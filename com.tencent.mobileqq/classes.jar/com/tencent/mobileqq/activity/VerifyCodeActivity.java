package com.tencent.mobileqq.activity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.qroute.route.annotation.RoutePage;
import com.tencent.mobileqq.widget.ClearableEditText;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqconnect.wtlogin.LoginHelper;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.manager.VerifyCodeManager;
import mqq.observer.ServerNotifyObserver;

@RoutePage(desc="验证码页面", path="/base/verifyCode")
public class VerifyCodeActivity
  extends IphoneTitleBarActivity
{
  private static final String TAG = "VerifyCodeActivity";
  final int MIN_VERIFY_CODE_LENGTH = 4;
  ClearableEditText ed;
  boolean isRefresh = false;
  boolean isSend;
  private AppInterface mApp = null;
  ImageView mVerifyCodeImageView;
  private TextView notestr;
  View.OnClickListener refreshListener = new VerifyCodeActivity.5(this);
  ServerNotifyObserver serverNotifyObserver = new VerifyCodeActivity.1(this);
  TextView tvRefresh;
  VerifyCodeManager verifyCodeManager;
  private View waitting;
  
  /* Error */
  private void init2(android.content.Intent paramIntent)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 74	com/tencent/mobileqq/activity/VerifyCodeActivity:initTitleBar	()V
    //   4: aconst_null
    //   5: astore 5
    //   7: aload_1
    //   8: ldc 76
    //   10: invokevirtual 82	android/content/Intent:getByteArrayExtra	(Ljava/lang/String;)[B
    //   13: astore_3
    //   14: aload_1
    //   15: ldc 84
    //   17: iconst_0
    //   18: invokevirtual 88	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   21: istore_2
    //   22: aload_1
    //   23: ldc 90
    //   25: invokevirtual 94	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   28: astore 4
    //   30: aload_1
    //   31: ldc 96
    //   33: invokevirtual 94	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   36: astore_1
    //   37: aload_1
    //   38: astore 5
    //   40: aload 4
    //   42: astore_1
    //   43: goto +40 -> 83
    //   46: astore 6
    //   48: aload 4
    //   50: astore_1
    //   51: aload 6
    //   53: astore 4
    //   55: goto +23 -> 78
    //   58: astore 4
    //   60: aconst_null
    //   61: astore_1
    //   62: goto +16 -> 78
    //   65: astore 4
    //   67: goto +7 -> 74
    //   70: astore 4
    //   72: aconst_null
    //   73: astore_3
    //   74: aconst_null
    //   75: astore_1
    //   76: iconst_0
    //   77: istore_2
    //   78: aload 4
    //   80: invokevirtual 99	java/lang/Exception:printStackTrace	()V
    //   83: aload 5
    //   85: invokestatic 105	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   88: ifne +12 -> 100
    //   91: aload_0
    //   92: getfield 107	com/tencent/mobileqq/activity/VerifyCodeActivity:notestr	Landroid/widget/TextView;
    //   95: aload 5
    //   97: invokevirtual 113	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   100: aload_1
    //   101: astore 4
    //   103: aload_1
    //   104: ifnonnull +7 -> 111
    //   107: ldc 115
    //   109: astore 4
    //   111: aload_3
    //   112: ifnull +17 -> 129
    //   115: aload_0
    //   116: getfield 117	com/tencent/mobileqq/activity/VerifyCodeActivity:mVerifyCodeImageView	Landroid/widget/ImageView;
    //   119: aload_3
    //   120: iconst_0
    //   121: aload_3
    //   122: arraylength
    //   123: invokestatic 123	com/tencent/mobileqq/util/BitmapManager:a	([BII)Landroid/graphics/Bitmap;
    //   126: invokevirtual 129	android/widget/ImageView:setImageBitmap	(Landroid/graphics/Bitmap;)V
    //   129: aload_0
    //   130: getfield 52	com/tencent/mobileqq/activity/VerifyCodeActivity:serverNotifyObserver	Lmqq/observer/ServerNotifyObserver;
    //   133: iload_2
    //   134: invokevirtual 135	mqq/observer/ServerNotifyObserver:setSeq	(I)V
    //   137: aload_0
    //   138: getfield 52	com/tencent/mobileqq/activity/VerifyCodeActivity:serverNotifyObserver	Lmqq/observer/ServerNotifyObserver;
    //   141: aload 4
    //   143: invokevirtual 139	mqq/observer/ServerNotifyObserver:setKey	(Ljava/lang/String;)V
    //   146: aload_0
    //   147: aload_0
    //   148: ldc 140
    //   150: invokevirtual 144	com/tencent/mobileqq/activity/VerifyCodeActivity:findViewById	(I)Landroid/view/View;
    //   153: checkcast 146	com/tencent/mobileqq/widget/ClearableEditText
    //   156: putfield 148	com/tencent/mobileqq/activity/VerifyCodeActivity:ed	Lcom/tencent/mobileqq/widget/ClearableEditText;
    //   159: aload_0
    //   160: getfield 148	com/tencent/mobileqq/activity/VerifyCodeActivity:ed	Lcom/tencent/mobileqq/widget/ClearableEditText;
    //   163: iconst_1
    //   164: invokevirtual 151	com/tencent/mobileqq/widget/ClearableEditText:setClearButtonStyle	(I)V
    //   167: aload_0
    //   168: getfield 148	com/tencent/mobileqq/activity/VerifyCodeActivity:ed	Lcom/tencent/mobileqq/widget/ClearableEditText;
    //   171: new 153	com/tencent/mobileqq/activity/VerifyCodeActivity$4
    //   174: dup
    //   175: aload_0
    //   176: invokespecial 154	com/tencent/mobileqq/activity/VerifyCodeActivity$4:<init>	(Lcom/tencent/mobileqq/activity/VerifyCodeActivity;)V
    //   179: invokevirtual 158	com/tencent/mobileqq/widget/ClearableEditText:addTextChangedListener	(Landroid/text/TextWatcher;)V
    //   182: aload_0
    //   183: aload_0
    //   184: ldc 159
    //   186: invokevirtual 144	com/tencent/mobileqq/activity/VerifyCodeActivity:findViewById	(I)Landroid/view/View;
    //   189: putfield 161	com/tencent/mobileqq/activity/VerifyCodeActivity:waitting	Landroid/view/View;
    //   192: aload_0
    //   193: aload_0
    //   194: ldc 162
    //   196: invokevirtual 144	com/tencent/mobileqq/activity/VerifyCodeActivity:findViewById	(I)Landroid/view/View;
    //   199: checkcast 109	android/widget/TextView
    //   202: putfield 164	com/tencent/mobileqq/activity/VerifyCodeActivity:tvRefresh	Landroid/widget/TextView;
    //   205: aload_0
    //   206: aload_0
    //   207: getfield 45	com/tencent/mobileqq/activity/VerifyCodeActivity:mApp	Lcom/tencent/common/app/AppInterface;
    //   210: bipush 6
    //   212: invokevirtual 170	com/tencent/common/app/AppInterface:getManager	(I)Lmqq/manager/Manager;
    //   215: checkcast 172	mqq/manager/VerifyCodeManager
    //   218: putfield 174	com/tencent/mobileqq/activity/VerifyCodeActivity:verifyCodeManager	Lmqq/manager/VerifyCodeManager;
    //   221: aload_0
    //   222: getfield 164	com/tencent/mobileqq/activity/VerifyCodeActivity:tvRefresh	Landroid/widget/TextView;
    //   225: aload_0
    //   226: getfield 57	com/tencent/mobileqq/activity/VerifyCodeActivity:refreshListener	Landroid/view/View$OnClickListener;
    //   229: invokevirtual 178	android/widget/TextView:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   232: aload_0
    //   233: getfield 117	com/tencent/mobileqq/activity/VerifyCodeActivity:mVerifyCodeImageView	Landroid/widget/ImageView;
    //   236: aload_0
    //   237: getfield 57	com/tencent/mobileqq/activity/VerifyCodeActivity:refreshListener	Landroid/view/View$OnClickListener;
    //   240: invokevirtual 179	android/widget/ImageView:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   243: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	244	0	this	VerifyCodeActivity
    //   0	244	1	paramIntent	android.content.Intent
    //   21	113	2	i	int
    //   13	109	3	arrayOfByte	byte[]
    //   28	26	4	localObject1	Object
    //   58	1	4	localException1	java.lang.Exception
    //   65	1	4	localException2	java.lang.Exception
    //   70	9	4	localException3	java.lang.Exception
    //   101	41	4	localObject2	Object
    //   5	91	5	localIntent	android.content.Intent
    //   46	6	6	localException4	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   30	37	46	java/lang/Exception
    //   22	30	58	java/lang/Exception
    //   14	22	65	java/lang/Exception
    //   7	14	70	java/lang/Exception
  }
  
  private void initTitleBar()
  {
    setTitle(2131917818);
    setLeftButton(2131887648, new VerifyCodeActivity.2(this));
    setRightHighlightButton(2131889474, new VerifyCodeActivity.3(this));
  }
  
  void cancelVerifyDialog()
  {
    QLog.d("VerifyCodeActivity", 1, "cancelVerifyDialog");
    VerifyCodeManager localVerifyCodeManager = this.verifyCodeManager;
    if (localVerifyCodeManager != null) {
      localVerifyCodeManager.cancelVerifyCode(this.serverNotifyObserver);
    }
    finish();
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.mApp = this.app;
    if (this.mApp == null) {
      this.mApp = ((AppInterface)getAppRuntime());
    }
    paramBundle = super.getIntent();
    if (paramBundle == null)
    {
      super.finish();
      return false;
    }
    super.setContentView(2131629627);
    setContentBackgroundResource(2130838958);
    this.mVerifyCodeImageView = ((ImageView)findViewById(2131449345));
    this.notestr = ((TextView)findViewById(2131439423));
    init2(paramBundle);
    LoginHelper.a(this.mApp);
    return true;
  }
  
  public boolean doOnKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4) {
      cancelVerifyDialog();
    }
    return super.doOnKeyDown(paramInt, paramKeyEvent);
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  void refreshVerifyCode()
  {
    this.isRefresh = true;
    this.isSend = false;
    showWaitting(true);
    VerifyCodeManager localVerifyCodeManager = this.verifyCodeManager;
    if (localVerifyCodeManager != null) {
      localVerifyCodeManager.refreVerifyCode(this.serverNotifyObserver);
    }
  }
  
  void sendVerifyCode(String paramString)
  {
    QLog.d("VerifyCodeActivity", 1, "sendVerifyCode");
    this.isSend = true;
    showWaitting(true);
    VerifyCodeManager localVerifyCodeManager = this.verifyCodeManager;
    if (localVerifyCodeManager != null) {
      localVerifyCodeManager.submitVerifyCode(this.serverNotifyObserver, paramString);
    }
  }
  
  void showWaitting(boolean paramBoolean)
  {
    QLog.d("VerifyCodeActivity", 1, new Object[] { "showWaitting isShow=", Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      this.waitting.setVisibility(0);
      this.mVerifyCodeImageView.setVisibility(8);
      return;
    }
    this.waitting.setVisibility(8);
    this.mVerifyCodeImageView.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.VerifyCodeActivity
 * JD-Core Version:    0.7.0.1
 */