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
public final class azrp
  extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{
  private final Context jdField_a_of_type_AndroidContentContext;
  private final LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private final azrq jdField_a_of_type_Azrq;
  private final ArrayList<azsj> jdField_a_of_type_JavaUtilArrayList;
  
  public azrp(@NotNull Context paramContext, @Nullable azrq paramazrq)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    paramContext = LayoutInflater.from(paramContext);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "LayoutInflater.from(context)");
    this.jdField_a_of_type_AndroidViewLayoutInflater = paramContext;
    this.jdField_a_of_type_Azrq = paramazrq;
  }
  
  public final void a(@Nullable List<azsj> paramList)
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
    return ((azsj)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).a();
  }
  
  public void onBindViewHolder(@NotNull RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramViewHolder, "viewHolder");
    switch (getItemViewType(paramInt))
    {
    }
    do
    {
      azrq localazrq;
      do
      {
        do
        {
          return;
          paramViewHolder = (azrr)paramViewHolder;
          i = ((azsj)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).c();
          if (i != -1) {
            paramViewHolder.a().setLeftText((CharSequence)this.jdField_a_of_type_AndroidContentContext.getString(i));
          }
          switch (((azsj)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).g())
          {
          default: 
            paramViewHolder.a().setRightText((CharSequence)this.jdField_a_of_type_AndroidContentContext.getString(2131694500));
          }
          for (;;)
          {
            if (((azsj)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).f() != -1) {
              paramViewHolder.a().setBgType(((azsj)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).f());
            }
            localazrq = this.jdField_a_of_type_Azrq;
            if (localazrq == null) {
              break;
            }
            paramViewHolder.a().setOnClickListener((View.OnClickListener)new azrw(localazrq, this, paramViewHolder, paramInt));
            return;
            paramViewHolder.a().setRightText((CharSequence)this.jdField_a_of_type_AndroidContentContext.getString(2131694500));
            continue;
            paramViewHolder.a().setRightText((CharSequence)this.jdField_a_of_type_AndroidContentContext.getString(2131694515));
            continue;
            paramViewHolder.a().setRightText((CharSequence)this.jdField_a_of_type_AndroidContentContext.getString(2131694516));
          }
          paramViewHolder = (azrt)paramViewHolder;
          i = ((azsj)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).c();
          if (i != -1) {
            paramViewHolder.a().setText((CharSequence)this.jdField_a_of_type_AndroidContentContext.getString(i));
          }
          paramViewHolder.a().setChecked(((azsj)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).b());
          if (((azsj)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).f() != -1) {
            paramViewHolder.a().setBgType(((azsj)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).f());
          }
          localazrq = this.jdField_a_of_type_Azrq;
        } while (localazrq == null);
        paramViewHolder.a().a().setOnClickListener((View.OnClickListener)new azrx(localazrq, this, paramViewHolder, paramInt));
        return;
        paramViewHolder = (azru)paramViewHolder;
        int i = ((azsj)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).c();
        int j = ((azsj)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).d();
        if ((i != -1) && (j != -1))
        {
          paramViewHolder.a().setText((CharSequence)this.jdField_a_of_type_AndroidContentContext.getString(i));
          paramViewHolder.a().setText((CharSequence)this.jdField_a_of_type_AndroidContentContext.getString(j));
        }
        paramViewHolder.a().setChecked(((azsj)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).b());
        if (((azsj)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).f() != -1) {
          paramViewHolder.a().setBgType(((azsj)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).f());
        }
        localazrq = this.jdField_a_of_type_Azrq;
      } while (localazrq == null);
      paramViewHolder.a().a().setOnClickListener((View.OnClickListener)new azry(localazrq, this, paramViewHolder, paramInt));
      return;
      paramViewHolder = (azrv)paramViewHolder;
      paramInt = ((azsj)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).c();
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
      paramViewGroup = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131561392, paramViewGroup, false);
      Intrinsics.checkExpressionValueIsNotNull(paramViewGroup, "mInflater.inflate(R.layo…k_item, viewGroup, false)");
      return (RecyclerView.ViewHolder)new azrs(paramViewGroup);
    case 1: 
      paramViewGroup = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131561391, paramViewGroup, false);
      Intrinsics.checkExpressionValueIsNotNull(paramViewGroup, "mInflater.inflate(R.layo…e_item, viewGroup, false)");
      return (RecyclerView.ViewHolder)new azrr(paramViewGroup);
    case 2: 
      paramViewGroup = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131561393, paramViewGroup, false);
      Intrinsics.checkExpressionValueIsNotNull(paramViewGroup, "mInflater.inflate(R.layo…e_item, viewGroup, false)");
      return (RecyclerView.ViewHolder)new azrt(paramViewGroup);
    case 3: 
      paramViewGroup = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131561394, paramViewGroup, false);
      Intrinsics.checkExpressionValueIsNotNull(paramViewGroup, "mInflater.inflate(R.layo…d_item, viewGroup, false)");
      return (RecyclerView.ViewHolder)new azru(paramViewGroup);
    case 4: 
      paramViewGroup = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131561392, paramViewGroup, false);
      Intrinsics.checkExpressionValueIsNotNull(paramViewGroup, "mInflater.inflate(R.layo…k_item, viewGroup, false)");
      return (RecyclerView.ViewHolder)new azrs(paramViewGroup);
    }
    paramViewGroup = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131561395, paramViewGroup, false);
    Intrinsics.checkExpressionValueIsNotNull(paramViewGroup, "mInflater.inflate(R.layo…e_item, viewGroup, false)");
    return (RecyclerView.ViewHolder)new azrv(paramViewGroup);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azrp
 * JD-Core Version:    0.7.0.1
 */