package com.tencent.biz.pubaccount.readinjoy.video;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.support.v7.widget.StaggeredGridLayoutManager.LayoutParams;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import com.tencent.mobileqq.R.styleable;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.pull2refresh.PagerSnapHelper;
import com.tencent.widget.pull2refresh.PagerSnapHelper.PagerEventListener;
import com.tencent.widget.pull2refresh.RecyclerViewWithHeaderFooter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class VideoFeedsRecyclerView
  extends RecyclerViewWithHeaderFooter
  implements OrientationDetector.OnOrientationChangedListener, PagerSnapHelper.PagerEventListener
{
  private static int jdField_a_of_type_Int;
  private static int jdField_b_of_type_Int;
  private float jdField_a_of_type_Float;
  private long jdField_a_of_type_Long;
  private RecyclerView.OnScrollListener jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$OnScrollListener = new VideoFeedsRecyclerView.1(this);
  private RecyclerView.ViewHolder jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder;
  private View jdField_a_of_type_AndroidViewView;
  private OrientationDetector jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoOrientationDetector;
  private PagerSnapHelper jdField_a_of_type_ComTencentWidgetPull2refreshPagerSnapHelper;
  private List<VideoFeedsRecyclerView.ListEventListener> jdField_a_of_type_JavaUtilList;
  private float jdField_b_of_type_Float;
  private View jdField_b_of_type_AndroidViewView;
  private boolean jdField_b_of_type_Boolean = false;
  private int jdField_c_of_type_Int;
  private boolean jdField_c_of_type_Boolean = true;
  private int jdField_d_of_type_Int = -1;
  private boolean jdField_d_of_type_Boolean = false;
  private int jdField_e_of_type_Int;
  private boolean jdField_e_of_type_Boolean = false;
  private int jdField_f_of_type_Int;
  private boolean jdField_f_of_type_Boolean = true;
  private int jdField_g_of_type_Int = 0;
  private boolean jdField_g_of_type_Boolean;
  private boolean h = true;
  private boolean i = true;
  private boolean j = true;
  
  public VideoFeedsRecyclerView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public VideoFeedsRecyclerView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public VideoFeedsRecyclerView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    e();
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.VideoFeedsRecyclerView, paramInt, 0);
    this.jdField_e_of_type_Int = paramContext.getInt(0, 0);
    this.jdField_f_of_type_Int = paramContext.getDimensionPixelSize(1, 0);
    this.jdField_b_of_type_Float = paramContext.getFloat(2, 25.0F);
    paramContext.recycle();
  }
  
  private void a(int paramInt, boolean paramBoolean)
  {
    if (!this.jdField_d_of_type_Boolean) {}
    do
    {
      do
      {
        return;
      } while ((this.jdField_b_of_type_Boolean) || (this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder == null));
      this.jdField_d_of_type_Boolean = false;
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoOrientationDetector != null) && (this.jdField_f_of_type_Boolean))
      {
        localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoOrientationDetector.a();
        if ((localObject instanceof Activity)) {
          ((Activity)localObject).setRequestedOrientation(1);
        }
      }
      if (this.jdField_a_of_type_JavaUtilList != null)
      {
        localObject = this.jdField_a_of_type_JavaUtilList.iterator();
        while (((Iterator)localObject).hasNext()) {
          ((VideoFeedsRecyclerView.ListEventListener)((Iterator)localObject).next()).a(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder, false);
        }
      }
    } while (!paramBoolean);
    Object localObject = new AlphaAnimation(0.0F, 1.0F);
    ((AlphaAnimation)localObject).setDuration(500L);
    ((AlphaAnimation)localObject).setFillAfter(true);
    startAnimation((Animation)localObject);
  }
  
  private void b(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      View localView = this.jdField_a_of_type_AndroidViewView;
      ViewGroup.LayoutParams localLayoutParams = localView.getLayoutParams();
      localLayoutParams.height = paramInt;
      localLayoutParams.width = -1;
      localView.setLayoutParams(localLayoutParams);
    }
  }
  
  private void b(int paramInt, boolean paramBoolean)
  {
    if (this.jdField_d_of_type_Boolean) {}
    label116:
    do
    {
      do
      {
        return;
      } while ((this.jdField_b_of_type_Boolean) || (this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder == null));
      this.jdField_d_of_type_Boolean = true;
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoOrientationDetector != null) && (this.jdField_f_of_type_Boolean))
      {
        if (paramInt != 0) {
          break label116;
        }
        localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoOrientationDetector.a();
        if ((localObject instanceof Activity)) {
          ((Activity)localObject).setRequestedOrientation(0);
        }
      }
      while (this.jdField_a_of_type_JavaUtilList != null)
      {
        localObject = this.jdField_a_of_type_JavaUtilList.iterator();
        while (((Iterator)localObject).hasNext()) {
          ((VideoFeedsRecyclerView.ListEventListener)((Iterator)localObject).next()).a(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder, true);
        }
        localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoOrientationDetector.a();
        if ((localObject instanceof Activity)) {
          ((Activity)localObject).setRequestedOrientation(8);
        }
      }
    } while (!paramBoolean);
    Object localObject = new AlphaAnimation(0.0F, 1.0F);
    ((AlphaAnimation)localObject).setDuration(500L);
    ((AlphaAnimation)localObject).setFillAfter(true);
    startAnimation((Animation)localObject);
  }
  
  private void e()
  {
    addOnScrollListener(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$OnScrollListener);
    g();
    setOverScrollMode(2);
    setItemAnimator(null);
    setHasFixedSize(true);
    setItemViewCacheSize(0);
    setClipChildren(false);
    setVerticalScrollBarEnabled(false);
    setHorizontalScrollBarEnabled(false);
    jdField_a_of_type_Int = super.getMinFlingVelocity() * 3;
    jdField_b_of_type_Int = super.getMinFlingVelocity() * 3;
  }
  
  private void f()
  {
    this.jdField_a_of_type_ComTencentWidgetPull2refreshPagerSnapHelper = new PagerSnapHelper(this.jdField_e_of_type_Int, this.jdField_b_of_type_Float);
    this.jdField_a_of_type_ComTencentWidgetPull2refreshPagerSnapHelper.e(this.jdField_f_of_type_Int);
    this.jdField_a_of_type_ComTencentWidgetPull2refreshPagerSnapHelper.c(this.jdField_c_of_type_Int + 1);
    this.jdField_a_of_type_ComTencentWidgetPull2refreshPagerSnapHelper.d(1);
    this.jdField_a_of_type_ComTencentWidgetPull2refreshPagerSnapHelper.a(this);
    this.jdField_a_of_type_ComTencentWidgetPull2refreshPagerSnapHelper.a(this);
    if (Build.VERSION.SDK_INT >= 23) {
      this.jdField_a_of_type_ComTencentWidgetPull2refreshPagerSnapHelper.a(true);
    }
    addOnLayoutChangeListener(new VideoFeedsRecyclerView.2(this));
  }
  
  private void g()
  {
    View localView = new View(getContext());
    localView.setId(2131376556);
    localView.setLayoutParams(new StaggeredGridLayoutManager.LayoutParams(-2, -2));
    this.jdField_a_of_type_AndroidViewView = localView;
    a(localView);
    localView = new View(getContext());
    localView.setId(2131376555);
    localView.setLayoutParams(new StaggeredGridLayoutManager.LayoutParams(-2, -2));
    this.jdField_b_of_type_AndroidViewView = localView;
    c(localView);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_ComTencentWidgetPull2refreshPagerSnapHelper.b() - 1;
  }
  
  public long a()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public View a()
  {
    if ((getLayoutManager() instanceof LinearLayoutManager)) {
      return this.jdField_a_of_type_ComTencentWidgetPull2refreshPagerSnapHelper.a((LinearLayoutManager)getLayoutManager());
    }
    return null;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        ((VideoFeedsRecyclerView.ListEventListener)localIterator.next()).E_();
      }
    }
  }
  
  public void a(int paramInt)
  {
    if ((this.jdField_b_of_type_Boolean) || (!this.jdField_e_of_type_Boolean) || (this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder == null)) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("VideoFeedsRecyclerView", 2, "onOrientationChanged: requestOrientation=" + paramInt + ", userOrientation=" + this.jdField_d_of_type_Int);
      }
    } while ((this.jdField_d_of_type_Int != -1) && (this.jdField_d_of_type_Int != paramInt));
    this.jdField_d_of_type_Int = -1;
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      b(paramInt, true);
      return;
    case 1: 
      a(paramInt, true);
      return;
    case 8: 
      b(paramInt, true);
      return;
    }
    a(paramInt, true);
  }
  
  public void a(RecyclerView.ViewHolder paramViewHolder)
  {
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder = paramViewHolder;
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoFeedsRecyclerView", 2, "onPagerChanged: pagerSnapOnCenterViewChanged position=" + paramViewHolder.getLayoutPosition() + ", this=" + this);
      }
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        ((VideoFeedsRecyclerView.ListEventListener)localIterator.next()).a(paramViewHolder);
      }
    }
  }
  
  public void a(VideoFeedsRecyclerView.ListEventListener paramListEventListener)
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
    }
    this.jdField_a_of_type_JavaUtilList.add(paramListEventListener);
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoFeedsRecyclerView", 2, "user exitFullScreen: ");
    }
    this.jdField_d_of_type_Int = 1;
    a(1, paramBoolean);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_ComTencentWidgetPull2refreshPagerSnapHelper.a();
  }
  
  public int b()
  {
    return this.jdField_a_of_type_ComTencentWidgetPull2refreshPagerSnapHelper.b();
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoFeedsRecyclerView", 2, "changeFullScreenStatus: mIsShowingFull=" + this.jdField_d_of_type_Boolean);
    }
    if (this.jdField_d_of_type_Boolean)
    {
      a(true);
      return;
    }
    b(true);
  }
  
  public void b(RecyclerView.ViewHolder paramViewHolder)
  {
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoFeedsRecyclerView", 2, "onPagerIdle: pagerSnapOnCenterViewChanged position=" + paramViewHolder.getLayoutPosition() + ", this=" + this);
      }
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        ((VideoFeedsRecyclerView.ListEventListener)localIterator.next()).b(paramViewHolder);
      }
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoFeedsRecyclerView", 2, "user enterFullScreen: ");
    }
    this.jdField_d_of_type_Int = 0;
    b(0, paramBoolean);
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_ComTencentWidgetPull2refreshPagerSnapHelper.b();
  }
  
  public void c()
  {
    addOnLayoutChangeListener(new VideoFeedsRecyclerView.3(this));
  }
  
  public boolean c()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      this.jdField_a_of_type_JavaUtilList = null;
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoOrientationDetector != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoOrientationDetector.a();
    }
  }
  
  public int getMinFlingVelocity()
  {
    if (getLayoutManager().canScrollVertically()) {
      return jdField_a_of_type_Int;
    }
    return jdField_b_of_type_Int;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    if (this.jdField_a_of_type_ComTencentWidgetPull2refreshPagerSnapHelper.d()) {}
    do
    {
      do
      {
        return false;
      } while (this.jdField_d_of_type_Boolean);
      if (paramMotionEvent.getAction() == 0)
      {
        this.jdField_a_of_type_Float = paramMotionEvent.getY();
        this.jdField_g_of_type_Boolean = false;
      }
      if ((paramMotionEvent.getAction() == 2) && (!this.jdField_g_of_type_Boolean) && (this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder != null))
      {
        int k = DisplayUtil.a(getContext(), 25.0F);
        int m = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        if ((Math.abs(this.jdField_a_of_type_Float - paramMotionEvent.getY()) > m) && ((this.jdField_a_of_type_Float < k) || (Math.abs(getHeight() - this.jdField_a_of_type_Float) < k)))
        {
          this.jdField_g_of_type_Boolean = true;
          return false;
        }
      }
    } while (!this.jdField_c_of_type_Boolean);
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool2 = false;
    boolean bool1;
    if (this.jdField_a_of_type_ComTencentWidgetPull2refreshPagerSnapHelper.d()) {
      bool1 = true;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (this.jdField_d_of_type_Boolean);
      bool1 = bool2;
    } while (this.jdField_g_of_type_Boolean);
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void scrollToPosition(int paramInt)
  {
    super.scrollToPosition(c() + paramInt);
    this.jdField_a_of_type_ComTencentWidgetPull2refreshPagerSnapHelper.c();
  }
  
  public void setAdapter(RecyclerView.Adapter paramAdapter)
  {
    RecyclerView.Adapter localAdapter = getAdapter();
    super.setAdapter(paramAdapter);
    if ((localAdapter != getAdapter()) && (getAdapter() != null) && (getLayoutManager() != null)) {
      f();
    }
  }
  
  public void setEnableFooterView(boolean paramBoolean)
  {
    this.i = paramBoolean;
  }
  
  public void setEnableHeaderView(boolean paramBoolean)
  {
    this.h = paramBoolean;
  }
  
  public void setExtraFooterCount(int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
  }
  
  public void setHeaderHeight(int paramInt)
  {
    this.jdField_g_of_type_Int = paramInt;
  }
  
  public void setLayoutManager(RecyclerView.LayoutManager paramLayoutManager)
  {
    RecyclerView.LayoutManager localLayoutManager = getLayoutManager();
    super.setLayoutManager(paramLayoutManager);
    if ((localLayoutManager != getLayoutManager()) && (getLayoutManager() != null) && (getAdapter() != null)) {
      f();
    }
  }
  
  public void setNeedDetectOrientation(Activity paramActivity, boolean paramBoolean)
  {
    this.jdField_e_of_type_Boolean = paramBoolean;
    if ((this.jdField_e_of_type_Boolean) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoOrientationDetector == null)) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoOrientationDetector = new OrientationDetector(paramActivity, this);
    }
  }
  
  public void setNeedDetectOrientation(Activity paramActivity, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.jdField_f_of_type_Boolean = paramBoolean2;
    setNeedDetectOrientation(paramActivity, paramBoolean1);
  }
  
  public void setScrollable(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
  }
  
  public void setSnapOffset(int paramInt)
  {
    this.jdField_f_of_type_Int = paramInt;
    if (this.jdField_a_of_type_ComTencentWidgetPull2refreshPagerSnapHelper != null) {
      this.jdField_a_of_type_ComTencentWidgetPull2refreshPagerSnapHelper.e(paramInt);
    }
  }
  
  public void setSnapOnFling(boolean paramBoolean)
  {
    this.j = paramBoolean;
    this.jdField_a_of_type_ComTencentWidgetPull2refreshPagerSnapHelper.c(paramBoolean);
  }
  
  public void setSnapOnIdle(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentWidgetPull2refreshPagerSnapHelper.b(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsRecyclerView
 * JD-Core Version:    0.7.0.1
 */