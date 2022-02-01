package com.tencent.biz.qqstory.takevideo.slideshow;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.RecycledViewPool;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.aelight.camera.util.EaseCubicInterpolator;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.activity.photo.album.NewPhotoPreviewActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.ThrowablesUtils;
import com.tencent.widget.itemtouchhelper.ItemTouchHelper;
import java.util.Iterator;
import java.util.List;

public class SlideShowViewController
  implements View.OnClickListener
{
  private String a = "SlideShowViewController";
  private Activity b;
  private SlideShowActionListener c;
  private View d;
  private RecyclerView e;
  private SlideShowAdapter f;
  private View g;
  private TextView h;
  private TextView i;
  private TextView j;
  private TextView k;
  private SlideProgressNotifier l;
  private LinearLayoutManager m;
  private int n = 20999;
  
  public SlideShowViewController(Activity paramActivity, View paramView, SlideShowActionListener paramSlideShowActionListener)
  {
    this.d = paramView;
    this.b = paramActivity;
    this.c = paramSlideShowActionListener;
    f();
    a();
  }
  
  private void a(View paramView)
  {
    AnimatorSet localAnimatorSet = new AnimatorSet();
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(paramView, "alpha", new float[] { 1.0F, 0.5F });
    localObjectAnimator1.setDuration(240L);
    localObjectAnimator1.setInterpolator(new EaseCubicInterpolator(0.33F, 0.0F, 0.67F, 1.0F));
    localObjectAnimator1.setStartDelay(0L);
    ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(paramView, "alpha", new float[] { 0.5F, 1.0F });
    localObjectAnimator2.setDuration(260L);
    localObjectAnimator2.setInterpolator(new EaseCubicInterpolator(0.33F, 0.0F, 0.67F, 1.0F));
    localObjectAnimator2.setStartDelay(237L);
    ObjectAnimator localObjectAnimator3 = ObjectAnimator.ofFloat(paramView, "alpha", new float[] { 1.0F, 0.5F });
    localObjectAnimator3.setDuration(270L);
    localObjectAnimator3.setInterpolator(new EaseCubicInterpolator(0.33F, 0.0F, 0.67F, 1.0F));
    localObjectAnimator3.setStartDelay(495L);
    paramView = ObjectAnimator.ofFloat(paramView, "alpha", new float[] { 0.5F, 1.0F });
    paramView.setDuration(240L);
    paramView.setInterpolator(new EaseCubicInterpolator(0.33F, 0.0F, 0.67F, 1.0F));
    paramView.setStartDelay(763L);
    localAnimatorSet.playTogether(new Animator[] { localObjectAnimator1, localObjectAnimator2, localObjectAnimator3, paramView });
    localAnimatorSet.start();
  }
  
  private void f()
  {
    if (this.d == null) {
      this.d = this.b.findViewById(2131442767);
    }
    this.d.setVisibility(0);
    this.g = this.d.findViewById(2131442764);
    this.g.setVisibility(0);
    int i1;
    if ((this.b instanceof NewPhotoListActivity)) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    if (i1 != 0)
    {
      this.d.setBackgroundColor(-526087);
      this.g.setBackgroundColor(-3026479);
    }
    else
    {
      this.d.setBackgroundColor(1996488704);
      this.g.setBackgroundColor(-1728053248);
    }
    this.e = ((RecyclerView)this.d.findViewById(2131442769));
    this.m = new LinearLayoutManager(this.b, 0, false);
    this.e.setLayoutManager(this.m);
    this.f = new SlideShowAdapter(this.d.getContext(), this, this.c);
    this.f.a(SlideShowPhotoListManager.a().f());
    this.e.setAdapter(this.f);
    this.e.getRecycledViewPool().setMaxRecycledViews(this.f.getItemViewType(0), 10);
    this.f.a(new SlideShowViewController.1(this));
    new ItemTouchHelper(new SlideShowItemTouchCallback(this.f)).attachToRecyclerView(this.e);
    this.i = ((TextView)this.d.findViewById(2131442770));
    this.h = ((TextView)this.d.findViewById(2131442771));
    this.j = ((TextView)this.d.findViewById(2131442763));
    this.j.setOnClickListener(this);
    this.k = ((TextView)this.d.findViewById(2131442762));
    this.k.setOnClickListener(this);
    this.l = new SlideProgressNotifier(this.b, 2131627752);
    if (g())
    {
      this.n = 60000;
      SlideShowPhotoListManager.a().a(this.n);
    }
  }
  
  private boolean g()
  {
    Activity localActivity = this.b;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localActivity != null)
    {
      bool1 = bool2;
      if (localActivity.getIntent() != null)
      {
        bool1 = bool2;
        if (this.b.getIntent().getIntExtra("edit_video_type", 10002) == 10023) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public void a()
  {
    int i1 = SlideShowPhotoListManager.a().e();
    boolean bool2 = true;
    boolean bool3 = true;
    boolean bool4 = true;
    boolean bool1 = true;
    if (i1 == 22) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    int i2;
    if (SlideShowPhotoListManager.a().d() == 11) {
      i2 = 1;
    } else {
      i2 = 0;
    }
    int i3;
    if ((this.b instanceof NewPhotoListActivity)) {
      i3 = 1;
    } else {
      i3 = 0;
    }
    List localList = SlideShowPhotoListManager.a().f();
    int i4;
    if (localList != null) {
      i4 = localList.size();
    } else {
      i4 = 0;
    }
    long l1 = 0L;
    if (i4 > 0)
    {
      localObject1 = localList.iterator();
      Object localObject2;
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (SlideItemInfo)((Iterator)localObject1).next();
        if (localObject2 != null) {
          l1 += ((SlideItemInfo)localObject2).a();
        }
      }
      if ((l1 > this.n) && (i1 == 0))
      {
        this.i.setTextColor(this.b.getResources().getColor(2131168224));
        this.h.setTextColor(this.b.getResources().getColor(2131168224));
        if (this.k.getVisibility() != 0)
        {
          localObject1 = SlideShowPhotoListManager.a().f().iterator();
          int i6 = 0;
          int i7 = 0;
          int i5 = 0;
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (SlideItemInfo)((Iterator)localObject1).next();
            if (localObject2 != null)
            {
              int i8 = i6 + 1;
              if (((SlideItemInfo)localObject2).e == 1)
              {
                i7 += 1;
                i6 = i8;
              }
              else
              {
                i6 = i8;
                if (((SlideItemInfo)localObject2).e == 0)
                {
                  i5 += 1;
                  i6 = i8;
                }
              }
            }
          }
          if (i3 != 0) {
            localObject1 = "0";
          } else {
            localObject1 = "1";
          }
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(i6);
          ((StringBuilder)localObject2).append("");
          localObject2 = ((StringBuilder)localObject2).toString();
          Object localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append(i5);
          ((StringBuilder)localObject3).append("");
          localObject3 = ((StringBuilder)localObject3).toString();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(i7);
          localStringBuilder.append("");
          StoryReportor.a("pic_choose", "exp_autoCut", i2 ^ 0x1, 0, new String[] { localObject1, localObject2, localObject3, localStringBuilder.toString() });
        }
        this.k.setVisibility(0);
      }
      else
      {
        if (i3 != 0)
        {
          this.i.setTextColor(this.b.getResources().getColor(2131167888));
          this.h.setTextColor(this.b.getResources().getColor(2131168225));
        }
        else
        {
          this.i.setTextColor(this.b.getResources().getColor(2131168464));
          this.h.setTextColor(this.b.getResources().getColor(2131168464));
        }
        this.k.setVisibility(8);
      }
      if (i1 == 0) {
        this.i.setText(this.b.getString(2131897390, new Object[] { Integer.valueOf(this.n / 1000) }));
      }
      this.h.setText(SlideShowUtils.a(l1));
      this.h.setVisibility(0);
      this.e.setVisibility(0);
    }
    else
    {
      if (i3 != 0) {
        this.i.setTextColor(this.b.getResources().getColor(2131167888));
      } else {
        this.i.setTextColor(this.b.getResources().getColor(2131168464));
      }
      if ((i2 == 0) && (i1 == 0)) {
        this.i.setText(this.b.getString(2131897392));
      } else {
        this.i.setText(this.b.getString(2131897391));
      }
      this.e.setVisibility(8);
      this.h.setVisibility(8);
      this.k.setVisibility(8);
    }
    if (i1 != 0)
    {
      localObject1 = this.j;
      if ((i4 < 2) || (i4 > 30)) {
        bool1 = false;
      }
      ((TextView)localObject1).setEnabled(bool1);
    }
    else if (i2 == 0)
    {
      localObject1 = this.j;
      if ((i4 >= 2) && (i4 <= 10) && (l1 <= this.n)) {
        bool1 = bool2;
      } else {
        bool1 = false;
      }
      ((TextView)localObject1).setEnabled(bool1);
    }
    else if (i3 != 0)
    {
      localObject1 = this.j;
      if ((i4 >= 1) && (i4 <= 10) && (l1 <= this.n)) {
        bool1 = bool3;
      } else {
        bool1 = false;
      }
      ((TextView)localObject1).setEnabled(bool1);
    }
    else if (i4 == 0)
    {
      this.j.setEnabled(true);
    }
    else
    {
      localObject1 = this.j;
      if ((i4 >= 1) && (i4 <= 10) && (l1 <= this.n)) {
        bool1 = bool4;
      } else {
        bool1 = false;
      }
      ((TextView)localObject1).setEnabled(bool1);
    }
    Object localObject1 = this.f;
    if (localObject1 != null) {
      ((SlideShowAdapter)localObject1).a(localList);
    }
  }
  
  public void a(int paramInt)
  {
    SlideShowAdapter localSlideShowAdapter = this.f;
    if (localSlideShowAdapter != null) {
      localSlideShowAdapter.a(paramInt);
    }
  }
  
  public void b()
  {
    List localList = SlideShowPhotoListManager.a().f();
    Object localObject = this.m;
    if ((localObject != null) && (this.e != null))
    {
      int i1 = ((LinearLayoutManager)localObject).findFirstVisibleItemPosition();
      int i2 = this.m.findLastVisibleItemPosition();
      while (i1 <= i2)
      {
        localObject = this.m.findViewByPosition(i1);
        if (localObject != null)
        {
          localObject = this.e.getChildViewHolder((View)localObject);
          if ((localObject instanceof SlideShowAdapter.SlideShowViewHolder))
          {
            localObject = (SlideShowAdapter.SlideShowViewHolder)localObject;
            SlideItemInfo localSlideItemInfo1 = (SlideItemInfo)((SlideShowAdapter.SlideShowViewHolder)localObject).a.getTag();
            Iterator localIterator = localList.iterator();
            while (localIterator.hasNext())
            {
              SlideItemInfo localSlideItemInfo2 = (SlideItemInfo)localIterator.next();
              if ((localSlideItemInfo1.f.equals(localSlideItemInfo2.f)) && (localSlideItemInfo2.t))
              {
                localSlideItemInfo2.t = false;
                a(((SlideShowAdapter.SlideShowViewHolder)localObject).a);
              }
            }
          }
        }
        i1 += 1;
      }
    }
  }
  
  public void c()
  {
    Object localObject = this.l;
    if (localObject != null)
    {
      ((SlideProgressNotifier)localObject).a();
      this.l.b();
      localObject = SlideShowPhotoListManager.a().f();
      Iterator localIterator = ((List)localObject).iterator();
      int i1 = 0;
      while (localIterator.hasNext())
      {
        SlideItemInfo localSlideItemInfo = (SlideItemInfo)localIterator.next();
        if (localSlideItemInfo != null) {
          i1 += (int)localSlideItemInfo.a();
        }
      }
      int i2 = i1;
      if (i1 == 0) {
        i2 = 5000;
      }
      double d1 = i2;
      Double.isNaN(d1);
      i1 = (int)(d1 * 1.5D);
      d1 = ((List)localObject).size();
      Double.isNaN(d1);
      double d2 = ((List)localObject).size() + 1;
      Double.isNaN(d2);
      i2 = (int)(d1 * 1.0D / d2 * 100.0D);
      this.l.a(0, i1, i2, 0);
    }
  }
  
  public void d()
  {
    if (this.l != null)
    {
      List localList = SlideShowPhotoListManager.a().f();
      int i2 = localList.size();
      int i1 = i2;
      if (i2 == 0) {
        i1 = 1;
      }
      double d1 = localList.size();
      Double.isNaN(d1);
      double d2 = localList.size() + 1;
      Double.isNaN(d2);
      i2 = (int)(d1 * 1.0D / d2 * 100.0D);
      this.l.a(i1 * 1000, 99, i2);
    }
  }
  
  public void e()
  {
    SlideProgressNotifier localSlideProgressNotifier = this.l;
    if (localSlideProgressNotifier != null)
    {
      localSlideProgressNotifier.a();
      this.l.b();
    }
  }
  
  public void onClick(View paramView)
  {
    Object localObject1;
    int i1;
    Object localObject3;
    int i2;
    switch (paramView.getId())
    {
    default: 
      break;
    case 2131446088: 
      localObject1 = (SlideItemInfo)paramView.getTag();
      i1 = SlideShowPhotoListManager.a().f().indexOf(localObject1);
      localObject3 = this.c;
      if ((localObject3 != null) && (localObject1 != null)) {
        ((SlideShowActionListener)localObject3).a(((SlideItemInfo)localObject1).f);
      }
      a(i1);
      break;
    case 2131442763: 
      if ((this.b instanceof NewPhotoListActivity)) {
        i1 = 0;
      } else {
        i1 = 1;
      }
      if (SlideShowPhotoListManager.a().d() == 11) {
        i2 = 1;
      } else {
        i2 = 0;
      }
      localObject1 = SlideShowPhotoListManager.a().f();
      if ((i2 != 0) && (i1 != 0) && (((List)localObject1).size() == 0))
      {
        localObject1 = this.c;
        if (localObject1 != null) {
          ((SlideShowActionListener)localObject1).d();
        }
        localObject1 = SlideShowPhotoListManager.a().f();
        if ((((List)localObject1).size() >= 1) && (((List)localObject1).size() <= 10) && (((SlideItemInfo)((List)localObject1).get(0)).a() <= 20999L)) {
          SlideShowPhotoListManager.a().a(this.b, null, 2);
        }
      }
      else
      {
        SlideShowPhotoListManager.a().a(this.b, null, 2);
        localObject1 = this.b;
        if ((localObject1 != null) && (((Activity)localObject1).getIntent().getBooleanExtra("from_qzone_slideshow", false)))
        {
          localObject1 = this.b;
          if ((localObject1 instanceof NewPhotoListActivity)) {
            SlideShowPhotoListManager.a().b(14);
          } else if ((localObject1 instanceof NewPhotoPreviewActivity)) {
            SlideShowPhotoListManager.a().b(19);
          }
        }
      }
      try
      {
        if (SlideShowPhotoListManager.a().d() != 13) {
          break;
        }
        if (this.b != null) {
          StoryReportor.a("pic_fictitious", "clk_next", this.b.getIntent(), new String[0]);
        }
        if ((!SlideShowPhotoListManager.a().b()) || (this.b == null)) {
          break;
        }
        StoryReportor.a("video_edit_new", "change_pic", this.b.getIntent(), new String[0]);
      }
      catch (Exception localException)
      {
        if (!QLog.isColorLevel()) {
          break;
        }
      }
      QLog.d(this.a, 2, ThrowablesUtils.a(localException));
      break;
    case 2131442762: 
      if (QLog.isColorLevel()) {
        QLog.d(this.a, 2, "qqstory_slideshow_auto_optimize");
      }
      Object localObject2 = SlideShowPhotoListManager.a().f().iterator();
      i2 = 0;
      int i3 = 0;
      i1 = 0;
      int i4;
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (SlideItemInfo)((Iterator)localObject2).next();
        i4 = i2 + 1;
        if (((SlideItemInfo)localObject3).e == 1)
        {
          i3 += 1;
          i2 = i4;
        }
        else
        {
          i2 = i4;
          if (((SlideItemInfo)localObject3).e == 0)
          {
            i1 += 1;
            i2 = i4;
          }
        }
      }
      boolean bool = this.b instanceof NewPhotoListActivity;
      if (SlideShowPhotoListManager.a().d() == 11) {
        i4 = 1;
      } else {
        i4 = 0;
      }
      if (bool) {
        localObject2 = "0";
      } else {
        localObject2 = "1";
      }
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(i2);
      ((StringBuilder)localObject3).append("");
      localObject3 = ((StringBuilder)localObject3).toString();
      Object localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append(i1);
      ((StringBuilder)localObject4).append("");
      localObject4 = ((StringBuilder)localObject4).toString();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(i3);
      localStringBuilder.append("");
      StoryReportor.a("pic_choose", "clk_autoCut", i4 ^ 0x1, 0, new String[] { localObject2, localObject3, localObject4, localStringBuilder.toString() });
      SlideShowPhotoListManager.a().m();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.slideshow.SlideShowViewController
 * JD-Core Version:    0.7.0.1
 */