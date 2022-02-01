import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

public class amry
  extends RecyclerView.Adapter<amrz>
{
  private Context jdField_a_of_type_AndroidContentContext;
  private View jdField_a_of_type_AndroidViewView;
  private List<amrx> jdField_a_of_type_JavaUtilList;
  
  public amry(Context paramContext, List<amrx> paramList)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public amrz a(ViewGroup paramViewGroup, int paramInt)
  {
    if ((this.jdField_a_of_type_AndroidViewView != null) && (paramInt == 1)) {
      return new amrz(this, this.jdField_a_of_type_AndroidViewView);
    }
    return new amrz(this, LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558937, paramViewGroup, false));
  }
  
  public void a(amrz paramamrz, int paramInt)
  {
    if (getItemViewType(paramInt) == 0)
    {
      amrx localamrx = (amrx)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      paramamrz.a.setText(localamrx.jdField_a_of_type_JavaLangString);
      paramamrz.a.setTextColor(Color.parseColor(amro.c[localamrx.jdField_a_of_type_Int]));
    }
    EventCollector.getInstance().onRecyclerBindViewHolder(paramamrz, paramInt, getItemId(paramInt));
  }
  
  public void a(View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
    notifyItemInserted(getItemCount() - 1);
  }
  
  public void a(List<amrx> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public int getItemCount()
  {
    if (this.jdField_a_of_type_AndroidViewView != null) {
      return this.jdField_a_of_type_JavaUtilList.size() + 1;
    }
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public int getItemViewType(int paramInt)
  {
    if ((this.jdField_a_of_type_AndroidViewView != null) && (paramInt == getItemCount() - 1)) {
      return 1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amry
 * JD-Core Version:    0.7.0.1
 */