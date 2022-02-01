package com.tencent.mobileqq.activity;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.recent.RecentUtil;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.LikeRankingListManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.CardProfile;
import com.tencent.mobileqq.data.LikeRankingInfo;
import com.tencent.mobileqq.nearby.NearbyLikeLimitManager;
import com.tencent.mobileqq.profile.votelist.VoteItemClickListener;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.SimpleTextView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class VisitorsActivity$VisitorAdapter
  extends BaseAdapter
{
  public int a;
  LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  protected NearbyLikeLimitManager a;
  VoteItemClickListener jdField_a_of_type_ComTencentMobileqqProfileVotelistVoteItemClickListener;
  public String a;
  List<CardProfile> jdField_a_of_type_JavaUtilList = new ArrayList();
  boolean jdField_a_of_type_Boolean;
  int jdField_b_of_type_Int;
  boolean jdField_b_of_type_Boolean;
  int jdField_c_of_type_Int;
  private boolean jdField_c_of_type_Boolean = false;
  int d;
  int e;
  private int f = 0;
  private int g;
  private int h;
  
  public VisitorsActivity$VisitorAdapter(VisitorsActivity paramVisitorsActivity, Context paramContext, QQAppInterface paramQQAppInterface, VoteItemClickListener paramVoteItemClickListener, int paramInt, boolean paramBoolean)
  {
    this.jdField_a_of_type_Int = 0;
    paramContext = paramVisitorsActivity.getResources();
    this.g = AIOUtils.a(17.0F, paramContext);
    this.h = AIOUtils.a(15.0F, paramContext);
    this.jdField_a_of_type_ComTencentMobileqqProfileVotelistVoteItemClickListener = paramVoteItemClickListener;
    this.f = paramInt;
    this.jdField_b_of_type_Boolean = paramBoolean;
    this.jdField_b_of_type_Int = AIOUtils.a(38.0F, paramContext);
    this.jdField_c_of_type_Int = AIOUtils.a(86.0F, paramContext);
    this.d = AIOUtils.a(60.0F, paramContext);
    this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyLikeLimitManager = ((NearbyLikeLimitManager)paramVisitorsActivity.app.getManager(QQManagerFactory.NEARBY_LIKE_LIMIT_MANAGER));
  }
  
  private View a()
  {
    View localView = this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.getLayoutInflater().inflate(2131559592, null);
    VisitorsActivity.MoreViewHolder localMoreViewHolder = new VisitorsActivity.MoreViewHolder();
    localMoreViewHolder.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131371896));
    localMoreViewHolder.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)localView.findViewById(2131376854));
    localMoreViewHolder.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131370717));
    localView.setTag(localMoreViewHolder);
    return localView;
  }
  
  private View a(ViewGroup paramViewGroup)
  {
    paramViewGroup = this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.getLayoutInflater().inflate(2131559429, paramViewGroup, false);
    VisitorsActivity.CustomViewHolder localCustomViewHolder = new VisitorsActivity.CustomViewHolder();
    localCustomViewHolder.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramViewGroup.findViewById(2131379718));
    localCustomViewHolder.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131368603));
    localCustomViewHolder.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131381704));
    localCustomViewHolder.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131379092));
    localCustomViewHolder.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131382095));
    localCustomViewHolder.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131370043));
    localCustomViewHolder.d = ((TextView)paramViewGroup.findViewById(2131380704));
    localCustomViewHolder.e = ((TextView)paramViewGroup.findViewById(2131365611));
    localCustomViewHolder.f = ((TextView)paramViewGroup.findViewById(2131380707));
    localCustomViewHolder.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131369872));
    localCustomViewHolder.g = ((TextView)paramViewGroup.findViewById(2131367582));
    localCustomViewHolder.jdField_a_of_type_ComTencentWidgetSimpleTextView = ((SimpleTextView)paramViewGroup.findViewById(2131364120));
    localCustomViewHolder.jdField_a_of_type_ComTencentWidgetSimpleTextView.setGravity(17);
    localCustomViewHolder.jdField_a_of_type_ComTencentWidgetSimpleTextView.setText(this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.getString(2131692673));
    localCustomViewHolder.jdField_a_of_type_ComTencentWidgetSimpleTextView.setTextSize(1, 16.0F);
    localCustomViewHolder.jdField_a_of_type_ComTencentWidgetSimpleTextView.setTextColor(-1);
    localCustomViewHolder.jdField_a_of_type_ComTencentWidgetSimpleTextView.setOnClickListener(new VisitorsActivity.VisitorAdapter.3(this, localCustomViewHolder));
    paramViewGroup.findViewById(2131365255).getLayoutParams().width = VisitorsActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity);
    paramViewGroup.setTag(localCustomViewHolder);
    return paramViewGroup;
  }
  
  private void a()
  {
    Rect localRect;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.jdField_a_of_type_Int == 0)
    {
      localRect = new Rect();
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.c == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.c.getVisibility() != 0)) {
        break label141;
      }
    }
    label141:
    for (Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.c;; localObject = this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView)
    {
      ((View)localObject).getGlobalVisibleRect(localRect);
      int i = localRect.bottom;
      int j = this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.getResources().getDisplayMetrics().heightPixels;
      if (QLog.isColorLevel()) {
        QLog.d("VisitorsActivity", 2, "init empty h " + this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.jdField_a_of_type_Int);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.jdField_a_of_type_Int = (j - i - AIOUtils.a(75.0F, this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.getResources()));
      return;
    }
  }
  
  private void a(VisitorsActivity.CustomViewHolder paramCustomViewHolder, CardProfile paramCardProfile)
  {
    TextView localTextView = paramCustomViewHolder.e;
    Object localObject = (RelativeLayout.LayoutParams)localTextView.getLayoutParams();
    if (paramCustomViewHolder.jdField_b_of_type_AndroidWidgetTextView.getVisibility() == 0)
    {
      ((RelativeLayout.LayoutParams)localObject).addRule(3, paramCustomViewHolder.jdField_b_of_type_AndroidWidgetTextView.getId());
      localTextView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      int i = ((Integer)paramCustomViewHolder.jdField_c_of_type_AndroidWidgetImageView.getTag(2131369872)).intValue();
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.a(paramCardProfile, paramCustomViewHolder.d, false, i);
      if (paramCardProfile.payVoteCount <= 0) {
        break label219;
      }
      paramCustomViewHolder.jdField_b_of_type_Int = 0;
      paramCustomViewHolder.d.setText(TextUtils.concat(new CharSequence[] { localObject, "，" }));
      if (this.f != 0) {
        break label209;
      }
    }
    label209:
    for (paramCustomViewHolder = HardCodeUtil.a(2131716650);; paramCustomViewHolder = HardCodeUtil.a(2131716651))
    {
      localTextView.setText(String.format("%s%d金豆", new Object[] { paramCustomViewHolder, Integer.valueOf(paramCardProfile.payVoteCount * 2) }));
      localTextView.setVisibility(0);
      return;
      if (paramCustomViewHolder.jdField_c_of_type_AndroidWidgetTextView.getVisibility() == 0)
      {
        ((RelativeLayout.LayoutParams)localObject).addRule(3, paramCustomViewHolder.jdField_c_of_type_AndroidWidgetTextView.getId());
        break;
      }
      ((RelativeLayout.LayoutParams)localObject).addRule(3, paramCustomViewHolder.jdField_a_of_type_AndroidWidgetTextView.getId());
      break;
    }
    label219:
    paramCustomViewHolder.jdField_b_of_type_Int = 0;
    localTextView.setVisibility(8);
    paramCustomViewHolder.d.setText((CharSequence)localObject);
  }
  
  private void a(VisitorsActivity.MoreViewHolder paramMoreViewHolder)
  {
    int j = 8;
    Object localObject = paramMoreViewHolder.jdField_a_of_type_AndroidWidgetTextView;
    if (this.jdField_a_of_type_Boolean)
    {
      i = 2131693848;
      ((TextView)localObject).setText(i);
      localObject = paramMoreViewHolder.jdField_a_of_type_AndroidWidgetProgressBar;
      if (!this.jdField_a_of_type_Boolean) {
        break label74;
      }
      i = 0;
      label41:
      ((ProgressBar)localObject).setVisibility(i);
      paramMoreViewHolder = paramMoreViewHolder.jdField_a_of_type_AndroidWidgetImageView;
      if (!this.jdField_a_of_type_Boolean) {
        break label80;
      }
    }
    label74:
    label80:
    for (int i = j;; i = 0)
    {
      paramMoreViewHolder.setVisibility(i);
      return;
      i = 2131694255;
      break;
      i = 8;
      break label41;
    }
  }
  
  private void a(Object paramObject, VisitorsActivity.CustomViewHolder paramCustomViewHolder)
  {
    if (paramObject == null) {
      return;
    }
    paramObject = (CardProfile)paramObject;
    String str = String.valueOf(paramObject.lEctID);
    paramCustomViewHolder.jdField_a_of_type_JavaLangObject = paramObject;
    Object localObject = StringUtil.d(String.valueOf(paramObject.strNick));
    paramCustomViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
    int i;
    if (paramObject.bAage > 0)
    {
      paramCustomViewHolder.jdField_b_of_type_AndroidWidgetTextView.setText(String.valueOf(paramObject.bAage));
      localObject = paramCustomViewHolder.jdField_b_of_type_AndroidWidgetTextView;
      if (paramObject.bSex != 1) {
        break label390;
      }
      i = 2130840665;
      label84:
      ((TextView)localObject).setCompoundDrawablesWithIntrinsicBounds(i, 0, 0, 0);
      if (paramObject.bSex != 1) {
        break label397;
      }
      paramCustomViewHolder.jdField_b_of_type_AndroidWidgetTextView.setBackgroundResource(2130845856);
      label111:
      if ((paramObject.bConstellation != 0) && (paramObject.bConstellation <= 12)) {
        break label410;
      }
      paramCustomViewHolder.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      label136:
      paramCustomViewHolder.jdField_c_of_type_AndroidWidgetImageView.setTag(paramObject);
      i = this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.a(paramObject, str);
      if ((i != 0) && (i != 2)) {
        break label506;
      }
      paramCustomViewHolder.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
      if (paramObject.bTodayVotedCnt <= 0L) {
        break label493;
      }
      if (!this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyLikeLimitManager.c(paramObject.lEctID)) {
        break label458;
      }
      if (paramObject.bAvailableCnt > 0L) {
        break label445;
      }
      paramCustomViewHolder.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130842788);
      label214:
      paramCustomViewHolder.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity);
      label225:
      a(paramCustomViewHolder, paramObject);
      if (TextUtils.isEmpty(paramObject.strTime)) {
        break label518;
      }
      paramCustomViewHolder.f.setText(paramObject.strTime);
      paramCustomViewHolder.f.setVisibility(0);
      label260:
      VisitorsActivity.a(paramObject.stVipInfo, paramCustomViewHolder.jdField_b_of_type_AndroidWidgetImageView, paramCustomViewHolder.jdField_a_of_type_AndroidWidgetTextView);
      if (!RecentUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.app, str)) {
        break label530;
      }
      paramCustomViewHolder.g.setVisibility(0);
      label298:
      localObject = (RelativeLayout.LayoutParams)paramCustomViewHolder.e.getLayoutParams();
      if (paramCustomViewHolder.jdField_b_of_type_AndroidWidgetTextView.getVisibility() != 0) {
        break label542;
      }
      ((RelativeLayout.LayoutParams)localObject).addRule(3, paramCustomViewHolder.jdField_b_of_type_AndroidWidgetTextView.getId());
    }
    for (;;)
    {
      paramCustomViewHolder.e.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.jdField_a_of_type_JavaUtilHashMap.put(str, paramCustomViewHolder.jdField_a_of_type_AndroidWidgetImageView);
      this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.a(str, paramObject.wFace, paramCustomViewHolder.jdField_a_of_type_AndroidWidgetImageView);
      return;
      paramCustomViewHolder.jdField_b_of_type_AndroidWidgetTextView.setText("");
      break;
      label390:
      i = 2130840670;
      break label84;
      label397:
      paramCustomViewHolder.jdField_b_of_type_AndroidWidgetTextView.setBackgroundResource(2130845865);
      break label111;
      label410:
      paramCustomViewHolder.jdField_c_of_type_AndroidWidgetTextView.setText(ProfileCardUtil.a(paramObject.bConstellation));
      paramCustomViewHolder.jdField_c_of_type_AndroidWidgetTextView.setBackgroundResource(2130845866);
      paramCustomViewHolder.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      break label136;
      label445:
      paramCustomViewHolder.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130842790);
      break label214;
      label458:
      if (paramObject.bAvailableCnt <= 0L)
      {
        paramCustomViewHolder.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130846189);
        break label214;
      }
      paramCustomViewHolder.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130846199);
      break label214;
      label493:
      paramCustomViewHolder.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130846186);
      break label214;
      label506:
      paramCustomViewHolder.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
      break label225;
      label518:
      paramCustomViewHolder.f.setVisibility(8);
      break label260;
      label530:
      paramCustomViewHolder.g.setVisibility(8);
      break label298;
      label542:
      if (paramCustomViewHolder.jdField_c_of_type_AndroidWidgetTextView.getVisibility() == 0) {
        ((RelativeLayout.LayoutParams)localObject).addRule(3, paramCustomViewHolder.jdField_c_of_type_AndroidWidgetTextView.getId());
      } else {
        ((RelativeLayout.LayoutParams)localObject).addRule(3, paramCustomViewHolder.jdField_a_of_type_AndroidWidgetLinearLayout.getId());
      }
    }
  }
  
  public CardProfile a(int paramInt)
  {
    if (paramInt < this.jdField_a_of_type_JavaUtilList.size()) {
      return (CardProfile)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public void a(ArrayList<CardProfile> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() < 1)) {
      if (QLog.isColorLevel()) {
        QLog.d("VisitorsActivity", 2, "setDataSet profiles empty:" + paramArrayList);
      }
    }
    int i;
    do
    {
      return;
      this.jdField_a_of_type_JavaUtilList = paramArrayList;
      this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.k = -1;
      i = this.jdField_c_of_type_Int * this.jdField_a_of_type_JavaUtilList.size();
    } while (i >= this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.g);
    this.e = (this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.g - this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.getTitleBarHeight() - i);
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
  }
  
  public CardProfile b(int paramInt)
  {
    if (paramInt < this.jdField_a_of_type_JavaUtilList.size()) {
      return (CardProfile)this.jdField_a_of_type_JavaUtilList.remove(paramInt);
    }
    return null;
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size() + 1;
  }
  
  public long getItemId(int paramInt)
  {
    if (paramInt > this.jdField_a_of_type_JavaUtilList.size() - 1) {
      return -1L;
    }
    return ((CardProfile)this.jdField_a_of_type_JavaUtilList.get(paramInt)).lEctID;
  }
  
  public int getItemViewType(int paramInt)
  {
    int j = 0;
    int i = j;
    if (paramInt > this.jdField_a_of_type_JavaUtilList.size() - 1)
    {
      if (this.jdField_a_of_type_JavaUtilList.size() != 0) {
        break label54;
      }
      if (this.f != 0) {
        break label42;
      }
      i = 3;
    }
    label42:
    do
    {
      return i;
      i = j;
    } while (this.f != 1);
    return 4;
    label54:
    if (this.jdField_c_of_type_Boolean) {
      return 1;
    }
    return 2;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    switch (getItemViewType(paramInt))
    {
    }
    for (;;)
    {
      paramView.setTag(-1, Integer.valueOf(paramInt));
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return paramView;
      if (paramInt > this.jdField_a_of_type_Int) {
        this.jdField_a_of_type_Int = paramInt;
      }
      if (paramView != null)
      {
        localView = paramView;
        if ((paramView.getTag() instanceof VisitorsActivity.CustomViewHolder)) {}
      }
      else
      {
        localView = a(paramViewGroup);
        localView.setOnClickListener(new VisitorsActivity.VisitorAdapter.1(this));
      }
      paramView = (VisitorsActivity.CustomViewHolder)localView.getTag();
      paramView.jdField_c_of_type_AndroidWidgetImageView.setTag(2131369872, Integer.valueOf(paramInt));
      paramView.jdField_a_of_type_Int = paramInt;
      a(a(paramInt), paramView);
      this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.a(localView, paramInt);
      paramView = localView;
      continue;
      if (paramView != null)
      {
        localView = paramView;
        if ((paramView.getTag() instanceof VisitorsActivity.MoreViewHolder)) {}
      }
      else
      {
        localView = a();
        localView.setOnClickListener(new VisitorsActivity.VisitorAdapter.2(this));
      }
      a((VisitorsActivity.MoreViewHolder)localView.getTag());
      paramView = localView;
      continue;
      if (this.jdField_a_of_type_AndroidViewLayoutInflater == null) {
        this.jdField_a_of_type_AndroidViewLayoutInflater = ((LayoutInflater)paramViewGroup.getContext().getSystemService("layout_inflater"));
      }
      paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131561398, null);
      if ((this.jdField_b_of_type_Boolean) && (this.e > this.d))
      {
        paramView.setMinimumHeight(this.e);
        paramView.setLayoutParams(new AbsListView.LayoutParams(-1, this.e));
      }
      ((TextView)paramView.findViewById(2131365325)).setText(this.jdField_a_of_type_JavaLangString);
      continue;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.jdField_a_of_type_AndroidViewView == null)
      {
        a();
        this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.getLayoutInflater().inflate(2131563215, null);
        this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.jdField_a_of_type_AndroidViewView.setLayoutParams(new AbsListView.LayoutParams(-1, this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.jdField_a_of_type_Int));
      }
      View localView = this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.jdField_a_of_type_AndroidViewView;
      TextView localTextView = (TextView)localView.findViewById(2131366345);
      LikeRankingInfo localLikeRankingInfo = this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.jdField_a_of_type_ComTencentMobileqqAppLikeRankingListManager.a();
      paramView = this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.getString(2131720629);
      if ((localLikeRankingInfo == null) || (localLikeRankingInfo.totalLikeCount <= 0)) {
        paramView = this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.getString(2131720628);
      }
      localTextView.setText(paramView);
      paramView = localView;
      continue;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.b == null)
      {
        a();
        this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.b = this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.getLayoutInflater().inflate(2131561397, null);
        this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.b.setLayoutParams(new AbsListView.LayoutParams(-1, this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.jdField_a_of_type_Int));
      }
      paramView = this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.b;
    }
  }
  
  public int getViewTypeCount()
  {
    return 5;
  }
  
  public boolean hasStableIds()
  {
    return false;
  }
  
  public boolean isEnabled(int paramInt)
  {
    if (paramInt > this.jdField_a_of_type_JavaUtilList.size() - 1) {
      return !this.jdField_a_of_type_Boolean;
    }
    return super.isEnabled(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.VisitorsActivity.VisitorAdapter
 * JD-Core Version:    0.7.0.1
 */