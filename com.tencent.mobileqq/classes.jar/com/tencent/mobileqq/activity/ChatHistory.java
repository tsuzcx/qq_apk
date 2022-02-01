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
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.MessageRoamManager;
import com.tencent.mobileqq.app.PublicAccountDataManager;
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
import com.tencent.mobileqq.emoticonview.PicEmoticonInfo;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;
import com.tencent.mobileqq.persistence.qslowtable.QSlowTableManager;
import com.tencent.mobileqq.qqaudio.audioplayer.AudioPlayer;
import com.tencent.mobileqq.qqaudio.audioplayer.AudioPlayerBase.AudioPlayerListener;
import com.tencent.mobileqq.service.message.remote.MessageRecordInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
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
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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
    }
    for (paramQQAppInterface = MessageDBUtils.a(MessageRecord.getOldTableName(paramString, paramInt), MessageRecord.getTableName(paramString, paramInt), localSQLiteDatabase, "", paramQQAppInterface.toString(), ""); paramQQAppInterface == null; paramQQAppInterface = MessageDBUtils.a(MessageRecord.getOldTableName(paramString, paramInt), MessageRecord.getTableName(paramString, paramInt), localSQLiteDatabase, paramQQAppInterface.toString()))
    {
      return 0;
      paramQQAppInterface = new StringBuilder(" where msgtype ");
      paramQQAppInterface.append(UinTypeUtil.a());
      paramQQAppInterface.append(" and isValid=1 ");
    }
    paramQQAppInterface = localSQLiteDatabase.rawQuery(paramQQAppInterface.toString(), null);
    if (paramQQAppInterface == null) {
      return 0;
    }
    long l1;
    if ((paramQQAppInterface.getCount() > 0) && (paramStringBuilder != null))
    {
      paramQQAppInterface.moveToLast();
      if (paramInt != 3000) {
        break label218;
      }
      l1 = paramQQAppInterface.getLong(paramQQAppInterface.getColumnIndex("shmsgseq"));
    }
    for (;;)
    {
      if (l1 > 0L) {
        paramStringBuilder.append(String.valueOf(l1));
      }
      paramInt = paramQQAppInterface.getCount();
      paramQQAppInterface.close();
      return paramInt;
      label218:
      if (paramInt == 0) {
        l1 = paramQQAppInterface.getLong(paramQQAppInterface.getColumnIndex("time"));
      } else if (paramInt == 1) {
        l1 = paramQQAppInterface.getLong(paramQQAppInterface.getColumnIndex("shmsgseq"));
      } else {
        l1 = 0L;
      }
    }
  }
  
  public static final Object a(View paramView)
  {
    if (paramView == null) {
      return null;
    }
    if ((paramView.getParent() == null) || ((paramView.getParent() instanceof XListView))) {
      return paramView.getTag();
    }
    return a((View)paramView.getParent());
  }
  
  public static boolean a(String paramString)
  {
    boolean bool = true;
    if ((paramString == null) || (paramString.trim().equals("")) || (paramString.contains("\n"))) {
      bool = false;
    }
    while (!Pattern.compile("^[*+,./\\\"=_-]+").matcher(paramString.substring(0, 1)).matches()) {
      return bool;
    }
    return false;
  }
  
  private void b(MessageRecord paramMessageRecord)
  {
    c(this.app.getMessageFacade().a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Int, paramMessageRecord));
  }
  
  private void c(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ChatHistory", 2, "recordCount : " + paramInt);
    }
    paramInt = this.l + paramInt;
    if (paramInt <= 0) {}
    int n;
    do
    {
      return;
      n = (paramInt - 1) / 8 + 1;
      if (QLog.isColorLevel()) {
        QLog.i("ChatHistory", 2, "pageIndex = " + n);
      }
    } while (n < 0);
    this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$ChatHistoryAdapter.jdField_c_of_type_Int = ((paramInt - 1) % 8);
    this.jdField_a_of_type_AndroidWidgetEditText.setText(String.valueOf(n));
    this.jdField_a_of_type_AndroidWidgetEditText.setSelection(this.jdField_a_of_type_AndroidWidgetEditText.getText().length());
  }
  
  protected MsgBody a(int paramInt1, int paramInt2, String paramString, int paramInt3)
  {
    if (((paramInt2 != -1003) && (paramInt2 != -1032) && (paramInt2 != -1031) && (paramInt2 != 201)) || ((paramInt1 == 1001) || (paramInt1 == 10002) || (ActionMsgUtil.a(paramInt2)) || (paramInt2 == -3001) || (paramInt2 == -30002) || (paramInt2 == -30003))) {
      return ActionMsgUtil.a(paramString);
    }
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
  
  public Cursor a(String paramString1, String paramString2, String paramString3)
  {
    SQLiteDatabase localSQLiteDatabase = this.app.getReadableDatabase();
    if (localSQLiteDatabase == null) {
      if (QLog.isColorLevel()) {
        QLog.e("ChatHistory", 2, "MessageProvide getDB null!");
      }
    }
    do
    {
      return null;
      if (paramString1.indexOf("mr_troop_") == -1) {
        break;
      }
      paramString3 = " where " + paramString3;
      paramString2 = MessageDBUtils.b(paramString2, paramString1, localSQLiteDatabase, paramString3);
    } while (paramString2 == null);
    paramString2.append(" t left join TroopMemberInfo m on t.senderuin=m.memberuin and t.frienduin=m.troopuin");
    for (;;)
    {
      try
      {
        paramString2 = localSQLiteDatabase.rawQuery(paramString2.toString(), null);
        paramString1 = paramString2;
      }
      catch (SQLException paramString2)
      {
        paramString1 = localSQLiteDatabase.query(paramString1, null, paramString3, null, null, null);
        continue;
      }
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
        try
        {
          paramString2 = localSQLiteDatabase.rawQuery(paramString2.toString(), null);
          paramString1 = paramString2;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("gene", 2, "cursor: " + paramString2);
          paramString1 = paramString2;
        }
        catch (SQLException paramString2)
        {
          for (;;)
          {
            paramString2 = localSQLiteDatabase.query(paramString1, null, paramString3, null, null, null);
          }
        }
      }
      else
      {
        if (paramString1.indexOf("mr_discusssion_") != -1)
        {
          paramString3 = " where " + paramString3;
          paramString2 = MessageDBUtils.b(paramString2, paramString1, localSQLiteDatabase, paramString3);
          if (paramString2 == null) {
            break;
          }
          paramString2.append(" t left join DiscussionMemberInfo m on t.senderuin=m.memberUin and t.frienduin=m.discussionUin");
          try
          {
            paramString2 = localSQLiteDatabase.rawQuery(paramString2.toString(), null);
            paramString1 = paramString2;
          }
          catch (SQLException paramString2)
          {
            paramString1 = localSQLiteDatabase.query(paramString1, null, paramString3, null, null, null);
          }
          continue;
        }
        paramString2 = MessageDBUtils.a(paramString2, paramString1, localSQLiteDatabase, paramString3, null);
        if (paramString2 != null) {
          try
          {
            paramString2 = localSQLiteDatabase.rawQuery(paramString2.toString(), null);
            paramString1 = paramString2;
          }
          catch (SQLException paramString2)
          {
            paramString1 = localSQLiteDatabase.query(paramString1, null, paramString3, null, null, null);
          }
        } else {
          paramString1 = null;
        }
      }
    }
  }
  
  protected EntityManager a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager == null) || (!this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.isOpen())) {}
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
    String str = ContactUtils.h(this.app, this.app.getCurrentAccountUin());
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
    if ((paramAbsStructMsg == null) || (!AbsShareMsg.class.isInstance(paramAbsStructMsg))) {
      return null;
    }
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
    if (!TextUtils.isEmpty(paramAbsStructMsg.mMsgBrief)) {
      localStringBuffer.append(paramAbsStructMsg.mMsgBrief);
    }
    for (;;)
    {
      return localStringBuffer.toString();
      if (!TextUtils.isEmpty(paramAbsStructMsg.mSourceName))
      {
        localStringBuffer.append(paramAbsStructMsg.mSourceName);
        localStringBuffer.append(" " + getString(2131719541) + " ");
        if (!TextUtils.isEmpty(paramAbsStructMsg.mContentTitle)) {
          localStringBuffer.append(paramAbsStructMsg.mContentTitle);
        }
      }
    }
  }
  
  protected void a()
  {
    RelativeLayout localRelativeLayout = new RelativeLayout(getActivity());
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
    this.jdField_a_of_type_ComTencentMobileqqBannerTipsBar = new TipsBar(getActivity());
    this.jdField_a_of_type_ComTencentMobileqqBannerTipsBar.setBarType(4);
    this.jdField_a_of_type_ComTencentMobileqqBannerTipsBar.setTipsIcon(getActivity().getResources().getDrawable(2130838388));
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
    if ((this.jdField_a_of_type_Int == 0) && (((CheckBox)this.jdField_b_of_type_AndroidAppDialog.findViewById(2131365628)).isChecked()))
    {
      j();
      this.app.getFileManagerDataCenter().a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Int);
    }
  }
  
  void a(int paramInt1, int paramInt2)
  {
    this.jdField_b_of_type_Int = paramInt1;
    if (paramInt2 > 0)
    {
      if (paramInt2 < 8)
      {
        paramInt2 = 1;
        if (paramInt1 >= 8) {
          break label79;
        }
        paramInt1 = 1;
      }
      for (;;)
      {
        this.jdField_c_of_type_Int = (paramInt1 + paramInt2);
        this.l = (paramInt2 * 8);
        this.jdField_b_of_type_Int += this.l;
        return;
        if (paramInt2 % 8 == 0) {
          paramInt2 /= 8;
        }
        for (;;)
        {
          break;
          paramInt2 = paramInt2 / 8 + 1;
        }
        label79:
        if (paramInt1 % 8 == 0) {
          paramInt1 /= 8;
        } else {
          paramInt1 = paramInt1 / 8 + 1;
        }
      }
    }
    if (this.jdField_b_of_type_Int < 8)
    {
      this.jdField_c_of_type_Int = 1;
      return;
    }
    if (this.jdField_b_of_type_Int % 8 == 0) {}
    for (paramInt1 = this.jdField_b_of_type_Int / 8;; paramInt1 = this.jdField_b_of_type_Int / 8 + 1)
    {
      this.jdField_c_of_type_Int = paramInt1;
      return;
    }
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
      this.jdField_c_of_type_AndroidGraphicsDrawableAnimationDrawable.setBounds(0, 0, this.jdField_c_of_type_AndroidGraphicsDrawableAnimationDrawable.getMinimumWidth(), this.jdField_c_of_type_AndroidGraphicsDrawableAnimationDrawable.getMinimumHeight());
      paramImageView.setImageDrawable(this.jdField_c_of_type_AndroidGraphicsDrawableAnimationDrawable);
      this.jdField_c_of_type_AndroidGraphicsDrawableAnimationDrawable.stop();
      this.jdField_c_of_type_AndroidGraphicsDrawableAnimationDrawable.start();
    }
  }
  
  protected void a(ImageView paramImageView, PicEmoticonInfo paramPicEmoticonInfo)
  {
    if ((paramImageView != null) && (paramPicEmoticonInfo != null) && (paramPicEmoticonInfo.isSound()))
    {
      paramPicEmoticonInfo = paramPicEmoticonInfo.getLoadingDrawable("fromAIO", true);
      Drawable localDrawable = paramImageView.getDrawable();
      if ((localDrawable instanceof URLDrawable)) {
        EmotionUtils.stopSoundDrawablePlay((URLDrawable)localDrawable);
      }
      paramImageView.setImageDrawable(paramPicEmoticonInfo);
    }
  }
  
  void a(MessageRecord paramMessageRecord)
  {
    if (QLog.isColorLevel())
    {
      if (paramMessageRecord == null) {
        break label110;
      }
      QLog.d("Q.msg.delmsg", 2, "startDelMsg is called,mr uniseq is:" + paramMessageRecord.uniseq + ",id is:" + paramMessageRecord.getId());
    }
    for (;;)
    {
      ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this, null);
      localActionSheet.setMainTitle(getResources().getString(2131696078));
      localActionSheet.addButton(2131691558, 3);
      localActionSheet.addCancelButton(2131690800);
      localActionSheet.setOnButtonClickListener(new ChatHistory.27(this, paramMessageRecord, localActionSheet));
      localActionSheet.show();
      return;
      label110:
      QLog.d("Q.msg.delmsg", 2, "startDelMsg is called,mr is null");
    }
  }
  
  void a(String paramString)
  {
    View localView = getLayoutInflater().inflate(2131559161, null);
    if (1 == this.jdField_a_of_type_Int)
    {
      ((TextView)localView.findViewById(2131379106)).setText(2131691148);
      localView.findViewById(2131365628).setVisibility(8);
    }
    for (;;)
    {
      if (!isFinishing())
      {
        this.jdField_b_of_type_AndroidAppDialog = DialogUtil.a(this, 230).setTitle(getString(2131691574)).setPositiveButton(getString(2131691558), new ChatHistory.16(this, paramString)).setNegativeButton(getString(2131690779), new ChatHistory.15(this)).addView(localView);
        this.jdField_b_of_type_AndroidAppDialog.show();
      }
      return;
      if (3000 == this.jdField_a_of_type_Int)
      {
        ((TextView)localView.findViewById(2131379106)).setText(2131691147);
        localView.findViewById(2131365628).setVisibility(8);
      }
      else if ((1001 == this.jdField_a_of_type_Int) || (10002 == this.jdField_a_of_type_Int) || (1000 == this.jdField_a_of_type_Int) || (10004 == this.jdField_a_of_type_Int) || (1020 == this.jdField_a_of_type_Int) || (1004 == this.jdField_a_of_type_Int) || (10010 == this.jdField_a_of_type_Int))
      {
        localView.findViewById(2131365628).setVisibility(8);
      }
    }
  }
  
  @SuppressLint({"NewApi"})
  protected void a(String paramString, int paramInt)
  {
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)findViewById(2131370461));
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
    if ((paramInt <= 0) || (paramInt > this.jdField_c_of_type_Int * 8)) {
      return false;
    }
    this.jdField_b_of_type_Boolean = true;
    int n = (paramInt - 1) / 8;
    this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$ChatHistoryAdapter.jdField_c_of_type_Int = ((paramInt - 1) % 8);
    this.jdField_a_of_type_AndroidWidgetEditText.setText(String.valueOf(n + 1));
    this.jdField_a_of_type_AndroidWidgetEditText.setSelection(this.jdField_a_of_type_AndroidWidgetEditText.getText().length());
    return true;
  }
  
  void b()
  {
    View localView1 = findViewById(2131379544);
    View localView2 = findViewById(2131377356);
    int n = localView1.getHeight();
    this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchMessageSearchDialog = new MessageSearchDialog(this, this.app, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    TranslateAnimation localTranslateAnimation1 = new TranslateAnimation(0.0F, 0.0F, 0.0F, -n);
    localTranslateAnimation1.setDuration(200L);
    localTranslateAnimation1.setFillAfter(true);
    TranslateAnimation localTranslateAnimation2 = new TranslateAnimation(0.0F, 0.0F, -n, 0.0F);
    localTranslateAnimation2.setDuration(200L);
    localTranslateAnimation1.setAnimationListener(new ChatHistory.4(this, localView2, localView1));
    localTranslateAnimation2.setAnimationListener(new ChatHistory.5(this, localView2, n));
    this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchMessageSearchDialog.setOnDismissListener(new ChatHistory.6(this, localView2, n, localView1, localTranslateAnimation2));
    localView2.startAnimation(localTranslateAnimation1);
  }
  
  void b(int paramInt)
  {
    QQToast.a(getActivity(), paramInt, 0).b(getResources().getDimensionPixelSize(2131299166));
  }
  
  protected void b(ImageView paramImageView)
  {
    if (paramImageView != null)
    {
      this.jdField_c_of_type_AndroidGraphicsDrawableAnimationDrawable.stop();
      paramImageView.setImageDrawable(getResources().getDrawable(2130847495));
    }
  }
  
  protected void b(ImageView paramImageView, PicEmoticonInfo paramPicEmoticonInfo)
  {
    if ((paramImageView != null) && (paramPicEmoticonInfo != null) && (paramPicEmoticonInfo.isSound()))
    {
      paramPicEmoticonInfo = paramPicEmoticonInfo.getLoadingDrawable("fromAIO", true);
      if ((paramPicEmoticonInfo instanceof URLDrawable)) {
        EmotionUtils.startSoundDrawablePlay((URLDrawable)paramPicEmoticonInfo);
      }
      paramImageView.setImageDrawable(paramPicEmoticonInfo);
    }
  }
  
  void b(String paramString)
  {
    if (jdField_a_of_type_AndroidWidgetToast == null) {
      jdField_a_of_type_AndroidWidgetToast = Toast.makeText(this, paramString, 0);
    }
    for (;;)
    {
      jdField_a_of_type_AndroidWidgetToast.show();
      return;
      jdField_a_of_type_AndroidWidgetToast.setText(paramString);
    }
  }
  
  /* Error */
  protected void b(String paramString, int paramInt)
  {
    // Byte code:
    //   0: ldc 182
    //   2: astore 7
    //   4: new 69	java/lang/StringBuffer
    //   7: dup
    //   8: invokespecial 70	java/lang/StringBuffer:<init>	()V
    //   11: astore 10
    //   13: iload_2
    //   14: iconst_1
    //   15: if_icmpeq +10 -> 25
    //   18: iload_2
    //   19: sipush 3000
    //   22: if_icmpne +511 -> 533
    //   25: aload_1
    //   26: iload_2
    //   27: invokestatic 177	com/tencent/mobileqq/data/MessageRecord:getOldTableName	(Ljava/lang/String;I)Ljava/lang/String;
    //   30: aload_1
    //   31: iload_2
    //   32: invokestatic 180	com/tencent/mobileqq/data/MessageRecord:getTableName	(Ljava/lang/String;I)Ljava/lang/String;
    //   35: aload_0
    //   36: getfield 291	com/tencent/mobileqq/activity/ChatHistory:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   39: invokevirtual 153	com/tencent/mobileqq/app/QQAppInterface:getReadableDatabase	()Lcom/tencent/mobileqq/app/SQLiteDatabase;
    //   42: invokestatic 952	com/tencent/mobileqq/utils/MessageDBUtils:a	(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/app/SQLiteDatabase;)Ljava/lang/StringBuilder;
    //   45: astore 6
    //   47: aload 6
    //   49: ifnull +1288 -> 1337
    //   52: aload_0
    //   53: getfield 291	com/tencent/mobileqq/activity/ChatHistory:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   56: invokevirtual 153	com/tencent/mobileqq/app/QQAppInterface:getReadableDatabase	()Lcom/tencent/mobileqq/app/SQLiteDatabase;
    //   59: aload 6
    //   61: invokevirtual 185	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   64: aconst_null
    //   65: invokevirtual 201	com/tencent/mobileqq/app/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   68: astore 8
    //   70: iload_2
    //   71: iconst_1
    //   72: if_icmpne +61 -> 133
    //   75: aload_0
    //   76: getfield 291	com/tencent/mobileqq/activity/ChatHistory:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   79: aload_1
    //   80: iconst_1
    //   81: invokestatic 955	com/tencent/mobileqq/utils/ContactUtils:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;I)Ljava/lang/String;
    //   84: astore_1
    //   85: aload 10
    //   87: new 155	java/lang/StringBuilder
    //   90: dup
    //   91: invokespecial 310	java/lang/StringBuilder:<init>	()V
    //   94: aload_0
    //   95: ldc_w 956
    //   98: invokevirtual 515	com/tencent/mobileqq/activity/ChatHistory:getString	(I)Ljava/lang/String;
    //   101: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: ldc_w 958
    //   107: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: invokevirtual 185	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   113: invokevirtual 495	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   116: pop
    //   117: aload 10
    //   119: aload_1
    //   120: invokevirtual 495	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   123: pop
    //   124: aload 10
    //   126: ldc_w 960
    //   129: invokevirtual 495	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   132: pop
    //   133: aload 8
    //   135: ifnull +355 -> 490
    //   138: aload 8
    //   140: invokeinterface 963 1 0
    //   145: ifeq +345 -> 490
    //   148: aload 7
    //   150: astore 6
    //   152: aload 8
    //   154: aload 8
    //   156: ldc 232
    //   158: invokeinterface 217 2 0
    //   163: invokeinterface 966 2 0
    //   168: istore 4
    //   170: aload 8
    //   172: aload 8
    //   174: ldc_w 968
    //   177: invokeinterface 217 2 0
    //   182: invokeinterface 969 2 0
    //   187: astore_1
    //   188: iconst_1
    //   189: iload_2
    //   190: if_icmpne +434 -> 624
    //   193: aload_0
    //   194: getfield 291	com/tencent/mobileqq/activity/ChatHistory:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   197: getstatic 974	com/tencent/mobileqq/app/QQManagerFactory:TROOP_MANAGER	I
    //   200: invokevirtual 978	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   203: checkcast 980	com/tencent/mobileqq/app/TroopManager
    //   206: aload_0
    //   207: getfield 297	com/tencent/mobileqq/activity/ChatHistory:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   210: invokevirtual 983	com/tencent/mobileqq/app/TroopManager:n	(Ljava/lang/String;)Z
    //   213: ifeq +378 -> 591
    //   216: aload_0
    //   217: getfield 291	com/tencent/mobileqq/activity/ChatHistory:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   220: aload_0
    //   221: getfield 297	com/tencent/mobileqq/activity/ChatHistory:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   224: aload_1
    //   225: invokestatic 986	com/tencent/mobileqq/utils/ContactUtils:g	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   228: astore_1
    //   229: aload 8
    //   231: aload 8
    //   233: ldc_w 988
    //   236: invokeinterface 217 2 0
    //   241: invokeinterface 966 2 0
    //   246: istore_3
    //   247: iload_3
    //   248: invokestatic 989	com/tencent/mobileqq/service/message/remote/MessageRecordInfo:a	(I)Z
    //   251: ifeq +418 -> 669
    //   254: aload_0
    //   255: invokevirtual 990	com/tencent/mobileqq/activity/ChatHistory:a	()Ljava/lang/String;
    //   258: astore 9
    //   260: aload 8
    //   262: ldc_w 992
    //   265: invokeinterface 217 2 0
    //   270: iflt +23 -> 293
    //   273: aload 8
    //   275: aload 8
    //   277: ldc_w 992
    //   280: invokeinterface 217 2 0
    //   285: invokeinterface 966 2 0
    //   290: ifgt +385 -> 675
    //   293: aload 8
    //   295: aload 8
    //   297: ldc_w 993
    //   300: invokeinterface 217 2 0
    //   305: invokeinterface 969 2 0
    //   310: astore_1
    //   311: aconst_null
    //   312: astore 6
    //   314: aload_1
    //   315: ifnull +17 -> 332
    //   318: new 995	com/tencent/mobileqq/text/QQText
    //   321: dup
    //   322: aload_1
    //   323: iconst_3
    //   324: invokespecial 998	com/tencent/mobileqq/text/QQText:<init>	(Ljava/lang/CharSequence;I)V
    //   327: invokevirtual 1001	com/tencent/mobileqq/text/QQText:toPlainText	()Ljava/lang/String;
    //   330: astore 6
    //   332: aload 6
    //   334: astore 7
    //   336: aload 6
    //   338: ifnull +67 -> 405
    //   341: aload 6
    //   343: astore 7
    //   345: aload 6
    //   347: invokevirtual 414	java/lang/String:length	()I
    //   350: ifle +55 -> 405
    //   353: aload 6
    //   355: astore 7
    //   357: aload_0
    //   358: aload 6
    //   360: invokevirtual 1003	com/tencent/mobileqq/activity/ChatHistory:b	(Ljava/lang/String;)Z
    //   363: ifeq +42 -> 405
    //   366: aload 6
    //   368: ldc_w 1005
    //   371: invokevirtual 1008	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   374: iconst_1
    //   375: aaload
    //   376: ldc_w 1010
    //   379: invokevirtual 1008	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   382: astore 7
    //   384: aload 7
    //   386: arraylength
    //   387: iconst_2
    //   388: if_icmpge +864 -> 1252
    //   391: iconst_1
    //   392: istore_3
    //   393: goto +950 -> 1343
    //   396: aload_0
    //   397: ldc_w 1011
    //   400: invokevirtual 515	com/tencent/mobileqq/activity/ChatHistory:getString	(I)Ljava/lang/String;
    //   403: astore 7
    //   405: new 155	java/lang/StringBuilder
    //   408: dup
    //   409: invokespecial 310	java/lang/StringBuilder:<init>	()V
    //   412: aload_0
    //   413: iload 4
    //   415: i2l
    //   416: ldc2_w 1012
    //   419: lmul
    //   420: invokevirtual 1015	com/tencent/mobileqq/activity/ChatHistory:a	(J)Ljava/lang/String;
    //   423: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   426: ldc_w 1017
    //   429: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   432: aload 9
    //   434: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   437: ldc_w 1019
    //   440: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   443: aload 7
    //   445: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   448: invokevirtual 185	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   451: astore 6
    //   453: aload 10
    //   455: new 155	java/lang/StringBuilder
    //   458: dup
    //   459: invokespecial 310	java/lang/StringBuilder:<init>	()V
    //   462: aload 6
    //   464: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   467: ldc_w 1021
    //   470: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   473: invokevirtual 185	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   476: invokevirtual 495	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   479: pop
    //   480: aload 8
    //   482: invokeinterface 1024 1 0
    //   487: ifne +844 -> 1331
    //   490: aload 8
    //   492: ifnull +10 -> 502
    //   495: aload 8
    //   497: invokeinterface 230 1 0
    //   502: aload_0
    //   503: new 1026	com/tencent/mobileqq/activity/ChatHistory$21
    //   506: dup
    //   507: aload_0
    //   508: getstatic 1031	com/tencent/mobileqq/app/AppConstants:SDCARD_PATH_CHATRECORD	Ljava/lang/String;
    //   511: aload_0
    //   512: getfield 72	com/tencent/mobileqq/activity/ChatHistory:jdField_a_of_type_JavaLangStringBuffer	Ljava/lang/StringBuffer;
    //   515: invokevirtual 504	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   518: aload 10
    //   520: invokevirtual 504	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   523: invokestatic 1036	com/tencent/mobileqq/utils/FileUtils:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z
    //   526: invokespecial 1039	com/tencent/mobileqq/activity/ChatHistory$21:<init>	(Lcom/tencent/mobileqq/activity/ChatHistory;Z)V
    //   529: invokevirtual 1043	com/tencent/mobileqq/activity/ChatHistory:runOnUiThread	(Ljava/lang/Runnable;)V
    //   532: return
    //   533: new 155	java/lang/StringBuilder
    //   536: dup
    //   537: invokespecial 310	java/lang/StringBuilder:<init>	()V
    //   540: ldc_w 1045
    //   543: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   546: invokestatic 165	com/tencent/imcore/message/UinTypeUtil:a	()Ljava/lang/String;
    //   549: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   552: ldc_w 1047
    //   555: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   558: invokevirtual 185	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   561: astore 6
    //   563: aload_1
    //   564: iload_2
    //   565: invokestatic 177	com/tencent/mobileqq/data/MessageRecord:getOldTableName	(Ljava/lang/String;I)Ljava/lang/String;
    //   568: aload_1
    //   569: iload_2
    //   570: invokestatic 180	com/tencent/mobileqq/data/MessageRecord:getTableName	(Ljava/lang/String;I)Ljava/lang/String;
    //   573: aload_0
    //   574: getfield 291	com/tencent/mobileqq/activity/ChatHistory:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   577: invokevirtual 153	com/tencent/mobileqq/app/QQAppInterface:getReadableDatabase	()Lcom/tencent/mobileqq/app/SQLiteDatabase;
    //   580: aload 6
    //   582: aconst_null
    //   583: invokestatic 430	com/tencent/mobileqq/utils/MessageDBUtils:a	(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/app/SQLiteDatabase;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   586: astore 6
    //   588: goto -541 -> 47
    //   591: ldc_w 1049
    //   594: iconst_2
    //   595: anewarray 90	java/lang/Object
    //   598: dup
    //   599: iconst_0
    //   600: aload_0
    //   601: getfield 291	com/tencent/mobileqq/activity/ChatHistory:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   604: aload_0
    //   605: getfield 297	com/tencent/mobileqq/activity/ChatHistory:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   608: aload_1
    //   609: invokestatic 986	com/tencent/mobileqq/utils/ContactUtils:g	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   612: aastore
    //   613: dup
    //   614: iconst_1
    //   615: aload_1
    //   616: aastore
    //   617: invokestatic 1052	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   620: astore_1
    //   621: goto -392 -> 229
    //   624: sipush 3000
    //   627: iload_2
    //   628: if_icmpne +33 -> 661
    //   631: ldc_w 1049
    //   634: iconst_2
    //   635: anewarray 90	java/lang/Object
    //   638: dup
    //   639: iconst_0
    //   640: aload_0
    //   641: getfield 291	com/tencent/mobileqq/activity/ChatHistory:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   644: aload_1
    //   645: iconst_0
    //   646: invokestatic 955	com/tencent/mobileqq/utils/ContactUtils:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;I)Ljava/lang/String;
    //   649: aastore
    //   650: dup
    //   651: iconst_1
    //   652: aload_1
    //   653: aastore
    //   654: invokestatic 1052	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   657: astore_1
    //   658: goto -429 -> 229
    //   661: aload_0
    //   662: getfield 1054	com/tencent/mobileqq/activity/ChatHistory:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   665: astore_1
    //   666: goto -437 -> 229
    //   669: aload_1
    //   670: astore 9
    //   672: goto -412 -> 260
    //   675: aload 8
    //   677: aload 8
    //   679: ldc_w 1056
    //   682: invokeinterface 217 2 0
    //   687: invokeinterface 966 2 0
    //   692: istore 5
    //   694: iload 5
    //   696: sipush -2007
    //   699: if_icmpne +14 -> 713
    //   702: aload_0
    //   703: ldc_w 1057
    //   706: invokevirtual 515	com/tencent/mobileqq/activity/ChatHistory:getString	(I)Ljava/lang/String;
    //   709: astore_1
    //   710: goto -399 -> 311
    //   713: iload 5
    //   715: sipush -2058
    //   718: if_icmpne +14 -> 732
    //   721: aload_0
    //   722: ldc_w 1058
    //   725: invokevirtual 515	com/tencent/mobileqq/activity/ChatHistory:getString	(I)Ljava/lang/String;
    //   728: astore_1
    //   729: goto -418 -> 311
    //   732: iload 5
    //   734: sipush -2039
    //   737: if_icmpne +61 -> 798
    //   740: aload 8
    //   742: aload 8
    //   744: ldc_w 1060
    //   747: invokeinterface 217 2 0
    //   752: invokeinterface 1064 2 0
    //   757: astore_1
    //   758: new 1066	com/tencent/mobileqq/apollo/api/model/MessageForApollo
    //   761: dup
    //   762: invokespecial 1067	com/tencent/mobileqq/apollo/api/model/MessageForApollo:<init>	()V
    //   765: astore 6
    //   767: aload 6
    //   769: aload_1
    //   770: putfield 1070	com/tencent/mobileqq/apollo/api/model/MessageForApollo:msgData	[B
    //   773: aload 6
    //   775: invokevirtual 1073	com/tencent/mobileqq/apollo/api/model/MessageForApollo:parse	()V
    //   778: ldc_w 1075
    //   781: invokestatic 1081	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   784: checkcast 1075	com/tencent/mobileqq/apollo/api/uitls/IApolloUtil
    //   787: aload 6
    //   789: invokeinterface 1085 2 0
    //   794: astore_1
    //   795: goto -484 -> 311
    //   798: iload 5
    //   800: sipush -2011
    //   803: if_icmpne +31 -> 834
    //   806: aload_0
    //   807: aload 8
    //   809: aload 8
    //   811: ldc_w 1060
    //   814: invokeinterface 217 2 0
    //   819: invokeinterface 1064 2 0
    //   824: invokestatic 1090	com/tencent/mobileqq/structmsg/StructMsgFactory:a	([B)Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   827: invokevirtual 1092	com/tencent/mobileqq/activity/ChatHistory:a	(Lcom/tencent/mobileqq/structmsg/AbsStructMsg;)Ljava/lang/String;
    //   830: astore_1
    //   831: goto -520 -> 311
    //   834: iload 5
    //   836: sipush -2020
    //   839: if_icmpne +58 -> 897
    //   842: iload_3
    //   843: invokestatic 989	com/tencent/mobileqq/service/message/remote/MessageRecordInfo:a	(I)Z
    //   846: ifeq +34 -> 880
    //   849: aload_0
    //   850: getfield 291	com/tencent/mobileqq/activity/ChatHistory:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   853: invokevirtual 1096	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   856: ldc_w 1097
    //   859: iconst_1
    //   860: anewarray 90	java/lang/Object
    //   863: dup
    //   864: iconst_0
    //   865: aload_0
    //   866: getfield 877	com/tencent/mobileqq/activity/ChatHistory:jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo	Lcom/tencent/mobileqq/activity/aio/SessionInfo;
    //   869: getfield 1101	com/tencent/mobileqq/activity/aio/SessionInfo:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   872: aastore
    //   873: invokevirtual 1106	com/tencent/qphone/base/util/BaseApplication:getString	(I[Ljava/lang/Object;)Ljava/lang/String;
    //   876: astore_1
    //   877: goto -566 -> 311
    //   880: aload_0
    //   881: getfield 291	com/tencent/mobileqq/activity/ChatHistory:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   884: invokevirtual 1096	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   887: ldc_w 1107
    //   890: invokevirtual 1108	com/tencent/qphone/base/util/BaseApplication:getString	(I)Ljava/lang/String;
    //   893: astore_1
    //   894: goto -583 -> 311
    //   897: iload 5
    //   899: sipush -2006
    //   902: if_icmpne +9 -> 911
    //   905: aload 6
    //   907: astore_1
    //   908: goto -428 -> 480
    //   911: iload 5
    //   913: sipush -2000
    //   916: if_icmpne +13 -> 929
    //   919: ldc_w 1109
    //   922: invokestatic 1113	com/tencent/mobileqq/app/HardCodeUtil:a	(I)Ljava/lang/String;
    //   925: astore_1
    //   926: goto -615 -> 311
    //   929: iload 5
    //   931: sipush -2002
    //   934: if_icmpne +13 -> 947
    //   937: ldc_w 1114
    //   940: invokestatic 1113	com/tencent/mobileqq/app/HardCodeUtil:a	(I)Ljava/lang/String;
    //   943: astore_1
    //   944: goto -633 -> 311
    //   947: iload 5
    //   949: sipush -2022
    //   952: if_icmpne +13 -> 965
    //   955: ldc_w 1115
    //   958: invokestatic 1113	com/tencent/mobileqq/app/HardCodeUtil:a	(I)Ljava/lang/String;
    //   961: astore_1
    //   962: goto -651 -> 311
    //   965: iload 5
    //   967: sipush -2071
    //   970: if_icmpne +14 -> 984
    //   973: aload_0
    //   974: ldc_w 1116
    //   977: invokevirtual 515	com/tencent/mobileqq/activity/ChatHistory:getString	(I)Ljava/lang/String;
    //   980: astore_1
    //   981: goto -670 -> 311
    //   984: iload 5
    //   986: sipush -7001
    //   989: if_icmpne +14 -> 1003
    //   992: aload_0
    //   993: ldc_w 1117
    //   996: invokevirtual 515	com/tencent/mobileqq/activity/ChatHistory:getString	(I)Ljava/lang/String;
    //   999: astore_1
    //   1000: goto -689 -> 311
    //   1003: iload 5
    //   1005: sipush -1035
    //   1008: if_icmpne +202 -> 1210
    //   1011: new 155	java/lang/StringBuilder
    //   1014: dup
    //   1015: invokespecial 310	java/lang/StringBuilder:<init>	()V
    //   1018: astore_1
    //   1019: aload 8
    //   1021: aload 8
    //   1023: ldc_w 1060
    //   1026: invokeinterface 217 2 0
    //   1031: invokeinterface 1064 2 0
    //   1036: astore 7
    //   1038: new 1119	localpb/richMsg/MixedMsg$Msg
    //   1041: dup
    //   1042: invokespecial 1120	localpb/richMsg/MixedMsg$Msg:<init>	()V
    //   1045: astore 6
    //   1047: aload 6
    //   1049: aload 7
    //   1051: invokevirtual 1124	localpb/richMsg/MixedMsg$Msg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   1054: pop
    //   1055: aload 6
    //   1057: getfield 1128	localpb/richMsg/MixedMsg$Msg:elems	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   1060: invokevirtual 1134	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   1063: invokeinterface 1139 1 0
    //   1068: ifgt +51 -> 1119
    //   1071: aload 8
    //   1073: ifnull -541 -> 532
    //   1076: aload 8
    //   1078: invokeinterface 230 1 0
    //   1083: return
    //   1084: astore 6
    //   1086: invokestatic 309	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1089: ifeq +12 -> 1101
    //   1092: ldc 61
    //   1094: iconst_2
    //   1095: ldc_w 1141
    //   1098: invokestatic 318	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1101: aload_1
    //   1102: invokevirtual 185	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1105: astore_1
    //   1106: goto -795 -> 311
    //   1109: astore 7
    //   1111: aload 7
    //   1113: invokevirtual 1144	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:printStackTrace	()V
    //   1116: goto -61 -> 1055
    //   1119: aload 6
    //   1121: getfield 1128	localpb/richMsg/MixedMsg$Msg:elems	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   1124: invokevirtual 1134	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   1127: invokeinterface 1139 1 0
    //   1132: istore 5
    //   1134: iconst_0
    //   1135: istore_3
    //   1136: iload_3
    //   1137: iload 5
    //   1139: if_icmpge -38 -> 1101
    //   1142: aload 6
    //   1144: getfield 1128	localpb/richMsg/MixedMsg$Msg:elems	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   1147: invokevirtual 1134	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   1150: iload_3
    //   1151: invokeinterface 1147 2 0
    //   1156: checkcast 1149	localpb/richMsg/MixedMsg$Elem
    //   1159: astore 7
    //   1161: aload 7
    //   1163: getfield 1153	localpb/richMsg/MixedMsg$Elem:textMsg	Lcom/tencent/mobileqq/pb/PBStringField;
    //   1166: invokevirtual 1158	com/tencent/mobileqq/pb/PBStringField:has	()Z
    //   1169: ifeq +19 -> 1188
    //   1172: aload_1
    //   1173: aload 7
    //   1175: getfield 1153	localpb/richMsg/MixedMsg$Elem:textMsg	Lcom/tencent/mobileqq/pb/PBStringField;
    //   1178: invokevirtual 1160	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   1181: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1184: pop
    //   1185: goto +173 -> 1358
    //   1188: aload 7
    //   1190: getfield 1164	localpb/richMsg/MixedMsg$Elem:picMsg	Llocalpb/richMsg/RichMsg$PicRec;
    //   1193: invokevirtual 1167	localpb/richMsg/RichMsg$PicRec:has	()Z
    //   1196: ifeq +162 -> 1358
    //   1199: aload_1
    //   1200: ldc_w 1169
    //   1203: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1206: pop
    //   1207: goto +151 -> 1358
    //   1210: new 223	java/lang/String
    //   1213: dup
    //   1214: aload 8
    //   1216: aload 8
    //   1218: ldc_w 1060
    //   1221: invokeinterface 217 2 0
    //   1226: invokeinterface 1064 2 0
    //   1231: ldc_w 1171
    //   1234: invokespecial 1174	java/lang/String:<init>	([BLjava/lang/String;)V
    //   1237: astore_1
    //   1238: goto -927 -> 311
    //   1241: astore_1
    //   1242: aload_1
    //   1243: invokevirtual 1175	java/lang/Exception:printStackTrace	()V
    //   1246: aload 6
    //   1248: astore_1
    //   1249: goto -938 -> 311
    //   1252: aload 7
    //   1254: iconst_2
    //   1255: aaload
    //   1256: invokestatic 1180	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   1259: invokevirtual 1183	java/lang/Integer:intValue	()I
    //   1262: istore_3
    //   1263: goto +80 -> 1343
    //   1266: aload 6
    //   1268: astore 7
    //   1270: iload_3
    //   1271: iconst_2
    //   1272: if_icmpne -867 -> 405
    //   1275: new 155	java/lang/StringBuilder
    //   1278: dup
    //   1279: invokespecial 310	java/lang/StringBuilder:<init>	()V
    //   1282: ldc_w 492
    //   1285: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1288: aload_0
    //   1289: ldc_w 1184
    //   1292: invokevirtual 515	com/tencent/mobileqq/activity/ChatHistory:getString	(I)Ljava/lang/String;
    //   1295: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1298: ldc_w 500
    //   1301: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1304: invokevirtual 185	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1307: astore 7
    //   1309: goto -904 -> 405
    //   1312: astore 7
    //   1314: ldc 61
    //   1316: iconst_1
    //   1317: ldc 182
    //   1319: aload 7
    //   1321: invokestatic 1187	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1324: aload 6
    //   1326: astore 7
    //   1328: goto -923 -> 405
    //   1331: aload_1
    //   1332: astore 6
    //   1334: goto -1182 -> 152
    //   1337: aconst_null
    //   1338: astore 8
    //   1340: goto -1270 -> 70
    //   1343: iload_3
    //   1344: iconst_1
    //   1345: if_icmpeq -949 -> 396
    //   1348: iload_3
    //   1349: ldc_w 1188
    //   1352: if_icmpne -86 -> 1266
    //   1355: goto -959 -> 396
    //   1358: iload_3
    //   1359: iconst_1
    //   1360: iadd
    //   1361: istore_3
    //   1362: goto -226 -> 1136
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1365	0	this	ChatHistory
    //   0	1365	1	paramString	String
    //   0	1365	2	paramInt	int
    //   246	1116	3	n	int
    //   168	246	4	i1	int
    //   692	448	5	i2	int
    //   45	1011	6	localObject1	Object
    //   1084	241	6	localException1	Exception
    //   1332	1	6	str1	String
    //   2	1048	7	localObject2	Object
    //   1109	3	7	localInvalidProtocolBufferMicroException	com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException
    //   1159	149	7	localObject3	Object
    //   1312	8	7	localException2	Exception
    //   1326	1	7	localObject4	Object
    //   68	1271	8	localCursor	Cursor
    //   258	413	9	str2	String
    //   11	508	10	localStringBuffer	StringBuffer
    // Exception table:
    //   from	to	target	type
    //   1019	1047	1084	java/lang/Exception
    //   1047	1055	1084	java/lang/Exception
    //   1055	1071	1084	java/lang/Exception
    //   1076	1083	1084	java/lang/Exception
    //   1111	1116	1084	java/lang/Exception
    //   1119	1134	1084	java/lang/Exception
    //   1142	1185	1084	java/lang/Exception
    //   1188	1207	1084	java/lang/Exception
    //   1047	1055	1109	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   1210	1238	1241	java/lang/Exception
    //   384	391	1312	java/lang/Exception
    //   396	405	1312	java/lang/Exception
    //   1252	1263	1312	java/lang/Exception
    //   1275	1309	1312	java/lang/Exception
  }
  
  boolean b(String paramString)
  {
    if (paramString.charAt(0) == '\026')
    {
      paramString = paramString.split("\026")[1].split("\\|");
      if (paramString.length < 2) {
        return true;
      }
      if (paramString.length > 3) {
        try
        {
          Long.valueOf(paramString[1]);
          Integer.valueOf(paramString[2]);
          Boolean.valueOf(paramString[3]);
          return true;
        }
        catch (NumberFormatException paramString)
        {
          return false;
        }
      }
      return false;
    }
    return false;
  }
  
  void c()
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_AndroidViewView = ((RelativeLayout)View.inflate(this, 2131562951, null));
    int n = (int)DisplayUtils.a(this, 6.0F);
    Object localObject = new RelativeLayout(this);
    ((RelativeLayout)localObject).setPadding(0, n, 0, n);
    ((RelativeLayout)localObject).setBackgroundResource(2130850755);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, getResources().getDimensionPixelSize(2131298885));
    ((RelativeLayout)localObject).addView(this.jdField_a_of_type_AndroidViewView, localLayoutParams);
    this.jdField_a_of_type_ComTencentWidgetXListView.addHeaderView((View)localObject);
    this.jdField_a_of_type_AndroidViewView.findViewById(2131363942).setVisibility(8);
    localObject = (EditText)this.jdField_a_of_type_AndroidViewView.findViewById(2131366452);
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
    this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerAudioPlayer.b(3);
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerAudioPlayer.a(paramString);
    if (QLog.isColorLevel()) {
      QLog.i("ChatHistory", 2, "playSource|bRet = " + bool);
    }
    if ((bool) && (this.jdField_a_of_type_AndroidHardwareSensor != null)) {
      this.jdField_a_of_type_AndroidHardwareSensorManager.registerListener(this, this.jdField_a_of_type_AndroidHardwareSensor, 2);
    }
    return bool;
  }
  
  protected void d()
  {
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131368761));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131368762));
    this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(getString(2131690874));
    this.jdField_b_of_type_AndroidWidgetImageView.setContentDescription(getString(2131690873));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new ChatHistory.9(this));
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(new ChatHistory.10(this));
    this.jdField_b_of_type_AndroidWidgetImageView.setEnabled(false);
    this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130849993);
    if (this.jdField_c_of_type_Int == 1)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setEnabled(false);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130840691);
    }
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379114));
    this.jdField_b_of_type_AndroidWidgetTextView.setText(String.valueOf(this.jdField_c_of_type_Int));
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131366126));
    this.jdField_a_of_type_AndroidWidgetEditText.setText(String.valueOf(this.jdField_d_of_type_Int));
    this.jdField_a_of_type_AndroidWidgetEditText.setSelection(this.jdField_a_of_type_AndroidWidgetEditText.getText().toString().length());
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(new ChatHistory.11(this));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131364242));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new ChatHistory.12(this));
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)findViewById(2131364241));
    this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(new ChatHistory.13(this));
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetButton.setVisibility(8);
    }
    if ((this.jdField_a_of_type_Int == 1001) || (this.jdField_a_of_type_Int == 10002) || (this.jdField_a_of_type_Int == 10004) || (this.jdField_a_of_type_Int == 1000) || (this.jdField_a_of_type_Int == 1020) || (this.jdField_a_of_type_Int == 1005) || (this.jdField_a_of_type_Int == 1004) || (this.jdField_a_of_type_Int == 1009) || (this.jdField_a_of_type_Int == 1010) || (this.jdField_a_of_type_Int == 1023) || (this.jdField_a_of_type_Int == 1024) || (this.jdField_a_of_type_Int == 10010)) {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(new ChatHistory.14(this));
      return;
      if ((this.jdField_a_of_type_Int != 1) && (this.jdField_a_of_type_Int != 3000))
      {
        FriendsManager localFriendsManager = (FriendsManager)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER);
        if ((localFriendsManager == null) || (!localFriendsManager.b(String.valueOf(this.jdField_b_of_type_JavaLangString))))
        {
          if (QLog.isColorLevel()) {
            QLog.e("ChatHistory", 2, "--mSyncHistory button: fm is null or the uin is not my friend: fm:" + localFriendsManager);
          }
          this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
        }
      }
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
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    switch (paramInt1)
    {
    }
    do
    {
      return;
      this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$ChatHistoryAdapter.getCursor().requery();
      return;
    } while (-1 != paramInt2);
    a(paramIntent.getExtras());
  }
  
  @TargetApi(14)
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    this.jdField_a_of_type_Float = getResources().getDisplayMetrics().density;
    this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable = ((AnimationDrawable)getResources().getDrawable(2130772365));
    this.jdField_b_of_type_AndroidGraphicsDrawableAnimationDrawable = ((AnimationDrawable)getResources().getDrawable(2130772366));
    this.jdField_c_of_type_AndroidGraphicsDrawableAnimationDrawable = ((AnimationDrawable)getResources().getDrawable(2130772280));
    paramBundle = getIntent().getExtras();
    this.jdField_b_of_type_JavaLangString = paramBundle.getString("uin");
    this.jdField_a_of_type_Int = paramBundle.getInt("uintype");
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = new SessionInfo();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString = paramBundle.getString("troop_uin");
    setContentViewNoTitle(2131558953);
    LinearLayout localLinearLayout = (LinearLayout)findViewById(2131377356);
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      localLinearLayout.setFitsSystemWindows(true);
      localLinearLayout.setPadding(0, ImmersiveUtils.getStatusBarHeight(this), 0, 0);
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
    this.jdField_a_of_type_ComTencentMobileqqUtilImageWorker.a((int)(150.0F * this.jdField_a_of_type_Float), (int)(100.0F * this.jdField_a_of_type_Float));
    s();
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$ChatHistoryAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$ChatHistoryAdapter.a();
    }
    if (this.jdField_a_of_type_AndroidHardwareSensorManager != null) {
      this.jdField_a_of_type_AndroidHardwareSensorManager.unregisterListener(this);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager != null) && (this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.isOpen()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ChatHistory", 2, "ChatHistory : close entityManager.");
      }
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.close();
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = null;
    }
    n();
    r();
    if (QLog.isColorLevel()) {
      QLog.i("ChatHistory", 2, "onDestroy() mCurPlayingPttInfo = " + this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$PlayingPttHistoryInfo);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$PlayingPttHistoryInfo != null) && (!this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$PlayingPttHistoryInfo.jdField_a_of_type_Boolean))
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
      label251:
      findViewById(2131377356).clearAnimation();
      return;
    }
    catch (Exception localException)
    {
      break label251;
    }
  }
  
  public void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    paramIntent = ChatHistoryC2CAllFragment.a(paramIntent);
    if (paramIntent != null) {
      b(paramIntent);
    }
  }
  
  public void doOnPause()
  {
    if (QLog.isColorLevel()) {
      QLog.i("ChatHistory", 2, "onPause() mCurPlayingPttInfo = " + this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$PlayingPttHistoryInfo);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$PlayingPttHistoryInfo != null) && (!this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$PlayingPttHistoryInfo.jdField_a_of_type_Boolean)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$PlayingPttHistoryInfo.d();
    }
    ApngImage.pauseByTag(0);
    ApngImage.pauseAll();
    super.doOnPause();
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    ApngImage.playByTag(0);
    ApngImage.resumeAll();
    if ((this.jdField_a_of_type_Boolean) && (!this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_MqqOsMqqHandler != null))
    {
      this.jdField_b_of_type_Boolean = true;
      this.jdField_a_of_type_MqqOsMqqHandler.postDelayed(new ChatHistory.22(this), 300L);
    }
  }
  
  void e()
  {
    f();
    this.jdField_a_of_type_AndroidWidgetEditText.setText(String.valueOf(this.jdField_d_of_type_Int));
    this.jdField_a_of_type_AndroidWidgetEditText.setSelection(this.jdField_a_of_type_AndroidWidgetEditText.getText().length());
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
    if ((getActivity() == null) || (getActivity().isFinishing())) {
      return;
    }
    if (this.jdField_d_of_type_Int > this.jdField_c_of_type_Int)
    {
      this.jdField_d_of_type_Int = this.jdField_c_of_type_Int;
      this.jdField_e_of_type_Int = ((this.jdField_d_of_type_Int - 1) * 8);
    }
    this.jdField_a_of_type_AndroidWidgetEditText.setText(String.valueOf(this.jdField_d_of_type_Int));
    this.jdField_a_of_type_AndroidWidgetEditText.setSelection(this.jdField_a_of_type_AndroidWidgetEditText.getText().length());
    this.jdField_b_of_type_AndroidWidgetTextView.setText(String.valueOf(this.jdField_c_of_type_Int));
    this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$ChatHistoryAdapter.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Int, this.jdField_e_of_type_Int);
  }
  
  void h()
  {
    this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(4, getResources().getString(2131719537)).sendToTarget();
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
    if (!NetworkUtil.d(this.app.getApplication().getApplicationContext()))
    {
      QQToast.a(getApplicationContext(), 2131691575, 1).a();
      return;
    }
    c(getApplication().getResources().getString(2131691576));
    this.app.getMsgHandler().c(this.jdField_b_of_type_JavaLangString);
  }
  
  void k()
  {
    this.jdField_a_of_type_JavaLangStringBuffer.setLength(0);
    String str;
    if (this.jdField_c_of_type_JavaLangString.compareTo(this.jdField_b_of_type_JavaLangString) == 0)
    {
      str = this.jdField_c_of_type_JavaLangString;
      if (!a(str)) {
        break label196;
      }
      str = str.replaceAll("[\\\\/:*?\"<>|]", "");
      this.jdField_a_of_type_JavaLangStringBuffer.append(str + ".txt");
    }
    for (;;)
    {
      boolean bool = FileUtils.a(AppConstants.SDCARD_PATH_CHATRECORD, this.jdField_a_of_type_JavaLangStringBuffer, ".txt");
      this.jdField_c_of_type_AndroidAppDialog = DialogUtil.a(this, 230, getString(2131691152), getString(2131691152) + AppConstants.SDCARD_PATH_CHATRECORD + this.jdField_a_of_type_JavaLangStringBuffer.toString(), new ChatHistory.17(this), new ChatHistory.18(this));
      if (!bool) {
        break label230;
      }
      this.jdField_c_of_type_AndroidAppDialog.show();
      return;
      str = String.format("%s(%s)", new Object[] { this.jdField_c_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString });
      break;
      label196:
      this.jdField_a_of_type_JavaLangStringBuffer.append(this.jdField_b_of_type_JavaLangString + ".txt");
    }
    label230:
    b(getString(2131692171));
  }
  
  void l()
  {
    this.jdField_c_of_type_AndroidAppDialog = DialogUtil.a(this, 230, getString(2131719538), getString(2131719912), new ChatHistory.19(this), new ChatHistory.20(this));
    this.jdField_c_of_type_AndroidAppDialog.show();
  }
  
  protected void m()
  {
    String str = getResources().getString(2131690865);
    if (this.jdField_a_of_type_Int == 0) {
      if (this.jdField_b_of_type_JavaLangString.equals(String.valueOf(AppConstants.SYSTEM_MSG_UIN)))
      {
        this.jdField_c_of_type_JavaLangString = getResources().getString(2131719683);
        if (!this.jdField_b_of_type_JavaLangString.equals(String.valueOf(AppConstants.SYSTEM_MSG_UIN))) {
          break label377;
        }
        str = getResources().getString(2131719683);
      }
    }
    label377:
    for (;;)
    {
      if ((this.jdField_c_of_type_JavaLangString == null) || (this.jdField_c_of_type_JavaLangString.trim().equals(""))) {
        this.jdField_c_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
      }
      setTitle(str);
      this.jdField_d_of_type_JavaLangString = a();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
      this.leftView = ((TextView)findViewById(2131369487));
      return;
      this.jdField_c_of_type_JavaLangString = ContactUtils.a(this.app, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString, ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int), 3);
      break;
      if (this.jdField_a_of_type_Int == 1)
      {
        this.jdField_c_of_type_JavaLangString = ((TroopManager)this.app.getManager(QQManagerFactory.TROOP_MANAGER)).a(this.jdField_b_of_type_JavaLangString);
      }
      else if ((this.jdField_a_of_type_Int == 1000) || (this.jdField_a_of_type_Int == 1020) || (this.jdField_a_of_type_Int == 1001) || (this.jdField_a_of_type_Int == 10002) || (this.jdField_a_of_type_Int == 10004) || (this.jdField_a_of_type_Int == 1004) || (this.jdField_a_of_type_Int == 10010))
      {
        this.jdField_c_of_type_JavaLangString = ContactUtils.i(this.app, this.jdField_b_of_type_JavaLangString);
      }
      else if (this.jdField_a_of_type_Int == 3000)
      {
        this.jdField_c_of_type_JavaLangString = ContactUtils.d(this.app, this.jdField_b_of_type_JavaLangString);
      }
      else if (this.jdField_a_of_type_Int == 1024)
      {
        PublicAccountInfo localPublicAccountInfo = ((PublicAccountDataManager)this.app.getManager(QQManagerFactory.PUBLICACCOUNTDATA_MANAGER)).b(this.jdField_b_of_type_JavaLangString);
        if (localPublicAccountInfo != null) {
          this.jdField_c_of_type_JavaLangString = localPublicAccountInfo.name;
        }
      }
    }
  }
  
  protected void n()
  {
    if (jdField_a_of_type_AndroidWidgetToast != null)
    {
      jdField_a_of_type_AndroidWidgetToast.cancel();
      jdField_a_of_type_AndroidWidgetToast = null;
    }
  }
  
  protected void o()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerAudioPlayer != null) && (this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerAudioPlayer.a()))
    {
      this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerAudioPlayer.d();
      this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerAudioPlayer = null;
    }
    if (this.jdField_a_of_type_AndroidHardwareSensorManager != null) {
      this.jdField_a_of_type_AndroidHardwareSensorManager.unregisterListener(this);
    }
    setVolumeControlStream(3);
  }
  
  public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public boolean onBackEvent()
  {
    try
    {
      if (this.jdField_a_of_type_AndroidWidgetEditText != null) {
        InputMethodUtil.b(this.jdField_a_of_type_AndroidWidgetEditText);
      }
      setResult(-1);
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchMessageSearchDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchMessageSearchDialog.a()))
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchMessageSearchDialog.show();
        this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchMessageSearchDialog.a(false);
        return true;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
    return super.onBackEvent();
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public View onCreateRightView()
  {
    super.onCreateRightView();
    TextView localTextView = this.rightViewText;
    if ((3000 == this.jdField_a_of_type_Int) || (1 == this.jdField_a_of_type_Int)) {
      this.rightViewText.setVisibility(8);
    }
    for (;;)
    {
      localTextView.setText(2131718637);
      this.jdField_a_of_type_AndroidWidgetTextView = localTextView;
      return localTextView;
      this.rightViewText.setVisibility(0);
    }
  }
  
  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    boolean bool2 = true;
    if (DeviceInfoUtil.h()) {}
    boolean bool1;
    label26:
    label61:
    do
    {
      return;
      if (paramSensorEvent.values[0] >= this.jdField_b_of_type_Float) {
        break;
      }
      bool1 = true;
      if (this.jdField_e_of_type_Boolean == bool1) {
        break label93;
      }
      this.jdField_e_of_type_Boolean = bool1;
      if (this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerAudioPlayer != null)
      {
        paramSensorEvent = this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerAudioPlayer;
        if (this.jdField_e_of_type_Boolean) {
          break label95;
        }
        bool1 = bool2;
        paramSensorEvent.a(bool1);
      }
    } while (AppSetting.jdField_d_of_type_Boolean);
    if (this.jdField_e_of_type_Boolean) {}
    for (int n = 2131719526;; n = 2131719528)
    {
      b(n);
      return;
      bool1 = false;
      break label26;
      label93:
      break;
      label95:
      bool1 = false;
      break label61;
    }
  }
  
  void p()
  {
    AudioUtil.b(2131230731, false);
  }
  
  protected void q()
  {
    this.jdField_a_of_type_AndroidHardwareSensorManager = ((SensorManager)this.app.getApplication().getSystemService("sensor"));
    this.jdField_a_of_type_AndroidHardwareSensor = this.jdField_a_of_type_AndroidHardwareSensorManager.getDefaultSensor(8);
    if (this.jdField_a_of_type_AndroidHardwareSensor != null)
    {
      this.jdField_b_of_type_Float = this.jdField_a_of_type_AndroidHardwareSensor.getMaximumRange();
      if (this.jdField_b_of_type_Float <= 10.0F) {
        break label72;
      }
    }
    label72:
    for (float f1 = 10.0F;; f1 = this.jdField_b_of_type_Float)
    {
      this.jdField_b_of_type_Float = f1;
      return;
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
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  protected void s()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) {
      switch (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int)
      {
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ChatHistory", 2, "AIO_chatlog arg:" + this.k);
      }
      ReportController.b(this.app, "CliOper", "", "", "AIO", "AIO_chatlog", this.k, 0, String.valueOf(this.k), "", "", "");
      return;
      this.k = 0;
      continue;
      this.k = 3;
      continue;
      this.k = 2;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatHistory
 * JD-Core Version:    0.7.0.1
 */