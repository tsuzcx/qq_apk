package com.tencent.mobileqq.activity.aio.rebuild.input.righticon;

import android.view.View;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.coreui.input.IOnRightIconClickListener;
import com.tencent.mobileqq.activity.aio.helper.AIOZhituHelper;
import com.tencent.mobileqq.activity.aio.helper.StickerRecHelper;

public class EmotionRightIconClickListener
  implements IOnRightIconClickListener
{
  public void a(AIOContext paramAIOContext, View paramView)
  {
    if (((AIOZhituHelper)paramAIOContext.a(116)).a)
    {
      paramAIOContext = (StickerRecHelper)paramAIOContext.a(14);
      if (paramAIOContext != null) {
        paramAIOContext.b();
      }
    }
  }
  
  public boolean a(AIOContext paramAIOContext, View paramView)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.input.righticon.EmotionRightIconClickListener
 * JD-Core Version:    0.7.0.1
 */