package com.tencent.biz.qqcircle.bizparts;

import android.app.Dialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.biz.qqcircle.QCirclePluginConfig;
import com.tencent.biz.qqcircle.QCirclePluginGlobalInfo;
import com.tencent.biz.qqcircle.debug.mocklbs.data.MockLbsInfo;
import com.tencent.biz.qqcircle.richframework.widget.actionsheet.ActionSheet;
import com.tencent.biz.richframework.config.RFWCommonConfig;
import com.tencent.qcircle.cooperation.config.QCircleSpUtil;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import cooperation.qzone.LocalMultiProcConfig;

public class QCirclePluginDebugPart
  extends QCircleBasePart
{
  private void a(SharedPreferences paramSharedPreferences, ActionSheet paramActionSheet)
  {
    if (paramSharedPreferences.getBoolean("SP_KEY_IS_BLOCK_CHECK_OPEN", false))
    {
      paramActionSheet.b(2131895665);
      return;
    }
    paramActionSheet.b(2131895673);
  }
  
  private void a(SharedPreferences paramSharedPreferences, boolean paramBoolean)
  {
    if (paramSharedPreferences == null) {
      return;
    }
    paramSharedPreferences = paramSharedPreferences.edit();
    paramSharedPreferences.putBoolean("qcircle_show_stick_draw_rect", paramBoolean);
    paramSharedPreferences.apply();
  }
  
  private void a(ActionSheet paramActionSheet)
  {
    if (LocalMultiProcConfig.getBool("SP_KEY_IS_PUBLISH_MATERIAL_TEST_OPEN", false))
    {
      paramActionSheet.b(2131895669);
      return;
    }
    paramActionSheet.b(2131895676);
  }
  
  private void b(SharedPreferences paramSharedPreferences, ActionSheet paramActionSheet)
  {
    if (paramSharedPreferences.getBoolean("qcircle_force_enable_floatlayer_flutter", false))
    {
      paramActionSheet.b(2131895686);
      return;
    }
    paramActionSheet.b(2131895674);
  }
  
  private void b(ActionSheet paramActionSheet)
  {
    int i = 0;
    if (((Integer)QCircleSpUtil.b("QFSFeedChildDebugInfoPresenter", Integer.valueOf(0))).intValue() == 1) {
      i = 1;
    }
    if (i != 0) {
      i = 2131896223;
    } else {
      i = 2131896238;
    }
    paramActionSheet.b(i);
  }
  
  private void c(SharedPreferences paramSharedPreferences, ActionSheet paramActionSheet)
  {
    if (paramSharedPreferences.getBoolean("SP_KEY_OPEN_NEW_LAYER", true))
    {
      paramActionSheet.b(g().getResources().getString(2131895666));
      return;
    }
    paramActionSheet.b(g().getResources().getString(2131895678));
  }
  
  private void d(SharedPreferences paramSharedPreferences, ActionSheet paramActionSheet)
  {
    if (paramSharedPreferences.getBoolean("SP_KEY_OPEN_NEW_PUBLISH", false))
    {
      paramActionSheet.b(g().getResources().getString(2131895668));
      return;
    }
    paramActionSheet.b(g().getResources().getString(2131895679));
  }
  
  private void e(SharedPreferences paramSharedPreferences, ActionSheet paramActionSheet)
  {
    if (LocalMultiProcConfig.getBool("SP_KEY_OPEN_IMAGE_EDIT_MODE", false))
    {
      paramActionSheet.b(g().getResources().getString(2131895672));
      return;
    }
    paramActionSheet.b(g().getResources().getString(2131895671));
  }
  
  private void f(SharedPreferences paramSharedPreferences, ActionSheet paramActionSheet)
  {
    if (paramSharedPreferences.getBoolean("qcircle_show_stick_draw_rect", false))
    {
      paramActionSheet.b("取消贴纸范围显示");
      return;
    }
    paramActionSheet.b("显示贴纸范围");
  }
  
  private void g(SharedPreferences paramSharedPreferences, ActionSheet paramActionSheet)
  {
    if (paramSharedPreferences.getBoolean("SP_KEY_OPEN_RE_RANK", false))
    {
      paramActionSheet.b(2131895670);
      return;
    }
    paramActionSheet.b(2131895677);
  }
  
  private void h(SharedPreferences paramSharedPreferences, ActionSheet paramActionSheet)
  {
    if (paramSharedPreferences.getBoolean("SP_KEY_GLOBAL_FEED_CENTER", true))
    {
      paramActionSheet.b(2131895667);
      return;
    }
    paramActionSheet.b(2131895675);
  }
  
  private void i()
  {
    ReportDialog localReportDialog = new ReportDialog(g(), 2131952183);
    localReportDialog.setCanceledOnTouchOutside(false);
    localReportDialog.setContentView(2131626958);
    ((TextView)localReportDialog.findViewById(2131447059)).setOnClickListener(new QCirclePluginDebugPart.2(this, (EditText)localReportDialog.findViewById(2131447134), localReportDialog));
    localReportDialog.show();
  }
  
  public String a()
  {
    return "QCirclePluginDebugPart";
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
  }
  
  public void a(String paramString, Object paramObject)
  {
    super.a(paramString, paramObject);
    if ("SHOW_DEBUG_INFO".equals(paramString))
    {
      paramObject = QCirclePluginConfig.b();
      ActionSheet localActionSheet = ActionSheet.a(g());
      paramString = RFWCommonConfig.b();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(g().getResources().getString(2131895683));
      localStringBuilder.append(" （");
      localStringBuilder.append(paramString);
      localStringBuilder.append("）");
      localActionSheet.b(localStringBuilder.toString());
      if (QCirclePluginGlobalInfo.j() != null) {
        paramString = QCirclePluginGlobalInfo.j().district;
      } else {
        paramString = "当前所在地";
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(g().getResources().getString(2131895682));
      localStringBuilder.append(" （");
      localStringBuilder.append(paramString);
      localStringBuilder.append("）");
      localActionSheet.b(localStringBuilder.toString());
      localActionSheet.b(2131895687);
      localActionSheet.b(2131895644);
      b(paramObject, localActionSheet);
      c(paramObject, localActionSheet);
      d(paramObject, localActionSheet);
      e(paramObject, localActionSheet);
      a(paramObject, localActionSheet);
      f(paramObject, localActionSheet);
      a(localActionSheet);
      g(paramObject, localActionSheet);
      h(paramObject, localActionSheet);
      b(localActionSheet);
      localActionSheet.b(g().getString(2131895901));
      localActionSheet.b(2131887648);
      localActionSheet.a(new QCirclePluginDebugPart.1(this, localActionSheet, paramObject));
      localActionSheet.show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.QCirclePluginDebugPart
 * JD-Core Version:    0.7.0.1
 */