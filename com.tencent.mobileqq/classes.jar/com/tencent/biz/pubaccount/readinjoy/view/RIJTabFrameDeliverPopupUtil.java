package com.tencent.biz.pubaccount.readinjoy.view;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextPaint;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.VisibleForTesting;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.capture.ReadInJoyCaptureLauncher;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJTransMergeKanDianReport.ReportR5Builder;
import com.tencent.biz.pubaccount.readinjoy.ugc.RIJUgcUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.Frame;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.widget.PopupMenuDialog;
import com.tencent.widget.PopupMenuDialog.MenuItem;
import cooperation.readinjoy.ReadInJoyHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.jetbrains.annotations.NotNull;

public class RIJTabFrameDeliverPopupUtil
{
  private static int a(float paramFloat, Resources paramResources)
  {
    if (paramFloat == 0.0F) {
      return 0;
    }
    return (int)(paramResources.getDisplayMetrics().density * paramFloat + 0.5F);
  }
  
  @VisibleForTesting
  public static int a(@NotNull Context paramContext, List<PopupMenuDialog.MenuItem> paramList)
  {
    int i = a(125.0F, paramContext.getResources());
    TextView localTextView = new TextView(paramContext);
    localTextView.setTextSize(1, 15.0F);
    paramList = paramList.iterator();
    if (paramList.hasNext())
    {
      PopupMenuDialog.MenuItem localMenuItem = (PopupMenuDialog.MenuItem)paramList.next();
      int j = (int)Math.ceil(localTextView.getPaint().measureText(localMenuItem.jdField_a_of_type_JavaLangString)) + a(71.0F, paramContext.getResources());
      if (j <= i) {
        break label96;
      }
      i = j;
    }
    label96:
    for (;;)
    {
      break;
      return i;
    }
  }
  
  private static PopupMenuDialog.MenuItem a(int paramInt, String paramString, Drawable paramDrawable)
  {
    PopupMenuDialog.MenuItem localMenuItem = new PopupMenuDialog.MenuItem();
    localMenuItem.jdField_a_of_type_Int = paramInt;
    localMenuItem.jdField_a_of_type_JavaLangString = paramString;
    localMenuItem.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
    return localMenuItem;
  }
  
  @VisibleForTesting
  public static PopupMenuDialog a(Frame paramFrame, List<PopupMenuDialog.MenuItem> paramList, boolean paramBoolean)
  {
    int i;
    if (paramBoolean)
    {
      i = 2130843026;
      if (!paramBoolean) {
        break label57;
      }
    }
    label57:
    for (int j = 2131755033;; j = 2131755032)
    {
      return PopupMenuDialog.a(paramFrame.a(), paramList, new RIJTabFrameDeliverPopupUtil.1(paramFrame), new RIJTabFrameDeliverPopupUtil.2(), a(paramFrame.a(), paramList), false, i, j);
      i = 2130839659;
      break;
    }
  }
  
  @VisibleForTesting
  public static List<PopupMenuDialog.MenuItem> a(Frame paramFrame)
  {
    ArrayList localArrayList = new ArrayList();
    a(paramFrame, ReadInJoyHelper.n(paramFrame.a), localArrayList);
    if (localArrayList.size() == 0) {
      a(paramFrame, 31, localArrayList);
    }
    return localArrayList;
  }
  
  public static void a()
  {
    a("0X800AC6C", 0);
  }
  
  private static void a(Frame paramFrame, int paramInt, List<PopupMenuDialog.MenuItem> paramList)
  {
    Drawable localDrawable;
    if (RIJUgcUtils.g())
    {
      localDrawable = paramFrame.a().getDrawable(2130843045).mutate();
      if (ThemeUtil.isInNightMode(paramFrame.a)) {
        localDrawable.setColorFilter(-1, PorterDuff.Mode.SRC_ATOP);
      }
      paramList.add(a(0, RIJUgcUtils.a(BaseApplicationImpl.getContext()), localDrawable));
    }
    if (RIJUgcUtils.a(paramInt))
    {
      localDrawable = paramFrame.a().getDrawable(2130843046).mutate();
      if (ThemeUtil.isInNightMode(paramFrame.a)) {
        localDrawable.setColorFilter(-1, PorterDuff.Mode.SRC_ATOP);
      }
      paramList.add(a(1, BaseApplicationImpl.getApplication().getString(2131718218), localDrawable));
    }
    if (RIJUgcUtils.h())
    {
      localDrawable = paramFrame.a().getDrawable(2130843242).mutate();
      if (ThemeUtil.isInNightMode(paramFrame.a)) {
        localDrawable.setColorFilter(-1, PorterDuff.Mode.SRC_ATOP);
      }
      paramList.add(a(2, RIJUgcUtils.b(BaseApplicationImpl.getContext()), localDrawable));
    }
    if (RIJUgcUtils.i())
    {
      localDrawable = paramFrame.a().getDrawable(2130843245).mutate();
      if (ThemeUtil.isInNightMode(paramFrame.a)) {
        localDrawable.setColorFilter(-1, PorterDuff.Mode.SRC_ATOP);
      }
      paramList.add(a(3, RIJUgcUtils.c(BaseApplicationImpl.getContext()), localDrawable));
    }
  }
  
  public static void a(Frame paramFrame, View paramView, boolean paramBoolean)
  {
    a(paramFrame, a(paramFrame), paramBoolean).showAsDropDown(paramView, paramView.getWidth() - paramFrame.a().getResources().getDimensionPixelSize(2131298898) - paramFrame.a().getResources().getDimensionPixelSize(2131298894) + a(40.0F, paramFrame.a().getResources()), paramFrame.a().getResources().getDimensionPixelSize(2131298219));
    a();
  }
  
  public static void a(String paramString, int paramInt)
  {
    int j = 0;
    Object localObject = new RIJTransMergeKanDianReport.ReportR5Builder();
    if (RIJUgcUtils.i()) {}
    for (int i = 1;; i = 0)
    {
      RIJTransMergeKanDianReport.ReportR5Builder localReportR5Builder = ((RIJTransMergeKanDianReport.ReportR5Builder)localObject).a("ugc_video_flag", Integer.valueOf(i));
      i = j;
      if (RIJUgcUtils.h()) {
        i = 1;
      }
      localReportR5Builder.a("ugc_column_flag", Integer.valueOf(i)).a("publisher_type", Integer.valueOf(1));
      if (paramInt != 0) {
        ((RIJTransMergeKanDianReport.ReportR5Builder)localObject).a("from", Integer.valueOf(paramInt));
      }
      localObject = ((RIJTransMergeKanDianReport.ReportR5Builder)localObject).a();
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountSimpleReportWithR5(paramString, (String)localObject);
      return;
    }
  }
  
  private static void b(Context paramContext)
  {
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("is_from_kan_dian", true);
    ReadInJoyCaptureLauncher.a(paramContext, localBundle);
    ((Activity)paramContext).overridePendingTransition(2130772253, 2130772045);
  }
  
  private static void c()
  {
    a("0X800AC6E", 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.RIJTabFrameDeliverPopupUtil
 * JD-Core Version:    0.7.0.1
 */