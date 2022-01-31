package com.tencent.mobileqq.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class UserGuideWeishiFragment
  extends PublicBaseFragment
  implements View.OnClickListener
{
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private boolean jdField_a_of_type_Boolean;
  private View b;
  
  private void a(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("UserGuideWeishiFragment", 2, "initUI has been called");
    }
    this.b = paramView.findViewById(2131375417);
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131375415);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131375416));
    c();
  }
  
  /* Error */
  private void c()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore 5
    //   6: aload_0
    //   7: invokevirtual 61	com/tencent/mobileqq/activity/UserGuideWeishiFragment:getResources	()Landroid/content/res/Resources;
    //   10: invokevirtual 67	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   13: getfield 73	android/util/DisplayMetrics:widthPixels	I
    //   16: istore_1
    //   17: aload_0
    //   18: invokevirtual 61	com/tencent/mobileqq/activity/UserGuideWeishiFragment:getResources	()Landroid/content/res/Resources;
    //   21: invokevirtual 67	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   24: getfield 76	android/util/DisplayMetrics:heightPixels	I
    //   27: istore_2
    //   28: iload_2
    //   29: ifle +30 -> 59
    //   32: aload_0
    //   33: getfield 40	com/tencent/mobileqq/activity/UserGuideWeishiFragment:b	Landroid/view/View;
    //   36: invokevirtual 80	android/view/View:getLayoutParams	()Landroid/view/ViewGroup$LayoutParams;
    //   39: astore_3
    //   40: aload_3
    //   41: iload_2
    //   42: i2d
    //   43: ldc2_w 81
    //   46: dmul
    //   47: d2i
    //   48: putfield 87	android/view/ViewGroup$LayoutParams:height	I
    //   51: aload_0
    //   52: getfield 40	com/tencent/mobileqq/activity/UserGuideWeishiFragment:b	Landroid/view/View;
    //   55: aload_3
    //   56: invokevirtual 91	android/view/View:setLayoutParams	(Landroid/view/ViewGroup$LayoutParams;)V
    //   59: aload_0
    //   60: invokevirtual 95	com/tencent/mobileqq/activity/UserGuideWeishiFragment:getActivity	()Landroid/support/v4/app/FragmentActivity;
    //   63: invokevirtual 101	android/support/v4/app/FragmentActivity:getAssets	()Landroid/content/res/AssetManager;
    //   66: ldc 103
    //   68: invokevirtual 109	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   71: astore_3
    //   72: aload_3
    //   73: ifnull +172 -> 245
    //   76: new 111	java/io/BufferedInputStream
    //   79: dup
    //   80: aload_3
    //   81: invokespecial 114	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   84: astore 4
    //   86: new 116	com/tencent/widget/BottomDrawable
    //   89: dup
    //   90: aload 4
    //   92: invokestatic 122	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   95: iload_1
    //   96: iload_2
    //   97: invokespecial 125	com/tencent/widget/BottomDrawable:<init>	(Landroid/graphics/Bitmap;II)V
    //   100: astore 5
    //   102: aload 5
    //   104: ifnull +71 -> 175
    //   107: aload_0
    //   108: getfield 52	com/tencent/mobileqq/activity/UserGuideWeishiFragment:jdField_a_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   111: invokevirtual 126	android/widget/ImageView:getLayoutParams	()Landroid/view/ViewGroup$LayoutParams;
    //   114: astore 6
    //   116: aload 6
    //   118: iload_1
    //   119: putfield 129	android/view/ViewGroup$LayoutParams:width	I
    //   122: aload 6
    //   124: iload_2
    //   125: putfield 87	android/view/ViewGroup$LayoutParams:height	I
    //   128: aload_0
    //   129: getfield 52	com/tencent/mobileqq/activity/UserGuideWeishiFragment:jdField_a_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   132: aload 6
    //   134: invokevirtual 130	android/widget/ImageView:setLayoutParams	(Landroid/view/ViewGroup$LayoutParams;)V
    //   137: aload_0
    //   138: getfield 52	com/tencent/mobileqq/activity/UserGuideWeishiFragment:jdField_a_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   141: getstatic 136	android/widget/ImageView$ScaleType:CENTER_CROP	Landroid/widget/ImageView$ScaleType;
    //   144: invokevirtual 140	android/widget/ImageView:setScaleType	(Landroid/widget/ImageView$ScaleType;)V
    //   147: aload_0
    //   148: getfield 52	com/tencent/mobileqq/activity/UserGuideWeishiFragment:jdField_a_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   151: aload 5
    //   153: invokevirtual 144	android/widget/ImageView:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   156: aload_3
    //   157: ifnull +7 -> 164
    //   160: aload_3
    //   161: invokevirtual 149	java/io/InputStream:close	()V
    //   164: aload 4
    //   166: ifnull +8 -> 174
    //   169: aload 4
    //   171: invokevirtual 150	java/io/BufferedInputStream:close	()V
    //   174: return
    //   175: ldc 152
    //   177: iconst_1
    //   178: ldc 154
    //   180: invokestatic 157	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   183: goto -27 -> 156
    //   186: astore 6
    //   188: aload 4
    //   190: astore 5
    //   192: aload 6
    //   194: astore 4
    //   196: aload 4
    //   198: invokevirtual 160	java/lang/Throwable:printStackTrace	()V
    //   201: ldc 152
    //   203: iconst_1
    //   204: ldc 162
    //   206: aload 4
    //   208: invokestatic 165	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   211: aload_3
    //   212: ifnull +7 -> 219
    //   215: aload_3
    //   216: invokevirtual 149	java/io/InputStream:close	()V
    //   219: aload 5
    //   221: ifnull -47 -> 174
    //   224: aload 5
    //   226: invokevirtual 150	java/io/BufferedInputStream:close	()V
    //   229: return
    //   230: astore_3
    //   231: aload_3
    //   232: invokevirtual 160	java/lang/Throwable:printStackTrace	()V
    //   235: ldc 152
    //   237: iconst_1
    //   238: ldc 162
    //   240: aload_3
    //   241: invokestatic 165	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   244: return
    //   245: ldc 152
    //   247: iconst_1
    //   248: ldc 167
    //   250: invokestatic 157	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   253: aconst_null
    //   254: astore 4
    //   256: goto -100 -> 156
    //   259: astore_3
    //   260: aload_3
    //   261: invokevirtual 160	java/lang/Throwable:printStackTrace	()V
    //   264: ldc 152
    //   266: iconst_1
    //   267: ldc 162
    //   269: aload_3
    //   270: invokestatic 165	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   273: return
    //   274: astore 4
    //   276: aconst_null
    //   277: astore_3
    //   278: aload 6
    //   280: astore 5
    //   282: aload_3
    //   283: ifnull +7 -> 290
    //   286: aload_3
    //   287: invokevirtual 149	java/io/InputStream:close	()V
    //   290: aload 5
    //   292: ifnull +8 -> 300
    //   295: aload 5
    //   297: invokevirtual 150	java/io/BufferedInputStream:close	()V
    //   300: aload 4
    //   302: athrow
    //   303: astore_3
    //   304: aload_3
    //   305: invokevirtual 160	java/lang/Throwable:printStackTrace	()V
    //   308: ldc 152
    //   310: iconst_1
    //   311: ldc 162
    //   313: aload_3
    //   314: invokestatic 165	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   317: goto -17 -> 300
    //   320: astore 4
    //   322: aload 6
    //   324: astore 5
    //   326: goto -44 -> 282
    //   329: astore 6
    //   331: aload 4
    //   333: astore 5
    //   335: aload 6
    //   337: astore 4
    //   339: goto -57 -> 282
    //   342: astore 4
    //   344: goto -62 -> 282
    //   347: astore 4
    //   349: aconst_null
    //   350: astore_3
    //   351: goto -155 -> 196
    //   354: astore 4
    //   356: goto -160 -> 196
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	359	0	this	UserGuideWeishiFragment
    //   16	103	1	i	int
    //   27	98	2	j	int
    //   39	177	3	localObject1	java.lang.Object
    //   230	11	3	localThrowable1	java.lang.Throwable
    //   259	11	3	localThrowable2	java.lang.Throwable
    //   277	10	3	localObject2	java.lang.Object
    //   303	11	3	localThrowable3	java.lang.Throwable
    //   350	1	3	localObject3	java.lang.Object
    //   84	171	4	localObject4	java.lang.Object
    //   274	27	4	localObject5	java.lang.Object
    //   320	12	4	localObject6	java.lang.Object
    //   337	1	4	localObject7	java.lang.Object
    //   342	1	4	localObject8	java.lang.Object
    //   347	1	4	localThrowable4	java.lang.Throwable
    //   354	1	4	localThrowable5	java.lang.Throwable
    //   4	330	5	localObject9	java.lang.Object
    //   1	132	6	localLayoutParams	android.view.ViewGroup.LayoutParams
    //   186	137	6	localThrowable6	java.lang.Throwable
    //   329	7	6	localObject10	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   86	102	186	java/lang/Throwable
    //   107	156	186	java/lang/Throwable
    //   175	183	186	java/lang/Throwable
    //   215	219	230	java/lang/Throwable
    //   224	229	230	java/lang/Throwable
    //   160	164	259	java/lang/Throwable
    //   169	174	259	java/lang/Throwable
    //   6	28	274	finally
    //   32	59	274	finally
    //   59	72	274	finally
    //   286	290	303	java/lang/Throwable
    //   295	300	303	java/lang/Throwable
    //   76	86	320	finally
    //   245	253	320	finally
    //   86	102	329	finally
    //   107	156	329	finally
    //   175	183	329	finally
    //   196	211	342	finally
    //   6	28	347	java/lang/Throwable
    //   32	59	347	java/lang/Throwable
    //   59	72	347	java/lang/Throwable
    //   76	86	354	java/lang/Throwable
    //   245	253	354	java/lang/Throwable
  }
  
  public void a(Activity paramActivity)
  {
    super.a(paramActivity);
    if (paramActivity == null) {
      return;
    }
    paramActivity.setRequestedOrientation(1);
    paramActivity.getWindow().addFlags(1024);
  }
  
  public boolean a()
  {
    return false;
  }
  
  protected void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("UserGuideWeiShiActivity", 2, "backToMainActivity has been called.");
    }
    FragmentActivity localFragmentActivity = getActivity();
    if (localFragmentActivity != null)
    {
      Intent localIntent = localFragmentActivity.getIntent();
      AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
      if ((localAppRuntime != null) && (localAppRuntime.isLogin()))
      {
        localIntent.setClass(localFragmentActivity, SplashActivity.class);
        localIntent.putExtra("tab_index", MainFragment.a);
      }
      for (;;)
      {
        localIntent.addFlags(67108864);
        startActivity(localIntent);
        localFragmentActivity.overridePendingTransition(2131034128, 2131034139);
        return;
        localIntent.setClass(localFragmentActivity, LoginActivity.class);
      }
    }
    QLog.d("UserGuideWeiShiActivity", 2, "UserGuideWeishiFragment activity ==null.");
  }
  
  public boolean b()
  {
    return false;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("UserGuideWeishiFragment", 2, "user_guide_enter_qq has been clicked");
    }
    getActivity().finish();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2130971710, null);
    a(paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    UserguideActivity.jdField_a_of_type_Boolean = false;
    super.onDestroy();
  }
  
  public void u_()
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = true;
      UserguideActivity.jdField_a_of_type_Boolean = false;
      b();
      super.u_();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.UserGuideWeishiFragment
 * JD-Core Version:    0.7.0.1
 */