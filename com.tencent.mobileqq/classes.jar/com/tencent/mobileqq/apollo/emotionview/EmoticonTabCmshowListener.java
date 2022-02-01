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
  private int jdField_a_of_type_Int = -1;
  private Context jdField_a_of_type_AndroidContentContext;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private IEmoticonMainPanelApp jdField_a_of_type_ComTencentMobileqqEmoticonviewIEmoticonMainPanelApp;
  private boolean jdField_a_of_type_Boolean = false;
  
  public EmoticonTabCmshowListener(IEmoticonMainPanelApp paramIEmoticonMainPanelApp, Context paramContext)
  {
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewIEmoticonMainPanelApp = paramIEmoticonMainPanelApp;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public static void a(Context paramContext)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt("apollo_emoji_tab_cmshow_first_red_dot", 1);
    paramContext.commit();
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
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidWidgetImageView != null)
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqEmoticonviewIEmoticonMainPanelApp;
      if (localObject != null)
      {
        if (((IEmoticonMainPanelApp)localObject).getQQAppInterface() == null) {
          return;
        }
        this.jdField_a_of_type_Boolean = a(this.jdField_a_of_type_AndroidContentContext);
        if (this.jdField_a_of_type_Boolean)
        {
          this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
          QLog.i("EmoticonTabAdapter", 1, "updateCmShowRedDot");
          return;
        }
        localObject = (IRedTouchManager)this.jdField_a_of_type_ComTencentMobileqqEmoticonviewIEmoticonMainPanelApp.getQQAppInterface().getRuntimeService(IRedTouchManager.class, "");
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
          this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
          ((IRedTouchManager)localObject).onRedTouchItemExposure(localAppInfo, "");
          return;
        }
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      }
    }
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidWidgetImageView != null)
    {
      IEmoticonMainPanelApp localIEmoticonMainPanelApp = this.jdField_a_of_type_ComTencentMobileqqEmoticonviewIEmoticonMainPanelApp;
      if ((localIEmoticonMainPanelApp != null) && (localIEmoticonMainPanelApp.getQQAppInterface() != null))
      {
        if (this.jdField_a_of_type_Int != paramInt) {
          return;
        }
        QLog.i("EmoticonTabAdapter", 1, "onCmShowRedDotClick");
        if (this.jdField_a_of_type_Boolean) {
          a(this.jdField_a_of_type_AndroidContentContext);
        }
        ((IRedTouchManager)this.jdField_a_of_type_ComTencentMobileqqEmoticonviewIEmoticonMainPanelApp.getQQAppInterface().getRuntimeService(IRedTouchManager.class, "")).onRedTouchItemClick("130105001");
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        ((IApolloDtReportHelper)QRoute.api(IApolloDtReportHelper.class)).report("aio", "emojicmtab", "click", new DtReportParamsBuilder().h(EmoticonPanelCmShowHelper.a()).a());
      }
    }
  }
  
  public void onCreateTabView(View paramView, URLImageView paramURLImageView, ImageView paramImageView, int paramInt)
  {
    this.jdField_a_of_type_AndroidWidgetImageView = paramImageView;
    this.jdField_a_of_type_Int = paramInt;
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.emotionview.EmoticonTabCmshowListener
 * JD-Core Version:    0.7.0.1
 */