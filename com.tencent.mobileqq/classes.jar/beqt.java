import android.text.TextUtils;
import com.tencent.qqmini.sdk.launcher.model.MiniAppBaseInfo;
import java.io.File;

public abstract class beqt
{
  public String a;
  public String b;
  public String c;
  public String d;
  public String e;
  
  public beqt() {}
  
  public beqt(String paramString, MiniAppBaseInfo paramMiniAppBaseInfo)
  {
    this.a = paramString;
    if (paramMiniAppBaseInfo != null)
    {
      this.d = paramMiniAppBaseInfo.appId;
      this.c = paramMiniAppBaseInfo.name;
      this.e = paramMiniAppBaseInfo.iconUrl;
    }
  }
  
  public abstract String c(String paramString);
  
  public String e()
  {
    return this.a;
  }
  
  public String f()
  {
    return this.a;
  }
  
  public String g(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    return new File(f(), paramString).getAbsolutePath();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("appId:").append(this.d).append(", name:").append(this.c);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     beqt
 * JD-Core Version:    0.7.0.1
 */