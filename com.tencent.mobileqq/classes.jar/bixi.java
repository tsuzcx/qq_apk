import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.mobileqq.app.ThreadManager;
import dov.com.tencent.biz.qqstory.takevideo.tag.EditVideoTagPresenter.1.1;
import java.util.ArrayList;
import java.util.List;

public class bixi
  extends sly<tak, tbx>
{
  bixi(bixh parambixh) {}
  
  public void a(@NonNull tak paramtak, @Nullable tbx paramtbx, @NonNull ErrorMessage paramErrorMessage)
  {
    urk.b("EditVideoTagPresenter", "refresh onCmdRespond.");
    if ((paramErrorMessage.isSuccess()) && (paramtbx != null))
    {
      urk.a("EditVideoTagPresenter", "refresh onCmdRespond, refresh success:[%s]", paramtbx.toString());
      paramtak = paramtbx.jdField_a_of_type_JavaUtilList;
      if (paramtak.contains(bixh.a(this.a)))
      {
        int i = paramtak.indexOf(bixh.a(this.a));
        bixh.a(this.a, (vik)paramtak.get(i));
        bixh.a(this.a).clear();
        bixh.a(this.a).addAll(paramtak);
        paramtak = new ArrayList(bixh.a(this.a));
        bixh.a(this.a, paramtbx.jdField_a_of_type_JavaLangString);
        bixh.a(this.a, paramtbx.b);
        ThreadManager.executeOnSubThread(new EditVideoTagPresenter.1.1(this, paramtak));
      }
    }
    for (;;)
    {
      bixh.a(this.a).a(paramErrorMessage.errorCode, bixh.a(this.a), this.a.a());
      return;
      bixh.a(this.a, null);
      break;
      urk.e("EditVideoTagPresenter", "refresh onCmdRespond, failed:[%s]", new Object[] { paramErrorMessage.toString() });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bixi
 * JD-Core Version:    0.7.0.1
 */