package com.tencent.biz.videostory.entrancewidget;

import android.text.TextUtils;
import com.tencent.biz.videostory.config.VSConfigManager;
import com.tencent.biz.videostory.config.processor.VSEntranceStyleBean;
import com.tencent.biz.videostory.config.processor.VSEntranceWidgetBean;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.util.QZLog;
import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

public class VSEntranceWidgetHelper
{
  private static volatile VSEntranceWidgetHelper jdField_a_of_type_ComTencentBizVideostoryEntrancewidgetVSEntranceWidgetHelper;
  private VSEntranceStyleBean jdField_a_of_type_ComTencentBizVideostoryConfigProcessorVSEntranceStyleBean;
  private VSEntranceWidgetBean jdField_a_of_type_ComTencentBizVideostoryConfigProcessorVSEntranceWidgetBean;
  private HashMap<String, VSEntranceWidgetHelper.StyleConfig> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private VSEntranceStyleBean jdField_b_of_type_ComTencentBizVideostoryConfigProcessorVSEntranceStyleBean;
  private VSEntranceWidgetBean jdField_b_of_type_ComTencentBizVideostoryConfigProcessorVSEntranceWidgetBean;
  private HashMap<String, VSEntranceWidgetHelper.WidgetConfig> jdField_b_of_type_JavaUtilHashMap = new HashMap();
  
  public static VSEntranceWidgetHelper a()
  {
    try
    {
      if (jdField_a_of_type_ComTencentBizVideostoryEntrancewidgetVSEntranceWidgetHelper == null) {
        try
        {
          if (jdField_a_of_type_ComTencentBizVideostoryEntrancewidgetVSEntranceWidgetHelper == null) {
            jdField_a_of_type_ComTencentBizVideostoryEntrancewidgetVSEntranceWidgetHelper = new VSEntranceWidgetHelper();
          }
        }
        finally {}
      }
      VSEntranceWidgetHelper localVSEntranceWidgetHelper = jdField_a_of_type_ComTencentBizVideostoryEntrancewidgetVSEntranceWidgetHelper;
      return localVSEntranceWidgetHelper;
    }
    finally {}
  }
  
  private void a(VSEntranceStyleBean paramVSEntranceStyleBean)
  {
    QLog.d("Q.videostory.config.VSEntranceWidgetHelper", 1, "handleStyleConfig()");
    if (paramVSEntranceStyleBean != null)
    {
      String str = paramVSEntranceStyleBean.a();
      if (TextUtils.isEmpty(str))
      {
        QLog.e("Q.videostory.config.VSEntranceWidgetHelper", 1, "handleStyleConfig error!");
        return;
      }
      if (VSEntranceWidgetDownLoadHelper.a().a(str))
      {
        a(paramVSEntranceStyleBean, VSEntranceWidgetDownLoadHelper.a().b(str));
        return;
      }
      VSEntranceWidgetDownLoadHelper.a().a(paramVSEntranceStyleBean.a(), new VSEntranceWidgetHelper.1(this, paramVSEntranceStyleBean, str));
    }
  }
  
