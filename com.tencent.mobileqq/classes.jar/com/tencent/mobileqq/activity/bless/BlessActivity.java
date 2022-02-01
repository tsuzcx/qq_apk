package com.tencent.mobileqq.activity.bless;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.media.AudioManager;
import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.widget.QQVideoView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.io.FileInputStream;
import java.io.InputStream;

public class BlessActivity
  extends BlessTypeActivity
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int = -1;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = null;
  private AudioManager jdField_a_of_type_AndroidMediaAudioManager = null;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler();
  private ImageView jdField_a_of_type_AndroidWidgetImageView = null;
  BlessActivity.AnimationDrawable2 jdField_a_of_type_ComTencentMobileqqActivityBlessBlessActivity$AnimationDrawable2;
  private QQVideoView jdField_a_of_type_ComTencentMobileqqWidgetQQVideoView = null;
  private String jdField_a_of_type_JavaLangString = "BlessActivity";
  private boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int;
  private View jdField_b_of_type_AndroidViewView = null;
  private ImageView jdField_b_of_type_AndroidWidgetImageView = null;
  private String jdField_b_of_type_JavaLangString = null;
  private boolean jdField_b_of_type_Boolean = false;
  private String jdField_c_of_type_JavaLangString = null;
  private boolean jdField_c_of_type_Boolean = false;
  private int jdField_d_of_type_Int;
  private boolean jdField_d_of_type_Boolean = false;
  private int jdField_e_of_type_Int = 0;
  private boolean jdField_e_of_type_Boolean = false;
  
  private void a(boolean paramBoolean)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = this.jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("stopPlayingStarVideo mNeedShowStarVideo=");
      localStringBuilder.append(this.jdField_a_of_type_Boolean);
      localStringBuilder.append(", mIsPlayingStarVideo=");
      localStringBuilder.append(this.jdField_b_of_type_Boolean);
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_b_of_type_Boolean = false;
      if (paramBoolean)
      {
        localObject = findViewById(2131370712);
        ((View)localObject).setVisibility(0);
        ((View)localObject).bringToFront();
        findViewById(2131369294).bringToFront();
        findViewById(2131378784).bringToFront();
      }
      localObject = this.jdField_b_of_type_AndroidViewView;
      if (localObject != null)
      {
        ((View)localObject).setClickable(false);
        this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      }
      localObject = this.jdField_a_of_type_AndroidWidgetImageView;
      if (localObject != null) {
        ((ImageView)localObject).setVisibility(8);
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetQQVideoView;
      if (localObject != null)
      {
        if (((QQVideoView)localObject).isPlaying()) {
          this.jdField_a_of_type_ComTencentMobileqqWidgetQQVideoView.stopPlayback();
        }
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQVideoView = null;
      }
      localObject = this.jdField_a_of_type_AndroidMediaAudioManager;
      if (localObject != null) {
        ((AudioManager)localObject).abandonAudioFocus(null);
      }
    }
  }
  
  /* Error */
  private void b()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 8
    //   3: aconst_null
    //   4: astore 7
    //   6: aload 7
    //   8: astore 6
    //   10: aload_0
    //   11: getfield 151	com/tencent/mobileqq/activity/bless/BlessActivity:jdField_a_of_type_ComTencentMobileqqActivityBlessBlessManager	Lcom/tencent/mobileqq/activity/bless/BlessManager;
    //   14: invokevirtual 156	com/tencent/mobileqq/activity/bless/BlessManager:f	()Ljava/lang/String;
    //   17: astore 10
    //   19: aload 7
    //   21: astore 6
    //   23: aload_0
    //   24: getfield 151	com/tencent/mobileqq/activity/bless/BlessActivity:jdField_a_of_type_ComTencentMobileqqActivityBlessBlessManager	Lcom/tencent/mobileqq/activity/bless/BlessManager;
    //   27: invokevirtual 159	com/tencent/mobileqq/activity/bless/BlessManager:g	()Ljava/lang/String;
    //   30: astore 9
    //   32: aload 7
    //   34: astore 6
    //   36: aload 9
    //   38: invokestatic 165	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   41: ifeq +4 -> 45
    //   44: return
    //   45: aload 7
    //   47: astore 6
    //   49: new 167	java/io/File
    //   52: dup
    //   53: aload 10
    //   55: invokespecial 170	java/io/File:<init>	(Ljava/lang/String;)V
    //   58: astore 11
    //   60: aload 7
    //   62: astore 6
    //   64: new 167	java/io/File
    //   67: dup
    //   68: aload 9
    //   70: invokespecial 170	java/io/File:<init>	(Ljava/lang/String;)V
    //   73: invokevirtual 173	java/io/File:exists	()Z
    //   76: ifne +30 -> 106
    //   79: aload 7
    //   81: astore 6
    //   83: aload 11
    //   85: invokevirtual 173	java/io/File:exists	()Z
    //   88: ifeq +18 -> 106
    //   91: aload 7
    //   93: astore 6
    //   95: aload 11
    //   97: invokevirtual 176	java/io/File:getPath	()Ljava/lang/String;
    //   100: aload 9
    //   102: iconst_0
    //   103: invokestatic 182	com/tencent/mobileqq/utils/FileUtils:uncompressZip	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   106: aload 7
    //   108: astore 6
    //   110: new 184	java/io/FileInputStream
    //   113: dup
    //   114: aload 10
    //   116: invokespecial 185	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   119: astore 7
    //   121: new 187	android/graphics/BitmapFactory$Options
    //   124: dup
    //   125: invokespecial 188	android/graphics/BitmapFactory$Options:<init>	()V
    //   128: astore 6
    //   130: aload 6
    //   132: aload 7
    //   134: aload_0
    //   135: getfield 64	com/tencent/mobileqq/activity/bless/BlessActivity:jdField_b_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   138: invokevirtual 192	android/widget/ImageView:getLayoutParams	()Landroid/view/ViewGroup$LayoutParams;
    //   141: getfield 197	android/view/ViewGroup$LayoutParams:width	I
    //   144: aload_0
    //   145: getfield 64	com/tencent/mobileqq/activity/bless/BlessActivity:jdField_b_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   148: invokevirtual 192	android/widget/ImageView:getLayoutParams	()Landroid/view/ViewGroup$LayoutParams;
    //   151: getfield 200	android/view/ViewGroup$LayoutParams:height	I
    //   154: invokestatic 205	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/io/InputStream;II)D
    //   157: d2i
    //   158: putfield 208	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   161: aload_0
    //   162: getfield 151	com/tencent/mobileqq/activity/bless/BlessActivity:jdField_a_of_type_ComTencentMobileqqActivityBlessBlessManager	Lcom/tencent/mobileqq/activity/bless/BlessManager;
    //   165: invokevirtual 212	com/tencent/mobileqq/activity/bless/BlessManager:l	()I
    //   168: istore_2
    //   169: iload_2
    //   170: iconst_m1
    //   171: if_icmpne +95 -> 266
    //   174: new 88	java/lang/StringBuilder
    //   177: dup
    //   178: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   181: astore 8
    //   183: aload 8
    //   185: aload 9
    //   187: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   190: pop
    //   191: aload 8
    //   193: iconst_1
    //   194: invokevirtual 215	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   197: pop
    //   198: aload 8
    //   200: ldc 217
    //   202: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   205: pop
    //   206: aload 8
    //   208: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   211: aload 6
    //   213: invokestatic 222	com/tencent/mobileqq/util/BitmapManager:a	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   216: astore 6
    //   218: aload_0
    //   219: getfield 64	com/tencent/mobileqq/activity/bless/BlessActivity:jdField_b_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   222: new 224	com/tencent/mobileqq/activity/bless/BlessActivity$3
    //   225: dup
    //   226: aload_0
    //   227: aload 6
    //   229: invokespecial 227	com/tencent/mobileqq/activity/bless/BlessActivity$3:<init>	(Lcom/tencent/mobileqq/activity/bless/BlessActivity;Landroid/graphics/Bitmap;)V
    //   232: ldc2_w 228
    //   235: invokevirtual 233	android/widget/ImageView:postDelayed	(Ljava/lang/Runnable;J)Z
    //   238: pop
    //   239: aload 7
    //   241: invokevirtual 238	java/io/InputStream:close	()V
    //   244: return
    //   245: astore 6
    //   247: invokestatic 86	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   250: ifeq +15 -> 265
    //   253: aload_0
    //   254: getfield 29	com/tencent/mobileqq/activity/bless/BlessActivity:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   257: iconst_2
    //   258: ldc 240
    //   260: aload 6
    //   262: invokestatic 243	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   265: return
    //   266: new 167	java/io/File
    //   269: dup
    //   270: aload 9
    //   272: invokespecial 170	java/io/File:<init>	(Ljava/lang/String;)V
    //   275: astore 8
    //   277: aload 8
    //   279: invokevirtual 246	java/io/File:isDirectory	()Z
    //   282: istore 5
    //   284: iload 5
    //   286: ifne +30 -> 316
    //   289: aload 7
    //   291: invokevirtual 238	java/io/InputStream:close	()V
    //   294: return
    //   295: astore 6
    //   297: invokestatic 86	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   300: ifeq +15 -> 315
    //   303: aload_0
    //   304: getfield 29	com/tencent/mobileqq/activity/bless/BlessActivity:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   307: iconst_2
    //   308: ldc 240
    //   310: aload 6
    //   312: invokestatic 243	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   315: return
    //   316: aload 8
    //   318: invokevirtual 250	java/io/File:list	()[Ljava/lang/String;
    //   321: arraylength
    //   322: istore_3
    //   323: aload_0
    //   324: getfield 151	com/tencent/mobileqq/activity/bless/BlessActivity:jdField_a_of_type_ComTencentMobileqqActivityBlessBlessManager	Lcom/tencent/mobileqq/activity/bless/BlessManager;
    //   327: invokevirtual 253	com/tencent/mobileqq/activity/bless/BlessManager:m	()I
    //   330: istore 4
    //   332: aload_0
    //   333: new 255	com/tencent/mobileqq/activity/bless/BlessActivity$AnimationDrawable2
    //   336: dup
    //   337: aload_0
    //   338: invokespecial 257	com/tencent/mobileqq/activity/bless/BlessActivity$AnimationDrawable2:<init>	(Lcom/tencent/mobileqq/activity/bless/BlessActivity;)V
    //   341: putfield 259	com/tencent/mobileqq/activity/bless/BlessActivity:jdField_a_of_type_ComTencentMobileqqActivityBlessBlessActivity$AnimationDrawable2	Lcom/tencent/mobileqq/activity/bless/BlessActivity$AnimationDrawable2;
    //   344: iconst_0
    //   345: istore_1
    //   346: iload_1
    //   347: iload_3
    //   348: if_icmpge +78 -> 426
    //   351: iload_1
    //   352: iconst_1
    //   353: iadd
    //   354: istore_1
    //   355: new 88	java/lang/StringBuilder
    //   358: dup
    //   359: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   362: astore 8
    //   364: aload 8
    //   366: aload 9
    //   368: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   371: pop
    //   372: aload 8
    //   374: iload_1
    //   375: invokevirtual 215	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   378: pop
    //   379: aload 8
    //   381: ldc 217
    //   383: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   386: pop
    //   387: aload 8
    //   389: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   392: aload 6
    //   394: invokestatic 222	com/tencent/mobileqq/util/BitmapManager:a	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   397: astore 8
    //   399: aload_0
    //   400: getfield 259	com/tencent/mobileqq/activity/bless/BlessActivity:jdField_a_of_type_ComTencentMobileqqActivityBlessBlessActivity$AnimationDrawable2	Lcom/tencent/mobileqq/activity/bless/BlessActivity$AnimationDrawable2;
    //   403: new 261	android/graphics/drawable/BitmapDrawable
    //   406: dup
    //   407: aload_0
    //   408: invokevirtual 265	com/tencent/mobileqq/activity/bless/BlessActivity:getResources	()Landroid/content/res/Resources;
    //   411: aload 8
    //   413: invokespecial 268	android/graphics/drawable/BitmapDrawable:<init>	(Landroid/content/res/Resources;Landroid/graphics/Bitmap;)V
    //   416: iload 4
    //   418: iload_3
    //   419: idiv
    //   420: invokevirtual 272	com/tencent/mobileqq/activity/bless/BlessActivity$AnimationDrawable2:addFrame	(Landroid/graphics/drawable/Drawable;I)V
    //   423: goto -77 -> 346
    //   426: iload_2
    //   427: ifne +14 -> 441
    //   430: aload_0
    //   431: getfield 259	com/tencent/mobileqq/activity/bless/BlessActivity:jdField_a_of_type_ComTencentMobileqqActivityBlessBlessActivity$AnimationDrawable2	Lcom/tencent/mobileqq/activity/bless/BlessActivity$AnimationDrawable2;
    //   434: iconst_0
    //   435: invokevirtual 275	com/tencent/mobileqq/activity/bless/BlessActivity$AnimationDrawable2:setOneShot	(Z)V
    //   438: goto +26 -> 464
    //   441: aload_0
    //   442: getfield 259	com/tencent/mobileqq/activity/bless/BlessActivity:jdField_a_of_type_ComTencentMobileqqActivityBlessBlessActivity$AnimationDrawable2	Lcom/tencent/mobileqq/activity/bless/BlessActivity$AnimationDrawable2;
    //   445: iconst_1
    //   446: invokevirtual 275	com/tencent/mobileqq/activity/bless/BlessActivity$AnimationDrawable2:setOneShot	(Z)V
    //   449: aload_0
    //   450: getfield 259	com/tencent/mobileqq/activity/bless/BlessActivity:jdField_a_of_type_ComTencentMobileqqActivityBlessBlessActivity$AnimationDrawable2	Lcom/tencent/mobileqq/activity/bless/BlessActivity$AnimationDrawable2;
    //   453: new 277	com/tencent/mobileqq/activity/bless/BlessActivity$4
    //   456: dup
    //   457: aload_0
    //   458: invokespecial 278	com/tencent/mobileqq/activity/bless/BlessActivity$4:<init>	(Lcom/tencent/mobileqq/activity/bless/BlessActivity;)V
    //   461: invokevirtual 281	com/tencent/mobileqq/activity/bless/BlessActivity$AnimationDrawable2:a	(Lcom/tencent/mobileqq/activity/bless/BlessActivity$IAnimationFinishListener;)V
    //   464: aload_0
    //   465: getfield 64	com/tencent/mobileqq/activity/bless/BlessActivity:jdField_b_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   468: new 283	com/tencent/mobileqq/activity/bless/BlessActivity$5
    //   471: dup
    //   472: aload_0
    //   473: invokespecial 284	com/tencent/mobileqq/activity/bless/BlessActivity$5:<init>	(Lcom/tencent/mobileqq/activity/bless/BlessActivity;)V
    //   476: ldc2_w 228
    //   479: invokevirtual 233	android/widget/ImageView:postDelayed	(Ljava/lang/Runnable;J)Z
    //   482: pop
    //   483: aload 7
    //   485: invokevirtual 238	java/io/InputStream:close	()V
    //   488: return
    //   489: astore 6
    //   491: invokestatic 86	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   494: ifeq +102 -> 596
    //   497: aload_0
    //   498: getfield 29	com/tencent/mobileqq/activity/bless/BlessActivity:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   501: iconst_2
    //   502: ldc 240
    //   504: aload 6
    //   506: invokestatic 243	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   509: return
    //   510: astore 6
    //   512: goto +85 -> 597
    //   515: astore 8
    //   517: goto +30 -> 547
    //   520: astore 7
    //   522: aload 6
    //   524: astore 8
    //   526: aload 7
    //   528: astore 6
    //   530: aload 8
    //   532: astore 7
    //   534: goto +63 -> 597
    //   537: astore 6
    //   539: aload 8
    //   541: astore 7
    //   543: aload 6
    //   545: astore 8
    //   547: aload 7
    //   549: astore 6
    //   551: invokestatic 86	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   554: ifeq +20 -> 574
    //   557: aload 7
    //   559: astore 6
    //   561: aload_0
    //   562: getfield 29	com/tencent/mobileqq/activity/bless/BlessActivity:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   565: iconst_2
    //   566: ldc_w 286
    //   569: aload 8
    //   571: invokestatic 243	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   574: aload 7
    //   576: ifnull +20 -> 596
    //   579: aload 7
    //   581: invokevirtual 238	java/io/InputStream:close	()V
    //   584: return
    //   585: astore 6
    //   587: invokestatic 86	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   590: ifeq +6 -> 596
    //   593: goto -96 -> 497
    //   596: return
    //   597: aload 7
    //   599: ifnull +31 -> 630
    //   602: aload 7
    //   604: invokevirtual 238	java/io/InputStream:close	()V
    //   607: goto +23 -> 630
    //   610: astore 7
    //   612: invokestatic 86	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   615: ifeq +15 -> 630
    //   618: aload_0
    //   619: getfield 29	com/tencent/mobileqq/activity/bless/BlessActivity:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   622: iconst_2
    //   623: ldc 240
    //   625: aload 7
    //   627: invokestatic 243	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   630: goto +6 -> 636
    //   633: aload 6
    //   635: athrow
    //   636: goto -3 -> 633
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	639	0	this	BlessActivity
    //   345	30	1	i	int
    //   168	259	2	j	int
    //   322	98	3	k	int
    //   330	90	4	m	int
    //   282	3	5	bool	boolean
    //   8	220	6	localObject1	Object
    //   245	16	6	localException1	Exception
    //   295	98	6	localException2	Exception
    //   489	16	6	localException3	Exception
    //   510	13	6	localObject2	Object
    //   528	1	6	localObject3	Object
    //   537	7	6	localException4	Exception
    //   549	11	6	localObject4	Object
    //   585	49	6	localException5	Exception
    //   4	480	7	localFileInputStream	FileInputStream
    //   520	7	7	localObject5	Object
    //   532	71	7	localObject6	Object
    //   610	16	7	localException6	Exception
    //   1	411	8	localObject7	Object
    //   515	1	8	localException7	Exception
    //   524	46	8	localObject8	Object
    //   30	337	9	str1	String
    //   17	98	10	str2	String
    //   58	38	11	localFile	java.io.File
    // Exception table:
    //   from	to	target	type
    //   239	244	245	java/lang/Exception
    //   289	294	295	java/lang/Exception
    //   483	488	489	java/lang/Exception
    //   121	169	510	finally
    //   174	239	510	finally
    //   266	284	510	finally
    //   316	344	510	finally
    //   355	423	510	finally
    //   430	438	510	finally
    //   441	464	510	finally
    //   464	483	510	finally
    //   121	169	515	java/lang/Exception
    //   174	239	515	java/lang/Exception
    //   266	284	515	java/lang/Exception
    //   316	344	515	java/lang/Exception
    //   355	423	515	java/lang/Exception
    //   430	438	515	java/lang/Exception
    //   441	464	515	java/lang/Exception
    //   464	483	515	java/lang/Exception
    //   10	19	520	finally
    //   23	32	520	finally
    //   36	44	520	finally
    //   49	60	520	finally
    //   64	79	520	finally
    //   83	91	520	finally
    //   95	106	520	finally
    //   110	121	520	finally
    //   551	557	520	finally
    //   561	574	520	finally
    //   10	19	537	java/lang/Exception
    //   23	32	537	java/lang/Exception
    //   36	44	537	java/lang/Exception
    //   49	60	537	java/lang/Exception
    //   64	79	537	java/lang/Exception
    //   83	91	537	java/lang/Exception
    //   95	106	537	java/lang/Exception
    //   110	121	537	java/lang/Exception
    //   579	584	585	java/lang/Exception
    //   602	607	610	java/lang/Exception
  }
  
  private void c()
  {
    if (this.jdField_c_of_type_Boolean) {
      return;
    }
    this.jdField_c_of_type_Boolean = true;
    Object localObject2 = (RelativeLayout)findViewById(2131376809);
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQVideoView == null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQVideoView = ((QQVideoView)findViewById(2131380812));
    }
    if (this.jdField_a_of_type_AndroidMediaAudioManager == null) {
      this.jdField_a_of_type_AndroidMediaAudioManager = ((AudioManager)getSystemService("audio"));
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQVideoView.setVideoPath(this.jdField_b_of_type_JavaLangString);
    Object localObject1 = new DisplayMetrics();
    getWindowManager().getDefaultDisplay().getMetrics((DisplayMetrics)localObject1);
    int k = this.jdField_d_of_type_Int;
    float f = k / 900;
    int j = (int)(700 * f + 0.5F);
    int i = j;
    if (j % 2 == 1) {
      i = j + 1;
    }
    this.jdField_b_of_type_Boolean = true;
    d();
    Object localObject3 = (RelativeLayout.LayoutParams)findViewById(2131370712).getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject3).width = k;
    ((RelativeLayout.LayoutParams)localObject3).height = i;
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131380807));
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    try
    {
      localObject3 = new FileInputStream(this.jdField_c_of_type_JavaLangString);
      localObject4 = new BitmapFactory.Options();
      ((BitmapFactory.Options)localObject4).inSampleSize = ((int)ImageUtil.a((InputStream)localObject3, k, i));
      localObject3 = BitmapManager.a(this.jdField_c_of_type_JavaLangString, (BitmapFactory.Options)localObject4);
      if (localObject3 != null) {
        this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap((Bitmap)localObject3);
      }
      localObject3 = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject3).width = k;
      ((RelativeLayout.LayoutParams)localObject3).height = i;
      this.jdField_a_of_type_AndroidWidgetImageView.bringToFront();
    }
    catch (Exception localException)
    {
      Object localObject4;
      if (QLog.isColorLevel())
      {
        localObject4 = this.jdField_a_of_type_JavaLangString;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("decode mVideoCoverPath error = ");
        localStringBuilder.append(localException.getMessage());
        QLog.e((String)localObject4, 2, localStringBuilder.toString());
      }
    }
    findViewById(2131378784).bringToFront();
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQVideoView.setDimension(k, i);
    ((RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqWidgetQQVideoView.getLayoutParams()).setMargins(0, 0, 0, 0);
    this.jdField_b_of_type_AndroidViewView = new View(this);
    ((RelativeLayout)localObject2).addView(this.jdField_b_of_type_AndroidViewView);
    localObject2 = (RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidViewView.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject2).addRule(11);
    ((RelativeLayout.LayoutParams)localObject2).addRule(10);
    ((RelativeLayout.LayoutParams)localObject2).setMargins(0, (int)(((DisplayMetrics)localObject1).density * 31.0F + 0.5F), 0, 0);
    ((RelativeLayout.LayoutParams)localObject2).width = ((int)(((DisplayMetrics)localObject1).density * 60.0F + 0.5F));
    ((RelativeLayout.LayoutParams)localObject2).height = ((int)(((DisplayMetrics)localObject1).density * 60.0F + 0.5F));
    this.jdField_b_of_type_AndroidViewView.bringToFront();
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(new BlessActivity.6(this));
    localObject1 = this.jdField_a_of_type_AndroidMediaAudioManager;
    if (localObject1 != null) {
      ((AudioManager)localObject1).requestAudioFocus(null, 3, 1);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQVideoView.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQVideoView.setOnPreparedListener(new BlessActivity.7(this));
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQVideoView.setOnCompletionListener(new BlessActivity.8(this));
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQVideoView.setOnErrorListener(new BlessActivity.9(this));
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_AndroidContentBroadcastReceiver == null) {
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = new BlessActivity.10(this);
    }
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("tencent.av.v2q.StartVideoChat");
    try
    {
      registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  /* Error */
  public void a()
  {
    // Byte code:
    //   0: aload_0
    //   1: ldc_w 420
    //   4: invokevirtual 112	com/tencent/mobileqq/activity/bless/BlessActivity:findViewById	(I)Landroid/view/View;
    //   7: checkcast 128	android/widget/ImageView
    //   10: astore_3
    //   11: aload_0
    //   12: getfield 151	com/tencent/mobileqq/activity/bless/BlessActivity:jdField_a_of_type_ComTencentMobileqqActivityBlessBlessManager	Lcom/tencent/mobileqq/activity/bless/BlessManager;
    //   15: invokevirtual 422	com/tencent/mobileqq/activity/bless/BlessManager:a	()Ljava/lang/String;
    //   18: astore 4
    //   20: aload 4
    //   22: ifnull +275 -> 297
    //   25: new 184	java/io/FileInputStream
    //   28: dup
    //   29: aload 4
    //   31: invokespecial 185	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   34: astore_2
    //   35: aload_2
    //   36: astore_1
    //   37: new 187	android/graphics/BitmapFactory$Options
    //   40: dup
    //   41: invokespecial 188	android/graphics/BitmapFactory$Options:<init>	()V
    //   44: astore 5
    //   46: aload_2
    //   47: astore_1
    //   48: aload 5
    //   50: aload_2
    //   51: aload_3
    //   52: invokevirtual 192	android/widget/ImageView:getLayoutParams	()Landroid/view/ViewGroup$LayoutParams;
    //   55: getfield 197	android/view/ViewGroup$LayoutParams:width	I
    //   58: aload_3
    //   59: invokevirtual 192	android/widget/ImageView:getLayoutParams	()Landroid/view/ViewGroup$LayoutParams;
    //   62: getfield 200	android/view/ViewGroup$LayoutParams:height	I
    //   65: invokestatic 205	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/io/InputStream;II)D
    //   68: d2i
    //   69: putfield 208	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   72: aload_2
    //   73: astore_1
    //   74: invokestatic 86	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   77: ifeq +87 -> 164
    //   80: aload_2
    //   81: astore_1
    //   82: aload_0
    //   83: getfield 29	com/tencent/mobileqq/activity/bless/BlessActivity:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   86: astore 6
    //   88: aload_2
    //   89: astore_1
    //   90: new 88	java/lang/StringBuilder
    //   93: dup
    //   94: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   97: astore 7
    //   99: aload_2
    //   100: astore_1
    //   101: aload 7
    //   103: ldc_w 424
    //   106: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: pop
    //   110: aload_2
    //   111: astore_1
    //   112: aload 7
    //   114: aload_3
    //   115: invokevirtual 192	android/widget/ImageView:getLayoutParams	()Landroid/view/ViewGroup$LayoutParams;
    //   118: getfield 197	android/view/ViewGroup$LayoutParams:width	I
    //   121: invokevirtual 215	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   124: pop
    //   125: aload_2
    //   126: astore_1
    //   127: aload 7
    //   129: ldc_w 426
    //   132: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   135: pop
    //   136: aload_2
    //   137: astore_1
    //   138: aload 7
    //   140: aload_3
    //   141: invokevirtual 192	android/widget/ImageView:getLayoutParams	()Landroid/view/ViewGroup$LayoutParams;
    //   144: getfield 200	android/view/ViewGroup$LayoutParams:height	I
    //   147: invokevirtual 215	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   150: pop
    //   151: aload_2
    //   152: astore_1
    //   153: aload 6
    //   155: iconst_2
    //   156: aload 7
    //   158: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   161: invokestatic 107	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   164: aload_2
    //   165: astore_1
    //   166: aload 4
    //   168: aload 5
    //   170: invokestatic 222	com/tencent/mobileqq/util/BitmapManager:a	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   173: astore 4
    //   175: aload 4
    //   177: ifnull +11 -> 188
    //   180: aload_2
    //   181: astore_1
    //   182: aload_3
    //   183: aload 4
    //   185: invokevirtual 333	android/widget/ImageView:setImageBitmap	(Landroid/graphics/Bitmap;)V
    //   188: aload_2
    //   189: invokevirtual 238	java/io/InputStream:close	()V
    //   192: goto +105 -> 297
    //   195: invokestatic 86	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   198: ifeq +99 -> 297
    //   201: aload_0
    //   202: getfield 29	com/tencent/mobileqq/activity/bless/BlessActivity:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   205: iconst_2
    //   206: ldc 240
    //   208: invokestatic 341	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   211: goto +86 -> 297
    //   214: astore_1
    //   215: aconst_null
    //   216: astore_2
    //   217: goto +51 -> 268
    //   220: aconst_null
    //   221: astore_2
    //   222: aload_2
    //   223: astore_1
    //   224: invokestatic 86	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   227: ifeq +16 -> 243
    //   230: aload_2
    //   231: astore_1
    //   232: aload_0
    //   233: getfield 29	com/tencent/mobileqq/activity/bless/BlessActivity:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   236: iconst_2
    //   237: ldc_w 428
    //   240: invokestatic 341	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   243: aload_2
    //   244: ifnull +53 -> 297
    //   247: aload_2
    //   248: invokevirtual 238	java/io/InputStream:close	()V
    //   251: goto +46 -> 297
    //   254: invokestatic 86	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   257: ifeq +40 -> 297
    //   260: goto -59 -> 201
    //   263: astore_3
    //   264: aload_1
    //   265: astore_2
    //   266: aload_3
    //   267: astore_1
    //   268: aload_2
    //   269: ifnull +26 -> 295
    //   272: aload_2
    //   273: invokevirtual 238	java/io/InputStream:close	()V
    //   276: goto +19 -> 295
    //   279: invokestatic 86	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   282: ifeq +13 -> 295
    //   285: aload_0
    //   286: getfield 29	com/tencent/mobileqq/activity/bless/BlessActivity:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   289: iconst_2
    //   290: ldc 240
    //   292: invokestatic 341	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   295: aload_1
    //   296: athrow
    //   297: aload_0
    //   298: getfield 33	com/tencent/mobileqq/activity/bless/BlessActivity:jdField_a_of_type_Boolean	Z
    //   301: ifeq +30 -> 331
    //   304: aload_0
    //   305: ldc_w 289
    //   308: invokevirtual 112	com/tencent/mobileqq/activity/bless/BlessActivity:findViewById	(I)Landroid/view/View;
    //   311: checkcast 291	android/widget/RelativeLayout
    //   314: astore_1
    //   315: aload_1
    //   316: invokevirtual 432	android/widget/RelativeLayout:getViewTreeObserver	()Landroid/view/ViewTreeObserver;
    //   319: new 434	com/tencent/mobileqq/activity/bless/BlessActivity$1
    //   322: dup
    //   323: aload_0
    //   324: aload_1
    //   325: invokespecial 437	com/tencent/mobileqq/activity/bless/BlessActivity$1:<init>	(Lcom/tencent/mobileqq/activity/bless/BlessActivity;Landroid/widget/RelativeLayout;)V
    //   328: invokevirtual 443	android/view/ViewTreeObserver:addOnGlobalLayoutListener	(Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;)V
    //   331: aload_0
    //   332: getfield 151	com/tencent/mobileqq/activity/bless/BlessActivity:jdField_a_of_type_ComTencentMobileqqActivityBlessBlessManager	Lcom/tencent/mobileqq/activity/bless/BlessManager;
    //   335: invokevirtual 446	com/tencent/mobileqq/activity/bless/BlessManager:a	()Ljava/lang/Boolean;
    //   338: invokevirtual 451	java/lang/Boolean:booleanValue	()Z
    //   341: ifeq +32 -> 373
    //   344: aload_0
    //   345: aload_0
    //   346: ldc_w 452
    //   349: invokevirtual 112	com/tencent/mobileqq/activity/bless/BlessActivity:findViewById	(I)Landroid/view/View;
    //   352: checkcast 128	android/widget/ImageView
    //   355: putfield 64	com/tencent/mobileqq/activity/bless/BlessActivity:jdField_b_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   358: new 454	com/tencent/mobileqq/activity/bless/BlessActivity$2
    //   361: dup
    //   362: aload_0
    //   363: invokespecial 455	com/tencent/mobileqq/activity/bless/BlessActivity$2:<init>	(Lcom/tencent/mobileqq/activity/bless/BlessActivity;)V
    //   366: bipush 10
    //   368: aconst_null
    //   369: iconst_1
    //   370: invokestatic 461	com/tencent/mobileqq/app/ThreadManager:post	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   373: return
    //   374: astore_1
    //   375: goto -155 -> 220
    //   378: astore_1
    //   379: goto -157 -> 222
    //   382: astore_1
    //   383: goto -188 -> 195
    //   386: astore_1
    //   387: goto -133 -> 254
    //   390: astore_2
    //   391: goto -112 -> 279
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	394	0	this	BlessActivity
    //   36	146	1	localObject1	Object
    //   214	1	1	localObject2	Object
    //   223	102	1	localObject3	Object
    //   374	1	1	localFileNotFoundException1	java.io.FileNotFoundException
    //   378	1	1	localFileNotFoundException2	java.io.FileNotFoundException
    //   382	1	1	localException1	Exception
    //   386	1	1	localException2	Exception
    //   34	239	2	localObject4	Object
    //   390	1	2	localException3	Exception
    //   10	173	3	localImageView	ImageView
    //   263	4	3	localObject5	Object
    //   18	166	4	localObject6	Object
    //   44	125	5	localOptions	BitmapFactory.Options
    //   86	68	6	str	String
    //   97	60	7	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   25	35	214	finally
    //   37	46	263	finally
    //   48	72	263	finally
    //   74	80	263	finally
    //   82	88	263	finally
    //   90	99	263	finally
    //   101	110	263	finally
    //   112	125	263	finally
    //   127	136	263	finally
    //   138	151	263	finally
    //   153	164	263	finally
    //   166	175	263	finally
    //   182	188	263	finally
    //   224	230	263	finally
    //   232	243	263	finally
    //   25	35	374	java/io/FileNotFoundException
    //   37	46	378	java/io/FileNotFoundException
    //   48	72	378	java/io/FileNotFoundException
    //   74	80	378	java/io/FileNotFoundException
    //   82	88	378	java/io/FileNotFoundException
    //   90	99	378	java/io/FileNotFoundException
    //   101	110	378	java/io/FileNotFoundException
    //   112	125	378	java/io/FileNotFoundException
    //   127	136	378	java/io/FileNotFoundException
    //   138	151	378	java/io/FileNotFoundException
    //   153	164	378	java/io/FileNotFoundException
    //   166	175	378	java/io/FileNotFoundException
    //   182	188	378	java/io/FileNotFoundException
    //   188	192	382	java/lang/Exception
    //   247	251	386	java/lang/Exception
    //   272	276	390	java/lang/Exception
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
    super.setContentView(2131558713);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessManager.h())
    {
      this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessManager.c();
      this.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessManager.d();
      if ((this.jdField_b_of_type_JavaLangString != null) && (this.jdField_c_of_type_JavaLangString != null)) {
        this.jdField_a_of_type_Boolean = true;
      }
    }
    this.jdField_a_of_type_Float = 0.6933333F;
    this.jdField_c_of_type_Int = 1;
    a();
    this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessManager.b(false);
    this.jdField_e_of_type_Boolean = getIntent().getBooleanExtra("PARAM_IS_FROM_SEARCH", false);
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessManager.c();
    Object localObject = this.jdField_a_of_type_AndroidContentBroadcastReceiver;
    if (localObject != null) {
      unregisterReceiver((BroadcastReceiver)localObject);
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessActivity$AnimationDrawable2;
    if ((localObject != null) && (((BlessActivity.AnimationDrawable2)localObject).isRunning())) {
      this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessActivity$AnimationDrawable2.stop();
    }
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = null;
  }
  
  protected void doOnPause()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "doOnPause");
    }
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_b_of_type_Boolean)) {
      if (this.jdField_d_of_type_Boolean)
      {
        a(true);
      }
      else
      {
        QQVideoView localQQVideoView = this.jdField_a_of_type_ComTencentMobileqqWidgetQQVideoView;
        if (localQQVideoView != null)
        {
          localQQVideoView.pause();
          this.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqWidgetQQVideoView.getCurrentPosition();
        }
      }
    }
    super.doOnPause();
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    int i = this.jdField_a_of_type_Int;
    if (i != -1)
    {
      QQVideoView localQQVideoView = this.jdField_a_of_type_ComTencentMobileqqWidgetQQVideoView;
      if (localQQVideoView != null)
      {
        localQQVideoView.seekTo(i);
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQVideoView.start();
        this.jdField_a_of_type_Int = -1;
      }
    }
  }
  
  protected boolean onBackEvent()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "onBackEvent");
    }
    a(false);
    if (!this.jdField_e_of_type_Boolean)
    {
      Intent localIntent = new Intent(this, SplashActivity.class);
      localIntent.setFlags(67108864);
      startActivity(localIntent);
    }
    finish();
    return true;
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (((i == 2131364007) || (i == 2131364094)) && (this.jdField_a_of_type_Boolean)) {
      a(true);
    }
    super.onClick(paramView);
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.bless.BlessActivity
 * JD-Core Version:    0.7.0.1
 */