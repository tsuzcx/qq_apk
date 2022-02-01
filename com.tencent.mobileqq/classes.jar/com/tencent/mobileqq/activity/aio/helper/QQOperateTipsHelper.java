package com.tencent.mobileqq.activity.aio.helper;

import android.support.annotation.NonNull;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.panel.PanelListener;
import com.tencent.mobileqq.activity.aio.tips.QQOperateTips;
import com.tencent.mobileqq.activity.aio.tips.TipsManager;
import com.tencent.mobileqq.app.ConfigObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.operation.QQOperationViopTipTask;
import java.util.ArrayList;
import java.util.List;

public class QQOperateTipsHelper
  implements ILifeCycleHelper, PanelListener
{
  protected List<QQOperationViopTipTask> a = new ArrayList();
  private final AIOContext b;
  private QQOperateTips c;
  private ConfigObserver d = new QQOperateTipsHelper.1(this);
  
  public QQOperateTipsHelper(AIOContext paramAIOContext)
  {
    this.b = paramAIOContext;
  }
  
  @NonNull
  public String getTag()
  {
    return "QQOperateTipsHelper";
  }
  
  public int[] interestedIn()
  {
    return new int[] { 4, 10, 15 };
  }
  
  public void onHideAllPanel() {}
  
  public void onMoveToState(int paramInt)
  {
    if (paramInt != 4)
    {
      if (paramInt != 10)
      {
        if (paramInt != 15) {
          return;
        }
        this.c = null;
        this.b.a().removeObserver(this.d);
        return;
      }
      if (this.c == null)
      {
        this.c = new QQOperateTips(this.b, this.a);
        this.b.c().b(this.c);
      }
    }
    else
    {
      this.b.a().addObserver(this.d);
    }
  }
  
  public void onPanelChanged(int paramInt1, int paramInt2) {}
  
  public void onPanelIconClickBeforeCreate(int paramInt) {}
  
  public void postOnPanelChanged(int paramInt1, int paramInt2)
  {
    paramInt1 = this.b.k();
    paramInt2 = this.a.size();
    if (paramInt1 != 0)
    {
      paramInt1 = this.b.c().b();
      if ((paramInt1 == 5) || (paramInt1 == 6)) {
        this.b.c().c();
      }
    }
    else if ((paramInt2 != 0) && (this.c != null) && (!((FullScreenInputHelper)this.b.a(24)).e()))
    {
      QQOperationViopTipTask localQQOperationViopTipTask = (QQOperationViopTipTask)this.a.get(paramInt2 - 1);
      this.c.a(localQQOperationViopTipTask);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.QQOperateTipsHelper
 * JD-Core Version:    0.7.0.1
 */