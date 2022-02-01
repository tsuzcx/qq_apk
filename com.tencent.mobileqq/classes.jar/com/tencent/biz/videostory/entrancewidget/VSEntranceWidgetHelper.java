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
  
  /* Error */
  public static VSEntranceWidgetHelper a()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 27	com/tencent/biz/videostory/entrancewidget/VSEntranceWidgetHelper:jdField_a_of_type_ComTencentBizVideostoryEntrancewidgetVSEntranceWidgetHelper	Lcom/tencent/biz/videostory/entrancewidget/VSEntranceWidgetHelper;
    //   6: ifnonnull +25 -> 31
    //   9: ldc 2
    //   11: monitorenter
    //   12: getstatic 27	com/tencent/biz/videostory/entrancewidget/VSEntranceWidgetHelper:jdField_a_of_type_ComTencentBizVideostoryEntrancewidgetVSEntranceWidgetHelper	Lcom/tencent/biz/videostory/entrancewidget/VSEntranceWidgetHelper;
    //   15: ifnonnull +13 -> 28
    //   18: new 2	com/tencent/biz/videostory/entrancewidget/VSEntranceWidgetHelper
    //   21: dup
    //   22: invokespecial 28	com/tencent/biz/videostory/entrancewidget/VSEntranceWidgetHelper:<init>	()V
    //   25: putstatic 27	com/tencent/biz/videostory/entrancewidget/VSEntranceWidgetHelper:jdField_a_of_type_ComTencentBizVideostoryEntrancewidgetVSEntranceWidgetHelper	Lcom/tencent/biz/videostory/entrancewidget/VSEntranceWidgetHelper;
    //   28: ldc 2
    //   30: monitorexit
    //   31: getstatic 27	com/tencent/biz/videostory/entrancewidget/VSEntranceWidgetHelper:jdField_a_of_type_ComTencentBizVideostoryEntrancewidgetVSEntranceWidgetHelper	Lcom/tencent/biz/videostory/entrancewidget/VSEntranceWidgetHelper;
    //   34: astore_0
    //   35: ldc 2
    //   37: monitorexit
    //   38: aload_0
    //   39: areturn
    //   40: astore_0
    //   41: ldc 2
    //   43: monitorexit
    //   44: aload_0
    //   45: athrow
    //   46: astore_0
    //   47: ldc 2
    //   49: monitorexit
    //   50: aload_0
    //   51: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   34	5	0	localVSEntranceWidgetHelper	VSEntranceWidgetHelper
    //   40	5	0	localObject1	Object
    //   46	5	0	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   12	28	40	finally
    //   28	31	40	finally
    //   41	44	40	finally
    //   3	12	46	finally
    //   31	35	46	finally
    //   44	46	46	finally
  }
  
  private void a(VSEntranceStyleBean paramVSEntranceStyleBean)
  {
    QLog.d("Q.videostory.config.VSEntranceWidgetHelper", 1, "handleStyleConfig()");
    String str;
    if (paramVSEntranceStyleBean != null)
    {
      str = paramVSEntranceStyleBean.a();
      if (TextUtils.isEmpty(str)) {
        QLog.e("Q.videostory.config.VSEntranceWidgetHelper", 1, "handleStyleConfig error!");
      }
    }
    else
    {
      return;
    }
    if (VSEntranceWidgetDownLoadHelper.a().a(str))
    {
      a(paramVSEntranceStyleBean, VSEntranceWidgetDownLoadHelper.a().b(str));
      return;
    }
    VSEntranceWidgetDownLoadHelper.a().a(paramVSEntranceStyleBean.a(), new VSEntranceWidgetHelper.1(this, paramVSEntranceStyleBean, str));
  }
  
  private void a(VSEntranceStyleBean paramVSEntranceStyleBean, String paramString)
  {
    QLog.d("Q.videostory.config.VSEntranceWidgetHelper", 1, "initStyleConfigCache() path:" + paramString);
    Iterator localIterator = paramVSEntranceStyleBean.a().keys();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      VSEntranceWidgetHelper.StyleConfig localStyleConfig = new VSEntranceWidgetHelper.StyleConfig(this, str, paramVSEntranceStyleBean.a().optJSONObject(str));
      localStyleConfig.a(paramString);
      this.jdField_a_of_type_JavaUtilHashMap.put(str, localStyleConfig);
    }
  }
  
  private void a(VSEntranceWidgetBean paramVSEntranceWidgetBean)
  {
    QLog.d("Q.videostory.config.VSEntranceWidgetHelper", 1, "handleWidgetConfig()");
    String str;
    if (paramVSEntranceWidgetBean != null)
    {
      str = paramVSEntranceWidgetBean.a();
      if (TextUtils.isEmpty(str)) {
        QLog.e("Q.videostory.config.VSEntranceWidgetHelper", 1, "handleWidgetConfig error!");
      }
    }
    else
    {
      return;
    }
    if (VSEntranceWidgetDownLoadHelper.a().a(str))
    {
      a(paramVSEntranceWidgetBean, VSEntranceWidgetDownLoadHelper.a().b(str));
      return;
    }
    VSEntranceWidgetDownLoadHelper.a().a(paramVSEntranceWidgetBean.a(), new VSEntranceWidgetHelper.2(this, paramVSEntranceWidgetBean, str));
  }
  
  private void a(VSEntranceWidgetBean paramVSEntranceWidgetBean, String paramString)
  {
    QLog.d("Q.videostory.config.VSEntranceWidgetHelper", 1, "initWidgetConfigCache() path:" + paramString);
    Object localObject1 = new File(paramString);
    Object localObject2;
    if (((File)localObject1).exists())
    {
      localObject2 = Arrays.asList(((File)localObject1).list());
      if (!((List)localObject2).contains("widget@2x.png")) {
        break label195;
      }
    }
    label195:
    for (localObject1 = paramString + "/" + "widget@2x.png";; localObject1 = "")
    {
      localObject2 = ((List)localObject2).iterator();
      for (;;)
      {
        String str;
        if (((Iterator)localObject2).hasNext())
        {
          str = (String)((Iterator)localObject2).next();
          if (!"widget@2x.png".equals(str)) {}
        }
        else
        {
          return;
        }
        VSEntranceWidgetHelper.WidgetConfig localWidgetConfig = new VSEntranceWidgetHelper.WidgetConfig(this, str, paramVSEntranceWidgetBean.c());
        localWidgetConfig.a(paramString + "/" + str);
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
      String str = (String)VSConfigManager.a().a("KEY_VS_ENTRANCE_STYLE_CONTENT", "");
      if (!TextUtils.isEmpty(str))
      {
        this.jdField_a_of_type_ComTencentBizVideostoryConfigProcessorVSEntranceStyleBean = VSEntranceStyleBean.a(str);
        if (this.jdField_a_of_type_ComTencentBizVideostoryConfigProcessorVSEntranceStyleBean != null) {
          QLog.i("Q.videostory.config.VSEntranceWidgetHelper", 1, "old style config:" + this.jdField_a_of_type_ComTencentBizVideostoryConfigProcessorVSEntranceStyleBean.toString());
        }
      }
      str = (String)VSConfigManager.a().a("KEY_VS_ENTRANCE_WIDGET_CONTENT", "");
      if (!TextUtils.isEmpty(str))
      {
        this.jdField_a_of_type_ComTencentBizVideostoryConfigProcessorVSEntranceWidgetBean = VSEntranceWidgetBean.a(str);
        if (this.jdField_a_of_type_ComTencentBizVideostoryConfigProcessorVSEntranceWidgetBean != null) {
          QLog.i("Q.videostory.config.VSEntranceWidgetHelper", 1, "old widget config:" + this.jdField_a_of_type_ComTencentBizVideostoryConfigProcessorVSEntranceWidgetBean.toString());
        }
      }
      this.jdField_b_of_type_ComTencentBizVideostoryConfigProcessorVSEntranceStyleBean = ((VSEntranceStyleBean)QConfigManager.a().a(473));
      if (this.jdField_b_of_type_ComTencentBizVideostoryConfigProcessorVSEntranceStyleBean != null) {
        QLog.i("Q.videostory.config.VSEntranceWidgetHelper", 1, "load style config:" + this.jdField_b_of_type_ComTencentBizVideostoryConfigProcessorVSEntranceStyleBean.toString());
      }
      this.jdField_b_of_type_ComTencentBizVideostoryConfigProcessorVSEntranceWidgetBean = ((VSEntranceWidgetBean)QConfigManager.a().a(474));
      if (this.jdField_b_of_type_ComTencentBizVideostoryConfigProcessorVSEntranceWidgetBean != null) {
        QLog.i("Q.videostory.config.VSEntranceWidgetHelper", 1, "load widget config:" + this.jdField_b_of_type_ComTencentBizVideostoryConfigProcessorVSEntranceWidgetBean.toString());
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
      QZLog.e("Q.videostory.config.VSEntranceWidgetHelper", 1, new Object[] { "loadConfig error!" + localException.toString() });
    }
  }
  
  public boolean a()
  {
    return VSConfigManager.a().b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.videostory.entrancewidget.VSEntranceWidgetHelper
 * JD-Core Version:    0.7.0.1
 */