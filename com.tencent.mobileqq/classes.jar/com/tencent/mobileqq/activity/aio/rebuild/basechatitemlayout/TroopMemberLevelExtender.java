package com.tencent.mobileqq.activity.aio.rebuild.basechatitemlayout;

import android.content.Context;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.coreui.msglist.basechatItemlayout.NickNameExtenderViewBasicAbility;
import com.tencent.mobileqq.activity.aio.coreui.msglist.basechatItemlayout.NickNameLayoutExtender;
import com.tencent.mobileqq.troop.troopMemberLevel.TroopMemberLevelView;
import com.tencent.mobileqq.utils.ViewUtils;

public class TroopMemberLevelExtender
  extends NickNameLayoutExtender
{
  private TextView a;
  
  public TroopMemberLevelExtender(Context paramContext)
  {
    super(paramContext);
  }
  
  private void a()
  {
    if (this.a == null)
    {
      this.a = new TroopMemberLevelView(this.mContext);
      this.a.setId(2131364673);
      this.a.setTextSize(2, 12.0F);
      this.a.setIncludeFontPadding(false);
      this.a.setPadding(AIOUtils.a(4.0F, this.mContext.getResources()), 0, AIOUtils.a(4.0F, this.mContext.getResources()), 0);
      this.a.setEllipsize(TextUtils.TruncateAt.END);
      this.a.setSingleLine();
      this.a.setGravity(17);
      this.a.setHorizontallyScrolling(false);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
      localLayoutParams.rightMargin = ViewUtils.a(2.0F);
      this.layoutParams = localLayoutParams;
    }
  }
  
  public NickNameExtenderViewBasicAbility getBasicAbility()
  {
    if (this.ability == null) {
      this.ability = new TroopMemberLevelExtender.1(this, this.a);
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
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.basechatitemlayout.TroopMemberLevelExtender
 * JD-Core Version:    0.7.0.1
 */