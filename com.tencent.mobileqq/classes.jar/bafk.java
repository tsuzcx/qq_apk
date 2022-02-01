import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "view", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mobileqq/profilesetting/ActionSheetPrivacySelectAdapter$onBindViewHolder$1$1"}, k=3, mv={1, 1, 16})
final class bafk
  implements View.OnClickListener
{
  bafk(bafj parambafj, bafg parambafg, bafi parambafi, int paramInt) {}
  
  public final void onClick(View paramView)
  {
    bafj localbafj = this.jdField_a_of_type_Bafj;
    Intrinsics.checkExpressionValueIsNotNull(paramView, "view");
    localbafj.a(paramView, (bafh)bafg.a(this.jdField_a_of_type_Bafg).get(this.jdField_a_of_type_Int));
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bafk
 * JD-Core Version:    0.7.0.1
 */