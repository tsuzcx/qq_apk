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

public class axyk
  extends BrowserBaseModel
{
  private void a(AIOFileVideoData paramAIOFileVideoData, Context paramContext, aiqi paramaiqi)
  {
    paramAIOFileVideoData = new axyl(this, paramContext, paramAIOFileVideoData, paramaiqi);
    arre.a(paramContext, paramContext.getString(2131692754), paramContext.getString(2131692756), paramAIOFileVideoData);
  }
  
  private boolean c(AIOFileVideoData paramAIOFileVideoData)
  {
    if ((paramAIOFileVideoData == null) || (paramAIOFileVideoData.g)) {}
    do
    {
      do
      {
        return false;
      } while (!arrr.a());
      if ((!TextUtils.isEmpty(paramAIOFileVideoData.jdField_a_of_type_JavaLangString)) && (paramAIOFileVideoData.jdField_c_of_type_Long > 0L) && (paramAIOFileVideoData.jdField_c_of_type_Long > paramAIOFileVideoData.jdField_e_of_type_Long)) {
        return true;
      }
    } while (paramAIOFileVideoData.jdField_c_of_type_Long <= 1048576L);
    return true;
  }
  
  public aiqo a(AIOFileVideoData paramAIOFileVideoData, boolean paramBoolean)
  {
    boolean bool = false;
    aiqo localaiqo = new aiqo();
    localaiqo.jdField_a_of_type_ArrayOfJavaLangString = new String[] { paramAIOFileVideoData.d };
    localaiqo.jdField_b_of_type_JavaLangString = paramAIOFileVideoData.jdField_e_of_type_JavaLangString;
    if (!a(paramAIOFileVideoData)) {
      bool = true;
    }
    localaiqo.jdField_a_of_type_Boolean = bool;
    if (localaiqo.jdField_a_of_type_Boolean) {}
    for (String str = paramAIOFileVideoData.jdField_f_of_type_JavaLangString;; str = paramAIOFileVideoData.jdField_c_of_type_JavaLangString)
    {
      localaiqo.jdField_a_of_type_JavaLangString = str;
      localaiqo.jdField_c_of_type_Long = paramAIOFileVideoData.progress;
      localaiqo.jdField_b_of_type_Boolean = true;
      localaiqo.jdField_b_of_type_Long = paramAIOFileVideoData.jdField_c_of_type_Long;
      localaiqo.jdField_a_of_type_Long = paramAIOFileVideoData.jdField_a_of_type_Long;
      localaiqo.jdField_b_of_type_Int = paramAIOFileVideoData.jdField_a_of_type_Int;
      localaiqo.e = paramBoolean;
      return localaiqo;
    }
  }
  
  public Drawable a(AIOFileVideoData paramAIOFileVideoData)
  {
    URLDrawable localURLDrawable = null;
    File localFile = a(paramAIOFileVideoData);
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mLoadingDrawable = bayu.a;
    localURLDrawableOptions.mFailedDrawable = bayu.a;
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
    if ((paramAIOFileVideoData == null) || (!arso.b(paramAIOFileVideoData.jdField_b_of_type_JavaLangString))) {
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
  
  public void a(AIOFileVideoData paramAIOFileVideoData, View paramView, aiqi paramaiqi)
  {
    if (c(paramAIOFileVideoData))
    {
      if (arsx.a(paramView.getContext(), false, new axym(this, paramAIOFileVideoData, paramaiqi, paramView))) {
        a(paramAIOFileVideoData, paramView.getContext(), paramaiqi);
      }
      return;
    }
    if (paramAIOFileVideoData.jdField_h_of_type_Boolean)
    {
      paramAIOFileVideoData.jdField_h_of_type_Boolean = false;
      paramaiqi.a(paramView, a(paramAIOFileVideoData, false));
    }
    paramaiqi.b();
    paramaiqi.f();
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
  
  public boolean a(AIOFileVideoData paramAIOFileVideoData, agki paramagki)
  {
    if ((paramAIOFileVideoData == null) || (a(paramAIOFileVideoData)) || (paramagki == null)) {}
    while ((!TextUtils.isEmpty(paramAIOFileVideoData.d)) && (!TextUtils.isEmpty(paramAIOFileVideoData.jdField_e_of_type_JavaLangString)) && (!TextUtils.isEmpty(paramAIOFileVideoData.jdField_f_of_type_JavaLangString))) {
      return false;
    }
    paramagki.a(paramAIOFileVideoData.jdField_a_of_type_Long, paramAIOFileVideoData.jdField_a_of_type_Int, 16842753);
    return true;
  }
  
  public boolean b(AIOFileVideoData paramAIOFileVideoData)
  {
    return !TextUtils.isEmpty(paramAIOFileVideoData.jdField_h_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axyk
 * JD-Core Version:    0.7.0.1
 */