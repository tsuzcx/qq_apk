package com.tencent.mobileqq.activity.aio.tips;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.support.v4.app.FragmentActivity;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.av.app.PstnSessionInfo;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.av.gaudio.AVNotifyCenter.UserInfo;
import com.tencent.av.gaudio.AVNotifyCenter.VideoRoomInfo;
import com.tencent.av.smallscreen.SmallScreenUtils;
import com.tencent.av.ui.CallbackWaitingActivityExt;
import com.tencent.av.ui.MultiVideoEnterPageActivity;
import com.tencent.av.utils.GVideoUpdateUtil;
import com.tencent.av.utils.PstnUtils;
import com.tencent.av.utils.UITools;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.DiscussionManager;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.util.FaceDrawable;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QAVGroupConfig.Report;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
import mqq.os.MqqHandler;
import wiv;
import wiw;
import wix;

public class VideoStatusTipsBar
  implements View.OnClickListener, TipsBarTask
{
  protected float a;
  Context jdField_a_of_type_AndroidContentContext;
  private View jdField_a_of_type_AndroidViewView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  private TipsManager jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private final String jdField_a_of_type_JavaLangString;
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  private wix jdField_a_of_type_Wix;
  private ImageView[] jdField_a_of_type_ArrayOfAndroidWidgetImageView = new ImageView[3];
  
  public VideoStatusTipsBar(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, TipsManager paramTipsManager, Context paramContext, MqqHandler paramMqqHandler)
  {
    this.jdField_a_of_type_JavaLangString = ("VideoStatusTipsBar." + paramSessionInfo.jdField_a_of_type_Int + "." + paramSessionInfo.jdField_a_of_type_JavaLangString + "_" + AudioHelper.a());
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager = paramTipsManager;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_MqqOsMqqHandler = paramMqqHandler;
    this.jdField_a_of_type_Float = paramContext.getResources().getDisplayMetrics().density;
    if (AudioHelper.e()) {
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, "VideoStatusTipsBar, curFriendUin[" + paramSessionInfo.jdField_a_of_type_JavaLangString + "], curType[" + paramSessionInfo.jdField_a_of_type_Int + "]");
    }
  }
  
  private int a(int paramInt)
  {
    int i = 0;
    switch (paramInt)
    {
    case 22: 
    default: 
      i = 3;
    case 20: 
    case 21: 
      return i;
    }
    return 2;
  }
  
  private void a(int paramInt1, String paramString, int paramInt2)
  {
    int i = 0;
    if (!NetworkUtil.d(this.jdField_a_of_type_AndroidContentContext.getApplicationContext())) {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 2131433117, 0).b(this.jdField_a_of_type_AndroidContentContext.getApplicationContext().getResources().getDimensionPixelSize(2131558448));
    }
    while (paramString == null) {
      return;
    }
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString);
    if ((paramInt2 == 2) && (!bool))
    {
      paramString = new HashMap();
      paramString.put("MultiAVType", String.valueOf(2));
      paramString.put("from", "tipBar");
      ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramString);
      return;
    }
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, MultiVideoEnterPageActivity.class);
    localIntent.addFlags(262144);
    localIntent.addFlags(268435456);
    long[] arrayOfLong;
    if (paramInt1 == 3000)
    {
      ArrayList localArrayList = ((DiscussionManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).a(paramString);
      if (localArrayList == null) {
        break label380;
      }
      int j = localArrayList.size();
      arrayOfLong = new long[j];
      while (i < j)
      {
        DiscussionMemberInfo localDiscussionMemberInfo = (DiscussionMemberInfo)localArrayList.get(i);
        if (localDiscussionMemberInfo != null) {
          arrayOfLong[i] = Long.valueOf(localDiscussionMemberInfo.memberUin).longValue();
        }
        i += 1;
      }
    }
    for (;;)
    {
      localIntent.putExtra("DiscussUinList", arrayOfLong);
      localIntent.putExtra("sessionType", 3);
      localIntent.putExtra("uin", paramString);
      localIntent.putExtra("uinType", paramInt1);
      localIntent.putExtra("Type", 3);
      localIntent.putExtra("GroupId", paramString);
      Long.valueOf(paramString).longValue();
      localIntent.putExtra("MultiAVType", paramInt2);
      localIntent.putExtra("flag", bool);
      ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localIntent);
      UITools.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
      GVideoUpdateUtil.a(this.jdField_a_of_type_AndroidContentContext, paramString, paramInt2, new wiw(this, localIntent));
      return;
      label380:
      arrayOfLong = null;
    }
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_AndroidViewView == null)
    {
      QAVGroupConfig.Report.a();
      this.jdField_a_of_type_AndroidViewView = ((LayoutInflater)this.jdField_a_of_type_AndroidContentContext.getSystemService("layout_inflater")).inflate(2130968650, null);
      this.jdField_a_of_type_AndroidViewView.setId(2131361896);
      this.jdField_a_of_type_AndroidViewView.setPadding(0, (int)(this.jdField_a_of_type_Float * 2.0F), 0, (int)(this.jdField_a_of_type_Float * 2.0F));
      this.jdField_a_of_type_AndroidViewView.setClickable(true);
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130838653);
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131363024));
      this.jdField_a_of_type_ArrayOfAndroidWidgetImageView[0] = ((ImageView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131363025));
      this.jdField_a_of_type_ArrayOfAndroidWidgetImageView[1] = ((ImageView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131363026));
      this.jdField_a_of_type_ArrayOfAndroidWidgetImageView[2] = ((ImageView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131363027));
    }
  }
  
  public int a()
  {
    return 60;
  }
  
  protected Drawable a(String paramString)
  {
    return FaceDrawable.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, (byte)2);
  }
  
  public View a(Object... paramVarArgs)
  {
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  String a(Context paramContext, String paramString, TextView paramTextView, float paramFloat)
  {
    TextPaint localTextPaint = paramTextView.getPaint();
    paramTextView = paramString;
    if (paramFloat > 0.0F)
    {
      float f1 = localTextPaint.measureText(paramString);
      paramTextView = paramString;
      if (f1 > paramFloat)
      {
        float f2 = paramFloat - localTextPaint.measureText("...");
        paramFloat = f1;
        paramContext = paramString;
        while ((f2 > 0.0F) && (paramFloat > f2) && (paramContext.length() > 0))
        {
          paramTextView = paramContext.substring(0, paramContext.length() - 1);
          f1 = localTextPaint.measureText(paramTextView);
          paramContext = paramTextView;
          paramFloat = f1;
          if (f1 == 0.0F)
          {
            paramContext = paramTextView;
            paramFloat = f1;
            if (paramTextView.length() > 0)
            {
              paramFloat = 1.0F + f2;
              paramContext = paramTextView;
            }
          }
        }
        paramTextView = paramString;
        if (f2 > 0.0F)
        {
          paramTextView = paramString;
          if (paramContext.length() > 0) {
            paramTextView = paramContext + "...";
          }
        }
      }
    }
    return paramTextView;
  }
  
  public void a()
  {
    a("showMeetinInvitedInfo", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 4, 0L);
  }
  
  public void a(int paramInt, String paramString1, String paramString2)
  {
    int i;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d(paramString1)) {
      i = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString1);
    }
    for (;;)
    {
      QLog.d(this.jdField_a_of_type_JavaLangString, 1, "refreshVideoStatus(): uinType:" + paramInt + ", peerUin:" + paramString1 + ",extraUin:" + paramString2 + ",sessionType:" + i);
      ImageView localImageView;
      TextView localTextView;
      if (((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c()) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().j()) && ((i == 1) || (i == 2) || (i == 5)) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == paramInt) && ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals(paramString1)) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals(paramString2)))) || ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d(paramString1)) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals(paramString1)))) {
        if (this.jdField_a_of_type_AndroidViewView == null)
        {
          this.jdField_a_of_type_AndroidViewView = ((LayoutInflater)this.jdField_a_of_type_AndroidContentContext.getSystemService("layout_inflater")).inflate(2130968650, null);
          this.jdField_a_of_type_AndroidViewView.setId(2131361896);
          this.jdField_a_of_type_AndroidViewView.setPadding(0, (int)(2.0F * this.jdField_a_of_type_Float), 0, (int)(2.0F * this.jdField_a_of_type_Float));
          this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130838653);
          this.jdField_a_of_type_AndroidViewView.setClickable(true);
          this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131363024));
          localImageView = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131363023);
          localTextView = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131363022);
          label323:
          this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
          if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c() == null) {}
        }
      }
      try
      {
        Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c());
        label390:
        String str;
        label452:
        boolean bool;
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d(paramString1))
        {
          UITools.a(this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_AndroidContentContext.getString(2131429180));
          str = "";
          if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d(paramString1)) {
            break label753;
          }
          paramString2 = str;
          if (i == 1) {
            paramString2 = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131429180);
          }
          if (i != 2) {
            break label886;
          }
          paramString2 = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131429181);
          a(null, paramString2, this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131494315), paramString1, 0);
          QLog.i(this.jdField_a_of_type_JavaLangString, 1, "refreshVideoStatus info=" + paramString2 + ", peerUin=" + paramString1);
          this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
          this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130838653);
          localImageView.setImageResource(2130838645);
          localImageView.setVisibility(0);
          if ((!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c()) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d(paramString1))) {
            break label844;
          }
          if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().g() != 2) {
            break label838;
          }
          bool = true;
          label584:
          a(bool);
          label590:
          if ((!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c()) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().e())) {
            break label852;
          }
          localTextView.setVisibility(0);
        }
        label753:
        do
        {
          return;
          if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c()) {
            break label889;
          }
          i = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().e();
          break;
          localImageView = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131363023);
          localTextView = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131363022);
          break label323;
          if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c()) {
            break label390;
          }
          if (paramInt == 1)
          {
            UITools.a(this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_AndroidContentContext.getString(2131428895), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b()));
            break label390;
          }
          UITools.a(this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_AndroidContentContext.getString(2131428895));
          break label390;
          paramString2 = str;
          if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c()) {
            break label886;
          }
          if (i == 1)
          {
            paramString2 = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131429087);
            break label452;
          }
          if (i == 5)
          {
            paramString2 = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131429555);
            break label452;
          }
          paramString2 = str;
          if (i != 2) {
            break label886;
          }
          paramString2 = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131429088);
          break label452;
          bool = false;
          break label584;
          a(true);
          break label590;
          localTextView.setVisibility(8);
          return;
        } while (b() != this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a());
        label838:
        label844:
        label852:
        this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a();
        return;
      }
      catch (Exception paramString2)
      {
        label886:
        for (;;) {}
        label889:
        i = 0;
      }
    }
  }
  
  public void a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt != 1000) {}
    label332:
    label505:
    for (;;)
    {
      return;
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1))
      {
        a("onAIOEvent.1." + paramInt, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 0, 0L);
        return;
      }
      int i = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().e();
      if (i == 3)
      {
        if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
          a("onAIOEvent.2." + paramInt, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 0, 0L);
        }
      }
      else {
        for (;;)
        {
          if ((!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) || (!((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50)).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
            break label505;
          }
          paramVarArgs = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
          if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d(paramVarArgs))
          {
            paramInt = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramVarArgs);
            if (paramInt == 1) {
              ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800478C", "0X800478C", 0, 0, "", "", "", "");
            }
            if (paramInt == 2) {
              ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004788", "0X8004788", 0, 0, "", "", "", "");
            }
          }
          a(0, paramVarArgs, "");
          long l1 = 0L;
          try
          {
            long l2 = Long.parseLong(paramVarArgs);
            l1 = l2;
          }
          catch (Exception localException)
          {
            Intent localIntent;
            break label332;
          }
          if (l1 == 0L) {
            break;
          }
          localIntent = new Intent("tencent.video.q2v.sendQueryRoomInfoRequest");
          localIntent.putExtra("roomId", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramVarArgs));
          localIntent.putExtra("peerUin", Long.parseLong(paramVarArgs));
          localIntent.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
          this.jdField_a_of_type_AndroidContentContext.sendBroadcast(localIntent);
          return;
          if ((i == 1) || (i == 2)) {
            a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().f(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d());
          } else if (i == 5) {
            a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().jdField_a_of_type_JavaLangString);
          }
        }
      }
    }
  }
  
  public void a(String paramString1, int paramInt1, String paramString2, int paramInt2, long paramLong)
  {
    if (AudioHelper.e()) {
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, "refreshMultiVideoStatus[" + paramString1 + "], uinType[" + paramInt1 + "], uin[" + paramString2 + "], type[" + paramInt2 + "], memberUin[" + paramLong + "], curType[" + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int + "]");
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 3000) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1)) {}
    for (;;)
    {
      if (b() == this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a()) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a();
      }
      return;
      label2306:
      try
      {
        l4 = Long.parseLong(paramString2);
        k = UITools.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
        l1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(k, l4);
        localVector = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(l4);
        j = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(l4);
        l3 = l1;
        i = paramInt2;
        if (k == 1)
        {
          l3 = l1;
          i = paramInt2;
          if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(k, l4))
          {
            l3 = l1;
            i = paramInt2;
            if (paramString2 != null)
            {
              l3 = l1;
              i = paramInt2;
              if (TextUtils.isDigitsOnly(paramString2))
              {
                l2 = l1;
                paramInt1 = paramInt2;
              }
            }
          }
        }
      }
      catch (NumberFormatException paramString1)
      {
        label1029:
        label2312:
        label2318:
        for (;;)
        {
          long l4;
          int k;
          Vector localVector;
          int j;
          long l3;
          int i;
          TextView localTextView;
          ImageView localImageView1;
          ImageView localImageView2;
          Object localObject5;
          Object localObject3;
          Object localObject4;
          Object localObject1;
          Object localObject2;
          String str;
          try
          {
            long l1;
            paramString1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(Long.parseLong(paramString2));
            i = j;
            l2 = l1;
            paramInt1 = paramInt2;
            if (paramString1 != null)
            {
              l2 = l1;
              paramInt1 = paramInt2;
              paramInt2 = a(paramString1.c);
              l2 = l1;
              paramInt1 = paramInt2;
              l1 = paramString1.jdField_a_of_type_Int;
              l2 = l1;
              paramInt1 = paramInt2;
              i = paramString1.jdField_b_of_type_Int;
              paramInt1 = paramInt2;
              l2 = l1;
            }
            paramInt2 = i;
            i = paramInt1;
            paramInt1 = paramInt2;
            if ((paramInt1 == 10) || (paramInt1 == 2))
            {
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(l4, paramInt1, (int)l2);
              paramString1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(l4, paramInt1);
              paramInt2 = 21;
              if (paramString1 != null)
              {
                if (paramString1.jdField_a_of_type_Int <= 0) {
                  paramInt2 = 23;
                }
                this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(2, l4, paramInt1, paramInt2, paramString1.jdField_a_of_type_Int);
              }
            }
            if (l2 <= 0L) {
              break;
            }
            c();
            localTextView = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131363022);
            localImageView1 = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131363023);
            localImageView2 = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131363020);
            localObject5 = null;
            localObject3 = null;
            localObject4 = null;
            paramString1 = null;
            localObject1 = null;
            localObject2 = null;
            str = null;
            if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(k, l4)) {
              break label1302;
            }
            localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
            paramString1 = Long.toString(paramLong);
            if ((paramLong == 0L) || (((String)localObject2).equals(Long.valueOf(paramLong))) || (paramInt1 == 2)) {
              break label1112;
            }
            localObject1 = Long.toString(l4);
            paramInt2 = 2;
            if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) {
              paramInt2 = 1;
            }
            localObject1 = ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1, (String)localObject1, paramInt2, 0);
            if ((i == 1) || (i == 2))
            {
              if (this.jdField_a_of_type_Wix != null) {
                break label1015;
              }
              this.jdField_a_of_type_Wix = new wix(this);
              if (this.jdField_a_of_type_MqqOsMqqHandler != null)
              {
                this.jdField_a_of_type_MqqOsMqqHandler.postDelayed(this.jdField_a_of_type_Wix, 3000L);
                this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().e(false);
              }
            }
            if (i != 1) {
              break label1054;
            }
            if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 3000) {
              break label1029;
            }
            paramString1 = this.jdField_a_of_type_AndroidContentContext.getString(2131433756);
            localTextView.setVisibility(8);
            if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 3000) {
              break label1270;
            }
            UITools.a(this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_AndroidContentContext.getString(2131428905));
            localImageView1.setVisibility(0);
            localObject2 = localObject1;
            localObject1 = paramString1;
            paramString1 = (String)localObject2;
            paramInt2 = this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131494315);
            a(paramString1, (String)localObject1, paramInt2, String.valueOf(l4), paramInt1);
            localTextView.setTextColor(paramInt2);
            if ((paramInt1 != 2) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString2))) {
              break label2280;
            }
            localImageView2.setImageDrawable(null);
            ReportController.b(null, "dc00899", "Grp_video", "", "notice", "exp_aio", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "" + TroopUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString), "", "");
            this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
            if ((localVector != null) && (localVector.size() != 0)) {
              break label1997;
            }
            paramString1 = this.jdField_a_of_type_ArrayOfAndroidWidgetImageView;
            paramInt2 = paramString1.length;
            paramInt1 = 0;
            if (paramInt1 >= paramInt2) {
              break label2066;
            }
            paramString1[paramInt1].setVisibility(8);
            paramInt1 += 1;
            continue;
            paramString1 = paramString1;
            l4 = 0L;
          }
          catch (NumberFormatException paramString1)
          {
            l3 = l2;
            i = paramInt1;
            if (QLog.isColorLevel())
            {
              QLog.e(this.jdField_a_of_type_JavaLangString, 2, "refreshMultiVideoStatus error : " + paramString1);
              i = paramInt1;
              l3 = l2;
            }
          }
          long l2 = l3;
          paramInt1 = j;
          continue;
          label1015:
          this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacks(this.jdField_a_of_type_Wix);
          continue;
          label1302:
          if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1)
          {
            paramString1 = this.jdField_a_of_type_AndroidContentContext.getString(2131433758);
            continue;
            label1054:
            if (i == 2)
            {
              if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000)
              {
                paramString1 = this.jdField_a_of_type_AndroidContentContext.getString(2131433757);
                continue;
              }
              if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1)
              {
                paramString1 = this.jdField_a_of_type_AndroidContentContext.getString(2131433759);
                continue;
                label1112:
                if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().e())
                {
                  localObject2 = this.jdField_a_of_type_AndroidContentContext.getString(2131433764);
                  this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().e(false);
                  localObject1 = str;
                  paramString1 = (String)localObject2;
                  if (paramInt1 != 2) {
                    continue;
                  }
                  localTextView.setVisibility(8);
                  localObject1 = str;
                  paramString1 = (String)localObject2;
                  continue;
                }
                if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000) {
                  paramString1 = this.jdField_a_of_type_AndroidContentContext.getString(2131433762);
                }
                for (;;)
                {
                  this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().e(true);
                  paramString1 = String.format(paramString1, new Object[] { Long.valueOf(l2) });
                  localTextView.setVisibility(0);
                  localObject1 = str;
                  break;
                  paramString1 = (String)localObject1;
                  if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) {
                    paramString1 = this.jdField_a_of_type_AndroidContentContext.getString(2131433763);
                  }
                }
                label1270:
                if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1) {
                  continue;
                }
                UITools.a(this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_AndroidContentContext.getString(2131428906), paramInt1);
                continue;
                localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(k, l4);
                if (localObject1 == null) {
                  if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000)
                  {
                    paramString1 = this.jdField_a_of_type_AndroidContentContext.getString(2131433751);
                    label1347:
                    str = String.format(paramString1, new Object[] { Long.valueOf(l2) });
                    localObject1 = localObject2;
                    paramString1 = str;
                    if (paramInt1 == 2)
                    {
                      localObject1 = localObject2;
                      paramString1 = str;
                      if (l2 > 99L)
                      {
                        paramString1 = this.jdField_a_of_type_AndroidContentContext.getString(2131429515);
                        localObject1 = localObject2;
                      }
                    }
                  }
                }
                for (;;)
                {
                  localTextView.setVisibility(8);
                  if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000)
                  {
                    UITools.a(this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_AndroidContentContext.getString(2131429092));
                    localObject2 = paramString1;
                    paramString1 = (String)localObject1;
                    localObject1 = localObject2;
                    break;
                    paramString1 = localObject5;
                    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1) {
                      break label1347;
                    }
                    paramString1 = this.jdField_a_of_type_AndroidContentContext.getString(2131433755);
                    break label1347;
                    if (((AVNotifyCenter.UserInfo)localObject1).jdField_a_of_type_Boolean)
                    {
                      paramString1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(((AVNotifyCenter.UserInfo)localObject1).jdField_a_of_type_Long);
                      if (paramString1 == null)
                      {
                        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000) {
                          paramString1 = this.jdField_a_of_type_AndroidContentContext.getString(2131433751);
                        }
                        for (;;)
                        {
                          str = String.format(paramString1, new Object[] { Long.valueOf(l2) });
                          localObject1 = localObject2;
                          paramString1 = str;
                          if (paramInt1 != 2) {
                            break;
                          }
                          localObject1 = localObject2;
                          paramString1 = str;
                          if (l2 <= 99L) {
                            break;
                          }
                          paramString1 = this.jdField_a_of_type_AndroidContentContext.getString(2131429515);
                          localObject1 = localObject2;
                          break;
                          paramString1 = localObject3;
                          if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) {
                            paramString1 = this.jdField_a_of_type_AndroidContentContext.getString(2131433755);
                          }
                        }
                      }
                      if (l2 == 1L)
                      {
                        localObject2 = this.jdField_a_of_type_AndroidContentContext.getString(2131433752);
                        localObject1 = paramString1;
                        paramString1 = (String)localObject2;
                        continue;
                      }
                      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000) {
                        localObject1 = this.jdField_a_of_type_AndroidContentContext.getString(2131433750);
                      }
                      for (;;)
                      {
                        localObject2 = String.format((String)localObject1, new Object[] { Long.valueOf(l2) });
                        if ((paramInt1 != 2) || (l2 <= 99L)) {
                          break label2318;
                        }
                        localObject2 = this.jdField_a_of_type_AndroidContentContext.getString(2131429516);
                        localObject1 = paramString1;
                        paramString1 = (String)localObject2;
                        break;
                        localObject1 = localObject4;
                        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) {
                          localObject1 = this.jdField_a_of_type_AndroidContentContext.getString(2131433754);
                        }
                      }
                    }
                    localObject1 = Long.toString(((AVNotifyCenter.UserInfo)localObject1).jdField_a_of_type_Long);
                    localObject2 = Long.toString(l4);
                    paramInt2 = 2;
                    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) {
                      paramInt2 = 1;
                    }
                    localObject2 = ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject1, (String)localObject2, paramInt2, 0);
                    if (l2 == 1L)
                    {
                      paramString1 = this.jdField_a_of_type_AndroidContentContext.getString(2131433752);
                      localObject1 = localObject2;
                      continue;
                    }
                    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000) {
                      paramString1 = this.jdField_a_of_type_AndroidContentContext.getString(2131433750);
                    }
                    for (;;)
                    {
                      str = String.format(paramString1, new Object[] { Long.valueOf(l2) });
                      localObject1 = localObject2;
                      paramString1 = str;
                      if (paramInt1 != 2) {
                        break;
                      }
                      localObject1 = localObject2;
                      paramString1 = str;
                      if (l2 <= 99L) {
                        break;
                      }
                      paramString1 = this.jdField_a_of_type_AndroidContentContext.getString(2131429516);
                      localObject1 = localObject2;
                      break;
                      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) {
                        paramString1 = this.jdField_a_of_type_AndroidContentContext.getString(2131433754);
                      }
                    }
                  }
                  if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) {
                    UITools.a(this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_AndroidContentContext.getString(2131429093), paramInt1);
                  }
                  localObject2 = paramString1;
                  paramString1 = (String)localObject1;
                  localObject1 = localObject2;
                  break;
                  label1997:
                  if (localVector.size() == 1)
                  {
                    this.jdField_a_of_type_ArrayOfAndroidWidgetImageView[0].setVisibility(0);
                    this.jdField_a_of_type_ArrayOfAndroidWidgetImageView[1].setVisibility(8);
                    this.jdField_a_of_type_ArrayOfAndroidWidgetImageView[2].setVisibility(8);
                    this.jdField_a_of_type_ArrayOfAndroidWidgetImageView[0].setImageDrawable(a(String.valueOf(((AVNotifyCenter.UserInfo)localVector.get(0)).jdField_a_of_type_Long)));
                    localImageView1.setImageResource(2130838645);
                    if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c()) {
                      break label2312;
                    }
                    if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(k, l4)) {
                      break label2306;
                    }
                    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().g() != 2) {
                      break label2300;
                    }
                  }
                  label2280:
                  label2300:
                  for (boolean bool = true;; bool = false)
                  {
                    a(bool);
                    return;
                    if (localVector.size() == 2)
                    {
                      this.jdField_a_of_type_ArrayOfAndroidWidgetImageView[0].setVisibility(0);
                      this.jdField_a_of_type_ArrayOfAndroidWidgetImageView[1].setVisibility(0);
                      this.jdField_a_of_type_ArrayOfAndroidWidgetImageView[2].setVisibility(8);
                      this.jdField_a_of_type_ArrayOfAndroidWidgetImageView[0].setImageDrawable(a(String.valueOf(((AVNotifyCenter.UserInfo)localVector.get(0)).jdField_a_of_type_Long)));
                      this.jdField_a_of_type_ArrayOfAndroidWidgetImageView[1].setImageDrawable(a(String.valueOf(((AVNotifyCenter.UserInfo)localVector.get(1)).jdField_a_of_type_Long)));
                      break;
                    }
                    paramInt1 = 0;
                    while (paramInt1 < this.jdField_a_of_type_ArrayOfAndroidWidgetImageView.length)
                    {
                      this.jdField_a_of_type_ArrayOfAndroidWidgetImageView[paramInt1].setVisibility(0);
                      this.jdField_a_of_type_ArrayOfAndroidWidgetImageView[paramInt1].setImageDrawable(a(String.valueOf(((AVNotifyCenter.UserInfo)localVector.get(paramInt1)).jdField_a_of_type_Long)));
                      paramInt1 += 1;
                    }
                    break;
                    localImageView2.setImageResource(2130845727);
                    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
                    break;
                  }
                  a(true);
                  return;
                  a(true);
                  return;
                  localObject1 = paramString1;
                  paramString1 = (String)localObject2;
                }
              }
            }
          }
          label2066:
          paramString1 = null;
        }
      }
    }
  }
  
  public void a(String paramString1, String paramString2, int paramInt1, String paramString3, int paramInt2)
  {
    LinearLayout localLinearLayout = (LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131363021);
    localLinearLayout.removeAllViews();
    if (paramString1 != null)
    {
      localTextView = new TextView(this.jdField_a_of_type_AndroidContentContext.getApplicationContext());
      localTextView.setId(2131361905);
      float f = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131559831);
      paramString1 = a(this.jdField_a_of_type_AndroidContentContext, paramString1, localTextView, f);
      localTextView.setTextSize(14.0F);
      localTextView.setTextColor(paramInt1);
      localTextView.setSingleLine();
      localTextView.setGravity(5);
      localTextView.setMaxWidth(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131559833));
      localTextView.setEllipsize(TextUtils.TruncateAt.END);
      localTextView.setText(paramString1);
      localLinearLayout.addView(localTextView);
    }
    TextView localTextView = new TextView(this.jdField_a_of_type_AndroidContentContext.getApplicationContext());
    localTextView.setTextSize(14.0F);
    localTextView.setTextColor(paramInt1);
    paramInt1 = paramInt2;
    if (paramInt2 == 0) {}
    try
    {
      paramInt1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(Long.valueOf(paramString3).longValue());
      paramString1 = paramString2;
      if (paramString2 != null)
      {
        paramString1 = (String)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c.get(paramString3);
        if (paramString1 == null) {
          break label392;
        }
        i = Integer.valueOf(paramString1.split(";")[0]).intValue();
        paramInt2 = Integer.valueOf(paramString1.split(";")[1]).intValue();
        if (i != 1) {
          break label351;
        }
        if (paramInt2 > 99) {
          paramString1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131429514);
        }
      }
      else
      {
        localTextView.setText(paramString1);
        localTextView.setId(2131362069);
        localLinearLayout.addView(localTextView);
        return;
      }
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        int i;
        paramInt1 = 0;
        continue;
        paramString1 = String.format(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131429513), new Object[] { Integer.valueOf(paramInt2) });
        continue;
        label351:
        paramString1 = paramString2;
        if (paramInt1 == 2)
        {
          paramString1 = paramString2.replace(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131433846), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131433848));
          continue;
          label392:
          paramInt2 = 0;
          i = 0;
        }
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_AndroidContentContext != null) && ((this.jdField_a_of_type_AndroidContentContext instanceof FragmentActivity))) {}
    for (boolean bool = ((FragmentActivity)this.jdField_a_of_type_AndroidContentContext).isResume();; bool = false)
    {
      if ((paramBoolean) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager != null)) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a(this, new Object[0]);
      }
      SmallScreenUtils.a(this.jdField_a_of_type_AndroidViewView, paramBoolean, bool);
      return;
    }
  }
  
  public int[] a()
  {
    return null;
  }
  
  public int b()
  {
    return 2;
  }
  
  public void b()
  {
    a("cancelMeetingInvitedInfo", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 4, 0L);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    Object localObject;
    label640:
    label645:
    for (;;)
    {
      return;
      if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a()) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c()))
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_a_of_type_JavaLangString, 2, "startGroupAudio phone is calling!");
        }
        paramView = this.jdField_a_of_type_AndroidContentContext.getString(2131429045);
        localObject = this.jdField_a_of_type_AndroidContentContext.getString(2131429041);
        DialogUtil.b(this.jdField_a_of_type_AndroidContentContext, 230, (String)localObject, paramView, 2131433029, 2131433030, new wiv(this), null).show();
        return;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 3000) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1)) {
        break;
      }
      int j = UITools.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
      long l = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      paramView = new HashMap();
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(l);
      int i;
      if (localObject != null)
      {
        i = ((AVNotifyCenter.VideoRoomInfo)localObject).jdField_b_of_type_Int;
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(l, i);
        paramView.put("MultiAVType", String.valueOf(i));
        if (i == 2)
        {
          paramView.put("Fromwhere", "SmallScreen");
          if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
            ReportController.b(null, "dc00899", "Grp_video", "", "notice", "Clk_video", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "" + TroopUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString), "2", "");
          }
        }
        if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(j, l)) {
          break label521;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(String.valueOf(l)) != 14) {
          break label488;
        }
        paramView.put("from", "tipBar");
        ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramView);
        label404:
        if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(j, l)) {
          break label640;
        }
      }
      for (paramView = "Cover_back";; paramView = "Clk_discuss_floating")
      {
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 3000) {
          break label645;
        }
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Multi_call", paramView, 0, 0, "", "", "", "");
        return;
        i = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(l);
        break;
        label488:
        ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, true, true, null, paramView);
        break label404;
        label521:
        a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, i);
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1) {
          break label404;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(l) == 10)
        {
          ReportController.b(null, "CliOper", "", "", "0X8005933", "0X8005933", 0, 0, "", "", "", "");
          break label404;
        }
        ReportController.b(null, "CliOper", "", "", "0X80046DA", "0X80046DA", 0, 0, "", "", "", "");
        break label404;
      }
    }
    boolean bool = false;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().e() == 5)
    {
      paramView = new Intent(this.jdField_a_of_type_AndroidContentContext, CallbackWaitingActivityExt.class);
      localObject = new PstnSessionInfo();
      ((PstnSessionInfo)localObject).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().jdField_a_of_type_JavaLangString;
      ((PstnSessionInfo)localObject).d = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().d;
      ((PstnSessionInfo)localObject).jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().jdField_b_of_type_JavaLangString;
      ((PstnSessionInfo)localObject).c = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().c;
      ((PstnSessionInfo)localObject).jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().jdField_a_of_type_Int;
      ((PstnSessionInfo)localObject).jdField_b_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().jdField_b_of_type_Int;
      paramView.putExtra("pstn_session_info", (Parcelable)localObject);
      this.jdField_a_of_type_AndroidContentContext.startActivity(paramView);
      PstnUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp());
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().e() == 1) {
      bool = true;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString) == 1)
      {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800478D", "0X800478D", 0, 0, "", "", "", "");
        bool = true;
      }
    }
    for (;;)
    {
      ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d, null, bool, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString, false, true, null, "from_internal");
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Two_call", "Two_call_full", 0, 0, "2", "", "", "");
      return;
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004789", "0X8004789", 0, 0, "", "", "", "");
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.tips.VideoStatusTipsBar
 * JD-Core Version:    0.7.0.1
 */