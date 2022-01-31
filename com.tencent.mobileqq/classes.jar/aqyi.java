import android.view.ViewGroup;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.search.FileSearchDetailFragment;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class aqyi
  extends ayff<ayjl, ayru>
{
  public aqyi(FileSearchDetailFragment paramFileSearchDetailFragment, ListView paramListView, bcws parambcws, ayjl paramayjl, String paramString, QQAppInterface paramQQAppInterface)
  {
    super(paramListView, parambcws);
    paramFileSearchDetailFragment = (aqyg)paramayjl;
    if (paramFileSearchDetailFragment.jdField_a_of_type_JavaUtilList.size() > 1)
    {
      paramListView = new ArrayList();
      parambcws = paramFileSearchDetailFragment.jdField_a_of_type_JavaUtilList.iterator();
      while (parambcws.hasNext())
      {
        paramayjl = (FileManagerEntity)parambcws.next();
        paramString = new aqyg();
        paramString.jdField_a_of_type_JavaLangString = paramFileSearchDetailFragment.jdField_a_of_type_JavaLangString;
        paramString.jdField_a_of_type_JavaUtilList.add(paramayjl);
        paramListView.add(paramString);
      }
      a(paramListView);
    }
  }
  
  protected aymg<ayjl, ayru> a(int paramInt)
  {
    return new aqyl(this.a.a);
  }
  
  protected ayrv a(int paramInt, ViewGroup paramViewGroup)
  {
    return new aqym(paramViewGroup);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqyi
 * JD-Core Version:    0.7.0.1
 */