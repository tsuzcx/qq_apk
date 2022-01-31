import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import java.util.ArrayList;

public class blcq
  extends RecyclerView.Adapter<blcs>
{
  private int jdField_a_of_type_Int = -1;
  private Context jdField_a_of_type_AndroidContentContext;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private blcf jdField_a_of_type_Blcf;
  private ArrayList<blcb> jdField_a_of_type_JavaUtilArrayList;
  
  public blcq(Context paramContext, blcf paramblcf)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Blcf = paramblcf;
    a(this.jdField_a_of_type_Blcf.a());
    a(this.jdField_a_of_type_Blcf.a());
  }
  
  private void a(RecyclerView paramRecyclerView)
  {
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = paramRecyclerView;
  }
  
  private void a(ArrayList<blcb> paramArrayList)
  {
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
  }
  
  public blcs a(@NonNull ViewGroup paramViewGroup, int paramInt)
  {
    if (this.jdField_a_of_type_AndroidContentContext == null) {
      this.jdField_a_of_type_AndroidContentContext = paramViewGroup.getContext();
    }
    paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131558546, paramViewGroup, false);
    if (paramInt != 0) {
      paramViewGroup.setVisibility(4);
    }
    return new blcs(paramViewGroup);
  }
  
  public void a()
  {
    blcs localblcs = (blcs)this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.findViewHolderForLayoutPosition(this.jdField_a_of_type_Int);
    if (localblcs != null) {
      localblcs.a(false);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Int >= 0) {
        ((blcb)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Int - 1)).a(false);
      }
      this.jdField_a_of_type_Int = -1;
      return;
      if (this.jdField_a_of_type_Int >= 0) {
        notifyItemChanged(this.jdField_a_of_type_Int);
      }
    }
  }
  
  public void a(blcs paramblcs, int paramInt)
  {
    if (paramblcs.getLayoutPosition() == 0)
    {
      localObject = new FrameLayout.LayoutParams(bdaq.a(this.jdField_a_of_type_AndroidContentContext, 33.0F), bdaq.a(this.jdField_a_of_type_AndroidContentContext, 33.0F));
      ((FrameLayout.LayoutParams)localObject).setMargins(0, 0, bdaq.a(this.jdField_a_of_type_AndroidContentContext, 51.0F), 0);
      paramblcs.itemView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      return;
    }
    Object localObject = ((blcb)this.jdField_a_of_type_JavaUtilArrayList.get(paramblcs.getLayoutPosition() - 1)).a;
    paramblcs.a.setText((CharSequence)localObject);
    if (this.jdField_a_of_type_Int == paramblcs.getLayoutPosition()) {
      paramblcs.a(true);
    }
    for (;;)
    {
      paramblcs.itemView.setOnClickListener(new blcr(this, paramblcs, (String)localObject));
      return;
      paramblcs.a(false);
    }
  }
  
  public int getItemCount()
  {
    return this.jdField_a_of_type_JavaUtilArrayList.size() + 1;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    if (paramInt != 0) {
      return 0;
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blcq
 * JD-Core Version:    0.7.0.1
 */