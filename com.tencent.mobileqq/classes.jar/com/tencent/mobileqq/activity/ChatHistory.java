package com.tencent.mobileqq.activity;

import ActionMsg.MsgBody;
import Override;
import adak;
import aece;
import aecg;
import aech;
import aeci;
import aecj;
import aeck;
import aecl;
import aecm;
import aecn;
import aeco;
import aecp;
import aecq;
import aecr;
import aecs;
import aect;
import aecu;
import aecv;
import aecw;
import aecy;
import aecz;
import aeda;
import aedb;
import aedc;
import aedd;
import aede;
import aedn;
import aedp;
import agej;
import agfs;
import akjn;
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
import antf;
import anyw;
import aocj;
import aocm;
import aody;
import asre;
import atup;
import azor;
import bdll;
import beyo;
import bhhi;
import bhhm;
import bhka;
import bhkm;
import bhlg;
import bhlq;
import bhmg;
import bhmi;
import bhnp;
import bhnt;
import bhnv;
import bhpc;
import bjbs;
import blgx;
import blha;
import blih;
import blir;
import blji;
import com.tencent.common.config.AppSetting;
import com.tencent.image.ApngImage;
import com.tencent.image.URLDrawable;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.AudioPlayer;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.history.ChatHistoryC2CAllFragment;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SQLiteDatabase;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.ProxyObserver;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.TipsBar;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
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
  public aede a;
  public aedn a;
  public aedp a;
  protected agfs a;
  public akjn a;
  public Dialog a;
  public AnimationDrawable a;
  protected Sensor a;
  public SensorManager a;
  Handler.Callback jdField_a_of_type_AndroidOsHandler$Callback = new aece(this);
  public Handler a;
  View jdField_a_of_type_AndroidViewView;
  protected Button a;
  public EditText a;
  public ImageView a;
  public TextView a;
  protected aocj a;
  public azor a;
  bhhm jdField_a_of_type_Bhhm;
  public bjbs a;
  blih jdField_a_of_type_Blih = new aecv(this);
  protected AudioPlayer a;
  public SessionInfo a;
  protected ProxyObserver a;
  protected EntityManager a;
  public TipsBar a;
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
  protected bjbs b;
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
    this.jdField_a_of_type_Azor = null;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_a_of_type_MqqOsMqqHandler = new blha(this.jdField_a_of_type_AndroidOsHandler$Callback);
    this.jdField_a_of_type_AndroidOsHandler = new aecq(this);
    this.jdField_a_of_type_Aedn = new aedn(this);
    this.jdField_a_of_type_Aocj = new aecs(this);
    this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyObserver = new aect(this);
    this.jdField_a_of_type_Agfs = new aecu(this);
  }
  
  public static final int a(QQAppInterface paramQQAppInterface, String paramString, int paramInt, StringBuilder paramStringBuilder)
  {
    if (paramQQAppInterface == null) {
      return 0;
    }
    SQLiteDatabase localSQLiteDatabase = paramQQAppInterface.a();
    if (localSQLiteDatabase == null) {
      return 0;
    }
    if (paramInt == 0)
    {
      paramQQAppInterface = new StringBuilder(" msgtype ");
      paramQQAppInterface.append(adak.b());
      paramQQAppInterface.append(" and isValid=1 ");
    }
    for (paramQQAppInterface = bhnp.a(MessageRecord.getOldTableName(paramString, paramInt), MessageRecord.getTableName(paramString, paramInt), localSQLiteDatabase, "", paramQQAppInterface.toString(), ""); paramQQAppInterface == null; paramQQAppInterface = bhnp.a(MessageRecord.getOldTableName(paramString, paramInt), MessageRecord.getTableName(paramString, paramInt), localSQLiteDatabase, paramQQAppInterface.toString()))
    {
      return 0;
      paramQQAppInterface = new StringBuilder(" where msgtype ");
      paramQQAppInterface.append(adak.b());
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
    c(this.app.a().a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Int, paramMessageRecord));
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
    this.jdField_a_of_type_Aede.jdField_c_of_type_Int = ((paramInt - 1) % 8);
    this.jdField_a_of_type_AndroidWidgetEditText.setText(String.valueOf(n));
    this.jdField_a_of_type_AndroidWidgetEditText.setSelection(this.jdField_a_of_type_AndroidWidgetEditText.getText().length());
  }
  
  public MsgBody a(int paramInt1, int paramInt2, String paramString, int paramInt3)
  {
    if (((paramInt2 != -1003) && (paramInt2 != -1032) && (paramInt2 != -1031) && (paramInt2 != 201)) || ((paramInt1 == 1001) || (paramInt1 == 10002) || (bhka.a(paramInt2)) || (paramInt2 == -3001) || (paramInt2 == -30002) || (paramInt2 == -30003))) {
      return bhka.a(paramString);
    }
    if (paramInt2 == -2009)
    {
      localMsgBody = new MsgBody();
      boolean bool = bhnt.b(paramInt3);
      localMsgBody.msg = bhnt.a(beyo.a(paramString), this, bool, false);
      localMsgBody.action = null;
      return localMsgBody;
    }
    if (paramInt2 == -2016)
    {
      localMsgBody = new MsgBody();
      localMsgBody.msg = bhnt.a(this.app, beyo.a(paramString), this, this.jdField_b_of_type_JavaLangString, null, this.jdField_a_of_type_Int);
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
    SQLiteDatabase localSQLiteDatabase = this.app.a();
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
      paramString2 = bhnp.b(paramString2, paramString1, localSQLiteDatabase, paramString3);
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
          paramString2 = bhnp.b(paramString2, paramString1, localSQLiteDatabase, paramString3);
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
        paramString2 = bhnp.a(paramString2, paramString1, localSQLiteDatabase, paramString3, null);
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
        this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = this.app.a().createMessageRecordEntityManager();
      }
      return this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager;
    }
  }
  
  protected String a()
  {
    String str = bhlg.h(this.app, this.app.getCurrentAccountUin());
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
        localStringBuffer.append(" " + getString(2131718374) + " ");
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
    this.jdField_a_of_type_ComTencentMobileqqWidgetTipsBar.setTipsIcon(getActivity().getResources().getDrawable(2130838270));
    localRelativeLayout.addView(this.jdField_a_of_type_ComTencentMobileqqWidgetTipsBar, localLayoutParams);
    this.jdField_a_of_type_ComTencentWidgetXListView.addHeaderView(localRelativeLayout);
    this.jdField_a_of_type_ComTencentMobileqqWidgetTipsBar.setOnClickListener(new aecy(this));
    this.jdField_c_of_type_AndroidWidgetTextView = this.jdField_a_of_type_ComTencentMobileqqWidgetTipsBar.a();
    this.jdField_a_of_type_ComTencentMobileqqWidgetTipsBar.setVisibility(8);
  }
  
  public void a(int paramInt)
  {
    if (paramInt > 0)
    {
      Cursor localCursor = this.jdField_a_of_type_Aede.getCursor();
      if (localCursor != null) {
        localCursor.requery();
      }
    }
    if ((this.jdField_a_of_type_Int == 0) && (((CheckBox)this.jdField_b_of_type_AndroidAppDialog.findViewById(2131365344)).isChecked()))
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
    ThreadManager.getSubThreadHandler().post(new ChatHistory.8(this, paramBoolean, paramInt));
  }
  
  protected void a(Bundle paramBundle)
  {
    Intent localIntent = agej.a(new Intent(this, SplashActivity.class), null);
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
  
  public void a(ImageView paramImageView, asre paramasre)
  {
    if ((paramImageView != null) && (paramasre != null) && (paramasre.b()))
    {
      paramasre = paramasre.a("fromAIO", true);
      Drawable localDrawable = paramImageView.getDrawable();
      if ((localDrawable instanceof URLDrawable)) {
        asre.b((URLDrawable)localDrawable);
      }
      paramImageView.setImageDrawable(paramasre);
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
      blir localblir = (blir)blji.a(this, null);
      localblir.a(getResources().getString(2131695439));
      localblir.a(2131691323, 3);
      localblir.c(2131690580);
      localblir.a(new aecw(this, paramMessageRecord, localblir));
      localblir.show();
      return;
      label110:
      QLog.d("Q.msg.delmsg", 2, "startDelMsg is called,mr is null");
    }
  }
  
  public void a(String paramString)
  {
    View localView = getLayoutInflater().inflate(2131559083, null);
    if (1 == this.jdField_a_of_type_Int)
    {
      ((TextView)localView.findViewById(2131378618)).setText(2131690916);
      localView.findViewById(2131365344).setVisibility(8);
    }
    for (;;)
    {
      if (!isFinishing())
      {
        this.jdField_b_of_type_AndroidAppDialog = bhlq.a(this, 230).setTitle(getString(2131691339)).setPositiveButton(getString(2131691323), new aecm(this, paramString)).setNegativeButton(getString(2131690560), new aecl(this)).addView(localView);
        this.jdField_b_of_type_AndroidAppDialog.show();
      }
      return;
      if (3000 == this.jdField_a_of_type_Int)
      {
        ((TextView)localView.findViewById(2131378618)).setText(2131690915);
        localView.findViewById(2131365344).setVisibility(8);
      }
      else if ((1001 == this.jdField_a_of_type_Int) || (10002 == this.jdField_a_of_type_Int) || (1000 == this.jdField_a_of_type_Int) || (10004 == this.jdField_a_of_type_Int) || (1020 == this.jdField_a_of_type_Int) || (1004 == this.jdField_a_of_type_Int) || (10010 == this.jdField_a_of_type_Int))
      {
        localView.findViewById(2131365344).setVisibility(8);
      }
    }
  }
  
  @SuppressLint({"NewApi"})
  protected void a(String paramString, int paramInt)
  {
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)findViewById(2131370021));
    c();
    a();
    this.jdField_a_of_type_Aede = new aede(this, this, null);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Aede);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnScrollListener(this.jdField_a_of_type_Blih);
    this.jdField_a_of_type_ComTencentWidgetXListView.setEdgeEffectEnabled(false);
    if (Build.VERSION.SDK_INT >= 9) {
      this.jdField_a_of_type_ComTencentWidgetXListView.setOverscrollFooter(null);
    }
    this.jdField_a_of_type_Aede.a(paramString, paramInt, this.jdField_e_of_type_Int);
  }
  
  boolean a(int paramInt)
  {
    if ((paramInt <= 0) || (paramInt > this.jdField_c_of_type_Int * 8)) {
      return false;
    }
    this.jdField_b_of_type_Boolean = true;
    int n = (paramInt - 1) / 8;
    this.jdField_a_of_type_Aede.jdField_c_of_type_Int = ((paramInt - 1) % 8);
    this.jdField_a_of_type_AndroidWidgetEditText.setText(String.valueOf(n + 1));
    this.jdField_a_of_type_AndroidWidgetEditText.setSelection(this.jdField_a_of_type_AndroidWidgetEditText.getText().length());
    return true;
  }
  
  public void b()
  {
    View localView1 = findViewById(2131379048);
    View localView2 = findViewById(2131376925);
    int n = localView1.getHeight();
    this.jdField_a_of_type_Akjn = new akjn(this, this.app, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    TranslateAnimation localTranslateAnimation1 = new TranslateAnimation(0.0F, 0.0F, 0.0F, -n);
    localTranslateAnimation1.setDuration(200L);
    localTranslateAnimation1.setFillAfter(true);
    TranslateAnimation localTranslateAnimation2 = new TranslateAnimation(0.0F, 0.0F, -n, 0.0F);
    localTranslateAnimation2.setDuration(200L);
    localTranslateAnimation1.setAnimationListener(new aecz(this, localView2, localView1));
    localTranslateAnimation2.setAnimationListener(new aeda(this, localView2, n));
    this.jdField_a_of_type_Akjn.setOnDismissListener(new aedb(this, localView2, n, localView1, localTranslateAnimation2));
    localView2.startAnimation(localTranslateAnimation1);
  }
  
  public void b(int paramInt)
  {
    QQToast.a(getActivity(), paramInt, 0).b(getResources().getDimensionPixelSize(2131299011));
  }
  
  public void b(ImageView paramImageView)
  {
    if (paramImageView != null)
    {
      this.jdField_c_of_type_AndroidGraphicsDrawableAnimationDrawable.stop();
      paramImageView.setImageDrawable(getResources().getDrawable(2130847134));
    }
  }
  
  public void b(ImageView paramImageView, asre paramasre)
  {
    if ((paramImageView != null) && (paramasre != null) && (paramasre.b()))
    {
      paramasre = paramasre.a("fromAIO", true);
      if ((paramasre instanceof URLDrawable)) {
        asre.a((URLDrawable)paramasre);
      }
      paramImageView.setImageDrawable(paramasre);
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
    //   22: if_icmpne +505 -> 527
    //   25: aload_1
    //   26: iload_2
    //   27: invokestatic 168	com/tencent/mobileqq/data/MessageRecord:getOldTableName	(Ljava/lang/String;I)Ljava/lang/String;
    //   30: aload_1
    //   31: iload_2
    //   32: invokestatic 171	com/tencent/mobileqq/data/MessageRecord:getTableName	(Ljava/lang/String;I)Ljava/lang/String;
    //   35: aload_0
    //   36: getfield 282	com/tencent/mobileqq/activity/ChatHistory:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   39: invokevirtual 144	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/SQLiteDatabase;
    //   42: invokestatic 929	bhnp:a	(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/app/SQLiteDatabase;)Ljava/lang/StringBuilder;
    //   45: astore 6
    //   47: aload 6
    //   49: ifnull +1262 -> 1311
    //   52: aload_0
    //   53: getfield 282	com/tencent/mobileqq/activity/ChatHistory:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   56: invokevirtual 144	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/SQLiteDatabase;
    //   59: aload 6
    //   61: invokevirtual 176	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   64: aconst_null
    //   65: invokevirtual 192	com/tencent/mobileqq/app/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   68: astore 8
    //   70: iload_2
    //   71: iconst_1
    //   72: if_icmpne +61 -> 133
    //   75: aload_0
    //   76: getfield 282	com/tencent/mobileqq/activity/ChatHistory:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   79: aload_1
    //   80: iconst_1
    //   81: invokestatic 932	bhlg:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;I)Ljava/lang/String;
    //   84: astore_1
    //   85: aload 10
    //   87: new 146	java/lang/StringBuilder
    //   90: dup
    //   91: invokespecial 300	java/lang/StringBuilder:<init>	()V
    //   94: aload_0
    //   95: ldc_w 933
    //   98: invokevirtual 502	com/tencent/mobileqq/activity/ChatHistory:getString	(I)Ljava/lang/String;
    //   101: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: ldc_w 935
    //   107: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: invokevirtual 176	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   113: invokevirtual 482	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   116: pop
    //   117: aload 10
    //   119: aload_1
    //   120: invokevirtual 482	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   123: pop
    //   124: aload 10
    //   126: ldc_w 937
    //   129: invokevirtual 482	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   132: pop
    //   133: aload 8
    //   135: ifnull +349 -> 484
    //   138: aload 8
    //   140: invokeinterface 940 1 0
    //   145: ifeq +339 -> 484
    //   148: aload 7
    //   150: astore 6
    //   152: aload 8
    //   154: aload 8
    //   156: ldc 223
    //   158: invokeinterface 208 2 0
    //   163: invokeinterface 943 2 0
    //   168: istore 4
    //   170: aload 8
    //   172: aload 8
    //   174: ldc_w 945
    //   177: invokeinterface 208 2 0
    //   182: invokeinterface 946 2 0
    //   187: astore_1
    //   188: iconst_1
    //   189: iload_2
    //   190: if_icmpne +428 -> 618
    //   193: aload_0
    //   194: getfield 282	com/tencent/mobileqq/activity/ChatHistory:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   197: aload_0
    //   198: getfield 287	com/tencent/mobileqq/activity/ChatHistory:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   201: invokestatic 952	com/tencent/mobileqq/data/TroopInfo:isQidianPrivateTroop	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;)Z
    //   204: ifeq +381 -> 585
    //   207: aload_0
    //   208: getfield 282	com/tencent/mobileqq/activity/ChatHistory:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   211: aload_0
    //   212: getfield 287	com/tencent/mobileqq/activity/ChatHistory:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   215: aload_1
    //   216: invokestatic 955	bhlg:h	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   219: astore_1
    //   220: aload 8
    //   222: aload 8
    //   224: ldc_w 957
    //   227: invokeinterface 208 2 0
    //   232: invokeinterface 943 2 0
    //   237: istore_3
    //   238: iload_3
    //   239: invokestatic 958	bhnt:a	(I)Z
    //   242: ifeq +421 -> 663
    //   245: aload_0
    //   246: invokevirtual 960	com/tencent/mobileqq/activity/ChatHistory:a	()Ljava/lang/String;
    //   249: astore 9
    //   251: aload 8
    //   253: ldc_w 962
    //   256: invokeinterface 208 2 0
    //   261: iflt +23 -> 284
    //   264: aload 8
    //   266: aload 8
    //   268: ldc_w 962
    //   271: invokeinterface 208 2 0
    //   276: invokeinterface 943 2 0
    //   281: ifgt +388 -> 669
    //   284: aload 8
    //   286: aload 8
    //   288: ldc_w 963
    //   291: invokeinterface 208 2 0
    //   296: invokeinterface 946 2 0
    //   301: astore_1
    //   302: aconst_null
    //   303: astore 6
    //   305: aload_1
    //   306: ifnull +17 -> 323
    //   309: new 965	begp
    //   312: dup
    //   313: aload_1
    //   314: iconst_3
    //   315: invokespecial 968	begp:<init>	(Ljava/lang/CharSequence;I)V
    //   318: invokevirtual 969	begp:a	()Ljava/lang/String;
    //   321: astore 6
    //   323: aload 6
    //   325: astore 7
    //   327: aload 6
    //   329: ifnull +67 -> 396
    //   332: aload 6
    //   334: astore 7
    //   336: aload 6
    //   338: invokevirtual 401	java/lang/String:length	()I
    //   341: ifle +55 -> 396
    //   344: aload 6
    //   346: astore 7
    //   348: aload_0
    //   349: aload 6
    //   351: invokevirtual 971	com/tencent/mobileqq/activity/ChatHistory:b	(Ljava/lang/String;)Z
    //   354: ifeq +42 -> 396
    //   357: aload 6
    //   359: ldc_w 973
    //   362: invokevirtual 976	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   365: iconst_1
    //   366: aaload
    //   367: ldc_w 978
    //   370: invokevirtual 976	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   373: astore 7
    //   375: aload 7
    //   377: arraylength
    //   378: iconst_2
    //   379: if_icmpge +853 -> 1232
    //   382: iconst_1
    //   383: istore_3
    //   384: goto +933 -> 1317
    //   387: aload_0
    //   388: ldc_w 979
    //   391: invokevirtual 502	com/tencent/mobileqq/activity/ChatHistory:getString	(I)Ljava/lang/String;
    //   394: astore 7
    //   396: new 146	java/lang/StringBuilder
    //   399: dup
    //   400: invokespecial 300	java/lang/StringBuilder:<init>	()V
    //   403: aload_0
    //   404: iload 4
    //   406: i2l
    //   407: ldc2_w 980
    //   410: lmul
    //   411: invokevirtual 983	com/tencent/mobileqq/activity/ChatHistory:a	(J)Ljava/lang/String;
    //   414: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   417: ldc_w 985
    //   420: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   423: aload 9
    //   425: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   428: ldc_w 987
    //   431: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   434: aload 7
    //   436: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   439: invokevirtual 176	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   442: astore 6
    //   444: aload 10
    //   446: new 146	java/lang/StringBuilder
    //   449: dup
    //   450: invokespecial 300	java/lang/StringBuilder:<init>	()V
    //   453: aload 6
    //   455: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   458: ldc_w 989
    //   461: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   464: invokevirtual 176	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   467: invokevirtual 482	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   470: pop
    //   471: aload_1
    //   472: astore 6
    //   474: aload 8
    //   476: invokeinterface 992 1 0
    //   481: ifne -329 -> 152
    //   484: aload 8
    //   486: ifnull +10 -> 496
    //   489: aload 8
    //   491: invokeinterface 221 1 0
    //   496: aload_0
    //   497: new 994	com/tencent/mobileqq/activity/ChatHistory$21
    //   500: dup
    //   501: aload_0
    //   502: getstatic 999	antf:bb	Ljava/lang/String;
    //   505: aload_0
    //   506: getfield 68	com/tencent/mobileqq/activity/ChatHistory:jdField_a_of_type_JavaLangStringBuffer	Ljava/lang/StringBuffer;
    //   509: invokevirtual 491	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   512: aload 10
    //   514: invokevirtual 491	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   517: invokestatic 1004	bhmi:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z
    //   520: invokespecial 1007	com/tencent/mobileqq/activity/ChatHistory$21:<init>	(Lcom/tencent/mobileqq/activity/ChatHistory;Z)V
    //   523: invokevirtual 1011	com/tencent/mobileqq/activity/ChatHistory:runOnUiThread	(Ljava/lang/Runnable;)V
    //   526: return
    //   527: new 146	java/lang/StringBuilder
    //   530: dup
    //   531: invokespecial 300	java/lang/StringBuilder:<init>	()V
    //   534: ldc_w 1013
    //   537: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   540: invokestatic 156	adak:b	()Ljava/lang/String;
    //   543: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   546: ldc_w 1015
    //   549: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   552: invokevirtual 176	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   555: astore 6
    //   557: aload_1
    //   558: iload_2
    //   559: invokestatic 168	com/tencent/mobileqq/data/MessageRecord:getOldTableName	(Ljava/lang/String;I)Ljava/lang/String;
    //   562: aload_1
    //   563: iload_2
    //   564: invokestatic 171	com/tencent/mobileqq/data/MessageRecord:getTableName	(Ljava/lang/String;I)Ljava/lang/String;
    //   567: aload_0
    //   568: getfield 282	com/tencent/mobileqq/activity/ChatHistory:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   571: invokevirtual 144	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/SQLiteDatabase;
    //   574: aload 6
    //   576: aconst_null
    //   577: invokestatic 417	bhnp:a	(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/app/SQLiteDatabase;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   580: astore 6
    //   582: goto -535 -> 47
    //   585: ldc_w 1017
    //   588: iconst_2
    //   589: anewarray 84	java/lang/Object
    //   592: dup
    //   593: iconst_0
    //   594: aload_0
    //   595: getfield 282	com/tencent/mobileqq/activity/ChatHistory:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   598: aload_0
    //   599: getfield 287	com/tencent/mobileqq/activity/ChatHistory:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   602: aload_1
    //   603: invokestatic 955	bhlg:h	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   606: aastore
    //   607: dup
    //   608: iconst_1
    //   609: aload_1
    //   610: aastore
    //   611: invokestatic 1020	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   614: astore_1
    //   615: goto -395 -> 220
    //   618: sipush 3000
    //   621: iload_2
    //   622: if_icmpne +33 -> 655
    //   625: ldc_w 1017
    //   628: iconst_2
    //   629: anewarray 84	java/lang/Object
    //   632: dup
    //   633: iconst_0
    //   634: aload_0
    //   635: getfield 282	com/tencent/mobileqq/activity/ChatHistory:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   638: aload_1
    //   639: iconst_0
    //   640: invokestatic 932	bhlg:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;I)Ljava/lang/String;
    //   643: aastore
    //   644: dup
    //   645: iconst_1
    //   646: aload_1
    //   647: aastore
    //   648: invokestatic 1020	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   651: astore_1
    //   652: goto -432 -> 220
    //   655: aload_0
    //   656: getfield 1022	com/tencent/mobileqq/activity/ChatHistory:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   659: astore_1
    //   660: goto -440 -> 220
    //   663: aload_1
    //   664: astore 9
    //   666: goto -415 -> 251
    //   669: aload 8
    //   671: aload 8
    //   673: ldc_w 1024
    //   676: invokeinterface 208 2 0
    //   681: invokeinterface 943 2 0
    //   686: istore 5
    //   688: iload 5
    //   690: sipush -2007
    //   693: if_icmpne +14 -> 707
    //   696: aload_0
    //   697: ldc_w 1025
    //   700: invokevirtual 502	com/tencent/mobileqq/activity/ChatHistory:getString	(I)Ljava/lang/String;
    //   703: astore_1
    //   704: goto -402 -> 302
    //   707: iload 5
    //   709: sipush -2058
    //   712: if_icmpne +14 -> 726
    //   715: aload_0
    //   716: ldc_w 1026
    //   719: invokevirtual 502	com/tencent/mobileqq/activity/ChatHistory:getString	(I)Ljava/lang/String;
    //   722: astore_1
    //   723: goto -421 -> 302
    //   726: iload 5
    //   728: sipush -2039
    //   731: if_icmpne +50 -> 781
    //   734: aload 8
    //   736: aload 8
    //   738: ldc_w 1028
    //   741: invokeinterface 208 2 0
    //   746: invokeinterface 1032 2 0
    //   751: astore_1
    //   752: new 1034	com/tencent/mobileqq/data/MessageForApollo
    //   755: dup
    //   756: invokespecial 1035	com/tencent/mobileqq/data/MessageForApollo:<init>	()V
    //   759: astore 6
    //   761: aload 6
    //   763: aload_1
    //   764: putfield 1038	com/tencent/mobileqq/data/MessageForApollo:msgData	[B
    //   767: aload 6
    //   769: invokevirtual 1041	com/tencent/mobileqq/data/MessageForApollo:parse	()V
    //   772: aload 6
    //   774: invokestatic 1046	com/tencent/mobileqq/apollo/utils/ApolloUtil:a	(Lcom/tencent/mobileqq/data/MessageForApollo;)Ljava/lang/String;
    //   777: astore_1
    //   778: goto -476 -> 302
    //   781: iload 5
    //   783: sipush -2011
    //   786: if_icmpne +31 -> 817
    //   789: aload_0
    //   790: aload 8
    //   792: aload 8
    //   794: ldc_w 1028
    //   797: invokeinterface 208 2 0
    //   802: invokeinterface 1032 2 0
    //   807: invokestatic 1051	bdow:a	([B)Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   810: invokevirtual 1053	com/tencent/mobileqq/activity/ChatHistory:a	(Lcom/tencent/mobileqq/structmsg/AbsStructMsg;)Ljava/lang/String;
    //   813: astore_1
    //   814: goto -512 -> 302
    //   817: iload 5
    //   819: sipush -2020
    //   822: if_icmpne +58 -> 880
    //   825: iload_3
    //   826: invokestatic 958	bhnt:a	(I)Z
    //   829: ifeq +34 -> 863
    //   832: aload_0
    //   833: getfield 282	com/tencent/mobileqq/activity/ChatHistory:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   836: invokevirtual 1057	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   839: ldc_w 1058
    //   842: iconst_1
    //   843: anewarray 84	java/lang/Object
    //   846: dup
    //   847: iconst_0
    //   848: aload_0
    //   849: getfield 855	com/tencent/mobileqq/activity/ChatHistory:jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo	Lcom/tencent/mobileqq/activity/aio/SessionInfo;
    //   852: getfield 1062	com/tencent/mobileqq/activity/aio/SessionInfo:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   855: aastore
    //   856: invokevirtual 1067	com/tencent/qphone/base/util/BaseApplication:getString	(I[Ljava/lang/Object;)Ljava/lang/String;
    //   859: astore_1
    //   860: goto -558 -> 302
    //   863: aload_0
    //   864: getfield 282	com/tencent/mobileqq/activity/ChatHistory:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   867: invokevirtual 1057	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   870: ldc_w 1068
    //   873: invokevirtual 1069	com/tencent/qphone/base/util/BaseApplication:getString	(I)Ljava/lang/String;
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
    //   899: ldc_w 1070
    //   902: invokestatic 1074	anzj:a	(I)Ljava/lang/String;
    //   905: astore_1
    //   906: goto -604 -> 302
    //   909: iload 5
    //   911: sipush -2002
    //   914: if_icmpne +13 -> 927
    //   917: ldc_w 1075
    //   920: invokestatic 1074	anzj:a	(I)Ljava/lang/String;
    //   923: astore_1
    //   924: goto -622 -> 302
    //   927: iload 5
    //   929: sipush -2022
    //   932: if_icmpne +13 -> 945
    //   935: ldc_w 1076
    //   938: invokestatic 1074	anzj:a	(I)Ljava/lang/String;
    //   941: astore_1
    //   942: goto -640 -> 302
    //   945: iload 5
    //   947: sipush -2071
    //   950: if_icmpne +14 -> 964
    //   953: aload_0
    //   954: ldc_w 1077
    //   957: invokevirtual 502	com/tencent/mobileqq/activity/ChatHistory:getString	(I)Ljava/lang/String;
    //   960: astore_1
    //   961: goto -659 -> 302
    //   964: iload 5
    //   966: sipush -7001
    //   969: if_icmpne +14 -> 983
    //   972: aload_0
    //   973: ldc_w 1078
    //   976: invokevirtual 502	com/tencent/mobileqq/activity/ChatHistory:getString	(I)Ljava/lang/String;
    //   979: astore_1
    //   980: goto -678 -> 302
    //   983: iload 5
    //   985: sipush -1035
    //   988: if_icmpne +202 -> 1190
    //   991: new 146	java/lang/StringBuilder
    //   994: dup
    //   995: invokespecial 300	java/lang/StringBuilder:<init>	()V
    //   998: astore_1
    //   999: aload 8
    //   1001: aload 8
    //   1003: ldc_w 1028
    //   1006: invokeinterface 208 2 0
    //   1011: invokeinterface 1032 2 0
    //   1016: astore 7
    //   1018: new 1080	localpb/richMsg/MixedMsg$Msg
    //   1021: dup
    //   1022: invokespecial 1081	localpb/richMsg/MixedMsg$Msg:<init>	()V
    //   1025: astore 6
    //   1027: aload 6
    //   1029: aload 7
    //   1031: invokevirtual 1085	localpb/richMsg/MixedMsg$Msg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   1034: pop
    //   1035: aload 6
    //   1037: getfield 1089	localpb/richMsg/MixedMsg$Msg:elems	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   1040: invokevirtual 1095	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   1043: invokeinterface 1100 1 0
    //   1048: ifgt +51 -> 1099
    //   1051: aload 8
    //   1053: ifnull -527 -> 526
    //   1056: aload 8
    //   1058: invokeinterface 221 1 0
    //   1063: return
    //   1064: astore 6
    //   1066: invokestatic 299	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1069: ifeq +12 -> 1081
    //   1072: ldc 61
    //   1074: iconst_2
    //   1075: ldc_w 1102
    //   1078: invokestatic 308	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1081: aload_1
    //   1082: invokevirtual 176	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1085: astore_1
    //   1086: goto -784 -> 302
    //   1089: astore 7
    //   1091: aload 7
    //   1093: invokevirtual 1105	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:printStackTrace	()V
    //   1096: goto -61 -> 1035
    //   1099: aload 6
    //   1101: getfield 1089	localpb/richMsg/MixedMsg$Msg:elems	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   1104: invokevirtual 1095	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   1107: invokeinterface 1100 1 0
    //   1112: istore 5
    //   1114: iconst_0
    //   1115: istore_3
    //   1116: iload_3
    //   1117: iload 5
    //   1119: if_icmpge -38 -> 1081
    //   1122: aload 6
    //   1124: getfield 1089	localpb/richMsg/MixedMsg$Msg:elems	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   1127: invokevirtual 1095	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   1130: iload_3
    //   1131: invokeinterface 1108 2 0
    //   1136: checkcast 1110	localpb/richMsg/MixedMsg$Elem
    //   1139: astore 7
    //   1141: aload 7
    //   1143: getfield 1114	localpb/richMsg/MixedMsg$Elem:textMsg	Lcom/tencent/mobileqq/pb/PBStringField;
    //   1146: invokevirtual 1119	com/tencent/mobileqq/pb/PBStringField:has	()Z
    //   1149: ifeq +19 -> 1168
    //   1152: aload_1
    //   1153: aload 7
    //   1155: getfield 1114	localpb/richMsg/MixedMsg$Elem:textMsg	Lcom/tencent/mobileqq/pb/PBStringField;
    //   1158: invokevirtual 1121	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   1161: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1164: pop
    //   1165: goto +167 -> 1332
    //   1168: aload 7
    //   1170: getfield 1125	localpb/richMsg/MixedMsg$Elem:picMsg	Llocalpb/richMsg/RichMsg$PicRec;
    //   1173: invokevirtual 1128	localpb/richMsg/RichMsg$PicRec:has	()Z
    //   1176: ifeq +156 -> 1332
    //   1179: aload_1
    //   1180: ldc_w 1130
    //   1183: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1186: pop
    //   1187: goto +145 -> 1332
    //   1190: new 214	java/lang/String
    //   1193: dup
    //   1194: aload 8
    //   1196: aload 8
    //   1198: ldc_w 1028
    //   1201: invokeinterface 208 2 0
    //   1206: invokeinterface 1032 2 0
    //   1211: ldc_w 1132
    //   1214: invokespecial 1135	java/lang/String:<init>	([BLjava/lang/String;)V
    //   1217: astore_1
    //   1218: goto -916 -> 302
    //   1221: astore_1
    //   1222: aload_1
    //   1223: invokevirtual 1136	java/lang/Exception:printStackTrace	()V
    //   1226: aload 6
    //   1228: astore_1
    //   1229: goto -927 -> 302
    //   1232: aload 7
    //   1234: iconst_2
    //   1235: aaload
    //   1236: invokestatic 1141	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   1239: invokevirtual 1144	java/lang/Integer:intValue	()I
    //   1242: istore_3
    //   1243: goto +74 -> 1317
    //   1246: aload 6
    //   1248: astore 7
    //   1250: iload_3
    //   1251: iconst_2
    //   1252: if_icmpne -856 -> 396
    //   1255: new 146	java/lang/StringBuilder
    //   1258: dup
    //   1259: invokespecial 300	java/lang/StringBuilder:<init>	()V
    //   1262: ldc_w 479
    //   1265: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1268: aload_0
    //   1269: ldc_w 1145
    //   1272: invokevirtual 502	com/tencent/mobileqq/activity/ChatHistory:getString	(I)Ljava/lang/String;
    //   1275: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1278: ldc_w 487
    //   1281: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1284: invokevirtual 176	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1287: astore 7
    //   1289: goto -893 -> 396
    //   1292: astore 7
    //   1294: ldc 61
    //   1296: iconst_1
    //   1297: ldc 173
    //   1299: aload 7
    //   1301: invokestatic 1148	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
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
    //   1323: ldc_w 1149
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
    this.jdField_a_of_type_AndroidViewView = ((RelativeLayout)View.inflate(this, 2131562854, null));
    int n = (int)bhmg.a(this, 6.0F);
    Object localObject = new RelativeLayout(this);
    ((RelativeLayout)localObject).setPadding(0, n, 0, n);
    ((RelativeLayout)localObject).setBackgroundResource(2130850330);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, getResources().getDimensionPixelSize(2131298729));
    ((RelativeLayout)localObject).addView(this.jdField_a_of_type_AndroidViewView, localLayoutParams);
    this.jdField_a_of_type_ComTencentWidgetXListView.addHeaderView((View)localObject);
    this.jdField_a_of_type_AndroidViewView.findViewById(2131363745).setVisibility(8);
    localObject = (EditText)this.jdField_a_of_type_AndroidViewView.findViewById(2131366151);
    ((EditText)localObject).setFocusableInTouchMode(false);
    ((EditText)localObject).setCursorVisible(false);
    ((EditText)localObject).setOnClickListener(new aedc(this));
    setLayerType(this.jdField_a_of_type_AndroidViewView);
  }
  
  protected void c(String paramString)
  {
    if (this.jdField_b_of_type_Bjbs == null) {
      this.jdField_b_of_type_Bjbs = new bjbs(this, getTitleBarHeight());
    }
    this.jdField_b_of_type_Bjbs.setCancelable(true);
    this.jdField_b_of_type_Bjbs.a(paramString);
    this.jdField_b_of_type_Bjbs.show();
  }
  
  public boolean c(String paramString)
  {
    o();
    MediaPlayerManager.a(this.app).a(true);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer == null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer = new AudioPlayer(this, this.jdField_a_of_type_Agfs);
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
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131368350));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131368351));
    this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(getString(2131690653));
    this.jdField_b_of_type_AndroidWidgetImageView.setContentDescription(getString(2131690652));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new aedd(this));
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(new aecg(this));
    this.jdField_b_of_type_AndroidWidgetImageView.setEnabled(false);
    this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130849596);
    if (this.jdField_c_of_type_Int == 1)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setEnabled(false);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130840479);
    }
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131378626));
    this.jdField_b_of_type_AndroidWidgetTextView.setText(String.valueOf(this.jdField_c_of_type_Int));
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131365830));
    this.jdField_a_of_type_AndroidWidgetEditText.setText(String.valueOf(this.jdField_d_of_type_Int));
    this.jdField_a_of_type_AndroidWidgetEditText.setSelection(this.jdField_a_of_type_AndroidWidgetEditText.getText().toString().length());
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(new aech(this));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131364036));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new aeci(this));
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)findViewById(2131364035));
    this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(new aecj(this));
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
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(new aeck(this));
      return;
      if ((this.jdField_a_of_type_Int != 1) && (this.jdField_a_of_type_Int != 3000))
      {
        anyw localanyw = (anyw)this.app.getManager(51);
        if ((localanyw == null) || (!localanyw.b(String.valueOf(this.jdField_b_of_type_JavaLangString))))
        {
          if (QLog.isColorLevel()) {
            QLog.e("ChatHistory", 2, "--mSyncHistory button: fm is null or the uin is not my friend: fm:" + localanyw);
          }
          this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
        }
      }
    }
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool);
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
      this.jdField_a_of_type_Aede.getCursor().requery();
      return;
    } while (-1 != paramInt2);
    a(paramIntent.getExtras());
  }
  
  @TargetApi(14)
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    addObserver(this.jdField_a_of_type_Aocj);
    this.jdField_a_of_type_Float = getResources().getDisplayMetrics().density;
    this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable = ((AnimationDrawable)getResources().getDrawable(2130772348));
    this.jdField_b_of_type_AndroidGraphicsDrawableAnimationDrawable = ((AnimationDrawable)getResources().getDrawable(2130772349));
    this.jdField_c_of_type_AndroidGraphicsDrawableAnimationDrawable = ((AnimationDrawable)getResources().getDrawable(2130772269));
    paramBundle = getIntent().getExtras();
    this.jdField_b_of_type_JavaLangString = paramBundle.getString("uin");
    this.jdField_a_of_type_Int = paramBundle.getInt("uintype");
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = new SessionInfo();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString = paramBundle.getString("troop_uin");
    setContentViewNoTitle(2131558877);
    LinearLayout localLinearLayout = (LinearLayout)findViewById(2131376925);
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
    this.jdField_a_of_type_Azor = ((azor)this.app.getManager(201));
    a(9, false);
    m();
    a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Int);
    q();
    if (this.app.a() != null) {
      this.app.a().addProxyObserver(this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyObserver);
    }
    this.app.a().saveNotify();
    this.jdField_a_of_type_Bhhm = new bhhm(this);
    this.jdField_a_of_type_Bhhm.a((int)(150.0F * this.jdField_a_of_type_Float), (int)(100.0F * this.jdField_a_of_type_Float));
    s();
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.jdField_a_of_type_Aede != null) {
      this.jdField_a_of_type_Aede.a();
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
      QLog.i("ChatHistory", 2, "onDestroy() mCurPlayingPttInfo = " + this.jdField_a_of_type_Aedp);
    }
    if ((this.jdField_a_of_type_Aedp != null) && (!this.jdField_a_of_type_Aedp.jdField_a_of_type_Boolean))
    {
      this.jdField_a_of_type_Aedp.d();
      this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable.stop();
      this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable = null;
      this.jdField_b_of_type_AndroidGraphicsDrawableAnimationDrawable.stop();
      this.jdField_b_of_type_AndroidGraphicsDrawableAnimationDrawable = null;
      this.jdField_c_of_type_AndroidGraphicsDrawableAnimationDrawable.stop();
      this.jdField_c_of_type_AndroidGraphicsDrawableAnimationDrawable = null;
    }
    this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
    this.app.removeHandler(getClass());
    removeObserver(this.jdField_a_of_type_Aocj);
    if (this.app.a() != null) {
      this.app.a().removeProxyObserver(this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyObserver);
    }
    this.app.a().saveNotify();
    try
    {
      this.jdField_a_of_type_Bhhm.a().a();
      label251:
      findViewById(2131376925).clearAnimation();
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
      QLog.i("ChatHistory", 2, "onPause() mCurPlayingPttInfo = " + this.jdField_a_of_type_Aedp);
    }
    if ((this.jdField_a_of_type_Aedp != null) && (!this.jdField_a_of_type_Aedp.jdField_a_of_type_Boolean)) {
      this.jdField_a_of_type_Aedp.d();
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
    this.jdField_a_of_type_Aede.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Int, this.jdField_e_of_type_Int);
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
    this.jdField_a_of_type_Aede.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Int, this.jdField_e_of_type_Int);
  }
  
  public void h()
  {
    this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(4, getResources().getString(2131718370)).sendToTarget();
    this.app.a().a((short)1, (byte)1);
  }
  
  public void i()
  {
    aocm localaocm = (aocm)this.app.getManager(92);
    if (localaocm != null)
    {
      long l1 = NetConnInfoCenter.getServerTime();
      this.app.a().a(this.jdField_b_of_type_JavaLangString, l1 - 604800L, 0L, l1, (short)0, 0L, 1, null, localaocm.b(), false, 0, false);
    }
  }
  
  protected void j()
  {
    if (!bhnv.d(this.app.getApplication().getApplicationContext()))
    {
      QQToast.a(getApplicationContext(), 2131691340, 1).a();
      return;
    }
    c(getApplication().getResources().getString(2131691341));
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
      boolean bool = bhmi.a(antf.bb, this.jdField_a_of_type_JavaLangStringBuffer, ".txt");
      this.jdField_c_of_type_AndroidAppDialog = bhlq.a(this, 230, getString(2131690920), getString(2131690920) + antf.bb + this.jdField_a_of_type_JavaLangStringBuffer.toString(), new aecn(this), new aeco(this));
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
    b(getString(2131691904));
  }
  
  public void l()
  {
    this.jdField_c_of_type_AndroidAppDialog = bhlq.a(this, 230, getString(2131718371), getString(2131718710), new aecp(this), new aecr(this));
    this.jdField_c_of_type_AndroidAppDialog.show();
  }
  
  protected void m()
  {
    String str = getResources().getString(2131690644);
    if (this.jdField_a_of_type_Int == 0) {
      if (this.jdField_b_of_type_JavaLangString.equals(String.valueOf(antf.G)))
      {
        this.jdField_c_of_type_JavaLangString = getResources().getString(2131718503);
        if (!this.jdField_b_of_type_JavaLangString.equals(String.valueOf(antf.G))) {
          break label375;
        }
        str = getResources().getString(2131718503);
      }
    }
    label375:
    for (;;)
    {
      if ((this.jdField_c_of_type_JavaLangString == null) || (this.jdField_c_of_type_JavaLangString.trim().equals(""))) {
        this.jdField_c_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
      }
      setTitle(str);
      this.jdField_d_of_type_JavaLangString = a();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
      this.leftView = ((TextView)findViewById(2131369042));
      return;
      this.jdField_c_of_type_JavaLangString = bhlg.a(this.app, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString, bhlg.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int), 3);
      break;
      if (this.jdField_a_of_type_Int == 1)
      {
        this.jdField_c_of_type_JavaLangString = ((TroopManager)this.app.getManager(52)).a(this.jdField_b_of_type_JavaLangString);
      }
      else if ((this.jdField_a_of_type_Int == 1000) || (this.jdField_a_of_type_Int == 1020) || (this.jdField_a_of_type_Int == 1001) || (this.jdField_a_of_type_Int == 10002) || (this.jdField_a_of_type_Int == 10004) || (this.jdField_a_of_type_Int == 1004) || (this.jdField_a_of_type_Int == 10010))
      {
        this.jdField_c_of_type_JavaLangString = bhlg.i(this.app, this.jdField_b_of_type_JavaLangString);
      }
      else if (this.jdField_a_of_type_Int == 3000)
      {
        this.jdField_c_of_type_JavaLangString = bhlg.d(this.app, this.jdField_b_of_type_JavaLangString);
      }
      else if (this.jdField_a_of_type_Int == 1024)
      {
        PublicAccountInfo localPublicAccountInfo = ((aody)this.app.getManager(56)).b(this.jdField_b_of_type_JavaLangString);
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
        blgx.b(this.jdField_a_of_type_AndroidWidgetEditText);
      }
      setResult(-1);
      if ((this.jdField_a_of_type_Akjn != null) && (this.jdField_a_of_type_Akjn.a()))
      {
        this.jdField_a_of_type_Akjn.show();
        this.jdField_a_of_type_Akjn.a(false);
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
      localTextView.setText(2131717515);
      this.jdField_a_of_type_AndroidWidgetTextView = localTextView;
      return localTextView;
      this.rightViewText.setVisibility(0);
    }
  }
  
  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    boolean bool2 = true;
    if (agej.b()) {}
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
    for (int n = 2131718359;; n = 2131718361)
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
    bhkm.b(2131230731, false);
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
      if (this.jdField_b_of_type_Bjbs != null)
      {
        this.jdField_b_of_type_Bjbs.dismiss();
        this.jdField_b_of_type_Bjbs.cancel();
        this.jdField_b_of_type_Bjbs = null;
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
      bdll.b(this.app, "CliOper", "", "", "AIO", "AIO_chatlog", this.k, 0, String.valueOf(this.k), "", "", "");
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
    bdll.b(this.app, "CliOper", "", "", "0X8005690", "0X8005690", this.k, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatHistory
 * JD-Core Version:    0.7.0.1
 */