import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.widget.qqfloatingscreen.FloatingScreenContainer;
import com.tencent.mobileqq.widget.qqfloatingscreen.listener.IVideoInnerStatusListener;

class bcuk
  implements bcuf
{
  bcuk(bcuj parambcuj) {}
  
  public void a()
  {
    if (bcuj.a(this.a) != null)
    {
      bcuj.a(this.a).notifyVideoStop();
      bcuj.a(this.a, 1);
    }
    this.a.a(true, new View[] { bcuj.a(this.a) });
  }
  
  public void a(boolean paramBoolean)
  {
    if ((this.a.a != null) && (this.a.a.getVisibility() != 0))
    {
      this.a.a(true, new View[] { this.a.a });
      if ((paramBoolean) && (bcuj.a(this.a) != null) && (bcuj.a(this.a) == 0))
      {
        bcuj.a(this.a).notifyVideoStart();
        this.a.a(false, new View[] { bcuj.a(this.a) });
      }
    }
    else
    {
      return;
    }
    if ((bcuj.a(this.a) != null) && (bcuj.a(this.a).getVisibility() == 0))
    {
      this.a.a(false, new View[] { bcuj.a(this.a) });
      return;
    }
    this.a.a(true, new View[] { bcuj.a(this.a) });
    bcuj.a(this.a, 1);
  }
  
  public void b()
  {
    if (bcuj.a(this.a) != null) {
      bcuj.a(this.a).notifyVideoStop();
    }
    this.a.a(true, new View[] { bcuj.a(this.a) });
    this.a.a(false, new View[] { this.a.a });
  }
  
  public void c()
  {
    this.a.b(5);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bcuk
 * JD-Core Version:    0.7.0.1
 */