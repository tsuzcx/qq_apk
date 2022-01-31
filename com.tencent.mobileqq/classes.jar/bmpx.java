import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleView;
import java.util.ArrayList;
import java.util.List;

public class bmpx
  implements bmmz
{
  ArrayList<bmmw> a = null;
  
  public bmpx(bmmw... paramVarArgs)
  {
    if ((paramVarArgs == null) || (paramVarArgs.length <= 0)) {
      throw new IllegalArgumentException("layers should not be null or empty");
    }
    this.a = new ArrayList(paramVarArgs.length);
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      bmmw localbmmw = paramVarArgs[i];
      if (localbmmw != null) {
        this.a.add(localbmmw);
      }
      i += 1;
    }
  }
  
  public bmmw a(String paramString)
  {
    int j = this.a.size();
    int i = 0;
    while (i < j)
    {
      if (((bmmw)this.a.get(i)).a().equals(paramString)) {
        return (bmmw)this.a.get(i);
      }
      i += 1;
    }
    return null;
  }
  
  public void a(List<bmmw> paramList, DoodleView paramDoodleView)
  {
    paramList.addAll(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmpx
 * JD-Core Version:    0.7.0.1
 */