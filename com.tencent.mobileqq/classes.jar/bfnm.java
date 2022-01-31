import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.support.annotation.ColorInt;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.WindowManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.DeviceProfileManager;
import cooperation.qqreader.QRBridgeActivity;
import cooperation.qqreader.net.BusinessTask;
import cooperation.qqreader.ui.ReaderBaseWebActivity;
import java.util.Arrays;
import java.util.Iterator;
import org.json.JSONObject;

public final class bfnm
{
  public static boolean a;
  private static boolean b;
  
  public static int a()
  {
    return BaseApplicationImpl.getApplication().getResources().getDisplayMetrics().widthPixels;
  }
  
  public static long a(Context paramContext)
  {
    long l1 = bfnl.a(paramContext);
    if (l1 == -1L)
    {
      bfnl.a(paramContext);
      return 0L;
    }
    long l2 = System.currentTimeMillis();
    bfnl.a(paramContext);
    return l2 - l1;
  }
  
  @Nullable
  public static Bitmap a(Drawable paramDrawable)
  {
    if (paramDrawable == null) {
      return null;
    }
    int i = paramDrawable.getIntrinsicWidth();
    int j = paramDrawable.getIntrinsicHeight();
    if (paramDrawable.getOpacity() != -1) {}
    for (Object localObject = Bitmap.Config.ARGB_8888;; localObject = Bitmap.Config.RGB_565)
    {
      localObject = Bitmap.createBitmap(i, j, (Bitmap.Config)localObject);
      Canvas localCanvas = new Canvas((Bitmap)localObject);
      paramDrawable.setBounds(0, 0, i, j);
      paramDrawable.draw(localCanvas);
      return localObject;
    }
  }
  
  @Nullable
  public static Bitmap a(String paramString)
  {
    return a(a(paramString));
  }
  
  public static Drawable a(@ColorInt int paramInt1, int paramInt2)
  {
    GradientDrawable localGradientDrawable = new GradientDrawable();
    localGradientDrawable.setShape(0);
    localGradientDrawable.setCornerRadius(paramInt2);
    localGradientDrawable.setColor(paramInt1);
    return localGradientDrawable;
  }
  
  @Nullable
  public static Drawable a(String paramString)
  {
    Object localObject = null;
    if (!TextUtils.isEmpty(paramString))
    {
      localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = new ColorDrawable(0);
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = new ColorDrawable(0);
      localObject = URLDrawable.getDrawable(paramString, (URLDrawable.URLDrawableOptions)localObject);
      if ((((URLDrawable)localObject).getStatus() == 2) || (((URLDrawable)localObject).getStatus() == 3)) {
        ((URLDrawable)localObject).restartDownload();
      }
    }
    else
    {
      return localObject;
    }
    ((URLDrawable)localObject).startDownload();
    return localObject;
  }
  
  @Nullable
  public static Object a(String paramString, JSONObject paramJSONObject)
  {
    Object localObject1;
    if (paramJSONObject == null)
    {
      localObject1 = null;
      return localObject1;
    }
    Iterator localIterator = paramJSONObject.keys();
    if ((localIterator == null) || (!localIterator.hasNext())) {
      return null;
    }
    for (;;)
    {
      try
      {
        localObject1 = paramJSONObject.get((String)localObject1);
        if ((localObject1 instanceof JSONObject))
        {
          Object localObject2 = a(paramString, (JSONObject)localObject1);
          localObject1 = localObject2;
          if (localObject2 != null) {
            break;
          }
        }
      }
      catch (Exception localException2)
      {
        continue;
      }
      if (localIterator.hasNext())
      {
        localObject1 = (String)localIterator.next();
        if (!paramString.equals(localObject1)) {}
      }
      else
      {
        try
        {
          localObject1 = paramJSONObject.get((String)localObject1);
          return localObject1;
        }
        catch (Exception localException1) {}
        return null;
      }
    }
  }
  
  public static String a()
  {
    if ("-1".equals(ReaderBaseWebActivity.a)) {
      return QRBridgeActivity.a;
    }
    return ReaderBaseWebActivity.a;
  }
  
  public static String a(@NonNull Activity paramActivity)
  {
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    paramActivity.getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
    return localDisplayMetrics.heightPixels + "x" + localDisplayMetrics.widthPixels;
  }
  
  public static String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    Uri localUri;
    Object localObject;
    do
    {
      do
      {
        do
        {
          return paramString;
          localUri = Uri.parse(paramString);
          if (!localUri.getPath().contains("bookDetails.html")) {
            break;
          }
          localObject = localUri.getQueryParameter("id");
        } while (TextUtils.isEmpty((CharSequence)localObject));
        return localUri.getScheme() + "://" + localUri.getHost() + "/club/client/read/6/rel/book_outDetail.html?ChannelID=100060&_wv=1&_wwv=4&bid=" + (String)localObject;
      } while (!localUri.getPath().contains("bookDetail_index.html"));
      String str = localUri.getQueryParameter("nbid");
      localObject = str;
      if (TextUtils.isEmpty(str)) {
        localObject = localUri.getQueryParameter("bid");
      }
    } while (TextUtils.isEmpty((CharSequence)localObject));
    return localUri.getScheme() + "://" + localUri.getHost() + "/club/client/read/6/rel/bookDetail_out_detail.html?ChannelID=100060&_wv=1&_wwv=4&nbid=" + (String)localObject;
  }
  
  public static void a(Activity paramActivity)
  {
    boolean bool = false;
    if (b) {}
    do
    {
      do
      {
        do
        {
          return;
        } while (paramActivity == null);
        paramActivity = paramActivity.getIntent();
      } while (paramActivity == null);
      paramActivity = paramActivity.getStringExtra("readerDpcConfig");
      Log.i("Utility", "initReaderDPC dpc = " + paramActivity);
    } while (TextUtils.isEmpty(paramActivity));
    Integer[] arrayOfInteger = new Integer[6];
    Arrays.fill(arrayOfInteger, Integer.valueOf(0));
    if (DeviceProfileManager.a(paramActivity, arrayOfInteger, new ajhd()) >= arrayOfInteger.length)
    {
      if (arrayOfInteger[5].intValue() == 1) {
        bool = true;
      }
      a = bool;
    }
    b = true;
  }
  
  public static void a(Context paramContext)
  {
    BusinessTask localBusinessTask = new BusinessTask("GetEnterShelfOnOffTask");
    localBusinessTask.a(new bfnn(paramContext), true);
    localBusinessTask.a();
  }
  
  public static void a(View paramView, float paramFloat)
  {
    if ((paramView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams))
    {
      ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)paramView.getLayoutParams();
      localMarginLayoutParams.topMargin = ((int)paramFloat);
      paramView.setLayoutParams(localMarginLayoutParams);
    }
  }
  
  public static int b()
  {
    return BaseApplicationImpl.getApplication().getResources().getDisplayMetrics().heightPixels;
  }
  
  public static String b()
  {
    DisplayMetrics localDisplayMetrics = BaseApplicationImpl.getApplication().getResources().getDisplayMetrics();
    return localDisplayMetrics.heightPixels + "x" + localDisplayMetrics.widthPixels;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfnm
 * JD-Core Version:    0.7.0.1
 */