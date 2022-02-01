import android.view.View;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.tencent.mobileqq.widget.FormSwitchItem;
import kotlin.Metadata;
import kotlin.TypeCastException;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/profilesetting/ProfileBasePrivacySettingAdapter$ProfileOtherHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "profileOtherSettingItem", "Lcom/tencent/mobileqq/widget/FormSwitchItem;", "getProfileOtherSettingItem", "()Lcom/tencent/mobileqq/widget/FormSwitchItem;", "setProfileOtherSettingItem", "(Lcom/tencent/mobileqq/widget/FormSwitchItem;)V", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class azrt
  extends RecyclerView.ViewHolder
{
  @NotNull
  private FormSwitchItem a;
  
  public azrt(@NotNull View paramView)
  {
    super(paramView);
    paramView = paramView.findViewById(2131372914);
    if (paramView == null) {
      throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.widget.FormSwitchItem");
    }
    this.a = ((FormSwitchItem)paramView);
  }
  
  @NotNull
  public final FormSwitchItem a()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azrt
 * JD-Core Version:    0.7.0.1
 */