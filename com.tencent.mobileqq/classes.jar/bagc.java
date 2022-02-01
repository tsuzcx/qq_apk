import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "view", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mobileqq/profilesetting/ProfileBasePrivacySettingAdapter$onBindViewHolder$3$1"}, k=3, mv={1, 1, 16})
final class bagc
  implements View.OnClickListener
{
  bagc(bafu parambafu, baft parambaft, bafy parambafy, int paramInt) {}
  
  public final void onClick(View paramView)
  {
    bafu localbafu = this.jdField_a_of_type_Bafu;
    Intrinsics.checkExpressionValueIsNotNull(paramView, "view");
    Object localObject = baft.a(this.jdField_a_of_type_Baft).get(this.jdField_a_of_type_Int);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "mData[position]");
    localbafu.b(paramView, (bagn)localObject);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bagc
 * JD-Core Version:    0.7.0.1
 */