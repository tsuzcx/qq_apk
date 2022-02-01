package com.tencent.biz.subscribe;

import android.content.res.Resources;
import android.support.v4.util.MQLruCache;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.GlobalImageCache;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;

public class SubImageLoader
{
  @NotNull
  public static URLDrawable.URLDrawableOptions a(URLImageView paramURLImageView)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mLoadingDrawable = BaseApplicationImpl.getApplication().getResources().getDrawable(2130846843);
    if (paramURLImageView.getLayoutParams() != null)
    {
      localURLDrawableOptions.mRequestWidth = paramURLImageView.getLayoutParams().width;
      localURLDrawableOptions.mRequestHeight = paramURLImageView.getLayoutParams().height;
    }
    return localURLDrawableOptions;
  }
  
  public static void a()
  {
    if (BaseApplicationImpl.sProcessId == 1)
    {
      GlobalImageCache.a.evict(0);
      return;
    }
    GlobalImageCache.a.evictAll();
  }
  
  public static void a(String paramString, URLImageView paramURLImageView)
  {
    a(paramString, paramURLImageView, null, false);
  }
  
  public static void a(String paramString, URLImageView paramURLImageView, URLDrawable.URLDrawableOptions paramURLDrawableOptions, boolean paramBoolean)
  {
    WeakReference localWeakReference = new WeakReference(paramURLImageView);
    URLDrawable.URLDrawableOptions localURLDrawableOptions = paramURLDrawableOptions;
    if (paramURLDrawableOptions == null) {}
    try
    {
      localURLDrawableOptions = a(paramURLImageView);
      if (paramBoolean) {
        paramString = URLDrawable.getFileDrawable(paramString, localURLDrawableOptions);
      } else {
        paramString = URLDrawable.getDrawable(paramString, localURLDrawableOptions);
      }
      if ((paramString == null) || (localWeakReference.get() == null)) {
        break label81;
      }
      ((ImageView)localWeakReference.get()).setImageDrawable(paramString);
      return;
    }
    catch (Error paramString)
    {
      break label72;
    }
    catch (Exception paramString)
    {
      label72:
      label77:
      label81:
      break label77;
    }
    paramString.printStackTrace();
    return;
    paramString.printStackTrace();
  }
  
  public static URLDrawable.URLDrawableOptions b(URLImageView paramURLImageView)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mLoadingDrawable = BaseApplicationImpl.getApplication().getResources().getDrawable(2130841698);
    if ((paramURLImageView != null) && (paramURLImageView.getLayoutParams() != null))
    {
      localURLDrawableOptions.mRequestWidth = paramURLImageView.getLayoutParams().width;
      localURLDrawableOptions.mRequestHeight = paramURLImageView.getLayoutParams().height;
    }
    return localURLDrawableOptions;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.SubImageLoader
 * JD-Core Version:    0.7.0.1
 */