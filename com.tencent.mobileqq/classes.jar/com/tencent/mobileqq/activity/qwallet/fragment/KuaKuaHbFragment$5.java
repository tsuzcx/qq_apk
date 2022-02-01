package com.tencent.mobileqq.activity.qwallet.fragment;

import android.view.View;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.activity.qwallet.redpacket.draw.ChooseItemView.OnVisibilityChangeListener;

class KuaKuaHbFragment$5
  implements ChooseItemView.OnVisibilityChangeListener
{
  KuaKuaHbFragment$5(KuaKuaHbFragment paramKuaKuaHbFragment) {}
  
  public void a(int paramInt)
  {
    if (paramInt == 0)
    {
      this.a.a.findViewById(2131369029).setVisibility(8);
      this.a.a.findViewById(2131377735).setVisibility(8);
      KuaKuaHbFragment.a(this.a).setVisibility(8);
      return;
    }
    this.a.a.findViewById(2131369029).setVisibility(0);
    this.a.a.findViewById(2131377735).setVisibility(0);
    KuaKuaHbFragment.a(this.a).setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.fragment.KuaKuaHbFragment.5
 * JD-Core Version:    0.7.0.1
 */