import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnKeyListener;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.multimsg.save.FileSaveProgressView;
import com.tencent.qphone.base.util.QLog;

public class aupt
  extends Dialog
  implements View.OnClickListener
{
  private DialogInterface.OnKeyListener jdField_a_of_type_AndroidContentDialogInterface$OnKeyListener = new aupu(this);
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  public aupv a;
  private FileSaveProgressView jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveProgressView;
  
  public aupt(@NonNull Context paramContext)
  {
    super(paramContext, 2131755185);
    a(paramContext);
  }
  
  private void a()
  {
    setCanceledOnTouchOutside(false);
    setOnKeyListener(this.jdField_a_of_type_AndroidContentDialogInterface$OnKeyListener);
  }
  
  private void a(@NonNull Context paramContext)
  {
    paramContext = LayoutInflater.from(paramContext).inflate(2131559103, null);
    setContentView(paramContext);
    this.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveProgressView = ((FileSaveProgressView)paramContext.findViewById(2131376116));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramContext.findViewById(2131363909));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    a();
  }
  
  private void b()
  {
    if (isShowing()) {
      if (this.jdField_a_of_type_Aupv != null) {
        this.jdField_a_of_type_Aupv.a();
      }
    }
    try
    {
      super.cancel();
      return;
    }
    catch (Throwable localThrowable)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("FileSaveDialog", 2, "cancel dialog exception: " + localThrowable.getMessage());
    }
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveProgressView != null) {
      this.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveProgressView.setProgress(paramInt);
    }
  }
  
  public void a(aupv paramaupv)
  {
    this.jdField_a_of_type_Aupv = paramaupv;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    }
    b();
  }
  
  public void show()
  {
    if (!isShowing()) {}
    try
    {
      super.show();
      return;
    }
    catch (Throwable localThrowable)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("FileSaveDialog", 2, "show dialog exception: " + localThrowable.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aupt
 * JD-Core Version:    0.7.0.1
 */