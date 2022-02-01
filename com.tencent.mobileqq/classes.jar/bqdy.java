import android.graphics.PointF;
import com.tencent.mobileqq.widget.QQToast;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleView;

public class bqdy
  implements bqjd
{
  public bqdy(bqdw parambqdw) {}
  
  public void a(int paramInt)
  {
    QQToast.a(bqdw.a(this.a), "最多可以圈10个好友哦", 0).a();
  }
  
  public void a(bqjc parambqjc)
  {
    if (parambqjc.a == 0)
    {
      f1 = parambqjc.b.x;
      f2 = parambqjc.s;
      f3 = -parambqjc.u;
      if (f1 + f2 + f3 >= parambqjc.u / 2.0F)
      {
        bqdw.a(this.a).a(1, f3 + parambqjc.s);
        return;
      }
      yuk.c("Q.qqstory.publish.edit.EditVideoAtDoodleController", "at label can not be reversed because it will be beyond layer.");
      return;
    }
    float f1 = parambqjc.b.x;
    float f2 = parambqjc.s;
    float f3 = parambqjc.u;
    if (f1 + f2 + f3 <= bqdw.a(this.a).getWidth() - parambqjc.u / 2.0F)
    {
      bqdw.a(this.a).a(0, f3 + parambqjc.s);
      return;
    }
    yuk.c("Q.qqstory.publish.edit.EditVideoAtDoodleController", "at label can not be reversed because it will be beyond layer.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bqdy
 * JD-Core Version:    0.7.0.1
 */