package com.tencent.mobileqq.activity.aio.rebuild.input.righticon;

import android.view.View;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.input.AIOInput;
import com.tencent.mobileqq.activity.aio.coreui.input.EditTextUI;
import com.tencent.mobileqq.activity.aio.coreui.input.IOnRightIconClickListener;
import com.tencent.mobileqq.activity.aio.coreui.input.InputUIContainer;
import com.tencent.mobileqq.activity.aio.helper.AIOZhituHelper;
import com.tencent.mobileqq.activity.aio.helper.HiBoomHelper;
import com.tencent.mobileqq.hiboom.HiBoomConstants;
import java.util.concurrent.atomic.AtomicBoolean;

public class HiBoomRightIconClickListener
  implements IOnRightIconClickListener
{
  public void a(AIOContext paramAIOContext, View paramView)
  {
    if (((AIOZhituHelper)paramAIOContext.a(116)).a) {
      HiBoomConstants.b.set(false);
    }
  }
  
  public boolean a(AIOContext paramAIOContext, View paramView)
  {
    return !HiBoomHelper.a(paramAIOContext.a(), paramAIOContext.a(), paramAIOContext.a().a().a().a().toString(), paramAIOContext.a().a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.input.righticon.HiBoomRightIconClickListener
 * JD-Core Version:    0.7.0.1
 */