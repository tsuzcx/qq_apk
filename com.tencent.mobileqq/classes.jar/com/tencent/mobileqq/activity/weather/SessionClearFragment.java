package com.tencent.mobileqq.activity.weather;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.aelight.camera.qqstory.api.IAECaptureContext;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.PublicFragmentActivityCallBackInterface;
import com.tencent.mobileqq.activity.aio.photo.IAIOImageProvider;
import com.tencent.mobileqq.activity.aio.photo.IAIOImageProvider.Stub;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.PeakAppInterface;
import com.tencent.mobileqq.app.message.messageclean.CleanMessageItemInfo;
import com.tencent.mobileqq.app.message.messageclean.MessageCleanManager;
import com.tencent.mobileqq.armap.INonMainProcAvatarLoader;
import com.tencent.mobileqq.avatar.api.IQQNonMainProcAvatarLoaderApi;
import com.tencent.mobileqq.drawable.EmptyDrawable;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.util.BinderWarpper;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class SessionClearFragment
  extends PublicBaseFragment
  implements PublicFragmentActivityCallBackInterface
{
  private int jdField_a_of_type_Int = 0;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private LinearLayoutManager jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private SparseArray<URLDrawable> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  private View jdField_a_of_type_AndroidViewView;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private IAIOImageProvider jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider;
  private SessionClearFragment.SessionListAdapter jdField_a_of_type_ComTencentMobileqqActivityWeatherSessionClearFragment$SessionListAdapter;
  private PeakAppInterface jdField_a_of_type_ComTencentMobileqqAppPeakAppInterface;
  private MessageCleanManager jdField_a_of_type_ComTencentMobileqqAppMessageMessagecleanMessageCleanManager;
  private INonMainProcAvatarLoader jdField_a_of_type_ComTencentMobileqqArmapINonMainProcAvatarLoader;
  private QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  List<CleanMessageItemInfo> jdField_a_of_type_JavaUtilList;
  private int jdField_b_of_type_Int = 0;
  private Button jdField_b_of_type_AndroidWidgetButton;
  private INonMainProcAvatarLoader jdField_b_of_type_ComTencentMobileqqArmapINonMainProcAvatarLoader;
  private int jdField_c_of_type_Int = 0;
  private INonMainProcAvatarLoader jdField_c_of_type_ComTencentMobileqqArmapINonMainProcAvatarLoader;
  
  public static Drawable a(String paramString, int paramInt1, int paramInt2)
  {
    EmptyDrawable localEmptyDrawable = new EmptyDrawable(Color.rgb(214, 214, 214), paramInt1, paramInt2);
    if (!TextUtils.isEmpty(paramString)) {
      try
      {
        URLDrawable localURLDrawable = URLDrawable.getDrawable(paramString, localEmptyDrawable, localEmptyDrawable);
        if (localURLDrawable.getStatus() != 1) {
          localURLDrawable.downloadImediatly();
        }
        return localURLDrawable;
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("getCoverDrawable():  getDrawable Exception, coverUrl=");
          localStringBuilder.append(paramString);
          QLog.e("SessionClearFragment", 2, localStringBuilder.toString(), localException);
        }
      }
    }
    return localEmptyDrawable;
  }
  
  private void a(int paramInt)
  {
    if (paramInt == 1) {
      this.jdField_a_of_type_AndroidWidgetButton.setText(HardCodeUtil.a(2131713728));
    } else {
      this.jdField_a_of_type_AndroidWidgetButton.setText(HardCodeUtil.a(2131713716));
    }
    this.jdField_a_of_type_Int = paramInt;
  }
  
  private void a(Dialog paramDialog)
  {
    if (paramDialog != null)
    {
      Object localObject = this.jdField_a_of_type_AndroidAppActivity;
      if ((localObject != null) && (!((Activity)localObject).isFinishing())) {
        try
        {
          paramDialog.show();
          return;
        }
        catch (Throwable paramDialog)
        {
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("showDialogSafe exception: ");
            ((StringBuilder)localObject).append(paramDialog.getMessage());
            QLog.d("SessionClearFragment", 2, ((StringBuilder)localObject).toString());
          }
        }
      }
    }
  }
  
  private void a(View paramView)
  {
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)paramView.findViewById(2131377283));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131377135));
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131377728));
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131365494));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131363756));
    this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager = new LinearLayoutManager(getBaseActivity());
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131366202));
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager);
    this.jdField_a_of_type_ComTencentMobileqqActivityWeatherSessionClearFragment$SessionListAdapter = new SessionClearFragment.SessionListAdapter(this, new ArrayList());
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityWeatherSessionClearFragment$SessionListAdapter);
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new SessionClearFragment.5(this));
    this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(new SessionClearFragment.6(this));
    paramView.findViewById(2131364711).setOnClickListener(new SessionClearFragment.7(this));
  }
  
  private void a(String paramString, int paramInt1, int paramInt2, ImageView paramImageView, int paramInt3)
  {
    if (FileUtils.fileExistsAndNotEmpty(paramString))
    {
      paramString = ShortVideoUtils.getThumbUrl(paramString);
      if (paramString != null)
      {
        paramString = a(paramString.toString(), paramInt1, paramInt2);
        if ((paramString instanceof URLDrawable)) {
          this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt3, (URLDrawable)paramString);
        }
        paramImageView.setImageDrawable(paramString);
        return;
      }
      QLog.d("SessionClearFragment", 2, "url  is null ");
    }
  }
  
  private void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppPeakAppInterface = ((PeakAppInterface)((IAECaptureContext)QRoute.api(IAECaptureContext.class)).getAppInterface());
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider == null)
    {
      Object localObject = (BinderWarpper)this.jdField_a_of_type_AndroidAppActivity.getIntent().getParcelableExtra("extra.IMAGE_PROVIDER");
      if (localObject != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider = IAIOImageProvider.Stub.a(((BinderWarpper)localObject).a);
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("IAIOImageProvider is ");
          ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider);
          QLog.d("SessionClearFragment", 2, ((StringBuilder)localObject).toString());
        }
      }
      else
      {
        throw new IllegalArgumentException("can't find Binder in Intent..");
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqAppPeakAppInterface = ((PeakAppInterface)((IAECaptureContext)QRoute.api(IAECaptureContext.class)).getAppInterface());
    this.jdField_a_of_type_ComTencentMobileqqAppMessageMessagecleanMessageCleanManager = ((MessageCleanManager)this.jdField_a_of_type_ComTencentMobileqqAppPeakAppInterface.getManager(4));
    this.jdField_a_of_type_ComTencentMobileqqAppMessageMessagecleanMessageCleanManager.a(new SessionClearFragment.1(this));
    this.jdField_a_of_type_ComTencentMobileqqAppMessageMessagecleanMessageCleanManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider);
    this.jdField_a_of_type_ComTencentMobileqqArmapINonMainProcAvatarLoader = ((IQQNonMainProcAvatarLoaderApi)QRoute.api(IQQNonMainProcAvatarLoaderApi.class)).getNonMainAppHeadLoader(this.jdField_a_of_type_AndroidAppActivity, 1);
    this.jdField_a_of_type_ComTencentMobileqqArmapINonMainProcAvatarLoader.a();
    this.jdField_a_of_type_ComTencentMobileqqArmapINonMainProcAvatarLoader.a(new SessionClearFragment.2(this));
    this.jdField_b_of_type_ComTencentMobileqqArmapINonMainProcAvatarLoader = ((IQQNonMainProcAvatarLoaderApi)QRoute.api(IQQNonMainProcAvatarLoaderApi.class)).getNonMainAppHeadLoader(this.jdField_a_of_type_AndroidAppActivity, 4);
    this.jdField_b_of_type_ComTencentMobileqqArmapINonMainProcAvatarLoader.a();
    this.jdField_b_of_type_ComTencentMobileqqArmapINonMainProcAvatarLoader.a(new SessionClearFragment.3(this));
    this.jdField_c_of_type_ComTencentMobileqqArmapINonMainProcAvatarLoader = ((IQQNonMainProcAvatarLoaderApi)QRoute.api(IQQNonMainProcAvatarLoaderApi.class)).getNonMainAppHeadLoader(this.jdField_a_of_type_AndroidAppActivity, 101);
    this.jdField_c_of_type_ComTencentMobileqqArmapINonMainProcAvatarLoader.a();
    this.jdField_c_of_type_ComTencentMobileqqArmapINonMainProcAvatarLoader.a(new SessionClearFragment.4(this));
    this.jdField_a_of_type_ComTencentMobileqqAppMessageMessagecleanMessageCleanManager.b();
    this.jdField_a_of_type_AndroidGraphicsBitmap = ImageUtil.f();
  }
  
  private void d()
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    int i = 0;
    while (i < this.jdField_a_of_type_ComTencentMobileqqActivityWeatherSessionClearFragment$SessionListAdapter.getItemCount())
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityWeatherSessionClearFragment$SessionListAdapter.a(i).a) {
        localArrayList1.add(this.jdField_a_of_type_ComTencentMobileqqActivityWeatherSessionClearFragment$SessionListAdapter.a(i));
      } else {
        localArrayList2.add(this.jdField_a_of_type_ComTencentMobileqqActivityWeatherSessionClearFragment$SessionListAdapter.a(i));
      }
      i += 1;
    }
    if (localArrayList1.size() > 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppMessageMessagecleanMessageCleanManager.a(localArrayList1);
      if (localArrayList2.size() == 0)
      {
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      }
      else
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityWeatherSessionClearFragment$SessionListAdapter.a(localArrayList2);
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        a(0);
      }
    }
    QQToast.a(this.jdField_a_of_type_AndroidAppActivity, 2, 2131691487, 0).b(getResources().getDimensionPixelSize(2131299168));
  }
  
  protected void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this.jdField_a_of_type_AndroidAppActivity, getResources().getDimensionPixelSize(2131299168));
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.setCancelable(false);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.setCanceledOnTouchOutside(false);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(HardCodeUtil.a(2131713723));
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(new SessionClearFragment.8(this));
  }
  
  public void a(List<CleanMessageItemInfo> paramList)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityWeatherSessionClearFragment$SessionListAdapter.a(paramList);
  }
  
  protected void b()
  {
    QQProgressDialog localQQProgressDialog = this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
    if ((localQQProgressDialog != null) && (localQQProgressDialog.isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    if (QLog.isColorLevel()) {
      QLog.d("SessionClearFragment", 2, "onAttach");
    }
  }
  
  public void onBackPressed()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SessionClearFragment", 2, "onBackPressed");
    }
    this.jdField_a_of_type_AndroidAppActivity.finish();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (QLog.isColorLevel()) {
      QLog.d("SessionClearFragment", 2, "onCreate");
    }
    this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidAppActivity.getWindow().getDecorView().findViewById(16908290);
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      paramBundle = (LinearLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams();
      int i = ImmersiveUtils.getStatusBarHeight(getBaseActivity());
      if (paramBundle != null) {
        paramBundle.setMargins(0, i, 0, 0);
      }
      this.jdField_a_of_type_AndroidViewView.setSystemUiVisibility(0);
    }
    c();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SessionClearFragment", 2, "onCreateView");
    }
    paramLayoutInflater = paramLayoutInflater.inflate(2131562834, paramViewGroup, false);
    a(paramLayoutInflater);
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (QLog.isColorLevel()) {
      QLog.d("SessionClearFragment", 2, "onDestroy");
    }
    this.jdField_a_of_type_ComTencentMobileqqAppMessageMessagecleanMessageCleanManager.onDestroy();
    this.jdField_a_of_type_ComTencentMobileqqArmapINonMainProcAvatarLoader.b();
    this.jdField_b_of_type_ComTencentMobileqqArmapINonMainProcAvatarLoader.b();
    this.jdField_c_of_type_ComTencentMobileqqArmapINonMainProcAvatarLoader.b();
    QQProgressDialog localQQProgressDialog = this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
    if (localQQProgressDialog != null) {
      localQQProgressDialog.dismiss();
    }
    this.jdField_a_of_type_AndroidAppActivity = null;
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SessionClearFragment", 2, "onNewIntent");
    }
    c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.weather.SessionClearFragment
 * JD-Core Version:    0.7.0.1
 */