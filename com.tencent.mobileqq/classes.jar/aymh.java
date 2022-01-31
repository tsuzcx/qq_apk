import android.content.Context;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.BaseApplication;
import java.io.File;

public class aymh
{
  private String a;
  private String b;
  private String c;
  
  public aymh a()
  {
    BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
    return a("999").a(localBaseApplication, "999_540", "999_540");
  }
  
  public aymh a(Context paramContext, String paramString1, String paramString2)
  {
    paramContext = a(paramContext);
    this.b = (paramContext + paramString1 + ".zip");
    this.c = (paramContext + paramString1 + File.separator + paramString2 + File.separator);
    return this;
  }
  
  public aymh a(String paramString)
  {
    this.a = paramString;
    return this;
  }
  
  public String a()
  {
    return this.a;
  }
  
  public String a(Context paramContext)
  {
    paramContext = paramContext.getDir("theme_810", 0).getAbsolutePath();
    StringBuilder localStringBuilder = actn.a().append(paramContext);
    if (!paramContext.endsWith(File.separator)) {
      localStringBuilder.append(File.separator);
    }
    return this.a + File.separator;
  }
  
  public boolean a()
  {
    return new File(this.b).exists();
  }
  
  public aymh b()
  {
    return a(BaseApplicationImpl.getContext(), "test", "test");
  }
  
  public String b()
  {
    return ThemeUtil.getThemeConfigID(this.a);
  }
  
  public String b(Context paramContext)
  {
    paramContext = a(paramContext);
    return paramContext + "3_" + b() + ".cfg";
  }
  
  public boolean b()
  {
    return new File(this.c).exists();
  }
  
  public aymh c()
  {
    this.b = null;
    this.c = null;
    return this;
  }
  
  public String c()
  {
    return this.b;
  }
  
  public String d()
  {
    return this.c;
  }
  
  public String toString()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aymh
 * JD-Core Version:    0.7.0.1
 */