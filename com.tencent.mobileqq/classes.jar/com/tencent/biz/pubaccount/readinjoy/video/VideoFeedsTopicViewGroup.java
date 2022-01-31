package com.tencent.biz.pubaccount.readinjoy.video;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.VideoInfo.ChannelInfo;
import com.tencent.mobileqq.util.DisplayUtil;
import java.util.ArrayList;
import java.util.Set;
import mic;

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
  private final int jdField_b_of_type_Int = 12;
  private boolean jdField_b_of_type_Boolean;
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
    VideoInfo.ChannelInfo localChannelInfo;
    String str;
    if ((this.jdField_a_of_type_Int != 0) && (!this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null))
    {
      removeAllViews();
      if ((this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a == null) || (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a.size() == 0))
      {
        setVisibility(8);
        j = this.jdField_a_of_type_Int;
        if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a == null) {
          break label495;
        }
        i = 0;
        if (i >= this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a.size()) {
          break label495;
        }
        localChannelInfo = (VideoInfo.ChannelInfo)this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a.get(i);
        str = localChannelInfo.a;
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
      Object localObject1 = new Rect();
      localObject2 = ((TextView)localObject2).getPaint();
      Object localObject3 = "# " + str;
      try
      {
        ((Paint)localObject2).getTextBounds((String)localObject3, 0, ((String)localObject3).length(), (Rect)localObject1);
        label205:
        int m = ((Rect)localObject1).width();
        int k;
        if (i == 0)
        {
          k = DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 15.0F);
          label226:
          k += m;
          if (j < k) {
            break label495;
          }
          j -= k;
          localObject1 = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
          localObject2 = new LinearLayout.LayoutParams(-2, -1);
          if (i != 0) {
            break label468;
          }
          ((LinearLayout.LayoutParams)localObject2).setMargins(DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 15.0F), 0, 0, DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 2.0F));
        }
        for (;;)
        {
          localObject3 = new TextView(this.jdField_a_of_type_AndroidContentContext);
          ((TextView)localObject3).setText("# ");
          ((TextView)localObject3).getPaint().setFakeBoldText(true);
          ((TextView)localObject3).setTextColor(Color.parseColor("#07D0B0"));
          ((TextView)localObject3).setTextSize(2, 12.0F);
          ((TextView)localObject3).setId(2131362203);
          ((LinearLayout)localObject1).addView((View)localObject3);
          localObject3 = new TextView(this.jdField_a_of_type_AndroidContentContext);
          ((TextView)localObject3).getPaint().setFakeBoldText(true);
          ((TextView)localObject3).setText(str);
          ((TextView)localObject3).setTextColor(Color.parseColor("#FFFFFF"));
          ((TextView)localObject3).setTextSize(2, 12.0F);
          ((TextView)localObject3).setId(2131362203);
          ((LinearLayout)localObject1).addView((View)localObject3);
          ((LinearLayout)localObject1).setId(2131362202);
          ((LinearLayout)localObject1).setTag(localChannelInfo);
          ((LinearLayout)localObject1).setOnClickListener(new mic(this, localChannelInfo));
          addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
          break;
          k = DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 10.0F);
          break label226;
          label468:
          ((LinearLayout.LayoutParams)localObject2).setMargins(DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 10.0F), 0, 0, DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 2.0F));
        }
        label495:
        this.jdField_a_of_type_JavaUtilSet.add(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.g);
        this.jdField_a_of_type_Boolean = true;
        return;
      }
      catch (Exception localException)
      {
        break label205;
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
  
  public void setArticleInfo(Activity paramActivity, VideoFeedsAdapter paramVideoFeedsAdapter, VideoInfo paramVideoInfo, Set paramSet, boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter = paramVideoFeedsAdapter;
    this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo = paramVideoInfo;
    this.jdField_a_of_type_JavaUtilSet = paramSet;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = paramBoolean;
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsTopicViewGroup
 * JD-Core Version:    0.7.0.1
 */