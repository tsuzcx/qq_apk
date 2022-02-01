package com.tencent.mobileqq.activity.aio.coreui.msglist.basechatItemlayout;

import android.text.Spannable;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.vas.ColorNickManager;

class NickNameExtender$1
  extends NickNameExtenderViewBasicAbility
{
  NickNameExtender$1(NickNameExtender paramNickNameExtender, View paramView)
  {
    super(paramView);
  }
  
  public void setData(Object... paramVarArgs)
  {
    if (!checkViewNonNull()) {}
    do
    {
      return;
      if ((paramVarArgs != null) && (paramVarArgs.length == 2))
      {
        ColorNickManager.a((QQAppInterface)paramVarArgs[0], (TextView)this.mView, (Spannable)paramVarArgs[1]);
        return;
      }
    } while ((paramVarArgs == null) || (paramVarArgs.length != 4));
    ColorNickManager.a((QQAppInterface)paramVarArgs[0], (TextView)this.mView, (Spannable)paramVarArgs[1], ((Integer)paramVarArgs[2]).intValue(), ((Boolean)paramVarArgs[3]).booleanValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.coreui.msglist.basechatItemlayout.NickNameExtender.1
 * JD-Core Version:    0.7.0.1
 */