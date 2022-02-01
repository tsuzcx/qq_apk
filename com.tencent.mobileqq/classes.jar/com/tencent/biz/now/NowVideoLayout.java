package com.tencent.biz.now;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.structmsg.StructMsgItemLive;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.StringUtil;
import java.util.HashMap;

public class NowVideoLayout
  extends RelativeLayout
{
  NowVideoView jdField_a_of_type_ComTencentBizNowNowVideoView;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  MessageRecord jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
  StructMsgItemLive jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgItemLive;
  HashMap<String, String> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  
  public NowVideoLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public void a()
  {
    Object localObject = getContext().getResources();
    this.jdField_a_of_type_ComTencentBizNowNowVideoView = new NowVideoView(getContext());
    this.jdField_a_of_type_ComTencentBizNowNowVideoView.setId(2131378575);
    this.jdField_a_of_type_ComTencentBizNowNowVideoView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    this.jdField_a_of_type_ComTencentBizNowNowVideoView.setUseRadiusRound(true, getContext().getResources().getDimensionPixelSize(2131296464));
    this.jdField_a_of_type_ComTencentBizNowNowVideoView.setContentDescription(getContext().getResources().getText(2131719540));
    localObject = new RelativeLayout.LayoutParams(AIOUtils.a(156.0F, (Resources)localObject), AIOUtils.a(209.0F, (Resources)localObject));
    addView(this.jdField_a_of_type_ComTencentBizNowNowVideoView, (ViewGroup.LayoutParams)localObject);
    localObject = new ImageView(getContext());
    ((ImageView)localObject).setImageResource(2130843459);
    ((ImageView)localObject).setId(2131373246);
    ((ImageView)localObject).setVisibility(8);
    int i = AIOUtils.a(60.0F, getResources());
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(i, i);
    localLayoutParams.addRule(13);
    addView((View)localObject, localLayoutParams);
    this.jdField_a_of_type_ComTencentBizNowNowVideoView.a((ImageView)localObject);
  }
  
  public void a(int paramInt, String paramString)
  {
    Object localObject = findViewById(2131378577);
    ImageView localImageView;
    String str2;
    TextView localTextView2;
    TextView localTextView1;
    if (localObject == null)
    {
      localImageView = new ImageView(getContext());
      localImageView.setId(2131378577);
      localObject = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject).addRule(9);
      ((RelativeLayout.LayoutParams)localObject).addRule(10);
      ((RelativeLayout.LayoutParams)localObject).setMargins(AIOUtils.a(10.0F, getResources()), AIOUtils.a(10.0F, getResources()), 0, 0);
      localImageView.setImageResource(2130844112);
      addView(localImageView, (ViewGroup.LayoutParams)localObject);
      localObject = getParent();
      str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
      if (!(localObject instanceof LinearLayout)) {
        break label646;
      }
      localObject = (LinearLayout)localObject;
      localTextView2 = (TextView)((LinearLayout)localObject).findViewById(2131380647);
      localTextView1 = (TextView)((LinearLayout)localObject).findViewById(2131380651);
    }
    for (;;)
    {
      String str1;
      label169:
      boolean bool;
      if (this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgItemLive == null)
      {
        str1 = "";
        localObject = str2;
        if (str2 == null)
        {
          str2 = ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString);
          localObject = str2;
          if (str2 != null)
          {
            localObject = str2;
            if (!str2.equals(paramString)) {
              localObject = StringUtil.a(str2, 10);
            }
          }
          this.jdField_a_of_type_JavaUtilHashMap.put(paramString, localObject);
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgItemLive == null) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgItemLive.ag))) {
          break label435;
        }
        paramString = (String)localObject + getContext().getText(2131697658).toString();
        label283:
        bool = ((NowLiveManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.NOW_LIVE_MANAGER)).a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.time);
        switch (paramInt)
        {
        default: 
          localImageView.setVisibility(4);
          label350:
          localObject = paramString;
          if (localTextView1 != null)
          {
            if (TextUtils.isEmpty(str1)) {
              break label633;
            }
            localTextView1.setText(str1);
            localObject = paramString + ":";
            localTextView1.setVisibility(0);
          }
          break;
        }
      }
      for (;;)
      {
        if (localTextView2 != null) {
          localTextView2.setText((CharSequence)localObject);
        }
        return;
        localImageView = (ImageView)localObject;
        break;
        str1 = this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgItemLive.ah;
        break label169;
        label435:
        paramString = (String)localObject + getContext().getText(2131697656).toString();
        break label283;
        localImageView.setVisibility(4);
        if (!bool) {
          break label350;
        }
        paramString = (String)localObject + getContext().getText(2131697657);
        break label350;
        localImageView.setVisibility(0);
        paramString = (String)localObject + getContext().getText(2131697657);
        break label350;
        localImageView.setVisibility(0);
        paramString = (String)localObject + getContext().getText(2131697656).toString();
        break label350;
        localImageView.setVisibility(0);
        paramString = (String)localObject + getContext().getText(2131697658).toString();
        break label350;
        label633:
        localTextView1.setVisibility(8);
        localObject = paramString;
      }
      label646:
      localTextView1 = null;
      localTextView2 = null;
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, StructMsgItemLive paramStructMsgItemLive, MessageRecord paramMessageRecord)
  {
    this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgItemLive = paramStructMsgItemLive;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = paramMessageRecord;
    if (this.jdField_a_of_type_ComTencentBizNowNowVideoView != null)
    {
      if (paramQQAppInterface != null) {
        break label166;
      }
      paramStructMsgItemLive = URLDrawable.getDrawable(paramStructMsgItemLive.ad, paramStructMsgItemLive.o, paramStructMsgItemLive.p);
      this.jdField_a_of_type_ComTencentBizNowNowVideoView.setImageDrawable(paramStructMsgItemLive);
      this.jdField_a_of_type_ComTencentBizNowNowVideoView.a(this.jdField_a_of_type_ComTencentBizNowNowVideoView.a);
    }
    for (;;)
    {
      boolean bool = false;
      paramStructMsgItemLive = null;
      if (paramQQAppInterface != null)
      {
        paramQQAppInterface = (NowLiveManager)paramQQAppInterface.getManager(QQManagerFactory.NOW_LIVE_MANAGER);
        bool = paramQQAppInterface.a(paramMessageRecord.frienduin, paramMessageRecord.time);
        paramStructMsgItemLive = paramQQAppInterface.a(paramMessageRecord.frienduin, paramMessageRecord.time);
      }
      if (!bool) {
        break label199;
      }
      if ((paramStructMsgItemLive == null) || ((paramStructMsgItemLive.a != 1) && (paramStructMsgItemLive.a != 2))) {
        break label189;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgItemLive == null) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgItemLive.ag))) {
        break;
      }
      a(3, paramMessageRecord.senderuin);
      return;
      label166:
      this.jdField_a_of_type_ComTencentBizNowNowVideoView.a(paramQQAppInterface, paramStructMsgItemLive, paramMessageRecord);
    }
    a(2, paramMessageRecord.senderuin);
    return;
    label189:
    a(1, paramMessageRecord.senderuin);
    return;
    label199:
    if ((this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgItemLive != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgItemLive.ag)))
    {
      a(3, paramMessageRecord.senderuin);
      return;
    }
    a(2, paramMessageRecord.senderuin);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.now.NowVideoLayout
 * JD-Core Version:    0.7.0.1
 */