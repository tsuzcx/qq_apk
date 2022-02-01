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
  private int jdField_a_of_type_Int = 0;
  private long jdField_a_of_type_Long;
  private AbsBarrageCache jdField_a_of_type_ComTencentMobileqqApolloBarrageAbsBarrageCache;
  private CanvasDrawer jdField_a_of_type_ComTencentMobileqqApolloBarrageCanvasDrawer;
  private SpriteContext jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext;
  private BarragePlugin jdField_a_of_type_ComTencentMobileqqCmshowEngineScriptPluginBarragePlugin;
  private WeakReferenceHandler jdField_a_of_type_ComTencentUtilWeakReferenceHandler;
  private boolean jdField_a_of_type_Boolean;
  
  public BarrageView(Context paramContext, SpriteContext paramSpriteContext)
  {
    super(paramContext);
    this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext = paramSpriteContext;
    a(paramSpriteContext);
  }
  
  private void a(SpriteContext paramSpriteContext)
  {
    this.jdField_a_of_type_ComTencentMobileqqApolloBarrageAbsBarrageCache = new ApolloBarrageCache();
    this.jdField_a_of_type_ComTencentMobileqqApolloBarrageCanvasDrawer = new CanvasDrawer();
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler = new WeakReferenceHandler(Looper.getMainLooper(), this);
    if (paramSpriteContext != null) {
      paramSpriteContext = paramSpriteContext.a();
    } else {
      paramSpriteContext = null;
    }
    if (paramSpriteContext != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqCmshowEngineScriptPluginBarragePlugin = new BarragePlugin(this);
      paramSpriteContext.a(this.jdField_a_of_type_ComTencentMobileqqCmshowEngineScriptPluginBarragePlugin);
    }
  }
  
  private void c()
  {
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(259);
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessage(259);
  }
  
  public int a()
  {
    return super.getWidth();
  }
  
  public AbsBarrageCache a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqApolloBarrageAbsBarrageCache;
  }
  
  public void a()
  {
    Object localObject = this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler;
    IScriptService localIScriptService = null;
    ((WeakReferenceHandler)localObject).removeCallbacksAndMessages(null);
    this.jdField_a_of_type_ComTencentMobileqqApolloBarrageCanvasDrawer.a(true);
    localObject = this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext;
    if (localObject != null) {
      localIScriptService = ((SpriteContext)localObject).a();
    }
    if (localIScriptService != null)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqCmshowEngineScriptPluginBarragePlugin;
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
  
  public int b()
  {
    return super.getHeight();
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(259);
    this.jdField_a_of_type_Boolean = true;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return false;
    case 259: 
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(259);
      invalidate();
      this.jdField_a_of_type_Boolean = false;
      return false;
    case 258: 
      if (paramMessage.arg1 > 0)
      {
        this.jdField_a_of_type_Int = 1;
      }
      else
      {
        this.jdField_a_of_type_ComTencentMobileqqApolloBarrageCanvasDrawer.a(false);
        super.setVisibility(8);
      }
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      c();
      this.jdField_a_of_type_Boolean = false;
      return false;
    case 257: 
      paramMessage = (Barrage)paramMessage.obj;
      this.jdField_a_of_type_ComTencentMobileqqApolloBarrageCanvasDrawer.a(paramMessage);
      this.jdField_a_of_type_Int = 0;
      c();
      this.jdField_a_of_type_Boolean = false;
      return false;
    }
    List localList = (List)paramMessage.obj;
    if (paramMessage.arg1 > 0) {
      this.jdField_a_of_type_ComTencentMobileqqApolloBarrageCanvasDrawer.a(false);
    }
    this.jdField_a_of_type_ComTencentMobileqqApolloBarrageCanvasDrawer.a(localList);
    this.jdField_a_of_type_Int = 0;
    super.setVisibility(0);
    c();
    this.jdField_a_of_type_Boolean = false;
    return false;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    System.currentTimeMillis();
    super.onDraw(paramCanvas);
    int i = this.jdField_a_of_type_Int;
    float f = 1.0F;
    if (i == 1)
    {
      f = (float)(System.currentTimeMillis() - this.jdField_a_of_type_Long) / 500.0F;
      if (f < 1.0F)
      {
        f = 1.0F - f;
      }
      else
      {
        this.jdField_a_of_type_Int = 0;
        this.jdField_a_of_type_ComTencentMobileqqApolloBarrageCanvasDrawer.a(false);
        this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessageDelayed(259, 20L);
        return;
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqApolloBarrageCanvasDrawer.a(paramCanvas, f))
    {
      if (!this.jdField_a_of_type_Boolean) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.barrage.BarrageView
 * JD-Core Version:    0.7.0.1
 */