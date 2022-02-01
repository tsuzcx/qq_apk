package com.tencent.biz.troop;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.SparseArray;
import com.tencent.biz.apiproxy.QQMusicClient;
import com.tencent.biz.apiproxy.WebPushClient;
import com.tencent.mobileqq.app.BizTroopObserver;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.HotChatObserver;
import com.tencent.mobileqq.app.LBSObserver;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.studyroom.api.IStudyRoomUploader;
import com.tencent.mobileqq.troop.api.ITroopMemberApiClientApi.Callback;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.app.MobileQQ;
import tencent.im.oidb.cmd0x7f5.cmd0x7f5.GroupInfo;

class TroopMemberApiClient$IncomingHandler
  extends Handler
{
  public TroopMemberApiClient$IncomingHandler(TroopMemberApiClient paramTroopMemberApiClient)
  {
    super(Looper.getMainLooper());
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage == null) {
      return;
    }
    Bundle localBundle = paramMessage.getData();
    if (localBundle == null) {
      return;
    }
    localBundle.setClassLoader(MobileQQ.sMobileQQ.getClassLoader());
    int i = localBundle.getInt("seq", -1);
    int j = paramMessage.what;
    Object localObject;
    if (j != 3)
    {
      if (j != 5)
      {
        if (j != 7) {
          if (j != 8)
          {
            if ((j == 28) || (j == 29) || (j == 43) || (j == 44) || (j == 75) || (j == 76)) {
              break label1969;
            }
            if (j != 80)
            {
              if ((j == 81) || (j == 86) || (j == 87)) {
                break label1969;
              }
              if (j != 90) {
                if (j == 91) {}
              }
            }
          }
        }
        switch (j)
        {
        default: 
          switch (j)
          {
          default: 
            switch (j)
            {
            default: 
              if (i == -1) {
                break;
              }
              paramMessage = (ITroopMemberApiClientApi.Callback)this.a.h.remove(Integer.valueOf(i));
              if (paramMessage == null) {
                break;
              }
              paramMessage.callback(localBundle);
              return;
            case 61: 
              if (i == -1) {
                break;
              }
              paramMessage = (ITroopMemberApiClientApi.Callback)this.a.h.remove(Integer.valueOf(i));
              if (paramMessage == null) {
                break;
              }
              paramMessage.callback(localBundle);
              return;
            case 58: 
              paramMessage = localBundle.getString("FilePath");
              i = localBundle.getInt("size");
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append(paramMessage);
              ((StringBuilder)localObject).append("/");
              ((StringBuilder)localObject).append(i);
              localObject = ((StringBuilder)localObject).toString();
              if ((TroopMemberApiClient.b(this.a) == null) || (paramMessage == null) || (TroopMemberApiClient.b(this.a).get(localObject) == null)) {
                break;
              }
              i = ((Integer)TroopMemberApiClient.b(this.a).get(localObject)).intValue();
              if (i == -1) {
                break;
              }
              paramMessage = (ITroopMemberApiClientApi.Callback)this.a.h.remove(Integer.valueOf(i));
              if (paramMessage == null) {
                break;
              }
              paramMessage.callback(localBundle);
              return;
            case 57: 
              paramMessage = localBundle.getString("FileName");
              i = localBundle.getInt("Status");
              if ((TroopMemberApiClient.a(this.a) == null) || (paramMessage == null) || (TroopMemberApiClient.a(this.a).get(paramMessage) == null)) {
                break;
              }
              j = ((Integer)TroopMemberApiClient.a(this.a).get(paramMessage)).intValue();
              if (j == -1) {
                break;
              }
              paramMessage = (ITroopMemberApiClientApi.Callback)this.a.h.get(Integer.valueOf(j));
              if (paramMessage == null) {
                break;
              }
              paramMessage.callback(localBundle);
              if (i != 11) {
                break;
              }
              this.a.h.remove(Integer.valueOf(j));
              return;
            case 56: 
              if (i == -1) {
                break;
              }
              paramMessage = (ITroopMemberApiClientApi.Callback)this.a.h.remove(Integer.valueOf(i));
              if (paramMessage == null) {
                break;
              }
              paramMessage.callback(localBundle);
              return;
            }
            break;
          case 26: 
            if (localBundle == null) {
              break;
            }
            i = localBundle.getInt("seq", -1);
            if (i == -1) {
              break;
            }
            paramMessage = (ITroopMemberApiClientApi.Callback)this.a.h.remove(Integer.valueOf(i));
            if (paramMessage == null) {
              break;
            }
            paramMessage.callback(localBundle);
            return;
          case 25: 
            if (localBundle == null) {
              break;
            }
            i = localBundle.getInt("seq1", -1);
            if (i == -1) {
              break;
            }
            paramMessage = (ITroopMemberApiClientApi.Callback)this.a.h.remove(Integer.valueOf(i));
            if (paramMessage == null) {
              break;
            }
            paramMessage.callback(localBundle);
            return;
          case 24: 
            if (localBundle == null) {
              break;
            }
            i = localBundle.getInt("seq", -1);
            if (i == -1) {
              break;
            }
            paramMessage = (ITroopMemberApiClientApi.Callback)this.a.h.remove(Integer.valueOf(i));
            if (paramMessage == null) {
              break;
            }
            paramMessage.callback(localBundle);
            return;
          case 23: 
            if (localBundle == null) {
              break;
            }
            i = localBundle.getInt("seq1", -1);
            if (i == -1) {
              break;
            }
            paramMessage = (ITroopMemberApiClientApi.Callback)this.a.h.remove(Integer.valueOf(i));
            if (paramMessage == null) {
              break;
            }
            paramMessage.callback(localBundle);
            return;
          }
          break;
        case 166: 
          paramMessage = (ITroopMemberApiClientApi.Callback)this.a.h.get(Integer.valueOf(i));
          if (paramMessage == null) {
            break;
          }
          paramMessage.callback(localBundle);
          return;
        case 158: 
          if (i == -1) {
            return;
          }
          if (((IStudyRoomUploader)QRoute.api(IStudyRoomUploader.class)).isPicUploadEnd(localBundle)) {
            paramMessage = (ITroopMemberApiClientApi.Callback)this.a.h.remove(Integer.valueOf(i));
          } else {
            paramMessage = (ITroopMemberApiClientApi.Callback)this.a.h.get(Integer.valueOf(i));
          }
          if (paramMessage == null) {
            break;
          }
          paramMessage.callback(localBundle);
          return;
        case 147: 
          this.a.c().a(localBundle);
          return;
        case 138: 
          if (i == -1) {
            break;
          }
          this.a.h.remove(Integer.valueOf(i));
          return;
        case 134: 
        case 135: 
        case 136: 
        case 137: 
          if (i == -1) {
            break;
          }
          paramMessage = (ITroopMemberApiClientApi.Callback)this.a.h.get(Integer.valueOf(i));
          if ((paramMessage == null) || (localBundle == null)) {
            break;
          }
          paramMessage.callback(localBundle);
          return;
        case 122: 
          if (i == -1) {
            break;
          }
          paramMessage = (ITroopMemberApiClientApi.Callback)this.a.h.remove(Integer.valueOf(i));
          if (paramMessage == null) {
            break;
          }
          localBundle.putBoolean("isSuccess", localBundle.getBoolean("isSuccess"));
          paramMessage.callback(localBundle);
          return;
        case 113: 
          if (i == -1) {
            break;
          }
          paramMessage = (ITroopMemberApiClientApi.Callback)this.a.h.remove(Integer.valueOf(i));
          if (paramMessage == null) {
            break;
          }
          paramMessage.callback(localBundle);
          return;
        case 112: 
          if (i == -1) {
            break;
          }
          paramMessage = (ITroopMemberApiClientApi.Callback)this.a.h.remove(Integer.valueOf(i));
          if (paramMessage == null) {
            break;
          }
          localBundle.putString("type", "troopCreateOpenAIO");
          paramMessage.callback(localBundle);
          return;
        case 107: 
          if (i != -1)
          {
            j = localBundle.getInt("retCode", -1);
            int k = localBundle.getInt("rate", -1);
            paramMessage = (ITroopMemberApiClientApi.Callback)this.a.h.get(Integer.valueOf(i));
            if (paramMessage != null)
            {
              paramMessage.callback(localBundle);
              if ((j != 0) || (k == 100))
              {
                paramMessage = new StringBuilder();
                paramMessage.append("download finish:");
                paramMessage.append(localBundle);
                QLog.d("ReadInJoy", 4, paramMessage.toString());
                this.a.h.remove(Integer.valueOf(i));
              }
              if (!QLog.isColorLevel()) {
                break;
              }
              paramMessage = new StringBuilder();
              paramMessage.append("client MSG_READINJOY_LOAD_SKIN retCode=");
              paramMessage.append(j);
              paramMessage.append(",rate=");
              paramMessage.append(k);
              QLog.d("readinjoy", 4, paramMessage.toString());
              return;
            }
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d("readinjoy", 4, "client MSG_READINJOY_LOAD_SKIN callback null");
            return;
          }
          if (!QLog.isColorLevel()) {
            break;
          }
          paramMessage = new StringBuilder();
          paramMessage.append("client MSG_READINJOY_LOAD_SKIN seq=");
          paramMessage.append(i);
          QLog.d("readinjoy", 4, paramMessage.toString());
          return;
        case 101: 
          if (i == -1) {
            break;
          }
          paramMessage = (ITroopMemberApiClientApi.Callback)this.a.h.remove(Integer.valueOf(i));
          if (paramMessage == null) {
            break;
          }
          paramMessage.callback(localBundle);
          return;
        case 66: 
          if (i == -1) {
            break;
          }
          paramMessage = (ITroopMemberApiClientApi.Callback)this.a.h.remove(Integer.valueOf(i));
          if (paramMessage == null) {
            break;
          }
          paramMessage.callback(localBundle);
          return;
        case 52: 
          if (localBundle == null) {
            break;
          }
          i = localBundle.getInt("seq", -1);
          if (i == -1) {
            break;
          }
          paramMessage = (ITroopMemberApiClientApi.Callback)this.a.h.remove(Integer.valueOf(i));
          if (paramMessage == null) {
            break;
          }
          paramMessage.callback(localBundle);
          return;
        case 33: 
          paramMessage = (ITroopMemberApiClientApi.Callback)this.a.h.remove(Integer.valueOf(i));
          if ((i == -1) || (paramMessage == null)) {
            break;
          }
          paramMessage.callback(localBundle);
          return;
        case 16: 
        case 17: 
        case 18: 
          localObject = (BusinessObserver)this.a.m.get(localBundle.getInt("req_seq"));
          if (localObject != null)
          {
            this.a.m.remove(localBundle.getInt("req_seq"));
            ((BusinessObserver)localObject).onUpdate(paramMessage.what, true, localBundle);
            return;
          }
          return;
          if (TroopMemberApiClient.c(this.a) == null) {
            break;
          }
          TroopMemberApiClient.c(this.a).callback(localBundle);
          return;
          if (TroopMemberApiClient.c(this.a) == null) {
            break;
          }
          TroopMemberApiClient.c(this.a).callback(localBundle);
          return;
          paramMessage = (ITroopMemberApiClientApi.Callback)this.a.h.remove(Integer.valueOf(i));
          if (paramMessage == null) {
            break;
          }
          paramMessage.callback(localBundle);
          return;
          this.a.b().a(localBundle);
          return;
        case 11: 
        case 13: 
        case 14: 
        case 15: 
        case 19: 
        case 20: 
        case 46: 
        case 72: 
        case 84: 
        case 102: 
        case 108: 
        case 109: 
        case 110: 
        case 154: 
        case 155: 
        case 164: 
          label1969:
          if (i == -1) {
            break;
          }
          paramMessage = (ITroopMemberApiClientApi.Callback)this.a.h.remove(Integer.valueOf(i));
          if (paramMessage == null) {
            break;
          }
          paramMessage.callback(localBundle);
          return;
        }
      }
      else if (this.a.n != null)
      {
        paramMessage = localBundle.getString("pageUrl");
        localObject = localBundle.getStringArrayList("lstVideoUrl");
        i = localBundle.getInt("totalTime", 0);
        this.a.n.onUpdate(localBundle.getInt("type"), true, new Object[] { paramMessage, localObject, Integer.valueOf(i) });
      }
    }
    else
    {
      i = localBundle.getInt("type");
      boolean bool = localBundle.getBoolean("isSuccess", false);
      paramMessage = localBundle.getSerializable("data");
      j = localBundle.getInt("observer_type", -1);
      String str2 = localBundle.getString("observerClassName");
      Iterator localIterator = this.a.e.iterator();
      if (localIterator.hasNext())
      {
        BusinessObserver localBusinessObserver = (BusinessObserver)localIterator.next();
        if (((j == 1) && ((localBusinessObserver instanceof LBSObserver))) || ((j == 2) && ((localBusinessObserver instanceof FriendListObserver))))
        {
          if (28 == i)
          {
            byte[] arrayOfByte = localBundle.getByteArray("groupInfo");
            localObject = new cmd0x7f5.GroupInfo();
            paramMessage = (Message)localObject;
            if (arrayOfByte != null) {
              try
              {
                ((cmd0x7f5.GroupInfo)localObject).mergeFrom(arrayOfByte);
                paramMessage = (Message)localObject;
              }
              catch (InvalidProtocolBufferMicroException paramMessage)
              {
                paramMessage.printStackTrace();
                paramMessage = null;
              }
            }
            localObject = new Object[2];
            localObject[0] = Integer.valueOf(localBundle.getInt("count"));
            localObject[1] = paramMessage;
            paramMessage = (Message)localObject;
          }
          localBusinessObserver.onUpdate(i, bool, paramMessage);
        }
        for (;;)
        {
          break;
          if ((j == 5) && ((localBusinessObserver instanceof HotChatObserver)))
          {
            ((HotChatObserver)localBusinessObserver).onUpdate(i, bool, paramMessage);
          }
          else
          {
            String str1;
            try
            {
              localObject = localBusinessObserver.getClass().getSuperclass().getName();
            }
            catch (Exception localException)
            {
              localException.printStackTrace();
              str1 = "";
            }
            if ((str2 == null) || (!str2.equals(str1))) {
              break;
            }
            localBusinessObserver.onUpdate(i, bool, paramMessage);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.troop.TroopMemberApiClient.IncomingHandler
 * JD-Core Version:    0.7.0.1
 */