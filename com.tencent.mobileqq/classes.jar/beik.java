import android.content.Context;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.BaseApplication;
import java.io.File;

public class beik
{
  private String a;
  private String b;
  private String c;
  
  public beik a()
  {
    BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
    return a("999").a(localBaseApplication, "999_540", "999_540");
  }
  
  public beik a(Context paramContext, String paramString1, String paramString2)
  {
    paramContext = a(paramContext);
    this.b = (paramContext + paramString1 + ".zip");
    this.c = (paramContext + paramString1 + File.separator + paramString2 + File.separator);
    return this;
  }
  
  public beik a(String paramString)
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
    StringBuilder localStringBuilder = AIOUtils.obtainStringBuilder().append(paramContext);
    if (!paramContext.endsWith(File.separator)) {
      localStringBuilder.append(File.separator);
    }
    return this.a + File.separator;
  }
  
  public boolean a()
  {
    return new File(this.b).exists();
  }
  
  public beik b()
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
  
  public beik c()
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     beik
 * JD-Core Version:    0.7.0.1
 */