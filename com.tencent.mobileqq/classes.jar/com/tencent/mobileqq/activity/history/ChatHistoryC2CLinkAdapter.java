package com.tencent.mobileqq.activity.history;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.history.helper.ChatHistoryItemSelectHelper;
import com.tencent.mobileqq.activity.history.helper.ContentHelper;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.mobileqq.structmsg.AbsStructMsgItem;
import com.tencent.mobileqq.structmsg.StructMsgForAudioShare;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ChatHistoryC2CLinkAdapter
  extends BaseAdapter
{
  View.OnClickListener a;
  View.OnClickListener b;
  Context c;
  ChatHistoryC2CLinkFragment d;
  private ArrayList<Object> e = new ArrayList();
  private LinkedHashMap<String, List<MessageRecord>> f = new LinkedHashMap();
  private ArrayMap<String, Boolean> g = new ArrayMap();
  private ChatHistoryItemSelectHelper h;
  private SimpleDateFormat i;
  private FriendsManager j;
  private QQAppInterface k;
  
  ChatHistoryC2CLinkAdapter(QQAppInterface paramQQAppInterface, Context paramContext, View.OnClickListener paramOnClickListener1, View.OnClickListener paramOnClickListener2, ChatHistoryC2CLinkFragment paramChatHistoryC2CLinkFragment, ChatHistoryItemSelectHelper paramChatHistoryItemSelectHelper)
  {
    this.k = paramQQAppInterface;
    this.c = paramContext;
    this.a = paramOnClickListener1;
    this.b = paramOnClickListener2;
    this.d = paramChatHistoryC2CLinkFragment;
    this.h = paramChatHistoryItemSelectHelper;
    this.i = new SimpleDateFormat("M月d日");
    this.j = ((FriendsManager)this.d.getBaseActivity().app.getManager(QQManagerFactory.FRIENDS_MANAGER));
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
  
  public static void a(ImageView paramImageView, String paramString)
  {
    BaseApplication localBaseApplication = BaseApplicationImpl.context;
    Drawable localDrawable = localBaseApplication.getResources().getDrawable(2130852667);
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mFailedDrawable = localDrawable;
    localURLDrawableOptions.mLoadingDrawable = localDrawable;
    ViewGroup.LayoutParams localLayoutParams = paramImageView.getLayoutParams();
    localURLDrawableOptions.mRequestHeight = localLayoutParams.height;
    localURLDrawableOptions.mRequestWidth = localLayoutParams.width;
    try
    {
      paramString = URLDrawable.getDrawable(paramString, localURLDrawableOptions);
      paramString.setTag(URLDrawableDecodeHandler.b(localLayoutParams.width, localLayoutParams.height, UIUtils.a(localBaseApplication, 6.0F)));
      paramString.setDecodeHandler(URLDrawableDecodeHandler.j);
      paramImageView.setImageDrawable(paramString);
      return;
    }
    catch (Throwable paramString)
    {
      label100:
      break label100;
    }
    paramImageView.setImageDrawable(localDrawable);
  }
  
  private void a(ChatHistoryC2CLinkAdapter.URLItemHolder paramURLItemHolder, MessageRecord paramMessageRecord)
  {
    boolean bool1 = paramMessageRecord instanceof MessageForArkApp;
    if (bool1)
    {
      m = 1;
      try
      {
        String str1 = ((MessageForArkApp)paramMessageRecord).getPreview();
        boolean bool2 = TextUtils.isEmpty(str1);
        if (bool2) {
          break label73;
        }
        try
        {
          a(ChatHistoryC2CLinkAdapter.URLItemHolder.a(paramURLItemHolder), str1);
        }
        catch (Exception localException1)
        {
          m = 1;
        }
        QLog.e("Q.history.C2CLinkAdapter", 1, localException2, new Object[0]);
      }
      catch (Exception localException2)
      {
        m = 0;
      }
      break label75;
    }
    label73:
    int m = 0;
    label75:
    if (m == 0) {
      ChatHistoryC2CLinkAdapter.URLItemHolder.a(paramURLItemHolder).setImageDrawable(this.c.getResources().getDrawable(2130852667));
    }
    String str2 = b(ContentHelper.a(paramMessageRecord));
    if (bool1)
    {
      String str3 = ((MessageForArkApp)paramMessageRecord).getTitle();
      TextView localTextView = ChatHistoryC2CLinkAdapter.URLItemHolder.b(paramURLItemHolder);
      localObject = str3;
      if (TextUtils.isEmpty(str3)) {
        localObject = str2;
      }
      localTextView.setText((CharSequence)localObject);
    }
    else
    {
      ChatHistoryC2CLinkAdapter.URLItemHolder.b(paramURLItemHolder).setText(str2);
    }
    Object localObject = new Date(paramMessageRecord.time * 1000L);
    localObject = this.i.format((Date)localObject);
    ChatHistoryC2CLinkAdapter.URLItemHolder.c(paramURLItemHolder).setText((CharSequence)localObject);
    ChatHistoryC2CLinkAdapter.URLItemHolder.d(paramURLItemHolder).setText(ContactUtils.g(this.d.getBaseActivity().app, paramMessageRecord.senderuin));
    ChatHistoryC2CLinkAdapter.URLItemHolder.f(paramURLItemHolder).setOnClickListener(new ChatHistoryC2CLinkAdapter.2(this, str2, paramURLItemHolder, paramMessageRecord));
    if (this.d.i)
    {
      ChatHistoryC2CLinkAdapter.URLItemHolder.e(paramURLItemHolder).setVisibility(0);
      bool1 = this.h.a(paramMessageRecord);
      ChatHistoryC2CLinkAdapter.URLItemHolder.e(paramURLItemHolder).setChecked(bool1);
      paramMessageRecord = (LinearLayout.LayoutParams)ChatHistoryC2CLinkAdapter.URLItemHolder.g(paramURLItemHolder).getLayoutParams();
      paramMessageRecord.setMargins(paramMessageRecord.leftMargin, paramMessageRecord.topMargin, UIUtils.a(this.c, 8.0F), paramMessageRecord.bottomMargin);
      ChatHistoryC2CLinkAdapter.URLItemHolder.g(paramURLItemHolder).setLayoutParams(paramMessageRecord);
      return;
    }
    ChatHistoryC2CLinkAdapter.URLItemHolder.e(paramURLItemHolder).setVisibility(8);
    paramMessageRecord = (LinearLayout.LayoutParams)ChatHistoryC2CLinkAdapter.URLItemHolder.g(paramURLItemHolder).getLayoutParams();
    paramMessageRecord.setMargins(paramMessageRecord.leftMargin, paramMessageRecord.topMargin, UIUtils.a(this.c, 50.0F), paramMessageRecord.bottomMargin);
    ChatHistoryC2CLinkAdapter.URLItemHolder.g(paramURLItemHolder).setLayoutParams(paramMessageRecord);
  }
  
  private void a(String paramString)
  {
    if (this.g.containsKey(paramString))
    {
      if (!this.f.containsKey(paramString)) {
        return;
      }
      boolean bool = ((Boolean)this.g.get(paramString)).booleanValue();
      List localList = (List)this.f.get(paramString);
      if (bool)
      {
        int m = this.e.indexOf(paramString);
        this.e.addAll(m + 1, localList);
        ReportController.b(this.k, "dc00898", "", "", "0X800AC87", "0X800AC87", 5, 0, "1", "2", "", "");
      }
      else
      {
        this.e.removeAll(localList);
        ReportController.b(this.k, "dc00898", "", "", "0X800AC87", "0X800AC87", 5, 0, "1", "1", "", "");
      }
      this.g.put(paramString, Boolean.valueOf(bool ^ true));
      notifyDataSetChanged();
    }
  }
  
  private String b(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      Matcher localMatcher = ChatHistoryC2CLinkFragment.t.matcher(paramString);
      if (localMatcher.find()) {
        return paramString.substring(localMatcher.start(), localMatcher.end());
      }
    }
    return "";
  }
  
  public void a(URLImageView paramURLImageView, AbsShareMsg paramAbsShareMsg)
  {
    Object localObject2 = this.c.getResources();
    Object localObject1 = a(paramAbsShareMsg, "cover");
    int m;
    if ((paramAbsShareMsg instanceof StructMsgForAudioShare)) {
      m = 2130852676;
    } else {
      m = 2130852667;
    }
    localObject2 = ((Resources)localObject2).getDrawable(m);
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      paramURLImageView.setImageDrawable((Drawable)localObject2);
      return;
    }
    paramAbsShareMsg = (AbsShareMsg)localObject1;
    if (!((String)localObject1).startsWith("http://"))
    {
      paramAbsShareMsg = (AbsShareMsg)localObject1;
      if (!((String)localObject1).startsWith("https://")) {
        paramAbsShareMsg = Uri.fromFile(new File((String)localObject1)).toString();
      }
    }
    paramAbsShareMsg = URLDrawable.getDrawable(paramAbsShareMsg, (Drawable)localObject2, (Drawable)localObject2);
    localObject1 = paramURLImageView.getLayoutParams();
    paramAbsShareMsg.setTag(URLDrawableDecodeHandler.b(((ViewGroup.LayoutParams)localObject1).width, ((ViewGroup.LayoutParams)localObject1).height, UIUtils.a(this.c, 6.0F)));
    paramAbsShareMsg.setDecodeHandler(URLDrawableDecodeHandler.j);
    paramURLImageView.setImageDrawable(paramAbsShareMsg);
  }
  
  public void a(LinkedHashMap<String, List<MessageRecord>> paramLinkedHashMap)
  {
    if (paramLinkedHashMap != null)
    {
      if (paramLinkedHashMap.isEmpty()) {
        return;
      }
      this.f = paramLinkedHashMap;
      this.g.clear();
      this.e.clear();
      paramLinkedHashMap = this.f.entrySet().iterator();
      while (paramLinkedHashMap.hasNext())
      {
        Object localObject = (Map.Entry)paramLinkedHashMap.next();
        String str = (String)((Map.Entry)localObject).getKey();
        localObject = (List)((Map.Entry)localObject).getValue();
        this.g.put(str, Boolean.valueOf(false));
        this.e.add(str);
        this.e.addAll((Collection)localObject);
      }
      if (QLog.isColorLevel())
      {
        paramLinkedHashMap = new StringBuilder();
        paramLinkedHashMap.append("[setData]data size: ");
        paramLinkedHashMap.append(this.f.size());
        paramLinkedHashMap.append(" header size: ");
        paramLinkedHashMap.append(this.g.size());
        paramLinkedHashMap.append(" elements size: ");
        paramLinkedHashMap.append(this.e.size());
        QLog.d("Q.history.C2CLinkAdapter", 2, paramLinkedHashMap.toString());
      }
      notifyDataSetChanged();
    }
  }
  
  public int getCount()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[getCount]data size: ");
      localStringBuilder.append(this.f.size());
      localStringBuilder.append(" header size: ");
      localStringBuilder.append(this.g.size());
      localStringBuilder.append(" elements size: ");
      localStringBuilder.append(this.e.size());
      QLog.d("Q.history.C2CLinkAdapter", 2, localStringBuilder.toString());
    }
    return this.e.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.e.get(paramInt);
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
      if ((paramView != null) && ((paramView.getTag() instanceof ChatHistoryC2CLinkAdapter.HistoryStructItemHolder)))
      {
        localObject1 = (ChatHistoryC2CLinkAdapter.HistoryStructItemHolder)paramView.getTag();
      }
      else
      {
        localObject1 = new ChatHistoryC2CLinkAdapter.HistoryStructItemHolder(this);
        paramView = View.inflate(this.c, 2131624476, null);
        ((ChatHistoryC2CLinkAdapter.HistoryStructItemHolder)localObject1).a = ((RelativeLayout)paramView.findViewById(2131444374));
        ((ChatHistoryC2CLinkAdapter.HistoryStructItemHolder)localObject1).b = ((CheckBox)paramView.findViewById(2131446441));
        ((ChatHistoryC2CLinkAdapter.HistoryStructItemHolder)localObject1).c = ((URLImageView)paramView.findViewById(2131446439));
        ((ChatHistoryC2CLinkAdapter.HistoryStructItemHolder)localObject1).d = ((TextView)paramView.findViewById(2131429731));
        ((ChatHistoryC2CLinkAdapter.HistoryStructItemHolder)localObject1).e = ((TextView)paramView.findViewById(2131438959));
        ((ChatHistoryC2CLinkAdapter.HistoryStructItemHolder)localObject1).f = ((TextView)paramView.findViewById(2131431622));
        paramView.setTag(localObject1);
        ((ChatHistoryC2CLinkAdapter.HistoryStructItemHolder)localObject1).a.setTag(localObject1);
        ((ChatHistoryC2CLinkAdapter.HistoryStructItemHolder)localObject1).a.setOnClickListener(this.a);
      }
      ((ChatHistoryC2CLinkAdapter.HistoryStructItemHolder)localObject1).g = localObject2;
      ((ChatHistoryC2CLinkAdapter.HistoryStructItemHolder)localObject1).h = this.d.C;
      if ((localObject2 instanceof MessageForStructing))
      {
        if (localObject2 == null) {
          ((MessageForStructing)localObject2).parse();
        }
        if ((((MessageForStructing)localObject2).structingMsg != null) && ((((MessageForStructing)localObject2).structingMsg instanceof AbsShareMsg)))
        {
          Object localObject3 = (AbsShareMsg)((MessageForStructing)localObject2).structingMsg;
          a(((ChatHistoryC2CLinkAdapter.HistoryStructItemHolder)localObject1).c, (AbsShareMsg)localObject3);
          ((ChatHistoryC2CLinkAdapter.HistoryStructItemHolder)localObject1).d.setText(a((AbsShareMsg)localObject3, "title"));
          localObject3 = ContactUtils.a(this.d.getBaseActivity().app, ((MessageForStructing)localObject2).senderuin);
          ((ChatHistoryC2CLinkAdapter.HistoryStructItemHolder)localObject1).e.setText((CharSequence)localObject3);
          localObject3 = new Date(((MessageForStructing)localObject2).time * 1000L);
          localObject3 = this.i.format((Date)localObject3);
          ((ChatHistoryC2CLinkAdapter.HistoryStructItemHolder)localObject1).f.setText((CharSequence)localObject3);
        }
      }
      else
      {
        ((ChatHistoryC2CLinkAdapter.HistoryStructItemHolder)localObject1).d.setText("");
        ((ChatHistoryC2CLinkAdapter.HistoryStructItemHolder)localObject1).e.setText("");
      }
      if (this.d.i)
      {
        ((ChatHistoryC2CLinkAdapter.HistoryStructItemHolder)localObject1).b.setVisibility(0);
        ((ChatHistoryC2CLinkAdapter.HistoryStructItemHolder)localObject1).b.setChecked(this.h.a(localObject2));
        localObject1 = paramView;
      }
      else
      {
        ((ChatHistoryC2CLinkAdapter.HistoryStructItemHolder)localObject1).b.setVisibility(8);
        localObject1 = paramView;
      }
    }
    else if ((!(localObject2 instanceof MessageForText)) && (!(localObject2 instanceof MessageForReplyText)) && (!(localObject2 instanceof MessageForMixedMsg)) && (!(localObject2 instanceof MessageForArkApp)))
    {
      localObject1 = paramView;
      if ((localObject2 instanceof String))
      {
        if ((paramView != null) && ((paramView.getTag() instanceof ChatHistoryC2CLinkAdapter.DividerViewHolder)))
        {
          localObject1 = (ChatHistoryC2CLinkAdapter.DividerViewHolder)paramView.getTag();
        }
        else
        {
          paramView = LayoutInflater.from(this.c).inflate(2131624413, null);
          localObject1 = new ChatHistoryC2CLinkAdapter.DividerViewHolder();
          ((ChatHistoryC2CLinkAdapter.DividerViewHolder)localObject1).b = ((CheckBox)paramView.findViewById(2131436369));
          ((ChatHistoryC2CLinkAdapter.DividerViewHolder)localObject1).a = ((TextView)paramView.findViewById(2131447246));
          paramView.setTag(localObject1);
          paramView.setOnClickListener(new ChatHistoryC2CLinkAdapter.1(this, (ChatHistoryC2CLinkAdapter.DividerViewHolder)localObject1));
        }
        ((ChatHistoryC2CLinkAdapter.DividerViewHolder)localObject1).b.setChecked(((Boolean)this.g.get(localObject2)).booleanValue() ^ true);
        ((ChatHistoryC2CLinkAdapter.DividerViewHolder)localObject1).a.setText((String)localObject2);
        localObject1 = paramView;
      }
    }
    else
    {
      if ((paramView != null) && ((paramView.getTag() instanceof ChatHistoryC2CLinkAdapter.URLItemHolder)))
      {
        localObject1 = (ChatHistoryC2CLinkAdapter.URLItemHolder)paramView.getTag();
      }
      else
      {
        paramView = LayoutInflater.from(this.c).inflate(2131624414, null);
        localObject1 = new ChatHistoryC2CLinkAdapter.URLItemHolder(this, paramView);
        paramView.setTag(localObject1);
      }
      a((ChatHistoryC2CLinkAdapter.URLItemHolder)localObject1, (MessageRecord)localObject2);
      localObject1 = paramView;
    }
    EventCollector.getInstance().onListGetView(paramInt, (View)localObject1, paramViewGroup, getItemId(paramInt));
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryC2CLinkAdapter
 * JD-Core Version:    0.7.0.1
 */