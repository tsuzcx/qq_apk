package com.tencent.mobileqq.activity.aio.helper;

import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.widget.XEditTextEx;

public class EnterForSendHelper
  implements ILifeCycleHelper
{
  protected boolean a = false;
  protected EnterForSendHelper.EnterForSend b;
  private final BaseChatPie c;
  private final BaseActivity d;
  
  public EnterForSendHelper(BaseChatPie paramBaseChatPie)
  {
    this.c = paramBaseChatPie;
    this.d = paramBaseChatPie.aX();
  }
  
  private void a(XEditTextEx paramXEditTextEx)
  {
    BaseActivity localBaseActivity = this.d;
    this.a = SettingCloneUtil.readValue(localBaseActivity, null, localBaseActivity.getString(2131892698), "qqsetting_enter_sendmsg_key", false);
    if (this.a) {
      paramXEditTextEx.setImeOptions(4);
    } else {
      paramXEditTextEx.setImeOptions(0);
    }
    if (this.b == null) {
      this.b = new EnterForSendHelper.EnterForSend(this, null);
    }
    paramXEditTextEx.setOnEditorActionListener(this.b);
    paramXEditTextEx.setOnKeyListener(this.b);
  }
  
  public String getTag()
  {
    return "EnterForSendHelper";
  }
  
  public int[] interestedIn()
  {
    return new int[] { 6, 10 };
  }
  
  public void onMoveToState(int paramInt)
  {
    if (paramInt != 6)
    {
      if (paramInt != 10) {
        return;
      }
      a(this.c.Y);
      return;
    }
    this.a = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.EnterForSendHelper
 * JD-Core Version:    0.7.0.1
 */