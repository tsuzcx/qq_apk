import android.view.ViewGroup;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.search.FileSearchDetailFragment;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class arcr
  extends ayjo<aynu, aywd>
{
  public arcr(FileSearchDetailFragment paramFileSearchDetailFragment, ListView paramListView, bdbb parambdbb, aynu paramaynu, String paramString, QQAppInterface paramQQAppInterface)
  {
    super(paramListView, parambdbb);
    paramFileSearchDetailFragment = (arcp)paramaynu;
    if (paramFileSearchDetailFragment.jdField_a_of_type_JavaUtilList.size() > 1)
    {
      paramListView = new ArrayList();
      parambdbb = paramFileSearchDetailFragment.jdField_a_of_type_JavaUtilList.iterator();
      while (parambdbb.hasNext())
      {
        paramaynu = (FileManagerEntity)parambdbb.next();
        paramString = new arcp();
        paramString.jdField_a_of_type_JavaLangString = paramFileSearchDetailFragment.jdField_a_of_type_JavaLangString;
        paramString.jdField_a_of_type_JavaUtilList.add(paramaynu);
        paramListView.add(paramString);
      }
      a(paramListView);
    }
  }
  
  protected ayqp<aynu, aywd> a(int paramInt)
  {
    return new arcu(this.a.a);
  }
  
  protected aywe a(int paramInt, ViewGroup paramViewGroup)
  {
    return new arcv(paramViewGroup);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arcr
 * JD-Core Version:    0.7.0.1
 */