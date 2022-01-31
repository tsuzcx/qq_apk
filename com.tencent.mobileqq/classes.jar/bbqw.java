import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.widget.qqfloatingscreen.FloatingScreenContainer;
import com.tencent.mobileqq.widget.qqfloatingscreen.listener.IVideoInnerStatusListener;

class bbqw
  implements bbqr
{
  bbqw(bbqv parambbqv) {}
  
  public void a()
  {
    if (bbqv.a(this.a) != null)
    {
      bbqv.a(this.a).notifyVideoStop();
      bbqv.a(this.a, 1);
    }
    this.a.a(true, new View[] { bbqv.a(this.a) });
  }
  
  public void a(boolean paramBoolean)
  {
    if ((this.a.a != null) && (this.a.a.getVisibility() != 0))
    {
      this.a.a(true, new View[] { this.a.a });
      if ((paramBoolean) && (bbqv.a(this.a) != null) && (bbqv.a(this.a) == 0))
      {
        bbqv.a(this.a).notifyVideoStart();
        this.a.a(false, new View[] { bbqv.a(this.a) });
      }
    }
    else
    {
      return;
    }
    if ((bbqv.a(this.a) != null) && (bbqv.a(this.a).getVisibility() == 0))
    {
      this.a.a(false, new View[] { bbqv.a(this.a) });
      return;
    }
    this.a.a(true, new View[] { bbqv.a(this.a) });
    bbqv.a(this.a, 1);
  }
  
  public void b()
  {
    if (bbqv.a(this.a) != null) {
      bbqv.a(this.a).notifyVideoStop();
    }
    this.a.a(true, new View[] { bbqv.a(this.a) });
    this.a.a(false, new View[] { this.a.a });
  }
  
  public void c()
  {
    this.a.a(5);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bbqw
 * JD-Core Version:    0.7.0.1
 */