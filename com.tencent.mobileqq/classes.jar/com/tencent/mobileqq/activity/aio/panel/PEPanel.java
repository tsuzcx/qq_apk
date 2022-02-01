package com.tencent.mobileqq.activity.aio.panel;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.PokeEmoPanelAdapter;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.item.PokeItemHelper;
import com.tencent.mobileqq.activity.aio.stickerbubble.PEPanelHelper;
import com.tencent.mobileqq.activity.aio.stickerbubble.StickerBubbleListView;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;
import com.tencent.mobileqq.dinifly.LottieComposition.Factory;
import com.tencent.mobileqq.dinifly.OnCompositionLoadedListener;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import com.tencent.widget.XPanelContainer;
import java.io.FileInputStream;
import mqq.os.MqqHandler;

public class PEPanel
  extends FrameLayout
{
  private ListView a;
  private PokeEmoPanelAdapter b;
  private DiniFlyAnimationView c;
  private PEPanel.ZuiAnimListenner d;
  private BaseChatPie e;
  private SessionInfo f;
  private String g;
  private boolean h;
  private boolean i = true;
  private long j;
  private MqqHandler k;
  
  public PEPanel(@NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  public PEPanel(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public PEPanel(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void a()
  {
    String str = this.g;
    Object localObject = this.c;
    if (QLog.isColorLevel()) {
      QLog.d("PokeEmo.PEPanel", 2, String.format(" playLottieAnim isAlreadyAnimating = %b,mIsLottieJsonLoaded = %b", new Object[] { Boolean.valueOf(((DiniFlyAnimationView)localObject).isAnimating()), Boolean.valueOf(this.h) }));
    }
    if (((DiniFlyAnimationView)localObject).isAnimating()) {
      return;
    }
    if (!this.h) {
      try
      {
        localObject = new PEPanel.2(this, (DiniFlyAnimationView)localObject);
        LottieComposition.Factory.fromInputStream(getContext(), new FileInputStream(str), (OnCompositionLoadedListener)localObject);
        this.h = true;
      }
      catch (Exception localException)
      {
        this.a.setVisibility(0);
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("load lottie exception ,msg = ");
          ((StringBuilder)localObject).append(localException.getMessage());
          QLog.d("PokeEmo.PEPanel", 2, ((StringBuilder)localObject).toString());
        }
      }
    }
    int m = PokeItemHelper.b(this.e.i(), 4);
    int n = PokeItemHelper.b(this.e.i(), 1);
    if ((m == 1) && (n > 0)) {}
    do
    {
      m = 1;
      break;
      if ((m == 0) && (n > 0))
      {
        m = 2;
        break;
      }
      if ((m == 1) && (n == 0))
      {
        m = 3;
        break;
      }
    } while ((m != 0) || (n != 0));
    m = 4;
    ReportController.b(this.e.i(), "dc00898", "", "", "0X8009221", "0X8009221", m, 0, "", "", "", "");
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  public void a(BaseChatPie paramBaseChatPie, SessionInfo paramSessionInfo)
  {
    this.f = paramSessionInfo;
    this.e = paramBaseChatPie;
    paramBaseChatPie = new DiniFlyAnimationView(getContext());
    paramSessionInfo = new FrameLayout.LayoutParams(-1, XPanelContainer.a - AIOUtils.b(40.0F, getResources()));
    this.c = paramBaseChatPie;
    addView(paramBaseChatPie, paramSessionInfo);
    this.a = new StickerBubbleListView(getContext(), this.e);
    paramBaseChatPie = new FrameLayout.LayoutParams(-1, -1);
    paramBaseChatPie.topMargin = AIOUtils.b(30.0F, getResources());
    this.a.setLayoutParams(paramBaseChatPie);
    this.a.setPadding(0, 0, 0, 0);
    this.a.setDivider(null);
    this.a.setScrollbarFadingEnabled(true);
    this.a.setVerticalFadingEdgeEnabled(true);
    this.a.setSelector(new ColorDrawable(0));
    addView(this.a, paramBaseChatPie);
    this.d = new PEPanel.ZuiAnimListenner(this);
    paramBaseChatPie = new StringBuilder();
    paramBaseChatPie.append(PEPanelHelper.c);
    paramBaseChatPie.append("aio_panel_pe_ani.json");
    this.g = paramBaseChatPie.toString();
    this.k = new MqqHandler(Looper.myLooper(), new PEPanel.1(this));
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PokeEmo.PEPanel", 2, String.format(" reload..reload = %s", new Object[] { paramString }));
    }
    paramString = PEPanelHelper.b(paramString);
    this.b = new PokeEmoPanelAdapter(BaseApplication.getContext());
    this.a.setAdapter(this.b);
    this.b.a(paramString);
    this.a.setSelection(0);
  }
  
  public void b() {}
  
  public void c() {}
  
  public void setListViewVisibile(int paramInt)
  {
    this.a.setVisibility(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.panel.PEPanel
 * JD-Core Version:    0.7.0.1
 */