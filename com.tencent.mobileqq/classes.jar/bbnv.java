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

public class bbnv
  extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{
  private int jdField_a_of_type_Int = -1;
  public Drawable a;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private bboa jdField_a_of_type_Bboa;
  public bbob a;
  private ArrayList<bbnx> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private int b;
  
  public bbnv(Context paramContext, bboa parambboa)
  {
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
    this.jdField_a_of_type_Bboa = parambboa;
    this.jdField_a_of_type_Bbob = new bbob();
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramContext.getResources().getDrawable(2130846164);
    this.jdField_b_of_type_Int = bawz.a(paramContext, 2.0F);
  }
  
  public bbnx a(int paramInt)
  {
    return (bbnx)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
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
      this.jdField_a_of_type_Bbob.a(-1);
    }
  }
  
  public void a(List<bbnx> paramList, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_JavaUtilArrayList.addAll(paramList);
    if (paramBoolean) {
      this.jdField_a_of_type_JavaUtilArrayList.add(new bbnx(4, null, 0, null));
    }
    notifyDataSetChanged();
  }
  
  public int getItemCount()
  {
    return this.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public long getItemId(int paramInt)
  {
    bbnx localbbnx = (bbnx)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    if (localbbnx.jdField_a_of_type_Int == 3) {
      return localbbnx.jdField_b_of_type_Int;
    }
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    return ((bbnx)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).jdField_a_of_type_Int;
  }
  
  public void onAttachedToRecyclerView(RecyclerView paramRecyclerView)
  {
    super.onAttachedToRecyclerView(paramRecyclerView);
    ((GridLayoutManager)paramRecyclerView.getLayoutManager()).setSpanSizeLookup(new bbnw(this));
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    Object localObject1 = (bbnx)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    switch (((bbnx)localObject1).jdField_a_of_type_Int)
    {
    }
    do
    {
      do
      {
        do
        {
          return;
        } while (!(paramViewHolder instanceof bbod));
        paramViewHolder = (bbod)paramViewHolder;
      } while (paramViewHolder.jdField_a_of_type_Int != 1);
      paramViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(((bbnx)localObject1).jdField_a_of_type_JavaLangString);
      return;
    } while (!(paramViewHolder instanceof bbnz));
    paramViewHolder = (bbnz)paramViewHolder;
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
      localObject1 = URLDrawable.getDrawable(((bbnx)localObject1).jdField_b_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject2);
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
      return new bbod(this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131561482, paramViewGroup, false), 1);
    case 3: 
      return new bbnz(this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131561483, paramViewGroup, false), this, this.jdField_a_of_type_Bboa);
    case 2: 
      return new bboc(this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131561485, paramViewGroup, false), this.jdField_a_of_type_Bboa, this.jdField_a_of_type_Bbob, this);
    }
    return new bbod(this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131561481, paramViewGroup, false), 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     bbnv
 * JD-Core Version:    0.7.0.1
 */