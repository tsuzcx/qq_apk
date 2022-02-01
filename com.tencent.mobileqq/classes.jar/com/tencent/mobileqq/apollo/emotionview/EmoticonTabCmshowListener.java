package com.tencent.mobileqq.apollo.emotionview;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.ImageView;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.apollo.statistics.product.DtReportParamsBuilder;
import com.tencent.mobileqq.apollo.statistics.product.api.IApolloDtReportHelper;
import com.tencent.mobileqq.emoticon.IEmotionTabCreateListener;
import com.tencent.mobileqq.emoticonview.IEmoticonMainPanelApp;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class EmoticonTabCmshowListener
  implements IEmotionTabCreateListener
{
  private Context a;
  private IEmoticonMainPanelApp b;
  private ImageView c;
  private int d = -1;
  private boolean e = false;
  
  public EmoticonTabCmshowListener(IEmoticonMainPanelApp paramIEmoticonMainPanelApp, Context paramContext)
  {
    this.b = paramIEmoticonMainPanelApp;
    this.a = paramContext;
  }
  
  public static boolean a(Context paramContext)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext);
    boolean bool = false;
    if (paramContext.getInt("apollo_emoji_tab_cmshow_first_red_dot", 0) == 0) {
      bool = true;
    }
    return bool;
  }
  
  public static void b(Context paramContext)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt("apollo_emoji_tab_cmshow_first_red_dot", 1);
    paramContext.commit();
  }
  
  public void a()
  {
    if (this.c != null)
    {
      Object localObject = this.b;
      if (localObject != null)
      {
        if (((IEmoticonMainPanelApp)localObject).getQQAppInterface() == null) {
          return;
        }
        this.e = a(this.a);
        if (this.e)
        {
          this.c.setVisibility(0);
          QLog.i("EmoticonTabAdapter", 1, "updateCmShowRedDot");
          return;
        }
        localObject = (IRedTouchManager)this.b.getQQAppInterface().getRuntimeService(IRedTouchManager.class, "");
        BusinessInfoCheckUpdate.AppInfo localAppInfo = ((IRedTouchManager)localObject).getAppInfoByPath("130105001");
        if (localAppInfo == null) {
          return;
        }
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("updateCmShowRedDot2 ");
        localStringBuilder.append(localAppInfo.iNewFlag.get());
        QLog.i("EmoticonTabAdapter", 1, localStringBuilder.toString());
        if (localAppInfo.iNewFlag.get() == 1)
        {
          this.c.setVisibility(0);
          ((IRedTouchManager)localObject).onRedTouchItemExposure(localAppInfo, "");
          return;
        }
        this.c.setVisibility(8);
      }
    }
  }
  
  public void a(int paramInt)
  {
    if (this.c != null)
    {
      IEmoticonMainPanelApp localIEmoticonMainPanelApp = this.b;
      if ((localIEmoticonMainPanelApp != null) && (localIEmoticonMainPanelApp.getQQAppInterface() != null))
      {
        if (this.d != paramInt) {
          return;
        }
        QLog.i("EmoticonTabAdapter", 1, "onCmShowRedDotClick");
        if (this.e) {
          b(this.a);
        }
        ((IRedTouchManager)this.b.getQQAppInterface().getRuntimeService(IRedTouchManager.class, "")).onRedTouchItemClick("130105001");
        this.c.setVisibility(8);
        ((IApolloDtReportHelper)QRoute.api(IApolloDtReportHelper.class)).report("aio", "emojicmtab", "click", new DtReportParamsBuilder().k(EmoticonPanelCmShowHelper.a()).b(Integer.valueOf(EmoticonPanelCmShowHelper.b())).a());
      }
    }
  }
  
  public void onCreateTabView(View paramView, URLImageView paramURLImageView, ImageView paramImageView, int paramInt)
  {
    this.c = paramImageView;
    this.d = paramInt;
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.emotionview.EmoticonTabCmshowListener
 * JD-Core Version:    0.7.0.1
 */