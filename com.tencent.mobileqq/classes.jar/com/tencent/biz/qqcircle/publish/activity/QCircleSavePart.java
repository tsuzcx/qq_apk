package com.tencent.biz.qqcircle.publish.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qcircleshadow.lib.QCircleHostConstants.AppConstants;
import com.tencent.biz.qcircleshadow.lib.QCircleHostQzoneHelper;
import com.tencent.biz.qqcircle.bizparts.QCircleBasePart;
import com.tencent.biz.qqcircle.publish.account.LoginData;
import com.tencent.biz.richframework.delegate.impl.RFThreadManager;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.qcircle.cooperation.config.QCircleConfigHelper;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import java.util.ArrayList;
import java.util.List;

public class QCircleSavePart
  extends QCircleBasePart
  implements View.OnClickListener, SimpleEventReceiver
{
  private boolean a = true;
  private ImageView c;
  private TextView d;
  
  public static void a(List<String> paramList)
  {
    boolean bool = false;
    if (QCircleHostQzoneHelper.getInt4Uin("qcircle_publish_selected_grid_save", QCircleConfigHelper.a("qqcircle", "qqcircle_save_media_in_device_when_publish", Integer.valueOf(0)).intValue(), LoginData.a().b()) == 1) {
      bool = true;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("savePics... mIsNeedSaveGridContent:");
    localStringBuilder.append(bool);
    QLog.d("[QcirclePublish]QCircleSavePart", 1, localStringBuilder.toString());
    if ((QCircleConfigHelper.b()) && (bool)) {
      a(paramList, QCircleHostConstants.AppConstants.SDCARD_IMG_SAVE());
    }
  }
  
  public static void a(List<String> paramList, String paramString)
  {
    if (paramList.size() > 0)
    {
      RFThreadManager.execute(new QCircleSavePart.1(paramList, paramString), RFThreadManager.Normal);
      return;
    }
    QLog.d("[QcirclePublish]QCircleSavePart", 1, "saveMediaToAlbum... No elements in param imageFiles");
  }
  
  public String a()
  {
    return "[QcirclePublish]QCircleSavePart";
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    if (QCircleConfigHelper.b())
    {
      this.c = ((ImageView)paramView.findViewById(2131441866));
      this.d = ((TextView)paramView.findViewById(2131441867));
      this.c.setOnClickListener(this);
      paramView.findViewById(2131441738).setVisibility(0);
      boolean bool;
      if (QCircleHostQzoneHelper.getInt4Uin("qcircle_publish_selected_grid_save", QCircleConfigHelper.a("qqcircle", "qqcircle_save_media_in_device_when_publish", Integer.valueOf(0)).intValue(), LoginData.a().b()) == 1) {
        bool = true;
      } else {
        bool = false;
      }
      this.a = bool;
      QLog.d("[QcirclePublish]QCircleSavePart", 1, new Object[] { "onInitView... mIsNeedSaveGridContent:", Boolean.valueOf(this.a) });
      if (this.a)
      {
        this.c.setBackgroundDrawable(QCircleSkinHelper.getInstance().getDrawable(2130845424));
        this.d.setTextColor(QCircleSkinHelper.getInstance().getColor(2131167084));
        return;
      }
      this.c.setBackgroundDrawable(QCircleSkinHelper.getInstance().getDrawable(2130845423));
      this.d.setTextColor(QCircleSkinHelper.getInstance().getColor(2131167085));
    }
  }
  
  public ArrayList<Class> getEventClass()
  {
    return new ArrayList();
  }
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle)
  {
    super.onActivityCreated(paramActivity, paramBundle);
    SimpleEventBus.getInstance().registerReceiver(this);
  }
  
  public void onActivityDestroyed(Activity paramActivity)
  {
    SimpleEventBus.getInstance().unRegisterReceiver(this);
    super.onActivityDestroyed(paramActivity);
  }
  
  public void onActivityPaused(Activity paramActivity)
  {
    super.onActivityPaused(paramActivity);
  }
  
  public void onActivityResumed(Activity paramActivity)
  {
    super.onActivityResumed(paramActivity);
  }
  
  public void onClick(View paramView)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.publish.activity.QCircleSavePart
 * JD-Core Version:    0.7.0.1
 */