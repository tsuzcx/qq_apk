package com.tencent.mobileqq.activity.aio.stickerrecommended.mvvm;

import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.aio.core.BaseAIOContext;
import com.tencent.mobileqq.activity.aio.stickerrecommended.adapter.StickerRecBarAdapter;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.emoticonview.EmotionKeywordHorizonListView;
import com.tencent.mobileqq.emoticonview.EmotionKeywordLayout;
import com.tencent.mobileqq.mvvm.BaseViewBinder;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.QLog;

public class StickerRecViewBinder
  extends BaseViewBinder
  implements IStickerRecViewBinder
{
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  private BaseAIOContext jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseAIOContext;
  private StickerRecBarAdapter jdField_a_of_type_ComTencentMobileqqActivityAioStickerrecommendedAdapterStickerRecBarAdapter;
  private StickerRecViewModel jdField_a_of_type_ComTencentMobileqqActivityAioStickerrecommendedMvvmStickerRecViewModel;
  private QBaseActivity jdField_a_of_type_ComTencentMobileqqAppQBaseActivity;
  private EmotionKeywordHorizonListView jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionKeywordHorizonListView;
  public EmotionKeywordLayout a;
  
  public StickerRecViewBinder(AppInterface paramAppInterface, QBaseActivity paramQBaseActivity, BaseAIOContext paramBaseAIOContext, IStickerRecViewModel paramIStickerRecViewModel)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity = paramQBaseActivity;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseAIOContext = paramBaseAIOContext;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerrecommendedMvvmStickerRecViewModel = ((StickerRecViewModel)paramIStickerRecViewModel);
  }
  
  private EmotionKeywordHorizonListView a(ViewGroup paramViewGroup, EditText paramEditText)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionKeywordLayout;
    if (localObject == null) {
      return null;
    }
    ((EmotionKeywordLayout)localObject).setEnableAnim(true);
    localObject = (LinearLayout)this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionKeywordLayout.findViewById(2131366149);
    EmotionKeywordHorizonListView localEmotionKeywordHorizonListView = (EmotionKeywordHorizonListView)this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionKeywordLayout.findViewById(2131366178);
    TextView localTextView = (TextView)this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionKeywordLayout.findViewById(2131366148);
    if (ThemeUtil.isNowThemeIsNight(this.jdField_a_of_type_ComTencentCommonAppAppInterface, false, null))
    {
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionKeywordLayout.setBackgroundColor(Color.parseColor("#1F1F1F"));
      localEmotionKeywordHorizonListView.setBackgroundColor(Color.parseColor("#1F1F1F"));
      ((LinearLayout)localObject).setBackgroundColor(Color.parseColor("#1F1F1F"));
      localTextView.setTextColor(Color.parseColor("#8D8D93"));
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerrecommendedAdapterStickerRecBarAdapter = new StickerRecBarAdapter(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseAIOContext, paramViewGroup, paramEditText, localEmotionKeywordHorizonListView);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerrecommendedAdapterStickerRecBarAdapter.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerrecommendedMvvmStickerRecViewModel);
    localEmotionKeywordHorizonListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerrecommendedAdapterStickerRecBarAdapter);
    localEmotionKeywordHorizonListView.setPadding(0, 0, 0, 0);
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionKeywordLayout.setOnVisibilityListener(new StickerRecViewBinder.4(this));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerrecommendedMvvmStickerRecViewModel.a(true);
    return localEmotionKeywordHorizonListView;
  }
  
  public void a(ViewGroup paramViewGroup, RelativeLayout paramRelativeLayout, EditText paramEditText)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionKeywordLayout == null) {
      try
      {
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionKeywordLayout = ((EmotionKeywordLayout)View.inflate(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, 2131558538, null));
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionKeywordHorizonListView = a(paramViewGroup, paramEditText);
        if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionKeywordHorizonListView == null) {
          return;
        }
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionKeywordHorizonListView.setTouchListener(new StickerRecViewBinder.5(this, paramEditText));
        paramViewGroup = new RelativeLayout.LayoutParams(-1, -2);
        paramViewGroup.addRule(2, 2131368875);
        paramViewGroup.addRule(9);
        this.jdField_a_of_type_AndroidWidgetRelativeLayout = paramRelativeLayout;
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionKeywordLayout, paramViewGroup);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerrecommendedMvvmStickerRecViewModel.c(true);
        return;
      }
      catch (Exception paramViewGroup)
      {
        paramRelativeLayout = new StringBuilder();
        paramRelativeLayout.append("EmotionPreviewLayout InflateException = ");
        paramRelativeLayout.append(paramViewGroup);
        QLog.e("StickerRecViewBinder", 2, paramRelativeLayout.toString());
      }
    }
  }
  
  public void a(LifecycleOwner paramLifecycleOwner)
  {
    a(paramLifecycleOwner, this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerrecommendedMvvmStickerRecViewModel);
    b(paramLifecycleOwner, this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerrecommendedMvvmStickerRecViewModel);
    c(paramLifecycleOwner, this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerrecommendedMvvmStickerRecViewModel);
  }
  
  protected void a(LifecycleOwner paramLifecycleOwner, StickerRecViewModel paramStickerRecViewModel)
  {
    paramStickerRecViewModel.a().observe(paramLifecycleOwner, new StickerRecViewBinder.1(this));
  }
  
  protected void b(LifecycleOwner paramLifecycleOwner, StickerRecViewModel paramStickerRecViewModel)
  {
    paramStickerRecViewModel.b().observe(paramLifecycleOwner, new StickerRecViewBinder.2(this));
  }
  
  protected void c(LifecycleOwner paramLifecycleOwner, StickerRecViewModel paramStickerRecViewModel)
  {
    paramStickerRecViewModel.c().observe(paramLifecycleOwner, new StickerRecViewBinder.3(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.stickerrecommended.mvvm.StickerRecViewBinder
 * JD-Core Version:    0.7.0.1
 */