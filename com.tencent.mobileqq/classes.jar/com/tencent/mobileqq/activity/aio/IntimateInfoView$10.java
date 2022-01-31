package com.tencent.mobileqq.activity.aio;

import acwi;
import acwl;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

public class IntimateInfoView$10
  implements Runnable
{
  public IntimateInfoView$10(acwl paramacwl, URLDrawable paramURLDrawable) {}
  
  public void run()
  {
    Bitmap localBitmap = Bitmap.createBitmap(750, 1272, Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    this.a.setBounds(0, 0, 750, 1272);
    this.a.draw(localCanvas);
    acwl.a(this.this$0, new acwi(this.this$0.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, acwl.a(this.this$0), acwl.a(this.this$0, this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()), acwl.a(this.this$0, this.this$0.jdField_a_of_type_JavaLangString), localBitmap));
    ThreadManager.getUIHandler().post(new IntimateInfoView.10.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.IntimateInfoView.10
 * JD-Core Version:    0.7.0.1
 */