import android.view.ViewGroup;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.search.FileSearchFragment;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class atzw
  extends bcbj<bcfr, bcnz>
{
  public atzw(ListView paramListView, aoof paramaoof, List<bcfr> paramList, String paramString, QQAppInterface paramQQAppInterface)
  {
    super(paramaoof, paramList);
    if (paramString == null) {
      return;
    }
    if (paramString.size() == 1)
    {
      paramListView = (atzt)paramString.get(0);
      if (paramListView.jdField_a_of_type_JavaUtilList.size() > 1)
      {
        paramaoof = new ArrayList();
        paramList = paramListView.jdField_a_of_type_JavaUtilList.iterator();
        while (paramList.hasNext())
        {
          paramString = (FileManagerEntity)paramList.next();
          paramQQAppInterface = new atzt();
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
    return new atzy(FileSearchFragment.a(this.a));
  }
  
  protected bcoa a(int paramInt, ViewGroup paramViewGroup)
  {
    return new atzz(paramViewGroup);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atzw
 * JD-Core Version:    0.7.0.1
 */