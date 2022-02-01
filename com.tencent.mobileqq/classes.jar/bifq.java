import com.tencent.gamecenter.appointment.GameCenterReceiver;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.open.wadl.WadlConfigCenter.1;
import java.util.HashMap;

public class bifq
{
  private static volatile bifq jdField_a_of_type_Bifq;
  private static final byte[] jdField_a_of_type_ArrayOfByte = new byte[0];
  private HashMap<String, bifo> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  
  private bifq()
  {
    a();
    GameCenterReceiver.a();
  }
  
  public static bifq a()
  {
    if (jdField_a_of_type_Bifq == null) {}
    synchronized (jdField_a_of_type_ArrayOfByte)
    {
      if (jdField_a_of_type_Bifq == null) {
        jdField_a_of_type_Bifq = new bifq();
      }
      return jdField_a_of_type_Bifq;
    }
  }
  
  public <T> T a(String paramString)
  {
    return this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
  }
  
  public void a()
  {
    ThreadManagerV2.excute(new WadlConfigCenter.1(this), 64, null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bifq
 * JD-Core Version:    0.7.0.1
 */