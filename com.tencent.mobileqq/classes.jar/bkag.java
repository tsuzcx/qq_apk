import com.tencent.gamecenter.appointment.GameCenterReceiver;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.open.wadl.WadlConfigCenter.1;
import java.util.HashMap;

public class bkag
{
  private static volatile bkag jdField_a_of_type_Bkag;
  private static final byte[] jdField_a_of_type_ArrayOfByte = new byte[0];
  private HashMap<String, bkae> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  
  private bkag()
  {
    a();
    GameCenterReceiver.a();
  }
  
  public static bkag a()
  {
    if (jdField_a_of_type_Bkag == null) {}
    synchronized (jdField_a_of_type_ArrayOfByte)
    {
      if (jdField_a_of_type_Bkag == null) {
        jdField_a_of_type_Bkag = new bkag();
      }
      return jdField_a_of_type_Bkag;
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
 * Qualified Name:     bkag
 * JD-Core Version:    0.7.0.1
 */