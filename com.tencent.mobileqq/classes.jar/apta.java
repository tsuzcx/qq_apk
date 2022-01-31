import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.gallery.model.video.AIOFileVideoData;
import java.io.File;

public class apta
  extends apsu
{
  private void a(AIOFileVideoData paramAIOFileVideoData, Context paramContext, agez paramagez)
  {
    paramAIOFileVideoData = new aptb(this, paramContext, paramAIOFileVideoData, paramagez);
    apbx.a(paramContext, paramContext.getString(2131627035), paramContext.getString(2131627037), paramAIOFileVideoData);
  }
  
  private boolean c(AIOFileVideoData paramAIOFileVideoData)
  {
    if ((paramAIOFileVideoData == null) || (paramAIOFileVideoData.jdField_g_of_type_Boolean)) {}
    do
    {
      do
      {
        return false;
      } while (!apck.a());
      if ((!TextUtils.isEmpty(paramAIOFileVideoData.jdField_a_of_type_JavaLangString)) && (paramAIOFileVideoData.jdField_c_of_type_Long > 0L) && (paramAIOFileVideoData.jdField_c_of_type_Long > paramAIOFileVideoData.jdField_e_of_type_Long)) {
        return true;
      }
    } while (paramAIOFileVideoData.jdField_c_of_type_Long <= 1048576L);
    return true;
  }
  
  public agfe a(AIOFileVideoData paramAIOFileVideoData, boolean paramBoolean)
  {
    boolean bool = false;
    agfe localagfe = new agfe();
    localagfe.jdField_a_of_type_ArrayOfJavaLangString = new String[] { paramAIOFileVideoData.d };
    localagfe.jdField_b_of_type_JavaLangString = paramAIOFileVideoData.jdField_e_of_type_JavaLangString;
    if (!a(paramAIOFileVideoData)) {
      bool = true;
    }
    localagfe.jdField_a_of_type_Boolean = bool;
    if (localagfe.jdField_a_of_type_Boolean) {}
    for (String str = paramAIOFileVideoData.jdField_f_of_type_JavaLangString;; str = paramAIOFileVideoData.jdField_c_of_type_JavaLangString)
    {
      localagfe.jdField_a_of_type_JavaLangString = str;
      localagfe.jdField_c_of_type_Long = paramAIOFileVideoData.jdField_g_of_type_Long;
      localagfe.jdField_b_of_type_Boolean = true;
      localagfe.jdField_b_of_type_Long = paramAIOFileVideoData.jdField_c_of_type_Long;
      localagfe.jdField_a_of_type_Long = paramAIOFileVideoData.jdField_a_of_type_Long;
      localagfe.jdField_b_of_type_Int = paramAIOFileVideoData.jdField_a_of_type_Int;
      localagfe.e = paramBoolean;
      return localagfe;
    }
  }
  
  public Drawable a(AIOFileVideoData paramAIOFileVideoData)
  {
    URLDrawable localURLDrawable = null;
    File localFile = a(paramAIOFileVideoData);
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mLoadingDrawable = axwd.a;
    localURLDrawableOptions.mFailedDrawable = axwd.a;
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
    if ((paramAIOFileVideoData == null) || (!apdh.b(paramAIOFileVideoData.jdField_b_of_type_JavaLangString))) {
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
  
  public void a(AIOFileVideoData paramAIOFileVideoData, View paramView, agez paramagez)
  {
    if (c(paramAIOFileVideoData))
    {
      if (apdq.a(paramView.getContext(), false, new aptc(this, paramAIOFileVideoData, paramagez, paramView))) {
        a(paramAIOFileVideoData, paramView.getContext(), paramagez);
      }
      return;
    }
    if (paramAIOFileVideoData.jdField_h_of_type_Boolean)
    {
      paramAIOFileVideoData.jdField_h_of_type_Boolean = false;
      paramagez.a(paramView, a(paramAIOFileVideoData, false));
    }
    paramagez.b();
    paramagez.f();
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
  
  public boolean a(AIOFileVideoData paramAIOFileVideoData, adye paramadye)
  {
    if ((paramAIOFileVideoData == null) || (a(paramAIOFileVideoData))) {}
    while ((!TextUtils.isEmpty(paramAIOFileVideoData.d)) && (!TextUtils.isEmpty(paramAIOFileVideoData.jdField_e_of_type_JavaLangString)) && (!TextUtils.isEmpty(paramAIOFileVideoData.jdField_f_of_type_JavaLangString))) {
      return false;
    }
    paramadye.a(paramAIOFileVideoData.jdField_a_of_type_Long, paramAIOFileVideoData.jdField_a_of_type_Int, 16842753);
    return true;
  }
  
  public boolean b(AIOFileVideoData paramAIOFileVideoData)
  {
    return !TextUtils.isEmpty(paramAIOFileVideoData.jdField_h_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     apta
 * JD-Core Version:    0.7.0.1
 */