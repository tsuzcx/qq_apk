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
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import ksn;
import kvq;
import kxf;
import lfg;
import lfi;
import lqb;
import lrg;
import lrk;
import lrl;

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
  SeekBar.OnSeekBarChangeListener mOnSeekBarChangeListener = new lrk(this);
  public SeekBar mSeek = null;
  int mThumbWidth;
  public Drawable mThumb_0;
  public Drawable mThumb_100;
  public Drawable mThumb_30;
  public Drawable mThumb_60;
  TextView mTip;
  int mTipLayoutMargin;
  RelativeLayout.LayoutParams mTipLayoutParams;
  lrg mUIInfo = null;
  
  public BeautyToolbar(VideoAppInterface paramVideoAppInterface, AVActivity paramAVActivity)
  {
    super(paramVideoAppInterface, paramAVActivity);
  }
  
  static boolean checkShowBeauty(VideoController paramVideoController, VideoAppInterface paramVideoAppInterface)
  {
    if ((paramVideoController.a().m) || (!paramVideoController.a().j) || (!AVNotifyCenter.e(paramVideoAppInterface.getCurrentAccountUin())) || (!paramVideoController.a().n)) {}
    for (int i = 1; i == 0; i = 0) {
      return true;
    }
    return false;
  }
  
  protected lrg getUIInfo()
  {
    if (this.mUIInfo == null)
    {
      this.mUIInfo = new lrg();
      this.mUIInfo.d = 4;
      this.mUIInfo.f = 2131494016;
      this.mUIInfo.e = 2130841404;
      this.mUIInfo.a = this.mApp.getApp().getString(2131630500);
    }
    return this.mUIInfo;
  }
  
  public String getUnableInfo()
  {
    if (this.mActivity.get() != null) {
      return ((AVActivity)this.mActivity.get()).getResources().getString(2131630084);
    }
    return "";
  }
  
  public boolean isEffectBtnEnable()
  {
    return kxf.a(this.mContext);
  }
  
  protected void onCreate(long paramLong, AVActivity paramAVActivity)
  {
    this.mBeautySeekBar = ((RelativeLayout)this.toolbarView.findViewById(2131306811));
    this.mSeek = ((SeekBar)this.toolbarView.findViewById(2131306812));
    this.mTip = ((TextView)this.toolbarView.findViewById(2131306813));
    this.mTipLayoutParams = null;
    this.mContext = paramAVActivity;
    this.mThumb_0 = this.mContext.getResources().getDrawable(2130841366);
    this.mThumb_30 = this.mContext.getResources().getDrawable(2130841368);
    this.mThumb_60 = this.mContext.getResources().getDrawable(2130841369);
    this.mThumb_100 = this.mContext.getResources().getDrawable(2130841367);
    this.mSeek.setMax(100);
    this.mSeek.setOnSeekBarChangeListener(this.mOnSeekBarChangeListener);
    this.mSeek.getViewTreeObserver().addOnGlobalLayoutListener(new lrl(this));
    if ((paramAVActivity instanceof AVActivity)) {
      this.mControlUI = paramAVActivity.a;
    }
    if (AudioHelper.a(0) == 1)
    {
      this.toolbarView.setBackgroundColor(-16711936);
      this.toolbarView.findViewById(2131306811).setBackgroundColor(-256);
      this.toolbarView.findViewById(2131306815).setBackgroundColor(-16711681);
      this.toolbarView.findViewById(2131306812).setBackgroundColor(-65281);
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
      kvq localkvq = ksn.a().a();
      if (localkvq != null) {
        localkvq.t = true;
      }
    }
    this.mControlUI.y(paramLong);
  }
  
  public void onShow(long paramLong, int paramInt, boolean paramBoolean)
  {
    this.mIsShown = true;
    this.mIs1stShow = true;
    this.mBeautyValue = this.mApp.b("BEAUTY_SKIN");
    this.mSeek.setProgress(this.mBeautyValue);
    this.mControlUI.K();
    lfi locallfi = VideoController.a().a(((AVActivity)this.mActivity.get()).getApplicationContext());
    if (locallfi != null)
    {
      if (AudioHelper.e()) {
        QLog.w("BeautyToolbar", 1, "onShow, seq[" + paramLong + "]");
      }
      locallfi.a(paramLong);
      lqb.a(paramLong, this.mApp);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.av.ui.BeautyToolbar
 * JD-Core Version:    0.7.0.1
 */