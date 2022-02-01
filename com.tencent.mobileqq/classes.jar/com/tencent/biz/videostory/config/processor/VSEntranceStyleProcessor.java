package com.tencent.biz.videostory.config.processor;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.biz.videostory.config.VSConfigManager;
import com.tencent.biz.videostory.entrancewidget.VSEntranceWidgetDownLoadHelper;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.qphone.base.util.QLog;

public class VSEntranceStyleProcessor
  extends IQConfigProcessor<VSEntranceStyleBean>
{
  private void a(String paramString1, String paramString2)
  {
    QLog.d("Q.videostory.config.VSEntranceStyleProcessor", 2, "onUpdate() apply new style config");
    if (!TextUtils.isEmpty(paramString2))
    {
      VSConfigManager.a().a("KEY_BOOLEAN_APPLY_STYLE_CONFIG", Boolean.valueOf(true));
      VSConfigManager.a().a("KEY_VS_ENTRANCE_STYLE_MD5", paramString1);
      VSConfigManager.a().a("KEY_VS_ENTRANCE_STYLE_CONTENT", paramString2);
    }
  }
  
  @NonNull
  public VSEntranceStyleBean a(int paramInt)
  {
    return new VSEntranceStyleBean();
  }
  
  @Nullable
  public VSEntranceStyleBean a(QConfItem[] paramArrayOfQConfItem)
  {
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0))
    {
      QLog.i("Q.videostory.config.VSEntranceStyleProcessor", 2, "onParsed " + paramArrayOfQConfItem[0].a);
      VSEntranceStyleBean localVSEntranceStyleBean = VSEntranceStyleBean.a(paramArrayOfQConfItem[0].a);
      if (localVSEntranceStyleBean == null)
      {
        QLog.e("Q.videostory.config.VSEntranceStyleProcessor", 2, "onParsed error!");
        return null;
      }
      String str = (String)VSConfigManager.a().a("KEY_VS_ENTRANCE_STYLE_MD5", "");
      if ((!TextUtils.isEmpty(localVSEntranceStyleBean.b())) && (!localVSEntranceStyleBean.b().equals(str)))
      {
        VSEntranceWidgetDownLoadHelper.a().a(localVSEntranceStyleBean);
        a(localVSEntranceStyleBean.b(), paramArrayOfQConfItem[0].a);
      }
      return localVSEntranceStyleBean;
    }
    QLog.e("Q.videostory.config.VSEntranceStyleProcessor", 2, "onParsed conf content is null!");
    return null;
  }
  
  public void a(VSEntranceStyleBean paramVSEntranceStyleBean)
  {
    if (paramVSEntranceStyleBean != null) {
      QLog.i("Q.videostory.config.VSEntranceStyleProcessor", 2, "onUpdate:" + paramVSEntranceStyleBean.toString());
    }
  }
  
  public Class<VSEntranceStyleBean> clazz()
  {
    return VSEntranceStyleBean.class;
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
    return 473;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.videostory.config.processor.VSEntranceStyleProcessor
 * JD-Core Version:    0.7.0.1
 */