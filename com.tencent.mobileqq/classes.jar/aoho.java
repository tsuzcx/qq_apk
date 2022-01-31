import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.tencent.mobileqq.extendfriend.bean.GroupInfo.Label;
import com.tencent.mobileqq.extendfriend.fragment.ExtendFriendGroupFragment;
import com.tencent.widget.RoundBGTextView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class aoho
  extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{
  private List<GroupInfo.Label> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  public aoho(List<GroupInfo.Label> paramList)
  {
    Collection localCollection;
    if (localCollection != null) {
      this.jdField_a_of_type_JavaUtilList.addAll(localCollection);
    }
  }
  
  public aohp a(ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup = (ViewGroup)LayoutInflater.from(paramViewGroup.getContext()).inflate(2131560746, paramViewGroup, false);
    return new aohp(this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendGroupFragment, paramViewGroup);
  }
  
  public void a(List<GroupInfo.Label> paramList)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    if (paramList != null) {
      this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    }
  }
  
  public int getItemCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    paramViewHolder = (aohp)paramViewHolder;
    Object localObject = (GroupInfo.Label)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    if ((((GroupInfo.Label)localObject).labelType == 2001) || ((((GroupInfo.Label)localObject).labelType >= 1000) && (((GroupInfo.Label)localObject).labelType < 2000))) {}
    for (paramInt = 1; paramInt != 0; paramInt = 0)
    {
      paramViewHolder.a.setVisibility(8);
      return;
    }
    paramViewHolder.a.setVisibility(0);
    paramViewHolder.a.setTextColor(((GroupInfo.Label)localObject).textColor);
    paramViewHolder.a.setBgColor(((GroupInfo.Label)localObject).bgColor);
    if (((GroupInfo.Label)localObject).labelType == 1)
    {
      localObject = new SpannableString("[icon]" + " " + ((GroupInfo.Label)localObject).labelName);
      if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendGroupFragment.a == null) {
        this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendGroupFragment.a = this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendGroupFragment.getResources().getDrawable(2130843243);
      }
      paramInt = (int)(paramViewHolder.a.a() * 0.8D + 0.5D);
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendGroupFragment.a.setBounds(0, 0, paramInt, paramInt);
      ((SpannableString)localObject).setSpan(new ImageSpan(this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendGroupFragment.a, 1), 0, "[icon]".length(), 17);
      paramViewHolder.a.setText((CharSequence)localObject);
      return;
    }
    paramViewHolder.a.setText(((GroupInfo.Label)localObject).labelName);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aoho
 * JD-Core Version:    0.7.0.1
 */