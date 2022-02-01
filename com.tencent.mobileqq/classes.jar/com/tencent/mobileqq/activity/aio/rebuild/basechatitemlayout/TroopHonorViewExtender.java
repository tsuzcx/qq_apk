package com.tencent.mobileqq.activity.aio.rebuild.basechatitemlayout;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mobileqq.activity.aio.coreui.msglist.basechatItemlayout.NickNameExtenderViewBasicAbility;
import com.tencent.mobileqq.activity.aio.coreui.msglist.basechatItemlayout.NickNameLayoutExtender;
import com.tencent.mobileqq.troop.honor.widget.TroopHonorView;
import com.tencent.mobileqq.utils.ViewUtils;

public class TroopHonorViewExtender
  extends NickNameLayoutExtender
{
  private TroopHonorView a;
  
  public TroopHonorViewExtender(Context paramContext)
  {
    super(paramContext);
  }
  
  private void a()
  {
    if (this.a == null)
    {
      this.a = new TroopHonorView(this.mContext);
      this.a.setId(2131364672);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
      localLayoutParams.leftMargin = ViewUtils.a(2.0F);
      this.layoutParams = localLayoutParams;
    }
  }
  
  public NickNameExtenderViewBasicAbility getBasicAbility()
  {
    if (this.ability == null) {
      this.ability = new TroopHonorViewExtender.1(this, this.a);
    }
    return this.ability;
  }
  
  public View getView()
  {
    a();
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.basechatitemlayout.TroopHonorViewExtender
 * JD-Core Version:    0.7.0.1
 */