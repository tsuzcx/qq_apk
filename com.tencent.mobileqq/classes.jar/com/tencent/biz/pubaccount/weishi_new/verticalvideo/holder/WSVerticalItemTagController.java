package com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder;

import UserGrowth.stSimpleMetaFeed;
import UserGrowth.stVideoTag;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.biz.pubaccount.weishi_new.baseui.AbsWsUIGroup;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUIUtil;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalItemData;

public class WSVerticalItemTagController
  extends AbsWsUIGroup<WSVerticalItemData>
{
  private TextView g;
  private stSimpleMetaFeed h;
  private WSVerticalVideoHolder i;
  
  public WSVerticalItemTagController(Context paramContext, WSVerticalVideoHolder paramWSVerticalVideoHolder)
  {
    super(paramContext);
    this.i = paramWSVerticalVideoHolder;
  }
  
  private boolean a(stVideoTag paramstVideoTag)
  {
    WSVerticalVideoHolder localWSVerticalVideoHolder = this.i;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localWSVerticalVideoHolder != null)
    {
      if (localWSVerticalVideoHolder.d == null) {
        return false;
      }
      bool1 = bool2;
      if (paramstVideoTag.tagId == 6)
      {
        bool1 = bool2;
        if (TextUtils.equals(this.i.d.k(), "recommend_tab"))
        {
          bool1 = bool2;
          if (h() == 0) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  protected void a()
  {
    WSVerticalItemData localWSVerticalItemData = (WSVerticalItemData)c();
    if ((localWSVerticalItemData != null) && ((localWSVerticalItemData.b() instanceof stSimpleMetaFeed))) {
      this.h = localWSVerticalItemData.b();
    }
  }
  
  protected void b()
  {
    Object localObject1 = this.h;
    if (localObject1 != null)
    {
      stVideoTag localstVideoTag = ((stSimpleMetaFeed)localObject1).videoTag;
      if ((localstVideoTag != null) && (!TextUtils.isEmpty(localstVideoTag.text)) && (!a(localstVideoTag)))
      {
        a(0);
        if ((!TextUtils.isEmpty(localstVideoTag.textColor)) && (localstVideoTag.textColor.startsWith("#")))
        {
          localObject1 = localstVideoTag.textColor;
        }
        else
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("#");
          ((StringBuilder)localObject1).append(localstVideoTag.textColor);
          localObject1 = ((StringBuilder)localObject1).toString();
        }
        if ((!TextUtils.isEmpty(localstVideoTag.bgColor)) && (localstVideoTag.bgColor.startsWith("#")))
        {
          localObject2 = localstVideoTag.bgColor;
        }
        else
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("#");
          ((StringBuilder)localObject2).append(localstVideoTag.bgColor);
          localObject2 = ((StringBuilder)localObject2).toString();
        }
        GradientDrawable localGradientDrawable = new GradientDrawable();
        localGradientDrawable.setCornerRadius(WeishiUIUtil.d);
        if (!WeishiUIUtil.a((String)localObject2)) {
          localObject2 = "#80000000";
        }
        localGradientDrawable.setColor(Color.parseColor((String)localObject2));
        this.g.setText(localstVideoTag.text);
        Object localObject2 = this.g;
        if (!WeishiUIUtil.a((String)localObject1)) {
          localObject1 = "#FFFFFF";
        }
        ((TextView)localObject2).setTextColor(Color.parseColor((String)localObject1));
        this.g.setBackgroundDrawable(localGradientDrawable);
        return;
      }
    }
    a(8);
  }
  
  protected void f() {}
  
  protected int i()
  {
    return 2131626089;
  }
  
  protected void j()
  {
    this.g = ((TextView)c(2131449427));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder.WSVerticalItemTagController
 * JD-Core Version:    0.7.0.1
 */