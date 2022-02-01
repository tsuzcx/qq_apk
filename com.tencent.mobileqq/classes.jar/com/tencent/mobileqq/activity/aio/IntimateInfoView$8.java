package com.tencent.mobileqq.activity.aio;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.IntimateInfo;
import mqq.os.MqqHandler;

class IntimateInfoView$8
  implements Runnable
{
  IntimateInfoView$8(IntimateInfoView paramIntimateInfoView, URLDrawable paramURLDrawable) {}
  
  public void run()
  {
    Bitmap localBitmap = Bitmap.createBitmap(750, 1272, Bitmap.Config.ARGB_8888);
    Object localObject1 = new Canvas(localBitmap);
    this.a.setBounds(0, 0, 750, 1272);
    this.a.draw((Canvas)localObject1);
    localObject1 = this.this$0;
    BaseActivity localBaseActivity = ((IntimateInfoView)localObject1).b;
    QQAppInterface localQQAppInterface = this.this$0.a;
    IntimateInfo localIntimateInfo = IntimateInfoView.c(this.this$0);
    Object localObject2 = this.this$0;
    localObject2 = ((IntimateInfoView)localObject2).b(((IntimateInfoView)localObject2).a.getCurrentAccountUin());
    IntimateInfoView localIntimateInfoView = this.this$0;
    IntimateInfoView.a((IntimateInfoView)localObject1, new IntimateInfoShareHelper(localBaseActivity, localQQAppInterface, localIntimateInfo, (Bitmap)localObject2, localIntimateInfoView.b(localIntimateInfoView.d), localBitmap));
    ThreadManager.getUIHandler().post(new IntimateInfoView.8.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.IntimateInfoView.8
 * JD-Core Version:    0.7.0.1
 */