import android.view.ViewGroup;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.search.FileSearchDetailFragment;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class apfg
  extends awkd<awog, awwp>
{
  public apfg(FileSearchDetailFragment paramFileSearchDetailFragment, ListView paramListView, baxk parambaxk, awog paramawog, String paramString, QQAppInterface paramQQAppInterface)
  {
    super(paramListView, parambaxk);
    paramFileSearchDetailFragment = (apfe)paramawog;
    if (paramFileSearchDetailFragment.jdField_a_of_type_JavaUtilList.size() > 1)
    {
      paramListView = new ArrayList();
      parambaxk = paramFileSearchDetailFragment.jdField_a_of_type_JavaUtilList.iterator();
      while (parambaxk.hasNext())
      {
        paramawog = (FileManagerEntity)parambaxk.next();
        paramString = new apfe();
        paramString.jdField_a_of_type_JavaLangString = paramFileSearchDetailFragment.jdField_a_of_type_JavaLangString;
        paramString.jdField_a_of_type_JavaUtilList.add(paramawog);
        paramListView.add(paramString);
      }
      a(paramListView);
    }
  }
  
  protected awrb<awog, awwp> a(int paramInt)
  {
    return new apfj(this.a.a);
  }
  
  protected awwq a(int paramInt, ViewGroup paramViewGroup)
  {
    return new apfk(paramViewGroup);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     apfg
 * JD-Core Version:    0.7.0.1
 */