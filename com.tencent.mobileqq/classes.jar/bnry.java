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
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

public class bnry
  extends RecyclerView.Adapter<bnsa>
{
  private int jdField_a_of_type_Int = -1;
  private Context jdField_a_of_type_AndroidContentContext;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private bnrn jdField_a_of_type_Bnrn;
  private ArrayList<bnrj> jdField_a_of_type_JavaUtilArrayList;
  
  public bnry(Context paramContext, bnrn parambnrn)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Bnrn = parambnrn;
    a(this.jdField_a_of_type_Bnrn.a());
    a(this.jdField_a_of_type_Bnrn.a());
  }
  
  private void a(RecyclerView paramRecyclerView)
  {
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = paramRecyclerView;
  }
  
  private void a(ArrayList<bnrj> paramArrayList)
  {
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
  }
  
  public bnsa a(@NonNull ViewGroup paramViewGroup, int paramInt)
  {
    if (this.jdField_a_of_type_AndroidContentContext == null) {
      this.jdField_a_of_type_AndroidContentContext = paramViewGroup.getContext();
    }
    paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131558573, paramViewGroup, false);
    if (paramInt != 0) {
      paramViewGroup.setVisibility(4);
    }
    return new bnsa(paramViewGroup);
  }
  
  public void a()
  {
    bnsa localbnsa = (bnsa)this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.findViewHolderForLayoutPosition(this.jdField_a_of_type_Int);
    if (localbnsa != null) {
      localbnsa.a(false);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Int >= 0) {
        ((bnrj)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Int - 1)).a(false);
      }
      this.jdField_a_of_type_Int = -1;
      return;
      if (this.jdField_a_of_type_Int >= 0) {
        notifyItemChanged(this.jdField_a_of_type_Int);
      }
    }
  }
  
  public void a(bnsa parambnsa, int paramInt)
  {
    if (parambnsa.getLayoutPosition() == 0)
    {
      localObject = new FrameLayout.LayoutParams(bggq.a(this.jdField_a_of_type_AndroidContentContext, 33.0F), bggq.a(this.jdField_a_of_type_AndroidContentContext, 33.0F));
      ((FrameLayout.LayoutParams)localObject).setMargins(0, 0, bggq.a(this.jdField_a_of_type_AndroidContentContext, 51.0F), 0);
      parambnsa.itemView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      EventCollector.getInstance().onRecyclerBindViewHolder(parambnsa, paramInt, getItemId(paramInt));
      return;
    }
    Object localObject = ((bnrj)this.jdField_a_of_type_JavaUtilArrayList.get(parambnsa.getLayoutPosition() - 1)).a;
    parambnsa.a.setText((CharSequence)localObject);
    if (this.jdField_a_of_type_Int == parambnsa.getLayoutPosition()) {
      parambnsa.a(true);
    }
    for (;;)
    {
      parambnsa.itemView.setOnClickListener(new bnrz(this, parambnsa, (String)localObject));
      break;
      parambnsa.a(false);
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
 * Qualified Name:     bnry
 * JD-Core Version:    0.7.0.1
 */