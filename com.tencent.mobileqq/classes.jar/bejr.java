import com.tencent.qqmini.sdk.core.proxy.VoIPProxy;
import com.tencent.qqmini.sdk.core.proxy.VoIPProxy.MultiUserInfo;
import com.tencent.qqmini.sdk.core.proxy.VoIPProxy.VoIPListener;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;

class bejr
  implements VoIPProxy.VoIPListener
{
  bejr(bejp parambejp) {}
  
  public void onEnterRoom()
  {
    betc.a("VoIPManager", "onEnterRoom");
    bejp.a(this.a).set(true);
    if (bejp.a(this.a) != null) {
      this.a.a(bejp.a(this.a), null);
    }
    bejp.a(this.a).updateRoomInfo();
    bejp.a(this.a, -1);
  }
  
  public void onError(int paramInt)
  {
    betc.a("VoIPManager", String.format("onEnterRoom errorType=%s", new Object[] { Integer.valueOf(paramInt) }));
    if ((paramInt == 2) || (paramInt == 1)) {
      if (bejp.a(this.a) != null)
      {
        bejp.a(this.a).onError(paramInt);
        bejp.a(this.a, null);
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
      } while (bejp.a(this.a) == null);
      bejp.a(this.a).onInterrupt(4, "第三方通话中断");
      return;
    } while ((paramInt != 3) || (bejp.a(this.a) == null));
    bejp.a(this.a).onInterrupt(3, "网络原因中断");
  }
  
  public void onUserAudioAvailable(VoIPProxy.MultiUserInfo paramMultiUserInfo, boolean paramBoolean)
  {
    betc.a("VoIPManager", String.format("onUserAudioAvailable userInfo=%s available=%s", new Object[] { paramMultiUserInfo, Boolean.valueOf(paramBoolean) }));
  }
  
  public void onUserEnter(VoIPProxy.MultiUserInfo paramMultiUserInfo)
  {
    betc.a("VoIPManager", String.format("onUserEnter userInfo=%s", new Object[] { paramMultiUserInfo }));
    if ((bejp.a(this.a) == null) && (bejp.a(this.a, paramMultiUserInfo.mUin) == null))
    {
      bejy localbejy = new bejy(this.a, null);
      localbejy.jdField_a_of_type_Long = paramMultiUserInfo.mUin;
      localbejy.jdField_a_of_type_JavaLangString = paramMultiUserInfo.mOpenId;
      localbejy.jdField_a_of_type_Int = 1;
      bejp.a(this.a, localbejy);
      if (bejp.a(this.a) != null) {
        bejp.a(this.a).onRoomMemberChange(bejp.a(this.a));
      }
    }
  }
  
  public void onUserExit(VoIPProxy.MultiUserInfo paramMultiUserInfo)
  {
    betc.a("VoIPManager", String.format("onUserExit userInfo=%s", new Object[] { paramMultiUserInfo }));
    if (bejp.a(this.a) == null)
    {
      bejp.b(this.a, paramMultiUserInfo.mUin);
      if (bejp.a(this.a) != null) {
        bejp.a(this.a).onRoomMemberChange(bejp.a(this.a));
      }
    }
  }
  
  public void onUserSpeaking(VoIPProxy.MultiUserInfo paramMultiUserInfo, boolean paramBoolean)
  {
    betc.a("VoIPManager", String.format("onUserSpeaking userInfo=%s speaking=%s", new Object[] { paramMultiUserInfo, Boolean.valueOf(paramBoolean) }));
    paramMultiUserInfo = bejp.a(this.a, paramMultiUserInfo.mUin);
    if (paramMultiUserInfo != null)
    {
      paramMultiUserInfo.jdField_a_of_type_Boolean = paramBoolean;
      if (bejp.a(this.a) != null) {
        bejp.a(this.a).onRoomMemberSpeaking(bejp.b(this.a));
      }
      return;
    }
    betc.d("VoIPManager", "onUserSpeaking userModel==null");
  }
  
  public void onUserUpdate(List<VoIPProxy.MultiUserInfo> paramList)
  {
    if ((bejp.a(this.a) != null) && (paramList != null))
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
      bejp.a(this.a).onJoinRoom(localJSONArray);
      bejp.a(this.a, paramList);
      bejp.a(this.a, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bejr
 * JD-Core Version:    0.7.0.1
 */