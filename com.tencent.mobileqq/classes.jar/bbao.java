import android.graphics.drawable.Drawable;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import com.tencent.image.DownloadParams.DecodeHandler;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;

public class bbao
{
  public static URLDrawable a(ImageView paramImageView, String paramString)
  {
    return a(paramImageView, paramString, bbbb.a);
  }
  
  public static URLDrawable a(ImageView paramImageView, String paramString, Drawable paramDrawable)
  {
    return a(paramImageView, paramString, bbbb.a, paramDrawable, paramDrawable);
  }
  
  public static URLDrawable a(ImageView paramImageView, String paramString, DownloadParams.DecodeHandler paramDecodeHandler)
  {
    return a(paramImageView, paramString, paramDecodeHandler, null);
  }
  
  public static URLDrawable a(ImageView paramImageView, String paramString, DownloadParams.DecodeHandler paramDecodeHandler, Drawable paramDrawable)
  {
    return a(paramImageView, paramString, paramDecodeHandler, paramDrawable, paramDrawable);
  }
  
  public static URLDrawable a(ImageView paramImageView, String paramString, DownloadParams.DecodeHandler paramDecodeHandler, Drawable paramDrawable1, Drawable paramDrawable2)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    if (paramImageView.getLayoutParams() != null)
    {
      localURLDrawableOptions.mRequestWidth = paramImageView.getLayoutParams().width;
      localURLDrawableOptions.mRequestHeight = paramImageView.getLayoutParams().height;
    }
    if ((localURLDrawableOptions.mRequestWidth <= 0) || (localURLDrawableOptions.mRequestHeight <= 0))
    {
      localURLDrawableOptions.mRequestWidth = Math.max(paramImageView.getWidth(), 0);
      localURLDrawableOptions.mRequestHeight = Math.max(paramImageView.getHeight(), 0);
    }
    localURLDrawableOptions.mFailedDrawable = paramDrawable2;
    localURLDrawableOptions.mLoadingDrawable = paramDrawable1;
    if (paramDecodeHandler != null) {
      localURLDrawableOptions.mMemoryCacheKeySuffix = paramDecodeHandler.toString();
    }
    paramString = URLDrawable.getDrawable(paramString, localURLDrawableOptions);
    paramString.setDecodeHandler(paramDecodeHandler);
    paramImageView.setImageDrawable(paramString);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     bbao
 * JD-Core Version:    0.7.0.1
 */