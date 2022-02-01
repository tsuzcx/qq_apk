package com.tencent.mobileqq.activity;

import ActionMsg.MsgBody;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.SQLException;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.Editable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.biz.pubaccount.api.IPublicAccountDataManager;
import com.tencent.common.config.AppSetting;
import com.tencent.image.ApngImage;
import com.tencent.image.URLDrawable;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.UinTypeUtil;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.history.ChatHistoryC2CAllFragment;
import com.tencent.mobileqq.activity.messagesearch.MessageSearchDialog;
import com.tencent.mobileqq.apollo.utils.api.IApolloMessageUtil;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.MessageRoamManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.SQLiteDatabase;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.ProxyObserver;
import com.tencent.mobileqq.banner.TipsBar;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.emoticonview.EmotionUtils;
import com.tencent.mobileqq.emoticonview.IPicEmoticonInfo;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;
import com.tencent.mobileqq.persistence.qslowtable.QSlowTableManager;
import com.tencent.mobileqq.qqaudio.audioplayer.AudioPlayer;
import com.tencent.mobileqq.qqaudio.audioplayer.AudioPlayerBase.AudioPlayerListener;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.message.remote.MessageRecordInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.transfile.TransfileUtile;
import com.tencent.mobileqq.util.ImageCache;
import com.tencent.mobileqq.util.ImageWorker;
import com.tencent.mobileqq.utils.ActionMsgUtil;
import com.tencent.mobileqq.utils.AudioUtil;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.MessageDBUtils;
import com.tencent.mobileqq.utils.MsgUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.InputMethodUtil;
import com.tencent.util.MqqWeakReferenceHandler;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.XListView;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import localpb.richMsg.MixedMsg.Elem;
import localpb.richMsg.MixedMsg.Msg;
import localpb.richMsg.RichMsg.PicRec;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

