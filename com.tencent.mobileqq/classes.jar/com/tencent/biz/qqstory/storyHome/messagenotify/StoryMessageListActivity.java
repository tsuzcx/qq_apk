package com.tencent.biz.qqstory.storyHome.messagenotify;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.MotionEvent;
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
import com.tencent.biz.qqstory.playvideo.StoryPlayerLauncher;
import com.tencent.biz.qqstory.playvideo.entrance.OpenPlayerBuilder;
import com.tencent.biz.qqstory.playvideo.entrance.VidListPlayInfo;
import com.tencent.biz.qqstory.shareGroup.infocard.QQStoryShareGroupProfileActivity;
import com.tencent.biz.qqstory.storyHome.QQStoryBaseActivity;
import com.tencent.biz.qqstory.storyHome.detail.model.SpannableStringUtils;
import com.tencent.biz.qqstory.storyHome.detail.view.StoryDetailActivity;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.service.message.EmotionCodecUtils;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.text.QQTextBuilder;
import com.tencent.mobileqq.utils.BubbleContextMenu;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;
import com.tencent.widget.AdapterView.OnItemLongClickListener;
import com.tencent.widget.BubblePopupWindow;
import com.tencent.widget.SwipListView;
import com.tribe.async.dispatch.Subscriber;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class StoryMessageListActivity
  extends QQStoryBaseActivity
  implements View.OnClickListener, AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener
{
  protected int a;
  protected long a;
  protected View a;
  protected TextView a;
  protected ProtoUtils.StoryProtocolObserver a;
  protected StoryMessageListActivity.StoryMessageListAdapter a;
  protected QQAppInterface a;
  protected QQCustomDialog a;
  protected QQCustomMenu a;
  protected BubblePopupWindow a;
  protected SwipListView a;
  protected String a;
  protected ArrayList<MessageData> a;
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
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 4;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Long = -1L;
    this.jdField_c_of_type_Int = 0;
    this.jdField_c_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentBizProtoUtils$StoryProtocolObserver = new StoryMessageListActivity.1(this);
    this.jdField_b_of_type_ComTencentBizProtoUtils$StoryProtocolObserver = new StoryMessageListActivity.2(this);
    this.jdField_c_of_type_ComTencentBizProtoUtils$StoryProtocolObserver = new StoryMessageListActivity.3(this);
  }
  
  @NonNull
  public static Intent a(Context paramContext, String paramString, int paramInt)
  {
    paramContext = new Intent(paramContext, StoryMessageListActivity.class);
    paramContext.putExtra("qqstory_message_list_source", paramInt);
    paramContext.putExtra("qqstory_jump_source", paramString);
    return paramContext;
  }
  
  protected CharSequence a(MessageData paramMessageData)
  {
    if (paramMessageData.jdField_a_of_type_Int == 2)
    {
      paramMessageData = paramMessageData.e;
    }
    else
    {
      SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(HardCodeUtil.a(2131714309));
      int i = localSpannableStringBuilder.length();
      localSpannableStringBuilder.append(PlayModeUtils.a(paramMessageData.jdField_d_of_type_JavaLangString));
      localSpannableStringBuilder.setSpan(new ForegroundColorSpan(this.app.getApp().getResources().getColor(2131167056)), i, localSpannableStringBuilder.length(), 33);
      localSpannableStringBuilder.append(':').append(paramMessageData.e);
      paramMessageData = localSpannableStringBuilder;
    }
    if (com.tencent.mobileqq.text.TextUtils.hasSysEmotion(paramMessageData.toString())) {
      return new QQText(EmotionCodecUtils.b(paramMessageData.toString()), 3, 14);
    }
    return paramMessageData;
  }
  
  protected String a()
  {
    int i = this.jdField_c_of_type_Int;
    if (i == 0) {
      return "play_video";
    }
    if (i == 1) {
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
    localReqStoryMessageList.version_ctrl.set(775);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("fetch message list, start=");
      localStringBuilder.append(this.jdField_a_of_type_Int);
      QLog.d("Q.qqstory.msgList", 2, localStringBuilder.toString());
    }
    ProtoUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_c_of_type_ComTencentBizProtoUtils$StoryProtocolObserver, localReqStoryMessageList.toByteArray(), StoryApi.a("StorySvc.get_710_message_list"));
  }
  
  protected void a(int paramInt)
  {
    if (!AppNetConnInfo.isNetSupport())
    {
      QQToast.a(getApplicationContext(), 1, HardCodeUtil.a(2131714315), 0).a();
      return;
    }
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity$StoryMessageListAdapter.a(paramInt))
    {
      MessageData localMessageData = (MessageData)this.jdField_a_of_type_JavaUtilArrayList.remove(paramInt);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("doDeleteMessage pos=");
        ((StringBuilder)localObject).append(paramInt);
        ((StringBuilder)localObject).append(" vid=");
        ((StringBuilder)localObject).append(localMessageData.jdField_b_of_type_JavaLangString);
        ((StringBuilder)localObject).append(" type=");
        ((StringBuilder)localObject).append(localMessageData.jdField_a_of_type_Int);
        ((StringBuilder)localObject).append(" cid=");
        ((StringBuilder)localObject).append(localMessageData.jdField_c_of_type_Int);
        QLog.i("Q.qqstory.msgList", 2, ((StringBuilder)localObject).toString());
      }
      Object localObject = new qqstory_710_del_message.ReqDelOneMessage();
      ((qqstory_710_del_message.ReqDelOneMessage)localObject).feed_id.set(ByteStringMicro.copyFromUtf8(localMessageData.jdField_f_of_type_JavaLangString));
      ((qqstory_710_del_message.ReqDelOneMessage)localObject).message_id.set(localMessageData.jdField_d_of_type_Int);
      ProtoUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_ComTencentBizProtoUtils$StoryProtocolObserver, ((qqstory_710_del_message.ReqDelOneMessage)localObject).toByteArray(), StoryApi.a("StorySvc.del_710_one_message"));
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity$StoryMessageListAdapter.notifyDataSetChanged();
      if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity$StoryMessageListAdapter.getCount() == 0)
      {
        this.jdField_b_of_type_AndroidViewView.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetTextView.setText(2131694466);
        this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(0, 2130841446, 0, 0);
        this.jdField_a_of_type_AndroidWidgetTextView.setClickable(false);
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_a_of_type_AndroidViewView.setVisibility(0);
        setRightViewTextDisable(0);
      }
    }
  }
  
  protected void a(MessageData paramMessageData, View paramView)
  {
    if (QLog.isColorLevel())
    {
      paramView = new StringBuilder();
      paramView.append("click item type=");
      paramView.append(paramMessageData.jdField_a_of_type_Int);
      QLog.d("Q.qqstory.msgList", 2, paramView.toString());
    }
    switch (paramMessageData.jdField_a_of_type_Int)
    {
    default: 
    case 19: 
      StoryPlayerLauncher.b(this, paramMessageData.jdField_b_of_type_JavaLangString, paramMessageData.s, 29);
      return;
    case 18: 
      StoryPlayerLauncher.a(this, new OpenPlayerBuilder(new VidListPlayInfo(paramMessageData.r, paramMessageData.jdField_b_of_type_JavaLangString), 126).a(), null);
      return;
    case 16: 
      paramView = new StringBuilder("https://story.now.qq.com/m/score/index.html?_wv=3&_nav_alpha=0");
      paramView.append("&vid=");
      paramView.append(paramMessageData.jdField_b_of_type_JavaLangString);
      SLog.a("Q.qqstory.msgList", "go to story grade detail web. url = %s.", paramView.toString());
      paramMessageData = new Intent(this, QQBrowserActivity.class);
      paramMessageData.putExtra("url", paramView.toString());
      paramMessageData.putExtra("startOpenPageTime", System.currentTimeMillis());
      startActivity(paramMessageData);
      if (QLog.isColorLevel())
      {
        QLog.d("Q.qqstory.msgList", 2, "StoryMessageListActivity#onItemClick() TYPE_ANSWER_MY_GRADE open webview!");
        return;
      }
      break;
    case 13: 
      paramView = new StringBuilder("https://story.now.qq.com/m/vote/index.html?_wv=3&_nav_alpha=0");
      paramView.append("&vid=");
      paramView.append(paramMessageData.jdField_b_of_type_JavaLangString);
      SLog.a("Q.qqstory.msgList", "go to story vote detail web. url = %s.", paramView.toString());
      paramMessageData = new Intent(this, QQBrowserActivity.class);
      paramMessageData.putExtra("url", paramView.toString());
      startActivity(paramMessageData);
      if (QLog.isColorLevel())
      {
        QLog.d("Q.qqstory.msgList", 2, "StoryMessageListActivity#onItemClick() TYPE_ANSWER_MY_VOTE open webview!");
        return;
      }
      break;
    case 11: 
      QQToast.a(this, -1, HardCodeUtil.a(2131714320), 0).a();
      return;
    case 10: 
      paramMessageData = ((UserManager)SuperManager.a(2)).a();
      if (paramMessageData == null)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.qqstory.msgList", 2, "self user item == null");
        }
        return;
      }
      paramMessageData = paramMessageData.getUserIconJumpURL();
      if (android.text.TextUtils.isEmpty(paramMessageData))
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.qqstory.msgList", 2, "jumpUrl is empty");
        }
        return;
      }
      paramView = new Intent(this, QQBrowserActivity.class);
      paramView.putExtra("url", paramMessageData);
      startActivity(paramView);
      return;
    case 6: 
    case 7: 
    case 8: 
    case 9: 
      QQStoryShareGroupProfileActivity.a(this, 2, paramMessageData.m, null, 7, 0);
      return;
    case 5: 
      if (paramMessageData.g == 0)
      {
        paramView = new Intent(this, QQBrowserActivity.class);
        paramView.putExtra("url", paramMessageData.jdField_i_of_type_JavaLangString);
        startActivity(paramView);
        if (QLog.isColorLevel()) {
          QLog.d("Q.qqstory.msgList", 2, "StoryMessageListActivity#onItemClick() TYPE_OFFICIAL open webview!");
        }
      }
      else if (paramMessageData.g == 1)
      {
        paramView = new Intent(this, JumpActivity.class);
        paramView.setData(Uri.parse(paramMessageData.jdField_i_of_type_JavaLangString));
        startActivity(paramView);
        if (QLog.isColorLevel()) {
          QLog.d("Q.qqstory.msgList", 2, "StoryMessageListActivity#onItemClick() TYPE_OFFICIAL open jumpActivity!");
        }
      }
      else if (QLog.isColorLevel())
      {
        paramView = new StringBuilder();
        paramView.append("StoryMessageListActivity#onItemClick() unknow url_type = ");
        paramView.append(paramMessageData.g);
        QLog.e("Q.qqstory.msgList", 2, paramView.toString());
        return;
      }
      break;
    case 4: 
    case 12: 
    case 14: 
    case 15: 
    case 17: 
      if (paramMessageData.jdField_a_of_type_Boolean)
      {
        QQToast.a(this, 1, HardCodeUtil.a(2131714344), 0).a();
        return;
      }
      StoryPlayerLauncher.a(this, new OpenPlayerBuilder(new VidListPlayInfo(paramMessageData.jdField_f_of_type_JavaLangString, paramMessageData.jdField_b_of_type_JavaLangString), 29).a(), null);
      return;
    case 2: 
    case 3: 
      StoryDetailActivity.a(this, paramMessageData.jdField_f_of_type_JavaLangString, 23, paramMessageData.jdField_c_of_type_Int, 0, paramMessageData.jdField_b_of_type_Int);
      return;
    case 1: 
      StoryDetailActivity.a(this, paramMessageData.jdField_f_of_type_JavaLangString, 23, 0, paramMessageData.jdField_b_of_type_Int);
    }
  }
  
  public void a(List<MessageData> paramList)
  {
    if (paramList != null)
    {
      if (paramList.size() == 0) {
        return;
      }
      UserManager localUserManager = (UserManager)SuperManager.a(2);
      ArrayList localArrayList = new ArrayList();
      HashSet localHashSet = new HashSet();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        MessageData localMessageData = (MessageData)paramList.next();
        String[] arrayOfString = new String[3];
        Object localObject = localMessageData.jdField_a_of_type_JavaLangString;
        int i = 0;
        arrayOfString[0] = localObject;
        arrayOfString[1] = localMessageData.jdField_c_of_type_JavaLangString;
        arrayOfString[2] = localMessageData.jdField_d_of_type_JavaLangString;
        int j = arrayOfString.length;
        while (i < j)
        {
          localMessageData = arrayOfString[i];
          if (!android.text.TextUtils.isEmpty(localMessageData))
          {
            localObject = localUserManager.b(localMessageData);
            if (((localObject == null) || (!((QQUserUIItem)localObject).isAvailable())) && (!localHashSet.contains(localMessageData)))
            {
              localArrayList.add(new QQUserUIItem.UserID("", localMessageData));
              localHashSet.add(localMessageData);
            }
          }
          i += 1;
        }
      }
      localHashSet.clear();
      if (!localArrayList.isEmpty()) {
        new GetUserInfoHandler().a(1, localArrayList);
      }
    }
  }
  
  protected void a(List<MessageData> paramList, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onUpdate size=");
      ((StringBuilder)localObject).append(paramList.size());
      ((StringBuilder)localObject).append(", end=");
      ((StringBuilder)localObject).append(paramBoolean1);
      QLog.d("Q.qqstory.msgList", 2, ((StringBuilder)localObject).toString());
    }
    if (this.jdField_a_of_type_JavaUtilArrayList.size() == 0)
    {
      if (paramList.size() > 0)
      {
        this.jdField_a_of_type_Long = ((MessageData)paramList.get(0)).jdField_a_of_type_Long;
        this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      }
      else
      {
        i = this.jdField_c_of_type_Int;
        if (((i == 0) || (i == 2)) && (paramBoolean2))
        {
          this.jdField_a_of_type_AndroidViewView.setVisibility(8);
        }
        else
        {
          this.jdField_b_of_type_AndroidViewView.setVisibility(8);
          this.jdField_a_of_type_AndroidWidgetTextView.setText(2131694466);
          this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(0, 2130841446, 0, 0);
          this.jdField_a_of_type_AndroidWidgetTextView.setClickable(false);
          this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
          this.jdField_a_of_type_AndroidViewView.setVisibility(0);
        }
      }
      localObject = ((UserManager)SuperManager.a(2)).b(QQStoryContext.a().b());
      if ((localObject != null) && (((QQUserUIItem)localObject).isVip)) {
        i = 1;
      } else {
        i = 0;
      }
      int j = this.jdField_c_of_type_Int;
      localObject = "1";
      if (j == 0)
      {
        if (i != 0) {
          i = 1;
        } else {
          i = 2;
        }
        StoryReportor.a("play_video", "exp_notice", i, 0, new String[] { "1", "", "", "" });
      }
      else if (j == 1)
      {
        if (paramList.size() > 0) {
          localObject = "2";
        }
        StoryReportor.a("memory", "exp_msg", 0, 0, new String[] { localObject, "", "", "" });
      }
    }
    a(paramList);
    this.jdField_a_of_type_JavaUtilArrayList.addAll(paramList);
    int i = paramList.size();
    if ((!paramBoolean1) && (i != 0))
    {
      this.jdField_b_of_type_Int = 4;
    }
    else
    {
      this.jdField_b_of_type_Int = 2;
      c();
    }
    if (i > 0)
    {
      paramList = this.jdField_a_of_type_JavaUtilArrayList;
      this.jdField_a_of_type_Int = ((int)(((MessageData)paramList.get(paramList.size() - 1)).jdField_a_of_type_Long / 1000L) - 1);
      setRightViewTextDisable(1);
    }
    this.jdField_c_of_type_Boolean = paramBoolean2;
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity$StoryMessageListAdapter.notifyDataSetChanged();
  }
  
  protected CharSequence b(MessageData paramMessageData)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(HardCodeUtil.a(2131714313));
    localStringBuilder.append(paramMessageData.e);
    return localStringBuilder.toString();
  }
  
  protected void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.msgList", 2, "onError");
    }
    this.jdField_b_of_type_Int = 3;
    if (this.jdField_a_of_type_JavaUtilArrayList.size() == 0)
    {
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131714308));
      this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(0, 2130846855, 0, 0);
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      if (this.jdField_c_of_type_Int == 0)
      {
        QQUserUIItem localQQUserUIItem = ((UserManager)SuperManager.a(2)).b(QQStoryContext.a().b());
        int i;
        if ((localQQUserUIItem != null) && (localQQUserUIItem.isVip)) {
          i = 1;
        } else {
          i = 0;
        }
        if (i != 0) {
          i = 1;
        } else {
          i = 2;
        }
        StoryReportor.a("play_video", "exp_notice", i, 0, new String[] { "2", "", "", "" });
      }
    }
    b(this.jdField_a_of_type_JavaUtilArrayList.size());
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
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(HardCodeUtil.a(2131714324));
    int i = localSpannableStringBuilder.length();
    localSpannableStringBuilder.append(paramMessageData.n);
    localSpannableStringBuilder.setSpan(new ForegroundColorSpan(this.app.getApp().getResources().getColor(2131167056)), i, localSpannableStringBuilder.length(), 33);
    SLog.b("Q.qqstory.msgList", "get vote publish string : %s, voteQuestion : %s.", localSpannableStringBuilder, paramMessageData.n);
    paramMessageData = localSpannableStringBuilder;
    if (com.tencent.mobileqq.text.TextUtils.hasSysEmotion(localSpannableStringBuilder.toString())) {
      paramMessageData = new QQText(EmotionCodecUtils.b(localSpannableStringBuilder.toString()), 3, 14);
    }
    return paramMessageData;
  }
  
  protected void c()
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    long l = this.jdField_a_of_type_Long;
    int i;
    StringBuilder localStringBuilder;
    if (l != -1L)
    {
      i = (int)(l / 1000L);
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("clearUnread by msg time, time=");
        localStringBuilder.append(i);
        QLog.d("Q.qqstory.msgList", 2, localStringBuilder.toString());
      }
      ((TroopRedTouchHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.GET_RED_POINT_EX_HANDLER)).a(i, this.jdField_c_of_type_Int);
      return;
    }
    if (this.jdField_b_of_type_Int == 2)
    {
      i = (int)(NetConnInfoCenter.getServerTimeMillis() / 1000L);
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("clearUnread by svr time, time=");
        localStringBuilder.append(i);
        QLog.d("Q.qqstory.msgList", 2, localStringBuilder.toString());
      }
      ((TroopRedTouchHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.GET_RED_POINT_EX_HANDLER)).a(i, this.jdField_c_of_type_Int);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.msgList", 2, "nothing to clear");
    }
  }
  
  protected CharSequence d(MessageData paramMessageData)
  {
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(paramMessageData.o);
    localSpannableStringBuilder.append("\n");
    localSpannableStringBuilder.append("投票：");
    localSpannableStringBuilder.append(paramMessageData.n);
    localSpannableStringBuilder.setSpan(new ForegroundColorSpan(-4473925), 0, localSpannableStringBuilder.length(), 33);
    SLog.b("Q.qqstory.msgList", "get answer vote string : %s, voteQuestion : %s, voteAnswer : %s.", localSpannableStringBuilder, paramMessageData.n, paramMessageData.o);
    paramMessageData = localSpannableStringBuilder;
    if (com.tencent.mobileqq.text.TextUtils.hasSysEmotion(localSpannableStringBuilder.toString())) {
      paramMessageData = new QQText(EmotionCodecUtils.b(localSpannableStringBuilder.toString()), 3, 14);
    }
    return paramMessageData;
  }
  
  protected void d()
  {
    if (!AppNetConnInfo.isNetSupport())
    {
      QQToast.a(getApplicationContext(), 1, HardCodeUtil.a(2131714316), 0).a();
      return;
    }
    long l = this.jdField_a_of_type_Long;
    if (l == -1L)
    {
      if (QLog.isColorLevel()) {
        QLog.w("Q.qqstory.msgList", 2, "doDeleteAllMessage but newest timestamp not set");
      }
      return;
    }
    int i = (int)(l / 1000L);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("doDeleteAllMessage time=");
      ((StringBuilder)localObject).append(i);
      QLog.i("Q.qqstory.msgList", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new qqstory_710_del_message.ReqDelAllMessage();
    ((qqstory_710_del_message.ReqDelAllMessage)localObject).start_time.set(i);
    ProtoUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentBizProtoUtils$StoryProtocolObserver, ((qqstory_710_del_message.ReqDelAllMessage)localObject).toByteArray(), StoryApi.a("StorySvc.del_710_all_message"));
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity$StoryMessageListAdapter.notifyDataSetChanged();
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131694466);
    this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(0, 2130841446, 0, 0);
    this.jdField_a_of_type_AndroidWidgetTextView.setClickable(false);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    setRightViewTextDisable(0);
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2131561709);
    super.findViewById(2131365132).setBackgroundColor(getResources().getColor(2131167116));
    this.jdField_a_of_type_AndroidViewView = super.findViewById(2131374463);
    this.jdField_b_of_type_AndroidViewView = super.findViewById(2131374548);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131366209));
    this.jdField_a_of_type_ComTencentWidgetSwipListView = ((SwipListView)super.findViewById(2131370153));
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity$StoryMessageListAdapter = new StoryMessageListActivity.StoryMessageListAdapter(this);
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setDragEnable(true);
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setAdapter(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity$StoryMessageListAdapter);
    setRightButton(2131690863, this);
    int i = 0;
    setRightViewTextDisable(0);
    paramBundle = getAppInterface();
    if ((paramBundle instanceof QQAppInterface)) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)paramBundle);
    } else {
      QLog.e("Q.qqstory.msgList", 1, "cannot get QQAppInterface");
    }
    paramBundle = getIntent();
    if (paramBundle != null) {
      i = paramBundle.getIntExtra("qqstory_message_list_source", 0);
    }
    this.jdField_c_of_type_Int = i;
    if (paramBundle == null) {
      paramBundle = "0";
    } else {
      paramBundle = paramBundle.getStringExtra("qqstory_jump_source");
    }
    this.jdField_a_of_type_JavaLangString = paramBundle;
    if (this.jdField_c_of_type_Int == 2) {
      super.setTitle(HardCodeUtil.a(2131714312));
    } else {
      super.setTitle(HardCodeUtil.a(2131714307));
    }
    a();
    paramBundle = StoryMsgNotification.a();
    paramBundle.a(this, 2);
    paramBundle.a(this, 4);
    return true;
  }
  
  protected void doOnDestroy()
  {
    QQCustomDialog localQQCustomDialog = this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
    if ((localQQCustomDialog != null) && (localQQCustomDialog.isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
    }
    super.doOnDestroy();
  }
  
  protected CharSequence e(MessageData paramMessageData)
  {
    if (com.tencent.mobileqq.text.TextUtils.hasSysEmotion(paramMessageData.q)) {
      return new QQText(EmotionCodecUtils.b(paramMessageData.q), 3, 14);
    }
    return paramMessageData.q;
  }
  
  public void e()
  {
    runOnUiThread(new StoryMessageListActivity.8(this));
  }
  
  protected CharSequence f(MessageData paramMessageData)
  {
    Object localObject = HardCodeUtil.a(2131714327);
    String str;
    StringBuilder localStringBuilder;
    if (com.tencent.mobileqq.text.TextUtils.hasSysEmotion(paramMessageData.q))
    {
      str = EmotionCodecUtils.b(paramMessageData.q);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("A");
      localStringBuilder.append("\n");
      localStringBuilder.append((String)localObject);
      localStringBuilder.append(str);
      localObject = new SpannableStringBuilder(localStringBuilder.toString());
    }
    else
    {
      str = paramMessageData.q;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("A");
      localStringBuilder.append("\n");
      localStringBuilder.append((String)localObject);
      localStringBuilder.append(str);
      localObject = new QQTextBuilder(localStringBuilder.toString(), 3, 14);
    }
    int i = paramMessageData.jdField_i_of_type_Int;
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i != 4)
          {
            if (i != 5) {
              return localObject;
            }
            SpannableStringUtils.a((SpannableStringBuilder)localObject, 0, 1, 2130844609, 50, 22, 1);
            return localObject;
          }
          SpannableStringUtils.a((SpannableStringBuilder)localObject, 0, 1, 2130844610, 50, 22, 1);
          return localObject;
        }
        SpannableStringUtils.a((SpannableStringBuilder)localObject, 0, 1, 2130844612, 50, 22, 1);
        return localObject;
      }
      SpannableStringUtils.a((SpannableStringBuilder)localObject, 0, 1, 2130844613, 50, 22, 1);
      return localObject;
    }
    SpannableStringUtils.a((SpannableStringBuilder)localObject, 0, 1, 2130844611, 50, 22, 1);
    return localObject;
  }
  
  public void finish()
  {
    c();
    super.finish();
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i != 2131366209)
    {
      if (i == 2131369233)
      {
        StoryReportor.a(a(), "clear_msg", 0, 0, new String[] { "", "", "", "" });
        QQCustomDialog localQQCustomDialog = this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
        if ((localQQCustomDialog != null) && (localQQCustomDialog.isShowing())) {
          this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
        }
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(this, 230).setMessage(HardCodeUtil.a(2131714302)).setNegativeButton(2131690728, new StoryMessageListActivity.5(this)).setPositiveButton(2131690863, new StoryMessageListActivity.4(this));
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
        StoryReportor.a(a(), "exp_sure", 0, 0, new String[] { "", "", "", "" });
      }
    }
    else if (this.jdField_b_of_type_Int == 3)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.msgList", 2, "click retry first page");
      }
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      a();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  protected void onCreateSubscribers(@NonNull Map<Subscriber, String> paramMap)
  {
    super.onCreateSubscribers(paramMap);
    paramMap.put(new StoryMessageListActivity.UpdateUserInfoEventReceiver(this), "");
    paramMap.put(new StoryMessageListActivity.TroopNickNameUpdateEventReceiver(this), "");
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity$StoryMessageListAdapter.a(paramInt))
    {
      Object localObject = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity$StoryMessageListAdapter.a(paramInt);
      if (localObject == null) {
        return;
      }
      a((MessageData)localObject, paramView);
      paramInt = ((MessageData)localObject).jdField_f_of_type_Int;
      if (paramInt != 0)
      {
        if (paramInt != 4)
        {
          if (paramInt != 104) {
            switch (paramInt)
            {
            default: 
              paramInt = 0;
              break;
            case 101: 
              paramInt = 9;
              break;
            case 100: 
              paramInt = 7;
              break;
            case 99: 
              if (((MessageData)localObject).h == 0) {
                paramInt = 6;
              } else {
                paramInt = 5;
              }
              break;
            }
          } else {
            paramInt = 8;
          }
        }
        else {
          paramInt = 3;
        }
      }
      else
      {
        paramAdapterView = ((UserManager)SuperManager.a(2)).b(((MessageData)localObject).jdField_a_of_type_JavaLangString);
        if ((paramAdapterView != null) && (paramAdapterView.isFriend())) {
          paramInt = 1;
        } else if ((paramAdapterView != null) && (paramAdapterView.isSubscribe())) {
          paramInt = 2;
        } else {
          paramInt = 4;
        }
      }
      int i = ((MessageData)localObject).jdField_a_of_type_Int;
      paramView = "1";
      switch (i)
      {
      default: 
        paramAdapterView = "";
        break;
      case 9: 
        paramAdapterView = "9";
        break;
      case 8: 
        paramAdapterView = "10";
        break;
      case 7: 
        paramAdapterView = "8";
        break;
      case 6: 
        paramAdapterView = "11";
        break;
      case 5: 
        paramAdapterView = "7";
        break;
      case 4: 
        paramAdapterView = "6";
        break;
      case 3: 
        if (QQStoryContext.a().a(((MessageData)localObject).jdField_d_of_type_JavaLangString)) {
          paramAdapterView = "3";
        }
        break;
      }
      do
      {
        do
        {
          paramAdapterView = "4";
          break;
        } while (!QQStoryContext.a().a(((MessageData)localObject).jdField_c_of_type_JavaLangString));
        paramAdapterView = "1";
        break;
      } while (!QQStoryContext.a().a(((MessageData)localObject).jdField_c_of_type_JavaLangString));
      paramAdapterView = "2";
      if (((MessageData)localObject).jdField_a_of_type_Boolean) {
        paramView = "4";
      }
      localObject = ((UserManager)SuperManager.a(2)).b(QQStoryContext.a().b());
      if ((localObject != null) && (((QQUserUIItem)localObject).isVip)) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0) {
        i = 1;
      } else {
        i = 2;
      }
      StoryReportor.a("play_video", "clk_msg", i, paramInt, new String[] { paramAdapterView, paramView, this.jdField_a_of_type_JavaLangString, "" });
      return;
    }
    paramInt = this.jdField_b_of_type_Int;
    if (paramInt == 3)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.msgList", 2, "click retry");
      }
    }
    else if (paramInt == 2)
    {
      if (this.jdField_c_of_type_Int == 2) {
        this.jdField_c_of_type_Int = 3;
      } else {
        this.jdField_c_of_type_Int = 1;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.msgList", 2, "convert to list");
      }
      StoryReportor.a("play_video", "clk_more", 0, 0, new String[] { "", "", "", "" });
    }
    this.jdField_b_of_type_Boolean = true;
    b(this.jdField_a_of_type_JavaUtilArrayList.size());
  }
  
  public boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity$StoryMessageListAdapter.a(paramInt))
    {
      paramAdapterView = this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow;
      if ((paramAdapterView != null) && (paramAdapterView.isShowing())) {
        this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.dismiss();
      }
      paramView.setSelected(true);
      if (this.jdField_a_of_type_ComTencentMobileqqUtilsDialogutilsQQCustomMenu == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqUtilsDialogutilsQQCustomMenu = new QQCustomMenu();
        this.jdField_a_of_type_ComTencentMobileqqUtilsDialogutilsQQCustomMenu.a(2131374481, HardCodeUtil.a(2131714321));
      }
      this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow = BubbleContextMenu.a(paramView, this.jdField_a_of_type_ComTencentMobileqqUtilsDialogutilsQQCustomMenu, new StoryMessageListActivity.6(this, paramInt), new StoryMessageListActivity.7(this, paramView));
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.messagenotify.StoryMessageListActivity
 * JD-Core Version:    0.7.0.1
 */