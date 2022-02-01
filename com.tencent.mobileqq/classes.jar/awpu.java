import android.view.View;
import com.tencent.mobileqq.msgbackup.fragment.MsgBackupTransportFragment;
import com.tencent.qphone.base.util.QLog;

public class awpu
  implements biea
{
  public awpu(MsgBackupTransportFragment paramMsgBackupTransportFragment) {}
  
  public void onItemSelect(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 2: 
      MsgBackupTransportFragment.a(this.a);
      if (QLog.isColorLevel()) {
        QLog.d("MsgBackup.MsgBackupTransportFragment", 2, "transfer is going, page is in link page! click cancel btn! sIsShouQiBtnClick= " + awnr.jdField_a_of_type_Boolean + ", isStart = " + this.a.jdField_a_of_type_Boolean);
      }
      if (MsgBackupTransportFragment.a(this.a) == 2)
      {
        if (!this.a.jdField_d_of_type_Boolean) {
          break label129;
        }
        awqs.a("0X800A243", 2);
      }
      while (this.a.jdField_a_of_type_Boolean)
      {
        this.a.k();
        return;
        label129:
        awqs.a("0X800A243", 1);
      }
      if (MsgBackupTransportFragment.a(this.a) == 1)
      {
        this.a.onBackEvent();
        return;
      }
      this.a.a(this.a.getActivity());
      return;
    }
    awnr.jdField_a_of_type_Boolean = true;
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackup.MsgBackupTransportFragment", 2, "transfer is going, page is in link page! click 收起按钮! sIsShouQiBtnClick= " + awnr.jdField_a_of_type_Boolean + ", curSpeed = " + this.a.jdField_a_of_type_Long + ", hasFinishedCount = " + this.a.jdField_d_of_type_Int);
    }
    awnr.a().a(this.a.jdField_a_of_type_Long, this.a.jdField_d_of_type_Int, 3, this.a.getActivity());
    awqs.a("0X800A249");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awpu
 * JD-Core Version:    0.7.0.1
 */