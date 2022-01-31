import com.tencent.commonsdk.util.HexUtil;
import com.tencent.mobileqq.filemanager.settings.FileAssistantBannerSetting.2;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class apbw
  implements axrt
{
  public apbw(FileAssistantBannerSetting.2 param2) {}
  
  public void onResp(axsq paramaxsq)
  {
    QLog.e("FileAssistantBannerSetting", 1, "onResp url: " + this.a.a.b() + " resultcode: " + paramaxsq.c);
    if ((paramaxsq.c == 200) && (paramaxsq.jdField_a_of_type_Int == 0) && (vlm.c(paramaxsq.jdField_a_of_type_Axsp.c)))
    {
      if (HexUtil.bytes2HexStr(apck.d(paramaxsq.jdField_a_of_type_Axsp.c)).equalsIgnoreCase(this.a.a.a())) {
        this.a.a.a(paramaxsq.jdField_a_of_type_Axsp.c);
      }
    }
    else {
      return;
    }
    QLog.e("FileAssistantBannerSetting", 1, "pic md5 != srvMd5, may be pic is error!");
    new File(paramaxsq.jdField_a_of_type_Axsp.c).delete();
  }
  
  public void onUpdateProgeress(axsp paramaxsp, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     apbw
 * JD-Core Version:    0.7.0.1
 */