package com.tencent.mobileqq.activity;

import ActionMsg.MsgBody;
import aaqf;
import aaqh;
import aaqi;
import aaqj;
import aaqk;
import aaql;
import aaqm;
import aaqn;
import aaqo;
import aaqp;
import aaqq;
import aaqr;
import aaqs;
import aaqt;
import aaqu;
import aaqv;
import aaqw;
import aaqx;
import aaqz;
import aara;
import aarb;
import aarc;
import aard;
import aare;
import aarf;
import aaro;
import aarq;
import actj;
import acts;
import ager;
import ajsd;
import ajxl;
import akat;
import akaw;
import akdh;
import akpx;
import akte;
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
import aobp;
import aoze;
import aukp;
import aukq;
import aumb;
import axqy;
import aywk;
import bazh;
import bazl;
import bbbu;
import bbcf;
import bbcz;
import bbdj;
import bbdv;
import bbdx;
import bbfd;
import bbfh;
import bbfj;
import bbgu;
import bcqf;
import bcql;
import bfni;
import bfnk;
import bfos;
import bfpc;
import bfpp;
import com.tencent.common.config.AppSetting;
import com.tencent.image.ApngImage;
import com.tencent.image.URLDrawable;
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
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.widget.TipsBar;
import com.tencent.qphone.base.util.QLog;
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
  public aarf a;
  public aaro a;
  public aarq a;
  protected acts a;
  public ager a;
  protected akat a;
  protected akte a;
  public Dialog a;
  public AnimationDrawable a;
  protected Sensor a;
  public SensorManager a;
  Handler.Callback jdField_a_of_type_AndroidOsHandler$Callback = new aaqf(this);
  public Handler a;
  View jdField_a_of_type_AndroidViewView;
  protected Button a;
  public EditText a;
  public ImageView a;
  public TextView a;
  protected aukp a;
  public aumb a;
  bazl jdField_a_of_type_Bazl;
  public bcqf a;
  bfos jdField_a_of_type_Bfos = new aaqw(this);
  protected AudioPlayer a;
  public SessionInfo a;
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
  protected bcqf b;
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
    this.jdField_a_of_type_Aumb = null;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_a_of_type_MqqOsMqqHandler = new bfnk(this.jdField_a_of_type_AndroidOsHandler$Callback);
    this.jdField_a_of_type_AndroidOsHandler = new aaqr(this);
    this.jdField_a_of_type_Aaro = new aaro(this);
    this.jdField_a_of_type_Akat = new aaqt(this);
    this.jdField_a_of_type_Akte = new aaqu(this);
    this.jdField_a_of_type_Acts = new aaqv(this);
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
      paramQQAppInterface.append(akpx.b());
      paramQQAppInterface.append(" and isValid=1 ");
    }
    for (paramQQAppInterface = bbfd.a(MessageRecord.getOldTableName(paramString, paramInt), MessageRecord.getTableName(paramString, paramInt), localSQLiteDatabase, "", paramQQAppInterface.toString(), ""); paramQQAppInterface == null; paramQQAppInterface = bbfd.a(MessageRecord.getOldTableName(paramString, paramInt), MessageRecord.getTableName(paramString, paramInt), localSQLiteDatabase, paramQQAppInterface.toString()))
    {
      return 0;
      paramQQAppInterface = new StringBuilder(" where msgtype ");
      paramQQAppInterface.append(akpx.b());
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
    this.jdField_a_of_type_Aarf.jdField_c_of_type_Int = ((paramInt - 1) % 8);
    this.jdField_a_of_type_AndroidWidgetEditText.setText(String.valueOf(n));
    this.jdField_a_of_type_AndroidWidgetEditText.setSelection(this.jdField_a_of_type_AndroidWidgetEditText.getText().length());
  }
  
  public MsgBody a(int paramInt1, int paramInt2, String paramString, int paramInt3)
  {
    if (((paramInt2 != -1003) && (paramInt2 != -1032) && (paramInt2 != -1031) && (paramInt2 != 201)) || ((paramInt1 == 1001) || (paramInt1 == 10002) || (bbbu.a(paramInt2)) || (paramInt2 == -3001) || (paramInt2 == -30002) || (paramInt2 == -30003))) {
      return bbbu.a(paramString);
    }
    if (paramInt2 == -2009)
    {
      localMsgBody = new MsgBody();
      boolean bool = bbfh.b(paramInt3);
      localMsgBody.msg = bbfh.a(aywk.a(paramString), this, bool, false);
      localMsgBody.action = null;
      return localMsgBody;
    }
    if (paramInt2 == -2016)
    {
      localMsgBody = new MsgBody();
      localMsgBody.msg = bbfh.a(this.app, aywk.a(paramString), this, this.jdField_b_of_type_JavaLangString, null, this.jdField_a_of_type_Int);
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
      paramString2 = bbfd.b(paramString2, paramString1, localSQLiteDatabase, paramString3);
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
          paramString2 = bbfd.b(paramString2, paramString1, localSQLiteDatabase, paramString3);
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
        paramString2 = bbfd.a(paramString2, paramString1, localSQLiteDatabase, paramString3, null);
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
  
  public aukp a()
  {
    if ((this.jdField_a_of_type_Aukp == null) || (!this.jdField_a_of_type_Aukp.a())) {}
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if ((this.jdField_a_of_type_Aukp == null) || (!this.jdField_a_of_type_Aukp.a())) {
        this.jdField_a_of_type_Aukp = this.app.getEntityManagerFactory().createMessageRecordEntityManager();
      }
      return this.jdField_a_of_type_Aukp;
    }
  }
  
  protected String a()
  {
    String str = bbcz.h(this.app, this.app.getCurrentAccountUin());
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
        localStringBuffer.append(" " + getString(2131719813) + " ");
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
    this.jdField_a_of_type_ComTencentMobileqqWidgetTipsBar.setTipsIcon(getActivity().getResources().getDrawable(2130838101));
    localRelativeLayout.addView(this.jdField_a_of_type_ComTencentMobileqqWidgetTipsBar, localLayoutParams);
    this.jdField_a_of_type_ComTencentWidgetXListView.addHeaderView(localRelativeLayout);
    this.jdField_a_of_type_ComTencentMobileqqWidgetTipsBar.setOnClickListener(new aaqz(this));
    this.jdField_c_of_type_AndroidWidgetTextView = this.jdField_a_of_type_ComTencentMobileqqWidgetTipsBar.a();
    this.jdField_a_of_type_ComTencentMobileqqWidgetTipsBar.setVisibility(8);
  }
  
  public void a(int paramInt)
  {
    if (paramInt > 0)
    {
      Cursor localCursor = this.jdField_a_of_type_Aarf.getCursor();
      if (localCursor != null) {
        localCursor.requery();
      }
    }
    if ((this.jdField_a_of_type_Int == 0) && (((CheckBox)this.jdField_b_of_type_AndroidAppDialog.findViewById(2131364976)).isChecked()))
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
    bcql.a(this, paramInt, paramString, 0).b(getTitleBarHeight());
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    ThreadManager.getSubThreadHandler().post(new ChatHistory.8(this, paramBoolean, paramInt));
  }
  
  protected void a(Bundle paramBundle)
  {
    Intent localIntent = actj.a(new Intent(this, SplashActivity.class), null);
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
  
  public void a(ImageView paramImageView, aobp paramaobp)
  {
    if ((paramImageView != null) && (paramaobp != null) && (paramaobp.b()))
    {
      paramaobp = paramaobp.a("fromAIO", true);
      Drawable localDrawable = paramImageView.getDrawable();
      if ((localDrawable instanceof URLDrawable)) {
        aobp.b((URLDrawable)localDrawable);
      }
      paramImageView.setImageDrawable(paramaobp);
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
      bfpc localbfpc = (bfpc)bfpp.a(this, null);
      localbfpc.a(getResources().getString(2131696396));
      localbfpc.a(2131691507, 3);
      localbfpc.c(2131690596);
      localbfpc.a(new aaqx(this, paramMessageRecord, localbfpc));
      localbfpc.show();
      return;
      label110:
      QLog.d("Q.msg.delmsg", 2, "startDelMsg is called,mr is null");
    }
  }
  
  public void a(String paramString)
  {
    View localView = getLayoutInflater().inflate(2131558980, null);
    if (1 == this.jdField_a_of_type_Int)
    {
      ((TextView)localView.findViewById(2131377046)).setText(2131691041);
      localView.findViewById(2131364976).setVisibility(8);
    }
    for (;;)
    {
      if (!isFinishing())
      {
        this.jdField_b_of_type_AndroidAppDialog = bbdj.a(this, 230).setTitle(getString(2131691522)).setPositiveButton(getString(2131691507), new aaqn(this, paramString)).setNegativeButton(getString(2131690573), new aaqm(this)).addView(localView);
        this.jdField_b_of_type_AndroidAppDialog.show();
      }
      return;
      if (3000 == this.jdField_a_of_type_Int)
      {
        ((TextView)localView.findViewById(2131377046)).setText(2131691040);
        localView.findViewById(2131364976).setVisibility(8);
      }
      else if ((1001 == this.jdField_a_of_type_Int) || (10002 == this.jdField_a_of_type_Int) || (1000 == this.jdField_a_of_type_Int) || (10004 == this.jdField_a_of_type_Int) || (1020 == this.jdField_a_of_type_Int) || (1004 == this.jdField_a_of_type_Int))
      {
        localView.findViewById(2131364976).setVisibility(8);
      }
    }
  }
  
  @SuppressLint({"NewApi"})
  protected void a(String paramString, int paramInt)
  {
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)findViewById(2131369275));
    c();
    a();
    this.jdField_a_of_type_Aarf = new aarf(this, this, null);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Aarf);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnScrollListener(this.jdField_a_of_type_Bfos);
    this.jdField_a_of_type_ComTencentWidgetXListView.setEdgeEffectEnabled(false);
    if (Build.VERSION.SDK_INT >= 9) {
      this.jdField_a_of_type_ComTencentWidgetXListView.setOverscrollFooter(null);
    }
    this.jdField_a_of_type_Aarf.a(paramString, paramInt, this.jdField_e_of_type_Int);
  }
  
  boolean a(int paramInt)
  {
    if ((paramInt <= 0) || (paramInt > this.jdField_c_of_type_Int * 8)) {
      return false;
    }
    this.jdField_b_of_type_Boolean = true;
    int n = (paramInt - 1) / 8;
    this.jdField_a_of_type_Aarf.jdField_c_of_type_Int = ((paramInt - 1) % 8);
    this.jdField_a_of_type_AndroidWidgetEditText.setText(String.valueOf(n + 1));
    this.jdField_a_of_type_AndroidWidgetEditText.setSelection(this.jdField_a_of_type_AndroidWidgetEditText.getText().length());
    return true;
  }
  
  public void b()
  {
    View localView1 = findViewById(2131377450);
    View localView2 = findViewById(2131375493);
    int n = localView1.getHeight();
    this.jdField_a_of_type_Ager = new ager(this, this.app, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    TranslateAnimation localTranslateAnimation1 = new TranslateAnimation(0.0F, 0.0F, 0.0F, -n);
    localTranslateAnimation1.setDuration(200L);
    localTranslateAnimation1.setFillAfter(true);
    TranslateAnimation localTranslateAnimation2 = new TranslateAnimation(0.0F, 0.0F, -n, 0.0F);
    localTranslateAnimation2.setDuration(200L);
    localTranslateAnimation1.setAnimationListener(new aara(this, localView2, localView1));
    localTranslateAnimation2.setAnimationListener(new aarb(this, localView2, n));
    this.jdField_a_of_type_Ager.setOnDismissListener(new aarc(this, localView2, n, localView1, localTranslateAnimation2));
    localView2.startAnimation(localTranslateAnimation1);
  }
  
  public void b(int paramInt)
  {
    bcql.a(getActivity(), paramInt, 0).b(getResources().getDimensionPixelSize(2131298865));
  }
  
  public void b(ImageView paramImageView)
  {
    if (paramImageView != null)
    {
      this.jdField_c_of_type_AndroidGraphicsDrawableAnimationDrawable.stop();
      paramImageView.setImageDrawable(getResources().getDrawable(2130846223));
    }
  }
  
  public void b(ImageView paramImageView, aobp paramaobp)
  {
    if ((paramImageView != null) && (paramaobp != null) && (paramaobp.b()))
    {
      paramaobp = paramaobp.a("fromAIO", true);
      if ((paramaobp instanceof URLDrawable)) {
        aobp.a((URLDrawable)paramaobp);
      }
      paramImageView.setImageDrawable(paramaobp);
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
    //   22: if_icmpne +514 -> 536
    //   25: aload_1
    //   26: iload_2
    //   27: invokestatic 168	com/tencent/mobileqq/data/MessageRecord:getOldTableName	(Ljava/lang/String;I)Ljava/lang/String;
    //   30: aload_1
    //   31: iload_2
    //   32: invokestatic 171	com/tencent/mobileqq/data/MessageRecord:getTableName	(Ljava/lang/String;I)Ljava/lang/String;
    //   35: aload_0
    //   36: getfield 281	com/tencent/mobileqq/activity/ChatHistory:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   39: invokevirtual 144	com/tencent/mobileqq/app/QQAppInterface:b	()Lcom/tencent/mobileqq/app/SQLiteDatabase;
    //   42: invokestatic 927	bbfd:a	(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/app/SQLiteDatabase;)Ljava/lang/StringBuilder;
    //   45: astore 6
    //   47: aload 6
    //   49: ifnull +1252 -> 1301
    //   52: aload_0
    //   53: getfield 281	com/tencent/mobileqq/activity/ChatHistory:app	Lcom/tencent/mobileqq/app/QQAppInterface;
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
    //   76: getfield 281	com/tencent/mobileqq/activity/ChatHistory:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   79: aload_1
    //   80: iconst_1
    //   81: invokestatic 930	bbcz:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;I)Ljava/lang/String;
    //   84: astore_1
    //   85: aload 10
    //   87: new 146	java/lang/StringBuilder
    //   90: dup
    //   91: invokespecial 299	java/lang/StringBuilder:<init>	()V
    //   94: aload_0
    //   95: ldc_w 931
    //   98: invokevirtual 500	com/tencent/mobileqq/activity/ChatHistory:getString	(I)Ljava/lang/String;
    //   101: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: ldc_w 933
    //   107: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: invokevirtual 176	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   113: invokevirtual 480	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   116: pop
    //   117: aload 10
    //   119: aload_1
    //   120: invokevirtual 480	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   123: pop
    //   124: aload 10
    //   126: ldc_w 935
    //   129: invokevirtual 480	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   132: pop
    //   133: aload 8
    //   135: ifnull +358 -> 493
    //   138: aload 8
    //   140: invokeinterface 938 1 0
    //   145: ifeq +348 -> 493
    //   148: aload 7
    //   150: astore 6
    //   152: aload 8
    //   154: aload 8
    //   156: ldc 222
    //   158: invokeinterface 207 2 0
    //   163: invokeinterface 941 2 0
    //   168: istore 4
    //   170: aload 8
    //   172: aload 8
    //   174: ldc_w 943
    //   177: invokeinterface 207 2 0
    //   182: invokeinterface 944 2 0
    //   187: astore_1
    //   188: iconst_1
    //   189: iload_2
    //   190: if_icmpne +437 -> 627
    //   193: aload_0
    //   194: getfield 281	com/tencent/mobileqq/activity/ChatHistory:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   197: aload_0
    //   198: getfield 286	com/tencent/mobileqq/activity/ChatHistory:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   201: invokestatic 950	com/tencent/mobileqq/data/TroopInfo:isQidianPrivateTroop	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;)Z
    //   204: ifeq +390 -> 594
    //   207: aload_0
    //   208: getfield 281	com/tencent/mobileqq/activity/ChatHistory:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   211: aload_0
    //   212: getfield 286	com/tencent/mobileqq/activity/ChatHistory:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   215: aload_1
    //   216: invokestatic 953	bbcz:h	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   219: astore_1
    //   220: aload 8
    //   222: aload 8
    //   224: ldc_w 955
    //   227: invokeinterface 207 2 0
    //   232: invokeinterface 941 2 0
    //   237: istore_3
    //   238: iload_3
    //   239: invokestatic 956	bbfh:a	(I)Z
    //   242: ifeq +430 -> 672
    //   245: aload_0
    //   246: invokevirtual 958	com/tencent/mobileqq/activity/ChatHistory:a	()Ljava/lang/String;
    //   249: astore 9
    //   251: aload 8
    //   253: ldc_w 960
    //   256: invokeinterface 207 2 0
    //   261: iflt +23 -> 284
    //   264: aload 8
    //   266: aload 8
    //   268: ldc_w 960
    //   271: invokeinterface 207 2 0
    //   276: invokeinterface 941 2 0
    //   281: ifgt +397 -> 678
    //   284: aload 8
    //   286: aload 8
    //   288: ldc_w 961
    //   291: invokeinterface 207 2 0
    //   296: invokeinterface 944 2 0
    //   301: astore_1
    //   302: aconst_null
    //   303: astore 6
    //   305: aload_1
    //   306: ifnull +17 -> 323
    //   309: new 963	aykk
    //   312: dup
    //   313: aload_1
    //   314: iconst_3
    //   315: invokespecial 966	aykk:<init>	(Ljava/lang/CharSequence;I)V
    //   318: invokevirtual 967	aykk:a	()Ljava/lang/String;
    //   321: astore 6
    //   323: aload 6
    //   325: astore 7
    //   327: aload 6
    //   329: ifnull +76 -> 405
    //   332: aload 6
    //   334: astore 7
    //   336: aload 6
    //   338: invokevirtual 399	java/lang/String:length	()I
    //   341: ifle +64 -> 405
    //   344: aload 6
    //   346: astore 7
    //   348: aload_0
    //   349: aload 6
    //   351: invokevirtual 969	com/tencent/mobileqq/activity/ChatHistory:b	(Ljava/lang/String;)Z
    //   354: ifeq +51 -> 405
    //   357: aload 6
    //   359: ldc_w 971
    //   362: invokevirtual 974	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   365: iconst_1
    //   366: aaload
    //   367: ldc_w 976
    //   370: invokevirtual 974	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   373: astore 7
    //   375: aload 7
    //   377: arraylength
    //   378: iconst_2
    //   379: if_icmpge +862 -> 1241
    //   382: iconst_1
    //   383: istore_3
    //   384: iload_3
    //   385: iconst_1
    //   386: if_icmpeq +10 -> 396
    //   389: iload_3
    //   390: ldc_w 977
    //   393: if_icmpne +862 -> 1255
    //   396: aload_0
    //   397: ldc_w 978
    //   400: invokevirtual 500	com/tencent/mobileqq/activity/ChatHistory:getString	(I)Ljava/lang/String;
    //   403: astore 7
    //   405: new 146	java/lang/StringBuilder
    //   408: dup
    //   409: invokespecial 299	java/lang/StringBuilder:<init>	()V
    //   412: aload_0
    //   413: iload 4
    //   415: i2l
    //   416: ldc2_w 979
    //   419: lmul
    //   420: invokevirtual 982	com/tencent/mobileqq/activity/ChatHistory:a	(J)Ljava/lang/String;
    //   423: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   426: ldc_w 984
    //   429: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   432: aload 9
    //   434: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   437: ldc_w 986
    //   440: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   443: aload 7
    //   445: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   448: invokevirtual 176	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   451: astore 6
    //   453: aload 10
    //   455: new 146	java/lang/StringBuilder
    //   458: dup
    //   459: invokespecial 299	java/lang/StringBuilder:<init>	()V
    //   462: aload 6
    //   464: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   467: ldc_w 988
    //   470: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   473: invokevirtual 176	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   476: invokevirtual 480	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   479: pop
    //   480: aload_1
    //   481: astore 6
    //   483: aload 8
    //   485: invokeinterface 991 1 0
    //   490: ifne -338 -> 152
    //   493: aload 8
    //   495: ifnull +10 -> 505
    //   498: aload 8
    //   500: invokeinterface 220 1 0
    //   505: aload_0
    //   506: new 993	com/tencent/mobileqq/activity/ChatHistory$21
    //   509: dup
    //   510: aload_0
    //   511: getstatic 998	ajsd:aX	Ljava/lang/String;
    //   514: aload_0
    //   515: getfield 68	com/tencent/mobileqq/activity/ChatHistory:jdField_a_of_type_JavaLangStringBuffer	Ljava/lang/StringBuffer;
    //   518: invokevirtual 489	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   521: aload 10
    //   523: invokevirtual 489	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   526: invokestatic 1003	bbdx:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z
    //   529: invokespecial 1006	com/tencent/mobileqq/activity/ChatHistory$21:<init>	(Lcom/tencent/mobileqq/activity/ChatHistory;Z)V
    //   532: invokevirtual 1010	com/tencent/mobileqq/activity/ChatHistory:runOnUiThread	(Ljava/lang/Runnable;)V
    //   535: return
    //   536: new 146	java/lang/StringBuilder
    //   539: dup
    //   540: invokespecial 299	java/lang/StringBuilder:<init>	()V
    //   543: ldc_w 1012
    //   546: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   549: invokestatic 156	akpx:b	()Ljava/lang/String;
    //   552: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   555: ldc_w 1014
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
    //   577: getfield 281	com/tencent/mobileqq/activity/ChatHistory:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   580: invokevirtual 144	com/tencent/mobileqq/app/QQAppInterface:b	()Lcom/tencent/mobileqq/app/SQLiteDatabase;
    //   583: aload 6
    //   585: aconst_null
    //   586: invokestatic 415	bbfd:a	(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/app/SQLiteDatabase;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   589: astore 6
    //   591: goto -544 -> 47
    //   594: ldc_w 1016
    //   597: iconst_2
    //   598: anewarray 84	java/lang/Object
    //   601: dup
    //   602: iconst_0
    //   603: aload_0
    //   604: getfield 281	com/tencent/mobileqq/activity/ChatHistory:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   607: aload_0
    //   608: getfield 286	com/tencent/mobileqq/activity/ChatHistory:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   611: aload_1
    //   612: invokestatic 953	bbcz:h	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   615: aastore
    //   616: dup
    //   617: iconst_1
    //   618: aload_1
    //   619: aastore
    //   620: invokestatic 1019	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   623: astore_1
    //   624: goto -404 -> 220
    //   627: sipush 3000
    //   630: iload_2
    //   631: if_icmpne +33 -> 664
    //   634: ldc_w 1016
    //   637: iconst_2
    //   638: anewarray 84	java/lang/Object
    //   641: dup
    //   642: iconst_0
    //   643: aload_0
    //   644: getfield 281	com/tencent/mobileqq/activity/ChatHistory:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   647: aload_1
    //   648: iconst_0
    //   649: invokestatic 930	bbcz:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;I)Ljava/lang/String;
    //   652: aastore
    //   653: dup
    //   654: iconst_1
    //   655: aload_1
    //   656: aastore
    //   657: invokestatic 1019	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   660: astore_1
    //   661: goto -441 -> 220
    //   664: aload_0
    //   665: getfield 1021	com/tencent/mobileqq/activity/ChatHistory:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   668: astore_1
    //   669: goto -449 -> 220
    //   672: aload_1
    //   673: astore 9
    //   675: goto -424 -> 251
    //   678: aload 8
    //   680: aload 8
    //   682: ldc_w 1023
    //   685: invokeinterface 207 2 0
    //   690: invokeinterface 941 2 0
    //   695: istore 5
    //   697: iload 5
    //   699: sipush -2007
    //   702: if_icmpne +14 -> 716
    //   705: aload_0
    //   706: ldc_w 1024
    //   709: invokevirtual 500	com/tencent/mobileqq/activity/ChatHistory:getString	(I)Ljava/lang/String;
    //   712: astore_1
    //   713: goto -411 -> 302
    //   716: iload 5
    //   718: sipush -2058
    //   721: if_icmpne +14 -> 735
    //   724: aload_0
    //   725: ldc_w 1025
    //   728: invokevirtual 500	com/tencent/mobileqq/activity/ChatHistory:getString	(I)Ljava/lang/String;
    //   731: astore_1
    //   732: goto -430 -> 302
    //   735: iload 5
    //   737: sipush -2039
    //   740: if_icmpne +50 -> 790
    //   743: aload 8
    //   745: aload 8
    //   747: ldc_w 1027
    //   750: invokeinterface 207 2 0
    //   755: invokeinterface 1031 2 0
    //   760: astore_1
    //   761: new 1033	com/tencent/mobileqq/data/MessageForApollo
    //   764: dup
    //   765: invokespecial 1034	com/tencent/mobileqq/data/MessageForApollo:<init>	()V
    //   768: astore 6
    //   770: aload 6
    //   772: aload_1
    //   773: putfield 1037	com/tencent/mobileqq/data/MessageForApollo:msgData	[B
    //   776: aload 6
    //   778: invokevirtual 1040	com/tencent/mobileqq/data/MessageForApollo:parse	()V
    //   781: aload 6
    //   783: invokestatic 1045	com/tencent/mobileqq/apollo/utils/ApolloUtil:a	(Lcom/tencent/mobileqq/data/MessageForApollo;)Ljava/lang/String;
    //   786: astore_1
    //   787: goto -485 -> 302
    //   790: iload 5
    //   792: sipush -2011
    //   795: if_icmpne +31 -> 826
    //   798: aload_0
    //   799: aload 8
    //   801: aload 8
    //   803: ldc_w 1027
    //   806: invokeinterface 207 2 0
    //   811: invokeinterface 1031 2 0
    //   816: invokestatic 1050	axva:a	([B)Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   819: invokevirtual 1052	com/tencent/mobileqq/activity/ChatHistory:a	(Lcom/tencent/mobileqq/structmsg/AbsStructMsg;)Ljava/lang/String;
    //   822: astore_1
    //   823: goto -521 -> 302
    //   826: iload 5
    //   828: sipush -2020
    //   831: if_icmpne +58 -> 889
    //   834: iload_3
    //   835: invokestatic 956	bbfh:a	(I)Z
    //   838: ifeq +34 -> 872
    //   841: aload_0
    //   842: getfield 281	com/tencent/mobileqq/activity/ChatHistory:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   845: invokevirtual 1056	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   848: ldc_w 1057
    //   851: iconst_1
    //   852: anewarray 84	java/lang/Object
    //   855: dup
    //   856: iconst_0
    //   857: aload_0
    //   858: getfield 853	com/tencent/mobileqq/activity/ChatHistory:jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo	Lcom/tencent/mobileqq/activity/aio/SessionInfo;
    //   861: getfield 1061	com/tencent/mobileqq/activity/aio/SessionInfo:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   864: aastore
    //   865: invokevirtual 1066	com/tencent/qphone/base/util/BaseApplication:getString	(I[Ljava/lang/Object;)Ljava/lang/String;
    //   868: astore_1
    //   869: goto -567 -> 302
    //   872: aload_0
    //   873: getfield 281	com/tencent/mobileqq/activity/ChatHistory:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   876: invokevirtual 1056	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   879: ldc_w 1067
    //   882: invokevirtual 1068	com/tencent/qphone/base/util/BaseApplication:getString	(I)Ljava/lang/String;
    //   885: astore_1
    //   886: goto -584 -> 302
    //   889: aload 6
    //   891: astore_1
    //   892: iload 5
    //   894: sipush -2006
    //   897: if_icmpeq -417 -> 480
    //   900: iload 5
    //   902: sipush -2000
    //   905: if_icmpne +13 -> 918
    //   908: ldc_w 1069
    //   911: invokestatic 1073	ajya:a	(I)Ljava/lang/String;
    //   914: astore_1
    //   915: goto -613 -> 302
    //   918: iload 5
    //   920: sipush -2002
    //   923: if_icmpne +13 -> 936
    //   926: ldc_w 1074
    //   929: invokestatic 1073	ajya:a	(I)Ljava/lang/String;
    //   932: astore_1
    //   933: goto -631 -> 302
    //   936: iload 5
    //   938: sipush -2022
    //   941: if_icmpne +13 -> 954
    //   944: ldc_w 1075
    //   947: invokestatic 1073	ajya:a	(I)Ljava/lang/String;
    //   950: astore_1
    //   951: goto -649 -> 302
    //   954: iload 5
    //   956: sipush -2071
    //   959: if_icmpne +14 -> 973
    //   962: aload_0
    //   963: ldc_w 1076
    //   966: invokevirtual 500	com/tencent/mobileqq/activity/ChatHistory:getString	(I)Ljava/lang/String;
    //   969: astore_1
    //   970: goto -668 -> 302
    //   973: iload 5
    //   975: sipush -7001
    //   978: if_icmpne +14 -> 992
    //   981: aload_0
    //   982: ldc_w 1077
    //   985: invokevirtual 500	com/tencent/mobileqq/activity/ChatHistory:getString	(I)Ljava/lang/String;
    //   988: astore_1
    //   989: goto -687 -> 302
    //   992: iload 5
    //   994: sipush -1035
    //   997: if_icmpne +202 -> 1199
    //   1000: new 146	java/lang/StringBuilder
    //   1003: dup
    //   1004: invokespecial 299	java/lang/StringBuilder:<init>	()V
    //   1007: astore_1
    //   1008: aload 8
    //   1010: aload 8
    //   1012: ldc_w 1027
    //   1015: invokeinterface 207 2 0
    //   1020: invokeinterface 1031 2 0
    //   1025: astore 7
    //   1027: new 1079	localpb/richMsg/MixedMsg$Msg
    //   1030: dup
    //   1031: invokespecial 1080	localpb/richMsg/MixedMsg$Msg:<init>	()V
    //   1034: astore 6
    //   1036: aload 6
    //   1038: aload 7
    //   1040: invokevirtual 1084	localpb/richMsg/MixedMsg$Msg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   1043: pop
    //   1044: aload 6
    //   1046: getfield 1088	localpb/richMsg/MixedMsg$Msg:elems	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   1049: invokevirtual 1094	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   1052: invokeinterface 1099 1 0
    //   1057: ifgt +51 -> 1108
    //   1060: aload 8
    //   1062: ifnull -527 -> 535
    //   1065: aload 8
    //   1067: invokeinterface 220 1 0
    //   1072: return
    //   1073: astore 6
    //   1075: invokestatic 298	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1078: ifeq +12 -> 1090
    //   1081: ldc 61
    //   1083: iconst_2
    //   1084: ldc_w 1101
    //   1087: invokestatic 307	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1090: aload_1
    //   1091: invokevirtual 176	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1094: astore_1
    //   1095: goto -793 -> 302
    //   1098: astore 7
    //   1100: aload 7
    //   1102: invokevirtual 1104	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:printStackTrace	()V
    //   1105: goto -61 -> 1044
    //   1108: aload 6
    //   1110: getfield 1088	localpb/richMsg/MixedMsg$Msg:elems	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   1113: invokevirtual 1094	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   1116: invokeinterface 1099 1 0
    //   1121: istore 5
    //   1123: iconst_0
    //   1124: istore_3
    //   1125: iload_3
    //   1126: iload 5
    //   1128: if_icmpge -38 -> 1090
    //   1131: aload 6
    //   1133: getfield 1088	localpb/richMsg/MixedMsg$Msg:elems	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   1136: invokevirtual 1094	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   1139: iload_3
    //   1140: invokeinterface 1107 2 0
    //   1145: checkcast 1109	localpb/richMsg/MixedMsg$Elem
    //   1148: astore 7
    //   1150: aload 7
    //   1152: getfield 1113	localpb/richMsg/MixedMsg$Elem:textMsg	Lcom/tencent/mobileqq/pb/PBStringField;
    //   1155: invokevirtual 1118	com/tencent/mobileqq/pb/PBStringField:has	()Z
    //   1158: ifeq +19 -> 1177
    //   1161: aload_1
    //   1162: aload 7
    //   1164: getfield 1113	localpb/richMsg/MixedMsg$Elem:textMsg	Lcom/tencent/mobileqq/pb/PBStringField;
    //   1167: invokevirtual 1120	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   1170: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1173: pop
    //   1174: goto +133 -> 1307
    //   1177: aload 7
    //   1179: getfield 1124	localpb/richMsg/MixedMsg$Elem:picMsg	Llocalpb/richMsg/RichMsg$PicRec;
    //   1182: invokevirtual 1127	localpb/richMsg/RichMsg$PicRec:has	()Z
    //   1185: ifeq +122 -> 1307
    //   1188: aload_1
    //   1189: ldc_w 1129
    //   1192: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1195: pop
    //   1196: goto +111 -> 1307
    //   1199: new 213	java/lang/String
    //   1202: dup
    //   1203: aload 8
    //   1205: aload 8
    //   1207: ldc_w 1027
    //   1210: invokeinterface 207 2 0
    //   1215: invokeinterface 1031 2 0
    //   1220: ldc_w 1131
    //   1223: invokespecial 1134	java/lang/String:<init>	([BLjava/lang/String;)V
    //   1226: astore_1
    //   1227: goto -925 -> 302
    //   1230: astore_1
    //   1231: aload_1
    //   1232: invokevirtual 1135	java/lang/Exception:printStackTrace	()V
    //   1235: aload 6
    //   1237: astore_1
    //   1238: goto -936 -> 302
    //   1241: aload 7
    //   1243: iconst_2
    //   1244: aaload
    //   1245: invokestatic 1140	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   1248: invokevirtual 1143	java/lang/Integer:intValue	()I
    //   1251: istore_3
    //   1252: goto -868 -> 384
    //   1255: aload 6
    //   1257: astore 7
    //   1259: iload_3
    //   1260: iconst_2
    //   1261: if_icmpne -856 -> 405
    //   1264: new 146	java/lang/StringBuilder
    //   1267: dup
    //   1268: invokespecial 299	java/lang/StringBuilder:<init>	()V
    //   1271: ldc_w 477
    //   1274: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1277: aload_0
    //   1278: ldc_w 1144
    //   1281: invokevirtual 500	com/tencent/mobileqq/activity/ChatHistory:getString	(I)Ljava/lang/String;
    //   1284: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1287: ldc_w 485
    //   1290: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1293: invokevirtual 176	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1296: astore 7
    //   1298: goto -893 -> 405
    //   1301: aconst_null
    //   1302: astore 8
    //   1304: goto -1234 -> 70
    //   1307: iload_3
    //   1308: iconst_1
    //   1309: iadd
    //   1310: istore_3
    //   1311: goto -186 -> 1125
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1314	0	this	ChatHistory
    //   0	1314	1	paramString	String
    //   0	1314	2	paramInt	int
    //   237	1074	3	n	int
    //   168	246	4	i1	int
    //   695	434	5	i2	int
    //   45	1000	6	localObject1	Object
    //   1073	183	6	localException	Exception
    //   2	1037	7	localObject2	Object
    //   1098	3	7	localInvalidProtocolBufferMicroException	com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException
    //   1148	149	7	localObject3	Object
    //   68	1235	8	localCursor	Cursor
    //   249	425	9	str	String
    //   11	511	10	localStringBuffer	StringBuffer
    // Exception table:
    //   from	to	target	type
    //   1008	1036	1073	java/lang/Exception
    //   1036	1044	1073	java/lang/Exception
    //   1044	1060	1073	java/lang/Exception
    //   1065	1072	1073	java/lang/Exception
    //   1100	1105	1073	java/lang/Exception
    //   1108	1123	1073	java/lang/Exception
    //   1131	1174	1073	java/lang/Exception
    //   1177	1196	1073	java/lang/Exception
    //   1036	1044	1098	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   1199	1227	1230	java/lang/Exception
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
    this.jdField_a_of_type_AndroidViewView = ((RelativeLayout)View.inflate(this, 2131562360, null));
    int n = (int)bbdv.a(this, 6.0F);
    Object localObject = new RelativeLayout(this);
    ((RelativeLayout)localObject).setPadding(0, n, 0, n);
    ((RelativeLayout)localObject).setBackgroundResource(2130849228);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, getResources().getDimensionPixelSize(2131298606));
    ((RelativeLayout)localObject).addView(this.jdField_a_of_type_AndroidViewView, localLayoutParams);
    this.jdField_a_of_type_ComTencentWidgetXListView.addHeaderView((View)localObject);
    this.jdField_a_of_type_AndroidViewView.findViewById(2131363479).setVisibility(8);
    localObject = (EditText)this.jdField_a_of_type_AndroidViewView.findViewById(2131365763);
    ((EditText)localObject).setFocusableInTouchMode(false);
    ((EditText)localObject).setCursorVisible(false);
    ((EditText)localObject).setOnClickListener(new aard(this));
    setLayerType(this.jdField_a_of_type_AndroidViewView);
  }
  
  protected void c(String paramString)
  {
    if (this.jdField_b_of_type_Bcqf == null) {
      this.jdField_b_of_type_Bcqf = new bcqf(this, getTitleBarHeight());
    }
    this.jdField_b_of_type_Bcqf.setCancelable(true);
    this.jdField_b_of_type_Bcqf.a(paramString);
    this.jdField_b_of_type_Bcqf.show();
  }
  
  public boolean c(String paramString)
  {
    o();
    MediaPlayerManager.a(this.app).a(true);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer == null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer = new AudioPlayer(this, this.jdField_a_of_type_Acts);
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
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131367806));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131367807));
    this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(getString(2131690726));
    this.jdField_b_of_type_AndroidWidgetImageView.setContentDescription(getString(2131690725));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new aare(this));
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(new aaqh(this));
    this.jdField_b_of_type_AndroidWidgetImageView.setEnabled(false);
    this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130848549);
    if (this.jdField_c_of_type_Int == 1)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setEnabled(false);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130840184);
    }
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131377054));
    this.jdField_b_of_type_AndroidWidgetTextView.setText(String.valueOf(this.jdField_c_of_type_Int));
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131365466));
    this.jdField_a_of_type_AndroidWidgetEditText.setText(String.valueOf(this.jdField_d_of_type_Int));
    this.jdField_a_of_type_AndroidWidgetEditText.setSelection(this.jdField_a_of_type_AndroidWidgetEditText.getText().toString().length());
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(new aaqi(this));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131363746));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new aaqj(this));
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)findViewById(2131363745));
    this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(new aaqk(this));
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
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(new aaql(this));
      return;
      if ((this.jdField_a_of_type_Int != 1) && (this.jdField_a_of_type_Int != 3000))
      {
        ajxl localajxl = (ajxl)this.app.getManager(51);
        if ((localajxl == null) || (!localajxl.b(String.valueOf(this.jdField_b_of_type_JavaLangString))))
        {
          if (QLog.isColorLevel()) {
            QLog.e("ChatHistory", 2, "--mSyncHistory button: fm is null or the uin is not my friend: fm:" + localajxl);
          }
          this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
        }
      }
    }
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
      this.jdField_a_of_type_Aarf.getCursor().requery();
      return;
    } while (-1 != paramInt2);
    a(paramIntent.getExtras());
  }
  
  @TargetApi(14)
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    addObserver(this.jdField_a_of_type_Akat);
    this.jdField_a_of_type_Float = getResources().getDisplayMetrics().density;
    this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable = ((AnimationDrawable)getResources().getDrawable(2130772320));
    this.jdField_b_of_type_AndroidGraphicsDrawableAnimationDrawable = ((AnimationDrawable)getResources().getDrawable(2130772321));
    this.jdField_c_of_type_AndroidGraphicsDrawableAnimationDrawable = ((AnimationDrawable)getResources().getDrawable(2130772244));
    paramBundle = getIntent().getExtras();
    this.jdField_b_of_type_JavaLangString = paramBundle.getString("uin");
    this.jdField_a_of_type_Int = paramBundle.getInt("uintype");
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = new SessionInfo();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString = paramBundle.getString("troop_uin");
    setContentViewNoTitle(2131558771);
    LinearLayout localLinearLayout = (LinearLayout)findViewById(2131375493);
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
    this.jdField_a_of_type_Aumb = ((aumb)this.app.getManager(201));
    a(9, false);
    m();
    a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Int);
    q();
    if (this.app.a() != null) {
      this.app.a().a(this.jdField_a_of_type_Akte);
    }
    this.app.a().f();
    this.jdField_a_of_type_Bazl = new bazl(this);
    this.jdField_a_of_type_Bazl.a((int)(150.0F * this.jdField_a_of_type_Float), (int)(100.0F * this.jdField_a_of_type_Float));
    s();
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.jdField_a_of_type_Aarf != null) {
      this.jdField_a_of_type_Aarf.a();
    }
    if (this.jdField_a_of_type_AndroidHardwareSensorManager != null) {
      this.jdField_a_of_type_AndroidHardwareSensorManager.unregisterListener(this);
    }
    if ((this.jdField_a_of_type_Aukp != null) && (this.jdField_a_of_type_Aukp.a()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ChatHistory", 2, "ChatHistory : close entityManager.");
      }
      this.jdField_a_of_type_Aukp.a();
      this.jdField_a_of_type_Aukp = null;
    }
    n();
    r();
    if (QLog.isColorLevel()) {
      QLog.i("ChatHistory", 2, "onDestroy() mCurPlayingPttInfo = " + this.jdField_a_of_type_Aarq);
    }
    if ((this.jdField_a_of_type_Aarq != null) && (!this.jdField_a_of_type_Aarq.jdField_a_of_type_Boolean))
    {
      this.jdField_a_of_type_Aarq.d();
      this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable.stop();
      this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable = null;
      this.jdField_b_of_type_AndroidGraphicsDrawableAnimationDrawable.stop();
      this.jdField_b_of_type_AndroidGraphicsDrawableAnimationDrawable = null;
      this.jdField_c_of_type_AndroidGraphicsDrawableAnimationDrawable.stop();
      this.jdField_c_of_type_AndroidGraphicsDrawableAnimationDrawable = null;
    }
    this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
    this.app.removeHandler(getClass());
    removeObserver(this.jdField_a_of_type_Akat);
    if (this.app.a() != null) {
      this.app.a().b(this.jdField_a_of_type_Akte);
    }
    this.app.a().f();
    try
    {
      this.jdField_a_of_type_Bazl.a().a();
      label251:
      findViewById(2131375493).clearAnimation();
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
      QLog.i("ChatHistory", 2, "onPause() mCurPlayingPttInfo = " + this.jdField_a_of_type_Aarq);
    }
    if ((this.jdField_a_of_type_Aarq != null) && (!this.jdField_a_of_type_Aarq.jdField_a_of_type_Boolean)) {
      this.jdField_a_of_type_Aarq.d();
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
    this.jdField_a_of_type_Aarf.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Int, this.jdField_e_of_type_Int);
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
    this.jdField_a_of_type_Aarf.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Int, this.jdField_e_of_type_Int);
  }
  
  public void h()
  {
    this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(4, getResources().getString(2131719807)).sendToTarget();
    this.app.a().a((short)1, (byte)1);
  }
  
  public void i()
  {
    akaw localakaw = (akaw)this.app.getManager(92);
    if (localakaw != null)
    {
      long l1 = NetConnInfoCenter.getServerTime();
      this.app.a().a(this.jdField_b_of_type_JavaLangString, l1 - 604800L, 0L, l1, (short)0, 0L, 1, null, localakaw.b(), false, 0, false);
    }
  }
  
  protected void j()
  {
    if (!bbfj.d(this.app.getApplication().getApplicationContext()))
    {
      bcql.a(getApplicationContext(), 2131691526, 1).a();
      return;
    }
    c(getApplication().getResources().getString(2131691527));
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
      boolean bool = bbdx.a(ajsd.aX, this.jdField_a_of_type_JavaLangStringBuffer, ".txt");
      this.jdField_c_of_type_AndroidAppDialog = bbdj.a(this, 230, getString(2131691045), getString(2131691045) + ajsd.aX + this.jdField_a_of_type_JavaLangStringBuffer.toString(), new aaqo(this), new aaqp(this));
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
    b(getString(2131692217));
  }
  
  public void l()
  {
    this.jdField_c_of_type_AndroidAppDialog = bbdj.a(this, 230, getString(2131719809), getString(2131720283), new aaqq(this), new aaqs(this));
    this.jdField_c_of_type_AndroidAppDialog.show();
  }
  
  protected void m()
  {
    String str = getResources().getString(2131690714);
    if (this.jdField_a_of_type_Int == 0) {
      if (this.jdField_b_of_type_JavaLangString.equals(String.valueOf(ajsd.G)))
      {
        this.jdField_c_of_type_JavaLangString = getResources().getString(2131719985);
        if (!this.jdField_b_of_type_JavaLangString.equals(String.valueOf(ajsd.G))) {
          break label365;
        }
        str = getResources().getString(2131719985);
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
      this.leftView = ((TextView)findViewById(2131368429));
      return;
      this.jdField_c_of_type_JavaLangString = bbcz.a(this.app, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString, bbcz.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int), 3);
      break;
      if (this.jdField_a_of_type_Int == 1)
      {
        this.jdField_c_of_type_JavaLangString = ((TroopManager)this.app.getManager(52)).a(this.jdField_b_of_type_JavaLangString);
      }
      else if ((this.jdField_a_of_type_Int == 1000) || (this.jdField_a_of_type_Int == 1020) || (this.jdField_a_of_type_Int == 1001) || (this.jdField_a_of_type_Int == 10002) || (this.jdField_a_of_type_Int == 10004) || (this.jdField_a_of_type_Int == 1004))
      {
        this.jdField_c_of_type_JavaLangString = bbcz.i(this.app, this.jdField_b_of_type_JavaLangString);
      }
      else if (this.jdField_a_of_type_Int == 3000)
      {
        this.jdField_c_of_type_JavaLangString = bbcz.d(this.app, this.jdField_b_of_type_JavaLangString);
      }
      else if (this.jdField_a_of_type_Int == 1024)
      {
        PublicAccountInfo localPublicAccountInfo = ((akdh)this.app.getManager(56)).b(this.jdField_b_of_type_JavaLangString);
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
        bfni.b(this.jdField_a_of_type_AndroidWidgetEditText);
      }
      setResult(-1);
      if ((this.jdField_a_of_type_Ager != null) && (this.jdField_a_of_type_Ager.a()))
      {
        this.jdField_a_of_type_Ager.show();
        this.jdField_a_of_type_Ager.a(false);
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
  
  public View onCreateRightView()
  {
    super.onCreateRightView();
    TextView localTextView = this.rightViewText;
    if ((3000 == this.jdField_a_of_type_Int) || (1 == this.jdField_a_of_type_Int)) {
      this.rightViewText.setVisibility(8);
    }
    for (;;)
    {
      localTextView.setText(2131718804);
      this.jdField_a_of_type_AndroidWidgetTextView = localTextView;
      return localTextView;
      this.rightViewText.setVisibility(0);
    }
  }
  
  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    boolean bool2 = true;
    if (actj.b()) {}
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
    } while (AppSetting.jdField_d_of_type_Boolean);
    if (this.jdField_e_of_type_Boolean) {}
    for (int n = 2131719795;; n = 2131719798)
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
    bbcf.b(2131230731, false);
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
      if (this.jdField_b_of_type_Bcqf != null)
      {
        this.jdField_b_of_type_Bcqf.dismiss();
        this.jdField_b_of_type_Bcqf.cancel();
        this.jdField_b_of_type_Bcqf = null;
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
      axqy.b(this.app, "CliOper", "", "", "AIO", "AIO_chatlog", this.k, 0, String.valueOf(this.k), "", "", "");
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
    axqy.b(this.app, "CliOper", "", "", "0X8005690", "0X8005690", this.k, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatHistory
 * JD-Core Version:    0.7.0.1
 */