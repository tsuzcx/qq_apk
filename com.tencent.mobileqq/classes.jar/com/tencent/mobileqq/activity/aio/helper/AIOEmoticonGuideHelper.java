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
  private BaseChatPie a;
  private EmoticonGuideBubbleView b;
  private final MqqHandler c;
  private QQSysAndEmojiConfProcessor.SystemAndEmojiConfBean d;
  
  public AIOEmoticonGuideHelper(BaseChatPie paramBaseChatPie)
  {
    this.a = paramBaseChatPie;
    this.c = new MqqWeakReferenceHandler(Looper.getMainLooper(), this);
    paramBaseChatPie.bv().d().a(this);
  }
  
  private boolean a(QQSysAndEmojiConfProcessor.SystemAndEmojiConfBean paramSystemAndEmojiConfBean)
  {
    boolean bool2 = false;
    if (paramSystemAndEmojiConfBean == null) {
      return false;
    }
    boolean bool1 = bool2;
    if (((Boolean)SharedPreUtils.c("key_show_emoticon_guide", Boolean.valueOf(true))).booleanValue())
    {
      bool1 = bool2;
      if (paramSystemAndEmojiConfBean.n.b()) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private void b(QQSysAndEmojiConfProcessor.SystemAndEmojiConfBean paramSystemAndEmojiConfBean)
  {
    if (paramSystemAndEmojiConfBean == null) {
      return;
    }
    if (this.a != null)
    {
      if (!a(paramSystemAndEmojiConfBean)) {
        return;
      }
      if (AIOEmoticonUIHelper.a(this.a.bv()) == null) {
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("aio_emoticon_guide.helper", 2, "realShowGuideBubble start.");
      }
      this.d = paramSystemAndEmojiConfBean;
      if (this.b == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("aio_emoticon_guide.helper", 2, "showGuideBubble  mGuideBubbleView is new create.");
        }
        this.b = new EmoticonGuideBubbleView(this.a.e);
      }
      Object localObject = paramSystemAndEmojiConfBean.n.c;
      if (ThemeUtil.isNowThemeIsNight(this.a.d, false, null)) {
        localObject = paramSystemAndEmojiConfBean.n.d;
      }
      boolean bool = ThemeUtil.isNowThemeIsSimple(this.a.d, false, null);
      if (!this.b.a(this.a.bl(), this.a.W, (String)localObject, paramSystemAndEmojiConfBean.n.h, paramSystemAndEmojiConfBean.n.i, bool)) {
        return;
      }
      ReportController.b(this.a.d, "dc00898", "", "", "0X800AD4C", "0X800AD4C", 0, 0, "", "", "", "");
      this.b.setOnClickListener(this);
      SharedPreUtils.a("key_show_emoticon_guide", Boolean.valueOf(false));
      this.c.removeCallbacksAndMessages(null);
      localObject = this.c;
      long l;
      if (paramSystemAndEmojiConfBean.n.j <= 0) {
        l = 3000L;
      } else {
        l = paramSystemAndEmojiConfBean.n.j * 1000;
      }
      ((MqqHandler)localObject).sendEmptyMessageDelayed(1, l);
    }
  }
  
  public void a()
  {
    if (!((Boolean)SharedPreUtils.c("key_show_emoticon_guide", Boolean.valueOf(true))).booleanValue()) {
      return;
    }
    ThreadManager.getFileThreadHandler().post(new AIOEmoticonGuideHelper.1(this));
  }
  
  public void b()
  {
    EmoticonGuideBubbleView localEmoticonGuideBubbleView = this.b;
    if ((localEmoticonGuideBubbleView != null) && (localEmoticonGuideBubbleView.getVisibility() == 0) && (this.a != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("aio_emoticon_guide.helper", 2, "removeGuideBubble ");
      }
      this.d = null;
      this.b.a(this.a.bl());
    }
    this.c.removeCallbacksAndMessages(null);
    this.b = null;
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
      b((QQSysAndEmojiConfProcessor.SystemAndEmojiConfBean)paramMessage.obj);
    }
    return true;
  }
  
  public int[] interestedIn()
  {
    return new int[] { 11, 15 };
  }
  
  public void onClick(View paramView)
  {
    Object localObject = this.a;
    if (localObject != null)
    {
      localObject = AIOEmoticonUIHelper.a(((BaseChatPie)localObject).bv());
      if (localObject != null)
      {
        QQSysAndEmojiConfProcessor.SystemAndEmojiConfBean localSystemAndEmojiConfBean = this.d;
        if (localSystemAndEmojiConfBean != null)
        {
          int i = localSystemAndEmojiConfBean.n.e;
          int k = this.d.n.f;
          int j;
          if (k == 1)
          {
            j = QQSysFaceUtil.convertToLocal(i);
            i = j;
            if (!QQSysFaceUtil.isValidFaceId(j)) {
              break label170;
            }
          }
          else if (k == 2)
          {
            j = QQEmojiUtil.getEmojiLocalId(i);
            i = j;
            if (!QQEmojiUtil.isValidEmojiId(j)) {
              break label170;
            }
          }
          else
          {
            i = -1;
          }
          if (i != -1)
          {
            ReportController.b(this.a.d, "dc00898", "", "", "0X800AD4D", "0X800AD4D", 0, 0, "", "", "", "");
            ((IEmoticonMainPanel)localObject).switchSystemEmojiTabLocationPos(k, i);
          }
          b();
          break label170;
        }
      }
      b();
    }
    label170:
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.AIOEmoticonGuideHelper
 * JD-Core Version:    0.7.0.1
 */