import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.GridLayoutManager.LayoutParams;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

public class bhls
  extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{
  private int jdField_a_of_type_Int = -1;
  public Drawable a;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private bhlx jdField_a_of_type_Bhlx;
  public bhly a;
  private ArrayList<bhlu> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private int b;
  
  public bhls(Context paramContext, bhlx parambhlx)
  {
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
    this.jdField_a_of_type_Bhlx = parambhlx;
    this.jdField_a_of_type_Bhly = new bhly();
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramContext.getResources().getDrawable(2130847086);
    this.jdField_b_of_type_Int = DisplayUtil.dip2px(paramContext, 2.0F);
  }
  
  public bhlu a(int paramInt)
  {
    return (bhlu)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
  }
  
  public void a(int paramInt)
  {
    int i = this.jdField_a_of_type_Int;
    this.jdField_a_of_type_Int = paramInt;
    if (i > 0) {
      notifyItemChanged(i);
    }
    if (this.jdField_a_of_type_Int > 0) {
      notifyItemChanged(this.jdField_a_of_type_Int);
    }
    if (paramInt > 0) {
      this.jdField_a_of_type_Bhly.a(-1);
    }
  }
  
  public void a(List<bhlu> paramList, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_JavaUtilArrayList.addAll(paramList);
    if (paramBoolean) {
      this.jdField_a_of_type_JavaUtilArrayList.add(new bhlu(4, null, 0, null));
    }
    notifyDataSetChanged();
  }
  
  public int getItemCount()
  {
    return this.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public long getItemId(int paramInt)
  {
    bhlu localbhlu = (bhlu)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    if (localbhlu.jdField_a_of_type_Int == 3) {
      return localbhlu.jdField_b_of_type_Int;
    }
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    return ((bhlu)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).jdField_a_of_type_Int;
  }
  
  public void onAttachedToRecyclerView(RecyclerView paramRecyclerView)
  {
    super.onAttachedToRecyclerView(paramRecyclerView);
    ((GridLayoutManager)paramRecyclerView.getLayoutManager()).setSpanSizeLookup(new bhlt(this));
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    Object localObject1 = (bhlu)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    switch (((bhlu)localObject1).jdField_a_of_type_Int)
    {
    }
    do
    {
      for (;;)
      {
        EventCollector.getInstance().onRecyclerBindViewHolder(paramViewHolder, paramInt, getItemId(paramInt));
        return;
        if ((paramViewHolder instanceof bhma))
        {
          localObject2 = (bhma)paramViewHolder;
          if (((bhma)localObject2).jdField_a_of_type_Int == 1) {
            ((bhma)localObject2).jdField_a_of_type_AndroidWidgetTextView.setText(((bhlu)localObject1).jdField_a_of_type_JavaLangString);
          }
        }
      }
    } while (!(paramViewHolder instanceof bhlw));
    Object localObject2 = (bhlw)paramViewHolder;
    ((bhlw)localObject2).jdField_a_of_type_Int = paramInt;
    Object localObject3 = (GridLayoutManager.LayoutParams)((bhlw)localObject2).itemView.getLayoutParams();
    if (paramInt % 3 == 0)
    {
      ((GridLayoutManager.LayoutParams)localObject3).rightMargin = 0;
      label139:
      if (paramInt != this.jdField_a_of_type_Int) {
        break label213;
      }
      ((bhlw)localObject2).b.setVisibility(0);
    }
    for (;;)
    {
      localObject3 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject3).mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      ((URLDrawable.URLDrawableOptions)localObject3).mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      localObject1 = URLDrawable.getDrawable(((bhlu)localObject1).jdField_b_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject3);
      ((bhlw)localObject2).jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject1);
      break;
      ((GridLayoutManager.LayoutParams)localObject3).rightMargin = this.jdField_b_of_type_Int;
      break label139;
      label213:
      ((bhlw)localObject2).b.setVisibility(8);
    }
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
      return new bhma(this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131561911, paramViewGroup, false), 1);
    case 3: 
      return new bhlw(this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131561912, paramViewGroup, false), this, this.jdField_a_of_type_Bhlx);
    case 2: 
      return new bhlz(this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131561914, paramViewGroup, false), this.jdField_a_of_type_Bhlx, this.jdField_a_of_type_Bhly, this);
    }
    return new bhma(this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131561910, paramViewGroup, false), 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhls
 * JD-Core Version:    0.7.0.1
 */