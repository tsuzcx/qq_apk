import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import com.tencent.mobileqq.msgbackup.fragment.MsgBackupDateFragment;
import com.tencent.qphone.base.util.QLog;

public class audo
  implements RadioGroup.OnCheckedChangeListener
{
  public audo(MsgBackupDateFragment paramMsgBackupDateFragment) {}
  
  public void onCheckedChanged(RadioGroup paramRadioGroup, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackup.BackupAndMigrateDateFragment", 2, "checkedId = " + paramInt);
    }
    switch (paramInt)
    {
    default: 
      return;
    case 2131364785: 
      MsgBackupDateFragment.a(this.a, 1);
      return;
    }
    MsgBackupDateFragment.a(this.a, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     audo
 * JD-Core Version:    0.7.0.1
 */