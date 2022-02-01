package com.tencent.mobileqq.activity.aio.coreui.msglist.basechatItemlayout;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.helper.AIOLongShotHelper;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vas.config.business.qvip.QVipRedNameCardConfig;
import com.tencent.mobileqq.vas.config.business.qvip.QVipRedNameCardProcessor;
import com.tencent.mobileqq.widget.ColorNickTextView;
import com.tencent.mobileqq.widget.MosaicEffect;

public class NickNameExtender
  extends NickNameLayoutExtender
{
  private TextView a;
  
  public NickNameExtender(Context paramContext)
  {
    super(paramContext);
  }
  
  private void a()
  {
    if (this.a == null)
    {
      this.a = new ColorNickTextView(this.mContext);
      this.a.setId(2131430595);
      this.a.setGravity(48);
      this.a.setTextSize(2, 12.0F);
      this.a.setIncludeFontPadding(false);
      this.a.setEllipsize(TextUtils.TruncateAt.END);
      this.a.setSingleLine();
      this.a.setMaxWidth(BaseChatItemLayout.f);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
      localLayoutParams.weight = 1.0F;
      this.layoutParams = localLayoutParams;
    }
  }
  
  public BaseChatItemLayoutViewBasicAbility getBasicAbility()
  {
    if (this.ability == null) {
      this.ability = new NickNameExtender.1(this, this.a);
    }
    return this.ability;
  }
  
  public View getView()
  {
    a();
    return this.a;
  }
  
  public void updateView(NickNameChatItemLayoutProcessor.NickNameLayoutData paramNickNameLayoutData)
  {
    this.a.setText(paramNickNameLayoutData.a);
    this.a.setTag(paramNickNameLayoutData.a);
    if (paramNickNameLayoutData.b != null) {
      this.a.setTextColor(paramNickNameLayoutData.b);
    }
    if ((QVipRedNameCardProcessor.e().a) && (!SimpleUIUtil.e()))
    {
      boolean bool = ((FriendsManager)BaseActivity.sTopActivity.app.getManager(QQManagerFactory.FRIENDS_MANAGER)).t;
      if ((paramNickNameLayoutData.l != 0) && (paramNickNameLayoutData.l != -100))
      {
        if (bool) {
          this.a.setTextColor(this.mContext.getResources().getColor(2131168187));
        } else {
          this.a.setTextColor(this.mContext.getResources().getColor(2131168001));
        }
      }
      else
      {
        int i = VipUtils.b(paramNickNameLayoutData.j);
        if ((i != 1) && (i != 2) && (i != 3) && (i != 4)) {
          this.a.setTextColor(this.mContext.getResources().getColor(2131168001));
        } else if (bool) {
          this.a.setTextColor(this.mContext.getResources().getColor(2131168187));
        } else {
          this.a.setTextColor(this.mContext.getResources().getColor(2131168001));
        }
      }
    }
    paramNickNameLayoutData = AIOLongShotHelper.f();
    if ((paramNickNameLayoutData != null) && (paramNickNameLayoutData.c()) && (paramNickNameLayoutData.d()))
    {
      ((ColorNickTextView)this.a).setMosaicEffect(new MosaicEffect(10));
      return;
    }
    ((ColorNickTextView)this.a).setMosaicEffect(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.coreui.msglist.basechatItemlayout.NickNameExtender
 * JD-Core Version:    0.7.0.1
 */