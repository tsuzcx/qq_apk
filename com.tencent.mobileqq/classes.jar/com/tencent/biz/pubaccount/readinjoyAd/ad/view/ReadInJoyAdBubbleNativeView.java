package com.tencent.biz.pubaccount.readinjoyAd.ad.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
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

public class ReadInJoyAdBubbleNativeView
  extends FrameLayout
  implements View.OnClickListener
{
  private Context a;
  private View b;
  private TextView c;
  private TextView d;
  private TextView e;
  private AdvertisementInfo f;
  private List<ReadInJoyAdBubbleNativeView.SingleBubble> g = new ArrayList();
  private Queue<String> h = new LinkedList();
  private ReadInJoyAdBubbleNativeView.UpdateUIHandler i;
  private boolean j = true;
  
  public ReadInJoyAdBubbleNativeView(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ReadInJoyAdBubbleNativeView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ReadInJoyAdBubbleNativeView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private void a()
  {
    Iterator localIterator = this.g.iterator();
    while (localIterator.hasNext()) {
      ((ReadInJoyAdBubbleNativeView.SingleBubble)localIterator.next()).a();
    }
  }
  
  private void b()
  {
    c();
    this.i.removeCallbacksAndMessages(null);
    this.h.clear();
    Object localObject = this.f.mAdExtInfo;
    if (localObject == null)
    {
      ((IRIJAdLogService)QRoute.api(IRIJAdLogService.class)).d("ReadInJoyAdBubbleNativeView", "adExtInfo is empty");
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
        ((IRIJAdLogService)QRoute.api(IRIJAdLogService.class)).d("ReadInJoyAdBubbleNativeView", "parseBuuble JSONArray is empty");
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
  
  private void c()
  {
    Iterator localIterator = this.g.iterator();
    int k = 0;
    while (localIterator.hasNext())
    {
      ReadInJoyAdBubbleNativeView.SingleBubble localSingleBubble = (ReadInJoyAdBubbleNativeView.SingleBubble)localIterator.next();
      localSingleBubble.a.setVisibility(8);
      localSingleBubble.b = k;
      k -= 1;
    }
  }
  
  public void a(Context paramContext)
  {
    this.a = paramContext;
    this.b = ((LayoutInflater)this.a.getSystemService("layout_inflater")).inflate(2131626102, this);
    this.c = ((TextView)this.b.findViewById(2131427641));
    this.d = ((TextView)this.b.findViewById(2131427642));
    this.e = ((TextView)this.b.findViewById(2131427643));
    paramContext = new ReadInJoyAdBubbleNativeView.SingleBubble(this.c, 0, this.a, this.h);
    ReadInJoyAdBubbleNativeView.SingleBubble localSingleBubble1 = new ReadInJoyAdBubbleNativeView.SingleBubble(this.d, -1, this.a, this.h);
    ReadInJoyAdBubbleNativeView.SingleBubble localSingleBubble2 = new ReadInJoyAdBubbleNativeView.SingleBubble(this.e, -2, this.a, this.h);
    this.g.add(paramContext);
    this.g.add(localSingleBubble1);
    this.g.add(localSingleBubble2);
    this.i = new ReadInJoyAdBubbleNativeView.UpdateUIHandler(this);
  }
  
  public void a(AdvertisementInfo paramAdvertisementInfo)
  {
    this.j = true;
    this.f = paramAdvertisementInfo;
    try
    {
      b();
      return;
    }
    catch (Exception paramAdvertisementInfo)
    {
      label15:
      break label15;
    }
    QLog.d("ReadInJoyAdBubbleNativeView", 2, "ReadInJoyAdBubbleView startBubble failed");
  }
  
  public void onClick(View paramView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.view.ReadInJoyAdBubbleNativeView
 * JD-Core Version:    0.7.0.1
 */