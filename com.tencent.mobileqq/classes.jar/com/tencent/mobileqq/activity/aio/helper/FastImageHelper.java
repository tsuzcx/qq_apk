package com.tencent.mobileqq.activity.aio.helper;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Handler.Callback;
import android.os.Message;
import android.preference.PreferenceManager;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.core.TroopChatPie;
import com.tencent.mobileqq.activity.aio.core.helper.CoreHelperProvider;
import com.tencent.mobileqq.activity.aio.rebuild.PlusPanelUtils;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.emoticonview.FastImagePreviewLayout;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

public class FastImageHelper
  implements Handler.Callback, View.OnClickListener, ILifeCycleHelper
{
  public static String a = "FastImageHelper";
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Context jdField_a_of_type_AndroidContentContext;
  RelativeLayout.LayoutParams jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams;
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  public FastImagePreviewLayout a;
  private final boolean jdField_a_of_type_Boolean = true;
  private boolean b = true;
  
  public FastImageHelper(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramBaseChatPie.jdField_a_of_type_AndroidContentContext;
    this.jdField_a_of_type_AndroidAppActivity = paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
    paramBaseChatPie.b().a().a(this);
  }
  
  public void a()
  {
    this.b = true;
  }
  
  public void a(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
  
  public boolean a()
  {
    return this.b;
  }
  
  public boolean a(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i != 32)
    {
      if (i != 33) {
        return false;
      }
      b(true);
      return false;
    }
    if (QLog.isColorLevel())
    {
      paramMessage = new StringBuilder();
      paramMessage.append("MSG_SHOW_FASTIMAGE,  mAllowFastImage = ");
      paramMessage.append(this.b);
      QLog.d("fastimage", 2, paramMessage.toString());
    }
    if (!this.b) {
      return true;
    }
    paramMessage = (StickerRecHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(14);
    if ((paramMessage != null) && (paramMessage.a()))
    {
      paramMessage.b();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a().removeMessages(67);
    }
    paramMessage = this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFastImagePreviewLayout;
    if ((paramMessage != null) && (paramMessage.getVisibility() == 0)) {
      b(false);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a().addView(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFastImagePreviewLayout, this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams);
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004D91", "0X8004D91", 0, 0, "", "", "", "");
    paramMessage = this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFastImagePreviewLayout;
    if (paramMessage != null)
    {
      paramMessage.showFastImage();
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFastImagePreviewLayout.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a().sendMessageDelayed(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a().obtainMessage(33), 5000L);
    return false;
  }
  
  public void b()
  {
    float f = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources().getDisplayMetrics().density;
    if (QLog.isColorLevel()) {
      QLog.d("fastimage", 2, "initAndQueryFastImage start! ");
    }
    Object localObject;
    if (!this.b)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("initAndQueryFastImage return!,  mAllowFastImage = ");
        ((StringBuilder)localObject).append(this.b);
        QLog.d("fastimage", 2, ((StringBuilder)localObject).toString());
      }
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFastImagePreviewLayout == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFastImagePreviewLayout = ((FastImagePreviewLayout)this.jdField_a_of_type_AndroidAppActivity.getLayoutInflater().inflate(2131558542, null));
      this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams.addRule(2, 2131368875);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams.addRule(7, 2131368875);
      localObject = this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams;
      double d = f;
      Double.isNaN(d);
      ((RelativeLayout.LayoutParams)localObject).rightMargin = ((int)(d * 10.5D + 0.5D));
      ((RelativeLayout.LayoutParams)localObject).bottomMargin = ((int)(f * 4.0F + 0.5F));
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFastImagePreviewLayout.setId(2131362365);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFastImagePreviewLayout.setHandler(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a());
    }
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFastImagePreviewLayout.queryFastImage();
    if (QLog.isColorLevel()) {
      QLog.d("fastimage", 2, "initAndQueryFastImage end! ");
    }
  }
  
  public void b(boolean paramBoolean)
  {
    FastImagePreviewLayout localFastImagePreviewLayout = this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFastImagePreviewLayout;
    if ((localFastImagePreviewLayout != null) && (localFastImagePreviewLayout.getVisibility() == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("fastimage", 2, "onPanelIconClick  removeFastImage");
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a().removeMessages(33);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFastImagePreviewLayout.removeFastImage(paramBoolean);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFastImagePreviewLayout.setOnClickListener(null);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a().removeView(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFastImagePreviewLayout);
    }
  }
  
  public void c()
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("BaseCHatPie onClick call enterPhotoPreivew. path = ");
      ((StringBuilder)localObject).append(PlusPanelUtils.b);
      QLog.d("fastimage", 2, ((StringBuilder)localObject).toString());
    }
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004D92", "0X8004D92", 0, 0, "", "", "", "");
    PreferenceManager.getDefaultSharedPreferences(this.jdField_a_of_type_AndroidContentContext).edit().putString("camera_photo_path", PlusPanelUtils.b).commit();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
    if ((localObject != null) && (((SessionInfo)localObject).jdField_a_of_type_Int == 1) && (((HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.HOT_CHAT_MANAGER)).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)))
    {
      localObject = new Intent();
      ((Intent)localObject).putExtra("PhotoConst.IS_SINGLE_MODE", true);
    }
    else
    {
      localObject = null;
    }
    SessionInfo localSessionInfo = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
    if (localSessionInfo != null) {
      ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, localSessionInfo, 1, (Intent)localObject, 8);
    }
    if (QLog.isColorLevel()) {
      QLog.d("fastimage", 2, "BaseCHatPie onClick call removeFastImage");
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a().removeMessages(33);
    localObject = this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFastImagePreviewLayout;
    if (localObject != null)
    {
      ((FastImagePreviewLayout)localObject).setOnClickListener(null);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a().removeView(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFastImagePreviewLayout);
    }
  }
  
  public String getTag()
  {
    return jdField_a_of_type_JavaLangString;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    return a(paramMessage);
  }
  
  public int[] interestedIn()
  {
    return new int[] { 6 };
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if ((i != 2131362365) && (i != 2131372878)) {
      b(true);
    }
    if (i == 2131362365) {
      c();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onMoveToState(int paramInt)
  {
    if ((paramInt == 6) && ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie instanceof TroopChatPie))) {
      a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.FastImageHelper
 * JD-Core Version:    0.7.0.1
 */