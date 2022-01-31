import android.graphics.PointF;
import com.tencent.mobileqq.widget.QQToast;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleView;

public class bmgl
  implements bmlq
{
  public bmgl(bmgj parambmgj) {}
  
  public void a(int paramInt)
  {
    QQToast.a(bmgj.a(this.a), "最多可以圈10个好友哦", 0).a();
  }
  
  public void a(bmlp parambmlp)
  {
    if (parambmlp.a == 0)
    {
      f1 = parambmlp.b.x;
      f2 = parambmlp.s;
      f3 = -parambmlp.u;
      if (f1 + f2 + f3 >= parambmlp.u / 2.0F)
      {
        bmgj.a(this.a).a(1, f3 + parambmlp.s);
        return;
      }
      wsv.c("Q.qqstory.publish.edit.EditVideoAtDoodleController", "at label can not be reversed because it will be beyond layer.");
      return;
    }
    float f1 = parambmlp.b.x;
    float f2 = parambmlp.s;
    float f3 = parambmlp.u;
    if (f1 + f2 + f3 <= bmgj.a(this.a).getWidth() - parambmlp.u / 2.0F)
    {
      bmgj.a(this.a).a(0, f3 + parambmlp.s);
      return;
    }
    wsv.c("Q.qqstory.publish.edit.EditVideoAtDoodleController", "at label can not be reversed because it will be beyond layer.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmgl
 * JD-Core Version:    0.7.0.1
 */