package com.tencent.biz.pubaccount.imagecollection;

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
import com.tencent.biz.pubaccount.accountdetail.api.impl.PublicAccountDetailImpl;
import com.tencent.biz.pubaccount.api.IPublicAccountDataManager;
import com.tencent.biz.pubaccount.api.IPublicAccountServlet;
import com.tencent.biz.pubaccount.imagecollection.api.IPublicAccountImageCollectionPreloadManager;
import com.tencent.biz.pubaccount.imagecollection.api.IPublicAccountImageCollectionUtils.PhotoCollectionInfo;
import com.tencent.biz.pubaccount.imagecollection.api.IPublicAccountImageCollectionUtils.PhotoFirstItemInfo;
import com.tencent.biz.pubaccount.imagecollection.api.IPublicAccountImageCollectionUtils.PhotoItemInfo;
import com.tencent.biz.pubaccount.imagecollection.api.IPublicAccountImageCollectionUtils.RecommendItemInfo;
import com.tencent.biz.pubaccount.imagecollection.api.impl.PublicAccountImageCollectionMainActivityImpl;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.applets.NewPublicAccountObserver;
import com.tencent.mobileqq.applets.PublicAccountStateReporter;
import com.tencent.mobileqq.kandian.base.image.ImageRequest;
import com.tencent.mobileqq.kandian.base.view.widget.VideoFeedsAlphaMaskView;
import com.tencent.mobileqq.kandian.base.view.widget.ZImageView;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.mp.mobileqq_mp.FollowRequest;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.widget.ImageProgressCircle;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ScaleGestureDetector;
import com.tencent.widget.ScaleGestureDetector.OnScaleGestureListener;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Formatter;
import mqq.app.NewIntent;

