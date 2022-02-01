package com.tencent.mobileqq.activity.aio.stickerrecommended;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.qphone.base.util.QLog;

public class StickerRecConfigProcessor
  extends IQConfigProcessor<StickerRecConfigBean>
{
  @NonNull
  public StickerRecConfigBean a(int paramInt)
  {
    return new StickerRecConfigBean();
  }
  
  @Nullable
  public StickerRecConfigBean a(QConfItem[] paramArrayOfQConfItem)
  {
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0))
    {
      StickerRecConfigBean localStickerRecConfigBean = StickerRecConfigBean.a(paramArrayOfQConfItem[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("StickerRecConfigProcessor", 2, "onParsed " + paramArrayOfQConfItem[0].a);
      }
      return localStickerRecConfigBean;
    }
    return null;
  }
  
  public void a(StickerRecConfigBean paramStickerRecConfigBean)
  {
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject instanceof QQAppInterface))
    {
      localObject = (QQAppInterface)localObject;
      String str = ((QQAppInterface)localObject).getCurrentUin();
      StickerRecManager.a(BaseApplicationImpl.getApplication(), str, paramStickerRecConfigBean.a());
      StickerRecManager.a((QQAppInterface)localObject, paramStickerRecConfigBean.a());
    }
  }
  
  public Class<StickerRecConfigBean> clazz()
  {
    return StickerRecConfigBean.class;
  }
  
  public boolean isAccountRelated()
  {
    return super.isAccountRelated();
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
    return 410;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.stickerrecommended.StickerRecConfigProcessor
 * JD-Core Version:    0.7.0.1
 */