import com.tencent.commonsdk.util.HexUtil;
import com.tencent.mobileqq.filemanager.settings.FileAssistantBannerSetting.2;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class aptq
  implements aysa
{
  public aptq(FileAssistantBannerSetting.2 param2) {}
  
  public void onResp(aysx paramaysx)
  {
    QLog.e("FileAssistantBannerSetting", 1, "onResp url: " + this.a.a.b() + " resultcode: " + paramaysx.c);
    if ((paramaysx.c == 200) && (paramaysx.jdField_a_of_type_Int == 0) && (vyi.c(paramaysx.jdField_a_of_type_Aysw.c)))
    {
      if (HexUtil.bytes2HexStr(apue.d(paramaysx.jdField_a_of_type_Aysw.c)).equalsIgnoreCase(this.a.a.a())) {
        this.a.a.a(paramaysx.jdField_a_of_type_Aysw.c);
      }
    }
    else {
      return;
    }
    QLog.e("FileAssistantBannerSetting", 1, "pic md5 != srvMd5, may be pic is error!");
    new File(paramaysx.jdField_a_of_type_Aysw.c).delete();
  }
  
  public void onUpdateProgeress(aysw paramaysw, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aptq
 * JD-Core Version:    0.7.0.1
 */