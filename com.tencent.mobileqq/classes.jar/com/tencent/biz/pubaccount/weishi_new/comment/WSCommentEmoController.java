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
  public static Editable.Factory a = new WSCommentEmoController.1();
  private ViewGroup b;
  private IEmoticonMainPanel c;
  private ImageButton d;
  private EditText e;
  private PublicFragmentActivity f;
  private boolean g = false;
  
  private ImageButton a(RelativeLayout paramRelativeLayout, boolean paramBoolean)
  {
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    ImageButton localImageButton = new ImageButton(paramRelativeLayout.getContext());
    localImageButton.setBackgroundResource(2130852729);
    int i;
    if (paramBoolean) {
      i = 8;
    } else {
      i = 0;
    }
    localImageButton.setVisibility(i);
    localLayoutParams.rightMargin = ViewUtils.dip2px(5.0F);
    localLayoutParams.bottomMargin = ViewUtils.dip2px(7.0F);
    localLayoutParams.addRule(11);
    localLayoutParams.addRule(12);
    paramRelativeLayout.addView(localImageButton, localLayoutParams);
    return localImageButton;
  }
  
  private IEmoticonMainPanel a(PublicFragmentActivity paramPublicFragmentActivity, ViewGroup paramViewGroup, EditText paramEditText, int paramInt, EmoticonCallback paramEmoticonCallback)
  {
    paramEditText.setEditableFactory(a);
    DeviceLib.a(paramPublicFragmentActivity, paramEditText);
    paramEditText = this.c;
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
      EditText localEditText = this.e;
      if (localEditText != null)
      {
        SystemAndEmojiEmoticonInfo localSystemAndEmojiEmoticonInfo = (SystemAndEmojiEmoticonInfo)paramEmoticonInfo;
        int i = localEditText.getSelectionStart();
        int j = this.e.getSelectionEnd();
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
            this.e.getEditableText().replace(i, j, paramEmoticonInfo);
          }
          catch (IllegalArgumentException paramEmoticonInfo)
          {
            QLog.e("WSCommentEmoController", 2, "sendEmoticon: ", paramEmoticonInfo);
          }
          localSystemAndEmojiEmoticonInfo.addToCommonUsed(this.f.app, null);
        }
      }
    }
  }
  
  public void a()
  {
    ImageButton localImageButton = this.d;
    if (localImageButton != null)
    {
      int i;
      if (android.text.TextUtils.isEmpty(this.e.getText())) {
        i = 8;
      } else {
        i = 0;
      }
      localImageButton.setVisibility(i);
    }
  }
  
  public void a(int paramInt)
  {
    IEmoticonMainPanel localIEmoticonMainPanel = this.c;
    if ((localIEmoticonMainPanel != null) && (localIEmoticonMainPanel.getView().getHeight() != paramInt))
    {
      this.c.getView().getLayoutParams().height = paramInt;
      this.c.getView().invalidate();
    }
  }
  
  public void a(PublicFragmentActivity paramPublicFragmentActivity, ViewGroup paramViewGroup, EditText paramEditText, int paramInt)
  {
    if ((paramEditText != null) && (paramViewGroup != null))
    {
      if (paramPublicFragmentActivity == null) {
        return;
      }
      this.f = paramPublicFragmentActivity;
      this.b = paramViewGroup;
      this.e = paramEditText;
      this.c = a(paramPublicFragmentActivity, paramViewGroup, paramEditText, paramInt, new WSCommentEmoController.2(this));
      this.d = a(this.c.getView(), android.text.TextUtils.isEmpty(this.e.getText()));
      this.d.setOnClickListener(new WSCommentEmoController.3(this));
    }
  }
  
  public void b()
  {
    this.g = true;
    ViewGroup localViewGroup = this.b;
    if (localViewGroup != null) {
      localViewGroup.setVisibility(0);
    }
  }
  
  public void c()
  {
    this.g = false;
    ViewGroup localViewGroup = this.b;
    if (localViewGroup != null) {
      localViewGroup.setVisibility(8);
    }
  }
  
  public boolean d()
  {
    return this.g;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.comment.WSCommentEmoController
 * JD-Core Version:    0.7.0.1
 */