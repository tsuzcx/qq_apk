package com.tencent.av.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.av.VideoController;
import com.tencent.av.VideoController.GAudioFriends;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.utils.MultiVideoMembersClickListener;
import com.tencent.av.utils.UITools;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import mqq.app.BaseActivity;

public class MultiMembersVideoUI
  extends RelativeLayout
  implements MultiMembersUI
{
  WeakReference<Context> a = null;
  long b = 0L;
  int c = 0;
  boolean d = false;
  GridView e = null;
  MultiMembersVideoUI.MVAdapter f = null;
  HorizontalScrollView g = null;
  View h = null;
  VideoAppInterface i = null;
  VideoController j = null;
  LayoutInflater k = null;
  ArrayList<MultiMembersUI.MVMembersInfo> l = new ArrayList();
  MultiVideoMembersClickListener m = null;
  int n = 0;
  boolean o = false;
  AdapterView.OnItemClickListener p = new MultiMembersVideoUI.1(this);
  View.OnTouchListener q = new MultiMembersVideoUI.2(this);
  
  public MultiMembersVideoUI(Context paramContext)
  {
    super(paramContext);
  }
  
  @TargetApi(9)
  public MultiMembersVideoUI(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.a = new WeakReference(paramContext);
    paramContext = (BaseActivity)this.a.get();
    if (paramContext == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("MultiMembersVideoUI", 2, "MVMembersContolUI-->can not get activity");
      }
      return;
    }
    this.i = ((VideoAppInterface)paramContext.getAppRuntime());
    paramAttributeSet = this.i;
    if (paramAttributeSet == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("MultiMembersVideoUI", 2, "MVMembersContolUI-->can not get AppRuntime");
      }
      paramContext.finish();
      return;
    }
    this.j = paramAttributeSet.b();
    if (this.j == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("MultiMembersVideoUI", 2, "MVMembersContolUI-->can not get videoControl");
      }
      paramContext.finish();
      return;
    }
    this.k = LayoutInflater.from((Context)this.a.get());
    this.h = this.k.inflate(2131625774, null);
    this.h.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
    this.e = ((GridView)this.h.findViewById(2131439090));
    this.g = ((HorizontalScrollView)this.h.findViewById(2131439088));
    this.e.setNumColumns(-1);
    this.e.setGravity(17);
    this.e.setSelector(new ColorDrawable(0));
    if (Build.VERSION.SDK_INT >= 9)
    {
      this.g.setOverScrollMode(2);
      this.e.setOverScrollMode(2);
    }
    this.f = new MultiMembersVideoUI.MVAdapter(this);
    this.e.setAdapter(this.f);
    this.e.setOnItemClickListener(this.p);
    this.e.setOnTouchListener(this.q);
    super.addView(this.h);
  }
  
  void a()
  {
    int i1 = this.l.size();
    int i2 = this.c;
    if (((i2 == 1) || (i2 == 2)) && (i1 > 8)) {
      i1 = this.n * 8;
    } else {
      i1 *= this.n;
    }
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.e.getLayoutParams();
    localLayoutParams.width = i1;
    this.e.setLayoutParams(localLayoutParams);
    this.f.notifyDataSetChanged();
  }
  
  public void a(long paramLong, int paramInt, boolean paramBoolean)
  {
    this.b = paramLong;
    this.c = paramInt;
    this.d = paramBoolean;
  }
  
  public void a(ArrayList<VideoController.GAudioFriends> paramArrayList)
  {
    if (paramArrayList != null)
    {
      b(paramArrayList);
      b();
      a();
    }
  }
  
  void b()
  {
    Object localObject = (BaseActivity)this.a.get();
    if (localObject == null) {
      return;
    }
    int i1 = this.l.size();
    int i2 = UITools.a(((BaseActivity)localObject).getApplicationContext());
    this.n = ((BaseActivity)localObject).getResources().getDimensionPixelSize(2131298504);
    this.e.setColumnWidth(this.n);
    double d1;
    if (this.d)
    {
      if (i1 <= 4)
      {
        i1 = (i2 - this.n * i1) / 2;
        break label199;
      }
      d1 = i2;
      Double.isNaN(d1);
      this.n = ((int)(d1 / 4.5D));
      this.e.setColumnWidth(this.n);
    }
    else
    {
      if (i1 <= 6)
      {
        i1 = ((BaseActivity)localObject).getResources().getDimensionPixelSize(2131298506);
        this.n = ((i2 - i1 * 2) / 6);
        this.e.setColumnWidth(this.n);
        break label199;
      }
      d1 = i2;
      Double.isNaN(d1);
      this.n = ((int)(d1 / 6.5D));
      this.e.setColumnWidth(this.n);
    }
    i1 = 0;
    label199:
    i2 = i1;
    if (i1 < 0) {
      i2 = 0;
    }
    localObject = (RelativeLayout.LayoutParams)this.g.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).leftMargin = i2;
    this.g.setLayoutParams((ViewGroup.LayoutParams)localObject);
  }
  
  void b(ArrayList<VideoController.GAudioFriends> paramArrayList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiMembersVideoUI", 2, "refreshDataSource");
    }
    if (paramArrayList == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MultiMembersVideoUI", 2, "refreshDataSource-->friends list is null");
      }
      return;
    }
    this.l.clear();
    int i1 = 0;
    while (i1 < paramArrayList.size())
    {
      VideoController.GAudioFriends localGAudioFriends = (VideoController.GAudioFriends)paramArrayList.get(i1);
      MultiMembersUI.MVMembersInfo localMVMembersInfo = new MultiMembersUI.MVMembersInfo();
      localMVMembersInfo.a = localGAudioFriends.a;
      localMVMembersInfo.d = localGAudioFriends.e;
      localMVMembersInfo.c = localGAudioFriends.d;
      localMVMembersInfo.b = localGAudioFriends.b;
      localMVMembersInfo.e = localGAudioFriends.f;
      localMVMembersInfo.j = localGAudioFriends.n;
      localMVMembersInfo.l = localGAudioFriends.o;
      localMVMembersInfo.m = localGAudioFriends.p;
      localMVMembersInfo.o = localGAudioFriends.w;
      this.l.add(localMVMembersInfo);
      i1 += 1;
    }
  }
  
  public void c()
  {
    int i2 = getLeftItemIndex();
    boolean bool2 = false;
    int i1 = i2;
    if (i2 < 0) {
      i1 = 0;
    }
    int i3 = Math.min(i1 + 4, this.l.size());
    i2 = i1;
    boolean bool1;
    for (;;)
    {
      bool1 = bool2;
      if (i2 >= i3) {
        break;
      }
      if (!((MultiMembersUI.MVMembersInfo)this.l.get(i2)).f)
      {
        bool1 = true;
        break;
      }
      i2 += 1;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("refreshHeadbitmap-->minIndex=");
      localStringBuilder.append(i1);
      localStringBuilder.append(",maxIndex=");
      localStringBuilder.append(i3);
      localStringBuilder.append(",needRefresh=");
      localStringBuilder.append(bool1);
      QLog.d("MultiMembersVideoUI", 2, localStringBuilder.toString());
    }
    if (bool1) {
      this.f.notifyDataSetChanged();
    }
  }
  
  int getLeftItemIndex()
  {
    long l1 = this.g.getScrollX();
    int i1 = this.n;
    if (i1 > 0) {
      return (int)l1 / i1;
    }
    return 0;
  }
  
  public void setOnItemClickListener(MultiVideoMembersClickListener paramMultiVideoMembersClickListener)
  {
    this.m = paramMultiVideoMembersClickListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.MultiMembersVideoUI
 * JD-Core Version:    0.7.0.1
 */