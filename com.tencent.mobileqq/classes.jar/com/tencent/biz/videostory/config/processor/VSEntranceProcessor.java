package com.tencent.biz.videostory.config.processor;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.videostory.config.VSConfigManager;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.qphone.base.util.QLog;

public class VSEntranceProcessor
  extends IQConfigProcessor<VSEntranceConfBean>
{
  @NonNull
  public VSEntranceConfBean a(int paramInt)
  {
    return new VSEntranceConfBean();
  }
  
  @Nullable
  public VSEntranceConfBean a(QConfItem[] paramArrayOfQConfItem)
  {
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0))
    {
      VSEntranceConfBean localVSEntranceConfBean = VSEntranceConfBean.a(paramArrayOfQConfItem[0].b);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onParsed ");
      localStringBuilder.append(paramArrayOfQConfItem[0].b);
      QLog.i("Q.videostory.config.VSEntranceProcessor", 2, localStringBuilder.toString());
      a(localVSEntranceConfBean);
      return localVSEntranceConfBean;
    }
    QLog.e("Q.videostory.config.VSEntranceProcessor", 2, "onParsed conf content is null!");
    return null;
  }
  
  public void a(VSEntranceConfBean paramVSEntranceConfBean)
  {
    if (paramVSEntranceConfBean != null)
    {
      VSConfigManager.a().b("mine_videostory_entrance", paramVSEntranceConfBean.a());
      VSConfigManager.a().b("enable_click_take_picture", paramVSEntranceConfBean.b());
      VSConfigManager.a().b("mine_videostory_drawer_entrance", paramVSEntranceConfBean.c());
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onUpdate:");
      localStringBuilder.append(paramVSEntranceConfBean.toString());
      QLog.i("Q.videostory.config.VSEntranceProcessor", 2, localStringBuilder.toString());
    }
  }
  
  public Class<VSEntranceConfBean> clazz()
  {
    return VSEntranceConfBean.class;
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
    return 411;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.videostory.config.processor.VSEntranceProcessor
 * JD-Core Version:    0.7.0.1
 */