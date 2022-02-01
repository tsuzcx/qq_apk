import com.tencent.mobileqq.troop.createNewTroop.RelationTroopEntity;
import java.util.ArrayList;

class bfhb
  implements bfxz
{
  bfhb(bfgz parambfgz, bfhh parambfhh) {}
  
  public void a(ArrayList<bfxy> paramArrayList)
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramArrayList.size())
    {
      RelationTroopEntity localRelationTroopEntity = new RelationTroopEntity();
      localRelationTroopEntity.troopInfo = ((bfxy)paramArrayList.get(i)).a;
      localArrayList.add(localRelationTroopEntity);
      i += 1;
    }
    this.jdField_a_of_type_Bfhh.a(localArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfhb
 * JD-Core Version:    0.7.0.1
 */