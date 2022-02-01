import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.qphone.base.util.QLog;

class aoax
  implements bihh
{
  aoax(aoaw paramaoaw, int paramInt) {}
  
  public void onWXShareResp(BaseResp paramBaseResp)
  {
    if ((paramBaseResp == null) || (paramBaseResp.transaction == null))
    {
      QLog.e("AVGameShareBase", 1, "onWXShareResp: respData is null");
      return;
    }
    if (!paramBaseResp.transaction.equals(this.jdField_a_of_type_Aoaw.a))
    {
      QLog.e("AVGameShareBase", 1, "onWXShareResp: mWXTransaction is wrong");
      return;
    }
    switch (paramBaseResp.errCode)
    {
    case -1: 
    default: 
      this.jdField_a_of_type_Aoaw.d(this.jdField_a_of_type_Int);
      return;
    case 0: 
      this.jdField_a_of_type_Aoaw.b(this.jdField_a_of_type_Int);
      return;
    }
    this.jdField_a_of_type_Aoaw.c(this.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aoax
 * JD-Core Version:    0.7.0.1
 */