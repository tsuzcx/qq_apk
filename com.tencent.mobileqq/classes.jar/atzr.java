import android.view.ViewGroup;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.search.ChatFileSearchFragment;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class atzr
  extends bcbj<bcfr, bcnz>
{
  public atzr(ListView paramListView, aoof paramaoof, List<bcfr> paramList, String paramString, QQAppInterface paramQQAppInterface)
  {
    super(paramaoof, paramList);
    if (paramString == null) {
      return;
    }
    if (paramString.size() == 1)
    {
      paramListView = (atzp)paramString.get(0);
      if (paramListView.jdField_a_of_type_JavaUtilList.size() > 1)
      {
        paramaoof = new ArrayList();
        paramList = paramListView.jdField_a_of_type_JavaUtilList.iterator();
        while (paramList.hasNext())
        {
          paramString = (FileManagerEntity)paramList.next();
          paramQQAppInterface = new atzp();
          paramQQAppInterface.jdField_a_of_type_JavaLangString = paramListView.jdField_a_of_type_JavaLangString;
          paramQQAppInterface.jdField_a_of_type_JavaUtilList.add(paramString);
          paramaoof.add(paramQQAppInterface);
        }
        a(paramaoof);
        return;
      }
    }
    a(paramString);
  }
  
  protected bcil<bcfr, bcnz> a(int paramInt)
  {
    return new atzy(ChatFileSearchFragment.a(this.a));
  }
  
  protected bcoa a(int paramInt, ViewGroup paramViewGroup)
  {
    return new atzs(paramViewGroup);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atzr
 * JD-Core Version:    0.7.0.1
 */