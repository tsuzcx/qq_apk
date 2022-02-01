import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.businessCard.data.BusinessCard;
import com.tencent.mobileqq.profilesetting.ProfileCardMoreActivity;
import com.tencent.qphone.base.util.QLog;

public class bagl
  extends aqjn
{
  public bagl(ProfileCardMoreActivity paramProfileCardMoreActivity) {}
  
  public void a(boolean paramBoolean, String paramString)
  {
    super.a(paramBoolean, paramString);
  }
  
  public void a(boolean paramBoolean, String paramString, int paramInt)
  {
    super.a(paramBoolean, paramString, paramInt);
    if (paramBoolean)
    {
      BusinessCard localBusinessCard = ((aqjm)this.a.app.getManager(QQManagerFactory.BUSINESS_CARD_MANAGER)).a(paramString);
      QLog.i("BusinessCard_observer_ProfileCardMoreActivity", 4, "onGetCardInfo success : cardId = " + paramString);
      this.a.a(localBusinessCard);
      this.a.a = localBusinessCard;
      return;
    }
    QLog.e("BusinessCard_observer_ProfileCardMoreActivity", 4, "onGetCardInfo faild : cardId = " + paramString);
  }
  
  public void b(boolean paramBoolean, String paramString)
  {
    super.b(paramBoolean, paramString);
  }
  
  public void b(boolean paramBoolean, String paramString, int paramInt)
  {
    super.b(paramBoolean, paramString, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bagl
 * JD-Core Version:    0.7.0.1
 */