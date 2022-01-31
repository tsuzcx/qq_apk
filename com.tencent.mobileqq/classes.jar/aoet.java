import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mobileqq.confess.ConfessPlugin;
import com.tencent.mobileqq.confess.ConfessPlugin.5;
import com.tencent.mobileqq.confess.ConfessPlugin.5.1;
import com.tencent.qphone.base.util.QLog;

public class aoet
  implements bevy
{
  public aoet(ConfessPlugin.5.1 param1) {}
  
  public void a(BaseResp paramBaseResp)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ConfessPlugin", 2, "onWXShareResp resp.errCode=" + paramBaseResp.errCode);
    }
    switch (paramBaseResp.errCode)
    {
    case -1: 
    default: 
      ConfessPlugin.a(this.a.a.this$0, false);
      ConfessPlugin.a(this.a.a.this$0, 1, 2131720019);
      return;
    case 0: 
      ConfessPlugin.a(this.a.a.this$0, true);
      ConfessPlugin.a(this.a.a.this$0, 2, 2131720038);
      return;
    }
    ConfessPlugin.a(this.a.a.this$0, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aoet
 * JD-Core Version:    0.7.0.1
 */