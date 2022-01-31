import android.view.ViewGroup;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.search.ChatFileSearchFragment;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class apfc
  extends awkd<awog, awwp>
{
  public apfc(ListView paramListView, baxk parambaxk, List<awog> paramList, String paramString, QQAppInterface paramQQAppInterface)
  {
    super(parambaxk, paramList);
    if (paramString == null) {
      return;
    }
    if (paramString.size() == 1)
    {
      paramListView = (apfa)paramString.get(0);
      if (paramListView.jdField_a_of_type_JavaUtilList.size() > 1)
      {
        parambaxk = new ArrayList();
        paramList = paramListView.jdField_a_of_type_JavaUtilList.iterator();
        while (paramList.hasNext())
        {
          paramString = (FileManagerEntity)paramList.next();
          paramQQAppInterface = new apfa();
          paramQQAppInterface.jdField_a_of_type_JavaLangString = paramListView.jdField_a_of_type_JavaLangString;
          paramQQAppInterface.jdField_a_of_type_JavaUtilList.add(paramString);
          parambaxk.add(paramQQAppInterface);
        }
        a(parambaxk);
        return;
      }
    }
    a(paramString);
  }
  
  protected awrb<awog, awwp> a(int paramInt)
  {
    return new apfj(ChatFileSearchFragment.a(this.a));
  }
  
  protected awwq a(int paramInt, ViewGroup paramViewGroup)
  {
    return new apfd(paramViewGroup);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     apfc
 * JD-Core Version:    0.7.0.1
 */