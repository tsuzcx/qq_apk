import com.tencent.mobileqq.transfile.INetEngine.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.text.DynamicTextConfigManager;
import dov.com.qq.im.capture.text.DynamicTextConfigManager.DynamicTextConfigBean.DynamicTextFontInfo;
import dov.com.qq.im.capture.text.DynamicTextConfigManager.DynamicTextResDownloader;
import dov.com.qq.im.capture.text.DynamicTextConfigManager.IDynamicTextResDownloadCallback;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import mqq.util.WeakReference;

public class anwh
  implements INetEngine.INetEngineListener
{
  public anwh(DynamicTextConfigManager.DynamicTextResDownloader paramDynamicTextResDownloader) {}
  
  public void a(NetReq arg1, long paramLong1, long paramLong2)
  {
    DynamicTextConfigManager.DynamicTextConfigBean.DynamicTextFontInfo localDynamicTextFontInfo = (DynamicTextConfigManager.DynamicTextConfigBean.DynamicTextFontInfo)???.a();
    synchronized (DynamicTextConfigManager.DynamicTextResDownloader.a(this.a))
    {
      Iterator localIterator = ((ArrayList)DynamicTextConfigManager.DynamicTextResDownloader.a(this.a).get(localDynamicTextFontInfo.jdField_a_of_type_JavaLangString)).iterator();
      while (localIterator.hasNext())
      {
        WeakReference localWeakReference = (WeakReference)localIterator.next();
        if (localWeakReference.get() != null) {
          ((DynamicTextConfigManager.IDynamicTextResDownloadCallback)localWeakReference.get()).a((float)(100L * paramLong1 / paramLong2), localDynamicTextFontInfo.jdField_a_of_type_JavaLangString, localDynamicTextFontInfo.jdField_a_of_type_Int);
        }
      }
    }
    float f = (float)paramLong1 * 100.0F / (float)paramLong2;
    localObject.b = ((int)f);
    if (QLog.isColorLevel()) {
      QLog.i("DText", 2, "onResDownloadProgressUpdate url: " + localObject.jdField_a_of_type_JavaLangString + " progress: " + f + " curOffset: " + paramLong1 + " totalLen: " + paramLong2);
    }
  }
  
  public void a(NetResp arg1)
  {
    DynamicTextConfigManager.DynamicTextConfigBean.DynamicTextFontInfo localDynamicTextFontInfo = (DynamicTextConfigManager.DynamicTextConfigBean.DynamicTextFontInfo)???.a.a();
    if (QLog.isColorLevel()) {
      QLog.i("DText", 2, "onResp, url is: " + localDynamicTextFontInfo.jdField_a_of_type_JavaLangString + " http status: " + ???.c);
    }
    DynamicTextConfigManager.DynamicTextResDownloader.a(this.a, localDynamicTextFontInfo);
    if ((DynamicTextConfigManager.DynamicTextResDownloader.a(this.a).b(localDynamicTextFontInfo)) && (DynamicTextConfigManager.DynamicTextResDownloader.a(this.a).a(localDynamicTextFontInfo))) {}
    for (boolean bool = true;; bool = false) {
      for (;;)
      {
        int i;
        synchronized (DynamicTextConfigManager.DynamicTextResDownloader.a(this.a))
        {
          ArrayList localArrayList = (ArrayList)DynamicTextConfigManager.DynamicTextResDownloader.a(this.a).remove(localDynamicTextFontInfo.jdField_a_of_type_JavaLangString);
          i = localArrayList.size() - 1;
          if (i >= 0)
          {
            WeakReference localWeakReference = (WeakReference)localArrayList.get(i);
            if (localWeakReference.get() != null) {
              ((DynamicTextConfigManager.IDynamicTextResDownloadCallback)localWeakReference.get()).a(bool, localDynamicTextFontInfo.jdField_a_of_type_JavaLangString);
            }
          }
          else
          {
            return;
          }
        }
        i -= 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     anwh
 * JD-Core Version:    0.7.0.1
 */