package com.tencent.biz.pubaccount.weishi_new.like;

import UserGrowth.stSimpleMetaFeed;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.biz.pubaccount.weishi_new.event.LikeRspEvent;
import com.tencent.biz.pubaccount.weishi_new.event.WSSimpleEventBus;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.mobileqq.kandian.biz.video.api.IVideoFeedsHelper;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.HashMap;
import java.util.Map;

public class WSLikeAnimationManger
{
  private Map<String, WsSingleClickLikeAnimation> a = new HashMap();
  private Map<String, WSDoubleLikeAnimation> b = new HashMap();
  
  private WSDoubleLikeAnimation a(String paramString)
  {
    WSDoubleLikeAnimation localWSDoubleLikeAnimation2 = (WSDoubleLikeAnimation)this.b.get(paramString);
    WSDoubleLikeAnimation localWSDoubleLikeAnimation1 = localWSDoubleLikeAnimation2;
    if (localWSDoubleLikeAnimation2 == null)
    {
      localWSDoubleLikeAnimation1 = new WSDoubleLikeAnimation();
      this.b.put(paramString, localWSDoubleLikeAnimation1);
    }
    return localWSDoubleLikeAnimation1;
  }
  
  public static WSLikeAnimationManger a()
  {
    return WSLikeAnimationManger.SingletonHolder.a();
  }
  
  private WsSingleClickLikeAnimation a(String paramString)
  {
    WsSingleClickLikeAnimation localWsSingleClickLikeAnimation2 = (WsSingleClickLikeAnimation)this.a.get(paramString);
    WsSingleClickLikeAnimation localWsSingleClickLikeAnimation1 = localWsSingleClickLikeAnimation2;
    if (localWsSingleClickLikeAnimation2 == null)
    {
      localWsSingleClickLikeAnimation1 = new WsSingleClickLikeAnimation();
      this.a.put(paramString, localWsSingleClickLikeAnimation1);
    }
    return localWsSingleClickLikeAnimation1;
  }
  
  private void a(stSimpleMetaFeed paramstSimpleMetaFeed, String paramString, boolean paramBoolean, int paramInt1, int paramInt2, TextView paramTextView, View paramView1, View paramView2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("doClickLike");
    localStringBuilder.append(paramBoolean);
    WSLog.a("WSLikeAnimationManger", localStringBuilder.toString());
    if (TextUtils.isEmpty(paramString))
    {
      WSLog.a("WSLikeAnimationManger", "feedId：is null");
      return;
    }
    if ((paramView1 != null) && (paramView2 != null)) {
      a(paramString).a(paramstSimpleMetaFeed, paramView1, paramView2, paramTextView, paramInt1, paramBoolean);
    }
    a(paramString, paramBoolean, paramInt2);
  }
  
  private void a(String paramString, int paramInt1, int paramInt2)
  {
    paramString = new LikeRspEvent(paramString, paramInt1);
    paramString.setRpsStatus(4301);
    paramString.setRspIsDing(paramInt2);
    WSSimpleEventBus.a().a(paramString);
  }
  
