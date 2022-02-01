import android.os.Bundle;
import android.os.Handler;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.contentbox.QZoneMsgFragment;
import cooperation.qzone.contentbox.QZoneMsgFragment.QZoneMsgUIObserver.1;
import cooperation.qzone.contentbox.model.QZoneMsgEntityNew;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;

public class blxf
  extends blxh
{
  public blxf(QZoneMsgFragment paramQZoneMsgFragment) {}
  
  protected void a(boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QZoneMsgManager.QZoneMsgFragment", 2, "onLoadMoreMsg");
    }
    super.a(paramBoolean, paramBundle);
    if (!paramBoolean)
    {
      QZLog.e("QZoneMsgManager.QZoneMsgFragment", "onLoadMoreMsg error");
      QZoneMsgFragment.a(this.a, paramBoolean);
      return;
    }
    paramBundle = (QZoneMsgEntityNew)paramBundle.getSerializable("key_response");
    if (paramBundle != null)
    {
      this.a.a.b(paramBundle.ArkNes_vec);
      QZoneMsgFragment.a(this.a);
      QZoneMsgFragment.a(this.a, paramBundle.hasmore);
      QLog.i("QZoneMsgManager.QZoneMsgFragment", 2, "onLoadMoreMsg ，hasMore=" + QZoneMsgFragment.c(this.a));
    }
    for (;;)
    {
      QZoneMsgFragment.a(this.a, paramBoolean);
      return;
      if (QLog.isColorLevel()) {
        QLog.e("QZoneMsgManager.QZoneMsgFragment", 2, "onLoadMoreMsg ，rsp=null");
      }
    }
  }
  
  protected boolean a(boolean paramBoolean, Bundle paramBundle)
  {
    return true;
  }
  
  protected void b(boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QZoneMsgManager.QZoneMsgFragment", 2, "onPreloadMsg");
    }
    super.b(paramBoolean, paramBundle);
    if (!paramBoolean) {
      QZLog.e("QZoneMsgManager.QZoneMsgFragment", "onPreloadMsg error");
    }
    do
    {
      return;
      paramBundle = (QZoneMsgEntityNew)paramBundle.getSerializable("key_response");
      if (paramBundle != null)
      {
        QZoneMsgFragment.a(this.a, paramBundle);
        QZoneMsgFragment.a(this.a, paramBundle.hasmore);
        this.a.a.a(paramBundle.ArkNes_vec);
        QLog.i("QZoneMsgManager.QZoneMsgFragment", 2, "onPreloadMsg ，hasMore=" + QZoneMsgFragment.c(this.a));
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.e("QZoneMsgManager.QZoneMsgFragment", 2, "onPreloadMsg ，rsp=null");
  }
  
  protected void c(boolean paramBoolean, Bundle paramBundle)
  {
    QLog.i("QZoneMsgManager.QZoneMsgFragment", 1, "onReFreshMsg start");
    super.c(paramBoolean, paramBundle);
    if (!paramBoolean)
    {
      QZLog.e("QZoneMsgManager.QZoneMsgFragment", "onReFreshMsg error");
      QZoneMsgFragment.b(this.a, paramBoolean);
      return;
    }
    paramBundle = (QZoneMsgEntityNew)paramBundle.getSerializable("key_response");
    if (paramBundle != null)
    {
      QZoneMsgFragment.a(this.a, paramBundle);
      QZoneMsgFragment.a(this.a).postDelayed(new QZoneMsgFragment.QZoneMsgUIObserver.1(this, paramBundle), 500L);
      QZoneMsgFragment.b(this.a, true);
      QZoneMsgFragment.a(this.a, paramBundle.hasmore);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder().append("onReFreshMsg ，hasMore=").append(QZoneMsgFragment.c(this.a)).append(" ,ArkNes_vec size:");
        if (paramBundle.ArkNes_vec == null) {
          break label175;
        }
        paramBundle = String.valueOf(paramBundle.ArkNes_vec.size());
        QLog.i("QZoneMsgManager.QZoneMsgFragment", 2, paramBundle);
      }
    }
    for (;;)
    {
      QZoneMsgFragment.b(this.a, paramBoolean);
      return;
      label175:
      paramBundle = "null";
      break;
      if (QLog.isColorLevel()) {
        QLog.e("QZoneMsgManager.QZoneMsgFragment", 2, "onReFreshMsg ，rsp=null");
      }
    }
  }
  
  protected void d(boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QZoneMsgManager.QZoneMsgFragment", 2, "onLikeFeed start");
    }
    super.d(paramBoolean, paramBundle);
    if ((paramBoolean) && (paramBundle != null))
    {
      paramBoolean = paramBundle.getBoolean("like_key");
      long l = paramBundle.getLong("entity_pushtime");
      this.a.a.a(l, paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blxf
 * JD-Core Version:    0.7.0.1
 */