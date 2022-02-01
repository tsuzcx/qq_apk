package com.tencent.mobileqq.activity.aio.helper;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.aio.InputLinearLayout;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.panel.PanelIconLinearLayout;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.emoticonview.AIOEmoticonPanelHelper;
import com.tencent.mobileqq.emoticonview.EmoticonCallback;
import com.tencent.mobileqq.emoticonview.relateemo.IAIORelatedEmotionExpandHelper;
import com.tencent.mobileqq.emoticonview.relateemo.IRelatedEmotionPanel;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XPanelContainer;
import mqq.os.MqqHandler;

public class AIORelatedEmotionHelper
  implements IHelper, ILifeCycleHelper, IAIORelatedEmotionExpandHelper
{
  private int jdField_a_of_type_Int = 0;
  private Context jdField_a_of_type_AndroidContentContext;
  private View jdField_a_of_type_AndroidViewView;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
  protected IRelatedEmotionPanel a;
  private boolean jdField_a_of_type_Boolean = true;
  private int b;
  private int c;
  private int d;
  
  public AIORelatedEmotionHelper(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_AndroidContentContext = paramBaseChatPie.jdField_a_of_type_AndroidContentContext;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
    double d1 = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().heightPixels;
    Double.isNaN(d1);
    this.d = ((int)(d1 * 0.6D));
  }
  
  private void b()
  {
    this.jdField_a_of_type_AndroidViewView = null;
    a();
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewRelateemoIRelatedEmotionPanel = null;
  }
  
  public int a()
  {
    int i = 0;
    if (!ThemeUtil.isNowThemeIsNight(null, false, null)) {
      i = ViewUtils.a(15.0F);
    }
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.getHeight() + this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.getHeight() - this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.getPaddingTop() + i;
  }
  
  public View a()
  {
    if (this.jdField_a_of_type_AndroidViewView == null) {
      this.jdField_a_of_type_AndroidViewView = new View(this.jdField_a_of_type_AndroidContentContext);
    }
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIORelatedEmotionHelper", 4, " resetLastStatus ");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewRelateemoIRelatedEmotionPanel == null) {
      return;
    }
    int i = this.b;
    if ((i >= this.d) || (i <= this.c)) {
      this.b = this.c;
    }
    XPanelContainer.jdField_a_of_type_Int = this.b;
    i = this.jdField_a_of_type_Int;
    if (i == 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a().a(false);
      return;
    }
    if (i == 1) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a().a(false);
    }
  }
  
  public void a(ChatMessage paramChatMessage, URLDrawable paramURLDrawable)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIORelatedEmotionHelper", 4, " showSearchRelatedEmotionPanel ");
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
    if ((localObject != null) && (((BaseChatPie)localObject).a() != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout != null))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout == null) {
        return;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewRelateemoIRelatedEmotionPanel == null) {
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewRelateemoIRelatedEmotionPanel = ((IRelatedEmotionPanel)View.inflate(this.jdField_a_of_type_AndroidContentContext, 2131558573, null));
      }
      this.c = ((Integer)SharedPreUtils.a(BaseApplication.getContext(), "", "sp_key_input_height", Integer.valueOf(0))).intValue();
      if (this.c == 0) {
        this.c = ((int)(XPanelContainer.b() * this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().density));
      }
      this.b = XPanelContainer.jdField_a_of_type_Int;
      localObject = (AIOEmoticonPanelHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(104);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewRelateemoIRelatedEmotionPanel.init(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (EmoticonCallback)localObject, this);
      this.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.c();
      int i = this.d;
      int j = a();
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewRelateemoIRelatedEmotionPanel.showEmotionSearchWindow(paramChatMessage, paramURLDrawable, i + j);
      this.jdField_a_of_type_Boolean = true;
      i = this.jdField_a_of_type_Int;
      if (i == 1)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a().a(37);
        return;
      }
      if (i == 0)
      {
        XPanelContainer.jdField_a_of_type_Int = this.d;
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a().postDelayed(new AIORelatedEmotionHelper.2(this), 150L);
      }
    }
  }
  
  public String getTag()
  {
    return "AIORelatedEmotionHelper";
  }
  
  public int[] interestedIn()
  {
    return new int[] { 15, 8 };
  }
  
  public void onClosePanel()
  {
    a();
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewRelateemoIRelatedEmotionPanel = null;
  }
  
  public void onMoveToState(int paramInt)
  {
    if (paramInt == 8)
    {
      ThreadManager.getFileThreadHandler().post(new AIORelatedEmotionHelper.1(this));
      return;
    }
    if (paramInt == 15) {
      b();
    }
  }
  
  public void updatePanelDistance(float paramFloat)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewRelateemoIRelatedEmotionPanel == null) {
      return;
    }
    int i = this.d;
    int j = (int)(i - paramFloat);
    if (j < i)
    {
      i = j;
      if (j <= 0) {
        i = 0;
      }
    }
    if (this.jdField_a_of_type_Boolean)
    {
      if ((this.jdField_a_of_type_Int != 0) && (i >= this.b) && (XPanelContainer.jdField_a_of_type_Int <= this.d))
      {
        XPanelContainer.jdField_a_of_type_Int = i;
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a().requestLayout();
      }
    }
    else
    {
      j = this.jdField_a_of_type_Int;
      if ((j != 0) && (j != 1))
      {
        if (i <= this.c)
        {
          j = XPanelContainer.jdField_a_of_type_Int;
          int k = this.c;
          if (j != k)
          {
            XPanelContainer.jdField_a_of_type_Int = k;
            this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a().requestLayout();
          }
        }
        else
        {
          XPanelContainer.jdField_a_of_type_Int = i;
          this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a().requestLayout();
        }
      }
      else
      {
        XPanelContainer.jdField_a_of_type_Int = i;
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a().requestLayout();
      }
    }
    if (i >= this.d) {
      this.jdField_a_of_type_Boolean = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.AIORelatedEmotionHelper
 * JD-Core Version:    0.7.0.1
 */