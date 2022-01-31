import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.mobileqq.app.ThreadManager;
import dov.com.tencent.biz.qqstory.takevideo.tag.EditVideoTagPresenter.1.1;
import java.util.ArrayList;
import java.util.List;

public class bmzv
  extends unj<vbv, vdi>
{
  bmzv(bmzu parambmzu) {}
  
  public void a(@NonNull vbv paramvbv, @Nullable vdi paramvdi, @NonNull ErrorMessage paramErrorMessage)
  {
    wsv.b("EditVideoTagPresenter", "refresh onCmdRespond.");
    if ((paramErrorMessage.isSuccess()) && (paramvdi != null))
    {
      wsv.a("EditVideoTagPresenter", "refresh onCmdRespond, refresh success:[%s]", paramvdi.toString());
      paramvbv = paramvdi.jdField_a_of_type_JavaUtilList;
      if (paramvbv.contains(bmzu.a(this.a)))
      {
        int i = paramvbv.indexOf(bmzu.a(this.a));
        bmzu.a(this.a, (xjv)paramvbv.get(i));
        bmzu.a(this.a).clear();
        bmzu.a(this.a).addAll(paramvbv);
        paramvbv = new ArrayList(bmzu.a(this.a));
        bmzu.a(this.a, paramvdi.jdField_a_of_type_JavaLangString);
        bmzu.a(this.a, paramvdi.b);
        ThreadManager.executeOnSubThread(new EditVideoTagPresenter.1.1(this, paramvbv));
      }
    }
    for (;;)
    {
      bmzu.a(this.a).a(paramErrorMessage.errorCode, bmzu.a(this.a), this.a.a());
      return;
      bmzu.a(this.a, null);
      break;
      wsv.e("EditVideoTagPresenter", "refresh onCmdRespond, failed:[%s]", new Object[] { paramErrorMessage.toString() });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmzv
 * JD-Core Version:    0.7.0.1
 */