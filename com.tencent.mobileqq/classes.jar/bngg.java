import android.text.TextUtils;
import cooperation.qzone.remote.IActionListener.Stub;
import cooperation.qzone.remote.RecvMsg;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

class bngg
  extends IActionListener.Stub
{
  bngg(bngf parambngf) {}
  
  public void onRecvFromMsg(RecvMsg paramRecvMsg)
  {
    if (paramRecvMsg == null) {}
    for (;;)
    {
      return;
      if ((!TextUtils.isEmpty(paramRecvMsg.getServiceCmd())) && (bngf.a(this.a) != null))
      {
        Iterator localIterator = bngf.a(this.a).iterator();
        while (localIterator.hasNext())
        {
          Object localObject = (WeakReference)localIterator.next();
          if (localObject != null)
          {
            localObject = (bngj)((WeakReference)localObject).get();
            if (localObject != null) {
              ((bngj)localObject).onWebEvent(paramRecvMsg.getServiceCmd(), paramRecvMsg.extraData);
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bngg
 * JD-Core Version:    0.7.0.1
 */