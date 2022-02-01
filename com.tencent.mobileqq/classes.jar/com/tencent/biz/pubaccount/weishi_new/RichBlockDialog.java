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
    this(paramContext, 2131756308, paramInt1, paramInt2);
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
    int i = this.jdField_a_of_type_UserGrowthStPopWindowsConfig.type;
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3) {
          return 6;
        }
        return 7;
      }
      return 401;
    }
    return 6;
  }
  
  private String a(int paramInt)
  {
    double d1 = paramInt;
    Double.isNaN(d1);
    String str2 = String.format("%.3f", new Object[] { Double.valueOf(d1 / 100.0D) });
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
    Object localObject1 = this.jdField_a_of_type_UserGrowthStPopWindowsConfig;
    if ((localObject1 != null) && (((stPopWindowsConfig)localObject1).jp_button != null))
    {
      a(112, "popup_clk");
      Object localObject2 = getContext();
      localObject1 = localObject2;
      if ((localObject2 instanceof ContextThemeWrapper)) {
        localObject1 = ((ContextThemeWrapper)localObject2).getBaseContext();
      }
      localObject2 = this.jdField_a_of_type_UserGrowthStPopWindowsConfig.schema_url;
      String str = this.jdField_a_of_type_UserGrowthStPopWindowsConfig.h5url;
      WeishiUtils.a(this.jdField_a_of_type_AndroidContentContext, (String)localObject2, str, "", this.jdField_a_of_type_UserGrowthStPopWindowsConfig.type, new RichBlockDialog.1(this, (Context)localObject1));
    }
    d();
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
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(getContext()).inflate(2131562601, null, false);
    setContentView(this.jdField_a_of_type_AndroidViewView);
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131375934));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131375938));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131375935));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131375937));
    this.e = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131375936));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131375932));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131375931));
    this.f = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131375939));
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
    stPopWindowsConfig localstPopWindowsConfig = this.jdField_a_of_type_UserGrowthStPopWindowsConfig;
    if ((localstPopWindowsConfig != null) && (localstPopWindowsConfig.type != 1))
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
    Object localObject = this.jdField_a_of_type_UserGrowthStPopWindowsConfig;
    if (localObject != null)
    {
      if (!TextUtils.isEmpty(((stPopWindowsConfig)localObject).title)) {
        this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_UserGrowthStPopWindowsConfig.title);
      }
      if (this.jdField_a_of_type_UserGrowthStPopWindowsConfig.type == 1)
      {
        if ((this.jdField_a_of_type_UserGrowthStPopWindowsConfig.annexation != null) && (this.jdField_a_of_type_UserGrowthStPopWindowsConfig.annexation.money > 0))
        {
          localObject = a(this.jdField_a_of_type_UserGrowthStPopWindowsConfig.annexation.money);
          this.jdField_c_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
        }
      }
      else if (this.jdField_a_of_type_UserGrowthStPopWindowsConfig.annexation != null)
      {
        localObject = this.jdField_c_of_type_AndroidWidgetTextView;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.jdField_a_of_type_UserGrowthStPopWindowsConfig.annexation.money);
        localStringBuilder.append("");
        ((TextView)localObject).setText(localStringBuilder.toString());
      }
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
    }
  }
  
  public void a() {}
  
  public void a(stGlobalConfig paramstGlobalConfig)
  {
    a();
    if (paramstGlobalConfig != null)
    {
      this.jdField_a_of_type_UserGrowthStGlobalConfig = paramstGlobalConfig;
      if ((paramstGlobalConfig.windows_config != null) && (paramstGlobalConfig.windows_config.size() > 0))
      {
        paramstGlobalConfig = (stPopWindowsConfig)paramstGlobalConfig.windows_config.get(0);
        if (paramstGlobalConfig != null)
        {
          if (paramstGlobalConfig.type == 1) {
            this.jdField_a_of_type_UserGrowthStPopWindowsConfig = paramstGlobalConfig;
          } else if (paramstGlobalConfig.type == 2) {
            this.jdField_a_of_type_UserGrowthStPopWindowsConfig = paramstGlobalConfig;
          } else {
            this.jdField_a_of_type_UserGrowthStPopWindowsConfig = paramstGlobalConfig;
          }
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("阻断页rich化 type是：");
          localStringBuilder.append(paramstGlobalConfig.type);
          WSLog.a("weishi-813", localStringBuilder.toString());
        }
        else
        {
          WSLog.a("weishi-813", "阻断页rich化 windowsConfig为null");
        }
      }
      else
      {
        WSLog.c("weishi-813", "瀑布流阻断页rich化 windowsConfig size为0");
      }
      c();
    }
  }
  
  public void a(Context paramContext)
  {
    if (paramContext == null) {
      return;
    }
    paramContext = this.jdField_a_of_type_UserGrowthStPopWindowsConfig;
    if (paramContext == null) {
      return;
    }
    if (!TextUtils.isEmpty(paramContext.bg_img_url))
    {
      paramContext = getContext().getResources().getDrawable(2130841770);
      int i = this.jdField_a_of_type_UserGrowthStPopWindowsConfig.type;
      if (i != 2)
      {
        if (i != 3)
        {
          d();
          return;
        }
        this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSMultiImageManager = new WSMultiImageManager();
        this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSMultiImageManager.a(this.jdField_a_of_type_ComTencentImageURLImageView, paramContext, this.jdField_a_of_type_UserGrowthStPopWindowsConfig.bg_img_url, true, false);
        e();
        return;
      }
      a(this.jdField_a_of_type_UserGrowthStPopWindowsConfig.bg_img_url, paramContext, paramContext, HardCodeUtil.a(2131713370));
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
    if (paramView == null) {
      return;
    }
    switch (paramView.getId())
    {
    case 2131375933: 
    default: 
    case 2131375934: 
      WSLog.a("weishi-813", "点击了图片 背景图");
      a(2);
      return;
    case 2131375932: 
      d();
      if (this.jdField_a_of_type_UserGrowthStPopWindowsConfig != null)
      {
        a(117, "popup_close");
        WSPublicAccReport.getInstance().reportClickRichBlockPop(1000005, this.jdField_a_of_type_UserGrowthStPopWindowsConfig.windowsid, this.jdField_a_of_type_UserGrowthStPopWindowsConfig.trace_id, this.jdField_b_of_type_JavaLangString, this.jdField_d_of_type_Int);
        return;
      }
      break;
    case 2131375931: 
      WSLog.a("weishi-813", "点击了红包 提现");
      a(1);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.RichBlockDialog
 * JD-Core Version:    0.7.0.1
 */