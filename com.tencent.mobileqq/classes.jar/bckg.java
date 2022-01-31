import com.tencent.gamecenter.appointment.GameCenterReceiver;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.open.wadl.WadlConfigCenter.1;
import java.util.HashMap;

public class bckg
{
  static bckg jdField_a_of_type_Bckg;
  static byte[] jdField_a_of_type_ArrayOfByte = new byte[0];
  private HashMap<String, bcke> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  
  private bckg()
  {
    a();
    GameCenterReceiver.a();
  }
  
  public static bckg a()
  {
    if (jdField_a_of_type_Bckg == null) {}
    synchronized (jdField_a_of_type_ArrayOfByte)
    {
      if (jdField_a_of_type_Bckg == null) {
        jdField_a_of_type_Bckg = new bckg();
      }
      return jdField_a_of_type_Bckg;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bckg
 * JD-Core Version:    0.7.0.1
 */