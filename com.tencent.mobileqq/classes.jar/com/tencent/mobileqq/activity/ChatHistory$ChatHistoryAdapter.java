package com.tencent.mobileqq.activity;

import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.text.format.Time;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.MixedImageOnclickListener;
import com.tencent.mobileqq.activity.aio.item.ChatThumbView;
import com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder.Holder;
import com.tencent.mobileqq.activity.aio.item.PicItemBuilder;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.utils.MessagePkgUtils;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.MarkFaceMessage;
import com.tencent.mobileqq.data.MessageForMarketFace;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.SystemMsg;
import com.tencent.mobileqq.emosm.api.IEmoticonManagerService;
import com.tencent.mobileqq.emoticonview.EmotionPanelConstans;
import com.tencent.mobileqq.emoticonview.IPicEmoticonInfo;
import com.tencent.mobileqq.magicface.drawable.PngFrameManager;
import com.tencent.mobileqq.pic.api.IPicFlash;
import com.tencent.mobileqq.pic.api.IPicHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.message.MessageUtils;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.transfile.CommonImgThumbHelper;
import com.tencent.mobileqq.widget.AnimationTextView;
import com.tencent.mobileqq.widget.MixedMsgLinearLayout;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.os.MqqHandler;
import org.json.JSONObject;

