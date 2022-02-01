package com.tencent.av.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.av.VideoController;
import com.tencent.av.VideoController.GAudioFriends;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.PinnedDividerListView;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class GAudioMemberListCtrl
{
  WeakReference<Context> a = null;
  long b = 0L;
  int c = 0;
  VideoController d = null;
  LayoutInflater e = null;
  ArrayList<GAudioMemberListCtrl.GAudioMemberInfo> f = new ArrayList();
  View.OnClickListener g = new GAudioMemberListCtrl.1(this);
  View.OnClickListener h = new GAudioMemberListCtrl.2(this);
  private PinnedDividerListView i = null;
  private GAudioMemberListCtrl.GAudioMemberListAdapter j = null;
  private VideoAppInterface k = null;
  private boolean l = false;
  private boolean m = false;
  
  @TargetApi(9)
  public GAudioMemberListCtrl(Context paramContext, VideoAppInterface paramVideoAppInterface, PinnedDividerListView paramPinnedDividerListView, long paramLong, int paramInt, boolean paramBoolean)
  {
    this.a = new WeakReference(paramContext);
    this.i = paramPinnedDividerListView;
    this.b = paramLong;
    this.c = paramInt;
    this.k = paramVideoAppInterface;
    this.d = this.k.b();
    if (this.d == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("GAudioMemberListCtrl", 2, "MVMembersContolUI-->can not get videoControl");
      }
      return;
    }
    this.e = LayoutInflater.from((Context)this.a.get());
    this.j = new GAudioMemberListCtrl.GAudioMemberListAdapter(this, null);
    this.i.setAdapter(this.j);
    this.l = paramBoolean;
    this.m = ThemeUtil.isInNightMode(this.k);
  }
  
  private int a(long paramLong)
  {
    int n = 0;
    while (n < this.f.size())
    {
      if (((GAudioMemberListCtrl.GAudioMemberInfo)this.f.get(n)).a == paramLong) {
        return n;
      }
      n += 1;
    }
    return -1;
  }
  
  private void b(ArrayList<VideoController.GAudioFriends> paramArrayList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GAudioMemberListCtrl", 2, "refreshDataSource");
    }
    if (paramArrayList == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("GAudioMemberListCtrl", 2, "refreshDataSource-->friends list is null");
      }
      return;
    }
    this.f.clear();
    int n = 0;
    while (n < paramArrayList.size())
    {
      VideoController.GAudioFriends localGAudioFriends = (VideoController.GAudioFriends)paramArrayList.get(n);
      GAudioMemberListCtrl.GAudioMemberInfo localGAudioMemberInfo = new GAudioMemberListCtrl.GAudioMemberInfo(this, null);
      localGAudioMemberInfo.a = localGAudioFriends.a;
      localGAudioMemberInfo.b = localGAudioFriends.b;
      localGAudioMemberInfo.g = localGAudioFriends.n;
      localGAudioMemberInfo.h = localGAudioFriends.o;
      localGAudioMemberInfo.i = localGAudioFriends.p;
      localGAudioMemberInfo.j = localGAudioFriends.q;
      localGAudioMemberInfo.k = localGAudioFriends.w;
      this.f.add(localGAudioMemberInfo);
      n += 1;
    }
  }
  
  public void a()
  {
    int i1 = this.i.getFirstVisiblePosition();
    boolean bool2 = false;
    int n = i1;
    if (i1 < 0) {
      n = 0;
    }
    int i2 = this.i.getLastVisiblePosition();
    i1 = n;
    boolean bool1;
    Object localObject;
    for (;;)
    {
      bool1 = bool2;
      if (i1 >= i2) {
        break;
      }
      bool1 = bool2;
      if (i1 >= this.f.size()) {
        break;
      }
      localObject = (GAudioMemberListCtrl.GAudioMemberInfo)this.f.get(i1);
      if ((localObject != null) && (!((GAudioMemberListCtrl.GAudioMemberInfo)localObject).c))
      {
        bool1 = true;
        break;
      }
      i1 += 1;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("refreshHeadbitmap-->minIndex=");
      ((StringBuilder)localObject).append(n);
      ((StringBuilder)localObject).append(",maxIndex=");
      ((StringBuilder)localObject).append(i2);
      ((StringBuilder)localObject).append(",needRefresh=");
      ((StringBuilder)localObject).append(bool1);
      QLog.d("GAudioMemberListCtrl", 2, ((StringBuilder)localObject).toString());
    }
    if (bool1) {
      this.j.notifyDataSetChanged();
    }
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    paramInt2 = a(paramLong);
    if (paramInt2 == -1)
    {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("notifyDataSetChanged-->this member not in infoList.uin=");
        ((StringBuilder)localObject1).append(paramLong);
        ((StringBuilder)localObject1).append(",isMicOff=");
        ((StringBuilder)localObject1).append(paramBoolean);
        QLog.e("GAudioMemberListCtrl", 2, ((StringBuilder)localObject1).toString());
      }
      return;
    }
    Object localObject1 = (GAudioMemberListCtrl.GAudioMemberInfo)this.f.get(paramInt2);
    ((GAudioMemberListCtrl.GAudioMemberInfo)localObject1).i = paramBoolean;
    ((GAudioMemberListCtrl.GAudioMemberInfo)localObject1).g = paramInt1;
    paramInt1 = this.i.getFirstVisiblePosition();
    int n = this.i.getLastVisiblePosition();
    if (paramInt2 >= paramInt1)
    {
      if (paramInt2 > n) {
        return;
      }
      paramInt1 = paramInt2 + 1 - paramInt1;
      if (paramInt1 > this.i.getChildCount()) {
        return;
      }
      Object localObject2 = this.i.getChildAt(paramInt1);
      if (localObject2 == null)
      {
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("notifyDataSetChanged--> view == null , index = ");
          ((StringBuilder)localObject1).append(paramInt2);
          QLog.e("GAudioMemberListCtrl", 2, ((StringBuilder)localObject1).toString());
        }
        return;
      }
      if (((View)localObject2).getTag() == null)
      {
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("notifyDataSetChanged-->can not get tag from uin-->index=");
          ((StringBuilder)localObject1).append(paramInt2);
          ((StringBuilder)localObject1).append(",uin=");
          ((StringBuilder)localObject1).append(paramLong);
          ((StringBuilder)localObject1).append(",isMicOff=");
          ((StringBuilder)localObject1).append(paramBoolean);
          QLog.e("GAudioMemberListCtrl", 2, ((StringBuilder)localObject1).toString());
        }
        return;
      }
      localObject2 = (GAudioMemberListCtrl.ViewHolder)((View)localObject2).getTag();
      if (localObject2 == null) {
        return;
      }
      if (((GAudioMemberListCtrl.GAudioMemberInfo)localObject1).i)
      {
        ((GAudioMemberListCtrl.ViewHolder)localObject2).f.setVisibility(8);
        if (((GAudioMemberListCtrl.ViewHolder)localObject2).g != null) {
          ((GAudioMemberListCtrl.ViewHolder)localObject2).g.setVisibility(8);
        }
      }
      if (((GAudioMemberListCtrl.GAudioMemberInfo)localObject1).i)
      {
        if ((((GAudioMemberListCtrl.ViewHolder)localObject2).k == -1) || (((GAudioMemberListCtrl.ViewHolder)localObject2).k == 0))
        {
          a(((GAudioMemberListCtrl.ViewHolder)localObject2).e, ((GAudioMemberListCtrl.GAudioMemberInfo)localObject1).i);
          ((GAudioMemberListCtrl.ViewHolder)localObject2).k = 1;
        }
      }
      else if ((((GAudioMemberListCtrl.ViewHolder)localObject2).k == -1) || (((GAudioMemberListCtrl.ViewHolder)localObject2).k == 1))
      {
        a(((GAudioMemberListCtrl.ViewHolder)localObject2).e, ((GAudioMemberListCtrl.GAudioMemberInfo)localObject1).i);
        ((GAudioMemberListCtrl.ViewHolder)localObject2).k = 0;
      }
    }
  }
  
  public void a(long paramLong, boolean paramBoolean)
  {
    int n = a(paramLong);
    if (n == -1)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("notifyDataSetChanged-->this member not in infoList.uin=");
        ((StringBuilder)localObject).append(paramLong);
        ((StringBuilder)localObject).append(",bSpeak=");
        ((StringBuilder)localObject).append(paramBoolean);
        QLog.e("GAudioMemberListCtrl", 2, ((StringBuilder)localObject).toString());
      }
      return;
    }
    Object localObject = (GAudioMemberListCtrl.GAudioMemberInfo)this.f.get(n);
    ((GAudioMemberListCtrl.GAudioMemberInfo)localObject).b = paramBoolean;
    if (((GAudioMemberListCtrl.GAudioMemberInfo)localObject).i)
    {
      ((GAudioMemberListCtrl.GAudioMemberInfo)localObject).b = false;
      paramBoolean = false;
    }
    int i1 = this.i.getFirstVisiblePosition();
    int i2 = this.i.getLastVisiblePosition();
    if ((n >= i1) && (n <= i2))
    {
      i1 = n + 1 - i1;
      if (i1 > this.i.getChildCount()) {
        return;
      }
      localObject = this.i.getChildAt(i1);
      if (localObject == null)
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("notifyDataSetChanged--> view == null , index = ");
          ((StringBuilder)localObject).append(n);
          QLog.e("GAudioMemberListCtrl", 2, ((StringBuilder)localObject).toString());
        }
        return;
      }
      if (((View)localObject).getTag() == null)
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("notifyDataSetChanged-->can not get tag from uin-->index=");
          ((StringBuilder)localObject).append(n);
          ((StringBuilder)localObject).append(",uin=");
          ((StringBuilder)localObject).append(paramLong);
          ((StringBuilder)localObject).append(",isSpeak=");
          ((StringBuilder)localObject).append(paramBoolean);
          QLog.e("GAudioMemberListCtrl", 2, ((StringBuilder)localObject).toString());
        }
        return;
      }
      localObject = (GAudioMemberListCtrl.ViewHolder)((View)localObject).getTag();
      if (localObject == null) {
        return;
      }
      if ((paramBoolean) && (((GAudioMemberListCtrl.ViewHolder)localObject).j))
      {
        ((GAudioMemberListCtrl.ViewHolder)localObject).f.setVisibility(0);
        if (((GAudioMemberListCtrl.ViewHolder)localObject).g != null) {
          ((GAudioMemberListCtrl.ViewHolder)localObject).g.setVisibility(0);
        }
      }
      else
      {
        ((GAudioMemberListCtrl.ViewHolder)localObject).f.setVisibility(8);
        if (((GAudioMemberListCtrl.ViewHolder)localObject).g != null) {
          ((GAudioMemberListCtrl.ViewHolder)localObject).g.setVisibility(8);
        }
      }
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("notifyDataSetChanged--> view is invisible uin =");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append(" , index = ");
      ((StringBuilder)localObject).append(n);
      QLog.e("GAudioMemberListCtrl", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  void a(ImageView paramImageView, boolean paramBoolean)
  {
    int n;
    if (paramBoolean)
    {
      if (this.m) {
        n = 2130842961;
      } else {
        n = 2130842960;
      }
      paramImageView.setImageResource(n);
      paramImageView.setContentDescription(HardCodeUtil.a(2131903138));
      return;
    }
    if (this.m) {
      n = 2130842963;
    } else {
      n = 2130842962;
    }
    paramImageView.setImageResource(n);
    paramImageView.setContentDescription(HardCodeUtil.a(2131903140));
  }
  
  public void a(ArrayList<VideoController.GAudioFriends> paramArrayList)
  {
    if (paramArrayList != null)
    {
      b(paramArrayList);
      this.j.notifyDataSetChanged();
    }
  }
  
  public void b()
  {
    int i1 = this.i.getChildCount();
    int n = 0;
    while (n < i1)
    {
      this.i.getChildAt(n).setTag(null);
      n += 1;
    }
    this.i = null;
    this.j = null;
    this.k = null;
    this.d = null;
    this.e = null;
    Object localObject = this.f;
    if (localObject != null) {
      ((ArrayList)localObject).clear();
    }
    localObject = this.a;
    if (localObject != null) {
      ((WeakReference)localObject).clear();
    }
    this.a = null;
  }
  
  public void b(long paramLong, boolean paramBoolean)
  {
    int n = a(paramLong);
    if (n == -1)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onSetMicBySelf uin=");
        localStringBuilder.append(paramLong);
        localStringBuilder.append(",isMicOffBySelf=");
        localStringBuilder.append(paramBoolean);
        QLog.e("GAudioMemberListCtrl", 2, localStringBuilder.toString());
      }
      return;
    }
    ((GAudioMemberListCtrl.GAudioMemberInfo)this.f.get(n)).j = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.GAudioMemberListCtrl
 * JD-Core Version:    0.7.0.1
 */