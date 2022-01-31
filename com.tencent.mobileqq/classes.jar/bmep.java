import android.widget.TextView;
import com.tencent.mobileqq.widget.QQToast;
import java.util.List;

class bmep
  implements bmve<Boolean, bmvk>
{
  bmep(bmeo parambmeo) {}
  
  public Void a(Boolean paramBoolean, bmvk parambmvk)
  {
    if (paramBoolean.booleanValue())
    {
      wsv.b("Q.qqstory.record.EditLocalVideoPlayer.Flow", "ThumbnailResult succ=%b size=%d", paramBoolean, Integer.valueOf(Math.max(parambmvk.b.size(), parambmvk.jdField_a_of_type_JavaUtilList.size())));
      this.a.a.setEnabled(true);
    }
    for (;;)
    {
      return null;
      wsv.e("Q.qqstory.record.EditLocalVideoPlayer.Flow", "ThumbnailResult error!!! errorCode=" + parambmvk.jdField_a_of_type_Int);
      QQToast.a(this.a.a(), 1, alpo.a(2131704046) + parambmvk.jdField_a_of_type_Int, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmep
 * JD-Core Version:    0.7.0.1
 */