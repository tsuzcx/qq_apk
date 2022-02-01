import com.tencent.tav.coremedia.CMTime;
import com.tencent.tavcut.session.TAVCutVideoSession;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class bnwk
  extends bnwn
{
  public bnwk(TAVCutVideoSession paramTAVCutVideoSession)
  {
    super(paramTAVCutVideoSession);
  }
  
  protected bnwd a(List<bnwc> paramList)
  {
    bnwo localbnwo = new bnwo();
    ArrayList localArrayList = new ArrayList();
    bnwc localbnwc;
    if ((paramList != null) && (paramList.size() > 0))
    {
      String str = a(paramList);
      paramList = paramList.iterator();
      do
      {
        if (!paramList.hasNext()) {
          break;
        }
        localbnwc = (bnwc)paramList.next();
      } while (!localbnwc.jdField_a_of_type_JavaLangString.equals(str));
    }
    for (paramList = localbnwc.jdField_a_of_type_JavaUtilList;; paramList = localArrayList)
    {
      localbnwo.jdField_a_of_type_JavaUtilList = paramList;
      return localbnwo;
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
 * Qualified Name:     bnwk
 * JD-Core Version:    0.7.0.1
 */