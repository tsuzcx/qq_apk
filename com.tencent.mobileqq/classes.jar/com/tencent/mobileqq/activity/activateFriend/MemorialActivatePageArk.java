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
import com.tencent.mobileqq.qqfeatureswitch.IFeatureRuntimeService;
import com.tencent.mobileqq.utils.TimeFormatterUtils;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONObject;

public class MemorialActivatePageArk
  extends ActivateBasePage
{
  public ArkAppView k;
  public final String l = "MemorialActivatePageArk";
  ArkAppContainer m;
  private ImageView n;
  private LinearLayout o;
  private TextView p;
  
  public MemorialActivatePageArk(Context paramContext)
  {
    super(paramContext);
  }
  
  public static boolean h()
  {
    return ((IFeatureRuntimeService)MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IFeatureRuntimeService.class, "all")).isFeatureSwitchEnable("AIO_QQMemorial_862898663");
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
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.k.setAlpha(1.0F);
    } else {
      f();
    }
    findViewById(2131427593).setVisibility(8);
    QLog.i("MemorialActivatePageArk", 1, "@arkgif  hideLoading");
  }
  
  public boolean a(long paramLong, JSONObject paramJSONObject, int paramInt)
  {
    try
    {
      localObject = TimeFormatterUtils.a(getContext(), 3, paramLong);
      this.c.setText((CharSequence)localObject);
      if (TextUtils.isEmpty(paramJSONObject.toString()))
      {
        if (QLog.isColorLevel())
        {
          QLog.i("MemorialActivatePageArk", 1, "initdata json empty");
          return false;
        }
      }
      else
      {
        g();
        int i;
        if (getContext() != null) {
          i = getContext().getResources().getDisplayMetrics().widthPixels;
        } else {
          i = ViewUtils.getScreenWidth();
        }
        i -= ViewUtils.dpToPx(84.0F);
        paramInt -= ViewUtils.dpToPx(35.0F);
        if (this.m != null)
        {
          QLog.i("MemorialActivatePageArk", 1, "@arkgif  initdata destroy");
          this.m.doOnEvent(2);
        }
        this.m = new ArkAppContainer();
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("@arkgif  arkAppContainer  init height =");
        ((StringBuilder)localObject).append(paramInt);
        QLog.i("MemorialActivatePageArk", 1, ((StringBuilder)localObject).toString());
        localObject = paramJSONObject.optString("app");
        String str = paramJSONObject.optString("view");
        paramJSONObject = paramJSONObject.optJSONObject("meta").toString();
        this.m.a((String)localObject, str, "1.0.0.1", paramJSONObject, getResources().getDisplayMetrics().scaledDensity, new SessionInfo());
        this.k.setOnTouchListener(this.k);
        this.k.setOnLongClickListener(this.k);
        this.m.setFixSize(i, paramInt);
        this.m.setMaxSize(i, paramInt);
        this.m.setMinSize(i, paramInt);
        paramJSONObject = new MemorialActivatePageArk.1(this);
        this.k.setLoadCallback(paramJSONObject);
        this.k.initArkView(this.m);
        return true;
      }
    }
    catch (Exception paramJSONObject)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("@arkgif  initdata erro");
      ((StringBuilder)localObject).append(paramJSONObject.toString());
      QLog.e("MemorialActivatePageArk", 1, ((StringBuilder)localObject).toString());
      return false;
    }
    return false;
  }
  
  public void b()
  {
    super.b();
    if (this.m != null)
    {
      QLog.i("MemorialActivatePageArk", 1, "@arkgif  destroy");
      this.m.doOnEvent(2);
    }
  }
  
  public void c()
  {
    super.c();
    ArkAppContainer localArkAppContainer = this.m;
    if (localArkAppContainer != null) {
      localArkAppContainer.invalidateRect();
    }
  }
  
  public void e()
  {
    this.k.setAlpha(0.0F);
    findViewById(2131427593).setVisibility(0);
    QLog.i("MemorialActivatePageArk", 1, "@arkgif  showLoading");
  }
  
  public void f()
  {
    this.o.setVisibility(0);
    this.n.setImageDrawable(getResources().getDrawable(2130846179));
    this.p.setVisibility(0);
  }
  
  public void g()
  {
    this.o.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.activateFriend.MemorialActivatePageArk
 * JD-Core Version:    0.7.0.1
 */