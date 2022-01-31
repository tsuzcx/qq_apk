package com.tencent.biz.pubaccount.readinjoy.view.fastweb.video;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.OrientationEventListener;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAdapter.VideoItemHolder;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAlphaMaskView;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsGradientMaskView;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsHelper;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.VersionUtils;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import mok;
import mol;
import mom;
import mon;
import moo;
import mop;
import moq;
import mor;
import mos;

public class FastWebVideoFeedsListView
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
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private AbsListView.OnScrollListener jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener;
  private ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private HashMap jdField_a_of_type_JavaUtilHashMap;
  private boolean jdField_a_of_type_Boolean = true;
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int;
  private ViewGroup jdField_b_of_type_AndroidViewViewGroup;
  private ArrayList jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  private HashMap jdField_b_of_type_JavaUtilHashMap = new HashMap();
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
  private boolean k;
  private boolean l;
  private boolean m;
  
  @TargetApi(9)
  public FastWebVideoFeedsListView(Context paramContext, Activity paramActivity)
  {
    super(paramContext);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    paramContext = VideoFeedsHelper.a(this.jdField_a_of_type_AndroidAppActivity);
    this.jdField_b_of_type_Int = paramContext[0];
    this.jdField_a_of_type_Int = paramContext[1];
    if (VersionUtils.c()) {
      setOverScrollMode(2);
    }
    h();
    this.jdField_a_of_type_AndroidViewVelocityTracker = VelocityTracker.obtain();
    super.setOnScrollListener(this);
  }
  
  private int a()
  {
    int i1 = getLastVisiblePosition();
    int i2 = getFirstVisiblePosition();
    int n = 0;
    while (n <= i1 - i2)
    {
      int i3 = getChildAt(n).getTop();
      int i4 = getChildAt(n).getBottom();
      if ((i3 < this.jdField_a_of_type_Int / 2) && (i4 > this.jdField_a_of_type_Int / 2)) {
        return n;
      }
      n += 1;
    }
    return -1;
  }
  
  @TargetApi(11)
  private void a(float paramFloat)
  {
    VideoFeedsAlphaMaskView localVideoFeedsAlphaMaskView;
    if (this.jdField_c_of_type_AndroidViewViewGroup != null) {
      if (VersionUtils.e())
      {
        if (((this.jdField_c_of_type_AndroidViewViewGroup.getTag() instanceof FastWebVideoFeedsAdapter.BaseItemHolder)) && (((FastWebVideoFeedsAdapter.BaseItemHolder)this.jdField_c_of_type_AndroidViewViewGroup.getTag()).jdField_a_of_type_Int == this.jdField_j_of_type_Int))
        {
          localVideoFeedsAlphaMaskView = ((FastWebVideoFeedsAdapter.BaseItemHolder)this.jdField_c_of_type_AndroidViewViewGroup.getTag()).jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAlphaMaskView;
          if (localVideoFeedsAlphaMaskView != null) {
            localVideoFeedsAlphaMaskView.setAlpha(paramFloat);
          }
        }
        if ((this.jdField_a_of_type_AndroidViewViewGroup == null) || (!(this.jdField_a_of_type_AndroidViewViewGroup.getTag() instanceof FastWebVideoFeedsAdapter.BaseItemHolder)) || (this.jdField_c_of_type_AndroidViewViewGroup.getTop() <= this.jdField_g_of_type_Int)) {
          break label262;
        }
        if (((FastWebVideoFeedsAdapter.BaseItemHolder)this.jdField_a_of_type_AndroidViewViewGroup.getTag()).jdField_a_of_type_Int == this.jdField_j_of_type_Int - 1)
        {
          localVideoFeedsAlphaMaskView = ((FastWebVideoFeedsAdapter.BaseItemHolder)this.jdField_a_of_type_AndroidViewViewGroup.getTag()).jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAlphaMaskView;
          if (localVideoFeedsAlphaMaskView != null) {
            localVideoFeedsAlphaMaskView.setAlpha(1.0F - paramFloat);
          }
        }
      }
    }
    for (;;)
    {
      if (((this.jdField_c_of_type_AndroidViewViewGroup.getTag() instanceof FastWebVideoFeedsAdapter.BaseItemHolder)) && (((FastWebVideoFeedsAdapter.BaseItemHolder)this.jdField_c_of_type_AndroidViewViewGroup.getTag()).jdField_a_of_type_Int == this.jdField_j_of_type_Int)) {
        a(((FastWebVideoFeedsAdapter.BaseItemHolder)this.jdField_c_of_type_AndroidViewViewGroup.getTag()).jdField_a_of_type_AndroidWidgetLinearLayout, paramFloat);
      }
      if ((this.jdField_b_of_type_AndroidViewViewGroup != null) && ((this.jdField_b_of_type_AndroidViewViewGroup.getTag() instanceof FastWebVideoFeedsAdapter.BaseItemHolder)) && (((FastWebVideoFeedsAdapter.BaseItemHolder)this.jdField_b_of_type_AndroidViewViewGroup.getTag()).jdField_a_of_type_Int == this.jdField_j_of_type_Int + 1)) {
        a(((FastWebVideoFeedsAdapter.BaseItemHolder)this.jdField_b_of_type_AndroidViewViewGroup.getTag()).c, paramFloat);
      }
      return;
      label262:
      if ((this.jdField_b_of_type_AndroidViewViewGroup != null) && ((this.jdField_b_of_type_AndroidViewViewGroup.getTag() instanceof FastWebVideoFeedsAdapter.BaseItemHolder)) && (((FastWebVideoFeedsAdapter.BaseItemHolder)this.jdField_b_of_type_AndroidViewViewGroup.getTag()).jdField_a_of_type_Int == this.jdField_j_of_type_Int + 1))
      {
        localVideoFeedsAlphaMaskView = ((FastWebVideoFeedsAdapter.BaseItemHolder)this.jdField_b_of_type_AndroidViewViewGroup.getTag()).jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAlphaMaskView;
        if (localVideoFeedsAlphaMaskView != null) {
          localVideoFeedsAlphaMaskView.setAlpha(1.0F - paramFloat);
        }
      }
    }
  }
  
  private void a(View paramView)
  {
    a(paramView, 0);
  }
  
  private void a(View paramView, int paramInt)
  {
    int n = 400;
    if (paramView == null) {
      return;
    }
    if ((paramView == this.jdField_a_of_type_AndroidViewViewGroup) || (paramView == this.jdField_b_of_type_AndroidViewViewGroup)) {
      this.l = true;
    }
    int i1 = (paramView.getTop() + paramView.getBottom()) / 2 - this.jdField_a_of_type_Int / 2;
    int i2 = Math.abs(i1);
    int i3 = Math.abs(paramInt);
    if (i3 == 0)
    {
      paramInt = 400;
      label72:
      if (i2 <= 1) {
        break label167;
      }
      if (paramInt <= 400) {
        break label169;
      }
      paramInt = n;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.pubaccount.video.feeds.FastWebVideoFeedsListView", 2, "scroll distance = " + i2 + "speed = " + i3 + "duration = " + paramInt);
      }
      this.jdField_e_of_type_Boolean = true;
      post(new mom(this, i1, paramInt));
      return;
      paramInt = i2 / i3;
      break label72;
      label167:
      break;
      label169:
      if (paramInt < 150) {
        paramInt = 150;
      }
    }
  }
  
  @TargetApi(11)
  private void a(ViewGroup paramViewGroup, float paramFloat)
  {
    if (this.jdField_b_of_type_JavaUtilHashMap.size() == 0)
    {
      this.jdField_b_of_type_JavaUtilHashMap.put(Integer.valueOf(2131367187), Integer.valueOf(230));
      this.jdField_b_of_type_JavaUtilHashMap.put(Integer.valueOf(2131367190), Integer.valueOf(179));
      this.jdField_b_of_type_JavaUtilHashMap.put(Integer.valueOf(2131367203), Integer.valueOf(255));
      this.jdField_b_of_type_JavaUtilHashMap.put(Integer.valueOf(2131367193), Integer.valueOf(128));
      this.jdField_b_of_type_JavaUtilHashMap.put(Integer.valueOf(2131367212), Integer.valueOf(179));
    }
    int i1 = (int)(255.0F * (1.0F - paramFloat));
    int i2 = paramViewGroup.getChildCount();
    int n = 0;
    if (n < i2)
    {
      View localView = paramViewGroup.getChildAt(n);
      if ((localView instanceof VideoFeedsGradientMaskView)) {
        ((VideoFeedsGradientMaskView)localView).setAlpha(i1);
      }
      for (;;)
      {
        n += 1;
        break;
        int i3;
        int i4;
        if (((localView instanceof Button)) && (this.jdField_b_of_type_JavaUtilHashMap.containsKey(Integer.valueOf(localView.getId()))))
        {
          i3 = (int)(((Integer)this.jdField_b_of_type_JavaUtilHashMap.get(Integer.valueOf(localView.getId()))).intValue() * (1.0F - paramFloat));
          i4 = ((TextView)localView).getCurrentTextColor();
          ((Button)localView).setTextColor(i3 << 24 | i4 & 0xFFFFFF);
          ((Button)localView).getBackground().mutate().setAlpha(i1);
        }
        else if ((localView instanceof ViewGroup))
        {
          a((ViewGroup)localView, paramFloat);
        }
        else if (((localView instanceof TextView)) && (this.jdField_b_of_type_JavaUtilHashMap.containsKey(Integer.valueOf(localView.getId()))))
        {
          i3 = (int)(((Integer)this.jdField_b_of_type_JavaUtilHashMap.get(Integer.valueOf(localView.getId()))).intValue() * (1.0F - paramFloat));
          i4 = ((TextView)localView).getCurrentTextColor();
          ((TextView)localView).setTextColor(i4 & 0xFFFFFF | i3 << 24);
        }
        else if ((localView instanceof ImageView))
        {
          VideoFeedsHelper.a((ImageView)localView, i1);
        }
      }
    }
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
  
  private boolean a(View paramView, float paramFloat1, float paramFloat2)
  {
    if (paramView == null) {}
    int n;
    int i1;
    int i2;
    int i3;
    do
    {
      return false;
      int[] arrayOfInt = new int[2];
      paramView.getLocationOnScreen(arrayOfInt);
      n = arrayOfInt[0];
      i1 = arrayOfInt[1];
      i2 = paramView.getMeasuredWidth();
      i3 = paramView.getMeasuredHeight();
    } while ((i1 > paramFloat2) || (paramFloat2 > i3 + i1) || (n > paramFloat1) || (paramFloat1 > i2 + n));
    return true;
  }
  
  @TargetApi(11)
  private void c(int paramInt)
  {
    if (!VersionUtils.e()) {
      return;
    }
    this.jdField_f_of_type_Boolean = true;
    this.l = false;
    i();
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((FastWebVideoFeedsListView.ListViewEventListener)((Iterator)localObject).next()).a(this.jdField_c_of_type_AndroidViewViewGroup.getTag(), true);
      }
    }
    if (!this.jdField_c_of_type_Boolean)
    {
      localObject = this.jdField_c_of_type_AndroidViewViewGroup.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject).height = this.jdField_a_of_type_Int;
      ((ViewGroup.LayoutParams)localObject).width = this.jdField_b_of_type_Int;
      this.jdField_c_of_type_AndroidViewViewGroup.setLayoutParams((ViewGroup.LayoutParams)localObject);
      post(new mop(this, this.jdField_g_of_type_Int));
      localObject = this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131365568);
      if (localObject != null) {
        ((View)localObject).setVisibility(8);
      }
      localObject = new AlphaAnimation(0.0F, 1.0F);
      ((AlphaAnimation)localObject).setDuration(500L);
      ((AlphaAnimation)localObject).setFillAfter(true);
      this.jdField_c_of_type_AndroidViewViewGroup.startAnimation((Animation)localObject);
      return;
    }
    Object localObject = this.jdField_c_of_type_AndroidViewViewGroup.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject).height = this.jdField_a_of_type_Int;
    ((ViewGroup.LayoutParams)localObject).width = this.jdField_a_of_type_Int;
    this.jdField_c_of_type_AndroidViewViewGroup.setLayoutParams((ViewGroup.LayoutParams)localObject);
    int n = 0;
    if (n < this.jdField_c_of_type_AndroidViewViewGroup.getChildCount())
    {
      localObject = this.jdField_c_of_type_AndroidViewViewGroup.getChildAt(n);
      if (((View)localObject).getId() == 2131367197) {}
      while (!VersionUtils.e())
      {
        n += 1;
        break;
      }
      if (paramInt == 1) {
        ((View)localObject).setRotation(90.0F);
      }
      for (;;)
      {
        ((View)localObject).setTranslationX(-(this.jdField_a_of_type_Int - this.jdField_b_of_type_Int) / 2);
        break;
        ((View)localObject).setRotation(-90.0F);
      }
    }
    localObject = this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131365568);
    if (localObject != null) {
      ((View)localObject).setVisibility(8);
    }
    if (this.jdField_d_of_type_Int == 0) {
      post(new moq(this, this.jdField_g_of_type_Int));
    }
    localObject = this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131367148);
    ViewGroup.LayoutParams localLayoutParams;
    if (localObject != null)
    {
      localLayoutParams = ((View)localObject).getLayoutParams();
      localLayoutParams.height = this.jdField_b_of_type_Int;
      localLayoutParams.width = this.jdField_a_of_type_Int;
      ((View)localObject).setLayoutParams(localLayoutParams);
      if (VersionUtils.e()) {
        ((View)localObject).setTranslationY((this.jdField_a_of_type_Int - this.jdField_b_of_type_Int) / 2);
      }
    }
    localObject = this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131366707);
    if (localObject != null)
    {
      localLayoutParams = ((View)localObject).getLayoutParams();
      localLayoutParams.height = this.jdField_b_of_type_Int;
      localLayoutParams.width = this.jdField_a_of_type_Int;
      ((View)localObject).setLayoutParams(localLayoutParams);
      if (VersionUtils.e()) {
        ((View)localObject).setTranslationY((this.jdField_a_of_type_Int - this.jdField_b_of_type_Int) / 2);
      }
    }
    localObject = this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131367143);
    if (localObject != null)
    {
      localLayoutParams = ((View)localObject).getLayoutParams();
      localLayoutParams.height = this.jdField_b_of_type_Int;
      localLayoutParams.width = this.jdField_a_of_type_Int;
      ((View)localObject).setLayoutParams(localLayoutParams);
      if (VersionUtils.e()) {
        ((View)localObject).setTranslationY((this.jdField_a_of_type_Int - this.jdField_b_of_type_Int) / 2);
      }
    }
    localObject = this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131367398);
    if (localObject != null)
    {
      localLayoutParams = ((View)localObject).getLayoutParams();
      localLayoutParams.height = this.jdField_b_of_type_Int;
      localLayoutParams.width = this.jdField_a_of_type_Int;
      ((View)localObject).setLayoutParams(localLayoutParams);
      if (VersionUtils.e()) {
        ((View)localObject).setTranslationY((this.jdField_a_of_type_Int - this.jdField_b_of_type_Int) / 2);
      }
    }
    localObject = new AlphaAnimation(0.0F, 1.0F);
    ((AlphaAnimation)localObject).setDuration(500L);
    ((AlphaAnimation)localObject).setFillAfter(true);
    this.jdField_c_of_type_AndroidViewViewGroup.startAnimation((Animation)localObject);
    this.jdField_d_of_type_Int = paramInt;
  }
  
  private void h()
  {
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    try
    {
      this.jdField_a_of_type_AndroidViewOrientationEventListener = new mok(this, this.jdField_a_of_type_AndroidAppActivity, 3);
      if ((this.jdField_a_of_type_AndroidViewOrientationEventListener != null) && (this.jdField_a_of_type_AndroidViewOrientationEventListener.canDetectOrientation())) {
        this.jdField_a_of_type_AndroidViewOrientationEventListener.enable();
      }
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("Q.pubaccount.video.feeds.FastWebVideoFeedsListView", 2, "initOrientationEventListener() Exception error=" + localException.getMessage());
    }
  }
  
  private void i()
  {
    if (this.jdField_d_of_type_Int != 0) {
      break label7;
    }
    label7:
    while ((this.jdField_f_of_type_Boolean) && (!this.jdField_c_of_type_Boolean)) {
      return;
    }
    int n = a();
    this.jdField_c_of_type_AndroidViewViewGroup = ((ViewGroup)getChildAt(n));
    this.jdField_b_of_type_AndroidViewViewGroup = ((ViewGroup)getChildAt(n + 1));
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)getChildAt(n - 1));
    int i1;
    if ((this.jdField_c_of_type_AndroidViewViewGroup != null) && (this.jdField_c_of_type_AndroidViewViewGroup.getTag() != null))
    {
      this.jdField_j_of_type_Int = ((FastWebVideoFeedsAdapter.BaseItemHolder)this.jdField_c_of_type_AndroidViewViewGroup.getTag()).jdField_a_of_type_Int;
      n = Math.abs(this.jdField_c_of_type_AndroidViewViewGroup.getRight() - this.jdField_c_of_type_AndroidViewViewGroup.getLeft());
      i1 = Math.abs(this.jdField_c_of_type_AndroidViewViewGroup.getBottom() - this.jdField_c_of_type_AndroidViewViewGroup.getTop());
      if (n <= i1) {
        break label260;
      }
    }
    label260:
    for (this.jdField_c_of_type_Boolean = true;; this.jdField_c_of_type_Boolean = false)
    {
      this.jdField_f_of_type_Int = i1;
      this.jdField_g_of_type_Int = this.jdField_c_of_type_AndroidViewViewGroup.getTop();
      this.jdField_j_of_type_Boolean = false;
      this.jdField_i_of_type_Boolean = false;
      if ((this.jdField_b_of_type_AndroidViewViewGroup != null) && (this.jdField_b_of_type_AndroidViewViewGroup.getTag() != null) && (((FastWebVideoFeedsAdapter.BaseItemHolder)this.jdField_b_of_type_AndroidViewViewGroup.getTag()).jdField_a_of_type_Int == getAdapter().getCount() - 1 - getHeaderViewsCount() - getFooterViewsCount())) {
        this.jdField_j_of_type_Boolean = true;
      }
      if ((this.jdField_a_of_type_AndroidViewViewGroup == null) || (this.jdField_a_of_type_AndroidViewViewGroup.getId() != 2131362199)) {
        break;
      }
      this.jdField_i_of_type_Boolean = true;
      return;
    }
  }
  
  public long a()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public void a()
  {
    if (this.jdField_e_of_type_Boolean) {
      postDelayed(new mol(this), 100L);
    }
    while (this.jdField_b_of_type_AndroidViewViewGroup == null) {
      return;
    }
    a(this.jdField_b_of_type_AndroidViewViewGroup);
  }
  
  public void a(int paramInt)
  {
    paramInt = (int)(this.jdField_a_of_type_Int / 2.0F - paramInt / 2.0F - AIOUtils.a(2.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
    ViewGroup localViewGroup = (ViewGroup)LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130969671, null);
    View localView = localViewGroup.findViewById(2131366680);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)localView.getLayoutParams();
    localLayoutParams.height = paramInt;
    localView.setLayoutParams(localLayoutParams);
    localViewGroup.setId(2131362199);
    localViewGroup.setOnClickListener(new mor(this));
    addHeaderView(localViewGroup);
    paramInt = (int)this.jdField_a_of_type_Int;
    localViewGroup = (ViewGroup)LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130969671, null);
    localView = localViewGroup.findViewById(2131366680);
    localLayoutParams = (RelativeLayout.LayoutParams)localView.getLayoutParams();
    localLayoutParams.height = paramInt;
    localView.setLayoutParams(localLayoutParams);
    localViewGroup.setId(2131362200);
    localViewGroup.setOnClickListener(new mos(this));
    addFooterView(localViewGroup);
  }
  
  public void a(FastWebVideoFeedsListView.ListViewEventListener paramListViewEventListener)
  {
    this.jdField_a_of_type_JavaUtilArrayList.add(paramListViewEventListener);
  }
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      if (this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener != null) {
        this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener.a(paramAbsListView, paramInt);
      }
      break;
    }
    do
    {
      return;
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
        i();
        if (this.l) {
          a(0.0F);
        }
        if ((this.l) && (this.jdField_a_of_type_JavaUtilArrayList != null) && (!this.jdField_f_of_type_Boolean) && (this.jdField_c_of_type_AndroidViewViewGroup != null))
        {
          Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
          while (localIterator.hasNext()) {
            ((FastWebVideoFeedsListView.ListViewEventListener)localIterator.next()).a(this.jdField_c_of_type_AndroidViewViewGroup.getTag());
          }
        }
      }
      this.jdField_c_of_type_Int = 1;
      break;
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
      i();
    }
    a();
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_AndroidViewViewGroup != null) {
      a(this.jdField_a_of_type_AndroidViewViewGroup);
    }
  }
  
  public void b(int paramInt)
  {
    if ((this.jdField_b_of_type_JavaUtilArrayList != null) && (!this.jdField_b_of_type_JavaUtilArrayList.contains(Integer.valueOf(paramInt)))) {
      this.jdField_b_of_type_JavaUtilArrayList.add(Integer.valueOf(paramInt));
    }
  }
  
  public void c()
  {
    if (this.jdField_f_of_type_Boolean)
    {
      d();
      return;
    }
    f();
  }
  
  public void d()
  {
    if (!this.jdField_f_of_type_Boolean) {
      return;
    }
    this.jdField_e_of_type_Int = 0;
    e();
  }
  
  @TargetApi(11)
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    if (!this.k)
    {
      i();
      if (this.jdField_c_of_type_AndroidViewViewGroup != null)
      {
        paramCanvas = this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131365568);
        if (VersionUtils.e()) {
          paramCanvas.setAlpha(0.0F);
        }
        if (this.jdField_a_of_type_JavaUtilArrayList != null)
        {
          paramCanvas = this.jdField_a_of_type_JavaUtilArrayList.iterator();
          while (paramCanvas.hasNext()) {
            ((FastWebVideoFeedsListView.ListViewEventListener)paramCanvas.next()).a(this.jdField_c_of_type_AndroidViewViewGroup.getTag());
          }
        }
        this.k = true;
      }
    }
  }
  
  @TargetApi(11)
  public void e()
  {
    if (!VersionUtils.e()) {
      return;
    }
    this.jdField_f_of_type_Boolean = false;
    this.jdField_d_of_type_Int = 0;
    Object localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((FastWebVideoFeedsListView.ListViewEventListener)((Iterator)localObject).next()).a(this.jdField_c_of_type_AndroidViewViewGroup.getTag(), false);
    }
    if (this.jdField_b_of_type_AndroidViewViewGroup != null)
    {
      if (!(this.jdField_b_of_type_AndroidViewViewGroup.getTag() instanceof VideoFeedsAdapter.VideoItemHolder)) {
        break label203;
      }
      VideoFeedsHelper.b((ImageView)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131367144), 0);
    }
    while (!this.jdField_c_of_type_Boolean)
    {
      localObject = this.jdField_c_of_type_AndroidViewViewGroup.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject).height = this.jdField_f_of_type_Int;
      ((ViewGroup.LayoutParams)localObject).width = this.jdField_b_of_type_Int;
      this.jdField_c_of_type_AndroidViewViewGroup.setLayoutParams((ViewGroup.LayoutParams)localObject);
      post(new mon(this, this.jdField_g_of_type_Int));
      localObject = this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131365568);
      if (localObject != null) {
        ((View)localObject).setVisibility(0);
      }
      localObject = new AlphaAnimation(0.0F, 1.0F);
      ((AlphaAnimation)localObject).setDuration(500L);
      ((AlphaAnimation)localObject).setFillAfter(true);
      this.jdField_c_of_type_AndroidViewViewGroup.startAnimation((Animation)localObject);
      return;
      label203:
      if ((this.jdField_b_of_type_AndroidViewViewGroup.getTag() instanceof FastWebVideoFeedsAdapter.ImageItemHolder)) {
        VideoFeedsHelper.b((ImageView)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131367399), 0);
      }
    }
    localObject = this.jdField_c_of_type_AndroidViewViewGroup.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject).height = this.jdField_f_of_type_Int;
    ((ViewGroup.LayoutParams)localObject).width = this.jdField_b_of_type_Int;
    this.jdField_c_of_type_AndroidViewViewGroup.setLayoutParams((ViewGroup.LayoutParams)localObject);
    int n = 0;
    if (n < this.jdField_c_of_type_AndroidViewViewGroup.getChildCount())
    {
      localObject = this.jdField_c_of_type_AndroidViewViewGroup.getChildAt(n);
      if (((View)localObject).getId() == 2131367197) {}
      for (;;)
      {
        n += 1;
        break;
        if (VersionUtils.e())
        {
          ((View)localObject).setRotation(0.0F);
          ((View)localObject).setTranslationX(0.0F);
        }
      }
    }
    post(new moo(this));
    localObject = this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131365568);
    if (localObject != null) {
      ((View)localObject).setVisibility(0);
    }
    localObject = this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131366707);
    ViewGroup.LayoutParams localLayoutParams;
    if (localObject != null)
    {
      localLayoutParams = ((View)localObject).getLayoutParams();
      localLayoutParams.height = -1;
      localLayoutParams.width = -1;
      ((View)localObject).setLayoutParams(localLayoutParams);
      if (VersionUtils.e()) {
        ((View)localObject).setTranslationY(0.0F);
      }
    }
    localObject = this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131367148);
    if (localObject != null)
    {
      localLayoutParams = ((View)localObject).getLayoutParams();
      localLayoutParams.height = -1;
      localLayoutParams.width = -1;
      ((View)localObject).setLayoutParams(localLayoutParams);
      if (VersionUtils.e()) {
        ((View)localObject).setTranslationY(0.0F);
      }
    }
    localObject = this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131367143);
    if (localObject != null)
    {
      localLayoutParams = ((View)localObject).getLayoutParams();
      localLayoutParams.height = -1;
      localLayoutParams.width = -1;
      ((View)localObject).setLayoutParams(localLayoutParams);
      if (VersionUtils.e()) {
        ((View)localObject).setTranslationY(0.0F);
      }
    }
    localObject = this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131367398);
    if (localObject != null)
    {
      localLayoutParams = ((View)localObject).getLayoutParams();
      localLayoutParams.height = -1;
      localLayoutParams.width = -1;
      ((View)localObject).setLayoutParams(localLayoutParams);
      if (VersionUtils.e()) {
        ((View)localObject).setTranslationY(0.0F);
      }
    }
    localObject = new AlphaAnimation(0.0F, 1.0F);
    ((AlphaAnimation)localObject).setDuration(500L);
    ((AlphaAnimation)localObject).setFillAfter(true);
    this.jdField_c_of_type_AndroidViewViewGroup.startAnimation((Animation)localObject);
  }
  
  public void f()
  {
    if (this.jdField_f_of_type_Boolean) {}
    while (this.jdField_c_of_type_Int == 1) {
      return;
    }
    this.jdField_e_of_type_Int = 1;
    c(1);
  }
  
  public void g()
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
      int n = AIOUtils.a(5.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      if ((paramMotionEvent.getY() < n) || (Math.abs(this.jdField_a_of_type_Int - paramMotionEvent.getY()) < n))
      {
        this.jdField_g_of_type_Boolean = true;
        return true;
      }
      this.l = false;
      this.m = false;
      this.jdField_h_of_type_Boolean = false;
      this.jdField_a_of_type_Float = paramMotionEvent.getY();
      this.jdField_g_of_type_Boolean = false;
      i();
      if (this.jdField_c_of_type_AndroidViewViewGroup != null)
      {
        Iterator localIterator = this.jdField_b_of_type_JavaUtilArrayList.iterator();
        while (localIterator.hasNext())
        {
          n = ((Integer)localIterator.next()).intValue();
          if (a(this.jdField_c_of_type_AndroidViewViewGroup.findViewById(n), paramMotionEvent.getX(), paramMotionEvent.getY()))
          {
            this.m = true;
            this.jdField_h_of_type_Int = n;
            return true;
          }
        }
      }
    }
    if (!this.jdField_a_of_type_Boolean) {
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
      if (this.m)
      {
        View localView = this.jdField_c_of_type_AndroidViewViewGroup.findViewById(this.jdField_h_of_type_Int);
        if ((localView != null) && (paramMotionEvent.getAction() != 2) && (Math.abs(paramMotionEvent.getY() - this.jdField_a_of_type_Float) < 150.0F)) {
          localView.onTouchEvent(paramMotionEvent);
        }
        return true;
      }
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
            ((FastWebVideoFeedsListView.ListViewEventListener)paramMotionEvent.next()).a();
          }
        }
        a(this.jdField_c_of_type_AndroidViewViewGroup, this.jdField_i_of_type_Int);
        return true;
      }
      this.jdField_a_of_type_AndroidViewVelocityTracker.clear();
    }
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
              ((FastWebVideoFeedsListView.ListViewEventListener)paramMotionEvent.next()).b();
            }
          }
        }
        return true;
      }
      if ((this.jdField_j_of_type_Boolean) && (paramMotionEvent.getY() + 300.0F < this.jdField_a_of_type_Float)) {
        return true;
      }
      if (this.jdField_h_of_type_Boolean) {
        return true;
      }
      f1 = paramMotionEvent.getY() - this.jdField_a_of_type_Float;
      if ((f1 > 0.0F) && (this.jdField_f_of_type_Int - 100 <= f1))
      {
        this.jdField_h_of_type_Boolean = true;
        a(this.jdField_a_of_type_AndroidViewViewGroup, this.jdField_i_of_type_Int);
        return true;
      }
    } while ((f1 >= 0.0F) || (Math.abs(f1) < this.jdField_f_of_type_Int - 100));
    this.jdField_h_of_type_Boolean = true;
    a(this.jdField_b_of_type_AndroidViewViewGroup, this.jdField_i_of_type_Int);
    return true;
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
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.video.FastWebVideoFeedsListView
 * JD-Core Version:    0.7.0.1
 */