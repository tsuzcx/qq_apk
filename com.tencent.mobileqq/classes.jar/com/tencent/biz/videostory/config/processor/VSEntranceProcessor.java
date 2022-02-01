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
      VSEntranceConfBean localVSEntranceConfBean = VSEntranceConfBean.a(paramArrayOfQConfItem[0].a);
      QLog.i("Q.videostory.config.VSEntranceProcessor", 2, "onParsed " + paramArrayOfQConfItem[0].a);
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
      VSConfigManager.a().a("mine_videostory_entrance", paramVSEntranceConfBean.a());
      VSConfigManager.a().a("enable_click_take_picture", paramVSEntranceConfBean.b());
      VSConfigManager.a().a("mine_videostory_drawer_entrance", paramVSEntranceConfBean.c());
      QLog.i("Q.videostory.config.VSEntranceProcessor", 2, "onUpdate:" + paramVSEntranceConfBean.toString());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.videostory.config.processor.VSEntranceProcessor
 * JD-Core Version:    0.7.0.1
 */