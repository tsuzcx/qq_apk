package com.tencent.mobileqq.activity.aio.item;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.NinePatch;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewStub;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.AbstractChatItemBuilder;
import com.tencent.mobileqq.activity.aio.AbstractChatItemBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.BeancurdManager;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForQCircleFeed;
import com.tencent.mobileqq.data.MessageForQCircleFeed.MediaData;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.profile.PersonalityLabel.CornerImageView;
import com.tencent.mobileqq.qcircle.api.IQCircleRFWApi;
import com.tencent.mobileqq.qcircle.api.utils.QCircleHostUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import java.util.ArrayList;
import mqq.os.MqqHandler;

public class QCircleFeedItemBuilder
  extends AbstractChatItemBuilder
{
  private static Drawable m;
  private static int n = -1;
  private final int e;
  private final int f;
  private final int g;
  private final int h;
  private final int i;
  private final int j;
  private final int k;
  private final int l;
  
  public QCircleFeedItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
    paramBaseAdapter = this.c.getResources();
    this.e = AIOUtils.b(227.0F, paramBaseAdapter);
    this.f = AIOUtils.b(128.0F, paramBaseAdapter);
    this.g = AIOUtils.b(129.0F, paramBaseAdapter);
    this.h = AIOUtils.b(128.0F, paramBaseAdapter);
    this.i = AIOUtils.b(98.0F, paramBaseAdapter);
    this.j = AIOUtils.b(64.0F, paramBaseAdapter);
    this.k = AIOUtils.b(4.0F, paramBaseAdapter);
    this.l = QzoneConfig.getInstance().getConfig("QZoneSetting", "qzoneAioFriendFeedNicknameMaxLength", 10);
    paramQQAppInterface = (BeancurdManager)paramQQAppInterface.getManager(QQManagerFactory.BEANCURD_MANAGER);
    if (paramQQAppInterface != null) {
      paramQQAppInterface.a(3, 12);
    }
  }
  
  private int a(MessageForQCircleFeed paramMessageForQCircleFeed)
  {
    if (paramMessageForQCircleFeed.mediaDatas != null)
    {
      if (paramMessageForQCircleFeed.mediaDatas.size() >= 3) {
        return 2;
      }
      return 1;
    }
    return 0;
  }
  
  private Drawable a(Resources paramResources, String paramString)
  {
    paramString = SafeBitmapFactory.decodeFile(paramString);
    if (paramString == null) {
      return null;
    }
    byte[] arrayOfByte = paramString.getNinePatchChunk();
    if (NinePatch.isNinePatchChunk(arrayOfByte)) {
      return new NinePatchDrawable(paramResources, paramString, arrayOfByte, new Rect(), null);
    }
    return new BitmapDrawable(paramResources, paramString);
  }
  
  private View a(View paramView, QCircleFeedItemBuilder.Holder paramHolder)
  {
    View localView = paramView;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.c).inflate(2131624437, null);
      paramHolder.g = paramView;
      paramHolder.h = paramView.findViewById(2131428046);
      paramHolder.k = ((TextView)paramView.findViewById(2131428055));
      paramHolder.l = ((TextView)paramView.findViewById(2131428047));
      localView = paramView;
      if (v)
      {
        paramHolder.r = new StringBuilder();
        localView = paramView;
      }
    }
    if (v)
    {
      localView.setContentDescription(null);
      paramHolder.r.replace(0, paramHolder.r.length(), "");
    }
    return localView;
  }
  
  private static String a(long paramLong)
  {
    return QCircleHostUtil.bigNumberFormatTranfer(paramLong);
  }
  
  private void a(QCircleFeedItemBuilder.Holder paramHolder, int paramInt)
  {
    if (paramHolder == null) {
      return;
    }
    if (paramInt <= 0)
    {
      paramHolder.t.setVisibility(8);
      return;
    }
    paramHolder.t.setVisibility(0);
    paramHolder.u.setText(a(paramInt));
  }
  
  private void a(QCircleFeedItemBuilder.Holder paramHolder, MessageForQCircleFeed paramMessageForQCircleFeed)
  {
    int i1 = a(paramMessageForQCircleFeed);
    if (i1 != 1)
    {
      if (i1 == 2) {
        c(paramHolder, paramMessageForQCircleFeed);
      }
    }
    else {
      b(paramHolder, paramMessageForQCircleFeed);
    }
    paramMessageForQCircleFeed = Utils.b(this.d.e, this.l);
    paramHolder.l.setText(this.c.getResources().getString(2131895808, new Object[] { paramMessageForQCircleFeed }));
    paramHolder.l.setVisibility(0);
    paramMessageForQCircleFeed = ((IQCircleRFWApi)QRoute.api(IQCircleRFWApi.class)).getDefaultSavePath("https://downv6.qq.com/video_story/qcircle/pic/background/img_aio_tofu_ark_bg.9.png");
    if (FileUtils.fileExistsAndNotEmpty(paramMessageForQCircleFeed))
    {
      if (m != null)
      {
        b(paramHolder.h);
        return;
      }
      ThreadManager.getFileThreadHandler().post(new QCircleFeedItemBuilder.2(this, paramMessageForQCircleFeed, paramHolder));
      paramHolder.h.setBackgroundResource(2130838214);
      return;
    }
    paramHolder.h.setBackgroundResource(2130838214);
  }
  
  private void b(View paramView)
  {
    if (m == null) {
      return;
    }
    if (Build.VERSION.SDK_INT >= 16)
    {
      paramView.setBackground(m);
      return;
    }
    paramView.setBackgroundDrawable(m);
  }
  
  private void b(QCircleFeedItemBuilder.Holder paramHolder, int paramInt)
  {
    if (paramHolder == null) {
      return;
    }
    if (paramInt <= 0)
    {
      paramHolder.v.setVisibility(8);
      return;
    }
    paramHolder.v.setVisibility(0);
    paramHolder.w.setText(a(paramInt));
  }
  
  private void b(QCircleFeedItemBuilder.Holder paramHolder, MessageForQCircleFeed paramMessageForQCircleFeed)
  {
    if (paramMessageForQCircleFeed.mediaDatas != null)
    {
      if (paramMessageForQCircleFeed.mediaDatas.size() == 0) {
        return;
      }
      Object localObject1 = paramMessageForQCircleFeed.mediaDatas;
      int i1 = 0;
      Object localObject3 = (MessageForQCircleFeed.MediaData)((ArrayList)localObject1).get(0);
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("setDataToSinglePicContainer picUrl= ");
        ((StringBuilder)localObject1).append(((MessageForQCircleFeed.MediaData)localObject3).mediaUrl);
        QLog.d("QCircleFeedItemBuilder", 2, ((StringBuilder)localObject1).toString());
      }
      Object localObject2 = paramMessageForQCircleFeed.coverImageUrl;
      localObject1 = localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        localObject1 = ((MessageForQCircleFeed.MediaData)localObject3).mediaUrl;
      }
      if (paramHolder.j != null) {
        paramHolder.j.setVisibility(8);
      }
      if (paramHolder.i == null)
      {
        paramHolder.i = ((ViewStub)paramHolder.g.findViewById(2131428056)).inflate();
        paramHolder.m = ((CornerImageView)paramHolder.g.findViewById(2131428048));
        paramHolder.n = ((ImageView)paramHolder.g.findViewById(2131428057));
        paramHolder.t = ((LinearLayout)paramHolder.g.findViewById(2131428044));
        paramHolder.u = ((TextView)paramHolder.g.findViewById(2131428059));
        paramHolder.v = ((LinearLayout)paramHolder.g.findViewById(2131428043));
        paramHolder.w = ((TextView)paramHolder.g.findViewById(2131428058));
        ((IQCircleRFWApi)QRoute.api(IQCircleRFWApi.class)).setNumberTypeface(paramHolder.u, false);
        ((IQCircleRFWApi)QRoute.api(IQCircleRFWApi.class)).setNumberTypeface(paramHolder.w, false);
      }
      paramHolder.i.setVisibility(0);
      if (!TextUtils.isEmpty(paramMessageForQCircleFeed.content)) {
        paramHolder.k.setText(paramMessageForQCircleFeed.content);
      }
      a(paramHolder, paramMessageForQCircleFeed.pushCount);
      b(paramHolder, paramMessageForQCircleFeed.likeCount);
      localObject2 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject2).mRequestWidth = this.e;
      ((URLDrawable.URLDrawableOptions)localObject2).mRequestHeight = this.f;
      localObject3 = paramHolder.m;
      int i2 = this.k;
      a((CornerImageView)localObject3, (String)localObject1, (URLDrawable.URLDrawableOptions)localObject2, new float[] { i2, i2, i2, i2, i2, i2, i2, i2 });
      paramHolder = paramHolder.n;
      if (paramMessageForQCircleFeed.type != 3) {
        i1 = 8;
      }
      paramHolder.setVisibility(i1);
      paramHolder = new StringBuilder();
      paramHolder.append("message.pushCount=");
      paramHolder.append(paramMessageForQCircleFeed.pushCount);
      paramHolder.append(",message.likecount=");
      paramHolder.append(paramMessageForQCircleFeed.likeCount);
      QLog.d("QCircleFeedItemBuilder", 2, paramHolder.toString());
    }
  }
  
  private void c()
  {
    String str = ((IQCircleRFWApi)QRoute.api(IQCircleRFWApi.class)).getDefaultSavePath("https://downv6.qq.com/video_story/qcircle/pic/background/img_aio_tofu_ark_bg.9.png");
    if (FileUtils.fileExistsAndNotEmpty(str)) {
      ThreadManager.getFileThreadHandler().post(new QCircleFeedItemBuilder.3(this, str));
    }
  }
  
  private void c(QCircleFeedItemBuilder.Holder paramHolder, MessageForQCircleFeed paramMessageForQCircleFeed)
  {
    if (paramMessageForQCircleFeed.mediaDatas != null)
    {
      if (paramMessageForQCircleFeed.mediaDatas.size() < 3) {
        return;
      }
      Object localObject = ((MessageForQCircleFeed.MediaData)paramMessageForQCircleFeed.mediaDatas.get(0)).mediaUrl;
      String str2 = ((MessageForQCircleFeed.MediaData)paramMessageForQCircleFeed.mediaDatas.get(1)).mediaUrl;
      String str1 = ((MessageForQCircleFeed.MediaData)paramMessageForQCircleFeed.mediaDatas.get(2)).mediaUrl;
      if (paramHolder.i != null) {
        paramHolder.i.setVisibility(8);
      }
      if (paramHolder.j == null)
      {
        paramHolder.j = ((ViewStub)paramHolder.g.findViewById(2131428054)).inflate();
        paramHolder.o = ((CornerImageView)paramHolder.g.findViewById(2131428049));
        paramHolder.p = ((CornerImageView)paramHolder.g.findViewById(2131428051));
        paramHolder.s = ((CornerImageView)paramHolder.g.findViewById(2131428050));
        paramHolder.t = ((LinearLayout)paramHolder.g.findViewById(2131428044));
        paramHolder.u = ((TextView)paramHolder.g.findViewById(2131428059));
        paramHolder.v = ((LinearLayout)paramHolder.g.findViewById(2131428043));
        paramHolder.w = ((TextView)paramHolder.g.findViewById(2131428058));
        ((IQCircleRFWApi)QRoute.api(IQCircleRFWApi.class)).setNumberTypeface(paramHolder.u, false);
        ((IQCircleRFWApi)QRoute.api(IQCircleRFWApi.class)).setNumberTypeface(paramHolder.w, false);
      }
      paramHolder.j.setVisibility(0);
      if (!TextUtils.isEmpty(paramMessageForQCircleFeed.content)) {
        paramHolder.k.setText(paramMessageForQCircleFeed.content);
      }
      a(paramHolder, paramMessageForQCircleFeed.pushCount);
      b(paramHolder, paramMessageForQCircleFeed.likeCount);
      URLDrawable.URLDrawableOptions localURLDrawableOptions2 = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions2.mRequestWidth = this.g;
      localURLDrawableOptions2.mRequestHeight = this.h;
      URLDrawable.URLDrawableOptions localURLDrawableOptions1 = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions1.mRequestWidth = this.i;
      localURLDrawableOptions1.mRequestHeight = this.j;
      CornerImageView localCornerImageView = paramHolder.o;
      int i1 = this.k;
      a(localCornerImageView, (String)localObject, localURLDrawableOptions2, new float[] { i1, i1, 0.0F, 0.0F, 0.0F, 0.0F, i1, i1 });
      localObject = paramHolder.p;
      i1 = this.k;
      a((CornerImageView)localObject, str2, localURLDrawableOptions1, new float[] { 0.0F, 0.0F, i1, i1, 0.0F, 0.0F, 0.0F, 0.0F });
      paramHolder = paramHolder.s;
      i1 = this.k;
      a(paramHolder, str1, localURLDrawableOptions1, new float[] { 0.0F, 0.0F, 0.0F, 0.0F, i1, i1, 0.0F, 0.0F });
      paramHolder = new StringBuilder();
      paramHolder.append("message.pushCount=");
      paramHolder.append(paramMessageForQCircleFeed.pushCount);
      paramHolder.append(",message.likecount=");
      paramHolder.append(paramMessageForQCircleFeed.likeCount);
      QLog.d("QCircleFeedItemBuilder", 2, paramHolder.toString());
    }
  }
  
  protected View a(MessageRecord paramMessageRecord, AbstractChatItemBuilder.ViewHolder paramViewHolder, View paramView, LinearLayout paramLinearLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    if (QLog.isColorLevel())
    {
      paramLinearLayout = new StringBuilder();
      paramLinearLayout.append("getItemView: invoked. info: message = ");
      paramLinearLayout.append(paramMessageRecord);
      QLog.i("QCircleFeedItemBuilder", 2, paramLinearLayout.toString());
    }
    c();
    paramMessageRecord = (MessageForQCircleFeed)paramMessageRecord;
    paramViewHolder = (QCircleFeedItemBuilder.Holder)paramViewHolder;
    paramView = a(paramView, paramViewHolder);
    paramViewHolder.d = paramMessageRecord.uniseq;
    paramViewHolder.e = paramMessageRecord.frienduin;
    paramViewHolder.f = null;
    a(paramViewHolder, paramMessageRecord);
    paramViewHolder.h.setOnClickListener(new QCircleFeedItemBuilder.1(this, paramMessageRecord));
    return paramView;
  }
  
  protected AbstractChatItemBuilder.ViewHolder a()
  {
    return new QCircleFeedItemBuilder.Holder(this);
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage) {}
  
  protected void a(CornerImageView paramCornerImageView, String paramString, URLDrawable.URLDrawableOptions paramURLDrawableOptions, float[] paramArrayOfFloat)
  {
    paramCornerImageView.setRadius(paramArrayOfFloat);
    paramCornerImageView.setImageURL(paramString);
  }
  
  public QQCustomMenuItem[] a(View paramView)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.QCircleFeedItemBuilder
 * JD-Core Version:    0.7.0.1
 */