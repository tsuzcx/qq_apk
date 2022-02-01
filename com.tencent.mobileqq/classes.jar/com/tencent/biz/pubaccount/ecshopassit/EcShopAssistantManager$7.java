package com.tencent.biz.pubaccount.ecshopassit;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.pubaccount.ecshopassit.view.EcShopRainView;
import com.tencent.biz.pubaccount.ecshopassit.view.EcShopRainView.Conf;
import com.tencent.mobileqq.activity.aio.AIOUtils;

final class EcShopAssistantManager$7
  implements Runnable
{
  EcShopAssistantManager$7(Context paramContext, RelativeLayout paramRelativeLayout, Bitmap paramBitmap) {}
  
  public void run()
  {
    int i = AIOUtils.a(60.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    EcShopRainView localEcShopRainView = new EcShopRainView(this.jdField_a_of_type_AndroidContentContext);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(localEcShopRainView, localLayoutParams);
    localEcShopRainView.post(new EcShopAssistantManager.7.1(this, localEcShopRainView, new EcShopRainView.Conf(this.jdField_a_of_type_AndroidGraphicsBitmap, i)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.ecshopassit.EcShopAssistantManager.7
 * JD-Core Version:    0.7.0.1
 */