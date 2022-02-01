package com.tencent.mobileqq.apollo.store;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.Utils;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.apollo.listener.OnApolloViewListener;
import com.tencent.mobileqq.apollo.utils.api.IApolloUtil;
import com.tencent.mobileqq.apollo.utils.api.impl.ApolloActionHelperImpl;
import com.tencent.mobileqq.apollo.utils.api.impl.ApolloUtilImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.face.util.FaceUtil;
import com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloRender;
import com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloRenderInterfaceImpl;
import com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloTextureView;
import com.tencent.mobileqq.cmshow.brickengine.apollo.IRenderCallback;
import com.tencent.mobileqq.drawable.RoundRectColorDrawable;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import com.tencent.widget.ActionSheetAdapter;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qzone.QZoneShareManager;
import java.io.File;
import java.lang.ref.WeakReference;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

public class ApolloImageShareLayout
  extends RelativeLayout
  implements DialogInterface.OnDismissListener, Handler.Callback, View.OnClickListener, AdapterView.OnItemClickListener, OnApolloViewListener, IRenderCallback, ActionSheet.OnButtonClickListener
{
  private long A;
  private long B;
  private ActionSheet C;
  private ActionSheetAdapter D;
  private long E;
  boolean a;
  WeakReferenceHandler b = new WeakReferenceHandler(Looper.getMainLooper(), this);
  private int[] c;
  private int d;
  private ApolloTextureView e;
  private float f;
  private boolean g;
  private RelativeLayout h;
  private TextView i;
  private ImageView j;
  private ImageView k;
  private ImageView l;
  private ImageView m;
  private boolean n;
  private ImageView o;
  private int p;
  private int q;
  private WeakReference<AppInterface> r;
  private Activity s;
  private int t;
  private String u = "apollo_fakeurl";
  private int v;
  private int w;
  private String x;
  private QQProgressDialog y;
  private int z;
  
  public ApolloImageShareLayout(Activity paramActivity)
  {
    super(paramActivity);
    this.s = paramActivity;
  }
  
  private void b(boolean paramBoolean)
  {
    Object localObject = this.e;
    if ((localObject != null) && (this.n) && (((ApolloTextureView)localObject).getRenderImpl() != null))
    {
      if (!paramBoolean)
      {
        this.e.getRenderImpl().a();
        this.e.getRenderImpl().a(1, null, this.d, this.f, 1.05F * (this.p / DeviceInfoUtil.A() / 2.0F), 0.0F);
        localObject = this.c;
        if ((localObject != null) && (localObject.length > 0)) {
          this.e.getRenderImpl().a(1, null, this.c, null);
        }
      }
      localObject = ApolloActionHelperImpl.getActionRscPath(5, -1, this.d, true);
      this.e.getRenderImpl().a(1, null, 5, 1000000, localObject[0], localObject[1]);
    }
  }
  
  @TargetApi(14)
  private Bitmap c()
  {
    try
    {
      if (Build.VERSION.SDK_INT >= 14)
      {
        Bitmap localBitmap = this.e.getBitmap();
        return localBitmap;
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      QLog.e("[cmshow]ApolloImageShareLayout", 2, localOutOfMemoryError.getMessage());
      return null;
    }
    catch (Exception localException)
    {
      QLog.e("[cmshow]ApolloImageShareLayout", 2, localException.getMessage());
    }
    return null;
  }
  
  protected void a()
  {
    if (this.s == null) {
      return;
    }
    Object localObject = new ArrayList();
    ((List)localObject).add(ActionSheetAdapter.a(1));
    ((List)localObject).add(ActionSheetAdapter.a(0));
    if (this.D == null) {
      this.D = new ActionSheetAdapter(this.s);
    }
    this.D.a((List)localObject);
    if (this.C == null) {
      this.C = ActionSheetAdapter.a(this.s, this.D, this, this, this, false);
    }
    localObject = this.C;
    if ((localObject != null) && (!((ActionSheet)localObject).isShowing())) {
      this.C.show();
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.n = true;
    if (this.d > 0) {
      b(false);
    }
  }
  
  public void a(int paramInt1, int paramInt2, AppInterface paramAppInterface, int paramInt3, int[] paramArrayOfInt, float paramFloat)
  {
    this.r = new WeakReference(paramAppInterface);
    this.d = paramInt3;
    this.c = paramArrayOfInt;
    this.f = paramFloat;
    super.setBackgroundColor(-1778384896);
    if (!this.g)
    {
      this.g = true;
      super.setClickable(true);
      this.h = new RelativeLayout(getContext());
      this.v = ((int)(ViewUtils.dip2px(296.0F) * 0.96F));
      paramInt3 = this.v;
      this.w = (paramInt3 * 880 / 592);
      paramAppInterface = new RelativeLayout.LayoutParams(paramInt3, this.w);
      paramAppInterface.addRule(14);
      paramAppInterface.addRule(10);
      paramInt3 = paramInt2;
      if (paramInt2 == 0) {
        paramInt3 = (int)DeviceInfoUtil.E();
      }
      paramInt2 = paramInt1;
      if (paramInt1 == 0) {
        paramInt2 = (int)DeviceInfoUtil.D();
      }
      paramInt1 = (paramInt3 - ImmersiveUtils.getStatusBarHeight(super.getContext()) - this.w) / 2;
      paramAppInterface.topMargin = paramInt1;
      this.h.setDrawingCacheEnabled(true);
      super.addView(this.h, paramAppInterface);
      paramFloat *= 368.0F;
      this.p = ((int)paramFloat);
      this.q = ((int)(paramFloat * 1.3F));
      this.e = new ApolloTextureView(getContext(), null);
      this.e.init(this);
      paramAppInterface = new RelativeLayout.LayoutParams(this.p, this.q);
      paramAppInterface.addRule(10);
      paramAppInterface.addRule(14);
      int i1 = this.w;
      int i2 = i1 * 272 / 880;
      this.t = (i1 - this.q - i2);
      paramAppInterface.topMargin = (this.t + paramInt1);
      super.addView(this.e, paramAppInterface);
      this.e.getRender().setRenderCallback(this);
      this.z = (this.t + paramInt1 + this.q / 2);
      i1 = (int)(ViewUtils.dip2px(40.0F) * 0.96F);
      this.o = new ImageView(getContext());
      this.o.setBackgroundResource(2130838470);
      paramAppInterface = new RelativeLayout.LayoutParams(i1, i1);
      paramAppInterface.addRule(14, -1);
      paramAppInterface.addRule(12, -1);
      paramAppInterface.bottomMargin = ((paramInt3 - ImmersiveUtils.getStatusBarHeight(super.getContext()) - this.w - paramInt1 - i1) / 2);
      this.o.setOnClickListener(this);
      super.addView(this.o, paramAppInterface);
      this.i = new TextView(getContext());
      this.i.setTextColor(-1);
      this.i.setTextSize(18.0F);
      this.i.setSingleLine(true);
      this.i.setMaxWidth((int)(this.v * 0.8F));
      this.i.setEllipsize(TextUtils.TruncateAt.END);
      paramAppInterface = new RelativeLayout.LayoutParams(-2, -2);
      paramAppInterface.topMargin = ((int)(ViewUtils.dip2px(40.0F) * 0.96F));
      paramAppInterface.addRule(10);
      paramAppInterface.addRule(14);
      this.h.addView(this.i, paramAppInterface);
      paramAppInterface = new View(super.getContext());
      paramArrayOfInt = new RelativeLayout.LayoutParams(this.v, (int)(ViewUtils.dip2px(55.0F) * 0.96F));
      paramArrayOfInt.addRule(10);
      paramArrayOfInt.addRule(14);
      paramArrayOfInt.topMargin = ((int)(this.w + paramInt1 - ViewUtils.dip2px(55.0F) * 0.96F));
      paramAppInterface.setBackgroundResource(2130838481);
      super.addView(paramAppInterface, paramArrayOfInt);
      paramInt3 = (int)(ViewUtils.dip2px(25.0F) * 0.96F);
      paramFloat = ViewUtils.dip2px(41.0F) * 0.96F;
      this.k = new ImageView(getContext());
      paramAppInterface = new RelativeLayout.LayoutParams(paramInt3, paramInt3);
      paramAppInterface.topMargin = ((int)(this.w + paramInt1 - ViewUtils.dip2px(42.0F) * 0.96F));
      float f2 = (paramInt2 - this.v) / 2;
      float f1 = paramInt3 / 2;
      paramAppInterface.leftMargin = ((int)(f2 + paramFloat - f1));
      paramAppInterface.addRule(10);
      paramAppInterface.addRule(9);
      super.addView(this.k, paramAppInterface);
      this.k.setOnClickListener(this);
      this.k.setBackgroundResource(2130838627);
      this.m = new ImageView(getContext());
      paramAppInterface = new RelativeLayout.LayoutParams(paramInt3, paramInt3);
      paramAppInterface.topMargin = ((int)(this.w + paramInt1 - ViewUtils.dip2px(42.0F) * 0.96F));
      i1 = this.v;
      f2 = (i1 - 2.0F * paramFloat) / 3.0F;
      paramAppInterface.leftMargin = ((int)((paramInt2 - i1) / 2 + paramFloat + f2 - f1));
      paramAppInterface.addRule(10);
      paramAppInterface.addRule(9);
      super.addView(this.m, paramAppInterface);
      this.m.setOnClickListener(this);
      this.m.setBackgroundResource(2130838625);
      this.j = new ImageView(getContext());
      paramAppInterface = new RelativeLayout.LayoutParams(paramInt3, paramInt3);
      paramAppInterface.topMargin = ((int)(this.w + paramInt1 - ViewUtils.dip2px(42.0F) * 0.96F));
      paramAppInterface.rightMargin = ((int)((paramInt2 - this.v) / 2 + paramFloat + f2 - f1));
      paramAppInterface.addRule(10);
      paramAppInterface.addRule(11);
      super.addView(this.j, paramAppInterface);
      this.j.setOnClickListener(this);
      this.j.setBackgroundResource(2130838626);
      this.l = new ImageView(getContext());
      paramAppInterface = new RelativeLayout.LayoutParams(paramInt3, paramInt3);
      paramAppInterface.topMargin = ((int)(paramInt1 + this.w - ViewUtils.dip2px(42.0F) * 0.96F));
      paramAppInterface.rightMargin = ((int)((paramInt2 - this.v) / 2 + paramFloat - f1));
      paramAppInterface.addRule(10);
      paramAppInterface.addRule(11);
      super.addView(this.l, paramAppInterface);
      this.l.setOnClickListener(this);
      this.l.setBackgroundResource(2130838628);
    }
  }
  
  public void a(int paramInt1, int paramInt2, String paramString)
  {
    paramString = this.e;
    if (paramString != null) {
      paramString.stopLoopDelayed(0L);
    }
  }
  
  public void a(int paramInt, String paramString) {}
  
  public void a(int paramInt, int[] paramArrayOfInt, float paramFloat, String paramString1, String paramString2)
  {
    super.setVisibility(0);
    this.x = paramString2;
    if ((paramInt == this.d) && (paramArrayOfInt == this.c) && (paramFloat == this.f))
    {
      b(true);
    }
    else
    {
      this.d = paramInt;
      this.c = paramArrayOfInt;
      this.f = paramFloat;
      b(false);
    }
    if (!TextUtils.isEmpty(paramString2)) {
      this.i.setText(paramString2);
    }
    if ((paramString1 != null) && (!paramString1.equals(this.u)))
    {
      this.u = paramString1;
      if (TextUtils.isEmpty(this.u)) {
        this.u = "https://cmshow.qq.com/qqshow/admindata/comdata/vipApollo_mall_share_background/sha1.61aa8c34c1eefb6207b65e500da2f5eb.png";
      }
      paramArrayOfInt = URLDrawable.URLDrawableOptions.obtain();
      paramInt = this.w;
      paramArrayOfInt.mRequestHeight = paramInt;
      int i1 = this.v;
      paramArrayOfInt.mRequestWidth = i1;
      paramString1 = new RoundRectColorDrawable(-8305182, 20.0F, i1, paramInt);
      paramArrayOfInt.mLoadingDrawable = paramString1;
      paramArrayOfInt.mFailedDrawable = paramString1;
      paramArrayOfInt = ((IApolloUtil)QRoute.api(IApolloUtil.class)).getDrawable(Utils.Crc64String(this.u), paramArrayOfInt, this.u);
      this.h.setBackgroundDrawable(paramArrayOfInt);
    }
    VipUtils.a(null, "cmshow", "Apollo", "PageView", 2, 0, new String[0]);
  }
  
  public void a(String paramString) {}
  
  public void a(boolean paramBoolean)
  {
    super.setVisibility(8);
    if (paramBoolean)
    {
      super.removeAllViews();
      localObject = this.e;
      if ((localObject != null) && (((ApolloTextureView)localObject).getRenderImpl() != null)) {
        this.e.getRenderImpl().c();
      }
    }
    this.b.removeCallbacksAndMessages(null);
    Object localObject = this.C;
    if (localObject != null) {
      ((ActionSheet)localObject).dismiss();
    }
    b();
  }
  
  void b()
  {
    QQProgressDialog localQQProgressDialog = this.y;
    if ((localQQProgressDialog != null) && (localQQProgressDialog.isShowing())) {
      this.y.dismiss();
    }
  }
  
  void b(String paramString)
  {
    if (this.y == null) {
      this.y = new QQProgressDialog(this.s, this.z);
    }
    this.y.a(paramString);
    this.y.show();
  }
  
  public void b_(int paramInt, String paramString) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    b();
    switch (paramMessage.what)
    {
    default: 
      return false;
    case 18: 
      if (super.getVisibility() != 0) {
        return false;
      }
      paramMessage = (String)paramMessage.obj;
      if (TextUtils.isEmpty(paramMessage))
      {
        if (QLog.isColorLevel()) {
          QLog.e("[cmshow]ApolloImageShareLayout", 1, "update avatar share QQ apolloImage no file");
        }
        return false;
      }
      if (!new File(paramMessage).exists())
      {
        if (QLog.isColorLevel()) {
          QLog.e("[cmshow]ApolloImageShareLayout", 1, "update avatar share QQ apolloImage no file");
        }
        return false;
      }
      int i1 = ProfileCardUtil.b(this.s);
      localObject1 = new Intent();
      ((Intent)localObject1).putExtra("keyFromUpdateAvatar", true);
      ((Intent)localObject1).putExtra("Business_Origin", 100);
      localObject2 = this.s;
      PhotoUtils.startPhotoEdit((Intent)localObject1, (Activity)localObject2, localObject2.getClass().getName(), i1, i1, 1080, 1080, paramMessage, FaceUtil.a());
      return false;
    case 17: 
      localObject1 = this.C;
      if (localObject1 != null) {
        ((ActionSheet)localObject1).dismiss();
      }
      if (super.getVisibility() != 0) {
        return false;
      }
      paramMessage = (String)paramMessage.obj;
      if (TextUtils.isEmpty(paramMessage))
      {
        if (QLog.isColorLevel()) {
          QLog.e("[cmshow]ApolloImageShareLayout", 1, "onItemClick share QQ apolloImage no file");
        }
        return false;
      }
      if (!new File(paramMessage).exists())
      {
        if (QLog.isColorLevel()) {
          QLog.e("[cmshow]ApolloImageShareLayout", 1, "onItemClick share QQ apolloImage no file");
        }
        return false;
      }
      localObject1 = this.s;
      if (localObject1 == null) {
        break label562;
      }
      ApolloUtilImpl.forwardImage_Common((Activity)localObject1, paramMessage, null, 1);
      return false;
    case 16: 
      localObject1 = this.C;
      if (localObject1 != null) {
        ((ActionSheet)localObject1).dismiss();
      }
      if (super.getVisibility() != 0) {
        return false;
      }
      localObject1 = this.r;
      if (localObject1 == null) {
        return false;
      }
      localObject1 = (AppInterface)((WeakReference)localObject1).get();
      if (localObject1 == null) {
        return false;
      }
      paramMessage = (String)paramMessage.obj;
      if (TextUtils.isEmpty(paramMessage))
      {
        if (QLog.isColorLevel()) {
          QLog.e("[cmshow]ApolloImageShareLayout", 1, "onItemClick share QZone apolloImage no file");
        }
        return false;
      }
      localObject2 = new Bundle();
      ArrayList localArrayList = new ArrayList();
      try
      {
        localArrayList.add(URLDecoder.decode(paramMessage));
        ((Bundle)localObject2).putStringArrayList("images", localArrayList);
        ((Bundle)localObject2).putString("summary", HardCodeUtil.a(2131898646));
        ((Bundle)localObject2).putInt("req_type", 7);
        ((Bundle)localObject2).putBoolean("key_need_save_draft", false);
        QZoneShareManager.publishToQzone((AppInterface)localObject1, this.s, (Bundle)localObject2, this, 15);
        return false;
      }
      catch (Exception paramMessage)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("publishToQzone:");
        ((StringBuilder)localObject1).append(paramMessage.getMessage());
        QLog.d("[cmshow]ApolloImageShareLayout", 2, ((StringBuilder)localObject1).toString());
        return false;
      }
    }
    if (super.getVisibility() != 0) {
      return false;
    }
    paramMessage = (String)paramMessage.obj;
    if (TextUtils.isEmpty(paramMessage)) {
      return false;
    }
    Object localObject1 = getContext();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(HardCodeUtil.a(2131898644));
    ((StringBuilder)localObject2).append(paramMessage);
    QQToast.makeText((Context)localObject1, ((StringBuilder)localObject2).toString(), 1).show();
    label562:
    return false;
  }
  
  @TargetApi(14)
  public void onClick(View paramView)
  {
    long l1;
    if (paramView == this.j)
    {
      l1 = System.currentTimeMillis();
      if (l1 - this.A < 800L) {
        return;
      }
      this.A = l1;
      if (this.a)
      {
        QQToast.makeText(getContext(), HardCodeUtil.a(2131898643), 0).show();
        return;
      }
      this.a = true;
      if (QLog.isColorLevel())
      {
        paramView = new StringBuilder();
        paramView.append("download Request:");
        paramView.append(l1);
        QLog.d("[cmshow]ApolloImageShareLayout", 2, paramView.toString());
      }
      if (Build.VERSION.SDK_INT >= 14)
      {
        b(HardCodeUtil.a(2131898642));
        ThreadManager.executeOnSubThread(new ApolloImageShareLayout.SaveImageTask(this, c(), this.e.getWidth(), this.e.getHeight(), 15, l1));
      }
      VipUtils.a(null, "cmshow", "Apollo", "SaveClick", 0, 0, new String[0]);
      return;
    }
    if (paramView == this.k)
    {
      if (this.n)
      {
        paramView = this.e;
        if ((paramView != null) && (paramView.getRenderImpl() != null))
        {
          paramView = ApolloActionHelperImpl.getActionRscPath(5, -1, this.d, true);
          this.e.getRenderImpl().a(1, null, 5, 1000000, paramView[0], paramView[1]);
        }
      }
      VipUtils.a(null, "cmshow", "Apollo", "PoseClick", 0, 0, new String[0]);
      return;
    }
    if (paramView == this.l)
    {
      a();
      VipUtils.a(null, "cmshow", "Apollo", "ShareClick", 0, 0, new String[0]);
      return;
    }
    if (paramView == this.o)
    {
      VipUtils.a(null, "cmshow", "Apollo", "CloseClick", 0, 0, new String[0]);
      a(false);
      return;
    }
    if (paramView == this.m)
    {
      l1 = System.currentTimeMillis();
      if (l1 - this.B < 800L) {
        return;
      }
      this.B = l1;
      if (this.a)
      {
        QQToast.makeText(getContext(), HardCodeUtil.a(2131898640), 0).show();
        return;
      }
      this.a = true;
      VipUtils.a(null, "cmshow", "Apollo", "headClick", 0, 0, new String[0]);
      b(HardCodeUtil.a(2131898641));
      ThreadManager.executeOnSubThread(new ApolloImageShareLayout.SaveImageTask(this, c(), this.e.getWidth(), this.e.getHeight(), 18, System.currentTimeMillis()));
    }
  }
  
  public void onClick(View paramView, int paramInt)
  {
    paramView = this.C;
    if (paramView != null) {
      paramView.dismiss();
    }
  }
  
  public void onDismiss(DialogInterface paramDialogInterface) {}
  
  @TargetApi(14)
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    long l1 = System.currentTimeMillis();
    if (l1 - this.E < 2000L) {
      return;
    }
    this.E = l1;
    if (paramLong == 1L)
    {
      if (Build.VERSION.SDK_INT >= 14)
      {
        b(HardCodeUtil.a(2131898639));
        ThreadManager.executeOnSubThread(new ApolloImageShareLayout.SaveImageTask(this, c(), this.e.getWidth(), this.e.getHeight(), 16, l1));
      }
      VipUtils.a(null, "cmshow", "Apollo", "Share2Qzone", 0, 0, new String[0]);
      return;
    }
    if (Build.VERSION.SDK_INT >= 14)
    {
      b(HardCodeUtil.a(2131898645));
      ThreadManager.executeOnSubThread(new ApolloImageShareLayout.SaveImageTask(this, c(), this.e.getWidth(), this.e.getHeight(), 17, l1));
    }
    VipUtils.a(null, "cmshow", "Apollo", "Share2QQ", 0, 0, new String[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.store.ApolloImageShareLayout
 * JD-Core Version:    0.7.0.1
 */