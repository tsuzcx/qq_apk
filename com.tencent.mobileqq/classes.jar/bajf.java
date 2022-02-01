import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.richmediabrowser.model.AIOFileVideoData;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.richmediabrowser.model.BrowserBaseModel;
import java.io.File;

public class bajf
  extends BrowserBaseModel
{
  private void b(AIOFileVideoData paramAIOFileVideoData, Context paramContext, bakr parambakr)
  {
    paramAIOFileVideoData = new bajg(this, paramContext, paramAIOFileVideoData, parambakr);
    aszg.a(paramContext, paramContext.getString(2131692374), paramContext.getString(2131692376), paramAIOFileVideoData);
  }
  
  private boolean c(AIOFileVideoData paramAIOFileVideoData)
  {
    if (a(paramAIOFileVideoData)) {}
    do
    {
      do
      {
        return false;
      } while ((paramAIOFileVideoData == null) || (paramAIOFileVideoData.g) || (!aszt.a()));
      if ((!TextUtils.isEmpty(paramAIOFileVideoData.jdField_a_of_type_JavaLangString)) && (paramAIOFileVideoData.jdField_c_of_type_Long > 0L) && (paramAIOFileVideoData.jdField_c_of_type_Long > paramAIOFileVideoData.e)) {
        return true;
      }
    } while (paramAIOFileVideoData.jdField_c_of_type_Long <= 1048576L);
    return true;
  }
  
  public ajqi a(AIOFileVideoData paramAIOFileVideoData, boolean paramBoolean)
  {
    boolean bool = false;
    ajqi localajqi = new ajqi();
    localajqi.jdField_a_of_type_ArrayOfJavaLangString = new String[] { paramAIOFileVideoData.jdField_d_of_type_JavaLangString };
    localajqi.jdField_a_of_type_JavaUtilArrayList = paramAIOFileVideoData.jdField_a_of_type_JavaUtilArrayList;
    if (!a(paramAIOFileVideoData)) {
      bool = true;
    }
    localajqi.jdField_a_of_type_Boolean = bool;
    if (localajqi.jdField_a_of_type_Boolean) {}
    for (String str = "";; str = paramAIOFileVideoData.jdField_c_of_type_JavaLangString)
    {
      localajqi.jdField_a_of_type_JavaLangString = str;
      localajqi.jdField_c_of_type_Long = paramAIOFileVideoData.progress;
      localajqi.jdField_b_of_type_Boolean = true;
      localajqi.jdField_b_of_type_Long = paramAIOFileVideoData.jdField_c_of_type_Long;
      localajqi.jdField_a_of_type_Long = paramAIOFileVideoData.jdField_a_of_type_Long;
      localajqi.jdField_b_of_type_Int = paramAIOFileVideoData.jdField_a_of_type_Int;
      localajqi.e = paramBoolean;
      localajqi.jdField_a_of_type_AndroidOsBundle = paramAIOFileVideoData.jdField_a_of_type_AndroidOsBundle;
      return localajqi;
    }
  }
  
  public Drawable a(AIOFileVideoData paramAIOFileVideoData)
  {
    URLDrawable localURLDrawable = null;
    File localFile = a(paramAIOFileVideoData);
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mLoadingDrawable = URLDrawableHelper.TRANSPARENT;
    localURLDrawableOptions.mFailedDrawable = URLDrawableHelper.TRANSPARENT;
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
    if ((paramAIOFileVideoData == null) || (!FileUtil.fileExistsAndNotEmpty(paramAIOFileVideoData.b))) {
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
  
  public void a(AIOFileVideoData paramAIOFileVideoData, Context paramContext, bakr parambakr)
  {
    if (c(paramAIOFileVideoData))
    {
      if (ataw.a(paramContext, false, new bajh(this, parambakr))) {
        b(paramAIOFileVideoData, paramContext, parambakr);
      }
      return;
    }
    parambakr.i();
  }
  
  public boolean a(AIOFileVideoData paramAIOFileVideoData)
  {
    if (paramAIOFileVideoData != null)
    {
      if ((TextUtils.isEmpty(paramAIOFileVideoData.jdField_c_of_type_JavaLangString)) && (paramAIOFileVideoData.jdField_a_of_type_AndroidOsBundle != null)) {
        paramAIOFileVideoData.jdField_c_of_type_JavaLangString = paramAIOFileVideoData.jdField_a_of_type_AndroidOsBundle.getString("savepath");
      }
      if (FileUtils.fileExistsAndNotEmpty(paramAIOFileVideoData.jdField_c_of_type_JavaLangString))
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
  
  public boolean a(AIOFileVideoData paramAIOFileVideoData, baiv parambaiv)
  {
    if ((paramAIOFileVideoData == null) || (a(paramAIOFileVideoData)) || (parambaiv == null)) {}
    while ((!TextUtils.isEmpty(paramAIOFileVideoData.jdField_d_of_type_JavaLangString)) && (paramAIOFileVideoData.jdField_a_of_type_JavaUtilArrayList != null)) {
      return false;
    }
    parambaiv.downloadMedia(paramAIOFileVideoData.jdField_a_of_type_Long, paramAIOFileVideoData.jdField_a_of_type_Int, 16842753);
    return true;
  }
  
  public boolean b(AIOFileVideoData paramAIOFileVideoData)
  {
    return !TextUtils.isEmpty(paramAIOFileVideoData.f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bajf
 * JD-Core Version:    0.7.0.1
 */