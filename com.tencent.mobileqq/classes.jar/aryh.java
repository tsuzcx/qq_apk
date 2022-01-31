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

public class aryh
  extends Dialog
  implements View.OnClickListener
{
  private DialogInterface.OnKeyListener jdField_a_of_type_AndroidContentDialogInterface$OnKeyListener = new aryi(this);
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  public aryj a;
  private FileSaveProgressView jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveProgressView;
  
  public aryh(@NonNull Context paramContext)
  {
    super(paramContext, 2131689645);
    a(paramContext);
  }
  
  private void a()
  {
    setCanceledOnTouchOutside(false);
    setOnKeyListener(this.jdField_a_of_type_AndroidContentDialogInterface$OnKeyListener);
  }
  
  private void a(@NonNull Context paramContext)
  {
    paramContext = LayoutInflater.from(paramContext).inflate(2131493494, null);
    setContentView(paramContext);
    this.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveProgressView = ((FileSaveProgressView)paramContext.findViewById(2131309811));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramContext.findViewById(2131298297));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    a();
  }
  
  private void b()
  {
    if (isShowing()) {
      if (this.jdField_a_of_type_Aryj != null) {
        this.jdField_a_of_type_Aryj.a();
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
  
  public void a(aryj paramaryj)
  {
    this.jdField_a_of_type_Aryj = paramaryj;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     aryh
 * JD-Core Version:    0.7.0.1
 */