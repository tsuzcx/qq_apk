import android.view.ViewGroup;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.search.FileSearchFragment;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class aqyj
  extends ayff<ayjl, ayru>
{
  public aqyj(ListView paramListView, bcws parambcws, List<ayjl> paramList, String paramString, QQAppInterface paramQQAppInterface)
  {
    super(parambcws, paramList);
    if (paramString == null) {
      return;
    }
    if (paramString.size() == 1)
    {
      paramListView = (aqyg)paramString.get(0);
      if (paramListView.jdField_a_of_type_JavaUtilList.size() > 1)
      {
        parambcws = new ArrayList();
        paramList = paramListView.jdField_a_of_type_JavaUtilList.iterator();
        while (paramList.hasNext())
        {
          paramString = (FileManagerEntity)paramList.next();
          paramQQAppInterface = new aqyg();
          paramQQAppInterface.jdField_a_of_type_JavaLangString = paramListView.jdField_a_of_type_JavaLangString;
          paramQQAppInterface.jdField_a_of_type_JavaUtilList.add(paramString);
          parambcws.add(paramQQAppInterface);
        }
        a(parambcws);
        return;
      }
    }
    a(paramString);
  }
  
  protected aymg<ayjl, ayru> a(int paramInt)
  {
    return new aqyl(FileSearchFragment.a(this.a));
  }
  
  protected ayrv a(int paramInt, ViewGroup paramViewGroup)
  {
    return new aqym(paramViewGroup);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqyj
 * JD-Core Version:    0.7.0.1
 */