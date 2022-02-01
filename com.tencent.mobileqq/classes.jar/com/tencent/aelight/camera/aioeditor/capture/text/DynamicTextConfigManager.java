package com.tencent.aelight.camera.aioeditor.capture.text;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.aelight.camera.aioeditor.capture.IQIMManager;
import com.tencent.aelight.camera.aioeditor.capture.music.CaptureConfigUpdateObserver;
import com.tencent.aelight.camera.aioeditor.capture.util.QIMFileUtils;
import com.tencent.biz.common.util.ZipUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class DynamicTextConfigManager
  extends IQIMManager
{
  public static File a = new File(QIMFileUtils.a(), "dynamic_text");
  private static String d;
  public int b = 120;
  private ArrayList<DynamicTextConfigManager.DynamicTextConfigBean> c = new ArrayList();
  private volatile boolean e = false;
  private volatile boolean f = false;
  private String g;
  private String h;
  private String i;
  private String j;
  private boolean k = false;
  private DynamicTextConfigManager.DynamicTextResDownloader l = new DynamicTextConfigManager.DynamicTextResDownloader(this);
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(a.getPath());
    localStringBuilder.append(File.separator);
    localStringBuilder.append("usable");
    localStringBuilder.append(File.separator);
    d = localStringBuilder.toString();
  }
  
  public static String a(@NonNull DynamicTextConfigManager.DynamicTextConfigBean.DynamicTextFontInfo paramDynamicTextFontInfo)
  {
    return new File(a, paramDynamicTextFontInfo.a()).getPath();
  }
  
  private ArrayList<DynamicTextConfigManager.DynamicTextConfigBean> c(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    try
    {
      ArrayList localArrayList = new ArrayList();
      paramString = new JSONObject(paramString).getJSONArray("texts");
      int n = paramString.length();
      int m = 0;
      while (m < n)
      {
        DynamicTextConfigManager.DynamicTextConfigBean localDynamicTextConfigBean = DynamicTextConfigManager.DynamicTextConfigBean.convertFrom(paramString.getJSONObject(m));
        if (localDynamicTextConfigBean != null)
        {
          localDynamicTextConfigBean.iconDrawableId = DynamicTextBuilder.c(localDynamicTextConfigBean.text_id);
          localArrayList.add(localDynamicTextConfigBean);
        }
        m += 1;
      }
      return localArrayList;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  private void d(String paramString)
  {
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString).getJSONObject("text_guide");
        if (paramString != null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("DText", 2, paramString.toString());
          }
          this.g = paramString.optString("default");
          this.h = paramString.optString("local_slides");
          this.i = paramString.optString("local_singlePhoto");
          this.j = paramString.optString("local_singleVideo");
          SharedPreferences localSharedPreferences = BaseApplicationImpl.getContext().getSharedPreferences("dynamic_text_pre", 4);
          if (localSharedPreferences == null) {
            return;
          }
          if (paramString.optInt("is_text_guide_on") != 1) {
            break label233;
          }
          bool = true;
          this.k = bool;
          localSharedPreferences.edit().putBoolean("dynamic_text_key_is_hint_on", this.k).apply();
          localSharedPreferences.edit().putString("key_dynamic_text_hint_default", this.g).apply();
          localSharedPreferences.edit().putString("key_dynamic_text_hint_local_slides", this.h).apply();
          localSharedPreferences.edit().putString("key_dtext_hint_single_photo", this.i).apply();
          localSharedPreferences.edit().putString("key_dtext_hint_single_video", this.j).apply();
          return;
        }
      }
      catch (Exception paramString)
      {
        QLog.d("DText", 1, paramString, new Object[0]);
      }
      return;
      label233:
      boolean bool = false;
    }
  }
  
  public static boolean f()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(a);
    localStringBuilder.append(File.separator);
    localStringBuilder.append("dynamic_text_config.cfg");
    boolean bool = new File(localStringBuilder.toString()).exists();
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("DynamicTextConfigManager isStickerConfigFileExist");
      localStringBuilder.append(bool);
      QLog.i("DText", 2, localStringBuilder.toString());
    }
    return bool;
  }
  
  public ArrayList<DynamicTextConfigManager.DynamicTextConfigBean> a()
  {
    return this.c;
  }
  
  public void a(DynamicTextConfigManager.DynamicTextConfigBean paramDynamicTextConfigBean, DynamicTextConfigManager.IDynamicTextResDownloadCallback paramIDynamicTextResDownloadCallback)
  {
    if (paramDynamicTextConfigBean != null)
    {
      if (paramDynamicTextConfigBean.fontInfos == null) {
        return;
      }
      ThreadManager.postImmediately(new DynamicTextConfigManager.1(this, paramDynamicTextConfigBean, paramIDynamicTextResDownloadCallback), null, true);
    }
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel())
    {
      ??? = new StringBuilder();
      ((StringBuilder)???).append("handleDynamicTextConfig config is: ");
      ((StringBuilder)???).append(paramString);
      QLog.i("DText", 2, ((StringBuilder)???).toString());
    }
    if ((!TextUtils.isEmpty(paramString)) && (!TextUtils.isEmpty(paramString.trim())))
    {
      Object localObject2 = c(paramString);
      if ((localObject2 != null) && (!((ArrayList)localObject2).isEmpty())) {
        synchronized (this.c)
        {
          this.c.clear();
          this.c.addAll((Collection)localObject2);
          d(paramString);
          this.e = true;
          g().notifyObservers(CaptureConfigUpdateObserver.class, 3, false, null);
          ??? = ((ArrayList)localObject2).iterator();
          while (((Iterator)???).hasNext())
          {
            localObject2 = (DynamicTextConfigManager.DynamicTextConfigBean)((Iterator)???).next();
            if ((((DynamicTextConfigManager.DynamicTextConfigBean)localObject2).predownload == 1) && (!a((DynamicTextConfigManager.DynamicTextConfigBean)localObject2)) && (NetConnInfoCenter.isWifiConn())) {
              a((DynamicTextConfigManager.DynamicTextConfigBean)localObject2, null);
            }
          }
          QIMFileUtils.a(a, "dynamic_text_config.cfg", paramString);
          return;
        }
      }
    }
  }
  
  public boolean a(DynamicTextConfigManager.DynamicTextConfigBean paramDynamicTextConfigBean)
  {
    if (paramDynamicTextConfigBean == null) {
      return false;
    }
    if (paramDynamicTextConfigBean.fontInfos == null) {
      return true;
    }
    paramDynamicTextConfigBean = paramDynamicTextConfigBean.fontInfos.iterator();
    while (paramDynamicTextConfigBean.hasNext()) {
      if (!b((DynamicTextConfigManager.DynamicTextConfigBean.DynamicTextFontInfo)paramDynamicTextConfigBean.next())) {
        return false;
      }
    }
    return true;
  }
  
  public DynamicTextConfigManager.DynamicTextConfigBean b(String arg1)
  {
    try
    {
      m = Integer.valueOf(???).intValue();
    }
    catch (Exception ???)
    {
      int m;
      label11:
      break label11;
    }
    m = 0;
    synchronized (this.c)
    {
      Iterator localIterator = this.c.iterator();
      while (localIterator.hasNext())
      {
        DynamicTextConfigManager.DynamicTextConfigBean localDynamicTextConfigBean = (DynamicTextConfigManager.DynamicTextConfigBean)localIterator.next();
        if ((localDynamicTextConfigBean != null) && (localDynamicTextConfigBean.text_id == m)) {
          return localDynamicTextConfigBean;
        }
      }
      return null;
    }
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.i("DText", 2, "initConfigListByFile start");
    }
    if ((!this.f) && (!this.e))
    {
      Object localObject1;
      if (f())
      {
        ??? = QIMFileUtils.a(a, "dynamic_text_config.cfg");
        localObject1 = ???;
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("initConfigListByFile dir=");
          ((StringBuilder)localObject1).append(a);
          ((StringBuilder)localObject1).append(" file=");
          ((StringBuilder)localObject1).append("dynamic_text_config.cfg");
          QLog.i("DText", 2, ((StringBuilder)localObject1).toString());
          localObject1 = ???;
        }
      }
      else
      {
        ??? = QIMFileUtils.a("dynamic_text_config.cfg");
        localObject1 = ???;
        if (QLog.isColorLevel())
        {
          QLog.i("DText", 2, "initConfigListByFile read from asset");
          localObject1 = ???;
        }
      }
      synchronized (this.c)
      {
        if ((!this.e) && (!this.f))
        {
          this.c.clear();
          ArrayList localArrayList = c((String)localObject1);
          if ((localArrayList != null) && (!localArrayList.isEmpty())) {
            this.c.addAll(localArrayList);
          }
          d((String)localObject1);
          this.f = true;
          if ((localArrayList != null) && (!localArrayList.isEmpty()))
          {
            localObject1 = localArrayList.iterator();
            while (((Iterator)localObject1).hasNext())
            {
              ??? = (DynamicTextConfigManager.DynamicTextConfigBean)((Iterator)localObject1).next();
              if ((((DynamicTextConfigManager.DynamicTextConfigBean)???).predownload == 1) && (!a((DynamicTextConfigManager.DynamicTextConfigBean)???)) && (NetConnInfoCenter.isWifiConn())) {
                a((DynamicTextConfigManager.DynamicTextConfigBean)???, null);
              }
            }
          }
          return;
        }
        return;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("DText", 2, "initConfigListByFile return by mIsInitByCache");
    }
  }
  
  public boolean b(DynamicTextConfigManager.DynamicTextConfigBean.DynamicTextFontInfo paramDynamicTextFontInfo)
  {
    if (paramDynamicTextFontInfo != null)
    {
      if (TextUtils.isEmpty(paramDynamicTextFontInfo.c)) {
        return false;
      }
      if (TextUtils.isEmpty(paramDynamicTextFontInfo.a)) {
        return true;
      }
      if (!new File(a, paramDynamicTextFontInfo.a()).exists()) {
        return false;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(d);
      localStringBuilder.append(paramDynamicTextFontInfo.c);
      if (new File(localStringBuilder.toString()).exists()) {
        return true;
      }
    }
    return false;
  }
  
  public void c() {}
  
  public boolean c(DynamicTextConfigManager.DynamicTextConfigBean.DynamicTextFontInfo paramDynamicTextFontInfo)
  {
    try
    {
      ZipUtils.unZipFile(new File(a, paramDynamicTextFontInfo.a()), d);
      return true;
    }
    catch (Exception paramDynamicTextFontInfo)
    {
      if (QLog.isColorLevel()) {
        paramDynamicTextFontInfo.printStackTrace();
      }
    }
    return false;
  }
  
  public String d(DynamicTextConfigManager.DynamicTextConfigBean.DynamicTextFontInfo paramDynamicTextFontInfo)
  {
    if (paramDynamicTextFontInfo == null) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(d);
    localStringBuilder.append(paramDynamicTextFontInfo.c);
    localStringBuilder.append(File.separator);
    return localStringBuilder.toString();
  }
  
  public void d() {}
  
  public boolean e()
  {
    return (this.e) || (this.f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextConfigManager
 * JD-Core Version:    0.7.0.1
 */