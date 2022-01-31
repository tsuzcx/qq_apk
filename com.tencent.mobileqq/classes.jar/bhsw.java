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

public class bhsw
  extends RecyclerView.Adapter<bhsy>
{
  private int jdField_a_of_type_Int = -1;
  private Context jdField_a_of_type_AndroidContentContext;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private bhsk jdField_a_of_type_Bhsk;
  private ArrayList<bhsg> jdField_a_of_type_JavaUtilArrayList;
  
  public bhsw(Context paramContext, bhsk parambhsk)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Bhsk = parambhsk;
    a(this.jdField_a_of_type_Bhsk.a());
    a(this.jdField_a_of_type_Bhsk.a());
  }
  
  private void a(RecyclerView paramRecyclerView)
  {
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = paramRecyclerView;
  }
  
  private void a(ArrayList<bhsg> paramArrayList)
  {
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
  }
  
  public bhsy a(@NonNull ViewGroup paramViewGroup, int paramInt)
  {
    if (this.jdField_a_of_type_AndroidContentContext == null) {
      this.jdField_a_of_type_AndroidContentContext = paramViewGroup.getContext();
    }
    paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131492971, paramViewGroup, false);
    if (paramInt != 0) {
      paramViewGroup.setVisibility(4);
    }
    return new bhsy(paramViewGroup);
  }
  
  public void a()
  {
    bhsy localbhsy = (bhsy)this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.findViewHolderForLayoutPosition(this.jdField_a_of_type_Int);
    if (localbhsy != null) {
      localbhsy.a(false);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Int >= 0) {
        ((bhsg)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Int - 1)).a(false);
      }
      this.jdField_a_of_type_Int = -1;
      return;
      if (this.jdField_a_of_type_Int >= 0) {
        notifyItemChanged(this.jdField_a_of_type_Int);
      }
    }
  }
  
  public void a(bhsy parambhsy, int paramInt)
  {
    if (parambhsy.getLayoutPosition() == 0)
    {
      localObject = new FrameLayout.LayoutParams(azvv.a(this.jdField_a_of_type_AndroidContentContext, 33.0F), azvv.a(this.jdField_a_of_type_AndroidContentContext, 33.0F));
      ((FrameLayout.LayoutParams)localObject).setMargins(0, 0, azvv.a(this.jdField_a_of_type_AndroidContentContext, 51.0F), 0);
      parambhsy.itemView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      return;
    }
    Object localObject = ((bhsg)this.jdField_a_of_type_JavaUtilArrayList.get(parambhsy.getLayoutPosition() - 1)).a;
    parambhsy.a.setText((CharSequence)localObject);
    if (this.jdField_a_of_type_Int == parambhsy.getLayoutPosition()) {
      parambhsy.a(true);
    }
    for (;;)
    {
      parambhsy.itemView.setOnClickListener(new bhsx(this, parambhsy, (String)localObject));
      return;
      parambhsy.a(false);
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
 * Qualified Name:     bhsw
 * JD-Core Version:    0.7.0.1
 */