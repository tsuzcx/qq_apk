import android.view.ViewGroup;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.FaceDecoder;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.search.FileSearchDetailFragment;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class asmf
  extends baun<bayt, bbhb>
{
  public asmf(FileSearchDetailFragment paramFileSearchDetailFragment, ListView paramListView, FaceDecoder paramFaceDecoder, bayt parambayt, String paramString, QQAppInterface paramQQAppInterface)
  {
    super(paramListView, paramFaceDecoder);
    paramFileSearchDetailFragment = (asmd)parambayt;
    if (paramFileSearchDetailFragment.jdField_a_of_type_JavaUtilList.size() > 1)
    {
      paramListView = new ArrayList();
      paramFaceDecoder = paramFileSearchDetailFragment.jdField_a_of_type_JavaUtilList.iterator();
      while (paramFaceDecoder.hasNext())
      {
        parambayt = (FileManagerEntity)paramFaceDecoder.next();
        paramString = new asmd();
        paramString.jdField_a_of_type_JavaLangString = paramFileSearchDetailFragment.jdField_a_of_type_JavaLangString;
        paramString.jdField_a_of_type_JavaUtilList.add(parambayt);
        paramListView.add(paramString);
      }
      a(paramListView);
    }
  }
  
  protected bbbn<bayt, bbhb> a(int paramInt)
  {
    return new asmi(this.a.a);
  }
  
  protected bbhc a(int paramInt, ViewGroup paramViewGroup)
  {
    return new asmj(paramViewGroup);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asmf
 * JD-Core Version:    0.7.0.1
 */