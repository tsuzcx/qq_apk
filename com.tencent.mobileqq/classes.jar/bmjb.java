import android.widget.TextView;
import com.tencent.mobileqq.widget.QQToast;
import java.util.List;

class bmjb
  implements bmzq<Boolean, bmzw>
{
  bmjb(bmja parambmja) {}
  
  public Void a(Boolean paramBoolean, bmzw parambmzw)
  {
    if (paramBoolean.booleanValue())
    {
      wxe.b("Q.qqstory.record.EditLocalVideoPlayer.Flow", "ThumbnailResult succ=%b size=%d", paramBoolean, Integer.valueOf(Math.max(parambmzw.b.size(), parambmzw.jdField_a_of_type_JavaUtilList.size())));
      this.a.a.setEnabled(true);
    }
    for (;;)
    {
      return null;
      wxe.e("Q.qqstory.record.EditLocalVideoPlayer.Flow", "ThumbnailResult error!!! errorCode=" + parambmzw.jdField_a_of_type_Int);
      QQToast.a(this.a.a(), 1, alud.a(2131704058) + parambmzw.jdField_a_of_type_Int, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmjb
 * JD-Core Version:    0.7.0.1
 */