package com.tencent.mobileqq.activity.aio.tips;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Handler;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.location.LocationShareServiceHolder;
import com.tencent.mobileqq.location.api.ILocationShareService;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.QQBlurView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ThemeImageWrapper;
import java.util.HashMap;
import java.util.List;

public class LocationShareTipsBar
  implements View.OnClickListener, TipsBarTask, DecodeTaskCompletionListener
{
  private static long h;
  private BaseChatPie a;
  private IFaceDecoder b;
  private ViewGroup c;
  private QQBlurView d;
  private HashMap<String, ImageView> e;
  private boolean f = false;
  private Runnable g = new LocationShareTipsBar.1(this);
  
  public LocationShareTipsBar(BaseChatPie paramBaseChatPie)
  {
    this.a = paramBaseChatPie;
    this.e = new HashMap(3);
    paramBaseChatPie = (AppInterface)BaseApplicationImpl.getApplication().getRuntime();
    this.b = ((IQQAvatarService)paramBaseChatPie.getRuntimeService(IQQAvatarService.class, "")).getInstance(paramBaseChatPie);
    this.b.setDecodeTaskCompletionListener(this);
  }
  
  public static void a(View paramView, String paramString)
  {
    if (AppSetting.e) {
      paramView.setContentDescription(paramString);
    }
  }
  
  private void a(String paramString, ImageView paramImageView)
  {
    if (this.a.f != BaseActivity.sTopActivity) {
      return;
    }
    Bitmap localBitmap = this.b.getBitmapFromCache(1, paramString);
    if (localBitmap != null)
    {
      paramImageView.setImageBitmap(localBitmap);
      paramImageView.setVisibility(0);
      return;
    }
    paramImageView.setVisibility(4);
    this.e.put(paramString, paramImageView);
    this.b.requestDecodeFace(paramString, 200, true);
  }
  
  public static void a(String paramString1, String paramString2, TextView paramTextView)
  {
    if (paramTextView.getWidth() == 0)
    {
      paramTextView.post(new LocationShareTipsBar.2(paramString1, paramString2, paramTextView));
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append(paramString2);
    localObject = ((StringBuilder)localObject).toString();
    float f2 = paramTextView.getWidth();
    float f1 = paramTextView.getPaint().measureText(paramString1);
    float f3 = paramTextView.getPaint().measureText(paramString2);
    if (f1 + f3 <= f2)
    {
      paramTextView.setText((CharSequence)localObject);
      return;
    }
    float f4 = paramTextView.getPaint().measureText("...");
    while ((f1 + f4 + f3 > f2) && (paramString1.length() > 0))
    {
      paramString1 = paramString1.substring(0, paramString1.length() - 1);
      f1 = paramTextView.getPaint().measureText(paramString1);
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append("...");
    ((StringBuilder)localObject).append(paramString2);
    paramTextView.setText(((StringBuilder)localObject).toString());
  }
  
  private void b(boolean paramBoolean, String paramString, int paramInt, List<String> paramList)
  {
    Object localObject1 = this.a.f;
    if (this.c == null)
    {
      this.c = ((ViewGroup)View.inflate((Context)localObject1, 2131627288, null));
      this.c.setOnClickListener(this);
    }
    this.c.setClickable(true);
    this.c.findViewById(2131442223).setVisibility(8);
    this.c.findViewById(2131442224).setVisibility(8);
    this.c.findViewById(2131442225).setVisibility(8);
    TextView localTextView = (TextView)this.c.findViewById(2131442222);
    if (ThemeUtil.isInNightMode(this.a.d)) {
      localTextView.setTextColor(Color.parseColor("#A8A8A8"));
    }
    d();
    if (paramBoolean)
    {
      paramString = new StringBuilder();
      paramString.append("你");
      paramString.append(((Activity)localObject1).getString(2131893806));
      paramString = paramString.toString();
      localTextView.setText(paramString);
      if (!this.f)
      {
        ReportController.b(null, "CliOper", "", "", "0X800A767", "0X800A767", 1, 0, "", "0", "0", "");
        this.f = true;
      }
      a(this.c, paramString);
    }
    else
    {
      if (paramInt == 1) {
        localObject1 = ((Activity)localObject1).getString(2131893806);
      } else {
        localObject1 = String.format(((Activity)localObject1).getString(2131893805), new Object[] { Integer.valueOf(paramInt) });
      }
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(paramString);
      ((StringBuilder)localObject2).append((String)localObject1);
      localObject2 = ((StringBuilder)localObject2).toString();
      a(paramString, (String)localObject1, localTextView);
      if (!this.f)
      {
        ReportController.b(null, "CliOper", "", "", "0X800A767", "0X800A767", 2, 0, "", "0", "0", "");
        this.f = true;
      }
      paramString = this.c;
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append((String)localObject2);
      ((StringBuilder)localObject1).append(" 点击加入位置共享");
      a(paramString, ((StringBuilder)localObject1).toString());
    }
    if ((paramList.size() > 0) && (!TextUtils.isEmpty((CharSequence)paramList.get(0)))) {
      a((String)paramList.get(0), (ImageView)this.c.findViewById(2131442223));
    }
    if ((paramList.size() > 1) && (!TextUtils.isEmpty((CharSequence)paramList.get(1)))) {
      a((String)paramList.get(1), (ImageView)this.c.findViewById(2131442224));
    }
    if ((paramList.size() > 2) && (!TextUtils.isEmpty((CharSequence)paramList.get(2)))) {
      a((String)paramList.get(2), (ImageView)this.c.findViewById(2131442225));
    }
    this.c.addOnAttachStateChangeListener(new LocationShareTipsBar.3(this));
    e();
  }
  
  @TargetApi(19)
  private void d()
  {
    if (this.d == null)
    {
      this.d = ((QQBlurView)this.c.findViewById(2131442221));
      this.d.a(this.a.aZ);
      QQBlurView localQQBlurView = this.d;
      localQQBlurView.b(localQQBlurView);
      this.d.b(0);
      this.d.a(8.0F);
      this.d.a(4);
      this.d.d();
      this.d.a();
    }
  }
  
  private void e()
  {
    Object localObject2 = this.c.findViewById(2131442227);
    Object localObject1 = (ImageView)this.c.findViewById(2131442220);
    if (ThemeImageWrapper.isNightMode())
    {
      ((View)localObject2).setBackgroundColor(Color.parseColor("#1F1F1F"));
      ((ImageView)localObject1).setImageResource(2130839648);
      localObject1 = this.d;
      if (localObject1 != null) {
        ((QQBlurView)localObject1).setVisibility(8);
      }
    }
    else
    {
      localObject2 = this.d;
      if (localObject2 != null) {
        ((QQBlurView)localObject2).setVisibility(0);
      }
      ((ImageView)localObject1).setImageResource(2130839647);
    }
  }
  
  public int a()
  {
    return 60;
  }
  
  public View a(Object... paramVarArgs)
  {
    return this.c;
  }
  
  public void a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 1000)
    {
      if (this.d != null)
      {
        ThreadManager.getUIHandlerV2().removeCallbacks(this.g);
        ThreadManager.getUIHandlerV2().postDelayed(this.g, 0L);
      }
    }
    else if ((paramInt == 1003) && (this.d != null))
    {
      ThreadManager.getUIHandlerV2().removeCallbacks(this.g);
      this.d.b();
    }
  }
  
  public void a(boolean paramBoolean, String paramString, int paramInt, List<String> paramList)
  {
    b(paramBoolean, paramString, paramInt, paramList);
  }
  
  public int b()
  {
    return 25;
  }
  
  public int[] c()
  {
    return new int[0];
  }
  
  public void onClick(View paramView)
  {
    if (System.currentTimeMillis() - h >= 1000L)
    {
      if (QLog.isColorLevel()) {
        QLog.d("LocationShareTipsBar", 2, new Object[] { "onClick: invoked. ", " v: ", paramView });
      }
      h = System.currentTimeMillis();
      LocationShareServiceHolder.a(this.a.d).launchShareUi(this.a.aX(), this.a.ah.a, this.a.ah.b, 3);
      ReportController.b(null, "CliOper", "", "", "0X800A768", "0X800A768", 0, 0, "", "0", "0", "");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    paramString = (ImageView)this.e.get(paramString);
    if (paramString != null)
    {
      paramString.setImageBitmap(paramBitmap);
      paramString.setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.tips.LocationShareTipsBar
 * JD-Core Version:    0.7.0.1
 */