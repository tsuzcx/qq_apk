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

public class azdc
  extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{
  public azdc(CustomCoverFragment paramCustomCoverFragment) {}
  
  private void a(azda paramazda)
  {
    if (CustomCoverFragment.c(this.a))
    {
      paramazda.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130850033);
      paramazda.jdField_a_of_type_AndroidWidgetButton.setTextColor(-8947849);
      paramazda.jdField_a_of_type_AndroidWidgetButton.setText(2131694367);
      return;
    }
    if ((paramazda.jdField_a_of_type_Int == CustomCoverFragment.a(this.a)) && (CustomCoverFragment.a(this.a)))
    {
      paramazda.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130850033);
      paramazda.jdField_a_of_type_AndroidWidgetButton.setTextColor(-8947849);
      paramazda.jdField_a_of_type_AndroidWidgetButton.setText(2131717817);
      return;
    }
    paramazda.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130850053);
    paramazda.jdField_a_of_type_AndroidWidgetButton.setTextColor(-16777216);
    paramazda.jdField_a_of_type_AndroidWidgetButton.setText(2131694367);
  }
  
  public azfg a(int paramInt)
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
    azfg localazfg;
    if ((paramViewHolder instanceof azda))
    {
      localObject1 = (azda)paramViewHolder;
      localazfg = a(paramInt);
      if (localazfg != null)
      {
        ((azda)localObject1).jdField_a_of_type_Int = localazfg.jdField_a_of_type_Int;
        ((azda)localObject1).jdField_a_of_type_AndroidWidgetTextView.setText(localazfg.jdField_a_of_type_JavaLangString);
        if (TextUtils.isEmpty(localazfg.b))
        {
          ((azda)localObject1).jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(CustomCoverFragment.a(this.a));
          ((azda)localObject1).jdField_a_of_type_AndroidWidgetButton.setTag(Integer.valueOf(localazfg.jdField_a_of_type_Int));
          ((azda)localObject1).jdField_a_of_type_AndroidWidgetImageView.setTag(Integer.valueOf(localazfg.jdField_a_of_type_Int));
          label100:
          a((azda)localObject1);
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
      localObject2 = URLDrawable.getDrawable(localazfg.b, (URLDrawable.URLDrawableOptions)localObject2);
      ((azda)localObject1).jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject2);
      break;
      ((azda)localObject1).jdField_a_of_type_AndroidWidgetButton.setTag(Integer.valueOf(0));
      ((azda)localObject1).jdField_a_of_type_AndroidWidgetImageView.setTag(Integer.valueOf(0));
      break label100;
      if ((paramViewHolder instanceof azdb))
      {
        localObject1 = (azdb)paramViewHolder;
        if (CustomCoverFragment.c(this.a) == 0)
        {
          CustomCoverFragment.c(this.a, 3);
          CustomCoverFragment.a(this.a);
        }
        if (CustomCoverFragment.c(this.a) == 3)
        {
          ((azdb)localObject1).itemView.setVisibility(0);
          ((azdb)localObject1).jdField_a_of_type_AndroidWidgetTextView.setTextColor(-16777216);
          ((azdb)localObject1).jdField_a_of_type_AndroidWidgetTextView.setText(2131689501);
          ((azdb)localObject1).jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
          ((azdb)localObject1).itemView.setBackgroundResource(2131166321);
        }
        else if (CustomCoverFragment.c(this.a) == 1)
        {
          ((azdb)localObject1).itemView.setVisibility(0);
          ((azdb)localObject1).jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.a.getResources().getColor(2131165688));
          ((azdb)localObject1).jdField_a_of_type_AndroidWidgetTextView.setText(2131690600);
          ((azdb)localObject1).jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
          ((azdb)localObject1).itemView.setBackgroundResource(2131167279);
        }
        else if (CustomCoverFragment.c(this.a) == 2)
        {
          ((azdb)localObject1).itemView.setVisibility(8);
        }
      }
    }
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    azcz localazcz = null;
    if (paramInt == 0)
    {
      paramViewGroup = this.a.getActivity().getLayoutInflater().inflate(2131562053, paramViewGroup, false);
      localazcz = new azcz(this.a, paramViewGroup);
    }
    do
    {
      return localazcz;
      if (paramInt == 1)
      {
        paramViewGroup = this.a.getActivity().getLayoutInflater().inflate(2131562054, paramViewGroup, false);
        paramViewGroup = new azda(this.a, paramViewGroup);
        ((azda)paramViewGroup).jdField_a_of_type_AndroidWidgetImageView.getLayoutParams().height = CustomCoverFragment.e(this.a);
        return paramViewGroup;
      }
    } while (paramInt != 2);
    paramViewGroup = this.a.getActivity().getLayoutInflater().inflate(2131561931, paramViewGroup, false);
    return new azdb(this.a, paramViewGroup);
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
 * Qualified Name:     azdc
 * JD-Core Version:    0.7.0.1
 */