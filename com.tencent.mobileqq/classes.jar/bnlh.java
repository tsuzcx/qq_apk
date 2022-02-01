import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.ttpic.openapi.watermark.LogicDataManager;
import dov.com.qq.im.ae.font.AEFontManager.1;
import dov.com.qq.im.ae.font.AEFontManager.2;
import java.io.File;
import java.util.HashMap;

public class bnlh
{
  private static volatile boolean jdField_a_of_type_Boolean;
  private HashMap<String, Typeface> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  
  public static bnlh a()
  {
    return bnlj.a;
  }
  
  private void a(String paramString)
  {
    Typeface localTypeface = a().a(paramString);
    if (localTypeface != Typeface.DEFAULT)
    {
      bnrh.b("AEFontManager", "LogicDataManager putTypeface--hit cache: " + paramString);
      LogicDataManager.getInstance().putTypeface(paramString, localTypeface);
      return;
    }
    ThreadManager.excute(new AEFontManager.2(this, paramString), 64, null, false);
  }
  
  @NonNull
  public Typeface a(@Nullable String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      paramString = Typeface.DEFAULT;
    }
    Typeface localTypeface;
    do
    {
      return paramString;
      localTypeface = (Typeface)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
      paramString = localTypeface;
    } while (localTypeface != null);
    return Typeface.DEFAULT;
  }
  
  public void a()
  {
    if (jdField_a_of_type_Boolean)
    {
      bnrh.b("AEFontManager", "[preDownloadGifFonts] already triggered");
      return;
    }
    jdField_a_of_type_Boolean = true;
    ThreadManager.excute(new AEFontManager.1(this), 128, null, false);
  }
  
  public void a(@Nullable String paramString, @Nullable Typeface paramTypeface)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramTypeface == null)) {
      return;
    }
    this.jdField_a_of_type_JavaUtilHashMap.put(paramString, paramTypeface);
  }
  
  public void a(@Nullable String paramString1, @NonNull String paramString2)
  {
    paramString2 = new File(paramString2);
    if (paramString2.exists()) {
      try
      {
        paramString2 = Typeface.createFromFile(paramString2);
        if (paramString2 != null) {
          a(paramString1, paramString2);
        }
        return;
      }
      catch (Throwable paramString1)
      {
        bnrh.a("AEFontManager", "[setTypeface], create typeface raised exception, e=", paramString1);
        return;
      }
    }
    bnrh.b("AEFontManager", "[setTypeface], fontFile not exists, path=" + paramString2.getAbsolutePath());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnlh
 * JD-Core Version:    0.7.0.1
 */