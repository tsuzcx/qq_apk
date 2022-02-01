import android.text.TextUtils;
import com.tencent.mobileqq.apollo.ApolloTextureView;
import com.tencent.mobileqq.apollo.barrage.BarrageView;
import com.tencent.mobileqq.apollo.store.ApolloWebAvatarParam;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class amxr
  implements amkh
{
  private WeakReference<amxo> a;
  
  public amxr(amxo paramamxo)
  {
    this.a = new WeakReference(paramamxo);
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
        amxo localamxo = (amxo)this.a.get();
        ApolloWebAvatarParam localApolloWebAvatarParam;
        if (localamxo != null)
        {
          localApolloWebAvatarParam = amxo.a(localamxo);
          if ((localApolloWebAvatarParam != null) && (paramString.equals(localApolloWebAvatarParam.apolloId)) && (localamxo.b != null))
          {
            amxo.b(localamxo);
            amxo.a(localamxo).removeMessages(24);
            localamxo.b.stopLoopDelayed(1000L);
            if (!TextUtils.isEmpty(amxo.a(localamxo)))
            {
              if (!amxo.a(localamxo)) {
                break label173;
              }
              if ((amxo.a(localamxo) == 1) && (localamxo.a != null)) {
                localamxo.a.b();
              }
            }
          }
        }
        while ((localamxo != null) && (localamxo.b != null))
        {
          return;
          label173:
          if (amxo.a(localamxo) == 1)
          {
            if (localamxo.a != null) {
              localamxo.a.a(true);
            }
          }
          else {
            localamxo.b.getRenderImpl().a(1, localApolloWebAvatarParam.apolloId, "Bubble");
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
    amxo localamxo;
    ApolloWebAvatarParam localApolloWebAvatarParam;
    do
    {
      do
      {
        do
        {
          return;
        } while (this.a == null);
        localamxo = (amxo)this.a.get();
      } while (localamxo == null);
      localApolloWebAvatarParam = amxo.a(localamxo);
    } while ((localApolloWebAvatarParam == null) || (!paramString.equals(localApolloWebAvatarParam.apolloId)));
    amxo.a(localamxo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amxr
 * JD-Core Version:    0.7.0.1
 */