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

public class bitq
  extends RecyclerView.Adapter<bits>
{
  private int jdField_a_of_type_Int = -1;
  private Context jdField_a_of_type_AndroidContentContext;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private bitf jdField_a_of_type_Bitf;
  private ArrayList<bitb> jdField_a_of_type_JavaUtilArrayList;
  
  public bitq(Context paramContext, bitf parambitf)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Bitf = parambitf;
    a(this.jdField_a_of_type_Bitf.a());
    a(this.jdField_a_of_type_Bitf.a());
  }
  
  private void a(RecyclerView paramRecyclerView)
  {
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = paramRecyclerView;
  }
  
  private void a(ArrayList<bitb> paramArrayList)
  {
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
  }
  
  public bits a(@NonNull ViewGroup paramViewGroup, int paramInt)
  {
    if (this.jdField_a_of_type_AndroidContentContext == null) {
      this.jdField_a_of_type_AndroidContentContext = paramViewGroup.getContext();
    }
    paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131558522, paramViewGroup, false);
    if (paramInt != 0) {
      paramViewGroup.setVisibility(4);
    }
    return new bits(paramViewGroup);
  }
  
  public void a()
  {
    bits localbits = (bits)this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.findViewHolderForLayoutPosition(this.jdField_a_of_type_Int);
    if (localbits != null) {
      localbits.a(false);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Int >= 0) {
        ((bitb)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Int - 1)).a(false);
      }
      this.jdField_a_of_type_Int = -1;
      return;
      if (this.jdField_a_of_type_Int >= 0) {
        notifyItemChanged(this.jdField_a_of_type_Int);
      }
    }
  }
  
  public void a(bits parambits, int paramInt)
  {
    if (parambits.getLayoutPosition() == 0)
    {
      localObject = new FrameLayout.LayoutParams(baxn.a(this.jdField_a_of_type_AndroidContentContext, 33.0F), baxn.a(this.jdField_a_of_type_AndroidContentContext, 33.0F));
      ((FrameLayout.LayoutParams)localObject).setMargins(0, 0, baxn.a(this.jdField_a_of_type_AndroidContentContext, 51.0F), 0);
      parambits.itemView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      return;
    }
    Object localObject = ((bitb)this.jdField_a_of_type_JavaUtilArrayList.get(parambits.getLayoutPosition() - 1)).a;
    parambits.a.setText((CharSequence)localObject);
    if (this.jdField_a_of_type_Int == parambits.getLayoutPosition()) {
      parambits.a(true);
    }
    for (;;)
    {
      parambits.itemView.setOnClickListener(new bitr(this, parambits, (String)localObject));
      return;
      parambits.a(false);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bitq
 * JD-Core Version:    0.7.0.1
 */