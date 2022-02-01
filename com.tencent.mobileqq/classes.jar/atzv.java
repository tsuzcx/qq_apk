import android.view.ViewGroup;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.search.FileSearchDetailFragment;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class atzv
  extends bcbj<bcfr, bcnz>
{
  public atzv(FileSearchDetailFragment paramFileSearchDetailFragment, ListView paramListView, aoof paramaoof, bcfr parambcfr, String paramString, QQAppInterface paramQQAppInterface)
  {
    super(paramListView, paramaoof);
    paramFileSearchDetailFragment = (atzt)parambcfr;
    if (paramFileSearchDetailFragment.jdField_a_of_type_JavaUtilList.size() > 1)
    {
      paramListView = new ArrayList();
      paramaoof = paramFileSearchDetailFragment.jdField_a_of_type_JavaUtilList.iterator();
      while (paramaoof.hasNext())
      {
        parambcfr = (FileManagerEntity)paramaoof.next();
        paramString = new atzt();
        paramString.jdField_a_of_type_JavaLangString = paramFileSearchDetailFragment.jdField_a_of_type_JavaLangString;
        paramString.jdField_a_of_type_JavaUtilList.add(parambcfr);
        paramListView.add(paramString);
      }
      a(paramListView);
    }
  }
  
  protected bcil<bcfr, bcnz> a(int paramInt)
  {
    return new atzy(this.a.a);
  }
  
  protected bcoa a(int paramInt, ViewGroup paramViewGroup)
  {
    return new atzz(paramViewGroup);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atzv
 * JD-Core Version:    0.7.0.1
 */