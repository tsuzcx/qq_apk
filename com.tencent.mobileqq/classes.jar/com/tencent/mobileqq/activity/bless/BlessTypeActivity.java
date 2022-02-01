package com.tencent.mobileqq.activity.bless;

import android.app.Dialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import com.tencent.aelight.camera.download.api.AEResInfo;
import com.tencent.aelight.camera.download.api.IAEResUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.audiopanel.PressToChangeVoicePanel;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.pttlogic.api.IPttUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.shortvideo.util.PtvFilterSoLoad;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.AudioUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQAudioHelper;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class BlessTypeActivity
  extends BaseActivity
  implements View.OnClickListener, View.OnTouchListener
{
  private static boolean b = false;
  protected float a;
  protected View a;
  protected BlessManager a;
  private boolean a;
  protected int c;
  
  public BlessTypeActivity()
  {
    this.jdField_a_of_type_Boolean = true;
  }
  
  /* Error */
  private void a()
  {
    // Byte code:
    //   0: aload_0
    //   1: ldc 30
    //   3: invokevirtual 34	com/tencent/mobileqq/activity/bless/BlessTypeActivity:findViewById	(I)Landroid/view/View;
    //   6: checkcast 36	com/tencent/widget/immersive/ImmersiveTitleBar2
    //   9: iconst_4
    //   10: invokevirtual 40	com/tencent/widget/immersive/ImmersiveTitleBar2:setVisibility	(I)V
    //   13: aload_0
    //   14: aload_0
    //   15: ldc 41
    //   17: invokevirtual 34	com/tencent/mobileqq/activity/bless/BlessTypeActivity:findViewById	(I)Landroid/view/View;
    //   20: putfield 43	com/tencent/mobileqq/activity/bless/BlessTypeActivity:jdField_a_of_type_AndroidViewView	Landroid/view/View;
    //   23: aload_0
    //   24: ldc 44
    //   26: invokevirtual 34	com/tencent/mobileqq/activity/bless/BlessTypeActivity:findViewById	(I)Landroid/view/View;
    //   29: aload_0
    //   30: invokevirtual 50	android/view/View:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   33: aload_0
    //   34: ldc 51
    //   36: invokevirtual 34	com/tencent/mobileqq/activity/bless/BlessTypeActivity:findViewById	(I)Landroid/view/View;
    //   39: aload_0
    //   40: invokevirtual 50	android/view/View:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   43: aload_0
    //   44: ldc 52
    //   46: invokevirtual 34	com/tencent/mobileqq/activity/bless/BlessTypeActivity:findViewById	(I)Landroid/view/View;
    //   49: astore_3
    //   50: aload_0
    //   51: aload_0
    //   52: getfield 54	com/tencent/mobileqq/activity/bless/BlessTypeActivity:jdField_a_of_type_ComTencentMobileqqActivityBlessBlessManager	Lcom/tencent/mobileqq/activity/bless/BlessManager;
    //   55: invokevirtual 60	com/tencent/mobileqq/activity/bless/BlessManager:e	()Z
    //   58: putfield 25	com/tencent/mobileqq/activity/bless/BlessTypeActivity:jdField_a_of_type_Boolean	Z
    //   61: aload_0
    //   62: getfield 54	com/tencent/mobileqq/activity/bless/BlessTypeActivity:jdField_a_of_type_ComTencentMobileqqActivityBlessBlessManager	Lcom/tencent/mobileqq/activity/bless/BlessManager;
    //   65: invokevirtual 63	com/tencent/mobileqq/activity/bless/BlessManager:f	()Z
    //   68: ifne +11 -> 79
    //   71: aload_3
    //   72: aload_0
    //   73: invokevirtual 50	android/view/View:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   76: goto +9 -> 85
    //   79: aload_3
    //   80: bipush 8
    //   82: invokevirtual 64	android/view/View:setVisibility	(I)V
    //   85: aload_0
    //   86: ldc 65
    //   88: invokevirtual 34	com/tencent/mobileqq/activity/bless/BlessTypeActivity:findViewById	(I)Landroid/view/View;
    //   91: checkcast 67	android/widget/ImageView
    //   94: astore 6
    //   96: invokestatic 71	com/tencent/mobileqq/activity/bless/BlessManager:g	()I
    //   99: istore_1
    //   100: iload_1
    //   101: i2f
    //   102: aload_0
    //   103: getfield 73	com/tencent/mobileqq/activity/bless/BlessTypeActivity:jdField_a_of_type_Float	F
    //   106: fmul
    //   107: f2i
    //   108: istore_2
    //   109: aload 6
    //   111: invokevirtual 77	android/widget/ImageView:getLayoutParams	()Landroid/view/ViewGroup$LayoutParams;
    //   114: iload_2
    //   115: putfield 82	android/view/ViewGroup$LayoutParams:height	I
    //   118: aload 6
    //   120: invokevirtual 85	android/widget/ImageView:requestLayout	()V
    //   123: invokestatic 90	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   126: ifeq +47 -> 173
    //   129: new 92	java/lang/StringBuilder
    //   132: dup
    //   133: invokespecial 93	java/lang/StringBuilder:<init>	()V
    //   136: astore_3
    //   137: aload_3
    //   138: ldc 95
    //   140: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   143: pop
    //   144: aload_3
    //   145: iload_1
    //   146: invokevirtual 102	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   149: pop
    //   150: aload_3
    //   151: ldc 104
    //   153: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   156: pop
    //   157: aload_3
    //   158: iload_2
    //   159: invokevirtual 102	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   162: pop
    //   163: ldc 106
    //   165: iconst_2
    //   166: aload_3
    //   167: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   170: invokestatic 114	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   173: aload_0
    //   174: getfield 54	com/tencent/mobileqq/activity/bless/BlessTypeActivity:jdField_a_of_type_ComTencentMobileqqActivityBlessBlessManager	Lcom/tencent/mobileqq/activity/bless/BlessManager;
    //   177: aload_0
    //   178: getfield 116	com/tencent/mobileqq/activity/bless/BlessTypeActivity:c	I
    //   181: invokevirtual 119	com/tencent/mobileqq/activity/bless/BlessManager:a	(I)Ljava/lang/String;
    //   184: astore 7
    //   186: aload 7
    //   188: ifnull +164 -> 352
    //   191: aconst_null
    //   192: astore 5
    //   194: aconst_null
    //   195: astore_3
    //   196: new 121	java/io/FileInputStream
    //   199: dup
    //   200: aload 7
    //   202: invokespecial 124	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   205: astore 4
    //   207: new 126	android/graphics/BitmapFactory$Options
    //   210: dup
    //   211: invokespecial 127	android/graphics/BitmapFactory$Options:<init>	()V
    //   214: astore_3
    //   215: aload_3
    //   216: aload 4
    //   218: iload_1
    //   219: iload_2
    //   220: invokestatic 132	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/io/InputStream;II)D
    //   223: d2i
    //   224: putfield 135	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   227: aload 7
    //   229: aload_3
    //   230: invokestatic 140	com/tencent/mobileqq/util/BitmapManager:a	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   233: astore_3
    //   234: aload_3
    //   235: ifnull +9 -> 244
    //   238: aload 6
    //   240: aload_3
    //   241: invokevirtual 144	android/widget/ImageView:setImageBitmap	(Landroid/graphics/Bitmap;)V
    //   244: aload 4
    //   246: invokevirtual 149	java/io/InputStream:close	()V
    //   249: return
    //   250: invokestatic 90	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   253: ifeq +99 -> 352
    //   256: ldc 106
    //   258: iconst_2
    //   259: ldc 151
    //   261: invokestatic 153	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   264: return
    //   265: astore_3
    //   266: goto +57 -> 323
    //   269: goto +14 -> 283
    //   272: astore 5
    //   274: aload_3
    //   275: astore 4
    //   277: aload 5
    //   279: astore_3
    //   280: goto +43 -> 323
    //   283: aload 4
    //   285: astore_3
    //   286: invokestatic 90	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   289: ifeq +14 -> 303
    //   292: aload 4
    //   294: astore_3
    //   295: ldc 106
    //   297: iconst_2
    //   298: ldc 155
    //   300: invokestatic 153	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   303: aload 4
    //   305: ifnull +47 -> 352
    //   308: aload 4
    //   310: invokevirtual 149	java/io/InputStream:close	()V
    //   313: return
    //   314: invokestatic 90	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   317: ifeq +35 -> 352
    //   320: goto -64 -> 256
    //   323: aload 4
    //   325: ifnull +25 -> 350
    //   328: aload 4
    //   330: invokevirtual 149	java/io/InputStream:close	()V
    //   333: goto +17 -> 350
    //   336: invokestatic 90	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   339: ifeq +11 -> 350
    //   342: ldc 106
    //   344: iconst_2
    //   345: ldc 151
    //   347: invokestatic 153	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   350: aload_3
    //   351: athrow
    //   352: return
    //   353: astore_3
    //   354: aload 5
    //   356: astore 4
    //   358: goto -75 -> 283
    //   361: astore_3
    //   362: goto -93 -> 269
    //   365: astore_3
    //   366: goto -116 -> 250
    //   369: astore_3
    //   370: goto -56 -> 314
    //   373: astore 4
    //   375: goto -39 -> 336
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	378	0	this	BlessTypeActivity
    //   99	120	1	i	int
    //   108	112	2	j	int
    //   49	192	3	localObject1	Object
    //   265	10	3	localObject2	Object
    //   279	72	3	localObject3	Object
    //   353	1	3	localFileNotFoundException1	java.io.FileNotFoundException
    //   361	1	3	localFileNotFoundException2	java.io.FileNotFoundException
    //   365	1	3	localException1	java.lang.Exception
    //   369	1	3	localException2	java.lang.Exception
    //   205	152	4	localObject4	Object
    //   373	1	4	localException3	java.lang.Exception
    //   192	1	5	localObject5	Object
    //   272	83	5	localObject6	Object
    //   94	145	6	localImageView	android.widget.ImageView
    //   184	44	7	str	String
    // Exception table:
    //   from	to	target	type
    //   207	234	265	finally
    //   238	244	265	finally
    //   196	207	272	finally
    //   286	292	272	finally
    //   295	303	272	finally
    //   196	207	353	java/io/FileNotFoundException
    //   207	234	361	java/io/FileNotFoundException
    //   238	244	361	java/io/FileNotFoundException
    //   244	249	365	java/lang/Exception
    //   308	313	369	java/lang/Exception
    //   328	333	373	java/lang/Exception
  }
  
  public boolean a()
  {
    if (ShortVideoUtils.isVideoSoLibLoaded()) {
      return true;
    }
    ShortVideoUtils.loadShortVideoSo(this.app);
    return ShortVideoUtils.isVideoSoLibLoaded();
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 != 102) {
      return;
    }
    if (paramInt2 == -1) {
      finish();
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    this.mActNeedImmersive = false;
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessManager = ((BlessManager)this.app.getManager(QQManagerFactory.SEND_BLESS_CONFIG_MANAGER));
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
  }
  
  protected void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    if (QLog.isColorLevel()) {
      QLog.d("BlessTyeActivity", 2, "onNewIntent");
    }
  }
  
  protected void doOnPostCreate(Bundle paramBundle)
  {
    super.doOnPostCreate(paramBundle);
    a();
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    Object localObject;
    if (i != 2131364007)
    {
      if (i != 2131364094)
      {
        if (i == 2131369202) {
          onBackEvent();
        }
      }
      else if (this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessManager.f() <= 0)
      {
        QQToast.a(this, String.format(getString(2131690685), new Object[] { Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessManager.e()) }), 0).a();
      }
      else
      {
        localObject = new Intent(this, BlessSendTextActivity.class);
        ((Intent)localObject).putExtra("param_ptv_enable", this.jdField_a_of_type_Boolean);
        startActivity((Intent)localObject);
        overridePendingTransition(2130772011, 2130772015);
        ReportController.b(this.app, "CliOper", "", "", "0X800618D", "0X800618D", 0, 0, "", "", "", "");
      }
    }
    else if (this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessManager.f() <= 0)
    {
      QQToast.a(this, String.format(getString(2131690685), new Object[] { Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessManager.e()) }), 0).a();
    }
    else if (!this.jdField_a_of_type_Boolean)
    {
      QQToast.a(BaseApplication.getContext(), getString(2131690666), 0).a();
    }
    else if (this.app.isVideoChatting())
    {
      QQToast.a(BaseApplication.getContext(), 2131695163, 0).a();
    }
    else if (AudioUtil.a(0))
    {
      ChatActivityUtils.a(this);
    }
    else if (AudioUtil.a(1))
    {
      ((IPttUtils)QRoute.api(IPttUtils.class)).showDialogAboutMeizuRecordPermission(this);
    }
    else if (QQAudioHelper.a(0))
    {
      DialogUtil.a(this, 230, getString(2131698511), getString(2131698513), new BlessTypeActivity.1(this), null).show();
    }
    else
    {
      boolean bool2 = PtvFilterSoLoad.a(this.app, BaseApplicationImpl.getContext());
      if (a()) {
        if (!bool2)
        {
          i = ((IAEResUtil)QRoute.api(IAEResUtil.class)).getAEResStatus(AEResInfo.AE_RES_BASE_PACKAGE);
          localObject = (IAEResUtil)QRoute.api(IAEResUtil.class);
          if (i != 0) {}
        }
        else
        {
          bool1 = true;
          break label412;
        }
      }
      boolean bool1 = false;
      label412:
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("bless_ptv press, filterOK=");
      ((StringBuilder)localObject).append(bool2);
      ((StringBuilder)localObject).append(",videoAndSoReady:");
      ((StringBuilder)localObject).append(bool1);
      QLog.i("BlessTyeActivity", 2, ((StringBuilder)localObject).toString());
      if ((bool1) && (!b))
      {
        PressToChangeVoicePanel.a(this.app, false, "0X8006385");
        b = true;
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.bless.BlessTypeActivity
 * JD-Core Version:    0.7.0.1
 */