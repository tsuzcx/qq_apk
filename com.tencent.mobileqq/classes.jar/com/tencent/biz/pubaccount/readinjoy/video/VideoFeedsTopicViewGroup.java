package com.tencent.biz.pubaccount.readinjoy.video;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.pubaccount.PublicAccountReportUtils;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.VideoInfo.ChannelInfo;
import com.tencent.biz.pubaccount.VideoReporter;
import com.tencent.mobileqq.util.DisplayUtil;
import java.util.ArrayList;
import java.util.Set;
import mdk;
import org.json.JSONObject;

public class VideoFeedsTopicViewGroup
  extends LinearLayout
{
  private int jdField_a_of_type_Int;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Context jdField_a_of_type_AndroidContentContext;
  private VideoInfo jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
  private VideoFeedsAdapter jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter;
  private Set jdField_a_of_type_JavaUtilSet;
  private boolean jdField_a_of_type_Boolean;
  private final int b = 12;
  private final int c = 6;
  private final int d = 10;
  private final int e = 15;
  
  public VideoFeedsTopicViewGroup(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public VideoFeedsTopicViewGroup(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  @TargetApi(11)
  public VideoFeedsTopicViewGroup(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  private void a()
  {
    int j;
    int i;
    label71:
    Object localObject1;
    String str;
    if ((this.jdField_a_of_type_Int != 0) && (!this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null))
    {
      removeAllViews();
      if ((this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a == null) || (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a.size() == 0))
      {
        setVisibility(8);
        j = this.jdField_a_of_type_Int;
        if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a == null) {
          break label551;
        }
        i = 0;
        if (i >= this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a.size()) {
          break label551;
        }
        localObject1 = (VideoInfo.ChannelInfo)this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a.get(i);
        str = ((VideoInfo.ChannelInfo)localObject1).a;
        if (!TextUtils.isEmpty(str)) {
          break label131;
        }
      }
    }
    for (;;)
    {
      i += 1;
      break label71;
      setVisibility(0);
      break;
      label131:
      Object localObject2 = new TextView(this.jdField_a_of_type_AndroidContentContext);
      ((TextView)localObject2).setTextSize(2, 12.0F);
      Object localObject3 = new Rect();
      ((TextView)localObject2).getPaint().getTextBounds("#" + str, 0, str.length() + 1, (Rect)localObject3);
      int m = ((Rect)localObject3).width();
      int k;
      if (i == 0)
      {
        k = DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 15.0F);
        label220:
        k += m;
        if (j < k) {
          break label551;
        }
        localObject2 = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
        localObject3 = new LinearLayout.LayoutParams(-2, -1);
        if (i != 0) {
          break label524;
        }
        ((LinearLayout.LayoutParams)localObject3).setMargins(DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 15.0F), 0, 0, DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 2.0F));
        label283:
        TextView localTextView = new TextView(this.jdField_a_of_type_AndroidContentContext);
        localTextView.setText("#");
        localTextView.setTextColor(Color.parseColor("#07D0B0"));
        localTextView.setTextSize(2, 12.0F);
        localTextView.setId(2131362203);
        ((LinearLayout)localObject2).addView(localTextView);
        localTextView = new TextView(this.jdField_a_of_type_AndroidContentContext);
        localTextView.setText(str);
        localTextView.setTextColor(Color.argb(255, 167, 167, 166));
        localTextView.setTextSize(2, 12.0F);
        localTextView.setId(2131362203);
        ((LinearLayout)localObject2).addView(localTextView);
        ((LinearLayout)localObject2).setId(2131362202);
        ((LinearLayout)localObject2).setTag(localObject1);
        ((LinearLayout)localObject2).setOnClickListener(new mdk(this, (VideoInfo.ChannelInfo)localObject1));
        addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
        if (!this.jdField_a_of_type_JavaUtilSet.contains(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.g)) {
          localObject1 = new JSONObject();
        }
      }
      try
      {
        ((JSONObject)localObject1).put("channel_id", 409409);
        label472:
        PublicAccountReportUtils.a(null, "", "0X80088BA", "0X80088BA", 0, 0, "3", "", "", VideoReporter.a("", "", "", "", (JSONObject)localObject1), false);
        j -= k;
        continue;
        k = DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 10.0F);
        break label220;
        label524:
        ((LinearLayout.LayoutParams)localObject3).setMargins(DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 10.0F), 0, 0, DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 2.0F));
        break label283;
        label551:
        this.jdField_a_of_type_JavaUtilSet.add(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.g);
        this.jdField_a_of_type_Boolean = true;
        return;
      }
      catch (Exception localException)
      {
        break label472;
      }
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int j = getDefaultSize(0, paramInt1);
    int i = j;
    if (j == 0) {
      i = this.jdField_a_of_type_Int;
    }
    this.jdField_a_of_type_Int = i;
    a();
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public void setArticleInfo(Activity paramActivity, VideoFeedsAdapter paramVideoFeedsAdapter, VideoInfo paramVideoInfo, Set paramSet)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter = paramVideoFeedsAdapter;
    this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo = paramVideoInfo;
    this.jdField_a_of_type_JavaUtilSet = paramSet;
    this.jdField_a_of_type_Boolean = false;
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsTopicViewGroup
 * JD-Core Version:    0.7.0.1
 */