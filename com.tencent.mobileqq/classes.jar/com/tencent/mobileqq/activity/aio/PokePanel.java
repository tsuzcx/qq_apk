package com.tencent.mobileqq.activity.aio;

import aanz;
import acyc;
import acyd;
import acye;
import acyf;
import adnj;
import adwf;
import adwj;
import ajya;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.HandlerThread;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import anpc;
import anpv;
import axqy;
import bbef;
import bbri;
import bfos;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.item.CustomFrameAnimationDrawable;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.utils.PokeBigResHandler;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import com.tencent.mobileqq.vas.VasQuickUpdateManager.CallBacker;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinnableBitmapDrawable;
import com.tencent.widget.AbsListView;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.os.MqqHandler;

public class PokePanel
  extends RelativeLayout
  implements adnj, View.OnClickListener, bfos
{
  public static boolean c;
  public int a;
  long jdField_a_of_type_Long = 0L;
  private acyf jdField_a_of_type_Acyf;
  HandlerThread jdField_a_of_type_AndroidOsHandlerThread;
  bbri jdField_a_of_type_Bbri = new acyd(this);
  BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  VasQuickUpdateManager.CallBacker jdField_a_of_type_ComTencentMobileqqVasVasQuickUpdateManager$CallBacker = new acyc(this);
  private ListView jdField_a_of_type_ComTencentWidgetListView;
  private String jdField_a_of_type_JavaLangString;
  private ArrayList<int[]> jdField_a_of_type_JavaUtilArrayList;
  MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  public boolean a;
  private final int[] jdField_a_of_type_ArrayOfInt = { 2131720932, 2130838928, 3 };
  public int b;
  long jdField_b_of_type_Long = 0L;
  public boolean b;
  private final int[] jdField_b_of_type_ArrayOfInt = { 2131695234, 2130838891, 1 };
  private final int[] c;
  private boolean jdField_d_of_type_Boolean;
  private final int[] jdField_d_of_type_ArrayOfInt = { 2131693268, 2130838926, 4 };
  private boolean jdField_e_of_type_Boolean;
  private final int[] jdField_e_of_type_ArrayOfInt = { 2131693276, 2130838927, 5 };
  private final int[] f = { 2131693191, 2130838892, 6 };
  
  public PokePanel(Context paramContext)
  {
    super(paramContext);
    this.jdField_c_of_type_ArrayOfInt = new int[] { 2131693065, 2130838864, 2 };
    this.jdField_a_of_type_Int = -1;
    this.jdField_b_of_type_Int = 1;
  }
  
  public PokePanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_c_of_type_ArrayOfInt = new int[] { 2131693065, 2130838864, 2 };
    this.jdField_a_of_type_Int = -1;
    this.jdField_b_of_type_Int = 1;
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    if (!jdField_c_of_type_Boolean) {
      ThreadManager.excute(new PokePanel.1(paramQQAppInterface), 64, null, true);
    }
  }
  
  private void a(ArrayList<acye> paramArrayList)
  {
    int i = 0;
    if (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      int[] arrayOfInt = (int[])this.jdField_a_of_type_JavaUtilArrayList.get(i);
      acye localacye = new acye();
      if ((arrayOfInt[2] == 1) && (!adwj.b(arrayOfInt[2]))) {
        localacye.jdField_a_of_type_AndroidGraphicsDrawableDrawable = BaseApplicationImpl.getContext().getResources().getDrawable(2130838001);
      }
      for (;;)
      {
        localacye.jdField_a_of_type_Int = arrayOfInt[2];
        localacye.jdField_b_of_type_Int = arrayOfInt[1];
        localacye.jdField_a_of_type_JavaLangString = BaseApplicationImpl.getContext().getResources().getString(arrayOfInt[0]);
        localacye.jdField_b_of_type_JavaLangString = (BaseApplicationImpl.getContext().getResources().getString(arrayOfInt[0]) + ajya.a(2131708338));
        localacye.jdField_b_of_type_Boolean = false;
        paramArrayList.add(localacye);
        i += 1;
        break;
        if ((arrayOfInt[2] != 0) && (adwj.b(arrayOfInt[2])))
        {
          String str;
          Object localObject;
          int j;
          switch (arrayOfInt[2])
          {
          default: 
            str = adwf.jdField_a_of_type_JavaLangString + "/chuo_icon/chuo_icon_";
            localObject = new BitmapFactory.Options();
            ((BitmapFactory.Options)localObject).inSampleSize = 1;
            ((BitmapFactory.Options)localObject).inMutable = true;
            localObject = bbef.a(str + "01.png", (BitmapFactory.Options)localObject);
            localObject = new CustomFrameAnimationDrawable(BaseApplicationImpl.getContext().getResources(), (Bitmap)localObject, this.jdField_a_of_type_MqqOsMqqHandler);
            j = 0;
            label318:
            if (j >= 22) {
              break label571;
            }
            if (j + 1 < 10) {
              ((CustomFrameAnimationDrawable)localObject).a(j, 40, str + "0" + (j + 1) + ".png");
            }
            break;
          }
          for (;;)
          {
            j += 1;
            break label318;
            str = adwf.jdField_a_of_type_JavaLangString + "/chuo_icon/chuo_icon_";
            break;
            str = adwf.jdField_a_of_type_JavaLangString + "/bixin_icon/bixin_icon_";
            break;
            str = adwf.jdField_a_of_type_JavaLangString + "/zan_icon/zan_icon_";
            break;
            str = adwf.jdField_a_of_type_JavaLangString + "/xinsui_icon/xinsui_icon_";
            break;
            str = adwf.jdField_a_of_type_JavaLangString + "/dazhao_icon/dazhao_icon_";
            break;
            str = adwf.jdField_a_of_type_JavaLangString + "/666_icon/666_icon_";
            break;
            ((CustomFrameAnimationDrawable)localObject).a(j, 40, str + (j + 1) + ".png");
          }
          label571:
          localacye.jdField_a_of_type_AndroidGraphicsDrawableDrawable = ((Drawable)localObject);
        }
        else
        {
          localacye.jdField_a_of_type_AndroidGraphicsDrawableDrawable = BaseApplicationImpl.getContext().getResources().getDrawable(arrayOfInt[1]);
        }
      }
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface)
  {
    if (jdField_c_of_type_Boolean) {
      return true;
    }
    if ((adwj.b(2)) && (adwj.b(3)) && (adwj.b(4)) && (adwj.b(5)) && (adwj.b(6)) && (PokeBigResHandler.a()))
    {
      adwj.a(paramQQAppInterface, null);
      jdField_c_of_type_Boolean = true;
      return true;
    }
    Object localObject = (anpc)paramQQAppInterface.getManager(77);
    if (localObject != null)
    {
      localObject = (anpv)((anpc)localObject).a("qq.android.poke.res_0625");
      paramQQAppInterface = (PokeBigResHandler)paramQQAppInterface.a(117);
      if (localObject != null) {
        ((anpv)localObject).a(true);
      }
      if ((paramQQAppInterface != null) && (!PokeBigResHandler.a())) {
        paramQQAppInterface.a(true);
      }
    }
    jdField_c_of_type_Boolean = false;
    return false;
  }
  
  private void b(Bundle paramBundle)
  {
    int i = paramBundle.getInt("type");
    int j = paramBundle.getInt("id");
    String str1 = paramBundle.getString("name");
    String str2 = paramBundle.getString("minVersion");
    int k = paramBundle.getInt("feeType");
    if (QLog.isColorLevel()) {
      QLog.d("PokeMsg", 2, new Object[] { "panel sendPokeMsg type:" + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, Integer.valueOf(1) });
    }
    switch (j)
    {
    default: 
      if (126 == i)
      {
        if (!paramBundle.getBoolean("isShowLoading")) {
          break label660;
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.aio.PokePanel", 2, "poke item is downloading, do nothing");
        }
      }
      break;
    }
    label184:
    do
    {
      return;
      aanz.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, BaseApplicationImpl.getContext(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, 1, "", "");
      axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "0X8007F22", "0X8007F22", 1, 0, "", "", "", "");
      break;
      aanz.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, BaseApplicationImpl.getContext(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, 2, "", "");
      axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "0X8007F22", "0X8007F22", 2, 0, "", "", "", "");
      break;
      aanz.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, BaseApplicationImpl.getContext(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, 4, "", "");
      axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "0X8007F22", "0X8007F22", 4, 0, "", "", "", "");
      break;
      aanz.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, BaseApplicationImpl.getContext(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, 3, "", "");
      axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "0X8007F22", "0X8007F22", 3, 0, "", "", "", "");
      break;
      if (this.jdField_a_of_type_Long == 0L) {}
      for (this.jdField_a_of_type_Long = SystemClock.currentThreadTimeMillis();; this.jdField_a_of_type_Long = SystemClock.currentThreadTimeMillis())
      {
        this.jdField_a_of_type_Long = SystemClock.currentThreadTimeMillis();
        aanz.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, BaseApplicationImpl.getContext(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, 5, "", "");
        axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "0X8007F22", "0X8007F22", 5, 0, "", "", "", "");
        break;
        if (SystemClock.currentThreadTimeMillis() - this.jdField_a_of_type_Long < 500L) {
          break label184;
        }
      }
      if (this.jdField_b_of_type_Long == 0L) {}
      for (this.jdField_b_of_type_Long = SystemClock.currentThreadTimeMillis();; this.jdField_b_of_type_Long = SystemClock.currentThreadTimeMillis())
      {
        aanz.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, BaseApplicationImpl.getContext(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, 6, "", "");
        axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "0X8007F22", "0X8007F22", 6, 0, "", "", "", "");
        break;
        if (SystemClock.currentThreadTimeMillis() - this.jdField_b_of_type_Long < 500L) {
          break label184;
        }
      }
      if (paramBundle.getBoolean("isShowDownload"))
      {
        this.jdField_a_of_type_Acyf.a("poke.item.res.", j, true, false);
        paramBundle = (VasQuickUpdateManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(184);
        if (!adwj.a("effect.gif", j)) {
          paramBundle.downloadItem(21L, "poke.item.effect." + j, "clickDownload");
        }
        paramBundle.downloadItem(21L, "poke.item.res." + j, "clickDownload");
        paramBundle.addCallBacker(this.jdField_a_of_type_ComTencentMobileqqVasVasQuickUpdateManager$CallBacker);
        return;
      }
    } while (adwj.jdField_a_of_type_Boolean);
    label660:
    adwj.jdField_a_of_type_Boolean = true;
    adwj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, j, str1, k, str2, 0);
  }
  
  private void b(String paramString)
  {
    int j = paramString.length();
    int i = 0;
    if (i < j)
    {
      switch (paramString.charAt(i))
      {
      }
      for (;;)
      {
        i += 1;
        break;
        this.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_b_of_type_ArrayOfInt);
        continue;
        this.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_c_of_type_ArrayOfInt);
        continue;
        this.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_a_of_type_ArrayOfInt);
        continue;
        this.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_d_of_type_ArrayOfInt);
        continue;
        this.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_e_of_type_ArrayOfInt);
        continue;
        this.jdField_a_of_type_JavaUtilArrayList.add(this.f);
      }
    }
  }
  
  public void a()
  {
    this.jdField_d_of_type_Boolean = true;
  }
  
  public void a(Bundle paramBundle)
  {
    if (!this.jdField_e_of_type_Boolean) {
      b(paramBundle);
    }
    this.jdField_e_of_type_Boolean = false;
  }
  
  public void a(BaseChatPie paramBaseChatPie, SessionInfo paramSessionInfo, String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramBaseChatPie.a();
    this.jdField_a_of_type_ComTencentWidgetListView = ((ListView)findViewById(2131367705));
    this.jdField_a_of_type_ComTencentWidgetListView.setOnScrollListener(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().addObserver(this.jdField_a_of_type_Bbri);
    paramBaseChatPie = getResources().getDrawable(2130849176);
    if ((paramBaseChatPie instanceof BitmapDrawable))
    {
      ((BitmapDrawable)paramBaseChatPie).setTileModeXY(Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
      ((BitmapDrawable)paramBaseChatPie).setDither(true);
      setBackgroundDrawable(paramBaseChatPie);
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaLangString = paramString;
      return;
      if ((paramBaseChatPie instanceof SkinnableBitmapDrawable))
      {
        ((SkinnableBitmapDrawable)paramBaseChatPie).setTileModeXY(Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
        ((SkinnableBitmapDrawable)paramBaseChatPie).setDither(true);
        setBackgroundDrawable(paramBaseChatPie);
      }
    }
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    }
    for (;;)
    {
      ArrayList localArrayList = new ArrayList();
      if (this.jdField_a_of_type_AndroidOsHandlerThread == null)
      {
        this.jdField_a_of_type_AndroidOsHandlerThread = ThreadManager.newFreeHandlerThread("PokePanelAnimThread", 0);
        this.jdField_a_of_type_AndroidOsHandlerThread.start();
        this.jdField_a_of_type_MqqOsMqqHandler = new MqqHandler(this.jdField_a_of_type_AndroidOsHandlerThread.getLooper());
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.aio.PokePanel", 2, "[pokepanel]reload()");
      }
      this.jdField_a_of_type_Acyf = new acyf(BaseApplication.getContext());
      this.jdField_a_of_type_Acyf.a(this);
      this.jdField_a_of_type_Acyf.a(this);
      this.jdField_a_of_type_ComTencentWidgetListView.setAdapter(this.jdField_a_of_type_Acyf);
      ThreadManager.getFileThreadHandler().post(new PokePanel.2(this, paramString, localArrayList));
      return;
      this.jdField_a_of_type_JavaUtilArrayList.clear();
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList != null) {
      this.jdField_a_of_type_JavaUtilArrayList.clear();
    }
  }
  
  public void c()
  {
    if (this.jdField_b_of_type_Boolean) {
      return;
    }
    this.jdField_b_of_type_Boolean = true;
    try
    {
      this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_AndroidOsHandlerThread.quit();
      this.jdField_a_of_type_AndroidOsHandlerThread = null;
      Object localObject = this.jdField_a_of_type_Acyf.a();
      if ((localObject != null) && (((ArrayList)localObject).size() > 0))
      {
        localObject = ((ArrayList)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          acye localacye = (acye)((Iterator)localObject).next();
          if ((localacye.jdField_a_of_type_AndroidGraphicsDrawableDrawable instanceof CustomFrameAnimationDrawable)) {
            ((CustomFrameAnimationDrawable)localacye.jdField_a_of_type_AndroidGraphicsDrawableDrawable).j();
          }
        }
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.d("Q.aio.PokePanel", 1, "ondestroy err " + localException);
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().removeObserver(this.jdField_a_of_type_Bbri);
      ((VasQuickUpdateManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(184)).removeCallBacker(this.jdField_a_of_type_ComTencentMobileqqVasVasQuickUpdateManager$CallBacker);
    }
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = false;
      Object localObject = this.jdField_a_of_type_Acyf.a();
      if ((localObject != null) && (((ArrayList)localObject).size() > 0))
      {
        localObject = ((ArrayList)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          acye localacye = (acye)((Iterator)localObject).next();
          if ((localacye.jdField_a_of_type_AndroidGraphicsDrawableDrawable instanceof CustomFrameAnimationDrawable)) {
            ((CustomFrameAnimationDrawable)localacye.jdField_a_of_type_AndroidGraphicsDrawableDrawable).l();
          }
        }
      }
    }
    ((PokeBigResHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(117)).a(false);
  }
  
  public void e()
  {
    if ((!this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Acyf != null))
    {
      this.jdField_a_of_type_Boolean = true;
      Object localObject = this.jdField_a_of_type_Acyf.a();
      if ((localObject != null) && (((ArrayList)localObject).size() > 0))
      {
        localObject = ((ArrayList)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          acye localacye = (acye)((Iterator)localObject).next();
          if ((localacye.jdField_a_of_type_AndroidGraphicsDrawableDrawable instanceof CustomFrameAnimationDrawable)) {
            ((CustomFrameAnimationDrawable)localacye.jdField_a_of_type_AndroidGraphicsDrawableDrawable).k();
          }
        }
      }
    }
  }
  
  public void onClick(View paramView) {}
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    c();
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if ((paramInt != 0) && (this.jdField_d_of_type_Boolean))
    {
      this.jdField_e_of_type_Boolean = true;
      return;
    }
    this.jdField_e_of_type_Boolean = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.PokePanel
 * JD-Core Version:    0.7.0.1
 */