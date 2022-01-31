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
import java.util.ArrayList;
import java.util.List;

public class bdrm
  extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{
  private int jdField_a_of_type_Int = -1;
  public Drawable a;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private bdrr jdField_a_of_type_Bdrr;
  public bdrs a;
  private ArrayList<bdro> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private int b;
  
  public bdrm(Context paramContext, bdrr parambdrr)
  {
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
    this.jdField_a_of_type_Bdrr = parambdrr;
    this.jdField_a_of_type_Bdrs = new bdrs();
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramContext.getResources().getDrawable(2130846622);
    this.jdField_b_of_type_Int = bdaq.a(paramContext, 2.0F);
  }
  
  public bdro a(int paramInt)
  {
    return (bdro)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
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
      this.jdField_a_of_type_Bdrs.a(-1);
    }
  }
  
  public void a(List<bdro> paramList, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_JavaUtilArrayList.addAll(paramList);
    if (paramBoolean) {
      this.jdField_a_of_type_JavaUtilArrayList.add(new bdro(4, null, 0, null));
    }
    notifyDataSetChanged();
  }
  
  public int getItemCount()
  {
    return this.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public long getItemId(int paramInt)
  {
    bdro localbdro = (bdro)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    if (localbdro.jdField_a_of_type_Int == 3) {
      return localbdro.jdField_b_of_type_Int;
    }
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    return ((bdro)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).jdField_a_of_type_Int;
  }
  
  public void onAttachedToRecyclerView(RecyclerView paramRecyclerView)
  {
    super.onAttachedToRecyclerView(paramRecyclerView);
    ((GridLayoutManager)paramRecyclerView.getLayoutManager()).setSpanSizeLookup(new bdrn(this));
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    Object localObject1 = (bdro)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    switch (((bdro)localObject1).jdField_a_of_type_Int)
    {
    }
    do
    {
      do
      {
        do
        {
          return;
        } while (!(paramViewHolder instanceof bdru));
        paramViewHolder = (bdru)paramViewHolder;
      } while (paramViewHolder.jdField_a_of_type_Int != 1);
      paramViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(((bdro)localObject1).jdField_a_of_type_JavaLangString);
      return;
    } while (!(paramViewHolder instanceof bdrq));
    paramViewHolder = (bdrq)paramViewHolder;
    paramViewHolder.jdField_a_of_type_Int = paramInt;
    Object localObject2 = (GridLayoutManager.LayoutParams)paramViewHolder.itemView.getLayoutParams();
    if (paramInt % 3 == 0)
    {
      ((GridLayoutManager.LayoutParams)localObject2).rightMargin = 0;
      if (paramInt != this.jdField_a_of_type_Int) {
        break label188;
      }
      paramViewHolder.b.setVisibility(0);
    }
    for (;;)
    {
      localObject2 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      localObject1 = URLDrawable.getDrawable(((bdro)localObject1).jdField_b_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject2);
      paramViewHolder.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject1);
      return;
      ((GridLayoutManager.LayoutParams)localObject2).rightMargin = this.jdField_b_of_type_Int;
      break;
      label188:
      paramViewHolder.b.setVisibility(8);
    }
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
      return new bdru(this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131561689, paramViewGroup, false), 1);
    case 3: 
      return new bdrq(this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131561690, paramViewGroup, false), this, this.jdField_a_of_type_Bdrr);
    case 2: 
      return new bdrt(this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131561692, paramViewGroup, false), this.jdField_a_of_type_Bdrr, this.jdField_a_of_type_Bdrs, this);
    }
    return new bdru(this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131561688, paramViewGroup, false), 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdrm
 * JD-Core Version:    0.7.0.1
 */