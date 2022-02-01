import android.widget.TextView;
import com.tencent.mobileqq.widget.QQToast;
import java.util.List;

class bncg
  implements bnnz<Boolean, bnof>
{
  bncg(bncf parambncf) {}
  
  public Void a(Boolean paramBoolean, bnof parambnof)
  {
    if (paramBoolean.booleanValue())
    {
      xvv.b("Q.qqstory.record.EditLocalVideoPlayer.Flow", "ThumbnailResult succ=%b size=%d", paramBoolean, Integer.valueOf(Math.max(parambnof.b.size(), parambnof.jdField_a_of_type_JavaUtilList.size())));
      this.a.a.setEnabled(true);
    }
    for (;;)
    {
      return null;
      xvv.e("Q.qqstory.record.EditLocalVideoPlayer.Flow", "ThumbnailResult error!!! errorCode=" + parambnof.jdField_a_of_type_Int);
      QQToast.a(this.a.a(), 1, amtj.a(2131702797) + parambnof.jdField_a_of_type_Int, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bncg
 * JD-Core Version:    0.7.0.1
 */