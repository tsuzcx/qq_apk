import android.content.Intent;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.DiscussionObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import cooperation.dingdong.DingdongPluginHelper;
import cooperation.dingdong.DingdongPluginRemoteCmdHandler;
import java.util.ArrayList;

public class amlb
  extends DiscussionObserver
{
  public amlb(DingdongPluginRemoteCmdHandler paramDingdongPluginRemoteCmdHandler) {}
  
  protected void a(boolean paramBoolean, int paramInt, long paramLong, String paramString)
  {
    Object localObject;
    if (DingdongPluginRemoteCmdHandler.a(this.a))
    {
      DingdongPluginRemoteCmdHandler.a(this.a, false);
      localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      if (!TextUtils.isEmpty(DingdongPluginRemoteCmdHandler.a(this.a))) {
        DingdongPluginRemoteCmdHandler.a(this.a, (QQAppInterface)localObject, DingdongPluginRemoteCmdHandler.a(this.a), paramLong);
      }
      if (localObject != null) {
        ((QQAppInterface)localObject).removeObserver(DingdongPluginRemoteCmdHandler.a(this.a));
      }
      localObject = new Intent();
      ((Intent)localObject).putExtra("reqCode", 5);
      ((Intent)localObject).putExtra("isSuccess", paramBoolean);
      ((Intent)localObject).putExtra("roomId", paramLong);
      ((Intent)localObject).putExtra("discussName", paramString);
      ((Intent)localObject).putExtra("discuss_create_reason", DingdongPluginRemoteCmdHandler.a(this.a));
      ((Intent)localObject).putExtra("createdFlag", 1);
      if (DingdongPluginRemoteCmdHandler.b(this.a) == 1) {
        DingdongPluginHelper.a(10, (Intent)localObject);
      }
    }
    else
    {
      return;
    }
    DingdongPluginHelper.a(2, (Intent)localObject);
  }
  
  protected void a(boolean paramBoolean, int paramInt, long paramLong, ArrayList paramArrayList)
  {
    if (DingdongPluginRemoteCmdHandler.a(this.a))
    {
      DingdongPluginRemoteCmdHandler.a(this.a, false);
      paramArrayList = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      if (paramArrayList != null) {
        paramArrayList.removeObserver(DingdongPluginRemoteCmdHandler.a(this.a));
      }
      paramArrayList = new Intent();
      paramArrayList.putExtra("reqCode", 7);
      paramArrayList.putExtra("isSuccess", paramBoolean);
      paramArrayList.putExtra("roomId", paramLong);
      if (DingdongPluginRemoteCmdHandler.b(this.a) == 1) {
        DingdongPluginHelper.a(11, paramArrayList);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amlb
 * JD-Core Version:    0.7.0.1
 */