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
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.TextView;
import anzj;
import bcsa;
import begp;
import begz;
import behh;
import bhkx;
import bhlq;
import bhpc;
import bhuk;
import bljm;
import bljn;
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
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AdapterView;
import com.tencent.widget.BubblePopupWindow;
import com.tencent.widget.SwipListView;
import com.tribe.async.dispatch.Subscriber;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import nkm;
import nko;
import nku;
import wnu;
import wth;
import wtt;
import wuo;
import xaq;
import xil;
import xiz;
import xlj;
import ygd;
import yky;
import ykz;
import yla;
import ylb;
import ylc;
import yld;
import yle;
import ylf;
import yli;
import ylk;
import yll;
import yuk;
import yup;

public class StoryMessageListActivity
  extends QQStoryBaseActivity
  implements View.OnClickListener, bljm, bljn
{
  protected int a;
  protected long a;
  protected View a;
  protected TextView a;
  protected bhpc a;
  protected bhuk a;
  protected QQAppInterface a;
  protected BubblePopupWindow a;
  public SwipListView a;
  protected String a;
  public ArrayList<yky> a;
  protected nko a;
  protected yli a;
  protected boolean a;
  public int b;
  protected View b;
  protected nko b;
  public boolean b;
  public int c;
  protected nko c;
  public boolean c;
  
  public StoryMessageListActivity()
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_b_of_type_Int = 4;
    this.jdField_a_of_type_Long = -1L;
    this.jdField_c_of_type_Int = 0;
    this.jdField_c_of_type_Boolean = true;
    this.jdField_a_of_type_Nko = new ykz(this);
    this.jdField_b_of_type_Nko = new yla(this);
    this.jdField_c_of_type_Nko = new ylb(this);
  }
  
  @NonNull
  public static Intent a(Context paramContext, String paramString, int paramInt)
  {
    paramContext = new Intent(paramContext, StoryMessageListActivity.class);
    paramContext.putExtra("qqstory_message_list_source", paramInt);
    paramContext.putExtra("qqstory_jump_source", paramString);
    return paramContext;
  }
  
  public CharSequence a(yky paramyky)
  {
    if (paramyky.jdField_a_of_type_Int == 2) {}
    Object localObject;
    for (paramyky = paramyky.e;; paramyky = (yky)localObject)
    {
      localObject = paramyky;
      if (behh.a(paramyky.toString())) {
        localObject = new begp(bcsa.b(paramyky.toString()), 3, 14);
      }
      return localObject;
      localObject = new SpannableStringBuilder(anzj.a(2131713313));
      int i = ((SpannableStringBuilder)localObject).length();
      ((SpannableStringBuilder)localObject).append(xiz.a(paramyky.jdField_d_of_type_JavaLangString));
      ((SpannableStringBuilder)localObject).setSpan(new ForegroundColorSpan(this.app.getApp().getResources().getColor(2131166990)), i, ((SpannableStringBuilder)localObject).length(), 33);
      ((SpannableStringBuilder)localObject).append(':').append(paramyky.e);
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
    nkm.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_c_of_type_Nko, localReqStoryMessageList.toByteArray(), wnu.a("StorySvc.get_710_message_list"));
  }
  
  public void a(int paramInt)
  {
    if (!AppNetConnInfo.isNetSupport()) {}
    do
    {
      QQToast.a(getApplicationContext(), 1, anzj.a(2131713319), 0).a();
      do
      {
        return;
      } while (!this.jdField_a_of_type_Yli.a(paramInt));
      yky localyky = (yky)this.jdField_a_of_type_JavaUtilArrayList.remove(paramInt);
      if (QLog.isColorLevel()) {
        QLog.i("Q.qqstory.msgList", 2, "doDeleteMessage pos=" + paramInt + " vid=" + localyky.jdField_b_of_type_JavaLangString + " type=" + localyky.jdField_a_of_type_Int + " cid=" + localyky.jdField_c_of_type_Int);
      }
      qqstory_710_del_message.ReqDelOneMessage localReqDelOneMessage = new qqstory_710_del_message.ReqDelOneMessage();
      localReqDelOneMessage.feed_id.set(ByteStringMicro.copyFromUtf8(localyky.jdField_f_of_type_JavaLangString));
      localReqDelOneMessage.message_id.set(localyky.jdField_d_of_type_Int);
      nkm.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_Nko, localReqDelOneMessage.toByteArray(), wnu.a("StorySvc.del_710_one_message"));
      this.jdField_a_of_type_Yli.notifyDataSetChanged();
    } while (this.jdField_a_of_type_Yli.getCount() != 0);
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131693999);
    this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(0, 2130841378, 0, 0);
    this.jdField_a_of_type_AndroidWidgetTextView.setClickable(false);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    setRightViewTextDisable(0);
  }
  
  public void a(List<yky> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {}
    ArrayList localArrayList;
    do
    {
      return;
      wtt localwtt = (wtt)wth.a(2);
      localArrayList = new ArrayList();
      HashSet localHashSet = new HashSet();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        yky localyky = (yky)paramList.next();
        String[] arrayOfString = new String[3];
        arrayOfString[0] = localyky.jdField_a_of_type_JavaLangString;
        arrayOfString[1] = localyky.jdField_c_of_type_JavaLangString;
        arrayOfString[2] = localyky.jdField_d_of_type_JavaLangString;
        int j = arrayOfString.length;
        int i = 0;
        while (i < j)
        {
          localyky = arrayOfString[i];
          if (!TextUtils.isEmpty(localyky))
          {
            QQUserUIItem localQQUserUIItem = localwtt.b(localyky);
            if (((localQQUserUIItem == null) || (!localQQUserUIItem.isAvailable())) && (!localHashSet.contains(localyky)))
            {
              localArrayList.add(new wuo("", localyky));
              localHashSet.add(localyky);
            }
          }
          i += 1;
        }
      }
      localHashSet.clear();
    } while (localArrayList.isEmpty());
    new xaq().a(1, localArrayList);
  }
  
  protected void a(List<yky> paramList, boolean paramBoolean1, boolean paramBoolean2)
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
        this.jdField_a_of_type_Long = ((yky)paramList.get(0)).jdField_a_of_type_Long;
        this.jdField_a_of_type_AndroidViewView.setVisibility(8);
        localObject = ((wtt)wth.a(2)).b(QQStoryContext.a().b());
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
        yup.a("play_video", "exp_notice", i, 0, new String[] { "1", "", "", "" });
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
        this.jdField_a_of_type_Int = ((int)(((yky)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_JavaUtilArrayList.size() - 1)).jdField_a_of_type_Long / 1000L) - 1);
        setRightViewTextDisable(1);
      }
      this.jdField_c_of_type_Boolean = paramBoolean2;
      this.jdField_a_of_type_Yli.notifyDataSetChanged();
      return;
      if (((this.jdField_c_of_type_Int == 0) || (this.jdField_c_of_type_Int == 2)) && (paramBoolean2))
      {
        this.jdField_a_of_type_AndroidViewView.setVisibility(8);
        break;
      }
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131693999);
      this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(0, 2130841378, 0, 0);
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
        yup.a("memory", "exp_msg", 0, 0, new String[] { localObject, "", "", "" });
        break;
      }
      label442:
      this.jdField_b_of_type_Int = 4;
    }
  }
  
  public void a(@NonNull Map<Subscriber, String> paramMap)
  {
    super.a(paramMap);
    paramMap.put(new yll(this), "");
    paramMap.put(new ylk(this), "");
  }
  
  protected void a(yky paramyky, View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.msgList", 2, "click item type=" + paramyky.jdField_a_of_type_Int);
    }
    switch (paramyky.jdField_a_of_type_Int)
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
                    if (paramyky.jdField_a_of_type_Boolean)
                    {
                      QQToast.a(this, 1, anzj.a(2131713348), 0).a();
                      return;
                    }
                    xlj.a(this, new OpenPlayerBuilder(new VidListPlayInfo(paramyky.jdField_f_of_type_JavaLangString, paramyky.jdField_b_of_type_JavaLangString), 29).a(), null);
                    return;
                    if (paramyky.g != 0) {
                      break;
                    }
                    paramView = new Intent(this, QQBrowserActivity.class);
                    paramView.putExtra("url", paramyky.jdField_i_of_type_JavaLangString);
                    startActivity(paramView);
                  } while (!QLog.isColorLevel());
                  QLog.d("Q.qqstory.msgList", 2, "StoryMessageListActivity#onItemClick() TYPE_OFFICIAL open webview!");
                  return;
                  if (paramyky.g != 1) {
                    break;
                  }
                  paramView = new Intent(this, JumpActivity.class);
                  paramView.setData(Uri.parse(paramyky.jdField_i_of_type_JavaLangString));
                  startActivity(paramView);
                } while (!QLog.isColorLevel());
                QLog.d("Q.qqstory.msgList", 2, "StoryMessageListActivity#onItemClick() TYPE_OFFICIAL open jumpActivity!");
                return;
              } while (!QLog.isColorLevel());
              QLog.e("Q.qqstory.msgList", 2, "StoryMessageListActivity#onItemClick() unknow url_type = " + paramyky.g);
              return;
              QQStoryShareGroupProfileActivity.a(this, 2, paramyky.m, null, 7, 0);
              return;
              paramyky = ((wtt)wth.a(2)).a();
              if (paramyky != null) {
                break;
              }
            } while (!QLog.isColorLevel());
            QLog.e("Q.qqstory.msgList", 2, "self user item == null");
            return;
            paramyky = paramyky.getUserIconJumpURL();
            if (!TextUtils.isEmpty(paramyky)) {
              break;
            }
          } while (!QLog.isColorLevel());
          QLog.e("Q.qqstory.msgList", 2, "jumpUrl is empty");
          return;
          paramView = new Intent(this, QQBrowserActivity.class);
          paramView.putExtra("url", paramyky);
          startActivity(paramView);
          return;
          StoryDetailActivity.a(this, paramyky.jdField_f_of_type_JavaLangString, 23, paramyky.jdField_c_of_type_Int, 0, paramyky.jdField_b_of_type_Int);
          return;
          StoryDetailActivity.a(this, paramyky.jdField_f_of_type_JavaLangString, 23, 0, paramyky.jdField_b_of_type_Int);
          return;
          QQToast.a(this, -1, anzj.a(2131713324), 0).a();
          return;
          paramView = new StringBuilder("https://story.now.qq.com/m/vote/index.html?_wv=3&_nav_alpha=0");
          paramView.append("&vid=").append(paramyky.jdField_b_of_type_JavaLangString);
          yuk.a("Q.qqstory.msgList", "go to story vote detail web. url = %s.", paramView.toString());
          paramyky = new Intent(this, QQBrowserActivity.class);
          paramyky.putExtra("url", paramView.toString());
          startActivity(paramyky);
        } while (!QLog.isColorLevel());
        QLog.d("Q.qqstory.msgList", 2, "StoryMessageListActivity#onItemClick() TYPE_ANSWER_MY_VOTE open webview!");
        return;
        paramView = new StringBuilder("https://story.now.qq.com/m/score/index.html?_wv=3&_nav_alpha=0");
        paramView.append("&vid=").append(paramyky.jdField_b_of_type_JavaLangString);
        yuk.a("Q.qqstory.msgList", "go to story grade detail web. url = %s.", paramView.toString());
        paramyky = new Intent(this, QQBrowserActivity.class);
        paramyky.putExtra("url", paramView.toString());
        paramyky.putExtra("startOpenPageTime", System.currentTimeMillis());
        startActivity(paramyky);
      } while (!QLog.isColorLevel());
      QLog.d("Q.qqstory.msgList", 2, "StoryMessageListActivity#onItemClick() TYPE_ANSWER_MY_GRADE open webview!");
      return;
    case 18: 
      xlj.a(this, new OpenPlayerBuilder(new VidListPlayInfo(paramyky.r, paramyky.jdField_b_of_type_JavaLangString), 126).a(), null);
      return;
    }
    xlj.b(this, paramyky.jdField_b_of_type_JavaLangString, paramyky.s, 29);
  }
  
  public boolean a(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (this.jdField_a_of_type_Yli.a(paramInt))
    {
      if ((this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow != null) && (this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.b())) {
        this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.b();
      }
      paramView.setSelected(true);
      if (this.jdField_a_of_type_Bhuk == null)
      {
        this.jdField_a_of_type_Bhuk = new bhuk();
        this.jdField_a_of_type_Bhuk.a(2131374572, anzj.a(2131713325));
      }
      this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow = bhkx.a(paramView, this.jdField_a_of_type_Bhuk, new yle(this, paramInt), new ylf(this, paramView));
      return true;
    }
    return false;
  }
  
  public CharSequence b(yky paramyky)
  {
    return anzj.a(2131713317) + paramyky.e;
  }
  
  public CharSequence c(yky paramyky)
  {
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(anzj.a(2131713328));
    int i = localSpannableStringBuilder.length();
    localSpannableStringBuilder.append(paramyky.n);
    localSpannableStringBuilder.setSpan(new ForegroundColorSpan(this.app.getApp().getResources().getColor(2131166990)), i, localSpannableStringBuilder.length(), 33);
    yuk.b("Q.qqstory.msgList", "get vote publish string : %s, voteQuestion : %s.", localSpannableStringBuilder, paramyky.n);
    paramyky = localSpannableStringBuilder;
    if (behh.a(localSpannableStringBuilder.toString())) {
      paramyky = new begp(bcsa.b(localSpannableStringBuilder.toString()), 3, 14);
    }
    return paramyky;
  }
  
  protected void c(int paramInt)
  {
    int i = this.jdField_a_of_type_ComTencentWidgetSwipListView.getFirstVisiblePosition();
    int j = this.jdField_a_of_type_ComTencentWidgetSwipListView.getLastVisiblePosition();
    if ((paramInt >= i) && (paramInt <= j))
    {
      View localView = this.jdField_a_of_type_ComTencentWidgetSwipListView.getChildAt(paramInt - i);
      this.jdField_a_of_type_Yli.getView(paramInt, localView, this.jdField_a_of_type_ComTencentWidgetSwipListView);
    }
  }
  
  public CharSequence d(yky paramyky)
  {
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(paramyky.o);
    localSpannableStringBuilder.append("\n");
    localSpannableStringBuilder.append("投票：");
    localSpannableStringBuilder.append(paramyky.n);
    localSpannableStringBuilder.setSpan(new ForegroundColorSpan(-4473925), 0, localSpannableStringBuilder.length(), 33);
    yuk.b("Q.qqstory.msgList", "get answer vote string : %s, voteQuestion : %s, voteAnswer : %s.", localSpannableStringBuilder, paramyky.n, paramyky.o);
    paramyky = localSpannableStringBuilder;
    if (behh.a(localSpannableStringBuilder.toString())) {
      paramyky = new begp(bcsa.b(localSpannableStringBuilder.toString()), 3, 14);
    }
    return paramyky;
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
      this.jdField_a_of_type_AndroidWidgetTextView.setText(anzj.a(2131713312));
      this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(0, 2130846630, 0, 0);
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      if (this.jdField_c_of_type_Int == 0)
      {
        QQUserUIItem localQQUserUIItem = ((wtt)wth.a(2)).b(QQStoryContext.a().b());
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
      yup.a("play_video", "exp_notice", i, 0, new String[] { "2", "", "", "" });
      c(this.jdField_a_of_type_JavaUtilArrayList.size());
      return;
      i = 0;
      break;
    }
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool);
    return bool;
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2131561780);
    super.findViewById(2131365008).setBackgroundColor(getResources().getColor(2131167050));
    this.jdField_a_of_type_AndroidViewView = super.findViewById(2131374553);
    this.jdField_b_of_type_AndroidViewView = super.findViewById(2131374640);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131366018));
    this.jdField_a_of_type_ComTencentWidgetSwipListView = ((SwipListView)super.findViewById(2131370052));
    this.jdField_a_of_type_Yli = new yli(this);
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setDragEnable(true);
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setAdapter(this.jdField_a_of_type_Yli);
    setRightButton(2131690716, this);
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
      super.setTitle(anzj.a(2131713316));
    }
    for (;;)
    {
      a();
      paramBundle = xil.a();
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
      super.setTitle(anzj.a(2131713311));
    }
  }
  
  public void doOnDestroy()
  {
    if ((this.jdField_a_of_type_Bhpc != null) && (this.jdField_a_of_type_Bhpc.isShowing())) {
      this.jdField_a_of_type_Bhpc.dismiss();
    }
    super.doOnDestroy();
  }
  
  public CharSequence e(yky paramyky)
  {
    if (behh.a(paramyky.q)) {
      return new begp(bcsa.b(paramyky.q), 3, 14);
    }
    return paramyky.q;
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
        ((nku)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(43)).a(i, this.jdField_c_of_type_Int);
        return;
      }
      if (this.jdField_b_of_type_Int == 2)
      {
        i = (int)(NetConnInfoCenter.getServerTimeMillis() / 1000L);
        if (QLog.isColorLevel()) {
          QLog.d("Q.qqstory.msgList", 2, "clearUnread by svr time, time=" + i);
        }
        ((nku)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(43)).a(i, this.jdField_c_of_type_Int);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.d("Q.qqstory.msgList", 2, "nothing to clear");
  }
  
  public CharSequence f(yky paramyky)
  {
    Object localObject = anzj.a(2131713331);
    String str;
    if (behh.a(paramyky.q)) {
      str = bcsa.b(paramyky.q);
    }
    int i;
    for (localObject = new SpannableStringBuilder("A" + "\n" + (String)localObject + str);; localObject = new begz("A" + "\n" + (String)localObject + str, 3, 14))
    {
      i = "A".length();
      switch (paramyky.jdField_i_of_type_Int)
      {
      default: 
        return localObject;
        str = paramyky.q;
      }
    }
    ygd.a((SpannableStringBuilder)localObject, 0, i, 2130844603, 50, 22, 1);
    return localObject;
    ygd.a((SpannableStringBuilder)localObject, 0, i, 2130844605, 50, 22, 1);
    return localObject;
    ygd.a((SpannableStringBuilder)localObject, 0, i, 2130844604, 50, 22, 1);
    return localObject;
    ygd.a((SpannableStringBuilder)localObject, 0, i, 2130844602, 50, 22, 1);
    return localObject;
    ygd.a((SpannableStringBuilder)localObject, 0, i, 2130844601, 50, 22, 1);
    return localObject;
  }
  
  public void f()
  {
    if (!AppNetConnInfo.isNetSupport()) {
      QQToast.a(getApplicationContext(), 1, anzj.a(2131713320), 0).a();
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
    nkm.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Nko, localReqDelAllMessage.toByteArray(), wnu.a("StorySvc.del_710_all_message"));
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_Yli.notifyDataSetChanged();
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131693999);
    this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(0, 2130841378, 0, 0);
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
        yup.a(a(), "clear_msg", 0, 0, new String[] { "", "", "", "" });
        if ((this.jdField_a_of_type_Bhpc != null) && (this.jdField_a_of_type_Bhpc.isShowing())) {
          this.jdField_a_of_type_Bhpc.dismiss();
        }
        this.jdField_a_of_type_Bhpc = bhlq.a(this, 230).setMessage(anzj.a(2131713306)).setNegativeButton(2131690580, new yld(this)).setPositiveButton(2131690716, new ylc(this));
        this.jdField_a_of_type_Bhpc.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        this.jdField_a_of_type_Bhpc.show();
        yup.a(a(), "exp_sure", 0, 0, new String[] { "", "", "", "" });
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
    if (this.jdField_a_of_type_Yli.a(paramInt))
    {
      localObject = this.jdField_a_of_type_Yli.a(paramInt);
      if (localObject == null) {
        return;
      }
      a((yky)localObject, paramView);
      switch (((yky)localObject).jdField_f_of_type_Int)
      {
      default: 
        paramInt = 0;
        switch (((yky)localObject).jdField_a_of_type_Int)
        {
        default: 
          paramAdapterView = "";
          label155:
          if (!((yky)localObject).jdField_a_of_type_Boolean) {}
          break;
        }
        break;
      }
    }
    for (paramView = "4";; paramView = "1")
    {
      localObject = ((wtt)wth.a(2)).b(QQStoryContext.a().b());
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
        yup.a("play_video", "clk_msg", i, paramInt, new String[] { paramAdapterView, paramView, this.jdField_a_of_type_JavaLangString, "" });
        return;
        paramAdapterView = ((wtt)wth.a(2)).b(((yky)localObject).jdField_a_of_type_JavaLangString);
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
        if (((yky)localObject).h == 0) {}
        for (paramInt = 6;; paramInt = 5) {
          break;
        }
        paramInt = 7;
        break;
        paramInt = 8;
        break;
        paramInt = 9;
        break;
        if (QQStoryContext.a().a(((yky)localObject).jdField_c_of_type_JavaLangString)) {}
        for (paramAdapterView = "2";; paramAdapterView = "4") {
          break;
        }
        if (QQStoryContext.a().a(((yky)localObject).jdField_c_of_type_JavaLangString)) {}
        for (paramAdapterView = "1";; paramAdapterView = "4") {
          break;
        }
        if (QQStoryContext.a().a(((yky)localObject).jdField_d_of_type_JavaLangString)) {}
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
        yup.a("play_video", "clk_more", 0, 0, new String[] { "", "", "", "" });
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.messagenotify.StoryMessageListActivity
 * JD-Core Version:    0.7.0.1
 */