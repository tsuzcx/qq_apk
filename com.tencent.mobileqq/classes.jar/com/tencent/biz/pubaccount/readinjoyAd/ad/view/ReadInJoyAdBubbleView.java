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
  private Context jdField_a_of_type_AndroidContentContext;
  private View jdField_a_of_type_AndroidViewView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private AdvertisementInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo;
  private ReadInJoyAdBubbleView.UpdateUIHandler jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyAdBubbleView$UpdateUIHandler;
  private List<ReadInJoyAdBubbleView.SingleBubble> jdField_a_of_type_JavaUtilList = new ArrayList();
  private Queue<String> jdField_a_of_type_JavaUtilQueue = new LinkedList();
  private boolean jdField_a_of_type_Boolean = true;
  private TextView b;
  private TextView c;
  
  public ReadInJoyAdBubbleView(VafContext paramVafContext)
  {
    super(paramVafContext);
    this.jdField_a_of_type_AndroidContentContext = paramVafContext.getContext();
    b();
  }
  
  private void b()
  {
    this.jdField_a_of_type_AndroidViewView = ((LayoutInflater)this.jdField_a_of_type_AndroidContentContext.getSystemService("layout_inflater")).inflate(2131560056, null);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131362063));
    this.b = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131362064));
    this.c = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131362065));
    ReadInJoyAdBubbleView.SingleBubble localSingleBubble1 = new ReadInJoyAdBubbleView.SingleBubble(this.jdField_a_of_type_AndroidWidgetTextView, 0, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaUtilQueue);
    ReadInJoyAdBubbleView.SingleBubble localSingleBubble2 = new ReadInJoyAdBubbleView.SingleBubble(this.b, -1, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaUtilQueue);
    ReadInJoyAdBubbleView.SingleBubble localSingleBubble3 = new ReadInJoyAdBubbleView.SingleBubble(this.c, -2, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaUtilQueue);
    this.jdField_a_of_type_JavaUtilList.add(localSingleBubble1);
    this.jdField_a_of_type_JavaUtilList.add(localSingleBubble2);
    this.jdField_a_of_type_JavaUtilList.add(localSingleBubble3);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyAdBubbleView$UpdateUIHandler = new ReadInJoyAdBubbleView.UpdateUIHandler(this);
  }
  
  private void c()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((ReadInJoyAdBubbleView.SingleBubble)localIterator.next()).a();
    }
  }
  
  private void d()
  {
    e();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyAdBubbleView$UpdateUIHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_JavaUtilQueue.clear();
    Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdExtInfo;
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
          if (i >= ((JSONArray)localObject).length()) {
            continue;
          }
          String str = (String)((JSONArray)localObject).get(i);
          if (TextUtils.isEmpty(str)) {
            break label162;
          }
          this.jdField_a_of_type_JavaUtilQueue.offer(str);
          break label162;
        }
        ((IRIJAdLogService)QRoute.api(IRIJAdLogService.class)).d("ReadInJoyAdBubbleView", "parseBuuble JSONArray is empty");
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        if (this.jdField_a_of_type_Boolean) {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyAdBubbleView$UpdateUIHandler.sendEmptyMessage(2);
        }
        return;
      }
      label157:
      int i = 0;
      continue;
      label162:
      i += 1;
    }
  }
  
  private void e()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      ReadInJoyAdBubbleView.SingleBubble localSingleBubble = (ReadInJoyAdBubbleView.SingleBubble)localIterator.next();
      localSingleBubble.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      localSingleBubble.jdField_a_of_type_Int = i;
      i -= 1;
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = true;
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
    this.jdField_a_of_type_Boolean = false;
  }
  
  public int getComMeasuredHeight()
  {
    return this.jdField_a_of_type_AndroidViewView.getMeasuredHeight();
  }
  
  public int getComMeasuredWidth()
  {
    return this.jdField_a_of_type_AndroidViewView.getMeasuredWidth();
  }
  
  public View getNativeView()
  {
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public void onClick(View paramView) {}
  
  public void onComLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.jdField_a_of_type_AndroidViewView.layout(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void onComMeasure(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_AndroidViewView.measure(paramInt1, paramInt2);
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
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo = ((AdvertisementInfo)paramObject);
          d();
          return true;
        }
      }
      catch (Exception paramObject)
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo = null;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("setAttribute STR_ID_SET_AD_BANNER exception ");
        localStringBuilder.append(paramObject.toString());
        QLog.d("ReadInJoyAdBubbleView", 1, localStringBuilder.toString());
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.view.ReadInJoyAdBubbleView
 * JD-Core Version:    0.7.0.1
 */