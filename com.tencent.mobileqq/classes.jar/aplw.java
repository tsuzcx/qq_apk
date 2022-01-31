import android.os.Bundle;
import android.os.Handler;
import com.tencent.mobileqq.emosm.web.MessengerService;
import com.tencent.mobileqq.emosm.web.MessengerService.8.1;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.richstatus.TipsInfo;
import com.tencent.qphone.base.util.QLog;

public class aplw
  implements axxl
{
  public aplw(MessengerService paramMessengerService) {}
  
  public void a(int paramInt, RichStatus paramRichStatus, Object paramObject)
  {
    if (this.a.b != null)
    {
      this.a.b.putString("cmd", "ipc_signature_setordelete");
      paramRichStatus = new Bundle();
      paramRichStatus.putInt("result", paramInt);
      paramRichStatus.putBoolean("hasTipsInfo", false);
      if ((paramObject instanceof TipsInfo))
      {
        paramObject = (TipsInfo)paramObject;
        if (paramObject.type > 0)
        {
          paramRichStatus.putInt("result", paramObject.ret);
          paramRichStatus.putBoolean("hasTipsInfo", true);
          paramRichStatus.putInt("tips_type", paramObject.type);
          paramRichStatus.putString("tips_titleWording", paramObject.titleWording);
          paramRichStatus.putString("tips_wording", paramObject.wording);
          paramRichStatus.putString("tips_rightBtnWording", paramObject.rightBtnWording);
          paramRichStatus.putString("tips_leftBtnWording", paramObject.leftBtnWording);
          paramRichStatus.putString("tips_vipType", paramObject.vipType);
          paramRichStatus.putInt("tips_vipMonth", paramObject.vipMonth);
          paramRichStatus.putString("tips_url", paramObject.url);
        }
      }
      this.a.b.putBundle("response", paramRichStatus);
      this.a.a(this.a.b);
      this.a.b = null;
    }
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if (paramInt == -1) {
      if (this.a.a != null) {
        this.a.a.post(new MessengerService.8.1(this));
      }
    }
    while (this.a.c == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("SigImg2Zone", 4, "isSync: " + paramBoolean);
    }
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("isSync", paramBoolean);
    this.a.c.putBundle("response", localBundle);
    this.a.a(this.a.c);
    this.a.c = null;
  }
  
  public void b(int paramInt, boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aplw
 * JD-Core Version:    0.7.0.1
 */