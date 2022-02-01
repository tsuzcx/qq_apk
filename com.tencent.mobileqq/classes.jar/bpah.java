import android.widget.TextView;
import com.tencent.mobileqq.widget.QQToast;
import java.util.List;

class bpah
  implements bpqw<Boolean, bprc>
{
  bpah(bpag parambpag) {}
  
  public Void a(Boolean paramBoolean, bprc parambprc)
  {
    if (paramBoolean.booleanValue())
    {
      yqp.b("Q.qqstory.record.EditLocalVideoPlayer.Flow", "ThumbnailResult succ=%b size=%d", paramBoolean, Integer.valueOf(Math.max(parambprc.b.size(), parambprc.jdField_a_of_type_JavaUtilList.size())));
      this.a.a.setEnabled(true);
    }
    for (;;)
    {
      return null;
      yqp.e("Q.qqstory.record.EditLocalVideoPlayer.Flow", "ThumbnailResult error!!! errorCode=" + parambprc.jdField_a_of_type_Int);
      QQToast.a(this.a.a(), 1, anni.a(2131702455) + parambprc.jdField_a_of_type_Int, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpah
 * JD-Core Version:    0.7.0.1
 */