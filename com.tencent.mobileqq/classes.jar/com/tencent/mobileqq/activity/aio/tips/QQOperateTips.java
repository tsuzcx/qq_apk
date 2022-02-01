package com.tencent.mobileqq.activity.aio.tips;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.msglist.MsgList;
import com.tencent.mobileqq.activity.aio.coreui.msglist.ListUI;
import com.tencent.mobileqq.app.MessageHandlerUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.config.operation.QQOperateManager;
import com.tencent.mobileqq.config.operation.QQOperationViopTipTask;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;

public class QQOperateTips
  implements GrayTipsTask, TipsBarTask
{
  private int jdField_a_of_type_Int = -1;
  private long jdField_a_of_type_Long = -1L;
  private BaseSessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo;
  private final AIOContext jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext;
  private TipsManager jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private WeakReference<Context> jdField_a_of_type_JavaLangRefWeakReference;
  protected List<QQOperationViopTipTask> a;
  private long b = -1L;
  
  public QQOperateTips(AIOContext paramAIOContext, List<QQOperationViopTipTask> paramList)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramAIOContext.a();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo = paramAIOContext.a();
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager = paramAIOContext.a();
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramAIOContext.a());
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext = paramAIOContext;
  }
  
  private void a()
  {
    ThreadManager.excute(new QQOperateTips.1(this), 16, null, true);
  }
  
  private void b()
  {
    ThreadManager.excute(new QQOperateTips.2(this), 16, null, true);
  }
  
  private void b(QQOperationViopTipTask paramQQOperationViopTipTask)
  {
    List localList = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().a().a();
    if (localList == null) {
      return;
    }
    int j = localList.size();
    int i = j - 1;
    while ((i >= 0) && (i >= j - 10))
    {
      if (((ChatMessage)localList.get(i)).msgtype == -1043)
      {
        i = 1;
        break label82;
      }
      i -= 1;
    }
    i = 0;
    label82:
    if (i != 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQOperateTips", 2, " findExcludeMsg, just return ");
      }
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a(this, new Object[] { paramQQOperationViopTipTask });
  }
  
  public int a()
  {
    return 40;
  }
  
  public View a(Object... paramVarArgs)
  {
    if ((paramVarArgs[0] instanceof QQOperationViopTipTask))
    {
      paramVarArgs = (QQOperationViopTipTask)paramVarArgs[0];
      Object localObject = this.jdField_a_of_type_JavaLangRefWeakReference;
      if (localObject != null)
      {
        if (((WeakReference)localObject).get() == null) {
          return null;
        }
        localObject = LayoutInflater.from((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get()).inflate(2131560946, null);
        TextView localTextView = (TextView)((View)localObject).findViewById(2131374123);
        Button localButton = (Button)((View)localObject).findViewById(2131374120);
        localTextView.setText(paramVarArgs.adwords);
        localButton.setText(paramVarArgs.clickableWord);
        localButton.setOnClickListener(new QQOperateTips.3(this, paramVarArgs));
        return localObject;
      }
    }
    return null;
  }
  
  public MessageRecord a(Object... paramVarArgs)
  {
    if ((paramVarArgs[0] instanceof QQOperationViopTipTask))
    {
      paramVarArgs = (QQOperationViopTipTask)paramVarArgs[0];
      MessageRecord localMessageRecord = MessageRecordFactory.a(-1041);
      long l = MessageCache.a();
      String str1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      String str2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_JavaLangString;
      String str3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramVarArgs.adwords);
      localStringBuilder.append("|");
      localStringBuilder.append(paramVarArgs.clickableWord);
      localStringBuilder.append("|");
      localStringBuilder.append(paramVarArgs.linkOffset);
      localStringBuilder.append("|");
      localStringBuilder.append(paramVarArgs.url);
      localStringBuilder.append("|");
      localStringBuilder.append(paramVarArgs.taskid);
      localMessageRecord.init(str1, str2, str3, localStringBuilder.toString(), l, -1041, this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_Int, l);
      localMessageRecord.isread = true;
      if (!MessageHandlerUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageRecord, false)) {
        return localMessageRecord;
      }
    }
    return null;
  }
  
  public void a(int paramInt, Object... paramVarArgs)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_Int != 0) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_Int != 3000)) {
      return;
    }
    if (paramInt == 1000)
    {
      a();
      return;
    }
    if (paramInt == 1001)
    {
      b();
      return;
    }
    if (paramInt == 2000)
    {
      paramVarArgs = this.jdField_a_of_type_JavaUtilList;
      if (paramVarArgs != null) {
        paramVarArgs.clear();
      }
    }
  }
  
  public void a(QQOperationViopTipTask paramQQOperationViopTipTask)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a(this, new Object[] { paramQQOperationViopTipTask });
  }
  
  public void a(List<QQOperationViopTipTask> paramList)
  {
    QQOperateManager localQQOperateManager = QQOperateManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      int i = ((QQOperationViopTipTask)paramList.next()).taskid;
      QQOperationViopTipTask localQQOperationViopTipTask = localQQOperateManager.a(i);
      Object localObject;
      if ((QLog.isDevelopLevel()) && (localQQOperationViopTipTask == null))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("on showTips, voipTask is null, taskId=");
        ((StringBuilder)localObject).append(i);
        QLog.d("QQOperateVoIP", 4, ((StringBuilder)localObject).toString());
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a() == 0) {
        i = 1;
      } else {
        i = 0;
      }
      if (localQQOperationViopTipTask != null) {
        if (localQQOperationViopTipTask.isBlueTipsTask())
        {
          if (i != 0)
          {
            a(localQQOperationViopTipTask);
          }
          else
          {
            localObject = this.jdField_a_of_type_JavaUtilList;
            if (localObject != null) {
              ((List)localObject).add(localQQOperationViopTipTask);
            }
          }
        }
        else if ((localQQOperationViopTipTask.isGryTipsTask()) && (!localQQOperateManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_Int, 2))) {
          b(localQQOperationViopTipTask);
        }
      }
    }
  }
  
  public int[] a()
  {
    return null;
  }
  
  public int b()
  {
    return 6;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.tips.QQOperateTips
 * JD-Core Version:    0.7.0.1
 */