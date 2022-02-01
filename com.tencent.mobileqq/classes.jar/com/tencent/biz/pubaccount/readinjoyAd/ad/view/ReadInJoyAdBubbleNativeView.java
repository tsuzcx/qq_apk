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
  private Context jdField_a_of_type_AndroidContentContext;
  private View jdField_a_of_type_AndroidViewView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private AdvertisementInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo;
  private ReadInJoyAdBubbleNativeView.UpdateUIHandler jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyAdBubbleNativeView$UpdateUIHandler;
  private List<ReadInJoyAdBubbleNativeView.SingleBubble> jdField_a_of_type_JavaUtilList = new ArrayList();
  private Queue<String> jdField_a_of_type_JavaUtilQueue = new LinkedList();
  private boolean jdField_a_of_type_Boolean = true;
  private TextView b;
  private TextView c;
  
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
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((ReadInJoyAdBubbleNativeView.SingleBubble)localIterator.next()).a();
    }
  }
  
  private void b()
  {
    c();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyAdBubbleNativeView$UpdateUIHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_JavaUtilQueue.clear();
    Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdExtInfo;
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
        ((IRIJAdLogService)QRoute.api(IRIJAdLogService.class)).d("ReadInJoyAdBubbleNativeView", "parseBuuble JSONArray is empty");
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        if (this.jdField_a_of_type_Boolean) {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyAdBubbleNativeView$UpdateUIHandler.sendEmptyMessage(2);
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
  
  private void c()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      ReadInJoyAdBubbleNativeView.SingleBubble localSingleBubble = (ReadInJoyAdBubbleNativeView.SingleBubble)localIterator.next();
      localSingleBubble.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      localSingleBubble.jdField_a_of_type_Int = i;
      i -= 1;
    }
  }
  
  public void a(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewView = ((LayoutInflater)this.jdField_a_of_type_AndroidContentContext.getSystemService("layout_inflater")).inflate(2131560057, this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131362063));
    this.b = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131362064));
    this.c = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131362065));
    paramContext = new ReadInJoyAdBubbleNativeView.SingleBubble(this.jdField_a_of_type_AndroidWidgetTextView, 0, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaUtilQueue);
    ReadInJoyAdBubbleNativeView.SingleBubble localSingleBubble1 = new ReadInJoyAdBubbleNativeView.SingleBubble(this.b, -1, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaUtilQueue);
    ReadInJoyAdBubbleNativeView.SingleBubble localSingleBubble2 = new ReadInJoyAdBubbleNativeView.SingleBubble(this.c, -2, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaUtilQueue);
    this.jdField_a_of_type_JavaUtilList.add(paramContext);
    this.jdField_a_of_type_JavaUtilList.add(localSingleBubble1);
    this.jdField_a_of_type_JavaUtilList.add(localSingleBubble2);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyAdBubbleNativeView$UpdateUIHandler = new ReadInJoyAdBubbleNativeView.UpdateUIHandler(this);
  }
  
  public void a(AdvertisementInfo paramAdvertisementInfo)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo = paramAdvertisementInfo;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.view.ReadInJoyAdBubbleNativeView
 * JD-Core Version:    0.7.0.1
 */