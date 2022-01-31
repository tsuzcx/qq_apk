import com.tencent.mobileqq.data.CardProfile;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class awzs
{
  public static ArrayList<CardProfile> a(List<CardProfile> paramList1, List<CardProfile> paramList2)
  {
    HashSet localHashSet = new HashSet();
    ArrayList localArrayList = new ArrayList();
    paramList1 = paramList1.iterator();
    paramList2 = paramList2.iterator();
    while (paramList1.hasNext())
    {
      CardProfile localCardProfile = (CardProfile)paramList1.next();
      localHashSet.add(Long.valueOf(localCardProfile.lEctID));
      localArrayList.add(localCardProfile);
    }
    while (paramList2.hasNext())
    {
      paramList1 = (CardProfile)paramList2.next();
      if (!localHashSet.contains(Long.valueOf(paramList1.lEctID))) {
        localArrayList.add(paramList1);
      }
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awzs
 * JD-Core Version:    0.7.0.1
 */