  private void a(VSEntranceStyleBean paramVSEntranceStyleBean, String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("initStyleConfigCache() path:");
    ((StringBuilder)localObject).append(paramString);
    QLog.d("Q.videostory.config.VSEntranceWidgetHelper", 1, ((StringBuilder)localObject).toString());
    localObject = paramVSEntranceStyleBean.a().keys();
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      VSEntranceWidgetHelper.StyleConfig localStyleConfig = new VSEntranceWidgetHelper.StyleConfig(this, str, paramVSEntranceStyleBean.a().optJSONObject(str));
      localStyleConfig.a(paramString);
      this.jdField_a_of_type_JavaUtilHashMap.put(str, localStyleConfig);
    }
  }
  
  private void a(VSEntranceWidgetBean paramVSEntranceWidgetBean)
  {
    QLog.d("Q.videostory.config.VSEntranceWidgetHelper", 1, "handleWidgetConfig()");
    if (paramVSEntranceWidgetBean != null)
    {
      String str = paramVSEntranceWidgetBean.a();
      if (TextUtils.isEmpty(str))
      {
        QLog.e("Q.videostory.config.VSEntranceWidgetHelper", 1, "handleWidgetConfig error!");
        return;
      }
      if (VSEntranceWidgetDownLoadHelper.a().a(str))
      {
        a(paramVSEntranceWidgetBean, VSEntranceWidgetDownLoadHelper.a().b(str));
        return;
      }
      VSEntranceWidgetDownLoadHelper.a().a(paramVSEntranceWidgetBean.a(), new VSEntranceWidgetHelper.2(this, paramVSEntranceWidgetBean, str));
    }
  }
  
  private void a(VSEntranceWidgetBean paramVSEntranceWidgetBean, String paramString)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("initWidgetConfigCache() path:");
    ((StringBuilder)localObject1).append(paramString);
    QLog.d("Q.videostory.config.VSEntranceWidgetHelper", 1, ((StringBuilder)localObject1).toString());
    localObject1 = new File(paramString);
    if (((File)localObject1).exists())
    {
      Object localObject2 = Arrays.asList(((File)localObject1).list());
      if (((List)localObject2).contains("widget@2x.png"))
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(paramString);
        ((StringBuilder)localObject1).append("/");
        ((StringBuilder)localObject1).append("widget@2x.png");
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      else
      {
        localObject1 = "";
      }
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        String str = (String)((Iterator)localObject2).next();
        if ("widget@2x.png".equals(str)) {
          return;
        }
        VSEntranceWidgetHelper.WidgetConfig localWidgetConfig = new VSEntranceWidgetHelper.WidgetConfig(this, str, paramVSEntranceWidgetBean.c());
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString);
        localStringBuilder.append("/");
        localStringBuilder.append(str);
        localWidgetConfig.a(localStringBuilder.toString());
        localWidgetConfig.f = ((String)localObject1);
        this.jdField_b_of_type_JavaUtilHashMap.put(str, localWidgetConfig);
      }
    }
  }
  
  private void b()
  {
    a(this.jdField_b_of_type_ComTencentBizVideostoryConfigProcessorVSEntranceStyleBean);
    a(this.jdField_b_of_type_ComTencentBizVideostoryConfigProcessorVSEntranceWidgetBean);
  }
  
  private boolean b()
  {
    return BaseApplicationImpl.sProcessId == 2;
  }
  
  public VSEntranceWidgetHelper.StyleConfig a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    return (VSEntranceWidgetHelper.StyleConfig)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
  }
  
  public VSEntranceWidgetHelper.WidgetConfig a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    return (VSEntranceWidgetHelper.WidgetConfig)this.jdField_b_of_type_JavaUtilHashMap.get(paramString);
  }
  
  public void a()
  {
    try
    {
      Object localObject = (String)VSConfigManager.a().a("KEY_VS_ENTRANCE_STYLE_CONTENT", "");
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        this.jdField_a_of_type_ComTencentBizVideostoryConfigProcessorVSEntranceStyleBean = VSEntranceStyleBean.a((String)localObject);
        if (this.jdField_a_of_type_ComTencentBizVideostoryConfigProcessorVSEntranceStyleBean != null)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("old style config:");
          ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentBizVideostoryConfigProcessorVSEntranceStyleBean.toString());
          QLog.i("Q.videostory.config.VSEntranceWidgetHelper", 1, ((StringBuilder)localObject).toString());
        }
      }
      localObject = (String)VSConfigManager.a().a("KEY_VS_ENTRANCE_WIDGET_CONTENT", "");
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        this.jdField_a_of_type_ComTencentBizVideostoryConfigProcessorVSEntranceWidgetBean = VSEntranceWidgetBean.a((String)localObject);
        if (this.jdField_a_of_type_ComTencentBizVideostoryConfigProcessorVSEntranceWidgetBean != null)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("old widget config:");
          ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentBizVideostoryConfigProcessorVSEntranceWidgetBean.toString());
          QLog.i("Q.videostory.config.VSEntranceWidgetHelper", 1, ((StringBuilder)localObject).toString());
        }
      }
      this.jdField_b_of_type_ComTencentBizVideostoryConfigProcessorVSEntranceStyleBean = ((VSEntranceStyleBean)QConfigManager.a().a(473));
      if (this.jdField_b_of_type_ComTencentBizVideostoryConfigProcessorVSEntranceStyleBean != null)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("load style config:");
        ((StringBuilder)localObject).append(this.jdField_b_of_type_ComTencentBizVideostoryConfigProcessorVSEntranceStyleBean.toString());
        QLog.i("Q.videostory.config.VSEntranceWidgetHelper", 1, ((StringBuilder)localObject).toString());
      }
      this.jdField_b_of_type_ComTencentBizVideostoryConfigProcessorVSEntranceWidgetBean = ((VSEntranceWidgetBean)QConfigManager.a().a(474));
      if (this.jdField_b_of_type_ComTencentBizVideostoryConfigProcessorVSEntranceWidgetBean != null)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("load widget config:");
        ((StringBuilder)localObject).append(this.jdField_b_of_type_ComTencentBizVideostoryConfigProcessorVSEntranceWidgetBean.toString());
        QLog.i("Q.videostory.config.VSEntranceWidgetHelper", 1, ((StringBuilder)localObject).toString());
      }
      if (b())
      {
        if (this.jdField_a_of_type_ComTencentBizVideostoryConfigProcessorVSEntranceStyleBean != null) {
          this.jdField_b_of_type_ComTencentBizVideostoryConfigProcessorVSEntranceStyleBean = this.jdField_a_of_type_ComTencentBizVideostoryConfigProcessorVSEntranceStyleBean;
        }
        if (this.jdField_a_of_type_ComTencentBizVideostoryConfigProcessorVSEntranceWidgetBean != null) {
          this.jdField_b_of_type_ComTencentBizVideostoryConfigProcessorVSEntranceWidgetBean = this.jdField_a_of_type_ComTencentBizVideostoryConfigProcessorVSEntranceWidgetBean;
        }
      }
      b();
      return;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("loadConfig error!");
      localStringBuilder.append(localException.toString());
      QZLog.e("Q.videostory.config.VSEntranceWidgetHelper", 1, new Object[] { localStringBuilder.toString() });
    }
  }
  
  public boolean a()
  {
    return VSConfigManager.a().b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.videostory.entrancewidget.VSEntranceWidgetHelper
 * JD-Core Version:    0.7.0.1
 */