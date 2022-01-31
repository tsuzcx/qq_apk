import android.text.TextUtils;
import cooperation.qzone.remote.IActionListener.Stub;
import cooperation.qzone.remote.RecvMsg;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

class bhkm
  extends IActionListener.Stub
{
  bhkm(bhkl parambhkl) {}
  
  public void onRecvFromMsg(RecvMsg paramRecvMsg)
  {
    if (paramRecvMsg == null) {}
    for (;;)
    {
      return;
      if ((!TextUtils.isEmpty(paramRecvMsg.getServiceCmd())) && (bhkl.a(this.a) != null))
      {
        Iterator localIterator = bhkl.a(this.a).iterator();
        while (localIterator.hasNext())
        {
          Object localObject = (WeakReference)localIterator.next();
          if (localObject != null)
          {
            localObject = (bhko)((WeakReference)localObject).get();
            if (localObject != null) {
              ((bhko)localObject).onWebEvent(paramRecvMsg.getServiceCmd(), paramRecvMsg.extraData);
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bhkm
 * JD-Core Version:    0.7.0.1
 */