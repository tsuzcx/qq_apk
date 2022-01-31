import android.view.ViewGroup;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.search.ChatFileSearchFragment;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class arcn
  extends ayjo<aynu, aywd>
{
  public arcn(ListView paramListView, bdbb parambdbb, List<aynu> paramList, String paramString, QQAppInterface paramQQAppInterface)
  {
    super(parambdbb, paramList);
    if (paramString == null) {
      return;
    }
    if (paramString.size() == 1)
    {
      paramListView = (arcl)paramString.get(0);
      if (paramListView.jdField_a_of_type_JavaUtilList.size() > 1)
      {
        parambdbb = new ArrayList();
        paramList = paramListView.jdField_a_of_type_JavaUtilList.iterator();
        while (paramList.hasNext())
        {
          paramString = (FileManagerEntity)paramList.next();
          paramQQAppInterface = new arcl();
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
    return new arcu(ChatFileSearchFragment.a(this.a));
  }
  
  protected aywe a(int paramInt, ViewGroup paramViewGroup)
  {
    return new arco(paramViewGroup);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arcn
 * JD-Core Version:    0.7.0.1
 */