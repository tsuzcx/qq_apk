import android.text.TextUtils;
import com.tencent.mobileqq.apollo.ApolloTextureView;
import com.tencent.mobileqq.apollo.barrage.BarrageView;
import com.tencent.mobileqq.apollo.store.ApolloWebAvatarParam;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class anfn
  implements ampw
{
  private WeakReference<anfk> a;
  
  public anfn(anfk paramanfk)
  {
    this.a = new WeakReference(paramanfk);
  }
  
  public void a(int paramInt1, int paramInt2, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloViewController", 2, new Object[] { "mOtherSurfaceView onCompleteRender, roleName=", paramString });
    }
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return;
      if (this.a != null)
      {
        anfk localanfk = (anfk)this.a.get();
        ApolloWebAvatarParam localApolloWebAvatarParam;
        if (localanfk != null)
        {
          localApolloWebAvatarParam = anfk.a(localanfk);
          if ((localApolloWebAvatarParam != null) && (paramString.equals(localApolloWebAvatarParam.apolloId)) && (localanfk.b != null))
          {
            anfk.b(localanfk);
            anfk.a(localanfk).removeMessages(24);
            localanfk.b.stopLoopDelayed(1000L);
            if (!TextUtils.isEmpty(anfk.a(localanfk)))
            {
              if (!anfk.a(localanfk)) {
                break label173;
              }
              if ((anfk.a(localanfk) == 1) && (localanfk.a != null)) {
                localanfk.a.b();
              }
            }
          }
        }
        while ((localanfk != null) && (localanfk.b != null))
        {
          return;
          label173:
          if (anfk.a(localanfk) == 1)
          {
            if (localanfk.a != null) {
              localanfk.a.a(true);
            }
          }
          else {
            localanfk.b.getRenderImpl().a(1, localApolloWebAvatarParam.apolloId, "Bubble");
          }
        }
      }
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloViewController", 2, new Object[] { "mOtherSurfaceView onStartRender, roleName=", paramString });
    }
    if (TextUtils.isEmpty(paramString)) {}
    anfk localanfk;
    ApolloWebAvatarParam localApolloWebAvatarParam;
    do
    {
      do
      {
        do
        {
          return;
        } while (this.a == null);
        localanfk = (anfk)this.a.get();
      } while (localanfk == null);
      localApolloWebAvatarParam = anfk.a(localanfk);
    } while ((localApolloWebAvatarParam == null) || (!paramString.equals(localApolloWebAvatarParam.apolloId)));
    anfk.a(localanfk);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anfn
 * JD-Core Version:    0.7.0.1
 */