import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.richmediabrowser.model.AIOFileVideoData;
import com.tencent.richmediabrowser.model.BrowserBaseModel;
import java.io.File;

public class bbpk
  extends BrowserBaseModel
{
  private void b(AIOFileVideoData paramAIOFileVideoData, Context paramContext, bbqw parambbqw)
  {
    paramAIOFileVideoData = new bbpl(this, paramContext, paramAIOFileVideoData, parambbqw);
    aumw.a(paramContext, paramContext.getString(2131692326), paramContext.getString(2131692328), paramAIOFileVideoData);
  }
  
  private boolean c(AIOFileVideoData paramAIOFileVideoData)
  {
    if (a(paramAIOFileVideoData)) {}
    do
    {
      do
      {
        return false;
      } while ((paramAIOFileVideoData == null) || (paramAIOFileVideoData.g) || (!aunj.a()));
      if ((!TextUtils.isEmpty(paramAIOFileVideoData.jdField_a_of_type_JavaLangString)) && (paramAIOFileVideoData.jdField_c_of_type_Long > 0L) && (paramAIOFileVideoData.jdField_c_of_type_Long > paramAIOFileVideoData.e)) {
        return true;
      }
    } while (paramAIOFileVideoData.jdField_c_of_type_Long <= 1048576L);
    return true;
  }
  
  public akss a(AIOFileVideoData paramAIOFileVideoData, boolean paramBoolean)
  {
    boolean bool = false;
    akss localakss = new akss();
    localakss.jdField_a_of_type_ArrayOfJavaLangString = new String[] { paramAIOFileVideoData.jdField_d_of_type_JavaLangString };
    localakss.jdField_a_of_type_JavaUtilArrayList = paramAIOFileVideoData.jdField_a_of_type_JavaUtilArrayList;
    if (!a(paramAIOFileVideoData)) {
      bool = true;
    }
    localakss.jdField_a_of_type_Boolean = bool;
    if (localakss.jdField_a_of_type_Boolean) {}
    for (String str = "";; str = paramAIOFileVideoData.jdField_c_of_type_JavaLangString)
    {
      localakss.jdField_a_of_type_JavaLangString = str;
      localakss.jdField_c_of_type_Long = paramAIOFileVideoData.progress;
      localakss.jdField_b_of_type_Boolean = true;
      localakss.jdField_b_of_type_Long = paramAIOFileVideoData.jdField_c_of_type_Long;
      localakss.jdField_a_of_type_Long = paramAIOFileVideoData.jdField_a_of_type_Long;
      localakss.jdField_b_of_type_Int = paramAIOFileVideoData.jdField_a_of_type_Int;
      localakss.e = paramBoolean;
      localakss.jdField_a_of_type_AndroidOsBundle = paramAIOFileVideoData.jdField_a_of_type_AndroidOsBundle;
      return localakss;
    }
  }
  
  public Drawable a(AIOFileVideoData paramAIOFileVideoData)
  {
    URLDrawable localURLDrawable = null;
    File localFile = a(paramAIOFileVideoData);
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mLoadingDrawable = beyq.a;
    localURLDrawableOptions.mFailedDrawable = beyq.a;
    if ((localFile != null) && (BaseApplicationImpl.sImageCache.get(a(paramAIOFileVideoData)) != null)) {
      localURLDrawable = URLDrawable.getDrawable(a(paramAIOFileVideoData), localURLDrawableOptions);
    }
    while (localFile == null) {
      return localURLDrawable;
    }
    paramAIOFileVideoData = URLDrawable.getDrawable(a(paramAIOFileVideoData), localURLDrawableOptions);
    paramAIOFileVideoData.downloadImediatly();
    return paramAIOFileVideoData;
  }
  
  public File a(AIOFileVideoData paramAIOFileVideoData)
  {
    if ((paramAIOFileVideoData == null) || (!auog.b(paramAIOFileVideoData.b))) {
      return null;
    }
    return new File(paramAIOFileVideoData.b);
  }
  
  public String a(AIOFileVideoData paramAIOFileVideoData)
  {
    if ((paramAIOFileVideoData == null) || (TextUtils.isEmpty(paramAIOFileVideoData.b))) {
      return "";
    }
    if (!paramAIOFileVideoData.b.startsWith("/")) {
      return "file:/" + paramAIOFileVideoData.b;
    }
    if (paramAIOFileVideoData.b.startsWith("//")) {
      return "file:" + paramAIOFileVideoData.b;
    }
    return "file:" + paramAIOFileVideoData.b;
  }
  
  public void a(AIOFileVideoData paramAIOFileVideoData, Context paramContext, bbqw parambbqw)
  {
    if (c(paramAIOFileVideoData))
    {
      if (auoo.a(paramContext, false, new bbpm(this, parambbqw))) {
        b(paramAIOFileVideoData, paramContext, parambbqw);
      }
      return;
    }
    parambbqw.i();
  }
  
  public boolean a(AIOFileVideoData paramAIOFileVideoData)
  {
    if (paramAIOFileVideoData != null)
    {
      if ((TextUtils.isEmpty(paramAIOFileVideoData.jdField_c_of_type_JavaLangString)) && (paramAIOFileVideoData.jdField_a_of_type_AndroidOsBundle != null)) {
        paramAIOFileVideoData.jdField_c_of_type_JavaLangString = paramAIOFileVideoData.jdField_a_of_type_AndroidOsBundle.getString("savepath");
      }
      if (bhmi.b(paramAIOFileVideoData.jdField_c_of_type_JavaLangString))
      {
        paramAIOFileVideoData.jdField_d_of_type_Boolean = true;
        return true;
      }
    }
    if ((paramAIOFileVideoData != null) && (paramAIOFileVideoData.jdField_d_of_type_JavaLangString == null)) {
      paramAIOFileVideoData.jdField_d_of_type_Boolean = false;
    }
    return false;
  }
  
  public boolean a(AIOFileVideoData paramAIOFileVideoData, bbpa parambbpa)
  {
    if ((paramAIOFileVideoData == null) || (a(paramAIOFileVideoData)) || (parambbpa == null)) {}
    while ((!TextUtils.isEmpty(paramAIOFileVideoData.jdField_d_of_type_JavaLangString)) && (paramAIOFileVideoData.jdField_a_of_type_JavaUtilArrayList != null)) {
      return false;
    }
    parambbpa.downloadMedia(paramAIOFileVideoData.jdField_a_of_type_Long, paramAIOFileVideoData.jdField_a_of_type_Int, 16842753);
    return true;
  }
  
  public boolean b(AIOFileVideoData paramAIOFileVideoData)
  {
    return !TextUtils.isEmpty(paramAIOFileVideoData.f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbpk
 * JD-Core Version:    0.7.0.1
 */