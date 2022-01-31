package com.tencent.mobileqq.activity.bless;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.media.AudioManager;
import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.KeyEvent;
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
import java.io.FileInputStream;
import java.io.InputStream;
import wbi;
import wbn;
import wbo;
import wbq;
import wbr;

public class BlessActivity
  extends BlessTypeActivity
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int = -1;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver;
  private AudioManager jdField_a_of_type_AndroidMediaAudioManager;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler();
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  public BlessActivity.AnimationDrawable2 a;
  private QQVideoView jdField_a_of_type_ComTencentMobileqqWidgetQQVideoView;
  private String jdField_a_of_type_JavaLangString = "BlessActivity";
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private View jdField_b_of_type_AndroidViewView;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean;
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int;
  private boolean jdField_d_of_type_Boolean;
  private int jdField_e_of_type_Int;
  private boolean jdField_e_of_type_Boolean;
  
  private void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "stopPlayingStarVideo mNeedShowStarVideo=" + this.jdField_a_of_type_Boolean + ", mIsPlayingStarVideo=" + this.jdField_b_of_type_Boolean);
    }
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_b_of_type_Boolean = false;
      if (paramBoolean)
      {
        View localView = findViewById(2131363350);
        localView.setVisibility(0);
        localView.bringToFront();
        findViewById(2131363352).bringToFront();
        findViewById(2131363360).bringToFront();
      }
      if (this.jdField_b_of_type_AndroidViewView != null)
      {
        this.jdField_b_of_type_AndroidViewView.setClickable(false);
        this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      }
      if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQVideoView != null)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQVideoView.isPlaying()) {
          this.jdField_a_of_type_ComTencentMobileqqWidgetQQVideoView.stopPlayback();
        }
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQVideoView = null;
      }
      if (this.jdField_a_of_type_AndroidMediaAudioManager != null) {
        this.jdField_a_of_type_AndroidMediaAudioManager.abandonAudioFocus(null);
      }
    }
  }
  
  /* Error */
  private void b()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: aconst_null
    //   3: astore 6
    //   5: aload_0
    //   6: getfield 141	com/tencent/mobileqq/activity/bless/BlessActivity:jdField_a_of_type_ComTencentMobileqqActivityBlessBlessManager	Lcom/tencent/mobileqq/activity/bless/BlessManager;
    //   9: invokevirtual 146	com/tencent/mobileqq/activity/bless/BlessManager:j	()Ljava/lang/String;
    //   12: astore 9
    //   14: aload_0
    //   15: getfield 141	com/tencent/mobileqq/activity/bless/BlessActivity:jdField_a_of_type_ComTencentMobileqqActivityBlessBlessManager	Lcom/tencent/mobileqq/activity/bless/BlessManager;
    //   18: invokevirtual 149	com/tencent/mobileqq/activity/bless/BlessManager:k	()Ljava/lang/String;
    //   21: astore 8
    //   23: aload 8
    //   25: invokestatic 155	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   28: istore 5
    //   30: iload 5
    //   32: ifeq +37 -> 69
    //   35: iconst_0
    //   36: ifeq +11 -> 47
    //   39: new 157	java/lang/NullPointerException
    //   42: dup
    //   43: invokespecial 158	java/lang/NullPointerException:<init>	()V
    //   46: athrow
    //   47: return
    //   48: astore 6
    //   50: invokestatic 64	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   53: ifeq -6 -> 47
    //   56: aload_0
    //   57: getfield 29	com/tencent/mobileqq/activity/bless/BlessActivity:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   60: iconst_2
    //   61: ldc 160
    //   63: aload 6
    //   65: invokestatic 163	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   68: return
    //   69: new 165	java/io/File
    //   72: dup
    //   73: aload 9
    //   75: invokespecial 168	java/io/File:<init>	(Ljava/lang/String;)V
    //   78: astore 7
    //   80: new 165	java/io/File
    //   83: dup
    //   84: aload 8
    //   86: invokespecial 168	java/io/File:<init>	(Ljava/lang/String;)V
    //   89: invokevirtual 171	java/io/File:exists	()Z
    //   92: ifne +22 -> 114
    //   95: aload 7
    //   97: invokevirtual 171	java/io/File:exists	()Z
    //   100: ifeq +14 -> 114
    //   103: aload 7
    //   105: invokevirtual 174	java/io/File:getPath	()Ljava/lang/String;
    //   108: aload 8
    //   110: iconst_0
    //   111: invokestatic 179	com/tencent/mobileqq/utils/FileUtils:a	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   114: new 181	java/io/FileInputStream
    //   117: dup
    //   118: aload 9
    //   120: invokespecial 182	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   123: astore 7
    //   125: new 184	android/graphics/BitmapFactory$Options
    //   128: dup
    //   129: invokespecial 185	android/graphics/BitmapFactory$Options:<init>	()V
    //   132: astore 6
    //   134: aload 6
    //   136: aload 7
    //   138: aload_0
    //   139: getfield 47	com/tencent/mobileqq/activity/bless/BlessActivity:jdField_b_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   142: invokevirtual 189	android/widget/ImageView:getLayoutParams	()Landroid/view/ViewGroup$LayoutParams;
    //   145: getfield 194	android/view/ViewGroup$LayoutParams:width	I
    //   148: aload_0
    //   149: getfield 47	com/tencent/mobileqq/activity/bless/BlessActivity:jdField_b_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   152: invokevirtual 189	android/widget/ImageView:getLayoutParams	()Landroid/view/ViewGroup$LayoutParams;
    //   155: getfield 197	android/view/ViewGroup$LayoutParams:height	I
    //   158: invokestatic 202	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/io/InputStream;II)D
    //   161: d2i
    //   162: putfield 205	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   165: aload_0
    //   166: getfield 141	com/tencent/mobileqq/activity/bless/BlessActivity:jdField_a_of_type_ComTencentMobileqqActivityBlessBlessManager	Lcom/tencent/mobileqq/activity/bless/BlessManager;
    //   169: invokevirtual 209	com/tencent/mobileqq/activity/bless/BlessManager:m	()I
    //   172: istore 4
    //   174: iload 4
    //   176: iconst_m1
    //   177: if_icmpne +87 -> 264
    //   180: new 66	java/lang/StringBuilder
    //   183: dup
    //   184: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   187: aload 8
    //   189: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   192: iconst_1
    //   193: invokevirtual 212	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   196: ldc 214
    //   198: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   201: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   204: aload 6
    //   206: invokestatic 219	com/tencent/mobileqq/util/BitmapManager:a	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   209: astore 6
    //   211: aload_0
    //   212: getfield 47	com/tencent/mobileqq/activity/bless/BlessActivity:jdField_b_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   215: new 221	wbk
    //   218: dup
    //   219: aload_0
    //   220: aload 6
    //   222: invokespecial 224	wbk:<init>	(Lcom/tencent/mobileqq/activity/bless/BlessActivity;Landroid/graphics/Bitmap;)V
    //   225: ldc2_w 225
    //   228: invokevirtual 230	android/widget/ImageView:postDelayed	(Ljava/lang/Runnable;J)Z
    //   231: pop
    //   232: aload 7
    //   234: ifnull -187 -> 47
    //   237: aload 7
    //   239: invokevirtual 235	java/io/InputStream:close	()V
    //   242: return
    //   243: astore 6
    //   245: invokestatic 64	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   248: ifeq -201 -> 47
    //   251: aload_0
    //   252: getfield 29	com/tencent/mobileqq/activity/bless/BlessActivity:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   255: iconst_2
    //   256: ldc 160
    //   258: aload 6
    //   260: invokestatic 163	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   263: return
    //   264: new 165	java/io/File
    //   267: dup
    //   268: aload 8
    //   270: invokespecial 168	java/io/File:<init>	(Ljava/lang/String;)V
    //   273: astore 9
    //   275: aload 9
    //   277: invokevirtual 238	java/io/File:isDirectory	()Z
    //   280: istore 5
    //   282: iload 5
    //   284: ifne +35 -> 319
    //   287: aload 7
    //   289: ifnull -242 -> 47
    //   292: aload 7
    //   294: invokevirtual 235	java/io/InputStream:close	()V
    //   297: return
    //   298: astore 6
    //   300: invokestatic 64	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   303: ifeq -256 -> 47
    //   306: aload_0
    //   307: getfield 29	com/tencent/mobileqq/activity/bless/BlessActivity:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   310: iconst_2
    //   311: ldc 160
    //   313: aload 6
    //   315: invokestatic 163	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   318: return
    //   319: aload 9
    //   321: invokevirtual 242	java/io/File:list	()[Ljava/lang/String;
    //   324: arraylength
    //   325: istore_3
    //   326: aload_0
    //   327: getfield 141	com/tencent/mobileqq/activity/bless/BlessActivity:jdField_a_of_type_ComTencentMobileqqActivityBlessBlessManager	Lcom/tencent/mobileqq/activity/bless/BlessManager;
    //   330: invokevirtual 245	com/tencent/mobileqq/activity/bless/BlessManager:n	()I
    //   333: istore_2
    //   334: aload_0
    //   335: new 247	com/tencent/mobileqq/activity/bless/BlessActivity$AnimationDrawable2
    //   338: dup
    //   339: aload_0
    //   340: invokespecial 249	com/tencent/mobileqq/activity/bless/BlessActivity$AnimationDrawable2:<init>	(Lcom/tencent/mobileqq/activity/bless/BlessActivity;)V
    //   343: putfield 251	com/tencent/mobileqq/activity/bless/BlessActivity:jdField_a_of_type_ComTencentMobileqqActivityBlessBlessActivity$AnimationDrawable2	Lcom/tencent/mobileqq/activity/bless/BlessActivity$AnimationDrawable2;
    //   346: iload_1
    //   347: iload_3
    //   348: if_icmpge +66 -> 414
    //   351: new 66	java/lang/StringBuilder
    //   354: dup
    //   355: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   358: aload 8
    //   360: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   363: iload_1
    //   364: iconst_1
    //   365: iadd
    //   366: invokevirtual 212	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   369: ldc 214
    //   371: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   374: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   377: aload 6
    //   379: invokestatic 219	com/tencent/mobileqq/util/BitmapManager:a	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   382: astore 9
    //   384: aload_0
    //   385: getfield 251	com/tencent/mobileqq/activity/bless/BlessActivity:jdField_a_of_type_ComTencentMobileqqActivityBlessBlessActivity$AnimationDrawable2	Lcom/tencent/mobileqq/activity/bless/BlessActivity$AnimationDrawable2;
    //   388: new 253	android/graphics/drawable/BitmapDrawable
    //   391: dup
    //   392: aload_0
    //   393: invokevirtual 257	com/tencent/mobileqq/activity/bless/BlessActivity:getResources	()Landroid/content/res/Resources;
    //   396: aload 9
    //   398: invokespecial 260	android/graphics/drawable/BitmapDrawable:<init>	(Landroid/content/res/Resources;Landroid/graphics/Bitmap;)V
    //   401: iload_2
    //   402: iload_3
    //   403: idiv
    //   404: invokevirtual 264	com/tencent/mobileqq/activity/bless/BlessActivity$AnimationDrawable2:addFrame	(Landroid/graphics/drawable/Drawable;I)V
    //   407: iload_1
    //   408: iconst_1
    //   409: iadd
    //   410: istore_1
    //   411: goto -65 -> 346
    //   414: iload 4
    //   416: ifne +62 -> 478
    //   419: aload_0
    //   420: getfield 251	com/tencent/mobileqq/activity/bless/BlessActivity:jdField_a_of_type_ComTencentMobileqqActivityBlessBlessActivity$AnimationDrawable2	Lcom/tencent/mobileqq/activity/bless/BlessActivity$AnimationDrawable2;
    //   423: iconst_0
    //   424: invokevirtual 267	com/tencent/mobileqq/activity/bless/BlessActivity$AnimationDrawable2:setOneShot	(Z)V
    //   427: aload_0
    //   428: getfield 47	com/tencent/mobileqq/activity/bless/BlessActivity:jdField_b_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   431: new 269	wbm
    //   434: dup
    //   435: aload_0
    //   436: invokespecial 270	wbm:<init>	(Lcom/tencent/mobileqq/activity/bless/BlessActivity;)V
    //   439: ldc2_w 225
    //   442: invokevirtual 230	android/widget/ImageView:postDelayed	(Ljava/lang/Runnable;J)Z
    //   445: pop
    //   446: aload 7
    //   448: ifnull -401 -> 47
    //   451: aload 7
    //   453: invokevirtual 235	java/io/InputStream:close	()V
    //   456: return
    //   457: astore 6
    //   459: invokestatic 64	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   462: ifeq -415 -> 47
    //   465: aload_0
    //   466: getfield 29	com/tencent/mobileqq/activity/bless/BlessActivity:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   469: iconst_2
    //   470: ldc 160
    //   472: aload 6
    //   474: invokestatic 163	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   477: return
    //   478: aload_0
    //   479: getfield 251	com/tencent/mobileqq/activity/bless/BlessActivity:jdField_a_of_type_ComTencentMobileqqActivityBlessBlessActivity$AnimationDrawable2	Lcom/tencent/mobileqq/activity/bless/BlessActivity$AnimationDrawable2;
    //   482: iconst_1
    //   483: invokevirtual 267	com/tencent/mobileqq/activity/bless/BlessActivity$AnimationDrawable2:setOneShot	(Z)V
    //   486: aload_0
    //   487: getfield 251	com/tencent/mobileqq/activity/bless/BlessActivity:jdField_a_of_type_ComTencentMobileqqActivityBlessBlessActivity$AnimationDrawable2	Lcom/tencent/mobileqq/activity/bless/BlessActivity$AnimationDrawable2;
    //   490: new 272	wbl
    //   493: dup
    //   494: aload_0
    //   495: invokespecial 273	wbl:<init>	(Lcom/tencent/mobileqq/activity/bless/BlessActivity;)V
    //   498: invokevirtual 276	com/tencent/mobileqq/activity/bless/BlessActivity$AnimationDrawable2:a	(Lcom/tencent/mobileqq/activity/bless/BlessActivity$IAnimationFinishListener;)V
    //   501: goto -74 -> 427
    //   504: astore 8
    //   506: aload 7
    //   508: astore 6
    //   510: aload 8
    //   512: astore 7
    //   514: invokestatic 64	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   517: ifeq +16 -> 533
    //   520: aload_0
    //   521: getfield 29	com/tencent/mobileqq/activity/bless/BlessActivity:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   524: iconst_2
    //   525: ldc_w 278
    //   528: aload 7
    //   530: invokestatic 163	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   533: aload 6
    //   535: ifnull -488 -> 47
    //   538: aload 6
    //   540: invokevirtual 235	java/io/InputStream:close	()V
    //   543: return
    //   544: astore 6
    //   546: invokestatic 64	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   549: ifeq -502 -> 47
    //   552: aload_0
    //   553: getfield 29	com/tencent/mobileqq/activity/bless/BlessActivity:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   556: iconst_2
    //   557: ldc 160
    //   559: aload 6
    //   561: invokestatic 163	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   564: return
    //   565: astore 6
    //   567: aconst_null
    //   568: astore 7
    //   570: aload 7
    //   572: ifnull +8 -> 580
    //   575: aload 7
    //   577: invokevirtual 235	java/io/InputStream:close	()V
    //   580: aload 6
    //   582: athrow
    //   583: astore 7
    //   585: invokestatic 64	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   588: ifeq -8 -> 580
    //   591: aload_0
    //   592: getfield 29	com/tencent/mobileqq/activity/bless/BlessActivity:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   595: iconst_2
    //   596: ldc 160
    //   598: aload 7
    //   600: invokestatic 163	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   603: goto -23 -> 580
    //   606: astore 6
    //   608: goto -38 -> 570
    //   611: astore 8
    //   613: aload 6
    //   615: astore 7
    //   617: aload 8
    //   619: astore 6
    //   621: goto -51 -> 570
    //   624: astore 7
    //   626: goto -112 -> 514
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	629	0	this	BlessActivity
    //   1	410	1	i	int
    //   333	71	2	j	int
    //   325	79	3	k	int
    //   172	243	4	m	int
    //   28	255	5	bool	boolean
    //   3	1	6	localObject1	Object
    //   48	16	6	localException1	Exception
    //   132	89	6	localObject2	Object
    //   243	16	6	localException2	Exception
    //   298	80	6	localException3	Exception
    //   457	16	6	localException4	Exception
    //   508	31	6	localObject3	Object
    //   544	16	6	localException5	Exception
    //   565	16	6	localObject4	Object
    //   606	8	6	localObject5	Object
    //   619	1	6	localObject6	Object
    //   78	498	7	localObject7	Object
    //   583	16	7	localException6	Exception
    //   615	1	7	localObject8	Object
    //   624	1	7	localException7	Exception
    //   21	338	8	str	String
    //   504	7	8	localException8	Exception
    //   611	7	8	localObject9	Object
    //   12	385	9	localObject10	Object
    // Exception table:
    //   from	to	target	type
    //   39	47	48	java/lang/Exception
    //   237	242	243	java/lang/Exception
    //   292	297	298	java/lang/Exception
    //   451	456	457	java/lang/Exception
    //   125	174	504	java/lang/Exception
    //   180	232	504	java/lang/Exception
    //   264	282	504	java/lang/Exception
    //   319	346	504	java/lang/Exception
    //   351	407	504	java/lang/Exception
    //   419	427	504	java/lang/Exception
    //   427	446	504	java/lang/Exception
    //   478	501	504	java/lang/Exception
    //   538	543	544	java/lang/Exception
    //   5	30	565	finally
    //   69	114	565	finally
    //   114	125	565	finally
    //   575	580	583	java/lang/Exception
    //   125	174	606	finally
    //   180	232	606	finally
    //   264	282	606	finally
    //   319	346	606	finally
    //   351	407	606	finally
    //   419	427	606	finally
    //   427	446	606	finally
    //   478	501	606	finally
    //   514	533	611	finally
    //   5	30	624	java/lang/Exception
    //   69	114	624	java/lang/Exception
    //   114	125	624	java/lang/Exception
  }
  
  private void c()
  {
    if (this.jdField_c_of_type_Boolean) {
      return;
    }
    this.jdField_c_of_type_Boolean = true;
    Object localObject1 = (RelativeLayout)findViewById(2131362822);
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQVideoView == null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQVideoView = ((QQVideoView)findViewById(2131363351));
    }
    if (this.jdField_a_of_type_AndroidMediaAudioManager == null) {
      this.jdField_a_of_type_AndroidMediaAudioManager = ((AudioManager)getSystemService("audio"));
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQVideoView.setVideoPath(this.jdField_b_of_type_JavaLangString);
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
    int j = this.jdField_d_of_type_Int;
    int i = (int)(j / 900 * 700 + 0.5F);
    if (i % 2 == 1) {
      i += 1;
    }
    for (;;)
    {
      this.jdField_b_of_type_Boolean = true;
      d();
      Object localObject2 = (RelativeLayout.LayoutParams)findViewById(2131363350).getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject2).width = j;
      ((RelativeLayout.LayoutParams)localObject2).height = i;
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131363349));
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      try
      {
        localObject2 = new FileInputStream(this.jdField_c_of_type_JavaLangString);
        BitmapFactory.Options localOptions = new BitmapFactory.Options();
        localOptions.inSampleSize = ((int)ImageUtil.a((InputStream)localObject2, j, i));
        localObject2 = BitmapManager.a(this.jdField_c_of_type_JavaLangString, localOptions);
        if (localObject2 != null) {
          this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap((Bitmap)localObject2);
        }
        localObject2 = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject2).width = j;
        ((RelativeLayout.LayoutParams)localObject2).height = i;
        this.jdField_a_of_type_AndroidWidgetImageView.bringToFront();
      }
      catch (Exception localException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e(this.jdField_a_of_type_JavaLangString, 2, "decode mVideoCoverPath error = " + localException.getMessage());
          }
        }
      }
      findViewById(2131363360).bringToFront();
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQVideoView.setDimension(j, i);
      ((RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqWidgetQQVideoView.getLayoutParams()).setMargins(0, 0, 0, 0);
      this.jdField_b_of_type_AndroidViewView = new View(this);
      ((RelativeLayout)localObject1).addView(this.jdField_b_of_type_AndroidViewView);
      localObject1 = (RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidViewView.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject1).addRule(11);
      ((RelativeLayout.LayoutParams)localObject1).addRule(10);
      ((RelativeLayout.LayoutParams)localObject1).setMargins(0, (int)(localDisplayMetrics.density * 31.0F + 0.5F), 0, 0);
      ((RelativeLayout.LayoutParams)localObject1).width = ((int)(localDisplayMetrics.density * 60.0F + 0.5F));
      ((RelativeLayout.LayoutParams)localObject1).height = ((int)(localDisplayMetrics.density * 60.0F + 0.5F));
      this.jdField_b_of_type_AndroidViewView.bringToFront();
      this.jdField_b_of_type_AndroidViewView.setOnClickListener(new wbn(this));
      if (this.jdField_a_of_type_AndroidMediaAudioManager != null) {
        this.jdField_a_of_type_AndroidMediaAudioManager.requestAudioFocus(null, 3, 1);
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQVideoView.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQVideoView.setOnPreparedListener(new wbo(this));
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQVideoView.setOnCompletionListener(new wbq(this));
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQVideoView.setOnErrorListener(new wbr(this));
      return;
    }
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_AndroidContentBroadcastReceiver == null) {
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = new wbi(this);
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
    //   4: invokevirtual 94	com/tencent/mobileqq/activity/bless/BlessActivity:findViewById	(I)Landroid/view/View;
    //   7: checkcast 114	android/widget/ImageView
    //   10: astore_1
    //   11: aload_0
    //   12: getfield 141	com/tencent/mobileqq/activity/bless/BlessActivity:jdField_a_of_type_ComTencentMobileqqActivityBlessBlessManager	Lcom/tencent/mobileqq/activity/bless/BlessManager;
    //   15: invokevirtual 422	com/tencent/mobileqq/activity/bless/BlessManager:a	()Ljava/lang/String;
    //   18: astore_3
    //   19: aload_3
    //   20: ifnull +125 -> 145
    //   23: new 181	java/io/FileInputStream
    //   26: dup
    //   27: aload_3
    //   28: invokespecial 182	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   31: astore_2
    //   32: new 184	android/graphics/BitmapFactory$Options
    //   35: dup
    //   36: invokespecial 185	android/graphics/BitmapFactory$Options:<init>	()V
    //   39: astore 4
    //   41: aload 4
    //   43: aload_2
    //   44: aload_1
    //   45: invokevirtual 189	android/widget/ImageView:getLayoutParams	()Landroid/view/ViewGroup$LayoutParams;
    //   48: getfield 194	android/view/ViewGroup$LayoutParams:width	I
    //   51: aload_1
    //   52: invokevirtual 189	android/widget/ImageView:getLayoutParams	()Landroid/view/ViewGroup$LayoutParams;
    //   55: getfield 197	android/view/ViewGroup$LayoutParams:height	I
    //   58: invokestatic 202	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/io/InputStream;II)D
    //   61: d2i
    //   62: putfield 205	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   65: invokestatic 64	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   68: ifeq +53 -> 121
    //   71: aload_0
    //   72: getfield 29	com/tencent/mobileqq/activity/bless/BlessActivity:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   75: iconst_2
    //   76: new 66	java/lang/StringBuilder
    //   79: dup
    //   80: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   83: ldc_w 424
    //   86: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: aload_1
    //   90: invokevirtual 189	android/widget/ImageView:getLayoutParams	()Landroid/view/ViewGroup$LayoutParams;
    //   93: getfield 194	android/view/ViewGroup$LayoutParams:width	I
    //   96: invokevirtual 212	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   99: ldc_w 426
    //   102: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   105: aload_1
    //   106: invokevirtual 189	android/widget/ImageView:getLayoutParams	()Landroid/view/ViewGroup$LayoutParams;
    //   109: getfield 197	android/view/ViewGroup$LayoutParams:height	I
    //   112: invokevirtual 212	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   115: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   118: invokestatic 89	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   121: aload_3
    //   122: aload 4
    //   124: invokestatic 219	com/tencent/mobileqq/util/BitmapManager:a	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   127: astore_3
    //   128: aload_3
    //   129: ifnull +8 -> 137
    //   132: aload_1
    //   133: aload_3
    //   134: invokevirtual 331	android/widget/ImageView:setImageBitmap	(Landroid/graphics/Bitmap;)V
    //   137: aload_2
    //   138: ifnull +7 -> 145
    //   141: aload_2
    //   142: invokevirtual 235	java/io/InputStream:close	()V
    //   145: aload_0
    //   146: getfield 75	com/tencent/mobileqq/activity/bless/BlessActivity:jdField_a_of_type_Boolean	Z
    //   149: ifeq +30 -> 179
    //   152: aload_0
    //   153: ldc_w 283
    //   156: invokevirtual 94	com/tencent/mobileqq/activity/bless/BlessActivity:findViewById	(I)Landroid/view/View;
    //   159: checkcast 285	android/widget/RelativeLayout
    //   162: astore_1
    //   163: aload_1
    //   164: invokevirtual 430	android/widget/RelativeLayout:getViewTreeObserver	()Landroid/view/ViewTreeObserver;
    //   167: new 432	wbh
    //   170: dup
    //   171: aload_0
    //   172: aload_1
    //   173: invokespecial 435	wbh:<init>	(Lcom/tencent/mobileqq/activity/bless/BlessActivity;Landroid/widget/RelativeLayout;)V
    //   176: invokevirtual 441	android/view/ViewTreeObserver:addOnGlobalLayoutListener	(Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;)V
    //   179: aload_0
    //   180: getfield 141	com/tencent/mobileqq/activity/bless/BlessActivity:jdField_a_of_type_ComTencentMobileqqActivityBlessBlessManager	Lcom/tencent/mobileqq/activity/bless/BlessManager;
    //   183: invokevirtual 444	com/tencent/mobileqq/activity/bless/BlessManager:a	()Ljava/lang/Boolean;
    //   186: invokevirtual 449	java/lang/Boolean:booleanValue	()Z
    //   189: ifeq +32 -> 221
    //   192: aload_0
    //   193: aload_0
    //   194: ldc_w 450
    //   197: invokevirtual 94	com/tencent/mobileqq/activity/bless/BlessActivity:findViewById	(I)Landroid/view/View;
    //   200: checkcast 114	android/widget/ImageView
    //   203: putfield 47	com/tencent/mobileqq/activity/bless/BlessActivity:jdField_b_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   206: new 452	wbj
    //   209: dup
    //   210: aload_0
    //   211: invokespecial 453	wbj:<init>	(Lcom/tencent/mobileqq/activity/bless/BlessActivity;)V
    //   214: bipush 10
    //   216: aconst_null
    //   217: iconst_1
    //   218: invokestatic 459	com/tencent/mobileqq/app/ThreadManager:post	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   221: return
    //   222: astore_1
    //   223: invokestatic 64	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   226: ifeq -81 -> 145
    //   229: aload_0
    //   230: getfield 29	com/tencent/mobileqq/activity/bless/BlessActivity:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   233: iconst_2
    //   234: ldc 160
    //   236: invokestatic 397	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   239: goto -94 -> 145
    //   242: astore_1
    //   243: aconst_null
    //   244: astore_1
    //   245: invokestatic 64	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   248: ifeq +14 -> 262
    //   251: aload_0
    //   252: getfield 29	com/tencent/mobileqq/activity/bless/BlessActivity:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   255: iconst_2
    //   256: ldc_w 461
    //   259: invokestatic 397	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   262: aload_1
    //   263: ifnull -118 -> 145
    //   266: aload_1
    //   267: invokevirtual 235	java/io/InputStream:close	()V
    //   270: goto -125 -> 145
    //   273: astore_1
    //   274: invokestatic 64	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   277: ifeq -132 -> 145
    //   280: aload_0
    //   281: getfield 29	com/tencent/mobileqq/activity/bless/BlessActivity:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   284: iconst_2
    //   285: ldc 160
    //   287: invokestatic 397	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   290: goto -145 -> 145
    //   293: astore_1
    //   294: aconst_null
    //   295: astore_2
    //   296: aload_2
    //   297: ifnull +7 -> 304
    //   300: aload_2
    //   301: invokevirtual 235	java/io/InputStream:close	()V
    //   304: aload_1
    //   305: athrow
    //   306: astore_2
    //   307: invokestatic 64	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   310: ifeq -6 -> 304
    //   313: aload_0
    //   314: getfield 29	com/tencent/mobileqq/activity/bless/BlessActivity:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   317: iconst_2
    //   318: ldc 160
    //   320: invokestatic 397	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   323: goto -19 -> 304
    //   326: astore_1
    //   327: goto -31 -> 296
    //   330: astore_3
    //   331: aload_1
    //   332: astore_2
    //   333: aload_3
    //   334: astore_1
    //   335: goto -39 -> 296
    //   338: astore_1
    //   339: aload_2
    //   340: astore_1
    //   341: goto -96 -> 245
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	344	0	this	BlessActivity
    //   10	163	1	localObject1	Object
    //   222	1	1	localException1	Exception
    //   242	1	1	localFileNotFoundException1	java.io.FileNotFoundException
    //   244	23	1	localObject2	Object
    //   273	1	1	localException2	Exception
    //   293	12	1	localObject3	Object
    //   326	6	1	localObject4	Object
    //   334	1	1	localObject5	Object
    //   338	1	1	localFileNotFoundException2	java.io.FileNotFoundException
    //   340	1	1	localObject6	Object
    //   31	270	2	localFileInputStream	FileInputStream
    //   306	1	2	localException3	Exception
    //   332	8	2	localObject7	Object
    //   18	116	3	localObject8	Object
    //   330	4	3	localObject9	Object
    //   39	84	4	localOptions	BitmapFactory.Options
    // Exception table:
    //   from	to	target	type
    //   141	145	222	java/lang/Exception
    //   23	32	242	java/io/FileNotFoundException
    //   266	270	273	java/lang/Exception
    //   23	32	293	finally
    //   300	304	306	java/lang/Exception
    //   32	121	326	finally
    //   121	128	326	finally
    //   132	137	326	finally
    //   245	262	330	finally
    //   32	121	338	java/io/FileNotFoundException
    //   121	128	338	java/io/FileNotFoundException
    //   132	137	338	java/io/FileNotFoundException
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2130968711);
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
    this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessManager.b();
    if (this.jdField_a_of_type_AndroidContentBroadcastReceiver != null) {
      unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessActivity$AnimationDrawable2 != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessActivity$AnimationDrawable2.isRunning())) {
      this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessActivity$AnimationDrawable2.stop();
    }
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = null;
  }
  
  protected void doOnPause()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "doOnPause");
    }
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_b_of_type_Boolean))
    {
      if (!this.jdField_d_of_type_Boolean) {
        break label48;
      }
      a(true);
    }
    for (;;)
    {
      super.doOnPause();
      return;
      label48:
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQVideoView != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQVideoView.pause();
        this.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqWidgetQQVideoView.getCurrentPosition();
      }
    }
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    if ((this.jdField_a_of_type_Int != -1) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQVideoView != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQVideoView.seekTo(this.jdField_a_of_type_Int);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQVideoView.start();
      this.jdField_a_of_type_Int = -1;
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
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      super.onClick(paramView);
      return;
      if (this.jdField_a_of_type_Boolean) {
        a(true);
      }
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.bless.BlessActivity
 * JD-Core Version:    0.7.0.1
 */