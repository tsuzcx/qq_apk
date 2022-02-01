package com.tencent.biz.pubaccount.readinjoyAd.ad.view;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdLogService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import org.json.JSONArray;
import org.json.JSONObject;

public class ReadInJoyAdBubbleView
  extends ViewBase
  implements View.OnClickListener
{
  private Context a;
  private View b;
  private TextView c;
  private TextView d;
  private TextView e;
  private AdvertisementInfo f;
  private List<ReadInJoyAdBubbleView.SingleBubble> g = new ArrayList();
  private Queue<String> h = new LinkedList();
  private ReadInJoyAdBubbleView.UpdateUIHandler i;
  private boolean j = true;
  
  public ReadInJoyAdBubbleView(VafContext paramVafContext)
  {
    super(paramVafContext);
    this.a = paramVafContext.getContext();
    b();
  }
  
  private void b()
  {
    this.b = ((LayoutInflater)this.a.getSystemService("layout_inflater")).inflate(2131626101, null);
    this.c = ((TextView)this.b.findViewById(2131427641));
    this.d = ((TextView)this.b.findViewById(2131427642));
    this.e = ((TextView)this.b.findViewById(2131427643));
    ReadInJoyAdBubbleView.SingleBubble localSingleBubble1 = new ReadInJoyAdBubbleView.SingleBubble(this.c, 0, this.a, this.h);
    ReadInJoyAdBubbleView.SingleBubble localSingleBubble2 = new ReadInJoyAdBubbleView.SingleBubble(this.d, -1, this.a, this.h);
    ReadInJoyAdBubbleView.SingleBubble localSingleBubble3 = new ReadInJoyAdBubbleView.SingleBubble(this.e, -2, this.a, this.h);
    this.g.add(localSingleBubble1);
    this.g.add(localSingleBubble2);
    this.g.add(localSingleBubble3);
    this.i = new ReadInJoyAdBubbleView.UpdateUIHandler(this);
  }
  
  private void c()
  {
    Iterator localIterator = this.g.iterator();
    while (localIterator.hasNext()) {
      ((ReadInJoyAdBubbleView.SingleBubble)localIterator.next()).a();
    }
  }
  
  private void d()
  {
    e();
    this.i.removeCallbacksAndMessages(null);
    this.h.clear();
    Object localObject = this.f.mAdExtInfo;
    if (localObject == null)
    {
      ((IRIJAdLogService)QRoute.api(IRIJAdLogService.class)).d("ReadInJoyAdBubbleView", "adExtInfo is empty");
      return;
    }
    for (;;)
    {
      try
      {
        localObject = new JSONObject((String)localObject).optJSONArray("ad_bubble_texts");
        if (localObject != null)
        {
          if (((JSONArray)localObject).length() != 0) {
            break label157;
          }
          continue;
          if (k >= ((JSONArray)localObject).length()) {
            continue;
          }
          String str = (String)((JSONArray)localObject).get(k);
          if (TextUtils.isEmpty(str)) {
            break label162;
          }
          this.h.offer(str);
          break label162;
        }
        ((IRIJAdLogService)QRoute.api(IRIJAdLogService.class)).d("ReadInJoyAdBubbleView", "parseBuuble JSONArray is empty");
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        if (this.j) {
          this.i.sendEmptyMessage(2);
        }
        return;
      }
      label157:
      int k = 0;
      continue;
      label162:
      k += 1;
    }
  }
  
  private void e()
  {
    Iterator localIterator = this.g.iterator();
    int k = 0;
    while (localIterator.hasNext())
    {
      ReadInJoyAdBubbleView.SingleBubble localSingleBubble = (ReadInJoyAdBubbleView.SingleBubble)localIterator.next();
      localSingleBubble.a.setVisibility(8);
      localSingleBubble.b = k;
      k -= 1;
    }
  }
  
  public void a()
  {
    this.j = true;
    try
    {
      d();
      return;
    }
    catch (Exception localException)
    {
      label10:
      break label10;
    }
    QLog.d("ReadInJoyAdBubbleView", 2, "ReadInJoyAdBubbleView startBubble failed");
  }
  
  public void a(boolean paramBoolean)
  {
    this.j = false;
  }
  
  public int getComMeasuredHeight()
  {
    return this.b.getMeasuredHeight();
  }
  
  public int getComMeasuredWidth()
  {
    return this.b.getMeasuredWidth();
  }
  
  public View getNativeView()
  {
    return this.b;
  }
  
  public void onClick(View paramView) {}
  
  public void onComLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.b.layout(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void onComMeasure(int paramInt1, int paramInt2)
  {
    this.b.measure(paramInt1, paramInt2);
  }
  
  public void onParseValueFinished()
  {
    super.onParseValueFinished();
  }
  
  protected boolean setAttribute(int paramInt, Object paramObject)
  {
    if (paramInt != 1042) {
      return super.setAttribute(paramInt, paramObject);
    }
    if (paramObject != null) {
      try
      {
        if ((paramObject instanceof AdvertisementInfo))
        {
          this.f = ((AdvertisementInfo)paramObject);
          d();
          return true;
        }
      }
      catch (Exception paramObject)
      {
        this.f = null;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("setAttribute STR_ID_SET_AD_BANNER exception ");
        localStringBuilder.append(paramObject.toString());
        QLog.d("ReadInJoyAdBubbleView", 1, localStringBuilder.toString());
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.view.ReadInJoyAdBubbleView
 * JD-Core Version:    0.7.0.1
 */