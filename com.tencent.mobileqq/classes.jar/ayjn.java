import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ImageButton;
import android.widget.TextView;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.teamworkforgroup.TroopTeamWorkFileSearchDialog.6.1;
import com.tencent.mobileqq.troop.widget.CountdownTimeTask;
import com.tencent.qphone.base.util.QLog;

public class ayjn
  implements TextWatcher
{
  ayjn(ayjh paramayjh) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    if (this.a.d) {
      this.a.d = false;
    }
    do
    {
      return;
      if (paramEditable == null) {}
      for (paramEditable = ""; paramEditable.trim().equals(""); paramEditable = paramEditable.toString())
      {
        this.a.c();
        return;
      }
      this.a.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(0);
      if (!bbfj.g(this.a.jdField_a_of_type_AndroidAppActivity))
      {
        if (this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetCountdownTimeTask != null)
        {
          this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetCountdownTimeTask.b();
          this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetCountdownTimeTask = null;
        }
        this.a.b();
        return;
      }
      this.a.c = false;
      if (this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetCountdownTimeTask == null)
      {
        this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetCountdownTimeTask = new CountdownTimeTask(new TroopTeamWorkFileSearchDialog.6.1(this), 800);
        ThreadManager.post(this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetCountdownTimeTask, 5, null, true);
        return;
      }
      if (this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetCountdownTimeTask.a() > 0L)
      {
        this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetCountdownTimeTask.a();
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.e("TroopTeamWorkFileSearchDialog", 2, "!!!!!! 这是个什么情况,逻辑出错了 !!!!!!!!!!!!!!!!!!!!!!!!!!!!");
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((!this.a.d) || ((this.a.d) && (this.a.jdField_b_of_type_Int <= 0)))
    {
      this.a.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      return;
    }
    this.a.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ayjn
 * JD-Core Version:    0.7.0.1
 */