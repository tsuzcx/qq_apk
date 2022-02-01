package com.tencent.mobileqq.apollo.store;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

public class ApolloDiyTextFragment
  extends PublicBaseFragment
  implements TextWatcher, View.OnClickListener
{
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private ApolloDiyTextFragment.DisablePasteEditTextView jdField_a_of_type_ComTencentMobileqqApolloStoreApolloDiyTextFragment$DisablePasteEditTextView;
  boolean jdField_a_of_type_Boolean = false;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  boolean jdField_b_of_type_Boolean = false;
  
  public void afterTextChanged(Editable paramEditable) {}
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    super.initWindowStyleAndAnimation(paramActivity);
    paramActivity.getWindow().setFlags(1024, 1024);
    paramActivity.getWindow().setSoftInputMode(17);
    paramActivity.overridePendingTransition(0, 0);
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public boolean needImmersive()
  {
    return false;
  }
  
  public boolean needStatusTrans()
  {
    return false;
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    ApolloDiyTextFragment.AndroidBug5497Workaround.a(super.getBaseActivity());
  }
  
  public void onClick(View paramView)
  {
    ImageView localImageView = this.jdField_b_of_type_AndroidWidgetImageView;
    String str = "";
    if (paramView == localImageView)
    {
      paramView = this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloDiyTextFragment$DisablePasteEditTextView.getText();
      if ((paramView != null) && (paramView.length() > 0)) {
        if (paramView.length() > 12)
        {
          QQToast.a(super.getBaseActivity(), HardCodeUtil.a(2131700543), 0).a();
        }
        else
        {
          paramView = new Intent();
          paramView.putExtra("ret", 1);
          if (this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloDiyTextFragment$DisablePasteEditTextView.getText() != null) {
            str = this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloDiyTextFragment$DisablePasteEditTextView.getText().toString();
          }
          paramView.putExtra("text", str);
          super.getBaseActivity().setResult(-1, paramView);
          super.getBaseActivity().finish();
        }
      }
      VipUtils.a(null, "cmshow", "Apollo", "ConfirmClick", 0, 0, new String[0]);
      return;
    }
    if (paramView == this.jdField_a_of_type_AndroidWidgetImageView)
    {
      paramView = new Intent();
      paramView.putExtra("ret", 0);
      if (this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloDiyTextFragment$DisablePasteEditTextView.getText() != null) {
        str = this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloDiyTextFragment$DisablePasteEditTextView.getText().toString();
      }
      paramView.putExtra("text", str);
      super.getBaseActivity().setResult(0, paramView);
      VipUtils.a(null, "cmshow", "Apollo", "CancelClick", 0, 0, new String[0]);
      super.getBaseActivity().finish();
      return;
    }
    if (paramView == this.jdField_a_of_type_AndroidWidgetTextView)
    {
      this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloDiyTextFragment$DisablePasteEditTextView.setText("");
      this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloDiyTextFragment$DisablePasteEditTextView.setHint(" ");
      VipUtils.a(null, "cmshow", "Apollo", "ClearClick", 0, 0, new String[0]);
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    paramLayoutInflater = super.getBaseActivity();
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = new RelativeLayout(paramLayoutInflater);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundColor(-1778384896);
    this.jdField_b_of_type_AndroidWidgetTextView = new TextView(paramLayoutInflater);
    this.jdField_b_of_type_AndroidWidgetTextView.setTextSize(14.0F);
    this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-1);
    paramViewGroup = new RelativeLayout.LayoutParams(-2, -2);
    paramViewGroup.addRule(14, -1);
    paramViewGroup.addRule(12, -1);
    paramViewGroup.bottomMargin = AIOUtils.b(80.0F, getResources());
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_b_of_type_AndroidWidgetTextView, paramViewGroup);
    paramViewGroup = new RelativeLayout(paramLayoutInflater);
    paramBundle = new RelativeLayout.LayoutParams(-1, -1);
    paramBundle.bottomMargin = AIOUtils.b(44.0F, getResources());
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(paramViewGroup, paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloDiyTextFragment$DisablePasteEditTextView = new ApolloDiyTextFragment.DisablePasteEditTextView(paramLayoutInflater);
    this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloDiyTextFragment$DisablePasteEditTextView.setCursorVisible(true);
    this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloDiyTextFragment$DisablePasteEditTextView.setTextSize(24.0F);
    this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloDiyTextFragment$DisablePasteEditTextView.setTextColor(-1);
    this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloDiyTextFragment$DisablePasteEditTextView.setHintTextColor(-1);
    this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloDiyTextFragment$DisablePasteEditTextView.setHint(HardCodeUtil.a(2131700547));
    this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloDiyTextFragment$DisablePasteEditTextView.setBackgroundColor(0);
    this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloDiyTextFragment$DisablePasteEditTextView.addTextChangedListener(this);
    this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloDiyTextFragment$DisablePasteEditTextView.setSingleLine(false);
    this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloDiyTextFragment$DisablePasteEditTextView.setSelection(0);
    paramBundle = new RelativeLayout.LayoutParams(-2, -2);
    paramBundle.addRule(13, -1);
    paramViewGroup.addView(this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloDiyTextFragment$DisablePasteEditTextView, paramBundle);
    float f = this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloDiyTextFragment$DisablePasteEditTextView.getPaint().measureText(HardCodeUtil.a(2131700546));
    this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloDiyTextFragment$DisablePasteEditTextView.setMaxWidth((int)(f + 1.0F));
    paramViewGroup = new RelativeLayout(paramLayoutInflater);
    paramBundle = new View(paramLayoutInflater);
    paramBundle.setBackgroundColor(-460552);
    new RelativeLayout.LayoutParams(-1, AIOUtils.b(1.0F, getResources())).addRule(10, -1);
    paramViewGroup.addView(paramBundle);
    paramBundle = new View(paramLayoutInflater);
    paramBundle.setBackgroundColor(-460552);
    new RelativeLayout.LayoutParams(-1, AIOUtils.b(1.0F, getResources())).addRule(12, -1);
    paramViewGroup.addView(paramBundle);
    this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(paramLayoutInflater);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130838427);
    paramBundle = new RelativeLayout.LayoutParams(-2, -2);
    paramBundle.addRule(15);
    paramBundle.addRule(9);
    paramBundle.leftMargin = AIOUtils.b(15.0F, getResources());
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    paramViewGroup.addView(this.jdField_a_of_type_AndroidWidgetImageView, paramBundle);
    this.jdField_b_of_type_AndroidWidgetImageView = new ImageView(paramLayoutInflater);
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
    paramBundle = new RelativeLayout.LayoutParams(-2, -2);
    paramBundle.addRule(15);
    paramBundle.addRule(11);
    paramBundle.rightMargin = AIOUtils.b(10.0F, getResources());
    paramViewGroup.addView(this.jdField_b_of_type_AndroidWidgetImageView, paramBundle);
    this.jdField_a_of_type_AndroidWidgetTextView = new TextView(paramLayoutInflater);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131700545));
    this.jdField_a_of_type_AndroidWidgetTextView.setGravity(17);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(16.0F);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-16777216);
    paramBundle = new RelativeLayout.LayoutParams(-2, -1);
    paramBundle.addRule(13);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    paramViewGroup.addView(this.jdField_a_of_type_AndroidWidgetTextView, paramBundle);
    paramBundle = new RelativeLayout.LayoutParams(-1, AIOUtils.b(43.0F, getResources()));
    paramBundle.addRule(12, -1);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(paramViewGroup, paramBundle);
    paramLayoutInflater = paramLayoutInflater.getIntent().getStringExtra("extra_key_last_text");
    if (!TextUtils.isEmpty(paramLayoutInflater))
    {
      this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloDiyTextFragment$DisablePasteEditTextView.setGravity(17);
      this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloDiyTextFragment$DisablePasteEditTextView.setText(paramLayoutInflater);
      this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloDiyTextFragment$DisablePasteEditTextView.a(paramLayoutInflater.length());
      int i = 12 - paramLayoutInflater.length();
      paramLayoutInflater = this.jdField_b_of_type_AndroidWidgetTextView;
      paramViewGroup = new StringBuilder();
      paramViewGroup.append(HardCodeUtil.a(2131700544));
      paramViewGroup.append(i);
      paramViewGroup.append(HardCodeUtil.a(2131700542));
      paramLayoutInflater.setText(paramViewGroup.toString());
      if (i < 0) {
        this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-65536);
      }
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-1);
      this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130838429);
    }
    else
    {
      this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloDiyTextFragment$DisablePasteEditTextView.setGravity(3);
      this.jdField_b_of_type_AndroidWidgetTextView.setText("还可以输入12个字");
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-1);
      this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130838428);
    }
    paramLayoutInflater = new AlphaAnimation(0.0F, 1.0F);
    paramLayoutInflater.setDuration(500L);
    paramLayoutInflater.setFillAfter(true);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.startAnimation(paramLayoutInflater);
    VipUtils.a(null, "cmshow", "Apollo", "PageView", 1, 0, new String[0]);
    return this.jdField_a_of_type_AndroidWidgetRelativeLayout;
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramCharSequence != null) && (paramCharSequence.length() > 0))
    {
      this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloDiyTextFragment$DisablePasteEditTextView.setHint(" ");
      String str = paramCharSequence.toString();
      if (QLog.isColorLevel())
      {
        paramCharSequence = new StringBuilder();
        paramCharSequence.append("onTextChanged:");
        paramCharSequence.append(str);
        paramCharSequence.append(" newStr:");
        paramCharSequence.append(str);
        QLog.d("[cmshow]ApolloDiyTextActivity", 2, paramCharSequence.toString());
      }
      paramInt1 = str.length();
      paramInt2 = this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloDiyTextFragment$DisablePasteEditTextView.getSelectionEnd();
      if (paramInt1 > 50)
      {
        paramCharSequence = str.substring(0, 50);
        if (!this.jdField_b_of_type_Boolean)
        {
          this.jdField_b_of_type_Boolean = true;
          VipUtils.a(null, "cmshow", "Apollo", "reach50", 0, 0, new String[0]);
        }
        paramInt1 = 50;
      }
      else
      {
        if (paramInt1 < 50) {
          this.jdField_b_of_type_Boolean = false;
        }
        paramCharSequence = str;
      }
      TextView localTextView = this.jdField_b_of_type_AndroidWidgetTextView;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(HardCodeUtil.a(2131700541));
      localStringBuilder.append(12 - paramInt1);
      localStringBuilder.append(HardCodeUtil.a(2131700540));
      localTextView.setText(localStringBuilder.toString());
      if (paramInt1 > 12)
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-65536);
        if (!this.jdField_a_of_type_Boolean)
        {
          this.jdField_a_of_type_Boolean = true;
          VipUtils.a(null, "cmshow", "Apollo", "over12", 0, 0, new String[0]);
        }
      }
      else
      {
        this.jdField_a_of_type_Boolean = false;
        this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-1);
      }
      paramInt1 = paramInt2;
      if (paramInt2 >= paramCharSequence.length()) {
        paramInt1 = paramCharSequence.length();
      }
      if (!str.equals(paramCharSequence))
      {
        this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloDiyTextFragment$DisablePasteEditTextView.removeTextChangedListener(this);
        this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloDiyTextFragment$DisablePasteEditTextView.setText(paramCharSequence);
        this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloDiyTextFragment$DisablePasteEditTextView.setSelection(paramInt1);
        this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloDiyTextFragment$DisablePasteEditTextView.addTextChangedListener(this);
      }
    }
    else
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setText("还可以输入12个字");
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-1);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloDiyTextFragment$DisablePasteEditTextView.getText() != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloDiyTextFragment$DisablePasteEditTextView.getText().length() > 0))
    {
      this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloDiyTextFragment$DisablePasteEditTextView.setGravity(17);
      paramCharSequence = this.jdField_b_of_type_AndroidWidgetImageView;
      if (paramCharSequence != null) {
        paramCharSequence.setImageResource(2130838429);
      }
    }
    else
    {
      this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloDiyTextFragment$DisablePasteEditTextView.setGravity(3);
      paramCharSequence = this.jdField_b_of_type_AndroidWidgetImageView;
      if (paramCharSequence != null) {
        paramCharSequence.setImageResource(2130838428);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.store.ApolloDiyTextFragment
 * JD-Core Version:    0.7.0.1
 */