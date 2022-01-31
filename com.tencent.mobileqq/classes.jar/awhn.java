import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class awhn
  implements axrt
{
  awhn(awhm paramawhm, String paramString, DownloadInfo paramDownloadInfo, int paramInt1, int paramInt2) {}
  
  public void onResp(axsq paramaxsq)
  {
    axro localaxro = (axro)paramaxsq.jdField_a_of_type_Axsp;
    if (this.jdField_a_of_type_Awhm.jdField_a_of_type_Axro == localaxro) {
      this.jdField_a_of_type_Awhm.jdField_a_of_type_Axro = null;
    }
    if (QLog.isColorLevel()) {
      QLog.i("QavGesture", 2, String.format("onResp, Url[%s], mResult[%s], mHttpCode[%s], md5[%s]", new Object[] { localaxro.jdField_a_of_type_JavaLangString, Integer.valueOf(paramaxsq.jdField_a_of_type_Int), Integer.valueOf(paramaxsq.c), this.jdField_a_of_type_JavaLangString }));
    }
    int i;
    if (paramaxsq.jdField_a_of_type_Int == 0)
    {
      paramaxsq = new File(localaxro.c);
      if (paramaxsq.exists())
      {
        try
        {
          String str = paramaxsq.getParent();
          bace.a(localaxro.c, str, false);
          awhl.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoGestureDownloadInfo, this.jdField_a_of_type_Int);
          i = 1;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            localException.printStackTrace();
            i = 0;
          }
          awhl.a(-1);
          this.jdField_a_of_type_Awhm.jdField_a_of_type_Boolean = false;
          return;
        }
        paramaxsq.delete();
      }
    }
    for (;;)
    {
      if (i != 0)
      {
        awhl.a(100 / this.jdField_a_of_type_Awhm.jdField_a_of_type_Int + this.jdField_a_of_type_Awhm.b);
        paramaxsq = this.jdField_a_of_type_Awhm;
        paramaxsq.b += 100 / this.jdField_a_of_type_Awhm.jdField_a_of_type_Int;
        if (!this.jdField_a_of_type_Awhm.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoGestureDownloadInfo, this.b - 1)) {
          this.jdField_a_of_type_Awhm.jdField_a_of_type_Boolean = false;
        }
        return;
      }
      i = 0;
    }
  }
  
  public void onUpdateProgeress(axsp paramaxsp, long paramLong1, long paramLong2)
  {
    int i;
    if (paramLong2 == 0L) {
      i = 0;
    }
    for (;;)
    {
      awhl.a(i / this.jdField_a_of_type_Awhm.jdField_a_of_type_Int + this.jdField_a_of_type_Awhm.b);
      return;
      if (paramLong1 >= paramLong2) {
        i = 99;
      } else {
        i = (int)((float)paramLong1 * 100.0F / (float)paramLong2);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     awhn
 * JD-Core Version:    0.7.0.1
 */