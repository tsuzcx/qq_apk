package com.tencent.mobileqq.apollo.barrage;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import java.util.List;
import mqq.os.MqqHandler;
import yox;

public class BarrageView
  extends View
  implements Handler.Callback, BarrageUI
{
  private int jdField_a_of_type_Int = 0;
  private long jdField_a_of_type_Long;
  private AbsBarrageCache jdField_a_of_type_ComTencentMobileqqApolloBarrageAbsBarrageCache;
  private CanvasDrawer jdField_a_of_type_ComTencentMobileqqApolloBarrageCanvasDrawer;
  private WeakReferenceHandler jdField_a_of_type_ComTencentUtilWeakReferenceHandler;
  private boolean jdField_a_of_type_Boolean;
  
  public BarrageView(Context paramContext)
  {
    super(paramContext);
    c();
  }
  
  public BarrageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    c();
  }
  
  private void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqApolloBarrageAbsBarrageCache = new ApolloBarrageCache();
    this.jdField_a_of_type_ComTencentMobileqqApolloBarrageCanvasDrawer = new CanvasDrawer();
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler = new WeakReferenceHandler(Looper.getMainLooper(), this);
  }
  
  private void d()
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
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_ComTencentMobileqqApolloBarrageCanvasDrawer.a(true);
  }
  
  public void a(List paramList, boolean paramBoolean)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return;
    }
    ThreadManager.getSubThreadHandler().post(new yox(paramList, this));
  }
  
  public void a(boolean paramBoolean)
  {
    WeakReferenceHandler localWeakReferenceHandler;
    if (this.jdField_a_of_type_ComTencentMobileqqApolloBarrageCanvasDrawer.a())
    {
      localWeakReferenceHandler = this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler;
      if (!paramBoolean) {
        break label34;
      }
    }
    label34:
    for (int i = 1;; i = 0)
    {
      localWeakReferenceHandler.obtainMessage(258, i, 0).sendToTarget();
      return;
    }
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
    case 256: 
      List localList = (List)paramMessage.obj;
      if (paramMessage.arg1 > 0) {
        this.jdField_a_of_type_ComTencentMobileqqApolloBarrageCanvasDrawer.a(false);
      }
      this.jdField_a_of_type_ComTencentMobileqqApolloBarrageCanvasDrawer.a(localList);
      this.jdField_a_of_type_Int = 0;
      super.setVisibility(0);
      d();
      this.jdField_a_of_type_Boolean = false;
      return false;
    case 257: 
      paramMessage = (Barrage)paramMessage.obj;
      this.jdField_a_of_type_ComTencentMobileqqApolloBarrageCanvasDrawer.a(paramMessage);
      this.jdField_a_of_type_Int = 0;
      d();
      this.jdField_a_of_type_Boolean = false;
      return false;
    case 258: 
      if (paramMessage.arg1 > 0) {
        this.jdField_a_of_type_Int = 1;
      }
      for (;;)
      {
        this.jdField_a_of_type_Long = System.currentTimeMillis();
        d();
        this.jdField_a_of_type_Boolean = false;
        return false;
        this.jdField_a_of_type_ComTencentMobileqqApolloBarrageCanvasDrawer.a(false);
        super.setVisibility(8);
      }
    }
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(259);
    invalidate();
    this.jdField_a_of_type_Boolean = false;
    return false;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    float f = 1.0F;
    System.currentTimeMillis();
    super.onDraw(paramCanvas);
    if (this.jdField_a_of_type_Int == 1)
    {
      f = (float)(System.currentTimeMillis() - this.jdField_a_of_type_Long) / 500.0F;
      if (f < 1.0F) {
        f = 1.0F - f;
      }
    }
    else
    {
      if (!this.jdField_a_of_type_ComTencentMobileqqApolloBarrageCanvasDrawer.a(paramCanvas, f)) {
        break label94;
      }
      if (!this.jdField_a_of_type_Boolean) {
        super.invalidate();
      }
    }
    label94:
    do
    {
      return;
      this.jdField_a_of_type_Int = 0;
      this.jdField_a_of_type_ComTencentMobileqqApolloBarrageCanvasDrawer.a(false);
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessageDelayed(259, 20L);
      return;
      super.setVisibility(8);
    } while (!QLog.isColorLevel());
    QLog.d("BarrageView", 2, "BarrageView setVisibility(GONE)");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.barrage.BarrageView
 * JD-Core Version:    0.7.0.1
 */