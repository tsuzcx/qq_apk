import com.tencent.mobileqq.shortvideo.util.RecentDanceConfigMgr;
import com.tencent.mobileqq.shortvideo.util.RecentDanceConfigMgr.DItemInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public final class axlh
  implements aysc
{
  public axlh(RecentDanceConfigMgr.DItemInfo paramDItemInfo, String paramString) {}
  
  public void onResp(aysz paramaysz)
  {
    if (paramaysz.jdField_a_of_type_Int == 0)
    {
      paramaysz = paramaysz.jdField_a_of_type_Aysy;
      if (new File(paramaysz.c).exists())
      {
        str = RecentDanceConfigMgr.a(paramaysz.c);
        if ((str == null) || ("".equals(str)) || (!str.equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilRecentDanceConfigMgr$DItemInfo.icon_md5)))
        {
          bbdx.d(paramaysz.c);
          bbdx.d(this.jdField_a_of_type_JavaLangString);
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
        bbdx.c(paramaysz.c, this.jdField_a_of_type_JavaLangString);
        RecentDanceConfigMgr.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilRecentDanceConfigMgr$DItemInfo, this.jdField_a_of_type_JavaLangString);
        return;
      }
      QLog.i("RecentDanceConfigMgr", 2, "processNetWork onResp[not exists]: mOutPath" + paramaysz.c);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("RecentDanceConfigMgr", 2, "processNetWork onResp: resp.mResult=" + paramaysz.jdField_a_of_type_Int);
    }
    bbdx.d(paramaysz.jdField_a_of_type_Aysy.c);
  }
  
  public void onUpdateProgeress(aysy paramaysy, long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("RecentDanceConfigMgr", 2, "processNetWork onUpdateProgeress: totalLen=" + paramLong2 + " curOffset=" + paramLong1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     axlh
 * JD-Core Version:    0.7.0.1
 */