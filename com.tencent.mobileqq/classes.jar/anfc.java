import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.apollo.view.ApolloGameViewBinder.ISessionHandler.1;
import com.tencent.mobileqq.apollo.view.ApolloGameViewBinder.ISessionHandler.2;
import com.tencent.mobileqq.apollo.view.ApolloGameViewBinder.ISessionHandler.3;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ApolloActionData;
import com.tencent.mobileqq.data.ApolloGameData;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class anfc
  extends amoq
{
  public int a;
  private WeakReference<anet> a;
  
  public anfc(anet paramanet)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramanet);
  }
  
  public void a(int paramInt1, String paramString1, long paramLong, String paramString2, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloGameViewBinder", 2, new Object[] { "[onQueryVirtualRoomInfo] errCode=", Long.valueOf(paramLong), ", gameId=", Integer.valueOf(paramInt1), ", resultStr=", paramString2 });
    }
    if (this.jdField_a_of_type_Int != paramInt2)
    {
      QLog.e("ApolloGameViewBinder", 1, "[onQueryVirtualRoomInfo] mCreateRoomReqCode != reqCode");
      return;
    }
    anet localanet = (anet)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localanet == null)
    {
      QLog.e("ApolloGameViewBinder", 1, "[onQueryVirtualRoomInfo] viewBinder null");
      return;
    }
    if (localanet.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)
    {
      QLog.e("ApolloGameViewBinder", 1, "[onQueryVirtualRoomInfo] viewBinder app null");
      return;
    }
    ApolloGameData localApolloGameData = ((ancd)localanet.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(155)).a(paramInt1);
    if (localApolloGameData == null)
    {
      QLog.e("ApolloGameViewBinder", 1, "[onQueryVirtualRoomInfo] gameData null");
      return;
    }
    if (paramLong == 0L)
    {
      amol.a(localanet.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1, paramString2);
      return;
    }
    if (paramLong == -300404L)
    {
      anet.a(localanet).post(new ApolloGameViewBinder.ISessionHandler.1(this, localanet, localApolloGameData));
      return;
    }
    if (paramLong == -300405L)
    {
      anet.a(localanet).post(new ApolloGameViewBinder.ISessionHandler.2(this, localanet, localApolloGameData));
      return;
    }
    QLog.e("ApolloGameViewBinder", 1, new Object[] { "[onQueryVirtualRoomInfo] errCode=", Long.valueOf(paramLong) });
    anet.a(localanet).post(new ApolloGameViewBinder.ISessionHandler.3(this, localanet));
  }
  
  public void a(boolean paramBoolean, int paramInt1, long paramLong, int paramInt2)
  {
    anet localanet = (anet)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localanet == null) {
      break label17;
    }
    label17:
    while (localanet.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return;
    }
    if (this.jdField_a_of_type_Int != paramInt2)
    {
      QLog.e("ApolloGameViewBinder", 1, "onCreateRoomId mCreateRoomReqCode != reqCode");
      return;
    }
    if (!paramBoolean)
    {
      QLog.e("ApolloGameViewBinder", 1, "onCreateRoomId createSuccess:false");
      return;
    }
    super.a(paramBoolean, paramInt1, paramLong, paramInt2);
    angn localangn = new angn();
    Object localObject = (ancd)localanet.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(155);
    String str = anni.a(2131699153);
    ApolloGameData localApolloGameData = ((ancd)localObject).a(paramInt1);
    if ((localApolloGameData != null) && (!TextUtils.isEmpty(localApolloGameData.name)))
    {
      localObject = ((ancd)localObject).a(localApolloGameData.actionId);
      if (localObject == null) {
        break label296;
      }
      str = ((ApolloActionData)localObject).actionName;
    }
    label296:
    for (;;)
    {
      paramInt2 = localApolloGameData.actionId;
      localangn.jdField_b_of_type_JavaLangString = localApolloGameData.name;
      for (;;)
      {
        localangn.jdField_a_of_type_JavaLangString = str;
        localangn.jdField_b_of_type_Int = paramInt2;
        localangn.jdField_a_of_type_Long = paramLong;
        localangn.jdField_a_of_type_Int = paramInt1;
        localangn.d = 3;
        localangn.e = 0;
        if ((localanet.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (localanet.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null)) {
          break;
        }
        amol.a(localanet.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localanet.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, localangn);
        if (!amoy.a(localanet.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
          break;
        }
        ((amhd)localanet.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(153)).a().b(localanet.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramInt1, paramLong);
        return;
        localangn.jdField_b_of_type_JavaLangString = anni.a(2131699193);
        paramInt2 = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anfc
 * JD-Core Version:    0.7.0.1
 */