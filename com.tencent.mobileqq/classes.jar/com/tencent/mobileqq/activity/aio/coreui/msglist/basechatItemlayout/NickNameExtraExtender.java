package com.tencent.mobileqq.activity.aio.coreui.msglist.basechatItemlayout;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.text.style.ImageSpan;
import android.view.View;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;

public class NickNameExtraExtender
  extends NickNameLayoutExtender
{
  private TextView a;
  
  public NickNameExtraExtender(Context paramContext)
  {
    super(paramContext);
  }
  
  private SpannableStringBuilder a(CharSequence paramCharSequence1, TextView paramTextView, int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, CharSequence paramCharSequence2, ColorStateList paramColorStateList, boolean paramBoolean4)
  {
    if ((paramCharSequence1 != null) && ((paramBoolean1) || (paramBoolean2) || (paramBoolean3)))
    {
      paramColorStateList = paramTextView.getEllipsize();
      if (paramColorStateList != null)
      {
        int i = paramInt;
        double d1;
        double d2;
        if (paramBoolean1)
        {
          d1 = paramInt;
          d2 = Math.ceil(BaseChatItemLayout.w * 13.0F);
          Double.isNaN(d1);
          i = (int)(d1 - d2);
        }
        paramInt = i;
        if (paramBoolean2)
        {
          d1 = i;
          d2 = Math.ceil(BaseChatItemLayout.w * 15.0F);
          Double.isNaN(d1);
          paramInt = (int)(d1 - d2);
        }
        if (paramBoolean3) {
          paramInt = AIOUtils.b(136.0F, this.mContext.getResources());
        }
        i = paramInt;
        if (paramInt < 0) {
          i = 0;
        }
        paramCharSequence1 = new SpannableStringBuilder(TextUtils.ellipsize(paramCharSequence1, paramTextView.getPaint(), i, paramColorStateList));
      }
      else
      {
        paramCharSequence1 = new SpannableStringBuilder(paramCharSequence1);
      }
      if (paramBoolean1)
      {
        paramTextView = this.mContext.getResources().getDrawable(2130849312);
        paramTextView.setBounds(0, 0, (int)(BaseChatItemLayout.w * 13.0F), (int)(BaseChatItemLayout.w * 13.0F));
        paramTextView = new ImageSpan(paramTextView, 0);
        paramColorStateList = new SpannableString(" ");
        paramColorStateList.setSpan(paramTextView, 0, 1, 33);
        if ((paramCharSequence1.length() > 1) && (paramCharSequence1.charAt(paramCharSequence1.length() - 1) == ':')) {
          paramCharSequence1.insert(paramCharSequence1.length() - 1, paramColorStateList);
        } else {
          paramCharSequence1.append(paramColorStateList);
        }
      }
      if ((paramBoolean3) && (!TextUtils.isEmpty(paramCharSequence2))) {
        paramCharSequence1.append(paramCharSequence2);
      }
      return paramCharSequence1;
    }
    return null;
  }
  
  private void a()
  {
    if (this.a == null)
    {
      this.a = new TextView(this.mContext);
      this.a.setId(2131430569);
      this.a.setGravity(48);
      this.a.setTextSize(2, 12.0F);
      this.a.setIncludeFontPadding(false);
      this.a.setEllipsize(TextUtils.TruncateAt.END);
      this.a.setSingleLine();
      this.layoutParams = new LinearLayout.LayoutParams(-2, -2);
    }
  }
  
  public BaseChatItemLayoutViewBasicAbility getBasicAbility()
  {
    if (this.ability == null) {
      this.ability = new BaseChatItemLayoutViewBasicAbilityImpl(this.a);
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
    paramNickNameLayoutData = a("", this.a, BaseChatItemLayout.f, paramNickNameLayoutData.d, paramNickNameLayoutData.e, paramNickNameLayoutData.f, paramNickNameLayoutData.g, paramNickNameLayoutData.h, paramNickNameLayoutData.c);
    if (paramNickNameLayoutData != null)
    {
      this.a.setText(paramNickNameLayoutData);
      this.a.setVisibility(0);
      return;
    }
    this.a.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.coreui.msglist.basechatItemlayout.NickNameExtraExtender
 * JD-Core Version:    0.7.0.1
 */