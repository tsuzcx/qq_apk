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
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.widget.SwipListView;
import com.tencent.widget.SwipListView.RightIconMenuListener;
import java.util.ArrayList;

public class SearchMightKnowFragment
  extends PublicBaseFragment
  implements TextWatcher, TextView.OnEditorActionListener
{
  public QuickPinyinEditText a;
  public QQAppInterface b = null;
  MayKnowAdapter.OnRecommendsCanceledListener c = new SearchMightKnowFragment.5(this);
  SwipListView.RightIconMenuListener d = new SearchMightKnowFragment.6(this);
  private LinearLayout e = null;
  private SwipListView f = null;
  private TextView g;
  private ImageButton h;
  private ImageView i;
  private RecommendFriendAdapter j;
  private MayknowRecommendManager k;
  private TopGestureLayout l;
  
  private void a(View paramView)
  {
    this.b = getBaseActivity().app;
    this.a = ((QuickPinyinEditText)paramView.findViewById(2131432634));
    this.f = ((SwipListView)paramView.findViewById(2131446653));
    this.e = ((LinearLayout)paramView.findViewById(2131437606));
    this.g = ((TextView)paramView.findViewById(2131432530));
    this.h = ((ImageButton)paramView.findViewById(2131435215));
    paramView.findViewById(2131445453).setFocusable(true);
    paramView.findViewById(2131445453).setFocusableInTouchMode(true);
    this.a.setFocusable(true);
    this.a.setFocusableInTouchMode(true);
    this.a.clearFocus();
    this.a.setImeOptions(3);
    this.a.setOnEditorActionListener(this);
    this.a.addTextChangedListener(this);
    this.a.setHint(HardCodeUtil.a(2131911107));
    this.f.setDragEnable(true);
    this.f.setRightIconMenuListener(this.d);
    this.f.setOnTouchListener(new SearchMightKnowFragment.1(this));
    this.j = new RecommendFriendAdapter(getBaseActivity(), this.b, this.f, 10, this.c);
    int m = getResources().getDimensionPixelSize(2131298134);
    this.j.a(m);
    this.k = ((MayknowRecommendManager)this.b.getManager(QQManagerFactory.MAYKNOW_RECOMMEND_MANAGER));
    ArrayList localArrayList = this.k.f();
    if (!StudyModeManager.h())
    {
      if (localArrayList.size() > 0)
      {
        this.j.a(localArrayList);
        this.g.setVisibility(8);
      }
      else
      {
        this.g.setVisibility(0);
        this.k.e(4);
      }
    }
    else
    {
      this.g.setVisibility(0);
      QLog.d("SearchMightKnowFragment", 2, " STUDY MODE NO RECOMMEND FRIEND");
    }
    this.h.setOnClickListener(new SearchMightKnowFragment.2(this));
    if (ThemeUtil.isNowThemeIsNight(this.b, false, null)) {
      paramView.findViewById(2131449310).setBackgroundColor(Color.parseColor("#292929"));
    }
  }
  
  private void a(String paramString)
  {
    ReportController.b(null, "dc00898", "", "", "0X800A338", "0X800A338", 0, 0, "", "", "", "");
    ActiveEntitySearchActivity.a(getBaseActivity(), paramString, HardCodeUtil.a(2131911106), new long[] { 1001L, 1002L });
  }
  
  private void a(boolean paramBoolean)
  {
    if (this.l == null)
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
        this.l = ((TopGestureLayout)localObject);
      }
    }
    Object localObject = this.l;
    if (localObject != null) {
      ((TopGestureLayout)localObject).setInterceptTouchFlag(paramBoolean);
    }
  }
  
  private void b(View paramView)
  {
    View localView = paramView.findViewById(2131429816);
    this.i = ((ImageView)paramView.findViewById(2131436275));
    this.i.setVisibility(0);
    this.i.setOnClickListener(new SearchMightKnowFragment.3(this));
    localView.setOnClickListener(new SearchMightKnowFragment.4(this));
  }
  
  public void a()
  {
    ((InputMethodManager)BaseApplicationImpl.getContext().getSystemService("input_method")).hideSoftInputFromWindow(this.a.getWindowToken(), 0);
    this.a.clearFocus();
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    if (this.a.length() == 0)
    {
      this.h.setVisibility(4);
      return;
    }
    this.h.setVisibility(0);
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131629617, paramViewGroup, false);
    b(paramLayoutInflater);
    a(paramLayoutInflater);
    ReportController.b(null, "dc00898", "", "", "0X800A337", "0X800A337", 0, 0, "", "", "", "");
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    RecommendFriendAdapter localRecommendFriendAdapter = this.j;
    if (localRecommendFriendAdapter != null) {
      localRecommendFriendAdapter.c();
    }
  }
  
  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool;
    if (paramInt == 3)
    {
      String str = this.a.getText().toString().trim();
      a();
      if ((str != null) && (!str.equals(""))) {
        a(str);
      }
      bool = true;
    }
    else
    {
      bool = false;
    }
    EventCollector.getInstance().onEditorAction(paramTextView, paramInt, paramKeyEvent);
    return bool;
  }
  
  public void onPause()
  {
    super.onPause();
    RecommendFriendAdapter localRecommendFriendAdapter = this.j;
    if (localRecommendFriendAdapter != null) {
      localRecommendFriendAdapter.a();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    RecommendFriendAdapter localRecommendFriendAdapter = this.j;
    if (localRecommendFriendAdapter != null) {
      localRecommendFriendAdapter.b();
    }
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.SearchMightKnowFragment
 * JD-Core Version:    0.7.0.1
 */