import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "view", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mobileqq/profilesetting/ProfileBasePrivacySettingAdapter$onBindViewHolder$2$1"}, k=3, mv={1, 1, 16})
final class azrx
  implements View.OnClickListener
{
  azrx(azrq paramazrq, azrp paramazrp, azrt paramazrt, int paramInt) {}
  
  public final void onClick(View paramView)
  {
    azrq localazrq = this.jdField_a_of_type_Azrq;
    Intrinsics.checkExpressionValueIsNotNull(paramView, "view");
    Object localObject = azrp.a(this.jdField_a_of_type_Azrp).get(this.jdField_a_of_type_Int);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "mData[position]");
    localazrq.b(paramView, (azsj)localObject);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azrx
 * JD-Core Version:    0.7.0.1
 */