import android.view.ViewGroup;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.search.FileSearchFragment;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class aoom
  extends avkk<avon, avww>
{
  public aoom(ListView paramListView, azwg paramazwg, List<avon> paramList, String paramString, QQAppInterface paramQQAppInterface)
  {
    super(paramazwg, paramList);
    if (paramString == null) {
      return;
    }
    if (paramString.size() == 1)
    {
      paramListView = (aooj)paramString.get(0);
      if (paramListView.jdField_a_of_type_JavaUtilList.size() > 1)
      {
        paramazwg = new ArrayList();
        paramList = paramListView.jdField_a_of_type_JavaUtilList.iterator();
        while (paramList.hasNext())
        {
          paramString = (FileManagerEntity)paramList.next();
          paramQQAppInterface = new aooj();
          paramQQAppInterface.jdField_a_of_type_JavaLangString = paramListView.jdField_a_of_type_JavaLangString;
          paramQQAppInterface.jdField_a_of_type_JavaUtilList.add(paramString);
          paramazwg.add(paramQQAppInterface);
        }
        a(paramazwg);
        return;
      }
    }
    a(paramString);
  }
  
  protected avri<avon, avww> a(int paramInt)
  {
    return new aooo(FileSearchFragment.a(this.a));
  }
  
  protected avwx a(int paramInt, ViewGroup paramViewGroup)
  {
    return new aoop(paramViewGroup);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aoom
 * JD-Core Version:    0.7.0.1
 */