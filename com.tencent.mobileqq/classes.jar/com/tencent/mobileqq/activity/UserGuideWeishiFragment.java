package com.tencent.mobileqq.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import java.lang.ref.WeakReference;
import mqq.app.AppRuntime;

public class UserGuideWeishiFragment
  extends PublicBaseFragment
  implements View.OnClickListener
{
  private Handler jdField_a_of_type_AndroidOsHandler;
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private boolean jdField_a_of_type_Boolean;
  private View jdField_b_of_type_AndroidViewView;
  private boolean jdField_b_of_type_Boolean;
  
  private void a(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("UserGuideWeishiFragment", 2, "initUI has been called");
    }
    this.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131363593);
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131380359);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131380360));
    b();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(new UserGuideWeishiFragment.FinishDeLay5Seconds(new WeakReference(getActivity())), 5000L);
    c();
  }
  
  /* Error */
  private void b()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore 5
    //   6: aload_0
    //   7: invokevirtual 97	com/tencent/mobileqq/activity/UserGuideWeishiFragment:getResources	()Landroid/content/res/Resources;
    //   10: invokevirtual 103	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   13: getfield 109	android/util/DisplayMetrics:widthPixels	I
    //   16: istore_1
    //   17: aload_0
    //   18: invokevirtual 97	com/tencent/mobileqq/activity/UserGuideWeishiFragment:getResources	()Landroid/content/res/Resources;
    //   21: invokevirtual 103	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   24: getfield 112	android/util/DisplayMetrics:heightPixels	I
    //   27: istore_2
    //   28: iload_2
    //   29: ifle +30 -> 59
    //   32: aload_0
    //   33: getfield 41	com/tencent/mobileqq/activity/UserGuideWeishiFragment:jdField_b_of_type_AndroidViewView	Landroid/view/View;
    //   36: invokevirtual 116	android/view/View:getLayoutParams	()Landroid/view/ViewGroup$LayoutParams;
    //   39: astore_3
    //   40: aload_3
    //   41: iload_2
    //   42: i2d
    //   43: ldc2_w 117
    //   46: dmul
    //   47: d2i
    //   48: putfield 123	android/view/ViewGroup$LayoutParams:height	I
    //   51: aload_0
    //   52: getfield 41	com/tencent/mobileqq/activity/UserGuideWeishiFragment:jdField_b_of_type_AndroidViewView	Landroid/view/View;
    //   55: aload_3
    //   56: invokevirtual 127	android/view/View:setLayoutParams	(Landroid/view/ViewGroup$LayoutParams;)V
    //   59: aload_0
    //   60: invokevirtual 76	com/tencent/mobileqq/activity/UserGuideWeishiFragment:getActivity	()Landroid/support/v4/app/FragmentActivity;
    //   63: invokevirtual 133	android/support/v4/app/FragmentActivity:getAssets	()Landroid/content/res/AssetManager;
    //   66: ldc 135
    //   68: invokevirtual 141	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   71: astore_3
    //   72: aload_3
    //   73: ifnull +223 -> 296
    //   76: new 143	java/io/BufferedInputStream
    //   79: dup
    //   80: aload_3
    //   81: invokespecial 146	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   84: astore 4
    //   86: aload 4
    //   88: invokestatic 152	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   91: astore 5
    //   93: aload 5
    //   95: ifnull +159 -> 254
    //   98: new 154	bkiw
    //   101: dup
    //   102: aload 5
    //   104: iload_1
    //   105: iload_2
    //   106: invokespecial 157	bkiw:<init>	(Landroid/graphics/Bitmap;II)V
    //   109: astore 5
    //   111: aload 5
    //   113: ifnull +71 -> 184
    //   116: aload_0
    //   117: getfield 53	com/tencent/mobileqq/activity/UserGuideWeishiFragment:jdField_a_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   120: invokevirtual 158	android/widget/ImageView:getLayoutParams	()Landroid/view/ViewGroup$LayoutParams;
    //   123: astore 6
    //   125: aload 6
    //   127: iload_1
    //   128: putfield 161	android/view/ViewGroup$LayoutParams:width	I
    //   131: aload 6
    //   133: iload_2
    //   134: putfield 123	android/view/ViewGroup$LayoutParams:height	I
    //   137: aload_0
    //   138: getfield 53	com/tencent/mobileqq/activity/UserGuideWeishiFragment:jdField_a_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   141: aload 6
    //   143: invokevirtual 162	android/widget/ImageView:setLayoutParams	(Landroid/view/ViewGroup$LayoutParams;)V
    //   146: aload_0
    //   147: getfield 53	com/tencent/mobileqq/activity/UserGuideWeishiFragment:jdField_a_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   150: getstatic 168	android/widget/ImageView$ScaleType:CENTER_CROP	Landroid/widget/ImageView$ScaleType;
    //   153: invokevirtual 172	android/widget/ImageView:setScaleType	(Landroid/widget/ImageView$ScaleType;)V
    //   156: aload_0
    //   157: getfield 53	com/tencent/mobileqq/activity/UserGuideWeishiFragment:jdField_a_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   160: aload 5
    //   162: invokevirtual 176	android/widget/ImageView:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   165: aload_3
    //   166: ifnull +7 -> 173
    //   169: aload_3
    //   170: invokevirtual 181	java/io/InputStream:close	()V
    //   173: aload 4
    //   175: ifnull +8 -> 183
    //   178: aload 4
    //   180: invokevirtual 182	java/io/BufferedInputStream:close	()V
    //   183: return
    //   184: ldc 26
    //   186: iconst_1
    //   187: ldc 184
    //   189: invokestatic 187	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   192: goto -27 -> 165
    //   195: astore 6
    //   197: aload 4
    //   199: astore 5
    //   201: aload 6
    //   203: astore 4
    //   205: aload 4
    //   207: invokevirtual 190	java/lang/Throwable:printStackTrace	()V
    //   210: ldc 26
    //   212: iconst_1
    //   213: ldc 192
    //   215: aload 4
    //   217: invokestatic 195	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   220: aload_3
    //   221: ifnull +7 -> 228
    //   224: aload_3
    //   225: invokevirtual 181	java/io/InputStream:close	()V
    //   228: aload 5
    //   230: ifnull -47 -> 183
    //   233: aload 5
    //   235: invokevirtual 182	java/io/BufferedInputStream:close	()V
    //   238: return
    //   239: astore_3
    //   240: aload_3
    //   241: invokevirtual 190	java/lang/Throwable:printStackTrace	()V
    //   244: ldc 26
    //   246: iconst_1
    //   247: ldc 192
    //   249: aload_3
    //   250: invokestatic 195	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   253: return
    //   254: ldc 26
    //   256: iconst_1
    //   257: ldc 197
    //   259: invokestatic 187	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   262: goto -97 -> 165
    //   265: astore 6
    //   267: aload 4
    //   269: astore 5
    //   271: aload 6
    //   273: astore 4
    //   275: aload_3
    //   276: ifnull +7 -> 283
    //   279: aload_3
    //   280: invokevirtual 181	java/io/InputStream:close	()V
    //   283: aload 5
    //   285: ifnull +8 -> 293
    //   288: aload 5
    //   290: invokevirtual 182	java/io/BufferedInputStream:close	()V
    //   293: aload 4
    //   295: athrow
    //   296: ldc 26
    //   298: iconst_1
    //   299: ldc 199
    //   301: invokestatic 187	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   304: aconst_null
    //   305: astore 4
    //   307: goto -142 -> 165
    //   310: astore_3
    //   311: aload_3
    //   312: invokevirtual 190	java/lang/Throwable:printStackTrace	()V
    //   315: ldc 26
    //   317: iconst_1
    //   318: ldc 192
    //   320: aload_3
    //   321: invokestatic 195	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   324: return
    //   325: astore_3
    //   326: aload_3
    //   327: invokevirtual 190	java/lang/Throwable:printStackTrace	()V
    //   330: ldc 26
    //   332: iconst_1
    //   333: ldc 192
    //   335: aload_3
    //   336: invokestatic 195	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   339: goto -46 -> 293
    //   342: astore 4
    //   344: aconst_null
    //   345: astore_3
    //   346: aload 6
    //   348: astore 5
    //   350: goto -75 -> 275
    //   353: astore 4
    //   355: aload 6
    //   357: astore 5
    //   359: goto -84 -> 275
    //   362: astore 4
    //   364: goto -89 -> 275
    //   367: astore 4
    //   369: aconst_null
    //   370: astore_3
    //   371: goto -166 -> 205
    //   374: astore 4
    //   376: goto -171 -> 205
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	379	0	this	UserGuideWeishiFragment
    //   16	112	1	i	int
    //   27	107	2	j	int
    //   39	186	3	localObject1	java.lang.Object
    //   239	41	3	localThrowable1	java.lang.Throwable
    //   310	11	3	localThrowable2	java.lang.Throwable
    //   325	11	3	localThrowable3	java.lang.Throwable
    //   345	26	3	localObject2	java.lang.Object
    //   84	222	4	localObject3	java.lang.Object
    //   342	1	4	localObject4	java.lang.Object
    //   353	1	4	localObject5	java.lang.Object
    //   362	1	4	localObject6	java.lang.Object
    //   367	1	4	localThrowable4	java.lang.Throwable
    //   374	1	4	localThrowable5	java.lang.Throwable
    //   4	354	5	localObject7	java.lang.Object
    //   1	141	6	localLayoutParams	android.view.ViewGroup.LayoutParams
    //   195	7	6	localThrowable6	java.lang.Throwable
    //   265	91	6	localObject8	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   86	93	195	java/lang/Throwable
    //   98	111	195	java/lang/Throwable
    //   116	165	195	java/lang/Throwable
    //   184	192	195	java/lang/Throwable
    //   254	262	195	java/lang/Throwable
    //   224	228	239	java/lang/Throwable
    //   233	238	239	java/lang/Throwable
    //   86	93	265	finally
    //   98	111	265	finally
    //   116	165	265	finally
    //   184	192	265	finally
    //   254	262	265	finally
    //   169	173	310	java/lang/Throwable
    //   178	183	310	java/lang/Throwable
    //   279	283	325	java/lang/Throwable
    //   288	293	325	java/lang/Throwable
    //   6	28	342	finally
    //   32	59	342	finally
    //   59	72	342	finally
    //   76	86	353	finally
    //   296	304	353	finally
    //   205	220	362	finally
    //   6	28	367	java/lang/Throwable
    //   32	59	367	java/lang/Throwable
    //   59	72	367	java/lang/Throwable
    //   76	86	374	java/lang/Throwable
    //   296	304	374	java/lang/Throwable
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
    FragmentActivity localFragmentActivity = getActivity();
    if (localFragmentActivity != null)
    {
      Intent localIntent = localFragmentActivity.getIntent();
      AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
      if ((localAppRuntime != null) && (localAppRuntime.isLogin()))
      {
        localIntent.setClass(localFragmentActivity, SplashActivity.class);
        localIntent.putExtra("tab_index", MainFragment.b);
      }
      for (;;)
      {
        localIntent.addFlags(67108864);
        startActivity(localIntent);
        localFragmentActivity.overridePendingTransition(2130771986, 2130772006);
        return;
        localIntent.setClass(localFragmentActivity, LoginActivity.class);
      }
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
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("UserGuideWeishiFragment", 2, "user_guide_enter_qq has been clicked");
      }
      getActivity().finish();
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131563045, null);
    a(paramLayoutInflater);
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    UserguideActivity.jdField_a_of_type_Boolean = false;
    super.onDestroy();
  }
  
  public void onFinish()
  {
    if (QLog.isColorLevel()) {
      QLog.d("UserGuideWeishiFragment", 2, "isDestroyed " + this.jdField_b_of_type_Boolean);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.UserGuideWeishiFragment
 * JD-Core Version:    0.7.0.1
 */