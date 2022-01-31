package com.tencent.mobileqq.activity.qwallet.redpacket.specify;

import ahfg;
import ahiw;
import ajya;
import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewPropertyAnimator;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import aycd;
import baxn;
import bayh;
import bbcz;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.QQWalletRedPacketMsg;
import com.tencent.mobileqq.surfaceviewaction.gl.SpriteVideoView;
import java.util.Iterator;
import java.util.List;

public class SpecifyGiftView
  extends RelativeLayout
{
  private int jdField_a_of_type_Int;
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private MessageForQQWalletMsg jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg;
  private SpriteVideoView jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteVideoView;
  private boolean jdField_a_of_type_Boolean = true;
  private int b;
  
  public SpecifyGiftView(Context paramContext, MessageForQQWalletMsg paramMessageForQQWalletMsg)
  {
    super(paramContext);
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg = paramMessageForQQWalletMsg;
    LinearLayout localLinearLayout = new LinearLayout(paramContext);
    addView(localLinearLayout);
    localLinearLayout.setOrientation(1);
    Object localObject = (RelativeLayout.LayoutParams)localLinearLayout.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).width = -2;
    ((RelativeLayout.LayoutParams)localObject).height = -2;
    ((RelativeLayout.LayoutParams)localObject).addRule(13, -1);
    this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteVideoView = new SpriteVideoView(paramContext, true);
    this.jdField_a_of_type_Int = baxn.a(paramContext, 325.0F);
    this.b = baxn.a(paramContext, 350.0F);
    this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteVideoView.setPivotX(this.jdField_a_of_type_Int / 2);
    this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteVideoView.setPivotY(this.b / 2);
    paramContext = new RelativeLayout(paramContext);
    paramContext.addView(this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteVideoView);
    localLinearLayout.addView(paramContext);
    localObject = (LinearLayout.LayoutParams)paramContext.getLayoutParams();
    ((LinearLayout.LayoutParams)localObject).width = this.jdField_a_of_type_Int;
    ((LinearLayout.LayoutParams)localObject).height = this.b;
    ((LinearLayout.LayoutParams)localObject).gravity = 1;
    this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteVideoView.setId(2131373608);
    this.jdField_a_of_type_AndroidViewView = a(paramMessageForQQWalletMsg, localLinearLayout);
    paramMessageForQQWalletMsg = new ImageView(getContext());
    paramContext.addView(paramMessageForQQWalletMsg);
    paramContext = (RelativeLayout.LayoutParams)paramMessageForQQWalletMsg.getLayoutParams();
    paramContext.width = baxn.a(getContext(), 40.0F);
    paramContext.height = baxn.a(getContext(), 40.0F);
    paramContext.topMargin = baxn.a(getContext(), 20.0F);
    paramContext.addRule(7, 2131373608);
    paramContext.addRule(6, 2131373608);
    paramMessageForQQWalletMsg.setScaleType(ImageView.ScaleType.FIT_XY);
    int i = baxn.a(getContext(), 16.0F);
    paramMessageForQQWalletMsg.setPadding(i, 0, 0, i);
    paramMessageForQQWalletMsg.setImageResource(2130846264);
    this.jdField_a_of_type_AndroidWidgetImageView = paramMessageForQQWalletMsg;
  }
  
  private View a(MessageForQQWalletMsg paramMessageForQQWalletMsg, LinearLayout paramLinearLayout)
  {
    QQAppInterface localQQAppInterface = ahiw.a();
    if (localQQAppInterface == null) {
      return null;
    }
    int i = baxn.a(getContext(), 15.0F);
    RelativeLayout localRelativeLayout = new RelativeLayout(getContext());
    paramLinearLayout.addView(localRelativeLayout);
    paramLinearLayout = (LinearLayout.LayoutParams)localRelativeLayout.getLayoutParams();
    paramLinearLayout.width = -2;
    paramLinearLayout.height = (baxn.a(getContext(), 100.0F) + i);
    paramLinearLayout.gravity = 1;
    paramLinearLayout = new LinearLayout(getContext());
    localRelativeLayout.addView(paramLinearLayout);
    paramLinearLayout.setBackgroundResource(2130846439);
    paramLinearLayout.setOrientation(1);
    Object localObject1 = (RelativeLayout.LayoutParams)paramLinearLayout.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject1).width = -2;
    ((RelativeLayout.LayoutParams)localObject1).height = (baxn.a(getContext(), 70.0F) + i * 2);
    ((RelativeLayout.LayoutParams)localObject1).addRule(12, -1);
    ((RelativeLayout.LayoutParams)localObject1).addRule(14, -1);
    paramLinearLayout.setPadding(baxn.a(getContext(), 30.0F), i, baxn.a(getContext(), 30.0F), i);
    TextView localTextView1 = new TextView(getContext());
    localTextView1.setTextColor(-16777216);
    localTextView1.setTextSize(1, 11.0F);
    paramLinearLayout.addView(localTextView1);
    localObject1 = (LinearLayout.LayoutParams)localTextView1.getLayoutParams();
    ((LinearLayout.LayoutParams)localObject1).width = -2;
    ((LinearLayout.LayoutParams)localObject1).height = -2;
    ((LinearLayout.LayoutParams)localObject1).gravity = 1;
    ((LinearLayout.LayoutParams)localObject1).topMargin = baxn.a(getContext(), 20.0F);
    TextView localTextView2 = new TextView(getContext());
    localTextView2.setTextColor(-16777216);
    localTextView2.setTextSize(1, 18.0F);
    paramLinearLayout.addView(localTextView2);
    paramLinearLayout = (LinearLayout.LayoutParams)localTextView2.getLayoutParams();
    paramLinearLayout.width = -2;
    paramLinearLayout.height = -2;
    paramLinearLayout.gravity = 1;
    paramLinearLayout = new LinearLayout(getContext());
    paramLinearLayout.setOrientation(0);
    localRelativeLayout.addView(paramLinearLayout);
    localObject1 = (RelativeLayout.LayoutParams)paramLinearLayout.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject1).width = -2;
    ((RelativeLayout.LayoutParams)localObject1).height = -2;
    ((RelativeLayout.LayoutParams)localObject1).addRule(14, -1);
    i = baxn.a(getContext(), 1.0F);
    ImageView localImageView = new ImageView(getContext());
    paramLinearLayout.addView(localImageView);
    localObject1 = (LinearLayout.LayoutParams)localImageView.getLayoutParams();
    ((LinearLayout.LayoutParams)localObject1).width = baxn.a(getContext(), 40.0F);
    ((LinearLayout.LayoutParams)localObject1).height = baxn.a(getContext(), 40.0F);
    localImageView.setScaleType(ImageView.ScaleType.FIT_XY);
    localImageView.setPadding(i, i, i, i);
    localImageView.setBackgroundResource(2130846438);
    View localView = new View(getContext());
    paramLinearLayout.addView(localView);
    localObject1 = (LinearLayout.LayoutParams)localView.getLayoutParams();
    ((LinearLayout.LayoutParams)localObject1).width = baxn.a(getContext(), 13.0F);
    ((LinearLayout.LayoutParams)localObject1).height = baxn.a(getContext(), 10.0F);
    ((LinearLayout.LayoutParams)localObject1).leftMargin = baxn.a(getContext(), 13.0F);
    ((LinearLayout.LayoutParams)localObject1).rightMargin = baxn.a(getContext(), 23.0F);
    ((LinearLayout.LayoutParams)localObject1).gravity = 16;
    localObject1 = paramMessageForQQWalletMsg.mQQWalletRedPacketMsg.specifyUinList.iterator();
    long l;
    while (((Iterator)localObject1).hasNext())
    {
      l = ((Long)((Iterator)localObject1).next()).longValue();
      localObject2 = new ImageView(getContext());
      paramLinearLayout.addView((View)localObject2);
      localObject3 = (LinearLayout.LayoutParams)((ImageView)localObject2).getLayoutParams();
      ((LinearLayout.LayoutParams)localObject3).width = baxn.a(getContext(), 40.0F);
      ((LinearLayout.LayoutParams)localObject3).height = baxn.a(getContext(), 40.0F);
      ((ImageView)localObject2).setScaleType(ImageView.ScaleType.FIT_XY);
      ((LinearLayout.LayoutParams)localObject3).leftMargin = (-baxn.a(getContext(), 10.0F));
      ((ImageView)localObject2).setImageDrawable(bayh.a(localQQAppInterface, String.valueOf(l), (byte)3));
      ((ImageView)localObject2).setBackgroundResource(2130846438);
      ((ImageView)localObject2).setPadding(i, i, i, i);
    }
    paramLinearLayout = bbcz.b(localQQAppInterface, paramMessageForQQWalletMsg.senderuin, true);
    Object localObject3 = ahiw.a(getContext(), paramLinearLayout, 90.0F, localTextView1.getPaint());
    Object localObject2 = paramMessageForQQWalletMsg.mQQWalletRedPacketMsg.specifyUinList.iterator();
    paramLinearLayout = "";
    i = 0;
    localObject1 = paramLinearLayout;
    String str;
    if (((Iterator)localObject2).hasNext())
    {
      l = ((Long)((Iterator)localObject2).next()).longValue();
      str = bbcz.b(localQQAppInterface, l + "", true);
      if (i <= 0) {
        break label1166;
      }
    }
    label1166:
    for (localObject1 = paramLinearLayout + "、";; localObject1 = paramLinearLayout)
    {
      localObject1 = (String)localObject1 + str;
      if ((i > 0) && (((String)localObject1).length() > 13)) {}
      for (;;)
      {
        i += 1;
        if (i >= 2)
        {
          localObject1 = paramLinearLayout;
          localObject2 = (String)localObject3 + ajya.a(2131714282) + (String)localObject1;
          i = paramMessageForQQWalletMsg.mQQWalletRedPacketMsg.specifyUinList.size();
          paramLinearLayout = (LinearLayout)localObject2;
          if (i >= 2) {
            paramLinearLayout = (String)localObject2 + ajya.a(2131714279) + i + ajya.a(2131714280);
          }
          paramLinearLayout = new SpannableStringBuilder(paramLinearLayout);
          paramLinearLayout.setSpan(new ForegroundColorSpan(-1694379), 0, ((String)localObject3).length(), 33);
          paramLinearLayout.setSpan(new StyleSpan(1), 0, ((String)localObject3).length(), 33);
          paramLinearLayout.setSpan(new ForegroundColorSpan(-1694379), ((String)localObject3).length() + 2, ((String)localObject3).length() + 3 + ((String)localObject1).length(), 33);
          localObject2 = new StyleSpan(1);
          i = ((String)localObject3).length();
          int j = ((String)localObject3).length();
          paramLinearLayout.setSpan(localObject2, i + 2, ((String)localObject1).length() + (j + 3), 33);
          localTextView1.setText(paramLinearLayout);
          localTextView1.setMaxLines(1);
          localTextView2.setText(ajya.a(2131714281));
          localImageView.setImageDrawable(bayh.a(localQQAppInterface, String.valueOf(paramMessageForQQWalletMsg.senderuin), (byte)3));
          localView.setBackgroundResource(2130846437);
          return localRelativeLayout;
        }
        break;
        paramLinearLayout = (LinearLayout)localObject1;
      }
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteVideoView != null) {
      this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteVideoView.a();
    }
  }
  
  public void a(String paramString, aycd paramaycd, View.OnClickListener paramOnClickListener)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteVideoView.a(paramString, paramaycd);
      if (this.jdField_a_of_type_AndroidViewView != null)
      {
        this.jdField_a_of_type_AndroidViewView.setAlpha(0.0F);
        this.jdField_a_of_type_AndroidViewView.animate().alpha(1.0F).setDuration(500L).start();
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new ahfg(this, paramaycd, paramOnClickListener));
      ahiw.a(this.jdField_a_of_type_AndroidWidgetImageView, 0.6F);
      return;
      if (paramaycd != null) {
        paramaycd.a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.redpacket.specify.SpecifyGiftView
 * JD-Core Version:    0.7.0.1
 */