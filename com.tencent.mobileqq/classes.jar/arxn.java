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

public class arxn
  extends RecyclerView.Adapter<arxq>
{
  Context jdField_a_of_type_AndroidContentContext;
  bcws jdField_a_of_type_Bcws;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  List<Pair<String, String>> jdField_a_of_type_JavaUtilList;
  
  public arxn(QQAppInterface paramQQAppInterface, Context paramContext, bcws parambcws)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Bcws = parambcws;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  public arxq a(ViewGroup paramViewGroup, int paramInt)
  {
    if (paramInt == arxj.b)
    {
      paramViewGroup = new View(this.jdField_a_of_type_AndroidContentContext);
      paramViewGroup.setLayoutParams(new RelativeLayout.LayoutParams(-1, this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131296992)));
      return new arxq(paramViewGroup);
    }
    return new arxp(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131559110, paramViewGroup, false));
  }
  
  public void a(arxq paramarxq, int paramInt)
  {
    if (paramarxq.a == arxj.b) {}
    Pair localPair;
    do
    {
      do
      {
        return;
      } while (paramarxq.a != arxj.a);
      paramInt -= 1;
      if (paramInt < 0) {
        QLog.e("Forward.Preview.Dialog", 2, "type normal in wrong index");
      }
      localPair = (Pair)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    } while (!(paramarxq instanceof arxp));
    ((arxp)paramarxq).a((String)localPair.first, (String)localPair.second, this.jdField_a_of_type_Bcws);
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
      return arxj.b;
    }
    return arxj.a;
  }
  
  public void onAttachedToRecyclerView(RecyclerView paramRecyclerView)
  {
    super.onAttachedToRecyclerView(paramRecyclerView);
    paramRecyclerView = paramRecyclerView.getLayoutManager();
    if ((paramRecyclerView instanceof GridLayoutManager)) {
      ((GridLayoutManager)paramRecyclerView).setSpanSizeLookup(new arxo(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arxn
 * JD-Core Version:    0.7.0.1
 */