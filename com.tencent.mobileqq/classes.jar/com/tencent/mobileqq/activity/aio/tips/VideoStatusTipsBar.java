package com.tencent.mobileqq.activity.aio.tips;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.text.TextUtils.TruncateAt;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.av.gaudio.AVNotifyCenter.UserInfo;
import com.tencent.av.gaudio.AVNotifyCenter.VideoRoomInfo;
import com.tencent.av.smallscreen.SmallScreenUtils;
import com.tencent.av.ui.MultiVideoEnterPageActivity;
import com.tencent.av.utils.DataReport;
import com.tencent.av.utils.UITools;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.DiscussionManager;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.pluspanel.appinfo.GroupVideoChatAppInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QAVGroupConfig;
import com.tencent.mobileqq.utils.QAVGroupConfig.Report;
import com.tencent.mobileqq.utils.QQAudioHelper;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import mqq.os.MqqHandler;

public class VideoStatusTipsBar
  implements View.OnClickListener, TipsBarTask
{
  Context a;
  protected float b;
  private final String c;
  private QQAppInterface d;
  private BaseSessionInfo e;
  private TipsManager f;
  private MqqHandler g;
  private View h;
  private LinearLayout i;
  private ImageView[] j = new ImageView[3];
  private LinearLayout k;
  private ImageView[] l = new ImageView[3];
  private VideoStatusTipsBar.RefreshMultiStateRunnable m;
  
  public VideoStatusTipsBar(QQAppInterface paramQQAppInterface, BaseSessionInfo paramBaseSessionInfo, TipsManager paramTipsManager, Context paramContext, MqqHandler paramMqqHandler)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("VideoStatusTipsBar.");
    localStringBuilder.append(paramBaseSessionInfo.a);
    localStringBuilder.append(".");
    localStringBuilder.append(paramBaseSessionInfo.b);
    localStringBuilder.append("_");
    localStringBuilder.append(QQAudioHelper.d());
    this.c = localStringBuilder.toString();
    this.d = paramQQAppInterface;
    this.e = paramBaseSessionInfo;
    this.f = paramTipsManager;
    this.a = paramContext;
    this.g = paramMqqHandler;
    this.b = paramContext.getResources().getDisplayMetrics().density;
    if (QQAudioHelper.f())
    {
      paramQQAppInterface = this.c;
      paramTipsManager = new StringBuilder();
      paramTipsManager.append("VideoStatusTipsBar, curFriendUin[");
      paramTipsManager.append(paramBaseSessionInfo.b);
      paramTipsManager.append("], curType[");
      paramTipsManager.append(paramBaseSessionInfo.a);
      paramTipsManager.append("]");
      QLog.w(paramQQAppInterface, 1, paramTipsManager.toString());
    }
  }
  
  private int a(int paramInt)
  {
    int i1 = 0;
    int n = i1;
    if (paramInt != 20)
    {
      n = i1;
      if (paramInt != 21)
      {
        if (paramInt != 23) {
          return 3;
        }
        n = 2;
      }
    }
    return n;
  }
  
  private String a(long paramLong, int paramInt)
  {
    Object localObject = this.d;
    if ((localObject != null) && (((QQAppInterface)localObject).getAVNotifyCenter() != null)) {
      localObject = this.d.getAVNotifyCenter().a(paramLong, paramInt);
    } else {
      localObject = null;
    }
    if ((localObject != null) && (((AVNotifyCenter.VideoRoomInfo)localObject).a())) {
      return this.a.getString(2131886543);
    }
    if ((localObject != null) && (((AVNotifyCenter.VideoRoomInfo)localObject).b())) {
      return this.a.getString(2131886514);
    }
    return this.a.getString(2131886539);
  }
  
  private String a(boolean paramBoolean, long paramLong1, int paramInt1, int paramInt2, long paramLong2)
  {
    Object localObject = this.d;
    if ((localObject != null) && (((QQAppInterface)localObject).getAVNotifyCenter() != null)) {
      localObject = this.d.getAVNotifyCenter().a(paramLong1, paramInt1);
    } else {
      localObject = null;
    }
    if (paramBoolean)
    {
      if (this.e.a == 1)
      {
        if ((localObject != null) && (((AVNotifyCenter.VideoRoomInfo)localObject).a())) {
          return this.a.getString(2131886519);
        }
        if ((localObject != null) && (((AVNotifyCenter.VideoRoomInfo)localObject).b())) {
          return this.a.getString(2131886514);
        }
        return this.a.getString(2131886511);
      }
      if ((paramInt1 == 2) && (paramLong2 > 99L))
      {
        if ((localObject != null) && (((AVNotifyCenter.VideoRoomInfo)localObject).a())) {
          return this.a.getString(2131886540);
        }
        if ((localObject != null) && (((AVNotifyCenter.VideoRoomInfo)localObject).b())) {
          return this.a.getString(2131886542);
        }
        return this.a.getString(2131886541);
      }
    }
    else
    {
      if (this.e.a == 1)
      {
        if ((localObject != null) && (((AVNotifyCenter.VideoRoomInfo)localObject).a())) {
          return this.a.getString(2131886519);
        }
        if ((localObject != null) && (((AVNotifyCenter.VideoRoomInfo)localObject).b())) {
          return this.a.getString(2131886514);
        }
        return this.a.getString(2131886510);
      }
      if ((paramInt1 == 2) && (paramLong2 > 99L))
      {
        if ((localObject != null) && (((AVNotifyCenter.VideoRoomInfo)localObject).a())) {
          return this.a.getString(2131886540);
        }
        if ((localObject != null) && (((AVNotifyCenter.VideoRoomInfo)localObject).b())) {
          return this.a.getString(2131886542);
        }
        return this.a.getString(2131886520);
      }
    }
    return "";
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt1, String paramString1, int paramInt2, boolean paramBoolean, String paramString2)
  {
    boolean bool1 = NetworkUtil.isNetSupport(paramContext.getApplicationContext());
    int n = 0;
    if (!bool1)
    {
      QQToast.makeText(paramContext, 2131892074, 0).show(paramContext.getApplicationContext().getResources().getDimensionPixelSize(2131299920));
      return;
    }
    if (paramString1 == null) {
      return;
    }
    boolean bool2 = paramQQAppInterface.getAVNotifyCenter().a(paramString1);
    if ((paramInt2 == 2) && (!bool2))
    {
      paramString2 = new HashMap();
      paramString2.put("MultiAVType", String.valueOf(2));
      paramString2.put("from", "tipBar");
      GroupVideoChatAppInfo.startGroupVideoOrVoice(paramQQAppInterface, paramContext, paramInt1, paramString1, paramString2);
      return;
    }
    if (paramQQAppInterface.getAVNotifyCenter().t() == 4) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    if (paramQQAppInterface.getAVNotifyCenter().a(paramContext, paramInt1, paramString1, bool1)) {
      return;
    }
    Intent localIntent = new Intent(paramContext, MultiVideoEnterPageActivity.class);
    localIntent.addFlags(262144);
    localIntent.addFlags(268435456);
    if (paramInt1 == 3000)
    {
      long[] arrayOfLong = null;
      ArrayList localArrayList = ((DiscussionManager)paramQQAppInterface.getManager(QQManagerFactory.DISCUSSION_MANAGER)).a(paramString1);
      if (localArrayList != null)
      {
        int i1 = localArrayList.size();
        arrayOfLong = new long[i1];
        while (n < i1)
        {
          DiscussionMemberInfo localDiscussionMemberInfo = (DiscussionMemberInfo)localArrayList.get(n);
          if (localDiscussionMemberInfo != null) {
            arrayOfLong[n] = Long.valueOf(localDiscussionMemberInfo.memberUin).longValue();
          }
          n += 1;
        }
      }
      localIntent.putExtra("DiscussUinList", arrayOfLong);
    }
    localIntent.putExtra("sessionType", 3);
    localIntent.putExtra("uin", paramString1);
    localIntent.putExtra("uinType", paramInt1);
    localIntent.putExtra("Type", 3);
    localIntent.putExtra("GroupId", paramString1);
    localIntent.putExtra("openClass", paramBoolean);
    localIntent.putExtra("MultiAVType", paramInt2);
    localIntent.putExtra("Fromwhere", paramString2);
    localIntent.putExtra("flag", bool2);
    if (1 == paramInt1) {
      localIntent.putExtra("groupInfo", QAVGroupConfig.b(paramQQAppInterface, paramString1));
    }
    paramContext.startActivity(localIntent);
  }
  
  private void i()
  {
    if (this.h == null)
    {
      QAVGroupConfig.Report.a();
      this.h = ((LayoutInflater)this.a.getSystemService("layout_inflater")).inflate(2131624117, null);
      this.h.setId(2131438957);
      View localView = this.h;
      float f1 = this.b;
      localView.setPadding(0, (int)(f1 * 2.0F), 0, (int)(f1 * 2.0F));
      this.h.setClickable(true);
      this.h.setOnClickListener(this);
      if (!ThemeUtil.isInNightMode(this.d)) {
        this.h.setBackgroundResource(2130839657);
      } else {
        this.h.setBackgroundColor(Color.parseColor("#1f1f1f"));
      }
      this.i = ((LinearLayout)this.h.findViewById(2131429024));
      this.j[0] = ((ImageView)this.i.findViewById(2131428990));
      this.j[1] = ((ImageView)this.i.findViewById(2131428992));
      this.j[2] = ((ImageView)this.i.findViewById(2131428994));
      this.k = ((LinearLayout)this.h.findViewById(2131429204));
      this.l[0] = ((ImageView)this.k.findViewById(2131429201));
      this.l[1] = ((ImageView)this.k.findViewById(2131429202));
      this.l[2] = ((ImageView)this.k.findViewById(2131429203));
    }
  }
  
  private boolean j()
  {
    if ((this.d.getAVNotifyCenter().c()) && (!this.d.isVideoChatting()))
    {
      DataReport.e(false, true);
      if (QLog.isColorLevel()) {
        QLog.d(this.c, 2, "startGroupAudio phone is calling!");
      }
      String str1 = this.a.getString(2131893471);
      String str2 = this.a.getString(2131893450);
      DialogUtil.a(this.a, 230, str2, str1, 2131887648, 2131892267, new VideoStatusTipsBar.1(this), null).show();
      return true;
    }
    return false;
  }
  
  public int a()
  {
    return 62;
  }
  
  protected Drawable a(String paramString)
  {
    return FaceDrawable.getUserFaceDrawable(this.d, paramString, (byte)4);
  }
  
  public View a(Object... paramVarArgs)
  {
    return this.h;
  }
  
  public VideoStatusTipsBar.TextInfo a(int paramInt1, long paramLong1, int paramInt2, long paramLong2, TextView paramTextView)
  {
    Object localObject = this.d.getAVNotifyCenter().d(paramInt1, paramLong1);
    if (localObject == null)
    {
      if (this.e.a == 3000) {
        localObject = this.a.getString(2131886549);
      } else if (this.e.a == 1) {
        localObject = a(true, paramLong1, paramInt2, this.e.a, paramLong2);
      } else {
        localObject = null;
      }
      str1 = String.format((String)localObject, new Object[] { Long.valueOf(paramLong2) });
      localObject = str1;
      if (paramInt2 == 2)
      {
        localObject = str1;
        if (paramLong2 > 99L) {
          localObject = a(true, paramLong1, paramInt2, this.e.a, paramLong2);
        }
      }
    }
    for (;;)
    {
      str1 = null;
      break label625;
      if (!((AVNotifyCenter.UserInfo)localObject).b) {
        break label426;
      }
      str1 = this.d.getAVNotifyCenter().g(((AVNotifyCenter.UserInfo)localObject).a);
      if (str1 != null) {
        break;
      }
      if (this.e.a == 3000) {
        localObject = this.a.getString(2131886549);
      } else if (this.e.a == 1) {
        localObject = this.a.getString(2131886511);
      } else {
        localObject = null;
      }
      str1 = String.format((String)localObject, new Object[] { Long.valueOf(paramLong2) });
      localObject = str1;
      if (paramInt2 == 2)
      {
        localObject = str1;
        if (paramLong2 > 99L) {
          localObject = this.a.getString(2131886541);
        }
      }
    }
    if (paramLong2 == 1L) {
      localObject = this.a.getString(2131886550);
    }
    String str2;
    for (;;)
    {
      break;
      if (this.e.a == 3000) {
        localObject = this.a.getString(2131886548);
      } else if (this.e.a == 1) {
        localObject = this.a.getString(2131886510);
      } else {
        localObject = null;
      }
      str2 = String.format((String)localObject, new Object[] { Long.valueOf(paramLong2) });
      localObject = str2;
      if (paramInt2 == 2)
      {
        localObject = str2;
        if (paramLong2 > 99L) {
          localObject = this.a.getString(2131886520);
        }
      }
    }
    label426:
    localObject = Long.toString(((AVNotifyCenter.UserInfo)localObject).a);
    String str1 = Long.toString(paramLong1);
    if (this.e.a == 1) {
      paramInt1 = 1;
    } else {
      paramInt1 = 2;
    }
    str1 = ContactUtils.a(this.d, (String)localObject, str1, paramInt1, 0);
    if (paramLong2 == 1L) {
      localObject = this.a.getString(2131886550);
    }
    for (;;)
    {
      break;
      if (this.e.a == 3000) {
        localObject = this.a.getString(2131886548);
      } else if (this.e.a == 1) {
        localObject = a(false, paramLong1, paramInt2, this.e.a, paramLong2);
      } else {
        localObject = null;
      }
      str2 = String.format((String)localObject, new Object[] { Long.valueOf(paramLong2) });
      localObject = str2;
      if (paramInt2 == 2)
      {
        localObject = str2;
        if (paramLong2 > 99L) {
          localObject = a(false, paramLong1, paramInt2, this.e.a, paramLong2);
        }
      }
    }
    label625:
    paramTextView.setVisibility(8);
    if (this.e.a == 3000) {
      UITools.a(this.h, this.a.getString(2131893300));
    } else if (this.e.a == 1) {
      UITools.a(this.h, this.a.getString(2131893333), paramInt2);
    }
    paramTextView = new VideoStatusTipsBar.TextInfo();
    paramTextView.b = str1;
    paramTextView.a = ((String)localObject);
    return paramTextView;
  }
  
  public VideoStatusTipsBar.TextInfo a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, long paramLong3, TextView paramTextView, ImageView paramImageView)
  {
    Object localObject3 = this.d.getCurrentAccountUin();
    Object localObject1 = Long.toString(paramLong1);
    Object localObject4 = null;
    Object localObject2 = null;
    if ((paramLong1 != 0L) && (!((String)localObject3).equals(Long.valueOf(paramLong1))) && (paramInt1 != 2))
    {
      localObject3 = Long.toString(paramLong2);
      int n;
      if (this.e.a == 1) {
        n = 1;
      } else {
        n = 2;
      }
      localObject3 = ContactUtils.a(this.d, (String)localObject1, (String)localObject3, n, 0);
      if (paramInt2 == 1)
      {
        if (this.e.a == 3000)
        {
          localObject1 = this.a.getString(2131886552);
        }
        else
        {
          localObject1 = localObject2;
          if (this.e.a == 1) {
            localObject1 = this.a.getString(2131886512);
          }
        }
      }
      else
      {
        localObject1 = localObject2;
        if (paramInt2 == 2) {
          if (this.e.a == 3000)
          {
            localObject1 = this.a.getString(2131886553);
          }
          else
          {
            localObject1 = localObject2;
            if (this.e.a == 1) {
              localObject1 = this.a.getString(2131886513);
            }
          }
        }
      }
      paramTextView.setVisibility(8);
    }
    else if (this.d.getAVNotifyCenter().p())
    {
      localObject2 = this.a.getString(2131886554);
      this.d.getAVNotifyCenter().d(false);
      localObject1 = localObject2;
      localObject3 = localObject4;
      if (paramInt1 == 2)
      {
        paramTextView.setVisibility(8);
        localObject1 = localObject2;
        localObject3 = localObject4;
      }
    }
    else
    {
      if (this.e.a == 3000) {
        localObject1 = this.a.getString(2131886546);
      } else if (this.e.a == 1) {
        localObject1 = a(paramLong2, paramInt1);
      } else {
        localObject1 = null;
      }
      this.d.getAVNotifyCenter().d(true);
      localObject2 = localObject1;
      if (localObject1 != null) {
        localObject2 = String.format((String)localObject1, new Object[] { Long.valueOf(paramLong3) });
      }
      paramTextView.setVisibility(0);
      localObject3 = localObject4;
      localObject1 = localObject2;
    }
    if (this.e.a == 3000) {
      UITools.a(this.h, this.a.getString(2131889946));
    } else if (this.e.a == 1) {
      UITools.a(this.h, this.a.getString(2131889947), paramInt1);
    }
    paramImageView.setVisibility(0);
    paramTextView = new VideoStatusTipsBar.TextInfo();
    paramTextView.b = ((String)localObject3);
    paramTextView.a = ((String)localObject1);
    return paramTextView;
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
        paramContext = paramString;
        paramFloat = f1;
        while ((f2 > 0.0F) && (paramFloat > f2) && (paramContext.length() > 0))
        {
          paramTextView = paramContext.substring(0, paramContext.length() - 1);
          f1 = localTextPaint.measureText(paramTextView);
          paramFloat = f1;
          paramContext = paramTextView;
          if (f1 == 0.0F)
          {
            paramFloat = f1;
            paramContext = paramTextView;
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
          if (paramContext.length() > 0)
          {
            paramString = new StringBuilder();
            paramString.append(paramContext);
            paramString.append("...");
            paramTextView = paramString.toString();
          }
        }
      }
    }
    return paramTextView;
  }
  
  public void a(int paramInt, String paramString1, String paramString2)
  {
    boolean bool3 = this.d.getAVNotifyCenter().i(paramString1);
    boolean bool2 = this.d.isVideoChatting();
    this.d.getAVNotifyCenter().q();
    boolean bool4 = this.d.getAVNotifyCenter().p();
    int n;
    if (bool3) {
      n = this.d.getAVNotifyCenter().k(paramString1);
    } else if (bool2) {
      n = this.d.getAVNotifyCenter().t();
    } else {
      n = 0;
    }
    Object localObject1 = this.c;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("refreshVideoStatus, uinType[");
    ((StringBuilder)localObject2).append(paramInt);
    ((StringBuilder)localObject2).append("], peerUin[");
    ((StringBuilder)localObject2).append(paramString1);
    ((StringBuilder)localObject2).append("], extraUin[");
    ((StringBuilder)localObject2).append(paramString2);
    ((StringBuilder)localObject2).append("], sessionType[");
    ((StringBuilder)localObject2).append(n);
    ((StringBuilder)localObject2).append("], isOtherTerminalAvChatting[");
    ((StringBuilder)localObject2).append(bool3);
    ((StringBuilder)localObject2).append("], isVideoChatting[");
    ((StringBuilder)localObject2).append(bool2);
    ((StringBuilder)localObject2).append("], SmallScreenState[");
    ((StringBuilder)localObject2).append(this.d.getAVNotifyCenter().B());
    ((StringBuilder)localObject2).append("], isReceiver[");
    ((StringBuilder)localObject2).append(this.d.getAVNotifyCenter().q());
    ((StringBuilder)localObject2).append("], isWaittingState[");
    ((StringBuilder)localObject2).append(this.d.getAVNotifyCenter().p());
    ((StringBuilder)localObject2).append("]");
    localObject2 = ((StringBuilder)localObject2).toString();
    boolean bool1 = true;
    QLog.w((String)localObject1, 1, (String)localObject2);
    if (((bool2) && (!this.d.getAVNotifyCenter().D()) && ((n == 1) || (n == 2)) && (this.e.a == paramInt) && ((this.e.b.equals(paramString1)) || (this.e.b.equals(paramString2)))) || ((bool3) && (this.e.b.equals(paramString1))))
    {
      paramString2 = this.h;
      if (paramString2 == null)
      {
        this.h = ((LayoutInflater)this.a.getSystemService("layout_inflater")).inflate(2131624117, null);
        this.h.setId(2131438957);
        paramString2 = this.h;
        float f1 = this.b;
        paramString2.setPadding(0, (int)(f1 * 2.0F), 0, (int)(f1 * 2.0F));
        this.h.setBackgroundResource(2130839657);
        this.h.setClickable(true);
        this.i = ((LinearLayout)this.h.findViewById(2131429024));
        this.k = ((LinearLayout)this.h.findViewById(2131429204));
        localObject1 = (ImageView)this.h.findViewById(2131435256);
        paramString2 = (TextView)this.h.findViewById(2131447185);
      }
      else
      {
        localObject1 = (ImageView)paramString2.findViewById(2131435256);
        paramString2 = (TextView)this.h.findViewById(2131447185);
      }
      this.i.setVisibility(8);
      this.k.setVisibility(8);
      if (this.d.getAVNotifyCenter().v() == null) {}
    }
    try
    {
      Long.parseLong(this.d.getAVNotifyCenter().v());
    }
    catch (Exception localException)
    {
      label620:
      String str;
      StringBuilder localStringBuilder;
      break label620;
    }
    if (bool3) {
      UITools.a(this.h, this.a.getString(2131893103));
    } else if (bool2) {
      if (paramInt == 1) {
        UITools.a(this.h, this.a.getString(2131887109), this.d.getAVNotifyCenter().e(this.d.getAVNotifyCenter().g()));
      } else {
        UITools.a(this.h, this.a.getString(2131887109));
      }
    }
    str = paramString2;
    localObject2 = "";
    if (bool3)
    {
      paramString2 = (String)localObject2;
      if (n == 1) {
        paramString2 = this.a.getResources().getString(2131893103);
      }
      if (n == 2) {
        paramString2 = this.a.getResources().getString(2131893701);
      }
    }
    else
    {
      paramString2 = (String)localObject2;
      if (bool2) {
        if (bool4)
        {
          paramString2 = this.a.getResources().getString(2131893743);
        }
        else if (n == 1)
        {
          paramString2 = this.a.getResources().getString(2131893112);
        }
        else
        {
          paramString2 = (String)localObject2;
          if (n == 2) {
            paramString2 = this.a.getResources().getString(2131893716);
          }
        }
      }
    }
    a(null, paramString2, this.a.getResources().getColor(2131168002), paramString1, 0);
    localObject2 = this.c;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("refreshVideoStatus info=");
    localStringBuilder.append(paramString2);
    localStringBuilder.append(", peerUin=");
    localStringBuilder.append(paramString1);
    QLog.i((String)localObject2, 1, localStringBuilder.toString());
    this.h.setOnClickListener(this);
    if (!ThemeUtil.isInNightMode(this.d))
    {
      this.h.setBackgroundResource(2130839657);
      ((ImageView)localObject1).setImageResource(2130839647);
    }
    else
    {
      this.h.setBackgroundColor(-14737633);
      ((ImageView)localObject1).setImageResource(2130839648);
    }
    ((ImageView)localObject1).setVisibility(0);
    if ((bool2) && (!bool3))
    {
      if (this.d.getAVNotifyCenter().B() != 2) {
        bool1 = false;
      }
      a(bool1);
    }
    else
    {
      a(true);
    }
    if ((bool2) && (!this.d.getAVNotifyCenter().p()))
    {
      str.setVisibility(0);
      return;
    }
    str.setVisibility(8);
    return;
    if (b() == this.f.b()) {
      this.f.c();
    }
  }
  
  public void a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt != 1000) {
      return;
    }
    long l2 = QQAudioHelper.d();
    if ((this.e.a != 3000) && (this.e.a != 1))
    {
      int n = this.d.getAVNotifyCenter().t();
      if (n == 3)
      {
        if (this.d.getAVNotifyCenter().a(this.e.b)) {
          return;
        }
        paramVarArgs = new StringBuilder();
        paramVarArgs.append("onAIOEvent_2_");
        paramVarArgs.append(paramInt);
        paramVarArgs.append(".");
        paramVarArgs.append(l2);
        a(paramVarArgs.toString(), this.e.a, this.e.b, 0, 0L);
      }
      else if ((n == 1) || (n == 2))
      {
        a(this.d.getAVNotifyCenter().u(), this.d.getAVNotifyCenter().v(), this.d.getAVNotifyCenter().w());
      }
      if ((!this.d.getAVNotifyCenter().i(this.e.b)) || (!((FriendsManager)this.d.getManager(QQManagerFactory.FRIENDS_MANAGER)).n(this.e.b))) {
        break label607;
      }
      paramVarArgs = this.e.b;
      if (this.d.getAVNotifyCenter().i(paramVarArgs))
      {
        n = this.d.getAVNotifyCenter().k(paramVarArgs);
        if (n == 1) {
          ReportController.b(this.d, "CliOper", "", "", "0X800478C", "0X800478C", 0, 0, "", "", "", "");
        }
        if (n == 2) {
          ReportController.b(this.d, "CliOper", "", "", "0X8004788", "0X8004788", 0, 0, "", "", "", "");
        }
      }
      a(0, paramVarArgs, "");
    }
    try
    {
      l1 = Long.parseLong(paramVarArgs);
    }
    catch (Exception localException)
    {
      long l1;
      label351:
      Object localObject;
      StringBuilder localStringBuilder;
      label607:
      break label351;
    }
    l1 = 0L;
    if (l1 != 0L)
    {
      l1 = this.d.getAVNotifyCenter().j(paramVarArgs);
      localObject = this.c;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("QueryRoomInfo.notify, eventType[");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("], roomId[");
      localStringBuilder.append(l1);
      localStringBuilder.append("], peerUin[");
      localStringBuilder.append(paramVarArgs);
      localStringBuilder.append("], seq[");
      localStringBuilder.append(l2);
      localStringBuilder.append("]");
      QLog.w((String)localObject, 1, localStringBuilder.toString());
      localObject = new Intent("tencent.video.q2v.sendQueryRoomInfoRequest");
      ((Intent)localObject).putExtra("roomId", l1);
      ((Intent)localObject).putExtra("peerUin", Long.parseLong(paramVarArgs));
      ((Intent)localObject).putExtra("uin", this.d.getAccount());
      ((Intent)localObject).putExtra("seq", l2);
      this.a.sendBroadcast((Intent)localObject);
      return;
      paramVarArgs = new StringBuilder();
      paramVarArgs.append("onAIOEvent_1_");
      paramVarArgs.append(paramInt);
      paramVarArgs.append(".");
      paramVarArgs.append(l2);
      a(paramVarArgs.toString(), this.e.a, this.e.b, 0, 0L);
    }
  }
  
  void a(long paramLong)
  {
    Object localObject = this.m;
    if (localObject == null) {
      this.m = new VideoStatusTipsBar.RefreshMultiStateRunnable(this);
    } else {
      this.g.removeCallbacks((Runnable)localObject);
    }
    localObject = this.g;
    if (localObject != null)
    {
      ((MqqHandler)localObject).postDelayed(this.m, paramLong);
      this.d.getAVNotifyCenter().d(false);
    }
  }
  
  /* Error */
  public void a(String paramString1, int paramInt1, String paramString2, int paramInt2, long paramLong)
  {
    // Byte code:
    //   0: invokestatic 112	com/tencent/mobileqq/utils/QQAudioHelper:f	()Z
    //   3: ifeq +143 -> 146
    //   6: aload_0
    //   7: getfield 80	com/tencent/mobileqq/activity/aio/tips/VideoStatusTipsBar:c	Ljava/lang/String;
    //   10: astore 23
    //   12: new 45	java/lang/StringBuilder
    //   15: dup
    //   16: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   19: astore 24
    //   21: aload 24
    //   23: ldc_w 708
    //   26: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: pop
    //   30: aload 24
    //   32: aload_1
    //   33: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: pop
    //   37: aload 24
    //   39: ldc_w 710
    //   42: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: pop
    //   46: aload 24
    //   48: iload_2
    //   49: invokevirtual 60	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   52: pop
    //   53: aload 24
    //   55: ldc_w 712
    //   58: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: pop
    //   62: aload 24
    //   64: aload_3
    //   65: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: pop
    //   69: aload 24
    //   71: ldc_w 714
    //   74: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: pop
    //   78: aload 24
    //   80: iload 4
    //   82: invokevirtual 60	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   85: pop
    //   86: aload 24
    //   88: ldc_w 716
    //   91: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: pop
    //   95: aload 24
    //   97: lload 5
    //   99: invokevirtual 74	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   102: pop
    //   103: aload 24
    //   105: ldc 116
    //   107: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: pop
    //   111: aload 24
    //   113: aload_0
    //   114: getfield 84	com/tencent/mobileqq/activity/aio/tips/VideoStatusTipsBar:e	Lcom/tencent/mobileqq/activity/aio/BaseSessionInfo;
    //   117: getfield 57	com/tencent/mobileqq/activity/aio/BaseSessionInfo:a	I
    //   120: invokevirtual 60	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   123: pop
    //   124: aload 24
    //   126: ldc 118
    //   128: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   131: pop
    //   132: aload 23
    //   134: iconst_1
    //   135: aload 24
    //   137: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   140: invokestatic 124	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   143: goto +3 -> 146
    //   146: aload_0
    //   147: getfield 84	com/tencent/mobileqq/activity/aio/tips/VideoStatusTipsBar:e	Lcom/tencent/mobileqq/activity/aio/BaseSessionInfo;
    //   150: getfield 57	com/tencent/mobileqq/activity/aio/BaseSessionInfo:a	I
    //   153: sipush 3000
    //   156: if_icmpeq +17 -> 173
    //   159: aload_0
    //   160: getfield 84	com/tencent/mobileqq/activity/aio/tips/VideoStatusTipsBar:e	Lcom/tencent/mobileqq/activity/aio/BaseSessionInfo;
    //   163: getfield 57	com/tencent/mobileqq/activity/aio/BaseSessionInfo:a	I
    //   166: iconst_1
    //   167: if_icmpeq +6 -> 173
    //   170: goto +485 -> 655
    //   173: aload_3
    //   174: invokestatic 586	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   177: lstore 11
    //   179: goto +6 -> 185
    //   182: lconst_0
    //   183: lstore 11
    //   185: aload_0
    //   186: getfield 84	com/tencent/mobileqq/activity/aio/tips/VideoStatusTipsBar:e	Lcom/tencent/mobileqq/activity/aio/BaseSessionInfo;
    //   189: getfield 57	com/tencent/mobileqq/activity/aio/BaseSessionInfo:a	I
    //   192: invokestatic 718	com/tencent/av/utils/UITools:b	(I)I
    //   195: istore 9
    //   197: aload_0
    //   198: getfield 82	com/tencent/mobileqq/activity/aio/tips/VideoStatusTipsBar:d	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   201: invokevirtual 133	com/tencent/mobileqq/app/QQAppInterface:getAVNotifyCenter	()Lcom/tencent/av/gaudio/AVNotifyCenter;
    //   204: iload 9
    //   206: lload 11
    //   208: invokevirtual 721	com/tencent/av/gaudio/AVNotifyCenter:c	(IJ)J
    //   211: lstore 13
    //   213: aload_0
    //   214: getfield 82	com/tencent/mobileqq/activity/aio/tips/VideoStatusTipsBar:d	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   217: invokevirtual 133	com/tencent/mobileqq/app/QQAppInterface:getAVNotifyCenter	()Lcom/tencent/av/gaudio/AVNotifyCenter;
    //   220: lload 11
    //   222: invokevirtual 724	com/tencent/av/gaudio/AVNotifyCenter:h	(J)Ljava/util/Vector;
    //   225: astore 26
    //   227: aload_0
    //   228: getfield 82	com/tencent/mobileqq/activity/aio/tips/VideoStatusTipsBar:d	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   231: invokevirtual 133	com/tencent/mobileqq/app/QQAppInterface:getAVNotifyCenter	()Lcom/tencent/av/gaudio/AVNotifyCenter;
    //   234: lload 11
    //   236: invokevirtual 593	com/tencent/av/gaudio/AVNotifyCenter:e	(J)I
    //   239: istore 8
    //   241: aload_0
    //   242: getfield 82	com/tencent/mobileqq/activity/aio/tips/VideoStatusTipsBar:d	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   245: invokevirtual 133	com/tencent/mobileqq/app/QQAppInterface:getAVNotifyCenter	()Lcom/tencent/av/gaudio/AVNotifyCenter;
    //   248: iload 9
    //   250: lload 11
    //   252: invokevirtual 727	com/tencent/av/gaudio/AVNotifyCenter:a	(IJ)Z
    //   255: istore 19
    //   257: iload 9
    //   259: iconst_1
    //   260: if_icmpne +282 -> 542
    //   263: iload 19
    //   265: ifne +277 -> 542
    //   268: aload_3
    //   269: ifnull +273 -> 542
    //   272: aload_3
    //   273: invokestatic 733	android/text/TextUtils:isDigitsOnly	(Ljava/lang/CharSequence;)Z
    //   276: ifeq +266 -> 542
    //   279: aload_0
    //   280: getfield 82	com/tencent/mobileqq/activity/aio/tips/VideoStatusTipsBar:d	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   283: invokevirtual 133	com/tencent/mobileqq/app/QQAppInterface:getAVNotifyCenter	()Lcom/tencent/av/gaudio/AVNotifyCenter;
    //   286: astore_1
    //   287: aload_1
    //   288: aload_3
    //   289: invokestatic 586	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   292: invokevirtual 736	com/tencent/av/gaudio/AVNotifyCenter:f	(J)Lcom/tencent/av/gaudio/AVNotifyCenter$VideoRoomInfo;
    //   295: astore_1
    //   296: aload_1
    //   297: ifnull +173 -> 470
    //   300: aload_1
    //   301: getfield 738	com/tencent/av/gaudio/AVNotifyCenter$VideoRoomInfo:d	I
    //   304: bipush 10
    //   306: if_icmpne +2142 -> 2448
    //   309: aload_1
    //   310: getfield 740	com/tencent/av/gaudio/AVNotifyCenter$VideoRoomInfo:c	I
    //   313: ifle +2135 -> 2448
    //   316: invokestatic 745	java/lang/System:currentTimeMillis	()J
    //   319: lstore 15
    //   321: aload_1
    //   322: getfield 747	com/tencent/av/gaudio/AVNotifyCenter$VideoRoomInfo:i	J
    //   325: lstore 17
    //   327: lload 15
    //   329: lload 17
    //   331: ldc2_w 748
    //   334: ladd
    //   335: lcmp
    //   336: ifle +2105 -> 2441
    //   339: aload_0
    //   340: getfield 80	com/tencent/mobileqq/activity/aio/tips/VideoStatusTipsBar:c	Ljava/lang/String;
    //   343: astore 23
    //   345: new 45	java/lang/StringBuilder
    //   348: dup
    //   349: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   352: astore 24
    //   354: aload 24
    //   356: ldc_w 751
    //   359: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   362: pop
    //   363: aload 24
    //   365: aload_1
    //   366: invokevirtual 754	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   369: pop
    //   370: aload 24
    //   372: ldc 118
    //   374: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   377: pop
    //   378: aload 23
    //   380: iconst_1
    //   381: aload 24
    //   383: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   386: invokestatic 124	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   389: iload 4
    //   391: istore_2
    //   392: aload_1
    //   393: iconst_0
    //   394: putfield 740	com/tencent/av/gaudio/AVNotifyCenter$VideoRoomInfo:c	I
    //   397: iload 4
    //   399: istore_2
    //   400: aload_0
    //   401: getfield 82	com/tencent/mobileqq/activity/aio/tips/VideoStatusTipsBar:d	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   404: invokevirtual 133	com/tencent/mobileqq/app/QQAppInterface:getAVNotifyCenter	()Lcom/tencent/av/gaudio/AVNotifyCenter;
    //   407: bipush 14
    //   409: iload 9
    //   411: lload 11
    //   413: aconst_null
    //   414: lconst_0
    //   415: invokevirtual 757	com/tencent/av/gaudio/AVNotifyCenter:a	(IIJ[JJ)V
    //   418: goto +3 -> 421
    //   421: iload 4
    //   423: istore_2
    //   424: aload_0
    //   425: aload_1
    //   426: getfield 759	com/tencent/av/gaudio/AVNotifyCenter$VideoRoomInfo:h	I
    //   429: invokespecial 761	com/tencent/mobileqq/activity/aio/tips/VideoStatusTipsBar:a	(I)I
    //   432: istore 4
    //   434: iload 4
    //   436: istore_2
    //   437: aload_1
    //   438: getfield 740	com/tencent/av/gaudio/AVNotifyCenter$VideoRoomInfo:c	I
    //   441: istore 10
    //   443: iload 10
    //   445: i2l
    //   446: lstore 13
    //   448: aload_1
    //   449: getfield 738	com/tencent/av/gaudio/AVNotifyCenter$VideoRoomInfo:d	I
    //   452: istore_2
    //   453: iconst_1
    //   454: istore 8
    //   456: goto +24 -> 480
    //   459: astore_1
    //   460: goto +28 -> 488
    //   463: astore_1
    //   464: iload_2
    //   465: istore 4
    //   467: goto +21 -> 488
    //   470: iconst_0
    //   471: istore 10
    //   473: iload 8
    //   475: istore_2
    //   476: iload 10
    //   478: istore 8
    //   480: goto +68 -> 548
    //   483: astore_1
    //   484: goto +4 -> 488
    //   487: astore_1
    //   488: invokestatic 410	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   491: ifeq +48 -> 539
    //   494: aload_0
    //   495: getfield 80	com/tencent/mobileqq/activity/aio/tips/VideoStatusTipsBar:c	Ljava/lang/String;
    //   498: astore 23
    //   500: new 45	java/lang/StringBuilder
    //   503: dup
    //   504: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   507: astore 24
    //   509: aload 24
    //   511: ldc_w 763
    //   514: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   517: pop
    //   518: aload 24
    //   520: aload_1
    //   521: invokevirtual 754	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   524: pop
    //   525: aload 23
    //   527: iconst_2
    //   528: aload 24
    //   530: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   533: invokestatic 765	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   536: goto +6 -> 542
    //   539: goto +3 -> 542
    //   542: iload 8
    //   544: istore_2
    //   545: iconst_0
    //   546: istore 8
    //   548: iload_2
    //   549: bipush 10
    //   551: if_icmpeq +8 -> 559
    //   554: iload_2
    //   555: iconst_2
    //   556: if_icmpne +92 -> 648
    //   559: aload_0
    //   560: getfield 82	com/tencent/mobileqq/activity/aio/tips/VideoStatusTipsBar:d	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   563: invokevirtual 133	com/tencent/mobileqq/app/QQAppInterface:getAVNotifyCenter	()Lcom/tencent/av/gaudio/AVNotifyCenter;
    //   566: lload 11
    //   568: iload_2
    //   569: lload 13
    //   571: l2i
    //   572: invokevirtual 768	com/tencent/av/gaudio/AVNotifyCenter:a	(JII)V
    //   575: iload_2
    //   576: iconst_2
    //   577: if_icmpne +71 -> 648
    //   580: aload_0
    //   581: getfield 82	com/tencent/mobileqq/activity/aio/tips/VideoStatusTipsBar:d	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   584: invokevirtual 133	com/tencent/mobileqq/app/QQAppInterface:getAVNotifyCenter	()Lcom/tencent/av/gaudio/AVNotifyCenter;
    //   587: lload 11
    //   589: iload_2
    //   590: invokevirtual 138	com/tencent/av/gaudio/AVNotifyCenter:a	(JI)Lcom/tencent/av/gaudio/AVNotifyCenter$VideoRoomInfo;
    //   593: astore_1
    //   594: aload_1
    //   595: ifnull +53 -> 648
    //   598: aload_1
    //   599: getfield 740	com/tencent/av/gaudio/AVNotifyCenter$VideoRoomInfo:c	I
    //   602: ifgt +10 -> 612
    //   605: bipush 23
    //   607: istore 10
    //   609: goto +7 -> 616
    //   612: bipush 21
    //   614: istore 10
    //   616: aload_0
    //   617: getfield 82	com/tencent/mobileqq/activity/aio/tips/VideoStatusTipsBar:d	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   620: invokevirtual 133	com/tencent/mobileqq/app/QQAppInterface:getAVNotifyCenter	()Lcom/tencent/av/gaudio/AVNotifyCenter;
    //   623: iconst_2
    //   624: lload 11
    //   626: iload_2
    //   627: aload_1
    //   628: getfield 770	com/tencent/av/gaudio/AVNotifyCenter$VideoRoomInfo:f	I
    //   631: aload_1
    //   632: getfield 772	com/tencent/av/gaudio/AVNotifyCenter$VideoRoomInfo:g	I
    //   635: aload_1
    //   636: getfield 774	com/tencent/av/gaudio/AVNotifyCenter$VideoRoomInfo:e	I
    //   639: iload 10
    //   641: aload_1
    //   642: getfield 740	com/tencent/av/gaudio/AVNotifyCenter$VideoRoomInfo:c	I
    //   645: invokevirtual 777	com/tencent/av/gaudio/AVNotifyCenter:a	(IJIIIIII)V
    //   648: lload 13
    //   650: lconst_0
    //   651: lcmp
    //   652: ifgt +25 -> 677
    //   655: aload_0
    //   656: invokevirtual 621	com/tencent/mobileqq/activity/aio/tips/VideoStatusTipsBar:b	()I
    //   659: aload_0
    //   660: getfield 86	com/tencent/mobileqq/activity/aio/tips/VideoStatusTipsBar:f	Lcom/tencent/mobileqq/activity/aio/tips/TipsManager;
    //   663: invokevirtual 624	com/tencent/mobileqq/activity/aio/tips/TipsManager:b	()I
    //   666: if_icmpne +10 -> 676
    //   669: aload_0
    //   670: getfield 86	com/tencent/mobileqq/activity/aio/tips/VideoStatusTipsBar:f	Lcom/tencent/mobileqq/activity/aio/tips/TipsManager;
    //   673: invokevirtual 626	com/tencent/mobileqq/activity/aio/tips/TipsManager:c	()V
    //   676: return
    //   677: invokestatic 780	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   680: ifeq +105 -> 785
    //   683: aload_0
    //   684: getfield 80	com/tencent/mobileqq/activity/aio/tips/VideoStatusTipsBar:c	Ljava/lang/String;
    //   687: astore_1
    //   688: new 45	java/lang/StringBuilder
    //   691: dup
    //   692: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   695: astore 23
    //   697: aload 23
    //   699: ldc_w 782
    //   702: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   705: pop
    //   706: aload 23
    //   708: lload 13
    //   710: invokevirtual 74	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   713: pop
    //   714: aload 23
    //   716: ldc_w 784
    //   719: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   722: pop
    //   723: aload 23
    //   725: iload_2
    //   726: invokevirtual 60	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   729: pop
    //   730: aload 23
    //   732: ldc_w 786
    //   735: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   738: pop
    //   739: aload 23
    //   741: iload 19
    //   743: invokevirtual 562	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   746: pop
    //   747: aload 23
    //   749: ldc_w 788
    //   752: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   755: pop
    //   756: aload 23
    //   758: iload 8
    //   760: invokevirtual 60	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   763: pop
    //   764: aload 23
    //   766: ldc 118
    //   768: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   771: pop
    //   772: aload_1
    //   773: iconst_1
    //   774: aload 23
    //   776: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   779: invokestatic 124	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   782: goto +3 -> 785
    //   785: iload 19
    //   787: istore 20
    //   789: aload_0
    //   790: invokespecial 790	com/tencent/mobileqq/activity/aio/tips/VideoStatusTipsBar:i	()V
    //   793: aload_0
    //   794: getfield 321	com/tencent/mobileqq/activity/aio/tips/VideoStatusTipsBar:h	Landroid/view/View;
    //   797: ldc_w 578
    //   800: invokevirtual 383	android/view/View:findViewById	(I)Landroid/view/View;
    //   803: checkcast 476	android/widget/TextView
    //   806: astore 25
    //   808: aload_0
    //   809: getfield 321	com/tencent/mobileqq/activity/aio/tips/VideoStatusTipsBar:h	Landroid/view/View;
    //   812: ldc_w 577
    //   815: invokevirtual 383	android/view/View:findViewById	(I)Landroid/view/View;
    //   818: checkcast 39	android/widget/ImageView
    //   821: astore 24
    //   823: aload_0
    //   824: getfield 321	com/tencent/mobileqq/activity/aio/tips/VideoStatusTipsBar:h	Landroid/view/View;
    //   827: ldc_w 791
    //   830: invokevirtual 383	android/view/View:findViewById	(I)Landroid/view/View;
    //   833: checkcast 39	android/widget/ImageView
    //   836: astore 27
    //   838: iload 20
    //   840: ifeq +25 -> 865
    //   843: aload_0
    //   844: lload 5
    //   846: lload 11
    //   848: iload_2
    //   849: iload 4
    //   851: lload 13
    //   853: aload 25
    //   855: aload 24
    //   857: invokevirtual 793	com/tencent/mobileqq/activity/aio/tips/VideoStatusTipsBar:a	(JJIIJLandroid/widget/TextView;Landroid/widget/ImageView;)Lcom/tencent/mobileqq/activity/aio/tips/VideoStatusTipsBar$TextInfo;
    //   860: astore 23
    //   862: goto +18 -> 880
    //   865: aload_0
    //   866: iload 9
    //   868: lload 11
    //   870: iload_2
    //   871: lload 13
    //   873: aload 25
    //   875: invokevirtual 795	com/tencent/mobileqq/activity/aio/tips/VideoStatusTipsBar:a	(IJIJLandroid/widget/TextView;)Lcom/tencent/mobileqq/activity/aio/tips/VideoStatusTipsBar$TextInfo;
    //   878: astore 23
    //   880: aload 26
    //   882: astore_1
    //   883: aload 27
    //   885: astore 26
    //   887: iconst_0
    //   888: istore 21
    //   890: iload 4
    //   892: iconst_1
    //   893: if_icmpeq +22 -> 915
    //   896: iload 4
    //   898: iconst_2
    //   899: if_icmpne +6 -> 905
    //   902: goto +13 -> 915
    //   905: aload_0
    //   906: ldc2_w 748
    //   909: invokevirtual 797	com/tencent/mobileqq/activity/aio/tips/VideoStatusTipsBar:a	(J)V
    //   912: goto +10 -> 922
    //   915: aload_0
    //   916: ldc2_w 798
    //   919: invokevirtual 797	com/tencent/mobileqq/activity/aio/tips/VideoStatusTipsBar:a	(J)V
    //   922: aload_0
    //   923: getfield 88	com/tencent/mobileqq/activity/aio/tips/VideoStatusTipsBar:a	Landroid/content/Context;
    //   926: invokevirtual 96	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   929: ldc_w 800
    //   932: invokevirtual 602	android/content/res/Resources:getColor	(I)I
    //   935: istore 4
    //   937: aload_0
    //   938: aload 23
    //   940: getfield 493	com/tencent/mobileqq/activity/aio/tips/VideoStatusTipsBar$TextInfo:b	Ljava/lang/String;
    //   943: aload 23
    //   945: getfield 495	com/tencent/mobileqq/activity/aio/tips/VideoStatusTipsBar$TextInfo:a	Ljava/lang/String;
    //   948: iload 4
    //   950: lload 11
    //   952: invokestatic 802	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   955: iload_2
    //   956: invokevirtual 605	com/tencent/mobileqq/activity/aio/tips/VideoStatusTipsBar:a	(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;I)V
    //   959: aload 25
    //   961: iload 4
    //   963: invokevirtual 805	android/widget/TextView:setTextColor	(I)V
    //   966: aload_0
    //   967: getfield 82	com/tencent/mobileqq/activity/aio/tips/VideoStatusTipsBar:d	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   970: invokestatic 363	com/tencent/mobileqq/vas/theme/api/ThemeUtil:isInNightMode	(Lmqq/app/AppRuntime;)Z
    //   973: istore 22
    //   975: iload_2
    //   976: iconst_2
    //   977: if_icmpne +375 -> 1352
    //   980: aload_0
    //   981: getfield 82	com/tencent/mobileqq/activity/aio/tips/VideoStatusTipsBar:d	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   984: invokevirtual 133	com/tencent/mobileqq/app/QQAppInterface:getAVNotifyCenter	()Lcom/tencent/av/gaudio/AVNotifyCenter;
    //   987: aload_3
    //   988: invokevirtual 192	com/tencent/av/gaudio/AVNotifyCenter:a	(Ljava/lang/String;)Z
    //   991: ifne +361 -> 1352
    //   994: aload 26
    //   996: aconst_null
    //   997: invokevirtual 809	android/widget/ImageView:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   1000: aload_0
    //   1001: getfield 84	com/tencent/mobileqq/activity/aio/tips/VideoStatusTipsBar:e	Lcom/tencent/mobileqq/activity/aio/BaseSessionInfo;
    //   1004: getfield 64	com/tencent/mobileqq/activity/aio/BaseSessionInfo:b	Ljava/lang/String;
    //   1007: astore_3
    //   1008: new 45	java/lang/StringBuilder
    //   1011: dup
    //   1012: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   1015: astore 23
    //   1017: aload 23
    //   1019: ldc 163
    //   1021: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1024: pop
    //   1025: aload 23
    //   1027: aload_0
    //   1028: getfield 82	com/tencent/mobileqq/activity/aio/tips/VideoStatusTipsBar:d	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1031: aload_0
    //   1032: getfield 84	com/tencent/mobileqq/activity/aio/tips/VideoStatusTipsBar:e	Lcom/tencent/mobileqq/activity/aio/BaseSessionInfo;
    //   1035: getfield 64	com/tencent/mobileqq/activity/aio/BaseSessionInfo:b	Ljava/lang/String;
    //   1038: invokestatic 814	com/tencent/mobileqq/troop/utils/TroopUtils:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;)I
    //   1041: invokevirtual 60	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1044: pop
    //   1045: aconst_null
    //   1046: ldc_w 816
    //   1049: ldc_w 818
    //   1052: ldc 163
    //   1054: ldc_w 820
    //   1057: ldc_w 822
    //   1060: iconst_0
    //   1061: iconst_0
    //   1062: aload_3
    //   1063: aload 23
    //   1065: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1068: ldc 163
    //   1070: ldc 163
    //   1072: invokestatic 656	com/tencent/mobileqq/statistics/ReportController:b	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1075: aload_0
    //   1076: getfield 387	com/tencent/mobileqq/activity/aio/tips/VideoStatusTipsBar:i	Landroid/widget/LinearLayout;
    //   1079: iconst_0
    //   1080: invokevirtual 579	android/widget/LinearLayout:setVisibility	(I)V
    //   1083: aload_1
    //   1084: ifnull +233 -> 1317
    //   1087: aload_1
    //   1088: invokevirtual 825	java/util/Vector:size	()I
    //   1091: ifne +6 -> 1097
    //   1094: goto +223 -> 1317
    //   1097: aload_1
    //   1098: invokevirtual 825	java/util/Vector:size	()I
    //   1101: iconst_1
    //   1102: if_icmpne +65 -> 1167
    //   1105: aload_0
    //   1106: getfield 41	com/tencent/mobileqq/activity/aio/tips/VideoStatusTipsBar:j	[Landroid/widget/ImageView;
    //   1109: iconst_0
    //   1110: aaload
    //   1111: iconst_0
    //   1112: invokevirtual 519	android/widget/ImageView:setVisibility	(I)V
    //   1115: aload_0
    //   1116: getfield 41	com/tencent/mobileqq/activity/aio/tips/VideoStatusTipsBar:j	[Landroid/widget/ImageView;
    //   1119: iconst_1
    //   1120: aaload
    //   1121: bipush 8
    //   1123: invokevirtual 519	android/widget/ImageView:setVisibility	(I)V
    //   1126: aload_0
    //   1127: getfield 41	com/tencent/mobileqq/activity/aio/tips/VideoStatusTipsBar:j	[Landroid/widget/ImageView;
    //   1130: iconst_2
    //   1131: aaload
    //   1132: bipush 8
    //   1134: invokevirtual 519	android/widget/ImageView:setVisibility	(I)V
    //   1137: aload_0
    //   1138: getfield 41	com/tencent/mobileqq/activity/aio/tips/VideoStatusTipsBar:j	[Landroid/widget/ImageView;
    //   1141: iconst_0
    //   1142: aaload
    //   1143: aload_0
    //   1144: aload_1
    //   1145: iconst_0
    //   1146: invokevirtual 826	java/util/Vector:get	(I)Ljava/lang/Object;
    //   1149: checkcast 456	com/tencent/av/gaudio/AVNotifyCenter$UserInfo
    //   1152: getfield 462	com/tencent/av/gaudio/AVNotifyCenter$UserInfo:a	J
    //   1155: invokestatic 802	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1158: invokevirtual 828	com/tencent/mobileqq/activity/aio/tips/VideoStatusTipsBar:a	(Ljava/lang/String;)Landroid/graphics/drawable/Drawable;
    //   1161: invokevirtual 809	android/widget/ImageView:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   1164: goto +185 -> 1349
    //   1167: aload_1
    //   1168: invokevirtual 825	java/util/Vector:size	()I
    //   1171: iconst_2
    //   1172: if_icmpne +91 -> 1263
    //   1175: aload_0
    //   1176: getfield 41	com/tencent/mobileqq/activity/aio/tips/VideoStatusTipsBar:j	[Landroid/widget/ImageView;
    //   1179: iconst_0
    //   1180: aaload
    //   1181: iconst_0
    //   1182: invokevirtual 519	android/widget/ImageView:setVisibility	(I)V
    //   1185: aload_0
    //   1186: getfield 41	com/tencent/mobileqq/activity/aio/tips/VideoStatusTipsBar:j	[Landroid/widget/ImageView;
    //   1189: iconst_1
    //   1190: aaload
    //   1191: iconst_0
    //   1192: invokevirtual 519	android/widget/ImageView:setVisibility	(I)V
    //   1195: aload_0
    //   1196: getfield 41	com/tencent/mobileqq/activity/aio/tips/VideoStatusTipsBar:j	[Landroid/widget/ImageView;
    //   1199: iconst_2
    //   1200: aaload
    //   1201: bipush 8
    //   1203: invokevirtual 519	android/widget/ImageView:setVisibility	(I)V
    //   1206: aload_0
    //   1207: getfield 41	com/tencent/mobileqq/activity/aio/tips/VideoStatusTipsBar:j	[Landroid/widget/ImageView;
    //   1210: iconst_0
    //   1211: aaload
    //   1212: aload_0
    //   1213: aload_1
    //   1214: iconst_0
    //   1215: invokevirtual 826	java/util/Vector:get	(I)Ljava/lang/Object;
    //   1218: checkcast 456	com/tencent/av/gaudio/AVNotifyCenter$UserInfo
    //   1221: getfield 462	com/tencent/av/gaudio/AVNotifyCenter$UserInfo:a	J
    //   1224: invokestatic 802	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1227: invokevirtual 828	com/tencent/mobileqq/activity/aio/tips/VideoStatusTipsBar:a	(Ljava/lang/String;)Landroid/graphics/drawable/Drawable;
    //   1230: invokevirtual 809	android/widget/ImageView:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   1233: aload_0
    //   1234: getfield 41	com/tencent/mobileqq/activity/aio/tips/VideoStatusTipsBar:j	[Landroid/widget/ImageView;
    //   1237: iconst_1
    //   1238: aaload
    //   1239: aload_0
    //   1240: aload_1
    //   1241: iconst_1
    //   1242: invokevirtual 826	java/util/Vector:get	(I)Ljava/lang/Object;
    //   1245: checkcast 456	com/tencent/av/gaudio/AVNotifyCenter$UserInfo
    //   1248: getfield 462	com/tencent/av/gaudio/AVNotifyCenter$UserInfo:a	J
    //   1251: invokestatic 802	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1254: invokevirtual 828	com/tencent/mobileqq/activity/aio/tips/VideoStatusTipsBar:a	(Ljava/lang/String;)Landroid/graphics/drawable/Drawable;
    //   1257: invokevirtual 809	android/widget/ImageView:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   1260: goto +89 -> 1349
    //   1263: iconst_0
    //   1264: istore_2
    //   1265: aload_0
    //   1266: getfield 41	com/tencent/mobileqq/activity/aio/tips/VideoStatusTipsBar:j	[Landroid/widget/ImageView;
    //   1269: astore_3
    //   1270: iload_2
    //   1271: aload_3
    //   1272: arraylength
    //   1273: if_icmpge +76 -> 1349
    //   1276: aload_3
    //   1277: iload_2
    //   1278: aaload
    //   1279: iconst_0
    //   1280: invokevirtual 519	android/widget/ImageView:setVisibility	(I)V
    //   1283: aload_0
    //   1284: getfield 41	com/tencent/mobileqq/activity/aio/tips/VideoStatusTipsBar:j	[Landroid/widget/ImageView;
    //   1287: iload_2
    //   1288: aaload
    //   1289: aload_0
    //   1290: aload_1
    //   1291: iload_2
    //   1292: invokevirtual 826	java/util/Vector:get	(I)Ljava/lang/Object;
    //   1295: checkcast 456	com/tencent/av/gaudio/AVNotifyCenter$UserInfo
    //   1298: getfield 462	com/tencent/av/gaudio/AVNotifyCenter$UserInfo:a	J
    //   1301: invokestatic 802	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1304: invokevirtual 828	com/tencent/mobileqq/activity/aio/tips/VideoStatusTipsBar:a	(Ljava/lang/String;)Landroid/graphics/drawable/Drawable;
    //   1307: invokevirtual 809	android/widget/ImageView:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   1310: iload_2
    //   1311: iconst_1
    //   1312: iadd
    //   1313: istore_2
    //   1314: goto -49 -> 1265
    //   1317: aload_0
    //   1318: getfield 41	com/tencent/mobileqq/activity/aio/tips/VideoStatusTipsBar:j	[Landroid/widget/ImageView;
    //   1321: astore_1
    //   1322: aload_1
    //   1323: arraylength
    //   1324: istore 4
    //   1326: iconst_0
    //   1327: istore_2
    //   1328: iload_2
    //   1329: iload 4
    //   1331: if_icmpge +18 -> 1349
    //   1334: aload_1
    //   1335: iload_2
    //   1336: aaload
    //   1337: bipush 8
    //   1339: invokevirtual 519	android/widget/ImageView:setVisibility	(I)V
    //   1342: iload_2
    //   1343: iconst_1
    //   1344: iadd
    //   1345: istore_2
    //   1346: goto -18 -> 1328
    //   1349: goto +1012 -> 2361
    //   1352: iload_2
    //   1353: bipush 10
    //   1355: if_icmpeq +17 -> 1372
    //   1358: iload_2
    //   1359: iconst_1
    //   1360: if_icmpeq +12 -> 1372
    //   1363: iload 9
    //   1365: iconst_2
    //   1366: if_icmpne +955 -> 2321
    //   1369: goto +3 -> 1372
    //   1372: aload_0
    //   1373: getfield 82	com/tencent/mobileqq/activity/aio/tips/VideoStatusTipsBar:d	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1376: invokevirtual 133	com/tencent/mobileqq/app/QQAppInterface:getAVNotifyCenter	()Lcom/tencent/av/gaudio/AVNotifyCenter;
    //   1379: aload_3
    //   1380: invokevirtual 192	com/tencent/av/gaudio/AVNotifyCenter:a	(Ljava/lang/String;)Z
    //   1383: ifne +938 -> 2321
    //   1386: iload 9
    //   1388: iconst_2
    //   1389: if_icmpne +21 -> 1410
    //   1392: aload_0
    //   1393: getfield 82	com/tencent/mobileqq/activity/aio/tips/VideoStatusTipsBar:d	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1396: invokevirtual 133	com/tencent/mobileqq/app/QQAppInterface:getAVNotifyCenter	()Lcom/tencent/av/gaudio/AVNotifyCenter;
    //   1399: iload 9
    //   1401: lload 11
    //   1403: invokevirtual 831	com/tencent/av/gaudio/AVNotifyCenter:e	(IJ)Ljava/util/Vector;
    //   1406: astore_1
    //   1407: goto +3 -> 1410
    //   1410: aload_1
    //   1411: ifnull +44 -> 1455
    //   1414: aload_1
    //   1415: invokevirtual 825	java/util/Vector:size	()I
    //   1418: iconst_1
    //   1419: if_icmpne +36 -> 1455
    //   1422: aload_0
    //   1423: getfield 82	com/tencent/mobileqq/activity/aio/tips/VideoStatusTipsBar:d	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1426: invokevirtual 834	com/tencent/mobileqq/app/QQAppInterface:getCurrentUin	()Ljava/lang/String;
    //   1429: aload_1
    //   1430: iconst_0
    //   1431: invokevirtual 826	java/util/Vector:get	(I)Ljava/lang/Object;
    //   1434: checkcast 456	com/tencent/av/gaudio/AVNotifyCenter$UserInfo
    //   1437: getfield 462	com/tencent/av/gaudio/AVNotifyCenter$UserInfo:a	J
    //   1440: invokestatic 802	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1443: invokevirtual 837	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   1446: ifeq +9 -> 1455
    //   1449: iconst_1
    //   1450: istore 19
    //   1452: goto +6 -> 1458
    //   1455: iconst_0
    //   1456: istore 19
    //   1458: aload_1
    //   1459: ifnull +745 -> 2204
    //   1462: aload_1
    //   1463: invokevirtual 825	java/util/Vector:size	()I
    //   1466: ifeq +738 -> 2204
    //   1469: iload 19
    //   1471: ifeq +6 -> 1477
    //   1474: goto +730 -> 2204
    //   1477: aload 26
    //   1479: aconst_null
    //   1480: invokevirtual 841	android/widget/ImageView:setImageBitmap	(Landroid/graphics/Bitmap;)V
    //   1483: aload_0
    //   1484: getfield 387	com/tencent/mobileqq/activity/aio/tips/VideoStatusTipsBar:i	Landroid/widget/LinearLayout;
    //   1487: bipush 8
    //   1489: invokevirtual 579	android/widget/LinearLayout:setVisibility	(I)V
    //   1492: aload_0
    //   1493: getfield 394	com/tencent/mobileqq/activity/aio/tips/VideoStatusTipsBar:k	Landroid/widget/LinearLayout;
    //   1496: iconst_0
    //   1497: invokevirtual 579	android/widget/LinearLayout:setVisibility	(I)V
    //   1500: aload_0
    //   1501: getfield 82	com/tencent/mobileqq/activity/aio/tips/VideoStatusTipsBar:d	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1504: getstatic 642	com/tencent/mobileqq/app/QQManagerFactory:FRIENDS_MANAGER	I
    //   1507: invokevirtual 247	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   1510: checkcast 644	com/tencent/mobileqq/app/FriendsManager
    //   1513: astore 27
    //   1515: new 254	java/util/ArrayList
    //   1518: dup
    //   1519: iconst_3
    //   1520: invokespecial 843	java/util/ArrayList:<init>	(I)V
    //   1523: astore 23
    //   1525: iconst_0
    //   1526: istore_2
    //   1527: iload_2
    //   1528: aload_1
    //   1529: invokevirtual 825	java/util/Vector:size	()I
    //   1532: if_icmpge +55 -> 1587
    //   1535: aload 27
    //   1537: aload_1
    //   1538: iload_2
    //   1539: invokevirtual 826	java/util/Vector:get	(I)Ljava/lang/Object;
    //   1542: checkcast 456	com/tencent/av/gaudio/AVNotifyCenter$UserInfo
    //   1545: getfield 462	com/tencent/av/gaudio/AVNotifyCenter$UserInfo:a	J
    //   1548: invokestatic 802	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1551: invokevirtual 647	com/tencent/mobileqq/app/FriendsManager:n	(Ljava/lang/String;)Z
    //   1554: ifeq +14 -> 1568
    //   1557: aload 23
    //   1559: aload_1
    //   1560: iload_2
    //   1561: invokevirtual 826	java/util/Vector:get	(I)Ljava/lang/Object;
    //   1564: invokevirtual 846	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1567: pop
    //   1568: aload 23
    //   1570: invokevirtual 257	java/util/ArrayList:size	()I
    //   1573: iconst_3
    //   1574: if_icmpne +6 -> 1580
    //   1577: goto +10 -> 1587
    //   1580: iload_2
    //   1581: iconst_1
    //   1582: iadd
    //   1583: istore_2
    //   1584: goto -57 -> 1527
    //   1587: aload_0
    //   1588: getfield 82	com/tencent/mobileqq/activity/aio/tips/VideoStatusTipsBar:d	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1591: getstatic 642	com/tencent/mobileqq/app/QQManagerFactory:FRIENDS_MANAGER	I
    //   1594: invokevirtual 247	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   1597: checkcast 644	com/tencent/mobileqq/app/FriendsManager
    //   1600: astore 27
    //   1602: aload 23
    //   1604: invokevirtual 257	java/util/ArrayList:size	()I
    //   1607: ifne +12 -> 1619
    //   1610: aload_1
    //   1611: iconst_0
    //   1612: invokevirtual 826	java/util/Vector:get	(I)Ljava/lang/Object;
    //   1615: astore_1
    //   1616: goto +10 -> 1626
    //   1619: aload 23
    //   1621: iconst_0
    //   1622: invokevirtual 261	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   1625: astore_1
    //   1626: aload_1
    //   1627: checkcast 456	com/tencent/av/gaudio/AVNotifyCenter$UserInfo
    //   1630: getfield 462	com/tencent/av/gaudio/AVNotifyCenter$UserInfo:a	J
    //   1633: invokestatic 802	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1636: astore_1
    //   1637: aload 27
    //   1639: aload_1
    //   1640: invokevirtual 647	com/tencent/mobileqq/app/FriendsManager:n	(Ljava/lang/String;)Z
    //   1643: ifeq +290 -> 1933
    //   1646: aload 23
    //   1648: invokevirtual 257	java/util/ArrayList:size	()I
    //   1651: iconst_1
    //   1652: if_icmpne +66 -> 1718
    //   1655: aload_0
    //   1656: getfield 43	com/tencent/mobileqq/activity/aio/tips/VideoStatusTipsBar:l	[Landroid/widget/ImageView;
    //   1659: iconst_0
    //   1660: aaload
    //   1661: iconst_0
    //   1662: invokevirtual 519	android/widget/ImageView:setVisibility	(I)V
    //   1665: aload_0
    //   1666: getfield 43	com/tencent/mobileqq/activity/aio/tips/VideoStatusTipsBar:l	[Landroid/widget/ImageView;
    //   1669: iconst_1
    //   1670: aaload
    //   1671: bipush 8
    //   1673: invokevirtual 519	android/widget/ImageView:setVisibility	(I)V
    //   1676: aload_0
    //   1677: getfield 43	com/tencent/mobileqq/activity/aio/tips/VideoStatusTipsBar:l	[Landroid/widget/ImageView;
    //   1680: iconst_2
    //   1681: aaload
    //   1682: bipush 8
    //   1684: invokevirtual 519	android/widget/ImageView:setVisibility	(I)V
    //   1687: aload_0
    //   1688: getfield 43	com/tencent/mobileqq/activity/aio/tips/VideoStatusTipsBar:l	[Landroid/widget/ImageView;
    //   1691: iconst_0
    //   1692: aaload
    //   1693: aload_0
    //   1694: aload 23
    //   1696: iconst_0
    //   1697: invokevirtual 261	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   1700: checkcast 456	com/tencent/av/gaudio/AVNotifyCenter$UserInfo
    //   1703: getfield 462	com/tencent/av/gaudio/AVNotifyCenter$UserInfo:a	J
    //   1706: invokestatic 802	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1709: invokevirtual 828	com/tencent/mobileqq/activity/aio/tips/VideoStatusTipsBar:a	(Ljava/lang/String;)Landroid/graphics/drawable/Drawable;
    //   1712: invokevirtual 809	android/widget/ImageView:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   1715: goto +249 -> 1964
    //   1718: aload 23
    //   1720: invokevirtual 257	java/util/ArrayList:size	()I
    //   1723: iconst_2
    //   1724: if_icmpne +93 -> 1817
    //   1727: aload_0
    //   1728: getfield 43	com/tencent/mobileqq/activity/aio/tips/VideoStatusTipsBar:l	[Landroid/widget/ImageView;
    //   1731: iconst_0
    //   1732: aaload
    //   1733: iconst_0
    //   1734: invokevirtual 519	android/widget/ImageView:setVisibility	(I)V
    //   1737: aload_0
    //   1738: getfield 43	com/tencent/mobileqq/activity/aio/tips/VideoStatusTipsBar:l	[Landroid/widget/ImageView;
    //   1741: iconst_1
    //   1742: aaload
    //   1743: iconst_0
    //   1744: invokevirtual 519	android/widget/ImageView:setVisibility	(I)V
    //   1747: aload_0
    //   1748: getfield 43	com/tencent/mobileqq/activity/aio/tips/VideoStatusTipsBar:l	[Landroid/widget/ImageView;
    //   1751: iconst_2
    //   1752: aaload
    //   1753: bipush 8
    //   1755: invokevirtual 519	android/widget/ImageView:setVisibility	(I)V
    //   1758: aload_0
    //   1759: getfield 43	com/tencent/mobileqq/activity/aio/tips/VideoStatusTipsBar:l	[Landroid/widget/ImageView;
    //   1762: iconst_0
    //   1763: aaload
    //   1764: aload_0
    //   1765: aload 23
    //   1767: iconst_0
    //   1768: invokevirtual 261	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   1771: checkcast 456	com/tencent/av/gaudio/AVNotifyCenter$UserInfo
    //   1774: getfield 462	com/tencent/av/gaudio/AVNotifyCenter$UserInfo:a	J
    //   1777: invokestatic 802	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1780: invokevirtual 828	com/tencent/mobileqq/activity/aio/tips/VideoStatusTipsBar:a	(Ljava/lang/String;)Landroid/graphics/drawable/Drawable;
    //   1783: invokevirtual 809	android/widget/ImageView:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   1786: aload_0
    //   1787: getfield 43	com/tencent/mobileqq/activity/aio/tips/VideoStatusTipsBar:l	[Landroid/widget/ImageView;
    //   1790: iconst_1
    //   1791: aaload
    //   1792: aload_0
    //   1793: aload 23
    //   1795: iconst_1
    //   1796: invokevirtual 261	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   1799: checkcast 456	com/tencent/av/gaudio/AVNotifyCenter$UserInfo
    //   1802: getfield 462	com/tencent/av/gaudio/AVNotifyCenter$UserInfo:a	J
    //   1805: invokestatic 802	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1808: invokevirtual 828	com/tencent/mobileqq/activity/aio/tips/VideoStatusTipsBar:a	(Ljava/lang/String;)Landroid/graphics/drawable/Drawable;
    //   1811: invokevirtual 809	android/widget/ImageView:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   1814: goto +150 -> 1964
    //   1817: aload 23
    //   1819: invokevirtual 257	java/util/ArrayList:size	()I
    //   1822: iconst_3
    //   1823: if_icmpne +61 -> 1884
    //   1826: iconst_0
    //   1827: istore_2
    //   1828: aload_0
    //   1829: getfield 43	com/tencent/mobileqq/activity/aio/tips/VideoStatusTipsBar:l	[Landroid/widget/ImageView;
    //   1832: astore 26
    //   1834: iload_2
    //   1835: aload 26
    //   1837: arraylength
    //   1838: if_icmpge +126 -> 1964
    //   1841: aload 26
    //   1843: iload_2
    //   1844: aaload
    //   1845: iconst_0
    //   1846: invokevirtual 519	android/widget/ImageView:setVisibility	(I)V
    //   1849: aload_0
    //   1850: getfield 43	com/tencent/mobileqq/activity/aio/tips/VideoStatusTipsBar:l	[Landroid/widget/ImageView;
    //   1853: iload_2
    //   1854: aaload
    //   1855: aload_0
    //   1856: aload 23
    //   1858: iload_2
    //   1859: invokevirtual 261	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   1862: checkcast 456	com/tencent/av/gaudio/AVNotifyCenter$UserInfo
    //   1865: getfield 462	com/tencent/av/gaudio/AVNotifyCenter$UserInfo:a	J
    //   1868: invokestatic 802	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1871: invokevirtual 828	com/tencent/mobileqq/activity/aio/tips/VideoStatusTipsBar:a	(Ljava/lang/String;)Landroid/graphics/drawable/Drawable;
    //   1874: invokevirtual 809	android/widget/ImageView:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   1877: iload_2
    //   1878: iconst_1
    //   1879: iadd
    //   1880: istore_2
    //   1881: goto -53 -> 1828
    //   1884: aload_0
    //   1885: getfield 43	com/tencent/mobileqq/activity/aio/tips/VideoStatusTipsBar:l	[Landroid/widget/ImageView;
    //   1888: iconst_0
    //   1889: aaload
    //   1890: iconst_0
    //   1891: invokevirtual 519	android/widget/ImageView:setVisibility	(I)V
    //   1894: aload_0
    //   1895: getfield 43	com/tencent/mobileqq/activity/aio/tips/VideoStatusTipsBar:l	[Landroid/widget/ImageView;
    //   1898: iconst_1
    //   1899: aaload
    //   1900: bipush 8
    //   1902: invokevirtual 519	android/widget/ImageView:setVisibility	(I)V
    //   1905: aload_0
    //   1906: getfield 43	com/tencent/mobileqq/activity/aio/tips/VideoStatusTipsBar:l	[Landroid/widget/ImageView;
    //   1909: iconst_2
    //   1910: aaload
    //   1911: bipush 8
    //   1913: invokevirtual 519	android/widget/ImageView:setVisibility	(I)V
    //   1916: aload_0
    //   1917: getfield 43	com/tencent/mobileqq/activity/aio/tips/VideoStatusTipsBar:l	[Landroid/widget/ImageView;
    //   1920: iconst_0
    //   1921: aaload
    //   1922: aload_0
    //   1923: aload_1
    //   1924: invokevirtual 828	com/tencent/mobileqq/activity/aio/tips/VideoStatusTipsBar:a	(Ljava/lang/String;)Landroid/graphics/drawable/Drawable;
    //   1927: invokevirtual 809	android/widget/ImageView:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   1930: goto +34 -> 1964
    //   1933: iload 22
    //   1935: ifeq +10 -> 1945
    //   1938: ldc_w 847
    //   1941: istore_2
    //   1942: goto +7 -> 1949
    //   1945: ldc_w 848
    //   1948: istore_2
    //   1949: aload 26
    //   1951: iload_2
    //   1952: invokevirtual 615	android/widget/ImageView:setImageResource	(I)V
    //   1955: aload_0
    //   1956: getfield 394	com/tencent/mobileqq/activity/aio/tips/VideoStatusTipsBar:k	Landroid/widget/LinearLayout;
    //   1959: bipush 8
    //   1961: invokevirtual 579	android/widget/LinearLayout:setVisibility	(I)V
    //   1964: aload_0
    //   1965: getfield 84	com/tencent/mobileqq/activity/aio/tips/VideoStatusTipsBar:e	Lcom/tencent/mobileqq/activity/aio/BaseSessionInfo;
    //   1968: getfield 57	com/tencent/mobileqq/activity/aio/BaseSessionInfo:a	I
    //   1971: iconst_1
    //   1972: if_icmpne +8 -> 1980
    //   1975: iconst_1
    //   1976: istore_2
    //   1977: goto +5 -> 1982
    //   1980: iconst_2
    //   1981: istore_2
    //   1982: aload_0
    //   1983: getfield 82	com/tencent/mobileqq/activity/aio/tips/VideoStatusTipsBar:d	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1986: aload_1
    //   1987: aload_3
    //   1988: iload_2
    //   1989: iconst_0
    //   1990: invokestatic 474	com/tencent/mobileqq/utils/ContactUtils:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;II)Ljava/lang/String;
    //   1993: astore_3
    //   1994: lload 13
    //   1996: lconst_1
    //   1997: lcmp
    //   1998: ifne +17 -> 2015
    //   2001: aload_0
    //   2002: getfield 88	com/tencent/mobileqq/activity/aio/tips/VideoStatusTipsBar:a	Landroid/content/Context;
    //   2005: ldc_w 849
    //   2008: invokevirtual 147	android/content/Context:getString	(I)Ljava/lang/String;
    //   2011: astore_1
    //   2012: goto +73 -> 2085
    //   2015: aload_0
    //   2016: getfield 84	com/tencent/mobileqq/activity/aio/tips/VideoStatusTipsBar:e	Lcom/tencent/mobileqq/activity/aio/BaseSessionInfo;
    //   2019: getfield 57	com/tencent/mobileqq/activity/aio/BaseSessionInfo:a	I
    //   2022: sipush 3000
    //   2025: if_icmpne +17 -> 2042
    //   2028: aload_0
    //   2029: getfield 88	com/tencent/mobileqq/activity/aio/tips/VideoStatusTipsBar:a	Landroid/content/Context;
    //   2032: ldc_w 467
    //   2035: invokevirtual 147	android/content/Context:getString	(I)Ljava/lang/String;
    //   2038: astore_1
    //   2039: goto +29 -> 2068
    //   2042: aload_0
    //   2043: getfield 84	com/tencent/mobileqq/activity/aio/tips/VideoStatusTipsBar:e	Lcom/tencent/mobileqq/activity/aio/BaseSessionInfo;
    //   2046: getfield 57	com/tencent/mobileqq/activity/aio/BaseSessionInfo:a	I
    //   2049: iconst_1
    //   2050: if_icmpne +16 -> 2066
    //   2053: aload_0
    //   2054: getfield 88	com/tencent/mobileqq/activity/aio/tips/VideoStatusTipsBar:a	Landroid/content/Context;
    //   2057: ldc 160
    //   2059: invokevirtual 147	android/content/Context:getString	(I)Ljava/lang/String;
    //   2062: astore_1
    //   2063: goto +5 -> 2068
    //   2066: aconst_null
    //   2067: astore_1
    //   2068: aload_1
    //   2069: iconst_1
    //   2070: anewarray 4	java/lang/Object
    //   2073: dup
    //   2074: iconst_0
    //   2075: lload 13
    //   2077: invokestatic 450	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2080: aastore
    //   2081: invokestatic 454	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   2084: astore_1
    //   2085: aload_0
    //   2086: getfield 321	com/tencent/mobileqq/activity/aio/tips/VideoStatusTipsBar:h	Landroid/view/View;
    //   2089: ldc_w 850
    //   2092: invokevirtual 383	android/view/View:findViewById	(I)Landroid/view/View;
    //   2095: checkcast 476	android/widget/TextView
    //   2098: astore 23
    //   2100: aload 23
    //   2102: ifnull +57 -> 2159
    //   2105: aload_0
    //   2106: getfield 321	com/tencent/mobileqq/activity/aio/tips/VideoStatusTipsBar:h	Landroid/view/View;
    //   2109: invokevirtual 851	android/view/View:getResources	()Landroid/content/res/Resources;
    //   2112: ldc_w 852
    //   2115: invokevirtual 185	android/content/res/Resources:getDimensionPixelSize	(I)I
    //   2118: i2f
    //   2119: fstore 7
    //   2121: new 45	java/lang/StringBuilder
    //   2124: dup
    //   2125: aload_0
    //   2126: getfield 321	com/tencent/mobileqq/activity/aio/tips/VideoStatusTipsBar:h	Landroid/view/View;
    //   2129: invokevirtual 855	android/view/View:getContext	()Landroid/content/Context;
    //   2132: aload_3
    //   2133: invokevirtual 856	java/lang/String:toString	()Ljava/lang/String;
    //   2136: aload 23
    //   2138: fload 7
    //   2140: invokestatic 858	com/tencent/av/utils/UITools:a	(Landroid/content/Context;Ljava/lang/String;Landroid/widget/TextView;F)Ljava/lang/String;
    //   2143: invokespecial 859	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2146: astore_3
    //   2147: aload_3
    //   2148: aload_1
    //   2149: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2152: pop
    //   2153: aload 23
    //   2155: aload_3
    //   2156: invokevirtual 863	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   2159: aload 25
    //   2161: invokevirtual 866	android/widget/TextView:getVisibility	()I
    //   2164: ifne +13 -> 2177
    //   2167: aload 25
    //   2169: bipush 8
    //   2171: invokevirtual 479	android/widget/TextView:setVisibility	(I)V
    //   2174: goto +3 -> 2177
    //   2177: aload_0
    //   2178: getfield 321	com/tencent/mobileqq/activity/aio/tips/VideoStatusTipsBar:h	Landroid/view/View;
    //   2181: ldc_w 867
    //   2184: invokevirtual 383	android/view/View:findViewById	(I)Landroid/view/View;
    //   2187: checkcast 476	android/widget/TextView
    //   2190: astore_1
    //   2191: aload_1
    //   2192: ifnull -843 -> 1349
    //   2195: aload_1
    //   2196: bipush 8
    //   2198: invokevirtual 479	android/widget/TextView:setVisibility	(I)V
    //   2201: goto -852 -> 1349
    //   2204: iload 22
    //   2206: ifeq +10 -> 2216
    //   2209: ldc_w 847
    //   2212: istore_2
    //   2213: goto +7 -> 2220
    //   2216: ldc_w 848
    //   2219: istore_2
    //   2220: aload 26
    //   2222: iload_2
    //   2223: invokevirtual 615	android/widget/ImageView:setImageResource	(I)V
    //   2226: iload 19
    //   2228: ifeq +35 -> 2263
    //   2231: aload_0
    //   2232: getfield 321	com/tencent/mobileqq/activity/aio/tips/VideoStatusTipsBar:h	Landroid/view/View;
    //   2235: ldc_w 850
    //   2238: invokevirtual 383	android/view/View:findViewById	(I)Landroid/view/View;
    //   2241: checkcast 476	android/widget/TextView
    //   2244: astore_1
    //   2245: aload_1
    //   2246: ifnull +17 -> 2263
    //   2249: aload_1
    //   2250: aload_0
    //   2251: getfield 88	com/tencent/mobileqq/activity/aio/tips/VideoStatusTipsBar:a	Landroid/content/Context;
    //   2254: ldc_w 868
    //   2257: invokevirtual 147	android/content/Context:getString	(I)Ljava/lang/String;
    //   2260: invokevirtual 863	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   2263: aload_0
    //   2264: getfield 387	com/tencent/mobileqq/activity/aio/tips/VideoStatusTipsBar:i	Landroid/widget/LinearLayout;
    //   2267: bipush 8
    //   2269: invokevirtual 579	android/widget/LinearLayout:setVisibility	(I)V
    //   2272: aload_0
    //   2273: getfield 394	com/tencent/mobileqq/activity/aio/tips/VideoStatusTipsBar:k	Landroid/widget/LinearLayout;
    //   2276: bipush 8
    //   2278: invokevirtual 579	android/widget/LinearLayout:setVisibility	(I)V
    //   2281: aload_0
    //   2282: getfield 80	com/tencent/mobileqq/activity/aio/tips/VideoStatusTipsBar:c	Ljava/lang/String;
    //   2285: astore_1
    //   2286: new 45	java/lang/StringBuilder
    //   2289: dup
    //   2290: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   2293: astore_3
    //   2294: aload_3
    //   2295: ldc_w 870
    //   2298: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2301: pop
    //   2302: aload_3
    //   2303: iload 19
    //   2305: invokevirtual 562	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   2308: pop
    //   2309: aload_1
    //   2310: iconst_1
    //   2311: aload_3
    //   2312: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2315: invokestatic 124	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   2318: goto +43 -> 2361
    //   2321: iload 22
    //   2323: ifeq +10 -> 2333
    //   2326: ldc_w 847
    //   2329: istore_2
    //   2330: goto +7 -> 2337
    //   2333: ldc_w 848
    //   2336: istore_2
    //   2337: aload 26
    //   2339: iload_2
    //   2340: invokevirtual 615	android/widget/ImageView:setImageResource	(I)V
    //   2343: aload_0
    //   2344: getfield 387	com/tencent/mobileqq/activity/aio/tips/VideoStatusTipsBar:i	Landroid/widget/LinearLayout;
    //   2347: bipush 8
    //   2349: invokevirtual 579	android/widget/LinearLayout:setVisibility	(I)V
    //   2352: aload_0
    //   2353: getfield 394	com/tencent/mobileqq/activity/aio/tips/VideoStatusTipsBar:k	Landroid/widget/LinearLayout;
    //   2356: bipush 8
    //   2358: invokevirtual 579	android/widget/LinearLayout:setVisibility	(I)V
    //   2361: aload_0
    //   2362: getfield 82	com/tencent/mobileqq/activity/aio/tips/VideoStatusTipsBar:d	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2365: invokestatic 363	com/tencent/mobileqq/vas/theme/api/ThemeUtil:isInNightMode	(Lmqq/app/AppRuntime;)Z
    //   2368: ifne +14 -> 2382
    //   2371: aload 24
    //   2373: ldc_w 612
    //   2376: invokevirtual 615	android/widget/ImageView:setImageResource	(I)V
    //   2379: goto +11 -> 2390
    //   2382: aload 24
    //   2384: ldc_w 617
    //   2387: invokevirtual 615	android/widget/ImageView:setImageResource	(I)V
    //   2390: aload_0
    //   2391: getfield 82	com/tencent/mobileqq/activity/aio/tips/VideoStatusTipsBar:d	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2394: invokevirtual 402	com/tencent/mobileqq/app/QQAppInterface:isVideoChatting	()Z
    //   2397: ifeq +26 -> 2423
    //   2400: iload 20
    //   2402: ifeq +21 -> 2423
    //   2405: iload 21
    //   2407: istore 19
    //   2409: aload_0
    //   2410: getfield 82	com/tencent/mobileqq/activity/aio/tips/VideoStatusTipsBar:d	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2413: invokevirtual 133	com/tencent/mobileqq/app/QQAppInterface:getAVNotifyCenter	()Lcom/tencent/av/gaudio/AVNotifyCenter;
    //   2416: invokevirtual 569	com/tencent/av/gaudio/AVNotifyCenter:B	()I
    //   2419: iconst_2
    //   2420: if_icmpne +6 -> 2426
    //   2423: iconst_1
    //   2424: istore 19
    //   2426: aload_0
    //   2427: iload 19
    //   2429: invokevirtual 619	com/tencent/mobileqq/activity/aio/tips/VideoStatusTipsBar:a	(Z)V
    //   2432: return
    //   2433: astore_1
    //   2434: goto -2252 -> 182
    //   2437: astore_1
    //   2438: goto -1950 -> 488
    //   2441: goto -2020 -> 421
    //   2444: astore_1
    //   2445: goto -1957 -> 488
    //   2448: goto -2027 -> 421
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2451	0	this	VideoStatusTipsBar
    //   0	2451	1	paramString1	String
    //   0	2451	2	paramInt1	int
    //   0	2451	3	paramString2	String
    //   0	2451	4	paramInt2	int
    //   0	2451	5	paramLong	long
    //   2119	20	7	f1	float
    //   239	520	8	n	int
    //   195	1205	9	i1	int
    //   441	199	10	i2	int
    //   177	1225	11	l1	long
    //   211	1865	13	l2	long
    //   319	9	15	l3	long
    //   325	5	17	l4	long
    //   255	2173	19	bool1	boolean
    //   787	1614	20	bool2	boolean
    //   888	1518	21	bool3	boolean
    //   973	1349	22	bool4	boolean
    //   10	2144	23	localObject1	Object
    //   19	2364	24	localObject2	Object
    //   806	1362	25	localTextView	TextView
    //   225	2113	26	localObject3	Object
    //   836	802	27	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   448	453	459	java/lang/NumberFormatException
    //   392	397	463	java/lang/NumberFormatException
    //   400	418	463	java/lang/NumberFormatException
    //   424	434	463	java/lang/NumberFormatException
    //   437	443	463	java/lang/NumberFormatException
    //   287	296	483	java/lang/NumberFormatException
    //   300	321	483	java/lang/NumberFormatException
    //   279	287	487	java/lang/NumberFormatException
    //   173	179	2433	java/lang/NumberFormatException
    //   339	389	2437	java/lang/NumberFormatException
    //   321	327	2444	java/lang/NumberFormatException
  }
  
  public void a(String paramString1, String paramString2, int paramInt1, String paramString3, int paramInt2)
  {
    LinearLayout localLinearLayout = (LinearLayout)this.h.findViewById(2131447184);
    localLinearLayout.removeAllViews();
    if (paramString1 != null)
    {
      localTextView = new TextView(this.a.getApplicationContext());
      localTextView.setId(2131438963);
      float f1 = this.a.getResources().getDimensionPixelSize(2131298092);
      paramString1 = a(this.a, paramString1, localTextView, f1);
      localTextView.setTextSize(14.0F);
      localTextView.setTextColor(paramInt1);
      localTextView.setSingleLine();
      localTextView.setGravity(5);
      localTextView.setMaxWidth(this.a.getResources().getDimensionPixelSize(2131297547));
      localTextView.setEllipsize(TextUtils.TruncateAt.END);
      localTextView.setText(paramString1);
      localLinearLayout.addView(localTextView);
    }
    TextView localTextView = new TextView(this.a.getApplicationContext());
    localTextView.setTextSize(14.0F);
    localTextView.setTextColor(paramInt1);
    paramInt1 = paramInt2;
    if (paramInt2 == 0) {}
    try
    {
      paramInt1 = this.d.getAVNotifyCenter().e(Long.valueOf(paramString3).longValue());
    }
    catch (Exception paramString1)
    {
      label202:
      int n;
      break label202;
    }
    paramInt1 = 0;
    paramString1 = paramString2;
    if (paramString2 != null)
    {
      paramString1 = (String)this.d.getAVNotifyCenter().g.get(paramString3);
      if (paramString1 != null)
      {
        paramInt2 = Integer.valueOf(paramString1.split(";")[0]).intValue();
        n = Integer.valueOf(paramString1.split(";")[1]).intValue();
      }
      else
      {
        n = 0;
        paramInt2 = 0;
      }
      if (paramInt2 == 1)
      {
        if (n > 99) {
          paramString1 = this.d.getApp().getString(2131893369);
        } else {
          paramString1 = String.format(this.d.getApp().getString(2131893368), new Object[] { Integer.valueOf(n) });
        }
      }
      else
      {
        paramString1 = paramString2;
        if (paramInt1 == 2) {
          paramString1 = paramString2.replace(this.d.getApp().getString(2131917338), this.d.getApp().getString(2131917339));
        }
      }
    }
    localTextView.setText(paramString1);
    localTextView.setId(2131440993);
    if (ThemeUtil.isInNightMode(this.d)) {
      localTextView.setTextColor(Color.parseColor("#A8A8A8"));
    }
    localLinearLayout.addView(localTextView);
  }
  
  public void a(boolean paramBoolean)
  {
    Object localObject = this.a;
    boolean bool;
    if ((localObject != null) && ((localObject instanceof BaseActivity))) {
      bool = ((BaseActivity)localObject).isResume();
    } else {
      bool = false;
    }
    if (paramBoolean)
    {
      localObject = this.f;
      if (localObject != null) {
        ((TipsManager)localObject).a(this, new Object[0]);
      }
    }
    SmallScreenUtils.a(this.h, paramBoolean, bool);
  }
  
  public int b()
  {
    return 2;
  }
  
  public int[] c()
  {
    return null;
  }
  
  public void d()
  {
    a("showMeetinInvitedInfo", this.e.a, this.e.b, 4, 0L);
  }
  
  public void e()
  {
    a("cancelMeetingInvitedInfo", this.e.a, this.e.b, 4, 0L);
  }
  
  public void f()
  {
    this.d.getAVNotifyCenter().d(true);
    a("doRefreshMultiState", this.e.a, this.e.b, 0, 0L);
  }
  
  void g()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i(this.c, 4, "onClick_multi");
    }
    int i2 = UITools.b(this.e.a);
    long l1 = Long.parseLong(this.e.b);
    Object localObject1 = new HashMap();
    Object localObject2 = this.d.getAVNotifyCenter().f(l1);
    boolean bool2 = false;
    int i1 = 2;
    int n;
    boolean bool1;
    if (localObject2 != null)
    {
      n = ((AVNotifyCenter.VideoRoomInfo)localObject2).d;
      bool1 = bool2;
      if (n == 2)
      {
        bool1 = bool2;
        if (((AVNotifyCenter.VideoRoomInfo)localObject2).f == 2)
        {
          bool1 = bool2;
          if (((AVNotifyCenter.VideoRoomInfo)localObject2).g == 4) {
            bool1 = true;
          }
        }
      }
    }
    else
    {
      n = this.d.getAVNotifyCenter().e(l1);
      bool1 = false;
    }
    this.d.getAVNotifyCenter().c(9, l1, n);
    ((Map)localObject1).put("MultiAVType", String.valueOf(n));
    if (n == 2)
    {
      ((Map)localObject1).put("Fromwhere", "SmallScreen");
      if (!this.d.getAVNotifyCenter().a(this.e.b))
      {
        localObject2 = this.e.b;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("");
        localStringBuilder.append(TroopUtils.a(this.d, this.e.b));
        ReportController.b(null, "dc00899", "Grp_video", "", "notice", "Clk_video", 0, 0, (String)localObject2, localStringBuilder.toString(), "2", "");
      }
    }
    if (this.d.getAVNotifyCenter().a(i2, l1))
    {
      if (this.d.getAVNotifyCenter().m(String.valueOf(l1)) == 14)
      {
        ((Map)localObject1).put("from", "tipBar");
        GroupVideoChatAppInfo.startGroupVideoOrVoice(this.d, this.a, this.e.a, this.e.b, (Map)localObject1);
      }
      else
      {
        ChatActivityUtils.a(this.d, this.a, this.e.a, this.e.b, true, true, null, (Map)localObject1);
      }
    }
    else
    {
      int i3 = this.d.getAVNotifyCenter().g(this.e.b);
      if (i3 != 4) {
        i1 = 1;
      }
      if (QLog.isDevelopLevel())
      {
        localObject1 = this.c;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("onClick_multi, sessionType[");
        ((StringBuilder)localObject2).append(i3);
        ((StringBuilder)localObject2).append("], enterType[");
        ((StringBuilder)localObject2).append(i1);
        ((StringBuilder)localObject2).append("]");
        QLog.i((String)localObject1, 4, ((StringBuilder)localObject2).toString());
      }
      if (!this.d.getAVNotifyCenter().a(this.a, i1, this.e.a, this.e.b)) {
        a(this.d, this.a, this.e.a, this.e.b, n, bool1, null);
      }
      if (this.e.a == 1) {
        if (this.d.getAVNotifyCenter().e(l1) == 10) {
          ReportController.b(null, "CliOper", "", "", "0X8005933", "0X8005933", 0, 0, "", "", "", "");
        } else {
          ReportController.b(null, "CliOper", "", "", "0X80046DA", "0X80046DA", 0, 0, "", "", "", "");
        }
      }
    }
    if (this.e.a == 3000)
    {
      if (this.d.getAVNotifyCenter().a(i2, l1)) {
        localObject1 = "Cover_back";
      } else {
        localObject1 = "Clk_discuss_floating";
      }
      ReportController.b(this.d, "CliOper", "", "", "Multi_call", (String)localObject1, 0, 0, "", "", "", "");
    }
  }
  
  void h()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i(this.c, 4, "onClick_double");
    }
    int i1 = this.d.getAVNotifyCenter().t();
    int n = 1;
    boolean bool;
    if (i1 == 1) {
      bool = true;
    } else {
      bool = false;
    }
    if (this.d.getAVNotifyCenter().i(this.e.b)) {
      if (this.d.getAVNotifyCenter().k(this.e.b) == 1)
      {
        ReportController.b(this.d, "CliOper", "", "", "0X800478D", "0X800478D", 0, 0, "", "", "", "");
        bool = true;
      }
      else
      {
        ReportController.b(this.d, "CliOper", "", "", "0X8004789", "0X8004789", 0, 0, "", "", "", "");
        bool = false;
      }
    }
    if (!bool) {
      n = 2;
    }
    if (this.d.getAVNotifyCenter().a(this.a, n, this.e.a, this.e.b)) {
      return;
    }
    ChatActivityUtils.a(this.d, this.a, this.e.a, this.e.b, this.e.e, null, bool, this.e.c, false, true, null, "from_internal");
    ReportController.b(this.d, "CliOper", "", "", "Two_call", "Two_call_full", 0, 0, "2", "", "", "");
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131438957) {
      if ((this.e.a != 3000) && (this.e.a != 1))
      {
        if (!j()) {
          h();
        }
      }
      else
      {
        long l1 = Long.parseLong(this.e.b);
        boolean bool = this.d.getAVNotifyCenter().a(this.e.b);
        AVNotifyCenter.VideoRoomInfo localVideoRoomInfo = this.d.getAVNotifyCenter().f(l1);
        int n;
        if (localVideoRoomInfo != null) {
          n = localVideoRoomInfo.d;
        } else {
          n = this.d.getAVNotifyCenter().e(l1);
        }
        if (((n == 10) && (!bool)) || (!j())) {
          g();
        }
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.tips.VideoStatusTipsBar
 * JD-Core Version:    0.7.0.1
 */