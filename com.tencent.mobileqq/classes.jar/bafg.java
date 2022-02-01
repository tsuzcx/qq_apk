import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/profilesetting/ActionSheetPrivacySelectAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "mContext", "Landroid/content/Context;", "profileDisplaySettingItem", "Lcom/tencent/mobileqq/profilesetting/ProfileDisplaySettingItem;", "(Landroid/content/Context;Lcom/tencent/mobileqq/profilesetting/ProfileDisplaySettingItem;)V", "getMContext", "()Landroid/content/Context;", "setMContext", "(Landroid/content/Context;)V", "mData", "", "Lcom/tencent/mobileqq/profilesetting/ActionSheetPrivacySelectAdapter$ActionSheetPrivacySelectBean;", "mInflater", "Landroid/view/LayoutInflater;", "mPrivacySelectActionSheetClickListener", "Lcom/tencent/mobileqq/profilesetting/ActionSheetPrivacySelectAdapter$PrivacySelectActionSheetClickListener;", "mProfileDisplaySettingItem", "getProfileDisplaySettingItem", "()Lcom/tencent/mobileqq/profilesetting/ProfileDisplaySettingItem;", "setProfileDisplaySettingItem", "(Lcom/tencent/mobileqq/profilesetting/ProfileDisplaySettingItem;)V", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "viewGroup", "Landroid/view/ViewGroup;", "viewType", "setData", "list", "", "setOnPrivacySelectActionSheetClickListener", "listener", "ActionSheetPrivacySelectBean", "PrivacyHolder", "PrivacySelectActionSheetClickListener", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class bafg
  extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{
  @NotNull
  private Context jdField_a_of_type_AndroidContentContext;
  private final LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private bafj jdField_a_of_type_Bafj;
  private final bagn jdField_a_of_type_Bagn;
  private final List<bafh> jdField_a_of_type_JavaUtilList;
  @NotNull
  private bagn b;
  
  public bafg(@NotNull Context paramContext, @NotNull bagn parambagn)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.b = parambagn;
    this.jdField_a_of_type_Bagn = this.b;
    this.jdField_a_of_type_JavaUtilList = ((List)new ArrayList());
    paramContext = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "LayoutInflater.from(mContext)");
    this.jdField_a_of_type_AndroidViewLayoutInflater = paramContext;
  }
  
  public final void a(@Nullable bafj parambafj)
  {
    this.jdField_a_of_type_Bafj = parambafj;
  }
  
  public final void a(@Nullable List<bafh> paramList)
  {
    if (paramList != null)
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      this.jdField_a_of_type_JavaUtilList.addAll((Collection)paramList);
    }
    notifyDataSetChanged();
  }
  
  public int getItemCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public void onBindViewHolder(@NotNull RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramViewHolder, "holder");
    paramViewHolder = (bafi)paramViewHolder;
    paramViewHolder.a().setText((CharSequence)((bafh)this.jdField_a_of_type_JavaUtilList.get(paramInt)).a());
    if (paramInt == 0)
    {
      paramViewHolder.itemView.setBackgroundResource(2130837583);
      if (((bafh)this.jdField_a_of_type_JavaUtilList.get(paramInt)).a() != this.jdField_a_of_type_Bagn.g()) {
        break label127;
      }
      paramViewHolder.a().setVisibility(0);
    }
    for (;;)
    {
      bafj localbafj = this.jdField_a_of_type_Bafj;
      if (localbafj != null) {
        paramViewHolder.itemView.setOnClickListener((View.OnClickListener)new bafk(localbafj, this, paramViewHolder, paramInt));
      }
      return;
      paramViewHolder.itemView.setBackgroundResource(2130837571);
      break;
      label127:
      paramViewHolder.a().setVisibility(8);
    }
  }
  
  @NotNull
  public RecyclerView.ViewHolder onCreateViewHolder(@NotNull ViewGroup paramViewGroup, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramViewGroup, "viewGroup");
    paramViewGroup = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131561376, paramViewGroup, false);
    Intrinsics.checkExpressionValueIsNotNull(paramViewGroup, "mInflater.inflate(R.layo…w_item, viewGroup, false)");
    return (RecyclerView.ViewHolder)new bafi(paramViewGroup);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bafg
 * JD-Core Version:    0.7.0.1
 */