package com.tencent.biz.pubaccount.readinjoy.viola.videonew;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.SeekBar;
import android.widget.TextView;
import anzj;
import bhgr;
import bhnv;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsGestureLayout;
import com.tencent.biz.pubaccount.readinjoy.viola.view.ViolaLazyFragment;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.viola.core.ViolaInstance;
import java.util.HashMap;
import rmr;
import rpj;
import rpt;
import sab;
import tia;
import tib;
import tih;
import til;
import tim;
import tio;
import tip;
import tiq;

public class ViolaVideoView
  extends FrameLayout
  implements View.OnClickListener, rpj, tia, tim
{
  private static HashMap<Integer, Drawable> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private ColorDrawable jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
  private Handler jdField_a_of_type_AndroidOsHandler = new tiq(this, null);
  private View jdField_a_of_type_AndroidViewView;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private SeekBar jdField_a_of_type_AndroidWidgetSeekBar;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private VideoFeedsGestureLayout jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout;
  private VideoPlayManager jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager;
  private URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  private rmr jdField_a_of_type_Rmr;
  private tib jdField_a_of_type_Tib;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private View jdField_b_of_type_AndroidViewView;
  private ViewGroup jdField_b_of_type_AndroidViewViewGroup;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private HashMap<Integer, Drawable> jdField_b_of_type_JavaUtilHashMap = new HashMap();
  private boolean jdField_b_of_type_Boolean = true;
  private ViewGroup jdField_c_of_type_AndroidViewViewGroup;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private boolean jdField_c_of_type_Boolean;
  private ViewGroup jdField_d_of_type_AndroidViewViewGroup;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  private boolean jdField_d_of_type_Boolean;
  private ViewGroup jdField_e_of_type_AndroidViewViewGroup;
  private TextView jdField_e_of_type_AndroidWidgetTextView;
  private ViewGroup jdField_f_of_type_AndroidViewViewGroup;
  private TextView jdField_f_of_type_AndroidWidgetTextView;
  
  public ViolaVideoView(@NonNull Activity paramActivity)
  {
    super(paramActivity);
    setTag("ViolaVideoView");
    this.jdField_a_of_type_AndroidViewViewGroup = new FrameLayout(paramActivity);
    addView(this.jdField_a_of_type_AndroidViewViewGroup, -1, -1);
    this.jdField_a_of_type_ComTencentImageURLImageView = new URLImageView(paramActivity);
    this.jdField_a_of_type_ComTencentImageURLImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    addView(this.jdField_a_of_type_ComTencentImageURLImageView, -1, -1);
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(paramActivity).inflate(2131560351, this, false);
    addView(this.jdField_a_of_type_AndroidViewView);
    a(this.jdField_a_of_type_AndroidViewView, paramActivity);
    this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable = new ColorDrawable(paramActivity.getResources().getColor(2131165343));
    this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable);
    paramActivity.getWindow().setFlags(16777216, 16777216);
  }
  
  private Drawable a(int paramInt)
  {
    if (this.jdField_b_of_type_JavaUtilHashMap.containsKey(Integer.valueOf(paramInt))) {
      return (Drawable)this.jdField_b_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt));
    }
    try
    {
      Drawable localDrawable = getContext().getResources().getDrawable(paramInt);
      this.jdField_b_of_type_JavaUtilHashMap.put(Integer.valueOf(paramInt), localDrawable);
      return localDrawable;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ViolaVideoView", 2, "innerGetDrawableFromCache() OutOfMemoryError e=" + localOutOfMemoryError.getMessage());
      }
    }
    return null;
  }
  
  private static Drawable a(Context paramContext, int paramInt)
  {
    if (jdField_a_of_type_JavaUtilHashMap == null) {}
    do
    {
      return null;
      if (jdField_a_of_type_JavaUtilHashMap.containsKey(Integer.valueOf(paramInt))) {
        return (Drawable)jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt));
      }
      try
      {
        paramContext = paramContext.getResources().getDrawable(paramInt);
        jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(paramInt), paramContext);
        return paramContext;
      }
      catch (OutOfMemoryError paramContext) {}
    } while (!QLog.isColorLevel());
    QLog.d("ViolaVideoView", 2, "innerGetDrawableFromCache() OutOfMemoryError e=" + paramContext.getMessage());
    return null;
  }
  
  private void a(int paramInt, String paramString)
  {
    if (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager.a()) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ViolaVideoView", 2, "innerChangePlayButton() what = " + paramInt);
    }
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidOsHandler.obtainMessage(paramInt, paramString).sendToTarget();
  }
  
  private void a(View paramView, Activity paramActivity)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout = ((VideoFeedsGestureLayout)paramView.findViewById(2131367489));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131372759));
    this.jdField_c_of_type_AndroidViewViewGroup = ((ViewGroup)paramView.findViewById(2131380789));
    this.jdField_a_of_type_AndroidWidgetSeekBar = ((SeekBar)paramView.findViewById(2131377252));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131365236));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131379245));
    this.jdField_b_of_type_AndroidViewViewGroup = ((ViewGroup)paramView.findViewById(2131372760));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131366115));
    this.jdField_d_of_type_AndroidViewViewGroup = ((ViewGroup)paramView.findViewById(2131363613));
    this.jdField_e_of_type_AndroidViewViewGroup = ((ViewGroup)paramView.findViewById(2131367318));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131367319));
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131372120));
    this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131366636));
    this.jdField_f_of_type_AndroidViewViewGroup = ((ViewGroup)paramView.findViewById(2131367317));
    this.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131364596);
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131367320));
    this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(null);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_e_of_type_AndroidWidgetTextView.setOnClickListener(this);
    h();
    this.jdField_e_of_type_AndroidViewViewGroup.setOnClickListener(this);
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_d_of_type_AndroidWidgetTextView.getPaint().setFakeBoldText(true);
    this.jdField_a_of_type_Rmr = new rmr(paramActivity);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout.setOnCustomClickListener(this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout.setContext(paramActivity);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout.setVideoBrightnessController(this.jdField_a_of_type_Rmr);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout.setVideoPlayManager(new tio(this));
  }
  
  private void a(boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      this.jdField_a_of_type_AndroidWidgetSeekBar.setClickable(true);
      this.jdField_a_of_type_AndroidWidgetSeekBar.setEnabled(true);
      this.jdField_a_of_type_AndroidWidgetSeekBar.setSelected(true);
      this.jdField_a_of_type_AndroidWidgetSeekBar.setFocusable(true);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetSeekBar.setClickable(false);
    this.jdField_a_of_type_AndroidWidgetSeekBar.setEnabled(false);
    this.jdField_a_of_type_AndroidWidgetSeekBar.setSelected(false);
    this.jdField_a_of_type_AndroidWidgetSeekBar.setFocusable(false);
  }
  
  private boolean a(View paramView)
  {
    return (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager.a() != null) && (paramView.getTag() == this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager.a());
  }
  
  private boolean a(til paramtil)
  {
    if (!bhnv.b(getContext())) {}
    while ((paramtil == null) || (paramtil.jdField_a_of_type_Tih == null)) {
      return false;
    }
    return true;
  }
  
  private void b(int paramInt)
  {
    ((ViewGroup.MarginLayoutParams)this.jdField_d_of_type_AndroidViewViewGroup.getLayoutParams()).bottomMargin = paramInt;
    this.jdField_d_of_type_AndroidViewViewGroup.requestLayout();
  }
  
  private void b(int paramInt1, int paramInt2)
  {
    if (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager.a()) {
      return;
    }
    rpt.a(this.jdField_a_of_type_ComTencentImageURLImageView, paramInt1, paramInt2);
  }
  
  private void b(int paramInt, String paramString)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager.a() == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ViolaVideoView", 2, "innerChangePlayButtonFromOpen() what = " + paramInt);
    }
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidOsHandler.obtainMessage(paramInt, paramString).sendToTarget();
  }
  
  private void b(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.jdField_c_of_type_AndroidViewViewGroup.getVisibility() == 8)
      {
        if (this.jdField_a_of_type_Tib != null) {
          this.jdField_a_of_type_Tib.a(paramBoolean);
        }
        rpt.a(this.jdField_c_of_type_AndroidViewViewGroup, 0);
      }
      if (this.jdField_b_of_type_AndroidViewViewGroup.getVisibility() == 8) {
        rpt.a(this.jdField_b_of_type_AndroidViewViewGroup, 0);
      }
      return;
    }
    if (this.jdField_c_of_type_AndroidViewViewGroup.getVisibility() == 0)
    {
      if (this.jdField_a_of_type_Tib != null) {
        this.jdField_a_of_type_Tib.a(paramBoolean);
      }
      rpt.a(this.jdField_c_of_type_AndroidViewViewGroup, 8);
    }
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager.d()) && (this.jdField_b_of_type_AndroidViewViewGroup.getVisibility() == 0)) {
      rpt.a(this.jdField_b_of_type_AndroidViewViewGroup, 8);
    }
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  private boolean b(til paramtil)
  {
    return (paramtil != null) && (paramtil.jdField_a_of_type_Tih != null) && (!paramtil.jdField_b_of_type_Boolean) && (bhnv.b(getContext())) && (paramtil.jdField_a_of_type_Tih.jdField_a_of_type_Long >= 0L);
  }
  
  private void c(tih paramtih)
  {
    String str = anzj.a(2131715249) + rpt.b(paramtih.jdField_a_of_type_Long);
    if (paramtih.jdField_a_of_type_Long <= 0L) {
      str = anzj.a(2131715250);
    }
    paramtih = this.jdField_f_of_type_AndroidWidgetTextView;
    paramtih.setText(str);
    rpt.a(paramtih, 0);
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(new ViolaVideoView.11(this, paramtih), 1000L);
  }
  
  private void f()
  {
    if (!this.jdField_c_of_type_Boolean) {}
    do
    {
      do
      {
        return;
      } while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager.a() == null);
      this.jdField_c_of_type_Boolean = false;
    } while (getParent() == null);
    VVideoView localVVideoView = (VVideoView)getParent();
    a();
    localVVideoView.b(1);
    b();
    a(1);
  }
  
  private void g()
  {
    if (this.jdField_c_of_type_Boolean) {}
    do
    {
      do
      {
        return;
      } while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager.a() == null);
      this.jdField_c_of_type_Boolean = true;
    } while (getParent() == null);
    VVideoView localVVideoView = (VVideoView)getParent();
    a();
    localVVideoView.a(0);
    b();
    a(0, false);
  }
  
  private void h()
  {
    this.jdField_a_of_type_AndroidWidgetSeekBar.setOnSeekBarChangeListener(new tip(this));
  }
  
  public ViewGroup a()
  {
    return this.jdField_a_of_type_AndroidViewViewGroup;
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager.a() != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager.a().jdField_a_of_type_Sab != null)) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager.a().jdField_a_of_type_Sab.a();
    }
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ViolaVideoView", 2, "deal exitFullScreen: ");
    }
    this.jdField_c_of_type_Boolean = false;
    setControlType(this.jdField_a_of_type_Int);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout.setIsInFullScreen(false);
    if (paramInt == 1) {
      ((Activity)getContext()).setRequestedOrientation(1);
    }
    for (;;)
    {
      ((Activity)getContext()).setRequestedOrientation(1);
      if (getParent() != null)
      {
        Object localObject = (VVideoView)getParent();
        ((Activity)getContext()).getWindow().getDecorView().setSystemUiVisibility(this.jdField_b_of_type_Int);
        if ((((VVideoView)localObject).a() != null) && (((VVideoView)localObject).a().getInstance() != null) && (((VVideoView)localObject).a().getInstance().getFragment() != null))
        {
          localObject = (ViolaLazyFragment)((VVideoView)localObject).a().getInstance().getFragment();
          if (localObject != null)
          {
            ((ViolaLazyFragment)localObject).showTitleBar();
            ((ViolaLazyFragment)localObject).recoverStatusBar();
          }
        }
        localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager.a();
        ViewGroup.LayoutParams localLayoutParams = getLayoutParams();
        localLayoutParams.height = ((til)localObject).c;
        localLayoutParams.width = ((til)localObject).jdField_b_of_type_Int;
      }
      this.jdField_f_of_type_AndroidViewViewGroup.setPadding(0, 0, 0, 0);
      if (this.jdField_a_of_type_Tib != null) {
        this.jdField_a_of_type_Tib.b(false);
      }
      return;
      ((Activity)getContext()).setRequestedOrientation(9);
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    ViewGroup.LayoutParams localLayoutParams = getLayoutParams();
    localLayoutParams.width = paramInt1;
    localLayoutParams.height = paramInt2;
    setLayoutParams(localLayoutParams);
    if (QLog.isColorLevel()) {
      QLog.d("ViolaVideoView", 2, "onSizeChanged: width=" + paramInt1 + ",height=" + paramInt2);
    }
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ViolaVideoView", 2, "deal enterFullScreen: ");
    }
    this.jdField_c_of_type_Boolean = true;
    setControlType(this.jdField_a_of_type_Int);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout.setIsInFullScreen(true);
    if (!paramBoolean)
    {
      if (paramInt != 0) {
        break label204;
      }
      ((Activity)getContext()).setRequestedOrientation(0);
    }
    for (;;)
    {
      if (getParent() != null)
      {
        Object localObject = (VVideoView)getParent();
        Activity localActivity = (Activity)getContext();
        this.jdField_b_of_type_Int = localActivity.getWindow().getDecorView().getSystemUiVisibility();
        rpt.a(localActivity);
        if ((((VVideoView)localObject).a() != null) && (((VVideoView)localObject).a().getInstance() != null) && (((VVideoView)localObject).a().getInstance().getFragment() != null))
        {
          localObject = (ViolaLazyFragment)((VVideoView)localObject).a().getInstance().getFragment();
          if (localObject != null)
          {
            ((ViolaLazyFragment)localObject).hideTitleBar();
            ((ViolaLazyFragment)localObject).hideStatusBar();
          }
        }
        localObject = getLayoutParams();
        ((ViewGroup.LayoutParams)localObject).height = -1;
        ((ViewGroup.LayoutParams)localObject).width = -1;
      }
      if (paramBoolean) {
        this.jdField_f_of_type_AndroidViewViewGroup.setPadding(0, 40, 0, 0);
      }
      if (this.jdField_a_of_type_Tib != null) {
        this.jdField_a_of_type_Tib.b(true);
      }
      return;
      label204:
      ((Activity)getContext()).setRequestedOrientation(8);
    }
  }
  
  public void a(View paramView)
  {
    if (!a(paramView)) {
      return;
    }
    if (this.jdField_c_of_type_AndroidViewViewGroup.getVisibility() == 8) {}
    for (boolean bool = true;; bool = false)
    {
      b(bool);
      return;
    }
  }
  
  public void a(View paramView, int paramInt)
  {
    if (!a(paramView)) {
      return;
    }
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      b(true);
      return;
    }
    b(false);
  }
  
  public void a(View paramView, int paramInt1, int paramInt2) {}
  
  public void a(VideoPlayManager paramVideoPlayManager)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager = paramVideoPlayManager;
  }
  
  public void a(tih paramtih)
  {
    int j = 0;
    if (!TextUtils.isEmpty(paramtih.b))
    {
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      ViewGroup.LayoutParams localLayoutParams = getLayoutParams();
      if (localLayoutParams.width > 0) {}
      for (int i = localLayoutParams.width;; i = 0)
      {
        localURLDrawableOptions.mRequestWidth = i;
        i = j;
        if (localLayoutParams.height > 0) {
          i = localLayoutParams.height;
        }
        localURLDrawableOptions.mRequestHeight = i;
        localURLDrawableOptions.mPlayGifImage = true;
        localURLDrawableOptions.mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
        localURLDrawableOptions.mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
        paramtih = URLDrawable.getDrawable(paramtih.b, localURLDrawableOptions);
        this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(paramtih);
        return;
      }
    }
    this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(null);
  }
  
  public void a(til paramtil)
  {
    a(paramtil.jdField_b_of_type_Int, paramtil.c);
    a(paramtil.jdField_a_of_type_Tih);
    if (b(paramtil)) {
      b(paramtil.jdField_a_of_type_Tih);
    }
    b(false);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager.e(paramtil.jdField_d_of_type_Int);
    if (paramtil.jdField_e_of_type_Int != -1) {
      b(paramtil.jdField_e_of_type_Int);
    }
    setFullScreenDisable(paramtil.jdField_d_of_type_Boolean);
    a(paramtil.jdField_e_of_type_Boolean);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(0);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(0, 3000L);
    this.jdField_a_of_type_AndroidWidgetImageView.setTag(paramtil);
    this.jdField_e_of_type_AndroidViewViewGroup.setTag(paramtil);
    this.jdField_b_of_type_AndroidViewView.setTag(paramtil);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout.setTag(paramtil);
    this.jdField_e_of_type_AndroidWidgetTextView.setTag(paramtil);
    setFullScreenTitle(paramtil.jdField_a_of_type_Tih.c);
  }
  
  public void a(til paramtil, int paramInt)
  {
    a(2, null);
  }
  
  public void a(til paramtil, int paramInt1, int paramInt2, String paramString)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new ViolaVideoView.9(this, paramString));
  }
  
  public void a(til paramtil, long paramLong)
  {
    float f1 = 100.0F;
    long l = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager.a();
    if (!this.jdField_a_of_type_Boolean)
    {
      if (l != 0L) {
        break label53;
      }
      this.jdField_a_of_type_AndroidWidgetSeekBar.setProgress(0);
    }
    label53:
    while (paramLong == 0L)
    {
      if (l > 0L) {
        rpt.a(this.jdField_b_of_type_AndroidWidgetTextView, l);
      }
      return;
    }
    int i = (int)(100L * paramLong / l);
    float f2 = Math.round(100000.0F / (float)l);
    if (i + f2 > 100.0F) {}
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetSeekBar.setProgress((int)f1);
      rpt.a(this.jdField_a_of_type_AndroidWidgetTextView, paramLong);
      break;
      f1 = i + f2;
    }
  }
  
  public void a(til paramtil, boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    if (paramBoolean)
    {
      this.jdField_b_of_type_Boolean = true;
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, 1200L);
      return;
    }
    b(2, null);
  }
  
  public boolean a()
  {
    return this.jdField_c_of_type_Boolean;
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager.a() != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager.a().jdField_a_of_type_Sab != null)) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager.a().jdField_a_of_type_Sab.b();
    }
  }
  
  public void b(View paramView) {}
  
  protected void b(tih paramtih)
  {
    paramtih = rpt.c(paramtih.jdField_a_of_type_Long);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    Drawable localDrawable = getContext().getResources().getDrawable(2130843132);
    this.jdField_e_of_type_AndroidWidgetTextView.setText(paramtih);
    this.jdField_e_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(localDrawable, null, null, null);
    this.jdField_e_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(bhgr.a(getContext(), 6.0F));
    this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(0);
  }
  
  public void b(til paramtil) {}
  
  public void b(til paramtil, int paramInt)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new ViolaVideoView.4(this));
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Rmr != null)
    {
      this.jdField_a_of_type_Rmr.b();
      this.jdField_a_of_type_Rmr = null;
    }
    if (this.jdField_a_of_type_AndroidOsHandler != null)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(0);
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    }
  }
  
  public void c(til paramtil)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new ViolaVideoView.2(this, paramtil));
  }
  
  public void d()
  {
    int i = 0;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager.a()) {
      i = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager.a();
    }
    if (QLog.isColorLevel()) {
      QLog.d("ViolaVideoView", 2, "handlePlayButtonClick() status()=" + i);
    }
    til localtil = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager.a();
    switch (i)
    {
    default: 
      return;
    case 0: 
    case 7: 
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager.b(localtil);
      return;
    case 6: 
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager.c(localtil);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager.b(localtil);
      return;
    case 3: 
    case 4: 
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager.a(1);
      return;
    case 5: 
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager.b(1);
      return;
    case 1: 
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager.a(1);
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager.a();
  }
  
  public void d(til paramtil)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new ViolaVideoView.3(this));
  }
  
  public void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ViolaVideoView", 2, "changeFullScreenStatus: mIsShowingFull=" + this.jdField_c_of_type_Boolean);
    }
    if (this.jdField_c_of_type_Boolean)
    {
      f();
      return;
    }
    g();
  }
  
  public void e(til paramtil)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new ViolaVideoView.5(this));
  }
  
  public void f(til paramtil)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new ViolaVideoView.6(this));
  }
  
  public void g(til paramtil)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new ViolaVideoView.7(this));
  }
  
  public void h(til paramtil)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new ViolaVideoView.8(this));
  }
  
  public void onClick(View paramView)
  {
    if (!a(paramView)) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      switch (paramView.getId())
      {
      default: 
        break;
      case 2131364596: 
        e();
        break;
      case 2131372759: 
        d();
        break;
      case 2131372120: 
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager.c()) {
          rpt.a(this.jdField_c_of_type_AndroidViewViewGroup, 8, 200);
        }
        d();
        break;
      case 2131367318: 
        e();
      }
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    c();
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  public void setControlType(int paramInt)
  {
    int j = 8;
    int i = 0;
    this.jdField_a_of_type_Int = paramInt;
    ImageView localImageView;
    switch (this.jdField_a_of_type_Int)
    {
    default: 
      localObject = this.jdField_f_of_type_AndroidViewViewGroup;
      paramInt = j;
      if (this.jdField_c_of_type_Boolean) {
        paramInt = 0;
      }
      ((ViewGroup)localObject).setVisibility(paramInt);
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      localImageView = this.jdField_b_of_type_AndroidWidgetImageView;
      if (!this.jdField_c_of_type_Boolean) {
        break;
      }
    }
    for (Object localObject = a(getContext(), 2130841764);; localObject = a(getContext(), 2130841765))
    {
      localImageView.setBackgroundDrawable((Drawable)localObject);
      return;
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      return;
      localObject = this.jdField_a_of_type_AndroidViewView;
      if (this.jdField_c_of_type_Boolean)
      {
        paramInt = 0;
        ((View)localObject).setVisibility(paramInt);
        localObject = this.jdField_f_of_type_AndroidViewViewGroup;
        if (!this.jdField_c_of_type_Boolean) {
          break label191;
        }
        paramInt = i;
        label146:
        ((ViewGroup)localObject).setVisibility(paramInt);
        localImageView = this.jdField_b_of_type_AndroidWidgetImageView;
        if (!this.jdField_c_of_type_Boolean) {
          break label197;
        }
      }
      label191:
      label197:
      for (localObject = a(getContext(), 2130841764);; localObject = a(getContext(), 2130841765))
      {
        localImageView.setBackgroundDrawable((Drawable)localObject);
        return;
        paramInt = 8;
        break;
        paramInt = 8;
        break label146;
      }
    }
  }
  
  public void setEndWithLastFrame(boolean paramBoolean)
  {
    this.jdField_d_of_type_Boolean = paramBoolean;
  }
  
  public void setEventListener(tib paramtib)
  {
    this.jdField_a_of_type_Tib = paramtib;
  }
  
  public void setFullScreenDisable(boolean paramBoolean)
  {
    ViewGroup localViewGroup = this.jdField_e_of_type_AndroidViewViewGroup;
    if (paramBoolean) {}
    for (int i = 8;; i = 0)
    {
      localViewGroup.setVisibility(i);
      return;
    }
  }
  
  public void setFullScreenTitle(String paramString)
  {
    this.jdField_d_of_type_AndroidWidgetTextView.setText(paramString);
  }
  
  public void setVisibility(int paramInt)
  {
    super.setVisibility(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.videonew.ViolaVideoView
 * JD-Core Version:    0.7.0.1
 */