import com.tencent.qphone.base.util.QLog;
import java.io.File;

class anmn
  implements beuq
{
  anmn(anmm paramanmm, String paramString, anmk paramanmk) {}
  
  public void onResp(bevm parambevm)
  {
    beum localbeum = (beum)parambevm.jdField_a_of_type_Bevl;
    if (this.jdField_a_of_type_Anmm.jdField_a_of_type_Beum == localbeum) {
      this.jdField_a_of_type_Anmm.jdField_a_of_type_Beum = null;
    }
    if (QLog.isColorLevel()) {
      QLog.i("TMG_Downloader", 2, String.format("onResp, Url[%s], mResult[%s], mHttpCode[%s], md5[%s]", new Object[] { localbeum.jdField_a_of_type_JavaLangString, Integer.valueOf(parambevm.jdField_a_of_type_Int), Integer.valueOf(parambevm.c), this.jdField_a_of_type_JavaLangString }));
    }
    if (parambevm.jdField_a_of_type_Int == 0)
    {
      parambevm = new File(localbeum.c);
      if (!parambevm.exists()) {}
    }
    do
    {
      for (;;)
      {
        try
        {
          parambevm = parambevm.getParent();
          bhmi.a(localbeum.c, parambevm, false);
          anml.a(this.jdField_a_of_type_Anmk.b);
          i = 1;
          if (i == 0) {
            break;
          }
          if (this.jdField_a_of_type_Anmm.jdField_a_of_type_Anmo != null)
          {
            this.jdField_a_of_type_Anmm.jdField_a_of_type_Anmo.a(100);
            this.jdField_a_of_type_Anmm.jdField_a_of_type_Anmo.a(0, "Download Complete!!!");
          }
          this.jdField_a_of_type_Anmm.jdField_a_of_type_Boolean = false;
          return;
        }
        catch (Exception parambevm)
        {
          parambevm.printStackTrace();
        }
        int i = 0;
      }
    } while (this.jdField_a_of_type_Anmm.jdField_a_of_type_Anmo == null);
    this.jdField_a_of_type_Anmm.jdField_a_of_type_Anmo.a(2, "");
  }
  
  public void onUpdateProgeress(bevl parambevl, long paramLong1, long paramLong2)
  {
    int i;
    if (paramLong2 == 0L) {
      i = 0;
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Anmm.jdField_a_of_type_Anmo != null) {
        this.jdField_a_of_type_Anmm.jdField_a_of_type_Anmo.a(i);
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
 * Qualified Name:     anmn
 * JD-Core Version:    0.7.0.1
 */