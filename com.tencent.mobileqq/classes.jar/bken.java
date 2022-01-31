import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleView;
import java.util.ArrayList;
import java.util.List;

public class bken
  implements bkbp
{
  ArrayList<bkbm> a = null;
  
  public bken(bkbm... paramVarArgs)
  {
    if ((paramVarArgs == null) || (paramVarArgs.length <= 0)) {
      throw new IllegalArgumentException("layers should not be null or empty");
    }
    this.a = new ArrayList(paramVarArgs.length);
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      bkbm localbkbm = paramVarArgs[i];
      if (localbkbm != null) {
        this.a.add(localbkbm);
      }
      i += 1;
    }
  }
  
  public bkbm a(String paramString)
  {
    int j = this.a.size();
    int i = 0;
    while (i < j)
    {
      if (((bkbm)this.a.get(i)).a().equals(paramString)) {
        return (bkbm)this.a.get(i);
      }
      i += 1;
    }
    return null;
  }
  
  public void a(List<bkbm> paramList, DoodleView paramDoodleView)
  {
    paramList.addAll(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bken
 * JD-Core Version:    0.7.0.1
 */