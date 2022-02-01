import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.support.v7.widget.StaggeredGridLayoutManager.LayoutParams;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.profile.CustomCoverFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Vector;

public class azvp
  extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{
  public azvp(CustomCoverFragment paramCustomCoverFragment) {}
  
  private void a(azvn paramazvn)
  {
    if (CustomCoverFragment.c(this.a))
    {
      paramazvn.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130850045);
      paramazvn.jdField_a_of_type_AndroidWidgetButton.setTextColor(-8947849);
      paramazvn.jdField_a_of_type_AndroidWidgetButton.setText(2131694409);
      return;
    }
    if ((paramazvn.jdField_a_of_type_Int == CustomCoverFragment.a(this.a)) && (CustomCoverFragment.a(this.a)))
    {
      paramazvn.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130850045);
      paramazvn.jdField_a_of_type_AndroidWidgetButton.setTextColor(-8947849);
      paramazvn.jdField_a_of_type_AndroidWidgetButton.setText(2131717949);
      return;
    }
    paramazvn.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130850065);
    paramazvn.jdField_a_of_type_AndroidWidgetButton.setTextColor(-16777216);
    paramazvn.jdField_a_of_type_AndroidWidgetButton.setText(2131694409);
  }
  
  public azxt a(int paramInt)
  {
    if ((CustomCoverFragment.a(this.a) != null) && (paramInt > 0) && (paramInt - 1 < CustomCoverFragment.a(this.a).size()) && (CustomCoverFragment.a(this.a) != null))
    {
      paramInt = ((Integer)CustomCoverFragment.a(this.a).get(paramInt - 1)).intValue();
      return CustomCoverFragment.a(this.a).a(paramInt, false);
    }
    return null;
  }
  
  public int getItemCount()
  {
    if (CustomCoverFragment.a(this.a) == null) {}
    for (int i = 0;; i = CustomCoverFragment.a(this.a).size()) {
      return i + 2;
    }
  }
  
  public int getItemViewType(int paramInt)
  {
    if (paramInt == 0) {
      return 0;
    }
    if ((CustomCoverFragment.a(this.a) != null) && (paramInt > CustomCoverFragment.a(this.a).size())) {
      return 2;
    }
    return 1;
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    Object localObject1;
    azxt localazxt;
    if ((paramViewHolder instanceof azvn))
    {
      localObject1 = (azvn)paramViewHolder;
      localazxt = a(paramInt);
      if (localazxt != null)
      {
        ((azvn)localObject1).jdField_a_of_type_Int = localazxt.jdField_a_of_type_Int;
        ((azvn)localObject1).jdField_a_of_type_AndroidWidgetTextView.setText(localazxt.jdField_a_of_type_JavaLangString);
        if (TextUtils.isEmpty(localazxt.b))
        {
          ((azvn)localObject1).jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(CustomCoverFragment.a(this.a));
          ((azvn)localObject1).jdField_a_of_type_AndroidWidgetButton.setTag(Integer.valueOf(localazxt.jdField_a_of_type_Int));
          ((azvn)localObject1).jdField_a_of_type_AndroidWidgetImageView.setTag(Integer.valueOf(localazxt.jdField_a_of_type_Int));
          label100:
          a((azvn)localObject1);
        }
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onRecyclerBindViewHolder(paramViewHolder, paramInt, getItemId(paramInt));
      return;
      Object localObject2 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject2).mRequestWidth = CustomCoverFragment.f(this.a);
      ((URLDrawable.URLDrawableOptions)localObject2).mRequestHeight = CustomCoverFragment.e(this.a);
      ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = CustomCoverFragment.a(this.a);
      ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = CustomCoverFragment.a(this.a);
      localObject2 = URLDrawable.getDrawable(localazxt.b, (URLDrawable.URLDrawableOptions)localObject2);
      ((azvn)localObject1).jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject2);
      break;
      ((azvn)localObject1).jdField_a_of_type_AndroidWidgetButton.setTag(Integer.valueOf(0));
      ((azvn)localObject1).jdField_a_of_type_AndroidWidgetImageView.setTag(Integer.valueOf(0));
      break label100;
      if ((paramViewHolder instanceof azvo))
      {
        localObject1 = (azvo)paramViewHolder;
        if (CustomCoverFragment.c(this.a) == 0)
        {
          CustomCoverFragment.c(this.a, 3);
          CustomCoverFragment.a(this.a);
        }
        if (CustomCoverFragment.c(this.a) == 3)
        {
          ((azvo)localObject1).itemView.setVisibility(0);
          ((azvo)localObject1).jdField_a_of_type_AndroidWidgetTextView.setTextColor(-16777216);
          ((azvo)localObject1).jdField_a_of_type_AndroidWidgetTextView.setText(2131689502);
          ((azvo)localObject1).jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
          ((azvo)localObject1).itemView.setBackgroundResource(2131166325);
        }
        else if (CustomCoverFragment.c(this.a) == 1)
        {
          ((azvo)localObject1).itemView.setVisibility(0);
          ((azvo)localObject1).jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.a.getResources().getColor(2131165688));
          ((azvo)localObject1).jdField_a_of_type_AndroidWidgetTextView.setText(2131690598);
          ((azvo)localObject1).jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
          ((azvo)localObject1).itemView.setBackgroundResource(2131167302);
        }
        else if (CustomCoverFragment.c(this.a) == 2)
        {
          ((azvo)localObject1).itemView.setVisibility(8);
        }
      }
    }
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    azvm localazvm = null;
    if (paramInt == 0)
    {
      paramViewGroup = this.a.getActivity().getLayoutInflater().inflate(2131562093, paramViewGroup, false);
      localazvm = new azvm(this.a, paramViewGroup);
    }
    do
    {
      return localazvm;
      if (paramInt == 1)
      {
        paramViewGroup = this.a.getActivity().getLayoutInflater().inflate(2131562094, paramViewGroup, false);
        paramViewGroup = new azvn(this.a, paramViewGroup);
        ((azvn)paramViewGroup).jdField_a_of_type_AndroidWidgetImageView.getLayoutParams().height = CustomCoverFragment.e(this.a);
        return paramViewGroup;
      }
    } while (paramInt != 2);
    paramViewGroup = this.a.getActivity().getLayoutInflater().inflate(2131561971, paramViewGroup, false);
    return new azvo(this.a, paramViewGroup);
  }
  
  public void onViewAttachedToWindow(RecyclerView.ViewHolder paramViewHolder)
  {
    boolean bool = true;
    super.onViewAttachedToWindow(paramViewHolder);
    Object localObject = paramViewHolder.itemView.getLayoutParams();
    if ((localObject != null) && ((localObject instanceof StaggeredGridLayoutManager.LayoutParams)))
    {
      localObject = (StaggeredGridLayoutManager.LayoutParams)localObject;
      if (getItemViewType(paramViewHolder.getLayoutPosition()) == 1) {
        break label49;
      }
    }
    for (;;)
    {
      ((StaggeredGridLayoutManager.LayoutParams)localObject).setFullSpan(bool);
      return;
      label49:
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azvp
 * JD-Core Version:    0.7.0.1
 */