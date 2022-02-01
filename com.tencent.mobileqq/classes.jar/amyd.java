import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

public class amyd
  extends RecyclerView.Adapter<amye>
{
  private Context jdField_a_of_type_AndroidContentContext;
  private View jdField_a_of_type_AndroidViewView;
  private List<amyc> jdField_a_of_type_JavaUtilList;
  
  public amyd(Context paramContext, List<amyc> paramList)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public amye a(ViewGroup paramViewGroup, int paramInt)
  {
    if ((this.jdField_a_of_type_AndroidViewView != null) && (paramInt == 1)) {
      return new amye(this, this.jdField_a_of_type_AndroidViewView);
    }
    return new amye(this, LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558902, paramViewGroup, false));
  }
  
  public void a(amye paramamye, int paramInt)
  {
    if (getItemViewType(paramInt) == 0)
    {
      amyc localamyc = (amyc)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      paramamye.a.setText(localamyc.jdField_a_of_type_JavaLangString);
      paramamye.a.setTextColor(Color.parseColor(amxt.c[localamyc.jdField_a_of_type_Int]));
    }
    EventCollector.getInstance().onRecyclerBindViewHolder(paramamye, paramInt, getItemId(paramInt));
  }
  
  public void a(View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
    notifyItemInserted(getItemCount() - 1);
  }
  
  public void a(List<amyc> paramList)
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
 * Qualified Name:     amyd
 * JD-Core Version:    0.7.0.1
 */