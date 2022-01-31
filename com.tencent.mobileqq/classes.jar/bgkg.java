import com.tencent.qphone.base.util.QLog;
import java.io.File;

class bgkg
  implements aysc
{
  bgkg(bgkf parambgkf, String paramString, bgkd parambgkd) {}
  
  public void onResp(aysz paramaysz)
  {
    ayrx localayrx = (ayrx)paramaysz.jdField_a_of_type_Aysy;
    if (this.jdField_a_of_type_Bgkf.jdField_a_of_type_Ayrx == localayrx) {
      this.jdField_a_of_type_Bgkf.jdField_a_of_type_Ayrx = null;
    }
    if (QLog.isColorLevel()) {
      QLog.i("TMG_Downloader", 2, String.format("onResp, Url[%s], mResult[%s], mHttpCode[%s], md5[%s]", new Object[] { localayrx.jdField_a_of_type_JavaLangString, Integer.valueOf(paramaysz.jdField_a_of_type_Int), Integer.valueOf(paramaysz.c), this.jdField_a_of_type_JavaLangString }));
    }
    if (paramaysz.jdField_a_of_type_Int == 0)
    {
      paramaysz = new File(localayrx.c);
      if (!paramaysz.exists()) {}
    }
    do
    {
      for (;;)
      {
        try
        {
          paramaysz = paramaysz.getParent();
          bbdx.a(localayrx.c, paramaysz, false);
          bgke.a(this.jdField_a_of_type_Bgkd.b);
          i = 1;
          if (i == 0) {
            break;
          }
          if (this.jdField_a_of_type_Bgkf.jdField_a_of_type_Bgkh != null)
          {
            this.jdField_a_of_type_Bgkf.jdField_a_of_type_Bgkh.a(100);
            this.jdField_a_of_type_Bgkf.jdField_a_of_type_Bgkh.a(0, "Download Complete!!!");
          }
          this.jdField_a_of_type_Bgkf.jdField_a_of_type_Boolean = false;
          return;
        }
        catch (Exception paramaysz)
        {
          paramaysz.printStackTrace();
        }
        int i = 0;
      }
    } while (this.jdField_a_of_type_Bgkf.jdField_a_of_type_Bgkh == null);
    this.jdField_a_of_type_Bgkf.jdField_a_of_type_Bgkh.a(2, "");
  }
  
  public void onUpdateProgeress(aysy paramaysy, long paramLong1, long paramLong2)
  {
    int i;
    if (paramLong2 == 0L) {
      i = 0;
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Bgkf.jdField_a_of_type_Bgkh != null) {
        this.jdField_a_of_type_Bgkf.jdField_a_of_type_Bgkh.a(i);
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
 * Qualified Name:     bgkg
 * JD-Core Version:    0.7.0.1
 */