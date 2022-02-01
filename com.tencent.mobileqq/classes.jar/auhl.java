import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import java.text.SimpleDateFormat;
import java.util.Date;
import tencent.im.cs.group_file_common.group_file_common.FileInfo;

class auhl
  extends aavj
{
  auhl(auha paramauha) {}
  
  protected void a(boolean paramBoolean, int paramInt, group_file_common.FileInfo paramFileInfo)
  {
    if (paramFileInfo != null)
    {
      String str = bhlg.h(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, String.valueOf(this.a.jdField_a_of_type_Auei.a().TroopUin), paramFileInfo.uint64_uploader_uin.get() + "");
      paramFileInfo = new Date(paramFileInfo.uint32_upload_time.get() * 1000L);
      SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy.MM.dd");
      paramFileInfo = " 于" + localSimpleDateFormat.format(paramFileInfo) + "上传";
      if (this.a.jdField_a_of_type_Augq != null) {
        this.a.jdField_a_of_type_Augq.b(str, paramFileInfo);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auhl
 * JD-Core Version:    0.7.0.1
 */