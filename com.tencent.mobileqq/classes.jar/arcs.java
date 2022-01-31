import android.view.ViewGroup;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.search.FileSearchFragment;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class arcs
  extends ayjo<aynu, aywd>
{
  public arcs(ListView paramListView, bdbb parambdbb, List<aynu> paramList, String paramString, QQAppInterface paramQQAppInterface)
  {
    super(parambdbb, paramList);
    if (paramString == null) {
      return;
    }
    if (paramString.size() == 1)
    {
      paramListView = (arcp)paramString.get(0);
      if (paramListView.jdField_a_of_type_JavaUtilList.size() > 1)
      {
        parambdbb = new ArrayList();
        paramList = paramListView.jdField_a_of_type_JavaUtilList.iterator();
        while (paramList.hasNext())
        {
          paramString = (FileManagerEntity)paramList.next();
          paramQQAppInterface = new arcp();
          paramQQAppInterface.jdField_a_of_type_JavaLangString = paramListView.jdField_a_of_type_JavaLangString;
          paramQQAppInterface.jdField_a_of_type_JavaUtilList.add(paramString);
          parambdbb.add(paramQQAppInterface);
        }
        a(parambdbb);
        return;
      }
    }
    a(paramString);
  }
  
  protected ayqp<aynu, aywd> a(int paramInt)
  {
    return new arcu(FileSearchFragment.a(this.a));
  }
  
  protected aywe a(int paramInt, ViewGroup paramViewGroup)
  {
    return new arcv(paramViewGroup);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arcs
 * JD-Core Version:    0.7.0.1
 */