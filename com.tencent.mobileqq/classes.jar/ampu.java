import com.tencent.qphone.base.util.QLog;
import cooperation.troop_homework.TroopHomeworkHelper.UploadFileTask;
import cooperation.troop_homework.jsp.TroopHWJsPlugin.UploadMediaEntry;

public class ampu
  implements Runnable
{
  public ampu(TroopHWJsPlugin.UploadMediaEntry paramUploadMediaEntry) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopHWJsPlugin", 2, "start upload!id = " + this.a.jdField_a_of_type_Int + " type = " + this.a.b);
    }
    this.a.jdField_a_of_type_CooperationTroop_homeworkTroopHomeworkHelper$UploadFileTask.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ampu
 * JD-Core Version:    0.7.0.1
 */