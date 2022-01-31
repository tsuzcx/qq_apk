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

public class awop
  extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{
  public awop(CustomCoverFragment paramCustomCoverFragment) {}
  
  private void a(awon paramawon)
  {
    if (CustomCoverFragment.c(this.a))
    {
      paramawon.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130849482);
      paramawon.jdField_a_of_type_AndroidWidgetButton.setTextColor(-8947849);
      paramawon.jdField_a_of_type_AndroidWidgetButton.setText(2131695405);
      return;
    }
    if ((paramawon.jdField_a_of_type_Int == CustomCoverFragment.a(this.a)) && (CustomCoverFragment.a(this.a)))
    {
      paramawon.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130849482);
      paramawon.jdField_a_of_type_AndroidWidgetButton.setTextColor(-8947849);
      paramawon.jdField_a_of_type_AndroidWidgetButton.setText(2131719863);
      return;
    }
    paramawon.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130849502);
    paramawon.jdField_a_of_type_AndroidWidgetButton.setTextColor(-16777216);
    paramawon.jdField_a_of_type_AndroidWidgetButton.setText(2131695405);
  }
  
  public awqv a(int paramInt)
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
    awqv localawqv;
    if ((paramViewHolder instanceof awon))
    {
      paramViewHolder = (awon)paramViewHolder;
      localawqv = a(paramInt);
      if (localawqv != null)
      {
        paramViewHolder.jdField_a_of_type_Int = localawqv.jdField_a_of_type_Int;
        paramViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(localawqv.jdField_a_of_type_JavaLangString);
        if (TextUtils.isEmpty(localawqv.b))
        {
          paramViewHolder.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(CustomCoverFragment.a(this.a));
          paramViewHolder.jdField_a_of_type_AndroidWidgetButton.setTag(Integer.valueOf(localawqv.jdField_a_of_type_Int));
          paramViewHolder.jdField_a_of_type_AndroidWidgetImageView.setTag(Integer.valueOf(localawqv.jdField_a_of_type_Int));
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
        localObject = URLDrawable.getDrawable(localawqv.b, (URLDrawable.URLDrawableOptions)localObject);
        paramViewHolder.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
        break;
        paramViewHolder.jdField_a_of_type_AndroidWidgetButton.setTag(Integer.valueOf(0));
        paramViewHolder.jdField_a_of_type_AndroidWidgetImageView.setTag(Integer.valueOf(0));
        break label93;
      } while (!(paramViewHolder instanceof awoo));
      paramViewHolder = (awoo)paramViewHolder;
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
        paramViewHolder.itemView.setBackgroundResource(2131166250);
        return;
      }
      if (CustomCoverFragment.c(this.a) == 1)
      {
        paramViewHolder.itemView.setVisibility(0);
        paramViewHolder.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.a.getResources().getColor(2131165650));
        paramViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(2131690670);
        paramViewHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        paramViewHolder.itemView.setBackgroundResource(2131167194);
        return;
      }
    } while (CustomCoverFragment.c(this.a) != 2);
    paramViewHolder.itemView.setVisibility(8);
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    awom localawom = null;
    if (paramInt == 0)
    {
      paramViewGroup = this.a.getActivity().getLayoutInflater().inflate(2131561813, paramViewGroup, false);
      localawom = new awom(this.a, paramViewGroup);
    }
    do
    {
      return localawom;
      if (paramInt == 1)
      {
        paramViewGroup = this.a.getActivity().getLayoutInflater().inflate(2131561814, paramViewGroup, false);
        paramViewGroup = new awon(this.a, paramViewGroup);
        ((awon)paramViewGroup).jdField_a_of_type_AndroidWidgetImageView.getLayoutParams().height = CustomCoverFragment.e(this.a);
        return paramViewGroup;
      }
    } while (paramInt != 2);
    paramViewGroup = this.a.getActivity().getLayoutInflater().inflate(2131561694, paramViewGroup, false);
    return new awoo(this.a, paramViewGroup);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     awop
 * JD-Core Version:    0.7.0.1
 */