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

public class botm
  extends RecyclerView.Adapter<boto>
{
  private int jdField_a_of_type_Int = -1;
  private Context jdField_a_of_type_AndroidContentContext;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private botb jdField_a_of_type_Botb;
  private ArrayList<bosx> jdField_a_of_type_JavaUtilArrayList;
  
  public botm(Context paramContext, botb parambotb)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Botb = parambotb;
    a(this.jdField_a_of_type_Botb.a());
    a(this.jdField_a_of_type_Botb.a());
  }
  
  private void a(RecyclerView paramRecyclerView)
  {
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = paramRecyclerView;
  }
  
  private void a(ArrayList<bosx> paramArrayList)
  {
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
  }
  
  public boto a(@NonNull ViewGroup paramViewGroup, int paramInt)
  {
    if (this.jdField_a_of_type_AndroidContentContext == null) {
      this.jdField_a_of_type_AndroidContentContext = paramViewGroup.getContext();
    }
    paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131558575, paramViewGroup, false);
    if (paramInt != 0) {
      paramViewGroup.setVisibility(4);
    }
    return new boto(paramViewGroup);
  }
  
  public void a()
  {
    boto localboto = (boto)this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.findViewHolderForLayoutPosition(this.jdField_a_of_type_Int);
    if (localboto != null) {
      localboto.a(false);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Int >= 0) {
        ((bosx)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Int - 1)).a(false);
      }
      this.jdField_a_of_type_Int = -1;
      return;
      if (this.jdField_a_of_type_Int >= 0) {
        notifyItemChanged(this.jdField_a_of_type_Int);
      }
    }
  }
  
  public void a(boto paramboto, int paramInt)
  {
    if (paramboto.getLayoutPosition() == 0)
    {
      localObject = new FrameLayout.LayoutParams(bhgr.a(this.jdField_a_of_type_AndroidContentContext, 33.0F), bhgr.a(this.jdField_a_of_type_AndroidContentContext, 33.0F));
      ((FrameLayout.LayoutParams)localObject).setMargins(0, 0, bhgr.a(this.jdField_a_of_type_AndroidContentContext, 51.0F), 0);
      paramboto.itemView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      EventCollector.getInstance().onRecyclerBindViewHolder(paramboto, paramInt, getItemId(paramInt));
      return;
    }
    Object localObject = ((bosx)this.jdField_a_of_type_JavaUtilArrayList.get(paramboto.getLayoutPosition() - 1)).a;
    paramboto.a.setText((CharSequence)localObject);
    if (this.jdField_a_of_type_Int == paramboto.getLayoutPosition()) {
      paramboto.a(true);
    }
    for (;;)
    {
      paramboto.itemView.setOnClickListener(new botn(this, paramboto, (String)localObject));
      break;
      paramboto.a(false);
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
 * Qualified Name:     botm
 * JD-Core Version:    0.7.0.1
 */