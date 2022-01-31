import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.res.Resources.NotFoundException;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.NumberPicker;
import android.widget.TextView;
import java.lang.reflect.Field;

public class bfeh
  extends Dialog
  implements DialogInterface.OnCancelListener, View.OnClickListener
{
  private int jdField_a_of_type_Int;
  private NumberPicker jdField_a_of_type_AndroidWidgetNumberPicker;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private bfej jdField_a_of_type_Bfej;
  private String[] jdField_a_of_type_ArrayOfJavaLangString;
  private TextView b;
  
  public bfeh(@NonNull Context paramContext)
  {
    super(paramContext, 2131755360);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    paramContext = LayoutInflater.from(paramContext).inflate(2131559260, null);
    setContentView(paramContext);
    Window localWindow = getWindow();
    if (localWindow != null)
    {
      localWindow.getDecorView().setPadding(0, 0, 0, 0);
      WindowManager.LayoutParams localLayoutParams = localWindow.getAttributes();
      localLayoutParams.width = -1;
      localLayoutParams.height = -2;
      localWindow.setAttributes(localLayoutParams);
      localWindow.setGravity(80);
    }
    this.jdField_a_of_type_AndroidWidgetNumberPicker = ((NumberPicker)paramContext.findViewById(2131370987));
    this.b = ((TextView)paramContext.findViewById(2131378078));
    this.b.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramContext.findViewById(2131378108));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    a(this.jdField_a_of_type_AndroidWidgetNumberPicker);
    setOnCancelListener(this);
  }
  
  private void a(NumberPicker paramNumberPicker)
  {
    Field[] arrayOfField = NumberPicker.class.getDeclaredFields();
    int j = arrayOfField.length;
    int i = 0;
    for (;;)
    {
      Field localField;
      if (i < j)
      {
        localField = arrayOfField[i];
        if (localField.getName().equals("mSelectionDivider")) {
          localField.setAccessible(true);
        }
      }
      else
      {
        try
        {
          localField.set(paramNumberPicker, new ColorDrawable(bffq.a("#3CB371")));
          return;
        }
        catch (IllegalArgumentException paramNumberPicker)
        {
          paramNumberPicker.printStackTrace();
          return;
        }
        catch (Resources.NotFoundException paramNumberPicker)
        {
          paramNumberPicker.printStackTrace();
          return;
        }
        catch (IllegalAccessException paramNumberPicker)
        {
          paramNumberPicker.printStackTrace();
          return;
        }
      }
      i += 1;
    }
  }
  
  public void a()
  {
    try
    {
      if (isShowing()) {
        dismiss();
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_AndroidWidgetNumberPicker.setMaxValue(paramInt);
  }
  
  public void a(int paramInt, bfej parambfej)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_AndroidWidgetNumberPicker.setOnValueChangedListener(new bfei(this));
    this.jdField_a_of_type_Bfej = parambfej;
  }
  
  public void a(String[] paramArrayOfString)
  {
    this.jdField_a_of_type_ArrayOfJavaLangString = paramArrayOfString;
    this.jdField_a_of_type_AndroidWidgetNumberPicker.setDisplayedValues(paramArrayOfString);
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_AndroidWidgetNumberPicker.setMinValue(paramInt);
  }
  
  public void c(int paramInt)
  {
    this.jdField_a_of_type_AndroidWidgetNumberPicker.setValue(paramInt);
  }
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    if (this.jdField_a_of_type_Bfej != null) {
      this.jdField_a_of_type_Bfej.onValCancel();
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131378078)
    {
      if (this.jdField_a_of_type_Bfej != null) {
        this.jdField_a_of_type_Bfej.onValCancel();
      }
      a();
    }
    while (paramView.getId() != 2131378108) {
      return;
    }
    if (this.jdField_a_of_type_Bfej != null) {
      this.jdField_a_of_type_Bfej.onValConfirm(this.jdField_a_of_type_Int);
    }
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bfeh
 * JD-Core Version:    0.7.0.1
 */