package com.tencent.mobileqq.apollo.store;

import aepi;
import akpl;
import akrb;
import aldl;
import aldp;
import aldq;
import aldr;
import alds;
import aldt;
import aldv;
import alen;
import alep;
import algj;
import aliu;
import alud;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.annotation.TargetApi;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import atxi;
import atxn;
import bdgk;
import begg;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.apollo.ApolloRender;
import com.tencent.mobileqq.apollo.ApolloTextureView;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.SystemBarCompact;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

public class ApolloGuestsStateActivity
  extends BaseActivity
  implements alep, View.OnClickListener, atxi, begg
{
  public float a;
  int jdField_a_of_type_Int = 0;
  public akrb a;
  private aldl jdField_a_of_type_Aldl;
  private ObjectAnimator jdField_a_of_type_AndroidAnimationObjectAnimator;
  Handler jdField_a_of_type_AndroidOsHandler;
  private SparseArray<alen> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  View jdField_a_of_type_AndroidViewView;
  public Button a;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  public RelativeLayout a;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  public ApolloTextureView a;
  String jdField_a_of_type_JavaLangString;
  List<View> jdField_a_of_type_JavaUtilList = new ArrayList();
  boolean jdField_a_of_type_Boolean = false;
  float jdField_b_of_type_Float = 0.0F;
  public int b;
  private ObjectAnimator jdField_b_of_type_AndroidAnimationObjectAnimator;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  String jdField_b_of_type_JavaLangString;
  boolean jdField_b_of_type_Boolean = false;
  public float c;
  int jdField_c_of_type_Int;
  private RelativeLayout jdField_c_of_type_AndroidWidgetRelativeLayout;
  boolean jdField_c_of_type_Boolean = false;
  int jdField_d_of_type_Int;
  boolean jdField_d_of_type_Boolean;
  
  public ApolloGuestsStateActivity()
  {
    this.jdField_a_of_type_Float = 0.0F;
    this.jdField_b_of_type_Int = 0;
    this.jdField_c_of_type_Float = 0.0F;
    this.jdField_a_of_type_Akrb = new aldr(this);
  }
  
  private Drawable a(int paramInt)
  {
    int j = 2130838507;
    int i;
    if (paramInt == 1) {
      i = 2130838506;
    }
    for (;;)
    {
      return super.getResources().getDrawable(i);
      i = j;
      if (paramInt == 2) {
        i = j;
      }
    }
  }
  
  private void c(List<alen> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return;
    }
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    int i;
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0))
    {
      i = 0;
      while (i < this.jdField_a_of_type_JavaUtilList.size())
      {
        this.jdField_b_of_type_AndroidWidgetRelativeLayout.removeView((View)this.jdField_a_of_type_JavaUtilList.get(i));
        i += 1;
      }
      this.jdField_a_of_type_JavaUtilList.clear();
    }
    DisplayMetrics localDisplayMetrics = super.getResources().getDisplayMetrics();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      alen localalen = (alen)paramList.next();
      if (!TextUtils.isEmpty(localalen.jdField_a_of_type_JavaLangString))
      {
        this.jdField_a_of_type_AndroidUtilSparseArray.put(localalen.jdField_a_of_type_Int, localalen);
        TextView localTextView = new TextView(this);
        localTextView.setId(localalen.jdField_a_of_type_Int);
        localTextView.setText(localalen.jdField_a_of_type_JavaLangString);
        localTextView.setTextSize(10.0F);
        localTextView.setTextColor(-1);
        localTextView.setGravity(17);
        label228:
        RelativeLayout.LayoutParams localLayoutParams;
        int j;
        if (localalen.jdField_a_of_type_Boolean)
        {
          localTextView.setTag("isRole");
          localTextView.setOnClickListener(this);
          localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
          localLayoutParams.addRule(15, -1);
          i = 0;
          Drawable localDrawable = a(localalen.g);
          if (localalen.g != 0)
          {
            localDrawable.setBounds(0, 0, localDrawable.getMinimumWidth(), localDrawable.getMinimumHeight());
            localTextView.setCompoundDrawables(localDrawable, null, null, null);
          }
          if (localalen.jdField_b_of_type_Int != 0) {
            break label548;
          }
          ApolloUtil.a(localTextView, 2130838438);
          localTextView.setPadding((int)(5.0F * localDisplayMetrics.density), 0, (int)(19.0F * localDisplayMetrics.density), 0);
          localTextView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
          j = localTextView.getMeasuredWidth();
          i = localTextView.getMeasuredHeight();
          if (QLog.isColorLevel()) {
            QLog.d("ApolloGuestsStateActivity", 2, "textview measure wiidth=" + localTextView.getMeasuredWidth());
          }
          localArrayList2.add(localTextView);
          localLayoutParams.addRule(9, -1);
          localLayoutParams.leftMargin = Math.max(localalen.jdField_c_of_type_Int - j, 0);
        }
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ApolloGuestsStateActivity", 2, "tag textview height = " + i);
          }
          localLayoutParams.addRule(12, -1);
          localLayoutParams.bottomMargin = Math.max(localalen.jdField_d_of_type_Int - i / 2, 0);
          if (this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView == null) {
            break;
          }
          this.jdField_b_of_type_AndroidWidgetRelativeLayout.addView(localTextView, localLayoutParams);
          localTextView.setVisibility(0);
          this.jdField_a_of_type_JavaUtilList.add(localTextView);
          break;
          localTextView.setTag("isDress");
          break label228;
          label548:
          if (localalen.jdField_b_of_type_Int == 1)
          {
            ApolloUtil.a(localTextView, 2130838439);
            localTextView.setPadding((int)(19.0F * localDisplayMetrics.density), 0, (int)(5.0F * localDisplayMetrics.density), 0);
            localTextView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
            j = localTextView.getMeasuredWidth();
            i = localTextView.getMeasuredHeight();
            localArrayList1.add(localTextView);
            localLayoutParams.addRule(11, -1);
            localLayoutParams.rightMargin = Math.max(localalen.jdField_c_of_type_Int - j, 0);
          }
        }
      }
    }
    a(localArrayList1);
    a(localArrayList2);
  }
  
  private void f()
  {
    PropertyValuesHolder localPropertyValuesHolder1 = PropertyValuesHolder.ofFloat("scaleX", new float[] { 1.0F, 1.8F, 1.2F });
    PropertyValuesHolder localPropertyValuesHolder2 = PropertyValuesHolder.ofFloat("scaleY", new float[] { 1.0F, 1.8F, 1.2F });
    this.jdField_a_of_type_AndroidAnimationObjectAnimator = ObjectAnimator.ofPropertyValuesHolder(this.jdField_a_of_type_AndroidWidgetButton, new PropertyValuesHolder[] { localPropertyValuesHolder1, localPropertyValuesHolder2 });
    this.jdField_a_of_type_AndroidAnimationObjectAnimator.setDuration(500L);
    this.jdField_a_of_type_AndroidAnimationObjectAnimator.addListener(new aldq(this));
    this.jdField_a_of_type_AndroidAnimationObjectAnimator.start();
  }
  
  @TargetApi(11)
  public void a()
  {
    b();
  }
  
  void a(int paramInt)
  {
    super.runOnUiThread(new ApolloGuestsStateActivity.2(this, paramInt));
  }
  
  void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_AndroidOsHandler != null)
    {
      Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(0);
      localMessage.arg1 = paramInt1;
      localMessage.arg2 = paramInt2;
      localMessage.sendToTarget();
    }
  }
  
  public void a(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      do
      {
        int i;
        int j;
        do
        {
          do
          {
            return;
            this.jdField_a_of_type_AndroidWidgetTextView.setText("" + paramMessage.arg1);
          } while (paramMessage.arg1 >= paramMessage.arg2);
          i = paramMessage.arg1;
          j = paramMessage.arg2;
          String str = String.valueOf(j);
          paramMessage = str;
          if (j == 99999) {
            paramMessage = str + "+";
          }
          this.jdField_a_of_type_AndroidWidgetTextView.setText(paramMessage);
          j -= i;
        } while ((j <= 0) || (i == 0));
        this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131362620));
        this.jdField_b_of_type_AndroidWidgetTextView.setText("+" + j);
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        return;
        c((List)paramMessage.obj);
      } while (!QLog.isColorLevel());
      QLog.d("ApolloGuestsStateActivity", 2, "dress tag list=" + ((List)paramMessage.obj).toString());
      return;
      paramMessage = (Bitmap)paramMessage.obj;
    } while (paramMessage == null);
    paramMessage = new BitmapDrawable(paramMessage);
    this.jdField_a_of_type_AndroidViewView.setBackgroundDrawable(paramMessage);
    BaseApplicationImpl.sImageCache.put(this.jdField_a_of_type_Int + "apollo_cmshow_background", paramMessage);
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    this.jdField_c_of_type_Int = paramInt1;
    if (this.jdField_a_of_type_Boolean) {
      a(this.jdField_c_of_type_Int, paramInt2);
    }
    for (;;)
    {
      this.jdField_c_of_type_Int = paramInt2;
      return;
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
    }
  }
  
  public void a(List<TextView> paramList)
  {
    if ((paramList == null) || (paramList.size() <= 0)) {}
    for (;;)
    {
      return;
      int i = 0;
      while (i < paramList.size() - 1)
      {
        TextView localTextView1 = (TextView)paramList.get(i);
        TextView localTextView2 = (TextView)paramList.get(i + 1);
        RelativeLayout.LayoutParams localLayoutParams1 = (RelativeLayout.LayoutParams)localTextView1.getLayoutParams();
        RelativeLayout.LayoutParams localLayoutParams2 = (RelativeLayout.LayoutParams)localTextView2.getLayoutParams();
        if (localLayoutParams1.bottomMargin - localLayoutParams2.bottomMargin < localTextView1.getMeasuredHeight())
        {
          int j = localTextView1.getMeasuredHeight();
          localLayoutParams2.bottomMargin -= j;
          localTextView2.requestLayout();
          if (QLog.isColorLevel()) {
            QLog.d("ApolloGuestsStateActivity", 2, "tag location modify move distence=" + j);
          }
        }
        i += 1;
      }
    }
  }
  
  public void a(int[] paramArrayOfInt, int paramInt)
  {
    float f = (float)Math.max(bdgk.h(), bdgk.g()) / 3.25F / 368.0F;
    if (this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView == null) {}
    akpl localakpl;
    do
    {
      return;
      localakpl = this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.getRenderImpl();
    } while (localakpl == null);
    localakpl.a(1, null, paramInt, f, this.jdField_a_of_type_Float, 0.0F);
    if (paramInt == 0) {
      localakpl.a(1, null, aldv.a(paramInt), null);
    }
    for (;;)
    {
      this.jdField_a_of_type_Int = paramInt;
      if ((this.jdField_b_of_type_Boolean) || (this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.getRender() == null)) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.getRender().setRenderCallback(this.jdField_a_of_type_Akrb);
      paramArrayOfInt = algj.a(4, -1, this.jdField_a_of_type_Int, true);
      localakpl.a(1, null, 5, 0, paramArrayOfInt[0], paramArrayOfInt[1]);
      this.jdField_b_of_type_Boolean = true;
      return;
      if ((paramInt > 0) && (paramArrayOfInt != null)) {
        localakpl.a(1, null, paramArrayOfInt, this.jdField_a_of_type_Aldl);
      }
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidViewView = super.getLayoutInflater().inflate(2131558645, null, false);
    this.jdField_c_of_type_AndroidWidgetRelativeLayout = new RelativeLayout(this);
    this.jdField_c_of_type_AndroidWidgetRelativeLayout.setBackgroundColor(super.getResources().getColor(2131166819));
    long l1 = Math.max(bdgk.h(), bdgk.g());
    long l2 = Math.min(bdgk.h(), bdgk.g());
    float f1 = (float)(l1 / 1.52D);
    float f2 = (float)(l2 / 1.27D);
    this.jdField_b_of_type_Float = f1;
    Object localObject = new RelativeLayout.LayoutParams((int)f2, (int)f1);
    ((RelativeLayout.LayoutParams)localObject).addRule(13);
    this.jdField_c_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_AndroidViewView, (ViewGroup.LayoutParams)localObject);
    localObject = new ImageView(this);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams((int)(l1 / 16.68D + 0.5D), (int)(l1 / 16.68D + 0.5D));
    localLayoutParams.addRule(12);
    localLayoutParams.addRule(14);
    localLayoutParams.bottomMargin = ((int)(l1 / 19.899999999999999D + 0.5D));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)localObject);
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
    ((ImageView)localObject).setBackgroundResource(2130838343);
    this.jdField_c_of_type_AndroidWidgetRelativeLayout.addView((View)localObject, localLayoutParams);
    localObject = AnimationUtils.loadAnimation(this, 2130772008);
    this.jdField_a_of_type_AndroidViewView.startAnimation((Animation)localObject);
    localObject = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = ((int)(this.jdField_b_of_type_Float + 0.5F));
    ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = ((int)(f2 + 0.5F));
    localObject = aldt.a(true, aliu.k + "apollo_aio_bg_v3.png", (URLDrawable.URLDrawableOptions)localObject, "https://cmshow.gtimg.cn/client/img/apollo_aio_bg_v3.png");
    this.jdField_a_of_type_AndroidViewView.setBackgroundDrawable((Drawable)localObject);
    this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView = new ApolloTextureView(this, null);
    localObject = new RelativeLayout.LayoutParams(-1, -1);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131367373));
    ((RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetRelativeLayout.getLayoutParams()).bottomMargin = ((int)((float)l1 / 5.03F + 0.5F));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.requestLayout();
    ((RelativeLayout.LayoutParams)localObject).addRule(14);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView, (ViewGroup.LayoutParams)localObject);
    this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.init(new alds(this));
    c();
  }
  
  public void b(int paramInt)
  {
    a(paramInt);
  }
  
  public void b(List<alen> paramList)
  {
    if ((this.jdField_a_of_type_AndroidOsHandler != null) && (paramList != null))
    {
      Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(1);
      localMessage.obj = paramList;
      localMessage.sendToTarget();
    }
  }
  
  public void c()
  {
    Object localObject = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131371139);
    this.jdField_b_of_type_JavaLangString = super.getIntent().getStringExtra("extra_guest_nick");
    this.jdField_a_of_type_JavaLangString = super.getIntent().getStringExtra("extra_guest_uin");
    this.jdField_d_of_type_Int = super.getIntent().getIntExtra("extra_guest_from", 0);
    if (QLog.isColorLevel()) {
      QLog.d("ApolloGuestsStateActivity", 2, "nickname = " + this.jdField_b_of_type_JavaLangString + " uin=" + this.jdField_a_of_type_JavaLangString);
    }
    if (this.jdField_a_of_type_JavaLangString.equals(super.getAppInterface().getCurrentAccountUin())) {
      this.jdField_a_of_type_Boolean = true;
    }
    QQAppInterface localQQAppInterface = this.app;
    int j = this.jdField_d_of_type_Int;
    int i;
    if (this.jdField_a_of_type_Boolean)
    {
      i = 0;
      VipUtils.a(localQQAppInterface, "cmshow", "Apollo", "yy_dresscheck", j, i, new String[0]);
      if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
        break label349;
      }
      ((TextView)localObject).setText(this.jdField_b_of_type_JavaLangString);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131362601));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131377934));
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131362737));
      d();
      localObject = Calendar.getInstance();
      if ((BaseApplicationImpl.getApplication().getSharedPreferences("cmshow_zan", 0).getBoolean(super.getAppInterface().getCurrentAccountUin() + "apollo_today_has_vote" + this.jdField_a_of_type_JavaLangString + ((Calendar)localObject).get(1) + ((Calendar)localObject).get(2) + ((Calendar)localObject).get(5), false)) && (Build.VERSION.SDK_INT >= 11))
      {
        this.jdField_d_of_type_Boolean = true;
        this.jdField_a_of_type_AndroidWidgetButton.setAlpha(0.5F);
      }
      return;
      i = 1;
      break;
      label349:
      ((TextView)localObject).setText(" ");
    }
  }
  
  @TargetApi(11)
  public void d()
  {
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131362619));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetButton.setOnTouchListener(new aldp(this));
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    switch (paramInt1)
    {
    }
    do
    {
      return;
    } while (paramInt2 != -1);
    Intent localIntent = aepi.a(new Intent(this, SplashActivity.class), null);
    localIntent.putExtras(new Bundle(paramIntent.getExtras()));
    super.startActivity(localIntent);
    super.finish();
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    getWindow().addFlags(16777216);
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_AndroidOsHandler = atxn.a(this);
    this.jdField_c_of_type_Float = super.getResources().getDisplayMetrics().density;
    a();
    this.jdField_a_of_type_Aldl = new aldl(this, (QQAppInterface)super.getAppInterface(), this, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView);
    this.jdField_a_of_type_Aldl.a();
    super.setContentView(this.jdField_c_of_type_AndroidWidgetRelativeLayout);
    super.setImmersiveStatus();
    if (this.mSystemBarComp != null)
    {
      this.mSystemBarComp.init();
      this.mSystemBarComp.setStatusColor(0);
      this.mSystemBarComp.setStatusBarColor(0);
    }
    return false;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    if ((this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.getRenderImpl() != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.getRenderImpl().a();
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.getRenderImpl().c();
    }
    if (this.jdField_a_of_type_Aldl != null)
    {
      this.jdField_a_of_type_Aldl.e();
      this.jdField_a_of_type_Aldl = null;
    }
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList = null;
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    }
    this.jdField_a_of_type_AndroidOsHandler = null;
    this.jdField_a_of_type_Akrb = null;
    if (this.jdField_a_of_type_AndroidAnimationObjectAnimator != null)
    {
      this.jdField_a_of_type_AndroidAnimationObjectAnimator.cancel();
      this.jdField_a_of_type_AndroidAnimationObjectAnimator = null;
    }
    if (this.jdField_b_of_type_AndroidAnimationObjectAnimator != null)
    {
      this.jdField_b_of_type_AndroidAnimationObjectAnimator.cancel();
      this.jdField_b_of_type_AndroidAnimationObjectAnimator = null;
    }
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.getRenderImpl() != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.getRenderImpl().a();
    }
  }
  
  @TargetApi(14)
  public boolean onBackEvent()
  {
    if (!isFinishing())
    {
      finish();
      overridePendingTransition(0, 0);
    }
    return true;
  }
  
  @TargetApi(14)
  public void onClick(View paramView)
  {
    if (paramView == this.jdField_b_of_type_AndroidWidgetImageView)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.getRenderImpl() != null))
      {
        this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.getRenderImpl().a();
        this.jdField_c_of_type_Boolean = true;
        this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.setVisibility(8);
      }
      if (!isFinishing())
      {
        finish();
        overridePendingTransition(0, 0);
      }
    }
    do
    {
      return;
      if (paramView.getId() != 2131362619) {
        break label245;
      }
      if (this.jdField_a_of_type_Boolean)
      {
        if (this.jdField_b_of_type_AndroidWidgetTextView != null) {
          this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        }
        VipUtils.a(this.app, "cmshow", "Apollo", "y_dresscheckflower", this.jdField_d_of_type_Int, 0, new String[0]);
        paramView = new Intent(this, QQBrowserActivity.class);
        paramView.putExtra("url", "https://cmshow.qq.com/apollo/html/details.html?_bid=2282&_wv=3&seq=-1");
        startActivity(paramView);
        return;
      }
      if (!this.jdField_d_of_type_Boolean) {
        break;
      }
      QQToast.a(this, 1, alud.a(2131700773), 0).b(super.getResources().getDimensionPixelSize(2131298914));
    } while (!QLog.isColorLevel());
    QLog.d("ApolloGuestsStateActivity", 2, "today is flowered");
    return;
    VipUtils.a(this.app, "cmshow", "Apollo", "y_dresscheckflower", this.jdField_d_of_type_Int, 1, new String[0]);
    this.jdField_d_of_type_Boolean = true;
    f();
    this.jdField_a_of_type_Aldl.b();
    return;
    label245:
    int i = paramView.getId();
    Object localObject = (alen)this.jdField_a_of_type_AndroidUtilSparseArray.get(i);
    VipUtils.a(this.app, "cmshow", "Apollo", "dresscheckclick", this.jdField_d_of_type_Int, 0, new String[] { "" + i });
    if ("isRole".equals((String)paramView.getTag())) {}
    for (paramView = "&view=role," + this.jdField_a_of_type_Int;; paramView = "&dressId=" + i + "&roleId=" + this.jdField_a_of_type_Int)
    {
      localObject = new Intent();
      ((Intent)localObject).putExtra("extra_key_url_append", paramView);
      ApolloUtil.a(this, (Intent)localObject, "mycmshow", aliu.ah, null);
      return;
      if ((((alen)localObject).i > 0) && (((alen)localObject).j == 1))
      {
        ApolloUtil.a(this, "&id=" + ((alen)localObject).i + "&type=" + 4, "aio");
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.store.ApolloGuestsStateActivity
 * JD-Core Version:    0.7.0.1
 */