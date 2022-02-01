import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.widget.qqfloatingscreen.FloatingScreenContainer;
import com.tencent.mobileqq.widget.qqfloatingscreen.listener.IVideoInnerStatusListener;

class bjfz
  implements bjfu
{
  bjfz(bjfy parambjfy) {}
  
  public void a()
  {
    if (bjfy.a(this.a) != null)
    {
      bjfy.a(this.a).notifyVideoStop();
      bjfy.a(this.a, 1);
    }
    this.a.a(true, new View[] { bjfy.a(this.a) });
  }
  
  public void a(boolean paramBoolean)
  {
    if ((this.a.a != null) && (this.a.a.getVisibility() != 0))
    {
      this.a.a(true, new View[] { this.a.a });
      if ((paramBoolean) && (bjfy.a(this.a) != null) && (bjfy.a(this.a) == 0))
      {
        bjfy.a(this.a).notifyVideoStart();
        this.a.a(false, new View[] { bjfy.a(this.a) });
      }
    }
    else
    {
      return;
    }
    if ((bjfy.a(this.a) != null) && (bjfy.a(this.a).getVisibility() == 0))
    {
      this.a.a(false, new View[] { bjfy.a(this.a) });
      return;
    }
    this.a.a(true, new View[] { bjfy.a(this.a) });
    bjfy.a(this.a, 1);
  }
  
  public void b()
  {
    if (bjfy.a(this.a) != null) {
      bjfy.a(this.a).notifyVideoStop();
    }
    this.a.a(true, new View[] { bjfy.a(this.a) });
    this.a.a(false, new View[] { this.a.a });
  }
  
  public void c()
  {
    this.a.b(5);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjfz
 * JD-Core Version:    0.7.0.1
 */