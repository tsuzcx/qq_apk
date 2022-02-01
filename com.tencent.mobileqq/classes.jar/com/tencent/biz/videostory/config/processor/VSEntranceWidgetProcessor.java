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
      VSConfigManager.a().b("KEY_BOOLEAN_APPLY_WIDGET_CONFIG", Boolean.valueOf(true));
      VSConfigManager.a().b("KEY_VS_ENTRANCE_WIDGET_MD5", paramString1);
      VSConfigManager.a().b("KEY_VS_ENTRANCE_WIDGET_CONTENT", paramString2);
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
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onParsed ");
      ((StringBuilder)localObject).append(paramArrayOfQConfItem[0].b);
      QLog.i("Q.videostory.config.VSEntranceWidgetProcessor", 2, ((StringBuilder)localObject).toString());
      localObject = VSEntranceWidgetBean.a(paramArrayOfQConfItem[0].b);
      if (localObject == null)
      {
        QLog.e("Q.videostory.config.VSEntranceWidgetProcessor", 2, "onParsed error!");
        return null;
      }
      String str = (String)VSConfigManager.a().a("KEY_VS_ENTRANCE_WIDGET_MD5", "");
      if ((!TextUtils.isEmpty(((VSEntranceWidgetBean)localObject).b())) && (!((VSEntranceWidgetBean)localObject).b().equals(str)))
      {
        VSEntranceWidgetDownLoadHelper.a().a((VSEntranceWidgetBean)localObject);
        a(((VSEntranceWidgetBean)localObject).b(), paramArrayOfQConfItem[0].b);
      }
      return localObject;
    }
    QLog.e("Q.videostory.config.VSEntranceWidgetProcessor", 2, "onParsed conf content is null!");
    return null;
  }
  
  public void a(VSEntranceWidgetBean paramVSEntranceWidgetBean)
  {
    if (paramVSEntranceWidgetBean != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onUpdate:");
      localStringBuilder.append(paramVSEntranceWidgetBean.toString());
      QLog.i("Q.videostory.config.VSEntranceWidgetProcessor", 2, localStringBuilder.toString());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.videostory.config.processor.VSEntranceWidgetProcessor
 * JD-Core Version:    0.7.0.1
 */