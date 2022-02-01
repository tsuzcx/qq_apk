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
  Context jdField_a_of_type_AndroidContentContext;
  private ArrayMap<String, Boolean> jdField_a_of_type_AndroidSupportV4UtilArrayMap = new ArrayMap();
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  ChatHistoryC2CLinkFragment jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryC2CLinkFragment;
  private ChatHistoryItemSelectHelper jdField_a_of_type_ComTencentMobileqqActivityHistoryHelperChatHistoryItemSelectHelper;
  private FriendsManager jdField_a_of_type_ComTencentMobileqqAppFriendsManager;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private SimpleDateFormat jdField_a_of_type_JavaTextSimpleDateFormat;
  private ArrayList<Object> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private LinkedHashMap<String, List<MessageRecord>> jdField_a_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
  View.OnClickListener b;
  
  ChatHistoryC2CLinkAdapter(QQAppInterface paramQQAppInterface, Context paramContext, View.OnClickListener paramOnClickListener1, View.OnClickListener paramOnClickListener2, ChatHistoryC2CLinkFragment paramChatHistoryC2CLinkFragment, ChatHistoryItemSelectHelper paramChatHistoryItemSelectHelper)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener1;
    this.b = paramOnClickListener2;
    this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryC2CLinkFragment = paramChatHistoryC2CLinkFragment;
    this.jdField_a_of_type_ComTencentMobileqqActivityHistoryHelperChatHistoryItemSelectHelper = paramChatHistoryItemSelectHelper;
    this.jdField_a_of_type_JavaTextSimpleDateFormat = new SimpleDateFormat("M月d日");
    this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager = ((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryC2CLinkFragment.getBaseActivity().app.getManager(QQManagerFactory.FRIENDS_MANAGER));
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
                } while ((((AbsStructMsgItem)localObject1).jdField_a_of_type_JavaUtilArrayList == null) || (((AbsStructMsgItem)localObject1).jdField_a_of_type_JavaUtilArrayList.isEmpty()));
                localObject2 = ((AbsStructMsgItem)localObject1).jdField_a_of_type_JavaUtilArrayList.iterator();
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
  
  private String a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      Matcher localMatcher = ChatHistoryC2CLinkFragment.a.matcher(paramString);
      if (localMatcher.find()) {
        return paramString.substring(localMatcher.start(), localMatcher.end());
      }
    }
    return "";
  }
  
  public static void a(ImageView paramImageView, String paramString)
  {
    BaseApplication localBaseApplication = BaseApplicationImpl.context;
    Drawable localDrawable = localBaseApplication.getResources().getDrawable(2130850832);
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
      paramString.setDecodeHandler(URLDrawableDecodeHandler.i);
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
      i = 1;
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
          i = 1;
        }
        QLog.e("Q.history.C2CLinkAdapter", 1, localException2, new Object[0]);
      }
      catch (Exception localException2)
      {
        i = 0;
      }
      break label75;
    }
    label73:
    int i = 0;
    label75:
    if (i == 0) {
      ChatHistoryC2CLinkAdapter.URLItemHolder.a(paramURLItemHolder).setImageDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130850832));
    }
    String str2 = a(ContentHelper.a(paramMessageRecord));
    if (bool1)
    {
      String str3 = ((MessageForArkApp)paramMessageRecord).getTitle();
      TextView localTextView = ChatHistoryC2CLinkAdapter.URLItemHolder.a(paramURLItemHolder);
      localObject = str3;
      if (TextUtils.isEmpty(str3)) {
        localObject = str2;
      }
      localTextView.setText((CharSequence)localObject);
    }
    else
    {
      ChatHistoryC2CLinkAdapter.URLItemHolder.a(paramURLItemHolder).setText(str2);
    }
    Object localObject = new Date(paramMessageRecord.time * 1000L);
    localObject = this.jdField_a_of_type_JavaTextSimpleDateFormat.format((Date)localObject);
    ChatHistoryC2CLinkAdapter.URLItemHolder.b(paramURLItemHolder).setText((CharSequence)localObject);
    ChatHistoryC2CLinkAdapter.URLItemHolder.c(paramURLItemHolder).setText(ContactUtils.f(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryC2CLinkFragment.getBaseActivity().app, paramMessageRecord.senderuin));
    ChatHistoryC2CLinkAdapter.URLItemHolder.a(paramURLItemHolder).setOnClickListener(new ChatHistoryC2CLinkAdapter.2(this, str2, paramURLItemHolder, paramMessageRecord));
    if (this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryC2CLinkFragment.c)
    {
      ChatHistoryC2CLinkAdapter.URLItemHolder.a(paramURLItemHolder).setVisibility(0);
      bool1 = this.jdField_a_of_type_ComTencentMobileqqActivityHistoryHelperChatHistoryItemSelectHelper.a(paramMessageRecord);
      ChatHistoryC2CLinkAdapter.URLItemHolder.a(paramURLItemHolder).setChecked(bool1);
      paramMessageRecord = (LinearLayout.LayoutParams)ChatHistoryC2CLinkAdapter.URLItemHolder.a(paramURLItemHolder).getLayoutParams();
      paramMessageRecord.setMargins(paramMessageRecord.leftMargin, paramMessageRecord.topMargin, UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 8.0F), paramMessageRecord.bottomMargin);
      ChatHistoryC2CLinkAdapter.URLItemHolder.a(paramURLItemHolder).setLayoutParams(paramMessageRecord);
      return;
    }
    ChatHistoryC2CLinkAdapter.URLItemHolder.a(paramURLItemHolder).setVisibility(8);
    paramMessageRecord = (LinearLayout.LayoutParams)ChatHistoryC2CLinkAdapter.URLItemHolder.a(paramURLItemHolder).getLayoutParams();
    paramMessageRecord.setMargins(paramMessageRecord.leftMargin, paramMessageRecord.topMargin, UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 50.0F), paramMessageRecord.bottomMargin);
    ChatHistoryC2CLinkAdapter.URLItemHolder.a(paramURLItemHolder).setLayoutParams(paramMessageRecord);
  }
  
  private void a(String paramString)
  {
    if (this.jdField_a_of_type_AndroidSupportV4UtilArrayMap.containsKey(paramString))
    {
      if (!this.jdField_a_of_type_JavaUtilLinkedHashMap.containsKey(paramString)) {
        return;
      }
      boolean bool = ((Boolean)this.jdField_a_of_type_AndroidSupportV4UtilArrayMap.get(paramString)).booleanValue();
      List localList = (List)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(paramString);
      if (bool)
      {
        int i = this.jdField_a_of_type_JavaUtilArrayList.indexOf(paramString);
        this.jdField_a_of_type_JavaUtilArrayList.addAll(i + 1, localList);
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800AC87", "0X800AC87", 5, 0, "1", "2", "", "");
      }
      else
      {
        this.jdField_a_of_type_JavaUtilArrayList.removeAll(localList);
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800AC87", "0X800AC87", 5, 0, "1", "1", "", "");
      }
      this.jdField_a_of_type_AndroidSupportV4UtilArrayMap.put(paramString, Boolean.valueOf(bool ^ true));
      notifyDataSetChanged();
    }
  }
  
  public void a(URLImageView paramURLImageView, AbsShareMsg paramAbsShareMsg)
  {
    Object localObject2 = this.jdField_a_of_type_AndroidContentContext.getResources();
    Object localObject1 = a(paramAbsShareMsg, "cover");
    int i;
    if ((paramAbsShareMsg instanceof StructMsgForAudioShare)) {
      i = 2130850841;
    } else {
      i = 2130850832;
    }
    localObject2 = ((Resources)localObject2).getDrawable(i);
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
    paramAbsShareMsg.setTag(URLDrawableDecodeHandler.b(((ViewGroup.LayoutParams)localObject1).width, ((ViewGroup.LayoutParams)localObject1).height, UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 6.0F)));
    paramAbsShareMsg.setDecodeHandler(URLDrawableDecodeHandler.i);
    paramURLImageView.setImageDrawable(paramAbsShareMsg);
  }
  
  public void a(LinkedHashMap<String, List<MessageRecord>> paramLinkedHashMap)
  {
    if (paramLinkedHashMap != null)
    {
      if (paramLinkedHashMap.isEmpty()) {
        return;
      }
      this.jdField_a_of_type_JavaUtilLinkedHashMap = paramLinkedHashMap;
      this.jdField_a_of_type_AndroidSupportV4UtilArrayMap.clear();
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      paramLinkedHashMap = this.jdField_a_of_type_JavaUtilLinkedHashMap.entrySet().iterator();
      while (paramLinkedHashMap.hasNext())
      {
        Object localObject = (Map.Entry)paramLinkedHashMap.next();
        String str = (String)((Map.Entry)localObject).getKey();
        localObject = (List)((Map.Entry)localObject).getValue();
        this.jdField_a_of_type_AndroidSupportV4UtilArrayMap.put(str, Boolean.valueOf(false));
        this.jdField_a_of_type_JavaUtilArrayList.add(str);
        this.jdField_a_of_type_JavaUtilArrayList.addAll((Collection)localObject);
      }
      if (QLog.isColorLevel())
      {
        paramLinkedHashMap = new StringBuilder();
        paramLinkedHashMap.append("[setData]data size: ");
        paramLinkedHashMap.append(this.jdField_a_of_type_JavaUtilLinkedHashMap.size());
        paramLinkedHashMap.append(" header size: ");
        paramLinkedHashMap.append(this.jdField_a_of_type_AndroidSupportV4UtilArrayMap.size());
        paramLinkedHashMap.append(" elements size: ");
        paramLinkedHashMap.append(this.jdField_a_of_type_JavaUtilArrayList.size());
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
      localStringBuilder.append(this.jdField_a_of_type_JavaUtilLinkedHashMap.size());
      localStringBuilder.append(" header size: ");
      localStringBuilder.append(this.jdField_a_of_type_AndroidSupportV4UtilArrayMap.size());
      localStringBuilder.append(" elements size: ");
      localStringBuilder.append(this.jdField_a_of_type_JavaUtilArrayList.size());
      QLog.d("Q.history.C2CLinkAdapter", 2, localStringBuilder.toString());
    }
    return this.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
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
        paramView = View.inflate(this.jdField_a_of_type_AndroidContentContext, 2131558856, null);
        ((ChatHistoryC2CLinkAdapter.HistoryStructItemHolder)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131376168));
        ((ChatHistoryC2CLinkAdapter.HistoryStructItemHolder)localObject1).jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)paramView.findViewById(2131377954));
        ((ChatHistoryC2CLinkAdapter.HistoryStructItemHolder)localObject1).jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131377952));
        ((ChatHistoryC2CLinkAdapter.HistoryStructItemHolder)localObject1).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131363798));
        ((ChatHistoryC2CLinkAdapter.HistoryStructItemHolder)localObject1).b = ((TextView)paramView.findViewById(2131371578));
        ((ChatHistoryC2CLinkAdapter.HistoryStructItemHolder)localObject1).c = ((TextView)paramView.findViewById(2131365418));
        paramView.setTag(localObject1);
        ((ChatHistoryC2CLinkAdapter.HistoryStructItemHolder)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout.setTag(localObject1);
        ((ChatHistoryC2CLinkAdapter.HistoryStructItemHolder)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      }
      ((ChatHistoryC2CLinkAdapter.HistoryStructItemHolder)localObject1).jdField_a_of_type_JavaLangObject = localObject2;
      ((ChatHistoryC2CLinkAdapter.HistoryStructItemHolder)localObject1).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryC2CLinkFragment.d;
      if ((localObject2 instanceof MessageForStructing))
      {
        if (localObject2 == null) {
          ((MessageForStructing)localObject2).parse();
        }
        if ((((MessageForStructing)localObject2).structingMsg != null) && ((((MessageForStructing)localObject2).structingMsg instanceof AbsShareMsg)))
        {
          Object localObject3 = (AbsShareMsg)((MessageForStructing)localObject2).structingMsg;
          a(((ChatHistoryC2CLinkAdapter.HistoryStructItemHolder)localObject1).jdField_a_of_type_ComTencentImageURLImageView, (AbsShareMsg)localObject3);
          ((ChatHistoryC2CLinkAdapter.HistoryStructItemHolder)localObject1).jdField_a_of_type_AndroidWidgetTextView.setText(a((AbsShareMsg)localObject3, "title"));
          localObject3 = ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryC2CLinkFragment.getBaseActivity().app, ((MessageForStructing)localObject2).senderuin);
          ((ChatHistoryC2CLinkAdapter.HistoryStructItemHolder)localObject1).b.setText((CharSequence)localObject3);
          localObject3 = new Date(((MessageForStructing)localObject2).time * 1000L);
          localObject3 = this.jdField_a_of_type_JavaTextSimpleDateFormat.format((Date)localObject3);
          ((ChatHistoryC2CLinkAdapter.HistoryStructItemHolder)localObject1).c.setText((CharSequence)localObject3);
        }
      }
      else
      {
        ((ChatHistoryC2CLinkAdapter.HistoryStructItemHolder)localObject1).jdField_a_of_type_AndroidWidgetTextView.setText("");
        ((ChatHistoryC2CLinkAdapter.HistoryStructItemHolder)localObject1).b.setText("");
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryC2CLinkFragment.c)
      {
        ((ChatHistoryC2CLinkAdapter.HistoryStructItemHolder)localObject1).jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(0);
        ((ChatHistoryC2CLinkAdapter.HistoryStructItemHolder)localObject1).jdField_a_of_type_AndroidWidgetCheckBox.setChecked(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryHelperChatHistoryItemSelectHelper.a(localObject2));
        localObject1 = paramView;
      }
      else
      {
        ((ChatHistoryC2CLinkAdapter.HistoryStructItemHolder)localObject1).jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(8);
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
          paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558793, null);
          localObject1 = new ChatHistoryC2CLinkAdapter.DividerViewHolder();
          ((ChatHistoryC2CLinkAdapter.DividerViewHolder)localObject1).jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)paramView.findViewById(2131369353));
          ((ChatHistoryC2CLinkAdapter.DividerViewHolder)localObject1).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378615));
          paramView.setTag(localObject1);
          paramView.setOnClickListener(new ChatHistoryC2CLinkAdapter.1(this, (ChatHistoryC2CLinkAdapter.DividerViewHolder)localObject1));
        }
        ((ChatHistoryC2CLinkAdapter.DividerViewHolder)localObject1).jdField_a_of_type_AndroidWidgetCheckBox.setChecked(((Boolean)this.jdField_a_of_type_AndroidSupportV4UtilArrayMap.get(localObject2)).booleanValue() ^ true);
        ((ChatHistoryC2CLinkAdapter.DividerViewHolder)localObject1).jdField_a_of_type_AndroidWidgetTextView.setText((String)localObject2);
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
        paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558794, null);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryC2CLinkAdapter
 * JD-Core Version:    0.7.0.1
 */