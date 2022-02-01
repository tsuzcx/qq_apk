import android.graphics.Bitmap;
import com.tencent.mobileqq.app.ThreadManager;
import cooperation.troop_homework.jsp.TroopHWJsPlugin;
import cooperation.troop_homework.jsp.TroopHWJsPlugin.UploadMediaEntry.2;
import cooperation.troop_homework.jsp.TroopHWJsPlugin.UploadMediaEntry.3;
import java.util.concurrent.atomic.AtomicBoolean;

public class bmrv
{
  public int a;
  public Bitmap a;
  public bmrk a;
  public bmrl a;
  public bmru a;
  String jdField_a_of_type_JavaLangString;
  public AtomicBoolean a;
  public boolean a;
  public int b;
  public String b;
  
  public bmrv(TroopHWJsPlugin paramTroopHWJsPlugin)
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_a_of_type_Bmrk = new bmrw(this);
  }
  
  public void a()
  {
    ThreadManager.postImmediately(new TroopHWJsPlugin.UploadMediaEntry.2(this), null, false);
  }
  
  public void b()
  {
    ThreadManager.postImmediately(new TroopHWJsPlugin.UploadMediaEntry.3(this), null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmrv
 * JD-Core Version:    0.7.0.1
 */