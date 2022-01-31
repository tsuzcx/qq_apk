package com.tencent.biz.pubaccount.readinjoy.channelCover;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyActivityHelper;
import com.tencent.biz.pubaccount.readinjoy.struct.ChannelCoverInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyVideoTopicTextView;
import com.tencent.biz.qqstory.takevideo.doodle.util.DisplayUtil;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import lin;
import lio;
import org.json.JSONObject;

public class ChannelCoverSimpleAdapter
  extends BaseAdapter
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  public ChannelCoverSimpleAdapter(Context paramContext, ArrayList paramArrayList, int paramInt)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Int = paramInt;
    if (paramArrayList != null)
    {
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      paramContext = new ChannelCoverInfo();
      this.jdField_a_of_type_JavaUtilArrayList.add(paramContext);
      this.jdField_a_of_type_JavaUtilArrayList.addAll(paramArrayList);
      paramContext = new ChannelCoverInfo();
      this.jdField_a_of_type_JavaUtilArrayList.add(paramContext);
    }
  }
  
  public ChannelCoverInfo a(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (paramInt < this.jdField_a_of_type_JavaUtilArrayList.size())) {
      return (ChannelCoverInfo)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    }
    return null;
  }
  
  public void a(ArrayList paramArrayList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("READINJOYChannelCoverSimpleAdapter", 2, "setData size" + paramArrayList.size());
    }
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      ChannelCoverInfo localChannelCoverInfo = new ChannelCoverInfo();
      this.jdField_a_of_type_JavaUtilArrayList.add(localChannelCoverInfo);
      this.jdField_a_of_type_JavaUtilArrayList.addAll(paramArrayList);
      paramArrayList = new ChannelCoverInfo();
      this.jdField_a_of_type_JavaUtilArrayList.add(paramArrayList);
    }
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("READINJOYChannelCoverSimpleAdapter", 2, "getCount()" + this.jdField_a_of_type_JavaUtilArrayList.size());
      }
      return this.jdField_a_of_type_JavaUtilArrayList.size();
    }
    return 0;
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public int getItemViewType(int paramInt)
  {
    if ((paramInt == 0) || ((this.jdField_a_of_type_JavaUtilArrayList != null) && (paramInt == this.jdField_a_of_type_JavaUtilArrayList.size() - 1))) {
      return 0;
    }
    return 1;
  }
  
  @TargetApi(16)
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject = this.jdField_a_of_type_AndroidContentContext.getResources();
    if (getItemViewType(paramInt) == 0)
    {
      paramViewGroup = paramView;
      if (paramView == null)
      {
        paramViewGroup = new View(this.jdField_a_of_type_AndroidContentContext);
        paramViewGroup.setLayoutParams(new ViewGroup.LayoutParams(AIOUtils.a(2.0F, (Resources)localObject), AIOUtils.a(21.0F, (Resources)localObject)));
      }
    }
    ChannelCoverInfo localChannelCoverInfo;
    do
    {
      return paramViewGroup;
      if (paramView != null) {
        break;
      }
      localObject = new lio(this);
      paramView = new ReadInJoyVideoTopicTextView(this.jdField_a_of_type_AndroidContentContext);
      paramView.setId(2131362203);
      paramView.setLayoutParams(new ViewGroup.LayoutParams(-2, DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 21.0F)));
      ((lio)localObject).jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyVideoTopicTextView = paramView;
      paramView.setTag(localObject);
      localChannelCoverInfo = (ChannelCoverInfo)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
      paramViewGroup = paramView;
    } while (localChannelCoverInfo == null);
    if (localChannelCoverInfo.mColumnType == 1)
    {
      ((lio)localObject).jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyVideoTopicTextView.setTopicText(localChannelCoverInfo.mChannelCoverName);
      label169:
      if (this.jdField_a_of_type_Int != 56) {
        break label377;
      }
      ((lio)localObject).jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyVideoTopicTextView.setTextColor(-5789786);
      label188:
      if (TextUtils.isEmpty(localChannelCoverInfo.mIconUrl)) {
        break label393;
      }
      paramInt = ViewUtils.a(21.0F);
      paramViewGroup = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130839226);
      paramViewGroup = URLDrawable.getDrawable(localChannelCoverInfo.mIconUrl, paramInt, paramInt, paramViewGroup, paramViewGroup);
      if ((paramViewGroup != null) && (paramViewGroup.getStatus() == 2)) {
        paramViewGroup.restartDownload();
      }
      paramViewGroup.setBounds(0, 0, paramInt, paramInt);
      ((lio)localObject).jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyVideoTopicTextView.setCompoundDrawables(paramViewGroup, null, null, null);
      label267:
      if (!localChannelCoverInfo.isReport)
      {
        localChannelCoverInfo.isReport = true;
        if (this.jdField_a_of_type_Int == 56)
        {
          new JSONObject();
          if (!localChannelCoverInfo.mIsTopic) {
            break label408;
          }
        }
      }
    }
    label393:
    label408:
    for (paramViewGroup = "0X80088BA";; paramViewGroup = "0X8007BE5")
    {
      ChannelCoverView.a(paramViewGroup, "1", "", "", localChannelCoverInfo);
      ChannelCoverView.a("0X8007F01", localChannelCoverInfo, ChannelCoverView.b);
      ((lio)localObject).jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyVideoTopicTextView.setOnClickListener(this);
      ((lio)localObject).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructChannelCoverInfo = localChannelCoverInfo;
      return paramView;
      localObject = (lio)paramView.getTag();
      break;
      ((lio)localObject).jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyVideoTopicTextView.setSubChannelText(localChannelCoverInfo.mChannelCoverName);
      break label169;
      label377:
      ((lio)localObject).jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyVideoTopicTextView.setTextColor(localChannelCoverInfo.mFontColor);
      break label188;
      ((lio)localObject).jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyVideoTopicTextView.setCompoundDrawables(null, null, null, null);
      break label267;
    }
  }
  
  public int getViewTypeCount()
  {
    return 2;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("READINJOYChannelCoverSimpleAdapter", 2, "click readinjoy_feeds_video_label_textview");
      }
      paramView = ((lio)paramView.getTag()).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructChannelCoverInfo;
    } while (paramView == null);
    Object localObject;
    if (TextUtils.isEmpty(paramView.mChannelJumpUrl))
    {
      localObject = new HashMap();
      ((HashMap)localObject).put("param_key_ariticle_id", Long.valueOf(paramView.mArticleId));
      ((HashMap)localObject).put("param_key_channel_cover_style", Integer.valueOf(paramView.mChannelCoverStyle));
      ((HashMap)localObject).put("param_key_channel_column_type", Integer.valueOf(paramView.mColumnType));
      if (this.jdField_a_of_type_Int == 56)
      {
        ReadInJoyActivityHelper.b(this.jdField_a_of_type_AndroidContentContext, paramView.mChannelCoverId, paramView.mChannelCoverName, paramView.mChannelType, 4, (Map)localObject);
        if (QLog.isColorLevel()) {
          QLog.d("READINJOYChannelCoverSimpleAdapter", 2, "launchChannelActivity info.mArticleId:" + paramView.mArticleId + " info.mChannelCoverStyle: " + paramView.mChannelCoverStyle + " info.mChannelCoverId:" + paramView.mChannelCoverId + " info.mChannelCoverName:" + paramView.mChannelCoverName + " info.mChannelType: " + paramView.mChannelType);
        }
        if (this.jdField_a_of_type_Int == 56) {
          ThreadManager.executeOnSubThread(new lin(this, paramView));
        }
      }
    }
    for (;;)
    {
      ChannelCoverView.a("0X8007F02", paramView, ChannelCoverView.b);
      return;
      ReadInJoyActivityHelper.a(this.jdField_a_of_type_AndroidContentContext, paramView.mChannelCoverId, paramView.mChannelCoverName, paramView.mChannelType, 4, (Map)localObject);
      break;
      localObject = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
      ((Intent)localObject).putExtra("url", paramView.mChannelJumpUrl);
      this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject);
      if (QLog.isColorLevel()) {
        QLog.d("READINJOYChannelCoverSimpleAdapter", 2, "info.mChannelJumpUrl:" + paramView.mChannelJumpUrl);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.channelCover.ChannelCoverSimpleAdapter
 * JD-Core Version:    0.7.0.1
 */