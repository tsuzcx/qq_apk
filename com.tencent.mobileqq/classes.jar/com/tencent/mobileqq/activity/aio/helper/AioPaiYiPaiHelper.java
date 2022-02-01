package com.tencent.mobileqq.activity.aio.helper;

import android.app.Activity;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.ListAdapter;
import com.tencent.mobileqq.activity.aio.ChatItemBuilder.BaseHolder;
import com.tencent.mobileqq.activity.aio.avatardoubletap.DoubleTapEffect;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.graytip.UniteEntity;
import com.tencent.mobileqq.graytip.UniteEntity.Note;
import com.tencent.mobileqq.graytip.UniteGrayTipUtil;
import com.tencent.mobileqq.paiyipai.PaiYiPaiObserver;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.vas.avatar.VasAvatar;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class AioPaiYiPaiHelper
  implements ILifeCycleHelper
{
  private ViewTreeObserver.OnPreDrawListener jdField_a_of_type_AndroidViewViewTreeObserver$OnPreDrawListener = new AioPaiYiPaiHelper.PaiYiPaiOnPreDrawListener(this);
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
  private PaiYiPaiObserver jdField_a_of_type_ComTencentMobileqqPaiyipaiPaiYiPaiObserver = new PaiYiPaiObserver();
  
  public AioPaiYiPaiHelper(HelperProvider paramHelperProvider, BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
  }
  
  private int a(ChatXListView paramChatXListView, String paramString)
  {
    int i = paramChatXListView.getChildCount() - 1;
    if (i >= 0)
    {
      View localView = paramChatXListView.getChildAt(i);
      if (localView == null) {}
      for (;;)
      {
        i -= 1;
        break;
        Object localObject = localView.getTag();
        if (((localObject instanceof ChatItemBuilder.BaseHolder)) && (TextUtils.equals(((ChatItemBuilder.BaseHolder)localObject).a.senderuin, paramString)))
        {
          localView = localView.findViewById(2131364643);
          if ((localView != null) && (localView.isShown()))
          {
            localObject = new int[2];
            localView.getLocationOnScreen((int[])localObject);
            Activity localActivity = a(localView);
            if ((localObject[0] + localView.getWidth() >= 0) && (localObject[0] <= localActivity.getResources().getDisplayMetrics().widthPixels))
            {
              int j = localObject[1];
              if ((localView.getHeight() + j >= 0) && (localObject[1] <= localActivity.getResources().getDisplayMetrics().heightPixels)) {
                break label214;
              }
            }
            if (QLog.isColorLevel()) {
              QLog.d("AioPaiYiPaiHelper", 2, "getAvatarIndex() called with: location = [" + Arrays.toString((int[])localObject) + "], not shown");
            }
          }
        }
      }
      label214:
      return i;
    }
    return -1;
  }
  
  private Activity a(View paramView)
  {
    for (paramView = paramView.getContext(); ((paramView instanceof ContextWrapper)) && (!(paramView instanceof Activity)); paramView = ((ContextWrapper)paramView).getBaseContext()) {}
    return (Activity)paramView;
  }
  
  private String a(ChatXListView paramChatXListView, ListAdapter paramListAdapter, Integer paramInteger)
  {
    paramChatXListView = (MessageForUniteGrayTip)paramListAdapter.getItem(paramInteger.intValue());
    if (paramChatXListView.entity == null) {
      UniteGrayTipUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatXListView);
    }
    paramChatXListView = paramChatXListView.entity;
    if (paramChatXListView == null)
    {
      QLog.e("AioPaiYiPaiHelper", 1, "getPlayPaiYiPaiAvatars() entity == null");
      paramInteger = "";
      return paramInteger;
    }
    paramListAdapter = paramChatXListView.a().a();
    int i = -1;
    paramChatXListView = "";
    int j = 0;
    label71:
    if (j < paramListAdapter.size())
    {
      paramInteger = (UniteEntity.Note)paramListAdapter.get(j);
      if (paramInteger.a() == 4) {}
    }
    for (;;)
    {
      j += 1;
      break label71;
      i += 1;
      if (i == 0) {
        paramChatXListView = (String)paramInteger.a().get(Integer.valueOf(6));
      }
      if (i == 1) {
        for (paramListAdapter = (String)paramInteger.a().get(Integer.valueOf(6));; paramListAdapter = "")
        {
          if (QLog.isColorLevel()) {
            QLog.d("AioPaiYiPaiHelper", 2, "getPlayPaiYiPaiAvatars() fromUin = [" + paramChatXListView + "], toUin = [" + paramListAdapter + "]");
          }
          if (TextUtils.equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a().getCurrentUin(), paramListAdapter))
          {
            paramInteger = paramListAdapter;
            if (!TextUtils.equals(paramChatXListView, paramListAdapter)) {
              break;
            }
            if (QLog.isColorLevel()) {
              QLog.d("AioPaiYiPaiHelper", 2, "getPlayPaiYiPaiAvatars() play myself");
            }
            return "";
          }
          if (QLog.isColorLevel()) {
            QLog.d("AioPaiYiPaiHelper", 2, "getPlayPaiYiPaiAvatars() for not at Me");
          }
          return "";
        }
      }
    }
  }
  
  private List<Integer> a(ChatXListView paramChatXListView, ListAdapter paramListAdapter)
  {
    paramChatXListView = new ArrayList();
    int i = paramListAdapter.getCount() - 1;
    if (i >= 0)
    {
      Object localObject = paramListAdapter.getItem(i);
      if (!(localObject instanceof ChatMessage)) {}
      for (;;)
      {
        i -= 1;
        break;
        localObject = (ChatMessage)localObject;
        if ((localObject instanceof MessageForUniteGrayTip))
        {
          localObject = (MessageForUniteGrayTip)localObject;
          if (!TextUtils.equals(((MessageForUniteGrayTip)localObject).getExtInfoFromExtStr("pai_yi_pai_showed"), "1"))
          {
            a((MessageForUniteGrayTip)localObject);
            String str = ((MessageForUniteGrayTip)localObject).getExtInfoFromExtStr("uint64_busi_type");
            if (QLog.isColorLevel()) {
              QLog.d("AioPaiYiPaiHelper", 2, "getPendingShowPaiYiPaiMsgs() called with: businessType = [" + str + "]");
            }
            if (TextUtils.equals(str, "12"))
            {
              localObject = ((MessageForUniteGrayTip)localObject).getExtInfoFromExtStr("uint64_busi_id");
              if (QLog.isColorLevel()) {
                QLog.d("AioPaiYiPaiHelper", 2, "getPendingShowPaiYiPaiMsgs() called with: businessId = [" + (String)localObject + "]");
              }
              if (TextUtils.equals((CharSequence)localObject, "1061"))
              {
                if (QLog.isColorLevel()) {
                  QLog.d("AioPaiYiPaiHelper", 2, "getPendingShowPaiYiPaiMsgs() called with: position = [" + i + "] pending show");
                }
                paramChatXListView.add(Integer.valueOf(i));
              }
            }
          }
        }
      }
    }
    return paramChatXListView;
  }
  
  private List<Integer> a(List<Integer> paramList, ChatXListView paramChatXListView, ListAdapter paramListAdapter)
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramList.size())
    {
      Integer localInteger = (Integer)paramList.get(i);
      String str = a(paramChatXListView, paramListAdapter, localInteger);
      int j = a(paramChatXListView, str);
      if (QLog.isColorLevel()) {
        QLog.d("AioPaiYiPaiHelper", 2, "getPlayPaiYiPaiAvatars() called with: position = [" + localInteger + "], toUin = [" + str + "], index = [" + j + "]");
      }
      if ((j != -1) && (!localArrayList.contains(Integer.valueOf(j))))
      {
        if (QLog.isColorLevel()) {
          QLog.d("AioPaiYiPaiHelper", 2, "getPlayPaiYiPaiAvatars() called with: index = [" + j + "]");
        }
        localArrayList.add(Integer.valueOf(j));
      }
      i += 1;
    }
    return localArrayList;
  }
  
  private void a()
  {
    ChatXListView localChatXListView = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView;
    if (localChatXListView == null)
    {
      QLog.e("AioPaiYiPaiHelper", 1, "listView == null");
      return;
    }
    ListAdapter localListAdapter = localChatXListView.getAdapter();
    if (localListAdapter == null)
    {
      QLog.e("AioPaiYiPaiHelper", 1, "adapter == null");
      return;
    }
    a(a(a(localChatXListView, localListAdapter), localChatXListView, localListAdapter), localChatXListView);
  }
  
  private void a(MessageForUniteGrayTip paramMessageForUniteGrayTip)
  {
    int i = 1;
    paramMessageForUniteGrayTip.saveExtInfoToExtStr("pai_yi_pai_showed", "1");
    ThreadManagerV2.executeOnFileThread(new AioPaiYiPaiHelper.UpdateShowTask(this, paramMessageForUniteGrayTip));
    if (paramMessageForUniteGrayTip.istroop == 0) {}
    for (;;)
    {
      ReportController.b(null, "dc00898", "", "", "0X800B3A2", "0X800B3A2", i, 0, "", "", "", "");
      return;
      if (paramMessageForUniteGrayTip.istroop == 1) {
        i = 2;
      } else {
        i = 10;
      }
    }
  }
  
  private void a(List<Integer> paramList, ChatXListView paramChatXListView)
  {
    int i = 0;
    if (i < paramList.size())
    {
      View localView = paramChatXListView.getChildAt(((Integer)paramList.get(i)).intValue()).findViewById(2131364643);
      if (QLog.isColorLevel()) {
        QLog.d("AioPaiYiPaiHelper", 2, "playPaiYiPaiAnimation() called with: avatar = [" + localView + "]");
      }
      if (!(localView instanceof VasAvatar)) {}
      for (;;)
      {
        i += 1;
        break;
        if (!localView.isShown())
        {
          if (QLog.isColorLevel()) {
            QLog.d("AioPaiYiPaiHelper", 2, "playPaiYiPaiAnimation() called with: avatar not shown");
          }
        }
        else {
          new DoubleTapEffect((VasAvatar)localView).a();
        }
      }
    }
  }
  
  public String getTag()
  {
    return "AioPaiYiPaiHelper";
  }
  
  public int[] interestedIn()
  {
    return new int[] { 4, 14 };
  }
  
  public void onMoveToState(int paramInt)
  {
    ViewGroup localViewGroup = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a();
    switch (paramInt)
    {
    default: 
      return;
    case 4: 
      localViewGroup.getViewTreeObserver().addOnPreDrawListener(this.jdField_a_of_type_AndroidViewViewTreeObserver$OnPreDrawListener);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqPaiyipaiPaiYiPaiObserver);
      return;
    }
    localViewGroup.getViewTreeObserver().removeOnPreDrawListener(this.jdField_a_of_type_AndroidViewViewTreeObserver$OnPreDrawListener);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqPaiyipaiPaiYiPaiObserver);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.AioPaiYiPaiHelper
 * JD-Core Version:    0.7.0.1
 */