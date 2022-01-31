package com.tencent.biz.pubaccount.readinjoy.video;

import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.qphone.base.util.QLog;
import ndn;
import new;
import org.json.JSONException;
import org.json.JSONObject;
import pyy;
import qcf;
import qcg;
import qch;
import qci;
import qhp;
import qht;
import qji;

public class VideoFeedsGestureLayout
  extends RelativeLayout
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private AudioManager jdField_a_of_type_AndroidMediaAudioManager;
  private GestureDetector jdField_a_of_type_AndroidViewGestureDetector;
  private SeekBar jdField_a_of_type_AndroidWidgetSeekBar;
  private VideoFeedsPlayManager jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager;
  private TopGestureLayout jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout;
  private pyy jdField_a_of_type_Pyy;
  private qcf jdField_a_of_type_Qcf;
  private qcg jdField_a_of_type_Qcg;
  private qci jdField_a_of_type_Qci;
  private qhp jdField_a_of_type_Qhp;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int = 0;
  private long jdField_c_of_type_Long;
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int;
  private boolean jdField_d_of_type_Boolean;
  private int e;
  private int f = -1;
  private int g;
  private int h;
  
  public VideoFeedsGestureLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public VideoFeedsGestureLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet, 0);
  }
  
  public VideoFeedsGestureLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_AndroidAppActivity == null) {
      return;
    }
    ViewGroup localViewGroup;
    int i;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout == null)
    {
      localViewGroup = (ViewGroup)this.jdField_a_of_type_AndroidAppActivity.getWindow().getDecorView();
      i = 0;
      label31:
      if (i < localViewGroup.getChildCount())
      {
        View localView = localViewGroup.getChildAt(i);
        if ((localView == null) || (!(localView instanceof ViewGroup))) {
          break label103;
        }
        localViewGroup = (ViewGroup)localView;
      }
    }
    label103:
    for (;;)
    {
      if ((localViewGroup instanceof TopGestureLayout))
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout = ((TopGestureLayout)localViewGroup);
        if (this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout == null) {
          break;
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.setInterceptTouchFlag(paramBoolean);
        return;
      }
      i += 1;
      break label31;
    }
  }
  
  public long a()
  {
    return this.jdField_c_of_type_Long;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Qci != null) {
      this.jdField_a_of_type_Qci.a();
    }
    this.jdField_c_of_type_Int = 0;
  }
  
  public void a(int paramInt, float paramFloat)
  {
    if (!this.jdField_c_of_type_Boolean) {
      return;
    }
    if (paramInt == 0)
    {
      this.jdField_d_of_type_Boolean = false;
      if (this.jdField_a_of_type_Qcf != null) {
        this.jdField_a_of_type_Qcf.a(this, 1);
      }
      if (this.jdField_a_of_type_AndroidMediaAudioManager == null)
      {
        this.jdField_a_of_type_AndroidMediaAudioManager = ((AudioManager)BaseApplicationImpl.getApplication().getBaseContext().getSystemService("audio"));
        this.g = this.jdField_a_of_type_AndroidMediaAudioManager.getStreamMaxVolume(3);
      }
    }
    label192:
    label203:
    label337:
    long l2;
    label267:
    label273:
    label434:
    label448:
    long l1;
    switch (paramInt)
    {
    default: 
    case 1: 
    case 2: 
      int i;
      do
      {
        this.jdField_c_of_type_Int = paramInt;
        return;
        if (this.jdField_d_of_type_Boolean) {
          break;
        }
        this.jdField_d_of_type_Boolean = true;
        if (this.jdField_a_of_type_Qcf == null) {
          break;
        }
        this.jdField_a_of_type_Qcf.a(this, 2);
        break;
        if (this.jdField_c_of_type_Int == 0) {
          this.jdField_d_of_type_Int = this.jdField_a_of_type_AndroidMediaAudioManager.getStreamVolume(3);
        }
        j = (int)(this.g * paramFloat) + this.jdField_d_of_type_Int;
        if (j > this.g)
        {
          i = this.g;
          if (this.jdField_a_of_type_Int != 2) {
            break label267;
          }
          j = 2;
          if (i != 0) {
            break label273;
          }
          qji.a().a(true, "user_gesture", j);
        }
        for (;;)
        {
          this.jdField_a_of_type_AndroidMediaAudioManager.setStreamVolume(3, i, 0);
          this.jdField_a_of_type_Qci.a(1, i / this.g, 0L, 0L);
          break;
          i = j;
          if (j >= 0) {
            break label192;
          }
          i = 0;
          break label192;
          j = 1;
          break label203;
          qji.a().a(false, "user_gesture", j);
        }
      } while (this.jdField_a_of_type_Pyy == null);
      if (this.jdField_c_of_type_Int == 0)
      {
        if (this.jdField_a_of_type_Pyy.a()) {
          this.jdField_b_of_type_Boolean = true;
        }
        if (this.f != -1) {
          break label448;
        }
        if (!this.jdField_b_of_type_Boolean) {
          break label434;
        }
        this.e = 127;
        if (QLog.isColorLevel()) {
          QLog.i("VideoFeedsItemFrameLayout", 2, "mBeginBrightness = " + this.e);
        }
      }
      int j = (int)(255.0F * paramFloat) + this.e;
      if (j > 255) {
        i = 255;
      }
      for (;;)
      {
        this.jdField_a_of_type_Pyy.a(i / 255.0F);
        this.jdField_a_of_type_Qci.a(2, i / 255.0F, 0L, 0L);
        this.f = i;
        break;
        this.e = this.jdField_a_of_type_Pyy.a();
        break label337;
        this.e = this.f;
        break label337;
        i = j;
        if (j < 0) {
          i = 0;
        }
      }
    case 3: 
      if ((this.jdField_a_of_type_Qhp != null) && (this.jdField_a_of_type_Qhp.a() != null))
      {
        l2 = this.jdField_a_of_type_Qhp.a().jdField_b_of_type_Int * 1000;
        l1 = this.jdField_a_of_type_Qhp.a();
      }
      break;
    }
    for (;;)
    {
      label517:
      if ((this.jdField_c_of_type_Int == 0) && (l2 != 0L)) {
        this.jdField_a_of_type_Float = ((float)l1 / (float)l2);
      }
      float f2 = this.jdField_a_of_type_Float + paramFloat;
      float f1;
      if (f2 > 1.0F) {
        f1 = 1.0F;
      }
      for (;;)
      {
        this.h = ((int)(f1 * (float)l2));
        this.jdField_a_of_type_Qci.a(3, paramFloat, this.h, l2);
        break;
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager != null)
        {
          l2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.b();
          l1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a();
          break label517;
        }
        if (this.jdField_a_of_type_Qcg == null) {
          break label770;
        }
        l2 = this.jdField_a_of_type_Qcg.a();
        l1 = this.jdField_a_of_type_Qcg.b();
        break label517;
        f1 = f2;
        if (f2 < 0.0F) {
          f1 = 0.0F;
        }
      }
      if (this.jdField_c_of_type_Int == 3)
      {
        if (this.jdField_a_of_type_Qhp == null) {
          break label725;
        }
        this.jdField_a_of_type_Qhp.c(this.h);
        if (this.jdField_a_of_type_AndroidWidgetSeekBar != null) {
          this.jdField_a_of_type_AndroidWidgetSeekBar.setProgress(this.h / 1000);
        }
      }
      for (;;)
      {
        this.jdField_a_of_type_Qci.a(0, 0.0F, 0L, 0L);
        break;
        label725:
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager != null) {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a(this.h, true);
        } else if (this.jdField_a_of_type_Qcg != null) {
          this.jdField_a_of_type_Qcg.a(this.h);
        }
      }
      label770:
      l1 = 0L;
      l2 = 0L;
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    this.jdField_c_of_type_Long = System.currentTimeMillis();
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if (this.jdField_a_of_type_AndroidViewGestureDetector == null) {
      this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(getContext(), new qch(this));
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    JSONObject localJSONObject;
    if ((paramMotionEvent.getAction() == 1) && (this.jdField_b_of_type_Int != 0)) {
      localJSONObject = new JSONObject();
    }
    try
    {
      localJSONObject.put("channel_id", this.jdField_a_of_type_Long);
      switch (this.jdField_b_of_type_Int)
      {
      default: 
        this.jdField_b_of_type_Int = 0;
        a(0, 0.0F);
        this.jdField_a_of_type_AndroidViewGestureDetector.onTouchEvent(paramMotionEvent);
        if ((!this.jdField_c_of_type_Boolean) && (this.jdField_a_of_type_Int == 1)) {
          return false;
        }
        break;
      }
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
        continue;
        ndn.b(null, null, "0X8008A42", "0X8008A42", 0, 0, "", "", "", new.a(localJSONObject), false);
        continue;
        ndn.b(null, null, "0X8008A43", "0X8008A43", 0, 0, "", "", "", new.a(localJSONObject), false);
        continue;
        ndn.b(null, null, "0X8008A41", "0X8008A41", 0, 0, "", "", "", new.a(localJSONObject), false);
      }
    }
    return true;
  }
  
  public void setChannelID(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public void setContext(Activity paramActivity)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
  }
  
  public void setIsInFullScreen(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
    if ((this.jdField_c_of_type_Boolean) && (!this.jdField_a_of_type_Boolean)) {
      this.jdField_a_of_type_Qci = new qci();
    }
    try
    {
      this.jdField_a_of_type_Qci.a(this.jdField_a_of_type_AndroidAppActivity, this);
      this.jdField_a_of_type_Boolean = true;
      if (this.jdField_c_of_type_Boolean)
      {
        a(false);
        return;
      }
    }
    catch (Exception localException)
    {
      do
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("VideoFeedsItemFrameLayout", 2, "wgs error =" + localException.getMessage());
          }
        }
        a(true);
      } while (this.jdField_a_of_type_Pyy == null);
      this.jdField_a_of_type_Pyy.a();
      this.f = -1;
    }
  }
  
  @Deprecated
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    super.setOnClickListener(paramOnClickListener);
  }
  
  public void setOnCustomClickListener(qcf paramqcf)
  {
    this.jdField_a_of_type_Qcf = paramqcf;
  }
  
  public void setSeekBar(SeekBar paramSeekBar)
  {
    this.jdField_a_of_type_AndroidWidgetSeekBar = paramSeekBar;
  }
  
  public void setVideoBrightnessController(pyy parampyy)
  {
    this.jdField_a_of_type_Pyy = parampyy;
  }
  
  public void setVideoPlayManager(VideoFeedsPlayManager paramVideoFeedsPlayManager)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager = paramVideoFeedsPlayManager;
    this.jdField_a_of_type_Int = 2;
  }
  
  public void setVideoPlayManager(qcg paramqcg)
  {
    this.jdField_a_of_type_Qcg = paramqcg;
  }
  
  public void setVideoPlayManager(qhp paramqhp)
  {
    this.jdField_a_of_type_Qhp = paramqhp;
    this.jdField_a_of_type_Int = 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsGestureLayout
 * JD-Core Version:    0.7.0.1
 */