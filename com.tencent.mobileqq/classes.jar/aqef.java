import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class aqef
  extends RecyclerView.Adapter<aqei>
{
  Context jdField_a_of_type_AndroidContentContext;
  baxy jdField_a_of_type_Baxy;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  List<Pair<String, String>> jdField_a_of_type_JavaUtilList;
  
  public aqef(QQAppInterface paramQQAppInterface, Context paramContext, baxy parambaxy)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Baxy = parambaxy;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  public aqei a(ViewGroup paramViewGroup, int paramInt)
  {
    if (paramInt == aqeb.b)
    {
      paramViewGroup = new View(this.jdField_a_of_type_AndroidContentContext);
      paramViewGroup.setLayoutParams(new RelativeLayout.LayoutParams(-1, this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131296976)));
      return new aqei(paramViewGroup);
    }
    return new aqeh(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131559069, paramViewGroup, false));
  }
  
  public void a(aqei paramaqei, int paramInt)
  {
    if (paramaqei.a == aqeb.b) {}
    Pair localPair;
    do
    {
      do
      {
        return;
      } while (paramaqei.a != aqeb.a);
      paramInt -= 1;
      if (paramInt < 0) {
        QLog.e("Forward.Preview.Dialog", 2, "type normal in wrong index");
      }
      localPair = (Pair)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    } while (!(paramaqei instanceof aqeh));
    ((aqeh)paramaqei).a((String)localPair.first, (String)localPair.second, this.jdField_a_of_type_Baxy);
  }
  
  public void a(List<Pair<String, String>> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return;
    }
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    notifyDataSetChanged();
  }
  
  public int getItemCount()
  {
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() == 0)) {
      return 0;
    }
    return this.jdField_a_of_type_JavaUtilList.size() + 1;
  }
  
  public int getItemViewType(int paramInt)
  {
    if (paramInt == 0) {
      return aqeb.b;
    }
    return aqeb.a;
  }
  
  public void onAttachedToRecyclerView(RecyclerView paramRecyclerView)
  {
    super.onAttachedToRecyclerView(paramRecyclerView);
    paramRecyclerView = paramRecyclerView.getLayoutManager();
    if ((paramRecyclerView instanceof GridLayoutManager)) {
      ((GridLayoutManager)paramRecyclerView).setSpanSizeLookup(new aqeg(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aqef
 * JD-Core Version:    0.7.0.1
 */