public class ChatHistory$ChatHistoryAdapter
  extends CursorAdapter
{
  protected LayoutInflater a;
  protected int b = 1000;
  Context c;
  protected int d;
  public int e = -1;
  
  public ChatHistory$ChatHistoryAdapter(ChatHistory paramChatHistory, Context paramContext, Cursor paramCursor)
  {
    super(paramContext, paramCursor);
    this.a = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
    this.c = paramContext;
    if (paramChatHistory.v < 1.0F)
    {
      paramChatHistory.y = ((int)(paramChatHistory.v * 100.0F));
      paramChatHistory.x = ((int)(paramChatHistory.v * 34.0F));
      paramChatHistory.z = ((int)(paramChatHistory.v * 14.0F));
      paramChatHistory.A = ((int)(paramChatHistory.v * 15.0F));
    }
    else
    {
      paramChatHistory.y = ((int)(paramChatHistory.v * 120.0F));
      paramChatHistory.x = ((int)(paramChatHistory.v * 34.0F));
      paramChatHistory.z = ((int)(paramChatHistory.v * 14.0F));
      paramChatHistory.A = ((int)(paramChatHistory.v * 15.0F));
    }
    paramChatHistory = paramContext.getResources().getDisplayMetrics();
    this.d = Math.min(paramChatHistory.widthPixels, paramChatHistory.heightPixels);
  }
  
  protected int a(int paramInt)
  {
    int j = this.f.x;
    if (paramInt >= 60) {
      return this.f.y;
    }
    if ((paramInt > 45) && (paramInt < 60))
    {
      paramInt = this.f.y * 15 / 16 + (paramInt - 45) * this.f.y / 15 / 16;
      i = this.f.x;
    }
    for (;;)
    {
      return paramInt + i;
      if ((paramInt > 30) && (paramInt <= 45))
      {
        paramInt = this.f.y * 13 / 16 + (paramInt - 30) * this.f.y * 2 / 15 / 16;
        i = this.f.x;
      }
      else
      {
        if ((paramInt <= 15) || (paramInt > 30)) {
          break;
        }
        paramInt = this.f.y * 9 / 16 + (paramInt - 15) * this.f.y * 4 / 15 / 16;
        i = this.f.x;
      }
    }
    int i = j;
    if (paramInt > 0)
    {
      i = j;
      if (paramInt <= 15)
      {
        paramInt = paramInt * this.f.y * 9 / 16 / 15;
        i = this.f.x + paramInt;
      }
    }
    return i;
  }
  
  protected String a(long paramLong)
  {
    Time localTime1 = new Time();
    Time localTime2 = new Time();
    localTime1.set(paramLong);
    localTime2.setToNow();
    if (localTime1.year != localTime2.year) {
      return localTime1.format("%Y-%m-%d %H:%M:%S");
    }
    if (localTime1.yearDay != localTime2.yearDay) {
      return localTime1.format("%m-%d %H:%M:%S");
    }
    return localTime1.format("%H:%M:%S");
  }
  
  public void a()
  {
    super.changeCursor(null);
  }
  
  public void a(Cursor paramCursor, TextView paramTextView1, int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2, TextView paramTextView2, ChatHistory.Holder paramHolder, ImageView paramImageView1, CharSequence paramCharSequence, ChatThumbView paramChatThumbView, View paramView1, View paramView2, ImageView paramImageView2, long paramLong)
  {
    Object localObject = paramCursor.getString(paramCursor.getColumnIndex("extStr"));
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = new JSONObject((String)localObject);
      if (((JSONObject)localObject).has("Emoji_Sticker_Info"))
      {
        int i = new JSONObject(((JSONObject)localObject).getString("Emoji_Sticker_Info")).getInt("msgType");
        if (i == -1000)
        {
          i = paramCursor.getInt(paramCursor.getColumnIndex("msgtype"));
          paramTextView1.setVisibility(0);
          if (!MessageUtils.b(paramInt1))
          {
            paramTextView1.setOnTouchListener(this.f.X);
            paramTextView1.setOnLongClickListener(this.f.X);
          }
          if (String.valueOf(AppConstants.SYSTEM_MSG_UIN).equals(paramString1))
          {
            paramCursor = SystemMsg.decode(this.f.app, paramString2, paramString3, i);
            if (paramCursor != null)
            {
              paramTextView1.setText(paramCursor.message);
              if (paramInt2 == 32769) {
                paramTextView2.setText(paramCursor.troopCode);
              }
            }
          }
          else
          {
            if (-2008 == i)
            {
              paramTextView1.setText(this.f.getString(2131916155));
              return;
            }
            if (-1002 == i)
            {
              paramTextView1.setText(paramHolder.a.getExtInfoFromExtStr("sens_msg_original_text"));
              return;
            }
            paramInt1 = paramCursor.getInt(paramCursor.getColumnIndex("extraflag"));
            if ((paramImageView1 != null) && (paramInt1 == 32768)) {
              paramImageView1.setVisibility(0);
            }
            paramTextView1.setText(new QQText(paramCharSequence, 13, 32, this.f.f));
          }
        }
        else
        {
          if (i == -2000)
          {
            if ((paramHolder.a instanceof MessageForPic))
            {
              if (((IPicFlash)QRoute.api(IPicFlash.class)).isFlashPicMsg(paramHolder.a))
              {
                paramTextView1.setVisibility(0);
                paramTextView1.setText(this.f.getString(2131888233));
                paramTextView1.setOnTouchListener(this.f.X);
                paramTextView1.setOnLongClickListener(this.f.X);
                return;
              }
              paramCursor = (MessageForPic)paramHolder.a;
              paramCursor.parse();
              paramTextView1 = new ImageViewParameter();
              paramChatThumbView.setOnTouchListener(this.f.X);
              paramChatThumbView.setOnLongClickListener(this.f.X);
              paramTextView1.b = paramCursor;
              paramTextView1.a = paramChatThumbView;
              if (QLog.isColorLevel())
              {
                paramString1 = new StringBuilder();
                paramString1.append("bindView pic.path:");
                paramString1.append(paramCursor.path);
                paramString1.append(",pic.uuid:");
                paramString1.append(paramCursor.uuid);
                QLog.d("history", 2, paramString1.toString());
              }
              if ((paramTextView1.b != null) && (paramTextView1.b.path != null)) {
                a(paramTextView1);
              }
            }
            else if ((QLog.isColorLevel()) && (paramHolder.a != null))
            {
              paramCursor = new StringBuilder();
              paramCursor.append("not messageforpicuniseq:");
              paramCursor.append(paramHolder.a.uniseq);
              paramCursor.append(",dbid:");
              paramCursor.append(paramHolder.a.getId());
              paramCursor.append("istroop:");
              paramCursor.append(paramHolder.a.istroop);
              paramCursor.append(",msgtype:");
              paramCursor.append(paramHolder.a.msgtype);
              QLog.d("history", 2, paramCursor.toString());
            }
            return;
          }
          if (i == -2007)
          {
            paramCursor = paramCursor.getBlob(paramCursor.getColumnIndex("msgData"));
            try
            {
              paramCursor = MessagePkgUtils.a(paramCursor);
              if ((paramCursor instanceof MarkFaceMessage))
              {
                paramChatThumbView.setVisibility(0);
                paramTextView1.setVisibility(8);
                paramImageView1.setVisibility(8);
                paramView1.setVisibility(8);
                paramView2.setVisibility(8);
                paramChatThumbView.setOnTouchListener(this.f.X);
                paramChatThumbView.setOnLongClickListener(this.f.X);
                paramTextView1 = new StringBuilder();
                paramTextView1.append(paramString1);
                paramTextView1.append(paramLong);
                paramChatThumbView.setTag(paramTextView1.toString());
                paramImageView2.setTag(null);
                a(paramChatThumbView, (MarkFaceMessage)paramCursor, paramImageView2, paramHolder.a);
                return;
              }
            }
            catch (Exception paramCursor)
            {
              paramTextView1 = new StringBuilder();
              paramTextView1.append("dealStikerMessage e = ");
              paramTextView1.append(paramCursor);
              QLog.e("ChatHistory", 1, paramTextView1.toString());
            }
          }
        }
      }
    }
  }
  
  public void a(ImageView paramImageView, int paramInt, IPicEmoticonInfo paramIPicEmoticonInfo, MessageRecord paramMessageRecord)
  {
    if (paramIPicEmoticonInfo == null)
    {
      paramImageView.setImageResource(2130837994);
    }
    else
    {
      MarketFaceItemBuilder.Holder localHolder = null;
      Object localObject1 = null;
      Object localObject2;
      if (paramInt == 2)
      {
        if (!paramIPicEmoticonInfo.isSound())
        {
          paramIPicEmoticonInfo = paramIPicEmoticonInfo.getBigDrawable(this.c, this.f.v);
          if (paramIPicEmoticonInfo != null)
          {
            paramImageView.setImageDrawable(paramIPicEmoticonInfo);
            paramImageView.setOnClickListener(null);
          }
        }
        else if (paramIPicEmoticonInfo.getLoadingDrawable("fromAIO", true) != null)
        {
          paramImageView.setOnClickListener(new ChatHistory.ChatHistoryAdapter.6(this, paramIPicEmoticonInfo));
          localObject2 = (View)paramImageView.getParent();
          if ((this.f.al != null) && (this.f.al.a(0, paramImageView.getTag())))
          {
            paramIPicEmoticonInfo = EmotionPanelConstans.emoticonSoundPath.replace("[epId]", paramIPicEmoticonInfo.getEmoticon().epId).replace("[eId]", paramIPicEmoticonInfo.getEmoticon().eId);
            this.f.al.a((View)localObject2, paramIPicEmoticonInfo);
            paramIPicEmoticonInfo = (IPicEmoticonInfo)localObject1;
            if (localObject2 != null) {
              paramIPicEmoticonInfo = (ImageView)((View)localObject2).findViewById(2131445986);
            }
            this.f.a(paramIPicEmoticonInfo);
          }
          else
          {
            localObject1 = localHolder;
            if (localObject2 != null) {
              localObject1 = (ImageView)((View)localObject2).findViewById(2131445986);
            }
            this.f.b((ImageView)localObject1);
            this.f.a(paramImageView, paramIPicEmoticonInfo);
          }
        }
      }
      else if (paramInt == 1)
      {
        paramIPicEmoticonInfo = paramIPicEmoticonInfo.getAioPreviewDrawable();
        if (paramIPicEmoticonInfo != null) {
          paramImageView.setImageDrawable(paramIPicEmoticonInfo);
        }
      }
      else if (paramInt == 3)
      {
        localHolder = new MarketFaceItemBuilder.Holder();
        paramImageView.setOnClickListener(null);
        localHolder.s = paramImageView;
        localHolder.a = paramIPicEmoticonInfo;
        localObject2 = (PngFrameManager)this.f.app.getManager(QQManagerFactory.PNG_FRAME_DRAWABLE_MANAGER);
        localHolder.y = paramIPicEmoticonInfo.getEmoticon().getId();
        localObject1 = (MessageForMarketFace)localHolder.q;
        if ((localObject1 != null) && (((MessageForMarketFace)localObject1).mMarkFaceMessage != null) && (((MessageForMarketFace)localObject1).mMarkFaceMessage.mobileparam != null) && (((MessageForMarketFace)localObject1).mMarkFaceMessage.mobileparam.length > 0)) {
          localObject1 = new String(((MessageForMarketFace)localObject1).mMarkFaceMessage.mobileparam);
        } else {
          localObject1 = "";
        }
        ((PngFrameManager)localObject2).a((String)localObject1, localHolder, paramIPicEmoticonInfo.getEmoticon().getId(), false, false, null);
      }
      else if (paramInt == 0)
      {
        paramImageView.setImageResource(2130837994);
      }
    }
    paramImageView.setOnClickListener(new ChatHistory.ChatHistoryAdapter.7(this, paramMessageRecord));
  }
  
  protected void a(ImageView paramImageView1, MarkFaceMessage paramMarkFaceMessage, ImageView paramImageView2, MessageRecord paramMessageRecord)
  {
    if (paramMarkFaceMessage == null)
    {
      a(paramImageView1, 0, null, paramMessageRecord);
      return;
    }
    ((IEmoticonManagerService)this.f.app.getRuntimeService(IEmoticonManagerService.class)).asyncGetEmoticonInfo(paramMarkFaceMessage, new ChatHistory.ChatHistoryAdapter.8(this, paramImageView2, paramMarkFaceMessage, paramImageView1, paramMessageRecord));
  }
  
  protected void a(ImageViewParameter paramImageViewParameter)
  {
    Object localObject = PicItemBuilder.a(this.f, paramImageViewParameter.b);
    paramImageViewParameter.a.setImageDrawable((Drawable)localObject);
    paramImageViewParameter.a.setVisibility(0);
    int i = paramImageViewParameter.b.msgtype;
    localObject = paramImageViewParameter.b.action;
    paramImageViewParameter.a.setOnClickListener(new ChatHistory.ChatHistoryAdapter.9(this, i, paramImageViewParameter, (String)localObject));
  }
  
  public void a(MixedMsgLinearLayout paramMixedMsgLinearLayout, MessageForMixedMsg paramMessageForMixedMsg)
  {
    if (paramMixedMsgLinearLayout == null) {
      return;
    }
    paramMessageForMixedMsg.parse();
    int j = paramMessageForMixedMsg.msgElemList.size();
    int i = 0;
    while (i < j)
    {
      localObject1 = (MessageRecord)paramMessageForMixedMsg.msgElemList.get(i);
      if ((localObject1 instanceof MessageForPic))
      {
        localObject1 = (MessageForPic)localObject1;
        if (((MessageForPic)localObject1).time == 0L) {
          MessageForMixedMsg.copyBaseInfoFromMixedToPic((MessageForPic)localObject1, paramMessageForMixedMsg);
        }
      }
      i += 1;
    }
    paramMixedMsgLinearLayout.a(paramMessageForMixedMsg.msgElemList, null);
    Object localObject1 = new MixedImageOnclickListener();
    ((MixedImageOnclickListener)localObject1).a = this.f.K;
    int k = paramMessageForMixedMsg.msgElemList.size();
    i = 0;
    while (i < k)
    {
      Object localObject2 = (MessageRecord)paramMessageForMixedMsg.msgElemList.get(i);
      View localView = paramMixedMsgLinearLayout.getChildAt(i);
      Object localObject3;
      if ((localObject2 instanceof MessageForText))
      {
        localObject3 = (AnimationTextView)localView;
        ((AnimationTextView)localObject3).setTextColor(this.f.getResources().getColor(2131168102));
        ((AnimationTextView)localObject3).setTextSize(0, AIOUtils.b(16.0F, paramMixedMsgLinearLayout.getContext().getResources()));
        localObject2 = (MessageForText)localObject2;
        if (TextUtils.isEmpty(((MessageForText)localObject2).sb2)) {
          ((AnimationTextView)localObject3).setText(((MessageForText)localObject2).sb);
        } else {
          ((AnimationTextView)localObject3).setText(((MessageForText)localObject2).sb2);
        }
      }
      else if ((localObject2 instanceof MessageForPic))
      {
        localObject2 = (MessageForPic)localObject2;
        localObject3 = (ChatThumbView)localView;
        ((ChatThumbView)localObject3).setAdjustViewBounds(true);
        ((ChatThumbView)localObject3).setMaxWidth(CommonImgThumbHelper.getImgThumbMaxPx(((IPicHelper)QRoute.api(IPicHelper.class)).isEmotion((MessageForPic)localObject2)));
        ((ChatThumbView)localObject3).setMaxHeight(CommonImgThumbHelper.getImgThumbMaxPx(((IPicHelper)QRoute.api(IPicHelper.class)).isEmotion((MessageForPic)localObject2)));
        URLDrawable localURLDrawable = PicItemBuilder.a(this.c, (MessageForPic)localObject2, (ChatThumbView)localObject3);
        ((ChatThumbView)localObject3).setTag(2131430592, localObject2);
        ((ChatThumbView)localObject3).setImageDrawable(localURLDrawable);
        ((ChatThumbView)localObject3).setOnClickListener((View.OnClickListener)localObject1);
      }
      else if (QLog.isColorLevel())
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("mixed type not support yet.");
        ((StringBuilder)localObject3).append(localObject2.getClass().getSimpleName());
        QLog.e("ChatHistory", 2, ((StringBuilder)localObject3).toString());
      }
      localObject2 = (LinearLayout.LayoutParams)localView.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject2).topMargin = BaseChatItemLayout.n;
      if (i == j - 1) {
        ((LinearLayout.LayoutParams)localObject2).bottomMargin = BaseChatItemLayout.n;
      } else {
        ((LinearLayout.LayoutParams)localObject2).bottomMargin = 0;
      }
      localView.setOnTouchListener(this.f.X);
      localView.setOnLongClickListener(this.f.X);
      i += 1;
    }
    paramMixedMsgLinearLayout.setOnTouchListener(this.f.X);
    paramMixedMsgLinearLayout.setOnLongClickListener(this.f.X);
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    ThreadManager.getSubThreadHandler().post(new ChatHistory.ChatHistoryAdapter.10(this, paramInt1, paramInt2, paramString));
  }
  
  /* Error */
  public void bindView(View paramView, Context paramContext, Cursor paramCursor)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 726	android/view/View:getTag	()Ljava/lang/Object;
    //   4: checkcast 230	com/tencent/mobileqq/activity/ChatHistory$Holder
    //   7: astore 13
    //   9: aload 13
    //   11: astore 15
    //   13: aload 13
    //   15: ifnonnull +22 -> 37
    //   18: new 230	com/tencent/mobileqq/activity/ChatHistory$Holder
    //   21: dup
    //   22: aload_0
    //   23: getfield 18	com/tencent/mobileqq/activity/ChatHistory$ChatHistoryAdapter:f	Lcom/tencent/mobileqq/activity/ChatHistory;
    //   26: invokespecial 729	com/tencent/mobileqq/activity/ChatHistory$Holder:<init>	(Lcom/tencent/mobileqq/activity/ChatHistory;)V
    //   29: astore 15
    //   31: aload_1
    //   32: aload 15
    //   34: invokevirtual 730	android/view/View:setTag	(Ljava/lang/Object;)V
    //   37: aload_0
    //   38: getfield 18	com/tencent/mobileqq/activity/ChatHistory$ChatHistoryAdapter:f	Lcom/tencent/mobileqq/activity/ChatHistory;
    //   41: getfield 732	com/tencent/mobileqq/activity/ChatHistory:e	Ljava/lang/String;
    //   44: aload_0
    //   45: getfield 18	com/tencent/mobileqq/activity/ChatHistory$ChatHistoryAdapter:f	Lcom/tencent/mobileqq/activity/ChatHistory;
    //   48: getfield 250	com/tencent/mobileqq/activity/ChatHistory:f	I
    //   51: invokestatic 736	com/tencent/mobileqq/data/MessageRecord:getTableName	(Ljava/lang/String;I)Ljava/lang/String;
    //   54: astore 13
    //   56: aload 15
    //   58: aload_0
    //   59: getfield 18	com/tencent/mobileqq/activity/ChatHistory$ChatHistoryAdapter:f	Lcom/tencent/mobileqq/activity/ChatHistory;
    //   62: invokevirtual 739	com/tencent/mobileqq/activity/ChatHistory:a	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   65: ldc 237
    //   67: aload 13
    //   69: aload_3
    //   70: invokevirtual 745	com/tencent/mobileqq/persistence/EntityManager:cursor2Entity	(Ljava/lang/Class;Ljava/lang/String;Landroid/database/Cursor;)Lcom/tencent/mobileqq/persistence/Entity;
    //   73: checkcast 237	com/tencent/mobileqq/data/MessageRecord
    //   76: putfield 233	com/tencent/mobileqq/activity/ChatHistory$Holder:a	Lcom/tencent/mobileqq/data/MessageRecord;
    //   79: aload 15
    //   81: getfield 233	com/tencent/mobileqq/activity/ChatHistory$Holder:a	Lcom/tencent/mobileqq/data/MessageRecord;
    //   84: ifnonnull +20 -> 104
    //   87: invokestatic 290	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   90: ifeq +13 -> 103
    //   93: ldc_w 378
    //   96: iconst_2
    //   97: ldc_w 747
    //   100: invokestatic 750	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   103: return
    //   104: aload_0
    //   105: getfield 18	com/tencent/mobileqq/activity/ChatHistory$ChatHistoryAdapter:f	Lcom/tencent/mobileqq/activity/ChatHistory;
    //   108: getfield 754	com/tencent/mobileqq/activity/ChatHistory:R	Z
    //   111: ifne +37 -> 148
    //   114: aload_0
    //   115: getfield 18	com/tencent/mobileqq/activity/ChatHistory$ChatHistoryAdapter:f	Lcom/tencent/mobileqq/activity/ChatHistory;
    //   118: getfield 209	com/tencent/mobileqq/activity/ChatHistory:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   121: invokevirtual 758	com/tencent/mobileqq/app/QQAppInterface:getMessageFacade	()Lcom/tencent/imcore/message/QQMessageFacade;
    //   124: aload 15
    //   126: getfield 233	com/tencent/mobileqq/activity/ChatHistory$Holder:a	Lcom/tencent/mobileqq/data/MessageRecord;
    //   129: getfield 761	com/tencent/mobileqq/data/MessageRecord:frienduin	Ljava/lang/String;
    //   132: aload 15
    //   134: getfield 233	com/tencent/mobileqq/activity/ChatHistory$Holder:a	Lcom/tencent/mobileqq/data/MessageRecord;
    //   137: getfield 339	com/tencent/mobileqq/data/MessageRecord:istroop	I
    //   140: aload 15
    //   142: getfield 233	com/tencent/mobileqq/activity/ChatHistory$Holder:a	Lcom/tencent/mobileqq/data/MessageRecord;
    //   145: invokevirtual 766	com/tencent/imcore/message/QQMessageFacade:d	(Ljava/lang/String;ILcom/tencent/mobileqq/data/MessageRecord;)V
    //   148: aload_3
    //   149: iconst_0
    //   150: invokeinterface 770 2 0
    //   155: lstore 10
    //   157: aload 15
    //   159: getfield 233	com/tencent/mobileqq/activity/ChatHistory$Holder:a	Lcom/tencent/mobileqq/data/MessageRecord;
    //   162: lload 10
    //   164: invokevirtual 773	com/tencent/mobileqq/data/MessageRecord:setId	(J)V
    //   167: aload_1
    //   168: ldc_w 774
    //   171: invokevirtual 463	android/view/View:findViewById	(I)Landroid/view/View;
    //   174: checkcast 776	android/widget/LinearLayout
    //   177: astore 26
    //   179: aload_1
    //   180: ldc_w 777
    //   183: invokevirtual 463	android/view/View:findViewById	(I)Landroid/view/View;
    //   186: checkcast 168	android/widget/TextView
    //   189: astore 30
    //   191: aload_1
    //   192: ldc_w 778
    //   195: invokevirtual 463	android/view/View:findViewById	(I)Landroid/view/View;
    //   198: checkcast 168	android/widget/TextView
    //   201: astore 18
    //   203: aload_1
    //   204: ldc_w 779
    //   207: invokevirtual 463	android/view/View:findViewById	(I)Landroid/view/View;
    //   210: checkcast 168	android/widget/TextView
    //   213: astore 21
    //   215: aload_1
    //   216: ldc_w 780
    //   219: invokevirtual 463	android/view/View:findViewById	(I)Landroid/view/View;
    //   222: checkcast 782	com/tencent/mobileqq/widget/PatchedTextView
    //   225: astore 17
    //   227: aload_1
    //   228: ldc_w 783
    //   231: invokevirtual 463	android/view/View:findViewById	(I)Landroid/view/View;
    //   234: checkcast 245	android/widget/ImageView
    //   237: astore 16
    //   239: aload_1
    //   240: ldc_w 784
    //   243: invokevirtual 463	android/view/View:findViewById	(I)Landroid/view/View;
    //   246: checkcast 591	com/tencent/mobileqq/widget/MixedMsgLinearLayout
    //   249: astore 28
    //   251: aload_1
    //   252: ldc_w 785
    //   255: invokevirtual 463	android/view/View:findViewById	(I)Landroid/view/View;
    //   258: checkcast 168	android/widget/TextView
    //   261: astore 27
    //   263: aload 26
    //   265: iconst_0
    //   266: invokevirtual 786	android/widget/LinearLayout:setVisibility	(I)V
    //   269: aload 17
    //   271: iconst_0
    //   272: invokevirtual 172	android/widget/TextView:setVisibility	(I)V
    //   275: aload 27
    //   277: bipush 8
    //   279: invokevirtual 172	android/widget/TextView:setVisibility	(I)V
    //   282: aload_1
    //   283: ldc_w 787
    //   286: invokevirtual 463	android/view/View:findViewById	(I)Landroid/view/View;
    //   289: checkcast 276	com/tencent/mobileqq/activity/aio/item/ChatThumbView
    //   292: astore 23
    //   294: aload 23
    //   296: iconst_0
    //   297: putfield 789	com/tencent/mobileqq/activity/aio/item/ChatThumbView:b	Z
    //   300: aload_1
    //   301: ldc_w 790
    //   304: invokevirtual 463	android/view/View:findViewById	(I)Landroid/view/View;
    //   307: checkcast 245	android/widget/ImageView
    //   310: astore 29
    //   312: aload_1
    //   313: ldc_w 791
    //   316: invokevirtual 463	android/view/View:findViewById	(I)Landroid/view/View;
    //   319: checkcast 793	android/widget/Button
    //   322: astore 19
    //   324: aload_1
    //   325: ldc_w 459
    //   328: invokevirtual 463	android/view/View:findViewById	(I)Landroid/view/View;
    //   331: checkcast 245	android/widget/ImageView
    //   334: astore 25
    //   336: aload 25
    //   338: bipush 8
    //   340: invokevirtual 246	android/widget/ImageView:setVisibility	(I)V
    //   343: aload 30
    //   345: bipush 8
    //   347: invokevirtual 172	android/widget/TextView:setVisibility	(I)V
    //   350: aload 17
    //   352: invokestatic 799	android/text/method/LinkMovementMethod:getInstance	()Landroid/text/method/MovementMethod;
    //   355: invokevirtual 803	android/widget/TextView:setMovementMethod	(Landroid/text/method/MovementMethod;)V
    //   358: aload_3
    //   359: aload_3
    //   360: ldc_w 804
    //   363: invokeinterface 134 2 0
    //   368: invokeinterface 138 2 0
    //   373: astore 20
    //   375: aload_3
    //   376: aload_3
    //   377: ldc_w 806
    //   380: invokeinterface 134 2 0
    //   385: invokeinterface 138 2 0
    //   390: astore 24
    //   392: aload_3
    //   393: aload_3
    //   394: ldc_w 807
    //   397: invokeinterface 134 2 0
    //   402: invokeinterface 166 2 0
    //   407: istore 4
    //   409: aload_3
    //   410: aload_3
    //   411: ldc_w 809
    //   414: invokeinterface 134 2 0
    //   419: invokeinterface 166 2 0
    //   424: istore 5
    //   426: aload_3
    //   427: aload_3
    //   428: ldc_w 810
    //   431: invokeinterface 134 2 0
    //   436: invokeinterface 166 2 0
    //   441: istore 6
    //   443: aload_3
    //   444: ldc_w 812
    //   447: invokeinterface 134 2 0
    //   452: iflt +308 -> 760
    //   455: aload_3
    //   456: aload_3
    //   457: ldc_w 812
    //   460: invokeinterface 134 2 0
    //   465: invokeinterface 166 2 0
    //   470: ifgt +6 -> 476
    //   473: goto +287 -> 760
    //   476: aload 15
    //   478: getfield 233	com/tencent/mobileqq/activity/ChatHistory$Holder:a	Lcom/tencent/mobileqq/data/MessageRecord;
    //   481: instanceof 814
    //   484: ifne +263 -> 747
    //   487: aload 15
    //   489: getfield 233	com/tencent/mobileqq/activity/ChatHistory$Holder:a	Lcom/tencent/mobileqq/data/MessageRecord;
    //   492: instanceof 816
    //   495: ifeq +6 -> 501
    //   498: goto +249 -> 747
    //   501: aload_3
    //   502: aload_3
    //   503: ldc_w 348
    //   506: invokeinterface 134 2 0
    //   511: invokeinterface 352 2 0
    //   516: astore 13
    //   518: new 197	java/lang/String
    //   521: dup
    //   522: aload 13
    //   524: ldc_w 818
    //   527: invokespecial 821	java/lang/String:<init>	([BLjava/lang/String;)V
    //   530: astore 13
    //   532: new 292	java/lang/StringBuilder
    //   535: dup
    //   536: aload 13
    //   538: invokespecial 822	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   541: astore 22
    //   543: aload 15
    //   545: getfield 233	com/tencent/mobileqq/activity/ChatHistory$Holder:a	Lcom/tencent/mobileqq/data/MessageRecord;
    //   548: instanceof 608
    //   551: ifeq +5431 -> 5982
    //   554: aload 15
    //   556: getfield 233	com/tencent/mobileqq/activity/ChatHistory$Holder:a	Lcom/tencent/mobileqq/data/MessageRecord;
    //   559: getfield 339	com/tencent/mobileqq/data/MessageRecord:istroop	I
    //   562: istore 7
    //   564: iload 7
    //   566: sipush 3000
    //   569: if_icmpne +5413 -> 5982
    //   572: aload 15
    //   574: getfield 233	com/tencent/mobileqq/activity/ChatHistory$Holder:a	Lcom/tencent/mobileqq/data/MessageRecord;
    //   577: ldc_w 824
    //   580: invokevirtual 240	com/tencent/mobileqq/data/MessageRecord:getExtInfoFromExtStr	(Ljava/lang/String;)Ljava/lang/String;
    //   583: astore 14
    //   585: aload 14
    //   587: invokestatic 144	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   590: istore 12
    //   592: iload 12
    //   594: ifne +5388 -> 5982
    //   597: getstatic 830	com/tencent/common/app/BaseApplicationImpl:sApplication	Lcom/tencent/common/app/BaseApplicationImpl;
    //   600: invokevirtual 834	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   603: astore 31
    //   605: ldc_w 492
    //   608: aload 31
    //   610: invokevirtual 837	java/lang/Class:isInstance	(Ljava/lang/Object;)Z
    //   613: ifeq +30 -> 643
    //   616: aload 31
    //   618: checkcast 492	com/tencent/mobileqq/app/QQAppInterface
    //   621: aload 22
    //   623: aload 14
    //   625: aload 20
    //   627: aload 15
    //   629: getfield 233	com/tencent/mobileqq/activity/ChatHistory$Holder:a	Lcom/tencent/mobileqq/data/MessageRecord;
    //   632: invokevirtual 840	com/tencent/mobileqq/data/MessageRecord:isSend	()Z
    //   635: invokestatic 845	com/tencent/mobileqq/troop/text/AtTroopMemberSpan:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;Z)Ljava/lang/StringBuilder;
    //   638: astore 14
    //   640: goto +56 -> 696
    //   643: aload 22
    //   645: astore 14
    //   647: invokestatic 290	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   650: ifeq +46 -> 696
    //   653: ldc_w 378
    //   656: iconst_2
    //   657: ldc_w 847
    //   660: invokestatic 316	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   663: aload 22
    //   665: astore 14
    //   667: goto +29 -> 696
    //   670: astore 14
    //   672: goto +5 -> 677
    //   675: astore 14
    //   677: ldc_w 378
    //   680: iconst_1
    //   681: ldc_w 849
    //   684: aload 14
    //   686: invokestatic 852	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   689: aload 22
    //   691: astore 14
    //   693: goto +3 -> 696
    //   696: aload 14
    //   698: invokevirtual 313	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   701: astore 14
    //   703: aload 14
    //   705: astore 13
    //   707: goto +70 -> 777
    //   710: astore 14
    //   712: goto +20 -> 732
    //   715: astore 14
    //   717: goto +15 -> 732
    //   720: astore 14
    //   722: goto +5 -> 727
    //   725: astore 14
    //   727: ldc_w 520
    //   730: astore 13
    //   732: ldc_w 378
    //   735: iconst_1
    //   736: ldc_w 854
    //   739: aload 14
    //   741: invokestatic 852	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   744: goto +33 -> 777
    //   747: aload 15
    //   749: getfield 233	com/tencent/mobileqq/activity/ChatHistory$Holder:a	Lcom/tencent/mobileqq/data/MessageRecord;
    //   752: getfield 857	com/tencent/mobileqq/data/MessageRecord:msg	Ljava/lang/String;
    //   755: astore 13
    //   757: goto +20 -> 777
    //   760: aload_3
    //   761: aload_3
    //   762: ldc_w 858
    //   765: invokeinterface 134 2 0
    //   770: invokeinterface 138 2 0
    //   775: astore 13
    //   777: aload_3
    //   778: aload_3
    //   779: ldc 164
    //   781: invokeinterface 134 2 0
    //   786: invokeinterface 166 2 0
    //   791: istore 7
    //   793: aload_0
    //   794: getfield 18	com/tencent/mobileqq/activity/ChatHistory$ChatHistoryAdapter:f	Lcom/tencent/mobileqq/activity/ChatHistory;
    //   797: iload 4
    //   799: iload 7
    //   801: aload 13
    //   803: iload 5
    //   805: invokevirtual 861	com/tencent/mobileqq/activity/ChatHistory:a	(IILjava/lang/String;I)LActionMsg/MsgBody;
    //   808: getfield 864	ActionMsg/MsgBody:msg	Ljava/lang/String;
    //   811: astore 14
    //   813: aload 15
    //   815: getfield 233	com/tencent/mobileqq/activity/ChatHistory$Holder:a	Lcom/tencent/mobileqq/data/MessageRecord;
    //   818: invokestatic 869	com/tencent/mobileqq/troop/utils/TroopBusinessUtil:a	(Lcom/tencent/mobileqq/data/MessageRecord;)Lcom/tencent/mobileqq/troop/utils/TroopBusinessUtil$TroopBusinessMessage;
    //   821: astore 22
    //   823: aload_0
    //   824: getfield 18	com/tencent/mobileqq/activity/ChatHistory$ChatHistoryAdapter:f	Lcom/tencent/mobileqq/activity/ChatHistory;
    //   827: getfield 209	com/tencent/mobileqq/activity/ChatHistory:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   830: getstatic 872	com/tencent/mobileqq/app/QQManagerFactory:TROOP_MANAGER	I
    //   833: invokevirtual 496	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   836: checkcast 874	com/tencent/mobileqq/app/TroopManager
    //   839: astore 31
    //   841: aload 31
    //   843: aload_0
    //   844: getfield 18	com/tencent/mobileqq/activity/ChatHistory$ChatHistoryAdapter:f	Lcom/tencent/mobileqq/activity/ChatHistory;
    //   847: getfield 732	com/tencent/mobileqq/activity/ChatHistory:e	Ljava/lang/String;
    //   850: invokevirtual 877	com/tencent/mobileqq/app/TroopManager:f	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/troop/TroopInfo;
    //   853: astore 13
    //   855: aload 13
    //   857: ifnull +83 -> 940
    //   860: aload 13
    //   862: getfield 883	com/tencent/mobileqq/data/troop/TroopInfo:cGroupRankSysFlag	B
    //   865: iconst_1
    //   866: if_icmpne +74 -> 940
    //   869: aload 13
    //   871: getfield 886	com/tencent/mobileqq/data/troop/TroopInfo:cGroupRankUserFlag	B
    //   874: iconst_1
    //   875: if_icmpne +65 -> 940
    //   878: aload 22
    //   880: ifnonnull +60 -> 940
    //   883: aload 31
    //   885: aload 20
    //   887: aload 24
    //   889: invokevirtual 890	com/tencent/mobileqq/app/TroopManager:g	(Ljava/lang/String;Ljava/lang/String;)Lcom/tencent/mobileqq/data/troop/TroopMemberInfo;
    //   892: astore 31
    //   894: invokestatic 895	com/tencent/mobileqq/troop/data/TroopRankConfig:a	()Lcom/tencent/mobileqq/troop/data/TroopRankConfig;
    //   897: aload 31
    //   899: aload 13
    //   901: invokevirtual 898	com/tencent/mobileqq/troop/data/TroopRankConfig:a	(Lcom/tencent/mobileqq/data/troop/TroopMemberInfo;Lcom/tencent/mobileqq/data/troop/TroopInfo;)Lcom/tencent/mobileqq/troop/data/TroopRankConfig$TroopRankItem;
    //   904: astore 13
    //   906: aload 13
    //   908: ifnull +32 -> 940
    //   911: aload 30
    //   913: iconst_0
    //   914: invokevirtual 172	android/widget/TextView:setVisibility	(I)V
    //   917: aload 30
    //   919: aload 13
    //   921: getfield 902	com/tencent/mobileqq/troop/data/TroopRankConfig$TroopRankItem:c	Ljava/lang/String;
    //   924: invokevirtual 222	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   927: aload 30
    //   929: aload 13
    //   931: getfield 903	com/tencent/mobileqq/troop/data/TroopRankConfig$TroopRankItem:b	I
    //   934: invokestatic 906	com/tencent/mobileqq/troop/data/TroopRankConfig:a	(Landroid/widget/TextView;I)V
    //   937: goto +3 -> 940
    //   940: aload 22
    //   942: ifnull +52 -> 994
    //   945: aload 18
    //   947: aload 22
    //   949: getfield 910	com/tencent/mobileqq/troop/utils/TroopBusinessUtil$TroopBusinessMessage:d	Ljava/lang/String;
    //   952: invokevirtual 222	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   955: aload 30
    //   957: iconst_0
    //   958: invokevirtual 172	android/widget/TextView:setVisibility	(I)V
    //   961: aload 30
    //   963: aload 22
    //   965: getfield 912	com/tencent/mobileqq/troop/utils/TroopBusinessUtil$TroopBusinessMessage:f	Ljava/lang/String;
    //   968: invokevirtual 222	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   971: aload 30
    //   973: aload_0
    //   974: getfield 18	com/tencent/mobileqq/activity/ChatHistory$ChatHistoryAdapter:f	Lcom/tencent/mobileqq/activity/ChatHistory;
    //   977: invokevirtual 611	com/tencent/mobileqq/activity/ChatHistory:getResources	()Landroid/content/res/Resources;
    //   980: aload 22
    //   982: getfield 915	com/tencent/mobileqq/troop/utils/TroopBusinessUtil$TroopBusinessMessage:h	I
    //   985: invokestatic 920	com/tencent/mobileqq/troop/utils/BizTroopUtil:a	(Landroid/content/res/Resources;I)Landroid/graphics/drawable/Drawable;
    //   988: invokevirtual 923	android/widget/TextView:setBackgroundDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   991: goto +200 -> 1191
    //   994: aload 15
    //   996: getfield 233	com/tencent/mobileqq/activity/ChatHistory$Holder:a	Lcom/tencent/mobileqq/data/MessageRecord;
    //   999: invokestatic 927	com/tencent/biz/anonymous/AnonymousChatHelper:c	(Lcom/tencent/mobileqq/data/MessageRecord;)Z
    //   1002: ifeq +68 -> 1070
    //   1005: new 292	java/lang/StringBuilder
    //   1008: dup
    //   1009: invokespecial 293	java/lang/StringBuilder:<init>	()V
    //   1012: astore 13
    //   1014: aload 13
    //   1016: aload_0
    //   1017: getfield 18	com/tencent/mobileqq/activity/ChatHistory$ChatHistoryAdapter:f	Lcom/tencent/mobileqq/activity/ChatHistory;
    //   1020: invokevirtual 611	com/tencent/mobileqq/activity/ChatHistory:getResources	()Landroid/content/res/Resources;
    //   1023: ldc_w 928
    //   1026: invokevirtual 929	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   1029: invokevirtual 299	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1032: pop
    //   1033: aload 13
    //   1035: aload 15
    //   1037: getfield 233	com/tencent/mobileqq/activity/ChatHistory$Holder:a	Lcom/tencent/mobileqq/data/MessageRecord;
    //   1040: invokestatic 932	com/tencent/biz/anonymous/AnonymousChatHelper:g	(Lcom/tencent/mobileqq/data/MessageRecord;)Lcom/tencent/biz/anonymous/AnonymousChatHelper$AnonymousExtInfo;
    //   1043: getfield 935	com/tencent/biz/anonymous/AnonymousChatHelper$AnonymousExtInfo:c	Ljava/lang/String;
    //   1046: invokevirtual 299	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1049: pop
    //   1050: aload 18
    //   1052: aload 13
    //   1054: invokevirtual 313	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1057: invokevirtual 222	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   1060: aload 30
    //   1062: bipush 8
    //   1064: invokevirtual 172	android/widget/TextView:setVisibility	(I)V
    //   1067: goto -76 -> 991
    //   1070: aload 15
    //   1072: getfield 233	com/tencent/mobileqq/activity/ChatHistory$Holder:a	Lcom/tencent/mobileqq/data/MessageRecord;
    //   1075: invokestatic 939	com/tencent/mobileqq/troop/utils/TroopBindPublicAccountMgr:a	(Lcom/tencent/mobileqq/data/MessageRecord;)Z
    //   1078: ifeq +35 -> 1113
    //   1081: aload 18
    //   1083: ldc_w 941
    //   1086: invokestatic 263	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   1089: checkcast 941	com/tencent/biz/pubaccount/util/api/IPublicAccountConfigUtil
    //   1092: aload_0
    //   1093: getfield 18	com/tencent/mobileqq/activity/ChatHistory$ChatHistoryAdapter:f	Lcom/tencent/mobileqq/activity/ChatHistory;
    //   1096: getfield 209	com/tencent/mobileqq/activity/ChatHistory:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1099: invokestatic 944	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1102: invokeinterface 948 3 0
    //   1107: invokevirtual 222	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   1110: goto -119 -> 991
    //   1113: aload 15
    //   1115: getfield 949	com/tencent/mobileqq/activity/ChatHistory$Holder:c	Ljava/lang/String;
    //   1118: invokestatic 144	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1121: ifne +40 -> 1161
    //   1124: aload 15
    //   1126: getfield 950	com/tencent/mobileqq/activity/ChatHistory$Holder:d	Ljava/lang/String;
    //   1129: invokestatic 144	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1132: ifne +29 -> 1161
    //   1135: aload 15
    //   1137: getfield 950	com/tencent/mobileqq/activity/ChatHistory$Holder:d	Ljava/lang/String;
    //   1140: aload 24
    //   1142: invokevirtual 205	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1145: ifeq +16 -> 1161
    //   1148: aload 18
    //   1150: aload 15
    //   1152: getfield 949	com/tencent/mobileqq/activity/ChatHistory$Holder:c	Ljava/lang/String;
    //   1155: invokevirtual 222	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   1158: goto -167 -> 991
    //   1161: aload 15
    //   1163: aload 24
    //   1165: putfield 950	com/tencent/mobileqq/activity/ChatHistory$Holder:d	Ljava/lang/String;
    //   1168: new 952	com/tencent/mobileqq/activity/ChatHistory$ChatHistoryAdapter$1
    //   1171: dup
    //   1172: aload_0
    //   1173: iload 5
    //   1175: aload 24
    //   1177: aload 15
    //   1179: aload 18
    //   1181: invokespecial 955	com/tencent/mobileqq/activity/ChatHistory$ChatHistoryAdapter$1:<init>	(Lcom/tencent/mobileqq/activity/ChatHistory$ChatHistoryAdapter;ILjava/lang/String;Lcom/tencent/mobileqq/activity/ChatHistory$Holder;Landroid/widget/TextView;)V
    //   1184: bipush 8
    //   1186: aconst_null
    //   1187: iconst_1
    //   1188: invokestatic 958	com/tencent/mobileqq/app/ThreadManager:post	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   1191: aload 20
    //   1193: astore 13
    //   1195: aload 22
    //   1197: ifnull +31 -> 1228
    //   1200: aload_0
    //   1201: getfield 18	com/tencent/mobileqq/activity/ChatHistory$ChatHistoryAdapter:f	Lcom/tencent/mobileqq/activity/ChatHistory;
    //   1204: getfield 209	com/tencent/mobileqq/activity/ChatHistory:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1207: iconst_0
    //   1208: aconst_null
    //   1209: invokestatic 964	com/tencent/mobileqq/vas/theme/api/ThemeUtil:isNowThemeIsDefault	(Lmqq/app/AppRuntime;ZLjava/lang/String;)Z
    //   1212: ifeq +16 -> 1228
    //   1215: aload 18
    //   1217: aload 22
    //   1219: getfield 965	com/tencent/mobileqq/troop/utils/TroopBusinessUtil$TroopBusinessMessage:e	I
    //   1222: invokevirtual 966	android/widget/TextView:setTextColor	(I)V
    //   1225: goto +21 -> 1246
    //   1228: aload 18
    //   1230: aload_0
    //   1231: getfield 18	com/tencent/mobileqq/activity/ChatHistory$ChatHistoryAdapter:f	Lcom/tencent/mobileqq/activity/ChatHistory;
    //   1234: invokevirtual 611	com/tencent/mobileqq/activity/ChatHistory:getResources	()Landroid/content/res/Resources;
    //   1237: ldc_w 967
    //   1240: invokevirtual 615	android/content/res/Resources:getColor	(I)I
    //   1243: invokevirtual 966	android/widget/TextView:setTextColor	(I)V
    //   1246: aload 21
    //   1248: aload_0
    //   1249: iload 6
    //   1251: i2l
    //   1252: ldc2_w 968
    //   1255: lmul
    //   1256: invokevirtual 971	com/tencent/mobileqq/activity/ChatHistory$ChatHistoryAdapter:a	(J)Ljava/lang/String;
    //   1259: invokevirtual 222	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   1262: aload_3
    //   1263: aload_3
    //   1264: ldc 242
    //   1266: invokeinterface 134 2 0
    //   1271: invokeinterface 166 2 0
    //   1276: istore 6
    //   1278: iload 6
    //   1280: ldc 243
    //   1282: if_icmpne +9 -> 1291
    //   1285: iconst_1
    //   1286: istore 4
    //   1288: goto +6 -> 1294
    //   1291: iconst_0
    //   1292: istore 4
    //   1294: iload 4
    //   1296: ifeq +35 -> 1331
    //   1299: aload 17
    //   1301: aload_2
    //   1302: invokevirtual 66	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   1305: invokevirtual 72	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   1308: getfield 77	android/util/DisplayMetrics:widthPixels	I
    //   1311: i2f
    //   1312: aload_0
    //   1313: getfield 18	com/tencent/mobileqq/activity/ChatHistory$ChatHistoryAdapter:f	Lcom/tencent/mobileqq/activity/ChatHistory;
    //   1316: getfield 45	com/tencent/mobileqq/activity/ChatHistory:v	F
    //   1319: ldc_w 972
    //   1322: fmul
    //   1323: fsub
    //   1324: f2i
    //   1325: invokevirtual 973	android/widget/TextView:setMaxWidth	(I)V
    //   1328: goto +3 -> 1331
    //   1331: aload 23
    //   1333: bipush 8
    //   1335: invokevirtual 360	com/tencent/mobileqq/activity/aio/item/ChatThumbView:setVisibility	(I)V
    //   1338: aload 17
    //   1340: bipush 8
    //   1342: invokevirtual 172	android/widget/TextView:setVisibility	(I)V
    //   1345: aload 16
    //   1347: bipush 8
    //   1349: invokevirtual 246	android/widget/ImageView:setVisibility	(I)V
    //   1352: aload 29
    //   1354: bipush 8
    //   1356: invokevirtual 246	android/widget/ImageView:setVisibility	(I)V
    //   1359: aload 19
    //   1361: bipush 8
    //   1363: invokevirtual 974	android/widget/Button:setVisibility	(I)V
    //   1366: aload 28
    //   1368: bipush 8
    //   1370: invokevirtual 975	com/tencent/mobileqq/widget/MixedMsgLinearLayout:setVisibility	(I)V
    //   1373: aload 17
    //   1375: aconst_null
    //   1376: invokevirtual 185	android/widget/TextView:setOnTouchListener	(Landroid/view/View$OnTouchListener;)V
    //   1379: aload 17
    //   1381: aconst_null
    //   1382: invokevirtual 189	android/widget/TextView:setOnLongClickListener	(Landroid/view/View$OnLongClickListener;)V
    //   1385: aload 17
    //   1387: aconst_null
    //   1388: invokevirtual 976	android/widget/TextView:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   1391: aload 19
    //   1393: aconst_null
    //   1394: invokevirtual 977	android/widget/Button:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   1397: aload_3
    //   1398: aload_0
    //   1399: invokevirtual 981	com/tencent/mobileqq/activity/ChatHistory$ChatHistoryAdapter:getCursor	()Landroid/database/Cursor;
    //   1402: ldc 164
    //   1404: invokeinterface 134 2 0
    //   1409: invokeinterface 166 2 0
    //   1414: istore 7
    //   1416: iload 7
    //   1418: sipush -2007
    //   1421: if_icmpne +155 -> 1576
    //   1424: aload 23
    //   1426: iconst_0
    //   1427: invokevirtual 360	com/tencent/mobileqq/activity/aio/item/ChatThumbView:setVisibility	(I)V
    //   1430: aload 17
    //   1432: bipush 8
    //   1434: invokevirtual 172	android/widget/TextView:setVisibility	(I)V
    //   1437: aload 16
    //   1439: bipush 8
    //   1441: invokevirtual 246	android/widget/ImageView:setVisibility	(I)V
    //   1444: aload 29
    //   1446: bipush 8
    //   1448: invokevirtual 246	android/widget/ImageView:setVisibility	(I)V
    //   1451: aload 19
    //   1453: bipush 8
    //   1455: invokevirtual 974	android/widget/Button:setVisibility	(I)V
    //   1458: aload 23
    //   1460: aload_0
    //   1461: getfield 18	com/tencent/mobileqq/activity/ChatHistory$ChatHistoryAdapter:f	Lcom/tencent/mobileqq/activity/ChatHistory;
    //   1464: getfield 181	com/tencent/mobileqq/activity/ChatHistory:X	Lcom/tencent/mobileqq/activity/ChatHistory$HistoryItemOnlongClickListener;
    //   1467: invokevirtual 277	com/tencent/mobileqq/activity/aio/item/ChatThumbView:setOnTouchListener	(Landroid/view/View$OnTouchListener;)V
    //   1470: aload 23
    //   1472: aload_0
    //   1473: getfield 18	com/tencent/mobileqq/activity/ChatHistory$ChatHistoryAdapter:f	Lcom/tencent/mobileqq/activity/ChatHistory;
    //   1476: getfield 181	com/tencent/mobileqq/activity/ChatHistory:X	Lcom/tencent/mobileqq/activity/ChatHistory$HistoryItemOnlongClickListener;
    //   1479: invokevirtual 278	com/tencent/mobileqq/activity/aio/item/ChatThumbView:setOnLongClickListener	(Landroid/view/View$OnLongClickListener;)V
    //   1482: aload_3
    //   1483: aload_3
    //   1484: ldc_w 348
    //   1487: invokeinterface 134 2 0
    //   1492: invokeinterface 352 2 0
    //   1497: astore_1
    //   1498: new 292	java/lang/StringBuilder
    //   1501: dup
    //   1502: invokespecial 293	java/lang/StringBuilder:<init>	()V
    //   1505: astore_2
    //   1506: aload_2
    //   1507: aload 13
    //   1509: invokevirtual 299	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1512: pop
    //   1513: aload_2
    //   1514: lload 10
    //   1516: invokevirtual 328	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1519: pop
    //   1520: aload 23
    //   1522: aload_2
    //   1523: invokevirtual 313	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1526: invokevirtual 367	com/tencent/mobileqq/activity/aio/item/ChatThumbView:setTag	(Ljava/lang/Object;)V
    //   1529: aload 25
    //   1531: aconst_null
    //   1532: invokevirtual 368	android/widget/ImageView:setTag	(Ljava/lang/Object;)V
    //   1535: aload_0
    //   1536: aload 23
    //   1538: aload_1
    //   1539: invokestatic 357	com/tencent/mobileqq/app/utils/MessagePkgUtils:a	([B)Ljava/lang/Object;
    //   1542: checkcast 359	com/tencent/mobileqq/data/MarkFaceMessage
    //   1545: aload 25
    //   1547: aload 15
    //   1549: getfield 233	com/tencent/mobileqq/activity/ChatHistory$Holder:a	Lcom/tencent/mobileqq/data/MessageRecord;
    //   1552: invokevirtual 371	com/tencent/mobileqq/activity/ChatHistory$ChatHistoryAdapter:a	(Landroid/widget/ImageView;Lcom/tencent/mobileqq/data/MarkFaceMessage;Landroid/widget/ImageView;Lcom/tencent/mobileqq/data/MessageRecord;)V
    //   1555: return
    //   1556: astore_1
    //   1557: aload_1
    //   1558: invokevirtual 984	java/lang/Exception:printStackTrace	()V
    //   1561: aload_0
    //   1562: aload 23
    //   1564: aconst_null
    //   1565: aload 25
    //   1567: aload 15
    //   1569: getfield 233	com/tencent/mobileqq/activity/ChatHistory$Holder:a	Lcom/tencent/mobileqq/data/MessageRecord;
    //   1572: invokevirtual 371	com/tencent/mobileqq/activity/ChatHistory$ChatHistoryAdapter:a	(Landroid/widget/ImageView;Lcom/tencent/mobileqq/data/MarkFaceMessage;Landroid/widget/ImageView;Lcom/tencent/mobileqq/data/MessageRecord;)V
    //   1575: return
    //   1576: iload 7
    //   1578: sipush -2058
    //   1581: if_icmpne +59 -> 1640
    //   1584: aload_0
    //   1585: aload_3
    //   1586: aload 17
    //   1588: iload 7
    //   1590: aload 13
    //   1592: aload 14
    //   1594: aload 24
    //   1596: iload 6
    //   1598: aload 18
    //   1600: aload 15
    //   1602: aload 16
    //   1604: aload 14
    //   1606: aload 23
    //   1608: aload 29
    //   1610: aload 19
    //   1612: aload 25
    //   1614: lload 10
    //   1616: invokevirtual 986	com/tencent/mobileqq/activity/ChatHistory$ChatHistoryAdapter:a	(Landroid/database/Cursor;Landroid/widget/TextView;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;ILandroid/widget/TextView;Lcom/tencent/mobileqq/activity/ChatHistory$Holder;Landroid/widget/ImageView;Ljava/lang/CharSequence;Lcom/tencent/mobileqq/activity/aio/item/ChatThumbView;Landroid/view/View;Landroid/view/View;Landroid/widget/ImageView;J)V
    //   1619: return
    //   1620: astore_1
    //   1621: aload_1
    //   1622: invokevirtual 984	java/lang/Exception:printStackTrace	()V
    //   1625: aload_0
    //   1626: aload 23
    //   1628: aconst_null
    //   1629: aload 25
    //   1631: aload 15
    //   1633: getfield 233	com/tencent/mobileqq/activity/ChatHistory$Holder:a	Lcom/tencent/mobileqq/data/MessageRecord;
    //   1636: invokevirtual 371	com/tencent/mobileqq/activity/ChatHistory$ChatHistoryAdapter:a	(Landroid/widget/ImageView;Lcom/tencent/mobileqq/data/MarkFaceMessage;Landroid/widget/ImageView;Lcom/tencent/mobileqq/data/MessageRecord;)V
    //   1639: return
    //   1640: iload 7
    //   1642: sipush -2039
    //   1645: if_icmpne +37 -> 1682
    //   1648: aload_3
    //   1649: aload_3
    //   1650: ldc_w 348
    //   1653: invokeinterface 134 2 0
    //   1658: invokeinterface 352 2 0
    //   1663: astore_1
    //   1664: ldc_w 988
    //   1667: invokestatic 263	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   1670: checkcast 988	com/tencent/mobileqq/apollo/utils/api/IApolloMessageUtil
    //   1673: aload 17
    //   1675: aload_1
    //   1676: invokeinterface 992 3 0
    //   1681: return
    //   1682: iload 7
    //   1684: sipush -2011
    //   1687: if_icmpeq +3844 -> 5531
    //   1690: iload 7
    //   1692: sipush -2051
    //   1695: if_icmpeq +3836 -> 5531
    //   1698: iload 7
    //   1700: sipush -7002
    //   1703: if_icmpeq +3828 -> 5531
    //   1706: iload 7
    //   1708: sipush -2054
    //   1711: if_icmpne +6 -> 1717
    //   1714: goto +3817 -> 5531
    //   1717: iload 7
    //   1719: sipush -3006
    //   1722: if_icmpne +64 -> 1786
    //   1725: aload_0
    //   1726: getfield 18	com/tencent/mobileqq/activity/ChatHistory$ChatHistoryAdapter:f	Lcom/tencent/mobileqq/activity/ChatHistory;
    //   1729: getfield 209	com/tencent/mobileqq/activity/ChatHistory:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1732: aload 15
    //   1734: getfield 233	com/tencent/mobileqq/activity/ChatHistory$Holder:a	Lcom/tencent/mobileqq/data/MessageRecord;
    //   1737: iconst_1
    //   1738: invokestatic 998	com/tencent/mobileqq/data/MessageForPubAccount:getMsgSummary	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/data/MessageRecord;Z)Ljava/lang/String;
    //   1741: astore_1
    //   1742: aload_1
    //   1743: invokestatic 144	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1746: ifne +39 -> 1785
    //   1749: aload 17
    //   1751: aload_1
    //   1752: invokevirtual 222	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   1755: aload 17
    //   1757: iconst_0
    //   1758: invokevirtual 172	android/widget/TextView:setVisibility	(I)V
    //   1761: aload 17
    //   1763: aload_0
    //   1764: getfield 18	com/tencent/mobileqq/activity/ChatHistory$ChatHistoryAdapter:f	Lcom/tencent/mobileqq/activity/ChatHistory;
    //   1767: getfield 181	com/tencent/mobileqq/activity/ChatHistory:X	Lcom/tencent/mobileqq/activity/ChatHistory$HistoryItemOnlongClickListener;
    //   1770: invokevirtual 185	android/widget/TextView:setOnTouchListener	(Landroid/view/View$OnTouchListener;)V
    //   1773: aload 17
    //   1775: aload_0
    //   1776: getfield 18	com/tencent/mobileqq/activity/ChatHistory$ChatHistoryAdapter:f	Lcom/tencent/mobileqq/activity/ChatHistory;
    //   1779: getfield 181	com/tencent/mobileqq/activity/ChatHistory:X	Lcom/tencent/mobileqq/activity/ChatHistory$HistoryItemOnlongClickListener;
    //   1782: invokevirtual 189	android/widget/TextView:setOnLongClickListener	(Landroid/view/View$OnLongClickListener;)V
    //   1785: return
    //   1786: iload 7
    //   1788: sipush -5008
    //   1791: if_icmpne +82 -> 1873
    //   1794: aload_3
    //   1795: aload_3
    //   1796: ldc_w 348
    //   1799: invokeinterface 134 2 0
    //   1804: invokeinterface 352 2 0
    //   1809: astore_1
    //   1810: new 1000	com/tencent/mobileqq/data/ArkAppMessage
    //   1813: dup
    //   1814: invokespecial 1001	com/tencent/mobileqq/data/ArkAppMessage:<init>	()V
    //   1817: astore_2
    //   1818: aload_2
    //   1819: aload_1
    //   1820: invokevirtual 1005	com/tencent/mobileqq/data/ArkAppMessage:fromBytes	([B)Z
    //   1823: pop
    //   1824: aload_2
    //   1825: getfield 1008	com/tencent/mobileqq/data/ArkAppMessage:promptText	Ljava/lang/String;
    //   1828: astore_1
    //   1829: aload_1
    //   1830: invokestatic 144	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1833: ifne +39 -> 1872
    //   1836: aload 17
    //   1838: aload_1
    //   1839: invokevirtual 222	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   1842: aload 17
    //   1844: iconst_0
    //   1845: invokevirtual 172	android/widget/TextView:setVisibility	(I)V
    //   1848: aload 17
    //   1850: aload_0
    //   1851: getfield 18	com/tencent/mobileqq/activity/ChatHistory$ChatHistoryAdapter:f	Lcom/tencent/mobileqq/activity/ChatHistory;
    //   1854: getfield 181	com/tencent/mobileqq/activity/ChatHistory:X	Lcom/tencent/mobileqq/activity/ChatHistory$HistoryItemOnlongClickListener;
    //   1857: invokevirtual 185	android/widget/TextView:setOnTouchListener	(Landroid/view/View$OnTouchListener;)V
    //   1860: aload 17
    //   1862: aload_0
    //   1863: getfield 18	com/tencent/mobileqq/activity/ChatHistory$ChatHistoryAdapter:f	Lcom/tencent/mobileqq/activity/ChatHistory;
    //   1866: getfield 181	com/tencent/mobileqq/activity/ChatHistory:X	Lcom/tencent/mobileqq/activity/ChatHistory$HistoryItemOnlongClickListener;
    //   1869: invokevirtual 189	android/widget/TextView:setOnLongClickListener	(Landroid/view/View$OnLongClickListener;)V
    //   1872: return
    //   1873: iload 7
    //   1875: sipush -5017
    //   1878: if_icmpne +82 -> 1960
    //   1881: aload_3
    //   1882: aload_3
    //   1883: ldc_w 348
    //   1886: invokeinterface 134 2 0
    //   1891: invokeinterface 352 2 0
    //   1896: astore_1
    //   1897: new 1000	com/tencent/mobileqq/data/ArkAppMessage
    //   1900: dup
    //   1901: invokespecial 1001	com/tencent/mobileqq/data/ArkAppMessage:<init>	()V
    //   1904: astore_2
    //   1905: aload_2
    //   1906: aload_1
    //   1907: invokevirtual 1005	com/tencent/mobileqq/data/ArkAppMessage:fromBytes	([B)Z
    //   1910: pop
    //   1911: aload_2
    //   1912: getfield 1008	com/tencent/mobileqq/data/ArkAppMessage:promptText	Ljava/lang/String;
    //   1915: astore_1
    //   1916: aload_1
    //   1917: invokestatic 144	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1920: ifne +39 -> 1959
    //   1923: aload 17
    //   1925: aload_1
    //   1926: invokevirtual 222	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   1929: aload 17
    //   1931: iconst_0
    //   1932: invokevirtual 172	android/widget/TextView:setVisibility	(I)V
    //   1935: aload 17
    //   1937: aload_0
    //   1938: getfield 18	com/tencent/mobileqq/activity/ChatHistory$ChatHistoryAdapter:f	Lcom/tencent/mobileqq/activity/ChatHistory;
    //   1941: getfield 181	com/tencent/mobileqq/activity/ChatHistory:X	Lcom/tencent/mobileqq/activity/ChatHistory$HistoryItemOnlongClickListener;
    //   1944: invokevirtual 185	android/widget/TextView:setOnTouchListener	(Landroid/view/View$OnTouchListener;)V
    //   1947: aload 17
    //   1949: aload_0
    //   1950: getfield 18	com/tencent/mobileqq/activity/ChatHistory$ChatHistoryAdapter:f	Lcom/tencent/mobileqq/activity/ChatHistory;
    //   1953: getfield 181	com/tencent/mobileqq/activity/ChatHistory:X	Lcom/tencent/mobileqq/activity/ChatHistory$HistoryItemOnlongClickListener;
    //   1956: invokevirtual 189	android/widget/TextView:setOnLongClickListener	(Landroid/view/View$OnLongClickListener;)V
    //   1959: return
    //   1960: iload 7
    //   1962: sipush -5016
    //   1965: if_icmpne +82 -> 2047
    //   1968: aload_3
    //   1969: aload_3
    //   1970: ldc_w 348
    //   1973: invokeinterface 134 2 0
    //   1978: invokeinterface 352 2 0
    //   1983: astore_1
    //   1984: new 1010	com/tencent/mobileqq/data/MessageForArkBabyqReply
    //   1987: dup
    //   1988: invokespecial 1011	com/tencent/mobileqq/data/MessageForArkBabyqReply:<init>	()V
    //   1991: astore_2
    //   1992: aload_2
    //   1993: aload_1
    //   1994: invokevirtual 1012	com/tencent/mobileqq/data/MessageForArkBabyqReply:fromBytes	([B)Z
    //   1997: pop
    //   1998: aload_2
    //   1999: getfield 1015	com/tencent/mobileqq/data/MessageForArkBabyqReply:babyqReplyText	Ljava/lang/String;
    //   2002: astore_1
    //   2003: aload_1
    //   2004: invokestatic 144	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2007: ifne +39 -> 2046
    //   2010: aload 17
    //   2012: aload_1
    //   2013: invokevirtual 222	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   2016: aload 17
    //   2018: iconst_0
    //   2019: invokevirtual 172	android/widget/TextView:setVisibility	(I)V
    //   2022: aload 17
    //   2024: aload_0
    //   2025: getfield 18	com/tencent/mobileqq/activity/ChatHistory$ChatHistoryAdapter:f	Lcom/tencent/mobileqq/activity/ChatHistory;
    //   2028: getfield 181	com/tencent/mobileqq/activity/ChatHistory:X	Lcom/tencent/mobileqq/activity/ChatHistory$HistoryItemOnlongClickListener;
    //   2031: invokevirtual 185	android/widget/TextView:setOnTouchListener	(Landroid/view/View$OnTouchListener;)V
    //   2034: aload 17
    //   2036: aload_0
    //   2037: getfield 18	com/tencent/mobileqq/activity/ChatHistory$ChatHistoryAdapter:f	Lcom/tencent/mobileqq/activity/ChatHistory;
    //   2040: getfield 181	com/tencent/mobileqq/activity/ChatHistory:X	Lcom/tencent/mobileqq/activity/ChatHistory$HistoryItemOnlongClickListener;
    //   2043: invokevirtual 189	android/widget/TextView:setOnLongClickListener	(Landroid/view/View$OnLongClickListener;)V
    //   2046: return
    //   2047: iload 7
    //   2049: sipush -5013
    //   2052: if_icmpne +82 -> 2134
    //   2055: aload_3
    //   2056: aload_3
    //   2057: ldc_w 348
    //   2060: invokeinterface 134 2 0
    //   2065: invokeinterface 352 2 0
    //   2070: astore_1
    //   2071: new 1017	com/tencent/mobileqq/data/ArkFlashChatMessage
    //   2074: dup
    //   2075: invokespecial 1018	com/tencent/mobileqq/data/ArkFlashChatMessage:<init>	()V
    //   2078: astore_2
    //   2079: aload_2
    //   2080: aload_1
    //   2081: invokevirtual 1019	com/tencent/mobileqq/data/ArkFlashChatMessage:fromBytes	([B)Z
    //   2084: pop
    //   2085: aload_2
    //   2086: getfield 1020	com/tencent/mobileqq/data/ArkFlashChatMessage:promptText	Ljava/lang/String;
    //   2089: astore_1
    //   2090: aload_1
    //   2091: invokestatic 144	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2094: ifne +39 -> 2133
    //   2097: aload 17
    //   2099: aload_1
    //   2100: invokevirtual 222	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   2103: aload 17
    //   2105: iconst_0
    //   2106: invokevirtual 172	android/widget/TextView:setVisibility	(I)V
    //   2109: aload 17
    //   2111: aload_0
    //   2112: getfield 18	com/tencent/mobileqq/activity/ChatHistory$ChatHistoryAdapter:f	Lcom/tencent/mobileqq/activity/ChatHistory;
    //   2115: getfield 181	com/tencent/mobileqq/activity/ChatHistory:X	Lcom/tencent/mobileqq/activity/ChatHistory$HistoryItemOnlongClickListener;
    //   2118: invokevirtual 185	android/widget/TextView:setOnTouchListener	(Landroid/view/View$OnTouchListener;)V
    //   2121: aload 17
    //   2123: aload_0
    //   2124: getfield 18	com/tencent/mobileqq/activity/ChatHistory$ChatHistoryAdapter:f	Lcom/tencent/mobileqq/activity/ChatHistory;
    //   2127: getfield 181	com/tencent/mobileqq/activity/ChatHistory:X	Lcom/tencent/mobileqq/activity/ChatHistory$HistoryItemOnlongClickListener;
    //   2130: invokevirtual 189	android/widget/TextView:setOnLongClickListener	(Landroid/view/View$OnLongClickListener;)V
    //   2133: return
    //   2134: iload 7
    //   2136: sipush -5014
    //   2139: if_icmpne +82 -> 2221
    //   2142: aload_3
    //   2143: aload_3
    //   2144: ldc_w 348
    //   2147: invokeinterface 134 2 0
    //   2152: invokeinterface 352 2 0
    //   2157: astore_2
    //   2158: aload_2
    //   2159: invokestatic 357	com/tencent/mobileqq/app/utils/MessagePkgUtils:a	([B)Ljava/lang/Object;
    //   2162: checkcast 1022	com/tencent/mobileqq/data/HiBoomMessage
    //   2165: getfield 1025	com/tencent/mobileqq/data/HiBoomMessage:text	Ljava/lang/String;
    //   2168: astore_2
    //   2169: aload_2
    //   2170: invokestatic 144	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2173: ifne +39 -> 2212
    //   2176: aload 17
    //   2178: aload_2
    //   2179: invokevirtual 222	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   2182: aload 17
    //   2184: iconst_0
    //   2185: invokevirtual 172	android/widget/TextView:setVisibility	(I)V
    //   2188: aload 17
    //   2190: aload_0
    //   2191: getfield 18	com/tencent/mobileqq/activity/ChatHistory$ChatHistoryAdapter:f	Lcom/tencent/mobileqq/activity/ChatHistory;
    //   2194: getfield 181	com/tencent/mobileqq/activity/ChatHistory:X	Lcom/tencent/mobileqq/activity/ChatHistory$HistoryItemOnlongClickListener;
    //   2197: invokevirtual 185	android/widget/TextView:setOnTouchListener	(Landroid/view/View$OnTouchListener;)V
    //   2200: aload 17
    //   2202: aload_0
    //   2203: getfield 18	com/tencent/mobileqq/activity/ChatHistory$ChatHistoryAdapter:f	Lcom/tencent/mobileqq/activity/ChatHistory;
    //   2206: getfield 181	com/tencent/mobileqq/activity/ChatHistory:X	Lcom/tencent/mobileqq/activity/ChatHistory$HistoryItemOnlongClickListener;
    //   2209: invokevirtual 189	android/widget/TextView:setOnLongClickListener	(Landroid/view/View$OnLongClickListener;)V
    //   2212: return
    //   2213: astore_2
    //   2214: aload_2
    //   2215: invokevirtual 984	java/lang/Exception:printStackTrace	()V
    //   2218: goto +1945 -> 4163
    //   2221: iload 7
    //   2223: sipush -2000
    //   2226: if_icmpeq +2970 -> 5196
    //   2229: iload 7
    //   2231: sipush -20000
    //   2234: if_icmpeq +2962 -> 5196
    //   2237: iload 7
    //   2239: sipush -3004
    //   2242: if_icmpeq +2954 -> 5196
    //   2245: iload 7
    //   2247: sipush -3005
    //   2250: if_icmpeq +2946 -> 5196
    //   2253: iload 7
    //   2255: sipush -3000
    //   2258: if_icmpeq +2938 -> 5196
    //   2261: iload 7
    //   2263: sipush -3001
    //   2266: if_icmpeq +2930 -> 5196
    //   2269: iload 7
    //   2271: sipush -5015
    //   2274: if_icmpne +6 -> 2280
    //   2277: goto +2919 -> 5196
    //   2280: iload 7
    //   2282: sipush -2002
    //   2285: if_icmpne +671 -> 2956
    //   2288: aload_3
    //   2289: aload_3
    //   2290: ldc_w 348
    //   2293: invokeinterface 134 2 0
    //   2298: invokeinterface 352 2 0
    //   2303: astore 20
    //   2305: new 1027	localpb/richMsg/RichMsg$PttRec
    //   2308: dup
    //   2309: invokespecial 1028	localpb/richMsg/RichMsg$PttRec:<init>	()V
    //   2312: astore_2
    //   2313: aload_2
    //   2314: aload 20
    //   2316: invokevirtual 1032	localpb/richMsg/RichMsg$PttRec:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   2319: pop
    //   2320: iconst_1
    //   2321: istore 4
    //   2323: goto +13 -> 2336
    //   2326: astore 20
    //   2328: aload 20
    //   2330: invokevirtual 984	java/lang/Exception:printStackTrace	()V
    //   2333: iconst_0
    //   2334: istore 4
    //   2336: iload 4
    //   2338: ifeq +615 -> 2953
    //   2341: aload_2
    //   2342: getfield 1036	localpb/richMsg/RichMsg$PttRec:voiceLength	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   2345: invokevirtual 1040	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   2348: istore 5
    //   2350: iload 5
    //   2352: istore 4
    //   2354: aload 15
    //   2356: ifnull +91 -> 2447
    //   2359: iload 5
    //   2361: istore 4
    //   2363: aload 15
    //   2365: getfield 233	com/tencent/mobileqq/activity/ChatHistory$Holder:a	Lcom/tencent/mobileqq/data/MessageRecord;
    //   2368: ifnull +79 -> 2447
    //   2371: iload 5
    //   2373: istore 4
    //   2375: aload 15
    //   2377: getfield 233	com/tencent/mobileqq/activity/ChatHistory$Holder:a	Lcom/tencent/mobileqq/data/MessageRecord;
    //   2380: instanceof 1042
    //   2383: ifeq +64 -> 2447
    //   2386: aload 15
    //   2388: getfield 233	com/tencent/mobileqq/activity/ChatHistory$Holder:a	Lcom/tencent/mobileqq/data/MessageRecord;
    //   2391: checkcast 1042	com/tencent/mobileqq/data/MessageForPtt
    //   2394: getfield 1045	com/tencent/mobileqq/data/MessageForPtt:voiceChangeFlag	I
    //   2397: iconst_1
    //   2398: if_icmpne +9 -> 2407
    //   2401: iconst_1
    //   2402: istore 12
    //   2404: goto +6 -> 2410
    //   2407: iconst_0
    //   2408: istore 12
    //   2410: aload 15
    //   2412: iload 12
    //   2414: putfield 1046	com/tencent/mobileqq/activity/ChatHistory$Holder:b	Z
    //   2417: iload 5
    //   2419: istore 4
    //   2421: iload 5
    //   2423: ifgt +24 -> 2447
    //   2426: ldc_w 1048
    //   2429: invokestatic 263	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   2432: checkcast 1048	com/tencent/mobileqq/ptt/temp/api/IQQRecorderTempApi
    //   2435: aload 15
    //   2437: getfield 233	com/tencent/mobileqq/activity/ChatHistory$Holder:a	Lcom/tencent/mobileqq/data/MessageRecord;
    //   2440: invokeinterface 1052 2 0
    //   2445: istore 4
    //   2447: aload 15
    //   2449: getfield 1046	com/tencent/mobileqq/activity/ChatHistory$Holder:b	Z
    //   2452: istore 12
    //   2454: aload_2
    //   2455: getfield 1055	localpb/richMsg/RichMsg$PttRec:voiceType	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   2458: invokevirtual 1057	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   2461: ifeq +15 -> 2476
    //   2464: aload_2
    //   2465: getfield 1055	localpb/richMsg/RichMsg$PttRec:voiceType	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   2468: invokevirtual 1040	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   2471: istore 5
    //   2473: goto +6 -> 2479
    //   2476: iconst_0
    //   2477: istore 5
    //   2479: iload 5
    //   2481: aload_2
    //   2482: getfield 1061	localpb/richMsg/RichMsg$PttRec:localPath	Lcom/tencent/mobileqq/pb/PBStringField;
    //   2485: invokevirtual 1065	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   2488: invokestatic 1069	com/tencent/mobileqq/data/MessageForPtt:getLocalFilePath	(ILjava/lang/String;)Ljava/lang/String;
    //   2491: astore_3
    //   2492: aload_2
    //   2493: getfield 1072	localpb/richMsg/RichMsg$PttRec:size	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   2496: invokevirtual 1076	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   2499: lstore 8
    //   2501: aload_0
    //   2502: getfield 18	com/tencent/mobileqq/activity/ChatHistory$ChatHistoryAdapter:f	Lcom/tencent/mobileqq/activity/ChatHistory;
    //   2505: getfield 57	com/tencent/mobileqq/activity/ChatHistory:z	I
    //   2508: istore 6
    //   2510: aload_0
    //   2511: getfield 18	com/tencent/mobileqq/activity/ChatHistory$ChatHistoryAdapter:f	Lcom/tencent/mobileqq/activity/ChatHistory;
    //   2514: getfield 61	com/tencent/mobileqq/activity/ChatHistory:A	I
    //   2517: istore 5
    //   2519: new 292	java/lang/StringBuilder
    //   2522: dup
    //   2523: invokespecial 293	java/lang/StringBuilder:<init>	()V
    //   2526: astore_2
    //   2527: aload_2
    //   2528: aload_3
    //   2529: invokevirtual 299	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2532: pop
    //   2533: aload_2
    //   2534: aload 13
    //   2536: invokevirtual 299	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2539: pop
    //   2540: aload_2
    //   2541: lload 10
    //   2543: invokevirtual 328	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2546: pop
    //   2547: aload 19
    //   2549: aload_2
    //   2550: invokevirtual 313	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2553: invokevirtual 1077	android/widget/Button:setTag	(Ljava/lang/Object;)V
    //   2556: aload 19
    //   2558: iconst_0
    //   2559: invokevirtual 974	android/widget/Button:setVisibility	(I)V
    //   2562: aload 19
    //   2564: ldc_w 520
    //   2567: invokevirtual 1078	android/widget/Button:setText	(Ljava/lang/CharSequence;)V
    //   2570: aload 19
    //   2572: aconst_null
    //   2573: invokevirtual 1078	android/widget/Button:setText	(Ljava/lang/CharSequence;)V
    //   2576: aload 19
    //   2578: aconst_null
    //   2579: aconst_null
    //   2580: aconst_null
    //   2581: aconst_null
    //   2582: invokevirtual 1082	android/widget/Button:setCompoundDrawables	(Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;)V
    //   2585: aload 19
    //   2587: iload 6
    //   2589: iconst_0
    //   2590: iload 5
    //   2592: iconst_0
    //   2593: invokevirtual 1086	android/widget/Button:setPadding	(IIII)V
    //   2596: aload 19
    //   2598: aload_0
    //   2599: getfield 18	com/tencent/mobileqq/activity/ChatHistory$ChatHistoryAdapter:f	Lcom/tencent/mobileqq/activity/ChatHistory;
    //   2602: getfield 181	com/tencent/mobileqq/activity/ChatHistory:X	Lcom/tencent/mobileqq/activity/ChatHistory$HistoryItemOnlongClickListener;
    //   2605: invokevirtual 1087	android/widget/Button:setOnTouchListener	(Landroid/view/View$OnTouchListener;)V
    //   2608: aload 19
    //   2610: aload_0
    //   2611: getfield 18	com/tencent/mobileqq/activity/ChatHistory$ChatHistoryAdapter:f	Lcom/tencent/mobileqq/activity/ChatHistory;
    //   2614: getfield 181	com/tencent/mobileqq/activity/ChatHistory:X	Lcom/tencent/mobileqq/activity/ChatHistory$HistoryItemOnlongClickListener;
    //   2617: invokevirtual 1088	android/widget/Button:setOnLongClickListener	(Landroid/view/View$OnLongClickListener;)V
    //   2620: iload 4
    //   2622: istore 5
    //   2624: iload 4
    //   2626: ifgt +20 -> 2646
    //   2629: ldc_w 1090
    //   2632: invokestatic 263	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   2635: checkcast 1090	com/tencent/mobileqq/ptt/IQQRecorderUtils
    //   2638: aload_3
    //   2639: invokeinterface 1092 2 0
    //   2644: istore 5
    //   2646: aload_3
    //   2647: getstatic 1095	com/tencent/mobileqq/app/AppConstants:SDCARD_ROOT	Ljava/lang/String;
    //   2650: invokevirtual 1098	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   2653: ifeq +236 -> 2889
    //   2656: iload 5
    //   2658: ifgt +6 -> 2664
    //   2661: goto +228 -> 2889
    //   2664: new 292	java/lang/StringBuilder
    //   2667: dup
    //   2668: invokespecial 293	java/lang/StringBuilder:<init>	()V
    //   2671: astore_2
    //   2672: aload_2
    //   2673: iload 5
    //   2675: invokestatic 1100	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   2678: invokevirtual 299	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2681: pop
    //   2682: aload_2
    //   2683: ldc_w 1102
    //   2686: invokevirtual 299	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2689: pop
    //   2690: aload 19
    //   2692: aload_2
    //   2693: invokevirtual 313	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2696: invokevirtual 1078	android/widget/Button:setText	(Ljava/lang/CharSequence;)V
    //   2699: aload 19
    //   2701: iload 6
    //   2703: iconst_0
    //   2704: aload_0
    //   2705: iload 5
    //   2707: invokevirtual 1104	com/tencent/mobileqq/activity/ChatHistory$ChatHistoryAdapter:a	(I)I
    //   2710: iconst_0
    //   2711: invokevirtual 1086	android/widget/Button:setPadding	(IIII)V
    //   2714: aload_0
    //   2715: getfield 18	com/tencent/mobileqq/activity/ChatHistory$ChatHistoryAdapter:f	Lcom/tencent/mobileqq/activity/ChatHistory;
    //   2718: getfield 421	com/tencent/mobileqq/activity/ChatHistory:al	Lcom/tencent/mobileqq/activity/ChatHistory$PlayingPttHistoryInfo;
    //   2721: ifnull +37 -> 2758
    //   2724: aload_0
    //   2725: getfield 18	com/tencent/mobileqq/activity/ChatHistory$ChatHistoryAdapter:f	Lcom/tencent/mobileqq/activity/ChatHistory;
    //   2728: getfield 421	com/tencent/mobileqq/activity/ChatHistory:al	Lcom/tencent/mobileqq/activity/ChatHistory$PlayingPttHistoryInfo;
    //   2731: iconst_0
    //   2732: aload 19
    //   2734: invokevirtual 1105	android/widget/Button:getTag	()Ljava/lang/Object;
    //   2737: invokevirtual 430	com/tencent/mobileqq/activity/ChatHistory$PlayingPttHistoryInfo:a	(ILjava/lang/Object;)Z
    //   2740: ifeq +18 -> 2758
    //   2743: aload_0
    //   2744: getfield 18	com/tencent/mobileqq/activity/ChatHistory$ChatHistoryAdapter:f	Lcom/tencent/mobileqq/activity/ChatHistory;
    //   2747: getfield 421	com/tencent/mobileqq/activity/ChatHistory:al	Lcom/tencent/mobileqq/activity/ChatHistory$PlayingPttHistoryInfo;
    //   2750: aload_1
    //   2751: aload_3
    //   2752: invokevirtual 458	com/tencent/mobileqq/activity/ChatHistory$PlayingPttHistoryInfo:a	(Landroid/view/View;Ljava/lang/String;)V
    //   2755: goto +117 -> 2872
    //   2758: iload 12
    //   2760: ifeq +20 -> 2780
    //   2763: aload_0
    //   2764: getfield 39	com/tencent/mobileqq/activity/ChatHistory$ChatHistoryAdapter:c	Landroid/content/Context;
    //   2767: invokevirtual 66	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   2770: ldc_w 1106
    //   2773: invokevirtual 1110	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   2776: astore_1
    //   2777: goto +17 -> 2794
    //   2780: aload_0
    //   2781: getfield 39	com/tencent/mobileqq/activity/ChatHistory$ChatHistoryAdapter:c	Landroid/content/Context;
    //   2784: invokevirtual 66	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   2787: ldc_w 1111
    //   2790: invokevirtual 1110	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   2793: astore_1
    //   2794: aload_1
    //   2795: iconst_0
    //   2796: iconst_0
    //   2797: aload_1
    //   2798: invokevirtual 1116	android/graphics/drawable/Drawable:getMinimumWidth	()I
    //   2801: aload_1
    //   2802: invokevirtual 1119	android/graphics/drawable/Drawable:getMinimumHeight	()I
    //   2805: invokevirtual 1122	android/graphics/drawable/Drawable:setBounds	(IIII)V
    //   2808: aload 19
    //   2810: aload_1
    //   2811: aconst_null
    //   2812: aconst_null
    //   2813: aconst_null
    //   2814: invokevirtual 1082	android/widget/Button:setCompoundDrawables	(Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;)V
    //   2817: lload 8
    //   2819: lconst_0
    //   2820: lcmp
    //   2821: ifgt +51 -> 2872
    //   2824: new 292	java/lang/StringBuilder
    //   2827: dup
    //   2828: invokespecial 293	java/lang/StringBuilder:<init>	()V
    //   2831: astore_1
    //   2832: aload_1
    //   2833: ldc_w 1124
    //   2836: invokevirtual 299	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2839: pop
    //   2840: aload_1
    //   2841: aload_0
    //   2842: getfield 18	com/tencent/mobileqq/activity/ChatHistory$ChatHistoryAdapter:f	Lcom/tencent/mobileqq/activity/ChatHistory;
    //   2845: ldc_w 1125
    //   2848: invokevirtual 228	com/tencent/mobileqq/activity/ChatHistory:getString	(I)Ljava/lang/String;
    //   2851: invokevirtual 299	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2854: pop
    //   2855: aload_1
    //   2856: ldc_w 1127
    //   2859: invokevirtual 299	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2862: pop
    //   2863: aload 19
    //   2865: aload_1
    //   2866: invokevirtual 313	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2869: invokevirtual 1078	android/widget/Button:setText	(Ljava/lang/CharSequence;)V
    //   2872: aload 19
    //   2874: new 1129	com/tencent/mobileqq/activity/ChatHistory$ChatHistoryAdapter$2
    //   2877: dup
    //   2878: aload_0
    //   2879: iload 5
    //   2881: aload_3
    //   2882: invokespecial 1132	com/tencent/mobileqq/activity/ChatHistory$ChatHistoryAdapter$2:<init>	(Lcom/tencent/mobileqq/activity/ChatHistory$ChatHistoryAdapter;ILjava/lang/String;)V
    //   2885: invokevirtual 977	android/widget/Button:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   2888: return
    //   2889: aload 19
    //   2891: aconst_null
    //   2892: aconst_null
    //   2893: aconst_null
    //   2894: aconst_null
    //   2895: invokevirtual 1082	android/widget/Button:setCompoundDrawables	(Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;)V
    //   2898: new 292	java/lang/StringBuilder
    //   2901: dup
    //   2902: invokespecial 293	java/lang/StringBuilder:<init>	()V
    //   2905: astore_1
    //   2906: aload_1
    //   2907: ldc_w 1124
    //   2910: invokevirtual 299	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2913: pop
    //   2914: aload_1
    //   2915: aload_0
    //   2916: getfield 18	com/tencent/mobileqq/activity/ChatHistory$ChatHistoryAdapter:f	Lcom/tencent/mobileqq/activity/ChatHistory;
    //   2919: ldc_w 1133
    //   2922: invokevirtual 228	com/tencent/mobileqq/activity/ChatHistory:getString	(I)Ljava/lang/String;
    //   2925: invokevirtual 299	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2928: pop
    //   2929: aload_1
    //   2930: ldc_w 1127
    //   2933: invokevirtual 299	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2936: pop
    //   2937: aload 19
    //   2939: aload_1
    //   2940: invokevirtual 313	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2943: invokevirtual 1078	android/widget/Button:setText	(Ljava/lang/CharSequence;)V
    //   2946: aload 19
    //   2948: aconst_null
    //   2949: invokevirtual 977	android/widget/Button:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   2952: return
    //   2953: goto +1210 -> 4163
    //   2956: aload 13
    //   2958: astore_2
    //   2959: iload 7
    //   2961: sipush -1035
    //   2964: if_icmpne +24 -> 2988
    //   2967: aload 28
    //   2969: iconst_0
    //   2970: invokevirtual 975	com/tencent/mobileqq/widget/MixedMsgLinearLayout:setVisibility	(I)V
    //   2973: aload_0
    //   2974: aload 28
    //   2976: aload 15
    //   2978: getfield 233	com/tencent/mobileqq/activity/ChatHistory$Holder:a	Lcom/tencent/mobileqq/data/MessageRecord;
    //   2981: checkcast 567	com/tencent/mobileqq/data/MessageForMixedMsg
    //   2984: invokevirtual 1135	com/tencent/mobileqq/activity/ChatHistory$ChatHistoryAdapter:a	(Lcom/tencent/mobileqq/widget/MixedMsgLinearLayout;Lcom/tencent/mobileqq/data/MessageForMixedMsg;)V
    //   2987: return
    //   2988: iload 7
    //   2990: sipush -7001
    //   2993: if_icmpne +25 -> 3018
    //   2996: aload 17
    //   2998: iconst_0
    //   2999: invokevirtual 172	android/widget/TextView:setVisibility	(I)V
    //   3002: aload 17
    //   3004: aload_0
    //   3005: getfield 18	com/tencent/mobileqq/activity/ChatHistory$ChatHistoryAdapter:f	Lcom/tencent/mobileqq/activity/ChatHistory;
    //   3008: ldc_w 1136
    //   3011: invokevirtual 228	com/tencent/mobileqq/activity/ChatHistory:getString	(I)Ljava/lang/String;
    //   3014: invokevirtual 222	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   3017: return
    //   3018: iload 7
    //   3020: sipush -2017
    //   3023: if_icmpne +19 -> 3042
    //   3026: aload 17
    //   3028: iconst_0
    //   3029: invokevirtual 172	android/widget/TextView:setVisibility	(I)V
    //   3032: aload 17
    //   3034: aconst_null
    //   3035: invokestatic 1140	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/String;)Ljava/lang/String;
    //   3038: invokevirtual 222	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   3041: return
    //   3042: iload 7
    //   3044: sipush -2020
    //   3047: if_icmpne +116 -> 3163
    //   3050: aload 17
    //   3052: iconst_0
    //   3053: invokevirtual 172	android/widget/TextView:setVisibility	(I)V
    //   3056: aload 17
    //   3058: new 1142	com/tencent/mobileqq/activity/ChatHistory$ChatHistoryAdapter$3
    //   3061: dup
    //   3062: aload_0
    //   3063: aload_2
    //   3064: invokespecial 1145	com/tencent/mobileqq/activity/ChatHistory$ChatHistoryAdapter$3:<init>	(Lcom/tencent/mobileqq/activity/ChatHistory$ChatHistoryAdapter;Ljava/lang/String;)V
    //   3067: invokevirtual 976	android/widget/TextView:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   3070: aload 17
    //   3072: aload_0
    //   3073: getfield 18	com/tencent/mobileqq/activity/ChatHistory$ChatHistoryAdapter:f	Lcom/tencent/mobileqq/activity/ChatHistory;
    //   3076: getfield 181	com/tencent/mobileqq/activity/ChatHistory:X	Lcom/tencent/mobileqq/activity/ChatHistory$HistoryItemOnlongClickListener;
    //   3079: invokevirtual 185	android/widget/TextView:setOnTouchListener	(Landroid/view/View$OnTouchListener;)V
    //   3082: aload 17
    //   3084: aload_0
    //   3085: getfield 18	com/tencent/mobileqq/activity/ChatHistory$ChatHistoryAdapter:f	Lcom/tencent/mobileqq/activity/ChatHistory;
    //   3088: getfield 181	com/tencent/mobileqq/activity/ChatHistory:X	Lcom/tencent/mobileqq/activity/ChatHistory$HistoryItemOnlongClickListener;
    //   3091: invokevirtual 189	android/widget/TextView:setOnLongClickListener	(Landroid/view/View$OnLongClickListener;)V
    //   3094: iload 5
    //   3096: invokestatic 1148	com/tencent/mobileqq/service/message/remote/MessageRecordInfo:b	(I)Z
    //   3099: ifeq +42 -> 3141
    //   3102: aload 17
    //   3104: aload_0
    //   3105: getfield 18	com/tencent/mobileqq/activity/ChatHistory$ChatHistoryAdapter:f	Lcom/tencent/mobileqq/activity/ChatHistory;
    //   3108: getfield 209	com/tencent/mobileqq/activity/ChatHistory:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   3111: invokevirtual 1151	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   3114: ldc_w 1152
    //   3117: iconst_1
    //   3118: anewarray 675	java/lang/Object
    //   3121: dup
    //   3122: iconst_0
    //   3123: aload_0
    //   3124: getfield 18	com/tencent/mobileqq/activity/ChatHistory$ChatHistoryAdapter:f	Lcom/tencent/mobileqq/activity/ChatHistory;
    //   3127: getfield 601	com/tencent/mobileqq/activity/ChatHistory:K	Lcom/tencent/mobileqq/activity/aio/SessionInfo;
    //   3130: getfield 1155	com/tencent/mobileqq/activity/aio/SessionInfo:e	Ljava/lang/String;
    //   3133: aastore
    //   3134: invokevirtual 1160	com/tencent/qphone/base/util/BaseApplication:getString	(I[Ljava/lang/Object;)Ljava/lang/String;
    //   3137: invokevirtual 222	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   3140: return
    //   3141: aload 17
    //   3143: aload_0
    //   3144: getfield 18	com/tencent/mobileqq/activity/ChatHistory$ChatHistoryAdapter:f	Lcom/tencent/mobileqq/activity/ChatHistory;
    //   3147: getfield 209	com/tencent/mobileqq/activity/ChatHistory:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   3150: invokevirtual 1151	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   3153: ldc_w 1161
    //   3156: invokevirtual 1162	com/tencent/qphone/base/util/BaseApplication:getString	(I)Ljava/lang/String;
    //   3159: invokevirtual 222	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   3162: return
    //   3163: iload 7
    //   3165: sipush -3008
    //   3168: if_icmpne +88 -> 3256
    //   3171: new 292	java/lang/StringBuilder
    //   3174: dup
    //   3175: invokespecial 293	java/lang/StringBuilder:<init>	()V
    //   3178: astore_1
    //   3179: aload_1
    //   3180: invokestatic 944	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   3183: ldc_w 1163
    //   3186: invokevirtual 1162	com/tencent/qphone/base/util/BaseApplication:getString	(I)Ljava/lang/String;
    //   3189: invokevirtual 299	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3192: pop
    //   3193: aload_1
    //   3194: ldc_w 1102
    //   3197: invokevirtual 299	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3200: pop
    //   3201: aload_1
    //   3202: aload 14
    //   3204: invokevirtual 299	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3207: pop
    //   3208: aload_1
    //   3209: ldc_w 1102
    //   3212: invokevirtual 299	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3215: pop
    //   3216: aload 17
    //   3218: aload_1
    //   3219: invokevirtual 313	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3222: invokevirtual 222	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   3225: aload 17
    //   3227: iconst_0
    //   3228: invokevirtual 172	android/widget/TextView:setVisibility	(I)V
    //   3231: aload 17
    //   3233: aload_0
    //   3234: getfield 18	com/tencent/mobileqq/activity/ChatHistory$ChatHistoryAdapter:f	Lcom/tencent/mobileqq/activity/ChatHistory;
    //   3237: getfield 181	com/tencent/mobileqq/activity/ChatHistory:X	Lcom/tencent/mobileqq/activity/ChatHistory$HistoryItemOnlongClickListener;
    //   3240: invokevirtual 185	android/widget/TextView:setOnTouchListener	(Landroid/view/View$OnTouchListener;)V
    //   3243: aload 17
    //   3245: aload_0
    //   3246: getfield 18	com/tencent/mobileqq/activity/ChatHistory$ChatHistoryAdapter:f	Lcom/tencent/mobileqq/activity/ChatHistory;
    //   3249: getfield 181	com/tencent/mobileqq/activity/ChatHistory:X	Lcom/tencent/mobileqq/activity/ChatHistory$HistoryItemOnlongClickListener;
    //   3252: invokevirtual 189	android/widget/TextView:setOnLongClickListener	(Landroid/view/View$OnLongClickListener;)V
    //   3255: return
    //   3256: iload 7
    //   3258: sipush -2022
    //   3261: if_icmpne +49 -> 3310
    //   3264: aload 17
    //   3266: iconst_0
    //   3267: invokevirtual 172	android/widget/TextView:setVisibility	(I)V
    //   3270: aload 17
    //   3272: aload_0
    //   3273: getfield 18	com/tencent/mobileqq/activity/ChatHistory$ChatHistoryAdapter:f	Lcom/tencent/mobileqq/activity/ChatHistory;
    //   3276: ldc_w 1164
    //   3279: invokevirtual 228	com/tencent/mobileqq/activity/ChatHistory:getString	(I)Ljava/lang/String;
    //   3282: invokevirtual 222	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   3285: aload 17
    //   3287: aload_0
    //   3288: getfield 18	com/tencent/mobileqq/activity/ChatHistory$ChatHistoryAdapter:f	Lcom/tencent/mobileqq/activity/ChatHistory;
    //   3291: getfield 181	com/tencent/mobileqq/activity/ChatHistory:X	Lcom/tencent/mobileqq/activity/ChatHistory$HistoryItemOnlongClickListener;
    //   3294: invokevirtual 185	android/widget/TextView:setOnTouchListener	(Landroid/view/View$OnTouchListener;)V
    //   3297: aload 17
    //   3299: aload_0
    //   3300: getfield 18	com/tencent/mobileqq/activity/ChatHistory$ChatHistoryAdapter:f	Lcom/tencent/mobileqq/activity/ChatHistory;
    //   3303: getfield 181	com/tencent/mobileqq/activity/ChatHistory:X	Lcom/tencent/mobileqq/activity/ChatHistory$HistoryItemOnlongClickListener;
    //   3306: invokevirtual 189	android/widget/TextView:setOnLongClickListener	(Landroid/view/View$OnLongClickListener;)V
    //   3309: return
    //   3310: iload 7
    //   3312: sipush -5002
    //   3315: if_icmpne +276 -> 3591
    //   3318: aload 15
    //   3320: getfield 233	com/tencent/mobileqq/activity/ChatHistory$Holder:a	Lcom/tencent/mobileqq/data/MessageRecord;
    //   3323: ifnull +158 -> 3481
    //   3326: aload 15
    //   3328: getfield 233	com/tencent/mobileqq/activity/ChatHistory$Holder:a	Lcom/tencent/mobileqq/data/MessageRecord;
    //   3331: instanceof 1166
    //   3334: ifeq +147 -> 3481
    //   3337: aload 15
    //   3339: getfield 233	com/tencent/mobileqq/activity/ChatHistory$Holder:a	Lcom/tencent/mobileqq/data/MessageRecord;
    //   3342: checkcast 1166	com/tencent/mobileqq/data/MessageForIncompatibleGrayTips
    //   3345: astore_1
    //   3346: aload_1
    //   3347: invokevirtual 1167	com/tencent/mobileqq/data/MessageForIncompatibleGrayTips:parse	()V
    //   3350: aload 17
    //   3352: aload_1
    //   3353: getfield 1168	com/tencent/mobileqq/data/MessageForIncompatibleGrayTips:msg	Ljava/lang/String;
    //   3356: invokevirtual 222	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   3359: aload 17
    //   3361: iconst_0
    //   3362: invokevirtual 172	android/widget/TextView:setVisibility	(I)V
    //   3365: aload_1
    //   3366: getfield 1171	com/tencent/mobileqq/data/MessageForIncompatibleGrayTips:url	Ljava/lang/String;
    //   3369: astore 13
    //   3371: new 1173	android/text/SpannableString
    //   3374: dup
    //   3375: aload_1
    //   3376: getfield 1168	com/tencent/mobileqq/data/MessageForIncompatibleGrayTips:msg	Ljava/lang/String;
    //   3379: invokespecial 1175	android/text/SpannableString:<init>	(Ljava/lang/CharSequence;)V
    //   3382: astore_3
    //   3383: new 1177	com/tencent/mobileqq/activity/ChatHistory$ChatHistoryAdapter$4
    //   3386: dup
    //   3387: aload_0
    //   3388: aload 13
    //   3390: aload_2
    //   3391: invokespecial 1180	com/tencent/mobileqq/activity/ChatHistory$ChatHistoryAdapter$4:<init>	(Lcom/tencent/mobileqq/activity/ChatHistory$ChatHistoryAdapter;Ljava/lang/String;Ljava/lang/String;)V
    //   3394: astore_2
    //   3395: aload_3
    //   3396: new 1182	android/text/style/ForegroundColorSpan
    //   3399: dup
    //   3400: ldc_w 1183
    //   3403: invokespecial 1185	android/text/style/ForegroundColorSpan:<init>	(I)V
    //   3406: aload_1
    //   3407: getfield 1188	com/tencent/mobileqq/data/MessageForIncompatibleGrayTips:linkStart	I
    //   3410: aload_1
    //   3411: getfield 1191	com/tencent/mobileqq/data/MessageForIncompatibleGrayTips:linkEnd	I
    //   3414: bipush 33
    //   3416: invokevirtual 1195	android/text/SpannableString:setSpan	(Ljava/lang/Object;III)V
    //   3419: aload_3
    //   3420: aload_2
    //   3421: aload_1
    //   3422: getfield 1188	com/tencent/mobileqq/data/MessageForIncompatibleGrayTips:linkStart	I
    //   3425: aload_1
    //   3426: getfield 1191	com/tencent/mobileqq/data/MessageForIncompatibleGrayTips:linkEnd	I
    //   3429: bipush 33
    //   3431: invokevirtual 1195	android/text/SpannableString:setSpan	(Ljava/lang/Object;III)V
    //   3434: aload 17
    //   3436: aload_3
    //   3437: invokevirtual 222	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   3440: aload 17
    //   3442: invokestatic 799	android/text/method/LinkMovementMethod:getInstance	()Landroid/text/method/MovementMethod;
    //   3445: invokevirtual 803	android/widget/TextView:setMovementMethod	(Landroid/text/method/MovementMethod;)V
    //   3448: aload 17
    //   3450: ldc_w 1196
    //   3453: invokevirtual 1199	android/widget/TextView:setHighlightColor	(I)V
    //   3456: aload 17
    //   3458: aload_0
    //   3459: getfield 18	com/tencent/mobileqq/activity/ChatHistory$ChatHistoryAdapter:f	Lcom/tencent/mobileqq/activity/ChatHistory;
    //   3462: getfield 181	com/tencent/mobileqq/activity/ChatHistory:X	Lcom/tencent/mobileqq/activity/ChatHistory$HistoryItemOnlongClickListener;
    //   3465: invokevirtual 185	android/widget/TextView:setOnTouchListener	(Landroid/view/View$OnTouchListener;)V
    //   3468: aload 17
    //   3470: aload_0
    //   3471: getfield 18	com/tencent/mobileqq/activity/ChatHistory$ChatHistoryAdapter:f	Lcom/tencent/mobileqq/activity/ChatHistory;
    //   3474: getfield 181	com/tencent/mobileqq/activity/ChatHistory:X	Lcom/tencent/mobileqq/activity/ChatHistory$HistoryItemOnlongClickListener;
    //   3477: invokevirtual 189	android/widget/TextView:setOnLongClickListener	(Landroid/view/View$OnLongClickListener;)V
    //   3480: return
    //   3481: invokestatic 290	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3484: ifeq +106 -> 3590
    //   3487: new 292	java/lang/StringBuilder
    //   3490: dup
    //   3491: invokespecial 293	java/lang/StringBuilder:<init>	()V
    //   3494: astore_1
    //   3495: aload_1
    //   3496: ldc_w 1201
    //   3499: invokevirtual 299	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3502: pop
    //   3503: aload_1
    //   3504: aload 15
    //   3506: getfield 233	com/tencent/mobileqq/activity/ChatHistory$Holder:a	Lcom/tencent/mobileqq/data/MessageRecord;
    //   3509: getfield 325	com/tencent/mobileqq/data/MessageRecord:uniseq	J
    //   3512: invokevirtual 328	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3515: pop
    //   3516: aload_1
    //   3517: ldc_w 330
    //   3520: invokevirtual 299	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3523: pop
    //   3524: aload_1
    //   3525: aload 15
    //   3527: getfield 233	com/tencent/mobileqq/activity/ChatHistory$Holder:a	Lcom/tencent/mobileqq/data/MessageRecord;
    //   3530: invokevirtual 334	com/tencent/mobileqq/data/MessageRecord:getId	()J
    //   3533: invokevirtual 328	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3536: pop
    //   3537: aload_1
    //   3538: ldc_w 336
    //   3541: invokevirtual 299	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3544: pop
    //   3545: aload_1
    //   3546: aload 15
    //   3548: getfield 233	com/tencent/mobileqq/activity/ChatHistory$Holder:a	Lcom/tencent/mobileqq/data/MessageRecord;
    //   3551: getfield 339	com/tencent/mobileqq/data/MessageRecord:istroop	I
    //   3554: invokevirtual 342	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3557: pop
    //   3558: aload_1
    //   3559: ldc_w 344
    //   3562: invokevirtual 299	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3565: pop
    //   3566: aload_1
    //   3567: aload 15
    //   3569: getfield 233	com/tencent/mobileqq/activity/ChatHistory$Holder:a	Lcom/tencent/mobileqq/data/MessageRecord;
    //   3572: getfield 346	com/tencent/mobileqq/data/MessageRecord:msgtype	I
    //   3575: invokevirtual 342	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3578: pop
    //   3579: ldc_w 309
    //   3582: iconst_2
    //   3583: aload_1
    //   3584: invokevirtual 313	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3587: invokestatic 316	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3590: return
    //   3591: iload 7
    //   3593: sipush -2025
    //   3596: if_icmpne +74 -> 3670
    //   3599: new 1203	com/tencent/mobileqq/data/MessageForQQWalletMsg
    //   3602: dup
    //   3603: invokespecial 1204	com/tencent/mobileqq/data/MessageForQQWalletMsg:<init>	()V
    //   3606: astore_1
    //   3607: aload_1
    //   3608: aload_3
    //   3609: aload_3
    //   3610: ldc_w 348
    //   3613: invokeinterface 134 2 0
    //   3618: invokeinterface 352 2 0
    //   3623: putfield 1206	com/tencent/mobileqq/data/MessageForQQWalletMsg:msgData	[B
    //   3626: aload_1
    //   3627: invokevirtual 1207	com/tencent/mobileqq/data/MessageForQQWalletMsg:parse	()V
    //   3630: aload 17
    //   3632: iconst_0
    //   3633: invokevirtual 172	android/widget/TextView:setVisibility	(I)V
    //   3636: aload 17
    //   3638: aload_1
    //   3639: invokevirtual 1209	com/tencent/mobileqq/data/MessageForQQWalletMsg:getMsgSummary	()Ljava/lang/String;
    //   3642: invokevirtual 222	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   3645: aload 17
    //   3647: aload_0
    //   3648: getfield 18	com/tencent/mobileqq/activity/ChatHistory$ChatHistoryAdapter:f	Lcom/tencent/mobileqq/activity/ChatHistory;
    //   3651: getfield 181	com/tencent/mobileqq/activity/ChatHistory:X	Lcom/tencent/mobileqq/activity/ChatHistory$HistoryItemOnlongClickListener;
    //   3654: invokevirtual 185	android/widget/TextView:setOnTouchListener	(Landroid/view/View$OnTouchListener;)V
    //   3657: aload 17
    //   3659: aload_0
    //   3660: getfield 18	com/tencent/mobileqq/activity/ChatHistory$ChatHistoryAdapter:f	Lcom/tencent/mobileqq/activity/ChatHistory;
    //   3663: getfield 181	com/tencent/mobileqq/activity/ChatHistory:X	Lcom/tencent/mobileqq/activity/ChatHistory$HistoryItemOnlongClickListener;
    //   3666: invokevirtual 189	android/widget/TextView:setOnLongClickListener	(Landroid/view/View$OnLongClickListener;)V
    //   3669: return
    //   3670: iload 7
    //   3672: sipush -2036
    //   3675: if_icmpne +74 -> 3749
    //   3678: new 1211	com/tencent/mobileqq/data/MessageForTroopFee
    //   3681: dup
    //   3682: invokespecial 1212	com/tencent/mobileqq/data/MessageForTroopFee:<init>	()V
    //   3685: astore_1
    //   3686: aload_1
    //   3687: aload_3
    //   3688: aload_3
    //   3689: ldc_w 348
    //   3692: invokeinterface 134 2 0
    //   3697: invokeinterface 352 2 0
    //   3702: putfield 1213	com/tencent/mobileqq/data/MessageForTroopFee:msgData	[B
    //   3705: aload_1
    //   3706: invokevirtual 1214	com/tencent/mobileqq/data/MessageForTroopFee:parse	()V
    //   3709: aload 17
    //   3711: iconst_0
    //   3712: invokevirtual 172	android/widget/TextView:setVisibility	(I)V
    //   3715: aload 17
    //   3717: aload_1
    //   3718: invokevirtual 1217	com/tencent/mobileqq/data/MessageForTroopFee:getSummaryMsg	()Ljava/lang/String;
    //   3721: invokevirtual 222	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   3724: aload 17
    //   3726: aload_0
    //   3727: getfield 18	com/tencent/mobileqq/activity/ChatHistory$ChatHistoryAdapter:f	Lcom/tencent/mobileqq/activity/ChatHistory;
    //   3730: getfield 181	com/tencent/mobileqq/activity/ChatHistory:X	Lcom/tencent/mobileqq/activity/ChatHistory$HistoryItemOnlongClickListener;
    //   3733: invokevirtual 185	android/widget/TextView:setOnTouchListener	(Landroid/view/View$OnTouchListener;)V
    //   3736: aload 17
    //   3738: aload_0
    //   3739: getfield 18	com/tencent/mobileqq/activity/ChatHistory$ChatHistoryAdapter:f	Lcom/tencent/mobileqq/activity/ChatHistory;
    //   3742: getfield 181	com/tencent/mobileqq/activity/ChatHistory:X	Lcom/tencent/mobileqq/activity/ChatHistory$HistoryItemOnlongClickListener;
    //   3745: invokevirtual 189	android/widget/TextView:setOnLongClickListener	(Landroid/view/View$OnLongClickListener;)V
    //   3748: return
    //   3749: iload 7
    //   3751: sipush -2035
    //   3754: if_icmpne +170 -> 3924
    //   3757: invokestatic 290	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3760: ifeq +85 -> 3845
    //   3763: new 292	java/lang/StringBuilder
    //   3766: dup
    //   3767: invokespecial 293	java/lang/StringBuilder:<init>	()V
    //   3770: astore_1
    //   3771: aload_1
    //   3772: ldc_w 1219
    //   3775: invokevirtual 299	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3778: pop
    //   3779: aload_1
    //   3780: aload 15
    //   3782: getfield 233	com/tencent/mobileqq/activity/ChatHistory$Holder:a	Lcom/tencent/mobileqq/data/MessageRecord;
    //   3785: getfield 1222	com/tencent/mobileqq/data/MessageRecord:shmsgseq	J
    //   3788: invokevirtual 328	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3791: pop
    //   3792: aload_1
    //   3793: ldc_w 1224
    //   3796: invokevirtual 299	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3799: pop
    //   3800: aload_1
    //   3801: aload 15
    //   3803: getfield 233	com/tencent/mobileqq/activity/ChatHistory$Holder:a	Lcom/tencent/mobileqq/data/MessageRecord;
    //   3806: getfield 346	com/tencent/mobileqq/data/MessageRecord:msgtype	I
    //   3809: invokevirtual 342	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3812: pop
    //   3813: aload_1
    //   3814: ldc_w 1226
    //   3817: invokevirtual 299	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3820: pop
    //   3821: aload_1
    //   3822: aload 15
    //   3824: getfield 233	com/tencent/mobileqq/activity/ChatHistory$Holder:a	Lcom/tencent/mobileqq/data/MessageRecord;
    //   3827: getfield 857	com/tencent/mobileqq/data/MessageRecord:msg	Ljava/lang/String;
    //   3830: invokevirtual 299	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3833: pop
    //   3834: ldc_w 1228
    //   3837: iconst_2
    //   3838: aload_1
    //   3839: invokevirtual 313	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3842: invokestatic 316	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3845: aload 15
    //   3847: getfield 233	com/tencent/mobileqq/activity/ChatHistory$Holder:a	Lcom/tencent/mobileqq/data/MessageRecord;
    //   3850: checkcast 1230	com/tencent/mobileqq/data/MessageForDeliverGiftTips
    //   3853: astore_1
    //   3854: aload 26
    //   3856: bipush 8
    //   3858: invokevirtual 786	android/widget/LinearLayout:setVisibility	(I)V
    //   3861: aload 17
    //   3863: bipush 8
    //   3865: invokevirtual 172	android/widget/TextView:setVisibility	(I)V
    //   3868: aload 27
    //   3870: iconst_0
    //   3871: invokevirtual 172	android/widget/TextView:setVisibility	(I)V
    //   3874: aload 27
    //   3876: iconst_1
    //   3877: invokevirtual 1233	android/widget/TextView:setClickable	(Z)V
    //   3880: aload 27
    //   3882: iconst_1
    //   3883: invokevirtual 1236	android/widget/TextView:setFocusable	(Z)V
    //   3886: aload 27
    //   3888: invokestatic 799	android/text/method/LinkMovementMethod:getInstance	()Landroid/text/method/MovementMethod;
    //   3891: invokevirtual 803	android/widget/TextView:setMovementMethod	(Landroid/text/method/MovementMethod;)V
    //   3894: aload 27
    //   3896: iconst_0
    //   3897: invokevirtual 172	android/widget/TextView:setVisibility	(I)V
    //   3900: aload 27
    //   3902: aload_1
    //   3903: aload_0
    //   3904: getfield 18	com/tencent/mobileqq/activity/ChatHistory$ChatHistoryAdapter:f	Lcom/tencent/mobileqq/activity/ChatHistory;
    //   3907: getfield 209	com/tencent/mobileqq/activity/ChatHistory:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   3910: aload_0
    //   3911: getfield 39	com/tencent/mobileqq/activity/ChatHistory$ChatHistoryAdapter:c	Landroid/content/Context;
    //   3914: iconst_0
    //   3915: aload 27
    //   3917: invokevirtual 1240	com/tencent/mobileqq/data/MessageForDeliverGiftTips:getHightlightMsgText	(Lcom/tencent/mobileqq/app/QQAppInterface;Landroid/content/Context;ZLandroid/graphics/drawable/Drawable$Callback;)Landroid/text/SpannableStringBuilder;
    //   3920: invokevirtual 222	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   3923: return
    //   3924: iload 7
    //   3926: sipush -2038
    //   3929: if_icmpne +74 -> 4003
    //   3932: new 1242	com/tencent/mobileqq/data/MessageForTroopGift
    //   3935: dup
    //   3936: invokespecial 1243	com/tencent/mobileqq/data/MessageForTroopGift:<init>	()V
    //   3939: astore_1
    //   3940: aload_1
    //   3941: aload_3
    //   3942: aload_3
    //   3943: ldc_w 348
    //   3946: invokeinterface 134 2 0
    //   3951: invokeinterface 352 2 0
    //   3956: putfield 1244	com/tencent/mobileqq/data/MessageForTroopGift:msgData	[B
    //   3959: aload_1
    //   3960: invokevirtual 1245	com/tencent/mobileqq/data/MessageForTroopGift:parse	()V
    //   3963: aload 17
    //   3965: iconst_0
    //   3966: invokevirtual 172	android/widget/TextView:setVisibility	(I)V
    //   3969: aload 17
    //   3971: aload_1
    //   3972: getfield 1248	com/tencent/mobileqq/data/MessageForTroopGift:summary	Ljava/lang/String;
    //   3975: invokevirtual 222	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   3978: aload 17
    //   3980: aload_0
    //   3981: getfield 18	com/tencent/mobileqq/activity/ChatHistory$ChatHistoryAdapter:f	Lcom/tencent/mobileqq/activity/ChatHistory;
    //   3984: getfield 181	com/tencent/mobileqq/activity/ChatHistory:X	Lcom/tencent/mobileqq/activity/ChatHistory$HistoryItemOnlongClickListener;
    //   3987: invokevirtual 185	android/widget/TextView:setOnTouchListener	(Landroid/view/View$OnTouchListener;)V
    //   3990: aload 17
    //   3992: aload_0
    //   3993: getfield 18	com/tencent/mobileqq/activity/ChatHistory$ChatHistoryAdapter:f	Lcom/tencent/mobileqq/activity/ChatHistory;
    //   3996: getfield 181	com/tencent/mobileqq/activity/ChatHistory:X	Lcom/tencent/mobileqq/activity/ChatHistory$HistoryItemOnlongClickListener;
    //   3999: invokevirtual 189	android/widget/TextView:setOnLongClickListener	(Landroid/view/View$OnLongClickListener;)V
    //   4002: return
    //   4003: iload 7
    //   4005: sipush -2048
    //   4008: if_icmpne +74 -> 4082
    //   4011: new 1250	com/tencent/mobileqq/data/MessageForTroopReward
    //   4014: dup
    //   4015: invokespecial 1251	com/tencent/mobileqq/data/MessageForTroopReward:<init>	()V
    //   4018: astore_1
    //   4019: aload_1
    //   4020: aload_3
    //   4021: aload_3
    //   4022: ldc_w 348
    //   4025: invokeinterface 134 2 0
    //   4030: invokeinterface 352 2 0
    //   4035: putfield 1252	com/tencent/mobileqq/data/MessageForTroopReward:msgData	[B
    //   4038: aload_1
    //   4039: invokevirtual 1253	com/tencent/mobileqq/data/MessageForTroopReward:parse	()V
    //   4042: aload 17
    //   4044: iconst_0
    //   4045: invokevirtual 172	android/widget/TextView:setVisibility	(I)V
    //   4048: aload 17
    //   4050: aload_1
    //   4051: invokevirtual 1254	com/tencent/mobileqq/data/MessageForTroopReward:getSummaryMsg	()Ljava/lang/String;
    //   4054: invokevirtual 222	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   4057: aload 17
    //   4059: aload_0
    //   4060: getfield 18	com/tencent/mobileqq/activity/ChatHistory$ChatHistoryAdapter:f	Lcom/tencent/mobileqq/activity/ChatHistory;
    //   4063: getfield 181	com/tencent/mobileqq/activity/ChatHistory:X	Lcom/tencent/mobileqq/activity/ChatHistory$HistoryItemOnlongClickListener;
    //   4066: invokevirtual 185	android/widget/TextView:setOnTouchListener	(Landroid/view/View$OnTouchListener;)V
    //   4069: aload 17
    //   4071: aload_0
    //   4072: getfield 18	com/tencent/mobileqq/activity/ChatHistory$ChatHistoryAdapter:f	Lcom/tencent/mobileqq/activity/ChatHistory;
    //   4075: getfield 181	com/tencent/mobileqq/activity/ChatHistory:X	Lcom/tencent/mobileqq/activity/ChatHistory$HistoryItemOnlongClickListener;
    //   4078: invokevirtual 189	android/widget/TextView:setOnLongClickListener	(Landroid/view/View$OnLongClickListener;)V
    //   4081: return
    //   4082: iload 7
    //   4084: sipush -2052
    //   4087: if_icmpeq +1062 -> 5149
    //   4090: iload 7
    //   4092: sipush -2057
    //   4095: if_icmpeq +1054 -> 5149
    //   4098: iload 7
    //   4100: sipush -2059
    //   4103: if_icmpne +6 -> 4109
    //   4106: goto +1043 -> 5149
    //   4109: iload 7
    //   4111: sipush -2071
    //   4114: if_icmpne +49 -> 4163
    //   4117: aload 17
    //   4119: iconst_0
    //   4120: invokevirtual 172	android/widget/TextView:setVisibility	(I)V
    //   4123: aload 17
    //   4125: aload_0
    //   4126: getfield 18	com/tencent/mobileqq/activity/ChatHistory$ChatHistoryAdapter:f	Lcom/tencent/mobileqq/activity/ChatHistory;
    //   4129: ldc_w 1255
    //   4132: invokevirtual 228	com/tencent/mobileqq/activity/ChatHistory:getString	(I)Ljava/lang/String;
    //   4135: invokevirtual 222	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   4138: aload 17
    //   4140: aload_0
    //   4141: getfield 18	com/tencent/mobileqq/activity/ChatHistory$ChatHistoryAdapter:f	Lcom/tencent/mobileqq/activity/ChatHistory;
    //   4144: getfield 181	com/tencent/mobileqq/activity/ChatHistory:X	Lcom/tencent/mobileqq/activity/ChatHistory$HistoryItemOnlongClickListener;
    //   4147: invokevirtual 185	android/widget/TextView:setOnTouchListener	(Landroid/view/View$OnTouchListener;)V
    //   4150: aload 17
    //   4152: aload_0
    //   4153: getfield 18	com/tencent/mobileqq/activity/ChatHistory$ChatHistoryAdapter:f	Lcom/tencent/mobileqq/activity/ChatHistory;
    //   4156: getfield 181	com/tencent/mobileqq/activity/ChatHistory:X	Lcom/tencent/mobileqq/activity/ChatHistory$HistoryItemOnlongClickListener;
    //   4159: invokevirtual 189	android/widget/TextView:setOnLongClickListener	(Landroid/view/View$OnLongClickListener;)V
    //   4162: return
    //   4163: aload 14
    //   4165: ifnull +764 -> 4929
    //   4168: aload 14
    //   4170: invokevirtual 1258	java/lang/String:length	()I
    //   4173: ifle +756 -> 4929
    //   4176: aload_0
    //   4177: getfield 18	com/tencent/mobileqq/activity/ChatHistory$ChatHistoryAdapter:f	Lcom/tencent/mobileqq/activity/ChatHistory;
    //   4180: aload 14
    //   4182: invokevirtual 1259	java/lang/String:toString	()Ljava/lang/String;
    //   4185: invokevirtual 1261	com/tencent/mobileqq/activity/ChatHistory:c	(Ljava/lang/String;)Z
    //   4188: ifeq +741 -> 4929
    //   4191: aload 14
    //   4193: ldc_w 1263
    //   4196: invokevirtual 1267	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   4199: iconst_1
    //   4200: aaload
    //   4201: ldc_w 1269
    //   4204: invokevirtual 1267	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   4207: astore_2
    //   4208: aload_2
    //   4209: iconst_0
    //   4210: aaload
    //   4211: astore_3
    //   4212: aload_2
    //   4213: arraylength
    //   4214: iconst_2
    //   4215: if_icmpge +9 -> 4224
    //   4218: iconst_1
    //   4219: istore 4
    //   4221: goto +14 -> 4235
    //   4224: aload_2
    //   4225: iconst_2
    //   4226: aaload
    //   4227: invokestatic 1274	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   4230: invokevirtual 1277	java/lang/Integer:intValue	()I
    //   4233: istore 4
    //   4235: aload_2
    //   4236: arraylength
    //   4237: iconst_5
    //   4238: if_icmplt +8 -> 4246
    //   4241: aload_2
    //   4242: iconst_4
    //   4243: aaload
    //   4244: astore 16
    //   4246: aload_2
    //   4247: arraylength
    //   4248: bipush 6
    //   4250: if_icmplt +12 -> 4262
    //   4253: aload 14
    //   4255: invokevirtual 1259	java/lang/String:toString	()Ljava/lang/String;
    //   4258: invokestatic 1282	com/tencent/mobileqq/transfile/TransfileUtile:getPicMD5ByMsgContent	(Ljava/lang/String;)Ljava/lang/String;
    //   4261: pop
    //   4262: aload_2
    //   4263: ifnull +35 -> 4298
    //   4266: aload_2
    //   4267: arraylength
    //   4268: iconst_1
    //   4269: if_icmple +29 -> 4298
    //   4272: aload_2
    //   4273: iconst_1
    //   4274: aaload
    //   4275: ifnonnull +10 -> 4285
    //   4278: ldc_w 1284
    //   4281: astore_2
    //   4282: goto +7 -> 4289
    //   4285: aload_2
    //   4286: iconst_1
    //   4287: aaload
    //   4288: astore_2
    //   4289: aload_2
    //   4290: invokestatic 1290	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   4293: lstore 8
    //   4295: goto +6 -> 4301
    //   4298: lconst_0
    //   4299: lstore 8
    //   4301: aload_3
    //   4302: invokestatic 1295	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   4305: pop
    //   4306: iload 4
    //   4308: ifeq +575 -> 4883
    //   4311: iload 4
    //   4313: iconst_1
    //   4314: if_icmpeq +544 -> 4858
    //   4317: iload 4
    //   4319: iconst_2
    //   4320: if_icmpeq +57 -> 4377
    //   4323: iload 4
    //   4325: ldc_w 1296
    //   4328: if_icmpeq +4 -> 4332
    //   4331: return
    //   4332: aload 23
    //   4334: iconst_0
    //   4335: invokevirtual 360	com/tencent/mobileqq/activity/aio/item/ChatThumbView:setVisibility	(I)V
    //   4338: aload 23
    //   4340: aconst_null
    //   4341: invokevirtual 671	com/tencent/mobileqq/activity/aio/item/ChatThumbView:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   4344: aload 23
    //   4346: aload_0
    //   4347: getfield 18	com/tencent/mobileqq/activity/ChatHistory$ChatHistoryAdapter:f	Lcom/tencent/mobileqq/activity/ChatHistory;
    //   4350: getfield 181	com/tencent/mobileqq/activity/ChatHistory:X	Lcom/tencent/mobileqq/activity/ChatHistory$HistoryItemOnlongClickListener;
    //   4353: invokevirtual 277	com/tencent/mobileqq/activity/aio/item/ChatThumbView:setOnTouchListener	(Landroid/view/View$OnTouchListener;)V
    //   4356: aload 23
    //   4358: aload_0
    //   4359: getfield 18	com/tencent/mobileqq/activity/ChatHistory$ChatHistoryAdapter:f	Lcom/tencent/mobileqq/activity/ChatHistory;
    //   4362: getfield 181	com/tencent/mobileqq/activity/ChatHistory:X	Lcom/tencent/mobileqq/activity/ChatHistory$HistoryItemOnlongClickListener;
    //   4365: invokevirtual 278	com/tencent/mobileqq/activity/aio/item/ChatThumbView:setOnLongClickListener	(Landroid/view/View$OnLongClickListener;)V
    //   4368: aload 23
    //   4370: ldc_w 1297
    //   4373: invokevirtual 1298	com/tencent/mobileqq/activity/aio/item/ChatThumbView:setImageResource	(I)V
    //   4376: return
    //   4377: aload_0
    //   4378: getfield 18	com/tencent/mobileqq/activity/ChatHistory$ChatHistoryAdapter:f	Lcom/tencent/mobileqq/activity/ChatHistory;
    //   4381: getfield 57	com/tencent/mobileqq/activity/ChatHistory:z	I
    //   4384: istore 6
    //   4386: aload_0
    //   4387: getfield 18	com/tencent/mobileqq/activity/ChatHistory$ChatHistoryAdapter:f	Lcom/tencent/mobileqq/activity/ChatHistory;
    //   4390: getfield 61	com/tencent/mobileqq/activity/ChatHistory:A	I
    //   4393: istore 4
    //   4395: new 292	java/lang/StringBuilder
    //   4398: dup
    //   4399: invokespecial 293	java/lang/StringBuilder:<init>	()V
    //   4402: astore_2
    //   4403: aload_2
    //   4404: aload_3
    //   4405: invokevirtual 299	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4408: pop
    //   4409: aload_2
    //   4410: aload 13
    //   4412: invokevirtual 299	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4415: pop
    //   4416: aload_2
    //   4417: lload 10
    //   4419: invokevirtual 328	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4422: pop
    //   4423: aload 19
    //   4425: aload_2
    //   4426: invokevirtual 313	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4429: invokevirtual 1077	android/widget/Button:setTag	(Ljava/lang/Object;)V
    //   4432: aload 19
    //   4434: iconst_0
    //   4435: invokevirtual 974	android/widget/Button:setVisibility	(I)V
    //   4438: aload 19
    //   4440: ldc_w 520
    //   4443: invokevirtual 1078	android/widget/Button:setText	(Ljava/lang/CharSequence;)V
    //   4446: aload 19
    //   4448: aconst_null
    //   4449: invokevirtual 1078	android/widget/Button:setText	(Ljava/lang/CharSequence;)V
    //   4452: aload 19
    //   4454: aconst_null
    //   4455: aconst_null
    //   4456: aconst_null
    //   4457: aconst_null
    //   4458: invokevirtual 1082	android/widget/Button:setCompoundDrawables	(Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;)V
    //   4461: aload 19
    //   4463: iload 6
    //   4465: iconst_0
    //   4466: iload 4
    //   4468: iconst_0
    //   4469: invokevirtual 1086	android/widget/Button:setPadding	(IIII)V
    //   4472: aload 19
    //   4474: aload_0
    //   4475: getfield 18	com/tencent/mobileqq/activity/ChatHistory$ChatHistoryAdapter:f	Lcom/tencent/mobileqq/activity/ChatHistory;
    //   4478: getfield 181	com/tencent/mobileqq/activity/ChatHistory:X	Lcom/tencent/mobileqq/activity/ChatHistory$HistoryItemOnlongClickListener;
    //   4481: invokevirtual 1087	android/widget/Button:setOnTouchListener	(Landroid/view/View$OnTouchListener;)V
    //   4484: aload 19
    //   4486: aload_0
    //   4487: getfield 18	com/tencent/mobileqq/activity/ChatHistory$ChatHistoryAdapter:f	Lcom/tencent/mobileqq/activity/ChatHistory;
    //   4490: getfield 181	com/tencent/mobileqq/activity/ChatHistory:X	Lcom/tencent/mobileqq/activity/ChatHistory$HistoryItemOnlongClickListener;
    //   4493: invokevirtual 1088	android/widget/Button:setOnLongClickListener	(Landroid/view/View$OnLongClickListener;)V
    //   4496: aload 15
    //   4498: ifnull +46 -> 4544
    //   4501: aload 15
    //   4503: getfield 233	com/tencent/mobileqq/activity/ChatHistory$Holder:a	Lcom/tencent/mobileqq/data/MessageRecord;
    //   4506: ifnull +38 -> 4544
    //   4509: aload 15
    //   4511: getfield 233	com/tencent/mobileqq/activity/ChatHistory$Holder:a	Lcom/tencent/mobileqq/data/MessageRecord;
    //   4514: instanceof 1042
    //   4517: ifeq +27 -> 4544
    //   4520: ldc_w 1048
    //   4523: invokestatic 263	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   4526: checkcast 1048	com/tencent/mobileqq/ptt/temp/api/IQQRecorderTempApi
    //   4529: aload 15
    //   4531: getfield 233	com/tencent/mobileqq/activity/ChatHistory$Holder:a	Lcom/tencent/mobileqq/data/MessageRecord;
    //   4534: invokeinterface 1052 2 0
    //   4539: istore 4
    //   4541: goto +6 -> 4547
    //   4544: iconst_0
    //   4545: istore 4
    //   4547: iload 4
    //   4549: istore 5
    //   4551: iload 4
    //   4553: ifgt +20 -> 4573
    //   4556: ldc_w 1090
    //   4559: invokestatic 263	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   4562: checkcast 1090	com/tencent/mobileqq/ptt/IQQRecorderUtils
    //   4565: aload_3
    //   4566: invokeinterface 1092 2 0
    //   4571: istore 5
    //   4573: aload_3
    //   4574: getstatic 1301	com/tencent/mobileqq/app/AppConstants:SDCARD_PATH	Ljava/lang/String;
    //   4577: invokevirtual 1098	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   4580: ifeq +214 -> 4794
    //   4583: iload 5
    //   4585: ifgt +6 -> 4591
    //   4588: goto +206 -> 4794
    //   4591: new 292	java/lang/StringBuilder
    //   4594: dup
    //   4595: invokespecial 293	java/lang/StringBuilder:<init>	()V
    //   4598: astore_2
    //   4599: aload_2
    //   4600: iload 5
    //   4602: invokestatic 1100	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   4605: invokevirtual 299	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4608: pop
    //   4609: aload_2
    //   4610: ldc_w 1102
    //   4613: invokevirtual 299	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4616: pop
    //   4617: aload 19
    //   4619: aload_2
    //   4620: invokevirtual 313	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4623: invokevirtual 1078	android/widget/Button:setText	(Ljava/lang/CharSequence;)V
    //   4626: aload 19
    //   4628: iload 6
    //   4630: iconst_0
    //   4631: aload_0
    //   4632: iload 5
    //   4634: invokevirtual 1104	com/tencent/mobileqq/activity/ChatHistory$ChatHistoryAdapter:a	(I)I
    //   4637: iconst_0
    //   4638: invokevirtual 1086	android/widget/Button:setPadding	(IIII)V
    //   4641: aload_0
    //   4642: getfield 18	com/tencent/mobileqq/activity/ChatHistory$ChatHistoryAdapter:f	Lcom/tencent/mobileqq/activity/ChatHistory;
    //   4645: getfield 421	com/tencent/mobileqq/activity/ChatHistory:al	Lcom/tencent/mobileqq/activity/ChatHistory$PlayingPttHistoryInfo;
    //   4648: ifnull +37 -> 4685
    //   4651: aload_0
    //   4652: getfield 18	com/tencent/mobileqq/activity/ChatHistory$ChatHistoryAdapter:f	Lcom/tencent/mobileqq/activity/ChatHistory;
    //   4655: getfield 421	com/tencent/mobileqq/activity/ChatHistory:al	Lcom/tencent/mobileqq/activity/ChatHistory$PlayingPttHistoryInfo;
    //   4658: iconst_0
    //   4659: aload 19
    //   4661: invokevirtual 1105	android/widget/Button:getTag	()Ljava/lang/Object;
    //   4664: invokevirtual 430	com/tencent/mobileqq/activity/ChatHistory$PlayingPttHistoryInfo:a	(ILjava/lang/Object;)Z
    //   4667: ifeq +18 -> 4685
    //   4670: aload_0
    //   4671: getfield 18	com/tencent/mobileqq/activity/ChatHistory$ChatHistoryAdapter:f	Lcom/tencent/mobileqq/activity/ChatHistory;
    //   4674: getfield 421	com/tencent/mobileqq/activity/ChatHistory:al	Lcom/tencent/mobileqq/activity/ChatHistory$PlayingPttHistoryInfo;
    //   4677: aload_1
    //   4678: aload_3
    //   4679: invokevirtual 458	com/tencent/mobileqq/activity/ChatHistory$PlayingPttHistoryInfo:a	(Landroid/view/View;Ljava/lang/String;)V
    //   4682: goto +95 -> 4777
    //   4685: aload_0
    //   4686: getfield 39	com/tencent/mobileqq/activity/ChatHistory$ChatHistoryAdapter:c	Landroid/content/Context;
    //   4689: invokevirtual 66	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   4692: ldc_w 1111
    //   4695: invokevirtual 1110	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   4698: astore_1
    //   4699: aload_1
    //   4700: iconst_0
    //   4701: iconst_0
    //   4702: aload_1
    //   4703: invokevirtual 1116	android/graphics/drawable/Drawable:getMinimumWidth	()I
    //   4706: aload_1
    //   4707: invokevirtual 1119	android/graphics/drawable/Drawable:getMinimumHeight	()I
    //   4710: invokevirtual 1122	android/graphics/drawable/Drawable:setBounds	(IIII)V
    //   4713: aload 19
    //   4715: aload_1
    //   4716: aconst_null
    //   4717: aconst_null
    //   4718: aconst_null
    //   4719: invokevirtual 1082	android/widget/Button:setCompoundDrawables	(Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;)V
    //   4722: lload 8
    //   4724: lconst_0
    //   4725: lcmp
    //   4726: ifgt +51 -> 4777
    //   4729: new 292	java/lang/StringBuilder
    //   4732: dup
    //   4733: invokespecial 293	java/lang/StringBuilder:<init>	()V
    //   4736: astore_1
    //   4737: aload_1
    //   4738: ldc_w 1124
    //   4741: invokevirtual 299	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4744: pop
    //   4745: aload_1
    //   4746: aload_0
    //   4747: getfield 18	com/tencent/mobileqq/activity/ChatHistory$ChatHistoryAdapter:f	Lcom/tencent/mobileqq/activity/ChatHistory;
    //   4750: ldc_w 1125
    //   4753: invokevirtual 228	com/tencent/mobileqq/activity/ChatHistory:getString	(I)Ljava/lang/String;
    //   4756: invokevirtual 299	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4759: pop
    //   4760: aload_1
    //   4761: ldc_w 1127
    //   4764: invokevirtual 299	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4767: pop
    //   4768: aload 19
    //   4770: aload_1
    //   4771: invokevirtual 313	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4774: invokevirtual 1078	android/widget/Button:setText	(Ljava/lang/CharSequence;)V
    //   4777: aload 19
    //   4779: new 1303	com/tencent/mobileqq/activity/ChatHistory$ChatHistoryAdapter$5
    //   4782: dup
    //   4783: aload_0
    //   4784: iload 5
    //   4786: aload_3
    //   4787: invokespecial 1304	com/tencent/mobileqq/activity/ChatHistory$ChatHistoryAdapter$5:<init>	(Lcom/tencent/mobileqq/activity/ChatHistory$ChatHistoryAdapter;ILjava/lang/String;)V
    //   4790: invokevirtual 977	android/widget/Button:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   4793: return
    //   4794: aload 19
    //   4796: aconst_null
    //   4797: aconst_null
    //   4798: aconst_null
    //   4799: aconst_null
    //   4800: invokevirtual 1082	android/widget/Button:setCompoundDrawables	(Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;)V
    //   4803: new 292	java/lang/StringBuilder
    //   4806: dup
    //   4807: invokespecial 293	java/lang/StringBuilder:<init>	()V
    //   4810: astore_1
    //   4811: aload_1
    //   4812: ldc_w 1124
    //   4815: invokevirtual 299	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4818: pop
    //   4819: aload_1
    //   4820: aload_0
    //   4821: getfield 18	com/tencent/mobileqq/activity/ChatHistory$ChatHistoryAdapter:f	Lcom/tencent/mobileqq/activity/ChatHistory;
    //   4824: ldc_w 1133
    //   4827: invokevirtual 228	com/tencent/mobileqq/activity/ChatHistory:getString	(I)Ljava/lang/String;
    //   4830: invokevirtual 299	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4833: pop
    //   4834: aload_1
    //   4835: ldc_w 1127
    //   4838: invokevirtual 299	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4841: pop
    //   4842: aload 19
    //   4844: aload_1
    //   4845: invokevirtual 313	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4848: invokevirtual 1078	android/widget/Button:setText	(Ljava/lang/CharSequence;)V
    //   4851: aload 19
    //   4853: aconst_null
    //   4854: invokevirtual 977	android/widget/Button:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   4857: return
    //   4858: aload 23
    //   4860: aload_0
    //   4861: getfield 18	com/tencent/mobileqq/activity/ChatHistory$ChatHistoryAdapter:f	Lcom/tencent/mobileqq/activity/ChatHistory;
    //   4864: getfield 181	com/tencent/mobileqq/activity/ChatHistory:X	Lcom/tencent/mobileqq/activity/ChatHistory$HistoryItemOnlongClickListener;
    //   4867: invokevirtual 277	com/tencent/mobileqq/activity/aio/item/ChatThumbView:setOnTouchListener	(Landroid/view/View$OnTouchListener;)V
    //   4870: aload 23
    //   4872: aload_0
    //   4873: getfield 18	com/tencent/mobileqq/activity/ChatHistory$ChatHistoryAdapter:f	Lcom/tencent/mobileqq/activity/ChatHistory;
    //   4876: getfield 181	com/tencent/mobileqq/activity/ChatHistory:X	Lcom/tencent/mobileqq/activity/ChatHistory$HistoryItemOnlongClickListener;
    //   4879: invokevirtual 278	com/tencent/mobileqq/activity/aio/item/ChatThumbView:setOnLongClickListener	(Landroid/view/View$OnLongClickListener;)V
    //   4882: return
    //   4883: aload 17
    //   4885: aload_0
    //   4886: getfield 18	com/tencent/mobileqq/activity/ChatHistory$ChatHistoryAdapter:f	Lcom/tencent/mobileqq/activity/ChatHistory;
    //   4889: ldc_w 1305
    //   4892: invokevirtual 228	com/tencent/mobileqq/activity/ChatHistory:getString	(I)Ljava/lang/String;
    //   4895: invokevirtual 222	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   4898: aload 17
    //   4900: iconst_0
    //   4901: invokevirtual 172	android/widget/TextView:setVisibility	(I)V
    //   4904: aload 17
    //   4906: aload_0
    //   4907: getfield 18	com/tencent/mobileqq/activity/ChatHistory$ChatHistoryAdapter:f	Lcom/tencent/mobileqq/activity/ChatHistory;
    //   4910: getfield 181	com/tencent/mobileqq/activity/ChatHistory:X	Lcom/tencent/mobileqq/activity/ChatHistory$HistoryItemOnlongClickListener;
    //   4913: invokevirtual 185	android/widget/TextView:setOnTouchListener	(Landroid/view/View$OnTouchListener;)V
    //   4916: aload 17
    //   4918: aload_0
    //   4919: getfield 18	com/tencent/mobileqq/activity/ChatHistory$ChatHistoryAdapter:f	Lcom/tencent/mobileqq/activity/ChatHistory;
    //   4922: getfield 181	com/tencent/mobileqq/activity/ChatHistory:X	Lcom/tencent/mobileqq/activity/ChatHistory$HistoryItemOnlongClickListener;
    //   4925: invokevirtual 189	android/widget/TextView:setOnLongClickListener	(Landroid/view/View$OnLongClickListener;)V
    //   4928: return
    //   4929: aload_3
    //   4930: aload_3
    //   4931: ldc 164
    //   4933: invokeinterface 134 2 0
    //   4938: invokeinterface 166 2 0
    //   4943: istore 4
    //   4945: aload 17
    //   4947: iconst_0
    //   4948: invokevirtual 172	android/widget/TextView:setVisibility	(I)V
    //   4951: iload 7
    //   4953: invokestatic 177	com/tencent/mobileqq/service/message/MessageUtils:b	(I)Z
    //   4956: ifne +27 -> 4983
    //   4959: aload 17
    //   4961: aload_0
    //   4962: getfield 18	com/tencent/mobileqq/activity/ChatHistory$ChatHistoryAdapter:f	Lcom/tencent/mobileqq/activity/ChatHistory;
    //   4965: getfield 181	com/tencent/mobileqq/activity/ChatHistory:X	Lcom/tencent/mobileqq/activity/ChatHistory$HistoryItemOnlongClickListener;
    //   4968: invokevirtual 185	android/widget/TextView:setOnTouchListener	(Landroid/view/View$OnTouchListener;)V
    //   4971: aload 17
    //   4973: aload_0
    //   4974: getfield 18	com/tencent/mobileqq/activity/ChatHistory$ChatHistoryAdapter:f	Lcom/tencent/mobileqq/activity/ChatHistory;
    //   4977: getfield 181	com/tencent/mobileqq/activity/ChatHistory:X	Lcom/tencent/mobileqq/activity/ChatHistory$HistoryItemOnlongClickListener;
    //   4980: invokevirtual 189	android/widget/TextView:setOnLongClickListener	(Landroid/view/View$OnLongClickListener;)V
    //   4983: getstatic 195	com/tencent/mobileqq/app/AppConstants:SYSTEM_MSG_UIN	Ljava/lang/String;
    //   4986: invokestatic 201	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   4989: aload 13
    //   4991: invokevirtual 205	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4994: ifeq +50 -> 5044
    //   4997: aload_0
    //   4998: getfield 18	com/tencent/mobileqq/activity/ChatHistory$ChatHistoryAdapter:f	Lcom/tencent/mobileqq/activity/ChatHistory;
    //   5001: getfield 209	com/tencent/mobileqq/activity/ChatHistory:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   5004: aload 14
    //   5006: aload 24
    //   5008: iload 4
    //   5010: invokestatic 215	com/tencent/mobileqq/data/SystemMsg:decode	(Lcom/tencent/common/app/AppInterface;Ljava/lang/String;Ljava/lang/String;I)Lcom/tencent/mobileqq/data/SystemMsg;
    //   5013: astore_1
    //   5014: aload_1
    //   5015: ifnull +133 -> 5148
    //   5018: aload 17
    //   5020: aload_1
    //   5021: getfield 218	com/tencent/mobileqq/data/SystemMsg:message	Ljava/lang/String;
    //   5024: invokevirtual 222	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   5027: iload 6
    //   5029: ldc 223
    //   5031: if_icmpne +117 -> 5148
    //   5034: aload 18
    //   5036: aload_1
    //   5037: getfield 226	com/tencent/mobileqq/data/SystemMsg:troopCode	Ljava/lang/String;
    //   5040: invokevirtual 222	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   5043: return
    //   5044: sipush -2008
    //   5047: iload 4
    //   5049: if_icmpne +18 -> 5067
    //   5052: aload 17
    //   5054: aload_0
    //   5055: getfield 18	com/tencent/mobileqq/activity/ChatHistory$ChatHistoryAdapter:f	Lcom/tencent/mobileqq/activity/ChatHistory;
    //   5058: ldc 227
    //   5060: invokevirtual 228	com/tencent/mobileqq/activity/ChatHistory:getString	(I)Ljava/lang/String;
    //   5063: invokevirtual 222	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   5066: return
    //   5067: sipush -1002
    //   5070: iload 4
    //   5072: if_icmpne +19 -> 5091
    //   5075: aload 17
    //   5077: aload 15
    //   5079: getfield 233	com/tencent/mobileqq/activity/ChatHistory$Holder:a	Lcom/tencent/mobileqq/data/MessageRecord;
    //   5082: ldc 235
    //   5084: invokevirtual 240	com/tencent/mobileqq/data/MessageRecord:getExtInfoFromExtStr	(Ljava/lang/String;)Ljava/lang/String;
    //   5087: invokevirtual 222	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   5090: return
    //   5091: aload_3
    //   5092: aload_3
    //   5093: ldc 242
    //   5095: invokeinterface 134 2 0
    //   5100: invokeinterface 166 2 0
    //   5105: istore 4
    //   5107: aload 16
    //   5109: ifnull +16 -> 5125
    //   5112: iload 4
    //   5114: ldc 243
    //   5116: if_icmpne +9 -> 5125
    //   5119: aload 16
    //   5121: iconst_0
    //   5122: invokevirtual 246	android/widget/ImageView:setVisibility	(I)V
    //   5125: aload 17
    //   5127: new 248	com/tencent/mobileqq/text/QQText
    //   5130: dup
    //   5131: aload 14
    //   5133: bipush 13
    //   5135: bipush 32
    //   5137: aload 15
    //   5139: getfield 233	com/tencent/mobileqq/activity/ChatHistory$Holder:a	Lcom/tencent/mobileqq/data/MessageRecord;
    //   5142: invokespecial 1308	com/tencent/mobileqq/text/QQText:<init>	(Ljava/lang/CharSequence;IILjava/lang/Object;)V
    //   5145: invokevirtual 222	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   5148: return
    //   5149: aload 17
    //   5151: iconst_0
    //   5152: invokevirtual 172	android/widget/TextView:setVisibility	(I)V
    //   5155: aload 17
    //   5157: aload 15
    //   5159: getfield 233	com/tencent/mobileqq/activity/ChatHistory$Holder:a	Lcom/tencent/mobileqq/data/MessageRecord;
    //   5162: checkcast 1310	com/tencent/mobileqq/data/ChatMessage
    //   5165: invokevirtual 1311	com/tencent/mobileqq/data/ChatMessage:getSummaryMsg	()Ljava/lang/String;
    //   5168: invokevirtual 222	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   5171: aload 17
    //   5173: aload_0
    //   5174: getfield 18	com/tencent/mobileqq/activity/ChatHistory$ChatHistoryAdapter:f	Lcom/tencent/mobileqq/activity/ChatHistory;
    //   5177: getfield 181	com/tencent/mobileqq/activity/ChatHistory:X	Lcom/tencent/mobileqq/activity/ChatHistory$HistoryItemOnlongClickListener;
    //   5180: invokevirtual 185	android/widget/TextView:setOnTouchListener	(Landroid/view/View$OnTouchListener;)V
    //   5183: aload 17
    //   5185: aload_0
    //   5186: getfield 18	com/tencent/mobileqq/activity/ChatHistory$ChatHistoryAdapter:f	Lcom/tencent/mobileqq/activity/ChatHistory;
    //   5189: getfield 181	com/tencent/mobileqq/activity/ChatHistory:X	Lcom/tencent/mobileqq/activity/ChatHistory$HistoryItemOnlongClickListener;
    //   5192: invokevirtual 189	android/widget/TextView:setOnLongClickListener	(Landroid/view/View$OnLongClickListener;)V
    //   5195: return
    //   5196: aload 15
    //   5198: getfield 233	com/tencent/mobileqq/activity/ChatHistory$Holder:a	Lcom/tencent/mobileqq/data/MessageRecord;
    //   5201: ifnull +220 -> 5421
    //   5204: aload 15
    //   5206: getfield 233	com/tencent/mobileqq/activity/ChatHistory$Holder:a	Lcom/tencent/mobileqq/data/MessageRecord;
    //   5209: instanceof 255
    //   5212: ifeq +209 -> 5421
    //   5215: ldc_w 257
    //   5218: invokestatic 263	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   5221: checkcast 257	com/tencent/mobileqq/pic/api/IPicFlash
    //   5224: aload 15
    //   5226: getfield 233	com/tencent/mobileqq/activity/ChatHistory$Holder:a	Lcom/tencent/mobileqq/data/MessageRecord;
    //   5229: invokeinterface 267 2 0
    //   5234: ifeq +49 -> 5283
    //   5237: aload 17
    //   5239: iconst_0
    //   5240: invokevirtual 172	android/widget/TextView:setVisibility	(I)V
    //   5243: aload 17
    //   5245: aload_0
    //   5246: getfield 18	com/tencent/mobileqq/activity/ChatHistory$ChatHistoryAdapter:f	Lcom/tencent/mobileqq/activity/ChatHistory;
    //   5249: ldc_w 268
    //   5252: invokevirtual 228	com/tencent/mobileqq/activity/ChatHistory:getString	(I)Ljava/lang/String;
    //   5255: invokevirtual 222	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   5258: aload 17
    //   5260: aload_0
    //   5261: getfield 18	com/tencent/mobileqq/activity/ChatHistory$ChatHistoryAdapter:f	Lcom/tencent/mobileqq/activity/ChatHistory;
    //   5264: getfield 181	com/tencent/mobileqq/activity/ChatHistory:X	Lcom/tencent/mobileqq/activity/ChatHistory$HistoryItemOnlongClickListener;
    //   5267: invokevirtual 185	android/widget/TextView:setOnTouchListener	(Landroid/view/View$OnTouchListener;)V
    //   5270: aload 17
    //   5272: aload_0
    //   5273: getfield 18	com/tencent/mobileqq/activity/ChatHistory$ChatHistoryAdapter:f	Lcom/tencent/mobileqq/activity/ChatHistory;
    //   5276: getfield 181	com/tencent/mobileqq/activity/ChatHistory:X	Lcom/tencent/mobileqq/activity/ChatHistory$HistoryItemOnlongClickListener;
    //   5279: invokevirtual 189	android/widget/TextView:setOnLongClickListener	(Landroid/view/View$OnLongClickListener;)V
    //   5282: return
    //   5283: aload 15
    //   5285: getfield 233	com/tencent/mobileqq/activity/ChatHistory$Holder:a	Lcom/tencent/mobileqq/data/MessageRecord;
    //   5288: checkcast 255	com/tencent/mobileqq/data/MessageForPic
    //   5291: astore_1
    //   5292: aload_1
    //   5293: invokevirtual 271	com/tencent/mobileqq/data/MessageForPic:parse	()V
    //   5296: new 273	com/tencent/mobileqq/activity/ImageViewParameter
    //   5299: dup
    //   5300: invokespecial 274	com/tencent/mobileqq/activity/ImageViewParameter:<init>	()V
    //   5303: astore_2
    //   5304: aload 23
    //   5306: aload_0
    //   5307: getfield 18	com/tencent/mobileqq/activity/ChatHistory$ChatHistoryAdapter:f	Lcom/tencent/mobileqq/activity/ChatHistory;
    //   5310: getfield 181	com/tencent/mobileqq/activity/ChatHistory:X	Lcom/tencent/mobileqq/activity/ChatHistory$HistoryItemOnlongClickListener;
    //   5313: invokevirtual 277	com/tencent/mobileqq/activity/aio/item/ChatThumbView:setOnTouchListener	(Landroid/view/View$OnTouchListener;)V
    //   5316: aload 23
    //   5318: aload_0
    //   5319: getfield 18	com/tencent/mobileqq/activity/ChatHistory$ChatHistoryAdapter:f	Lcom/tencent/mobileqq/activity/ChatHistory;
    //   5322: getfield 181	com/tencent/mobileqq/activity/ChatHistory:X	Lcom/tencent/mobileqq/activity/ChatHistory$HistoryItemOnlongClickListener;
    //   5325: invokevirtual 278	com/tencent/mobileqq/activity/aio/item/ChatThumbView:setOnLongClickListener	(Landroid/view/View$OnLongClickListener;)V
    //   5328: aload_2
    //   5329: aload_1
    //   5330: putfield 281	com/tencent/mobileqq/activity/ImageViewParameter:b	Lcom/tencent/mobileqq/data/MessageForPic;
    //   5333: aload_2
    //   5334: aload 23
    //   5336: putfield 284	com/tencent/mobileqq/activity/ImageViewParameter:a	Lcom/tencent/image/URLImageView;
    //   5339: invokestatic 290	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5342: ifeq +56 -> 5398
    //   5345: new 292	java/lang/StringBuilder
    //   5348: dup
    //   5349: invokespecial 293	java/lang/StringBuilder:<init>	()V
    //   5352: astore_3
    //   5353: aload_3
    //   5354: ldc_w 295
    //   5357: invokevirtual 299	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5360: pop
    //   5361: aload_3
    //   5362: aload_1
    //   5363: getfield 302	com/tencent/mobileqq/data/MessageForPic:path	Ljava/lang/String;
    //   5366: invokevirtual 299	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5369: pop
    //   5370: aload_3
    //   5371: ldc_w 304
    //   5374: invokevirtual 299	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5377: pop
    //   5378: aload_3
    //   5379: aload_1
    //   5380: getfield 307	com/tencent/mobileqq/data/MessageForPic:uuid	Ljava/lang/String;
    //   5383: invokevirtual 299	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5386: pop
    //   5387: ldc_w 309
    //   5390: iconst_2
    //   5391: aload_3
    //   5392: invokevirtual 313	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5395: invokestatic 316	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   5398: aload_2
    //   5399: getfield 281	com/tencent/mobileqq/activity/ImageViewParameter:b	Lcom/tencent/mobileqq/data/MessageForPic;
    //   5402: ifnull +128 -> 5530
    //   5405: aload_2
    //   5406: getfield 281	com/tencent/mobileqq/activity/ImageViewParameter:b	Lcom/tencent/mobileqq/data/MessageForPic;
    //   5409: getfield 302	com/tencent/mobileqq/data/MessageForPic:path	Ljava/lang/String;
    //   5412: ifnull +118 -> 5530
    //   5415: aload_0
    //   5416: aload_2
    //   5417: invokevirtual 319	com/tencent/mobileqq/activity/ChatHistory$ChatHistoryAdapter:a	(Lcom/tencent/mobileqq/activity/ImageViewParameter;)V
    //   5420: return
    //   5421: invokestatic 290	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5424: ifeq +106 -> 5530
    //   5427: new 292	java/lang/StringBuilder
    //   5430: dup
    //   5431: invokespecial 293	java/lang/StringBuilder:<init>	()V
    //   5434: astore_1
    //   5435: aload_1
    //   5436: ldc_w 321
    //   5439: invokevirtual 299	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5442: pop
    //   5443: aload_1
    //   5444: aload 15
    //   5446: getfield 233	com/tencent/mobileqq/activity/ChatHistory$Holder:a	Lcom/tencent/mobileqq/data/MessageRecord;
    //   5449: getfield 325	com/tencent/mobileqq/data/MessageRecord:uniseq	J
    //   5452: invokevirtual 328	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5455: pop
    //   5456: aload_1
    //   5457: ldc_w 330
    //   5460: invokevirtual 299	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5463: pop
    //   5464: aload_1
    //   5465: aload 15
    //   5467: getfield 233	com/tencent/mobileqq/activity/ChatHistory$Holder:a	Lcom/tencent/mobileqq/data/MessageRecord;
    //   5470: invokevirtual 334	com/tencent/mobileqq/data/MessageRecord:getId	()J
    //   5473: invokevirtual 328	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5476: pop
    //   5477: aload_1
    //   5478: ldc_w 336
    //   5481: invokevirtual 299	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5484: pop
    //   5485: aload_1
    //   5486: aload 15
    //   5488: getfield 233	com/tencent/mobileqq/activity/ChatHistory$Holder:a	Lcom/tencent/mobileqq/data/MessageRecord;
    //   5491: getfield 339	com/tencent/mobileqq/data/MessageRecord:istroop	I
    //   5494: invokevirtual 342	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5497: pop
    //   5498: aload_1
    //   5499: ldc_w 344
    //   5502: invokevirtual 299	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5505: pop
    //   5506: aload_1
    //   5507: aload 15
    //   5509: getfield 233	com/tencent/mobileqq/activity/ChatHistory$Holder:a	Lcom/tencent/mobileqq/data/MessageRecord;
    //   5512: getfield 346	com/tencent/mobileqq/data/MessageRecord:msgtype	I
    //   5515: invokevirtual 342	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5518: pop
    //   5519: ldc_w 309
    //   5522: iconst_2
    //   5523: aload_1
    //   5524: invokevirtual 313	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5527: invokestatic 316	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   5530: return
    //   5531: aload_3
    //   5532: aload_3
    //   5533: ldc_w 348
    //   5536: invokeinterface 134 2 0
    //   5541: invokeinterface 352 2 0
    //   5546: invokestatic 1316	com/tencent/mobileqq/structmsg/StructMsgFactory:a	([B)Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   5549: astore_3
    //   5550: aload_0
    //   5551: getfield 18	com/tencent/mobileqq/activity/ChatHistory$ChatHistoryAdapter:f	Lcom/tencent/mobileqq/activity/ChatHistory;
    //   5554: aload_3
    //   5555: invokevirtual 1319	com/tencent/mobileqq/activity/ChatHistory:a	(Lcom/tencent/mobileqq/structmsg/AbsStructMsg;)Ljava/lang/String;
    //   5558: astore_1
    //   5559: aload 15
    //   5561: getfield 233	com/tencent/mobileqq/activity/ChatHistory$Holder:a	Lcom/tencent/mobileqq/data/MessageRecord;
    //   5564: instanceof 1321
    //   5567: ifeq +276 -> 5843
    //   5570: aload 15
    //   5572: getfield 233	com/tencent/mobileqq/activity/ChatHistory$Holder:a	Lcom/tencent/mobileqq/data/MessageRecord;
    //   5575: checkcast 1321	com/tencent/mobileqq/data/MessageForStructing
    //   5578: astore_2
    //   5579: aload_2
    //   5580: getfield 1322	com/tencent/mobileqq/data/MessageForStructing:istroop	I
    //   5583: sipush 1024
    //   5586: if_icmpne +20 -> 5606
    //   5589: aload_0
    //   5590: getfield 18	com/tencent/mobileqq/activity/ChatHistory$ChatHistoryAdapter:f	Lcom/tencent/mobileqq/activity/ChatHistory;
    //   5593: getfield 209	com/tencent/mobileqq/activity/ChatHistory:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   5596: aload_2
    //   5597: getfield 1323	com/tencent/mobileqq/data/MessageForStructing:frienduin	Ljava/lang/String;
    //   5600: invokestatic 1328	com/tencent/qidian/QidianManager:a	(Lcom/tencent/common/app/business/BaseQQAppInterface;Ljava/lang/String;)Z
    //   5603: ifeq +24 -> 5627
    //   5606: aload_0
    //   5607: getfield 18	com/tencent/mobileqq/activity/ChatHistory$ChatHistoryAdapter:f	Lcom/tencent/mobileqq/activity/ChatHistory;
    //   5610: getfield 209	com/tencent/mobileqq/activity/ChatHistory:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   5613: aload_2
    //   5614: getfield 1323	com/tencent/mobileqq/data/MessageForStructing:frienduin	Ljava/lang/String;
    //   5617: aload_2
    //   5618: getfield 1322	com/tencent/mobileqq/data/MessageForStructing:istroop	I
    //   5621: invokestatic 1333	com/tencent/biz/eqq/CrmUtils:a	(Lcom/tencent/common/app/business/BaseQQAppInterface;Ljava/lang/String;I)Z
    //   5624: ifeq +219 -> 5843
    //   5627: aload_1
    //   5628: astore_2
    //   5629: aload_1
    //   5630: invokestatic 144	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   5633: ifeq +110 -> 5743
    //   5636: aload_1
    //   5637: astore_2
    //   5638: aload_3
    //   5639: ifnull +104 -> 5743
    //   5642: aload_1
    //   5643: astore_2
    //   5644: aload_3
    //   5645: instanceof 1335
    //   5648: ifeq +95 -> 5743
    //   5651: aload_3
    //   5652: checkcast 1335	com/tencent/mobileqq/structmsg/AbsShareMsg
    //   5655: invokevirtual 1339	com/tencent/mobileqq/structmsg/AbsShareMsg:getStructMsgItemLists	()Ljava/util/List;
    //   5658: invokeinterface 1343 1 0
    //   5663: astore_3
    //   5664: aload_1
    //   5665: astore_2
    //   5666: aload_3
    //   5667: invokeinterface 1348 1 0
    //   5672: ifeq +71 -> 5743
    //   5675: aload_3
    //   5676: invokeinterface 1351 1 0
    //   5681: checkcast 1353	com/tencent/mobileqq/structmsg/AbsStructMsgElement
    //   5684: astore_2
    //   5685: aload_2
    //   5686: instanceof 1355
    //   5689: ifeq -25 -> 5664
    //   5692: aload_2
    //   5693: checkcast 1355	com/tencent/mobileqq/structmsg/AbsStructMsgItem
    //   5696: getfield 1359	com/tencent/mobileqq/structmsg/AbsStructMsgItem:ax	Ljava/util/ArrayList;
    //   5699: invokevirtual 1362	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   5702: astore_2
    //   5703: aload_2
    //   5704: invokeinterface 1348 1 0
    //   5709: ifeq -45 -> 5664
    //   5712: aload_2
    //   5713: invokeinterface 1351 1 0
    //   5718: checkcast 1353	com/tencent/mobileqq/structmsg/AbsStructMsgElement
    //   5721: astore 13
    //   5723: aload 13
    //   5725: instanceof 1364
    //   5728: ifeq -25 -> 5703
    //   5731: aload 13
    //   5733: checkcast 1364	com/tencent/mobileqq/structmsg/view/StructMsgItemTitle
    //   5736: invokevirtual 1366	com/tencent/mobileqq/structmsg/view/StructMsgItemTitle:e	()Ljava/lang/String;
    //   5739: astore_1
    //   5740: goto -76 -> 5664
    //   5743: aload_2
    //   5744: invokestatic 144	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   5747: ifne +95 -> 5842
    //   5750: aload_0
    //   5751: getfield 18	com/tencent/mobileqq/activity/ChatHistory$ChatHistoryAdapter:f	Lcom/tencent/mobileqq/activity/ChatHistory;
    //   5754: getfield 209	com/tencent/mobileqq/activity/ChatHistory:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   5757: invokevirtual 1151	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   5760: ldc_w 1367
    //   5763: invokevirtual 1162	com/tencent/qphone/base/util/BaseApplication:getString	(I)Ljava/lang/String;
    //   5766: iconst_1
    //   5767: anewarray 675	java/lang/Object
    //   5770: dup
    //   5771: iconst_0
    //   5772: ldc_w 1368
    //   5775: invokestatic 1372	com/tencent/mobileqq/app/HardCodeUtil:a	(I)Ljava/lang/String;
    //   5778: aastore
    //   5779: invokestatic 1375	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   5782: astore_1
    //   5783: new 292	java/lang/StringBuilder
    //   5786: dup
    //   5787: invokespecial 293	java/lang/StringBuilder:<init>	()V
    //   5790: astore_3
    //   5791: aload_3
    //   5792: aload_1
    //   5793: invokevirtual 299	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5796: pop
    //   5797: aload_3
    //   5798: aload_2
    //   5799: invokevirtual 299	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5802: pop
    //   5803: aload 17
    //   5805: aload_3
    //   5806: invokevirtual 313	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5809: invokevirtual 222	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   5812: aload 17
    //   5814: iconst_0
    //   5815: invokevirtual 172	android/widget/TextView:setVisibility	(I)V
    //   5818: aload 17
    //   5820: aload_0
    //   5821: getfield 18	com/tencent/mobileqq/activity/ChatHistory$ChatHistoryAdapter:f	Lcom/tencent/mobileqq/activity/ChatHistory;
    //   5824: getfield 181	com/tencent/mobileqq/activity/ChatHistory:X	Lcom/tencent/mobileqq/activity/ChatHistory$HistoryItemOnlongClickListener;
    //   5827: invokevirtual 185	android/widget/TextView:setOnTouchListener	(Landroid/view/View$OnTouchListener;)V
    //   5830: aload 17
    //   5832: aload_0
    //   5833: getfield 18	com/tencent/mobileqq/activity/ChatHistory$ChatHistoryAdapter:f	Lcom/tencent/mobileqq/activity/ChatHistory;
    //   5836: getfield 181	com/tencent/mobileqq/activity/ChatHistory:X	Lcom/tencent/mobileqq/activity/ChatHistory$HistoryItemOnlongClickListener;
    //   5839: invokevirtual 189	android/widget/TextView:setOnLongClickListener	(Landroid/view/View$OnLongClickListener;)V
    //   5842: return
    //   5843: aload_1
    //   5844: invokestatic 144	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   5847: ifne +129 -> 5976
    //   5850: aload 15
    //   5852: getfield 233	com/tencent/mobileqq/activity/ChatHistory$Holder:a	Lcom/tencent/mobileqq/data/MessageRecord;
    //   5855: invokestatic 939	com/tencent/mobileqq/troop/utils/TroopBindPublicAccountMgr:a	(Lcom/tencent/mobileqq/data/MessageRecord;)Z
    //   5858: ifeq +82 -> 5940
    //   5861: aload_0
    //   5862: getfield 18	com/tencent/mobileqq/activity/ChatHistory$ChatHistoryAdapter:f	Lcom/tencent/mobileqq/activity/ChatHistory;
    //   5865: getfield 209	com/tencent/mobileqq/activity/ChatHistory:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   5868: invokevirtual 1151	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   5871: ldc_w 1367
    //   5874: invokevirtual 1162	com/tencent/qphone/base/util/BaseApplication:getString	(I)Ljava/lang/String;
    //   5877: iconst_1
    //   5878: anewarray 675	java/lang/Object
    //   5881: dup
    //   5882: iconst_0
    //   5883: ldc_w 941
    //   5886: invokestatic 263	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   5889: checkcast 941	com/tencent/biz/pubaccount/util/api/IPublicAccountConfigUtil
    //   5892: aload_0
    //   5893: getfield 18	com/tencent/mobileqq/activity/ChatHistory$ChatHistoryAdapter:f	Lcom/tencent/mobileqq/activity/ChatHistory;
    //   5896: getfield 209	com/tencent/mobileqq/activity/ChatHistory:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   5899: invokestatic 944	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   5902: invokeinterface 948 3 0
    //   5907: aastore
    //   5908: invokestatic 1375	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   5911: astore_2
    //   5912: new 292	java/lang/StringBuilder
    //   5915: dup
    //   5916: invokespecial 293	java/lang/StringBuilder:<init>	()V
    //   5919: astore_3
    //   5920: aload_3
    //   5921: aload_2
    //   5922: invokevirtual 299	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5925: pop
    //   5926: aload_3
    //   5927: aload_1
    //   5928: invokevirtual 299	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5931: pop
    //   5932: aload_3
    //   5933: invokevirtual 313	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5936: astore_1
    //   5937: goto +3 -> 5940
    //   5940: aload 17
    //   5942: aload_1
    //   5943: invokevirtual 222	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   5946: aload 17
    //   5948: iconst_0
    //   5949: invokevirtual 172	android/widget/TextView:setVisibility	(I)V
    //   5952: aload 17
    //   5954: aload_0
    //   5955: getfield 18	com/tencent/mobileqq/activity/ChatHistory$ChatHistoryAdapter:f	Lcom/tencent/mobileqq/activity/ChatHistory;
    //   5958: getfield 181	com/tencent/mobileqq/activity/ChatHistory:X	Lcom/tencent/mobileqq/activity/ChatHistory$HistoryItemOnlongClickListener;
    //   5961: invokevirtual 185	android/widget/TextView:setOnTouchListener	(Landroid/view/View$OnTouchListener;)V
    //   5964: aload 17
    //   5966: aload_0
    //   5967: getfield 18	com/tencent/mobileqq/activity/ChatHistory$ChatHistoryAdapter:f	Lcom/tencent/mobileqq/activity/ChatHistory;
    //   5970: getfield 181	com/tencent/mobileqq/activity/ChatHistory:X	Lcom/tencent/mobileqq/activity/ChatHistory$HistoryItemOnlongClickListener;
    //   5973: invokevirtual 189	android/widget/TextView:setOnLongClickListener	(Landroid/view/View$OnLongClickListener;)V
    //   5976: return
    //   5977: astore 14
    //   5979: goto -5262 -> 717
    //   5982: aload 22
    //   5984: astore 14
    //   5986: goto -5290 -> 696
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	5989	0	this	ChatHistoryAdapter
    //   0	5989	1	paramView	View
    //   0	5989	2	paramContext	Context
    //   0	5989	3	paramCursor	Cursor
    //   407	4710	4	i	int
    //   424	4361	5	j	int
    //   441	4591	6	k	int
    //   562	4390	7	m	int
    //   2499	2224	8	l1	long
    //   155	4263	10	l2	long
    //   590	2169	12	bool	boolean
    //   7	5725	13	localObject1	Object
    //   583	83	14	localObject2	Object
    //   670	1	14	localException1	Exception
    //   675	10	14	localException2	Exception
    //   691	13	14	localObject3	Object
    //   710	1	14	localException3	Exception
    //   715	1	14	localException4	Exception
    //   720	1	14	localException5	Exception
    //   725	15	14	localException6	Exception
    //   811	4321	14	str1	String
    //   5977	1	14	localException7	Exception
    //   5984	1	14	localObject4	Object
    //   11	5840	15	localObject5	Object
    //   237	4883	16	localImageView1	ImageView
    //   225	5740	17	localPatchedTextView	com.tencent.mobileqq.widget.PatchedTextView
    //   201	4834	18	localTextView1	TextView
    //   322	4530	19	localButton	android.widget.Button
    //   373	1942	20	localObject6	Object
    //   2326	3	20	localException8	Exception
    //   213	1034	21	localTextView2	TextView
    //   541	5442	22	localObject7	Object
    //   292	5043	23	localChatThumbView	ChatThumbView
    //   390	4617	24	str2	String
    //   334	1296	25	localImageView2	ImageView
    //   177	3678	26	localLinearLayout	android.widget.LinearLayout
    //   261	3655	27	localTextView3	TextView
    //   249	2726	28	localMixedMsgLinearLayout	MixedMsgLinearLayout
    //   310	1299	29	localImageView3	ImageView
    //   189	872	30	localTextView4	TextView
    //   603	295	31	localObject8	Object
    // Exception table:
    //   from	to	target	type
    //   605	640	670	java/lang/Exception
    //   647	663	670	java/lang/Exception
    //   597	605	675	java/lang/Exception
    //   677	689	710	java/lang/Exception
    //   696	703	710	java/lang/Exception
    //   532	564	715	java/lang/Exception
    //   518	532	720	java/lang/Exception
    //   501	518	725	java/lang/Exception
    //   1535	1555	1556	java/lang/Exception
    //   1584	1619	1620	java/lang/Exception
    //   2158	2212	2213	java/lang/Exception
    //   2313	2320	2326	java/lang/Exception
    //   572	592	5977	java/lang/Exception
  }
  
  public void changeCursor(Cursor paramCursor)
  {
    if (paramCursor != null)
    {
      if (getCursor() != null) {
        getCursor().deactivate();
      }
      super.changeCursor(paramCursor);
      notifyDataSetChanged();
    }
  }
  
  public View newView(Context paramContext, Cursor paramCursor, ViewGroup paramViewGroup)
  {
    return this.a.inflate(2131624479, paramViewGroup, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatHistory.ChatHistoryAdapter
 * JD-Core Version:    0.7.0.1
 */