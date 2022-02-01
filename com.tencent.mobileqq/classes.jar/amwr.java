import android.content.Context;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;

public class amwr
  extends BusinessHandler
{
  private static final Object jdField_a_of_type_JavaLangObject = new Object();
  private aokb jdField_a_of_type_Aokb;
  
  public amwr(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
  }
  
  public void a(Context paramContext)
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_Aokb == null)
      {
        this.jdField_a_of_type_Aokb = aokb.a();
        this.jdField_a_of_type_Aokb.a(paramContext, hashCode(), "MiniCodePeakHandler");
      }
      return;
    }
  }
  
  public Class<? extends BusinessObserver> observerClass()
  {
    return null;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (QLog.isColorLevel()) {
      QLog.i("MiniCodePeakHandler", 2, "onDestroy");
    }
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_Aokb != null)
      {
        this.jdField_a_of_type_Aokb.a(hashCode(), "MiniCodePeakHandler");
        this.jdField_a_of_type_Aokb = null;
      }
      return;
    }
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amwr
 * JD-Core Version:    0.7.0.1
 */