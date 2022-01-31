import com.tencent.mobileqq.troop.homework.entry.ui.PublishHomeWorkFragment;
import com.tencent.mobileqq.widget.FormSimpleItem;

public class bbvk
  implements bbwr
{
  public bbvk(PublishHomeWorkFragment paramPublishHomeWorkFragment) {}
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    long l = bbwn.a(this.a.a, paramInt1, paramInt2, paramInt3) / 1000L;
    if (!PublishHomeWorkFragment.a(this.a, l))
    {
      bbwn.a(this.a.a, (bbwn)this.a.a.a());
      return;
    }
    this.a.c = l;
    this.a.a.b();
    this.a.b.setRightText(this.a.a(l));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbvk
 * JD-Core Version:    0.7.0.1
 */