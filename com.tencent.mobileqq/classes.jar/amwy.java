import com.tencent.mobileqq.transfile.INetEngine.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.paster.QIMInformationPasterManager;
import dov.com.qq.im.capture.paster.QIMInformationPasterManager.IInformationPasterResDownloaderCallback;
import dov.com.qq.im.capture.paster.QIMInformationPasterManager.InformationPasterResDownloader;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.InfomationFacePackage.Item;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import mqq.util.WeakReference;

public class amwy
  implements INetEngine.INetEngineListener
{
  public amwy(QIMInformationPasterManager.InformationPasterResDownloader paramInformationPasterResDownloader) {}
  
  public void a(NetReq arg1, long paramLong1, long paramLong2)
  {
    String str = ((InfomationFacePackage.Item)???.a()).d;
    float f = (float)(100L * paramLong1 / paramLong2);
    synchronized (QIMInformationPasterManager.InformationPasterResDownloader.a(this.a))
    {
      Iterator localIterator = ((ArrayList)QIMInformationPasterManager.InformationPasterResDownloader.a(this.a).get(str)).iterator();
      while (localIterator.hasNext())
      {
        WeakReference localWeakReference = (WeakReference)localIterator.next();
        if (localWeakReference.get() != null) {
          ((QIMInformationPasterManager.IInformationPasterResDownloaderCallback)localWeakReference.get()).a(f, str, 0);
        }
      }
    }
  }
  
  public void a(NetResp paramNetResp)
  {
    InfomationFacePackage.Item localItem = (InfomationFacePackage.Item)paramNetResp.a.a();
    String str = localItem.d;
    if (QLog.isColorLevel()) {
      QLog.d("QIMInformationPasterManager", 2, "onResp ,url is :" + str + " http status:" + paramNetResp.c);
    }
    if ((paramNetResp.c == 200) && (QIMInformationPasterManager.InformationPasterResDownloader.a(this.a).b(localItem))) {}
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QIMInformationPasterManager", 2, "onResp ,isSucess:" + bool);
      }
      paramNetResp = ((ArrayList)QIMInformationPasterManager.InformationPasterResDownloader.a(this.a).get(str)).iterator();
      while (paramNetResp.hasNext())
      {
        WeakReference localWeakReference = (WeakReference)paramNetResp.next();
        if (localWeakReference.get() != null) {
          ((QIMInformationPasterManager.IInformationPasterResDownloaderCallback)localWeakReference.get()).a(bool, str, localItem);
        }
      }
    }
    QIMInformationPasterManager.InformationPasterResDownloader.a(this.a).remove(str);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     amwy
 * JD-Core Version:    0.7.0.1
 */