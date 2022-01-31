package com.tencent.mobileqq.ar.config;

import aaiy;
import aaiz;
import aaja;
import aajb;
import aajc;
import aajd;
import aaje;
import aaji;
import aajp;
import aakl;
import aako;
import android.animation.IntEvaluator;
import android.animation.ValueAnimator;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.dinifly.LottieComposition.Factory;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.PopupMenuDialog;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import mqq.os.MqqHandler;
import org.json.JSONObject;

public class MainDownAni
{
  private static String jdField_a_of_type_JavaLangString = "WorldCupMgr";
  aaji jdField_a_of_type_Aaji = null;
  ValueAnimator jdField_a_of_type_AndroidAnimationValueAnimator = null;
  public boolean a;
  
  public MainDownAni()
  {
    this.jdField_a_of_type_Boolean = false;
  }
  
  static int a(PopupMenuDialog paramPopupMenuDialog)
  {
    View localView1 = paramPopupMenuDialog.getContentView();
    Object localObject = localView1.getResources();
    int i = ((Resources)localObject).getDimensionPixelSize(2131558949);
    int j = ((Resources)localObject).getDimensionPixelSize(2131558953);
    paramPopupMenuDialog.setWidth(i + j);
    View localView2 = localView1.findViewById(2131370705);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)localView2.getLayoutParams();
    localLayoutParams.rightMargin = j;
    localView2.setLayoutParams(localLayoutParams);
    i = ((Resources)localObject).getDimensionPixelSize(2131558952);
    localView1 = localView1.findViewById(com.tencent.mobileqq.activity.recent.RecentOptPopBar.a[0]);
    localView1.setPadding(i, 0, 0, 0);
    localView1 = localView1.findViewById(2131374908);
    localObject = (LinearLayout.LayoutParams)localView1.getLayoutParams();
    ((LinearLayout.LayoutParams)localObject).width = -2;
    localView1.setLayoutParams((ViewGroup.LayoutParams)localObject);
    paramPopupMenuDialog.jdField_a_of_type_Boolean = true;
    return 0;
  }
  
  private boolean a(aaji paramaaji, aajp paramaajp)
  {
    ImageView localImageView = (ImageView)paramaaji.e.get();
    if (localImageView == null)
    {
      QLog.i(jdField_a_of_type_JavaLangString, 1, "loadDownAnimation, downAniView为空");
      a();
      return false;
    }
    Object localObject2 = paramaaji.jdField_a_of_type_JavaLangString + "menuicon_moving/";
    Object localObject1 = new File((String)localObject2, "down.json");
    if (!((File)localObject1).exists())
    {
      QLog.i(jdField_a_of_type_JavaLangString, 1, "loadDownAnimation, json文件不存在");
      a();
      return false;
    }
    File localFile = new File((String)localObject2, "images");
    if (!localFile.exists())
    {
      QLog.i(jdField_a_of_type_JavaLangString, 1, "loadDownAnimation, image不存在");
      a();
      return false;
    }
    localObject2 = WorldCupMgr.a(WorldCupMgr.a(((File)localObject1).getAbsolutePath()), (int)(paramaajp.t * 2 / paramaaji.jdField_a_of_type_Float), 1);
    if (AudioHelper.a(0) == 1) {
      WorldCupMgr.a((JSONObject)localObject2, ((File)localObject1).getAbsolutePath() + "_.json");
    }
    paramaajp = new aaje(this, paramaaji, paramaajp, localFile.getAbsolutePath() + "/");
    if (localObject2 != null) {
      LottieComposition.Factory.fromJson(localImageView.getResources(), (JSONObject)localObject2, paramaajp);
    }
    for (;;)
    {
      return true;
      try
      {
        localObject1 = new FileInputStream((File)localObject1);
        paramaaji.jdField_a_of_type_JavaIoFileInputStream = ((FileInputStream)localObject1);
        LottieComposition.Factory.fromInputStream(localImageView.getContext(), (InputStream)localObject1, paramaajp);
      }
      catch (Exception paramaaji)
      {
        QLog.i(jdField_a_of_type_JavaLangString, 1, "loadDownAnimation, 读取json失败", paramaaji);
        a();
      }
    }
    return false;
  }
  
  static int b(PopupMenuDialog paramPopupMenuDialog)
  {
    View localView = paramPopupMenuDialog.getContentView().findViewById(2131374911);
    if (localView == null) {
      return 0;
    }
    int i = localView.getResources().getDimensionPixelSize(2131558947);
    localView.setVisibility(0);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)localView.getLayoutParams();
    localLayoutParams.height = i;
    localView.setLayoutParams(localLayoutParams);
    paramPopupMenuDialog.setHeight(paramPopupMenuDialog.getHeight() + i);
    paramPopupMenuDialog.jdField_a_of_type_Boolean = true;
    return i;
  }
  
  int a(AppInterface paramAppInterface, WorldCupMgr paramWorldCupMgr, View paramView, PopupMenuDialog paramPopupMenuDialog, int paramInt)
  {
    Object localObject = paramWorldCupMgr.a();
    if (!WorldCupConfigInfo.c((WorldCupConfigInfo)localObject)) {}
    View localView;
    do
    {
      do
      {
        return paramInt;
      } while (!WorldCup.a());
      localView = paramPopupMenuDialog.getContentView().findViewById(com.tencent.mobileqq.activity.recent.RecentOptPopBar.a[0]);
    } while (localView == null);
    if ((WorldCupConfigInfo.d((WorldCupConfigInfo)localObject)) && (!paramWorldCupMgr.jdField_a_of_type_Aako.c()))
    {
      QLog.w(jdField_a_of_type_JavaLangString, 1, "MainDownAni， 图片没有加载完成, mTaskStatus[" + paramWorldCupMgr.jdField_a_of_type_Aako.g + "]");
      return paramInt;
    }
    if (WorldCupStaticInstance.a().b)
    {
      QLog.w(jdField_a_of_type_JavaLangString, 1, "MainDownAni， 从左到右播放中");
      return paramInt;
    }
    paramAppInterface = new aaji();
    this.jdField_a_of_type_Aaji = paramAppInterface;
    paramAppInterface.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(localView);
    paramAppInterface.jdField_a_of_type_JavaLangString = ((WorldCupConfigInfo)localObject).a(0);
    paramAppInterface.jdField_a_of_type_ComTencentMobileqqArConfigWorldCupMgr = paramWorldCupMgr;
    paramAppInterface.jdField_a_of_type_Float = localView.getResources().getDisplayMetrics().density;
    paramAppInterface.jdField_a_of_type_ComTencentMobileqqArConfigWorldCupConfigInfo = ((WorldCupConfigInfo)localObject);
    WorldCupStaticInstance.a().jdField_a_of_type_Boolean = true;
    paramPopupMenuDialog.setOnDismissListener(new aaiy(this, paramAppInterface));
    localObject = (ImageView)paramView.findViewById(2131363968);
    if (localObject == null)
    {
      QLog.w(jdField_a_of_type_JavaLangString, 1, "MainDownAni, 没找到conversation_title_right_btn");
      return paramInt;
    }
    paramView = (ImageView)paramView.findViewById(2131362515);
    paramAppInterface.b = new WeakReference(localObject);
    paramAppInterface.c = new WeakReference(paramView);
    a(paramPopupMenuDialog);
    if ((paramView != null) && (paramView.getVisibility() == 0)) {
      paramInt -= b(paramPopupMenuDialog);
    }
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isDevelopLevel()) {
        QLog.w(jdField_a_of_type_JavaLangString, 1, "modifyMenu, needDownAni[" + bool + "]");
      }
      paramAppInterface.d = new WeakReference(paramPopupMenuDialog);
      paramPopupMenuDialog.getContentView().setOnClickListener(new aaiz(this, paramAppInterface));
      paramPopupMenuDialog.getContentView().getViewTreeObserver().addOnGlobalLayoutListener(new aaja(this, paramAppInterface, paramWorldCupMgr));
      return paramInt;
    }
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_Aaji == null) || (this.jdField_a_of_type_Aaji.jdField_a_of_type_JavaIoFileInputStream != null)) {}
    try
    {
      this.jdField_a_of_type_Aaji.jdField_a_of_type_JavaIoFileInputStream.close();
      label27:
      this.jdField_a_of_type_Aaji.jdField_a_of_type_JavaIoFileInputStream = null;
      this.jdField_a_of_type_Aaji = null;
      if (this.jdField_a_of_type_AndroidAnimationValueAnimator != null)
      {
        this.jdField_a_of_type_AndroidAnimationValueAnimator.removeAllListeners();
        this.jdField_a_of_type_AndroidAnimationValueAnimator.removeAllUpdateListeners();
        if (this.jdField_a_of_type_AndroidAnimationValueAnimator.isRunning()) {
          this.jdField_a_of_type_AndroidAnimationValueAnimator.end();
        }
        this.jdField_a_of_type_AndroidAnimationValueAnimator = null;
      }
      this.jdField_a_of_type_Boolean = false;
      return;
    }
    catch (Exception localException)
    {
      break label27;
    }
  }
  
  public void a(aaji paramaaji)
  {
    if (this.jdField_a_of_type_Boolean) {
      ThreadManager.getUIHandler().post(new aajb(this, paramaaji));
    }
  }
  
  void a(aaji paramaaji, aajp paramaajp)
  {
    ImageView localImageView = (ImageView)((View)paramaaji.jdField_a_of_type_JavaLangRefWeakReference.get()).findViewById(2131374909);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)localImageView.getLayoutParams();
    localLayoutParams.width = paramaajp.m;
    localLayoutParams.height = paramaajp.n;
    localLayoutParams.setMargins(paramaajp.q, paramaajp.r, 0, 0);
    localImageView.setLayoutParams(localLayoutParams);
    paramaaji = (Bitmap)paramaaji.jdField_a_of_type_ComTencentMobileqqArConfigWorldCupMgr.jdField_a_of_type_Aakl.a.get(Integer.valueOf(0));
    if (paramaaji == null) {
      QLog.w(jdField_a_of_type_JavaLangString, 1, "directShowMenuIcon, 没有图片资源");
    }
    for (;;)
    {
      localImageView.setVisibility(0);
      return;
      localImageView.setImageDrawable(new BitmapDrawable(paramaaji));
    }
  }
  
  public void a(TextView paramTextView, int paramInt, ImageView paramImageView, Drawable paramDrawable)
  {
    paramTextView.setTextColor(paramInt);
    if (paramDrawable != null)
    {
      paramDrawable.setColorFilter(paramInt, PorterDuff.Mode.MULTIPLY);
      paramImageView.setImageDrawable(paramDrawable);
    }
  }
  
  void a(PopupMenuDialog paramPopupMenuDialog, aajp paramaajp)
  {
    paramPopupMenuDialog = paramPopupMenuDialog.getContentView().findViewById(2131374913);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)paramPopupMenuDialog.getLayoutParams();
    localLayoutParams.width = paramaajp.s;
    localLayoutParams.height = paramaajp.t;
    localLayoutParams.setMargins(paramaajp.w, paramaajp.x, 0, 0);
    paramPopupMenuDialog.setLayoutParams(localLayoutParams);
  }
  
  public void a(WeakReference paramWeakReference)
  {
    QLog.w(jdField_a_of_type_JavaLangString, 1, "MainDownAni.stopDownAni");
    a();
  }
  
  public void b(aaji paramaaji)
  {
    boolean bool2 = false;
    Object localObject2 = (PopupMenuDialog)paramaaji.d.get();
    Object localObject3 = (View)paramaaji.b.get();
    View localView = (View)paramaaji.c.get();
    Object localObject1 = (View)paramaaji.jdField_a_of_type_JavaLangRefWeakReference.get();
    if ((localObject2 == null) || (localObject3 == null) || (localObject1 == null))
    {
      paramaaji = jdField_a_of_type_JavaLangString;
      localObject4 = new StringBuilder().append("MainDownAni.startDownAni, pop[");
      if (localObject2 != null)
      {
        bool1 = true;
        localObject2 = ((StringBuilder)localObject4).append(bool1).append("], addBtn[");
        if (localObject3 == null) {
          break label186;
        }
        bool1 = true;
        label112:
        localObject2 = ((StringBuilder)localObject2).append(bool1).append("], menuItem[");
        if (localObject1 == null) {
          break label191;
        }
      }
      label186:
      label191:
      for (boolean bool1 = true;; bool1 = false)
      {
        localObject1 = ((StringBuilder)localObject2).append(bool1).append("], football_in_AddBtn[");
        bool1 = bool2;
        if (localView != null) {
          bool1 = true;
        }
        QLog.w(paramaaji, 1, bool1 + "]");
        a();
        return;
        bool1 = false;
        break;
        bool1 = false;
        break label112;
      }
    }
    if (!((PopupMenuDialog)localObject2).isShowing())
    {
      QLog.w(jdField_a_of_type_JavaLangString, 1, "MainDownAni.startDownAni, 菜单没显示");
      a();
      return;
    }
    Object localObject4 = ((PopupMenuDialog)localObject2).getContentView();
    paramaaji.e = new WeakReference((ImageView)((View)localObject4).findViewById(2131374913));
    localObject3 = MainEntryAni.a((View)localObject3);
    if (localObject3 == null)
    {
      QLog.w(jdField_a_of_type_JavaLangString, 1, "MainDownAni.startDownAni, positionInfo为空");
      a();
      return;
    }
    MainEntryAni.a((aajp)localObject3, (View)localObject4, (View)localObject1);
    if ((localView == null) || (!localView.isShown()))
    {
      QLog.w(jdField_a_of_type_JavaLangString, 1, "directShowMenuIcon");
      a(paramaaji, (aajp)localObject3);
      a();
      return;
    }
    QLog.w(jdField_a_of_type_JavaLangString, 1, "loadDownAnimation");
    a((PopupMenuDialog)localObject2, (aajp)localObject3);
    localView.setVisibility(0);
    WorldCupConfigInfo.c(paramaaji.jdField_a_of_type_ComTencentMobileqqArConfigWorldCupConfigInfo.l, WorldCupConfigInfo.a());
    ThreadManager.getUIHandler().postDelayed(new aajc(this, paramaaji, (aajp)localObject3), 300L);
  }
  
  public void b(aaji paramaaji, aajp paramaajp)
  {
    Object localObject = (PopupMenuDialog)paramaaji.d.get();
    ImageView localImageView = (ImageView)paramaaji.e.get();
    View localView = (View)paramaaji.jdField_a_of_type_JavaLangRefWeakReference.get();
    String str = jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder().append("MainDownAni.onMovingAnimationEnd, popupWindow[");
    boolean bool;
    if (localObject != null)
    {
      bool = true;
      localStringBuilder = localStringBuilder.append(bool).append("], movingView[");
      if (localImageView == null) {
        break label142;
      }
      bool = true;
      label84:
      localStringBuilder = localStringBuilder.append(bool).append("], menuItem[");
      if (localView == null) {
        break label147;
      }
      bool = true;
      label105:
      QLog.w(str, 1, bool + "]");
      if ((localObject != null) && (localImageView != null)) {
        break label152;
      }
    }
    label142:
    label147:
    label152:
    do
    {
      return;
      bool = false;
      break;
      bool = false;
      break label84;
      bool = false;
      break label105;
      localImageView.setVisibility(8);
    } while (localView == null);
    if (AudioHelper.a(0) == 1)
    {
      localImageView.setBackgroundColor(Color.parseColor("#1F000000"));
      localView.setBackgroundColor(Color.parseColor("#1FFFC0CB"));
      localImageView.setVisibility(0);
      localObject = (ImageView)paramaaji.c.get();
      if (localObject != null) {
        ((ImageView)localObject).setVisibility(0);
      }
    }
    a(paramaaji, paramaajp);
    a();
  }
  
  public void c(aaji paramaaji)
  {
    Object localObject2 = (View)paramaaji.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localObject2 == null) {
      return;
    }
    Object localObject1 = (ImageView)((View)localObject2).findViewById(2131374907);
    localObject2 = (TextView)((View)localObject2).findViewById(2131374908);
    localObject1 = new WeakReference(localObject1);
    localObject2 = new WeakReference(localObject2);
    paramaaji = new BitmapDrawable((Bitmap)paramaaji.jdField_a_of_type_ComTencentMobileqqArConfigWorldCupMgr.b.a.get(Integer.valueOf(0)));
    String[] arrayOfString = new String[5];
    arrayOfString[0] = "#042531";
    arrayOfString[1] = "#074962";
    arrayOfString[2] = "#0b6e93";
    arrayOfString[3] = "#0e92c4";
    arrayOfString[4] = "#12b7f5";
    ValueAnimator localValueAnimator = ValueAnimator.ofObject(new IntEvaluator(), new Object[] { Integer.valueOf(0), Integer.valueOf(arrayOfString.length - 1) });
    localValueAnimator.setDuration(300L);
    localValueAnimator.setRepeatMode(2);
    localValueAnimator.setRepeatCount(3);
    localValueAnimator.addUpdateListener(new aajd(this, (WeakReference)localObject1, (WeakReference)localObject2, arrayOfString, paramaaji));
    localValueAnimator.start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ar.config.MainDownAni
 * JD-Core Version:    0.7.0.1
 */