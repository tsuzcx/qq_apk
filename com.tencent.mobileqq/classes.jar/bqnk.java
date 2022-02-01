import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleView;
import java.util.ArrayList;
import java.util.List;

public class bqnk
  implements bqkm
{
  ArrayList<bqkj> a = null;
  
  public bqnk(bqkj... paramVarArgs)
  {
    if ((paramVarArgs == null) || (paramVarArgs.length <= 0)) {
      throw new IllegalArgumentException("layers should not be null or empty");
    }
    this.a = new ArrayList(paramVarArgs.length);
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      bqkj localbqkj = paramVarArgs[i];
      if (localbqkj != null) {
        this.a.add(localbqkj);
      }
      i += 1;
    }
  }
  
  public bqkj a(String paramString)
  {
    int j = this.a.size();
    int i = 0;
    while (i < j)
    {
      if (((bqkj)this.a.get(i)).a().equals(paramString)) {
        return (bqkj)this.a.get(i);
      }
      i += 1;
    }
    return null;
  }
  
  public void a(List<bqkj> paramList, DoodleView paramDoodleView)
  {
    paramList.addAll(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bqnk
 * JD-Core Version:    0.7.0.1
 */