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
import com.tencent.mobileqq.config.business.qvip.QVipRedNameCardConfig;
import com.tencent.mobileqq.config.business.qvip.QVipRedNameCardProcessor;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.utils.VipUtils;
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
      this.a.setId(2131364651);
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
  
  public NickNameExtenderViewBasicAbility getBasicAbility()
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
  
  public void updateView(NickNameLayoutProcessor.NickNameLayoutData paramNickNameLayoutData)
  {
    this.a.setText(paramNickNameLayoutData.jdField_a_of_type_JavaLangCharSequence);
    this.a.setTag(paramNickNameLayoutData.jdField_a_of_type_JavaLangCharSequence);
    if (paramNickNameLayoutData.jdField_a_of_type_AndroidContentResColorStateList != null) {
      this.a.setTextColor(paramNickNameLayoutData.jdField_a_of_type_AndroidContentResColorStateList);
    }
    boolean bool;
    if ((QVipRedNameCardProcessor.c().a) && (!SimpleUIUtil.a()))
    {
      bool = ((FriendsManager)BaseActivity.sTopActivity.app.getManager(QQManagerFactory.FRIENDS_MANAGER)).c;
      if ((paramNickNameLayoutData.c == 0) || (paramNickNameLayoutData.c == -100)) {
        break label177;
      }
      if (!bool) {
        break label155;
      }
      this.a.setTextColor(this.mContext.getResources().getColor(2131167177));
    }
    for (;;)
    {
      paramNickNameLayoutData = AIOLongShotHelper.a();
      if ((paramNickNameLayoutData == null) || (!paramNickNameLayoutData.a()) || (!paramNickNameLayoutData.b())) {
        break;
      }
      ((ColorNickTextView)this.a).setMosaicEffect(new MosaicEffect(10));
      return;
      label155:
      this.a.setTextColor(this.mContext.getResources().getColor(2131167040));
      continue;
      label177:
      switch (VipUtils.a(paramNickNameLayoutData.jdField_a_of_type_Int))
      {
      default: 
        this.a.setTextColor(this.mContext.getResources().getColor(2131167040));
        break;
      case 1: 
      case 2: 
      case 3: 
      case 4: 
        if (bool) {
          this.a.setTextColor(this.mContext.getResources().getColor(2131167177));
        } else {
          this.a.setTextColor(this.mContext.getResources().getColor(2131167040));
        }
        break;
      }
    }
    ((ColorNickTextView)this.a).setMosaicEffect(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.coreui.msglist.basechatItemlayout.NickNameExtender
 * JD-Core Version:    0.7.0.1
 */