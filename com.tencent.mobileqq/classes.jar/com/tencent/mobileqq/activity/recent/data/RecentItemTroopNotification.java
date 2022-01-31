package com.tencent.mobileqq.activity.recent.data;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.contact.troop.TroopNotificationUtils;
import com.tencent.mobileqq.activity.recent.TimeManager;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.RecommendTroopManagerImp;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.systemmsg.GroupSystemMsgController;
import com.tencent.mobileqq.systemmsg.MessageForSystemMsg;
import java.util.List;
import tencent.mobileim.structmsg.structmsg.StructMsg;

public class RecentItemTroopNotification
  extends RecentUserBaseData
{
  public RecentItemTroopNotification(RecentUser paramRecentUser)
  {
    super(paramRecentUser);
  }
  
  private boolean a(QQAppInterface paramQQAppInterface, Context paramContext, RecommendTroopManagerImp paramRecommendTroopManagerImp, MessageRecord paramMessageRecord)
  {
    if ((paramQQAppInterface == null) || (paramContext == null) || (paramRecommendTroopManagerImp == null) || (paramMessageRecord == null)) {
      return false;
    }
    this.jdField_a_of_type_Long = paramMessageRecord.time;
    if (paramMessageRecord.msgtype == -1039)
    {
      if (paramRecommendTroopManagerImp != null)
      {
        this.jdField_c_of_type_JavaLangCharSequence = (paramContext.getResources().getString(2131430182) + paramRecommendTroopManagerImp.a());
        return true;
      }
    }
    else if ((paramMessageRecord.msgtype == -1040) && (paramRecommendTroopManagerImp != null))
    {
      this.jdField_c_of_type_JavaLangCharSequence = paramRecommendTroopManagerImp.a();
      return true;
    }
    return false;
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if ((paramQQAppInterface == null) || (paramContext == null)) {}
    RecommendTroopManagerImp localRecommendTroopManagerImp;
    MessageRecord localMessageRecord;
    label66:
    Object localObject;
    do
    {
      return;
      super.a(paramQQAppInterface, paramContext);
      if (TextUtils.isEmpty(this.b)) {
        this.b = paramContext.getString(2131433290);
      }
      localRecommendTroopManagerImp = (RecommendTroopManagerImp)paramQQAppInterface.getManager(21);
      this.jdField_c_of_type_Int = TroopNotificationUtils.a(paramQQAppInterface);
      if (localRecommendTroopManagerImp == null) {
        break;
      }
      localMessageRecord = localRecommendTroopManagerImp.a();
      localObject = paramQQAppInterface.a().b(AppConstants.L, 0);
    } while ((localObject == null) && (localMessageRecord == null));
    label128:
    int i;
    int j;
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = ((MessageForSystemMsg)((List)localObject).get(((List)localObject).size() - 1)).getSystemMsg();
      i = GroupSystemMsgController.a().a(paramQQAppInterface);
      j = RecommendTroopManagerImp.b(paramQQAppInterface);
      if ((localObject == null) || (i <= 0)) {
        break label339;
      }
      this.jdField_a_of_type_Long = ((structmsg.StructMsg)localObject).msg_time.get();
      this.jdField_c_of_type_JavaLangCharSequence = GroupSystemMsgController.a().a(paramQQAppInterface);
      i = 1;
    }
    for (;;)
    {
      label176:
      if ((this.jdField_a_of_type_Long > 0L) && (this.jdField_a_of_type_Long != 9223372036854775806L)) {
        this.jdField_c_of_type_JavaLangString = TimeManager.a().a(a(), this.jdField_a_of_type_Long);
      }
      if (i != 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.jumpTabMode = 0;
        label226:
        if (!AppSetting.b) {
          break label495;
        }
        paramQQAppInterface = new StringBuilder(24);
        paramQQAppInterface.append(this.b);
        if (this.jdField_c_of_type_Int != 0) {
          break label497;
        }
      }
      for (;;)
      {
        if (this.jdField_d_of_type_JavaLangCharSequence != null) {
          paramQQAppInterface.append(this.jdField_d_of_type_JavaLangCharSequence + ",");
        }
        paramQQAppInterface.append(this.jdField_c_of_type_JavaLangCharSequence).append(',').append(this.jdField_c_of_type_JavaLangString);
        this.jdField_d_of_type_JavaLangString = paramQQAppInterface.toString();
        return;
        localMessageRecord = null;
        break label66;
        localObject = GroupSystemMsgController.a().a();
        break label128;
        label339:
        if (j > 0)
        {
          if (!a(paramQQAppInterface, paramContext, localRecommendTroopManagerImp, localMessageRecord)) {
            break label562;
          }
          i = 0;
          break label176;
        }
        if ((localObject != null) && (localMessageRecord != null))
        {
          if (((structmsg.StructMsg)localObject).msg_time.get() > localMessageRecord.time)
          {
            this.jdField_a_of_type_Long = ((structmsg.StructMsg)localObject).msg_time.get();
            this.jdField_c_of_type_JavaLangCharSequence = GroupSystemMsgController.a().a(paramQQAppInterface);
            i = 1;
            break label176;
          }
          if (!a(paramQQAppInterface, paramContext, localRecommendTroopManagerImp, localMessageRecord)) {
            break label562;
          }
          i = 0;
          break label176;
        }
        if (localObject != null)
        {
          this.jdField_a_of_type_Long = ((structmsg.StructMsg)localObject).msg_time.get();
          this.jdField_c_of_type_JavaLangCharSequence = GroupSystemMsgController.a().a(paramQQAppInterface);
        }
        if ((localMessageRecord == null) || (!a(paramQQAppInterface, paramContext, localRecommendTroopManagerImp, localMessageRecord))) {
          break label562;
        }
        i = 0;
        break label176;
        this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.jumpTabMode = 1;
        break label226;
        label495:
        break;
        label497:
        if (this.jdField_c_of_type_Int == 1) {
          paramQQAppInterface.append("有一条未读");
        } else if (this.jdField_c_of_type_Int == 2) {
          paramQQAppInterface.append("有两条未读");
        } else if (this.jdField_c_of_type_Int > 0) {
          paramQQAppInterface.append("有").append(this.jdField_c_of_type_Int).append("条未读");
        }
      }
      label562:
      i = 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.data.RecentItemTroopNotification
 * JD-Core Version:    0.7.0.1
 */