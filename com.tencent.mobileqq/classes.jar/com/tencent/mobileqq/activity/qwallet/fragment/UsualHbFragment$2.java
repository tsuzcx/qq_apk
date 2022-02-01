package com.tencent.mobileqq.activity.qwallet.fragment;

import Wallet.SkinInfo;
import android.text.TextUtils;
import android.widget.EditText;
import com.tencent.mobileqq.activity.qwallet.SendHbActivity;
import com.tencent.mobileqq.activity.qwallet.fragment.busylogic.HbBusiUtils;
import com.tencent.mobileqq.activity.qwallet.fragment.busylogic.HbSkinInfo;
import com.tencent.mobileqq.activity.qwallet.fragment.busylogic.HbSkinLogic.ItemSelectListener;
import com.tencent.mobileqq.app.HardCodeUtil;

class UsualHbFragment$2
  implements HbSkinLogic.ItemSelectListener
{
  UsualHbFragment$2(UsualHbFragment paramUsualHbFragment) {}
  
  public void a(HbSkinInfo paramHbSkinInfo)
  {
    if ((paramHbSkinInfo.a.skin_id == 0) || (paramHbSkinInfo.a.skin_id == -2))
    {
      paramHbSkinInfo = HbBusiUtils.a(this.a.channel, this.a.a, this.a.mActivity.getConfigLogic(), paramHbSkinInfo.a.blessing);
      this.a.c.setHint(paramHbSkinInfo);
      return;
    }
    if (TextUtils.isEmpty(paramHbSkinInfo.a.blessing))
    {
      this.a.c.setHint(HardCodeUtil.a(2131696794));
      return;
    }
    this.a.c.setHint(paramHbSkinInfo.a.blessing);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.fragment.UsualHbFragment.2
 * JD-Core Version:    0.7.0.1
 */