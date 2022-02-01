import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.mobileqq.data.QCallRecord;
import com.tencent.mobileqq.qcall.QCallDetailActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class baot
  extends BaseAdapter
{
  public List<QCallRecord> a;
  
  public baot(QCallDetailActivity paramQCallDetailActivity)
  {
    this.jdField_a_of_type_JavaUtilList = new CopyOnWriteArrayList();
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      this.jdField_a_of_type_JavaUtilList = new CopyOnWriteArrayList();
    }
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    if (((QCallRecord)this.jdField_a_of_type_JavaUtilList.get(paramInt)).type == QCallRecord.TYPE_DATE) {
      return QCallRecord.TYPE_DATE;
    }
    return QCallRecord.TYPE_REALRECORD;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return paramView;
  }
  
  public int getViewTypeCount()
  {
    return 3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     baot
 * JD-Core Version:    0.7.0.1
 */