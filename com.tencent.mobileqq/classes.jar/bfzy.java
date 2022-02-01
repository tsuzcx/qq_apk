import com.tencent.mobileqq.troop.homework.entry.ui.PublishHomeWorkFragment;
import com.tencent.mobileqq.widget.FormSimpleItem;

public class bfzy
  implements bgbf
{
  public bfzy(PublishHomeWorkFragment paramPublishHomeWorkFragment) {}
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    long l = bgbb.a(this.a.a, paramInt1, paramInt2, paramInt3) / 1000L;
    if (!PublishHomeWorkFragment.a(this.a, l))
    {
      bgbb.a(this.a.a, (bgbb)this.a.a.a());
      return;
    }
    this.a.c = l;
    this.a.a.b();
    this.a.b.setRightText(this.a.a(l));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfzy
 * JD-Core Version:    0.7.0.1
 */