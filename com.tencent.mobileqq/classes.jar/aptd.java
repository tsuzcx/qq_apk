import android.graphics.drawable.Drawable;
import android.support.v4.util.MQLruCache;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.gallery.model.video.AIOShortVideoData;
import java.io.File;

public class aptd
  extends apsu
{
  public Drawable a(AIOShortVideoData paramAIOShortVideoData)
  {
    URLDrawable localURLDrawable = null;
    File localFile = a(paramAIOShortVideoData, 0);
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mLoadingDrawable = axwd.a;
    localURLDrawableOptions.mFailedDrawable = axwd.a;
    if ((localFile != null) && (BaseApplicationImpl.sImageCache.get(a(paramAIOShortVideoData, 0)) != null)) {
      localURLDrawable = URLDrawable.getDrawable(a(paramAIOShortVideoData, 0), localURLDrawableOptions);
    }
    while (localFile == null) {
      return localURLDrawable;
    }
    paramAIOShortVideoData = URLDrawable.getDrawable(a(paramAIOShortVideoData, 0), localURLDrawableOptions);
    paramAIOShortVideoData.downloadImediatly();
    return paramAIOShortVideoData;
  }
  
  public File a(AIOShortVideoData paramAIOShortVideoData, int paramInt)
  {
    if (paramAIOShortVideoData == null) {
      return null;
    }
    switch (paramInt)
    {
    default: 
      paramAIOShortVideoData = null;
    }
    while ((paramAIOShortVideoData != null) && (!paramAIOShortVideoData.equals("I:N")))
    {
      paramAIOShortVideoData = new File(paramAIOShortVideoData);
      if (!paramAIOShortVideoData.exists()) {
        break;
      }
      return paramAIOShortVideoData;
      paramAIOShortVideoData = paramAIOShortVideoData.a;
      continue;
      paramAIOShortVideoData = paramAIOShortVideoData.b;
    }
  }
  
  public String a(AIOShortVideoData paramAIOShortVideoData, int paramInt)
  {
    if (paramAIOShortVideoData == null) {
      return null;
    }
    switch (paramInt)
    {
    default: 
      paramAIOShortVideoData = null;
    }
    while ((paramAIOShortVideoData != null) && (!paramAIOShortVideoData.equals("I:N")))
    {
      if (paramAIOShortVideoData.startsWith("/")) {
        break label88;
      }
      return "file:/" + paramAIOShortVideoData;
      paramAIOShortVideoData = paramAIOShortVideoData.a;
      continue;
      paramAIOShortVideoData = paramAIOShortVideoData.b;
    }
    label88:
    if (paramAIOShortVideoData.startsWith("//")) {
      return "file:" + paramAIOShortVideoData;
    }
    return "file:" + paramAIOShortVideoData;
  }
  
  public void a(AIOShortVideoData paramAIOShortVideoData, int paramInt, String paramString)
  {
    if ("I:E".equals(paramString))
    {
      switch (paramInt)
      {
      default: 
        return;
      case 0: 
        paramAIOShortVideoData.d = true;
        return;
      }
      paramAIOShortVideoData.e = true;
      return;
    }
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      paramAIOShortVideoData.a = paramString;
      return;
    }
    paramAIOShortVideoData.b = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aptd
 * JD-Core Version:    0.7.0.1
 */