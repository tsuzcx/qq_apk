import com.tencent.qphone.base.util.QLog;

public class azfj
{
  private azfa a;
  
  public azfj(azfa paramazfa)
  {
    this.a = paramazfa;
  }
  
  public void a(azfk paramazfk)
  {
    if (paramazfk == null) {
      if (QLog.isColorLevel()) {
        QLog.d("VoiceModel", 2, "executeCommand commandInformation is null");
      }
    }
    azeb localazeb;
    do
    {
      return;
      localazeb = new azew(this.a).a(paramazfk.a);
    } while (localazeb == null);
    new azex(localazeb).a(paramazfk);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azfj
 * JD-Core Version:    0.7.0.1
 */