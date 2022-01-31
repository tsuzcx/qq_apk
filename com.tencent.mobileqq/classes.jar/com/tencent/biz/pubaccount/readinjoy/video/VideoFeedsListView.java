package com.tencent.biz.pubaccount.readinjoy.video;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.OrientationEventListener;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ListAdapter;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mfsdk.collector.DropFrameMonitor;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import mco;
import mcp;
import mcq;
import mcr;
import mcs;
import mct;
import mcu;
import mcv;

public class VideoFeedsListView
  extends ListView
  implements AbsListView.OnScrollListener
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Context jdField_a_of_type_AndroidContentContext;
  private OrientationEventListener jdField_a_of_type_AndroidViewOrientationEventListener;
  private VelocityTracker jdField_a_of_type_AndroidViewVelocityTracker;
  private View jdField_a_of_type_AndroidViewView;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private AbsListView.OnScrollListener jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener;
  private ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private HashMap jdField_a_of_type_JavaUtilHashMap;
  private mcv jdField_a_of_type_Mcv;
  private boolean jdField_a_of_type_Boolean = true;
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int;
  private ViewGroup jdField_b_of_type_AndroidViewViewGroup;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private ViewGroup jdField_c_of_type_AndroidViewViewGroup;
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int = 0;
  private boolean jdField_d_of_type_Boolean = true;
  private int jdField_e_of_type_Int = -1;
  private boolean jdField_e_of_type_Boolean;
  private int jdField_f_of_type_Int;
  private boolean jdField_f_of_type_Boolean;
  private int jdField_g_of_type_Int;
  private boolean jdField_g_of_type_Boolean;
  private int jdField_h_of_type_Int;
  private boolean jdField_h_of_type_Boolean;
  private int jdField_i_of_type_Int;
  private boolean jdField_i_of_type_Boolean;
  private int jdField_j_of_type_Int = -1;
  private boolean jdField_j_of_type_Boolean;
  private int jdField_k_of_type_Int;
  private boolean jdField_k_of_type_Boolean;
  private boolean l;
  private boolean m;
  private boolean n;
  private boolean o;
  private boolean p = true;
  private boolean q = true;
  
  public VideoFeedsListView(Context paramContext, Activity paramActivity)
  {
    super(paramContext);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    paramContext = VideoFeedsHelper.a(this.jdField_a_of_type_AndroidAppActivity);
    this.jdField_b_of_type_Int = paramContext[0];
    this.jdField_a_of_type_Int = paramContext[1];
    setOverScrollMode(2);
    g();
    this.jdField_a_of_type_AndroidViewVelocityTracker = VelocityTracker.obtain();
    this.jdField_a_of_type_Mcv = new mcv(this, new Handler());
    this.jdField_a_of_type_Mcv.a();
    this.q = VideoFeedsHelper.a(this.jdField_a_of_type_AndroidContentContext);
    super.setOnScrollListener(this);
  }
  
  private int a(int paramInt)
  {
    return (int)(this.jdField_a_of_type_Int / 2.0F - paramInt / 2.0F - AIOUtils.a(2.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
  }
  
  private void a(float paramFloat)
  {
    if (this.o) {}
    label7:
    VideoFeedsAlphaMaskView localVideoFeedsAlphaMaskView;
    do
    {
      do
      {
        do
        {
          do
          {
            break label7;
            break label7;
            do
            {
              return;
            } while (this.jdField_c_of_type_AndroidViewViewGroup == null);
            if (((this.jdField_c_of_type_AndroidViewViewGroup.getTag() instanceof VideoFeedsAdapter.BaseItemHolder)) && (((VideoFeedsAdapter.BaseItemHolder)this.jdField_c_of_type_AndroidViewViewGroup.getTag()).jdField_b_of_type_Int == this.jdField_j_of_type_Int))
            {
              localVideoFeedsAlphaMaskView = ((VideoFeedsAdapter.BaseItemHolder)this.jdField_c_of_type_AndroidViewViewGroup.getTag()).a;
              if (localVideoFeedsAlphaMaskView != null) {
                localVideoFeedsAlphaMaskView.setAlpha(paramFloat);
              }
            }
            if ((this.jdField_a_of_type_AndroidViewViewGroup == null) || (!(this.jdField_a_of_type_AndroidViewViewGroup.getTag() instanceof VideoFeedsAdapter.BaseItemHolder)) || (this.jdField_c_of_type_AndroidViewViewGroup.getTop() <= this.jdField_g_of_type_Int)) {
              break;
            }
          } while (((VideoFeedsAdapter.BaseItemHolder)this.jdField_a_of_type_AndroidViewViewGroup.getTag()).jdField_b_of_type_Int != this.jdField_j_of_type_Int - 1);
          localVideoFeedsAlphaMaskView = ((VideoFeedsAdapter.BaseItemHolder)this.jdField_a_of_type_AndroidViewViewGroup.getTag()).a;
        } while (localVideoFeedsAlphaMaskView == null);
        localVideoFeedsAlphaMaskView.setAlpha(1.0F - paramFloat);
        return;
      } while ((this.jdField_b_of_type_AndroidViewViewGroup == null) || (!(this.jdField_b_of_type_AndroidViewViewGroup.getTag() instanceof VideoFeedsAdapter.BaseItemHolder)) || (((VideoFeedsAdapter.BaseItemHolder)this.jdField_b_of_type_AndroidViewViewGroup.getTag()).jdField_b_of_type_Int != this.jdField_j_of_type_Int + 1));
      localVideoFeedsAlphaMaskView = ((VideoFeedsAdapter.BaseItemHolder)this.jdField_b_of_type_AndroidViewViewGroup.getTag()).a;
    } while (localVideoFeedsAlphaMaskView == null);
    localVideoFeedsAlphaMaskView.setAlpha(1.0F - paramFloat);
  }
  
  private void a(int paramInt)
  {
    paramInt = a(paramInt);
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      View localView = this.jdField_a_of_type_AndroidViewView.findViewById(2131366680);
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)localView.getLayoutParams();
      localLayoutParams.height = paramInt;
      localView.setLayoutParams(localLayoutParams);
    }
  }
  
  private void a(int paramInt, boolean paramBoolean)
  {
    c();
    Object localObject1 = this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131367394);
    if (localObject1 != null) {
      ((View)localObject1).setVisibility(8);
    }
    localObject1 = this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131367396);
    if (localObject1 != null) {
      ((View)localObject1).setVisibility(8);
    }
    this.jdField_f_of_type_Boolean = true;
    this.l = false;
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      localObject1 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject1).hasNext()) {
        ((VideoFeedsListView.ListViewEventListener)((Iterator)localObject1).next()).a(this.jdField_c_of_type_AndroidViewViewGroup.getTag(), true);
      }
    }
    localObject1 = (ViewGroup)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131367395);
    ViewGroup.LayoutParams localLayoutParams;
    if (!this.jdField_c_of_type_Boolean)
    {
      localObject2 = ((ViewGroup)localObject1).getLayoutParams();
      ((ViewGroup.LayoutParams)localObject2).height = this.jdField_a_of_type_Int;
      ((ViewGroup.LayoutParams)localObject2).width = this.jdField_b_of_type_Int;
      ((ViewGroup)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      paramInt = 0;
      while (paramInt < ((ViewGroup)localObject1).getChildCount())
      {
        localObject2 = ((ViewGroup)localObject1).getChildAt(paramInt);
        localLayoutParams = ((View)localObject2).getLayoutParams();
        localLayoutParams.height = this.jdField_a_of_type_Int;
        localLayoutParams.width = this.jdField_b_of_type_Int;
        ((View)localObject2).setLayoutParams(localLayoutParams);
        paramInt += 1;
      }
      this.jdField_e_of_type_Boolean = true;
      smoothScrollBy(this.jdField_g_of_type_Int, 0);
      localObject2 = this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131367397);
      if (localObject2 != null) {
        ((View)localObject2).setVisibility(8);
      }
      localObject2 = new AlphaAnimation(0.0F, 1.0F);
      ((AlphaAnimation)localObject2).setDuration(500L);
      ((AlphaAnimation)localObject2).setFillAfter(true);
      ((ViewGroup)localObject1).startAnimation((Animation)localObject2);
      return;
    }
    Object localObject2 = ((ViewGroup)localObject1).getLayoutParams();
    ((ViewGroup.LayoutParams)localObject2).height = this.jdField_a_of_type_Int;
    ((ViewGroup.LayoutParams)localObject2).width = this.jdField_a_of_type_Int;
    ((ViewGroup)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
    int i1 = 0;
    if (i1 < ((ViewGroup)localObject1).getChildCount())
    {
      localObject2 = ((ViewGroup)localObject1).getChildAt(i1);
      if (paramInt == 1) {
        ((View)localObject2).setRotation(90.0F);
      }
      for (;;)
      {
        ((View)localObject2).setTranslationX(-(this.jdField_a_of_type_Int - this.jdField_b_of_type_Int) / 2);
        localLayoutParams = ((View)localObject2).getLayoutParams();
        localLayoutParams.height = this.jdField_b_of_type_Int;
        localLayoutParams.width = this.jdField_a_of_type_Int;
        ((View)localObject2).setLayoutParams(localLayoutParams);
        ((View)localObject2).setTranslationY((this.jdField_a_of_type_Int - this.jdField_b_of_type_Int) / 2);
        i1 += 1;
        break;
        ((View)localObject2).setRotation(-90.0F);
      }
    }
    localObject2 = this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131367397);
    if (localObject2 != null) {
      ((View)localObject2).setVisibility(8);
    }
    if (this.jdField_d_of_type_Int == 0)
    {
      this.jdField_e_of_type_Boolean = true;
      smoothScrollBy(this.jdField_g_of_type_Int, 0);
    }
    if (paramBoolean)
    {
      localObject2 = new AlphaAnimation(0.0F, 1.0F);
      ((AlphaAnimation)localObject2).setDuration(500L);
      ((AlphaAnimation)localObject2).setFillAfter(true);
      ((ViewGroup)localObject1).startAnimation((Animation)localObject2);
    }
    this.jdField_d_of_type_Int = paramInt;
  }
  
  private void a(View paramView)
  {
    a(paramView, 0);
  }
  
  private void a(View paramView, int paramInt)
  {
    int i1 = 400;
    if (paramView == null) {
      return;
    }
    if ((paramView == this.jdField_a_of_type_AndroidViewViewGroup) || (paramView == this.jdField_b_of_type_AndroidViewViewGroup)) {
      this.l = true;
    }
    int i2 = (paramView.getTop() + paramView.getBottom()) / 2 - this.jdField_a_of_type_Int / 2;
    int i4 = Math.abs(i2);
    int i3 = Math.abs(paramInt);
    if (i3 == 0)
    {
      paramInt = 400;
      label72:
      if (i4 <= 1) {
        break label188;
      }
      if (paramInt <= 400) {
        break label190;
      }
      paramInt = i1;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.pubaccount.video.feeds.VideoFeedsListView", 2, "scroll distance = " + i2 + "speed = " + i3 + "duration = " + paramInt);
      }
      this.jdField_e_of_type_Boolean = true;
      if ((this.jdField_i_of_type_Boolean) && (i2 <= 0)) {
        this.jdField_e_of_type_Boolean = false;
      }
      post(new mcq(this, i2, paramInt));
      return;
      paramInt = i4 / i3;
      break label72;
      label188:
      break;
      label190:
      if (paramInt < 150) {
        paramInt = 150;
      }
    }
  }
  
  private void a(View paramView, boolean paramBoolean)
  {
    paramView = paramView.findViewById(2131367395);
    if (paramBoolean)
    {
      localLayoutParams = paramView.getLayoutParams();
      this.jdField_k_of_type_Int = localLayoutParams.height;
      localLayoutParams.height = VideoFeedsHelper.a(this.jdField_a_of_type_AndroidAppActivity);
      paramView.setLayoutParams(localLayoutParams);
      return;
    }
    ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
    localLayoutParams.height = this.jdField_k_of_type_Int;
    paramView.setLayoutParams(localLayoutParams);
  }
  
  private boolean a(int paramInt)
  {
    if ((paramInt >= 70) && (paramInt <= 110)) {
      paramInt = 1;
    }
    for (;;)
    {
      long l1 = System.currentTimeMillis();
      this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(paramInt), Long.valueOf(l1));
      Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
      Map.Entry localEntry;
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        localEntry = (Map.Entry)localIterator.next();
      } while ((((Integer)localEntry.getKey()).intValue() == paramInt) || (l1 - ((Long)localEntry.getValue()).longValue() >= 100L));
      return false;
      if ((paramInt >= 250) && (paramInt <= 290)) {
        paramInt = 2;
      } else {
        paramInt = 0;
      }
    }
    return true;
  }
  
  private int b()
  {
    int i2 = getLastVisiblePosition();
    int i3 = getFirstVisiblePosition();
    int i1 = 0;
    while (i1 <= i2 - i3)
    {
      int i4 = getChildAt(i1).getTop();
      int i5 = getChildAt(i1).getBottom();
      if ((i4 < this.jdField_a_of_type_Int / 2) && (i5 > this.jdField_a_of_type_Int / 2)) {
        return i1;
      }
      i1 += 1;
    }
    return -1;
  }
  
  private void b(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      View localView = this.jdField_a_of_type_AndroidViewView.findViewById(2131366680);
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)localView.getLayoutParams();
      localLayoutParams.height = paramInt;
      localView.setLayoutParams(localLayoutParams);
    }
  }
  
  private void g()
  {
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    try
    {
      this.jdField_a_of_type_AndroidViewOrientationEventListener = new mco(this, this.jdField_a_of_type_AndroidAppActivity, 3);
      if (this.jdField_a_of_type_AndroidViewOrientationEventListener.canDetectOrientation()) {
        this.jdField_a_of_type_AndroidViewOrientationEventListener.enable();
      }
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("Q.pubaccount.video.feeds.VideoFeedsListView", 2, "initOrientationEventListener() Exception error=" + localException.getMessage());
    }
  }
  
  public int a()
  {
    return this.jdField_c_of_type_Int;
  }
  
  public long a()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public void a()
  {
    if (this.jdField_e_of_type_Boolean) {
      postDelayed(new mcp(this), 100L);
    }
    while (this.jdField_b_of_type_AndroidViewViewGroup == null) {
      return;
    }
    a(this.jdField_b_of_type_AndroidViewViewGroup);
  }
  
  public void a(VideoFeedsListView.ListViewEventListener paramListViewEventListener)
  {
    this.jdField_a_of_type_JavaUtilArrayList.add(paramListViewEventListener);
  }
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt == 0)
    {
      DropFrameMonitor.a().a("list_video_feeds", false);
      switch (paramInt)
      {
      default: 
        label40:
        if (this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener != null) {
          this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener.a(paramAbsListView, paramInt);
        }
        break;
      }
    }
    do
    {
      return;
      DropFrameMonitor.a().a("list_video_feeds");
      break;
      if ((this.jdField_c_of_type_Int == 1) && (!this.jdField_e_of_type_Boolean)) {
        a(this.jdField_c_of_type_AndroidViewViewGroup, this.jdField_i_of_type_Int);
      }
      for (;;)
      {
        this.jdField_c_of_type_Int = 0;
        break;
        this.jdField_e_of_type_Boolean = false;
        if (this.l) {
          a(1.0F);
        }
        c();
        if (this.l) {
          a(0.0F);
        }
        if ((this.l) && (this.jdField_a_of_type_JavaUtilArrayList != null) && (!this.jdField_f_of_type_Boolean) && (this.jdField_c_of_type_AndroidViewViewGroup != null))
        {
          Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
          while (localIterator.hasNext()) {
            ((VideoFeedsListView.ListViewEventListener)localIterator.next()).a(this.jdField_c_of_type_AndroidViewViewGroup.getTag());
          }
        }
      }
      this.jdField_c_of_type_Int = 1;
      break label40;
    } while (this.jdField_e_of_type_Boolean);
    if (this.jdField_b_of_type_Float > this.jdField_a_of_type_Float) {
      if (!this.jdField_i_of_type_Boolean) {
        a(this.jdField_a_of_type_AndroidViewViewGroup, this.jdField_i_of_type_Int);
      }
    }
    for (;;)
    {
      this.jdField_c_of_type_Int = 2;
      break;
      a(this.jdField_c_of_type_AndroidViewViewGroup, this.jdField_i_of_type_Int);
      continue;
      if (this.jdField_b_of_type_Float < this.jdField_a_of_type_Float) {
        if (!this.jdField_j_of_type_Boolean) {
          a(this.jdField_b_of_type_AndroidViewViewGroup, this.jdField_i_of_type_Int);
        } else {
          a(this.jdField_c_of_type_AndroidViewViewGroup, this.jdField_i_of_type_Int);
        }
      }
    }
  }
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    float f1 = 1.0F;
    float f2;
    if (this.jdField_c_of_type_AndroidViewViewGroup != null)
    {
      f2 = Math.round(Math.abs(this.jdField_c_of_type_AndroidViewViewGroup.getTop() - this.jdField_g_of_type_Int) / this.jdField_f_of_type_Int * 100.0F) / 100.0F;
      if (f2 <= 1.0F) {
        break label81;
      }
    }
    for (;;)
    {
      a(f1);
      if (this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener != null) {
        this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener.a(paramAbsListView, paramInt1, paramInt2, paramInt3);
      }
      return;
      label81:
      f1 = f2;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean) {
      c();
    }
    a();
  }
  
  public boolean a()
  {
    return this.o;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_AndroidViewViewGroup != null) {
      a(this.jdField_a_of_type_AndroidViewViewGroup);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if (!this.jdField_f_of_type_Boolean) {
      return;
    }
    this.jdField_e_of_type_Int = 0;
    c(paramBoolean);
  }
  
  public void c()
  {
    if (this.jdField_d_of_type_Int != 0) {
      break label7;
    }
    label7:
    while (((this.jdField_f_of_type_Boolean) && (!this.jdField_c_of_type_Boolean)) || (this.o) || (this.n)) {
      return;
    }
    int i1 = b();
    this.jdField_c_of_type_AndroidViewViewGroup = ((ViewGroup)getChildAt(i1));
    this.jdField_b_of_type_AndroidViewViewGroup = ((ViewGroup)getChildAt(i1 + 1));
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)getChildAt(i1 - 1));
    int i2;
    if ((this.jdField_c_of_type_AndroidViewViewGroup != null) && (this.jdField_c_of_type_AndroidViewViewGroup.getTag() != null))
    {
      this.jdField_j_of_type_Int = ((VideoFeedsAdapter.BaseItemHolder)this.jdField_c_of_type_AndroidViewViewGroup.getTag()).jdField_b_of_type_Int;
      View localView = this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131367395);
      i1 = Math.abs(localView.getRight() - localView.getLeft());
      i2 = Math.abs(localView.getBottom() - localView.getTop());
      if (i1 <= i2) {
        break label272;
      }
    }
    label272:
    for (this.jdField_c_of_type_Boolean = true;; this.jdField_c_of_type_Boolean = false)
    {
      this.jdField_f_of_type_Int = i2;
      this.jdField_g_of_type_Int = this.jdField_c_of_type_AndroidViewViewGroup.getTop();
      this.jdField_j_of_type_Boolean = false;
      this.jdField_i_of_type_Boolean = false;
      if ((this.jdField_b_of_type_AndroidViewViewGroup != null) && (this.jdField_b_of_type_AndroidViewViewGroup.getTag() != null) && (((VideoFeedsAdapter.BaseItemHolder)this.jdField_b_of_type_AndroidViewViewGroup.getTag()).jdField_b_of_type_Int == getAdapter().getCount() - 1 - getHeaderViewsCount() - getFooterViewsCount())) {
        this.jdField_j_of_type_Boolean = true;
      }
      if ((this.jdField_a_of_type_AndroidViewViewGroup == null) || (this.jdField_a_of_type_AndroidViewViewGroup.getId() != 2131362199)) {
        break;
      }
      this.jdField_i_of_type_Boolean = true;
      return;
    }
  }
  
  public void c(boolean paramBoolean)
  {
    this.jdField_f_of_type_Boolean = false;
    this.jdField_d_of_type_Int = 0;
    Object localObject1 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((VideoFeedsListView.ListViewEventListener)((Iterator)localObject1).next()).a(this.jdField_c_of_type_AndroidViewViewGroup.getTag(), false);
    }
    localObject1 = this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131367394);
    if (localObject1 != null) {
      ((View)localObject1).setVisibility(0);
    }
    localObject1 = this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131367396);
    if (localObject1 != null) {
      ((View)localObject1).setVisibility(0);
    }
    localObject1 = (ViewGroup)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131367395);
    Object localObject2;
    int i1;
    ViewGroup.LayoutParams localLayoutParams;
    if (!this.jdField_c_of_type_Boolean)
    {
      localObject2 = ((ViewGroup)localObject1).getLayoutParams();
      ((ViewGroup.LayoutParams)localObject2).height = -2;
      ((ViewGroup.LayoutParams)localObject2).width = this.jdField_b_of_type_Int;
      ((ViewGroup)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      i1 = 0;
      while (i1 < ((ViewGroup)localObject1).getChildCount())
      {
        localObject2 = ((ViewGroup)localObject1).getChildAt(i1);
        localLayoutParams = ((View)localObject2).getLayoutParams();
        localLayoutParams.height = this.jdField_f_of_type_Int;
        localLayoutParams.width = this.jdField_b_of_type_Int;
        ((View)localObject2).setLayoutParams(localLayoutParams);
        i1 += 1;
      }
      this.jdField_e_of_type_Boolean = true;
      smoothScrollBy(-this.jdField_g_of_type_Int, 0);
      localObject1 = this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131367397);
      if (localObject1 != null) {
        ((View)localObject1).setVisibility(0);
      }
      localObject1 = new AlphaAnimation(0.0F, 1.0F);
      ((AlphaAnimation)localObject1).setDuration(500L);
      ((AlphaAnimation)localObject1).setFillAfter(true);
      startAnimation((Animation)localObject1);
    }
    do
    {
      return;
      localObject2 = ((ViewGroup)localObject1).getLayoutParams();
      ((ViewGroup.LayoutParams)localObject2).height = this.jdField_f_of_type_Int;
      ((ViewGroup.LayoutParams)localObject2).width = this.jdField_b_of_type_Int;
      ((ViewGroup)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      i1 = 0;
      while (i1 < ((ViewGroup)localObject1).getChildCount())
      {
        localObject2 = ((ViewGroup)localObject1).getChildAt(i1);
        ((View)localObject2).setRotation(0.0F);
        ((View)localObject2).setTranslationX(0.0F);
        localLayoutParams = ((View)localObject2).getLayoutParams();
        localLayoutParams.height = -1;
        localLayoutParams.width = -1;
        ((View)localObject2).setLayoutParams(localLayoutParams);
        ((View)localObject2).setTranslationY(0.0F);
        i1 += 1;
      }
      this.jdField_e_of_type_Boolean = true;
      smoothScrollBy(-this.jdField_g_of_type_Int, 0);
      localObject1 = this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131367397);
      if (localObject1 != null) {
        ((View)localObject1).setVisibility(0);
      }
    } while (!paramBoolean);
    localObject1 = new AlphaAnimation(0.0F, 1.0F);
    ((AlphaAnimation)localObject1).setDuration(500L);
    ((AlphaAnimation)localObject1).setFillAfter(true);
    startAnimation((Animation)localObject1);
  }
  
  public void d()
  {
    AlphaAnimation localAlphaAnimation;
    if (this.jdField_f_of_type_Boolean)
    {
      if (this.n)
      {
        this.n = false;
        b(false);
        localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
        localAlphaAnimation.setDuration(800L);
        localAlphaAnimation.setFillAfter(true);
        startAnimation(localAlphaAnimation);
        postDelayed(new mcr(this), 100L);
        return;
      }
      b(true);
      return;
    }
    if (this.o)
    {
      this.n = true;
      setIsScrollItemToTop(false, false);
      localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
      localAlphaAnimation.setDuration(500L);
      localAlphaAnimation.setFillAfter(true);
      startAnimation(localAlphaAnimation);
      postDelayed(new mcs(this), 100L);
      return;
    }
    d(true);
  }
  
  public void d(boolean paramBoolean)
  {
    if (this.jdField_f_of_type_Boolean) {}
    while (this.jdField_c_of_type_Int == 1) {
      return;
    }
    this.jdField_e_of_type_Int = 1;
    a(1, paramBoolean);
  }
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    if (!this.m)
    {
      this.jdField_c_of_type_AndroidViewViewGroup = ((ViewGroup)getChildAt(1));
      this.jdField_h_of_type_Int = (this.jdField_c_of_type_AndroidViewViewGroup.getBottom() - this.jdField_c_of_type_AndroidViewViewGroup.getTop());
      if (this.o)
      {
        paramCanvas = this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131367395);
        int i1 = Math.abs(paramCanvas.getRight() - paramCanvas.getLeft());
        int i2 = Math.abs(paramCanvas.getBottom() - paramCanvas.getTop());
        if (i1 > i2)
        {
          this.jdField_c_of_type_Boolean = true;
          this.jdField_f_of_type_Int = i2;
          this.jdField_g_of_type_Int = a(this.jdField_h_of_type_Int);
          this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131367394).setVisibility(8);
          b(0);
          a(this.jdField_c_of_type_AndroidViewViewGroup, true);
          this.p = false;
          label146:
          this.m = true;
        }
      }
    }
    do
    {
      do
      {
        return;
        this.jdField_c_of_type_Boolean = false;
        break;
        a(this.jdField_c_of_type_AndroidViewViewGroup.getHeight());
        break label146;
      } while (this.jdField_k_of_type_Boolean);
      if (!this.o)
      {
        c();
        this.jdField_g_of_type_Int = a(this.jdField_h_of_type_Int);
      }
    } while ((this.jdField_c_of_type_AndroidViewViewGroup == null) || (!(this.jdField_c_of_type_AndroidViewViewGroup.getTag() instanceof VideoFeedsAdapter.BaseVideoItemHolder)));
    this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131367397).setAlpha(0.0F);
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      paramCanvas = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (paramCanvas.hasNext()) {
        ((VideoFeedsListView.ListViewEventListener)paramCanvas.next()).a(this.jdField_c_of_type_AndroidViewViewGroup.getTag());
      }
    }
    this.jdField_k_of_type_Boolean = true;
  }
  
  public void e()
  {
    ViewGroup localViewGroup = (ViewGroup)LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130969671, null);
    localViewGroup.setId(2131362199);
    localViewGroup.setOnClickListener(new mct(this));
    this.jdField_a_of_type_AndroidViewView = localViewGroup;
    addHeaderView(localViewGroup);
    int i1 = (int)this.jdField_a_of_type_Int;
    localViewGroup = (ViewGroup)LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130969671, null);
    localViewGroup.setId(2131362200);
    View localView = localViewGroup.findViewById(2131366680);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)localView.getLayoutParams();
    localLayoutParams.height = i1;
    localView.setLayoutParams(localLayoutParams);
    localViewGroup.setOnClickListener(new mcu(this));
    addFooterView(localViewGroup);
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_AndroidViewOrientationEventListener != null)
    {
      this.jdField_a_of_type_AndroidViewOrientationEventListener.disable();
      this.jdField_a_of_type_AndroidViewOrientationEventListener = null;
    }
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      this.jdField_a_of_type_JavaUtilArrayList = null;
    }
    if (this.jdField_a_of_type_AndroidViewVelocityTracker != null)
    {
      this.jdField_a_of_type_AndroidViewVelocityTracker.recycle();
      this.jdField_a_of_type_AndroidViewVelocityTracker = null;
    }
    if (this.jdField_a_of_type_Mcv != null)
    {
      this.jdField_a_of_type_Mcv.b();
      this.jdField_a_of_type_Mcv = null;
    }
    this.jdField_a_of_type_AndroidViewViewGroup = null;
    this.jdField_c_of_type_AndroidViewViewGroup = null;
    this.jdField_b_of_type_AndroidViewViewGroup = null;
    this.jdField_a_of_type_AndroidContentContext = null;
    this.jdField_a_of_type_AndroidAppActivity = null;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    if (this.jdField_e_of_type_Boolean) {
      return true;
    }
    if (this.jdField_f_of_type_Boolean) {
      return false;
    }
    if (paramMotionEvent.getAction() == 0)
    {
      if ((this.jdField_c_of_type_AndroidViewViewGroup != null) && (!(this.jdField_c_of_type_AndroidViewViewGroup.getTag() instanceof VideoFeedsAdapter.ADVideoItemHolder)))
      {
        int i1 = AIOUtils.a(25.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        if ((paramMotionEvent.getY() < i1) || (Math.abs(this.jdField_a_of_type_Int - paramMotionEvent.getY()) < i1))
        {
          this.jdField_g_of_type_Boolean = true;
          return true;
        }
      }
      this.l = false;
      this.jdField_h_of_type_Boolean = false;
      this.jdField_a_of_type_Float = paramMotionEvent.getY();
      this.jdField_g_of_type_Boolean = false;
      c();
    }
    if ((!this.jdField_a_of_type_Boolean) || (this.o)) {
      return false;
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool2 = false;
    boolean bool1;
    if (this.jdField_e_of_type_Boolean) {
      bool1 = true;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (this.jdField_f_of_type_Boolean);
      bool1 = bool2;
    } while (this.jdField_g_of_type_Boolean);
    if (this.jdField_a_of_type_AndroidViewVelocityTracker == null) {
      this.jdField_a_of_type_AndroidViewVelocityTracker = VelocityTracker.obtain();
    }
    this.jdField_a_of_type_AndroidViewVelocityTracker.addMovement(paramMotionEvent);
    if (paramMotionEvent.getAction() == 1)
    {
      this.jdField_b_of_type_Float = paramMotionEvent.getY();
      if ((this.jdField_j_of_type_Boolean) && (paramMotionEvent.getY() + 300.0F < this.jdField_a_of_type_Float))
      {
        if (this.jdField_a_of_type_JavaUtilArrayList != null)
        {
          paramMotionEvent = this.jdField_a_of_type_JavaUtilArrayList.iterator();
          while (paramMotionEvent.hasNext()) {
            ((VideoFeedsListView.ListViewEventListener)paramMotionEvent.next()).a();
          }
        }
        a(this.jdField_c_of_type_AndroidViewViewGroup, this.jdField_i_of_type_Int);
        return true;
      }
      this.jdField_a_of_type_AndroidViewVelocityTracker.clear();
    }
    int i1;
    float f1;
    do
    {
      do
      {
        return super.onTouchEvent(paramMotionEvent);
      } while (paramMotionEvent.getAction() != 2);
      this.jdField_a_of_type_AndroidViewVelocityTracker.computeCurrentVelocity(1);
      this.jdField_i_of_type_Int = ((int)this.jdField_a_of_type_AndroidViewVelocityTracker.getYVelocity());
      if ((this.jdField_i_of_type_Boolean) && (paramMotionEvent.getY() > this.jdField_a_of_type_Float))
      {
        if ((paramMotionEvent.getY() - this.jdField_a_of_type_Float > 300.0F) && (!this.jdField_b_of_type_Boolean))
        {
          this.jdField_b_of_type_Boolean = true;
          if (this.jdField_a_of_type_JavaUtilArrayList != null)
          {
            paramMotionEvent = this.jdField_a_of_type_JavaUtilArrayList.iterator();
            while (paramMotionEvent.hasNext()) {
              ((VideoFeedsListView.ListViewEventListener)paramMotionEvent.next()).b();
            }
          }
        }
        return true;
      }
      i1 = (int)(this.jdField_f_of_type_Int * 0.3D);
      f1 = paramMotionEvent.getY() - this.jdField_a_of_type_Float;
      if ((this.jdField_j_of_type_Boolean) && (f1 < 0.0F) && (Math.abs(f1) >= i1)) {
        return true;
      }
      if (this.jdField_h_of_type_Boolean) {
        return true;
      }
      if ((f1 > 0.0F) && (i1 <= f1))
      {
        this.jdField_h_of_type_Boolean = true;
        a(this.jdField_a_of_type_AndroidViewViewGroup, this.jdField_i_of_type_Int);
        return true;
      }
    } while ((f1 >= 0.0F) || (Math.abs(f1) < i1));
    this.jdField_h_of_type_Boolean = true;
    a(this.jdField_b_of_type_AndroidViewViewGroup, this.jdField_i_of_type_Int);
    return true;
  }
  
  public void setIsScrollItemToTop(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.jdField_k_of_type_Boolean) {
      if (!paramBoolean1)
      {
        this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131367394).setVisibility(0);
        if (!this.p)
        {
          this.p = true;
          a(this.jdField_h_of_type_Int);
          a(this.jdField_c_of_type_AndroidViewViewGroup, false);
          this.o = false;
        }
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.pubaccount.video.feeds.VideoFeedsListView", 2, "setIsScrollItemToTop isScrollItemToTop=" + paramBoolean1 + ", needDurationWhenScrollToTop=" + paramBoolean2 + ", mFirstDrawCompleted=" + this.jdField_k_of_type_Boolean + ", mIsHeaderHeightSetted=" + this.p + ", mIsNeedRecoveryScrollItemToTop=" + this.n + ", mCenterViewHeight=" + this.jdField_h_of_type_Int + ", mContentViewHeightBefore=" + this.jdField_k_of_type_Int);
      }
      if (this.jdField_a_of_type_JavaUtilArrayList == null) {
        return;
      }
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext()) {
        ((VideoFeedsListView.ListViewEventListener)localIterator.next()).a(paramBoolean1);
      }
      this.jdField_a_of_type_AndroidViewViewGroup = null;
      this.jdField_b_of_type_AndroidViewViewGroup = null;
      this.jdField_e_of_type_Boolean = true;
      if (this.n)
      {
        smoothScrollBy(-this.jdField_g_of_type_Int, 0);
        break;
      }
      smoothScrollBy(-this.jdField_g_of_type_Int, 500);
      break;
      this.o = true;
      this.jdField_h_of_type_Int = (this.jdField_c_of_type_AndroidViewViewGroup.getBottom() - this.jdField_c_of_type_AndroidViewViewGroup.getTop());
      this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131367394).setVisibility(8);
      this.jdField_e_of_type_Boolean = true;
      if (paramBoolean2) {
        smoothScrollBy(this.jdField_g_of_type_Int, 500);
      }
      for (;;)
      {
        a(this.jdField_c_of_type_AndroidViewViewGroup, true);
        break;
        smoothScrollBy(this.jdField_g_of_type_Int, 0);
      }
      this.o = paramBoolean1;
    }
  }
  
  public void setNeedDetectScreenOrientation(boolean paramBoolean)
  {
    this.jdField_d_of_type_Boolean = paramBoolean;
  }
  
  public void setOnScrollListener(AbsListView.OnScrollListener paramOnScrollListener)
  {
    this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener = paramOnScrollListener;
  }
  
  public void setScrollable(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsListView
 * JD-Core Version:    0.7.0.1
 */