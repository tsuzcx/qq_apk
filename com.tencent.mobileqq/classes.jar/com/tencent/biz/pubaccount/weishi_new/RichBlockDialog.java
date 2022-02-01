package com.tencent.biz.pubaccount.weishi_new;

import UserGrowth.stAnnexation;
import UserGrowth.stGlobalConfig;
import UserGrowth.stPopWindowsButton;
import UserGrowth.stPopWindowsConfig;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.weishi_new.download.wsapp.WSFallKeyPicMonitor;
import com.tencent.biz.pubaccount.weishi_new.report.WSPublicAccReport;
import com.tencent.biz.pubaccount.weishi_new.report.WSReportDc00898;
import com.tencent.biz.pubaccount.weishi_new.report.dc898.WSReportDC898Vertical;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUtils;
import com.tencent.biz.subscribe.comment.SafeDialog;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

public class RichBlockDialog
  extends SafeDialog
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int = 12;
  private long jdField_a_of_type_Long;
  private stGlobalConfig jdField_a_of_type_UserGrowthStGlobalConfig;
  public stPopWindowsConfig a;
  private Context jdField_a_of_type_AndroidContentContext;
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private WSMultiImageManager jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSMultiImageManager;
  private URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  private String jdField_a_of_type_JavaLangString = "weishi://main";
  private boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int = 5;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private String jdField_b_of_type_JavaLangString;
  private int jdField_c_of_type_Int;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private int jdField_d_of_type_Int;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  private TextView e;
  private TextView f;
  
  private RichBlockDialog(Context paramContext, int paramInt1, int paramInt2)
  {
    this(paramContext, 2131755959, paramInt1, paramInt2);
  }
  
  private RichBlockDialog(Context paramContext, int paramInt1, int paramInt2, int paramInt3)
  {
    super(paramContext, paramInt1);
    b();
    paramContext = getWindow();
    if (paramContext == null)
    {
      WSLog.b("RichBlockDialog", 2, "ScrollMoreDialog() window == null.");
      return;
    }
    paramContext = paramContext.getAttributes();
    if (paramContext == null)
    {
      WSLog.b("RichBlockDialog", 2, "ScrollMoreDialog() params == null.");
      return;
    }
    paramContext.width = paramInt2;
    paramContext.height = paramInt3;
  }
  
  public RichBlockDialog(Context paramContext, int paramInt1, int paramInt2, String paramString)
  {
    this(paramContext, -1, -1);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_c_of_type_Int = paramInt1;
    this.jdField_d_of_type_Int = paramInt2;
    this.jdField_b_of_type_JavaLangString = paramString;
  }
  
  private int a()
  {
    switch (this.jdField_a_of_type_UserGrowthStPopWindowsConfig.type)
    {
    case 1: 
    default: 
      return 6;
    case 2: 
      return 401;
    }
    return 7;
  }
  
  private String a(int paramInt)
  {
    String str2 = String.format("%.3f", new Object[] { Double.valueOf(paramInt / 100.0D) });
    String str1 = str2;
    if (str2.indexOf(".") > 0) {
      str1 = str2.replaceAll("0+?$", "").replaceAll("[.]$", "");
    }
    return str1;
  }
  
  private void a(int paramInt)
  {
    long l = System.currentTimeMillis();
    if (l - this.jdField_a_of_type_Long < 1500L)
    {
      WSLog.a("RichBlockDialog", 1, "点击时间小于1.5秒，不做响应");
      return;
    }
    this.jdField_a_of_type_Long = l;
    Context localContext;
    if ((this.jdField_a_of_type_UserGrowthStPopWindowsConfig != null) && (this.jdField_a_of_type_UserGrowthStPopWindowsConfig.jp_button != null))
    {
      a(112, "popup_clk");
      localContext = getContext();
      if (!(localContext instanceof ContextThemeWrapper)) {
        break label133;
      }
      localContext = ((ContextThemeWrapper)localContext).getBaseContext();
    }
    label133:
    for (;;)
    {
      String str1 = this.jdField_a_of_type_UserGrowthStPopWindowsConfig.schema_url;
      String str2 = this.jdField_a_of_type_UserGrowthStPopWindowsConfig.h5url;
      WeishiUtils.a(this.jdField_a_of_type_AndroidContentContext, str1, str2, "", this.jdField_a_of_type_UserGrowthStPopWindowsConfig.type, new RichBlockDialog.1(this, localContext));
      d();
      return;
    }
  }
  
  private void a(int paramInt, String paramString)
  {
    if (b())
    {
      WSReportDc00898.c(paramInt, this.jdField_a_of_type_UserGrowthStPopWindowsConfig.type, this.jdField_a_of_type_UserGrowthStPopWindowsConfig.windowsid);
      return;
    }
    WSReportDC898Vertical.b(paramString, this.jdField_a_of_type_UserGrowthStPopWindowsConfig.type, this.jdField_a_of_type_UserGrowthStPopWindowsConfig.windowsid);
  }
  
  private void b()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(getContext()).inflate(2131562785, null, false);
    setContentView(this.jdField_a_of_type_AndroidViewView);
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131376422));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131376426));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131376423));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131376425));
    this.e = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131376424));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131376420));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131376419));
    this.f = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131376427));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentImageURLImageView.setOnClickListener(this);
  }
  
  private boolean b()
  {
    return this.jdField_c_of_type_Int == 0;
  }
  
  private void c()
  {
    if ((this.jdField_a_of_type_UserGrowthStPopWindowsConfig != null) && (this.jdField_a_of_type_UserGrowthStPopWindowsConfig.type != 1))
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(4);
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(4);
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(4);
      this.e.setVisibility(4);
      this.f.setVisibility(4);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
      WSLog.a("weishi-813", "展示图片");
      return;
    }
    WSLog.a("weishi-813", "展示红包");
  }
  
  private void d()
  {
    if (isShowing()) {
      dismiss();
    }
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_UserGrowthStPopWindowsConfig != null)
    {
      if (!TextUtils.isEmpty(this.jdField_a_of_type_UserGrowthStPopWindowsConfig.title)) {
        this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_UserGrowthStPopWindowsConfig.title);
      }
      if (this.jdField_a_of_type_UserGrowthStPopWindowsConfig.type != 1) {
        break label234;
      }
      if ((this.jdField_a_of_type_UserGrowthStPopWindowsConfig.annexation != null) && (this.jdField_a_of_type_UserGrowthStPopWindowsConfig.annexation.money > 0))
      {
        String str = a(this.jdField_a_of_type_UserGrowthStPopWindowsConfig.annexation.money);
        this.jdField_c_of_type_AndroidWidgetTextView.setText(str);
      }
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_UserGrowthStPopWindowsConfig.jp_button != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_UserGrowthStPopWindowsConfig.jp_button.title))) {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_UserGrowthStPopWindowsConfig.jp_button.title);
      }
      if (!TextUtils.isEmpty(this.jdField_a_of_type_UserGrowthStPopWindowsConfig.text)) {
        this.jdField_d_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_UserGrowthStPopWindowsConfig.text);
      }
      if (!TextUtils.isEmpty(this.jdField_a_of_type_UserGrowthStPopWindowsConfig.remark)) {
        this.e.setText(this.jdField_a_of_type_UserGrowthStPopWindowsConfig.remark);
      }
      show();
      a(6, "popup_exp");
      WSPublicAccReport.getInstance().reportExposeRichBlockPop(this.jdField_a_of_type_UserGrowthStPopWindowsConfig.windowsid, this.jdField_a_of_type_UserGrowthStPopWindowsConfig.trace_id, this.jdField_b_of_type_JavaLangString, this.jdField_d_of_type_Int);
      a();
      return;
      label234:
      if (this.jdField_a_of_type_UserGrowthStPopWindowsConfig.annexation != null) {
        this.jdField_c_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_UserGrowthStPopWindowsConfig.annexation.money + "");
      }
    }
  }
  
  public void a() {}
  
  public void a(stGlobalConfig paramstGlobalConfig)
  {
    a();
    if (paramstGlobalConfig != null)
    {
      this.jdField_a_of_type_UserGrowthStGlobalConfig = paramstGlobalConfig;
      if ((paramstGlobalConfig.windows_config == null) || (paramstGlobalConfig.windows_config.size() <= 0)) {
        break label129;
      }
      paramstGlobalConfig = (stPopWindowsConfig)paramstGlobalConfig.windows_config.get(0);
      if (paramstGlobalConfig == null) {
        break label117;
      }
      if (paramstGlobalConfig.type != 1) {
        break label93;
      }
      this.jdField_a_of_type_UserGrowthStPopWindowsConfig = paramstGlobalConfig;
      WSLog.a("weishi-813", "阻断页rich化 type是：" + paramstGlobalConfig.type);
    }
    for (;;)
    {
      c();
      return;
      label93:
      if (paramstGlobalConfig.type == 2)
      {
        this.jdField_a_of_type_UserGrowthStPopWindowsConfig = paramstGlobalConfig;
        break;
      }
      this.jdField_a_of_type_UserGrowthStPopWindowsConfig = paramstGlobalConfig;
      break;
      label117:
      WSLog.a("weishi-813", "阻断页rich化 windowsConfig为null");
      continue;
      label129:
      WSLog.c("weishi-813", "瀑布流阻断页rich化 windowsConfig size为0");
    }
  }
  
  public void a(Context paramContext)
  {
    if (paramContext == null) {}
    while (this.jdField_a_of_type_UserGrowthStPopWindowsConfig == null) {
      return;
    }
    if (!TextUtils.isEmpty(this.jdField_a_of_type_UserGrowthStPopWindowsConfig.bg_img_url))
    {
      paramContext = getContext().getResources().getDrawable(2130841881);
      switch (this.jdField_a_of_type_UserGrowthStPopWindowsConfig.type)
      {
      default: 
        d();
        return;
      case 3: 
        this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSMultiImageManager = new WSMultiImageManager();
        this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSMultiImageManager.a(this.jdField_a_of_type_ComTencentImageURLImageView, paramContext, this.jdField_a_of_type_UserGrowthStPopWindowsConfig.bg_img_url, true, false);
        e();
        return;
      }
      a(this.jdField_a_of_type_UserGrowthStPopWindowsConfig.bg_img_url, paramContext, paramContext, HardCodeUtil.a(2131713402));
      return;
    }
    d();
  }
  
  public void a(String paramString1, Drawable paramDrawable1, Drawable paramDrawable2, String paramString2)
  {
    WSFallKeyPicMonitor.a(3);
    paramString2 = URLDrawable.URLDrawableOptions.obtain();
    paramString2.mFailedDrawable = paramDrawable1;
    paramString2.mLoadingDrawable = paramDrawable2;
    paramString1 = URLDrawable.getDrawable(paramString1, paramString2);
    this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(paramString1);
    this.jdField_a_of_type_ComTencentImageURLImageView.setURLDrawableDownListener(new RichBlockDialog.2(this));
    this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(paramString1);
    if (1 == paramString1.getStatus())
    {
      e();
      WSFallKeyPicMonitor.b(3);
      return;
    }
    paramString1.startDownload();
  }
  
  public void dismiss()
  {
    WSLog.b("RichBlockDialog", 2, "dismiss()");
    try
    {
      this.jdField_a_of_type_Boolean = false;
      if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSMultiImageManager != null)
      {
        this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSMultiImageManager.a();
        this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSMultiImageManager = null;
      }
      super.dismiss();
      return;
    }
    catch (Exception localException)
    {
      WSLog.d("RichBlockDialog", 2, localException.getLocalizedMessage());
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView == null) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      switch (paramView.getId())
      {
      case 2131376421: 
      default: 
        break;
      case 2131376419: 
        WSLog.a("weishi-813", "点击了红包 提现");
        a(1);
        break;
      case 2131376420: 
        d();
        if (this.jdField_a_of_type_UserGrowthStPopWindowsConfig != null)
        {
          a(117, "popup_close");
          WSPublicAccReport.getInstance().reportClickRichBlockPop(1000005, this.jdField_a_of_type_UserGrowthStPopWindowsConfig.windowsid, this.jdField_a_of_type_UserGrowthStPopWindowsConfig.trace_id, this.jdField_b_of_type_JavaLangString, this.jdField_d_of_type_Int);
        }
        break;
      case 2131376422: 
        WSLog.a("weishi-813", "点击了图片 背景图");
        a(2);
      }
    }
  }
  
  public void show()
  {
    WSLog.b("RichBlockDialog", 2, "show()");
    try
    {
      super.show();
      this.jdField_a_of_type_Boolean = true;
      return;
    }
    catch (Exception localException)
    {
      WSLog.d("RichBlockDialog", 2, localException.getLocalizedMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.RichBlockDialog
 * JD-Core Version:    0.7.0.1
 */