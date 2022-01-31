import android.graphics.drawable.Drawable;
import android.support.v4.util.MQLruCache;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.gallery.model.pic.AIOPicData;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

public class aqmq
  extends aqml
{
  public int a(AIOPicData paramAIOPicData, String paramString)
  {
    if ((paramString == null) || (paramAIOPicData == null)) {}
    do
    {
      return 0;
      if ((paramAIOPicData.a != null) && (paramString.contains(paramAIOPicData.a))) {
        return 1;
      }
      if ((paramAIOPicData.b != null) && (paramString.contains(paramAIOPicData.b))) {
        return 2;
      }
    } while ((paramAIOPicData.c == null) || (!paramString.contains(paramAIOPicData.c)));
    return 4;
  }
  
  public Drawable a(AIOPicData paramAIOPicData)
  {
    URLDrawable localURLDrawable = null;
    File localFile1 = a(paramAIOPicData, 2);
    File localFile2 = a(paramAIOPicData, 4);
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mLoadingDrawable = aywm.a;
    localURLDrawableOptions.mFailedDrawable = aywm.a;
    if ((localFile1 != null) && (BaseApplicationImpl.sImageCache.get(a(paramAIOPicData, 2)) != null)) {
      localURLDrawable = URLDrawable.getDrawable(a(paramAIOPicData, 2), localURLDrawableOptions);
    }
    do
    {
      return localURLDrawable;
      if ((localFile2 != null) && (BaseApplicationImpl.sImageCache.get(a(paramAIOPicData, 4)) != null)) {
        return URLDrawable.getDrawable(a(paramAIOPicData, 4), localURLDrawableOptions);
      }
    } while (a(paramAIOPicData, 1) == null);
    paramAIOPicData = URLDrawable.getDrawable(a(paramAIOPicData, 1), localURLDrawableOptions);
    paramAIOPicData.downloadImediatly();
    return paramAIOPicData;
  }
  
  public File a(AIOPicData paramAIOPicData, int paramInt)
  {
    if (paramAIOPicData == null) {
      return null;
    }
    switch (paramInt)
    {
    case 3: 
    case 5: 
    case 6: 
    case 7: 
    default: 
      paramAIOPicData = null;
    }
    while ((paramAIOPicData != null) && (!paramAIOPicData.equals("I:N")))
    {
      paramAIOPicData = new File(paramAIOPicData);
      if (!paramAIOPicData.exists()) {
        break;
      }
      return paramAIOPicData;
      paramAIOPicData = paramAIOPicData.a;
      continue;
      paramAIOPicData = paramAIOPicData.b;
      continue;
      paramAIOPicData = paramAIOPicData.c;
      continue;
      paramAIOPicData = paramAIOPicData.jdField_d_of_type_JavaLangString;
    }
  }
  
  public String a(AIOPicData paramAIOPicData, int paramInt)
  {
    Object localObject2 = null;
    Object localObject1;
    if (paramAIOPicData == null)
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
      if (paramAIOPicData.jdField_d_of_type_Int != 3) {
        break label152;
      }
      paramAIOPicData = new File(str);
      try
      {
        paramAIOPicData = paramAIOPicData.toURI().toURL().toString();
        return paramAIOPicData;
      }
      catch (MalformedURLException paramAIOPicData)
      {
        paramAIOPicData.printStackTrace();
        return null;
      }
      str = paramAIOPicData.a;
      continue;
      str = paramAIOPicData.b;
      continue;
      str = paramAIOPicData.c;
      continue;
      str = paramAIOPicData.jdField_d_of_type_JavaLangString;
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
  
  public void a(AIOPicData paramAIOPicData, int paramInt, String paramString)
  {
    if ("I:E".equals(paramString)) {
      switch (paramInt)
      {
      }
    }
    do
    {
      return;
      paramAIOPicData.e = true;
      return;
      paramAIOPicData.f = true;
      return;
      paramAIOPicData.jdField_d_of_type_Boolean = true;
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
        paramAIOPicData.a = paramString;
        return;
      case 2: 
        paramAIOPicData.b = paramString;
      }
    } while ((paramAIOPicData.j) || (!new File(paramAIOPicData.a + "_hd").exists()));
    paramAIOPicData.a += "_hd";
    return;
    paramAIOPicData.c = paramString;
    return;
    paramAIOPicData.jdField_d_of_type_JavaLangString = paramString;
  }
  
  public boolean a(AIOPicData paramAIOPicData, int paramInt)
  {
    boolean bool2 = true;
    boolean bool1;
    if (paramAIOPicData == null) {
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
          } while (!paramAIOPicData.a.equals("I:N"));
          return false;
          bool1 = bool2;
        } while (!paramAIOPicData.b.equals("I:N"));
        return false;
        bool1 = bool2;
      } while (paramAIOPicData.jdField_d_of_type_Int == 3);
      bool1 = bool2;
    } while (!paramAIOPicData.c.equals("I:N"));
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aqmq
 * JD-Core Version:    0.7.0.1
 */