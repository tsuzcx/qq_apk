package com.tencent.biz.videostory.config.processor;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.videostory.config.VSConfigManager;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.qphone.base.util.QLog;

public class VSSubscribeProcessor
  extends IQConfigProcessor<VSSubscribeConfBean>
{
  @NonNull
  public VSSubscribeConfBean a(int paramInt)
  {
    return new VSSubscribeConfBean();
  }
  
  @Nullable
  public VSSubscribeConfBean a(QConfItem[] paramArrayOfQConfItem)
  {
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0))
    {
      VSSubscribeConfBean localVSSubscribeConfBean = VSSubscribeConfBean.a(paramArrayOfQConfItem[0].b);
      a(localVSSubscribeConfBean);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onParsed ");
      localStringBuilder.append(paramArrayOfQConfItem[0].b);
      QLog.i("Q.videostory.config.VSSubscribeProcessor", 2, localStringBuilder.toString());
      return localVSSubscribeConfBean;
    }
    return null;
  }
  
  public void a(VSSubscribeConfBean paramVSSubscribeConfBean)
  {
    QLog.i("Q.videostory.config.VSSubscribeProcessor", 2, "onUpdate ");
    if (paramVSSubscribeConfBean != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onUpdate ");
      localStringBuilder.append(paramVSSubscribeConfBean.toString());
      QLog.i("Q.videostory.config.VSSubscribeProcessor", 2, localStringBuilder.toString());
      VSConfigManager.a().b("subscribe_entrance_enable", paramVSSubscribeConfBean.a());
      VSConfigManager.a().b("is_open_sharing", paramVSSubscribeConfBean.b());
      VSConfigManager.a().b("subscribe_account_title", paramVSSubscribeConfBean.c());
      VSConfigManager.a().b("newfollowlist", paramVSSubscribeConfBean.d());
      VSConfigManager.a().b("subscribe_publish_entrance_enable", paramVSSubscribeConfBean.e());
    }
  }
  
  public Class<VSSubscribeConfBean> clazz()
  {
    return VSSubscribeConfBean.class;
  }
  
  public boolean isAccountRelated()
  {
    return true;
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
    return 463;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.videostory.config.processor.VSSubscribeProcessor
 * JD-Core Version:    0.7.0.1
 */