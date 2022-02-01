import android.os.Message;
import com.tencent.qphone.base.util.QLog;
import com.tencent.weiyun.transmission.upload.UploadJobContext.StatusInfo;
import com.tencent.weiyun.transmission.upload.UploadManager.IUploadStatusListener;
import mqq.os.MqqHandler;
import mqq.util.WeakReference;

final class aukj
  implements UploadManager.IUploadStatusListener
{
  private final String jdField_a_of_type_JavaLangString;
  private final WeakReference<aukg> jdField_a_of_type_MqqUtilWeakReference;
  
  private aukj(aukg paramaukg, String paramString)
  {
    if (paramaukg == null) {}
    for (paramaukg = null;; paramaukg = new WeakReference(paramaukg))
    {
      this.jdField_a_of_type_MqqUtilWeakReference = paramaukg;
      this.jdField_a_of_type_JavaLangString = paramString;
      return;
    }
  }
  
  public void onUploadJobAdded(String paramString, long paramLong) {}
  
  public void onUploadStatusChanged(String paramString, long paramLong, UploadJobContext.StatusInfo paramStatusInfo, boolean paramBoolean)
  {
    aukg localaukg;
    if (this.jdField_a_of_type_MqqUtilWeakReference == null)
    {
      localaukg = null;
      if ((localaukg != null) && (!aukg.a(localaukg))) {
        break label39;
      }
    }
    label39:
    while (aukg.a(localaukg) == null)
    {
      return;
      localaukg = (aukg)this.jdField_a_of_type_MqqUtilWeakReference.get();
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
        aukg.a(localaukg).sendMessage(paramString);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aukj
 * JD-Core Version:    0.7.0.1
 */