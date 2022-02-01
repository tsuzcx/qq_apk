package com.tencent.mobileqq.activity;

import android.text.SpannableString;
import android.text.style.RelativeSizeSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.LikeRankingInfo;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

class LikeRankingListActivity$LikeRankingListAdapter
  extends BaseAdapter
{
  List<LikeRankingInfo> a = new ArrayList();
  boolean b = false;
  String c;
  String d;
  RelativeSizeSpan e = new RelativeSizeSpan(0.62F);
  int[] f = { 2130846984, 2130846985, 2130846986 };
  int[] g = { 2130846981, 2130846982, 2130846983 };
  
  public LikeRankingListActivity$LikeRankingListAdapter(LikeRankingListActivity paramLikeRankingListActivity)
  {
    this.d = paramLikeRankingListActivity.getString(2131917332);
    this.c = paramLikeRankingListActivity.getString(2131891211);
  }
  
  public LikeRankingInfo a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.a.size())) {
      return (LikeRankingInfo)this.a.get(paramInt);
    }
    return null;
  }
  
  public void a(List<LikeRankingInfo> paramList, boolean paramBoolean)
  {
    this.a.clear();
    LikeRankingInfo localLikeRankingInfo1 = this.h.h;
    int i = paramList.size() - 1;
    while (i >= 0)
    {
      LikeRankingInfo localLikeRankingInfo2 = (LikeRankingInfo)paramList.get(i);
      if (localLikeRankingInfo2.uin == this.h.h.uin)
      {
        this.h.h = localLikeRankingInfo2;
        break;
      }
      i -= 1;
    }
    if ((this.a.size() == 0) && (this.h.h.rankingNum > 3) && (this.h.h.likeCountOfToday > 0)) {
      this.a.add(this.h.h);
    }
    if (QLog.isColorLevel()) {
      QLog.i("LikeRankingListActivity", 2, String.format("setList isServer:%s oldRankInfo:%s newRankInfo:%s size:%d", new Object[] { Boolean.valueOf(paramBoolean), localLikeRankingInfo1, this.h.h, Integer.valueOf(paramList.size()) }));
    }
    this.a.addAll(paramList);
    this.b = false;
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    return this.a.size() + 1;
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public int getItemViewType(int paramInt)
  {
    if (paramInt == getCount() - 1) {
      return 1;
    }
    return 0;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int i = getItemViewType(paramInt);
    View localView = paramView;
    if (paramView == null) {
      if (i != 0)
      {
        if (i != 1)
        {
          localView = paramView;
        }
        else
        {
          localView = LayoutInflater.from(this.h).inflate(2131625460, null);
          paramView = new LikeRankingListActivity.LikeRankingListAdapter.MoreViewHolder(this);
          paramView.a = ((TextView)localView.findViewById(2131438894));
          paramView.b = ((ProgressBar)localView.findViewById(2131444560));
          paramView.c = ((ImageView)localView.findViewById(2131437616));
          localView.setTag(paramView);
        }
      }
      else
      {
        localView = LayoutInflater.from(this.h).inflate(2131627504, null);
        paramView = new LikeRankingListActivity.LikeRankingListAdapter.ViewHolder(this);
        paramView.a = ((TextView)localView.findViewById(2131448682));
        paramView.b = ((ImageView)localView.findViewById(2131436525));
        paramView.c = ((ImageView)localView.findViewById(2131436273));
        paramView.d = ((ImageView)localView.findViewById(2131436271));
        paramView.e = ((TextView)localView.findViewById(2131448606));
        paramView.f = ((TextView)localView.findViewById(2131448829));
        paramView.g = ((TextView)localView.findViewById(2131448561));
        paramView.h = localView.findViewById(2131432003);
        localView.setTag(paramView);
      }
    }
    int k = 8;
    int j = 0;
    Object localObject;
    if (i != 0)
    {
      if (i == 1)
      {
        paramView = (LikeRankingListActivity.LikeRankingListAdapter.MoreViewHolder)localView.getTag();
        localObject = paramView.a;
        if (this.b) {
          i = 2131891378;
        } else {
          i = 2131891858;
        }
        ((TextView)localObject).setText(i);
        localObject = paramView.b;
        if (this.b) {
          i = 0;
        } else {
          i = 8;
        }
        ((ProgressBar)localObject).setVisibility(i);
        paramView = paramView.c;
        if (this.b) {
          i = k;
        } else {
          i = 0;
        }
        paramView.setVisibility(i);
        if (this.b) {
          i = j;
        } else {
          i = 4;
        }
        localView.setVisibility(i);
      }
    }
    else
    {
      LikeRankingInfo localLikeRankingInfo = a(paramInt);
      if (localLikeRankingInfo != null)
      {
        LikeRankingListActivity.LikeRankingListAdapter.ViewHolder localViewHolder = (LikeRankingListActivity.LikeRankingListAdapter.ViewHolder)localView.getTag();
        localViewHolder.a.setText(String.valueOf(paramInt));
        if ((paramInt == 0) && (localLikeRankingInfo.uin == this.h.h.uin) && ((localLikeRankingInfo.rankingNum > 3) || (localLikeRankingInfo.rankingNum < 1))) {
          localViewHolder.h.setVisibility(0);
        } else {
          localViewHolder.h.setVisibility(8);
        }
        String str = String.valueOf(localLikeRankingInfo.uin);
        paramView = this.h.b.m(str);
        if (paramView != null)
        {
          localViewHolder.e.setText(paramView.getFriendNick());
          localObject = this.h.c.getBitmapFromCache(1, str);
          paramView = (View)localObject;
          if (localObject == null)
          {
            if (!this.h.c.isPausing()) {
              this.h.c.requestDecodeFace(str, 1, true);
            }
            paramView = ImageUtil.k();
          }
          localViewHolder.d.setImageBitmap(paramView);
        }
        else
        {
          localViewHolder.e.setText(str);
          localViewHolder.d.setImageBitmap(ImageUtil.k());
        }
        i = localLikeRankingInfo.rankingNum;
        if ((i != 1) && (i != 2) && (i != 3))
        {
          if (localLikeRankingInfo.rankingNum < 1) {
            localViewHolder.a.setText("-");
          } else {
            localViewHolder.a.setText(String.valueOf(localLikeRankingInfo.rankingNum));
          }
          localViewHolder.b.setVisibility(8);
          localViewHolder.c.setVisibility(8);
        }
        else
        {
          localViewHolder.a.setText(String.valueOf(localLikeRankingInfo.rankingNum));
          localViewHolder.b.setVisibility(8);
          localViewHolder.c.setImageResource(this.g[(localLikeRankingInfo.rankingNum - 1)]);
          localViewHolder.c.setVisibility(0);
        }
        paramView = new SpannableString(String.format(Locale.CHINA, this.c, new Object[] { Integer.valueOf(localLikeRankingInfo.likeCountOfToday) }));
        paramView.setSpan(this.e, 0, 1, 33);
        localViewHolder.g.setText(paramView);
        localViewHolder.f.setText(String.format(Locale.CHINA, this.d, new Object[] { Integer.valueOf(localLikeRankingInfo.totalLikeCount) }));
      }
    }
    EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
    return localView;
  }
  
  public int getViewTypeCount()
  {
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.LikeRankingListActivity.LikeRankingListAdapter
 * JD-Core Version:    0.7.0.1
 */