package com.tencent.mobileqq.activity.aio.troop.trooptodo;

import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.tencent.biz.videostory.FastClickUtils;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.msglist.MsgList;
import com.tencent.mobileqq.activity.aio.coreui.msglist.Scroller;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.data.trooptodo.TroopToDoBannerModel;
import com.tencent.mobileqq.data.trooptodo.TroopToDoBannerModel.Person;
import com.tencent.mobileqq.data.trooptodo.TroopToDoBannerModel.RawInfo;
import com.tencent.mobileqq.filemanager.util.QFileUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.data.TroopFileStatusInfo;
import com.tencent.mobileqq.troop.todo.TroopTodoReportUtils;
import com.tencent.mobileqq.troop.todo.TroopTodoReportUtils.ReportData;
import com.tencent.mobileqq.troop.todo.TroopTodoUtils;
import com.tencent.mobileqq.troop.trooptodo.handler.TroopToDoHandler;
import com.tencent.mobileqq.troop.utils.TroopFileUtils;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;

public class TroopToDoTipsBar
  implements View.OnClickListener
{
  @VisibleForTesting
  protected View a;
  @VisibleForTesting
  protected TextView b;
  @VisibleForTesting
  protected TextView c;
  @VisibleForTesting
  protected ImageView d;
  @VisibleForTesting
  protected TextView e;
  @VisibleForTesting
  protected URLImageView f;
  private QQAppInterface g;
  @NonNull
  private TroopToDoBannerModel h = new TroopToDoBannerModel();
  private TroopToDoHandler i;
  private AIOContext j;
  private TroopToDoController k;
  private boolean l = false;
  private TroopTodoReportUtils.ReportData m = new TroopTodoReportUtils.ReportData();
  
  public TroopToDoTipsBar(AIOContext paramAIOContext, QQAppInterface paramQQAppInterface, TroopToDoController paramTroopToDoController)
  {
    this.g = paramQQAppInterface;
    this.j = paramAIOContext;
    this.k = paramTroopToDoController;
    this.i = ((TroopToDoHandler)paramQQAppInterface.getBusinessHandler(TroopToDoHandler.class.getName()));
    f();
  }
  
  private void a(long paramLong)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[handlerMsgLocation] msgSeq = ");
    ((StringBuilder)localObject).append(paramLong);
    QLog.i("TroopToDoTipsBar-TodoInfo", 1, ((StringBuilder)localObject).toString());
    localObject = this.j;
    if (localObject == null)
    {
      QLog.e("TroopToDoTipsBar-TodoInfo", 1, "[handlerMsgLocation] aioContext null, return.");
      return;
    }
    ((AIOContext)localObject).e().d().a(104, paramLong, 0);
  }
  
  private void a(TroopToDoBannerModel paramTroopToDoBannerModel, URLImageView paramURLImageView)
  {
    paramURLImageView.setBackgroundURL(paramTroopToDoBannerModel.c());
    paramURLImageView.setVisibility(0);
  }
  
  private void b(TroopToDoBannerModel paramTroopToDoBannerModel)
  {
    this.d.setContentDescription(this.j.b().getString(2131917636));
    String str1 = this.j.b().getString(2131917638);
    String str2 = this.j.b().getString(2131917637);
    View localView = this.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str1);
    localStringBuilder.append(paramTroopToDoBannerModel.b());
    localStringBuilder.append(str2);
    localStringBuilder.append(paramTroopToDoBannerModel.a().b);
    localView.setContentDescription(localStringBuilder.toString());
  }
  
  private void c(TroopToDoBannerModel paramTroopToDoBannerModel)
  {
    this.m.a = TroopTodoReportUtils.a(this.g, paramTroopToDoBannerModel.e().a);
    this.m.b = paramTroopToDoBannerModel.e().f;
    this.m.c = paramTroopToDoBannerModel.e().g;
    this.m.d = paramTroopToDoBannerModel.e().h;
    paramTroopToDoBannerModel = new StringBuilder();
    paramTroopToDoBannerModel.append("reportData: ");
    paramTroopToDoBannerModel.append(this.m.toString());
    QLog.i("TroopToDoTipsBar-TodoInfo", 4, paramTroopToDoBannerModel.toString());
  }
  
  private void d(TroopToDoBannerModel paramTroopToDoBannerModel)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramTroopToDoBannerModel.a().b);
    localStringBuilder.append("设置了群待办");
    paramTroopToDoBannerModel = localStringBuilder.toString();
    this.e.setText(paramTroopToDoBannerModel);
    if (!this.l)
    {
      this.e.setTextColor(TroopTodoUtils.a(this.j, 2131168401));
      return;
    }
    this.e.setTextColor(TroopTodoUtils.a(this.j, 2131168402));
  }
  
  private void e(TroopToDoBannerModel paramTroopToDoBannerModel)
  {
    this.b.setText(paramTroopToDoBannerModel.b());
    if (!this.l)
    {
      this.b.setTextColor(TroopTodoUtils.a(this.j, 2131168397));
      return;
    }
    this.b.setTextColor(TroopTodoUtils.a(this.j, 2131168398));
  }
  
  private void f(TroopToDoBannerModel paramTroopToDoBannerModel)
  {
    if (paramTroopToDoBannerModel.e().d == 3)
    {
      p();
      return;
    }
    if (paramTroopToDoBannerModel.e().d == 1)
    {
      if (TroopTodoUtils.a(this.g, paramTroopToDoBannerModel.e().a)) {
        g();
      }
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("initTaskStatusBtn state error: ");
    localStringBuilder.append(paramTroopToDoBannerModel.toString());
    QLog.e("TroopToDoTipsBar-TodoInfo", 4, localStringBuilder.toString());
  }
  
  private void i()
  {
    if (!this.l)
    {
      this.a.setBackgroundResource(2130853396);
      this.d.setImageResource(2130853393);
      return;
    }
    this.a.setBackgroundResource(2130853397);
    this.d.setImageResource(2130853394);
  }
  
  private void j()
  {
    if (FastClickUtils.a("TroopToDoTipsBar-TodoInfoonBannerClick")) {
      return;
    }
    if (this.h.d() == -1)
    {
      QLog.e("TroopToDoTipsBar-TodoInfo", 1, "onBannerClick: model is not initialized");
      return;
    }
    if (this.h.d() == 2)
    {
      ReportController.b(this.g, "dc00898", "", "", "0X800BC76", "0X800BC76", 0, 0, String.valueOf(this.m.a), String.valueOf(this.m.b), this.m.c, String.valueOf(this.m.d));
      k();
    }
    else if (this.h.d() == 1)
    {
      a(this.h.e().b);
    }
    this.c.setVisibility(0);
  }
  
  private void k()
  {
    if (this.h.b().startsWith("[文件]"))
    {
      localObject = TroopTodoUtils.a(this.g, this.j, this.h.e().b);
      if ((localObject != null) && ((localObject instanceof MessageForTroopFile)))
      {
        localObject = (MessageForTroopFile)localObject;
        TroopFileStatusInfo localTroopFileStatusInfo = TroopFileUtils.a(this.g, (MessageForTroopFile)localObject);
        long l1 = TroopTodoUtils.a(this.j);
        SessionInfo localSessionInfo = (SessionInfo)this.j.O();
        QFileUtils.a(this.g, this.j.b(), localSessionInfo, (ChatMessage)localObject, l1, localTroopFileStatusInfo, ((MessageForTroopFile)localObject).senderuin, ((MessageForTroopFile)localObject).lastTime, 3, 3, null, false, false);
        return;
      }
      a(this.h.e().b);
      return;
    }
    Object localObject = new Intent();
    ((Intent)localObject).putExtra("url", this.h.e().e);
    RouteUtils.a(this.j.b(), (Intent)localObject, "/base/browser");
  }
  
  private void l()
  {
    if (FastClickUtils.a("TroopToDoTipsBar-TodoInfoonClose")) {
      return;
    }
    if (this.h.d() == -1)
    {
      QLog.e("TroopToDoTipsBar-TodoInfo", 1, "onClose: model is not initialized");
      return;
    }
    if (TroopTodoUtils.a(this.g, this.h.e().a))
    {
      n();
      return;
    }
    m();
  }
  
  private void m()
  {
    ReportController.b(this.g, "dc00898", "", "", "0X800BC78", "0X800BC78", 0, 0, String.valueOf(this.m.a), String.valueOf(this.m.b), this.m.c, String.valueOf(this.m.d));
    TroopToDoBannerModel.RawInfo localRawInfo = this.h.e();
    this.i.d(localRawInfo.a, localRawInfo.b, localRawInfo.c);
  }
  
  private void n()
  {
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.b(this.j.b(), null);
    localActionSheet.setMainTitle(2131917644);
    localActionSheet.addButton(2131917645);
    localActionSheet.addButton(2131917643);
    localActionSheet.addCancelButton(2131917642);
    localActionSheet.setOnButtonClickListener(new TroopToDoTipsBar.1(this, localActionSheet));
    localActionSheet.show();
  }
  
  private void o()
  {
    if (FastClickUtils.a("TroopToDoTipsBar-TodoInfoonComplete")) {
      return;
    }
    if (this.h.d() == -1)
    {
      QLog.e("TroopToDoTipsBar-TodoInfo", 1, "onComplete: model is not initialized");
      return;
    }
    ReportController.b(this.g, "dc00898", "", "", "0X800BC77", "0X800BC77", 0, 0, String.valueOf(this.m.a), String.valueOf(this.m.b), this.m.c, String.valueOf(this.m.d));
    if (this.c.getText().equals(this.j.b().getString(2131917647))) {
      return;
    }
    TroopToDoBannerModel.RawInfo localRawInfo = this.h.e();
    this.i.a(localRawInfo.a, localRawInfo.b, localRawInfo.c);
  }
  
  private void p()
  {
    this.c.setText(this.j.b().getString(2131917648));
    if (!this.l) {
      this.c.setTextColor(TroopTodoUtils.a(this.j, 2131168405));
    } else {
      this.c.setTextColor(TroopTodoUtils.a(this.j, 2131168406));
    }
    this.c.setVisibility(8);
  }
  
  public int a()
  {
    int n = View.MeasureSpec.makeMeasureSpec(0, 0);
    int i1 = View.MeasureSpec.makeMeasureSpec(0, 0);
    this.a.measure(n, i1);
    Object localObject = this.j.b().getResources();
    float f1 = AIOUtils.b(this.a.getMeasuredHeight(), (Resources)localObject);
    float f2 = AIOUtils.b(this.a.getMeasuredWidth(), (Resources)localObject);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("getBarHeight heightDp = ");
    ((StringBuilder)localObject).append(f1);
    ((StringBuilder)localObject).append(", widthDp = ");
    ((StringBuilder)localObject).append(f2);
    QLog.i("TroopToDoTipsBar-TodoInfo", 1, ((StringBuilder)localObject).toString());
    return (int)f1;
  }
  
  public void a(TroopToDoBannerModel paramTroopToDoBannerModel)
  {
    if (paramTroopToDoBannerModel == null)
    {
      QLog.i("TroopToDoTipsBar-TodoInfo", 1, "updateUI : model =null");
      return;
    }
    this.h = paramTroopToDoBannerModel;
    this.l = ThemeUtil.isNowThemeIsNight(this.g, false, null);
    i();
    a(paramTroopToDoBannerModel, this.f);
    e(paramTroopToDoBannerModel);
    d(paramTroopToDoBannerModel);
    f(paramTroopToDoBannerModel);
    c(paramTroopToDoBannerModel);
    b(paramTroopToDoBannerModel);
  }
  
  public TroopTodoReportUtils.ReportData b()
  {
    return this.m;
  }
  
  public boolean c()
  {
    return this.k.c();
  }
  
  public void d()
  {
    ReportController.b(this.g, "dc00898", "", "", "0X800BC74", "0X800BC74", 0, 0, String.valueOf(this.m.a), String.valueOf(this.m.b), this.m.c, String.valueOf(this.m.d));
    this.k.a(this.l);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("showTroopToDoBanner: ");
    localStringBuilder.append(this.k.b().getVisibility());
    QLog.i("TroopToDoTipsBar-TodoInfo", 4, localStringBuilder.toString());
    TroopTodoUtils.a(true);
  }
  
  public void e()
  {
    this.k.a();
    TroopTodoUtils.a(false);
    TroopTodoUtils.b();
    this.j.e().d().a(0);
  }
  
  protected void f()
  {
    this.a = this.k.b();
    this.b = ((TextView)this.a.findViewById(2131447660));
    this.c = ((TextView)this.a.findViewById(2131447657));
    this.d = ((ImageView)this.a.findViewById(2131447659));
    this.e = ((TextView)this.a.findViewById(2131447662));
    this.f = ((URLImageView)this.a.findViewById(2131447661));
    this.a.setOnClickListener(this);
    this.c.setOnClickListener(this);
    this.d.setOnClickListener(this);
  }
  
  public void g()
  {
    this.c.setText(this.j.b().getString(2131917647));
    if (!this.l) {
      this.c.setTextColor(TroopTodoUtils.a(this.j, 2131168403));
    } else {
      this.c.setTextColor(TroopTodoUtils.a(this.j, 2131168404));
    }
    this.c.setVisibility(0);
  }
  
  public TroopToDoBannerModel h()
  {
    return this.h;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    case 2131447658: 
    default: 
      break;
    case 2131447659: 
      l();
      break;
    case 2131447657: 
      o();
      break;
    case 2131447656: 
      j();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.troop.trooptodo.TroopToDoTipsBar
 * JD-Core Version:    0.7.0.1
 */