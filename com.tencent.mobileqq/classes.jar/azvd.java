import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class azvd
  extends azql
{
  public boolean c;
  public int k;
  public int l = 3;
  
  public azvd()
  {
    this(null);
  }
  
  public azvd(String paramString)
  {
    super(paramString, "summary");
  }
  
  public View a(Context paramContext, View paramView, Bundle paramBundle)
  {
    Object localObject1;
    if ((paramBundle != null) && (paramBundle.containsKey("extend-data-json")) && (paramBundle.getInt("serviceID", 0) == 128))
    {
      localObject1 = paramBundle.getString("extend-data-json");
      if (TextUtils.isEmpty((CharSequence)localObject1)) {}
    }
    try
    {
      Object localObject2;
      Object localObject3;
      if ((paramContext instanceof BaseActivity))
      {
        localObject2 = new JSONObject((String)localObject1);
        localObject3 = ((BaseActivity)paramContext).app;
        localStringBuilder = new StringBuilder();
        if (!((JSONObject)localObject2).has("senderuin")) {
          break label308;
        }
        localObject1 = ((JSONObject)localObject2).optString("senderuin");
        if (!TextUtils.equals((CharSequence)localObject1, ((QQAppInterface)localObject3).c())) {
          break label247;
        }
        localObject1 = bdbt.a((QQAppInterface)localObject3, ((JSONObject)localObject2).optString("invitedUin"), 0);
        localStringBuilder.append("你邀请").append(bdbt.a((String)localObject1, 12.0F));
      }
      for (;;)
      {
        localObject1 = ((JSONObject)localObject2).optString("groupname");
        localObject3 = (TroopManager)((QQAppInterface)localObject3).getManager(52);
        if (localObject3 == null) {
          break;
        }
        localObject2 = ((TroopManager)localObject3).b(((JSONObject)localObject2).optString("groupcode"));
        if (localObject2 == null) {
          break;
        }
        localObject2 = ((TroopInfo)localObject2).getTroopName();
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          break;
        }
        localObject1 = localObject2;
        localStringBuilder.append("加入群聊“").append(bdbt.a((String)localObject1, 12.0F)).append("”，进入可查看详情。");
        this.Y = localStringBuilder.toString();
        return super.a(paramContext, paramView, paramBundle);
        label247:
        localStringBuilder.append(bdbt.a(bdbt.a((QQAppInterface)localObject3, (String)localObject1, 0), 12.0F)).append("邀请你");
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        StringBuilder localStringBuilder;
        QLog.d("StructMsg", 1, "createView error:" + localThrowable.getMessage());
        continue;
        label308:
        localStringBuilder.append("邀请");
      }
    }
  }
  
  public String a()
  {
    return "Summary";
  }
  
  public void a(AbsShareMsg paramAbsShareMsg)
  {
    paramAbsShareMsg.mContentSummary = this.Y;
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    this.c = paramBoolean;
    this.k = paramInt;
  }
  
  public int b()
  {
    if ((this.a != null) && (this.a.mMsgServiceID == 35)) {
      return super.b();
    }
    return this.l;
  }
  
  public void b(int paramInt)
  {
    this.l = paramInt;
  }
  
  public int c()
  {
    return 2131378960;
  }
  
  public int e()
  {
    if ((this.c) && (this.k != 0)) {
      return -1;
    }
    return -8355712;
  }
  
  public int f()
  {
    return 28;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azvd
 * JD-Core Version:    0.7.0.1
 */