import com.tencent.qav.QavDef.MultiUserInfo;
import com.tencent.qqmini.sdk.launcher.core.proxy.VoIPProxy.MultiUserInfo;
import com.tencent.qqmini.sdk.launcher.core.proxy.VoIPProxy.VoIPListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class bjzu
  extends bjcp
{
  bjzu(bjzs parambjzs) {}
  
  public void onEnterRoom()
  {
    if (bjzs.a(this.a) != null) {
      bjzs.a(this.a).onEnterRoom();
    }
  }
  
  public void onError(int paramInt)
  {
    if (bjzs.a(this.a) != null) {
      bjzs.a(this.a).onError(paramInt);
    }
  }
  
  public void onUserAudioAvailable(QavDef.MultiUserInfo paramMultiUserInfo, boolean paramBoolean)
  {
    if (bjzs.a(this.a) != null)
    {
      VoIPProxy.MultiUserInfo localMultiUserInfo = null;
      if (paramMultiUserInfo != null)
      {
        localMultiUserInfo = new VoIPProxy.MultiUserInfo();
        localMultiUserInfo.mMicOn = paramMultiUserInfo.mMicOn;
        localMultiUserInfo.mOpenId = paramMultiUserInfo.mOpenId;
        localMultiUserInfo.mUin = paramMultiUserInfo.mUin;
      }
      bjzs.a(this.a).onUserAudioAvailable(localMultiUserInfo, paramBoolean);
    }
  }
  
  public void onUserEnter(QavDef.MultiUserInfo paramMultiUserInfo)
  {
    if (bjzs.a(this.a) != null)
    {
      VoIPProxy.MultiUserInfo localMultiUserInfo = null;
      if (paramMultiUserInfo != null)
      {
        localMultiUserInfo = new VoIPProxy.MultiUserInfo();
        localMultiUserInfo.mMicOn = paramMultiUserInfo.mMicOn;
        localMultiUserInfo.mOpenId = paramMultiUserInfo.mOpenId;
        localMultiUserInfo.mUin = paramMultiUserInfo.mUin;
      }
      bjzs.a(this.a).onUserEnter(localMultiUserInfo);
    }
  }
  
  public void onUserExit(QavDef.MultiUserInfo paramMultiUserInfo)
  {
    if (bjzs.a(this.a) != null)
    {
      VoIPProxy.MultiUserInfo localMultiUserInfo = null;
      if (paramMultiUserInfo != null)
      {
        localMultiUserInfo = new VoIPProxy.MultiUserInfo();
        localMultiUserInfo.mMicOn = paramMultiUserInfo.mMicOn;
        localMultiUserInfo.mOpenId = paramMultiUserInfo.mOpenId;
        localMultiUserInfo.mUin = paramMultiUserInfo.mUin;
      }
      bjzs.a(this.a).onUserExit(localMultiUserInfo);
    }
  }
  
  public void onUserSpeaking(QavDef.MultiUserInfo paramMultiUserInfo, boolean paramBoolean)
  {
    if (bjzs.a(this.a) != null)
    {
      VoIPProxy.MultiUserInfo localMultiUserInfo = null;
      if (paramMultiUserInfo != null)
      {
        localMultiUserInfo = new VoIPProxy.MultiUserInfo();
        localMultiUserInfo.mMicOn = paramMultiUserInfo.mMicOn;
        localMultiUserInfo.mOpenId = paramMultiUserInfo.mOpenId;
        localMultiUserInfo.mUin = paramMultiUserInfo.mUin;
      }
      bjzs.a(this.a).onUserSpeaking(localMultiUserInfo, paramBoolean);
    }
  }
  
  public void onUserUpdate(List<QavDef.MultiUserInfo> paramList)
  {
    if (bjzs.a(this.a) != null)
    {
      ArrayList localArrayList = null;
      if (paramList != null)
      {
        localArrayList = new ArrayList();
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          QavDef.MultiUserInfo localMultiUserInfo = (QavDef.MultiUserInfo)paramList.next();
          if (localMultiUserInfo != null)
          {
            VoIPProxy.MultiUserInfo localMultiUserInfo1 = new VoIPProxy.MultiUserInfo();
            localMultiUserInfo1.mMicOn = localMultiUserInfo.mMicOn;
            localMultiUserInfo1.mOpenId = localMultiUserInfo.mOpenId;
            localMultiUserInfo1.mUin = localMultiUserInfo.mUin;
            localArrayList.add(localMultiUserInfo1);
          }
        }
      }
      bjzs.a(this.a).onUserUpdate(localArrayList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjzu
 * JD-Core Version:    0.7.0.1
 */