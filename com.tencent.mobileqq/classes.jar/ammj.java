import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

public class ammj
  extends RecyclerView.Adapter<ammk>
{
  private Context jdField_a_of_type_AndroidContentContext;
  private View jdField_a_of_type_AndroidViewView;
  private List<ammi> jdField_a_of_type_JavaUtilList;
  
  public ammj(Context paramContext, List<ammi> paramList)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public ammk a(ViewGroup paramViewGroup, int paramInt)
  {
    if ((this.jdField_a_of_type_AndroidViewView != null) && (paramInt == 1)) {
      return new ammk(this, this.jdField_a_of_type_AndroidViewView);
    }
    return new ammk(this, LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558903, paramViewGroup, false));
  }
  
  public void a(ammk paramammk, int paramInt)
  {
    if (getItemViewType(paramInt) == 0)
    {
      ammi localammi = (ammi)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      paramammk.a.setText(localammi.jdField_a_of_type_JavaLangString);
      paramammk.a.setTextColor(Color.parseColor(amlz.c[localammi.jdField_a_of_type_Int]));
    }
    EventCollector.getInstance().onRecyclerBindViewHolder(paramammk, paramInt, getItemId(paramInt));
  }
  
  public void a(View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
    notifyItemInserted(getItemCount() - 1);
  }
  
  public void a(List<ammi> paramList)
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
 * Qualified Name:     ammj
 * JD-Core Version:    0.7.0.1
 */