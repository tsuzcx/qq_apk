import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.widget.qqfloatingscreen.FloatingScreenContainer;
import com.tencent.mobileqq.widget.qqfloatingscreen.listener.IVideoInnerStatusListener;

class bhmf
  implements bhma
{
  bhmf(bhme parambhme) {}
  
  public void a()
  {
    if (bhme.a(this.a) != null)
    {
      bhme.a(this.a).notifyVideoStop();
      bhme.a(this.a, 1);
    }
    this.a.a(true, new View[] { bhme.a(this.a) });
  }
  
  public void a(boolean paramBoolean)
  {
    if ((this.a.a != null) && (this.a.a.getVisibility() != 0))
    {
      this.a.a(true, new View[] { this.a.a });
      if ((paramBoolean) && (bhme.a(this.a) != null) && (bhme.a(this.a) == 0))
      {
        bhme.a(this.a).notifyVideoStart();
        this.a.a(false, new View[] { bhme.a(this.a) });
      }
    }
    else
    {
      return;
    }
    if ((bhme.a(this.a) != null) && (bhme.a(this.a).getVisibility() == 0))
    {
      this.a.a(false, new View[] { bhme.a(this.a) });
      return;
    }
    this.a.a(true, new View[] { bhme.a(this.a) });
    bhme.a(this.a, 1);
  }
  
  public void b()
  {
    if (bhme.a(this.a) != null) {
      bhme.a(this.a).notifyVideoStop();
    }
    this.a.a(true, new View[] { bhme.a(this.a) });
    this.a.a(false, new View[] { this.a.a });
  }
  
  public void c()
  {
    this.a.b(5);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhmf
 * JD-Core Version:    0.7.0.1
 */