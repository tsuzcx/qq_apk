import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.richmedia.ordersend.OrderMediaMsgStatusCallback.1;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import mqq.os.MqqHandler;

public class awax
  implements acwb
{
  private awaz jdField_a_of_type_Awaz;
  private Long jdField_a_of_type_JavaLangLong;
  private String jdField_a_of_type_JavaLangString;
  private ConcurrentHashMap<Long, away> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
  private ConcurrentLinkedQueue<Long> jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue = new ConcurrentLinkedQueue();
  
  public awax(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  private ayqo a()
  {
    if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.isEmpty())
    {
      this.jdField_a_of_type_JavaLangLong = ((Long)this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.peek());
      if ((this.jdField_a_of_type_JavaLangLong != null) && (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(this.jdField_a_of_type_JavaLangLong)))
      {
        away localaway = (away)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(this.jdField_a_of_type_JavaLangLong);
        if (localaway != null) {
          return localaway.a();
        }
      }
    }
    return null;
  }
  
  private void a(ayqo paramayqo)
  {
    if ((this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null) && (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Long.valueOf(paramayqo.b))))
    {
      Object localObject = (away)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Long.valueOf(paramayqo.b));
      if (localObject == null) {
        break label150;
      }
      View localView = ((away)localObject).a();
      localObject = ((away)localObject).a();
      if ((localView != null) && (localObject != null))
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("realHandleMessage1 status:").append(paramayqo.d).append(" ,uniseq").append(paramayqo.b);
          QLog.d("OrderMediaMsgStatusCallback", 2, localStringBuilder.toString());
        }
        ((acwb)localObject).a(localView, paramayqo, paramayqo.d, paramayqo.g);
      }
    }
    else
    {
      return;
    }
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Long.valueOf(paramayqo.b));
    return;
    label150:
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Long.valueOf(paramayqo.b));
  }
  
  private void a(ayqo paramayqo, boolean paramBoolean)
  {
    if (paramayqo == null) {}
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
            if ((this.jdField_a_of_type_JavaLangLong == null) || (paramayqo.b != this.jdField_a_of_type_JavaLangLong.longValue())) {
              break;
            }
            a(paramayqo);
          } while (paramayqo.d != 1003);
          this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.remove(this.jdField_a_of_type_JavaLangLong);
          this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(this.jdField_a_of_type_JavaLangLong);
          if (QLog.isColorLevel()) {
            QLog.d("OrderMediaMsgStatusCallback", 2, "remove callback:" + this.jdField_a_of_type_JavaLangLong);
          }
          a(a(), false);
          return;
        } while ((!paramBoolean) || (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Long.valueOf(paramayqo.b))));
        localObject = (away)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Long.valueOf(paramayqo.b));
      } while (localObject == null);
      ((away)localObject).a(paramayqo);
    } while (!QLog.isColorLevel());
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("needCache fileStatus:").append(paramayqo.d).append(" ,uniseq:").append(paramayqo.b);
    QLog.d("OrderMediaMsgStatusCallback", 2, ((StringBuilder)localObject).toString());
  }
  
  private boolean a(long paramLong, int paramInt)
  {
    boolean bool1 = false;
    if (awan.b(paramInt))
    {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.remove(Long.valueOf(paramLong));
      if (this.jdField_a_of_type_Awaz != null) {
        this.jdField_a_of_type_Awaz.a(paramLong, paramInt);
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
      localObject = (away)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Long.valueOf(paramLong));
      if (localObject != null)
      {
        localView = ((away)localObject).a();
        localacwb = ((away)localObject).a();
        localObject = ((away)localObject).a();
        if ((localView != null) && (localacwb != null) && (localObject != null))
        {
          if (QLog.isColorLevel())
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("realHandleMessage2 status:").append(((ayqo)localObject).d).append(" ,uniseq:").append(((ayqo)localObject).b);
            QLog.d("OrderMediaMsgStatusCallback", 2, localStringBuilder.toString());
          }
          ThreadManager.getUIHandler().post(new OrderMediaMsgStatusCallback.1(this, localacwb, localView, (ayqo)localObject));
        }
      }
    }
    while (!QLog.isColorLevel())
    {
      Object localObject;
      View localView;
      acwb localacwb;
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
    this.jdField_a_of_type_Awaz = null;
  }
  
  public void a(long paramLong)
  {
    if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.contains(Long.valueOf(paramLong))) {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.offer(Long.valueOf(paramLong));
    }
  }
  
  public void a(View paramView, ayqo paramayqo, int paramInt1, int paramInt2)
  {
    if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.contains(Long.valueOf(paramayqo.b)))
    {
      a(paramayqo);
      if (QLog.isColorLevel()) {
        QLog.d("OrderMediaMsgStatusCallback", 2, "not exist in uniseqlist:" + paramayqo.b);
      }
      return;
    }
    boolean bool = true;
    paramView = paramayqo;
    if (a(paramayqo.b, paramInt1))
    {
      a(paramayqo);
      paramView = a();
      bool = false;
    }
    a(paramView, bool);
  }
  
  public void a(awaz paramawaz)
  {
    this.jdField_a_of_type_Awaz = paramawaz;
  }
  
  public boolean a(QQAppInterface paramQQAppInterface, long paramLong, View paramView, acwb paramacwb)
  {
    if ((paramQQAppInterface == null) || (this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue == null) || (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.contains(Long.valueOf(paramLong)))) {
      return false;
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap == null) {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    }
    Object localObject = acvz.a(paramQQAppInterface);
    if (localObject != null) {
      ((acvz)localObject).a(paramView, this);
    }
    int i;
    if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Long.valueOf(paramLong)))
    {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Long.valueOf(paramLong), new away(this, paramView, paramacwb));
      if (QLog.isColorLevel()) {
        QLog.d("OrderMediaMsgStatusCallback", 2, "callback add success:" + paramLong);
      }
      paramQQAppInterface = paramQQAppInterface.a().a(this.jdField_a_of_type_JavaLangString, paramLong);
      if (paramQQAppInterface == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("OrderMediaMsgStatusCallback", 2, "addCallback processor is null " + paramLong);
        }
        if (this.jdField_a_of_type_Awaz == null) {
          break label504;
        }
        this.jdField_a_of_type_Awaz.a(paramLong);
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
          if (paramacwb != null) {
            break label519;
          }
        }
      }
    }
    label519:
    for (paramQQAppInterface = "";; paramQQAppInterface = paramacwb.toString())
    {
      paramView.append(paramQQAppInterface);
      QLog.d("OrderMediaMsgStatusCallback", 2, ((StringBuilder)localObject).toString());
      return true;
      if ((paramQQAppInterface instanceof aypb))
      {
        paramQQAppInterface = (aypb)paramQQAppInterface;
        i = (int)paramQQAppInterface.c();
        if (!a(paramLong, i))
        {
          this.jdField_a_of_type_JavaLangLong = ((Long)this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.peek());
          if ((paramLong != 0L) && (this.jdField_a_of_type_JavaLangLong != null) && (paramLong != this.jdField_a_of_type_JavaLangLong.longValue()))
          {
            if (paramacwb != null)
            {
              paramacwb.a(paramView, paramQQAppInterface.a(), i, paramQQAppInterface.j);
              localObject = (away)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Long.valueOf(paramLong));
              if (localObject != null) {
                ((away)localObject).a(paramQQAppInterface.a());
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
        paramQQAppInterface = (away)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Long.valueOf(paramLong));
        paramQQAppInterface.a = new WeakReference(paramView);
        paramQQAppInterface.b = new WeakReference(paramacwb);
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
 * Qualified Name:     awax
 * JD-Core Version:    0.7.0.1
 */