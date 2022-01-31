package com.tencent.mobileqq.activity.qwallet.widget;

import android.app.Activity;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.graphics.drawable.ColorDrawable;
import android.view.Window;
import com.tencent.mobileqq.activity.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.widget.AnimationView;
import com.tencent.mobileqq.widget.AnimationView.AnimationInfo;
import com.tencent.widget.immersive.ImmersiveUtils;

public class QWalletAnimDialog
  extends Dialog
{
  public static final String ACTION_FACE_TO_FACE = "qwallet.facetoface";
  protected Activity mActivity;
  private AnimationView.AnimationInfo mAnimInfo;
  private AnimationView mAnimationView;
  private BroadcastReceiver mBroadcastReceiver = new QWalletAnimDialog.2(this);
  protected boolean mIsFirstRepeated;
  protected String mNickName;
  protected long mReportSeq;
  protected String mUin;
  protected String mUrl;
  
  public QWalletAnimDialog(Activity paramActivity, int paramInt, AnimationView.AnimationInfo paramAnimationInfo, long paramLong)
  {
    super(paramActivity, paramInt);
    this.mAnimInfo = paramAnimationInfo;
    this.mReportSeq = paramLong;
    this.mActivity = paramActivity;
    init();
  }
  
  private void init()
  {
    super.requestWindowFeature(1);
    Object localObject = getWindow();
    setContentView(2130971042);
    ((Window)localObject).setLayout(-1, -1);
    ((Window)localObject).setBackgroundDrawable(new ColorDrawable(0));
    if (ImmersiveUtils.isSupporImmersive() == 1) {
      ((Window)localObject).addFlags(67108864);
    }
    setCanceledOnTouchOutside(false);
    this.mAnimationView = ((AnimationView)findViewById(2131372717));
    this.mAnimationView.setAnimationFromInfo(this.mAnimInfo);
    this.mAnimationView.setAnimationListener(new QWalletAnimDialog.1(this));
    localObject = new IntentFilter();
    ((IntentFilter)localObject).addAction("qwallet.facetoface");
    getContext().registerReceiver(this.mBroadcastReceiver, (IntentFilter)localObject);
  }
  
  public void dismiss()
  {
    super.dismiss();
    getContext().unregisterReceiver(this.mBroadcastReceiver);
    this.mAnimationView.stop();
    this.mAnimationView.setImageDrawable(null);
    if (this.mAnimInfo != null)
    {
      this.mAnimInfo.destoryBitmaps();
      this.mAnimInfo = null;
    }
    this.mActivity = null;
    VACDReportUtil.a(this.mReportSeq, null, "animDialogDismiss", null, 0, null);
  }
  
  public void setF2fRedpackInfo(String paramString1, String paramString2, String paramString3)
  {
    this.mUin = paramString1;
    this.mNickName = paramString2;
    this.mUrl = paramString3;
  }
  
  public void show()
  {
    super.show();
    this.mAnimationView.play();
    VACDReportUtil.a(this.mReportSeq, null, "animDialogShow", null, 0, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.widget.QWalletAnimDialog
 * JD-Core Version:    0.7.0.1
 */