package com.tencent.mobileqq.activity.bless;

import com.tencent.mobileqq.app.ShortVideoObserver;
import com.tencent.mobileqq.shortvideo.redbag.RedBagVideoManager;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;

class BlessResultActivity$1
  extends ShortVideoObserver
{
  BlessResultActivity$1(BlessResultActivity paramBlessResultActivity) {}
  
  public void a(boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BlessResultActivity", 2, "VideoRedbag, onCheckRealNameRsp in bless");
    }
    if ((paramBoolean) && (paramInt == RedBagVideoManager.a)) {
      DialogUtil.a(this.a.getActivity(), 0, null, this.a.getString(2131719382), 2131719384, 2131719383, new BlessResultActivity.1.1(this), new BlessResultActivity.1.2(this)).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.bless.BlessResultActivity.1
 * JD-Core Version:    0.7.0.1
 */