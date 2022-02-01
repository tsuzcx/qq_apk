package com.tencent.av.random;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.av.VideoController;
import com.tencent.av.VideoController.GAudioFriends;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.SessionInfo.Anychat_Info;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

class RandomController$1
  implements RandomWebProtocol.OnRequestListener
{
  RandomController$1(RandomController paramRandomController) {}
  
  public void a(int paramInt, RandomWebProtocol.Response paramResponse)
  {
    if (this.a.jdField_a_of_type_ComTencentAvAppSessionInfo == null) {}
    label517:
    label1010:
    do
    {
      do
      {
        do
        {
          for (;;)
          {
            return;
            if (QLog.isColorLevel()) {
              QLog.d("RandomController", 2, "rsp.rsptype = " + paramResponse.a + ", errCode = " + paramInt);
            }
            if ((paramResponse.a == 1) || (paramResponse.a == 2))
            {
              switch (paramInt)
              {
              case -2: 
              default: 
                RandomController.b(this.a);
                return;
              case 1: 
                if (RandomController.a(this.a).get() >= 3)
                {
                  RandomController.a(this.a);
                  return;
                }
                paramResponse = (RandomWebProtocol.RspDouble)paramResponse;
                RandomController.a(this.a).a(paramResponse);
                RandomController.a(this.a).a().postDelayed(RandomController.a(this.a), paramResponse.h);
                return;
              case 0: 
                RandomController.a(this.a, paramResponse);
                return;
              case -1: 
                RandomController.a(this.a);
                return;
              }
              RandomController.b(this.a, paramResponse);
              return;
            }
            if ((paramResponse.a == -100) || (paramResponse.a == 3))
            {
              if (RandomController.a(this.a) == 1)
              {
                if ((paramInt == 0) && ((paramResponse instanceof RandomWebProtocol.RspDoublePull)))
                {
                  paramResponse = (RandomWebProtocol.RspDoublePull)paramResponse;
                  this.a.jdField_a_of_type_ComTencentAvAppSessionInfo.a.a = paramResponse.a;
                  if (this.a.jdField_a_of_type_ComTencentAvAppSessionInfo.l())
                  {
                    paramResponse = RandomController.a(this.a).iterator();
                    while (paramResponse.hasNext()) {
                      ((RandomController.RandomListener)paramResponse.next()).a();
                    }
                  }
                }
              }
              else if (RandomController.a(this.a) == 2)
              {
                Object localObject2;
                Object localObject1;
                if ((paramInt == 0) && ((paramResponse instanceof RandomWebProtocol.RspMultiPull)))
                {
                  localObject2 = (RandomWebProtocol.RspMultiPull)paramResponse;
                  if (((RandomWebProtocol.RspMultiPull)localObject2).f != 0) {
                    if (((RandomWebProtocol.RspMultiPull)localObject2).f != 2) {
                      break label517;
                    }
                  }
                  for (localObject1 = ((RandomWebProtocol.RspMultiPull)localObject2).e;; localObject1 = String.valueOf(((RandomWebProtocol.RspMultiPull)localObject2).jdField_a_of_type_Long))
                  {
                    if (!TextUtils.isEmpty((CharSequence)localObject1))
                    {
                      VideoController.GAudioFriends localGAudioFriends = RandomController.a(this.a).a((String)localObject1);
                      if (localGAudioFriends != null)
                      {
                        localGAudioFriends.c = ((RandomWebProtocol.RspMultiPull)localObject2).c;
                        RandomController.a(this.a).a((String)localObject1, ((RandomWebProtocol.RspMultiPull)localObject2).b, ((RandomWebProtocol.RspMultiPull)localObject2).c);
                        if (QLog.isColorLevel()) {
                          QLog.d("RandomController", 2, "RSP_MULTI_PULL uin:" + localGAudioFriends.jdField_a_of_type_Long + ", headUrl:" + localGAudioFriends.c);
                        }
                      }
                    }
                    localObject1 = RandomController.a(this.a).iterator();
                    while (((Iterator)localObject1).hasNext()) {
                      ((RandomController.RandomListener)((Iterator)localObject1).next()).a();
                    }
                  }
                }
                if (paramInt == 100)
                {
                  localObject2 = RandomController.a(this.a).c();
                  localObject1 = new StringBuilder();
                  localObject2 = ((ArrayList)localObject2).iterator();
                  while (((Iterator)localObject2).hasNext()) {
                    ((StringBuilder)localObject1).append(((VideoController.GAudioFriends)((Iterator)localObject2).next()).jdField_a_of_type_Long).append("|");
                  }
                  if ((!this.a.jdField_b_of_type_Boolean) && (RandomController.a(this.a) != null)) {
                    RandomController.a(this.a).a(RandomController.b(this.a), 5, ((StringBuilder)localObject1).toString(), this.a.a(RandomController.a(this.a).getAccount()), this.a.jdField_a_of_type_Long);
                  }
                }
                if ((paramResponse instanceof RandomWebProtocol.RspMultiPull))
                {
                  paramResponse = (RandomWebProtocol.RspMultiPull)paramResponse;
                  if ((!TextUtils.isEmpty(paramResponse.d)) && (TextUtils.isEmpty(this.a.jdField_a_of_type_ComTencentAvAppSessionInfo.a.e)))
                  {
                    this.a.jdField_a_of_type_ComTencentAvAppSessionInfo.a.e = (RandomController.a(this.a).getApp().getString(2131695731) + " “" + paramResponse.d + "” ");
                    RandomController.a(this.a, paramResponse.d);
                    if (QLog.isColorLevel()) {
                      QLog.d("RandomController", 2, "RSP_MULTI_PULL talkTips : " + this.a.jdField_a_of_type_ComTencentAvAppSessionInfo.a.e);
                    }
                  }
                }
              }
              if (paramInt == -3)
              {
                paramResponse = RandomController.a(this.a).iterator();
                while (paramResponse.hasNext()) {
                  ((RandomController.RandomListener)paramResponse.next()).a();
                }
              }
            }
            else
            {
              if ((!(paramResponse instanceof RandomWebProtocol.RspMultiRoomOwner)) || (paramResponse.a != 5)) {
                break label1010;
              }
              if (paramInt != 0) {
                break;
              }
              paramResponse = (RandomWebProtocol.RspMultiRoomOwner)paramResponse;
              if (QLog.isColorLevel()) {
                QLog.d("RandomController", 2, "request room owner room owner change push，uin " + paramResponse.b + " [random room owner]");
              }
              this.a.jdField_b_of_type_Int = 5;
              this.a.g = paramResponse.b;
              paramResponse = RandomController.a(this.a).iterator();
              while (paramResponse.hasNext()) {
                ((RandomController.RandomListener)paramResponse.next()).a();
              }
            }
          }
        } while ((paramInt != -4) || (!QLog.isColorLevel()));
        QLog.e("RandomController", 2, "[random room owner] pull room fail fail");
        return;
      } while ((!(paramResponse instanceof RandomWebProtocol.RspMultiRoomOwner)) || (4 != paramResponse.a));
      if (QLog.isColorLevel()) {
        QLog.d("RandomController", 2, "[random room owner] RSP_MULTI_KICK_MEMBER");
      }
      RandomController.a(this.a).a().removeCallbacks(RandomController.a(this.a));
      RandomController.a(this.a, false);
      paramResponse = (RandomWebProtocol.RspMultiRoomOwner)paramResponse;
      long l = paramResponse.jdField_a_of_type_OrgJsonJSONObject.optInt("groupid");
      this.a.jdField_a_of_type_JavaLangString = HexUtil.hexString2String(paramResponse.jdField_a_of_type_OrgJsonJSONObject.optString("wording").trim());
      if (TextUtils.isEmpty(this.a.jdField_a_of_type_JavaLangString)) {
        this.a.jdField_a_of_type_JavaLangString = RandomController.a(this.a).getApp().getApplicationContext().getString(2131695724);
      }
      if (QLog.isColorLevel()) {
        QLog.d("RandomController", 2, "[random room owner] KICK_MEMBER success groupId = " + l + ", mCurrGroupId = " + this.a.jdField_a_of_type_Long);
      }
      if (l == this.a.jdField_a_of_type_Long)
      {
        if (paramInt == 0)
        {
          if (QLog.isColorLevel()) {
            QLog.d("RandomController", 2, "[random room owner] KICK_MEMBER success");
          }
          this.a.jdField_b_of_type_Int = 6;
        }
        for (;;)
        {
          paramResponse = RandomController.a(this.a).iterator();
          while (paramResponse.hasNext()) {
            ((RandomController.RandomListener)paramResponse.next()).a();
          }
          break;
          if (paramInt == -4)
          {
            if (QLog.isColorLevel()) {
              QLog.e("RandomController", 2, "[random room owner] KICK_MEMBER fail" + paramResponse.jdField_a_of_type_JavaLangString);
            }
            this.a.jdField_b_of_type_Int = 7;
          }
        }
      }
    } while (!QLog.isColorLevel());
    QLog.d("RandomController", 2, "KICK_MEMBER success groupid != mCurrGroupId  [random room owner]");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.random.RandomController.1
 * JD-Core Version:    0.7.0.1
 */