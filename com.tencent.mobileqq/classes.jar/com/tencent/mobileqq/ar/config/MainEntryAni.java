package com.tencent.mobileqq.ar.config;

import aaqa;
import aaqb;
import aaqc;
import aaqf;
import aaqg;
import aarj;
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
  aaqf jdField_a_of_type_Aaqf = null;
  boolean jdField_a_of_type_Boolean = false;
  
  static aaqg a(aaqg paramaaqg, View paramView1, View paramView2)
  {
    paramView1 = paramView1.findViewById(2131374956);
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
    paramView1 = (RelativeLayout)paramView2.findViewById(2131368810);
    paramView2 = new int[2];
    paramView1.getLocationOnScreen(paramView2);
    paramaaqg.m = paramaaqg.g;
    paramaaqg.n = paramaaqg.h;
    paramaaqg.o = paramaaqg.i;
    paramaaqg.p = ((k * 2 + m - paramaaqg.n) / 2);
    paramaaqg.q = (paramaaqg.o - paramView2[0]);
    paramaaqg.r = (paramaaqg.p - paramView2[1]);
    paramaaqg.u = paramaaqg.i;
    paramaaqg.v = paramaaqg.j;
    paramaaqg.s = paramaaqg.g;
    paramaaqg.t = (paramaaqg.p + paramaaqg.n - paramaaqg.v);
    paramaaqg.w = (paramaaqg.u - i);
    paramaaqg.x = (paramaaqg.v - j);
    QLog.w("WorldCupMgr", 1, "calcIconInMenu, icon[" + paramaaqg.o + ", " + paramaaqg.p + "], local[" + paramaaqg.q + ", " + paramaaqg.r + "], size[" + paramaaqg.m + ", " + paramaaqg.n + "], canvas[" + paramaaqg.u + ", " + paramaaqg.v + "], local[" + paramaaqg.w + ", " + paramaaqg.x + "], size[" + paramaaqg.s + ", " + paramaaqg.t + "], rightLayoutLT[" + paramView2[0] + ", " + paramView2[1] + "], menuItem_Height[" + m + "]");
    return paramaaqg;
  }
  
  public static aaqg a(aaqg paramaaqg, DragFrameLayout paramDragFrameLayout)
  {
    int[] arrayOfInt = new int[2];
    paramDragFrameLayout.getLocationOnScreen(arrayOfInt);
    paramaaqg.a = (paramaaqg.i + paramaaqg.g);
    paramaaqg.b = AIOUtils.a(60.0F, paramDragFrameLayout.getResources());
    paramaaqg.c = 0;
    paramaaqg.d = paramaaqg.j;
    paramaaqg.e = (paramaaqg.c - arrayOfInt[0]);
    paramaaqg.f = (paramaaqg.d - arrayOfInt[1]);
    QLog.w("WorldCupMgr", 1, "calcFootballMoving, moving[" + paramaaqg.c + ", " + paramaaqg.d + "], local[" + paramaaqg.e + ", " + paramaaqg.f + "], size[" + paramaaqg.a + ", " + paramaaqg.b + "], contentFrameLT[" + arrayOfInt[0] + ", " + arrayOfInt[1] + "], size[" + paramDragFrameLayout.getWidth() + ", " + paramDragFrameLayout.getHeight() + "]");
    return paramaaqg;
  }
  
  public static aaqg a(View paramView)
  {
    Object localObject1 = a(paramView);
    if (localObject1 == null)
    {
      QLog.w("WorldCupMgr", 1, "calcFootballInAddBtn, 找不到titleBar");
      return null;
    }
    Object localObject2 = (RelativeLayout)((RelativeLayout)localObject1).findViewById(2131363995);
    localObject1 = new aaqg();
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
    ((aaqg)localObject1).g = AIOUtils.a(60.0F, localResources);
    ((aaqg)localObject1).h = AIOUtils.a(60.0F, localResources);
    ((aaqg)localObject1).i = ((i2 * 2 + i3 - ((aaqg)localObject1).g) / 2);
    ((aaqg)localObject1).j = ((j * 2 + m - ((aaqg)localObject1).h) / 2);
    ((aaqg)localObject1).k = (((aaqg)localObject1).i - arrayOfInt[0]);
    ((aaqg)localObject1).l = (((aaqg)localObject1).j - arrayOfInt[1]);
    QLog.w("WorldCupMgr", 1, "calcFootballInAddBtn, addBtn[" + i + ", " + j + "], size[" + k + ", " + m + "], addBtn_paddingLeft[" + n + "], addBtn_paddingRight[" + i1 + "], realIcon[" + i2 + ", " + j + "], size[" + i3 + ", " + m + "], football[" + ((aaqg)localObject1).i + ", " + ((aaqg)localObject1).j + "], local_football[" + ((aaqg)localObject1).k + ", " + ((aaqg)localObject1).l + "], size[" + ((aaqg)localObject1).g + ", " + ((aaqg)localObject1).h + "]");
    return localObject1;
  }
  
  static RelativeLayout a(View paramView)
  {
    paramView = paramView.getParent();
    ViewParent localViewParent;
    do
    {
      if (((paramView instanceof RelativeLayout)) && (((RelativeLayout)paramView).getId() == 2131363990)) {
        return (RelativeLayout)paramView;
      }
      localViewParent = paramView.getParent();
      paramView = localViewParent;
    } while (localViewParent != null);
    QLog.w("WorldCupMgr", 1, "没有找到conversation_activity_title");
    return null;
  }
  
  private void a(aaqf paramaaqf)
  {
    QLog.w("WorldCupMgr", 1, "MainEntryAni.clean");
    if (paramaaqf != null)
    {
      ImageView localImageView = (ImageView)paramaaqf.d.get();
      if (localImageView != null)
      {
        localImageView.setVisibility(4);
        localImageView.setImageDrawable(null);
      }
      paramaaqf.jdField_a_of_type_ComTencentMobileqqArConfigWorldCupMgr.jdField_a_of_type_Aarj.c();
    }
    WorldCupStaticInstance.a().b = false;
    this.jdField_a_of_type_Boolean = false;
  }
  
  private boolean a(aaqf paramaaqf, aaqg paramaaqg)
  {
    DragFrameLayout localDragFrameLayout = (DragFrameLayout)paramaaqf.c.get();
    if (localDragFrameLayout == null)
    {
      QLog.i("WorldCupMgr", 1, "loadRollAnimation, dragFrameLayout为空");
      a(paramaaqf);
      return false;
    }
    if (!paramaaqf.jdField_a_of_type_ComTencentMobileqqArConfigWorldCupMgr.jdField_a_of_type_Aarj.c())
    {
      QLog.i("WorldCupMgr", 1, "loadRollAnimation, 资源未准备好");
      a(paramaaqf);
      return false;
    }
    paramaaqg = new aaqc(this, paramaaqf, paramaaqg, paramaaqf.jdField_a_of_type_JavaLangString + "addbtn_moving/images/");
    LottieComposition.Factory.fromJson(localDragFrameLayout.getResources(), paramaaqf.jdField_a_of_type_ComTencentMobileqqArConfigWorldCupMgr.jdField_a_of_type_Aarj.jdField_a_of_type_OrgJsonJSONObject, paramaaqg);
    return true;
  }
  
  private void b(aaqf paramaaqf)
  {
    boolean bool2 = false;
    if (!this.jdField_a_of_type_Boolean) {
      QLog.w("WorldCupMgr", 1, "MainEntryAni.innerPlay, 已经取消动画");
    }
    do
    {
      return;
      Object localObject1 = (DragFrameLayout)paramaaqf.c.get();
      Object localObject2 = (RelativeLayout)paramaaqf.b.get();
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
          a(paramaaqf);
          return;
        }
      }
      Object localObject3 = (ImageView)((RelativeLayout)localObject2).findViewById(2131363993);
      if (localObject3 == null)
      {
        QLog.w("WorldCupMgr", 1, "MainEntryAni, 没找到conversation_title_right_btn");
        a(paramaaqf);
        return;
      }
      localObject3 = a((View)localObject3);
      if (localObject3 == null)
      {
        QLog.w("WorldCupMgr", 1, "MainDownAni.innerPlay, positionInfo为空");
        a(paramaaqf);
        return;
      }
      QLog.w("WorldCupMgr", 1, "MainEntryAni.innerPlay, AddBtnMenuShow[" + WorldCupStaticInstance.a().jdField_a_of_type_Boolean + "]");
      a((aaqg)localObject3, (DragFrameLayout)localObject1);
      if (WorldCupConfigInfo.e(paramaaqf.jdField_a_of_type_ComTencentMobileqqArConfigWorldCupConfigInfo))
      {
        QLog.w("WorldCupMgr", 1, "MainEntryAni.innerPlay, 播放从左到右动画");
        localObject1 = a((DragFrameLayout)localObject1, (aaqg)localObject3);
        paramaaqf.d = new WeakReference(localObject1);
        localObject2 = a((RelativeLayout)localObject2, (aaqg)localObject3);
        ((ImageView)localObject2).setVisibility(4);
        paramaaqf.e = new WeakReference(localObject2);
        ((ImageView)localObject1).setVisibility(0);
        WorldCupConfigInfo.c(paramaaqf.jdField_a_of_type_ComTencentMobileqqArConfigWorldCupConfigInfo.l, 0L);
        a(paramaaqf, (aaqg)localObject3);
        return;
      }
      if (WorldCupConfigInfo.d(paramaaqf.jdField_a_of_type_ComTencentMobileqqArConfigWorldCupConfigInfo))
      {
        QLog.w("WorldCupMgr", 1, "MainEntryAni.innerPlay, 直接显示加号上的足球");
        a(paramaaqf, (aaqg)localObject3);
        a(paramaaqf);
        return;
      }
    } while (!WorldCupConfigInfo.c(paramaaqf.jdField_a_of_type_ComTencentMobileqqArConfigWorldCupConfigInfo));
    QLog.w("WorldCupMgr", 1, "MainEntryAni.innerPlay, 外面不需要显示");
    a(paramaaqf);
  }
  
  ImageView a(RelativeLayout paramRelativeLayout, aaqg paramaaqg)
  {
    RelativeLayout localRelativeLayout = (RelativeLayout)paramRelativeLayout.findViewById(2131363995);
    ImageView localImageView2 = (ImageView)localRelativeLayout.findViewById(2131362519);
    ImageView localImageView1 = localImageView2;
    if (localImageView2 == null)
    {
      localImageView1 = new ImageView(paramRelativeLayout.getContext());
      localImageView1.setId(2131362519);
      paramRelativeLayout = new RelativeLayout.LayoutParams(paramaaqg.g, paramaaqg.h);
      paramRelativeLayout.addRule(10, -1);
      paramRelativeLayout.addRule(9, -1);
      paramRelativeLayout.setMargins(paramaaqg.k, paramaaqg.l, 0, 0);
      localRelativeLayout.addView(localImageView1, paramRelativeLayout);
    }
    paramRelativeLayout = new RelativeLayout.LayoutParams(paramaaqg.g, paramaaqg.h);
    paramRelativeLayout.addRule(10, -1);
    paramRelativeLayout.addRule(9, -1);
    paramRelativeLayout.setMargins(paramaaqg.k, paramaaqg.l, 0, 0);
    localImageView1.setLayoutParams(paramRelativeLayout);
    return localImageView1;
  }
  
  ImageView a(DragFrameLayout paramDragFrameLayout, aaqg paramaaqg)
  {
    Object localObject2 = (ImageView)paramDragFrameLayout.findViewById(2131362520);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new ImageView(paramDragFrameLayout.getContext());
      ((ImageView)localObject1).setId(2131362520);
      paramDragFrameLayout.addView((View)localObject1);
    }
    localObject2 = new FrameLayout.LayoutParams(paramaaqg.a, paramaaqg.b);
    ((FrameLayout.LayoutParams)localObject2).setMargins(paramaaqg.e, paramaaqg.f, 0, 0);
    ((ImageView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
    paramDragFrameLayout.bringChildToFront((View)localObject1);
    return localObject1;
  }
  
  void a()
  {
    this.jdField_a_of_type_Boolean = false;
    WorldCupStaticInstance.a().b = false;
    if (this.jdField_a_of_type_Aaqf != null)
    {
      Object localObject = (ImageView)this.jdField_a_of_type_Aaqf.e.get();
      if (localObject != null)
      {
        localObject = new WeakReference(localObject);
        ThreadManager.getUIHandler().post(new aaqa(this, (WeakReference)localObject));
        this.jdField_a_of_type_Aaqf.e.clear();
      }
      this.jdField_a_of_type_Aaqf = null;
    }
  }
  
  public void a(aaqf paramaaqf, aaqg paramaaqg)
  {
    if (paramaaqf.b.get() == null)
    {
      QLog.w("WorldCupMgr", 1, "showFootballInAddBtn, mTitleBar已经被释放");
      return;
    }
    paramaaqg = a((RelativeLayout)paramaaqf.b.get(), paramaaqg);
    paramaaqf.e = new WeakReference(paramaaqg);
    paramaaqg.setImageBitmap(paramaaqf.jdField_a_of_type_ComTencentMobileqqArConfigWorldCupMgr.jdField_a_of_type_Aarj.jdField_a_of_type_AndroidGraphicsBitmap);
    paramaaqg.setClickable(false);
    paramaaqg.setVisibility(0);
  }
  
  void a(QQAppInterface paramQQAppInterface, Activity paramActivity, View paramView)
  {
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    paramQQAppInterface = (DragFrameLayout)paramActivity.findViewById(2131364961);
    if (paramQQAppInterface == null)
    {
      QLog.w("WorldCupMgr", 1, "MainEntryAni.hide, 没找到contentFrame");
      return;
    }
    paramQQAppInterface = (ImageView)paramQQAppInterface.findViewById(2131362520);
    if (paramQQAppInterface == null)
    {
      QLog.w("WorldCupMgr", 1, "MainEntryAni.hide, 没找到ar_football_Ani");
      return;
    }
    paramQQAppInterface.setVisibility(4);
  }
  
  boolean a(aaqf paramaaqf, View paramView)
  {
    ArrayList localArrayList = new ArrayList();
    paramaaqf.jdField_a_of_type_ComTencentMobileqqArConfigWorldCupMgr.jdField_a_of_type_Aarj.a(paramaaqf.jdField_a_of_type_JavaLangString, (DragFrameLayout)paramaaqf.c.get(), paramView);
    paramaaqf.jdField_a_of_type_ComTencentMobileqqArConfigWorldCupMgr.jdField_a_of_type_Aarf.b = paramaaqf.jdField_a_of_type_JavaLangString;
    paramaaqf.jdField_a_of_type_ComTencentMobileqqArConfigWorldCupMgr.b.b = paramaaqf.jdField_a_of_type_JavaLangString;
    paramaaqf.jdField_a_of_type_ComTencentMobileqqArConfigWorldCupMgr.jdField_a_of_type_Aari.jdField_a_of_type_JavaLangString = paramaaqf.jdField_a_of_type_JavaLangString;
    if (WorldCupConfigInfo.e(paramaaqf.jdField_a_of_type_ComTencentMobileqqArConfigWorldCupConfigInfo))
    {
      localArrayList.add(paramaaqf.jdField_a_of_type_ComTencentMobileqqArConfigWorldCupMgr.jdField_a_of_type_Aarj);
      localArrayList.add(paramaaqf.jdField_a_of_type_ComTencentMobileqqArConfigWorldCupMgr.jdField_a_of_type_Aarf);
      localArrayList.add(paramaaqf.jdField_a_of_type_ComTencentMobileqqArConfigWorldCupMgr.b);
      localArrayList.add(paramaaqf.jdField_a_of_type_ComTencentMobileqqArConfigWorldCupMgr.jdField_a_of_type_Aari);
      QLog.w("WorldCupMgr", 1, "checkBitmap, 显示从左到右的动画");
    }
    for (;;)
    {
      WorldCup.a(paramaaqf.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      WorldCupMgr.a(((View)paramaaqf.jdField_a_of_type_JavaLangRefWeakReference.get()).getResources(), localArrayList, new aaqb(this, localArrayList, localArrayList, paramaaqf));
      return true;
      if (WorldCupConfigInfo.d(paramaaqf.jdField_a_of_type_ComTencentMobileqqArConfigWorldCupConfigInfo))
      {
        localArrayList.add(paramaaqf.jdField_a_of_type_ComTencentMobileqqArConfigWorldCupMgr.jdField_a_of_type_Aarj);
        localArrayList.add(paramaaqf.jdField_a_of_type_ComTencentMobileqqArConfigWorldCupMgr.jdField_a_of_type_Aarf);
        localArrayList.add(paramaaqf.jdField_a_of_type_ComTencentMobileqqArConfigWorldCupMgr.b);
        localArrayList.add(paramaaqf.jdField_a_of_type_ComTencentMobileqqArConfigWorldCupMgr.jdField_a_of_type_Aari);
        QLog.w("WorldCupMgr", 1, "checkBitmap, 显示加号上的动画");
      }
      else
      {
        if (!WorldCupConfigInfo.c(paramaaqf.jdField_a_of_type_ComTencentMobileqqArConfigWorldCupConfigInfo)) {
          break;
        }
        localArrayList.add(paramaaqf.jdField_a_of_type_ComTencentMobileqqArConfigWorldCupMgr.jdField_a_of_type_Aarf);
        QLog.w("WorldCupMgr", 1, "checkBitmap, 扫一扫菜单旁边显示icon");
      }
    }
    return false;
  }
  
  public boolean a(QQAppInterface paramQQAppInterface, WorldCupMgr paramWorldCupMgr, FragmentActivity paramFragmentActivity, View paramView)
  {
    WorldCupConfigInfo localWorldCupConfigInfo = WorldCup.a(paramQQAppInterface);
    String str = localWorldCupConfigInfo.a(0);
    DragFrameLayout localDragFrameLayout = (DragFrameLayout)paramFragmentActivity.findViewById(2131364961);
    if (localDragFrameLayout == null)
    {
      QLog.w("WorldCupMgr", 1, "MainEntryAni.play, 没找到contentFrame");
      a(null);
      return false;
    }
    if (this.jdField_a_of_type_Boolean)
    {
      paramQQAppInterface = (ImageView)localDragFrameLayout.findViewById(2131362520);
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
    Object localObject = (RelativeLayout)paramFragmentActivity.findViewById(2131364962);
    if (localObject == null)
    {
      QLog.w("WorldCupMgr", 1, "MainEntryAni.play, 没找到layout_head");
      a(null);
      return false;
    }
    if ((ImageView)((RelativeLayout)localObject).findViewById(2131370005) == null)
    {
      QLog.w("WorldCupMgr", 1, "MainEntryAni.play, 没找到conversation_head");
      a(null);
      return false;
    }
    paramFragmentActivity = (RelativeLayout)paramFragmentActivity.findViewById(2131363990);
    if (paramFragmentActivity == null)
    {
      QLog.w("WorldCupMgr", 1, "MainEntryAni.play, 没找到conversation_activity_title");
      a(null);
      return false;
    }
    localObject = (ImageView)paramFragmentActivity.findViewById(2131363993);
    if (localObject == null)
    {
      QLog.w("WorldCupMgr", 1, "MainEntryAni.play, 没找到conversation_title_right_btn");
      a(null);
      return false;
    }
    aaqf localaaqf = new aaqf();
    this.jdField_a_of_type_Aaqf = localaaqf;
    localaaqf.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    localaaqf.jdField_a_of_type_ComTencentMobileqqArConfigWorldCupMgr = paramWorldCupMgr;
    localaaqf.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramView);
    localaaqf.jdField_a_of_type_JavaLangString = str;
    localaaqf.jdField_a_of_type_ComTencentMobileqqArConfigWorldCupConfigInfo = localWorldCupConfigInfo;
    localaaqf.c = new WeakReference(localDragFrameLayout);
    localaaqf.b = new WeakReference(paramFragmentActivity);
    if (!a(localaaqf, (View)localObject))
    {
      QLog.w("WorldCupMgr", 1, "MainEntryAni.play, 检查图片失败");
      a(localaaqf);
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ar.config.MainEntryAni
 * JD-Core Version:    0.7.0.1
 */