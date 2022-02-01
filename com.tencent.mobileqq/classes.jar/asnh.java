import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k=3, mv={1, 1, 16})
final class asnh
  implements View.OnClickListener
{
  asnh(asnf paramasnf) {}
  
  public final void onClick(View paramView)
  {
    Intrinsics.checkExpressionValueIsNotNull(paramView, "v");
    Object localObject = paramView.getTag();
    if (localObject == null) {
      throw new TypeCastException("null cannot be cast to non-null type kotlin.Int");
    }
    int i = ((Integer)localObject).intValue();
    localObject = asnf.a(this.a);
    if (localObject == null) {
      Intrinsics.throwNpe();
    }
    localObject = (askj)((List)localObject).get(i);
    if (QLog.isColorLevel()) {
      QLog.d("CompletePersonalDataDialog", 2, "onClick position = " + i);
    }
    asnf.a(this.a, (askj)localObject);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asnh
 * JD-Core Version:    0.7.0.1
 */