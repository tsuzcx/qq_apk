import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pluspanel.appinfo.PlusPanelAppInfo;
import com.tencent.mobileqq.pluspanel.loader.c2c.C2CPlusPanelAppConfigHelper;
import com.tencent.mobileqq.scribble.ScribbleResMgr;
import java.util.Iterator;
import java.util.List;

public class ayhd
  extends ayhc
{
  private void a(BaseChatPie paramBaseChatPie, List<PlusPanelAppInfo> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        PlusPanelAppInfo localPlusPanelAppInfo = (PlusPanelAppInfo)paramList.next();
        if (localPlusPanelAppInfo.getAppID() == 215)
        {
          if ((alnr.a(paramBaseChatPie.mActivity, Boolean.valueOf(false))) && (alnr.a(paramBaseChatPie.getApp(), "aio", null) > 0)) {
            a(localPlusPanelAppInfo);
          }
        }
        else {
          a(localPlusPanelAppInfo);
        }
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      PlusPanelAppInfo localPlusPanelAppInfo = C2CPlusPanelAppConfigHelper.INSTANCE.getAppInfoByAppID(paramInt2);
      if (localPlusPanelAppInfo != null)
      {
        this.jdField_a_of_type_JavaUtilList.add(localPlusPanelAppInfo);
        return;
      }
    }
    super.a(paramInt1, paramInt2);
  }
  
  void b(BaseChatPie paramBaseChatPie)
  {
    QQAppInterface localQQAppInterface = paramBaseChatPie.app;
    bcef.b(localQQAppInterface, "P_CliOper", "Vip_pay_mywallet", "", "wallet", "transferAIOshow", 0, 0, "", "", "", "");
    this.jdField_a_of_type_Boolean = false;
    List localList = C2CPlusPanelAppConfigHelper.INSTANCE.getC2CAppInfo();
    if (!localList.isEmpty())
    {
      this.jdField_a_of_type_Boolean = true;
      a(paramBaseChatPie, localList);
    }
    do
    {
      return;
      c(paramBaseChatPie.sessionInfo.curType);
      a(paramBaseChatPie.sessionInfo.curType, 201);
      a(paramBaseChatPie.sessionInfo.curType, 202);
      a(paramBaseChatPie.sessionInfo.curType, 203);
      if (augn.a(localQQAppInterface).b()) {
        a(paramBaseChatPie.sessionInfo.curType, 204);
      }
      a(paramBaseChatPie.sessionInfo.curType, 219);
      if ((agxo.a(localQQAppInterface).a()) && (bbyp.b())) {
        a(paramBaseChatPie.sessionInfo.curType, 209);
      }
      a(paramBaseChatPie.sessionInfo.curType, 205);
      a(paramBaseChatPie.sessionInfo.curType, 206);
      a(paramBaseChatPie.sessionInfo.curType, 207);
      if ((agxo.a(localQQAppInterface).a()) && (!bbyp.b())) {
        a(paramBaseChatPie.sessionInfo.curType, 209);
      }
      a(paramBaseChatPie.sessionInfo.curType, 208);
      if (ScribbleResMgr.c(paramBaseChatPie.mContext, localQQAppInterface.getCurrentAccountUin())) {
        a(paramBaseChatPie.sessionInfo.curType, 210);
      }
      a(paramBaseChatPie.sessionInfo.curType, 1000000006);
      a(paramBaseChatPie.sessionInfo.curType, 211);
      a(paramBaseChatPie.sessionInfo.curType, 212);
      a(paramBaseChatPie.sessionInfo.curType, 213);
      if (azux.a()) {
        a(paramBaseChatPie.sessionInfo.curType, 216);
      }
      if (((bcvg)localQQAppInterface.getManager(283)).a().booleanValue())
      {
        a(paramBaseChatPie.sessionInfo.curType, 214);
        agwt.a(localQQAppInterface, "0X80093F3", paramBaseChatPie.sessionInfo.curType);
      }
      if ((alnr.a(paramBaseChatPie.mContext, Boolean.valueOf(false))) && (alnr.a(localQQAppInterface, "aio", null) > 0)) {
        a(paramBaseChatPie.sessionInfo.curType, 215);
      }
      if (!aoth.jdField_a_of_type_Boolean) {
        a(paramBaseChatPie.sessionInfo.curType, 1000000001);
      }
    } while ((localQQAppInterface.getAccount() == null) || (!localQQAppInterface.getAccount().equals(paramBaseChatPie.sessionInfo.curFriendUin)));
    a(paramBaseChatPie.sessionInfo.curType, 211);
    a(paramBaseChatPie.sessionInfo.curType, 203);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayhd
 * JD-Core Version:    0.7.0.1
 */