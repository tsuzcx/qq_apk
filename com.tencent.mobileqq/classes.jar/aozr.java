import android.os.Message;
import com.tencent.qphone.base.util.QLog;
import com.tencent.weiyun.transmission.upload.UploadJobContext.StatusInfo;
import com.tencent.weiyun.transmission.upload.UploadManager.IUploadStatusListener;
import mqq.os.MqqHandler;
import mqq.util.WeakReference;

final class aozr
  implements UploadManager.IUploadStatusListener
{
  private final String jdField_a_of_type_JavaLangString;
  private final WeakReference<aozo> jdField_a_of_type_MqqUtilWeakReference;
  
  private aozr(aozo paramaozo, String paramString)
  {
    if (paramaozo == null) {}
    for (paramaozo = null;; paramaozo = new WeakReference(paramaozo))
    {
      this.jdField_a_of_type_MqqUtilWeakReference = paramaozo;
      this.jdField_a_of_type_JavaLangString = paramString;
      return;
    }
  }
  
  public void onUploadJobAdded(String paramString, long paramLong) {}
  
  public void onUploadStatusChanged(String paramString, long paramLong, UploadJobContext.StatusInfo paramStatusInfo, boolean paramBoolean)
  {
    aozo localaozo;
    if (this.jdField_a_of_type_MqqUtilWeakReference == null)
    {
      localaozo = null;
      if ((localaozo != null) && (!aozo.a(localaozo))) {
        break label39;
      }
    }
    label39:
    while (aozo.a(localaozo) == null)
    {
      return;
      localaozo = (aozo)this.jdField_a_of_type_MqqUtilWeakReference.get();
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
        aozo.a(localaozo).sendMessage(paramString);
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
 * Qualified Name:     aozr
 * JD-Core Version:    0.7.0.1
 */