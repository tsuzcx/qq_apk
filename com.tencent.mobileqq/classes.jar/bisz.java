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

public class bisz
  extends RecyclerView.Adapter<bitb>
{
  private int jdField_a_of_type_Int = -1;
  private Context jdField_a_of_type_AndroidContentContext;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private biso jdField_a_of_type_Biso;
  private ArrayList<bisk> jdField_a_of_type_JavaUtilArrayList;
  
  public bisz(Context paramContext, biso parambiso)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Biso = parambiso;
    a(this.jdField_a_of_type_Biso.a());
    a(this.jdField_a_of_type_Biso.a());
  }
  
  private void a(RecyclerView paramRecyclerView)
  {
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = paramRecyclerView;
  }
  
  private void a(ArrayList<bisk> paramArrayList)
  {
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
  }
  
  public bitb a(@NonNull ViewGroup paramViewGroup, int paramInt)
  {
    if (this.jdField_a_of_type_AndroidContentContext == null) {
      this.jdField_a_of_type_AndroidContentContext = paramViewGroup.getContext();
    }
    paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131558522, paramViewGroup, false);
    if (paramInt != 0) {
      paramViewGroup.setVisibility(4);
    }
    return new bitb(paramViewGroup);
  }
  
  public void a()
  {
    bitb localbitb = (bitb)this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.findViewHolderForLayoutPosition(this.jdField_a_of_type_Int);
    if (localbitb != null) {
      localbitb.a(false);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Int >= 0) {
        ((bisk)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Int - 1)).a(false);
      }
      this.jdField_a_of_type_Int = -1;
      return;
      if (this.jdField_a_of_type_Int >= 0) {
        notifyItemChanged(this.jdField_a_of_type_Int);
      }
    }
  }
  
  public void a(bitb parambitb, int paramInt)
  {
    if (parambitb.getLayoutPosition() == 0)
    {
      localObject = new FrameLayout.LayoutParams(bawz.a(this.jdField_a_of_type_AndroidContentContext, 33.0F), bawz.a(this.jdField_a_of_type_AndroidContentContext, 33.0F));
      ((FrameLayout.LayoutParams)localObject).setMargins(0, 0, bawz.a(this.jdField_a_of_type_AndroidContentContext, 51.0F), 0);
      parambitb.itemView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      return;
    }
    Object localObject = ((bisk)this.jdField_a_of_type_JavaUtilArrayList.get(parambitb.getLayoutPosition() - 1)).a;
    parambitb.a.setText((CharSequence)localObject);
    if (this.jdField_a_of_type_Int == parambitb.getLayoutPosition()) {
      parambitb.a(true);
    }
    for (;;)
    {
      parambitb.itemView.setOnClickListener(new bita(this, parambitb, (String)localObject));
      return;
      parambitb.a(false);
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
 * Qualified Name:     bisz
 * JD-Core Version:    0.7.0.1
 */