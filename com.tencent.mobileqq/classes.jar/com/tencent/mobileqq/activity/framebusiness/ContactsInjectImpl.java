package com.tencent.mobileqq.activity.framebusiness;

import android.util.SparseArray;
import android.view.View;
import android.widget.TabWidget;
import android.widget.TextView;
import com.tencent.mobileqq.activity.contacts.base.Contacts;
import com.tencent.mobileqq.activity.home.ITabFrameController;
import com.tencent.mobileqq.activity.home.impl.FrameControllerUtil;
import com.tencent.mobileqq.activity.home.impl.FrameInfoBean;
import com.tencent.mobileqq.activity.home.impl.TabFrameControllerImpl;
import com.tencent.mobileqq.app.Frame;
import com.tencent.mobileqq.app.FrameFragment;
import com.tencent.mobileqq.app.FrameFragment.DragViewTouchListener;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qcall.QCallFacade;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.QQTabHost;
import com.tencent.mobileqq.widget.TabDragAnimationView;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

public class ContactsInjectImpl
  extends BaseFrameBusiness
{
  public static final String a = FrameControllerUtil.m;
  public static final String b = Contacts.class.getName();
  
  public void a()
  {
    TabFrameControllerImpl.registerFrameInfo(new FrameInfoBean(Contacts.class, FrameControllerUtil.c, FrameControllerUtil.m, 2130852554, 2130852556, 2131891479, 12, 3));
  }
  
  public void a(FrameFragment paramFrameFragment)
  {
    Frame localFrame = paramFrameFragment.a(Contacts.class);
    if (localFrame != null)
    {
      int j = -1;
      int i = j;
      if (paramFrameFragment.s != null)
      {
        i = j;
        if (paramFrameFragment.s.getTabWidget() != null) {
          i = paramFrameFragment.s.getTabWidget().getHeight();
        }
      }
      ((Contacts)localFrame).b(i);
    }
  }
  
  public void a(FrameFragment paramFrameFragment, int paramInt1, Frame paramFrame, int paramInt2)
  {
    if ((paramInt1 == FrameControllerUtil.b) && (paramInt2 != FrameControllerUtil.b) && (paramFrameFragment.A != null))
    {
      paramFrameFragment = (QCallFacade)paramFrameFragment.A.getManager(QQManagerFactory.RECENT_CALL_FACADE);
      if (paramFrameFragment != null) {
        paramFrameFragment.a(MessageCache.c());
      }
    }
  }
  
  public void a(FrameFragment paramFrameFragment, FrameFragment.DragViewTouchListener paramDragViewTouchListener)
  {
    TabDragAnimationView localTabDragAnimationView = (TabDragAnimationView)paramFrameFragment.z[2].findViewById(2131446751);
    localTabDragAnimationView.setOnTouchListener(paramDragViewTouchListener);
    localTabDragAnimationView.setExpectedLogoMoveDistance(ViewUtils.dpToPx(2.0F));
    localTabDragAnimationView.a("联系人");
    paramFrameFragment.B.put(FrameControllerUtil.c, localTabDragAnimationView);
    paramFrameFragment.C.put(FrameControllerUtil.c, (TextView)paramFrameFragment.z[2].findViewById(2131448791));
  }
  
  public void a(FrameFragment paramFrameFragment, String paramString)
  {
    ((ITabFrameController)QRoute.api(ITabFrameController.class)).updateTabContentDescription(paramFrameFragment, FrameControllerUtil.m, ((ITabFrameController)QRoute.api(ITabFrameController.class)).getCurrentTabTag(paramFrameFragment.s));
  }
  
  public void a(RedTouch paramRedTouch, FrameFragment paramFrameFragment, int paramInt, BusinessInfoCheckUpdate.RedTypeInfo paramRedTypeInfo, IRedTouchManager paramIRedTouchManager)
  {
    if (paramInt == 33)
    {
      paramRedTouch = (RedTouch)paramFrameFragment.G.get(FrameControllerUtil.m);
      ((ITabFrameController)QRoute.api(ITabFrameController.class)).updateRedTouch(paramFrameFragment, paramInt, paramRedTouch, paramRedTypeInfo);
    }
  }
  
  public void a(HashMap<String, View> paramHashMap, boolean paramBoolean)
  {
    ((ITabFrameController)QRoute.api(ITabFrameController.class)).setSoundEffectsEnableForTab(paramHashMap, paramBoolean, a);
  }
  
  public void b()
  {
    FrameInfoBean localFrameInfoBean = ((ITabFrameController)QRoute.api(ITabFrameController.class)).getFrameInfoByClazz(Contacts.class);
    localFrameInfoBean.a(FrameControllerUtil.c);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("doOnUpdateFrameInfo className: ");
    localStringBuilder.append(localFrameInfoBean.a().getName());
    localStringBuilder.append(" tabIndex: ");
    localStringBuilder.append(localFrameInfoBean.c());
    QLog.d("TabFrameControllerImplBusiness", 1, localStringBuilder.toString());
  }
  
  public void b(FrameFragment paramFrameFragment)
  {
    paramFrameFragment.a(FrameControllerUtil.c, 2130852753, 2130852754);
  }
  
  public void b(FrameFragment paramFrameFragment, String paramString)
  {
    if (b.equals(paramString)) {
      ThreadManager.getSubThreadHandler().postDelayed(new ContactsInjectImpl.1(this, paramFrameFragment), 500L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.framebusiness.ContactsInjectImpl
 * JD-Core Version:    0.7.0.1
 */