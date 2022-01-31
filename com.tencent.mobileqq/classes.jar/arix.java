import com.tencent.intervideo.nowproxy.customized_interface.CustomizedLog;
import com.tencent.qphone.base.util.QLog;

class arix
  implements CustomizedLog
{
  arix(arik paramarik) {}
  
  public void onFlushLogs() {}
  
  public void onLog(int paramInt, String paramString1, String paramString2)
  {
    QLog.i(paramString1, 1, paramString2);
  }
  
  public void onUploadLogs() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     arix
 * JD-Core Version:    0.7.0.1
 */