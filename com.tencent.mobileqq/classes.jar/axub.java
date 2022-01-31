import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.richmediabrowser.model.AIOFileVideoData;
import com.tencent.richmediabrowser.model.BrowserBaseModel;
import java.io.File;

public class axub
  extends BrowserBaseModel
{
  private void a(AIOFileVideoData paramAIOFileVideoData, Context paramContext, ailt paramailt)
  {
    paramAIOFileVideoData = new axuc(this, paramContext, paramAIOFileVideoData, paramailt);
    armv.a(paramContext, paramContext.getString(2131692752), paramContext.getString(2131692754), paramAIOFileVideoData);
  }
  
  private boolean c(AIOFileVideoData paramAIOFileVideoData)
  {
    if ((paramAIOFileVideoData == null) || (paramAIOFileVideoData.g)) {}
    do
    {
      do
      {
        return false;
      } while (!arni.a());
      if ((!TextUtils.isEmpty(paramAIOFileVideoData.jdField_a_of_type_JavaLangString)) && (paramAIOFileVideoData.jdField_c_of_type_Long > 0L) && (paramAIOFileVideoData.jdField_c_of_type_Long > paramAIOFileVideoData.jdField_e_of_type_Long)) {
        return true;
      }
    } while (paramAIOFileVideoData.jdField_c_of_type_Long <= 1048576L);
    return true;
  }
  
  public ailz a(AIOFileVideoData paramAIOFileVideoData, boolean paramBoolean)
  {
    boolean bool = false;
    ailz localailz = new ailz();
    localailz.jdField_a_of_type_ArrayOfJavaLangString = new String[] { paramAIOFileVideoData.d };
    localailz.jdField_b_of_type_JavaLangString = paramAIOFileVideoData.jdField_e_of_type_JavaLangString;
    if (!a(paramAIOFileVideoData)) {
      bool = true;
    }
    localailz.jdField_a_of_type_Boolean = bool;
    if (localailz.jdField_a_of_type_Boolean) {}
    for (String str = paramAIOFileVideoData.jdField_f_of_type_JavaLangString;; str = paramAIOFileVideoData.jdField_c_of_type_JavaLangString)
    {
      localailz.jdField_a_of_type_JavaLangString = str;
      localailz.jdField_c_of_type_Long = paramAIOFileVideoData.progress;
      localailz.jdField_b_of_type_Boolean = true;
      localailz.jdField_b_of_type_Long = paramAIOFileVideoData.jdField_c_of_type_Long;
      localailz.jdField_a_of_type_Long = paramAIOFileVideoData.jdField_a_of_type_Long;
      localailz.jdField_b_of_type_Int = paramAIOFileVideoData.jdField_a_of_type_Int;
      localailz.e = paramBoolean;
      return localailz;
    }
  }
  
  public Drawable a(AIOFileVideoData paramAIOFileVideoData)
  {
    URLDrawable localURLDrawable = null;
    File localFile = a(paramAIOFileVideoData);
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mLoadingDrawable = baul.a;
    localURLDrawableOptions.mFailedDrawable = baul.a;
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
    if ((paramAIOFileVideoData == null) || (!arof.b(paramAIOFileVideoData.jdField_b_of_type_JavaLangString))) {
      return null;
    }
    return new File(paramAIOFileVideoData.jdField_b_of_type_JavaLangString);
  }
  
  public String a(AIOFileVideoData paramAIOFileVideoData)
  {
    if ((paramAIOFileVideoData == null) || (TextUtils.isEmpty(paramAIOFileVideoData.jdField_b_of_type_JavaLangString))) {
      return "";
    }
    if (!paramAIOFileVideoData.jdField_b_of_type_JavaLangString.startsWith("/")) {
      return "file:/" + paramAIOFileVideoData.jdField_b_of_type_JavaLangString;
    }
    if (paramAIOFileVideoData.jdField_b_of_type_JavaLangString.startsWith("//")) {
      return "file:" + paramAIOFileVideoData.jdField_b_of_type_JavaLangString;
    }
    return "file:" + paramAIOFileVideoData.jdField_b_of_type_JavaLangString;
  }
  
  public void a(AIOFileVideoData paramAIOFileVideoData)
  {
    paramAIOFileVideoData.jdField_f_of_type_Boolean = true;
    paramAIOFileVideoData.jdField_h_of_type_Boolean = true;
  }
  
  public void a(AIOFileVideoData paramAIOFileVideoData, View paramView, ailt paramailt)
  {
    if (c(paramAIOFileVideoData))
    {
      if (aroo.a(paramView.getContext(), false, new axud(this, paramAIOFileVideoData, paramailt, paramView))) {
        a(paramAIOFileVideoData, paramView.getContext(), paramailt);
      }
      return;
    }
    if (paramAIOFileVideoData.jdField_h_of_type_Boolean)
    {
      paramAIOFileVideoData.jdField_h_of_type_Boolean = false;
      paramailt.a(paramView, a(paramAIOFileVideoData, false));
    }
    paramailt.b();
    paramailt.f();
  }
  
  public boolean a(AIOFileVideoData paramAIOFileVideoData)
  {
    if ((paramAIOFileVideoData != null) && (!TextUtils.isEmpty(paramAIOFileVideoData.jdField_c_of_type_JavaLangString))) {
      return true;
    }
    if ((paramAIOFileVideoData != null) && (paramAIOFileVideoData.jdField_f_of_type_Boolean))
    {
      paramAIOFileVideoData.jdField_c_of_type_JavaLangString = paramAIOFileVideoData.jdField_f_of_type_JavaLangString;
      paramAIOFileVideoData.jdField_e_of_type_JavaLangString = null;
      return true;
    }
    return false;
  }
  
  public boolean a(AIOFileVideoData paramAIOFileVideoData, agft paramagft)
  {
    if ((paramAIOFileVideoData == null) || (a(paramAIOFileVideoData)) || (paramagft == null)) {}
    while ((!TextUtils.isEmpty(paramAIOFileVideoData.d)) && (!TextUtils.isEmpty(paramAIOFileVideoData.jdField_e_of_type_JavaLangString)) && (!TextUtils.isEmpty(paramAIOFileVideoData.jdField_f_of_type_JavaLangString))) {
      return false;
    }
    paramagft.a(paramAIOFileVideoData.jdField_a_of_type_Long, paramAIOFileVideoData.jdField_a_of_type_Int, 16842753);
    return true;
  }
  
  public boolean b(AIOFileVideoData paramAIOFileVideoData)
  {
    return !TextUtils.isEmpty(paramAIOFileVideoData.jdField_h_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axub
 * JD-Core Version:    0.7.0.1
 */