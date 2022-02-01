package com.tencent.mobileqq.activity.aio.helper;

import com.tencent.mobileqq.activity.aio.TodoInfoPresenter;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.troop.trooptodo.TroopToDoController;
import com.tencent.mobileqq.activity.aio.troop.trooptodo.TroopToDoTipsBar;
import com.tencent.mobileqq.activity.aio.troop.trooptodo.TroopToDoTipsBarManage;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.trooptodo.TroopToDoBannerModel;
import com.tencent.mobileqq.data.trooptodo.TroopToDoBannerModel.RawInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.todo.TroopToDoMsgRevokeObserver;
import com.tencent.mobileqq.troop.todo.TroopTodoReportUtils.ReportData;
import com.tencent.mobileqq.troop.todo.TroopTodoUtils;
import com.tencent.mobileqq.troop.trooptodo.TroopToDoObserver;
import com.tencent.mobileqq.troop.trooptodo.api.ITroopToDoResponseHandler;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import org.jetbrains.annotations.NotNull;

public class TroopToDoHelper
  implements ILifeCycleHelper, ITroopToDoMsgRevoke, ITroopToDoResponseHandler
{
  private QQAppInterface a;
  private AIOContext b;
  private TroopToDoObserver c = new TroopToDoObserver(this);
  private TroopToDoMsgRevokeObserver d = null;
  private TroopToDoController e = null;
  private TroopToDoTipsBarManage f = null;
  private boolean g = true;
  
  public TroopToDoHelper(BaseChatPie paramBaseChatPie)
  {
    QLog.i("TroopToDoHelper-TodoInfo", 4, "TroopToDoHelper init");
    this.a = paramBaseChatPie.d;
    this.b = paramBaseChatPie.bv();
    this.d = new TroopToDoMsgRevokeObserver(paramBaseChatPie, this);
    c();
  }
  
  private void a(TroopToDoBannerModel paramTroopToDoBannerModel)
  {
    if (paramTroopToDoBannerModel == null)
    {
      QLog.i("TroopToDoHelper-TodoInfo", 4, "initTroopToDoTipsBarAndShow: model == null");
      return;
    }
    if (paramTroopToDoBannerModel.e().a != TroopTodoUtils.a(this.b))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("initTroopToDoTipsBarAndShow: 不是本群的model丢弃 model:");
      ((StringBuilder)localObject).append(paramTroopToDoBannerModel.toString());
      QLog.i("TroopToDoHelper-TodoInfo", 4, ((StringBuilder)localObject).toString());
      return;
    }
    Object localObject = this.f;
    if (localObject == null)
    {
      QLog.e("TroopToDoHelper-TodoInfo", 4, "initTroopToDoTipsBarAndShow,barManage == null");
      return;
    }
    localObject = ((TroopToDoTipsBarManage)localObject).a();
    if ((paramTroopToDoBannerModel.e().d != 2) && (paramTroopToDoBannerModel.e().d != 4))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("update model:");
      localStringBuilder.append(paramTroopToDoBannerModel);
      QLog.i("TroopToDoHelper-TodoInfo", 4, localStringBuilder.toString());
      ((TroopToDoTipsBar)localObject).a(paramTroopToDoBannerModel);
      if (paramTroopToDoBannerModel.e().d == 3)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("TroopToDoTipsBar TODO_STATUS_CODE_UNFINISHED 展示:");
        localStringBuilder.append(paramTroopToDoBannerModel.toString());
        QLog.i("TroopToDoHelper-TodoInfo", 4, localStringBuilder.toString());
        ((TroopToDoTipsBar)localObject).d();
        TroopTodoUtils.a(paramTroopToDoBannerModel);
        return;
      }
      if (paramTroopToDoBannerModel.e().d == 1)
      {
        if (TroopTodoUtils.a(this.a, paramTroopToDoBannerModel.e().a))
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("TroopToDoTipsBar TODO_STATUS_CODE_FINISH 主态展示:");
          localStringBuilder.append(paramTroopToDoBannerModel.toString());
          QLog.i("TroopToDoHelper-TodoInfo", 4, localStringBuilder.toString());
          ((TroopToDoTipsBar)localObject).d();
          TroopTodoUtils.a(paramTroopToDoBannerModel);
          return;
        }
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("TroopToDoTipsBar TODO_STATUS_CODE_FINISH 客态不展示:");
        localStringBuilder.append(paramTroopToDoBannerModel.toString());
        QLog.i("TroopToDoHelper-TodoInfo", 4, localStringBuilder.toString());
        ((TroopToDoTipsBar)localObject).e();
        return;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("非预期model:");
      ((StringBuilder)localObject).append(paramTroopToDoBannerModel.toString());
      QLog.e("TroopToDoHelper-TodoInfo", 4, ((StringBuilder)localObject).toString());
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TroopToDoTipsBar TODO_STATUS_CODE_CLOSE or TODO_STATUS_CODE_RECALL 不展示:");
    localStringBuilder.append(paramTroopToDoBannerModel.toString());
    QLog.i("TroopToDoHelper-TodoInfo", 4, localStringBuilder.toString());
    ((TroopToDoTipsBar)localObject).e();
  }
  
  private void c()
  {
    TroopToDoHelper.1 local1 = new TroopToDoHelper.1(this);
    TodoInfoPresenter.a().a(this.a, local1);
  }
  
  private void d()
  {
    if (this.g) {
      return;
    }
    Object localObject = this.f;
    if (localObject == null)
    {
      QLog.i("TroopToDoHelper-TodoInfo", 4, "troopToDoBarExposure: barManage == null");
      return;
    }
    localObject = ((TroopToDoTipsBarManage)localObject).a();
    if (!((TroopToDoTipsBar)localObject).c()) {
      return;
    }
    localObject = ((TroopToDoTipsBar)localObject).b();
    ReportController.b(this.a, "dc00898", "", "", "0X800BC74", "0X800BC74", 0, 0, String.valueOf(((TroopTodoReportUtils.ReportData)localObject).a), String.valueOf(((TroopTodoReportUtils.ReportData)localObject).b), ((TroopTodoReportUtils.ReportData)localObject).c, String.valueOf(((TroopTodoReportUtils.ReportData)localObject).d));
  }
  
  public TroopToDoController a()
  {
    return this.e;
  }
  
  public void a(boolean paramBoolean, Object paramObject)
  {
    paramObject = new StringBuilder();
    paramObject.append("handleCloseTask invoke, isSuccess = ");
    paramObject.append(paramBoolean);
    QLog.i("TroopToDoHelper-TodoInfo", 4, paramObject.toString());
    if (!paramBoolean)
    {
      paramObject = this.b.b().getString(2131917639);
      QQToast.makeText(this.b.b(), 1, paramObject, 0).show();
      return;
    }
    if (this.f != null)
    {
      QLog.i("TroopToDoHelper-TodoInfo", 4, "TroopToDoTipsBar 不展示: handleCloseTask");
      this.f.a().e();
      TodoInfoPresenter.a().b(TroopTodoUtils.a(this.b));
    }
  }
  
  public void a(boolean paramBoolean, List<MessageRecord> paramList)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("handleMessageRevoke invoke, isSuccess=");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append(", msgList =");
    if (paramList != null) {
      paramList = Integer.valueOf(paramList.size());
    } else {
      paramList = null;
    }
    localStringBuilder.append(paramList);
    QLog.i("TroopToDoHelper-TodoInfo", 4, localStringBuilder.toString());
  }
  
  public TroopToDoTipsBar b()
  {
    TroopToDoTipsBarManage localTroopToDoTipsBarManage = this.f;
    if (localTroopToDoTipsBarManage == null)
    {
      QLog.e("TroopToDoHelper-TodoInfo", 2, "getTroopToDoTipsBar: barManage == null");
      return null;
    }
    return localTroopToDoTipsBarManage.a();
  }
  
  public void b(boolean paramBoolean, Object paramObject)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("handleRecallTask invoke, isSuccess = ");
    localStringBuilder.append(paramBoolean);
    QLog.i("TroopToDoHelper-TodoInfo", 4, localStringBuilder.toString());
    if (!paramBoolean)
    {
      paramObject = this.b.b().getString(2131917646);
      QQToast.makeText(this.b.b(), 1, paramObject, 0).show();
      return;
    }
    if (((paramObject instanceof Integer)) && (((Integer)paramObject).intValue() == 300213))
    {
      paramObject = this.b.b().getString(2131917641);
      QQToast.makeText(this.b.b(), 1, paramObject, 0).show();
    }
  }
  
  public void c(boolean paramBoolean, Object paramObject)
  {
    paramObject = new StringBuilder();
    paramObject.append("handleCompleteTask invoke, isSuccess = ");
    paramObject.append(paramBoolean);
    QLog.i("TroopToDoHelper-TodoInfo", 4, paramObject.toString());
    if (!paramBoolean)
    {
      paramObject = this.b.b().getString(2131917640);
      QQToast.makeText(this.b.b(), 1, paramObject, 0).show();
      return;
    }
    paramObject = this.f;
    if (paramObject == null)
    {
      QLog.e("TroopToDoHelper-TodoInfo", 1, "handleCompleteTask barManage == null");
      return;
    }
    paramObject = paramObject.a();
    if (TroopTodoUtils.a(this.a, paramObject.h().e().a))
    {
      paramObject.g();
    }
    else
    {
      QLog.i("TroopToDoHelper-TodoInfo", 4, "TroopToDoTipsBar 不展示: 普通成员handleCompleteTask");
      paramObject.e();
    }
    TodoInfoPresenter.a().b(TroopTodoUtils.a(this.b));
  }
  
  public void d(boolean paramBoolean, Object paramObject)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("handleAddTask invoke, isSuccess=");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append(", data=");
    localStringBuilder.append(paramObject);
    QLog.i("TroopToDoHelper-TodoInfo", 4, localStringBuilder.toString());
    if (!paramBoolean)
    {
      paramObject = this.b.b().getString(2131917634);
      QQToast.makeText(this.b.b(), 1, paramObject, 0).show();
      return;
    }
    if (((paramObject instanceof Integer)) && (((Integer)paramObject).intValue() == 300225))
    {
      paramObject = this.b.b().getString(2131917635);
      QQToast.makeText(this.b.b(), 1, paramObject, 0).show();
    }
  }
  
  @NotNull
  public String getTag()
  {
    return "TroopToDoHelper-TodoInfo";
  }
  
  public int[] interestedIn()
  {
    return new int[] { 0, 4, 8, 10, 12, 15 };
  }
  
  public void onMoveToState(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 4)
      {
        if (paramInt != 8)
        {
          if (paramInt != 10)
          {
            if (paramInt != 12)
            {
              if (paramInt != 15) {
                return;
              }
              QLog.d("TroopToDoHelper-TodoInfo", 4, "DESTROY");
              if (this.f != null)
              {
                QLog.i("TroopToDoHelper-TodoInfo", 4, "TroopToDoTipsBar 不展示: 退出群聊");
                this.f.a().e();
              }
              this.f = null;
              this.a.removeObserver(this.c);
              this.a.removeObserver(this.d);
              return;
            }
            QLog.d("TroopToDoHelper-TodoInfo", 4, "STOP");
            return;
          }
          QLog.d("TroopToDoHelper-TodoInfo", 4, "SHOW");
          d();
          this.g = false;
          return;
        }
        QLog.d("TroopToDoHelper-TodoInfo", 4, "SHOW_FIRST_BEGIN");
        this.g = true;
        long l = TroopTodoUtils.a(this.b);
        TodoInfoPresenter.a().a(l);
        return;
      }
      QLog.d("TroopToDoHelper-TodoInfo", 4, "CREATE");
      this.f = new TroopToDoTipsBarManage(this.b, this.e, this.a);
      this.a.addObserver(this.c);
      this.a.addObserver(this.d);
      return;
    }
    if (this.e == null) {
      this.e = new TroopToDoController(this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.TroopToDoHelper
 * JD-Core Version:    0.7.0.1
 */