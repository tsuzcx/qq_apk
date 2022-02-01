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

public class bnfd
  extends RecyclerView.Adapter<bnfe>
{
  private Context jdField_a_of_type_AndroidContentContext;
  private List<bnff> jdField_a_of_type_JavaUtilList;
  
  public bnfd(@NonNull Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaUtilList = new LinkedList();
  }
  
  public bnfe a(ViewGroup paramViewGroup, int paramInt)
  {
    return new bnfe(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558498, paramViewGroup, false));
  }
  
  public void a(bnfe parambnfe, int paramInt)
  {
    parambnfe.a((bnff)this.jdField_a_of_type_JavaUtilList.get(paramInt));
    EventCollector.getInstance().onRecyclerBindViewHolder(parambnfe, paramInt, getItemId(paramInt));
  }
  
  public void a(@NonNull List<bnff> paramList)
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
 * Qualified Name:     bnfd
 * JD-Core Version:    0.7.0.1
 */