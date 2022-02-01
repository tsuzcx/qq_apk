package com.tencent.mobileqq.activity.aio.helper;

import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.config.business.QQSysAndEmojiConfProcessor.EmoticonGuideConfBean;
import com.tencent.mobileqq.config.business.QQSysAndEmojiConfProcessor.SystemAndEmojiConfBean;
import com.tencent.mobileqq.emosm.AIOEmoticonUIHelper;
import com.tencent.mobileqq.emoticon.QQEmojiUtil;
import com.tencent.mobileqq.emoticon.QQSysFaceUtil;
import com.tencent.mobileqq.emoticonview.EmoticonGuideBubbleView;
import com.tencent.mobileqq.emoticonview.EmoticonMainPanel;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.MqqWeakReferenceHandler;
import mqq.os.MqqHandler;

public class AIOEmoticonGuideHelper
  implements Handler.Callback, View.OnClickListener, IHelper, ILifeCycleHelper
{
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
  private QQSysAndEmojiConfProcessor.SystemAndEmojiConfBean jdField_a_of_type_ComTencentMobileqqConfigBusinessQQSysAndEmojiConfProcessor$SystemAndEmojiConfBean;
  private EmoticonGuideBubbleView jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonGuideBubbleView;
  private final MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  
  public AIOEmoticonGuideHelper(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_MqqOsMqqHandler = new MqqWeakReferenceHandler(Looper.getMainLooper(), this);
  }
  
  private void a(QQSysAndEmojiConfProcessor.SystemAndEmojiConfBean paramSystemAndEmojiConfBean)
  {
    if (paramSystemAndEmojiConfBean == null) {}
    String str;
    boolean bool;
    do
    {
      do
      {
        return;
      } while ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null) || (!a(paramSystemAndEmojiConfBean)) || (AIOEmoticonUIHelper.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie) == null));
      if (QLog.isColorLevel()) {
        QLog.d("aio_emoticon_guide.helper", 2, "realShowGuideBubble start.");
      }
      this.jdField_a_of_type_ComTencentMobileqqConfigBusinessQQSysAndEmojiConfProcessor$SystemAndEmojiConfBean = paramSystemAndEmojiConfBean;
      if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonGuideBubbleView == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("aio_emoticon_guide.helper", 2, "showGuideBubble  mGuideBubbleView is new create.");
        }
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonGuideBubbleView = new EmoticonGuideBubbleView(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_AndroidContentContext);
      }
      str = paramSystemAndEmojiConfBean.a.a;
      if (ThemeUtil.isNowThemeIsNight(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, null)) {
        str = paramSystemAndEmojiConfBean.a.b;
      }
      bool = ThemeUtil.isNowThemeIsSimple(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, null);
    } while (!this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonGuideBubbleView.showGuideBubble(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout, str, paramSystemAndEmojiConfBean.a.e, paramSystemAndEmojiConfBean.a.f, bool));
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800AD4C", "0X800AD4C", 0, 0, "", "", "", "");
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonGuideBubbleView.setOnClickListener(this);
    SharedPreUtils.a("key_show_emoticon_guide", Boolean.valueOf(false));
    this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(1, 3000L);
  }
  
  private boolean a(QQSysAndEmojiConfProcessor.SystemAndEmojiConfBean paramSystemAndEmojiConfBean)
  {
    if (paramSystemAndEmojiConfBean == null) {
      return false;
    }
    if ((((Boolean)SharedPreUtils.a("key_show_emoticon_guide", Boolean.valueOf(true))).booleanValue()) && (paramSystemAndEmojiConfBean.a.b())) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public void a()
  {
    if (!((Boolean)SharedPreUtils.a("key_show_emoticon_guide", Boolean.valueOf(true))).booleanValue()) {
      return;
    }
    ThreadManager.getFileThreadHandler().post(new AIOEmoticonGuideHelper.1(this));
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonGuideBubbleView != null) && (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonGuideBubbleView.getVisibility() == 0) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("aio_emoticon_guide.helper", 2, "removeGuideBubble ");
      }
      this.jdField_a_of_type_ComTencentMobileqqConfigBusinessQQSysAndEmojiConfProcessor$SystemAndEmojiConfBean = null;
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonGuideBubbleView.removeGuideBubble(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a());
    }
    this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonGuideBubbleView = null;
  }
  
  public String getTag()
  {
    return "aio_emoticon_guide.helper";
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1) {
      b();
    }
    while (paramMessage.what != 2) {
      return true;
    }
    a((QQSysAndEmojiConfProcessor.SystemAndEmojiConfBean)paramMessage.obj);
    return true;
  }
  
  public int[] interestedIn()
  {
    return new int[] { 10, 14 };
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null) {
      break label93;
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      EmoticonMainPanel localEmoticonMainPanel = AIOEmoticonUIHelper.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie);
      if ((localEmoticonMainPanel != null) && (this.jdField_a_of_type_ComTencentMobileqqConfigBusinessQQSysAndEmojiConfProcessor$SystemAndEmojiConfBean != null))
      {
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonGuideBubbleView.removeGuideBubble(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a());
        int j = this.jdField_a_of_type_ComTencentMobileqqConfigBusinessQQSysAndEmojiConfProcessor$SystemAndEmojiConfBean.a.c;
        int k = this.jdField_a_of_type_ComTencentMobileqqConfigBusinessQQSysAndEmojiConfProcessor$SystemAndEmojiConfBean.a.d;
        int i = -1;
        if (k == 1)
        {
          i = QQSysFaceUtil.convertToLocal(j);
          if (QQSysFaceUtil.isValidFaceId(i)) {
            label93:
            if (i != -1)
            {
              ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800AD4D", "0X800AD4D", 0, 0, "", "", "", "");
              localEmoticonMainPanel.switchSystemEmojiTabLocationPos(k, i);
            }
          }
        }
        else
        {
          if (k != 2) {
            break;
          }
          j = QQEmojiUtil.getEmojiLocalId(j);
          i = j;
          if (QQEmojiUtil.isValidEmojiId(j)) {
            break;
          }
        }
      }
    }
  }
  
  public void onMoveToState(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.AIOEmoticonGuideHelper
 * JD-Core Version:    0.7.0.1
 */