package com.tencent.mobileqq.ar.config;

import aajj;
import aajk;
import aajl;
import aajo;
import aajp;
import aakp;
import android.app.Activity;
import android.content.res.Resources;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.dinifly.LottieComposition.Factory;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import mqq.os.MqqHandler;

public class MainEntryAni
{
  aajo jdField_a_of_type_Aajo = null;
  boolean jdField_a_of_type_Boolean = false;
  
  static aajp a(aajp paramaajp, View paramView1, View paramView2)
  {
    paramView1 = paramView1.findViewById(2131374912);
    int[] arrayOfInt = new int[2];
    paramView1.getLocationOnScreen(arrayOfInt);
    int i = arrayOfInt[0];
    int j = arrayOfInt[1];
    paramView1 = new int[2];
    paramView2.getLocationOnScreen(paramView1);
    int k = paramView1[0];
    k = paramView1[1];
    paramView2.getWidth();
    int m = paramView2.getHeight();
    paramView1 = (RelativeLayout)paramView2.findViewById(2131368807);
    paramView2 = new int[2];
    paramView1.getLocationOnScreen(paramView2);
    paramaajp.m = paramaajp.g;
    paramaajp.n = paramaajp.h;
    paramaajp.o = paramaajp.i;
    paramaajp.p = ((k * 2 + m - paramaajp.n) / 2);
    paramaajp.q = (paramaajp.o - paramView2[0]);
    paramaajp.r = (paramaajp.p - paramView2[1]);
    paramaajp.u = paramaajp.i;
    paramaajp.v = paramaajp.j;
    paramaajp.s = paramaajp.g;
    paramaajp.t = (paramaajp.p + paramaajp.n - paramaajp.v);
    paramaajp.w = (paramaajp.u - i);
    paramaajp.x = (paramaajp.v - j);
    QLog.w("WorldCupMgr", 1, "calcIconInMenu, icon[" + paramaajp.o + ", " + paramaajp.p + "], local[" + paramaajp.q + ", " + paramaajp.r + "], size[" + paramaajp.m + ", " + paramaajp.n + "], canvas[" + paramaajp.u + ", " + paramaajp.v + "], local[" + paramaajp.w + ", " + paramaajp.x + "], size[" + paramaajp.s + ", " + paramaajp.t + "], rightLayoutLT[" + paramView2[0] + ", " + paramView2[1] + "], menuItem_Height[" + m + "]");
    return paramaajp;
  }
  
  public static aajp a(aajp paramaajp, DragFrameLayout paramDragFrameLayout)
  {
    int[] arrayOfInt = new int[2];
    paramDragFrameLayout.getLocationOnScreen(arrayOfInt);
    paramaajp.a = (paramaajp.i + paramaajp.g);
    paramaajp.b = AIOUtils.a(60.0F, paramDragFrameLayout.getResources());
    paramaajp.c = 0;
    paramaajp.d = paramaajp.j;
    paramaajp.e = (paramaajp.c - arrayOfInt[0]);
    paramaajp.f = (paramaajp.d - arrayOfInt[1]);
    QLog.w("WorldCupMgr", 1, "calcFootballMoving, moving[" + paramaajp.c + ", " + paramaajp.d + "], local[" + paramaajp.e + ", " + paramaajp.f + "], size[" + paramaajp.a + ", " + paramaajp.b + "], contentFrameLT[" + arrayOfInt[0] + ", " + arrayOfInt[1] + "], size[" + paramDragFrameLayout.getWidth() + ", " + paramDragFrameLayout.getHeight() + "]");
    return paramaajp;
  }
  
