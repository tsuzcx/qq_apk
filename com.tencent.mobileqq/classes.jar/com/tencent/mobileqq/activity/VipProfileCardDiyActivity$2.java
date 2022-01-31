package com.tencent.mobileqq.activity;

import android.content.res.Resources;
import android.graphics.BitmapFactory.Options;
import android.util.DisplayMetrics;
import baxi;
import bfob;
import com.tencent.mobileqq.emoticon.EmojiStickerManager;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;

class VipProfileCardDiyActivity$2
  implements Runnable
{
  VipProfileCardDiyActivity$2(VipProfileCardDiyActivity paramVipProfileCardDiyActivity) {}
  
  public void run()
  {
    File localFile1 = new File(EmojiStickerManager.a(), "qvip_profile_diy_card_guide.png");
    File localFile2 = new File(EmojiStickerManager.a(), "qvip_profile_diy_card_guide_demo.png");
    if ((localFile1.exists()) && (localFile2.exists()))
    {
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inDensity = 320;
      localOptions.inTargetDensity = this.this$0.jdField_a_of_type_AndroidContentResResources.getDisplayMetrics().densityDpi;
      this.this$0.jdField_a_of_type_AndroidGraphicsBitmap = baxi.a(localFile1.getAbsolutePath(), localOptions);
      this.this$0.b = baxi.a(localFile2.getAbsolutePath(), localOptions);
      this.this$0.jdField_a_of_type_Bfob.sendEmptyMessage(9);
      this.this$0.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
      return;
    }
    this.this$0.jdField_a_of_type_ComTencentMobileqqVasVasQuickUpdateManager.downloadItem(1004L, "emojiStickerGuideZip_v2", "VipProfileCardDiy");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.VipProfileCardDiyActivity.2
 * JD-Core Version:    0.7.0.1
 */