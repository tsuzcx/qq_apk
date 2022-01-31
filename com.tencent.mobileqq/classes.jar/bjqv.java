import android.text.TextUtils;
import cooperation.qzone.remote.IActionListener.Stub;
import cooperation.qzone.remote.RecvMsg;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

class bjqv
  extends IActionListener.Stub
{
  bjqv(bjqu parambjqu) {}
  
  public void onRecvFromMsg(RecvMsg paramRecvMsg)
  {
    if (paramRecvMsg == null) {}
    for (;;)
    {
      return;
      if ((!TextUtils.isEmpty(paramRecvMsg.getServiceCmd())) && (bjqu.a(this.a) != null))
      {
        Iterator localIterator = bjqu.a(this.a).iterator();
        while (localIterator.hasNext())
        {
          Object localObject = (WeakReference)localIterator.next();
          if (localObject != null)
          {
            localObject = (bjqx)((WeakReference)localObject).get();
            if (localObject != null) {
              ((bjqx)localObject).onWebEvent(paramRecvMsg.getServiceCmd(), paramRecvMsg.extraData);
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bjqv
 * JD-Core Version:    0.7.0.1
 */