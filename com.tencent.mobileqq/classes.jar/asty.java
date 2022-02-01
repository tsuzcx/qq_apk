import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/extendfriend/wiget/CompletePersonalDataDialog$TaskAdapter$ViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "taskDescription", "Landroid/widget/TextView;", "getTaskDescription", "()Landroid/widget/TextView;", "setTaskDescription", "(Landroid/widget/TextView;)V", "taskStatus", "Landroid/widget/Button;", "getTaskStatus", "()Landroid/widget/Button;", "setTaskStatus", "(Landroid/widget/Button;)V", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class asty
  extends RecyclerView.ViewHolder
{
  @NotNull
  private Button jdField_a_of_type_AndroidWidgetButton;
  @NotNull
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  
  public asty(@NotNull View paramView)
  {
    super(paramView);
    View localView = paramView.findViewById(2131378509);
    Intrinsics.checkExpressionValueIsNotNull(localView, "itemView.findViewById(R.id.task_description)");
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView);
    paramView = paramView.findViewById(2131378514);
    Intrinsics.checkExpressionValueIsNotNull(paramView, "itemView.findViewById(R.id.task_status)");
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)paramView);
  }
  
  @NotNull
  public final Button a()
  {
    return this.jdField_a_of_type_AndroidWidgetButton;
  }
  
  @NotNull
  public final TextView a()
  {
    return this.jdField_a_of_type_AndroidWidgetTextView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asty
 * JD-Core Version:    0.7.0.1
 */