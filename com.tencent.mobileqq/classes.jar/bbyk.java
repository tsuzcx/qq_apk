import QC.UniSetRsp;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicInteger;

class bbyk
  implements BusinessObserver
{
  bbyk(bbyj parambbyj, long paramLong) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    boolean bool = true;
    if (QLog.isColorLevel())
    {
      QLog.d("SimpleUILog.SimpleUIHandler", 1, new Object[] { "sendSwitchBubbleUnread onObserver update: ", Boolean.valueOf(paramBoolean), "type: ", Integer.valueOf(paramInt) });
      if ((paramObject instanceof UniSetRsp)) {
        QLog.d("SimpleUILog.SimpleUIHandler", 1, new Object[] { "ret: ", Integer.valueOf(((UniSetRsp)paramObject).ret) });
      }
    }
    if ((paramBoolean) && ((paramObject instanceof UniSetRsp)) && (((UniSetRsp)paramObject).ret == 0))
    {
      paramObject = this.jdField_a_of_type_Bbyj;
      if (bbyj.a(this.jdField_a_of_type_Bbyj).get() == 1)
      {
        paramBoolean = true;
        paramInt = bbyj.b(this.jdField_a_of_type_Bbyj).get();
        if (bbyj.c(this.jdField_a_of_type_Bbyj).get() != 1) {
          break label168;
        }
      }
      label168:
      for (bool = true;; bool = false)
      {
        paramObject.a(paramBoolean, paramInt, false, bool, this.jdField_a_of_type_Long);
        return;
        paramBoolean = false;
        break;
      }
    }
    paramObject = this.jdField_a_of_type_Bbyj;
    if (bbyj.a(this.jdField_a_of_type_Bbyj).get() == 1)
    {
      paramBoolean = true;
      paramInt = bbyj.b(this.jdField_a_of_type_Bbyj).get();
      if (bbyj.c(this.jdField_a_of_type_Bbyj).get() != 1) {
        break label237;
      }
    }
    for (;;)
    {
      paramObject.a(false, paramBoolean, paramInt, bool, false, false);
      return;
      paramBoolean = false;
      break;
      label237:
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbyk
 * JD-Core Version:    0.7.0.1
 */