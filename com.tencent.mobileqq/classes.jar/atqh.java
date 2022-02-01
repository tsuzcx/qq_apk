import android.view.ViewGroup;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.FaceDecoder;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.search.ChatFileSearchFragment;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class atqh
  extends bcbd<bcfj, bcnt>
{
  public atqh(ListView paramListView, FaceDecoder paramFaceDecoder, List<bcfj> paramList, String paramString, QQAppInterface paramQQAppInterface)
  {
    super(paramFaceDecoder, paramList);
    if (paramString == null) {
      return;
    }
    if (paramString.size() == 1)
    {
      paramListView = (atqf)paramString.get(0);
      if (paramListView.jdField_a_of_type_JavaUtilList.size() > 1)
      {
        paramFaceDecoder = new ArrayList();
        paramList = paramListView.jdField_a_of_type_JavaUtilList.iterator();
        while (paramList.hasNext())
        {
          paramString = (FileManagerEntity)paramList.next();
          paramQQAppInterface = new atqf();
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
  
  protected bcif<bcfj, bcnt> a(int paramInt)
  {
    return new atqo(ChatFileSearchFragment.a(this.a));
  }
  
  protected bcnu a(int paramInt, ViewGroup paramViewGroup)
  {
    return new atqi(paramViewGroup);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atqh
 * JD-Core Version:    0.7.0.1
 */