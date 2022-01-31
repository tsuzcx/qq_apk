import com.tencent.mobileqq.shortvideo.util.RecentDanceConfigMgr;
import com.tencent.mobileqq.shortvideo.util.RecentDanceConfigMgr.DItemInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public final class azgn
  implements bapx
{
  public azgn(RecentDanceConfigMgr.DItemInfo paramDItemInfo, String paramString) {}
  
  public void onResp(baqw parambaqw)
  {
    if (parambaqw.jdField_a_of_type_Int == 0)
    {
      parambaqw = parambaqw.jdField_a_of_type_Baqv;
      if (new File(parambaqw.c).exists())
      {
        str = RecentDanceConfigMgr.a(parambaqw.c);
        if ((str == null) || ("".equals(str)) || (!str.equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilRecentDanceConfigMgr$DItemInfo.icon_md5)))
        {
          bdcs.d(parambaqw.c);
          bdcs.d(this.jdField_a_of_type_JavaLangString);
          if (QLog.isColorLevel()) {
            QLog.i("RecentDanceConfigMgr", 2, "processNetWork onResp: item.icon_md5" + this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilRecentDanceConfigMgr$DItemInfo.icon_md5 + " md5=" + str);
          }
        }
      }
      while (!QLog.isColorLevel())
      {
        String str;
        return;
        if (QLog.isColorLevel()) {
          QLog.i("RecentDanceConfigMgr", 2, "processNetWork onResp: check success");
        }
        bdcs.c(parambaqw.c, this.jdField_a_of_type_JavaLangString);
        RecentDanceConfigMgr.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilRecentDanceConfigMgr$DItemInfo, this.jdField_a_of_type_JavaLangString);
        return;
      }
      QLog.i("RecentDanceConfigMgr", 2, "processNetWork onResp[not exists]: mOutPath" + parambaqw.c);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("RecentDanceConfigMgr", 2, "processNetWork onResp: resp.mResult=" + parambaqw.jdField_a_of_type_Int);
    }
    bdcs.d(parambaqw.jdField_a_of_type_Baqv.c);
  }
  
  public void onUpdateProgeress(baqv parambaqv, long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("RecentDanceConfigMgr", 2, "processNetWork onUpdateProgeress: totalLen=" + paramLong2 + " curOffset=" + paramLong1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azgn
 * JD-Core Version:    0.7.0.1
 */