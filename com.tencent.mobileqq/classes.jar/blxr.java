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
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

public class blxr
  extends RecyclerView.Adapter<blxt>
{
  private int jdField_a_of_type_Int = -1;
  private Context jdField_a_of_type_AndroidContentContext;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private blxg jdField_a_of_type_Blxg;
  private ArrayList<blxc> jdField_a_of_type_JavaUtilArrayList;
  
  public blxr(Context paramContext, blxg paramblxg)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Blxg = paramblxg;
    a(this.jdField_a_of_type_Blxg.a());
    a(this.jdField_a_of_type_Blxg.a());
  }
  
  private void a(RecyclerView paramRecyclerView)
  {
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = paramRecyclerView;
  }
  
  private void a(ArrayList<blxc> paramArrayList)
  {
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
  }
  
  public blxt a(@NonNull ViewGroup paramViewGroup, int paramInt)
  {
    if (this.jdField_a_of_type_AndroidContentContext == null) {
      this.jdField_a_of_type_AndroidContentContext = paramViewGroup.getContext();
    }
    paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131558578, paramViewGroup, false);
    if (paramInt != 0) {
      paramViewGroup.setVisibility(4);
    }
    return new blxt(paramViewGroup);
  }
  
  public void a()
  {
    blxt localblxt = (blxt)this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.findViewHolderForLayoutPosition(this.jdField_a_of_type_Int);
    if (localblxt != null) {
      localblxt.a(false);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Int >= 0) {
        ((blxc)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Int - 1)).a(false);
      }
      this.jdField_a_of_type_Int = -1;
      return;
      if (this.jdField_a_of_type_Int >= 0) {
        notifyItemChanged(this.jdField_a_of_type_Int);
      }
    }
  }
  
  public void a(blxt paramblxt, int paramInt)
  {
    if (paramblxt.getLayoutPosition() == 0)
    {
      localObject = new FrameLayout.LayoutParams(DisplayUtil.dip2px(this.jdField_a_of_type_AndroidContentContext, 33.0F), DisplayUtil.dip2px(this.jdField_a_of_type_AndroidContentContext, 33.0F));
      ((FrameLayout.LayoutParams)localObject).setMargins(0, 0, DisplayUtil.dip2px(this.jdField_a_of_type_AndroidContentContext, 51.0F), 0);
      paramblxt.itemView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      EventCollector.getInstance().onRecyclerBindViewHolder(paramblxt, paramInt, getItemId(paramInt));
      return;
    }
    Object localObject = ((blxc)this.jdField_a_of_type_JavaUtilArrayList.get(paramblxt.getLayoutPosition() - 1)).a;
    paramblxt.a.setText((CharSequence)localObject);
    if (this.jdField_a_of_type_Int == paramblxt.getLayoutPosition()) {
      paramblxt.a(true);
    }
    for (;;)
    {
      paramblxt.itemView.setOnClickListener(new blxs(this, paramblxt, (String)localObject));
      break;
      paramblxt.a(false);
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
 * Qualified Name:     blxr
 * JD-Core Version:    0.7.0.1
 */