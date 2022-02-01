import eipc.EIPCResult;
import eipc.EIPCResultCallback;

class avpi
  implements EIPCResultCallback
{
  avpi(avph paramavph, long paramLong) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    switch (paramEIPCResult.code)
    {
    }
    for (;;)
    {
      bdla.b(null, "dc00898", "", "", "0X800AC2D", "0X800AC2D", 0, 0, String.valueOf(System.currentTimeMillis() - avph.a(this.jdField_a_of_type_Avph)), String.valueOf(this.jdField_a_of_type_Long), "", "");
      return;
      avph.a(this.jdField_a_of_type_Avph).a(2, paramEIPCResult.data);
      continue;
      avph.a(this.jdField_a_of_type_Avph).a(1, paramEIPCResult.data);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avpi
 * JD-Core Version:    0.7.0.1
 */