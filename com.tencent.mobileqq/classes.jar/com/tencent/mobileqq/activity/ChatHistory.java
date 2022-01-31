package com.tencent.mobileqq.activity;

import ActionMsg.MsgBody;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.app.Dialog;
import android.content.Intent;
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
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.AudioPlayer;
import com.tencent.mobileqq.activity.aio.AudioPlayer.AudioPlayerListener;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.messagesearch.MessageSearchDialog;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.MessageRoamManager;
import com.tencent.mobileqq.app.PublicAccountDataManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SQLiteDatabase;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.message.MsgProxyUtils;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.ProxyObserver;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.emoticonview.PicEmoticonInfo;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.persistence.qslowtable.QSlowTableManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.transfile.TransfileUtile;
import com.tencent.mobileqq.util.ImageCache;
import com.tencent.mobileqq.util.ImageWorker;
import com.tencent.mobileqq.utils.ActionMsgUtil;
import com.tencent.mobileqq.utils.AudioUtil;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.MessageDBUtils;
import com.tencent.mobileqq.utils.MsgUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.TipsBar;
import com.tencent.qphone.base.util.QLog;
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
import ryg;
import ryi;
import ryj;
import ryk;
import ryl;
import rym;
import ryn;
import ryo;
import ryq;
import rys;
import ryt;
import ryu;
import ryv;
import ryx;
import rza;
import rzb;
import rzc;
import rzd;
import rze;
import rzg;
import rzh;
import rzi;
import rzj;
import rzk;
import rzl;
import rzm;

