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

public class bkyj
  extends RecyclerView.Adapter<bkyl>
{
  private int jdField_a_of_type_Int = -1;
  private Context jdField_a_of_type_AndroidContentContext;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private bkxy jdField_a_of_type_Bkxy;
  private ArrayList<bkxu> jdField_a_of_type_JavaUtilArrayList;
  
  public bkyj(Context paramContext, bkxy parambkxy)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Bkxy = parambkxy;
    a(this.jdField_a_of_type_Bkxy.a());
    a(this.jdField_a_of_type_Bkxy.a());
  }
  
  private void a(RecyclerView paramRecyclerView)
  {
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = paramRecyclerView;
  }
  
  private void a(ArrayList<bkxu> paramArrayList)
  {
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
  }
  
  public bkyl a(@NonNull ViewGroup paramViewGroup, int paramInt)
  {
    if (this.jdField_a_of_type_AndroidContentContext == null) {
      this.jdField_a_of_type_AndroidContentContext = paramViewGroup.getContext();
    }
    paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131558546, paramViewGroup, false);
    if (paramInt != 0) {
      paramViewGroup.setVisibility(4);
    }
    return new bkyl(paramViewGroup);
  }
  
  public void a()
  {
    bkyl localbkyl = (bkyl)this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.findViewHolderForLayoutPosition(this.jdField_a_of_type_Int);
    if (localbkyl != null) {
      localbkyl.a(false);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Int >= 0) {
        ((bkxu)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Int - 1)).a(false);
      }
      this.jdField_a_of_type_Int = -1;
      return;
      if (this.jdField_a_of_type_Int >= 0) {
        notifyItemChanged(this.jdField_a_of_type_Int);
      }
    }
  }
  
  public void a(bkyl parambkyl, int paramInt)
  {
    if (parambkyl.getLayoutPosition() == 0)
    {
      localObject = new FrameLayout.LayoutParams(bcwh.a(this.jdField_a_of_type_AndroidContentContext, 33.0F), bcwh.a(this.jdField_a_of_type_AndroidContentContext, 33.0F));
      ((FrameLayout.LayoutParams)localObject).setMargins(0, 0, bcwh.a(this.jdField_a_of_type_AndroidContentContext, 51.0F), 0);
      parambkyl.itemView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      return;
    }
    Object localObject = ((bkxu)this.jdField_a_of_type_JavaUtilArrayList.get(parambkyl.getLayoutPosition() - 1)).a;
    parambkyl.a.setText((CharSequence)localObject);
    if (this.jdField_a_of_type_Int == parambkyl.getLayoutPosition()) {
      parambkyl.a(true);
    }
    for (;;)
    {
      parambkyl.itemView.setOnClickListener(new bkyk(this, parambkyl, (String)localObject));
      return;
      parambkyl.a(false);
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
 * Qualified Name:     bkyj
 * JD-Core Version:    0.7.0.1
 */