package com.tencent.av.business.manager;

import android.text.TextUtils;
import com.tencent.av.AVLog;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.handler.SentenceInfo;
import com.tencent.av.business.manager.magicface.EffectFaceManager;
import com.tencent.av.business.manager.support.EffectSupportManager;
import com.tencent.av.business.manager.zimu.EffectZimuManager;
import com.tencent.av.business.manager.zimu.ZimuItem;
import com.tencent.av.ui.ControlUIObserver.ZimuRequest;
import com.tencent.av.ui.funchat.zimu.ZimuToolbar;
import com.tencent.av.utils.AudioHelper;
import com.tencent.av.utils.SeqUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.Observable;

public class BusinessMessageCenter
{
  private BusinessMessageCenter.MyDataObserver a;
  private VideoAppInterface b;
  
  public BusinessMessageCenter(VideoAppInterface paramVideoAppInterface)
  {
    this.b = paramVideoAppInterface;
    this.a = new BusinessMessageCenter.MyDataObserver(this);
    this.b.a(this.a);
  }
  
  private void a(String paramString, boolean paramBoolean)
  {
    int i = 0;
    while (i < 19)
    {
      if (this.b.d(i)) {
        this.b.c(i).a(paramString, paramBoolean);
      }
      i += 1;
    }
  }
  
  private void a(Observable paramObservable, Object paramObject)
  {
    Object localObject = (Object[])paramObject;
    int i = ((Integer)localObject[0]).intValue();
    if (i != 13)
    {
      if (i != 28)
      {
        if (i != 101)
        {
          if (i != 203)
          {
            if (i != 6009)
            {
              if (i != 6103) {
                return;
              }
              a(((Integer)localObject[1]).intValue(), (String)localObject[2]);
              return;
            }
            b(((Integer)localObject[1]).intValue(), (String)localObject[2]);
            return;
          }
          paramObservable = (String)localObject[1];
          bool = ((Boolean)localObject[2]).booleanValue();
          l1 = SeqUtil.a((Object[])localObject, 3);
          paramObject = this.b.b().k().s;
          long l2 = this.b.b().k().aN;
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("onSessionStatusChanged[END], eventPeerUin[");
          ((StringBuilder)localObject).append(paramObservable);
          ((StringBuilder)localObject).append("], isQuit[");
          ((StringBuilder)localObject).append(bool);
          ((StringBuilder)localObject).append("], curPeerUin[");
          ((StringBuilder)localObject).append(paramObject);
          ((StringBuilder)localObject).append("], relationId[");
          ((StringBuilder)localObject).append(l2);
          ((StringBuilder)localObject).append("]");
          QLog.w("BusinessMessageCenter", 1, ((StringBuilder)localObject).toString());
          if ((paramObject != null) && (!paramObject.equalsIgnoreCase(paramObservable))) {
            return;
          }
          a(l1, 3, null);
          return;
        }
        a(SeqUtil.a((Object[])localObject, 1), 2, null);
        return;
      }
      paramObject = (String)localObject[1];
      boolean bool = ((Boolean)localObject[2]).booleanValue();
      paramObservable = paramObject;
      if (TextUtils.isEmpty(paramObject)) {
        paramObservable = "";
      }
      a(paramObservable, bool);
      return;
    }
    long l1 = SeqUtil.a((Object[])localObject, 1);
    if (QLog.isColorLevel()) {
      QLog.w("BusinessMessageCenter", 1, "onSessionStatusChanged[Connected],");
    }
    a(l1, 1, null);
  }
  
  public int a(int paramInt, String paramString)
  {
    if (((paramInt == 3) || (paramInt == 1)) && (!((EffectSupportManager)this.b.c(5)).a(3, paramInt, paramString))) {
      ((EffectFaceManager)this.b.c(3)).a(paramInt, paramString);
    }
    return 0;
  }
  
