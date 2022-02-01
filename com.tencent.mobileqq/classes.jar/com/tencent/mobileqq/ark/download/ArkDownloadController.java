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
  private static ArkDownloadController jdField_a_of_type_ComTencentMobileqqArkDownloadArkDownloadController;
  private int jdField_a_of_type_Int = 0;
  private long jdField_a_of_type_Long = 0L;
  private QQCustomDialog jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private Runnable jdField_a_of_type_JavaLangRunnable = null;
  private ArrayList<ArkDownloadItem> jdField_a_of_type_JavaUtilArrayList = new ArrayList(4);
  private boolean jdField_a_of_type_Boolean = false;
  private ArrayList<ArkDownloadItem> b = new ArrayList(4);
  
  public static ArkDownloadController a()
  {
    if (jdField_a_of_type_ComTencentMobileqqArkDownloadArkDownloadController == null) {
      try
      {
        if (jdField_a_of_type_ComTencentMobileqqArkDownloadArkDownloadController == null) {
          jdField_a_of_type_ComTencentMobileqqArkDownloadArkDownloadController = new ArkDownloadController();
        }
      }
      finally {}
    }
    return jdField_a_of_type_ComTencentMobileqqArkDownloadArkDownloadController;
  }
  
  private void a(Context paramContext, ArrayList<ArkDownloadItem> paramArrayList, LinearLayout paramLinearLayout1, LinearLayout paramLinearLayout2)
  {
    if (paramArrayList.size() <= 4) {
      paramLinearLayout2.setVisibility(8);
    }
    Drawable localDrawable = paramContext.getResources().getDrawable(2130838614);
    int i = 0;
    while (i < paramArrayList.size())
    {
      Object localObject = (ArkDownloadItem)paramArrayList.get(i);
      View localView = LayoutInflater.from(paramContext).inflate(2131558639, null, false);
      URLImageView localURLImageView = (URLImageView)localView.findViewById(2131368345);
      TextView localTextView = (TextView)localView.findViewById(2131372039);
      QLog.d("ark.download.ctrl", 1, new Object[] { "ark.dctrl [initAppView] item[", Integer.valueOf(i), "],app name:", ((ArkDownloadItem)localObject).b, ",appid:", ((ArkDownloadItem)localObject).jdField_a_of_type_JavaLangString, ",icon:", ((ArkDownloadItem)localObject).c });
      if (i < 7)
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
        if (i != 7) {
          break;
        }
        localURLImageView.setImageDrawable(paramContext.getResources().getDrawable(2130838616));
        localTextView.setText(String.format("+%d", new Object[] { Integer.valueOf(paramArrayList.size() - 7) }));
        localTextView.setVisibility(0);
      }
      if (i < 4) {
        paramLinearLayout1.addView(localView, i);
      } else {
        paramLinearLayout2.addView(localView, i - 4);
      }
      i += 1;
    }
  }
  
  private void a(String paramString)
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      QLog.e("ark.download.ctrl", 1, new Object[] { "ark.dctrl [checkWaitQueueToShowDialog] waite size:", Integer.valueOf(this.jdField_a_of_type_JavaUtilArrayList.size()) });
      if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)
      {
        this.b.clear();
        this.b.addAll((ArrayList)this.jdField_a_of_type_JavaUtilArrayList.clone());
        this.jdField_a_of_type_JavaUtilArrayList.clear();
        b(paramString);
      }
      return;
    }
  }
  
  private void b(String paramString)
  {
    Activity localActivity = Foreground.getTopActivity();
    int i = 0;
    if ((localActivity != null) && (!localActivity.isFinishing()))
    {
      Object localObject = this.b;
      if ((localObject != null) && (((ArrayList)localObject).size() > 0))
      {
        localObject = new ArkDownloadController.2(this, paramString);
        try
        {
          this.jdField_a_of_type_Long = System.currentTimeMillis();
          this.jdField_a_of_type_Int = this.b.size();
          QLog.e("ark.download.ctrl", 1, new Object[] { "ark.dctrl [showDownloadDialog] arkappname:", paramString, ",showlist size:", Integer.valueOf(this.jdField_a_of_type_Int) });
          this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(localActivity, 230, 2131558638, null, String.format(localActivity.getString(2131690147), new Object[] { Integer.valueOf(this.jdField_a_of_type_Int) }), localActivity.getString(2131690728), localActivity.getString(2131690144), (DialogInterface.OnClickListener)localObject, (DialogInterface.OnClickListener)localObject);
          localObject = (LinearLayout)this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.findViewById(2131370078);
          LinearLayout localLinearLayout = (LinearLayout)this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.findViewById(2131370077);
          a(localActivity, this.b, (LinearLayout)localObject, localLinearLayout);
          this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setOnDismissListener(new ArkDownloadController.3(this));
          this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
          ReportController.a(null, "dc00898", "", "", "0X800AD1C", "0X800AD1C", 3, 0, String.valueOf(this.jdField_a_of_type_Int), "", paramString, "");
          return;
        }
        catch (Exception paramString)
        {
          QLog.e("ark.download.ctrl", 1, "ark.dctrl [showDownloadDialog] exception:", paramString);
          return;
        }
      }
    }
    paramString = this.b;
    if (paramString != null) {
      i = paramString.size();
    }
    QLog.e("ark.download.ctrl", 1, new Object[] { "ark.dctrl [showDownloadDialog] error,showlist size:", Integer.valueOf(i) });
  }
  
  public void a(String paramString1, String arg2, String paramString3, String paramString4, DialogInterface.OnClickListener paramOnClickListener)
  {
    int i = this.jdField_a_of_type_JavaUtilArrayList.size();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("], app:");
    ((StringBuilder)localObject).append(paramString3);
    ((StringBuilder)localObject).append(",iconUrl:");
    ((StringBuilder)localObject).append(paramString4);
    QLog.d("ark.download.ctrl", 1, new Object[] { "ark.dctrl [showDownloadPermissionDialog] arkAppName:", paramString1, ", queue size[", Integer.valueOf(i), ((StringBuilder)localObject).toString() });
    localObject = new ArkDownloadItem();
    ((ArkDownloadItem)localObject).jdField_a_of_type_JavaLangString = ???;
    ((ArkDownloadItem)localObject).c = paramString4;
    ((ArkDownloadItem)localObject).b = paramString3;
    ((ArkDownloadItem)localObject).jdField_a_of_type_AndroidContentDialogInterface$OnClickListener = paramOnClickListener;
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_JavaUtilArrayList.add(localObject);
      if (!this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_Boolean = true;
        this.jdField_a_of_type_JavaLangRunnable = new ArkDownloadController.1(this, paramString1);
        ArkDispatchTask.getInstance().postToMainThreadDelayed(this.jdField_a_of_type_JavaLangRunnable, 150L);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ark.download.ArkDownloadController
 * JD-Core Version:    0.7.0.1
 */