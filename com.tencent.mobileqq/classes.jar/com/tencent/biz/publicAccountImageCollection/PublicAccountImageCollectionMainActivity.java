package com.tencent.biz.publicAccountImageCollection;

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
import com.tencent.av.utils.ShareUtils;
import com.tencent.biz.pubaccount.PublicAccountArticleHandler;
import com.tencent.biz.pubaccount.PublicAccountArticleObserver;
import com.tencent.biz.pubaccount.api.IPublicAccountBrowser.ActionSheetItem;
import com.tencent.biz.pubaccount.api.IPublicAccountBrowser.ActionSheetItemAdapter;
import com.tencent.biz.pubaccount.api.IPublicAccountBrowser.ActionSheetItemViewHolder;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
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
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsShareMsg.Builder;
import com.tencent.mobileqq.structmsg.AbsStructMsgItem;
import com.tencent.mobileqq.structmsg.StructMsgElementFactory;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.open.base.MD5Utils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
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
import mqq.app.MobileQQ;

public class PublicAccountImageCollectionMainActivity
  extends BaseActivity
  implements View.OnClickListener, AdapterView.OnItemClickListener
{
  public static boolean a;
  public static int b;
  public static int c;
  public static int d;
  float jdField_a_of_type_Float;
  int jdField_a_of_type_Int = 1;
  private long jdField_a_of_type_Long;
  private AnimatorSet jdField_a_of_type_AndroidAnimationAnimatorSet;
  Context jdField_a_of_type_AndroidContentContext;
  Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  Matrix jdField_a_of_type_AndroidGraphicsMatrix = new Matrix();
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  protected Handler a;
  ScaleGestureDetector jdField_a_of_type_AndroidViewScaleGestureDetector;
  ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private TranslateAnimation jdField_a_of_type_AndroidViewAnimationTranslateAnimation;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  private PublicAccountArticleHandler jdField_a_of_type_ComTencentBizPubaccountPublicAccountArticleHandler;
  private PublicAccountArticleObserver jdField_a_of_type_ComTencentBizPubaccountPublicAccountArticleObserver;
  private PublicAccountImageCollectionAdapter jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageCollectionAdapter = null;
  private PublicAccountImageCollectionListView jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageCollectionListView = null;
  private PublicAccountImageCollectionUtils.PhotoCollectionInfo jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageCollectionUtils$PhotoCollectionInfo;
  private PublicAccountImageView jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageView;
  ElasticHorScrView jdField_a_of_type_ComTencentBizWidgetsElasticHorScrView;
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  ActionSheet jdField_a_of_type_ComTencentWidgetActionSheet;
  public String a;
  private ArrayList<PublicAccountImageCollectionUtils.RecommendItemInfo> jdField_a_of_type_JavaUtilArrayList;
  float[] jdField_a_of_type_ArrayOfFloat = new float[9];
  float jdField_b_of_type_Float;
  Matrix jdField_b_of_type_AndroidGraphicsMatrix = new Matrix();
  private Handler jdField_b_of_type_AndroidOsHandler = null;
  ViewGroup jdField_b_of_type_AndroidViewViewGroup;
  private TranslateAnimation jdField_b_of_type_AndroidViewAnimationTranslateAnimation;
  ImageView jdField_b_of_type_AndroidWidgetImageView;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  ElasticHorScrView jdField_b_of_type_ComTencentBizWidgetsElasticHorScrView;
  public String b;
  private boolean jdField_b_of_type_Boolean;
  float[] jdField_b_of_type_ArrayOfFloat = new float[9];
  Matrix jdField_c_of_type_AndroidGraphicsMatrix;
  ImageView jdField_c_of_type_AndroidWidgetImageView;
  TextView jdField_c_of_type_AndroidWidgetTextView;
  public String c;
  private boolean jdField_c_of_type_Boolean = false;
  ImageView jdField_d_of_type_AndroidWidgetImageView;
  private String jdField_d_of_type_JavaLangString = "";
  private boolean jdField_d_of_type_Boolean;
  int jdField_e_of_type_Int;
  ImageView jdField_e_of_type_AndroidWidgetImageView;
  private String jdField_e_of_type_JavaLangString = "";
  private boolean jdField_e_of_type_Boolean;
  int jdField_f_of_type_Int;
  ImageView jdField_f_of_type_AndroidWidgetImageView;
  private String jdField_f_of_type_JavaLangString = null;
  private boolean jdField_f_of_type_Boolean = false;
  int jdField_g_of_type_Int;
  private String jdField_g_of_type_JavaLangString = "";
  private boolean jdField_g_of_type_Boolean = false;
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
    jdField_a_of_type_Boolean = false;
    jdField_b_of_type_Int = 2;
    jdField_c_of_type_Int = 3;
    jdField_d_of_type_Int = 4;
  }
  
  public PublicAccountImageCollectionMainActivity()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_a_of_type_AndroidOsHandler = new PublicAccountImageCollectionMainActivity.15(this);
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
    View localView = super.getLayoutInflater().inflate(2131559223, null);
    this.jdField_a_of_type_ComTencentBizWidgetsElasticHorScrView = ((ElasticHorScrView)localView.findViewById(2131377564));
    this.jdField_b_of_type_ComTencentBizWidgetsElasticHorScrView = ((ElasticHorScrView)localView.findViewById(2131377565));
    if (paramInt == 1) {
      this.jdField_b_of_type_ComTencentBizWidgetsElasticHorScrView.setVisibility(8);
    }
    GridView localGridView2 = (GridView)localView.findViewById(2131368059);
    GridView localGridView1 = (GridView)localView.findViewById(2131368060);
    Object localObject1 = (TextView)localView.findViewById(2131361987);
    Object localObject2 = (LinearLayout.LayoutParams)((TextView)localObject1).getLayoutParams();
    ((LinearLayout.LayoutParams)localObject2).topMargin = ((int)(13.0F * this.jdField_b_of_type_Float));
    ((TextView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
    ((TextView)localObject1).setText(2131690800);
    ((TextView)localObject1).setOnClickListener(new PublicAccountImageCollectionMainActivity.11(this));
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
      localGridView2.setAdapter(new IPublicAccountBrowser.ActionSheetItemAdapter(this, 0, (List)localObject1));
      localGridView2.setSelector(new ColorDrawable(0));
      localGridView2.setOnItemClickListener(this);
      paramInt = localLayoutParams.width;
      this.jdField_f_of_type_Int = paramInt;
      int n = ((List)localObject2).size();
      localObject1 = localGridView1.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject1).width = ((int)((n * 75 + (n - 1) * 10 + 3) * this.jdField_b_of_type_Float));
      localGridView1.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      localGridView1.setNumColumns(n);
      localGridView1.setAdapter(new IPublicAccountBrowser.ActionSheetItemAdapter(this, 0, (List)localObject2));
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
    ReportDialog localReportDialog = new ReportDialog(this, 2131755582);
    localReportDialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
    localReportDialog.setContentView(2131559731);
    if (!paramBoolean) {
      if (paramInt == 6) {
        ((TextView)localReportDialog.findViewById(2131381971)).setText(2131695208);
      }
    }
    for (;;)
    {
      localReportDialog.show();
      this.jdField_b_of_type_AndroidOsHandler.postDelayed(new PublicAccountImageCollectionMainActivity.10(this, localReportDialog), 1000L);
      return;
      if (paramInt == 10)
      {
        ((TextView)localReportDialog.findViewById(2131381971)).setText(2131695207);
      }
      else
      {
        ((TextView)localReportDialog.findViewById(2131381971)).setText(2131695206);
        continue;
        this.jdField_c_of_type_Boolean = false;
      }
    }
  }
  
  private List<IPublicAccountBrowser.ActionSheetItem>[] a()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = new IPublicAccountBrowser.ActionSheetItem();
    ((IPublicAccountBrowser.ActionSheetItem)localObject).jdField_a_of_type_JavaLangString = super.getString(2131696380);
    ((IPublicAccountBrowser.ActionSheetItem)localObject).jdField_a_of_type_Int = 2130839214;
    ((IPublicAccountBrowser.ActionSheetItem)localObject).jdField_a_of_type_Boolean = true;
    ((IPublicAccountBrowser.ActionSheetItem)localObject).jdField_b_of_type_Int = 2;
    ((IPublicAccountBrowser.ActionSheetItem)localObject).jdField_b_of_type_JavaLangString = "";
    localArrayList.add(localObject);
    localObject = new IPublicAccountBrowser.ActionSheetItem();
    ((IPublicAccountBrowser.ActionSheetItem)localObject).jdField_a_of_type_JavaLangString = super.getString(2131696394);
    ((IPublicAccountBrowser.ActionSheetItem)localObject).jdField_a_of_type_Int = 2130839215;
    ((IPublicAccountBrowser.ActionSheetItem)localObject).jdField_a_of_type_Boolean = true;
    ((IPublicAccountBrowser.ActionSheetItem)localObject).jdField_b_of_type_Int = 3;
    ((IPublicAccountBrowser.ActionSheetItem)localObject).jdField_b_of_type_JavaLangString = "";
    localArrayList.add(localObject);
    localObject = new IPublicAccountBrowser.ActionSheetItem();
    ((IPublicAccountBrowser.ActionSheetItem)localObject).jdField_a_of_type_JavaLangString = super.getString(2131696401);
    ((IPublicAccountBrowser.ActionSheetItem)localObject).jdField_a_of_type_Int = 2130839218;
    ((IPublicAccountBrowser.ActionSheetItem)localObject).jdField_b_of_type_Int = 9;
    ((IPublicAccountBrowser.ActionSheetItem)localObject).jdField_b_of_type_JavaLangString = "";
    localArrayList.add(localObject);
    localObject = new IPublicAccountBrowser.ActionSheetItem();
    ((IPublicAccountBrowser.ActionSheetItem)localObject).jdField_a_of_type_JavaLangString = super.getString(2131696383);
    ((IPublicAccountBrowser.ActionSheetItem)localObject).jdField_a_of_type_Int = 2130839212;
    ((IPublicAccountBrowser.ActionSheetItem)localObject).jdField_b_of_type_Int = 10;
    ((IPublicAccountBrowser.ActionSheetItem)localObject).jdField_b_of_type_JavaLangString = "";
    localArrayList.add(localObject);
    localObject = new IPublicAccountBrowser.ActionSheetItem();
    ((IPublicAccountBrowser.ActionSheetItem)localObject).jdField_a_of_type_JavaLangString = super.getString(2131696377);
    ((IPublicAccountBrowser.ActionSheetItem)localObject).jdField_a_of_type_Boolean = true;
    ((IPublicAccountBrowser.ActionSheetItem)localObject).jdField_a_of_type_Int = 2130842837;
    ((IPublicAccountBrowser.ActionSheetItem)localObject).jdField_b_of_type_Int = 4;
    ((IPublicAccountBrowser.ActionSheetItem)localObject).jdField_b_of_type_JavaLangString = "";
    localArrayList.add(localObject);
    localObject = new ArrayList();
    IPublicAccountBrowser.ActionSheetItem localActionSheetItem = new IPublicAccountBrowser.ActionSheetItem();
    localActionSheetItem.jdField_a_of_type_JavaLangString = super.getString(2131696366);
    localActionSheetItem.jdField_a_of_type_Boolean = true;
    localActionSheetItem.jdField_a_of_type_Int = 2130844331;
    localActionSheetItem.jdField_b_of_type_Int = 6;
    localActionSheetItem.jdField_b_of_type_JavaLangString = "";
    ((ArrayList)localObject).add(localActionSheetItem);
    localActionSheetItem = new IPublicAccountBrowser.ActionSheetItem();
    localActionSheetItem.jdField_a_of_type_JavaLangString = super.getString(2131696372);
    localActionSheetItem.jdField_a_of_type_Int = 2130839210;
    localActionSheetItem.jdField_a_of_type_Boolean = true;
    localActionSheetItem.jdField_b_of_type_Int = 1;
    localActionSheetItem.jdField_b_of_type_JavaLangString = "";
    ((ArrayList)localObject).add(localActionSheetItem);
    localActionSheetItem = new IPublicAccountBrowser.ActionSheetItem();
    localActionSheetItem.jdField_a_of_type_JavaLangString = super.getString(2131696378);
    localActionSheetItem.jdField_a_of_type_Int = 2130842827;
    localActionSheetItem.jdField_a_of_type_Boolean = true;
    localActionSheetItem.jdField_b_of_type_Int = 11;
    localActionSheetItem.jdField_b_of_type_JavaLangString = "";
    ((ArrayList)localObject).add(localActionSheetItem);
    return (List[])new ArrayList[] { localArrayList, localObject };
  }
  
  private void b(int paramInt)
  {
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, this.jdField_a_of_type_JavaLangString, "0X8007A7A", "0X8007A7A", 0, 0, this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, "" + a(this.j), "" + paramInt, false);
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
    paramString.setURLDrawableListener(new PublicAccountImageCollectionMainActivity.14(this, paramString));
    paramString.startDownload();
  }
  
  private void c(int paramInt)
  {
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, this.jdField_a_of_type_JavaLangString, "0X8007C18", "0X8007C18", 0, 0, this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, "" + paramInt, "", false);
  }
  
  @TargetApi(11)
  private void j()
  {
    this.jdField_b_of_type_Float = getResources().getDisplayMetrics().density;
    a();
    this.jdField_b_of_type_AndroidOsHandler = new Handler();
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131368796));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131368797));
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)super.findViewById(2131377367));
    this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageCollectionListView = ((PublicAccountImageCollectionListView)super.findViewById(2131368789));
    this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageCollectionListView.setVerticalScrollBarEnabled(false);
    this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageCollectionListView.setDividerHeight(0);
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)getWindow().getDecorView());
    this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageCollectionAdapter = new PublicAccountImageCollectionAdapter(this, this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageCollectionListView, (QQAppInterface)super.getAppInterface());
    this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageCollectionListView.setSmoothScrollbarEnabled(false);
    this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageCollectionListView.setOnTouchListener(new PublicAccountImageCollectionMainActivity.1(this));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)super.findViewById(2131381046));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131368798));
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131368781));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131368780));
    this.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131368800));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131368799));
    this.jdField_f_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131368794));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131368782));
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
    this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountArticleHandler = ((PublicAccountArticleHandler)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getBusinessHandler(BusinessHandlerFactory.PUBLIC_ACCOUNT_VIDEO_HANDLER));
    this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountArticleObserver = new PublicAccountImageCollectionMainActivity.3(this);
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
      ThreadManager.executeOnSubThread(new PublicAccountImageCollectionMainActivity.4(this));
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
    this.jdField_b_of_type_AndroidOsHandler.postDelayed(new PublicAccountImageCollectionMainActivity.5(this), 0L);
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
    this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageCollectionAdapter.a(this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageCollectionUtils$PhotoCollectionInfo);
    this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageCollectionAdapter.a(this.jdField_a_of_type_JavaUtilArrayList);
    this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageCollectionAdapter.a(this.jdField_b_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageCollectionListView.setAdapter(this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageCollectionAdapter);
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
    if (FileUtils.b(AppConstants.SDCARD_PATH_PUBLIC_ACCOUNT_IMAGE_COLLECTION_PRELOAD + this.jdField_b_of_type_JavaLangString))
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
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, this.jdField_a_of_type_JavaLangString, "0X8007B9A", "0X8007B9A", 0, 0, this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, "", "", false);
  }
  
  private void r()
  {
    Object localObject1 = "mqqapi://readinjoy/apenalbum?src_type=app&version=1&articleid=" + this.jdField_b_of_type_JavaLangString;
    localObject1 = new AbsShareMsg.Builder(StructMsgForGeneralShare.class).c(79).a("web", this.jdField_c_of_type_JavaLangString, (String)localObject1, "", "").a(HardCodeUtil.a(2131708781) + this.jdField_g_of_type_JavaLangString).a();
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
      int n = getResources().getColor(2131167305);
      this.mSystemBarComp.setStatusColor(n);
      this.mSystemBarComp.setStatusBarColor(n);
    }
    if ((VersionUtils.g()) && (VersionUtils.e())) {
      getWindow().getDecorView().setSystemUiVisibility(4102);
    }
    if (VersionUtils.e()) {
      getWindow().getDecorView().setOnSystemUiVisibilityChangeListener(new PublicAccountImageCollectionMainActivity.2(this));
    }
  }
  
  public void a(int paramInt)
  {
    if ((isFinishing()) || (this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageCollectionAdapter == null)) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentWidgetActionSheet == null)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet = ((ActionSheet)ActionSheetHelper.a(this, null));
      View localView1 = a(paramInt);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.setActionContentView(localView1, null);
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
          break label137;
        }
        this.jdField_g_of_type_Int = 2;
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, this.jdField_a_of_type_JavaLangString, "0X8007A79", "0X8007A79", 0, 0, this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, "", "", false);
        return;
      }
      catch (Exception localException)
      {
        return;
      }
      View localView2 = a(paramInt);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.setActionContentView(localView2, null);
    }
    label137:
    this.jdField_g_of_type_Int = 1;
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, this.jdField_a_of_type_JavaLangString, "0X8007A80", "0X8007A80", 0, 0, this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, "", "", false);
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
          break label194;
        }
        paramString = this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageCollectionUtils$PhotoCollectionInfo.jdField_a_of_type_JavaUtilArrayList.iterator();
        paramInt1 = 0;
        while (paramString.hasNext())
        {
          if (!((PublicAccountImageCollectionUtils.PhotoItemInfo)paramString.next()).jdField_a_of_type_Boolean) {
            break label191;
          }
          paramInt1 += 1;
        }
      }
    }
    for (;;)
    {
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, this.jdField_a_of_type_JavaLangString, "0X8007B8B", "0X8007B8B", 0, 0, this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, "" + n, "" + paramInt1, false);
      return;
      label191:
      break;
      label194:
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
    a(getString(2131695204));
    ThreadManager.executeOnSubThread(new PublicAccountImageCollectionMainActivity.13(this));
  }
  
  public void doOnBackPressed()
  {
    a(1, 0, "");
    super.doOnBackPressed();
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, this.jdField_a_of_type_JavaLangString, "0X8007B8F", "0X8007B8F", 0, 0, this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, "", "", false);
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    this.mNeedStatusTrans = false;
    this.mActNeedImmersive = false;
    super.doOnCreate(paramBundle);
    super.setContentView(2131559734);
    j();
    n();
    k();
    l();
    this.jdField_a_of_type_AndroidViewScaleGestureDetector = new ScaleGestureDetector(this, new PublicAccountImageCollectionMainActivity.ScaleGestureListener(this, null));
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
    if (this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageCollectionAdapter != null) {
      this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageCollectionAdapter.a();
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
        this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountArticleHandler.a();
      }
      this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountArticleHandler = null;
    }
    p();
    ImageManager.a().a();
    PublicAccountImageCollectionActivityManager.a().b(this);
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
    if (this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageCollectionAdapter != null) {
      this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageCollectionAdapter.b();
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
        break label132;
      }
      this.k += 1;
      this.jdField_e_of_type_AndroidWidgetImageView.setImageResource(2130841796);
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, this.jdField_a_of_type_JavaLangString, "0X8007B95", "0X8007B95", 0, 0, this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, "", "", false);
    }
    for (;;)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setText("" + this.k);
      this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountArticleHandler.a(this.jdField_b_of_type_JavaLangString, this.jdField_b_of_type_Boolean, false);
      return;
      bool = false;
      break;
      label132:
      this.k -= 1;
      this.jdField_e_of_type_AndroidWidgetImageView.setImageResource(2130841795);
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, this.jdField_a_of_type_JavaLangString, "0X8007B96", "0X8007B96", 0, 0, this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, "", "", false);
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
    this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.setAnimationListener(new PublicAccountImageCollectionMainActivity.7(this));
    this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation.setAnimationListener(new PublicAccountImageCollectionMainActivity.8(this));
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
        if (this.jdField_a_of_type_ComTencentWidgetActionSheet.isShowing()) {
          this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
        }
        n = ((IPublicAccountBrowser.ActionSheetItemViewHolder)localObject1).a.jdField_b_of_type_Int;
        localObject1 = this.jdField_c_of_type_JavaLangString;
        if (n == 1)
        {
          ((ClipboardManager)getSystemService("clipboard")).setText((CharSequence)localObject1);
          QRUtils.a(2, 2131691374);
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
              QRUtils.a(1, 2131695226);
            }
          }
          else if (n == 3)
          {
            ShareUtils.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this, this.jdField_i_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_h_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString);
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
      PublicAccountImageCollectionUtils.a(this, this.jdField_g_of_type_JavaLangString, this.jdField_h_of_type_JavaLangString, localActivityNotFoundException, this.jdField_a_of_type_AndroidGraphicsBitmap, n);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.publicAccountImageCollection.PublicAccountImageCollectionMainActivity
 * JD-Core Version:    0.7.0.1
 */