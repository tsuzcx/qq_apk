package com.tencent.biz.qqstory.storyHome.messagenotify;

import Override;
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
import anvx;
import bcsc;
import bhcw;
import bhdj;
import bhjq;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.network.pb.qqstory_710_del_message.ReqDelAllMessage;
import com.tencent.biz.qqstory.network.pb.qqstory_710_del_message.ReqDelOneMessage;
import com.tencent.biz.qqstory.network.pb.qqstory_710_message.ReqStoryMessageList;
import com.tencent.biz.qqstory.playvideo.entrance.OpenPlayerBuilder;
import com.tencent.biz.qqstory.playvideo.entrance.VidListPlayInfo;
import com.tencent.biz.qqstory.shareGroup.infocard.QQStoryShareGroupProfileActivity;
import com.tencent.biz.qqstory.storyHome.QQStoryBaseActivity;
import com.tencent.biz.qqstory.storyHome.detail.view.StoryDetailActivity;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.text.QQTextBuilder;
import com.tencent.mobileqq.utils.QQCustomDialog;
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
import ntb;
import ntd;
import ntj;
import weg;
import wjs;
import wke;
import wkz;
import wrb;
import wyw;
import wzk;
import xbp;
import xwj;
import ybe;
import ybf;
import ybg;
import ybh;
import ybi;
import ybj;
import ybk;
import ybl;
import ybo;
import ybq;
import ybr;
import ykq;
import ykv;

