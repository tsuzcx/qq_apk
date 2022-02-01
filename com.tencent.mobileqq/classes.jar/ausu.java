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
import com.tencent.mobileqq.app.face.FaceDecoder;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

public class ausu
  extends RecyclerView.Adapter<ausx>
{
  Context jdField_a_of_type_AndroidContentContext;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  FaceDecoder jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder;
  List<Pair<String, String>> jdField_a_of_type_JavaUtilList;
  
  public ausu(QQAppInterface paramQQAppInterface, Context paramContext, FaceDecoder paramFaceDecoder)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder = paramFaceDecoder;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  public ausx a(ViewGroup paramViewGroup, int paramInt)
  {
    if (paramInt == ausq.b)
    {
      paramViewGroup = new View(this.jdField_a_of_type_AndroidContentContext);
      paramViewGroup.setLayoutParams(new RelativeLayout.LayoutParams(-1, this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131297113)));
      return new ausx(paramViewGroup);
    }
    return new ausw(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131559215, paramViewGroup, false));
  }
  
  public void a(ausx paramausx, int paramInt)
  {
    if (paramausx.a == ausq.b) {}
    for (;;)
    {
      EventCollector.getInstance().onRecyclerBindViewHolder(paramausx, paramInt, getItemId(paramInt));
      return;
      if (paramausx.a == ausq.a)
      {
        int i = paramInt - 1;
        if (i < 0) {
          QLog.e("Forward.Preview.Dialog", 2, "type normal in wrong index");
        }
        Pair localPair = (Pair)this.jdField_a_of_type_JavaUtilList.get(i);
        if ((paramausx instanceof ausw)) {
          ((ausw)paramausx).a((String)localPair.first, (String)localPair.second, this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder);
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
      return ausq.b;
    }
    return ausq.a;
  }
  
  public void onAttachedToRecyclerView(RecyclerView paramRecyclerView)
  {
    super.onAttachedToRecyclerView(paramRecyclerView);
    paramRecyclerView = paramRecyclerView.getLayoutManager();
    if ((paramRecyclerView instanceof GridLayoutManager)) {
      ((GridLayoutManager)paramRecyclerView).setSpanSizeLookup(new ausv(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ausu
 * JD-Core Version:    0.7.0.1
 */