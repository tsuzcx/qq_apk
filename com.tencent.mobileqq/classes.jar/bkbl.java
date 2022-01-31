import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleView;
import java.util.List;

public class bkbl
  implements bkbp
{
  public static final String[] a = { "AtLayer0", "AtLayer1", "AtLayer2", "AtLayer3", "AtLayer4", "AtLayer5" };
  
  public void a(List<bkbm> paramList, DoodleView paramDoodleView)
  {
    int i = 0;
    while (i < a.length)
    {
      paramList.add(new bkae(paramDoodleView, a[i]));
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bkbl
 * JD-Core Version:    0.7.0.1
 */