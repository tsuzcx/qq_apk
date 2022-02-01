import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class bchk
  implements bdvw
{
  bchk(bchj parambchj, String paramString, DownloadInfo paramDownloadInfo, int paramInt1, int paramInt2) {}
  
  public void onResp(bdwt parambdwt)
  {
    bdvs localbdvs = (bdvs)parambdwt.jdField_a_of_type_Bdws;
    if (this.jdField_a_of_type_Bchj.jdField_a_of_type_Bdvs == localbdvs) {
      this.jdField_a_of_type_Bchj.jdField_a_of_type_Bdvs = null;
    }
    if (QLog.isColorLevel()) {
      QLog.i("QavGesture", 2, String.format("onResp, Url[%s], mResult[%s], mHttpCode[%s], md5[%s]", new Object[] { localbdvs.jdField_a_of_type_JavaLangString, Integer.valueOf(parambdwt.jdField_a_of_type_Int), Integer.valueOf(parambdwt.c), this.jdField_a_of_type_JavaLangString }));
    }
    int i;
    if (parambdwt.jdField_a_of_type_Int == 0)
    {
      parambdwt = new File(localbdvs.c);
      if (parambdwt.exists())
      {
        try
        {
          String str = parambdwt.getParent();
          bgmg.a(localbdvs.c, str, false);
          bchi.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoGestureDownloadInfo, this.jdField_a_of_type_Int);
          i = 1;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            localException.printStackTrace();
            i = 0;
          }
          bchi.a(-1);
          this.jdField_a_of_type_Bchj.jdField_a_of_type_Boolean = false;
          return;
        }
        parambdwt.delete();
      }
    }
    for (;;)
    {
      if (i != 0)
      {
        bchi.a(100 / this.jdField_a_of_type_Bchj.jdField_a_of_type_Int + this.jdField_a_of_type_Bchj.b);
        parambdwt = this.jdField_a_of_type_Bchj;
        parambdwt.b += 100 / this.jdField_a_of_type_Bchj.jdField_a_of_type_Int;
        if (!this.jdField_a_of_type_Bchj.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoGestureDownloadInfo, this.b - 1)) {
          this.jdField_a_of_type_Bchj.jdField_a_of_type_Boolean = false;
        }
        return;
      }
      i = 0;
    }
  }
  
  public void onUpdateProgeress(bdws parambdws, long paramLong1, long paramLong2)
  {
    int i;
    if (paramLong2 == 0L) {
      i = 0;
    }
    for (;;)
    {
      bchi.a(i / this.jdField_a_of_type_Bchj.jdField_a_of_type_Int + this.jdField_a_of_type_Bchj.b);
      return;
      if (paramLong1 >= paramLong2) {
        i = 99;
      } else {
        i = (int)((float)paramLong1 * 100.0F / (float)paramLong2);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bchk
 * JD-Core Version:    0.7.0.1
 */