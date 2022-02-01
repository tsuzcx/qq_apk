package com.tencent.mobileqq.activity.aio.helper;

import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.core.TroopChatPie;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.troop.blocktroop.TroopBlockUtils;
import com.tencent.mobileqq.utils.QQCustomDialog;

public class TroopBlockDialogHelper
  implements ILifeCycleHelper
{
  protected QQCustomDialog a;
  private BaseChatPie b;
  
  public TroopBlockDialogHelper(BaseChatPie paramBaseChatPie)
  {
    this.b = paramBaseChatPie;
  }
  
  protected void a()
  {
    QQCustomDialog localQQCustomDialog = this.a;
    if ((localQQCustomDialog != null) && (localQQCustomDialog.isShowing())) {
      this.a.dismiss();
    }
  }
  
  public void b()
  {
    Object localObject = this.b;
    if (localObject == null) {
      return;
    }
    if (((BaseChatPie)localObject).ah == null) {
      return;
    }
    if (TextUtils.isEmpty(this.b.ah.b)) {
      return;
    }
    if (!this.b.f.isResume()) {
      return;
    }
    localObject = this.b.ah.b;
    if (TroopBlockUtils.b(this.b.d, (String)localObject))
    {
      a();
      this.a = TroopBlockUtils.a(this.b.aX(), this.b.d, (String)localObject, new TroopBlockDialogHelper.1(this, (String)localObject));
      return;
    }
    a();
    localObject = this.b;
    if ((localObject instanceof TroopChatPie)) {
      ((TroopChatPie)localObject).bO();
    }
  }
  
  public String getTag()
  {
    return "TroopBlockDialogHelper";
  }
  
  public int[] interestedIn()
  {
    return new int[] { 15, 7 };
  }
  
  public void onMoveToState(int paramInt)
  {
    if (paramInt != 7)
    {
      if (paramInt != 15) {
        return;
      }
      a();
      return;
    }
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.TroopBlockDialogHelper
 * JD-Core Version:    0.7.0.1
 */