import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.tencent.mobileqq.app.ThreadManager;
import dov.com.qq.im.ae.camera.ui.dashboard.AEVideoStoryDashboardPart.DashboardAdapter.1;
import java.util.LinkedList;
import java.util.List;
import mqq.os.MqqHandler;

public class bkwz
  extends RecyclerView.Adapter<bkxa>
{
  private Context jdField_a_of_type_AndroidContentContext;
  private List<bkxb> jdField_a_of_type_JavaUtilList;
  
  public bkwz(@NonNull Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaUtilList = new LinkedList();
  }
  
  public bkxa a(ViewGroup paramViewGroup, int paramInt)
  {
    return new bkxa(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558477, paramViewGroup, false));
  }
  
  public void a(bkxa parambkxa, int paramInt)
  {
    parambkxa.a((bkxb)this.jdField_a_of_type_JavaUtilList.get(paramInt));
  }
  
  public void a(@NonNull List<bkxb> paramList)
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
 * Qualified Name:     bkwz
 * JD-Core Version:    0.7.0.1
 */