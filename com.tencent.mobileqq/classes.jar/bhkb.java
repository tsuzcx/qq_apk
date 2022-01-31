import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.NonNull;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.FrameLayout;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.TimePicker;
import com.tencent.qqmini.sdk.utils.ColorUtils;
import java.lang.reflect.Field;

public class bhkb
  extends Dialog
  implements DialogInterface.OnCancelListener, View.OnClickListener
{
  private int jdField_a_of_type_Int;
  private NumberPicker jdField_a_of_type_AndroidWidgetNumberPicker;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private TimePicker jdField_a_of_type_AndroidWidgetTimePicker;
  private bhkd jdField_a_of_type_Bhkd;
  private int jdField_b_of_type_Int;
  private NumberPicker jdField_b_of_type_AndroidWidgetNumberPicker;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private int c;
  private int d;
  
  public bhkb(@NonNull Context paramContext)
  {
    super(paramContext, 2131755367);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    paramContext = LayoutInflater.from(paramContext).inflate(2131559342, null);
    setContentView(paramContext);
    Object localObject = getWindow();
    if (localObject != null)
    {
      ((Window)localObject).getDecorView().setPadding(0, 0, 0, 0);
      WindowManager.LayoutParams localLayoutParams = ((Window)localObject).getAttributes();
      localLayoutParams.width = -1;
      localLayoutParams.height = -2;
      ((Window)localObject).setAttributes(localLayoutParams);
      ((Window)localObject).setGravity(80);
    }
    localObject = (FrameLayout)paramContext.findViewById(2131371992);
    this.jdField_a_of_type_AndroidWidgetTimePicker = new TimePicker(new ContextThemeWrapper(getContext(), 16973934));
    ((FrameLayout)localObject).addView(this.jdField_a_of_type_AndroidWidgetTimePicker);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramContext.findViewById(2131378686));
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramContext.findViewById(2131378721));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    int i = Resources.getSystem().getIdentifier("hour", "id", "android");
    int j = Resources.getSystem().getIdentifier("minute", "id", "android");
    int k = Resources.getSystem().getIdentifier("amPm", "id", "android");
    this.jdField_a_of_type_AndroidWidgetNumberPicker = ((NumberPicker)this.jdField_a_of_type_AndroidWidgetTimePicker.findViewById(i));
    this.jdField_b_of_type_AndroidWidgetNumberPicker = ((NumberPicker)this.jdField_a_of_type_AndroidWidgetTimePicker.findViewById(j));
    paramContext = (NumberPicker)this.jdField_a_of_type_AndroidWidgetTimePicker.findViewById(k);
    a(this.jdField_a_of_type_AndroidWidgetNumberPicker);
    a(this.jdField_b_of_type_AndroidWidgetNumberPicker);
    a(paramContext);
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
  
  public void a(int paramInt1, int paramInt2, bhkd parambhkd)
  {
    this.jdField_a_of_type_AndroidWidgetTimePicker.setCurrentHour(Integer.valueOf(paramInt1));
    this.jdField_a_of_type_AndroidWidgetTimePicker.setCurrentMinute(Integer.valueOf(paramInt2));
    this.jdField_a_of_type_AndroidWidgetTimePicker.setOnTimeChangedListener(new bhkc(this));
    this.jdField_a_of_type_Bhkd = parambhkd;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidWidgetTimePicker.setIs24HourView(Boolean.valueOf(paramBoolean));
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_AndroidWidgetNumberPicker.setMinValue(paramInt);
  }
  
  public void c(int paramInt)
  {
    this.c = paramInt;
  }
  
  public void d(int paramInt)
  {
    this.d = paramInt;
  }
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    if (this.jdField_a_of_type_Bhkd != null) {
      this.jdField_a_of_type_Bhkd.onTimeCancel();
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131378686)
    {
      if (this.jdField_a_of_type_Bhkd != null) {
        this.jdField_a_of_type_Bhkd.onTimeCancel();
      }
      a();
    }
    while (paramView.getId() != 2131378721) {
      return;
    }
    if (this.jdField_a_of_type_Bhkd != null)
    {
      Object localObject = String.valueOf(this.jdField_a_of_type_Int);
      paramView = (View)localObject;
      if (this.jdField_a_of_type_Int < 10) {
        paramView = "0" + (String)localObject;
      }
      String str = String.valueOf(this.jdField_b_of_type_Int);
      localObject = str;
      if (this.jdField_b_of_type_Int < 10) {
        localObject = "0" + str;
      }
      this.jdField_a_of_type_Bhkd.onTimeConfirm(paramView, (String)localObject);
    }
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhkb
 * JD-Core Version:    0.7.0.1
 */