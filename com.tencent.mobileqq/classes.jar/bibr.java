import android.widget.TextView;
import java.util.List;

class bibr
  implements bisp<Boolean, bisv>
{
  bibr(bibq parambibq) {}
  
  public Void a(Boolean paramBoolean, bisv parambisv)
  {
    if (paramBoolean.booleanValue())
    {
      urk.b("Q.qqstory.record.EditLocalVideoPlayer.Flow", "ThumbnailResult succ=%b size=%d", paramBoolean, Integer.valueOf(Math.max(parambisv.b.size(), parambisv.jdField_a_of_type_JavaUtilList.size())));
      this.a.a.setEnabled(true);
    }
    for (;;)
    {
      return null;
      urk.e("Q.qqstory.record.EditLocalVideoPlayer.Flow", "ThumbnailResult error!!! errorCode=" + parambisv.jdField_a_of_type_Int);
      bbmy.a(this.a.a(), 1, ajjy.a(2131637878) + parambisv.jdField_a_of_type_Int, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bibr
 * JD-Core Version:    0.7.0.1
 */