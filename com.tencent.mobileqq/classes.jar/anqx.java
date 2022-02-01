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

public class anqx
  extends anak
{
  public int a;
  private WeakReference<anqo> a;
  
  public anqx(anqo paramanqo)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramanqo);
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
    anqo localanqo = (anqo)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localanqo == null)
    {
      QLog.e("ApolloGameViewBinder", 1, "[onQueryVirtualRoomInfo] viewBinder null");
      return;
    }
    if (localanqo.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)
    {
      QLog.e("ApolloGameViewBinder", 1, "[onQueryVirtualRoomInfo] viewBinder app null");
      return;
    }
    ApolloGameData localApolloGameData = ((annx)localanqo.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(155)).a(paramInt1);
    if (localApolloGameData == null)
    {
      QLog.e("ApolloGameViewBinder", 1, "[onQueryVirtualRoomInfo] gameData null");
      return;
    }
    if (paramLong == 0L)
    {
      anaf.a(localanqo.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1, paramString2);
      return;
    }
    if (paramLong == -300404L)
    {
      anqo.a(localanqo).post(new ApolloGameViewBinder.ISessionHandler.1(this, localanqo, localApolloGameData));
      return;
    }
    if (paramLong == -300405L)
    {
      anqo.a(localanqo).post(new ApolloGameViewBinder.ISessionHandler.2(this, localanqo, localApolloGameData));
      return;
    }
    QLog.e("ApolloGameViewBinder", 1, new Object[] { "[onQueryVirtualRoomInfo] errCode=", Long.valueOf(paramLong) });
    anqo.a(localanqo).post(new ApolloGameViewBinder.ISessionHandler.3(this, localanqo));
  }
  
  public void a(boolean paramBoolean, int paramInt1, long paramLong, int paramInt2)
  {
    anqo localanqo = (anqo)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localanqo == null) {
      break label17;
    }
    label17:
    while (localanqo.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
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
    ansi localansi = new ansi();
    Object localObject = (annx)localanqo.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(155);
    String str = anzj.a(2131699260);
    ApolloGameData localApolloGameData = ((annx)localObject).a(paramInt1);
    if ((localApolloGameData != null) && (!TextUtils.isEmpty(localApolloGameData.name)))
    {
      localObject = ((annx)localObject).a(localApolloGameData.actionId);
      if (localObject == null) {
        break label296;
      }
      str = ((ApolloActionData)localObject).actionName;
    }
    label296:
    for (;;)
    {
      paramInt2 = localApolloGameData.actionId;
      localansi.jdField_b_of_type_JavaLangString = localApolloGameData.name;
      for (;;)
      {
        localansi.jdField_a_of_type_JavaLangString = str;
        localansi.jdField_b_of_type_Int = paramInt2;
        localansi.jdField_a_of_type_Long = paramLong;
        localansi.jdField_a_of_type_Int = paramInt1;
        localansi.d = 3;
        localansi.e = 0;
        if ((localanqo.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (localanqo.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null)) {
          break;
        }
        anaf.a(localanqo.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localanqo.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, localansi);
        if (!anas.a(localanqo.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
          break;
        }
        ((amsx)localanqo.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(153)).a().b(localanqo.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramInt1, paramLong);
        return;
        localansi.jdField_b_of_type_JavaLangString = anzj.a(2131699300);
        paramInt2 = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anqx
 * JD-Core Version:    0.7.0.1
 */