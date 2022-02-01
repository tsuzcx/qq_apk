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
  private static ArkAppMusicModule.GlobalMusicCallback jdField_a_of_type_ComTencentMobileqqArkApiModuleArkAppMusicModule$GlobalMusicCallback;
  protected static final ArrayList<WeakReference<ArkAppMusicModule>> a;
  private static String e = "";
  protected long a;
  protected SongInfo a;
  protected String a;
  private WeakReference<ArkAppMusicModule> jdField_a_of_type_JavaLangRefWeakReference;
  
  static
  {
    jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  public ArkAppMusicModule(ark.Application paramApplication, int paramInt)
  {
    super(paramApplication, paramInt);
    this.jdField_a_of_type_Long = 0L;
    jdField_a_of_type_ComTencentMobileqqArkApiModuleArkAppMusicModule$GlobalMusicCallback = new ArkAppMusicModule.GlobalMusicCallback(this.jdField_b_of_type_JavaLangString);
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(this);
    jdField_a_of_type_JavaUtilArrayList.add(this.jdField_a_of_type_JavaLangRefWeakReference);
  }
  
  protected static int a(int paramInt)
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
  
  public static String a()
  {
    if (TextUtils.isEmpty(e)) {
      e = QQPlayerService.a(1, "ark.music.module");
    }
    return e;
  }
  
  public void Destruct()
  {
    QQPlayerService.c(jdField_a_of_type_ComTencentMobileqqArkApiModuleArkAppMusicModule$GlobalMusicCallback);
    jdField_a_of_type_JavaUtilArrayList.remove(this.jdField_a_of_type_JavaLangRefWeakReference);
    this.jdField_a_of_type_JavaLangRefWeakReference = null;
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
      int i = QQPlayerService.a();
      double d2 = 0.0D;
      if (i != 2)
      {
        d1 = d2;
        if (QQPlayerService.a() != 3) {}
      }
      else
      {
        try
        {
          i = QQPlayerService.f();
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
      d1 = QQPlayerService.d();
      Double.isNaN(d1);
      paramVariantWrapper.SetDouble(d1 / 1000.0D);
      return true;
    }
    if (paramString.equals("GetState"))
    {
      paramVariantWrapper.SetInt(a(QQPlayerService.a()));
      return true;
    }
    if (paramString.equals("GetCurrentSong"))
    {
      a(paramArrayOfVariantWrapper[0], QQPlayerService.b());
      return true;
    }
    if (paramString.equals("SetCallback"))
    {
      paramString = a(this.jdField_a_of_type_Long);
      if (paramString != null) {
        paramString.Reset();
      }
      paramString = paramArrayOfVariantWrapper[0];
      if ((paramString != null) && (paramString.IsFunction()))
      {
        this.jdField_a_of_type_Long = a(paramString.Copy());
        QQPlayerService.b(jdField_a_of_type_ComTencentMobileqqArkApiModuleArkAppMusicModule$GlobalMusicCallback);
        QQPlayerService.a(null);
        return true;
      }
      this.jdField_a_of_type_Long = 0L;
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
        paramString = a(this.jdField_a_of_type_Long);
        if (paramString != null) {
          paramString.Reset();
        }
        paramString = paramArrayOfVariantWrapper[1];
        if ((paramString != null) && (paramString.IsFunction()))
        {
          this.jdField_a_of_type_Long = a(paramString.Copy());
          QQPlayerService.a(null);
          return true;
        }
        this.jdField_a_of_type_Long = 0L;
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
        paramString = a(this.jdField_a_of_type_Long);
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
    long l = this.jdField_a_of_type_Long;
    if (l == 0L)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ark.music.module", 2, "ArkAppMusicModule.callback.invalid");
      }
      return;
    }
    ark.VariantWrapper localVariantWrapper = b(l);
    SongInfo localSongInfo2 = QQPlayerService.b();
    SongInfo localSongInfo1 = localSongInfo2;
    if (localSongInfo2 == null) {
      localSongInfo1 = this.jdField_a_of_type_ComTencentMobileqqMusicSongInfo;
    }
    a(localVariantWrapper, paramInt, localSongInfo1);
    if (paramInt == 4) {
      this.jdField_a_of_type_ComTencentMobileqqMusicSongInfo = null;
    }
  }
  
  public void a(ark.VariantWrapper paramVariantWrapper, int paramInt, SongInfo paramSongInfo)
  {
    if ((paramVariantWrapper != null) && (paramVariantWrapper.IsFunction()) && (paramSongInfo != null))
    {
      paramInt = a(paramInt);
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
        localJSONObject.put("url", paramSongInfo.jdField_b_of_type_JavaLangString);
        localJSONObject.put("title", paramSongInfo.c);
        localJSONObject.put("singer", paramSongInfo.h);
        localJSONObject.put("id", String.format(Locale.CHINA, "%d", new Object[] { Long.valueOf(paramSongInfo.jdField_a_of_type_Long) }));
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
          localJSONObject.put("url", paramSongInfo.jdField_b_of_type_JavaLangString);
          localJSONObject.put("title", paramSongInfo.c);
          localJSONObject.put("singer", paramSongInfo.h);
          localJSONObject.put("id", String.format(Locale.CHINA, "%d", new Object[] { Long.valueOf(paramSongInfo.jdField_a_of_type_Long) }));
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
      localSongInfo.jdField_b_of_type_Int = 4;
      localSongInfo.jdField_b_of_type_JavaLangString = paramArrayOfVariantWrapper[0].GetString();
      try
      {
        paramArrayOfVariantWrapper = new JSONObject(paramArrayOfVariantWrapper[1].GetTableAsJsonString());
        localSongInfo.f = paramArrayOfVariantWrapper.optString("url");
        localSongInfo.c = paramArrayOfVariantWrapper.optString("title");
        localSongInfo.h = paramArrayOfVariantWrapper.optString("singer");
        localSongInfo.jdField_a_of_type_Long = paramArrayOfVariantWrapper.optLong("id");
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
      this.jdField_a_of_type_JavaLangString = localSongInfo.jdField_b_of_type_JavaLangString;
      this.jdField_a_of_type_ComTencentMobileqqMusicSongInfo = localSongInfo;
      ((IArkThreadManager)QRoute.api(IArkThreadManager.class)).postToMainThread(new ArkAppMusicModule.1(this, localSongInfo));
    }
  }
  
  public boolean a()
  {
    return false;
  }
  
  protected ArkModuleMethod[] a()
  {
    return null;
  }
  
  public boolean b()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ark.api.module.ArkAppMusicModule
 * JD-Core Version:    0.7.0.1
 */