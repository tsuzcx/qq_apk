import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import kotlin.Metadata;
import kotlin.TypeCastException;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/profilesetting/ActionSheetPrivacySelectAdapter$PrivacyHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "checkIv", "Landroid/widget/ImageView;", "getCheckIv", "()Landroid/widget/ImageView;", "setCheckIv", "(Landroid/widget/ImageView;)V", "titleTv", "Landroid/widget/TextView;", "getTitleTv", "()Landroid/widget/TextView;", "setTitleTv", "(Landroid/widget/TextView;)V", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class ayzu
  extends RecyclerView.ViewHolder
{
  @NotNull
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  @NotNull
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  
  public ayzu(@NotNull View paramView)
  {
    super(paramView);
    View localView = paramView.findViewById(2131378809);
    if (localView == null) {
      throw new TypeCastException("null cannot be cast to non-null type android.widget.TextView");
    }
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView);
    paramView = paramView.findViewById(2131364522);
    if (paramView == null) {
      throw new TypeCastException("null cannot be cast to non-null type android.widget.ImageView");
    }
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView);
  }
  
  @NotNull
  public final ImageView a()
  {
    return this.jdField_a_of_type_AndroidWidgetImageView;
  }
  
  @NotNull
  public final TextView a()
  {
    return this.jdField_a_of_type_AndroidWidgetTextView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayzu
 * JD-Core Version:    0.7.0.1
 */