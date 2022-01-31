import android.os.Handler;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoFilterNeo.1.1;

public class biey
  implements spg<sqx>
{
  public void a(boolean paramBoolean, sqx paramsqx)
  {
    urk.b("Q.qqstory.publish.edit.EditVideoFilterNeo", "onWeatherUpdate, isSuccess=" + paramBoolean);
    if ((paramBoolean) && (paramsqx != null))
    {
      urk.a("Q.qqstory.publish.edit.EditVideoFilterNeo", "onWeatherUpdate, temperature=%s", Integer.valueOf(paramsqx.a));
      int i = paramsqx.a;
      biex.a(this.a).post(new EditVideoFilterNeo.1.1(this, i));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     biey
 * JD-Core Version:    0.7.0.1
 */