import android.graphics.drawable.Drawable;
import android.support.v4.util.MQLruCache;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.richmediabrowser.model.AIOPictureData;
import com.tencent.richmediabrowser.model.BrowserBaseModel;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

public class axyn
  extends BrowserBaseModel
{
  public int a(AIOPictureData paramAIOPictureData, String paramString)
  {
    if ((paramString == null) || (paramAIOPictureData == null)) {}
    do
    {
      return 0;
      if ((paramAIOPictureData.a != null) && (paramString.contains(paramAIOPictureData.a))) {
        return 1;
      }
      if ((paramAIOPictureData.b != null) && (paramString.contains(paramAIOPictureData.b))) {
        return 2;
      }
    } while ((paramAIOPictureData.c == null) || (!paramString.contains(paramAIOPictureData.c)));
    return 4;
  }
  
  public Drawable a(AIOPictureData paramAIOPictureData)
  {
    URLDrawable localURLDrawable = null;
    File localFile1 = a(paramAIOPictureData, 2);
    File localFile2 = a(paramAIOPictureData, 4);
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mLoadingDrawable = bayu.a;
    localURLDrawableOptions.mFailedDrawable = bayu.a;
    if ((localFile1 != null) && (BaseApplicationImpl.sImageCache.get(a(paramAIOPictureData, 2)) != null)) {
      localURLDrawable = URLDrawable.getDrawable(a(paramAIOPictureData, 2), localURLDrawableOptions);
    }
    do
    {
      return localURLDrawable;
      if ((localFile2 != null) && (BaseApplicationImpl.sImageCache.get(a(paramAIOPictureData, 4)) != null)) {
        return URLDrawable.getDrawable(a(paramAIOPictureData, 4), localURLDrawableOptions);
      }
    } while (a(paramAIOPictureData, 1) == null);
    paramAIOPictureData = URLDrawable.getDrawable(a(paramAIOPictureData, 1), localURLDrawableOptions);
    paramAIOPictureData.downloadImediatly();
    return paramAIOPictureData;
  }
  
  public File a(AIOPictureData paramAIOPictureData, int paramInt)
  {
    if (paramAIOPictureData == null) {
      return null;
    }
    switch (paramInt)
    {
    case 3: 
    case 5: 
    case 6: 
    case 7: 
    default: 
      paramAIOPictureData = null;
    }
    while ((paramAIOPictureData != null) && (!paramAIOPictureData.equals("I:N")))
    {
      paramAIOPictureData = new File(paramAIOPictureData);
      if (!paramAIOPictureData.exists()) {
        break;
      }
      return paramAIOPictureData;
      paramAIOPictureData = paramAIOPictureData.a;
      continue;
      paramAIOPictureData = paramAIOPictureData.b;
      continue;
      paramAIOPictureData = paramAIOPictureData.c;
      continue;
      paramAIOPictureData = paramAIOPictureData.jdField_d_of_type_JavaLangString;
    }
  }
  
  public String a(AIOPictureData paramAIOPictureData, int paramInt)
  {
    Object localObject2 = null;
    Object localObject1;
    if (paramAIOPictureData == null)
    {
      localObject1 = "";
      return localObject1;
    }
    String str;
    switch (paramInt)
    {
    case 3: 
    case 5: 
    case 6: 
    case 7: 
    default: 
      str = null;
    }
    for (;;)
    {
      localObject1 = localObject2;
      if (str == null) {
        break;
      }
      localObject1 = localObject2;
      if (str.equals("I:N")) {
        break;
      }
      if (paramAIOPictureData.jdField_d_of_type_Int != 3) {
        break label152;
      }
      paramAIOPictureData = new File(str);
      try
      {
        paramAIOPictureData = paramAIOPictureData.toURI().toURL().toString();
        return paramAIOPictureData;
      }
      catch (MalformedURLException paramAIOPictureData)
      {
        paramAIOPictureData.printStackTrace();
        return null;
      }
      str = paramAIOPictureData.a;
      continue;
      str = paramAIOPictureData.b;
      continue;
      str = paramAIOPictureData.c;
      continue;
      str = paramAIOPictureData.jdField_d_of_type_JavaLangString;
    }
    label152:
    if (!str.startsWith("/")) {
      return "file:/" + str;
    }
    if (str.startsWith("//")) {
      return "file:" + str;
    }
    return "file:" + str;
  }
  
  public void a(AIOPictureData paramAIOPictureData, int paramInt, String paramString)
  {
    if ("I:E".equals(paramString)) {
      switch (paramInt)
      {
      }
    }
    do
    {
      return;
      paramAIOPictureData.e = true;
      return;
      paramAIOPictureData.f = true;
      return;
      paramAIOPictureData.jdField_d_of_type_Boolean = true;
      return;
      switch (paramInt)
      {
      case 3: 
      case 5: 
      case 6: 
      case 7: 
      default: 
        return;
      case 1: 
        paramAIOPictureData.a = paramString;
        return;
      case 2: 
        paramAIOPictureData.b = paramString;
      }
    } while ((paramAIOPictureData.j) || (!new File(paramAIOPictureData.a + "_hd").exists()));
    paramAIOPictureData.a += "_hd";
    return;
    paramAIOPictureData.c = paramString;
    return;
    paramAIOPictureData.jdField_d_of_type_JavaLangString = paramString;
  }
  
  public boolean a(AIOPictureData paramAIOPictureData, int paramInt)
  {
    boolean bool2 = true;
    boolean bool1;
    if (paramAIOPictureData == null) {
      bool1 = false;
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return bool1;
            switch (paramInt)
            {
            case 3: 
            default: 
              return false;
            case 1: 
              bool1 = bool2;
            }
          } while (!paramAIOPictureData.a.equals("I:N"));
          return false;
          bool1 = bool2;
        } while (!paramAIOPictureData.b.equals("I:N"));
        return false;
        bool1 = bool2;
      } while (paramAIOPictureData.jdField_d_of_type_Int == 3);
      bool1 = bool2;
    } while (!paramAIOPictureData.c.equals("I:N"));
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axyn
 * JD-Core Version:    0.7.0.1
 */