public class PublicAccountImageCollectionAdapter
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
  private PublicAccountImageCollectionListView.ListViewEventListener jdField_a_of_type_ComTencentBizPubaccountImagecollectionPublicAccountImageCollectionListView$ListViewEventListener = new PublicAccountImageCollectionAdapter.1(this);
  private PublicAccountImageCollectionListView jdField_a_of_type_ComTencentBizPubaccountImagecollectionPublicAccountImageCollectionListView;
  private PublicAccountImageCollectionRecommendViewWrapper jdField_a_of_type_ComTencentBizPubaccountImagecollectionPublicAccountImageCollectionRecommendViewWrapper;
  private IPublicAccountImageCollectionUtils.PhotoCollectionInfo jdField_a_of_type_ComTencentBizPubaccountImagecollectionApiIPublicAccountImageCollectionUtils$PhotoCollectionInfo = null;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private NewPublicAccountObserver jdField_a_of_type_ComTencentMobileqqAppletsNewPublicAccountObserver;
  String jdField_a_of_type_JavaLangString = "";
  public ArrayList<IPublicAccountImageCollectionUtils.PhotoItemInfo> a;
  boolean jdField_a_of_type_Boolean = false;
  final int jdField_b_of_type_Int = 1;
  private View jdField_b_of_type_AndroidViewView;
  String jdField_b_of_type_JavaLangString = "";
  private ArrayList<IPublicAccountImageCollectionUtils.RecommendItemInfo> jdField_b_of_type_JavaUtilArrayList = null;
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
    this.jdField_a_of_type_ComTencentBizPubaccountImagecollectionPublicAccountImageCollectionListView = paramPublicAccountImageCollectionListView;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentBizPubaccountImagecollectionPublicAccountImageCollectionListView.a(this.jdField_a_of_type_ComTencentBizPubaccountImagecollectionPublicAccountImageCollectionListView$ListViewEventListener);
    this.jdField_a_of_type_Float = this.jdField_a_of_type_ComTencentBizPubaccountImagecollectionPublicAccountImageCollectionListView.getResources().getDisplayMetrics().density;
    if (a()) {
      this.jdField_e_of_type_Int = (a()[1] - a());
    } else {
      this.jdField_e_of_type_Int = a()[1];
    }
    this.jdField_f_of_type_Int = a()[0];
    this.jdField_a_of_type_ComTencentBizPubaccountImagecollectionPublicAccountImageCollectionListView.setScreenHeight(this.jdField_e_of_type_Int);
    this.jdField_a_of_type_AndroidUtilLruCache = new LruCache(15);
    a(paramContext);
  }
  
  private int a()
  {
    Resources localResources = this.jdField_a_of_type_AndroidAppActivity.getResources();
    return localResources.getDimensionPixelSize(localResources.getIdentifier("status_bar_height", "dimen", "android"));
  }
  
  private void a(ZImageView paramZImageView, ImageRequest paramImageRequest, ImageProgressCircle paramImageProgressCircle, int paramInt)
  {
    ColorDrawable localColorDrawable = new ColorDrawable(Color.parseColor("#000000"));
    if ((paramImageRequest != null) && (paramImageRequest.jdField_a_of_type_JavaNetURL != null))
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("loadImage url = ");
        localStringBuilder.append(paramImageRequest.jdField_a_of_type_JavaNetURL);
        localStringBuilder.append(" reqWidth = ");
        localStringBuilder.append(paramImageRequest.jdField_a_of_type_Int);
        localStringBuilder.append(" reqHeight = ");
        localStringBuilder.append(paramImageRequest.jdField_b_of_type_Int);
        QLog.d("PublicAccountImageCollectionAdapter", 2, localStringBuilder.toString());
      }
      boolean bool;
      if (AbsDownloader.getFile(paramImageRequest.jdField_a_of_type_JavaNetURL.toString()) != null) {
        bool = true;
      } else {
        bool = false;
      }
      if (bool) {
        ((IPublicAccountImageCollectionPreloadManager)QRoute.api(IPublicAccountImageCollectionPreloadManager.class)).doStatisticReportForImageHit(true, paramInt);
      } else {
        ((IPublicAccountImageCollectionPreloadManager)QRoute.api(IPublicAccountImageCollectionPreloadManager.class)).doStatisticReportForImageHit(false, paramInt);
      }
      long l = NetConnInfoCenter.getServerTimeMillis();
      paramZImageView.setImagePlaceHolder(localColorDrawable).setImageForImageCollection(paramImageRequest, new PublicAccountImageCollectionAdapter.6(this, bool, l, paramImageProgressCircle));
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PublicAccountImageCollectionAdapter", 2, "loadImage url is empty! use default preload image");
    }
    paramZImageView.setImageDrawable(localColorDrawable);
  }
  
  private void a(ImageProgressCircle paramImageProgressCircle)
  {
    if (paramImageProgressCircle == null) {
      return;
    }
    if (paramImageProgressCircle.getVisibility() != 4) {
      paramImageProgressCircle.setVisibility(4);
    }
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
    Button localButton = this.jdField_a_of_type_AndroidWidgetButton;
    if ((localButton != null) && (this.jdField_a_of_type_Boolean))
    {
      localButton.setText(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131695269));
      this.jdField_a_of_type_AndroidWidgetButton.setBackgroundDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130841708));
    }
  }
  
  private void f()
  {
    Button localButton = this.jdField_a_of_type_AndroidWidgetButton;
    if (localButton != null)
    {
      if (this.jdField_a_of_type_Boolean)
      {
        localButton.setVisibility(8);
        return;
      }
      if ((!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountImagecollectionApiIPublicAccountImageCollectionUtils$PhotoCollectionInfo.jdField_c_of_type_JavaLangString)) && (!this.jdField_a_of_type_ComTencentBizPubaccountImagecollectionApiIPublicAccountImageCollectionUtils$PhotoCollectionInfo.jdField_c_of_type_JavaLangString.equals("0")))
      {
        this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetButton.setBackgroundDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130839280));
        this.jdField_a_of_type_AndroidWidgetButton.setText(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131695270));
      }
    }
  }
  
  private void g()
  {
    int j = this.jdField_a_of_type_ComTencentBizPubaccountImagecollectionPublicAccountImageCollectionListView.getLastVisiblePosition();
    int k = this.jdField_a_of_type_ComTencentBizPubaccountImagecollectionPublicAccountImageCollectionListView.getFirstVisiblePosition();
    int i = 0;
    while (i <= j - k)
    {
      Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountImagecollectionPublicAccountImageCollectionListView.getChildAt(i);
      if ((((View)localObject).getTag() != null) && ((((View)localObject).getTag() instanceof PublicAccountImageCollectionAdapter.ImageItemHolder)))
      {
        localObject = (PublicAccountImageCollectionAdapter.ImageItemHolder)((View)localObject).getTag();
        if (((PublicAccountImageCollectionAdapter.ImageItemHolder)localObject).jdField_a_of_type_AndroidWidgetTextView.getVisibility() == 0)
        {
          this.jdField_f_of_type_Boolean = false;
          ((PublicAccountImageCollectionAdapter.ImageItemHolder)localObject).jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        }
        else
        {
          this.jdField_f_of_type_Boolean = true;
          ((PublicAccountImageCollectionAdapter.ImageItemHolder)localObject).jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        }
      }
      i += 1;
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
    Object localObject1 = this.jdField_b_of_type_AndroidViewView;
    if (localObject1 != null)
    {
      if (!(((View)localObject1).getTag() instanceof PublicAccountImageCollectionAdapter.ImageItemHolder)) {
        return;
      }
      if (!this.jdField_a_of_type_ComTencentBizPubaccountImagecollectionPublicAccountImageCollectionListView.a(this.jdField_b_of_type_AndroidViewView).booleanValue()) {
        return;
      }
      localObject1 = new Intent(this.jdField_a_of_type_AndroidContentContext, PublicAccountImageCollectionActivity.class);
      Object localObject2 = ((ZImageView)((ViewGroup)this.jdField_b_of_type_AndroidViewView).getChildAt(0)).getImageMatrix();
      float[] arrayOfFloat = new float[9];
      ((Matrix)localObject2).getValues(arrayOfFloat);
      localObject2 = this.jdField_a_of_type_JavaUtilArrayList;
      if (localObject2 == null) {
        return;
      }
      localObject2 = (IPublicAccountImageCollectionUtils.PhotoItemInfo)((ArrayList)localObject2).get(this.jdField_d_of_type_Int - 1);
      String str = ((IPublicAccountImageCollectionUtils.PhotoItemInfo)localObject2).jdField_a_of_type_JavaLangString;
      int i = a(localObject2)[0];
      int j = a(localObject2)[1];
      ZImageView localZImageView = (ZImageView)((ViewGroup)this.jdField_b_of_type_AndroidViewView).getChildAt(0);
      int k = localZImageView.getWidth();
      int m = localZImageView.getHeight();
      if (!TextUtils.isEmpty(str))
      {
        ((Intent)localObject1).putExtra("doubleBitMapPath", str);
        ((Intent)localObject1).putExtra("urlImageHeight", j);
        ((Intent)localObject1).putExtra("urlImageWidth", i);
        ((Intent)localObject1).putExtra("urlImageWidthReal", k);
        ((Intent)localObject1).putExtra("urlImageHeightReal", m);
        ((Intent)localObject1).putExtra("imageMatrix", arrayOfFloat);
        this.jdField_a_of_type_AndroidAppActivity.startActivity((Intent)localObject1);
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, this.jdField_c_of_type_JavaLangString, "0X8007B91", "0X8007B91", 0, 0, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, ((IPublicAccountImageCollectionUtils.PhotoItemInfo)localObject2).jdField_a_of_type_JavaLangString, "2", false);
      }
    }
  }
  
  public URL a(String paramString)
  {
    URL localURL = (URL)this.jdField_a_of_type_AndroidUtilLruCache.get(paramString);
    Object localObject2 = localURL;
    if (localURL == null)
    {
      localObject2 = null;
      Object localObject1;
      try
      {
        localObject1 = new URL(paramString);
      }
      catch (MalformedURLException localMalformedURLException)
      {
        localObject1 = localObject2;
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("getURLPath ERROR e = ");
          ((StringBuilder)localObject1).append(localMalformedURLException.getMessage());
          QLog.d("PublicAccountImageCollectionAdapter", 2, ((StringBuilder)localObject1).toString());
          localObject1 = localObject2;
        }
      }
      localObject2 = localURL;
      if (localObject1 != null)
      {
        this.jdField_a_of_type_AndroidUtilLruCache.put(paramString, localObject1);
        localObject2 = localObject1;
      }
    }
    return localObject2;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidAppActivity != null) {
      this.jdField_a_of_type_AndroidAppActivity = null;
    }
    Object localObject = this.jdField_a_of_type_AndroidUtilLruCache;
    if (localObject != null) {
      ((LruCache)localObject).evictAll();
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountImagecollectionPublicAccountImageCollectionListView$ListViewEventListener != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountImagecollectionPublicAccountImageCollectionListView$ListViewEventListener = null;
    }
    if (this.jdField_b_of_type_AndroidViewView != null) {
      this.jdField_b_of_type_AndroidViewView = null;
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (localObject != null) {
      ((QQAppInterface)localObject).removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppletsNewPublicAccountObserver);
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_g_of_type_Int = paramInt;
    if (this.jdField_a_of_type_AndroidWidgetTextView != null)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("");
      ((StringBuilder)localObject).append(paramInt);
      localObject = ((StringBuilder)localObject).toString();
      if (paramInt > 1000000)
      {
        localObject = "100万+";
      }
      else if (paramInt > 100000)
      {
        double d1 = paramInt;
        Double.isNaN(d1);
        d1 /= 100000.0D;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(new Formatter().format("%.1f", new Object[] { Double.valueOf(d1) }).toString());
        ((StringBuilder)localObject).append(HardCodeUtil.a(2131708786));
        localObject = ((StringBuilder)localObject).toString();
      }
      TextView localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(HardCodeUtil.a(2131708763));
      localStringBuilder.append((String)localObject);
      localTextView.setText(localStringBuilder.toString());
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
    Object localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountImagecollectionApiIPublicAccountImageCollectionUtils$PhotoCollectionInfo;
    if (localObject1 == null)
    {
      if (this.jdField_c_of_type_Boolean)
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("PublicAccountImageCollectionAdapter", 2, "setDataForImageCover getPhotoCollectionInfo error");
        }
        paramCoverHolder.f.setVisibility(0);
        a(paramCoverHolder.jdField_a_of_type_ComTencentMobileqqWidgetImageProgressCircle);
        ((PublicAccountImageCollectionMainActivityImpl)this.jdField_a_of_type_AndroidAppActivity).hideUserGuide();
        return;
      }
      paramCoverHolder.f.setVisibility(8);
      return;
    }
    if ((((IPublicAccountImageCollectionUtils.PhotoCollectionInfo)localObject1).jdField_a_of_type_ComTencentBizPubaccountImagecollectionApiIPublicAccountImageCollectionUtils$PhotoFirstItemInfo != null) && (QLog.isColorLevel()))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("setDataForImageCover title =");
      ((StringBuilder)localObject1).append(this.jdField_a_of_type_ComTencentBizPubaccountImagecollectionApiIPublicAccountImageCollectionUtils$PhotoCollectionInfo.e);
      ((StringBuilder)localObject1).append("; coverUrl =");
      ((StringBuilder)localObject1).append(this.jdField_a_of_type_ComTencentBizPubaccountImagecollectionApiIPublicAccountImageCollectionUtils$PhotoCollectionInfo.jdField_a_of_type_ComTencentBizPubaccountImagecollectionApiIPublicAccountImageCollectionUtils$PhotoFirstItemInfo.jdField_a_of_type_JavaLangString);
      ((StringBuilder)localObject1).append("; accountName = ");
      ((StringBuilder)localObject1).append(this.jdField_a_of_type_ComTencentBizPubaccountImagecollectionApiIPublicAccountImageCollectionUtils$PhotoCollectionInfo.jdField_a_of_type_ComTencentBizPubaccountImagecollectionApiIPublicAccountImageCollectionUtils$PhotoFirstItemInfo.jdField_b_of_type_JavaLangString);
      ((StringBuilder)localObject1).append("; author=");
      ((StringBuilder)localObject1).append(this.jdField_a_of_type_ComTencentBizPubaccountImagecollectionApiIPublicAccountImageCollectionUtils$PhotoCollectionInfo.jdField_a_of_type_ComTencentBizPubaccountImagecollectionApiIPublicAccountImageCollectionUtils$PhotoFirstItemInfo.d);
      ((StringBuilder)localObject1).append("; time =");
      ((StringBuilder)localObject1).append(this.jdField_a_of_type_ComTencentBizPubaccountImagecollectionApiIPublicAccountImageCollectionUtils$PhotoCollectionInfo.jdField_a_of_type_ComTencentBizPubaccountImagecollectionApiIPublicAccountImageCollectionUtils$PhotoFirstItemInfo.jdField_c_of_type_JavaLangString);
      QLog.d("PublicAccountImageCollectionAdapter", 2, ((StringBuilder)localObject1).toString());
    }
    paramCoverHolder.jdField_a_of_type_AndroidViewView.setVisibility(0);
    paramCoverHolder.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentBizPubaccountImagecollectionApiIPublicAccountImageCollectionUtils$PhotoCollectionInfo.e);
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("");
    ((StringBuilder)localObject1).append(this.jdField_g_of_type_Int);
    localObject1 = ((StringBuilder)localObject1).toString();
    int i = this.jdField_g_of_type_Int;
    if (i > 1000000)
    {
      localObject1 = "100万+";
    }
    else if (i > 100000)
    {
      double d1 = i;
      Double.isNaN(d1);
      d1 /= 100000.0D;
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(new Formatter().format("%.1f", new Object[] { Double.valueOf(d1) }).toString());
      ((StringBuilder)localObject1).append(HardCodeUtil.a(2131708804));
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    Object localObject2 = paramCoverHolder.e;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(HardCodeUtil.a(2131708753));
    localStringBuilder.append((String)localObject1);
    ((TextView)localObject2).setText(localStringBuilder.toString());
    localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountImagecollectionApiIPublicAccountImageCollectionUtils$PhotoCollectionInfo.jdField_a_of_type_ComTencentBizPubaccountImagecollectionApiIPublicAccountImageCollectionUtils$PhotoFirstItemInfo;
    if (localObject1 != null)
    {
      paramCoverHolder.d.setText(((IPublicAccountImageCollectionUtils.PhotoFirstItemInfo)localObject1).jdField_b_of_type_JavaLangString);
      paramCoverHolder.b.setText(((IPublicAccountImageCollectionUtils.PhotoFirstItemInfo)localObject1).d);
      paramCoverHolder.c.setText(((IPublicAccountImageCollectionUtils.PhotoFirstItemInfo)localObject1).jdField_c_of_type_JavaLangString);
      if (!TextUtils.isEmpty(((IPublicAccountImageCollectionUtils.PhotoFirstItemInfo)localObject1).jdField_b_of_type_JavaLangString))
      {
        paramCoverHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        paramCoverHolder.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(FaceDrawable.getFaceDrawable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, this.jdField_a_of_type_ComTencentBizPubaccountImagecollectionApiIPublicAccountImageCollectionUtils$PhotoCollectionInfo.jdField_c_of_type_JavaLangString));
      }
      else
      {
        paramCoverHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      }
      localObject2 = new ImageRequest();
      ((ImageRequest)localObject2).jdField_a_of_type_JavaNetURL = a(((IPublicAccountImageCollectionUtils.PhotoFirstItemInfo)localObject1).jdField_a_of_type_JavaLangString);
      a(paramCoverHolder.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetZImageView, (ImageRequest)localObject2, paramCoverHolder.jdField_a_of_type_ComTencentMobileqqWidgetImageProgressCircle, 0);
    }
    if ((TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountImagecollectionApiIPublicAccountImageCollectionUtils$PhotoCollectionInfo.jdField_c_of_type_JavaLangString)) || (this.jdField_a_of_type_ComTencentBizPubaccountImagecollectionApiIPublicAccountImageCollectionUtils$PhotoCollectionInfo.jdField_c_of_type_JavaLangString.equals("0")))
    {
      new RelativeLayout.LayoutParams(-1, -1).setMargins(AIOUtils.b(12.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), AIOUtils.b(25.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), 0, 0);
      paramCoverHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      paramCoverHolder.e.setTextSize(2, 14.0F);
      paramCoverHolder.d.setVisibility(8);
      paramCoverHolder.b.setTextSize(2, 14.0F);
      paramCoverHolder.c.setTextSize(2, 14.0F);
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(null);
    }
    if (!this.jdField_b_of_type_Boolean) {
      ((PublicAccountImageCollectionMainActivityImpl)this.jdField_a_of_type_AndroidAppActivity).showUserGuide();
    }
    this.jdField_b_of_type_Boolean = true;
  }
  
  void a(PublicAccountImageCollectionAdapter.ImageItemHolder paramImageItemHolder, int paramInt)
  {
    Object localObject1 = this.jdField_a_of_type_JavaUtilArrayList;
    if (localObject1 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PublicAccountImageCollectionAdapter", 2, "setDataForImageFeeds mPhotoItemInfo is null");
      }
      return;
    }
    int j = 1;
    if (paramInt >= 1)
    {
      if (paramInt > ((ArrayList)localObject1).size()) {
        return;
      }
      localObject1 = (IPublicAccountImageCollectionUtils.PhotoItemInfo)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt - 1);
      if ((localObject1 != null) && (((IPublicAccountImageCollectionUtils.PhotoItemInfo)localObject1).jdField_a_of_type_Int != 0))
      {
        if (this.jdField_f_of_type_Int == 0) {
          return;
        }
        int k = ((IPublicAccountImageCollectionUtils.PhotoItemInfo)localObject1).jdField_b_of_type_Int / ((IPublicAccountImageCollectionUtils.PhotoItemInfo)localObject1).jdField_a_of_type_Int;
        int i = this.jdField_e_of_type_Int;
        int m = this.jdField_f_of_type_Int;
        if (k <= i / m) {
          i = m * ((IPublicAccountImageCollectionUtils.PhotoItemInfo)localObject1).jdField_b_of_type_Int / ((IPublicAccountImageCollectionUtils.PhotoItemInfo)localObject1).jdField_a_of_type_Int;
        }
        ((IPublicAccountImageCollectionUtils.PhotoItemInfo)localObject1).jdField_a_of_type_Boolean = true;
        Object localObject3 = (RelativeLayout.LayoutParams)paramImageItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetZImageView.getLayoutParams();
        Object localObject2 = (RelativeLayout.LayoutParams)paramImageItemHolder.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
        ViewGroup.LayoutParams localLayoutParams = paramImageItemHolder.jdField_a_of_type_AndroidViewView.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject3).width = this.jdField_f_of_type_Int;
        ((RelativeLayout.LayoutParams)localObject3).height = i;
        paramImageItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetZImageView.setLayoutParams((ViewGroup.LayoutParams)localObject3);
        URL localURL = a(((IPublicAccountImageCollectionUtils.PhotoItemInfo)localObject1).jdField_a_of_type_JavaLangString);
        if (localURL == null) {
          return;
        }
        ImageRequest localImageRequest = new ImageRequest();
        localImageRequest.jdField_a_of_type_JavaNetURL = localURL;
        localImageRequest.jdField_a_of_type_Int = a(localObject1)[0];
        localImageRequest.jdField_b_of_type_Int = a(localObject1)[1];
        a(paramImageItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetZImageView, localImageRequest, paramImageItemHolder.jdField_a_of_type_ComTencentMobileqqWidgetImageProgressCircle, paramImageItemHolder.jdField_a_of_type_Int);
        if ((((IPublicAccountImageCollectionUtils.PhotoItemInfo)localObject1).jdField_a_of_type_Int / ((IPublicAccountImageCollectionUtils.PhotoItemInfo)localObject1).jdField_b_of_type_Int <= 1.3D) || (TextUtils.isEmpty(((IPublicAccountImageCollectionUtils.PhotoItemInfo)localObject1).jdField_b_of_type_JavaLangString)) || (((IPublicAccountImageCollectionUtils.PhotoItemInfo)localObject1).jdField_b_of_type_JavaLangString.equals(" "))) {
          j = 0;
        }
        if (j != 0)
        {
          paramImageItemHolder.jdField_a_of_type_AndroidWidgetTextView.setMinHeight(AIOUtils.b(97.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
          localLayoutParams.height = (((RelativeLayout.LayoutParams)localObject3).height + AIOUtils.b(97.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
          paramImageItemHolder.jdField_a_of_type_AndroidWidgetTextView.setGravity(16);
        }
        else
        {
          localLayoutParams.height = ((RelativeLayout.LayoutParams)localObject3).height;
          paramImageItemHolder.jdField_a_of_type_AndroidWidgetTextView.setGravity(80);
        }
        float f1;
        if (i > this.jdField_e_of_type_Int - (int)(this.jdField_a_of_type_Float * 88.0F))
        {
          localObject3 = paramImageItemHolder.jdField_a_of_type_AndroidWidgetTextView;
          f1 = this.jdField_a_of_type_Float;
          ((TextView)localObject3).setPadding((int)(f1 * 15.0F), (int)(10.0F * f1), (int)(15.0F * f1), (int)(f1 * 44.0F));
        }
        else
        {
          localObject3 = paramImageItemHolder.jdField_a_of_type_AndroidWidgetTextView;
          f1 = this.jdField_a_of_type_Float;
          ((TextView)localObject3).setPadding((int)(f1 * 15.0F), (int)(f1 * 10.0F), (int)(15.0F * f1), (int)(f1 * 10.0F));
        }
        paramImageItemHolder.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        paramImageItemHolder.jdField_a_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
        paramImageItemHolder.jdField_a_of_type_AndroidWidgetTextView.setMaxLines(3);
        paramImageItemHolder.jdField_a_of_type_AndroidWidgetTextView.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(paramInt);
        ((StringBuilder)localObject2).append("/");
        ((StringBuilder)localObject2).append(this.jdField_a_of_type_JavaUtilArrayList.size());
        ((StringBuilder)localObject2).append("  ");
        ((StringBuilder)localObject2).append(((IPublicAccountImageCollectionUtils.PhotoItemInfo)localObject1).jdField_b_of_type_JavaLangString);
        localObject2 = ((StringBuilder)localObject2).toString();
        paramImageItemHolder.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject2);
        if ((!TextUtils.isEmpty(((IPublicAccountImageCollectionUtils.PhotoItemInfo)localObject1).jdField_b_of_type_JavaLangString)) && (!((IPublicAccountImageCollectionUtils.PhotoItemInfo)localObject1).jdField_b_of_type_JavaLangString.equals(" "))) {
          paramImageItemHolder.jdField_a_of_type_AndroidWidgetTextView.setBackgroundColor(Color.parseColor("#66000000"));
        } else {
          paramImageItemHolder.jdField_a_of_type_AndroidWidgetTextView.setBackgroundColor(0);
        }
        if (!this.jdField_f_of_type_Boolean) {
          paramImageItemHolder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        } else {
          paramImageItemHolder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        }
        paramImageItemHolder.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(new PublicAccountImageCollectionAdapter.3(this));
      }
    }
  }
  
  public void a(IPublicAccountImageCollectionUtils.PhotoCollectionInfo paramPhotoCollectionInfo)
  {
    if (paramPhotoCollectionInfo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PublicAccountImageCollectionAdapter", 2, "setPhotoCollectionInfo is null");
      }
      return;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setPhotoCollectionInfo articleURl = ");
      localStringBuilder.append(paramPhotoCollectionInfo.jdField_b_of_type_JavaLangString);
      localStringBuilder.append("; puin=");
      localStringBuilder.append(paramPhotoCollectionInfo.jdField_c_of_type_JavaLangString);
      localStringBuilder.append("; imageUrl=");
      localStringBuilder.append(paramPhotoCollectionInfo.d);
      QLog.d("PublicAccountImageCollectionAdapter", 2, localStringBuilder.toString());
    }
    this.jdField_a_of_type_ComTencentBizPubaccountImagecollectionApiIPublicAccountImageCollectionUtils$PhotoCollectionInfo = paramPhotoCollectionInfo;
    this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentBizPubaccountImagecollectionApiIPublicAccountImageCollectionUtils$PhotoCollectionInfo.jdField_b_of_type_JavaLangString;
    this.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_ComTencentBizPubaccountImagecollectionApiIPublicAccountImageCollectionUtils$PhotoCollectionInfo.jdField_c_of_type_JavaLangString;
    this.jdField_a_of_type_JavaUtilArrayList = this.jdField_a_of_type_ComTencentBizPubaccountImagecollectionApiIPublicAccountImageCollectionUtils$PhotoCollectionInfo.jdField_a_of_type_JavaUtilArrayList;
    this.jdField_a_of_type_ComTencentBizPubaccountImagecollectionPublicAccountImageCollectionListView.setPhotoCollectionInfo(this.jdField_a_of_type_JavaUtilArrayList);
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a(ArrayList<IPublicAccountImageCollectionUtils.RecommendItemInfo> paramArrayList)
  {
    if (paramArrayList == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PublicAccountImageCollectionAdapter", 2, "setRecommendItemInfos is null");
      }
      return;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setRecommendItemInfos size = ");
      localStringBuilder.append(paramArrayList.size());
      QLog.d("PublicAccountImageCollectionAdapter", 2, localStringBuilder.toString());
    }
    this.jdField_b_of_type_JavaUtilArrayList = paramArrayList;
    this.jdField_a_of_type_ComTencentBizPubaccountImagecollectionPublicAccountImageCollectionListView.setRecommendInfo(this.jdField_b_of_type_JavaUtilArrayList);
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isDevelopLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setGetPhotoCollectionInfoError isError = ");
      localStringBuilder.append(paramBoolean);
      QLog.d("PublicAccountImageCollectionAdapter", 2, localStringBuilder.toString());
    }
    this.jdField_c_of_type_Boolean = paramBoolean;
  }
  
  boolean a(int paramInt, View paramView)
  {
    boolean bool3 = false;
    boolean bool2 = false;
    if (paramView == null) {
      return false;
    }
    boolean bool1;
    if (paramInt == 1)
    {
      bool1 = bool2;
      if (paramView.getTag() != null)
      {
        bool1 = bool2;
        if ((paramView.getTag() instanceof PublicAccountImageCollectionAdapter.ImageItemHolder)) {
          bool1 = true;
        }
      }
      return bool1;
    }
    if (paramInt == 0)
    {
      bool1 = bool3;
      if (paramView.getTag() != null)
      {
        bool1 = bool3;
        if ((paramView.getTag() instanceof PublicAccountImageCollectionAdapter.CoverHolder)) {
          bool1 = true;
        }
      }
      return bool1;
    }
    return true;
  }
  
  public int[] a(IPublicAccountImageCollectionUtils.PhotoItemInfo paramPhotoItemInfo)
  {
    int[] arrayOfInt = new int[2];
    if (paramPhotoItemInfo != null)
    {
      int i = paramPhotoItemInfo.jdField_a_of_type_Int;
      int j = this.jdField_f_of_type_Int;
      if (i > j)
      {
        arrayOfInt[0] = j;
        i = paramPhotoItemInfo.jdField_b_of_type_Int / paramPhotoItemInfo.jdField_a_of_type_Int;
        j = this.jdField_e_of_type_Int;
        int k = this.jdField_f_of_type_Int;
        if (i > j / k)
        {
          arrayOfInt[1] = j;
          return arrayOfInt;
        }
        arrayOfInt[1] = (k * paramPhotoItemInfo.jdField_b_of_type_Int / paramPhotoItemInfo.jdField_a_of_type_Int);
        return arrayOfInt;
      }
      arrayOfInt[0] = paramPhotoItemInfo.jdField_a_of_type_Int;
      i = paramPhotoItemInfo.jdField_b_of_type_Int;
      j = this.jdField_e_of_type_Int;
      if (i > j)
      {
        arrayOfInt[1] = j;
        return arrayOfInt;
      }
      arrayOfInt[1] = paramPhotoItemInfo.jdField_b_of_type_Int;
    }
    return arrayOfInt;
  }
  
  public void b()
  {
    PublicAccountImageCollectionRecommendViewWrapper localPublicAccountImageCollectionRecommendViewWrapper = this.jdField_a_of_type_ComTencentBizPubaccountImagecollectionPublicAccountImageCollectionRecommendViewWrapper;
    if (localPublicAccountImageCollectionRecommendViewWrapper != null) {
      localPublicAccountImageCollectionRecommendViewWrapper.a(this.jdField_b_of_type_JavaUtilArrayList);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if (QLog.isDevelopLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setGetRecommendInfoError isError = ");
      localStringBuilder.append(paramBoolean);
      QLog.d("PublicAccountImageCollectionAdapter", 2, localStringBuilder.toString());
    }
    this.jdField_d_of_type_Boolean = paramBoolean;
  }
  
  void c()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountImagecollectionApiIPublicAccountImageCollectionUtils$PhotoCollectionInfo != null)
    {
      ActivityURIRequest localActivityURIRequest = new ActivityURIRequest(this.jdField_a_of_type_AndroidAppActivity, "/pubaccount/detail");
      localActivityURIRequest.extra().putString("uin", this.jdField_a_of_type_ComTencentBizPubaccountImagecollectionApiIPublicAccountImageCollectionUtils$PhotoCollectionInfo.jdField_c_of_type_JavaLangString);
      localActivityURIRequest.setFlags(67108864);
      QRoute.startUri(localActivityURIRequest, null);
    }
  }
  
  public void c(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setIsFollowed isFollowed = ");
      localStringBuilder.append(paramBoolean);
      QLog.d("PublicAccountImageCollectionAdapter", 2, localStringBuilder.toString());
    }
    this.jdField_a_of_type_Boolean = paramBoolean;
    f();
  }
  
  void d()
  {
    Object localObject = (IPublicAccountDataManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IPublicAccountDataManager.class, "all");
    if (localObject != null)
    {
      localObject = (PublicAccountDetailImpl)((IPublicAccountDataManager)localObject).findAccountDetailInfo(this.jdField_a_of_type_ComTencentBizPubaccountImagecollectionApiIPublicAccountImageCollectionUtils$PhotoCollectionInfo.jdField_c_of_type_JavaLangString);
      if ((localObject != null) && (((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).getAccountType(((PublicAccountDetailImpl)localObject).accountFlag) != -4))
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppletsNewPublicAccountObserver);
        this.jdField_a_of_type_ComTencentMobileqqAppletsNewPublicAccountObserver = new NewPublicAccountObserver(new PublicAccountImageCollectionAdapter.5(this));
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppletsNewPublicAccountObserver);
        PublicAccountStateReporter.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true, this.jdField_a_of_type_ComTencentBizPubaccountImagecollectionApiIPublicAccountImageCollectionUtils$PhotoCollectionInfo.jdField_c_of_type_JavaLangString, 21);
      }
      else
      {
        localObject = new NewIntent(this.jdField_a_of_type_AndroidContentContext, ((IPublicAccountServlet)QRoute.api(IPublicAccountServlet.class)).getServletClass());
        ((NewIntent)localObject).putExtra("cmd", "follow");
        mobileqq_mp.FollowRequest localFollowRequest = new mobileqq_mp.FollowRequest();
        localFollowRequest.uin.set((int)Long.parseLong(this.jdField_a_of_type_ComTencentBizPubaccountImagecollectionApiIPublicAccountImageCollectionUtils$PhotoCollectionInfo.jdField_c_of_type_JavaLangString));
        localFollowRequest.ext.set("21");
        ((NewIntent)localObject).putExtra("data", localFollowRequest.toByteArray());
        ((NewIntent)localObject).setObserver(new PublicAccountImageCollectionAdapter.4(this));
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet((NewIntent)localObject);
      }
    }
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).reportFollowEvent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentBizPubaccountImagecollectionApiIPublicAccountImageCollectionUtils$PhotoCollectionInfo.jdField_c_of_type_JavaLangString, 21);
  }
  
  public void d(boolean paramBoolean)
  {
    View localView1 = ((ViewGroup)this.jdField_a_of_type_ComTencentBizPubaccountImagecollectionPublicAccountImageCollectionListView.getParent()).getChildAt(1);
    View localView2 = ((ViewGroup)this.jdField_a_of_type_ComTencentBizPubaccountImagecollectionPublicAccountImageCollectionListView.getParent()).getChildAt(2);
    if (localView2 != null)
    {
      if (localView1 == null) {
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
  }
  
  public int getCount()
  {
    ArrayList localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
    if (localArrayList == null) {
      return 1;
    }
    return localArrayList.size() + 2;
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
    View localView = paramView;
    int i = 0;
    this.jdField_d_of_type_Int = 0;
    int j = getItemViewType(paramInt);
    boolean bool = a(j, localView);
    Object localObject = null;
    if (bool)
    {
      if (j != 0)
      {
        if (j == 1)
        {
          localObject = (PublicAccountImageCollectionAdapter.ImageItemHolder)paramView.getTag();
          ((PublicAccountImageCollectionAdapter.ImageItemHolder)localObject).jdField_a_of_type_Int = paramInt;
          localView.setTag(localObject);
          paramView = null;
          break label513;
        }
      }
      else
      {
        paramView = (PublicAccountImageCollectionAdapter.CoverHolder)paramView.getTag();
        break label513;
      }
    }
    else
    {
      if (j == 0) {
        break label225;
      }
      if (j == 1) {
        break label104;
      }
    }
    paramView = null;
    break label513;
    label104:
    localView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131559609, paramViewGroup, false);
    localObject = new PublicAccountImageCollectionAdapter.ImageItemHolder();
    ((PublicAccountImageCollectionAdapter.ImageItemHolder)localObject).jdField_a_of_type_ComTencentMobileqqWidgetImageProgressCircle = ((ImageProgressCircle)localView.findViewById(2131373222));
    ((PublicAccountImageCollectionAdapter.ImageItemHolder)localObject).jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetZImageView = ((ZImageView)localView.findViewById(2131373212));
    ((PublicAccountImageCollectionAdapter.ImageItemHolder)localObject).jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131368474));
    ((PublicAccountImageCollectionAdapter.ImageItemHolder)localObject).jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetVideoFeedsAlphaMaskView = ((VideoFeedsAlphaMaskView)localView.findViewById(2131370711));
    ((PublicAccountImageCollectionAdapter.ImageItemHolder)localObject).jdField_a_of_type_AndroidViewView = localView.findViewById(2131376818);
    ((PublicAccountImageCollectionAdapter.ImageItemHolder)localObject).jdField_a_of_type_Int = paramInt;
    localView.setTag(localObject);
    paramView = null;
    break label513;
    label225:
    localView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131559608, paramViewGroup, false);
    paramView = localView.getLayoutParams();
    paramView.height = this.jdField_e_of_type_Int;
    localView.setLayoutParams(paramView);
    paramView = new PublicAccountImageCollectionAdapter.CoverHolder();
    paramView.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetZImageView = ((ZImageView)localView.findViewById(2131368512));
    paramView.jdField_a_of_type_ComTencentMobileqqWidgetImageProgressCircle = ((ImageProgressCircle)localView.findViewById(2131368513));
    paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131368514));
    paramView.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131368519));
    paramView.d = ((TextView)localView.findViewById(2131368520));
    paramView.c = ((TextView)localView.findViewById(2131368515));
    paramView.b = ((TextView)localView.findViewById(2131368507));
    paramView.b = ((TextView)localView.findViewById(2131368507));
    paramView.e = ((TextView)localView.findViewById(2131368522));
    paramView.jdField_a_of_type_AndroidWidgetButton = ((Button)localView.findViewById(2131368517));
    paramView.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetVideoFeedsAlphaMaskView = ((VideoFeedsAlphaMaskView)localView.findViewById(2131370711));
    paramView.jdField_a_of_type_AndroidViewView = localView.findViewById(2131368521);
    paramView.f = ((TextView)localView.findViewById(2131368516));
    paramView.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_AndroidWidgetButton = paramView.jdField_a_of_type_AndroidWidgetButton;
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidViewView = paramView.jdField_a_of_type_AndroidViewView;
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView = paramView.e;
    localView.setTag(paramView);
    label513:
    if (j == 1)
    {
      a((PublicAccountImageCollectionAdapter.ImageItemHolder)localObject, paramInt);
      paramView = localView;
    }
    else if (j == 0)
    {
      a(paramView);
      paramView = localView;
    }
    else
    {
      paramView = localView;
      if (j == 2)
      {
        if (!this.jdField_g_of_type_Boolean)
        {
          paramView = "";
          localObject = paramView;
          if (this.jdField_b_of_type_JavaUtilArrayList != null) {
            for (;;)
            {
              localObject = paramView;
              if (this.jdField_b_of_type_JavaUtilArrayList.size() <= i) {
                break;
              }
              localObject = paramView;
              if (i >= 6) {
                break;
              }
              localObject = (IPublicAccountImageCollectionUtils.RecommendItemInfo)this.jdField_b_of_type_JavaUtilArrayList.get(i);
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append(paramView);
              localStringBuilder.append(((IPublicAccountImageCollectionUtils.RecommendItemInfo)localObject).d);
              localStringBuilder.append("&");
              paramView = localStringBuilder.toString();
              i += 1;
            }
          }
          ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, this.jdField_c_of_type_JavaLangString, "0X8007B93", "0X8007B93", 0, 0, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, (String)localObject, "", false);
        }
        this.jdField_g_of_type_Boolean = true;
        if (this.jdField_a_of_type_ComTencentBizPubaccountImagecollectionPublicAccountImageCollectionRecommendViewWrapper == null) {
          this.jdField_a_of_type_ComTencentBizPubaccountImagecollectionPublicAccountImageCollectionRecommendViewWrapper = new PublicAccountImageCollectionRecommendViewWrapper(this.jdField_a_of_type_AndroidAppActivity, this.jdField_b_of_type_JavaUtilArrayList, this.jdField_e_of_type_Int, this.jdField_f_of_type_Int, this.jdField_d_of_type_Boolean);
        }
        localObject = this.jdField_a_of_type_ComTencentBizPubaccountImagecollectionPublicAccountImageCollectionRecommendViewWrapper;
        paramView = localView;
        if (localObject != null) {
          paramView = ((PublicAccountImageCollectionRecommendViewWrapper)localObject).a(this.jdField_a_of_type_AndroidAppActivity, localView, paramViewGroup);
        }
      }
    }
    paramView.setLongClickable(true);
    paramView.setOnTouchListener(new PublicAccountImageCollectionAdapter.2(this, paramInt));
    return paramView;
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
      return;
    }
    if (paramView == this.jdField_a_of_type_AndroidViewView)
    {
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, this.jdField_c_of_type_JavaLangString, "0X8007B8D", "0X8007B8D", 0, 0, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, "", "", false);
      c();
    }
  }
  
  public boolean onScale(ScaleGestureDetector paramScaleGestureDetector)
  {
    return false;
  }
  
  public boolean onScaleBegin(ScaleGestureDetector paramScaleGestureDetector)
  {
    return false;
  }
  
  public void onScaleEnd(ScaleGestureDetector paramScaleGestureDetector) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.imagecollection.PublicAccountImageCollectionAdapter
 * JD-Core Version:    0.7.0.1
 */