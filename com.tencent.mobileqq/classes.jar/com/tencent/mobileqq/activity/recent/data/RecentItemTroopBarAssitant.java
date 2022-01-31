package com.tencent.mobileqq.activity.recent.data;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.subscript.SubscriptRecommendController;
import com.tencent.biz.pubaccount.troopbarassit.TroopBarAssistantManager;
import com.tencent.biz.pubaccount.troopbarassit.TroopBarData;
import com.tencent.biz.pubaccount.util.PublicAccountConfigUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.aio.XMLMessageUtils;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.app.PublicAccountDataManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.mobileqq.data.DraftSummaryInfo;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PAMessage;
import com.tencent.mobileqq.data.PAMessage.Item;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.mobileqq.structmsg.AbsStructMsgItem;
import com.tencent.mobileqq.structmsg.view.StructMsgItemTitle;
import com.tencent.mobileqq.utils.MsgUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RecentItemTroopBarAssitant
  extends RecentUserBaseData
{
  public RecentItemTroopBarAssitant(RecentUser paramRecentUser)
  {
    super(paramRecentUser);
    this.jdField_b_of_type_Int = 2;
  }
  
  public void a(Context paramContext)
  {
    if ((this.jdField_c_of_type_Int > 0) && (!SubscriptRecommendController.d((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()))) {
      if (this.jdField_c_of_type_Int <= 99)
      {
        this.jdField_d_of_type_JavaLangCharSequence = String.format(paramContext.getString(2131430054), new Object[] { Integer.valueOf(this.jdField_c_of_type_Int) });
        this.e = paramContext.getResources().getColor(2131494281);
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Long == 0L) {
        this.jdField_c_of_type_JavaLangString = "";
      }
      return;
      this.jdField_d_of_type_JavaLangCharSequence = paramContext.getString(2131430059);
      break;
      this.jdField_d_of_type_JavaLangCharSequence = "";
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_Int = 0;
    TroopBarData localTroopBarData = TroopBarAssistantManager.a().a(paramQQAppInterface);
    if ((localTroopBarData == null) || (TextUtils.isEmpty(localTroopBarData.mUin))) {}
    do
    {
      do
      {
        return;
        paramQQAppInterface = paramQQAppInterface.a();
      } while (paramQQAppInterface == null);
      paramQQAppInterface = paramQQAppInterface.a(localTroopBarData.mUin, 1008);
    } while ((paramQQAppInterface != null) && (!TextUtils.isEmpty(paramQQAppInterface.getSummary())));
    this.jdField_a_of_type_Int = 0;
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if ((paramQQAppInterface == null) || (paramContext == null)) {
      return;
    }
    super.a(paramQQAppInterface, paramContext);
    this.jdField_b_of_type_JavaLangString = PublicAccountConfigUtil.a(paramQQAppInterface, paramContext);
    Object localObject5 = TroopBarAssistantManager.a();
    MsgSummary localMsgSummary = a();
    Object localObject1;
    label91:
    Object localObject2;
    if (SubscriptRecommendController.d(paramQQAppInterface))
    {
      this.jdField_c_of_type_Int = 1;
      ((TroopBarAssistantManager)localObject5).jdField_a_of_type_Int = this.jdField_c_of_type_Int;
      localObject1 = SubscriptRecommendController.b(paramQQAppInterface);
      if (TextUtils.isEmpty((CharSequence)localObject1)) {}
      for (localMsgSummary.b = paramContext.getString(2131430064);; localMsgSummary.b = ((CharSequence)localObject1))
      {
        this.jdField_a_of_type_Long = ((TroopBarAssistantManager)localObject5).a(paramQQAppInterface);
        a(paramQQAppInterface);
        a(paramQQAppInterface, localMsgSummary);
        a(paramQQAppInterface, paramContext, localMsgSummary);
        if (AppSetting.b)
        {
          localObject1 = this.jdField_b_of_type_JavaLangString;
          if (this.jdField_c_of_type_Int != 0) {
            break label941;
          }
          localObject2 = paramContext.getString(2131430053);
          if (this.jdField_c_of_type_JavaLangCharSequence != null) {
            break;
          }
          paramQQAppInterface = "";
          label148:
          this.jdField_d_of_type_JavaLangString = String.format((String)localObject2, new Object[] { localObject1, paramQQAppInterface, this.jdField_c_of_type_JavaLangString });
        }
        label177:
        a(paramContext);
        return;
      }
    }
    label207:
    Object localObject3;
    Object localObject4;
    label350:
    int i;
    if (((TroopBarAssistantManager)localObject5).a(paramQQAppInterface) == 0)
    {
      this.jdField_c_of_type_Int = 0;
      ((TroopBarAssistantManager)localObject5).jdField_a_of_type_Int = 0;
      localObject2 = null;
      localObject3 = paramQQAppInterface.a();
      localObject4 = ((TroopBarAssistantManager)localObject5).a(paramQQAppInterface);
      localObject1 = localObject2;
      if (localObject3 != null)
      {
        localObject1 = localObject2;
        if (localObject4 != null) {
          localObject1 = ((QQMessageFacade)localObject3).a(((TroopBarData)localObject4).mUin, 1008);
        }
      }
      if (localObject1 == null) {
        break label920;
      }
      this.jdField_a_of_type_Long = ((QQMessageFacade.Message)localObject1).time;
      if (TextUtils.isEmpty(((TroopBarAssistantManager)localObject5).a(((QQMessageFacade.Message)localObject1).frienduin)))
      {
        localObject2 = (PublicAccountDataManager)paramQQAppInterface.getManager(55);
        if (localObject2 != null)
        {
          localObject5 = ((PublicAccountDataManager)localObject2).b(((QQMessageFacade.Message)localObject1).frienduin);
          if (localObject5 != null) {
            break label622;
          }
          localObject2 = ((PublicAccountDataManager)localObject2).a(((QQMessageFacade.Message)localObject1).frienduin);
          if (localObject2 == null) {
            break label612;
          }
          localObject2 = ((AccountDetail)localObject2).name;
        }
      }
      if (localObject1 != null)
      {
        MsgUtils.a(paramContext, paramQQAppInterface, (QQMessageFacade.Message)localObject1, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.type, localMsgSummary, "", true, false);
        i = ((QQMessageFacade.Message)localObject1).msgtype;
        if ((i == -3006) || (i == -5004))
        {
          localMsgSummary.jdField_c_of_type_JavaLangCharSequence = "";
          localMsgSummary.b = "";
          localObject5 = XMLMessageUtils.a((MessageRecord)localObject1);
          if ((localObject5 != null) && (((PAMessage)localObject5).items != null) && (((PAMessage)localObject5).items.size() != 0)) {
            break label632;
          }
          a((QQMessageFacade.Message)localObject1, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.type, paramQQAppInterface, paramContext, localMsgSummary);
        }
        if (((!TextUtils.isEmpty(localMsgSummary.b)) || (!TextUtils.isEmpty(localMsgSummary.jdField_c_of_type_JavaLangCharSequence))) && (!TextUtils.equals(localMsgSummary.a(paramContext), "你有新消息"))) {
          break label748;
        }
        i = 1;
        label495:
        if (i != 0)
        {
          localObject2 = ((QQMessageFacade)localObject3).b(((TroopBarData)localObject4).mUin, 1008);
          if ((localObject2 != null) && ((localObject2 instanceof MessageForStructing))) {
            break label753;
          }
        }
      }
    }
    label527:
    label818:
    label1085:
    label1086:
    for (;;)
    {
      if ((localObject1 == null) && (TextUtils.isEmpty(localMsgSummary.b)) && (TextUtils.isEmpty(localMsgSummary.jdField_c_of_type_JavaLangCharSequence)))
      {
        localMsgSummary.jdField_a_of_type_JavaLangCharSequence = null;
        localMsgSummary.b = ("暂无" + PublicAccountConfigUtil.a(paramQQAppInterface, paramContext) + "消息");
        break label91;
        this.jdField_c_of_type_Int = ((TroopBarAssistantManager)localObject5).a(paramQQAppInterface, false);
        break label207;
        label612:
        localObject2 = ((QQMessageFacade.Message)localObject1).frienduin;
        break label350;
        label622:
        localObject2 = ((PublicAccountInfo)localObject5).name;
        break label350;
        label632:
        localObject2 = ((PAMessage.Item)((PAMessage)localObject5).items.get(0)).title;
        if ((((PAMessage.Item)((PAMessage)localObject5).items.get(0)).cover == null) && (((PAMessage.Item)((PAMessage)localObject5).items.get(0)).digestList != null)) {
          localObject2 = (String)localObject2 + "：" + (String)((PAMessage.Item)((PAMessage)localObject5).items.get(0)).digestList.get(0);
        }
        for (;;)
        {
          localMsgSummary.b = ((CharSequence)localObject2);
          break;
        }
        label748:
        i = 0;
        break label495;
        label753:
        ((MessageForStructing)localObject2).parse();
        if ((((MessageForStructing)localObject2).structingMsg == null) || (!(((MessageForStructing)localObject2).structingMsg instanceof AbsShareMsg))) {
          break;
        }
        localObject2 = ((AbsShareMsg)((MessageForStructing)localObject2).structingMsg).getStructMsgItemLists();
        if (localObject2 == null) {
          continue;
        }
        localObject2 = ((List)localObject2).iterator();
        i = 0;
        if (((Iterator)localObject2).hasNext())
        {
          localObject3 = (AbsStructMsgElement)((Iterator)localObject2).next();
          if (!(localObject3 instanceof AbsStructMsgItem)) {
            break label1085;
          }
          localObject3 = ((AbsStructMsgItem)localObject3).a.iterator();
          while (((Iterator)localObject3).hasNext())
          {
            localObject4 = (AbsStructMsgElement)((Iterator)localObject3).next();
            if ((localObject4 instanceof StructMsgItemTitle))
            {
              localMsgSummary.b = ((StructMsgItemTitle)localObject4).b();
              localMsgSummary.jdField_c_of_type_JavaLangCharSequence = "";
              i = 1;
            }
          }
        }
      }
      for (;;)
      {
        if (i != 0) {
          break label1086;
        }
        break label818;
        break label527;
        this.jdField_a_of_type_Long = ((TroopBarAssistantManager)localObject5).a(paramQQAppInterface);
        break label527;
        break;
        paramQQAppInterface = this.jdField_c_of_type_JavaLangCharSequence;
        break label148;
        if (this.jdField_c_of_type_Int == 1)
        {
          this.jdField_d_of_type_JavaLangString = String.format(paramContext.getString(2131430052), new Object[] { localObject1, "一", this.jdField_c_of_type_JavaLangString });
          break label177;
        }
        if (this.jdField_c_of_type_Int == 2)
        {
          this.jdField_d_of_type_JavaLangString = String.format(paramContext.getString(2131430052), new Object[] { localObject1, "两", this.jdField_c_of_type_JavaLangString });
          break label177;
        }
        if (this.jdField_c_of_type_Int <= 0) {
          break label177;
        }
        this.jdField_d_of_type_JavaLangString = String.format(paramContext.getString(2131430052), new Object[] { localObject1, Integer.toString(this.jdField_c_of_type_Int), this.jdField_c_of_type_JavaLangString });
        break label177;
      }
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, MsgSummary paramMsgSummary)
  {
    if (paramMsgSummary == null) {}
    do
    {
      do
      {
        do
        {
          return;
          paramMsgSummary.jdField_a_of_type_Boolean = false;
          paramMsgSummary.jdField_d_of_type_JavaLangCharSequence = null;
          paramMsgSummary = paramQQAppInterface.a();
        } while (paramMsgSummary == null);
        paramQQAppInterface = TroopBarAssistantManager.a().a(paramQQAppInterface);
      } while ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramQQAppInterface.mUin)) || (this.jdField_a_of_type_Long >= paramQQAppInterface.mLastDraftTime));
      paramQQAppInterface = paramMsgSummary.a(paramQQAppInterface.mUin, 1008);
    } while ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramQQAppInterface.getSummary())));
    this.jdField_a_of_type_Long = paramQQAppInterface.getTime();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.data.RecentItemTroopBarAssitant
 * JD-Core Version:    0.7.0.1
 */