import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.extendfriend.bean.GroupInfo;
import com.tencent.mobileqq.extendfriend.fragment.ExtendFriendGroupFragment;
import com.tencent.mobileqq.extendfriend.fragment.ExtendFriendGroupFragment.RecyclerViewAdapter.1;
import com.tencent.mobileqq.extendfriend.wiget.ExtendFriendFooterView;
import com.tencent.widget.SingleLineTextView;
import java.io.File;
import java.util.LinkedList;
import mqq.os.MqqHandler;

public class aohs
  extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{
  private int jdField_a_of_type_Int;
  private aoiy jdField_a_of_type_Aoiy;
  private LinkedList<GroupInfo> jdField_a_of_type_JavaUtilLinkedList;
  private boolean jdField_a_of_type_Boolean;
  
  public aohs(aoiy paramaoiy, LinkedList<GroupInfo> paramLinkedList)
  {
    this.jdField_a_of_type_Aoiy = paramLinkedList;
    Object localObject;
    this.jdField_a_of_type_JavaUtilLinkedList = localObject;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_JavaUtilLinkedList.size();
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    this.jdField_a_of_type_Int = paramInt;
    if ((paramBoolean) && (!this.jdField_a_of_type_JavaUtilLinkedList.isEmpty())) {
      notifyItemChanged(getItemCount() - 1);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    notifyDataSetChanged();
  }
  
  public int getItemCount()
  {
    if (this.jdField_a_of_type_Boolean) {
      return this.jdField_a_of_type_JavaUtilLinkedList.size() + 1;
    }
    if (this.jdField_a_of_type_JavaUtilLinkedList.isEmpty()) {
      return 0;
    }
    return this.jdField_a_of_type_JavaUtilLinkedList.size() + 2;
  }
  
  public int getItemViewType(int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilLinkedList.size() == 0) {
      return 2;
    }
    if (paramInt == 0) {
      return 3;
    }
    if (paramInt < this.jdField_a_of_type_JavaUtilLinkedList.size() + 1) {
      return 0;
    }
    return 1;
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    Object localObject;
    switch (getItemViewType(paramInt))
    {
    default: 
    case 2: 
      do
      {
        return;
        paramViewHolder = (aohl)paramViewHolder;
        paramViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams().height = ExtendFriendGroupFragment.a(this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendGroupFragment).getHeight();
        localObject = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = aywm.a;
        ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = aywm.a;
        localObject = aokq.a("expand_square_blank.png");
      } while (!new File((String)localObject).exists());
      paramViewHolder = paramViewHolder.jdField_a_of_type_ComTencentImageURLImageView;
      ThreadManager.getSubThreadHandler().post(new ExtendFriendGroupFragment.RecyclerViewAdapter.1(this, (String)localObject, paramViewHolder));
      return;
    case 0: 
      localObject = (aohp)paramViewHolder;
      GroupInfo localGroupInfo = (GroupInfo)this.jdField_a_of_type_JavaUtilLinkedList.get(paramInt - 1);
      ((aohp)localObject).jdField_a_of_type_AndroidViewView.setTag(2131364656, Integer.valueOf(paramInt - 1));
      ((aohp)localObject).jdField_a_of_type_ComTencentWidgetSingleLineTextView.setText(localGroupInfo.groupName);
      if (TextUtils.isEmpty(localGroupInfo.groupDesc))
      {
        paramViewHolder = ajya.a(2131704265);
        if (!paramViewHolder.equals(((aohp)localObject).b.a())) {
          ((aohp)localObject).b.setText(paramViewHolder);
        }
        paramViewHolder = (aoht)((aohp)localObject).jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getAdapter();
        if (paramViewHolder != null) {
          break label332;
        }
        paramViewHolder = new aoht(this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendGroupFragment, localGroupInfo.labels);
        ((aohp)localObject).jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(paramViewHolder);
        label245:
        paramViewHolder = URLDrawable.URLDrawableOptions.obtain();
        paramViewHolder.mLoadingDrawable = bbef.c();
        paramViewHolder.mFailedDrawable = aywm.a;
        paramViewHolder = URLDrawable.getDrawable(localGroupInfo.groupFace, paramViewHolder);
        if (!ExtendFriendGroupFragment.c(this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendGroupFragment)) {
          break label348;
        }
        paramViewHolder.setTag(new int[] { 140, 140, 10 });
        paramViewHolder.setDecodeHandler(bavw.i);
      }
      for (;;)
      {
        ((aohp)localObject).jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(paramViewHolder);
        return;
        paramViewHolder = localGroupInfo.groupDesc;
        break;
        label332:
        paramViewHolder.a(localGroupInfo.labels);
        paramViewHolder.notifyDataSetChanged();
        break label245;
        label348:
        paramViewHolder.setTag(bavw.a(140, 140));
        paramViewHolder.setDecodeHandler(bavw.o);
      }
    }
    paramViewHolder = (aohm)paramViewHolder;
    paramViewHolder.a(paramViewHolder, this.jdField_a_of_type_Int);
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    if (paramInt == 2)
    {
      paramViewGroup = (ViewGroup)LayoutInflater.from(paramViewGroup.getContext()).inflate(2131560738, paramViewGroup, false);
      return new aohl(this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendGroupFragment, paramViewGroup);
    }
    if (paramInt == 1)
    {
      paramViewGroup = new ExtendFriendFooterView(ExtendFriendGroupFragment.a(this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendGroupFragment));
      paramViewGroup.findViewById(2131378507).getLayoutParams().height = actj.a(50.0F, this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendGroupFragment.getResources());
      return new aohm(this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendGroupFragment, paramViewGroup, this.jdField_a_of_type_Aoiy);
    }
    if (paramInt == 3)
    {
      paramViewGroup = (ViewGroup)LayoutInflater.from(paramViewGroup.getContext()).inflate(2131560747, paramViewGroup, false);
      return new aohn(this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendGroupFragment, paramViewGroup);
    }
    paramViewGroup = (ViewGroup)LayoutInflater.from(paramViewGroup.getContext()).inflate(2131560743, paramViewGroup, false);
    return new aohp(this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendGroupFragment, paramViewGroup, this.jdField_a_of_type_Aoiy);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aohs
 * JD-Core Version:    0.7.0.1
 */