import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.mobileqq.app.ThreadManager;
import dov.com.tencent.biz.qqstory.takevideo.tag.EditVideoTagPresenter.1.1;
import java.util.ArrayList;
import java.util.List;

public class bqxi
  extends woz<xdl, xey>
{
  bqxi(bqxh parambqxh) {}
  
  public void a(@NonNull xdl paramxdl, @Nullable xey paramxey, @NonNull ErrorMessage paramErrorMessage)
  {
    yuk.b("EditVideoTagPresenter", "refresh onCmdRespond.");
    if ((paramErrorMessage.isSuccess()) && (paramxey != null))
    {
      yuk.a("EditVideoTagPresenter", "refresh onCmdRespond, refresh success:[%s]", paramxey.toString());
      paramxdl = paramxey.jdField_a_of_type_JavaUtilList;
      if (paramxdl.contains(bqxh.a(this.a)))
      {
        int i = paramxdl.indexOf(bqxh.a(this.a));
        bqxh.a(this.a, (zlk)paramxdl.get(i));
        bqxh.a(this.a).clear();
        bqxh.a(this.a).addAll(paramxdl);
        paramxdl = new ArrayList(bqxh.a(this.a));
        bqxh.a(this.a, paramxey.jdField_a_of_type_JavaLangString);
        bqxh.a(this.a, paramxey.b);
        ThreadManager.executeOnSubThread(new EditVideoTagPresenter.1.1(this, paramxdl));
      }
    }
    for (;;)
    {
      bqxh.a(this.a).a(paramErrorMessage.errorCode, bqxh.a(this.a), this.a.a());
      return;
      bqxh.a(this.a, null);
      break;
      yuk.e("EditVideoTagPresenter", "refresh onCmdRespond, failed:[%s]", new Object[] { paramErrorMessage.toString() });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bqxi
 * JD-Core Version:    0.7.0.1
 */