import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ApolloBaseInfo;
import com.tencent.mobileqq.vas.VasExtensionHandler;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;

class amta
  extends Handler
{
  amta(amsx paramamsx, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what == amsx.jdField_a_of_type_Int)
    {
      paramMessage = (VasExtensionHandler)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(71);
      if (paramMessage != null) {
        localObject = new ArrayList(amsx.jdField_a_of_type_JavaUtilVector.size());
      }
    }
    while (paramMessage.what != amsx.jdField_b_of_type_Int)
    {
      try
      {
        Iterator localIterator = amsx.jdField_a_of_type_JavaUtilVector.iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          if (!((ArrayList)localObject).contains(str)) {
            ((ArrayList)localObject).add(Long.valueOf(Long.parseLong(str)));
          }
        }
        paramMessage.a((ArrayList)localObject, "troop");
      }
      catch (Exception localException) {}
      for (;;)
      {
        amsx.jdField_a_of_type_JavaUtilVector.clear();
        if (amsx.jdField_b_of_type_JavaUtilVector.size() > 0)
        {
          paramMessage.a((String[])amsx.jdField_b_of_type_JavaUtilVector.toArray(new String[0]));
          amsx.jdField_b_of_type_JavaUtilVector.clear();
        }
        return;
        if ((amsx.a(this.a) != null) && (amsx.a(this.a).apolloLocalTS != amsx.a(this.a).apolloServerTS) && (!((ArrayList)localObject).contains(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c()))) {
          ((ArrayList)localObject).add(Long.valueOf(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getLongAccountUin()));
        }
      }
    }
    Object localObject = (String)paramMessage.obj;
    if (paramMessage.arg1 == 1) {
      if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!amsx.jdField_a_of_type_JavaUtilVector.contains(localObject)))
      {
        amsx.jdField_a_of_type_JavaUtilVector.add(localObject);
        if (QLog.isColorLevel()) {
          QLog.d("ApolloManager", 2, "addToBulkPullMap-->dress uin:" + (String)localObject);
        }
      }
    }
    for (;;)
    {
      this.a.jdField_a_of_type_AndroidOsHandler.removeMessages(amsx.jdField_a_of_type_Int);
      this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(amsx.jdField_a_of_type_Int, 200L);
      return;
      if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!amsx.jdField_b_of_type_JavaUtilVector.contains(localObject)))
      {
        amsx.jdField_b_of_type_JavaUtilVector.add(localObject);
        if (QLog.isColorLevel()) {
          QLog.d("ApolloManager", 2, "addToBulkPullMap-->info uin:" + (String)localObject);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amta
 * JD-Core Version:    0.7.0.1
 */