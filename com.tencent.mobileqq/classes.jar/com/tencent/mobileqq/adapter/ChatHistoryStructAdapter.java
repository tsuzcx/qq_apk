package com.tencent.mobileqq.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.ChatHistoryFileActivity;
import com.tencent.mobileqq.activity.ChatHistoryStructMsgView;
import com.tencent.mobileqq.activity.ChatHistoryViewBase;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.mobileqq.structmsg.AbsStructMsgItem;
import com.tencent.mobileqq.structmsg.StructMsgForAudioShare;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ChatHistoryStructAdapter
  extends BaseAdapter
{
  View.OnClickListener a;
  View.OnClickListener b;
  public ArrayList<Object> c;
  Context d;
  ChatHistoryViewBase e;
  
  public ChatHistoryStructAdapter(Context paramContext, ArrayList<Object> paramArrayList, View.OnClickListener paramOnClickListener1, View.OnClickListener paramOnClickListener2, ChatHistoryViewBase paramChatHistoryViewBase)
  {
    this.d = paramContext;
    this.c = paramArrayList;
    this.a = paramOnClickListener1;
    this.b = paramOnClickListener2;
    this.e = paramChatHistoryViewBase;
  }
  
  public static String a(AbsShareMsg paramAbsShareMsg, String paramString)
  {
    Object localObject1;
    if (paramString.equals("cover")) {
      localObject1 = paramAbsShareMsg.mContentCover;
    } else {
      localObject1 = paramAbsShareMsg.mContentTitle;
    }
    Object localObject2 = localObject1;
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      localObject2 = localObject1;
      if ((paramAbsShareMsg instanceof StructMsgForGeneralShare))
      {
        paramAbsShareMsg = (StructMsgForGeneralShare)paramAbsShareMsg;
        localObject2 = localObject1;
        if (paramAbsShareMsg.mStructMsgItemLists != null)
        {
          localObject2 = localObject1;
          if (!paramAbsShareMsg.mStructMsgItemLists.isEmpty())
          {
            Iterator localIterator = paramAbsShareMsg.mStructMsgItemLists.iterator();
            paramAbsShareMsg = (AbsShareMsg)localObject1;
            do
            {
              do
              {
                do
                {
                  localObject2 = paramAbsShareMsg;
                  if (!localIterator.hasNext()) {
                    return localObject2;
                  }
                  localObject1 = (AbsStructMsgElement)localIterator.next();
                  if (!(localObject1 instanceof AbsStructMsgItem)) {
                    break;
                  }
                  localObject1 = (AbsStructMsgItem)localObject1;
                } while ((((AbsStructMsgItem)localObject1).ax == null) || (((AbsStructMsgItem)localObject1).ax.isEmpty()));
                localObject2 = ((AbsStructMsgItem)localObject1).ax.iterator();
                localObject1 = paramAbsShareMsg;
                while (((Iterator)localObject2).hasNext())
                {
                  paramAbsShareMsg = (AbsStructMsgElement)((Iterator)localObject2).next();
                  if (paramString.equals("cover")) {
                    paramAbsShareMsg = StructMsgForGeneralShare.getCoverForChatHistory(paramAbsShareMsg);
                  } else {
                    paramAbsShareMsg = StructMsgForGeneralShare.getTitleForChatHistory(paramAbsShareMsg);
                  }
                  localObject1 = paramAbsShareMsg;
                  if (!TextUtils.isEmpty(paramAbsShareMsg)) {
                    localObject1 = paramAbsShareMsg;
                  }
                }
                paramAbsShareMsg = (AbsShareMsg)localObject1;
              } while (TextUtils.isEmpty((CharSequence)localObject1));
              return localObject1;
              if (paramString.equals("cover")) {
                localObject1 = StructMsgForGeneralShare.getCoverForChatHistory((AbsStructMsgElement)localObject1);
              } else {
                localObject1 = StructMsgForGeneralShare.getTitleForChatHistory((AbsStructMsgElement)localObject1);
              }
              paramAbsShareMsg = (AbsShareMsg)localObject1;
            } while (TextUtils.isEmpty((CharSequence)localObject1));
            localObject2 = localObject1;
          }
        }
      }
    }
    return localObject2;
  }
  
  public static boolean a(MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord instanceof MessageForStructing))
    {
      Object localObject = (MessageForStructing)paramMessageRecord;
      AbsStructMsg localAbsStructMsg = ((MessageForStructing)localObject).structingMsg;
      if (localAbsStructMsg == null) {
        ((MessageForStructing)localObject).parse();
      }
      if (AnonymousChatHelper.c(paramMessageRecord)) {
        return false;
      }
      if ((localAbsStructMsg != null) && (localAbsStructMsg.fwFlag != 1))
      {
        if (localAbsStructMsg.hasFlag(1)) {
          return false;
        }
        if ((localAbsStructMsg instanceof StructMsgForAudioShare)) {
          return true;
        }
        if ((localAbsStructMsg instanceof StructMsgForGeneralShare))
        {
          localObject = (StructMsgForGeneralShare)localAbsStructMsg;
          paramMessageRecord = a((AbsShareMsg)localObject, "cover");
          localObject = a((AbsShareMsg)localObject, "title");
          if ((!TextUtils.isEmpty(paramMessageRecord)) && (!TextUtils.isEmpty((CharSequence)localObject))) {
            return true;
          }
        }
      }
    }
    return false;
  }
  
  public void a(URLImageView paramURLImageView, AbsShareMsg paramAbsShareMsg)
  {
    Object localObject = this.d.getResources();
    String str = a(paramAbsShareMsg, "cover");
    int i;
    if ((paramAbsShareMsg instanceof StructMsgForAudioShare)) {
      i = 2130852676;
    } else {
      i = 2130852666;
    }
    localObject = ((Resources)localObject).getDrawable(i);
    if (TextUtils.isEmpty(str))
    {
      paramURLImageView.setImageDrawable((Drawable)localObject);
      return;
    }
    paramAbsShareMsg = str;
    if (!str.startsWith("http://"))
    {
      paramAbsShareMsg = str;
      if (!str.startsWith("https://")) {
        paramAbsShareMsg = Uri.fromFile(new File(str)).toString();
      }
    }
    paramURLImageView.setImageDrawable(URLDrawable.getDrawable(paramAbsShareMsg, (Drawable)localObject, (Drawable)localObject));
  }
  
  public int getCount()
  {
    ArrayList localArrayList = this.c;
    if (localArrayList != null) {
      return localArrayList.size();
    }
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    return this.c.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject2 = getItem(paramInt);
    Object localObject1;
    if ((localObject2 instanceof MessageForStructing))
    {
      localObject2 = (MessageForStructing)localObject2;
      if ((paramView != null) && ((paramView.getTag() instanceof ChatHistoryStructAdapter.HistoryStructItemHolder)))
      {
        localObject1 = (ChatHistoryStructAdapter.HistoryStructItemHolder)paramView.getTag();
      }
      else
      {
        localObject1 = new ChatHistoryStructAdapter.HistoryStructItemHolder(this);
        paramView = View.inflate(this.d, 2131629319, null);
        ((ChatHistoryStructAdapter.HistoryStructItemHolder)localObject1).a = ((RelativeLayout)paramView.findViewById(2131444374));
        ((ChatHistoryStructAdapter.HistoryStructItemHolder)localObject1).b = ((CheckBox)paramView.findViewById(2131446441));
        ((ChatHistoryStructAdapter.HistoryStructItemHolder)localObject1).c = ((URLImageView)paramView.findViewById(2131446439));
        ((ChatHistoryStructAdapter.HistoryStructItemHolder)localObject1).d = ((TextView)paramView.findViewById(2131429731));
        ((ChatHistoryStructAdapter.HistoryStructItemHolder)localObject1).e = ((TextView)paramView.findViewById(2131438959));
        paramView.setTag(localObject1);
        ((ChatHistoryStructAdapter.HistoryStructItemHolder)localObject1).a.setTag(localObject1);
        ((ChatHistoryStructAdapter.HistoryStructItemHolder)localObject1).a.setOnClickListener(this.a);
      }
      ((ChatHistoryStructAdapter.HistoryStructItemHolder)localObject1).f = localObject2;
      ((ChatHistoryStructAdapter.HistoryStructItemHolder)localObject1).g = ((ChatHistoryStructMsgView)this.e).k;
      if ((localObject2 instanceof MessageForStructing))
      {
        if (localObject2 == null) {
          ((MessageForStructing)localObject2).parse();
        }
        if ((((MessageForStructing)localObject2).structingMsg != null) && ((((MessageForStructing)localObject2).structingMsg instanceof AbsShareMsg)))
        {
          AbsShareMsg localAbsShareMsg = (AbsShareMsg)((MessageForStructing)localObject2).structingMsg;
          a(((ChatHistoryStructAdapter.HistoryStructItemHolder)localObject1).c, localAbsShareMsg);
          ((ChatHistoryStructAdapter.HistoryStructItemHolder)localObject1).d.setText(a(localAbsShareMsg, "title"));
          ((ChatHistoryStructAdapter.HistoryStructItemHolder)localObject1).e.setText(localAbsShareMsg.mSourceName);
        }
      }
      else
      {
        ((ChatHistoryStructAdapter.HistoryStructItemHolder)localObject1).d.setText("");
        ((ChatHistoryStructAdapter.HistoryStructItemHolder)localObject1).e.setText("");
      }
      if (this.e.i())
      {
        ((ChatHistoryStructAdapter.HistoryStructItemHolder)localObject1).b.setVisibility(0);
        ((ChatHistoryStructAdapter.HistoryStructItemHolder)localObject1).b.setChecked(this.e.D.c((ChatMessage)localObject2));
        localObject1 = paramView;
      }
      else
      {
        ((ChatHistoryStructAdapter.HistoryStructItemHolder)localObject1).b.setVisibility(8);
        localObject1 = paramView;
      }
    }
    else
    {
      localObject1 = paramView;
      if ((localObject2 instanceof String))
      {
        if ((paramView != null) && ((paramView.getTag() instanceof TextView)))
        {
          localObject1 = (TextView)paramView.getTag();
        }
        else
        {
          paramView = View.inflate(this.d, 2131629320, null);
          localObject1 = (TextView)paramView.findViewById(2131447089);
          paramView.setTag(localObject1);
        }
        ((TextView)localObject1).setText((String)localObject2);
        localObject1 = paramView;
      }
    }
    EventCollector.getInstance().onListGetView(paramInt, (View)localObject1, paramViewGroup, getItemId(paramInt));
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.adapter.ChatHistoryStructAdapter
 * JD-Core Version:    0.7.0.1
 */