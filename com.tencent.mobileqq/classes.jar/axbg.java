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
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.RecentDynamicAvatarView;
import com.tencent.widget.SingleLineTextView;
import java.util.List;

public class axbg
  extends RecyclerView.ViewHolder
  implements View.OnClickListener, CompoundButton.OnCheckedChangeListener
{
  public View a;
  private CheckBox jdField_a_of_type_AndroidWidgetCheckBox;
  private axbh jdField_a_of_type_Axbh;
  public RecentDynamicAvatarView a;
  public SingleLineTextView a;
  
  public axbg(axbf paramaxbf, View paramView, axbh paramaxbh)
  {
    super(paramView);
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)paramView.findViewById(2131369172));
    this.jdField_a_of_type_AndroidWidgetCheckBox.setButtonDrawable(2130839151);
    this.jdField_a_of_type_AndroidWidgetCheckBox.setOnCheckedChangeListener(null);
    this.jdField_a_of_type_AndroidWidgetCheckBox.setOnCheckedChangeListener(this);
    this.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView = ((RecentDynamicAvatarView)paramView.findViewById(2131369100));
    this.jdField_a_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)paramView.findViewById(2131369182));
    this.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setTextColor(axbf.a(paramaxbf).getResources().getColor(2131167033));
    this.jdField_a_of_type_Axbh = paramaxbh;
    paramaxbf.a(this.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView);
    paramView.setOnClickListener(this);
    paramView.setTag(this);
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Axbh != null)
    {
      int i = getAdapterPosition();
      if (QLog.isColorLevel()) {
        QLog.i("MsgBackup.BackupAndMigrateListAdapter", 2, "BackupAndMigrateItemHolder onCheckedChanged: " + i + ", isChecked = " + paramBoolean);
      }
      this.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(paramBoolean);
      axbf.a(this.jdField_a_of_type_Axbf).setValueAt(i, Boolean.valueOf(paramBoolean));
      this.jdField_a_of_type_Axbh.a(this.jdField_a_of_type_AndroidWidgetCheckBox.isChecked(), (RecentBaseData)axbf.a(this.jdField_a_of_type_Axbf).get(i));
    }
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
  
  public void onClick(View paramView)
  {
    CheckBox localCheckBox;
    if (this.jdField_a_of_type_Axbh != null)
    {
      bool = this.jdField_a_of_type_AndroidWidgetCheckBox.isChecked();
      localCheckBox = this.jdField_a_of_type_AndroidWidgetCheckBox;
      if (bool) {
        break label39;
      }
    }
    label39:
    for (boolean bool = true;; bool = false)
    {
      localCheckBox.setChecked(bool);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axbg
 * JD-Core Version:    0.7.0.1
 */