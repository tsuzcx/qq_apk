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
    this.jdField_a_of_type_ComTencentBizNowNowVideoView.setId(2131377986);
    this.jdField_a_of_type_ComTencentBizNowNowVideoView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    this.jdField_a_of_type_ComTencentBizNowNowVideoView.setUseRadiusRound(true, getContext().getResources().getDimensionPixelSize(2131296443));
    this.jdField_a_of_type_ComTencentBizNowNowVideoView.setContentDescription(getContext().getResources().getText(2131719258));
    localObject = new RelativeLayout.LayoutParams(AIOUtils.b(156.0F, (Resources)localObject), AIOUtils.b(209.0F, (Resources)localObject));
    addView(this.jdField_a_of_type_ComTencentBizNowNowVideoView, (ViewGroup.LayoutParams)localObject);
    localObject = new ImageView(getContext());
    ((ImageView)localObject).setImageResource(2130843373);
    ((ImageView)localObject).setId(2131372825);
    ((ImageView)localObject).setVisibility(8);
    int i = AIOUtils.b(60.0F, getResources());
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(i, i);
    localLayoutParams.addRule(13);
    addView((View)localObject, localLayoutParams);
    this.jdField_a_of_type_ComTencentBizNowNowVideoView.a((ImageView)localObject);
  }
  
  public void a(int paramInt, String paramString)
  {
    Object localObject = findViewById(2131377988);
    ImageView localImageView;
    if (localObject == null)
    {
      localImageView = new ImageView(getContext());
      localImageView.setId(2131377988);
      localObject = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject).addRule(9);
      ((RelativeLayout.LayoutParams)localObject).addRule(10);
      ((RelativeLayout.LayoutParams)localObject).setMargins(AIOUtils.b(10.0F, getResources()), AIOUtils.b(10.0F, getResources()), 0, 0);
      localImageView.setImageResource(2130844016);
      addView(localImageView, (ViewGroup.LayoutParams)localObject);
    }
    else
    {
      localImageView = (ImageView)localObject;
    }
    localObject = getParent();
    String str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
    boolean bool = localObject instanceof LinearLayout;
    TextView localTextView2 = null;
    TextView localTextView1;
    if (bool)
    {
      localObject = (LinearLayout)localObject;
      localTextView2 = (TextView)((LinearLayout)localObject).findViewById(2131379926);
      localTextView1 = (TextView)((LinearLayout)localObject).findViewById(2131379930);
    }
    else
    {
      localTextView1 = null;
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgItemLive;
    String str1;
    if (localObject == null) {
      str1 = "";
    } else {
      str1 = ((StructMsgItemLive)localObject).ah;
    }
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
    paramString = this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgItemLive;
    if ((paramString != null) && (!TextUtils.isEmpty(paramString.ag)))
    {
      paramString = new StringBuilder();
      paramString.append((String)localObject);
      paramString.append(getContext().getText(2131697664).toString());
      paramString = paramString.toString();
    }
    else
    {
      paramString = new StringBuilder();
      paramString.append((String)localObject);
      paramString.append(getContext().getText(2131697662).toString());
      paramString = paramString.toString();
    }
    bool = ((NowLiveManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.NOW_LIVE_MANAGER)).a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.time);
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3)
          {
            localImageView.setVisibility(4);
          }
          else
          {
            localImageView.setVisibility(0);
            paramString = new StringBuilder();
            paramString.append((String)localObject);
            paramString.append(getContext().getText(2131697664).toString());
            paramString = paramString.toString();
          }
        }
        else
        {
          localImageView.setVisibility(0);
          paramString = new StringBuilder();
          paramString.append((String)localObject);
          paramString.append(getContext().getText(2131697662).toString());
          paramString = paramString.toString();
        }
      }
      else
      {
        localImageView.setVisibility(0);
        paramString = new StringBuilder();
        paramString.append((String)localObject);
        paramString.append(getContext().getText(2131697663));
        paramString = paramString.toString();
      }
    }
    else
    {
      localImageView.setVisibility(4);
      if (bool)
      {
        paramString = new StringBuilder();
        paramString.append((String)localObject);
        paramString.append(getContext().getText(2131697663));
        paramString = paramString.toString();
      }
    }
    localObject = paramString;
    if (localTextView1 != null) {
      if (!TextUtils.isEmpty(str1))
      {
        localTextView1.setText(str1);
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append(":");
        localObject = ((StringBuilder)localObject).toString();
        localTextView1.setVisibility(0);
      }
      else
      {
        localTextView1.setVisibility(8);
        localObject = paramString;
      }
    }
    if (localTextView2 != null) {
      localTextView2.setText((CharSequence)localObject);
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, StructMsgItemLive paramStructMsgItemLive, MessageRecord paramMessageRecord)
  {
    this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgItemLive = paramStructMsgItemLive;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = paramMessageRecord;
    NowVideoView localNowVideoView = this.jdField_a_of_type_ComTencentBizNowNowVideoView;
    if (localNowVideoView != null) {
      if (paramQQAppInterface == null)
      {
        paramStructMsgItemLive = URLDrawable.getDrawable(paramStructMsgItemLive.ad, paramStructMsgItemLive.o, paramStructMsgItemLive.p);
        this.jdField_a_of_type_ComTencentBizNowNowVideoView.setImageDrawable(paramStructMsgItemLive);
        paramStructMsgItemLive = this.jdField_a_of_type_ComTencentBizNowNowVideoView;
        paramStructMsgItemLive.a(paramStructMsgItemLive.a);
      }
      else
      {
        localNowVideoView.a(paramQQAppInterface, paramStructMsgItemLive, paramMessageRecord);
      }
    }
    boolean bool = false;
    paramStructMsgItemLive = null;
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface = (NowLiveManager)paramQQAppInterface.getManager(QQManagerFactory.NOW_LIVE_MANAGER);
      bool = paramQQAppInterface.a(paramMessageRecord.frienduin, paramMessageRecord.time);
      paramStructMsgItemLive = paramQQAppInterface.a(paramMessageRecord.frienduin, paramMessageRecord.time);
    }
    if (bool)
    {
      if ((paramStructMsgItemLive != null) && ((paramStructMsgItemLive.a == 1) || (paramStructMsgItemLive.a == 2)))
      {
        paramQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgItemLive;
        if ((paramQQAppInterface != null) && (!TextUtils.isEmpty(paramQQAppInterface.ag)))
        {
          a(3, paramMessageRecord.senderuin);
          return;
        }
        a(2, paramMessageRecord.senderuin);
        return;
      }
      a(1, paramMessageRecord.senderuin);
      return;
    }
    paramQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgItemLive;
    if ((paramQQAppInterface != null) && (!TextUtils.isEmpty(paramQQAppInterface.ag)))
    {
      a(3, paramMessageRecord.senderuin);
      return;
    }
    a(2, paramMessageRecord.senderuin);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.now.NowVideoLayout
 * JD-Core Version:    0.7.0.1
 */