  public int a(String paramString)
  {
    Object localObject2 = this;
    if (!TextUtils.isEmpty(paramString))
    {
      Object localObject3 = paramString.split("\\|");
      long l1 = 0L;
      EffectZimuManager localEffectZimuManager;
      if (localObject3.length > 0) {
        localEffectZimuManager = localObject3[0];
      } else {
        localEffectZimuManager = null;
      }
      if (localEffectZimuManager == null) {
        return 0;
      }
      Object localObject1;
      if (localObject3.length > 1) {
        localObject1 = localObject3[1];
      } else {
        localObject1 = null;
      }
      String str;
      if (localObject3.length > 2) {
        str = localObject3[2];
      } else {
        str = null;
      }
      if (localObject3.length > 3) {
        l1 = AudioHelper.c(localObject3[3]);
      }
      long l2 = AudioHelper.b();
      long l3 = AudioHelper.c();
      int i;
      if (localEffectZimuManager.startsWith("EMPTY_ITEM"))
      {
        if (ZimuToolbar.isSupport())
        {
          localEffectZimuManager = (EffectZimuManager)((BusinessMessageCenter)localObject2).b.c(0);
          localObject2 = (ZimuItem)localEffectZimuManager.c();
          if ((localObject2 != null) && (!TextUtils.isEmpty(((ZimuItem)localObject2).getId())))
          {
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("onReceivedChangingZimuOfPeer, 对方取消字幕, info[");
            ((StringBuilder)localObject3).append(paramString);
            ((StringBuilder)localObject3).append("], sessionid[");
            ((StringBuilder)localObject3).append((String)localObject1);
            ((StringBuilder)localObject3).append("], cmdSeq[");
            ((StringBuilder)localObject3).append(str);
            ((StringBuilder)localObject3).append("], seq[");
            ((StringBuilder)localObject3).append(l3);
            ((StringBuilder)localObject3).append("], sendTime[");
            ((StringBuilder)localObject3).append(l1);
            ((StringBuilder)localObject3).append("], offset[");
            ((StringBuilder)localObject3).append(l2 - l1);
            ((StringBuilder)localObject3).append("], isTranslation[");
            ((StringBuilder)localObject3).append(localEffectZimuManager.l());
            ((StringBuilder)localObject3).append("], cur[");
            ((StringBuilder)localObject3).append(((ZimuItem)localObject2).getId());
            ((StringBuilder)localObject3).append("]");
            QLog.w("BusinessMessageCenter", 1, ((StringBuilder)localObject3).toString());
            paramString = this;
            localObject1 = (EffectZimuManager)paramString.b.c(0);
            ((EffectZimuManager)localObject1).a("onReceivedChangingZimuOfPeer", l3);
            new ControlUIObserver.ZimuRequest(l3, "onReceivedChangingZimuOfPeer", 3, "0").a(paramString.b);
            ((EffectZimuManager)localObject1).a(l3, null);
            paramString.a(Integer.valueOf(6010), Integer.valueOf(1));
            i = 1;
          }
          else
          {
            i = 0;
          }
          this.b.e(0);
          return i;
        }
      }
      else if (ZimuToolbar.isSupport())
      {
        localObject3 = (EffectZimuManager)((BusinessMessageCenter)localObject2).b.c(0);
        ZimuItem localZimuItem = (ZimuItem)((EffectZimuManager)localObject3).b(localEffectZimuManager);
        localObject2 = (ZimuItem)((EffectZimuManager)localObject3).c();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onReceivedChangingZimuOfPeer, 对方选择字幕, info[");
        localStringBuilder.append(paramString);
        localStringBuilder.append("], zimuId[");
        localStringBuilder.append(localEffectZimuManager);
        localStringBuilder.append("], sessionid[");
        localStringBuilder.append((String)localObject1);
        localStringBuilder.append("], cmdSeq[");
        localStringBuilder.append(str);
        localStringBuilder.append("], seq[");
        localStringBuilder.append(l3);
        localStringBuilder.append("], sendTime[");
        localStringBuilder.append(l1);
        localStringBuilder.append("], offset[");
        localStringBuilder.append(l2 - l1);
        localStringBuilder.append("], isTranslation[");
        localStringBuilder.append(((EffectZimuManager)localObject3).l());
        localStringBuilder.append("], ZimuItem[");
        localStringBuilder.append(localZimuItem);
        localStringBuilder.append("], CurItem[");
        localStringBuilder.append(localObject2);
        localStringBuilder.append("]");
        QLog.w("BusinessMessageCenter", 1, localStringBuilder.toString());
        if (localZimuItem != null)
        {
          boolean bool;
          if (localObject2 == null) {
            bool = false;
          } else {
            bool = ((ZimuItem)localObject2).getId().equalsIgnoreCase(localZimuItem.getId());
          }
          if (!bool)
          {
            ((EffectZimuManager)localObject3).a("onReceivedChangingZimuOfPeer", false, l3, (String)localObject1);
            ((EffectZimuManager)localObject3).a(l3, localEffectZimuManager);
            if (!localZimuItem.isUsable()) {
              ((EffectZimuManager)localObject3).b(l3, localZimuItem);
            }
            i = 2;
            localObject1 = new ControlUIObserver.ZimuRequest(l3, "onReceivedChangingZimuOfPeer", 1, localEffectZimuManager);
            paramString = this;
            ((ControlUIObserver.ZimuRequest)localObject1).a(paramString.b);
            if (localObject2 == null) {
              i = 3;
            }
            paramString.a(Integer.valueOf(6010), Integer.valueOf(i));
            j = i;
            if (EffectZimuManager.a(paramString.b)) {
              break label808;
            }
            paramString.a(Integer.valueOf(6012), Integer.valueOf(i));
            j = i;
            break label808;
          }
        }
        int j = 0;
        label808:
        this.b.e(0);
        return j;
      }
    }
    return 0;
  }
  
  public void a(long paramLong, int paramInt, String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.b.b().as());
    ((StringBuilder)localObject).append("");
    localObject = ((StringBuilder)localObject).toString();
    int i = 0;
    while (i < 19)
    {
      if (this.b.d(i)) {
        this.b.c(i).a(paramLong, paramInt, (String)localObject, paramString);
      }
      i += 1;
    }
  }
  
  protected void a(Integer paramInteger, Object paramObject)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("notifyEvent :");
    localStringBuilder.append(paramInteger);
    localStringBuilder.append("|");
    localStringBuilder.append(paramObject);
    AVLog.printColorLog("BusinessMessageCenter", localStringBuilder.toString());
    this.b.a(new Object[] { paramInteger, paramObject });
  }
  
  public int b(int paramInt, String paramString)
  {
    if ((paramInt != 7) && (paramInt != 12))
    {
      if (paramInt != 13) {
        return 0;
      }
      if (!((EffectSupportManager)this.b.c(5)).a(0, paramInt, paramString))
      {
        String str = paramString;
        if (paramString.equals("。")) {
          str = "。 ";
        }
        paramString = new SentenceInfo(this.b.b().k().s, str, str, 2);
        paramString.e = true;
        a(Integer.valueOf(6008), paramString);
        return 0;
      }
    }
    else if (!((EffectSupportManager)this.b.c(5)).a(0, paramInt, paramString))
    {
      a(paramString);
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.business.manager.BusinessMessageCenter
 * JD-Core Version:    0.7.0.1
 */