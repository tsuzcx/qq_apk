package com.tencent.mobileqq.activity;

import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.INearbyLikeLimitManager.LikeResultItem;
import com.tencent.mobileqq.nearby.business.NearbyCardObserver;
import com.tencent.mobileqq.profile.vote.VoteHelper;
import java.util.ArrayList;
import java.util.Iterator;

class VisitorsActivity$14
  extends NearbyCardObserver
{
  VisitorsActivity$14(VisitorsActivity paramVisitorsActivity) {}
  
  public void a(boolean paramBoolean, String paramString)
  {
    if ((paramBoolean) && (TextUtils.equals("0", paramString)))
    {
      if (this.a.f != null) {
        this.a.f.notifyDataSetChanged();
      }
      if (this.a.k != null) {
        this.a.k.notifyDataSetChanged();
      }
    }
  }
  
  public void a(boolean paramBoolean, String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    if (!paramString1.equals(this.a.app.getCurrentAccountUin())) {
      return;
    }
    if (paramInt2 == 1)
    {
      if (!paramBoolean)
      {
        this.a.c.b(paramString2, paramInt1, false);
        return;
      }
      this.a.c.a(paramString2, paramInt1, false);
      return;
    }
    if (paramInt2 == 0) {
      this.a.c.a(Long.parseLong(paramString2));
    }
  }
  
  public void a(boolean paramBoolean, ArrayList<Object> paramArrayList, int paramInt)
  {
    if ((paramBoolean) && (paramArrayList != null)) {
      try
      {
        if (paramArrayList.size() > 0)
        {
          paramArrayList = paramArrayList.iterator();
          while (paramArrayList.hasNext())
          {
            INearbyLikeLimitManager.LikeResultItem localLikeResultItem = (INearbyLikeLimitManager.LikeResultItem)paramArrayList.next();
            if (paramInt == 511)
            {
              if (localLikeResultItem.a == 0)
              {
                VoteHelper localVoteHelper = this.a.c;
                StringBuilder localStringBuilder = new StringBuilder();
                localStringBuilder.append(localLikeResultItem.c);
                localStringBuilder.append("");
                localVoteHelper.a(localStringBuilder.toString(), localLikeResultItem.d + localLikeResultItem.e, false);
              }
            }
            else if (localLikeResultItem.a == 0) {
              this.a.c.a(localLikeResultItem.c);
            }
          }
        }
        return;
      }
      catch (Exception paramArrayList)
      {
        paramArrayList.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.VisitorsActivity.14
 * JD-Core Version:    0.7.0.1
 */