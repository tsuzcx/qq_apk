package com.tencent.biz.publicAccountImageCollection;

import Override;
import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.text.ClipboardManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import anvx;
import aupt;
import bdnr;
import bdnv;
import bdoe;
import bkzi;
import bkzz;
import bmad;
import com.tencent.biz.widgets.ElasticHorScrView;
import com.tencent.common.app.AppInterface;
import com.tencent.image.RegionDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.open.base.MD5Utils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.util.VersionUtils;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.MobileQQ;
import mus;
import ojn;
import ojo;
import ojr;
import ojs;
import ojt;
import olh;
import tlv;
import vti;
import vtj;
import vub;
import vuc;
import vud;
import vue;
import vuf;
import vug;
import vuh;
import vui;
import vuj;
import vuq;
import vus;
import vuu;
import vuv;
import znl;

public class PublicAccountImageCollectionMainActivity
  extends BaseActivity
  implements View.OnClickListener, AdapterView.OnItemClickListener
{
  public static boolean a;
  public static int b;
  public static int c;
  public static int d;
  public float a;
  public int a;
  private long jdField_a_of_type_Long;
  private AnimatorSet jdField_a_of_type_AndroidAnimationAnimatorSet;
  public Context a;
  public Bitmap a;
  public Matrix a;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  public Handler a;
  public ScaleGestureDetector a;
  public ViewGroup a;
  private TranslateAnimation jdField_a_of_type_AndroidViewAnimationTranslateAnimation;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  public LinearLayout a;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  public bkzi a;
  private PublicAccountImageCollectionListView jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageCollectionListView;
  private PublicAccountImageView jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageView;
  ElasticHorScrView jdField_a_of_type_ComTencentBizWidgetsElasticHorScrView;
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  public String a;
  private ArrayList<vuv> jdField_a_of_type_JavaUtilArrayList;
  private ojn jdField_a_of_type_Ojn;
  private ojo jdField_a_of_type_Ojo;
  private vtj jdField_a_of_type_Vtj;
  private vus jdField_a_of_type_Vus;
  public float[] a;
  float jdField_b_of_type_Float;
  public Matrix b;
  private Handler jdField_b_of_type_AndroidOsHandler;
  public ViewGroup b;
  private TranslateAnimation jdField_b_of_type_AndroidViewAnimationTranslateAnimation;
  ImageView jdField_b_of_type_AndroidWidgetImageView;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  ElasticHorScrView jdField_b_of_type_ComTencentBizWidgetsElasticHorScrView;
  public String b;
  private boolean jdField_b_of_type_Boolean;
  public float[] b;
  public Matrix c;
  ImageView jdField_c_of_type_AndroidWidgetImageView;
  TextView jdField_c_of_type_AndroidWidgetTextView;
  public String c;
  private boolean jdField_c_of_type_Boolean;
  ImageView jdField_d_of_type_AndroidWidgetImageView;
  private String jdField_d_of_type_JavaLangString = "";
  private boolean jdField_d_of_type_Boolean;
  int jdField_e_of_type_Int;
  ImageView jdField_e_of_type_AndroidWidgetImageView;
  private String jdField_e_of_type_JavaLangString = "";
  private boolean jdField_e_of_type_Boolean;
  int jdField_f_of_type_Int;
  ImageView jdField_f_of_type_AndroidWidgetImageView;
  private String jdField_f_of_type_JavaLangString;
  private boolean jdField_f_of_type_Boolean;
  int jdField_g_of_type_Int;
  private String jdField_g_of_type_JavaLangString = "";
  private boolean jdField_g_of_type_Boolean;
  private int jdField_h_of_type_Int;
  private String jdField_h_of_type_JavaLangString = "";
  private int jdField_i_of_type_Int;
  private String jdField_i_of_type_JavaLangString = "";
  private int j;
  private int k;
  private int l;
  private int m;
  
  static
  {
    jdField_b_of_type_Int = 2;
    jdField_c_of_type_Int = 3;
    jdField_d_of_type_Int = 4;
  }
  
  public PublicAccountImageCollectionMainActivity()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_a_of_type_AndroidGraphicsMatrix = new Matrix();
    this.jdField_b_of_type_AndroidGraphicsMatrix = new Matrix();
    this.jdField_a_of_type_ArrayOfFloat = new float[9];
    this.jdField_b_of_type_ArrayOfFloat = new float[9];
    this.jdField_a_of_type_Int = 1;
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_a_of_type_AndroidOsHandler = new vue(this);
  }
  
  private int a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 16;
    case 0: 
      return jdField_b_of_type_Int;
    case 1: 
      return jdField_c_of_type_Int;
    }
    return jdField_d_of_type_Int;
  }
  
  @TargetApi(9)
  private View a(int paramInt)
  {
    View localView = super.getLayoutInflater().inflate(2131559189, null);
    this.jdField_a_of_type_ComTencentBizWidgetsElasticHorScrView = ((ElasticHorScrView)localView.findViewById(2131377144));
    this.jdField_b_of_type_ComTencentBizWidgetsElasticHorScrView = ((ElasticHorScrView)localView.findViewById(2131377145));
    if (paramInt == 1) {
      this.jdField_b_of_type_ComTencentBizWidgetsElasticHorScrView.setVisibility(8);
    }
    GridView localGridView2 = (GridView)localView.findViewById(2131367851);
    GridView localGridView1 = (GridView)localView.findViewById(2131367852);
    Object localObject1 = (TextView)localView.findViewById(2131361985);
    Object localObject2 = (LinearLayout.LayoutParams)((TextView)localObject1).getLayoutParams();
    ((LinearLayout.LayoutParams)localObject2).topMargin = ((int)(13.0F * this.jdField_b_of_type_Float));
    ((TextView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
    ((TextView)localObject1).setText(2131690697);
    ((TextView)localObject1).setOnClickListener(new vuc(this));
    if (Build.VERSION.SDK_INT >= 9)
    {
      this.jdField_a_of_type_ComTencentBizWidgetsElasticHorScrView.setOverScrollMode(2);
      this.jdField_b_of_type_ComTencentBizWidgetsElasticHorScrView.setOverScrollMode(2);
    }
    localGridView1.setSmoothScrollbarEnabled(false);
    localObject2 = a();
    if (localObject2.length > 0)
    {
      localObject1 = localObject2[0];
      if (localObject2.length <= 1) {
        break label418;
      }
    }
    label418:
    for (localObject2 = localObject2[1];; localObject2 = new ArrayList(0))
    {
      paramInt = ((List)localObject1).size();
      localGridView2.setNumColumns(paramInt);
      ViewGroup.LayoutParams localLayoutParams = localGridView2.getLayoutParams();
      localLayoutParams.width = ((int)(((paramInt - 1) * 10 + paramInt * 75 + 3) * this.jdField_b_of_type_Float));
      localGridView2.setLayoutParams(localLayoutParams);
      localGridView2.setAdapter(new ojs(this, 0, (List)localObject1));
      localGridView2.setSelector(new ColorDrawable(0));
      localGridView2.setOnItemClickListener(this);
      paramInt = localLayoutParams.width;
      this.jdField_f_of_type_Int = paramInt;
      int n = ((List)localObject2).size();
      localObject1 = localGridView1.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject1).width = ((int)((n * 75 + (n - 1) * 10 + 3) * this.jdField_b_of_type_Float));
      localGridView1.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      localGridView1.setNumColumns(n);
      localGridView1.setAdapter(new ojs(this, 0, (List)localObject2));
      localGridView1.setSelector(new ColorDrawable(0));
      localGridView1.setOnItemClickListener(this);
      n = ((ViewGroup.LayoutParams)localObject1).width;
      this.jdField_e_of_type_Int = n;
      localView.post(new PublicAccountImageCollectionMainActivity.12(this, paramInt, n));
      return localView;
      localObject1 = new ArrayList(0);
      break;
    }
  }
  
  @TargetApi(11)
  private void a(View paramView1, View paramView2, long paramLong1, long paramLong2)
  {
    if (Build.VERSION.SDK_INT >= 11)
    {
      paramView1.setAlpha(0.0F);
      paramView1.setVisibility(0);
      paramView2.setAlpha(0.0F);
      paramView2.setVisibility(0);
      paramView1 = ObjectAnimator.ofFloat(paramView1, "alpha", new float[] { 0.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F });
      paramView2 = ObjectAnimator.ofFloat(paramView2, "alpha", new float[] { 0.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F });
      paramView1.setDuration(1800L);
      paramView1.setRepeatCount(-1);
      paramView1.setRepeatMode(1);
      paramView1.setStartDelay(paramLong1);
      paramView2.setDuration(1800L);
      paramView2.setRepeatCount(-1);
      paramView2.setRepeatMode(1);
      paramView2.setStartDelay(paramLong2);
      if (this.jdField_a_of_type_AndroidAnimationAnimatorSet == null) {
        this.jdField_a_of_type_AndroidAnimationAnimatorSet = new AnimatorSet();
      }
      this.jdField_a_of_type_AndroidAnimationAnimatorSet.playTogether(new Animator[] { paramView1, paramView2 });
      this.jdField_a_of_type_AndroidAnimationAnimatorSet.start();
      return;
    }
    paramView1.setVisibility(0);
    paramView2.setVisibility(0);
  }
  
  private void a(String paramString)
  {
    if ((this.jdField_c_of_type_AndroidWidgetTextView == null) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    this.jdField_c_of_type_AndroidWidgetTextView.setText(paramString);
  }
  
  private void a(boolean paramBoolean, int paramInt)
  {
    ReportDialog localReportDialog = new ReportDialog(this, 2131755574);
    localReportDialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
    localReportDialog.setContentView(2131559655);
    if (!paramBoolean) {
      if (paramInt == 6) {
        ((TextView)localReportDialog.findViewById(2131381510)).setText(2131694969);
      }
    }
    for (;;)
    {
      localReportDialog.show();
      this.jdField_b_of_type_AndroidOsHandler.postDelayed(new PublicAccountImageCollectionMainActivity.10(this, localReportDialog), 1000L);
      return;
      if (paramInt == 10)
      {
        ((TextView)localReportDialog.findViewById(2131381510)).setText(2131694968);
      }
      else
      {
        ((TextView)localReportDialog.findViewById(2131381510)).setText(2131694967);
        continue;
        this.jdField_c_of_type_Boolean = false;
      }
    }
  }
  
  private List<ojr>[] a()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = new ojr();
    ((ojr)localObject).jdField_a_of_type_JavaLangString = super.getString(2131696130);
    ((ojr)localObject).jdField_a_of_type_Int = 2130839146;
    ((ojr)localObject).jdField_a_of_type_Boolean = true;
    ((ojr)localObject).jdField_b_of_type_Int = 2;
    ((ojr)localObject).jdField_b_of_type_JavaLangString = "";
    localArrayList.add(localObject);
    localObject = new ojr();
    ((ojr)localObject).jdField_a_of_type_JavaLangString = super.getString(2131696143);
    ((ojr)localObject).jdField_a_of_type_Int = 2130839147;
    ((ojr)localObject).jdField_a_of_type_Boolean = true;
    ((ojr)localObject).jdField_b_of_type_Int = 3;
    ((ojr)localObject).jdField_b_of_type_JavaLangString = "";
    localArrayList.add(localObject);
    localObject = new ojr();
    ((ojr)localObject).jdField_a_of_type_JavaLangString = super.getString(2131696150);
    ((ojr)localObject).jdField_a_of_type_Int = 2130839150;
    ((ojr)localObject).jdField_b_of_type_Int = 9;
    ((ojr)localObject).jdField_b_of_type_JavaLangString = "";
    localArrayList.add(localObject);
    localObject = new ojr();
    ((ojr)localObject).jdField_a_of_type_JavaLangString = super.getString(2131696133);
    ((ojr)localObject).jdField_a_of_type_Int = 2130839144;
    ((ojr)localObject).jdField_b_of_type_Int = 10;
    ((ojr)localObject).jdField_b_of_type_JavaLangString = "";
    localArrayList.add(localObject);
    localObject = new ojr();
    ((ojr)localObject).jdField_a_of_type_JavaLangString = super.getString(2131696127);
    ((ojr)localObject).jdField_a_of_type_Boolean = true;
    ((ojr)localObject).jdField_a_of_type_Int = 2130842691;
    ((ojr)localObject).jdField_b_of_type_Int = 4;
    ((ojr)localObject).jdField_b_of_type_JavaLangString = "";
    localArrayList.add(localObject);
    localObject = new ArrayList();
    ojr localojr = new ojr();
    localojr.jdField_a_of_type_JavaLangString = super.getString(2131696116);
    localojr.jdField_a_of_type_Boolean = true;
    localojr.jdField_a_of_type_Int = 2130844149;
    localojr.jdField_b_of_type_Int = 6;
    localojr.jdField_b_of_type_JavaLangString = "";
    ((ArrayList)localObject).add(localojr);
    localojr = new ojr();
    localojr.jdField_a_of_type_JavaLangString = super.getString(2131696122);
    localojr.jdField_a_of_type_Int = 2130839142;
    localojr.jdField_a_of_type_Boolean = true;
    localojr.jdField_b_of_type_Int = 1;
    localojr.jdField_b_of_type_JavaLangString = "";
    ((ArrayList)localObject).add(localojr);
    localojr = new ojr();
    localojr.jdField_a_of_type_JavaLangString = super.getString(2131696128);
    localojr.jdField_a_of_type_Int = 2130842681;
    localojr.jdField_a_of_type_Boolean = true;
    localojr.jdField_b_of_type_Int = 11;
    localojr.jdField_b_of_type_JavaLangString = "";
    ((ArrayList)localObject).add(localojr);
    return (List[])new ArrayList[] { localArrayList, localObject };
  }
  
  private void b(int paramInt)
  {
    olh.a(null, this.jdField_a_of_type_JavaLangString, "0X8007A7A", "0X8007A7A", 0, 0, this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, "" + a(this.j), "" + paramInt, false);
  }
  
  private void b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return;
      try
      {
        paramString = URLDrawable.getDrawable(paramString, null, null);
        if ((paramString.getStatus() != 1) || (!(paramString.getCurrDrawable() instanceof RegionDrawable))) {
          break;
        }
        this.jdField_a_of_type_AndroidGraphicsBitmap = ((RegionDrawable)paramString.getCurrDrawable()).getBitmap();
        return;
      }
      catch (Exception paramString) {}
    } while (!QLog.isColorLevel());
    QLog.e("qqBaseActivity", 2, "initData", paramString);
    return;
    paramString.setURLDrawableListener(new vud(this, paramString));
    paramString.startDownload();
  }
  
  private void c(int paramInt)
  {
    olh.a(null, this.jdField_a_of_type_JavaLangString, "0X8007C18", "0X8007C18", 0, 0, this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, "" + paramInt, "", false);
  }
  
  @TargetApi(11)
  private void j()
  {
    this.jdField_b_of_type_Float = getResources().getDisplayMetrics().density;
    a();
    this.jdField_b_of_type_AndroidOsHandler = new Handler();
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131368566));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131368567));
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)super.findViewById(2131376958));
    this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageCollectionListView = ((PublicAccountImageCollectionListView)super.findViewById(2131368559));
    this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageCollectionListView.setVerticalScrollBarEnabled(false);
    this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageCollectionListView.setDividerHeight(0);
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)getWindow().getDecorView());
    this.jdField_a_of_type_Vtj = new vtj(this, this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageCollectionListView, (QQAppInterface)super.getAppInterface());
    this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageCollectionListView.setSmoothScrollbarEnabled(false);
    this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageCollectionListView.setOnTouchListener(new vub(this));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)super.findViewById(2131380601));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131368568));
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131368551));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131368550));
    this.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131368570));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131368569));
    this.jdField_f_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131368564));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131368552));
    this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_d_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_e_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_f_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
  }
  
  private void k()
  {
    this.jdField_a_of_type_Ojn = ((ojn)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getBusinessHandler(BusinessHandlerFactory.PUBLIC_ACCOUNT_VIDEO_HANDLER));
    this.jdField_a_of_type_Ojo = new vug(this);
    this.jdField_a_of_type_Ojn.a(this.jdField_a_of_type_Ojo);
  }
  
  private void l()
  {
    if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))
    {
      if (QLog.isColorLevel()) {
        QLog.d("qqBaseActivity", 2, "fetchAllArticleInfo");
      }
      o();
      ThreadManager.executeOnSubThread(new PublicAccountImageCollectionMainActivity.4(this));
    }
  }
  
  private void m()
  {
    if (this.jdField_a_of_type_Vus == null) {
      return;
    }
    this.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_Vus.jdField_b_of_type_JavaLangString;
    this.jdField_g_of_type_JavaLangString = this.jdField_a_of_type_Vus.jdField_e_of_type_JavaLangString;
    this.jdField_i_of_type_JavaLangString = this.jdField_a_of_type_Vus.jdField_d_of_type_JavaLangString;
    this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_Vus.jdField_c_of_type_JavaLangString;
    if (TextUtils.isEmpty(this.jdField_h_of_type_JavaLangString)) {
      this.jdField_h_of_type_JavaLangString = "来自QQ看点的分享";
    }
    this.jdField_b_of_type_AndroidOsHandler.postDelayed(new PublicAccountImageCollectionMainActivity.5(this), 0L);
    i();
    b(this.jdField_i_of_type_JavaLangString);
    this.jdField_a_of_type_Ojn.a(this.jdField_c_of_type_JavaLangString);
  }
  
  private void n()
  {
    this.jdField_b_of_type_JavaLangString = getIntent().getStringExtra("articleid");
    this.jdField_e_of_type_JavaLangString = getIntent().getStringExtra("recommend_source");
    if (this.jdField_e_of_type_JavaLangString == null) {
      this.jdField_e_of_type_JavaLangString = "";
    }
    this.jdField_h_of_type_Int = getIntent().getIntExtra("recommend_position", 0);
    this.jdField_i_of_type_Int = getIntent().getIntExtra("click_source", 1);
    this.j = getIntent().getIntExtra("source_for_report", 16);
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = ((AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null));
    this.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin();
    this.jdField_a_of_type_Vtj.a(this.jdField_a_of_type_Vus);
    this.jdField_a_of_type_Vtj.a(this.jdField_a_of_type_JavaUtilArrayList);
    this.jdField_a_of_type_Vtj.a(this.jdField_b_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageCollectionListView.setAdapter(this.jdField_a_of_type_Vtj);
  }
  
  private void o()
  {
    this.jdField_a_of_type_Vus = PublicAccountImageCollectionPreloadManager.a().a(this.jdField_b_of_type_JavaLangString);
    if (this.jdField_a_of_type_Vus != null)
    {
      PublicAccountImageCollectionPreloadManager.a().a(true);
      m();
      PublicAccountImageCollectionPreloadManager.a().a(this.jdField_a_of_type_Ojo);
      return;
    }
    if (FileUtils.fileExistsAndNotEmpty(AppConstants.SDCARD_PATH_PUBLIC_ACCOUNT_IMAGE_COLLECTION_PRELOAD + this.jdField_b_of_type_JavaLangString))
    {
      PublicAccountImageCollectionPreloadManager.a().a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Ojo);
      PublicAccountImageCollectionPreloadManager.a().a(true);
      return;
    }
    PublicAccountImageCollectionPreloadManager.a().a(false);
    this.jdField_f_of_type_Boolean = true;
  }
  
  @TargetApi(11)
  private void p()
  {
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout.getAnimation() != null)
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.getAnimation().setAnimationListener(null);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.getAnimation().cancel();
      this.jdField_a_of_type_AndroidWidgetLinearLayout.clearAnimation();
    }
    if (this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation != null)
    {
      this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.setAnimationListener(null);
      this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.cancel();
      this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation = null;
    }
    if (this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation != null)
    {
      this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation.setAnimationListener(null);
      this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation.cancel();
      this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation = null;
    }
    if (Build.VERSION.SDK_INT >= 11)
    {
      if (this.jdField_a_of_type_AndroidAnimationAnimatorSet != null)
      {
        Iterator localIterator = this.jdField_a_of_type_AndroidAnimationAnimatorSet.getChildAnimations().iterator();
        while (localIterator.hasNext())
        {
          Animator localAnimator = (Animator)localIterator.next();
          localAnimator.end();
          localAnimator.cancel();
        }
        this.jdField_a_of_type_AndroidAnimationAnimatorSet.end();
        this.jdField_a_of_type_AndroidAnimationAnimatorSet.cancel();
      }
      this.jdField_a_of_type_AndroidAnimationAnimatorSet = null;
    }
  }
  
  private void q()
  {
    Intent localIntent = new Intent(this, PublicAccountImageCollectionCommentActivity.class);
    if (!TextUtils.isEmpty(this.jdField_f_of_type_JavaLangString)) {
      localIntent.putExtra("comment", this.jdField_f_of_type_JavaLangString);
    }
    localIntent.putExtra("anonymous", this.jdField_c_of_type_Boolean);
    startActivityForResult(localIntent, 100);
    olh.a(null, this.jdField_a_of_type_JavaLangString, "0X8007B9A", "0X8007B9A", 0, 0, this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, "", "", false);
  }
  
  private void r()
  {
    Object localObject1 = "mqqapi://readinjoy/apenalbum?src_type=app&version=1&articleid=" + this.jdField_b_of_type_JavaLangString;
    localObject1 = new bdnr(StructMsgForGeneralShare.class).c(79).a("web", this.jdField_c_of_type_JavaLangString, (String)localObject1, "", "").a(anvx.a(2131708254) + this.jdField_g_of_type_JavaLangString).a();
    Object localObject2 = this.jdField_i_of_type_JavaLangString;
    bdnv localbdnv = bdoe.a(2);
    localbdnv.a((String)localObject2, this.jdField_g_of_type_JavaLangString, this.jdField_h_of_type_JavaLangString);
    ((AbsShareMsg)localObject1).addItem(localbdnv);
    localObject2 = new Intent();
    ((Intent)localObject2).putExtra("forward_thumb", this.jdField_i_of_type_JavaLangString);
    ((Intent)localObject2).putExtra("forward_type", -3);
    ((Intent)localObject2).putExtra("stuctmsg_bytes", ((AbsShareMsg)localObject1).getBytes());
    aupt.a(this, (Intent)localObject2, 21);
  }
  
  private void s()
  {
    this.jdField_a_of_type_AndroidViewViewGroup.removeView(this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageView);
    this.jdField_g_of_type_Boolean = false;
  }
  
  void a()
  {
    if ((Build.VERSION.SDK_INT >= 19) && (ImmersiveUtils.isSupporImmersive() == 1)) {
      super.getWindow().addFlags(67108864);
    }
    if (this.mSystemBarComp != null)
    {
      int n = getResources().getColor(2131167296);
      this.mSystemBarComp.setStatusColor(n);
      this.mSystemBarComp.setStatusBarColor(n);
    }
    if ((VersionUtils.isJellyBean()) && (VersionUtils.isHoneycomb())) {
      getWindow().getDecorView().setSystemUiVisibility(4102);
    }
    if (VersionUtils.isHoneycomb()) {
      getWindow().getDecorView().setOnSystemUiVisibilityChangeListener(new vuf(this));
    }
  }
  
  public void a(int paramInt)
  {
    if ((isFinishing()) || (this.jdField_a_of_type_Vtj == null)) {
      return;
    }
    if (this.jdField_a_of_type_Bkzi == null)
    {
      this.jdField_a_of_type_Bkzi = ((bkzi)bkzz.a(this, null));
      View localView1 = a(paramInt);
      this.jdField_a_of_type_Bkzi.a(localView1, null);
    }
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_Bkzi.isShowing()) {
          break;
        }
        this.jdField_a_of_type_Bkzi.show();
        if (paramInt != 2) {
          break label126;
        }
        this.jdField_g_of_type_Int = 2;
        olh.a(null, this.jdField_a_of_type_JavaLangString, "0X8007A79", "0X8007A79", 0, 0, this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, "", "", false);
        return;
      }
      catch (Exception localException)
      {
        return;
      }
      View localView2 = a(paramInt);
      this.jdField_a_of_type_Bkzi.a(localView2, null);
    }
    label126:
    this.jdField_g_of_type_Int = 1;
    olh.a(null, this.jdField_a_of_type_JavaLangString, "0X8007A80", "0X8007A80", 0, 0, this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, "", "", false);
  }
  
  public void a(int paramInt1, int paramInt2, String paramString)
  {
    int n;
    if (!this.jdField_e_of_type_Boolean)
    {
      this.jdField_e_of_type_Boolean = true;
      if (this.jdField_a_of_type_Vus != null)
      {
        n = (int)(System.currentTimeMillis() - this.jdField_a_of_type_Long);
        this.jdField_a_of_type_Ojn.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Vus.jdField_b_of_type_JavaLangString, paramInt1, paramInt2, paramString, n, this.jdField_a_of_type_JavaUtilArrayList);
        if (this.jdField_a_of_type_Vus.jdField_a_of_type_JavaUtilArrayList == null) {
          break label183;
        }
        paramString = this.jdField_a_of_type_Vus.jdField_a_of_type_JavaUtilArrayList.iterator();
        paramInt1 = 0;
        while (paramString.hasNext())
        {
          if (!((vuu)paramString.next()).jdField_a_of_type_Boolean) {
            break label180;
          }
          paramInt1 += 1;
        }
      }
    }
    for (;;)
    {
      olh.a(null, this.jdField_a_of_type_JavaLangString, "0X8007B8B", "0X8007B8B", 0, 0, this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, "" + n, "" + paramInt1, false);
      return;
      label180:
      break;
      label183:
      paramInt1 = 0;
    }
  }
  
  protected void a(String paramString, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentCommonAppAppInterface == null) {
      return;
    }
    String str = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin();
    bmad.a(paramString).c(str).b(this, str, 101, null);
  }
  
  void b()
  {
    a(2);
  }
  
  void c()
  {
    q();
  }
  
  void d()
  {
    if ((this.jdField_a_of_type_Vus != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_Vus.jdField_b_of_type_JavaLangString)))
    {
      Intent localIntent = new Intent(this, QQBrowserActivity.class);
      localIntent.putExtra("url", this.jdField_a_of_type_Vus.jdField_f_of_type_JavaLangString);
      localIntent.putExtra("hide_more_button", true);
      startActivity(localIntent);
    }
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    switch (paramInt1)
    {
    }
    do
    {
      do
      {
        return;
        bmad.a(this, paramIntent);
        return;
        switch (paramInt2)
        {
        default: 
          return;
        }
        ForwardUtils.handleForwardData((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface, this, getApplicationContext(), paramIntent, null);
        return;
      } while (paramIntent == null);
      this.jdField_f_of_type_JavaLangString = paramIntent.getStringExtra("comment");
      this.jdField_c_of_type_Boolean = paramIntent.getBooleanExtra("anonymous", false);
      if (paramInt2 == 0)
      {
        a(this.jdField_f_of_type_JavaLangString);
        return;
      }
    } while (paramInt2 != -1);
    a(getString(2131694965));
    ThreadManager.executeOnSubThread(new PublicAccountImageCollectionMainActivity.13(this));
  }
  
  public void doOnBackPressed()
  {
    a(1, 0, "");
    super.doOnBackPressed();
    olh.a(null, this.jdField_a_of_type_JavaLangString, "0X8007B8F", "0X8007B8F", 0, 0, this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, "", "", false);
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    this.mNeedStatusTrans = false;
    this.mActNeedImmersive = false;
    super.doOnCreate(paramBundle);
    super.setContentView(2131559658);
    j();
    n();
    k();
    l();
    this.jdField_a_of_type_AndroidViewScaleGestureDetector = new ScaleGestureDetector(this, new vuj(this, null));
    this.jdField_a_of_type_AndroidContentContext = getBaseContext();
    if (VersionUtils.isIceScreamSandwich()) {
      getWindow().setFlags(16777216, 16777216);
    }
    vti.a().a(this);
    vti.a().a();
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.jdField_b_of_type_AndroidOsHandler != null)
    {
      this.jdField_b_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      this.jdField_b_of_type_AndroidOsHandler = null;
    }
    if (this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageCollectionListView != null) {
      this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageCollectionListView.c();
    }
    if (this.jdField_a_of_type_Vtj != null) {
      this.jdField_a_of_type_Vtj.a();
    }
    if (this.jdField_a_of_type_AndroidContentContext != null) {
      this.jdField_a_of_type_AndroidContentContext = null;
    }
    if (this.jdField_a_of_type_AndroidOsHandler != null)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_AndroidOsHandler = null;
    }
    if (this.jdField_a_of_type_Ojn != null)
    {
      if (vti.a().a() == 1) {
        this.jdField_a_of_type_Ojn.a();
      }
      this.jdField_a_of_type_Ojn = null;
    }
    p();
    tlv.a().a();
    vti.a().b(this);
    PublicAccountImageCollectionPreloadManager.a().b();
  }
  
  public void doOnPause()
  {
    super.doOnPause();
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    i();
    if (this.jdField_a_of_type_Vtj != null) {
      this.jdField_a_of_type_Vtj.b();
    }
  }
  
  void e()
  {
    boolean bool;
    if (!this.jdField_b_of_type_Boolean)
    {
      bool = true;
      this.jdField_b_of_type_Boolean = bool;
      if (!this.jdField_b_of_type_Boolean) {
        break label121;
      }
      this.k += 1;
      this.jdField_e_of_type_AndroidWidgetImageView.setImageResource(2130841653);
      olh.a(null, this.jdField_a_of_type_JavaLangString, "0X8007B95", "0X8007B95", 0, 0, this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, "", "", false);
    }
    for (;;)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setText("" + this.k);
      this.jdField_a_of_type_Ojn.a(this.jdField_b_of_type_JavaLangString, this.jdField_b_of_type_Boolean, false);
      return;
      bool = false;
      break;
      label121:
      this.k -= 1;
      this.jdField_e_of_type_AndroidWidgetImageView.setImageResource(2130841652);
      olh.a(null, this.jdField_a_of_type_JavaLangString, "0X8007B96", "0X8007B96", 0, 0, this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, "", "", false);
    }
  }
  
  void f()
  {
    a(1);
  }
  
  @TargetApi(11)
  public void g()
  {
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout.getVisibility() == 8) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("qqBaseActivity", 2, "hide user guide");
    }
    p();
    this.jdField_b_of_type_AndroidOsHandler.post(new PublicAccountImageCollectionMainActivity.6(this));
  }
  
  @TargetApi(11)
  public void h()
  {
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout.getVisibility() == 0) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("qqBaseActivity", 2, "show user guide");
    }
    if (this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation != null) {
      this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.cancel();
    }
    if (this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation != null) {
      this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation.cancel();
    }
    this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 1.0F, 1, -0.2F);
    this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.setDuration(200L);
    this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.setFillAfter(true);
    this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, -0.2F, 1, 0.0F);
    this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation.setDuration(300L);
    this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation.setFillAfter(true);
    this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.setAnimationListener(new vuh(this));
    this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation.setAnimationListener(new vui(this));
    this.jdField_b_of_type_AndroidOsHandler.postDelayed(new PublicAccountImageCollectionMainActivity.9(this), 300L);
  }
  
  void i()
  {
    ThreadManager.post(new PublicAccountImageCollectionMainActivity.16(this), 5, null, true);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      doOnBackPressed();
      b();
      continue;
      c();
      continue;
      e();
      continue;
      e();
      continue;
      d();
      continue;
      d();
      continue;
      f();
      continue;
      c();
    }
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    Object localObject1 = paramView.getTag();
    if (localObject1 == null) {}
    int n;
    do
    {
      for (;;)
      {
        EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
        return;
        if (this.jdField_a_of_type_Bkzi.isShowing()) {
          this.jdField_a_of_type_Bkzi.dismiss();
        }
        n = ((ojt)localObject1).a.jdField_b_of_type_Int;
        localObject1 = this.jdField_c_of_type_JavaLangString;
        if (n == 1)
        {
          ((ClipboardManager)getSystemService("clipboard")).setText((CharSequence)localObject1);
          znl.a(2, 2131691266);
          c(1011);
        }
        else
        {
          Object localObject2;
          if (n == 11)
          {
            Object localObject3 = null;
            try
            {
              localObject1 = URLEncoder.encode((String)localObject1, "UTF-8");
              localObject3 = String.valueOf(NetConnInfoCenter.getServerTime());
              String str = MD5Utils.encodeHexStr((String)localObject1 + 200 + (String)localObject3 + "jubao@article@123").toLowerCase();
              localObject1 = "https://jubao.mp.qq.com/mobile/report?qq=" + this.jdField_d_of_type_JavaLangString + "&mp_uin=" + this.jdField_a_of_type_JavaLangString + "&scene=200&sub_appname=article_webview&timestamp=" + (String)localObject3 + "&sign=" + str + "&article_url=" + (String)localObject1;
              localObject3 = new Intent(this, QQBrowserActivity.class);
              ((Intent)localObject3).putExtra("url", (String)localObject1);
              ((Intent)localObject3).putExtra("hide_more_button", true);
              startActivity((Intent)localObject3);
              c(1008);
            }
            catch (UnsupportedEncodingException localUnsupportedEncodingException)
            {
              for (;;)
              {
                localObject2 = localObject3;
                if (QLog.isColorLevel())
                {
                  QLog.d("qqBaseActivity", 2, "encode url failed, because UTF-8 is unknown");
                  localObject2 = localObject3;
                }
              }
            }
          }
          else if (n == 2)
          {
            r();
            b(1001);
            if (this.jdField_g_of_type_Int == 2) {
              c(1001);
            }
          }
          else if (n == 4)
          {
            localObject2 = new Intent("android.intent.action.VIEW", Uri.parse((String)localObject2));
            ((Intent)localObject2).putExtra("normal", true);
            try
            {
              startActivity((Intent)localObject2);
              c(1006);
            }
            catch (ActivityNotFoundException localActivityNotFoundException)
            {
              znl.a(1, 2131694987);
            }
          }
          else if (n == 3)
          {
            mus.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this, this.jdField_i_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_h_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString);
            b(1002);
            if (this.jdField_g_of_type_Int == 2) {
              c(1002);
            }
          }
          else
          {
            if (n != 6) {
              break;
            }
            a(localActivityNotFoundException, true);
            c(1007);
          }
        }
      }
    } while ((n != 9) && (n != 10));
    if (n == 9)
    {
      b(1003);
      if (this.jdField_g_of_type_Int == 2) {
        c(1003);
      }
    }
    for (;;)
    {
      vuq.a(this, this.jdField_g_of_type_JavaLangString, this.jdField_h_of_type_JavaLangString, localActivityNotFoundException, this.jdField_a_of_type_AndroidGraphicsBitmap, n);
      break;
      b(1004);
      if (this.jdField_g_of_type_Int == 2) {
        c(1004);
      }
    }
  }
  
  public void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
    getWindow().setFormat(-3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.publicAccountImageCollection.PublicAccountImageCollectionMainActivity
 * JD-Core Version:    0.7.0.1
 */