  public static aajp a(View paramView)
  {
    Object localObject1 = a(paramView);
    if (localObject1 == null)
    {
      QLog.w("WorldCupMgr", 1, "calcFootballInAddBtn, 找不到titleBar");
      return null;
    }
    Object localObject2 = (RelativeLayout)((RelativeLayout)localObject1).findViewById(2131363970);
    localObject1 = new aajp();
    Resources localResources = paramView.getResources();
    int[] arrayOfInt = new int[2];
    ((RelativeLayout)localObject2).getLocationOnScreen(arrayOfInt);
    localObject2 = new int[2];
    paramView.getLocationOnScreen((int[])localObject2);
    int i = localObject2[0];
    int j = localObject2[1];
    int k = paramView.getWidth();
    int m = paramView.getHeight();
    int n = AIOUtils.a(6.0F, localResources);
    int i1 = AIOUtils.a(3.0F, localResources);
    int i2 = i + n;
    int i3 = k - n - i1;
    ((aajp)localObject1).g = AIOUtils.a(60.0F, localResources);
    ((aajp)localObject1).h = AIOUtils.a(60.0F, localResources);
    ((aajp)localObject1).i = ((i2 * 2 + i3 - ((aajp)localObject1).g) / 2);
    ((aajp)localObject1).j = ((j * 2 + m - ((aajp)localObject1).h) / 2);
    ((aajp)localObject1).k = (((aajp)localObject1).i - arrayOfInt[0]);
    ((aajp)localObject1).l = (((aajp)localObject1).j - arrayOfInt[1]);
    QLog.w("WorldCupMgr", 1, "calcFootballInAddBtn, addBtn[" + i + ", " + j + "], size[" + k + ", " + m + "], addBtn_paddingLeft[" + n + "], addBtn_paddingRight[" + i1 + "], realIcon[" + i2 + ", " + j + "], size[" + i3 + ", " + m + "], football[" + ((aajp)localObject1).i + ", " + ((aajp)localObject1).j + "], local_football[" + ((aajp)localObject1).k + ", " + ((aajp)localObject1).l + "], size[" + ((aajp)localObject1).g + ", " + ((aajp)localObject1).h + "]");
    return localObject1;
  }
  
  static RelativeLayout a(View paramView)
  {
    paramView = paramView.getParent();
    ViewParent localViewParent;
    do
    {
      if (((paramView instanceof RelativeLayout)) && (((RelativeLayout)paramView).getId() == 2131363965)) {
        return (RelativeLayout)paramView;
      }
      localViewParent = paramView.getParent();
      paramView = localViewParent;
    } while (localViewParent != null);
    QLog.w("WorldCupMgr", 1, "没有找到conversation_activity_title");
    return null;
  }
  
  private void a(aajo paramaajo)
  {
    QLog.w("WorldCupMgr", 1, "MainEntryAni.clean");
    if (paramaajo != null)
    {
      ImageView localImageView = (ImageView)paramaajo.d.get();
      if (localImageView != null)
      {
        localImageView.setVisibility(4);
        localImageView.setImageDrawable(null);
      }
      paramaajo.jdField_a_of_type_ComTencentMobileqqArConfigWorldCupMgr.jdField_a_of_type_Aakp.c();
    }
    WorldCupStaticInstance.a().b = false;
    this.jdField_a_of_type_Boolean = false;
  }
  
  private boolean a(aajo paramaajo, aajp paramaajp)
  {
    DragFrameLayout localDragFrameLayout = (DragFrameLayout)paramaajo.c.get();
    if (localDragFrameLayout == null)
    {
      QLog.i("WorldCupMgr", 1, "loadRollAnimation, dragFrameLayout为空");
      a(paramaajo);
      return false;
    }
    if (!paramaajo.jdField_a_of_type_ComTencentMobileqqArConfigWorldCupMgr.jdField_a_of_type_Aakp.c())
    {
      QLog.i("WorldCupMgr", 1, "loadRollAnimation, 资源未准备好");
      a(paramaajo);
      return false;
    }
    paramaajp = new aajl(this, paramaajo, paramaajp, paramaajo.jdField_a_of_type_JavaLangString + "addbtn_moving/images/");
    LottieComposition.Factory.fromJson(localDragFrameLayout.getResources(), paramaajo.jdField_a_of_type_ComTencentMobileqqArConfigWorldCupMgr.jdField_a_of_type_Aakp.jdField_a_of_type_OrgJsonJSONObject, paramaajp);
    return true;
  }
  
