import android.widget.TextView;
import java.util.List;

class bjtf
  implements bkju<Boolean, bkka>
{
  bjtf(bjte parambjte) {}
  
  public Void a(Boolean paramBoolean, bkka parambkka)
  {
    if (paramBoolean.booleanValue())
    {
      ved.b("Q.qqstory.record.EditLocalVideoPlayer.Flow", "ThumbnailResult succ=%b size=%d", paramBoolean, Integer.valueOf(Math.max(parambkka.b.size(), parambkka.jdField_a_of_type_JavaUtilList.size())));
      this.a.a.setEnabled(true);
    }
    for (;;)
    {
      return null;
      ved.e("Q.qqstory.record.EditLocalVideoPlayer.Flow", "ThumbnailResult error!!! errorCode=" + parambkka.jdField_a_of_type_Int);
      bcql.a(this.a.a(), 1, ajya.a(2131703674) + parambkka.jdField_a_of_type_Int, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjtf
 * JD-Core Version:    0.7.0.1
 */