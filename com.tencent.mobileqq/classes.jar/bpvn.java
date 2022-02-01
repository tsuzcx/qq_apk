import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.mobileqq.app.ThreadManager;
import dov.com.tencent.biz.qqstory.takevideo.tag.EditVideoTagPresenter.1.1;
import java.util.ArrayList;
import java.util.List;

public class bpvn
  extends wle<wzq, xbd>
{
  bpvn(bpvm parambpvm) {}
  
  public void a(@NonNull wzq paramwzq, @Nullable xbd paramxbd, @NonNull ErrorMessage paramErrorMessage)
  {
    yqp.b("EditVideoTagPresenter", "refresh onCmdRespond.");
    if ((paramErrorMessage.isSuccess()) && (paramxbd != null))
    {
      yqp.a("EditVideoTagPresenter", "refresh onCmdRespond, refresh success:[%s]", paramxbd.toString());
      paramwzq = paramxbd.jdField_a_of_type_JavaUtilList;
      if (paramwzq.contains(bpvm.a(this.a)))
      {
        int i = paramwzq.indexOf(bpvm.a(this.a));
        bpvm.a(this.a, (zhp)paramwzq.get(i));
        bpvm.a(this.a).clear();
        bpvm.a(this.a).addAll(paramwzq);
        paramwzq = new ArrayList(bpvm.a(this.a));
        bpvm.a(this.a, paramxbd.jdField_a_of_type_JavaLangString);
        bpvm.a(this.a, paramxbd.b);
        ThreadManager.executeOnSubThread(new EditVideoTagPresenter.1.1(this, paramwzq));
      }
    }
    for (;;)
    {
      bpvm.a(this.a).a(paramErrorMessage.errorCode, bpvm.a(this.a), this.a.a());
      return;
      bpvm.a(this.a, null);
      break;
      yqp.e("EditVideoTagPresenter", "refresh onCmdRespond, failed:[%s]", new Object[] { paramErrorMessage.toString() });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpvn
 * JD-Core Version:    0.7.0.1
 */