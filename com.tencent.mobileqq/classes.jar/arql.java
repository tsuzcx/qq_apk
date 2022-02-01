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
import com.tencent.mobileqq.utils.ViewUtils;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/extendfriend/wiget/FillBirthdayDialog;", "Lcom/tencent/mobileqq/mini/ui/dialog/DialogFromBottom;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "initBirthday", "", "listener", "Lcom/tencent/mobileqq/extendfriend/wiget/FillBirthdayDialog$OnConfirmListener;", "(Landroid/content/Context;ILcom/tencent/mobileqq/extendfriend/wiget/FillBirthdayDialog$OnConfirmListener;)V", "birthdayPickHelper", "Lcom/tencent/mobileqq/activity/BirthdayPickHelper;", "confirmListener", "newBirthdayDay", "newBirthdayMonth", "newBirthdayUnion", "newBirthdayYear", "init", "", "Companion", "OnConfirmListener", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class arql
  extends DialogFromBottom
{
  public static final arqm a;
  private int jdField_a_of_type_Int;
  private acuy jdField_a_of_type_Acuy;
  private arqn jdField_a_of_type_Arqn;
  private int b;
  private int c;
  private int d;
  
  static
  {
    jdField_a_of_type_Arqm = new arqm(null);
  }
  
  public arql(@NotNull Context paramContext, int paramInt, @Nullable arqn paramarqn)
  {
    super(paramContext);
    this.jdField_a_of_type_Arqn = paramarqn;
    this.d = paramInt;
    a(paramContext, paramInt);
  }
  
  private final void a(Context paramContext, int paramInt)
  {
    Object localObject1 = LayoutInflater.from(paramContext).inflate(2131561050, null);
    if (localObject1 == null) {
      throw new TypeCastException("null cannot be cast to non-null type android.widget.LinearLayout");
    }
    localObject1 = (LinearLayout)localObject1;
    this.jdField_a_of_type_Acuy = new acuy(paramContext, paramInt, true);
    Object localObject2 = this.jdField_a_of_type_Acuy;
    if (localObject2 == null) {
      Intrinsics.throwNpe();
    }
    ((acuy)localObject2).a((acva)new arqo(this));
    localObject2 = this.jdField_a_of_type_Acuy;
    if (localObject2 == null) {
      Intrinsics.throwNpe();
    }
    localObject2 = ((acuy)localObject2).a();
    ((IphonePickerView)localObject2).setBackgroundColor(paramContext.getResources().getColor(2131165553));
    ((LinearLayout)localObject1).addView((View)localObject2, 2);
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "pickerView");
    paramContext = ((IphonePickerView)localObject2).getLayoutParams();
    if (paramContext == null) {
      throw new TypeCastException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
    }
    paramContext = (LinearLayout.LayoutParams)paramContext;
    paramContext.topMargin = ViewUtils.dpToPx(-2.0F);
    ((IphonePickerView)localObject2).setLayoutParams((ViewGroup.LayoutParams)paramContext);
    setContentView((View)localObject1);
    ((ImageView)((LinearLayout)localObject1).findViewById(2131362968)).setOnClickListener((View.OnClickListener)new arqp(this));
    setOnCancelListener((DialogInterface.OnCancelListener)arqq.a);
    ((Button)((LinearLayout)localObject1).findViewById(2131364983)).setOnClickListener((View.OnClickListener)new arqr(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arql
 * JD-Core Version:    0.7.0.1
 */