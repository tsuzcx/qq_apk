import android.os.Bundle;
import android.os.Handler;
import android.util.SparseArray;
import com.tencent.qqmini.sdk.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.model.BaseLibInfo;
import com.tencent.qqmini.sdk.manager.EngineChannel;
import com.tencent.qqmini.sdk.manager.EngineManager.EngineChannelReceiver.1;
import com.tencent.qqmini.sdk.manager.InstalledEngine;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class betc
  implements besu
{
  public betc(besz parambesz) {}
  
  public void a(int paramInt, Bundle paramBundle)
  {
    paramBundle.setClassLoader(getClass().getClassLoader());
    int i = paramBundle.getInt("baseLibType");
    int j = paramBundle.getInt("enginePid");
    paramBundle = (EngineChannel)paramBundle.getParcelable("engineChannel");
    if (paramBundle != null)
    {
      if (besz.a(this.a).indexOfKey(j) > 0) {
        besl.c("EngineManager", "[MiniEng] channel already exists for pid " + j + " replacing");
      }
      besz.a(this.a).put(j, paramBundle);
    }
    paramBundle = (EngineChannel)besz.a(this.a).get(j);
    if (paramBundle == null)
    {
      besl.d("EngineManager", "[MiniEng]no channel available for pid " + j);
      return;
    }
    besl.b("EngineManager", "[MiniEng] onReceiveData what=" + paramInt + ",baseLibType=" + i + ",pid=" + j + ",remote=" + paramBundle + ",channelCount=" + besz.a(this.a).size());
    paramBundle.a(55, null);
    Object localObject1;
    Object localObject2;
    if (paramInt == 1)
    {
      localObject1 = besz.a().a(i);
      localObject2 = new Bundle();
      ((Bundle)localObject2).putParcelableArrayList("installedEngineList", (ArrayList)localObject1);
      paramBundle.a(51, (Bundle)localObject2);
      besz.a(this.a, paramBundle);
      besl.b("EngineManager", "[MiniEng]LiveChannel count " + besz.a(this.a).size());
      return;
    }
    if (paramInt == 3) {
      if (i == 2)
      {
        localObject1 = this.a.a(i).iterator();
        do
        {
          if (!((Iterator)localObject1).hasNext()) {
            break;
          }
          localObject2 = (InstalledEngine)((Iterator)localObject1).next();
        } while ((!((InstalledEngine)localObject2).b) || (!((InstalledEngine)localObject2).a));
      }
    }
    for (paramInt = 1;; paramInt = 0)
    {
      if ((!beub.a().a()) && (paramInt == 0))
      {
        beiw.b().post(new EngineManager.EngineChannelReceiver.1(this, paramBundle));
        return;
      }
      if (beub.a().b())
      {
        localObject1 = bfgy.a();
        besl.b("EngineManager", "[MiniEng] QQSpeed INSTALL_LATEST_ENGINE gameEngineLib " + localObject1);
        if ((localObject1 == null) || (((BaseLibInfo)localObject1).baseLibType != 2)) {
          break;
        }
        besz.b(this.a, (BaseLibInfo)localObject1, paramBundle);
        return;
      }
      ((ChannelProxy)ProxyManager.get(ChannelProxy.class)).updateBaseLib("0,0,1", false, true, new betd(this, i, paramBundle));
      return;
      if (paramInt != 5) {
        break;
      }
      if ((i == 2) && (beub.a().b()))
      {
        localObject1 = bfgy.a();
        besl.b("EngineManager", "[MiniEng] QQSpeed UPGRADE_ENGINE gameEngineLib " + localObject1);
        if ((localObject1 == null) || (((BaseLibInfo)localObject1).baseLibType != 2)) {
          break;
        }
        besz.c(this.a, (BaseLibInfo)localObject1, paramBundle);
        return;
      }
      ((ChannelProxy)ProxyManager.get(ChannelProxy.class)).updateBaseLib("0,0,1", false, true, new bete(this, i, paramBundle));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     betc
 * JD-Core Version:    0.7.0.1
 */