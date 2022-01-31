package com.tencent.biz.pubaccount.readinjoy.viola.videonew;

import ajjy;
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
import azvv;
import badq;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsGestureLayout;
import com.tencent.biz.pubaccount.readinjoy.viola.view.ViolaLazyFragment;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.view.IVideoViewBase;
import com.tencent.viola.core.ViolaInstance;
import java.util.HashMap;
import pyy;
import qcf;
import qcn;
import rmc;
import rmd;
import rmi;
import rmm;
import rmn;
import rmp;
import rmq;
import rmr;

public class ViolaVideoView
  extends FrameLayout
  implements View.OnClickListener, qcf, rmc, rmn
{
  private static HashMap<Integer, Drawable> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private ColorDrawable jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
  private Handler jdField_a_of_type_AndroidOsHandler = new rmr(this, null);
  private View jdField_a_of_type_AndroidViewView;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private SeekBar jdField_a_of_type_AndroidWidgetSeekBar;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private VideoFeedsGestureLayout jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout;
  private VideoPlayManager jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager;
  private URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  private pyy jdField_a_of_type_Pyy;
  private rmd jdField_a_of_type_Rmd;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private View jdField_b_of_type_AndroidViewView;
  private ViewGroup jdField_b_of_type_AndroidViewViewGroup;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private HashMap<Integer, Drawable> jdField_b_of_type_JavaUtilHashMap = new HashMap();
  private boolean jdField_b_of_type_Boolean = true;
  private View jdField_c_of_type_AndroidViewView;
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
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(paramActivity).inflate(2131494513, this, false);
    addView(this.jdField_a_of_type_AndroidViewView);
    a(this.jdField_a_of_type_AndroidViewView, paramActivity);
    this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable = new ColorDrawable(paramActivity.getResources().getColor(2131099738));
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
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout = ((VideoFeedsGestureLayout)paramView.findViewById(2131301388));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131306042));
    this.jdField_c_of_type_AndroidViewViewGroup = ((ViewGroup)paramView.findViewById(2131313115));
    this.jdField_a_of_type_AndroidWidgetSeekBar = ((SeekBar)paramView.findViewById(2131310016));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131299307));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131311816));
    this.jdField_b_of_type_AndroidViewViewGroup = ((ViewGroup)paramView.findViewById(2131306043));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131300138));
    this.jdField_d_of_type_AndroidViewViewGroup = ((ViewGroup)paramView.findViewById(2131297811));
    this.jdField_e_of_type_AndroidViewViewGroup = ((ViewGroup)paramView.findViewById(2131301264));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131301265));
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131305411));
    this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131300642));
    this.jdField_f_of_type_AndroidViewViewGroup = ((ViewGroup)paramView.findViewById(2131301263));
    this.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131298714);
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131301266));
    this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(null);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_e_of_type_AndroidWidgetTextView.setOnClickListener(this);
    h();
    this.jdField_e_of_type_AndroidViewViewGroup.setOnClickListener(this);
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_d_of_type_AndroidWidgetTextView.getPaint().setFakeBoldText(true);
    this.jdField_a_of_type_Pyy = new pyy(paramActivity);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout.setOnCustomClickListener(this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout.setContext(paramActivity);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout.setVideoBrightnessController(this.jdField_a_of_type_Pyy);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout.setVideoPlayManager(new rmp(this));
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
  
  private boolean a(rmm paramrmm)
  {
    if (!badq.b(getContext())) {}
    while ((paramrmm == null) || (paramrmm.jdField_a_of_type_Rmi == null)) {
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
    qcn.b(this.jdField_a_of_type_ComTencentImageURLImageView, paramInt1, paramInt2);
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
        if (this.jdField_a_of_type_Rmd != null) {
          this.jdField_a_of_type_Rmd.b(paramBoolean);
        }
        qcn.a(this.jdField_c_of_type_AndroidViewViewGroup, 0);
      }
      if (this.jdField_b_of_type_AndroidViewViewGroup.getVisibility() == 8) {
        qcn.a(this.jdField_b_of_type_AndroidViewViewGroup, 0);
      }
      return;
    }
    if (this.jdField_c_of_type_AndroidViewViewGroup.getVisibility() == 0)
    {
      if (this.jdField_a_of_type_Rmd != null) {
        this.jdField_a_of_type_Rmd.b(paramBoolean);
      }
      qcn.a(this.jdField_c_of_type_AndroidViewViewGroup, 8);
    }
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager.d()) && (this.jdField_b_of_type_AndroidViewViewGroup.getVisibility() == 0)) {
      qcn.a(this.jdField_b_of_type_AndroidViewViewGroup, 8);
    }
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  private boolean b(rmm paramrmm)
  {
    return (paramrmm != null) && (paramrmm.jdField_a_of_type_Rmi != null) && (!paramrmm.jdField_b_of_type_Boolean) && (badq.b(getContext())) && (paramrmm.jdField_a_of_type_Rmi.jdField_a_of_type_Long >= 0L);
  }
  
  private void c(rmi paramrmi)
  {
    String str = ajjy.a(2131650677) + qcn.b(paramrmi.jdField_a_of_type_Long);
    if (paramrmi.jdField_a_of_type_Long <= 0L) {
      str = ajjy.a(2131650678);
    }
    paramrmi = this.jdField_f_of_type_AndroidWidgetTextView;
    paramrmi.setText(str);
    qcn.a(paramrmi, 0);
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(new ViolaVideoView.11(this, paramrmi), 1000L);
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
    this.jdField_a_of_type_AndroidWidgetSeekBar.setOnSeekBarChangeListener(new rmq(this));
  }
  
  public ViewGroup a()
  {
    return this.jdField_a_of_type_AndroidViewViewGroup;
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager.a() != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager.a().jdField_a_of_type_AndroidViewView != null)) {
      ((IVideoViewBase)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager.a().jdField_a_of_type_AndroidViewView).doCacheSurfaceTexture();
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
            ((ViolaLazyFragment)localObject).p();
            ((ViolaLazyFragment)localObject).n();
          }
        }
        localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager.a();
        ViewGroup.LayoutParams localLayoutParams = getLayoutParams();
        localLayoutParams.height = ((rmm)localObject).c;
        localLayoutParams.width = ((rmm)localObject).jdField_b_of_type_Int;
      }
      this.jdField_f_of_type_AndroidViewViewGroup.setPadding(0, 0, 0, 0);
      if (this.jdField_a_of_type_Rmd != null) {
        this.jdField_a_of_type_Rmd.c(false);
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
        qcn.a(localActivity);
        if ((((VVideoView)localObject).a() != null) && (((VVideoView)localObject).a().getInstance() != null) && (((VVideoView)localObject).a().getInstance().getFragment() != null))
        {
          localObject = (ViolaLazyFragment)((VVideoView)localObject).a().getInstance().getFragment();
          if (localObject != null)
          {
            ((ViolaLazyFragment)localObject).o();
            ((ViolaLazyFragment)localObject).m();
          }
        }
        localObject = getLayoutParams();
        ((ViewGroup.LayoutParams)localObject).height = -1;
        ((ViewGroup.LayoutParams)localObject).width = -1;
      }
      if (paramBoolean) {
        this.jdField_f_of_type_AndroidViewViewGroup.setPadding(0, 40, 0, 0);
      }
      if (this.jdField_a_of_type_Rmd != null) {
        this.jdField_a_of_type_Rmd.c(true);
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
  
  public void a(rmi paramrmi)
  {
    int j = 0;
    if (!TextUtils.isEmpty(paramrmi.b))
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
        paramrmi = URLDrawable.getDrawable(paramrmi.b, localURLDrawableOptions);
        this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(paramrmi);
        return;
      }
    }
    this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(null);
  }
  
  public void a(rmm paramrmm)
  {
    a(paramrmm.jdField_b_of_type_Int, paramrmm.c);
    a(paramrmm.jdField_a_of_type_Rmi);
    if (b(paramrmm)) {
      b(paramrmm.jdField_a_of_type_Rmi);
    }
    b(false);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager.e(paramrmm.jdField_d_of_type_Int);
    if (paramrmm.jdField_e_of_type_Int != -1) {
      b(paramrmm.jdField_e_of_type_Int);
    }
    setFullScreenDisable(paramrmm.jdField_d_of_type_Boolean);
    a(paramrmm.jdField_e_of_type_Boolean);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(0);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(0, 3000L);
    this.jdField_a_of_type_AndroidWidgetImageView.setTag(paramrmm);
    this.jdField_e_of_type_AndroidViewViewGroup.setTag(paramrmm);
    this.jdField_b_of_type_AndroidViewView.setTag(paramrmm);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout.setTag(paramrmm);
    this.jdField_e_of_type_AndroidWidgetTextView.setTag(paramrmm);
    setFullScreenTitle(paramrmm.jdField_a_of_type_Rmi.c);
  }
  
  public void a(rmm paramrmm, int paramInt)
  {
    a(2, null);
  }
  
  public void a(rmm paramrmm, int paramInt1, int paramInt2, String paramString)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new ViolaVideoView.9(this, paramString));
  }
  
  public void a(rmm paramrmm, long paramLong)
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
        qcn.a(this.jdField_b_of_type_AndroidWidgetTextView, l);
      }
      return;
    }
    int i = (int)(100L * paramLong / l);
    float f2 = Math.round(100000.0F / (float)l);
    if (i + f2 > 100.0F) {}
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetSeekBar.setProgress((int)f1);
      qcn.a(this.jdField_a_of_type_AndroidWidgetTextView, paramLong);
      break;
      f1 = i + f2;
    }
  }
  
  public void a(rmm paramrmm, boolean paramBoolean)
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
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager.a() != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager.a().jdField_a_of_type_AndroidViewView != null)) {
      ((IVideoViewBase)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager.a().jdField_a_of_type_AndroidViewView).doRecoverSurfaceTexture();
    }
  }
  
  public void b(View paramView) {}
  
  protected void b(rmi paramrmi)
  {
    paramrmi = qcn.c(paramrmi.jdField_a_of_type_Long);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    Drawable localDrawable = getContext().getResources().getDrawable(2130842494);
    this.jdField_e_of_type_AndroidWidgetTextView.setText(paramrmi);
    this.jdField_e_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(localDrawable, null, null, null);
    this.jdField_e_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(azvv.a(getContext(), 6.0F));
    this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(0);
  }
  
  public void b(rmm paramrmm)
  {
    this.jdField_c_of_type_AndroidViewView = paramrmm.jdField_a_of_type_AndroidViewView;
  }
  
  public void b(rmm paramrmm, int paramInt)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new ViolaVideoView.4(this));
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Pyy != null)
    {
      this.jdField_a_of_type_Pyy.b();
      this.jdField_a_of_type_Pyy = null;
    }
    if (this.jdField_a_of_type_AndroidOsHandler != null)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(0);
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_AndroidOsHandler = null;
    }
  }
  
  public void c(rmm paramrmm)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new ViolaVideoView.2(this, paramrmm));
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
    rmm localrmm = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager.a();
    switch (i)
    {
    default: 
      return;
    case 0: 
    case 7: 
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager.b(localrmm);
      return;
    case 6: 
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager.c(localrmm);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager.b(localrmm);
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
  
  public void d(rmm paramrmm)
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
  
  public void e(rmm paramrmm)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new ViolaVideoView.5(this));
  }
  
  public void f(rmm paramrmm)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new ViolaVideoView.6(this));
  }
  
  public void g(rmm paramrmm)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new ViolaVideoView.7(this));
  }
  
  public void h(rmm paramrmm)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new ViolaVideoView.8(this));
  }
  
  public void onClick(View paramView)
  {
    if (!a(paramView)) {
      return;
    }
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131298714: 
      e();
      return;
    case 2131306042: 
      d();
      return;
    case 2131305411: 
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager.c()) {
        qcn.a(this.jdField_c_of_type_AndroidViewViewGroup, 8, 200);
      }
      d();
      return;
    }
    e();
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
    for (Object localObject = a(getContext(), 2130841247);; localObject = a(getContext(), 2130841248))
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
      for (localObject = a(getContext(), 2130841247);; localObject = a(getContext(), 2130841248))
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
  
  public void setEventListener(rmd paramrmd)
  {
    this.jdField_a_of_type_Rmd = paramrmd;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.videonew.ViolaVideoView
 * JD-Core Version:    0.7.0.1
 */