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
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

public class auiw
  extends RecyclerView.Adapter<auiz>
{
  Context jdField_a_of_type_AndroidContentContext;
  aobu jdField_a_of_type_Aobu;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  List<Pair<String, String>> jdField_a_of_type_JavaUtilList;
  
  public auiw(QQAppInterface paramQQAppInterface, Context paramContext, aobu paramaobu)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Aobu = paramaobu;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  public auiz a(ViewGroup paramViewGroup, int paramInt)
  {
    if (paramInt == auis.b)
    {
      paramViewGroup = new View(this.jdField_a_of_type_AndroidContentContext);
      paramViewGroup.setLayoutParams(new RelativeLayout.LayoutParams(-1, this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131297045)));
      return new auiz(paramViewGroup);
    }
    return new auiy(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131559178, paramViewGroup, false));
  }
  
  public void a(auiz paramauiz, int paramInt)
  {
    if (paramauiz.a == auis.b) {}
    for (;;)
    {
      EventCollector.getInstance().onRecyclerBindViewHolder(paramauiz, paramInt, getItemId(paramInt));
      return;
      if (paramauiz.a == auis.a)
      {
        int i = paramInt - 1;
        if (i < 0) {
          QLog.e("Forward.Preview.Dialog", 2, "type normal in wrong index");
        }
        Pair localPair = (Pair)this.jdField_a_of_type_JavaUtilList.get(i);
        if ((paramauiz instanceof auiy)) {
          ((auiy)paramauiz).a((String)localPair.first, (String)localPair.second, this.jdField_a_of_type_Aobu);
        }
      }
    }
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
      return auis.b;
    }
    return auis.a;
  }
  
  public void onAttachedToRecyclerView(RecyclerView paramRecyclerView)
  {
    super.onAttachedToRecyclerView(paramRecyclerView);
    paramRecyclerView = paramRecyclerView.getLayoutManager();
    if ((paramRecyclerView instanceof GridLayoutManager)) {
      ((GridLayoutManager)paramRecyclerView).setSpanSizeLookup(new auix(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auiw
 * JD-Core Version:    0.7.0.1
 */