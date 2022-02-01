import android.view.ViewGroup;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.FaceDecoder;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.search.ChatFileSearchFragment;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class asmb
  extends baun<bayt, bbhb>
{
  public asmb(ListView paramListView, FaceDecoder paramFaceDecoder, List<bayt> paramList, String paramString, QQAppInterface paramQQAppInterface)
  {
    super(paramFaceDecoder, paramList);
    if (paramString == null) {
      return;
    }
    if (paramString.size() == 1)
    {
      paramListView = (aslz)paramString.get(0);
      if (paramListView.jdField_a_of_type_JavaUtilList.size() > 1)
      {
        paramFaceDecoder = new ArrayList();
        paramList = paramListView.jdField_a_of_type_JavaUtilList.iterator();
        while (paramList.hasNext())
        {
          paramString = (FileManagerEntity)paramList.next();
          paramQQAppInterface = new aslz();
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
    return new asmi(ChatFileSearchFragment.a(this.a));
  }
  
  protected bbhc a(int paramInt, ViewGroup paramViewGroup)
  {
    return new asmc(paramViewGroup);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asmb
 * JD-Core Version:    0.7.0.1
 */