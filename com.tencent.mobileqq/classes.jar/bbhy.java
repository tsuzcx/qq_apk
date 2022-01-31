import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;

public class bbhy
  extends Dialog
  implements View.OnClickListener, CompoundButton.OnCheckedChangeListener
{
  private Context jdField_a_of_type_AndroidContentContext;
  private CheckBox jdField_a_of_type_AndroidWidgetCheckBox;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private bbhz jdField_a_of_type_Bbhz;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private boolean jdField_a_of_type_Boolean;
  private TextView b;
  private TextView c;
  private TextView d;
  
  public bbhy(Context paramContext, QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    super(paramContext, 2131690181);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Boolean = paramBoolean;
    a();
  }
  
  private void a()
  {
    setContentView(2131496741);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131299583));
    this.b = ((TextView)findViewById(2131299579));
    this.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)findViewById(2131298623));
    this.c = ((TextView)findViewById(2131299568));
    this.d = ((TextView)findViewById(2131299574));
    if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(ajjy.a(2131637340));
    }
    if (this.b != null) {
      this.b.setText(ajjy.a(2131637339));
    }
    if (this.jdField_a_of_type_AndroidWidgetCheckBox != null)
    {
      if (!this.jdField_a_of_type_Boolean) {
        break label231;
      }
      this.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetCheckBox.setText(ajjy.a(2131637341));
      this.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(baig.E(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c()));
      this.jdField_a_of_type_AndroidWidgetCheckBox.setOnCheckedChangeListener(this);
    }
    for (;;)
    {
      if (this.c != null)
      {
        this.c.setText(2131625035);
        this.c.setOnClickListener(this);
      }
      if (this.d != null)
      {
        this.d.setText(2131629116);
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
    awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A363", "0X800A363", paramInt, 0, "1", "", "", "");
  }
  
  public void a(bbhz parambbhz)
  {
    this.jdField_a_of_type_Bbhz = parambbhz;
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
    if (this.jdField_a_of_type_Boolean) {
      if (!this.jdField_a_of_type_AndroidWidgetCheckBox.isChecked()) {
        break label53;
      }
    }
    label53:
    for (i = 1;; i = 2) {
      switch (paramView.getId())
      {
      default: 
        return;
      }
    }
    dismiss();
    awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A365", "0X800A365", i, 0, "1", "", "", "");
    return;
    if (this.jdField_a_of_type_Bbhz != null)
    {
      this.jdField_a_of_type_Bbhz.a(this, paramView, a());
      if (this.jdField_a_of_type_Boolean) {
        baig.v(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), this.jdField_a_of_type_AndroidWidgetCheckBox.isChecked());
      }
      dismiss();
    }
    awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A364", "0X800A364", i, 0, "1", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bbhy
 * JD-Core Version:    0.7.0.1
 */