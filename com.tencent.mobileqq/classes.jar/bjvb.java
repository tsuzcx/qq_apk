import android.graphics.PointF;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleView;

public class bjvb
  implements bkag
{
  public bjvb(bjuz parambjuz) {}
  
  public void a(int paramInt)
  {
    bcql.a(bjuz.a(this.a), "最多可以圈10个好友哦", 0).a();
  }
  
  public void a(bkaf parambkaf)
  {
    if (parambkaf.a == 0)
    {
      f1 = parambkaf.b.x;
      f2 = parambkaf.s;
      f3 = -parambkaf.u;
      if (f1 + f2 + f3 >= parambkaf.u / 2.0F)
      {
        bjuz.a(this.a).a(1, f3 + parambkaf.s);
        return;
      }
      ved.c("Q.qqstory.publish.edit.EditVideoAtDoodleController", "at label can not be reversed because it will be beyond layer.");
      return;
    }
    float f1 = parambkaf.b.x;
    float f2 = parambkaf.s;
    float f3 = parambkaf.u;
    if (f1 + f2 + f3 <= bjuz.a(this.a).getWidth() - parambkaf.u / 2.0F)
    {
      bjuz.a(this.a).a(0, f3 + parambkaf.s);
      return;
    }
    ved.c("Q.qqstory.publish.edit.EditVideoAtDoodleController", "at label can not be reversed because it will be beyond layer.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjvb
 * JD-Core Version:    0.7.0.1
 */