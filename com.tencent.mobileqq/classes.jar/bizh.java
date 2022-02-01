import com.tencent.gamecenter.appointment.GameCenterReceiver;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.open.wadl.WadlConfigCenter.1;
import java.util.HashMap;

public class bizh
{
  private static volatile bizh jdField_a_of_type_Bizh;
  private static final byte[] jdField_a_of_type_ArrayOfByte = new byte[0];
  private HashMap<String, bizf> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  
  private bizh()
  {
    a();
    GameCenterReceiver.a();
  }
  
  public static bizh a()
  {
    if (jdField_a_of_type_Bizh == null) {}
    synchronized (jdField_a_of_type_ArrayOfByte)
    {
      if (jdField_a_of_type_Bizh == null) {
        jdField_a_of_type_Bizh = new bizh();
      }
      return jdField_a_of_type_Bizh;
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
 * Qualified Name:     bizh
 * JD-Core Version:    0.7.0.1
 */