package com.tencent.biz.pubaccount.weishi_new;

import UserGrowth.stPublisherGuide;
import UserGrowth.stPublisherRsp;
import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.weishi_new.report.WSPublicAccReport;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUtils;
import com.tencent.biz.subscribe.comment.SafeDialog;
import com.tencent.image.URLImageView;

public class WSPublisherDialog
  extends SafeDialog
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int;
  private stPublisherRsp jdField_a_of_type_UserGrowthStPublisherRsp;
  private Context jdField_a_of_type_AndroidContentContext;
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private WSMultiImageManager jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSMultiImageManager;
  private URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  private TextView b;
  
  public WSPublisherDialog(Context paramContext)
  {
    this(paramContext, -1, -1);
  }
  
  public WSPublisherDialog(Context paramContext, int paramInt1, int paramInt2)
  {
    this(paramContext, 2131756308, paramInt1, paramInt2);
  }
  
  protected WSPublisherDialog(Context paramContext, int paramInt1, int paramInt2, int paramInt3)
  {
    super(paramContext, paramInt1);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    b();
    paramContext = getWindow();
    if (paramContext == null)
    {
      WSLog.b("WSPublisherDialog", 2, "ScrollMoreDialog() window == null.");
      return;
    }
    paramContext = paramContext.getAttributes();
    if (paramContext == null)
    {
      WSLog.b("WSPublisherDialog", 2, "ScrollMoreDialog() params == null.");
      return;
    }
    paramContext.width = paramInt2;
    paramContext.height = paramInt3;
  }
  
  private void a(String paramString1, String paramString2, int paramInt)
  {
    String str;
    if (this.jdField_a_of_type_Int == 0) {
      str = "focus";
    } else {
      str = "feeds";
    }
    WSPublicAccReport.getInstance().reportPublisher(paramString1, str, paramString2, paramInt);
  }
  
  private void b()
  {
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(getContext()).inflate(2131560027, null, false);
    setContentView(this.jdField_a_of_type_AndroidViewView);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131381248));
    this.b = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131381249));
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131381220));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131381221));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131381225));
    RelativeLayout localRelativeLayout = (RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131381233);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
    localRelativeLayout.setOnClickListener(this);
    a("gzh_exposure", "publish_popup", 0);
  }
  
  private void c()
  {
    if (isShowing()) {
      dismiss();
    }
  }
  
  private void d()
  {
    stPublisherRsp localstPublisherRsp = this.jdField_a_of_type_UserGrowthStPublisherRsp;
    if (localstPublisherRsp == null) {
      return;
    }
    WeishiUtils.a(this.jdField_a_of_type_AndroidContentContext, localstPublisherRsp.weishiSchema, this.jdField_a_of_type_UserGrowthStPublisherRsp.h5Url, this.jdField_a_of_type_UserGrowthStPublisherRsp.miniAppSchema, 0, new WSPublisherDialog.1(this));
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(stPublisherRsp paramstPublisherRsp)
  {
    this.jdField_a_of_type_UserGrowthStPublisherRsp = paramstPublisherRsp;
    paramstPublisherRsp = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130841770);
    Object localObject = this.jdField_a_of_type_UserGrowthStPublisherRsp;
    if ((localObject != null) && (((stPublisherRsp)localObject).guide != null))
    {
      localObject = this.jdField_a_of_type_UserGrowthStPublisherRsp.guide.imageUrl;
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_UserGrowthStPublisherRsp.guide.desc);
      this.b.setText(this.jdField_a_of_type_UserGrowthStPublisherRsp.guide.btnText);
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSMultiImageManager = new WSMultiImageManager();
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSMultiImageManager.a(this.jdField_a_of_type_ComTencentImageURLImageView, paramstPublisherRsp, (String)localObject, true, false);
      return;
    }
    this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(paramstPublisherRsp);
  }
  
  public void dismiss()
  {
    super.dismiss();
    WSMultiImageManager localWSMultiImageManager = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSMultiImageManager;
    if (localWSMultiImageManager != null)
    {
      localWSMultiImageManager.a();
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSMultiImageManager = null;
    }
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i != 2131381221)
    {
      if (i != 2131381225)
      {
        if (i != 2131381233) {
          return;
        }
        a("gzh_click", "publish_popup", 1000001);
        c();
        return;
      }
      d();
      c();
      return;
    }
    a("gzh_click", "publish_popup", 1000005);
    c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.WSPublisherDialog
 * JD-Core Version:    0.7.0.1
 */