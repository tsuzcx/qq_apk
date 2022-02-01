import com.tencent.qphone.base.util.QLog;
import java.io.File;

class anat
  implements bdvw
{
  anat(anas paramanas, String paramString, anaq paramanaq) {}
  
  public void onResp(bdwt parambdwt)
  {
    bdvs localbdvs = (bdvs)parambdwt.jdField_a_of_type_Bdws;
    if (this.jdField_a_of_type_Anas.jdField_a_of_type_Bdvs == localbdvs) {
      this.jdField_a_of_type_Anas.jdField_a_of_type_Bdvs = null;
    }
    if (QLog.isColorLevel()) {
      QLog.i("TMG_Downloader", 2, String.format("onResp, Url[%s], mResult[%s], mHttpCode[%s], md5[%s]", new Object[] { localbdvs.jdField_a_of_type_JavaLangString, Integer.valueOf(parambdwt.jdField_a_of_type_Int), Integer.valueOf(parambdwt.c), this.jdField_a_of_type_JavaLangString }));
    }
    if (parambdwt.jdField_a_of_type_Int == 0)
    {
      parambdwt = new File(localbdvs.c);
      if (!parambdwt.exists()) {}
    }
    do
    {
      for (;;)
      {
        try
        {
          parambdwt = parambdwt.getParent();
          bgmg.a(localbdvs.c, parambdwt, false);
          anar.a(this.jdField_a_of_type_Anaq.b);
          i = 1;
          if (i == 0) {
            break;
          }
          if (this.jdField_a_of_type_Anas.jdField_a_of_type_Anau != null)
          {
            this.jdField_a_of_type_Anas.jdField_a_of_type_Anau.a(100);
            this.jdField_a_of_type_Anas.jdField_a_of_type_Anau.a(0, "Download Complete!!!");
          }
          this.jdField_a_of_type_Anas.jdField_a_of_type_Boolean = false;
          return;
        }
        catch (Exception parambdwt)
        {
          parambdwt.printStackTrace();
        }
        int i = 0;
      }
    } while (this.jdField_a_of_type_Anas.jdField_a_of_type_Anau == null);
    this.jdField_a_of_type_Anas.jdField_a_of_type_Anau.a(2, "");
  }
  
  public void onUpdateProgeress(bdws parambdws, long paramLong1, long paramLong2)
  {
    int i;
    if (paramLong2 == 0L) {
      i = 0;
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Anas.jdField_a_of_type_Anau != null) {
        this.jdField_a_of_type_Anas.jdField_a_of_type_Anau.a(i);
      }
      return;
      if (paramLong1 >= paramLong2) {
        i = 99;
      } else {
        i = (int)((float)paramLong1 * 100.0F / (float)paramLong2);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anat
 * JD-Core Version:    0.7.0.1
 */