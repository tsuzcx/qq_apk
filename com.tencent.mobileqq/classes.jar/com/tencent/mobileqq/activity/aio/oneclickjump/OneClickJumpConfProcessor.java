package com.tencent.mobileqq.activity.aio.oneclickjump;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.qphone.base.util.QLog;

public class OneClickJumpConfProcessor
  extends IQConfigProcessor<OneClickJumpConfBean>
{
  @NonNull
  public OneClickJumpConfBean a(int paramInt)
  {
    return new OneClickJumpConfBean();
  }
  
  @Nullable
  public OneClickJumpConfBean a(QConfItem[] paramArrayOfQConfItem)
  {
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0))
    {
      Object localObject2 = OneClickJumpConfBean.a(paramArrayOfQConfItem[0].b);
      Object localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = new OneClickJumpConfBean();
      }
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("onParsed ");
        ((StringBuilder)localObject2).append(paramArrayOfQConfItem[0].b);
        QLog.d("OneClickJumpConfProcessor", 2, ((StringBuilder)localObject2).toString());
      }
      return localObject1;
    }
    return new OneClickJumpConfBean();
  }
  
  public void a(OneClickJumpConfBean paramOneClickJumpConfBean) {}
  
  public Class<OneClickJumpConfBean> clazz()
  {
    return OneClickJumpConfBean.class;
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
    return 750;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.oneclickjump.OneClickJumpConfProcessor
 * JD-Core Version:    0.7.0.1
 */