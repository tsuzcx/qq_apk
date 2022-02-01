package com.tencent.mobileqq.activity;

import android.app.Dialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.adapter.FacePreloadBaseAdapter.ViewHolder;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.DiscussionManager;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.avatar.observer.AvatarObserver;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.widget.IndexView;
import com.tencent.mobileqq.widget.IndexView.OnIndexChangedListener;
import com.tencent.mobileqq.widget.PinnedDividerListView;
import com.tencent.mobileqq.widget.PinnedDividerListView.OnLayoutListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class DiscussionMemberActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener, View.OnTouchListener, IndexView.OnIndexChangedListener, PinnedDividerListView.OnLayoutListener, AdapterView.OnItemClickListener
{
  private final int jdField_a_of_type_Int = 1;
  View jdField_a_of_type_AndroidViewView;
  EditText jdField_a_of_type_AndroidWidgetEditText;
  private ImageButton jdField_a_of_type_AndroidWidgetImageButton;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private DiscussionMemberActivity.DiscussionMemberListAdapter jdField_a_of_type_ComTencentMobileqqActivityDiscussionMemberActivity$DiscussionMemberListAdapter;
  DiscussionMemberActivity.SearchResultAdapter jdField_a_of_type_ComTencentMobileqqActivityDiscussionMemberActivity$SearchResultAdapter;
  private IndexView jdField_a_of_type_ComTencentMobileqqWidgetIndexView;
  PinnedDividerListView jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView;
  XListView jdField_a_of_type_ComTencentWidgetXListView;
  private String jdField_a_of_type_JavaLangString;
  List<DiscussionMemberActivity.DiscussionMember> jdField_a_of_type_JavaUtilList = new ArrayList();
  View jdField_b_of_type_AndroidViewView;
  private EditText jdField_b_of_type_AndroidWidgetEditText;
  private String jdField_b_of_type_JavaLangString;
  private List<DiscussionMemberActivity.DiscussionMember> jdField_b_of_type_JavaUtilList = new ArrayList();
  private View c;
  private View d;
  private View e;
  
  private void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView = ((PinnedDividerListView)findViewById(2131364583));
    this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView = ((IndexView)findViewById(2131369039));
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setSelector(2131167305);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setOnItemClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setOnLayoutListener(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setIndex(new String[] { "$", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "#" });
    this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setOnIndexChangedListener(this);
    this.c = findViewById(2131377159);
    this.jdField_a_of_type_AndroidViewView = ((View)this.c.getParent());
    this.jdField_b_of_type_AndroidViewView = findViewById(2131377728);
    this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130838979);
    setTitle(HardCodeUtil.a(2131703382));
    Object localObject = (RelativeLayout)getLayoutInflater().inflate(2131562951, this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView, false);
    ((RelativeLayout)localObject).setPadding(0, 0, 40, 0);
    this.jdField_b_of_type_AndroidWidgetEditText = ((EditText)((RelativeLayout)localObject).findViewById(2131366452));
    this.jdField_b_of_type_AndroidWidgetEditText.setFocusable(false);
    this.jdField_b_of_type_AndroidWidgetEditText.setOnTouchListener(this);
    ((Button)((RelativeLayout)localObject).findViewById(2131363942)).setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.addHeaderView((View)localObject);
    this.e = getLayoutInflater().inflate(2131559175, this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView, false);
    TroopMemberListActivity.ViewHolder localViewHolder = new TroopMemberListActivity.ViewHolder();
    localViewHolder.jdField_a_of_type_JavaLangString = this.app.getCurrentAccountUin();
    localViewHolder.c = ((ImageView)this.e.findViewById(2131369676));
    localViewHolder.c.setBackgroundDrawable(FaceDrawable.getUserFaceDrawable(this.app, this.app.getCurrentAccountUin(), (byte)3));
    localViewHolder.b = ((TextView)this.e.findViewById(2131380475));
    localObject = this.app.getCurrentNickname();
    TextView localTextView = localViewHolder.b;
    if ((localObject != null) && (((String)localObject).trim().length() > 0)) {}
    for (;;)
    {
      localTextView.setText((CharSequence)localObject);
      this.e.setTag(localViewHolder);
      this.e.setOnClickListener(this);
      this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.addHeaderView(this.e);
      return;
      localObject = this.app.getCurrentAccountUin();
    }
  }
  
  private void b()
  {
    FriendsManager localFriendsManager = (FriendsManager)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER);
    Object localObject = (DiscussionManager)this.app.getManager(QQManagerFactory.DISCUSSION_MANAGER);
    if (localFriendsManager != null)
    {
      localObject = ((DiscussionManager)localObject).a(this.jdField_a_of_type_JavaLangString);
      if (localObject != null)
      {
        this.jdField_a_of_type_JavaUtilList.clear();
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          DiscussionMemberInfo localDiscussionMemberInfo = (DiscussionMemberInfo)((Iterator)localObject).next();
          if (localDiscussionMemberInfo.memberUin.equals(this.app.getCurrentAccountUin()))
          {
            this.jdField_b_of_type_JavaLangString = ContactUtils.a(this.app, localDiscussionMemberInfo);
          }
          else
          {
            DiscussionMemberActivity.DiscussionMember localDiscussionMember = new DiscussionMemberActivity.DiscussionMember(this, null);
            localDiscussionMember.jdField_a_of_type_JavaLangString = localDiscussionMemberInfo.memberUin;
            localDiscussionMember.jdField_b_of_type_JavaLangString = ContactUtils.a(localDiscussionMemberInfo, this.app);
            localFriendsManager.e(localDiscussionMember.jdField_a_of_type_JavaLangString);
            localDiscussionMember.d = ChnToSpell.a(localDiscussionMember.jdField_b_of_type_JavaLangString, 1);
            localDiscussionMember.c = ChnToSpell.a(localDiscussionMember.jdField_b_of_type_JavaLangString, 2);
            this.jdField_a_of_type_JavaUtilList.add(localDiscussionMember);
          }
        }
      }
    }
  }
  
  private void c()
  {
    ReportDialog localReportDialog = new ReportDialog(this);
    localReportDialog.setCanceledOnTouchOutside(true);
    localReportDialog.requestWindowFeature(1);
    localReportDialog.getWindow().setSoftInputMode(36);
    localReportDialog.setContentView(2131562960);
    Object localObject1 = localReportDialog.getWindow().getAttributes();
    ((WindowManager.LayoutParams)localObject1).x = 0;
    ((WindowManager.LayoutParams)localObject1).y = 0;
    ((WindowManager.LayoutParams)localObject1).width = -1;
    ((WindowManager.LayoutParams)localObject1).windowAnimations = 16973824;
    ((WindowManager.LayoutParams)localObject1).gravity = 51;
    localReportDialog.getWindow().setBackgroundDrawable(new ColorDrawable());
    int i = this.c.getHeight();
    Object localObject3 = new TranslateAnimation(0.0F, 0.0F, 0.0F, -i);
    ((TranslateAnimation)localObject3).setDuration(300L);
    ((TranslateAnimation)localObject3).setFillAfter(true);
    Object localObject2 = new TranslateAnimation(0.0F, 0.0F, -i, 0.0F);
    ((TranslateAnimation)localObject2).setDuration(300L);
    localObject1 = (InputMethodManager)getSystemService("input_method");
    DiscussionMemberActivity.1 local1 = new DiscussionMemberActivity.1(this, (TranslateAnimation)localObject3, localReportDialog, (TranslateAnimation)localObject2, i);
    ((TranslateAnimation)localObject3).setAnimationListener(local1);
    ((TranslateAnimation)localObject2).setAnimationListener(local1);
    this.jdField_a_of_type_AndroidViewView.startAnimation((Animation)localObject3);
    localObject3 = new DiscussionMemberActivity.2(this);
    addObserver((BusinessObserver)localObject3);
    localReportDialog.setOnDismissListener(new DiscussionMemberActivity.3(this, i, (TranslateAnimation)localObject2, (InputMethodManager)localObject1, (AvatarObserver)localObject3));
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)localReportDialog.findViewById(2131366452));
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(new DiscussionMemberActivity.SearchTextWatcher(this, null));
    this.jdField_a_of_type_AndroidWidgetEditText.setSelection(0);
    this.jdField_a_of_type_AndroidWidgetEditText.requestFocus();
    this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)localReportDialog.findViewById(2131368600));
    this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(new DiscussionMemberActivity.4(this));
    localObject2 = (Button)localReportDialog.findViewById(2131363942);
    ((Button)localObject2).setVisibility(0);
    ((Button)localObject2).setOnClickListener(new DiscussionMemberActivity.5(this, localReportDialog));
    this.d = localReportDialog.findViewById(2131372336);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localReportDialog.findViewById(2131376997));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(new DiscussionMemberActivity.6(this, localReportDialog));
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)localReportDialog.findViewById(2131377573));
    this.jdField_a_of_type_ComTencentWidgetXListView.setBackgroundDrawable(getResources().getDrawable(2130838979));
    this.jdField_a_of_type_ComTencentWidgetXListView.setDividerHeight(0);
    this.jdField_b_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionMemberActivity$SearchResultAdapter = new DiscussionMemberActivity.SearchResultAdapter(this, this.jdField_b_of_type_JavaUtilList);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionMemberActivity$SearchResultAdapter);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnTouchListener(new DiscussionMemberActivity.7(this, (InputMethodManager)localObject1));
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnItemClickListener(new DiscussionMemberActivity.8(this, localReportDialog));
  }
  
  void a(View paramView)
  {
    paramView = (FacePreloadBaseAdapter.ViewHolder)paramView.getTag();
    if ((paramView != null) && (paramView.jdField_a_of_type_JavaLangString != null))
    {
      paramView = paramView.jdField_a_of_type_JavaLangString;
      if (paramView.equals(this.app.getCurrentAccountUin()))
      {
        paramView = new ProfileActivity.AllInOne(paramView, 0);
        paramView.g = 5;
        ProfileActivity.a(this, paramView, 1);
      }
    }
    else
    {
      return;
    }
    if (((FriendsManager)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER)).b(paramView))
    {
      localAllInOne = new ProfileActivity.AllInOne(paramView, 1);
      localAllInOne.h = ContactUtils.a(this.app, paramView, 0);
      localAllInOne.g = 5;
      ProfileActivity.a(this, localAllInOne, 1);
      return;
    }
    ProfileActivity.AllInOne localAllInOne = new ProfileActivity.AllInOne(paramView, 46);
    localAllInOne.h = ContactUtils.a(this.app, paramView, 0);
    localAllInOne.f = paramView;
    localAllInOne.jdField_e_of_type_Int = 3000;
    localAllInOne.jdField_e_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    localAllInOne.g = 5;
    ProfileActivity.a(this, localAllInOne, 1);
  }
  
  public void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.getFirstVisiblePosition() > 0) || ((this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.getFirstVisiblePosition() == 0) && (this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.getChildCount() < this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionMemberActivity$DiscussionMemberListAdapter.getCount() + this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.getHeaderViewsCount()))) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setVisibility(0);
    }
  }
  
  public void a(String paramString)
  {
    if ("$".equals(paramString)) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setSelection(0);
    }
    int i;
    do
    {
      return;
      i = this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionMemberActivity$DiscussionMemberListAdapter.a(paramString);
    } while (i == -1);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setSelection(i + this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.getHeaderViewsCount());
  }
  
  void b(String paramString)
  {
    this.jdField_b_of_type_JavaUtilList.clear();
    if ((paramString.equals("")) || (paramString.trim().length() == 0))
    {
      this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(8);
      this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(8);
      this.d.setVisibility(8);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionMemberActivity$SearchResultAdapter.notifyDataSetChanged();
      return;
      this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(0);
      this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(0);
      ArrayList localArrayList1 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      ArrayList localArrayList3 = new ArrayList();
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        DiscussionMemberActivity.DiscussionMember localDiscussionMember = (DiscussionMemberActivity.DiscussionMember)localIterator.next();
        if (localDiscussionMember != null) {
          if ((localDiscussionMember.jdField_b_of_type_JavaLangString.equals(paramString)) || (localDiscussionMember.jdField_a_of_type_JavaLangString.equals(paramString)) || (localDiscussionMember.d.equals(paramString.toLowerCase())) || (localDiscussionMember.c.equals(paramString.toLowerCase()))) {
            localArrayList1.add(localDiscussionMember);
          } else if ((localDiscussionMember.jdField_b_of_type_JavaLangString.indexOf(paramString) == 0) || (localDiscussionMember.jdField_a_of_type_JavaLangString.indexOf(paramString) == 0) || (localDiscussionMember.c.indexOf(paramString.toLowerCase()) == 0) || (localDiscussionMember.d.indexOf(paramString.toLowerCase()) == 0)) {
            localArrayList2.add(localDiscussionMember);
          } else if ((localDiscussionMember.jdField_b_of_type_JavaLangString.indexOf(paramString) > 0) || (localDiscussionMember.jdField_a_of_type_JavaLangString.indexOf(paramString) > 0) || (localDiscussionMember.c.indexOf(paramString.toLowerCase()) > 0) || (localDiscussionMember.d.indexOf(paramString.toLowerCase()) > 0)) {
            localArrayList3.add(localDiscussionMember);
          }
        }
      }
      Collections.sort(localArrayList2, new DiscussionMemberActivity.MyComparator(this, null));
      this.jdField_b_of_type_JavaUtilList.addAll(localArrayList1);
      this.jdField_b_of_type_JavaUtilList.addAll(localArrayList2);
      this.jdField_b_of_type_JavaUtilList.addAll(localArrayList3);
      if (this.jdField_b_of_type_JavaUtilList.isEmpty()) {
        this.d.setVisibility(0);
      } else {
        this.d.setVisibility(8);
      }
    }
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((-1 == paramInt2) && (paramInt2 == 1)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionMemberActivity$DiscussionMemberListAdapter.notifyDataSetChanged();
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2131562988);
    this.jdField_a_of_type_JavaLangString = getIntent().getStringExtra("uin");
    a();
    b();
    ((TroopMemberListActivity.ViewHolder)this.e.getTag()).b.setText(this.jdField_b_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionMemberActivity$DiscussionMemberListAdapter = new DiscussionMemberActivity.DiscussionMemberListAdapter(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionMemberActivity$DiscussionMemberListAdapter);
    return true;
  }
  
  public void doOnDestroy()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionMemberActivity$DiscussionMemberListAdapter.c();
    super.doOnDestroy();
  }
  
  public void doOnStart()
  {
    super.doOnStart();
    getWindow().setSoftInputMode(48);
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.e) {
      a(paramView);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    a(paramView);
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 1) {
      c();
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.DiscussionMemberActivity
 * JD-Core Version:    0.7.0.1
 */