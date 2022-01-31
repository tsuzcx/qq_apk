import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.util.SparseArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.RecentDynamicAvatarView;
import com.tencent.widget.SingleLineTextView;
import java.util.List;

public class audt
  extends RecyclerView.ViewHolder
  implements View.OnClickListener, CompoundButton.OnCheckedChangeListener
{
  public View a;
  private CheckBox jdField_a_of_type_AndroidWidgetCheckBox;
  private audu jdField_a_of_type_Audu;
  public RecentDynamicAvatarView a;
  public SingleLineTextView a;
  
  public audt(auds paramauds, View paramView, audu paramaudu)
  {
    super(paramView);
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)paramView.findViewById(2131368557));
    this.jdField_a_of_type_AndroidWidgetCheckBox.setButtonDrawable(2130838921);
    this.jdField_a_of_type_AndroidWidgetCheckBox.setOnCheckedChangeListener(null);
    this.jdField_a_of_type_AndroidWidgetCheckBox.setOnCheckedChangeListener(this);
    this.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView = ((RecentDynamicAvatarView)paramView.findViewById(2131368507));
    this.jdField_a_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)paramView.findViewById(2131368566));
    this.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setTextColor(auds.a(paramauds).getResources().getColor(2131166908));
    this.jdField_a_of_type_Audu = paramaudu;
    paramauds.a(this.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView);
    paramView.setOnClickListener(this);
    paramView.setTag(this);
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Audu != null)
    {
      int i = getAdapterPosition();
      if (QLog.isColorLevel()) {
        QLog.i("MsgBackup.BackupAndMigrateListAdapter", 2, "BackupAndMigrateItemHolder onCheckedChanged: " + i + ", isChecked = " + paramBoolean);
      }
      this.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(paramBoolean);
      auds.a(this.jdField_a_of_type_Auds).setValueAt(i, Boolean.valueOf(paramBoolean));
      this.jdField_a_of_type_Audu.a(this.jdField_a_of_type_AndroidWidgetCheckBox.isChecked(), (RecentBaseData)auds.a(this.jdField_a_of_type_Auds).get(i));
    }
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_Audu != null)
    {
      bool = this.jdField_a_of_type_AndroidWidgetCheckBox.isChecked();
      paramView = this.jdField_a_of_type_AndroidWidgetCheckBox;
      if (bool) {
        break label32;
      }
    }
    label32:
    for (boolean bool = true;; bool = false)
    {
      paramView.setChecked(bool);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     audt
 * JD-Core Version:    0.7.0.1
 */