import android.content.Context;
import com.tencent.mobileqq.app.QQAppInterface;
import java.io.File;

public class bdsf
  extends bdrz
{
  public static bdsf a = new bdsf();
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt, bdpj parambdpj, boolean paramBoolean)
  {
    a.download(paramQQAppInterface, "qqVipLevel." + paramInt, parambdpj, paramBoolean);
  }
  
  public static boolean a(Context paramContext, int paramInt)
  {
    String str = "qqVipLevel." + paramInt;
    return new File(a.getDir(paramContext, str)).exists();
  }
  
  public long getBID()
  {
    return 41L;
  }
  
  protected String getRootDir()
  {
    return "qqlevel_icon";
  }
  
  protected String getScidPrefix()
  {
    return "qqVipLevel.";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdsf
 * JD-Core Version:    0.7.0.1
 */