import android.graphics.Bitmap;
import com.tencent.mobileqq.app.ThreadManager;
import cooperation.troop_homework.jsp.TroopHWJsPlugin;
import cooperation.troop_homework.jsp.TroopHWJsPlugin.UploadMediaEntry.2;
import cooperation.troop_homework.jsp.TroopHWJsPlugin.UploadMediaEntry.3;
import java.util.concurrent.atomic.AtomicBoolean;

public class bhxc
{
  public int a;
  public Bitmap a;
  public bhwr a;
  public bhws a;
  public bhxb a;
  String jdField_a_of_type_JavaLangString;
  public AtomicBoolean a;
  public boolean a;
  public int b;
  public String b;
  
  public bhxc(TroopHWJsPlugin paramTroopHWJsPlugin)
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_a_of_type_Bhwr = new bhxd(this);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bhxc
 * JD-Core Version:    0.7.0.1
 */