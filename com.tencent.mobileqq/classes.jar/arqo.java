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

public class arqo
  extends RecyclerView.ViewHolder
  implements View.OnClickListener, CompoundButton.OnCheckedChangeListener
{
  public View a;
  private CheckBox jdField_a_of_type_AndroidWidgetCheckBox;
  private arqp jdField_a_of_type_Arqp;
  public RecentDynamicAvatarView a;
  public SingleLineTextView a;
  
  public arqo(arqn paramarqn, View paramView, arqp paramarqp)
  {
    super(paramView);
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)paramView.findViewById(2131302750));
    this.jdField_a_of_type_AndroidWidgetCheckBox.setButtonDrawable(2130838739);
    this.jdField_a_of_type_AndroidWidgetCheckBox.setOnCheckedChangeListener(null);
    this.jdField_a_of_type_AndroidWidgetCheckBox.setOnCheckedChangeListener(this);
    this.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView = ((RecentDynamicAvatarView)paramView.findViewById(2131302713));
    this.jdField_a_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)paramView.findViewById(2131302759));
    this.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setTextColor(arqn.a(paramarqn).getResources().getColor(2131101267));
    this.jdField_a_of_type_Arqp = paramarqp;
    paramarqn.a(this.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView);
    paramView.setOnClickListener(this);
    paramView.setTag(this);
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Arqp != null)
    {
      int i = getAdapterPosition();
      if (QLog.isColorLevel()) {
        QLog.i("MsgBackup.BackupAndMigrateListAdapter", 2, "BackupAndMigrateItemHolder onCheckedChanged: " + i + ", isChecked = " + paramBoolean);
      }
      this.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(paramBoolean);
      arqn.a(this.jdField_a_of_type_Arqn).setValueAt(i, Boolean.valueOf(paramBoolean));
      this.jdField_a_of_type_Arqp.a(this.jdField_a_of_type_AndroidWidgetCheckBox.isChecked(), (RecentBaseData)arqn.a(this.jdField_a_of_type_Arqn).get(i));
    }
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_Arqp != null)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     arqo
 * JD-Core Version:    0.7.0.1
 */