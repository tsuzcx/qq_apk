package com.tencent.av.ui.effect.toolbar.oldversion;

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
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.BeautyConfigUtil;
import com.tencent.av.ui.VideoControlUI;
import com.tencent.av.ui.effect.toolbar.BaseToolbar.UIInfo;
import com.tencent.av.utils.AudioHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class BeautyToolbar
  extends BaseToolbarOldVersion
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
  
  public static boolean checkShowBeauty(VideoController paramVideoController, VideoAppInterface paramVideoAppInterface)
  {
    int i;
    if ((!paramVideoController.k().M) && (paramVideoController.k().H) && (BeautyConfigUtil.a(paramVideoAppInterface.getCurrentAccountUin())) && (paramVideoController.k().N)) {
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
      localUIInfo.h = 2131625810;
      localUIInfo.f = 2130842979;
      localUIInfo.g = this.mApp.getApp().getString(2131893678);
    }
    return this.mUIInfo;
  }
  
  public String getUnableInfo()
  {
    if (this.mActivity.get() != null) {
      return ((AVActivity)this.mActivity.get()).getResources().getString(2131893217);
    }
    return "";
  }
  
  public boolean isEffectBtnEnable()
  {
    return true ^ isOpenAvatar2D(true);
  }
  
  public boolean isEffectBtnNormal()
  {
    return (!isOpenAvatar2D(true)) && (EffectFilterTools.a(this.mContext));
  }
  
  protected void onCreate(long paramLong, AVActivity paramAVActivity)
  {
    this.mBeautySeekBar = ((RelativeLayout)this.toolbarView.findViewById(2131441312));
    this.mSeek = ((SeekBar)this.toolbarView.findViewById(2131441313));
    this.mTip = ((TextView)this.toolbarView.findViewById(2131441314));
    this.mTipLayoutParams = null;
    this.mContext = paramAVActivity;
    this.mThumb_0 = this.mContext.getResources().getDrawable(2130842932);
    this.mThumb_30 = this.mContext.getResources().getDrawable(2130842934);
    this.mThumb_60 = this.mContext.getResources().getDrawable(2130842935);
    this.mThumb_100 = this.mContext.getResources().getDrawable(2130842933);
    this.mSeek.setMax(100);
    this.mSeek.setOnSeekBarChangeListener(this.mOnSeekBarChangeListener);
    this.mSeek.getViewTreeObserver().addOnGlobalLayoutListener(new BeautyToolbar.2(this));
    if ((paramAVActivity instanceof AVActivity)) {
      this.mControlUI = paramAVActivity.K;
    }
    if (AudioHelper.a(0) == 1)
    {
      this.toolbarView.setBackgroundColor(-16711936);
      this.toolbarView.findViewById(2131441312).setBackgroundColor(-256);
      this.toolbarView.findViewById(2131441316).setBackgroundColor(-16711681);
      this.toolbarView.findViewById(2131441313).setBackgroundColor(-65281);
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
      SessionInfo localSessionInfo = SessionMgr.a().b();
      if (localSessionInfo != null) {
        localSessionInfo.S = true;
      }
    }
    this.mControlUI.I(paramLong);
  }
  
  public void onShow(long paramLong, int paramInt, boolean paramBoolean)
  {
    this.mIsShown = true;
    this.mIs1stShow = true;
    this.mBeautyValue = this.mApp.n("BEAUTY_SKIN");
    this.mSeek.setProgress(this.mBeautyValue);
    this.mControlUI.ai();
    EffectsRenderController localEffectsRenderController = VideoController.f().m(false);
    if (localEffectsRenderController != null)
    {
      if (AudioHelper.e())
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
 * Qualified Name:     com.tencent.av.ui.effect.toolbar.oldversion.BeautyToolbar
 * JD-Core Version:    0.7.0.1
 */