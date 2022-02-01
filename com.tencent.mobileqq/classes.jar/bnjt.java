import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleView;
import java.util.ArrayList;
import java.util.List;

public class bnjt
  implements bngy
{
  ArrayList<bngv> a = null;
  
  public bnjt(bngv... paramVarArgs)
  {
    if ((paramVarArgs == null) || (paramVarArgs.length <= 0)) {
      throw new IllegalArgumentException("layers should not be null or empty");
    }
    this.a = new ArrayList(paramVarArgs.length);
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      bngv localbngv = paramVarArgs[i];
      if (localbngv != null) {
        this.a.add(localbngv);
      }
      i += 1;
    }
  }
  
  public bngv a(String paramString)
  {
    int j = this.a.size();
    int i = 0;
    while (i < j)
    {
      if (((bngv)this.a.get(i)).a().equals(paramString)) {
        return (bngv)this.a.get(i);
      }
      i += 1;
    }
    return null;
  }
  
  public void a(List<bngv> paramList, DoodleView paramDoodleView)
  {
    paramList.addAll(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnjt
 * JD-Core Version:    0.7.0.1
 */