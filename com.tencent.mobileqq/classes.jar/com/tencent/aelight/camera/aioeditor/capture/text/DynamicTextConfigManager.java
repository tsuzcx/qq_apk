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
  public static File a;
  private static String jdField_a_of_type_JavaLangString;
  public int a;
  private DynamicTextConfigManager.DynamicTextResDownloader jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextDynamicTextConfigManager$DynamicTextResDownloader = new DynamicTextConfigManager.DynamicTextResDownloader(this);
  private ArrayList<DynamicTextConfigManager.DynamicTextConfigBean> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private volatile boolean jdField_a_of_type_Boolean = false;
  private String jdField_b_of_type_JavaLangString;
  private volatile boolean jdField_b_of_type_Boolean = false;
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean = false;
  private String d;
  private String e;
  
  static
  {
    jdField_a_of_type_JavaIoFile = new File(QIMFileUtils.a(), "dynamic_text");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(jdField_a_of_type_JavaIoFile.getPath());
    localStringBuilder.append(File.separator);
    localStringBuilder.append("usable");
    localStringBuilder.append(File.separator);
    jdField_a_of_type_JavaLangString = localStringBuilder.toString();
  }
  
  public DynamicTextConfigManager()
  {
    this.jdField_a_of_type_Int = 120;
  }
  
  public static String a(@NonNull DynamicTextConfigManager.DynamicTextConfigBean.DynamicTextFontInfo paramDynamicTextFontInfo)
  {
    return new File(jdField_a_of_type_JavaIoFile, paramDynamicTextFontInfo.a()).getPath();
  }
  
  private ArrayList<DynamicTextConfigManager.DynamicTextConfigBean> a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    try
    {
      ArrayList localArrayList = new ArrayList();
      paramString = new JSONObject(paramString).getJSONArray("texts");
      int j = paramString.length();
      int i = 0;
      while (i < j)
      {
        DynamicTextConfigManager.DynamicTextConfigBean localDynamicTextConfigBean = DynamicTextConfigManager.DynamicTextConfigBean.convertFrom(paramString.getJSONObject(i));
        if (localDynamicTextConfigBean != null)
        {
          localDynamicTextConfigBean.iconDrawableId = DynamicTextBuilder.a(localDynamicTextConfigBean.text_id);
          localArrayList.add(localDynamicTextConfigBean);
        }
        i += 1;
      }
      return localArrayList;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  private void b(String paramString)
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
          this.jdField_b_of_type_JavaLangString = paramString.optString("default");
          this.jdField_c_of_type_JavaLangString = paramString.optString("local_slides");
          this.d = paramString.optString("local_singlePhoto");
          this.e = paramString.optString("local_singleVideo");
          SharedPreferences localSharedPreferences = BaseApplicationImpl.getContext().getSharedPreferences("dynamic_text_pre", 4);
          if (localSharedPreferences == null) {
            return;
          }
          if (paramString.optInt("is_text_guide_on") != 1) {
            break label233;
          }
          bool = true;
          this.jdField_c_of_type_Boolean = bool;
          localSharedPreferences.edit().putBoolean("dynamic_text_key_is_hint_on", this.jdField_c_of_type_Boolean).apply();
          localSharedPreferences.edit().putString("key_dynamic_text_hint_default", this.jdField_b_of_type_JavaLangString).apply();
          localSharedPreferences.edit().putString("key_dynamic_text_hint_local_slides", this.jdField_c_of_type_JavaLangString).apply();
          localSharedPreferences.edit().putString("key_dtext_hint_single_photo", this.d).apply();
          localSharedPreferences.edit().putString("key_dtext_hint_single_video", this.e).apply();
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
  
  public static boolean b()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(jdField_a_of_type_JavaIoFile);
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
  
  public DynamicTextConfigManager.DynamicTextConfigBean a(String arg1)
  {
    try
    {
      i = Integer.valueOf(???).intValue();
    }
    catch (Exception ???)
    {
      int i;
      label11:
      break label11;
    }
    i = 0;
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        DynamicTextConfigManager.DynamicTextConfigBean localDynamicTextConfigBean = (DynamicTextConfigManager.DynamicTextConfigBean)localIterator.next();
        if ((localDynamicTextConfigBean != null) && (localDynamicTextConfigBean.text_id == i)) {
          return localDynamicTextConfigBean;
        }
      }
      return null;
    }
  }
  
  public ArrayList<DynamicTextConfigManager.DynamicTextConfigBean> a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public void a() {}
  
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
      Object localObject2 = a(paramString);
      if ((localObject2 != null) && (!((ArrayList)localObject2).isEmpty())) {
        synchronized (this.jdField_a_of_type_JavaUtilArrayList)
        {
          this.jdField_a_of_type_JavaUtilArrayList.clear();
          this.jdField_a_of_type_JavaUtilArrayList.addAll((Collection)localObject2);
          b(paramString);
          this.jdField_a_of_type_Boolean = true;
          a().notifyObservers(CaptureConfigUpdateObserver.class, 3, false, null);
          ??? = ((ArrayList)localObject2).iterator();
          while (((Iterator)???).hasNext())
          {
            localObject2 = (DynamicTextConfigManager.DynamicTextConfigBean)((Iterator)???).next();
            if ((((DynamicTextConfigManager.DynamicTextConfigBean)localObject2).predownload == 1) && (!a((DynamicTextConfigManager.DynamicTextConfigBean)localObject2)) && (NetConnInfoCenter.isWifiConn())) {
              a((DynamicTextConfigManager.DynamicTextConfigBean)localObject2, null);
            }
          }
          QIMFileUtils.a(jdField_a_of_type_JavaIoFile, "dynamic_text_config.cfg", paramString);
          return;
        }
      }
    }
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_Boolean) || (this.jdField_b_of_type_Boolean);
  }
  
  public boolean a(DynamicTextConfigManager.DynamicTextConfigBean.DynamicTextFontInfo paramDynamicTextFontInfo)
  {
    if (paramDynamicTextFontInfo != null)
    {
      if (TextUtils.isEmpty(paramDynamicTextFontInfo.jdField_c_of_type_JavaLangString)) {
        return false;
      }
      if (TextUtils.isEmpty(paramDynamicTextFontInfo.jdField_a_of_type_JavaLangString)) {
        return true;
      }
      if (!new File(jdField_a_of_type_JavaIoFile, paramDynamicTextFontInfo.a()).exists()) {
        return false;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(jdField_a_of_type_JavaLangString);
      localStringBuilder.append(paramDynamicTextFontInfo.jdField_c_of_type_JavaLangString);
      if (new File(localStringBuilder.toString()).exists()) {
        return true;
      }
    }
    return false;
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
      if (!a((DynamicTextConfigManager.DynamicTextConfigBean.DynamicTextFontInfo)paramDynamicTextConfigBean.next())) {
        return false;
      }
    }
    return true;
  }
  
  public String b(DynamicTextConfigManager.DynamicTextConfigBean.DynamicTextFontInfo paramDynamicTextFontInfo)
  {
    if (paramDynamicTextFontInfo == null) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(jdField_a_of_type_JavaLangString);
    localStringBuilder.append(paramDynamicTextFontInfo.jdField_c_of_type_JavaLangString);
    localStringBuilder.append(File.separator);
    return localStringBuilder.toString();
  }
  
  public void b() {}
  
  public boolean b(DynamicTextConfigManager.DynamicTextConfigBean.DynamicTextFontInfo paramDynamicTextFontInfo)
  {
    try
    {
      ZipUtils.unZipFile(new File(jdField_a_of_type_JavaIoFile, paramDynamicTextFontInfo.a()), jdField_a_of_type_JavaLangString);
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
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.i("DText", 2, "initConfigListByFile start");
    }
    if ((!this.jdField_b_of_type_Boolean) && (!this.jdField_a_of_type_Boolean))
    {
      Object localObject1;
      if (b())
      {
        ??? = QIMFileUtils.a(jdField_a_of_type_JavaIoFile, "dynamic_text_config.cfg");
        localObject1 = ???;
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("initConfigListByFile dir=");
          ((StringBuilder)localObject1).append(jdField_a_of_type_JavaIoFile);
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
      synchronized (this.jdField_a_of_type_JavaUtilArrayList)
      {
        if ((!this.jdField_a_of_type_Boolean) && (!this.jdField_b_of_type_Boolean))
        {
          this.jdField_a_of_type_JavaUtilArrayList.clear();
          ArrayList localArrayList = a((String)localObject1);
          if ((localArrayList != null) && (!localArrayList.isEmpty())) {
            this.jdField_a_of_type_JavaUtilArrayList.addAll(localArrayList);
          }
          b((String)localObject1);
          this.jdField_b_of_type_Boolean = true;
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextConfigManager
 * JD-Core Version:    0.7.0.1
 */