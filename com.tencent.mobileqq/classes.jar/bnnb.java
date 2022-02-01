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

public class bnnb
  extends RecyclerView.Adapter<bnnd>
{
  private int jdField_a_of_type_Int = -1;
  private Context jdField_a_of_type_AndroidContentContext;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private bnmq jdField_a_of_type_Bnmq;
  private ArrayList<bnmm> jdField_a_of_type_JavaUtilArrayList;
  
  public bnnb(Context paramContext, bnmq parambnmq)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Bnmq = parambnmq;
    a(this.jdField_a_of_type_Bnmq.a());
    a(this.jdField_a_of_type_Bnmq.a());
  }
  
  private void a(RecyclerView paramRecyclerView)
  {
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = paramRecyclerView;
  }
  
  private void a(ArrayList<bnmm> paramArrayList)
  {
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
  }
  
  public bnnd a(@NonNull ViewGroup paramViewGroup, int paramInt)
  {
    if (this.jdField_a_of_type_AndroidContentContext == null) {
      this.jdField_a_of_type_AndroidContentContext = paramViewGroup.getContext();
    }
    paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131558590, paramViewGroup, false);
    if (paramInt != 0) {
      paramViewGroup.setVisibility(4);
    }
    return new bnnd(paramViewGroup);
  }
  
  public void a()
  {
    bnnd localbnnd = (bnnd)this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.findViewHolderForLayoutPosition(this.jdField_a_of_type_Int);
    if (localbnnd != null) {
      localbnnd.a(false);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Int >= 0) {
        ((bnmm)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Int - 1)).a(false);
      }
      this.jdField_a_of_type_Int = -1;
      return;
      if (this.jdField_a_of_type_Int >= 0) {
        notifyItemChanged(this.jdField_a_of_type_Int);
      }
    }
  }
  
  public void a(bnnd parambnnd, int paramInt)
  {
    if (parambnnd.getLayoutPosition() == 0)
    {
      localObject = new FrameLayout.LayoutParams(DisplayUtil.dip2px(this.jdField_a_of_type_AndroidContentContext, 33.0F), DisplayUtil.dip2px(this.jdField_a_of_type_AndroidContentContext, 33.0F));
      ((FrameLayout.LayoutParams)localObject).setMargins(0, 0, DisplayUtil.dip2px(this.jdField_a_of_type_AndroidContentContext, 51.0F), 0);
      parambnnd.itemView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      EventCollector.getInstance().onRecyclerBindViewHolder(parambnnd, paramInt, getItemId(paramInt));
      return;
    }
    Object localObject = ((bnmm)this.jdField_a_of_type_JavaUtilArrayList.get(parambnnd.getLayoutPosition() - 1)).a;
    parambnnd.a.setText((CharSequence)localObject);
    if (this.jdField_a_of_type_Int == parambnnd.getLayoutPosition()) {
      parambnnd.a(true);
    }
    for (;;)
    {
      parambnnd.itemView.setOnClickListener(new bnnc(this, parambnnd, (String)localObject));
      break;
      parambnnd.a(false);
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
 * Qualified Name:     bnnb
 * JD-Core Version:    0.7.0.1
 */