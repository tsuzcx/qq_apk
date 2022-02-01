package com.tencent.mobileqq.activity;

import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
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
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.adapter.MayKnowAdapter.OnRecommendsCanceledListener;
import com.tencent.mobileqq.adapter.RecommendFriendAdapter;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.MayknowRecommendManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.search.activity.ActiveEntitySearchActivity;
import com.tencent.mobileqq.search.view.QuickPinyinEditText;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.widget.SwipListView;
import com.tencent.widget.SwipListView.RightIconMenuListener;
import java.util.ArrayList;

public class SearchMightKnowFragment
  extends PublicBaseFragment
  implements TextWatcher, TextView.OnEditorActionListener
{
  private ImageButton jdField_a_of_type_AndroidWidgetImageButton;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout = null;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private TopGestureLayout jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout;
  MayKnowAdapter.OnRecommendsCanceledListener jdField_a_of_type_ComTencentMobileqqAdapterMayKnowAdapter$OnRecommendsCanceledListener = new SearchMightKnowFragment.5(this);
  private RecommendFriendAdapter jdField_a_of_type_ComTencentMobileqqAdapterRecommendFriendAdapter;
  private MayknowRecommendManager jdField_a_of_type_ComTencentMobileqqAppMayknowRecommendManager;
  public QQAppInterface a;
  public QuickPinyinEditText a;
  SwipListView.RightIconMenuListener jdField_a_of_type_ComTencentWidgetSwipListView$RightIconMenuListener = new SearchMightKnowFragment.6(this);
  private SwipListView jdField_a_of_type_ComTencentWidgetSwipListView = null;
  
  public SearchMightKnowFragment()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
  }
  
  private void a(View paramView)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = getBaseActivity().app;
    this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText = ((QuickPinyinEditText)paramView.findViewById(2131366333));
    this.jdField_a_of_type_ComTencentWidgetSwipListView = ((SwipListView)paramView.findViewById(2131378144));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131370347));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131366238));
    this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)paramView.findViewById(2131368340));
    paramView.findViewById(2131377084).setFocusable(true);
    paramView.findViewById(2131377084).setFocusableInTouchMode(true);
    this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setFocusable(true);
    this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setFocusableInTouchMode(true);
    this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.clearFocus();
    this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setImeOptions(3);
    this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setOnEditorActionListener(this);
    this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.addTextChangedListener(this);
    this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setHint(HardCodeUtil.a(2131713561));
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setDragEnable(true);
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setRightIconMenuListener(this.jdField_a_of_type_ComTencentWidgetSwipListView$RightIconMenuListener);
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setOnTouchListener(new SearchMightKnowFragment.1(this));
    this.jdField_a_of_type_ComTencentMobileqqAdapterRecommendFriendAdapter = new RecommendFriendAdapter(getBaseActivity(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentWidgetSwipListView, 10, this.jdField_a_of_type_ComTencentMobileqqAdapterMayKnowAdapter$OnRecommendsCanceledListener);
    int i = getResources().getDimensionPixelSize(2131297483);
    this.jdField_a_of_type_ComTencentMobileqqAdapterRecommendFriendAdapter.a(i);
    this.jdField_a_of_type_ComTencentMobileqqAppMayknowRecommendManager = ((MayknowRecommendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MAYKNOW_RECOMMEND_MANAGER));
    ArrayList localArrayList = this.jdField_a_of_type_ComTencentMobileqqAppMayknowRecommendManager.c();
    if (!StudyModeManager.a())
    {
      if (localArrayList.size() > 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqAdapterRecommendFriendAdapter.a(localArrayList);
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      else
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_a_of_type_ComTencentMobileqqAppMayknowRecommendManager.a(4);
      }
    }
    else
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      QLog.d("SearchMightKnowFragment", 2, " STUDY MODE NO RECOMMEND FRIEND");
    }
    this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(new SearchMightKnowFragment.2(this));
    if (ThemeUtil.isNowThemeIsNight(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, null)) {
      paramView.findViewById(2131380364).setBackgroundColor(Color.parseColor("#292929"));
    }
  }
  
  private void a(String paramString)
  {
    ReportController.b(null, "dc00898", "", "", "0X800A338", "0X800A338", 0, 0, "", "", "", "");
    ActiveEntitySearchActivity.a(getBaseActivity(), paramString, HardCodeUtil.a(2131713560), new long[] { 1001L, 1002L });
  }
  
  private void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout == null)
    {
      ViewGroup localViewGroup = (ViewGroup)getBaseActivity().getWindow().getDecorView();
      View localView = localViewGroup.getChildAt(0);
      localObject = localViewGroup;
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
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout;
    if (localObject != null) {
      ((TopGestureLayout)localObject).setInterceptTouchFlag(paramBoolean);
    }
  }
  
  private void b(View paramView)
  {
    View localView = paramView.findViewById(2131363868);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131369289));
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new SearchMightKnowFragment.3(this));
    localView.setOnClickListener(new SearchMightKnowFragment.4(this));
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
    paramLayoutInflater = paramLayoutInflater.inflate(2131563009, paramViewGroup, false);
    b(paramLayoutInflater);
    a(paramLayoutInflater);
    ReportController.b(null, "dc00898", "", "", "0X800A337", "0X800A337", 0, 0, "", "", "", "");
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    RecommendFriendAdapter localRecommendFriendAdapter = this.jdField_a_of_type_ComTencentMobileqqAdapterRecommendFriendAdapter;
    if (localRecommendFriendAdapter != null) {
      localRecommendFriendAdapter.c();
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
    RecommendFriendAdapter localRecommendFriendAdapter = this.jdField_a_of_type_ComTencentMobileqqAdapterRecommendFriendAdapter;
    if (localRecommendFriendAdapter != null) {
      localRecommendFriendAdapter.a();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    RecommendFriendAdapter localRecommendFriendAdapter = this.jdField_a_of_type_ComTencentMobileqqAdapterRecommendFriendAdapter;
    if (localRecommendFriendAdapter != null) {
      localRecommendFriendAdapter.b();
    }
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.SearchMightKnowFragment
 * JD-Core Version:    0.7.0.1
 */