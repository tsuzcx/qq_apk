package com.tencent.mobileqq.activity;

import aevr;
import aevs;
import aevt;
import aevu;
import aevv;
import aevw;
import amii;
import amiw;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import anvx;
import anyb;
import bdla;
import bdvn;
import blfe;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.search.activity.ActiveEntitySearchActivity;
import com.tencent.mobileqq.search.view.QuickPinyinEditText;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.widget.SwipListView;
import java.util.ArrayList;

public class SearchMightKnowFragment
  extends PublicBaseFragment
  implements TextWatcher, TextView.OnEditorActionListener
{
  amii jdField_a_of_type_Amii = new aevv(this);
  private amiw jdField_a_of_type_Amiw;
  private ImageButton jdField_a_of_type_AndroidWidgetImageButton;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private anyb jdField_a_of_type_Anyb;
  blfe jdField_a_of_type_Blfe = new aevw(this);
  private TopGestureLayout jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout;
  public QQAppInterface a;
  public QuickPinyinEditText a;
  private SwipListView jdField_a_of_type_ComTencentWidgetSwipListView;
  
  private void a(View paramView)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = getActivity().app;
    this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText = ((QuickPinyinEditText)paramView.findViewById(2131366280));
    this.jdField_a_of_type_ComTencentWidgetSwipListView = ((SwipListView)paramView.findViewById(2131378323));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131370431));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131366179));
    this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)paramView.findViewById(2131368378));
    paramView.findViewById(2131377225).setFocusable(true);
    paramView.findViewById(2131377225).setFocusableInTouchMode(true);
    this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setFocusable(true);
    this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setFocusableInTouchMode(true);
    this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.clearFocus();
    this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setImeOptions(3);
    this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setOnEditorActionListener(this);
    this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.addTextChangedListener(this);
    this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setHint(anvx.a(2131713098));
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setDragEnable(true);
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setRightIconMenuListener(this.jdField_a_of_type_Blfe);
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setOnTouchListener(new aevr(this));
    this.jdField_a_of_type_Amiw = new amiw(getActivity(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentWidgetSwipListView, 10, this.jdField_a_of_type_Amii);
    int i = getResources().getDimensionPixelSize(2131297426);
    this.jdField_a_of_type_Amiw.a(i);
    this.jdField_a_of_type_Anyb = ((anyb)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MAYKNOW_RECOMMEND_MANAGER));
    ArrayList localArrayList = this.jdField_a_of_type_Anyb.c();
    if (!bdvn.a()) {
      if (localArrayList.size() > 0)
      {
        this.jdField_a_of_type_Amiw.a(localArrayList);
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(new aevs(this));
      if (ThemeUtil.isNowThemeIsNight(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, null)) {
        paramView.findViewById(2131380663).setBackgroundColor(Color.parseColor("#292929"));
      }
      return;
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_Anyb.a(4);
      continue;
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      QLog.d("SearchMightKnowFragment", 2, " STUDY MODE NO RECOMMEND FRIEND");
    }
  }
  
  private void a(String paramString)
  {
    bdla.b(null, "dc00898", "", "", "0X800A338", "0X800A338", 0, 0, "", "", "", "");
    ActiveEntitySearchActivity.a(getActivity(), paramString, anvx.a(2131713097), new long[] { 1001L, 1002L });
  }
  
  private void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout == null)
    {
      ViewGroup localViewGroup = (ViewGroup)getActivity().getWindow().getDecorView();
      View localView = localViewGroup.getChildAt(0);
      Object localObject = localViewGroup;
      if (localView != null)
      {
        localObject = localViewGroup;
        if ((localView instanceof DragFrameLayout)) {
          localObject = (ViewGroup)localView;
        }
      }
      localObject = ((ViewGroup)localObject).getChildAt(0);
      if ((localObject instanceof TopGestureLayout)) {
        this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout = ((TopGestureLayout)localObject);
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.setInterceptTouchFlag(paramBoolean);
    }
  }
  
  private void b(View paramView)
  {
    View localView = paramView.findViewById(2131363845);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131369324));
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new aevt(this));
    localView.setOnClickListener(new aevu(this));
  }
  
  public void a()
  {
    ((InputMethodManager)BaseApplicationImpl.getContext().getSystemService("input_method")).hideSoftInputFromWindow(this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.getWindowToken(), 0);
    this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.clearFocus();
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.length() == 0)
    {
      this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(4);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(0);
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131563029, paramViewGroup, false);
    b(paramLayoutInflater);
    a(paramLayoutInflater);
    bdla.b(null, "dc00898", "", "", "0X800A337", "0X800A337", 0, 0, "", "", "", "");
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    if (this.jdField_a_of_type_Amiw != null) {
      this.jdField_a_of_type_Amiw.c();
    }
  }
  
  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 3)
    {
      paramTextView = this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.getText().toString().trim();
      a();
      if ((paramTextView != null) && (!paramTextView.equals(""))) {
        a(paramTextView);
      }
      return true;
    }
    return false;
  }
  
  public void onPause()
  {
    super.onPause();
    if (this.jdField_a_of_type_Amiw != null) {
      this.jdField_a_of_type_Amiw.a();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.jdField_a_of_type_Amiw != null) {
      this.jdField_a_of_type_Amiw.b();
    }
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.SearchMightKnowFragment
 * JD-Core Version:    0.7.0.1
 */