import android.content.Context;
import android.view.LayoutInflater;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.widget.Switch;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/profilesetting/ProfileBasePrivacySettingAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "context", "Landroid/content/Context;", "privacySettingClickListener", "Lcom/tencent/mobileqq/profilesetting/ProfileBasePrivacySettingAdapter$PrivacySettingClickListener;", "(Landroid/content/Context;Lcom/tencent/mobileqq/profilesetting/ProfileBasePrivacySettingAdapter$PrivacySettingClickListener;)V", "mContext", "mData", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/profilesetting/ProfileDisplaySettingItem;", "Lkotlin/collections/ArrayList;", "mInflater", "Landroid/view/LayoutInflater;", "mPrivacySettingClickListener", "getItemCount", "", "getItemViewType", "position", "onBindViewHolder", "", "viewHolder", "onCreateViewHolder", "viewGroup", "Landroid/view/ViewGroup;", "type", "setData", "data", "", "PrivacySettingClickListener", "ProfileBaseHolder", "ProfileBlankHolder", "ProfileOtherHolder", "ProfileOtherWithSecondHolder", "ProfileTitleHolder", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class azaf
  extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{
  private final Context jdField_a_of_type_AndroidContentContext;
  private final LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private final azag jdField_a_of_type_Azag;
  private final ArrayList<azaz> jdField_a_of_type_JavaUtilArrayList;
  
  public azaf(@NotNull Context paramContext, @Nullable azag paramazag)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    paramContext = LayoutInflater.from(paramContext);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "LayoutInflater.from(context)");
    this.jdField_a_of_type_AndroidViewLayoutInflater = paramContext;
    this.jdField_a_of_type_Azag = paramazag;
  }
  
  public final void a(@Nullable List<azaz> paramList)
  {
    if (paramList != null)
    {
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      this.jdField_a_of_type_JavaUtilArrayList.addAll((Collection)paramList);
    }
    notifyDataSetChanged();
  }
  
  public int getItemCount()
  {
    return this.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public int getItemViewType(int paramInt)
  {
    return ((azaz)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).a();
  }
  
  public void onBindViewHolder(@NotNull RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramViewHolder, "viewHolder");
    switch (getItemViewType(paramInt))
    {
    }
    do
    {
      azag localazag;
      do
      {
        do
        {
          return;
          paramViewHolder = (azah)paramViewHolder;
          i = ((azaz)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).c();
          if (i != -1) {
            paramViewHolder.a().setLeftText((CharSequence)this.jdField_a_of_type_AndroidContentContext.getString(i));
          }
          switch (((azaz)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).g())
          {
          default: 
            paramViewHolder.a().setRightText((CharSequence)this.jdField_a_of_type_AndroidContentContext.getString(2131694657));
          }
          for (;;)
          {
            if (((azaz)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).f() != -1) {
              paramViewHolder.a().setBgType(((azaz)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).f());
            }
            localazag = this.jdField_a_of_type_Azag;
            if (localazag == null) {
              break;
            }
            paramViewHolder.a().setOnClickListener((View.OnClickListener)new azam(localazag, this, paramViewHolder, paramInt));
            return;
            paramViewHolder.a().setRightText((CharSequence)this.jdField_a_of_type_AndroidContentContext.getString(2131694657));
            continue;
            paramViewHolder.a().setRightText((CharSequence)this.jdField_a_of_type_AndroidContentContext.getString(2131694673));
            continue;
            paramViewHolder.a().setRightText((CharSequence)this.jdField_a_of_type_AndroidContentContext.getString(2131694674));
          }
          paramViewHolder = (azaj)paramViewHolder;
          i = ((azaz)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).c();
          if (i != -1) {
            paramViewHolder.a().setText((CharSequence)this.jdField_a_of_type_AndroidContentContext.getString(i));
          }
          paramViewHolder.a().setChecked(((azaz)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).b());
          if (((azaz)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).f() != -1) {
            paramViewHolder.a().setBgType(((azaz)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).f());
          }
          localazag = this.jdField_a_of_type_Azag;
        } while (localazag == null);
        paramViewHolder.a().a().setOnClickListener((View.OnClickListener)new azan(localazag, this, paramViewHolder, paramInt));
        return;
        paramViewHolder = (azak)paramViewHolder;
        int i = ((azaz)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).c();
        int j = ((azaz)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).d();
        if ((i != -1) && (j != -1))
        {
          paramViewHolder.a().setText((CharSequence)this.jdField_a_of_type_AndroidContentContext.getString(i));
          paramViewHolder.a().setText((CharSequence)this.jdField_a_of_type_AndroidContentContext.getString(j));
        }
        paramViewHolder.a().setChecked(((azaz)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).b());
        if (((azaz)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).f() != -1) {
          paramViewHolder.a().setBgType(((azaz)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).f());
        }
        localazag = this.jdField_a_of_type_Azag;
      } while (localazag == null);
      paramViewHolder.a().a().setOnClickListener((View.OnClickListener)new azao(localazag, this, paramViewHolder, paramInt));
      return;
      paramViewHolder = (azal)paramViewHolder;
      paramInt = ((azaz)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).c();
    } while (paramInt == -1);
    paramViewHolder.a().setText((CharSequence)this.jdField_a_of_type_AndroidContentContext.getString(paramInt));
  }
  
  @NotNull
  public RecyclerView.ViewHolder onCreateViewHolder(@NotNull ViewGroup paramViewGroup, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramViewGroup, "viewGroup");
    switch (paramInt)
    {
    default: 
      paramViewGroup = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131561317, paramViewGroup, false);
      Intrinsics.checkExpressionValueIsNotNull(paramViewGroup, "mInflater.inflate(R.layo…k_item, viewGroup, false)");
      return (RecyclerView.ViewHolder)new azai(paramViewGroup);
    case 1: 
      paramViewGroup = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131561316, paramViewGroup, false);
      Intrinsics.checkExpressionValueIsNotNull(paramViewGroup, "mInflater.inflate(R.layo…e_item, viewGroup, false)");
      return (RecyclerView.ViewHolder)new azah(paramViewGroup);
    case 2: 
      paramViewGroup = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131561318, paramViewGroup, false);
      Intrinsics.checkExpressionValueIsNotNull(paramViewGroup, "mInflater.inflate(R.layo…e_item, viewGroup, false)");
      return (RecyclerView.ViewHolder)new azaj(paramViewGroup);
    case 3: 
      paramViewGroup = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131561319, paramViewGroup, false);
      Intrinsics.checkExpressionValueIsNotNull(paramViewGroup, "mInflater.inflate(R.layo…d_item, viewGroup, false)");
      return (RecyclerView.ViewHolder)new azak(paramViewGroup);
    case 4: 
      paramViewGroup = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131561317, paramViewGroup, false);
      Intrinsics.checkExpressionValueIsNotNull(paramViewGroup, "mInflater.inflate(R.layo…k_item, viewGroup, false)");
      return (RecyclerView.ViewHolder)new azai(paramViewGroup);
    }
    paramViewGroup = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131561320, paramViewGroup, false);
    Intrinsics.checkExpressionValueIsNotNull(paramViewGroup, "mInflater.inflate(R.layo…e_item, viewGroup, false)");
    return (RecyclerView.ViewHolder)new azal(paramViewGroup);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azaf
 * JD-Core Version:    0.7.0.1
 */