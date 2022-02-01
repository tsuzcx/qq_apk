import android.text.TextUtils;
import android.widget.ImageView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;

public class bqku
{
  private static bqku a = new bqku();
  
  public static bqku a()
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
    localURLDrawableOptions.mFailedDrawable = beyq.a;
    localURLDrawableOptions.mLoadingDrawable = beyq.a;
    localURLDrawableOptions.mUseAutoScaleParams = false;
    return URLDrawable.getDrawable(paramString, localURLDrawableOptions);
  }
  
  public void a(ImageView paramImageView, String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if ((paramImageView == null) || (TextUtils.isEmpty(paramString)))
    {
      yuk.e("ImageLoader", "ImageView or uri is null.");
      return;
    }
    yuk.b("ImageLoader", "uri:" + paramString + ",width:" + paramInt1 + ",height:" + paramInt2);
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
 * Qualified Name:     bqku
 * JD-Core Version:    0.7.0.1
 */