import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.apollo.ApolloTextureView;
import com.tencent.mobileqq.apollo.barrage.BarrageView;
import com.tencent.mobileqq.apollo.store.ApolloWebAvatarParam;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class amed
  implements alqv
{
  amed(amec paramamec) {}
  
  public void a(int paramInt1, int paramInt2, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloViewController", 2, new Object[] { "[onCompleteRender] taskId=", Integer.valueOf(paramInt1), ", roleName=", paramString, ", errCode=", Integer.valueOf(paramInt2) });
    }
    if (TextUtils.isEmpty(paramString)) {
      QLog.e("ApolloViewController", 1, "[onCompleteRender] roleName null");
    }
    do
    {
      do
      {
        do
        {
          return;
          if (!amec.a(this.a).containsKey(paramString))
          {
            QLog.e("ApolloViewController", 1, "[onCompleteRender] roleName not showing");
            return;
          }
          if ((amec.a(this.a) == null) || (TextUtils.isEmpty(amec.a(this.a).apolloId)) || (!amec.a(this.a).apolloId.equals(paramString))) {
            break;
          }
          amec.b(this.a);
          if (this.a.c != 5) {
            this.a.jdField_a_of_type_Int = 1;
          }
          paramString = amec.a(this.a).obtainMessage(18, 1, 0);
          amec.a(this.a).sendMessage(paramString);
          this.a.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.stopLoopDelayed(15000L);
        } while (TextUtils.isEmpty(amec.a(this.a)));
        if (!amec.a(this.a)) {
          break;
        }
      } while ((amec.a(this.a) != 1) || (this.a.jdField_a_of_type_ComTencentMobileqqApolloBarrageBarrageView == null));
      this.a.jdField_a_of_type_ComTencentMobileqqApolloBarrageBarrageView.b();
      return;
      if (amec.a(this.a) != 1) {
        break;
      }
    } while (this.a.jdField_a_of_type_ComTencentMobileqqApolloBarrageBarrageView == null);
    this.a.jdField_a_of_type_ComTencentMobileqqApolloBarrageBarrageView.a(true);
    return;
    this.a.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.getRenderImpl().a(1, amec.a(this.a).apolloId, "Bubble");
    return;
    synchronized (amec.a(this.a))
    {
      if (amec.a(this.a).containsKey(paramString))
      {
        Message localMessage = amec.a(this.a).obtainMessage(28);
        localMessage.obj = paramString;
        amec.a(this.a).sendMessage(localMessage);
        this.a.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.stopLoopDelayed(15000L);
      }
      return;
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloViewController", 2, new Object[] { "[onStartRender] taskId=", Integer.valueOf(paramInt), ", roleName=", paramString });
    }
    if ((amec.a(this.a) != null) && (!TextUtils.isEmpty(amec.a(this.a).apolloId)) && (amec.a(this.a).apolloId.equals(paramString))) {
      amec.a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amed
 * JD-Core Version:    0.7.0.1
 */