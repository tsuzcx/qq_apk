import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.richmedia.ordersend.OrderMediaMsgStatusCallback.1;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import mqq.os.MqqHandler;

public class avbc
  implements aclm
{
  private avbe jdField_a_of_type_Avbe;
  private Long jdField_a_of_type_JavaLangLong;
  private String jdField_a_of_type_JavaLangString;
  private ConcurrentHashMap<Long, avbd> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
  private ConcurrentLinkedQueue<Long> jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue = new ConcurrentLinkedQueue();
  
  public avbc(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  private axqf a()
  {
    if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.isEmpty())
    {
      this.jdField_a_of_type_JavaLangLong = ((Long)this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.peek());
      if ((this.jdField_a_of_type_JavaLangLong != null) && (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(this.jdField_a_of_type_JavaLangLong)))
      {
        avbd localavbd = (avbd)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(this.jdField_a_of_type_JavaLangLong);
        if (localavbd != null) {
          return localavbd.a();
        }
      }
    }
    return null;
  }
  
  private void a(axqf paramaxqf)
  {
    if ((this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null) && (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Long.valueOf(paramaxqf.b))))
    {
      Object localObject = (avbd)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Long.valueOf(paramaxqf.b));
      if (localObject == null) {
        break label150;
      }
      View localView = ((avbd)localObject).a();
      localObject = ((avbd)localObject).a();
      if ((localView != null) && (localObject != null))
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("realHandleMessage1 status:").append(paramaxqf.d).append(" ,uniseq").append(paramaxqf.b);
          QLog.d("OrderMediaMsgStatusCallback", 2, localStringBuilder.toString());
        }
        ((aclm)localObject).a(localView, paramaxqf, paramaxqf.d, paramaxqf.g);
      }
    }
    else
    {
      return;
    }
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Long.valueOf(paramaxqf.b));
    return;
    label150:
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Long.valueOf(paramaxqf.b));
  }
  
  private void a(axqf paramaxqf, boolean paramBoolean)
  {
    if (paramaxqf == null) {}
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
            if ((this.jdField_a_of_type_JavaLangLong == null) || (paramaxqf.b != this.jdField_a_of_type_JavaLangLong.longValue())) {
              break;
            }
            a(paramaxqf);
          } while (paramaxqf.d != 1003);
          this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.remove(this.jdField_a_of_type_JavaLangLong);
          this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(this.jdField_a_of_type_JavaLangLong);
          if (QLog.isColorLevel()) {
            QLog.d("OrderMediaMsgStatusCallback", 2, "remove callback:" + this.jdField_a_of_type_JavaLangLong);
          }
          a(a(), false);
          return;
        } while ((!paramBoolean) || (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Long.valueOf(paramaxqf.b))));
        localObject = (avbd)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Long.valueOf(paramaxqf.b));
      } while (localObject == null);
      ((avbd)localObject).a(paramaxqf);
    } while (!QLog.isColorLevel());
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("needCache fileStatus:").append(paramaxqf.d).append(" ,uniseq:").append(paramaxqf.b);
    QLog.d("OrderMediaMsgStatusCallback", 2, ((StringBuilder)localObject).toString());
  }
  
  private boolean a(long paramLong, int paramInt)
  {
    boolean bool1 = false;
    if (avas.b(paramInt))
    {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.remove(Long.valueOf(paramLong));
      if (this.jdField_a_of_type_Avbe != null) {
        this.jdField_a_of_type_Avbe.a(paramLong, paramInt);
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
      localObject = (avbd)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Long.valueOf(paramLong));
      if (localObject != null)
      {
        localView = ((avbd)localObject).a();
        localaclm = ((avbd)localObject).a();
        localObject = ((avbd)localObject).a();
        if ((localView != null) && (localaclm != null) && (localObject != null))
        {
          if (QLog.isColorLevel())
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("realHandleMessage2 status:").append(((axqf)localObject).d).append(" ,uniseq:").append(((axqf)localObject).b);
            QLog.d("OrderMediaMsgStatusCallback", 2, localStringBuilder.toString());
          }
          ThreadManager.getUIHandler().post(new OrderMediaMsgStatusCallback.1(this, localaclm, localView, (axqf)localObject));
        }
      }
    }
    while (!QLog.isColorLevel())
    {
      Object localObject;
      View localView;
      aclm localaclm;
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
    this.jdField_a_of_type_Avbe = null;
  }
  
  public void a(long paramLong)
  {
    if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.contains(Long.valueOf(paramLong))) {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.offer(Long.valueOf(paramLong));
    }
  }
  
  public void a(View paramView, axqf paramaxqf, int paramInt1, int paramInt2)
  {
    if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.contains(Long.valueOf(paramaxqf.b)))
    {
      a(paramaxqf);
      if (QLog.isColorLevel()) {
        QLog.d("OrderMediaMsgStatusCallback", 2, "not exist in uniseqlist:" + paramaxqf.b);
      }
      return;
    }
    boolean bool = true;
    paramView = paramaxqf;
    if (a(paramaxqf.b, paramInt1))
    {
      a(paramaxqf);
      paramView = a();
      bool = false;
    }
    a(paramView, bool);
  }
  
  public void a(avbe paramavbe)
  {
    this.jdField_a_of_type_Avbe = paramavbe;
  }
  
  public boolean a(QQAppInterface paramQQAppInterface, long paramLong, View paramView, aclm paramaclm)
  {
    if ((paramQQAppInterface == null) || (this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue == null) || (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.contains(Long.valueOf(paramLong)))) {
      return false;
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap == null) {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    }
    Object localObject = aclk.a(paramQQAppInterface);
    if (localObject != null) {
      ((aclk)localObject).a(paramView, this);
    }
    int i;
    if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Long.valueOf(paramLong)))
    {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Long.valueOf(paramLong), new avbd(this, paramView, paramaclm));
      if (QLog.isColorLevel()) {
        QLog.d("OrderMediaMsgStatusCallback", 2, "callback add success:" + paramLong);
      }
      paramQQAppInterface = paramQQAppInterface.a().a(this.jdField_a_of_type_JavaLangString, paramLong);
      if (paramQQAppInterface == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("OrderMediaMsgStatusCallback", 2, "addCallback processor is null " + paramLong);
        }
        if (this.jdField_a_of_type_Avbe == null) {
          break label504;
        }
        this.jdField_a_of_type_Avbe.a(paramLong);
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
          if (paramaclm != null) {
            break label519;
          }
        }
      }
    }
    label519:
    for (paramQQAppInterface = "";; paramQQAppInterface = paramaclm.toString())
    {
      paramView.append(paramQQAppInterface);
      QLog.d("OrderMediaMsgStatusCallback", 2, ((StringBuilder)localObject).toString());
      return true;
      if ((paramQQAppInterface instanceof axou))
      {
        paramQQAppInterface = (axou)paramQQAppInterface;
        i = (int)paramQQAppInterface.c();
        if (!a(paramLong, i))
        {
          this.jdField_a_of_type_JavaLangLong = ((Long)this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.peek());
          if ((paramLong != 0L) && (this.jdField_a_of_type_JavaLangLong != null) && (paramLong != this.jdField_a_of_type_JavaLangLong.longValue()))
          {
            if (paramaclm != null)
            {
              paramaclm.a(paramView, paramQQAppInterface.a(), i, paramQQAppInterface.j);
              localObject = (avbd)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Long.valueOf(paramLong));
              if (localObject != null) {
                ((avbd)localObject).a(paramQQAppInterface.a());
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
        paramQQAppInterface = (avbd)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Long.valueOf(paramLong));
        paramQQAppInterface.a = new WeakReference(paramView);
        paramQQAppInterface.b = new WeakReference(paramaclm);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     avbc
 * JD-Core Version:    0.7.0.1
 */