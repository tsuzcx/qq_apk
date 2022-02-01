package com.tencent.mobileqq.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.home.impl.FrameControllerUtil;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import java.lang.ref.WeakReference;
import mqq.app.AppRuntime;

public class UserGuideWeishiFragment
  extends PublicBaseFragment
  implements View.OnClickListener
{
  private Handler jdField_a_of_type_AndroidOsHandler;
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private boolean jdField_a_of_type_Boolean = false;
  private View jdField_b_of_type_AndroidViewView;
  private boolean jdField_b_of_type_Boolean = false;
  
  private void a(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("UserGuideWeishiFragment", 2, "initUI has been called");
    }
    this.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131363740);
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131380314);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131380315));
    b();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(new UserGuideWeishiFragment.FinishDeLay5Seconds(new WeakReference(getBaseActivity())), 5000L);
    c();
  }
  
  /* Error */
  private void b()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 9
    //   3: aconst_null
    //   4: astore 8
    //   6: aconst_null
    //   7: astore 7
    //   9: aload_0
    //   10: invokevirtual 101	com/tencent/mobileqq/activity/UserGuideWeishiFragment:getResources	()Landroid/content/res/Resources;
    //   13: invokevirtual 107	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   16: getfield 113	android/util/DisplayMetrics:widthPixels	I
    //   19: istore_3
    //   20: aload_0
    //   21: invokevirtual 101	com/tencent/mobileqq/activity/UserGuideWeishiFragment:getResources	()Landroid/content/res/Resources;
    //   24: invokevirtual 107	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   27: getfield 116	android/util/DisplayMetrics:heightPixels	I
    //   30: istore 4
    //   32: iload 4
    //   34: ifle +45 -> 79
    //   37: aload_0
    //   38: getfield 45	com/tencent/mobileqq/activity/UserGuideWeishiFragment:jdField_b_of_type_AndroidViewView	Landroid/view/View;
    //   41: invokevirtual 120	android/view/View:getLayoutParams	()Landroid/view/ViewGroup$LayoutParams;
    //   44: astore 6
    //   46: iload 4
    //   48: i2d
    //   49: dstore_1
    //   50: dload_1
    //   51: invokestatic 126	java/lang/Double:isNaN	(D)Z
    //   54: pop
    //   55: dload_1
    //   56: ldc2_w 127
    //   59: dmul
    //   60: d2i
    //   61: istore 5
    //   63: aload 6
    //   65: iload 5
    //   67: putfield 133	android/view/ViewGroup$LayoutParams:height	I
    //   70: aload_0
    //   71: getfield 45	com/tencent/mobileqq/activity/UserGuideWeishiFragment:jdField_b_of_type_AndroidViewView	Landroid/view/View;
    //   74: aload 6
    //   76: invokevirtual 137	android/view/View:setLayoutParams	(Landroid/view/ViewGroup$LayoutParams;)V
    //   79: aload_0
    //   80: invokevirtual 80	com/tencent/mobileqq/activity/UserGuideWeishiFragment:getBaseActivity	()Lcom/tencent/mobileqq/app/BaseActivity;
    //   83: invokevirtual 143	com/tencent/mobileqq/app/BaseActivity:getAssets	()Landroid/content/res/AssetManager;
    //   86: ldc 145
    //   88: invokevirtual 151	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   91: astore 6
    //   93: aload 6
    //   95: ifnull +135 -> 230
    //   98: new 153	java/io/BufferedInputStream
    //   101: dup
    //   102: aload 6
    //   104: invokespecial 156	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   107: astore 7
    //   109: aload 7
    //   111: invokestatic 162	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   114: astore 8
    //   116: aload 8
    //   118: ifnull +70 -> 188
    //   121: new 164	com/tencent/widget/BottomDrawable
    //   124: dup
    //   125: aload 8
    //   127: iload_3
    //   128: iload 4
    //   130: invokespecial 167	com/tencent/widget/BottomDrawable:<init>	(Landroid/graphics/Bitmap;II)V
    //   133: astore 8
    //   135: aload_0
    //   136: getfield 57	com/tencent/mobileqq/activity/UserGuideWeishiFragment:jdField_a_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   139: invokevirtual 168	android/widget/ImageView:getLayoutParams	()Landroid/view/ViewGroup$LayoutParams;
    //   142: astore 9
    //   144: aload 9
    //   146: iload_3
    //   147: putfield 171	android/view/ViewGroup$LayoutParams:width	I
    //   150: aload 9
    //   152: iload 4
    //   154: putfield 133	android/view/ViewGroup$LayoutParams:height	I
    //   157: aload_0
    //   158: getfield 57	com/tencent/mobileqq/activity/UserGuideWeishiFragment:jdField_a_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   161: aload 9
    //   163: invokevirtual 172	android/widget/ImageView:setLayoutParams	(Landroid/view/ViewGroup$LayoutParams;)V
    //   166: aload_0
    //   167: getfield 57	com/tencent/mobileqq/activity/UserGuideWeishiFragment:jdField_a_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   170: getstatic 178	android/widget/ImageView$ScaleType:CENTER_CROP	Landroid/widget/ImageView$ScaleType;
    //   173: invokevirtual 182	android/widget/ImageView:setScaleType	(Landroid/widget/ImageView$ScaleType;)V
    //   176: aload_0
    //   177: getfield 57	com/tencent/mobileqq/activity/UserGuideWeishiFragment:jdField_a_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   180: aload 8
    //   182: invokevirtual 186	android/widget/ImageView:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   185: goto +11 -> 196
    //   188: ldc 30
    //   190: iconst_1
    //   191: ldc 188
    //   193: invokestatic 191	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   196: goto +42 -> 238
    //   199: astore 8
    //   201: goto +140 -> 341
    //   204: astore 8
    //   206: goto +21 -> 227
    //   209: astore 9
    //   211: aload 8
    //   213: astore 7
    //   215: aload 9
    //   217: astore 8
    //   219: goto +122 -> 341
    //   222: astore 8
    //   224: aconst_null
    //   225: astore 7
    //   227: goto +57 -> 284
    //   230: ldc 30
    //   232: iconst_1
    //   233: ldc 193
    //   235: invokestatic 191	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   238: aload 6
    //   240: ifnull +8 -> 248
    //   243: aload 6
    //   245: invokevirtual 198	java/io/InputStream:close	()V
    //   248: aload 7
    //   250: ifnull +88 -> 338
    //   253: aload 7
    //   255: invokevirtual 199	java/io/BufferedInputStream:close	()V
    //   258: return
    //   259: astore 9
    //   261: aconst_null
    //   262: astore 6
    //   264: aload 8
    //   266: astore 7
    //   268: aload 9
    //   270: astore 8
    //   272: goto +69 -> 341
    //   275: astore 8
    //   277: aconst_null
    //   278: astore 7
    //   280: aload 9
    //   282: astore 6
    //   284: aload 8
    //   286: invokevirtual 202	java/lang/Throwable:printStackTrace	()V
    //   289: ldc 30
    //   291: iconst_1
    //   292: ldc 204
    //   294: aload 8
    //   296: invokestatic 207	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   299: aload 6
    //   301: ifnull +11 -> 312
    //   304: aload 6
    //   306: invokevirtual 198	java/io/InputStream:close	()V
    //   309: goto +3 -> 312
    //   312: aload 7
    //   314: ifnull +24 -> 338
    //   317: aload 7
    //   319: invokevirtual 199	java/io/BufferedInputStream:close	()V
    //   322: return
    //   323: aload 6
    //   325: invokevirtual 202	java/lang/Throwable:printStackTrace	()V
    //   328: ldc 30
    //   330: iconst_1
    //   331: ldc 204
    //   333: aload 6
    //   335: invokestatic 207	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   338: return
    //   339: astore 8
    //   341: aload 6
    //   343: ifnull +11 -> 354
    //   346: aload 6
    //   348: invokevirtual 198	java/io/InputStream:close	()V
    //   351: goto +3 -> 354
    //   354: aload 7
    //   356: ifnull +26 -> 382
    //   359: aload 7
    //   361: invokevirtual 199	java/io/BufferedInputStream:close	()V
    //   364: goto +18 -> 382
    //   367: aload 6
    //   369: invokevirtual 202	java/lang/Throwable:printStackTrace	()V
    //   372: ldc 30
    //   374: iconst_1
    //   375: ldc 204
    //   377: aload 6
    //   379: invokestatic 207	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   382: aload 8
    //   384: athrow
    //   385: astore 6
    //   387: goto -64 -> 323
    //   390: astore 6
    //   392: goto -25 -> 367
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	395	0	this	UserGuideWeishiFragment
    //   49	7	1	d	double
    //   19	128	3	i	int
    //   30	123	4	j	int
    //   61	5	5	k	int
    //   44	334	6	localObject1	java.lang.Object
    //   385	1	6	localThrowable1	java.lang.Throwable
    //   390	1	6	localThrowable2	java.lang.Throwable
    //   7	353	7	localObject2	java.lang.Object
    //   4	177	8	localObject3	java.lang.Object
    //   199	1	8	localObject4	java.lang.Object
    //   204	8	8	localThrowable3	java.lang.Throwable
    //   217	1	8	localObject5	java.lang.Object
    //   222	43	8	localThrowable4	java.lang.Throwable
    //   270	1	8	localObject6	java.lang.Object
    //   275	20	8	localThrowable5	java.lang.Throwable
    //   339	44	8	localObject7	java.lang.Object
    //   1	161	9	localLayoutParams	android.view.ViewGroup.LayoutParams
    //   209	7	9	localObject8	java.lang.Object
    //   259	22	9	localObject9	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   109	116	199	finally
    //   121	185	199	finally
    //   188	196	199	finally
    //   109	116	204	java/lang/Throwable
    //   121	185	204	java/lang/Throwable
    //   188	196	204	java/lang/Throwable
    //   98	109	209	finally
    //   230	238	209	finally
    //   98	109	222	java/lang/Throwable
    //   230	238	222	java/lang/Throwable
    //   9	32	259	finally
    //   37	46	259	finally
    //   63	79	259	finally
    //   79	93	259	finally
    //   9	32	275	java/lang/Throwable
    //   37	46	275	java/lang/Throwable
    //   63	79	275	java/lang/Throwable
    //   79	93	275	java/lang/Throwable
    //   284	299	339	finally
    //   243	248	385	java/lang/Throwable
    //   253	258	385	java/lang/Throwable
    //   304	309	385	java/lang/Throwable
    //   317	322	385	java/lang/Throwable
    //   346	351	390	java/lang/Throwable
    //   359	364	390	java/lang/Throwable
  }
  
  private void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("UserGuideWeishiFragment", 2, "needAutoFinishForTalkBack-");
    }
    ThreadManager.excute(new UserGuideWeishiFragment.1(this), 16, null, true);
  }
  
  protected void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("UserGuideWeishiFragment", 2, "backToMainActivity has been called.");
    }
    BaseActivity localBaseActivity = getBaseActivity();
    if (localBaseActivity != null)
    {
      Intent localIntent = localBaseActivity.getIntent();
      AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
      if ((localAppRuntime != null) && (localAppRuntime.isLogin()))
      {
        localIntent.setClass(localBaseActivity, SplashActivity.class);
        localIntent.putExtra("tab_index", FrameControllerUtil.a);
        localIntent.addFlags(67108864);
        startActivity(localIntent);
        localBaseActivity.overridePendingTransition(2130772000, 2130772020);
        return;
      }
      localIntent.addFlags(67108864);
      RouteUtils.a(localBaseActivity, localIntent, "/base/login");
      localBaseActivity.overridePendingTransition(2130772000, 2130772020);
      return;
    }
    QLog.d("UserGuideWeishiFragment", 2, "UserGuideWeishiFragment activity ==null.");
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    super.initWindowStyleAndAnimation(paramActivity);
    if (paramActivity == null) {
      return;
    }
    paramActivity.setRequestedOrientation(1);
    paramActivity.getWindow().addFlags(1024);
  }
  
  public boolean needImmersive()
  {
    return false;
  }
  
  public boolean needStatusTrans()
  {
    return false;
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131380314)
    {
      if (QLog.isColorLevel()) {
        QLog.d("UserGuideWeishiFragment", 2, "user_guide_enter_qq has been clicked");
      }
      getBaseActivity().finish();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131563015, null);
    a(paramLayoutInflater);
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    UserguideActivity.jdField_a_of_type_Boolean = false;
    super.onDestroy();
  }
  
  public void onFinish()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isDestroyed ");
      localStringBuilder.append(this.jdField_b_of_type_Boolean);
      QLog.d("UserGuideWeishiFragment", 2, localStringBuilder.toString());
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    if (!this.jdField_b_of_type_Boolean)
    {
      this.jdField_b_of_type_Boolean = true;
      UserguideActivity.jdField_a_of_type_Boolean = false;
      if (this.jdField_a_of_type_Boolean) {
        a();
      }
      super.onFinish();
    }
  }
  
  public void onResume()
  {
    this.jdField_a_of_type_Boolean = true;
    super.onResume();
  }
  
  public void onStop()
  {
    this.jdField_a_of_type_Boolean = false;
    super.onStop();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.UserGuideWeishiFragment
 * JD-Core Version:    0.7.0.1
 */