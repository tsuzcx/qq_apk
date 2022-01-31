package com.tencent.mobileqq.activity.bless;

import afaz;
import afbb;
import afbt;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import axlc;
import axqw;
import bbcv;
import bcpw;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.audiopanel.PressToChangeVoicePanel;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class BlessTypeActivity
  extends BaseActivity
  implements View.OnClickListener, View.OnTouchListener
{
  private static boolean b;
  protected float a;
  public afaz a;
  protected View a;
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
    //   1: ldc 28
    //   3: invokevirtual 32	com/tencent/mobileqq/activity/bless/BlessTypeActivity:findViewById	(I)Landroid/view/View;
    //   6: checkcast 34	com/tencent/widget/immersive/ImmersiveTitleBar2
    //   9: iconst_4
    //   10: invokevirtual 38	com/tencent/widget/immersive/ImmersiveTitleBar2:setVisibility	(I)V
    //   13: aload_0
    //   14: aload_0
    //   15: ldc 39
    //   17: invokevirtual 32	com/tencent/mobileqq/activity/bless/BlessTypeActivity:findViewById	(I)Landroid/view/View;
    //   20: putfield 41	com/tencent/mobileqq/activity/bless/BlessTypeActivity:jdField_a_of_type_AndroidViewView	Landroid/view/View;
    //   23: aload_0
    //   24: ldc 42
    //   26: invokevirtual 32	com/tencent/mobileqq/activity/bless/BlessTypeActivity:findViewById	(I)Landroid/view/View;
    //   29: aload_0
    //   30: invokevirtual 48	android/view/View:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   33: aload_0
    //   34: ldc 49
    //   36: invokevirtual 32	com/tencent/mobileqq/activity/bless/BlessTypeActivity:findViewById	(I)Landroid/view/View;
    //   39: aload_0
    //   40: invokevirtual 48	android/view/View:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   43: aload_0
    //   44: ldc 50
    //   46: invokevirtual 32	com/tencent/mobileqq/activity/bless/BlessTypeActivity:findViewById	(I)Landroid/view/View;
    //   49: astore_3
    //   50: aload_0
    //   51: aload_0
    //   52: getfield 52	com/tencent/mobileqq/activity/bless/BlessTypeActivity:jdField_a_of_type_Afaz	Lafaz;
    //   55: invokevirtual 58	afaz:e	()Z
    //   58: putfield 22	com/tencent/mobileqq/activity/bless/BlessTypeActivity:jdField_a_of_type_Boolean	Z
    //   61: aload_0
    //   62: getfield 52	com/tencent/mobileqq/activity/bless/BlessTypeActivity:jdField_a_of_type_Afaz	Lafaz;
    //   65: invokevirtual 61	afaz:f	()Z
    //   68: ifne +165 -> 233
    //   71: aload_3
    //   72: aload_0
    //   73: invokevirtual 48	android/view/View:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   76: aload_0
    //   77: ldc 62
    //   79: invokevirtual 32	com/tencent/mobileqq/activity/bless/BlessTypeActivity:findViewById	(I)Landroid/view/View;
    //   82: checkcast 64	android/widget/ImageView
    //   85: astore_3
    //   86: invokestatic 68	afaz:g	()I
    //   89: istore_1
    //   90: iload_1
    //   91: i2f
    //   92: aload_0
    //   93: getfield 70	com/tencent/mobileqq/activity/bless/BlessTypeActivity:jdField_a_of_type_Float	F
    //   96: fmul
    //   97: f2i
    //   98: istore_2
    //   99: aload_3
    //   100: invokevirtual 74	android/widget/ImageView:getLayoutParams	()Landroid/view/ViewGroup$LayoutParams;
    //   103: iload_2
    //   104: putfield 79	android/view/ViewGroup$LayoutParams:height	I
    //   107: aload_3
    //   108: invokevirtual 82	android/widget/ImageView:requestLayout	()V
    //   111: invokestatic 87	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   114: ifeq +37 -> 151
    //   117: ldc 89
    //   119: iconst_2
    //   120: new 91	java/lang/StringBuilder
    //   123: dup
    //   124: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   127: ldc 94
    //   129: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: iload_1
    //   133: invokevirtual 101	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   136: ldc 103
    //   138: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   141: iload_2
    //   142: invokevirtual 101	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   145: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   148: invokestatic 111	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   151: aload_0
    //   152: getfield 52	com/tencent/mobileqq/activity/bless/BlessTypeActivity:jdField_a_of_type_Afaz	Lafaz;
    //   155: aload_0
    //   156: getfield 113	com/tencent/mobileqq/activity/bless/BlessTypeActivity:c	I
    //   159: invokevirtual 116	afaz:a	(I)Ljava/lang/String;
    //   162: astore 5
    //   164: aload 5
    //   166: ifnull +66 -> 232
    //   169: new 118	java/io/FileInputStream
    //   172: dup
    //   173: aload 5
    //   175: invokespecial 121	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   178: astore 4
    //   180: new 123	android/graphics/BitmapFactory$Options
    //   183: dup
    //   184: invokespecial 124	android/graphics/BitmapFactory$Options:<init>	()V
    //   187: astore 6
    //   189: aload 6
    //   191: aload 4
    //   193: iload_1
    //   194: iload_2
    //   195: invokestatic 129	bbdr:a	(Ljava/io/InputStream;II)D
    //   198: d2i
    //   199: putfield 132	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   202: aload 5
    //   204: aload 6
    //   206: invokestatic 137	bawu:a	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   209: astore 5
    //   211: aload 5
    //   213: ifnull +9 -> 222
    //   216: aload_3
    //   217: aload 5
    //   219: invokevirtual 141	android/widget/ImageView:setImageBitmap	(Landroid/graphics/Bitmap;)V
    //   222: aload 4
    //   224: ifnull +8 -> 232
    //   227: aload 4
    //   229: invokevirtual 146	java/io/InputStream:close	()V
    //   232: return
    //   233: aload_3
    //   234: bipush 8
    //   236: invokevirtual 147	android/view/View:setVisibility	(I)V
    //   239: goto -163 -> 76
    //   242: astore_3
    //   243: invokestatic 87	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   246: ifeq -14 -> 232
    //   249: ldc 89
    //   251: iconst_2
    //   252: ldc 149
    //   254: invokestatic 151	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   257: return
    //   258: astore_3
    //   259: aconst_null
    //   260: astore_3
    //   261: invokestatic 87	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   264: ifeq +11 -> 275
    //   267: ldc 89
    //   269: iconst_2
    //   270: ldc 153
    //   272: invokestatic 151	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   275: aload_3
    //   276: ifnull -44 -> 232
    //   279: aload_3
    //   280: invokevirtual 146	java/io/InputStream:close	()V
    //   283: return
    //   284: astore_3
    //   285: invokestatic 87	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   288: ifeq -56 -> 232
    //   291: ldc 89
    //   293: iconst_2
    //   294: ldc 149
    //   296: invokestatic 151	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   299: return
    //   300: astore_3
    //   301: aconst_null
    //   302: astore 4
    //   304: aload 4
    //   306: ifnull +8 -> 314
    //   309: aload 4
    //   311: invokevirtual 146	java/io/InputStream:close	()V
    //   314: aload_3
    //   315: athrow
    //   316: astore 4
    //   318: invokestatic 87	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   321: ifeq -7 -> 314
    //   324: ldc 89
    //   326: iconst_2
    //   327: ldc 149
    //   329: invokestatic 151	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   332: goto -18 -> 314
    //   335: astore_3
    //   336: goto -32 -> 304
    //   339: astore 5
    //   341: aload_3
    //   342: astore 4
    //   344: aload 5
    //   346: astore_3
    //   347: goto -43 -> 304
    //   350: astore_3
    //   351: aload 4
    //   353: astore_3
    //   354: goto -93 -> 261
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	357	0	this	BlessTypeActivity
    //   89	105	1	i	int
    //   98	97	2	j	int
    //   49	185	3	localObject1	Object
    //   242	1	3	localException1	java.lang.Exception
    //   258	1	3	localFileNotFoundException1	java.io.FileNotFoundException
    //   260	20	3	localObject2	Object
    //   284	1	3	localException2	java.lang.Exception
    //   300	15	3	localObject3	Object
    //   335	7	3	localObject4	Object
    //   346	1	3	localObject5	Object
    //   350	1	3	localFileNotFoundException2	java.io.FileNotFoundException
    //   353	1	3	localObject6	Object
    //   178	132	4	localFileInputStream	java.io.FileInputStream
    //   316	1	4	localException3	java.lang.Exception
    //   342	10	4	localObject7	Object
    //   162	56	5	localObject8	Object
    //   339	6	5	localObject9	Object
    //   187	18	6	localOptions	android.graphics.BitmapFactory.Options
    // Exception table:
    //   from	to	target	type
    //   227	232	242	java/lang/Exception
    //   169	180	258	java/io/FileNotFoundException
    //   279	283	284	java/lang/Exception
    //   169	180	300	finally
    //   309	314	316	java/lang/Exception
    //   180	211	335	finally
    //   216	222	335	finally
    //   261	275	339	finally
    //   180	211	350	java/io/FileNotFoundException
    //   216	222	350	java/io/FileNotFoundException
  }
  
  public boolean a()
  {
    if (ShortVideoUtils.a()) {}
    do
    {
      return true;
      ShortVideoUtils.a(this.app);
    } while (ShortVideoUtils.a());
    return false;
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    switch (paramInt1)
    {
    }
    do
    {
      return;
    } while (paramInt2 != -1);
    finish();
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    this.mActNeedImmersive = false;
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_Afaz = ((afaz)this.app.getManager(138));
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
  }
  
  public void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    if (QLog.isColorLevel()) {
      QLog.d("BlessTyeActivity", 2, "onNewIntent");
    }
  }
  
  public void doOnPostCreate(Bundle paramBundle)
  {
    super.doOnPostCreate(paramBundle);
    a();
  }
  
  public void doOnResume()
  {
    super.doOnResume();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131368429: 
      onBackEvent();
      return;
    case 2131363683: 
      if (this.jdField_a_of_type_Afaz.f() <= 0)
      {
        bcpw.a(this, String.format(getString(2131690533), new Object[] { Integer.valueOf(this.jdField_a_of_type_Afaz.e()) }), 0).a();
        return;
      }
      paramView = new Intent(this, BlessSendTextActivity.class);
      paramView.putExtra("param_ptv_enable", this.jdField_a_of_type_Boolean);
      startActivity(paramView);
      overridePendingTransition(2130771997, 2130772001);
      afbb.a("bless_event_text_click", null);
      axqw.b(this.app, "CliOper", "", "", "0X800618D", "0X800618D", 0, 0, "", "", "", "");
      return;
    }
    if (this.jdField_a_of_type_Afaz.f() <= 0)
    {
      bcpw.a(this, String.format(getString(2131690533), new Object[] { Integer.valueOf(this.jdField_a_of_type_Afaz.e()) }), 0).a();
      return;
    }
    if (!this.jdField_a_of_type_Boolean)
    {
      bcpw.a(BaseApplication.getContext(), getString(2131690511), 0).a();
      return;
    }
    if (this.app.c())
    {
      bcpw.a(BaseApplication.getContext(), 2131695521, 0).a();
      return;
    }
    if (AudioHelper.b(0))
    {
      ChatActivityUtils.b(this);
      return;
    }
    if (AudioHelper.b(1))
    {
      ChatActivityUtils.a(this);
      return;
    }
    if (AudioHelper.a(0))
    {
      bbcv.a(this, 230, getString(2131698453), getString(2131698455), new afbt(this), null).show();
      return;
    }
    boolean bool2 = axlc.a(this.app, BaseApplicationImpl.getContext());
    if ((a()) && ((bool2) || (axlc.a(this) == 0))) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      QLog.i("BlessTyeActivity", 2, "bless_ptv press, filterOK=" + bool2 + ",videoAndSoReady:" + bool1);
      if ((!bool1) || (b)) {
        break;
      }
      PressToChangeVoicePanel.a(this.app, false, "0X8006385");
      b = true;
      return;
    }
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.bless.BlessTypeActivity
 * JD-Core Version:    0.7.0.1
 */