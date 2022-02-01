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
  public ServiceAccountFolderFeed a;
  private URLImageView b;
  private TextView c;
  private DragTextView d;
  private RecentFaceDecoder e;
  private HashMap<String, Bitmap> f;
  private IDragView.OnChangeModeListener g;
  private boolean h = false;
  
  public ServiceFolderFollowPBHeadView$ServiceAccountViewHolder(View paramView, RecentFaceDecoder paramRecentFaceDecoder, HashMap<String, Bitmap> paramHashMap, DragFrameLayout paramDragFrameLayout)
  {
    super(paramView);
    this.e = paramRecentFaceDecoder;
    this.f = paramHashMap;
    this.g = paramDragFrameLayout;
    this.b = ((URLImageView)paramView.findViewById(2131445658));
    this.c = ((TextView)paramView.findViewById(2131445663));
    this.d = ((DragTextView)paramView.findViewById(2131445666));
  }
  
  private void a(View paramView, ServiceAccountFolderFeed paramServiceAccountFolderFeed)
  {
    if (TextUtils.equals(paramServiceAccountFolderFeed.b, NowQQLiveConstant.a))
    {
      NowQQLiveHelper.a(paramView.getContext(), paramServiceAccountFolderFeed.b, 1);
      return;
    }
    b(paramView, paramServiceAccountFolderFeed);
  }
  
  private boolean a(ServiceAccountFolderFeed paramServiceAccountFolderFeed1, ServiceAccountFolderFeed paramServiceAccountFolderFeed2)
  {
    if ((paramServiceAccountFolderFeed1 != null) && (paramServiceAccountFolderFeed2 != null))
    {
      boolean bool;
      if ((paramServiceAccountFolderFeed1.b.equals(paramServiceAccountFolderFeed2.b)) && (paramServiceAccountFolderFeed1.d == paramServiceAccountFolderFeed2.d) && (paramServiceAccountFolderFeed1.c == paramServiceAccountFolderFeed2.c) && (paramServiceAccountFolderFeed1.h.equals(paramServiceAccountFolderFeed2.h))) {
        bool = true;
      } else {
        bool = false;
      }
      paramServiceAccountFolderFeed1 = ServiceFolderFollowPBHeadView.b();
      paramServiceAccountFolderFeed2 = new StringBuilder();
      paramServiceAccountFolderFeed2.append("isSameServiceData:");
      paramServiceAccountFolderFeed2.append(bool);
      QLog.d(paramServiceAccountFolderFeed1, 4, paramServiceAccountFolderFeed2.toString());
    }
    return false;
  }
  
  private void b(View paramView, ServiceAccountFolderFeed paramServiceAccountFolderFeed)
  {
    Intent localIntent = new Intent(paramView.getContext(), ChatActivity.class);
    localIntent.putExtra("uintype", 1008);
    localIntent.putExtra("uin", paramServiceAccountFolderFeed.b);
    localIntent.putExtra("uinname", paramServiceAccountFolderFeed.h);
    localIntent.putExtra("start_time", System.currentTimeMillis());
    localIntent.putExtra("red_hot_count", paramServiceAccountFolderFeed.d);
    localIntent.putExtra("INTENT_KEY_FROM", 2);
    paramView.getContext().startActivity(localIntent);
  }
  
  @RequiresApi(api=8)
  public void a(ImageView paramImageView, String paramString)
  {
    Bitmap localBitmap = (Bitmap)this.f.get(paramString);
    if (localBitmap == null) {
      paramImageView.setImageDrawable(this.e.a(1008, paramString));
    } else {
      paramImageView.setImageBitmap(localBitmap);
    }
    if (this.h) {
      paramImageView.setColorFilter(1711276032);
    }
  }
  
  public void a(ServiceAccountFolderFeed paramServiceAccountFolderFeed, int paramInt)
  {
    if (paramServiceAccountFolderFeed != null)
    {
      if (a(this.a, paramServiceAccountFolderFeed)) {
        return;
      }
      this.a = paramServiceAccountFolderFeed;
      this.itemView.setTag(this.a);
      this.d.setTag(2131445660, this.a);
      this.d.setTag(2131445658, Integer.valueOf(paramInt));
      this.c.setText(paramServiceAccountFolderFeed.h);
      if (this.h) {
        this.c.setTextColor(-5723992);
      }
      a(this.b, paramServiceAccountFolderFeed.b);
      int j = paramServiceAccountFolderFeed.d;
      int i = paramServiceAccountFolderFeed.c;
      Object localObject3 = paramServiceAccountFolderFeed.j;
      if (localObject3 != null)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(j);
        ((StringBuilder)localObject1).append("");
        localObject1 = ((StringBuilder)localObject1).toString();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(((MessageRecord)localObject3).msgseq);
        ((StringBuilder)localObject2).append("");
        localObject2 = ((StringBuilder)localObject2).toString();
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append(((MessageRecord)localObject3).msgBackupMsgRandom);
        ((StringBuilder)localObject4).append("");
        localObject1 = PublicAccountEventReport.a((String)localObject1, (String)localObject2, ((StringBuilder)localObject4).toString());
      }
      else
      {
        localObject1 = "";
      }
      if (j > 0) {
        if (i == 0)
        {
          this.d.setDragViewType(-1, this.itemView);
          this.d.setOnModeChangeListener(null);
        }
        else
        {
          if (i == 2)
          {
            this.d.setDragViewType(-1, this.itemView);
            this.d.setOnModeChangeListener(null);
            i = 1;
            break label333;
          }
          this.d.setDragViewType(0, this.itemView);
          this.d.setOnModeChangeListener(this.g);
          i = 3;
          k = 2130852592;
          break label339;
        }
      }
      i = 0;
      label333:
      j = 0;
      int k = 0;
      label339:
      CustomWidgetUtil.a(this.d, i, j, k, 99, null);
      if ((paramServiceAccountFolderFeed.j != null) && (paramServiceAccountFolderFeed.j.mExJsonObject != null)) {
        localObject2 = paramServiceAccountFolderFeed.j.mExJsonObject.optString("report_key_bytes_oac_msg_extend", "");
      } else {
        localObject2 = "";
      }
      this.itemView.setOnClickListener(new ServiceFolderFollowPBHeadView.ServiceAccountViewHolder.1(this, paramServiceAccountFolderFeed, paramInt, (MessageRecord)localObject3, (String)localObject2, (String)localObject1));
      localObject3 = paramServiceAccountFolderFeed.j;
      Object localObject4 = paramServiceAccountFolderFeed.b;
      i = paramServiceAccountFolderFeed.c;
      j = paramServiceAccountFolderFeed.d;
      Object localObject5 = new StringBuilder();
      ((StringBuilder)localObject5).append(paramServiceAccountFolderFeed.i);
      ((StringBuilder)localObject5).append("");
      localObject5 = ((StringBuilder)localObject5).toString();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramInt);
      localStringBuilder.append("");
      PublicAccountEventReport.a(null, (MessageRecord)localObject3, (String)localObject4, i, j, (String)localObject5, (String)localObject2, (String)localObject1, localStringBuilder.toString());
      Object localObject1 = paramServiceAccountFolderFeed.b;
      Object localObject2 = paramServiceAccountFolderFeed.h;
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(paramServiceAccountFolderFeed.i);
      ((StringBuilder)localObject3).append("");
      VSReporter.a((String)localObject1, "auth_follow", "new_s_exp", 0, 0, new String[] { "", "", localObject2, ((StringBuilder)localObject3).toString() });
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.h = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.relativevideo.ServiceFolderFollowPBHeadView.ServiceAccountViewHolder
 * JD-Core Version:    0.7.0.1
 */