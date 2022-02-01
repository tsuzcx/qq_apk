package com.tencent.mobileqq.activity;

import ActionMsg.MsgBody;
import Override;
import acnh;
import adnr;
import adnt;
import adnu;
import adnv;
import adnw;
import adnx;
import adny;
import adnz;
import adoa;
import adob;
import adoc;
import adod;
import adoe;
import adof;
import adog;
import adoh;
import adoi;
import adoj;
import adol;
import adom;
import adon;
import adoo;
import adop;
import adoq;
import ador;
import adpa;
import adpc;
import afpx;
import akda;
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
import anvk;
import anyz;
import anzc;
import aoan;
import atlf;
import azil;
import bdla;
import bgzj;
import bgzn;
import bhca;
import bhcl;
import bhdj;
import bhdz;
import bhff;
import bhfj;
import bisl;
import bkxz;
import bkyc;
import bkzi;
import bkzz;
import com.tencent.common.config.AppSetting;
import com.tencent.image.ApngImage;
import com.tencent.image.URLDrawable;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.AudioPlayer;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.history.ChatHistoryC2CAllFragment;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.SQLiteDatabase;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.ProxyObserver;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.emoticonview.PicEmoticonInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.transfile.TransfileUtile;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.TipsBar;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView.OnScrollListener;
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
  public float a;
  public int a;
  protected long a;
  public ador a;
  public adpa a;
  public adpc a;
  protected afpx a;
  public akda a;
  public Dialog a;
  public AnimationDrawable a;
  protected Sensor a;
  public SensorManager a;
  Handler.Callback jdField_a_of_type_AndroidOsHandler$Callback = new adnr(this);
  public Handler a;
  View jdField_a_of_type_AndroidViewView;
  protected Button a;
  public EditText a;
  public ImageView a;
  public TextView a;
  protected anyz a;
  public azil a;
  bgzn jdField_a_of_type_Bgzn;
  public bisl a;
  protected AudioPlayer a;
  public SessionInfo a;
  protected ProxyObserver a;
  protected EntityManager a;
  public TipsBar a;
  AbsListView.OnScrollListener jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener = new adoi(this);
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
  public AnimationDrawable b;
  protected Button b;
  public ImageView b;
  TextView b;
  protected bisl b;
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
  public int f;
  public int g;
  public int h;
  public int i;
  final int j = 60;
  public int k = 999;
  int l = 0;
  public int m;
  
  public ChatHistory()
  {
    this.jdField_a_of_type_JavaLangStringBuffer = new StringBuffer();
    this.jdField_d_of_type_Int = 1;
    this.jdField_e_of_type_Int = 0;
    this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable = null;
    this.jdField_b_of_type_AndroidGraphicsDrawableAnimationDrawable = null;
    this.jdField_b_of_type_Long = 0L;
    this.jdField_a_of_type_JavaLangObject = new Object();
    this.jdField_a_of_type_Azil = null;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_a_of_type_MqqOsMqqHandler = new bkyc(this.jdField_a_of_type_AndroidOsHandler$Callback);
    this.jdField_a_of_type_AndroidOsHandler = new adod(this);
    this.jdField_a_of_type_Adpa = new adpa(this);
    this.jdField_a_of_type_Anyz = new adof(this);
    this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyObserver = new adog(this);
    this.jdField_a_of_type_Afpx = new adoh(this);
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
      paramQQAppInterface.append(acnh.b());
      paramQQAppInterface.append(" and isValid=1 ");
    }
    for (paramQQAppInterface = bhff.a(MessageRecord.getOldTableName(paramString, paramInt), MessageRecord.getTableName(paramString, paramInt), localSQLiteDatabase, "", paramQQAppInterface.toString(), ""); paramQQAppInterface == null; paramQQAppInterface = bhff.a(MessageRecord.getOldTableName(paramString, paramInt), MessageRecord.getTableName(paramString, paramInt), localSQLiteDatabase, paramQQAppInterface.toString()))
    {
      return 0;
      paramQQAppInterface = new StringBuilder(" where msgtype ");
      paramQQAppInterface.append(acnh.b());
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
    c(this.app.getMessageFacade().queryMsgRecordIndex(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Int, paramMessageRecord));
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
    this.jdField_a_of_type_Ador.jdField_c_of_type_Int = ((paramInt - 1) % 8);
    this.jdField_a_of_type_AndroidWidgetEditText.setText(String.valueOf(n));
    this.jdField_a_of_type_AndroidWidgetEditText.setSelection(this.jdField_a_of_type_AndroidWidgetEditText.getText().length());
  }
  
  public MsgBody a(int paramInt1, int paramInt2, String paramString, int paramInt3)
  {
    if (((paramInt2 != -1003) && (paramInt2 != -1032) && (paramInt2 != -1031) && (paramInt2 != 201)) || ((paramInt1 == 1001) || (paramInt1 == 10002) || (bhca.a(paramInt2)) || (paramInt2 == -3001) || (paramInt2 == -30002) || (paramInt2 == -30003))) {
      return bhca.a(paramString);
    }
    if (paramInt2 == -2009)
    {
      localMsgBody = new MsgBody();
      boolean bool = bhfj.b(paramInt3);
      localMsgBody.msg = bhfj.a(TransfileUtile.analysisTransFileProtocolData(paramString), this, bool, false);
      localMsgBody.action = null;
      return localMsgBody;
    }
    if (paramInt2 == -2016)
    {
      localMsgBody = new MsgBody();
      localMsgBody.msg = bhfj.a(this.app, TransfileUtile.analysisTransFileProtocolData(paramString), this, this.jdField_b_of_type_JavaLangString, null, this.jdField_a_of_type_Int);
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
      paramString2 = bhff.b(paramString2, paramString1, localSQLiteDatabase, paramString3);
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
          paramString2 = bhff.b(paramString2, paramString1, localSQLiteDatabase, paramString3);
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
        paramString2 = bhff.a(paramString2, paramString1, localSQLiteDatabase, paramString3, null);
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
  
  public EntityManager a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager == null) || (!this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.isOpen())) {}
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager == null) || (!this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.isOpen())) {
        this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = this.app.getEntityManagerFactory().createMessageRecordEntityManager();
      }
      return this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager;
    }
  }
  
  protected String a()
  {
    String str = ContactUtils.getAccountNickName(this.app, this.app.getCurrentAccountUin());
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
  
  public String a(AbsStructMsg paramAbsStructMsg)
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
        localStringBuffer.append(" " + getString(2131719005) + " ");
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
    this.jdField_a_of_type_ComTencentMobileqqWidgetTipsBar.setTipsIcon(getActivity().getResources().getDrawable(2130838319));
    localRelativeLayout.addView(this.jdField_a_of_type_ComTencentMobileqqWidgetTipsBar, localLayoutParams);
    this.jdField_a_of_type_ComTencentWidgetXListView.addHeaderView(localRelativeLayout);
    this.jdField_a_of_type_ComTencentMobileqqWidgetTipsBar.setOnClickListener(new adol(this));
    this.jdField_c_of_type_AndroidWidgetTextView = this.jdField_a_of_type_ComTencentMobileqqWidgetTipsBar.a();
    this.jdField_a_of_type_ComTencentMobileqqWidgetTipsBar.setVisibility(8);
  }
  
  public void a(int paramInt)
  {
    if (paramInt > 0)
    {
      Cursor localCursor = this.jdField_a_of_type_Ador.getCursor();
      if (localCursor != null) {
        localCursor.requery();
      }
    }
    if ((this.jdField_a_of_type_Int == 0) && (((CheckBox)this.jdField_b_of_type_AndroidAppDialog.findViewById(2131365467)).isChecked()))
    {
      j();
      this.app.getFileManagerDataCenter().a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Int);
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
    ThreadManager.getSubThreadHandler().post(new ChatHistory.8(this, paramBoolean, paramInt));
  }
  
  protected void a(Bundle paramBundle)
  {
    Intent localIntent = AIOUtils.setOpenAIOIntent(new Intent(this, SplashActivity.class), null);
    localIntent.putExtras(new Bundle(paramBundle));
    startActivity(localIntent);
  }
  
  public void a(Message paramMessage)
  {
    this.jdField_a_of_type_MqqOsMqqHandler.sendMessageDelayed(paramMessage, 0L);
  }
  
  public void a(ImageView paramImageView)
  {
    if (paramImageView != null)
    {
      this.jdField_c_of_type_AndroidGraphicsDrawableAnimationDrawable.setBounds(0, 0, this.jdField_c_of_type_AndroidGraphicsDrawableAnimationDrawable.getMinimumWidth(), this.jdField_c_of_type_AndroidGraphicsDrawableAnimationDrawable.getMinimumHeight());
      paramImageView.setImageDrawable(this.jdField_c_of_type_AndroidGraphicsDrawableAnimationDrawable);
      this.jdField_c_of_type_AndroidGraphicsDrawableAnimationDrawable.stop();
      this.jdField_c_of_type_AndroidGraphicsDrawableAnimationDrawable.start();
    }
  }
  
  public void a(ImageView paramImageView, PicEmoticonInfo paramPicEmoticonInfo)
  {
    if ((paramImageView != null) && (paramPicEmoticonInfo != null) && (paramPicEmoticonInfo.isSound()))
    {
      paramPicEmoticonInfo = paramPicEmoticonInfo.getLoadingDrawable("fromAIO", true);
      Drawable localDrawable = paramImageView.getDrawable();
      if ((localDrawable instanceof URLDrawable)) {
        PicEmoticonInfo.stopSoundDrawablePlay((URLDrawable)localDrawable);
      }
      paramImageView.setImageDrawable(paramPicEmoticonInfo);
    }
  }
  
  public void a(MessageRecord paramMessageRecord)
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
      bkzi localbkzi = (bkzi)bkzz.a(this, null);
      localbkzi.a(getResources().getString(2131695830));
      localbkzi.a(2131691448, 3);
      localbkzi.c(2131690697);
      localbkzi.a(new adoj(this, paramMessageRecord, localbkzi));
      localbkzi.show();
      return;
      label110:
      QLog.d("Q.msg.delmsg", 2, "startDelMsg is called,mr is null");
    }
  }
  
  public void a(String paramString)
  {
    View localView = getLayoutInflater().inflate(2131559119, null);
    if (1 == this.jdField_a_of_type_Int)
    {
      ((TextView)localView.findViewById(2131378673)).setText(2131691041);
      localView.findViewById(2131365467).setVisibility(8);
    }
    for (;;)
    {
      if (!isFinishing())
      {
        this.jdField_b_of_type_AndroidAppDialog = bhdj.a(this, 230).setTitle(getString(2131691464)).setPositiveButton(getString(2131691448), new adnz(this, paramString)).setNegativeButton(getString(2131690677), new adny(this)).addView(localView);
        this.jdField_b_of_type_AndroidAppDialog.show();
      }
      return;
      if (3000 == this.jdField_a_of_type_Int)
      {
        ((TextView)localView.findViewById(2131378673)).setText(2131691040);
        localView.findViewById(2131365467).setVisibility(8);
      }
      else if ((1001 == this.jdField_a_of_type_Int) || (10002 == this.jdField_a_of_type_Int) || (1000 == this.jdField_a_of_type_Int) || (10004 == this.jdField_a_of_type_Int) || (1020 == this.jdField_a_of_type_Int) || (1004 == this.jdField_a_of_type_Int) || (10010 == this.jdField_a_of_type_Int))
      {
        localView.findViewById(2131365467).setVisibility(8);
      }
    }
  }
  
  @SuppressLint({"NewApi"})
  protected void a(String paramString, int paramInt)
  {
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)findViewById(2131370189));
    c();
    a();
    this.jdField_a_of_type_Ador = new ador(this, this, null);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Ador);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnScrollListener(this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener);
    this.jdField_a_of_type_ComTencentWidgetXListView.setEdgeEffectEnabled(false);
    if (Build.VERSION.SDK_INT >= 9) {
      this.jdField_a_of_type_ComTencentWidgetXListView.setOverscrollFooter(null);
    }
    this.jdField_a_of_type_Ador.a(paramString, paramInt, this.jdField_e_of_type_Int);
  }
  
  boolean a(int paramInt)
  {
    if ((paramInt <= 0) || (paramInt > this.jdField_c_of_type_Int * 8)) {
      return false;
    }
    this.jdField_b_of_type_Boolean = true;
    int n = (paramInt - 1) / 8;
    this.jdField_a_of_type_Ador.jdField_c_of_type_Int = ((paramInt - 1) % 8);
    this.jdField_a_of_type_AndroidWidgetEditText.setText(String.valueOf(n + 1));
    this.jdField_a_of_type_AndroidWidgetEditText.setSelection(this.jdField_a_of_type_AndroidWidgetEditText.getText().length());
    return true;
  }
  
  public void b()
  {
    View localView1 = findViewById(2131379110);
    View localView2 = findViewById(2131376947);
    int n = localView1.getHeight();
    this.jdField_a_of_type_Akda = new akda(this, this.app, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    TranslateAnimation localTranslateAnimation1 = new TranslateAnimation(0.0F, 0.0F, 0.0F, -n);
    localTranslateAnimation1.setDuration(200L);
    localTranslateAnimation1.setFillAfter(true);
    TranslateAnimation localTranslateAnimation2 = new TranslateAnimation(0.0F, 0.0F, -n, 0.0F);
    localTranslateAnimation2.setDuration(200L);
    localTranslateAnimation1.setAnimationListener(new adom(this, localView2, localView1));
    localTranslateAnimation2.setAnimationListener(new adon(this, localView2, n));
    this.jdField_a_of_type_Akda.setOnDismissListener(new adoo(this, localView2, n, localView1, localTranslateAnimation2));
    localView2.startAnimation(localTranslateAnimation1);
  }
  
  public void b(int paramInt)
  {
    QQToast.a(getActivity(), paramInt, 0).b(getResources().getDimensionPixelSize(2131299080));
  }
  
  public void b(ImageView paramImageView)
  {
    if (paramImageView != null)
    {
      this.jdField_c_of_type_AndroidGraphicsDrawableAnimationDrawable.stop();
      paramImageView.setImageDrawable(getResources().getDrawable(2130847140));
    }
  }
  
  public void b(ImageView paramImageView, PicEmoticonInfo paramPicEmoticonInfo)
  {
    if ((paramImageView != null) && (paramPicEmoticonInfo != null) && (paramPicEmoticonInfo.isSound()))
    {
      paramPicEmoticonInfo = paramPicEmoticonInfo.getLoadingDrawable("fromAIO", true);
      if ((paramPicEmoticonInfo instanceof URLDrawable)) {
        PicEmoticonInfo.startSoundDrawablePlay((URLDrawable)paramPicEmoticonInfo);
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
  protected void b(String paramString, int paramInt)
  {
    // Byte code:
    //   0: ldc 174
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
    //   22: if_icmpne +505 -> 527
    //   25: aload_1
    //   26: iload_2
    //   27: invokestatic 169	com/tencent/mobileqq/data/MessageRecord:getOldTableName	(Ljava/lang/String;I)Ljava/lang/String;
    //   30: aload_1
    //   31: iload_2
    //   32: invokestatic 172	com/tencent/mobileqq/data/MessageRecord:getTableName	(Ljava/lang/String;I)Ljava/lang/String;
    //   35: aload_0
    //   36: getfield 283	com/tencent/mobileqq/activity/ChatHistory:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   39: invokevirtual 145	com/tencent/mobileqq/app/QQAppInterface:getReadableDatabase	()Lcom/tencent/mobileqq/app/SQLiteDatabase;
    //   42: invokestatic 941	bhff:a	(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/app/SQLiteDatabase;)Ljava/lang/StringBuilder;
    //   45: astore 6
    //   47: aload 6
    //   49: ifnull +1262 -> 1311
    //   52: aload_0
    //   53: getfield 283	com/tencent/mobileqq/activity/ChatHistory:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   56: invokevirtual 145	com/tencent/mobileqq/app/QQAppInterface:getReadableDatabase	()Lcom/tencent/mobileqq/app/SQLiteDatabase;
    //   59: aload 6
    //   61: invokevirtual 177	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   64: aconst_null
    //   65: invokevirtual 193	com/tencent/mobileqq/app/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   68: astore 8
    //   70: iload_2
    //   71: iconst_1
    //   72: if_icmpne +61 -> 133
    //   75: aload_0
    //   76: getfield 283	com/tencent/mobileqq/activity/ChatHistory:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   79: aload_1
    //   80: iconst_1
    //   81: invokestatic 945	com/tencent/mobileqq/utils/ContactUtils:getNick	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;I)Ljava/lang/String;
    //   84: astore_1
    //   85: aload 10
    //   87: new 147	java/lang/StringBuilder
    //   90: dup
    //   91: invokespecial 303	java/lang/StringBuilder:<init>	()V
    //   94: aload_0
    //   95: ldc_w 946
    //   98: invokevirtual 508	com/tencent/mobileqq/activity/ChatHistory:getString	(I)Ljava/lang/String;
    //   101: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: ldc_w 948
    //   107: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: invokevirtual 177	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   113: invokevirtual 488	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   116: pop
    //   117: aload 10
    //   119: aload_1
    //   120: invokevirtual 488	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   123: pop
    //   124: aload 10
    //   126: ldc_w 950
    //   129: invokevirtual 488	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   132: pop
    //   133: aload 8
    //   135: ifnull +349 -> 484
    //   138: aload 8
    //   140: invokeinterface 953 1 0
    //   145: ifeq +339 -> 484
    //   148: aload 7
    //   150: astore 6
    //   152: aload 8
    //   154: aload 8
    //   156: ldc 224
    //   158: invokeinterface 209 2 0
    //   163: invokeinterface 956 2 0
    //   168: istore 4
    //   170: aload 8
    //   172: aload 8
    //   174: ldc_w 958
    //   177: invokeinterface 209 2 0
    //   182: invokeinterface 959 2 0
    //   187: astore_1
    //   188: iconst_1
    //   189: iload_2
    //   190: if_icmpne +428 -> 618
    //   193: aload_0
    //   194: getfield 283	com/tencent/mobileqq/activity/ChatHistory:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   197: aload_0
    //   198: getfield 289	com/tencent/mobileqq/activity/ChatHistory:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   201: invokestatic 965	com/tencent/mobileqq/data/troop/TroopInfo:isQidianPrivateTroop	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;)Z
    //   204: ifeq +381 -> 585
    //   207: aload_0
    //   208: getfield 283	com/tencent/mobileqq/activity/ChatHistory:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   211: aload_0
    //   212: getfield 289	com/tencent/mobileqq/activity/ChatHistory:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   215: aload_1
    //   216: invokestatic 969	com/tencent/mobileqq/utils/ContactUtils:getTroopMemberName	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   219: astore_1
    //   220: aload 8
    //   222: aload 8
    //   224: ldc_w 971
    //   227: invokeinterface 209 2 0
    //   232: invokeinterface 956 2 0
    //   237: istore_3
    //   238: iload_3
    //   239: invokestatic 972	bhfj:a	(I)Z
    //   242: ifeq +421 -> 663
    //   245: aload_0
    //   246: invokevirtual 974	com/tencent/mobileqq/activity/ChatHistory:a	()Ljava/lang/String;
    //   249: astore 9
    //   251: aload 8
    //   253: ldc_w 976
    //   256: invokeinterface 209 2 0
    //   261: iflt +23 -> 284
    //   264: aload 8
    //   266: aload 8
    //   268: ldc_w 976
    //   271: invokeinterface 209 2 0
    //   276: invokeinterface 956 2 0
    //   281: ifgt +388 -> 669
    //   284: aload 8
    //   286: aload 8
    //   288: ldc_w 977
    //   291: invokeinterface 209 2 0
    //   296: invokeinterface 959 2 0
    //   301: astore_1
    //   302: aconst_null
    //   303: astore 6
    //   305: aload_1
    //   306: ifnull +17 -> 323
    //   309: new 979	com/tencent/mobileqq/text/QQText
    //   312: dup
    //   313: aload_1
    //   314: iconst_3
    //   315: invokespecial 982	com/tencent/mobileqq/text/QQText:<init>	(Ljava/lang/CharSequence;I)V
    //   318: invokevirtual 985	com/tencent/mobileqq/text/QQText:toPlainText	()Ljava/lang/String;
    //   321: astore 6
    //   323: aload 6
    //   325: astore 7
    //   327: aload 6
    //   329: ifnull +67 -> 396
    //   332: aload 6
    //   334: astore 7
    //   336: aload 6
    //   338: invokevirtual 405	java/lang/String:length	()I
    //   341: ifle +55 -> 396
    //   344: aload 6
    //   346: astore 7
    //   348: aload_0
    //   349: aload 6
    //   351: invokevirtual 987	com/tencent/mobileqq/activity/ChatHistory:b	(Ljava/lang/String;)Z
    //   354: ifeq +42 -> 396
    //   357: aload 6
    //   359: ldc_w 989
    //   362: invokevirtual 992	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   365: iconst_1
    //   366: aaload
    //   367: ldc_w 994
    //   370: invokevirtual 992	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   373: astore 7
    //   375: aload 7
    //   377: arraylength
    //   378: iconst_2
    //   379: if_icmpge +853 -> 1232
    //   382: iconst_1
    //   383: istore_3
    //   384: goto +933 -> 1317
    //   387: aload_0
    //   388: ldc_w 995
    //   391: invokevirtual 508	com/tencent/mobileqq/activity/ChatHistory:getString	(I)Ljava/lang/String;
    //   394: astore 7
    //   396: new 147	java/lang/StringBuilder
    //   399: dup
    //   400: invokespecial 303	java/lang/StringBuilder:<init>	()V
    //   403: aload_0
    //   404: iload 4
    //   406: i2l
    //   407: ldc2_w 996
    //   410: lmul
    //   411: invokevirtual 999	com/tencent/mobileqq/activity/ChatHistory:a	(J)Ljava/lang/String;
    //   414: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   417: ldc_w 1001
    //   420: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   423: aload 9
    //   425: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   428: ldc_w 1003
    //   431: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   434: aload 7
    //   436: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   439: invokevirtual 177	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   442: astore 6
    //   444: aload 10
    //   446: new 147	java/lang/StringBuilder
    //   449: dup
    //   450: invokespecial 303	java/lang/StringBuilder:<init>	()V
    //   453: aload 6
    //   455: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   458: ldc_w 1005
    //   461: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   464: invokevirtual 177	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   467: invokevirtual 488	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   470: pop
    //   471: aload_1
    //   472: astore 6
    //   474: aload 8
    //   476: invokeinterface 1008 1 0
    //   481: ifne -329 -> 152
    //   484: aload 8
    //   486: ifnull +10 -> 496
    //   489: aload 8
    //   491: invokeinterface 222 1 0
    //   496: aload_0
    //   497: new 1010	com/tencent/mobileqq/activity/ChatHistory$21
    //   500: dup
    //   501: aload_0
    //   502: getstatic 1015	com/tencent/mobileqq/app/AppConstants:SDCARD_PATH_CHATRECORD	Ljava/lang/String;
    //   505: aload_0
    //   506: getfield 68	com/tencent/mobileqq/activity/ChatHistory:jdField_a_of_type_JavaLangStringBuffer	Ljava/lang/StringBuffer;
    //   509: invokevirtual 497	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   512: aload 10
    //   514: invokevirtual 497	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   517: invokestatic 1021	com/tencent/mobileqq/utils/FileUtils:writeFile	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z
    //   520: invokespecial 1024	com/tencent/mobileqq/activity/ChatHistory$21:<init>	(Lcom/tencent/mobileqq/activity/ChatHistory;Z)V
    //   523: invokevirtual 1028	com/tencent/mobileqq/activity/ChatHistory:runOnUiThread	(Ljava/lang/Runnable;)V
    //   526: return
    //   527: new 147	java/lang/StringBuilder
    //   530: dup
    //   531: invokespecial 303	java/lang/StringBuilder:<init>	()V
    //   534: ldc_w 1030
    //   537: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   540: invokestatic 157	acnh:b	()Ljava/lang/String;
    //   543: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   546: ldc_w 1032
    //   549: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   552: invokevirtual 177	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   555: astore 6
    //   557: aload_1
    //   558: iload_2
    //   559: invokestatic 169	com/tencent/mobileqq/data/MessageRecord:getOldTableName	(Ljava/lang/String;I)Ljava/lang/String;
    //   562: aload_1
    //   563: iload_2
    //   564: invokestatic 172	com/tencent/mobileqq/data/MessageRecord:getTableName	(Ljava/lang/String;I)Ljava/lang/String;
    //   567: aload_0
    //   568: getfield 283	com/tencent/mobileqq/activity/ChatHistory:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   571: invokevirtual 145	com/tencent/mobileqq/app/QQAppInterface:getReadableDatabase	()Lcom/tencent/mobileqq/app/SQLiteDatabase;
    //   574: aload 6
    //   576: aconst_null
    //   577: invokestatic 421	bhff:a	(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/app/SQLiteDatabase;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   580: astore 6
    //   582: goto -535 -> 47
    //   585: ldc_w 1034
    //   588: iconst_2
    //   589: anewarray 84	java/lang/Object
    //   592: dup
    //   593: iconst_0
    //   594: aload_0
    //   595: getfield 283	com/tencent/mobileqq/activity/ChatHistory:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   598: aload_0
    //   599: getfield 289	com/tencent/mobileqq/activity/ChatHistory:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   602: aload_1
    //   603: invokestatic 969	com/tencent/mobileqq/utils/ContactUtils:getTroopMemberName	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   606: aastore
    //   607: dup
    //   608: iconst_1
    //   609: aload_1
    //   610: aastore
    //   611: invokestatic 1037	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   614: astore_1
    //   615: goto -395 -> 220
    //   618: sipush 3000
    //   621: iload_2
    //   622: if_icmpne +33 -> 655
    //   625: ldc_w 1034
    //   628: iconst_2
    //   629: anewarray 84	java/lang/Object
    //   632: dup
    //   633: iconst_0
    //   634: aload_0
    //   635: getfield 283	com/tencent/mobileqq/activity/ChatHistory:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   638: aload_1
    //   639: iconst_0
    //   640: invokestatic 945	com/tencent/mobileqq/utils/ContactUtils:getNick	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;I)Ljava/lang/String;
    //   643: aastore
    //   644: dup
    //   645: iconst_1
    //   646: aload_1
    //   647: aastore
    //   648: invokestatic 1037	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   651: astore_1
    //   652: goto -432 -> 220
    //   655: aload_0
    //   656: getfield 1039	com/tencent/mobileqq/activity/ChatHistory:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   659: astore_1
    //   660: goto -440 -> 220
    //   663: aload_1
    //   664: astore 9
    //   666: goto -415 -> 251
    //   669: aload 8
    //   671: aload 8
    //   673: ldc_w 1041
    //   676: invokeinterface 209 2 0
    //   681: invokeinterface 956 2 0
    //   686: istore 5
    //   688: iload 5
    //   690: sipush -2007
    //   693: if_icmpne +14 -> 707
    //   696: aload_0
    //   697: ldc_w 1042
    //   700: invokevirtual 508	com/tencent/mobileqq/activity/ChatHistory:getString	(I)Ljava/lang/String;
    //   703: astore_1
    //   704: goto -402 -> 302
    //   707: iload 5
    //   709: sipush -2058
    //   712: if_icmpne +14 -> 726
    //   715: aload_0
    //   716: ldc_w 1043
    //   719: invokevirtual 508	com/tencent/mobileqq/activity/ChatHistory:getString	(I)Ljava/lang/String;
    //   722: astore_1
    //   723: goto -421 -> 302
    //   726: iload 5
    //   728: sipush -2039
    //   731: if_icmpne +50 -> 781
    //   734: aload 8
    //   736: aload 8
    //   738: ldc_w 1045
    //   741: invokeinterface 209 2 0
    //   746: invokeinterface 1049 2 0
    //   751: astore_1
    //   752: new 1051	com/tencent/mobileqq/data/MessageForApollo
    //   755: dup
    //   756: invokespecial 1052	com/tencent/mobileqq/data/MessageForApollo:<init>	()V
    //   759: astore 6
    //   761: aload 6
    //   763: aload_1
    //   764: putfield 1055	com/tencent/mobileqq/data/MessageForApollo:msgData	[B
    //   767: aload 6
    //   769: invokevirtual 1058	com/tencent/mobileqq/data/MessageForApollo:parse	()V
    //   772: aload 6
    //   774: invokestatic 1063	com/tencent/mobileqq/apollo/utils/ApolloUtil:a	(Lcom/tencent/mobileqq/data/MessageForApollo;)Ljava/lang/String;
    //   777: astore_1
    //   778: goto -476 -> 302
    //   781: iload 5
    //   783: sipush -2011
    //   786: if_icmpne +31 -> 817
    //   789: aload_0
    //   790: aload 8
    //   792: aload 8
    //   794: ldc_w 1045
    //   797: invokeinterface 209 2 0
    //   802: invokeinterface 1049 2 0
    //   807: invokestatic 1068	bdof:a	([B)Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   810: invokevirtual 1070	com/tencent/mobileqq/activity/ChatHistory:a	(Lcom/tencent/mobileqq/structmsg/AbsStructMsg;)Ljava/lang/String;
    //   813: astore_1
    //   814: goto -512 -> 302
    //   817: iload 5
    //   819: sipush -2020
    //   822: if_icmpne +58 -> 880
    //   825: iload_3
    //   826: invokestatic 972	bhfj:a	(I)Z
    //   829: ifeq +34 -> 863
    //   832: aload_0
    //   833: getfield 283	com/tencent/mobileqq/activity/ChatHistory:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   836: invokevirtual 1074	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   839: ldc_w 1075
    //   842: iconst_1
    //   843: anewarray 84	java/lang/Object
    //   846: dup
    //   847: iconst_0
    //   848: aload_0
    //   849: getfield 866	com/tencent/mobileqq/activity/ChatHistory:jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo	Lcom/tencent/mobileqq/activity/aio/SessionInfo;
    //   852: getfield 1080	com/tencent/mobileqq/activity/aio/SessionInfo:curFriendNick	Ljava/lang/String;
    //   855: aastore
    //   856: invokevirtual 1085	com/tencent/qphone/base/util/BaseApplication:getString	(I[Ljava/lang/Object;)Ljava/lang/String;
    //   859: astore_1
    //   860: goto -558 -> 302
    //   863: aload_0
    //   864: getfield 283	com/tencent/mobileqq/activity/ChatHistory:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   867: invokevirtual 1074	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   870: ldc_w 1086
    //   873: invokevirtual 1087	com/tencent/qphone/base/util/BaseApplication:getString	(I)Ljava/lang/String;
    //   876: astore_1
    //   877: goto -575 -> 302
    //   880: aload 6
    //   882: astore_1
    //   883: iload 5
    //   885: sipush -2006
    //   888: if_icmpeq -417 -> 471
    //   891: iload 5
    //   893: sipush -2000
    //   896: if_icmpne +13 -> 909
    //   899: ldc_w 1088
    //   902: invokestatic 1092	anvx:a	(I)Ljava/lang/String;
    //   905: astore_1
    //   906: goto -604 -> 302
    //   909: iload 5
    //   911: sipush -2002
    //   914: if_icmpne +13 -> 927
    //   917: ldc_w 1093
    //   920: invokestatic 1092	anvx:a	(I)Ljava/lang/String;
    //   923: astore_1
    //   924: goto -622 -> 302
    //   927: iload 5
    //   929: sipush -2022
    //   932: if_icmpne +13 -> 945
    //   935: ldc_w 1094
    //   938: invokestatic 1092	anvx:a	(I)Ljava/lang/String;
    //   941: astore_1
    //   942: goto -640 -> 302
    //   945: iload 5
    //   947: sipush -2071
    //   950: if_icmpne +14 -> 964
    //   953: aload_0
    //   954: ldc_w 1095
    //   957: invokevirtual 508	com/tencent/mobileqq/activity/ChatHistory:getString	(I)Ljava/lang/String;
    //   960: astore_1
    //   961: goto -659 -> 302
    //   964: iload 5
    //   966: sipush -7001
    //   969: if_icmpne +14 -> 983
    //   972: aload_0
    //   973: ldc_w 1096
    //   976: invokevirtual 508	com/tencent/mobileqq/activity/ChatHistory:getString	(I)Ljava/lang/String;
    //   979: astore_1
    //   980: goto -678 -> 302
    //   983: iload 5
    //   985: sipush -1035
    //   988: if_icmpne +202 -> 1190
    //   991: new 147	java/lang/StringBuilder
    //   994: dup
    //   995: invokespecial 303	java/lang/StringBuilder:<init>	()V
    //   998: astore_1
    //   999: aload 8
    //   1001: aload 8
    //   1003: ldc_w 1045
    //   1006: invokeinterface 209 2 0
    //   1011: invokeinterface 1049 2 0
    //   1016: astore 7
    //   1018: new 1098	localpb/richMsg/MixedMsg$Msg
    //   1021: dup
    //   1022: invokespecial 1099	localpb/richMsg/MixedMsg$Msg:<init>	()V
    //   1025: astore 6
    //   1027: aload 6
    //   1029: aload 7
    //   1031: invokevirtual 1103	localpb/richMsg/MixedMsg$Msg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   1034: pop
    //   1035: aload 6
    //   1037: getfield 1107	localpb/richMsg/MixedMsg$Msg:elems	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   1040: invokevirtual 1113	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   1043: invokeinterface 1118 1 0
    //   1048: ifgt +51 -> 1099
    //   1051: aload 8
    //   1053: ifnull -527 -> 526
    //   1056: aload 8
    //   1058: invokeinterface 222 1 0
    //   1063: return
    //   1064: astore 6
    //   1066: invokestatic 302	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1069: ifeq +12 -> 1081
    //   1072: ldc 61
    //   1074: iconst_2
    //   1075: ldc_w 1120
    //   1078: invokestatic 311	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1081: aload_1
    //   1082: invokevirtual 177	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1085: astore_1
    //   1086: goto -784 -> 302
    //   1089: astore 7
    //   1091: aload 7
    //   1093: invokevirtual 1123	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:printStackTrace	()V
    //   1096: goto -61 -> 1035
    //   1099: aload 6
    //   1101: getfield 1107	localpb/richMsg/MixedMsg$Msg:elems	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   1104: invokevirtual 1113	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   1107: invokeinterface 1118 1 0
    //   1112: istore 5
    //   1114: iconst_0
    //   1115: istore_3
    //   1116: iload_3
    //   1117: iload 5
    //   1119: if_icmpge -38 -> 1081
    //   1122: aload 6
    //   1124: getfield 1107	localpb/richMsg/MixedMsg$Msg:elems	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   1127: invokevirtual 1113	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   1130: iload_3
    //   1131: invokeinterface 1126 2 0
    //   1136: checkcast 1128	localpb/richMsg/MixedMsg$Elem
    //   1139: astore 7
    //   1141: aload 7
    //   1143: getfield 1132	localpb/richMsg/MixedMsg$Elem:textMsg	Lcom/tencent/mobileqq/pb/PBStringField;
    //   1146: invokevirtual 1137	com/tencent/mobileqq/pb/PBStringField:has	()Z
    //   1149: ifeq +19 -> 1168
    //   1152: aload_1
    //   1153: aload 7
    //   1155: getfield 1132	localpb/richMsg/MixedMsg$Elem:textMsg	Lcom/tencent/mobileqq/pb/PBStringField;
    //   1158: invokevirtual 1139	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   1161: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1164: pop
    //   1165: goto +167 -> 1332
    //   1168: aload 7
    //   1170: getfield 1143	localpb/richMsg/MixedMsg$Elem:picMsg	Llocalpb/richMsg/RichMsg$PicRec;
    //   1173: invokevirtual 1146	localpb/richMsg/RichMsg$PicRec:has	()Z
    //   1176: ifeq +156 -> 1332
    //   1179: aload_1
    //   1180: ldc_w 1148
    //   1183: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1186: pop
    //   1187: goto +145 -> 1332
    //   1190: new 215	java/lang/String
    //   1193: dup
    //   1194: aload 8
    //   1196: aload 8
    //   1198: ldc_w 1045
    //   1201: invokeinterface 209 2 0
    //   1206: invokeinterface 1049 2 0
    //   1211: ldc_w 1150
    //   1214: invokespecial 1153	java/lang/String:<init>	([BLjava/lang/String;)V
    //   1217: astore_1
    //   1218: goto -916 -> 302
    //   1221: astore_1
    //   1222: aload_1
    //   1223: invokevirtual 1154	java/lang/Exception:printStackTrace	()V
    //   1226: aload 6
    //   1228: astore_1
    //   1229: goto -927 -> 302
    //   1232: aload 7
    //   1234: iconst_2
    //   1235: aaload
    //   1236: invokestatic 1159	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   1239: invokevirtual 1162	java/lang/Integer:intValue	()I
    //   1242: istore_3
    //   1243: goto +74 -> 1317
    //   1246: aload 6
    //   1248: astore 7
    //   1250: iload_3
    //   1251: iconst_2
    //   1252: if_icmpne -856 -> 396
    //   1255: new 147	java/lang/StringBuilder
    //   1258: dup
    //   1259: invokespecial 303	java/lang/StringBuilder:<init>	()V
    //   1262: ldc_w 485
    //   1265: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1268: aload_0
    //   1269: ldc_w 1163
    //   1272: invokevirtual 508	com/tencent/mobileqq/activity/ChatHistory:getString	(I)Ljava/lang/String;
    //   1275: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1278: ldc_w 493
    //   1281: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1284: invokevirtual 177	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1287: astore 7
    //   1289: goto -893 -> 396
    //   1292: astore 7
    //   1294: ldc 61
    //   1296: iconst_1
    //   1297: ldc 174
    //   1299: aload 7
    //   1301: invokestatic 1166	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1304: aload 6
    //   1306: astore 7
    //   1308: goto -912 -> 396
    //   1311: aconst_null
    //   1312: astore 8
    //   1314: goto -1244 -> 70
    //   1317: iload_3
    //   1318: iconst_1
    //   1319: if_icmpeq -932 -> 387
    //   1322: iload_3
    //   1323: ldc_w 1167
    //   1326: if_icmpne -80 -> 1246
    //   1329: goto -942 -> 387
    //   1332: iload_3
    //   1333: iconst_1
    //   1334: iadd
    //   1335: istore_3
    //   1336: goto -220 -> 1116
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1339	0	this	ChatHistory
    //   0	1339	1	paramString	String
    //   0	1339	2	paramInt	int
    //   237	1099	3	n	int
    //   168	237	4	i1	int
    //   686	434	5	i2	int
    //   45	991	6	localObject1	Object
    //   1064	241	6	localException1	Exception
    //   2	1028	7	localObject2	Object
    //   1089	3	7	localInvalidProtocolBufferMicroException	com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException
    //   1139	149	7	localObject3	Object
    //   1292	8	7	localException2	Exception
    //   1306	1	7	localObject4	Object
    //   68	1245	8	localCursor	Cursor
    //   249	416	9	str	String
    //   11	502	10	localStringBuffer	StringBuffer
    // Exception table:
    //   from	to	target	type
    //   999	1027	1064	java/lang/Exception
    //   1027	1035	1064	java/lang/Exception
    //   1035	1051	1064	java/lang/Exception
    //   1056	1063	1064	java/lang/Exception
    //   1091	1096	1064	java/lang/Exception
    //   1099	1114	1064	java/lang/Exception
    //   1122	1165	1064	java/lang/Exception
    //   1168	1187	1064	java/lang/Exception
    //   1027	1035	1089	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   1190	1218	1221	java/lang/Exception
    //   375	382	1292	java/lang/Exception
    //   387	396	1292	java/lang/Exception
    //   1232	1243	1292	java/lang/Exception
    //   1255	1289	1292	java/lang/Exception
  }
  
  public boolean b(String paramString)
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
    this.jdField_a_of_type_AndroidViewView = ((RelativeLayout)View.inflate(this, 2131562804, null));
    int n = (int)bhdz.a(this, 6.0F);
    Object localObject = new RelativeLayout(this);
    ((RelativeLayout)localObject).setPadding(0, n, 0, n);
    ((RelativeLayout)localObject).setBackgroundResource(2130850355);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, getResources().getDimensionPixelSize(2131298798));
    ((RelativeLayout)localObject).addView(this.jdField_a_of_type_AndroidViewView, localLayoutParams);
    this.jdField_a_of_type_ComTencentWidgetXListView.addHeaderView((View)localObject);
    this.jdField_a_of_type_AndroidViewView.findViewById(2131363845).setVisibility(8);
    localObject = (EditText)this.jdField_a_of_type_AndroidViewView.findViewById(2131366280);
    ((EditText)localObject).setFocusableInTouchMode(false);
    ((EditText)localObject).setCursorVisible(false);
    ((EditText)localObject).setOnClickListener(new adop(this));
    setLayerType(this.jdField_a_of_type_AndroidViewView);
  }
  
  protected void c(String paramString)
  {
    if (this.jdField_b_of_type_Bisl == null) {
      this.jdField_b_of_type_Bisl = new bisl(this, getTitleBarHeight());
    }
    this.jdField_b_of_type_Bisl.setCancelable(true);
    this.jdField_b_of_type_Bisl.a(paramString);
    this.jdField_b_of_type_Bisl.show();
  }
  
  public boolean c(String paramString)
  {
    o();
    MediaPlayerManager.a(this.app).a(true);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer == null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer = new AudioPlayer(this, this.jdField_a_of_type_Afpx);
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
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131368531));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131368532));
    this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(getString(2131690770));
    this.jdField_b_of_type_AndroidWidgetImageView.setContentDescription(getString(2131690769));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new adoq(this));
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(new adnt(this));
    this.jdField_b_of_type_AndroidWidgetImageView.setEnabled(false);
    this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130849601);
    if (this.jdField_c_of_type_Int == 1)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setEnabled(false);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130840554);
    }
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131378681));
    this.jdField_b_of_type_AndroidWidgetTextView.setText(String.valueOf(this.jdField_c_of_type_Int));
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131365961));
    this.jdField_a_of_type_AndroidWidgetEditText.setText(String.valueOf(this.jdField_d_of_type_Int));
    this.jdField_a_of_type_AndroidWidgetEditText.setSelection(this.jdField_a_of_type_AndroidWidgetEditText.getText().toString().length());
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(new adnu(this));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131364135));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new adnv(this));
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)findViewById(2131364134));
    this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(new adnw(this));
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
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(new adnx(this));
      return;
      if ((this.jdField_a_of_type_Int != 1) && (this.jdField_a_of_type_Int != 3000))
      {
        anvk localanvk = (anvk)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER);
        if ((localanvk == null) || (!localanvk.b(String.valueOf(this.jdField_b_of_type_JavaLangString))))
        {
          if (QLog.isColorLevel()) {
            QLog.e("ChatHistory", 2, "--mSyncHistory button: fm is null or the uin is not my friend: fm:" + localanvk);
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
      this.jdField_a_of_type_Ador.getCursor().requery();
      return;
    } while (-1 != paramInt2);
    a(paramIntent.getExtras());
  }
  
  @TargetApi(14)
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    addObserver(this.jdField_a_of_type_Anyz);
    this.jdField_a_of_type_Float = getResources().getDisplayMetrics().density;
    this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable = ((AnimationDrawable)getResources().getDrawable(2130772345));
    this.jdField_b_of_type_AndroidGraphicsDrawableAnimationDrawable = ((AnimationDrawable)getResources().getDrawable(2130772346));
    this.jdField_c_of_type_AndroidGraphicsDrawableAnimationDrawable = ((AnimationDrawable)getResources().getDrawable(2130772266));
    paramBundle = getIntent().getExtras();
    this.jdField_b_of_type_JavaLangString = paramBundle.getString("uin");
    this.jdField_a_of_type_Int = paramBundle.getInt("uintype");
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = new SessionInfo();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin = this.jdField_b_of_type_JavaLangString;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType = this.jdField_a_of_type_Int;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendNick = this.jdField_c_of_type_JavaLangString;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.troopUin = paramBundle.getString("troop_uin");
    setContentViewNoTitle(2131558912);
    LinearLayout localLinearLayout = (LinearLayout)findViewById(2131376947);
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
    this.jdField_a_of_type_Azil = ((azil)this.app.getManager(QQManagerFactory.SLOW_TABLE_MANAGER));
    a(9, false);
    m();
    a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Int);
    q();
    if (this.app.getProxyManager() != null) {
      this.app.getProxyManager().addProxyObserver(this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyObserver);
    }
    this.app.getProxyManager().saveNotify();
    this.jdField_a_of_type_Bgzn = new bgzn(this);
    this.jdField_a_of_type_Bgzn.a((int)(150.0F * this.jdField_a_of_type_Float), (int)(100.0F * this.jdField_a_of_type_Float));
    s();
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.jdField_a_of_type_Ador != null) {
      this.jdField_a_of_type_Ador.a();
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
      QLog.i("ChatHistory", 2, "onDestroy() mCurPlayingPttInfo = " + this.jdField_a_of_type_Adpc);
    }
    if ((this.jdField_a_of_type_Adpc != null) && (!this.jdField_a_of_type_Adpc.jdField_a_of_type_Boolean))
    {
      this.jdField_a_of_type_Adpc.d();
      this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable.stop();
      this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable = null;
      this.jdField_b_of_type_AndroidGraphicsDrawableAnimationDrawable.stop();
      this.jdField_b_of_type_AndroidGraphicsDrawableAnimationDrawable = null;
      this.jdField_c_of_type_AndroidGraphicsDrawableAnimationDrawable.stop();
      this.jdField_c_of_type_AndroidGraphicsDrawableAnimationDrawable = null;
    }
    this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
    this.app.removeHandler(getClass());
    removeObserver(this.jdField_a_of_type_Anyz);
    if (this.app.getProxyManager() != null) {
      this.app.getProxyManager().removeProxyObserver(this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyObserver);
    }
    this.app.getProxyManager().saveNotify();
    try
    {
      this.jdField_a_of_type_Bgzn.a().a();
      label251:
      findViewById(2131376947).clearAnimation();
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
      QLog.i("ChatHistory", 2, "onPause() mCurPlayingPttInfo = " + this.jdField_a_of_type_Adpc);
    }
    if ((this.jdField_a_of_type_Adpc != null) && (!this.jdField_a_of_type_Adpc.jdField_a_of_type_Boolean)) {
      this.jdField_a_of_type_Adpc.d();
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
  
  public void e()
  {
    f();
    this.jdField_a_of_type_AndroidWidgetEditText.setText(String.valueOf(this.jdField_d_of_type_Int));
    this.jdField_a_of_type_AndroidWidgetEditText.setSelection(this.jdField_a_of_type_AndroidWidgetEditText.getText().length());
    this.jdField_b_of_type_AndroidWidgetTextView.setText(String.valueOf(this.jdField_c_of_type_Int));
    this.jdField_a_of_type_Ador.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Int, this.jdField_e_of_type_Int);
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
    this.jdField_a_of_type_Ador.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Int, this.jdField_e_of_type_Int);
  }
  
  public void h()
  {
    this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(4, getResources().getString(2131719001)).sendToTarget();
    this.app.getMsgHandler().a((short)1, (byte)1);
  }
  
  public void i()
  {
    anzc localanzc = (anzc)this.app.getManager(QQManagerFactory.MESSAGE_ROAM_MANAGER);
    if (localanzc != null)
    {
      long l1 = NetConnInfoCenter.getServerTime();
      this.app.getMsgHandler().a(this.jdField_b_of_type_JavaLangString, l1 - 604800L, 0L, l1, (short)0, 0L, 1, null, localanzc.b(), false, 0, false);
    }
  }
  
  protected void j()
  {
    if (!NetworkUtil.isNetSupport(this.app.getApplication().getApplicationContext()))
    {
      QQToast.a(getApplicationContext(), 2131691465, 1).a();
      return;
    }
    c(getApplication().getResources().getString(2131691466));
    this.app.getMsgHandler().c(this.jdField_b_of_type_JavaLangString);
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
      boolean bool = FileUtils.justOnExistFileAndAddSuffix(AppConstants.SDCARD_PATH_CHATRECORD, this.jdField_a_of_type_JavaLangStringBuffer, ".txt");
      this.jdField_c_of_type_AndroidAppDialog = bhdj.a(this, 230, getString(2131691045), getString(2131691045) + AppConstants.SDCARD_PATH_CHATRECORD + this.jdField_a_of_type_JavaLangStringBuffer.toString(), new adoa(this), new adob(this));
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
    b(getString(2131692040));
  }
  
  public void l()
  {
    this.jdField_c_of_type_AndroidAppDialog = bhdj.a(this, 230, getString(2131719002), getString(2131719353), new adoc(this), new adoe(this));
    this.jdField_c_of_type_AndroidAppDialog.show();
  }
  
  protected void m()
  {
    String str = getResources().getString(2131690761);
    if (this.jdField_a_of_type_Int == 0) {
      if (this.jdField_b_of_type_JavaLangString.equals(String.valueOf(AppConstants.SYSTEM_MSG_UIN)))
      {
        this.jdField_c_of_type_JavaLangString = getResources().getString(2131719141);
        if (!this.jdField_b_of_type_JavaLangString.equals(String.valueOf(AppConstants.SYSTEM_MSG_UIN))) {
          break label377;
        }
        str = getResources().getString(2131719141);
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
      this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendNick = this.jdField_c_of_type_JavaLangString;
      this.leftView = ((TextView)findViewById(2131369231));
      return;
      this.jdField_c_of_type_JavaLangString = ContactUtils.getDisplayName(this.app, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.troopUin, ContactUtils.getEntry(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType), 3);
      break;
      if (this.jdField_a_of_type_Int == 1)
      {
        this.jdField_c_of_type_JavaLangString = ((TroopManager)this.app.getManager(QQManagerFactory.TROOP_MANAGER)).a(this.jdField_b_of_type_JavaLangString);
      }
      else if ((this.jdField_a_of_type_Int == 1000) || (this.jdField_a_of_type_Int == 1020) || (this.jdField_a_of_type_Int == 1001) || (this.jdField_a_of_type_Int == 10002) || (this.jdField_a_of_type_Int == 10004) || (this.jdField_a_of_type_Int == 1004) || (this.jdField_a_of_type_Int == 10010))
      {
        this.jdField_c_of_type_JavaLangString = ContactUtils.getFriendNickName(this.app, this.jdField_b_of_type_JavaLangString);
      }
      else if (this.jdField_a_of_type_Int == 3000)
      {
        this.jdField_c_of_type_JavaLangString = ContactUtils.getDiscussionNameDefaultUin(this.app, this.jdField_b_of_type_JavaLangString);
      }
      else if (this.jdField_a_of_type_Int == 1024)
      {
        PublicAccountInfo localPublicAccountInfo = ((aoan)this.app.getManager(QQManagerFactory.PUBLICACCOUNTDATA_MANAGER)).b(this.jdField_b_of_type_JavaLangString);
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
  
  public void o()
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
  
  public boolean onBackEvent()
  {
    try
    {
      if (this.jdField_a_of_type_AndroidWidgetEditText != null) {
        bkxz.b(this.jdField_a_of_type_AndroidWidgetEditText);
      }
      setResult(-1);
      if ((this.jdField_a_of_type_Akda != null) && (this.jdField_a_of_type_Akda.a()))
      {
        this.jdField_a_of_type_Akda.show();
        this.jdField_a_of_type_Akda.a(false);
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
      localTextView.setText(2131718133);
      this.jdField_a_of_type_AndroidWidgetTextView = localTextView;
      return localTextView;
      this.rightViewText.setVisibility(0);
    }
  }
  
  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    boolean bool2 = true;
    if (AIOUtils.isRubbishSamsun()) {}
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
    } while (AppSetting.jdField_c_of_type_Boolean);
    if (this.jdField_e_of_type_Boolean) {}
    for (int n = 2131718990;; n = 2131718992)
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
    bhcl.b(2131230731, false);
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
      if (this.jdField_b_of_type_Bisl != null)
      {
        this.jdField_b_of_type_Bisl.dismiss();
        this.jdField_b_of_type_Bisl.cancel();
        this.jdField_b_of_type_Bisl = null;
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
      switch (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType)
      {
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ChatHistory", 2, "AIO_chatlog arg:" + this.k);
      }
      bdla.b(this.app, "CliOper", "", "", "AIO", "AIO_chatlog", this.k, 0, String.valueOf(this.k), "", "", "");
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
    bdla.b(this.app, "CliOper", "", "", "0X8005690", "0X8005690", this.k, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatHistory
 * JD-Core Version:    0.7.0.1
 */