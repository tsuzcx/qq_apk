import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.res.Resources.NotFoundException;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.NumberPicker;
import android.widget.TextView;
import com.tencent.qqmini.sdk.runtime.widget.MiniNumberPicker;
import java.lang.reflect.Field;
import java.util.ArrayList;

public class bfee
  extends Dialog
  implements DialogInterface.OnCancelListener, View.OnClickListener
{
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private bfeg jdField_a_of_type_Bfeg;
  private ArrayList<NumberPicker> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private int[] jdField_a_of_type_ArrayOfInt;
  private String[][] jdField_a_of_type_Array2dOfJavaLangString;
  private TextView b;
  
  public bfee(@NonNull Context paramContext)
  {
    super(paramContext, 2131755360);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    paramContext = LayoutInflater.from(paramContext).inflate(2131559268, null);
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
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramContext.findViewById(2131370599));
    this.b = ((TextView)paramContext.findViewById(2131370600));
    this.b.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramContext.findViewById(2131370601));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
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
  
  public void a(int paramInt1, int paramInt2, String[] paramArrayOfString)
  {
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0)) {}
    do
    {
      do
      {
        return;
      } while ((this.jdField_a_of_type_JavaUtilArrayList == null) || (paramInt1 >= this.jdField_a_of_type_JavaUtilArrayList.size()));
      NumberPicker localNumberPicker = (NumberPicker)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt1);
      localNumberPicker.setDisplayedValues(null);
      localNumberPicker.setMaxValue(paramArrayOfString.length - 1);
      localNumberPicker.setDisplayedValues(paramArrayOfString);
      localNumberPicker.setValue(paramInt2);
    } while ((paramInt1 >= this.jdField_a_of_type_ArrayOfInt.length) || (paramInt1 < 0));
    this.jdField_a_of_type_ArrayOfInt[paramInt1] = paramInt2;
  }
  
  public void a(bfeg parambfeg)
  {
    this.jdField_a_of_type_Bfeg = parambfeg;
  }
  
  public void a(int[] paramArrayOfInt)
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.size() == 0)) {}
    for (;;)
    {
      return;
      if ((paramArrayOfInt != null) && (paramArrayOfInt.length == this.jdField_a_of_type_JavaUtilArrayList.size()))
      {
        this.jdField_a_of_type_ArrayOfInt = paramArrayOfInt;
        int i = 0;
        while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
        {
          ((NumberPicker)this.jdField_a_of_type_JavaUtilArrayList.get(i)).setValue(paramArrayOfInt[i]);
          i += 1;
        }
      }
    }
  }
  
  public void a(String[][] paramArrayOfString)
  {
    this.jdField_a_of_type_Array2dOfJavaLangString = paramArrayOfString;
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount() > 0) {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
    }
    this.jdField_a_of_type_ArrayOfInt = null;
    if (paramArrayOfString != null)
    {
      this.jdField_a_of_type_ArrayOfInt = new int[paramArrayOfString.length];
      int i = 0;
      if (i < paramArrayOfString.length)
      {
        if (Build.VERSION.SDK_INT >= 16) {}
        for (Object localObject = new MiniNumberPicker(getContext());; localObject = new NumberPicker(getContext()))
        {
          if (paramArrayOfString[i].length > 0)
          {
            ((NumberPicker)localObject).setDisplayedValues(paramArrayOfString[i]);
            ((NumberPicker)localObject).setMinValue(0);
            ((NumberPicker)localObject).setMaxValue(paramArrayOfString[i].length - 1);
          }
          ((NumberPicker)localObject).setOnValueChangedListener(new bfef(this, i));
          a((NumberPicker)localObject);
          this.jdField_a_of_type_JavaUtilArrayList.add(localObject);
          LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(0, -2);
          localLayoutParams.weight = 1.0F;
          localLayoutParams.setMargins(10, 10, 10, 10);
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject, localLayoutParams);
          i += 1;
          break;
        }
      }
    }
  }
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    if (this.jdField_a_of_type_Bfeg != null) {
      this.jdField_a_of_type_Bfeg.onValCancel();
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131370600)
    {
      if (this.jdField_a_of_type_Bfeg != null) {
        this.jdField_a_of_type_Bfeg.onValCancel();
      }
      a();
    }
    while (paramView.getId() != 2131370601) {
      return;
    }
    if (this.jdField_a_of_type_Bfeg != null) {
      this.jdField_a_of_type_Bfeg.onValConfirm(this.jdField_a_of_type_ArrayOfInt);
    }
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bfee
 * JD-Core Version:    0.7.0.1
 */