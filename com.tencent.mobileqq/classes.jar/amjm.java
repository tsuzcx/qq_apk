import com.tencent.open.base.BspatchUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class amjm
  extends bhhe
{
  amjm(amjl paramamjl, File paramFile, amjo paramamjo) {}
  
  public void onDone(bhhf parambhhf)
  {
    super.onDone(parambhhf);
    if (QLog.isColorLevel()) {
      QLog.d("rscContent_CmShowRscUpdateHandler", 2, "downloadZipAndPatch task.getStatus:" + parambhhf.a());
    }
    if (3 == parambhhf.a())
    {
      if (this.jdField_a_of_type_JavaIoFile.exists())
      {
        String str = this.jdField_a_of_type_Amjo.e();
        parambhhf = this.jdField_a_of_type_Amjo.c();
        if (BspatchUtil.a(str, this.jdField_a_of_type_JavaIoFile.getAbsolutePath(), parambhhf))
        {
          try
          {
            str = bita.a(parambhhf);
            if (QLog.isColorLevel()) {
              QLog.d("rscContent_CmShowRscUpdateHandler", 2, " downloadZipAndPatch onDone dstMd5:" + str + " result.mMd5:" + this.jdField_a_of_type_Amjo.d);
            }
            if (amjl.a(this.jdField_a_of_type_Amjo, str))
            {
              if (amjl.a(this.jdField_a_of_type_Amjo))
              {
                nmk.a(new File(parambhhf), this.jdField_a_of_type_JavaIoFile.getParent() + File.separator);
                if (QLog.isColorLevel()) {
                  QLog.d("rscContent_CmShowRscUpdateHandler", 2, "downloadZipAndPatch unZipFile ok file path->" + this.jdField_a_of_type_JavaIoFile.getAbsolutePath() + " dstpath:" + parambhhf);
                }
              }
              for (;;)
              {
                amjl.a(this.jdField_a_of_type_Amjl, this.jdField_a_of_type_Amjo.jdField_e_of_type_Int, this.jdField_a_of_type_Amjo);
                return;
                boolean bool = bgmg.d(parambhhf, this.jdField_a_of_type_Amjo.b() + this.jdField_a_of_type_Amjo.jdField_e_of_type_JavaLangString);
                QLog.i("rscContent_CmShowRscUpdateHandler", 1, "downloadZipAndPatch no need unzip copy:" + bool);
              }
            }
            QLog.d("rscContent_CmShowRscUpdateHandler", 2, "downloadZipAndPatch unZipFile file error path->" + this.jdField_a_of_type_JavaIoFile.getAbsolutePath() + parambhhf.getMessage());
          }
          catch (Exception parambhhf)
          {
            this.jdField_a_of_type_JavaIoFile.delete();
            QLog.d("rscContent_CmShowRscUpdateHandler", 2, "downloadZipAndPatch unZipFile file error path->" + this.jdField_a_of_type_JavaIoFile.getAbsolutePath() + parambhhf.getMessage());
            return;
            QLog.e("rscContent_CmShowRscUpdateHandler", 1, "dstMd5 != result.mMd5");
            amjl.a(this.jdField_a_of_type_Amjl, this.jdField_a_of_type_Amjo);
            return;
          }
          catch (OutOfMemoryError parambhhf)
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
          amjl.a(this.jdField_a_of_type_Amjl, this.jdField_a_of_type_Amjo);
        }
      }
      else
      {
        amjl.a(this.jdField_a_of_type_Amjl, this.jdField_a_of_type_Amjo);
        QLog.d("rscContent_CmShowRscUpdateHandler", 1, "downloadZipAndPatch patchFile no exist path->" + this.jdField_a_of_type_JavaIoFile.getAbsolutePath() + " task.getStatus()->" + parambhhf.a());
      }
    }
    else {
      QLog.d("rscContent_CmShowRscUpdateHandler", 1, "downloadZipAndPatch  file error path->" + this.jdField_a_of_type_JavaIoFile.getAbsolutePath() + " task.getStatus()->" + parambhhf.a());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amjm
 * JD-Core Version:    0.7.0.1
 */