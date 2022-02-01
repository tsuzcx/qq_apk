import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.widget.qqfloatingscreen.FloatingScreenContainer;
import com.tencent.mobileqq.widget.qqfloatingscreen.listener.IVideoInnerStatusListener;

class biwv
  implements biwq
{
  biwv(biwu parambiwu) {}
  
  public void a()
  {
    if (biwu.a(this.a) != null)
    {
      biwu.a(this.a).notifyVideoStop();
      biwu.a(this.a, 1);
    }
    this.a.a(true, new View[] { biwu.a(this.a) });
  }
  
  public void a(boolean paramBoolean)
  {
    if ((this.a.a != null) && (this.a.a.getVisibility() != 0))
    {
      this.a.a(true, new View[] { this.a.a });
      if ((paramBoolean) && (biwu.a(this.a) != null) && (biwu.a(this.a) == 0))
      {
        biwu.a(this.a).notifyVideoStart();
        this.a.a(false, new View[] { biwu.a(this.a) });
      }
    }
    else
    {
      return;
    }
    if ((biwu.a(this.a) != null) && (biwu.a(this.a).getVisibility() == 0))
    {
      this.a.a(false, new View[] { biwu.a(this.a) });
      return;
    }
    this.a.a(true, new View[] { biwu.a(this.a) });
    biwu.a(this.a, 1);
  }
  
  public void b()
  {
    if (biwu.a(this.a) != null) {
      biwu.a(this.a).notifyVideoStop();
    }
    this.a.a(true, new View[] { biwu.a(this.a) });
    this.a.a(false, new View[] { this.a.a });
  }
  
  public void c()
  {
    this.a.b(5);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     biwv
 * JD-Core Version:    0.7.0.1
 */