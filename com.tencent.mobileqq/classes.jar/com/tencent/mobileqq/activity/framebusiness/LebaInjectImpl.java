package com.tencent.mobileqq.activity.framebusiness;

import android.util.SparseArray;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.activity.home.ITabFrameController;
import com.tencent.mobileqq.activity.home.impl.FrameControllerUtil;
import com.tencent.mobileqq.activity.home.impl.FrameInfoBean;
import com.tencent.mobileqq.activity.home.impl.TabFrameControllerImpl;
import com.tencent.mobileqq.app.Frame;
import com.tencent.mobileqq.app.FrameFragment;
import com.tencent.mobileqq.app.FrameFragment.DragViewTouchListener;
import com.tencent.mobileqq.leba.ILebaFrameApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.widget.TabDragAnimationView;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class LebaInjectImpl
  extends BaseFrameBusiness
{
  public static final String a = FrameControllerUtil.o;
  
  public void a()
  {
    TabFrameControllerImpl.registerFrameInfo(new FrameInfoBean(((ILebaFrameApi)QRoute.api(ILebaFrameApi.class)).getLebaFrameClass(), FrameControllerUtil.d, FrameControllerUtil.o, 2130852570, 2130852572, 2131891481, 14, 4));
  }
  
  public void a(FrameFragment paramFrameFragment)
  {
    paramFrameFragment = paramFrameFragment.a(((ILebaFrameApi)QRoute.api(ILebaFrameApi.class)).getLebaFrameClass());
    ((ILebaFrameApi)QRoute.api(ILebaFrameApi.class)).onPostThemeChanged(paramFrameFragment);
  }
  
  public void a(FrameFragment paramFrameFragment, int paramInt1, Frame paramFrame, int paramInt2) {}
  
  public void a(FrameFragment paramFrameFragment, FrameFragment.DragViewTouchListener paramDragViewTouchListener)
  {
    TabDragAnimationView localTabDragAnimationView = (TabDragAnimationView)paramFrameFragment.z[3].findViewById(2131446751);
    localTabDragAnimationView.setOnTouchListener(paramDragViewTouchListener);
    localTabDragAnimationView.a("动态");
    paramFrameFragment.B.put(FrameControllerUtil.d, localTabDragAnimationView);
    paramFrameFragment.C.put(FrameControllerUtil.d, (TextView)paramFrameFragment.z[3].findViewById(2131448791));
  }
  
  public void a(FrameFragment paramFrameFragment, String paramString)
  {
    ((ITabFrameController)QRoute.api(ITabFrameController.class)).updateTabContentDescription(paramFrameFragment, FrameControllerUtil.o, ((ITabFrameController)QRoute.api(ITabFrameController.class)).getCurrentTabTag(paramFrameFragment.s));
  }
  
  public void a(RedTouch paramRedTouch, FrameFragment paramFrameFragment, int paramInt, BusinessInfoCheckUpdate.RedTypeInfo paramRedTypeInfo, IRedTouchManager paramIRedTouchManager)
  {
    if (paramInt == 34)
    {
      paramRedTouch = (RedTouch)paramFrameFragment.G.get(FrameControllerUtil.o);
      ((ITabFrameController)QRoute.api(ITabFrameController.class)).updateRedTouch(paramFrameFragment, paramInt, paramRedTouch, paramRedTypeInfo);
      paramIRedTouchManager.reportLevelZeroRedInfo(0, 30);
    }
  }
  
  public void a(HashMap<String, View> paramHashMap, boolean paramBoolean)
  {
    ((ITabFrameController)QRoute.api(ITabFrameController.class)).setSoundEffectsEnableForTab(paramHashMap, paramBoolean, a);
  }
  
  public void b()
  {
    FrameInfoBean localFrameInfoBean = ((ITabFrameController)QRoute.api(ITabFrameController.class)).getFrameInfoByClazz(((ILebaFrameApi)QRoute.api(ILebaFrameApi.class)).getLebaFrameClass());
    localFrameInfoBean.a(FrameControllerUtil.d);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("doOnUpdateFrameInfo className: ");
    localStringBuilder.append(localFrameInfoBean.a().getName());
    localStringBuilder.append(" tabIndex: ");
    localStringBuilder.append(localFrameInfoBean.c());
    QLog.d("TabFrameControllerImplBusiness", 1, localStringBuilder.toString());
  }
  
  public void b(FrameFragment paramFrameFragment)
  {
    paramFrameFragment.a(FrameControllerUtil.d, -1, 2130852758);
  }
  
  public void b(FrameFragment paramFrameFragment, String paramString)
  {
    if (paramFrameFragment.A == null) {
      return;
    }
    if (((ILebaFrameApi)QRoute.api(ILebaFrameApi.class)).isLeba(paramString))
    {
      paramString = paramFrameFragment.v();
      if (((ILebaFrameApi)QRoute.api(ILebaFrameApi.class)).isLebaFrame(paramString))
      {
        paramFrameFragment = (RedTouch)paramFrameFragment.G.get(FrameControllerUtil.o);
        boolean bool;
        if ((paramFrameFragment != null) && (paramFrameFragment.h())) {
          bool = true;
        } else {
          bool = false;
        }
        if (paramFrameFragment == null) {
          paramFrameFragment = null;
        } else {
          paramFrameFragment = paramFrameFragment.getRedType();
        }
        ((ILebaFrameApi)QRoute.api(ILebaFrameApi.class)).onSwitchToLeba(paramString, bool, paramFrameFragment);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.framebusiness.LebaInjectImpl
 * JD-Core Version:    0.7.0.1
 */