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
  private GestureDetector A;
  private boolean B = true;
  private int C;
  private View D;
  private boolean E;
  private LruCache<String, URL> F = null;
  private NewPublicAccountObserver G;
  private PublicAccountImageCollectionListView.ListViewEventListener H = new PublicAccountImageCollectionAdapter.1(this);
  final int a = 0;
  final int b = 1;
  final int c = 2;
  public ArrayList<IPublicAccountImageCollectionUtils.PhotoItemInfo> d = null;
  Button e;
  View f;
  TextView g;
  boolean h = false;
  boolean i = false;
  float j;
  int k = 0;
  int l;
  int m;
  boolean n = false;
  boolean o = false;
  boolean p = false;
  String q = "";
  String r = "";
  String s = "";
  private PublicAccountImageCollectionListView t;
  private Context u;
  private Activity v;
  private QQAppInterface w;
  private IPublicAccountImageCollectionUtils.PhotoCollectionInfo x = null;
  private ArrayList<IPublicAccountImageCollectionUtils.RecommendItemInfo> y = null;
  private PublicAccountImageCollectionRecommendViewWrapper z;
  
  public PublicAccountImageCollectionAdapter(Context paramContext, PublicAccountImageCollectionListView paramPublicAccountImageCollectionListView, QQAppInterface paramQQAppInterface)
  {
    this.u = paramContext.getApplicationContext();
    this.v = ((Activity)paramContext);
    this.t = paramPublicAccountImageCollectionListView;
    this.w = paramQQAppInterface;
    this.t.a(this.H);
    this.j = this.t.getResources().getDisplayMetrics().density;
    if (f()) {
      this.l = (e()[1] - g());
    } else {
      this.l = e()[1];
    }
    this.m = e()[0];
    this.t.setScreenHeight(this.l);
    this.F = new LruCache(15);
    a(paramContext);
  }
  
  private void a(ZImageView paramZImageView, ImageRequest paramImageRequest, ImageProgressCircle paramImageProgressCircle, int paramInt)
  {
    ColorDrawable localColorDrawable = new ColorDrawable(Color.parseColor("#000000"));
    if ((paramImageRequest != null) && (paramImageRequest.a != null))
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("loadImage url = ");
        localStringBuilder.append(paramImageRequest.a);
        localStringBuilder.append(" reqWidth = ");
        localStringBuilder.append(paramImageRequest.b);
        localStringBuilder.append(" reqHeight = ");
        localStringBuilder.append(paramImageRequest.c);
        QLog.d("PublicAccountImageCollectionAdapter", 2, localStringBuilder.toString());
      }
      boolean bool;
      if (AbsDownloader.getFile(paramImageRequest.a.toString()) != null) {
        bool = true;
      } else {
        bool = false;
      }
      if (bool) {
        ((IPublicAccountImageCollectionPreloadManager)QRoute.api(IPublicAccountImageCollectionPreloadManager.class)).doStatisticReportForImageHit(true, paramInt);
      } else {
        ((IPublicAccountImageCollectionPreloadManager)QRoute.api(IPublicAccountImageCollectionPreloadManager.class)).doStatisticReportForImageHit(false, paramInt);
      }
      long l1 = NetConnInfoCenter.getServerTimeMillis();
      paramZImageView.setImagePlaceHolder(localColorDrawable).setImageForImageCollection(paramImageRequest, new PublicAccountImageCollectionAdapter.6(this, bool, l1, paramImageProgressCircle));
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
  
  private void b(int paramInt)
  {
    Toast.makeText(this.u, paramInt, 0).show();
  }
  
  private int[] e()
  {
    int[] arrayOfInt = new int[2];
    Display localDisplay = this.v.getWindowManager().getDefaultDisplay();
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
  
  private boolean f()
  {
    return Build.VERSION.SDK_INT < 19;
  }
  
  private int g()
  {
    Resources localResources = this.v.getResources();
    return localResources.getDimensionPixelSize(localResources.getIdentifier("status_bar_height", "dimen", "android"));
  }
  
  private void h()
  {
    Button localButton = this.e;
    if ((localButton != null) && (this.h))
    {
      localButton.setText(this.u.getResources().getString(2131893004));
      this.e.setBackgroundDrawable(this.u.getResources().getDrawable(2130842623));
    }
  }
  
  private void i()
  {
    Button localButton = this.e;
    if (localButton != null)
    {
      if (this.h)
      {
        localButton.setVisibility(8);
        return;
      }
      if ((!TextUtils.isEmpty(this.x.c)) && (!this.x.c.equals("0")))
      {
        this.e.setVisibility(0);
        this.e.setBackgroundDrawable(this.u.getResources().getDrawable(2130839460));
        this.e.setText(this.u.getResources().getString(2131893005));
      }
    }
  }
  
  private void j()
  {
    int i2 = this.t.getLastVisiblePosition();
    int i3 = this.t.getFirstVisiblePosition();
    int i1 = 0;
    while (i1 <= i2 - i3)
    {
      Object localObject = this.t.getChildAt(i1);
      if ((((View)localObject).getTag() != null) && ((((View)localObject).getTag() instanceof PublicAccountImageCollectionAdapter.ImageItemHolder)))
      {
        localObject = (PublicAccountImageCollectionAdapter.ImageItemHolder)((View)localObject).getTag();
        if (((PublicAccountImageCollectionAdapter.ImageItemHolder)localObject).b.getVisibility() == 0)
        {
          this.B = false;
          ((PublicAccountImageCollectionAdapter.ImageItemHolder)localObject).b.setVisibility(8);
        }
        else
        {
          this.B = true;
          ((PublicAccountImageCollectionAdapter.ImageItemHolder)localObject).b.setVisibility(0);
        }
      }
      i1 += 1;
    }
    if (this.B)
    {
      d(true);
      return;
    }
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, this.s, "0X8007B92", "0X8007B92", 0, 0, this.q, this.r, "", "", false);
    d(false);
  }
  
  private void k()
  {
    Object localObject1 = this.D;
    if (localObject1 != null)
    {
      if (!(((View)localObject1).getTag() instanceof PublicAccountImageCollectionAdapter.ImageItemHolder)) {
        return;
      }
      if (!this.t.b(this.D).booleanValue()) {
        return;
      }
      localObject1 = new Intent(this.u, PublicAccountImageCollectionActivity.class);
      Object localObject2 = ((ZImageView)((ViewGroup)this.D).getChildAt(0)).getImageMatrix();
      float[] arrayOfFloat = new float[9];
      ((Matrix)localObject2).getValues(arrayOfFloat);
      localObject2 = this.d;
      if (localObject2 == null) {
        return;
      }
      localObject2 = (IPublicAccountImageCollectionUtils.PhotoItemInfo)((ArrayList)localObject2).get(this.k - 1);
      String str = ((IPublicAccountImageCollectionUtils.PhotoItemInfo)localObject2).a;
      int i1 = a(localObject2)[0];
      int i2 = a(localObject2)[1];
      ZImageView localZImageView = (ZImageView)((ViewGroup)this.D).getChildAt(0);
      int i3 = localZImageView.getWidth();
      int i4 = localZImageView.getHeight();
      if (!TextUtils.isEmpty(str))
      {
        ((Intent)localObject1).putExtra("doubleBitMapPath", str);
        ((Intent)localObject1).putExtra("urlImageHeight", i2);
        ((Intent)localObject1).putExtra("urlImageWidth", i1);
        ((Intent)localObject1).putExtra("urlImageWidthReal", i3);
        ((Intent)localObject1).putExtra("urlImageHeightReal", i4);
        ((Intent)localObject1).putExtra("imageMatrix", arrayOfFloat);
        this.v.startActivity((Intent)localObject1);
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, this.s, "0X8007B91", "0X8007B91", 0, 0, this.q, this.r, ((IPublicAccountImageCollectionUtils.PhotoItemInfo)localObject2).a, "2", false);
      }
    }
  }
  
  public void a()
  {
    if (this.v != null) {
      this.v = null;
    }
    Object localObject = this.F;
    if (localObject != null) {
      ((LruCache)localObject).evictAll();
    }
    if (this.H != null) {
      this.H = null;
    }
    if (this.D != null) {
      this.D = null;
    }
    localObject = this.w;
    if (localObject != null) {
      ((QQAppInterface)localObject).removeObserver(this.G);
    }
  }
  
  public void a(int paramInt)
  {
    this.C = paramInt;
    if (this.g != null)
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
        ((StringBuilder)localObject).append(HardCodeUtil.a(2131906562));
        localObject = ((StringBuilder)localObject).toString();
      }
      TextView localTextView = this.g;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(HardCodeUtil.a(2131906542));
      localStringBuilder.append((String)localObject);
      localTextView.setText(localStringBuilder.toString());
    }
  }
  
  void a(Context paramContext)
  {
    this.A = new GestureDetector(paramContext, new PublicAccountImageCollectionAdapter.PublicAccountOnGestureListener(this, null));
  }
  
  void a(View paramView)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("PublicAccountImageCollectionAdapter", 2, "showMoreDescription");
    }
    paramView = (TextView)paramView;
    if (!this.p)
    {
      paramView.setMaxLines(2147483647);
      paramView.setEllipsize(null);
      this.p = true;
      return;
    }
    paramView.setMaxLines(3);
    paramView.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
    this.p = false;
  }
  
  void a(PublicAccountImageCollectionAdapter.CoverHolder paramCoverHolder)
  {
    Object localObject1 = this.x;
    if (localObject1 == null)
    {
      if (this.n)
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("PublicAccountImageCollectionAdapter", 2, "setDataForImageCover getPhotoCollectionInfo error");
        }
        paramCoverHolder.l.setVisibility(0);
        a(paramCoverHolder.b);
        ((PublicAccountImageCollectionMainActivityImpl)this.v).hideUserGuide();
        return;
      }
      paramCoverHolder.l.setVisibility(8);
      return;
    }
    if ((((IPublicAccountImageCollectionUtils.PhotoCollectionInfo)localObject1).h != null) && (QLog.isColorLevel()))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("setDataForImageCover title =");
      ((StringBuilder)localObject1).append(this.x.e);
      ((StringBuilder)localObject1).append("; coverUrl =");
      ((StringBuilder)localObject1).append(this.x.h.a);
      ((StringBuilder)localObject1).append("; accountName = ");
      ((StringBuilder)localObject1).append(this.x.h.b);
      ((StringBuilder)localObject1).append("; author=");
      ((StringBuilder)localObject1).append(this.x.h.d);
      ((StringBuilder)localObject1).append("; time =");
      ((StringBuilder)localObject1).append(this.x.h.c);
      QLog.d("PublicAccountImageCollectionAdapter", 2, ((StringBuilder)localObject1).toString());
    }
    paramCoverHolder.k.setVisibility(0);
    paramCoverHolder.c.setText(this.x.e);
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("");
    ((StringBuilder)localObject1).append(this.C);
    localObject1 = ((StringBuilder)localObject1).toString();
    int i1 = this.C;
    if (i1 > 1000000)
    {
      localObject1 = "100万+";
    }
    else if (i1 > 100000)
    {
      double d1 = i1;
      Double.isNaN(d1);
      d1 /= 100000.0D;
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(new Formatter().format("%.1f", new Object[] { Double.valueOf(d1) }).toString());
      ((StringBuilder)localObject1).append(HardCodeUtil.a(2131906579));
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    Object localObject2 = paramCoverHolder.h;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(HardCodeUtil.a(2131906533));
    localStringBuilder.append((String)localObject1);
    ((TextView)localObject2).setText(localStringBuilder.toString());
    localObject1 = this.x.h;
    if (localObject1 != null)
    {
      paramCoverHolder.g.setText(((IPublicAccountImageCollectionUtils.PhotoFirstItemInfo)localObject1).b);
      paramCoverHolder.e.setText(((IPublicAccountImageCollectionUtils.PhotoFirstItemInfo)localObject1).d);
      paramCoverHolder.f.setText(((IPublicAccountImageCollectionUtils.PhotoFirstItemInfo)localObject1).c);
      if (!TextUtils.isEmpty(((IPublicAccountImageCollectionUtils.PhotoFirstItemInfo)localObject1).b))
      {
        paramCoverHolder.d.setVisibility(0);
        paramCoverHolder.d.setImageDrawable(FaceDrawable.getFaceDrawable(this.w, 1, this.x.c));
      }
      else
      {
        paramCoverHolder.d.setVisibility(8);
      }
      localObject2 = new ImageRequest();
      ((ImageRequest)localObject2).a = b(((IPublicAccountImageCollectionUtils.PhotoFirstItemInfo)localObject1).a);
      a(paramCoverHolder.a, (ImageRequest)localObject2, paramCoverHolder.b, 0);
    }
    if ((TextUtils.isEmpty(this.x.c)) || (this.x.c.equals("0")))
    {
      new RelativeLayout.LayoutParams(-1, -1).setMargins(AIOUtils.b(12.0F, this.u.getResources()), AIOUtils.b(25.0F, this.u.getResources()), 0, 0);
      paramCoverHolder.d.setVisibility(8);
      paramCoverHolder.h.setTextSize(2, 14.0F);
      paramCoverHolder.g.setVisibility(8);
      paramCoverHolder.e.setTextSize(2, 14.0F);
      paramCoverHolder.f.setTextSize(2, 14.0F);
      this.f.setOnClickListener(null);
    }
    if (!this.i) {
      ((PublicAccountImageCollectionMainActivityImpl)this.v).showUserGuide();
    }
    this.i = true;
  }
  
  void a(PublicAccountImageCollectionAdapter.ImageItemHolder paramImageItemHolder, int paramInt)
  {
    Object localObject1 = this.d;
    if (localObject1 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PublicAccountImageCollectionAdapter", 2, "setDataForImageFeeds mPhotoItemInfo is null");
      }
      return;
    }
    int i2 = 1;
    if (paramInt >= 1)
    {
      if (paramInt > ((ArrayList)localObject1).size()) {
        return;
      }
      localObject1 = (IPublicAccountImageCollectionUtils.PhotoItemInfo)this.d.get(paramInt - 1);
      if ((localObject1 != null) && (((IPublicAccountImageCollectionUtils.PhotoItemInfo)localObject1).d != 0))
      {
        if (this.m == 0) {
          return;
        }
        int i3 = ((IPublicAccountImageCollectionUtils.PhotoItemInfo)localObject1).e / ((IPublicAccountImageCollectionUtils.PhotoItemInfo)localObject1).d;
        int i1 = this.l;
        int i4 = this.m;
        if (i3 <= i1 / i4) {
          i1 = i4 * ((IPublicAccountImageCollectionUtils.PhotoItemInfo)localObject1).e / ((IPublicAccountImageCollectionUtils.PhotoItemInfo)localObject1).d;
        }
        ((IPublicAccountImageCollectionUtils.PhotoItemInfo)localObject1).f = true;
        Object localObject3 = (RelativeLayout.LayoutParams)paramImageItemHolder.c.getLayoutParams();
        Object localObject2 = (RelativeLayout.LayoutParams)paramImageItemHolder.b.getLayoutParams();
        ViewGroup.LayoutParams localLayoutParams = paramImageItemHolder.a.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject3).width = this.m;
        ((RelativeLayout.LayoutParams)localObject3).height = i1;
        paramImageItemHolder.c.setLayoutParams((ViewGroup.LayoutParams)localObject3);
        URL localURL = b(((IPublicAccountImageCollectionUtils.PhotoItemInfo)localObject1).a);
        if (localURL == null) {
          return;
        }
        ImageRequest localImageRequest = new ImageRequest();
        localImageRequest.a = localURL;
        localImageRequest.b = a(localObject1)[0];
        localImageRequest.c = a(localObject1)[1];
        a(paramImageItemHolder.c, localImageRequest, paramImageItemHolder.d, paramImageItemHolder.f);
        if ((((IPublicAccountImageCollectionUtils.PhotoItemInfo)localObject1).d / ((IPublicAccountImageCollectionUtils.PhotoItemInfo)localObject1).e <= 1.3D) || (TextUtils.isEmpty(((IPublicAccountImageCollectionUtils.PhotoItemInfo)localObject1).b)) || (((IPublicAccountImageCollectionUtils.PhotoItemInfo)localObject1).b.equals(" "))) {
          i2 = 0;
        }
        if (i2 != 0)
        {
          paramImageItemHolder.b.setMinHeight(AIOUtils.b(97.0F, this.u.getResources()));
          localLayoutParams.height = (((RelativeLayout.LayoutParams)localObject3).height + AIOUtils.b(97.0F, this.u.getResources()));
          paramImageItemHolder.b.setGravity(16);
        }
        else
        {
          localLayoutParams.height = ((RelativeLayout.LayoutParams)localObject3).height;
          paramImageItemHolder.b.setGravity(80);
        }
        float f1;
        if (i1 > this.l - (int)(this.j * 88.0F))
        {
          localObject3 = paramImageItemHolder.b;
          f1 = this.j;
          ((TextView)localObject3).setPadding((int)(f1 * 15.0F), (int)(10.0F * f1), (int)(15.0F * f1), (int)(f1 * 44.0F));
        }
        else
        {
          localObject3 = paramImageItemHolder.b;
          f1 = this.j;
          ((TextView)localObject3).setPadding((int)(f1 * 15.0F), (int)(f1 * 10.0F), (int)(15.0F * f1), (int)(f1 * 10.0F));
        }
        paramImageItemHolder.b.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        paramImageItemHolder.a.setLayoutParams(localLayoutParams);
        paramImageItemHolder.b.setMaxLines(3);
        paramImageItemHolder.b.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(paramInt);
        ((StringBuilder)localObject2).append("/");
        ((StringBuilder)localObject2).append(this.d.size());
        ((StringBuilder)localObject2).append("  ");
        ((StringBuilder)localObject2).append(((IPublicAccountImageCollectionUtils.PhotoItemInfo)localObject1).b);
        localObject2 = ((StringBuilder)localObject2).toString();
        paramImageItemHolder.b.setText((CharSequence)localObject2);
        if ((!TextUtils.isEmpty(((IPublicAccountImageCollectionUtils.PhotoItemInfo)localObject1).b)) && (!((IPublicAccountImageCollectionUtils.PhotoItemInfo)localObject1).b.equals(" "))) {
          paramImageItemHolder.b.setBackgroundColor(Color.parseColor("#66000000"));
        } else {
          paramImageItemHolder.b.setBackgroundColor(0);
        }
        if (!this.B) {
          paramImageItemHolder.b.setVisibility(8);
        } else {
          paramImageItemHolder.b.setVisibility(0);
        }
        paramImageItemHolder.b.setOnClickListener(new PublicAccountImageCollectionAdapter.3(this));
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
      localStringBuilder.append(paramPhotoCollectionInfo.b);
      localStringBuilder.append("; puin=");
      localStringBuilder.append(paramPhotoCollectionInfo.c);
      localStringBuilder.append("; imageUrl=");
      localStringBuilder.append(paramPhotoCollectionInfo.d);
      QLog.d("PublicAccountImageCollectionAdapter", 2, localStringBuilder.toString());
    }
    this.x = paramPhotoCollectionInfo;
    this.r = this.x.b;
    this.s = this.x.c;
    this.d = this.x.i;
    this.t.setPhotoCollectionInfo(this.d);
  }
  
  public void a(String paramString)
  {
    this.q = paramString;
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
    this.y = paramArrayList;
    this.t.setRecommendInfo(this.y);
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
    this.n = paramBoolean;
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
      int i1 = paramPhotoItemInfo.d;
      int i2 = this.m;
      if (i1 > i2)
      {
        arrayOfInt[0] = i2;
        i1 = paramPhotoItemInfo.e / paramPhotoItemInfo.d;
        i2 = this.l;
        int i3 = this.m;
        if (i1 > i2 / i3)
        {
          arrayOfInt[1] = i2;
          return arrayOfInt;
        }
        arrayOfInt[1] = (i3 * paramPhotoItemInfo.e / paramPhotoItemInfo.d);
        return arrayOfInt;
      }
      arrayOfInt[0] = paramPhotoItemInfo.d;
      i1 = paramPhotoItemInfo.e;
      i2 = this.l;
      if (i1 > i2)
      {
        arrayOfInt[1] = i2;
        return arrayOfInt;
      }
      arrayOfInt[1] = paramPhotoItemInfo.e;
    }
    return arrayOfInt;
  }
  
  public URL b(String paramString)
  {
    URL localURL = (URL)this.F.get(paramString);
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
        this.F.put(paramString, localObject1);
        localObject2 = localObject1;
      }
    }
    return localObject2;
  }
  
  public void b()
  {
    PublicAccountImageCollectionRecommendViewWrapper localPublicAccountImageCollectionRecommendViewWrapper = this.z;
    if (localPublicAccountImageCollectionRecommendViewWrapper != null) {
      localPublicAccountImageCollectionRecommendViewWrapper.a(this.y);
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
    this.o = paramBoolean;
  }
  
  void c()
  {
    if (this.x != null)
    {
      ActivityURIRequest localActivityURIRequest = new ActivityURIRequest(this.v, "/pubaccount/detail");
      localActivityURIRequest.extra().putString("uin", this.x.c);
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
    this.h = paramBoolean;
    i();
  }
  
  void d()
  {
    Object localObject = (IPublicAccountDataManager)this.w.getRuntimeService(IPublicAccountDataManager.class, "all");
    if (localObject != null)
    {
      localObject = (PublicAccountDetailImpl)((IPublicAccountDataManager)localObject).findAccountDetailInfo(this.x.c);
      if ((localObject != null) && (((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).getAccountType(((PublicAccountDetailImpl)localObject).accountFlag) != -4))
      {
        this.w.removeObserver(this.G);
        this.G = new NewPublicAccountObserver(new PublicAccountImageCollectionAdapter.5(this));
        this.w.addObserver(this.G);
        PublicAccountStateReporter.a(this.w, true, this.x.c, 21);
      }
      else
      {
        localObject = new NewIntent(this.u, ((IPublicAccountServlet)QRoute.api(IPublicAccountServlet.class)).getServletClass());
        ((NewIntent)localObject).putExtra("cmd", "follow");
        mobileqq_mp.FollowRequest localFollowRequest = new mobileqq_mp.FollowRequest();
        localFollowRequest.uin.set((int)Long.parseLong(this.x.c));
        localFollowRequest.ext.set("21");
        ((NewIntent)localObject).putExtra("data", localFollowRequest.toByteArray());
        ((NewIntent)localObject).setObserver(new PublicAccountImageCollectionAdapter.4(this));
        this.w.startServlet((NewIntent)localObject);
      }
    }
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).reportFollowEvent(this.w, this.x.c, 21);
  }
  
  public void d(boolean paramBoolean)
  {
    View localView1 = ((ViewGroup)this.t.getParent()).getChildAt(1);
    View localView2 = ((ViewGroup)this.t.getParent()).getChildAt(2);
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
    ArrayList localArrayList = this.d;
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
    int i1 = 0;
    this.k = 0;
    int i2 = getItemViewType(paramInt);
    boolean bool = a(i2, localView);
    Object localObject = null;
    if (bool)
    {
      if (i2 != 0)
      {
        if (i2 == 1)
        {
          localObject = (PublicAccountImageCollectionAdapter.ImageItemHolder)paramView.getTag();
          ((PublicAccountImageCollectionAdapter.ImageItemHolder)localObject).f = paramInt;
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
      if (i2 == 0) {
        break label225;
      }
      if (i2 == 1) {
        break label104;
      }
    }
    paramView = null;
    break label513;
    label104:
    localView = LayoutInflater.from(this.u).inflate(2131625638, paramViewGroup, false);
    localObject = new PublicAccountImageCollectionAdapter.ImageItemHolder();
    ((PublicAccountImageCollectionAdapter.ImageItemHolder)localObject).d = ((ImageProgressCircle)localView.findViewById(2131440831));
    ((PublicAccountImageCollectionAdapter.ImageItemHolder)localObject).c = ((ZImageView)localView.findViewById(2131440821));
    ((PublicAccountImageCollectionAdapter.ImageItemHolder)localObject).b = ((TextView)localView.findViewById(2131435371));
    ((PublicAccountImageCollectionAdapter.ImageItemHolder)localObject).e = ((VideoFeedsAlphaMaskView)localView.findViewById(2131437989));
    ((PublicAccountImageCollectionAdapter.ImageItemHolder)localObject).a = localView.findViewById(2131445148);
    ((PublicAccountImageCollectionAdapter.ImageItemHolder)localObject).f = paramInt;
    localView.setTag(localObject);
    paramView = null;
    break label513;
    label225:
    localView = LayoutInflater.from(this.u).inflate(2131625637, paramViewGroup, false);
    paramView = localView.getLayoutParams();
    paramView.height = this.l;
    localView.setLayoutParams(paramView);
    paramView = new PublicAccountImageCollectionAdapter.CoverHolder();
    paramView.a = ((ZImageView)localView.findViewById(2131435416));
    paramView.b = ((ImageProgressCircle)localView.findViewById(2131435417));
    paramView.c = ((TextView)localView.findViewById(2131435418));
    paramView.d = ((ImageView)localView.findViewById(2131435423));
    paramView.g = ((TextView)localView.findViewById(2131435424));
    paramView.f = ((TextView)localView.findViewById(2131435419));
    paramView.e = ((TextView)localView.findViewById(2131435411));
    paramView.e = ((TextView)localView.findViewById(2131435411));
    paramView.h = ((TextView)localView.findViewById(2131435426));
    paramView.i = ((Button)localView.findViewById(2131435421));
    paramView.j = ((VideoFeedsAlphaMaskView)localView.findViewById(2131437989));
    paramView.k = localView.findViewById(2131435425);
    paramView.l = ((TextView)localView.findViewById(2131435420));
    paramView.m = paramInt;
    this.e = paramView.i;
    this.e.setOnClickListener(this);
    this.f = paramView.k;
    this.f.setOnClickListener(this);
    this.g = paramView.h;
    localView.setTag(paramView);
    label513:
    if (i2 == 1)
    {
      a((PublicAccountImageCollectionAdapter.ImageItemHolder)localObject, paramInt);
      paramView = localView;
    }
    else if (i2 == 0)
    {
      a(paramView);
      paramView = localView;
    }
    else
    {
      paramView = localView;
      if (i2 == 2)
      {
        if (!this.E)
        {
          paramView = "";
          localObject = paramView;
          if (this.y != null) {
            for (;;)
            {
              localObject = paramView;
              if (this.y.size() <= i1) {
                break;
              }
              localObject = paramView;
              if (i1 >= 6) {
                break;
              }
              localObject = (IPublicAccountImageCollectionUtils.RecommendItemInfo)this.y.get(i1);
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append(paramView);
              localStringBuilder.append(((IPublicAccountImageCollectionUtils.RecommendItemInfo)localObject).d);
              localStringBuilder.append("&");
              paramView = localStringBuilder.toString();
              i1 += 1;
            }
          }
          ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, this.s, "0X8007B93", "0X8007B93", 0, 0, this.q, this.r, (String)localObject, "", false);
        }
        this.E = true;
        if (this.z == null) {
          this.z = new PublicAccountImageCollectionRecommendViewWrapper(this.v, this.y, this.l, this.m, this.o);
        }
        localObject = this.z;
        paramView = localView;
        if (localObject != null) {
          paramView = ((PublicAccountImageCollectionRecommendViewWrapper)localObject).a(this.v, localView, paramViewGroup);
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
    if (paramView == this.e)
    {
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, this.s, "0X8007B8E", "0X8007B8E", 0, 0, this.q, this.r, "", "", false);
      d();
      return;
    }
    if (paramView == this.f)
    {
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, this.s, "0X8007B8D", "0X8007B8D", 0, 0, this.q, this.r, "", "", false);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.imagecollection.PublicAccountImageCollectionAdapter
 * JD-Core Version:    0.7.0.1
 */