import com.tencent.mobileqq.shortvideo.util.ShortVideoTrimmer.ProcessCallBack;
import com.tencent.qphone.base.util.QLog;

class bcyv
  implements ShortVideoTrimmer.ProcessCallBack
{
  bcyv(bcyt parambcyt) {}
  
  public void onDestroy()
  {
    this.a.a = null;
    if (QLog.isColorLevel()) {
      QLog.d("VideoCompressProcessor", 2, "CompressTask, step: ShortVideoTrimmer onDestroy!");
    }
  }
  
  public void onStart(Process paramProcess)
  {
    this.a.a = paramProcess;
    if (QLog.isColorLevel()) {
      QLog.d("VideoCompressProcessor", 2, "CompressTask, step: ShortVideoTrimmer Start!");
    }
  }
  
  public void onStop()
  {
    this.a.a = null;
    if (QLog.isColorLevel()) {
      QLog.d("VideoCompressProcessor", 2, "CompressTask, step: ShortVideoTrimmer onStop!");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcyv
 * JD-Core Version:    0.7.0.1
 */