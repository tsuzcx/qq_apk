package com.tencent.mobileqq.activity.richmedia.subtitles;

import android.os.Looper;
import android.text.TextUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.richmedia.capture.data.SubtitleItem;
import com.tencent.mobileqq.richmedia.capture.data.SubtitleItem.FontItem;
import com.tencent.mobileqq.richmedia.capture.util.CaptureUtil;
import com.tencent.mobileqq.shortvideo.mediadevice.CodecParam;
import com.tencent.mobileqq.transfile.NetworkCenter;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import xtc;
import xtd;
import xte;
import xtf;
import xtg;

public class SubtitleDataManager
  extends RDBaseDataManager
{
  private static SubtitleDataManager a;
  public WeakReference a;
  public final ArrayList a;
  public final ArrayList b = new ArrayList();
  public int c;
  
  private SubtitleDataManager()
  {
    super(231, true, false);
    this.jdField_a_of_type_JavaLangRefWeakReference = null;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  public static final SubtitleDataManager a()
  {
    try
    {
      if (jdField_a_of_type_ComTencentMobileqqActivityRichmediaSubtitlesSubtitleDataManager == null) {
        jdField_a_of_type_ComTencentMobileqqActivityRichmediaSubtitlesSubtitleDataManager = new SubtitleDataManager();
      }
      return jdField_a_of_type_ComTencentMobileqqActivityRichmediaSubtitlesSubtitleDataManager;
    }
    finally {}
  }
  
  private String a()
  {
    return RDConfigServletProxy.a(231, null) + File.separator + "fonts" + File.separator;
  }
  
  private String a(SubtitleItem.FontItem paramFontItem)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      return null;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      SubtitleItem localSubtitleItem = (SubtitleItem)localIterator.next();
      if (localSubtitleItem.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataSubtitleItem$FontItem == paramFontItem) {
        return localSubtitleItem.jdField_c_of_type_JavaLangString;
      }
    }
    return null;
  }
  
  private void a(ArrayList paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() < 2)) {
      return;
    }
    Collections.sort(paramArrayList, new xtg(this));
  }
  
  private boolean a(SubtitleItem.FontItem paramFontItem)
  {
    if (paramFontItem == null) {
      return false;
    }
    String str = a() + paramFontItem.jdField_a_of_type_JavaLangString;
    if (FileUtils.a(str))
    {
      paramFontItem.f = str;
      paramFontItem.jdField_d_of_type_Int = 2;
      return true;
    }
    paramFontItem.f = null;
    paramFontItem.jdField_d_of_type_Int = 0;
    return false;
  }
  
  private boolean a(String paramString)
  {
    boolean bool3 = false;
    bool1 = false;
    bool2 = false;
    if (TextUtils.isEmpty(paramString)) {
      return bool2;
    }
    for (bool2 = bool1;; bool2 = false)
    {
      try
      {
        localJSONObject = new JSONObject(paramString);
        bool2 = bool1;
        bool1 = b(localJSONObject);
      }
      catch (JSONException localJSONException1)
      {
        for (;;)
        {
          try
          {
            bool2 = a(localJSONObject);
            if ((bool2) && (bool1)) {
              bool2 = true;
            }
          }
          catch (JSONException localJSONException2)
          {
            JSONObject localJSONObject;
            boolean bool4;
            bool2 = bool1;
            continue;
          }
          try
          {
            bool4 = c(localJSONObject);
            bool1 = bool3;
            if (bool4)
            {
              bool1 = bool3;
              if (bool2) {
                bool1 = true;
              }
            }
            bool2 = bool1;
            if (!bool1) {
              break;
            }
            bool2 = bool1;
            d();
            return bool1;
          }
          catch (JSONException localJSONException3) {}
        }
        localJSONException1 = localJSONException1;
      }
      localJSONException1.printStackTrace();
      QLog.e("SubtitleDataManager", 2, "parseConfig|parse failed.context = " + paramString);
      return bool2;
    }
  }
  
  private boolean a(String paramString, SubtitleItem.FontItem paramFontItem)
  {
    paramString = a(paramString, paramFontItem.jdField_e_of_type_JavaLangString);
    if (!TextUtils.isEmpty(paramString))
    {
      FileUtils.d(paramString, a() + paramFontItem.jdField_a_of_type_JavaLangString);
      a(paramFontItem);
      ThreadManager.getUIHandler().post(new xtf(this, paramFontItem));
      return true;
    }
    return false;
  }
  
  private boolean a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return false;
    }
    try
    {
      paramJSONObject = paramJSONObject.getJSONArray("font");
      int i = 0;
      while (i < paramJSONObject.length())
      {
        JSONObject localJSONObject = paramJSONObject.getJSONObject(i);
        SubtitleItem.FontItem localFontItem = new SubtitleItem.FontItem();
        localFontItem.jdField_a_of_type_Int = Integer.valueOf(localJSONObject.getInt("id")).intValue();
        localFontItem.jdField_a_of_type_JavaLangString = localJSONObject.getString("title");
        localFontItem.jdField_b_of_type_JavaLangString = localJSONObject.getString("name");
        localFontItem.jdField_c_of_type_JavaLangString = localJSONObject.getString("resurl");
        localFontItem.jdField_d_of_type_JavaLangString = localJSONObject.getString("md5");
        localFontItem.jdField_e_of_type_JavaLangString = localJSONObject.optString("md5_ttf");
        localFontItem.jdField_b_of_type_Int = Integer.valueOf(localJSONObject.getInt("predown")).intValue();
        this.b.add(localFontItem);
        i += 1;
      }
      return true;
    }
    catch (JSONException paramJSONObject)
    {
      paramJSONObject.printStackTrace();
      QLog.e("SubtitleDataManager", 2, "parseConfig|parse fonts exception:" + paramJSONObject);
    }
    return false;
  }
  
  private boolean b(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return false;
    }
    try
    {
      b("on".equalsIgnoreCase(paramJSONObject.getString("switch")));
      return true;
    }
    catch (JSONException paramJSONObject)
    {
      paramJSONObject.printStackTrace();
      QLog.e("SubtitleDataManager", 2, "parseConfig|parse switch exception " + paramJSONObject);
    }
    return false;
  }
  
  private boolean c(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return false;
    }
    for (;;)
    {
      int i;
      SubtitleItem localSubtitleItem;
      try
      {
        paramJSONObject = paramJSONObject.getJSONArray("content");
        i = 0;
        if (i >= paramJSONObject.length()) {
          break label285;
        }
        JSONObject localJSONObject = paramJSONObject.getJSONObject(i);
        localSubtitleItem = new SubtitleItem();
        localSubtitleItem.jdField_a_of_type_Int = Integer.valueOf(localJSONObject.getInt("id")).intValue();
        if (!AnimDrawerFactory.a(localSubtitleItem.jdField_a_of_type_Int)) {
          break label295;
        }
        localSubtitleItem.jdField_b_of_type_JavaLangString = localJSONObject.getString("name");
        int j = localJSONObject.getInt("fontid");
        Iterator localIterator = this.b.iterator();
        if (localIterator.hasNext())
        {
          SubtitleItem.FontItem localFontItem = (SubtitleItem.FontItem)localIterator.next();
          if (localFontItem.jdField_a_of_type_Int != j) {
            continue;
          }
          localSubtitleItem.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataSubtitleItem$FontItem = localFontItem;
        }
        localSubtitleItem.jdField_c_of_type_JavaLangString = localJSONObject.optString("avfontfolder");
        localSubtitleItem.jdField_b_of_type_Int = localJSONObject.optInt("position");
        localSubtitleItem.jdField_a_of_type_Boolean = false;
        j = localJSONObject.getInt("app");
        if ((j == 1) || (j == 3))
        {
          if (localJSONObject.getInt("show") == 1) {
            localSubtitleItem.jdField_a_of_type_Boolean = true;
          }
        }
        else
        {
          localSubtitleItem.jdField_a_of_type_JavaLangString = localJSONObject.getString("iconurl");
          if (!localSubtitleItem.jdField_a_of_type_Boolean) {
            break label295;
          }
          this.jdField_a_of_type_JavaUtilArrayList.add(localSubtitleItem);
        }
      }
      catch (JSONException paramJSONObject)
      {
        paramJSONObject.printStackTrace();
        QLog.e("SubtitleDataManager", 2, "parseConfig|parse subtitleitem exception:" + paramJSONObject);
        return false;
      }
      localSubtitleItem.jdField_a_of_type_Boolean = false;
      continue;
      label285:
      a(this.jdField_a_of_type_JavaUtilArrayList);
      return true;
      label295:
      i += 1;
    }
  }
  
  private void d()
  {
    int i = NetworkCenter.a().a();
    if (QLog.isColorLevel()) {
      QLog.d("SubtitleDataManager", 2, "checkFonts, netType:" + i);
    }
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
    {
      SubtitleItem.FontItem localFontItem = (SubtitleItem.FontItem)localIterator.next();
      a(localFontItem);
      if ((i == 1) && (localFontItem.jdField_b_of_type_Int == 1))
      {
        if (QLog.isColorLevel()) {
          QLog.d("SubtitleDataManager", 2, "predown font:" + localFontItem.jdField_b_of_type_JavaLangString);
        }
        a(a(localFontItem), localFontItem);
      }
    }
  }
  
  public String a(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      paramString1 = null;
    }
    String str;
    do
    {
      return paramString1;
      paramString1 = AppConstants.aJ + "qav" + File.separator + "effect" + File.separator + "216" + File.separator + paramString1 + File.separator + "font.ttf";
      str = FileUtils.b(paramString1);
    } while ((!TextUtils.isEmpty(str)) && (str.equalsIgnoreCase(paramString2)));
    return null;
  }
  
  public ArrayList a()
  {
    try
    {
      if (a() != 2) {
        return null;
      }
      ArrayList localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
      return localArrayList;
    }
    finally {}
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.b.clear();
  }
  
  public void a(int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SubtitleDataManager", 2, "onDownloadResult: nID:" + paramInt1 + " nResult:" + paramInt2 + " file:" + paramString1 + " unzipPath:" + paramString2);
    }
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
    {
      paramString2 = (SubtitleItem.FontItem)localIterator.next();
      if (paramString2.jdField_c_of_type_Int == paramInt1)
      {
        if (paramInt2 != 0)
        {
          paramString2.jdField_d_of_type_Int = 0;
          paramString2.jdField_e_of_type_Int = 0;
          paramString2.jdField_c_of_type_Int = -1;
        }
        while (this.jdField_a_of_type_JavaLangRefWeakReference != null)
        {
          paramString1 = (SubtitleDataManager.SubtitleDataManagerListener)this.jdField_a_of_type_JavaLangRefWeakReference.get();
          localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
          while (localIterator.hasNext())
          {
            SubtitleItem localSubtitleItem = (SubtitleItem)localIterator.next();
            if ((localSubtitleItem.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataSubtitleItem$FontItem == paramString2) && (localSubtitleItem.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataSubtitleItem$FontItem != null)) {
              paramString1.a(localSubtitleItem.jdField_a_of_type_Int, paramInt2, localSubtitleItem.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataSubtitleItem$FontItem.f);
            }
          }
          a(paramString2);
          ThreadManager.post(new xtd(this, paramString1), 5, null, true);
        }
      }
    }
  }
  
  public void a(SubtitleDataManager.SubtitleDataManagerListener paramSubtitleDataManagerListener)
  {
    if (paramSubtitleDataManagerListener == null)
    {
      this.jdField_a_of_type_JavaLangRefWeakReference = null;
      return;
    }
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramSubtitleDataManagerListener);
  }
  
  public void a(String paramString, SubtitleItem.FontItem paramFontItem)
  {
    if (paramFontItem == null) {}
    do
    {
      do
      {
        return;
      } while ((paramFontItem.jdField_d_of_type_Int == 1) || (paramFontItem.jdField_d_of_type_Int == 2));
      paramFontItem.jdField_d_of_type_Int = 1;
      if (Looper.getMainLooper() == Looper.myLooper())
      {
        ThreadManager.post(new xte(this, paramString, paramFontItem), 5, null, true);
        return;
      }
    } while (a(paramString, paramFontItem));
    paramFontItem.jdField_c_of_type_Int = a(paramFontItem.jdField_c_of_type_JavaLangString, a() + paramFontItem.jdField_d_of_type_JavaLangString, paramFontItem.jdField_d_of_type_JavaLangString, a());
  }
  
  public boolean a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SubtitleDataManager", 2, "check switch begin");
    }
    boolean bool1 = CaptureUtil.a();
    boolean bool2 = super.a();
    if (QLog.isColorLevel()) {
      QLog.d("SubtitleDataManager", 2, "check switch end:" + bool1 + "-" + bool2);
    }
    return (bool1) && (bool2);
  }
  
  public boolean a(int paramInt1, int paramInt2, String paramString)
  {
    return a(paramString);
  }
  
  public void b()
  {
    this.jdField_c_of_type_Int = 0;
    AudioTranslator.a().a(CodecParam.q, CodecParam.o, CodecParam.p);
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SubtitleDataManager", 2, "onConfigEnd: nVersion:" + paramInt1 + " nTaskCount:" + paramInt2);
    }
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null) {
      ThreadManager.getUIHandler().post(new xtc(this));
    }
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SubtitleDataManager", 2, " onUninit:" + this.jdField_c_of_type_Int);
    }
    this.jdField_c_of_type_Int = 0;
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_JavaLangRefWeakReference = null;
    AudioTranslator.a().a();
  }
  
  public void c(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SubtitleDataManager", 2, "onDownloadProgress: nID:" + paramInt1 + " progress:" + paramInt2);
    }
    Object localObject = this.b.iterator();
    SubtitleItem.FontItem localFontItem;
    while (((Iterator)localObject).hasNext())
    {
      localFontItem = (SubtitleItem.FontItem)((Iterator)localObject).next();
      if (localFontItem.jdField_c_of_type_Int == paramInt1) {
        localFontItem.jdField_e_of_type_Int = paramInt2;
      }
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_JavaLangRefWeakReference != null) && (localFontItem != null))
      {
        localObject = (SubtitleDataManager.SubtitleDataManagerListener)this.jdField_a_of_type_JavaLangRefWeakReference.get();
        Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        while (localIterator.hasNext())
        {
          SubtitleItem localSubtitleItem = (SubtitleItem)localIterator.next();
          if (localSubtitleItem.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataSubtitleItem$FontItem == localFontItem) {
            ((SubtitleDataManager.SubtitleDataManagerListener)localObject).a(localSubtitleItem.jdField_a_of_type_Int, localSubtitleItem.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataSubtitleItem$FontItem.jdField_e_of_type_Int);
          }
        }
      }
      return;
      localFontItem = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.subtitles.SubtitleDataManager
 * JD-Core Version:    0.7.0.1
 */