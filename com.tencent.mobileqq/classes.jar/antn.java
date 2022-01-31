import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.channel.CmdTaskManger.CommandCallback;
import com.tencent.biz.qqstory.model.AddressDataProvider.AddressInfo;
import com.tencent.biz.qqstory.network.request.GetLocationRequest;
import com.tencent.biz.qqstory.network.response.GetLocationResponse;
import com.tencent.biz.qqstory.support.logging.SLog;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoFilterNeo;

public class antn
  implements CmdTaskManger.CommandCallback
{
  public antn(EditVideoFilterNeo paramEditVideoFilterNeo) {}
  
  public void a(@NonNull GetLocationRequest paramGetLocationRequest, @Nullable GetLocationResponse paramGetLocationResponse, @NonNull ErrorMessage paramErrorMessage)
  {
    SLog.b("Q.qqstory.publish.edit.EditVideoFilterNeo", "requestAddress Cmd Respond.");
    if ((paramErrorMessage.isSuccess()) && (paramGetLocationResponse != null))
    {
      SLog.a("Q.qqstory.publish.edit.EditVideoFilterNeo", "requestAddress onCmdRespond success : %s .", paramGetLocationResponse.toString());
      paramGetLocationRequest = new AddressDataProvider.AddressInfo(paramGetLocationResponse.a, paramGetLocationResponse.c, paramGetLocationResponse.d, paramGetLocationResponse.e, paramGetLocationResponse.f, paramGetLocationRequest.d, paramGetLocationRequest.e);
      this.a.a(0, paramGetLocationRequest);
      return;
    }
    SLog.e("Q.qqstory.publish.edit.EditVideoFilterNeo", "requestAddress onCmdRespond failed : %s .", new Object[] { paramErrorMessage.toString() });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     antn
 * JD-Core Version:    0.7.0.1
 */