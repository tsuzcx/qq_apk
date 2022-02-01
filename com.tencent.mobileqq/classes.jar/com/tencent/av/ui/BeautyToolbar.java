package com.tencent.av.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import lcb;
import lff;
import lgv;
import lpj;
import lpm;
import mbb;
import mch;
import mci;
import mcj;
import mck;

public class BeautyToolbar
  extends BaseToolbar
{
  static final String TAG = "BeautyToolbar";
  RelativeLayout mBeautySeekBar = null;
  public int mBeautyValue = 0;
  Context mContext = null;
  private VideoControlUI mControlUI;
  public boolean mIs1stShow = false;
  boolean mIsShown = false;
  SeekBar.OnSeekBarChangeListener mOnSeekBarChangeListener = new mcj(this);
  public SeekBar mSeek = null;
  int mThumbWidth;
  public Drawable mThumb_0;
  public Drawable mThumb_100;
  public Drawable mThumb_30;
  public Drawable mThumb_60;
  TextView mTip;
  int mTipLayoutMargin;
  RelativeLayout.LayoutParams mTipLayoutParams;
  mch mUIInfo = null;
  
  public BeautyToolbar(VideoAppInterface paramVideoAppInterface, AVActivity paramAVActivity)
  {
    super(paramVideoAppInterface, paramAVActivity);
  }
  
  static boolean checkShowBeauty(VideoController paramVideoController, VideoAppInterface paramVideoAppInterface)
  {
    if ((paramVideoController.a().n) || (!paramVideoController.a().j) || (!mci.a(paramVideoAppInterface.getCurrentAccountUin())) || (!paramVideoController.a().o)) {}
    for (int i = 1; i == 0; i = 0) {
      return true;
    }
    return false;
  }
  
  protected mch getUIInfo()
  {
    if (this.mUIInfo == null)
    {
      this.mUIInfo = new mch();
      this.mUIInfo.d = 4;
      this.mUIInfo.f = 2131559782;
      this.mUIInfo.e = 2130841959;
      this.mUIInfo.a = this.mApp.getApp().getString(2131695302);
    }
    return this.mUIInfo;
  }
  
  public String getUnableInfo()
  {
    if (this.mActivity.get() != null) {
      return ((AVActivity)this.mActivity.get()).getResources().getString(2131694854);
    }
    return "";
  }
  
  public boolean isEffectBtnEnable()
  {
    return lgv.a(this.mContext);
  }
  
  protected void onCreate(long paramLong, AVActivity paramAVActivity)
  {
    this.mBeautySeekBar = ((RelativeLayout)this.toolbarView.findViewById(2131373644));
    this.mSeek = ((SeekBar)this.toolbarView.findViewById(2131373645));
    this.mTip = ((TextView)this.toolbarView.findViewById(2131373646));
    this.mTipLayoutParams = null;
    this.mContext = paramAVActivity;
    this.mThumb_0 = this.mContext.getResources().getDrawable(2130841920);
    this.mThumb_30 = this.mContext.getResources().getDrawable(2130841922);
    this.mThumb_60 = this.mContext.getResources().getDrawable(2130841923);
    this.mThumb_100 = this.mContext.getResources().getDrawable(2130841921);
    this.mSeek.setMax(100);
    this.mSeek.setOnSeekBarChangeListener(this.mOnSeekBarChangeListener);
    this.mSeek.getViewTreeObserver().addOnGlobalLayoutListener(new mck(this));
    if ((paramAVActivity instanceof AVActivity)) {
      this.mControlUI = paramAVActivity.a;
    }
    if (AudioHelper.a(0) == 1)
    {
      this.toolbarView.setBackgroundColor(-16711936);
      this.toolbarView.findViewById(2131373644).setBackgroundColor(-256);
      this.toolbarView.findViewById(2131373648).setBackgroundColor(-16711681);
      this.toolbarView.findViewById(2131373645).setBackgroundColor(-65281);
    }
    this.mBeautySeekBar.setVisibility(4);
  }
  
  public void onHide(long paramLong)
  {
    this.mBeautySeekBar.setVisibility(8);
    this.mIsShown = false;
    this.mApp.a("BEAUTY_SKIN", this.mBeautyValue, true);
    if (this.mBeautyValue > 0)
    {
      lff locallff = lcb.a().a();
      if (locallff != null) {
        locallff.u = true;
      }
    }
    this.mControlUI.C(paramLong);
  }
  
  public void onShow(long paramLong, int paramInt, boolean paramBoolean)
  {
    this.mIsShown = true;
    this.mIs1stShow = true;
    this.mBeautyValue = this.mApp.b("BEAUTY_SKIN");
    this.mSeek.setProgress(this.mBeautyValue);
    this.mControlUI.L();
    lpm locallpm = VideoController.a().a(((AVActivity)this.mActivity.get()).getApplicationContext());
    if (locallpm != null)
    {
      if (AudioHelper.f()) {
        QLog.w("BeautyToolbar", 1, "onShow, seq[" + paramLong + "]");
      }
      locallpm.a(paramLong);
      mbb.a(paramLong, this.mApp);
    }
  }
  
  public void updateTip(int paramInt)
  {
    if (this.mTipLayoutParams == null)
    {
      this.mTipLayoutParams = ((RelativeLayout.LayoutParams)this.mTip.getLayoutParams());
      this.mThumbWidth = this.mThumb_60.getIntrinsicWidth();
      this.mTipLayoutMargin = (((RelativeLayout.LayoutParams)this.mSeek.getLayoutParams()).leftMargin + this.mThumbWidth / 2);
    }
    this.mTip.setText(paramInt + "%");
    int i = this.mTip.getWidth();
    int j = this.mSeek.getWidth();
    this.mTipLayoutParams.leftMargin = (this.mTipLayoutMargin - i / 2 + (j - this.mThumbWidth) * paramInt / 100);
    this.mTip.requestLayout();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.ui.BeautyToolbar
 * JD-Core Version:    0.7.0.1
 */