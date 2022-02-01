import QC.SetFontBubbleRsp;
import android.os.Bundle;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import java.lang.ref.WeakReference;

public class audx
  extends anam
{
  private WeakReference<BaseChatPie> a;
  
  public audx(BaseChatPie paramBaseChatPie)
  {
    this.a = new WeakReference(paramBaseChatPie);
  }
  
  public void a(Bundle paramBundle)
  {
    BaseChatPie localBaseChatPie = (BaseChatPie)this.a.get();
    if (localBaseChatPie != null) {
      audt.a(localBaseChatPie.app).a(localBaseChatPie, paramBundle);
    }
  }
  
  public void a(boolean paramBoolean, SetFontBubbleRsp paramSetFontBubbleRsp, int paramInt)
  {
    BaseChatPie localBaseChatPie = (BaseChatPie)this.a.get();
    if (localBaseChatPie != null) {
      audt.a(localBaseChatPie.app).a(localBaseChatPie, paramBoolean, paramSetFontBubbleRsp, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     audx
 * JD-Core Version:    0.7.0.1
 */