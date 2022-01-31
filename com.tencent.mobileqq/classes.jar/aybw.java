import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Point;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.support.v4.app.FragmentManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.qrcode.activity.ScannerActivity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.pluginsdk.PluginProxyActivity;
import com.tencent.mobileqq.screendetect.ScreenShotFragment;
import com.tencent.mobileqq.screendetect.ScreenShotHelper.2;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import mqq.app.AppActivity;

public class aybw
{
  private static aybm jdField_a_of_type_Aybm;
  private static List<Integer> jdField_a_of_type_JavaUtilList = new ArrayList();
  public static boolean a;
  private static boolean b;
  
  static
  {
    jdField_a_of_type_Boolean = true;
    jdField_a_of_type_JavaUtilList.clear();
    jdField_a_of_type_JavaUtilList.add(Integer.valueOf(0));
    jdField_a_of_type_JavaUtilList.add(Integer.valueOf(1));
    jdField_a_of_type_JavaUtilList.add(Integer.valueOf(3000));
    jdField_a_of_type_JavaUtilList.add(Integer.valueOf(1004));
    jdField_a_of_type_JavaUtilList.add(Integer.valueOf(1000));
    jdField_a_of_type_JavaUtilList.add(Integer.valueOf(1022));
    jdField_a_of_type_JavaUtilList.add(Integer.valueOf(1001));
    jdField_a_of_type_JavaUtilList.add(Integer.valueOf(10002));
    jdField_a_of_type_JavaUtilList.add(Integer.valueOf(1006));
    jdField_a_of_type_JavaUtilList.add(Integer.valueOf(1005));
    jdField_a_of_type_JavaUtilList.add(Integer.valueOf(10008));
  }
  
