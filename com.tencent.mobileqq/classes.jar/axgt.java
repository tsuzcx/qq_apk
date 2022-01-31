import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class axgt
  implements aysa
{
  axgt(axgs paramaxgs, String paramString, DownloadInfo paramDownloadInfo, int paramInt1, int paramInt2) {}
  
  public void onResp(aysx paramaysx)
  {
    ayrv localayrv = (ayrv)paramaysx.jdField_a_of_type_Aysw;
    if (this.jdField_a_of_type_Axgs.jdField_a_of_type_Ayrv == localayrv) {
      this.jdField_a_of_type_Axgs.jdField_a_of_type_Ayrv = null;
    }
    if (QLog.isColorLevel()) {
      QLog.i("QavGesture", 2, String.format("onResp, Url[%s], mResult[%s], mHttpCode[%s], md5[%s]", new Object[] { localayrv.jdField_a_of_type_JavaLangString, Integer.valueOf(paramaysx.jdField_a_of_type_Int), Integer.valueOf(paramaysx.c), this.jdField_a_of_type_JavaLangString }));
    }
    int i;
    if (paramaysx.jdField_a_of_type_Int == 0)
    {
      paramaysx = new File(localayrv.c);
      if (paramaysx.exists())
      {
        try
        {
          String str = paramaysx.getParent();
          bbdj.a(localayrv.c, str, false);
          axgr.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoGestureDownloadInfo, this.jdField_a_of_type_Int);
          i = 1;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            localException.printStackTrace();
            i = 0;
          }
          axgr.a(-1);
          this.jdField_a_of_type_Axgs.jdField_a_of_type_Boolean = false;
          return;
        }
        paramaysx.delete();
      }
    }
    for (;;)
    {
      if (i != 0)
      {
        axgr.a(100 / this.jdField_a_of_type_Axgs.jdField_a_of_type_Int + this.jdField_a_of_type_Axgs.b);
        paramaysx = this.jdField_a_of_type_Axgs;
        paramaysx.b += 100 / this.jdField_a_of_type_Axgs.jdField_a_of_type_Int;
        if (!this.jdField_a_of_type_Axgs.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoGestureDownloadInfo, this.b - 1)) {
          this.jdField_a_of_type_Axgs.jdField_a_of_type_Boolean = false;
        }
        return;
      }
      i = 0;
    }
  }
  
  public void onUpdateProgeress(aysw paramaysw, long paramLong1, long paramLong2)
  {
    int i;
    if (paramLong2 == 0L) {
      i = 0;
    }
    for (;;)
    {
      axgr.a(i / this.jdField_a_of_type_Axgs.jdField_a_of_type_Int + this.jdField_a_of_type_Axgs.b);
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
 * Qualified Name:     axgt
 * JD-Core Version:    0.7.0.1
 */