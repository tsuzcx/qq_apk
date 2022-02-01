package com.tencent.biz.pubaccount;

import android.content.res.Resources;
import android.graphics.Paint;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.pubaccount.accountdetail.api.impl.PublicAccountDetailImpl;
import com.tencent.biz.pubaccount.accountdetail.view.AccountDetailTopGestureLayout;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountUtilImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.face.FaceDrawable;

public class AccountMoreDetailController
  implements View.OnClickListener
{
  protected float a;
  int jdField_a_of_type_Int = 0;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  Button jdField_a_of_type_AndroidWidgetButton;
  public ImageView a;
  public RelativeLayout a;
  public TextView a;
  private PublicAccountDetailImpl jdField_a_of_type_ComTencentBizPubaccountAccountdetailApiImplPublicAccountDetailImpl;
  protected AccountDetailTopGestureLayout a;
  private BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  public boolean a;
  protected int b;
  private ViewGroup jdField_b_of_type_AndroidViewViewGroup;
  public ImageView b;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  public ImageView c;
  ImageView d;
  protected ImageView e;
  
  public AccountMoreDetailController(BaseActivity paramBaseActivity, View.OnClickListener paramOnClickListener, ViewGroup paramViewGroup)
  {
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    this.jdField_b_of_type_AndroidViewViewGroup = paramViewGroup;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
    a();
  }
  
  private void a()
  {
    this.jdField_a_of_type_Float = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDisplayMetrics().density;
    b();
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131361929));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131361928));
    this.jdField_a_of_type_AndroidWidgetTextView.setSingleLine();
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-16777216);
  }
  
  private boolean a()
  {
    return Build.VERSION.SDK_INT < 19;
  }
  
  private void b()
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131370013));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(null);
    float f1;
    int i;
    float f2;
    if (a())
    {
      f1 = this.jdField_a_of_type_Float;
      i = (int)(64.0F * f1);
      f2 = 4.0F;
    }
    else
    {
      f1 = this.jdField_a_of_type_Float;
      i = (int)(75.0F * f1);
      f2 = 25.0F;
    }
    int j = (int)(f1 * f2);
    Object localObject = new RelativeLayout.LayoutParams(-1, i);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setPadding(0, j, 0, 0);
    this.jdField_a_of_type_Int = i;
    localObject = this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailViewAccountDetailTopGestureLayout;
    if (localObject != null) {
      ((AccountDetailTopGestureLayout)localObject).setTitleHeight(this.jdField_a_of_type_Int);
    }
    this.d = ((ImageView)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131370012));
    this.d.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131369233));
    this.jdField_b_of_type_AndroidWidgetTextView.setText("");
    this.e = ((ImageView)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131369216));
    this.e.setImageResource(2130843861);
    this.e.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131697523));
    this.e.setVisibility(0);
    this.e.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131368383));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131368355));
    this.c = ((ImageView)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131364430));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131361897));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.d.setImageResource(2130850440);
    this.e.setImageResource(2130842551);
  }
  
  public void a(PublicAccountDetailImpl paramPublicAccountDetailImpl)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailApiImplPublicAccountDetailImpl = paramPublicAccountDetailImpl;
    this.jdField_a_of_type_AndroidViewViewGroup.removeAllViews();
    if (this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailApiImplPublicAccountDetailImpl == null) {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(FaceDrawable.getFaceDrawable(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, 1, this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailApiImplPublicAccountDetailImpl.uin));
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
    this.c.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailApiImplPublicAccountDetailImpl.name);
    paramPublicAccountDetailImpl = new Paint();
    paramPublicAccountDetailImpl.setTextSize(this.jdField_a_of_type_AndroidWidgetTextView.getTextSize());
    Object localObject = this.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject).width = ((int)((int)paramPublicAccountDetailImpl.measureText(this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailApiImplPublicAccountDetailImpl.name) + this.jdField_a_of_type_Float * 4.0F));
    this.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    paramPublicAccountDetailImpl = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    String str = this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailApiImplPublicAccountDetailImpl.certifiedDescription;
    if ((!TextUtils.isEmpty(str)) && (str.contains(":")))
    {
      int j = str.indexOf(":");
      localObject = str.substring(0, j);
      int i = str.length();
      j += 1;
      if (i > j)
      {
        str = str.substring(j);
        this.jdField_a_of_type_AndroidViewViewGroup.addView(new AccountMoreDetailController.DetailItemGenerator(paramPublicAccountDetailImpl, null, (String)localObject, str).a());
      }
    }
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailApiImplPublicAccountDetailImpl.summary)) {
      this.jdField_a_of_type_AndroidViewViewGroup.addView(new AccountMoreDetailController.DetailItemGenerator(paramPublicAccountDetailImpl, null, "信息简介", this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailApiImplPublicAccountDetailImpl.summary).a());
    }
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailApiImplPublicAccountDetailImpl.certifiedEnterprise)) {
      this.jdField_a_of_type_AndroidViewViewGroup.addView(new AccountMoreDetailController.DetailItemGenerator(paramPublicAccountDetailImpl, null, "认证来源", this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailApiImplPublicAccountDetailImpl.certifiedEnterprise).a());
    }
    localObject = PublicAccountUtilImpl.pickOutFreakingPhoneNumber(this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailApiImplPublicAccountDetailImpl);
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      this.jdField_a_of_type_AndroidViewViewGroup.addView(new AccountMoreDetailController.DetailItemGenerator(paramPublicAccountDetailImpl, null, "联系电话", (String)localObject).a());
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131370012)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.doOnBackPressed();
      return;
    }
    this.jdField_a_of_type_AndroidViewView$OnClickListener.onClick(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.AccountMoreDetailController
 * JD-Core Version:    0.7.0.1
 */