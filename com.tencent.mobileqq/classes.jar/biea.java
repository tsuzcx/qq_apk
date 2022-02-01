import android.content.res.Resources;
import android.text.TextUtils;
import android.widget.ImageView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.tmassistantbase.util.GlobalUtil;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;

public class biea
{
  public static String a(String paramString)
  {
    bhzm.b("CommonUtils_", "genExistedAPKFileNameByUrl url = " + paramString);
    Object localObject2 = null;
    if (paramString.contains(".apk"))
    {
      localObject2 = paramString.trim().substring(paramString.lastIndexOf("/") + 1).trim();
      localObject1 = localObject2;
      if (((String)localObject2).contains("?")) {
        localObject1 = ((String)localObject2).substring(0, ((String)localObject2).lastIndexOf("?"));
      }
      localObject2 = localObject1;
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        paramString = c(b((String)localObject1));
        bhzm.b("CommonUtils_", "genExistedAPKFileNameByUrl  fileName = " + paramString);
        return paramString;
      }
    }
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject2 = GlobalUtil.calcMD5AsString(paramString);
      localObject1 = localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        localObject1 = Integer.toString(Math.abs(paramString.hashCode()));
      }
      localObject1 = (String)localObject1 + ".apk";
    }
    bhzm.b("CommonUtils_", "genExistedAPKFileNameByUrl fileName == null, return fileName = " + (String)localObject1);
    return localObject1;
  }
  
  public static void a(ImageView paramImageView, String paramString)
  {
    try
    {
      paramString = new URL(paramString);
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mRequestHeight = 234;
      localURLDrawableOptions.mRequestWidth = 234;
      localURLDrawableOptions.mFailedDrawable = BaseApplication.getContext().getResources().getDrawable(2130841869);
      localURLDrawableOptions.mLoadingDrawable = BaseApplication.getContext().getResources().getDrawable(2130841869);
      paramString = URLDrawable.getDrawable(paramString, localURLDrawableOptions);
      paramString.setAutoDownload(true);
      paramString.setURLDrawableListener(new bieb(paramImageView));
      paramString.startDownload();
      paramImageView.setImageDrawable(paramString);
      return;
    }
    catch (MalformedURLException paramImageView)
    {
      paramImageView.printStackTrace();
    }
  }
  
  public static boolean a()
  {
    return bicl.a().b();
  }
  
  private static String b(String paramString)
  {
    if (paramString != null) {
      return URLDecoder.decode(paramString);
    }
    return "";
  }
  
  private static String c(String paramString)
  {
    return paramString.replace("?", "_").replace("*", "_").replace(" ", "_").replace("$", "_").replace("&", "_").replace("@", "_").replace("#", "_").replace("<", "_").replace(">", "_").replace("|", "_").replace(":", "_").replace("/", "_").replace("\\", "_").replace("\"", "_");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     biea
 * JD-Core Version:    0.7.0.1
 */