package com.tencent.biz.pubaccount.readinjoy.fragment;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import anzj;
import com.tencent.biz.pubaccount.VideoAdInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.AdData;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.widget.navbar.NavBarCommon;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.os.MqqHandler;
import nzq;
import ozs;
import rcl;
import tlx;
import tqb;

public class ReadInJoyUninterestComplainFragment
  extends IphoneTitleBarFragment
  implements TextWatcher, View.OnClickListener
{
  private int jdField_a_of_type_Int;
  private Parcelable jdField_a_of_type_AndroidOsParcelable;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private EditText jdField_a_of_type_AndroidWidgetEditText;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private EditText b;
  
  private void a(String paramString1, String paramString2)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString(nzq.a, paramString2);
    localBundle.putString(nzq.b, paramString1);
    switch (this.jdField_a_of_type_Int)
    {
    default: 
      return;
    case 1: 
      paramString1 = (AdvertisementInfo)this.jdField_a_of_type_AndroidOsParcelable;
      if (ozs.a(paramString1)) {}
      for (int i = nzq.S;; i = nzq.N)
      {
        nzq.a(new tlx().a(getActivity()).a(nzq.c).b(i).a(paramString1).a(localBundle).a());
        return;
      }
    case 2: 
      paramString1 = (VideoAdInfo)this.jdField_a_of_type_AndroidOsParcelable;
      nzq.a(new tlx().a(getActivity()).a(nzq.c).b(nzq.R).a(nzq.a(paramString1)).a(paramString1).a(localBundle).a());
      return;
    }
    paramString1 = (AdData)this.jdField_a_of_type_AndroidOsParcelable;
    nzq.a(new tlx().a(getActivity()).a(nzq.c).b(nzq.M).a(tqb.a(paramString1)).a(localBundle).a());
  }
  
  private void b()
  {
    this.vg.changeBg(true);
    if (this.leftView != null) {
      this.leftView.setText(anzj.a(2131711680));
    }
    setTitle(anzj.a(2131711697));
    if (ThemeUtil.isInNightMode(ozs.a())) {
      View.inflate(getActivity(), 2131560238, this.titleRoot);
    }
  }
  
  private void c()
  {
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)this.mContentView.findViewById(2131364925));
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.mContentView.findViewById(2131365148));
    this.b = ((EditText)this.mContentView.findViewById(2131372459));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.mContentView.findViewById(2131378183));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
  }
  
  private void d()
  {
    this.jdField_a_of_type_Int = getArguments().getInt("key_from_type", 0);
    this.jdField_a_of_type_AndroidOsParcelable = getArguments().getParcelable("key_ad_info");
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyUninterestComplainFragment", 2, "initData fromType:" + this.jdField_a_of_type_Int + ", adinfo:" + this.jdField_a_of_type_AndroidOsParcelable);
    }
    switch (this.jdField_a_of_type_Int)
    {
    default: 
      onBackEvent();
    }
    do
    {
      do
      {
        do
        {
          return;
        } while ((this.jdField_a_of_type_AndroidOsParcelable instanceof AdvertisementInfo));
        if (QLog.isColorLevel()) {
          QLog.e("ReadInJoyUninterestComplainFragment", 2, "adinfo is not AdvertisementInfo");
        }
        onBackEvent();
        return;
      } while ((this.jdField_a_of_type_AndroidOsParcelable instanceof VideoAdInfo));
      if (QLog.isColorLevel()) {
        QLog.e("ReadInJoyUninterestComplainFragment", 2, "adinfo is not VideoAdInfo");
      }
      onBackEvent();
      return;
    } while ((this.jdField_a_of_type_AndroidOsParcelable instanceof AdData));
    if (QLog.isColorLevel()) {
      QLog.e("ReadInJoyUninterestComplainFragment", 2, "adinfo is not AdData");
    }
    onBackEvent();
  }
  
  private void e()
  {
    View localView = getActivity().getCurrentFocus();
    if (((InputMethodManager)getActivity().getSystemService("input_method")).showSoftInput(localView, 0)) {
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyUninterestComplainFragment", 2, "showKeyboard success");
      }
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.e("ReadInJoyUninterestComplainFragment", 2, "showKeyboard fail");
  }
  
  private void f()
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("key_ad_info", this.jdField_a_of_type_AndroidOsParcelable);
    getActivity().setResult(-1, localIntent);
  }
  
  public void a()
  {
    View localView = getActivity().getCurrentFocus();
    if (localView != null) {
      ((InputMethodManager)getActivity().getSystemService("input_method")).hideSoftInputFromWindow(localView.getWindowToken(), 0);
    }
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    paramEditable = paramEditable.toString();
    this.jdField_a_of_type_AndroidWidgetTextView.setText(String.valueOf(getResources().getInteger(2131427366) - paramEditable.length()));
    if (paramEditable.trim().length() > 0)
    {
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    b();
    c();
    d();
  }
  
  public int getContentLayoutId()
  {
    return 2131560299;
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    getActivity().getWindow().setSoftInputMode(1);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      a();
      String str1 = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString().trim();
      String str2 = this.b.getText().toString().trim();
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyUninterestComplainFragment", 2, "onSubmitClick complaints:" + str1);
      }
      a(str1, str2);
      f();
      onBackEvent();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    rcl.a(this);
    ThreadManager.getUIHandler().postDelayed(new ReadInJoyUninterestComplainFragment.1(this), 300L);
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyUninterestComplainFragment
 * JD-Core Version:    0.7.0.1
 */