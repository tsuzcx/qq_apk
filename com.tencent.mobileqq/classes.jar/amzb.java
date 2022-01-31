import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class amzb
  extends bavp
{
  amzb(amyy paramamyy, QQAppInterface paramQQAppInterface, String paramString, bavq parambavq, baps parambaps, amze paramamze, amzd paramamzd)
  {
    super(paramQQAppInterface, paramString, parambavq, parambaps);
  }
  
  protected void realCancel()
  {
    QLog.i("AREngine_ARPreSoResourceDownload", 1, " HttpEngineTask realCancel");
    synchronized (amyy.a(this.jdField_a_of_type_Amyy))
    {
      amzd localamzd = (amzd)amyy.a(this.jdField_a_of_type_Amyy).get(this.jdField_a_of_type_Amze.b);
      if (localamzd != null) {
        localamzd.b();
      }
      super.realCancel();
      return;
    }
  }
  
  protected void realStart()
  {
    QLog.i("AREngine_ARPreSoResourceDownload", 1, " HttpEngineTask  realStart");
    synchronized (amyy.a(this.jdField_a_of_type_Amyy))
    {
      amzd localamzd = (amzd)amyy.a(this.jdField_a_of_type_Amyy).get(this.jdField_a_of_type_Amze.b);
      if (localamzd != null) {
        this.jdField_a_of_type_Amzd.a();
      }
      super.realStart();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amzb
 * JD-Core Version:    0.7.0.1
 */