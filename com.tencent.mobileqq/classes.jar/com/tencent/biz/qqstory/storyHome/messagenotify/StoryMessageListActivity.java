package com.tencent.biz.qqstory.storyHome.messagenotify;

import ajjy;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.TextView;
import awbk;
import axkd;
import axkn;
import axku;
import baay;
import babr;
import bafb;
import bakh;
import bbmy;
import behi;
import behj;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.network.pb.qqstory_710_del_message.ReqDelAllMessage;
import com.tencent.biz.qqstory.network.pb.qqstory_710_del_message.ReqDelOneMessage;
import com.tencent.biz.qqstory.network.pb.qqstory_710_message.ReqStoryMessageList;
import com.tencent.biz.qqstory.playvideo.QQStoryWarningActivity;
import com.tencent.biz.qqstory.playvideo.entrance.OpenPlayerBuilder;
import com.tencent.biz.qqstory.playvideo.entrance.VidListPlayInfo;
import com.tencent.biz.qqstory.shareGroup.infocard.QQStoryShareGroupProfileActivity;
import com.tencent.biz.qqstory.storyHome.QQStoryBaseActivity;
import com.tencent.biz.qqstory.storyHome.detail.view.StoryDetailActivity;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import com.tencent.widget.BubblePopupWindow;
import com.tencent.widget.SwipListView;
import com.tribe.async.dispatch.Subscriber;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mmj;
import mml;
import mmr;
import skt;
import sqg;
import sqs;
import srn;
import sxp;
import tfk;
import tfy;
import tij;
import udd;
import uhy;
import uhz;
import uia;
import uib;
import uic;
import uid;
import uie;
import uif;
import uii;
import uik;
import uil;
import urk;
import urp;

