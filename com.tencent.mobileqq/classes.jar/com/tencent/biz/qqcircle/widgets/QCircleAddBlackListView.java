package com.tencent.biz.qqcircle.widgets;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.tencent.biz.qqcircle.richframework.util.FastClickUtils;
import com.tencent.biz.qqcircle.richframework.widget.actionsheet.ActionSheet;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.biz.qcircle.R.styleable;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import feedcloud.FeedCloudMeta.StUser;

public class QCircleAddBlackListView
  extends TextView
  implements View.OnClickListener
{
  private int a;
  private int b;
  private int c;
  private int d;
  private String e;
  private String f;
  private FeedCloudMeta.StUser g;
  
  public QCircleAddBlackListView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public QCircleAddBlackListView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public QCircleAddBlackListView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.cw);
    this.b = paramContext.getResourceId(R.styleable.cz, 2130845322);
    this.a = paramContext.getResourceId(R.styleable.cC, 2130845324);
    this.c = paramContext.getResourceId(R.styleable.cA, 2131167085);
    this.d = paramContext.getResourceId(R.styleable.cD, 2131167084);
    paramContext.recycle();
    a();
  }
  
  private void a(int paramInt)
  {
    Object localObject = this.g;
    if (localObject != null)
    {
      ((FeedCloudMeta.StUser)localObject).blackState.set(paramInt);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("uin:");
      ((StringBuilder)localObject).append(this.g.id.get());
      ((StringBuilder)localObject).append(" state:");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("QCircleAddBlackListView", 1, ((StringBuilder)localObject).toString());
    }
    if (getVisibility() == 8) {
      return;
    }
    if (paramInt == 0)
    {
      c();
      return;
    }
    b();
  }
  
  public static void a(Context paramContext, String paramString, int paramInt1, int paramInt2)
  {
    if (paramContext == null) {
      return;
    }
    Intent localIntent = new Intent("action_update_web_user_follow_state");
    localIntent.putExtra("uin", paramString);
    localIntent.putExtra("followstate", paramInt1);
    localIntent.putExtra("blackstate", paramInt2);
    paramContext.sendBroadcast(localIntent);
  }
  
  private void a(boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  private void d()
  {
    ActionSheet localActionSheet = ActionSheet.a(getContext());
    localActionSheet.a(getContext().getResources().getString(2131895621));
    localActionSheet.a(2131892267, 3);
    localActionSheet.e(2131887648);
    localActionSheet.a(new QCircleAddBlackListView.1(this, localActionSheet));
    if (!localActionSheet.isShowing()) {
      localActionSheet.show();
    }
  }
  
  protected URLDrawable a(int paramInt, String paramString)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mLoadingDrawable = QCircleSkinHelper.getInstance().getDrawable(paramInt);
    return URLDrawable.getDrawable(paramString, localURLDrawableOptions);
  }
  
  protected void a()
  {
    setOnClickListener(this);
    b();
  }
  
  public void a(String paramString)
  {
    Intent localIntent = new Intent();
    localIntent.setAction("action_reload_get_main_page");
    localIntent.putExtra("uin", paramString);
    if (getContext() != null) {
      getContext().sendBroadcast(localIntent);
    }
  }
  
  protected void b()
  {
    setVisibility(0);
    if (!TextUtils.isEmpty(this.e)) {
      setBackgroundDrawable(a(this.a, this.e));
    } else {
      setBackgroundDrawable(QCircleSkinHelper.getInstance().getDrawable(this.a));
    }
    setTextColor(QCircleSkinHelper.getInstance().getColor(this.d));
    setText(2131895884);
  }
  
  protected void c()
  {
    setVisibility(0);
    if (!TextUtils.isEmpty(this.f)) {
      setBackgroundDrawable(a(this.b, this.f));
    } else {
      setBackgroundDrawable(QCircleSkinHelper.getInstance().getDrawable(this.b));
    }
    setTextColor(QCircleSkinHelper.getInstance().getColor(this.c));
    setText(2131895627);
  }
  
  public void onClick(View paramView)
  {
    if (!FastClickUtils.a("QCircleblackViewClick"))
    {
      FeedCloudMeta.StUser localStUser = this.g;
      if (localStUser != null) {
        if (localStUser.blackState.get() == 1) {
          a(false);
        } else if (this.g.blackState.get() == 0) {
          d();
        }
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void setUserData(FeedCloudMeta.StUser paramStUser)
  {
    this.g = paramStUser;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleAddBlackListView
 * JD-Core Version:    0.7.0.1
 */