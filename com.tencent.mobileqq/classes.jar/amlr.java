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

public class amlr
  extends alve
{
  public int a;
  private WeakReference<amli> a;
  
  public amlr(amli paramamli)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramamli);
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
    amli localamli = (amli)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localamli == null)
    {
      QLog.e("ApolloGameViewBinder", 1, "[onQueryVirtualRoomInfo] viewBinder null");
      return;
    }
    if (localamli.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)
    {
      QLog.e("ApolloGameViewBinder", 1, "[onQueryVirtualRoomInfo] viewBinder app null");
      return;
    }
    ApolloGameData localApolloGameData = ((amir)localamli.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(155)).a(paramInt1);
    if (localApolloGameData == null)
    {
      QLog.e("ApolloGameViewBinder", 1, "[onQueryVirtualRoomInfo] gameData null");
      return;
    }
    if (paramLong == 0L)
    {
      aluz.a(localamli.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1, paramString2);
      return;
    }
    if (paramLong == -300404L)
    {
      amli.a(localamli).post(new ApolloGameViewBinder.ISessionHandler.1(this, localamli, localApolloGameData));
      return;
    }
    if (paramLong == -300405L)
    {
      amli.a(localamli).post(new ApolloGameViewBinder.ISessionHandler.2(this, localamli, localApolloGameData));
      return;
    }
    QLog.e("ApolloGameViewBinder", 1, new Object[] { "[onQueryVirtualRoomInfo] errCode=", Long.valueOf(paramLong) });
    amli.a(localamli).post(new ApolloGameViewBinder.ISessionHandler.3(this, localamli));
  }
  
  public void a(boolean paramBoolean, int paramInt1, long paramLong, int paramInt2)
  {
    amli localamli = (amli)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localamli == null) {
      break label17;
    }
    label17:
    while (localamli.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
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
    ammz localammz = new ammz();
    Object localObject = (amir)localamli.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(155);
    String str = amtj.a(2131699495);
    ApolloGameData localApolloGameData = ((amir)localObject).a(paramInt1);
    if ((localApolloGameData != null) && (!TextUtils.isEmpty(localApolloGameData.name)))
    {
      localObject = ((amir)localObject).a(localApolloGameData.actionId);
      if (localObject == null) {
        break label296;
      }
      str = ((ApolloActionData)localObject).actionName;
    }
    label296:
    for (;;)
    {
      paramInt2 = localApolloGameData.actionId;
      localammz.jdField_b_of_type_JavaLangString = localApolloGameData.name;
      for (;;)
      {
        localammz.jdField_a_of_type_JavaLangString = str;
        localammz.jdField_b_of_type_Int = paramInt2;
        localammz.jdField_a_of_type_Long = paramLong;
        localammz.jdField_a_of_type_Int = paramInt1;
        localammz.d = 3;
        localammz.e = 0;
        if ((localamli.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (localamli.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null)) {
          break;
        }
        aluz.a(localamli.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localamli.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, localammz);
        if (!alvm.a(localamli.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin)) {
          break;
        }
        ((alnr)localamli.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(153)).a().b(localamli.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, paramInt1, paramLong);
        return;
        localammz.jdField_b_of_type_JavaLangString = amtj.a(2131699535);
        paramInt2 = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amlr
 * JD-Core Version:    0.7.0.1
 */