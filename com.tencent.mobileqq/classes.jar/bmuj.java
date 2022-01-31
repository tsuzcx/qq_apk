import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleView;
import java.util.ArrayList;
import java.util.List;

public class bmuj
  implements bmrl
{
  ArrayList<bmri> a = null;
  
  public bmuj(bmri... paramVarArgs)
  {
    if ((paramVarArgs == null) || (paramVarArgs.length <= 0)) {
      throw new IllegalArgumentException("layers should not be null or empty");
    }
    this.a = new ArrayList(paramVarArgs.length);
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      bmri localbmri = paramVarArgs[i];
      if (localbmri != null) {
        this.a.add(localbmri);
      }
      i += 1;
    }
  }
  
  public bmri a(String paramString)
  {
    int j = this.a.size();
    int i = 0;
    while (i < j)
    {
      if (((bmri)this.a.get(i)).a().equals(paramString)) {
        return (bmri)this.a.get(i);
      }
      i += 1;
    }
    return null;
  }
  
  public void a(List<bmri> paramList, DoodleView paramDoodleView)
  {
    paramList.addAll(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmuj
 * JD-Core Version:    0.7.0.1
 */