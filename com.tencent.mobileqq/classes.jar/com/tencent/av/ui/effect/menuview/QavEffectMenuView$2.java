package com.tencent.av.ui.effect.menuview;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.opengl.effects.EffectController;
import com.tencent.av.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QavEffectMenuView$2
  implements View.OnClickListener
{
  QavEffectMenuView$2(QavEffectMenuView paramQavEffectMenuView) {}
  
  public void onClick(View paramView)
  {
    long l = AudioHelper.c();
    int i = paramView.getId();
    Object localObject = paramView.getTag(2131446795);
    if ((localObject instanceof Boolean)) {
      bool = ((Boolean)localObject).booleanValue();
    } else {
      bool = false;
    }
    int j = this.a.l;
    boolean bool = this.a.a(l, i, bool);
    if ((bool) && (j != i)) {
      QavEffectMenuView.b(this.a).a(new Object[] { Integer.valueOf(6105), Integer.valueOf(i), Long.valueOf(l) });
    }
    if (bool)
    {
      localObject = VideoController.f().m(true);
      if (localObject != null)
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("QavEffectMenuView", 1, "onShow clear state");
        }
        ((EffectController)localObject).a(i);
      }
    }
    QavEffectMenuView.c(this.a).a(new Object[] { Integer.valueOf(165), Integer.valueOf(1) });
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.effect.menuview.QavEffectMenuView.2
 * JD-Core Version:    0.7.0.1
 */