  private void b(aajo paramaajo)
  {
    boolean bool2 = false;
    if (!this.jdField_a_of_type_Boolean) {
      QLog.w("WorldCupMgr", 1, "MainEntryAni.innerPlay, 已经取消动画");
    }
    do
    {
      return;
      Object localObject1 = (DragFrameLayout)paramaajo.c.get();
      Object localObject2 = (RelativeLayout)paramaajo.b.get();
      if ((localObject2 == null) || (localObject1 == null))
      {
        localObject3 = new StringBuilder().append("MainDownAni.innerPlay, 控件为空, titleBar[");
        if (localObject2 != null) {}
        for (boolean bool1 = true;; bool1 = false)
        {
          localObject2 = ((StringBuilder)localObject3).append(bool1).append("], contentFrame[");
          bool1 = bool2;
          if (localObject1 != null) {
            bool1 = true;
          }
          QLog.w("WorldCupMgr", 1, bool1 + "]");
          a(paramaajo);
          return;
        }
      }
      Object localObject3 = (ImageView)((RelativeLayout)localObject2).findViewById(2131363968);
      if (localObject3 == null)
      {
        QLog.w("WorldCupMgr", 1, "MainEntryAni, 没找到conversation_title_right_btn");
        a(paramaajo);
        return;
      }
      localObject3 = a((View)localObject3);
      if (localObject3 == null)
      {
        QLog.w("WorldCupMgr", 1, "MainDownAni.innerPlay, positionInfo为空");
        a(paramaajo);
        return;
      }
      QLog.w("WorldCupMgr", 1, "MainEntryAni.innerPlay, AddBtnMenuShow[" + WorldCupStaticInstance.a().jdField_a_of_type_Boolean + "]");
      a((aajp)localObject3, (DragFrameLayout)localObject1);
      if (WorldCupConfigInfo.e(paramaajo.jdField_a_of_type_ComTencentMobileqqArConfigWorldCupConfigInfo))
      {
        QLog.w("WorldCupMgr", 1, "MainEntryAni.innerPlay, 播放从左到右动画");
        localObject1 = a((DragFrameLayout)localObject1, (aajp)localObject3);
        paramaajo.d = new WeakReference(localObject1);
        localObject2 = a((RelativeLayout)localObject2, (aajp)localObject3);
        ((ImageView)localObject2).setVisibility(4);
        paramaajo.e = new WeakReference(localObject2);
        ((ImageView)localObject1).setVisibility(0);
        WorldCupConfigInfo.c(paramaajo.jdField_a_of_type_ComTencentMobileqqArConfigWorldCupConfigInfo.l, 0L);
        a(paramaajo, (aajp)localObject3);
        return;
      }
      if (WorldCupConfigInfo.d(paramaajo.jdField_a_of_type_ComTencentMobileqqArConfigWorldCupConfigInfo))
      {
        QLog.w("WorldCupMgr", 1, "MainEntryAni.innerPlay, 直接显示加号上的足球");
        a(paramaajo, (aajp)localObject3);
        a(paramaajo);
        return;
      }
    } while (!WorldCupConfigInfo.c(paramaajo.jdField_a_of_type_ComTencentMobileqqArConfigWorldCupConfigInfo));
    QLog.w("WorldCupMgr", 1, "MainEntryAni.innerPlay, 外面不需要显示");
    a(paramaajo);
  }
  
  ImageView a(RelativeLayout paramRelativeLayout, aajp paramaajp)
  {
    RelativeLayout localRelativeLayout = (RelativeLayout)paramRelativeLayout.findViewById(2131363970);
    ImageView localImageView2 = (ImageView)localRelativeLayout.findViewById(2131362515);
    ImageView localImageView1 = localImageView2;
    if (localImageView2 == null)
    {
      localImageView1 = new ImageView(paramRelativeLayout.getContext());
      localImageView1.setId(2131362515);
      paramRelativeLayout = new RelativeLayout.LayoutParams(paramaajp.g, paramaajp.h);
      paramRelativeLayout.addRule(10, -1);
      paramRelativeLayout.addRule(9, -1);
      paramRelativeLayout.setMargins(paramaajp.k, paramaajp.l, 0, 0);
      localRelativeLayout.addView(localImageView1, paramRelativeLayout);
    }
    paramRelativeLayout = new RelativeLayout.LayoutParams(paramaajp.g, paramaajp.h);
    paramRelativeLayout.addRule(10, -1);
    paramRelativeLayout.addRule(9, -1);
    paramRelativeLayout.setMargins(paramaajp.k, paramaajp.l, 0, 0);
    localImageView1.setLayoutParams(paramRelativeLayout);
    return localImageView1;
  }
  
