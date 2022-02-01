import android.graphics.drawable.Drawable;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.richmediabrowser.model.AIOFilePictureData;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.richmediabrowser.model.BrowserBaseModel;
import java.io.File;
import org.json.JSONObject;

public class bbpt
  extends BrowserBaseModel
{
  public Drawable a(AIOFilePictureData paramAIOFilePictureData)
  {
    File localFile1 = a(paramAIOFilePictureData, 18);
    File localFile2 = a(paramAIOFilePictureData, 20);
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mLoadingDrawable = URLDrawableHelper.TRANSPARENT;
    localURLDrawableOptions.mFailedDrawable = URLDrawableHelper.TRANSPARENT;
    if ((localFile1 != null) && (BaseApplicationImpl.sImageCache.get(a(paramAIOFilePictureData, 18)) != null)) {
      if (URLDrawableHelper.getExifRotation(localFile1.getAbsolutePath()) == 0) {}
    }
    do
    {
      do
      {
        return null;
        return URLDrawable.getDrawable(a(paramAIOFilePictureData, 18), localURLDrawableOptions);
        if ((localFile2 == null) || (BaseApplicationImpl.sImageCache.get(a(paramAIOFilePictureData, 20)) == null)) {
          break;
        }
      } while (URLDrawableHelper.getExifRotation(localFile2.getAbsolutePath()) != 0);
      return URLDrawable.getDrawable(a(paramAIOFilePictureData, 20), localURLDrawableOptions);
    } while (a(paramAIOFilePictureData, 16) == null);
    return URLDrawable.getDrawable(a(paramAIOFilePictureData, 16), localURLDrawableOptions);
  }
  
  public File a(AIOFilePictureData paramAIOFilePictureData, int paramInt)
  {
    if (paramAIOFilePictureData == null) {
      return null;
    }
    switch (paramInt)
    {
    case 17: 
    case 19: 
    default: 
      paramAIOFilePictureData = null;
    }
    while ((paramAIOFilePictureData != null) && (!paramAIOFilePictureData.equals("I:N")))
    {
      paramAIOFilePictureData = new File(paramAIOFilePictureData);
      if (!paramAIOFilePictureData.exists()) {
        break;
      }
      return paramAIOFilePictureData;
      paramAIOFilePictureData = paramAIOFilePictureData.b;
      continue;
      paramAIOFilePictureData = paramAIOFilePictureData.c;
      continue;
      paramAIOFilePictureData = paramAIOFilePictureData.jdField_d_of_type_JavaLangString;
    }
  }
  
  public String a(AIOFilePictureData paramAIOFilePictureData, int paramInt)
  {
    if (paramAIOFilePictureData == null) {
      return null;
    }
    switch (paramInt)
    {
    case 17: 
    case 19: 
    default: 
      paramAIOFilePictureData = null;
    }
    while ((paramAIOFilePictureData != null) && (!paramAIOFilePictureData.equals("I:N")))
    {
      if (paramAIOFilePictureData.startsWith("/")) {
        break label108;
      }
      return "file:/" + paramAIOFilePictureData;
      paramAIOFilePictureData = paramAIOFilePictureData.b;
      continue;
      paramAIOFilePictureData = paramAIOFilePictureData.c;
      continue;
      paramAIOFilePictureData = paramAIOFilePictureData.jdField_d_of_type_JavaLangString;
    }
    label108:
    if (paramAIOFilePictureData.startsWith("//")) {
      return "file:" + paramAIOFilePictureData;
    }
    return "file:" + paramAIOFilePictureData;
  }
  
  public void a(AIOFilePictureData paramAIOFilePictureData, int paramInt, String paramString)
  {
    if ((paramAIOFilePictureData == null) || (paramString == null)) {
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
        paramAIOFilePictureData.f = true;
        return;
      case 18: 
        paramAIOFilePictureData.jdField_d_of_type_Boolean = true;
        return;
      }
      paramAIOFilePictureData.e = true;
      return;
    }
    switch (paramInt)
    {
    case 17: 
    case 19: 
    default: 
      return;
    case 16: 
      paramAIOFilePictureData.b = paramString;
      return;
    case 18: 
      paramAIOFilePictureData.c = paramString;
      return;
    }
    paramAIOFilePictureData.jdField_d_of_type_JavaLangString = paramString;
  }
  
  public boolean a(AIOFilePictureData paramAIOFilePictureData, int paramInt)
  {
    boolean bool2 = true;
    boolean bool1;
    if (paramAIOFilePictureData == null) {
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
      } while (!paramAIOFilePictureData.b.equals("I:N"));
      return false;
      bool1 = bool2;
    } while (!paramAIOFilePictureData.c.equals("I:N"));
    return false;
  }
  
  public void b(AIOFilePictureData paramAIOFilePictureData, int paramInt, String paramString)
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
        paramAIOFilePictureData.g = i;
      }
    }
    while ((paramInt != 16) || (localObject == null) || (!((String)localObject).equals("thumb_download"))) {
      return;
    }
    paramAIOFilePictureData.g = i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbpt
 * JD-Core Version:    0.7.0.1
 */