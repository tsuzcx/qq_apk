import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.earlydownload.xmldata.QavSoData;
import com.tencent.mobileqq.earlydownload.xmldata.XmlData;

public class aphj
  extends aphk
{
  public aphj(QQAppInterface paramQQAppInterface)
  {
    super(e(), paramQQAppInterface);
  }
  
  public static String e()
  {
    if (lnz.f() <= 2) {
      return "qq.android.qav.so_665";
    }
    return "qq.android.qav.sov9_828";
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
 * Qualified Name:     aphj
 * JD-Core Version:    0.7.0.1
 */