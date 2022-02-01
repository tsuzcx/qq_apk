import com.tencent.mobileqq.data.TroopInfo;
import java.util.ArrayList;

public class bqvx
{
  TroopInfo a;
  public boolean a;
  
  public bqvx(boolean paramBoolean, TroopInfo paramTroopInfo)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo = paramTroopInfo;
  }
  
  public static ArrayList<bqvx> a(ArrayList<TroopInfo> paramArrayList, ArrayList<String> paramArrayList1)
  {
    ArrayList localArrayList = new ArrayList(paramArrayList.size());
    int i = 0;
    while (i < paramArrayList.size())
    {
      TroopInfo localTroopInfo = (TroopInfo)paramArrayList.get(i);
      bqvx localbqvx = new bqvx(false, localTroopInfo);
      if ((paramArrayList1 != null) && (paramArrayList1.contains(localTroopInfo.troopuin))) {
        localbqvx.jdField_a_of_type_Boolean = true;
      }
      localArrayList.add(localbqvx);
      i += 1;
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bqvx
 * JD-Core Version:    0.7.0.1
 */