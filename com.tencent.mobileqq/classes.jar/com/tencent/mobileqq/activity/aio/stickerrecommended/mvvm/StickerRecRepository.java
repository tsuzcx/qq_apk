package com.tencent.mobileqq.activity.aio.stickerrecommended.mvvm;

import android.os.Handler;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.aio.stickerrecommended.IStickerRecEmoticon;
import com.tencent.mobileqq.activity.aio.stickerrecommended.IStickerRecManager.ImgUpdateListener;
import com.tencent.mobileqq.activity.aio.stickerrecommended.impl.StickerRecManagerImpl;
import com.tencent.mobileqq.activity.aio.stickerrecommended.mvvm.data.StickerRecLiveData;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mvvm.BaseRepository;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class StickerRecRepository
  extends BaseRepository
  implements IStickerRecManager.ImgUpdateListener
{
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  private StickerRecManagerImpl jdField_a_of_type_ComTencentMobileqqActivityAioStickerrecommendedImplStickerRecManagerImpl;
  private StickerRecViewModel jdField_a_of_type_ComTencentMobileqqActivityAioStickerrecommendedMvvmStickerRecViewModel;
  
  public AppInterface a()
  {
    return this.jdField_a_of_type_ComTencentCommonAppAppInterface;
  }
  
  public StickerRecManagerImpl a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerrecommendedImplStickerRecManagerImpl == null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerrecommendedImplStickerRecManagerImpl = StickerRecManagerImpl.get(this.jdField_a_of_type_ComTencentCommonAppAppInterface);
    }
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerrecommendedImplStickerRecManagerImpl;
  }
  
  public void a()
  {
    AppInterface localAppInterface = this.jdField_a_of_type_ComTencentCommonAppAppInterface;
    if (localAppInterface == null) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerrecommendedImplStickerRecManagerImpl == null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerrecommendedImplStickerRecManagerImpl = StickerRecManagerImpl.get(localAppInterface);
    }
    if (!this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerrecommendedImplStickerRecManagerImpl.hasInit()) {
      ThreadManager.executeOnSubThread(new StickerRecRepository.1(this));
    }
  }
  
  public void a(AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerrecommendedImplStickerRecManagerImpl = StickerRecManagerImpl.get(this.jdField_a_of_type_ComTencentCommonAppAppInterface);
  }
  
  public void a(StickerRecViewModel paramStickerRecViewModel)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerrecommendedMvvmStickerRecViewModel = paramStickerRecViewModel;
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerrecommendedImplStickerRecManagerImpl == null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerrecommendedImplStickerRecManagerImpl = StickerRecManagerImpl.get(this.jdField_a_of_type_ComTencentCommonAppAppInterface);
    }
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerrecommendedImplStickerRecManagerImpl.setImgUpdateListener(this);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerrecommendedImplStickerRecManagerImpl.setImgUpdateListener(null);
  }
  
  public void onImgUpdated(List<IStickerRecEmoticon> paramList, String paramString1, String paramString2, int paramInt, String paramString3)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("data=");
      localStringBuilder.append(paramList.size());
      QLog.d("StickerRecRepository", 2, localStringBuilder.toString());
    }
    paramList = new StickerRecLiveData(paramList, paramString1, paramString2, paramInt, paramString3);
    ThreadManagerV2.getUIHandlerV2().post(new StickerRecRepository.2(this, paramList));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.stickerrecommended.mvvm.StickerRecRepository
 * JD-Core Version:    0.7.0.1
 */