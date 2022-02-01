package com.tencent.biz.pubaccount.weishi_new.comment;

import android.text.Editable;
import android.text.Editable.Factory;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.devicelib.DeviceLib;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.emoticonview.EmoticonCallback;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.emoticonview.IEmoticonMainPanel;
import com.tencent.mobileqq.emoticonview.SystemAndEmojiEmoticonInfo;
import com.tencent.mobileqq.emoticonview.api.IEmoticonMainPanelService;
import com.tencent.mobileqq.emoticonview.api.IEmoticonMainPanelService.PanelBuilder;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;

public class WSCommentEmoController
{
  public static Editable.Factory a;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private EditText jdField_a_of_type_AndroidWidgetEditText;
  private ImageButton jdField_a_of_type_AndroidWidgetImageButton;
  private PublicFragmentActivity jdField_a_of_type_ComTencentMobileqqActivityPublicFragmentActivity;
  private IEmoticonMainPanel jdField_a_of_type_ComTencentMobileqqEmoticonviewIEmoticonMainPanel;
  private boolean jdField_a_of_type_Boolean = false;
  
  static
  {
    jdField_a_of_type_AndroidTextEditable$Factory = new WSCommentEmoController.1();
  }
  
  private ImageButton a(RelativeLayout paramRelativeLayout, boolean paramBoolean)
  {
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    ImageButton localImageButton = new ImageButton(paramRelativeLayout.getContext());
    localImageButton.setBackgroundResource(2130850877);
    int i;
    if (paramBoolean) {
      i = 8;
    } else {
      i = 0;
    }
    localImageButton.setVisibility(i);
    localLayoutParams.rightMargin = ViewUtils.a(5.0F);
    localLayoutParams.bottomMargin = ViewUtils.a(7.0F);
    localLayoutParams.addRule(11);
    localLayoutParams.addRule(12);
    paramRelativeLayout.addView(localImageButton, localLayoutParams);
    return localImageButton;
  }
  
  private IEmoticonMainPanel a(PublicFragmentActivity paramPublicFragmentActivity, ViewGroup paramViewGroup, EditText paramEditText, int paramInt, EmoticonCallback paramEmoticonCallback)
  {
    paramEditText.setEditableFactory(jdField_a_of_type_AndroidTextEditable$Factory);
    DeviceLib.a(paramPublicFragmentActivity, paramEditText);
    paramEditText = this.jdField_a_of_type_ComTencentMobileqqEmoticonviewIEmoticonMainPanel;
    if (paramEditText != null) {
      return paramEditText;
    }
    paramPublicFragmentActivity = ((IEmoticonMainPanelService)paramPublicFragmentActivity.app.getRuntimeService(IEmoticonMainPanelService.class)).newBuilder(paramPublicFragmentActivity, 1008).setCallBack(paramEmoticonCallback).setOnlySysAndEmoji(true).setToastOffset(paramPublicFragmentActivity.getTitleBarHeight()).create();
    paramPublicFragmentActivity.hideAllTabs();
    paramPublicFragmentActivity.setOnlySysEmotionEnable(true);
    paramEditText = new RelativeLayout.LayoutParams(-1, paramInt);
    paramViewGroup.addView(paramPublicFragmentActivity.getView(), paramEditText);
    return paramPublicFragmentActivity;
  }
  
  private void a(EmoticonInfo paramEmoticonInfo)
  {
    if ((paramEmoticonInfo instanceof SystemAndEmojiEmoticonInfo))
    {
      EditText localEditText = this.jdField_a_of_type_AndroidWidgetEditText;
      if (localEditText != null)
      {
        SystemAndEmojiEmoticonInfo localSystemAndEmojiEmoticonInfo = (SystemAndEmojiEmoticonInfo)paramEmoticonInfo;
        int i = localEditText.getSelectionStart();
        int j = this.jdField_a_of_type_AndroidWidgetEditText.getSelectionEnd();
        int k = localSystemAndEmojiEmoticonInfo.emotionType;
        int m = localSystemAndEmojiEmoticonInfo.code;
        if ((i >= 0) && (j >= 0) && (j >= i))
        {
          if (m == -1) {
            return;
          }
          if (k == 1) {}
          try
          {
            paramEmoticonInfo = com.tencent.mobileqq.text.TextUtils.getSysEmotcationString(m);
            break label93;
            paramEmoticonInfo = com.tencent.mobileqq.text.TextUtils.getEmojiString(m);
            label93:
            this.jdField_a_of_type_AndroidWidgetEditText.getEditableText().replace(i, j, paramEmoticonInfo);
          }
          catch (IllegalArgumentException paramEmoticonInfo)
          {
            QLog.e("WSCommentEmoController", 2, "sendEmoticon: ", paramEmoticonInfo);
          }
          localSystemAndEmojiEmoticonInfo.addToCommonUsed(this.jdField_a_of_type_ComTencentMobileqqActivityPublicFragmentActivity.app, null);
        }
      }
    }
  }
  
  public void a()
  {
    ImageButton localImageButton = this.jdField_a_of_type_AndroidWidgetImageButton;
    if (localImageButton != null)
    {
      int i;
      if (android.text.TextUtils.isEmpty(this.jdField_a_of_type_AndroidWidgetEditText.getText())) {
        i = 8;
      } else {
        i = 0;
      }
      localImageButton.setVisibility(i);
    }
  }
  
  public void a(int paramInt)
  {
    IEmoticonMainPanel localIEmoticonMainPanel = this.jdField_a_of_type_ComTencentMobileqqEmoticonviewIEmoticonMainPanel;
    if ((localIEmoticonMainPanel != null) && (localIEmoticonMainPanel.getView().getHeight() != paramInt))
    {
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewIEmoticonMainPanel.getView().getLayoutParams().height = paramInt;
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewIEmoticonMainPanel.getView().invalidate();
    }
  }
  
  public void a(PublicFragmentActivity paramPublicFragmentActivity, ViewGroup paramViewGroup, EditText paramEditText, int paramInt)
  {
    if ((paramEditText != null) && (paramViewGroup != null))
    {
      if (paramPublicFragmentActivity == null) {
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityPublicFragmentActivity = paramPublicFragmentActivity;
      this.jdField_a_of_type_AndroidViewViewGroup = paramViewGroup;
      this.jdField_a_of_type_AndroidWidgetEditText = paramEditText;
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewIEmoticonMainPanel = a(paramPublicFragmentActivity, paramViewGroup, paramEditText, paramInt, new WSCommentEmoController.2(this));
      this.jdField_a_of_type_AndroidWidgetImageButton = a(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewIEmoticonMainPanel.getView(), android.text.TextUtils.isEmpty(this.jdField_a_of_type_AndroidWidgetEditText.getText()));
      this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(new WSCommentEmoController.3(this));
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void b()
  {
    this.jdField_a_of_type_Boolean = true;
    ViewGroup localViewGroup = this.jdField_a_of_type_AndroidViewViewGroup;
    if (localViewGroup != null) {
      localViewGroup.setVisibility(0);
    }
  }
  
  public void c()
  {
    this.jdField_a_of_type_Boolean = false;
    ViewGroup localViewGroup = this.jdField_a_of_type_AndroidViewViewGroup;
    if (localViewGroup != null) {
      localViewGroup.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.comment.WSCommentEmoController
 * JD-Core Version:    0.7.0.1
 */