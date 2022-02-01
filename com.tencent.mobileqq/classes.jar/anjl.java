import android.text.TextUtils;
import com.tencent.mobileqq.apollo.ApolloTextureView;
import com.tencent.mobileqq.apollo.barrage.BarrageView;
import com.tencent.mobileqq.apollo.store.ApolloWebAvatarParam;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class anjl
  implements amwb
{
  private WeakReference<anji> a;
  
  public anjl(anji paramanji)
  {
    this.a = new WeakReference(paramanji);
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
        anji localanji = (anji)this.a.get();
        ApolloWebAvatarParam localApolloWebAvatarParam;
        if (localanji != null)
        {
          localApolloWebAvatarParam = anji.a(localanji);
          if ((localApolloWebAvatarParam != null) && (paramString.equals(localApolloWebAvatarParam.apolloId)) && (localanji.b != null))
          {
            anji.b(localanji);
            anji.a(localanji).removeMessages(24);
            localanji.b.stopLoopDelayed(1000L);
            if (!TextUtils.isEmpty(anji.a(localanji)))
            {
              if (!anji.a(localanji)) {
                break label173;
              }
              if ((anji.a(localanji) == 1) && (localanji.a != null)) {
                localanji.a.b();
              }
            }
          }
        }
        while ((localanji != null) && (localanji.b != null))
        {
          return;
          label173:
          if (anji.a(localanji) == 1)
          {
            if (localanji.a != null) {
              localanji.a.a(true);
            }
          }
          else {
            localanji.b.getRenderImpl().a(1, localApolloWebAvatarParam.apolloId, "Bubble");
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
    anji localanji;
    ApolloWebAvatarParam localApolloWebAvatarParam;
    do
    {
      do
      {
        do
        {
          return;
        } while (this.a == null);
        localanji = (anji)this.a.get();
      } while (localanji == null);
      localApolloWebAvatarParam = anji.a(localanji);
    } while ((localApolloWebAvatarParam == null) || (!paramString.equals(localApolloWebAvatarParam.apolloId)));
    anji.a(localanji);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anjl
 * JD-Core Version:    0.7.0.1
 */