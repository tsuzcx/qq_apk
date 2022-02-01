import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.open.base.BspatchUtil;
import com.tencent.open.base.MD5Utils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class ampb
  extends bhyn
{
  ampb(ampa paramampa, File paramFile, ampd paramampd) {}
  
  public void onDone(bhyo parambhyo)
  {
    super.onDone(parambhyo);
    if (QLog.isColorLevel()) {
      QLog.d("rscContent_CmShowRscUpdateHandler", 2, "downloadZipAndPatch task.getStatus:" + parambhyo.a());
    }
    if (3 == parambhyo.a())
    {
      if (this.jdField_a_of_type_JavaIoFile.exists())
      {
        String str = this.jdField_a_of_type_Ampd.e();
        parambhyo = this.jdField_a_of_type_Ampd.c();
        if (BspatchUtil.a(str, this.jdField_a_of_type_JavaIoFile.getAbsolutePath(), parambhyo))
        {
          try
          {
            str = MD5Utils.encodeFileHexStr(parambhyo);
            if (QLog.isColorLevel()) {
              QLog.d("rscContent_CmShowRscUpdateHandler", 2, " downloadZipAndPatch onDone dstMd5:" + str + " result.mMd5:" + this.jdField_a_of_type_Ampd.d);
            }
            if (ampa.a(this.jdField_a_of_type_Ampd, str))
            {
              if (ampa.a(this.jdField_a_of_type_Ampd))
              {
                nwp.a(new File(parambhyo), this.jdField_a_of_type_JavaIoFile.getParent() + File.separator);
                if (QLog.isColorLevel()) {
                  QLog.d("rscContent_CmShowRscUpdateHandler", 2, "downloadZipAndPatch unZipFile ok file path->" + this.jdField_a_of_type_JavaIoFile.getAbsolutePath() + " dstpath:" + parambhyo);
                }
              }
              for (;;)
              {
                ampa.a(this.jdField_a_of_type_Ampa, this.jdField_a_of_type_Ampd.jdField_e_of_type_Int, this.jdField_a_of_type_Ampd);
                return;
                boolean bool = FileUtils.copyFile(parambhyo, this.jdField_a_of_type_Ampd.b() + this.jdField_a_of_type_Ampd.jdField_e_of_type_JavaLangString);
                QLog.i("rscContent_CmShowRscUpdateHandler", 1, "downloadZipAndPatch no need unzip copy:" + bool);
              }
            }
            QLog.d("rscContent_CmShowRscUpdateHandler", 2, "downloadZipAndPatch unZipFile file error path->" + this.jdField_a_of_type_JavaIoFile.getAbsolutePath() + parambhyo.getMessage());
          }
          catch (Exception parambhyo)
          {
            this.jdField_a_of_type_JavaIoFile.delete();
            QLog.d("rscContent_CmShowRscUpdateHandler", 2, "downloadZipAndPatch unZipFile file error path->" + this.jdField_a_of_type_JavaIoFile.getAbsolutePath() + parambhyo.getMessage());
            return;
            QLog.e("rscContent_CmShowRscUpdateHandler", 1, "dstMd5 != result.mMd5");
            ampa.a(this.jdField_a_of_type_Ampa, this.jdField_a_of_type_Ampd);
            return;
          }
          catch (OutOfMemoryError parambhyo)
          {
            this.jdField_a_of_type_JavaIoFile.delete();
            if (!QLog.isColorLevel()) {
              return;
            }
          }
        }
        else
        {
          QLog.d("rscContent_CmShowRscUpdateHandler", 1, "downloadZipAndPatch patchFile error path->" + this.jdField_a_of_type_JavaIoFile.getAbsolutePath());
          ampa.a(this.jdField_a_of_type_Ampa, this.jdField_a_of_type_Ampd);
        }
      }
      else
      {
        ampa.a(this.jdField_a_of_type_Ampa, this.jdField_a_of_type_Ampd);
        QLog.d("rscContent_CmShowRscUpdateHandler", 1, "downloadZipAndPatch patchFile no exist path->" + this.jdField_a_of_type_JavaIoFile.getAbsolutePath() + " task.getStatus()->" + parambhyo.a());
      }
    }
    else {
      QLog.d("rscContent_CmShowRscUpdateHandler", 1, "downloadZipAndPatch  file error path->" + this.jdField_a_of_type_JavaIoFile.getAbsolutePath() + " task.getStatus()->" + parambhyo.a());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ampb
 * JD-Core Version:    0.7.0.1
 */