package com.tencent.biz.pubaccount.imagecollection;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.biz.pubaccount.imagecollection.api.IPublicAccountImageCollectionPreloadManager;
import com.tencent.biz.pubaccount.imagecollection.api.IPublicAccountImageCollectionUtils.PhotoItemInfo;
import com.tencent.biz.pubaccount.imagecollection.api.IPublicAccountImageCollectionUtils.RecommendItemInfo;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.base.image.api.IImageManager;
import com.tencent.mobileqq.kandian.base.view.widget.VideoFeedsAlphaMaskView;
import com.tencent.mobileqq.kandian.base.view.widget.ZImageView;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PublicAccountImageCollectionListView
  extends ListView
  implements AbsListView.OnScrollListener
{
  private float jdField_a_of_type_Float;
  int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long = 0L;
  private Context jdField_a_of_type_AndroidContentContext;
  private VelocityTracker jdField_a_of_type_AndroidViewVelocityTracker;
  private AbsListView.OnScrollListener jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener = null;
  private ArrayList<PublicAccountImageCollectionListView.ListViewEventListener> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  boolean jdField_a_of_type_Boolean = false;
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int;
  private ArrayList<IPublicAccountImageCollectionUtils.PhotoItemInfo> jdField_b_of_type_JavaUtilArrayList = null;
  private boolean jdField_b_of_type_Boolean = false;
  private int jdField_c_of_type_Int = 0;
  private ArrayList<IPublicAccountImageCollectionUtils.RecommendItemInfo> jdField_c_of_type_JavaUtilArrayList = null;
  private boolean jdField_c_of_type_Boolean = false;
  private boolean d = false;
  
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
      int m = this.jdField_b_of_type_Int;
      if ((j < m / 2) && (k > m / 2)) {
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
    int j = ((View)localObject).getTop();
    int i = ((View)localObject).getBottom();
    paramInt = i;
    if ((((View)localObject).getTag() instanceof PublicAccountImageCollectionAdapter.ImageItemHolder))
    {
      localObject = (PublicAccountImageCollectionAdapter.ImageItemHolder)((View)localObject).getTag();
      paramInt = i;
      if (((PublicAccountImageCollectionAdapter.ImageItemHolder)localObject).jdField_a_of_type_AndroidWidgetTextView.getBottom() != ((PublicAccountImageCollectionAdapter.ImageItemHolder)localObject).jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetZImageView.getBottom()) {
        paramInt = ((PublicAccountImageCollectionAdapter.ImageItemHolder)localObject).jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetZImageView.getBottom() + j;
      }
    }
    i = (j + paramInt) / 2 - this.jdField_b_of_type_Int / 2;
    if (i == 0) {
      return;
    }
    paramInt = Math.abs(i);
    j = Math.abs(this.jdField_c_of_type_Int);
    if (j == 0) {
      paramInt = 400;
    } else {
      paramInt /= j;
    }
    this.jdField_b_of_type_Boolean = true;
    ((IImageManager)QRoute.api(IImageManager.class)).pauseDownload();
    post(new PublicAccountImageCollectionListView.1(this, i, paramInt));
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("preloadImg start:");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append(" count:");
      ((StringBuilder)localObject).append(paramInt2);
      QLog.d("PublicAccountImageCollectionListView", 2, ((StringBuilder)localObject).toString());
    }
    if (this.jdField_b_of_type_JavaUtilArrayList == null) {
      return;
    }
    long l = System.currentTimeMillis();
    if (!NetworkUtil.isWifiConnected(this.jdField_a_of_type_AndroidContentContext)) {
      return;
    }
    Object localObject = new ArrayList(this.jdField_b_of_type_JavaUtilArrayList);
    ThreadManager.post(new PublicAccountImageCollectionListView.2(this, this.jdField_a_of_type_Long, (List)localObject, paramInt1, paramInt2, l), 5, null, true);
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    if (!((IPublicAccountImageCollectionPreloadManager)QRoute.api(IPublicAccountImageCollectionPreloadManager.class)).canPreload()) {
      return;
    }
    ((IPublicAccountImageCollectionPreloadManager)QRoute.api(IPublicAccountImageCollectionPreloadManager.class)).cancelNotDownloadTask();
    ArrayList localArrayList = this.jdField_c_of_type_JavaUtilArrayList;
    if (localArrayList != null)
    {
      int j = localArrayList.size();
      int i = 0;
      while (i < j)
      {
        ((IPublicAccountImageCollectionPreloadManager)QRoute.api(IPublicAccountImageCollectionPreloadManager.class)).addTask(((IPublicAccountImageCollectionUtils.RecommendItemInfo)this.jdField_c_of_type_JavaUtilArrayList.get(i)).d);
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
    return Boolean.valueOf(a().equals(paramView));
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
    if ((paramView != null) && (paramView.getTag() != null))
    {
      VideoFeedsAlphaMaskView localVideoFeedsAlphaMaskView;
      if ((paramView.getTag() instanceof PublicAccountImageCollectionAdapter.ImageItemHolder)) {
        localVideoFeedsAlphaMaskView = ((PublicAccountImageCollectionAdapter.ImageItemHolder)paramView.getTag()).jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetVideoFeedsAlphaMaskView;
      } else if ((paramView.getTag() instanceof PublicAccountImageCollectionAdapter.CoverHolder)) {
        localVideoFeedsAlphaMaskView = ((PublicAccountImageCollectionAdapter.CoverHolder)paramView.getTag()).jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetVideoFeedsAlphaMaskView;
      } else if ((paramView.getTag() instanceof PublicAccountImageCollectionRecommendViewWrapper.RecommendHolder)) {
        localVideoFeedsAlphaMaskView = ((PublicAccountImageCollectionRecommendViewWrapper.RecommendHolder)paramView.getTag()).jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetVideoFeedsAlphaMaskView;
      } else {
        localVideoFeedsAlphaMaskView = null;
      }
      int i = Math.abs((paramView.getBottom() + paramView.getTop()) / 2 - this.jdField_b_of_type_Int / 2);
      int j = (paramView.getBottom() - paramView.getTop()) / 2;
      float f2 = Math.round(i / j * 100.0F) / 100.0F;
      float f1 = f2;
      if (f2 > 1.0F) {
        f1 = 1.0F;
      }
      if (localVideoFeedsAlphaMaskView != null) {
        localVideoFeedsAlphaMaskView.setAlpha(f1);
      }
    }
  }
  
  public void a(PublicAccountImageCollectionListView.ListViewEventListener paramListViewEventListener)
  {
    this.jdField_a_of_type_JavaUtilArrayList.add(paramListViewEventListener);
  }
  
  void b()
  {
    int i = getFirstVisiblePosition();
    while (i <= getLastVisiblePosition())
    {
      ViewGroup localViewGroup = (ViewGroup)getChildAt(i - getFirstVisiblePosition());
      if ((localViewGroup.getTop() < this.jdField_b_of_type_Int / 2) && (localViewGroup.getBottom() > this.jdField_b_of_type_Int / 2))
      {
        if ((localViewGroup.getTag() instanceof PublicAccountImageCollectionRecommendViewWrapper.RecommendHolder))
        {
          localViewGroup.setClickable(false);
          localViewGroup.getChildAt(0).setClickable(true);
          localViewGroup.getChildAt(0).setFocusable(true);
          localViewGroup.getChildAt(0).setEnabled(true);
        }
        if ((localViewGroup.getTag() instanceof PublicAccountImageCollectionAdapter.ImageItemHolder))
        {
          localViewGroup.setClickable(false);
          localViewGroup.getChildAt(1).setClickable(true);
          localViewGroup.getChildAt(1).setFocusable(true);
          localViewGroup.getChildAt(1).setEnabled(true);
        }
      }
      else
      {
        if ((localViewGroup.getTag() instanceof PublicAccountImageCollectionRecommendViewWrapper.RecommendHolder))
        {
          localViewGroup.setClickable(true);
          localViewGroup.getChildAt(0).setClickable(false);
          localViewGroup.getChildAt(0).setFocusable(false);
          localViewGroup.getChildAt(0).setEnabled(false);
        }
        if ((localViewGroup.getTag() instanceof PublicAccountImageCollectionAdapter.ImageItemHolder))
        {
          localViewGroup.setClickable(true);
          localViewGroup.getChildAt(1).setClickable(false);
          localViewGroup.getChildAt(1).setFocusable(false);
          localViewGroup.getChildAt(1).setEnabled(false);
        }
      }
      i += 1;
    }
  }
  
  public void c()
  {
    Object localObject = this.jdField_a_of_type_JavaUtilArrayList;
    if (localObject != null)
    {
      ((ArrayList)localObject).clear();
      this.jdField_a_of_type_JavaUtilArrayList = null;
    }
    localObject = this.jdField_a_of_type_AndroidViewVelocityTracker;
    if (localObject != null)
    {
      ((VelocityTracker)localObject).recycle();
      this.jdField_a_of_type_AndroidViewVelocityTracker = null;
    }
    this.jdField_a_of_type_AndroidContentContext = null;
    ((IImageManager)QRoute.api(IImageManager.class)).clean();
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
    if (paramInt != 0)
    {
      if (paramInt == 2)
      {
        if (this.jdField_b_of_type_Boolean) {
          return;
        }
        if (this.jdField_b_of_type_Float - this.jdField_a_of_type_Float > 0.0F) {
          a(this.jdField_a_of_type_Int - 1);
        } else {
          a(this.jdField_a_of_type_Int + 1);
        }
      }
    }
    else
    {
      if (!this.jdField_b_of_type_Boolean) {
        a(this.jdField_a_of_type_Int);
      }
      this.jdField_b_of_type_Boolean = false;
      localObject1 = a();
      if (this.d)
      {
        Object localObject2 = this.jdField_a_of_type_JavaUtilArrayList;
        if ((localObject2 != null) && (localObject1 != null))
        {
          localObject2 = ((ArrayList)localObject2).iterator();
          while (((Iterator)localObject2).hasNext()) {
            ((PublicAccountImageCollectionListView.ListViewEventListener)((Iterator)localObject2).next()).a(((ViewGroup)localObject1).getTag());
          }
        }
      }
      ((IImageManager)QRoute.api(IImageManager.class)).resume();
      int i = getLastVisiblePosition();
      int j = getFirstVisiblePosition();
      int k = ((IPublicAccountImageCollectionPreloadManager)QRoute.api(IPublicAccountImageCollectionPreloadManager.class)).getPreloadImageCount();
      a(getFirstVisiblePosition(), i - j + 1 + k);
      if ((getChildAt(paramAbsListView.getLastVisiblePosition() - getFirstVisiblePosition()).getTag() instanceof PublicAccountImageCollectionRecommendViewWrapper.RecommendHolder)) {
        d();
      }
      b();
    }
    Object localObject1 = this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener;
    if (localObject1 != null) {
      ((AbsListView.OnScrollListener)localObject1).onScrollStateChanged(paramAbsListView, paramInt);
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
    else if (paramMotionEvent.getAction() == 2)
    {
      this.jdField_a_of_type_AndroidViewVelocityTracker.computeCurrentVelocity(1);
      this.jdField_c_of_type_Int = ((int)this.jdField_a_of_type_AndroidViewVelocityTracker.getYVelocity());
      if (this.jdField_c_of_type_Boolean) {
        return true;
      }
      View localView = getChildAt(this.jdField_a_of_type_Int - getFirstVisiblePosition());
      if (localView != null)
      {
        double d1 = localView.getHeight();
        Double.isNaN(d1);
        int i = (int)(d1 * 0.8D);
        if (Math.abs(paramMotionEvent.getY() - this.jdField_a_of_type_Float) >= i)
        {
          if (paramMotionEvent.getY() - this.jdField_a_of_type_Float > 0.0F)
          {
            this.jdField_c_of_type_Boolean = true;
            a(this.jdField_a_of_type_Int - 1);
            return true;
          }
          if (paramMotionEvent.getY() - this.jdField_a_of_type_Float < 0.0F)
          {
            this.jdField_c_of_type_Boolean = true;
            a(this.jdField_a_of_type_Int + 1);
            return true;
          }
        }
      }
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setPhotoCollectionInfo(ArrayList<IPublicAccountImageCollectionUtils.PhotoItemInfo> paramArrayList)
  {
    this.jdField_b_of_type_JavaUtilArrayList = paramArrayList;
    a(1, 1);
  }
  
  public void setRecommendInfo(ArrayList<IPublicAccountImageCollectionUtils.RecommendItemInfo> paramArrayList)
  {
    this.jdField_c_of_type_JavaUtilArrayList = paramArrayList;
  }
  
  public void setScreenHeight(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.imagecollection.PublicAccountImageCollectionListView
 * JD-Core Version:    0.7.0.1
 */