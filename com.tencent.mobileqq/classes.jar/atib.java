import android.view.ViewGroup;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.search.FileSearchDetailFragment;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class atib
  extends bbip<bbmy, bbvg>
{
  public atib(FileSearchDetailFragment paramFileSearchDetailFragment, ListView paramListView, aobu paramaobu, bbmy parambbmy, String paramString, QQAppInterface paramQQAppInterface)
  {
    super(paramListView, paramaobu);
    paramFileSearchDetailFragment = (athz)parambbmy;
    if (paramFileSearchDetailFragment.jdField_a_of_type_JavaUtilList.size() > 1)
    {
      paramListView = new ArrayList();
      paramaobu = paramFileSearchDetailFragment.jdField_a_of_type_JavaUtilList.iterator();
      while (paramaobu.hasNext())
      {
        parambbmy = (FileManagerEntity)paramaobu.next();
        paramString = new athz();
        paramString.jdField_a_of_type_JavaLangString = paramFileSearchDetailFragment.jdField_a_of_type_JavaLangString;
        paramString.jdField_a_of_type_JavaUtilList.add(parambbmy);
        paramListView.add(paramString);
      }
      a(paramListView);
    }
  }
  
  protected bbps<bbmy, bbvg> a(int paramInt)
  {
    return new atie(this.a.a);
  }
  
  protected bbvh a(int paramInt, ViewGroup paramViewGroup)
  {
    return new atif(paramViewGroup);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atib
 * JD-Core Version:    0.7.0.1
 */