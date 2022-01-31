import android.view.ViewGroup;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.search.FileSearchDetailFragment;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class apfk
  extends awkf<awoi, awwr>
{
  public apfk(FileSearchDetailFragment paramFileSearchDetailFragment, ListView paramListView, baxy parambaxy, awoi paramawoi, String paramString, QQAppInterface paramQQAppInterface)
  {
    super(paramListView, parambaxy);
    paramFileSearchDetailFragment = (apfi)paramawoi;
    if (paramFileSearchDetailFragment.jdField_a_of_type_JavaUtilList.size() > 1)
    {
      paramListView = new ArrayList();
      parambaxy = paramFileSearchDetailFragment.jdField_a_of_type_JavaUtilList.iterator();
      while (parambaxy.hasNext())
      {
        paramawoi = (FileManagerEntity)parambaxy.next();
        paramString = new apfi();
        paramString.jdField_a_of_type_JavaLangString = paramFileSearchDetailFragment.jdField_a_of_type_JavaLangString;
        paramString.jdField_a_of_type_JavaUtilList.add(paramawoi);
        paramListView.add(paramString);
      }
      a(paramListView);
    }
  }
  
  protected awrd<awoi, awwr> a(int paramInt)
  {
    return new apfn(this.a.a);
  }
  
  protected awws a(int paramInt, ViewGroup paramViewGroup)
  {
    return new apfo(paramViewGroup);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     apfk
 * JD-Core Version:    0.7.0.1
 */