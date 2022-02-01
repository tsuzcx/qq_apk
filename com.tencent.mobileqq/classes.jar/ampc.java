import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.open.base.MD5Utils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class ampc
  extends bhyn
{
  ampc(ampa paramampa, File paramFile, ampd paramampd) {}
  
  public void onDone(bhyo parambhyo)
  {
    super.onDone(parambhyo);
    if (QLog.isColorLevel()) {
      QLog.d("rscContent_CmShowRscUpdateHandler", 2, "downloadAllZip task.getStatus:" + parambhyo.a());
    }
    if (3 == parambhyo.a())
    {
      if (this.jdField_a_of_type_JavaIoFile.exists()) {
        try
        {
          parambhyo = MD5Utils.encodeFileHexStr(this.jdField_a_of_type_JavaIoFile.getAbsolutePath());
          if (QLog.isColorLevel()) {
            QLog.d("rscContent_CmShowRscUpdateHandler", 2, " downloadAllZip onDone dstMd5:" + parambhyo + " result.mMd5:" + this.jdField_a_of_type_Ampd.d);
          }
          if (ampa.a(this.jdField_a_of_type_Ampd, parambhyo))
          {
            if (ampa.a(this.jdField_a_of_type_Ampd))
            {
              nwp.a(this.jdField_a_of_type_JavaIoFile, this.jdField_a_of_type_JavaIoFile.getParent() + File.separator);
              if (QLog.isColorLevel()) {
                QLog.d("rscContent_CmShowRscUpdateHandler", 2, "downloadAllZip unZipFile ok file path->" + this.jdField_a_of_type_JavaIoFile.getAbsolutePath());
              }
            }
            for (;;)
            {
              ampa.a(this.jdField_a_of_type_Ampa, this.jdField_a_of_type_Ampd.jdField_e_of_type_Int, this.jdField_a_of_type_Ampd);
              return;
              boolean bool = FileUtils.copyFile(this.jdField_a_of_type_JavaIoFile.getAbsolutePath(), this.jdField_a_of_type_Ampd.b() + this.jdField_a_of_type_Ampd.jdField_e_of_type_JavaLangString);
              QLog.i("rscContent_CmShowRscUpdateHandler", 1, "downloadAllZip no need unzip copy:" + bool);
            }
          }
          QLog.d("rscContent_CmShowRscUpdateHandler", 1, "downloadAllZip  file error path- no exist:" + this.jdField_a_of_type_JavaIoFile.getAbsolutePath());
        }
        catch (Exception parambhyo)
        {
          ampa.a(this.jdField_a_of_type_Ampa, this.jdField_a_of_type_Ampd.jdField_e_of_type_Int);
          this.jdField_a_of_type_JavaIoFile.delete();
          QLog.d("rscContent_CmShowRscUpdateHandler", 2, "downloadAllZip unZipFile file error path->" + this.jdField_a_of_type_JavaIoFile.getAbsolutePath() + parambhyo.getMessage());
          return;
          QLog.e("rscContent_CmShowRscUpdateHandler", 1, "dstMd5 != result.mMd5");
          ampa.a(this.jdField_a_of_type_Ampa, this.jdField_a_of_type_Ampd.jdField_e_of_type_Int);
          return;
        }
        catch (OutOfMemoryError parambhyo)
        {
          if (QLog.isColorLevel()) {
            QLog.d("rscContent_CmShowRscUpdateHandler", 2, "downloadAllZip unZipFile file error path->" + this.jdField_a_of_type_JavaIoFile.getAbsolutePath() + parambhyo.getMessage());
          }
          this.jdField_a_of_type_JavaIoFile.delete();
          return;
        }
      }
      ampa.a(this.jdField_a_of_type_Ampa, this.jdField_a_of_type_Ampd.jdField_e_of_type_Int);
      return;
    }
    QLog.d("rscContent_CmShowRscUpdateHandler", 1, "downloadAllZip  file error path->" + this.jdField_a_of_type_JavaIoFile.getAbsolutePath() + " task.getStatus()->" + parambhyo.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ampc
 * JD-Core Version:    0.7.0.1
 */