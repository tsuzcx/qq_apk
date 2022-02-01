import android.text.TextUtils;
import android.widget.ImageView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.transfile.URLDrawableHelper;

public class bowy
{
  private static bowy a = new bowy();
  
  public static bowy a()
  {
    return a;
  }
  
  public URLDrawable a(String paramString, int paramInt1, int paramInt2)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    if ((paramInt1 > 0) && (paramInt2 > 0))
    {
      localURLDrawableOptions.mRequestWidth = paramInt1;
      localURLDrawableOptions.mRequestHeight = paramInt2;
    }
    localURLDrawableOptions.mFailedDrawable = URLDrawableHelper.TRANSPARENT;
    localURLDrawableOptions.mLoadingDrawable = URLDrawableHelper.TRANSPARENT;
    localURLDrawableOptions.mUseAutoScaleParams = false;
    return URLDrawable.getDrawable(paramString, localURLDrawableOptions);
  }
  
  public void a(ImageView paramImageView, String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if ((paramImageView == null) || (TextUtils.isEmpty(paramString)))
    {
      ykq.e("ImageLoader", "ImageView or uri is null.");
      return;
    }
    ykq.b("ImageLoader", "uri:" + paramString + ",width:" + paramInt1 + ",height:" + paramInt2);
    paramString = a(paramString, paramInt1, paramInt2);
    if (paramBoolean) {}
    for (;;)
    {
      paramImageView.setImageDrawable(paramString);
      return;
      paramString = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bowy
 * JD-Core Version:    0.7.0.1
 */