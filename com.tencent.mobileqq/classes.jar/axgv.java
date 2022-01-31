import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class axgv
  implements aysc
{
  axgv(axgu paramaxgu, String paramString, DownloadInfo paramDownloadInfo, int paramInt1, int paramInt2) {}
  
  public void onResp(aysz paramaysz)
  {
    ayrx localayrx = (ayrx)paramaysz.jdField_a_of_type_Aysy;
    if (this.jdField_a_of_type_Axgu.jdField_a_of_type_Ayrx == localayrx) {
      this.jdField_a_of_type_Axgu.jdField_a_of_type_Ayrx = null;
    }
    if (QLog.isColorLevel()) {
      QLog.i("QavGesture", 2, String.format("onResp, Url[%s], mResult[%s], mHttpCode[%s], md5[%s]", new Object[] { localayrx.jdField_a_of_type_JavaLangString, Integer.valueOf(paramaysz.jdField_a_of_type_Int), Integer.valueOf(paramaysz.c), this.jdField_a_of_type_JavaLangString }));
    }
    int i;
    if (paramaysz.jdField_a_of_type_Int == 0)
    {
      paramaysz = new File(localayrx.c);
      if (paramaysz.exists())
      {
        try
        {
          String str = paramaysz.getParent();
          bbdx.a(localayrx.c, str, false);
          axgt.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoGestureDownloadInfo, this.jdField_a_of_type_Int);
          i = 1;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            localException.printStackTrace();
            i = 0;
          }
          axgt.a(-1);
          this.jdField_a_of_type_Axgu.jdField_a_of_type_Boolean = false;
          return;
        }
        paramaysz.delete();
      }
    }
    for (;;)
    {
      if (i != 0)
      {
        axgt.a(100 / this.jdField_a_of_type_Axgu.jdField_a_of_type_Int + this.jdField_a_of_type_Axgu.b);
        paramaysz = this.jdField_a_of_type_Axgu;
        paramaysz.b += 100 / this.jdField_a_of_type_Axgu.jdField_a_of_type_Int;
        if (!this.jdField_a_of_type_Axgu.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoGestureDownloadInfo, this.b - 1)) {
          this.jdField_a_of_type_Axgu.jdField_a_of_type_Boolean = false;
        }
        return;
      }
      i = 0;
    }
  }
  
  public void onUpdateProgeress(aysy paramaysy, long paramLong1, long paramLong2)
  {
    int i;
    if (paramLong2 == 0L) {
      i = 0;
    }
    for (;;)
    {
      axgt.a(i / this.jdField_a_of_type_Axgu.jdField_a_of_type_Int + this.jdField_a_of_type_Axgu.b);
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
 * Qualified Name:     axgv
 * JD-Core Version:    0.7.0.1
 */