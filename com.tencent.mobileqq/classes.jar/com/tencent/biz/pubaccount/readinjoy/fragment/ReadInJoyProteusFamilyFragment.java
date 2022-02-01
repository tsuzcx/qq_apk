package com.tencent.biz.pubaccount.readinjoy.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import bleh;
import blek;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.utils.ViewUtils;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;
import orn;
import orp;
import pju;
import pjy;
import pqu;
import pzf;
import pzg;
import pzh;
import pzi;
import pzj;

public class ReadInJoyProteusFamilyFragment
  extends IphoneTitleBarFragment
  implements orp, pjy
{
  private Context jdField_a_of_type_AndroidContentContext;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private pzj jdField_a_of_type_Pzj;
  
  private void a()
  {
    if (this.jdField_a_of_type_AndroidContentContext != null)
    {
      this.jdField_a_of_type_Pzj = new pzj((Activity)this.jdField_a_of_type_AndroidContentContext);
      ViewGroup localViewGroup = (ViewGroup)this.mContentView.findViewById(2131373263);
      this.jdField_a_of_type_Pzj.a(localViewGroup);
      b();
    }
  }
  
  private void a(int paramInt)
  {
    if (this.leftView != null)
    {
      this.leftView.setTextColor(paramInt);
      this.leftView.setBackgroundResource(2130849537);
    }
    if (this.centerView != null) {
      this.centerView.setTextColor(paramInt);
    }
  }
  
  private void b()
  {
    setTitle(this.jdField_a_of_type_AndroidContentContext.getString(2131717821));
    pqu.a(getTitleBarView());
    a(-16777216);
    Object localObject = this.rightViewImg;
    if (localObject != null)
    {
      ((ImageView)localObject).setImageResource(2130842897);
      ((ImageView)localObject).setVisibility(0);
      ((ImageView)localObject).setBackgroundResource(0);
      ((ImageView)localObject).setOnClickListener(new pzf(this, (ImageView)localObject));
    }
    localObject = getTitleBarView();
    if (localObject != null) {
      ((View)localObject).setOnClickListener(new pzg(this));
    }
  }
  
  public void a(BaseActivity paramBaseActivity, View paramView)
  {
    ArrayList localArrayList = new ArrayList();
    int[] arrayOfInt = new int[3];
    int[] tmp16_14 = arrayOfInt;
    tmp16_14[0] = 0;
    int[] tmp20_16 = tmp16_14;
    tmp20_16[1] = 1;
    int[] tmp24_20 = tmp20_16;
    tmp24_20[2] = 2;
    tmp24_20;
    String str1 = BaseApplicationImpl.getApplication().getString(2131717821);
    String str2 = BaseApplicationImpl.getApplication().getString(2131717821);
    String str3 = BaseApplicationImpl.getApplication().getString(2131717821);
    int i = 0;
    while (i < arrayOfInt.length)
    {
      blek localblek = new blek();
      localblek.jdField_a_of_type_Int = arrayOfInt[i];
      localblek.jdField_a_of_type_JavaLangString = new String[] { str1, str2, str3 }[i];
      localblek.b = new int[] { 2130842890, 2130842891, 2130842890 }[i];
      localArrayList.add(localblek);
      i += 1;
    }
    i = ViewUtils.dip2px(125.0F);
    bleh.a(paramBaseActivity, localArrayList, new pzh(this), new pzi(this), i, false, -1, 2131755031).showAsDropDown(paramView, -(i - paramView.getWidth()), 0);
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_AndroidWidgetTextView == null) {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
  }
  
  public void a(boolean paramBoolean, List<BaseArticleInfo> paramList)
  {
    if ((paramBoolean) && (paramList != null) && (paramList.size() > 0)) {
      ThreadManager.getUIHandler().post(new ReadInJoyProteusFamilyFragment.1(this, paramList));
    }
  }
  
  public void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    a();
    this.jdField_a_of_type_Pzj.a();
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.mContentView.findViewById(2131366720));
    orn.a().a(8888, this);
  }
  
  public int getContentLayoutId()
  {
    return 2131560300;
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    super.initWindowStyleAndAnimation(paramActivity);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (this.jdField_a_of_type_Pzj != null) {
      this.jdField_a_of_type_Pzj.a(paramInt1, paramInt2, paramIntent);
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_a_of_type_AndroidContentContext = getActivity();
    pju.a().a(this);
    pju.a().a();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    pju.a().b();
    if (this.jdField_a_of_type_Pzj != null) {
      this.jdField_a_of_type_Pzj.d();
    }
    orn.a().b(8888, this);
  }
  
  public void onDetach()
  {
    super.onDetach();
    if (this.jdField_a_of_type_Pzj != null) {
      this.jdField_a_of_type_Pzj.c();
    }
  }
  
  public void onPause()
  {
    super.onPause();
    if (this.jdField_a_of_type_Pzj != null) {
      this.jdField_a_of_type_Pzj.g();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.jdField_a_of_type_Pzj != null) {
      this.jdField_a_of_type_Pzj.h();
    }
    pqu.a(getActivity(), true, pqu.a(getActivity()));
  }
  
  public void onStart()
  {
    super.onStart();
    if (this.jdField_a_of_type_Pzj != null) {
      this.jdField_a_of_type_Pzj.e();
    }
  }
  
  public void onStop()
  {
    super.onStop();
    if (this.jdField_a_of_type_Pzj != null) {
      this.jdField_a_of_type_Pzj.f();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyProteusFamilyFragment
 * JD-Core Version:    0.7.0.1
 */