package com.tencent.mobileqq.activity.aio.anim.friendship.impl;

import com.tencent.mobileqq.activity.aio.anim.friendship.impl.base.IDirector.OnDirectorPrepared;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.mutualmark.ZipResourcesDownloader.OnZipResourcesDownloadCallback;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

class LottieAnimDirector$2
  implements ZipResourcesDownloader.OnZipResourcesDownloadCallback
{
  LottieAnimDirector$2(LottieAnimDirector paramLottieAnimDirector, IDirector.OnDirectorPrepared paramOnDirectorPrepared) {}
  
  public void a(boolean paramBoolean)
  {
    QLog.i("LottieAnimDirector", 1, "onZipDownloadResult success:" + paramBoolean + " mPaused:" + LottieAnimDirector.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimFriendshipImplLottieAnimDirector) + " mDestroyed:" + LottieAnimDirector.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimFriendshipImplLottieAnimDirector));
    if ((LottieAnimDirector.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimFriendshipImplLottieAnimDirector)) || (LottieAnimDirector.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimFriendshipImplLottieAnimDirector))) {
      return;
    }
    ThreadManager.getUIHandler().post(new LottieAnimDirector.2.1(this, paramBoolean));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.anim.friendship.impl.LottieAnimDirector.2
 * JD-Core Version:    0.7.0.1
 */