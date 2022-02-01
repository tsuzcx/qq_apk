package com.tencent.biz.publicAccountImageCollection;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAlphaMaskView;
import com.tencent.biz.pubaccount.readinjoy.view.imageloader.ZImageView;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.Iterator;
import syn;
import vex;
import vey;
import vfg;
import vfw;
import vgb;
import vgc;

public class PublicAccountImageCollectionListView
  extends ListView
  implements AbsListView.OnScrollListener
{
  private float jdField_a_of_type_Float;
  int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private Context jdField_a_of_type_AndroidContentContext;
  private VelocityTracker jdField_a_of_type_AndroidViewVelocityTracker;
  private AbsListView.OnScrollListener jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener;
  private ArrayList<vfg> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  boolean jdField_a_of_type_Boolean = false;
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int;
  private ArrayList<vgb> jdField_b_of_type_JavaUtilArrayList;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private ArrayList<vgc> jdField_c_of_type_JavaUtilArrayList;
  private boolean jdField_c_of_type_Boolean;
  private boolean d;
  
  public PublicAccountImageCollectionListView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public PublicAccountImageCollectionListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public PublicAccountImageCollectionListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private int a()
  {
    int i = getFirstVisiblePosition();
    while (i <= getLastVisiblePosition())
    {
      int j = getChildAt(i - getFirstVisiblePosition()).getTop();
      int k = getChildAt(i - getFirstVisiblePosition()).getBottom();
      if ((j < this.jdField_b_of_type_Int / 2) && (k > this.jdField_b_of_type_Int / 2)) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  private void a(int paramInt)
  {
    Object localObject = getChildAt(paramInt - getFirstVisiblePosition());
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PublicAccountImageCollectionListView", 2, "smoothScrollTo targetView is null");
      }
      return;
    }
    if (paramInt != a()) {
      this.d = true;
    }
    int i = ((View)localObject).getTop();
    paramInt = ((View)localObject).getBottom();
    if ((((View)localObject).getTag() instanceof vey))
    {
      localObject = (vey)((View)localObject).getTag();
      if (((vey)localObject).jdField_a_of_type_AndroidWidgetTextView.getBottom() != ((vey)localObject).jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderZImageView.getBottom()) {
        paramInt = ((vey)localObject).jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderZImageView.getBottom() + i;
      }
    }
    for (;;)
    {
      i = (paramInt + i) / 2 - this.jdField_b_of_type_Int / 2;
      if (i == 0) {
        break;
      }
      paramInt = Math.abs(i);
      int j = Math.abs(this.jdField_c_of_type_Int);
      if (j == 0) {
        paramInt = 400;
      }
      for (;;)
      {
        this.jdField_b_of_type_Boolean = true;
        syn.a().b();
        post(new PublicAccountImageCollectionListView.1(this, i, paramInt));
        return;
        paramInt /= j;
      }
    }
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PublicAccountImageCollectionListView", 2, "preloadImg start:" + paramInt1 + " count:" + paramInt2);
    }
    if (this.jdField_b_of_type_JavaUtilArrayList == null) {}
    long l;
    do
    {
      return;
      l = System.currentTimeMillis();
    } while (!NetworkUtil.isWifiConnected(this.jdField_a_of_type_AndroidContentContext));
    ArrayList localArrayList = new ArrayList(this.jdField_b_of_type_JavaUtilArrayList);
    ThreadManager.post(new PublicAccountImageCollectionListView.2(this, this.jdField_a_of_type_Long, localArrayList, paramInt1, paramInt2, l), 5, null, true);
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_Boolean) {}
    while (!PublicAccountImageCollectionPreloadManager.a().a()) {
      return;
    }
    PublicAccountImageCollectionPreloadManager.a().c();
    if (this.jdField_c_of_type_JavaUtilArrayList != null)
    {
      int j = this.jdField_c_of_type_JavaUtilArrayList.size();
      int i = 0;
      while (i < j)
      {
        PublicAccountImageCollectionPreloadManager.a().a(((vgc)this.jdField_c_of_type_JavaUtilArrayList.get(i)).d);
        i += 1;
      }
    }
    this.jdField_a_of_type_Boolean = true;
  }
  
  public ViewGroup a()
  {
    return (ViewGroup)getChildAt(a() - getFirstVisiblePosition());
  }
  
  public Boolean a(View paramView)
  {
    boolean bool = false;
    if (a().equals(paramView)) {
      bool = true;
    }
    return Boolean.valueOf(bool);
  }
  
  public void a()
  {
    a(this.jdField_a_of_type_Int);
  }
  
  void a(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewVelocityTracker = VelocityTracker.obtain();
    super.setOnScrollListener(this);
  }
  
  void a(View paramView)
  {
    float f1 = 1.0F;
    VideoFeedsAlphaMaskView localVideoFeedsAlphaMaskView = null;
    float f2;
    if ((paramView != null) && (paramView.getTag() != null))
    {
      if (!(paramView.getTag() instanceof vey)) {
        break label110;
      }
      localVideoFeedsAlphaMaskView = ((vey)paramView.getTag()).jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAlphaMaskView;
      int i = Math.abs((paramView.getBottom() + paramView.getTop()) / 2 - this.jdField_b_of_type_Int / 2);
      int j = (paramView.getBottom() - paramView.getTop()) / 2;
      f2 = Math.round(i / j * 100.0F) / 100.0F;
      if (f2 <= 1.0F) {
        break label160;
      }
    }
    for (;;)
    {
      if (localVideoFeedsAlphaMaskView != null) {
        localVideoFeedsAlphaMaskView.setAlpha(f1);
      }
      return;
      label110:
      if ((paramView.getTag() instanceof vex))
      {
        localVideoFeedsAlphaMaskView = ((vex)paramView.getTag()).jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAlphaMaskView;
        break;
      }
      if (!(paramView.getTag() instanceof vfw)) {
        break;
      }
      localVideoFeedsAlphaMaskView = ((vfw)paramView.getTag()).jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAlphaMaskView;
      break;
      label160:
      f1 = f2;
    }
  }
  
  public void a(vfg paramvfg)
  {
    this.jdField_a_of_type_JavaUtilArrayList.add(paramvfg);
  }
  
  void b()
  {
    int i = getFirstVisiblePosition();
    if (i <= getLastVisiblePosition())
    {
      ViewGroup localViewGroup = (ViewGroup)getChildAt(i - getFirstVisiblePosition());
      if ((localViewGroup.getTop() < this.jdField_b_of_type_Int / 2) && (localViewGroup.getBottom() > this.jdField_b_of_type_Int / 2))
      {
        if ((localViewGroup.getTag() instanceof vfw))
        {
          localViewGroup.setClickable(false);
          localViewGroup.getChildAt(0).setClickable(true);
          localViewGroup.getChildAt(0).setFocusable(true);
          localViewGroup.getChildAt(0).setEnabled(true);
        }
        if ((localViewGroup.getTag() instanceof vey))
        {
          localViewGroup.setClickable(false);
          localViewGroup.getChildAt(1).setClickable(true);
          localViewGroup.getChildAt(1).setFocusable(true);
          localViewGroup.getChildAt(1).setEnabled(true);
        }
      }
      for (;;)
      {
        i += 1;
        break;
        if ((localViewGroup.getTag() instanceof vfw))
        {
          localViewGroup.setClickable(true);
          localViewGroup.getChildAt(0).setClickable(false);
          localViewGroup.getChildAt(0).setFocusable(false);
          localViewGroup.getChildAt(0).setEnabled(false);
        }
        if ((localViewGroup.getTag() instanceof vey))
        {
          localViewGroup.setClickable(true);
          localViewGroup.getChildAt(1).setClickable(false);
          localViewGroup.getChildAt(1).setFocusable(false);
          localViewGroup.getChildAt(1).setEnabled(false);
        }
      }
    }
  }
  
  public void c()
  {
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
    this.jdField_a_of_type_AndroidContentContext = null;
    syn.a().a();
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.jdField_b_of_type_Boolean) {
      return true;
    }
    if (paramMotionEvent.getAction() == 0)
    {
      this.d = false;
      this.jdField_c_of_type_Boolean = false;
      this.jdField_a_of_type_Float = paramMotionEvent.getY();
      this.jdField_a_of_type_Int = a();
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    paramInt1 = 0;
    while (paramInt1 < paramInt2)
    {
      a(paramAbsListView.getChildAt(paramInt1));
      paramInt1 += 1;
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener != null) {
        this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener.onScrollStateChanged(paramAbsListView, paramInt);
      }
      do
      {
        return;
        if (!this.jdField_b_of_type_Boolean) {
          a(this.jdField_a_of_type_Int);
        }
        this.jdField_b_of_type_Boolean = false;
        ViewGroup localViewGroup = a();
        if ((this.d) && (this.jdField_a_of_type_JavaUtilArrayList != null) && (localViewGroup != null))
        {
          Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
          while (localIterator.hasNext()) {
            ((vfg)localIterator.next()).a(localViewGroup.getTag());
          }
        }
        syn.a().c();
        int i = getLastVisiblePosition();
        int j = getFirstVisiblePosition();
        int k = PublicAccountImageCollectionPreloadManager.a().a();
        a(getFirstVisiblePosition(), i - j + 1 + k);
        if ((getChildAt(paramAbsListView.getLastVisiblePosition() - getFirstVisiblePosition()).getTag() instanceof vfw)) {
          d();
        }
        b();
        break;
      } while (this.jdField_b_of_type_Boolean);
      if (this.jdField_b_of_type_Float - this.jdField_a_of_type_Float > 0.0F) {
        a(this.jdField_a_of_type_Int - 1);
      } else {
        a(this.jdField_a_of_type_Int + 1);
      }
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.jdField_b_of_type_Boolean) {
      return true;
    }
    if (this.jdField_a_of_type_AndroidViewVelocityTracker == null) {
      this.jdField_a_of_type_AndroidViewVelocityTracker = VelocityTracker.obtain();
    }
    this.jdField_a_of_type_AndroidViewVelocityTracker.addMovement(paramMotionEvent);
    if (paramMotionEvent.getAction() == 1)
    {
      this.jdField_b_of_type_Float = paramMotionEvent.getY();
      this.jdField_a_of_type_AndroidViewVelocityTracker.clear();
    }
    do
    {
      int i;
      do
      {
        View localView;
        do
        {
          do
          {
            return super.onTouchEvent(paramMotionEvent);
          } while (paramMotionEvent.getAction() != 2);
          this.jdField_a_of_type_AndroidViewVelocityTracker.computeCurrentVelocity(1);
          this.jdField_c_of_type_Int = ((int)this.jdField_a_of_type_AndroidViewVelocityTracker.getYVelocity());
          if (this.jdField_c_of_type_Boolean) {
            break;
          }
          localView = getChildAt(this.jdField_a_of_type_Int - getFirstVisiblePosition());
        } while (localView == null);
        i = (int)(localView.getHeight() * 0.8D);
      } while (Math.abs(paramMotionEvent.getY() - this.jdField_a_of_type_Float) < i);
      if (paramMotionEvent.getY() - this.jdField_a_of_type_Float > 0.0F)
      {
        this.jdField_c_of_type_Boolean = true;
        a(this.jdField_a_of_type_Int - 1);
        return true;
      }
    } while (paramMotionEvent.getY() - this.jdField_a_of_type_Float >= 0.0F);
    this.jdField_c_of_type_Boolean = true;
    a(this.jdField_a_of_type_Int + 1);
    return true;
  }
  
  public void setPhotoCollectionInfo(ArrayList<vgb> paramArrayList)
  {
    this.jdField_b_of_type_JavaUtilArrayList = paramArrayList;
    a(1, 1);
  }
  
  public void setRecommendInfo(ArrayList<vgc> paramArrayList)
  {
    this.jdField_c_of_type_JavaUtilArrayList = paramArrayList;
  }
  
  public void setScreenHeight(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.publicAccountImageCollection.PublicAccountImageCollectionListView
 * JD-Core Version:    0.7.0.1
 */