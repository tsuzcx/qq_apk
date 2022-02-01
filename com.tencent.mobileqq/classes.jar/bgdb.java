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

public class bgdb
  extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{
  private int jdField_a_of_type_Int = -1;
  public Drawable a;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private bgdg jdField_a_of_type_Bgdg;
  public bgdh a;
  private ArrayList<bgdd> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private int b;
  
  public bgdb(Context paramContext, bgdg parambgdg)
  {
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
    this.jdField_a_of_type_Bgdg = parambgdg;
    this.jdField_a_of_type_Bgdh = new bgdh();
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramContext.getResources().getDrawable(2130846989);
    this.jdField_b_of_type_Int = DisplayUtil.dip2px(paramContext, 2.0F);
  }
  
  public bgdd a(int paramInt)
  {
    return (bgdd)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
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
      this.jdField_a_of_type_Bgdh.a(-1);
    }
  }
  
  public void a(List<bgdd> paramList, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_JavaUtilArrayList.addAll(paramList);
    if (paramBoolean) {
      this.jdField_a_of_type_JavaUtilArrayList.add(new bgdd(4, null, 0, null));
    }
    notifyDataSetChanged();
  }
  
  public int getItemCount()
  {
    return this.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public long getItemId(int paramInt)
  {
    bgdd localbgdd = (bgdd)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    if (localbgdd.jdField_a_of_type_Int == 3) {
      return localbgdd.jdField_b_of_type_Int;
    }
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    return ((bgdd)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).jdField_a_of_type_Int;
  }
  
  public void onAttachedToRecyclerView(RecyclerView paramRecyclerView)
  {
    super.onAttachedToRecyclerView(paramRecyclerView);
    ((GridLayoutManager)paramRecyclerView.getLayoutManager()).setSpanSizeLookup(new bgdc(this));
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    Object localObject1 = (bgdd)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    switch (((bgdd)localObject1).jdField_a_of_type_Int)
    {
    }
    do
    {
      for (;;)
      {
        EventCollector.getInstance().onRecyclerBindViewHolder(paramViewHolder, paramInt, getItemId(paramInt));
        return;
        if ((paramViewHolder instanceof bgdj))
        {
          localObject2 = (bgdj)paramViewHolder;
          if (((bgdj)localObject2).jdField_a_of_type_Int == 1) {
            ((bgdj)localObject2).jdField_a_of_type_AndroidWidgetTextView.setText(((bgdd)localObject1).jdField_a_of_type_JavaLangString);
          }
        }
      }
    } while (!(paramViewHolder instanceof bgdf));
    Object localObject2 = (bgdf)paramViewHolder;
    ((bgdf)localObject2).jdField_a_of_type_Int = paramInt;
    Object localObject3 = (GridLayoutManager.LayoutParams)((bgdf)localObject2).itemView.getLayoutParams();
    if (paramInt % 3 == 0)
    {
      ((GridLayoutManager.LayoutParams)localObject3).rightMargin = 0;
      label139:
      if (paramInt != this.jdField_a_of_type_Int) {
        break label213;
      }
      ((bgdf)localObject2).b.setVisibility(0);
    }
    for (;;)
    {
      localObject3 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject3).mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      ((URLDrawable.URLDrawableOptions)localObject3).mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      localObject1 = URLDrawable.getDrawable(((bgdd)localObject1).jdField_b_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject3);
      ((bgdf)localObject2).jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject1);
      break;
      ((GridLayoutManager.LayoutParams)localObject3).rightMargin = this.jdField_b_of_type_Int;
      break label139;
      label213:
      ((bgdf)localObject2).b.setVisibility(8);
    }
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
      return new bgdj(this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131561843, paramViewGroup, false), 1);
    case 3: 
      return new bgdf(this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131561844, paramViewGroup, false), this, this.jdField_a_of_type_Bgdg);
    case 2: 
      return new bgdi(this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131561846, paramViewGroup, false), this.jdField_a_of_type_Bgdg, this.jdField_a_of_type_Bgdh, this);
    }
    return new bgdj(this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131561842, paramViewGroup, false), 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgdb
 * JD-Core Version:    0.7.0.1
 */