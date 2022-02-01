import android.widget.TextView;
import com.tencent.mobileqq.widget.QQToast;
import java.util.List;

class bqcc
  implements bqsr<Boolean, bqsx>
{
  bqcc(bqcb parambqcb) {}
  
  public Void a(Boolean paramBoolean, bqsx parambqsx)
  {
    if (paramBoolean.booleanValue())
    {
      yuk.b("Q.qqstory.record.EditLocalVideoPlayer.Flow", "ThumbnailResult succ=%b size=%d", paramBoolean, Integer.valueOf(Math.max(parambqsx.b.size(), parambqsx.jdField_a_of_type_JavaUtilList.size())));
      this.a.a.setEnabled(true);
    }
    for (;;)
    {
      return null;
      yuk.e("Q.qqstory.record.EditLocalVideoPlayer.Flow", "ThumbnailResult error!!! errorCode=" + parambqsx.jdField_a_of_type_Int);
      QQToast.a(this.a.a(), 1, anzj.a(2131702562) + parambqsx.jdField_a_of_type_Int, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bqcc
 * JD-Core Version:    0.7.0.1
 */