import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.widget.qqfloatingscreen.FloatingScreenContainer;
import com.tencent.mobileqq.widget.qqfloatingscreen.listener.IVideoInnerStatusListener;

class beyc
  implements bexx
{
  beyc(beyb parambeyb) {}
  
  public void a()
  {
    if (beyb.a(this.a) != null)
    {
      beyb.a(this.a).notifyVideoStop();
      beyb.a(this.a, 1);
    }
    this.a.a(true, new View[] { beyb.a(this.a) });
  }
  
  public void a(boolean paramBoolean)
  {
    if ((this.a.a != null) && (this.a.a.getVisibility() != 0))
    {
      this.a.a(true, new View[] { this.a.a });
      if ((paramBoolean) && (beyb.a(this.a) != null) && (beyb.a(this.a) == 0))
      {
        beyb.a(this.a).notifyVideoStart();
        this.a.a(false, new View[] { beyb.a(this.a) });
      }
    }
    else
    {
      return;
    }
    if ((beyb.a(this.a) != null) && (beyb.a(this.a).getVisibility() == 0))
    {
      this.a.a(false, new View[] { beyb.a(this.a) });
      return;
    }
    this.a.a(true, new View[] { beyb.a(this.a) });
    beyb.a(this.a, 1);
  }
  
  public void b()
  {
    if (beyb.a(this.a) != null) {
      beyb.a(this.a).notifyVideoStop();
    }
    this.a.a(true, new View[] { beyb.a(this.a) });
    this.a.a(false, new View[] { this.a.a });
  }
  
  public void c()
  {
    this.a.b(5);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     beyc
 * JD-Core Version:    0.7.0.1
 */