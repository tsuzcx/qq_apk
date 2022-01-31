import QC.SetFontBubbleRsp;
import android.os.Bundle;
import com.tencent.mobileqq.activity.BaseChatPie;
import java.lang.ref.WeakReference;

public class aqwt
  extends akfy
{
  private WeakReference<BaseChatPie> a;
  
  public aqwt(BaseChatPie paramBaseChatPie)
  {
    this.a = new WeakReference(paramBaseChatPie);
  }
  
  public void a(Bundle paramBundle)
  {
    BaseChatPie localBaseChatPie = (BaseChatPie)this.a.get();
    if (localBaseChatPie != null) {
      aqwp.a(localBaseChatPie.a).a(localBaseChatPie, paramBundle);
    }
  }
  
  public void a(boolean paramBoolean, SetFontBubbleRsp paramSetFontBubbleRsp, int paramInt)
  {
    BaseChatPie localBaseChatPie = (BaseChatPie)this.a.get();
    if (localBaseChatPie != null) {
      aqwp.a(localBaseChatPie.a).a(localBaseChatPie, paramBoolean, paramSetFontBubbleRsp, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aqwt
 * JD-Core Version:    0.7.0.1
 */