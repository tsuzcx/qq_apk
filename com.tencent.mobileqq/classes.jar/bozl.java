import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleView;
import java.util.ArrayList;
import java.util.List;

public class bozl
  implements bowq
{
  ArrayList<bown> a = null;
  
  public bozl(bown... paramVarArgs)
  {
    if ((paramVarArgs == null) || (paramVarArgs.length <= 0)) {
      throw new IllegalArgumentException("layers should not be null or empty");
    }
    this.a = new ArrayList(paramVarArgs.length);
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      bown localbown = paramVarArgs[i];
      if (localbown != null) {
        this.a.add(localbown);
      }
      i += 1;
    }
  }
  
  public bown a(String paramString)
  {
    int j = this.a.size();
    int i = 0;
    while (i < j)
    {
      if (((bown)this.a.get(i)).a().equals(paramString)) {
        return (bown)this.a.get(i);
      }
      i += 1;
    }
    return null;
  }
  
  public void a(List<bown> paramList, DoodleView paramDoodleView)
  {
    paramList.addAll(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bozl
 * JD-Core Version:    0.7.0.1
 */