public class ChatHistory
  extends IphoneTitleBarActivity
  implements SensorEventListener
{
  protected static Toast a;
  public float a;
  public int a;
  public long a;
  public Dialog a;
  AnimationDrawable jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable = null;
  protected Sensor a;
  public SensorManager a;
  Handler.Callback jdField_a_of_type_AndroidOsHandler$Callback = new ryg(this);
  public Handler a;
  View jdField_a_of_type_AndroidViewView;
  protected Button a;
  public EditText a;
  public ImageView a;
  public TextView a;
  public ChatHistory.ChatHistoryAdapter a;
  ChatHistory.HistoryItemOnlongClickListener jdField_a_of_type_ComTencentMobileqqActivityChatHistory$HistoryItemOnlongClickListener = new ChatHistory.HistoryItemOnlongClickListener(this);
  public ChatHistory.PlayingPttHistoryInfo a;
  protected AudioPlayer.AudioPlayerListener a;
  protected AudioPlayer a;
  public SessionInfo a;
  public MessageSearchDialog a;
  protected MessageObserver a;
  protected ProxyObserver a;
  protected EntityManager a;
  public QSlowTableManager a;
  ImageWorker jdField_a_of_type_ComTencentMobileqqUtilImageWorker;
  public QQProgressDialog a;
  public TipsBar a;
  AbsListView.OnScrollListener jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener = new rzd(this);
  public XListView a;
  protected Object a;
  final String jdField_a_of_type_JavaLangString = "ChatHistory";
  protected StringBuffer a;
  public MqqHandler a;
  protected boolean a;
  protected float b;
  protected int b;
  public long b;
  public Dialog b;
  AnimationDrawable jdField_b_of_type_AndroidGraphicsDrawableAnimationDrawable = null;
  protected Button b;
  public ImageView b;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  protected QQProgressDialog b;
  public String b;
  protected boolean b;
  public int c;
  public Dialog c;
  protected AnimationDrawable c;
  public TextView c;
  public String c;
  protected boolean c;
  public int d;
  public String d;
  public boolean d;
  public int e;
  protected boolean e;
  int f;
  int g;
  int h;
  int i;
  final int j = 60;
  public int k = 999;
  public int l = 0;
  public int m;
  
  public ChatHistory()
  {
    this.jdField_a_of_type_JavaLangStringBuffer = new StringBuffer();
    this.jdField_d_of_type_Int = 1;
    this.jdField_e_of_type_Int = 0;
    this.jdField_b_of_type_Long = 0L;
    this.jdField_a_of_type_JavaLangObject = new Object();
    this.jdField_a_of_type_ComTencentMobileqqPersistenceQslowtableQSlowTableManager = null;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_a_of_type_MqqOsMqqHandler = new MqqWeakReferenceHandler(this.jdField_a_of_type_AndroidOsHandler$Callback);
    this.jdField_a_of_type_AndroidOsHandler = new ryu(this);
    this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver = new rza(this);
    this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyObserver = new rzb(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer$AudioPlayerListener = new rzc(this);
  }
  
  public static final int a(QQAppInterface paramQQAppInterface, String paramString, int paramInt, StringBuilder paramStringBuilder)
  {
    if (paramQQAppInterface == null) {
      return 0;
    }
    SQLiteDatabase localSQLiteDatabase = paramQQAppInterface.b();
    if (localSQLiteDatabase == null) {
      return 0;
    }
    if (paramInt == 0)
    {
      paramQQAppInterface = new StringBuilder(" msgtype ");
      paramQQAppInterface.append(MsgProxyUtils.b());
      paramQQAppInterface.append(" and isValid=1 ");
    }
    for (paramQQAppInterface = MessageDBUtils.a(MessageRecord.getOldTableName(paramString, paramInt), MessageRecord.getTableName(paramString, paramInt), localSQLiteDatabase, "", paramQQAppInterface.toString(), ""); paramQQAppInterface == null; paramQQAppInterface = MessageDBUtils.a(MessageRecord.getOldTableName(paramString, paramInt), MessageRecord.getTableName(paramString, paramInt), localSQLiteDatabase, paramQQAppInterface.toString()))
    {
      return 0;
      paramQQAppInterface = new StringBuilder(" where msgtype ");
      paramQQAppInterface.append(MsgProxyUtils.b());
      paramQQAppInterface.append(" and isValid=1 ");
    }
    paramQQAppInterface = localSQLiteDatabase.a(paramQQAppInterface.toString(), null);
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
  
  protected MsgBody a(int paramInt1, int paramInt2, String paramString, int paramInt3)
  {
    if (((paramInt2 != -1003) && (paramInt2 != -1032) && (paramInt2 != -1031) && (paramInt2 != 201)) || ((paramInt1 == 1001) || (paramInt1 == 10002) || (ActionMsgUtil.a(paramInt2)) || (paramInt2 == -3001) || (paramInt2 == -30002) || (paramInt2 == -30003))) {
      return ActionMsgUtil.a(paramString);
    }
    if (paramInt2 == -2009)
    {
      localMsgBody = new MsgBody();
      boolean bool = MsgUtils.b(paramInt3);
      localMsgBody.msg = MsgUtils.a(TransfileUtile.a(paramString), this, bool, false);
      localMsgBody.action = null;
      return localMsgBody;
    }
    if (paramInt2 == -2016)
    {
      localMsgBody = new MsgBody();
      localMsgBody.msg = MsgUtils.a(this.app, TransfileUtile.a(paramString), this, this.jdField_b_of_type_JavaLangString, null, this.jdField_a_of_type_Int);
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
    SQLiteDatabase localSQLiteDatabase = this.app.b();
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
        paramString2 = localSQLiteDatabase.a(paramString2.toString(), null);
        paramString1 = paramString2;
      }
      catch (SQLException paramString2)
      {
        paramString1 = localSQLiteDatabase.a(paramString1, null, paramString3, null, null, null);
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
          paramString2 = localSQLiteDatabase.a(paramString2.toString(), null);
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
            paramString2 = localSQLiteDatabase.a(paramString1, null, paramString3, null, null, null);
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
            paramString2 = localSQLiteDatabase.a(paramString2.toString(), null);
            paramString1 = paramString2;
          }
          catch (SQLException paramString2)
          {
            paramString1 = localSQLiteDatabase.a(paramString1, null, paramString3, null, null, null);
          }
          continue;
        }
        paramString2 = MessageDBUtils.a(paramString2, paramString1, localSQLiteDatabase, paramString3, null);
        if (paramString2 != null) {
          try
          {
            paramString2 = localSQLiteDatabase.a(paramString2.toString(), null);
            paramString1 = paramString2;
          }
          catch (SQLException paramString2)
          {
            paramString1 = localSQLiteDatabase.a(paramString1, null, paramString3, null, null, null);
          }
        } else {
          paramString1 = null;
        }
      }
    }
  }
  
  protected EntityManager a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager == null) || (!this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a())) {}
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager == null) || (!this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a())) {
        this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = this.app.getEntityManagerFactory().createMessageRecordEntityManager();
      }
      return this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager;
    }
  }
  
  protected String a()
  {
    String str = ContactUtils.j(this.app, this.app.getCurrentAccountUin());
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
        localStringBuffer.append(" " + getString(2131436442) + " ");
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
    this.jdField_a_of_type_ComTencentMobileqqWidgetTipsBar = new TipsBar(getActivity());
    this.jdField_a_of_type_ComTencentMobileqqWidgetTipsBar.setBarType(4);
    this.jdField_a_of_type_ComTencentMobileqqWidgetTipsBar.setTipsIcon(getActivity().getResources().getDrawable(2130837754));
    localRelativeLayout.addView(this.jdField_a_of_type_ComTencentMobileqqWidgetTipsBar, localLayoutParams);
    this.jdField_a_of_type_ComTencentWidgetXListView.addHeaderView(localRelativeLayout);
    this.jdField_a_of_type_ComTencentMobileqqWidgetTipsBar.setOnClickListener(new rzg(this));
    this.jdField_c_of_type_AndroidWidgetTextView = this.jdField_a_of_type_ComTencentMobileqqWidgetTipsBar.a();
    this.jdField_a_of_type_ComTencentMobileqqWidgetTipsBar.setVisibility(8);
  }
  
  public void a(int paramInt)
  {
    if (paramInt > 0)
    {
      Cursor localCursor = this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$ChatHistoryAdapter.getCursor();
      if (localCursor != null) {
        localCursor.requery();
      }
    }
    if ((this.jdField_a_of_type_Int == 0) && (((CheckBox)this.jdField_b_of_type_AndroidAppDialog.findViewById(2131364268)).isChecked()))
    {
      j();
      this.app.a().a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Int);
    }
  }
  
  public void a(int paramInt1, int paramInt2)
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
  
  public void a(int paramInt, String paramString)
  {
    QQToast.a(this, paramInt, paramString, 0).b(getTitleBarHeight());
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    ThreadManager.getSubThreadHandler().post(new rzl(this, paramBoolean, paramInt));
  }
  
  protected void a(Bundle paramBundle)
  {
    Intent localIntent = AIOUtils.a(new Intent(this, SplashActivity.class), null);
    localIntent.putExtras(new Bundle(paramBundle));
    startActivity(localIntent);
  }
  
  public void a(Message paramMessage)
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
    if ((paramImageView != null) && (paramPicEmoticonInfo != null) && (paramPicEmoticonInfo.a()))
    {
      paramPicEmoticonInfo = paramPicEmoticonInfo.a("fromAIO", true);
      Drawable localDrawable = paramImageView.getDrawable();
      if ((localDrawable instanceof URLDrawable)) {
        PicEmoticonInfo.b((URLDrawable)localDrawable);
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
      localActionSheet.a(getResources().getString(2131430175));
      localActionSheet.a(2131434041, 3);
      localActionSheet.c(2131433015);
      localActionSheet.a(new rze(this, paramMessageRecord, localActionSheet));
      localActionSheet.show();
      return;
      label110:
      QLog.d("Q.msg.delmsg", 2, "startDelMsg is called,mr is null");
    }
  }
  
  public void a(String paramString)
  {
    View localView = getLayoutInflater().inflate(2130968919, null);
    if (1 == this.jdField_a_of_type_Int)
    {
      ((TextView)localView.findViewById(2131362961)).setText(2131433701);
      localView.findViewById(2131364268).setVisibility(8);
    }
    for (;;)
    {
      if (!isFinishing())
      {
        this.jdField_b_of_type_AndroidAppDialog = DialogUtil.a(this, 230).setTitle(getString(2131433673)).setPositiveButton(getString(2131434041), new ryo(this, paramString)).setNegativeButton(getString(2131433699), new ryn(this)).addView(localView);
        this.jdField_b_of_type_AndroidAppDialog.show();
      }
      return;
      if (3000 == this.jdField_a_of_type_Int)
      {
        ((TextView)localView.findViewById(2131362961)).setText(2131433702);
        localView.findViewById(2131364268).setVisibility(8);
      }
      else if ((1001 == this.jdField_a_of_type_Int) || (10002 == this.jdField_a_of_type_Int) || (1000 == this.jdField_a_of_type_Int) || (10004 == this.jdField_a_of_type_Int) || (1020 == this.jdField_a_of_type_Int) || (1004 == this.jdField_a_of_type_Int))
      {
        localView.findViewById(2131364268).setVisibility(8);
      }
    }
  }
  
  @SuppressLint({"NewApi"})
  protected void a(String paramString, int paramInt)
  {
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)findViewById(2131363754));
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
  
  public boolean a(int paramInt)
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
  
  public void b()
  {
    View localView1 = findViewById(2131363753);
    View localView2 = findViewById(2131362840);
    int n = localView1.getHeight();
    this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchMessageSearchDialog = new MessageSearchDialog(this, this.app, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    TranslateAnimation localTranslateAnimation1 = new TranslateAnimation(0.0F, 0.0F, 0.0F, -n);
    localTranslateAnimation1.setDuration(200L);
    localTranslateAnimation1.setFillAfter(true);
    TranslateAnimation localTranslateAnimation2 = new TranslateAnimation(0.0F, 0.0F, -n, 0.0F);
    localTranslateAnimation2.setDuration(200L);
    localTranslateAnimation1.setAnimationListener(new rzh(this, localView2, localView1));
    localTranslateAnimation2.setAnimationListener(new rzi(this, localView2, n));
    this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchMessageSearchDialog.setOnDismissListener(new rzj(this, localView2, n, localView1, localTranslateAnimation2));
    localView2.startAnimation(localTranslateAnimation1);
  }
  
  public void b(int paramInt)
  {
    QQToast.a(getActivity(), paramInt, 0).b(getResources().getDimensionPixelSize(2131558448));
  }
  
  protected void b(ImageView paramImageView)
  {
    if (paramImageView != null)
    {
      this.jdField_c_of_type_AndroidGraphicsDrawableAnimationDrawable.stop();
      paramImageView.setImageDrawable(getResources().getDrawable(2130843978));
    }
  }
  
  protected void b(ImageView paramImageView, PicEmoticonInfo paramPicEmoticonInfo)
  {
    if ((paramImageView != null) && (paramPicEmoticonInfo != null) && (paramPicEmoticonInfo.a()))
    {
      paramPicEmoticonInfo = paramPicEmoticonInfo.a("fromAIO", true);
      if ((paramPicEmoticonInfo instanceof URLDrawable)) {
        PicEmoticonInfo.a((URLDrawable)paramPicEmoticonInfo);
      }
      paramImageView.setImageDrawable(paramPicEmoticonInfo);
    }
  }
  
  public void b(String paramString)
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
  public void b(String paramString, int paramInt)
  {
    // Byte code:
    //   0: ldc 173
    //   2: astore 7
    //   4: new 65	java/lang/StringBuffer
    //   7: dup
    //   8: invokespecial 66	java/lang/StringBuffer:<init>	()V
    //   11: astore 10
    //   13: iload_2
    //   14: iconst_1
    //   15: if_icmpeq +10 -> 25
    //   18: iload_2
    //   19: sipush 3000
    //   22: if_icmpne +514 -> 536
    //   25: aload_1
    //   26: iload_2
    //   27: invokestatic 168	com/tencent/mobileqq/data/MessageRecord:getOldTableName	(Ljava/lang/String;I)Ljava/lang/String;
    //   30: aload_1
    //   31: iload_2
    //   32: invokestatic 171	com/tencent/mobileqq/data/MessageRecord:getTableName	(Ljava/lang/String;I)Ljava/lang/String;
    //   35: aload_0
    //   36: getfield 306	com/tencent/mobileqq/activity/ChatHistory:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   39: invokevirtual 144	com/tencent/mobileqq/app/QQAppInterface:b	()Lcom/tencent/mobileqq/app/SQLiteDatabase;
    //   42: invokestatic 907	com/tencent/mobileqq/utils/MessageDBUtils:a	(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/app/SQLiteDatabase;)Ljava/lang/StringBuilder;
    //   45: astore 6
    //   47: aload 6
    //   49: ifnull +1224 -> 1273
    //   52: aload_0
    //   53: getfield 306	com/tencent/mobileqq/activity/ChatHistory:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   56: invokevirtual 144	com/tencent/mobileqq/app/QQAppInterface:b	()Lcom/tencent/mobileqq/app/SQLiteDatabase;
    //   59: aload 6
    //   61: invokevirtual 176	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   64: aconst_null
    //   65: invokevirtual 191	com/tencent/mobileqq/app/SQLiteDatabase:a	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   68: astore 8
    //   70: iload_2
    //   71: iconst_1
    //   72: if_icmpne +61 -> 133
    //   75: aload_0
    //   76: getfield 306	com/tencent/mobileqq/activity/ChatHistory:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   79: aload_1
    //   80: iconst_1
    //   81: invokestatic 910	com/tencent/mobileqq/utils/ContactUtils:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;I)Ljava/lang/String;
    //   84: astore_1
    //   85: aload 10
    //   87: new 146	java/lang/StringBuilder
    //   90: dup
    //   91: invokespecial 332	java/lang/StringBuilder:<init>	()V
    //   94: aload_0
    //   95: ldc_w 911
    //   98: invokevirtual 452	com/tencent/mobileqq/activity/ChatHistory:getString	(I)Ljava/lang/String;
    //   101: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: ldc_w 913
    //   107: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: invokevirtual 176	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   113: invokevirtual 431	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   116: pop
    //   117: aload 10
    //   119: aload_1
    //   120: invokevirtual 431	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   123: pop
    //   124: aload 10
    //   126: ldc_w 915
    //   129: invokevirtual 431	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   132: pop
    //   133: aload 8
    //   135: ifnull +358 -> 493
    //   138: aload 8
    //   140: invokeinterface 918 1 0
    //   145: ifeq +348 -> 493
    //   148: aload 7
    //   150: astore 6
    //   152: aload 8
    //   154: aload 8
    //   156: ldc 222
    //   158: invokeinterface 207 2 0
    //   163: invokeinterface 921 2 0
    //   168: istore 4
    //   170: aload 8
    //   172: aload 8
    //   174: ldc_w 923
    //   177: invokeinterface 207 2 0
    //   182: invokeinterface 924 2 0
    //   187: astore_1
    //   188: iconst_1
    //   189: iload_2
    //   190: if_icmpne +437 -> 627
    //   193: aload_0
    //   194: getfield 306	com/tencent/mobileqq/activity/ChatHistory:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   197: aload_0
    //   198: getfield 308	com/tencent/mobileqq/activity/ChatHistory:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   201: invokestatic 930	com/tencent/mobileqq/data/TroopInfo:isQidianPrivateTroop	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;)Z
    //   204: ifeq +390 -> 594
    //   207: aload_0
    //   208: getfield 306	com/tencent/mobileqq/activity/ChatHistory:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   211: aload_0
    //   212: getfield 308	com/tencent/mobileqq/activity/ChatHistory:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   215: aload_1
    //   216: invokestatic 933	com/tencent/mobileqq/utils/ContactUtils:g	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   219: astore_1
    //   220: aload 8
    //   222: aload 8
    //   224: ldc_w 935
    //   227: invokeinterface 207 2 0
    //   232: invokeinterface 921 2 0
    //   237: istore_3
    //   238: iload_3
    //   239: invokestatic 936	com/tencent/mobileqq/utils/MsgUtils:a	(I)Z
    //   242: ifeq +430 -> 672
    //   245: aload_0
    //   246: invokevirtual 938	com/tencent/mobileqq/activity/ChatHistory:a	()Ljava/lang/String;
    //   249: astore 9
    //   251: aload 8
    //   253: ldc_w 940
    //   256: invokeinterface 207 2 0
    //   261: iflt +23 -> 284
    //   264: aload 8
    //   266: aload 8
    //   268: ldc_w 940
    //   271: invokeinterface 207 2 0
    //   276: invokeinterface 921 2 0
    //   281: ifgt +397 -> 678
    //   284: aload 8
    //   286: aload 8
    //   288: ldc_w 941
    //   291: invokeinterface 207 2 0
    //   296: invokeinterface 924 2 0
    //   301: astore_1
    //   302: aconst_null
    //   303: astore 6
    //   305: aload_1
    //   306: ifnull +17 -> 323
    //   309: new 943	com/tencent/mobileqq/text/QQText
    //   312: dup
    //   313: aload_1
    //   314: iconst_3
    //   315: invokespecial 946	com/tencent/mobileqq/text/QQText:<init>	(Ljava/lang/CharSequence;I)V
    //   318: invokevirtual 947	com/tencent/mobileqq/text/QQText:a	()Ljava/lang/String;
    //   321: astore 6
    //   323: aload 6
    //   325: astore 7
    //   327: aload 6
    //   329: ifnull +76 -> 405
    //   332: aload 6
    //   334: astore 7
    //   336: aload 6
    //   338: invokevirtual 350	java/lang/String:length	()I
    //   341: ifle +64 -> 405
    //   344: aload 6
    //   346: astore 7
    //   348: aload_0
    //   349: aload 6
    //   351: invokevirtual 949	com/tencent/mobileqq/activity/ChatHistory:b	(Ljava/lang/String;)Z
    //   354: ifeq +51 -> 405
    //   357: aload 6
    //   359: ldc_w 951
    //   362: invokevirtual 954	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   365: iconst_1
    //   366: aaload
    //   367: ldc_w 956
    //   370: invokevirtual 954	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   373: astore 7
    //   375: aload 7
    //   377: arraylength
    //   378: iconst_2
    //   379: if_icmpge +834 -> 1213
    //   382: iconst_1
    //   383: istore_3
    //   384: iload_3
    //   385: iconst_1
    //   386: if_icmpeq +10 -> 396
    //   389: iload_3
    //   390: ldc_w 957
    //   393: if_icmpne +834 -> 1227
    //   396: aload_0
    //   397: ldc_w 958
    //   400: invokevirtual 452	com/tencent/mobileqq/activity/ChatHistory:getString	(I)Ljava/lang/String;
    //   403: astore 7
    //   405: new 146	java/lang/StringBuilder
    //   408: dup
    //   409: invokespecial 332	java/lang/StringBuilder:<init>	()V
    //   412: aload_0
    //   413: iload 4
    //   415: i2l
    //   416: ldc2_w 959
    //   419: lmul
    //   420: invokevirtual 962	com/tencent/mobileqq/activity/ChatHistory:a	(J)Ljava/lang/String;
    //   423: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   426: ldc_w 964
    //   429: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   432: aload 9
    //   434: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   437: ldc_w 966
    //   440: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   443: aload 7
    //   445: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   448: invokevirtual 176	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   451: astore 6
    //   453: aload 10
    //   455: new 146	java/lang/StringBuilder
    //   458: dup
    //   459: invokespecial 332	java/lang/StringBuilder:<init>	()V
    //   462: aload 6
    //   464: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   467: ldc_w 968
    //   470: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   473: invokevirtual 176	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   476: invokevirtual 431	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   479: pop
    //   480: aload_1
    //   481: astore 6
    //   483: aload 8
    //   485: invokeinterface 971 1 0
    //   490: ifne -338 -> 152
    //   493: aload 8
    //   495: ifnull +10 -> 505
    //   498: aload 8
    //   500: invokeinterface 220 1 0
    //   505: aload_0
    //   506: new 973	ryw
    //   509: dup
    //   510: aload_0
    //   511: getstatic 978	com/tencent/mobileqq/app/AppConstants:aK	Ljava/lang/String;
    //   514: aload_0
    //   515: getfield 68	com/tencent/mobileqq/activity/ChatHistory:jdField_a_of_type_JavaLangStringBuffer	Ljava/lang/StringBuffer;
    //   518: invokevirtual 440	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   521: aload 10
    //   523: invokevirtual 440	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   526: invokestatic 983	com/tencent/mobileqq/utils/FileUtils:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z
    //   529: invokespecial 986	ryw:<init>	(Lcom/tencent/mobileqq/activity/ChatHistory;Z)V
    //   532: invokevirtual 990	com/tencent/mobileqq/activity/ChatHistory:runOnUiThread	(Ljava/lang/Runnable;)V
    //   535: return
    //   536: new 146	java/lang/StringBuilder
    //   539: dup
    //   540: invokespecial 332	java/lang/StringBuilder:<init>	()V
    //   543: ldc_w 992
    //   546: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   549: invokestatic 156	com/tencent/mobileqq/app/message/MsgProxyUtils:b	()Ljava/lang/String;
    //   552: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   555: ldc_w 994
    //   558: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   561: invokevirtual 176	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   564: astore 6
    //   566: aload_1
    //   567: iload_2
    //   568: invokestatic 168	com/tencent/mobileqq/data/MessageRecord:getOldTableName	(Ljava/lang/String;I)Ljava/lang/String;
    //   571: aload_1
    //   572: iload_2
    //   573: invokestatic 171	com/tencent/mobileqq/data/MessageRecord:getTableName	(Ljava/lang/String;I)Ljava/lang/String;
    //   576: aload_0
    //   577: getfield 306	com/tencent/mobileqq/activity/ChatHistory:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   580: invokevirtual 144	com/tencent/mobileqq/app/QQAppInterface:b	()Lcom/tencent/mobileqq/app/SQLiteDatabase;
    //   583: aload 6
    //   585: aconst_null
    //   586: invokestatic 366	com/tencent/mobileqq/utils/MessageDBUtils:a	(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/app/SQLiteDatabase;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   589: astore 6
    //   591: goto -544 -> 47
    //   594: ldc_w 996
    //   597: iconst_2
    //   598: anewarray 84	java/lang/Object
    //   601: dup
    //   602: iconst_0
    //   603: aload_0
    //   604: getfield 306	com/tencent/mobileqq/activity/ChatHistory:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   607: aload_0
    //   608: getfield 308	com/tencent/mobileqq/activity/ChatHistory:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   611: aload_1
    //   612: invokestatic 933	com/tencent/mobileqq/utils/ContactUtils:g	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   615: aastore
    //   616: dup
    //   617: iconst_1
    //   618: aload_1
    //   619: aastore
    //   620: invokestatic 999	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   623: astore_1
    //   624: goto -404 -> 220
    //   627: sipush 3000
    //   630: iload_2
    //   631: if_icmpne +33 -> 664
    //   634: ldc_w 996
    //   637: iconst_2
    //   638: anewarray 84	java/lang/Object
    //   641: dup
    //   642: iconst_0
    //   643: aload_0
    //   644: getfield 306	com/tencent/mobileqq/activity/ChatHistory:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   647: aload_1
    //   648: iconst_0
    //   649: invokestatic 910	com/tencent/mobileqq/utils/ContactUtils:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;I)Ljava/lang/String;
    //   652: aastore
    //   653: dup
    //   654: iconst_1
    //   655: aload_1
    //   656: aastore
    //   657: invokestatic 999	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   660: astore_1
    //   661: goto -441 -> 220
    //   664: aload_0
    //   665: getfield 1001	com/tencent/mobileqq/activity/ChatHistory:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   668: astore_1
    //   669: goto -449 -> 220
    //   672: aload_1
    //   673: astore 9
    //   675: goto -424 -> 251
    //   678: aload 8
    //   680: aload 8
    //   682: ldc_w 1003
    //   685: invokeinterface 207 2 0
    //   690: invokeinterface 921 2 0
    //   695: istore 5
    //   697: iload 5
    //   699: sipush -2007
    //   702: if_icmpne +14 -> 716
    //   705: aload_0
    //   706: ldc_w 1004
    //   709: invokevirtual 452	com/tencent/mobileqq/activity/ChatHistory:getString	(I)Ljava/lang/String;
    //   712: astore_1
    //   713: goto -411 -> 302
    //   716: iload 5
    //   718: sipush -2058
    //   721: if_icmpne +14 -> 735
    //   724: aload_0
    //   725: ldc_w 1005
    //   728: invokevirtual 452	com/tencent/mobileqq/activity/ChatHistory:getString	(I)Ljava/lang/String;
    //   731: astore_1
    //   732: goto -430 -> 302
    //   735: iload 5
    //   737: sipush -2039
    //   740: if_icmpne +50 -> 790
    //   743: aload 8
    //   745: aload 8
    //   747: ldc_w 1007
    //   750: invokeinterface 207 2 0
    //   755: invokeinterface 1011 2 0
    //   760: astore_1
    //   761: new 1013	com/tencent/mobileqq/data/MessageForApollo
    //   764: dup
    //   765: invokespecial 1014	com/tencent/mobileqq/data/MessageForApollo:<init>	()V
    //   768: astore 6
    //   770: aload 6
    //   772: aload_1
    //   773: putfield 1017	com/tencent/mobileqq/data/MessageForApollo:msgData	[B
    //   776: aload 6
    //   778: invokevirtual 1020	com/tencent/mobileqq/data/MessageForApollo:parse	()V
    //   781: aload 6
    //   783: invokestatic 1025	com/tencent/mobileqq/apollo/utils/ApolloUtil:a	(Lcom/tencent/mobileqq/data/MessageForApollo;)Ljava/lang/String;
    //   786: astore_1
    //   787: goto -485 -> 302
    //   790: iload 5
    //   792: sipush -2011
    //   795: if_icmpne +31 -> 826
    //   798: aload_0
    //   799: aload 8
    //   801: aload 8
    //   803: ldc_w 1007
    //   806: invokeinterface 207 2 0
    //   811: invokeinterface 1011 2 0
    //   816: invokestatic 1030	com/tencent/mobileqq/structmsg/StructMsgFactory:a	([B)Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   819: invokevirtual 1032	com/tencent/mobileqq/activity/ChatHistory:a	(Lcom/tencent/mobileqq/structmsg/AbsStructMsg;)Ljava/lang/String;
    //   822: astore_1
    //   823: goto -521 -> 302
    //   826: iload 5
    //   828: sipush -2020
    //   831: if_icmpne +58 -> 889
    //   834: iload_3
    //   835: invokestatic 936	com/tencent/mobileqq/utils/MsgUtils:a	(I)Z
    //   838: ifeq +34 -> 872
    //   841: aload_0
    //   842: getfield 306	com/tencent/mobileqq/activity/ChatHistory:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   845: invokevirtual 1036	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   848: ldc_w 1037
    //   851: iconst_1
    //   852: anewarray 84	java/lang/Object
    //   855: dup
    //   856: iconst_0
    //   857: aload_0
    //   858: getfield 833	com/tencent/mobileqq/activity/ChatHistory:jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo	Lcom/tencent/mobileqq/activity/aio/SessionInfo;
    //   861: getfield 1041	com/tencent/mobileqq/activity/aio/SessionInfo:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   864: aastore
    //   865: invokevirtual 1046	com/tencent/qphone/base/util/BaseApplication:getString	(I[Ljava/lang/Object;)Ljava/lang/String;
    //   868: astore_1
    //   869: goto -567 -> 302
    //   872: aload_0
    //   873: getfield 306	com/tencent/mobileqq/activity/ChatHistory:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   876: invokevirtual 1036	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   879: ldc_w 1047
    //   882: invokevirtual 1048	com/tencent/qphone/base/util/BaseApplication:getString	(I)Ljava/lang/String;
    //   885: astore_1
    //   886: goto -584 -> 302
    //   889: aload 6
    //   891: astore_1
    //   892: iload 5
    //   894: sipush -2006
    //   897: if_icmpeq -417 -> 480
    //   900: iload 5
    //   902: sipush -2000
    //   905: if_icmpne +10 -> 915
    //   908: ldc_w 1050
    //   911: astore_1
    //   912: goto -610 -> 302
    //   915: iload 5
    //   917: sipush -2002
    //   920: if_icmpne +10 -> 930
    //   923: ldc_w 1052
    //   926: astore_1
    //   927: goto -625 -> 302
    //   930: iload 5
    //   932: sipush -2022
    //   935: if_icmpne +10 -> 945
    //   938: ldc_w 1054
    //   941: astore_1
    //   942: goto -640 -> 302
    //   945: iload 5
    //   947: sipush -7001
    //   950: if_icmpne +14 -> 964
    //   953: aload_0
    //   954: ldc_w 1055
    //   957: invokevirtual 452	com/tencent/mobileqq/activity/ChatHistory:getString	(I)Ljava/lang/String;
    //   960: astore_1
    //   961: goto -659 -> 302
    //   964: iload 5
    //   966: sipush -1035
    //   969: if_icmpne +202 -> 1171
    //   972: new 146	java/lang/StringBuilder
    //   975: dup
    //   976: invokespecial 332	java/lang/StringBuilder:<init>	()V
    //   979: astore_1
    //   980: aload 8
    //   982: aload 8
    //   984: ldc_w 1007
    //   987: invokeinterface 207 2 0
    //   992: invokeinterface 1011 2 0
    //   997: astore 7
    //   999: new 1057	localpb/richMsg/MixedMsg$Msg
    //   1002: dup
    //   1003: invokespecial 1058	localpb/richMsg/MixedMsg$Msg:<init>	()V
    //   1006: astore 6
    //   1008: aload 6
    //   1010: aload 7
    //   1012: invokevirtual 1062	localpb/richMsg/MixedMsg$Msg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   1015: pop
    //   1016: aload 6
    //   1018: getfield 1066	localpb/richMsg/MixedMsg$Msg:elems	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   1021: invokevirtual 1072	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   1024: invokeinterface 1077 1 0
    //   1029: ifgt +51 -> 1080
    //   1032: aload 8
    //   1034: ifnull -499 -> 535
    //   1037: aload 8
    //   1039: invokeinterface 220 1 0
    //   1044: return
    //   1045: astore 6
    //   1047: invokestatic 321	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1050: ifeq +12 -> 1062
    //   1053: ldc 61
    //   1055: iconst_2
    //   1056: ldc_w 1079
    //   1059: invokestatic 1081	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1062: aload_1
    //   1063: invokevirtual 176	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1066: astore_1
    //   1067: goto -765 -> 302
    //   1070: astore 7
    //   1072: aload 7
    //   1074: invokevirtual 1084	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:printStackTrace	()V
    //   1077: goto -61 -> 1016
    //   1080: aload 6
    //   1082: getfield 1066	localpb/richMsg/MixedMsg$Msg:elems	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   1085: invokevirtual 1072	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   1088: invokeinterface 1077 1 0
    //   1093: istore 5
    //   1095: iconst_0
    //   1096: istore_3
    //   1097: iload_3
    //   1098: iload 5
    //   1100: if_icmpge -38 -> 1062
    //   1103: aload 6
    //   1105: getfield 1066	localpb/richMsg/MixedMsg$Msg:elems	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   1108: invokevirtual 1072	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   1111: iload_3
    //   1112: invokeinterface 1087 2 0
    //   1117: checkcast 1089	localpb/richMsg/MixedMsg$Elem
    //   1120: astore 7
    //   1122: aload 7
    //   1124: getfield 1093	localpb/richMsg/MixedMsg$Elem:textMsg	Lcom/tencent/mobileqq/pb/PBStringField;
    //   1127: invokevirtual 1098	com/tencent/mobileqq/pb/PBStringField:has	()Z
    //   1130: ifeq +19 -> 1149
    //   1133: aload_1
    //   1134: aload 7
    //   1136: getfield 1093	localpb/richMsg/MixedMsg$Elem:textMsg	Lcom/tencent/mobileqq/pb/PBStringField;
    //   1139: invokevirtual 1100	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   1142: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1145: pop
    //   1146: goto +133 -> 1279
    //   1149: aload 7
    //   1151: getfield 1104	localpb/richMsg/MixedMsg$Elem:picMsg	Llocalpb/richMsg/RichMsg$PicRec;
    //   1154: invokevirtual 1107	localpb/richMsg/RichMsg$PicRec:has	()Z
    //   1157: ifeq +122 -> 1279
    //   1160: aload_1
    //   1161: ldc_w 1050
    //   1164: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1167: pop
    //   1168: goto +111 -> 1279
    //   1171: new 213	java/lang/String
    //   1174: dup
    //   1175: aload 8
    //   1177: aload 8
    //   1179: ldc_w 1007
    //   1182: invokeinterface 207 2 0
    //   1187: invokeinterface 1011 2 0
    //   1192: ldc_w 1109
    //   1195: invokespecial 1112	java/lang/String:<init>	([BLjava/lang/String;)V
    //   1198: astore_1
    //   1199: goto -897 -> 302
    //   1202: astore_1
    //   1203: aload_1
    //   1204: invokevirtual 1113	java/lang/Exception:printStackTrace	()V
    //   1207: aload 6
    //   1209: astore_1
    //   1210: goto -908 -> 302
    //   1213: aload 7
    //   1215: iconst_2
    //   1216: aaload
    //   1217: invokestatic 1118	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   1220: invokevirtual 1121	java/lang/Integer:intValue	()I
    //   1223: istore_3
    //   1224: goto -840 -> 384
    //   1227: aload 6
    //   1229: astore 7
    //   1231: iload_3
    //   1232: iconst_2
    //   1233: if_icmpne -828 -> 405
    //   1236: new 146	java/lang/StringBuilder
    //   1239: dup
    //   1240: invokespecial 332	java/lang/StringBuilder:<init>	()V
    //   1243: ldc_w 428
    //   1246: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1249: aload_0
    //   1250: ldc_w 1122
    //   1253: invokevirtual 452	com/tencent/mobileqq/activity/ChatHistory:getString	(I)Ljava/lang/String;
    //   1256: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1259: ldc_w 436
    //   1262: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1265: invokevirtual 176	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1268: astore 7
    //   1270: goto -865 -> 405
    //   1273: aconst_null
    //   1274: astore 8
    //   1276: goto -1206 -> 70
    //   1279: iload_3
    //   1280: iconst_1
    //   1281: iadd
    //   1282: istore_3
    //   1283: goto -186 -> 1097
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1286	0	this	ChatHistory
    //   0	1286	1	paramString	String
    //   0	1286	2	paramInt	int
    //   237	1046	3	n	int
    //   168	246	4	i1	int
    //   695	406	5	i2	int
    //   45	972	6	localObject1	Object
    //   1045	183	6	localException	Exception
    //   2	1009	7	localObject2	Object
    //   1070	3	7	localInvalidProtocolBufferMicroException	com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException
    //   1120	149	7	localObject3	Object
    //   68	1207	8	localCursor	Cursor
    //   249	425	9	str	String
    //   11	511	10	localStringBuffer	StringBuffer
    // Exception table:
    //   from	to	target	type
    //   980	1008	1045	java/lang/Exception
    //   1008	1016	1045	java/lang/Exception
    //   1016	1032	1045	java/lang/Exception
    //   1037	1044	1045	java/lang/Exception
    //   1072	1077	1045	java/lang/Exception
    //   1080	1095	1045	java/lang/Exception
    //   1103	1146	1045	java/lang/Exception
    //   1149	1168	1045	java/lang/Exception
    //   1008	1016	1070	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   1171	1199	1202	java/lang/Exception
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
    this.jdField_a_of_type_AndroidViewView = ((RelativeLayout)View.inflate(this, 2130971517, null));
    int n = (int)DisplayUtils.a(this, 6.0F);
    Object localObject = new RelativeLayout(this);
    ((RelativeLayout)localObject).setPadding(0, n, 0, n);
    ((RelativeLayout)localObject).setBackgroundResource(2130845986);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, getResources().getDimensionPixelSize(2131558583));
    ((RelativeLayout)localObject).addView(this.jdField_a_of_type_AndroidViewView, localLayoutParams);
    this.jdField_a_of_type_ComTencentWidgetXListView.addHeaderView((View)localObject);
    this.jdField_a_of_type_AndroidViewView.findViewById(2131368321).setVisibility(8);
    localObject = (EditText)this.jdField_a_of_type_AndroidViewView.findViewById(2131368322);
    ((EditText)localObject).setFocusableInTouchMode(false);
    ((EditText)localObject).setCursorVisible(false);
    ((EditText)localObject).setOnClickListener(new rzk(this));
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
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer == null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer = new AudioPlayer(this, this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer$AudioPlayerListener);
    }
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.a(paramString);
    if (QLog.isColorLevel()) {
      QLog.i("ChatHistory", 2, "playSource|bRet = " + bool);
    }
    if ((bool) && (this.jdField_a_of_type_AndroidHardwareSensor != null)) {
      this.jdField_a_of_type_AndroidHardwareSensorManager.registerListener(this, this.jdField_a_of_type_AndroidHardwareSensor, 2);
    }
    return bool;
  }
  
  public void d()
  {
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131363759));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131363763));
    this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(getString(2131437142));
    this.jdField_b_of_type_AndroidWidgetImageView.setContentDescription(getString(2131437143));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new rzm(this));
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(new ryi(this));
    this.jdField_b_of_type_AndroidWidgetImageView.setEnabled(false);
    this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130845465);
    if (this.jdField_c_of_type_Int == 1)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setEnabled(false);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130839268);
    }
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131363762));
    this.jdField_b_of_type_AndroidWidgetTextView.setText(String.valueOf(this.jdField_c_of_type_Int));
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131363760));
    this.jdField_a_of_type_AndroidWidgetEditText.setText(String.valueOf(this.jdField_d_of_type_Int));
    this.jdField_a_of_type_AndroidWidgetEditText.setSelection(this.jdField_a_of_type_AndroidWidgetEditText.getText().toString().length());
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(new ryj(this));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131363764));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new ryk(this));
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)findViewById(2131363765));
    this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(new ryl(this));
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetButton.setVisibility(8);
    }
    if ((this.jdField_a_of_type_Int == 1001) || (this.jdField_a_of_type_Int == 10002) || (this.jdField_a_of_type_Int == 10004) || (this.jdField_a_of_type_Int == 1000) || (this.jdField_a_of_type_Int == 1020) || (this.jdField_a_of_type_Int == 1005) || (this.jdField_a_of_type_Int == 1004) || (this.jdField_a_of_type_Int == 1009) || (this.jdField_a_of_type_Int == 1010) || (this.jdField_a_of_type_Int == 1023) || (this.jdField_a_of_type_Int == 1024)) {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(new rym(this));
      return;
      if ((this.jdField_a_of_type_Int != 1) && (this.jdField_a_of_type_Int != 3000))
      {
        FriendsManager localFriendsManager = (FriendsManager)this.app.getManager(50);
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
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
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
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    this.jdField_a_of_type_Float = getResources().getDisplayMetrics().density;
    this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable = ((AnimationDrawable)getResources().getDrawable(2131034416));
    this.jdField_b_of_type_AndroidGraphicsDrawableAnimationDrawable = ((AnimationDrawable)getResources().getDrawable(2131034417));
    this.jdField_c_of_type_AndroidGraphicsDrawableAnimationDrawable = ((AnimationDrawable)getResources().getDrawable(2131034356));
    paramBundle = getIntent().getExtras();
    this.jdField_b_of_type_JavaLangString = paramBundle.getString("uin");
    this.jdField_a_of_type_Int = paramBundle.getInt("uintype");
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = new SessionInfo();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString = paramBundle.getString("troop_uin");
    setContentViewNoTitle(2130968781);
    LinearLayout localLinearLayout = (LinearLayout)findViewById(2131362840);
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      localLinearLayout.setFitsSystemWindows(true);
      localLinearLayout.setPadding(0, ImmersiveUtils.a(this), 0, 0);
    }
    boolean bool = paramBundle.getBoolean("from_RecentSaidActivity", false);
    this.jdField_a_of_type_Boolean = bool;
    if (bool) {
      this.jdField_a_of_type_Long = paramBundle.getLong("target_shmsgseq");
    }
    init(getIntent());
    this.app.setHandler(getClass(), this.jdField_a_of_type_MqqOsMqqHandler);
    this.jdField_a_of_type_ComTencentMobileqqPersistenceQslowtableQSlowTableManager = ((QSlowTableManager)this.app.getManager(200));
    a(9, false);
    m();
    a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Int);
    q();
    if (this.app.a() != null) {
      this.app.a().a(this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyObserver);
    }
    this.app.a().f();
    this.jdField_a_of_type_ComTencentMobileqqUtilImageWorker = new ImageWorker(this);
    this.jdField_a_of_type_ComTencentMobileqqUtilImageWorker.a((int)(150.0F * this.jdField_a_of_type_Float), (int)(100.0F * this.jdField_a_of_type_Float));
    s();
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$ChatHistoryAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$ChatHistoryAdapter.a();
    }
    if (this.jdField_a_of_type_AndroidHardwareSensorManager != null) {
      this.jdField_a_of_type_AndroidHardwareSensorManager.unregisterListener(this);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager != null) && (this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ChatHistory", 2, "ChatHistory : close entityManager.");
      }
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a();
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
    if (this.app.a() != null) {
      this.app.a().b(this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyObserver);
    }
    this.app.a().f();
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilImageWorker.a().a();
      label251:
      findViewById(2131362840).clearAnimation();
      return;
    }
    catch (Exception localException)
    {
      break label251;
    }
  }
  
  protected void doOnPause()
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
  
  protected void doOnResume()
  {
    super.doOnResume();
    ApngImage.playByTag(0);
    ApngImage.resumeAll();
    if ((this.jdField_a_of_type_Boolean) && (!this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_MqqOsMqqHandler != null))
    {
      this.jdField_b_of_type_Boolean = true;
      this.jdField_a_of_type_MqqOsMqqHandler.postDelayed(new ryx(this), 300L);
    }
  }
  
  public void e()
  {
    f();
    this.jdField_a_of_type_AndroidWidgetEditText.setText(String.valueOf(this.jdField_d_of_type_Int));
    this.jdField_a_of_type_AndroidWidgetEditText.setSelection(this.jdField_a_of_type_AndroidWidgetEditText.getText().length());
    this.jdField_b_of_type_AndroidWidgetTextView.setText(String.valueOf(this.jdField_c_of_type_Int));
    this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$ChatHistoryAdapter.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Int, this.jdField_e_of_type_Int);
  }
  
  public void f()
  {
    this.jdField_d_of_type_Int = this.jdField_c_of_type_Int;
    this.jdField_e_of_type_Int = ((this.jdField_d_of_type_Int - 1) * 8);
  }
  
  public void finish()
  {
    super.finish();
  }
  
  public void g()
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
  
  public void h()
  {
    this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(4, getResources().getString(2131433842)).sendToTarget();
    this.app.a().a((short)1, (byte)1);
  }
  
  public void i()
  {
    MessageRoamManager localMessageRoamManager = (MessageRoamManager)this.app.getManager(91);
    if (localMessageRoamManager != null)
    {
      long l1 = NetConnInfoCenter.getServerTime();
      this.app.a().a(this.jdField_b_of_type_JavaLangString, l1 - 604800L, 0L, l1, (short)0, 0L, 1, null, localMessageRoamManager.b(), false, 0, false);
    }
  }
  
  protected void j()
  {
    if (!NetworkUtil.d(this.app.getApplication().getApplicationContext()))
    {
      QQToast.a(getApplicationContext(), 2131434481, 1).a();
      return;
    }
    c(getApplication().getResources().getString(2131434482));
    this.app.a().c(this.jdField_b_of_type_JavaLangString);
  }
  
  public void k()
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
      boolean bool = FileUtils.a(AppConstants.aK, this.jdField_a_of_type_JavaLangStringBuffer, ".txt");
      this.jdField_c_of_type_AndroidAppDialog = DialogUtil.a(this, 230, getString(2131433705), getString(2131433705) + AppConstants.aK + this.jdField_a_of_type_JavaLangStringBuffer.toString(), new ryq(this), new rys(this));
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
    b(getString(2131433707));
  }
  
  public void l()
  {
    this.jdField_c_of_type_AndroidAppDialog = DialogUtil.a(this, 230, getString(2131433844), getString(2131433845), new ryt(this), new ryv(this));
    this.jdField_c_of_type_AndroidAppDialog.show();
  }
  
  protected void m()
  {
    String str = getResources().getString(2131433649);
    if (this.jdField_a_of_type_Int == 0) {
      if (this.jdField_b_of_type_JavaLangString.equals(String.valueOf(AppConstants.F)))
      {
        this.jdField_c_of_type_JavaLangString = getResources().getString(2131434943);
        if (!this.jdField_b_of_type_JavaLangString.equals(String.valueOf(AppConstants.F))) {
          break label365;
        }
        str = getResources().getString(2131434943);
      }
    }
    label365:
    for (;;)
    {
      if ((this.jdField_c_of_type_JavaLangString == null) || (this.jdField_c_of_type_JavaLangString.trim().equals(""))) {
        this.jdField_c_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
      }
      setTitle(str);
      this.jdField_d_of_type_JavaLangString = a();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
      this.leftView = ((TextView)findViewById(2131363245));
      return;
      this.jdField_c_of_type_JavaLangString = ContactUtils.a(this.app, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString, ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int), 3);
      break;
      if (this.jdField_a_of_type_Int == 1)
      {
        this.jdField_c_of_type_JavaLangString = ((TroopManager)this.app.getManager(51)).a(this.jdField_b_of_type_JavaLangString);
      }
      else if ((this.jdField_a_of_type_Int == 1000) || (this.jdField_a_of_type_Int == 1020) || (this.jdField_a_of_type_Int == 1001) || (this.jdField_a_of_type_Int == 10002) || (this.jdField_a_of_type_Int == 10004) || (this.jdField_a_of_type_Int == 1004))
      {
        this.jdField_c_of_type_JavaLangString = ContactUtils.k(this.app, this.jdField_b_of_type_JavaLangString);
      }
      else if (this.jdField_a_of_type_Int == 3000)
      {
        this.jdField_c_of_type_JavaLangString = ContactUtils.d(this.app, this.jdField_b_of_type_JavaLangString);
      }
      else if (this.jdField_a_of_type_Int == 1024)
      {
        PublicAccountInfo localPublicAccountInfo = ((PublicAccountDataManager)this.app.getManager(55)).b(this.jdField_b_of_type_JavaLangString);
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
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.a()))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.c();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer = null;
    }
    if (this.jdField_a_of_type_AndroidHardwareSensorManager != null) {
      this.jdField_a_of_type_AndroidHardwareSensorManager.unregisterListener(this);
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
  
  protected View onCreateRightView()
  {
    super.onCreateRightView();
    TextView localTextView = this.rightViewText;
    if ((3000 == this.jdField_a_of_type_Int) || (1 == this.jdField_a_of_type_Int)) {
      this.rightViewText.setVisibility(8);
    }
    for (;;)
    {
      localTextView.setText(2131433846);
      this.jdField_a_of_type_AndroidWidgetTextView = localTextView;
      return localTextView;
      this.rightViewText.setVisibility(0);
    }
  }
  
  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    boolean bool2 = true;
    if (AIOUtils.b()) {}
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
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer != null)
      {
        paramSensorEvent = this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer;
        if (this.jdField_e_of_type_Boolean) {
          break label95;
        }
        bool1 = bool2;
        paramSensorEvent.a(bool1);
      }
    } while (AppSetting.jdField_b_of_type_Boolean);
    if (this.jdField_e_of_type_Boolean) {}
    for (int n = 2131433887;; n = 2131433888)
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
  
  public void p()
  {
    AudioUtil.b(2131230730, false);
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
  
  public void r()
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