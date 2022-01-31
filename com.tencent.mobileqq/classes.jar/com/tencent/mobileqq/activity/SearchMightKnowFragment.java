package com.tencent.mobileqq.activity;

import adro;
import adrp;
import adrq;
import adrr;
import adrs;
import adrt;
import akfm;
import akfy;
import alpo;
import alro;
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
import azmj;
import azwu;
import bhwu;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.search.activity.ActiveEntitySearchActivity;
import com.tencent.mobileqq.search.view.QuickPinyinEditText;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.SwipListView;
import java.util.ArrayList;

public class SearchMightKnowFragment
  extends PublicBaseFragment
  implements TextWatcher, TextView.OnEditorActionListener
{
  akfm jdField_a_of_type_Akfm = new adrs(this);
  private akfy jdField_a_of_type_Akfy;
  private alro jdField_a_of_type_Alro;
  private ImageButton jdField_a_of_type_AndroidWidgetImageButton;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  bhwu jdField_a_of_type_Bhwu = new adrt(this);
  private TopGestureLayout jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout;
  public QQAppInterface a;
  public QuickPinyinEditText a;
  private SwipListView jdField_a_of_type_ComTencentWidgetSwipListView;
  
  private void a(View paramView)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = getActivity().app;
    this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText = ((QuickPinyinEditText)paramView.findViewById(2131365849));
    this.jdField_a_of_type_ComTencentWidgetSwipListView = ((SwipListView)paramView.findViewById(2131377243));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131369733));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131365759));
    this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)paramView.findViewById(2131367807));
    paramView.findViewById(2131376231).setFocusable(true);
    paramView.findViewById(2131376231).setFocusableInTouchMode(true);
    this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setFocusable(true);
    this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setFocusableInTouchMode(true);
    this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.clearFocus();
    this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setImeOptions(3);
    this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setOnEditorActionListener(this);
    this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.addTextChangedListener(this);
    this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setHint(alpo.a(2131714019));
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setDragEnable(true);
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setRightIconMenuListener(this.jdField_a_of_type_Bhwu);
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setOnTouchListener(new adro(this));
    this.jdField_a_of_type_Akfy = new akfy(getActivity(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentWidgetSwipListView, 10, this.jdField_a_of_type_Akfm);
    int i = getResources().getDimensionPixelSize(2131297295);
    this.jdField_a_of_type_Akfy.a(i);
    this.jdField_a_of_type_Alro = ((alro)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(159));
    ArrayList localArrayList = this.jdField_a_of_type_Alro.c();
    if (!azwu.a()) {
      if (localArrayList.size() > 0)
      {
        this.jdField_a_of_type_Akfy.a(localArrayList);
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(new adrp(this));
      if (ThemeUtil.isNowThemeIsNight(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, null)) {
        paramView.findViewById(2131379429).setBackgroundColor(Color.parseColor("#292929"));
      }
      return;
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_Alro.a(4);
      continue;
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      QLog.d("SearchMightKnowFragment", 2, " STUDY MODE NO RECOMMEND FRIEND");
    }
  }
  
  private void a(String paramString)
  {
    azmj.b(null, "dc00898", "", "", "0X800A338", "0X800A338", 0, 0, "", "", "", "");
    ActiveEntitySearchActivity.a(getActivity(), paramString, alpo.a(2131714018), new long[] { 1001L, 1002L });
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
    View localView = paramView.findViewById(2131363520);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368697));
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new adrq(this));
    localView.setOnClickListener(new adrr(this));
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
    paramLayoutInflater = paramLayoutInflater.inflate(2131562783, paramViewGroup, false);
    b(paramLayoutInflater);
    a(paramLayoutInflater);
    azmj.b(null, "dc00898", "", "", "0X800A337", "0X800A337", 0, 0, "", "", "", "");
    return paramLayoutInflater;
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    if (this.jdField_a_of_type_Akfy != null) {
      this.jdField_a_of_type_Akfy.c();
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
    if (this.jdField_a_of_type_Akfy != null) {
      this.jdField_a_of_type_Akfy.a();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.jdField_a_of_type_Akfy != null) {
      this.jdField_a_of_type_Akfy.b();
    }
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.SearchMightKnowFragment
 * JD-Core Version:    0.7.0.1
 */