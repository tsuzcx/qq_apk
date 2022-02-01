import android.text.TextUtils;
import com.tencent.mobileqq.apollo.ApolloTextureView;
import com.tencent.mobileqq.apollo.barrage.BarrageView;
import com.tencent.mobileqq.apollo.store.ApolloWebAvatarParam;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class amef
  implements alqv
{
  private WeakReference<amec> a;
  
  public amef(amec paramamec)
  {
    this.a = new WeakReference(paramamec);
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
        amec localamec = (amec)this.a.get();
        ApolloWebAvatarParam localApolloWebAvatarParam;
        if (localamec != null)
        {
          localApolloWebAvatarParam = amec.a(localamec);
          if ((localApolloWebAvatarParam != null) && (paramString.equals(localApolloWebAvatarParam.apolloId)) && (localamec.b != null))
          {
            amec.b(localamec);
            amec.a(localamec).removeMessages(24);
            localamec.b.stopLoopDelayed(1000L);
            if (!TextUtils.isEmpty(amec.a(localamec)))
            {
              if (!amec.a(localamec)) {
                break label173;
              }
              if ((amec.a(localamec) == 1) && (localamec.a != null)) {
                localamec.a.b();
              }
            }
          }
        }
        while ((localamec != null) && (localamec.b != null))
        {
          return;
          label173:
          if (amec.a(localamec) == 1)
          {
            if (localamec.a != null) {
              localamec.a.a(true);
            }
          }
          else {
            localamec.b.getRenderImpl().a(1, localApolloWebAvatarParam.apolloId, "Bubble");
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
    amec localamec;
    ApolloWebAvatarParam localApolloWebAvatarParam;
    do
    {
      do
      {
        do
        {
          return;
        } while (this.a == null);
        localamec = (amec)this.a.get();
      } while (localamec == null);
      localApolloWebAvatarParam = amec.a(localamec);
    } while ((localApolloWebAvatarParam == null) || (!paramString.equals(localApolloWebAvatarParam.apolloId)));
    amec.a(localamec);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amef
 * JD-Core Version:    0.7.0.1
 */