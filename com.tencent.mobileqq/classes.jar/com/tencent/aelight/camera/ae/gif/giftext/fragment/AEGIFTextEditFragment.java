package com.tencent.aelight.camera.ae.gif.giftext.fragment;

import android.app.Activity;
import android.app.Dialog;
import android.app.Fragment;
import android.app.FragmentManager;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.InputFilter;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider;
import com.tencent.aelight.camera.ae.AEViewModelProviders;
import com.tencent.aelight.camera.ae.config.CameraPeakServiceHandler;
import com.tencent.aelight.camera.ae.gif.AEStoryGIFPreviewActivity;
import com.tencent.aelight.camera.ae.gif.giftext.AEGIFOutlineTextView;
import com.tencent.aelight.camera.ae.gif.giftext.AEGIFTextMvp;
import com.tencent.aelight.camera.ae.gif.giftext.adapter.AEGIFTextColorAdapter;
import com.tencent.aelight.camera.ae.gif.giftext.viewmodel.AEGIFTextEditViewModel;
import com.tencent.aelight.camera.ae.gif.video.PngCreateResult.PngResultItem;
import com.tencent.aelight.camera.ae.gif.video.PngsTextDrawer;
import com.tencent.aelight.camera.ae.report.AEBaseDataReporter;
import com.tencent.aelight.camera.ae.report.AEBaseReportParam;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.PeakAppInterface;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.widget.immersive.SystemBarTintManager;

