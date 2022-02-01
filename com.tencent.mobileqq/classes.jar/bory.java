import android.widget.TextView;
import com.tencent.mobileqq.widget.QQToast;
import java.util.List;

class bory
  implements bpdr<Boolean, bpdx>
{
  bory(borx paramborx) {}
  
  public Void a(Boolean paramBoolean, bpdx parambpdx)
  {
    if (paramBoolean.booleanValue())
    {
      ykq.b("Q.qqstory.record.EditLocalVideoPlayer.Flow", "ThumbnailResult succ=%b size=%d", paramBoolean, Integer.valueOf(Math.max(parambpdx.b.size(), parambpdx.jdField_a_of_type_JavaUtilList.size())));
      this.a.a.setEnabled(true);
    }
    for (;;)
    {
      return null;
      ykq.e("Q.qqstory.record.EditLocalVideoPlayer.Flow", "ThumbnailResult error!!! errorCode=" + parambpdx.jdField_a_of_type_Int);
      QQToast.a(this.a.a(), 1, anvx.a(2131703148) + parambpdx.jdField_a_of_type_Int, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bory
 * JD-Core Version:    0.7.0.1
 */