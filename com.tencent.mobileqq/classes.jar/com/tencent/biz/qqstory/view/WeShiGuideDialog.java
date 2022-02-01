package com.tencent.biz.qqstory.view;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.utils.WeishiGuideUtils;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.video.api.IVideoFeedsWeiShiUtils;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.api.IVideoReporter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import org.json.JSONException;
import org.json.JSONObject;

public class WeShiGuideDialog
  extends ReportDialog
  implements View.OnClickListener
{
  protected int a;
  private Context jdField_a_of_type_AndroidContentContext;
  private View jdField_a_of_type_AndroidViewView;
  protected Button a;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private WeShiGuideDialog.OnWsDialogDismissListener jdField_a_of_type_ComTencentBizQqstoryViewWeShiGuideDialog$OnWsDialogDismissListener;
  protected String a;
  protected boolean a;
  private String b;
  private String c = "";
  private String d = "";
  private String e = "";
  private String f = null;
  private String g;
  
  public WeShiGuideDialog(@NonNull Context paramContext, int paramInt, String paramString)
  {
    super(paramContext, paramInt);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.g = paramString;
  }
  
  public WeShiGuideDialog(@NonNull Context paramContext, String paramString)
  {
    this(paramContext, 2131756189, paramString);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public static Dialog a(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt, String paramString4)
  {
    if (WeishiGuideUtils.a(paramContext))
    {
      WeishiGuideUtils.a(paramContext, "biz_src_jc_hyws", paramString4);
      return null;
    }
    paramContext = new WeShiGuideDialog(paramContext, "biz_src_jc_hyws").a(paramString1, paramString2, paramString3).a(paramInt, paramString4);
    paramContext.show();
    return paramContext;
  }
  
  private void a(int paramInt)
  {
    WeShiGuideDialog.OnWsDialogDismissListener localOnWsDialogDismissListener = this.jdField_a_of_type_ComTencentBizQqstoryViewWeShiGuideDialog$OnWsDialogDismissListener;
    if (localOnWsDialogDismissListener != null) {
      localOnWsDialogDismissListener.a(this, paramInt);
    }
  }
  
  private void b()
  {
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131363914));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131369319));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131370231);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379760));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetButton.setText(HardCodeUtil.a(2131716410));
    a();
    if (TextUtils.isEmpty(this.b)) {
      this.b = "https://pub.idqqimg.com/pc/misc/files/20180423/03d546703c3f49a3857c67be2e94f928.png";
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    Object localObject = URLDrawable.URLDrawableOptions.obtain();
    ColorDrawable localColorDrawable = new ColorDrawable(-16777216);
    ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = localColorDrawable;
    ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = localColorDrawable;
    localObject = URLDrawable.getDrawable(this.b, (URLDrawable.URLDrawableOptions)localObject);
    ((URLDrawable)localObject).setURLDrawableListener(new WeShiGuideDialog.WeakViewDownloadListener(this.jdField_a_of_type_AndroidWidgetTextView));
    this.jdField_a_of_type_AndroidViewView.setBackgroundDrawable((Drawable)localObject);
    int i = ((URLDrawable)localObject).getStatus();
    if (i != 1)
    {
      if (i == 2) {
        ((URLDrawable)localObject).restartDownload();
      }
    }
    else {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    }
  }
  
  public WeShiGuideDialog a(int paramInt, String paramString)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString;
    return this;
  }
  
  public WeShiGuideDialog a(String paramString)
  {
    this.b = paramString;
    return this;
  }
  
  public WeShiGuideDialog a(String paramString1, String paramString2, String paramString3)
  {
    this.c = paramString1;
    this.d = paramString2;
    this.e = paramString3;
    return this;
  }
  
  public void a()
  {
    boolean bool = WeishiGuideUtils.a(getContext());
    if (this.jdField_a_of_type_Boolean != bool)
    {
      this.jdField_a_of_type_Boolean = bool;
      if (this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_AndroidWidgetButton.setText(HardCodeUtil.a(2131716411));
        return;
      }
      this.jdField_a_of_type_AndroidWidgetButton.setText(HardCodeUtil.a(2131716414));
    }
  }
  
  public void onBackPressed()
  {
    super.onBackPressed();
    a(-1);
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    int n = 1;
    Object localObject;
    int k;
    int j;
    int m;
    JSONObject localJSONObject;
    if (i != 2131363914)
    {
      if (i == 2131369319)
      {
        dismiss();
        a(-1);
        if (TextUtils.isEmpty(this.f)) {
          StoryReportor.a("weishi_share", "cover_close", 0, 0, new String[] { this.d, this.c, "weishi", this.e });
        }
      }
    }
    else
    {
      a();
      if (TextUtils.isEmpty(this.f))
      {
        if (this.jdField_a_of_type_Boolean)
        {
          WeishiGuideUtils.a(getContext(), this.g, this.jdField_a_of_type_JavaLangString);
          i = 0;
        }
        else
        {
          QQToast.a(getContext(), HardCodeUtil.a(2131716412), 0).a();
          WeishiGuideUtils.a(getContext(), this.g);
          i = 1;
        }
        StoryReportor.a("weishi_share", "cover_clk", 0, 0, new String[] { this.d, this.c, "weishi", this.e });
      }
      else
      {
        if (this.jdField_a_of_type_Boolean)
        {
          ((IVideoFeedsWeiShiUtils)QRoute.api(IVideoFeedsWeiShiUtils.class)).openWeishi(getContext(), this.f);
          i = 0;
        }
        else
        {
          QQToast.a(getContext(), -1, HardCodeUtil.a(2131716413), 0).b(getContext().getResources().getDimensionPixelSize(2131299168));
          ((IVideoFeedsWeiShiUtils)QRoute.api(IVideoFeedsWeiShiUtils.class)).gotoWeishiDownload(getContext(), this.f);
          i = 1;
        }
        localObject = this.jdField_a_of_type_AndroidContentContext;
        if ((localObject instanceof Activity))
        {
          k = ((Activity)localObject).getIntent().getIntExtra("REPORT_VIDEO_FEEDS_JUMP_FROM", 0);
          j = ((Activity)this.jdField_a_of_type_AndroidContentContext).getIntent().getIntExtra("VIDEO_FROM_TYPE", -1);
          if ((j != 9) && (j != 12)) {
            j = 0;
          } else {
            j = 1;
          }
          m = j;
          j = k;
        }
        else
        {
          m = 0;
          j = 0;
        }
        localJSONObject = new JSONObject();
      }
    }
    for (;;)
    {
      try
      {
        if (!this.jdField_a_of_type_Boolean) {
          break label598;
        }
        localObject = "0";
        localJSONObject.put("download", localObject);
        localObject = (IVideoReporter)QRoute.api(IVideoReporter.class);
        if (m == 0) {
          break label606;
        }
        k = n;
        ((IVideoReporter)localObject).addKanDianTagForWeishiReport(localJSONObject, k);
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
      if (((IVideoFeedsWeiShiUtils)QRoute.api(IVideoFeedsWeiShiUtils.class)).isWeishi(this.f)) {
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, null, "0X80092A7", "0X80092A7", 0, 0, String.valueOf(j), "", "", ((IVideoReporter)QRoute.api(IVideoReporter.class)).videoReportBaseR5(null, null, "", "", localJSONObject), false);
      } else {
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, null, "0X80092A9", "0X80092A9", 0, 0, String.valueOf(j), "", "", ((IVideoReporter)QRoute.api(IVideoReporter.class)).videoReportBaseR5(null, null, "", "", localJSONObject), false);
      }
      dismiss();
      a(i);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label598:
      String str = "1";
      continue;
      label606:
      k = 0;
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131561837);
    b();
    setCanceledOnTouchOutside(false);
  }
  
  public void show()
  {
    super.show();
    if (TextUtils.isEmpty(this.f)) {
      StoryReportor.a("weishi_share", "cover_exp", 0, 0, new String[] { this.d, this.c, "weishi", this.e });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.view.WeShiGuideDialog
 * JD-Core Version:    0.7.0.1
 */