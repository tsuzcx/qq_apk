import com.tencent.mobileqq.shortvideo.util.RecentDanceConfigMgr;
import com.tencent.mobileqq.shortvideo.util.RecentDanceConfigMgr.DItemInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public final class axlf
  implements aysa
{
  public axlf(RecentDanceConfigMgr.DItemInfo paramDItemInfo, String paramString) {}
  
  public void onResp(aysx paramaysx)
  {
    if (paramaysx.jdField_a_of_type_Int == 0)
    {
      paramaysx = paramaysx.jdField_a_of_type_Aysw;
      if (new File(paramaysx.c).exists())
      {
        str = RecentDanceConfigMgr.a(paramaysx.c);
        if ((str == null) || ("".equals(str)) || (!str.equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilRecentDanceConfigMgr$DItemInfo.icon_md5)))
        {
          bbdj.d(paramaysx.c);
          bbdj.d(this.jdField_a_of_type_JavaLangString);
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
        bbdj.c(paramaysx.c, this.jdField_a_of_type_JavaLangString);
        RecentDanceConfigMgr.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilRecentDanceConfigMgr$DItemInfo, this.jdField_a_of_type_JavaLangString);
        return;
      }
      QLog.i("RecentDanceConfigMgr", 2, "processNetWork onResp[not exists]: mOutPath" + paramaysx.c);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("RecentDanceConfigMgr", 2, "processNetWork onResp: resp.mResult=" + paramaysx.jdField_a_of_type_Int);
    }
    bbdj.d(paramaysx.jdField_a_of_type_Aysw.c);
  }
  
  public void onUpdateProgeress(aysw paramaysw, long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("RecentDanceConfigMgr", 2, "processNetWork onUpdateProgeress: totalLen=" + paramLong2 + " curOffset=" + paramLong1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     axlf
 * JD-Core Version:    0.7.0.1
 */