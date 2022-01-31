import android.widget.TextView;
import java.util.List;

class bjso
  implements bkjd<Boolean, bkjj>
{
  bjso(bjsn parambjsn) {}
  
  public Void a(Boolean paramBoolean, bkjj parambkjj)
  {
    if (paramBoolean.booleanValue())
    {
      veg.b("Q.qqstory.record.EditLocalVideoPlayer.Flow", "ThumbnailResult succ=%b size=%d", paramBoolean, Integer.valueOf(Math.max(parambkjj.b.size(), parambkjj.jdField_a_of_type_JavaUtilList.size())));
      this.a.a.setEnabled(true);
    }
    for (;;)
    {
      return null;
      veg.e("Q.qqstory.record.EditLocalVideoPlayer.Flow", "ThumbnailResult error!!! errorCode=" + parambkjj.jdField_a_of_type_Int);
      bcpw.a(this.a.a(), 1, ajyc.a(2131703663) + parambkjj.jdField_a_of_type_Int, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjso
 * JD-Core Version:    0.7.0.1
 */