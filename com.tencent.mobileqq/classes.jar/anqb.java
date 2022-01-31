import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.earlydownload.xmldata.QavSoData;
import com.tencent.mobileqq.earlydownload.xmldata.XmlData;

public class anqb
  extends anqc
{
  public anqb(QQAppInterface paramQQAppInterface)
  {
    super(e(), paramQQAppInterface);
  }
  
  public static String e()
  {
    if (AppSetting.b) {
      return "qq.android.qav.sov9_828_for_arm64";
    }
    if (llw.f() <= 2) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     anqb
 * JD-Core Version:    0.7.0.1
 */