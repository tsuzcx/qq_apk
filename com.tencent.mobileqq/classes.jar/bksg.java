import com.tencent.qav.QavDef.MultiUserInfo;
import com.tencent.qqmini.sdk.launcher.core.proxy.VoIPProxy.MultiUserInfo;
import com.tencent.qqmini.sdk.launcher.core.proxy.VoIPProxy.VoIPListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class bksg
  extends bjub
{
  bksg(bkse parambkse) {}
  
  public void a()
  {
    if (bkse.a(this.a) != null) {
      bkse.a(this.a).onEnterRoom();
    }
  }
  
  public void a(int paramInt)
  {
    if (bkse.a(this.a) != null) {
      bkse.a(this.a).onError(paramInt);
    }
  }
  
  public void a(QavDef.MultiUserInfo paramMultiUserInfo)
  {
    if (bkse.a(this.a) != null)
    {
      VoIPProxy.MultiUserInfo localMultiUserInfo = null;
      if (paramMultiUserInfo != null)
      {
        localMultiUserInfo = new VoIPProxy.MultiUserInfo();
        localMultiUserInfo.mMicOn = paramMultiUserInfo.mMicOn;
        localMultiUserInfo.mOpenId = paramMultiUserInfo.mOpenId;
        localMultiUserInfo.mUin = paramMultiUserInfo.mUin;
      }
      bkse.a(this.a).onUserEnter(localMultiUserInfo);
    }
  }
  
  public void a(QavDef.MultiUserInfo paramMultiUserInfo, boolean paramBoolean)
  {
    if (bkse.a(this.a) != null)
    {
      VoIPProxy.MultiUserInfo localMultiUserInfo = null;
      if (paramMultiUserInfo != null)
      {
        localMultiUserInfo = new VoIPProxy.MultiUserInfo();
        localMultiUserInfo.mMicOn = paramMultiUserInfo.mMicOn;
        localMultiUserInfo.mOpenId = paramMultiUserInfo.mOpenId;
        localMultiUserInfo.mUin = paramMultiUserInfo.mUin;
      }
      bkse.a(this.a).onUserAudioAvailable(localMultiUserInfo, paramBoolean);
    }
  }
  
  public void a(List<QavDef.MultiUserInfo> paramList)
  {
    if (bkse.a(this.a) != null)
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
      bkse.a(this.a).onUserUpdate(localArrayList);
    }
  }
  
  public void b(QavDef.MultiUserInfo paramMultiUserInfo)
  {
    if (bkse.a(this.a) != null)
    {
      VoIPProxy.MultiUserInfo localMultiUserInfo = null;
      if (paramMultiUserInfo != null)
      {
        localMultiUserInfo = new VoIPProxy.MultiUserInfo();
        localMultiUserInfo.mMicOn = paramMultiUserInfo.mMicOn;
        localMultiUserInfo.mOpenId = paramMultiUserInfo.mOpenId;
        localMultiUserInfo.mUin = paramMultiUserInfo.mUin;
      }
      bkse.a(this.a).onUserExit(localMultiUserInfo);
    }
  }
  
  public void b(QavDef.MultiUserInfo paramMultiUserInfo, boolean paramBoolean)
  {
    if (bkse.a(this.a) != null)
    {
      VoIPProxy.MultiUserInfo localMultiUserInfo = null;
      if (paramMultiUserInfo != null)
      {
        localMultiUserInfo = new VoIPProxy.MultiUserInfo();
        localMultiUserInfo.mMicOn = paramMultiUserInfo.mMicOn;
        localMultiUserInfo.mOpenId = paramMultiUserInfo.mOpenId;
        localMultiUserInfo.mUin = paramMultiUserInfo.mUin;
      }
      bkse.a(this.a).onUserSpeaking(localMultiUserInfo, paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bksg
 * JD-Core Version:    0.7.0.1
 */