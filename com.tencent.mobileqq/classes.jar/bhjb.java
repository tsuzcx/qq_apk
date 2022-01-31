import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.res.Resources.NotFoundException;
import android.graphics.drawable.ColorDrawable;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.DatePicker;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.NumberPicker;
import android.widget.TextView;
import com.tencent.qqmini.sdk.utils.ColorUtils;
import java.lang.reflect.Field;

public class bhjb
  extends Dialog
  implements DialogInterface.OnCancelListener, View.OnClickListener
{
  private int jdField_a_of_type_Int;
  private DatePicker jdField_a_of_type_AndroidWidgetDatePicker;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private bhjd jdField_a_of_type_Bhjd;
  private int jdField_b_of_type_Int;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private int c;
  
  public bhjb(Context paramContext)
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
    this.jdField_a_of_type_AndroidWidgetDatePicker = new DatePicker(new ContextThemeWrapper(getContext(), 16973934));
    this.jdField_a_of_type_AndroidWidgetDatePicker.setCalendarViewShown(false);
    ((FrameLayout)localObject).addView(this.jdField_a_of_type_AndroidWidgetDatePicker);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramContext.findViewById(2131378686));
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramContext.findViewById(2131378721));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    a(this.jdField_a_of_type_AndroidWidgetDatePicker);
    setOnCancelListener(this);
  }
  
  private void a(DatePicker paramDatePicker)
  {
    paramDatePicker = (LinearLayout)((LinearLayout)paramDatePicker.getChildAt(0)).getChildAt(0);
    int i = 0;
    if (i < paramDatePicker.getChildCount())
    {
      NumberPicker localNumberPicker = (NumberPicker)paramDatePicker.getChildAt(i);
      Field[] arrayOfField = NumberPicker.class.getDeclaredFields();
      int k = arrayOfField.length;
      int j = 0;
      for (;;)
      {
        for (;;)
        {
          Field localField;
          if (j < k)
          {
            localField = arrayOfField[j];
            if (localField.getName().equals("mSelectionDivider")) {
              localField.setAccessible(true);
            }
          }
          else
          {
            try
            {
              localField.set(localNumberPicker, new ColorDrawable(ColorUtils.parseColor("#3CB371")));
              i += 1;
            }
            catch (IllegalArgumentException localIllegalArgumentException)
            {
              for (;;)
              {
                localIllegalArgumentException.printStackTrace();
              }
            }
            catch (Resources.NotFoundException localNotFoundException)
            {
              for (;;)
              {
                localNotFoundException.printStackTrace();
              }
            }
            catch (IllegalAccessException localIllegalAccessException)
            {
              for (;;)
              {
                localIllegalAccessException.printStackTrace();
              }
            }
          }
        }
        j += 1;
      }
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
    if (this.jdField_a_of_type_AndroidWidgetDatePicker != null) {
      ((ViewGroup)((ViewGroup)this.jdField_a_of_type_AndroidWidgetDatePicker.getChildAt(0)).getChildAt(0)).getChildAt(0).setVisibility(paramInt);
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    this.c = paramInt3;
    this.jdField_a_of_type_AndroidWidgetDatePicker.updateDate(paramInt1, paramInt2, paramInt3);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, bhjd parambhjd)
  {
    this.jdField_a_of_type_AndroidWidgetDatePicker.init(paramInt1, paramInt2, paramInt3, new bhjc(this));
    this.jdField_a_of_type_Bhjd = parambhjd;
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_AndroidWidgetDatePicker.setMinDate(paramLong);
  }
  
  public void b(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidWidgetDatePicker != null) {
      ((ViewGroup)((ViewGroup)this.jdField_a_of_type_AndroidWidgetDatePicker.getChildAt(0)).getChildAt(0)).getChildAt(1).setVisibility(paramInt);
    }
  }
  
  public void b(long paramLong)
  {
    this.jdField_a_of_type_AndroidWidgetDatePicker.setMaxDate(paramLong);
  }
  
  public void c(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidWidgetDatePicker != null) {
      ((ViewGroup)((ViewGroup)this.jdField_a_of_type_AndroidWidgetDatePicker.getChildAt(0)).getChildAt(0)).getChildAt(2).setVisibility(paramInt);
    }
  }
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    if (this.jdField_a_of_type_Bhjd != null) {
      this.jdField_a_of_type_Bhjd.onDateCancel();
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131378686)
    {
      if (this.jdField_a_of_type_Bhjd != null) {
        this.jdField_a_of_type_Bhjd.onDateCancel();
      }
      a();
    }
    while (paramView.getId() != 2131378721) {
      return;
    }
    int i;
    if (this.jdField_a_of_type_Bhjd != null)
    {
      i = this.jdField_b_of_type_Int + 1;
      if (i >= 10) {
        break label133;
      }
      paramView = "0" + i;
      i = this.c;
      if (i >= 10) {
        break label141;
      }
    }
    label133:
    label141:
    for (String str = "0" + i;; str = String.valueOf(i))
    {
      this.jdField_a_of_type_Bhjd.onDateConfirm(String.valueOf(this.jdField_a_of_type_Int), paramView, str);
      a();
      return;
      paramView = String.valueOf(i);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhjb
 * JD-Core Version:    0.7.0.1
 */