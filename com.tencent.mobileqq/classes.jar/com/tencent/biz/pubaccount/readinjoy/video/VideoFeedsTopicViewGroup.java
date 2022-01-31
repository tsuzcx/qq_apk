package com.tencent.biz.pubaccount.readinjoy.video;

import actj;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import baxn;
import bfnz;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.VideoInfo.ChannelInfo;
import java.util.ArrayList;
import java.util.Set;
import qlp;
import qoi;
import qtg;

public class VideoFeedsTopicViewGroup
  extends LinearLayout
{
  private int jdField_a_of_type_Int;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Context jdField_a_of_type_AndroidContentContext;
  private VideoInfo jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
  private Set<String> jdField_a_of_type_JavaUtilSet;
  private qlp jdField_a_of_type_Qlp;
  private boolean jdField_a_of_type_Boolean;
  private final int jdField_b_of_type_Int = 13;
  private boolean jdField_b_of_type_Boolean;
  private final int c = 4;
  private int d;
  
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
    int j = this.jdField_a_of_type_Int - getPaddingLeft() - getPaddingRight() - this.d;
    if (((j <= 0) && (this.jdField_a_of_type_Int > 0)) || (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo == null)) {
      setVisibility(8);
    }
    int i;
    label107:
    VideoInfo.ChannelInfo localChannelInfo;
    Object localObject1;
    if ((j > 0) && (!this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null))
    {
      removeAllViews();
      if ((this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a == null) || (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a.size() == 0))
      {
        setVisibility(8);
        if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a == null) {
          break label510;
        }
        i = 0;
        if (i >= this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a.size()) {
          break label510;
        }
        localChannelInfo = (VideoInfo.ChannelInfo)this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a.get(i);
        localObject1 = localChannelInfo.a;
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          break label182;
        }
      }
    }
    for (;;)
    {
      i += 1;
      break label107;
      setVisibility(0);
      if (getWidth() != 0) {
        break;
      }
      qoi.a(this, 200);
      break;
      label182:
      TextView localTextView = new TextView(this.jdField_a_of_type_AndroidContentContext);
      localTextView.setText((CharSequence)localObject1);
      localTextView.setGravity(17);
      localTextView.setTextColor(Color.parseColor("#FFFFFF"));
      localTextView.setTextSize(2, 13.0F);
      localTextView.setId(2131374776);
      Object localObject2 = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130842442);
      ((Drawable)localObject2).setBounds(0, 0, actj.a(18.0F, getResources()), actj.a(18.0F, getResources()));
      localTextView.setCompoundDrawables((Drawable)localObject2, null, null, null);
      int m = baxn.a(this.jdField_a_of_type_AndroidContentContext, 4.0F);
      localTextView.setCompoundDrawablePadding(m);
      if (bfnz.g()) {
        localTextView.setBackground(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130842200));
      }
      localTextView.setPadding(actj.a(4.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), 0, actj.a(4.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), 0);
      TextPaint localTextPaint = localTextView.getPaint();
      localObject2 = new Rect();
      try
      {
        localTextPaint.getTextBounds((String)localObject1, 0, ((String)localObject1).length(), (Rect)localObject2);
        label386:
        int n = ((Rect)localObject2).width();
        int i1 = localTextView.getCompoundDrawables()[0].getIntrinsicWidth();
        int k;
        if (i == 0)
        {
          k = 0;
          label411:
          k += m * 4 + (n + i1);
          if (j < k) {
            break label497;
          }
          j -= k;
          localObject1 = new LinearLayout.LayoutParams(-2, -1);
          if (i != 0) {
            break label533;
          }
          ((LinearLayout.LayoutParams)localObject1).setMargins(0, 0, 0, 0);
        }
        for (;;)
        {
          localTextView.setOnClickListener(new qtg(this, localChannelInfo));
          addView(localTextView, (ViewGroup.LayoutParams)localObject1);
          break;
          k = baxn.a(this.jdField_a_of_type_AndroidContentContext, 4.0F);
          break label411;
          label497:
          if (getChildCount() == 0) {
            setVisibility(8);
          }
          label510:
          this.jdField_a_of_type_JavaUtilSet.add(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.g);
          this.jdField_a_of_type_Boolean = true;
          return;
          label533:
          ((LinearLayout.LayoutParams)localObject1).setMargins(baxn.a(this.jdField_a_of_type_AndroidContentContext, 4.0F), 0, 0, 0);
        }
      }
      catch (Exception localException)
      {
        break label386;
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
  
  public void setArticleInfo(Activity paramActivity, qlp paramqlp, VideoInfo paramVideoInfo, Set<String> paramSet, boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_Qlp = paramqlp;
    this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo = paramVideoInfo;
    this.jdField_a_of_type_JavaUtilSet = paramSet;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = paramBoolean;
    a();
  }
  
  public void setHorizontalMargin(int paramInt)
  {
    this.d = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsTopicViewGroup
 * JD-Core Version:    0.7.0.1
 */