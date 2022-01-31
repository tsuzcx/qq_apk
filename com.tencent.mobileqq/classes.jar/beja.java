import com.tencent.qqmini.sdk.core.proxy.VoIPProxy;
import com.tencent.qqmini.sdk.core.proxy.VoIPProxy.MultiUserInfo;
import com.tencent.qqmini.sdk.core.proxy.VoIPProxy.VoIPListener;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;

class beja
  implements VoIPProxy.VoIPListener
{
  beja(beiy parambeiy) {}
  
  public void onEnterRoom()
  {
    besl.a("VoIPManager", "onEnterRoom");
    beiy.a(this.a).set(true);
    if (beiy.a(this.a) != null) {
      this.a.a(beiy.a(this.a), null);
    }
    beiy.a(this.a).updateRoomInfo();
    beiy.a(this.a, -1);
  }
  
  public void onError(int paramInt)
  {
    besl.a("VoIPManager", String.format("onEnterRoom errorType=%s", new Object[] { Integer.valueOf(paramInt) }));
    if ((paramInt == 2) || (paramInt == 1)) {
      if (beiy.a(this.a) != null)
      {
        beiy.a(this.a).onError(paramInt);
        beiy.a(this.a, null);
      }
    }
    do
    {
      do
      {
        return;
        if (paramInt != 4) {
          break;
        }
      } while (beiy.a(this.a) == null);
      beiy.a(this.a).onInterrupt(4, "第三方通话中断");
      return;
    } while ((paramInt != 3) || (beiy.a(this.a) == null));
    beiy.a(this.a).onInterrupt(3, "网络原因中断");
  }
  
  public void onUserAudioAvailable(VoIPProxy.MultiUserInfo paramMultiUserInfo, boolean paramBoolean)
  {
    besl.a("VoIPManager", String.format("onUserAudioAvailable userInfo=%s available=%s", new Object[] { paramMultiUserInfo, Boolean.valueOf(paramBoolean) }));
  }
  
  public void onUserEnter(VoIPProxy.MultiUserInfo paramMultiUserInfo)
  {
    besl.a("VoIPManager", String.format("onUserEnter userInfo=%s", new Object[] { paramMultiUserInfo }));
    if ((beiy.a(this.a) == null) && (beiy.a(this.a, paramMultiUserInfo.mUin) == null))
    {
      bejh localbejh = new bejh(this.a, null);
      localbejh.jdField_a_of_type_Long = paramMultiUserInfo.mUin;
      localbejh.jdField_a_of_type_JavaLangString = paramMultiUserInfo.mOpenId;
      localbejh.jdField_a_of_type_Int = 1;
      beiy.a(this.a, localbejh);
      if (beiy.a(this.a) != null) {
        beiy.a(this.a).onRoomMemberChange(beiy.a(this.a));
      }
    }
  }
  
  public void onUserExit(VoIPProxy.MultiUserInfo paramMultiUserInfo)
  {
    besl.a("VoIPManager", String.format("onUserExit userInfo=%s", new Object[] { paramMultiUserInfo }));
    if (beiy.a(this.a) == null)
    {
      beiy.b(this.a, paramMultiUserInfo.mUin);
      if (beiy.a(this.a) != null) {
        beiy.a(this.a).onRoomMemberChange(beiy.a(this.a));
      }
    }
  }
  
  public void onUserSpeaking(VoIPProxy.MultiUserInfo paramMultiUserInfo, boolean paramBoolean)
  {
    besl.a("VoIPManager", String.format("onUserSpeaking userInfo=%s speaking=%s", new Object[] { paramMultiUserInfo, Boolean.valueOf(paramBoolean) }));
    paramMultiUserInfo = beiy.a(this.a, paramMultiUserInfo.mUin);
    if (paramMultiUserInfo != null)
    {
      paramMultiUserInfo.jdField_a_of_type_Boolean = paramBoolean;
      if (beiy.a(this.a) != null) {
        beiy.a(this.a).onRoomMemberSpeaking(beiy.b(this.a));
      }
      return;
    }
    besl.d("VoIPManager", "onUserSpeaking userModel==null");
  }
  
  public void onUserUpdate(List<VoIPProxy.MultiUserInfo> paramList)
  {
    if ((beiy.a(this.a) != null) && (paramList != null))
    {
      JSONArray localJSONArray = new JSONArray();
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        VoIPProxy.MultiUserInfo localMultiUserInfo = (VoIPProxy.MultiUserInfo)localIterator.next();
        if (localMultiUserInfo.mUin != 0L) {
          localJSONArray.put(localMultiUserInfo.mOpenId);
        }
      }
      beiy.a(this.a).onJoinRoom(localJSONArray);
      beiy.a(this.a, paramList);
      beiy.a(this.a, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     beja
 * JD-Core Version:    0.7.0.1
 */