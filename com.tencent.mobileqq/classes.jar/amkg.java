import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.persistence.Entity;

public class amkg
{
  public int a;
  public DiscussionInfo a;
  public TroopInfo a;
  public int b;
  
  public amkg(int paramInt, DiscussionInfo paramDiscussionInfo)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo = paramDiscussionInfo;
  }
  
  public amkg(int paramInt1, DiscussionInfo paramDiscussionInfo, int paramInt2)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo = paramDiscussionInfo;
    this.b = paramInt2;
  }
  
  public amkg(int paramInt, Entity paramEntity)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo = ((TroopInfo)paramEntity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amkg
 * JD-Core Version:    0.7.0.1
 */