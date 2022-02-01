package com.tencent.biz.videostory.config.processor;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.biz.videostory.config.VSConfigManager;
import com.tencent.biz.videostory.entrancewidget.VSEntranceWidgetDownLoadHelper;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.qphone.base.util.QLog;

public class VSEntranceWidgetProcessor
  extends IQConfigProcessor<VSEntranceWidgetBean>
{
  private void a(String paramString1, String paramString2)
  {
    QLog.d("Q.videostory.config.VSEntranceWidgetProcessor", 2, "onUpdate() apply new widget config");
    if (!TextUtils.isEmpty(paramString2))
    {
      VSConfigManager.a().a("KEY_BOOLEAN_APPLY_WIDGET_CONFIG", Boolean.valueOf(true));
      VSConfigManager.a().a("KEY_VS_ENTRANCE_WIDGET_MD5", paramString1);
      VSConfigManager.a().a("KEY_VS_ENTRANCE_WIDGET_CONTENT", paramString2);
    }
  }
  
  @NonNull
  public VSEntranceWidgetBean a(int paramInt)
  {
    return new VSEntranceWidgetBean();
  }
  
  @Nullable
  public VSEntranceWidgetBean a(QConfItem[] paramArrayOfQConfItem)
  {
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0))
    {
      QLog.i("Q.videostory.config.VSEntranceWidgetProcessor", 2, "onParsed " + paramArrayOfQConfItem[0].a);
      VSEntranceWidgetBean localVSEntranceWidgetBean = VSEntranceWidgetBean.a(paramArrayOfQConfItem[0].a);
      if (localVSEntranceWidgetBean == null)
      {
        QLog.e("Q.videostory.config.VSEntranceWidgetProcessor", 2, "onParsed error!");
        return null;
      }
      String str = (String)VSConfigManager.a().a("KEY_VS_ENTRANCE_WIDGET_MD5", "");
      if ((!TextUtils.isEmpty(localVSEntranceWidgetBean.b())) && (!localVSEntranceWidgetBean.b().equals(str)))
      {
        VSEntranceWidgetDownLoadHelper.a().a(localVSEntranceWidgetBean);
        a(localVSEntranceWidgetBean.b(), paramArrayOfQConfItem[0].a);
      }
      return localVSEntranceWidgetBean;
    }
    QLog.e("Q.videostory.config.VSEntranceWidgetProcessor", 2, "onParsed conf content is null!");
    return null;
  }
  
  public void a(VSEntranceWidgetBean paramVSEntranceWidgetBean)
  {
    if (paramVSEntranceWidgetBean != null) {
      QLog.i("Q.videostory.config.VSEntranceWidgetProcessor", 2, "onUpdate:" + paramVSEntranceWidgetBean.toString());
    }
  }
  
  public Class<VSEntranceWidgetBean> clazz()
  {
    return VSEntranceWidgetBean.class;
  }
  
  public boolean isNeedCompressed()
  {
    return true;
  }
  
  public boolean isNeedStoreLargeFile()
  {
    return false;
  }
  
  public int migrateOldVersion()
  {
    return 0;
  }
  
  public void onReqFailed(int paramInt) {}
  
  public int type()
  {
    return 474;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.videostory.config.processor.VSEntranceWidgetProcessor
 * JD-Core Version:    0.7.0.1
 */