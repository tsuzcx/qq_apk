import QC.UniSetRsp;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.qphone.base.util.QLog;

class bbyl
  implements BusinessObserver
{
  bbyl(bbyj parambbyj, boolean paramBoolean1, int paramInt, boolean paramBoolean2, boolean paramBoolean3, long paramLong) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (QLog.isColorLevel())
    {
      QLog.d("SimpleUILog.SimpleUIHandler", 2, new Object[] { "type:", Integer.valueOf(paramInt), " success:", Boolean.valueOf(paramBoolean), " data:", paramObject });
      if ((paramObject instanceof UniSetRsp)) {
        QLog.d("SimpleUILog.SimpleUIHandler", 1, new Object[] { "ret: ", Integer.valueOf(((UniSetRsp)paramObject).ret) });
      }
    }
    if ((paramBoolean) && ((paramObject instanceof UniSetRsp)) && (((UniSetRsp)paramObject).ret == 0))
    {
      this.jdField_a_of_type_Bbyj.a(this.jdField_a_of_type_Boolean, this.jdField_a_of_type_Int, this.b, this.c, this.jdField_a_of_type_Long);
      return;
    }
    this.jdField_a_of_type_Bbyj.a(paramBoolean, this.jdField_a_of_type_Boolean, this.jdField_a_of_type_Int, this.c, this.b, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbyl
 * JD-Core Version:    0.7.0.1
 */