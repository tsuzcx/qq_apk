package com.tencent.biz.qqstory.storyHome.messagenotify;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.TextView;
import com.tencent.biz.ProtoUtils;
import com.tencent.biz.ProtoUtils.StoryProtocolObserver;
import com.tencent.biz.TroopRedpoint.TroopRedTouchHandler;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.boundaries.StoryApi;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.UserManager;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.model.item.QQUserUIItem.UserID;
import com.tencent.biz.qqstory.network.handler.GetUserInfoHandler;
import com.tencent.biz.qqstory.network.pb.qqstory_710_del_message.ReqDelAllMessage;
import com.tencent.biz.qqstory.network.pb.qqstory_710_del_message.ReqDelOneMessage;
import com.tencent.biz.qqstory.network.pb.qqstory_710_message.ReqStoryMessageList;
import com.tencent.biz.qqstory.notification.StoryMsgNotification;
import com.tencent.biz.qqstory.playmode.util.PlayModeUtils;
import com.tencent.biz.qqstory.playvideo.QQStoryWarningActivity;
import com.tencent.biz.qqstory.playvideo.StoryPlayVideoActivity;
import com.tencent.biz.qqstory.shareGroup.infocard.QQStoryShareGroupProfileActivity;
import com.tencent.biz.qqstory.storyHome.QQStoryBaseActivity;
import com.tencent.biz.qqstory.storyHome.detail.model.SpannableStringUtils;
import com.tencent.biz.qqstory.storyHome.detail.view.StoryDetailActivity;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.service.message.MessageUtils;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.text.QQTextBuilder;
import com.tencent.mobileqq.utils.BubbleContextMenu;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;
import com.tencent.widget.AdapterView.OnItemLongClickListener;
import com.tencent.widget.BubblePopupWindow;
import com.tencent.widget.SwipListView;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import nxu;
import nxv;
import nxw;
import nxz;
import nya;
import nyb;
import nyc;
import nyd;
import nyf;
import nyg;

