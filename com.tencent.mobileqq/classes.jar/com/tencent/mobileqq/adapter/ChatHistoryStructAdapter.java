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
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ChatHistoryStructAdapter
  extends BaseAdapter
{
  Context jdField_a_of_type_AndroidContentContext;
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  ChatHistoryViewBase jdField_a_of_type_ComTencentMobileqqActivityChatHistoryViewBase;
  public ArrayList a;
  View.OnClickListener b;
  
  public ChatHistoryStructAdapter(Context paramContext, ArrayList paramArrayList, View.OnClickListener paramOnClickListener1, View.OnClickListener paramOnClickListener2, ChatHistoryViewBase paramChatHistoryViewBase)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener1;
    this.b = paramOnClickListener2;
    this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryViewBase = paramChatHistoryViewBase;
  }
  
  public static String a(AbsShareMsg paramAbsShareMsg, String paramString)
  {
    Object localObject1;
    Object localObject2;
    if (paramString.equals("cover"))
    {
      localObject1 = paramAbsShareMsg.mContentCover;
      localObject2 = localObject1;
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
              if (!localIterator.hasNext()) {
                return paramAbsShareMsg;
              }
              localObject2 = (AbsStructMsgElement)localIterator.next();
              if (!(localObject2 instanceof AbsStructMsgItem)) {
                break label214;
              }
              localObject1 = paramAbsShareMsg;
              if (((AbsStructMsgItem)localObject2).jdField_a_of_type_JavaUtilArrayList == null) {
                break label248;
              }
              localObject1 = paramAbsShareMsg;
              if (((AbsStructMsgItem)localObject2).jdField_a_of_type_JavaUtilArrayList.isEmpty()) {
                break label248;
              }
              localObject2 = ((AbsStructMsgItem)localObject2).jdField_a_of_type_JavaUtilArrayList.iterator();
              localObject1 = paramAbsShareMsg;
              label176:
              do
              {
                paramAbsShareMsg = (AbsShareMsg)localObject1;
                if (!((Iterator)localObject2).hasNext()) {
                  break;
                }
                paramAbsShareMsg = (AbsStructMsgElement)((Iterator)localObject2).next();
                if (!paramString.equals("cover")) {
                  break label206;
                }
                paramAbsShareMsg = StructMsgForGeneralShare.getCoverForChatHistory(paramAbsShareMsg);
                localObject1 = paramAbsShareMsg;
              } while (TextUtils.isEmpty(paramAbsShareMsg));
              localObject1 = paramAbsShareMsg;
              if (TextUtils.isEmpty(paramAbsShareMsg)) {
                break label248;
              }
              localObject2 = paramAbsShareMsg;
            }
          }
        }
      }
    }
    label206:
    label214:
    label228:
    do
    {
      return localObject2;
      localObject1 = paramAbsShareMsg.mContentTitle;
      break;
      paramAbsShareMsg = StructMsgForGeneralShare.getTitleForChatHistory(paramAbsShareMsg);
      break label176;
      if (!paramString.equals("cover")) {
        break label240;
      }
      paramAbsShareMsg = StructMsgForGeneralShare.getCoverForChatHistory((AbsStructMsgElement)localObject2);
      localObject2 = paramAbsShareMsg;
    } while (!TextUtils.isEmpty(paramAbsShareMsg));
    for (;;)
    {
      break;
      label240:
      paramAbsShareMsg = StructMsgForGeneralShare.getTitleForChatHistory((AbsStructMsgElement)localObject2);
      break label228;
      label248:
      paramAbsShareMsg = (AbsShareMsg)localObject1;
    }
    return paramAbsShareMsg;
  }
  
  public static boolean a(MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord instanceof MessageForStructing))
    {
      Object localObject = ((MessageForStructing)paramMessageRecord).structingMsg;
      if (localObject == null) {
        ((MessageForStructing)paramMessageRecord).parse();
      }
      if (AnonymousChatHelper.a(paramMessageRecord)) {
        return false;
      }
      if (localObject != null)
      {
        if ((((AbsStructMsg)localObject).fwFlag == 1) || (((AbsStructMsg)localObject).hasFlag(1))) {
          return false;
        }
        if ((localObject instanceof StructMsgForAudioShare)) {
          return true;
        }
        if ((localObject instanceof StructMsgForGeneralShare))
        {
          paramMessageRecord = a((StructMsgForGeneralShare)localObject, "cover");
          localObject = a((StructMsgForGeneralShare)localObject, "title");
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
    Object localObject = this.jdField_a_of_type_AndroidContentContext.getResources();
    String str = a(paramAbsShareMsg, "cover");
    int i = 2130845965;
    if ((paramAbsShareMsg instanceof StructMsgForAudioShare)) {
      i = 2130845974;
    }
    localObject = ((Resources)localObject).getDrawable(i);
    if (TextUtils.isEmpty(str))
    {
      paramURLImageView.setImageDrawable((Drawable)localObject);
      return;
    }
    if ((!str.startsWith("http://")) && (!str.startsWith("https://"))) {}
    for (paramAbsShareMsg = Uri.fromFile(new File(str)).toString();; paramAbsShareMsg = str)
    {
      paramURLImageView.setImageDrawable(URLDrawable.getDrawable(paramAbsShareMsg, (Drawable)localObject, (Drawable)localObject));
      return;
    }
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList != null) {
      return this.jdField_a_of_type_JavaUtilArrayList.size();
    }
    return 0;
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
      localObject1 = (MessageForStructing)localObject2;
      if ((paramView != null) && ((paramView.getTag() instanceof ChatHistoryStructAdapter.HistoryStructItemHolder)))
      {
        paramViewGroup = (ChatHistoryStructAdapter.HistoryStructItemHolder)paramView.getTag();
        paramViewGroup.jdField_a_of_type_JavaLangObject = localObject1;
        paramViewGroup.jdField_a_of_type_JavaLangString = ((ChatHistoryStructMsgView)this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryViewBase).c;
        if (!(localObject1 instanceof MessageForStructing)) {
          break label304;
        }
        if (localObject1 == null) {
          ((MessageForStructing)localObject1).parse();
        }
        if ((((MessageForStructing)localObject1).structingMsg != null) && ((((MessageForStructing)localObject1).structingMsg instanceof AbsShareMsg)))
        {
          localObject2 = (AbsShareMsg)((MessageForStructing)localObject1).structingMsg;
          a(paramViewGroup.jdField_a_of_type_ComTencentImageURLImageView, (AbsShareMsg)localObject2);
          paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(a((AbsShareMsg)localObject2, "title"));
          paramViewGroup.b.setText(((AbsShareMsg)localObject2).mSourceName);
        }
        label147:
        if (!this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryViewBase.a()) {
          break label327;
        }
        paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(0);
        paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryViewBase.a.a((ChatMessage)localObject1));
        paramViewGroup = paramView;
      }
    }
    label304:
    label327:
    do
    {
      return paramViewGroup;
      paramViewGroup = new ChatHistoryStructAdapter.HistoryStructItemHolder(this);
      paramView = View.inflate(this.jdField_a_of_type_AndroidContentContext, 2130971548, null);
      paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131374988));
      paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)paramView.findViewById(2131374989));
      paramViewGroup.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131374991));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131363618));
      paramViewGroup.b = ((TextView)paramView.findViewById(2131374992));
      paramView.setTag(paramViewGroup);
      paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout.setTag(paramViewGroup);
      paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      break;
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText("");
      paramViewGroup.b.setText("");
      break label147;
      paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(8);
      return paramView;
      paramViewGroup = paramView;
    } while (!(localObject2 instanceof String));
    if ((paramView != null) && ((paramView.getTag() instanceof TextView)))
    {
      localObject1 = (TextView)paramView.getTag();
      paramViewGroup = paramView;
      paramView = (View)localObject1;
    }
    for (;;)
    {
      paramView.setText((String)localObject2);
      return paramViewGroup;
      paramViewGroup = View.inflate(this.jdField_a_of_type_AndroidContentContext, 2130971549, null);
      paramView = (TextView)paramViewGroup.findViewById(2131365531);
      paramViewGroup.setTag(paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.adapter.ChatHistoryStructAdapter
 * JD-Core Version:    0.7.0.1
 */