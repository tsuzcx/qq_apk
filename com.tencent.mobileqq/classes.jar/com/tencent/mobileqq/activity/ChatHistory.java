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
  protected static Toast a;
  float jdField_a_of_type_Float;
  int jdField_a_of_type_Int;
  protected long a;
  Dialog jdField_a_of_type_AndroidAppDialog;
  AnimationDrawable jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable = null;
  protected Sensor a;
  protected SensorManager a;
  Handler.Callback jdField_a_of_type_AndroidOsHandler$Callback = new ChatHistory.1(this);
  protected Handler a;
  View jdField_a_of_type_AndroidViewView;
  protected Button a;
  EditText jdField_a_of_type_AndroidWidgetEditText;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  ChatHistory.ChatHistoryAdapter jdField_a_of_type_ComTencentMobileqqActivityChatHistory$ChatHistoryAdapter;
  ChatHistory.HistoryItemOnlongClickListener jdField_a_of_type_ComTencentMobileqqActivityChatHistory$HistoryItemOnlongClickListener = new ChatHistory.HistoryItemOnlongClickListener(this);
  protected ChatHistory.PlayingPttHistoryInfo a;
  protected SessionInfo a;
  MessageSearchDialog jdField_a_of_type_ComTencentMobileqqActivityMessagesearchMessageSearchDialog;
  protected MessageObserver a;
  protected ProxyObserver a;
  TipsBar jdField_a_of_type_ComTencentMobileqqBannerTipsBar;
  protected EntityManager a;
  QSlowTableManager jdField_a_of_type_ComTencentMobileqqPersistenceQslowtableQSlowTableManager = null;
  protected AudioPlayer a;
  protected AudioPlayerBase.AudioPlayerListener a;
  ImageWorker jdField_a_of_type_ComTencentMobileqqUtilImageWorker;
  QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  AbsListView.OnScrollListener jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener = new ChatHistory.26(this);
  protected XListView a;
  protected Object a;
  final String jdField_a_of_type_JavaLangString = "ChatHistory";
  protected StringBuffer a;
  MqqHandler jdField_a_of_type_MqqOsMqqHandler = new MqqWeakReferenceHandler(this.jdField_a_of_type_AndroidOsHandler$Callback);
  protected boolean a;
  protected float b;
  protected int b;
  long jdField_b_of_type_Long = 0L;
  Dialog jdField_b_of_type_AndroidAppDialog;
  AnimationDrawable jdField_b_of_type_AndroidGraphicsDrawableAnimationDrawable = null;
  protected Button b;
  ImageView jdField_b_of_type_AndroidWidgetImageView;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  protected QQProgressDialog b;
  String jdField_b_of_type_JavaLangString;
  protected boolean b;
  int jdField_c_of_type_Int;
  Dialog jdField_c_of_type_AndroidAppDialog;
  protected AnimationDrawable c;
  TextView jdField_c_of_type_AndroidWidgetTextView;
  public String c;
  protected boolean c;
  int jdField_d_of_type_Int = 1;
  public String d;
  boolean jdField_d_of_type_Boolean = false;
  int e;
  protected boolean e;
  int f;
  int g;
  int h;
  int i;
  final int j = 60;
  protected int k = 999;
  int l = 0;
  int m;
  
  public ChatHistory()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_JavaLangStringBuffer = new StringBuffer();
    this.jdField_e_of_type_Int = 0;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_JavaLangObject = new Object();
    this.jdField_a_of_type_AndroidOsHandler = new ChatHistory.2(this);
    this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver = new ChatHistory.23(this);
    this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyObserver = new ChatHistory.24(this);
    this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerAudioPlayer = null;
    this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerAudioPlayerBase$AudioPlayerListener = new ChatHistory.25(this);
  }
  
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
  
  public static boolean a(String paramString)
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
  
  private void b(MessageRecord paramMessageRecord)
  {
    c(this.app.getMessageFacade().a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Int, paramMessageRecord));
  }
  
  private void c(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("recordCount : ");
      ((StringBuilder)localObject).append(paramInt);
      QLog.i("ChatHistory", 2, ((StringBuilder)localObject).toString());
    }
    paramInt += this.l;
    if (paramInt <= 0) {
      return;
    }
    paramInt -= 1;
    int n = paramInt / 8 + 1;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("pageIndex = ");
      ((StringBuilder)localObject).append(n);
      QLog.i("ChatHistory", 2, ((StringBuilder)localObject).toString());
    }
    if (n < 0) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$ChatHistoryAdapter.jdField_c_of_type_Int = (paramInt % 8);
    this.jdField_a_of_type_AndroidWidgetEditText.setText(String.valueOf(n));
    Object localObject = this.jdField_a_of_type_AndroidWidgetEditText;
    ((EditText)localObject).setSelection(((EditText)localObject).getText().length());
  }
  
  protected MsgBody a(int paramInt1, int paramInt2, String paramString, int paramInt3)
  {
    if (((paramInt2 != -1003) && (paramInt2 != -1032) && (paramInt2 != -1031) && (paramInt2 != 201)) || ((paramInt1 != 1001) && (paramInt1 != 10002) && (!ActionMsgUtil.a(paramInt2)) && (paramInt2 != -3001) && (paramInt2 != -30002) && (paramInt2 != -30003)))
    {
      if (paramInt2 == -2009)
      {
        localMsgBody = new MsgBody();
        boolean bool = MessageRecordInfo.b(paramInt3);
        localMsgBody.msg = MsgUtils.a(TransfileUtile.analysisTransFileProtocolData(paramString), this, bool, false);
        localMsgBody.action = null;
        return localMsgBody;
      }
      if (paramInt2 == -2016)
      {
        localMsgBody = new MsgBody();
        localMsgBody.msg = MsgUtils.a(this.app, TransfileUtile.analysisTransFileProtocolData(paramString), this, this.jdField_b_of_type_JavaLangString, null, this.jdField_a_of_type_Int);
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
    ??? = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager;
    if ((??? == null) || (!((EntityManager)???).isOpen())) {}
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager == null) || (!this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.isOpen())) {
        this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = this.app.getEntityManagerFactory().a();
      }
      return this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager;
    }
  }
  
  protected String a()
  {
    String str = ContactUtils.e(this.app, this.app.getCurrentAccountUin());
    if ((str != null) && (!str.trim().equals(""))) {
      return str;
    }
    return this.app.getCurrentAccountUin();
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
        localStringBuilder.append(getString(2131719259));
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
  
  protected void a()
  {
    RelativeLayout localRelativeLayout = new RelativeLayout(getActivity());
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
    this.jdField_a_of_type_ComTencentMobileqqBannerTipsBar = new TipsBar(getActivity());
    this.jdField_a_of_type_ComTencentMobileqqBannerTipsBar.setBarType(4);
    this.jdField_a_of_type_ComTencentMobileqqBannerTipsBar.setTipsIcon(getActivity().getResources().getDrawable(2130838218));
    localRelativeLayout.addView(this.jdField_a_of_type_ComTencentMobileqqBannerTipsBar, localLayoutParams);
    this.jdField_a_of_type_ComTencentWidgetXListView.addHeaderView(localRelativeLayout);
    this.jdField_a_of_type_ComTencentMobileqqBannerTipsBar.setOnClickListener(new ChatHistory.3(this));
    this.jdField_c_of_type_AndroidWidgetTextView = this.jdField_a_of_type_ComTencentMobileqqBannerTipsBar.a();
    this.jdField_a_of_type_ComTencentMobileqqBannerTipsBar.setVisibility(8);
  }
  
  void a(int paramInt)
  {
    if (paramInt > 0)
    {
      Cursor localCursor = this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$ChatHistoryAdapter.getCursor();
      if (localCursor != null) {
        localCursor.requery();
      }
    }
    if ((this.jdField_a_of_type_Int == 0) && (((CheckBox)this.jdField_b_of_type_AndroidAppDialog.findViewById(2131365472)).isChecked()))
    {
      j();
      this.app.getFileManagerDataCenter().a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Int);
    }
  }
  
  void a(int paramInt1, int paramInt2)
  {
    this.jdField_b_of_type_Int = paramInt1;
    int n = 1;
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
        paramInt1 = n;
      } else if (paramInt1 % 8 == 0) {
        paramInt1 /= 8;
      } else {
        paramInt1 = paramInt1 / 8 + 1;
      }
      this.jdField_c_of_type_Int = (paramInt1 + paramInt2);
      this.l = (paramInt2 * 8);
      this.jdField_b_of_type_Int += this.l;
      return;
    }
    paramInt1 = this.jdField_b_of_type_Int;
    if (paramInt1 < 8)
    {
      this.jdField_c_of_type_Int = 1;
      return;
    }
    if (paramInt1 % 8 == 0) {
      paramInt1 /= 8;
    } else {
      paramInt1 = paramInt1 / 8 + 1;
    }
    this.jdField_c_of_type_Int = paramInt1;
  }
  
  void a(int paramInt, String paramString)
  {
    QQToast.a(this, paramInt, paramString, 0).b(getTitleBarHeight());
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
    this.jdField_a_of_type_MqqOsMqqHandler.sendMessageDelayed(paramMessage, 0L);
  }
  
  protected void a(ImageView paramImageView)
  {
    if (paramImageView != null)
    {
      AnimationDrawable localAnimationDrawable = this.jdField_c_of_type_AndroidGraphicsDrawableAnimationDrawable;
      localAnimationDrawable.setBounds(0, 0, localAnimationDrawable.getMinimumWidth(), this.jdField_c_of_type_AndroidGraphicsDrawableAnimationDrawable.getMinimumHeight());
      paramImageView.setImageDrawable(this.jdField_c_of_type_AndroidGraphicsDrawableAnimationDrawable);
      this.jdField_c_of_type_AndroidGraphicsDrawableAnimationDrawable.stop();
      this.jdField_c_of_type_AndroidGraphicsDrawableAnimationDrawable.start();
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
    Object localObject = (ActionSheet)ActionSheetHelper.a(this, null);
    ((ActionSheet)localObject).setMainTitle(getResources().getString(2131696093));
    ((ActionSheet)localObject).addButton(2131691479, 3);
    ((ActionSheet)localObject).addCancelButton(2131690728);
    ((ActionSheet)localObject).setOnButtonClickListener(new ChatHistory.27(this, paramMessageRecord, (ActionSheet)localObject));
    ((ActionSheet)localObject).show();
  }
  
  void a(String paramString)
  {
    View localView = getLayoutInflater().inflate(2131559055, null);
    int n = this.jdField_a_of_type_Int;
    if (1 == n)
    {
      ((TextView)localView.findViewById(2131378476)).setText(2131691068);
      localView.findViewById(2131365472).setVisibility(8);
    }
    else if (3000 == n)
    {
      ((TextView)localView.findViewById(2131378476)).setText(2131691067);
      localView.findViewById(2131365472).setVisibility(8);
    }
    else if ((1001 == n) || (10002 == n) || (1000 == n) || (10004 == n) || (1020 == n) || (1004 == n) || (10010 == n))
    {
      localView.findViewById(2131365472).setVisibility(8);
    }
    if (!isFinishing())
    {
      this.jdField_b_of_type_AndroidAppDialog = DialogUtil.a(this, 230).setTitle(getString(2131691495)).setPositiveButton(getString(2131691479), new ChatHistory.16(this, paramString)).setNegativeButton(getString(2131690707), new ChatHistory.15(this)).addView(localView);
      this.jdField_b_of_type_AndroidAppDialog.show();
    }
  }
  
  @SuppressLint({"NewApi"})
  protected void a(String paramString, int paramInt)
  {
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)findViewById(2131370120));
    c();
    a();
    this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$ChatHistoryAdapter = new ChatHistory.ChatHistoryAdapter(this, this, null);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$ChatHistoryAdapter);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnScrollListener(this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener);
    this.jdField_a_of_type_ComTencentWidgetXListView.setEdgeEffectEnabled(false);
    if (Build.VERSION.SDK_INT >= 9) {
      this.jdField_a_of_type_ComTencentWidgetXListView.setOverscrollFooter(null);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$ChatHistoryAdapter.a(paramString, paramInt, this.jdField_e_of_type_Int);
  }
  
  boolean a(int paramInt)
  {
    if ((paramInt > 0) && (paramInt <= this.jdField_c_of_type_Int * 8))
    {
      this.jdField_b_of_type_Boolean = true;
      paramInt -= 1;
      int n = paramInt / 8;
      this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$ChatHistoryAdapter.jdField_c_of_type_Int = (paramInt % 8);
      this.jdField_a_of_type_AndroidWidgetEditText.setText(String.valueOf(n + 1));
      EditText localEditText = this.jdField_a_of_type_AndroidWidgetEditText;
      localEditText.setSelection(localEditText.getText().length());
      return true;
    }
    return false;
  }
  
  void b()
  {
    View localView1 = findViewById(2131378891);
    View localView2 = findViewById(2131376809);
    int n = localView1.getHeight();
    this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchMessageSearchDialog = new MessageSearchDialog(this, this.app, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    float f1 = -n;
    TranslateAnimation localTranslateAnimation1 = new TranslateAnimation(0.0F, 0.0F, 0.0F, f1);
    localTranslateAnimation1.setDuration(200L);
    localTranslateAnimation1.setFillAfter(true);
    TranslateAnimation localTranslateAnimation2 = new TranslateAnimation(0.0F, 0.0F, f1, 0.0F);
    localTranslateAnimation2.setDuration(200L);
    localTranslateAnimation1.setAnimationListener(new ChatHistory.4(this, localView2, localView1));
    localTranslateAnimation2.setAnimationListener(new ChatHistory.5(this, localView2, n));
    this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchMessageSearchDialog.setOnDismissListener(new ChatHistory.6(this, localView2, n, localView1, localTranslateAnimation2));
    localView2.startAnimation(localTranslateAnimation1);
  }
  
  void b(int paramInt)
  {
    QQToast.a(getActivity(), paramInt, 0).b(getResources().getDimensionPixelSize(2131299168));
  }
  
  protected void b(ImageView paramImageView)
  {
    if (paramImageView != null)
    {
      this.jdField_c_of_type_AndroidGraphicsDrawableAnimationDrawable.stop();
      paramImageView.setImageDrawable(getResources().getDrawable(2130847365));
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
  
  void b(String paramString)
  {
    Toast localToast = jdField_a_of_type_AndroidWidgetToast;
    if (localToast == null) {
      jdField_a_of_type_AndroidWidgetToast = Toast.makeText(this, paramString, 0);
    } else {
      localToast.setText(paramString);
    }
    jdField_a_of_type_AndroidWidgetToast.show();
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
      ((StringBuilder)localObject1).append(getString(2131719979));
      ((StringBuilder)localObject1).append(":");
      localStringBuffer.append(((StringBuilder)localObject1).toString());
      localStringBuffer.append(paramString);
      localStringBuffer.append("\r\n===========================================\r\n");
    }
    int i1;
    int n;
    int i2;
    Object localObject2;
    if ((localCursor != null) && (localCursor.moveToFirst()))
    {
      localObject1 = "";
      i1 = localCursor.getInt(localCursor.getColumnIndex("time"));
      paramString = localCursor.getString(localCursor.getColumnIndex("senderuin"));
      n = 0;
      if (1 == paramInt)
      {
        if (((TroopManager)this.app.getManager(QQManagerFactory.TROOP_MANAGER)).m(this.jdField_b_of_type_JavaLangString)) {
          paramString = ContactUtils.b(this.app, this.jdField_b_of_type_JavaLangString, paramString);
        } else {
          paramString = String.format("%s(%s)", new Object[] { ContactUtils.b(this.app, this.jdField_b_of_type_JavaLangString, paramString), paramString });
        }
      }
      else if (3000 == paramInt) {
        paramString = String.format("%s(%s)", new Object[] { ContactUtils.a(this.app, paramString, 0), paramString });
      } else {
        paramString = this.jdField_c_of_type_JavaLangString;
      }
      i2 = localCursor.getInt(localCursor.getColumnIndex("issend"));
      localObject2 = paramString;
      if (MessageRecordInfo.a(i2)) {
        localObject2 = a();
      }
      if ((localCursor.getColumnIndex("versionCode") >= 0) && (localCursor.getInt(localCursor.getColumnIndex("versionCode")) > 0))
      {
        int i3 = localCursor.getInt(localCursor.getColumnIndex("msgtype"));
        if (i3 == -2007)
        {
          paramString = getString(2131691922);
          break label1042;
        }
        if (i3 == -2058)
        {
          paramString = getString(2131719234);
          break label1042;
        }
        if (i3 == -2039)
        {
          paramString = localCursor.getBlob(localCursor.getColumnIndex("msgData"));
          paramString = ((IApolloMessageUtil)QRoute.api(IApolloMessageUtil.class)).getApolloDescMsg(paramString);
          break label1042;
        }
        if (i3 == -2011)
        {
          paramString = a(StructMsgFactory.a(localCursor.getBlob(localCursor.getColumnIndex("msgData"))));
          break label1042;
        }
        if (i3 == -2020)
        {
          if (MessageRecordInfo.a(i2))
          {
            paramString = this.app.getApp().getString(2131718862, new Object[] { this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString });
            break label1042;
          }
          paramString = this.app.getApp().getString(2131718861);
          break label1042;
        }
        if (i3 == -2006)
        {
          paramString = (String)localObject1;
          break label1347;
        }
        if (i3 == -2000)
        {
          paramString = HardCodeUtil.a(2131701813);
          break label1042;
        }
        if (i3 == -2002)
        {
          paramString = HardCodeUtil.a(2131701801);
          break label1042;
        }
        if (i3 == -2022)
        {
          paramString = HardCodeUtil.a(2131701811);
          break label1042;
        }
        if (i3 == -2071)
        {
          paramString = getString(2131691284);
          break label1042;
        }
        if (i3 == -7001)
        {
          paramString = getString(2131694329);
          break label1042;
        }
        if (i3 == -1035) {
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
          break label1414;
        }
        localCursor.close();
        return;
      }
      i2 = ((MixedMsg.Msg)localObject1).elems.get().size();
      while (n < i2)
      {
        localObject3 = (MixedMsg.Elem)((MixedMsg.Msg)localObject1).elems.get().get(n);
        if (((MixedMsg.Elem)localObject3).textMsg.has()) {
          paramString.append(((MixedMsg.Elem)localObject3).textMsg.get());
        } else if (((MixedMsg.Elem)localObject3).picMsg.has()) {
          paramString.append("[图片]");
        }
        n += 1;
      }
    }
    catch (Exception localException1)
    {
      Object localObject3;
      label959:
      break label959;
    }
    if (QLog.isColorLevel()) {
      QLog.i("ChatHistory", 2, "Parse mix message error");
    }
    paramString = paramString.toString();
    break label1042;
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
    label1042:
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
        if (b((String)localObject1))
        {
          localObject3 = localObject1.split("\026")[1].split("\\|");
          try
          {
            if (localObject3.length < 2) {
              n = 1;
            } else {
              n = Integer.valueOf(localObject3[2]).intValue();
            }
          }
          catch (Exception localException2)
          {
            label1144:
            QLog.d("ChatHistory", 1, "", localException2);
            localObject4 = localObject1;
          }
          localObject3 = localObject1;
          if (n == 2)
          {
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("[");
            ((StringBuilder)localObject3).append(getString(2131719744));
            ((StringBuilder)localObject3).append("]");
            localObject3 = ((StringBuilder)localObject3).toString();
            localObject1 = localObject3;
          }
        }
      }
    }
    for (;;)
    {
      localObject3 = getString(2131718406);
      localObject1 = localObject3;
      localObject3 = localObject1;
      Object localObject4;
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(a(i1 * 1000L));
      ((StringBuilder)localObject1).append("  ");
      ((StringBuilder)localObject1).append((String)localObject2);
      ((StringBuilder)localObject1).append("\r\n");
      ((StringBuilder)localObject1).append(localObject4);
      localObject1 = ((StringBuilder)localObject1).toString();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append("\r\n\r\n");
      localStringBuffer.append(((StringBuilder)localObject2).toString());
      label1347:
      if (localCursor.moveToNext())
      {
        localObject1 = paramString;
        break;
      }
      if (localCursor != null) {
        localCursor.close();
      }
      runOnUiThread(new ChatHistory.21(this, FileUtils.writeFile(AppConstants.SDCARD_PATH_CHATRECORD, this.jdField_a_of_type_JavaLangStringBuffer.toString(), localStringBuffer.toString())));
      return;
      label1414:
      return;
      if (n != 1) {
        if (n != 65538) {
          break label1144;
        }
      }
    }
  }
  
  boolean b(String paramString)
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
  
  void c()
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_AndroidViewView = ((RelativeLayout)View.inflate(this, 2131562770, null));
    int n = (int)DisplayUtils.a(this, 6.0F);
    Object localObject = new RelativeLayout(this);
    ((RelativeLayout)localObject).setPadding(0, n, 0, n);
    ((RelativeLayout)localObject).setBackgroundResource(2130850681);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, getResources().getDimensionPixelSize(2131298889));
    ((RelativeLayout)localObject).addView(this.jdField_a_of_type_AndroidViewView, localLayoutParams);
    this.jdField_a_of_type_ComTencentWidgetXListView.addHeaderView((View)localObject);
    this.jdField_a_of_type_AndroidViewView.findViewById(2131363868).setVisibility(8);
    localObject = (EditText)this.jdField_a_of_type_AndroidViewView.findViewById(2131366333);
    ((EditText)localObject).setFocusableInTouchMode(false);
    ((EditText)localObject).setCursorVisible(false);
    ((EditText)localObject).setOnClickListener(new ChatHistory.7(this));
    setLayerType(this.jdField_a_of_type_AndroidViewView);
  }
  
  protected void c(String paramString)
  {
    if (this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) {
      this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, getTitleBarHeight());
    }
    this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog.setCancelable(true);
    this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(paramString);
    this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
  }
  
  protected boolean c(String paramString)
  {
    o();
    MediaPlayerManager.a(this.app).a(true);
    if (this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerAudioPlayer == null) {
      this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerAudioPlayer = new AudioPlayer(this, this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerAudioPlayerBase$AudioPlayerListener);
    }
    this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerAudioPlayer.a(3);
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerAudioPlayer.a(paramString);
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("playSource|bRet = ");
      paramString.append(bool);
      QLog.i("ChatHistory", 2, paramString.toString());
    }
    if (bool)
    {
      paramString = this.jdField_a_of_type_AndroidHardwareSensor;
      if (paramString != null) {
        this.jdField_a_of_type_AndroidHardwareSensorManager.registerListener(this, paramString, 2);
      }
    }
    return bool;
  }
  
  protected void d()
  {
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131368492));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131368493));
    this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(getString(2131690803));
    this.jdField_b_of_type_AndroidWidgetImageView.setContentDescription(getString(2131690802));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new ChatHistory.9(this));
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(new ChatHistory.10(this));
    this.jdField_b_of_type_AndroidWidgetImageView.setEnabled(false);
    this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130849919);
    if (this.jdField_c_of_type_Int == 1)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setEnabled(false);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130840566);
    }
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131378484));
    this.jdField_b_of_type_AndroidWidgetTextView.setText(String.valueOf(this.jdField_c_of_type_Int));
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131366043));
    this.jdField_a_of_type_AndroidWidgetEditText.setText(String.valueOf(this.jdField_d_of_type_Int));
    Object localObject = this.jdField_a_of_type_AndroidWidgetEditText;
    ((EditText)localObject).setSelection(((EditText)localObject).getText().toString().length());
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(new ChatHistory.11(this));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131364159));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new ChatHistory.12(this));
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)findViewById(2131364158));
    this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(new ChatHistory.13(this));
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetButton.setVisibility(8);
    }
    int n = this.jdField_a_of_type_Int;
    if ((n != 1001) && (n != 10002) && (n != 10004) && (n != 1000) && (n != 1020) && (n != 1005) && (n != 1004) && (n != 1009) && (n != 1010) && (n != 1023) && (n != 1024) && (n != 10010))
    {
      if ((n != 1) && (n != 3000))
      {
        localObject = (FriendsManager)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER);
        if ((localObject == null) || (!((FriendsManager)localObject).b(String.valueOf(this.jdField_b_of_type_JavaLangString))))
        {
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("--mSyncHistory button: fm is null or the uin is not my friend: fm:");
            localStringBuilder.append(localObject);
            QLog.e("ChatHistory", 2, localStringBuilder.toString());
          }
          this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
        }
      }
    }
    else {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(new ChatHistory.14(this));
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
      this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$ChatHistoryAdapter.getCursor().requery();
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
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    this.jdField_a_of_type_Float = getResources().getDisplayMetrics().density;
    this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable = ((AnimationDrawable)getResources().getDrawable(2130772397));
    this.jdField_b_of_type_AndroidGraphicsDrawableAnimationDrawable = ((AnimationDrawable)getResources().getDrawable(2130772398));
    this.jdField_c_of_type_AndroidGraphicsDrawableAnimationDrawable = ((AnimationDrawable)getResources().getDrawable(2130772308));
    paramBundle = getIntent().getExtras();
    this.jdField_b_of_type_JavaLangString = paramBundle.getString("uin");
    this.jdField_a_of_type_Int = paramBundle.getInt("uintype");
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = new SessionInfo();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
    ((SessionInfo)localObject).jdField_a_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
    ((SessionInfo)localObject).jdField_a_of_type_Int = this.jdField_a_of_type_Int;
    ((SessionInfo)localObject).jdField_d_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
    ((SessionInfo)localObject).jdField_b_of_type_JavaLangString = paramBundle.getString("troop_uin");
    setContentViewNoTitle(2131558851);
    localObject = (LinearLayout)findViewById(2131376809);
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      ((LinearLayout)localObject).setFitsSystemWindows(true);
      ((LinearLayout)localObject).setPadding(0, ImmersiveUtils.getStatusBarHeight(this), 0, 0);
    }
    boolean bool = paramBundle.getBoolean("from_RecentSaidActivity", false);
    this.jdField_a_of_type_Boolean = bool;
    if (bool) {
      this.jdField_a_of_type_Long = paramBundle.getLong("target_shmsgseq");
    }
    init(getIntent());
    this.app.setHandler(getClass(), this.jdField_a_of_type_MqqOsMqqHandler);
    this.jdField_a_of_type_ComTencentMobileqqPersistenceQslowtableQSlowTableManager = ((QSlowTableManager)this.app.getManager(QQManagerFactory.SLOW_TABLE_MANAGER));
    a(9, false);
    m();
    a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Int);
    q();
    if (this.app.getProxyManager() != null) {
      this.app.getProxyManager().addProxyObserver(this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyObserver);
    }
    this.app.getProxyManager().saveNotify();
    this.jdField_a_of_type_ComTencentMobileqqUtilImageWorker = new ImageWorker(this);
    paramBundle = this.jdField_a_of_type_ComTencentMobileqqUtilImageWorker;
    float f1 = this.jdField_a_of_type_Float;
    paramBundle.a((int)(150.0F * f1), (int)(f1 * 100.0F));
    s();
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$ChatHistoryAdapter;
    if (localObject != null) {
      ((ChatHistory.ChatHistoryAdapter)localObject).a();
    }
    localObject = this.jdField_a_of_type_AndroidHardwareSensorManager;
    if (localObject != null) {
      ((SensorManager)localObject).unregisterListener(this);
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager;
    if ((localObject != null) && (((EntityManager)localObject).isOpen()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ChatHistory", 2, "ChatHistory : close entityManager.");
      }
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.close();
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = null;
    }
    n();
    r();
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onDestroy() mCurPlayingPttInfo = ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$PlayingPttHistoryInfo);
      QLog.i("ChatHistory", 2, ((StringBuilder)localObject).toString());
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$PlayingPttHistoryInfo;
    if ((localObject != null) && (!((ChatHistory.PlayingPttHistoryInfo)localObject).jdField_a_of_type_Boolean))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$PlayingPttHistoryInfo.d();
      this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable.stop();
      this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable = null;
      this.jdField_b_of_type_AndroidGraphicsDrawableAnimationDrawable.stop();
      this.jdField_b_of_type_AndroidGraphicsDrawableAnimationDrawable = null;
      this.jdField_c_of_type_AndroidGraphicsDrawableAnimationDrawable.stop();
      this.jdField_c_of_type_AndroidGraphicsDrawableAnimationDrawable = null;
    }
    this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
    this.app.removeHandler(getClass());
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    if (this.app.getProxyManager() != null) {
      this.app.getProxyManager().removeProxyObserver(this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyObserver);
    }
    this.app.getProxyManager().saveNotify();
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilImageWorker.a().a();
      label253:
      findViewById(2131376809).clearAnimation();
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
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$PlayingPttHistoryInfo);
      QLog.i("ChatHistory", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$PlayingPttHistoryInfo;
    if ((localObject != null) && (!((ChatHistory.PlayingPttHistoryInfo)localObject).jdField_a_of_type_Boolean)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$PlayingPttHistoryInfo.d();
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
    if ((this.jdField_a_of_type_Boolean) && (!this.jdField_b_of_type_Boolean))
    {
      MqqHandler localMqqHandler = this.jdField_a_of_type_MqqOsMqqHandler;
      if (localMqqHandler != null)
      {
        this.jdField_b_of_type_Boolean = true;
        localMqqHandler.postDelayed(new ChatHistory.22(this), 300L);
      }
    }
  }
  
  void e()
  {
    f();
    this.jdField_a_of_type_AndroidWidgetEditText.setText(String.valueOf(this.jdField_d_of_type_Int));
    EditText localEditText = this.jdField_a_of_type_AndroidWidgetEditText;
    localEditText.setSelection(localEditText.getText().length());
    this.jdField_b_of_type_AndroidWidgetTextView.setText(String.valueOf(this.jdField_c_of_type_Int));
    this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$ChatHistoryAdapter.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Int, this.jdField_e_of_type_Int);
  }
  
  protected void f()
  {
    this.jdField_d_of_type_Int = this.jdField_c_of_type_Int;
    this.jdField_e_of_type_Int = ((this.jdField_d_of_type_Int - 1) * 8);
  }
  
  public void finish()
  {
    super.finish();
  }
  
  void g()
  {
    if (getActivity() != null)
    {
      if (getActivity().isFinishing()) {
        return;
      }
      int n = this.jdField_d_of_type_Int;
      int i1 = this.jdField_c_of_type_Int;
      if (n > i1)
      {
        this.jdField_d_of_type_Int = i1;
        this.jdField_e_of_type_Int = ((this.jdField_d_of_type_Int - 1) * 8);
      }
      this.jdField_a_of_type_AndroidWidgetEditText.setText(String.valueOf(this.jdField_d_of_type_Int));
      EditText localEditText = this.jdField_a_of_type_AndroidWidgetEditText;
      localEditText.setSelection(localEditText.getText().length());
      this.jdField_b_of_type_AndroidWidgetTextView.setText(String.valueOf(this.jdField_c_of_type_Int));
      this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$ChatHistoryAdapter.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Int, this.jdField_e_of_type_Int);
    }
  }
  
  void h()
  {
    this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(4, getResources().getString(2131719255)).sendToTarget();
    this.app.getMsgHandler().a((short)1, (byte)1);
  }
  
  void i()
  {
    MessageRoamManager localMessageRoamManager = (MessageRoamManager)this.app.getManager(QQManagerFactory.MESSAGE_ROAM_MANAGER);
    if (localMessageRoamManager != null)
    {
      long l1 = NetConnInfoCenter.getServerTime();
      this.app.getMsgHandler().a(this.jdField_b_of_type_JavaLangString, l1 - 604800L, 0L, l1, (short)0, 0L, 1, null, localMessageRoamManager.b(), false, 0, false);
    }
  }
  
  protected void j()
  {
    if (!NetworkUtil.isNetSupport(this.app.getApplication().getApplicationContext()))
    {
      QQToast.a(getApplicationContext(), 2131691496, 1).a();
      return;
    }
    c(getApplication().getResources().getString(2131691497));
    this.app.getMsgHandler().e(this.jdField_b_of_type_JavaLangString);
  }
  
  void k()
  {
    this.jdField_a_of_type_JavaLangStringBuffer.setLength(0);
    if (this.jdField_c_of_type_JavaLangString.compareTo(this.jdField_b_of_type_JavaLangString) == 0) {
      localObject1 = this.jdField_c_of_type_JavaLangString;
    } else {
      localObject1 = String.format("%s(%s)", new Object[] { this.jdField_c_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString });
    }
    if (a((String)localObject1))
    {
      localObject1 = ((String)localObject1).replaceAll("[\\\\/:*?\"<>|]", "");
      localObject2 = this.jdField_a_of_type_JavaLangStringBuffer;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject1);
      localStringBuilder.append(".txt");
      ((StringBuffer)localObject2).append(localStringBuilder.toString());
    }
    else
    {
      localObject1 = this.jdField_a_of_type_JavaLangStringBuffer;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(this.jdField_b_of_type_JavaLangString);
      ((StringBuilder)localObject2).append(".txt");
      ((StringBuffer)localObject1).append(((StringBuilder)localObject2).toString());
    }
    boolean bool = FileUtils.justOnExistFileAndAddSuffix(AppConstants.SDCARD_PATH_CHATRECORD, this.jdField_a_of_type_JavaLangStringBuffer, ".txt");
    Object localObject1 = getString(2131691072);
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(getString(2131691072));
    ((StringBuilder)localObject2).append(AppConstants.SDCARD_PATH_CHATRECORD);
    ((StringBuilder)localObject2).append(this.jdField_a_of_type_JavaLangStringBuffer.toString());
    this.jdField_c_of_type_AndroidAppDialog = DialogUtil.a(this, 230, (String)localObject1, ((StringBuilder)localObject2).toString(), new ChatHistory.17(this), new ChatHistory.18(this));
    if (bool)
    {
      this.jdField_c_of_type_AndroidAppDialog.show();
      return;
    }
    b(getString(2131692092));
  }
  
  void l()
  {
    this.jdField_c_of_type_AndroidAppDialog = DialogUtil.a(this, 230, getString(2131719256), getString(2131719644), new ChatHistory.19(this), new ChatHistory.20(this));
    this.jdField_c_of_type_AndroidAppDialog.show();
  }
  
  protected void m()
  {
    String str2 = getResources().getString(2131690793);
    int n = this.jdField_a_of_type_Int;
    String str1;
    if (n == 0)
    {
      if (this.jdField_b_of_type_JavaLangString.equals(String.valueOf(AppConstants.SYSTEM_MSG_UIN))) {
        this.jdField_c_of_type_JavaLangString = getResources().getString(2131719404);
      } else {
        this.jdField_c_of_type_JavaLangString = ContactUtils.a(this.app, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString, ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int), 3);
      }
      str1 = str2;
      if (this.jdField_b_of_type_JavaLangString.equals(String.valueOf(AppConstants.SYSTEM_MSG_UIN))) {
        str1 = getResources().getString(2131719404);
      }
    }
    else if (n == 1)
    {
      this.jdField_c_of_type_JavaLangString = ((TroopManager)this.app.getManager(QQManagerFactory.TROOP_MANAGER)).a(this.jdField_b_of_type_JavaLangString);
      str1 = str2;
    }
    else if ((n != 1000) && (n != 1020) && (n != 1001) && (n != 10002) && (n != 10004) && (n != 1004) && (n != 10010))
    {
      if (n == 3000)
      {
        this.jdField_c_of_type_JavaLangString = ContactUtils.a(this.app, this.jdField_b_of_type_JavaLangString);
        str1 = str2;
      }
      else
      {
        str1 = str2;
        if (n == 1024)
        {
          PublicAccountInfo localPublicAccountInfo = (PublicAccountInfo)((IPublicAccountDataManager)this.app.getRuntimeService(IPublicAccountDataManager.class, "all")).findPublicAccountInfo(this.jdField_b_of_type_JavaLangString);
          str1 = str2;
          if (localPublicAccountInfo != null)
          {
            this.jdField_c_of_type_JavaLangString = localPublicAccountInfo.name;
            str1 = str2;
          }
        }
      }
    }
    else
    {
      this.jdField_c_of_type_JavaLangString = ContactUtils.c(this.app, this.jdField_b_of_type_JavaLangString);
      str1 = str2;
    }
    str2 = this.jdField_c_of_type_JavaLangString;
    if ((str2 == null) || (str2.trim().equals(""))) {
      this.jdField_c_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
    }
    setTitle(str1);
    this.jdField_d_of_type_JavaLangString = a();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
    this.leftView = ((TextView)findViewById(2131369202));
  }
  
  protected void n()
  {
    Toast localToast = jdField_a_of_type_AndroidWidgetToast;
    if (localToast != null)
    {
      localToast.cancel();
      jdField_a_of_type_AndroidWidgetToast = null;
    }
  }
  
  protected void o()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerAudioPlayer;
    if ((localObject != null) && (((AudioPlayer)localObject).a()))
    {
      this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerAudioPlayer.c();
      this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerAudioPlayer = null;
    }
    localObject = this.jdField_a_of_type_AndroidHardwareSensorManager;
    if (localObject != null) {
      ((SensorManager)localObject).unregisterListener(this);
    }
    setVolumeControlStream(3);
  }
  
  public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  protected boolean onBackEvent()
  {
    try
    {
      if (this.jdField_a_of_type_AndroidWidgetEditText != null) {
        InputMethodUtil.b(this.jdField_a_of_type_AndroidWidgetEditText);
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    setResult(-1);
    MessageSearchDialog localMessageSearchDialog = this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchMessageSearchDialog;
    if ((localMessageSearchDialog != null) && (localMessageSearchDialog.a()))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchMessageSearchDialog.show();
      this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchMessageSearchDialog.a(false);
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
    int n = this.jdField_a_of_type_Int;
    if ((3000 != n) && (1 != n)) {
      this.rightViewText.setVisibility(0);
    } else {
      this.rightViewText.setVisibility(8);
    }
    localTextView.setText(2131718355);
    this.jdField_a_of_type_AndroidWidgetTextView = localTextView;
    return localTextView;
  }
  
  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    if (DeviceInfoUtil.j()) {
      return;
    }
    paramSensorEvent = paramSensorEvent.values;
    boolean bool = false;
    if (paramSensorEvent[0] < this.jdField_b_of_type_Float) {
      bool = true;
    }
    if (this.jdField_e_of_type_Boolean != bool)
    {
      this.jdField_e_of_type_Boolean = bool;
      paramSensorEvent = this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerAudioPlayer;
      if (paramSensorEvent != null) {
        paramSensorEvent.a(this.jdField_e_of_type_Boolean ^ true);
      }
      if (!AppSetting.jdField_d_of_type_Boolean)
      {
        int n;
        if (this.jdField_e_of_type_Boolean) {
          n = 2131719244;
        } else {
          n = 2131719246;
        }
        b(n);
      }
    }
  }
  
  void p()
  {
    AudioUtil.b(2131230735, false);
  }
  
  protected void q()
  {
    this.jdField_a_of_type_AndroidHardwareSensorManager = ((SensorManager)this.app.getApplication().getSystemService("sensor"));
    this.jdField_a_of_type_AndroidHardwareSensor = this.jdField_a_of_type_AndroidHardwareSensorManager.getDefaultSensor(8);
    Sensor localSensor = this.jdField_a_of_type_AndroidHardwareSensor;
    if (localSensor != null)
    {
      this.jdField_b_of_type_Float = localSensor.getMaximumRange();
      float f2 = this.jdField_b_of_type_Float;
      float f1 = f2;
      if (f2 > 10.0F) {
        f1 = 10.0F;
      }
      this.jdField_b_of_type_Float = f1;
    }
  }
  
  void r()
  {
    try
    {
      if (this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog != null)
      {
        this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
        this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog.cancel();
        this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  protected void s()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
    if (localObject != null)
    {
      int n = ((SessionInfo)localObject).jdField_a_of_type_Int;
      if (n != 0)
      {
        if (n != 1)
        {
          if (n == 3000) {
            this.k = 2;
          }
        }
        else {
          this.k = 3;
        }
      }
      else {
        this.k = 0;
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("AIO_chatlog arg:");
        ((StringBuilder)localObject).append(this.k);
        QLog.d("ChatHistory", 2, ((StringBuilder)localObject).toString());
      }
      localObject = this.app;
      n = this.k;
      ReportController.b((AppRuntime)localObject, "CliOper", "", "", "AIO", "AIO_chatlog", n, 0, String.valueOf(n), "", "", "");
    }
  }
  
  public void t()
  {
    if (this.jdField_c_of_type_Boolean) {
      return;
    }
    this.jdField_c_of_type_Boolean = true;
    ReportController.b(this.app, "CliOper", "", "", "0X8005690", "0X8005690", this.k, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatHistory
 * JD-Core Version:    0.7.0.1
 */