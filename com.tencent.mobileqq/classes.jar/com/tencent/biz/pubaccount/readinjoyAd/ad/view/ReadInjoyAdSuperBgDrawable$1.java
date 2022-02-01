package com.tencent.biz.pubaccount.readinjoyAd.ad.view;

import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;
import tzw;

public class ReadInjoyAdSuperBgDrawable$1
  implements Runnable
{
  public ReadInjoyAdSuperBgDrawable$1(tzw paramtzw, Drawable paramDrawable, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    tzw.a(this.this$0, tzw.a(this.this$0, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, this.jdField_a_of_type_Int, this.b));
    if (tzw.a(this.this$0) != null) {
      ThreadManager.getUIHandler().post(new ReadInjoyAdSuperBgDrawable.1.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.view.ReadInjoyAdSuperBgDrawable.1
 * JD-Core Version:    0.7.0.1
 */