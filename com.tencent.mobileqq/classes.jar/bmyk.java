import com.tencent.mobileqq.data.TroopInfo;
import java.util.ArrayList;

public class bmyk
{
  TroopInfo a;
  public boolean a;
  
  public bmyk(boolean paramBoolean, TroopInfo paramTroopInfo)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo = paramTroopInfo;
  }
  
  public static ArrayList<bmyk> a(ArrayList<TroopInfo> paramArrayList, ArrayList<String> paramArrayList1)
  {
    ArrayList localArrayList = new ArrayList(paramArrayList.size());
    int i = 0;
    while (i < paramArrayList.size())
    {
      TroopInfo localTroopInfo = (TroopInfo)paramArrayList.get(i);
      bmyk localbmyk = new bmyk(false, localTroopInfo);
      if ((paramArrayList1 != null) && (paramArrayList1.contains(localTroopInfo.troopuin))) {
        localbmyk.jdField_a_of_type_Boolean = true;
      }
      localArrayList.add(localbmyk);
      i += 1;
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmyk
 * JD-Core Version:    0.7.0.1
 */