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

public class ayke
  extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{
  public ayke(CustomCoverFragment paramCustomCoverFragment) {}
  
  private void a(aykc paramaykc)
  {
    if (CustomCoverFragment.c(this.a))
    {
      paramaykc.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130849962);
      paramaykc.jdField_a_of_type_AndroidWidgetButton.setTextColor(-8947849);
      paramaykc.jdField_a_of_type_AndroidWidgetButton.setText(2131694523);
      return;
    }
    if ((paramaykc.jdField_a_of_type_Int == CustomCoverFragment.a(this.a)) && (CustomCoverFragment.a(this.a)))
    {
      paramaykc.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130849962);
      paramaykc.jdField_a_of_type_AndroidWidgetButton.setTextColor(-8947849);
      paramaykc.jdField_a_of_type_AndroidWidgetButton.setText(2131718190);
      return;
    }
    paramaykc.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130849982);
    paramaykc.jdField_a_of_type_AndroidWidgetButton.setTextColor(-16777216);
    paramaykc.jdField_a_of_type_AndroidWidgetButton.setText(2131694523);
  }
  
  public aymi a(int paramInt)
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
    aymi localaymi;
    if ((paramViewHolder instanceof aykc))
    {
      localObject1 = (aykc)paramViewHolder;
      localaymi = a(paramInt);
      if (localaymi != null)
      {
        ((aykc)localObject1).jdField_a_of_type_Int = localaymi.jdField_a_of_type_Int;
        ((aykc)localObject1).jdField_a_of_type_AndroidWidgetTextView.setText(localaymi.jdField_a_of_type_JavaLangString);
        if (TextUtils.isEmpty(localaymi.b))
        {
          ((aykc)localObject1).jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(CustomCoverFragment.a(this.a));
          ((aykc)localObject1).jdField_a_of_type_AndroidWidgetButton.setTag(Integer.valueOf(localaymi.jdField_a_of_type_Int));
          ((aykc)localObject1).jdField_a_of_type_AndroidWidgetImageView.setTag(Integer.valueOf(localaymi.jdField_a_of_type_Int));
          label100:
          a((aykc)localObject1);
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
      localObject2 = URLDrawable.getDrawable(localaymi.b, (URLDrawable.URLDrawableOptions)localObject2);
      ((aykc)localObject1).jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject2);
      break;
      ((aykc)localObject1).jdField_a_of_type_AndroidWidgetButton.setTag(Integer.valueOf(0));
      ((aykc)localObject1).jdField_a_of_type_AndroidWidgetImageView.setTag(Integer.valueOf(0));
      break label100;
      if ((paramViewHolder instanceof aykd))
      {
        localObject1 = (aykd)paramViewHolder;
        if (CustomCoverFragment.c(this.a) == 0)
        {
          CustomCoverFragment.c(this.a, 3);
          CustomCoverFragment.a(this.a);
        }
        if (CustomCoverFragment.c(this.a) == 3)
        {
          ((aykd)localObject1).itemView.setVisibility(0);
          ((aykd)localObject1).jdField_a_of_type_AndroidWidgetTextView.setTextColor(-16777216);
          ((aykd)localObject1).jdField_a_of_type_AndroidWidgetTextView.setText(2131689502);
          ((aykd)localObject1).jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        }
        else if (CustomCoverFragment.c(this.a) == 1)
        {
          ((aykd)localObject1).itemView.setVisibility(0);
          ((aykd)localObject1).jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.a.getResources().getColor(2131165696));
          ((aykd)localObject1).jdField_a_of_type_AndroidWidgetTextView.setText(2131690638);
          ((aykd)localObject1).jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        }
        else if (CustomCoverFragment.c(this.a) == 2)
        {
          ((aykd)localObject1).itemView.setVisibility(8);
        }
      }
    }
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    aykb localaykb = null;
    if (paramInt == 0)
    {
      paramViewGroup = this.a.getActivity().getLayoutInflater().inflate(2131561968, paramViewGroup, false);
      localaykb = new aykb(this.a, paramViewGroup);
    }
    do
    {
      return localaykb;
      if (paramInt == 1)
      {
        paramViewGroup = this.a.getActivity().getLayoutInflater().inflate(2131561969, paramViewGroup, false);
        paramViewGroup = new aykc(this.a, paramViewGroup);
        ((aykc)paramViewGroup).jdField_a_of_type_AndroidWidgetImageView.getLayoutParams().height = CustomCoverFragment.e(this.a);
        return paramViewGroup;
      }
    } while (paramInt != 2);
    paramViewGroup = this.a.getActivity().getLayoutInflater().inflate(2131561848, paramViewGroup, false);
    return new aykd(this.a, paramViewGroup);
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
 * Qualified Name:     ayke
 * JD-Core Version:    0.7.0.1
 */