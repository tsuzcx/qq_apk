import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.ApngDrawable;
import com.tencent.image.ApngImage;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.URL;
import javax.annotation.Nullable;
import mqq.app.AppRuntime;

public class bdpt
{
  public static int[] a = { 2, 3, 4, 5, 6, 8 };
  public static final int[] b = { 1, 0, 2, 3, 9, 27 };
  
  public static URLDrawable a(String paramString1, String paramString2, Drawable paramDrawable, int[] paramArrayOfInt, String paramString3, Bundle paramBundle)
  {
    return a(null, paramString1, paramString2, paramDrawable, paramArrayOfInt, paramString3, paramBundle);
  }
  
  public static URLDrawable a(String paramString, int[] paramArrayOfInt, Drawable paramDrawable)
  {
    return a(paramString, paramArrayOfInt, paramDrawable, null, new bdpu(paramArrayOfInt));
  }
  
  public static URLDrawable a(String paramString, int[] paramArrayOfInt, Drawable paramDrawable, Bundle paramBundle, URLDrawable.URLDrawableListener paramURLDrawableListener)
  {
    String str1 = new File(paramString).getName();
    String str2 = a(paramString);
    paramString = b(BaseApplicationImpl.sApplication.getRuntime(), str2, paramString, paramDrawable, paramArrayOfInt, str1, paramBundle);
    if (paramString != null)
    {
      int i = paramString.getStatus();
      if (i != 1)
      {
        if (QLog.isColorLevel()) {
          QLog.e("ddddd", 2, "urlDrawable is not  SUCCESSED :" + i);
        }
        paramString.setURLDrawableListener(paramURLDrawableListener);
        if (i == 2) {
          paramString.restartDownload();
        }
      }
      for (;;)
      {
        return paramString;
        paramString.startDownload();
        continue;
        paramDrawable = paramString.getCurrDrawable();
        if ((paramDrawable != null) && ((paramDrawable instanceof ApngDrawable)) && (((ApngDrawable)paramDrawable).getImage() != null)) {
          ApngImage.playByTag(paramArrayOfInt[0]);
        }
      }
    }
    return null;
  }
  
  public static URLDrawable a(@Nullable AppRuntime paramAppRuntime, String paramString1, String paramString2, Drawable paramDrawable, int[] paramArrayOfInt, String paramString3, Bundle paramBundle)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return null;
    }
    paramAppRuntime = paramBundle;
    if (paramBundle == null) {}
    try
    {
      paramAppRuntime = new Bundle();
      boolean bool = paramAppRuntime.getBoolean("key_play_apng", true);
      int i = paramAppRuntime.getInt("key_loop");
      paramBundle = new URL("vasapngdownloader", paramString1, paramString2);
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mUseApngImage = bool;
      localURLDrawableOptions.mUseMemoryCache = paramAppRuntime.getBoolean("key_use_cache", true);
      localURLDrawableOptions.mMemoryCacheKeySuffix = (bool + "," + i);
      i = paramAppRuntime.getInt("key_width", 0);
      int j = paramAppRuntime.getInt("key_height", 0);
      if ((i > 0) && (j > 0))
      {
        localURLDrawableOptions.mRequestWidth = i;
        localURLDrawableOptions.mRequestHeight = j;
      }
      localURLDrawableOptions.mLoadingDrawable = paramDrawable;
      localURLDrawableOptions.mFailedDrawable = paramDrawable;
      paramAppRuntime.putIntArray("key_tagId_arr", paramArrayOfInt);
      paramAppRuntime.putString("key_name", paramString3);
      paramAppRuntime.putBoolean("key_double_bitmap", true);
      localURLDrawableOptions.mExtraInfo = paramAppRuntime;
      if ("-Dynamic-".equals(paramString2)) {
        localURLDrawableOptions.mUseAutoScaleParams = false;
      }
      if (!paramAppRuntime.getBoolean("key_use_auto_scale_params", true)) {
        localURLDrawableOptions.mUseAutoScaleParams = false;
      }
      paramAppRuntime = URLDrawable.getDrawable(paramBundle, localURLDrawableOptions);
      if (QLog.isColorLevel()) {
        QLog.d("VasApngUtil", 2, "getApngDrawable ApngImage ok path:" + paramString1 + ", name=" + paramString3);
      }
      return paramAppRuntime;
    }
    catch (Exception paramAppRuntime)
    {
      QLog.e("VasApngUtil", 1, "getApngDrawable ApngImage err:" + paramAppRuntime.toString() + ", path:" + paramString1 + ", name=" + paramString3);
    }
    return null;
  }
  
  public static URLDrawable a(AppRuntime paramAppRuntime, String paramString1, String paramString2, Drawable paramDrawable, int[] paramArrayOfInt, String paramString3, boolean paramBoolean, Bundle paramBundle)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return null;
    }
    paramAppRuntime = paramBundle;
    if (paramBundle == null) {}
    try
    {
      paramAppRuntime = new Bundle();
      boolean bool = paramAppRuntime.getBoolean("key_play_apng", true);
      int i = paramAppRuntime.getInt("key_loop");
      paramString2 = new URL("vasapngdownloader", paramString1, paramString2);
      paramBundle = URLDrawable.URLDrawableOptions.obtain();
      paramBundle.mUseApngImage = bool;
      paramBundle.mUseMemoryCache = paramAppRuntime.getBoolean("key_use_cache", true);
      paramBundle.mMemoryCacheKeySuffix = (bool + "," + i);
      paramBundle.mUseUnFinishCache = paramBoolean;
      i = paramAppRuntime.getInt("key_width", 0);
      int j = paramAppRuntime.getInt("key_height", 0);
      if ((i > 0) && (j > 0))
      {
        paramBundle.mRequestWidth = i;
        paramBundle.mRequestHeight = j;
      }
      paramBundle.mLoadingDrawable = paramDrawable;
      paramBundle.mFailedDrawable = paramDrawable;
      paramAppRuntime.putIntArray("key_tagId_arr", paramArrayOfInt);
      paramAppRuntime.putString("key_name", paramString3);
      paramAppRuntime.putBoolean("key_double_bitmap", true);
      paramBundle.mExtraInfo = paramAppRuntime;
      paramBundle.mUseAutoScaleParams = false;
      paramAppRuntime = URLDrawable.getDrawable(paramString2, paramBundle);
      if (QLog.isColorLevel()) {
        QLog.d("VasApngUtil", 2, "getApngDrawable ApngImage ok path:" + paramString1 + ", name=" + paramString3);
      }
      return paramAppRuntime;
    }
    catch (Exception paramAppRuntime)
    {
      QLog.e("VasApngUtil", 1, "getApngDrawable ApngImage err:" + paramAppRuntime.toString() + ", path:" + paramString1 + ", name=" + paramString3);
    }
    return null;
  }
  
  public static String a(String paramString)
  {
    return bduw.a(new StringBuilder().append(aljq.aX).append(".vipicon/").toString()) + paramString.hashCode() + ".png";
  }
  
  public static URLDrawable b(AppRuntime paramAppRuntime, String paramString1, String paramString2, Drawable paramDrawable, int[] paramArrayOfInt, String paramString3, Bundle paramBundle)
  {
    return a(paramAppRuntime, paramString1, paramString2, paramDrawable, paramArrayOfInt, paramString3, true, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdpt
 * JD-Core Version:    0.7.0.1
 */