import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.richmedia.ordersend.OrderMediaMsgStatusCallback.1;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import mqq.os.MqqHandler;

public class bbnz
  implements agif
{
  private bbob jdField_a_of_type_Bbob;
  private Long jdField_a_of_type_JavaLangLong;
  private String jdField_a_of_type_JavaLangString;
  private ConcurrentHashMap<Long, bboa> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
  private ConcurrentLinkedQueue<Long> jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue = new ConcurrentLinkedQueue();
  
  public bbnz(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  private bete a()
  {
    if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.isEmpty())
    {
      this.jdField_a_of_type_JavaLangLong = ((Long)this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.peek());
      if ((this.jdField_a_of_type_JavaLangLong != null) && (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(this.jdField_a_of_type_JavaLangLong)))
      {
        bboa localbboa = (bboa)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(this.jdField_a_of_type_JavaLangLong);
        if (localbboa != null) {
          return localbboa.a();
        }
      }
    }
    return null;
  }
  
  private void a(bete parambete)
  {
    if ((this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null) && (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Long.valueOf(parambete.b))))
    {
      Object localObject = (bboa)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Long.valueOf(parambete.b));
      if (localObject == null) {
        break label150;
      }
      View localView = ((bboa)localObject).a();
      localObject = ((bboa)localObject).a();
      if ((localView != null) && (localObject != null))
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("realHandleMessage1 status:").append(parambete.d).append(" ,uniseq").append(parambete.b);
          QLog.d("OrderMediaMsgStatusCallback", 2, localStringBuilder.toString());
        }
        ((agif)localObject).a(localView, parambete, parambete.d, parambete.g);
      }
    }
    else
    {
      return;
    }
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Long.valueOf(parambete.b));
    return;
    label150:
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Long.valueOf(parambete.b));
  }
  
  private void a(bete parambete, boolean paramBoolean)
  {
    if (parambete == null) {}
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            this.jdField_a_of_type_JavaLangLong = ((Long)this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.peek());
            if ((this.jdField_a_of_type_JavaLangLong == null) || (parambete.b != this.jdField_a_of_type_JavaLangLong.longValue())) {
              break;
            }
            a(parambete);
          } while (parambete.d != 1003);
          this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.remove(this.jdField_a_of_type_JavaLangLong);
          this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(this.jdField_a_of_type_JavaLangLong);
          if (QLog.isColorLevel()) {
            QLog.d("OrderMediaMsgStatusCallback", 2, "remove callback:" + this.jdField_a_of_type_JavaLangLong);
          }
          a(a(), false);
          return;
        } while ((!paramBoolean) || (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Long.valueOf(parambete.b))));
        localObject = (bboa)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Long.valueOf(parambete.b));
      } while (localObject == null);
      ((bboa)localObject).a(parambete);
    } while (!QLog.isColorLevel());
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("needCache fileStatus:").append(parambete.d).append(" ,uniseq:").append(parambete.b);
    QLog.d("OrderMediaMsgStatusCallback", 2, ((StringBuilder)localObject).toString());
  }
  
  private boolean a(long paramLong, int paramInt)
  {
    boolean bool1 = false;
    if (bbnp.b(paramInt))
    {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.remove(Long.valueOf(paramLong));
      if (this.jdField_a_of_type_Bbob != null) {
        this.jdField_a_of_type_Bbob.a(paramLong, paramInt);
      }
      boolean bool2 = true;
      bool1 = bool2;
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("handleErrorMessage status:").append(paramInt).append(" ,uniseq:").append(paramLong);
        QLog.d("OrderMediaMsgStatusCallback", 2, localStringBuilder.toString());
        bool1 = bool2;
      }
    }
    return bool1;
  }
  
  private void c(long paramLong)
  {
    if ((this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null) && (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Long.valueOf(paramLong))))
    {
      localObject = (bboa)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Long.valueOf(paramLong));
      if (localObject != null)
      {
        localView = ((bboa)localObject).a();
        localagif = ((bboa)localObject).a();
        localObject = ((bboa)localObject).a();
        if ((localView != null) && (localagif != null) && (localObject != null))
        {
          if (QLog.isColorLevel())
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("realHandleMessage2 status:").append(((bete)localObject).d).append(" ,uniseq:").append(((bete)localObject).b);
            QLog.d("OrderMediaMsgStatusCallback", 2, localStringBuilder.toString());
          }
          ThreadManager.getUIHandler().post(new OrderMediaMsgStatusCallback.1(this, localagif, localView, (bete)localObject));
        }
      }
    }
    while (!QLog.isColorLevel())
    {
      Object localObject;
      View localView;
      agif localagif;
      StringBuilder localStringBuilder;
      return;
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Long.valueOf(paramLong));
      return;
    }
    QLog.d("OrderMediaMsgStatusCallback", 2, "CallbackWrapperMap not contain:" + paramLong);
  }
  
  public int a(long paramLong)
  {
    int i = 0;
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.contains(Long.valueOf(paramLong)))
    {
      if (((Long)this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.peek()).longValue() == paramLong) {
        i = 1;
      }
    }
    else {
      return i;
    }
    return 2;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null)
    {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = null;
    }
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.clear();
    this.jdField_a_of_type_Bbob = null;
  }
  
  public void a(long paramLong)
  {
    if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.contains(Long.valueOf(paramLong))) {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.offer(Long.valueOf(paramLong));
    }
  }
  
  public void a(View paramView, bete parambete, int paramInt1, int paramInt2)
  {
    if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.contains(Long.valueOf(parambete.b)))
    {
      a(parambete);
      if (QLog.isColorLevel()) {
        QLog.d("OrderMediaMsgStatusCallback", 2, "not exist in uniseqlist:" + parambete.b);
      }
      return;
    }
    boolean bool = true;
    paramView = parambete;
    if (a(parambete.b, paramInt1))
    {
      a(parambete);
      paramView = a();
      bool = false;
    }
    a(paramView, bool);
  }
  
  public void a(bbob parambbob)
  {
    this.jdField_a_of_type_Bbob = parambbob;
  }
  
  public boolean a(QQAppInterface paramQQAppInterface, long paramLong, View paramView, agif paramagif)
  {
    if ((paramQQAppInterface == null) || (this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue == null) || (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.contains(Long.valueOf(paramLong)))) {
      return false;
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap == null) {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    }
    Object localObject = agid.a(paramQQAppInterface);
    if (localObject != null) {
      ((agid)localObject).a(paramView, this);
    }
    int i;
    if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Long.valueOf(paramLong)))
    {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Long.valueOf(paramLong), new bboa(this, paramView, paramagif));
      if (QLog.isColorLevel()) {
        QLog.d("OrderMediaMsgStatusCallback", 2, "callback add success:" + paramLong);
      }
      paramQQAppInterface = paramQQAppInterface.a().a(this.jdField_a_of_type_JavaLangString, paramLong);
      if (paramQQAppInterface == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("OrderMediaMsgStatusCallback", 2, "addCallback processor is null " + paramLong);
        }
        if (this.jdField_a_of_type_Bbob == null) {
          break label504;
        }
        this.jdField_a_of_type_Bbob.a(paramLong);
        i = -1;
        if (QLog.isDevelopLevel())
        {
          localObject = new StringBuilder();
          StringBuilder localStringBuilder = ((StringBuilder)localObject).append("addCallback uniseq:").append(paramLong).append(" ,status:").append(i).append(" ,view:");
          if (paramView != null) {
            break label510;
          }
          paramQQAppInterface = "";
          label252:
          paramView = localStringBuilder.append(paramQQAppInterface).append(" ,callback:");
          if (paramagif != null) {
            break label519;
          }
        }
      }
    }
    label519:
    for (paramQQAppInterface = "";; paramQQAppInterface = paramagif.toString())
    {
      paramView.append(paramQQAppInterface);
      QLog.d("OrderMediaMsgStatusCallback", 2, ((StringBuilder)localObject).toString());
      return true;
      if ((paramQQAppInterface instanceof berp))
      {
        paramQQAppInterface = (berp)paramQQAppInterface;
        i = (int)paramQQAppInterface.c();
        if (!a(paramLong, i))
        {
          this.jdField_a_of_type_JavaLangLong = ((Long)this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.peek());
          if ((paramLong != 0L) && (this.jdField_a_of_type_JavaLangLong != null) && (paramLong != this.jdField_a_of_type_JavaLangLong.longValue()))
          {
            if (paramagif != null)
            {
              paramagif.a(paramView, paramQQAppInterface.a(), i, paramQQAppInterface.k);
              localObject = (bboa)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Long.valueOf(paramLong));
              if (localObject != null) {
                ((bboa)localObject).a(paramQQAppInterface.a());
              }
            }
            if (QLog.isColorLevel())
            {
              paramQQAppInterface = new StringBuilder();
              paramQQAppInterface.append("Not the first! status:").append(i).append(" ,uniseq:").append(paramLong);
              QLog.d("OrderMediaMsgStatusCallback", 2, paramQQAppInterface.toString());
            }
          }
        }
        break;
        paramQQAppInterface = (bboa)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Long.valueOf(paramLong));
        paramQQAppInterface.a = new WeakReference(paramView);
        paramQQAppInterface.b = new WeakReference(paramagif);
      }
      label504:
      i = -1;
      break;
      label510:
      paramQQAppInterface = paramView.toString();
      break label252;
    }
  }
  
  public void b(long paramLong)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.contains(Long.valueOf(paramLong)))
    {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.remove(Long.valueOf(paramLong));
      if (QLog.isColorLevel()) {
        QLog.d("OrderMediaMsgStatusCallback", 2, "removeUniseqFromOrderList " + paramLong);
      }
      c(paramLong);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbnz
 * JD-Core Version:    0.7.0.1
 */