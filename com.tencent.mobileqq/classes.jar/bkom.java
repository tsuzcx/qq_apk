import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.mobileqq.app.ThreadManager;
import dov.com.tencent.biz.qqstory.takevideo.tag.EditVideoTagPresenter.2.1;
import java.util.List;

public class bkom
  extends syr<tnd, toq>
{
  bkom(bkok parambkok) {}
  
  public void a(@NonNull tnd paramtnd, @Nullable toq paramtoq, @NonNull ErrorMessage paramErrorMessage)
  {
    ved.b("EditVideoTagPresenter", "loadMore onCmdRespond.");
    if ((paramErrorMessage.isSuccess()) && (paramtoq != null))
    {
      ved.a("EditVideoTagPresenter", "loadMore onCmdRespond, refresh success:[%s]", paramtoq.toString());
      bkok.a(this.a).addAll(paramtoq.jdField_a_of_type_JavaUtilList);
      bkok.a(this.a, paramtoq.jdField_a_of_type_JavaLangString);
      bkok.a(this.a, paramtoq.b);
      ThreadManager.executeOnSubThread(new EditVideoTagPresenter.2.1(this));
    }
    for (;;)
    {
      bkok.a(this.a).b(paramErrorMessage.errorCode, bkok.a(this.a), this.a.a());
      return;
      ved.e("EditVideoTagPresenter", "loadMore onCmdRespond, failed:[%s]", new Object[] { paramErrorMessage.toString() });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bkom
 * JD-Core Version:    0.7.0.1
 */