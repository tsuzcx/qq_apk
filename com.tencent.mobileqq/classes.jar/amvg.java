import com.tencent.open.base.BspatchUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class amvg
  extends biht
{
  amvg(amvf paramamvf, File paramFile, amvi paramamvi) {}
  
  public void onDone(bihu parambihu)
  {
    super.onDone(parambihu);
    if (QLog.isColorLevel()) {
      QLog.d("rscContent_CmShowRscUpdateHandler", 2, "downloadZipAndPatch task.getStatus:" + parambihu.a());
    }
    if (3 == parambihu.a())
    {
      if (this.jdField_a_of_type_JavaIoFile.exists())
      {
        String str = this.jdField_a_of_type_Amvi.e();
        parambihu = this.jdField_a_of_type_Amvi.c();
        if (BspatchUtil.a(str, this.jdField_a_of_type_JavaIoFile.getAbsolutePath(), parambihu))
        {
          try
          {
            str = bjtz.a(parambihu);
            if (QLog.isColorLevel()) {
              QLog.d("rscContent_CmShowRscUpdateHandler", 2, " downloadZipAndPatch onDone dstMd5:" + str + " result.mMd5:" + this.jdField_a_of_type_Amvi.d);
            }
            if (amvf.a(this.jdField_a_of_type_Amvi, str))
            {
              if (amvf.a(this.jdField_a_of_type_Amvi))
              {
                nof.a(new File(parambihu), this.jdField_a_of_type_JavaIoFile.getParent() + File.separator);
                if (QLog.isColorLevel()) {
                  QLog.d("rscContent_CmShowRscUpdateHandler", 2, "downloadZipAndPatch unZipFile ok file path->" + this.jdField_a_of_type_JavaIoFile.getAbsolutePath() + " dstpath:" + parambihu);
                }
              }
              for (;;)
              {
                amvf.a(this.jdField_a_of_type_Amvf, this.jdField_a_of_type_Amvi.jdField_e_of_type_Int, this.jdField_a_of_type_Amvi);
                return;
                boolean bool = bhmi.d(parambihu, this.jdField_a_of_type_Amvi.b() + this.jdField_a_of_type_Amvi.jdField_e_of_type_JavaLangString);
                QLog.i("rscContent_CmShowRscUpdateHandler", 1, "downloadZipAndPatch no need unzip copy:" + bool);
              }
            }
            QLog.d("rscContent_CmShowRscUpdateHandler", 2, "downloadZipAndPatch unZipFile file error path->" + this.jdField_a_of_type_JavaIoFile.getAbsolutePath() + parambihu.getMessage());
          }
          catch (Exception parambihu)
          {
            this.jdField_a_of_type_JavaIoFile.delete();
            QLog.d("rscContent_CmShowRscUpdateHandler", 2, "downloadZipAndPatch unZipFile file error path->" + this.jdField_a_of_type_JavaIoFile.getAbsolutePath() + parambihu.getMessage());
            return;
            QLog.e("rscContent_CmShowRscUpdateHandler", 1, "dstMd5 != result.mMd5");
            amvf.a(this.jdField_a_of_type_Amvf, this.jdField_a_of_type_Amvi);
            return;
          }
          catch (OutOfMemoryError parambihu)
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
          amvf.a(this.jdField_a_of_type_Amvf, this.jdField_a_of_type_Amvi);
        }
      }
      else
      {
        amvf.a(this.jdField_a_of_type_Amvf, this.jdField_a_of_type_Amvi);
        QLog.d("rscContent_CmShowRscUpdateHandler", 1, "downloadZipAndPatch patchFile no exist path->" + this.jdField_a_of_type_JavaIoFile.getAbsolutePath() + " task.getStatus()->" + parambihu.a());
      }
    }
    else {
      QLog.d("rscContent_CmShowRscUpdateHandler", 1, "downloadZipAndPatch  file error path->" + this.jdField_a_of_type_JavaIoFile.getAbsolutePath() + " task.getStatus()->" + parambihu.a());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amvg
 * JD-Core Version:    0.7.0.1
 */