import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.config.ResourcePluginListener;
import com.tencent.mobileqq.studymode.KidModeAdvanceSettingFragment;
import com.tencent.mobileqq.studymode.KidModeAdvanceSettingFragment.5.1;
import com.tencent.qphone.base.util.QLog;

public class bcnp
  extends ResourcePluginListener
{
  public bcnp(KidModeAdvanceSettingFragment paramKidModeAdvanceSettingFragment) {}
  
  public void a(byte paramByte)
  {
    QLog.d("leba_study", 1, "notifyLebaState ");
    ThreadManager.excute(new KidModeAdvanceSettingFragment.5.1(this), 32, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcnp
 * JD-Core Version:    0.7.0.1
 */