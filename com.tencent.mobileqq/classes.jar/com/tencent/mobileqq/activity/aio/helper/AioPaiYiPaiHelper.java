package com.tencent.mobileqq.activity.aio.helper;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.ListAdapter;
import com.tencent.imcore.message.QQMessageFacade;
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
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.paiyipai.PaiYiPaiObserver;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.vas.avatar.VasAvatar;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import mqq.os.MqqHandler;

public class AioPaiYiPaiHelper
  implements ILifeCycleHelper
{
  private Context jdField_a_of_type_AndroidContentContext;
  private ViewTreeObserver.OnPreDrawListener jdField_a_of_type_AndroidViewViewTreeObserver$OnPreDrawListener = new AioPaiYiPaiHelper.PaiYiPaiOnPreDrawListener(this);
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private PaiYiPaiObserver jdField_a_of_type_ComTencentMobileqqPaiyipaiPaiYiPaiObserver = new AioPaiYiPaiHelper.1(this);
  
  public AioPaiYiPaiHelper(HelperProvider paramHelperProvider, BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_AndroidContentContext = paramBaseChatPie.jdField_a_of_type_AndroidContentContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramBaseChatPie.a();
  }
  
  private int a(ChatXListView paramChatXListView, String paramString)
  {
    int i = paramChatXListView.getChildCount() - 1;
    while (i >= 0)
    {
      Object localObject1 = paramChatXListView.getChildAt(i);
      if (localObject1 != null)
      {
        Object localObject2 = ((View)localObject1).getTag();
        if (((localObject2 instanceof ChatItemBuilder.BaseHolder)) && (TextUtils.equals(((ChatItemBuilder.BaseHolder)localObject2).a.senderuin, paramString)))
        {
          localObject2 = ((View)localObject1).findViewById(2131364530);
          if ((localObject2 != null) && (((View)localObject2).isShown()))
          {
            localObject1 = new int[2];
            ((View)localObject2).getLocationOnScreen((int[])localObject1);
            Activity localActivity = a((View)localObject2);
            if ((localObject1[0] + ((View)localObject2).getWidth() >= 0) && (localObject1[0] <= localActivity.getResources().getDisplayMetrics().widthPixels) && (localObject1[1] + ((View)localObject2).getHeight() >= 0))
            {
              j = i;
              if (localObject1[1] <= localActivity.getResources().getDisplayMetrics().heightPixels) {
                break label238;
              }
            }
            if (QLog.isColorLevel())
            {
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("getAvatarIndex() called with: location = [");
              ((StringBuilder)localObject2).append(Arrays.toString((int[])localObject1));
              ((StringBuilder)localObject2).append("], not shown");
              QLog.d("AioPaiYiPaiHelper", 2, ((StringBuilder)localObject2).toString());
            }
          }
        }
      }
      i -= 1;
    }
    int j = -1;
    label238:
    return j;
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
      return "";
    }
    paramInteger = paramChatXListView.a().a();
    int j = -1;
    int i = 0;
    for (paramChatXListView = ""; i < paramInteger.size(); paramChatXListView = paramListAdapter)
    {
      UniteEntity.Note localNote = (UniteEntity.Note)paramInteger.get(i);
      if (localNote.a() != 4)
      {
        paramListAdapter = paramChatXListView;
      }
      else
      {
        int k = j + 1;
        if (k == 0) {
          paramChatXListView = (String)localNote.a().get(Integer.valueOf(6));
        }
        j = k;
        paramListAdapter = paramChatXListView;
        if (k == 1)
        {
          paramListAdapter = (String)localNote.a().get(Integer.valueOf(6));
          break label177;
        }
      }
      i += 1;
    }
    paramListAdapter = "";
    label177:
    if (QLog.isColorLevel())
    {
      paramInteger = new StringBuilder();
      paramInteger.append("getPlayPaiYiPaiAvatars() fromUin = [");
      paramInteger.append(paramChatXListView);
      paramInteger.append("], toUin = [");
      paramInteger.append(paramListAdapter);
      paramInteger.append("]");
      QLog.d("AioPaiYiPaiHelper", 2, paramInteger.toString());
    }
    if (TextUtils.equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a().getCurrentUin(), paramListAdapter))
    {
      if (TextUtils.equals(paramChatXListView, paramListAdapter))
      {
        if (QLog.isColorLevel())
        {
          QLog.d("AioPaiYiPaiHelper", 2, "getPlayPaiYiPaiAvatars() play myself");
          return "";
        }
      }
      else {
        return paramListAdapter;
      }
    }
    else if (QLog.isColorLevel()) {
      QLog.d("AioPaiYiPaiHelper", 2, "getPlayPaiYiPaiAvatars() for not at Me");
    }
    return "";
  }
  
  private List<Integer> a(ChatXListView paramChatXListView, ListAdapter paramListAdapter)
  {
    paramChatXListView = new ArrayList();
    int i = paramListAdapter.getCount() - 1;
    while (i >= 0)
    {
      Object localObject1 = paramListAdapter.getItem(i);
      if ((localObject1 instanceof ChatMessage))
      {
        localObject1 = (ChatMessage)localObject1;
        if ((localObject1 instanceof MessageForUniteGrayTip))
        {
          localObject1 = (MessageForUniteGrayTip)localObject1;
          if (!TextUtils.equals(((MessageForUniteGrayTip)localObject1).getExtInfoFromExtStr("pai_yi_pai_showed"), "1"))
          {
            a((MessageForUniteGrayTip)localObject1);
            Object localObject2 = ((MessageForUniteGrayTip)localObject1).getExtInfoFromExtStr("uint64_busi_type");
            if (QLog.isColorLevel())
            {
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("getPendingShowPaiYiPaiMsgs() called with: businessType = [");
              localStringBuilder.append((String)localObject2);
              localStringBuilder.append("]");
              QLog.d("AioPaiYiPaiHelper", 2, localStringBuilder.toString());
            }
            if (TextUtils.equals((CharSequence)localObject2, "12"))
            {
              localObject1 = ((MessageForUniteGrayTip)localObject1).getExtInfoFromExtStr("uint64_busi_id");
              if (QLog.isColorLevel())
              {
                localObject2 = new StringBuilder();
                ((StringBuilder)localObject2).append("getPendingShowPaiYiPaiMsgs() called with: businessId = [");
                ((StringBuilder)localObject2).append((String)localObject1);
                ((StringBuilder)localObject2).append("]");
                QLog.d("AioPaiYiPaiHelper", 2, ((StringBuilder)localObject2).toString());
              }
              if (TextUtils.equals((CharSequence)localObject1, "1061"))
              {
                if (QLog.isColorLevel())
                {
                  localObject1 = new StringBuilder();
                  ((StringBuilder)localObject1).append("getPendingShowPaiYiPaiMsgs() called with: position = [");
                  ((StringBuilder)localObject1).append(i);
                  ((StringBuilder)localObject1).append("] pending show");
                  QLog.d("AioPaiYiPaiHelper", 2, ((StringBuilder)localObject1).toString());
                }
                paramChatXListView.add(Integer.valueOf(i));
              }
            }
          }
        }
      }
      i -= 1;
    }
    return paramChatXListView;
  }
  
  private List<Integer> a(List<Integer> paramList, ChatXListView paramChatXListView, ListAdapter paramListAdapter)
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramList.size())
    {
      Object localObject = (Integer)paramList.get(i);
      String str = a(paramChatXListView, paramListAdapter, (Integer)localObject);
      int j = a(paramChatXListView, str);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getPlayPaiYiPaiAvatars() called with: position = [");
        localStringBuilder.append(localObject);
        localStringBuilder.append("], toUin = [");
        localStringBuilder.append(str);
        localStringBuilder.append("], index = [");
        localStringBuilder.append(j);
        localStringBuilder.append("]");
        QLog.d("AioPaiYiPaiHelper", 2, localStringBuilder.toString());
      }
      if ((j != -1) && (!localArrayList.contains(Integer.valueOf(j))))
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("getPlayPaiYiPaiAvatars() called with: index = [");
          ((StringBuilder)localObject).append(j);
          ((StringBuilder)localObject).append("]");
          QLog.d("AioPaiYiPaiHelper", 2, ((StringBuilder)localObject).toString());
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
    paramMessageForUniteGrayTip.saveExtInfoToExtStr("pai_yi_pai_showed", "1");
    ThreadManagerV2.executeOnFileThread(new AioPaiYiPaiHelper.UpdateShowTask(this, paramMessageForUniteGrayTip));
    int i;
    if (paramMessageForUniteGrayTip.istroop == 0) {
      i = 1;
    } else if (paramMessageForUniteGrayTip.istroop == 1) {
      i = 2;
    } else {
      i = 10;
    }
    ReportController.b(null, "dc00898", "", "", "0X800B3A2", "0X800B3A2", i, 0, "", "", "", "");
  }
  
  private void a(List<Integer> paramList, ChatXListView paramChatXListView)
  {
    int i = 0;
    while (i < paramList.size())
    {
      View localView = paramChatXListView.getChildAt(((Integer)paramList.get(i)).intValue()).findViewById(2131364530);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("playPaiYiPaiAnimation() called with: avatar = [");
        localStringBuilder.append(localView);
        localStringBuilder.append("]");
        QLog.d("AioPaiYiPaiHelper", 2, localStringBuilder.toString());
      }
      if ((localView instanceof VasAvatar)) {
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
      i += 1;
    }
  }
  
  private void b(ChatMessage paramChatMessage)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.c = new QQProgressDialog(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.c.a(this.jdField_a_of_type_AndroidContentContext.getString(2131694328));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.c.c(true);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.c.show();
    QQMessageFacade localQQMessageFacade = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().b(true);
    localQQMessageFacade.e(paramChatMessage);
    paramChatMessage = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a().obtainMessage(267387140, 1, 0);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a().sendMessageDelayed(paramChatMessage, 20000);
  }
  
  public void a(ChatMessage paramChatMessage)
  {
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800BAD4", "0X800BAD4", 0, 0, "", "", "", "");
    if (((paramChatMessage instanceof MessageForUniteGrayTip)) && (TextUtils.equals("1", ((MessageForUniteGrayTip)paramChatMessage).getExtInfoFromExtStr("pai_yi_pai_online_status")))) {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800BBDD", "0X800BBDD", 0, 0, "", "", "", "");
    }
    if (NetConnInfoCenter.getServerTimeMillis() - paramChatMessage.time * 1000L > 120000L)
    {
      DialogUtil.a(this.jdField_a_of_type_AndroidContentContext, 230).setMessage(this.jdField_a_of_type_AndroidContentContext.getString(2131694687)).setPositiveButton(17039370, new AioPaiYiPaiHelper.2(this)).show();
      return;
    }
    b(paramChatMessage);
  }
  
  public String getTag()
  {
    return "AioPaiYiPaiHelper";
  }
  
  public int[] interestedIn()
  {
    return new int[] { 4, 15 };
  }
  
  public void onMoveToState(int paramInt)
  {
    ViewGroup localViewGroup = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a();
    if (paramInt != 4)
    {
      if (paramInt != 15) {
        return;
      }
      localViewGroup.getViewTreeObserver().removeOnPreDrawListener(this.jdField_a_of_type_AndroidViewViewTreeObserver$OnPreDrawListener);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqPaiyipaiPaiYiPaiObserver);
      return;
    }
    localViewGroup.getViewTreeObserver().addOnPreDrawListener(this.jdField_a_of_type_AndroidViewViewTreeObserver$OnPreDrawListener);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqPaiyipaiPaiYiPaiObserver);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.AioPaiYiPaiHelper
 * JD-Core Version:    0.7.0.1
 */