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
import java.util.Vector;

public class ausu
  extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{
  public ausu(CustomCoverFragment paramCustomCoverFragment) {}
  
  private void a(auss paramauss)
  {
    if (CustomCoverFragment.c(this.a))
    {
      paramauss.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130848978);
      paramauss.jdField_a_of_type_AndroidWidgetButton.setTextColor(-8947849);
      paramauss.jdField_a_of_type_AndroidWidgetButton.setText(2131695245);
      return;
    }
    if ((paramauss.jdField_a_of_type_Int == CustomCoverFragment.a(this.a)) && (CustomCoverFragment.a(this.a)))
    {
      paramauss.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130848978);
      paramauss.jdField_a_of_type_AndroidWidgetButton.setTextColor(-8947849);
      paramauss.jdField_a_of_type_AndroidWidgetButton.setText(2131719367);
      return;
    }
    paramauss.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130848998);
    paramauss.jdField_a_of_type_AndroidWidgetButton.setTextColor(-16777216);
    paramauss.jdField_a_of_type_AndroidWidgetButton.setText(2131695245);
  }
  
  public auva a(int paramInt)
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
    auva localauva;
    if ((paramViewHolder instanceof auss))
    {
      paramViewHolder = (auss)paramViewHolder;
      localauva = a(paramInt);
      if (localauva != null)
      {
        paramViewHolder.jdField_a_of_type_Int = localauva.jdField_a_of_type_Int;
        paramViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(localauva.jdField_a_of_type_JavaLangString);
        if (TextUtils.isEmpty(localauva.b))
        {
          paramViewHolder.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(CustomCoverFragment.a(this.a));
          paramViewHolder.jdField_a_of_type_AndroidWidgetButton.setTag(Integer.valueOf(localauva.jdField_a_of_type_Int));
          paramViewHolder.jdField_a_of_type_AndroidWidgetImageView.setTag(Integer.valueOf(localauva.jdField_a_of_type_Int));
          label93:
          a(paramViewHolder);
        }
      }
    }
    do
    {
      do
      {
        return;
        Object localObject = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = CustomCoverFragment.f(this.a);
        ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = CustomCoverFragment.e(this.a);
        ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = CustomCoverFragment.a(this.a);
        ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = CustomCoverFragment.a(this.a);
        localObject = URLDrawable.getDrawable(localauva.b, (URLDrawable.URLDrawableOptions)localObject);
        paramViewHolder.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
        break;
        paramViewHolder.jdField_a_of_type_AndroidWidgetButton.setTag(Integer.valueOf(0));
        paramViewHolder.jdField_a_of_type_AndroidWidgetImageView.setTag(Integer.valueOf(0));
        break label93;
      } while (!(paramViewHolder instanceof aust));
      paramViewHolder = (aust)paramViewHolder;
      if (CustomCoverFragment.c(this.a) == 0)
      {
        CustomCoverFragment.c(this.a, 3);
        CustomCoverFragment.a(this.a);
      }
      if (CustomCoverFragment.c(this.a) == 3)
      {
        paramViewHolder.itemView.setVisibility(0);
        paramViewHolder.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-16777216);
        paramViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(2131689555);
        paramViewHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        paramViewHolder.itemView.setBackgroundResource(2131166201);
        return;
      }
      if (CustomCoverFragment.c(this.a) == 1)
      {
        paramViewHolder.itemView.setVisibility(0);
        paramViewHolder.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.a.getResources().getColor(2131165614));
        paramViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(2131690618);
        paramViewHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        paramViewHolder.itemView.setBackgroundResource(2131167134);
        return;
      }
    } while (CustomCoverFragment.c(this.a) != 2);
    paramViewHolder.itemView.setVisibility(8);
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    ausr localausr = null;
    if (paramInt == 0)
    {
      paramViewGroup = this.a.getActivity().getLayoutInflater().inflate(2131561604, paramViewGroup, false);
      localausr = new ausr(this.a, paramViewGroup);
    }
    do
    {
      return localausr;
      if (paramInt == 1)
      {
        paramViewGroup = this.a.getActivity().getLayoutInflater().inflate(2131561605, paramViewGroup, false);
        paramViewGroup = new auss(this.a, paramViewGroup);
        ((auss)paramViewGroup).jdField_a_of_type_AndroidWidgetImageView.getLayoutParams().height = CustomCoverFragment.e(this.a);
        return paramViewGroup;
      }
    } while (paramInt != 2);
    paramViewGroup = this.a.getActivity().getLayoutInflater().inflate(2131561486, paramViewGroup, false);
    return new aust(this.a, paramViewGroup);
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
 * Qualified Name:     ausu
 * JD-Core Version:    0.7.0.1
 */