import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;

class asvh
  implements anui
{
  asvh(asvg paramasvg, String paramString, int paramInt1, int paramInt2) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramBoolean)
    {
      paramObject = (anyw)this.jdField_a_of_type_Asvg.app.getManager(51);
      Card localCard = paramObject.c(this.jdField_a_of_type_JavaLangString);
      localCard.clothesId = this.jdField_a_of_type_Int;
      localCard.fontId = this.b;
      localCard.updateTime = NetConnInfoCenter.getServerTimeMillis();
      paramObject.a(localCard);
      this.jdField_a_of_type_Asvg.notifyUI(1, paramBoolean, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asvh
 * JD-Core Version:    0.7.0.1
 */