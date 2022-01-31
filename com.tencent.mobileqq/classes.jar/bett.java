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

public class bett
  implements betl
{
  public bett(betq parambetq) {}
  
  public void a(int paramInt, Bundle paramBundle)
  {
    paramBundle.setClassLoader(getClass().getClassLoader());
    int i = paramBundle.getInt("baseLibType");
    int j = paramBundle.getInt("enginePid");
    paramBundle = (EngineChannel)paramBundle.getParcelable("engineChannel");
    if (paramBundle != null)
    {
      if (betq.a(this.a).indexOfKey(j) > 0) {
        betc.c("EngineManager", "[MiniEng] channel already exists for pid " + j + " replacing");
      }
      betq.a(this.a).put(j, paramBundle);
    }
    paramBundle = (EngineChannel)betq.a(this.a).get(j);
    if (paramBundle == null)
    {
      betc.d("EngineManager", "[MiniEng]no channel available for pid " + j);
      return;
    }
    betc.b("EngineManager", "[MiniEng] onReceiveData what=" + paramInt + ",baseLibType=" + i + ",pid=" + j + ",remote=" + paramBundle + ",channelCount=" + betq.a(this.a).size());
    paramBundle.a(55, null);
    Object localObject1;
    Object localObject2;
    if (paramInt == 1)
    {
      localObject1 = betq.a().a(i);
      localObject2 = new Bundle();
      ((Bundle)localObject2).putParcelableArrayList("installedEngineList", (ArrayList)localObject1);
      paramBundle.a(51, (Bundle)localObject2);
      betq.a(this.a, paramBundle);
      betc.b("EngineManager", "[MiniEng]LiveChannel count " + betq.a(this.a).size());
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
      if ((!beus.a().a()) && (paramInt == 0))
      {
        bejn.b().post(new EngineManager.EngineChannelReceiver.1(this, paramBundle));
        return;
      }
      if (beus.a().b())
      {
        localObject1 = bfhp.a();
        betc.b("EngineManager", "[MiniEng] QQSpeed INSTALL_LATEST_ENGINE gameEngineLib " + localObject1);
        if ((localObject1 == null) || (((BaseLibInfo)localObject1).baseLibType != 2)) {
          break;
        }
        betq.b(this.a, (BaseLibInfo)localObject1, paramBundle);
        return;
      }
      ((ChannelProxy)ProxyManager.get(ChannelProxy.class)).updateBaseLib("0,0,1", false, true, new betu(this, i, paramBundle));
      return;
      if (paramInt != 5) {
        break;
      }
      if ((i == 2) && (beus.a().b()))
      {
        localObject1 = bfhp.a();
        betc.b("EngineManager", "[MiniEng] QQSpeed UPGRADE_ENGINE gameEngineLib " + localObject1);
        if ((localObject1 == null) || (((BaseLibInfo)localObject1).baseLibType != 2)) {
          break;
        }
        betq.c(this.a, (BaseLibInfo)localObject1, paramBundle);
        return;
      }
      ((ChannelProxy)ProxyManager.get(ChannelProxy.class)).updateBaseLib("0,0,1", false, true, new betv(this, i, paramBundle));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bett
 * JD-Core Version:    0.7.0.1
 */