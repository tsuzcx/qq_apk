package com.tencent.biz.qqcircle.launcher.parser;

import android.content.Context;
import com.tencent.biz.qqcircle.beans.QCircleFolderBean;
import com.tencent.biz.qqcircle.launcher.QCircleLauncher;
import com.tencent.biz.qqcircle.richframework.util.FastClickUtils;
import com.tencent.mobileqq.qcircle.api.constant.QCirclePeriodCollect;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.beans.QCircleSchemeBean;
import cooperation.qqcircle.report.QCircleReportHelper;
import java.util.HashMap;

public class QCircleFolderSchemeParser
  extends QCircleBaseSchemeParser
{
  private void a(QCircleFolderBean paramQCircleFolderBean, HashMap<String, String> paramHashMap)
  {
    if ((paramQCircleFolderBean != null) && (paramHashMap != null))
    {
      if (paramHashMap.containsKey("key_assign_show_tab_type")) {
        try
        {
          paramQCircleFolderBean.setAssignShowTabType(Integer.parseInt((String)paramHashMap.get("key_assign_show_tab_type")));
          return;
        }
        catch (Exception paramQCircleFolderBean)
        {
          paramHashMap = new StringBuilder();
          paramHashMap.append("parseInt error!");
          paramHashMap.append(paramQCircleFolderBean.toString());
          QLog.e("QCircleBaseSchemeParser", 1, paramHashMap.toString());
          return;
        }
      }
      if (paramHashMap.containsKey("tabtype")) {
        try
        {
          paramQCircleFolderBean.setAssignShowTabType(Integer.parseInt((String)paramHashMap.get("tabtype")));
          return;
        }
        catch (Exception paramQCircleFolderBean)
        {
          paramHashMap = new StringBuilder();
          paramHashMap.append("parseInt error!");
          paramHashMap.append(paramQCircleFolderBean.toString());
          QLog.e("QCircleBaseSchemeParser", 1, paramHashMap.toString());
        }
      }
      return;
    }
    QLog.e("QCircleBaseSchemeParser", 1, "parseAssignShowTabTypeParam failed!");
  }
  
  private void a(HashMap<String, String> paramHashMap, HashMap<String, byte[]> paramHashMap1, QCircleFolderBean paramQCircleFolderBean)
  {
    String str;
    if (paramHashMap.containsKey("uin"))
    {
      str = (String)paramHashMap.get("uin");
      QCircleReportHelper.getInstance().setInviteUin(str);
      paramQCircleFolderBean.setUin(str);
    }
    if (paramHashMap.containsKey("invite_id"))
    {
      str = (String)paramHashMap.get("invite_id");
      QCircleReportHelper.getInstance().setInviteId(str);
      paramQCircleFolderBean.mInviteUin = str;
    }
    else
    {
      QCircleReportHelper.getInstance().setInviteId(null);
    }
    if (paramHashMap.containsKey("key_is_publish"))
    {
      int i = Integer.parseInt((String)paramHashMap.get("key_is_publish"));
      boolean bool = true;
      if (i != 1) {
        bool = false;
      }
      paramQCircleFolderBean.setPublish(bool);
    }
    if (paramHashMap.containsKey("key_show_active_red_dot")) {
      paramQCircleFolderBean.setHasRedDot(Boolean.parseBoolean((String)paramHashMap.get("key_show_active_red_dot")));
    }
    if (paramHashMap.containsKey("key_unread_red_num")) {
      paramQCircleFolderBean.setUnreadRedNum(Integer.parseInt((String)paramHashMap.get("key_unread_red_num")));
    }
    if ((paramHashMap1 != null) && (paramHashMap1.containsKey("key_red_dot_trans_info"))) {
      paramQCircleFolderBean.setRedDotTransInfo((byte[])paramHashMap1.get("key_red_dot_trans_info"));
    }
  }
  
  private void b(Context paramContext, QCircleSchemeBean paramQCircleSchemeBean)
  {
    if (FastClickUtils.a("QCircleBaseSchemeParser_launchFolderPageBySchema", 500L)) {
      return;
    }
    QCirclePeriodCollect.record("plugin_loaded");
    HashMap localHashMap = paramQCircleSchemeBean.getAttrs();
    if (localHashMap == null) {
      return;
    }
    QCircleFolderBean localQCircleFolderBean = new QCircleFolderBean();
    a(paramQCircleSchemeBean, localQCircleFolderBean);
    a(localQCircleFolderBean, localHashMap);
    a(localQCircleFolderBean, localHashMap);
    b(localQCircleFolderBean, localHashMap);
    a(localHashMap, paramQCircleSchemeBean.getByteAttrs(), localQCircleFolderBean);
    if ("openpymk".equals(paramQCircleSchemeBean.getSchemeAction()))
    {
      localQCircleFolderBean.setOpenPymk(true);
      b(localQCircleFolderBean, localHashMap);
    }
    else
    {
      localQCircleFolderBean.setOpenPymk(false);
    }
    localQCircleFolderBean.setEnterTime(paramQCircleSchemeBean.getEnterTime());
    QCircleLauncher.a(paramContext, localQCircleFolderBean);
  }
  
  private void b(QCircleFolderBean paramQCircleFolderBean, HashMap<String, String> paramHashMap)
  {
    paramQCircleFolderBean.setPymkTranferData((String)paramHashMap.get("transdata"));
    try
    {
      paramQCircleFolderBean.setPymkJumpType(Integer.parseInt((String)paramHashMap.get("type")));
      return;
    }
    catch (Exception paramQCircleFolderBean)
    {
      paramQCircleFolderBean.printStackTrace();
    }
  }
  
  public void a(Context paramContext, QCircleSchemeBean paramQCircleSchemeBean)
  {
    b(paramContext, paramQCircleSchemeBean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.launcher.parser.QCircleFolderSchemeParser
 * JD-Core Version:    0.7.0.1
 */