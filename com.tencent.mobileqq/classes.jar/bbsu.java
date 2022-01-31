import android.content.Context;
import com.tencent.mobileqq.app.QQAppInterface;
import java.io.File;

public class bbsu
  extends bbso
{
  public static bbsu a = new bbsu();
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt, bbqb parambbqb, boolean paramBoolean)
  {
    a.download(paramQQAppInterface, "qqVipLevel." + paramInt, parambbqb, paramBoolean);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     bbsu
 * JD-Core Version:    0.7.0.1
 */