import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.transfile.INetEngine.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.InfomationFacePackage.Item;
import java.lang.ref.WeakReference;
import mqq.os.MqqHandler;

class anko
  implements INetEngine.INetEngineListener
{
  anko(ankn paramankn, WeakReference paramWeakReference1, WeakReference paramWeakReference2, String paramString, ankr paramankr) {}
  
  public void a(NetReq paramNetReq, long paramLong1, long paramLong2)
  {
    int i = (int)(100L * paramLong1 / paramLong2);
    if (QLog.isColorLevel()) {
      QLog.d("InformationFaceAdapter", 2, "apng percent:" + i);
    }
    ThreadManager.getUIHandler().post(new ankq(this, i));
  }
  
  public void a(NetResp paramNetResp)
  {
    String str = ((InfomationFacePackage.Item)paramNetResp.a.a()).d;
    if (QLog.isColorLevel()) {
      QLog.d("InformationFaceAdapter", 2, "onResp ,url is :" + str + " http status:" + paramNetResp.c);
    }
    if (paramNetResp.c == 200) {}
    for (boolean bool = true;; bool = false)
    {
      ThreadManager.getUIHandler().post(new ankp(this, bool));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     anko
 * JD-Core Version:    0.7.0.1
 */