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
  int a;
  boolean b = false;
  private ArrayList<PublicAccountImageCollectionListView.ListViewEventListener> c = new ArrayList();
  private Context d;
  private int e;
  private AbsListView.OnScrollListener f = null;
  private float g;
  private float h;
  private boolean i = false;
  private boolean j = false;
  private boolean k = false;
  private VelocityTracker l;
  private int m = 0;
  private ArrayList<IPublicAccountImageCollectionUtils.PhotoItemInfo> n = null;
  private ArrayList<IPublicAccountImageCollectionUtils.RecommendItemInfo> o = null;
  private long p = 0L;
  
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
    if (paramInt != getCenterChildPosition()) {
      this.k = true;
    }
    int i2 = ((View)localObject).getTop();
    int i1 = ((View)localObject).getBottom();
    paramInt = i1;
    if ((((View)localObject).getTag() instanceof PublicAccountImageCollectionAdapter.ImageItemHolder))
    {
      localObject = (PublicAccountImageCollectionAdapter.ImageItemHolder)((View)localObject).getTag();
      paramInt = i1;
      if (((PublicAccountImageCollectionAdapter.ImageItemHolder)localObject).b.getBottom() != ((PublicAccountImageCollectionAdapter.ImageItemHolder)localObject).c.getBottom()) {
        paramInt = ((PublicAccountImageCollectionAdapter.ImageItemHolder)localObject).c.getBottom() + i2;
      }
    }
    i1 = (i2 + paramInt) / 2 - this.e / 2;
    if (i1 == 0) {
      return;
    }
    paramInt = Math.abs(i1);
    i2 = Math.abs(this.m);
    if (i2 == 0) {
      paramInt = 400;
    } else {
      paramInt /= i2;
    }
    this.i = true;
    ((IImageManager)QRoute.api(IImageManager.class)).pauseDownload();
    post(new PublicAccountImageCollectionListView.1(this, i1, paramInt));
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
    if (this.n == null) {
      return;
    }
    long l1 = System.currentTimeMillis();
    if (!NetworkUtil.isWifiConnected(this.d)) {
      return;
    }
    Object localObject = new ArrayList(this.n);
    ThreadManager.post(new PublicAccountImageCollectionListView.2(this, this.p, (List)localObject, paramInt1, paramInt2, l1), 5, null, true);
  }
  
  private void d()
  {
    if (this.b) {
      return;
    }
    if (!((IPublicAccountImageCollectionPreloadManager)QRoute.api(IPublicAccountImageCollectionPreloadManager.class)).canPreload()) {
      return;
    }
    ((IPublicAccountImageCollectionPreloadManager)QRoute.api(IPublicAccountImageCollectionPreloadManager.class)).cancelNotDownloadTask();
    ArrayList localArrayList = this.o;
    if (localArrayList != null)
    {
      int i2 = localArrayList.size();
      int i1 = 0;
      while (i1 < i2)
      {
        ((IPublicAccountImageCollectionPreloadManager)QRoute.api(IPublicAccountImageCollectionPreloadManager.class)).addTask(((IPublicAccountImageCollectionUtils.RecommendItemInfo)this.o.get(i1)).d);
        i1 += 1;
      }
    }
    this.b = true;
  }
  
  private int getCenterChildPosition()
  {
    int i1 = getFirstVisiblePosition();
    while (i1 <= getLastVisiblePosition())
    {
      int i2 = getChildAt(i1 - getFirstVisiblePosition()).getTop();
      int i3 = getChildAt(i1 - getFirstVisiblePosition()).getBottom();
      int i4 = this.e;
      if ((i2 < i4 / 2) && (i3 > i4 / 2)) {
        return i1;
      }
      i1 += 1;
    }
    return -1;
  }
  
  public void a()
  {
    a(this.a);
  }
  
  void a(Context paramContext)
  {
    this.d = paramContext;
    this.l = VelocityTracker.obtain();
    super.setOnScrollListener(this);
  }
  
  void a(View paramView)
  {
    if ((paramView != null) && (paramView.getTag() != null))
    {
      VideoFeedsAlphaMaskView localVideoFeedsAlphaMaskView;
      if ((paramView.getTag() instanceof PublicAccountImageCollectionAdapter.ImageItemHolder)) {
        localVideoFeedsAlphaMaskView = ((PublicAccountImageCollectionAdapter.ImageItemHolder)paramView.getTag()).e;
      } else if ((paramView.getTag() instanceof PublicAccountImageCollectionAdapter.CoverHolder)) {
        localVideoFeedsAlphaMaskView = ((PublicAccountImageCollectionAdapter.CoverHolder)paramView.getTag()).j;
      } else if ((paramView.getTag() instanceof PublicAccountImageCollectionRecommendViewWrapper.RecommendHolder)) {
        localVideoFeedsAlphaMaskView = ((PublicAccountImageCollectionRecommendViewWrapper.RecommendHolder)paramView.getTag()).b;
      } else {
        localVideoFeedsAlphaMaskView = null;
      }
      int i1 = Math.abs((paramView.getBottom() + paramView.getTop()) / 2 - this.e / 2);
      int i2 = (paramView.getBottom() - paramView.getTop()) / 2;
      float f2 = Math.round(i1 / i2 * 100.0F) / 100.0F;
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
    this.c.add(paramListViewEventListener);
  }
  
  public Boolean b(View paramView)
  {
    return Boolean.valueOf(getCenterView().equals(paramView));
  }
  
  void b()
  {
    int i1 = getFirstVisiblePosition();
    while (i1 <= getLastVisiblePosition())
    {
      ViewGroup localViewGroup = (ViewGroup)getChildAt(i1 - getFirstVisiblePosition());
      if ((localViewGroup.getTop() < this.e / 2) && (localViewGroup.getBottom() > this.e / 2))
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
      i1 += 1;
    }
  }
  
  public void c()
  {
    Object localObject = this.c;
    if (localObject != null)
    {
      ((ArrayList)localObject).clear();
      this.c = null;
    }
    localObject = this.l;
    if (localObject != null)
    {
      ((VelocityTracker)localObject).recycle();
      this.l = null;
    }
    this.d = null;
    ((IImageManager)QRoute.api(IImageManager.class)).clean();
  }
  
  public ViewGroup getCenterView()
  {
    return (ViewGroup)getChildAt(getCenterChildPosition() - getFirstVisiblePosition());
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.i) {
      return true;
    }
    if (paramMotionEvent.getAction() == 0)
    {
      this.k = false;
      this.j = false;
      this.g = paramMotionEvent.getY();
      this.a = getCenterChildPosition();
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
        if (this.i) {
          return;
        }
        if (this.h - this.g > 0.0F) {
          a(this.a - 1);
        } else {
          a(this.a + 1);
        }
      }
    }
    else
    {
      if (!this.i) {
        a(this.a);
      }
      this.i = false;
      localObject1 = getCenterView();
      if (this.k)
      {
        Object localObject2 = this.c;
        if ((localObject2 != null) && (localObject1 != null))
        {
          localObject2 = ((ArrayList)localObject2).iterator();
          while (((Iterator)localObject2).hasNext()) {
            ((PublicAccountImageCollectionListView.ListViewEventListener)((Iterator)localObject2).next()).a(((ViewGroup)localObject1).getTag());
          }
        }
      }
      ((IImageManager)QRoute.api(IImageManager.class)).resume();
      int i1 = getLastVisiblePosition();
      int i2 = getFirstVisiblePosition();
      int i3 = ((IPublicAccountImageCollectionPreloadManager)QRoute.api(IPublicAccountImageCollectionPreloadManager.class)).getPreloadImageCount();
      a(getFirstVisiblePosition(), i1 - i2 + 1 + i3);
      if ((getChildAt(paramAbsListView.getLastVisiblePosition() - getFirstVisiblePosition()).getTag() instanceof PublicAccountImageCollectionRecommendViewWrapper.RecommendHolder)) {
        d();
      }
      b();
    }
    Object localObject1 = this.f;
    if (localObject1 != null) {
      ((AbsListView.OnScrollListener)localObject1).onScrollStateChanged(paramAbsListView, paramInt);
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.i) {
      return true;
    }
    if (this.l == null) {
      this.l = VelocityTracker.obtain();
    }
    this.l.addMovement(paramMotionEvent);
    if (paramMotionEvent.getAction() == 1)
    {
      this.h = paramMotionEvent.getY();
      this.l.clear();
    }
    else if (paramMotionEvent.getAction() == 2)
    {
      this.l.computeCurrentVelocity(1);
      this.m = ((int)this.l.getYVelocity());
      if (this.j) {
        return true;
      }
      View localView = getChildAt(this.a - getFirstVisiblePosition());
      if (localView != null)
      {
        double d1 = localView.getHeight();
        Double.isNaN(d1);
        int i1 = (int)(d1 * 0.8D);
        if (Math.abs(paramMotionEvent.getY() - this.g) >= i1)
        {
          if (paramMotionEvent.getY() - this.g > 0.0F)
          {
            this.j = true;
            a(this.a - 1);
            return true;
          }
          if (paramMotionEvent.getY() - this.g < 0.0F)
          {
            this.j = true;
            a(this.a + 1);
            return true;
          }
        }
      }
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setPhotoCollectionInfo(ArrayList<IPublicAccountImageCollectionUtils.PhotoItemInfo> paramArrayList)
  {
    this.n = paramArrayList;
    a(1, 1);
  }
  
  public void setRecommendInfo(ArrayList<IPublicAccountImageCollectionUtils.RecommendItemInfo> paramArrayList)
  {
    this.o = paramArrayList;
  }
  
  public void setScreenHeight(int paramInt)
  {
    this.e = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.imagecollection.PublicAccountImageCollectionListView
 * JD-Core Version:    0.7.0.1
 */