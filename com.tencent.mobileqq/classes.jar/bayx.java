import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.os.SystemClock;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Locale;

public class bayx
  implements Handler.Callback
{
  private long jdField_a_of_type_Long;
  private final Handler jdField_a_of_type_AndroidOsHandler;
  private final bayy jdField_a_of_type_Bayy;
  private final LinkedList<bayz> jdField_a_of_type_JavaUtilLinkedList;
  private final LinkedList<bayz> b;
  
  public bayx(bayy parambayy)
  {
    this.jdField_a_of_type_Bayy = parambayy;
    this.jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
    this.b = new LinkedList();
    this.jdField_a_of_type_AndroidOsHandler = new bfob(ThreadManager.getSubThreadLooper(), this);
    this.jdField_a_of_type_Long = 0L;
  }
  
  private void a(bayz parambayz)
  {
    if (!parambayz.a()) {
      if (QLog.isColorLevel()) {
        QLog.d("FetchInfoListManager", 2, bbkk.a(new Object[] { "addToNeedFetchInfoListInner() ", parambayz.toString(), "非法请求" }));
      }
    }
    do
    {
      do
      {
        return;
        if ((!this.jdField_a_of_type_JavaUtilLinkedList.contains(parambayz)) && (!this.b.contains(parambayz))) {
          break;
        }
      } while (!QLog.isDevelopLevel());
      QLog.d("FetchInfoListManager", 4, bbkk.a(new Object[] { "addToNeedFetchInfoListInner()", parambayz.toString(), "已经在队列中了" }));
      return;
      if (QLog.isDevelopLevel()) {
        QLog.d("FetchInfoListManager", 4, bbkk.a(new Object[] { "addToNeedFetchInfoListInner()", parambayz.toString() }));
      }
      this.jdField_a_of_type_JavaUtilLinkedList.addFirst(parambayz);
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
      bayz localbayz;
      do
      {
        localbayz = (bayz)this.jdField_a_of_type_JavaUtilLinkedList.removeFirst();
      } while ((localbayz == null) && (!this.jdField_a_of_type_JavaUtilLinkedList.isEmpty()));
      if (localbayz == null)
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("FetchInfoListManager", 4, "doFetchInfo req is null !");
        }
      }
      else
      {
        this.jdField_a_of_type_Long = SystemClock.elapsedRealtime();
        if (QLog.isColorLevel()) {
          QLog.d("FetchInfoListManager", 2, String.format(Locale.getDefault(), "doFetchInfo type:%d  key: %s time:%d", new Object[] { Integer.valueOf(localbayz.jdField_a_of_type_Int), localbayz.jdField_a_of_type_JavaLangString, Long.valueOf(this.jdField_a_of_type_Long) }));
        }
        if (localbayz.jdField_a_of_type_Int == 1)
        {
          ArrayList localArrayList = new ArrayList();
          b(localbayz);
          localArrayList.add(localbayz);
          int i = Math.min(this.jdField_a_of_type_JavaUtilLinkedList.size(), 20) - 1;
          while (i >= 0)
          {
            localbayz = (bayz)this.jdField_a_of_type_JavaUtilLinkedList.get(i);
            if ((localbayz != null) && (localbayz.jdField_a_of_type_Int == 1))
            {
              this.jdField_a_of_type_JavaUtilLinkedList.remove(i);
              b(localbayz);
              localArrayList.add(localbayz);
            }
            i -= 1;
          }
          this.jdField_a_of_type_Bayy.a(1, localArrayList);
        }
        while (!this.jdField_a_of_type_JavaUtilLinkedList.isEmpty())
        {
          this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
          return;
          b(localbayz);
          this.jdField_a_of_type_Bayy.a(localbayz);
        }
      }
    }
  }
  
  private void b(bayz parambayz)
  {
    if ((parambayz != null) && (!this.b.contains(parambayz)))
    {
      parambayz.jdField_a_of_type_Long = SystemClock.elapsedRealtime();
      this.b.add(parambayz);
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
        bayz localbayz = (bayz)this.b.get(i);
        long l2;
        if (localbayz == null)
        {
          this.b.remove(localbayz);
          l2 = l1;
        }
        for (;;)
        {
          i -= 1;
          l1 = l2;
          break;
          long l3 = l4 - localbayz.jdField_a_of_type_Long;
          if ((l3 < 0L) || (l3 >= 30000L))
          {
            this.b.remove(localbayz);
            l2 = l1;
            if (localStringBuilder != null)
            {
              localStringBuilder.append(", [").append(localbayz.jdField_a_of_type_Int).append(",").append(localbayz.jdField_a_of_type_JavaLangString).append("]");
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
    paramString2 = new bayz(paramInt, paramString1, paramString2, paramObject, paramBundle);
    paramString2 = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(3, paramString2);
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramString2);
    if (QLog.isDevelopLevel()) {
      QLog.i("FetchInfoListManager", 4, String.format(Locale.getDefault(), "addToNeedFetchInfoList [%d, %s]", new Object[] { Integer.valueOf(paramInt), paramString1 }));
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 3) {
      if ((paramMessage.obj instanceof bayz)) {
        a((bayz)paramMessage.obj);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     bayx
 * JD-Core Version:    0.7.0.1
 */