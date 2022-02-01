package com.tencent.mobileqq.activity.aio.rebuild.input.righticon;

import android.view.View;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.coreui.input.IOnRightIconClickListener;
import com.tencent.mobileqq.activity.aio.helper.AIOZhituHelper;
import com.tencent.mobileqq.doutu.DoutuHelper;

public class DoutuRightIconClickListener
  implements IOnRightIconClickListener
{
  public boolean a(AIOContext paramAIOContext, View paramView)
  {
    return false;
  }
  
  public void b(AIOContext paramAIOContext, View paramView)
  {
    if (((AIOZhituHelper)paramAIOContext.a(116)).a) {
      ((DoutuHelper)paramAIOContext.a(115)).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.input.righticon.DoutuRightIconClickListener
 * JD-Core Version:    0.7.0.1
 */