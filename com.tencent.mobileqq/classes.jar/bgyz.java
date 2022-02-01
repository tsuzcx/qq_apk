import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.os.SystemClock;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Locale;

public class bgyz
  implements Handler.Callback
{
  private long jdField_a_of_type_Long;
  private final Handler jdField_a_of_type_AndroidOsHandler;
  private final bgza jdField_a_of_type_Bgza;
  private final LinkedList<bgzb> jdField_a_of_type_JavaUtilLinkedList;
  private final LinkedList<bgzb> b;
  
  public bgyz(bgza parambgza)
  {
    this.jdField_a_of_type_Bgza = parambgza;
    this.jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
    this.b = new LinkedList();
    this.jdField_a_of_type_AndroidOsHandler = new bkys(ThreadManager.getSubThreadLooper(), this);
    this.jdField_a_of_type_Long = 0L;
  }
  
  private void a(bgzb parambgzb)
  {
    if (!parambgzb.a()) {
      if (QLog.isColorLevel()) {
        QLog.d("FetchInfoListManager", 2, StringUtil.makeLogMsg(new Object[] { "addToNeedFetchInfoListInner() ", parambgzb.toString(), "非法请求" }));
      }
    }
    do
    {
      do
      {
        return;
        if ((!this.jdField_a_of_type_JavaUtilLinkedList.contains(parambgzb)) && (!this.b.contains(parambgzb))) {
          break;
        }
      } while (!QLog.isDevelopLevel());
      QLog.d("FetchInfoListManager", 4, StringUtil.makeLogMsg(new Object[] { "addToNeedFetchInfoListInner()", parambgzb.toString(), "已经在队列中了" }));
      return;
      if (QLog.isDevelopLevel()) {
        QLog.d("FetchInfoListManager", 4, StringUtil.makeLogMsg(new Object[] { "addToNeedFetchInfoListInner()", parambgzb.toString() }));
      }
      this.jdField_a_of_type_JavaUtilLinkedList.addFirst(parambgzb);
    } while (this.jdField_a_of_type_AndroidOsHandler.hasMessages(1));
    long l = SystemClock.elapsedRealtime() - this.jdField_a_of_type_Long;
    if ((l < 0L) || (l > 2000L))
    {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, 300L);
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_JavaUtilLinkedList.isEmpty()) {
      if (QLog.isDevelopLevel()) {
        QLog.d("FetchInfoListManager", 4, "doFetchInfo fetch list is empty!");
      }
    }
    for (;;)
    {
      return;
      bgzb localbgzb;
      do
      {
        localbgzb = (bgzb)this.jdField_a_of_type_JavaUtilLinkedList.removeFirst();
      } while ((localbgzb == null) && (!this.jdField_a_of_type_JavaUtilLinkedList.isEmpty()));
      if (localbgzb == null)
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("FetchInfoListManager", 4, "doFetchInfo req is null !");
        }
      }
      else
      {
        this.jdField_a_of_type_Long = SystemClock.elapsedRealtime();
        if (QLog.isColorLevel()) {
          QLog.d("FetchInfoListManager", 2, String.format(Locale.getDefault(), "doFetchInfo type:%d  key: %s time:%d", new Object[] { Integer.valueOf(localbgzb.jdField_a_of_type_Int), localbgzb.jdField_a_of_type_JavaLangString, Long.valueOf(this.jdField_a_of_type_Long) }));
        }
        if (localbgzb.jdField_a_of_type_Int == 1)
        {
          ArrayList localArrayList = new ArrayList();
          b(localbgzb);
          localArrayList.add(localbgzb);
          int i = Math.min(this.jdField_a_of_type_JavaUtilLinkedList.size(), 20) - 1;
          while (i >= 0)
          {
            localbgzb = (bgzb)this.jdField_a_of_type_JavaUtilLinkedList.get(i);
            if ((localbgzb != null) && (localbgzb.jdField_a_of_type_Int == 1))
            {
              this.jdField_a_of_type_JavaUtilLinkedList.remove(i);
              b(localbgzb);
              localArrayList.add(localbgzb);
            }
            i -= 1;
          }
          this.jdField_a_of_type_Bgza.a(1, localArrayList);
        }
        while (!this.jdField_a_of_type_JavaUtilLinkedList.isEmpty())
        {
          this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
          return;
          b(localbgzb);
          this.jdField_a_of_type_Bgza.a(localbgzb);
        }
      }
    }
  }
  
  private void b(bgzb parambgzb)
  {
    if ((parambgzb != null) && (!this.b.contains(parambgzb)))
    {
      parambgzb.jdField_a_of_type_Long = SystemClock.elapsedRealtime();
      this.b.add(parambgzb);
      if (!this.jdField_a_of_type_AndroidOsHandler.hasMessages(2)) {
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(2, 30000L);
      }
    }
  }
  
  private void c()
  {
    StringBuilder localStringBuilder;
    if (QLog.isDevelopLevel())
    {
      localStringBuilder = new StringBuilder(200);
      localStringBuilder.append("dealTimeOut  size:").append(this.b.size()).append(" {");
    }
    for (;;)
    {
      long l4 = SystemClock.elapsedRealtime();
      int i = this.b.size() - 1;
      long l1 = 30000L;
      if (i >= 0)
      {
        bgzb localbgzb = (bgzb)this.b.get(i);
        long l2;
        if (localbgzb == null)
        {
          this.b.remove(localbgzb);
          l2 = l1;
        }
        for (;;)
        {
          i -= 1;
          l1 = l2;
          break;
          long l3 = l4 - localbgzb.jdField_a_of_type_Long;
          if ((l3 < 0L) || (l3 >= 30000L))
          {
            this.b.remove(localbgzb);
            l2 = l1;
            if (localStringBuilder != null)
            {
              localStringBuilder.append(", [").append(localbgzb.jdField_a_of_type_Int).append(",").append(localbgzb.jdField_a_of_type_JavaLangString).append("]");
              l2 = l1;
            }
          }
          else
          {
            l2 = l1;
            if (l3 < l1) {
              l2 = l3;
            }
          }
        }
      }
      if (!this.b.isEmpty()) {
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(2, Math.max(1000L, l1));
      }
      if ((QLog.isDevelopLevel()) && (localStringBuilder != null))
      {
        localStringBuilder.append("}");
        localStringBuilder.append(" isEmpty: ").append(this.b.isEmpty());
        QLog.d("FetchInfoListManager", 4, localStringBuilder.toString());
      }
      return;
      localStringBuilder = null;
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilLinkedList.clear();
    this.b.clear();
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    if (QLog.isDevelopLevel()) {
      QLog.i("FetchInfoListManager", 4, "clear");
    }
  }
  
  public void a(int paramInt, String paramString1, String paramString2, Object paramObject, Bundle paramBundle)
  {
    paramString2 = new bgzb(paramInt, paramString1, paramString2, paramObject, paramBundle);
    paramString2 = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(3, paramString2);
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramString2);
    if (QLog.isDevelopLevel()) {
      QLog.i("FetchInfoListManager", 4, String.format(Locale.getDefault(), "addToNeedFetchInfoList [%d, %s]", new Object[] { Integer.valueOf(paramInt), paramString1 }));
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 3) {
      if ((paramMessage.obj instanceof bgzb)) {
        a((bgzb)paramMessage.obj);
      }
    }
    do
    {
      return true;
      if (paramMessage.what == 1)
      {
        b();
        return true;
      }
    } while (paramMessage.what != 2);
    c();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgyz
 * JD-Core Version:    0.7.0.1
 */