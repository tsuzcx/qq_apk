import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.mobileqq.app.ThreadManager;
import dov.com.tencent.biz.qqstory.takevideo.tag.EditVideoTagPresenter.1.1;
import java.util.ArrayList;
import java.util.List;

public class bneh
  extends urs<vge, vhr>
{
  bneh(bneg parambneg) {}
  
  public void a(@NonNull vge paramvge, @Nullable vhr paramvhr, @NonNull ErrorMessage paramErrorMessage)
  {
    wxe.b("EditVideoTagPresenter", "refresh onCmdRespond.");
    if ((paramErrorMessage.isSuccess()) && (paramvhr != null))
    {
      wxe.a("EditVideoTagPresenter", "refresh onCmdRespond, refresh success:[%s]", paramvhr.toString());
      paramvge = paramvhr.jdField_a_of_type_JavaUtilList;
      if (paramvge.contains(bneg.a(this.a)))
      {
        int i = paramvge.indexOf(bneg.a(this.a));
        bneg.a(this.a, (xoe)paramvge.get(i));
        bneg.a(this.a).clear();
        bneg.a(this.a).addAll(paramvge);
        paramvge = new ArrayList(bneg.a(this.a));
        bneg.a(this.a, paramvhr.jdField_a_of_type_JavaLangString);
        bneg.a(this.a, paramvhr.b);
        ThreadManager.executeOnSubThread(new EditVideoTagPresenter.1.1(this, paramvge));
      }
    }
    for (;;)
    {
      bneg.a(this.a).a(paramErrorMessage.errorCode, bneg.a(this.a), this.a.a());
      return;
      bneg.a(this.a, null);
      break;
      wxe.e("EditVideoTagPresenter", "refresh onCmdRespond, failed:[%s]", new Object[] { paramErrorMessage.toString() });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bneh
 * JD-Core Version:    0.7.0.1
 */