public class StoryMessageListActivity
  extends QQStoryBaseActivity
  implements View.OnClickListener, AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener
{
  protected int a;
  protected long a;
  protected View a;
  protected TextView a;
  protected ProtoUtils.StoryProtocolObserver a;
  public StoryMessageListActivity.StoryMessageListAdapter a;
  protected QQAppInterface a;
  protected QQCustomDialog a;
  protected QQCustomMenu a;
  protected BubblePopupWindow a;
  protected SwipListView a;
  protected String a;
  protected ArrayList a;
  protected boolean a;
  protected int b;
  protected View b;
  protected ProtoUtils.StoryProtocolObserver b;
  protected boolean b;
  protected int c;
  protected ProtoUtils.StoryProtocolObserver c;
  protected boolean c;
  
  public StoryMessageListActivity()
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_b_of_type_Int = 4;
    this.jdField_a_of_type_Long = -1L;
    this.jdField_c_of_type_Int = 0;
    this.jdField_c_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentBizProtoUtils$StoryProtocolObserver = new nxu(this);
    this.jdField_b_of_type_ComTencentBizProtoUtils$StoryProtocolObserver = new nxv(this);
    this.jdField_c_of_type_ComTencentBizProtoUtils$StoryProtocolObserver = new nxw(this);
  }
  
  protected CharSequence a(MessageData paramMessageData)
  {
    if (paramMessageData.jdField_a_of_type_Int == 2) {}
    Object localObject;
    for (paramMessageData = paramMessageData.jdField_e_of_type_JavaLangString;; paramMessageData = (MessageData)localObject)
    {
      localObject = paramMessageData;
      if (com.tencent.mobileqq.text.TextUtils.a(paramMessageData.toString())) {
        localObject = new QQText(MessageUtils.b(paramMessageData.toString()), 3, 14);
      }
      return localObject;
      localObject = new SpannableStringBuilder("回复");
      int i = ((SpannableStringBuilder)localObject).length();
      ((SpannableStringBuilder)localObject).append(PlayModeUtils.a(paramMessageData.jdField_d_of_type_JavaLangString));
      ((SpannableStringBuilder)localObject).setSpan(new ForegroundColorSpan(this.app.getApp().getResources().getColor(2131494214)), i, ((SpannableStringBuilder)localObject).length(), 33);
      ((SpannableStringBuilder)localObject).append(':').append(paramMessageData.jdField_e_of_type_JavaLangString);
    }
  }
  
  public String a()
  {
    if (this.jdField_c_of_type_Int == 0) {
      return "play_video";
    }
    if (this.jdField_c_of_type_Int == 1) {
      return "memory";
    }
    return "";
  }
  
  protected void a()
  {
    if (this.jdField_b_of_type_Int == 1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.msgList", 2, "already loading");
      }
      return;
    }
    this.jdField_b_of_type_Int = 1;
    qqstory_710_message.ReqStoryMessageList localReqStoryMessageList = new qqstory_710_message.ReqStoryMessageList();
    localReqStoryMessageList.num.set(20);
    localReqStoryMessageList.start_time.set(this.jdField_a_of_type_Int);
    localReqStoryMessageList.source.set(this.jdField_c_of_type_Int);
    localReqStoryMessageList.version_ctrl.set(760);
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.msgList", 2, "fetch message list, start=" + this.jdField_a_of_type_Int);
    }
    ProtoUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_c_of_type_ComTencentBizProtoUtils$StoryProtocolObserver, localReqStoryMessageList.toByteArray(), StoryApi.a("StorySvc.get_710_message_list"));
  }
  
  public void a(int paramInt)
  {
    if (!AppNetConnInfo.isNetSupport()) {}
    do
    {
      QQToast.a(getApplicationContext(), 1, "网络异常，请重试", 0).a();
      do
      {
        return;
      } while (!this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity$StoryMessageListAdapter.a(paramInt));
      MessageData localMessageData = (MessageData)this.jdField_a_of_type_JavaUtilArrayList.remove(paramInt);
      if (QLog.isColorLevel()) {
        QLog.i("Q.qqstory.msgList", 2, "doDeleteMessage pos=" + paramInt + " vid=" + localMessageData.jdField_b_of_type_JavaLangString + " type=" + localMessageData.jdField_a_of_type_Int + " cid=" + localMessageData.jdField_c_of_type_Int);
      }
      qqstory_710_del_message.ReqDelOneMessage localReqDelOneMessage = new qqstory_710_del_message.ReqDelOneMessage();
      localReqDelOneMessage.feed_id.set(ByteStringMicro.copyFromUtf8(localMessageData.jdField_f_of_type_JavaLangString));
      localReqDelOneMessage.message_id.set(localMessageData.jdField_d_of_type_Int);
      ProtoUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_ComTencentBizProtoUtils$StoryProtocolObserver, localReqDelOneMessage.toByteArray(), StoryApi.a("StorySvc.del_710_one_message"));
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity$StoryMessageListAdapter.notifyDataSetChanged();
    } while (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity$StoryMessageListAdapter.getCount() != 0);
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131434680);
    this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(0, 2130839525, 0, 0);
    this.jdField_a_of_type_AndroidWidgetTextView.setClickable(false);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    setRightViewTextDisable(0);
  }
  
  protected void a(MessageData paramMessageData, View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.msgList", 2, "click item type=" + paramMessageData.jdField_a_of_type_Int);
    }
    switch (paramMessageData.jdField_a_of_type_Int)
    {
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  return;
                  if (paramMessageData.jdField_a_of_type_Boolean)
                  {
                    paramMessageData = new Intent(this, QQStoryWarningActivity.class);
                    paramMessageData.putExtra("tipsResource", "该视频已被删除");
                    startActivity(paramMessageData);
                    return;
                  }
                  StoryPlayVideoActivity.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this, paramMessageData.jdField_c_of_type_JavaLangString, paramMessageData.m, paramMessageData.jdField_b_of_type_JavaLangString, paramMessageData.jdField_f_of_type_JavaLangString, paramView);
                  return;
                  if (paramMessageData.jdField_f_of_type_Int != 0) {
                    break;
                  }
                  paramView = new Intent(this, QQBrowserActivity.class);
                  paramView.putExtra("url", paramMessageData.i);
                  startActivity(paramView);
                } while (!QLog.isColorLevel());
                QLog.d("Q.qqstory.msgList", 2, "StoryMessageListActivity#onItemClick() TYPE_OFFICIAL open webview!");
                return;
                if (paramMessageData.jdField_f_of_type_Int != 1) {
                  break;
                }
                paramView = new Intent(this, JumpActivity.class);
                paramView.setData(Uri.parse(paramMessageData.i));
                startActivity(paramView);
              } while (!QLog.isColorLevel());
              QLog.d("Q.qqstory.msgList", 2, "StoryMessageListActivity#onItemClick() TYPE_OFFICIAL open jumpActivity!");
              return;
            } while (!QLog.isColorLevel());
            QLog.e("Q.qqstory.msgList", 2, "StoryMessageListActivity#onItemClick() unknow url_type = " + paramMessageData.jdField_f_of_type_Int);
            return;
            QQStoryShareGroupProfileActivity.a(this, 2, paramMessageData.m, null, 7, 0);
            return;
            paramMessageData = ((UserManager)SuperManager.a(2)).a();
            if (paramMessageData != null) {
              break;
            }
          } while (!QLog.isColorLevel());
          QLog.e("Q.qqstory.msgList", 2, "self user item == null");
          return;
          paramMessageData = paramMessageData.getUserIconJumpURL();
          if (!android.text.TextUtils.isEmpty(paramMessageData)) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.e("Q.qqstory.msgList", 2, "jumpUrl is empty");
        return;
        paramView = new Intent(this, QQBrowserActivity.class);
        paramView.putExtra("url", paramMessageData);
        startActivity(paramView);
        return;
        StoryDetailActivity.a(this, paramMessageData.jdField_f_of_type_JavaLangString, 23, paramMessageData.jdField_c_of_type_Int, 0, paramMessageData.jdField_b_of_type_Int);
        return;
        StoryDetailActivity.a(this, paramMessageData.jdField_f_of_type_JavaLangString, 23, 0, paramMessageData.jdField_b_of_type_Int);
        return;
        QQToast.a(this, -1, "你不是该圈子成员，无法查看", 0).a();
        return;
        paramView = new StringBuilder("http://story.now.qq.com/m/vote/index.html?_wv=3&_nav_alpha=0");
        paramView.append("&vid=").append(paramMessageData.jdField_b_of_type_JavaLangString);
        SLog.a("Q.qqstory.msgList", "go to story vote detail web. url = %s.", paramView.toString());
        paramMessageData = new Intent(this, QQBrowserActivity.class);
        paramMessageData.putExtra("url", paramView.toString());
        startActivity(paramMessageData);
      } while (!QLog.isColorLevel());
      QLog.d("Q.qqstory.msgList", 2, "StoryMessageListActivity#onItemClick() TYPE_ANSWER_MY_VOTE open webview!");
      return;
      paramView = new StringBuilder("http://story.now.qq.com/m/score/index.html?_wv=3&_nav_alpha=0");
      paramView.append("&vid=").append(paramMessageData.jdField_b_of_type_JavaLangString);
      SLog.a("Q.qqstory.msgList", "go to story grade detail web. url = %s.", paramView.toString());
      paramMessageData = new Intent(this, QQBrowserActivity.class);
      paramMessageData.putExtra("url", paramView.toString());
      paramMessageData.putExtra("startOpenPageTime", System.currentTimeMillis());
      startActivity(paramMessageData);
    } while (!QLog.isColorLevel());
    QLog.d("Q.qqstory.msgList", 2, "StoryMessageListActivity#onItemClick() TYPE_ANSWER_MY_GRADE open webview!");
  }
  
  public void a(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    Object localObject;
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity$StoryMessageListAdapter.a(paramInt))
    {
      localObject = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity$StoryMessageListAdapter.a(paramInt);
      if (localObject == null) {
        return;
      }
      a((MessageData)localObject, paramView);
      switch (((MessageData)localObject).jdField_e_of_type_Int)
      {
      default: 
        paramInt = 0;
        switch (((MessageData)localObject).jdField_a_of_type_Int)
        {
        default: 
          paramAdapterView = "";
          label155:
          if (!((MessageData)localObject).jdField_a_of_type_Boolean) {}
          break;
        }
        break;
      }
    }
    for (paramView = "4";; paramView = "1")
    {
      localObject = ((UserManager)SuperManager.a(2)).b(QQStoryContext.a().b());
      if ((localObject != null) && (((QQUserUIItem)localObject).isVip))
      {
        i = 1;
        label201:
        if (i == 0) {
          break label472;
        }
      }
      label472:
      for (int i = 1;; i = 2)
      {
        StoryReportor.a("play_video", "clk_msg", i, paramInt, new String[] { paramAdapterView, paramView, this.jdField_a_of_type_JavaLangString, "" });
        return;
        paramAdapterView = ((UserManager)SuperManager.a(2)).b(((MessageData)localObject).jdField_a_of_type_JavaLangString);
        if ((paramAdapterView != null) && (paramAdapterView.isFriend()))
        {
          paramInt = 1;
          break;
        }
        if ((paramAdapterView != null) && (paramAdapterView.isSubscribe()))
        {
          paramInt = 2;
          break;
        }
        paramInt = 4;
        break;
        paramInt = 3;
        break;
        if (((MessageData)localObject).g == 0) {}
        for (paramInt = 6;; paramInt = 5) {
          break;
        }
        paramInt = 7;
        break;
        paramInt = 8;
        break;
        paramInt = 9;
        break;
        if (QQStoryContext.a().a(((MessageData)localObject).jdField_c_of_type_JavaLangString)) {}
        for (paramAdapterView = "2";; paramAdapterView = "4") {
          break;
        }
        if (QQStoryContext.a().a(((MessageData)localObject).jdField_c_of_type_JavaLangString)) {}
        for (paramAdapterView = "1";; paramAdapterView = "4") {
          break;
        }
        if (QQStoryContext.a().a(((MessageData)localObject).jdField_d_of_type_JavaLangString)) {}
        for (paramAdapterView = "3";; paramAdapterView = "4") {
          break;
        }
        paramAdapterView = "6";
        break label155;
        paramAdapterView = "7";
        break label155;
        paramAdapterView = "8";
        break label155;
        paramAdapterView = "9";
        break label155;
        paramAdapterView = "10";
        break label155;
        paramAdapterView = "11";
        break label155;
        i = 0;
        break label201;
      }
      if (this.jdField_b_of_type_Int == 3) {
        if (QLog.isColorLevel()) {
          QLog.d("Q.qqstory.msgList", 2, "click retry");
        }
      }
      while (this.jdField_b_of_type_Int != 2)
      {
        this.jdField_b_of_type_Boolean = true;
        b(this.jdField_a_of_type_JavaUtilArrayList.size());
        return;
      }
      if (this.jdField_c_of_type_Int == 2) {}
      for (this.jdField_c_of_type_Int = 3;; this.jdField_c_of_type_Int = 1)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.qqstory.msgList", 2, "convert to list");
        }
        StoryReportor.a("play_video", "clk_more", 0, 0, new String[] { "", "", "", "" });
        break;
      }
    }
  }
  
  public void a(List paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {}
    ArrayList localArrayList;
    do
    {
      return;
      UserManager localUserManager = (UserManager)SuperManager.a(2);
      localArrayList = new ArrayList();
      HashSet localHashSet = new HashSet();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        MessageData localMessageData = (MessageData)paramList.next();
        String[] arrayOfString = new String[3];
        arrayOfString[0] = localMessageData.jdField_a_of_type_JavaLangString;
        arrayOfString[1] = localMessageData.jdField_c_of_type_JavaLangString;
        arrayOfString[2] = localMessageData.jdField_d_of_type_JavaLangString;
        int j = arrayOfString.length;
        int i = 0;
        while (i < j)
        {
          localMessageData = arrayOfString[i];
          if (!android.text.TextUtils.isEmpty(localMessageData))
          {
            QQUserUIItem localQQUserUIItem = localUserManager.b(localMessageData);
            if (((localQQUserUIItem == null) || (!localQQUserUIItem.isAvailable())) && (!localHashSet.contains(localMessageData)))
            {
              localArrayList.add(new QQUserUIItem.UserID("", localMessageData));
              localHashSet.add(localMessageData);
            }
          }
          i += 1;
        }
      }
      localHashSet.clear();
    } while (localArrayList.isEmpty());
    new GetUserInfoHandler().a(1, localArrayList);
  }
  
  public void a(List paramList, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.msgList", 2, "onUpdate size=" + paramList.size() + ", end=" + paramBoolean1);
    }
    Object localObject;
    int i;
    if (this.jdField_a_of_type_JavaUtilArrayList.size() == 0)
    {
      if (paramList.size() > 0)
      {
        this.jdField_a_of_type_Long = ((MessageData)paramList.get(0)).jdField_a_of_type_Long;
        this.jdField_a_of_type_AndroidViewView.setVisibility(8);
        localObject = ((UserManager)SuperManager.a(2)).b(QQStoryContext.a().b());
        if ((localObject == null) || (!((QQUserUIItem)localObject).isVip)) {
          break label363;
        }
        i = 1;
        label126:
        if (this.jdField_c_of_type_Int != 0) {
          break label375;
        }
        if (i == 0) {
          break label369;
        }
        i = 1;
        label141:
        StoryReportor.a("play_video", "exp_notice", i, 0, new String[] { "1", "", "", "" });
      }
    }
    else
    {
      label177:
      a(paramList);
      this.jdField_a_of_type_JavaUtilArrayList.addAll(paramList);
      i = paramList.size();
      if ((!paramBoolean1) && (i != 0)) {
        break label442;
      }
      this.jdField_b_of_type_Int = 2;
      c();
    }
    for (;;)
    {
      if (i > 0)
      {
        this.jdField_a_of_type_Int = ((int)(((MessageData)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_JavaUtilArrayList.size() - 1)).jdField_a_of_type_Long / 1000L) - 1);
        setRightViewTextDisable(1);
      }
      this.jdField_c_of_type_Boolean = paramBoolean2;
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity$StoryMessageListAdapter.notifyDataSetChanged();
      return;
      if (((this.jdField_c_of_type_Int == 0) || (this.jdField_c_of_type_Int == 2)) && (paramBoolean2))
      {
        this.jdField_a_of_type_AndroidViewView.setVisibility(8);
        break;
      }
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131434680);
      this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(0, 2130839525, 0, 0);
      this.jdField_a_of_type_AndroidWidgetTextView.setClickable(false);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      break;
      label363:
      i = 0;
      break label126;
      label369:
      i = 2;
      break label141;
      label375:
      if (this.jdField_c_of_type_Int != 1) {
        break label177;
      }
      if (paramList.size() > 0) {}
      for (localObject = "2";; localObject = "1")
      {
        StoryReportor.a("memory", "exp_msg", 0, 0, new String[] { localObject, "", "", "" });
        break;
      }
      label442:
      this.jdField_b_of_type_Int = 4;
    }
  }
  
  protected void a(@NonNull Map paramMap)
  {
    super.a(paramMap);
    paramMap.put(new nyg(this), "");
    paramMap.put(new nyf(this), "");
  }
  
  public boolean a(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity$StoryMessageListAdapter.a(paramInt))
    {
      if ((this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow != null) && (this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.b())) {
        this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.a();
      }
      paramView.setSelected(true);
      if (this.jdField_a_of_type_ComTencentMobileqqUtilsDialogutilsQQCustomMenu == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqUtilsDialogutilsQQCustomMenu = new QQCustomMenu();
        this.jdField_a_of_type_ComTencentMobileqqUtilsDialogutilsQQCustomMenu.a(2131375620, "删除");
      }
      this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow = BubbleContextMenu.a(paramView, this.jdField_a_of_type_ComTencentMobileqqUtilsDialogutilsQQCustomMenu, new nyb(this, paramInt), new nyc(this, paramView));
      return true;
    }
    return false;
  }
  
  protected CharSequence b(MessageData paramMessageData)
  {
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder("发起了投票：");
    int i = localSpannableStringBuilder.length();
    localSpannableStringBuilder.append(paramMessageData.n);
    localSpannableStringBuilder.setSpan(new ForegroundColorSpan(this.app.getApp().getResources().getColor(2131494214)), i, localSpannableStringBuilder.length(), 33);
    SLog.b("Q.qqstory.msgList", "get vote publish string : %s, voteQuestion : %s.", localSpannableStringBuilder, paramMessageData.n);
    paramMessageData = localSpannableStringBuilder;
    if (com.tencent.mobileqq.text.TextUtils.a(localSpannableStringBuilder.toString())) {
      paramMessageData = new QQText(MessageUtils.b(localSpannableStringBuilder.toString()), 3, 14);
    }
    return paramMessageData;
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.msgList", 2, "onError");
    }
    this.jdField_b_of_type_Int = 3;
    if (this.jdField_a_of_type_JavaUtilArrayList.size() == 0)
    {
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView.setText("加载失败，点击重试");
      this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(0, 2130843566, 0, 0);
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      if (this.jdField_c_of_type_Int == 0)
      {
        QQUserUIItem localQQUserUIItem = ((UserManager)SuperManager.a(2)).b(QQStoryContext.a().b());
        if ((localQQUserUIItem == null) || (!localQQUserUIItem.isVip)) {
          break label176;
        }
        i = 1;
        if (i == 0) {
          break label181;
        }
      }
    }
    label176:
    label181:
    for (int i = 1;; i = 2)
    {
      StoryReportor.a("play_video", "exp_notice", i, 0, new String[] { "2", "", "", "" });
      b(this.jdField_a_of_type_JavaUtilArrayList.size());
      return;
      i = 0;
      break;
    }
  }
  
  protected void b(int paramInt)
  {
    int i = this.jdField_a_of_type_ComTencentWidgetSwipListView.getFirstVisiblePosition();
    int j = this.jdField_a_of_type_ComTencentWidgetSwipListView.getLastVisiblePosition();
    if ((paramInt >= i) && (paramInt <= j))
    {
      View localView = this.jdField_a_of_type_ComTencentWidgetSwipListView.getChildAt(paramInt - i);
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity$StoryMessageListAdapter.getView(paramInt, localView, this.jdField_a_of_type_ComTencentWidgetSwipListView);
    }
  }
  
  protected CharSequence c(MessageData paramMessageData)
  {
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(paramMessageData.o);
    localSpannableStringBuilder.append("\n");
    localSpannableStringBuilder.append("投票：");
    localSpannableStringBuilder.append(paramMessageData.n);
    localSpannableStringBuilder.setSpan(new ForegroundColorSpan(-4473925), 0, localSpannableStringBuilder.length(), 33);
    SLog.b("Q.qqstory.msgList", "get answer vote string : %s, voteQuestion : %s, voteAnswer : %s.", localSpannableStringBuilder, paramMessageData.n, paramMessageData.o);
    paramMessageData = localSpannableStringBuilder;
    if (com.tencent.mobileqq.text.TextUtils.a(localSpannableStringBuilder.toString())) {
      paramMessageData = new QQText(MessageUtils.b(localSpannableStringBuilder.toString()), 3, 14);
    }
    return paramMessageData;
  }
  
  protected void c()
  {
    if (this.jdField_a_of_type_Boolean) {}
    do
    {
      return;
      this.jdField_a_of_type_Boolean = true;
      int i;
      if (this.jdField_a_of_type_Long != -1L)
      {
        i = (int)(this.jdField_a_of_type_Long / 1000L);
        if (QLog.isColorLevel()) {
          QLog.d("Q.qqstory.msgList", 2, "clearUnread by msg time, time=" + i);
        }
        ((TroopRedTouchHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(43)).a(i, this.jdField_c_of_type_Int);
        return;
      }
      if (this.jdField_b_of_type_Int == 2)
      {
        i = (int)(NetConnInfoCenter.getServerTimeMillis() / 1000L);
        if (QLog.isColorLevel()) {
          QLog.d("Q.qqstory.msgList", 2, "clearUnread by svr time, time=" + i);
        }
        ((TroopRedTouchHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(43)).a(i, this.jdField_c_of_type_Int);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.d("Q.qqstory.msgList", 2, "nothing to clear");
  }
  
  protected CharSequence d(MessageData paramMessageData)
  {
    if (com.tencent.mobileqq.text.TextUtils.a(paramMessageData.q)) {
      return new QQText(MessageUtils.b(paramMessageData.q), 3, 14);
    }
    return paramMessageData.q;
  }
  
  public void d()
  {
    if (!AppNetConnInfo.isNetSupport()) {
      QQToast.a(getApplicationContext(), 1, "网络异常，请重试", 0).a();
    }
    do
    {
      return;
      if (this.jdField_a_of_type_Long != -1L) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.w("Q.qqstory.msgList", 2, "doDeleteAllMessage but newest timestamp not set");
    return;
    int i = (int)(this.jdField_a_of_type_Long / 1000L);
    if (QLog.isColorLevel()) {
      QLog.i("Q.qqstory.msgList", 2, "doDeleteAllMessage time=" + i);
    }
    qqstory_710_del_message.ReqDelAllMessage localReqDelAllMessage = new qqstory_710_del_message.ReqDelAllMessage();
    localReqDelAllMessage.start_time.set(i);
    ProtoUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentBizProtoUtils$StoryProtocolObserver, localReqDelAllMessage.toByteArray(), StoryApi.a("StorySvc.del_710_all_message"));
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity$StoryMessageListAdapter.notifyDataSetChanged();
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131434680);
    this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(0, 2130839525, 0, 0);
    this.jdField_a_of_type_AndroidWidgetTextView.setClickable(false);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    setRightViewTextDisable(0);
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2130970777);
    super.findViewById(2131362841).setBackgroundColor(getResources().getColor(2131494255));
    this.jdField_a_of_type_AndroidViewView = super.findViewById(2131371901);
    this.jdField_b_of_type_AndroidViewView = super.findViewById(2131371902);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131370558));
    this.jdField_a_of_type_ComTencentWidgetSwipListView = ((SwipListView)super.findViewById(2131364184));
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity$StoryMessageListAdapter = new StoryMessageListActivity.StoryMessageListAdapter(this);
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setDragEnable(true);
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setAdapter(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity$StoryMessageListAdapter);
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setOnItemClickListener(this);
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setOnItemLongClickListener(this);
    setRightButton(2131433257, this);
    setRightViewTextDisable(0);
    paramBundle = getAppInterface();
    int i;
    if ((paramBundle instanceof QQAppInterface))
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)paramBundle);
      paramBundle = getIntent();
      if (paramBundle != null) {
        break label241;
      }
      i = 0;
      label174:
      this.jdField_c_of_type_Int = i;
      if (paramBundle != null) {
        break label253;
      }
      paramBundle = "0";
      label187:
      this.jdField_a_of_type_JavaLangString = paramBundle;
      if (this.jdField_c_of_type_Int != 2) {
        break label264;
      }
      super.setTitle("互动通知");
    }
    for (;;)
    {
      a();
      paramBundle = StoryMsgNotification.a();
      paramBundle.a(this, 2);
      paramBundle.a(this, 4);
      return true;
      QLog.e("Q.qqstory.msgList", 1, "cannot get QQAppInterface");
      break;
      label241:
      i = paramBundle.getIntExtra("qqstory_message_list_source", 0);
      break label174;
      label253:
      paramBundle = paramBundle.getStringExtra("qqstory_jump_source");
      break label187;
      label264:
      super.setTitle("消息");
    }
  }
  
  protected void doOnDestroy()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
    }
    super.doOnDestroy();
  }
  
  protected CharSequence e(MessageData paramMessageData)
  {
    if (com.tencent.mobileqq.text.TextUtils.a(paramMessageData.q)) {
      localObject = MessageUtils.b(paramMessageData.q);
    }
    int i;
    for (Object localObject = new SpannableStringBuilder("A" + "\n" + "评分：" + (String)localObject);; localObject = new QQTextBuilder("A" + "\n" + "评分：" + (String)localObject, 3, 14))
    {
      i = "A".length();
      switch (paramMessageData.h)
      {
      default: 
        return localObject;
        localObject = paramMessageData.q;
      }
    }
    SpannableStringUtils.a((SpannableStringBuilder)localObject, 0, i, 2130841963, 50, 22, 1);
    return localObject;
    SpannableStringUtils.a((SpannableStringBuilder)localObject, 0, i, 2130841965, 50, 22, 1);
    return localObject;
    SpannableStringUtils.a((SpannableStringBuilder)localObject, 0, i, 2130841964, 50, 22, 1);
    return localObject;
    SpannableStringUtils.a((SpannableStringBuilder)localObject, 0, i, 2130841962, 50, 22, 1);
    return localObject;
    SpannableStringUtils.a((SpannableStringBuilder)localObject, 0, i, 2130841961, 50, 22, 1);
    return localObject;
  }
  
  public void e()
  {
    runOnUiThread(new nyd(this));
  }
  
  public void finish()
  {
    c();
    super.finish();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
    case 2131370558: 
      do
      {
        return;
      } while (this.jdField_b_of_type_Int != 3);
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.msgList", 2, "click retry first page");
      }
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      a();
      return;
    }
    StoryReportor.a(a(), "clear_msg", 0, 0, new String[] { "", "", "", "" });
    if ((this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(this, 230).setMessage("确定要清空所有消息记录？").setNegativeButton(2131433015, new nya(this)).setPositiveButton(2131433257, new nxz(this));
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
    StoryReportor.a(a(), "exp_sure", 0, 0, new String[] { "", "", "", "" });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.messagenotify.StoryMessageListActivity
 * JD-Core Version:    0.7.0.1
 */