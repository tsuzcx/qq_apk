import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleView;
import java.util.ArrayList;
import java.util.List;

public class bplp
  implements bpir
{
  ArrayList<bpio> a = null;
  
  public bplp(bpio... paramVarArgs)
  {
    if ((paramVarArgs == null) || (paramVarArgs.length <= 0)) {
      throw new IllegalArgumentException("layers should not be null or empty");
    }
    this.a = new ArrayList(paramVarArgs.length);
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      bpio localbpio = paramVarArgs[i];
      if (localbpio != null) {
        this.a.add(localbpio);
      }
      i += 1;
    }
  }
  
  public bpio a(String paramString)
  {
    int j = this.a.size();
    int i = 0;
    while (i < j)
    {
      if (((bpio)this.a.get(i)).a().equals(paramString)) {
        return (bpio)this.a.get(i);
      }
      i += 1;
    }
    return null;
  }
  
  public void a(List<bpio> paramList, DoodleView paramDoodleView)
  {
    paramList.addAll(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bplp
 * JD-Core Version:    0.7.0.1
 */