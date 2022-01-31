package com.tencent.mobileqq.apollo.store;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
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
import com.tencent.mobileqq.apollo.ApolloRender;
import com.tencent.mobileqq.apollo.ApolloRenderInterfaceImpl;
import com.tencent.mobileqq.apollo.ApolloTextureView;
import com.tencent.mobileqq.apollo.IRenderCallback;
import com.tencent.mobileqq.apollo.OnApolloViewListener;
import com.tencent.mobileqq.apollo.task.ApolloActionHelper;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.drawable.RoundRectColorDrawable;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.VipUtils;
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
import zai;

public class ApolloImageShareLayout
  extends RelativeLayout
  implements DialogInterface.OnDismissListener, Handler.Callback, View.OnClickListener, AdapterView.OnItemClickListener, IRenderCallback, OnApolloViewListener, ActionSheet.OnButtonClickListener
{
  private float jdField_a_of_type_Float;
  int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  ApolloTextureView jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView;
  public WeakReferenceHandler a;
  private ActionSheet jdField_a_of_type_ComTencentWidgetActionSheet;
  private ActionSheetAdapter jdField_a_of_type_ComTencentWidgetActionSheetAdapter;
  private String jdField_a_of_type_JavaLangString = "apollo_fakeurl";
  private WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  public boolean a;
  private int[] jdField_a_of_type_ArrayOfInt;
  int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int;
  private ImageView jdField_d_of_type_AndroidWidgetImageView;
  private int e;
  private int f;
  
  public ApolloImageShareLayout(Activity paramActivity)
  {
    super(paramActivity);
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler = new WeakReferenceHandler(Looper.getMainLooper(), this);
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
  }
  
  @TargetApi(14)
  private Bitmap a()
  {
    Bitmap localBitmap = null;
    try
    {
      if (Build.VERSION.SDK_INT >= 14) {
        localBitmap = this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.getBitmap();
      }
      return localBitmap;
    }
    catch (Exception localException)
    {
      QLog.e("ApolloImageShareLayout", 2, localException.getMessage());
      return null;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      QLog.e("ApolloImageShareLayout", 2, localOutOfMemoryError.getMessage());
    }
    return null;
  }
  
  private void b(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView != null) && (this.jdField_c_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.getRenderImpl() != null))
    {
      if (!paramBoolean)
      {
        this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.getRenderImpl().a();
        this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.getRenderImpl().a(1, null, this.jdField_c_of_type_Int, this.jdField_a_of_type_Float, this.jdField_a_of_type_Int / DeviceInfoUtil.a() / 2.0F * 1.05F, 0.0F);
        if ((this.jdField_a_of_type_ArrayOfInt != null) && (this.jdField_a_of_type_ArrayOfInt.length > 0)) {
          this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.getRenderImpl().a(1, null, this.jdField_a_of_type_ArrayOfInt, null);
        }
      }
      String[] arrayOfString = ApolloActionHelper.a(5, -1, this.jdField_c_of_type_Int, true);
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.getRenderImpl().a(1, null, 5, 1000000, arrayOfString[0], arrayOfString[1]);
    }
  }
  
  public void OnClick(View paramView, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentWidgetActionSheet != null) {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
    }
  }
  
  protected void a()
  {
    if (this.jdField_a_of_type_AndroidAppActivity == null) {}
    do
    {
      return;
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(ActionSheetAdapter.a(1));
      localArrayList.add(ActionSheetAdapter.a(0));
      if (this.jdField_a_of_type_ComTencentWidgetActionSheetAdapter == null) {
        this.jdField_a_of_type_ComTencentWidgetActionSheetAdapter = new ActionSheetAdapter(this.jdField_a_of_type_AndroidAppActivity);
      }
      this.jdField_a_of_type_ComTencentWidgetActionSheetAdapter.a(localArrayList);
      if (this.jdField_a_of_type_ComTencentWidgetActionSheet == null) {
        this.jdField_a_of_type_ComTencentWidgetActionSheet = ActionSheetAdapter.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentWidgetActionSheetAdapter, this, this, this, false);
      }
    } while ((this.jdField_a_of_type_ComTencentWidgetActionSheet == null) || (this.jdField_a_of_type_ComTencentWidgetActionSheet.isShowing()));
    this.jdField_a_of_type_ComTencentWidgetActionSheet.show();
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
      this.e = ((int)(AIOUtils.a(296.0F, getResources()) * 0.96F));
      this.f = (this.e * 880 / 592);
      paramAppInterface = new RelativeLayout.LayoutParams(this.e, this.f);
      paramAppInterface.addRule(14);
      paramAppInterface.addRule(10);
      paramInt3 = paramInt2;
      if (paramInt2 == 0) {
        paramInt3 = (int)DeviceInfoUtil.k();
      }
      paramInt2 = paramInt1;
      if (paramInt1 == 0) {
        paramInt2 = (int)DeviceInfoUtil.j();
      }
      paramInt1 = (paramInt3 - ImmersiveUtils.a(super.getContext()) - this.f) / 2;
      paramAppInterface.topMargin = paramInt1;
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setDrawingCacheEnabled(true);
      super.addView(this.jdField_a_of_type_AndroidWidgetRelativeLayout, paramAppInterface);
      int i = this.f * 272 / 880;
      this.jdField_a_of_type_Int = ((int)(368.0F * paramFloat));
      this.jdField_b_of_type_Int = ((int)(368.0F * paramFloat * 1.3F));
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView = new ApolloTextureView(getContext(), null);
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.init(this);
      paramAppInterface = new RelativeLayout.LayoutParams(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
      paramAppInterface.addRule(10);
      paramAppInterface.addRule(14);
      this.jdField_d_of_type_Int = (this.f - this.jdField_b_of_type_Int - i);
      paramAppInterface.topMargin = (this.jdField_d_of_type_Int + paramInt1);
      super.addView(this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView, paramAppInterface);
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.getRender().setRenderCallback(this);
      i = (int)(AIOUtils.a(40.0F, getResources()) * 0.96F);
      this.jdField_d_of_type_AndroidWidgetImageView = new ImageView(getContext());
      this.jdField_d_of_type_AndroidWidgetImageView.setBackgroundResource(2130838019);
      paramAppInterface = new RelativeLayout.LayoutParams(i, i);
      paramAppInterface.addRule(14, -1);
      paramAppInterface.addRule(12, -1);
      paramAppInterface.bottomMargin = ((paramInt3 - ImmersiveUtils.a(super.getContext()) - this.f - paramInt1 - i) / 2);
      this.jdField_d_of_type_AndroidWidgetImageView.setOnClickListener(this);
      super.addView(this.jdField_d_of_type_AndroidWidgetImageView, paramAppInterface);
      this.jdField_a_of_type_AndroidWidgetTextView = new TextView(getContext());
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-1);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(18.0F);
      this.jdField_a_of_type_AndroidWidgetTextView.setSingleLine(true);
      this.jdField_a_of_type_AndroidWidgetTextView.setMaxWidth((int)(this.e * 0.8F));
      this.jdField_a_of_type_AndroidWidgetTextView.setEllipsize(TextUtils.TruncateAt.END);
      paramAppInterface = new RelativeLayout.LayoutParams(-2, -2);
      paramAppInterface.topMargin = ((int)(AIOUtils.a(40.0F, getResources()) * 0.96F));
      paramAppInterface.addRule(10);
      paramAppInterface.addRule(14);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_AndroidWidgetTextView, paramAppInterface);
      paramAppInterface = new View(super.getContext());
      paramArrayOfInt = new RelativeLayout.LayoutParams(this.e, (int)(AIOUtils.a(55.0F, super.getResources()) * 0.96F));
      paramArrayOfInt.addRule(10);
      paramArrayOfInt.addRule(14);
      paramArrayOfInt.topMargin = ((int)(this.f + paramInt1 - AIOUtils.a(55.0F, super.getResources()) * 0.96F));
      paramAppInterface.setBackgroundResource(2130838030);
      super.addView(paramAppInterface, paramArrayOfInt);
      paramInt3 = (int)(AIOUtils.a(25.0F, getResources()) * 0.96F);
      this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(getContext());
      paramAppInterface = new RelativeLayout.LayoutParams(paramInt3, paramInt3);
      paramAppInterface.topMargin = ((int)(this.f + paramInt1 - AIOUtils.a(42.0F, super.getResources()) * 0.96F));
      paramAppInterface.addRule(10);
      paramAppInterface.addRule(14);
      super.addView(this.jdField_a_of_type_AndroidWidgetImageView, paramAppInterface);
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130838154);
      this.jdField_b_of_type_AndroidWidgetImageView = new ImageView(getContext());
      paramAppInterface = new RelativeLayout.LayoutParams(paramInt3, paramInt3);
      paramAppInterface.topMargin = ((int)(this.f + paramInt1 - AIOUtils.a(42.0F, super.getResources()) * 0.96F));
      paramAppInterface.leftMargin = ((int)((paramInt2 - this.e) / 2 + AIOUtils.a(41.0F, getResources()) * 0.96F));
      paramAppInterface.addRule(10);
      paramAppInterface.addRule(9);
      super.addView(this.jdField_b_of_type_AndroidWidgetImageView, paramAppInterface);
      this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(2130838155);
      this.jdField_c_of_type_AndroidWidgetImageView = new ImageView(getContext());
      paramAppInterface = new RelativeLayout.LayoutParams(paramInt3, paramInt3);
      paramAppInterface.topMargin = ((int)(this.f + paramInt1 - AIOUtils.a(42.0F, super.getResources()) * 0.96F));
      paramFloat = (paramInt2 - this.e) / 2;
      paramAppInterface.rightMargin = ((int)(0.96F * AIOUtils.a(41.0F, getResources()) + paramFloat));
      paramAppInterface.addRule(10);
      paramAppInterface.addRule(11);
      super.addView(this.jdField_c_of_type_AndroidWidgetImageView, paramAppInterface);
      this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_c_of_type_AndroidWidgetImageView.setBackgroundResource(2130838156);
    }
  }
  
  public void a(int paramInt1, int paramInt2, String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.stopLoopDelayed(0L);
    }
  }
  
  public void a(int paramInt, String paramString) {}
  
  public void a(int paramInt, int[] paramArrayOfInt, float paramFloat, String paramString1, String paramString2)
  {
    super.setVisibility(0);
    this.jdField_b_of_type_JavaLangString = paramString2;
    if ((paramInt != this.jdField_c_of_type_Int) || (paramArrayOfInt != this.jdField_a_of_type_ArrayOfInt) || (paramFloat != this.jdField_a_of_type_Float))
    {
      this.jdField_c_of_type_Int = paramInt;
      this.jdField_a_of_type_ArrayOfInt = paramArrayOfInt;
      this.jdField_a_of_type_Float = paramFloat;
      b(false);
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(paramString2)) {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString2);
      }
      if ((paramString1 != null) && (!paramString1.equals(this.jdField_a_of_type_JavaLangString)))
      {
        this.jdField_a_of_type_JavaLangString = paramString1;
        if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
          this.jdField_a_of_type_JavaLangString = "http://cmshow.qq.com/qqshow/admindata/comdata/vipApollo_mall_share_background/sha1.61aa8c34c1eefb6207b65e500da2f5eb.png";
        }
        paramArrayOfInt = URLDrawable.URLDrawableOptions.obtain();
        paramArrayOfInt.mRequestHeight = this.f;
        paramArrayOfInt.mRequestWidth = this.e;
        paramString1 = new RoundRectColorDrawable(-8305182, 20.0F, this.e, this.f);
        paramArrayOfInt.mLoadingDrawable = paramString1;
        paramArrayOfInt.mFailedDrawable = paramString1;
        paramArrayOfInt = ApolloImageDownloader.a(Utils.Crc64String(this.jdField_a_of_type_JavaLangString), paramArrayOfInt, this.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundDrawable(paramArrayOfInt);
      }
      VipUtils.a(null, "cmshow", "Apollo", "PageView", 2, 0, new String[0]);
      return;
      b(true);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    super.setVisibility(8);
    if (paramBoolean)
    {
      super.removeAllViews();
      if ((this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.getRenderImpl() != null)) {
        this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.getRenderImpl().c();
      }
    }
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeCallbacksAndMessages(null);
    if (this.jdField_a_of_type_ComTencentWidgetActionSheet != null) {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      do
      {
        do
        {
          do
          {
            AppInterface localAppInterface;
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      return false;
                    } while (super.getVisibility() != 0);
                    paramMessage = (String)paramMessage.obj;
                  } while (TextUtils.isEmpty(paramMessage));
                  QQToast.a(getContext(), "图片已保存到" + paramMessage, 1).a();
                  return false;
                  if (this.jdField_a_of_type_ComTencentWidgetActionSheet != null) {
                    this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
                  }
                } while ((super.getVisibility() != 0) || (this.jdField_a_of_type_JavaLangRefWeakReference == null));
                localAppInterface = (AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
              } while (localAppInterface == null);
              paramMessage = (String)paramMessage.obj;
              if (!TextUtils.isEmpty(paramMessage)) {
                break;
              }
            } while (!QLog.isColorLevel());
            QLog.e("ApolloImageShareLayout", 1, "onItemClick share QZone apolloImage no file");
            return false;
            Bundle localBundle = new Bundle();
            ArrayList localArrayList = new ArrayList();
            try
            {
              localArrayList.add(URLDecoder.decode(paramMessage));
              localBundle.putStringArrayList("images", localArrayList);
              localBundle.putString("summary", "厘米秀");
              localBundle.putInt("req_type", 7);
              localBundle.putBoolean("key_need_save_draft", false);
              QZoneShareManager.a(localAppInterface, this.jdField_a_of_type_AndroidAppActivity, localBundle, this, 15);
              return false;
            }
            catch (Exception paramMessage)
            {
              QLog.d("ApolloImageShareLayout", 2, "publishToQzone:" + paramMessage.getMessage());
              return false;
            }
            if (this.jdField_a_of_type_ComTencentWidgetActionSheet != null) {
              this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
            }
          } while (super.getVisibility() != 0);
          paramMessage = (String)paramMessage.obj;
          if (!TextUtils.isEmpty(paramMessage)) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.e("ApolloImageShareLayout", 1, "onItemClick share QQ apolloImage no file");
        return false;
        if (new File(paramMessage).exists()) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.e("ApolloImageShareLayout", 1, "onItemClick share QQ apolloImage no file");
      return false;
    } while (this.jdField_a_of_type_AndroidAppActivity == null);
    ApolloUtil.a(this.jdField_a_of_type_AndroidAppActivity, paramMessage, null, 1);
    return false;
  }
  
  @TargetApi(14)
  public void onClick(View paramView)
  {
    long l;
    if (paramView == this.jdField_a_of_type_AndroidWidgetImageView)
    {
      l = System.currentTimeMillis();
      if (l - this.jdField_a_of_type_Long >= 800L) {}
    }
    do
    {
      return;
      this.jdField_a_of_type_Long = l;
      if (this.jdField_a_of_type_Boolean)
      {
        QQToast.a(getContext(), "正在保存", 0).a();
        return;
      }
      this.jdField_a_of_type_Boolean = true;
      if (QLog.isColorLevel()) {
        QLog.d("ApolloImageShareLayout", 2, "download Request:" + l);
      }
      if (Build.VERSION.SDK_INT >= 14) {
        ThreadManager.executeOnSubThread(new zai(this, a(), this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.getWidth(), this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.getHeight(), 15, l));
      }
      VipUtils.a(null, "cmshow", "Apollo", "SaveClick", 0, 0, new String[0]);
      return;
      if (paramView == this.jdField_b_of_type_AndroidWidgetImageView)
      {
        if ((this.jdField_c_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.getRenderImpl() != null))
        {
          paramView = ApolloActionHelper.a(5, -1, this.jdField_c_of_type_Int, true);
          this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.getRenderImpl().a(1, null, 5, 1000000, paramView[0], paramView[1]);
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
    } while (paramView != this.jdField_d_of_type_AndroidWidgetImageView);
    VipUtils.a(null, "cmshow", "Apollo", "CloseClick", 0, 0, new String[0]);
    a(false);
  }
  
  public void onDismiss(DialogInterface paramDialogInterface) {}
  
  @TargetApi(14)
  public void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    long l = System.currentTimeMillis();
    if (l - this.jdField_b_of_type_Long < 2000L) {
      return;
    }
    this.jdField_b_of_type_Long = l;
    if (paramLong == 1L)
    {
      if (Build.VERSION.SDK_INT >= 14)
      {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.invalidate();
        ThreadManager.executeOnSubThread(new zai(this, a(), this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.getWidth(), this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.getHeight(), 16, l));
      }
      VipUtils.a(null, "cmshow", "Apollo", "Share2Qzone", 0, 0, new String[0]);
      return;
    }
    if (Build.VERSION.SDK_INT >= 14)
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.invalidate();
      ThreadManager.executeOnSubThread(new zai(this, a(), this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.getWidth(), this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.getHeight(), 17, l));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.store.ApolloImageShareLayout
 * JD-Core Version:    0.7.0.1
 */