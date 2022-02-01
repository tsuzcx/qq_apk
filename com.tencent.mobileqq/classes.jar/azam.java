import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "view", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mobileqq/profilesetting/ProfileBasePrivacySettingAdapter$onBindViewHolder$1$1"}, k=3, mv={1, 1, 16})
final class azam
  implements View.OnClickListener
{
  azam(azag paramazag, azaf paramazaf, azah paramazah, int paramInt) {}
  
  public final void onClick(View paramView)
  {
    azag localazag = this.jdField_a_of_type_Azag;
    Intrinsics.checkExpressionValueIsNotNull(paramView, "view");
    localazag.a(paramView, (azaz)azaf.a(this.jdField_a_of_type_Azaf).get(this.jdField_a_of_type_Int));
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azam
 * JD-Core Version:    0.7.0.1
 */