package com.tencent.mobileqq.ark.download;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.ark.ArkDispatchTask;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.app.Foreground;

public class ArkDownloadController
{
  private static ArkDownloadController i;
  private QQCustomDialog a = null;
  private ArrayList<ArkDownloadItem> b = new ArrayList(4);
  private ArrayList<ArkDownloadItem> c = new ArrayList(4);
  private Object d = new Object();
  private boolean e = false;
  private Runnable f = null;
  private int g = 0;
  private long h = 0L;
  
  public static ArkDownloadController a()
  {
    if (i == null) {
      try
      {
        if (i == null) {
          i = new ArkDownloadController();
        }
      }
      finally {}
    }
    return i;
  }
  
  private void a(Context paramContext, ArrayList<ArkDownloadItem> paramArrayList, LinearLayout paramLinearLayout1, LinearLayout paramLinearLayout2)
  {
    if (paramArrayList.size() <= 4) {
      paramLinearLayout2.setVisibility(8);
    }
    Drawable localDrawable = paramContext.getResources().getDrawable(2130838739);
    int j = 0;
    while (j < paramArrayList.size())
    {
      Object localObject = (ArkDownloadItem)paramArrayList.get(j);
      View localView = LayoutInflater.from(paramContext).inflate(2131624254, null, false);
      URLImageView localURLImageView = (URLImageView)localView.findViewById(2131435222);
      TextView localTextView = (TextView)localView.findViewById(2131439502);
      QLog.d("ark.download.ctrl", 1, new Object[] { "ark.dctrl [initAppView] item[", Integer.valueOf(j), "],app name:", ((ArkDownloadItem)localObject).b, ",appid:", ((ArkDownloadItem)localObject).a, ",icon:", ((ArkDownloadItem)localObject).c });
      if (j < 7)
      {
        URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        localURLDrawableOptions.mRequestWidth = AIOUtils.b(47.0F, paramContext.getResources());
        localURLDrawableOptions.mRequestHeight = localURLDrawableOptions.mRequestWidth;
        localURLDrawableOptions.mLoadingDrawable = localDrawable;
        localURLDrawableOptions.mFailedDrawable = localDrawable;
        localObject = URLDrawable.getDrawable(((ArkDownloadItem)localObject).c, localURLDrawableOptions);
        ((URLDrawable)localObject).setTargetDensity(paramContext.getResources().getDisplayMetrics().densityDpi);
        if (((URLDrawable)localObject).getStatus() == 2) {
          ((URLDrawable)localObject).restartDownload();
        }
        localURLImageView.setImageDrawable((Drawable)localObject);
        localTextView.setVisibility(8);
      }
      else
      {
        if (j != 7) {
          break;
        }
        localURLImageView.setImageDrawable(paramContext.getResources().getDrawable(2130838741));
        localTextView.setText(String.format("+%d", new Object[] { Integer.valueOf(paramArrayList.size() - 7) }));
        localTextView.setVisibility(0);
      }
      if (j < 4) {
        paramLinearLayout1.addView(localView, j);
      } else {
        paramLinearLayout2.addView(localView, j - 4);
      }
      j += 1;
    }
  }
  
  private void a(String paramString)
  {
    synchronized (this.d)
    {
      QLog.e("ark.download.ctrl", 1, new Object[] { "ark.dctrl [checkWaitQueueToShowDialog] waite size:", Integer.valueOf(this.b.size()) });
      if (this.b.size() > 0)
      {
        this.c.clear();
        this.c.addAll((ArrayList)this.b.clone());
        this.b.clear();
        b(paramString);
      }
      return;
    }
  }
  
  private void b(String paramString)
  {
    Activity localActivity = Foreground.getTopActivity();
    int j = 0;
    if ((localActivity != null) && (!localActivity.isFinishing()))
    {
      Object localObject = this.c;
      if ((localObject != null) && (((ArrayList)localObject).size() > 0))
      {
        localObject = new ArkDownloadController.2(this, paramString);
        try
        {
          this.h = System.currentTimeMillis();
          this.g = this.c.size();
          QLog.e("ark.download.ctrl", 1, new Object[] { "ark.dctrl [showDownloadDialog] arkappname:", paramString, ",showlist size:", Integer.valueOf(this.g) });
          this.a = DialogUtil.a(localActivity, 230, 2131624253, null, String.format(localActivity.getString(2131887046), new Object[] { Integer.valueOf(this.g) }), localActivity.getString(2131887648), localActivity.getString(2131887043), (DialogInterface.OnClickListener)localObject, (DialogInterface.OnClickListener)localObject);
          localObject = (LinearLayout)this.a.findViewById(2131437240);
          LinearLayout localLinearLayout = (LinearLayout)this.a.findViewById(2131437239);
          a(localActivity, this.c, (LinearLayout)localObject, localLinearLayout);
          this.a.setOnDismissListener(new ArkDownloadController.3(this));
          this.a.show();
          ReportController.a(null, "dc00898", "", "", "0X800AD1C", "0X800AD1C", 3, 0, String.valueOf(this.g), "", paramString, "");
          return;
        }
        catch (Exception paramString)
        {
          QLog.e("ark.download.ctrl", 1, "ark.dctrl [showDownloadDialog] exception:", paramString);
          return;
        }
      }
    }
    paramString = this.c;
    if (paramString != null) {
      j = paramString.size();
    }
    QLog.e("ark.download.ctrl", 1, new Object[] { "ark.dctrl [showDownloadDialog] error,showlist size:", Integer.valueOf(j) });
  }
  
  public void a(String paramString1, String arg2, String paramString3, String paramString4, DialogInterface.OnClickListener paramOnClickListener)
  {
    int j = this.b.size();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("], app:");
    ((StringBuilder)localObject).append(paramString3);
    ((StringBuilder)localObject).append(",iconUrl:");
    ((StringBuilder)localObject).append(paramString4);
    QLog.d("ark.download.ctrl", 1, new Object[] { "ark.dctrl [showDownloadPermissionDialog] arkAppName:", paramString1, ", queue size[", Integer.valueOf(j), ((StringBuilder)localObject).toString() });
    localObject = new ArkDownloadItem();
    ((ArkDownloadItem)localObject).a = ???;
    ((ArkDownloadItem)localObject).c = paramString4;
    ((ArkDownloadItem)localObject).b = paramString3;
    ((ArkDownloadItem)localObject).d = paramOnClickListener;
    synchronized (this.d)
    {
      this.b.add(localObject);
      if (!this.e)
      {
        this.e = true;
        this.f = new ArkDownloadController.1(this, paramString1);
        ArkDispatchTask.getInstance().postToMainThreadDelayed(this.f, 150L);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.download.ArkDownloadController
 * JD-Core Version:    0.7.0.1
 */