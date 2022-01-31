import android.os.Message;
import com.tencent.qphone.base.util.QLog;
import com.tencent.weiyun.transmission.upload.UploadJobContext.StatusInfo;
import com.tencent.weiyun.transmission.upload.UploadManager.IUploadStatusListener;
import mqq.os.MqqHandler;
import mqq.util.WeakReference;

final class arpa
  implements UploadManager.IUploadStatusListener
{
  private final String jdField_a_of_type_JavaLangString;
  private final WeakReference<arox> jdField_a_of_type_MqqUtilWeakReference;
  
  private arpa(arox paramarox, String paramString)
  {
    if (paramarox == null) {}
    for (paramarox = null;; paramarox = new WeakReference(paramarox))
    {
      this.jdField_a_of_type_MqqUtilWeakReference = paramarox;
      this.jdField_a_of_type_JavaLangString = paramString;
      return;
    }
  }
  
  public void onUploadJobAdded(String paramString, long paramLong) {}
  
  public void onUploadStatusChanged(String paramString, long paramLong, UploadJobContext.StatusInfo paramStatusInfo, boolean paramBoolean)
  {
    arox localarox;
    if (this.jdField_a_of_type_MqqUtilWeakReference == null)
    {
      localarox = null;
      if ((localarox != null) && (!arox.a(localarox))) {
        break label39;
      }
    }
    label39:
    while (arox.a(localarox) == null)
    {
      return;
      localarox = (arox)this.jdField_a_of_type_MqqUtilWeakReference.get();
      break;
    }
    if (paramBoolean)
    {
      switch (paramStatusInfo.state)
      {
      default: 
        label80:
        paramString = null;
      }
      while (paramString != null)
      {
        arox.a(localarox).sendMessage(paramString);
        return;
        if (paramStatusInfo.errorCode == 1810002)
        {
          if (!QLog.isColorLevel()) {
            break label80;
          }
          QLog.i("WeiyunShareProcessController<FileAssistant>", 2, "upload is canceled, for file:" + this.jdField_a_of_type_JavaLangString);
          paramString = null;
          continue;
        }
        paramString = new Message();
        paramString.what = 3;
        paramString.obj = new Object[] { Integer.valueOf(paramStatusInfo.errorCode), paramStatusInfo.errorMsg };
        continue;
        paramString = new Message();
        paramString.what = 2;
        paramString.obj = new Object[] { paramStatusInfo, this.jdField_a_of_type_JavaLangString };
      }
    }
    if (paramStatusInfo.totalSize <= 0L) {}
    for (float f = 0.0F;; f = (float)paramStatusInfo.currSize / (float)paramStatusInfo.totalSize)
    {
      paramString = new Message();
      paramString.what = 4;
      paramString.obj = new Object[] { Float.valueOf(f) };
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arpa
 * JD-Core Version:    0.7.0.1
 */