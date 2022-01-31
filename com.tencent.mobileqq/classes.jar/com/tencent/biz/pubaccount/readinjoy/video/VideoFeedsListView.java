package com.tencent.biz.pubaccount.readinjoy.video;

import actj;
import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.OrientationEventListener;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ListAdapter;
import android.widget.RelativeLayout.LayoutParams;
import bfos;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import qma;
import qmd;
import qmf;
import qoi;
import qpx;
import qpy;
import qpz;
import qqa;
import zzz;

public class VideoFeedsListView
  extends ListView
  implements bfos
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private Context jdField_a_of_type_AndroidContentContext;
  private OrientationEventListener jdField_a_of_type_AndroidViewOrientationEventListener;
  private VelocityTracker jdField_a_of_type_AndroidViewVelocityTracker;
  private View jdField_a_of_type_AndroidViewView;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private bfos jdField_a_of_type_Bfos;
  private ArrayList<qpz> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private HashMap<Integer, Long> jdField_a_of_type_JavaUtilHashMap;
  private qqa jdField_a_of_type_Qqa;
  protected boolean a;
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int;
  private ViewGroup jdField_b_of_type_AndroidViewViewGroup;
  private boolean jdField_b_of_type_Boolean = true;
  private int jdField_c_of_type_Int = 0;
  private ViewGroup jdField_c_of_type_AndroidViewViewGroup;
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int = 0;
  private boolean jdField_d_of_type_Boolean;
  private int jdField_e_of_type_Int = -1;
  private boolean jdField_e_of_type_Boolean = true;
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
  private int jdField_k_of_type_Int = -1;
  private boolean jdField_k_of_type_Boolean;
  private int jdField_l_of_type_Int;
  private boolean jdField_l_of_type_Boolean;
  private boolean m;
  private boolean n;
  private boolean o = true;
  private boolean p;
  private boolean q;
  private boolean r;
  private boolean s;
  private boolean t;
  private boolean u = true;
  private boolean v = true;
  private boolean w = true;
  
  public VideoFeedsListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    paramContext = qoi.b((Activity)this.jdField_a_of_type_AndroidContentContext);
    this.jdField_b_of_type_Int = paramContext[0];
    this.jdField_a_of_type_Int = paramContext[1];
    setOverScrollMode(2);
    c();
    this.jdField_a_of_type_AndroidViewVelocityTracker = VelocityTracker.obtain();
    this.jdField_a_of_type_Qqa = new qqa(this, new Handler());
    this.jdField_a_of_type_Qqa.a();
    this.w = qoi.a(this.jdField_a_of_type_AndroidContentContext);
    super.setOnScrollListener(this);
  }
  
  private int a()
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
  
  private int a(int paramInt)
  {
    return (int)(this.jdField_a_of_type_Int / 2.0F - paramInt / 2.0F - actj.a(2.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
  }
  
  private void a(float paramFloat)
  {
    if (this.t) {}
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
            if (((this.jdField_c_of_type_AndroidViewViewGroup.getTag() instanceof qmd)) && (((qmd)this.jdField_c_of_type_AndroidViewViewGroup.getTag()).jdField_b_of_type_Int == this.jdField_j_of_type_Int))
            {
              localVideoFeedsAlphaMaskView = ((qmd)this.jdField_c_of_type_AndroidViewViewGroup.getTag()).jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAlphaMaskView;
              if (localVideoFeedsAlphaMaskView != null) {
                localVideoFeedsAlphaMaskView.setAlpha(paramFloat);
              }
            }
            if ((this.jdField_a_of_type_AndroidViewViewGroup == null) || (!(this.jdField_a_of_type_AndroidViewViewGroup.getTag() instanceof qmd)) || (this.jdField_c_of_type_AndroidViewViewGroup.getTop() <= this.jdField_g_of_type_Int)) {
              break;
            }
          } while (((qmd)this.jdField_a_of_type_AndroidViewViewGroup.getTag()).jdField_b_of_type_Int != this.jdField_j_of_type_Int - 1);
          localVideoFeedsAlphaMaskView = ((qmd)this.jdField_a_of_type_AndroidViewViewGroup.getTag()).jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAlphaMaskView;
        } while (localVideoFeedsAlphaMaskView == null);
        localVideoFeedsAlphaMaskView.setAlpha(1.0F - paramFloat);
        return;
      } while ((this.jdField_b_of_type_AndroidViewViewGroup == null) || (!(this.jdField_b_of_type_AndroidViewViewGroup.getTag() instanceof qmd)) || (((qmd)this.jdField_b_of_type_AndroidViewViewGroup.getTag()).jdField_b_of_type_Int != this.jdField_j_of_type_Int + 1));
      localVideoFeedsAlphaMaskView = ((qmd)this.jdField_b_of_type_AndroidViewViewGroup.getTag()).jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAlphaMaskView;
    } while (localVideoFeedsAlphaMaskView == null);
    localVideoFeedsAlphaMaskView.setAlpha(1.0F - paramFloat);
  }
  
  private void a(int paramInt)
  {
    paramInt = a(paramInt);
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      View localView = this.jdField_a_of_type_AndroidViewView.findViewById(2131363301);
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)localView.getLayoutParams();
      localLayoutParams.height = paramInt;
      localView.setLayoutParams(localLayoutParams);
    }
  }
  
  private void a(int paramInt, boolean paramBoolean)
  {
    b();
    Object localObject1 = this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131367466);
    if (localObject1 != null) {
      ((View)localObject1).setVisibility(8);
    }
    localObject1 = this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131366597);
    if (localObject1 != null) {
      ((View)localObject1).setVisibility(8);
    }
    this.jdField_g_of_type_Boolean = true;
    this.m = false;
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      localObject1 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject1).hasNext()) {
        ((qpz)((Iterator)localObject1).next()).a(this.jdField_c_of_type_AndroidViewViewGroup.getTag(), true);
      }
    }
    localObject1 = (ViewGroup)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131364533);
    if (localObject1 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.pubaccount.video.feeds.VideoFeedsListView", 2, "innerEnterFullScreen() ERROR root == null");
      }
      return;
    }
    Object localObject2 = ((ViewGroup)localObject1).getLayoutParams();
    ((ViewGroup.LayoutParams)localObject2).height = this.jdField_a_of_type_Int;
    ((ViewGroup.LayoutParams)localObject2).width = this.jdField_a_of_type_Int;
    ((ViewGroup)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
    int i1 = 0;
    while (i1 < ((ViewGroup)localObject1).getChildCount())
    {
      localObject2 = ((ViewGroup)localObject1).getChildAt(i1);
      ViewGroup.LayoutParams localLayoutParams = ((View)localObject2).getLayoutParams();
      if ((localLayoutParams.height != -1) || (localLayoutParams.width != -1))
      {
        i1 += 1;
      }
      else
      {
        if (paramInt == 1) {
          ((View)localObject2).setRotation(90.0F);
        }
        for (;;)
        {
          ((View)localObject2).setTranslationX(-(this.jdField_a_of_type_Int - this.jdField_b_of_type_Int) / 2);
          localLayoutParams.height = this.jdField_b_of_type_Int;
          localLayoutParams.width = this.jdField_a_of_type_Int;
          ((View)localObject2).setLayoutParams(localLayoutParams);
          ((View)localObject2).setTranslationY((this.jdField_a_of_type_Int - this.jdField_b_of_type_Int) / 2);
          break;
          ((View)localObject2).setRotation(-90.0F);
        }
      }
    }
    localObject2 = this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131364546);
    if (localObject2 != null) {
      ((View)localObject2).setVisibility(8);
    }
    if (this.jdField_d_of_type_Int == 0)
    {
      if (this.jdField_j_of_type_Int != 0) {
        this.jdField_f_of_type_Boolean = true;
      }
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
    Object localObject;
    if (paramView != this.jdField_a_of_type_AndroidViewViewGroup)
    {
      localObject = paramView;
      if (paramView != this.jdField_b_of_type_AndroidViewViewGroup) {}
    }
    else
    {
      this.m = true;
      localObject = paramView;
      if (this.r)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.pubaccount.video.feeds.VideoFeedsListView", 2, "smoothScrollItemToCenter: 极端情况，滚动时数据发生变化，不触发滚动");
        }
        this.r = false;
        localObject = this.jdField_c_of_type_AndroidViewViewGroup;
        this.m = false;
      }
    }
    if (localObject == this.jdField_b_of_type_AndroidViewViewGroup) {
      this.p = false;
    }
    int i2 = (((View)localObject).getTop() + ((View)localObject).getBottom()) / 2 - this.jdField_a_of_type_Int / 2;
    int i4 = Math.abs(i2);
    int i3 = Math.abs(paramInt);
    if (i3 == 0)
    {
      paramInt = 400;
      label132:
      if (i4 <= 1) {
        break label185;
      }
      if (paramInt <= 400) {
        break label187;
      }
      paramInt = i1;
    }
    for (;;)
    {
      if (a(i2, paramInt)) {
        break label204;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.pubaccount.video.feeds.VideoFeedsListView", 2, "smoothScrollItemToCenter: dont need scroll just return");
      }
      this.m = false;
      return;
      paramInt = i4 / i3;
      break label132;
      label185:
      break;
      label187:
      if (paramInt < 150) {
        paramInt = 150;
      }
    }
    label204:
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.feeds.VideoFeedsListView", 2, "scroll distance = " + i2 + "speed = " + i3 + "duration = " + paramInt);
    }
    this.q = true;
    this.jdField_f_of_type_Boolean = true;
    post(new VideoFeedsListView.3(this, i2, paramInt));
  }
  
  private void a(View paramView, boolean paramBoolean)
  {
    paramView = paramView.findViewById(2131364533);
    if (paramBoolean)
    {
      localLayoutParams = paramView.getLayoutParams();
      this.jdField_l_of_type_Int = localLayoutParams.height;
      localLayoutParams.height = qoi.a((Activity)this.jdField_a_of_type_AndroidContentContext);
      paramView.setLayoutParams(localLayoutParams);
      return;
    }
    ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
    localLayoutParams.height = this.jdField_l_of_type_Int;
    paramView.setLayoutParams(localLayoutParams);
  }
  
  private boolean a()
  {
    return (this.jdField_c_of_type_AndroidViewViewGroup != null) && ((this.jdField_c_of_type_AndroidViewViewGroup.getTag() instanceof qma));
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
  
  private boolean a(int paramInt1, int paramInt2)
  {
    paramInt2 = this.mFirstPosition;
    int i1 = getChildCount();
    int i2 = getPaddingTop();
    int i3 = getHeight();
    int i4 = getPaddingBottom();
    return (paramInt1 != 0) && (this.mItemCount != 0) && (getChildCount() != 0) && ((paramInt2 != 0) || (getChildAt(0).getTop() != i2) || (paramInt1 >= 0)) && ((paramInt2 + i1 - 1 != this.mItemCount - 1) || (getChildAt(i1 - 1).getBottom() != i3 - i4) || (paramInt1 <= 0));
  }
  
  private void b(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      View localView = this.jdField_a_of_type_AndroidViewView.findViewById(2131363301);
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)localView.getLayoutParams();
      localLayoutParams.height = paramInt;
      localView.setLayoutParams(localLayoutParams);
    }
  }
  
  private void c()
  {
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    try
    {
      this.jdField_a_of_type_AndroidViewOrientationEventListener = new qpy(this, this.jdField_a_of_type_AndroidContentContext, 3);
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
  
  public void a()
  {
    if (this.q) {
      if (QLog.isColorLevel()) {
        QLog.d("Q.pubaccount.video.feeds.VideoFeedsListView", 2, "smoothScrollToNextItem: scrolling item to center ,just return");
      }
    }
    do
    {
      return;
      if (this.jdField_f_of_type_Boolean)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.pubaccount.video.feeds.VideoFeedsListView", 2, "smoothScrollToNextItem: scrolling ,do scroll when idle");
        }
        this.p = true;
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.pubaccount.video.feeds.VideoFeedsListView", 2, "smoothScrollToNextItem: ");
      }
    } while (this.jdField_b_of_type_AndroidViewViewGroup == null);
    a(this.jdField_b_of_type_AndroidViewViewGroup);
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_g_of_type_Boolean = false;
    this.jdField_d_of_type_Int = 0;
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      localObject1 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject1).hasNext()) {
        ((qpz)((Iterator)localObject1).next()).a(this.jdField_c_of_type_AndroidViewViewGroup.getTag(), false);
      }
    }
    Object localObject1 = this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131367466);
    if (localObject1 != null) {
      ((View)localObject1).setVisibility(0);
    }
    localObject1 = this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131366597);
    if (localObject1 != null) {
      ((View)localObject1).setVisibility(0);
    }
    localObject1 = (ViewGroup)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131364533);
    if (localObject1 == null) {
      if (QLog.isColorLevel()) {
        QLog.d("Q.pubaccount.video.feeds.VideoFeedsListView", 2, "innerExitFullScreen() ERROR root == null");
      }
    }
    do
    {
      return;
      Object localObject2 = ((ViewGroup)localObject1).getLayoutParams();
      ((ViewGroup.LayoutParams)localObject2).height = this.jdField_f_of_type_Int;
      ((ViewGroup.LayoutParams)localObject2).width = this.jdField_b_of_type_Int;
      ((ViewGroup)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      int i1 = 0;
      if (i1 < ((ViewGroup)localObject1).getChildCount())
      {
        localObject2 = ((ViewGroup)localObject1).getChildAt(i1);
        ViewGroup.LayoutParams localLayoutParams = ((View)localObject2).getLayoutParams();
        if ((localLayoutParams.height != this.jdField_b_of_type_Int) || (localLayoutParams.width != this.jdField_a_of_type_Int)) {}
        for (;;)
        {
          i1 += 1;
          break;
          ((View)localObject2).setRotation(0.0F);
          ((View)localObject2).setTranslationX(0.0F);
          localLayoutParams.height = -1;
          localLayoutParams.width = -1;
          ((View)localObject2).setLayoutParams(localLayoutParams);
          ((View)localObject2).setTranslationY(0.0F);
        }
      }
      if (this.jdField_j_of_type_Int != 0) {
        this.jdField_f_of_type_Boolean = true;
      }
      smoothScrollBy(-this.jdField_g_of_type_Int, 0);
      localObject1 = this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131364546);
      if (localObject1 != null) {
        ((View)localObject1).setVisibility(0);
      }
    } while (!paramBoolean);
    localObject1 = new AlphaAnimation(0.0F, 1.0F);
    ((AlphaAnimation)localObject1).setDuration(500L);
    ((AlphaAnimation)localObject1).setFillAfter(true);
    startAnimation((Animation)localObject1);
  }
  
  public void b()
  {
    if (this.jdField_d_of_type_Int != 0) {
      break label7;
    }
    label7:
    while (((this.jdField_g_of_type_Boolean) && (!this.jdField_d_of_type_Boolean)) || (this.t) || (this.s)) {
      return;
    }
    int i1 = a();
    this.jdField_c_of_type_AndroidViewViewGroup = ((ViewGroup)getChildAt(i1));
    this.jdField_b_of_type_AndroidViewViewGroup = ((ViewGroup)getChildAt(i1 + 1));
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)getChildAt(i1 - 1));
    if ((this.jdField_c_of_type_AndroidViewViewGroup != null) && (this.jdField_c_of_type_AndroidViewViewGroup.getTag() != null))
    {
      this.jdField_j_of_type_Int = ((qmd)this.jdField_c_of_type_AndroidViewViewGroup.getTag()).jdField_b_of_type_Int;
      localObject = this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131364533);
      if (localObject == null)
      {
        QLog.e("Q.pubaccount.video.feeds.VideoFeedsListView", 2, "resetVideoInstance: contentView null ！，itemType=" + ((qmd)this.jdField_c_of_type_AndroidViewViewGroup.getTag()).jdField_a_of_type_Int);
        return;
      }
      i1 = Math.abs(((View)localObject).getRight() - ((View)localObject).getLeft());
      int i2 = Math.abs(((View)localObject).getBottom() - ((View)localObject).getTop());
      if (i1 > i2)
      {
        this.jdField_d_of_type_Boolean = true;
        label204:
        this.jdField_f_of_type_Int = i2;
        this.jdField_g_of_type_Int = this.jdField_c_of_type_AndroidViewViewGroup.getTop();
      }
    }
    else
    {
      this.jdField_k_of_type_Boolean = false;
      this.jdField_j_of_type_Boolean = false;
      if (!this.o) {
        break label326;
      }
    }
    label326:
    for (Object localObject = this.jdField_b_of_type_AndroidViewViewGroup;; localObject = this.jdField_c_of_type_AndroidViewViewGroup)
    {
      if ((localObject != null) && (((View)localObject).getTag() != null) && (((qmd)((View)localObject).getTag()).jdField_b_of_type_Int == getAdapter().getCount() - 1 - getHeaderViewsCount() - getFooterViewsCount())) {
        this.jdField_k_of_type_Boolean = true;
      }
      if ((this.jdField_a_of_type_AndroidViewViewGroup == null) || (this.jdField_a_of_type_AndroidViewViewGroup.getId() != 2131374774)) {
        break;
      }
      this.jdField_j_of_type_Boolean = true;
      return;
      this.jdField_d_of_type_Boolean = false;
      break label204;
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if (this.jdField_g_of_type_Boolean) {}
    while (this.jdField_c_of_type_Int == 1) {
      return;
    }
    this.jdField_e_of_type_Int = 1;
    a(1, paramBoolean);
  }
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    if (!this.n)
    {
      this.jdField_c_of_type_AndroidViewViewGroup = ((ViewGroup)getChildAt(1));
      if (this.jdField_c_of_type_AndroidViewViewGroup != null) {}
    }
    do
    {
      do
      {
        return;
        this.jdField_h_of_type_Int = (this.jdField_c_of_type_AndroidViewViewGroup.getBottom() - this.jdField_c_of_type_AndroidViewViewGroup.getTop());
        if (this.t)
        {
          paramCanvas = this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131364533);
          int i1 = Math.abs(paramCanvas.getRight() - paramCanvas.getLeft());
          int i2 = Math.abs(paramCanvas.getBottom() - paramCanvas.getTop());
          if (i1 > i2)
          {
            this.jdField_d_of_type_Boolean = true;
            this.jdField_f_of_type_Int = i2;
            this.jdField_g_of_type_Int = a(this.jdField_h_of_type_Int);
            this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131367466).setVisibility(8);
            b(0);
            a(this.jdField_c_of_type_AndroidViewViewGroup, true);
            this.u = false;
          }
        }
        for (;;)
        {
          this.n = true;
          return;
          this.jdField_d_of_type_Boolean = false;
          break;
          a(this.jdField_c_of_type_AndroidViewViewGroup.getHeight());
        }
        if ((!this.o) && (this.jdField_k_of_type_Boolean))
        {
          b();
          if ((!this.jdField_k_of_type_Boolean) && (!this.jdField_f_of_type_Boolean) && (this.jdField_c_of_type_AndroidViewViewGroup != null) && ((this.jdField_c_of_type_AndroidViewViewGroup.getTag() instanceof qmf)) && (this.jdField_a_of_type_JavaUtilArrayList != null))
          {
            paramCanvas = this.jdField_a_of_type_JavaUtilArrayList.iterator();
            while (paramCanvas.hasNext()) {
              ((qpz)paramCanvas.next()).a(this.jdField_c_of_type_AndroidViewViewGroup.getTag());
            }
          }
        }
      } while (this.jdField_l_of_type_Boolean);
      if (!this.t)
      {
        b();
        this.jdField_g_of_type_Int = a(this.jdField_h_of_type_Int);
      }
    } while ((this.jdField_c_of_type_AndroidViewViewGroup == null) || (!(this.jdField_c_of_type_AndroidViewViewGroup.getTag() instanceof qmf)));
    this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131364546).setAlpha(0.0F);
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      paramCanvas = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (paramCanvas.hasNext()) {
        ((qpz)paramCanvas.next()).a(this.jdField_c_of_type_AndroidViewViewGroup.getTag());
      }
    }
    this.jdField_l_of_type_Boolean = true;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    if (this.jdField_f_of_type_Boolean) {
      return true;
    }
    if (this.jdField_g_of_type_Boolean) {
      return false;
    }
    if (paramMotionEvent.getAction() == 0)
    {
      this.m = false;
      this.jdField_i_of_type_Boolean = false;
      this.jdField_a_of_type_Float = paramMotionEvent.getY();
      this.jdField_h_of_type_Boolean = false;
      b();
    }
    if ((paramMotionEvent.getAction() == 2) && (!this.jdField_h_of_type_Boolean) && (this.jdField_c_of_type_AndroidViewViewGroup != null))
    {
      int i1 = actj.a(25.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      int i2 = ViewConfiguration.getTouchSlop();
      if ((Math.abs(this.jdField_a_of_type_Float - paramMotionEvent.getY()) > i2) && ((this.jdField_a_of_type_Float < i1) || (Math.abs(this.jdField_a_of_type_Int - this.jdField_a_of_type_Float) < i1)))
      {
        this.jdField_h_of_type_Boolean = true;
        return true;
      }
    }
    if ((!this.jdField_b_of_type_Boolean) || (this.t)) {
      return false;
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
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
      if (this.jdField_a_of_type_Bfos != null) {
        this.jdField_a_of_type_Bfos.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
      }
      return;
      label81:
      f1 = f2;
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt == 0)
    {
      zzz.a().a("list_video_feeds", false);
      switch (paramInt)
      {
      default: 
        label40:
        if (this.jdField_a_of_type_Bfos != null) {
          this.jdField_a_of_type_Bfos.onScrollStateChanged(paramAbsListView, paramInt);
        }
        break;
      }
    }
    do
    {
      return;
      zzz.a().a("list_video_feeds");
      break;
      if ((this.jdField_c_of_type_Int == 1) && (!this.jdField_f_of_type_Boolean)) {
        a(this.jdField_c_of_type_AndroidViewViewGroup, this.jdField_i_of_type_Int);
      }
      for (;;)
      {
        this.r = false;
        this.jdField_c_of_type_Int = 0;
        break;
        this.jdField_f_of_type_Boolean = false;
        this.q = false;
        if (this.m) {
          a(1.0F);
        }
        b();
        if (this.m) {
          a(0.0F);
        }
        if ((this.m) && (this.jdField_a_of_type_JavaUtilArrayList != null) && (!this.jdField_g_of_type_Boolean) && (this.jdField_c_of_type_AndroidViewViewGroup != null))
        {
          if (QLog.isColorLevel()) {
            QLog.d("VideoFeedsPlayManager.preplay", 2, "onScrollStateChanged: onCenterViewChanged ");
          }
          Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
          while (localIterator.hasNext()) {
            ((qpz)localIterator.next()).a(this.jdField_c_of_type_AndroidViewViewGroup.getTag());
          }
        }
        if (this.p) {
          a();
        }
      }
      this.jdField_c_of_type_Int = 1;
      break label40;
    } while (this.jdField_f_of_type_Boolean);
    if (this.jdField_b_of_type_Float > this.jdField_a_of_type_Float) {
      if (!this.jdField_j_of_type_Boolean) {
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
        if (!this.jdField_k_of_type_Boolean) {
          a(this.jdField_b_of_type_AndroidViewViewGroup, this.jdField_i_of_type_Int);
        } else {
          a(this.jdField_c_of_type_AndroidViewViewGroup, this.jdField_i_of_type_Int);
        }
      }
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool2 = false;
    boolean bool1;
    if (this.jdField_f_of_type_Boolean) {
      bool1 = true;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (this.jdField_g_of_type_Boolean);
      bool1 = bool2;
    } while (this.jdField_h_of_type_Boolean);
    if (this.jdField_a_of_type_AndroidViewVelocityTracker == null) {
      this.jdField_a_of_type_AndroidViewVelocityTracker = VelocityTracker.obtain();
    }
    this.jdField_a_of_type_AndroidViewVelocityTracker.addMovement(paramMotionEvent);
    if (this.jdField_k_of_type_Int == 6)
    {
      this.jdField_a_of_type_Float = paramMotionEvent.getY();
      this.jdField_k_of_type_Int = paramMotionEvent.getActionMasked();
      return super.onTouchEvent(paramMotionEvent);
    }
    this.jdField_k_of_type_Int = paramMotionEvent.getActionMasked();
    if (paramMotionEvent.getAction() == 1)
    {
      this.jdField_b_of_type_Float = paramMotionEvent.getY();
      if (((this.jdField_a_of_type_Boolean) && (this.jdField_k_of_type_Boolean)) || ((this.jdField_k_of_type_Boolean) && (paramMotionEvent.getY() + 300.0F < this.jdField_a_of_type_Float)))
      {
        if (this.jdField_a_of_type_JavaUtilArrayList != null)
        {
          paramMotionEvent = this.jdField_a_of_type_JavaUtilArrayList.iterator();
          while (paramMotionEvent.hasNext()) {
            ((qpz)paramMotionEvent.next()).a();
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
      if ((this.jdField_j_of_type_Boolean) && (paramMotionEvent.getY() > this.jdField_a_of_type_Float))
      {
        if ((paramMotionEvent.getY() - this.jdField_a_of_type_Float > 300.0F) && (!this.jdField_c_of_type_Boolean))
        {
          this.jdField_c_of_type_Boolean = true;
          if (this.jdField_a_of_type_JavaUtilArrayList != null)
          {
            paramMotionEvent = this.jdField_a_of_type_JavaUtilArrayList.iterator();
            while (paramMotionEvent.hasNext()) {
              ((qpz)paramMotionEvent.next()).b();
            }
          }
        }
        return true;
      }
      i1 = (int)(this.jdField_f_of_type_Int * 0.3D);
      f1 = paramMotionEvent.getY() - this.jdField_a_of_type_Float;
      if ((!this.jdField_a_of_type_Boolean) && (this.jdField_k_of_type_Boolean) && (f1 < 0.0F) && (Math.abs(f1) >= i1)) {
        return true;
      }
      if (this.jdField_i_of_type_Boolean) {
        return true;
      }
      if ((f1 > 0.0F) && (i1 <= f1))
      {
        this.jdField_i_of_type_Boolean = true;
        a(this.jdField_a_of_type_AndroidViewViewGroup, this.jdField_i_of_type_Int);
        return true;
      }
    } while ((f1 >= 0.0F) || (Math.abs(f1) < i1));
    this.jdField_i_of_type_Boolean = true;
    a(this.jdField_b_of_type_AndroidViewViewGroup, this.jdField_i_of_type_Int);
    return true;
  }
  
  public void setAdapter(ListAdapter paramListAdapter)
  {
    super.setAdapter(paramListAdapter);
    getAdapter().registerDataSetObserver(new qpx(this));
  }
  
  public void setIsLastItemAsFooter(boolean paramBoolean)
  {
    this.o = paramBoolean;
  }
  
  public void setIsOrignalVideoFullScreen(boolean paramBoolean)
  {
    this.v = paramBoolean;
  }
  
  public void setIsScrollItemToTop(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.jdField_l_of_type_Boolean) {
      if (!paramBoolean1)
      {
        this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131367466).setVisibility(0);
        if (!this.u)
        {
          this.u = true;
          a(this.jdField_h_of_type_Int);
          a(this.jdField_c_of_type_AndroidViewViewGroup, false);
          this.t = false;
        }
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.pubaccount.video.feeds.VideoFeedsListView", 2, "setIsScrollItemToTop isScrollItemToTop=" + paramBoolean1 + ", needDurationWhenScrollToTop=" + paramBoolean2 + ", mFirstDrawCompleted=" + this.jdField_l_of_type_Boolean + ", mIsHeaderHeightSetted=" + this.u + ", mIsNeedRecoveryScrollItemToTop=" + this.s + ", mCenterViewHeight=" + this.jdField_h_of_type_Int + ", mContentViewHeightBefore=" + this.jdField_l_of_type_Int);
      }
      if (this.jdField_a_of_type_JavaUtilArrayList == null) {
        return;
      }
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext()) {
        ((qpz)localIterator.next()).a(paramBoolean1);
      }
      this.jdField_a_of_type_AndroidViewViewGroup = null;
      this.jdField_b_of_type_AndroidViewViewGroup = null;
      this.jdField_f_of_type_Boolean = true;
      if (this.s)
      {
        smoothScrollBy(-this.jdField_g_of_type_Int, 0);
        break;
      }
      smoothScrollBy(-this.jdField_g_of_type_Int, 500);
      break;
      this.t = true;
      this.jdField_h_of_type_Int = (this.jdField_c_of_type_AndroidViewViewGroup.getBottom() - this.jdField_c_of_type_AndroidViewViewGroup.getTop());
      this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131367466).setVisibility(8);
      this.jdField_f_of_type_Boolean = true;
      if (paramBoolean2) {
        smoothScrollBy(this.jdField_g_of_type_Int, 500);
      }
      for (;;)
      {
        a(this.jdField_c_of_type_AndroidViewViewGroup, true);
        break;
        smoothScrollBy(this.jdField_g_of_type_Int, 0);
      }
      this.t = paramBoolean1;
    }
  }
  
  public void setNeedDetectScreenOrientation(boolean paramBoolean)
  {
    this.jdField_e_of_type_Boolean = paramBoolean;
  }
  
  public void setOnScrollListener(bfos parambfos)
  {
    this.jdField_a_of_type_Bfos = parambfos;
  }
  
  public void setScrollable(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsListView
 * JD-Core Version:    0.7.0.1
 */