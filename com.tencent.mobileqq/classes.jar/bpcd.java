import android.graphics.PointF;
import com.tencent.mobileqq.widget.QQToast;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleView;

public class bpcd
  implements bphi
{
  public bpcd(bpcb parambpcb) {}
  
  public void a(int paramInt)
  {
    QQToast.a(bpcb.a(this.a), "最多可以圈10个好友哦", 0).a();
  }
  
  public void a(bphh parambphh)
  {
    if (parambphh.a == 0)
    {
      f1 = parambphh.b.x;
      f2 = parambphh.s;
      f3 = -parambphh.u;
      if (f1 + f2 + f3 >= parambphh.u / 2.0F)
      {
        bpcb.a(this.a).a(1, f3 + parambphh.s);
        return;
      }
      yqp.c("Q.qqstory.publish.edit.EditVideoAtDoodleController", "at label can not be reversed because it will be beyond layer.");
      return;
    }
    float f1 = parambphh.b.x;
    float f2 = parambphh.s;
    float f3 = parambphh.u;
    if (f1 + f2 + f3 <= bpcb.a(this.a).getWidth() - parambphh.u / 2.0F)
    {
      bpcb.a(this.a).a(0, f3 + parambphh.s);
      return;
    }
    yqp.c("Q.qqstory.publish.edit.EditVideoAtDoodleController", "at label can not be reversed because it will be beyond layer.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpcd
 * JD-Core Version:    0.7.0.1
 */