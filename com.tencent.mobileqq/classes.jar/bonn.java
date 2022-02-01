import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.qq.im.ae.camera.ui.dashboard.AEVideoStoryDashboardPart.DashboardAdapter.1;
import java.util.LinkedList;
import java.util.List;
import mqq.os.MqqHandler;

public class bonn
  extends RecyclerView.Adapter<bono>
{
  private Context jdField_a_of_type_AndroidContentContext;
  private List<bonp> jdField_a_of_type_JavaUtilList;
  
  public bonn(@NonNull Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaUtilList = new LinkedList();
  }
  
  public bono a(ViewGroup paramViewGroup, int paramInt)
  {
    return new bono(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558490, paramViewGroup, false));
  }
  
  public void a(bono parambono, int paramInt)
  {
    parambono.a((bonp)this.jdField_a_of_type_JavaUtilList.get(paramInt));
    EventCollector.getInstance().onRecyclerBindViewHolder(parambono, paramInt, getItemId(paramInt));
  }
  
  public void a(@NonNull List<bonp> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    ThreadManager.getUIHandler().post(new AEVideoStoryDashboardPart.DashboardAdapter.1(this));
  }
  
  public int getItemCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bonn
 * JD-Core Version:    0.7.0.1
 */