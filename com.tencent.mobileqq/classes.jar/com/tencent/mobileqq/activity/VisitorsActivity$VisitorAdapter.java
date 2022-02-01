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
import com.tencent.mobileqq.nearby.INearbyLikeLimitManager;
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
  protected INearbyLikeLimitManager a;
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
    this.g = AIOUtils.b(17.0F, paramContext);
    this.h = AIOUtils.b(15.0F, paramContext);
    this.jdField_a_of_type_ComTencentMobileqqProfileVotelistVoteItemClickListener = paramVoteItemClickListener;
    this.f = paramInt;
    this.jdField_b_of_type_Boolean = paramBoolean;
    this.jdField_b_of_type_Int = AIOUtils.b(38.0F, paramContext);
    this.jdField_c_of_type_Int = AIOUtils.b(86.0F, paramContext);
    this.d = AIOUtils.b(60.0F, paramContext);
    this.jdField_a_of_type_ComTencentMobileqqNearbyINearbyLikeLimitManager = ((INearbyLikeLimitManager)paramVisitorsActivity.app.getManager(QQManagerFactory.NEARBY_LIKE_LIMIT_MANAGER));
  }
  
  private View a()
  {
    View localView = this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.getLayoutInflater().inflate(2131559469, null);
    VisitorsActivity.MoreViewHolder localMoreViewHolder = new VisitorsActivity.MoreViewHolder();
    localMoreViewHolder.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131371517));
    localMoreViewHolder.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)localView.findViewById(2131376345));
    localMoreViewHolder.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131370354));
    localView.setTag(localMoreViewHolder);
    return localView;
  }
  
  private View a(ViewGroup paramViewGroup)
  {
    paramViewGroup = this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.getLayoutInflater().inflate(2131559304, paramViewGroup, false);
    VisitorsActivity.CustomViewHolder localCustomViewHolder = new VisitorsActivity.CustomViewHolder();
    localCustomViewHolder.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramViewGroup.findViewById(2131379058));
    localCustomViewHolder.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131368343));
    localCustomViewHolder.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131380937));
    localCustomViewHolder.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131378461));
    localCustomViewHolder.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131381297));
    localCustomViewHolder.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131369727));
    localCustomViewHolder.d = ((TextView)paramViewGroup.findViewById(2131379975));
    localCustomViewHolder.e = ((TextView)paramViewGroup.findViewById(2131365453));
    localCustomViewHolder.f = ((TextView)paramViewGroup.findViewById(2131379978));
    localCustomViewHolder.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131369557));
    localCustomViewHolder.g = ((TextView)paramViewGroup.findViewById(2131367340));
    localCustomViewHolder.jdField_a_of_type_ComTencentWidgetSimpleTextView = ((SimpleTextView)paramViewGroup.findViewById(2131364041));
    localCustomViewHolder.jdField_a_of_type_ComTencentWidgetSimpleTextView.setGravity(17);
    localCustomViewHolder.jdField_a_of_type_ComTencentWidgetSimpleTextView.setText(this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.getString(2131692630));
    localCustomViewHolder.jdField_a_of_type_ComTencentWidgetSimpleTextView.setTextSize(1, 16.0F);
    localCustomViewHolder.jdField_a_of_type_ComTencentWidgetSimpleTextView.setTextColor(-1);
    localCustomViewHolder.jdField_a_of_type_ComTencentWidgetSimpleTextView.setOnClickListener(new VisitorsActivity.VisitorAdapter.3(this, localCustomViewHolder));
    paramViewGroup.findViewById(2131365132).getLayoutParams().width = VisitorsActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity);
    paramViewGroup.setTag(localCustomViewHolder);
    return paramViewGroup;
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.jdField_a_of_type_Int == 0)
    {
      Rect localRect = new Rect();
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.c != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.c.getVisibility() == 0)) {
        localObject = this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.c;
      } else {
        localObject = this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView;
      }
      ((View)localObject).getGlobalVisibleRect(localRect);
      int i = localRect.bottom;
      int j = this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.getResources().getDisplayMetrics().heightPixels;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("init empty h ");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.jdField_a_of_type_Int);
        QLog.d("VisitorsActivity", 2, ((StringBuilder)localObject).toString());
      }
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity;
      ((VisitorsActivity)localObject).jdField_a_of_type_Int = (j - i - AIOUtils.b(75.0F, ((VisitorsActivity)localObject).getResources()));
    }
  }
  
  private void a(VisitorsActivity.CustomViewHolder paramCustomViewHolder, CardProfile paramCardProfile)
  {
    TextView localTextView = paramCustomViewHolder.e;
    Object localObject = (RelativeLayout.LayoutParams)localTextView.getLayoutParams();
    if (paramCustomViewHolder.jdField_b_of_type_AndroidWidgetTextView.getVisibility() == 0) {
      ((RelativeLayout.LayoutParams)localObject).addRule(3, paramCustomViewHolder.jdField_b_of_type_AndroidWidgetTextView.getId());
    } else if (paramCustomViewHolder.jdField_c_of_type_AndroidWidgetTextView.getVisibility() == 0) {
      ((RelativeLayout.LayoutParams)localObject).addRule(3, paramCustomViewHolder.jdField_c_of_type_AndroidWidgetTextView.getId());
    } else {
      ((RelativeLayout.LayoutParams)localObject).addRule(3, paramCustomViewHolder.jdField_a_of_type_AndroidWidgetTextView.getId());
    }
    localTextView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    int i = ((Integer)paramCustomViewHolder.jdField_c_of_type_AndroidWidgetImageView.getTag(2131369557)).intValue();
    localObject = this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.a(paramCardProfile, paramCustomViewHolder.d, false, i);
    if (paramCardProfile.payVoteCount > 0)
    {
      paramCustomViewHolder.jdField_b_of_type_Int = 0;
      paramCustomViewHolder.d.setText(TextUtils.concat(new CharSequence[] { localObject, "，" }));
      if (this.f == 0) {
        i = 2131716305;
      } else {
        i = 2131716306;
      }
      localTextView.setText(String.format("%s%d金豆", new Object[] { HardCodeUtil.a(i), Integer.valueOf(paramCardProfile.payVoteCount * 2) }));
      localTextView.setVisibility(0);
      return;
    }
    paramCustomViewHolder.jdField_b_of_type_Int = 0;
    localTextView.setVisibility(8);
    paramCustomViewHolder.d.setText((CharSequence)localObject);
  }
  
  private void a(VisitorsActivity.MoreViewHolder paramMoreViewHolder)
  {
    Object localObject = paramMoreViewHolder.jdField_a_of_type_AndroidWidgetTextView;
    if (this.jdField_a_of_type_Boolean) {
      i = 2131693802;
    } else {
      i = 2131694220;
    }
    ((TextView)localObject).setText(i);
    localObject = paramMoreViewHolder.jdField_a_of_type_AndroidWidgetProgressBar;
    boolean bool = this.jdField_a_of_type_Boolean;
    int j = 0;
    if (bool) {
      i = 0;
    } else {
      i = 8;
    }
    ((ProgressBar)localObject).setVisibility(i);
    paramMoreViewHolder = paramMoreViewHolder.jdField_a_of_type_AndroidWidgetImageView;
    int i = j;
    if (this.jdField_a_of_type_Boolean) {
      i = 8;
    }
    paramMoreViewHolder.setVisibility(i);
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
    if (paramObject.bAage > 0) {
      paramCustomViewHolder.jdField_b_of_type_AndroidWidgetTextView.setText(String.valueOf(paramObject.bAage));
    } else {
      paramCustomViewHolder.jdField_b_of_type_AndroidWidgetTextView.setText("");
    }
    localObject = paramCustomViewHolder.jdField_b_of_type_AndroidWidgetTextView;
    if (paramObject.bSex == 1) {
      i = 2130840540;
    } else {
      i = 2130840545;
    }
    ((TextView)localObject).setCompoundDrawablesWithIntrinsicBounds(i, 0, 0, 0);
    if (paramObject.bSex == 1) {
      paramCustomViewHolder.jdField_b_of_type_AndroidWidgetTextView.setBackgroundResource(2130845729);
    } else {
      paramCustomViewHolder.jdField_b_of_type_AndroidWidgetTextView.setBackgroundResource(2130845738);
    }
    if ((paramObject.bConstellation != 0) && (paramObject.bConstellation <= 12))
    {
      paramCustomViewHolder.jdField_c_of_type_AndroidWidgetTextView.setText(ProfileCardUtil.a(paramObject.bConstellation));
      paramCustomViewHolder.jdField_c_of_type_AndroidWidgetTextView.setBackgroundResource(2130845739);
      paramCustomViewHolder.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
    }
    else
    {
      paramCustomViewHolder.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    paramCustomViewHolder.jdField_c_of_type_AndroidWidgetImageView.setTag(paramObject);
    int i = this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.a(paramObject, str);
    if ((i != 0) && (i != 2))
    {
      paramCustomViewHolder.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    else
    {
      paramCustomViewHolder.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
      if (paramObject.bTodayVotedCnt > 0L)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqNearbyINearbyLikeLimitManager.a(paramObject.lEctID))
        {
          if (paramObject.bAvailableCnt <= 0L) {
            paramCustomViewHolder.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130842688);
          } else {
            paramCustomViewHolder.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130842690);
          }
        }
        else if (paramObject.bAvailableCnt <= 0L) {
          paramCustomViewHolder.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130846065);
        } else {
          paramCustomViewHolder.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130846075);
        }
      }
      else {
        paramCustomViewHolder.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130846062);
      }
      paramCustomViewHolder.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity);
    }
    a(paramCustomViewHolder, paramObject);
    if (!TextUtils.isEmpty(paramObject.strTime))
    {
      paramCustomViewHolder.f.setText(paramObject.strTime);
      paramCustomViewHolder.f.setVisibility(0);
    }
    else
    {
      paramCustomViewHolder.f.setVisibility(8);
    }
    VisitorsActivity.a(paramObject.stVipInfo, paramCustomViewHolder.jdField_b_of_type_AndroidWidgetImageView, paramCustomViewHolder.jdField_a_of_type_AndroidWidgetTextView);
    if (RecentUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.app, str)) {
      paramCustomViewHolder.g.setVisibility(0);
    } else {
      paramCustomViewHolder.g.setVisibility(8);
    }
    localObject = (RelativeLayout.LayoutParams)paramCustomViewHolder.e.getLayoutParams();
    if (paramCustomViewHolder.jdField_b_of_type_AndroidWidgetTextView.getVisibility() == 0) {
      ((RelativeLayout.LayoutParams)localObject).addRule(3, paramCustomViewHolder.jdField_b_of_type_AndroidWidgetTextView.getId());
    } else if (paramCustomViewHolder.jdField_c_of_type_AndroidWidgetTextView.getVisibility() == 0) {
      ((RelativeLayout.LayoutParams)localObject).addRule(3, paramCustomViewHolder.jdField_c_of_type_AndroidWidgetTextView.getId());
    } else {
      ((RelativeLayout.LayoutParams)localObject).addRule(3, paramCustomViewHolder.jdField_a_of_type_AndroidWidgetLinearLayout.getId());
    }
    paramCustomViewHolder.e.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.jdField_a_of_type_JavaUtilHashMap.put(str, paramCustomViewHolder.jdField_a_of_type_AndroidWidgetImageView);
    this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.a(str, paramObject.wFace, paramCustomViewHolder.jdField_a_of_type_AndroidWidgetImageView);
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
    if ((paramArrayList != null) && (paramArrayList.size() >= 1))
    {
      this.jdField_a_of_type_JavaUtilList = paramArrayList;
      this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.k = -1;
      int i = this.jdField_c_of_type_Int * this.jdField_a_of_type_JavaUtilList.size();
      if (i < this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.g) {
        this.e = (this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.g - this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.getTitleBarHeight() - i);
      }
      return;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setDataSet profiles empty:");
      localStringBuilder.append(paramArrayList);
      QLog.d("VisitorsActivity", 2, localStringBuilder.toString());
    }
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
    if (paramInt > this.jdField_a_of_type_JavaUtilList.size() - 1) {
      if (this.jdField_a_of_type_JavaUtilList.size() == 0)
      {
        paramInt = this.f;
        if (paramInt == 0) {
          return 3;
        }
        if (paramInt == 1) {
          return 4;
        }
      }
      else
      {
        if (this.jdField_c_of_type_Boolean) {
          return 1;
        }
        return 2;
      }
    }
    return 0;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int i = getItemViewType(paramInt);
    View localView;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3)
          {
            if (i == 4)
            {
              if (this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.b == null)
              {
                a();
                paramView = this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity;
                paramView.b = paramView.getLayoutInflater().inflate(2131561236, null);
                this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.b.setLayoutParams(new AbsListView.LayoutParams(-1, this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.jdField_a_of_type_Int));
              }
              paramView = this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.b;
            }
          }
          else
          {
            if (this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.jdField_a_of_type_AndroidViewView == null)
            {
              a();
              paramView = this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity;
              paramView.jdField_a_of_type_AndroidViewView = paramView.getLayoutInflater().inflate(2131563039, null);
              this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.jdField_a_of_type_AndroidViewView.setLayoutParams(new AbsListView.LayoutParams(-1, this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.jdField_a_of_type_Int));
            }
            localView = this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.jdField_a_of_type_AndroidViewView;
            TextView localTextView = (TextView)localView.findViewById(2131366233);
            LikeRankingInfo localLikeRankingInfo = this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.jdField_a_of_type_ComTencentMobileqqAppLikeRankingListManager.a();
            paramView = this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.getString(2131720344);
            if ((localLikeRankingInfo == null) || (localLikeRankingInfo.totalLikeCount <= 0)) {
              paramView = this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.getString(2131720343);
            }
            localTextView.setText(paramView);
            paramView = localView;
          }
        }
        else
        {
          if (this.jdField_a_of_type_AndroidViewLayoutInflater == null) {
            this.jdField_a_of_type_AndroidViewLayoutInflater = ((LayoutInflater)paramViewGroup.getContext().getSystemService("layout_inflater"));
          }
          paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131561237, null);
          if (this.jdField_b_of_type_Boolean)
          {
            i = this.e;
            if (i > this.d)
            {
              paramView.setMinimumHeight(i);
              paramView.setLayoutParams(new AbsListView.LayoutParams(-1, this.e));
            }
          }
          ((TextView)paramView.findViewById(2131365200)).setText(this.jdField_a_of_type_JavaLangString);
        }
      }
      else
      {
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
      }
    }
    else
    {
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
      paramView.jdField_c_of_type_AndroidWidgetImageView.setTag(2131369557, Integer.valueOf(paramInt));
      paramView.jdField_a_of_type_Int = paramInt;
      a(a(paramInt), paramView);
      this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.a(localView, paramInt);
      paramView = localView;
    }
    paramView.setTag(-1, Integer.valueOf(paramInt));
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return paramView;
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
      return this.jdField_a_of_type_Boolean ^ true;
    }
    return super.isEnabled(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.VisitorsActivity.VisitorAdapter
 * JD-Core Version:    0.7.0.1
 */