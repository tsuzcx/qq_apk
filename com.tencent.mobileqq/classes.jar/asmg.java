import android.view.ViewGroup;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.FaceDecoder;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.search.FileSearchFragment;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class asmg
  extends baun<bayt, bbhb>
{
  public asmg(ListView paramListView, FaceDecoder paramFaceDecoder, List<bayt> paramList, String paramString, QQAppInterface paramQQAppInterface)
  {
    super(paramFaceDecoder, paramList);
    if (paramString == null) {
      return;
    }
    if (paramString.size() == 1)
    {
      paramListView = (asmd)paramString.get(0);
      if (paramListView.jdField_a_of_type_JavaUtilList.size() > 1)
      {
        paramFaceDecoder = new ArrayList();
        paramList = paramListView.jdField_a_of_type_JavaUtilList.iterator();
        while (paramList.hasNext())
        {
          paramString = (FileManagerEntity)paramList.next();
          paramQQAppInterface = new asmd();
          paramQQAppInterface.jdField_a_of_type_JavaLangString = paramListView.jdField_a_of_type_JavaLangString;
          paramQQAppInterface.jdField_a_of_type_JavaUtilList.add(paramString);
          paramFaceDecoder.add(paramQQAppInterface);
        }
        a(paramFaceDecoder);
        return;
      }
    }
    a(paramString);
  }
  
  protected bbbn<bayt, bbhb> a(int paramInt)
  {
    return new asmi(FileSearchFragment.a(this.a));
  }
  
  protected bbhc a(int paramInt, ViewGroup paramViewGroup)
  {
    return new asmj(paramViewGroup);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asmg
 * JD-Core Version:    0.7.0.1
 */