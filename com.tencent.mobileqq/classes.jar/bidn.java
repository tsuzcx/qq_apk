import android.graphics.PointF;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleView;

public class bidn
  implements biiu
{
  public bidn(bidl parambidl) {}
  
  public void a(int paramInt)
  {
    bbmy.a(bidl.a(this.a), "最多可以圈10个好友哦", 0).a();
  }
  
  public void a(biit parambiit)
  {
    if (parambiit.a == 0)
    {
      f1 = parambiit.b.x;
      f2 = parambiit.s;
      f3 = -parambiit.u;
      if (f1 + f2 + f3 >= parambiit.u / 2.0F)
      {
        bidl.a(this.a).a(1, f3 + parambiit.s);
        return;
      }
      urk.c("Q.qqstory.publish.edit.EditVideoAtDoodleController", "at label can not be reversed because it will be beyond layer.");
      return;
    }
    float f1 = parambiit.b.x;
    float f2 = parambiit.s;
    float f3 = parambiit.u;
    if (f1 + f2 + f3 <= bidl.a(this.a).getWidth() - parambiit.u / 2.0F)
    {
      bidl.a(this.a).a(0, f3 + parambiit.s);
      return;
    }
    urk.c("Q.qqstory.publish.edit.EditVideoAtDoodleController", "at label can not be reversed because it will be beyond layer.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bidn
 * JD-Core Version:    0.7.0.1
 */