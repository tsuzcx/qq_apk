import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.webviewplugin.QzoneDynamicAlbumPlugin;
import java.util.List;

public class ankp
  implements Runnable
{
  public ankp(QzoneDynamicAlbumPlugin paramQzoneDynamicAlbumPlugin, List paramList, String[] paramArrayOfString) {}
  
  public void run()
  {
    int i = 0;
    if (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      if (this.jdField_a_of_type_JavaUtilList.get(i) == null) {}
      for (;;)
      {
        i += 1;
        break;
        if (!QzoneDynamicAlbumPlugin.a(BaseApplicationImpl.getContext(), (String)this.jdField_a_of_type_JavaUtilList.get(i), this.jdField_a_of_type_ArrayOfJavaLangString[i], QzoneDynamicAlbumPlugin.b()[0], QzoneDynamicAlbumPlugin.b()[1])) {
          QLog.i("QZLog", 2, "DynamicQzoneDynamicAlbumPlugin compress failed! ");
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("QZLog", 2, "DynamicQzoneDynamicAlbumPlugin compress all done  ");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ankp
 * JD-Core Version:    0.7.0.1
 */