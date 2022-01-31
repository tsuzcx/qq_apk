import android.os.Handler;
import com.tencent.qphone.base.util.QLog;

class ayvt
  implements axrt
{
  private int jdField_a_of_type_Int;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private boolean jdField_a_of_type_Boolean;
  
  ayvt(ayvs paramayvs, Handler paramHandler, int paramInt, boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidOsHandler = paramHandler;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void onResp(axsq paramaxsq)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BeginnerGuideDownloadManager", 2, "BeginnerGuideDownloadManager$DownloadListener onResp: " + paramaxsq.jdField_a_of_type_Int + ", desc: " + paramaxsq.jdField_a_of_type_JavaLangString);
    }
    if (paramaxsq.jdField_a_of_type_Int == 3) {
      return;
    }
    if (paramaxsq.jdField_a_of_type_Int == 0)
    {
      paramaxsq = ayvs.a(paramaxsq.jdField_a_of_type_Axsp.c);
      if (ayvs.a(this.jdField_a_of_type_Ayvs).equalsIgnoreCase(paramaxsq))
      {
        if (QLog.isColorLevel()) {
          QLog.d("BeginnerGuideDownloadManager", 2, "BeginnerGuideDownloadManager$DownloadListener download success");
        }
        ayvs.a(this.jdField_a_of_type_Ayvs, this.jdField_a_of_type_AndroidOsHandler, this.jdField_a_of_type_Int, this.jdField_a_of_type_Boolean);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("BeginnerGuideDownloadManager", 2, "BeginnerGuideDownloadManager$DownloadListener download success, md5 check failed");
      }
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1112);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("BeginnerGuideDownloadManager", 2, "BeginnerGuideDownloadManager$DownloadListener onResp error");
    }
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1113);
  }
  
  public void onUpdateProgeress(axsp paramaxsp, long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BeginnerGuideDownloadManager", 2, "BeginnerGuideDownloadManager$DownloadListener Dowloading " + paramLong1 + "/" + paramLong2 + " " + 100L * paramLong1 / paramLong2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     ayvt
 * JD-Core Version:    0.7.0.1
 */