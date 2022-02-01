package com.tencent.biz.subscribe.widget.relativevideo;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderFeed;
import com.tencent.biz.videostory.support.VSReporter;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.recent.RecentFaceDecoder;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.activity.recent.cur.DragTextView;
import com.tencent.mobileqq.activity.recent.cur.IDragView.OnChangeModeListener;
import com.tencent.mobileqq.applets.PublicAccountEventReport;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.now.NowQQLiveConstant;
import com.tencent.mobileqq.now.NowQQLiveHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.CustomWidgetUtil;
import java.util.HashMap;
import org.json.JSONObject;

class ServiceFolderFollowPBHeadView$ServiceAccountViewHolder
  extends RecyclerView.ViewHolder
{
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  public ServiceAccountFolderFeed a;
  private URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  private RecentFaceDecoder jdField_a_of_type_ComTencentMobileqqActivityRecentRecentFaceDecoder;
  private DragTextView jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView;
  private IDragView.OnChangeModeListener jdField_a_of_type_ComTencentMobileqqActivityRecentCurIDragView$OnChangeModeListener;
  private HashMap<String, Bitmap> jdField_a_of_type_JavaUtilHashMap;
  private boolean jdField_a_of_type_Boolean = false;
  
  public ServiceFolderFollowPBHeadView$ServiceAccountViewHolder(View paramView, RecentFaceDecoder paramRecentFaceDecoder, HashMap<String, Bitmap> paramHashMap, DragFrameLayout paramDragFrameLayout)
  {
    super(paramView);
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentFaceDecoder = paramRecentFaceDecoder;
    this.jdField_a_of_type_JavaUtilHashMap = paramHashMap;
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurIDragView$OnChangeModeListener = paramDragFrameLayout;
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131377845));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131377850));
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView = ((DragTextView)paramView.findViewById(2131377853));
  }
  
  private void a(View paramView, ServiceAccountFolderFeed paramServiceAccountFolderFeed)
  {
    if (TextUtils.equals(paramServiceAccountFolderFeed.jdField_a_of_type_JavaLangString, NowQQLiveConstant.jdField_a_of_type_JavaLangString))
    {
      NowQQLiveHelper.a(paramView.getContext(), paramServiceAccountFolderFeed.jdField_a_of_type_JavaLangString, 1);
      return;
    }
    b(paramView, paramServiceAccountFolderFeed);
  }
  
  private boolean a(ServiceAccountFolderFeed paramServiceAccountFolderFeed1, ServiceAccountFolderFeed paramServiceAccountFolderFeed2)
  {
    if ((paramServiceAccountFolderFeed1 != null) && (paramServiceAccountFolderFeed2 != null)) {
      if ((!paramServiceAccountFolderFeed1.jdField_a_of_type_JavaLangString.equals(paramServiceAccountFolderFeed2.jdField_a_of_type_JavaLangString)) || (paramServiceAccountFolderFeed1.b != paramServiceAccountFolderFeed2.b) || (paramServiceAccountFolderFeed1.jdField_a_of_type_Int != paramServiceAccountFolderFeed2.jdField_a_of_type_Int) || (!paramServiceAccountFolderFeed1.c.equals(paramServiceAccountFolderFeed2.c))) {
        break label88;
      }
    }
    label88:
    for (boolean bool = true;; bool = false)
    {
      QLog.d(ServiceFolderFollowPBHeadView.a(), 4, "isSameServiceData:" + bool);
      return false;
    }
  }
  
  private void b(View paramView, ServiceAccountFolderFeed paramServiceAccountFolderFeed)
  {
    Intent localIntent = new Intent(paramView.getContext(), ChatActivity.class);
    localIntent.putExtra("uintype", 1008);
    localIntent.putExtra("uin", paramServiceAccountFolderFeed.jdField_a_of_type_JavaLangString);
    localIntent.putExtra("uinname", paramServiceAccountFolderFeed.c);
    localIntent.putExtra("start_time", System.currentTimeMillis());
    localIntent.putExtra("red_hot_count", paramServiceAccountFolderFeed.b);
    localIntent.putExtra("INTENT_KEY_FROM", 2);
    paramView.getContext().startActivity(localIntent);
  }
  
  @RequiresApi(api=8)
  public void a(ImageView paramImageView, String paramString)
  {
    Bitmap localBitmap = (Bitmap)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
    if (localBitmap == null) {
      paramImageView.setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentFaceDecoder.a(1008, paramString));
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Boolean) {
        paramImageView.setColorFilter(1711276032);
      }
      return;
      paramImageView.setImageBitmap(localBitmap);
    }
  }
  
  public void a(ServiceAccountFolderFeed paramServiceAccountFolderFeed, int paramInt)
  {
    if ((paramServiceAccountFolderFeed == null) || (a(this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderFeed, paramServiceAccountFolderFeed))) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderFeed = paramServiceAccountFolderFeed;
    this.itemView.setTag(this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderFeed);
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setTag(2131377847, this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderFeed);
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setTag(2131377845, Integer.valueOf(paramInt));
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramServiceAccountFolderFeed.c);
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-5723992);
    }
    a(this.jdField_a_of_type_ComTencentImageURLImageView, paramServiceAccountFolderFeed.jdField_a_of_type_JavaLangString);
    int j = paramServiceAccountFolderFeed.b;
    int i = 0;
    int k = 0;
    int m = paramServiceAccountFolderFeed.jdField_a_of_type_Int;
    Object localObject = paramServiceAccountFolderFeed.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
    if (localObject != null)
    {
      localObject = PublicAccountEventReport.a(j + "", ((MessageRecord)localObject).msgseq + "", ((MessageRecord)localObject).msgBackupMsgRandom + "");
      if (j <= 0) {
        break label517;
      }
      if (m != 0) {
        break label447;
      }
      i = 0;
      k = 0;
      j = 0;
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(-1, this.itemView);
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setOnModeChangeListener(null);
    }
    label517:
    for (;;)
    {
      CustomWidgetUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView, i, j, k, 99, null);
      String str2 = "";
      String str1 = str2;
      if (paramServiceAccountFolderFeed.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null)
      {
        str1 = str2;
        if (paramServiceAccountFolderFeed.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.mExJsonObject != null) {
          str1 = paramServiceAccountFolderFeed.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.mExJsonObject.optString("report_key_bytes_oac_msg_extend", "");
        }
      }
      this.itemView.setOnClickListener(new ServiceFolderFollowPBHeadView.ServiceAccountViewHolder.1(this, paramServiceAccountFolderFeed, paramInt, str1, (String)localObject));
      PublicAccountEventReport.a(null, paramServiceAccountFolderFeed.jdField_a_of_type_JavaLangString, paramServiceAccountFolderFeed.jdField_a_of_type_Int, paramServiceAccountFolderFeed.b, paramServiceAccountFolderFeed.jdField_a_of_type_JavaLangCharSequence + "", str1, (String)localObject, paramInt + "");
      VSReporter.a(paramServiceAccountFolderFeed.jdField_a_of_type_JavaLangString, "auth_follow", "new_s_exp", 0, 0, new String[] { "", "", paramServiceAccountFolderFeed.c, paramServiceAccountFolderFeed.jdField_a_of_type_JavaLangCharSequence + "" });
      return;
      localObject = "";
      break;
      label447:
      if (m == 2)
      {
        i = 1;
        k = 0;
        j = 0;
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(-1, this.itemView);
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setOnModeChangeListener(null);
      }
      else
      {
        i = 3;
        k = 2130850834;
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(0, this.itemView);
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setOnModeChangeListener(this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurIDragView$OnChangeModeListener);
        continue;
        j = 0;
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.relativevideo.ServiceFolderFollowPBHeadView.ServiceAccountViewHolder
 * JD-Core Version:    0.7.0.1
 */