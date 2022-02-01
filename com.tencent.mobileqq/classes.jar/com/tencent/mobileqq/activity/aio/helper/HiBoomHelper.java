package com.tencent.mobileqq.activity.aio.helper;

import android.content.Context;
import android.graphics.Paint;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.coreui.input.EditTextUI;
import com.tencent.mobileqq.activity.aio.item.PicItemBuilder;
import com.tencent.mobileqq.activity.aio.zhitu.ZhituManager;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hiboom.HiBoomConstants;
import com.tencent.mobileqq.hiboom.api.HiBoomForwardAuthObserver;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.vas.api.IVasCommonAdapter;
import com.tencent.mobileqq.vas.font.api.IFontManagerService;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;

public class HiBoomHelper
  implements ILifeCycleHelper, AbsListView.OnScrollListener
{
  private Paint a;
  private BaseChatPie b;
  private BusinessObserver c;
  private HiBoomForwardAuthObserver d;
  
  public HiBoomHelper(BaseChatPie paramBaseChatPie)
  {
    this.b = paramBaseChatPie;
  }
  
  private void a()
  {
    BaseChatPie localBaseChatPie = this.b;
    if ((localBaseChatPie != null) && (localBaseChatPie.d != null))
    {
      if (this.c != null) {
        this.b.d.removeObserver(this.c);
      }
      if (this.d != null) {
        this.b.d.removeObserver(this.d);
      }
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString, int paramInt)
  {
    ReportController.b(paramQQAppInterface, "dc00898", "", "", "0X8008C70", "0X8008C70", ZhituManager.a(paramInt), 0, "", "", "", "");
    paramString = HiBoomConstants.a(paramString);
    if ((paramString != null) && (paramString.length() > 20))
    {
      QQToast.makeText(paramContext, HardCodeUtil.a(2131903444), 0).show();
      ReportController.b(paramQQAppInterface, "dc00898", "", "", "0X800932C", "0X800932C", 0, 0, "", "", "", "");
      return false;
    }
    return true;
  }
  
  private void b()
  {
    BaseChatPie localBaseChatPie = this.b;
    if ((localBaseChatPie != null) && (localBaseChatPie.d != null))
    {
      this.c = ((IVasCommonAdapter)QRoute.api(IVasCommonAdapter.class)).getHiBoomAuthObserver(this.b.aX());
      this.b.d.addObserver(this.c);
      this.d = new HiBoomForwardAuthObserver(this.b.aX());
      this.b.d.addObserver(this.d);
    }
  }
  
  private void c()
  {
    com.etrump.mixlayout.api.ETFontUtil.enableAnimation = true;
  }
  
  public boolean a(Context paramContext, String paramString, EditTextUI paramEditTextUI)
  {
    if (this.a == null) {
      this.a = new Paint();
    }
    this.a.setTypeface(paramEditTextUI.o());
    this.a.setTextSize(paramEditTextUI.p());
    return (paramString.length() < 200) && (!paramString.contains("\n")) && ((int)this.a.measureText(paramString) + AIOUtils.b(45.0F, paramContext.getResources()) + paramEditTextUI.e() < paramEditTextUI.q());
  }
  
  public String getTag()
  {
    return "HiBoomHelper";
  }
  
  public int[] interestedIn()
  {
    return new int[] { 4, 15, 10 };
  }
  
  public void onMoveToState(int paramInt)
  {
    if (paramInt != 4)
    {
      if (paramInt != 10)
      {
        if (paramInt != 15) {
          return;
        }
        a();
        return;
      }
      c();
      return;
    }
    b();
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt == 0)
    {
      com.etrump.mixlayout.api.ETFontUtil.enableAnimation = true;
      paramAbsListView = this.b;
      if ((paramAbsListView != null) && (paramAbsListView.d != null)) {
        ((IFontManagerService)this.b.d.getRuntimeService(IFontManagerService.class, "")).resumeFontAnimation(this.b);
      }
    }
    else if (!PicItemBuilder.C)
    {
      com.etrump.mixlayout.api.ETFontUtil.enableAnimation = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.HiBoomHelper
 * JD-Core Version:    0.7.0.1
 */