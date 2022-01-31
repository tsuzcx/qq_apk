package com.tencent.biz.publicAccountImageCollection;

import alof;
import alud;
import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
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
import aryv;
import azup;
import azut;
import azvc;
import bdhb;
import bflr;
import bhtb;
import bhuf;
import bhus;
import biva;
import com.tencent.biz.widgets.ElasticHorScrView;
import com.tencent.common.app.AppInterface;
import com.tencent.image.RegionDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;
import mqq.app.MobileQQ;
import mwe;
import npt;
import npu;
import nqh;
import nqi;
import nqj;
import nrt;
import sff;
import toh;
import toi;
import tpa;
import tpb;
import tpc;
import tpd;
import tpe;
import tpf;
import tpg;
import tph;
import tpi;
import tpp;
import tpr;
import tpt;
import tpu;
import ybk;

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
  public bhuf a;
  private PublicAccountImageCollectionListView jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageCollectionListView;
  private PublicAccountImageView jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageView;
  ElasticHorScrView jdField_a_of_type_ComTencentBizWidgetsElasticHorScrView;
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  public String a;
  private ArrayList<tpu> jdField_a_of_type_JavaUtilArrayList;
  private npt jdField_a_of_type_Npt;
  private npu jdField_a_of_type_Npu;
  private toi jdField_a_of_type_Toi;
  private tpr jdField_a_of_type_Tpr;
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
    this.jdField_a_of_type_AndroidOsHandler = new tpd(this);
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
    View localView = super.getLayoutInflater().inflate(2131559084, null);
    this.jdField_a_of_type_ComTencentBizWidgetsElasticHorScrView = ((ElasticHorScrView)localView.findViewById(2131376210));
    this.jdField_b_of_type_ComTencentBizWidgetsElasticHorScrView = ((ElasticHorScrView)localView.findViewById(2131376212));
    if (paramInt == 1) {
      this.jdField_b_of_type_ComTencentBizWidgetsElasticHorScrView.setVisibility(8);
    }
    GridView localGridView2 = (GridView)localView.findViewById(2131367308);
    GridView localGridView1 = (GridView)localView.findViewById(2131367309);
    Object localObject1 = (TextView)localView.findViewById(2131361928);
    Object localObject2 = (LinearLayout.LayoutParams)((TextView)localObject1).getLayoutParams();
    ((LinearLayout.LayoutParams)localObject2).topMargin = ((int)(13.0F * this.jdField_b_of_type_Float));
    ((TextView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
    ((TextView)localObject1).setText(2131690648);
    ((TextView)localObject1).setOnClickListener(new tpb(this));
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
      localGridView2.setAdapter(new nqi(this, 0, (List)localObject1));
      localGridView2.setSelector(new ColorDrawable(0));
      localGridView2.setOnItemClickListener(this);
      paramInt = localLayoutParams.width;
      this.jdField_f_of_type_Int = paramInt;
      int n = ((List)localObject2).size();
      localObject1 = localGridView1.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject1).width = ((int)((n * 75 + (n - 1) * 10 + 3) * this.jdField_b_of_type_Float));
      localGridView1.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      localGridView1.setNumColumns(n);
      localGridView1.setAdapter(new nqi(this, 0, (List)localObject2));
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
    Dialog localDialog = new Dialog(this, 2131755550);
    localDialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
    localDialog.setContentView(2131559481);
    if (!paramBoolean) {
      if (paramInt == 6) {
        ((TextView)localDialog.findViewById(2131380273)).setText(2131695712);
      }
    }
    for (;;)
    {
      localDialog.show();
      this.jdField_b_of_type_AndroidOsHandler.postDelayed(new PublicAccountImageCollectionMainActivity.10(this, localDialog), 1000L);
      return;
      if (paramInt == 10)
      {
        ((TextView)localDialog.findViewById(2131380273)).setText(2131695711);
      }
      else
      {
        ((TextView)localDialog.findViewById(2131380273)).setText(2131695710);
        continue;
        this.jdField_c_of_type_Boolean = false;
      }
    }
  }
  
  private List<nqh>[] a()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = new nqh();
    ((nqh)localObject).jdField_a_of_type_JavaLangString = super.getString(2131696873);
    ((nqh)localObject).jdField_a_of_type_Int = 2130838917;
    ((nqh)localObject).jdField_a_of_type_Boolean = true;
    ((nqh)localObject).jdField_b_of_type_Int = 2;
    ((nqh)localObject).jdField_b_of_type_JavaLangString = "";
    localArrayList.add(localObject);
    localObject = new nqh();
    ((nqh)localObject).jdField_a_of_type_JavaLangString = super.getString(2131696886);
    ((nqh)localObject).jdField_a_of_type_Int = 2130838918;
    ((nqh)localObject).jdField_a_of_type_Boolean = true;
    ((nqh)localObject).jdField_b_of_type_Int = 3;
    ((nqh)localObject).jdField_b_of_type_JavaLangString = "";
    localArrayList.add(localObject);
    localObject = new nqh();
    ((nqh)localObject).jdField_a_of_type_JavaLangString = super.getString(2131696893);
    ((nqh)localObject).jdField_a_of_type_Int = 2130838921;
    ((nqh)localObject).jdField_b_of_type_Int = 9;
    ((nqh)localObject).jdField_b_of_type_JavaLangString = "";
    localArrayList.add(localObject);
    localObject = new nqh();
    ((nqh)localObject).jdField_a_of_type_JavaLangString = super.getString(2131696876);
    ((nqh)localObject).jdField_a_of_type_Int = 2130838915;
    ((nqh)localObject).jdField_b_of_type_Int = 10;
    ((nqh)localObject).jdField_b_of_type_JavaLangString = "";
    localArrayList.add(localObject);
    localObject = new nqh();
    ((nqh)localObject).jdField_a_of_type_JavaLangString = super.getString(2131696870);
    ((nqh)localObject).jdField_a_of_type_Boolean = true;
    ((nqh)localObject).jdField_a_of_type_Int = 2130842293;
    ((nqh)localObject).jdField_b_of_type_Int = 4;
    ((nqh)localObject).jdField_b_of_type_JavaLangString = "";
    localArrayList.add(localObject);
    localObject = new ArrayList();
    nqh localnqh = new nqh();
    localnqh.jdField_a_of_type_JavaLangString = super.getString(2131696859);
    localnqh.jdField_a_of_type_Boolean = true;
    localnqh.jdField_a_of_type_Int = 2130843813;
    localnqh.jdField_b_of_type_Int = 6;
    localnqh.jdField_b_of_type_JavaLangString = "";
    ((ArrayList)localObject).add(localnqh);
    localnqh = new nqh();
    localnqh.jdField_a_of_type_JavaLangString = super.getString(2131696865);
    localnqh.jdField_a_of_type_Int = 2130838913;
    localnqh.jdField_a_of_type_Boolean = true;
    localnqh.jdField_b_of_type_Int = 1;
    localnqh.jdField_b_of_type_JavaLangString = "";
    ((ArrayList)localObject).add(localnqh);
    localnqh = new nqh();
    localnqh.jdField_a_of_type_JavaLangString = super.getString(2131696871);
    localnqh.jdField_a_of_type_Int = 2130842283;
    localnqh.jdField_a_of_type_Boolean = true;
    localnqh.jdField_b_of_type_Int = 11;
    localnqh.jdField_b_of_type_JavaLangString = "";
    ((ArrayList)localObject).add(localnqh);
    return (List[])new ArrayList[] { localArrayList, localObject };
  }
  
  private void b(int paramInt)
  {
    nrt.a(null, this.jdField_a_of_type_JavaLangString, "0X8007A7A", "0X8007A7A", 0, 0, this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, "" + a(this.j), "" + paramInt, false);
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
    paramString.setURLDrawableListener(new tpc(this, paramString));
    paramString.startDownload();
  }
  
  private void c(int paramInt)
  {
    nrt.a(null, this.jdField_a_of_type_JavaLangString, "0X8007C18", "0X8007C18", 0, 0, this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, "" + paramInt, "", false);
  }
  
  @TargetApi(11)
  private void j()
  {
    this.jdField_b_of_type_Float = getResources().getDisplayMetrics().density;
    a();
    this.jdField_b_of_type_AndroidOsHandler = new Handler();
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131367986));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131367987));
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)super.findViewById(2131376045));
    this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageCollectionListView = ((PublicAccountImageCollectionListView)super.findViewById(2131367979));
    this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageCollectionListView.setVerticalScrollBarEnabled(false);
    this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageCollectionListView.setDividerHeight(0);
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)getWindow().getDecorView());
    this.jdField_a_of_type_Toi = new toi(this, this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageCollectionListView, (QQAppInterface)super.getAppInterface());
    this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageCollectionListView.setSmoothScrollbarEnabled(false);
    this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageCollectionListView.setOnTouchListener(new tpa(this));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)super.findViewById(2131379430));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131367988));
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131367971));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131367970));
    this.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131367990));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131367989));
    this.jdField_f_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131367984));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131367972));
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
    this.jdField_a_of_type_Npt = ((npt)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getBusinessHandler(93));
    this.jdField_a_of_type_Npu = new tpf(this);
    this.jdField_a_of_type_Npt.a(this.jdField_a_of_type_Npu);
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
    if (this.jdField_a_of_type_Tpr == null) {
      return;
    }
    this.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_Tpr.jdField_b_of_type_JavaLangString;
    this.jdField_g_of_type_JavaLangString = this.jdField_a_of_type_Tpr.jdField_e_of_type_JavaLangString;
    this.jdField_i_of_type_JavaLangString = this.jdField_a_of_type_Tpr.jdField_d_of_type_JavaLangString;
    this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_Tpr.jdField_c_of_type_JavaLangString;
    if (TextUtils.isEmpty(this.jdField_h_of_type_JavaLangString)) {
      this.jdField_h_of_type_JavaLangString = "来自QQ看点的分享";
    }
    this.jdField_b_of_type_AndroidOsHandler.postDelayed(new PublicAccountImageCollectionMainActivity.5(this), 0L);
    i();
    b(this.jdField_i_of_type_JavaLangString);
    this.jdField_a_of_type_Npt.a(this.jdField_c_of_type_JavaLangString);
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
    this.jdField_a_of_type_Toi.a(this.jdField_a_of_type_Tpr);
    this.jdField_a_of_type_Toi.a(this.jdField_a_of_type_JavaUtilArrayList);
    this.jdField_a_of_type_Toi.a(this.jdField_b_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageCollectionListView.setAdapter(this.jdField_a_of_type_Toi);
  }
  
  private void o()
  {
    this.jdField_a_of_type_Tpr = PublicAccountImageCollectionPreloadManager.a().a(this.jdField_b_of_type_JavaLangString);
    if (this.jdField_a_of_type_Tpr != null)
    {
      PublicAccountImageCollectionPreloadManager.a().a(true);
      m();
      PublicAccountImageCollectionPreloadManager.a().a(this.jdField_a_of_type_Npu);
      return;
    }
    if (bdhb.b(alof.cN + this.jdField_b_of_type_JavaLangString))
    {
      PublicAccountImageCollectionPreloadManager.a().a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Npu);
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
    nrt.a(null, this.jdField_a_of_type_JavaLangString, "0X8007B9A", "0X8007B9A", 0, 0, this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, "", "", false);
  }
  
  private void r()
  {
    Object localObject1 = "mqqapi://readinjoy/apenalbum?src_type=app&version=1&articleid=" + this.jdField_b_of_type_JavaLangString;
    localObject1 = new azup(StructMsgForGeneralShare.class).c(79).a("web", this.jdField_c_of_type_JavaLangString, (String)localObject1, "", "").a(alud.a(2131709190) + this.jdField_g_of_type_JavaLangString).a();
    Object localObject2 = this.jdField_i_of_type_JavaLangString;
    azut localazut = azvc.a(2);
    localazut.a((String)localObject2, this.jdField_g_of_type_JavaLangString, this.jdField_h_of_type_JavaLangString);
    ((AbsShareMsg)localObject1).addItem(localazut);
    localObject2 = new Intent();
    ((Intent)localObject2).putExtra("forward_thumb", this.jdField_i_of_type_JavaLangString);
    ((Intent)localObject2).putExtra("forward_type", -3);
    ((Intent)localObject2).putExtra("stuctmsg_bytes", ((AbsShareMsg)localObject1).getBytes());
    aryv.a(this, (Intent)localObject2, 21);
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
      int n = getResources().getColor(2131167140);
      this.mSystemBarComp.setStatusColor(n);
      this.mSystemBarComp.setStatusBarColor(n);
    }
    if ((bhtb.g()) && (bhtb.e())) {
      getWindow().getDecorView().setSystemUiVisibility(4102);
    }
    if (bhtb.e()) {
      getWindow().getDecorView().setOnSystemUiVisibilityChangeListener(new tpe(this));
    }
  }
  
  public void a(int paramInt)
  {
    if ((isFinishing()) || (this.jdField_a_of_type_Toi == null)) {
      return;
    }
    if (this.jdField_a_of_type_Bhuf == null)
    {
      this.jdField_a_of_type_Bhuf = ((bhuf)bhus.a(this, null));
      View localView1 = a(paramInt);
      this.jdField_a_of_type_Bhuf.a(localView1, null);
    }
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_Bhuf.isShowing()) {
          break;
        }
        this.jdField_a_of_type_Bhuf.show();
        if (paramInt != 2) {
          break label126;
        }
        this.jdField_g_of_type_Int = 2;
        nrt.a(null, this.jdField_a_of_type_JavaLangString, "0X8007A79", "0X8007A79", 0, 0, this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, "", "", false);
        return;
      }
      catch (Exception localException)
      {
        return;
      }
      View localView2 = a(paramInt);
      this.jdField_a_of_type_Bhuf.a(localView2, null);
    }
    label126:
    this.jdField_g_of_type_Int = 1;
    nrt.a(null, this.jdField_a_of_type_JavaLangString, "0X8007A80", "0X8007A80", 0, 0, this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, "", "", false);
  }
  
  public void a(int paramInt1, int paramInt2, String paramString)
  {
    int n;
    if (!this.jdField_e_of_type_Boolean)
    {
      this.jdField_e_of_type_Boolean = true;
      if (this.jdField_a_of_type_Tpr != null)
      {
        n = (int)(System.currentTimeMillis() - this.jdField_a_of_type_Long);
        this.jdField_a_of_type_Npt.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Tpr.jdField_b_of_type_JavaLangString, paramInt1, paramInt2, paramString, n, this.jdField_a_of_type_JavaUtilArrayList);
        if (this.jdField_a_of_type_Tpr.jdField_a_of_type_JavaUtilArrayList == null) {
          break label183;
        }
        paramString = this.jdField_a_of_type_Tpr.jdField_a_of_type_JavaUtilArrayList.iterator();
        paramInt1 = 0;
        while (paramString.hasNext())
        {
          if (!((tpt)paramString.next()).jdField_a_of_type_Boolean) {
            break label180;
          }
          paramInt1 += 1;
        }
      }
    }
    for (;;)
    {
      nrt.a(null, this.jdField_a_of_type_JavaLangString, "0X8007B8B", "0X8007B8B", 0, 0, this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, "" + n, "" + paramInt1, false);
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
    biva.a(paramString).c(str).b(this, str, 101, null);
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
    if ((this.jdField_a_of_type_Tpr != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_Tpr.jdField_b_of_type_JavaLangString)))
    {
      Intent localIntent = new Intent(this, QQBrowserActivity.class);
      localIntent.putExtra("url", this.jdField_a_of_type_Tpr.jdField_f_of_type_JavaLangString);
      localIntent.putExtra("hide_more_button", true);
      startActivity(localIntent);
    }
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
        biva.a(this, paramIntent);
        return;
        switch (paramInt2)
        {
        default: 
          return;
        }
        ForwardUtils.a((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface, this, getApplicationContext(), paramIntent, null);
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
    a(getString(2131695708));
    ThreadManager.executeOnSubThread(new PublicAccountImageCollectionMainActivity.13(this));
  }
  
  public void doOnBackPressed()
  {
    a(1, 0, "");
    super.doOnBackPressed();
    nrt.a(null, this.jdField_a_of_type_JavaLangString, "0X8007B8F", "0X8007B8F", 0, 0, this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, "", "", false);
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    this.mNeedStatusTrans = false;
    this.mActNeedImmersive = false;
    super.doOnCreate(paramBundle);
    super.setContentView(2131559484);
    j();
    n();
    k();
    l();
    this.jdField_a_of_type_AndroidViewScaleGestureDetector = new ScaleGestureDetector(this, new tpi(this, null));
    this.jdField_a_of_type_AndroidContentContext = getBaseContext();
    if (bhtb.d()) {
      getWindow().setFlags(16777216, 16777216);
    }
    toh.a().a(this);
    toh.a().a();
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
    if (this.jdField_a_of_type_Toi != null) {
      this.jdField_a_of_type_Toi.a();
    }
    if (this.jdField_a_of_type_AndroidContentContext != null) {
      this.jdField_a_of_type_AndroidContentContext = null;
    }
    if (this.jdField_a_of_type_AndroidOsHandler != null)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_AndroidOsHandler = null;
    }
    if (this.jdField_a_of_type_Npt != null)
    {
      if (toh.a().a() == 1) {
        this.jdField_a_of_type_Npt.a();
      }
      this.jdField_a_of_type_Npt = null;
    }
    p();
    sff.a().a();
    toh.a().b(this);
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
    if (this.jdField_a_of_type_Toi != null) {
      this.jdField_a_of_type_Toi.b();
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
      this.jdField_e_of_type_AndroidWidgetImageView.setImageResource(2130841294);
      nrt.a(null, this.jdField_a_of_type_JavaLangString, "0X8007B95", "0X8007B95", 0, 0, this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, "", "", false);
    }
    for (;;)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setText("" + this.k);
      this.jdField_a_of_type_Npt.a(this.jdField_b_of_type_JavaLangString, this.jdField_b_of_type_Boolean, false);
      return;
      bool = false;
      break;
      label121:
      this.k -= 1;
      this.jdField_e_of_type_AndroidWidgetImageView.setImageResource(2130841293);
      nrt.a(null, this.jdField_a_of_type_JavaLangString, "0X8007B96", "0X8007B96", 0, 0, this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, "", "", false);
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
    this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.setAnimationListener(new tpg(this));
    this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation.setAnimationListener(new tph(this));
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
    case 2131367973: 
    case 2131367974: 
    case 2131367975: 
    case 2131367976: 
    case 2131367977: 
    case 2131367978: 
    case 2131367979: 
    case 2131367980: 
    case 2131367981: 
    case 2131367982: 
    case 2131367983: 
    case 2131367985: 
    default: 
      return;
    case 2131367986: 
      doOnBackPressed();
    case 2131367987: 
      b();
      return;
    case 2131367988: 
      c();
      return;
    case 2131367990: 
      e();
      return;
    case 2131367989: 
      e();
      return;
    case 2131367971: 
      d();
      return;
    case 2131367970: 
      d();
      return;
    case 2131367984: 
      f();
      return;
    }
    c();
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = paramView.getTag();
    if (paramAdapterView == null) {}
    do
    {
      do
      {
        do
        {
          return;
          if (this.jdField_a_of_type_Bhuf.isShowing()) {
            this.jdField_a_of_type_Bhuf.dismiss();
          }
          paramInt = ((nqj)paramAdapterView).a.jdField_b_of_type_Int;
          paramAdapterView = this.jdField_c_of_type_JavaLangString;
          if (paramInt == 1)
          {
            ((ClipboardManager)getSystemService("clipboard")).setText(paramAdapterView);
            ybk.a(2, 2131691363);
            c(1011);
            return;
          }
          if (paramInt == 11)
          {
            Pattern.compile("http://.*.mp.qq.com.*").matcher(paramAdapterView);
            paramView = null;
            try
            {
              paramAdapterView = URLEncoder.encode(paramAdapterView, "UTF-8");
              paramView = String.valueOf(NetConnInfoCenter.getServerTime());
              String str = bflr.b(paramAdapterView + 200 + paramView + "jubao@article@123").toLowerCase();
              paramAdapterView = "https://jubao.mp.qq.com/mobile/report?qq=" + this.jdField_d_of_type_JavaLangString + "&mp_uin=" + this.jdField_a_of_type_JavaLangString + "&scene=200&sub_appname=article_webview&timestamp=" + paramView + "&sign=" + str + "&article_url=" + paramAdapterView;
              paramView = new Intent(this, QQBrowserActivity.class);
              paramView.putExtra("url", paramAdapterView);
              paramView.putExtra("hide_more_button", true);
              startActivity(paramView);
              c(1008);
              return;
            }
            catch (UnsupportedEncodingException paramAdapterView)
            {
              for (;;)
              {
                paramAdapterView = paramView;
                if (QLog.isColorLevel())
                {
                  QLog.d("qqBaseActivity", 2, "encode url failed, because UTF-8 is unknown");
                  paramAdapterView = paramView;
                }
              }
            }
          }
          if (paramInt != 2) {
            break;
          }
          r();
          b(1001);
        } while (this.jdField_g_of_type_Int != 2);
        c(1001);
        return;
        if (paramInt == 4)
        {
          paramAdapterView = new Intent("android.intent.action.VIEW", Uri.parse(paramAdapterView));
          paramAdapterView.putExtra("normal", true);
          try
          {
            startActivity(paramAdapterView);
            c(1006);
            return;
          }
          catch (ActivityNotFoundException paramAdapterView)
          {
            ybk.a(1, 2131695733);
            return;
          }
        }
        if (paramInt != 3) {
          break;
        }
        mwe.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this, this.jdField_i_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_h_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString);
        b(1002);
      } while (this.jdField_g_of_type_Int != 2);
      c(1002);
      return;
      if (paramInt == 6)
      {
        a(paramAdapterView, true);
        c(1007);
        return;
      }
    } while ((paramInt != 9) && (paramInt != 10));
    if (paramInt == 9)
    {
      b(1003);
      if (this.jdField_g_of_type_Int == 2) {
        c(1003);
      }
    }
    for (;;)
    {
      tpp.a(this, this.jdField_g_of_type_JavaLangString, this.jdField_h_of_type_JavaLangString, paramAdapterView, this.jdField_a_of_type_AndroidGraphicsBitmap, paramInt);
      return;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.publicAccountImageCollection.PublicAccountImageCollectionMainActivity
 * JD-Core Version:    0.7.0.1
 */