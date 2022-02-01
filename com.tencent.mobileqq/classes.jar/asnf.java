import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mobileqq.activity.FriendProfileMoreInfoActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.extendfriend.fragment.ExtendFriendEditFragment;
import com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelGalleryActivity;
import com.tencent.mobileqq.widget.PhotoWallView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/extendfriend/wiget/CompletePersonalDataDialog$TaskAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mobileqq/extendfriend/wiget/CompletePersonalDataDialog$TaskAdapter$ViewHolder;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "onClickListener", "Landroid/view/View$OnClickListener;", "taskList", "", "Lcom/tencent/mobileqq/extendfriend/limitchat/CompletePesonalDataTask;", "getItemCount", "", "jumpToTask", "", "task", "onBindViewHolder", "viewHolder", "i", "onCreateViewHolder", "viewGroup", "Landroid/view/ViewGroup;", "updateTasks", "tasks", "", "ViewHolder", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class asnf
  extends RecyclerView.Adapter<asng>
{
  private final Context jdField_a_of_type_AndroidContentContext;
  private final View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private final List<askj> jdField_a_of_type_JavaUtilList;
  
  public asnf(@NotNull Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaUtilList = ((List)new ArrayList());
    this.jdField_a_of_type_AndroidViewView$OnClickListener = ((View.OnClickListener)new asnh(this));
  }
  
  private final void a(askj paramaskj)
  {
    switch (paramaskj.jdField_a_of_type_Int)
    {
    }
    for (;;)
    {
      bcst.b(null, "dc00898", "", "", "0X800B08A", "0X800B08A", paramaskj.jdField_a_of_type_Int, 0, "", "", "", "");
      return;
      Object localObject1 = new Intent(this.jdField_a_of_type_AndroidContentContext, FriendProfileMoreInfoActivity.class);
      this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject1);
      continue;
      localObject1 = this.jdField_a_of_type_AndroidContentContext;
      if (localObject1 == null) {
        throw new TypeCastException("null cannot be cast to non-null type android.app.Activity");
      }
      asme.a((Activity)localObject1, "");
      continue;
      localObject1 = new Intent();
      Object localObject2 = this.jdField_a_of_type_AndroidContentContext;
      if (localObject2 == null) {
        throw new TypeCastException("null cannot be cast to non-null type android.app.Activity");
      }
      PublicFragmentActivity.a((Activity)localObject2, (Intent)localObject1, ExtendFriendEditFragment.class, 4097);
      continue;
      localObject1 = new Intent(this.jdField_a_of_type_AndroidContentContext, PersonalityLabelGalleryActivity.class);
      localObject2 = this.jdField_a_of_type_AndroidContentContext;
      if (localObject2 == null) {
        throw new TypeCastException("null cannot be cast to non-null type android.support.v4.app.FragmentActivity");
      }
      localObject2 = ((FragmentActivity)localObject2).app;
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "(context as FragmentActivity).app");
      ((Intent)localObject1).putExtra("uin", ((QQAppInterface)localObject2).c());
      this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject1);
      continue;
      localObject1 = this.jdField_a_of_type_AndroidContentContext;
      if (localObject1 == null) {
        throw new TypeCastException("null cannot be cast to non-null type android.support.v4.app.FragmentActivity");
      }
      localObject1 = ((FragmentActivity)localObject1).app;
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "(context as FragmentActivity).app");
      localObject1 = ((QQAppInterface)localObject1).c();
      localObject2 = this.jdField_a_of_type_AndroidContentContext;
      if (localObject2 == null) {
        throw new TypeCastException("null cannot be cast to non-null type android.app.Activity");
      }
      PhotoWallView.a((Activity)localObject2, (String)localObject1, true);
    }
  }
  
  @NotNull
  public asng a(@NotNull ViewGroup paramViewGroup, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramViewGroup, "viewGroup");
    paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561145, paramViewGroup, false);
    Intrinsics.checkExpressionValueIsNotNull(paramViewGroup, "convertView");
    paramViewGroup = new asng(paramViewGroup);
    paramViewGroup.a().setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    return paramViewGroup;
  }
  
  public void a(@NotNull asng paramasng, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramasng, "viewHolder");
    if (this.jdField_a_of_type_JavaUtilList == null)
    {
      EventCollector.getInstance().onRecyclerBindViewHolder(paramasng, paramInt, getItemId(paramInt));
      return;
    }
    Object localObject = (askj)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    String str = ((askj)localObject).jdField_a_of_type_JavaLangString + " +" + ((askj)localObject).b;
    Intrinsics.checkExpressionValueIsNotNull(str, "StringBuilder(task.taskD…k.rewardCount).toString()");
    paramasng.a().setText((CharSequence)str);
    boolean bool;
    switch (((askj)localObject).c)
    {
    default: 
      localObject = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131697902);
      bool = true;
      label140:
      if (bool)
      {
        paramasng.a().setBackgroundDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130845089));
        paramasng.a().setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167279));
      }
      break;
    }
    for (;;)
    {
      paramasng.a().setEnabled(bool);
      paramasng.a().setText((CharSequence)localObject);
      paramasng.a().setTag(Integer.valueOf(paramInt));
      break;
      localObject = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131697902);
      bool = true;
      break label140;
      localObject = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131697903);
      bool = false;
      break label140;
      localObject = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131697904);
      bool = false;
      break label140;
      paramasng.a().setBackgroundDrawable(null);
      paramasng.a().setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131165572));
    }
  }
  
  public final void a(@Nullable List<? extends askj> paramList)
  {
    List localList = this.jdField_a_of_type_JavaUtilList;
    if (localList != null) {
      localList.clear();
    }
    localList = this.jdField_a_of_type_JavaUtilList;
    if (localList != null)
    {
      if (paramList == null) {
        Intrinsics.throwNpe();
      }
      localList.addAll((Collection)paramList);
    }
  }
  
  public int getItemCount()
  {
    List localList = this.jdField_a_of_type_JavaUtilList;
    if (localList != null) {
      return localList.size();
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asnf
 * JD-Core Version:    0.7.0.1
 */