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
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.util.BinderWarpper;
import com.tencent.widget.immersive.ImmersiveUtils;
import dov.com.qq.im.capture.CaptureContext;
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
        if (QLog.isColorLevel()) {
          QLog.e("SessionClearFragment", 2, "getCoverDrawable():  getDrawable Exception, coverUrl=" + paramString, localException);
        }
      }
    }
    return localEmptyDrawable;
  }
  
  private void a(int paramInt)
  {
    if (paramInt == 1) {
      this.jdField_a_of_type_AndroidWidgetButton.setText(HardCodeUtil.a(2131713800));
    }
    for (;;)
    {
      this.jdField_a_of_type_Int = paramInt;
      return;
      this.jdField_a_of_type_AndroidWidgetButton.setText(HardCodeUtil.a(2131713788));
    }
  }
  
  private void a(Dialog paramDialog)
  {
    if ((paramDialog != null) && (this.jdField_a_of_type_AndroidAppActivity != null) && (!this.jdField_a_of_type_AndroidAppActivity.isFinishing())) {}
    try
    {
      paramDialog.show();
      return;
    }
    catch (Throwable paramDialog)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("SessionClearFragment", 2, "showDialogSafe exception: " + paramDialog.getMessage());
    }
  }
  
  private void a(View paramView)
  {
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)paramView.findViewById(2131377857));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131377707));
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378320));
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131365650));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131363829));
    this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager = new LinearLayoutManager(getActivity());
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131366314));
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager);
    this.jdField_a_of_type_ComTencentMobileqqActivityWeatherSessionClearFragment$SessionListAdapter = new SessionClearFragment.SessionListAdapter(this, new ArrayList());
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityWeatherSessionClearFragment$SessionListAdapter);
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new SessionClearFragment.5(this));
    this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(new SessionClearFragment.6(this));
    paramView.findViewById(2131364824).setOnClickListener(new SessionClearFragment.7(this));
  }
  
  private void a(String paramString, int paramInt1, int paramInt2, ImageView paramImageView, int paramInt3)
  {
    if (FileUtils.b(paramString))
    {
      paramString = ShortVideoUtils.getThumbUrl(paramString);
      if (paramString != null)
      {
        paramString = a(paramString.toString(), paramInt1, paramInt2);
        if ((paramString instanceof URLDrawable)) {
          this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt3, (URLDrawable)paramString);
        }
        paramImageView.setImageDrawable(paramString);
      }
    }
    else
    {
      return;
    }
    QLog.d("SessionClearFragment", 2, "url  is null ");
  }
  
  private void c()
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    int i = 0;
    if (i < this.jdField_a_of_type_ComTencentMobileqqActivityWeatherSessionClearFragment$SessionListAdapter.getItemCount())
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityWeatherSessionClearFragment$SessionListAdapter.a(i).a) {
        localArrayList1.add(this.jdField_a_of_type_ComTencentMobileqqActivityWeatherSessionClearFragment$SessionListAdapter.a(i));
      }
      for (;;)
      {
        i += 1;
        break;
        localArrayList2.add(this.jdField_a_of_type_ComTencentMobileqqActivityWeatherSessionClearFragment$SessionListAdapter.a(i));
      }
    }
    if (localArrayList1.size() > 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppMessageMessagecleanMessageCleanManager.a(localArrayList1);
      if ((localArrayList2 != null) && (localArrayList2.size() != 0)) {
        break label149;
      }
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    }
    for (;;)
    {
      QQToast.a(this.jdField_a_of_type_AndroidAppActivity, 2, 2131691566, 0).b(getResources().getDimensionPixelSize(2131299166));
      return;
      label149:
      this.jdField_a_of_type_ComTencentMobileqqActivityWeatherSessionClearFragment$SessionListAdapter.a(localArrayList2);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      a(0);
    }
  }
  
  protected void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this.jdField_a_of_type_AndroidAppActivity, getResources().getDimensionPixelSize(2131299166));
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.setCancelable(false);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.setCanceledOnTouchOutside(false);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(HardCodeUtil.a(2131713795));
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(new SessionClearFragment.8(this));
  }
  
  public void a(List<CleanMessageItemInfo> paramList)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityWeatherSessionClearFragment$SessionListAdapter.a(paramList);
  }
  
  protected void b()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
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
    this.jdField_a_of_type_AndroidAppActivity.finish();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidAppActivity.getWindow().getDecorView().findViewById(16908290);
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      paramBundle = (LinearLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams();
      int i = ImmersiveUtils.getStatusBarHeight(getActivity());
      if (paramBundle != null) {
        paramBundle.setMargins(0, i, 0, 0);
      }
      this.jdField_a_of_type_AndroidViewView.setSystemUiVisibility(0);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppPeakAppInterface = ((PeakAppInterface)CaptureContext.a());
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider == null)
    {
      paramBundle = (BinderWarpper)this.jdField_a_of_type_AndroidAppActivity.getIntent().getParcelableExtra("extra.IMAGE_PROVIDER");
      if (paramBundle == null) {
        break label369;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider = IAIOImageProvider.Stub.a(paramBundle.a);
      if (QLog.isColorLevel()) {
        QLog.d("SessionClearFragment", 2, "IAIOImageProvider is " + this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider);
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqAppPeakAppInterface = ((PeakAppInterface)CaptureContext.a());
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
    this.jdField_a_of_type_AndroidGraphicsBitmap = ImageUtil.c();
    return;
    label369:
    throw new IllegalArgumentException("can't find Binder in Intent..");
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131563012, paramViewGroup, false);
    a(paramLayoutInflater);
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.jdField_a_of_type_ComTencentMobileqqAppMessageMessagecleanMessageCleanManager.onDestroy();
    this.jdField_a_of_type_ComTencentMobileqqArmapINonMainProcAvatarLoader.b();
    this.jdField_b_of_type_ComTencentMobileqqArmapINonMainProcAvatarLoader.b();
    this.jdField_c_of_type_ComTencentMobileqqArmapINonMainProcAvatarLoader.b();
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
    this.jdField_a_of_type_AndroidAppActivity = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.weather.SessionClearFragment
 * JD-Core Version:    0.7.0.1
 */