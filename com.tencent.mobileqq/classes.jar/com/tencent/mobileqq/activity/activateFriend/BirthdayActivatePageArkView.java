package com.tencent.mobileqq.activity.activateFriend;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.ArkAppContainer;
import com.tencent.mobileqq.activity.aio.item.ArkAppView;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.utils.TimeFormatterUtils;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;

public class BirthdayActivatePageArkView
  extends ActivateBasePage
{
  public ArkAppView k;
  public final String l = "BirthdayActivatePageArkView";
  ArkAppContainer m;
  private ImageView n;
  private LinearLayout o;
  private TextView p;
  
  public BirthdayActivatePageArkView(Context paramContext)
  {
    super(paramContext);
  }
  
  public void a()
  {
    this.b = this.a.inflate(2131627241, this, false);
    this.k = ((ArkAppView)this.b.findViewById(2131442265));
    this.c = ((TextView)this.b.findViewById(2131427595));
    this.o = ((LinearLayout)this.b.findViewById(2131432536));
    this.n = ((ImageView)this.b.findViewById(2131427610));
    this.p = ((TextView)this.b.findViewById(2131432518));
    addView(this.b);
  }
  
  public void a(long paramLong, String paramString, int paramInt)
  {
    try
    {
      localObject = TimeFormatterUtils.a(getContext(), 3, paramLong);
      this.c.setText((CharSequence)localObject);
      if (TextUtils.isEmpty(paramString))
      {
        g();
        return;
      }
      h();
      int i;
      if (getContext() != null) {
        i = getContext().getResources().getDisplayMetrics().widthPixels;
      } else {
        i = ViewUtils.getScreenWidth();
      }
      i -= ViewUtils.dpToPx(84.0F);
      paramInt -= ViewUtils.dpToPx(35.0F);
      localObject = new ArkAppMessage();
      ((ArkAppMessage)localObject).fromAppXml(paramString);
      if (this.m != null)
      {
        QLog.i("BirthdayActivatePageArkView", 1, "@arkgif  initdata destroy");
        this.m.doOnEvent(2);
      }
      this.m = new ArkAppContainer();
      paramString = new StringBuilder();
      paramString.append("@arkgif  arkAppContainer  init height =");
      paramString.append(paramInt);
      QLog.i("BirthdayActivatePageArkView", 1, paramString.toString());
      this.m.a(((ArkAppMessage)localObject).appName, ((ArkAppMessage)localObject).appView, ((ArkAppMessage)localObject).appMinVersion, ((ArkAppMessage)localObject).metaList, getResources().getDisplayMetrics().scaledDensity, new SessionInfo());
      this.k.setOnTouchListener(this.k);
      this.k.setOnLongClickListener(this.k);
      this.m.setFixSize(i, paramInt);
      this.m.setMaxSize(i, paramInt);
      this.m.setMinSize(i, paramInt);
      paramString = new BirthdayActivatePageArkView.1(this);
      this.k.setLoadCallback(paramString);
      this.k.initArkView(this.m);
      return;
    }
    catch (Exception paramString)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("@arkgif  initdata erro");
      ((StringBuilder)localObject).append(paramString.toString());
      QLog.e("BirthdayActivatePageArkView", 1, ((StringBuilder)localObject).toString());
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.k.setAlpha(1.0F);
    } else {
      g();
    }
    findViewById(2131427593).setVisibility(8);
    QLog.i("BirthdayActivatePageArkView", 1, "@arkgif  hideLoading");
  }
  
  public void b()
  {
    super.b();
    if (this.m != null)
    {
      QLog.i("BirthdayActivatePageArkView", 1, "@arkgif  destroy");
      this.m.doOnEvent(2);
    }
  }
  
  public void e()
  {
    a(true);
  }
  
  public void f()
  {
    this.k.setAlpha(0.0F);
    findViewById(2131427593).setVisibility(0);
    QLog.i("BirthdayActivatePageArkView", 1, "@arkgif  showLoading");
  }
  
  public void g()
  {
    this.o.setVisibility(0);
    this.n.setImageDrawable(getResources().getDrawable(2130846149));
    this.p.setVisibility(0);
  }
  
  public void h()
  {
    this.o.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.activateFriend.BirthdayActivatePageArkView
 * JD-Core Version:    0.7.0.1
 */