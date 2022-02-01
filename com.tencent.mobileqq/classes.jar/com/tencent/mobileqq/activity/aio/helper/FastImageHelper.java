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
  public FastImagePreviewLayout b;
  RelativeLayout.LayoutParams c;
  private QQAppInterface d;
  private Context e;
  private Activity f;
  private BaseChatPie g;
  private SessionInfo h;
  private final boolean i = true;
  private boolean j = true;
  
  public FastImageHelper(BaseChatPie paramBaseChatPie)
  {
    this.d = paramBaseChatPie.d;
    this.e = paramBaseChatPie.e;
    this.f = paramBaseChatPie.f;
    this.g = paramBaseChatPie;
    this.h = paramBaseChatPie.ah;
    paramBaseChatPie.bv().d().a(this);
  }
  
  public void a(boolean paramBoolean)
  {
    this.j = paramBoolean;
  }
  
  public boolean a()
  {
    return this.j;
  }
  
  public boolean a(Message paramMessage)
  {
    int k = paramMessage.what;
    if (k != 32)
    {
      if (k != 33) {
        return false;
      }
      b(true);
      return false;
    }
    if (QLog.isColorLevel())
    {
      paramMessage = new StringBuilder();
      paramMessage.append("MSG_SHOW_FASTIMAGE,  mAllowFastImage = ");
      paramMessage.append(this.j);
      QLog.d("fastimage", 2, paramMessage.toString());
    }
    if (!this.j) {
      return true;
    }
    paramMessage = (StickerRecHelper)this.g.q(14);
    if ((paramMessage != null) && (paramMessage.c()))
    {
      paramMessage.b();
      this.g.j().removeMessages(67);
    }
    paramMessage = this.b;
    if ((paramMessage != null) && (paramMessage.getVisibility() == 0)) {
      b(false);
    }
    this.g.bl().addView(this.b, this.c);
    ReportController.b(this.d, "CliOper", "", "", "0X8004D91", "0X8004D91", 0, 0, "", "", "", "");
    paramMessage = this.b;
    if (paramMessage != null)
    {
      paramMessage.showFastImage();
      this.b.setOnClickListener(this.g);
    }
    this.g.j().sendMessageDelayed(this.g.j().obtainMessage(33), 5000L);
    return false;
  }
  
  public void b()
  {
    this.j = true;
  }
  
  public void b(boolean paramBoolean)
  {
    FastImagePreviewLayout localFastImagePreviewLayout = this.b;
    if ((localFastImagePreviewLayout != null) && (localFastImagePreviewLayout.getVisibility() == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("fastimage", 2, "onPanelIconClick  removeFastImage");
      }
      this.g.j().removeMessages(33);
      this.b.removeFastImage(paramBoolean);
      this.b.setOnClickListener(null);
      this.g.bl().removeView(this.b);
    }
  }
  
  public void c()
  {
    float f1 = this.d.getApplication().getResources().getDisplayMetrics().density;
    if (QLog.isColorLevel()) {
      QLog.d("fastimage", 2, "initAndQueryFastImage start! ");
    }
    Object localObject;
    if (!this.j)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("initAndQueryFastImage return!,  mAllowFastImage = ");
        ((StringBuilder)localObject).append(this.j);
        QLog.d("fastimage", 2, ((StringBuilder)localObject).toString());
      }
      return;
    }
    if (this.b == null)
    {
      this.b = ((FastImagePreviewLayout)this.f.getLayoutInflater().inflate(2131624095, null));
      this.c = new RelativeLayout.LayoutParams(-2, -2);
      this.c.addRule(2, 2131435809);
      this.c.addRule(7, 2131435809);
      localObject = this.c;
      double d1 = f1;
      Double.isNaN(d1);
      ((RelativeLayout.LayoutParams)localObject).rightMargin = ((int)(d1 * 10.5D + 0.5D));
      ((RelativeLayout.LayoutParams)localObject).bottomMargin = ((int)(f1 * 4.0F + 0.5F));
      this.b.setId(2131427965);
      this.b.setHandler(this.g.j());
    }
    this.b.queryFastImage();
    if (QLog.isColorLevel()) {
      QLog.d("fastimage", 2, "initAndQueryFastImage end! ");
    }
  }
  
  public void d()
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("BaseCHatPie onClick call enterPhotoPreivew. path = ");
      ((StringBuilder)localObject).append(PlusPanelUtils.b);
      QLog.d("fastimage", 2, ((StringBuilder)localObject).toString());
    }
    ReportController.b(this.d, "CliOper", "", "", "0X8004D92", "0X8004D92", 0, 0, "", "", "", "");
    PreferenceManager.getDefaultSharedPreferences(this.e).edit().putString("camera_photo_path", PlusPanelUtils.b).commit();
    Object localObject = this.h;
    if ((localObject != null) && (((SessionInfo)localObject).a == 1) && (((HotChatManager)this.d.getManager(QQManagerFactory.HOT_CHAT_MANAGER)).b(this.h.b)))
    {
      localObject = new Intent();
      ((Intent)localObject).putExtra("PhotoConst.IS_SINGLE_MODE", true);
    }
    else
    {
      localObject = null;
    }
    SessionInfo localSessionInfo = this.h;
    if (localSessionInfo != null) {
      ChatActivityUtils.a(this.d, this.f, localSessionInfo, 1, (Intent)localObject, 8);
    }
    if (QLog.isColorLevel()) {
      QLog.d("fastimage", 2, "BaseCHatPie onClick call removeFastImage");
    }
    this.g.j().removeMessages(33);
    localObject = this.b;
    if (localObject != null)
    {
      ((FastImagePreviewLayout)localObject).setOnClickListener(null);
      this.g.bl().removeView(this.b);
    }
  }
  
  public String getTag()
  {
    return a;
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
    int k = paramView.getId();
    if ((k != 2131427965) && (k != 2131440441)) {
      b(true);
    }
    if (k == 2131427965) {
      d();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onMoveToState(int paramInt)
  {
    if ((paramInt == 6) && ((this.g instanceof TroopChatPie))) {
      b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.FastImageHelper
 * JD-Core Version:    0.7.0.1
 */