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
  protected List<QQOperationViopTipTask> a;
  private long b = -1L;
  private long c = -1L;
  private int d = -1;
  private QQAppInterface e;
  private TipsManager f;
  private WeakReference<Context> g;
  private BaseSessionInfo h;
  private final AIOContext i;
  
  public QQOperateTips(AIOContext paramAIOContext, List<QQOperationViopTipTask> paramList)
  {
    this.e = paramAIOContext.a();
    this.h = paramAIOContext.O();
    this.a = paramList;
    this.f = paramAIOContext.c();
    this.g = new WeakReference(paramAIOContext.b());
    this.i = paramAIOContext;
  }
  
  private void b(QQOperationViopTipTask paramQQOperationViopTipTask)
  {
    List localList = this.i.e().b().d();
    if (localList == null) {
      return;
    }
    int k = localList.size();
    int j = k - 1;
    while ((j >= 0) && (j >= k - 10))
    {
      if (((ChatMessage)localList.get(j)).msgtype == -1043)
      {
        j = 1;
        break label82;
      }
      j -= 1;
    }
    j = 0;
    label82:
    if (j != 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQOperateTips", 2, " findExcludeMsg, just return ");
      }
      return;
    }
    this.f.a(this, new Object[] { paramQQOperationViopTipTask });
  }
  
  private void d()
  {
    ThreadManager.excute(new QQOperateTips.1(this), 16, null, true);
  }
  
  private void e()
  {
    ThreadManager.excute(new QQOperateTips.2(this), 16, null, true);
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
      Object localObject = this.g;
      if (localObject != null)
      {
        if (((WeakReference)localObject).get() == null) {
          return null;
        }
        localObject = LayoutInflater.from((Context)this.g.get()).inflate(2131627287, null);
        TextView localTextView = (TextView)((View)localObject).findViewById(2131442218);
        Button localButton = (Button)((View)localObject).findViewById(2131442215);
        localTextView.setText(paramVarArgs.adwords);
        localButton.setText(paramVarArgs.clickableWord);
        localButton.setOnClickListener(new QQOperateTips.3(this, paramVarArgs));
        return localObject;
      }
    }
    return null;
  }
  
  public void a(int paramInt, Object... paramVarArgs)
  {
    if ((this.h.a != 0) && (this.h.a != 3000)) {
      return;
    }
    if (paramInt == 1000)
    {
      d();
      return;
    }
    if (paramInt == 1001)
    {
      e();
      return;
    }
    if (paramInt == 2000)
    {
      paramVarArgs = this.a;
      if (paramVarArgs != null) {
        paramVarArgs.clear();
      }
    }
  }
  
  public void a(QQOperationViopTipTask paramQQOperationViopTipTask)
  {
    this.f.a(this, new Object[] { paramQQOperationViopTipTask });
  }
  
  public void a(List<QQOperationViopTipTask> paramList)
  {
    QQOperateManager localQQOperateManager = QQOperateManager.a(this.e);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      int j = ((QQOperationViopTipTask)paramList.next()).taskid;
      QQOperationViopTipTask localQQOperationViopTipTask = localQQOperateManager.a(j);
      Object localObject;
      if ((QLog.isDevelopLevel()) && (localQQOperationViopTipTask == null))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("on showTips, voipTask is null, taskId=");
        ((StringBuilder)localObject).append(j);
        QLog.d("QQOperateVoIP", 4, ((StringBuilder)localObject).toString());
      }
      if (this.i.k() == 0) {
        j = 1;
      } else {
        j = 0;
      }
      if (localQQOperationViopTipTask != null) {
        if (localQQOperationViopTipTask.isBlueTipsTask())
        {
          if (j != 0)
          {
            a(localQQOperationViopTipTask);
          }
          else
          {
            localObject = this.a;
            if (localObject != null) {
              ((List)localObject).add(localQQOperationViopTipTask);
            }
          }
        }
        else if ((localQQOperationViopTipTask.isGryTipsTask()) && (!localQQOperateManager.a(this.h.a, 2))) {
          b(localQQOperationViopTipTask);
        }
      }
    }
  }
  
  public MessageRecord a_(Object... paramVarArgs)
  {
    if ((paramVarArgs[0] instanceof QQOperationViopTipTask))
    {
      paramVarArgs = (QQOperationViopTipTask)paramVarArgs[0];
      MessageRecord localMessageRecord = MessageRecordFactory.a(-1041);
      long l = MessageCache.c();
      String str1 = this.e.getCurrentAccountUin();
      String str2 = this.h.b;
      String str3 = this.e.getAccount();
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
      localMessageRecord.init(str1, str2, str3, localStringBuilder.toString(), l, -1041, this.h.a, l);
      localMessageRecord.isread = true;
      if (!MessageHandlerUtils.a(this.e, localMessageRecord, false)) {
        return localMessageRecord;
      }
    }
    return null;
  }
  
  public int b()
  {
    return 6;
  }
  
  public int[] c()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.tips.QQOperateTips
 * JD-Core Version:    0.7.0.1
 */