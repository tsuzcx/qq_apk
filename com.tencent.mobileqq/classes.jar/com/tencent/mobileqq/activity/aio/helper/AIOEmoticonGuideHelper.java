package com.tencent.mobileqq.activity.aio.helper;

import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.core.helper.CoreHelperProvider;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.config.business.QQSysAndEmojiConfProcessor.EmoticonGuideConfBean;
import com.tencent.mobileqq.config.business.QQSysAndEmojiConfProcessor.SystemAndEmojiConfBean;
import com.tencent.mobileqq.emosm.AIOEmoticonUIHelper;
import com.tencent.mobileqq.emosm.view.EmoticonGuideBubbleView;
import com.tencent.mobileqq.emoticon.QQEmojiUtil;
import com.tencent.mobileqq.emoticon.QQSysFaceUtil;
import com.tencent.mobileqq.emoticonview.IEmoticonMainPanel;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.MqqWeakReferenceHandler;
import mqq.os.MqqHandler;

public class AIOEmoticonGuideHelper
  implements Handler.Callback, View.OnClickListener, IHelper, ILifeCycleHelper
{
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
  private QQSysAndEmojiConfProcessor.SystemAndEmojiConfBean jdField_a_of_type_ComTencentMobileqqConfigBusinessQQSysAndEmojiConfProcessor$SystemAndEmojiConfBean;
  private EmoticonGuideBubbleView jdField_a_of_type_ComTencentMobileqqEmosmViewEmoticonGuideBubbleView;
  private final MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  
  public AIOEmoticonGuideHelper(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_MqqOsMqqHandler = new MqqWeakReferenceHandler(Looper.getMainLooper(), this);
    paramBaseChatPie.b().a().a(this);
  }
  
  private void a(QQSysAndEmojiConfProcessor.SystemAndEmojiConfBean paramSystemAndEmojiConfBean)
  {
    if (paramSystemAndEmojiConfBean == null) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null)
    {
      if (!a(paramSystemAndEmojiConfBean)) {
        return;
      }
      if (AIOEmoticonUIHelper.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.b()) == null) {
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("aio_emoticon_guide.helper", 2, "realShowGuideBubble start.");
      }
      this.jdField_a_of_type_ComTencentMobileqqConfigBusinessQQSysAndEmojiConfProcessor$SystemAndEmojiConfBean = paramSystemAndEmojiConfBean;
      if (this.jdField_a_of_type_ComTencentMobileqqEmosmViewEmoticonGuideBubbleView == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("aio_emoticon_guide.helper", 2, "showGuideBubble  mGuideBubbleView is new create.");
        }
        this.jdField_a_of_type_ComTencentMobileqqEmosmViewEmoticonGuideBubbleView = new EmoticonGuideBubbleView(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_AndroidContentContext);
      }
      Object localObject = paramSystemAndEmojiConfBean.a.a;
      if (ThemeUtil.isNowThemeIsNight(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, null)) {
        localObject = paramSystemAndEmojiConfBean.a.b;
      }
      boolean bool = ThemeUtil.isNowThemeIsSimple(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, null);
      if (!this.jdField_a_of_type_ComTencentMobileqqEmosmViewEmoticonGuideBubbleView.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout, (String)localObject, paramSystemAndEmojiConfBean.a.e, paramSystemAndEmojiConfBean.a.f, bool)) {
        return;
      }
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800AD4C", "0X800AD4C", 0, 0, "", "", "", "");
      this.jdField_a_of_type_ComTencentMobileqqEmosmViewEmoticonGuideBubbleView.setOnClickListener(this);
      SharedPreUtils.a("key_show_emoticon_guide", Boolean.valueOf(false));
      this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
      localObject = this.jdField_a_of_type_MqqOsMqqHandler;
      long l;
      if (paramSystemAndEmojiConfBean.a.g <= 0) {
        l = 3000L;
      } else {
        l = paramSystemAndEmojiConfBean.a.g * 1000;
      }
      ((MqqHandler)localObject).sendEmptyMessageDelayed(1, l);
    }
  }
  
  private boolean a(QQSysAndEmojiConfProcessor.SystemAndEmojiConfBean paramSystemAndEmojiConfBean)
  {
    boolean bool2 = false;
    if (paramSystemAndEmojiConfBean == null) {
      return false;
    }
    boolean bool1 = bool2;
    if (((Boolean)SharedPreUtils.a("key_show_emoticon_guide", Boolean.valueOf(true))).booleanValue())
    {
      bool1 = bool2;
      if (paramSystemAndEmojiConfBean.a.b()) {
        bool1 = true;
      }
    }
    return bool1;
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
    EmoticonGuideBubbleView localEmoticonGuideBubbleView = this.jdField_a_of_type_ComTencentMobileqqEmosmViewEmoticonGuideBubbleView;
    if ((localEmoticonGuideBubbleView != null) && (localEmoticonGuideBubbleView.getVisibility() == 0) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("aio_emoticon_guide.helper", 2, "removeGuideBubble ");
      }
      this.jdField_a_of_type_ComTencentMobileqqConfigBusinessQQSysAndEmojiConfProcessor$SystemAndEmojiConfBean = null;
      this.jdField_a_of_type_ComTencentMobileqqEmosmViewEmoticonGuideBubbleView.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a());
    }
    this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_ComTencentMobileqqEmosmViewEmoticonGuideBubbleView = null;
  }
  
  public String getTag()
  {
    return "aio_emoticon_guide.helper";
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1)
    {
      b();
      return true;
    }
    if (paramMessage.what == 2) {
      a((QQSysAndEmojiConfProcessor.SystemAndEmojiConfBean)paramMessage.obj);
    }
    return true;
  }
  
  public int[] interestedIn()
  {
    return new int[] { 11, 15 };
  }
  
  public void onClick(View paramView)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
    if (localObject != null)
    {
      localObject = AIOEmoticonUIHelper.a(((BaseChatPie)localObject).b());
      if (localObject != null)
      {
        QQSysAndEmojiConfProcessor.SystemAndEmojiConfBean localSystemAndEmojiConfBean = this.jdField_a_of_type_ComTencentMobileqqConfigBusinessQQSysAndEmojiConfProcessor$SystemAndEmojiConfBean;
        if (localSystemAndEmojiConfBean != null)
        {
          int i = localSystemAndEmojiConfBean.a.c;
          int k = this.jdField_a_of_type_ComTencentMobileqqConfigBusinessQQSysAndEmojiConfProcessor$SystemAndEmojiConfBean.a.d;
          int j;
          if (k == 1)
          {
            j = QQSysFaceUtil.convertToLocal(i);
            i = j;
            if (!QQSysFaceUtil.isValidFaceId(j)) {
              break label168;
            }
          }
          else if (k == 2)
          {
            j = QQEmojiUtil.getEmojiLocalId(i);
            i = j;
            if (!QQEmojiUtil.isValidEmojiId(j)) {
              break label168;
            }
          }
          else
          {
            i = -1;
          }
          if (i != -1)
          {
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800AD4D", "0X800AD4D", 0, 0, "", "", "", "");
            ((IEmoticonMainPanel)localObject).switchSystemEmojiTabLocationPos(k, i);
          }
          b();
          break label168;
        }
      }
      b();
    }
    label168:
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onMoveToState(int paramInt)
  {
    if ((paramInt != 11) && (paramInt != 15)) {
      return;
    }
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.AIOEmoticonGuideHelper
 * JD-Core Version:    0.7.0.1
 */