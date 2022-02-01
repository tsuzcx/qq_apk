package com.tencent.mobileqq.activity.aio.rebuild.basechatitemlayout;

import android.view.View;
import com.tencent.mobileqq.activity.aio.coreui.msglist.basechatItemlayout.BaseChatItemLayoutViewBasicAbility;
import com.tencent.mobileqq.troop.honor.widget.TroopHonorView;
import java.util.List;

class TroopHonorViewExtender$1
  extends BaseChatItemLayoutViewBasicAbility
{
  TroopHonorViewExtender$1(TroopHonorViewExtender paramTroopHonorViewExtender, View paramView)
  {
    super(paramView);
  }
  
  public void setData(Object... paramVarArgs)
  {
    if (!checkViewNonNull()) {
      return;
    }
    if (paramVarArgs == null)
    {
      ((TroopHonorView)this.mView).setHonorList(null);
      return;
    }
    if (paramVarArgs.length == 2) {
      ((TroopHonorView)this.mView).setHonorList((List)paramVarArgs[0], ((Integer)paramVarArgs[1]).intValue());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.basechatitemlayout.TroopHonorViewExtender.1
 * JD-Core Version:    0.7.0.1
 */