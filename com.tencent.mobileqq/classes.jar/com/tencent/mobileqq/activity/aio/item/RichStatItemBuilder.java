package com.tencent.mobileqq.activity.aio.item;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity.Launcher;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.AbstractChatItemBuilder;
import com.tencent.mobileqq.activity.aio.AbstractChatItemBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.BeancurdManager;
import com.tencent.mobileqq.activity.aio.ChatBackground;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.SignatureHandler;
import com.tencent.mobileqq.app.SignatureManager;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForRichState;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.richstatus.IIconListener;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.richstatus.SignatureHistoryFragment;
import com.tencent.mobileqq.richstatus.StatusManager;
import com.tencent.mobileqq.richstatus.sign.AIOSignViewHolder;
import com.tencent.mobileqq.richstatus.sign.BoxShadowLayout;
import com.tencent.mobileqq.richstatus.sign.ISignViewHolder;
import com.tencent.mobileqq.richstatus.sign.ISignViewHolder.OnClickListener;
import com.tencent.mobileqq.richstatus.topic.TopicUtil;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.text.ITopic;
import com.tencent.mobileqq.text.ITopic.OnTopicClickListener;
import com.tencent.mobileqq.together.TogetherUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.TimeFormatterUtils;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import org.json.JSONArray;

