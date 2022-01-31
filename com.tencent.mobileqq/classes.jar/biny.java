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

public class biny
  extends RecyclerView.Adapter<binz>
{
  private Context jdField_a_of_type_AndroidContentContext;
  private List<bioa> jdField_a_of_type_JavaUtilList;
  
  public biny(@NonNull Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaUtilList = new LinkedList();
  }
  
  public binz a(ViewGroup paramViewGroup, int paramInt)
  {
    return new binz(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558477, paramViewGroup, false));
  }
  
  public void a(binz parambinz, int paramInt)
  {
    parambinz.a((bioa)this.jdField_a_of_type_JavaUtilList.get(paramInt));
  }
  
  public void a(@NonNull List<bioa> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    ThreadManager.getUIHandler().post(new AEVideoStoryDashboardPart.DashboardAdapter.1(this));
  }
  
  public int getItemCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     biny
 * JD-Core Version:    0.7.0.1
 */