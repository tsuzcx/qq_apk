package com.tencent.mobileqq.activity.aio.item;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.PayBridgeActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.QQWalletTransferMsg;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.hb.aio.QQWalletBaseMsgElem;
import com.tencent.mobileqq.qwallet.transaction.INotifyMsgApi;
import com.tencent.mobileqq.qwallet.transaction.NotifyMsgObserver;
import com.tencent.mobileqq.qwallet.widget.QQWalletTransferBubbleView;
import com.tencent.mobileqq.service.message.remote.MessageRecordInfo;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONObject;

public class QQWalletTransMsgItemBuilder
  extends BaseBubbleBuilder
{
  private static int U = 0;
  private static int V = 0;
  private static int W = 0;
  public static final String a = "QQWalletTransMsgItemBuilder";
  protected final int A = 2131443087;
  protected final int B = 2131443086;
  protected final int C = 2131443089;
  final String D = "pay";
  final String E = "pfa";
  protected int F;
  protected int G;
  protected int H;
  protected int I;
  protected int J;
  protected int K;
  protected int L;
  protected int M;
  protected int N;
  protected int O;
  protected String P = "";
  long Q;
  protected float R = 1.0F;
  protected HashMap<String, SparseArray<WeakReference<QQWalletTransMsgItemBuilder.QWalletTransMsgHolder>>> S = new HashMap();
  protected NotifyMsgObserver T = new QQWalletTransMsgItemBuilder.2(this);
  private View.OnClickListener X = new QQWalletTransMsgItemBuilder.1(this);
  protected final int w = 2131443075;
  protected final int x = 2131443101;
  protected final int y = 2131443088;
  protected final int z = 2131443098;
  
  public QQWalletTransMsgItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.P = paramContext.getString(2131914264);
    this.R = paramContext.getResources().getDisplayMetrics().density;
    float f = this.R;
    this.G = ((int)(42.0F * f + 0.5F));
    this.H = ((int)(21.0F * f + 0.5F));
    this.I = ((int)(15.0F * f + 0.5F));
    this.J = ((int)(10.0F * f + 0.5F));
    this.K = ((int)(9.0F * f + 0.5F));
    this.L = ((int)(6.5F * f + 0.5F));
    this.M = ((int)(4.0F * f + 0.5F));
    this.N = ((int)(1.0F * f + 0.5F));
    this.F = (this.J * 23);
    this.O = ((int)(f * 7.0F + 0.5F));
    int i = this.N;
    U = i * 2;
    V = i * 2;
    W = this.O;
  }
  
  private RelativeLayout a(QQWalletTransMsgItemBuilder.QWalletTransMsgHolder paramQWalletTransMsgHolder, Context paramContext)
  {
    RelativeLayout localRelativeLayout = new RelativeLayout(paramContext);
    localRelativeLayout.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
    QQWalletTransferBubbleView localQQWalletTransferBubbleView = new QQWalletTransferBubbleView(paramContext);
    localQQWalletTransferBubbleView.setLayoutParams(new RelativeLayout.LayoutParams(this.F, this.I * 5));
    localQQWalletTransferBubbleView.setId(2131443075);
    ImageView localImageView = new ImageView(paramContext);
    int i = this.G;
    Object localObject1 = new RelativeLayout.LayoutParams(i, i);
    ((RelativeLayout.LayoutParams)localObject1).rightMargin = this.H;
    ((RelativeLayout.LayoutParams)localObject1).addRule(15);
    ((RelativeLayout.LayoutParams)localObject1).addRule(11);
    localImageView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    localImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
    localImageView.setId(2131443101);
    localQQWalletTransferBubbleView.addView(localImageView);
    Object localObject2 = new LinearLayout(paramContext);
    localObject1 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject1).addRule(0, 2131443101);
    ((RelativeLayout.LayoutParams)localObject1).addRule(9);
    ((RelativeLayout.LayoutParams)localObject1).leftMargin = this.H;
    ((RelativeLayout.LayoutParams)localObject1).rightMargin = this.L;
    ((RelativeLayout.LayoutParams)localObject1).addRule(15);
    ((LinearLayout)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject1);
    ((LinearLayout)localObject2).setOrientation(1);
    localObject1 = new TextView(paramContext);
    ((TextView)localObject1).setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
    ((TextView)localObject1).setSingleLine();
    ((TextView)localObject1).setEllipsize(TextUtils.TruncateAt.END);
    ((TextView)localObject1).setTextSize(24.0F);
    ((TextView)localObject1).setId(2131443088);
    ((LinearLayout)localObject2).addView((View)localObject1);
    TextView localTextView = new TextView(paramContext);
    Object localObject3 = new LinearLayout.LayoutParams(-2, -2);
    ((LinearLayout.LayoutParams)localObject3).topMargin = this.N;
    localTextView.setLayoutParams((ViewGroup.LayoutParams)localObject3);
    localTextView.setSingleLine();
    localTextView.setEllipsize(TextUtils.TruncateAt.END);
    localTextView.setTextSize(13.0F);
    localTextView.setId(2131443098);
    ((LinearLayout)localObject2).addView(localTextView);
    localQQWalletTransferBubbleView.addView((View)localObject2);
    localRelativeLayout.addView(localQQWalletTransferBubbleView);
    localObject2 = new QQWalletTransferBubbleView(paramContext);
    localObject3 = new RelativeLayout.LayoutParams(this.F, -2);
    ((RelativeLayout.LayoutParams)localObject3).addRule(3, 2131443075);
    ((QQWalletTransferBubbleView)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject3);
    ((QQWalletTransferBubbleView)localObject2).setBackgroundResource(2130849134);
    ((QQWalletTransferBubbleView)localObject2).setId(2131443087);
    paramContext = new TextView(paramContext);
    localObject3 = new RelativeLayout.LayoutParams(-2, -2);
    i = this.H;
    ((RelativeLayout.LayoutParams)localObject3).leftMargin = i;
    ((RelativeLayout.LayoutParams)localObject3).rightMargin = i;
    i = this.I;
    ((RelativeLayout.LayoutParams)localObject3).topMargin = i;
    ((RelativeLayout.LayoutParams)localObject3).bottomMargin = i;
    ((RelativeLayout.LayoutParams)localObject3).addRule(15);
    paramContext.setLayoutParams((ViewGroup.LayoutParams)localObject3);
    paramContext.setSingleLine();
    paramContext.setEllipsize(TextUtils.TruncateAt.END);
    paramContext.setTextColor(-7500403);
    paramContext.setTextSize(12.0F);
    paramContext.setIncludeFontPadding(false);
    paramContext.setId(2131443086);
    ((QQWalletTransferBubbleView)localObject2).addView(paramContext);
    localRelativeLayout.addView((View)localObject2);
    paramQWalletTransMsgHolder.b = ((TextView)localObject1);
    paramQWalletTransMsgHolder.c = localTextView;
    paramQWalletTransMsgHolder.d = localImageView;
    paramQWalletTransMsgHolder.e = paramContext;
    paramQWalletTransMsgHolder.f = ((QQWalletTransferBubbleView)localObject2);
    paramQWalletTransMsgHolder.g = localQQWalletTransferBubbleView;
    return localRelativeLayout;
  }
  
  private TextView a(Context paramContext)
  {
    paramContext = new TextView(paramContext);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.topMargin = this.J;
    localLayoutParams.bottomMargin = this.L;
    int i = this.G;
    int j = this.M;
    localLayoutParams.leftMargin = (i + j);
    localLayoutParams.rightMargin = (i + j);
    localLayoutParams.addRule(3, 2131430578);
    localLayoutParams.addRule(14);
    paramContext.setLayoutParams(localLayoutParams);
    paramContext.setTextColor(-1);
    paramContext.setBackgroundResource(2130846198);
    i = this.K;
    paramContext.setPadding(i, this.M, i, 0);
    paramContext.setClickable(false);
    paramContext.setVisibility(8);
    paramContext.setGravity(16);
    paramContext.setIncludeFontPadding(false);
    paramContext.setLineSpacing(this.M, 1.0F);
    paramContext.setTextSize(12.0F);
    paramContext.setId(2131443089);
    return paramContext;
  }
  
  private void a(TextView paramTextView, String paramString)
  {
    if (paramTextView != null)
    {
      if (paramString == null) {
        return;
      }
      paramTextView.setTextSize(24.0F);
      TextPaint localTextPaint = paramTextView.getPaint();
      if (localTextPaint != null)
      {
        float f = localTextPaint.measureText(paramString);
        if (this.F > BaseChatItemLayout.e)
        {
          if (f > BaseChatItemLayout.e - this.J * 9) {
            paramTextView.setTextSize(14.0F);
          }
        }
        else if (f > this.J * 14) {
          paramTextView.setTextSize(14.0F);
        }
      }
      paramTextView.setText(paramString);
    }
  }
  
  private void a(QQWalletTransMsgItemBuilder.QWalletTransMsgHolder paramQWalletTransMsgHolder, MessageForQQWalletMsg paramMessageForQQWalletMsg, QQWalletBaseMsgElem paramQQWalletBaseMsgElem, boolean paramBoolean, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    int i;
    if (paramMessageForQQWalletMsg.messageType == 16) {
      i = 1;
    } else {
      i = 0;
    }
    a(paramQWalletTransMsgHolder.b, paramQQWalletBaseMsgElem.c);
    paramQWalletTransMsgHolder.b.setTextColor(paramQQWalletBaseMsgElem.i);
    paramQWalletTransMsgHolder.c.setText(paramQQWalletBaseMsgElem.d);
    paramQWalletTransMsgHolder.c.setTextColor(paramQQWalletBaseMsgElem.j);
    paramQWalletTransMsgHolder.e.setText(paramQQWalletBaseMsgElem.e);
    if (i != 0)
    {
      localObject = this.e.getResources().getDrawable(a(paramQQWalletBaseMsgElem.b));
      if (!TextUtils.isEmpty(paramQQWalletBaseMsgElem.n)) {
        localObject = URLDrawableHelper.getDrawable(paramQQWalletBaseMsgElem.n, (int)DisplayUtils.a(this.e, this.G), (int)DisplayUtils.a(this.e, this.G), null, null);
      }
      paramQWalletTransMsgHolder.d.setImageDrawable((Drawable)localObject);
    }
    if (ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().waitAppRuntime(null), false, null))
    {
      paramQWalletTransMsgHolder.g.setBubbleNightBackground(2130849133, Color.parseColor("#FF19BAFF"), paramBoolean);
      paramQWalletTransMsgHolder.f.setBubbleBackground(2130849134, Color.parseColor("#A4A5A8"), paramBoolean);
      paramQWalletTransMsgHolder.b.setTextColor(Color.parseColor("#B2B2B2"));
      paramQWalletTransMsgHolder.c.setTextColor(Color.parseColor("#B2B2B2"));
      paramQWalletTransMsgHolder.e.setTextColor(Color.parseColor("#5D616B"));
    }
    else if (SimpleUIUtil.e())
    {
      paramQWalletTransMsgHolder.g.setBubbleBackground(2130849133, Color.parseColor("#FF19BAFF"), paramBoolean);
      paramQWalletTransMsgHolder.f.setBubbleBackground(2130849134, Color.parseColor("#FFECEDF2"), paramBoolean);
      paramQWalletTransMsgHolder.e.setTextColor(Color.parseColor("#FF878B99"));
    }
    else
    {
      paramQWalletTransMsgHolder.g.setBubbleBackground(2130849133, paramQQWalletBaseMsgElem.a, paramBoolean);
      if (paramQQWalletBaseMsgElem.p != 0) {
        paramQWalletTransMsgHolder.f.setBubbleBackground(2130849134, paramQQWalletBaseMsgElem.p, paramBoolean);
      }
      if (paramQQWalletBaseMsgElem.o != 0) {
        paramQWalletTransMsgHolder.e.setTextColor(paramQQWalletBaseMsgElem.o);
      }
    }
    Object localObject = paramQWalletTransMsgHolder.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramQQWalletBaseMsgElem.c);
    localStringBuilder.append(paramQQWalletBaseMsgElem.d);
    localStringBuilder.append(this.P);
    ((RelativeLayout)localObject).setContentDescription(localStringBuilder.toString());
    paramQWalletTransMsgHolder.a.setOnClickListener(this.X);
    paramQWalletTransMsgHolder.a.setOnLongClickListener(paramOnLongClickAndTouchListener);
    paramQWalletTransMsgHolder.a.setOnTouchListener(paramOnLongClickAndTouchListener);
    if (i != 0) {
      a(paramQWalletTransMsgHolder, paramMessageForQQWalletMsg, paramQQWalletBaseMsgElem);
    }
  }
  
  private boolean a(Context paramContext, String paramString1, String paramString2, String paramString3, MessageForQQWalletMsg paramMessageForQQWalletMsg, SessionInfo paramSessionInfo)
  {
    if ((paramContext != null) && (!TextUtils.isEmpty(paramString1)))
    {
      paramString2 = paramString1.split("\\?");
      paramSessionInfo = paramString2[0];
      if (TextUtils.isEmpty(paramSessionInfo)) {
        return false;
      }
      if (paramString2.length > 1) {
        paramString2 = paramMessageForQQWalletMsg.parseUrlParams(paramString2[1]);
      } else {
        paramString2 = new HashMap();
      }
      if (paramSessionInfo.equals("pay"))
      {
        paramString1 = (String)paramString2.get("payData");
        paramString2 = (String)paramString2.get("reqCode");
        if (!TextUtils.isEmpty(paramString2))
        {
          if (TextUtils.isEmpty(paramString1)) {
            return false;
          }
          paramString3 = new Bundle();
          paramString3.putString("json", paramString1);
          paramString3.putString("callbackSn", "0");
          paramString1 = new Intent(paramContext, PayBridgeActivity.class);
          paramString1.putExtras(paramString3);
          paramString1.putExtra("pay_requestcode", Integer.valueOf(paramString2).intValue());
        }
        else
        {
          return false;
        }
      }
      else if (paramSessionInfo.equals("pfa"))
      {
        paramMessageForQQWalletMsg = (String)paramString2.get("data");
        paramString3 = (String)paramString2.get("tokenid");
        if ((!TextUtils.isEmpty(paramString3)) && (!TextUtils.isEmpty(paramMessageForQQWalletMsg)))
        {
          paramString2 = new JSONObject();
          try
          {
            paramString2.put("userId", this.d.getCurrentAccountUin());
            paramString2.put("viewTag", "payByFriendConfirm");
            paramString2.put("appInfo", "appid#1344242394|bargainor_id#1000030201|channel#paymsg");
            paramString2.put("comeForm", 2);
            paramMessageForQQWalletMsg = new JSONObject();
            paramMessageForQQWalletMsg.put("pfa_req", paramString1);
            paramMessageForQQWalletMsg.put("token_id", paramString3);
            paramString2.put("extra_data", paramMessageForQQWalletMsg);
          }
          catch (Exception paramString1)
          {
            if (QLog.isDevelopLevel()) {
              paramString1.printStackTrace();
            }
          }
          paramString3 = new Bundle();
          paramString3.putString("json", paramString2.toString());
          paramString3.putString("callbackSn", "0");
          paramString1 = new Intent(paramContext, PayBridgeActivity.class);
          paramString1.putExtras(paramString3);
          paramString1.putExtra("pay_requestcode", 5);
        }
        else
        {
          return false;
        }
      }
      else
      {
        paramString3 = null;
        try
        {
          paramString1 = QQWalletTransMsgItemBuilder.class.getClassLoader();
          if (paramString1 == null) {
            return false;
          }
          paramString1 = paramString1.loadClass(paramSessionInfo);
        }
        catch (Exception paramMessageForQQWalletMsg)
        {
          if (QLog.isDevelopLevel()) {
            paramMessageForQQWalletMsg.printStackTrace();
          }
          paramString1 = paramString3;
          if (QLog.isColorLevel())
          {
            paramString1 = a;
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("QQWalletTransMsgItemBuilder failed to find Class : ");
            localStringBuilder.append(paramSessionInfo);
            QLog.d(paramString1, 2, localStringBuilder.toString(), paramMessageForQQWalletMsg);
            paramString1 = paramString3;
          }
        }
        if (paramString1 == null) {
          return false;
        }
        paramString3 = new Intent(paramContext, paramString1);
        paramString2 = paramString2.entrySet().iterator();
        for (;;)
        {
          paramString1 = paramString3;
          if (!paramString2.hasNext()) {
            break;
          }
          paramString1 = (Map.Entry)paramString2.next();
          paramString3.putExtra((String)paramString1.getKey(), (String)paramString1.getValue());
        }
      }
      try
      {
        paramContext.startActivity(paramString1);
        return true;
      }
      catch (Exception paramContext)
      {
        if (QLog.isDevelopLevel()) {
          paramContext.printStackTrace();
        }
        if (QLog.isColorLevel())
        {
          paramString1 = a;
          paramString2 = new StringBuilder();
          paramString2.append("QQWalletMsgItemBuilder failed to startActivity : ");
          paramString2.append(paramSessionInfo);
          QLog.d(paramString1, 2, paramString2.toString(), paramContext);
        }
        return false;
      }
    }
    return false;
  }
  
  protected int a(int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 3)
      {
        if (paramInt != 4)
        {
          if (paramInt != 5)
          {
            if (paramInt != 6) {
              return 2130849132;
            }
            return 2130849116;
          }
          return 2130849117;
        }
        return 2130849118;
      }
      return 2130849136;
    }
    return 2130849135;
  }
  
  protected View a(ChatMessage paramChatMessage, BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, BaseChatItemLayout paramBaseChatItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    QQWalletTransMsgItemBuilder.QWalletTransMsgHolder localQWalletTransMsgHolder = (QQWalletTransMsgItemBuilder.QWalletTransMsgHolder)paramViewHolder;
    if ((paramChatMessage instanceof MessageForQQWalletMsg)) {
      paramViewHolder = (MessageForQQWalletMsg)paramChatMessage;
    } else {
      paramViewHolder = null;
    }
    if (paramViewHolder != null)
    {
      if (paramViewHolder.mQQWalletTransferMsg == null) {
        return null;
      }
      if ((localQWalletTransMsgHolder.a == null) || ((localQWalletTransMsgHolder.a != null) && (localQWalletTransMsgHolder.s != paramChatMessage.uniseq)))
      {
        localQWalletTransMsgHolder.a = a(localQWalletTransMsgHolder, this.e);
        paramBaseChatItemLayout.addView(a(this.e));
      }
      localQWalletTransMsgHolder.s = paramChatMessage.uniseq;
      paramView = paramViewHolder.mQQWalletTransferMsg.elem;
      if (paramView == null) {
        return localQWalletTransMsgHolder.a;
      }
      a(localQWalletTransMsgHolder, paramViewHolder, paramView, paramChatMessage.isSend() ^ true, paramOnLongClickAndTouchListener);
      paramChatMessage = this.d;
      paramOnLongClickAndTouchListener = new StringBuilder();
      paramOnLongClickAndTouchListener.append("");
      paramOnLongClickAndTouchListener.append(paramViewHolder.mQQWalletTransferMsg.templateId);
      ReportController.b(paramChatMessage, "P_CliOper", "Vip_pay_mywallet", "", "transferaccountmsg", "show", 0, 0, paramOnLongClickAndTouchListener.toString(), "", "", "");
      paramChatMessage = (TextView)paramBaseChatItemLayout.findViewById(2131443089);
      if (paramChatMessage != null) {
        if ((paramView != null) && (!TextUtils.isEmpty(paramView.g)))
        {
          paramChatMessage.setText(paramView.g);
          paramChatMessage.setVisibility(0);
        }
        else
        {
          paramChatMessage.setVisibility(8);
        }
      }
      if (paramViewHolder.messageType == 16)
      {
        this.d.registObserver(this.T);
        if (!TextUtils.isEmpty(paramViewHolder.mQQWalletTransferMsg.listId))
        {
          paramView = (SparseArray)this.S.get(paramViewHolder.mQQWalletTransferMsg.listId);
          paramChatMessage = paramView;
          if (paramView == null)
          {
            paramChatMessage = new SparseArray();
            this.S.put(paramViewHolder.mQQWalletTransferMsg.listId, paramChatMessage);
          }
          paramChatMessage.put((int)paramViewHolder.uniseq, new WeakReference(localQWalletTransMsgHolder));
        }
      }
      return localQWalletTransMsgHolder.a;
    }
    return null;
  }
  
  protected BaseBubbleBuilder.ViewHolder a()
  {
    return new QQWalletTransMsgItemBuilder.QWalletTransMsgHolder(this);
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    if (paramInt != 2131431695)
    {
      super.a(paramInt, paramContext, paramChatMessage);
      return;
    }
    ChatActivityFacade.b(this.e, this.d, paramChatMessage);
  }
  
  protected void a(View paramView, ChatMessage paramChatMessage)
  {
    if (paramChatMessage.isSend())
    {
      paramView.setPadding(V, W, U, 0);
      return;
    }
    if (paramChatMessage.istroop == 1008)
    {
      paramView.setPadding(U, W, V, paramView.getResources().getDimensionPixelSize(2131296613));
      return;
    }
    paramView.setPadding(U, W, V, 0);
  }
  
  protected void a(QQWalletTransMsgItemBuilder.QWalletTransMsgHolder paramQWalletTransMsgHolder, MessageForQQWalletMsg paramMessageForQQWalletMsg, QQWalletBaseMsgElem paramQQWalletBaseMsgElem)
  {
    if (paramMessageForQQWalletMsg.messageType == 16)
    {
      String str = paramQQWalletBaseMsgElem.c;
      int j = -12727643;
      boolean bool = paramMessageForQQWalletMsg.isSend();
      int k = 2130849108;
      int i;
      if ((!bool) && (!paramQQWalletBaseMsgElem.a(this.d.getLongAccountUin())))
      {
        paramQQWalletBaseMsgElem = BaseApplicationImpl.getContext().getString(2131914257);
        i = 2130849109;
      }
      else
      {
        paramQQWalletBaseMsgElem = (INotifyMsgApi)QRoute.api(INotifyMsgApi.class);
        int m = paramQQWalletBaseMsgElem.getAAPayState(paramMessageForQQWalletMsg.mQQWalletTransferMsg.listId, paramMessageForQQWalletMsg);
        i = m;
        if (m == -1)
        {
          paramQQWalletBaseMsgElem = paramQQWalletBaseMsgElem.getAAPayState(paramMessageForQQWalletMsg);
          i = m;
          if (!TextUtils.isEmpty(paramQQWalletBaseMsgElem)) {
            try
            {
              i = Integer.valueOf(paramQQWalletBaseMsgElem).intValue();
            }
            catch (Exception paramQQWalletBaseMsgElem)
            {
              i = m;
              if (QLog.isColorLevel())
              {
                paramQQWalletBaseMsgElem.printStackTrace();
                i = m;
              }
            }
          }
        }
        if (i == 1)
        {
          i = 2130849110;
          paramQQWalletBaseMsgElem = BaseApplicationImpl.getContext().getString(2131914263);
          j = -7676215;
        }
        else
        {
          if (i == 2) {}
          for (paramQQWalletBaseMsgElem = BaseApplicationImpl.getContext().getString(2131914258);; paramQQWalletBaseMsgElem = BaseApplicationImpl.getContext().getString(2131914260))
          {
            j = -7676215;
            i = 2130849107;
            break label269;
            if (i != 3) {
              break;
            }
          }
          if (paramMessageForQQWalletMsg.isSend())
          {
            paramQQWalletBaseMsgElem = BaseApplicationImpl.getContext().getString(2131914261);
            i = k;
          }
          else
          {
            paramQQWalletBaseMsgElem = BaseApplicationImpl.getContext().getString(2131914259);
            i = k;
          }
        }
      }
      label269:
      a(paramQWalletTransMsgHolder.b, paramQQWalletBaseMsgElem);
      if ((i != 0) && (paramQWalletTransMsgHolder.d != null))
      {
        paramQQWalletBaseMsgElem = this.e.getResources().getDrawable(i);
        paramQWalletTransMsgHolder.d.setImageDrawable(paramQQWalletBaseMsgElem);
      }
      if (paramQWalletTransMsgHolder.g != null) {
        paramQWalletTransMsgHolder.g.setBubbleBackground(2130849133, j, paramMessageForQQWalletMsg.isSend() ^ true);
      }
    }
  }
  
  public QQCustomMenuItem[] a(View paramView)
  {
    QQCustomMenu localQQCustomMenu = new QQCustomMenu();
    paramView = AIOUtils.a(paramView);
    a(localQQCustomMenu, this.e, 2131444634, paramView, null);
    ChatActivityFacade.a(localQQCustomMenu, this.e, this.f.a);
    a(localQQCustomMenu, this.e, 2131444651, paramView, null);
    super.a(localQQCustomMenu, this.e, 2131439015, null, null);
    super.a(localQQCustomMenu, this.e, 2131428089, null, null);
    return localQQCustomMenu.d();
  }
  
  public void b()
  {
    this.d.unRegistObserver(this.T);
    this.S.clear();
    super.b();
  }
  
  public int c(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  protected String d(ChatMessage paramChatMessage)
  {
    Object localObject;
    if ((paramChatMessage instanceof MessageForQQWalletMsg)) {
      localObject = (MessageForQQWalletMsg)paramChatMessage;
    } else {
      localObject = null;
    }
    if ((localObject != null) && (((MessageForQQWalletMsg)localObject).mQQWalletTransferMsg != null))
    {
      localObject = ((MessageForQQWalletMsg)localObject).mQQWalletTransferMsg.elem;
      if (localObject != null)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        if (MessageRecordInfo.b(paramChatMessage.issend)) {
          localStringBuilder.append("发出");
        } else {
          localStringBuilder.append("发来");
        }
        if ((((QQWalletBaseMsgElem)localObject).e != null) && (((QQWalletBaseMsgElem)localObject).e.contains("QQ转账")))
        {
          localStringBuilder.append("QQ转账");
          localStringBuilder.append(((QQWalletBaseMsgElem)localObject).c);
          localStringBuilder.append("按钮");
        }
        else
        {
          localStringBuilder.append("QQ转账");
          localStringBuilder.append(((QQWalletBaseMsgElem)localObject).c);
          localStringBuilder.append(((QQWalletBaseMsgElem)localObject).e);
          localStringBuilder.append("按钮");
        }
        return localStringBuilder.toString();
      }
      return paramChatMessage.msg;
    }
    return paramChatMessage.msg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.QQWalletTransMsgItemBuilder
 * JD-Core Version:    0.7.0.1
 */