import android.graphics.drawable.Drawable;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.gallery.model.pic.AIOFilePicData;
import java.io.File;
import org.json.JSONObject;

public class aqmp
  extends aqml
{
  public Drawable a(AIOFilePicData paramAIOFilePicData)
  {
    File localFile1 = a(paramAIOFilePicData, 18);
    File localFile2 = a(paramAIOFilePicData, 20);
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mLoadingDrawable = aywm.a;
    localURLDrawableOptions.mFailedDrawable = aywm.a;
    if ((localFile1 != null) && (BaseApplicationImpl.sImageCache.get(a(paramAIOFilePicData, 18)) != null)) {
      if (aywm.a(localFile1.getAbsolutePath()) == 0) {}
    }
    do
    {
      do
      {
        return null;
        return URLDrawable.getDrawable(a(paramAIOFilePicData, 18), localURLDrawableOptions);
        if ((localFile2 == null) || (BaseApplicationImpl.sImageCache.get(a(paramAIOFilePicData, 20)) == null)) {
          break;
        }
      } while (aywm.a(localFile2.getAbsolutePath()) != 0);
      return URLDrawable.getDrawable(a(paramAIOFilePicData, 20), localURLDrawableOptions);
    } while (a(paramAIOFilePicData, 16) == null);
    return URLDrawable.getDrawable(a(paramAIOFilePicData, 16), localURLDrawableOptions);
  }
  
  public File a(AIOFilePicData paramAIOFilePicData, int paramInt)
  {
    if (paramAIOFilePicData == null) {
      return null;
    }
    switch (paramInt)
    {
    case 17: 
    case 19: 
    default: 
      paramAIOFilePicData = null;
    }
    while ((paramAIOFilePicData != null) && (!paramAIOFilePicData.equals("I:N")))
    {
      paramAIOFilePicData = new File(paramAIOFilePicData);
      if (!paramAIOFilePicData.exists()) {
        break;
      }
      return paramAIOFilePicData;
      paramAIOFilePicData = paramAIOFilePicData.b;
      continue;
      paramAIOFilePicData = paramAIOFilePicData.c;
      continue;
      paramAIOFilePicData = paramAIOFilePicData.jdField_d_of_type_JavaLangString;
    }
  }
  
  public String a(AIOFilePicData paramAIOFilePicData, int paramInt)
  {
    if (paramAIOFilePicData == null) {
      return null;
    }
    switch (paramInt)
    {
    case 17: 
    case 19: 
    default: 
      paramAIOFilePicData = null;
    }
    while ((paramAIOFilePicData != null) && (!paramAIOFilePicData.equals("I:N")))
    {
      if (paramAIOFilePicData.startsWith("/")) {
        break label108;
      }
      return "file:/" + paramAIOFilePicData;
      paramAIOFilePicData = paramAIOFilePicData.b;
      continue;
      paramAIOFilePicData = paramAIOFilePicData.c;
      continue;
      paramAIOFilePicData = paramAIOFilePicData.jdField_d_of_type_JavaLangString;
    }
    label108:
    if (paramAIOFilePicData.startsWith("//")) {
      return "file:" + paramAIOFilePicData;
    }
    return "file:" + paramAIOFilePicData;
  }
  
  public void a(AIOFilePicData paramAIOFilePicData, int paramInt, String paramString)
  {
    if ((paramAIOFilePicData == null) || (paramString == null)) {
      return;
    }
    if ("I:E".equals(paramString))
    {
      switch (paramInt)
      {
      case 17: 
      case 19: 
      default: 
        return;
      case 16: 
        paramAIOFilePicData.f = true;
        return;
      case 18: 
        paramAIOFilePicData.jdField_d_of_type_Boolean = true;
        return;
      }
      paramAIOFilePicData.e = true;
      return;
    }
    switch (paramInt)
    {
    case 17: 
    case 19: 
    default: 
      return;
    case 16: 
      paramAIOFilePicData.b = paramString;
      return;
    case 18: 
      paramAIOFilePicData.c = paramString;
      return;
    }
    paramAIOFilePicData.jdField_d_of_type_JavaLangString = paramString;
  }
  
  public boolean a(AIOFilePicData paramAIOFilePicData, int paramInt)
  {
    boolean bool2 = true;
    boolean bool1;
    if (paramAIOFilePicData == null) {
      bool1 = false;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
        switch (paramInt)
        {
        case 20: 
        case 17: 
        case 19: 
        default: 
          return false;
        case 16: 
          bool1 = bool2;
        }
      } while (!paramAIOFilePicData.b.equals("I:N"));
      return false;
      bool1 = bool2;
    } while (!paramAIOFilePicData.c.equals("I:N"));
    return false;
  }
  
  public void b(AIOFilePicData paramAIOFilePicData, int paramInt, String paramString)
  {
    String str2 = "";
    j = 0;
    i = j;
    localObject = str2;
    if (!TextUtils.isEmpty(paramString)) {
      str1 = str2;
    }
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString);
      paramString = str2;
      str1 = str2;
      if (localJSONObject.has("errorType"))
      {
        str1 = str2;
        paramString = localJSONObject.getString("errorType");
      }
      i = j;
      localObject = paramString;
      str1 = paramString;
      if (localJSONObject.has("errorCode"))
      {
        str1 = paramString;
        i = localJSONObject.getInt("errorCode");
        localObject = paramString;
      }
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        i = j;
        localObject = str1;
      }
    }
    if (paramInt == 18) {
      if ((localObject != null) && (((String)localObject).equals("thumb_download"))) {
        paramAIOFilePicData.i = i;
      }
    }
    while ((paramInt != 16) || (localObject == null) || (!((String)localObject).equals("thumb_download"))) {
      return;
    }
    paramAIOFilePicData.i = i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aqmp
 * JD-Core Version:    0.7.0.1
 */