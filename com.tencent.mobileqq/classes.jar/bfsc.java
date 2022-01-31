import com.tencent.gamecenter.appointment.GameCenterReceiver;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.open.wadl.WadlConfigCenter.1;
import java.util.HashMap;

public class bfsc
{
  static bfsc jdField_a_of_type_Bfsc;
  static byte[] jdField_a_of_type_ArrayOfByte = new byte[0];
  private HashMap<String, bfsa> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  
  private bfsc()
  {
    a();
    GameCenterReceiver.a();
  }
  
  public static bfsc a()
  {
    if (jdField_a_of_type_Bfsc == null) {}
    synchronized (jdField_a_of_type_ArrayOfByte)
    {
      if (jdField_a_of_type_Bfsc == null) {
        jdField_a_of_type_Bfsc = new bfsc();
      }
      return jdField_a_of_type_Bfsc;
    }
  }
  
  public <T> T a(String paramString)
  {
    return this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
  }
  
  public void a()
  {
    ThreadManagerV2.executeOnFileThread(new WadlConfigCenter.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bfsc
 * JD-Core Version:    0.7.0.1
 */