package com.tencent.mobileqq.activity.specialcare;

import android.os.Handler;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.data.SpecialCareInfo;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import java.util.List;

class SpecailCareListActivity$4
  extends FriendListObserver
{
  SpecailCareListActivity$4(SpecailCareListActivity paramSpecailCareListActivity) {}
  
  protected void onSetSpecialCareSwitch_global(boolean paramBoolean, Object[] paramArrayOfObject)
  {
    int i = ((Integer)paramArrayOfObject[0]).intValue();
    paramArrayOfObject = (String[])paramArrayOfObject[1];
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onSetSpecialCareSwitch_global isSucess= ");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(",type=");
      localStringBuilder.append(i);
      localStringBuilder.append(",uinSize=");
      localStringBuilder.append(paramArrayOfObject.length);
      QLog.d("SpecailCareListActivity", 2, localStringBuilder.toString());
    }
    boolean bool;
    if ((SpecailCareListActivity.a(this.a) != null) && (paramArrayOfObject != null)) {
      bool = Arrays.equals(SpecailCareListActivity.a(this.a), paramArrayOfObject);
    } else {
      bool = false;
    }
    if (bool)
    {
      if (paramArrayOfObject.length >= 1)
      {
        this.a.h();
        if (paramBoolean)
        {
          if (this.a.m != null)
          {
            this.a.d();
            QQToast.makeText(BaseApplication.getContext(), 2, 2131886209, 0).show(this.a.getTitleBarHeight());
          }
          else
          {
            QQToast.makeText(BaseApplication.getContext(), 2, 2131897342, 0).show(this.a.getTitleBarHeight());
          }
          this.a.a();
          this.a.o.notifyDataSetChanged();
          return;
        }
        if (this.a.m != null)
        {
          QQToast.makeText(BaseApplication.getContext(), 1, 2131897326, 0).show(this.a.getTitleBarHeight());
          return;
        }
        QQToast.makeText(BaseApplication.getContext(), 1, 2131897341, 0).show(this.a.getTitleBarHeight());
        return;
      }
      if (paramBoolean)
      {
        this.a.a();
        this.a.o.notifyDataSetChanged();
      }
    }
    else if (paramBoolean)
    {
      this.a.a();
      this.a.o.notifyDataSetChanged();
    }
  }
  
  protected void onUpdateDelFriend(boolean paramBoolean, Object paramObject)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onUpdateDelFriend isSucess= ");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(", uin=");
      localStringBuilder.append((Long)paramObject);
      QLog.d("SpecailCareListActivity", 2, localStringBuilder.toString());
    }
    if (paramBoolean)
    {
      this.a.a();
      this.a.o.notifyDataSetChanged();
    }
  }
  
  protected void onUpdateFriendList(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onUpdateFriendList isSuccess=");
      localStringBuilder.append(paramBoolean1);
      localStringBuilder.append(", isComplete=");
      localStringBuilder.append(paramBoolean2);
      localStringBuilder.append(" mIsPullRefresh=");
      localStringBuilder.append(this.a.r);
      QLog.d("SpecailCareListActivity", 2, localStringBuilder.toString());
    }
    if ((!paramBoolean1) || (paramBoolean2))
    {
      this.a.a();
      this.a.o.notifyDataSetChanged();
    }
    if (this.a.r)
    {
      if ((paramBoolean1) && (paramBoolean2))
      {
        this.a.j.a(0);
        this.a.A.sendEmptyMessageDelayed(2001, 1000L);
        this.a.r = false;
        return;
      }
      if (!paramBoolean1)
      {
        this.a.j.a(1);
        this.a.A.sendEmptyMessageDelayed(2001, 1000L);
        this.a.r = false;
      }
    }
  }
  
  protected void onUpdateOnlineFriend(boolean paramBoolean, String[] paramArrayOfString)
  {
    if (QLog.isColorLevel())
    {
      paramArrayOfString = new StringBuilder();
      paramArrayOfString.append("onUpdateSignature isSucess= ");
      paramArrayOfString.append(paramBoolean);
      QLog.d("SpecailCareListActivity", 2, paramArrayOfString.toString());
    }
    if (paramBoolean)
    {
      if (this.a.E != 0)
      {
        this.a.y = true;
        return;
      }
      this.a.o.notifyDataSetChanged();
    }
  }
  
  protected void onUpdateSignature(boolean paramBoolean, String[] paramArrayOfString)
  {
    if (QLog.isColorLevel())
    {
      paramArrayOfString = new StringBuilder();
      paramArrayOfString.append("onUpdateSignature isSucess= ");
      paramArrayOfString.append(paramBoolean);
      QLog.d("SpecailCareListActivity", 2, paramArrayOfString.toString());
    }
    if (this.a.E != 0)
    {
      this.a.y = true;
      return;
    }
    this.a.o.notifyDataSetChanged();
  }
  
  protected void onUpdateSpecialCareList(boolean paramBoolean1, boolean paramBoolean2, List<SpecialCareInfo> paramList)
  {
    if (QLog.isColorLevel())
    {
      paramList = new StringBuilder();
      paramList.append("onUpdateSpecialCareList isSucess= ");
      paramList.append(paramBoolean1);
      paramList.append(",isComplete=");
      paramList.append(paramBoolean2);
      QLog.d("SpecailCareListActivity", 2, paramList.toString());
    }
    if (paramBoolean1)
    {
      this.a.a();
      this.a.o.notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.specialcare.SpecailCareListActivity.4
 * JD-Core Version:    0.7.0.1
 */