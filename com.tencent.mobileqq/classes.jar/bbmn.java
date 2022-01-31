import com.tencent.mobileqq.troop.createNewTroop.RelationTroopEntity;
import java.util.ArrayList;

class bbmn
  implements bccr
{
  bbmn(bbml parambbml, bbmt parambbmt) {}
  
  public void a(ArrayList<bccq> paramArrayList)
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramArrayList.size())
    {
      RelationTroopEntity localRelationTroopEntity = new RelationTroopEntity();
      localRelationTroopEntity.troopInfo = ((bccq)paramArrayList.get(i)).a;
      localArrayList.add(localRelationTroopEntity);
      i += 1;
    }
    this.jdField_a_of_type_Bbmt.a(localArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbmn
 * JD-Core Version:    0.7.0.1
 */