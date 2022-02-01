import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.apollo.view.pannel.viewbinder.ApolloGameViewBinder.ISessionHandler.1;
import com.tencent.mobileqq.apollo.view.pannel.viewbinder.ApolloGameViewBinder.ISessionHandler.2;
import com.tencent.mobileqq.apollo.view.pannel.viewbinder.ApolloGameViewBinder.ISessionHandler.3;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.ApolloActionData;
import com.tencent.mobileqq.data.ApolloGameData;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class anqd
  extends amug
{
  public int a;
  private WeakReference<anpu> a;
  
  public anqd(anpu paramanpu)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramanpu);
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
    anpu localanpu = (anpu)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localanpu == null)
    {
      QLog.e("ApolloGameViewBinder", 1, "[onQueryVirtualRoomInfo] viewBinder null");
      return;
    }
    if (localanpu.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)
    {
      QLog.e("ApolloGameViewBinder", 1, "[onQueryVirtualRoomInfo] viewBinder app null");
      return;
    }
    ApolloGameData localApolloGameData = ((ankc)localanpu.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.APOOLO_DAO_MANAGER)).a(paramInt1);
    if (localApolloGameData == null)
    {
      QLog.e("ApolloGameViewBinder", 1, "[onQueryVirtualRoomInfo] gameData null");
      return;
    }
    if (paramLong == 0L)
    {
      amub.a(localanpu.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1, paramString2);
      return;
    }
    if (paramLong == -300404L)
    {
      anpu.a(localanpu).post(new ApolloGameViewBinder.ISessionHandler.1(this, localanpu, localApolloGameData));
      return;
    }
    if (paramLong == -300405L)
    {
      anpu.a(localanpu).post(new ApolloGameViewBinder.ISessionHandler.2(this, localanpu, localApolloGameData));
      return;
    }
    QLog.e("ApolloGameViewBinder", 1, new Object[] { "[onQueryVirtualRoomInfo] errCode=", Long.valueOf(paramLong) });
    anpu.a(localanpu).post(new ApolloGameViewBinder.ISessionHandler.3(this, localanpu));
  }
  
  public void a(boolean paramBoolean, int paramInt1, long paramLong, int paramInt2)
  {
    anpu localanpu = (anpu)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localanpu == null) {
      break label17;
    }
    label17:
    while (localanpu.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
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
    amri localamri = new amri();
    Object localObject = (ankc)localanpu.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.APOOLO_DAO_MANAGER);
    String str = anvx.a(2131699846);
    ApolloGameData localApolloGameData = ((ankc)localObject).a(paramInt1);
    if ((localApolloGameData != null) && (!TextUtils.isEmpty(localApolloGameData.name)))
    {
      localObject = ((ankc)localObject).a(localApolloGameData.actionId);
      if (localObject == null) {
        break label296;
      }
      str = ((ApolloActionData)localObject).actionName;
    }
    label296:
    for (;;)
    {
      paramInt2 = localApolloGameData.actionId;
      localamri.jdField_b_of_type_JavaLangString = localApolloGameData.name;
      for (;;)
      {
        localamri.jdField_a_of_type_JavaLangString = str;
        localamri.jdField_b_of_type_Int = paramInt2;
        localamri.jdField_a_of_type_Long = paramLong;
        localamri.jdField_a_of_type_Int = paramInt1;
        localamri.d = 3;
        localamri.e = 0;
        if ((localanpu.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (localanpu.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null)) {
          break;
        }
        amub.a(localanpu.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localanpu.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, localamri);
        if (!amuo.a(localanpu.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin)) {
          break;
        }
        ((amme)localanpu.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.APOLLO_MANAGER)).a().b(localanpu.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, paramInt1, paramLong);
        return;
        localamri.jdField_b_of_type_JavaLangString = anvx.a(2131699886);
        paramInt2 = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anqd
 * JD-Core Version:    0.7.0.1
 */