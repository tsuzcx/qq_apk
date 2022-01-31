package com.tencent.av.utils;

import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.SessionInfo.Anychat_Info;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.core.VcSystemInfo;
import com.tencent.av.opengl.utils.Utils;
import com.tencent.av.smallscreen.SmallScreenUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import khr;
import khs;

public class TipsManager
{
  public static ResidentTip a;
  int jdField_a_of_type_Int = 0;
  public Handler a;
  ImageView jdField_a_of_type_AndroidWidgetImageView = null;
  public LinearLayout a;
  ProgressBar jdField_a_of_type_AndroidWidgetProgressBar = null;
  TextView jdField_a_of_type_AndroidWidgetTextView = null;
  VideoAppInterface jdField_a_of_type_ComTencentAvAppVideoAppInterface = null;
  Runnable jdField_a_of_type_JavaLangRunnable = null;
  String jdField_a_of_type_JavaLangString = null;
  private ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  public Map a;
  boolean jdField_a_of_type_Boolean = false;
  public int b;
  ImageView jdField_b_of_type_AndroidWidgetImageView = null;
  public TextView b;
  Runnable jdField_b_of_type_JavaLangRunnable = new khs(this);
  public boolean b;
  int jdField_c_of_type_Int = 0;
  TextView jdField_c_of_type_AndroidWidgetTextView = null;
  boolean jdField_c_of_type_Boolean = false;
  int jdField_d_of_type_Int = 0;
  boolean jdField_d_of_type_Boolean = true;
  public boolean e = false;
  private boolean f;
  
  static
  {
    jdField_a_of_type_ComTencentAvUtilsResidentTip = new ResidentTip(0, null);
  }
  
