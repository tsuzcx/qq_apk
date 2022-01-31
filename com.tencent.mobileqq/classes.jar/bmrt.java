import android.text.TextUtils;
import android.widget.ImageView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;

public class bmrt
{
  private static bmrt a = new bmrt();
  
  public static bmrt a()
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
    localURLDrawableOptions.mFailedDrawable = bayu.a;
    localURLDrawableOptions.mLoadingDrawable = bayu.a;
    localURLDrawableOptions.mUseAutoScaleParams = false;
    return URLDrawable.getDrawable(paramString, localURLDrawableOptions);
  }
  
  public void a(ImageView paramImageView, String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if ((paramImageView == null) || (TextUtils.isEmpty(paramString)))
    {
      wxe.e("ImageLoader", "ImageView or uri is null.");
      return;
    }
    wxe.b("ImageLoader", "uri:" + paramString + ",width:" + paramInt1 + ",height:" + paramInt2);
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
 * Qualified Name:     bmrt
 * JD-Core Version:    0.7.0.1
 */