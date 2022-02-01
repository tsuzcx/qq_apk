package com.tencent.mobileqq.activity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.data.CardProfile;
import com.tencent.mobileqq.profile.like.PraiseInfo;
import com.tencent.mobileqq.profile.vote.VoteHelper;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.NearbyZanAnimLayout;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.SwipListView;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

class VisitorsActivity$1
  extends Handler
{
  VisitorsActivity$1(VisitorsActivity paramVisitorsActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    int m = 0;
    int k = 2;
    Object localObject;
    switch (i)
    {
    default: 
    case 13: 
      this.a.b(paramMessage.arg1);
      return;
    case 12: 
      this.a.ap = false;
      return;
    case 11: 
      int j = paramMessage.arg1;
      int n = paramMessage.arg2;
      i = j;
      if (j > 20) {
        i = 20;
      }
      if (i > 0)
      {
        paramMessage = (Object[])paramMessage.obj;
        if ((paramMessage != null) && (paramMessage.length == 2))
        {
          j = ((Integer)paramMessage[0]).intValue();
          localObject = this.a.e;
          int i1 = ((XListView)localObject).getFirstVisiblePosition();
          int i2 = ((XListView)localObject).getLastVisiblePosition();
          if ((j >= i1) && (j <= i2))
          {
            localObject = ((XListView)localObject).getChildAt(j - i1 + ((XListView)localObject).getHeaderViewsCount());
            if (localObject != null)
            {
              localObject = (TextView)((View)localObject).findViewById(2131448874);
              if (localObject != null)
              {
                int[] arrayOfInt = new int[2];
                ((TextView)localObject).getLocationInWindow(arrayOfInt);
                PraiseInfo localPraiseInfo = (PraiseInfo)paramMessage[1];
                if (TextUtils.isEmpty(localPraiseInfo.c)) {
                  j = 1;
                } else {
                  j = localPraiseInfo.c.length() + 1;
                }
                if (!TextUtils.isEmpty(((TextView)localObject).getText())) {
                  k = ((TextView)localObject).getText().length() * 2;
                }
                float f1 = arrayOfInt[0] + ((TextView)localObject).getWidth() * j / k;
                float f2 = arrayOfInt[1] - this.a.at + ((TextView)localObject).getPaddingTop();
                if ((n > 0) && (localPraiseInfo.j != null)) {
                  this.a.ab.a(localPraiseInfo, localPraiseInfo.j, f1, f2);
                } else {
                  this.a.ab.a(localPraiseInfo, localPraiseInfo.h, f1, f2);
                }
                i -= 1;
                if (i > 0)
                {
                  paramMessage = this.a.ar.obtainMessage(11, i, n, paramMessage);
                  if (this.a.ao == null) {
                    this.a.ao = new Random();
                  }
                  i = com.tencent.mobileqq.dating.NewVoteAnimHelper.a[this.a.ao.nextInt(com.tencent.mobileqq.dating.NewVoteAnimHelper.a.length)];
                  this.a.ar.sendMessageDelayed(paramMessage, i * 5);
                  i = m;
                  break label535;
                }
                this.a.ar.sendEmptyMessageDelayed(12, 2000L);
                i = m;
                break label535;
              }
            }
          }
        }
      }
      i = 1;
      if (i != 0)
      {
        this.a.ar.sendEmptyMessageDelayed(12, 100L);
        return;
      }
      break;
    case 10: 
      this.a.a(false, paramMessage.arg1, paramMessage.arg2, paramMessage.getData().getInt("totalVoteCount"));
      return;
    case 9: 
      paramMessage = (CardProfile)paramMessage.obj;
      this.a.c.b(paramMessage);
      return;
    case 8: 
      if (QLog.isColorLevel()) {
        QLog.d("VisitorsActivity", 2, "setDataSet fresh fav data");
      }
      this.a.f.a(this.a.d);
      this.a.f.notifyDataSetChanged();
      return;
    case 7: 
      if (QLog.isColorLevel()) {
        QLog.d("VisitorsActivity", 2, "setDataSet fresh fav data");
      }
      this.a.k.a(this.a.l);
      this.a.k.notifyDataSetChanged();
      return;
    case 6: 
      this.a.c.b();
      return;
    case 5: 
      paramMessage = paramMessage.obj;
      if ((paramMessage instanceof Object[]))
      {
        localObject = (Object[])paramMessage;
        paramMessage = (ArrayList)localObject[0];
        localObject = (ArrayList)localObject[1];
        this.a.d.addAll(paramMessage);
        this.a.l.addAll((Collection)localObject);
        if (QLog.isColorLevel()) {
          QLog.d("VisitorsActivity", 2, "setDataSet visitor UI_ONINIT");
        }
        this.a.f.a(this.a.d);
        if (QLog.isColorLevel()) {
          QLog.d("VisitorsActivity", 2, "setDataSet favor UI_ONINIT");
        }
        this.a.k.a(this.a.l);
        this.a.f.notifyDataSetChanged();
        this.a.k.notifyDataSetChanged();
      }
      paramMessage = this.a;
      paramMessage.af = true;
      if (!NetworkUtil.isNetSupport(paramMessage))
      {
        this.a.ar.sendEmptyMessageDelayed(2, 1000L);
        return;
      }
      this.a.b(true);
      return;
    case 4: 
      this.a.e.springBackOverScrollHeaderView();
      return;
    case 3: 
      if (this.a.ac == 0) {
        this.a.f.notifyDataSetChanged();
      } else {
        this.a.k.notifyDataSetChanged();
      }
      this.a.av = SystemClock.uptimeMillis();
      return;
    case 2: 
      this.a.stopTitleProgress();
      this.a.e.springBackOverScrollHeaderView();
      this.a.e.springBackOverScrollHeaderView();
      paramMessage = this.a;
      paramMessage.a(1, paramMessage.getString(2131892104));
      return;
    case 1: 
      label535:
      this.a.e.springBackOverScrollHeaderView();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.VisitorsActivity.1
 * JD-Core Version:    0.7.0.1
 */