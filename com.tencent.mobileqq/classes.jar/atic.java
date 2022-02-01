import android.view.ViewGroup;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.search.FileSearchFragment;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class atic
  extends bbip<bbmy, bbvg>
{
  public atic(ListView paramListView, aobu paramaobu, List<bbmy> paramList, String paramString, QQAppInterface paramQQAppInterface)
  {
    super(paramaobu, paramList);
    if (paramString == null) {
      return;
    }
    if (paramString.size() == 1)
    {
      paramListView = (athz)paramString.get(0);
      if (paramListView.jdField_a_of_type_JavaUtilList.size() > 1)
      {
        paramaobu = new ArrayList();
        paramList = paramListView.jdField_a_of_type_JavaUtilList.iterator();
        while (paramList.hasNext())
        {
          paramString = (FileManagerEntity)paramList.next();
          paramQQAppInterface = new athz();
          paramQQAppInterface.jdField_a_of_type_JavaLangString = paramListView.jdField_a_of_type_JavaLangString;
          paramQQAppInterface.jdField_a_of_type_JavaUtilList.add(paramString);
          paramaobu.add(paramQQAppInterface);
        }
        a(paramaobu);
        return;
      }
    }
    a(paramString);
  }
  
  protected bbps<bbmy, bbvg> a(int paramInt)
  {
    return new atie(FileSearchFragment.a(this.a));
  }
  
  protected bbvh a(int paramInt, ViewGroup paramViewGroup)
  {
    return new atif(paramViewGroup);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atic
 * JD-Core Version:    0.7.0.1
 */