  public TipsManager(VideoAppInterface paramVideoAppInterface, LinearLayout paramLinearLayout)
  {
    this.jdField_b_of_type_Int = 0;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidOsHandler = null;
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramLinearLayout.findViewById(2131364222));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = paramLinearLayout;
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramLinearLayout.findViewById(2131364221));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramLinearLayout.findViewById(2131365803));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramLinearLayout.findViewById(2131365801));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramLinearLayout.findViewById(2131365802));
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = paramVideoAppInterface;
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
    this.jdField_a_of_type_JavaLangRunnable = new khr(this);
  }
  
  private void a(boolean paramBoolean1, int paramInt, long paramLong, boolean paramBoolean2, String paramString, boolean paramBoolean3, boolean paramBoolean4)
  {
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        TipsManager.TipsListener localTipsListener = (TipsManager.TipsListener)localIterator.next();
        if (localTipsListener != null) {
          localTipsListener.a(paramBoolean1, paramInt, paramBoolean2, paramLong, paramString, paramBoolean3, paramBoolean4);
        }
      }
    }
  }
  
  public static boolean a(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TipsManager", 2, "setResidentTips-->type=" + paramInt + " ,wording" + paramString + " ,originalType=" + jdField_a_of_type_ComTencentAvUtilsResidentTip.jdField_a_of_type_Int);
    }
    if (paramInt > jdField_a_of_type_ComTencentAvUtilsResidentTip.jdField_a_of_type_Int)
    {
      jdField_a_of_type_ComTencentAvUtilsResidentTip.jdField_a_of_type_Int = paramInt;
      jdField_a_of_type_ComTencentAvUtilsResidentTip.jdField_a_of_type_JavaLangString = paramString;
      return true;
    }
    return false;
  }
  
  public static void c(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TipsManager", 2, "removeResidentTips-->type=" + paramInt);
    }
    if ((paramInt == jdField_a_of_type_ComTencentAvUtilsResidentTip.jdField_a_of_type_Int) || (paramInt == 109))
    {
      jdField_a_of_type_ComTencentAvUtilsResidentTip.jdField_a_of_type_Int = 0;
      jdField_a_of_type_ComTencentAvUtilsResidentTip.jdField_a_of_type_JavaLangString = null;
    }
  }
  
  public void a()
  {
    this.jdField_d_of_type_Boolean = false;
    c();
  }
  
  public void a(int paramInt)
  {
    int j = this.jdField_b_of_type_Int;
    this.jdField_b_of_type_Int = paramInt;
    Object localObject = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
    String str = ((VideoController)localObject).a().c;
    int i = ((VideoController)localObject).b(str);
    if (QLog.isColorLevel()) {
      QLog.w("TipsManager", 1, "showTips, Type[" + j + "->" + this.jdField_b_of_type_Int + "], mFullScreen[" + this.jdField_c_of_type_Boolean + "], mCurrentState[" + this.jdField_a_of_type_Boolean + "], mPreviosState[" + this.jdField_b_of_type_Boolean + "], mPreviosType[" + this.jdField_d_of_type_Int + "]");
    }
    if (this.jdField_a_of_type_AndroidWidgetTextView == null) {
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    long l = 32767L;
    label745:
    boolean bool2;
    boolean bool1;
    switch (this.jdField_b_of_type_Int)
    {
    default: 
      a();
      i = 0;
      bool2 = false;
      bool1 = true;
    }
    for (;;)
    {
      label753:
      b(paramInt);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      if (this.jdField_a_of_type_JavaLangString != null) {
        b(bool1, bool2);
      }
      boolean bool3;
      if (jdField_a_of_type_ComTencentAvUtilsResidentTip.jdField_a_of_type_Int == 0)
      {
        bool3 = true;
        label804:
        a(true, paramInt, l, bool3, this.jdField_a_of_type_JavaLangString, bool1, bool2);
        if ((!this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().a().p) && (this.jdField_d_of_type_Boolean)) {
          break label4571;
        }
        c();
      }
      while (i != 0)
      {
        a();
        return;
        a();
        i = 0;
        bool2 = false;
        bool1 = true;
        break label753;
        if (QLog.isColorLevel()) {
          QLog.d("TipsManager", 2, "showTips TYPE_RANDOM_MEMBER_KICK_OUT [random room owner]");
        }
        if (this.jdField_a_of_type_Boolean)
        {
          this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 3000L);
          if (!QLog.isColorLevel()) {
            break label4589;
          }
          QLog.d("TipsManager", 2, "postDelayed TYPE_RANDOM_MEMBER_KICK_OUT [random room owner]");
          l = 3000L;
          bool2 = false;
          bool1 = false;
          i = 0;
          break label753;
        }
        if (QLog.isColorLevel()) {
          QLog.d("TipsManager", 2, "removeTips TYPE_RANDOM_MEMBER_KICK_OUT [random room owner]");
        }
        a();
        i = 0;
        bool2 = false;
        bool1 = false;
        break label753;
        if (this.jdField_a_of_type_Boolean)
        {
          this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getString(2131429186);
          i = 0;
          bool2 = false;
          bool1 = true;
          break label753;
        }
        a();
        i = 0;
        bool2 = false;
        bool1 = true;
        break label753;
        if (this.jdField_a_of_type_Boolean)
        {
          this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getString(2131428691);
          i = 0;
          bool2 = false;
          bool1 = true;
          break label753;
        }
        a();
        i = 0;
        bool2 = false;
        bool1 = true;
        break label753;
        if (this.jdField_a_of_type_Boolean)
        {
          this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
          if (!this.jdField_c_of_type_Boolean) {
            break label745;
          }
          this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 3000L);
          l = 3000L;
          bool2 = false;
          bool1 = true;
          i = 0;
          break label753;
        }
        a();
        i = 0;
        bool2 = false;
        bool1 = true;
        break label753;
        if (this.jdField_a_of_type_Boolean)
        {
          this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getString(2131428696);
          i = 0;
          bool2 = false;
          bool1 = false;
          break label753;
        }
        a();
        i = 0;
        bool2 = false;
        bool1 = false;
        break label753;
        if (this.jdField_a_of_type_Boolean)
        {
          this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getString(2131428697);
          this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 3000L);
          l = 3000L;
          bool2 = false;
          bool1 = true;
          i = 0;
          break label753;
        }
        this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getString(2131428698);
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 3000L);
        l = 3000L;
        bool2 = false;
        bool1 = false;
        i = 0;
        break label753;
        if (this.jdField_a_of_type_Boolean)
        {
          this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getString(2131428686);
          i = 0;
          bool2 = false;
          bool1 = false;
          break label753;
        }
        a();
        i = 0;
        bool2 = false;
        bool1 = false;
        break label753;
        if (this.jdField_a_of_type_Boolean)
        {
          this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getString(2131429184);
          this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 3000L);
          l = 3000L;
          bool2 = false;
          bool1 = false;
          i = 0;
          break label753;
        }
        a();
        i = 0;
        bool2 = false;
        bool1 = false;
        break label753;
        if (this.jdField_a_of_type_Boolean)
        {
          this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getString(2131428687);
          i = 0;
          bool2 = false;
          bool1 = false;
          break label753;
        }
        a();
        i = 0;
        bool2 = false;
        bool1 = false;
        break label753;
        if (this.jdField_a_of_type_Boolean)
        {
          if (((VideoController)localObject).b(str) == 5)
          {
            this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getString(2131428695);
            this.jdField_d_of_type_Int = this.jdField_b_of_type_Int;
            i = 0;
            bool2 = false;
            bool1 = false;
            break label753;
          }
          this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getString(2131429102);
          i = 0;
          bool2 = false;
          bool1 = true;
          break label753;
        }
        a();
        this.jdField_d_of_type_Int = 0;
        i = 0;
        bool2 = false;
        bool1 = true;
        break label753;
        if (this.jdField_a_of_type_Boolean)
        {
          this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getString(2131428694);
          this.jdField_d_of_type_Int = this.jdField_b_of_type_Int;
          i = 0;
          bool2 = false;
          bool1 = true;
          break label753;
        }
        a();
        this.jdField_d_of_type_Int = 0;
        i = 0;
        bool2 = false;
        bool1 = false;
        break label753;
        this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getString(2131429123);
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 3000L);
        l = 3000L;
        bool2 = false;
        bool1 = true;
        i = 0;
        break label753;
        this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getString(2131429124);
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 3000L);
        l = 3000L;
        bool2 = false;
        bool1 = true;
        i = 0;
        break label753;
        if (this.jdField_a_of_type_Boolean)
        {
          localObject = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp();
          if (this.f) {}
          for (i = 2131429411;; i = 2131428701)
          {
            this.jdField_a_of_type_JavaLangString = ((BaseApplication)localObject).getString(i);
            this.jdField_d_of_type_Int = this.jdField_b_of_type_Int;
            i = 0;
            bool2 = false;
            bool1 = true;
            break;
          }
        }
        if (!this.f) {}
        for (this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getString(2131428703);; this.jdField_a_of_type_JavaLangString = "")
        {
          this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 3000L);
          this.jdField_d_of_type_Int = 0;
          l = 3000L;
          bool2 = false;
          bool1 = false;
          i = 0;
          break;
        }
        this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getString(2131429130);
        this.jdField_d_of_type_Int = this.jdField_b_of_type_Int;
        i = 0;
        bool2 = false;
        bool1 = true;
        break label753;
        this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getString(2131429131);
        this.jdField_d_of_type_Int = this.jdField_b_of_type_Int;
        i = 0;
        bool2 = true;
        bool1 = false;
        break label753;
        if (this.jdField_a_of_type_Boolean)
        {
          this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getString(2131429195);
          this.jdField_d_of_type_Int = this.jdField_b_of_type_Int;
          i = 0;
          bool2 = false;
          bool1 = true;
          break label753;
        }
        e();
        i = 0;
        bool2 = false;
        bool1 = true;
        break label753;
        if (this.jdField_a_of_type_Boolean)
        {
          localObject = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp();
          if (this.f) {}
          for (i = 2131429410;; i = 2131428706)
          {
            this.jdField_a_of_type_JavaLangString = ((BaseApplication)localObject).getString(i);
            i = 0;
            bool2 = false;
            bool1 = true;
            break;
          }
        }
        e();
        i = 0;
        bool2 = false;
        bool1 = true;
        break label753;
        if (this.jdField_a_of_type_Boolean)
        {
          this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getString(2131428707);
          i = 0;
          bool2 = false;
          bool1 = true;
          break label753;
        }
        e();
        i = 0;
        bool2 = false;
        bool1 = true;
        break label753;
        h();
        i = ((VideoController)localObject).a().a.jdField_a_of_type_Int;
        if ((i == 3) || (i == 1))
        {
          i = 0;
          bool2 = false;
          bool1 = false;
          break label753;
        }
        i = 0;
        bool2 = true;
        bool1 = false;
        break label753;
        this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_JavaLangString);
        i = 0;
        bool2 = false;
        bool1 = true;
        break label753;
        this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getString(2131429368);
        i = 0;
        bool2 = false;
        bool1 = false;
        break label753;
        this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getString(2131429370);
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 3000L);
        l = 3000L;
        bool2 = false;
        bool1 = false;
        i = 0;
        break label753;
        this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getString(2131429369);
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 3000L);
        l = 3000L;
        bool2 = false;
        bool1 = false;
        i = 0;
        break label753;
        this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getString(2131429462);
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 3000L);
        l = 3000L;
        bool2 = false;
        bool1 = false;
        i = 0;
        break label753;
        this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_JavaLangString);
        i = 0;
        bool2 = false;
        bool1 = true;
        break label753;
        if (this.jdField_a_of_type_Boolean)
        {
          this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getString(2131429079);
          i = 0;
          bool2 = false;
          bool1 = false;
          break label753;
        }
        a();
        i = 0;
        bool2 = false;
        bool1 = false;
        break label753;
        this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getString(2131428755);
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 3000L);
        l = 3000L;
        bool2 = false;
        bool1 = true;
        i = 0;
        break label753;
        if (this.jdField_a_of_type_Boolean)
        {
          this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getString(2131428690);
          i = 0;
          bool2 = false;
          bool1 = false;
          break label753;
        }
        a();
        i = 0;
        bool2 = false;
        bool1 = false;
        break label753;
        this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getString(2131429099);
        i = 0;
        bool2 = false;
        bool1 = true;
        break label753;
        this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getString(2131429116);
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 3000L);
        l = 3000L;
        bool2 = true;
        bool1 = false;
        i = 0;
        break label753;
        this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getString(2131429115);
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 3000L);
        l = 3000L;
        bool2 = true;
        bool1 = false;
        i = 0;
        break label753;
        this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getString(2131429100);
        i = 0;
        bool2 = false;
        bool1 = true;
        break label753;
        this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getString(2131429117);
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 5000L);
        l = 5000L;
        i = 0;
        bool2 = false;
        bool1 = true;
        break label753;
        this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getString(2131429118);
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 5000L);
        this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getString(2131429117);
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 3000L);
        l = 3000L;
        bool2 = false;
        bool1 = true;
        i = 0;
        break label753;
        this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getString(2131428968);
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 30000L);
        l = 30000L;
        i = 0;
        bool2 = true;
        bool1 = false;
        break label753;
        this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getString(2131428699);
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 3000L);
        l = 3000L;
        bool2 = false;
        bool1 = true;
        i = 0;
        break label753;
        this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getString(2131428700);
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 3000L);
        l = 3000L;
        bool2 = false;
        bool1 = true;
        i = 0;
        break label753;
        this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getString(2131429165);
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 3000L);
        l = 3000L;
        bool2 = false;
        bool1 = true;
        i = 0;
        break label753;
        this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getString(2131429166);
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 3000L);
        l = 3000L;
        bool2 = false;
        bool1 = true;
        i = 0;
        break label753;
        this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getString(2131429112);
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 3000L);
        l = 3000L;
        bool2 = false;
        bool1 = true;
        i = 0;
        break label753;
        this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getString(2131429113);
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 3000L);
        l = 3000L;
        bool2 = false;
        bool1 = true;
        i = 0;
        break label753;
        this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getString(2131429173);
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 3000L);
        l = 3000L;
        bool2 = false;
        bool1 = true;
        i = 0;
        break label753;
        this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getString(2131429125);
        i = 0;
        bool2 = false;
        bool1 = false;
        break label753;
        this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getString(2131429159);
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 3000L);
        l = 3000L;
        bool2 = false;
        bool1 = true;
        i = 0;
        break label753;
        i = 0;
        bool2 = false;
        bool1 = true;
        break label753;
        this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getString(2131429160);
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 3000L);
        l = 3000L;
        bool2 = false;
        bool1 = true;
        i = 0;
        break label753;
        this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getString(2131429158);
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 3000L);
        l = 3000L;
        bool2 = false;
        bool1 = true;
        i = 0;
        break label753;
        this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getString(2131429163);
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 3000L);
        l = 3000L;
        bool2 = false;
        bool1 = true;
        i = 0;
        break label753;
        this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getString(2131433989);
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 3000L);
        l = 3000L;
        bool2 = false;
        bool1 = true;
        i = 0;
        break label753;
        this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getString(2131429669);
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 3000L);
        l = 3000L;
        bool2 = false;
        bool1 = true;
        i = 0;
        break label753;
        this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getString(2131429164);
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 3000L);
        l = 3000L;
        bool2 = false;
        bool1 = true;
        i = 0;
        break label753;
        this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getString(2131429161);
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 3000L);
        l = 3000L;
        bool2 = false;
        bool1 = true;
        i = 0;
        break label753;
        this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getString(2131429162);
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 3000L);
        l = 3000L;
        bool2 = false;
        bool1 = true;
        i = 0;
        break label753;
        if (this.jdField_a_of_type_Boolean)
        {
          this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getString(2131429176);
          i = 0;
          bool2 = true;
          bool1 = false;
          break label753;
        }
        a();
        i = 0;
        bool2 = true;
        bool1 = false;
        break label753;
        if (this.jdField_a_of_type_Boolean)
        {
          this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getString(2131429222);
          i = 0;
          bool2 = false;
          bool1 = false;
          break label753;
        }
        a();
        i = 0;
        bool2 = false;
        bool1 = false;
        break label753;
        j = ((VideoController)localObject).c(str);
        if (((VideoController)localObject).a().i == 1011) {
          if (j < 45) {
            this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getString(2131429169);
          }
        }
        for (;;)
        {
          this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 3000L);
          l = 3000L;
          bool2 = false;
          bool1 = true;
          i = 0;
          break;
          if (!VcSystemInfo.f()) {
            this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getString(2131428808);
          } else if (!VcSystemInfo.b()) {
            this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getString(2131428807);
          } else if (Utils.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp()) == 1) {
            this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getString(2131428802);
          } else if (j < 16) {
            this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getString(2131429168);
          } else if ((i != 4) && (i != 2) && (i != 3)) {
            this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getString(2131429169);
          }
        }
        if ((i != 4) && (i != 2)) {}
        for (this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getString(2131429171);; this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getString(2131429172))
        {
          this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 3000L);
          l = 3000L;
          bool2 = false;
          bool1 = true;
          i = 0;
          break;
        }
        this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getString(2131429170);
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 3000L);
        l = 3000L;
        bool2 = false;
        bool1 = true;
        i = 0;
        break label753;
        this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getString(2131428803);
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 3000L);
        l = 3000L;
        bool2 = false;
        bool1 = true;
        i = 0;
        break label753;
        if (this.jdField_a_of_type_Boolean)
        {
          this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getString(2131429363);
          i = 0;
          bool2 = false;
          bool1 = false;
          break label753;
        }
        i = 1;
        bool2 = false;
        bool1 = true;
        break label753;
        if (this.jdField_a_of_type_Boolean)
        {
          this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getString(2131429364);
          i = 0;
          bool2 = false;
          bool1 = false;
          break label753;
        }
        i = 1;
        bool2 = false;
        bool1 = true;
        break label753;
        if (this.jdField_a_of_type_Boolean)
        {
          this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getString(2131429343);
          i = 0;
          bool2 = false;
          bool1 = false;
          break label753;
        }
        i = 1;
        bool2 = false;
        bool1 = true;
        break label753;
        if (this.jdField_a_of_type_Boolean)
        {
          this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getString(2131429383);
          i = 0;
          bool2 = false;
          bool1 = false;
          break label753;
        }
        i = 1;
        bool2 = false;
        bool1 = true;
        break label753;
        if (this.jdField_a_of_type_Boolean)
        {
          this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getString(2131429235);
          UITools.a(this.jdField_a_of_type_AndroidWidgetTextView, this.jdField_a_of_type_JavaLangString);
          i = 0;
          bool2 = false;
          bool1 = false;
          break label753;
        }
        a();
        i = 0;
        bool2 = false;
        bool1 = false;
        break label753;
        if (this.jdField_a_of_type_Boolean)
        {
          this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getString(2131429433);
          UITools.a(this.jdField_a_of_type_AndroidWidgetTextView, this.jdField_a_of_type_JavaLangString);
          this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 2000L);
          l = 2000L;
          i = 0;
          bool2 = false;
          bool1 = true;
          break label753;
        }
        a();
        i = 0;
        bool2 = false;
        bool1 = false;
        break label753;
        this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getString(2131428733);
        this.jdField_d_of_type_Int = this.jdField_b_of_type_Int;
        i = 0;
        bool2 = false;
        bool1 = false;
        break label753;
        this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getString(2131429132);
        this.jdField_d_of_type_Int = this.jdField_b_of_type_Int;
        i = 0;
        bool2 = true;
        bool1 = false;
        break label753;
        bool3 = false;
        break label804;
        label4571:
        if (this.jdField_a_of_type_AndroidWidgetLinearLayout != null) {
          this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        }
      }
      label4589:
      l = 3000L;
      bool2 = false;
      bool1 = false;
      i = 0;
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TipsManager", 2, "showApnTips type = " + paramInt1);
    }
    this.jdField_a_of_type_Int = paramInt2;
    if ((this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().a().p) || (!this.jdField_d_of_type_Boolean)) {
      c();
    }
    while ((paramInt1 != 38) || ((this.jdField_b_of_type_Int > paramInt1) && (this.jdField_b_of_type_Int < 100))) {
      return;
    }
    if ((this.jdField_b_of_type_Int > 0) && (this.jdField_b_of_type_Int <= 34))
    {
      this.jdField_b_of_type_Boolean = true;
      this.jdField_d_of_type_Int = this.jdField_b_of_type_Int;
    }
    a(paramInt1);
  }
  
  public void a(int paramInt, Drawable paramDrawable, String paramString)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("showIconTips, type[").append(this.jdField_b_of_type_Int).append("->").append(paramInt).append("], drawble[");
      if (paramDrawable == null) {
        break label206;
      }
      bool = true;
      localStringBuilder = localStringBuilder.append(bool).append("], strText[").append(paramString).append("], mIconTips[");
      if (this.jdField_b_of_type_AndroidWidgetImageView == null) {
        break label212;
      }
      bool = true;
      label85:
      localStringBuilder = localStringBuilder.append(bool).append("], mIconTipsText[");
      if (this.jdField_c_of_type_AndroidWidgetTextView == null) {
        break label218;
      }
    }
    label206:
    label212:
    label218:
    for (boolean bool = true;; bool = false)
    {
      QLog.w("TipsManager", 1, bool + "]");
      this.jdField_b_of_type_Int = paramInt;
      if (this.jdField_a_of_type_AndroidWidgetLinearLayout != null) {
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      }
      if ((this.jdField_b_of_type_AndroidWidgetImageView != null) && (paramDrawable != null))
      {
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
        this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(paramDrawable);
      }
      if ((this.jdField_c_of_type_AndroidWidgetTextView != null) && (paramString != null))
      {
        this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_c_of_type_AndroidWidgetTextView.setText(paramString);
      }
      return;
      bool = false;
      break;
      bool = false;
      break label85;
    }
  }
  
  public void a(int paramInt1, String paramString, long paramLong, int paramInt2)
  {
    if ((this.jdField_b_of_type_Int <= 100) && (paramInt1 < this.jdField_b_of_type_Int)) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      int i = this.jdField_b_of_type_Int;
      if (QLog.isColorLevel()) {
        QLog.w("TipsManager", 1, "showTips, type[" + i + "->" + paramInt1 + "], text[" + paramString + "], period[" + paramLong + "], flag[" + paramInt2 + "], mCurrentType[" + this.jdField_b_of_type_Int + "], ignore[" + bool1 + "], mCurrentState[" + this.jdField_a_of_type_Boolean + "]");
      }
      if (!bool1) {
        break;
      }
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    a();
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    b(paramInt1);
    this.jdField_b_of_type_Int = paramInt1;
    if ((this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().a().p) || (!this.jdField_d_of_type_Boolean))
    {
      c();
      return;
    }
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout != null) {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    }
    if (paramLong > 0L) {
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, paramLong);
    }
    label287:
    boolean bool2;
    if (paramInt2 == 0)
    {
      b(false, false);
      if (this.jdField_a_of_type_AndroidWidgetImageView == null) {
        break label412;
      }
      if (this.jdField_a_of_type_AndroidWidgetImageView.getVisibility() != 0) {
        break label406;
      }
      bool1 = true;
      if (this.jdField_a_of_type_AndroidWidgetProgressBar == null) {
        break label424;
      }
      if (this.jdField_a_of_type_AndroidWidgetProgressBar.getVisibility() != 0) {
        break label418;
      }
      bool2 = true;
      label307:
      if (jdField_a_of_type_ComTencentAvUtilsResidentTip.jdField_a_of_type_Int != 0) {
        break label430;
      }
    }
    label406:
    label412:
    label418:
    label424:
    label430:
    for (boolean bool3 = true;; bool3 = false)
    {
      a(true, paramInt1, paramLong, bool3, paramString, bool1, bool2);
      return;
      if (paramInt2 == 1)
      {
        b(true, false);
        break;
      }
      if (paramInt2 == 2)
      {
        b(false, true);
        break;
      }
      b(false, false);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("TipsManager", 2, "showTips-->flag value is wrong:" + paramInt2);
      break;
      bool1 = false;
      break label287;
      bool1 = false;
      break label287;
      bool2 = false;
      break label307;
      bool2 = false;
      break label307;
    }
  }
  
  public void a(int paramInt, String paramString, boolean paramBoolean)
  {
    this.jdField_b_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString;
    label57:
    label81:
    boolean bool;
    if ((paramInt == 106) || (paramInt == 103))
    {
      b(false, true);
      if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
        break label170;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      b(paramInt);
      if (this.jdField_a_of_type_AndroidWidgetImageView == null) {
        break label195;
      }
      if (this.jdField_a_of_type_AndroidWidgetImageView.getVisibility() != 0) {
        break label190;
      }
      paramBoolean = true;
      if (this.jdField_a_of_type_AndroidWidgetProgressBar == null) {
        break label206;
      }
      if (this.jdField_a_of_type_AndroidWidgetProgressBar.getVisibility() != 0) {
        break label200;
      }
      bool = true;
      label101:
      a(true, paramInt, 2147483647L, true, this.jdField_a_of_type_JavaLangString, paramBoolean, bool);
      if ((!this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().a().p) && (this.jdField_d_of_type_Boolean)) {
        break label212;
      }
      c();
    }
    label170:
    label190:
    label195:
    label200:
    label206:
    label212:
    while (this.jdField_a_of_type_AndroidWidgetLinearLayout == null)
    {
      return;
      if (paramInt == 107)
      {
        b(true, false);
        break;
      }
      b(false, false);
      break;
      this.jdField_a_of_type_AndroidWidgetTextView.setText(null);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      break label57;
      paramBoolean = false;
      break label81;
      paramBoolean = false;
      break label81;
      bool = false;
      break label101;
      bool = false;
      break label101;
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TipsManager", 2, "showStatusTipWithoutOrder-->TYPE=" + paramInt + " flag=" + paramBoolean);
    }
    this.jdField_a_of_type_Boolean = paramBoolean;
    a(paramInt);
  }
  
  public void a(boolean paramBoolean)
  {
    a(paramBoolean, false);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramBoolean1) || (paramBoolean2))
    {
      if (this.jdField_a_of_type_AndroidWidgetTextView != null)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getResources().getColor(2131493505));
        this.jdField_a_of_type_AndroidWidgetTextView.setShadowLayer(3.0F, 1.0F, 1.0F, 1342177280);
      }
      if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130840332);
      }
      if (this.jdField_a_of_type_AndroidWidgetProgressBar != null) {
        this.jdField_a_of_type_AndroidWidgetProgressBar.getIndeterminateDrawable().setColorFilter(-1, PorterDuff.Mode.MULTIPLY);
      }
    }
    do
    {
      return;
      if (this.jdField_a_of_type_AndroidWidgetTextView != null)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#566B7D"));
        this.jdField_a_of_type_AndroidWidgetTextView.setShadowLayer(0.0F, 0.0F, 0.0F, 5663613);
      }
      if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130840333);
      }
    } while (this.jdField_a_of_type_AndroidWidgetProgressBar == null);
    this.jdField_a_of_type_AndroidWidgetProgressBar.getIndeterminateDrawable().setColorFilter(-11113603, PorterDuff.Mode.MULTIPLY);
  }
  
  public boolean a()
  {
    boolean bool = true;
    if (QLog.isColorLevel())
    {
      QLog.d("TipsManager", 2, "removeTips, ResidentTip[" + jdField_a_of_type_ComTencentAvUtilsResidentTip + "]");
      SmallScreenUtils.a("removeTips");
    }
    if (jdField_a_of_type_ComTencentAvUtilsResidentTip.jdField_a_of_type_Int != 0)
    {
      int i = jdField_a_of_type_ComTencentAvUtilsResidentTip.jdField_a_of_type_Int;
      String str = jdField_a_of_type_ComTencentAvUtilsResidentTip.jdField_a_of_type_JavaLangString;
      if (jdField_a_of_type_ComTencentAvUtilsResidentTip.jdField_a_of_type_Int == 106) {}
      for (;;)
      {
        a(i, str, bool);
        return false;
        bool = false;
      }
    }
    if ((this.jdField_b_of_type_AndroidWidgetImageView != null) && (this.jdField_b_of_type_AndroidWidgetImageView.getVisibility() == 0) && (this.jdField_c_of_type_AndroidWidgetTextView != null) && (this.jdField_c_of_type_AndroidWidgetTextView.getVisibility() == 0)) {}
    for (;;)
    {
      b(false, false);
      if (this.jdField_a_of_type_AndroidWidgetTextView != null)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(null);
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      g();
      this.jdField_a_of_type_JavaLangString = null;
      this.jdField_b_of_type_Int = 0;
      a(false, 0, 0L, false, this.jdField_a_of_type_JavaLangString, false, false);
      return true;
      if (this.jdField_a_of_type_AndroidWidgetLinearLayout != null) {
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      }
    }
  }
  
  public boolean a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TipsManager", 2, "removeTips, Type[" + paramInt + "], mCurrentType[" + this.jdField_b_of_type_Int + "]");
    }
    if (this.jdField_b_of_type_Int == paramInt)
    {
      a();
      return true;
    }
    return false;
  }
  
  public void b()
  {
    this.jdField_d_of_type_Boolean = true;
    d();
  }
  
  void b(int paramInt)
  {
    if (paramInt == 104) {
      if ((this.jdField_b_of_type_AndroidWidgetTextView != null) && (this.jdField_b_of_type_AndroidWidgetTextView.getVisibility() != 0))
      {
        if (!this.jdField_c_of_type_Boolean) {
          break label39;
        }
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(4);
      }
    }
    label39:
    while ((this.jdField_b_of_type_AndroidWidgetTextView == null) || (this.jdField_b_of_type_AndroidWidgetTextView.getVisibility() != 0))
    {
      return;
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      return;
    }
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(4);
  }
  
  public void b(int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TipsManager", 2, "showStatusTips type = " + paramInt);
    }
    if ((this.jdField_b_of_type_Int >= 1000) && (paramInt < 1000)) {
      if (QLog.isColorLevel()) {
        QLog.d("TipsManager", 2, "showStatusTips foruce return type = " + paramInt + ", mCurrentType=" + this.jdField_b_of_type_Int);
      }
    }
    while ((this.jdField_b_of_type_Int == paramInt) && (this.jdField_a_of_type_Boolean == paramBoolean)) {
      return;
    }
    if ((this.jdField_b_of_type_Int == 29) && (this.jdField_a_of_type_Boolean) && (paramInt != 43) && (paramInt != 42) && (paramInt != 29) && (paramInt != 1001) && (paramInt != 1002))
    {
      this.jdField_b_of_type_Boolean = true;
      this.jdField_d_of_type_Int = this.jdField_b_of_type_Int;
    }
    if ((paramInt >= this.jdField_b_of_type_Int) || (this.jdField_b_of_type_Int >= 100))
    {
      this.jdField_a_of_type_Boolean = paramBoolean;
      a(paramInt);
      return;
    }
    if (((paramInt == 22) || (paramInt == 19)) && ((this.jdField_b_of_type_Int == 29) || (this.jdField_b_of_type_Int == 28) || (this.jdField_b_of_type_Int == 27)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("TipsManager", 2, "show");
      }
      this.jdField_a_of_type_Boolean = paramBoolean;
      this.jdField_b_of_type_Boolean = true;
      this.jdField_d_of_type_Int = this.jdField_b_of_type_Int;
      a(paramInt);
      return;
    }
    this.jdField_b_of_type_Boolean = paramBoolean;
    this.jdField_d_of_type_Int = paramInt;
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
    if (QLog.isColorLevel()) {
      QLog.d("TipsManager", 2, "setFullScreenFlag: " + this.jdField_c_of_type_Boolean);
    }
    VideoController localVideoController = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
    if (((this.jdField_b_of_type_Int != 0) || (!localVideoController.a().jdField_d_of_type_Boolean)) || (((!paramBoolean) || (this.jdField_b_of_type_Int != 27)) || (((!paramBoolean) || (this.jdField_b_of_type_Int != 29)) || ((paramBoolean) && (this.jdField_b_of_type_Int == 14))))) {
      a();
    }
    if (this.jdField_b_of_type_Int == 104)
    {
      if (paramBoolean) {
        g();
      }
    }
    else {
      return;
    }
    b(this.jdField_b_of_type_Int);
  }
  
  void b(boolean paramBoolean1, boolean paramBoolean2)
  {
    int j = 0;
    Object localObject;
    if (this.jdField_a_of_type_AndroidWidgetImageView != null)
    {
      localObject = this.jdField_a_of_type_AndroidWidgetImageView;
      if (paramBoolean1)
      {
        i = 0;
        ((ImageView)localObject).setVisibility(i);
      }
    }
    else if (this.jdField_a_of_type_AndroidWidgetProgressBar != null)
    {
      localObject = this.jdField_a_of_type_AndroidWidgetProgressBar;
      if (!paramBoolean2) {
        break label61;
      }
    }
    label61:
    for (int i = j;; i = 8)
    {
      ((ProgressBar)localObject).setVisibility(i);
      return;
      i = 8;
      break;
    }
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      SmallScreenUtils.a("hideTips");
    }
    g();
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(4);
    a(false, this.jdField_b_of_type_Int, 0L, false, this.jdField_a_of_type_JavaLangString, false, false);
  }
  
  public void d()
  {
    if (this.jdField_d_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      if ((this.jdField_b_of_type_Int == 71) && (this.jdField_b_of_type_AndroidWidgetTextView != null) && (this.jdField_b_of_type_AndroidWidgetTextView.getVisibility() != 0)) {
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      }
    }
  }
  
  public void e()
  {
    if (QLog.isColorLevel()) {
      QLog.w("TipsManager", 1, "recoverTips, mPreviosState[" + this.jdField_b_of_type_Boolean + "], mPreviosType[" + this.jdField_d_of_type_Int + "]");
    }
    if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = true;
      a(this.jdField_d_of_type_Int);
      this.jdField_b_of_type_Boolean = false;
      return;
    }
    a();
  }
  
  public void f()
  {
    if (QLog.isColorLevel()) {
      SmallScreenUtils.a("removeIconTips");
    }
    if (this.jdField_b_of_type_AndroidWidgetImageView != null)
    {
      this.jdField_b_of_type_AndroidWidgetImageView.setImageBitmap(null);
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    if (this.jdField_c_of_type_AndroidWidgetTextView != null)
    {
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_c_of_type_AndroidWidgetTextView.setText(null);
    }
  }
  
  void g()
  {
    if ((this.jdField_b_of_type_AndroidWidgetTextView != null) && (this.jdField_b_of_type_AndroidWidgetTextView.getVisibility() == 0)) {
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(4);
    }
  }
  
  void h()
  {
    g();
    if (QLog.isColorLevel()) {
      QLog.d("TipsManager", 2, "mApnType = " + this.jdField_a_of_type_Int);
    }
    int i = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().a().a.jdField_a_of_type_Int;
    switch (this.jdField_a_of_type_Int)
    {
    default: 
      return;
    case 0: 
      if (this.f)
      {
        this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getString(2131429408);
        b(false, true);
      }
      for (;;)
      {
        this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
        return;
        if ((i == 3) || (i == 1))
        {
          this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getString(2131428860);
          b(false, false);
        }
        else
        {
          this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getString(2131428859);
          b(false, true);
        }
      }
    case 2: 
      if (this.f)
      {
        this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getString(2131429406);
        this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, null, null);
        b(false, true);
      }
      for (;;)
      {
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 3000L);
        return;
        if ((i == 3) || (i == 1))
        {
          this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getString(2131428862);
          b(false, false);
        }
        else
        {
          this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getString(2131428858);
          this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, null, null);
          b(false, true);
        }
      }
    }
    if (this.f)
    {
      this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getString(2131429407);
      this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, null, null);
      b(false, true);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 3000L);
      return;
      if ((i == 3) || (i == 1))
      {
        this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getString(2131428861);
        b(false, false);
      }
      else
      {
        this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getString(2131428857);
        this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, null, null);
        b(false, true);
      }
    }
  }
  
  public void i()
  {
    b(false, false);
    this.jdField_a_of_type_AndroidWidgetTextView.setText("");
    int i = this.jdField_b_of_type_Int;
    if (jdField_a_of_type_ComTencentAvUtilsResidentTip.jdField_a_of_type_Int == 0) {}
    for (boolean bool = true;; bool = false)
    {
      a(false, i, 0L, bool, this.jdField_a_of_type_JavaLangString, false, false);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.utils.TipsManager
 * JD-Core Version:    0.7.0.1
 */