  ImageView a(DragFrameLayout paramDragFrameLayout, aajp paramaajp)
  {
    Object localObject2 = (ImageView)paramDragFrameLayout.findViewById(2131362516);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new ImageView(paramDragFrameLayout.getContext());
      ((ImageView)localObject1).setId(2131362516);
      paramDragFrameLayout.addView((View)localObject1);
    }
    localObject2 = new FrameLayout.LayoutParams(paramaajp.a, paramaajp.b);
    ((FrameLayout.LayoutParams)localObject2).setMargins(paramaajp.e, paramaajp.f, 0, 0);
    ((ImageView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
    paramDragFrameLayout.bringChildToFront((View)localObject1);
    return localObject1;
  }
  
  void a()
  {
    this.jdField_a_of_type_Boolean = false;
    WorldCupStaticInstance.a().b = false;
    if (this.jdField_a_of_type_Aajo != null)
    {
      Object localObject = (ImageView)this.jdField_a_of_type_Aajo.e.get();
      if (localObject != null)
      {
        localObject = new WeakReference(localObject);
        ThreadManager.getUIHandler().post(new aajj(this, (WeakReference)localObject));
        this.jdField_a_of_type_Aajo.e.clear();
      }
      this.jdField_a_of_type_Aajo = null;
    }
  }
  
  public void a(aajo paramaajo, aajp paramaajp)
  {
    paramaajp = a((RelativeLayout)paramaajo.b.get(), paramaajp);
    paramaajo.e = new WeakReference(paramaajp);
    paramaajp.setImageBitmap(paramaajo.jdField_a_of_type_ComTencentMobileqqArConfigWorldCupMgr.jdField_a_of_type_Aakp.jdField_a_of_type_AndroidGraphicsBitmap);
    paramaajp.setClickable(false);
    paramaajp.setVisibility(0);
  }
  
  void a(QQAppInterface paramQQAppInterface, Activity paramActivity, View paramView)
  {
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    paramQQAppInterface = (DragFrameLayout)paramActivity.findViewById(2131364934);
    if (paramQQAppInterface == null)
    {
      QLog.w("WorldCupMgr", 1, "MainEntryAni.hide, 没找到contentFrame");
      return;
    }
    paramQQAppInterface = (ImageView)paramQQAppInterface.findViewById(2131362516);
    if (paramQQAppInterface == null)
    {
      QLog.w("WorldCupMgr", 1, "MainEntryAni.hide, 没找到ar_football_Ani");
      return;
    }
    paramQQAppInterface.setVisibility(4);
  }
  
  boolean a(aajo paramaajo, View paramView)
  {
    ArrayList localArrayList = new ArrayList();
    paramaajo.jdField_a_of_type_ComTencentMobileqqArConfigWorldCupMgr.jdField_a_of_type_Aakp.a(paramaajo.jdField_a_of_type_JavaLangString, (DragFrameLayout)paramaajo.c.get(), paramView);
    paramaajo.jdField_a_of_type_ComTencentMobileqqArConfigWorldCupMgr.jdField_a_of_type_Aakl.b = paramaajo.jdField_a_of_type_JavaLangString;
    paramaajo.jdField_a_of_type_ComTencentMobileqqArConfigWorldCupMgr.b.b = paramaajo.jdField_a_of_type_JavaLangString;
    paramaajo.jdField_a_of_type_ComTencentMobileqqArConfigWorldCupMgr.jdField_a_of_type_Aako.jdField_a_of_type_JavaLangString = paramaajo.jdField_a_of_type_JavaLangString;
    if (WorldCupConfigInfo.e(paramaajo.jdField_a_of_type_ComTencentMobileqqArConfigWorldCupConfigInfo))
    {
      localArrayList.add(paramaajo.jdField_a_of_type_ComTencentMobileqqArConfigWorldCupMgr.jdField_a_of_type_Aakp);
      localArrayList.add(paramaajo.jdField_a_of_type_ComTencentMobileqqArConfigWorldCupMgr.jdField_a_of_type_Aakl);
      localArrayList.add(paramaajo.jdField_a_of_type_ComTencentMobileqqArConfigWorldCupMgr.b);
      localArrayList.add(paramaajo.jdField_a_of_type_ComTencentMobileqqArConfigWorldCupMgr.jdField_a_of_type_Aako);
      QLog.w("WorldCupMgr", 1, "checkBitmap, 显示从左到右的动画");
    }
    for (;;)
    {
      WorldCup.a(paramaajo.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      WorldCupMgr.a(((View)paramaajo.jdField_a_of_type_JavaLangRefWeakReference.get()).getResources(), localArrayList, new aajk(this, localArrayList, localArrayList, paramaajo));
      return true;
      if (WorldCupConfigInfo.d(paramaajo.jdField_a_of_type_ComTencentMobileqqArConfigWorldCupConfigInfo))
      {
        localArrayList.add(paramaajo.jdField_a_of_type_ComTencentMobileqqArConfigWorldCupMgr.jdField_a_of_type_Aakp);
        localArrayList.add(paramaajo.jdField_a_of_type_ComTencentMobileqqArConfigWorldCupMgr.jdField_a_of_type_Aakl);
        localArrayList.add(paramaajo.jdField_a_of_type_ComTencentMobileqqArConfigWorldCupMgr.b);
        localArrayList.add(paramaajo.jdField_a_of_type_ComTencentMobileqqArConfigWorldCupMgr.jdField_a_of_type_Aako);
        QLog.w("WorldCupMgr", 1, "checkBitmap, 显示加号上的动画");
      }
      else
      {
        if (!WorldCupConfigInfo.c(paramaajo.jdField_a_of_type_ComTencentMobileqqArConfigWorldCupConfigInfo)) {
          break;
        }
        localArrayList.add(paramaajo.jdField_a_of_type_ComTencentMobileqqArConfigWorldCupMgr.jdField_a_of_type_Aakl);
        QLog.w("WorldCupMgr", 1, "checkBitmap, 扫一扫菜单旁边显示icon");
      }
    }
    return false;
  }
  
  public boolean a(QQAppInterface paramQQAppInterface, WorldCupMgr paramWorldCupMgr, FragmentActivity paramFragmentActivity, View paramView)
  {
    WorldCupConfigInfo localWorldCupConfigInfo = WorldCup.a(paramQQAppInterface);
    String str = localWorldCupConfigInfo.a(0);
    DragFrameLayout localDragFrameLayout = (DragFrameLayout)paramFragmentActivity.findViewById(2131364934);
    if (localDragFrameLayout == null)
    {
      QLog.w("WorldCupMgr", 1, "MainEntryAni.play, 没找到contentFrame");
      a(null);
      return false;
    }
    if (this.jdField_a_of_type_Boolean)
    {
      paramQQAppInterface = (ImageView)localDragFrameLayout.findViewById(2131362516);
      if (paramQQAppInterface == null)
      {
        QLog.w("WorldCupMgr", 1, "MainEntryAni.play, 没找到ar_football_Ani");
        return true;
      }
      QLog.w("WorldCupMgr", 1, "MainEntryAni.play, 已经在播放中[" + paramQQAppInterface.getVisibility() + "]");
      paramQQAppInterface.setVisibility(0);
      return true;
    }
    this.jdField_a_of_type_Boolean = true;
    WorldCupStaticInstance.a().b = true;
    Object localObject = (RelativeLayout)paramFragmentActivity.findViewById(2131364935);
    if (localObject == null)
    {
      QLog.w("WorldCupMgr", 1, "MainEntryAni.play, 没找到layout_head");
      a(null);
      return false;
    }
    if ((ImageView)((RelativeLayout)localObject).findViewById(2131369996) == null)
    {
      QLog.w("WorldCupMgr", 1, "MainEntryAni.play, 没找到conversation_head");
      a(null);
      return false;
    }
    paramFragmentActivity = (RelativeLayout)paramFragmentActivity.findViewById(2131363965);
    if (paramFragmentActivity == null)
    {
      QLog.w("WorldCupMgr", 1, "MainEntryAni.play, 没找到conversation_activity_title");
      a(null);
      return false;
    }
    localObject = (ImageView)paramFragmentActivity.findViewById(2131363968);
    if (localObject == null)
    {
      QLog.w("WorldCupMgr", 1, "MainEntryAni.play, 没找到conversation_title_right_btn");
      a(null);
      return false;
    }
    aajo localaajo = new aajo();
    this.jdField_a_of_type_Aajo = localaajo;
    localaajo.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    localaajo.jdField_a_of_type_ComTencentMobileqqArConfigWorldCupMgr = paramWorldCupMgr;
    localaajo.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramView);
    localaajo.jdField_a_of_type_JavaLangString = str;
    localaajo.jdField_a_of_type_ComTencentMobileqqArConfigWorldCupConfigInfo = localWorldCupConfigInfo;
    localaajo.c = new WeakReference(localDragFrameLayout);
    localaajo.b = new WeakReference(paramFragmentActivity);
    if (!a(localaajo, (View)localObject))
    {
      QLog.w("WorldCupMgr", 1, "MainEntryAni.play, 检查图片失败");
      a(localaajo);
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ar.config.MainEntryAni
 * JD-Core Version:    0.7.0.1
 */