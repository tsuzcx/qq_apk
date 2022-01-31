import android.text.TextUtils;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import com.tencent.mobileqq.msgbackup.fragment.MsgBackupDateFragment;

public class asmo
  implements RadioGroup.OnCheckedChangeListener
{
  public asmo(MsgBackupDateFragment paramMsgBackupDateFragment) {}
  
  public void onCheckedChanged(RadioGroup paramRadioGroup, int paramInt)
  {
    switch (paramInt)
    {
    }
    while (MsgBackupDateFragment.a(this.a)) {
      if ((MsgBackupDateFragment.b(this.a)) && (MsgBackupDateFragment.c(this.a)))
      {
        this.a.setRightButtonEnable(true);
        return;
        MsgBackupDateFragment.a(this.a, false);
        MsgBackupDateFragment.a(this.a, 0L);
        MsgBackupDateFragment.b(this.a, 0L);
        MsgBackupDateFragment.a(this.a).setVisibility(8);
        continue;
        MsgBackupDateFragment.a(this.a, true);
        MsgBackupDateFragment.a(this.a).setVisibility(0);
      }
      else
      {
        if ((!TextUtils.isEmpty(MsgBackupDateFragment.a(this.a))) && (!TextUtils.isEmpty(MsgBackupDateFragment.b(this.a))))
        {
          this.a.setRightButtonEnable(true);
          return;
        }
        this.a.setRightButtonEnable(false);
        return;
      }
    }
    this.a.setRightButtonEnable(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     asmo
 * JD-Core Version:    0.7.0.1
 */