package com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.ugc;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.tencent.biz.pubaccount.VideoReporter;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.capture.ReadInJoyCaptureLauncher;
import com.tencent.biz.pubaccount.readinjoy.decoupling.accesslayer.util.RIJQQAppInterfaceUtil;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.push.RIJKanDianFolderStatus;
import com.tencent.biz.pubaccount.readinjoy.ugc.KandianVideoUploadService;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.PopupMenuDialog;
import com.tencent.widget.PopupMenuDialog.MenuItem;
import cooperation.readinjoy.ReadInJoyHelper;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;
import org.json.JSONException;
import org.json.JSONObject;

public class RIJUGCDianDian
{
  public static int a()
  {
    return KandianVideoUploadService.a();
  }
  
  public static void a(int paramInt, List<PopupMenuDialog.MenuItem> paramList)
  {
    PopupMenuDialog.MenuItem localMenuItem;
    if ((paramInt & 0x1) != 0)
    {
      localMenuItem = new PopupMenuDialog.MenuItem();
      localMenuItem.jdField_a_of_type_Int = 0;
      localMenuItem.jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getString(2131718214);
      localMenuItem.b = 2130843045;
      paramList.add(localMenuItem);
    }
    if ((paramInt & 0x2) != 0)
    {
      localMenuItem = new PopupMenuDialog.MenuItem();
      localMenuItem.jdField_a_of_type_Int = 1;
      localMenuItem.jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getString(2131718218);
      localMenuItem.b = 2130843046;
      paramList.add(localMenuItem);
    }
  }
  
  public static void a(BaseActivity paramBaseActivity, View paramView)
  {
    StatisticCollector.getInstance(paramBaseActivity).collectPerformance(RIJQQAppInterfaceUtil.a(), "actReadInJoyDDShowPopupMenu", true, 0L, 0L, null, "");
    ArrayList localArrayList = new ArrayList();
    a(ReadInJoyHelper.m(RIJQQAppInterfaceUtil.a()), localArrayList);
    if (localArrayList.size() == 0) {
      a(31, localArrayList);
    }
    PopupMenuDialog.a(paramBaseActivity, localArrayList, new RIJUGCDianDian.1(paramBaseActivity), new RIJUGCDianDian.2(), AIOUtils.a(125.0F, paramBaseActivity.getResources()), false, 2130843026, 2131755033).showAsDropDown(paramView);
  }
  
  public static void a(String paramString1, String paramString2)
  {
    String str = "";
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("folder_status", RIJKanDianFolderStatus.jdField_a_of_type_Int);
      localJSONObject.put("releasetype", paramString2);
      localJSONObject.put("tab_source", paramString1);
      localJSONObject.put("kandian_mode_new", VideoReporter.a());
      paramString1 = localJSONObject.toString();
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8008C5D", "0X8008C5D", 0, 0, "", "", "", paramString1, false);
      return;
    }
    catch (JSONException paramString2)
    {
      for (;;)
      {
        paramString1 = str;
        if (QLog.isColorLevel())
        {
          QLog.e("RIJUGCDianDian", 2, "secondClassDeliverOperationReport:" + paramString2.toString());
          paramString1 = str;
        }
      }
    }
  }
  
  public static boolean a()
  {
    boolean bool = false;
    if (ReadInJoyHelper.m(RIJQQAppInterfaceUtil.a()) != 0) {
      bool = true;
    }
    return bool;
  }
  
  private static void b(Context paramContext)
  {
    c(paramContext);
    StatisticCollector.getInstance(paramContext).collectPerformance(RIJQQAppInterfaceUtil.a().getAccount(), "actReadInJoyDDShowVideoAS", true, 0L, 0L, null, "");
  }
  
  private static void c(Context paramContext)
  {
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("is_from_dian_dian", true);
    ReadInJoyCaptureLauncher.a(paramContext, localBundle);
    ((Activity)paramContext).overridePendingTransition(2130772253, 2130772045);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.ugc.RIJUGCDianDian
 * JD-Core Version:    0.7.0.1
 */