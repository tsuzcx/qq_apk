import android.os.Bundle;
import android.os.Handler;
import android.util.SparseArray;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.model.BaseLibInfo;
import com.tencent.qqmini.sdk.log.QMLog;
import com.tencent.qqmini.sdk.manager.EngineChannel;
import com.tencent.qqmini.sdk.manager.EngineManager.EngineChannelReceiver.1;
import com.tencent.qqmini.sdk.manager.InstalledEngine;
import com.tencent.qqmini.sdk.utils.WnsUtil;
import java.util.Iterator;
import java.util.List;

public class bgwh
  implements bgvz
{
  public bgwh(bgwe parambgwe) {}
  
  public void a(int paramInt, Bundle paramBundle)
  {
    paramBundle.setClassLoader(getClass().getClassLoader());
    int i = paramBundle.getInt("baseLibType");
    int j = paramBundle.getInt("enginePid");
    EngineChannel localEngineChannel = (EngineChannel)paramBundle.getParcelable("engineChannel");
    if (localEngineChannel != null)
    {
      if (bgwe.a(this.a).indexOfKey(j) > 0) {
        QMLog.w("EngineManager", "[MiniEng] channel already exists for pid " + j + " replacing");
      }
      bgwe.a(this.a).put(j, localEngineChannel);
    }
    localEngineChannel = (EngineChannel)bgwe.a(this.a).get(j);
    if (localEngineChannel == null)
    {
      QMLog.e("EngineManager", "[MiniEng]no channel available for pid " + j);
      return;
    }
    QMLog.i("EngineManager", "[MiniEng] onReceiveData what=" + paramInt + ",baseLibType=" + i + ",pid=" + j + ",remote=" + localEngineChannel + ",channelCount=" + bgwe.a(this.a).size());
    localEngineChannel.a(55, null);
    Object localObject;
    if (paramInt == 1)
    {
      paramBundle = bgwe.a().a(i);
      localObject = new Bundle();
      ((Bundle)localObject).putParcelableArrayList("installedEngineList", paramBundle);
      localEngineChannel.a(51, (Bundle)localObject);
      bgwe.a(this.a, localEngineChannel);
      QMLog.i("EngineManager", "[MiniEng]LiveChannel count " + bgwe.a(this.a).size());
      return;
    }
    if (paramInt == 3) {
      if (i == 2)
      {
        paramBundle = this.a.a(i).iterator();
        do
        {
          if (!paramBundle.hasNext()) {
            break;
          }
          localObject = (InstalledEngine)paramBundle.next();
        } while ((!((InstalledEngine)localObject).b) || (!((InstalledEngine)localObject).a));
      }
    }
    for (paramInt = 1;; paramInt = 0)
    {
      if ((!bgxk.a().a()) && (paramInt == 0))
      {
        ThreadManager.b().post(new EngineManager.EngineChannelReceiver.1(this, localEngineChannel));
        return;
      }
      if (bgxk.a().b())
      {
        paramBundle = WnsUtil.getGameBaseLibInfo();
        QMLog.i("EngineManager", "[MiniEng] QQSpeed INSTALL_LATEST_ENGINE gameEngineLib " + paramBundle);
        if ((paramBundle == null) || (paramBundle.baseLibType != 2)) {
          break;
        }
        bgwe.b(this.a, paramBundle, localEngineChannel);
        return;
      }
      ((ChannelProxy)ProxyManager.get(ChannelProxy.class)).updateBaseLib("0,0,1", false, true, new bgwi(this, i, localEngineChannel));
      return;
      if (paramInt == 5)
      {
        if ((i == 2) && (bgxk.a().b()))
        {
          paramBundle = WnsUtil.getGameBaseLibInfo();
          QMLog.i("EngineManager", "[MiniEng] QQSpeed UPGRADE_ENGINE gameEngineLib " + paramBundle);
          if ((paramBundle == null) || (paramBundle.baseLibType != 2)) {
            break;
          }
          bgwe.c(this.a, paramBundle, localEngineChannel);
          return;
        }
        ((ChannelProxy)ProxyManager.get(ChannelProxy.class)).updateBaseLib("0,0,1", false, true, new bgwj(this, i, localEngineChannel));
        return;
      }
      if (paramInt != 56) {
        break;
      }
      paramBundle = (InstalledEngine)paramBundle.getParcelable("invalidEngine");
      QMLog.i("EngineManager", "[MiniEng] receive delete InstalledEngine from pid:" + j + ", baseLibType:" + i + ", targetEngine:" + paramBundle);
      if (paramBundle == null) {
        break;
      }
      bgwa.a(paramBundle);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bgwh
 * JD-Core Version:    0.7.0.1
 */