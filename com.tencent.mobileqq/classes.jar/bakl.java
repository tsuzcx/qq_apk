import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import kotlin.Metadata;
import kotlin.TypeCastException;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/profilesetting/ProfileBasePrivacySettingAdapter$ProfileTitleHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "profileTitleItem", "Landroid/widget/TextView;", "getProfileTitleItem", "()Landroid/widget/TextView;", "setProfileTitleItem", "(Landroid/widget/TextView;)V", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class bakl
  extends RecyclerView.ViewHolder
{
  @NotNull
  private TextView a;
  
  public bakl(@NotNull View paramView)
  {
    super(paramView);
    paramView = paramView.findViewById(2131373033);
    if (paramView == null) {
      throw new TypeCastException("null cannot be cast to non-null type android.widget.TextView");
    }
    this.a = ((TextView)paramView);
  }
  
  @NotNull
  public final TextView a()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bakl
 * JD-Core Version:    0.7.0.1
 */