public class StoryMessageListActivity
  extends QQStoryBaseActivity
  implements View.OnClickListener, behi, behj
{
  protected int a;
  protected long a;
  protected View a;
  protected TextView a;
  protected bafb a;
  protected bakh a;
  protected QQAppInterface a;
  protected BubblePopupWindow a;
  public SwipListView a;
  protected String a;
  public ArrayList<uhy> a;
  protected mml a;
  protected uii a;
  protected boolean a;
  public int b;
  protected View b;
  protected mml b;
  public boolean b;
  public int c;
  protected mml c;
  public boolean c;
  
  public StoryMessageListActivity()
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_b_of_type_Int = 4;
    this.jdField_a_of_type_Long = -1L;
    this.jdField_c_of_type_Int = 0;
    this.jdField_c_of_type_Boolean = true;
    this.jdField_a_of_type_Mml = new uhz(this);
    this.jdField_b_of_type_Mml = new uia(this);
    this.jdField_c_of_type_Mml = new uib(this);
  }
  
  @NonNull
  public static Intent a(Context paramContext, String paramString, int paramInt)
  {
    paramContext = new Intent(paramContext, StoryMessageListActivity.class);
    paramContext.putExtra("qqstory_message_list_source", paramInt);
    paramContext.putExtra("qqstory_jump_source", paramString);
    return paramContext;
  }
  
  public CharSequence a(uhy paramuhy)
  {
    if (paramuhy.jdField_a_of_type_Int == 2) {}
    Object localObject;
    for (paramuhy = paramuhy.e;; paramuhy = (uhy)localObject)
    {
      localObject = paramuhy;
      if (axku.a(paramuhy.toString())) {
        localObject = new axkd(awbk.b(paramuhy.toString()), 3, 14);
      }
      return localObject;
      localObject = new SpannableStringBuilder(ajjy.a(2131648719));
      int i = ((SpannableStringBuilder)localObject).length();
      ((SpannableStringBuilder)localObject).append(tfy.a(paramuhy.jdField_d_of_type_JavaLangString));
      ((SpannableStringBuilder)localObject).setSpan(new ForegroundColorSpan(this.app.getApp().getResources().getColor(2131101260)), i, ((SpannableStringBuilder)localObject).length(), 33);
      ((SpannableStringBuilder)localObject).append(':').append(paramuhy.e);
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
    mmj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_c_of_type_Mml, localReqStoryMessageList.toByteArray(), skt.a("StorySvc.get_710_message_list"));
  }
  
  public void a(int paramInt)
  {
    if (!AppNetConnInfo.isNetSupport()) {}
    do
    {
      bbmy.a(getApplicationContext(), 1, ajjy.a(2131648725), 0).a();
      do
      {
        return;
      } while (!this.jdField_a_of_type_Uii.a(paramInt));
      uhy localuhy = (uhy)this.jdField_a_of_type_JavaUtilArrayList.remove(paramInt);
      if (QLog.isColorLevel()) {
        QLog.i("Q.qqstory.msgList", 2, "doDeleteMessage pos=" + paramInt + " vid=" + localuhy.jdField_b_of_type_JavaLangString + " type=" + localuhy.jdField_a_of_type_Int + " cid=" + localuhy.jdField_c_of_type_Int);
      }
      qqstory_710_del_message.ReqDelOneMessage localReqDelOneMessage = new qqstory_710_del_message.ReqDelOneMessage();
      localReqDelOneMessage.feed_id.set(ByteStringMicro.copyFromUtf8(localuhy.jdField_f_of_type_JavaLangString));
      localReqDelOneMessage.message_id.set(localuhy.jdField_d_of_type_Int);
      mmj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_Mml, localReqDelOneMessage.toByteArray(), skt.a("StorySvc.del_710_one_message"));
      this.jdField_a_of_type_Uii.notifyDataSetChanged();
    } while (this.jdField_a_of_type_Uii.getCount() != 0);
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131628994);
    this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(0, 2130840935, 0, 0);
    this.jdField_a_of_type_AndroidWidgetTextView.setClickable(false);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    setRightViewTextDisable(0);
  }
  
  public void a(List<uhy> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {}
    ArrayList localArrayList;
    do
    {
      return;
      sqs localsqs = (sqs)sqg.a(2);
      localArrayList = new ArrayList();
      HashSet localHashSet = new HashSet();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        uhy localuhy = (uhy)paramList.next();
        String[] arrayOfString = new String[3];
        arrayOfString[0] = localuhy.jdField_a_of_type_JavaLangString;
        arrayOfString[1] = localuhy.jdField_c_of_type_JavaLangString;
        arrayOfString[2] = localuhy.jdField_d_of_type_JavaLangString;
        int j = arrayOfString.length;
        int i = 0;
        while (i < j)
        {
          localuhy = arrayOfString[i];
          if (!TextUtils.isEmpty(localuhy))
          {
            QQUserUIItem localQQUserUIItem = localsqs.b(localuhy);
            if (((localQQUserUIItem == null) || (!localQQUserUIItem.isAvailable())) && (!localHashSet.contains(localuhy)))
            {
              localArrayList.add(new srn("", localuhy));
              localHashSet.add(localuhy);
            }
          }
          i += 1;
        }
      }
      localHashSet.clear();
    } while (localArrayList.isEmpty());
    new sxp().a(1, localArrayList);
  }
  
  protected void a(List<uhy> paramList, boolean paramBoolean1, boolean paramBoolean2)
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
        this.jdField_a_of_type_Long = ((uhy)paramList.get(0)).jdField_a_of_type_Long;
        this.jdField_a_of_type_AndroidViewView.setVisibility(8);
        localObject = ((sqs)sqg.a(2)).b(QQStoryContext.a().b());
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
        urp.a("play_video", "exp_notice", i, 0, new String[] { "1", "", "", "" });
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
        this.jdField_a_of_type_Int = ((int)(((uhy)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_JavaUtilArrayList.size() - 1)).jdField_a_of_type_Long / 1000L) - 1);
        setRightViewTextDisable(1);
      }
      this.jdField_c_of_type_Boolean = paramBoolean2;
      this.jdField_a_of_type_Uii.notifyDataSetChanged();
      return;
      if (((this.jdField_c_of_type_Int == 0) || (this.jdField_c_of_type_Int == 2)) && (paramBoolean2))
      {
        this.jdField_a_of_type_AndroidViewView.setVisibility(8);
        break;
      }
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131628994);
      this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(0, 2130840935, 0, 0);
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
        urp.a("memory", "exp_msg", 0, 0, new String[] { localObject, "", "", "" });
        break;
      }
      label442:
      this.jdField_b_of_type_Int = 4;
    }
  }
  
  public void a(@NonNull Map<Subscriber, String> paramMap)
  {
    super.a(paramMap);
    paramMap.put(new uil(this), "");
    paramMap.put(new uik(this), "");
  }
  
  protected void a(uhy paramuhy, View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.msgList", 2, "click item type=" + paramuhy.jdField_a_of_type_Int);
    }
    switch (paramuhy.jdField_a_of_type_Int)
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
                    if (paramuhy.jdField_a_of_type_Boolean)
                    {
                      paramuhy = new Intent(this, QQStoryWarningActivity.class);
                      paramuhy.putExtra("tipsResource", ajjy.a(2131648724));
                      startActivity(paramuhy);
                      return;
                    }
                    tij.a(this, new OpenPlayerBuilder(new VidListPlayInfo(paramuhy.jdField_f_of_type_JavaLangString, paramuhy.jdField_b_of_type_JavaLangString), 29).a(), null);
                    return;
                    if (paramuhy.g != 0) {
                      break;
                    }
                    paramView = new Intent(this, QQBrowserActivity.class);
                    paramView.putExtra("url", paramuhy.jdField_i_of_type_JavaLangString);
                    startActivity(paramView);
                  } while (!QLog.isColorLevel());
                  QLog.d("Q.qqstory.msgList", 2, "StoryMessageListActivity#onItemClick() TYPE_OFFICIAL open webview!");
                  return;
                  if (paramuhy.g != 1) {
                    break;
                  }
                  paramView = new Intent(this, JumpActivity.class);
                  paramView.setData(Uri.parse(paramuhy.jdField_i_of_type_JavaLangString));
                  startActivity(paramView);
                } while (!QLog.isColorLevel());
                QLog.d("Q.qqstory.msgList", 2, "StoryMessageListActivity#onItemClick() TYPE_OFFICIAL open jumpActivity!");
                return;
              } while (!QLog.isColorLevel());
              QLog.e("Q.qqstory.msgList", 2, "StoryMessageListActivity#onItemClick() unknow url_type = " + paramuhy.g);
              return;
              QQStoryShareGroupProfileActivity.a(this, 2, paramuhy.m, null, 7, 0);
              return;
              paramuhy = ((sqs)sqg.a(2)).a();
              if (paramuhy != null) {
                break;
              }
            } while (!QLog.isColorLevel());
            QLog.e("Q.qqstory.msgList", 2, "self user item == null");
            return;
            paramuhy = paramuhy.getUserIconJumpURL();
            if (!TextUtils.isEmpty(paramuhy)) {
              break;
            }
          } while (!QLog.isColorLevel());
          QLog.e("Q.qqstory.msgList", 2, "jumpUrl is empty");
          return;
          paramView = new Intent(this, QQBrowserActivity.class);
          paramView.putExtra("url", paramuhy);
          startActivity(paramView);
          return;
          StoryDetailActivity.a(this, paramuhy.jdField_f_of_type_JavaLangString, 23, paramuhy.jdField_c_of_type_Int, 0, paramuhy.jdField_b_of_type_Int);
          return;
          StoryDetailActivity.a(this, paramuhy.jdField_f_of_type_JavaLangString, 23, 0, paramuhy.jdField_b_of_type_Int);
          return;
          bbmy.a(this, -1, ajjy.a(2131648730), 0).a();
          return;
          paramView = new StringBuilder("http://story.now.qq.com/m/vote/index.html?_wv=3&_nav_alpha=0");
          paramView.append("&vid=").append(paramuhy.jdField_b_of_type_JavaLangString);
          urk.a("Q.qqstory.msgList", "go to story vote detail web. url = %s.", paramView.toString());
          paramuhy = new Intent(this, QQBrowserActivity.class);
          paramuhy.putExtra("url", paramView.toString());
          startActivity(paramuhy);
        } while (!QLog.isColorLevel());
        QLog.d("Q.qqstory.msgList", 2, "StoryMessageListActivity#onItemClick() TYPE_ANSWER_MY_VOTE open webview!");
        return;
        paramView = new StringBuilder("http://story.now.qq.com/m/score/index.html?_wv=3&_nav_alpha=0");
        paramView.append("&vid=").append(paramuhy.jdField_b_of_type_JavaLangString);
        urk.a("Q.qqstory.msgList", "go to story grade detail web. url = %s.", paramView.toString());
        paramuhy = new Intent(this, QQBrowserActivity.class);
        paramuhy.putExtra("url", paramView.toString());
        paramuhy.putExtra("startOpenPageTime", System.currentTimeMillis());
        startActivity(paramuhy);
      } while (!QLog.isColorLevel());
      QLog.d("Q.qqstory.msgList", 2, "StoryMessageListActivity#onItemClick() TYPE_ANSWER_MY_GRADE open webview!");
      return;
    case 18: 
      tij.a(this, new OpenPlayerBuilder(new VidListPlayInfo(paramuhy.r, paramuhy.jdField_b_of_type_JavaLangString), 126).a(), null);
      return;
    }
    tij.b(this, paramuhy.jdField_b_of_type_JavaLangString, paramuhy.s, 29);
  }
  
  public boolean a(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (this.jdField_a_of_type_Uii.a(paramInt))
    {
      if ((this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow != null) && (this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.b())) {
        this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.b();
      }
      paramView.setSelected(true);
      if (this.jdField_a_of_type_Bakh == null)
      {
        this.jdField_a_of_type_Bakh = new bakh();
        this.jdField_a_of_type_Bakh.a(2131307517, ajjy.a(2131648731));
      }
      this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow = baay.a(paramView, this.jdField_a_of_type_Bakh, new uie(this, paramInt), new uif(this, paramView));
      return true;
    }
    return false;
  }
  
  public CharSequence b(uhy paramuhy)
  {
    return ajjy.a(2131648723) + paramuhy.e;
  }
  
  public CharSequence c(uhy paramuhy)
  {
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(ajjy.a(2131648734));
    int i = localSpannableStringBuilder.length();
    localSpannableStringBuilder.append(paramuhy.n);
    localSpannableStringBuilder.setSpan(new ForegroundColorSpan(this.app.getApp().getResources().getColor(2131101260)), i, localSpannableStringBuilder.length(), 33);
    urk.b("Q.qqstory.msgList", "get vote publish string : %s, voteQuestion : %s.", localSpannableStringBuilder, paramuhy.n);
    paramuhy = localSpannableStringBuilder;
    if (axku.a(localSpannableStringBuilder.toString())) {
      paramuhy = new axkd(awbk.b(localSpannableStringBuilder.toString()), 3, 14);
    }
    return paramuhy;
  }
  
  protected void c(int paramInt)
  {
    int i = this.jdField_a_of_type_ComTencentWidgetSwipListView.getFirstVisiblePosition();
    int j = this.jdField_a_of_type_ComTencentWidgetSwipListView.getLastVisiblePosition();
    if ((paramInt >= i) && (paramInt <= j))
    {
      View localView = this.jdField_a_of_type_ComTencentWidgetSwipListView.getChildAt(paramInt - i);
      this.jdField_a_of_type_Uii.getView(paramInt, localView, this.jdField_a_of_type_ComTencentWidgetSwipListView);
    }
  }
  
  public CharSequence d(uhy paramuhy)
  {
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(paramuhy.o);
    localSpannableStringBuilder.append("\n");
    localSpannableStringBuilder.append("投票：");
    localSpannableStringBuilder.append(paramuhy.n);
    localSpannableStringBuilder.setSpan(new ForegroundColorSpan(-4473925), 0, localSpannableStringBuilder.length(), 33);
    urk.b("Q.qqstory.msgList", "get answer vote string : %s, voteQuestion : %s, voteAnswer : %s.", localSpannableStringBuilder, paramuhy.n, paramuhy.o);
    paramuhy = localSpannableStringBuilder;
    if (axku.a(localSpannableStringBuilder.toString())) {
      paramuhy = new axkd(awbk.b(localSpannableStringBuilder.toString()), 3, 14);
    }
    return paramuhy;
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
      this.jdField_a_of_type_AndroidWidgetTextView.setText(ajjy.a(2131648718));
      this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(0, 2130845533, 0, 0);
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      if (this.jdField_c_of_type_Int == 0)
      {
        QQUserUIItem localQQUserUIItem = ((sqs)sqg.a(2)).b(QQStoryContext.a().b());
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
      urp.a("play_video", "exp_notice", i, 0, new String[] { "2", "", "", "" });
      c(this.jdField_a_of_type_JavaUtilArrayList.size());
      return;
      i = 0;
      break;
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2131495706);
    super.findViewById(2131299097).setBackgroundColor(getResources().getColor(2131101317));
    this.jdField_a_of_type_AndroidViewView = super.findViewById(2131307498);
    this.jdField_b_of_type_AndroidViewView = super.findViewById(2131307586);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131300049));
    this.jdField_a_of_type_ComTencentWidgetSwipListView = ((SwipListView)super.findViewById(2131303636));
    this.jdField_a_of_type_Uii = new uii(this);
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setDragEnable(true);
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setAdapter(this.jdField_a_of_type_Uii);
    setRightButton(2131625256, this);
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
      super.setTitle(ajjy.a(2131648722));
    }
    for (;;)
    {
      a();
      paramBundle = tfk.a();
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
      super.setTitle(ajjy.a(2131648717));
    }
  }
  
  public void doOnDestroy()
  {
    if ((this.jdField_a_of_type_Bafb != null) && (this.jdField_a_of_type_Bafb.isShowing())) {
      this.jdField_a_of_type_Bafb.dismiss();
    }
    super.doOnDestroy();
  }
  
  public CharSequence e(uhy paramuhy)
  {
    if (axku.a(paramuhy.q)) {
      return new axkd(awbk.b(paramuhy.q), 3, 14);
    }
    return paramuhy.q;
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
        ((mmr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(43)).a(i, this.jdField_c_of_type_Int);
        return;
      }
      if (this.jdField_b_of_type_Int == 2)
      {
        i = (int)(NetConnInfoCenter.getServerTimeMillis() / 1000L);
        if (QLog.isColorLevel()) {
          QLog.d("Q.qqstory.msgList", 2, "clearUnread by svr time, time=" + i);
        }
        ((mmr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(43)).a(i, this.jdField_c_of_type_Int);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.d("Q.qqstory.msgList", 2, "nothing to clear");
  }
  
  public CharSequence f(uhy paramuhy)
  {
    Object localObject = ajjy.a(2131648737);
    String str;
    if (axku.a(paramuhy.q)) {
      str = awbk.b(paramuhy.q);
    }
    int i;
    for (localObject = new SpannableStringBuilder("A" + "\n" + (String)localObject + str);; localObject = new axkn("A" + "\n" + (String)localObject + str, 3, 14))
    {
      i = "A".length();
      switch (paramuhy.jdField_i_of_type_Int)
      {
      default: 
        return localObject;
        str = paramuhy.q;
      }
    }
    udd.a((SpannableStringBuilder)localObject, 0, i, 2130843697, 50, 22, 1);
    return localObject;
    udd.a((SpannableStringBuilder)localObject, 0, i, 2130843699, 50, 22, 1);
    return localObject;
    udd.a((SpannableStringBuilder)localObject, 0, i, 2130843698, 50, 22, 1);
    return localObject;
    udd.a((SpannableStringBuilder)localObject, 0, i, 2130843696, 50, 22, 1);
    return localObject;
    udd.a((SpannableStringBuilder)localObject, 0, i, 2130843695, 50, 22, 1);
    return localObject;
  }
  
  public void f()
  {
    if (!AppNetConnInfo.isNetSupport()) {
      bbmy.a(getApplicationContext(), 1, ajjy.a(2131648726), 0).a();
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
    mmj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Mml, localReqDelAllMessage.toByteArray(), skt.a("StorySvc.del_710_all_message"));
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_Uii.notifyDataSetChanged();
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131628994);
    this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(0, 2130840935, 0, 0);
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
    default: 
    case 2131300049: 
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
    urp.a(a(), "clear_msg", 0, 0, new String[] { "", "", "", "" });
    if ((this.jdField_a_of_type_Bafb != null) && (this.jdField_a_of_type_Bafb.isShowing())) {
      this.jdField_a_of_type_Bafb.dismiss();
    }
    this.jdField_a_of_type_Bafb = babr.a(this, 230).setMessage(ajjy.a(2131648712)).setNegativeButton(2131625035, new uid(this)).setPositiveButton(2131625256, new uic(this));
    this.jdField_a_of_type_Bafb.getWindow().setBackgroundDrawable(new ColorDrawable(0));
    this.jdField_a_of_type_Bafb.show();
    urp.a(a(), "exp_sure", 0, 0, new String[] { "", "", "", "" });
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    Object localObject;
    if (this.jdField_a_of_type_Uii.a(paramInt))
    {
      localObject = this.jdField_a_of_type_Uii.a(paramInt);
      if (localObject == null) {
        return;
      }
      a((uhy)localObject, paramView);
      switch (((uhy)localObject).jdField_f_of_type_Int)
      {
      default: 
        paramInt = 0;
        switch (((uhy)localObject).jdField_a_of_type_Int)
        {
        default: 
          paramAdapterView = "";
          label155:
          if (!((uhy)localObject).jdField_a_of_type_Boolean) {}
          break;
        }
        break;
      }
    }
    for (paramView = "4";; paramView = "1")
    {
      localObject = ((sqs)sqg.a(2)).b(QQStoryContext.a().b());
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
        urp.a("play_video", "clk_msg", i, paramInt, new String[] { paramAdapterView, paramView, this.jdField_a_of_type_JavaLangString, "" });
        return;
        paramAdapterView = ((sqs)sqg.a(2)).b(((uhy)localObject).jdField_a_of_type_JavaLangString);
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
        if (((uhy)localObject).h == 0) {}
        for (paramInt = 6;; paramInt = 5) {
          break;
        }
        paramInt = 7;
        break;
        paramInt = 8;
        break;
        paramInt = 9;
        break;
        if (QQStoryContext.a().a(((uhy)localObject).jdField_c_of_type_JavaLangString)) {}
        for (paramAdapterView = "2";; paramAdapterView = "4") {
          break;
        }
        if (QQStoryContext.a().a(((uhy)localObject).jdField_c_of_type_JavaLangString)) {}
        for (paramAdapterView = "1";; paramAdapterView = "4") {
          break;
        }
        if (QQStoryContext.a().a(((uhy)localObject).jdField_d_of_type_JavaLangString)) {}
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
        urp.a("play_video", "clk_more", 0, 0, new String[] { "", "", "", "" });
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.messagenotify.StoryMessageListActivity
 * JD-Core Version:    0.7.0.1
 */