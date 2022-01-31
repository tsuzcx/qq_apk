import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.mobileqq.app.ThreadManager;
import dov.com.tencent.biz.qqstory.takevideo.tag.EditVideoTagPresenter.2.1;
import java.util.List;

public class bknv
  extends syu<tng, tot>
{
  bknv(bknt parambknt) {}
  
  public void a(@NonNull tng paramtng, @Nullable tot paramtot, @NonNull ErrorMessage paramErrorMessage)
  {
    veg.b("EditVideoTagPresenter", "loadMore onCmdRespond.");
    if ((paramErrorMessage.isSuccess()) && (paramtot != null))
    {
      veg.a("EditVideoTagPresenter", "loadMore onCmdRespond, refresh success:[%s]", paramtot.toString());
      bknt.a(this.a).addAll(paramtot.jdField_a_of_type_JavaUtilList);
      bknt.a(this.a, paramtot.jdField_a_of_type_JavaLangString);
      bknt.a(this.a, paramtot.b);
      ThreadManager.executeOnSubThread(new EditVideoTagPresenter.2.1(this));
    }
    for (;;)
    {
      bknt.a(this.a).b(paramErrorMessage.errorCode, bknt.a(this.a), this.a.a());
      return;
      veg.e("EditVideoTagPresenter", "loadMore onCmdRespond, failed:[%s]", new Object[] { paramErrorMessage.toString() });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bknv
 * JD-Core Version:    0.7.0.1
 */