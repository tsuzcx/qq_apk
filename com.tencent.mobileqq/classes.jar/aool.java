import android.view.ViewGroup;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.search.FileSearchDetailFragment;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class aool
  extends avkk<avon, avww>
{
  public aool(FileSearchDetailFragment paramFileSearchDetailFragment, ListView paramListView, azwg paramazwg, avon paramavon, String paramString, QQAppInterface paramQQAppInterface)
  {
    super(paramListView, paramazwg);
    paramFileSearchDetailFragment = (aooj)paramavon;
    if (paramFileSearchDetailFragment.jdField_a_of_type_JavaUtilList.size() > 1)
    {
      paramListView = new ArrayList();
      paramazwg = paramFileSearchDetailFragment.jdField_a_of_type_JavaUtilList.iterator();
      while (paramazwg.hasNext())
      {
        paramavon = (FileManagerEntity)paramazwg.next();
        paramString = new aooj();
        paramString.jdField_a_of_type_JavaLangString = paramFileSearchDetailFragment.jdField_a_of_type_JavaLangString;
        paramString.jdField_a_of_type_JavaUtilList.add(paramavon);
        paramListView.add(paramString);
      }
      a(paramListView);
    }
  }
  
  protected avri<avon, avww> a(int paramInt)
  {
    return new aooo(this.a.a);
  }
  
  protected avwx a(int paramInt, ViewGroup paramViewGroup)
  {
    return new aoop(paramViewGroup);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aool
 * JD-Core Version:    0.7.0.1
 */