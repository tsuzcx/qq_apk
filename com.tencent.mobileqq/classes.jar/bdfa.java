import com.tencent.qqmini.sdk.core.proxy.VoIPProxy;
import com.tencent.qqmini.sdk.core.proxy.VoIPProxy.MultiUserInfo;
import com.tencent.qqmini.sdk.core.proxy.VoIPProxy.VoIPListener;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;

class bdfa
  implements VoIPProxy.VoIPListener
{
  bdfa(bdey parambdey) {}
  
  public void onEnterRoom()
  {
    bdnw.a("VoIPManager", "onEnterRoom");
    bdey.a(this.a).set(true);
    if (bdey.a(this.a) != null) {
      this.a.a(bdey.a(this.a), null);
    }
    bdey.a(this.a).updateRoomInfo();
    bdey.a(this.a, -1);
  }
  
  public void onError(int paramInt)
  {
    bdnw.a("VoIPManager", String.format("onEnterRoom errorType=%s", new Object[] { Integer.valueOf(paramInt) }));
    if ((paramInt == 2) || (paramInt == 1)) {
      if (bdey.a(this.a) != null)
      {
        bdey.a(this.a).onError(paramInt);
        bdey.a(this.a, null);
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
      } while (bdey.a(this.a) == null);
      bdey.a(this.a).onInterrupt(4, "第三方通话中断");
      return;
    } while ((paramInt != 3) || (bdey.a(this.a) == null));
    bdey.a(this.a).onInterrupt(3, "网络原因中断");
  }
  
  public void onUserAudioAvailable(VoIPProxy.MultiUserInfo paramMultiUserInfo, boolean paramBoolean)
  {
    bdnw.a("VoIPManager", String.format("onUserAudioAvailable userInfo=%s available=%s", new Object[] { paramMultiUserInfo, Boolean.valueOf(paramBoolean) }));
  }
  
  public void onUserEnter(VoIPProxy.MultiUserInfo paramMultiUserInfo)
  {
    bdnw.a("VoIPManager", String.format("onUserEnter userInfo=%s", new Object[] { paramMultiUserInfo }));
    if ((bdey.a(this.a) == null) && (bdey.a(this.a, paramMultiUserInfo.mUin) == null))
    {
      bdfh localbdfh = new bdfh(this.a, null);
      localbdfh.jdField_a_of_type_Long = paramMultiUserInfo.mUin;
      localbdfh.jdField_a_of_type_JavaLangString = paramMultiUserInfo.mOpenId;
      localbdfh.jdField_a_of_type_Int = 1;
      bdey.a(this.a, localbdfh);
      if (bdey.a(this.a) != null) {
        bdey.a(this.a).onRoomMemberChange(bdey.a(this.a));
      }
    }
  }
  
  public void onUserExit(VoIPProxy.MultiUserInfo paramMultiUserInfo)
  {
    bdnw.a("VoIPManager", String.format("onUserExit userInfo=%s", new Object[] { paramMultiUserInfo }));
    if (bdey.a(this.a) == null)
    {
      bdey.b(this.a, paramMultiUserInfo.mUin);
      if (bdey.a(this.a) != null) {
        bdey.a(this.a).onRoomMemberChange(bdey.a(this.a));
      }
    }
  }
  
  public void onUserSpeaking(VoIPProxy.MultiUserInfo paramMultiUserInfo, boolean paramBoolean)
  {
    bdnw.a("VoIPManager", String.format("onUserSpeaking userInfo=%s speaking=%s", new Object[] { paramMultiUserInfo, Boolean.valueOf(paramBoolean) }));
    paramMultiUserInfo = bdey.a(this.a, paramMultiUserInfo.mUin);
    if (paramMultiUserInfo != null)
    {
      paramMultiUserInfo.jdField_a_of_type_Boolean = paramBoolean;
      if (bdey.a(this.a) != null) {
        bdey.a(this.a).onRoomMemberSpeaking(bdey.b(this.a));
      }
      return;
    }
    bdnw.d("VoIPManager", "onUserSpeaking userModel==null");
  }
  
  public void onUserUpdate(List<VoIPProxy.MultiUserInfo> paramList)
  {
    if ((bdey.a(this.a) != null) && (paramList != null))
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
      bdey.a(this.a).onJoinRoom(localJSONArray);
      bdey.a(this.a, paramList);
      bdey.a(this.a, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bdfa
 * JD-Core Version:    0.7.0.1
 */