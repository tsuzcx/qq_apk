import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class bgbn
  extends bgax
{
  aofu jdField_a_of_type_Aofu;
  private bgav jdField_a_of_type_Bgav;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private String jdField_a_of_type_JavaLangString;
  
  public bgbn(BaseChatPie paramBaseChatPie, bgav parambgav)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramBaseChatPie.app;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_Bgav = parambgav;
    try
    {
      this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.sessionInfo.curFriendUin;
      this.jdField_a_of_type_Aofu = new bgbo(this);
      return;
    }
    catch (Exception paramBaseChatPie)
    {
      for (;;)
      {
        QLog.e("FansBeatRankProcessor", 2, "mTroopUin init error: ", paramBaseChatPie);
      }
    }
  }
  
  private void a(ArrayList<bgba> paramArrayList)
  {
    if (this.jdField_a_of_type_Bgav != null) {
      this.jdField_a_of_type_Bgav.a(4, paramArrayList);
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      a(null);
      return;
    }
    bgbp localbgbp = new bgbp();
    localbgbp.b("https://static-res.qq.com/static-res/clivia/heart_icon.png");
    localbgbp.a("打榜");
    localbgbp.a(0);
    localbgbp.a(false);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(localbgbp);
    a(localArrayList);
    bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800B584", "0X800B584", 0, 0, "", "", "", "");
  }
  
  private void e()
  {
    TroopInfo localTroopInfo = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).c(this.jdField_a_of_type_JavaLangString);
    if ((localTroopInfo != null) && (localTroopInfo.isFansTroop()))
    {
      if (localTroopInfo.getFansTroopStarId() != 0) {}
      for (boolean bool = true;; bool = false)
      {
        a(bool);
        return;
      }
    }
    a(false);
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Aofu);
  }
  
  public void a(Object paramObject)
  {
    if ((paramObject instanceof bgbp))
    {
      if (QLog.isColorLevel()) {
        QLog.i("FansBeatRankProcessor", 2, "onClick");
      }
      if (!bdvn.a()) {
        break label44;
      }
      QQToast.a(BaseApplicationImpl.sApplication, anvx.a(2131699085), 0).a();
    }
    label44:
    do
    {
      return;
      bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800B585", "0X800B585", 0, 0, "", "", "", "");
      paramObject = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).c(this.jdField_a_of_type_JavaLangString);
      if (paramObject != null)
      {
        bghc.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mContext, this.jdField_a_of_type_JavaLangString, paramObject.getFansTroopStarId());
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.i("FansBeatRankProcessor", 2, "onClick: TroopInfo null");
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Aofu);
  }
  
  public void b(Object paramObject) {}
  
  public void c() {}
  
  public void d()
  {
    e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgbn
 * JD-Core Version:    0.7.0.1
 */