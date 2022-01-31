import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleView;
import java.util.ArrayList;
import java.util.List;

public class bkdw
  implements bkay
{
  ArrayList<bkav> a = null;
  
  public bkdw(bkav... paramVarArgs)
  {
    if ((paramVarArgs == null) || (paramVarArgs.length <= 0)) {
      throw new IllegalArgumentException("layers should not be null or empty");
    }
    this.a = new ArrayList(paramVarArgs.length);
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      bkav localbkav = paramVarArgs[i];
      if (localbkav != null) {
        this.a.add(localbkav);
      }
      i += 1;
    }
  }
  
  public bkav a(String paramString)
  {
    int j = this.a.size();
    int i = 0;
    while (i < j)
    {
      if (((bkav)this.a.get(i)).a().equals(paramString)) {
        return (bkav)this.a.get(i);
      }
      i += 1;
    }
    return null;
  }
  
  public void a(List<bkav> paramList, DoodleView paramDoodleView)
  {
    paramList.addAll(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bkdw
 * JD-Core Version:    0.7.0.1
 */