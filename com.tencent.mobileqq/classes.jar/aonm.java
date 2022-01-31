import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.channel.CmdTaskManger.UIThreadCallback;
import com.tencent.biz.qqstory.network.request.GetTagListRequest;
import com.tencent.biz.qqstory.network.response.GetTagListResponse;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.takevideo.tag.TagItem;
import com.tencent.mobileqq.app.ThreadManager;
import dov.com.tencent.biz.qqstory.takevideo.tag.EditVideoTagPresenter;
import dov.com.tencent.biz.qqstory.takevideo.tag.IEditVideoTagView;
import java.util.List;

public class aonm
  extends CmdTaskManger.UIThreadCallback
{
  public aonm(EditVideoTagPresenter paramEditVideoTagPresenter) {}
  
  public void a(@NonNull GetTagListRequest paramGetTagListRequest, @Nullable GetTagListResponse paramGetTagListResponse, @NonNull ErrorMessage paramErrorMessage)
  {
    SLog.b("EditVideoTagPresenter", "refresh onCmdRespond.");
    if ((paramErrorMessage.isSuccess()) && (paramGetTagListResponse != null))
    {
      SLog.a("EditVideoTagPresenter", "refresh onCmdRespond, refresh success:[%s]", paramGetTagListResponse.toString());
      paramGetTagListRequest = paramGetTagListResponse.jdField_a_of_type_JavaUtilList;
      if (paramGetTagListRequest.contains(EditVideoTagPresenter.a(this.a)))
      {
        int i = paramGetTagListRequest.indexOf(EditVideoTagPresenter.a(this.a));
        EditVideoTagPresenter.a(this.a, (TagItem)paramGetTagListRequest.get(i));
        EditVideoTagPresenter.a(this.a).clear();
        EditVideoTagPresenter.a(this.a).addAll(paramGetTagListRequest);
        EditVideoTagPresenter.a(this.a, paramGetTagListResponse.jdField_a_of_type_JavaLangString);
        EditVideoTagPresenter.a(this.a, paramGetTagListResponse.b);
        ThreadManager.executeOnSubThread(new aonn(this));
      }
    }
    for (;;)
    {
      EditVideoTagPresenter.a(this.a).a(paramErrorMessage.errorCode, EditVideoTagPresenter.a(this.a), this.a.a());
      return;
      EditVideoTagPresenter.a(this.a, null);
      break;
      SLog.e("EditVideoTagPresenter", "refresh onCmdRespond, failed:[%s]", new Object[] { paramErrorMessage.toString() });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     aonm
 * JD-Core Version:    0.7.0.1
 */