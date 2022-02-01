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

public class bnma
  extends RecyclerView.Adapter<bnmb>
{
  private Context jdField_a_of_type_AndroidContentContext;
  private List<bnmc> jdField_a_of_type_JavaUtilList;
  
  public bnma(@NonNull Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaUtilList = new LinkedList();
  }
  
  public bnmb a(ViewGroup paramViewGroup, int paramInt)
  {
    return new bnmb(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558489, paramViewGroup, false));
  }
  
  public void a(bnmb parambnmb, int paramInt)
  {
    parambnmb.a((bnmc)this.jdField_a_of_type_JavaUtilList.get(paramInt));
    EventCollector.getInstance().onRecyclerBindViewHolder(parambnmb, paramInt, getItemId(paramInt));
  }
  
  public void a(@NonNull List<bnmc> paramList)
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
 * Qualified Name:     bnma
 * JD-Core Version:    0.7.0.1
 */