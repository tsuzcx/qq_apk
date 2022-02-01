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
import com.tencent.av.utils.AudioHelper;
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
    int i;
    if ((!paramVideoController.a().n) && (paramVideoController.a().j) && (BeautyConfigUtil.a(paramVideoAppInterface.getCurrentAccountUin())) && (paramVideoController.a().o)) {
      i = 0;
    } else {
      i = 1;
    }
    return i ^ 0x1;
  }
  
  protected BaseToolbar.UIInfo getUIInfo()
  {
    if (this.mUIInfo == null)
    {
      this.mUIInfo = new BaseToolbar.UIInfo();
      BaseToolbar.UIInfo localUIInfo = this.mUIInfo;
      localUIInfo.d = 4;
      localUIInfo.g = 2131559768;
      localUIInfo.f = 2130842055;
      localUIInfo.a = this.mApp.getApp().getString(2131695916);
    }
    return this.mUIInfo;
  }
  
  public String getUnableInfo()
  {
    if (this.mActivity.get() != null) {
      return ((AVActivity)this.mActivity.get()).getResources().getString(2131695462);
    }
    return "";
  }
  
  public boolean isEffectBtnEnable()
  {
    return EffectFilterTools.a(this.mContext);
  }
  
  protected void onCreate(long paramLong, AVActivity paramAVActivity)
  {
    this.mBeautySeekBar = ((RelativeLayout)this.toolbarView.findViewById(2131373642));
    this.mSeek = ((SeekBar)this.toolbarView.findViewById(2131373643));
    this.mTip = ((TextView)this.toolbarView.findViewById(2131373644));
    this.mTipLayoutParams = null;
    this.mContext = paramAVActivity;
    this.mThumb_0 = this.mContext.getResources().getDrawable(2130842015);
    this.mThumb_30 = this.mContext.getResources().getDrawable(2130842017);
    this.mThumb_60 = this.mContext.getResources().getDrawable(2130842018);
    this.mThumb_100 = this.mContext.getResources().getDrawable(2130842016);
    this.mSeek.setMax(100);
    this.mSeek.setOnSeekBarChangeListener(this.mOnSeekBarChangeListener);
    this.mSeek.getViewTreeObserver().addOnGlobalLayoutListener(new BeautyToolbar.2(this));
    if ((paramAVActivity instanceof AVActivity)) {
      this.mControlUI = paramAVActivity.a;
    }
    if (AudioHelper.a(0) == 1)
    {
      this.toolbarView.setBackgroundColor(-16711936);
      this.toolbarView.findViewById(2131373642).setBackgroundColor(-256);
      this.toolbarView.findViewById(2131373646).setBackgroundColor(-16711681);
      this.toolbarView.findViewById(2131373643).setBackgroundColor(-65281);
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
        localSessionInfo.t = true;
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
    this.mControlUI.N();
    EffectsRenderController localEffectsRenderController = VideoController.a().a(false);
    if (localEffectsRenderController != null)
    {
      if (AudioHelper.b())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onShow, seq[");
        localStringBuilder.append(paramLong);
        localStringBuilder.append("]");
        QLog.w("BeautyToolbar", 1, localStringBuilder.toString());
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
    TextView localTextView = this.mTip;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt);
    localStringBuilder.append("%");
    localTextView.setText(localStringBuilder.toString());
    int i = this.mTip.getWidth();
    int j = this.mSeek.getWidth();
    this.mTipLayoutParams.leftMargin = (this.mTipLayoutMargin - i / 2 + (j - this.mThumbWidth) * paramInt / 100);
    this.mTip.requestLayout();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.BeautyToolbar
 * JD-Core Version:    0.7.0.1
 */