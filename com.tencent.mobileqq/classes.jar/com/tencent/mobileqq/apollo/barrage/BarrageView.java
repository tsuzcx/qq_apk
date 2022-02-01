package com.tencent.mobileqq.apollo.barrage;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import com.tencent.mobileqq.apollo.script.SpriteContext;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.cmshow.engine.script.IScriptService;
import com.tencent.mobileqq.cmshow.engine.script.plugin.BarragePlugin;
import com.tencent.mobileqq.cmshow.engine.script.plugin.IEventPlugin;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import java.util.List;
import mqq.os.MqqHandler;

public class BarrageView
  extends View
  implements Handler.Callback, BarrageUI
{
  private AbsBarrageCache a;
  private CanvasDrawer b;
  private WeakReferenceHandler c;
  private int d = 0;
  private long e;
  private boolean f;
  private BarragePlugin g;
  private SpriteContext h;
  
  public BarrageView(Context paramContext, SpriteContext paramSpriteContext)
  {
    super(paramContext);
    this.h = paramSpriteContext;
    a(paramSpriteContext);
  }
  
  private void a(SpriteContext paramSpriteContext)
  {
    this.a = new ApolloBarrageCache();
    this.b = new CanvasDrawer();
    this.c = new WeakReferenceHandler(Looper.getMainLooper(), this);
    if (paramSpriteContext != null) {
      paramSpriteContext = paramSpriteContext.o();
    } else {
      paramSpriteContext = null;
    }
    if (paramSpriteContext != null)
    {
      this.g = new BarragePlugin(this);
      paramSpriteContext.a(this.g);
    }
  }
  
  private void c()
  {
    this.c.removeMessages(259);
    this.c.sendEmptyMessage(259);
  }
  
  public void a()
  {
    Object localObject = this.c;
    IScriptService localIScriptService = null;
    ((WeakReferenceHandler)localObject).removeCallbacksAndMessages(null);
    this.b.a(true);
    localObject = this.h;
    if (localObject != null) {
      localIScriptService = ((SpriteContext)localObject).o();
    }
    if (localIScriptService != null)
    {
      localObject = this.g;
      if (localObject != null) {
        localIScriptService.b((IEventPlugin)localObject);
      }
    }
  }
  
  public void a(List<Barrage> paramList, boolean paramBoolean)
  {
    if (paramList != null)
    {
      if (paramList.isEmpty()) {
        return;
      }
      ThreadManager.getSubThreadHandler().post(new BarrageView.PrebuildCacheTask(paramList, this));
    }
  }
  
  public void a(boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void b()
  {
    this.c.removeMessages(259);
    this.f = true;
  }
  
  public AbsBarrageCache getBarrageCache()
  {
    return this.a;
  }
  
  public int getUIHeight()
  {
    return super.getHeight();
  }
  
  public int getUIWidth()
  {
    return super.getWidth();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return false;
    case 259: 
      this.c.removeMessages(259);
      invalidate();
      this.f = false;
      return false;
    case 258: 
      if (paramMessage.arg1 > 0)
      {
        this.d = 1;
      }
      else
      {
        this.b.a(false);
        super.setVisibility(8);
      }
      this.e = System.currentTimeMillis();
      c();
      this.f = false;
      return false;
    case 257: 
      paramMessage = (Barrage)paramMessage.obj;
      this.b.a(paramMessage);
      this.d = 0;
      c();
      this.f = false;
      return false;
    }
    List localList = (List)paramMessage.obj;
    if (paramMessage.arg1 > 0) {
      this.b.a(false);
    }
    this.b.a(localList);
    this.d = 0;
    super.setVisibility(0);
    c();
    this.f = false;
    return false;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    System.currentTimeMillis();
    super.onDraw(paramCanvas);
    int i = this.d;
    float f1 = 1.0F;
    if (i == 1)
    {
      f1 = (float)(System.currentTimeMillis() - this.e) / 500.0F;
      if (f1 < 1.0F)
      {
        f1 = 1.0F - f1;
      }
      else
      {
        this.d = 0;
        this.b.a(false);
        this.c.sendEmptyMessageDelayed(259, 20L);
        return;
      }
    }
    if (this.b.a(paramCanvas, f1))
    {
      if (!this.f) {
        super.invalidate();
      }
    }
    else
    {
      super.setVisibility(8);
      if (QLog.isColorLevel()) {
        QLog.d("[cmshow]BarrageView", 2, "BarrageView setVisibility(GONE)");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.barrage.BarrageView
 * JD-Core Version:    0.7.0.1
 */