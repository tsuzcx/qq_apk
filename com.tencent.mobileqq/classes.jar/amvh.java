import com.tencent.qphone.base.util.QLog;
import java.io.File;

class amvh
  extends biht
{
  amvh(amvf paramamvf, File paramFile, amvi paramamvi) {}
  
  public void onDone(bihu parambihu)
  {
    super.onDone(parambihu);
    if (QLog.isColorLevel()) {
      QLog.d("rscContent_CmShowRscUpdateHandler", 2, "downloadAllZip task.getStatus:" + parambihu.a());
    }
    if (3 == parambihu.a())
    {
      if (this.jdField_a_of_type_JavaIoFile.exists()) {
        try
        {
          parambihu = bjtz.a(this.jdField_a_of_type_JavaIoFile.getAbsolutePath());
          if (QLog.isColorLevel()) {
            QLog.d("rscContent_CmShowRscUpdateHandler", 2, " downloadAllZip onDone dstMd5:" + parambihu + " result.mMd5:" + this.jdField_a_of_type_Amvi.d);
          }
          if (amvf.a(this.jdField_a_of_type_Amvi, parambihu))
          {
            if (amvf.a(this.jdField_a_of_type_Amvi))
            {
              nof.a(this.jdField_a_of_type_JavaIoFile, this.jdField_a_of_type_JavaIoFile.getParent() + File.separator);
              if (QLog.isColorLevel()) {
                QLog.d("rscContent_CmShowRscUpdateHandler", 2, "downloadAllZip unZipFile ok file path->" + this.jdField_a_of_type_JavaIoFile.getAbsolutePath());
              }
            }
            for (;;)
            {
              amvf.a(this.jdField_a_of_type_Amvf, this.jdField_a_of_type_Amvi.jdField_e_of_type_Int, this.jdField_a_of_type_Amvi);
              return;
              boolean bool = bhmi.d(this.jdField_a_of_type_JavaIoFile.getAbsolutePath(), this.jdField_a_of_type_Amvi.b() + this.jdField_a_of_type_Amvi.jdField_e_of_type_JavaLangString);
              QLog.i("rscContent_CmShowRscUpdateHandler", 1, "downloadAllZip no need unzip copy:" + bool);
            }
          }
          QLog.d("rscContent_CmShowRscUpdateHandler", 1, "downloadAllZip  file error path- no exist:" + this.jdField_a_of_type_JavaIoFile.getAbsolutePath());
        }
        catch (Exception parambihu)
        {
          amvf.a(this.jdField_a_of_type_Amvf, this.jdField_a_of_type_Amvi.jdField_e_of_type_Int);
          this.jdField_a_of_type_JavaIoFile.delete();
          QLog.d("rscContent_CmShowRscUpdateHandler", 2, "downloadAllZip unZipFile file error path->" + this.jdField_a_of_type_JavaIoFile.getAbsolutePath() + parambihu.getMessage());
          return;
          QLog.e("rscContent_CmShowRscUpdateHandler", 1, "dstMd5 != result.mMd5");
          amvf.a(this.jdField_a_of_type_Amvf, this.jdField_a_of_type_Amvi.jdField_e_of_type_Int);
          return;
        }
        catch (OutOfMemoryError parambihu)
        {
          if (QLog.isColorLevel()) {
            QLog.d("rscContent_CmShowRscUpdateHandler", 2, "downloadAllZip unZipFile file error path->" + this.jdField_a_of_type_JavaIoFile.getAbsolutePath() + parambihu.getMessage());
          }
          this.jdField_a_of_type_JavaIoFile.delete();
          return;
        }
      }
      amvf.a(this.jdField_a_of_type_Amvf, this.jdField_a_of_type_Amvi.jdField_e_of_type_Int);
      return;
    }
    QLog.d("rscContent_CmShowRscUpdateHandler", 1, "downloadAllZip  file error path->" + this.jdField_a_of_type_JavaIoFile.getAbsolutePath() + " task.getStatus()->" + parambihu.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amvh
 * JD-Core Version:    0.7.0.1
 */