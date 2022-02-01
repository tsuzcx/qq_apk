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
  private KandianUrlImageView a;
  private TextView b;
  private TextView c;
  private TextView d;
  private WSOpenWeiShiData e;
  private WSOnDialogItemClickListener f;
  
  public WSOpenWeiShiTipsDialog(@NonNull Context paramContext)
  {
    super(paramContext, 1929904129);
    a();
    b();
    setCanceledOnTouchOutside(false);
  }
  
  private void a()
  {
    setContentView(1929773060);
    this.a = ((KandianUrlImageView)findViewById(1929707544));
    this.b = ((TextView)findViewById(1929707600));
    this.c = ((TextView)findViewById(1929707599));
    this.d = ((TextView)findViewById(1929707598));
    this.d.setOnClickListener(this);
    findViewById(1929707543).setOnClickListener(this);
  }
  
  @NonNull
  private String b(@Nullable WSOpenWeiShiData paramWSOpenWeiShiData)
  {
    if ((paramWSOpenWeiShiData != null) && (paramWSOpenWeiShiData.c() != null)) {
      return paramWSOpenWeiShiData.c();
    }
    return "";
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
  private Drawable c()
  {
    return getContext().getResources().getDrawable(2130843742);
  }
  
  @NonNull
  private String c(@Nullable WSOpenWeiShiData paramWSOpenWeiShiData)
  {
    if ((paramWSOpenWeiShiData != null) && (!TextUtils.isEmpty(paramWSOpenWeiShiData.f()))) {
      return paramWSOpenWeiShiData.f();
    }
    return getContext().getString(1929838636);
  }
  
  @NonNull
  private String d(@Nullable WSOpenWeiShiData paramWSOpenWeiShiData)
  {
    if ((paramWSOpenWeiShiData != null) && (!TextUtils.isEmpty(paramWSOpenWeiShiData.e()))) {
      return paramWSOpenWeiShiData.e();
    }
    return getContext().getString(1929838624);
  }
  
  private void d()
  {
    WSOnDialogItemClickListener localWSOnDialogItemClickListener = this.f;
    if (localWSOnDialogItemClickListener != null) {
      localWSOnDialogItemClickListener.a();
    }
    dismiss();
  }
  
  @NonNull
  private String e(@Nullable WSOpenWeiShiData paramWSOpenWeiShiData)
  {
    if ((paramWSOpenWeiShiData != null) && (!TextUtils.isEmpty(paramWSOpenWeiShiData.d()))) {
      return paramWSOpenWeiShiData.d();
    }
    return getContext().getString(1929838618);
  }
  
  private void e()
  {
    WSOnDialogItemClickListener localWSOnDialogItemClickListener = this.f;
    if (localWSOnDialogItemClickListener != null) {
      localWSOnDialogItemClickListener.a(f(this.e));
    }
    dismiss();
  }
  
  @NonNull
  private String f(@Nullable WSOpenWeiShiData paramWSOpenWeiShiData)
  {
    if ((paramWSOpenWeiShiData != null) && (paramWSOpenWeiShiData.g() != null)) {
      return paramWSOpenWeiShiData.g();
    }
    return "";
  }
  
  public void a(@Nullable WSOnDialogItemClickListener paramWSOnDialogItemClickListener)
  {
    this.f = paramWSOnDialogItemClickListener;
  }
  
  public void a(@Nullable WSOpenWeiShiData paramWSOpenWeiShiData)
  {
    this.e = paramWSOpenWeiShiData;
    WSPicLoader.a().a(this.a, b(paramWSOpenWeiShiData), c());
    this.b.setText(e(paramWSOpenWeiShiData));
    this.c.setText(d(paramWSOpenWeiShiData));
    this.d.setText(c(paramWSOpenWeiShiData));
  }
  
  public void onBackPressed()
  {
    d();
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i != 1929707543)
    {
      if (i != 1929707598) {
        return;
      }
      e();
      return;
    }
    d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.openws.WSOpenWeiShiTipsDialog
 * JD-Core Version:    0.7.0.1
 */