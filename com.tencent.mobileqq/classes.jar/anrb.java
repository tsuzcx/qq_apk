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

public class anrb
  extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{
  private int jdField_a_of_type_Int;
  private ansh jdField_a_of_type_Ansh;
  private LinkedList<GroupInfo> jdField_a_of_type_JavaUtilLinkedList;
  private boolean jdField_a_of_type_Boolean;
  
  public anrb(ansh paramansh, LinkedList<GroupInfo> paramLinkedList)
  {
    this.jdField_a_of_type_Ansh = paramLinkedList;
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
        paramViewHolder = (anqu)paramViewHolder;
        paramViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams().height = ExtendFriendGroupFragment.a(this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendGroupFragment).getHeight();
        localObject = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = axwd.a;
        ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = axwd.a;
        localObject = antz.a("expand_square_blank.png");
      } while (!new File((String)localObject).exists());
      paramViewHolder = paramViewHolder.jdField_a_of_type_ComTencentImageURLImageView;
      ThreadManager.getSubThreadHandler().post(new ExtendFriendGroupFragment.RecyclerViewAdapter.1(this, (String)localObject, paramViewHolder));
      return;
    case 0: 
      localObject = (anqy)paramViewHolder;
      GroupInfo localGroupInfo = (GroupInfo)this.jdField_a_of_type_JavaUtilLinkedList.get(paramInt - 1);
      ((anqy)localObject).jdField_a_of_type_AndroidViewView.setTag(2131299097, Integer.valueOf(paramInt - 1));
      ((anqy)localObject).jdField_a_of_type_ComTencentWidgetSingleLineTextView.setText(localGroupInfo.groupName);
      if (TextUtils.isEmpty(localGroupInfo.groupDesc))
      {
        paramViewHolder = ajjy.a(2131638469);
        if (!paramViewHolder.equals(((anqy)localObject).b.a())) {
          ((anqy)localObject).b.setText(paramViewHolder);
        }
        paramViewHolder = (anrc)((anqy)localObject).jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getAdapter();
        if (paramViewHolder != null) {
          break label332;
        }
        paramViewHolder = new anrc(this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendGroupFragment, localGroupInfo.labels);
        ((anqy)localObject).jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(paramViewHolder);
        label245:
        paramViewHolder = URLDrawable.URLDrawableOptions.obtain();
        paramViewHolder.mLoadingDrawable = bacm.c();
        paramViewHolder.mFailedDrawable = axwd.a;
        paramViewHolder = URLDrawable.getDrawable(localGroupInfo.groupFace, paramViewHolder);
        if (!ExtendFriendGroupFragment.c(this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendGroupFragment)) {
          break label348;
        }
        paramViewHolder.setTag(new int[] { 140, 140, 10 });
        paramViewHolder.setDecodeHandler(azue.i);
      }
      for (;;)
      {
        ((anqy)localObject).jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(paramViewHolder);
        return;
        paramViewHolder = localGroupInfo.groupDesc;
        break;
        label332:
        paramViewHolder.a(localGroupInfo.labels);
        paramViewHolder.notifyDataSetChanged();
        break label245;
        label348:
        paramViewHolder.setTag(azue.a(140, 140));
        paramViewHolder.setDecodeHandler(azue.o);
      }
    }
    paramViewHolder = (anqv)paramViewHolder;
    paramViewHolder.a(paramViewHolder, this.jdField_a_of_type_Int);
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    if (paramInt == 2)
    {
      paramViewGroup = (ViewGroup)LayoutInflater.from(paramViewGroup.getContext()).inflate(2131495164, paramViewGroup, false);
      return new anqu(this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendGroupFragment, paramViewGroup);
    }
    if (paramInt == 1)
    {
      paramViewGroup = new ExtendFriendFooterView(ExtendFriendGroupFragment.a(this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendGroupFragment));
      paramViewGroup.findViewById(2131312678).getLayoutParams().height = aciy.a(50.0F, this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendGroupFragment.getResources());
      return new anqv(this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendGroupFragment, paramViewGroup, this.jdField_a_of_type_Ansh);
    }
    if (paramInt == 3)
    {
      paramViewGroup = (ViewGroup)LayoutInflater.from(paramViewGroup.getContext()).inflate(2131495173, paramViewGroup, false);
      return new anqw(this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendGroupFragment, paramViewGroup);
    }
    paramViewGroup = (ViewGroup)LayoutInflater.from(paramViewGroup.getContext()).inflate(2131495169, paramViewGroup, false);
    return new anqy(this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendGroupFragment, paramViewGroup, this.jdField_a_of_type_Ansh);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     anrb
 * JD-Core Version:    0.7.0.1
 */