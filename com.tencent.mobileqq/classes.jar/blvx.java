import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import java.io.File;
import java.util.HashMap;

public class blvx
{
  private HashMap<String, Typeface> a = new HashMap();
  
  public static blvx a()
  {
    return blvz.a;
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
      localTypeface = (Typeface)this.a.get(paramString);
      paramString = localTypeface;
    } while (localTypeface != null);
    return Typeface.DEFAULT;
  }
  
  public void a(@Nullable String paramString, @Nullable Typeface paramTypeface)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramTypeface == null)) {
      return;
    }
    this.a.put(paramString, paramTypeface);
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
        bmbx.a("AEFontManager", "[setTypeface], create typeface raised exception, e=", paramString1);
        return;
      }
    }
    bmbx.b("AEFontManager", "[setTypeface], fontFile not exists, path=" + paramString2.getAbsolutePath());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blvx
 * JD-Core Version:    0.7.0.1
 */