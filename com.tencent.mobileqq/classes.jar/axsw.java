import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.richmedia.ordersend.OrderMediaMsgStatusCallback.1;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import mqq.os.MqqHandler;

public class axsw
  implements aenl
{
  private axsy jdField_a_of_type_Axsy;
  private Long jdField_a_of_type_JavaLangLong;
  private String jdField_a_of_type_JavaLangString;
  private ConcurrentHashMap<Long, axsx> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
  private ConcurrentLinkedQueue<Long> jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue = new ConcurrentLinkedQueue();
  
  public axsw(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  private baoj a()
  {
    if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.isEmpty())
    {
      this.jdField_a_of_type_JavaLangLong = ((Long)this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.peek());
      if ((this.jdField_a_of_type_JavaLangLong != null) && (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(this.jdField_a_of_type_JavaLangLong)))
      {
        axsx localaxsx = (axsx)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(this.jdField_a_of_type_JavaLangLong);
        if (localaxsx != null) {
          return localaxsx.a();
        }
      }
    }
    return null;
  }
  
  private void a(baoj parambaoj)
  {
    if ((this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null) && (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Long.valueOf(parambaoj.b))))
    {
      Object localObject = (axsx)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Long.valueOf(parambaoj.b));
      if (localObject == null) {
        break label150;
      }
      View localView = ((axsx)localObject).a();
      localObject = ((axsx)localObject).a();
      if ((localView != null) && (localObject != null))
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("realHandleMessage1 status:").append(parambaoj.d).append(" ,uniseq").append(parambaoj.b);
          QLog.d("OrderMediaMsgStatusCallback", 2, localStringBuilder.toString());
        }
        ((aenl)localObject).a(localView, parambaoj, parambaoj.d, parambaoj.g);
      }
    }
    else
    {
      return;
    }
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Long.valueOf(parambaoj.b));
    return;
    label150:
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Long.valueOf(parambaoj.b));
  }
  
  private void a(baoj parambaoj, boolean paramBoolean)
  {
    if (parambaoj == null) {}
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
            if ((this.jdField_a_of_type_JavaLangLong == null) || (parambaoj.b != this.jdField_a_of_type_JavaLangLong.longValue())) {
              break;
            }
            a(parambaoj);
          } while (parambaoj.d != 1003);
          this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.remove(this.jdField_a_of_type_JavaLangLong);
          this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(this.jdField_a_of_type_JavaLangLong);
          if (QLog.isColorLevel()) {
            QLog.d("OrderMediaMsgStatusCallback", 2, "remove callback:" + this.jdField_a_of_type_JavaLangLong);
          }
          a(a(), false);
          return;
        } while ((!paramBoolean) || (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Long.valueOf(parambaoj.b))));
        localObject = (axsx)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Long.valueOf(parambaoj.b));
      } while (localObject == null);
      ((axsx)localObject).a(parambaoj);
    } while (!QLog.isColorLevel());
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("needCache fileStatus:").append(parambaoj.d).append(" ,uniseq:").append(parambaoj.b);
    QLog.d("OrderMediaMsgStatusCallback", 2, ((StringBuilder)localObject).toString());
  }
  
  private boolean a(long paramLong, int paramInt)
  {
    boolean bool1 = false;
    if (axsm.b(paramInt))
    {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.remove(Long.valueOf(paramLong));
      if (this.jdField_a_of_type_Axsy != null) {
        this.jdField_a_of_type_Axsy.a(paramLong, paramInt);
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
      localObject = (axsx)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Long.valueOf(paramLong));
      if (localObject != null)
      {
        localView = ((axsx)localObject).a();
        localaenl = ((axsx)localObject).a();
        localObject = ((axsx)localObject).a();
        if ((localView != null) && (localaenl != null) && (localObject != null))
        {
          if (QLog.isColorLevel())
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("realHandleMessage2 status:").append(((baoj)localObject).d).append(" ,uniseq:").append(((baoj)localObject).b);
            QLog.d("OrderMediaMsgStatusCallback", 2, localStringBuilder.toString());
          }
          ThreadManager.getUIHandler().post(new OrderMediaMsgStatusCallback.1(this, localaenl, localView, (baoj)localObject));
        }
      }
    }
    while (!QLog.isColorLevel())
    {
      Object localObject;
      View localView;
      aenl localaenl;
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
    this.jdField_a_of_type_Axsy = null;
  }
  
  public void a(long paramLong)
  {
    if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.contains(Long.valueOf(paramLong))) {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.offer(Long.valueOf(paramLong));
    }
  }
  
  public void a(View paramView, baoj parambaoj, int paramInt1, int paramInt2)
  {
    if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.contains(Long.valueOf(parambaoj.b)))
    {
      a(parambaoj);
      if (QLog.isColorLevel()) {
        QLog.d("OrderMediaMsgStatusCallback", 2, "not exist in uniseqlist:" + parambaoj.b);
      }
      return;
    }
    boolean bool = true;
    paramView = parambaoj;
    if (a(parambaoj.b, paramInt1))
    {
      a(parambaoj);
      paramView = a();
      bool = false;
    }
    a(paramView, bool);
  }
  
  public void a(axsy paramaxsy)
  {
    this.jdField_a_of_type_Axsy = paramaxsy;
  }
  
  public boolean a(QQAppInterface paramQQAppInterface, long paramLong, View paramView, aenl paramaenl)
  {
    if ((paramQQAppInterface == null) || (this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue == null) || (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.contains(Long.valueOf(paramLong)))) {
      return false;
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap == null) {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    }
    Object localObject = aenj.a(paramQQAppInterface);
    if (localObject != null) {
      ((aenj)localObject).a(paramView, this);
    }
    int i;
    if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Long.valueOf(paramLong)))
    {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Long.valueOf(paramLong), new axsx(this, paramView, paramaenl));
      if (QLog.isColorLevel()) {
        QLog.d("OrderMediaMsgStatusCallback", 2, "callback add success:" + paramLong);
      }
      paramQQAppInterface = paramQQAppInterface.a().a(this.jdField_a_of_type_JavaLangString, paramLong);
      if (paramQQAppInterface == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("OrderMediaMsgStatusCallback", 2, "addCallback processor is null " + paramLong);
        }
        if (this.jdField_a_of_type_Axsy == null) {
          break label504;
        }
        this.jdField_a_of_type_Axsy.a(paramLong);
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
          if (paramaenl != null) {
            break label519;
          }
        }
      }
    }
    label519:
    for (paramQQAppInterface = "";; paramQQAppInterface = paramaenl.toString())
    {
      paramView.append(paramQQAppInterface);
      QLog.d("OrderMediaMsgStatusCallback", 2, ((StringBuilder)localObject).toString());
      return true;
      if ((paramQQAppInterface instanceof bamw))
      {
        paramQQAppInterface = (bamw)paramQQAppInterface;
        i = (int)paramQQAppInterface.c();
        if (!a(paramLong, i))
        {
          this.jdField_a_of_type_JavaLangLong = ((Long)this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.peek());
          if ((paramLong != 0L) && (this.jdField_a_of_type_JavaLangLong != null) && (paramLong != this.jdField_a_of_type_JavaLangLong.longValue()))
          {
            if (paramaenl != null)
            {
              paramaenl.a(paramView, paramQQAppInterface.a(), i, paramQQAppInterface.j);
              localObject = (axsx)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Long.valueOf(paramLong));
              if (localObject != null) {
                ((axsx)localObject).a(paramQQAppInterface.a());
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
        paramQQAppInterface = (axsx)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Long.valueOf(paramLong));
        paramQQAppInterface.a = new WeakReference(paramView);
        paramQQAppInterface.b = new WeakReference(paramaenl);
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
 * Qualified Name:     axsw
 * JD-Core Version:    0.7.0.1
 */