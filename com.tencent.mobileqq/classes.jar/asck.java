import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.earlydownload.xmldata.QavSoData;
import com.tencent.mobileqq.earlydownload.xmldata.XmlData;

public class asck
  extends ascl
{
  public asck(QQAppInterface paramQQAppInterface)
  {
    super(e(), paramQQAppInterface);
  }
  
  public static String e()
  {
    if (llq.f() <= 2) {
      return "qq.android.qav.so_665";
    }
    return "";
  }
  
  public Class<? extends XmlData> a()
  {
    return QavSoData.class;
  }
  
  public String b()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asck
 * JD-Core Version:    0.7.0.1
 */