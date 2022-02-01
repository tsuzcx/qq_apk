import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;

public class bint
  extends ReportDialog
  implements View.OnClickListener, CompoundButton.OnCheckedChangeListener
{
  private Context jdField_a_of_type_AndroidContentContext;
  private CheckBox jdField_a_of_type_AndroidWidgetCheckBox;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private binu jdField_a_of_type_Binu;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private boolean jdField_a_of_type_Boolean;
  private TextView b;
  private TextView c;
  private TextView d;
  
  public bint(Context paramContext, QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    super(paramContext, 2131755829);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Boolean = paramBoolean;
    a();
  }
  
  private void a()
  {
    setContentView(2131562785);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131365648));
    this.b = ((TextView)findViewById(2131365644));
    this.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)findViewById(2131364596));
    this.c = ((TextView)findViewById(2131365633));
    this.d = ((TextView)findViewById(2131365639));
    if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(anvx.a(2131702610));
    }
    if (this.b != null) {
      this.b.setText(anvx.a(2131702609));
    }
    if (this.jdField_a_of_type_AndroidWidgetCheckBox != null)
    {
      if (!this.jdField_a_of_type_Boolean) {
        break label231;
      }
      this.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetCheckBox.setText(anvx.a(2131702611));
      this.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(bhhr.C(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin()));
      this.jdField_a_of_type_AndroidWidgetCheckBox.setOnCheckedChangeListener(this);
    }
    for (;;)
    {
      if (this.c != null)
      {
        this.c.setText(2131690697);
        this.c.setOnClickListener(this);
      }
      if (this.d != null)
      {
        this.d.setText(2131694399);
        this.d.setOnClickListener(this);
      }
      setCancelable(true);
      setCanceledOnTouchOutside(true);
      return;
      label231:
      this.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(false);
    }
  }
  
  public void a(int paramInt)
  {
    super.show();
    bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A363", "0X800A363", paramInt, 0, "1", "", "", "");
  }
  
  public void a(binu parambinu)
  {
    this.jdField_a_of_type_Binu = parambinu;
  }
  
  @Deprecated
  public void a(String paramString)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_AndroidWidgetCheckBox != null) {
      return this.jdField_a_of_type_AndroidWidgetCheckBox.isChecked();
    }
    return false;
  }
  
  public void b(String paramString)
  {
    this.b.setText(paramString);
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean) {}
  
  public void onClick(View paramView)
  {
    int i = 3;
    if (this.jdField_a_of_type_Boolean)
    {
      if (this.jdField_a_of_type_AndroidWidgetCheckBox.isChecked()) {
        i = 1;
      }
    }
    else {
      switch (paramView.getId())
      {
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      i = 2;
      break;
      dismiss();
      bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A365", "0X800A365", i, 0, "1", "", "", "");
      continue;
      if (this.jdField_a_of_type_Binu != null)
      {
        this.jdField_a_of_type_Binu.a(this, paramView, a());
        if (this.jdField_a_of_type_Boolean) {
          bhhr.v(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), this.jdField_a_of_type_AndroidWidgetCheckBox.isChecked());
        }
        dismiss();
      }
      bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A364", "0X800A364", i, 0, "1", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bint
 * JD-Core Version:    0.7.0.1
 */