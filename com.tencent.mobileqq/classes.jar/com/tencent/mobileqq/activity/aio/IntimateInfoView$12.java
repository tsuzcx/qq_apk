package com.tencent.mobileqq.activity.aio;

import afys;
import afyw;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

public class IntimateInfoView$12
  implements Runnable
{
  public IntimateInfoView$12(afyw paramafyw, URLDrawable paramURLDrawable) {}
  
  public void run()
  {
    Bitmap localBitmap = Bitmap.createBitmap(750, 1272, Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    this.a.setBounds(0, 0, 750, 1272);
    this.a.draw(localCanvas);
    afyw.a(this.this$0, new afys(this.this$0.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, afyw.a(this.this$0), afyw.a(this.this$0, this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()), afyw.a(this.this$0, this.this$0.jdField_a_of_type_JavaLangString), localBitmap));
    ThreadManager.getUIHandler().post(new IntimateInfoView.12.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.IntimateInfoView.12
 * JD-Core Version:    0.7.0.1
 */