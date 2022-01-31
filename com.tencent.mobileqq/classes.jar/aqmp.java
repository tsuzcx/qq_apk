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

public class aqmp
  extends aqmj
{
  private void a(AIOFileVideoData paramAIOFileVideoData, Context paramContext, agqx paramagqx)
  {
    paramAIOFileVideoData = new aqmq(this, paramContext, paramAIOFileVideoData, paramagqx);
    aptr.a(paramContext, paramContext.getString(2131692672), paramContext.getString(2131692674), paramAIOFileVideoData);
  }
  
  private boolean c(AIOFileVideoData paramAIOFileVideoData)
  {
    if ((paramAIOFileVideoData == null) || (paramAIOFileVideoData.jdField_g_of_type_Boolean)) {}
    do
    {
      do
      {
        return false;
      } while (!apue.a());
      if ((!TextUtils.isEmpty(paramAIOFileVideoData.jdField_a_of_type_JavaLangString)) && (paramAIOFileVideoData.jdField_c_of_type_Long > 0L) && (paramAIOFileVideoData.jdField_c_of_type_Long > paramAIOFileVideoData.jdField_e_of_type_Long)) {
        return true;
      }
    } while (paramAIOFileVideoData.jdField_c_of_type_Long <= 1048576L);
    return true;
  }
  
  public agrc a(AIOFileVideoData paramAIOFileVideoData, boolean paramBoolean)
  {
    boolean bool = false;
    agrc localagrc = new agrc();
    localagrc.jdField_a_of_type_ArrayOfJavaLangString = new String[] { paramAIOFileVideoData.d };
    localagrc.jdField_b_of_type_JavaLangString = paramAIOFileVideoData.jdField_e_of_type_JavaLangString;
    if (!a(paramAIOFileVideoData)) {
      bool = true;
    }
    localagrc.jdField_a_of_type_Boolean = bool;
    if (localagrc.jdField_a_of_type_Boolean) {}
    for (String str = paramAIOFileVideoData.jdField_f_of_type_JavaLangString;; str = paramAIOFileVideoData.jdField_c_of_type_JavaLangString)
    {
      localagrc.jdField_a_of_type_JavaLangString = str;
      localagrc.jdField_c_of_type_Long = paramAIOFileVideoData.jdField_g_of_type_Long;
      localagrc.jdField_b_of_type_Boolean = true;
      localagrc.jdField_b_of_type_Long = paramAIOFileVideoData.jdField_c_of_type_Long;
      localagrc.jdField_a_of_type_Long = paramAIOFileVideoData.jdField_a_of_type_Long;
      localagrc.jdField_b_of_type_Int = paramAIOFileVideoData.jdField_a_of_type_Int;
      localagrc.e = paramBoolean;
      return localagrc;
    }
  }
  
  public Drawable a(AIOFileVideoData paramAIOFileVideoData)
  {
    URLDrawable localURLDrawable = null;
    File localFile = a(paramAIOFileVideoData);
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mLoadingDrawable = aywk.a;
    localURLDrawableOptions.mFailedDrawable = aywk.a;
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
    if ((paramAIOFileVideoData == null) || (!apvb.b(paramAIOFileVideoData.jdField_b_of_type_JavaLangString))) {
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
  
  public void a(AIOFileVideoData paramAIOFileVideoData, View paramView, agqx paramagqx)
  {
    if (c(paramAIOFileVideoData))
    {
      if (apvk.a(paramView.getContext(), false, new aqmr(this, paramAIOFileVideoData, paramagqx, paramView))) {
        a(paramAIOFileVideoData, paramView.getContext(), paramagqx);
      }
      return;
    }
    if (paramAIOFileVideoData.jdField_h_of_type_Boolean)
    {
      paramAIOFileVideoData.jdField_h_of_type_Boolean = false;
      paramagqx.a(paramView, a(paramAIOFileVideoData, false));
    }
    paramagqx.b();
    paramagqx.f();
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
  
  public boolean a(AIOFileVideoData paramAIOFileVideoData, aejd paramaejd)
  {
    if ((paramAIOFileVideoData == null) || (a(paramAIOFileVideoData))) {}
    while ((!TextUtils.isEmpty(paramAIOFileVideoData.d)) && (!TextUtils.isEmpty(paramAIOFileVideoData.jdField_e_of_type_JavaLangString)) && (!TextUtils.isEmpty(paramAIOFileVideoData.jdField_f_of_type_JavaLangString))) {
      return false;
    }
    paramaejd.a(paramAIOFileVideoData.jdField_a_of_type_Long, paramAIOFileVideoData.jdField_a_of_type_Int, 16842753);
    return true;
  }
  
  public boolean b(AIOFileVideoData paramAIOFileVideoData)
  {
    return !TextUtils.isEmpty(paramAIOFileVideoData.jdField_h_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aqmp
 * JD-Core Version:    0.7.0.1
 */