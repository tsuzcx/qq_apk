import com.tencent.qphone.base.util.QLog;
import java.io.File;

class amjn
  extends bhhe
{
  amjn(amjl paramamjl, File paramFile, amjo paramamjo) {}
  
  public void onDone(bhhf parambhhf)
  {
    super.onDone(parambhhf);
    if (QLog.isColorLevel()) {
      QLog.d("rscContent_CmShowRscUpdateHandler", 2, "downloadAllZip task.getStatus:" + parambhhf.a());
    }
    if (3 == parambhhf.a())
    {
      if (this.jdField_a_of_type_JavaIoFile.exists()) {
        try
        {
          parambhhf = bita.a(this.jdField_a_of_type_JavaIoFile.getAbsolutePath());
          if (QLog.isColorLevel()) {
            QLog.d("rscContent_CmShowRscUpdateHandler", 2, " downloadAllZip onDone dstMd5:" + parambhhf + " result.mMd5:" + this.jdField_a_of_type_Amjo.d);
          }
          if (amjl.a(this.jdField_a_of_type_Amjo, parambhhf))
          {
            if (amjl.a(this.jdField_a_of_type_Amjo))
            {
              nmk.a(this.jdField_a_of_type_JavaIoFile, this.jdField_a_of_type_JavaIoFile.getParent() + File.separator);
              if (QLog.isColorLevel()) {
                QLog.d("rscContent_CmShowRscUpdateHandler", 2, "downloadAllZip unZipFile ok file path->" + this.jdField_a_of_type_JavaIoFile.getAbsolutePath());
              }
            }
            for (;;)
            {
              amjl.a(this.jdField_a_of_type_Amjl, this.jdField_a_of_type_Amjo.jdField_e_of_type_Int, this.jdField_a_of_type_Amjo);
              return;
              boolean bool = bgmg.d(this.jdField_a_of_type_JavaIoFile.getAbsolutePath(), this.jdField_a_of_type_Amjo.b() + this.jdField_a_of_type_Amjo.jdField_e_of_type_JavaLangString);
              QLog.i("rscContent_CmShowRscUpdateHandler", 1, "downloadAllZip no need unzip copy:" + bool);
            }
          }
          QLog.d("rscContent_CmShowRscUpdateHandler", 1, "downloadAllZip  file error path- no exist:" + this.jdField_a_of_type_JavaIoFile.getAbsolutePath());
        }
        catch (Exception parambhhf)
        {
          amjl.a(this.jdField_a_of_type_Amjl, this.jdField_a_of_type_Amjo.jdField_e_of_type_Int);
          this.jdField_a_of_type_JavaIoFile.delete();
          QLog.d("rscContent_CmShowRscUpdateHandler", 2, "downloadAllZip unZipFile file error path->" + this.jdField_a_of_type_JavaIoFile.getAbsolutePath() + parambhhf.getMessage());
          return;
          QLog.e("rscContent_CmShowRscUpdateHandler", 1, "dstMd5 != result.mMd5");
          amjl.a(this.jdField_a_of_type_Amjl, this.jdField_a_of_type_Amjo.jdField_e_of_type_Int);
          return;
        }
        catch (OutOfMemoryError parambhhf)
        {
          if (QLog.isColorLevel()) {
            QLog.d("rscContent_CmShowRscUpdateHandler", 2, "downloadAllZip unZipFile file error path->" + this.jdField_a_of_type_JavaIoFile.getAbsolutePath() + parambhhf.getMessage());
          }
          this.jdField_a_of_type_JavaIoFile.delete();
          return;
        }
      }
      amjl.a(this.jdField_a_of_type_Amjl, this.jdField_a_of_type_Amjo.jdField_e_of_type_Int);
      return;
    }
    QLog.d("rscContent_CmShowRscUpdateHandler", 1, "downloadAllZip  file error path->" + this.jdField_a_of_type_JavaIoFile.getAbsolutePath() + " task.getStatus()->" + parambhhf.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amjn
 * JD-Core Version:    0.7.0.1
 */