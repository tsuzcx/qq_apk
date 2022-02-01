package com.tencent.biz.pubaccount.conf;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.pubaccount.subscript.SubscriptRecommendController;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.qphone.base.util.QLog;

public class PaSubscribeRedDotProcessor
  extends IQConfigProcessor<PaSubscribeRedDotBean>
{
  @NonNull
  public PaSubscribeRedDotBean a(int paramInt)
  {
    if (paramInt == 0)
    {
      Object localObject = BaseApplicationImpl.getApplication().getRuntime();
      if ((localObject instanceof QQAppInterface))
      {
        localObject = (QQAppInterface)localObject;
        boolean bool = SubscriptRecommendController.d((QQAppInterface)localObject);
        return PaSubscribeRedDotBean.a(SubscriptRecommendController.a((QQAppInterface)localObject), SubscriptRecommendController.b((QQAppInterface)localObject), bool);
      }
    }
    return new PaSubscribeRedDotBean();
  }
  
  @Nullable
  public PaSubscribeRedDotBean a(QConfItem[] paramArrayOfQConfItem)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PaSubscribeRedDotProcessor", 2, "[onParsed]");
    }
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0)) {
      return PaSubscribeRedDotBean.a(paramArrayOfQConfItem);
    }
    return null;
  }
  
  public void a(PaSubscribeRedDotBean paramPaSubscribeRedDotBean)
  {
    paramPaSubscribeRedDotBean.a();
  }
  
  public Class<PaSubscribeRedDotBean> clazz()
  {
    return PaSubscribeRedDotBean.class;
  }
  
  public boolean isAccountRelated()
  {
    return true;
  }
  
  public boolean isNeedCompressed()
  {
    return false;
  }
  
  public boolean isNeedStoreLargeFile()
  {
    return false;
  }
  
  public int migrateOldVersion()
  {
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject instanceof QQAppInterface))
    {
      localObject = (QQAppInterface)localObject;
      return SharedPreUtils.x(((QQAppInterface)localObject).getApp(), ((QQAppInterface)localObject).getAccount());
    }
    return 0;
  }
  
  public void onReqFailed(int paramInt) {}
  
  public int type()
  {
    return 35;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.conf.PaSubscribeRedDotProcessor
 * JD-Core Version:    0.7.0.1
 */