public class AEGIFTextEditFragment
  extends Fragment
{
  private float jdField_a_of_type_Float = 0.0F;
  private int jdField_a_of_type_Int;
  private Dialog jdField_a_of_type_AndroidAppDialog;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private View jdField_a_of_type_AndroidViewView;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private EditText jdField_a_of_type_AndroidWidgetEditText;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private AEStoryGIFPreviewActivity jdField_a_of_type_ComTencentAelightCameraAeGifAEStoryGIFPreviewActivity;
  private AEGIFTextMvp jdField_a_of_type_ComTencentAelightCameraAeGifGiftextAEGIFTextMvp;
  private AEGIFTextColorAdapter jdField_a_of_type_ComTencentAelightCameraAeGifGiftextAdapterAEGIFTextColorAdapter;
  private AEGIFTextEditFragment.TextValidCallback jdField_a_of_type_ComTencentAelightCameraAeGifGiftextFragmentAEGIFTextEditFragment$TextValidCallback;
  AEGIFTextEditViewModel jdField_a_of_type_ComTencentAelightCameraAeGifGiftextViewmodelAEGIFTextEditViewModel;
  private QQCustomDialog jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean = false;
  private float jdField_b_of_type_Float = 1.0F;
  private RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  private String jdField_b_of_type_JavaLangString;
  private float jdField_c_of_type_Float = 0.82F;
  private String jdField_c_of_type_JavaLangString = null;
  private float d = 0.16F;
  
  private int a(char paramChar)
  {
    if ((paramChar != '\n') && (paramChar != '\r'))
    {
      if (paramChar < '') {
        return 1;
      }
      return 2;
    }
    return 0;
  }
  
  public static AEGIFTextEditFragment a(String paramString1, boolean paramBoolean, View paramView, String paramString2)
  {
    paramString1 = a(paramString1, paramBoolean, paramString2);
    paramString1.b(paramView);
    return paramString1;
  }
  
  public static AEGIFTextEditFragment a(String paramString1, boolean paramBoolean, String paramString2)
  {
    AEGIFTextEditFragment localAEGIFTextEditFragment = new AEGIFTextEditFragment();
    Bundle localBundle = new Bundle();
    localBundle.putString("KEY_PNG_DIR_PATH", paramString1);
    localBundle.putBoolean("KEY_IS_MULTIPLE", paramBoolean);
    if (!TextUtils.isEmpty(paramString2)) {
      localBundle.putString("KEY_FONT_ID", paramString2);
    }
    localAEGIFTextEditFragment.setArguments(localBundle);
    return localAEGIFTextEditFragment;
  }
  
  private void a()
  {
    ((InputMethodManager)this.jdField_a_of_type_ComTencentAelightCameraAeGifAEStoryGIFPreviewActivity.getSystemService("input_method")).toggleSoftInput(1, 2);
  }
  
  private void a(int paramInt)
  {
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.post(new AEGIFTextEditFragment.13(this, paramInt));
  }
  
  private void a(AEGIFTextEditFragment.TextValidCallback paramTextValidCallback)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeGifGiftextFragmentAEGIFTextEditFragment$TextValidCallback = paramTextValidCallback;
  }
  
  private void a(String paramString1, String paramString2)
  {
    AEBaseReportParam.a().p(paramString1);
    AEBaseReportParam.a().q(paramString2);
  }
  
  private void a(boolean paramBoolean)
  {
    Object localObject = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
    if (paramBoolean)
    {
      if (((String)localObject).equals(""))
      {
        localObject = this.jdField_a_of_type_ComTencentAelightCameraAeGifGiftextAEGIFTextMvp;
        if (localObject != null) {
          ((AEGIFTextMvp)localObject).d();
        }
        this.jdField_a_of_type_ComTencentAelightCameraAeGifGiftextViewmodelAEGIFTextEditViewModel.a();
        a("none", this.jdField_a_of_type_ComTencentAelightCameraAeGifGiftextAdapterAEGIFTextColorAdapter.a());
        getFragmentManager().popBackStack();
        return;
      }
      d();
      b((String)localObject);
      return;
    }
    getFragmentManager().popBackStack();
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      if (paramBoolean2)
      {
        h();
        Object localObject = (PngCreateResult.PngResultItem)this.jdField_a_of_type_ComTencentAelightCameraAeGifGiftextViewmodelAEGIFTextEditViewModel.c().getValue();
        if ((localObject != null) && (((PngCreateResult.PngResultItem)localObject).jdField_a_of_type_JavaLangString != null)) {
          FileUtils.deleteDirectory(((PngCreateResult.PngResultItem)localObject).jdField_a_of_type_JavaLangString);
        }
        localObject = new PngsTextDrawer(this.jdField_c_of_type_JavaLangString);
        b();
        String str = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
        ((PngsTextDrawer)localObject).a(str, 55, this.jdField_a_of_type_ComTencentAelightCameraAeGifGiftextAdapterAEGIFTextColorAdapter.a(), this.jdField_a_of_type_ComTencentAelightCameraAeGifGiftextAdapterAEGIFTextColorAdapter.b(), DisplayUtil.a(getActivity(), 4.0F), this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Float, this.jdField_c_of_type_Float, this.jdField_b_of_type_Float, this.d);
        ((PngsTextDrawer)localObject).a(new AEGIFTextEditFragment.3(this, str));
        return;
      }
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
      this.jdField_a_of_type_ComTencentAelightCameraAeGifAEStoryGIFPreviewActivity.runOnUiThread(new AEGIFTextEditFragment.4(this));
      return;
    }
    this.jdField_a_of_type_AndroidAppDialog.dismiss();
    e();
  }
  
  private int b()
  {
    Activity localActivity = getActivity();
    if ((localActivity != null) && (!localActivity.isFinishing()) && (SystemBarTintManager.hasNavBar(localActivity))) {
      return SystemBarTintManager.getNavigationBarHeight(localActivity);
    }
    return 0;
  }
  
  private void b()
  {
    if (((AEGIFOutlineTextView)this.jdField_a_of_type_AndroidViewView.findViewById(2064122466) != null) && (this.jdField_a_of_type_AndroidWidgetEditText.getText().toString().indexOf('\n') > 0))
    {
      this.jdField_c_of_type_Float = 0.73F;
      this.d = 0.3F;
    }
  }
  
  private void b(View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
  }
  
  private void b(String paramString)
  {
    AppInterface localAppInterface = QQStoryContext.a();
    CameraPeakServiceHandler localCameraPeakServiceHandler = (CameraPeakServiceHandler)localAppInterface.getBusinessHandler(PeakAppInterface.d);
    localAppInterface.addObserver(new AEGIFTextEditFragment.11(this, localAppInterface));
    localCameraPeakServiceHandler.c(paramString);
  }
  
  private void b(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.jdField_a_of_type_AndroidAppDialog.dismiss();
    if (paramBoolean1)
    {
      if (paramBoolean2)
      {
        h();
        getFragmentManager().popBackStack();
        return;
      }
      this.jdField_a_of_type_ComTencentAelightCameraAeGifAEStoryGIFPreviewActivity.runOnUiThread(new AEGIFTextEditFragment.5(this));
      return;
    }
    e();
  }
  
  private void c()
  {
    ((InputMethodManager)this.jdField_a_of_type_ComTencentAelightCameraAeGifAEStoryGIFPreviewActivity.getSystemService("input_method")).hideSoftInputFromWindow(this.jdField_a_of_type_ComTencentAelightCameraAeGifAEStoryGIFPreviewActivity.getWindow().getDecorView().getRootView().getWindowToken(), 0);
  }
  
  private void d()
  {
    this.jdField_a_of_type_AndroidAppDialog = new Dialog(this.jdField_a_of_type_ComTencentAelightCameraAeGifAEStoryGIFPreviewActivity, 2131756189);
    this.jdField_a_of_type_AndroidAppDialog.setCancelable(false);
    this.jdField_a_of_type_AndroidAppDialog.setCanceledOnTouchOutside(false);
    this.jdField_a_of_type_AndroidAppDialog.setContentView(2064318634);
    this.jdField_a_of_type_AndroidAppDialog.show();
  }
  
  private void e()
  {
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(this.jdField_a_of_type_ComTencentAelightCameraAeGifAEStoryGIFPreviewActivity, 230);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setMessage(HardCodeUtil.a(2131700202));
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setCanceledOnTouchOutside(false);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setPositiveButton(HardCodeUtil.a(2131700201), new AEGIFTextEditFragment.6(this));
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
  }
  
  private void f()
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeGifGiftextViewmodelAEGIFTextEditViewModel = ((AEGIFTextEditViewModel)AEViewModelProviders.a(this.jdField_a_of_type_ComTencentAelightCameraAeGifAEStoryGIFPreviewActivity).get(AEGIFTextEditViewModel.class));
  }
  
  private void g()
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2064122564));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2064122570));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2064122000));
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2064122585));
    LinearLayoutManager localLinearLayoutManager = new LinearLayoutManager(this.jdField_a_of_type_ComTencentAelightCameraAeGifAEStoryGIFPreviewActivity, 0, false);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(localLinearLayoutManager);
    this.jdField_a_of_type_ComTencentAelightCameraAeGifGiftextAdapterAEGIFTextColorAdapter = new AEGIFTextColorAdapter(this.jdField_a_of_type_ComTencentAelightCameraAeGifAEStoryGIFPreviewActivity, this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView);
    this.jdField_a_of_type_ComTencentAelightCameraAeGifGiftextAdapterAEGIFTextColorAdapter.a(this.jdField_a_of_type_Int);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_ComTencentAelightCameraAeGifGiftextAdapterAEGIFTextColorAdapter);
    this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2064122694).setOnClickListener(new AEGIFTextEditFragment.7(this));
    this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2064122695).setOnClickListener(new AEGIFTextEditFragment.8(this));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new AEGIFTextEditFragment.9(this));
  }
  
  private void h()
  {
    String str1 = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
    String str2 = this.jdField_a_of_type_ComTencentAelightCameraAeGifGiftextAdapterAEGIFTextColorAdapter.a();
    int i = this.jdField_a_of_type_ComTencentAelightCameraAeGifGiftextAdapterAEGIFTextColorAdapter.a();
    String str3 = this.jdField_a_of_type_ComTencentAelightCameraAeGifGiftextAdapterAEGIFTextColorAdapter.b();
    if (this.jdField_a_of_type_ComTencentAelightCameraAeGifGiftextAEGIFTextMvp != null) {
      this.jdField_a_of_type_ComTencentAelightCameraAeGifAEStoryGIFPreviewActivity.runOnUiThread(new AEGIFTextEditFragment.10(this, str1, str2, str3, i));
    }
    this.jdField_a_of_type_ComTencentAelightCameraAeGifGiftextViewmodelAEGIFTextEditViewModel.a(str1, i);
    a(str1, str2);
  }
  
  protected int a()
  {
    return 2064318603;
  }
  
  public void a(View paramView)
  {
    paramView.getViewTreeObserver().addOnGlobalLayoutListener(new AEGIFTextEditFragment.12(this, paramView));
  }
  
  public void a(AEGIFTextMvp paramAEGIFTextMvp)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeGifGiftextAEGIFTextMvp = paramAEGIFTextMvp;
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2064122618));
    this.jdField_a_of_type_ComTencentAelightCameraAeGifGiftextAdapterAEGIFTextColorAdapter.a(this.jdField_a_of_type_AndroidWidgetEditText);
    this.jdField_a_of_type_AndroidWidgetEditText.setText(this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_AndroidWidgetEditText.setTextColor(Color.parseColor(paramString));
    this.jdField_a_of_type_AndroidWidgetEditText.setSelection(this.jdField_a_of_type_JavaLangString.length());
    if (this.jdField_a_of_type_AndroidWidgetEditText.length() > 0)
    {
      paramString = this.jdField_a_of_type_AndroidWidgetImageView;
      if (paramString != null) {
        paramString.setVisibility(0);
      }
    }
    this.jdField_a_of_type_AndroidWidgetEditText.setFilters(new InputFilter[] { new AEGIFTextEditFragment.LengthInputFilter(this) });
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(new AEGIFTextEditFragment.14(this));
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_c_of_type_JavaLangString = getArguments().getString("KEY_PNG_DIR_PATH");
    this.jdField_a_of_type_Boolean = getArguments().getBoolean("KEY_IS_MULTIPLE", false);
    if (getArguments().containsKey("KEY_FONT_ID")) {
      this.jdField_b_of_type_JavaLangString = getArguments().getString("KEY_FONT_ID");
    }
    this.jdField_a_of_type_ComTencentAelightCameraAeGifAEStoryGIFPreviewActivity = ((AEStoryGIFPreviewActivity)getActivity());
    f();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)paramLayoutInflater.inflate(a(), paramViewGroup, false));
    paramLayoutInflater = this.jdField_a_of_type_ComTencentAelightCameraAeGifGiftextAEGIFTextMvp;
    if (paramLayoutInflater != null)
    {
      this.jdField_a_of_type_JavaLangString = paramLayoutInflater.a();
      this.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentAelightCameraAeGifGiftextAEGIFTextMvp.a();
    }
    else
    {
      this.jdField_a_of_type_JavaLangString = ((String)this.jdField_a_of_type_ComTencentAelightCameraAeGifGiftextViewmodelAEGIFTextEditViewModel.b().getValue());
    }
    g();
    a(this.jdField_a_of_type_ComTencentAelightCameraAeGifGiftextAdapterAEGIFTextColorAdapter.a());
    a();
    return this.jdField_a_of_type_AndroidViewViewGroup;
  }
  
  public void onPause()
  {
    super.onPause();
    c();
  }
  
  public void onResume()
  {
    super.onResume();
    this.jdField_a_of_type_AndroidWidgetEditText.requestFocus();
    AEBaseDataReporter localAEBaseDataReporter = AEBaseDataReporter.a();
    String str;
    if (this.jdField_a_of_type_Boolean) {
      str = "recommend";
    } else {
      str = "edit";
    }
    localAEBaseDataReporter.m(str);
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    this.jdField_a_of_type_AndroidViewViewGroup.setOnTouchListener(new AEGIFTextEditFragment.1(this));
    a(new AEGIFTextEditFragment.2(this));
    a(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.gif.giftext.fragment.AEGIFTextEditFragment
 * JD-Core Version:    0.7.0.1
 */