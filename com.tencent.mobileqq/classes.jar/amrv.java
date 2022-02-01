import android.widget.RelativeLayout;
import com.tencent.mobileqq.apollo.debug.CmGameDebugView;

public class amrv
  implements amrp
{
  public amrv(CmGameDebugView paramCmGameDebugView) {}
  
  public void a(int paramInt)
  {
    if (CmGameDebugView.a(this.a).getVisibility() != 0)
    {
      CmGameDebugView.b(this.a, true);
      return;
    }
    CmGameDebugView.b(this.a, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amrv
 * JD-Core Version:    0.7.0.1
 */