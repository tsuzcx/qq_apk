import com.tencent.mobileqq.troop.essencemsg.TroopEssenceMsgItem;

public class bflb
{
  public int a;
  public TroopEssenceMsgItem a;
  public String a;
  public String b;
  
  public bflb(TroopEssenceMsgItem paramTroopEssenceMsgItem, int paramInt, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopEssencemsgTroopEssenceMsgItem = paramTroopEssenceMsgItem;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    StringBuilder localStringBuilder2 = localStringBuilder1.append("msgItem:");
    if (this.jdField_a_of_type_ComTencentMobileqqTroopEssencemsgTroopEssenceMsgItem != null) {}
    for (String str = this.jdField_a_of_type_ComTencentMobileqqTroopEssencemsgTroopEssenceMsgItem.toString();; str = "null")
    {
      localStringBuilder2.append(str).append(" ");
      localStringBuilder1.append("graytipmsgseq:").append(this.jdField_a_of_type_Int).append(" ");
      localStringBuilder1.append("opNickName:").append(this.jdField_a_of_type_JavaLangString).append(" ");
      localStringBuilder1.append("senderNickName:").append(this.b);
      return localStringBuilder1.toString();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bflb
 * JD-Core Version:    0.7.0.1
 */