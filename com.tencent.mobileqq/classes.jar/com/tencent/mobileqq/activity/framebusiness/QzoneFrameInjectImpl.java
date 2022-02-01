package com.tencent.mobileqq.activity.framebusiness;

import android.util.SparseArray;
import android.view.View;
import com.tencent.mobileqq.activity.home.IFrameBusinessInterface;
import com.tencent.mobileqq.activity.home.ITabFrameController;
import com.tencent.mobileqq.activity.home.impl.FrameControllerUtil;
import com.tencent.mobileqq.activity.home.impl.FrameInfoBean;
import com.tencent.mobileqq.activity.home.impl.TabFrameControllerImpl;
import com.tencent.mobileqq.activity.leba.QzoneFrame;
import com.tencent.mobileqq.app.Frame;
import com.tencent.mobileqq.app.FrameFragment;
import com.tencent.mobileqq.app.FrameFragment.DragViewTouchListener;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.redtouch.RedTouchManager;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.widget.TabDragAnimationView;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.app.AppRuntime;

public class QzoneFrameInjectImpl
  implements IFrameBusinessInterface
{
  public static final String a = FrameControllerUtil.c;
  public static final String b = QzoneFrame.class.getName();
  
  public void a()
  {
    TabFrameControllerImpl.registerFrameInfo(new FrameInfoBean(QzoneFrame.class, FrameControllerUtil.i, FrameControllerUtil.c, 2130850818, 2130850819, 2131693920, 14, 4));
  }
  
  public void a(FrameFragment paramFrameFragment)
  {
    paramFrameFragment = paramFrameFragment.a(QzoneFrame.class);
    if (paramFrameFragment != null) {
      ((QzoneFrame)paramFrameFragment).g();
    }
  }
  
  public void a(FrameFragment paramFrameFragment, int paramInt1, Frame paramFrame, int paramInt2)
  {
    if ((paramFrame instanceof QzoneFrame)) {
      ((QzoneFrame)paramFrame).c();
    }
  }
  
  public void a(FrameFragment paramFrameFragment, FrameFragment.DragViewTouchListener paramDragViewTouchListener) {}
  
  public void a(FrameFragment paramFrameFragment, String paramString) {}
  
  public void a(RedTouch paramRedTouch, FrameFragment paramFrameFragment, int paramInt, BusinessInfoCheckUpdate.RedTypeInfo paramRedTypeInfo, RedTouchManager paramRedTouchManager) {}
  
  public void a(HashMap<String, View> paramHashMap, boolean paramBoolean)
  {
    ((ITabFrameController)QRoute.api(ITabFrameController.class)).setSoundEffectsEnableForTab(paramHashMap, paramBoolean, a);
  }
  
  public void a(AppRuntime paramAppRuntime, SparseArray<TabDragAnimationView> paramSparseArray, int paramInt) {}
  
  public boolean a(FrameFragment paramFrameFragment)
  {
    return false;
  }
  
  public void b()
  {
    FrameInfoBean localFrameInfoBean = ((ITabFrameController)QRoute.api(ITabFrameController.class)).getFrameInfoByClazz(QzoneFrame.class);
    localFrameInfoBean.a(FrameControllerUtil.i);
    QLog.d("TabFrameControllerImplBusiness", 1, "doOnUpdateFrameInfo className: " + localFrameInfoBean.a().getName() + " tabIndex: " + localFrameInfoBean.a());
  }
  
  public void b(FrameFragment paramFrameFragment) {}
  
  public void b(FrameFragment paramFrameFragment, String paramString)
  {
    if (b.equals(paramString))
    {
      paramString = paramFrameFragment.a();
      if ((paramString instanceof QzoneFrame))
      {
        boolean bool = ((ITabFrameController)QRoute.api(ITabFrameController.class)).isLebaHasRedPoint(paramFrameFragment.a);
        ((QzoneFrame)paramString).a(bool);
      }
    }
  }
  
  public void c(FrameFragment paramFrameFragment) {}
  
  public void d(FrameFragment paramFrameFragment) {}
  
  public void e(FrameFragment paramFrameFragment) {}
  
  public void f(FrameFragment paramFrameFragment) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.framebusiness.QzoneFrameInjectImpl
 * JD-Core Version:    0.7.0.1
 */