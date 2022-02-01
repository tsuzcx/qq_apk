import com.tencent.mobileqq.search.searchengine.GroupSearchEngine;
import java.util.List;

public class bcma
  extends bcmb
{
  public bcma(GroupSearchEngine paramGroupSearchEngine, bcmc parambcmc, String paramString, int paramInt)
  {
    super(paramGroupSearchEngine, parambcmc, paramString, paramInt);
  }
  
  protected bcfq a(List<bcfr> paramList, String paramString)
  {
    return new bcff(paramList, paramString, GroupSearchEngine.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcma
 * JD-Core Version:    0.7.0.1
 */