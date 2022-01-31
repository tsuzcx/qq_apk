import android.graphics.PointF;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleView;

public class bjuk
  implements bjzp
{
  public bjuk(bjui parambjui) {}
  
  public void a(int paramInt)
  {
    bcpw.a(bjui.a(this.a), "最多可以圈10个好友哦", 0).a();
  }
  
  public void a(bjzo parambjzo)
  {
    if (parambjzo.a == 0)
    {
      f1 = parambjzo.b.x;
      f2 = parambjzo.s;
      f3 = -parambjzo.u;
      if (f1 + f2 + f3 >= parambjzo.u / 2.0F)
      {
        bjui.a(this.a).a(1, f3 + parambjzo.s);
        return;
      }
      veg.c("Q.qqstory.publish.edit.EditVideoAtDoodleController", "at label can not be reversed because it will be beyond layer.");
      return;
    }
    float f1 = parambjzo.b.x;
    float f2 = parambjzo.s;
    float f3 = parambjzo.u;
    if (f1 + f2 + f3 <= bjui.a(this.a).getWidth() - parambjzo.u / 2.0F)
    {
      bjui.a(this.a).a(0, f3 + parambjzo.s);
      return;
    }
    veg.c("Q.qqstory.publish.edit.EditVideoAtDoodleController", "at label can not be reversed because it will be beyond layer.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjuk
 * JD-Core Version:    0.7.0.1
 */