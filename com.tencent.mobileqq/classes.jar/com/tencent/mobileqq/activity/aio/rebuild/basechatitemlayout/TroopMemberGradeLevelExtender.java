package com.tencent.mobileqq.activity.aio.rebuild.basechatitemlayout;

import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.activity.aio.coreui.msglist.basechatItemlayout.NickNameExtenderViewBasicAbility;
import com.tencent.mobileqq.activity.aio.coreui.msglist.basechatItemlayout.NickNameLayoutExtender;
import com.tencent.mobileqq.troop.troopgame.TroopMemberGradeLevelView;

public class TroopMemberGradeLevelExtender
  extends NickNameLayoutExtender
{
  private TroopMemberGradeLevelView a;
  
  public TroopMemberGradeLevelExtender(Context paramContext)
  {
    super(paramContext);
  }
  
  private NickNameExtenderViewBasicAbility a()
  {
    return new TroopMemberGradeLevelExtender.1(this, this.a);
  }
  
  private void a()
  {
    if (this.a == null)
    {
      this.a = new TroopMemberGradeLevelView(this.mContext);
      this.a.setId(2131364671);
    }
  }
  
  public NickNameExtenderViewBasicAbility getBasicAbility()
  {
    if (this.ability == null) {
      this.ability = a();
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
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.basechatitemlayout.TroopMemberGradeLevelExtender
 * JD-Core Version:    0.7.0.1
 */