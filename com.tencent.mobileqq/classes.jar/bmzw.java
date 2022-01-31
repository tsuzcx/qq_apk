import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.mobileqq.app.ThreadManager;
import dov.com.tencent.biz.qqstory.takevideo.tag.EditVideoTagPresenter.2.1;
import java.util.List;

public class bmzw
  extends unj<vbv, vdi>
{
  bmzw(bmzu parambmzu) {}
  
  public void a(@NonNull vbv paramvbv, @Nullable vdi paramvdi, @NonNull ErrorMessage paramErrorMessage)
  {
    wsv.b("EditVideoTagPresenter", "loadMore onCmdRespond.");
    if ((paramErrorMessage.isSuccess()) && (paramvdi != null))
    {
      wsv.a("EditVideoTagPresenter", "loadMore onCmdRespond, refresh success:[%s]", paramvdi.toString());
      bmzu.a(this.a).addAll(paramvdi.jdField_a_of_type_JavaUtilList);
      bmzu.a(this.a, paramvdi.jdField_a_of_type_JavaLangString);
      bmzu.a(this.a, paramvdi.b);
      ThreadManager.executeOnSubThread(new EditVideoTagPresenter.2.1(this));
    }
    for (;;)
    {
      bmzu.a(this.a).b(paramErrorMessage.errorCode, bmzu.a(this.a), this.a.a());
      return;
      wsv.e("EditVideoTagPresenter", "loadMore onCmdRespond, failed:[%s]", new Object[] { paramErrorMessage.toString() });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmzw
 * JD-Core Version:    0.7.0.1
 */