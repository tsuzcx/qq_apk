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
import com.tencent.biz.pubaccount.PublicAccountReportUtils;
import com.tencent.biz.pubaccount.VideoReporter;
import com.tencent.biz.pubaccount.util.VideoFeedsWeiShiUtils;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.utils.WeishiGuideUtils;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.widget.QQToast;
import org.json.JSONException;
import org.json.JSONObject;

public class WeShiGuideDialog
  extends Dialog
  implements View.OnClickListener
{
  private Context jdField_a_of_type_AndroidContentContext;
  private View jdField_a_of_type_AndroidViewView;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private String b = "";
  private String c = "";
  private String d = "";
  private String e;
  
  public WeShiGuideDialog(@NonNull Context paramContext)
  {
    this(paramContext, 2131624515);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public WeShiGuideDialog(@NonNull Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public static Dialog a(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    if (WeishiGuideUtils.a(paramContext))
    {
      WeishiGuideUtils.a(paramContext);
      return null;
    }
    paramContext = new WeShiGuideDialog(paramContext).a(paramString1, paramString2, paramString3);
    paramContext.show();
    return paramContext;
  }
  
  private void b()
  {
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131371999));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131363197));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131371997);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131371998));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetButton.setText("下载微视");
    a();
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      this.jdField_a_of_type_JavaLangString = "https://pub.idqqimg.com/pc/misc/files/20180423/03d546703c3f49a3857c67be2e94f928.png";
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    Object localObject = URLDrawable.URLDrawableOptions.obtain();
    ColorDrawable localColorDrawable = new ColorDrawable(-16777216);
    ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = localColorDrawable;
    ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = localColorDrawable;
    localObject = URLDrawable.getDrawable(this.jdField_a_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject);
    ((URLDrawable)localObject).setURLDrawableListener(new WeShiGuideDialog.WeakViewDownloadListener(this.jdField_a_of_type_AndroidWidgetTextView));
    this.jdField_a_of_type_AndroidViewView.setBackgroundDrawable((Drawable)localObject);
    int i = ((URLDrawable)localObject).getStatus();
    if (i != 1)
    {
      if (i == 2) {
        ((URLDrawable)localObject).restartDownload();
      }
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  public WeShiGuideDialog a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    return this;
  }
  
  public WeShiGuideDialog a(String paramString1, String paramString2, String paramString3)
  {
    this.b = paramString1;
    this.c = paramString2;
    this.d = paramString3;
    return this;
  }
  
  public void a()
  {
    boolean bool = WeishiGuideUtils.a(getContext());
    if (this.jdField_a_of_type_Boolean != bool)
    {
      this.jdField_a_of_type_Boolean = bool;
      if (this.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_AndroidWidgetButton.setText("打开微视");
      }
    }
    else
    {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetButton.setText("下载微视");
  }
  
  public WeShiGuideDialog b(String paramString)
  {
    this.e = paramString;
    return this;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131371999: 
      a();
      if (TextUtils.isEmpty(this.e))
      {
        if (this.jdField_a_of_type_Boolean) {
          WeishiGuideUtils.a(getContext());
        }
        for (;;)
        {
          StoryReportor.a("weishi_share", "cover_clk", 0, 0, new String[] { this.c, this.b, "weishi", this.d });
          label100:
          dismiss();
          return;
          QQToast.a(getContext(), "正在下载，请稍候。", 0).a();
          WeishiGuideUtils.b(getContext());
        }
      }
      if (this.jdField_a_of_type_Boolean)
      {
        VideoFeedsWeiShiUtils.a(getContext(), this.e);
        label147:
        if (!(this.jdField_a_of_type_AndroidContentContext instanceof Activity)) {
          break label392;
        }
      }
      break;
    }
    label392:
    for (int i = ((Activity)this.jdField_a_of_type_AndroidContentContext).getIntent().getIntExtra("REPORT_VIDEO_FEEDS_JUMP_FROM", 0);; i = 0)
    {
      JSONObject localJSONObject = new JSONObject();
      for (;;)
      {
        try
        {
          if (!this.jdField_a_of_type_Boolean) {
            continue;
          }
          paramView = "0";
          localJSONObject.put("download", paramView);
        }
        catch (JSONException paramView)
        {
          paramView.printStackTrace();
          continue;
          PublicAccountReportUtils.a(null, null, "0X80092A9", "0X80092A9", 0, 0, String.valueOf(i), "", "", VideoReporter.a(null, null, "", "", localJSONObject), false);
        }
        if (!"video_type_videopublic".equals(this.e)) {
          continue;
        }
        PublicAccountReportUtils.a(null, null, "0X80092A7", "0X80092A7", 0, 0, String.valueOf(i), "", "", VideoReporter.a(null, null, "", "", localJSONObject), false);
        break;
        QQToast.a(getContext(), -1, "正在下载，请稍候。", 0).b(getContext().getResources().getDimensionPixelSize(2131558448));
        VideoFeedsWeiShiUtils.b(getContext(), this.e);
        break label147;
        paramView = "1";
      }
      break label100;
      dismiss();
      if (!TextUtils.isEmpty(this.e)) {
        break;
      }
      StoryReportor.a("weishi_share", "cover_close", 0, 0, new String[] { this.c, this.b, "weishi", this.d });
      return;
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130970857);
    b();
    setCanceledOnTouchOutside(false);
  }
  
  public void show()
  {
    super.show();
    if (TextUtils.isEmpty(this.e)) {
      StoryReportor.a("weishi_share", "cover_exp", 0, 0, new String[] { this.c, this.b, "weishi", this.d });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.view.WeShiGuideDialog
 * JD-Core Version:    0.7.0.1
 */