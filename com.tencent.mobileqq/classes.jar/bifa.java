import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.widget.qqfloatingscreen.FloatingScreenContainer;
import com.tencent.mobileqq.widget.qqfloatingscreen.listener.IVideoInnerStatusListener;

class bifa
  implements biev
{
  bifa(biez parambiez) {}
  
  public void a()
  {
    if (biez.a(this.a) != null)
    {
      biez.a(this.a).notifyVideoStop();
      biez.a(this.a, 1);
    }
    this.a.a(true, new View[] { biez.a(this.a) });
  }
  
  public void a(boolean paramBoolean)
  {
    if ((this.a.a != null) && (this.a.a.getVisibility() != 0))
    {
      this.a.a(true, new View[] { this.a.a });
      if ((paramBoolean) && (biez.a(this.a) != null) && (biez.a(this.a) == 0))
      {
        biez.a(this.a).notifyVideoStart();
        this.a.a(false, new View[] { biez.a(this.a) });
      }
    }
    else
    {
      return;
    }
    if ((biez.a(this.a) != null) && (biez.a(this.a).getVisibility() == 0))
    {
      this.a.a(false, new View[] { biez.a(this.a) });
      return;
    }
    this.a.a(true, new View[] { biez.a(this.a) });
    biez.a(this.a, 1);
  }
  
  public void b()
  {
    if (biez.a(this.a) != null) {
      biez.a(this.a).notifyVideoStop();
    }
    this.a.a(true, new View[] { biez.a(this.a) });
    this.a.a(false, new View[] { this.a.a });
  }
  
  public void c()
  {
    this.a.b(5);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bifa
 * JD-Core Version:    0.7.0.1
 */