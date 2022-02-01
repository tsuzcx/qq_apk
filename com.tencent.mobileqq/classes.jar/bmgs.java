import com.tencent.tav.coremedia.CMTime;
import com.tencent.tavcut.session.TAVCutVideoSession;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class bmgs
  extends bmgv
{
  public bmgs(TAVCutVideoSession paramTAVCutVideoSession)
  {
    super(paramTAVCutVideoSession);
  }
  
  protected bmgl a(List<bmgk> paramList)
  {
    bmgw localbmgw = new bmgw();
    ArrayList localArrayList = new ArrayList();
    bmgk localbmgk;
    if ((paramList != null) && (paramList.size() > 0))
    {
      String str = a(paramList);
      paramList = paramList.iterator();
      do
      {
        if (!paramList.hasNext()) {
          break;
        }
        localbmgk = (bmgk)paramList.next();
      } while (!localbmgk.jdField_a_of_type_JavaLangString.equals(str));
    }
    for (paramList = localbmgk.jdField_a_of_type_JavaUtilList;; paramList = localArrayList)
    {
      localbmgw.jdField_a_of_type_JavaUtilList = paramList;
      return localbmgw;
    }
  }
  
  protected List<Long> a()
  {
    ArrayList localArrayList = new ArrayList();
    if ((this.a != null) && (this.a.getDuration() != null))
    {
      long l1 = this.a.getDuration().getTimeUs() / 1000L;
      int i = 3000;
      if (l1 > 30000L) {
        i = 6000;
      }
      int j = 0;
      while ((j <= l1 / i) && (j < 3))
      {
        long l2 = j * i;
        if (l2 < l1) {
          localArrayList.add(Long.valueOf(l2));
        }
        j += 1;
      }
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmgs
 * JD-Core Version:    0.7.0.1
 */