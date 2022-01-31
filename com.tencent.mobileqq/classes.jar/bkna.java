import com.tencent.mobileqq.data.TroopInfo;
import java.util.ArrayList;

public class bkna
{
  TroopInfo a;
  public boolean a;
  
  public bkna(boolean paramBoolean, TroopInfo paramTroopInfo)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo = paramTroopInfo;
  }
  
  public static ArrayList<bkna> a(ArrayList<TroopInfo> paramArrayList, ArrayList<String> paramArrayList1)
  {
    ArrayList localArrayList = new ArrayList(paramArrayList.size());
    int i = 0;
    while (i < paramArrayList.size())
    {
      TroopInfo localTroopInfo = (TroopInfo)paramArrayList.get(i);
      bkna localbkna = new bkna(false, localTroopInfo);
      if ((paramArrayList1 != null) && (paramArrayList1.contains(localTroopInfo.troopuin))) {
        localbkna.jdField_a_of_type_Boolean = true;
      }
      localArrayList.add(localbkna);
      i += 1;
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bkna
 * JD-Core Version:    0.7.0.1
 */