import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

public class amvy
  extends amvl
{
  public String b;
  public String c;
  
  public amvy(String paramString1, int paramInt1, int paramInt2, int paramInt3, float paramFloat1, float paramFloat2, float paramFloat3, String paramString2, String paramString3)
  {
    super(paramString1, paramInt1, paramInt2, paramInt3, paramFloat1, paramFloat2, paramFloat3);
    if (!TextUtils.isEmpty(paramString2))
    {
      paramString1 = paramString2.split("\\|");
      if (paramString1.length > 0) {
        this.b = paramString1[0];
      }
    }
    this.c = paramString3;
    QLog.d("GreetingCardResourceInfo", 2, String.format("GreetingCardResourceInfo mLuaScriptPath=%s mResourceDirPath=%s", new Object[] { this.b, this.c }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amvy
 * JD-Core Version:    0.7.0.1
 */