package com.tencent.mobileqq.ar.config;

import aapp;
import aapq;
import aapr;
import aaps;
import aapt;
import aapu;
import aapv;
import aapz;
import aaqg;
import aarf;
import aari;
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
  aapz jdField_a_of_type_Aapz = null;
  ValueAnimator jdField_a_of_type_AndroidAnimationValueAnimator = null;
  private final String jdField_a_of_type_JavaLangString;
  public boolean a;
  
  public MainDownAni(String paramString)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  static int a(PopupMenuDialog paramPopupMenuDialog)
  {
    View localView1 = paramPopupMenuDialog.getContentView();
    Object localObject = localView1.getResources();
    int i = ((Resources)localObject).getDimensionPixelSize(2131558949);
    int j = ((Resources)localObject).getDimensionPixelSize(2131558953);
    paramPopupMenuDialog.setWidth(i + j);
    View localView2 = localView1.findViewById(2131370696);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)localView2.getLayoutParams();
    localLayoutParams.rightMargin = j;
    localView2.setLayoutParams(localLayoutParams);
    i = ((Resources)localObject).getDimensionPixelSize(2131558952);
    localView1 = localView1.findViewById(com.tencent.mobileqq.activity.recent.RecentOptPopBar.a[0]);
    localView1.setPadding(i, 0, 0, 0);
    localView1 = localView1.findViewById(2131363250);
    localObject = (LinearLayout.LayoutParams)localView1.getLayoutParams();
    ((LinearLayout.LayoutParams)localObject).width = -2;
    localView1.setLayoutParams((ViewGroup.LayoutParams)localObject);
    paramPopupMenuDialog.jdField_a_of_type_Boolean = true;
    return 0;
  }
  
  private boolean a(aapz paramaapz, aaqg paramaaqg)
  {
    ImageView localImageView = (ImageView)paramaapz.e.get();
    if (localImageView == null)
    {
      QLog.i(this.jdField_a_of_type_JavaLangString, 1, "loadDownAnimation, downAniView为空");
      a();
      return false;
    }
    Object localObject2 = paramaapz.jdField_a_of_type_JavaLangString + "menuicon_moving/";
    Object localObject1 = new File((String)localObject2, "down.json");
    if (!((File)localObject1).exists())
    {
      QLog.i(this.jdField_a_of_type_JavaLangString, 1, "loadDownAnimation, json文件不存在");
      a();
      return false;
    }
    localObject2 = new File((String)localObject2, "images");
    if (!((File)localObject2).exists())
    {
      QLog.i(this.jdField_a_of_type_JavaLangString, 1, "loadDownAnimation, image不存在");
      a();
      return false;
    }
    Object localObject3 = WorldCupMgr.a(((File)localObject1).getAbsolutePath());
    localObject3 = WorldCupMgr.a(this.jdField_a_of_type_JavaLangString, (String)localObject3, (int)(paramaaqg.t * 2 / paramaapz.jdField_a_of_type_Float), 1);
    if (AudioHelper.a(0) == 1) {
      WorldCupMgr.a(this.jdField_a_of_type_JavaLangString, (JSONObject)localObject3, ((File)localObject1).getAbsolutePath() + "_.json");
    }
    paramaaqg = new aapv(this, paramaapz, paramaaqg, ((File)localObject2).getAbsolutePath() + "/");
    if (localObject3 != null) {
      LottieComposition.Factory.fromJson(localImageView.getResources(), (JSONObject)localObject3, paramaaqg);
    }
    for (;;)
    {
      return true;
      try
      {
        localObject1 = new FileInputStream((File)localObject1);
        paramaapz.jdField_a_of_type_JavaIoFileInputStream = ((FileInputStream)localObject1);
        LottieComposition.Factory.fromInputStream(localImageView.getContext(), (InputStream)localObject1, paramaaqg);
      }
      catch (Exception paramaapz)
      {
        QLog.i(this.jdField_a_of_type_JavaLangString, 1, "loadDownAnimation, 读取json失败", paramaapz);
        a();
      }
    }
    return false;
  }
  
  static int b(PopupMenuDialog paramPopupMenuDialog)
  {
    View localView = paramPopupMenuDialog.getContentView().findViewById(2131370908);
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
    if ((WorldCupConfigInfo.d((WorldCupConfigInfo)localObject)) && (!paramWorldCupMgr.jdField_a_of_type_Aari.c()))
    {
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, "MainDownAni， 图片没有加载完成, mTaskStatus[" + paramWorldCupMgr.jdField_a_of_type_Aari.g + "]");
      return paramInt;
    }
    if (WorldCupStaticInstance.a().b)
    {
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, "MainDownAni， 从左到右播放中");
      return paramInt;
    }
    paramAppInterface = new aapz();
    this.jdField_a_of_type_Aapz = paramAppInterface;
    paramAppInterface.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(localView);
    paramAppInterface.jdField_a_of_type_JavaLangString = ((WorldCupConfigInfo)localObject).a(0);
    paramAppInterface.jdField_a_of_type_ComTencentMobileqqArConfigWorldCupMgr = paramWorldCupMgr;
    paramAppInterface.jdField_a_of_type_Float = localView.getResources().getDisplayMetrics().density;
    paramAppInterface.jdField_a_of_type_ComTencentMobileqqArConfigWorldCupConfigInfo = ((WorldCupConfigInfo)localObject);
    WorldCupStaticInstance.a().jdField_a_of_type_Boolean = true;
    paramPopupMenuDialog.setOnDismissListener(new aapp(this, paramAppInterface));
    localObject = (ImageView)paramView.findViewById(2131363993);
    if (localObject == null)
    {
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, "MainDownAni, 没找到conversation_title_right_btn");
      return paramInt;
    }
    paramView = (ImageView)paramView.findViewById(2131362519);
    paramAppInterface.b = new WeakReference(localObject);
    paramAppInterface.c = new WeakReference(paramView);
    a(paramPopupMenuDialog);
    if ((paramView != null) && (paramView.getVisibility() == 0)) {
      paramInt -= b(paramPopupMenuDialog);
    }
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isDevelopLevel()) {
        QLog.w(this.jdField_a_of_type_JavaLangString, 1, "modifyMenu, needDownAni[" + bool + "]");
      }
      paramAppInterface.d = new WeakReference(paramPopupMenuDialog);
      paramPopupMenuDialog.getContentView().setOnClickListener(new aapq(this, paramAppInterface));
      paramPopupMenuDialog.getContentView().getViewTreeObserver().addOnGlobalLayoutListener(new aapr(this, paramAppInterface, paramWorldCupMgr));
      return paramInt;
    }
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_Aapz == null) || (this.jdField_a_of_type_Aapz.jdField_a_of_type_JavaIoFileInputStream != null)) {}
    try
    {
      this.jdField_a_of_type_Aapz.jdField_a_of_type_JavaIoFileInputStream.close();
      label27:
      this.jdField_a_of_type_Aapz.jdField_a_of_type_JavaIoFileInputStream = null;
      this.jdField_a_of_type_Aapz = null;
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
  
  public void a(aapz paramaapz)
  {
    if (this.jdField_a_of_type_Boolean) {
      ThreadManager.getUIHandler().post(new aaps(this, paramaapz));
    }
  }
  
  void a(aapz paramaapz, aaqg paramaaqg)
  {
    ImageView localImageView = (ImageView)((View)paramaapz.jdField_a_of_type_JavaLangRefWeakReference.get()).findViewById(2131374965);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)localImageView.getLayoutParams();
    localLayoutParams.width = paramaaqg.m;
    localLayoutParams.height = paramaaqg.n;
    localLayoutParams.setMargins(paramaaqg.q, paramaaqg.r, 0, 0);
    localImageView.setLayoutParams(localLayoutParams);
    paramaapz = (Bitmap)paramaapz.jdField_a_of_type_ComTencentMobileqqArConfigWorldCupMgr.jdField_a_of_type_Aarf.a.get(Integer.valueOf(0));
    if (paramaapz == null) {
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, "directShowMenuIcon, 没有图片资源");
    }
    for (;;)
    {
      localImageView.setVisibility(0);
      return;
      localImageView.setImageDrawable(new BitmapDrawable(paramaapz));
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
  
  void a(PopupMenuDialog paramPopupMenuDialog, aaqg paramaaqg)
  {
    paramPopupMenuDialog = paramPopupMenuDialog.getContentView().findViewById(2131374957);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)paramPopupMenuDialog.getLayoutParams();
    localLayoutParams.width = paramaaqg.s;
    localLayoutParams.height = paramaaqg.t;
    localLayoutParams.setMargins(paramaaqg.w, paramaaqg.x, 0, 0);
    paramPopupMenuDialog.setLayoutParams(localLayoutParams);
  }
  
  public void a(WeakReference paramWeakReference)
  {
    QLog.w(this.jdField_a_of_type_JavaLangString, 1, "MainDownAni.stopDownAni");
    a();
  }
  
  public void b(aapz paramaapz)
  {
    boolean bool2 = false;
    Object localObject2 = (PopupMenuDialog)paramaapz.d.get();
    Object localObject3 = (View)paramaapz.b.get();
    View localView = (View)paramaapz.c.get();
    Object localObject1 = (View)paramaapz.jdField_a_of_type_JavaLangRefWeakReference.get();
    if ((localObject2 == null) || (localObject3 == null) || (localObject1 == null))
    {
      paramaapz = this.jdField_a_of_type_JavaLangString;
      localObject4 = new StringBuilder().append("MainDownAni.startDownAni, pop[");
      if (localObject2 != null)
      {
        bool1 = true;
        localObject2 = ((StringBuilder)localObject4).append(bool1).append("], addBtn[");
        if (localObject3 == null) {
          break label187;
        }
        bool1 = true;
        label113:
        localObject2 = ((StringBuilder)localObject2).append(bool1).append("], menuItem[");
        if (localObject1 == null) {
          break label192;
        }
      }
      label187:
      label192:
      for (boolean bool1 = true;; bool1 = false)
      {
        localObject1 = ((StringBuilder)localObject2).append(bool1).append("], football_in_AddBtn[");
        bool1 = bool2;
        if (localView != null) {
          bool1 = true;
        }
        QLog.w(paramaapz, 1, bool1 + "]");
        a();
        return;
        bool1 = false;
        break;
        bool1 = false;
        break label113;
      }
    }
    if (!((PopupMenuDialog)localObject2).isShowing())
    {
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, "MainDownAni.startDownAni, 菜单没显示");
      a();
      return;
    }
    Object localObject4 = ((PopupMenuDialog)localObject2).getContentView();
    paramaapz.e = new WeakReference((ImageView)((View)localObject4).findViewById(2131374957));
    localObject3 = MainEntryAni.a((View)localObject3);
    if (localObject3 == null)
    {
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, "MainDownAni.startDownAni, positionInfo为空");
      a();
      return;
    }
    MainEntryAni.a((aaqg)localObject3, (View)localObject4, (View)localObject1);
    if ((localView == null) || (!localView.isShown()))
    {
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, "directShowMenuIcon");
      a(paramaapz, (aaqg)localObject3);
      a();
      return;
    }
    QLog.w(this.jdField_a_of_type_JavaLangString, 1, "loadDownAnimation");
    a((PopupMenuDialog)localObject2, (aaqg)localObject3);
    localView.setVisibility(0);
    WorldCupConfigInfo.c(paramaapz.jdField_a_of_type_ComTencentMobileqqArConfigWorldCupConfigInfo.l, WorldCupConfigInfo.a());
    ThreadManager.getUIHandler().postDelayed(new aapt(this, paramaapz, (aaqg)localObject3), 300L);
  }
  
  public void b(aapz paramaapz, aaqg paramaaqg)
  {
    Object localObject = (PopupMenuDialog)paramaapz.d.get();
    ImageView localImageView = (ImageView)paramaapz.e.get();
    View localView = (View)paramaapz.jdField_a_of_type_JavaLangRefWeakReference.get();
    String str = this.jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder().append("MainDownAni.onMovingAnimationEnd, popupWindow[");
    boolean bool;
    if (localObject != null)
    {
      bool = true;
      localStringBuilder = localStringBuilder.append(bool).append("], movingView[");
      if (localImageView == null) {
        break label143;
      }
      bool = true;
      label85:
      localStringBuilder = localStringBuilder.append(bool).append("], menuItem[");
      if (localView == null) {
        break label148;
      }
      bool = true;
      label106:
      QLog.w(str, 1, bool + "]");
      if ((localObject != null) && (localImageView != null)) {
        break label153;
      }
    }
    label143:
    label148:
    label153:
    do
    {
      return;
      bool = false;
      break;
      bool = false;
      break label85;
      bool = false;
      break label106;
      localImageView.setVisibility(8);
    } while (localView == null);
    if (AudioHelper.a(0) == 1)
    {
      localImageView.setBackgroundColor(Color.parseColor("#1F000000"));
      localView.setBackgroundColor(Color.parseColor("#1FFFC0CB"));
      localImageView.setVisibility(0);
      localObject = (ImageView)paramaapz.c.get();
      if (localObject != null) {
        ((ImageView)localObject).setVisibility(0);
      }
    }
    a(paramaapz, paramaaqg);
    a();
  }
  
  public void c(aapz paramaapz)
  {
    Object localObject2 = (View)paramaapz.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localObject2 == null) {
      return;
    }
    Object localObject1 = (ImageView)((View)localObject2).findViewById(2131363249);
    localObject2 = (TextView)((View)localObject2).findViewById(2131363250);
    localObject1 = new WeakReference(localObject1);
    localObject2 = new WeakReference(localObject2);
    paramaapz = new BitmapDrawable((Bitmap)paramaapz.jdField_a_of_type_ComTencentMobileqqArConfigWorldCupMgr.b.a.get(Integer.valueOf(0)));
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
    localValueAnimator.addUpdateListener(new aapu(this, (WeakReference)localObject1, (WeakReference)localObject2, arrayOfString, paramaapz));
    localValueAnimator.start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ar.config.MainDownAni
 * JD-Core Version:    0.7.0.1
 */