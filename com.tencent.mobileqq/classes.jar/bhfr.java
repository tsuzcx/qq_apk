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
import com.tencent.qqmini.sdk.utils.ColorUtils;
import java.lang.reflect.Field;

public class bhfr
  extends Dialog
  implements DialogInterface.OnCancelListener, View.OnClickListener
{
  private int jdField_a_of_type_Int;
  private NumberPicker jdField_a_of_type_AndroidWidgetNumberPicker;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private bhft jdField_a_of_type_Bhft;
  private String[] jdField_a_of_type_ArrayOfJavaLangString;
  private TextView b;
  
  public bhfr(@NonNull Context paramContext)
  {
    super(paramContext, 2131755367);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    paramContext = LayoutInflater.from(paramContext).inflate(2131559344, null);
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
    this.jdField_a_of_type_AndroidWidgetNumberPicker = ((NumberPicker)paramContext.findViewById(2131371298));
    this.b = ((TextView)paramContext.findViewById(2131378632));
    this.b.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramContext.findViewById(2131378667));
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
          localField.set(paramNumberPicker, new ColorDrawable(ColorUtils.parseColor("#3CB371")));
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
  
  public void a(int paramInt, bhft parambhft)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_AndroidWidgetNumberPicker.setOnValueChangedListener(new bhfs(this));
    this.jdField_a_of_type_Bhft = parambhft;
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
    if (this.jdField_a_of_type_Bhft != null) {
      this.jdField_a_of_type_Bhft.onValCancel();
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131378632)
    {
      if (this.jdField_a_of_type_Bhft != null) {
        this.jdField_a_of_type_Bhft.onValCancel();
      }
      a();
    }
    while (paramView.getId() != 2131378667) {
      return;
    }
    if (this.jdField_a_of_type_Bhft != null) {
      this.jdField_a_of_type_Bhft.onValConfirm(this.jdField_a_of_type_Int);
    }
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhfr
 * JD-Core Version:    0.7.0.1
 */