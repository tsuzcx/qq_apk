package com.tencent.biz.pubaccount.weishi_new.config;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;

public class WeSeeConfigProcessor
  extends IQConfigProcessor<WeSeeConfigBean>
{
  @NonNull
  public WeSeeConfigBean a(int paramInt)
  {
    return new WeSeeConfigBean();
  }
  
  @Nullable
  public WeSeeConfigBean a(QConfItem[] paramArrayOfQConfItem)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("");
    ((StringBuilder)localObject).append(paramArrayOfQConfItem.length);
    WSLog.a("WeSeeConfigProcessor", ((StringBuilder)localObject).toString());
    localObject = new WeSeeConfigBean();
    if (((WeSeeConfigBean)localObject).a(paramArrayOfQConfItem)) {
      return localObject;
    }
    return null;
  }
  
  public void a(WeSeeConfigBean paramWeSeeConfigBean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onUpdate ");
    localStringBuilder.append(paramWeSeeConfigBean);
    WSLog.f("WeSeeConfigProcessor", localStringBuilder.toString());
    WSConfigManager.a().a(paramWeSeeConfigBean);
  }
  
  public Class<WeSeeConfigBean> clazz()
  {
    return WeSeeConfigBean.class;
  }
  
  public boolean isAccountRelated()
  {
    return false;
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
  
  public void onReqNoReceive()
  {
    super.onReqNoReceive();
    WSLog.f("WeSeeConfigProcessor", "onReqNoReceive");
  }
  
  public int type()
  {
    return 447;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.config.WeSeeConfigProcessor
 * JD-Core Version:    0.7.0.1
 */