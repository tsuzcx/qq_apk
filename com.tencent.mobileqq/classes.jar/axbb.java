import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import com.tencent.mobileqq.msgbackup.fragment.MsgBackupDateFragment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class axbb
  implements RadioGroup.OnCheckedChangeListener
{
  public axbb(MsgBackupDateFragment paramMsgBackupDateFragment) {}
  
  public void onCheckedChanged(RadioGroup paramRadioGroup, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackup.BackupAndMigrateDateFragment", 2, "checkedId = " + paramInt);
    }
    switch (paramInt)
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onCheckedChanged(paramRadioGroup, paramInt);
      return;
      MsgBackupDateFragment.a(this.a, 1);
      continue;
      MsgBackupDateFragment.a(this.a, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axbb
 * JD-Core Version:    0.7.0.1
 */