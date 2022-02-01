package com.tencent.biz.pubaccount.weishi_new.openws;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.biz.pubaccount.weishi_new.image.WSPicLoader;
import com.tencent.biz.pubaccount.weishi_new.openws.data.WSOpenWeiShiData;
import com.tencent.mobileqq.kandian.base.view.widget.KandianUrlImageView;

public class WSOpenWeiShiTipsDialog
  extends Dialog
  implements View.OnClickListener
{
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private WSOnDialogItemClickListener jdField_a_of_type_ComTencentBizPubaccountWeishi_newOpenwsWSOnDialogItemClickListener;
  private WSOpenWeiShiData jdField_a_of_type_ComTencentBizPubaccountWeishi_newOpenwsDataWSOpenWeiShiData;
  private KandianUrlImageView jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView;
  private TextView b;
  private TextView c;
  
  public WSOpenWeiShiTipsDialog(@NonNull Context paramContext)
  {
    super(paramContext, 1929773056);
    a();
    b();
    setCanceledOnTouchOutside(false);
  }
  
  @NonNull
  private Drawable a()
  {
    return getContext().getResources().getDrawable(2130842789);
  }
  
  @NonNull
  private String a(@Nullable WSOpenWeiShiData paramWSOpenWeiShiData)
  {
    if ((paramWSOpenWeiShiData != null) && (paramWSOpenWeiShiData.a() != null)) {
      return paramWSOpenWeiShiData.a();
    }
    return "";
  }
  
  private void a()
  {
    setContentView(1929641984);
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView = ((KandianUrlImageView)findViewById(1929576458));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(1929576470));
    this.b = ((TextView)findViewById(1929576469));
    this.c = ((TextView)findViewById(1929576468));
    this.c.setOnClickListener(this);
    findViewById(1929576457).setOnClickListener(this);
  }
  
  @NonNull
  private String b(@Nullable WSOpenWeiShiData paramWSOpenWeiShiData)
  {
    if ((paramWSOpenWeiShiData != null) && (!TextUtils.isEmpty(paramWSOpenWeiShiData.d()))) {
      return paramWSOpenWeiShiData.d();
    }
    return getContext().getString(1929707533);
  }
  
  private void b()
  {
    Object localObject = getWindow();
    if (localObject == null) {
      return;
    }
    localObject = ((Window)localObject).getAttributes();
    ((WindowManager.LayoutParams)localObject).width = -1;
    ((WindowManager.LayoutParams)localObject).height = -2;
    ((WindowManager.LayoutParams)localObject).gravity = 80;
  }
  
  @NonNull
  private String c(@Nullable WSOpenWeiShiData paramWSOpenWeiShiData)
  {
    if ((paramWSOpenWeiShiData != null) && (!TextUtils.isEmpty(paramWSOpenWeiShiData.c()))) {
      return paramWSOpenWeiShiData.c();
    }
    return getContext().getString(1929707532);
  }
  
  private void c()
  {
    WSOnDialogItemClickListener localWSOnDialogItemClickListener = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newOpenwsWSOnDialogItemClickListener;
    if (localWSOnDialogItemClickListener != null) {
      localWSOnDialogItemClickListener.a();
    }
    dismiss();
  }
  
  @NonNull
  private String d(@Nullable WSOpenWeiShiData paramWSOpenWeiShiData)
  {
    if ((paramWSOpenWeiShiData != null) && (!TextUtils.isEmpty(paramWSOpenWeiShiData.b()))) {
      return paramWSOpenWeiShiData.b();
    }
    return getContext().getString(1929707531);
  }
  
  private void d()
  {
    WSOnDialogItemClickListener localWSOnDialogItemClickListener = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newOpenwsWSOnDialogItemClickListener;
    if (localWSOnDialogItemClickListener != null) {
      localWSOnDialogItemClickListener.a(e(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newOpenwsDataWSOpenWeiShiData));
    }
    dismiss();
  }
  
  @NonNull
  private String e(@Nullable WSOpenWeiShiData paramWSOpenWeiShiData)
  {
    if ((paramWSOpenWeiShiData != null) && (paramWSOpenWeiShiData.e() != null)) {
      return paramWSOpenWeiShiData.e();
    }
    return "";
  }
  
  public void a(@Nullable WSOnDialogItemClickListener paramWSOnDialogItemClickListener)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newOpenwsWSOnDialogItemClickListener = paramWSOnDialogItemClickListener;
  }
  
  public void a(@Nullable WSOpenWeiShiData paramWSOpenWeiShiData)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newOpenwsDataWSOpenWeiShiData = paramWSOpenWeiShiData;
    WSPicLoader.a(this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView, a(paramWSOpenWeiShiData), a());
    this.jdField_a_of_type_AndroidWidgetTextView.setText(d(paramWSOpenWeiShiData));
    this.b.setText(c(paramWSOpenWeiShiData));
    this.c.setText(b(paramWSOpenWeiShiData));
  }
  
  public void onBackPressed()
  {
    c();
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i != 1929576457)
    {
      if (i != 1929576468) {
        return;
      }
      d();
      return;
    }
    c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.openws.WSOpenWeiShiTipsDialog
 * JD-Core Version:    0.7.0.1
 */