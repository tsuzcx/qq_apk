import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView;
import com.tencent.mobileqq.mini.ui.dialog.DialogFromBottom;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/extendfriend/wiget/FillBirthdayDialog;", "Lcom/tencent/mobileqq/mini/ui/dialog/DialogFromBottom;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "initBirthday", "", "listener", "Lcom/tencent/mobileqq/extendfriend/wiget/FillBirthdayDialog$OnConfirmListener;", "(Landroid/content/Context;ILcom/tencent/mobileqq/extendfriend/wiget/FillBirthdayDialog$OnConfirmListener;)V", "birthdayPickHelper", "Lcom/tencent/mobileqq/activity/BirthdayPickHelper;", "confirmListener", "newBirthdayDay", "newBirthdayMonth", "newBirthdayUnion", "newBirthdayYear", "init", "", "Companion", "OnConfirmListener", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class asnz
  extends DialogFromBottom
{
  public static final asoa a;
  private int jdField_a_of_type_Int;
  private adqp jdField_a_of_type_Adqp;
  private asob jdField_a_of_type_Asob;
  private int b;
  private int c;
  private int d;
  
  static
  {
    jdField_a_of_type_Asoa = new asoa(null);
  }
  
  public asnz(@NotNull Context paramContext, int paramInt, @Nullable asob paramasob)
  {
    super(paramContext);
    this.jdField_a_of_type_Asob = paramasob;
    this.d = paramInt;
    a(paramContext, paramInt);
  }
  
  private final void a(Context paramContext, int paramInt)
  {
    Object localObject1 = LayoutInflater.from(paramContext).inflate(2131561140, null);
    if (localObject1 == null) {
      throw new TypeCastException("null cannot be cast to non-null type android.widget.LinearLayout");
    }
    localObject1 = (LinearLayout)localObject1;
    this.jdField_a_of_type_Adqp = new adqp(paramContext, paramInt, true);
    Object localObject2 = this.jdField_a_of_type_Adqp;
    if (localObject2 == null) {
      Intrinsics.throwNpe();
    }
    ((adqp)localObject2).a((adqr)new asoc(this));
    localObject2 = this.jdField_a_of_type_Adqp;
    if (localObject2 == null) {
      Intrinsics.throwNpe();
    }
    localObject2 = ((adqp)localObject2).a();
    ((IphonePickerView)localObject2).setBackgroundColor(paramContext.getResources().getColor(2131165545));
    ((LinearLayout)localObject1).addView((View)localObject2, 2);
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "pickerView");
    paramContext = ((IphonePickerView)localObject2).getLayoutParams();
    if (paramContext == null) {
      throw new TypeCastException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
    }
    paramContext = (LinearLayout.LayoutParams)paramContext;
    paramContext.topMargin = bgtn.b(-2.0F);
    ((IphonePickerView)localObject2).setLayoutParams((ViewGroup.LayoutParams)paramContext);
    setContentView((View)localObject1);
    ((ImageView)((LinearLayout)localObject1).findViewById(2131362936)).setOnClickListener((View.OnClickListener)new asod(this));
    setOnCancelListener((DialogInterface.OnCancelListener)asoe.a);
    ((Button)((LinearLayout)localObject1).findViewById(2131364909)).setOnClickListener((View.OnClickListener)new asof(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asnz
 * JD-Core Version:    0.7.0.1
 */