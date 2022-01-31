import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.ttpic.openapi.manager.FeatureManager;
import com.tencent.ttpic.openapi.watermark.LogicDataManager;
import java.io.File;
import java.util.HashMap;

public class birh
{
  private static boolean jdField_a_of_type_Boolean;
  private final int jdField_a_of_type_Int = 0;
  private final String jdField_a_of_type_JavaLangString = "AEFontManager";
  private HashMap<String, Typeface> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private final int[] jdField_a_of_type_ArrayOfInt = { 0, 1 };
  private final int b = 1;
  
  public static birh a()
  {
    if (!jdField_a_of_type_Boolean)
    {
      birj.a().a();
      jdField_a_of_type_Boolean = true;
    }
    return birj.a();
  }
  
  private void b(@NonNull String paramString, @NonNull Typeface paramTypeface)
  {
    int[] arrayOfInt = this.jdField_a_of_type_ArrayOfInt;
    int j = arrayOfInt.length;
    int i = 0;
    if (i < j)
    {
      switch (arrayOfInt[i])
      {
      }
      for (;;)
      {
        i += 1;
        break;
        LogicDataManager.getInstance().putTypeface(paramString, paramTypeface);
      }
    }
  }
  
  @NonNull
  public Typeface a(@Nullable String paramString)
  {
    if (paramString != null)
    {
      if (this.jdField_a_of_type_JavaUtilHashMap.get(paramString) == null) {
        return Typeface.DEFAULT;
      }
      return (Typeface)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
    }
    return Typeface.DEFAULT;
  }
  
  public void a()
  {
    a("jianqiaohei.ttf", FeatureManager.getResourceDir());
  }
  
  public void a(@Nullable String paramString, @Nullable Typeface paramTypeface)
  {
    if ((paramString == null) || (paramTypeface == null)) {
      return;
    }
    this.jdField_a_of_type_JavaUtilHashMap.put(paramString, paramTypeface);
    b(paramString, paramTypeface);
  }
  
  public void a(@Nullable String paramString1, @Nullable String paramString2)
  {
    Object localObject = paramString2;
    if (TextUtils.isEmpty(paramString2)) {
      localObject = FeatureManager.getResourceDir();
    }
    paramString2 = new File((String)localObject, paramString1);
    localObject = Typeface.DEFAULT;
    if (paramString2.exists()) {
      try
      {
        a(paramString1, Typeface.createFromFile(paramString2));
        return;
      }
      catch (RuntimeException paramString1)
      {
        bizq.d("AEFontManager", "【ERROR】Typeface.createFromFile");
        return;
      }
    }
    bizq.a("AEFontManager", "文件不存在" + paramString2.getAbsolutePath());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     birh
 * JD-Core Version:    0.7.0.1
 */