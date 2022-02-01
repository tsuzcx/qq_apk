import com.tencent.qav.QavDef.MultiUserInfo;
import com.tencent.qqmini.sdk.launcher.core.proxy.VoIPProxy.MultiUserInfo;
import com.tencent.qqmini.sdk.launcher.core.proxy.VoIPProxy.VoIPListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class bjgv
  extends biiz
{
  bjgv(bjgt parambjgt) {}
  
  public void onEnterRoom()
  {
    if (bjgt.a(this.a) != null) {
      bjgt.a(this.a).onEnterRoom();
    }
  }
  
  public void onError(int paramInt)
  {
    if (bjgt.a(this.a) != null) {
      bjgt.a(this.a).onError(paramInt);
    }
  }
  
  public void onUserAudioAvailable(QavDef.MultiUserInfo paramMultiUserInfo, boolean paramBoolean)
  {
    if (bjgt.a(this.a) != null)
    {
      VoIPProxy.MultiUserInfo localMultiUserInfo = null;
      if (paramMultiUserInfo != null)
      {
        localMultiUserInfo = new VoIPProxy.MultiUserInfo();
        localMultiUserInfo.mMicOn = paramMultiUserInfo.mMicOn;
        localMultiUserInfo.mOpenId = paramMultiUserInfo.mOpenId;
        localMultiUserInfo.mUin = paramMultiUserInfo.mUin;
      }
      bjgt.a(this.a).onUserAudioAvailable(localMultiUserInfo, paramBoolean);
    }
  }
  
  public void onUserEnter(QavDef.MultiUserInfo paramMultiUserInfo)
  {
    if (bjgt.a(this.a) != null)
    {
      VoIPProxy.MultiUserInfo localMultiUserInfo = null;
      if (paramMultiUserInfo != null)
      {
        localMultiUserInfo = new VoIPProxy.MultiUserInfo();
        localMultiUserInfo.mMicOn = paramMultiUserInfo.mMicOn;
        localMultiUserInfo.mOpenId = paramMultiUserInfo.mOpenId;
        localMultiUserInfo.mUin = paramMultiUserInfo.mUin;
      }
      bjgt.a(this.a).onUserEnter(localMultiUserInfo);
    }
  }
  
  public void onUserExit(QavDef.MultiUserInfo paramMultiUserInfo)
  {
    if (bjgt.a(this.a) != null)
    {
      VoIPProxy.MultiUserInfo localMultiUserInfo = null;
      if (paramMultiUserInfo != null)
      {
        localMultiUserInfo = new VoIPProxy.MultiUserInfo();
        localMultiUserInfo.mMicOn = paramMultiUserInfo.mMicOn;
        localMultiUserInfo.mOpenId = paramMultiUserInfo.mOpenId;
        localMultiUserInfo.mUin = paramMultiUserInfo.mUin;
      }
      bjgt.a(this.a).onUserExit(localMultiUserInfo);
    }
  }
  
  public void onUserSpeaking(QavDef.MultiUserInfo paramMultiUserInfo, boolean paramBoolean)
  {
    if (bjgt.a(this.a) != null)
    {
      VoIPProxy.MultiUserInfo localMultiUserInfo = null;
      if (paramMultiUserInfo != null)
      {
        localMultiUserInfo = new VoIPProxy.MultiUserInfo();
        localMultiUserInfo.mMicOn = paramMultiUserInfo.mMicOn;
        localMultiUserInfo.mOpenId = paramMultiUserInfo.mOpenId;
        localMultiUserInfo.mUin = paramMultiUserInfo.mUin;
      }
      bjgt.a(this.a).onUserSpeaking(localMultiUserInfo, paramBoolean);
    }
  }
  
  public void onUserUpdate(List<QavDef.MultiUserInfo> paramList)
  {
    if (bjgt.a(this.a) != null)
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
      bjgt.a(this.a).onUserUpdate(localArrayList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjgv
 * JD-Core Version:    0.7.0.1
 */