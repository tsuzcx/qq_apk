package com.tencent.mobileqq.activity.framebusiness;

import android.view.View;
import com.tencent.mobileqq.activity.home.ITabFrameController;
import com.tencent.mobileqq.activity.home.impl.FrameControllerUtil;
import com.tencent.mobileqq.activity.home.impl.FrameInfoBean;
import com.tencent.mobileqq.activity.home.impl.TabFrameControllerImpl;
import com.tencent.mobileqq.activity.leba.QzoneFrame;
import com.tencent.mobileqq.app.Frame;
import com.tencent.mobileqq.app.FrameFragment;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class QzoneFrameInjectImpl
  extends BaseFrameBusiness
{
  public static final String a = FrameControllerUtil.n;
  public static final String b = QzoneFrame.class.getName();
  
  public void a()
  {
    TabFrameControllerImpl.registerFrameInfo(new FrameInfoBean(QzoneFrame.class, FrameControllerUtil.i, FrameControllerUtil.n, 2130852570, 2130852572, 2131891481, 14, 4));
  }
  
  public void a(FrameFragment paramFrameFragment)
  {
    paramFrameFragment = paramFrameFragment.a(QzoneFrame.class);
    if (paramFrameFragment != null) {
      ((QzoneFrame)paramFrameFragment).n();
    }
  }
  
  public void a(FrameFragment paramFrameFragment, int paramInt1, Frame paramFrame, int paramInt2)
  {
    if ((paramFrame instanceof QzoneFrame)) {
      ((QzoneFrame)paramFrame).m();
    }
  }
  
  public void a(HashMap<String, View> paramHashMap, boolean paramBoolean)
  {
    ((ITabFrameController)QRoute.api(ITabFrameController.class)).setSoundEffectsEnableForTab(paramHashMap, paramBoolean, a);
  }
  
  public boolean a(HashMap<String, View> paramHashMap)
  {
    paramHashMap = (RedTouch)paramHashMap.get(FrameControllerUtil.o);
    if (paramHashMap == null) {
      return false;
    }
    return paramHashMap.h();
  }
  
  public void b()
  {
    FrameInfoBean localFrameInfoBean = ((ITabFrameController)QRoute.api(ITabFrameController.class)).getFrameInfoByClazz(QzoneFrame.class);
    localFrameInfoBean.a(FrameControllerUtil.i);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("doOnUpdateFrameInfo className: ");
    localStringBuilder.append(localFrameInfoBean.a().getName());
    localStringBuilder.append(" tabIndex: ");
    localStringBuilder.append(localFrameInfoBean.c());
    QLog.d("TabFrameControllerImplBusiness", 1, localStringBuilder.toString());
  }
  
  public void b(FrameFragment paramFrameFragment, String paramString)
  {
    if (b.equals(paramString))
    {
      paramString = paramFrameFragment.v();
      if ((paramString instanceof QzoneFrame))
      {
        boolean bool = a(paramFrameFragment.G);
        ((QzoneFrame)paramString).c(bool);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.framebusiness.QzoneFrameInjectImpl
 * JD-Core Version:    0.7.0.1
 */