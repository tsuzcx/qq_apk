package com.tencent.av.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import com.tencent.av.VideoController;
import com.tencent.av.VideoController.GAudioFriends;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.utils.MultiVideoMembersClickListener;
import com.tencent.av.utils.UITools;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import mqq.app.BaseActivity;

public class MultiMembersAudioUI
  extends LinearLayout
  implements MultiMembersUI
{
  final int[] a = { 2131438037, 2131438038, 2131438039, 2131438040, 2131438041, 2131438042, 2131438043, 2131438044 };
  WeakReference<Context> b = null;
  VideoAppInterface c = null;
  VideoController d = null;
  ViewPager e;
  MultiMembersAudioUI.MemberPagerAdapter f;
  MultiMembersAudioIndicator g;
  long h = 0L;
  int i = 0;
  MultiVideoMembersClickListener j = null;
  ArrayList<MultiMembersUI.MVMembersInfo> k = new ArrayList();
  int l = 0;
  boolean m = false;
  boolean n = false;
  View.OnClickListener o = new MultiMembersAudioUI.1(this);
  
  @TargetApi(9)
  public MultiMembersAudioUI(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    super.setOrientation(1);
    this.b = new WeakReference(paramContext);
    paramContext = (BaseActivity)this.b.get();
    if (paramContext == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("MultiMembersAudioUI", 2, "MVMembersContolUI-->can not get activity");
      }
      return;
    }
    this.c = ((VideoAppInterface)paramContext.getAppRuntime());
    paramAttributeSet = this.c;
    if (paramAttributeSet == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("MultiMembersAudioUI", 2, "MVMembersContolUI-->can not get AppRuntime");
      }
      paramContext.finish();
      return;
    }
    this.d = paramAttributeSet.b();
    if (this.d == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("MultiMembersAudioUI", 2, "MVMembersContolUI-->can not get videoControl");
      }
      paramContext.finish();
      return;
    }
    int i1 = (int)UITools.a(getContext(), 170.0F);
    this.e = new ViewPager(super.getContext());
    paramContext = new LinearLayout.LayoutParams(-1, i1);
    this.e.setLayoutParams(paramContext);
    this.e.setFocusable(false);
    this.e.setFocusableInTouchMode(false);
    this.f = new MultiMembersAudioUI.MemberPagerAdapter(this);
    this.e.setAdapter(this.f);
    super.addView(this.e);
    this.g = new MultiMembersAudioIndicator(super.getContext());
    paramContext = new LinearLayout.LayoutParams(-1, -2);
    this.g.setLayoutParams(paramContext);
    this.g.setViewPager(this.e);
    super.addView(this.g);
  }
  
  private void a(ImageView paramImageView, int paramInt)
  {
    if (paramImageView != null) {
      paramImageView.setVisibility(paramInt);
    }
  }
  
  private void a(RelativeLayout.LayoutParams paramLayoutParams)
  {
    if (this.n)
    {
      paramLayoutParams.addRule(15);
      return;
    }
    if (Build.VERSION.SDK_INT >= 17) {
      paramLayoutParams.removeRule(15);
    }
  }
  
  private boolean b(int paramInt)
  {
    if ((paramInt < 8) && ((this.k.size() != 8) || (paramInt != 7))) {
      return false;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[random room owner] member is null index=");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(",uin=");
      QLog.e("MultiMembersAudioUI", 2, localStringBuilder.toString());
    }
    return true;
  }
  
  int a(int paramInt1, int paramInt2)
  {
    if (paramInt2 > paramInt1 - 1) {
      return -1;
    }
    switch (paramInt1)
    {
    default: 
      return -1;
    case 7: 
    case 8: 
      return this.a[paramInt2];
    case 6: 
      if (paramInt2 < 3) {
        return this.a[paramInt2];
      }
      return this.a[(paramInt2 + 1)];
    case 5: 
      if (paramInt2 < 3) {
        return this.a[paramInt2];
      }
      return this.a[(paramInt2 + 1)];
    case 4: 
      if (paramInt2 < 2) {
        return this.a[paramInt2];
      }
      return this.a[(paramInt2 + 2)];
    case 3: 
      return this.a[paramInt2];
    case 2: 
      return this.a[paramInt2];
    }
    return this.a[0];
  }
  
  int a(long paramLong)
  {
    if (this.k == null) {
      return -1;
    }
    int i1 = 0;
    while (i1 < this.l)
    {
      if (((MultiMembersUI.MVMembersInfo)this.k.get(i1)).a == paramLong) {
        return i1;
      }
      i1 += 1;
    }
    return -1;
  }
  
  View a(int paramInt)
  {
    Object localObject2 = this.k;
    Object localObject1 = null;
    Object localObject3 = null;
    if (localObject2 == null) {
      return null;
    }
    if (b(paramInt)) {
      return null;
    }
    if (paramInt < 0) {
      return null;
    }
    if (paramInt >= this.l) {
      return null;
    }
    if (this.e == null) {
      return null;
    }
    if (this.f == null) {
      return null;
    }
    int i1 = paramInt + 1;
    int i2 = i1 / 8;
    if (i1 % 8 == 0) {
      paramInt = 0;
    } else {
      paramInt = 1;
    }
    i2 = i2 + paramInt - 1;
    if (i2 == this.f.getCount() - 1) {
      paramInt = this.l - i2 * 8;
    } else {
      paramInt = 8;
    }
    try
    {
      localObject2 = this.e;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("MemberPagerAdapter_");
      localStringBuilder.append(i2);
      localObject2 = ((ViewPager)localObject2).findViewWithTag(localStringBuilder.toString());
      if (localObject2 != null)
      {
        localObject1 = ((View)localObject2).findViewById(a(paramInt, i1 - i2 * 8 - 1));
        try
        {
          localObject2 = (MultiMembersUI.Holder)((View)localObject1).getTag();
          if (localObject2 != null)
          {
            boolean bool = ((MultiMembersUI.Holder)localObject2).n;
            if (!bool) {
              break label312;
            }
          }
          return null;
        }
        catch (Exception localException1) {}
      }
      else
      {
        localObject2 = localObject1;
        if (!QLog.isColorLevel()) {
          break label308;
        }
        QLog.e("MultiMembersAudioUI", 2, "[random room owner] page is null");
        localObject2 = localObject1;
      }
    }
    catch (Exception localException2)
    {
      localObject1 = localObject3;
      localObject2 = localObject1;
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("[random room owner] ");
        ((StringBuilder)localObject2).append(localException2.getMessage());
        QLog.e("MultiMembersAudioUI", 2, ((StringBuilder)localObject2).toString());
        localObject2 = localObject1;
      }
    }
    label308:
    localObject1 = localObject2;
    label312:
    return localObject1;
  }
  
  MultiMembersUI.Holder a(View paramView)
  {
    MultiMembersUI.Holder localHolder = new MultiMembersUI.Holder();
    localHolder.g = ((ImageView)paramView.findViewById(2131441083));
    localHolder.h = ((TextView)paramView.findViewById(2131441099));
    if (this.d.k().aQ == 7) {
      localHolder.h.setVisibility(4);
    }
    if (this.n)
    {
      boolean bool = ThemeUtil.isInNightMode(this.c);
      if (bool) {
        localHolder.h.setTextColor(Color.parseColor("#A8A8A8"));
      } else {
        localHolder.h.setTextColor(Color.parseColor("#FFFFFF"));
      }
      if (bool)
      {
        localHolder.d = ((ImageView)paramView.findViewById(2131441102));
        int i1 = AIOUtils.b(15.0F, getResources());
        GradientDrawable localGradientDrawable = new GradientDrawable();
        localGradientDrawable.setShape(1);
        localGradientDrawable.setColor(Color.parseColor("#4C000000"));
        localGradientDrawable.setSize(i1, i1);
        localHolder.d.setBackgroundDrawable(localGradientDrawable);
      }
    }
    localHolder.c = ((ImageView)paramView.findViewById(2131441101));
    localHolder.e = ((ImageView)paramView.findViewById(2131441089));
    localHolder.i = ((TextView)paramView.findViewById(2131441085));
    localHolder.m = ((ImageView)paramView.findViewById(2131441098));
    localHolder.j = ((RelativeLayout)paramView.findViewById(2131441234));
    localHolder.p = ((ImageView)paramView.findViewById(2131441084));
    return localHolder;
  }
  
  public void a()
  {
    if (this.k == null) {
      return;
    }
    int i3 = 0;
    int i1 = 0;
    int i2;
    for (;;)
    {
      i2 = i3;
      if (i1 >= this.l) {
        break;
      }
      if (!((MultiMembersUI.MVMembersInfo)this.k.get(i1)).f)
      {
        i2 = 1;
        break;
      }
      i1 += 1;
    }
    if (i2 != 0) {
      this.f.notifyDataSetChanged();
    }
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("refreshMemMicState. uin = ");
    ((StringBuilder)localObject1).append(paramLong);
    ((StringBuilder)localObject1).append(", accType = ");
    ((StringBuilder)localObject1).append(paramInt1);
    ((StringBuilder)localObject1).append(", pstnStatus = ");
    ((StringBuilder)localObject1).append(paramInt2);
    ((StringBuilder)localObject1).append(", isMicOff = ");
    ((StringBuilder)localObject1).append(paramBoolean);
    QLog.d("MultiMembersAudioUI", 2, ((StringBuilder)localObject1).toString());
    paramInt1 = a(paramLong);
    if (paramInt1 == -1)
    {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("notifyDataSetChanged-->this member not in infoList.uin=");
        ((StringBuilder)localObject1).append(paramLong);
        ((StringBuilder)localObject1).append(",isMicOff=");
        ((StringBuilder)localObject1).append(paramBoolean);
        QLog.e("MultiMembersAudioUI", 2, ((StringBuilder)localObject1).toString());
      }
      return;
    }
    localObject1 = (MultiMembersUI.MVMembersInfo)this.k.get(paramInt1);
    if (((MultiMembersUI.MVMembersInfo)localObject1).m == paramBoolean) {
      return;
    }
    ((MultiMembersUI.MVMembersInfo)localObject1).m = paramBoolean;
    Object localObject2 = a(paramInt1);
    if (localObject2 == null) {
      return;
    }
    if (((View)localObject2).getTag() == null)
    {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("notifyDataSetChanged-->can not get tag from uin-->index=");
        ((StringBuilder)localObject1).append(paramInt1);
        ((StringBuilder)localObject1).append(",uin=");
        ((StringBuilder)localObject1).append(paramLong);
        ((StringBuilder)localObject1).append(",isMicOff=");
        ((StringBuilder)localObject1).append(paramBoolean);
        QLog.e("MultiMembersAudioUI", 2, ((StringBuilder)localObject1).toString());
      }
      return;
    }
    localObject2 = (MultiMembersUI.Holder)((View)localObject2).getTag();
    if (localObject2 == null) {
      return;
    }
    if (paramBoolean)
    {
      if (((MultiMembersUI.Holder)localObject2).c.getVisibility() == 0)
      {
        ((MultiMembersUI.Holder)localObject2).c.setVisibility(8);
        a(((MultiMembersUI.Holder)localObject2).d, 8);
      }
      if (((MultiMembersUI.Holder)localObject2).m.getVisibility() != 0) {
        ((MultiMembersUI.Holder)localObject2).m.setVisibility(0);
      }
    }
    else
    {
      if (((MultiMembersUI.Holder)localObject2).m.getVisibility() == 0) {
        ((MultiMembersUI.Holder)localObject2).m.setVisibility(8);
      }
      if (((MultiMembersUI.MVMembersInfo)localObject1).b)
      {
        ((MultiMembersUI.Holder)localObject2).c.setVisibility(0);
        a(((MultiMembersUI.Holder)localObject2).d, 0);
        return;
      }
      ((MultiMembersUI.Holder)localObject2).c.setVisibility(8);
      a(((MultiMembersUI.Holder)localObject2).d, 8);
    }
  }
  
  public void a(long paramLong, int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("initMVMLayout relationUin: ");
      localStringBuilder.append(paramLong);
      localStringBuilder.append(", relationType: ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(", bEnterPage: ");
      localStringBuilder.append(paramBoolean);
      QLog.d("MultiMembersAudioUI", 2, localStringBuilder.toString());
    }
    this.h = paramLong;
    this.i = paramInt;
  }
  
  public void a(long paramLong, boolean paramBoolean)
  {
    int i1 = a(paramLong);
    if (i1 == -1)
    {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("notifyDataSetChanged-->this member not in infoList.uin=");
        ((StringBuilder)localObject1).append(paramLong);
        ((StringBuilder)localObject1).append(",bSpeak=");
        ((StringBuilder)localObject1).append(paramBoolean);
        QLog.e("MultiMembersAudioUI", 2, ((StringBuilder)localObject1).toString());
      }
      return;
    }
    Object localObject1 = (MultiMembersUI.MVMembersInfo)this.k.get(i1);
    if (((MultiMembersUI.MVMembersInfo)localObject1).b == paramBoolean) {
      return;
    }
    ((MultiMembersUI.MVMembersInfo)localObject1).b = paramBoolean;
    Object localObject2 = a(i1);
    if (localObject2 == null) {
      return;
    }
    if (((View)localObject2).getTag() == null)
    {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("notifyDataSetChanged-->can not get tag from uin-->index=");
        ((StringBuilder)localObject1).append(i1);
        ((StringBuilder)localObject1).append(",uin=");
        ((StringBuilder)localObject1).append(paramLong);
        ((StringBuilder)localObject1).append(",isSpeak=");
        ((StringBuilder)localObject1).append(paramBoolean);
        QLog.e("MultiMembersAudioUI", 2, ((StringBuilder)localObject1).toString());
      }
      return;
    }
    localObject2 = (MultiMembersUI.Holder)((View)localObject2).getTag();
    if (localObject2 == null) {
      return;
    }
    boolean bool;
    if ((this.d.k().aQ != 1) || (this.d.k().o != 10))
    {
      bool = paramBoolean;
      if (this.d.k().aQ != 2) {}
    }
    else if (((MultiMembersUI.MVMembersInfo)localObject1).m)
    {
      if (((MultiMembersUI.Holder)localObject2).m.getVisibility() != 0) {
        ((MultiMembersUI.Holder)localObject2).m.setVisibility(0);
      }
      if (((MultiMembersUI.Holder)localObject2).c.getVisibility() == 0)
      {
        ((MultiMembersUI.Holder)localObject2).c.setVisibility(8);
        a(((MultiMembersUI.Holder)localObject2).d, 8);
      }
      ((MultiMembersUI.MVMembersInfo)localObject1).b = false;
      bool = false;
    }
    else
    {
      bool = paramBoolean;
      if (((MultiMembersUI.Holder)localObject2).m.getVisibility() == 0)
      {
        ((MultiMembersUI.Holder)localObject2).m.setVisibility(8);
        bool = paramBoolean;
      }
    }
    if ((bool) && (((MultiMembersUI.Holder)localObject2).l))
    {
      if (((MultiMembersUI.Holder)localObject2).c.getVisibility() != 0)
      {
        ((MultiMembersUI.Holder)localObject2).c.setVisibility(0);
        a(((MultiMembersUI.Holder)localObject2).d, 0);
      }
    }
    else if (((MultiMembersUI.Holder)localObject2).c.getVisibility() == 0)
    {
      ((MultiMembersUI.Holder)localObject2).c.setVisibility(8);
      a(((MultiMembersUI.Holder)localObject2).d, 8);
    }
    if (this.i == 7)
    {
      ((MultiMembersUI.Holder)localObject2).o = ((MultiMembersUI.MVMembersInfo)localObject1).n;
      i1 = ((MultiMembersUI.Holder)localObject2).o;
      if (i1 != 1)
      {
        if (i1 != 2)
        {
          if (i1 == 4) {
            ((MultiMembersUI.Holder)localObject2).e.setImageResource(2130842897);
          }
        }
        else {
          ((MultiMembersUI.Holder)localObject2).e.setImageResource(2130842895);
        }
      }
      else {
        ((MultiMembersUI.Holder)localObject2).e.setImageResource(2130842899);
      }
      if (((MultiMembersUI.Holder)localObject2).o != 0) {
        ((MultiMembersUI.Holder)localObject2).e.setVisibility(0);
      }
    }
  }
  
  void a(View paramView, int paramInt)
  {
    if (paramView == null) {
      return;
    }
    View localView1 = paramView.findViewById(2131430993);
    View localView2 = paramView.findViewById(2131430994);
    View localView3 = paramView.findViewById(2131438037);
    View localView4 = paramView.findViewById(2131438038);
    View localView5 = paramView.findViewById(2131438039);
    View localView6 = paramView.findViewById(2131438040);
    View localView7 = paramView.findViewById(2131438041);
    View localView8 = paramView.findViewById(2131438042);
    View localView9 = paramView.findViewById(2131438043);
    paramView = paramView.findViewById(2131438044);
    if ((localView1 != null) && (localView2 != null) && (localView3 != null) && (localView4 != null) && (localView5 != null) && (localView6 != null) && (localView7 != null) && (localView8 != null) && (localView9 != null))
    {
      if (paramView == null) {
        return;
      }
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)localView1.getLayoutParams();
      switch (paramInt)
      {
      default: 
        localView1.setVisibility(8);
        localView2.setVisibility(8);
        return;
      case 8: 
        localView1.setVisibility(0);
        localView3.setVisibility(0);
        localView4.setVisibility(0);
        localView5.setVisibility(0);
        localView6.setVisibility(0);
        a(localLayoutParams);
        localLayoutParams.addRule(10);
        localView1.setLayoutParams(localLayoutParams);
        localView2.setVisibility(0);
        localView7.setVisibility(0);
        localView8.setVisibility(0);
        localView9.setVisibility(0);
        paramView.setVisibility(0);
        return;
      case 7: 
        localView1.setVisibility(0);
        localView3.setVisibility(0);
        localView4.setVisibility(0);
        localView5.setVisibility(0);
        localView6.setVisibility(0);
        a(localLayoutParams);
        localLayoutParams.addRule(10);
        localView1.setLayoutParams(localLayoutParams);
        localView2.setVisibility(0);
        localView7.setVisibility(0);
        localView8.setVisibility(0);
        localView9.setVisibility(0);
        paramView.setVisibility(8);
        return;
      case 6: 
        localView1.setVisibility(0);
        localView3.setVisibility(0);
        localView4.setVisibility(0);
        localView5.setVisibility(0);
        localView6.setVisibility(8);
        a(localLayoutParams);
        localLayoutParams.addRule(10);
        localView1.setLayoutParams(localLayoutParams);
        localView2.setVisibility(0);
        localView7.setVisibility(0);
        localView8.setVisibility(0);
        localView9.setVisibility(0);
        paramView.setVisibility(8);
        return;
      case 5: 
        localView1.setVisibility(0);
        localView3.setVisibility(0);
        localView4.setVisibility(0);
        localView5.setVisibility(0);
        localView6.setVisibility(8);
        a(localLayoutParams);
        localLayoutParams.addRule(10);
        localView1.setLayoutParams(localLayoutParams);
        localView2.setVisibility(0);
        localView7.setVisibility(0);
        localView8.setVisibility(0);
        localView9.setVisibility(8);
        paramView.setVisibility(8);
        return;
      case 4: 
        localView1.setVisibility(0);
        localView3.setVisibility(0);
        localView4.setVisibility(0);
        localView5.setVisibility(8);
        localView6.setVisibility(8);
        a(localLayoutParams);
        localLayoutParams.addRule(10);
        localView1.setLayoutParams(localLayoutParams);
        localView2.setVisibility(0);
        localView7.setVisibility(0);
        localView8.setVisibility(0);
        localView9.setVisibility(8);
        paramView.setVisibility(8);
        return;
      case 3: 
        localView1.setVisibility(0);
        localView3.setVisibility(0);
        localView4.setVisibility(0);
        localView5.setVisibility(0);
        localView6.setVisibility(8);
        a(localLayoutParams);
        localLayoutParams.addRule(10, 0);
        localView1.setLayoutParams(localLayoutParams);
        localView2.setVisibility(8);
        return;
      case 2: 
        localView1.setVisibility(0);
        localView3.setVisibility(0);
        localView4.setVisibility(0);
        localView5.setVisibility(8);
        localView6.setVisibility(8);
        a(localLayoutParams);
        localLayoutParams.addRule(10, 0);
        localView1.setLayoutParams(localLayoutParams);
        localView2.setVisibility(8);
        return;
      }
      localView1.setVisibility(0);
      localView3.setVisibility(0);
      localView4.setVisibility(8);
      localView5.setVisibility(8);
      localView6.setVisibility(8);
      a(localLayoutParams);
      localLayoutParams.addRule(10, 0);
      localView1.setLayoutParams(localLayoutParams);
      localView2.setVisibility(8);
    }
  }
  
  public void a(ArrayList<VideoController.GAudioFriends> paramArrayList)
  {
    b(paramArrayList);
    this.g.b();
    this.f.notifyDataSetChanged();
  }
  
  void b(ArrayList<VideoController.GAudioFriends> paramArrayList)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("refreshDataSource, friends[");
      if (paramArrayList != null) {
        i1 = paramArrayList.size();
      } else {
        i1 = -1;
      }
      ((StringBuilder)localObject).append(i1);
      ((StringBuilder)localObject).append("], mInfoList[");
      ((StringBuilder)localObject).append(this.k.size());
      ((StringBuilder)localObject).append("]");
      QLog.w("MultiMembersAudioUI", 1, ((StringBuilder)localObject).toString());
    }
    this.k.clear();
    if (paramArrayList != null)
    {
      i1 = 0;
      while (i1 < paramArrayList.size())
      {
        localObject = (VideoController.GAudioFriends)paramArrayList.get(i1);
        MultiMembersUI.MVMembersInfo localMVMembersInfo = new MultiMembersUI.MVMembersInfo();
        localMVMembersInfo.a = ((VideoController.GAudioFriends)localObject).a;
        localMVMembersInfo.d = ((VideoController.GAudioFriends)localObject).e;
        localMVMembersInfo.c = ((VideoController.GAudioFriends)localObject).d;
        localMVMembersInfo.b = ((VideoController.GAudioFriends)localObject).b;
        localMVMembersInfo.e = ((VideoController.GAudioFriends)localObject).f;
        localMVMembersInfo.j = ((VideoController.GAudioFriends)localObject).n;
        localMVMembersInfo.l = ((VideoController.GAudioFriends)localObject).o;
        localMVMembersInfo.m = ((VideoController.GAudioFriends)localObject).p;
        localMVMembersInfo.n = ((VideoController.GAudioFriends)localObject).v;
        localMVMembersInfo.o = ((VideoController.GAudioFriends)localObject).w;
        this.k.add(localMVMembersInfo);
        i1 += 1;
      }
    }
    this.l = this.k.size();
    int i1 = this.i;
    if (((i1 == 1) || (i1 == 2)) && (this.k.size() > 8)) {
      this.l = 8;
    }
  }
  
  public int getMemberCnt()
  {
    return this.k.size();
  }
  
  public void setIsEnterpage(boolean paramBoolean)
  {
    this.n = paramBoolean;
  }
  
  public void setOnItemClickListener(MultiVideoMembersClickListener paramMultiVideoMembersClickListener)
  {
    this.j = paramMultiVideoMembersClickListener;
  }
  
  public void setRandomMultiIsMask(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setRandomMultiIsMask isMask: ");
      localStringBuilder.append(paramBoolean);
      QLog.d("MultiMembersAudioUI", 2, localStringBuilder.toString());
    }
    this.m = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.MultiMembersAudioUI
 * JD-Core Version:    0.7.0.1
 */