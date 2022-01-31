import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.mobileqq.nearby.picbrowser.PicInfo;
import java.util.ArrayList;
import java.util.List;

public class avmb
  extends BaseAdapter
{
  private List<PicInfo> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  public avmb(List<PicInfo> paramList, int paramInt)
  {
    int j = i * 6;
    int i = j;
    while ((i < paramInt.size()) && (i < j + 6))
    {
      this.jdField_a_of_type_JavaUtilList.add(paramInt.get(i));
      i += 1;
    }
  }
  
  public int getCount()
  {
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
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    return this.jdField_a_of_type_Avkt.a(paramInt, (PicInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     avmb
 * JD-Core Version:    0.7.0.1
 */