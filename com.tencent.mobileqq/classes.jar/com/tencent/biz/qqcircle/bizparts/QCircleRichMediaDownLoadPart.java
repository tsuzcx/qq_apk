package com.tencent.biz.qqcircle.bizparts;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.biz.qqcircle.widgets.QCircleProgress;
import com.tencent.biz.richframework.delegate.impl.RFThreadManager;
import com.tencent.biz.richframework.part.Part;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;

public class QCircleRichMediaDownLoadPart
  extends Part
{
  private Dialog a;
  private QCircleProgress b;
  private TextView c;
  private Context d;
  
  public QCircleRichMediaDownLoadPart() {}
  
  public QCircleRichMediaDownLoadPart(Context paramContext)
  {
    this.d = paramContext;
  }
  
  private void a(int paramInt)
  {
    Object localObject = this.b;
    if (localObject != null) {
      ((QCircleProgress)localObject).setProgress(paramInt);
    }
    localObject = this.c;
    if (localObject != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramInt);
      localStringBuilder.append("%");
      ((TextView)localObject).setText(localStringBuilder.toString());
    }
  }
  
  private void b(boolean paramBoolean)
  {
    QLog.d("QCircleRichMediaDownLoadPart", 2, new Object[] { "[downLoadResult] success: ", Boolean.valueOf(paramBoolean) });
    Dialog localDialog = this.a;
    if ((localDialog != null) && (localDialog.isShowing()))
    {
      if (paramBoolean) {
        a(100);
      }
      try
      {
        this.a.dismiss();
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        localIllegalArgumentException.printStackTrace();
      }
      Toast localToast = new Toast(g());
      View localView = LayoutInflater.from(g()).inflate(2131626957, null);
      localToast.setDuration(0);
      TextView localTextView = (TextView)localView.findViewById(2131432109);
      String str;
      if (paramBoolean) {
        str = g().getResources().getString(2131895700);
      } else {
        str = g().getResources().getString(2131895699);
      }
      localTextView.setText(str);
      localToast.setGravity(17, 0, 0);
      localToast.setView(localView);
      localToast.show();
    }
  }
  
  private void d()
  {
    if (this.a == null)
    {
      this.a = new ReportDialog(g(), 2131952183);
      this.a.setCanceledOnTouchOutside(true);
      View localView = LayoutInflater.from(g()).inflate(2131626956, null);
      this.b = ((QCircleProgress)localView.findViewById(2131441613));
      this.b.setStrokeWidth(4.0F);
      this.b.setBgAndProgressColor(20, Color.parseColor("#ffffff"), 90, Color.parseColor("#ffffff"));
      this.c = ((TextView)localView.findViewById(2131441612));
      this.a.setContentView(localView);
      this.a.setCancelable(false);
    }
    this.c.setText("0%");
    this.b.setProgress(0.0F);
    if (!this.a.isShowing()) {
      try
      {
        this.a.show();
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public String a()
  {
    return "QCircleRichMediaDownLoadPart";
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
  }
  
  public void a(String paramString, Object paramObject)
  {
    RFThreadManager.getUIHandler().post(new QCircleRichMediaDownLoadPart.1(this, paramString, paramObject));
  }
  
  public boolean ah_()
  {
    Dialog localDialog = this.a;
    if ((localDialog != null) && (localDialog.isShowing())) {
      return true;
    }
    return super.ah_();
  }
  
  public Context g()
  {
    Context localContext2 = this.d;
    Context localContext1 = localContext2;
    if (localContext2 == null) {
      localContext1 = super.g();
    }
    return localContext1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.QCircleRichMediaDownLoadPart
 * JD-Core Version:    0.7.0.1
 */