  private void a(String paramString, LikeRspEvent paramLikeRspEvent, int paramInt)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      Map localMap = this.a;
      if ((localMap != null) && (localMap.size() > 0))
      {
        paramString = (WsSingleClickLikeAnimation)this.a.get(paramString);
        if (paramString != null) {
          a(paramString.a(), paramString.a(), paramString.a(), paramString.b());
        }
      }
    }
    paramLikeRspEvent.setRpsStatus(4302);
    paramLikeRspEvent.setRspIsDing(paramInt);
  }
  
  private void a(String paramString, boolean paramBoolean, int paramInt)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.useAs(TypeTransformer.java:868)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:668)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s2stmt(TypeTransformer.java:820)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:843)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void a()
  {
    Map localMap = this.a;
    if (localMap != null) {
      localMap.clear();
    }
    localMap = this.b;
    if (localMap != null) {
      localMap.clear();
    }
  }
  
  public void a(stSimpleMetaFeed paramstSimpleMetaFeed, int paramInt1, int paramInt2, int paramInt3, TextView paramTextView, View paramView1, View paramView2, ViewGroup paramViewGroup)
  {
    if (paramstSimpleMetaFeed == null)
    {
      WSLog.d("WSLikeAnimationManger", "feed：is null");
      return;
    }
    String str = paramstSimpleMetaFeed.id;
    if (TextUtils.isEmpty(str))
    {
      WSLog.d("WSLikeAnimationManger", "feedId：is null");
      return;
    }
    int i;
    if (paramstSimpleMetaFeed.is_ding == 1) {
      i = 1;
    } else {
      i = 0;
    }
    if (i == 0)
    {
      paramstSimpleMetaFeed.ding_count += 1;
      paramstSimpleMetaFeed.is_ding = 1;
    }
    if (paramViewGroup != null) {
      a(str).a(paramViewGroup, paramInt2, paramInt3);
    }
    if (i == 0) {
      a(paramstSimpleMetaFeed, str, true, paramstSimpleMetaFeed.ding_count, paramInt1, paramTextView, paramView1, paramView2);
    }
  }
  
  public void a(stSimpleMetaFeed paramstSimpleMetaFeed, int paramInt, TextView paramTextView, View paramView1, View paramView2, ViewGroup paramViewGroup)
  {
    int i = paramstSimpleMetaFeed.is_ding;
    int j = 0;
    if (i == 1) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      paramstSimpleMetaFeed.ding_count -= 1;
    } else {
      paramstSimpleMetaFeed.ding_count += 1;
    }
    boolean bool = i ^ 0x1;
    i = j;
    if (bool) {
      i = 1;
    }
    paramstSimpleMetaFeed.is_ding = i;
    a(paramstSimpleMetaFeed, paramstSimpleMetaFeed.id, bool, paramstSimpleMetaFeed.ding_count, paramInt, paramTextView, paramView1, paramView2);
    if ((bool) && (paramViewGroup != null))
    {
      a(paramstSimpleMetaFeed.id).a(paramViewGroup, paramViewGroup.getMeasuredWidth() / 2, paramViewGroup.getMeasuredHeight() / 2);
      return;
    }
  }
  
  public void a(stSimpleMetaFeed paramstSimpleMetaFeed, TextView paramTextView, View paramView1, View paramView2)
  {
    if (paramstSimpleMetaFeed == null)
    {
      WSLog.d("WSLikeAnimationManger", "resetLikeSate：is null");
      return;
    }
    int i = paramstSimpleMetaFeed.is_ding;
    int j = 0;
    if (i == 1) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      paramstSimpleMetaFeed.ding_count -= 1;
    } else {
      paramstSimpleMetaFeed.ding_count += 1;
    }
    boolean bool = i ^ 0x1;
    i = j;
    if (bool) {
      i = 1;
    }
    paramstSimpleMetaFeed.is_ding = i;
    if (paramView1 != null) {
      paramView1.setSelected(bool);
    }
    if (paramView2 != null) {
      paramView2.setVisibility(8);
    }
    if (paramTextView != null)
    {
      if (paramstSimpleMetaFeed.ding_count > 0)
      {
        ((IVideoFeedsHelper)QRoute.api(IVideoFeedsHelper.class)).commonSetCountToTextView(paramTextView, paramstSimpleMetaFeed.ding_count, "0");
        return;
      }
      paramTextView.setText("赞");
    }
  }
  
  public void a(String paramString)
  {
    Object localObject = this.a;
    if (localObject != null)
    {
      localObject = (WsSingleClickLikeAnimation)((Map)localObject).get(paramString);
      if (localObject != null)
      {
        ((WsSingleClickLikeAnimation)localObject).a();
        this.a.remove(localObject);
      }
    }
    localObject = this.b;
    if (localObject != null)
    {
      paramString = (WSDoubleLikeAnimation)((Map)localObject).get(paramString);
      if (paramString != null)
      {
        paramString.a();
        this.b.remove(paramString);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.like.WSLikeAnimationManger
 * JD-Core Version:    0.7.0.1
 */