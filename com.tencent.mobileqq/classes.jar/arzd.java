import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.Toast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k=3, mv={1, 1, 16})
public final class arzd
  implements View.OnClickListener
{
  public arzd(View paramView, EditText paramEditText1, EditText paramEditText2) {}
  
  public final void onClick(View paramView)
  {
    Object localObject1 = this.jdField_a_of_type_AndroidWidgetEditText;
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "etAdCode");
    localObject1 = ((EditText)localObject1).getText().toString();
    Object localObject2 = this.b;
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "etBusiness");
    localObject2 = ((EditText)localObject2).getText().toString();
    if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!TextUtils.isEmpty((CharSequence)localObject2)))
    {
      Context localContext = this.jdField_a_of_type_AndroidViewView.getContext();
      Intrinsics.checkExpressionValueIsNotNull(localContext, "context");
      amfb.a(localContext, (String)localObject1, (String)localObject2);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      Toast.makeText(this.jdField_a_of_type_AndroidViewView.getContext(), (CharSequence)("Invalid adcode=" + (String)localObject1 + " or businessId=" + (String)localObject2), 1).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arzd
 * JD-Core Version:    0.7.0.1
 */