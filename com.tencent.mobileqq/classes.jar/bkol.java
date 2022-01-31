import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.mobileqq.app.ThreadManager;
import dov.com.tencent.biz.qqstory.takevideo.tag.EditVideoTagPresenter.1.1;
import java.util.ArrayList;
import java.util.List;

public class bkol
  extends syr<tnd, toq>
{
  bkol(bkok parambkok) {}
  
  public void a(@NonNull tnd paramtnd, @Nullable toq paramtoq, @NonNull ErrorMessage paramErrorMessage)
  {
    ved.b("EditVideoTagPresenter", "refresh onCmdRespond.");
    if ((paramErrorMessage.isSuccess()) && (paramtoq != null))
    {
      ved.a("EditVideoTagPresenter", "refresh onCmdRespond, refresh success:[%s]", paramtoq.toString());
      paramtnd = paramtoq.jdField_a_of_type_JavaUtilList;
      if (paramtnd.contains(bkok.a(this.a)))
      {
        int i = paramtnd.indexOf(bkok.a(this.a));
        bkok.a(this.a, (vvd)paramtnd.get(i));
        bkok.a(this.a).clear();
        bkok.a(this.a).addAll(paramtnd);
        paramtnd = new ArrayList(bkok.a(this.a));
        bkok.a(this.a, paramtoq.jdField_a_of_type_JavaLangString);
        bkok.a(this.a, paramtoq.b);
        ThreadManager.executeOnSubThread(new EditVideoTagPresenter.1.1(this, paramtnd));
      }
    }
    for (;;)
    {
      bkok.a(this.a).a(paramErrorMessage.errorCode, bkok.a(this.a), this.a.a());
      return;
      bkok.a(this.a, null);
      break;
      ved.e("EditVideoTagPresenter", "refresh onCmdRespond, failed:[%s]", new Object[] { paramErrorMessage.toString() });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bkol
 * JD-Core Version:    0.7.0.1
 */