public class ChatHistory
  extends IphoneTitleBarActivity
  implements SensorEventListener
{
  protected static Toast u;
  int A;
  final int B = 60;
  TextView C;
  AnimationDrawable D = null;
  AnimationDrawable E = null;
  protected AnimationDrawable F;
  ImageView G;
  ImageView H;
  MessageSearchDialog I;
  long J = 0L;
  protected SessionInfo K;
  protected int L = 999;
  protected boolean M = false;
  ImageWorker N;
  protected EntityManager O;
  protected Object P = new Object();
  QSlowTableManager Q = null;
  boolean R = false;
  int S = 0;
  Handler.Callback T = new ChatHistory.1(this);
  MqqHandler U = new MqqWeakReferenceHandler(this.T);
  QQProgressDialog V;
  protected Handler W = new ChatHistory.2(this);
  ChatHistory.HistoryItemOnlongClickListener X = new ChatHistory.HistoryItemOnlongClickListener(this);
  TipsBar Y;
  View Z;
  final String a = "ChatHistory";
  Dialog aa;
  Dialog ab;
  protected MessageObserver ac = new ChatHistory.23(this);
  protected ProxyObserver ad = new ChatHistory.24(this);
  protected AudioPlayer ae = null;
  protected AudioPlayerBase.AudioPlayerListener af = new ChatHistory.25(this);
  protected SensorManager ag;
  protected Sensor ah;
  protected float ai;
  protected boolean aj;
  protected QQProgressDialog ak;
  protected ChatHistory.PlayingPttHistoryInfo al;
  int am;
  AbsListView.OnScrollListener an = new ChatHistory.26(this);
  protected boolean b = false;
  protected long c;
  protected boolean d = false;
  String e;
  int f;
  public String g;
  public String h;
  protected XListView i;
  ChatHistory.ChatHistoryAdapter j;
  protected Button k;
  protected Button l;
  TextView m;
  protected StringBuffer n = new StringBuffer();
  EditText o;
  TextView p;
  protected int q;
  int r;
  int s = 1;
  int t = 0;
  float v;
  Dialog w;
  int x;
  int y;
  int z;
  
  public static final int a(QQAppInterface paramQQAppInterface, String paramString, int paramInt, StringBuilder paramStringBuilder)
  {
    if (paramQQAppInterface == null) {
      return 0;
    }
    SQLiteDatabase localSQLiteDatabase = paramQQAppInterface.getReadableDatabase();
    if (localSQLiteDatabase == null) {
      return 0;
    }
    if (paramInt == 0)
    {
      paramQQAppInterface = new StringBuilder(" msgtype ");
      paramQQAppInterface.append(UinTypeUtil.a());
      paramQQAppInterface.append(" and isValid=1 ");
      paramQQAppInterface = MessageDBUtils.a(MessageRecord.getOldTableName(paramString, paramInt), MessageRecord.getTableName(paramString, paramInt), localSQLiteDatabase, "", paramQQAppInterface.toString(), "");
    }
    else
    {
      paramQQAppInterface = new StringBuilder(" where msgtype ");
      paramQQAppInterface.append(UinTypeUtil.a());
      paramQQAppInterface.append(" and isValid=1 ");
      paramQQAppInterface = MessageDBUtils.a(MessageRecord.getOldTableName(paramString, paramInt), MessageRecord.getTableName(paramString, paramInt), localSQLiteDatabase, paramQQAppInterface.toString());
    }
    if (paramQQAppInterface == null) {
      return 0;
    }
    paramQQAppInterface = localSQLiteDatabase.rawQuery(paramQQAppInterface.toString(), null);
    if (paramQQAppInterface == null) {
      return 0;
    }
    if ((paramQQAppInterface.getCount() > 0) && (paramStringBuilder != null))
    {
      paramQQAppInterface.moveToLast();
      long l1;
      if (paramInt == 3000) {
        l1 = paramQQAppInterface.getLong(paramQQAppInterface.getColumnIndex("shmsgseq"));
      } else if (paramInt == 0) {
        l1 = paramQQAppInterface.getLong(paramQQAppInterface.getColumnIndex("time"));
      } else if (paramInt == 1) {
        l1 = paramQQAppInterface.getLong(paramQQAppInterface.getColumnIndex("shmsgseq"));
      } else {
        l1 = 0L;
      }
      if (l1 > 0L) {
        paramStringBuilder.append(String.valueOf(l1));
      }
    }
    paramInt = paramQQAppInterface.getCount();
    paramQQAppInterface.close();
    return paramInt;
  }
  
  public static final Object a(View paramView)
  {
    if (paramView == null) {
      return null;
    }
    if ((paramView.getParent() != null) && (!(paramView.getParent() instanceof XListView))) {
      return a((View)paramView.getParent());
    }
    return paramView.getTag();
  }
  
  private void b(MessageRecord paramMessageRecord)
  {
    d(this.app.getMessageFacade().c(this.e, this.f, paramMessageRecord));
  }
  
  public static boolean b(String paramString)
  {
    if ((paramString != null) && (!paramString.trim().equals("")))
    {
      if (paramString.contains("\n")) {
        return false;
      }
      return Pattern.compile("^[*+,./\\\"=_-]+").matcher(paramString.substring(0, 1)).matches() ^ true;
    }
    return false;
  }
  
  private void d(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("recordCount : ");
      ((StringBuilder)localObject).append(paramInt);
      QLog.i("ChatHistory", 2, ((StringBuilder)localObject).toString());
    }
    paramInt += this.S;
    if (paramInt <= 0) {
      return;
    }
    paramInt -= 1;
    int i1 = paramInt / 8 + 1;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("pageIndex = ");
      ((StringBuilder)localObject).append(i1);
      QLog.i("ChatHistory", 2, ((StringBuilder)localObject).toString());
    }
    if (i1 < 0) {
      return;
    }
    this.j.e = (paramInt % 8);
    this.o.setText(String.valueOf(i1));
    Object localObject = this.o;
    ((EditText)localObject).setSelection(((EditText)localObject).getText().length());
  }
  
  protected MsgBody a(int paramInt1, int paramInt2, String paramString, int paramInt3)
  {
    if (((paramInt2 != -1003) && (paramInt2 != -1032) && (paramInt2 != -1031) && (paramInt2 != 201)) || ((paramInt1 != 1001) && (paramInt1 != 10002) && (!ActionMsgUtil.a(paramInt2)) && (paramInt2 != -3001) && (paramInt2 != -30002) && (paramInt2 != -30003)))
    {
      if (paramInt2 == -2009)
      {
        localMsgBody = new MsgBody();
        boolean bool = MessageRecordInfo.c(paramInt3);
        localMsgBody.msg = MsgUtils.a(TransfileUtile.analysisTransFileProtocolData(paramString), this, bool, false);
        localMsgBody.action = null;
        return localMsgBody;
      }
      if (paramInt2 == -2016)
      {
        localMsgBody = new MsgBody();
        localMsgBody.msg = MsgUtils.a(this.app, TransfileUtile.analysisTransFileProtocolData(paramString), this, this.e, null, this.f);
        localMsgBody.action = null;
        return localMsgBody;
      }
      MsgBody localMsgBody = new MsgBody();
      localMsgBody.msg = paramString;
      localMsgBody.action = null;
      return localMsgBody;
    }
    return ActionMsgUtil.a(paramString);
  }
  
  public Cursor a(String paramString1, String paramString2, String paramString3)
  {
    SQLiteDatabase localSQLiteDatabase = this.app.getReadableDatabase();
    StringBuilder localStringBuilder1 = null;
    if (localSQLiteDatabase == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("ChatHistory", 2, "MessageProvide getDB null!");
      }
      return null;
    }
    if (paramString1.indexOf("mr_troop_") != -1)
    {
      localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append(" where ");
      localStringBuilder1.append(paramString3);
      paramString3 = localStringBuilder1.toString();
      paramString2 = MessageDBUtils.b(paramString2, paramString1, localSQLiteDatabase, paramString3);
      if (paramString2 == null) {
        return null;
      }
      paramString2.append(" t left join TroopMemberInfo m on t.senderuin=m.memberuin and t.frienduin=m.troopuin");
    }
    label206:
    label342:
    try
    {
      paramString2 = localSQLiteDatabase.rawQuery(paramString2.toString(), null);
      paramString1 = paramString2;
    }
    catch (SQLException paramString2)
    {
      label115:
      break label115;
    }
    for (paramString1 = localSQLiteDatabase.query(paramString1, null, paramString3, null, null, null);; paramString1 = localSQLiteDatabase.query(paramString1, null, paramString3, null, null, null)) {
      for (;;)
      {
        return paramString1;
        if (paramString1.indexOf("mr_grp_") != -1)
        {
          paramString2 = new StringBuilder("select * from ");
          paramString2.append(paramString1);
          paramString2.append(" t left join GrpMemberInfo m on t.senderuin=m.mId and t.frienduin=m.grpID left join friends l on m.mId =l.uin ");
          if ((paramString3 != null) && (paramString3.length() > 0))
          {
            paramString2.append(" where ");
            paramString2.append(paramString3);
          }
        }
        try
        {
          paramString2 = localSQLiteDatabase.rawQuery(paramString2.toString(), null);
          paramString1 = paramString2;
        }
        catch (SQLException paramString2)
        {
          break label206;
        }
        paramString1 = localSQLiteDatabase.query(paramString1, null, paramString3, null, null, null);
        paramString2 = paramString1;
        if (!QLog.isColorLevel()) {
          break label402;
        }
        paramString2 = new StringBuilder();
        paramString2.append("cursor: ");
        paramString2.append(paramString1);
        QLog.d("gene", 2, paramString2.toString());
        return paramString1;
        if (paramString1.indexOf("mr_discusssion_") == -1) {
          break label357;
        }
        localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append(" where ");
        localStringBuilder1.append(paramString3);
        paramString3 = localStringBuilder1.toString();
        paramString2 = MessageDBUtils.b(paramString2, paramString1, localSQLiteDatabase, paramString3);
        if (paramString2 == null) {
          return null;
        }
        paramString2.append(" t left join DiscussionMemberInfo m on t.senderuin=m.memberUin and t.frienduin=m.discussionUin");
        try
        {
          paramString2 = localSQLiteDatabase.rawQuery(paramString2.toString(), null);
          paramString1 = paramString2;
        }
        catch (SQLException paramString2)
        {
          StringBuilder localStringBuilder2;
          break label342;
        }
      }
    }
    label357:
    localStringBuilder2 = MessageDBUtils.a(paramString2, paramString1, localSQLiteDatabase, paramString3, null);
    paramString2 = localStringBuilder1;
    if (localStringBuilder2 != null) {}
    try
    {
      paramString2 = localSQLiteDatabase.rawQuery(localStringBuilder2.toString(), null);
      return paramString2;
    }
    catch (SQLException paramString2)
    {
      label390:
      break label390;
    }
    paramString2 = localSQLiteDatabase.query(paramString1, null, paramString3, null, null, null);
    label402:
    return paramString2;
  }
  
  protected EntityManager a()
  {
    ??? = this.O;
    if ((??? == null) || (!((EntityManager)???).isOpen())) {}
    synchronized (this.P)
    {
      if ((this.O == null) || (!this.O.isOpen())) {
        this.O = this.app.getEntityManagerFactory().b();
      }
      return this.O;
    }
  }
  
  protected String a(long paramLong)
  {
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("", Locale.SIMPLIFIED_CHINESE);
    localSimpleDateFormat.applyPattern("yyyy-MM-dd HH:mm:ss");
    return localSimpleDateFormat.format(Long.valueOf(paramLong));
  }
  
  protected String a(AbsStructMsg paramAbsStructMsg)
  {
    if ((paramAbsStructMsg != null) && (AbsShareMsg.class.isInstance(paramAbsStructMsg)))
    {
      paramAbsStructMsg = (AbsShareMsg)paramAbsStructMsg;
      StringBuffer localStringBuffer = new StringBuffer();
      if (paramAbsStructMsg.mMsgServiceID == 80)
      {
        localStringBuffer.append("[");
        localStringBuffer.append(paramAbsStructMsg.mSourceName);
        localStringBuffer.append("]");
        localStringBuffer.append(paramAbsStructMsg.mMsgBrief);
        return localStringBuffer.toString();
      }
      if (!TextUtils.isEmpty(paramAbsStructMsg.mMsgBrief))
      {
        localStringBuffer.append(paramAbsStructMsg.mMsgBrief);
      }
      else if (!TextUtils.isEmpty(paramAbsStructMsg.mSourceName))
      {
        localStringBuffer.append(paramAbsStructMsg.mSourceName);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(" ");
        localStringBuilder.append(getString(2131916811));
        localStringBuilder.append(" ");
        localStringBuffer.append(localStringBuilder.toString());
        if (!TextUtils.isEmpty(paramAbsStructMsg.mContentTitle)) {
          localStringBuffer.append(paramAbsStructMsg.mContentTitle);
        }
      }
      return localStringBuffer.toString();
    }
    return null;
  }
  
  void a(int paramInt1, int paramInt2)
  {
    this.q = paramInt1;
    int i1 = 1;
    if (paramInt2 > 0)
    {
      if (paramInt2 < 8) {
        paramInt2 = 1;
      } else if (paramInt2 % 8 == 0) {
        paramInt2 /= 8;
      } else {
        paramInt2 = paramInt2 / 8 + 1;
      }
      if (paramInt1 < 8) {
        paramInt1 = i1;
      } else if (paramInt1 % 8 == 0) {
        paramInt1 /= 8;
      } else {
        paramInt1 = paramInt1 / 8 + 1;
      }
      this.r = (paramInt1 + paramInt2);
      this.S = (paramInt2 * 8);
      this.q += this.S;
      return;
    }
    paramInt1 = this.q;
    if (paramInt1 < 8)
    {
      this.r = 1;
      return;
    }
    if (paramInt1 % 8 == 0) {
      paramInt1 /= 8;
    } else {
      paramInt1 = paramInt1 / 8 + 1;
    }
    this.r = paramInt1;
  }
  
  void a(int paramInt, String paramString)
  {
    QQToast.makeText(this, paramInt, paramString, 0).show(getTitleBarHeight());
  }
  
  void a(int paramInt, boolean paramBoolean)
  {
    ThreadManager.getSubThreadHandler().post(new ChatHistory.8(this, paramBoolean, paramInt));
  }
  
  protected void a(Bundle paramBundle)
  {
    Intent localIntent = AIOUtils.a(new Intent(this, SplashActivity.class), null);
    localIntent.putExtras(new Bundle(paramBundle));
    startActivity(localIntent);
  }
  
  void a(Message paramMessage)
  {
    this.U.sendMessageDelayed(paramMessage, 0L);
  }
  
  protected void a(ImageView paramImageView)
  {
    if (paramImageView != null)
    {
      AnimationDrawable localAnimationDrawable = this.F;
      localAnimationDrawable.setBounds(0, 0, localAnimationDrawable.getMinimumWidth(), this.F.getMinimumHeight());
      paramImageView.setImageDrawable(this.F);
      this.F.stop();
      this.F.start();
    }
  }
  
  protected void a(ImageView paramImageView, IPicEmoticonInfo paramIPicEmoticonInfo)
  {
    if ((paramImageView != null) && (paramIPicEmoticonInfo != null) && (paramIPicEmoticonInfo.isSound()))
    {
      paramIPicEmoticonInfo = paramIPicEmoticonInfo.getLoadingDrawable("fromAIO", true);
      Drawable localDrawable = paramImageView.getDrawable();
      if ((localDrawable instanceof URLDrawable)) {
        EmotionUtils.stopSoundDrawablePlay((URLDrawable)localDrawable);
      }
      paramImageView.setImageDrawable(paramIPicEmoticonInfo);
    }
  }
  
  void a(MessageRecord paramMessageRecord)
  {
    if (QLog.isColorLevel()) {
      if (paramMessageRecord != null)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("startDelMsg is called,mr uniseq is:");
        ((StringBuilder)localObject).append(paramMessageRecord.uniseq);
        ((StringBuilder)localObject).append(",id is:");
        ((StringBuilder)localObject).append(paramMessageRecord.getId());
        QLog.d("Q.msg.delmsg", 2, ((StringBuilder)localObject).toString());
      }
      else
      {
        QLog.d("Q.msg.delmsg", 2, "startDelMsg is called,mr is null");
      }
    }
    Object localObject = (ActionSheet)ActionSheetHelper.b(this, null);
    ((ActionSheet)localObject).setMainTitle(getResources().getString(2131893858));
    ((ActionSheet)localObject).addButton(2131888438, 3);
    ((ActionSheet)localObject).addCancelButton(2131887648);
    ((ActionSheet)localObject).setOnButtonClickListener(new ChatHistory.27(this, paramMessageRecord, (ActionSheet)localObject));
    ((ActionSheet)localObject).show();
  }
  
  void a(String paramString)
  {
    View localView = getLayoutInflater().inflate(2131624707, null);
    int i1 = this.f;
    if (1 == i1)
    {
      ((TextView)localView.findViewById(2131447090)).setText(2131888014);
      localView.findViewById(2131431687).setVisibility(8);
    }
    else if (3000 == i1)
    {
      ((TextView)localView.findViewById(2131447090)).setText(2131888013);
      localView.findViewById(2131431687).setVisibility(8);
    }
    else if ((1001 == i1) || (10002 == i1) || (1000 == i1) || (10004 == i1) || (1020 == i1) || (1004 == i1) || (10010 == i1))
    {
      localView.findViewById(2131431687).setVisibility(8);
    }
    if (!isFinishing())
    {
      this.aa = DialogUtil.a(this, 230).setTitle(getString(2131888454)).setPositiveButton(getString(2131888438), new ChatHistory.16(this, paramString)).setNegativeButton(getString(2131887626), new ChatHistory.15(this)).addView(localView);
      this.aa.show();
    }
  }
  
  @SuppressLint({"NewApi"})
  protected void a(String paramString, int paramInt)
  {
    this.i = ((XListView)findViewById(2131437282));
    d();
    b();
    this.j = new ChatHistory.ChatHistoryAdapter(this, this, null);
    this.i.setAdapter(this.j);
    this.i.setOnScrollListener(this.an);
    this.i.setEdgeEffectEnabled(false);
    if (Build.VERSION.SDK_INT >= 9) {
      this.i.setOverscrollFooter(null);
    }
    this.j.a(paramString, paramInt, this.t);
  }
  
  boolean a(int paramInt)
  {
    if ((paramInt > 0) && (paramInt <= this.r * 8))
    {
      this.d = true;
      paramInt -= 1;
      int i1 = paramInt / 8;
      this.j.e = (paramInt % 8);
      this.o.setText(String.valueOf(i1 + 1));
      EditText localEditText = this.o;
      localEditText.setSelection(localEditText.getText().length());
      return true;
    }
    return false;
  }
  
  protected void b()
  {
    RelativeLayout localRelativeLayout = new RelativeLayout(getActivity());
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
    this.Y = new TipsBar(getActivity());
    this.Y.setBarType(4);
    this.Y.setTipsIcon(getActivity().getResources().getDrawable(2130838283));
    localRelativeLayout.addView(this.Y, localLayoutParams);
    this.i.addHeaderView(localRelativeLayout);
    this.Y.setOnClickListener(new ChatHistory.3(this));
    this.C = this.Y.getTextView();
    this.Y.setVisibility(8);
  }
  
  void b(int paramInt)
  {
    if (paramInt > 0)
    {
      Cursor localCursor = this.j.getCursor();
      if (localCursor != null) {
        localCursor.requery();
      }
    }
    if ((this.f == 0) && (((CheckBox)this.aa.findViewById(2131431687)).isChecked()))
    {
      l();
      this.app.getFileManagerDataCenter().a(this.e, this.f);
    }
  }
  
  protected void b(ImageView paramImageView)
  {
    if (paramImageView != null)
    {
      this.F.stop();
      paramImageView.setImageDrawable(getResources().getDrawable(2130849016));
    }
  }
  
  protected void b(ImageView paramImageView, IPicEmoticonInfo paramIPicEmoticonInfo)
  {
    if ((paramImageView != null) && (paramIPicEmoticonInfo != null) && (paramIPicEmoticonInfo.isSound()))
    {
      paramIPicEmoticonInfo = paramIPicEmoticonInfo.getLoadingDrawable("fromAIO", true);
      if ((paramIPicEmoticonInfo instanceof URLDrawable)) {
        EmotionUtils.startSoundDrawablePlay((URLDrawable)paramIPicEmoticonInfo);
      }
      paramImageView.setImageDrawable(paramIPicEmoticonInfo);
    }
  }
  
  protected void b(String paramString, int paramInt)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    Object localObject1;
    if ((paramInt != 1) && (paramInt != 3000))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("( isValid=1 and msgtype ");
      ((StringBuilder)localObject1).append(UinTypeUtil.a());
      ((StringBuilder)localObject1).append(" ) ORDER BY time asc , longMsgIndex asc");
      localObject1 = ((StringBuilder)localObject1).toString();
      localObject1 = MessageDBUtils.a(MessageRecord.getOldTableName(paramString, paramInt), MessageRecord.getTableName(paramString, paramInt), this.app.getReadableDatabase(), (String)localObject1, null);
    }
    else
    {
      localObject1 = MessageDBUtils.a(MessageRecord.getOldTableName(paramString, paramInt), MessageRecord.getTableName(paramString, paramInt), this.app.getReadableDatabase());
    }
    Cursor localCursor;
    if (localObject1 != null) {
      localCursor = this.app.getReadableDatabase().rawQuery(((StringBuilder)localObject1).toString(), null);
    } else {
      localCursor = null;
    }
    if (paramInt == 1)
    {
      paramString = ContactUtils.a(this.app, paramString, 1);
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(getString(2131917584));
      ((StringBuilder)localObject1).append(":");
      localStringBuffer.append(((StringBuilder)localObject1).toString());
      localStringBuffer.append(paramString);
      localStringBuffer.append("\r\n===========================================\r\n");
    }
    int i2;
    int i1;
    int i3;
    Object localObject2;
    if ((localCursor != null) && (localCursor.moveToFirst()))
    {
      localObject1 = "";
      i2 = localCursor.getInt(localCursor.getColumnIndex("time"));
      paramString = localCursor.getString(localCursor.getColumnIndex("senderuin"));
      i1 = 0;
      if (1 == paramInt)
      {
        if (((TroopManager)this.app.getManager(QQManagerFactory.TROOP_MANAGER)).Z(this.e)) {
          paramString = ContactUtils.b(this.app, this.e, paramString);
        } else {
          paramString = String.format("%s(%s)", new Object[] { ContactUtils.b(this.app, this.e, paramString), paramString });
        }
      }
      else if (3000 == paramInt) {
        paramString = String.format("%s(%s)", new Object[] { ContactUtils.a(this.app, paramString, 0), paramString });
      } else {
        paramString = this.g;
      }
      i3 = localCursor.getInt(localCursor.getColumnIndex("issend"));
      localObject2 = paramString;
      if (MessageRecordInfo.b(i3)) {
        localObject2 = e();
      }
      if ((localCursor.getColumnIndex("versionCode") >= 0) && (localCursor.getInt(localCursor.getColumnIndex("versionCode")) > 0))
      {
        int i4 = localCursor.getInt(localCursor.getColumnIndex("msgtype"));
        if (i4 == -2007)
        {
          paramString = getString(2131888889);
          break label1062;
        }
        if (i4 == -2058)
        {
          paramString = getString(2131916786);
          break label1062;
        }
        if (i4 == -8018)
        {
          paramString = getString(2131886651);
          break label1062;
        }
        if (i4 == -2039)
        {
          paramString = localCursor.getBlob(localCursor.getColumnIndex("msgData"));
          paramString = ((IApolloMessageUtil)QRoute.api(IApolloMessageUtil.class)).getApolloDescMsg(paramString);
          break label1062;
        }
        if (i4 == -2011)
        {
          paramString = a(StructMsgFactory.a(localCursor.getBlob(localCursor.getColumnIndex("msgData"))));
          break label1062;
        }
        if (i4 == -2020)
        {
          if (MessageRecordInfo.b(i3))
          {
            paramString = this.app.getApp().getString(2131916395, new Object[] { this.K.e });
            break label1062;
          }
          paramString = this.app.getApp().getString(2131916394);
          break label1062;
        }
        if (i4 == -2006)
        {
          paramString = (String)localObject1;
          break label1367;
        }
        if (i4 == -2000)
        {
          paramString = HardCodeUtil.a(2131899831);
          break label1062;
        }
        if (i4 == -2002)
        {
          paramString = HardCodeUtil.a(2131899819);
          break label1062;
        }
        if (i4 == -2022)
        {
          paramString = HardCodeUtil.a(2131899829);
          break label1062;
        }
        if (i4 == -2071)
        {
          paramString = getString(2131888234);
          break label1062;
        }
        if (i4 == -7001)
        {
          paramString = getString(2131891967);
          break label1062;
        }
        if (i4 == -1035) {
          paramString = new StringBuilder();
        }
      }
    }
    try
    {
      byte[] arrayOfByte = localCursor.getBlob(localCursor.getColumnIndex("msgData"));
      localObject1 = new MixedMsg.Msg();
      try
      {
        ((MixedMsg.Msg)localObject1).mergeFrom(arrayOfByte);
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
      {
        localInvalidProtocolBufferMicroException.printStackTrace();
      }
      if (((MixedMsg.Msg)localObject1).elems.get().size() <= 0)
      {
        if (localCursor == null) {
          break label1434;
        }
        localCursor.close();
        return;
      }
      i3 = ((MixedMsg.Msg)localObject1).elems.get().size();
      while (i1 < i3)
      {
        localObject3 = (MixedMsg.Elem)((MixedMsg.Msg)localObject1).elems.get().get(i1);
        if (((MixedMsg.Elem)localObject3).textMsg.has()) {
          paramString.append(((MixedMsg.Elem)localObject3).textMsg.get());
        } else if (((MixedMsg.Elem)localObject3).picMsg.has()) {
          paramString.append("[图片]");
        }
        i1 += 1;
      }
    }
    catch (Exception localException1)
    {
      Object localObject3;
      label979:
      break label979;
    }
    if (QLog.isColorLevel()) {
      QLog.i("ChatHistory", 2, "Parse mix message error");
    }
    paramString = paramString.toString();
    break label1062;
    try
    {
      paramString = new String(localCursor.getBlob(localCursor.getColumnIndex("msgData")), "UTF-8");
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      paramString = (String)localObject1;
    }
    paramString = localCursor.getString(localCursor.getColumnIndex("msg"));
    label1062:
    if (paramString != null) {
      localObject1 = new QQText(paramString, 3).toPlainText();
    } else {
      localObject1 = null;
    }
    localObject3 = localObject1;
    if (localObject1 != null)
    {
      localObject3 = localObject1;
      if (((String)localObject1).length() > 0)
      {
        localObject3 = localObject1;
        if (c((String)localObject1))
        {
          localObject3 = localObject1.split("\026")[1].split("\\|");
          try
          {
            if (localObject3.length < 2) {
              i1 = 1;
            } else {
              i1 = Integer.valueOf(localObject3[2]).intValue();
            }
          }
          catch (Exception localException2)
          {
            label1164:
            QLog.d("ChatHistory", 1, "", localException2);
            localObject4 = localObject1;
          }
          localObject3 = localObject1;
          if (i1 == 2)
          {
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("[");
            ((StringBuilder)localObject3).append(getString(2131917347));
            ((StringBuilder)localObject3).append("]");
            localObject3 = ((StringBuilder)localObject3).toString();
            localObject1 = localObject3;
          }
        }
      }
    }
    for (;;)
    {
      localObject3 = getString(2131915898);
      localObject1 = localObject3;
      localObject3 = localObject1;
      Object localObject4;
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(a(i2 * 1000L));
      ((StringBuilder)localObject1).append("  ");
      ((StringBuilder)localObject1).append((String)localObject2);
      ((StringBuilder)localObject1).append("\r\n");
      ((StringBuilder)localObject1).append(localObject4);
      localObject1 = ((StringBuilder)localObject1).toString();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append("\r\n\r\n");
      localStringBuffer.append(((StringBuilder)localObject2).toString());
      label1367:
      if (localCursor.moveToNext())
      {
        localObject1 = paramString;
        break;
      }
      if (localCursor != null) {
        localCursor.close();
      }
      runOnUiThread(new ChatHistory.21(this, FileUtils.writeFile(AppConstants.SDCARD_PATH_CHATRECORD, this.n.toString(), localStringBuffer.toString())));
      return;
      label1434:
      return;
      if (i1 != 1) {
        if (i1 != 65538) {
          break label1164;
        }
      }
    }
  }
  
  void c()
  {
    View localView1 = findViewById(2131447593);
    View localView2 = findViewById(2131445137);
    int i1 = localView1.getHeight();
    this.I = new MessageSearchDialog(this, this.app, this.K);
    float f1 = -i1;
    TranslateAnimation localTranslateAnimation1 = new TranslateAnimation(0.0F, 0.0F, 0.0F, f1);
    localTranslateAnimation1.setDuration(200L);
    localTranslateAnimation1.setFillAfter(true);
    TranslateAnimation localTranslateAnimation2 = new TranslateAnimation(0.0F, 0.0F, f1, 0.0F);
    localTranslateAnimation2.setDuration(200L);
    localTranslateAnimation1.setAnimationListener(new ChatHistory.4(this, localView2, localView1));
    localTranslateAnimation2.setAnimationListener(new ChatHistory.5(this, localView2, i1));
    this.I.setOnDismissListener(new ChatHistory.6(this, localView2, i1, localView1, localTranslateAnimation2));
    localView2.startAnimation(localTranslateAnimation1);
  }
  
  void c(int paramInt)
  {
    QQToast.makeText(getActivity(), paramInt, 0).show(getResources().getDimensionPixelSize(2131299920));
  }
  
  boolean c(String paramString)
  {
    if (paramString.charAt(0) == '\026')
    {
      paramString = paramString.split("\026")[1].split("\\|");
      if (paramString.length < 2) {
        return true;
      }
      if (paramString.length <= 3) {}
    }
    try
    {
      Long.valueOf(paramString[1]);
      Integer.valueOf(paramString[2]);
      Boolean.valueOf(paramString[3]);
      return true;
    }
    catch (NumberFormatException paramString) {}
    return false;
    return false;
  }
  
  void d()
  {
    if (this.b) {
      return;
    }
    this.Z = ((RelativeLayout)View.inflate(this, 2131629215, null));
    int i1 = (int)DisplayUtils.a(this, 6.0F);
    Object localObject = new RelativeLayout(this);
    ((RelativeLayout)localObject).setPadding(0, i1, 0, i1);
    ((RelativeLayout)localObject).setBackgroundResource(2130852485);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, getResources().getDimensionPixelSize(2131299611));
    ((RelativeLayout)localObject).addView(this.Z, localLayoutParams);
    this.i.addHeaderView((View)localObject);
    this.Z.findViewById(2131429816).setVisibility(8);
    localObject = (EditText)this.Z.findViewById(2131432634);
    ((EditText)localObject).setFocusableInTouchMode(false);
    ((EditText)localObject).setCursorVisible(false);
    ((EditText)localObject).setOnClickListener(new ChatHistory.7(this));
    setLayerType(this.Z);
  }
  
  void d(String paramString)
  {
    Toast localToast = u;
    if (localToast == null) {
      u = Toast.makeText(this, paramString, 0);
    } else {
      localToast.setText(paramString);
    }
    u.show();
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 != 21)
    {
      if (paramInt1 != 200) {
        return;
      }
      this.j.getCursor().requery();
      return;
    }
    if (-1 == paramInt2) {
      a(paramIntent.getExtras());
    }
  }
  
  @TargetApi(14)
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    addObserver(this.ac);
    this.v = getResources().getDisplayMetrics().density;
    this.D = ((AnimationDrawable)getResources().getDrawable(2130772493));
    this.E = ((AnimationDrawable)getResources().getDrawable(2130772494));
    this.F = ((AnimationDrawable)getResources().getDrawable(2130772400));
    paramBundle = getIntent().getExtras();
    this.e = paramBundle.getString("uin");
    this.f = paramBundle.getInt("uintype");
    this.K = new SessionInfo();
    Object localObject = this.K;
    ((SessionInfo)localObject).b = this.e;
    ((SessionInfo)localObject).a = this.f;
    ((SessionInfo)localObject).e = this.g;
    ((SessionInfo)localObject).c = paramBundle.getString("troop_uin");
    setContentViewNoTitle(2131624471);
    localObject = (LinearLayout)findViewById(2131445137);
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      ((LinearLayout)localObject).setFitsSystemWindows(true);
      ((LinearLayout)localObject).setPadding(0, ImmersiveUtils.getStatusBarHeight(this), 0, 0);
    }
    boolean bool = paramBundle.getBoolean("from_RecentSaidActivity", false);
    this.b = bool;
    if (bool) {
      this.c = paramBundle.getLong("target_shmsgseq");
    }
    init(getIntent());
    this.app.setHandler(getClass(), this.U);
    this.Q = ((QSlowTableManager)this.app.getManager(QQManagerFactory.SLOW_TABLE_MANAGER));
    a(9, false);
    o();
    a(this.e, this.f);
    s();
    if (this.app.getProxyManager() != null) {
      this.app.getProxyManager().addProxyObserver(this.ad);
    }
    this.app.getProxyManager().saveNotify();
    this.N = new ImageWorker(this);
    paramBundle = this.N;
    float f1 = this.v;
    paramBundle.a((int)(150.0F * f1), (int)(f1 * 100.0F));
    u();
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    Object localObject = this.j;
    if (localObject != null) {
      ((ChatHistory.ChatHistoryAdapter)localObject).a();
    }
    localObject = this.ag;
    if (localObject != null) {
      ((SensorManager)localObject).unregisterListener(this);
    }
    localObject = this.O;
    if ((localObject != null) && (((EntityManager)localObject).isOpen()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ChatHistory", 2, "ChatHistory : close entityManager.");
      }
      this.O.close();
      this.O = null;
    }
    p();
    t();
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onDestroy() mCurPlayingPttInfo = ");
      ((StringBuilder)localObject).append(this.al);
      QLog.i("ChatHistory", 2, ((StringBuilder)localObject).toString());
    }
    localObject = this.al;
    if ((localObject != null) && (!((ChatHistory.PlayingPttHistoryInfo)localObject).d))
    {
      this.al.d();
      this.D.stop();
      this.D = null;
      this.E.stop();
      this.E = null;
      this.F.stop();
      this.F = null;
    }
    this.U.removeCallbacksAndMessages(null);
    this.app.removeHandler(getClass());
    removeObserver(this.ac);
    if (this.app.getProxyManager() != null) {
      this.app.getProxyManager().removeProxyObserver(this.ad);
    }
    this.app.getProxyManager().saveNotify();
    try
    {
      this.N.a().a();
      label253:
      findViewById(2131445137).clearAnimation();
      return;
    }
    catch (Exception localException)
    {
      break label253;
    }
  }
  
  protected void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    paramIntent = ChatHistoryC2CAllFragment.a(paramIntent);
    if (paramIntent != null) {
      b(paramIntent);
    }
  }
  
  protected void doOnPause()
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onPause() mCurPlayingPttInfo = ");
      ((StringBuilder)localObject).append(this.al);
      QLog.i("ChatHistory", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.al;
    if ((localObject != null) && (!((ChatHistory.PlayingPttHistoryInfo)localObject).d)) {
      this.al.d();
    }
    ApngImage.pauseByTag(0);
    ApngImage.pauseAll();
    super.doOnPause();
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    ApngImage.playByTag(0);
    ApngImage.resumeAll();
    if ((this.b) && (!this.d))
    {
      MqqHandler localMqqHandler = this.U;
      if (localMqqHandler != null)
      {
        this.d = true;
        localMqqHandler.postDelayed(new ChatHistory.22(this), 300L);
      }
    }
  }
  
  protected String e()
  {
    String str = ContactUtils.f(this.app, this.app.getCurrentAccountUin());
    if ((str != null) && (!str.trim().equals(""))) {
      return str;
    }
    return this.app.getCurrentAccountUin();
  }
  
  protected boolean e(String paramString)
  {
    q();
    MediaPlayerManager.a(this.app).a(true);
    if (this.ae == null) {
      this.ae = new AudioPlayer(this, this.af);
    }
    this.ae.a(3);
    boolean bool = this.ae.a(paramString);
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("playSource|bRet = ");
      paramString.append(bool);
      QLog.i("ChatHistory", 2, paramString.toString());
    }
    if (bool)
    {
      paramString = this.ah;
      if (paramString != null) {
        this.ag.registerListener(this, paramString, 2);
      }
    }
    return bool;
  }
  
  protected void f()
  {
    this.G = ((ImageView)findViewById(2131435394));
    this.H = ((ImageView)findViewById(2131435395));
    this.G.setContentDescription(getString(2131887733));
    this.H.setContentDescription(getString(2131887732));
    this.G.setOnClickListener(new ChatHistory.9(this));
    this.H.setOnClickListener(new ChatHistory.10(this));
    this.H.setEnabled(false);
    this.H.setImageResource(2130851647);
    if (this.r == 1)
    {
      this.G.setEnabled(false);
      this.G.setImageResource(2130841331);
    }
    this.p = ((TextView)findViewById(2131447098));
    this.p.setText(String.valueOf(this.r));
    this.o = ((EditText)findViewById(2131432319));
    this.o.setText(String.valueOf(this.s));
    Object localObject = this.o;
    ((EditText)localObject).setSelection(((EditText)localObject).getText().toString().length());
    this.o.addTextChangedListener(new ChatHistory.11(this));
    this.k = ((Button)findViewById(2131430126));
    this.k.setOnClickListener(new ChatHistory.12(this));
    this.l = ((Button)findViewById(2131430125));
    this.l.setOnClickListener(new ChatHistory.13(this));
    if (this.b)
    {
      this.k.setVisibility(8);
      this.l.setVisibility(8);
    }
    int i1 = this.f;
    if ((i1 != 1001) && (i1 != 10002) && (i1 != 10004) && (i1 != 1000) && (i1 != 1020) && (i1 != 1005) && (i1 != 1004) && (i1 != 1009) && (i1 != 1010) && (i1 != 1023) && (i1 != 1024) && (i1 != 10010))
    {
      if ((i1 != 1) && (i1 != 3000))
      {
        localObject = (FriendsManager)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER);
        if ((localObject == null) || (!((FriendsManager)localObject).n(String.valueOf(this.e))))
        {
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("--mSyncHistory button: fm is null or the uin is not my friend: fm:");
            localStringBuilder.append(localObject);
            QLog.e("ChatHistory", 2, localStringBuilder.toString());
          }
          this.m.setVisibility(4);
        }
      }
    }
    else {
      this.m.setVisibility(4);
    }
    this.m.setOnClickListener(new ChatHistory.14(this));
  }
  
  protected void f(String paramString)
  {
    if (this.ak == null) {
      this.ak = new QQProgressDialog(this, getTitleBarHeight());
    }
    this.ak.setCancelable(true);
    this.ak.a(paramString);
    this.ak.show();
  }
  
  public void finish()
  {
    super.finish();
  }
  
  void g()
  {
    h();
    this.o.setText(String.valueOf(this.s));
    EditText localEditText = this.o;
    localEditText.setSelection(localEditText.getText().length());
    this.p.setText(String.valueOf(this.r));
    this.j.a(this.e, this.f, this.t);
  }
  
  protected void h()
  {
    this.s = this.r;
    this.t = ((this.s - 1) * 8);
  }
  
  void i()
  {
    if (getActivity() != null)
    {
      if (getActivity().isFinishing()) {
        return;
      }
      int i1 = this.s;
      int i2 = this.r;
      if (i1 > i2)
      {
        this.s = i2;
        this.t = ((this.s - 1) * 8);
      }
      this.o.setText(String.valueOf(this.s));
      EditText localEditText = this.o;
      localEditText.setSelection(localEditText.getText().length());
      this.p.setText(String.valueOf(this.r));
      this.j.a(this.e, this.f, this.t);
    }
  }
  
  void j()
  {
    this.U.obtainMessage(4, getResources().getString(2131916807)).sendToTarget();
    this.app.getMsgHandler().a((short)1, (byte)1);
  }
  
  void k()
  {
    MessageRoamManager localMessageRoamManager = (MessageRoamManager)this.app.getManager(QQManagerFactory.MESSAGE_ROAM_MANAGER);
    if (localMessageRoamManager != null)
    {
      long l1 = NetConnInfoCenter.getServerTime();
      this.app.getMsgHandler().a(this.e, l1 - 604800L, 0L, l1, (short)0, 0L, 1, null, localMessageRoamManager.z(), false, 0, false);
    }
  }
  
  protected void l()
  {
    if (!NetworkUtil.isNetSupport(this.app.getApplication().getApplicationContext()))
    {
      QQToast.makeText(getApplicationContext(), 2131888455, 1).show();
      return;
    }
    f(getApplication().getResources().getString(2131888456));
    this.app.getMsgHandler().h(this.e);
  }
  
  void m()
  {
    this.n.setLength(0);
    if (this.g.compareTo(this.e) == 0) {
      localObject1 = this.g;
    } else {
      localObject1 = String.format("%s(%s)", new Object[] { this.g, this.e });
    }
    if (b((String)localObject1))
    {
      localObject1 = ((String)localObject1).replaceAll("[\\\\/:*?\"<>|]", "");
      localObject2 = this.n;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject1);
      localStringBuilder.append(".txt");
      ((StringBuffer)localObject2).append(localStringBuilder.toString());
    }
    else
    {
      localObject1 = this.n;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(this.e);
      ((StringBuilder)localObject2).append(".txt");
      ((StringBuffer)localObject1).append(((StringBuilder)localObject2).toString());
    }
    boolean bool = FileUtils.justOnExistFileAndAddSuffix(AppConstants.SDCARD_PATH_CHATRECORD, this.n, ".txt");
    Object localObject1 = getString(2131888018);
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(getString(2131888018));
    ((StringBuilder)localObject2).append(AppConstants.SDCARD_PATH_CHATRECORD);
    ((StringBuilder)localObject2).append(this.n.toString());
    this.ab = DialogUtil.a(this, 230, (String)localObject1, ((StringBuilder)localObject2).toString(), new ChatHistory.17(this), new ChatHistory.18(this));
    if (bool)
    {
      this.ab.show();
      return;
    }
    d(getString(2131889070));
  }
  
  void n()
  {
    this.ab = DialogUtil.a(this, 230, getString(2131916808), getString(2131917245), new ChatHistory.19(this), new ChatHistory.20(this));
    this.ab.show();
  }
  
  protected void o()
  {
    String str2 = getResources().getString(2131887723);
    int i1 = this.f;
    String str1;
    if (i1 == 0)
    {
      if (this.e.equals(String.valueOf(AppConstants.SYSTEM_MSG_UIN))) {
        this.g = getResources().getString(2131916963);
      } else {
        this.g = ContactUtils.a(this.app, this.K.b, this.K.c, ContactUtils.c(this.K.a), 3);
      }
      str1 = str2;
      if (this.e.equals(String.valueOf(AppConstants.SYSTEM_MSG_UIN))) {
        str1 = getResources().getString(2131916963);
      }
    }
    else if (i1 == 1)
    {
      this.g = ((TroopManager)this.app.getManager(QQManagerFactory.TROOP_MANAGER)).i(this.e);
      str1 = str2;
    }
    else if ((i1 != 1000) && (i1 != 1020) && (i1 != 1001) && (i1 != 10002) && (i1 != 10004) && (i1 != 1004) && (i1 != 10010))
    {
      if (i1 == 3000)
      {
        this.g = ContactUtils.a(this.app, this.e);
        str1 = str2;
      }
      else
      {
        str1 = str2;
        if (i1 == 1024)
        {
          PublicAccountInfo localPublicAccountInfo = (PublicAccountInfo)((IPublicAccountDataManager)this.app.getRuntimeService(IPublicAccountDataManager.class, "all")).findPublicAccountInfo(this.e);
          str1 = str2;
          if (localPublicAccountInfo != null)
          {
            this.g = localPublicAccountInfo.name;
            str1 = str2;
          }
        }
      }
    }
    else
    {
      this.g = ContactUtils.c(this.app, this.e);
      str1 = str2;
    }
    str2 = this.g;
    if ((str2 == null) || (str2.trim().equals(""))) {
      this.g = this.e;
    }
    setTitle(str1);
    this.h = e();
    this.K.e = this.g;
    this.leftView = ((TextView)findViewById(2131436180));
  }
  
  public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  protected boolean onBackEvent()
  {
    try
    {
      if (this.o != null) {
        InputMethodUtil.b(this.o);
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    setResult(-1);
    MessageSearchDialog localMessageSearchDialog = this.I;
    if ((localMessageSearchDialog != null) && (localMessageSearchDialog.f()))
    {
      this.I.show();
      this.I.a(false);
      return true;
    }
    return super.onBackEvent();
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  protected View onCreateRightView()
  {
    super.onCreateRightView();
    TextView localTextView = this.rightViewText;
    int i1 = this.f;
    if ((3000 != i1) && (1 != i1)) {
      this.rightViewText.setVisibility(0);
    } else {
      this.rightViewText.setVisibility(8);
    }
    localTextView.setText(2131915847);
    this.m = localTextView;
    return localTextView;
  }
  
  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    if (DeviceInfoUtil.W()) {
      return;
    }
    paramSensorEvent = paramSensorEvent.values;
    boolean bool = false;
    if (paramSensorEvent[0] < this.ai) {
      bool = true;
    }
    if (this.aj != bool)
    {
      this.aj = bool;
      paramSensorEvent = this.ae;
      if (paramSensorEvent != null) {
        paramSensorEvent.a(this.aj ^ true);
      }
      if (!AppSetting.e)
      {
        int i1;
        if (this.aj) {
          i1 = 2131916796;
        } else {
          i1 = 2131916798;
        }
        c(i1);
      }
    }
  }
  
  protected void p()
  {
    Toast localToast = u;
    if (localToast != null)
    {
      localToast.cancel();
      u = null;
    }
  }
  
  protected void q()
  {
    Object localObject = this.ae;
    if ((localObject != null) && (((AudioPlayer)localObject).m()))
    {
      this.ae.d();
      this.ae = null;
    }
    localObject = this.ag;
    if (localObject != null) {
      ((SensorManager)localObject).unregisterListener(this);
    }
    setVolumeControlStream(3);
  }
  
  void r()
  {
    AudioUtil.b(2131230803, false);
  }
  
  protected void s()
  {
    this.ag = ((SensorManager)this.app.getApplication().getSystemService("sensor"));
    this.ah = this.ag.getDefaultSensor(8);
    Sensor localSensor = this.ah;
    if (localSensor != null)
    {
      this.ai = localSensor.getMaximumRange();
      float f2 = this.ai;
      float f1 = f2;
      if (f2 > 10.0F) {
        f1 = 10.0F;
      }
      this.ai = f1;
    }
  }
  
  void t()
  {
    try
    {
      if (this.ak != null)
      {
        this.ak.dismiss();
        this.ak.cancel();
        this.ak = null;
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  protected void u()
  {
    Object localObject = this.K;
    if (localObject != null)
    {
      int i1 = ((SessionInfo)localObject).a;
      if (i1 != 0)
      {
        if (i1 != 1)
        {
          if (i1 == 3000) {
            this.L = 2;
          }
        }
        else {
          this.L = 3;
        }
      }
      else {
        this.L = 0;
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("AIO_chatlog arg:");
        ((StringBuilder)localObject).append(this.L);
        QLog.d("ChatHistory", 2, ((StringBuilder)localObject).toString());
      }
      localObject = this.app;
      i1 = this.L;
      ReportController.b((AppRuntime)localObject, "CliOper", "", "", "AIO", "AIO_chatlog", i1, 0, String.valueOf(i1), "", "", "");
    }
  }
  
  public void v()
  {
    if (this.M) {
      return;
    }
    this.M = true;
    ReportController.b(this.app, "CliOper", "", "", "0X8005690", "0X8005690", this.L, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatHistory
 * JD-Core Version:    0.7.0.1
 */