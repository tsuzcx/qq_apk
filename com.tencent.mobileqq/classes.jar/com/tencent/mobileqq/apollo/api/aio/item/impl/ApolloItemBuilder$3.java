package com.tencent.mobileqq.apollo.api.aio.item.impl;

import android.content.Context;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.apollo.api.data.IApolloDaoManagerService;
import com.tencent.mobileqq.apollo.api.model.ApolloActionData;
import com.tencent.mobileqq.apollo.api.model.ApolloFavActionData;
import com.tencent.mobileqq.apollo.api.model.ApolloInfo;
import com.tencent.mobileqq.apollo.api.model.ApolloMainInfo;
import com.tencent.mobileqq.apollo.api.uitls.IApolloUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

final class ApolloItemBuilder$3
  implements Runnable
{
  ApolloItemBuilder$3(QQAppInterface paramQQAppInterface, Context paramContext, ApolloFavActionData paramApolloFavActionData, SessionInfo paramSessionInfo) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {}
    Object localObject2;
    do
    {
      do
      {
        do
        {
          return;
          localObject2 = (IApolloDaoManagerService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IApolloDaoManagerService.class, "all");
        } while (localObject2 == null);
        localObject1 = ((IApolloDaoManagerService)localObject2).getFavPackageActionList();
        if ((localObject1 == null) || (((List)localObject1).size() < 143)) {
          break;
        }
        ApolloItemBuilder.a(this.jdField_a_of_type_AndroidContentContext.getString(2131690105), 1, this.jdField_a_of_type_AndroidContentContext);
      } while (!QLog.isColorLevel());
      QLog.d("ApolloItemBuilder", 2, "fav number is 144");
      return;
      if (((IApolloDaoManagerService)localObject2).findActionById(this.jdField_a_of_type_ComTencentMobileqqApolloApiModelApolloFavActionData.acitonId) != null) {
        break;
      }
      ApolloItemBuilder.a(this.jdField_a_of_type_AndroidContentContext.getString(2131690108), 1, this.jdField_a_of_type_AndroidContentContext);
    } while (!QLog.isColorLevel());
    QLog.d("ApolloItemBuilder", 2, "cant find the add aciton id=" + this.jdField_a_of_type_ComTencentMobileqqApolloApiModelApolloFavActionData.acitonId);
    return;
    Object localObject1 = ((IApolloDaoManagerService)localObject2).getFavPackageActionList();
    Object localObject3;
    if ((localObject1 != null) && (((List)localObject1).size() > 0))
    {
      localObject1 = ((List)localObject1).iterator();
      do
      {
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        localObject3 = (ApolloFavActionData)((Iterator)localObject1).next();
      } while (this.jdField_a_of_type_ComTencentMobileqqApolloApiModelApolloFavActionData.acitonId != ((ApolloFavActionData)localObject3).acitonId);
    }
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        ApolloItemBuilder.a(this.jdField_a_of_type_AndroidContentContext.getString(2131690104), 1, this.jdField_a_of_type_AndroidContentContext);
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("ApolloItemBuilder", 2, "the add aciton is exist id=" + this.jdField_a_of_type_ComTencentMobileqqApolloApiModelApolloFavActionData.acitonId);
        return;
      }
      long l = System.currentTimeMillis();
      this.jdField_a_of_type_ComTencentMobileqqApolloApiModelApolloFavActionData.favId = l;
      ((IApolloDaoManagerService)localObject2).insertFavActionPackageData(this.jdField_a_of_type_ComTencentMobileqqApolloApiModelApolloFavActionData);
      ApolloItemBuilder.a(this.jdField_a_of_type_AndroidContentContext.getString(2131690109), 2, this.jdField_a_of_type_AndroidContentContext);
      localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      i = ((IApolloUtil)QRoute.api(IApolloUtil.class)).getReportSessiontype(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
      String str = "" + this.jdField_a_of_type_ComTencentMobileqqApolloApiModelApolloFavActionData.acitonId;
      if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqApolloApiModelApolloFavActionData.text)) {}
      for (localObject1 = "0";; localObject1 = this.jdField_a_of_type_ComTencentMobileqqApolloApiModelApolloFavActionData.text)
      {
        VipUtils.a((AppInterface)localObject3, "cmshow", "Apollo", "add_action", i, 0, new String[] { str, "", localObject1 });
        if (QLog.isColorLevel()) {
          QLog.d("ApolloItemBuilder", 2, " add aciton success id=" + this.jdField_a_of_type_ComTencentMobileqqApolloApiModelApolloFavActionData.acitonId);
        }
        localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(ChatActivity.class);
        if (localObject3 == null) {
          break;
        }
        localObject1 = new ApolloMainInfo(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
        ((ApolloInfo)localObject1).mAction = ((IApolloDaoManagerService)localObject2).findActionById(this.jdField_a_of_type_ComTencentMobileqqApolloApiModelApolloFavActionData.acitonId);
        ((ApolloInfo)localObject1).mActionText = this.jdField_a_of_type_ComTencentMobileqqApolloApiModelApolloFavActionData.text;
        ((ApolloInfo)localObject1).mTextType = this.jdField_a_of_type_ComTencentMobileqqApolloApiModelApolloFavActionData.textType;
        ((ApolloInfo)localObject1).mAudioId = this.jdField_a_of_type_ComTencentMobileqqApolloApiModelApolloFavActionData.audioId;
        ((ApolloInfo)localObject1).mPlayOriginalAudio = this.jdField_a_of_type_ComTencentMobileqqApolloApiModelApolloFavActionData.playOriginalAudio;
        ((ApolloInfo)localObject1).mAudioStartTime = this.jdField_a_of_type_ComTencentMobileqqApolloApiModelApolloFavActionData.audioStartTime;
        localObject2 = ((MqqHandler)localObject3).obtainMessage(66);
        ((Message)localObject2).obj = localObject1;
        ((Message)localObject2).sendToTarget();
        if (((ApolloInfo)localObject1).mAction.status != 0) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("ApolloItemBuilder", 2, "add action download res " + ((ApolloInfo)localObject1).toString());
        }
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
          break;
        }
        localObject2 = (IApolloManagerService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IApolloManagerService.class, "all");
        localObject3 = new ArrayList();
        ((List)localObject3).add(((ApolloInfo)localObject1).mAction);
        ((IApolloManagerService)localObject2).downloadResAndPanel((List)localObject3, "apollo_key");
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.aio.item.impl.ApolloItemBuilder.3
 * JD-Core Version:    0.7.0.1
 */