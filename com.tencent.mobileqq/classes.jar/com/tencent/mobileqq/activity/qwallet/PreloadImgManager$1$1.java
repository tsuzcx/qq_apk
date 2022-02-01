package com.tencent.mobileqq.activity.qwallet;

import android.os.Bundle;
import com.tencent.mobileqq.mqsafeedit.BaseApplication;
import com.tencent.mobileqq.vip.DownloadTask;
import java.util.List;

class PreloadImgManager$1$1
  implements Runnable
{
  PreloadImgManager$1$1(PreloadImgManager.1 param1, DownloadTask paramDownloadTask) {}
  
  public void run()
  {
    int j = this.jdField_a_of_type_ComTencentMobileqqVipDownloadTask.a.size();
    Bundle localBundle = this.jdField_a_of_type_ComTencentMobileqqVipDownloadTask.a();
    int i = 0;
    while (i < j)
    {
      String str = (String)this.jdField_a_of_type_ComTencentMobileqqVipDownloadTask.a.get(i);
      PreloadImgManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadImgManager$1.a, BaseApplication.getContext(), localBundle.getString(str), str);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.PreloadImgManager.1.1
 * JD-Core Version:    0.7.0.1
 */