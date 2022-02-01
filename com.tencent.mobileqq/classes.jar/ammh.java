import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ApolloBaseInfo;
import com.tencent.mobileqq.vas.VasExtensionHandler;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;

class ammh
  extends Handler
{
  ammh(amme paramamme, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what == amme.jdField_b_of_type_Int)
    {
      paramMessage = (VasExtensionHandler)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.VAS_EXTENSION_HANDLER);
      if (paramMessage != null) {
        localObject = new ArrayList(amme.jdField_a_of_type_JavaUtilVector.size());
      }
    }
    while (paramMessage.what != amme.c)
    {
      try
      {
        Iterator localIterator = amme.jdField_a_of_type_JavaUtilVector.iterator();
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
        amme.jdField_a_of_type_JavaUtilVector.clear();
        if (amme.jdField_b_of_type_JavaUtilVector.size() > 0)
        {
          paramMessage.a((String[])amme.jdField_b_of_type_JavaUtilVector.toArray(new String[0]));
          amme.jdField_b_of_type_JavaUtilVector.clear();
        }
        return;
        if ((amme.a(this.a) != null) && (amme.a(this.a).apolloLocalTS != amme.a(this.a).apolloServerTS) && (!((ArrayList)localObject).contains(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin()))) {
          ((ArrayList)localObject).add(Long.valueOf(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getLongAccountUin()));
        }
      }
    }
    Object localObject = (String)paramMessage.obj;
    if (paramMessage.arg1 == 1) {
      if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!amme.jdField_a_of_type_JavaUtilVector.contains(localObject)))
      {
        amme.jdField_a_of_type_JavaUtilVector.add(localObject);
        if (QLog.isColorLevel()) {
          QLog.d("ApolloManager", 2, "addToBulkPullMap-->dress uin:" + (String)localObject);
        }
      }
    }
    for (;;)
    {
      this.a.jdField_a_of_type_AndroidOsHandler.removeMessages(amme.jdField_b_of_type_Int);
      this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(amme.jdField_b_of_type_Int, 200L);
      return;
      if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!amme.jdField_b_of_type_JavaUtilVector.contains(localObject)))
      {
        amme.jdField_b_of_type_JavaUtilVector.add(localObject);
        if (QLog.isColorLevel()) {
          QLog.d("ApolloManager", 2, "addToBulkPullMap-->info uin:" + (String)localObject);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ammh
 * JD-Core Version:    0.7.0.1
 */