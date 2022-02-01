import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class bdac
  implements beuq
{
  bdac(bdab parambdab, String paramString, DownloadInfo paramDownloadInfo, int paramInt1, int paramInt2) {}
  
  public void onResp(bevm parambevm)
  {
    beum localbeum = (beum)parambevm.jdField_a_of_type_Bevl;
    if (this.jdField_a_of_type_Bdab.jdField_a_of_type_Beum == localbeum) {
      this.jdField_a_of_type_Bdab.jdField_a_of_type_Beum = null;
    }
    if (QLog.isColorLevel()) {
      QLog.i("QavGesture", 2, String.format("onResp, Url[%s], mResult[%s], mHttpCode[%s], md5[%s]", new Object[] { localbeum.jdField_a_of_type_JavaLangString, Integer.valueOf(parambevm.jdField_a_of_type_Int), Integer.valueOf(parambevm.c), this.jdField_a_of_type_JavaLangString }));
    }
    int i;
    if (parambevm.jdField_a_of_type_Int == 0)
    {
      parambevm = new File(localbeum.c);
      if (parambevm.exists())
      {
        try
        {
          String str = parambevm.getParent();
          bhmi.a(localbeum.c, str, false);
          bdaa.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoGestureDownloadInfo, this.jdField_a_of_type_Int);
          i = 1;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            localException.printStackTrace();
            i = 0;
          }
          bdaa.a(-1);
          this.jdField_a_of_type_Bdab.jdField_a_of_type_Boolean = false;
          return;
        }
        parambevm.delete();
      }
    }
    for (;;)
    {
      if (i != 0)
      {
        bdaa.a(100 / this.jdField_a_of_type_Bdab.jdField_a_of_type_Int + this.jdField_a_of_type_Bdab.b);
        parambevm = this.jdField_a_of_type_Bdab;
        parambevm.b += 100 / this.jdField_a_of_type_Bdab.jdField_a_of_type_Int;
        if (!this.jdField_a_of_type_Bdab.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoGestureDownloadInfo, this.b - 1)) {
          this.jdField_a_of_type_Bdab.jdField_a_of_type_Boolean = false;
        }
        return;
      }
      i = 0;
    }
  }
  
  public void onUpdateProgeress(bevl parambevl, long paramLong1, long paramLong2)
  {
    int i;
    if (paramLong2 == 0L) {
      i = 0;
    }
    for (;;)
    {
      bdaa.a(i / this.jdField_a_of_type_Bdab.jdField_a_of_type_Int + this.jdField_a_of_type_Bdab.b);
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
 * Qualified Name:     bdac
 * JD-Core Version:    0.7.0.1
 */