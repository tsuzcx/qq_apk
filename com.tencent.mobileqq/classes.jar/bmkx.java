import android.graphics.PointF;
import com.tencent.mobileqq.widget.QQToast;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleView;

public class bmkx
  implements bmqc
{
  public bmkx(bmkv parambmkv) {}
  
  public void a(int paramInt)
  {
    QQToast.a(bmkv.a(this.a), "最多可以圈10个好友哦", 0).a();
  }
  
  public void a(bmqb parambmqb)
  {
    if (parambmqb.a == 0)
    {
      f1 = parambmqb.b.x;
      f2 = parambmqb.s;
      f3 = -parambmqb.u;
      if (f1 + f2 + f3 >= parambmqb.u / 2.0F)
      {
        bmkv.a(this.a).a(1, f3 + parambmqb.s);
        return;
      }
      wxe.c("Q.qqstory.publish.edit.EditVideoAtDoodleController", "at label can not be reversed because it will be beyond layer.");
      return;
    }
    float f1 = parambmqb.b.x;
    float f2 = parambmqb.s;
    float f3 = parambmqb.u;
    if (f1 + f2 + f3 <= bmkv.a(this.a).getWidth() - parambmqb.u / 2.0F)
    {
      bmkv.a(this.a).a(0, f3 + parambmqb.s);
      return;
    }
    wxe.c("Q.qqstory.publish.edit.EditVideoAtDoodleController", "at label can not be reversed because it will be beyond layer.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmkx
 * JD-Core Version:    0.7.0.1
 */