public class RichStatItemBuilder
  extends AbstractChatItemBuilder
  implements IIconListener, ISignViewHolder.OnClickListener, ITopic.OnTopicClickListener
{
  public static long e;
  private static RichStatus o;
  HashSet<RichStatItemBuilder.Holder> f = new HashSet();
  StatusManager g;
  SignatureManager h;
  AIOAnimationConatiner i = null;
  MessageForRichState j = null;
  protected Handler k = new Handler(Looper.getMainLooper());
  RichStatItemBuilder.WeakHolder l = new RichStatItemBuilder.WeakHolder(null);
  long m;
  long n;
  
  public RichStatItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
    this.l.a = new WeakReference(this);
    this.j = null;
    this.g = ((StatusManager)paramQQAppInterface.getManager(QQManagerFactory.STATUS_MANAGER));
    this.h = ((SignatureManager)paramQQAppInterface.getManager(QQManagerFactory.SIGNATURE_MANAGER));
    this.i = paramAIOAnimationConatiner;
    paramQQAppInterface = (BeancurdManager)paramQQAppInterface.getManager(QQManagerFactory.BEANCURD_MANAGER);
    if (paramQQAppInterface != null) {
      paramQQAppInterface.a(3, 1);
    }
    paramQQAppInterface = this.g;
    if (paramQQAppInterface != null) {
      paramQQAppInterface.a(this.l);
    }
  }
  
  private void a(int paramInt1, int paramInt2, Bitmap paramBitmap, int paramInt3)
  {
    if (paramBitmap != null) {
      this.b.notifyDataSetChanged();
    }
  }
  
  private void a(MessageForRichState paramMessageForRichState)
  {
    if (o == null) {
      o = new RichStatus(null);
    }
    o.feedsId = paramMessageForRichState.feedId;
    o.tplId = paramMessageForRichState.tplId;
    RichStatus localRichStatus = o;
    int i1;
    if (TextUtils.isEmpty(paramMessageForRichState.actionId)) {
      i1 = o.actionId;
    } else {
      i1 = Integer.parseInt(paramMessageForRichState.actionId);
    }
    localRichStatus.actionId = i1;
    o.actionText = paramMessageForRichState.actionText;
    localRichStatus = o;
    if (TextUtils.isEmpty(paramMessageForRichState.dataId)) {
      i1 = o.dataId;
    } else {
      i1 = Integer.parseInt(paramMessageForRichState.dataId);
    }
    localRichStatus.dataId = i1;
    o.dataText = paramMessageForRichState.dataText;
    o.locationText = paramMessageForRichState.locText;
    localRichStatus = o;
    if (TextUtils.isEmpty(paramMessageForRichState.locPos)) {
      i1 = o.locationPosition;
    } else {
      i1 = Integer.parseInt(paramMessageForRichState.locPos);
    }
    localRichStatus.locationPosition = i1;
    o.time = paramMessageForRichState.time;
    o.fontId = paramMessageForRichState.fontId;
    o.fontType = paramMessageForRichState.fontType;
    o.plainText = null;
    if ((paramMessageForRichState.plainText != null) && (paramMessageForRichState.plainText.length() > 0))
    {
      o.plainText = new ArrayList(paramMessageForRichState.plainText.length());
      i1 = 0;
      while (i1 < paramMessageForRichState.plainText.length())
      {
        o.plainText.add(paramMessageForRichState.plainText.optString(i1));
        i1 += 1;
      }
    }
    o.topicFromJson(paramMessageForRichState.topics);
    o.topicPosFromJson(paramMessageForRichState.topicsPos);
  }
  
  private void d()
  {
    Intent localIntent = new Intent(this.c, PublicFragmentActivity.class);
    localIntent.putExtra("key_uin", this.d.b);
    localIntent.putExtra("key_uin_name", this.d.e);
    localIntent.putExtra("key_open_via", "history-liaotian");
    PublicFragmentActivity.Launcher.a(this.c, localIntent, PublicFragmentActivity.class, SignatureHistoryFragment.class);
    ReportController.b(this.a, "CliOper", "", "", "signiture", "aio_clk_his", 0, 0, "", "", "", "");
    ReportController.b(this.a, "dc00898", "", "", "0x8009434", "0x8009434", 0, 0, "", "1", "", "");
    VasWebviewUtil.a(this.a.getCurrentAccountUin(), "signature_aio", "click", "", 0, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
  }
  
  private void e()
  {
    if (System.currentTimeMillis() - this.m > 2000L)
    {
      this.m = System.currentTimeMillis();
      ReportController.b(null, "dc00898", "", "", "0X800A4EB", "0X800A4EB", 0, 0, "0", "0", "", "");
    }
  }
  
  protected View a(MessageRecord paramMessageRecord, AbstractChatItemBuilder.ViewHolder paramViewHolder, View paramView, LinearLayout paramLinearLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    this.j = ((MessageForRichState)paramMessageRecord);
    e = this.j.uniseq;
    paramLinearLayout = (RichStatItemBuilder.Holder)paramViewHolder;
    paramMessageRecord = paramView;
    if (paramView == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AIOSignViewHolder", 2, "convertView is null, create SignatureView.");
      }
      paramMessageRecord = new BoxShadowLayout(this.c);
      paramViewHolder = new ViewGroup.MarginLayoutParams(-1, -2);
      int i1 = AIOUtils.b(6.0F, this.c.getResources());
      paramViewHolder.leftMargin = i1;
      paramViewHolder.rightMargin = i1;
      paramMessageRecord.setLayoutParams(paramViewHolder);
      paramLinearLayout.d = new AIOSignViewHolder(this.c, this.a, paramMessageRecord, this.j.frienduin);
      paramLinearLayout.d.a(this);
      paramLinearLayout.d.a(this);
    }
    a(this.j);
    paramLinearLayout.d.d = this.j.uniseq;
    paramLinearLayout.d.A = this.j.frienduin;
    paramLinearLayout.d.e = this.j.istroop;
    paramLinearLayout.d.f = this.j.feedId;
    paramLinearLayout.d.g = this.j.tplId;
    paramLinearLayout.d.h = this.j.count;
    paramLinearLayout.d.y = this.j.zanFlag;
    if (this.d.H.b != null) {
      paramLinearLayout.d.c = this.d.H.b.getDefaultColor();
    }
    paramViewHolder = this.j.ver;
    if ((paramViewHolder != null) && (paramViewHolder.equals("1.0")))
    {
      if (this.j.time > 0L) {
        paramViewHolder = TimeFormatterUtils.a(this.c, 3, this.j.time * 1000L);
      } else {
        paramViewHolder = null;
      }
      if (this.d.e != null) {
        paramView = this.d.e;
      } else {
        paramView = this.d.b;
      }
      paramView = TogetherUtils.a(20, paramView);
      paramOnLongClickAndTouchListener = new StringBuilder();
      paramOnLongClickAndTouchListener.append(paramView);
      paramOnLongClickAndTouchListener.append(HardCodeUtil.a(2131910924));
      paramOnLongClickAndTouchListener = paramOnLongClickAndTouchListener.toString();
      paramLinearLayout.d.b = paramOnLongClickAndTouchListener;
      if (v)
      {
        paramOnLongClickAndTouchListener = o.getPlainText();
        if (paramLinearLayout.r == null) {
          paramLinearLayout.r = new StringBuilder();
        } else if (paramLinearLayout.r.length() > 0) {
          paramLinearLayout.r.delete(0, paramLinearLayout.r.length());
        }
        paramLinearLayout.r.append(paramView);
        if (this.j.time > 0L)
        {
          paramView = paramLinearLayout.r;
          paramView.append("于");
          paramView.append(paramViewHolder);
        }
        paramViewHolder = paramLinearLayout.r;
        paramViewHolder.append("更新了签名，内容是：");
        paramViewHolder.append(paramOnLongClickAndTouchListener);
        paramMessageRecord.setContentDescription(paramLinearLayout.r.toString());
      }
    }
    paramLinearLayout.d.a(o);
    this.a.getMsgCache().f(this.d.b, o.time);
    ThreadManager.post(new RichStatItemBuilder.1(this), 8, null, true);
    e();
    return paramMessageRecord;
  }
  
  protected AbstractChatItemBuilder.ViewHolder a()
  {
    RichStatItemBuilder.Holder localHolder = new RichStatItemBuilder.Holder();
    this.f.add(localHolder);
    return localHolder;
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage) {}
  
  public void a(View paramView, int paramInt, ISignViewHolder paramISignViewHolder)
  {
    QLog.d("ChatItemBuilder", 1, new Object[] { "onClick viewType=", paramView });
    if (paramInt == 3)
    {
      d();
      paramInt = 2;
    }
    else if (paramInt == 4)
    {
      a(paramISignViewHolder);
      paramInt = 3;
    }
    else
    {
      d();
      paramInt = 1;
    }
    ReportController.b(this.a, "dc00898", "", "", "0X800A98E", "0X800A98E", paramInt, 0, "0", "0", "", "");
  }
  
  public void a(ISignViewHolder paramISignViewHolder)
  {
    if (!TextUtils.isEmpty(o.feedsId))
    {
      Resources localResources = this.c.getResources();
      if (!NetworkUtil.isNetSupport(this.c))
      {
        QQToast.makeText(this.c, localResources.getString(2131889169), 0).show(((BaseActivity)this.c).getTitleBarHeight());
        return;
      }
      long l1 = System.currentTimeMillis();
      if (Math.abs(l1 - this.n) < 200L)
      {
        QQToast.makeText(this.c, localResources.getString(2131887809), 0).show(((BaseActivity)this.c).getTitleBarHeight());
        return;
      }
      this.n = l1;
    }
    for (;;)
    {
      try
      {
        paramISignViewHolder = (AIOSignViewHolder)paramISignViewHolder;
        i1 = paramISignViewHolder.h;
        int i3 = paramISignViewHolder.y;
        int i2 = 1;
        if (i3 == 0)
        {
          paramISignViewHolder.y = 1;
          i1 += 1;
          ReportController.b(this.a, "CliOper", "", "", "signiture", "aio_act_on", 0, 0, "", "", "", "");
        }
        else
        {
          paramISignViewHolder.y = 0;
          i1 -= 1;
          if (i1 <= 0) {
            break label307;
          }
          ReportController.b(this.a, "CliOper", "", "", "signiture", "aio_act_off", 0, 0, "", "", "", "");
          i2 = 0;
        }
        paramISignViewHolder.h = i1;
        paramISignViewHolder.t();
        ((SignatureHandler)this.a.getBusinessHandler(BusinessHandlerFactory.SIGNATURE_HANDLER)).a(this.d.b, paramISignViewHolder.f, 255, i2);
        return;
      }
      catch (Exception paramISignViewHolder)
      {
        if (QLog.isColorLevel()) {
          QLog.i("ChatItemBuilder", 2, paramISignViewHolder.getMessage(), paramISignViewHolder);
        }
      }
      return;
      label307:
      int i1 = 0;
    }
  }
  
  public QQCustomMenuItem[] a(View paramView)
  {
    return null;
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.i("ChatItemBuilder", 2, "RichStatItemBuilder destroy");
    }
    Object localObject = this.f.iterator();
    while (((Iterator)localObject).hasNext())
    {
      RichStatItemBuilder.Holder localHolder = (RichStatItemBuilder.Holder)((Iterator)localObject).next();
      if (localHolder.d != null) {
        localHolder.d.v();
      }
    }
    localObject = this.g;
    if (localObject != null) {
      ((StatusManager)localObject).b(this.l);
    }
    this.g = null;
    this.h = null;
  }
  
  public void onClick(ITopic paramITopic, View paramView)
  {
    QLog.d("ChatItemBuilder", 1, new Object[] { "onClick topic=", paramITopic });
    paramITopic = paramITopic.getData();
    if ((paramITopic instanceof Pair))
    {
      paramITopic = (Pair)paramITopic;
      if (QLog.isColorLevel()) {
        QLog.i("ChatItemBuilder", 2, String.format("aio onTopicClick [%d,%s]", new Object[] { paramITopic.first, paramITopic.second }));
      }
      TopicUtil.a(this.c, TopicUtil.a(((Integer)paramITopic.first).intValue(), (String)paramITopic.second), -1);
    }
  }
  
  public void onGetIcon(int paramInt1, int paramInt2, Bitmap paramBitmap)
  {
    if (paramBitmap != null) {
      this.b.notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.RichStatItemBuilder
 * JD-Core Version:    0.7.0.1
 */