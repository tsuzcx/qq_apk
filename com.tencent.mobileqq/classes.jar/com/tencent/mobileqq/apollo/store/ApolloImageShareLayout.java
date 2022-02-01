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
import com.tencent.mobileqq.activity.aio.AIOUtils;
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
  private float jdField_a_of_type_Float;
  int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  ApolloTextureView jdField_a_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloTextureView;
  QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  WeakReferenceHandler jdField_a_of_type_ComTencentUtilWeakReferenceHandler = new WeakReferenceHandler(Looper.getMainLooper(), this);
  private ActionSheet jdField_a_of_type_ComTencentWidgetActionSheet;
  private ActionSheetAdapter jdField_a_of_type_ComTencentWidgetActionSheetAdapter;
  private String jdField_a_of_type_JavaLangString = "apollo_fakeurl";
  private WeakReference<AppInterface> jdField_a_of_type_JavaLangRefWeakReference;
  boolean jdField_a_of_type_Boolean;
  private int[] jdField_a_of_type_ArrayOfInt;
  int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private long jdField_c_of_type_Long;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int;
  private ImageView jdField_d_of_type_AndroidWidgetImageView;
  private int jdField_e_of_type_Int;
  private ImageView jdField_e_of_type_AndroidWidgetImageView;
  private int f;
  private int g;
  
  public ApolloImageShareLayout(Activity paramActivity)
  {
    super(paramActivity);
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
  }
  
  @TargetApi(14)
  private Bitmap a()
  {
    try
    {
      if (Build.VERSION.SDK_INT >= 14)
      {
        Bitmap localBitmap = this.jdField_a_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloTextureView.getBitmap();
        return localBitmap;
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      QLog.e("ApolloImageShareLayout", 2, localOutOfMemoryError.getMessage());
      return null;
    }
    catch (Exception localException)
    {
      QLog.e("ApolloImageShareLayout", 2, localException.getMessage());
    }
    return null;
  }
  
  private void b(boolean paramBoolean)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloTextureView;
    if ((localObject != null) && (this.jdField_c_of_type_Boolean) && (((ApolloTextureView)localObject).getRenderImpl() != null))
    {
      if (!paramBoolean)
      {
        this.jdField_a_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloTextureView.getRenderImpl().a();
        this.jdField_a_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloTextureView.getRenderImpl().a(1, null, this.jdField_c_of_type_Int, this.jdField_a_of_type_Float, 1.05F * (this.jdField_a_of_type_Int / DeviceInfoUtil.a() / 2.0F), 0.0F);
        localObject = this.jdField_a_of_type_ArrayOfInt;
        if ((localObject != null) && (localObject.length > 0)) {
          this.jdField_a_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloTextureView.getRenderImpl().a(1, null, this.jdField_a_of_type_ArrayOfInt, null);
        }
      }
      localObject = ApolloActionHelperImpl.getActionRscPath(5, -1, this.jdField_c_of_type_Int, true);
      this.jdField_a_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloTextureView.getRenderImpl().a(1, null, 5, 1000000, localObject[0], localObject[1]);
    }
  }
  
  public void OnClick(View paramView, int paramInt)
  {
    paramView = this.jdField_a_of_type_ComTencentWidgetActionSheet;
    if (paramView != null) {
      paramView.dismiss();
    }
  }
  
  protected void a()
  {
    if (this.jdField_a_of_type_AndroidAppActivity == null) {
      return;
    }
    Object localObject = new ArrayList();
    ((List)localObject).add(ActionSheetAdapter.a(1));
    ((List)localObject).add(ActionSheetAdapter.a(0));
    if (this.jdField_a_of_type_ComTencentWidgetActionSheetAdapter == null) {
      this.jdField_a_of_type_ComTencentWidgetActionSheetAdapter = new ActionSheetAdapter(this.jdField_a_of_type_AndroidAppActivity);
    }
    this.jdField_a_of_type_ComTencentWidgetActionSheetAdapter.a((List)localObject);
    if (this.jdField_a_of_type_ComTencentWidgetActionSheet == null) {
      this.jdField_a_of_type_ComTencentWidgetActionSheet = ActionSheetAdapter.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentWidgetActionSheetAdapter, this, this, this, false);
    }
    localObject = this.jdField_a_of_type_ComTencentWidgetActionSheet;
    if ((localObject != null) && (!((ActionSheet)localObject).isShowing())) {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.show();
    }
  }
  
  public void a(int paramInt1, int paramInt2, AppInterface paramAppInterface, int paramInt3, int[] paramArrayOfInt, float paramFloat)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramAppInterface);
    this.jdField_c_of_type_Int = paramInt3;
    this.jdField_a_of_type_ArrayOfInt = paramArrayOfInt;
    this.jdField_a_of_type_Float = paramFloat;
    super.setBackgroundColor(-1778384896);
    if (!this.jdField_b_of_type_Boolean)
    {
      this.jdField_b_of_type_Boolean = true;
      super.setClickable(true);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = new RelativeLayout(getContext());
      this.jdField_e_of_type_Int = ((int)(AIOUtils.b(296.0F, getResources()) * 0.96F));
      paramInt3 = this.jdField_e_of_type_Int;
      this.f = (paramInt3 * 880 / 592);
      paramAppInterface = new RelativeLayout.LayoutParams(paramInt3, this.f);
      paramAppInterface.addRule(14);
      paramAppInterface.addRule(10);
      paramInt3 = paramInt2;
      if (paramInt2 == 0) {
        paramInt3 = (int)DeviceInfoUtil.j();
      }
      paramInt2 = paramInt1;
      if (paramInt1 == 0) {
        paramInt2 = (int)DeviceInfoUtil.i();
      }
      paramInt1 = (paramInt3 - ImmersiveUtils.getStatusBarHeight(super.getContext()) - this.f) / 2;
      paramAppInterface.topMargin = paramInt1;
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setDrawingCacheEnabled(true);
      super.addView(this.jdField_a_of_type_AndroidWidgetRelativeLayout, paramAppInterface);
      paramFloat *= 368.0F;
      this.jdField_a_of_type_Int = ((int)paramFloat);
      this.jdField_b_of_type_Int = ((int)(paramFloat * 1.3F));
      this.jdField_a_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloTextureView = new ApolloTextureView(getContext(), null);
      this.jdField_a_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloTextureView.init(this);
      paramAppInterface = new RelativeLayout.LayoutParams(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
      paramAppInterface.addRule(10);
      paramAppInterface.addRule(14);
      int i = this.f;
      int j = i * 272 / 880;
      this.jdField_d_of_type_Int = (i - this.jdField_b_of_type_Int - j);
      paramAppInterface.topMargin = (this.jdField_d_of_type_Int + paramInt1);
      super.addView(this.jdField_a_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloTextureView, paramAppInterface);
      this.jdField_a_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloTextureView.getRender().setRenderCallback(this);
      this.g = (this.jdField_d_of_type_Int + paramInt1 + this.jdField_b_of_type_Int / 2);
      i = (int)(AIOUtils.b(40.0F, getResources()) * 0.96F);
      this.jdField_e_of_type_AndroidWidgetImageView = new ImageView(getContext());
      this.jdField_e_of_type_AndroidWidgetImageView.setBackgroundResource(2130838412);
      paramAppInterface = new RelativeLayout.LayoutParams(i, i);
      paramAppInterface.addRule(14, -1);
      paramAppInterface.addRule(12, -1);
      paramAppInterface.bottomMargin = ((paramInt3 - ImmersiveUtils.getStatusBarHeight(super.getContext()) - this.f - paramInt1 - i) / 2);
      this.jdField_e_of_type_AndroidWidgetImageView.setOnClickListener(this);
      super.addView(this.jdField_e_of_type_AndroidWidgetImageView, paramAppInterface);
      this.jdField_a_of_type_AndroidWidgetTextView = new TextView(getContext());
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-1);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(18.0F);
      this.jdField_a_of_type_AndroidWidgetTextView.setSingleLine(true);
      this.jdField_a_of_type_AndroidWidgetTextView.setMaxWidth((int)(this.jdField_e_of_type_Int * 0.8F));
      this.jdField_a_of_type_AndroidWidgetTextView.setEllipsize(TextUtils.TruncateAt.END);
      paramAppInterface = new RelativeLayout.LayoutParams(-2, -2);
      paramAppInterface.topMargin = ((int)(AIOUtils.b(40.0F, getResources()) * 0.96F));
      paramAppInterface.addRule(10);
      paramAppInterface.addRule(14);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_AndroidWidgetTextView, paramAppInterface);
      paramAppInterface = new View(super.getContext());
      paramArrayOfInt = new RelativeLayout.LayoutParams(this.jdField_e_of_type_Int, (int)(AIOUtils.b(55.0F, super.getResources()) * 0.96F));
      paramArrayOfInt.addRule(10);
      paramArrayOfInt.addRule(14);
      paramArrayOfInt.topMargin = ((int)(this.f + paramInt1 - AIOUtils.b(55.0F, super.getResources()) * 0.96F));
      paramAppInterface.setBackgroundResource(2130838423);
      super.addView(paramAppInterface, paramArrayOfInt);
      paramInt3 = (int)(AIOUtils.b(25.0F, getResources()) * 0.96F);
      paramFloat = AIOUtils.b(41.0F, super.getResources()) * 0.96F;
      this.jdField_b_of_type_AndroidWidgetImageView = new ImageView(getContext());
      paramAppInterface = new RelativeLayout.LayoutParams(paramInt3, paramInt3);
      paramAppInterface.topMargin = ((int)(this.f + paramInt1 - AIOUtils.b(42.0F, super.getResources()) * 0.96F));
      float f2 = (paramInt2 - this.jdField_e_of_type_Int) / 2;
      float f1 = paramInt3 / 2;
      paramAppInterface.leftMargin = ((int)(f2 + paramFloat - f1));
      paramAppInterface.addRule(10);
      paramAppInterface.addRule(9);
      super.addView(this.jdField_b_of_type_AndroidWidgetImageView, paramAppInterface);
      this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(2130838568);
      this.jdField_d_of_type_AndroidWidgetImageView = new ImageView(getContext());
      paramAppInterface = new RelativeLayout.LayoutParams(paramInt3, paramInt3);
      paramAppInterface.topMargin = ((int)(this.f + paramInt1 - AIOUtils.b(42.0F, super.getResources()) * 0.96F));
      i = this.jdField_e_of_type_Int;
      f2 = (i - 2.0F * paramFloat) / 3.0F;
      paramAppInterface.leftMargin = ((int)((paramInt2 - i) / 2 + paramFloat + f2 - f1));
      paramAppInterface.addRule(10);
      paramAppInterface.addRule(9);
      super.addView(this.jdField_d_of_type_AndroidWidgetImageView, paramAppInterface);
      this.jdField_d_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_d_of_type_AndroidWidgetImageView.setBackgroundResource(2130838566);
      this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(getContext());
      paramAppInterface = new RelativeLayout.LayoutParams(paramInt3, paramInt3);
      paramAppInterface.topMargin = ((int)(this.f + paramInt1 - AIOUtils.b(42.0F, super.getResources()) * 0.96F));
      paramAppInterface.rightMargin = ((int)((paramInt2 - this.jdField_e_of_type_Int) / 2 + paramFloat + f2 - f1));
      paramAppInterface.addRule(10);
      paramAppInterface.addRule(11);
      super.addView(this.jdField_a_of_type_AndroidWidgetImageView, paramAppInterface);
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130838567);
      this.jdField_c_of_type_AndroidWidgetImageView = new ImageView(getContext());
      paramAppInterface = new RelativeLayout.LayoutParams(paramInt3, paramInt3);
      paramAppInterface.topMargin = ((int)(paramInt1 + this.f - AIOUtils.b(42.0F, super.getResources()) * 0.96F));
      paramAppInterface.rightMargin = ((int)((paramInt2 - this.jdField_e_of_type_Int) / 2 + paramFloat - f1));
      paramAppInterface.addRule(10);
      paramAppInterface.addRule(11);
      super.addView(this.jdField_c_of_type_AndroidWidgetImageView, paramAppInterface);
      this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_c_of_type_AndroidWidgetImageView.setBackgroundResource(2130838569);
    }
  }
  
  public void a(int paramInt1, int paramInt2, String paramString)
  {
    paramString = this.jdField_a_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloTextureView;
    if (paramString != null) {
      paramString.stopLoopDelayed(0L);
    }
  }
  
  public void a(int paramInt, String paramString) {}
  
  public void a(int paramInt, int[] paramArrayOfInt, float paramFloat, String paramString1, String paramString2)
  {
    super.setVisibility(0);
    this.jdField_b_of_type_JavaLangString = paramString2;
    if ((paramInt == this.jdField_c_of_type_Int) && (paramArrayOfInt == this.jdField_a_of_type_ArrayOfInt) && (paramFloat == this.jdField_a_of_type_Float))
    {
      b(true);
    }
    else
    {
      this.jdField_c_of_type_Int = paramInt;
      this.jdField_a_of_type_ArrayOfInt = paramArrayOfInt;
      this.jdField_a_of_type_Float = paramFloat;
      b(false);
    }
    if (!TextUtils.isEmpty(paramString2)) {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString2);
    }
    if ((paramString1 != null) && (!paramString1.equals(this.jdField_a_of_type_JavaLangString)))
    {
      this.jdField_a_of_type_JavaLangString = paramString1;
      if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
        this.jdField_a_of_type_JavaLangString = "https://cmshow.qq.com/qqshow/admindata/comdata/vipApollo_mall_share_background/sha1.61aa8c34c1eefb6207b65e500da2f5eb.png";
      }
      paramArrayOfInt = URLDrawable.URLDrawableOptions.obtain();
      paramInt = this.f;
      paramArrayOfInt.mRequestHeight = paramInt;
      int i = this.jdField_e_of_type_Int;
      paramArrayOfInt.mRequestWidth = i;
      paramString1 = new RoundRectColorDrawable(-8305182, 20.0F, i, paramInt);
      paramArrayOfInt.mLoadingDrawable = paramString1;
      paramArrayOfInt.mFailedDrawable = paramString1;
      paramArrayOfInt = ((IApolloUtil)QRoute.api(IApolloUtil.class)).getDrawable(Utils.Crc64String(this.jdField_a_of_type_JavaLangString), paramArrayOfInt, this.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundDrawable(paramArrayOfInt);
    }
    VipUtils.a(null, "cmshow", "Apollo", "PageView", 2, 0, new String[0]);
  }
  
  void a(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this.jdField_a_of_type_AndroidAppActivity, this.g);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(paramString);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
  }
  
  public void a(boolean paramBoolean)
  {
    super.setVisibility(8);
    if (paramBoolean)
    {
      super.removeAllViews();
      localObject = this.jdField_a_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloTextureView;
      if ((localObject != null) && (((ApolloTextureView)localObject).getRenderImpl() != null)) {
        this.jdField_a_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloTextureView.getRenderImpl().c();
      }
    }
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeCallbacksAndMessages(null);
    Object localObject = this.jdField_a_of_type_ComTencentWidgetActionSheet;
    if (localObject != null) {
      ((ActionSheet)localObject).dismiss();
    }
    b();
  }
  
  void b()
  {
    QQProgressDialog localQQProgressDialog = this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
    if ((localQQProgressDialog != null) && (localQQProgressDialog.isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
  }
  
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
          QLog.e("ApolloImageShareLayout", 1, "update avatar share QQ apolloImage no file");
        }
        return false;
      }
      if (!new File(paramMessage).exists())
      {
        if (QLog.isColorLevel()) {
          QLog.e("ApolloImageShareLayout", 1, "update avatar share QQ apolloImage no file");
        }
        return false;
      }
      int i = ProfileCardUtil.b(this.jdField_a_of_type_AndroidAppActivity);
      localObject1 = new Intent();
      ((Intent)localObject1).putExtra("keyFromUpdateAvatar", true);
      ((Intent)localObject1).putExtra("Business_Origin", 100);
      localObject2 = this.jdField_a_of_type_AndroidAppActivity;
      PhotoUtils.startPhotoEdit((Intent)localObject1, (Activity)localObject2, localObject2.getClass().getName(), i, i, 1080, 1080, paramMessage, FaceUtil.a());
      return false;
    case 17: 
      localObject1 = this.jdField_a_of_type_ComTencentWidgetActionSheet;
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
          QLog.e("ApolloImageShareLayout", 1, "onItemClick share QQ apolloImage no file");
        }
        return false;
      }
      if (!new File(paramMessage).exists())
      {
        if (QLog.isColorLevel()) {
          QLog.e("ApolloImageShareLayout", 1, "onItemClick share QQ apolloImage no file");
        }
        return false;
      }
      localObject1 = this.jdField_a_of_type_AndroidAppActivity;
      if (localObject1 == null) {
        break label562;
      }
      ApolloUtilImpl.forwardImage_Common((Activity)localObject1, paramMessage, null, 1);
      return false;
    case 16: 
      localObject1 = this.jdField_a_of_type_ComTencentWidgetActionSheet;
      if (localObject1 != null) {
        ((ActionSheet)localObject1).dismiss();
      }
      if (super.getVisibility() != 0) {
        return false;
      }
      localObject1 = this.jdField_a_of_type_JavaLangRefWeakReference;
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
          QLog.e("ApolloImageShareLayout", 1, "onItemClick share QZone apolloImage no file");
        }
        return false;
      }
      localObject2 = new Bundle();
      ArrayList localArrayList = new ArrayList();
      try
      {
        localArrayList.add(URLDecoder.decode(paramMessage));
        ((Bundle)localObject2).putStringArrayList("images", localArrayList);
        ((Bundle)localObject2).putString("summary", HardCodeUtil.a(2131700619));
        ((Bundle)localObject2).putInt("req_type", 7);
        ((Bundle)localObject2).putBoolean("key_need_save_draft", false);
        QZoneShareManager.publishToQzone((AppInterface)localObject1, this.jdField_a_of_type_AndroidAppActivity, (Bundle)localObject2, this, 15);
        return false;
      }
      catch (Exception paramMessage)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("publishToQzone:");
        ((StringBuilder)localObject1).append(paramMessage.getMessage());
        QLog.d("ApolloImageShareLayout", 2, ((StringBuilder)localObject1).toString());
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
    ((StringBuilder)localObject2).append(HardCodeUtil.a(2131700617));
    ((StringBuilder)localObject2).append(paramMessage);
    QQToast.a((Context)localObject1, ((StringBuilder)localObject2).toString(), 1).a();
    label562:
    return false;
  }
  
  @TargetApi(14)
  public void onClick(View paramView)
  {
    long l;
    if (paramView == this.jdField_a_of_type_AndroidWidgetImageView)
    {
      l = System.currentTimeMillis();
      if (l - this.jdField_a_of_type_Long < 800L) {
        return;
      }
      this.jdField_a_of_type_Long = l;
      if (this.jdField_a_of_type_Boolean)
      {
        QQToast.a(getContext(), HardCodeUtil.a(2131700616), 0).a();
        return;
      }
      this.jdField_a_of_type_Boolean = true;
      if (QLog.isColorLevel())
      {
        paramView = new StringBuilder();
        paramView.append("download Request:");
        paramView.append(l);
        QLog.d("ApolloImageShareLayout", 2, paramView.toString());
      }
      if (Build.VERSION.SDK_INT >= 14)
      {
        a(HardCodeUtil.a(2131700615));
        ThreadManager.executeOnSubThread(new ApolloImageShareLayout.SaveImageTask(this, a(), this.jdField_a_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloTextureView.getWidth(), this.jdField_a_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloTextureView.getHeight(), 15, l));
      }
      VipUtils.a(null, "cmshow", "Apollo", "SaveClick", 0, 0, new String[0]);
      return;
    }
    if (paramView == this.jdField_b_of_type_AndroidWidgetImageView)
    {
      if (this.jdField_c_of_type_Boolean)
      {
        paramView = this.jdField_a_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloTextureView;
        if ((paramView != null) && (paramView.getRenderImpl() != null))
        {
          paramView = ApolloActionHelperImpl.getActionRscPath(5, -1, this.jdField_c_of_type_Int, true);
          this.jdField_a_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloTextureView.getRenderImpl().a(1, null, 5, 1000000, paramView[0], paramView[1]);
        }
      }
      VipUtils.a(null, "cmshow", "Apollo", "PoseClick", 0, 0, new String[0]);
      return;
    }
    if (paramView == this.jdField_c_of_type_AndroidWidgetImageView)
    {
      a();
      VipUtils.a(null, "cmshow", "Apollo", "ShareClick", 0, 0, new String[0]);
      return;
    }
    if (paramView == this.jdField_e_of_type_AndroidWidgetImageView)
    {
      VipUtils.a(null, "cmshow", "Apollo", "CloseClick", 0, 0, new String[0]);
      a(false);
      return;
    }
    if (paramView == this.jdField_d_of_type_AndroidWidgetImageView)
    {
      l = System.currentTimeMillis();
      if (l - this.jdField_b_of_type_Long < 800L) {
        return;
      }
      this.jdField_b_of_type_Long = l;
      if (this.jdField_a_of_type_Boolean)
      {
        QQToast.a(getContext(), HardCodeUtil.a(2131700613), 0).a();
        return;
      }
      this.jdField_a_of_type_Boolean = true;
      VipUtils.a(null, "cmshow", "Apollo", "headClick", 0, 0, new String[0]);
      a(HardCodeUtil.a(2131700614));
      ThreadManager.executeOnSubThread(new ApolloImageShareLayout.SaveImageTask(this, a(), this.jdField_a_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloTextureView.getWidth(), this.jdField_a_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloTextureView.getHeight(), 18, System.currentTimeMillis()));
    }
  }
  
  public void onDismiss(DialogInterface paramDialogInterface) {}
  
  @TargetApi(14)
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    long l = System.currentTimeMillis();
    if (l - this.jdField_c_of_type_Long < 2000L) {
      return;
    }
    this.jdField_c_of_type_Long = l;
    if (paramLong == 1L)
    {
      if (Build.VERSION.SDK_INT >= 14)
      {
        a(HardCodeUtil.a(2131700612));
        ThreadManager.executeOnSubThread(new ApolloImageShareLayout.SaveImageTask(this, a(), this.jdField_a_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloTextureView.getWidth(), this.jdField_a_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloTextureView.getHeight(), 16, l));
      }
      VipUtils.a(null, "cmshow", "Apollo", "Share2Qzone", 0, 0, new String[0]);
      return;
    }
    if (Build.VERSION.SDK_INT >= 14)
    {
      a(HardCodeUtil.a(2131700618));
      ThreadManager.executeOnSubThread(new ApolloImageShareLayout.SaveImageTask(this, a(), this.jdField_a_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloTextureView.getWidth(), this.jdField_a_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloTextureView.getHeight(), 17, l));
    }
    VipUtils.a(null, "cmshow", "Apollo", "Share2QQ", 0, 0, new String[0]);
  }
  
  public void onNotifyLongTouch(String paramString) {}
  
  public void onNotifyStatusChanged(int paramInt, String paramString) {}
  
  public void onSurfaceReady(int paramInt1, int paramInt2)
  {
    this.jdField_c_of_type_Boolean = true;
    if (this.jdField_c_of_type_Int > 0) {
      b(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.store.ApolloImageShareLayout
 * JD-Core Version:    0.7.0.1
 */