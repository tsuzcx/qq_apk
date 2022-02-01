package com.tencent.mobileqq.activity.aio;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.HandlerThread;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.item.ClickedWaveView.OnTouchReceive;
import com.tencent.mobileqq.activity.aio.item.CustomFrameAnimationDrawable;
import com.tencent.mobileqq.activity.aio.item.PokeItemAnimationManager;
import com.tencent.mobileqq.activity.aio.item.PokeItemHelper;
import com.tencent.mobileqq.apollo.handler.IApolloExtensionObserver;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.utils.PokeBigResHandler;
import com.tencent.mobileqq.earlydownload.api.IEarlyDownloadService;
import com.tencent.mobileqq.earlydownload.handler.PokeResHandler;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.vas.updatesystem.api.IVasQuickUpdateService;
import com.tencent.mobileqq.vas.updatesystem.callback.CallBacker;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinnableBitmapDrawable;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.os.MqqHandler;

public class PokePanel
  extends RelativeLayout
  implements View.OnClickListener, ClickedWaveView.OnTouchReceive, AbsListView.OnScrollListener
{
  public static boolean f = false;
  HandlerThread a;
  MqqHandler b;
  BaseChatPie c;
  public boolean d = false;
  public boolean e = false;
  CallBacker g = new PokePanel.3(this);
  long h = 0L;
  long i = 0L;
  int j = -1;
  int k = 1;
  IApolloExtensionObserver l = new PokePanel.4(this);
  private ListView m;
  private SessionInfo n;
  private QQAppInterface o;
  private PokePanelAdapter p;
  private String q;
  private boolean r = false;
  private boolean s = false;
  private ArrayList<int[]> t;
  private final int[] u = { 2131918209, 2130839317, 3 };
  private final int[] v = { 2131892674, 2130839277, 1 };
  private final int[] w = { 2131890046, 2130839275, 2 };
  private final int[] x = { 2131890671, 2130839315, 4 };
  private final int[] y = { 2131890678, 2130839316, 5 };
  private final int[] z = { 2131890169, 2130839278, 6 };
  
  public PokePanel(Context paramContext)
  {
    super(paramContext);
  }
  
  public PokePanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    if (!f) {
      ThreadManager.excute(new PokePanel.1(paramQQAppInterface), 64, null, true);
    }
  }
  
  private void a(ArrayList<PokePanel.PokeData> paramArrayList)
  {
    int i1 = 0;
    while (i1 < this.t.size())
    {
      int[] arrayOfInt = (int[])this.t.get(i1);
      PokePanel.PokeData localPokeData = new PokePanel.PokeData();
      if ((arrayOfInt[2] == 1) && (!PokeItemHelper.e(arrayOfInt[2])))
      {
        localPokeData.b = BaseApplicationImpl.getContext().getResources().getDrawable(2130838155);
      }
      else if ((arrayOfInt[2] != 0) && (PokeItemHelper.e(arrayOfInt[2])))
      {
        switch (arrayOfInt[2])
        {
        default: 
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(PokeItemAnimationManager.b);
          ((StringBuilder)localObject1).append("/chuo_icon/chuo_icon_");
          localObject1 = ((StringBuilder)localObject1).toString();
          break;
        case 6: 
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(PokeItemAnimationManager.b);
          ((StringBuilder)localObject1).append("/dazhao_icon/dazhao_icon_");
          localObject1 = ((StringBuilder)localObject1).toString();
          break;
        case 5: 
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(PokeItemAnimationManager.b);
          ((StringBuilder)localObject1).append("/666_icon/666_icon_");
          localObject1 = ((StringBuilder)localObject1).toString();
          break;
        case 4: 
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(PokeItemAnimationManager.b);
          ((StringBuilder)localObject1).append("/xinsui_icon/xinsui_icon_");
          localObject1 = ((StringBuilder)localObject1).toString();
          break;
        case 3: 
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(PokeItemAnimationManager.b);
          ((StringBuilder)localObject1).append("/zan_icon/zan_icon_");
          localObject1 = ((StringBuilder)localObject1).toString();
          break;
        case 2: 
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(PokeItemAnimationManager.b);
          ((StringBuilder)localObject1).append("/bixin_icon/bixin_icon_");
          localObject1 = ((StringBuilder)localObject1).toString();
          break;
        case 1: 
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(PokeItemAnimationManager.b);
          ((StringBuilder)localObject1).append("/chuo_icon/chuo_icon_");
          localObject1 = ((StringBuilder)localObject1).toString();
        }
        Object localObject2 = new BitmapFactory.Options();
        ((BitmapFactory.Options)localObject2).inSampleSize = 1;
        ((BitmapFactory.Options)localObject2).inMutable = true;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append((String)localObject1);
        localStringBuilder.append("01.png");
        localObject2 = ImageUtil.a(localStringBuilder.toString(), (BitmapFactory.Options)localObject2);
        localObject2 = new CustomFrameAnimationDrawable(BaseApplicationImpl.getContext().getResources(), (Bitmap)localObject2, this.b);
        int i3;
        for (int i2 = 0; i2 < 22; i2 = i3)
        {
          i3 = i2 + 1;
          if (i3 < 10)
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append((String)localObject1);
            localStringBuilder.append("0");
            localStringBuilder.append(i3);
            localStringBuilder.append(".png");
            ((CustomFrameAnimationDrawable)localObject2).a(i2, 40, localStringBuilder.toString());
          }
          else
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append((String)localObject1);
            localStringBuilder.append(i3);
            localStringBuilder.append(".png");
            ((CustomFrameAnimationDrawable)localObject2).a(i2, 40, localStringBuilder.toString());
          }
        }
        localPokeData.b = ((Drawable)localObject2);
      }
      else
      {
        localPokeData.b = BaseApplicationImpl.getContext().getResources().getDrawable(arrayOfInt[1]);
      }
      localPokeData.a = arrayOfInt[2];
      localPokeData.c = arrayOfInt[1];
      localPokeData.d = BaseApplicationImpl.getContext().getResources().getString(arrayOfInt[0]);
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(BaseApplicationImpl.getContext().getResources().getString(arrayOfInt[0]));
      ((StringBuilder)localObject1).append(HardCodeUtil.a(2131906110));
      localPokeData.e = ((StringBuilder)localObject1).toString();
      localPokeData.h = false;
      paramArrayList.add(localPokeData);
      i1 += 1;
    }
  }
  
  private void b(Bundle paramBundle)
  {
    int i2 = paramBundle.getInt("type");
    int i1 = paramBundle.getInt("id");
    Object localObject = paramBundle.getString("name");
    String str = paramBundle.getString("minVersion");
    int i3 = paramBundle.getInt("feeType");
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("panel sendPokeMsg type:");
      localStringBuilder.append(this.n);
      QLog.d("PokeMsg", 2, new Object[] { localStringBuilder.toString(), Integer.valueOf(1) });
    }
    switch (i1)
    {
    }
    for (;;)
    {
      break;
      ChatActivityFacade.a(this.o, BaseApplicationImpl.getContext(), this.n, 3, "", "");
      ReportController.b(this.o, "CliOper", "", this.n.b, "0X8007F22", "0X8007F22", 3, 0, "", "", "", "");
      continue;
      if (this.h == 0L)
      {
        this.h = SystemClock.currentThreadTimeMillis();
      }
      else
      {
        if (SystemClock.currentThreadTimeMillis() - this.h < 500L) {
          return;
        }
        this.h = SystemClock.currentThreadTimeMillis();
      }
      this.h = SystemClock.currentThreadTimeMillis();
      ChatActivityFacade.a(this.o, BaseApplicationImpl.getContext(), this.n, 5, "", "");
      ReportController.b(this.o, "CliOper", "", this.n.b, "0X8007F22", "0X8007F22", 5, 0, "", "", "", "");
      break;
      ChatActivityFacade.a(this.o, BaseApplicationImpl.getContext(), this.n, 4, "", "");
      ReportController.b(this.o, "CliOper", "", this.n.b, "0X8007F22", "0X8007F22", 4, 0, "", "", "", "");
      break;
      if (this.i == 0L)
      {
        this.i = SystemClock.currentThreadTimeMillis();
      }
      else
      {
        if (SystemClock.currentThreadTimeMillis() - this.i < 500L) {
          return;
        }
        this.i = SystemClock.currentThreadTimeMillis();
      }
      ChatActivityFacade.a(this.o, BaseApplicationImpl.getContext(), this.n, 6, "", "");
      ReportController.b(this.o, "CliOper", "", this.n.b, "0X8007F22", "0X8007F22", 6, 0, "", "", "", "");
      break;
      ChatActivityFacade.a(this.o, BaseApplicationImpl.getContext(), this.n, 1, "", "");
      ReportController.b(this.o, "CliOper", "", this.n.b, "0X8007F22", "0X8007F22", 1, 0, "", "", "", "");
      break;
      ChatActivityFacade.a(this.o, BaseApplicationImpl.getContext(), this.n, 2, "", "");
      ReportController.b(this.o, "CliOper", "", this.n.b, "0X8007F22", "0X8007F22", 2, 0, "", "", "", "");
    }
    if (126 == i2)
    {
      if (paramBundle.getBoolean("isShowLoading"))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.aio.PokePanel", 2, "poke item is downloading, do nothing");
        }
        return;
      }
      if (paramBundle.getBoolean("isShowDownload"))
      {
        this.p.a("poke.item.res.", i1, true, false);
        paramBundle = (IVasQuickUpdateService)this.o.getRuntimeService(IVasQuickUpdateService.class, "");
        if (!PokeItemHelper.a("effect.gif", i1))
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("poke.item.effect.");
          ((StringBuilder)localObject).append(i1);
          paramBundle.downloadItem(21L, ((StringBuilder)localObject).toString(), "clickDownload");
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("poke.item.res.");
        ((StringBuilder)localObject).append(i1);
        paramBundle.downloadItem(21L, ((StringBuilder)localObject).toString(), "clickDownload");
        paramBundle.addCallBacker(this.g);
        return;
      }
      if (!PokeItemHelper.l)
      {
        PokeItemHelper.l = true;
        PokeItemHelper.a(this.o, i1, (String)localObject, i3, str, 0);
      }
    }
  }
  
  private void b(String paramString)
  {
    int i2 = paramString.length();
    int i1 = 0;
    while (i1 < i2)
    {
      switch (paramString.charAt(i1))
      {
      default: 
        break;
      case '6': 
        this.t.add(this.z);
        break;
      case '5': 
        this.t.add(this.y);
        break;
      case '4': 
        this.t.add(this.x);
        break;
      case '3': 
        this.t.add(this.u);
        break;
      case '2': 
        this.t.add(this.w);
        break;
      case '1': 
        this.t.add(this.v);
      }
      i1 += 1;
    }
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface)
  {
    if (f) {
      return true;
    }
    if ((PokeItemHelper.e(2)) && (PokeItemHelper.e(3)) && (PokeItemHelper.e(4)) && (PokeItemHelper.e(5)) && (PokeItemHelper.e(6)) && (PokeBigResHandler.a()))
    {
      PokeItemHelper.a(paramQQAppInterface, null);
      f = true;
      return true;
    }
    Object localObject = (IEarlyDownloadService)paramQQAppInterface.getRuntimeService(IEarlyDownloadService.class, "");
    if (localObject != null)
    {
      localObject = (PokeResHandler)((IEarlyDownloadService)localObject).getEarlyHandler("qq.android.poke.res_0625");
      paramQQAppInterface = (PokeBigResHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.POKE_BIG_RES_HANDLER);
      if (localObject != null) {
        ((PokeResHandler)localObject).a(true);
      }
      if ((paramQQAppInterface != null) && (!PokeBigResHandler.a())) {
        paramQQAppInterface.a(true);
      }
    }
    f = false;
    return false;
  }
  
  public void a()
  {
    this.r = true;
  }
  
  public void a(Bundle paramBundle)
  {
    if (!this.s) {
      b(paramBundle);
    }
    this.s = false;
  }
  
  public void a(BaseChatPie paramBaseChatPie, SessionInfo paramSessionInfo, String paramString)
  {
    this.n = paramSessionInfo;
    this.c = paramBaseChatPie;
    this.o = paramBaseChatPie.i();
    this.m = ((ListView)findViewById(2131435253));
    this.m.setOnScrollListener(this);
    this.c.aX().addObserver(this.l);
    paramBaseChatPie = getResources().getDrawable(2130852413);
    if ((paramBaseChatPie instanceof BitmapDrawable))
    {
      paramSessionInfo = (BitmapDrawable)paramBaseChatPie;
      paramSessionInfo.setTileModeXY(Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
      paramSessionInfo.setDither(true);
      setBackgroundDrawable(paramBaseChatPie);
    }
    else if ((paramBaseChatPie instanceof SkinnableBitmapDrawable))
    {
      paramSessionInfo = (SkinnableBitmapDrawable)paramBaseChatPie;
      paramSessionInfo.setTileModeXY(Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
      paramSessionInfo.setDither(true);
      setBackgroundDrawable(paramBaseChatPie);
    }
    this.q = paramString;
  }
  
  public void a(String paramString)
  {
    ArrayList localArrayList = this.t;
    if (localArrayList == null) {
      this.t = new ArrayList();
    } else {
      localArrayList.clear();
    }
    localArrayList = new ArrayList();
    if (this.a == null)
    {
      this.a = ThreadManager.newFreeHandlerThread("PokePanelAnimThread", 0);
      this.a.start();
      this.b = new MqqHandler(this.a.getLooper());
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.aio.PokePanel", 2, "[pokepanel]reload()");
    }
    this.p = new PokePanelAdapter(BaseApplication.getContext());
    this.p.a(this);
    this.p.a(this);
    this.m.setAdapter(this.p);
    ThreadManager.getFileThreadHandler().post(new PokePanel.2(this, paramString, localArrayList));
  }
  
  public void b()
  {
    ArrayList localArrayList = this.t;
    if (localArrayList != null) {
      localArrayList.clear();
    }
  }
  
  public void c()
  {
    if (this.e) {
      return;
    }
    this.e = true;
    try
    {
      this.b.removeCallbacksAndMessages(null);
      this.a.quit();
      this.a = null;
      Object localObject1 = this.p.a();
      Object localObject2;
      if ((localObject1 != null) && (((ArrayList)localObject1).size() > 0))
      {
        localObject1 = ((ArrayList)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (PokePanel.PokeData)((Iterator)localObject1).next();
          if ((((PokePanel.PokeData)localObject2).b instanceof CustomFrameAnimationDrawable)) {
            ((CustomFrameAnimationDrawable)((PokePanel.PokeData)localObject2).b).m();
          }
        }
      }
      return;
    }
    catch (Exception localException)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("ondestroy err ");
      ((StringBuilder)localObject2).append(localException);
      QLog.d("Q.aio.PokePanel", 1, ((StringBuilder)localObject2).toString());
      this.c.aX().removeObserver(this.l);
      ((IVasQuickUpdateService)this.o.getRuntimeService(IVasQuickUpdateService.class, "")).removeCallBacker(this.g);
    }
  }
  
  public void d()
  {
    if (this.d)
    {
      this.d = false;
      Object localObject = this.p.a();
      if ((localObject != null) && (((ArrayList)localObject).size() > 0))
      {
        localObject = ((ArrayList)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          PokePanel.PokeData localPokeData = (PokePanel.PokeData)((Iterator)localObject).next();
          if ((localPokeData.b instanceof CustomFrameAnimationDrawable)) {
            ((CustomFrameAnimationDrawable)localPokeData.b).o();
          }
        }
      }
    }
    ((PokeBigResHandler)this.o.getBusinessHandler(BusinessHandlerFactory.POKE_BIG_RES_HANDLER)).a(false);
  }
  
  public void e()
  {
    if (!this.d)
    {
      Object localObject = this.p;
      if (localObject != null)
      {
        this.d = true;
        localObject = ((PokePanelAdapter)localObject).a();
        if ((localObject != null) && (((ArrayList)localObject).size() > 0))
        {
          localObject = ((ArrayList)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            PokePanel.PokeData localPokeData = (PokePanel.PokeData)((Iterator)localObject).next();
            if ((localPokeData.b instanceof CustomFrameAnimationDrawable)) {
              ((CustomFrameAnimationDrawable)localPokeData.b).n();
            }
          }
        }
      }
    }
  }
  
  public void onClick(View paramView) {}
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    c();
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if ((paramInt != 0) && (this.r))
    {
      this.s = true;
      return;
    }
    this.s = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.PokePanel
 * JD-Core Version:    0.7.0.1
 */