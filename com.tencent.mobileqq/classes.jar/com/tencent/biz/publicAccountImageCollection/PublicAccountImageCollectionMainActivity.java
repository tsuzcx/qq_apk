package com.tencent.biz.publicAccountImageCollection;

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
import com.tencent.av.utils.ShareUtils;
import com.tencent.biz.pubaccount.PublicAccountArticleHandler;
import com.tencent.biz.pubaccount.PublicAccountArticleObserver;
import com.tencent.biz.pubaccount.PublicAccountBrowser.ActionSheetItem;
import com.tencent.biz.pubaccount.PublicAccountBrowser.ActionSheetItemAdapter;
import com.tencent.biz.pubaccount.PublicAccountBrowser.ActionSheetItemViewHolder;
import com.tencent.biz.pubaccount.PublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.view.imageloader.ImageManager;
import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.biz.widgets.ElasticHorScrView;
import com.tencent.common.app.AppInterface;
import com.tencent.image.RegionDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsShareMsg.Builder;
import com.tencent.mobileqq.structmsg.AbsStructMsgItem;
import com.tencent.mobileqq.structmsg.StructMsgElementFactory;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.open.base.MD5Utils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.VersionUtils;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import cooperation.qqfav.QfavBuilder;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;
import mqq.app.MobileQQ;
import mvv;
import mwn;
import mwo;
import mwp;
import mwq;
import mwr;
import mws;
import mwt;
import mwu;
import mww;
import mwx;
import mxj;
import mxk;
import mxl;
import mxm;
import mxn;
import mxo;
import mxp;

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
  public TextView a;
  private PublicAccountArticleHandler jdField_a_of_type_ComTencentBizPubaccountPublicAccountArticleHandler;
  private PublicAccountArticleObserver jdField_a_of_type_ComTencentBizPubaccountPublicAccountArticleObserver;
  private PublicAccountImageCollectionListView jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageCollectionListView;
  private PublicAccountImageCollectionUtils.PhotoCollectionInfo jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageCollectionUtils$PhotoCollectionInfo;
  private PublicAccountImageView jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageView;
  public ElasticHorScrView a;
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  public ActionSheet a;
  public String a;
  private ArrayList jdField_a_of_type_JavaUtilArrayList;
  private mvv jdField_a_of_type_Mvv;
  public float[] a;
  float jdField_b_of_type_Float;
  public Matrix b;
  private Handler jdField_b_of_type_AndroidOsHandler;
  public ViewGroup b;
  private TranslateAnimation jdField_b_of_type_AndroidViewAnimationTranslateAnimation;
  ImageView jdField_b_of_type_AndroidWidgetImageView;
  public TextView b;
  public ElasticHorScrView b;
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
  public ImageView e;
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
    this.jdField_a_of_type_AndroidOsHandler = new mwt(this);
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
    View localView = super.getLayoutInflater().inflate(2130968984, null);
    this.jdField_a_of_type_ComTencentBizWidgetsElasticHorScrView = ((ElasticHorScrView)localView.findViewById(2131363794));
    this.jdField_b_of_type_ComTencentBizWidgetsElasticHorScrView = ((ElasticHorScrView)localView.findViewById(2131363796));
    if (paramInt == 1) {
      this.jdField_b_of_type_ComTencentBizWidgetsElasticHorScrView.setVisibility(8);
    }
    GridView localGridView2 = (GridView)localView.findViewById(2131363795);
    GridView localGridView1 = (GridView)localView.findViewById(2131363797);
    Object localObject1 = (TextView)localView.findViewById(2131362797);
    Object localObject2 = (LinearLayout.LayoutParams)((TextView)localObject1).getLayoutParams();
    ((LinearLayout.LayoutParams)localObject2).topMargin = ((int)(13.0F * this.jdField_b_of_type_Float));
    ((TextView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
    ((TextView)localObject1).setText(2131432998);
    ((TextView)localObject1).setOnClickListener(new mwp(this));
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
      localGridView2.setAdapter(new PublicAccountBrowser.ActionSheetItemAdapter(this, 0, (List)localObject1));
      localGridView2.setSelector(new ColorDrawable(0));
      localGridView2.setOnItemClickListener(this);
      paramInt = localLayoutParams.width;
      this.jdField_f_of_type_Int = paramInt;
      int n = ((List)localObject2).size();
      localObject1 = localGridView1.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject1).width = ((int)((n * 75 + (n - 1) * 10 + 3) * this.jdField_b_of_type_Float));
      localGridView1.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      localGridView1.setNumColumns(n);
      localGridView1.setAdapter(new PublicAccountBrowser.ActionSheetItemAdapter(this, 0, (List)localObject2));
      localGridView1.setSelector(new ColorDrawable(0));
      localGridView1.setOnItemClickListener(this);
      n = ((ViewGroup.LayoutParams)localObject1).width;
      this.jdField_e_of_type_Int = n;
      localView.post(new mwq(this, paramInt, n));
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
    Dialog localDialog = new Dialog(this, 2131624483);
    localDialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
    localDialog.setContentView(2130969212);
    if (!paramBoolean) {
      if (paramInt == 6) {
        ((TextView)localDialog.findViewById(2131365597)).setText(2131438536);
      }
    }
    for (;;)
    {
      localDialog.show();
      this.jdField_b_of_type_AndroidOsHandler.postDelayed(new mwo(this, localDialog), 1000L);
      return;
      if (paramInt == 10)
      {
        ((TextView)localDialog.findViewById(2131365597)).setText(2131438537);
      }
      else
      {
        ((TextView)localDialog.findViewById(2131365597)).setText(2131438535);
        continue;
        this.jdField_c_of_type_Boolean = false;
      }
    }
  }
  
  private List[] a()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = new PublicAccountBrowser.ActionSheetItem();
    ((PublicAccountBrowser.ActionSheetItem)localObject).jdField_a_of_type_JavaLangString = super.getString(2131430091);
    ((PublicAccountBrowser.ActionSheetItem)localObject).jdField_a_of_type_Int = 2130838332;
    ((PublicAccountBrowser.ActionSheetItem)localObject).jdField_a_of_type_Boolean = true;
    ((PublicAccountBrowser.ActionSheetItem)localObject).jdField_b_of_type_Int = 2;
    ((PublicAccountBrowser.ActionSheetItem)localObject).jdField_b_of_type_JavaLangString = "";
    localArrayList.add(localObject);
    localObject = new PublicAccountBrowser.ActionSheetItem();
    ((PublicAccountBrowser.ActionSheetItem)localObject).jdField_a_of_type_JavaLangString = super.getString(2131430097);
    ((PublicAccountBrowser.ActionSheetItem)localObject).jdField_a_of_type_Int = 2130838333;
    ((PublicAccountBrowser.ActionSheetItem)localObject).jdField_a_of_type_Boolean = true;
    ((PublicAccountBrowser.ActionSheetItem)localObject).jdField_b_of_type_Int = 3;
    ((PublicAccountBrowser.ActionSheetItem)localObject).jdField_b_of_type_JavaLangString = "";
    localArrayList.add(localObject);
    localObject = new PublicAccountBrowser.ActionSheetItem();
    ((PublicAccountBrowser.ActionSheetItem)localObject).jdField_a_of_type_JavaLangString = super.getString(2131430109);
    ((PublicAccountBrowser.ActionSheetItem)localObject).jdField_a_of_type_Int = 2130838336;
    ((PublicAccountBrowser.ActionSheetItem)localObject).jdField_b_of_type_Int = 9;
    ((PublicAccountBrowser.ActionSheetItem)localObject).jdField_b_of_type_JavaLangString = "";
    localArrayList.add(localObject);
    localObject = new PublicAccountBrowser.ActionSheetItem();
    ((PublicAccountBrowser.ActionSheetItem)localObject).jdField_a_of_type_JavaLangString = super.getString(2131430110);
    ((PublicAccountBrowser.ActionSheetItem)localObject).jdField_a_of_type_Int = 2130838330;
    ((PublicAccountBrowser.ActionSheetItem)localObject).jdField_b_of_type_Int = 10;
    ((PublicAccountBrowser.ActionSheetItem)localObject).jdField_b_of_type_JavaLangString = "";
    localArrayList.add(localObject);
    localObject = new PublicAccountBrowser.ActionSheetItem();
    ((PublicAccountBrowser.ActionSheetItem)localObject).jdField_a_of_type_JavaLangString = super.getString(2131430095);
    ((PublicAccountBrowser.ActionSheetItem)localObject).jdField_a_of_type_Boolean = true;
    ((PublicAccountBrowser.ActionSheetItem)localObject).jdField_a_of_type_Int = 2130840650;
    ((PublicAccountBrowser.ActionSheetItem)localObject).jdField_b_of_type_Int = 4;
    ((PublicAccountBrowser.ActionSheetItem)localObject).jdField_b_of_type_JavaLangString = "";
    localArrayList.add(localObject);
    localObject = new ArrayList();
    PublicAccountBrowser.ActionSheetItem localActionSheetItem = new PublicAccountBrowser.ActionSheetItem();
    localActionSheetItem.jdField_a_of_type_JavaLangString = super.getString(2131430107);
    localActionSheetItem.jdField_a_of_type_Boolean = true;
    localActionSheetItem.jdField_a_of_type_Int = 2130841536;
    localActionSheetItem.jdField_b_of_type_Int = 6;
    localActionSheetItem.jdField_b_of_type_JavaLangString = "";
    ((ArrayList)localObject).add(localActionSheetItem);
    localActionSheetItem = new PublicAccountBrowser.ActionSheetItem();
    localActionSheetItem.jdField_a_of_type_JavaLangString = super.getString(2131430093);
    localActionSheetItem.jdField_a_of_type_Int = 2130838328;
    localActionSheetItem.jdField_a_of_type_Boolean = true;
    localActionSheetItem.jdField_b_of_type_Int = 1;
    localActionSheetItem.jdField_b_of_type_JavaLangString = "";
    ((ArrayList)localObject).add(localActionSheetItem);
    localActionSheetItem = new PublicAccountBrowser.ActionSheetItem();
    localActionSheetItem.jdField_a_of_type_JavaLangString = super.getString(2131430094);
    localActionSheetItem.jdField_a_of_type_Int = 2130840641;
    localActionSheetItem.jdField_a_of_type_Boolean = true;
    localActionSheetItem.jdField_b_of_type_Int = 11;
    localActionSheetItem.jdField_b_of_type_JavaLangString = "";
    ((ArrayList)localObject).add(localActionSheetItem);
    return (List[])new ArrayList[] { localArrayList, localObject };
  }
  
  private void b(int paramInt)
  {
    PublicAccountReportUtils.a(null, this.jdField_a_of_type_JavaLangString, "0X8007A7A", "0X8007A7A", 0, 0, this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, "" + a(this.j), "" + paramInt, false);
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
    paramString.setURLDrawableListener(new mws(this, paramString));
    paramString.startDownload();
  }
  
  private void c(int paramInt)
  {
    PublicAccountReportUtils.a(null, this.jdField_a_of_type_JavaLangString, "0X8007C18", "0X8007C18", 0, 0, this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, "" + paramInt, "", false);
  }
  
  @TargetApi(11)
  private void j()
  {
    this.jdField_b_of_type_Float = getResources().getDisplayMetrics().density;
    a();
    this.jdField_b_of_type_AndroidOsHandler = new Handler();
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131365616));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131365617));
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)super.findViewById(2131365613));
    this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageCollectionListView = ((PublicAccountImageCollectionListView)super.findViewById(2131365614));
    this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageCollectionListView.setVerticalScrollBarEnabled(false);
    this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageCollectionListView.setDividerHeight(0);
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)getWindow().getDecorView());
    this.jdField_a_of_type_Mvv = new mvv(this, this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageCollectionListView, (QQAppInterface)super.getAppInterface());
    this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageCollectionListView.setSmoothScrollbarEnabled(false);
    this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageCollectionListView.setOnTouchListener(new mwn(this));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)super.findViewById(2131365626));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131365619));
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131365625));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131365624));
    this.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131365623));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131365622));
    this.jdField_f_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131365621));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131365620));
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
    this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountArticleHandler = ((PublicAccountArticleHandler)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getBusinessHandler(93));
    this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountArticleObserver = new mwx(this);
    this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountArticleHandler.a(this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountArticleObserver);
  }
  
  private void l()
  {
    if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))
    {
      if (QLog.isColorLevel()) {
        QLog.d("qqBaseActivity", 2, "fetchAllArticleInfo");
      }
      o();
      ThreadManager.executeOnSubThread(new mxj(this));
    }
  }
  
  private void m()
  {
    if (this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageCollectionUtils$PhotoCollectionInfo == null) {
      return;
    }
    this.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageCollectionUtils$PhotoCollectionInfo.jdField_b_of_type_JavaLangString;
    this.jdField_g_of_type_JavaLangString = this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageCollectionUtils$PhotoCollectionInfo.jdField_e_of_type_JavaLangString;
    this.jdField_i_of_type_JavaLangString = this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageCollectionUtils$PhotoCollectionInfo.jdField_d_of_type_JavaLangString;
    this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageCollectionUtils$PhotoCollectionInfo.jdField_c_of_type_JavaLangString;
    if (TextUtils.isEmpty(this.jdField_h_of_type_JavaLangString)) {
      this.jdField_h_of_type_JavaLangString = "来自QQ看点的分享";
    }
    this.jdField_b_of_type_AndroidOsHandler.postDelayed(new mxk(this), 0L);
    i();
    b(this.jdField_i_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountArticleHandler.a(this.jdField_c_of_type_JavaLangString);
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
    this.jdField_a_of_type_Mvv.a(this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageCollectionUtils$PhotoCollectionInfo);
    this.jdField_a_of_type_Mvv.a(this.jdField_a_of_type_JavaUtilArrayList);
    this.jdField_a_of_type_Mvv.a(this.jdField_b_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageCollectionListView.setAdapter(this.jdField_a_of_type_Mvv);
  }
  
  private void o()
  {
    this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageCollectionUtils$PhotoCollectionInfo = PublicAccountImageCollectionPreloadManager.a().a(this.jdField_b_of_type_JavaLangString);
    if (this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageCollectionUtils$PhotoCollectionInfo != null)
    {
      PublicAccountImageCollectionPreloadManager.a().a(true);
      m();
      PublicAccountImageCollectionPreloadManager.a().a(this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountArticleObserver);
      return;
    }
    if (FileUtils.b(AppConstants.ct + this.jdField_b_of_type_JavaLangString))
    {
      PublicAccountImageCollectionPreloadManager.a().a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountArticleObserver);
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
    PublicAccountReportUtils.a(null, this.jdField_a_of_type_JavaLangString, "0X8007B9A", "0X8007B9A", 0, 0, this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, "", "", false);
  }
  
  private void r()
  {
    Object localObject1 = "mqqapi://readinjoy/apenalbum?src_type=app&version=1&articleid=" + this.jdField_b_of_type_JavaLangString;
    localObject1 = new AbsShareMsg.Builder(StructMsgForGeneralShare.class).b(79).a("web", this.jdField_c_of_type_JavaLangString, (String)localObject1, "", "").a("[分享]" + this.jdField_g_of_type_JavaLangString).a();
    Object localObject2 = this.jdField_i_of_type_JavaLangString;
    AbsStructMsgItem localAbsStructMsgItem = StructMsgElementFactory.a(2);
    localAbsStructMsgItem.a((String)localObject2, this.jdField_g_of_type_JavaLangString, this.jdField_h_of_type_JavaLangString);
    ((AbsShareMsg)localObject1).addItem(localAbsStructMsgItem);
    localObject2 = new Intent();
    ((Intent)localObject2).putExtra("forward_thumb", this.jdField_i_of_type_JavaLangString);
    ((Intent)localObject2).putExtra("forward_type", -3);
    ((Intent)localObject2).putExtra("stuctmsg_bytes", ((AbsShareMsg)localObject1).getBytes());
    ForwardBaseOption.a(this, (Intent)localObject2, 21);
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
      int n = getResources().getColor(2131492923);
      this.mSystemBarComp.setStatusColor(n);
      this.mSystemBarComp.setStatusBarColor(n);
    }
    if ((VersionUtils.g()) && (VersionUtils.e())) {
      getWindow().getDecorView().setSystemUiVisibility(4102);
    }
    if (VersionUtils.e()) {
      getWindow().getDecorView().setOnSystemUiVisibilityChangeListener(new mww(this));
    }
  }
  
  public void a(int paramInt)
  {
    if ((isFinishing()) || (this.jdField_a_of_type_Mvv == null)) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentWidgetActionSheet == null)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet = ((ActionSheet)ActionSheetHelper.a(this, null));
      View localView1 = a(paramInt);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.a(localView1, null);
    }
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_ComTencentWidgetActionSheet.isShowing()) {
          break;
        }
        this.jdField_a_of_type_ComTencentWidgetActionSheet.show();
        if (paramInt != 2) {
          break label126;
        }
        this.jdField_g_of_type_Int = 2;
        PublicAccountReportUtils.a(null, this.jdField_a_of_type_JavaLangString, "0X8007A79", "0X8007A79", 0, 0, this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, "", "", false);
        return;
      }
      catch (Exception localException)
      {
        return;
      }
      View localView2 = a(paramInt);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.a(localView2, null);
    }
    label126:
    this.jdField_g_of_type_Int = 1;
    PublicAccountReportUtils.a(null, this.jdField_a_of_type_JavaLangString, "0X8007A80", "0X8007A80", 0, 0, this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, "", "", false);
  }
  
  public void a(int paramInt1, int paramInt2, String paramString)
  {
    int n;
    if (!this.jdField_e_of_type_Boolean)
    {
      this.jdField_e_of_type_Boolean = true;
      if (this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageCollectionUtils$PhotoCollectionInfo != null)
      {
        n = (int)(System.currentTimeMillis() - this.jdField_a_of_type_Long);
        this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountArticleHandler.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageCollectionUtils$PhotoCollectionInfo.jdField_b_of_type_JavaLangString, paramInt1, paramInt2, paramString, n, this.jdField_a_of_type_JavaUtilArrayList);
        if (this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageCollectionUtils$PhotoCollectionInfo.jdField_a_of_type_JavaUtilArrayList == null) {
          break label183;
        }
        paramString = this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageCollectionUtils$PhotoCollectionInfo.jdField_a_of_type_JavaUtilArrayList.iterator();
        paramInt1 = 0;
        while (paramString.hasNext())
        {
          if (!((PublicAccountImageCollectionUtils.PhotoItemInfo)paramString.next()).jdField_a_of_type_Boolean) {
            break label180;
          }
          paramInt1 += 1;
        }
      }
    }
    for (;;)
    {
      PublicAccountReportUtils.a(null, this.jdField_a_of_type_JavaLangString, "0X8007B8B", "0X8007B8B", 0, 0, this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, "" + n, "" + paramInt1, false);
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
    QfavBuilder.a(paramString).c(str).b(this, str, 101, null);
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
    if ((this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageCollectionUtils$PhotoCollectionInfo != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageCollectionUtils$PhotoCollectionInfo.jdField_b_of_type_JavaLangString)))
    {
      Intent localIntent = new Intent(this, QQBrowserActivity.class);
      localIntent.putExtra("url", this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageCollectionUtils$PhotoCollectionInfo.jdField_f_of_type_JavaLangString);
      localIntent.putExtra("hide_more_button", true);
      startActivity(localIntent);
    }
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    switch (paramInt1)
    {
    }
    do
    {
      do
      {
        return;
        QfavBuilder.a(this, paramIntent);
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
    a(getString(2131438797));
    ThreadManager.executeOnSubThread(new mwr(this));
  }
  
  public void doOnBackPressed()
  {
    a(1, 0, "");
    super.doOnBackPressed();
    PublicAccountReportUtils.a(null, this.jdField_a_of_type_JavaLangString, "0X8007B8F", "0X8007B8F", 0, 0, this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, "", "", false);
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    this.mNeedStatusTrans = false;
    this.mActNeedImmersive = false;
    super.doOnCreate(paramBundle);
    super.setContentView(2130969215);
    j();
    n();
    k();
    l();
    this.jdField_a_of_type_AndroidViewScaleGestureDetector = new ScaleGestureDetector(this, new mxp(this, null));
    this.jdField_a_of_type_AndroidContentContext = getBaseContext();
    if (VersionUtils.d()) {
      getWindow().setFlags(16777216, 16777216);
    }
    PublicAccountImageCollectionActivityManager.a().a(this);
    PublicAccountImageCollectionActivityManager.a().a();
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
    if (this.jdField_a_of_type_Mvv != null) {
      this.jdField_a_of_type_Mvv.a();
    }
    if (this.jdField_a_of_type_AndroidContentContext != null) {
      this.jdField_a_of_type_AndroidContentContext = null;
    }
    if (this.jdField_a_of_type_AndroidOsHandler != null)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_AndroidOsHandler = null;
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountArticleHandler != null)
    {
      if (PublicAccountImageCollectionActivityManager.a().a() == 1) {
        this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountArticleHandler.b();
      }
      this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountArticleHandler = null;
    }
    p();
    ImageManager.a().a();
    PublicAccountImageCollectionActivityManager.a().b(this);
    PublicAccountImageCollectionPreloadManager.a().b();
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    i();
    if (this.jdField_a_of_type_Mvv != null) {
      this.jdField_a_of_type_Mvv.b();
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
      this.jdField_e_of_type_AndroidWidgetImageView.setImageResource(2130839673);
      PublicAccountReportUtils.a(null, this.jdField_a_of_type_JavaLangString, "0X8007B95", "0X8007B95", 0, 0, this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, "", "", false);
    }
    for (;;)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setText("" + this.k);
      this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountArticleHandler.a(this.jdField_b_of_type_JavaLangString, this.jdField_b_of_type_Boolean, false);
      return;
      bool = false;
      break;
      label121:
      this.k -= 1;
      this.jdField_e_of_type_AndroidWidgetImageView.setImageResource(2130839672);
      PublicAccountReportUtils.a(null, this.jdField_a_of_type_JavaLangString, "0X8007B96", "0X8007B96", 0, 0, this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, "", "", false);
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
    this.jdField_b_of_type_AndroidOsHandler.post(new mxl(this));
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
    this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.setAnimationListener(new mxm(this));
    this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation.setAnimationListener(new mxn(this));
    this.jdField_b_of_type_AndroidOsHandler.postDelayed(new mxo(this), 300L);
  }
  
  void i()
  {
    ThreadManager.post(new mwu(this), 5, null, true);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    case 2131365618: 
    default: 
      return;
    case 2131365616: 
      doOnBackPressed();
    case 2131365617: 
      b();
      return;
    case 2131365619: 
      c();
      return;
    case 2131365623: 
      e();
      return;
    case 2131365622: 
      e();
      return;
    case 2131365625: 
      d();
      return;
    case 2131365624: 
      d();
      return;
    case 2131365621: 
      f();
      return;
    }
    c();
  }
  
  public void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
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
          if (this.jdField_a_of_type_ComTencentWidgetActionSheet.isShowing()) {
            this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
          }
          paramInt = ((PublicAccountBrowser.ActionSheetItemViewHolder)paramAdapterView).a.jdField_b_of_type_Int;
          paramAdapterView = this.jdField_c_of_type_JavaLangString;
          if (paramInt == 1)
          {
            ((ClipboardManager)getSystemService("clipboard")).setText(paramAdapterView);
            QRUtils.a(2, 2131429988);
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
              String str = MD5Utils.b(paramAdapterView + 200 + paramView + "jubao@article@123").toLowerCase();
              paramAdapterView = "http://jubao.mp.qq.com/mobile/report?qq=" + this.jdField_d_of_type_JavaLangString + "&mp_uin=" + this.jdField_a_of_type_JavaLangString + "&scene=200&sub_appname=article_webview&timestamp=" + paramView + "&sign=" + str + "&article_url=" + paramAdapterView;
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
            QRUtils.a(1, 2131430011);
            return;
          }
        }
        if (paramInt != 3) {
          break;
        }
        ShareUtils.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this, this.jdField_i_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_h_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString);
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
      PublicAccountImageCollectionUtils.a(this, this.jdField_g_of_type_JavaLangString, this.jdField_h_of_type_JavaLangString, paramAdapterView, this.jdField_a_of_type_AndroidGraphicsBitmap, paramInt);
      return;
      b(1004);
      if (this.jdField_g_of_type_Int == 2) {
        c(1004);
      }
    }
  }
  
  protected void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
    getWindow().setFormat(-3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.publicAccountImageCollection.PublicAccountImageCollectionMainActivity
 * JD-Core Version:    0.7.0.1
 */