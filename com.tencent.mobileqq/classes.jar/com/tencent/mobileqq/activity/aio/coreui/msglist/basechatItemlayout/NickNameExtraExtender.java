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
    if ((paramCharSequence1 == null) || ((!paramBoolean1) && (!paramBoolean2) && (!paramBoolean3)))
    {
      paramTextView = null;
      return paramTextView;
    }
    paramColorStateList = paramTextView.getEllipsize();
    if (paramColorStateList != null)
    {
      if (!paramBoolean1) {
        break label280;
      }
      paramInt = (int)(paramInt - Math.ceil(13.0F * BaseChatItemLayout.d));
    }
    label270:
    label280:
    for (;;)
    {
      int i = paramInt;
      if (paramBoolean2) {
        i = (int)(paramInt - Math.ceil(15.0F * BaseChatItemLayout.d));
      }
      if (paramBoolean3) {
        i = AIOUtils.a(136.0F, this.mContext.getResources());
      }
      paramInt = i;
      if (i < 0) {
        paramInt = 0;
      }
      paramCharSequence1 = new SpannableStringBuilder(TextUtils.ellipsize(paramCharSequence1, paramTextView.getPaint(), paramInt, paramColorStateList));
      label127:
      if (paramBoolean1)
      {
        paramTextView = this.mContext.getResources().getDrawable(2130847785);
        paramTextView.setBounds(0, 0, (int)(13.0F * BaseChatItemLayout.d), (int)(13.0F * BaseChatItemLayout.d));
        paramTextView = new ImageSpan(paramTextView, 0);
        paramColorStateList = new SpannableString(" ");
        paramColorStateList.setSpan(paramTextView, 0, 1, 33);
        if ((paramCharSequence1.length() <= 1) || (paramCharSequence1.charAt(paramCharSequence1.length() - 1) != ':')) {
          break label270;
        }
        paramCharSequence1.insert(paramCharSequence1.length() - 1, paramColorStateList);
      }
      for (;;)
      {
        paramTextView = paramCharSequence1;
        if (!paramBoolean3) {
          break;
        }
        paramTextView = paramCharSequence1;
        if (TextUtils.isEmpty(paramCharSequence2)) {
          break;
        }
        paramCharSequence1.append(paramCharSequence2);
        return paramCharSequence1;
        paramCharSequence1 = new SpannableStringBuilder(paramCharSequence1);
        break label127;
        paramCharSequence1.append(paramColorStateList);
      }
    }
  }
  
  private void a()
  {
    if (this.a == null)
    {
      this.a = new TextView(this.mContext);
      this.a.setId(2131364625);
      this.a.setGravity(48);
      this.a.setTextSize(2, 12.0F);
      this.a.setIncludeFontPadding(false);
      this.a.setEllipsize(TextUtils.TruncateAt.END);
      this.a.setSingleLine();
      this.layoutParams = new LinearLayout.LayoutParams(-2, -2);
    }
  }
  
  public NickNameExtenderViewBasicAbility getBasicAbility()
  {
    if (this.ability == null) {
      this.ability = new NickNameExtenderViewBasicAbilityImpl(this.a);
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
    paramNickNameLayoutData = a("", this.a, BaseChatItemLayout.f, paramNickNameLayoutData.jdField_b_of_type_Boolean, paramNickNameLayoutData.c, paramNickNameLayoutData.d, paramNickNameLayoutData.jdField_b_of_type_JavaLangCharSequence, paramNickNameLayoutData.jdField_b_of_type_AndroidContentResColorStateList, paramNickNameLayoutData.a);
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