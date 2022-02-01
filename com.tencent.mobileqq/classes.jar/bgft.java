import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.vas.VasApngFactory.sam.java_lang_Runnable.0;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.URL;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/vas/VasApngFactory;", "", "()V", "TAG", "", "doOnMainThread", "", "block", "Lkotlin/Function0;", "getApngDrawableFromUrl", "Lcom/tencent/image/URLDrawable;", "filePath", "urlStr", "options", "Lcom/tencent/mobileqq/vas/VasApngFactory$Options;", "getApngURLDrawable", "Options", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class bgft
{
  public static final bgft a = new bgft();
  
  @JvmStatic
  @JvmOverloads
  @Nullable
  public static final URLDrawable a(@NotNull String paramString, @NotNull bgfu parambgfu)
  {
    return a(paramString, parambgfu, null, 4, null);
  }
  
  @JvmStatic
  @JvmOverloads
  @Nullable
  public static final URLDrawable a(@NotNull String paramString1, @NotNull bgfu parambgfu, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "urlStr");
    Intrinsics.checkParameterIsNotNull(parambgfu, "options");
    Intrinsics.checkParameterIsNotNull(paramString2, "filePath");
    bgfv localbgfv = new bgfv(parambgfu);
    paramString1 = a.a(paramString2, paramString1, parambgfu);
    if (paramString1 != null)
    {
      int i = paramString1.getStatus();
      if (i != 1)
      {
        if (QLog.isColorLevel()) {
          QLog.e("VasApngFactory", 2, "UrlDrawable is not  SUCCESSED :" + i);
        }
        paramString1.setURLDrawableListener((URLDrawable.URLDrawableListener)localbgfv);
        if (i == 2) {
          paramString1.restartDownload();
        }
      }
      for (;;)
      {
        return paramString1;
        if (i != 0)
        {
          paramString1.startDownload();
          continue;
          localbgfv.onLoadSuccessed(paramString1);
        }
      }
    }
    return null;
  }
  
  private final URLDrawable a(String paramString1, String paramString2, bgfu parambgfu)
  {
    if (((CharSequence)paramString1).length() == 0) {}
    for (int i = 1; i != 0; i = 0) {
      return null;
    }
    String str = new File(paramString2).getName();
    try
    {
      Object localObject = parambgfu.a();
      ((Bundle)localObject).putInt("key_loop", parambgfu.a());
      ((Bundle)localObject).putIntArray("key_tagId_arr", parambgfu.a());
      ((Bundle)localObject).putBoolean("key_double_bitmap", true);
      ((Bundle)localObject).putString("key_name", str);
      paramString2 = new URL("vasapngdownloader", paramString1, paramString2);
      localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mExtraInfo = parambgfu.a();
      ((URLDrawable.URLDrawableOptions)localObject).mUseApngImage = true;
      ((URLDrawable.URLDrawableOptions)localObject).mUseMemoryCache = parambgfu.a();
      ((URLDrawable.URLDrawableOptions)localObject).mMemoryCacheKeySuffix = String.valueOf(parambgfu.a());
      ((URLDrawable.URLDrawableOptions)localObject).mUseUnFinishCache = parambgfu.c();
      ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = parambgfu.b();
      ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = parambgfu.c();
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = parambgfu.a();
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = parambgfu.a();
      ((URLDrawable.URLDrawableOptions)localObject).mUseAutoScaleParams = parambgfu.b();
      paramString2 = URLDrawable.getDrawable(paramString2, (URLDrawable.URLDrawableOptions)localObject);
      if (QLog.isColorLevel()) {
        QLog.d("VasApngFactory", 2, "getApngDrawable ApngImage ok path:" + paramString1 + ", name=" + str);
      }
      return paramString2;
    }
    catch (Throwable paramString2)
    {
      QLog.e("VasApngFactory", 1, "getApngDrawable ApngImage err:" + paramString2 + ", path:" + paramString1 + ", name=" + str);
    }
    return null;
  }
  
  private final void a(Function0<Unit> paramFunction0)
  {
    if (Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper()))
    {
      paramFunction0.invoke();
      return;
    }
    Handler localHandler = ThreadManagerV2.getUIHandlerV2();
    if (paramFunction0 != null) {
      paramFunction0 = new VasApngFactory.sam.java_lang_Runnable.0(paramFunction0);
    }
    for (;;)
    {
      localHandler.post((Runnable)paramFunction0);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgft
 * JD-Core Version:    0.7.0.1
 */