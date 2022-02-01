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
import com.tencent.biz.pubaccount.weishi_new.combo.publisher.IWSPublisherDialogClickListener;
import com.tencent.biz.pubaccount.weishi_new.report.WSPublicAccReport;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.biz.subscribe.comment.SafeDialog;
import com.tencent.image.URLImageView;

public class WSPublisherDialog
  extends SafeDialog
  implements View.OnClickListener
{
  private Context a;
  private View b;
  private TextView d;
  private TextView e;
  private URLImageView f;
  private ImageView g;
  private LinearLayout h;
  private stPublisherRsp i;
  private WSMultiImageManager j;
  private IWSPublisherDialogClickListener k;
  private int l;
  
  public WSPublisherDialog(Context paramContext)
  {
    this(paramContext, -1, -1);
  }
  
  public WSPublisherDialog(Context paramContext, int paramInt1, int paramInt2)
  {
    this(paramContext, 2131953466, paramInt1, paramInt2);
  }
  
  protected WSPublisherDialog(Context paramContext, int paramInt1, int paramInt2, int paramInt3)
  {
    super(paramContext, paramInt1);
    this.a = paramContext;
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
    if (this.l == 0) {
      str = "focus";
    } else {
      str = "feeds";
    }
    WSPublicAccReport.getInstance().reportPublisher(paramString1, str, paramString2, paramInt);
  }
  
  private void b()
  {
    this.b = LayoutInflater.from(getContext()).inflate(2131626070, null, false);
    setContentView(this.b);
    this.d = ((TextView)this.b.findViewById(2131450296));
    this.e = ((TextView)this.b.findViewById(2131450297));
    this.f = ((URLImageView)this.b.findViewById(2131450268));
    this.g = ((ImageView)this.b.findViewById(2131450269));
    this.h = ((LinearLayout)this.b.findViewById(2131450273));
    RelativeLayout localRelativeLayout = (RelativeLayout)this.b.findViewById(2131450281);
    this.g.setOnClickListener(this);
    this.h.setOnClickListener(this);
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
    if (this.i == null) {
      return;
    }
    IWSPublisherDialogClickListener localIWSPublisherDialogClickListener = this.k;
    if (localIWSPublisherDialogClickListener != null) {
      localIWSPublisherDialogClickListener.a();
    }
  }
  
  public void a(int paramInt)
  {
    this.l = paramInt;
  }
  
  public void a(stPublisherRsp paramstPublisherRsp)
  {
    this.i = paramstPublisherRsp;
    paramstPublisherRsp = this.a.getResources().getDrawable(2130842687);
    Object localObject = this.i;
    if ((localObject != null) && (((stPublisherRsp)localObject).guide != null))
    {
      localObject = this.i.guide.imageUrl;
      this.d.setText(this.i.guide.desc);
      this.e.setText(this.i.guide.btnText);
      this.j = new WSMultiImageManager();
      this.j.a(this.f, paramstPublisherRsp, (String)localObject, true, false);
      return;
    }
    this.f.setImageDrawable(paramstPublisherRsp);
  }
  
  public void a(IWSPublisherDialogClickListener paramIWSPublisherDialogClickListener)
  {
    this.k = paramIWSPublisherDialogClickListener;
  }
  
  public void dismiss()
  {
    super.dismiss();
    WSMultiImageManager localWSMultiImageManager = this.j;
    if (localWSMultiImageManager != null)
    {
      localWSMultiImageManager.a();
      this.j = null;
    }
  }
  
  public void onClick(View paramView)
  {
    int m = paramView.getId();
    if (m != 2131450269)
    {
      if (m != 2131450273)
      {
        if (m != 2131450281) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.WSPublisherDialog
 * JD-Core Version:    0.7.0.1
 */