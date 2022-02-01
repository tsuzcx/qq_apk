package com.tencent.mobileqq.ark.api.module;

import android.text.TextUtils;
import com.tencent.ark.ark.Application;
import com.tencent.ark.ark.VariantWrapper;
import com.tencent.mobileqq.ark.api.IArkThreadManager;
import com.tencent.mobileqq.ark.module.ArkAppModuleBase;
import com.tencent.mobileqq.ark.module.ArkModuleMethod;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.mobileqq.music.SongInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

@KeepClassConstructor
public class ArkAppMusicModule
  extends ArkAppModuleBase
{
  protected static final ArrayList<WeakReference<ArkAppMusicModule>> a = new ArrayList();
  private static String k = "";
  private static ArkAppMusicModule.GlobalMusicCallback m;
  protected long b = 0L;
  protected String c;
  protected SongInfo d;
  private WeakReference<ArkAppMusicModule> l;
  
  public ArkAppMusicModule(ark.Application paramApplication, int paramInt)
  {
    super(paramApplication, paramInt);
    m = new ArkAppMusicModule.GlobalMusicCallback(this.f);
    this.l = new WeakReference(this);
    a.add(this.l);
  }
  
  protected static int b(int paramInt)
  {
    if (paramInt != 0)
    {
      switch (paramInt)
      {
      default: 
        return 5;
      case 5: 
      case 6: 
      case 7: 
        return 0;
      case 4: 
        return 3;
      case 3: 
        return 2;
      }
      return 1;
    }
    return 4;
  }
  
  public static String d()
  {
    if (TextUtils.isEmpty(k)) {
      k = QQPlayerService.a(1, "ark.music.module");
    }
    return k;
  }
  
  public void Destruct()
  {
    QQPlayerService.c(m);
    a.remove(this.l);
    this.l = null;
    super.Destruct();
  }
  
  public String GetTypeName()
  {
    return "QQMusic";
  }
  
  public boolean HasMethod(String paramString)
  {
    if (paramString.equals("Play")) {
      return true;
    }
    if (paramString.equals("Stop")) {
      return true;
    }
    if (paramString.equals("Pause")) {
      return true;
    }
    if (paramString.equals("Resume")) {
      return true;
    }
    if (paramString.equals("GetCurrentTime")) {
      return true;
    }
    if (paramString.equals("GetDuration")) {
      return true;
    }
    if (paramString.equals("GetState")) {
      return true;
    }
    if (paramString.equals("GetCurrentSong")) {
      return true;
    }
    if (paramString.equals("SetCallback")) {
      return true;
    }
    if (paramString.equals("AttachEvent")) {
      return true;
    }
    return paramString.equals("DetachEvent");
  }
  
  public boolean Invoke(String paramString, ark.VariantWrapper[] paramArrayOfVariantWrapper, ark.VariantWrapper paramVariantWrapper)
  {
    if ((QLog.isColorLevel()) && (!paramString.equals("GetCurrentTime")) && (!paramString.equals("GetDuration"))) {
      QLog.i("ark.music.module", 2, String.format("ArkAppMusicModule.invokeFunc.%s", new Object[] { paramString }));
    }
    if (paramString.equals("Play"))
    {
      QQPlayerService.a(null);
      a(paramArrayOfVariantWrapper);
      return true;
    }
    if (paramString.equals("Stop"))
    {
      ((IArkThreadManager)QRoute.api(IArkThreadManager.class)).postToMainThread(new ArkAppMusicModule.2(this));
      return true;
    }
    if (paramString.equals("Pause"))
    {
      ((IArkThreadManager)QRoute.api(IArkThreadManager.class)).postToMainThread(new ArkAppMusicModule.3(this));
      return true;
    }
    if (paramString.equals("Resume"))
    {
      ((IArkThreadManager)QRoute.api(IArkThreadManager.class)).postToMainThread(new ArkAppMusicModule.4(this));
      return true;
    }
    double d1;
    if (paramString.equals("GetCurrentTime"))
    {
      int i = QQPlayerService.c();
      double d2 = 0.0D;
      if (i != 2)
      {
        d1 = d2;
        if (QQPlayerService.c() != 3) {}
      }
      else
      {
        try
        {
          i = QQPlayerService.k();
          d1 = i;
          Double.isNaN(d1);
          d1 /= 1000.0D;
        }
        catch (IllegalStateException paramString)
        {
          QLog.d("ark.music.module", 2, new Object[] { "ArkAppMusicModule.invokeFunc.getCurrentPlayPosition.error", paramString.getMessage() });
          d1 = d2;
        }
      }
      paramVariantWrapper.SetDouble(d1);
      return true;
    }
    if (paramString.equals("GetDuration"))
    {
      d1 = QQPlayerService.i();
      Double.isNaN(d1);
      paramVariantWrapper.SetDouble(d1 / 1000.0D);
      return true;
    }
    if (paramString.equals("GetState"))
    {
      paramVariantWrapper.SetInt(b(QQPlayerService.c()));
      return true;
    }
    if (paramString.equals("GetCurrentSong"))
    {
      a(paramArrayOfVariantWrapper[0], QQPlayerService.g());
      return true;
    }
    if (paramString.equals("SetCallback"))
    {
      paramString = a(this.b);
      if (paramString != null) {
        paramString.Reset();
      }
      paramString = paramArrayOfVariantWrapper[0];
      if ((paramString != null) && (paramString.IsFunction()))
      {
        this.b = a(paramString.Copy());
        QQPlayerService.b(m);
        QQPlayerService.a(null);
        return true;
      }
      this.b = 0L;
      return true;
    }
    if (paramString.equals("AttachEvent"))
    {
      paramString = paramArrayOfVariantWrapper[0];
      if ((paramString != null) && (paramString.IsString()))
      {
        if (!"State".equals(paramString.GetString())) {
          return true;
        }
        paramString = a(this.b);
        if (paramString != null) {
          paramString.Reset();
        }
        paramString = paramArrayOfVariantWrapper[1];
        if ((paramString != null) && (paramString.IsFunction()))
        {
          this.b = a(paramString.Copy());
          QQPlayerService.a(null);
          return true;
        }
        this.b = 0L;
      }
      return true;
    }
    if (paramString.equals("DetachEvent"))
    {
      paramString = paramArrayOfVariantWrapper[0];
      if ((paramString != null) && (paramString.IsString()))
      {
        if (!"State".equals(paramString.GetString())) {
          return true;
        }
        paramString = a(this.b);
        if (paramString != null) {
          paramString.Reset();
        }
      }
      return true;
    }
    return false;
  }
  
  public void a(int paramInt)
  {
    long l1 = this.b;
    if (l1 == 0L)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ark.music.module", 2, "ArkAppMusicModule.callback.invalid");
      }
      return;
    }
    ark.VariantWrapper localVariantWrapper = b(l1);
    SongInfo localSongInfo2 = QQPlayerService.g();
    SongInfo localSongInfo1 = localSongInfo2;
    if (localSongInfo2 == null) {
      localSongInfo1 = this.d;
    }
    a(localVariantWrapper, paramInt, localSongInfo1);
    if (paramInt == 4) {
      this.d = null;
    }
  }
  
  public void a(ark.VariantWrapper paramVariantWrapper, int paramInt, SongInfo paramSongInfo)
  {
    if ((paramVariantWrapper != null) && (paramVariantWrapper.IsFunction()) && (paramSongInfo != null))
    {
      paramInt = b(paramInt);
      if (paramInt == 5)
      {
        if (QLog.isColorLevel()) {
          QLog.i("ark.music.module", 2, "ArkAppMusicModule.callback.state.invalid");
        }
        return;
      }
      ark.VariantWrapper localVariantWrapper1 = paramVariantWrapper.Create();
      if (QLog.isColorLevel()) {
        QLog.i("ark.music.module", 2, String.format(Locale.CHINA, "ArkAppMusicModule.callback.state: %d", new Object[] { Integer.valueOf(paramInt) }));
      }
      localVariantWrapper1.SetInt(paramInt);
      ark.VariantWrapper localVariantWrapper2 = paramVariantWrapper.Create();
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("url", paramSongInfo.d);
        localJSONObject.put("title", paramSongInfo.e);
        localJSONObject.put("singer", paramSongInfo.j);
        localJSONObject.put("id", String.format(Locale.CHINA, "%d", new Object[] { Long.valueOf(paramSongInfo.a) }));
      }
      catch (JSONException paramSongInfo)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ark.music.module", 2, new Object[] { "ArkAppMusicModule.doCallback.1.json.", paramSongInfo.getMessage() });
        }
      }
      localVariantWrapper2.SetTableAsJsonString(localJSONObject.toString());
      paramSongInfo = paramVariantWrapper.Create();
      paramVariantWrapper.InvokeDefault(new ark.VariantWrapper[] { localVariantWrapper1, localVariantWrapper2 }, paramSongInfo);
      localVariantWrapper2.Reset();
      localVariantWrapper1.Reset();
      paramSongInfo.Reset();
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("ark.music.module", 2, "ArkAppMusicModule.callback.invalid");
    }
  }
  
  public void a(ark.VariantWrapper paramVariantWrapper, SongInfo paramSongInfo)
  {
    if (paramVariantWrapper != null)
    {
      if (!paramVariantWrapper.IsFunction()) {
        return;
      }
      ark.VariantWrapper localVariantWrapper1 = paramVariantWrapper.Create();
      ark.VariantWrapper localVariantWrapper2 = paramVariantWrapper.Create();
      if (paramSongInfo != null)
      {
        JSONObject localJSONObject = new JSONObject();
        try
        {
          localJSONObject.put("url", paramSongInfo.d);
          localJSONObject.put("title", paramSongInfo.e);
          localJSONObject.put("singer", paramSongInfo.j);
          localJSONObject.put("id", String.format(Locale.CHINA, "%d", new Object[] { Long.valueOf(paramSongInfo.a) }));
        }
        catch (JSONException paramSongInfo)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ark.music.module", 2, new Object[] { "ArkAppMusicModule.doCallback.2.json.", paramSongInfo.getMessage() });
          }
        }
        localVariantWrapper2.SetTableAsJsonString(localJSONObject.toString());
      }
      paramVariantWrapper.InvokeDefault(new ark.VariantWrapper[] { localVariantWrapper2 }, localVariantWrapper1);
      localVariantWrapper2.Reset();
      localVariantWrapper1.Reset();
    }
  }
  
  public void a(SongInfo paramSongInfo) {}
  
  protected void a(ark.VariantWrapper[] paramArrayOfVariantWrapper)
  {
    if (paramArrayOfVariantWrapper != null)
    {
      if (paramArrayOfVariantWrapper.length < 2) {
        return;
      }
      SongInfo localSongInfo = new SongInfo();
      localSongInfo.m = 4;
      localSongInfo.d = paramArrayOfVariantWrapper[0].GetString();
      try
      {
        paramArrayOfVariantWrapper = new JSONObject(paramArrayOfVariantWrapper[1].GetTableAsJsonString());
        localSongInfo.h = paramArrayOfVariantWrapper.optString("url");
        localSongInfo.e = paramArrayOfVariantWrapper.optString("title");
        localSongInfo.j = paramArrayOfVariantWrapper.optString("singer");
        localSongInfo.a = paramArrayOfVariantWrapper.optLong("id");
      }
      catch (JSONException paramArrayOfVariantWrapper)
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("QQMusic.Play parameter error: ");
          localStringBuilder.append(paramArrayOfVariantWrapper.getMessage());
          QLog.d("ark.music.module", 2, localStringBuilder.toString());
        }
      }
      this.c = localSongInfo.d;
      this.d = localSongInfo;
      ((IArkThreadManager)QRoute.api(IArkThreadManager.class)).postToMainThread(new ArkAppMusicModule.1(this, localSongInfo));
    }
  }
  
  protected ArkModuleMethod[] a()
  {
    return null;
  }
  
  public boolean b()
  {
    return false;
  }
  
  public boolean c()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.api.module.ArkAppMusicModule
 * JD-Core Version:    0.7.0.1
 */