public class StoryMessageListActivity
  extends QQStoryBaseActivity
  implements View.OnClickListener, AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener
{
  protected int a;
  protected long a;
  protected View a;
  protected TextView a;
  protected bhjq a;
  protected QQAppInterface a;
  protected QQCustomDialog a;
  protected BubblePopupWindow a;
  public SwipListView a;
  protected String a;
  public ArrayList<ybe> a;
  protected ntd a;
  protected ybo a;
  protected boolean a;
  public int b;
  protected View b;
  protected ntd b;
  public boolean b;
  public int c;
  protected ntd c;
  public boolean c;
  
  public StoryMessageListActivity()
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_b_of_type_Int = 4;
    this.jdField_a_of_type_Long = -1L;
    this.jdField_c_of_type_Int = 0;
    this.jdField_c_of_type_Boolean = true;
    this.jdField_a_of_type_Ntd = new ybf(this);
    this.jdField_b_of_type_Ntd = new ybg(this);
    this.jdField_c_of_type_Ntd = new ybh(this);
  }
  
  @NonNull
  public static Intent a(Context paramContext, String paramString, int paramInt)
  {
    paramContext = new Intent(paramContext, StoryMessageListActivity.class);
    paramContext.putExtra("qqstory_message_list_source", paramInt);
    paramContext.putExtra("qqstory_jump_source", paramString);
    return paramContext;
  }
  
  public CharSequence a(ybe paramybe)
  {
    if (paramybe.jdField_a_of_type_Int == 2) {}
    Object localObject;
    for (paramybe = paramybe.e;; paramybe = (ybe)localObject)
    {
      localObject = paramybe;
      if (com.tencent.mobileqq.text.TextUtils.hasSysEmotion(paramybe.toString())) {
        localObject = new QQText(bcsc.b(paramybe.toString()), 3, 14);
      }
      return localObject;
      localObject = new SpannableStringBuilder(anvx.a(2131713892));
      int i = ((SpannableStringBuilder)localObject).length();
      ((SpannableStringBuilder)localObject).append(wzk.a(paramybe.jdField_d_of_type_JavaLangString));
      ((SpannableStringBuilder)localObject).setSpan(new ForegroundColorSpan(this.app.getApp().getResources().getColor(2131167026)), i, ((SpannableStringBuilder)localObject).length(), 33);
      ((SpannableStringBuilder)localObject).append(':').append(paramybe.e);
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
  
  public void a()
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
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.msgList", 2, "fetch message list, start=" + this.jdField_a_of_type_Int);
    }
    ntb.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_c_of_type_Ntd, localReqStoryMessageList.toByteArray(), weg.a("StorySvc.get_710_message_list"));
  }
  
  public void a(int paramInt)
  {
    if (!AppNetConnInfo.isNetSupport()) {}
    do
    {
      QQToast.a(getApplicationContext(), 1, anvx.a(2131713898), 0).a();
      do
      {
        return;
      } while (!this.jdField_a_of_type_Ybo.a(paramInt));
      ybe localybe = (ybe)this.jdField_a_of_type_JavaUtilArrayList.remove(paramInt);
      if (QLog.isColorLevel()) {
        QLog.i("Q.qqstory.msgList", 2, "doDeleteMessage pos=" + paramInt + " vid=" + localybe.jdField_b_of_type_JavaLangString + " type=" + localybe.jdField_a_of_type_Int + " cid=" + localybe.jdField_c_of_type_Int);
      }
      qqstory_710_del_message.ReqDelOneMessage localReqDelOneMessage = new qqstory_710_del_message.ReqDelOneMessage();
      localReqDelOneMessage.feed_id.set(ByteStringMicro.copyFromUtf8(localybe.jdField_f_of_type_JavaLangString));
      localReqDelOneMessage.message_id.set(localybe.jdField_d_of_type_Int);
      ntb.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_Ntd, localReqDelOneMessage.toByteArray(), weg.a("StorySvc.del_710_one_message"));
      this.jdField_a_of_type_Ybo.notifyDataSetChanged();
    } while (this.jdField_a_of_type_Ybo.getCount() != 0);
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131694296);
    this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(0, 2130841420, 0, 0);
    this.jdField_a_of_type_AndroidWidgetTextView.setClickable(false);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    setRightViewTextDisable(0);
  }
  
  public void a(List<ybe> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {}
    ArrayList localArrayList;
    do
    {
      return;
      wke localwke = (wke)wjs.a(2);
      localArrayList = new ArrayList();
      HashSet localHashSet = new HashSet();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        ybe localybe = (ybe)paramList.next();
        String[] arrayOfString = new String[3];
        arrayOfString[0] = localybe.jdField_a_of_type_JavaLangString;
        arrayOfString[1] = localybe.jdField_c_of_type_JavaLangString;
        arrayOfString[2] = localybe.jdField_d_of_type_JavaLangString;
        int j = arrayOfString.length;
        int i = 0;
        while (i < j)
        {
          localybe = arrayOfString[i];
          if (!android.text.TextUtils.isEmpty(localybe))
          {
            QQUserUIItem localQQUserUIItem = localwke.b(localybe);
            if (((localQQUserUIItem == null) || (!localQQUserUIItem.isAvailable())) && (!localHashSet.contains(localybe)))
            {
              localArrayList.add(new wkz("", localybe));
              localHashSet.add(localybe);
            }
          }
          i += 1;
        }
      }
      localHashSet.clear();
    } while (localArrayList.isEmpty());
    new wrb().a(1, localArrayList);
  }
  
  protected void a(List<ybe> paramList, boolean paramBoolean1, boolean paramBoolean2)
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
        this.jdField_a_of_type_Long = ((ybe)paramList.get(0)).jdField_a_of_type_Long;
        this.jdField_a_of_type_AndroidViewView.setVisibility(8);
        localObject = ((wke)wjs.a(2)).b(QQStoryContext.a().b());
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
        ykv.a("play_video", "exp_notice", i, 0, new String[] { "1", "", "", "" });
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
      e();
    }
    for (;;)
    {
      if (i > 0)
      {
        this.jdField_a_of_type_Int = ((int)(((ybe)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_JavaUtilArrayList.size() - 1)).jdField_a_of_type_Long / 1000L) - 1);
        setRightViewTextDisable(1);
      }
      this.jdField_c_of_type_Boolean = paramBoolean2;
      this.jdField_a_of_type_Ybo.notifyDataSetChanged();
      return;
      if (((this.jdField_c_of_type_Int == 0) || (this.jdField_c_of_type_Int == 2)) && (paramBoolean2))
      {
        this.jdField_a_of_type_AndroidViewView.setVisibility(8);
        break;
      }
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131694296);
      this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(0, 2130841420, 0, 0);
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
        ykv.a("memory", "exp_msg", 0, 0, new String[] { localObject, "", "", "" });
        break;
      }
      label442:
      this.jdField_b_of_type_Int = 4;
    }
  }
  
  public void a(@NonNull Map<Subscriber, String> paramMap)
  {
    super.a(paramMap);
    paramMap.put(new ybr(this), "");
    paramMap.put(new ybq(this), "");
  }
  
  protected void a(ybe paramybe, View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.msgList", 2, "click item type=" + paramybe.jdField_a_of_type_Int);
    }
    switch (paramybe.jdField_a_of_type_Int)
    {
    default: 
    case 4: 
    case 12: 
    case 14: 
    case 15: 
    case 17: 
    case 5: 
    case 6: 
    case 7: 
    case 8: 
    case 9: 
    case 10: 
    case 2: 
    case 3: 
    case 1: 
    case 11: 
    case 13: 
    case 16: 
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
                    if (paramybe.jdField_a_of_type_Boolean)
                    {
                      QQToast.a(this, 1, anvx.a(2131713927), 0).a();
                      return;
                    }
                    xbp.a(this, new OpenPlayerBuilder(new VidListPlayInfo(paramybe.jdField_f_of_type_JavaLangString, paramybe.jdField_b_of_type_JavaLangString), 29).a(), null);
                    return;
                    if (paramybe.g != 0) {
                      break;
                    }
                    paramView = new Intent(this, QQBrowserActivity.class);
                    paramView.putExtra("url", paramybe.jdField_i_of_type_JavaLangString);
                    startActivity(paramView);
                  } while (!QLog.isColorLevel());
                  QLog.d("Q.qqstory.msgList", 2, "StoryMessageListActivity#onItemClick() TYPE_OFFICIAL open webview!");
                  return;
                  if (paramybe.g != 1) {
                    break;
                  }
                  paramView = new Intent(this, JumpActivity.class);
                  paramView.setData(Uri.parse(paramybe.jdField_i_of_type_JavaLangString));
                  startActivity(paramView);
                } while (!QLog.isColorLevel());
                QLog.d("Q.qqstory.msgList", 2, "StoryMessageListActivity#onItemClick() TYPE_OFFICIAL open jumpActivity!");
                return;
              } while (!QLog.isColorLevel());
              QLog.e("Q.qqstory.msgList", 2, "StoryMessageListActivity#onItemClick() unknow url_type = " + paramybe.g);
              return;
              QQStoryShareGroupProfileActivity.a(this, 2, paramybe.m, null, 7, 0);
              return;
              paramybe = ((wke)wjs.a(2)).a();
              if (paramybe != null) {
                break;
              }
            } while (!QLog.isColorLevel());
            QLog.e("Q.qqstory.msgList", 2, "self user item == null");
            return;
            paramybe = paramybe.getUserIconJumpURL();
            if (!android.text.TextUtils.isEmpty(paramybe)) {
              break;
            }
          } while (!QLog.isColorLevel());
          QLog.e("Q.qqstory.msgList", 2, "jumpUrl is empty");
          return;
          paramView = new Intent(this, QQBrowserActivity.class);
          paramView.putExtra("url", paramybe);
          startActivity(paramView);
          return;
          StoryDetailActivity.a(this, paramybe.jdField_f_of_type_JavaLangString, 23, paramybe.jdField_c_of_type_Int, 0, paramybe.jdField_b_of_type_Int);
          return;
          StoryDetailActivity.a(this, paramybe.jdField_f_of_type_JavaLangString, 23, 0, paramybe.jdField_b_of_type_Int);
          return;
          QQToast.a(this, -1, anvx.a(2131713903), 0).a();
          return;
          paramView = new StringBuilder("https://story.now.qq.com/m/vote/index.html?_wv=3&_nav_alpha=0");
          paramView.append("&vid=").append(paramybe.jdField_b_of_type_JavaLangString);
          ykq.a("Q.qqstory.msgList", "go to story vote detail web. url = %s.", paramView.toString());
          paramybe = new Intent(this, QQBrowserActivity.class);
          paramybe.putExtra("url", paramView.toString());
          startActivity(paramybe);
        } while (!QLog.isColorLevel());
        QLog.d("Q.qqstory.msgList", 2, "StoryMessageListActivity#onItemClick() TYPE_ANSWER_MY_VOTE open webview!");
        return;
        paramView = new StringBuilder("https://story.now.qq.com/m/score/index.html?_wv=3&_nav_alpha=0");
        paramView.append("&vid=").append(paramybe.jdField_b_of_type_JavaLangString);
        ykq.a("Q.qqstory.msgList", "go to story grade detail web. url = %s.", paramView.toString());
        paramybe = new Intent(this, QQBrowserActivity.class);
        paramybe.putExtra("url", paramView.toString());
        paramybe.putExtra("startOpenPageTime", System.currentTimeMillis());
        startActivity(paramybe);
      } while (!QLog.isColorLevel());
      QLog.d("Q.qqstory.msgList", 2, "StoryMessageListActivity#onItemClick() TYPE_ANSWER_MY_GRADE open webview!");
      return;
    case 18: 
      xbp.a(this, new OpenPlayerBuilder(new VidListPlayInfo(paramybe.r, paramybe.jdField_b_of_type_JavaLangString), 126).a(), null);
      return;
    }
    xbp.b(this, paramybe.jdField_b_of_type_JavaLangString, paramybe.s, 29);
  }
  
  public CharSequence b(ybe paramybe)
  {
    return anvx.a(2131713896) + paramybe.e;
  }
  
  public CharSequence c(ybe paramybe)
  {
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(anvx.a(2131713907));
    int i = localSpannableStringBuilder.length();
    localSpannableStringBuilder.append(paramybe.n);
    localSpannableStringBuilder.setSpan(new ForegroundColorSpan(this.app.getApp().getResources().getColor(2131167026)), i, localSpannableStringBuilder.length(), 33);
    ykq.b("Q.qqstory.msgList", "get vote publish string : %s, voteQuestion : %s.", localSpannableStringBuilder, paramybe.n);
    paramybe = localSpannableStringBuilder;
    if (com.tencent.mobileqq.text.TextUtils.hasSysEmotion(localSpannableStringBuilder.toString())) {
      paramybe = new QQText(bcsc.b(localSpannableStringBuilder.toString()), 3, 14);
    }
    return paramybe;
  }
  
  protected void c(int paramInt)
  {
    int i = this.jdField_a_of_type_ComTencentWidgetSwipListView.getFirstVisiblePosition();
    int j = this.jdField_a_of_type_ComTencentWidgetSwipListView.getLastVisiblePosition();
    if ((paramInt >= i) && (paramInt <= j))
    {
      View localView = this.jdField_a_of_type_ComTencentWidgetSwipListView.getChildAt(paramInt - i);
      this.jdField_a_of_type_Ybo.getView(paramInt, localView, this.jdField_a_of_type_ComTencentWidgetSwipListView);
    }
  }
  
  public CharSequence d(ybe paramybe)
  {
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(paramybe.o);
    localSpannableStringBuilder.append("\n");
    localSpannableStringBuilder.append("投票：");
    localSpannableStringBuilder.append(paramybe.n);
    localSpannableStringBuilder.setSpan(new ForegroundColorSpan(-4473925), 0, localSpannableStringBuilder.length(), 33);
    ykq.b("Q.qqstory.msgList", "get answer vote string : %s, voteQuestion : %s, voteAnswer : %s.", localSpannableStringBuilder, paramybe.n, paramybe.o);
    paramybe = localSpannableStringBuilder;
    if (com.tencent.mobileqq.text.TextUtils.hasSysEmotion(localSpannableStringBuilder.toString())) {
      paramybe = new QQText(bcsc.b(localSpannableStringBuilder.toString()), 3, 14);
    }
    return paramybe;
  }
  
  protected void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.msgList", 2, "onError");
    }
    this.jdField_b_of_type_Int = 3;
    if (this.jdField_a_of_type_JavaUtilArrayList.size() == 0)
    {
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(anvx.a(2131713891));
      this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(0, 2130846634, 0, 0);
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      if (this.jdField_c_of_type_Int == 0)
      {
        QQUserUIItem localQQUserUIItem = ((wke)wjs.a(2)).b(QQStoryContext.a().b());
        if ((localQQUserUIItem == null) || (!localQQUserUIItem.isVip)) {
          break label179;
        }
        i = 1;
        if (i == 0) {
          break label184;
        }
      }
    }
    label179:
    label184:
    for (int i = 1;; i = 2)
    {
      ykv.a("play_video", "exp_notice", i, 0, new String[] { "2", "", "", "" });
      c(this.jdField_a_of_type_JavaUtilArrayList.size());
      return;
      i = 0;
      break;
    }
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2131561726);
    super.findViewById(2131365119).setBackgroundColor(getResources().getColor(2131167086));
    this.jdField_a_of_type_AndroidViewView = super.findViewById(2131374559);
    this.jdField_b_of_type_AndroidViewView = super.findViewById(2131374646);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131366149));
    this.jdField_a_of_type_ComTencentWidgetSwipListView = ((SwipListView)super.findViewById(2131370221));
    this.jdField_a_of_type_Ybo = new ybo(this);
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setDragEnable(true);
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setAdapter(this.jdField_a_of_type_Ybo);
    setRightButton(2131690833, this);
    setRightViewTextDisable(0);
    paramBundle = getAppInterface();
    int i;
    if ((paramBundle instanceof QQAppInterface))
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)paramBundle);
      paramBundle = getIntent();
      if (paramBundle != null) {
        break label228;
      }
      i = 0;
      label158:
      this.jdField_c_of_type_Int = i;
      if (paramBundle != null) {
        break label239;
      }
      paramBundle = "0";
      label171:
      this.jdField_a_of_type_JavaLangString = paramBundle;
      if (this.jdField_c_of_type_Int != 2) {
        break label249;
      }
      super.setTitle(anvx.a(2131713895));
    }
    for (;;)
    {
      a();
      paramBundle = wyw.a();
      paramBundle.a(this, 2);
      paramBundle.a(this, 4);
      return true;
      QLog.e("Q.qqstory.msgList", 1, "cannot get QQAppInterface");
      break;
      label228:
      i = paramBundle.getIntExtra("qqstory_message_list_source", 0);
      break label158;
      label239:
      paramBundle = paramBundle.getStringExtra("qqstory_jump_source");
      break label171;
      label249:
      super.setTitle(anvx.a(2131713890));
    }
  }
  
  public void doOnDestroy()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
    }
    super.doOnDestroy();
  }
  
  public CharSequence e(ybe paramybe)
  {
    if (com.tencent.mobileqq.text.TextUtils.hasSysEmotion(paramybe.q)) {
      return new QQText(bcsc.b(paramybe.q), 3, 14);
    }
    return paramybe.q;
  }
  
  protected void e()
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
        ((ntj)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.GET_RED_POINT_EX_HANDLER)).a(i, this.jdField_c_of_type_Int);
        return;
      }
      if (this.jdField_b_of_type_Int == 2)
      {
        i = (int)(NetConnInfoCenter.getServerTimeMillis() / 1000L);
        if (QLog.isColorLevel()) {
          QLog.d("Q.qqstory.msgList", 2, "clearUnread by svr time, time=" + i);
        }
        ((ntj)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.GET_RED_POINT_EX_HANDLER)).a(i, this.jdField_c_of_type_Int);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.d("Q.qqstory.msgList", 2, "nothing to clear");
  }
  
  public CharSequence f(ybe paramybe)
  {
    Object localObject = anvx.a(2131713910);
    String str;
    if (com.tencent.mobileqq.text.TextUtils.hasSysEmotion(paramybe.q)) {
      str = bcsc.b(paramybe.q);
    }
    int i;
    for (localObject = new SpannableStringBuilder("A" + "\n" + (String)localObject + str);; localObject = new QQTextBuilder("A" + "\n" + (String)localObject + str, 3, 14))
    {
      i = "A".length();
      switch (paramybe.jdField_i_of_type_Int)
      {
      default: 
        return localObject;
        str = paramybe.q;
      }
    }
    xwj.a((SpannableStringBuilder)localObject, 0, i, 2130844546, 50, 22, 1);
    return localObject;
    xwj.a((SpannableStringBuilder)localObject, 0, i, 2130844548, 50, 22, 1);
    return localObject;
    xwj.a((SpannableStringBuilder)localObject, 0, i, 2130844547, 50, 22, 1);
    return localObject;
    xwj.a((SpannableStringBuilder)localObject, 0, i, 2130844545, 50, 22, 1);
    return localObject;
    xwj.a((SpannableStringBuilder)localObject, 0, i, 2130844544, 50, 22, 1);
    return localObject;
  }
  
  public void f()
  {
    if (!AppNetConnInfo.isNetSupport()) {
      QQToast.a(getApplicationContext(), 1, anvx.a(2131713899), 0).a();
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
    ntb.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Ntd, localReqDelAllMessage.toByteArray(), weg.a("StorySvc.del_710_all_message"));
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_Ybo.notifyDataSetChanged();
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131694296);
    this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(0, 2130841420, 0, 0);
    this.jdField_a_of_type_AndroidWidgetTextView.setClickable(false);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    setRightViewTextDisable(0);
  }
  
  public void finish()
  {
    e();
    super.finish();
  }
  
  public void g()
  {
    runOnUiThread(new StoryMessageListActivity.8(this));
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (this.jdField_b_of_type_Int == 3)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.qqstory.msgList", 2, "click retry first page");
        }
        this.jdField_b_of_type_AndroidViewView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        this.jdField_a_of_type_AndroidViewView.setVisibility(0);
        a();
        continue;
        ykv.a(a(), "clear_msg", 0, 0, new String[] { "", "", "", "" });
        if ((this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing())) {
          this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
        }
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = bhdj.a(this, 230).setMessage(anvx.a(2131713885)).setNegativeButton(2131690697, new ybj(this)).setPositiveButton(2131690833, new ybi(this));
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
        ykv.a(a(), "exp_sure", 0, 0, new String[] { "", "", "", "" });
      }
    }
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    Object localObject;
    if (this.jdField_a_of_type_Ybo.a(paramInt))
    {
      localObject = this.jdField_a_of_type_Ybo.a(paramInt);
      if (localObject == null) {
        return;
      }
      a((ybe)localObject, paramView);
      switch (((ybe)localObject).jdField_f_of_type_Int)
      {
      default: 
        paramInt = 0;
        switch (((ybe)localObject).jdField_a_of_type_Int)
        {
        default: 
          paramAdapterView = "";
          label155:
          if (!((ybe)localObject).jdField_a_of_type_Boolean) {}
          break;
        }
        break;
      }
    }
    for (paramView = "4";; paramView = "1")
    {
      localObject = ((wke)wjs.a(2)).b(QQStoryContext.a().b());
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
        ykv.a("play_video", "clk_msg", i, paramInt, new String[] { paramAdapterView, paramView, this.jdField_a_of_type_JavaLangString, "" });
        return;
        paramAdapterView = ((wke)wjs.a(2)).b(((ybe)localObject).jdField_a_of_type_JavaLangString);
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
        if (((ybe)localObject).h == 0) {}
        for (paramInt = 6;; paramInt = 5) {
          break;
        }
        paramInt = 7;
        break;
        paramInt = 8;
        break;
        paramInt = 9;
        break;
        if (QQStoryContext.a().a(((ybe)localObject).jdField_c_of_type_JavaLangString)) {}
        for (paramAdapterView = "2";; paramAdapterView = "4") {
          break;
        }
        if (QQStoryContext.a().a(((ybe)localObject).jdField_c_of_type_JavaLangString)) {}
        for (paramAdapterView = "1";; paramAdapterView = "4") {
          break;
        }
        if (QQStoryContext.a().a(((ybe)localObject).jdField_d_of_type_JavaLangString)) {}
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
        c(this.jdField_a_of_type_JavaUtilArrayList.size());
        return;
      }
      if (this.jdField_c_of_type_Int == 2) {}
      for (this.jdField_c_of_type_Int = 3;; this.jdField_c_of_type_Int = 1)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.qqstory.msgList", 2, "convert to list");
        }
        ykv.a("play_video", "clk_more", 0, 0, new String[] { "", "", "", "" });
        break;
      }
    }
  }
  
  public boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (this.jdField_a_of_type_Ybo.a(paramInt))
    {
      if ((this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow != null) && (this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.b())) {
        this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.a();
      }
      paramView.setSelected(true);
      if (this.jdField_a_of_type_Bhjq == null)
      {
        this.jdField_a_of_type_Bhjq = new bhjq();
        this.jdField_a_of_type_Bhjq.a(2131374578, anvx.a(2131713904));
      }
      this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow = bhcw.a(paramView, this.jdField_a_of_type_Bhjq, new ybk(this, paramInt), new ybl(this, paramView));
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.messagenotify.StoryMessageListActivity
 * JD-Core Version:    0.7.0.1
 */