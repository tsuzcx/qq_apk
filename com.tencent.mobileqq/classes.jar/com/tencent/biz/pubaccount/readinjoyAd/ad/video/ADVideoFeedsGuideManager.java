package com.tencent.biz.pubaccount.readinjoyAd.ad.video;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.video.videofeeds.ADVideoItemHolder;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdUtilService;
import com.tencent.mobileqq.kandian.ad.api.entity.IADVideoFeedsGuideManager;
import com.tencent.mobileqq.kandian.base.view.widget.ICircleCountDownView;
import com.tencent.mobileqq.kandian.biz.ad.entity.VideoAdInfo;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoPlayParam;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.viewholder.VideoItemHolder;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.PackageUtil;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public class ADVideoFeedsGuideManager
  implements Handler.Callback, IADVideoFeedsGuideManager
{
  private Context a;
  private Handler b;
  private ADVideoItemHolder c;
  private ArrayList<ProgressStateListener> d;
  private boolean e;
  private boolean f;
  private boolean g;
  
  public ADVideoFeedsGuideManager(Context paramContext)
  {
    this.a = paramContext;
    this.b = new Handler(this);
    this.d = new ArrayList();
  }
  
  private int a(VideoInfo paramVideoInfo)
  {
    if ((paramVideoInfo != null) && (paramVideoInfo.as != null))
    {
      if (((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isAmsSubscribeAd(paramVideoInfo.as)) {
        return 4;
      }
      if (paramVideoInfo.as.o != 12) {
        return 1;
      }
    }
    try
    {
      paramVideoInfo = new JSONObject(paramVideoInfo.as.A);
      boolean bool = PackageUtil.a(this.a, paramVideoInfo.optString("pkg_name"));
      if (bool) {
        return 3;
      }
      return 2;
    }
    catch (JSONException paramVideoInfo) {}
    return 0;
    return 2;
  }
  
  private boolean b(VideoPlayParam paramVideoPlayParam)
  {
    return (paramVideoPlayParam != null) && (paramVideoPlayParam.c != null) && (paramVideoPlayParam.f != null) && (paramVideoPlayParam.c.aq) && (paramVideoPlayParam.c.as != null);
  }
  
  private void j()
  {
    Object localObject = this.c;
    if ((localObject != null) && (((ADVideoItemHolder)localObject).r != null))
    {
      Resources localResources = this.c.r.getResources();
      if ((this.c.az != null) && (this.c.az.c != null))
      {
        String str;
        if ((this.c.az.c.as != null) && (!TextUtils.isEmpty(this.c.az.c.as.t))) {
          str = this.c.az.c.as.t;
        } else {
          str = "";
        }
        i = a(this.c.az.c);
        if ((i != 0) && (i != 1))
        {
          if (i != 2)
          {
            if (i != 3)
            {
              if (i != 4) {
                localObject = str;
              } else {
                localObject = localResources.getText(2131915394).toString();
              }
            }
            else {
              localObject = localResources.getText(2131915392).toString();
            }
          }
          else
          {
            localObject = str;
            if (TextUtils.isEmpty(str)) {
              localObject = localResources.getText(2131915391).toString();
            }
          }
        }
        else
        {
          localObject = str;
          if (TextUtils.isEmpty(str)) {
            localObject = localResources.getText(2131915449).toString();
          }
        }
      }
      else
      {
        localObject = localResources.getText(2131915449).toString();
      }
      int i = 2130844163;
      if (localResources.getText(2131915391).toString().equals(localObject)) {
        i = 2130844162;
      } else if (localResources.getText(2131915392).toString().equals(localObject)) {
        i = 2130844165;
      }
      this.c.r.setText((CharSequence)localObject);
      int j = AIOUtils.b(12.0F, localResources);
      localObject = localResources.getDrawable(i);
      ((Drawable)localObject).setBounds(0, 0, j, j);
      this.c.r.setCompoundDrawables((Drawable)localObject, null, null, null);
    }
  }
  
  public void a()
  {
    Object localObject = this.b;
    if (localObject != null)
    {
      ((Handler)localObject).removeCallbacksAndMessages(null);
      this.b = null;
    }
    if (this.a != null) {
      this.a = null;
    }
    if (this.c != null) {
      this.c = null;
    }
    localObject = this.d;
    if (localObject != null)
    {
      ((ArrayList)localObject).clear();
      this.d = null;
    }
  }
  
  public void a(ProgressStateListener paramProgressStateListener)
  {
    if ((paramProgressStateListener != null) && (!this.d.contains(paramProgressStateListener))) {
      this.d.add(paramProgressStateListener);
    }
  }
  
  public void a(VideoItemHolder paramVideoItemHolder)
  {
    ADVideoItemHolder localADVideoItemHolder = this.c;
    if (localADVideoItemHolder != null)
    {
      localADVideoItemHolder.k.setVisibility(8);
      this.c.az.b("continue_pause", false);
      this.b.removeCallbacksAndMessages(null);
      this.e = false;
    }
    if ((paramVideoItemHolder instanceof ADVideoItemHolder))
    {
      this.c = ((ADVideoItemHolder)paramVideoItemHolder);
      return;
    }
    this.c = null;
  }
  
  public boolean a(VideoPlayParam paramVideoPlayParam)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void b()
  {
    this.b.removeCallbacksAndMessages(null);
  }
  
  public boolean c()
  {
    if (!this.f)
    {
      ADVideoItemHolder localADVideoItemHolder = this.c;
      if ((localADVideoItemHolder != null) && (localADVideoItemHolder.k != null) && (this.c.k.getVisibility() == 0))
      {
        if (this.g)
        {
          this.c.k.setVisibility(8);
          this.c.az.b("continue_pause", false);
          this.g = false;
          return true;
        }
        j();
        this.b.sendEmptyMessageDelayed(1, 20L);
      }
    }
    this.g = false;
    return false;
  }
  
  public void d()
  {
    this.f = true;
    b();
  }
  
  public void e()
  {
    this.f = false;
    c();
  }
  
  public void f()
  {
    ADVideoItemHolder localADVideoItemHolder = this.c;
    if ((localADVideoItemHolder != null) && (localADVideoItemHolder.k != null))
    {
      this.c.k.setVisibility(8);
      this.c.az.b("continue_pause", false);
    }
    this.b.removeCallbacksAndMessages(null);
    this.e = false;
  }
  
  public void g()
  {
    ADVideoItemHolder localADVideoItemHolder = this.c;
    if ((localADVideoItemHolder != null) && (localADVideoItemHolder.az != null) && (this.c.az.c != null) && (a(this.c.az.c) != 3)) {
      this.g = true;
    }
  }
  
  public ADVideoItemHolder h()
  {
    return this.c;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what != 1) {
      return false;
    }
    paramMessage = this.c;
    if ((paramMessage != null) && (paramMessage.s != null))
    {
      if (this.c.s.a(20))
      {
        if (this.c.k != null)
        {
          this.c.k.setVisibility(8);
          this.c.az.b("continue_pause", false);
        }
        this.b.removeCallbacksAndMessages(null);
        this.e = true;
        paramMessage = this.d;
        if (paramMessage != null)
        {
          paramMessage = paramMessage.iterator();
          while (paramMessage.hasNext()) {
            ((ProgressStateListener)paramMessage.next()).a();
          }
        }
        this.e = false;
        return true;
      }
      this.b.sendEmptyMessageDelayed(1, 20L);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.video.ADVideoFeedsGuideManager
 * JD-Core Version:    0.7.0.1
 */