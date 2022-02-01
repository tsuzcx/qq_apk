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
import com.tencent.av.SessionMgr;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.filter.EffectFilterTools;
import com.tencent.av.opengl.effects.EffectController;
import com.tencent.av.opengl.effects.EffectsRenderController;
import com.tencent.av.tips.TipsUtil;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class BeautyToolbar
  extends BaseToolbar
{
  static final String TAG = "BeautyToolbar";
  RelativeLayout mBeautySeekBar = null;
  int mBeautyValue = 0;
  Context mContext = null;
  private VideoControlUI mControlUI;
  boolean mIs1stShow = false;
  boolean mIsShown = false;
  SeekBar.OnSeekBarChangeListener mOnSeekBarChangeListener = new BeautyToolbar.1(this);
  SeekBar mSeek = null;
  int mThumbWidth;
  Drawable mThumb_0;
  Drawable mThumb_100;
  Drawable mThumb_30;
  Drawable mThumb_60;
  TextView mTip;
  int mTipLayoutMargin;
  RelativeLayout.LayoutParams mTipLayoutParams;
  BaseToolbar.UIInfo mUIInfo = null;
  
  public BeautyToolbar(VideoAppInterface paramVideoAppInterface, AVActivity paramAVActivity)
  {
    super(paramVideoAppInterface, paramAVActivity);
  }
  
  static boolean checkShowBeauty(VideoController paramVideoController, VideoAppInterface paramVideoAppInterface)
  {
    if ((paramVideoController.a().n) || (!paramVideoController.a().j) || (!BeautyConfigUtil.a(paramVideoAppInterface.getCurrentAccountUin())) || (!paramVideoController.a().o)) {}
    for (int i = 1; i == 0; i = 0) {
      return true;
    }
    return false;
  }
  
  protected BaseToolbar.UIInfo getUIInfo()
  {
    if (this.mUIInfo == null)
    {
      this.mUIInfo = new BaseToolbar.UIInfo();
      this.mUIInfo.d = 4;
      this.mUIInfo.g = 2131559897;
      this.mUIInfo.f = 2130842157;
      this.mUIInfo.a = this.mApp.getApp().getString(2131695901);
    }
    return this.mUIInfo;
  }
  
  public String getUnableInfo()
  {
    if (this.mActivity.get() != null) {
      return ((AVActivity)this.mActivity.get()).getResources().getString(2131695451);
    }
    return "";
  }
  
  public boolean isEffectBtnEnable()
  {
    return EffectFilterTools.a(this.mContext);
  }
  
  protected void onCreate(long paramLong, AVActivity paramAVActivity)
  {
    this.mBeautySeekBar = ((RelativeLayout)this.toolbarView.findViewById(2131374087));
    this.mSeek = ((SeekBar)this.toolbarView.findViewById(2131374088));
    this.mTip = ((TextView)this.toolbarView.findViewById(2131374089));
    this.mTipLayoutParams = null;
    this.mContext = paramAVActivity;
    this.mThumb_0 = this.mContext.getResources().getDrawable(2130842118);
    this.mThumb_30 = this.mContext.getResources().getDrawable(2130842120);
    this.mThumb_60 = this.mContext.getResources().getDrawable(2130842121);
    this.mThumb_100 = this.mContext.getResources().getDrawable(2130842119);
    this.mSeek.setMax(100);
    this.mSeek.setOnSeekBarChangeListener(this.mOnSeekBarChangeListener);
    this.mSeek.getViewTreeObserver().addOnGlobalLayoutListener(new BeautyToolbar.2(this));
    if ((paramAVActivity instanceof AVActivity)) {
      this.mControlUI = paramAVActivity.a;
    }
    if (AudioHelper.a(0) == 1)
    {
      this.toolbarView.setBackgroundColor(-16711936);
      this.toolbarView.findViewById(2131374087).setBackgroundColor(-256);
      this.toolbarView.findViewById(2131374091).setBackgroundColor(-16711681);
      this.toolbarView.findViewById(2131374088).setBackgroundColor(-65281);
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
      SessionInfo localSessionInfo = SessionMgr.a().a();
      if (localSessionInfo != null) {
        localSessionInfo.u = true;
      }
    }
    this.mControlUI.D(paramLong);
  }
  
  public void onShow(long paramLong, int paramInt, boolean paramBoolean)
  {
    this.mIsShown = true;
    this.mIs1stShow = true;
    this.mBeautyValue = this.mApp.b("BEAUTY_SKIN");
    this.mSeek.setProgress(this.mBeautyValue);
    this.mControlUI.N();
    EffectsRenderController localEffectsRenderController = VideoController.a().a(false);
    if (localEffectsRenderController != null)
    {
      if (AudioHelper.e()) {
        QLog.w("BeautyToolbar", 1, "onShow, seq[" + paramLong + "]");
      }
      localEffectsRenderController.a(paramLong);
    }
    TipsUtil.a(paramLong, this.mApp);
  }
  
  void updateTip(int paramInt)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.ui.BeautyToolbar
 * JD-Core Version:    0.7.0.1
 */