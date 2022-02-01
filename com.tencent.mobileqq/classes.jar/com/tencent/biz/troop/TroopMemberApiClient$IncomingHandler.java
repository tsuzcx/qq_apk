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
import com.tencent.mobileqq.app.TroopBusinessObserver;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.studyroom.upload.StudyRoomPicUploadUtil;
import com.tencent.mobileqq.troop.api.ITroopObserver;
import com.tencent.mobileqq.troop.api.observer.TroopObserver;
import com.tencent.mobileqq.troop.observer.TroopApiObserver;
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
    if (paramMessage == null) {}
    Bundle localBundle;
    int i;
    boolean bool;
    int j;
    Iterator localIterator;
    label618:
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            localBundle = paramMessage.getData();
          } while (localBundle == null);
          localBundle.setClassLoader(MobileQQ.sMobileQQ.getClassLoader());
          i = localBundle.getInt("seq", -1);
          switch (paramMessage.what)
          {
          }
        } while (i == -1);
        paramMessage = (TroopMemberApiClient.Callback)this.a.jdField_a_of_type_JavaUtilMap.remove(Integer.valueOf(i));
      } while (paramMessage == null);
      paramMessage.callback(localBundle);
      return;
      i = localBundle.getInt("type");
      bool = localBundle.getBoolean("isSuccess", false);
      paramMessage = localBundle.getSerializable("data");
      j = localBundle.getInt("observer_type");
      localIterator = this.a.jdField_a_of_type_JavaUtilList.iterator();
    } while (!localIterator.hasNext());
    BusinessObserver localBusinessObserver = (BusinessObserver)localIterator.next();
    Object localObject;
    if (((j == 1) && ((localBusinessObserver instanceof LBSObserver))) || ((j == 2) && ((localBusinessObserver instanceof FriendListObserver)))) {
      if (28 == i)
      {
        localObject = localBundle.getByteArray("groupInfo");
        paramMessage = new cmd0x7f5.GroupInfo();
        if (localObject == null) {
          break label2386;
        }
      }
    }
    label2386:
    for (;;)
    {
      try
      {
        paramMessage.mergeFrom((byte[])localObject);
        localObject = new Object[2];
        localObject[0] = Integer.valueOf(localBundle.getInt("count"));
        localObject[1] = paramMessage;
        paramMessage = (Message)localObject;
        localBusinessObserver.onUpdate(i, bool, paramMessage);
      }
      catch (InvalidProtocolBufferMicroException paramMessage)
      {
        paramMessage.printStackTrace();
        paramMessage = null;
        continue;
      }
      if ((j == 3) && ((localBusinessObserver instanceof TroopObserver)))
      {
        ((TroopObserver)localBusinessObserver).onUpdate(i, bool, paramMessage);
        break label618;
      }
      if ((j == 6) && ((localBusinessObserver instanceof TroopBusinessObserver)))
      {
        ((TroopBusinessObserver)localBusinessObserver).onUpdate(i, bool, paramMessage);
        break label618;
      }
      if ((j == 7) && ((localBusinessObserver instanceof TroopApiObserver)))
      {
        ((TroopApiObserver)localBusinessObserver).onUpdate(i, bool, paramMessage);
        break label618;
      }
      if ((j == 4) && ((localBusinessObserver instanceof BizTroopObserver)))
      {
        ((BizTroopObserver)localBusinessObserver).onUpdate(i, bool, paramMessage);
        break label618;
      }
      if ((j == 5) && ((localBusinessObserver instanceof HotChatObserver)))
      {
        ((HotChatObserver)localBusinessObserver).onUpdate(i, bool, paramMessage);
        break label618;
      }
      if ((j != 8) || (!(localBusinessObserver instanceof ITroopObserver))) {
        break label618;
      }
      ((ITroopObserver)localBusinessObserver).onUpdate(i, bool, paramMessage);
      break label618;
      if (i == -1) {
        break;
      }
      paramMessage = (TroopMemberApiClient.Callback)this.a.jdField_a_of_type_JavaUtilMap.remove(Integer.valueOf(i));
      if (paramMessage == null) {
        break;
      }
      paramMessage.callback(localBundle);
      return;
      if (i != -1)
      {
        j = localBundle.getInt("retCode", -1);
        int k = localBundle.getInt("rate", -1);
        paramMessage = (TroopMemberApiClient.Callback)this.a.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(i));
        if (paramMessage != null)
        {
          paramMessage.callback(localBundle);
          if ((j != 0) || (k == 100))
          {
            QLog.d("ReadInJoy", 4, "download finish:" + localBundle);
            this.a.jdField_a_of_type_JavaUtilMap.remove(Integer.valueOf(i));
          }
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("readinjoy", 4, "client MSG_READINJOY_LOAD_SKIN retCode=" + j + ",rate=" + k);
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
      QLog.d("readinjoy", 4, "client MSG_READINJOY_LOAD_SKIN seq=" + i);
      return;
      if (this.a.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver == null) {
        break;
      }
      paramMessage = localBundle.getString("pageUrl");
      localObject = localBundle.getStringArrayList("lstVideoUrl");
      i = localBundle.getInt("totalTime", 0);
      this.a.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver.onUpdate(localBundle.getInt("type"), true, new Object[] { paramMessage, localObject, Integer.valueOf(i) });
      return;
      this.a.a().a(localBundle);
      return;
      this.a.a().a(localBundle);
      return;
      localObject = (BusinessObserver)this.a.jdField_a_of_type_AndroidUtilSparseArray.get(localBundle.getInt("req_seq"));
      if (localObject == null) {
        break;
      }
      this.a.jdField_a_of_type_AndroidUtilSparseArray.remove(localBundle.getInt("req_seq"));
      ((BusinessObserver)localObject).onUpdate(paramMessage.what, true, localBundle);
      return;
      if (localBundle == null) {
        break;
      }
      i = localBundle.getInt("seq1", -1);
      if (i == -1) {
        break;
      }
      paramMessage = (TroopMemberApiClient.Callback)this.a.jdField_a_of_type_JavaUtilMap.remove(Integer.valueOf(i));
      if (paramMessage == null) {
        break;
      }
      paramMessage.callback(localBundle);
      return;
      if (localBundle == null) {
        break;
      }
      i = localBundle.getInt("seq", -1);
      if (i == -1) {
        break;
      }
      paramMessage = (TroopMemberApiClient.Callback)this.a.jdField_a_of_type_JavaUtilMap.remove(Integer.valueOf(i));
      if (paramMessage == null) {
        break;
      }
      paramMessage.callback(localBundle);
      return;
      if (localBundle == null) {
        break;
      }
      i = localBundle.getInt("seq1", -1);
      if (i == -1) {
        break;
      }
      paramMessage = (TroopMemberApiClient.Callback)this.a.jdField_a_of_type_JavaUtilMap.remove(Integer.valueOf(i));
      if (paramMessage == null) {
        break;
      }
      paramMessage.callback(localBundle);
      return;
      if (localBundle == null) {
        break;
      }
      i = localBundle.getInt("seq", -1);
      if (i == -1) {
        break;
      }
      paramMessage = (TroopMemberApiClient.Callback)this.a.jdField_a_of_type_JavaUtilMap.remove(Integer.valueOf(i));
      if (paramMessage == null) {
        break;
      }
      paramMessage.callback(localBundle);
      return;
      paramMessage = (TroopMemberApiClient.Callback)this.a.jdField_a_of_type_JavaUtilMap.remove(Integer.valueOf(i));
      if ((i == -1) || (paramMessage == null)) {
        break;
      }
      paramMessage.callback(localBundle);
      return;
      if (localBundle == null) {
        break;
      }
      i = localBundle.getInt("seq", -1);
      if (i == -1) {
        break;
      }
      paramMessage = (TroopMemberApiClient.Callback)this.a.jdField_a_of_type_JavaUtilMap.remove(Integer.valueOf(i));
      if (paramMessage == null) {
        break;
      }
      paramMessage.callback(localBundle);
      return;
      if (i == -1) {
        break;
      }
      paramMessage = (TroopMemberApiClient.Callback)this.a.jdField_a_of_type_JavaUtilMap.remove(Integer.valueOf(i));
      if (paramMessage == null) {
        break;
      }
      paramMessage.callback(localBundle);
      return;
      paramMessage = localBundle.getString("FileName");
      i = localBundle.getInt("Status");
      if ((TroopMemberApiClient.a(this.a) == null) || (paramMessage == null) || (TroopMemberApiClient.a(this.a).get(paramMessage) == null)) {
        break;
      }
      j = ((Integer)TroopMemberApiClient.a(this.a).get(paramMessage)).intValue();
      if (j == -1) {
        break;
      }
      paramMessage = (TroopMemberApiClient.Callback)this.a.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(j));
      if (paramMessage == null) {
        break;
      }
      paramMessage.callback(localBundle);
      if (i != 11) {
        break;
      }
      this.a.jdField_a_of_type_JavaUtilMap.remove(Integer.valueOf(j));
      return;
      paramMessage = localBundle.getString("FilePath");
      i = localBundle.getInt("size");
      localObject = paramMessage + "/" + i;
      if ((TroopMemberApiClient.b(this.a) == null) || (paramMessage == null) || (TroopMemberApiClient.b(this.a).get(localObject) == null)) {
        break;
      }
      i = ((Integer)TroopMemberApiClient.b(this.a).get(localObject)).intValue();
      if (i == -1) {
        break;
      }
      paramMessage = (TroopMemberApiClient.Callback)this.a.jdField_a_of_type_JavaUtilMap.remove(Integer.valueOf(i));
      if (paramMessage == null) {
        break;
      }
      paramMessage.callback(localBundle);
      return;
      if (i == -1) {
        break;
      }
      paramMessage = (TroopMemberApiClient.Callback)this.a.jdField_a_of_type_JavaUtilMap.remove(Integer.valueOf(i));
      if (paramMessage == null) {
        break;
      }
      paramMessage.callback(localBundle);
      return;
      if (i == -1) {
        break;
      }
      paramMessage = (TroopMemberApiClient.Callback)this.a.jdField_a_of_type_JavaUtilMap.remove(Integer.valueOf(i));
      if (paramMessage == null) {
        break;
      }
      paramMessage.callback(localBundle);
      return;
      if (i == -1) {
        break;
      }
      paramMessage = (TroopMemberApiClient.Callback)this.a.jdField_a_of_type_JavaUtilMap.remove(Integer.valueOf(i));
      if (paramMessage == null) {
        break;
      }
      paramMessage.callback(localBundle);
      return;
      paramMessage = (TroopMemberApiClient.Callback)this.a.jdField_a_of_type_JavaUtilMap.remove(Integer.valueOf(i));
      if (paramMessage == null) {
        break;
      }
      paramMessage.callback(localBundle);
      return;
      if (TroopMemberApiClient.a(this.a) == null) {
        break;
      }
      TroopMemberApiClient.a(this.a).callback(localBundle);
      return;
      if (TroopMemberApiClient.a(this.a) == null) {
        break;
      }
      TroopMemberApiClient.a(this.a).callback(localBundle);
      return;
      if (i == -1) {
        break;
      }
      paramMessage = (TroopMemberApiClient.Callback)this.a.jdField_a_of_type_JavaUtilMap.remove(Integer.valueOf(i));
      if (paramMessage == null) {
        break;
      }
      paramMessage.callback(localBundle);
      return;
      if (i == -1) {
        break;
      }
      paramMessage = (TroopMemberApiClient.Callback)this.a.jdField_a_of_type_JavaUtilMap.remove(Integer.valueOf(i));
      if (paramMessage == null) {
        break;
      }
      localBundle.putString("type", "troopCreateOpenAIO");
      paramMessage.callback(localBundle);
      return;
      if (i == -1) {
        break;
      }
      paramMessage = (TroopMemberApiClient.Callback)this.a.jdField_a_of_type_JavaUtilMap.remove(Integer.valueOf(i));
      if (paramMessage == null) {
        break;
      }
      localBundle.putBoolean("isSuccess", localBundle.getBoolean("isSuccess"));
      paramMessage.callback(localBundle);
      return;
      if (i == -1) {
        break;
      }
      paramMessage = (TroopMemberApiClient.Callback)this.a.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(i));
      if ((paramMessage == null) || (localBundle == null)) {
        break;
      }
      paramMessage.callback(localBundle);
      return;
      if (i == -1) {
        break;
      }
      this.a.jdField_a_of_type_JavaUtilMap.remove(Integer.valueOf(i));
      return;
      if (i == -1) {
        break;
      }
      if (StudyRoomPicUploadUtil.a(localBundle)) {}
      for (paramMessage = (TroopMemberApiClient.Callback)this.a.jdField_a_of_type_JavaUtilMap.remove(Integer.valueOf(i)); paramMessage != null; paramMessage = (TroopMemberApiClient.Callback)this.a.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(i)))
      {
        paramMessage.callback(localBundle);
        return;
      }
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.troop.TroopMemberApiClient.IncomingHandler
 * JD-Core Version:    0.7.0.1
 */