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

public class aohn
  extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{
  private int jdField_a_of_type_Int;
  private aoit jdField_a_of_type_Aoit;
  private LinkedList<GroupInfo> jdField_a_of_type_JavaUtilLinkedList;
  private boolean jdField_a_of_type_Boolean;
  
  public aohn(aoit paramaoit, LinkedList<GroupInfo> paramLinkedList)
  {
    this.jdField_a_of_type_Aoit = paramLinkedList;
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
        paramViewHolder = (aohg)paramViewHolder;
        paramViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams().height = ExtendFriendGroupFragment.a(this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendGroupFragment).getHeight();
        localObject = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = aywk.a;
        ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = aywk.a;
        localObject = aokl.a("expand_square_blank.png");
      } while (!new File((String)localObject).exists());
      paramViewHolder = paramViewHolder.jdField_a_of_type_ComTencentImageURLImageView;
      ThreadManager.getSubThreadHandler().post(new ExtendFriendGroupFragment.RecyclerViewAdapter.1(this, (String)localObject, paramViewHolder));
      return;
    case 0: 
      localObject = (aohk)paramViewHolder;
      GroupInfo localGroupInfo = (GroupInfo)this.jdField_a_of_type_JavaUtilLinkedList.get(paramInt - 1);
      ((aohk)localObject).jdField_a_of_type_AndroidViewView.setTag(2131364657, Integer.valueOf(paramInt - 1));
      ((aohk)localObject).jdField_a_of_type_ComTencentWidgetSingleLineTextView.setText(localGroupInfo.groupName);
      if (TextUtils.isEmpty(localGroupInfo.groupDesc))
      {
        paramViewHolder = ajyc.a(2131704254);
        if (!paramViewHolder.equals(((aohk)localObject).b.a())) {
          ((aohk)localObject).b.setText(paramViewHolder);
        }
        paramViewHolder = (aoho)((aohk)localObject).jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getAdapter();
        if (paramViewHolder != null) {
          break label332;
        }
        paramViewHolder = new aoho(this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendGroupFragment, localGroupInfo.labels);
        ((aohk)localObject).jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(paramViewHolder);
        label245:
        paramViewHolder = URLDrawable.URLDrawableOptions.obtain();
        paramViewHolder.mLoadingDrawable = bbdr.c();
        paramViewHolder.mFailedDrawable = aywk.a;
        paramViewHolder = URLDrawable.getDrawable(localGroupInfo.groupFace, paramViewHolder);
        if (!ExtendFriendGroupFragment.c(this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendGroupFragment)) {
          break label348;
        }
        paramViewHolder.setTag(new int[] { 140, 140, 10 });
        paramViewHolder.setDecodeHandler(bavi.i);
      }
      for (;;)
      {
        ((aohk)localObject).jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(paramViewHolder);
        return;
        paramViewHolder = localGroupInfo.groupDesc;
        break;
        label332:
        paramViewHolder.a(localGroupInfo.labels);
        paramViewHolder.notifyDataSetChanged();
        break label245;
        label348:
        paramViewHolder.setTag(bavi.a(140, 140));
        paramViewHolder.setDecodeHandler(bavi.o);
      }
    }
    paramViewHolder = (aohh)paramViewHolder;
    paramViewHolder.a(paramViewHolder, this.jdField_a_of_type_Int);
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    if (paramInt == 2)
    {
      paramViewGroup = (ViewGroup)LayoutInflater.from(paramViewGroup.getContext()).inflate(2131560739, paramViewGroup, false);
      return new aohg(this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendGroupFragment, paramViewGroup);
    }
    if (paramInt == 1)
    {
      paramViewGroup = new ExtendFriendFooterView(ExtendFriendGroupFragment.a(this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendGroupFragment));
      paramViewGroup.findViewById(2131378502).getLayoutParams().height = actn.a(50.0F, this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendGroupFragment.getResources());
      return new aohh(this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendGroupFragment, paramViewGroup, this.jdField_a_of_type_Aoit);
    }
    if (paramInt == 3)
    {
      paramViewGroup = (ViewGroup)LayoutInflater.from(paramViewGroup.getContext()).inflate(2131560748, paramViewGroup, false);
      return new aohi(this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendGroupFragment, paramViewGroup);
    }
    paramViewGroup = (ViewGroup)LayoutInflater.from(paramViewGroup.getContext()).inflate(2131560744, paramViewGroup, false);
    return new aohk(this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendGroupFragment, paramViewGroup, this.jdField_a_of_type_Aoit);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aohn
 * JD-Core Version:    0.7.0.1
 */