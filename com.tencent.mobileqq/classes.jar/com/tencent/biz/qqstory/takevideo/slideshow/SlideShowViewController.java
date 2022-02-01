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
  private int jdField_a_of_type_Int = 20999;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private LinearLayoutManager jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private View jdField_a_of_type_AndroidViewView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private SlideProgressNotifier jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideProgressNotifier;
  private SlideShowActionListener jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideShowActionListener;
  private SlideShowAdapter jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideShowAdapter;
  private String jdField_a_of_type_JavaLangString = "SlideShowViewController";
  private View jdField_b_of_type_AndroidViewView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private TextView c;
  private TextView d;
  
  public SlideShowViewController(Activity paramActivity, View paramView, SlideShowActionListener paramSlideShowActionListener)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideShowActionListener = paramSlideShowActionListener;
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
  
  private boolean a()
  {
    Activity localActivity = this.jdField_a_of_type_AndroidAppActivity;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localActivity != null)
    {
      bool1 = bool2;
      if (localActivity.getIntent() != null)
      {
        bool1 = bool2;
        if (this.jdField_a_of_type_AndroidAppActivity.getIntent().getIntExtra("edit_video_type", 10002) == 10023) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_AndroidViewView == null) {
      this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidAppActivity.findViewById(2131374597);
    }
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131374594);
    this.jdField_b_of_type_AndroidViewView.setVisibility(0);
    int i;
    if ((this.jdField_a_of_type_AndroidAppActivity instanceof NewPhotoListActivity)) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      this.jdField_a_of_type_AndroidViewView.setBackgroundColor(-526087);
      this.jdField_b_of_type_AndroidViewView.setBackgroundColor(-3026479);
    }
    else
    {
      this.jdField_a_of_type_AndroidViewView.setBackgroundColor(1996488704);
      this.jdField_b_of_type_AndroidViewView.setBackgroundColor(-1728053248);
    }
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)this.jdField_a_of_type_AndroidViewView.findViewById(2131374599));
    this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager = new LinearLayoutManager(this.jdField_a_of_type_AndroidAppActivity, 0, false);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideShowAdapter = new SlideShowAdapter(this.jdField_a_of_type_AndroidViewView.getContext(), this, this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideShowActionListener);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideShowAdapter.a(SlideShowPhotoListManager.a().a());
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideShowAdapter);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getRecycledViewPool().setMaxRecycledViews(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideShowAdapter.getItemViewType(0), 10);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideShowAdapter.a(new SlideShowViewController.1(this));
    new ItemTouchHelper(new SlideShowItemTouchCallback(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideShowAdapter)).attachToRecyclerView(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131374600));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131374601));
    this.c = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131374593));
    this.c.setOnClickListener(this);
    this.d = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131374592));
    this.d.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideProgressNotifier = new SlideProgressNotifier(this.jdField_a_of_type_AndroidAppActivity, 2131561396);
    if (a())
    {
      this.jdField_a_of_type_Int = 60000;
      SlideShowPhotoListManager.a().a(this.jdField_a_of_type_Int);
    }
  }
  
  public void a()
  {
    int i = SlideShowPhotoListManager.a().b();
    boolean bool2 = true;
    boolean bool3 = true;
    boolean bool4 = true;
    boolean bool1 = true;
    if (i == 22) {
      i = 1;
    } else {
      i = 0;
    }
    int j;
    if (SlideShowPhotoListManager.a().a() == 11) {
      j = 1;
    } else {
      j = 0;
    }
    int k;
    if ((this.jdField_a_of_type_AndroidAppActivity instanceof NewPhotoListActivity)) {
      k = 1;
    } else {
      k = 0;
    }
    List localList = SlideShowPhotoListManager.a().a();
    int m;
    if (localList != null) {
      m = localList.size();
    } else {
      m = 0;
    }
    long l = 0L;
    if (m > 0)
    {
      localObject1 = localList.iterator();
      Object localObject2;
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (SlideItemInfo)((Iterator)localObject1).next();
        if (localObject2 != null) {
          l += ((SlideItemInfo)localObject2).a();
        }
      }
      if ((l > this.jdField_a_of_type_Int) && (i == 0))
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidAppActivity.getResources().getColor(2131167234));
        this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidAppActivity.getResources().getColor(2131167234));
        if (this.d.getVisibility() != 0)
        {
          localObject1 = SlideShowPhotoListManager.a().a().iterator();
          int i1 = 0;
          int i2 = 0;
          int n = 0;
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (SlideItemInfo)((Iterator)localObject1).next();
            if (localObject2 != null)
            {
              int i3 = i1 + 1;
              if (((SlideItemInfo)localObject2).jdField_b_of_type_Int == 1)
              {
                i2 += 1;
                i1 = i3;
              }
              else
              {
                i1 = i3;
                if (((SlideItemInfo)localObject2).jdField_b_of_type_Int == 0)
                {
                  n += 1;
                  i1 = i3;
                }
              }
            }
          }
          if (k != 0) {
            localObject1 = "0";
          } else {
            localObject1 = "1";
          }
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(i1);
          ((StringBuilder)localObject2).append("");
          localObject2 = ((StringBuilder)localObject2).toString();
          Object localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append(n);
          ((StringBuilder)localObject3).append("");
          localObject3 = ((StringBuilder)localObject3).toString();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(i2);
          localStringBuilder.append("");
          StoryReportor.a("pic_choose", "exp_autoCut", j ^ 0x1, 0, new String[] { localObject1, localObject2, localObject3, localStringBuilder.toString() });
        }
        this.d.setVisibility(0);
      }
      else
      {
        if (k != 0)
        {
          this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidAppActivity.getResources().getColor(2131166955));
          this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidAppActivity.getResources().getColor(2131167235));
        }
        else
        {
          this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidAppActivity.getResources().getColor(2131167394));
          this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidAppActivity.getResources().getColor(2131167394));
        }
        this.d.setVisibility(8);
      }
      if (i == 0) {
        this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidAppActivity.getString(2131699373, new Object[] { Integer.valueOf(this.jdField_a_of_type_Int / 1000) }));
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setText(SlideShowUtils.a(l));
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setVisibility(0);
    }
    else
    {
      if (k != 0) {
        this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidAppActivity.getResources().getColor(2131166955));
      } else {
        this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidAppActivity.getResources().getColor(2131167394));
      }
      if ((j == 0) && (i == 0)) {
        this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidAppActivity.getString(2131699375));
      } else {
        this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidAppActivity.getString(2131699374));
      }
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      this.d.setVisibility(8);
    }
    if (i != 0)
    {
      localObject1 = this.c;
      if ((m < 2) || (m > 30)) {
        bool1 = false;
      }
      ((TextView)localObject1).setEnabled(bool1);
    }
    else if (j == 0)
    {
      localObject1 = this.c;
      if ((m >= 2) && (m <= 10) && (l <= this.jdField_a_of_type_Int)) {
        bool1 = bool2;
      } else {
        bool1 = false;
      }
      ((TextView)localObject1).setEnabled(bool1);
    }
    else if (k != 0)
    {
      localObject1 = this.c;
      if ((m >= 1) && (m <= 10) && (l <= this.jdField_a_of_type_Int)) {
        bool1 = bool3;
      } else {
        bool1 = false;
      }
      ((TextView)localObject1).setEnabled(bool1);
    }
    else if (m == 0)
    {
      this.c.setEnabled(true);
    }
    else
    {
      localObject1 = this.c;
      if ((m >= 1) && (m <= 10) && (l <= this.jdField_a_of_type_Int)) {
        bool1 = bool4;
      } else {
        bool1 = false;
      }
      ((TextView)localObject1).setEnabled(bool1);
    }
    Object localObject1 = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideShowAdapter;
    if (localObject1 != null) {
      ((SlideShowAdapter)localObject1).a(localList);
    }
  }
  
  public void a(int paramInt)
  {
    SlideShowAdapter localSlideShowAdapter = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideShowAdapter;
    if (localSlideShowAdapter != null) {
      localSlideShowAdapter.a(paramInt);
    }
  }
  
  public void b()
  {
    List localList = SlideShowPhotoListManager.a().a();
    Object localObject = this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager;
    if ((localObject != null) && (this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView != null))
    {
      int i = ((LinearLayoutManager)localObject).findFirstVisibleItemPosition();
      int j = this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager.findLastVisibleItemPosition();
      while (i <= j)
      {
        localObject = this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager.findViewByPosition(i);
        if (localObject != null)
        {
          localObject = this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getChildViewHolder((View)localObject);
          if ((localObject instanceof SlideShowAdapter.SlideShowViewHolder))
          {
            localObject = (SlideShowAdapter.SlideShowViewHolder)localObject;
            SlideItemInfo localSlideItemInfo1 = (SlideItemInfo)((SlideShowAdapter.SlideShowViewHolder)localObject).a.getTag();
            Iterator localIterator = localList.iterator();
            while (localIterator.hasNext())
            {
              SlideItemInfo localSlideItemInfo2 = (SlideItemInfo)localIterator.next();
              if ((localSlideItemInfo1.jdField_b_of_type_JavaLangString.equals(localSlideItemInfo2.jdField_b_of_type_JavaLangString)) && (localSlideItemInfo2.c))
              {
                localSlideItemInfo2.c = false;
                a(((SlideShowAdapter.SlideShowViewHolder)localObject).a);
              }
            }
          }
        }
        i += 1;
      }
    }
  }
  
  public void c()
  {
    Object localObject = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideProgressNotifier;
    if (localObject != null)
    {
      ((SlideProgressNotifier)localObject).a();
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideProgressNotifier.b();
      localObject = SlideShowPhotoListManager.a().a();
      Iterator localIterator = ((List)localObject).iterator();
      int i = 0;
      while (localIterator.hasNext())
      {
        SlideItemInfo localSlideItemInfo = (SlideItemInfo)localIterator.next();
        if (localSlideItemInfo != null) {
          i += (int)localSlideItemInfo.a();
        }
      }
      int j = i;
      if (i == 0) {
        j = 5000;
      }
      double d1 = j;
      Double.isNaN(d1);
      i = (int)(d1 * 1.5D);
      d1 = ((List)localObject).size();
      Double.isNaN(d1);
      double d2 = ((List)localObject).size() + 1;
      Double.isNaN(d2);
      j = (int)(d1 * 1.0D / d2 * 100.0D);
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideProgressNotifier.a(0, i, j, 0);
    }
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideProgressNotifier != null)
    {
      List localList = SlideShowPhotoListManager.a().a();
      int j = localList.size();
      int i = j;
      if (j == 0) {
        i = 1;
      }
      double d1 = localList.size();
      Double.isNaN(d1);
      double d2 = localList.size() + 1;
      Double.isNaN(d2);
      j = (int)(d1 * 1.0D / d2 * 100.0D);
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideProgressNotifier.a(i * 1000, 99, j);
    }
  }
  
  public void e()
  {
    SlideProgressNotifier localSlideProgressNotifier = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideProgressNotifier;
    if (localSlideProgressNotifier != null)
    {
      localSlideProgressNotifier.a();
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideProgressNotifier.b();
    }
  }
  
  public void onClick(View paramView)
  {
    Object localObject1;
    int i;
    Object localObject3;
    int j;
    switch (paramView.getId())
    {
    default: 
      break;
    case 2131377664: 
      localObject1 = (SlideItemInfo)paramView.getTag();
      i = SlideShowPhotoListManager.a().a().indexOf(localObject1);
      localObject3 = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideShowActionListener;
      if ((localObject3 != null) && (localObject1 != null)) {
        ((SlideShowActionListener)localObject3).a(((SlideItemInfo)localObject1).jdField_b_of_type_JavaLangString);
      }
      a(i);
      break;
    case 2131374593: 
      if ((this.jdField_a_of_type_AndroidAppActivity instanceof NewPhotoListActivity)) {
        i = 0;
      } else {
        i = 1;
      }
      if (SlideShowPhotoListManager.a().a() == 11) {
        j = 1;
      } else {
        j = 0;
      }
      localObject1 = SlideShowPhotoListManager.a().a();
      if ((j != 0) && (i != 0) && (((List)localObject1).size() == 0))
      {
        localObject1 = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideShowActionListener;
        if (localObject1 != null) {
          ((SlideShowActionListener)localObject1).d();
        }
        localObject1 = SlideShowPhotoListManager.a().a();
        if ((((List)localObject1).size() >= 1) && (((List)localObject1).size() <= 10) && (((SlideItemInfo)((List)localObject1).get(0)).a() <= 20999L)) {
          SlideShowPhotoListManager.a().a(this.jdField_a_of_type_AndroidAppActivity, null, 2);
        }
      }
      else
      {
        SlideShowPhotoListManager.a().a(this.jdField_a_of_type_AndroidAppActivity, null, 2);
        localObject1 = this.jdField_a_of_type_AndroidAppActivity;
        if ((localObject1 != null) && (((Activity)localObject1).getIntent().getBooleanExtra("from_qzone_slideshow", false)))
        {
          localObject1 = this.jdField_a_of_type_AndroidAppActivity;
          if ((localObject1 instanceof NewPhotoListActivity)) {
            SlideShowPhotoListManager.a().b(14);
          } else if ((localObject1 instanceof NewPhotoPreviewActivity)) {
            SlideShowPhotoListManager.a().b(19);
          }
        }
      }
      try
      {
        if (SlideShowPhotoListManager.a().a() != 13) {
          break;
        }
        if (this.jdField_a_of_type_AndroidAppActivity != null) {
          StoryReportor.a("pic_fictitious", "clk_next", this.jdField_a_of_type_AndroidAppActivity.getIntent(), new String[0]);
        }
        if ((!SlideShowPhotoListManager.a().a()) || (this.jdField_a_of_type_AndroidAppActivity == null)) {
          break;
        }
        StoryReportor.a("video_edit_new", "change_pic", this.jdField_a_of_type_AndroidAppActivity.getIntent(), new String[0]);
      }
      catch (Exception localException)
      {
        if (!QLog.isColorLevel()) {
          break;
        }
      }
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, ThrowablesUtils.a(localException));
      break;
    case 2131374592: 
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "qqstory_slideshow_auto_optimize");
      }
      Object localObject2 = SlideShowPhotoListManager.a().a().iterator();
      j = 0;
      int k = 0;
      i = 0;
      int m;
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (SlideItemInfo)((Iterator)localObject2).next();
        m = j + 1;
        if (((SlideItemInfo)localObject3).jdField_b_of_type_Int == 1)
        {
          k += 1;
          j = m;
        }
        else
        {
          j = m;
          if (((SlideItemInfo)localObject3).jdField_b_of_type_Int == 0)
          {
            i += 1;
            j = m;
          }
        }
      }
      boolean bool = this.jdField_a_of_type_AndroidAppActivity instanceof NewPhotoListActivity;
      if (SlideShowPhotoListManager.a().a() == 11) {
        m = 1;
      } else {
        m = 0;
      }
      if (bool) {
        localObject2 = "0";
      } else {
        localObject2 = "1";
      }
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(j);
      ((StringBuilder)localObject3).append("");
      localObject3 = ((StringBuilder)localObject3).toString();
      Object localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append(i);
      ((StringBuilder)localObject4).append("");
      localObject4 = ((StringBuilder)localObject4).toString();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(k);
      localStringBuilder.append("");
      StoryReportor.a("pic_choose", "clk_autoCut", m ^ 0x1, 0, new String[] { localObject2, localObject3, localObject4, localStringBuilder.toString() });
      SlideShowPhotoListManager.a().f();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.slideshow.SlideShowViewController
 * JD-Core Version:    0.7.0.1
 */