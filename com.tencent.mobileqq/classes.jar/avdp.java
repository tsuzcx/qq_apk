import com.etrump.mixlayout.ETTextView;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.richstatus.SignatureFontView;

public class avdp
  extends fs
{
  public avdp(SignatureFontView paramSignatureFontView) {}
  
  public void a(ChatMessage paramChatMessage, int paramInt)
  {
    if ((SignatureFontView.a(this.a) < 0) || (SignatureFontView.b(this.a) < SignatureFontView.a(this.a)))
    {
      this.a.a.d = true;
      this.a.a.a(false, false);
      if (SignatureFontView.a(this.a) > 0) {
        SignatureFontView.c(this.a);
      }
    }
  }
  
  public void a(ChatMessage paramChatMessage, boolean paramBoolean, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     avdp
 * JD-Core Version:    0.7.0.1
 */