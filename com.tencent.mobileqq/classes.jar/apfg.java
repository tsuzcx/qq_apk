import android.view.ViewGroup;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.search.ChatFileSearchFragment;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class apfg
  extends awkf<awoi, awwr>
{
  public apfg(ListView paramListView, baxy parambaxy, List<awoi> paramList, String paramString, QQAppInterface paramQQAppInterface)
  {
    super(parambaxy, paramList);
    if (paramString == null) {
      return;
    }
    if (paramString.size() == 1)
    {
      paramListView = (apfe)paramString.get(0);
      if (paramListView.jdField_a_of_type_JavaUtilList.size() > 1)
      {
        parambaxy = new ArrayList();
        paramList = paramListView.jdField_a_of_type_JavaUtilList.iterator();
        while (paramList.hasNext())
        {
          paramString = (FileManagerEntity)paramList.next();
          paramQQAppInterface = new apfe();
          paramQQAppInterface.jdField_a_of_type_JavaLangString = paramListView.jdField_a_of_type_JavaLangString;
          paramQQAppInterface.jdField_a_of_type_JavaUtilList.add(paramString);
          parambaxy.add(paramQQAppInterface);
        }
        a(parambaxy);
        return;
      }
    }
    a(paramString);
  }
  
  protected awrd<awoi, awwr> a(int paramInt)
  {
    return new apfn(ChatFileSearchFragment.a(this.a));
  }
  
  protected awws a(int paramInt, ViewGroup paramViewGroup)
  {
    return new apfh(paramViewGroup);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     apfg
 * JD-Core Version:    0.7.0.1
 */