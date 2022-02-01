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
  VoteItemClickListener a;
  List<CardProfile> b = new ArrayList();
  boolean c;
  public int d = 0;
  public String e;
  LayoutInflater f;
  boolean g;
  int h;
  int i;
  int j;
  int k;
  protected INearbyLikeLimitManager l;
  private int n = 0;
  private boolean o = false;
  private int p;
  private int q;
  
  public VisitorsActivity$VisitorAdapter(VisitorsActivity paramVisitorsActivity, Context paramContext, QQAppInterface paramQQAppInterface, VoteItemClickListener paramVoteItemClickListener, int paramInt, boolean paramBoolean)
  {
    paramContext = paramVisitorsActivity.getResources();
    this.p = AIOUtils.b(17.0F, paramContext);
    this.q = AIOUtils.b(15.0F, paramContext);
    this.a = paramVoteItemClickListener;
    this.n = paramInt;
    this.g = paramBoolean;
    this.h = AIOUtils.b(38.0F, paramContext);
    this.i = AIOUtils.b(86.0F, paramContext);
    this.j = AIOUtils.b(60.0F, paramContext);
    this.l = ((INearbyLikeLimitManager)paramVisitorsActivity.app.getManager(QQManagerFactory.NEARBY_LIKE_LIMIT_MANAGER));
  }
  
  private View a(ViewGroup paramViewGroup)
  {
    paramViewGroup = this.m.getLayoutInflater().inflate(2131625253, paramViewGroup, false);
    VisitorsActivity.CustomViewHolder localCustomViewHolder = new VisitorsActivity.CustomViewHolder();
    localCustomViewHolder.a = ((LinearLayout)paramViewGroup.findViewById(2131447781));
    localCustomViewHolder.b = ((ImageView)paramViewGroup.findViewById(2131435219));
    localCustomViewHolder.d = ((ImageView)paramViewGroup.findViewById(2131449927));
    localCustomViewHolder.c = ((TextView)paramViewGroup.findViewById(2131447063));
    localCustomViewHolder.f = ((TextView)paramViewGroup.findViewById(2131450349));
    localCustomViewHolder.e = ((TextView)paramViewGroup.findViewById(2131436844));
    localCustomViewHolder.g = ((TextView)paramViewGroup.findViewById(2131448874));
    localCustomViewHolder.h = ((TextView)paramViewGroup.findViewById(2131431661));
    localCustomViewHolder.i = ((TextView)paramViewGroup.findViewById(2131448877));
    localCustomViewHolder.j = ((ImageView)paramViewGroup.findViewById(2131436660));
    localCustomViewHolder.k = ((TextView)paramViewGroup.findViewById(2131433797));
    localCustomViewHolder.l = ((SimpleTextView)paramViewGroup.findViewById(2131429998));
    localCustomViewHolder.l.setGravity(17);
    localCustomViewHolder.l.setText(this.m.getString(2131889653));
    localCustomViewHolder.l.setTextSize(1, 16.0F);
    localCustomViewHolder.l.setTextColor(-1);
    localCustomViewHolder.l.setOnClickListener(new VisitorsActivity.VisitorAdapter.3(this, localCustomViewHolder));
    paramViewGroup.findViewById(2131431280).getLayoutParams().width = VisitorsActivity.e(this.m);
    paramViewGroup.setTag(localCustomViewHolder);
    return paramViewGroup;
  }
  
  private void a()
  {
    if (this.m.j == 0)
    {
      Rect localRect = new Rect();
      if ((this.m.x != null) && (this.m.x.getVisibility() == 0)) {
        localObject = this.m.x;
      } else {
        localObject = this.m.b;
      }
      ((View)localObject).getGlobalVisibleRect(localRect);
      int i1 = localRect.bottom;
      int i2 = this.m.getResources().getDisplayMetrics().heightPixels;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("init empty h ");
        ((StringBuilder)localObject).append(this.m.j);
        QLog.d("VisitorsActivity", 2, ((StringBuilder)localObject).toString());
      }
      Object localObject = this.m;
      ((VisitorsActivity)localObject).j = (i2 - i1 - AIOUtils.b(75.0F, ((VisitorsActivity)localObject).getResources()));
    }
  }
  
  private void a(VisitorsActivity.CustomViewHolder paramCustomViewHolder, CardProfile paramCardProfile)
  {
    TextView localTextView = paramCustomViewHolder.h;
    Object localObject = (RelativeLayout.LayoutParams)localTextView.getLayoutParams();
    if (paramCustomViewHolder.e.getVisibility() == 0) {
      ((RelativeLayout.LayoutParams)localObject).addRule(3, paramCustomViewHolder.e.getId());
    } else if (paramCustomViewHolder.f.getVisibility() == 0) {
      ((RelativeLayout.LayoutParams)localObject).addRule(3, paramCustomViewHolder.f.getId());
    } else {
      ((RelativeLayout.LayoutParams)localObject).addRule(3, paramCustomViewHolder.c.getId());
    }
    localTextView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    int i1 = ((Integer)paramCustomViewHolder.j.getTag(2131436660)).intValue();
    localObject = this.m.a(paramCardProfile, paramCustomViewHolder.g, false, i1);
    if (paramCardProfile.payVoteCount > 0)
    {
      paramCustomViewHolder.n = 0;
      paramCustomViewHolder.g.setText(TextUtils.concat(new CharSequence[] { localObject, "，" }));
      if (this.n == 0) {
        i1 = 2131913747;
      } else {
        i1 = 2131913748;
      }
      localTextView.setText(String.format("%s%d金豆", new Object[] { HardCodeUtil.a(i1), Integer.valueOf(paramCardProfile.payVoteCount * 2) }));
      localTextView.setVisibility(0);
      return;
    }
    paramCustomViewHolder.n = 0;
    localTextView.setVisibility(8);
    paramCustomViewHolder.g.setText((CharSequence)localObject);
  }
  
  private void a(VisitorsActivity.MoreViewHolder paramMoreViewHolder)
  {
    Object localObject = paramMoreViewHolder.a;
    if (this.c) {
      i1 = 2131891378;
    } else {
      i1 = 2131891858;
    }
    ((TextView)localObject).setText(i1);
    localObject = paramMoreViewHolder.b;
    boolean bool = this.c;
    int i2 = 0;
    if (bool) {
      i1 = 0;
    } else {
      i1 = 8;
    }
    ((ProgressBar)localObject).setVisibility(i1);
    paramMoreViewHolder = paramMoreViewHolder.c;
    int i1 = i2;
    if (this.c) {
      i1 = 8;
    }
    paramMoreViewHolder.setVisibility(i1);
  }
  
  private void a(Object paramObject, VisitorsActivity.CustomViewHolder paramCustomViewHolder)
  {
    if (paramObject == null) {
      return;
    }
    paramObject = (CardProfile)paramObject;
    String str = String.valueOf(paramObject.lEctID);
    paramCustomViewHolder.o = paramObject;
    Object localObject = StringUtil.trim(String.valueOf(paramObject.strNick));
    paramCustomViewHolder.c.setText((CharSequence)localObject);
    if (paramObject.bAage > 0) {
      paramCustomViewHolder.e.setText(String.valueOf(paramObject.bAage));
    } else {
      paramCustomViewHolder.e.setText("");
    }
    localObject = paramCustomViewHolder.e;
    if (paramObject.bSex == 1) {
      i1 = 2130841306;
    } else {
      i1 = 2130841311;
    }
    ((TextView)localObject).setCompoundDrawablesWithIntrinsicBounds(i1, 0, 0, 0);
    if (paramObject.bSex == 1) {
      paramCustomViewHolder.e.setBackgroundResource(2130847199);
    } else {
      paramCustomViewHolder.e.setBackgroundResource(2130847208);
    }
    if ((paramObject.bConstellation != 0) && (paramObject.bConstellation <= 12))
    {
      paramCustomViewHolder.f.setText(ProfileCardUtil.a(paramObject.bConstellation));
      paramCustomViewHolder.f.setBackgroundResource(2130847209);
      paramCustomViewHolder.f.setVisibility(0);
    }
    else
    {
      paramCustomViewHolder.f.setVisibility(8);
    }
    paramCustomViewHolder.j.setTag(paramObject);
    int i1 = this.m.a(paramObject, str);
    if ((i1 != 0) && (i1 != 2))
    {
      paramCustomViewHolder.j.setVisibility(8);
    }
    else
    {
      paramCustomViewHolder.j.setVisibility(0);
      if (paramObject.bTodayVotedCnt > 0L)
      {
        if (this.l.a(paramObject.lEctID))
        {
          if (paramObject.bAvailableCnt <= 0L) {
            paramCustomViewHolder.j.setImageResource(2130843641);
          } else {
            paramCustomViewHolder.j.setImageResource(2130843643);
          }
        }
        else if (paramObject.bAvailableCnt <= 0L) {
          paramCustomViewHolder.j.setImageResource(2130847535);
        } else {
          paramCustomViewHolder.j.setImageResource(2130847545);
        }
      }
      else {
        paramCustomViewHolder.j.setImageResource(2130847532);
      }
      paramCustomViewHolder.j.setOnClickListener(this.m);
    }
    a(paramCustomViewHolder, paramObject);
    if (!TextUtils.isEmpty(paramObject.strTime))
    {
      paramCustomViewHolder.i.setText(paramObject.strTime);
      paramCustomViewHolder.i.setVisibility(0);
    }
    else
    {
      paramCustomViewHolder.i.setVisibility(8);
    }
    VisitorsActivity.a(paramObject.stVipInfo, paramCustomViewHolder.d, paramCustomViewHolder.c);
    if (RecentUtil.a(this.m.app, str)) {
      paramCustomViewHolder.k.setVisibility(0);
    } else {
      paramCustomViewHolder.k.setVisibility(8);
    }
    localObject = (RelativeLayout.LayoutParams)paramCustomViewHolder.h.getLayoutParams();
    if (paramCustomViewHolder.e.getVisibility() == 0) {
      ((RelativeLayout.LayoutParams)localObject).addRule(3, paramCustomViewHolder.e.getId());
    } else if (paramCustomViewHolder.f.getVisibility() == 0) {
      ((RelativeLayout.LayoutParams)localObject).addRule(3, paramCustomViewHolder.f.getId());
    } else {
      ((RelativeLayout.LayoutParams)localObject).addRule(3, paramCustomViewHolder.a.getId());
    }
    paramCustomViewHolder.h.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.m.ad.put(str, paramCustomViewHolder.b);
    this.m.a(str, paramObject.wFace, paramCustomViewHolder.b);
  }
  
  private View b()
  {
    View localView = this.m.getLayoutInflater().inflate(2131625460, null);
    VisitorsActivity.MoreViewHolder localMoreViewHolder = new VisitorsActivity.MoreViewHolder();
    localMoreViewHolder.a = ((TextView)localView.findViewById(2131438894));
    localMoreViewHolder.b = ((ProgressBar)localView.findViewById(2131444560));
    localMoreViewHolder.c = ((ImageView)localView.findViewById(2131437616));
    localView.setTag(localMoreViewHolder);
    return localView;
  }
  
  public CardProfile a(int paramInt)
  {
    if (paramInt < this.b.size()) {
      return (CardProfile)this.b.get(paramInt);
    }
    return null;
  }
  
  public void a(ArrayList<CardProfile> paramArrayList)
  {
    if ((paramArrayList != null) && (paramArrayList.size() >= 1))
    {
      this.b = paramArrayList;
      this.m.aA = -1;
      int i1 = this.i * this.b.size();
      if (i1 < this.m.X) {
        this.k = (this.m.X - this.m.getTitleBarHeight() - i1);
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
    this.o = paramBoolean;
  }
  
  public CardProfile b(int paramInt)
  {
    if (paramInt < this.b.size()) {
      return (CardProfile)this.b.remove(paramInt);
    }
    return null;
  }
  
  public int getCount()
  {
    return this.b.size() + 1;
  }
  
  public long getItemId(int paramInt)
  {
    if (paramInt > this.b.size() - 1) {
      return -1L;
    }
    return ((CardProfile)this.b.get(paramInt)).lEctID;
  }
  
  public int getItemViewType(int paramInt)
  {
    if (paramInt > this.b.size() - 1) {
      if (this.b.size() == 0)
      {
        paramInt = this.n;
        if (paramInt == 0) {
          return 3;
        }
        if (paramInt == 1) {
          return 4;
        }
      }
      else
      {
        if (this.o) {
          return 1;
        }
        return 2;
      }
    }
    return 0;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int i1 = getItemViewType(paramInt);
    View localView;
    if (i1 != 0)
    {
      if (i1 != 1)
      {
        if (i1 != 2)
        {
          if (i1 != 3)
          {
            if (i1 == 4)
            {
              if (this.m.n == null)
              {
                a();
                paramView = this.m;
                paramView.n = paramView.getLayoutInflater().inflate(2131627592, null);
                this.m.n.setLayoutParams(new AbsListView.LayoutParams(-1, this.m.j));
              }
              paramView = this.m.n;
            }
          }
          else
          {
            if (this.m.h == null)
            {
              a();
              paramView = this.m;
              paramView.h = paramView.getLayoutInflater().inflate(2131629653, null);
              this.m.h.setLayoutParams(new AbsListView.LayoutParams(-1, this.m.j));
            }
            localView = this.m.h;
            TextView localTextView = (TextView)localView.findViewById(2131432525);
            LikeRankingInfo localLikeRankingInfo = this.m.r.b();
            paramView = this.m.getString(2131917981);
            if ((localLikeRankingInfo == null) || (localLikeRankingInfo.totalLikeCount <= 0)) {
              paramView = this.m.getString(2131917980);
            }
            localTextView.setText(paramView);
            paramView = localView;
          }
        }
        else
        {
          if (this.f == null) {
            this.f = ((LayoutInflater)paramViewGroup.getContext().getSystemService("layout_inflater"));
          }
          paramView = this.f.inflate(2131627593, null);
          if (this.g)
          {
            i1 = this.k;
            if (i1 > this.j)
            {
              paramView.setMinimumHeight(i1);
              paramView.setLayoutParams(new AbsListView.LayoutParams(-1, this.k));
            }
          }
          ((TextView)paramView.findViewById(2131431364)).setText(this.e);
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
          localView = b();
          localView.setOnClickListener(new VisitorsActivity.VisitorAdapter.2(this));
        }
        a((VisitorsActivity.MoreViewHolder)localView.getTag());
        paramView = localView;
      }
    }
    else
    {
      if (paramInt > this.d) {
        this.d = paramInt;
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
      paramView.j.setTag(2131436660, Integer.valueOf(paramInt));
      paramView.m = paramInt;
      a(a(paramInt), paramView);
      this.m.a(localView, paramInt);
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
    if (paramInt > this.b.size() - 1) {
      return this.c ^ true;
    }
    return super.isEnabled(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.VisitorsActivity.VisitorAdapter
 * JD-Core Version:    0.7.0.1
 */