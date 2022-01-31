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
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
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

public class avgx
{
  private static avgo jdField_a_of_type_Avgo;
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
          else if ((localRecentBaseData.a() == 6000) && (TextUtils.equals(localRecentBaseData.a(), ajed.z)))
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
            paramList = agzt.a(new RecentUser(ajed.z, 6000), paramQQAppInterface, paramActivity);
            if (paramList != null)
            {
              paramList.mTitleName = paramActivity.getResources().getString(2131628323);
              localArrayList.add(paramList);
            }
          }
          Collections.sort(localArrayList, new agzu(paramQQAppInterface));
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
    avgo localavgo2 = (avgo)alzw.a().a(485);
    avgo localavgo1 = localavgo2;
    if (localavgo2 == null)
    {
      localavgo2 = new avgo();
      localavgo1 = localavgo2;
      if (QLog.isColorLevel())
      {
        QLog.d("ScreenShotHelper", 2, "ScreenShotConfigData = null, general new bean, so switch default is opened!");
        localavgo1 = localavgo2;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("ScreenShotHelper", 2, "ScreenShotConfigData switch isOpened = " + localavgo1);
    }
    jdField_a_of_type_Avgo = localavgo1;
  }
  
  public static void a(Activity paramActivity)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScreenShotHelper", 2, "removeFloatView() called with: activity = [" + paramActivity + "]");
    }
    paramActivity = ((ViewGroup)paramActivity.getWindow().getDecorView().getRootView()).findViewById(2131309879);
    if (paramActivity != null) {
      ((ViewGroup)paramActivity.getParent()).removeView(paramActivity);
    }
  }
  
  public static void a(Activity paramActivity, Handler paramHandler)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScreenShotHelper", 2, "onActivityResumeHideFloatView");
    }
    View localView = ((ViewGroup)paramActivity.getWindow().getDecorView().getRootView()).findViewById(2131309879);
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
    paramActivity = ((ViewGroup)paramActivity.getWindow().getDecorView().getRootView()).findViewById(2131309879);
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
    Object localObject1 = localViewGroup.findViewById(2131309879);
    int k = bajq.b(79.0F);
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
        localObject3 = View.inflate(paramActivity, 2131496757, null);
        localImageView = (ImageView)((View)localObject3).findViewById(2131309882);
        localObject1 = (RelativeLayout.LayoutParams)localImageView.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject1).height = j;
        ((RelativeLayout.LayoutParams)localObject1).width = k;
        localImageView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      }
      for (;;)
      {
        try
        {
          paramActivity.getResources().getDrawable(2130839762);
          localObject1 = URLDrawable.URLDrawableOptions.obtain();
          ((URLDrawable.URLDrawableOptions)localObject1).mRequestWidth = k;
          ((URLDrawable.URLDrawableOptions)localObject1).mRequestHeight = j;
          ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = axwd.b();
          ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = axwd.a();
          ((URLDrawable.URLDrawableOptions)localObject1).mPlayGifImage = false;
          ((URLDrawable.URLDrawableOptions)localObject1).mGifRoundCorner = 0.0F;
          ((URLDrawable.URLDrawableOptions)localObject1).mNeedCheckNetType = false;
          ((URLDrawable.URLDrawableOptions)localObject1).mRetryCount = 3;
          localObject1 = URLDrawable.getFileDrawable(paramString, (URLDrawable.URLDrawableOptions)localObject1);
          localImageView.setImageDrawable((Drawable)localObject1);
          localObject1 = new FrameLayout.LayoutParams(bajq.b(96.0F), -2);
          ((FrameLayout.LayoutParams)localObject1).gravity = 21;
          ((FrameLayout.LayoutParams)localObject1).rightMargin = bajq.b(16.0F);
          ((View)localObject3).setLayoutParams((ViewGroup.LayoutParams)localObject1);
          localViewGroup.addView((View)localObject3);
          ((View)localObject3).setId(2131309879);
          localObject1 = localObject3;
          if (localObject1 != null)
          {
            a((View)localObject1);
            ((View)localObject1).setTag(paramString);
            ((View)localObject1).setOnClickListener(new avgy());
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
  
  public static void a(Context paramContext, String paramString)
  {
    if ((paramContext instanceof Activity))
    {
      localObject = ((ViewGroup)((Activity)paramContext).getWindow().getDecorView().getRootView()).findViewById(2131309879);
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
                abju.a(paramString, (Intent)localObject, PublicTransFragmentActivity.class, ScreenShotFragment.class, 9011);
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
      abju.a((QQBrowserActivity)paramContext, (Intent)localObject, PublicTransFragmentActivity.class, ScreenShotFragment.class, 11);
    }
    while (i != 0) {
      return;
    }
    abju.a(paramContext, (Intent)localObject, PublicTransFragmentActivity.class, ScreenShotFragment.class);
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
      paramString = xfq.a;
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
  
  public static void a(avgo paramavgo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScreenShotHelper", 2, "onConfUpdate : " + paramavgo);
    }
    if (paramavgo != null) {
      jdField_a_of_type_Boolean = paramavgo.a();
    }
  }
  
  public static void a(String paramString, int paramInt)
  {
    awqx.b(null, "dc00898", "", "", paramString, paramString, paramInt, 0, "", "", "", "");
  }
  
  public static void a(String paramString1, String paramString2, String paramString3)
  {
    awqx.b(null, "dc00898", "", "", paramString1, paramString1, 0, 0, paramString2, paramString3, "", "");
  }
  
  public static boolean a()
  {
    if (b) {
      return jdField_a_of_type_Boolean;
    }
    b = true;
    a();
    jdField_a_of_type_Boolean = jdField_a_of_type_Avgo.a();
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
    return paramQQBrowserActivity.getSupportFragmentManager().findFragmentById(2131299146) instanceof WebViewFragment;
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
    paramActivity = ((ViewGroup)paramActivity.getWindow().getDecorView().getRootView()).findViewById(2131309879);
    if (paramActivity != null) {
      paramActivity.setVisibility(8);
    }
  }
  
  public List<RecentBaseData> a(Activity paramActivity, QQAppInterface paramQQAppInterface)
  {
    int i = 0;
    List localList = paramQQAppInterface.a().a().a(false);
    agzu localagzu = new agzu(paramQQAppInterface);
    localagzu.a(localList);
    ArrayList localArrayList = new ArrayList();
    if (localList != null) {
      i = localList.size();
    }
    agzt.a(localList, paramQQAppInterface, paramActivity, localArrayList, i);
    try
    {
      Collections.sort(localArrayList, localagzu);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     avgx
 * JD-Core Version:    0.7.0.1
 */