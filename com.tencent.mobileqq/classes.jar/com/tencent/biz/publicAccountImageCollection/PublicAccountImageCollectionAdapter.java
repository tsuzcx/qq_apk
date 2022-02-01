package com.tencent.biz.publicAccountImageCollection;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.DisplayMetrics;
import android.util.LruCache;
import android.view.Display;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.api.IPublicAccountServlet;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAlphaMaskView;
import com.tencent.biz.pubaccount.readinjoy.view.imageloader.ImageRequest;
import com.tencent.biz.pubaccount.readinjoy.view.imageloader.ZImageView;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.PublicAccountDataManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.applets.NewPublicAccountObserver;
import com.tencent.mobileqq.applets.PublicAccountStateReporter;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.mobileqq.mp.mobileqq_mp.FollowRequest;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.widget.ImageProgressCircle;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ScaleGestureDetector.OnScaleGestureListener;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Formatter;
import mqq.app.NewIntent;

class PublicAccountImageCollectionAdapter
  extends BaseAdapter
  implements View.OnClickListener, ScaleGestureDetector.OnScaleGestureListener
{
  float jdField_a_of_type_Float;
  final int jdField_a_of_type_Int = 0;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Context jdField_a_of_type_AndroidContentContext;
  private LruCache<String, URL> jdField_a_of_type_AndroidUtilLruCache = null;
  private GestureDetector jdField_a_of_type_AndroidViewGestureDetector;
  View jdField_a_of_type_AndroidViewView;
  Button jdField_a_of_type_AndroidWidgetButton;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  private PublicAccountImageCollectionListView.ListViewEventListener jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageCollectionListView$ListViewEventListener = new PublicAccountImageCollectionAdapter.1(this);
  private PublicAccountImageCollectionListView jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageCollectionListView;
  private PublicAccountImageCollectionRecommendViewWrapper jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageCollectionRecommendViewWrapper;
  private PublicAccountImageCollectionUtils.PhotoCollectionInfo jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageCollectionUtils$PhotoCollectionInfo = null;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private NewPublicAccountObserver jdField_a_of_type_ComTencentMobileqqAppletsNewPublicAccountObserver;
  String jdField_a_of_type_JavaLangString = "";
  public ArrayList<PublicAccountImageCollectionUtils.PhotoItemInfo> a;
  boolean jdField_a_of_type_Boolean = false;
  final int jdField_b_of_type_Int = 1;
  private View jdField_b_of_type_AndroidViewView;
  String jdField_b_of_type_JavaLangString = "";
  private ArrayList<PublicAccountImageCollectionUtils.RecommendItemInfo> jdField_b_of_type_JavaUtilArrayList = null;
  boolean jdField_b_of_type_Boolean = false;
  final int jdField_c_of_type_Int = 2;
  String jdField_c_of_type_JavaLangString = "";
  boolean jdField_c_of_type_Boolean = false;
  int jdField_d_of_type_Int = 0;
  boolean jdField_d_of_type_Boolean = false;
  int jdField_e_of_type_Int;
  boolean jdField_e_of_type_Boolean = false;
  int jdField_f_of_type_Int;
  private boolean jdField_f_of_type_Boolean = true;
  private int jdField_g_of_type_Int;
  private boolean jdField_g_of_type_Boolean;
  
  public PublicAccountImageCollectionAdapter(Context paramContext, PublicAccountImageCollectionListView paramPublicAccountImageCollectionListView, QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaUtilArrayList = null;
    this.jdField_a_of_type_AndroidContentContext = paramContext.getApplicationContext();
    this.jdField_a_of_type_AndroidAppActivity = ((Activity)paramContext);
    this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageCollectionListView = paramPublicAccountImageCollectionListView;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageCollectionListView.a(this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageCollectionListView$ListViewEventListener);
    this.jdField_a_of_type_Float = this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageCollectionListView.getResources().getDisplayMetrics().density;
    if (a()) {}
    for (this.jdField_e_of_type_Int = (a()[1] - a());; this.jdField_e_of_type_Int = a()[1])
    {
      this.jdField_f_of_type_Int = a()[0];
      this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageCollectionListView.setScreenHeight(this.jdField_e_of_type_Int);
      this.jdField_a_of_type_AndroidUtilLruCache = new LruCache(15);
      a(paramContext);
      return;
    }
  }
  
  private int a()
  {
    Resources localResources = this.jdField_a_of_type_AndroidAppActivity.getResources();
    return localResources.getDimensionPixelSize(localResources.getIdentifier("status_bar_height", "dimen", "android"));
  }
  
  private void a(ZImageView paramZImageView, ImageRequest paramImageRequest, ImageProgressCircle paramImageProgressCircle, int paramInt)
  {
    ColorDrawable localColorDrawable = new ColorDrawable(Color.parseColor("#000000"));
    if ((paramImageRequest == null) || (paramImageRequest.jdField_a_of_type_JavaNetURL == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("PublicAccountImageCollectionAdapter", 2, "loadImage url is empty! use default preload image");
      }
      paramZImageView.setImageDrawable(localColorDrawable);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PublicAccountImageCollectionAdapter", 2, "loadImage url = " + paramImageRequest.jdField_a_of_type_JavaNetURL + " reqWidth = " + paramImageRequest.jdField_a_of_type_Int + " reqHeight = " + paramImageRequest.jdField_b_of_type_Int);
    }
    if (AbsDownloader.getFile(paramImageRequest.jdField_a_of_type_JavaNetURL.toString()) != null) {}
    for (boolean bool = true;; bool = false)
    {
      if (bool) {
        PublicAccountImageCollectionPreloadManager.a().a(true, paramInt);
      }
      for (;;)
      {
        long l = NetConnInfoCenter.getServerTimeMillis();
        paramZImageView.setImagePlaceHolder(localColorDrawable).setImageForImageCollection(paramImageRequest, new PublicAccountImageCollectionAdapter.6(this, bool, l, paramImageProgressCircle));
        return;
        PublicAccountImageCollectionPreloadManager.a().a(false, paramInt);
      }
    }
  }
  
  private void a(ImageProgressCircle paramImageProgressCircle)
  {
    if (paramImageProgressCircle == null) {}
    while (paramImageProgressCircle.getVisibility() == 4) {
      return;
    }
    paramImageProgressCircle.setVisibility(4);
  }
  
  private void a(ImageProgressCircle paramImageProgressCircle, int paramInt)
  {
    if (paramImageProgressCircle.getVisibility() != 0) {
      paramImageProgressCircle.setVisibility(0);
    }
    paramImageProgressCircle.setProgress(paramInt / 100);
  }
  
  private boolean a()
  {
    return Build.VERSION.SDK_INT < 19;
  }
  
  private int[] a()
  {
    int[] arrayOfInt = new int[2];
    Display localDisplay = this.jdField_a_of_type_AndroidAppActivity.getWindowManager().getDefaultDisplay();
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    try
    {
      Class.forName("android.view.Display").getMethod("getRealMetrics", new Class[] { DisplayMetrics.class }).invoke(localDisplay, new Object[] { localDisplayMetrics });
      arrayOfInt[0] = localDisplayMetrics.widthPixels;
      arrayOfInt[1] = localDisplayMetrics.heightPixels;
      return arrayOfInt;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return arrayOfInt;
  }
  
  private void b(int paramInt)
  {
    Toast.makeText(this.jdField_a_of_type_AndroidContentContext, paramInt, 0).show();
  }
  
  private void e()
  {
    if ((this.jdField_a_of_type_AndroidWidgetButton != null) && (this.jdField_a_of_type_Boolean))
    {
      this.jdField_a_of_type_AndroidWidgetButton.setText(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131695266));
      this.jdField_a_of_type_AndroidWidgetButton.setBackgroundDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130841822));
    }
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_AndroidWidgetButton != null)
    {
      if (!this.jdField_a_of_type_Boolean) {
        break label24;
      }
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
    }
    label24:
    while ((TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageCollectionUtils$PhotoCollectionInfo.jdField_c_of_type_JavaLangString)) || (this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageCollectionUtils$PhotoCollectionInfo.jdField_c_of_type_JavaLangString.equals("0"))) {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetButton.setBackgroundDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130839424));
    this.jdField_a_of_type_AndroidWidgetButton.setText(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131695267));
  }
  
  private void g()
  {
    int j = this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageCollectionListView.getLastVisiblePosition();
    int k = this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageCollectionListView.getFirstVisiblePosition();
    int i = 0;
    if (i <= j - k)
    {
      Object localObject = this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageCollectionListView.getChildAt(i);
      if ((((View)localObject).getTag() != null) && ((((View)localObject).getTag() instanceof PublicAccountImageCollectionAdapter.ImageItemHolder)))
      {
        localObject = (PublicAccountImageCollectionAdapter.ImageItemHolder)((View)localObject).getTag();
        if (((PublicAccountImageCollectionAdapter.ImageItemHolder)localObject).jdField_a_of_type_AndroidWidgetTextView.getVisibility() != 0) {
          break label97;
        }
        this.jdField_f_of_type_Boolean = false;
        ((PublicAccountImageCollectionAdapter.ImageItemHolder)localObject).jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      for (;;)
      {
        i += 1;
        break;
        label97:
        this.jdField_f_of_type_Boolean = true;
        ((PublicAccountImageCollectionAdapter.ImageItemHolder)localObject).jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      }
    }
    if (this.jdField_f_of_type_Boolean)
    {
      d(true);
      return;
    }
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, this.jdField_c_of_type_JavaLangString, "0X8007B92", "0X8007B92", 0, 0, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, "", "", false);
    d(false);
  }
  
  private void h()
  {
    if ((this.jdField_b_of_type_AndroidViewView == null) || (!(this.jdField_b_of_type_AndroidViewView.getTag() instanceof PublicAccountImageCollectionAdapter.ImageItemHolder))) {}
    Intent localIntent;
    Object localObject;
    float[] arrayOfFloat;
    String str;
    int i;
    int j;
    int k;
    int m;
    do
    {
      do
      {
        do
        {
          return;
        } while (!this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageCollectionListView.a(this.jdField_b_of_type_AndroidViewView).booleanValue());
        localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, PublicAccountImageCollectionActivity.class);
        localObject = ((ZImageView)((ViewGroup)this.jdField_b_of_type_AndroidViewView).getChildAt(0)).getImageMatrix();
        arrayOfFloat = new float[9];
        ((Matrix)localObject).getValues(arrayOfFloat);
      } while (this.jdField_a_of_type_JavaUtilArrayList == null);
      localObject = (PublicAccountImageCollectionUtils.PhotoItemInfo)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_d_of_type_Int - 1);
      str = ((PublicAccountImageCollectionUtils.PhotoItemInfo)localObject).jdField_a_of_type_JavaLangString;
      i = a(localObject)[0];
      j = a(localObject)[1];
      ZImageView localZImageView = (ZImageView)((ViewGroup)this.jdField_b_of_type_AndroidViewView).getChildAt(0);
      k = localZImageView.getWidth();
      m = localZImageView.getHeight();
    } while (TextUtils.isEmpty(str));
    localIntent.putExtra("doubleBitMapPath", str);
    localIntent.putExtra("urlImageHeight", j);
    localIntent.putExtra("urlImageWidth", i);
    localIntent.putExtra("urlImageWidthReal", k);
    localIntent.putExtra("urlImageHeightReal", m);
    localIntent.putExtra("imageMatrix", arrayOfFloat);
    this.jdField_a_of_type_AndroidAppActivity.startActivity(localIntent);
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, this.jdField_c_of_type_JavaLangString, "0X8007B91", "0X8007B91", 0, 0, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, ((PublicAccountImageCollectionUtils.PhotoItemInfo)localObject).jdField_a_of_type_JavaLangString, "2", false);
  }
  
  public URL a(String paramString)
  {
    URL localURL2 = (URL)this.jdField_a_of_type_AndroidUtilLruCache.get(paramString);
    Object localObject2 = localURL2;
    if (localURL2 == null) {}
    try
    {
      URL localURL1 = new URL(paramString);
      localObject2 = localURL2;
      if (localURL1 != null)
      {
        this.jdField_a_of_type_AndroidUtilLruCache.put(paramString, localURL1);
        localObject2 = localURL1;
      }
      return localObject2;
    }
    catch (MalformedURLException localMalformedURLException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PublicAccountImageCollectionAdapter", 2, "getURLPath ERROR e = " + localMalformedURLException.getMessage());
        }
        Object localObject1 = null;
      }
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidAppActivity != null) {
      this.jdField_a_of_type_AndroidAppActivity = null;
    }
    if (this.jdField_a_of_type_AndroidUtilLruCache != null) {
      this.jdField_a_of_type_AndroidUtilLruCache.evictAll();
    }
    if (this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageCollectionListView$ListViewEventListener != null) {
      this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageCollectionListView$ListViewEventListener = null;
    }
    if (this.jdField_b_of_type_AndroidViewView != null) {
      this.jdField_b_of_type_AndroidViewView = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppletsNewPublicAccountObserver);
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_g_of_type_Int = paramInt;
    String str;
    if (this.jdField_a_of_type_AndroidWidgetTextView != null)
    {
      str = "" + paramInt;
      if (paramInt <= 1000000) {
        break label77;
      }
      str = "100万+";
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131708757) + str);
      return;
      label77:
      if (paramInt > 100000)
      {
        double d1 = paramInt / 100000.0D;
        str = new Formatter().format("%.1f", new Object[] { Double.valueOf(d1) }).toString() + HardCodeUtil.a(2131708780);
      }
    }
  }
  
  void a(Context paramContext)
  {
    this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(paramContext, new PublicAccountImageCollectionAdapter.PublicAccountOnGestureListener(this, null));
  }
  
  void a(View paramView)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("PublicAccountImageCollectionAdapter", 2, "showMoreDescription");
    }
    paramView = (TextView)paramView;
    if (!this.jdField_e_of_type_Boolean)
    {
      paramView.setMaxLines(2147483647);
      paramView.setEllipsize(null);
      this.jdField_e_of_type_Boolean = true;
      return;
    }
    paramView.setMaxLines(3);
    paramView.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
    this.jdField_e_of_type_Boolean = false;
  }
  
  void a(PublicAccountImageCollectionAdapter.CoverHolder paramCoverHolder)
  {
    if (this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageCollectionUtils$PhotoCollectionInfo == null)
    {
      if (this.jdField_c_of_type_Boolean)
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("PublicAccountImageCollectionAdapter", 2, "setDataForImageCover getPhotoCollectionInfo error");
        }
        paramCoverHolder.f.setVisibility(0);
        a(paramCoverHolder.jdField_a_of_type_ComTencentMobileqqWidgetImageProgressCircle);
        ((PublicAccountImageCollectionMainActivity)this.jdField_a_of_type_AndroidAppActivity).g();
        return;
      }
      paramCoverHolder.f.setVisibility(8);
      return;
    }
    if ((this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageCollectionUtils$PhotoCollectionInfo.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageCollectionUtils$PhotoFirstItemInfo != null) && (QLog.isColorLevel())) {
      QLog.d("PublicAccountImageCollectionAdapter", 2, "setDataForImageCover title =" + this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageCollectionUtils$PhotoCollectionInfo.e + "; coverUrl =" + this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageCollectionUtils$PhotoCollectionInfo.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageCollectionUtils$PhotoFirstItemInfo.jdField_a_of_type_JavaLangString + "; accountName = " + this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageCollectionUtils$PhotoCollectionInfo.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageCollectionUtils$PhotoFirstItemInfo.jdField_b_of_type_JavaLangString + "; author=" + this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageCollectionUtils$PhotoCollectionInfo.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageCollectionUtils$PhotoFirstItemInfo.d + "; time =" + this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageCollectionUtils$PhotoCollectionInfo.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageCollectionUtils$PhotoFirstItemInfo.jdField_c_of_type_JavaLangString);
    }
    paramCoverHolder.jdField_a_of_type_AndroidViewView.setVisibility(0);
    paramCoverHolder.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageCollectionUtils$PhotoCollectionInfo.e);
    Object localObject = "" + this.jdField_g_of_type_Int;
    if (this.jdField_g_of_type_Int > 1000000)
    {
      localObject = "100万+";
      paramCoverHolder.e.setText(HardCodeUtil.a(2131708747) + (String)localObject);
      localObject = this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageCollectionUtils$PhotoCollectionInfo.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageCollectionUtils$PhotoFirstItemInfo;
      if (localObject != null)
      {
        paramCoverHolder.d.setText(((PublicAccountImageCollectionUtils.PhotoFirstItemInfo)localObject).jdField_b_of_type_JavaLangString);
        paramCoverHolder.b.setText(((PublicAccountImageCollectionUtils.PhotoFirstItemInfo)localObject).d);
        paramCoverHolder.c.setText(((PublicAccountImageCollectionUtils.PhotoFirstItemInfo)localObject).jdField_c_of_type_JavaLangString);
        if (TextUtils.isEmpty(((PublicAccountImageCollectionUtils.PhotoFirstItemInfo)localObject).jdField_b_of_type_JavaLangString)) {
          break label636;
        }
        paramCoverHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        paramCoverHolder.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(FaceDrawable.getFaceDrawable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageCollectionUtils$PhotoCollectionInfo.jdField_c_of_type_JavaLangString));
      }
    }
    for (;;)
    {
      ImageRequest localImageRequest = new ImageRequest();
      localImageRequest.jdField_a_of_type_JavaNetURL = a(((PublicAccountImageCollectionUtils.PhotoFirstItemInfo)localObject).jdField_a_of_type_JavaLangString);
      a(paramCoverHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderZImageView, localImageRequest, paramCoverHolder.jdField_a_of_type_ComTencentMobileqqWidgetImageProgressCircle, 0);
      if ((TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageCollectionUtils$PhotoCollectionInfo.jdField_c_of_type_JavaLangString)) || (this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageCollectionUtils$PhotoCollectionInfo.jdField_c_of_type_JavaLangString.equals("0")))
      {
        new RelativeLayout.LayoutParams(-1, -1).setMargins(AIOUtils.a(12.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), AIOUtils.a(25.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), 0, 0);
        paramCoverHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        paramCoverHolder.e.setTextSize(2, 14.0F);
        paramCoverHolder.d.setVisibility(8);
        paramCoverHolder.b.setTextSize(2, 14.0F);
        paramCoverHolder.c.setTextSize(2, 14.0F);
        this.jdField_a_of_type_AndroidViewView.setOnClickListener(null);
      }
      if (!this.jdField_b_of_type_Boolean) {
        ((PublicAccountImageCollectionMainActivity)this.jdField_a_of_type_AndroidAppActivity).h();
      }
      this.jdField_b_of_type_Boolean = true;
      return;
      if (this.jdField_g_of_type_Int <= 100000) {
        break;
      }
      double d1 = this.jdField_g_of_type_Int / 100000.0D;
      localObject = new Formatter().format("%.1f", new Object[] { Double.valueOf(d1) }).toString() + HardCodeUtil.a(2131708798);
      break;
      label636:
      paramCoverHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    }
  }
  
  void a(PublicAccountImageCollectionAdapter.ImageItemHolder paramImageItemHolder, int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      if (QLog.isColorLevel()) {
        QLog.d("PublicAccountImageCollectionAdapter", 2, "setDataForImageFeeds mPhotoItemInfo is null");
      }
    }
    PublicAccountImageCollectionUtils.PhotoItemInfo localPhotoItemInfo;
    int i;
    Object localObject;
    RelativeLayout.LayoutParams localLayoutParams;
    ViewGroup.LayoutParams localLayoutParams1;
    URL localURL;
    do
    {
      do
      {
        do
        {
          return;
        } while ((paramInt < 1) || (paramInt > this.jdField_a_of_type_JavaUtilArrayList.size()));
        localPhotoItemInfo = (PublicAccountImageCollectionUtils.PhotoItemInfo)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt - 1);
      } while ((localPhotoItemInfo == null) || (localPhotoItemInfo.jdField_a_of_type_Int == 0) || (this.jdField_f_of_type_Int == 0));
      if (localPhotoItemInfo.jdField_b_of_type_Int / localPhotoItemInfo.jdField_a_of_type_Int <= this.jdField_e_of_type_Int / this.jdField_f_of_type_Int) {
        break;
      }
      i = this.jdField_e_of_type_Int;
      localPhotoItemInfo.jdField_a_of_type_Boolean = true;
      localObject = (RelativeLayout.LayoutParams)paramImageItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderZImageView.getLayoutParams();
      localLayoutParams = (RelativeLayout.LayoutParams)paramImageItemHolder.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
      localLayoutParams1 = paramImageItemHolder.jdField_a_of_type_AndroidViewView.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).width = this.jdField_f_of_type_Int;
      ((RelativeLayout.LayoutParams)localObject).height = i;
      paramImageItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderZImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localURL = a(localPhotoItemInfo.jdField_a_of_type_JavaLangString);
    } while (localURL == null);
    ImageRequest localImageRequest = new ImageRequest();
    localImageRequest.jdField_a_of_type_JavaNetURL = localURL;
    localImageRequest.jdField_a_of_type_Int = a(localPhotoItemInfo)[0];
    localImageRequest.jdField_b_of_type_Int = a(localPhotoItemInfo)[1];
    a(paramImageItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderZImageView, localImageRequest, paramImageItemHolder.jdField_a_of_type_ComTencentMobileqqWidgetImageProgressCircle, paramImageItemHolder.jdField_a_of_type_Int);
    int j;
    if ((localPhotoItemInfo.jdField_a_of_type_Int / localPhotoItemInfo.jdField_b_of_type_Int > 1.3D) && (!TextUtils.isEmpty(localPhotoItemInfo.jdField_b_of_type_JavaLangString)) && (!localPhotoItemInfo.jdField_b_of_type_JavaLangString.equals(" ")))
    {
      j = 1;
      label290:
      if (j == 0) {
        break label594;
      }
      paramImageItemHolder.jdField_a_of_type_AndroidWidgetTextView.setMinHeight(AIOUtils.a(97.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      localLayoutParams1.height = (((RelativeLayout.LayoutParams)localObject).height + AIOUtils.a(97.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      paramImageItemHolder.jdField_a_of_type_AndroidWidgetTextView.setGravity(16);
      label348:
      if (i <= this.jdField_e_of_type_Int - (int)(88.0F * this.jdField_a_of_type_Float)) {
        break label616;
      }
      paramImageItemHolder.jdField_a_of_type_AndroidWidgetTextView.setPadding((int)(15.0F * this.jdField_a_of_type_Float), (int)(10.0F * this.jdField_a_of_type_Float), (int)(15.0F * this.jdField_a_of_type_Float), (int)(44.0F * this.jdField_a_of_type_Float));
      label409:
      paramImageItemHolder.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams(localLayoutParams);
      paramImageItemHolder.jdField_a_of_type_AndroidViewView.setLayoutParams(localLayoutParams1);
      paramImageItemHolder.jdField_a_of_type_AndroidWidgetTextView.setMaxLines(3);
      paramImageItemHolder.jdField_a_of_type_AndroidWidgetTextView.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
      localObject = paramInt + "/" + this.jdField_a_of_type_JavaUtilArrayList.size() + "  " + localPhotoItemInfo.jdField_b_of_type_JavaLangString;
      paramImageItemHolder.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      if ((!TextUtils.isEmpty(localPhotoItemInfo.jdField_b_of_type_JavaLangString)) && (!localPhotoItemInfo.jdField_b_of_type_JavaLangString.equals(" "))) {
        break label662;
      }
      paramImageItemHolder.jdField_a_of_type_AndroidWidgetTextView.setBackgroundColor(0);
      label536:
      if (this.jdField_f_of_type_Boolean) {
        break label678;
      }
      paramImageItemHolder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    for (;;)
    {
      paramImageItemHolder.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(new PublicAccountImageCollectionAdapter.3(this));
      return;
      i = this.jdField_f_of_type_Int * localPhotoItemInfo.jdField_b_of_type_Int / localPhotoItemInfo.jdField_a_of_type_Int;
      break;
      j = 0;
      break label290;
      label594:
      localLayoutParams1.height = ((RelativeLayout.LayoutParams)localObject).height;
      paramImageItemHolder.jdField_a_of_type_AndroidWidgetTextView.setGravity(80);
      break label348;
      label616:
      paramImageItemHolder.jdField_a_of_type_AndroidWidgetTextView.setPadding((int)(15.0F * this.jdField_a_of_type_Float), (int)(10.0F * this.jdField_a_of_type_Float), (int)(15.0F * this.jdField_a_of_type_Float), (int)(10.0F * this.jdField_a_of_type_Float));
      break label409;
      label662:
      paramImageItemHolder.jdField_a_of_type_AndroidWidgetTextView.setBackgroundColor(Color.parseColor("#66000000"));
      break label536;
      label678:
      paramImageItemHolder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    }
  }
  
  public void a(PublicAccountImageCollectionUtils.PhotoCollectionInfo paramPhotoCollectionInfo)
  {
    if (paramPhotoCollectionInfo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PublicAccountImageCollectionAdapter", 2, "setPhotoCollectionInfo is null");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PublicAccountImageCollectionAdapter", 2, "setPhotoCollectionInfo articleURl = " + paramPhotoCollectionInfo.jdField_b_of_type_JavaLangString + "; puin=" + paramPhotoCollectionInfo.jdField_c_of_type_JavaLangString + "; imageUrl=" + paramPhotoCollectionInfo.d);
    }
    this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageCollectionUtils$PhotoCollectionInfo = paramPhotoCollectionInfo;
    this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageCollectionUtils$PhotoCollectionInfo.jdField_b_of_type_JavaLangString;
    this.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageCollectionUtils$PhotoCollectionInfo.jdField_c_of_type_JavaLangString;
    this.jdField_a_of_type_JavaUtilArrayList = this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageCollectionUtils$PhotoCollectionInfo.jdField_a_of_type_JavaUtilArrayList;
    this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageCollectionListView.setPhotoCollectionInfo(this.jdField_a_of_type_JavaUtilArrayList);
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a(ArrayList<PublicAccountImageCollectionUtils.RecommendItemInfo> paramArrayList)
  {
    if (paramArrayList == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PublicAccountImageCollectionAdapter", 2, "setRecommendItemInfos is null");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PublicAccountImageCollectionAdapter", 2, "setRecommendItemInfos size = " + paramArrayList.size());
    }
    this.jdField_b_of_type_JavaUtilArrayList = paramArrayList;
    this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageCollectionListView.setRecommendInfo(this.jdField_b_of_type_JavaUtilArrayList);
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("PublicAccountImageCollectionAdapter", 2, "setGetPhotoCollectionInfoError isError = " + paramBoolean);
    }
    this.jdField_c_of_type_Boolean = paramBoolean;
  }
  
  boolean a(int paramInt, View paramView)
  {
    boolean bool2 = true;
    boolean bool1;
    if (paramView == null) {
      bool1 = false;
    }
    label38:
    do
    {
      do
      {
        do
        {
          return bool1;
          if (paramInt != 1) {
            break label38;
          }
          if (paramView.getTag() == null) {
            break;
          }
          bool1 = bool2;
        } while ((paramView.getTag() instanceof PublicAccountImageCollectionAdapter.ImageItemHolder));
        return false;
        bool1 = bool2;
      } while (paramInt != 0);
      if (paramView.getTag() == null) {
        break;
      }
      bool1 = bool2;
    } while ((paramView.getTag() instanceof PublicAccountImageCollectionAdapter.CoverHolder));
    return false;
  }
  
  public int[] a(PublicAccountImageCollectionUtils.PhotoItemInfo paramPhotoItemInfo)
  {
    int[] arrayOfInt = new int[2];
    if (paramPhotoItemInfo != null)
    {
      if (paramPhotoItemInfo.jdField_a_of_type_Int <= this.jdField_f_of_type_Int) {
        break label75;
      }
      arrayOfInt[0] = this.jdField_f_of_type_Int;
      if (paramPhotoItemInfo.jdField_b_of_type_Int / paramPhotoItemInfo.jdField_a_of_type_Int > this.jdField_e_of_type_Int / this.jdField_f_of_type_Int) {
        arrayOfInt[1] = this.jdField_e_of_type_Int;
      }
    }
    else
    {
      return arrayOfInt;
    }
    arrayOfInt[1] = (this.jdField_f_of_type_Int * paramPhotoItemInfo.jdField_b_of_type_Int / paramPhotoItemInfo.jdField_a_of_type_Int);
    return arrayOfInt;
    label75:
    arrayOfInt[0] = paramPhotoItemInfo.jdField_a_of_type_Int;
    if (paramPhotoItemInfo.jdField_b_of_type_Int > this.jdField_e_of_type_Int)
    {
      arrayOfInt[1] = this.jdField_e_of_type_Int;
      return arrayOfInt;
    }
    arrayOfInt[1] = paramPhotoItemInfo.jdField_b_of_type_Int;
    return arrayOfInt;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageCollectionRecommendViewWrapper != null) {
      this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageCollectionRecommendViewWrapper.a(this.jdField_b_of_type_JavaUtilArrayList);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("PublicAccountImageCollectionAdapter", 2, "setGetRecommendInfoError isError = " + paramBoolean);
    }
    this.jdField_d_of_type_Boolean = paramBoolean;
  }
  
  void c()
  {
    if (this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageCollectionUtils$PhotoCollectionInfo != null)
    {
      ActivityURIRequest localActivityURIRequest = new ActivityURIRequest(this.jdField_a_of_type_AndroidAppActivity, "/pubaccount/detail");
      localActivityURIRequest.extra().putString("uin", this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageCollectionUtils$PhotoCollectionInfo.jdField_c_of_type_JavaLangString);
      localActivityURIRequest.setFlags(67108864);
      QRoute.startUri(localActivityURIRequest, null);
    }
  }
  
  public void c(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PublicAccountImageCollectionAdapter", 2, "setIsFollowed isFollowed = " + paramBoolean);
    }
    this.jdField_a_of_type_Boolean = paramBoolean;
    f();
  }
  
  void d()
  {
    Object localObject = (PublicAccountDataManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.PUBLICACCOUNTDATA_MANAGER);
    if (localObject != null)
    {
      localObject = ((PublicAccountDataManager)localObject).a(this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageCollectionUtils$PhotoCollectionInfo.jdField_c_of_type_JavaLangString);
      if ((localObject != null) && (((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).getAccountType(((AccountDetail)localObject).accountFlag) != -4)) {
        break label190;
      }
      localObject = new NewIntent(this.jdField_a_of_type_AndroidContentContext, ((IPublicAccountServlet)QRoute.api(IPublicAccountServlet.class)).getServletClass());
      ((NewIntent)localObject).putExtra("cmd", "follow");
      mobileqq_mp.FollowRequest localFollowRequest = new mobileqq_mp.FollowRequest();
      localFollowRequest.uin.set((int)Long.parseLong(this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageCollectionUtils$PhotoCollectionInfo.jdField_c_of_type_JavaLangString));
      localFollowRequest.ext.set("21");
      ((NewIntent)localObject).putExtra("data", localFollowRequest.toByteArray());
      ((NewIntent)localObject).setObserver(new PublicAccountImageCollectionAdapter.4(this));
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet((NewIntent)localObject);
    }
    for (;;)
    {
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).reportFollowEvent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageCollectionUtils$PhotoCollectionInfo.jdField_c_of_type_JavaLangString, 21);
      return;
      label190:
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppletsNewPublicAccountObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppletsNewPublicAccountObserver = new NewPublicAccountObserver(new PublicAccountImageCollectionAdapter.5(this));
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppletsNewPublicAccountObserver);
      PublicAccountStateReporter.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true, this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageCollectionUtils$PhotoCollectionInfo.jdField_c_of_type_JavaLangString, 21);
    }
  }
  
  public void d(boolean paramBoolean)
  {
    View localView1 = ((ViewGroup)this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageCollectionListView.getParent()).getChildAt(1);
    View localView2 = ((ViewGroup)this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageCollectionListView.getParent()).getChildAt(2);
    if ((localView2 == null) || (localView1 == null)) {
      return;
    }
    if (paramBoolean)
    {
      localView2.setVisibility(0);
      localView1.setVisibility(0);
      return;
    }
    localView2.setVisibility(8);
    localView1.setVisibility(8);
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      return 1;
    }
    return this.jdField_a_of_type_JavaUtilArrayList.size() + 2;
  }
  
  public Object getItem(int paramInt)
  {
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    if (paramInt == 0) {
      return 0;
    }
    if (paramInt == getCount() - 1) {
      return 2;
    }
    return 1;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject3 = null;
    Object localObject2 = null;
    this.jdField_d_of_type_Int = 0;
    int i = getItemViewType(paramInt);
    Object localObject1;
    if (a(i, paramView)) {
      switch (i)
      {
      default: 
        localObject1 = null;
        localObject2 = null;
        localObject3 = paramView;
        Object localObject4 = localObject1;
        localObject1 = localObject3;
        localObject3 = localObject2;
        localObject2 = localObject4;
        if (i == 1) {
          a((PublicAccountImageCollectionAdapter.ImageItemHolder)localObject3, paramInt);
        }
        break;
      }
    }
    for (;;)
    {
      ((View)localObject1).setLongClickable(true);
      ((View)localObject1).setOnTouchListener(new PublicAccountImageCollectionAdapter.2(this, paramInt));
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return localObject1;
      localObject1 = (PublicAccountImageCollectionAdapter.CoverHolder)paramView.getTag();
      localObject2 = null;
      break;
      localObject2 = (PublicAccountImageCollectionAdapter.ImageItemHolder)paramView.getTag();
      ((PublicAccountImageCollectionAdapter.ImageItemHolder)localObject2).jdField_a_of_type_Int = paramInt;
      paramView.setTag(localObject2);
      localObject1 = null;
      break;
      switch (i)
      {
      default: 
        localObject1 = paramView;
        break;
      case 0: 
        localObject1 = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131559732, paramViewGroup, false);
        localObject2 = ((View)localObject1).getLayoutParams();
        ((ViewGroup.LayoutParams)localObject2).height = this.jdField_e_of_type_Int;
        ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
        localObject2 = new PublicAccountImageCollectionAdapter.CoverHolder();
        ((PublicAccountImageCollectionAdapter.CoverHolder)localObject2).jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderZImageView = ((ZImageView)((View)localObject1).findViewById(2131368783));
        ((PublicAccountImageCollectionAdapter.CoverHolder)localObject2).jdField_a_of_type_ComTencentMobileqqWidgetImageProgressCircle = ((ImageProgressCircle)((View)localObject1).findViewById(2131368784));
        ((PublicAccountImageCollectionAdapter.CoverHolder)localObject2).jdField_a_of_type_AndroidWidgetTextView = ((TextView)((View)localObject1).findViewById(2131368785));
        ((PublicAccountImageCollectionAdapter.CoverHolder)localObject2).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject1).findViewById(2131368790));
        ((PublicAccountImageCollectionAdapter.CoverHolder)localObject2).d = ((TextView)((View)localObject1).findViewById(2131368791));
        ((PublicAccountImageCollectionAdapter.CoverHolder)localObject2).c = ((TextView)((View)localObject1).findViewById(2131368786));
        ((PublicAccountImageCollectionAdapter.CoverHolder)localObject2).b = ((TextView)((View)localObject1).findViewById(2131368778));
        ((PublicAccountImageCollectionAdapter.CoverHolder)localObject2).b = ((TextView)((View)localObject1).findViewById(2131368778));
        ((PublicAccountImageCollectionAdapter.CoverHolder)localObject2).e = ((TextView)((View)localObject1).findViewById(2131368793));
        ((PublicAccountImageCollectionAdapter.CoverHolder)localObject2).jdField_a_of_type_AndroidWidgetButton = ((Button)((View)localObject1).findViewById(2131368788));
        ((PublicAccountImageCollectionAdapter.CoverHolder)localObject2).jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAlphaMaskView = ((VideoFeedsAlphaMaskView)((View)localObject1).findViewById(2131371077));
        ((PublicAccountImageCollectionAdapter.CoverHolder)localObject2).jdField_a_of_type_AndroidViewView = ((View)localObject1).findViewById(2131368792);
        ((PublicAccountImageCollectionAdapter.CoverHolder)localObject2).f = ((TextView)((View)localObject1).findViewById(2131368787));
        ((PublicAccountImageCollectionAdapter.CoverHolder)localObject2).jdField_a_of_type_Int = paramInt;
        this.jdField_a_of_type_AndroidWidgetButton = ((PublicAccountImageCollectionAdapter.CoverHolder)localObject2).jdField_a_of_type_AndroidWidgetButton;
        this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
        this.jdField_a_of_type_AndroidViewView = ((PublicAccountImageCollectionAdapter.CoverHolder)localObject2).jdField_a_of_type_AndroidViewView;
        this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
        this.jdField_a_of_type_AndroidWidgetTextView = ((PublicAccountImageCollectionAdapter.CoverHolder)localObject2).e;
        ((View)localObject1).setTag(localObject2);
        break;
      case 1: 
        localObject1 = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131559733, paramViewGroup, false);
        localObject3 = new PublicAccountImageCollectionAdapter.ImageItemHolder();
        ((PublicAccountImageCollectionAdapter.ImageItemHolder)localObject3).jdField_a_of_type_ComTencentMobileqqWidgetImageProgressCircle = ((ImageProgressCircle)((View)localObject1).findViewById(2131373649));
        ((PublicAccountImageCollectionAdapter.ImageItemHolder)localObject3).jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderZImageView = ((ZImageView)((View)localObject1).findViewById(2131373639));
        ((PublicAccountImageCollectionAdapter.ImageItemHolder)localObject3).jdField_a_of_type_AndroidWidgetTextView = ((TextView)((View)localObject1).findViewById(2131368742));
        ((PublicAccountImageCollectionAdapter.ImageItemHolder)localObject3).jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAlphaMaskView = ((VideoFeedsAlphaMaskView)((View)localObject1).findViewById(2131371077));
        ((PublicAccountImageCollectionAdapter.ImageItemHolder)localObject3).jdField_a_of_type_AndroidViewView = ((View)localObject1).findViewById(2131377366);
        ((PublicAccountImageCollectionAdapter.ImageItemHolder)localObject3).jdField_a_of_type_Int = paramInt;
        ((View)localObject1).setTag(localObject3);
        break;
        if (i != 0) {
          break label644;
        }
        a((PublicAccountImageCollectionAdapter.CoverHolder)localObject2);
      }
    }
    label644:
    if (i == 2) {
      if (!this.jdField_g_of_type_Boolean)
      {
        if (this.jdField_b_of_type_JavaUtilArrayList == null) {
          break label856;
        }
        localObject2 = "";
        i = 0;
        while ((this.jdField_b_of_type_JavaUtilArrayList.size() > i) && (i < 6))
        {
          localObject3 = (PublicAccountImageCollectionUtils.RecommendItemInfo)this.jdField_b_of_type_JavaUtilArrayList.get(i);
          localObject2 = (String)localObject2 + ((PublicAccountImageCollectionUtils.RecommendItemInfo)localObject3).d + "&";
          i += 1;
        }
      }
    }
    for (;;)
    {
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, this.jdField_c_of_type_JavaLangString, "0X8007B93", "0X8007B93", 0, 0, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, (String)localObject2, "", false);
      this.jdField_g_of_type_Boolean = true;
      if (this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageCollectionRecommendViewWrapper == null) {
        this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageCollectionRecommendViewWrapper = new PublicAccountImageCollectionRecommendViewWrapper(this.jdField_a_of_type_AndroidAppActivity, this.jdField_b_of_type_JavaUtilArrayList, this.jdField_e_of_type_Int, this.jdField_f_of_type_Int, this.jdField_d_of_type_Boolean);
      }
      if (this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageCollectionRecommendViewWrapper != null)
      {
        localObject1 = this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageCollectionRecommendViewWrapper.a(this.jdField_a_of_type_AndroidAppActivity, (View)localObject1, paramViewGroup);
        break;
      }
      break;
      label856:
      localObject2 = "";
    }
  }
  
  public int getViewTypeCount()
  {
    return 3;
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.jdField_a_of_type_AndroidWidgetButton)
    {
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, this.jdField_c_of_type_JavaLangString, "0X8007B8E", "0X8007B8E", 0, 0, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, "", "", false);
      d();
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (paramView == this.jdField_a_of_type_AndroidViewView)
      {
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, this.jdField_c_of_type_JavaLangString, "0X8007B8D", "0X8007B8D", 0, 0, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, "", "", false);
        c();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.publicAccountImageCollection.PublicAccountImageCollectionAdapter
 * JD-Core Version:    0.7.0.1
 */