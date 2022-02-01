import android.content.Context;
import com.tencent.mobileqq.app.QQAppInterface;
import java.io.File;

public class bico
  extends bici
{
  public static bico a = new bico();
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt, bhza parambhza, boolean paramBoolean)
  {
    a.download(paramQQAppInterface, "qqVipLevel." + paramInt, parambhza, paramBoolean);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bico
 * JD-Core Version:    0.7.0.1
 */