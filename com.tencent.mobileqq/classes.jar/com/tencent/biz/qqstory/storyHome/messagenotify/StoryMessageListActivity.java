package com.tencent.biz.qqstory.storyHome.messagenotify;

import ajya;
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
import axau;
import aykk;
import ayku;
import aylc;
import bbcq;
import bbdj;
import bbgu;
import bbmf;
import bcql;
import bfpt;
import bfpu;
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
import mxf;
import mxh;
import mxn;
import sxm;
import tcz;
import tdl;
import teg;
import tki;
import tsd;
import tsr;
import tvc;
import upw;
import uur;
import uus;
import uut;
import uuu;
import uuv;
import uuw;
import uux;
import uuy;
import uvb;
import uvd;
import uve;
import ved;
import vei;

public class StoryMessageListActivity
  extends QQStoryBaseActivity
  implements View.OnClickListener, bfpt, bfpu
{
  protected int a;
  protected long a;
  protected View a;
  protected TextView a;
  protected bbgu a;
  protected bbmf a;
  protected QQAppInterface a;
  protected BubblePopupWindow a;
  public SwipListView a;
  protected String a;
  public ArrayList<uur> a;
  protected mxh a;
  protected uvb a;
  protected boolean a;
  public int b;
  protected View b;
  protected mxh b;
  public boolean b;
  public int c;
  protected mxh c;
  public boolean c;
  
  public StoryMessageListActivity()
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_b_of_type_Int = 4;
    this.jdField_a_of_type_Long = -1L;
    this.jdField_c_of_type_Int = 0;
    this.jdField_c_of_type_Boolean = true;
    this.jdField_a_of_type_Mxh = new uus(this);
    this.jdField_b_of_type_Mxh = new uut(this);
    this.jdField_c_of_type_Mxh = new uuu(this);
  }
  
  @NonNull
  public static Intent a(Context paramContext, String paramString, int paramInt)
  {
    paramContext = new Intent(paramContext, StoryMessageListActivity.class);
    paramContext.putExtra("qqstory_message_list_source", paramInt);
    paramContext.putExtra("qqstory_jump_source", paramString);
    return paramContext;
  }
  
  public CharSequence a(uur paramuur)
  {
    if (paramuur.jdField_a_of_type_Int == 2) {}
    Object localObject;
    for (paramuur = paramuur.e;; paramuur = (uur)localObject)
    {
      localObject = paramuur;
      if (aylc.a(paramuur.toString())) {
        localObject = new aykk(axau.b(paramuur.toString()), 3, 14);
      }
      return localObject;
      localObject = new SpannableStringBuilder(ajya.a(2131714519));
      int i = ((SpannableStringBuilder)localObject).length();
      ((SpannableStringBuilder)localObject).append(tsr.a(paramuur.jdField_d_of_type_JavaLangString));
      ((SpannableStringBuilder)localObject).setSpan(new ForegroundColorSpan(this.app.getApp().getResources().getColor(2131166854)), i, ((SpannableStringBuilder)localObject).length(), 33);
      ((SpannableStringBuilder)localObject).append(':').append(paramuur.e);
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
    mxf.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_c_of_type_Mxh, localReqStoryMessageList.toByteArray(), sxm.a("StorySvc.get_710_message_list"));
  }
  
  public void a(int paramInt)
  {
    if (!AppNetConnInfo.isNetSupport()) {}
    do
    {
      bcql.a(getApplicationContext(), 1, ajya.a(2131714525), 0).a();
      do
      {
        return;
      } while (!this.jdField_a_of_type_Uvb.a(paramInt));
      uur localuur = (uur)this.jdField_a_of_type_JavaUtilArrayList.remove(paramInt);
      if (QLog.isColorLevel()) {
        QLog.i("Q.qqstory.msgList", 2, "doDeleteMessage pos=" + paramInt + " vid=" + localuur.jdField_b_of_type_JavaLangString + " type=" + localuur.jdField_a_of_type_Int + " cid=" + localuur.jdField_c_of_type_Int);
      }
      qqstory_710_del_message.ReqDelOneMessage localReqDelOneMessage = new qqstory_710_del_message.ReqDelOneMessage();
      localReqDelOneMessage.feed_id.set(ByteStringMicro.copyFromUtf8(localuur.jdField_f_of_type_JavaLangString));
      localReqDelOneMessage.message_id.set(localuur.jdField_d_of_type_Int);
      mxf.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_Mxh, localReqDelOneMessage.toByteArray(), sxm.a("StorySvc.del_710_one_message"));
      this.jdField_a_of_type_Uvb.notifyDataSetChanged();
    } while (this.jdField_a_of_type_Uvb.getCount() != 0);
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131694659);
    this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(0, 2130840999, 0, 0);
    this.jdField_a_of_type_AndroidWidgetTextView.setClickable(false);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    setRightViewTextDisable(0);
  }
  
  public void a(List<uur> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {}
    ArrayList localArrayList;
    do
    {
      return;
      tdl localtdl = (tdl)tcz.a(2);
      localArrayList = new ArrayList();
      HashSet localHashSet = new HashSet();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        uur localuur = (uur)paramList.next();
        String[] arrayOfString = new String[3];
        arrayOfString[0] = localuur.jdField_a_of_type_JavaLangString;
        arrayOfString[1] = localuur.jdField_c_of_type_JavaLangString;
        arrayOfString[2] = localuur.jdField_d_of_type_JavaLangString;
        int j = arrayOfString.length;
        int i = 0;
        while (i < j)
        {
          localuur = arrayOfString[i];
          if (!TextUtils.isEmpty(localuur))
          {
            QQUserUIItem localQQUserUIItem = localtdl.b(localuur);
            if (((localQQUserUIItem == null) || (!localQQUserUIItem.isAvailable())) && (!localHashSet.contains(localuur)))
            {
              localArrayList.add(new teg("", localuur));
              localHashSet.add(localuur);
            }
          }
          i += 1;
        }
      }
      localHashSet.clear();
    } while (localArrayList.isEmpty());
    new tki().a(1, localArrayList);
  }
  
  protected void a(List<uur> paramList, boolean paramBoolean1, boolean paramBoolean2)
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
        this.jdField_a_of_type_Long = ((uur)paramList.get(0)).jdField_a_of_type_Long;
        this.jdField_a_of_type_AndroidViewView.setVisibility(8);
        localObject = ((tdl)tcz.a(2)).b(QQStoryContext.a().b());
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
        vei.a("play_video", "exp_notice", i, 0, new String[] { "1", "", "", "" });
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
        this.jdField_a_of_type_Int = ((int)(((uur)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_JavaUtilArrayList.size() - 1)).jdField_a_of_type_Long / 1000L) - 1);
        setRightViewTextDisable(1);
      }
      this.jdField_c_of_type_Boolean = paramBoolean2;
      this.jdField_a_of_type_Uvb.notifyDataSetChanged();
      return;
      if (((this.jdField_c_of_type_Int == 0) || (this.jdField_c_of_type_Int == 2)) && (paramBoolean2))
      {
        this.jdField_a_of_type_AndroidViewView.setVisibility(8);
        break;
      }
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131694659);
      this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(0, 2130840999, 0, 0);
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
        vei.a("memory", "exp_msg", 0, 0, new String[] { localObject, "", "", "" });
        break;
      }
      label442:
      this.jdField_b_of_type_Int = 4;
    }
  }
  
  public void a(@NonNull Map<Subscriber, String> paramMap)
  {
    super.a(paramMap);
    paramMap.put(new uve(this), "");
    paramMap.put(new uvd(this), "");
  }
  
  protected void a(uur paramuur, View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.msgList", 2, "click item type=" + paramuur.jdField_a_of_type_Int);
    }
    switch (paramuur.jdField_a_of_type_Int)
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
                    if (paramuur.jdField_a_of_type_Boolean)
                    {
                      paramuur = new Intent(this, QQStoryWarningActivity.class);
                      paramuur.putExtra("tipsResource", ajya.a(2131714524));
                      startActivity(paramuur);
                      return;
                    }
                    tvc.a(this, new OpenPlayerBuilder(new VidListPlayInfo(paramuur.jdField_f_of_type_JavaLangString, paramuur.jdField_b_of_type_JavaLangString), 29).a(), null);
                    return;
                    if (paramuur.g != 0) {
                      break;
                    }
                    paramView = new Intent(this, QQBrowserActivity.class);
                    paramView.putExtra("url", paramuur.jdField_i_of_type_JavaLangString);
                    startActivity(paramView);
                  } while (!QLog.isColorLevel());
                  QLog.d("Q.qqstory.msgList", 2, "StoryMessageListActivity#onItemClick() TYPE_OFFICIAL open webview!");
                  return;
                  if (paramuur.g != 1) {
                    break;
                  }
                  paramView = new Intent(this, JumpActivity.class);
                  paramView.setData(Uri.parse(paramuur.jdField_i_of_type_JavaLangString));
                  startActivity(paramView);
                } while (!QLog.isColorLevel());
                QLog.d("Q.qqstory.msgList", 2, "StoryMessageListActivity#onItemClick() TYPE_OFFICIAL open jumpActivity!");
                return;
              } while (!QLog.isColorLevel());
              QLog.e("Q.qqstory.msgList", 2, "StoryMessageListActivity#onItemClick() unknow url_type = " + paramuur.g);
              return;
              QQStoryShareGroupProfileActivity.a(this, 2, paramuur.m, null, 7, 0);
              return;
              paramuur = ((tdl)tcz.a(2)).a();
              if (paramuur != null) {
                break;
              }
            } while (!QLog.isColorLevel());
            QLog.e("Q.qqstory.msgList", 2, "self user item == null");
            return;
            paramuur = paramuur.getUserIconJumpURL();
            if (!TextUtils.isEmpty(paramuur)) {
              break;
            }
          } while (!QLog.isColorLevel());
          QLog.e("Q.qqstory.msgList", 2, "jumpUrl is empty");
          return;
          paramView = new Intent(this, QQBrowserActivity.class);
          paramView.putExtra("url", paramuur);
          startActivity(paramView);
          return;
          StoryDetailActivity.a(this, paramuur.jdField_f_of_type_JavaLangString, 23, paramuur.jdField_c_of_type_Int, 0, paramuur.jdField_b_of_type_Int);
          return;
          StoryDetailActivity.a(this, paramuur.jdField_f_of_type_JavaLangString, 23, 0, paramuur.jdField_b_of_type_Int);
          return;
          bcql.a(this, -1, ajya.a(2131714530), 0).a();
          return;
          paramView = new StringBuilder("http://story.now.qq.com/m/vote/index.html?_wv=3&_nav_alpha=0");
          paramView.append("&vid=").append(paramuur.jdField_b_of_type_JavaLangString);
          ved.a("Q.qqstory.msgList", "go to story vote detail web. url = %s.", paramView.toString());
          paramuur = new Intent(this, QQBrowserActivity.class);
          paramuur.putExtra("url", paramView.toString());
          startActivity(paramuur);
        } while (!QLog.isColorLevel());
        QLog.d("Q.qqstory.msgList", 2, "StoryMessageListActivity#onItemClick() TYPE_ANSWER_MY_VOTE open webview!");
        return;
        paramView = new StringBuilder("http://story.now.qq.com/m/score/index.html?_wv=3&_nav_alpha=0");
        paramView.append("&vid=").append(paramuur.jdField_b_of_type_JavaLangString);
        ved.a("Q.qqstory.msgList", "go to story grade detail web. url = %s.", paramView.toString());
        paramuur = new Intent(this, QQBrowserActivity.class);
        paramuur.putExtra("url", paramView.toString());
        paramuur.putExtra("startOpenPageTime", System.currentTimeMillis());
        startActivity(paramuur);
      } while (!QLog.isColorLevel());
      QLog.d("Q.qqstory.msgList", 2, "StoryMessageListActivity#onItemClick() TYPE_ANSWER_MY_GRADE open webview!");
      return;
    case 18: 
      tvc.a(this, new OpenPlayerBuilder(new VidListPlayInfo(paramuur.r, paramuur.jdField_b_of_type_JavaLangString), 126).a(), null);
      return;
    }
    tvc.b(this, paramuur.jdField_b_of_type_JavaLangString, paramuur.s, 29);
  }
  
  public boolean a(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (this.jdField_a_of_type_Uvb.a(paramInt))
    {
      if ((this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow != null) && (this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.b())) {
        this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.b();
      }
      paramView.setSelected(true);
      if (this.jdField_a_of_type_Bbmf == null)
      {
        this.jdField_a_of_type_Bbmf = new bbmf();
        this.jdField_a_of_type_Bbmf.a(2131373232, ajya.a(2131714531));
      }
      this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow = bbcq.a(paramView, this.jdField_a_of_type_Bbmf, new uux(this, paramInt), new uuy(this, paramView));
      return true;
    }
    return false;
  }
  
  public CharSequence b(uur paramuur)
  {
    return ajya.a(2131714523) + paramuur.e;
  }
  
  public CharSequence c(uur paramuur)
  {
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(ajya.a(2131714534));
    int i = localSpannableStringBuilder.length();
    localSpannableStringBuilder.append(paramuur.n);
    localSpannableStringBuilder.setSpan(new ForegroundColorSpan(this.app.getApp().getResources().getColor(2131166854)), i, localSpannableStringBuilder.length(), 33);
    ved.b("Q.qqstory.msgList", "get vote publish string : %s, voteQuestion : %s.", localSpannableStringBuilder, paramuur.n);
    paramuur = localSpannableStringBuilder;
    if (aylc.a(localSpannableStringBuilder.toString())) {
      paramuur = new aykk(axau.b(localSpannableStringBuilder.toString()), 3, 14);
    }
    return paramuur;
  }
  
  protected void c(int paramInt)
  {
    int i = this.jdField_a_of_type_ComTencentWidgetSwipListView.getFirstVisiblePosition();
    int j = this.jdField_a_of_type_ComTencentWidgetSwipListView.getLastVisiblePosition();
    if ((paramInt >= i) && (paramInt <= j))
    {
      View localView = this.jdField_a_of_type_ComTencentWidgetSwipListView.getChildAt(paramInt - i);
      this.jdField_a_of_type_Uvb.getView(paramInt, localView, this.jdField_a_of_type_ComTencentWidgetSwipListView);
    }
  }
  
  public CharSequence d(uur paramuur)
  {
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(paramuur.o);
    localSpannableStringBuilder.append("\n");
    localSpannableStringBuilder.append("投票：");
    localSpannableStringBuilder.append(paramuur.n);
    localSpannableStringBuilder.setSpan(new ForegroundColorSpan(-4473925), 0, localSpannableStringBuilder.length(), 33);
    ved.b("Q.qqstory.msgList", "get answer vote string : %s, voteQuestion : %s, voteAnswer : %s.", localSpannableStringBuilder, paramuur.n, paramuur.o);
    paramuur = localSpannableStringBuilder;
    if (aylc.a(localSpannableStringBuilder.toString())) {
      paramuur = new aykk(axau.b(localSpannableStringBuilder.toString()), 3, 14);
    }
    return paramuur;
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
      this.jdField_a_of_type_AndroidWidgetTextView.setText(ajya.a(2131714518));
      this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(0, 2130845722, 0, 0);
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      if (this.jdField_c_of_type_Int == 0)
      {
        QQUserUIItem localQQUserUIItem = ((tdl)tcz.a(2)).b(QQStoryContext.a().b());
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
      vei.a("play_video", "exp_notice", i, 0, new String[] { "2", "", "", "" });
      c(this.jdField_a_of_type_JavaUtilArrayList.size());
      return;
      i = 0;
      break;
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2131561296);
    super.findViewById(2131364656).setBackgroundColor(getResources().getColor(2131166912));
    this.jdField_a_of_type_AndroidViewView = super.findViewById(2131373213);
    this.jdField_b_of_type_AndroidViewView = super.findViewById(2131373301);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131365645));
    this.jdField_a_of_type_ComTencentWidgetSwipListView = ((SwipListView)super.findViewById(2131369306));
    this.jdField_a_of_type_Uvb = new uvb(this);
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setDragEnable(true);
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setAdapter(this.jdField_a_of_type_Uvb);
    setRightButton(2131690817, this);
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
      super.setTitle(ajya.a(2131714522));
    }
    for (;;)
    {
      a();
      paramBundle = tsd.a();
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
      super.setTitle(ajya.a(2131714517));
    }
  }
  
  public void doOnDestroy()
  {
    if ((this.jdField_a_of_type_Bbgu != null) && (this.jdField_a_of_type_Bbgu.isShowing())) {
      this.jdField_a_of_type_Bbgu.dismiss();
    }
    super.doOnDestroy();
  }
  
  public CharSequence e(uur paramuur)
  {
    if (aylc.a(paramuur.q)) {
      return new aykk(axau.b(paramuur.q), 3, 14);
    }
    return paramuur.q;
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
        ((mxn)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(43)).a(i, this.jdField_c_of_type_Int);
        return;
      }
      if (this.jdField_b_of_type_Int == 2)
      {
        i = (int)(NetConnInfoCenter.getServerTimeMillis() / 1000L);
        if (QLog.isColorLevel()) {
          QLog.d("Q.qqstory.msgList", 2, "clearUnread by svr time, time=" + i);
        }
        ((mxn)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(43)).a(i, this.jdField_c_of_type_Int);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.d("Q.qqstory.msgList", 2, "nothing to clear");
  }
  
  public CharSequence f(uur paramuur)
  {
    Object localObject = ajya.a(2131714537);
    String str;
    if (aylc.a(paramuur.q)) {
      str = axau.b(paramuur.q);
    }
    int i;
    for (localObject = new SpannableStringBuilder("A" + "\n" + (String)localObject + str);; localObject = new ayku("A" + "\n" + (String)localObject + str, 3, 14))
    {
      i = "A".length();
      switch (paramuur.jdField_i_of_type_Int)
      {
      default: 
        return localObject;
        str = paramuur.q;
      }
    }
    upw.a((SpannableStringBuilder)localObject, 0, i, 2130843779, 50, 22, 1);
    return localObject;
    upw.a((SpannableStringBuilder)localObject, 0, i, 2130843781, 50, 22, 1);
    return localObject;
    upw.a((SpannableStringBuilder)localObject, 0, i, 2130843780, 50, 22, 1);
    return localObject;
    upw.a((SpannableStringBuilder)localObject, 0, i, 2130843778, 50, 22, 1);
    return localObject;
    upw.a((SpannableStringBuilder)localObject, 0, i, 2130843777, 50, 22, 1);
    return localObject;
  }
  
  public void f()
  {
    if (!AppNetConnInfo.isNetSupport()) {
      bcql.a(getApplicationContext(), 1, ajya.a(2131714526), 0).a();
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
    mxf.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Mxh, localReqDelAllMessage.toByteArray(), sxm.a("StorySvc.del_710_all_message"));
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_Uvb.notifyDataSetChanged();
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131694659);
    this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(0, 2130840999, 0, 0);
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
    case 2131365645: 
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
    vei.a(a(), "clear_msg", 0, 0, new String[] { "", "", "", "" });
    if ((this.jdField_a_of_type_Bbgu != null) && (this.jdField_a_of_type_Bbgu.isShowing())) {
      this.jdField_a_of_type_Bbgu.dismiss();
    }
    this.jdField_a_of_type_Bbgu = bbdj.a(this, 230).setMessage(ajya.a(2131714512)).setNegativeButton(2131690596, new uuw(this)).setPositiveButton(2131690817, new uuv(this));
    this.jdField_a_of_type_Bbgu.getWindow().setBackgroundDrawable(new ColorDrawable(0));
    this.jdField_a_of_type_Bbgu.show();
    vei.a(a(), "exp_sure", 0, 0, new String[] { "", "", "", "" });
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    Object localObject;
    if (this.jdField_a_of_type_Uvb.a(paramInt))
    {
      localObject = this.jdField_a_of_type_Uvb.a(paramInt);
      if (localObject == null) {
        return;
      }
      a((uur)localObject, paramView);
      switch (((uur)localObject).jdField_f_of_type_Int)
      {
      default: 
        paramInt = 0;
        switch (((uur)localObject).jdField_a_of_type_Int)
        {
        default: 
          paramAdapterView = "";
          label155:
          if (!((uur)localObject).jdField_a_of_type_Boolean) {}
          break;
        }
        break;
      }
    }
    for (paramView = "4";; paramView = "1")
    {
      localObject = ((tdl)tcz.a(2)).b(QQStoryContext.a().b());
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
        vei.a("play_video", "clk_msg", i, paramInt, new String[] { paramAdapterView, paramView, this.jdField_a_of_type_JavaLangString, "" });
        return;
        paramAdapterView = ((tdl)tcz.a(2)).b(((uur)localObject).jdField_a_of_type_JavaLangString);
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
        if (((uur)localObject).h == 0) {}
        for (paramInt = 6;; paramInt = 5) {
          break;
        }
        paramInt = 7;
        break;
        paramInt = 8;
        break;
        paramInt = 9;
        break;
        if (QQStoryContext.a().a(((uur)localObject).jdField_c_of_type_JavaLangString)) {}
        for (paramAdapterView = "2";; paramAdapterView = "4") {
          break;
        }
        if (QQStoryContext.a().a(((uur)localObject).jdField_c_of_type_JavaLangString)) {}
        for (paramAdapterView = "1";; paramAdapterView = "4") {
          break;
        }
        if (QQStoryContext.a().a(((uur)localObject).jdField_d_of_type_JavaLangString)) {}
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
        vei.a("play_video", "clk_more", 0, 0, new String[] { "", "", "", "" });
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.messagenotify.StoryMessageListActivity
 * JD-Core Version:    0.7.0.1
 */