  public static Point a(Context paramContext)
  {
    try
    {
      localObject = new Point();
      try
      {
        paramContext = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay();
        if (Build.VERSION.SDK_INT >= 17) {
          paramContext.getRealSize((Point)localObject);
        }
        for (;;)
        {
          return localObject;
          try
          {
            Method localMethod1 = Display.class.getMethod("getRawWidth", new Class[0]);
            Method localMethod2 = Display.class.getMethod("getRawHeight", new Class[0]);
            ((Point)localObject).set(((Integer)localMethod1.invoke(paramContext, new Object[0])).intValue(), ((Integer)localMethod2.invoke(paramContext, new Object[0])).intValue());
          }
          catch (Exception localException2)
          {
            ((Point)localObject).set(paramContext.getWidth(), paramContext.getHeight());
            localException2.printStackTrace();
          }
        }
        QLog.e("ScreenShotHelper", 1, "getRealScreenSize error.", (Throwable)localObject);
      }
      catch (Exception localException3)
      {
        paramContext = (Context)localObject;
        localObject = localException3;
      }
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        Object localObject;
        paramContext = null;
      }
    }
    return paramContext;
  }
  
  private List<RecentBaseData> a(List<RecentBaseData> paramList, Activity paramActivity, QQAppInterface paramQQAppInterface)
  {
    ArrayList localArrayList = new ArrayList();
    for (;;)
    {
      int j;
      try
      {
        int k = paramList.size();
        j = 0;
        int i = -1;
        if (j < k)
        {
          RecentBaseData localRecentBaseData = (RecentBaseData)paramList.get(j);
          if (a(localRecentBaseData))
          {
            localArrayList.add(localRecentBaseData);
          }
          else if ((localRecentBaseData.a() == 6000) && (TextUtils.equals(localRecentBaseData.a(), aljq.z)))
          {
            localArrayList.add(localRecentBaseData);
            i = j;
          }
        }
        else
        {
          if ((localArrayList.size() == 0) || (i == -1))
          {
            QLog.d("ScreenShotHelper", 2, "filterRecentUser resultList.size = " + localArrayList.size() + ", index = " + i);
            paramList = ajdp.a(new RecentUser(aljq.z, 6000), paramQQAppInterface, paramActivity);
            if (paramList != null)
            {
              paramList.mTitleName = paramActivity.getResources().getString(2131694081);
              localArrayList.add(paramList);
            }
          }
          Collections.sort(localArrayList, new ajdq(paramQQAppInterface));
          return localArrayList;
        }
      }
      catch (Exception paramList)
      {
        QLog.e("ScreenShotHelper", 1, "filterRecentUser error.", paramList);
        return localArrayList;
      }
      j += 1;
    }
  }
  
  private static void a()
  {
    aybm localaybm2 = (aybm)aogj.a().a(485);
    aybm localaybm1 = localaybm2;
    if (localaybm2 == null)
    {
      localaybm2 = new aybm();
      localaybm1 = localaybm2;
      if (QLog.isColorLevel())
      {
        QLog.d("ScreenShotHelper", 2, "ScreenShotConfigData = null, general new bean, so switch default is opened!");
        localaybm1 = localaybm2;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("ScreenShotHelper", 2, "ScreenShotConfigData switch isOpened = " + localaybm1);
    }
    jdField_a_of_type_Aybm = localaybm1;
  }
  
  public static void a(Activity paramActivity)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScreenShotHelper", 2, "removeFloatView() called with: activity = [" + paramActivity + "]");
    }
    paramActivity = ((ViewGroup)paramActivity.getWindow().getDecorView().getRootView()).findViewById(2131376132);
    if (paramActivity != null) {
      ((ViewGroup)paramActivity.getParent()).removeView(paramActivity);
    }
  }
  
  public static void a(Activity paramActivity, Handler paramHandler)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScreenShotHelper", 2, "onActivityResumeHideFloatView");
    }
    View localView = ((ViewGroup)paramActivity.getWindow().getDecorView().getRootView()).findViewById(2131376132);
    if (localView != null)
    {
      localView.setVisibility(0);
      paramHandler.postDelayed(new ScreenShotHelper.2(new WeakReference(paramActivity), localView, paramHandler), 5000L);
    }
  }
  
  public static void a(Activity paramActivity, MotionEvent paramMotionEvent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScreenShotHelper", 2, "disaptchTouchEventCallback() called with: activity = [" + paramActivity + "], ev = [" + paramMotionEvent + "]");
    }
    paramActivity = ((ViewGroup)paramActivity.getWindow().getDecorView().getRootView()).findViewById(2131376132);
    if (paramActivity != null)
    {
      int[] arrayOfInt = new int[2];
      paramActivity.getLocationOnScreen(arrayOfInt);
      if (!new RectF(arrayOfInt[0], arrayOfInt[1], arrayOfInt[0] + paramActivity.getWidth(), arrayOfInt[1] + paramActivity.getHeight()).contains(paramMotionEvent.getRawX(), paramMotionEvent.getRawY())) {
        ((ViewGroup)paramActivity.getParent()).removeView(paramActivity);
      }
    }
  }
  
  public static void a(Activity paramActivity, String paramString, Handler paramHandler)
  {
    ViewGroup localViewGroup = (ViewGroup)paramActivity.getWindow().getDecorView().getRootView();
    Object localObject1 = localViewGroup.findViewById(2131376132);
    int k = bdkf.b(79.0F);
    Object localObject3 = a(paramActivity);
    int j = (int)(((Point)localObject3).y / ((Point)localObject3).x * k);
    if (j > 2.5D * k) {
      j = (int)(2.5D * k);
    }
    for (;;)
    {
      ImageView localImageView;
      if ((localObject1 == null) && ((localViewGroup instanceof FrameLayout)))
      {
        localObject3 = View.inflate(paramActivity, 2131562561, null);
        localImageView = (ImageView)((View)localObject3).findViewById(2131376135);
        localObject1 = (RelativeLayout.LayoutParams)localImageView.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject1).height = j;
        ((RelativeLayout.LayoutParams)localObject1).width = k;
        localImageView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      }
      for (;;)
      {
        try
        {
          paramActivity.getResources().getDrawable(2130840157);
          localObject1 = URLDrawable.URLDrawableOptions.obtain();
          ((URLDrawable.URLDrawableOptions)localObject1).mRequestWidth = k;
          ((URLDrawable.URLDrawableOptions)localObject1).mRequestHeight = j;
          ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = baul.b();
          ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = baul.a();
          ((URLDrawable.URLDrawableOptions)localObject1).mPlayGifImage = false;
          ((URLDrawable.URLDrawableOptions)localObject1).mGifRoundCorner = 0.0F;
          ((URLDrawable.URLDrawableOptions)localObject1).mNeedCheckNetType = false;
          ((URLDrawable.URLDrawableOptions)localObject1).mRetryCount = 3;
          localObject1 = URLDrawable.getFileDrawable(paramString, (URLDrawable.URLDrawableOptions)localObject1);
          localImageView.setImageDrawable((Drawable)localObject1);
          localObject1 = new FrameLayout.LayoutParams(bdkf.b(96.0F), -2);
          ((FrameLayout.LayoutParams)localObject1).gravity = 21;
          ((FrameLayout.LayoutParams)localObject1).rightMargin = bdkf.b(16.0F);
          ((View)localObject3).setLayoutParams((ViewGroup.LayoutParams)localObject1);
          localViewGroup.addView((View)localObject3);
          ((View)localObject3).setId(2131376132);
          localObject1 = localObject3;
          if (localObject1 != null)
          {
            a((View)localObject1);
            ((View)localObject1).setTag(paramString);
            ((View)localObject1).setOnClickListener(new aybx());
            a(paramActivity, paramHandler);
            return;
          }
        }
        catch (IllegalStateException localIllegalStateException)
        {
          localObject1 = new BitmapFactory.Options();
          ((BitmapFactory.Options)localObject1).inJustDecodeBounds = true;
          BitmapFactory.decodeFile(paramString, (BitmapFactory.Options)localObject1);
          int i = 1;
          if (j > 0) {
            i = ((BitmapFactory.Options)localObject1).outHeight / j;
          }
          j = 1;
          if (k > 0) {
            j = ((BitmapFactory.Options)localObject1).outWidth / k;
          }
          ((BitmapFactory.Options)localObject1).inJustDecodeBounds = false;
          k = j;
          if (i > j) {
            k = i;
          }
          ((BitmapFactory.Options)localObject1).inSampleSize = k;
          ((BitmapFactory.Options)localObject1).inTargetDensity = 320;
          Object localObject2;
          if (BaseApplicationImpl.getContext().getResources().getDisplayMetrics().densityDpi > ((BitmapFactory.Options)localObject1).inDensity)
          {
            ((BitmapFactory.Options)localObject1).inDensity = 320;
            try
            {
              localObject1 = new BitmapDrawable(BitmapFactory.decodeFile(paramString, (BitmapFactory.Options)localObject1));
            }
            catch (Throwable localThrowable)
            {
              QLog.e("ScreenShotHelper", 1, "decode screenshot failed ", localIllegalStateException);
              localObject2 = null;
            }
          }
          else
          {
            localObject2.inDensity = BaseApplicationImpl.getContext().getResources().getDisplayMetrics().densityDpi;
            continue;
            QLog.e("ScreenShotHelper", 1, "screenshot float view failed ");
            return;
          }
        }
      }
    }
  }
  
  /* Error */
  public static void a(Context paramContext, android.net.Uri paramUri, View paramView1, View paramView2, boolean paramBoolean)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aconst_null
    //   4: astore 8
    //   6: aload_0
    //   7: ifnonnull +4 -> 11
    //   10: return
    //   11: new 513	android/util/SparseArray
    //   14: dup
    //   15: iconst_2
    //   16: invokespecial 515	android/util/SparseArray:<init>	(I)V
    //   19: astore 9
    //   21: aload_1
    //   22: aload_0
    //   23: iconst_3
    //   24: aload 9
    //   26: invokestatic 520	xwb:a	(Landroid/net/Uri;Landroid/content/Context;ILandroid/util/SparseArray;)I
    //   29: istore 6
    //   31: iload 6
    //   33: invokestatic 523	xwb:b	(I)Z
    //   36: ifeq +262 -> 298
    //   39: invokestatic 219	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   42: ifeq +12 -> 54
    //   45: ldc 105
    //   47: iconst_2
    //   48: ldc_w 525
    //   51: invokestatic 164	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   54: aload 9
    //   56: iconst_2
    //   57: invokevirtual 526	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   60: astore_0
    //   61: aload_0
    //   62: instanceof 528
    //   65: ifeq +228 -> 293
    //   68: aload_0
    //   69: checkcast 528	java/lang/String
    //   72: astore_1
    //   73: new 530	org/json/JSONObject
    //   76: dup
    //   77: invokespecial 531	org/json/JSONObject:<init>	()V
    //   80: astore_0
    //   81: aload_0
    //   82: ldc_w 533
    //   85: aload_1
    //   86: invokevirtual 537	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   89: pop
    //   90: aload_0
    //   91: ifnonnull +167 -> 258
    //   94: ldc_w 539
    //   97: astore_0
    //   98: aload_3
    //   99: iconst_0
    //   100: invokevirtual 270	android/view/View:setVisibility	(I)V
    //   103: aload_3
    //   104: aload_0
    //   105: invokevirtual 443	android/view/View:setTag	(Ljava/lang/Object;)V
    //   108: iconst_1
    //   109: istore 5
    //   111: iload 6
    //   113: invokestatic 541	xwb:a	(I)Z
    //   116: ifeq -106 -> 10
    //   119: invokestatic 219	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   122: ifeq +12 -> 134
    //   125: ldc 105
    //   127: iconst_2
    //   128: ldc_w 543
    //   131: invokestatic 164	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   134: aload 9
    //   136: iconst_1
    //   137: invokevirtual 526	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   140: astore_1
    //   141: aload 8
    //   143: astore_0
    //   144: aload_1
    //   145: instanceof 545
    //   148: ifeq +56 -> 204
    //   151: aload_1
    //   152: checkcast 545	android/util/Pair
    //   155: astore_0
    //   156: aload_0
    //   157: getfield 549	android/util/Pair:second	Ljava/lang/Object;
    //   160: invokestatic 552	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   163: invokevirtual 555	java/lang/String:trim	()Ljava/lang/String;
    //   166: astore_1
    //   167: aload_0
    //   168: getfield 558	android/util/Pair:first	Ljava/lang/Object;
    //   171: invokestatic 552	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   174: invokevirtual 555	java/lang/String:trim	()Ljava/lang/String;
    //   177: astore_3
    //   178: new 530	org/json/JSONObject
    //   181: dup
    //   182: invokespecial 531	org/json/JSONObject:<init>	()V
    //   185: astore_0
    //   186: aload_0
    //   187: ldc_w 560
    //   190: aload_1
    //   191: invokevirtual 537	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   194: pop
    //   195: aload_0
    //   196: ldc_w 562
    //   199: aload_3
    //   200: invokevirtual 537	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   203: pop
    //   204: aload_0
    //   205: ifnonnull +72 -> 277
    //   208: ldc_w 539
    //   211: astore_0
    //   212: iload 5
    //   214: ifeq +8 -> 222
    //   217: iload 4
    //   219: ifeq -209 -> 10
    //   222: invokestatic 219	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   225: ifeq +12 -> 237
    //   228: ldc 105
    //   230: iconst_2
    //   231: ldc_w 564
    //   234: invokestatic 164	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   237: aload_2
    //   238: iconst_0
    //   239: invokevirtual 270	android/view/View:setVisibility	(I)V
    //   242: aload_2
    //   243: aload_0
    //   244: invokevirtual 443	android/view/View:setTag	(Ljava/lang/Object;)V
    //   247: return
    //   248: astore_1
    //   249: aconst_null
    //   250: astore_0
    //   251: aload_1
    //   252: invokevirtual 565	org/json/JSONException:printStackTrace	()V
    //   255: goto -165 -> 90
    //   258: aload_0
    //   259: invokevirtual 566	org/json/JSONObject:toString	()Ljava/lang/String;
    //   262: astore_0
    //   263: goto -165 -> 98
    //   266: astore_1
    //   267: aload 7
    //   269: astore_0
    //   270: aload_1
    //   271: invokevirtual 565	org/json/JSONException:printStackTrace	()V
    //   274: goto -70 -> 204
    //   277: aload_0
    //   278: invokevirtual 566	org/json/JSONObject:toString	()Ljava/lang/String;
    //   281: astore_0
    //   282: goto -70 -> 212
    //   285: astore_1
    //   286: goto -16 -> 270
    //   289: astore_1
    //   290: goto -39 -> 251
    //   293: aconst_null
    //   294: astore_0
    //   295: goto -205 -> 90
    //   298: iconst_0
    //   299: istore 5
    //   301: goto -190 -> 111
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	304	0	paramContext	Context
    //   0	304	1	paramUri	android.net.Uri
    //   0	304	2	paramView1	View
    //   0	304	3	paramView2	View
    //   0	304	4	paramBoolean	boolean
    //   109	191	5	i	int
    //   29	83	6	j	int
    //   1	267	7	localObject1	Object
    //   4	138	8	localObject2	Object
    //   19	116	9	localSparseArray	android.util.SparseArray
    // Exception table:
    //   from	to	target	type
    //   73	81	248	org/json/JSONException
    //   178	186	266	org/json/JSONException
    //   186	204	285	org/json/JSONException
    //   81	90	289	org/json/JSONException
  }
  
  public static void a(Context paramContext, String paramString)
  {
    if ((paramContext instanceof Activity))
    {
      localObject = ((ViewGroup)((Activity)paramContext).getWindow().getDecorView().getRootView()).findViewById(2131376132);
      if (localObject != null) {
        ((ViewGroup)((View)localObject).getParent()).removeView((View)localObject);
      }
    }
    Object localObject = new Intent();
    ((Intent)localObject).putExtra("public_fragment_window_feature", 1);
    ((Intent)localObject).putExtra("screen_path", paramString);
    int j = 0;
    int i = j;
    if ((paramContext instanceof BaseActivity))
    {
      paramString = (BaseActivity)paramContext;
      QQAppInterface localQQAppInterface = paramString.app;
      i = j;
      if (localQQAppInterface != null)
      {
        i = j;
        if (localQQAppInterface.a() != null)
        {
          i = j;
          if (localQQAppInterface.a().a())
          {
            i = j;
            if (localQQAppInterface.a().a() != null)
            {
              i = j;
              if (localQQAppInterface.a().a().size() > 0)
              {
                ((Intent)localObject).putExtra("is_aio_page_with_msg", true);
                adky.a(paramString, (Intent)localObject, PublicTransFragmentActivity.class, ScreenShotFragment.class, 9011);
                i = 1;
              }
            }
          }
        }
      }
    }
    if (((paramContext instanceof QQBrowserActivity)) && (a((QQBrowserActivity)paramContext)))
    {
      ((Intent)localObject).putExtra("is_screen_shot_from_web", true);
      adky.a((QQBrowserActivity)paramContext, (Intent)localObject, PublicTransFragmentActivity.class, ScreenShotFragment.class, 11);
    }
    while (i != 0) {
      return;
    }
    adky.a(paramContext, (Intent)localObject, PublicTransFragmentActivity.class, ScreenShotFragment.class);
  }
  
  public static void a(Context paramContext, String paramString, int paramInt, Intent paramIntent)
  {
    Intent localIntent = paramIntent;
    if (paramIntent == null) {
      localIntent = new Intent();
    }
    localIntent.setClass(paramContext, ScannerActivity.class);
    localIntent.putExtra("PhotoConst.SINGLE_PHOTO_PATH", paramString);
    localIntent.putExtra("detectType", paramInt);
    localIntent.putExtra("QRDecode", true);
    localIntent.putExtra("QRDecodeResult", paramString);
    paramContext.startActivity(localIntent);
  }
  
  public static void a(Context paramContext, String paramString, Handler paramHandler)
  {
    try
    {
      if (!(paramContext instanceof Activity)) {
        return;
      }
      if ((Build.VERSION.SDK_INT >= 24) && (((Activity)paramContext).isInMultiWindowMode()))
      {
        if (!QLog.isColorLevel()) {
          return;
        }
        QLog.d("ScreenShotHelper", 2, "start float view is error and errMsg : isInMultiWindowMode");
        return;
      }
      a((Activity)paramContext, paramString, paramHandler);
      paramString = zdg.a;
      if (paramString == null) {
        return;
      }
      if ((paramContext instanceof AppActivity))
      {
        AppActivity.setActivityDispatchCallback(paramString);
        return;
      }
    }
    catch (Exception paramContext)
    {
      QLog.e("ScreenShotHelper", 2, paramContext, new Object[0]);
      return;
    }
    PluginProxyActivity.setActivityDispatchCallback(paramString);
  }
  
  public static void a(View paramView)
  {
    paramView = ObjectAnimator.ofFloat(paramView, "alpha", new float[] { 0.0F, 1.0F });
    paramView.setDuration(300L);
    paramView.start();
  }
  
  public static void a(aybm paramaybm)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScreenShotHelper", 2, "onConfUpdate : " + paramaybm);
    }
    if (paramaybm != null) {
      jdField_a_of_type_Boolean = paramaybm.a();
    }
  }
  
  public static void a(String paramString, int paramInt)
  {
    azmj.b(null, "dc00898", "", "", paramString, paramString, paramInt, 0, "", "", "", "");
  }
  
  public static void a(String paramString1, String paramString2, String paramString3)
  {
    azmj.b(null, "dc00898", "", "", paramString1, paramString1, 0, 0, paramString2, paramString3, "", "");
  }
  
  public static boolean a()
  {
    if (b) {
      return jdField_a_of_type_Boolean;
    }
    b = true;
    a();
    jdField_a_of_type_Boolean = jdField_a_of_type_Aybm.a();
    if (QLog.isColorLevel()) {
      QLog.d("ScreenShotHelper", 2, "ScreenShotConfigData isSwitchOpened = " + jdField_a_of_type_Boolean);
    }
    return jdField_a_of_type_Boolean;
  }
  
  private static boolean a(QQBrowserActivity paramQQBrowserActivity)
  {
    if (paramQQBrowserActivity == null)
    {
      QLog.e("ScreenShotHelper", 1, "isCurrentPageIsWebFragment activity is null");
      return false;
    }
    return paramQQBrowserActivity.getSupportFragmentManager().findFragmentById(2131364784) instanceof WebViewFragment;
  }
  
  private boolean a(RecentBaseData paramRecentBaseData)
  {
    return jdField_a_of_type_JavaUtilList.contains(Integer.valueOf(paramRecentBaseData.a()));
  }
  
  public static void b(Activity paramActivity)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScreenShotHelper", 2, "hideFloatView() called with: activity = [" + paramActivity + "]");
    }
    paramActivity = ((ViewGroup)paramActivity.getWindow().getDecorView().getRootView()).findViewById(2131376132);
    if (paramActivity != null) {
      paramActivity.setVisibility(8);
    }
  }
  
  public List<RecentBaseData> a(Activity paramActivity, QQAppInterface paramQQAppInterface)
  {
    ArrayList localArrayList = new ArrayList();
    try
    {
      if (paramQQAppInterface.a().a().a(false).size() > 0) {
        localArrayList.addAll(ajeu.a().jdField_a_of_type_JavaUtilList);
      }
      return a(localArrayList, paramActivity, paramQQAppInterface);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("ScreenShotHelper", 1, "getRecentUser error.", localException);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aybw
 * JD-Core Version:    0.7.0.1
 */