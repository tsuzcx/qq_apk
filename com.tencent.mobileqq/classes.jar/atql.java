import android.view.ViewGroup;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.FaceDecoder;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.search.FileSearchDetailFragment;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class atql
  extends bcbd<bcfj, bcnt>
{
  public atql(FileSearchDetailFragment paramFileSearchDetailFragment, ListView paramListView, FaceDecoder paramFaceDecoder, bcfj parambcfj, String paramString, QQAppInterface paramQQAppInterface)
  {
    super(paramListView, paramFaceDecoder);
    paramFileSearchDetailFragment = (atqj)parambcfj;
    if (paramFileSearchDetailFragment.jdField_a_of_type_JavaUtilList.size() > 1)
    {
      paramListView = new ArrayList();
      paramFaceDecoder = paramFileSearchDetailFragment.jdField_a_of_type_JavaUtilList.iterator();
      while (paramFaceDecoder.hasNext())
      {
        parambcfj = (FileManagerEntity)paramFaceDecoder.next();
        paramString = new atqj();
        paramString.jdField_a_of_type_JavaLangString = paramFileSearchDetailFragment.jdField_a_of_type_JavaLangString;
        paramString.jdField_a_of_type_JavaUtilList.add(parambcfj);
        paramListView.add(paramString);
      }
      a(paramListView);
    }
  }
  
  protected bcif<bcfj, bcnt> a(int paramInt)
  {
    return new atqo(this.a.a);
  }
  
  protected bcnu a(int paramInt, ViewGroup paramViewGroup)
  {
    return new atqp(paramViewGroup);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atql
 * JD-Core Version:    0.7.0.1
 */