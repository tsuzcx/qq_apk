import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleView;
import java.util.ArrayList;
import java.util.List;

public class binb
  implements bikd
{
  ArrayList<bika> a = null;
  
  public binb(bika... paramVarArgs)
  {
    if ((paramVarArgs == null) || (paramVarArgs.length <= 0)) {
      throw new IllegalArgumentException("layers should not be null or empty");
    }
    this.a = new ArrayList(paramVarArgs.length);
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      bika localbika = paramVarArgs[i];
      if (localbika != null) {
        this.a.add(localbika);
      }
      i += 1;
    }
  }
  
  public bika a(String paramString)
  {
    int j = this.a.size();
    int i = 0;
    while (i < j)
    {
      if (((bika)this.a.get(i)).a().equals(paramString)) {
        return (bika)this.a.get(i);
      }
      i += 1;
    }
    return null;
  }
  
  public void a(List<bika> paramList, DoodleView paramDoodleView)
  {
    paramList.addAll(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     binb
 * JD-Core Version:    0.7.0.1
 */