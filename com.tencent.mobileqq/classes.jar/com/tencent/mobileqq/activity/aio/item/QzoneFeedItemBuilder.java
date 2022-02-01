package com.tencent.mobileqq.activity.aio.item;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewStub;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.AbstractChatItemBuilder;
import com.tencent.mobileqq.activity.aio.AbstractChatItemBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.BeancurdManager;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForQzoneFeed;
import com.tencent.mobileqq.data.MessageForQzoneFeed.MediaData;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.profile.PersonalityLabel.CornerImageView;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.TimeFormatterUtils;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.URLUtil;
import common.config.service.QzoneConfig;
import cooperation.qzone.QZoneClickReport;
import cooperation.qzone.QZoneClickReport.ReportInfo;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class QzoneFeedItemBuilder
  extends AbstractChatItemBuilder
{
  private static int r = -1;
  private final int e;
  private final int f;
  private final int g;
  private final int h;
  private final int i;
  private final int j;
  private final int k;
  private final int l;
  private final int m;
  private final int n;
  private final int o;
  private final int p;
  private final String q;
  
  public QzoneFeedItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
    paramBaseAdapter = this.c.getResources();
    this.e = AIOUtils.b(251.0F, paramBaseAdapter);
    this.f = AIOUtils.b(131.0F, paramBaseAdapter);
    this.g = AIOUtils.b(128.5F, paramBaseAdapter);
    this.h = AIOUtils.b(131.0F, paramBaseAdapter);
    this.i = AIOUtils.b(122.5F, paramBaseAdapter);
    this.j = AIOUtils.b(131.0F, paramBaseAdapter);
    this.k = AIOUtils.b(16.0F, paramBaseAdapter);
    this.o = AIOUtils.b(71.5F, paramBaseAdapter);
    this.p = AIOUtils.b(74.0F, paramBaseAdapter);
    this.l = QzoneConfig.getInstance().getConfig("QZoneSetting", "qzoneAioFriendFeedNicknameMaxLength", 10);
    this.m = QzoneConfig.getInstance().getConfig("QZoneSetting", "qzoneAioFriendFeedBlogTitleMaxLength", 8);
    this.n = QzoneConfig.getInstance().getConfig("QZoneSetting", "qzoneAioFriendFeedPicBlogTitleMaxLength", 12);
    this.q = QzoneConfig.getInstance().getConfig("QZoneSetting", "qzoneAioFriendFeedLogoWaterImgUrl", "https://qzonestyle.gtimg.cn/aoi/sola/20191119115951_pUMyXUXliB.png");
    paramQQAppInterface = (BeancurdManager)paramQQAppInterface.getManager(QQManagerFactory.BEANCURD_MANAGER);
    if (paramQQAppInterface != null) {
      paramQQAppInterface.a(3, 2);
    }
  }
  
  private int a(MessageForQzoneFeed paramMessageForQzoneFeed)
  {
    if (paramMessageForQzoneFeed.mediaDatas != null)
    {
      int i2 = paramMessageForQzoneFeed.mediaDatas.size();
      int i1 = 1;
      if (i2 > 1) {
        i1 = 2;
      }
      return i1;
    }
    if (!TextUtils.isEmpty(paramMessageForQzoneFeed.title)) {
      return 4;
    }
    return 3;
  }
  
  private View a(View paramView, QzoneFeedItemBuilder.Holder paramHolder)
  {
    View localView = paramView;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.c).inflate(2131624446, null);
      paramHolder.g = paramView;
      paramHolder.h = paramView.findViewById(2131428070);
      paramHolder.i = paramView.findViewById(2131428061);
      paramHolder.o = ((TextView)paramView.findViewById(2131428081));
      paramHolder.p = ((TextView)paramView.findViewById(2131428074));
      paramHolder.s = ((TextView)paramView.findViewById(2131428084));
      paramHolder.G = ((CornerImageView)paramView.findViewById(2131428079));
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
  
  private static String a(String paramString, int paramInt)
  {
    paramString = Utils.b(paramString, paramInt);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("《");
    localStringBuilder.append(paramString);
    localStringBuilder.append("》");
    return localStringBuilder.toString();
  }
  
  private void a(QzoneFeedItemBuilder.Holder paramHolder)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mRequestWidth = this.o;
    localURLDrawableOptions.mRequestHeight = this.p;
    paramHolder.G.setVisibility(0);
    CornerImageView localCornerImageView = paramHolder.G;
    int i1 = this.k;
    localCornerImageView.setRadius(new float[] { 0.0F, 0.0F, 0.0F, 0.0F, i1, i1, 0.0F, 0.0F });
    paramHolder.G.setAlpha(0.08F);
    localURLDrawableOptions.mFailedDrawable = new ColorDrawable(0);
    localURLDrawableOptions.mLoadingDrawable = localURLDrawableOptions.mFailedDrawable;
    paramHolder.G.setImageDrawable(URLDrawable.getDrawable(this.q, localURLDrawableOptions));
  }
  
  private void a(QzoneFeedItemBuilder.Holder paramHolder, int paramInt)
  {
    if (paramHolder.j == null)
    {
      paramHolder.j = ((ViewStub)paramHolder.g.findViewById(2131428073)).inflate();
      paramHolder.H = ((TextView)paramHolder.j.findViewById(2131428071));
    }
    paramHolder.j.setOnClickListener(new QzoneFeedItemBuilder.2(this));
    paramHolder.j.setVisibility(0);
    if (paramHolder.k != null) {
      paramHolder.k.setVisibility(8);
    }
    if (paramHolder.o != null) {
      paramHolder.o.setVisibility(8);
    }
    String str;
    if (paramInt == 1) {
      str = HardCodeUtil.a(2131909400);
    } else if (paramInt == 2) {
      str = HardCodeUtil.a(2131909411);
    } else {
      str = "TA";
    }
    if (paramHolder.H != null)
    {
      paramHolder = paramHolder.H;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(HardCodeUtil.a(2131909413));
      localStringBuilder.append(str);
      localStringBuilder.append(HardCodeUtil.a(2131909427));
      paramHolder.setText(localStringBuilder.toString());
    }
    paramHolder = new QZoneClickReport.ReportInfo();
    paramHolder.actionType = "330";
    paramHolder.subactionType = "3";
    paramHolder.reserves = "1";
    QZoneClickReport.startReportImediately(this.a.getAccount(), paramHolder);
  }
  
  private void a(QzoneFeedItemBuilder.Holder paramHolder, MessageForQzoneFeed paramMessageForQzoneFeed)
  {
    int i1 = a(paramMessageForQzoneFeed);
    if (i1 != 1)
    {
      if (i1 != 2)
      {
        if (i1 != 3)
        {
          if (i1 == 4) {
            d(paramHolder, paramMessageForQzoneFeed);
          }
        }
        else {
          e(paramHolder, paramMessageForQzoneFeed);
        }
      }
      else {
        c(paramHolder, paramMessageForQzoneFeed);
      }
    }
    else {
      b(paramHolder, paramMessageForQzoneFeed);
    }
    String str = Utils.b(this.d.e, this.l);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(str);
    ((StringBuilder)localObject).append(paramMessageForQzoneFeed.summery);
    localObject = ((StringBuilder)localObject).toString();
    paramHolder.p.setText((CharSequence)localObject);
    paramHolder.p.setVisibility(0);
    CharSequence localCharSequence = TimeFormatterUtils.a(this.c, 7, paramMessageForQzoneFeed.feedTime * 1000L);
    if (paramMessageForQzoneFeed.isFirstMsgWithNewFriend)
    {
      a(paramHolder, paramMessageForQzoneFeed.gender);
    }
    else
    {
      boolean bool;
      if ((paramMessageForQzoneFeed.mapExt != null) && (paramMessageForQzoneFeed.mapExt.containsKey("isliked"))) {
        bool = "1".equals(paramMessageForQzoneFeed.mapExt.get("isliked"));
      } else {
        bool = false;
      }
      if ((paramMessageForQzoneFeed.mapExt != null) && (paramMessageForQzoneFeed.mapExt.containsKey("likekey"))) {
        localObject = (String)paramMessageForQzoneFeed.mapExt.get("likekey");
      } else {
        localObject = "";
      }
      a(paramHolder, localCharSequence, paramMessageForQzoneFeed, paramMessageForQzoneFeed.ulikeNum, paramMessageForQzoneFeed.uCommentNum, paramMessageForQzoneFeed.appId, bool, (String)localObject);
    }
    if (v)
    {
      paramHolder.r.append(str);
      if (paramMessageForQzoneFeed.feedTime > 0L)
      {
        localObject = paramHolder.r;
        ((StringBuilder)localObject).append("于");
        ((StringBuilder)localObject).append(localCharSequence);
      }
      localObject = paramHolder.r;
      ((StringBuilder)localObject).append(paramMessageForQzoneFeed.summery);
      ((StringBuilder)localObject).append("内容是：");
      ((StringBuilder)localObject).append(paramMessageForQzoneFeed.title);
      ((StringBuilder)localObject).append(paramMessageForQzoneFeed.content);
      paramHolder.g.setContentDescription(paramHolder.r.toString());
    }
  }
  
  private void a(QzoneFeedItemBuilder.Holder paramHolder, CharSequence paramCharSequence, MessageForQzoneFeed paramMessageForQzoneFeed, int paramInt1, long paramLong, int paramInt2, boolean paramBoolean, String paramString)
  {
    if (paramHolder.k == null)
    {
      paramHolder.k = ((ViewStub)paramHolder.g.findViewById(2131428067)).inflate();
      paramHolder.C = ((TextView)paramHolder.k.findViewById(2131428086));
      paramHolder.D = ((TextView)paramHolder.k.findViewById(2131428083));
      paramHolder.E = ((ImageView)paramHolder.k.findViewById(2131428082));
      paramHolder.F = ((TextView)paramHolder.k.findViewById(2131428069));
    }
    paramHolder.C.setText(paramCharSequence);
    paramHolder.D.setText(b(paramInt1));
    paramCharSequence = paramHolder.E;
    int i1;
    if (paramBoolean) {
      i1 = 2130849416;
    } else {
      i1 = 2130849415;
    }
    paramCharSequence.setImageResource(i1);
    paramHolder.E.setOnClickListener(new QzoneFeedItemBuilder.3(this, paramBoolean, paramInt1, paramHolder, paramString, paramInt2, paramMessageForQzoneFeed));
    paramHolder.F.setText(b(paramLong));
    paramHolder.k.setVisibility(0);
    if (paramHolder.j != null) {
      paramHolder.j.setVisibility(8);
    }
    if (paramHolder.o != null) {
      paramHolder.o.setVisibility(0);
    }
  }
  
  private static void a(CornerImageView paramCornerImageView, View paramView, MessageForQzoneFeed.MediaData paramMediaData, URLDrawable.URLDrawableOptions paramURLDrawableOptions, float[] paramArrayOfFloat)
  {
    if (paramMediaData.uType == 1) {
      paramView.setVisibility(0);
    } else {
      paramView.setVisibility(8);
    }
    paramCornerImageView.setRadius(paramArrayOfFloat);
    paramView = b(paramMediaData.strImgUrl);
    if (!TextUtils.isEmpty(paramView)) {
      paramCornerImageView.setImageDrawable(URLDrawable.getDrawable(paramView, paramURLDrawableOptions));
    }
  }
  
  private static String b(long paramLong)
  {
    if (paramLong > 100000000L) {
      return String.format("%.1f亿", new Object[] { Float.valueOf((float)paramLong / 1.0E+008F) });
    }
    if (paramLong > 10000L) {
      return String.format("%.1f万", new Object[] { Float.valueOf((float)paramLong / 10000.0F) });
    }
    return String.format("%d", new Object[] { Long.valueOf(paramLong) });
  }
  
  public static String b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    int i1 = paramString.indexOf("http");
    if (i1 < 0) {
      return null;
    }
    paramString = paramString.substring(i1);
    try
    {
      new URL(paramString);
      return paramString;
    }
    catch (MalformedURLException paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  private void b(QzoneFeedItemBuilder.Holder paramHolder, MessageForQzoneFeed paramMessageForQzoneFeed)
  {
    if (paramMessageForQzoneFeed.mediaDatas != null)
    {
      if (paramMessageForQzoneFeed.mediaDatas.size() == 0) {
        return;
      }
      paramHolder.i.setVisibility(0);
      if (paramHolder.m != null) {
        paramHolder.m.setVisibility(8);
      }
      if (paramHolder.n != null) {
        paramHolder.n.setVisibility(8);
      }
      paramHolder.s.setVisibility(8);
      if (paramHolder.l == null)
      {
        paramHolder.l = ((ViewStub)paramHolder.g.findViewById(2131428085)).inflate();
        paramHolder.t = ((CornerImageView)paramHolder.g.findViewById(2131428075));
        paramHolder.u = ((ImageView)paramHolder.g.findViewById(2131428057));
      }
      paramHolder.h.setBackgroundResource(2130838227);
      paramHolder.G.setVisibility(8);
      paramHolder.l.setVisibility(0);
      MessageForQzoneFeed.MediaData localMediaData = (MessageForQzoneFeed.MediaData)paramMessageForQzoneFeed.mediaDatas.get(0);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("setDataToSinglePicContainer picUrl= ");
        ((StringBuilder)localObject).append(localMediaData.strImgUrl);
        QLog.d("QzoneFeedItemBuilder", 2, ((StringBuilder)localObject).toString());
      }
      if (paramMessageForQzoneFeed.appId == 2)
      {
        paramMessageForQzoneFeed = a(paramMessageForQzoneFeed.title, this.n);
        paramHolder.o.setText(paramMessageForQzoneFeed);
      }
      else
      {
        paramHolder.o.setText(paramMessageForQzoneFeed.content);
      }
      paramMessageForQzoneFeed = URLDrawable.URLDrawableOptions.obtain();
      paramMessageForQzoneFeed.mRequestWidth = this.e;
      paramMessageForQzoneFeed.mRequestHeight = this.f;
      Object localObject = paramHolder.t;
      paramHolder = paramHolder.u;
      int i1 = this.k;
      a((CornerImageView)localObject, paramHolder, localMediaData, paramMessageForQzoneFeed, new float[] { i1, i1, i1, i1, 0.0F, 0.0F, 0.0F, 0.0F });
    }
  }
  
  private void c(QzoneFeedItemBuilder.Holder paramHolder, MessageForQzoneFeed paramMessageForQzoneFeed)
  {
    if (paramMessageForQzoneFeed.mediaDatas != null)
    {
      if (paramMessageForQzoneFeed.mediaDatas.size() < 2) {
        return;
      }
      paramHolder.i.setVisibility(0);
      if (paramHolder.l != null) {
        paramHolder.l.setVisibility(8);
      }
      if (paramHolder.n != null) {
        paramHolder.n.setVisibility(8);
      }
      paramHolder.s.setVisibility(8);
      if (paramHolder.m == null)
      {
        paramHolder.m = ((ViewStub)paramHolder.g.findViewById(2131428080)).inflate();
        paramHolder.v = ((CornerImageView)paramHolder.g.findViewById(2131428076));
        paramHolder.w = ((ImageView)paramHolder.g.findViewById(2131428087));
        paramHolder.x = ((CornerImageView)paramHolder.g.findViewById(2131428077));
        paramHolder.y = ((ImageView)paramHolder.g.findViewById(2131428078));
        paramHolder.z = ((TextView)paramHolder.g.findViewById(2131428053));
      }
      paramHolder.h.setBackgroundResource(2130838227);
      paramHolder.G.setVisibility(8);
      paramHolder.m.setVisibility(0);
      if (paramMessageForQzoneFeed.appId == 2)
      {
        localObject1 = a(paramMessageForQzoneFeed.title, this.n);
        paramHolder.o.setText((CharSequence)localObject1);
      }
      else
      {
        paramHolder.o.setText(paramMessageForQzoneFeed.content);
      }
      if (paramMessageForQzoneFeed.imageCount > 2) {
        paramHolder.z.setText(String.format("共 %s 个", new Object[] { b(paramMessageForQzoneFeed.imageCount) }));
      } else {
        paramHolder.z.setText("");
      }
      Object localObject2 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject2).mRequestWidth = this.g;
      ((URLDrawable.URLDrawableOptions)localObject2).mRequestHeight = this.h;
      Object localObject1 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject1).mRequestWidth = this.i;
      ((URLDrawable.URLDrawableOptions)localObject1).mRequestHeight = this.j;
      CornerImageView localCornerImageView = paramHolder.v;
      ImageView localImageView = paramHolder.w;
      MessageForQzoneFeed.MediaData localMediaData = (MessageForQzoneFeed.MediaData)paramMessageForQzoneFeed.mediaDatas.get(0);
      int i1 = this.k;
      a(localCornerImageView, localImageView, localMediaData, (URLDrawable.URLDrawableOptions)localObject2, new float[] { i1, i1, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F });
      localObject2 = paramHolder.x;
      paramHolder = paramHolder.y;
      paramMessageForQzoneFeed = (MessageForQzoneFeed.MediaData)paramMessageForQzoneFeed.mediaDatas.get(1);
      i1 = this.k;
      a((CornerImageView)localObject2, paramHolder, paramMessageForQzoneFeed, (URLDrawable.URLDrawableOptions)localObject1, new float[] { 0.0F, 0.0F, i1, i1, 0.0F, 0.0F, 0.0F, 0.0F });
    }
  }
  
  private void d(QzoneFeedItemBuilder.Holder paramHolder, MessageForQzoneFeed paramMessageForQzoneFeed)
  {
    paramHolder.i.setVisibility(8);
    paramHolder.s.setVisibility(8);
    if (paramHolder.n == null)
    {
      paramHolder.n = ((ViewStub)paramHolder.g.findViewById(2131428064)).inflate();
      paramHolder.A = ((TextView)paramHolder.g.findViewById(2131428065));
      paramHolder.B = ((TextView)paramHolder.g.findViewById(2131428063));
    }
    paramHolder.h.setBackgroundResource(2130838229);
    a(paramHolder);
    paramHolder.n.setVisibility(0);
    String str = a(paramMessageForQzoneFeed.title, this.m);
    paramHolder.A.setText(str);
    paramHolder.B.setText(paramMessageForQzoneFeed.content);
  }
  
  private void e(QzoneFeedItemBuilder.Holder paramHolder, MessageForQzoneFeed paramMessageForQzoneFeed)
  {
    paramHolder.i.setVisibility(8);
    if (paramHolder.n != null) {
      paramHolder.n.setVisibility(8);
    }
    paramHolder.h.setBackgroundResource(2130838229);
    a(paramHolder);
    paramHolder.s.setVisibility(0);
    paramHolder.s.setText(paramMessageForQzoneFeed.content);
  }
  
  protected View a(MessageRecord paramMessageRecord, AbstractChatItemBuilder.ViewHolder paramViewHolder, View paramView, LinearLayout paramLinearLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    if (QLog.isColorLevel())
    {
      paramLinearLayout = new StringBuilder();
      paramLinearLayout.append("getItemView: invoked. info: message = ");
      paramLinearLayout.append(paramMessageRecord);
      QLog.i("QzoneFeedItemBuilder", 2, paramLinearLayout.toString());
    }
    paramLinearLayout = (MessageForQzoneFeed)paramMessageRecord;
    paramMessageRecord = (QzoneFeedItemBuilder.Holder)paramViewHolder;
    paramView = a(paramView, paramMessageRecord);
    paramMessageRecord.d = paramLinearLayout.uniseq;
    paramMessageRecord.e = paramLinearLayout.frienduin;
    paramViewHolder = null;
    paramMessageRecord.f = null;
    paramLinearLayout.coverImageUrl = b(paramLinearLayout.coverImageUrl);
    a(paramMessageRecord, paramLinearLayout);
    paramMessageRecord.h.setOnClickListener(new QzoneFeedItemBuilder.1(this, paramLinearLayout));
    if (!paramLinearLayout.hasExposed)
    {
      ReportController.b(this.a, "CliOper", "", "", "0X8005FFF", "0X8005FFF", 0, 0, "", "", "", "");
      paramLinearLayout.hasExposed = true;
    }
    paramMessageRecord = URLUtil.a(paramLinearLayout.actionUrl);
    if (paramMessageRecord != null) {
      paramViewHolder = (String)paramMessageRecord.get("a");
    }
    if (paramViewHolder != null)
    {
      paramMessageRecord = "4";
      if (paramViewHolder.equals("4")) {
        paramMessageRecord = "1";
      } else if (paramViewHolder.equals("311")) {
        paramMessageRecord = "2";
      } else if (paramViewHolder.equals("2")) {
        paramMessageRecord = "3";
      }
      paramViewHolder = new QZoneClickReport.ReportInfo();
      paramViewHolder.actionType = "330";
      paramViewHolder.subactionType = "1";
      paramViewHolder.reserves = paramMessageRecord;
      if (paramLinearLayout.isFirstMsgWithNewFriend) {
        paramViewHolder.reserves10 = "1";
      }
      paramViewHolder.reservesExt = new ArrayList();
      paramViewHolder.reservesExt.add(paramLinearLayout.actionUrl);
      QZoneClickReport.startReportImediately(this.a.getAccount(), paramViewHolder);
    }
    return paramView;
  }
  
  protected AbstractChatItemBuilder.ViewHolder a()
  {
    return new QzoneFeedItemBuilder.Holder(this);
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage) {}
  
  public boolean a(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && ((paramString.startsWith("http://")) || (paramString.startsWith("https://"))))
    {
      Intent localIntent = new Intent(this.c, QQBrowserActivity.class);
      localIntent.putExtra("url", paramString);
      localIntent.putExtra("fromAio", true);
      ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).modifyIntentForSpecificBrowserIfNeeded(localIntent, paramString);
      this.c.startActivity(localIntent);
      return true;
    }
    return false;
  }
  
  public QQCustomMenuItem[] a(View paramView)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.QzoneFeedItemBuilder
 * JD-Core Version:    0.7.0.1
 */