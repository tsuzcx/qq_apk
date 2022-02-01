package com.tencent.av.ui;

import Override;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewStub;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import anzj;
import aquy;
import bdll;
import bhoo;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.gaudio.BaseGaInvite;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import lcb;
import lcv;
import ldf;
import lef;
import leu;
import lff;
import lfg;
import lfh;
import lfl;
import lkg;
import lnv;
import lzq;
import mez;
import mfa;
import mfb;
import mfc;
import mfd;
import mfe;
import mff;
import mfg;
import mfh;
import mfi;
import mqq.os.MqqHandler;
import mrl;
import mro;
import mrs;
import mtn;
import mur;
import mvd;

public class MultiIncomingCallsActivity
  extends BaseGaInvite
{
  public static boolean e;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver;
  Bitmap jdField_a_of_type_AndroidGraphicsBitmap = null;
  MutiMemberThumbList jdField_a_of_type_ComTencentAvUiMutiMemberThumbList;
  private Runnable jdField_a_of_type_JavaLangRunnable;
  private ArrayList<lnv> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  lef jdField_a_of_type_Lef = new mfa(this);
  private leu jdField_a_of_type_Leu = new mez(this);
  lff jdField_a_of_type_Lff = null;
  lfl jdField_a_of_type_Lfl = new mfb(this);
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  mro jdField_a_of_type_Mro = null;
  mtn jdField_a_of_type_Mtn;
  public boolean a;
  private BroadcastReceiver jdField_b_of_type_AndroidContentBroadcastReceiver = new mfd(this);
  private Runnable jdField_b_of_type_JavaLangRunnable = new MultiIncomingCallsActivity.2(this);
  private lef jdField_b_of_type_Lef = new mfc(this);
  boolean jdField_b_of_type_Boolean = false;
  long[] jdField_b_of_type_ArrayOfLong = null;
  int jdField_c_of_type_Int = 0;
  private long jdField_c_of_type_Long;
  TextView jdField_c_of_type_AndroidWidgetTextView = null;
  private Runnable jdField_c_of_type_JavaLangRunnable;
  public String c;
  boolean jdField_c_of_type_Boolean;
  int jdField_d_of_type_Int = -1;
  private Runnable jdField_d_of_type_JavaLangRunnable;
  String jdField_d_of_type_JavaLangString = null;
  boolean jdField_d_of_type_Boolean = false;
  int e;
  public String e;
  String jdField_f_of_type_JavaLangString;
  private boolean jdField_f_of_type_Boolean;
  private boolean g;
  private boolean h;
  
  public MultiIncomingCallsActivity()
  {
    this.jdField_c_of_type_JavaLangString = null;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_e_of_type_JavaLangString = "";
    this.jdField_e_of_type_Int = 0;
  }
  
  private void a(long paramLong, ArrayList<lcv> paramArrayList, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "handleMemberListUpdate");
    }
    if ((paramLong == this.jdField_a_of_type_Long) && ((paramInt == 10) || (paramInt == 1)))
    {
      this.h = true;
      h();
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "sendIsResumeBroadcast isResume = " + paramBoolean);
    }
    lzq.a(BaseApplicationImpl.getContext(), paramBoolean);
  }
  
  private void c(int paramInt)
  {
    boolean bool = this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_b_of_type_Int, this.jdField_a_of_type_Long, paramInt);
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "getGAudioRoomMemList " + bool);
    }
    if (!bool)
    {
      QQToast.a(this, anzj.a(2131705898), 1).b(getResources().getDimensionPixelSize(2131299011));
      finish();
    }
  }
  
  private void g()
  {
    if (this.jdField_a_of_type_MqqOsMqqHandler != null)
    {
      this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
      this.jdField_a_of_type_MqqOsMqqHandler.postDelayed(this.jdField_b_of_type_JavaLangRunnable, 10000L);
    }
  }
  
  private void h()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "notifyDataChange mHasCallFromMemberList:=" + this.h);
    }
    g();
    Object localObject1 = this.jdField_a_of_type_ComTencentAvVideoController.e();
    ArrayList localArrayList = new ArrayList();
    HashSet localHashSet = new HashSet();
    localObject1 = ((ArrayList)localObject1).iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (lcv)((Iterator)localObject1).next();
      if (((lcv)localObject2).jdField_a_of_type_Long != this.jdField_b_of_type_Long) {
        localArrayList.add(localObject2);
      }
      localHashSet.add(Long.valueOf(((lcv)localObject2).jdField_a_of_type_Long));
    }
    int i = localArrayList.size();
    localObject1 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    if (((Iterator)localObject1).hasNext())
    {
      localObject2 = (lnv)((Iterator)localObject1).next();
      lcv locallcv;
      if (!localHashSet.contains(Long.valueOf(((lnv)localObject2).jdField_a_of_type_Long)))
      {
        locallcv = new lcv();
        locallcv.jdField_a_of_type_Long = ((lnv)localObject2).jdField_a_of_type_Long;
        locallcv.d = ((lnv)localObject2).jdField_b_of_type_Long;
        if (((lnv)localObject2).jdField_a_of_type_Long == this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getLongAccountUin())
        {
          localArrayList.add(0, locallcv);
          i += 1;
        }
      }
      for (;;)
      {
        break;
        localArrayList.add(locallcv);
      }
    }
    if (this.jdField_c_of_type_JavaLangRunnable != null)
    {
      ThreadManager.getSubThreadHandler().removeCallbacks(this.jdField_c_of_type_JavaLangRunnable);
      this.jdField_c_of_type_JavaLangRunnable = null;
    }
    this.jdField_c_of_type_JavaLangRunnable = new MultiIncomingCallsActivity.10(this, i, localArrayList);
    ThreadManager.getSubThreadHandler().post(this.jdField_c_of_type_JavaLangRunnable);
  }
  
  public void a(long paramLong, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController == null) {}
    do
    {
      return;
      QLog.w(this.jdField_b_of_type_JavaLangString, 1, "closeSession, reason[" + paramInt + "], seq[" + paramLong + "]");
      localObject = Long.valueOf(mrs.a(this.jdField_c_of_type_JavaLangString));
      if (!this.jdField_a_of_type_Boolean) {
        break;
      }
      if (paramInt == 1)
      {
        this.jdField_a_of_type_ComTencentAvVideoController.a(paramLong, ((Long)localObject).longValue(), 7);
        return;
      }
    } while (paramInt != 2);
    this.jdField_a_of_type_ComTencentAvVideoController.a(paramLong, ((Long)localObject).longValue(), 2);
    return;
    if (this.jdField_a_of_type_Lff == null) {}
    for (Object localObject = this.jdField_c_of_type_JavaLangString;; localObject = this.jdField_a_of_type_Lff.jdField_d_of_type_JavaLangString)
    {
      this.jdField_a_of_type_ComTencentAvVideoController.a((String)localObject, 241);
      this.jdField_a_of_type_ComTencentAvVideoController.b(241);
      return;
    }
  }
  
  void a(long paramLong1, int paramInt1, long paramLong2, boolean paramBoolean1, int paramInt2, boolean paramBoolean2)
  {
    String str = this.jdField_b_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder().append("ignoreMultiCall, refuse3rd[").append(paramBoolean2).append("], mVideoController[");
    boolean bool;
    if (this.jdField_a_of_type_ComTencentAvVideoController != null)
    {
      bool = true;
      QLog.w(str, 1, bool + "], seq[" + paramLong1 + "]");
      if (this.jdField_a_of_type_ComTencentAvVideoController != null) {
        break label88;
      }
    }
    for (;;)
    {
      return;
      bool = false;
      break;
      label88:
      if (!paramBoolean2) {
        this.jdField_a_of_type_ComTencentAvVideoController.a(paramLong1, paramInt1, paramLong2, 10, false);
      }
      while ((paramBoolean1) && (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null))
      {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(67), Long.valueOf(paramLong2), Integer.valueOf(3) });
        return;
        this.jdField_a_of_type_ComTencentAvVideoController.a(paramLong1, paramInt1, paramLong2, paramInt2, false);
      }
    }
  }
  
  void a(long paramLong, Intent paramIntent)
  {
    e();
    boolean bool1 = ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    this.jdField_a_of_type_Mro = new mro(this, bool1);
    View localView = LayoutInflater.from(this).inflate(2131559696, null);
    Object localObject1;
    label171:
    label211:
    Object localObject2;
    label285:
    label485:
    int j;
    if (b())
    {
      localObject1 = (ViewStub)localView.findViewById(2131373513);
      if (localObject1 != null) {
        ((ViewStub)localObject1).inflate();
      }
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131373519));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131373518));
      this.jdField_b_of_type_AndroidWidgetTextView.setSingleLine();
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131373523));
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131373517));
      if (!ldf.a()) {
        break label900;
      }
      this.jdField_c_of_type_AndroidWidgetTextView.setText(2131695014);
      this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131166006));
      c();
      if (!b()) {
        break label940;
      }
      if (this.jdField_a_of_type_AndroidGraphicsBitmap != null) {
        this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap);
      }
      this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_Mro.a(localView, false);
      if (b())
      {
        this.jdField_a_of_type_ComTencentAvUiMutiMemberThumbList = ((MutiMemberThumbList)localView.findViewById(2131373524));
        this.jdField_a_of_type_ComTencentAvUiMutiMemberThumbList.setBitMapFetcher(this.jdField_a_of_type_ComTencentAvVideoController);
        this.jdField_a_of_type_ComTencentAvUiMutiMemberThumbList.setRelationShipInfo(this.jdField_a_of_type_Long, this.jdField_b_of_type_Int);
        localObject2 = this.jdField_a_of_type_ComTencentAvUiMutiMemberThumbList;
        if (!bool1) {
          break label969;
        }
        localObject1 = "#757575";
        ((MutiMemberThumbList)localObject2).setTextColor((String)localObject1);
        this.jdField_a_of_type_ComTencentAvUiMutiMemberThumbList.setHeadImgMask(bool1);
        this.jdField_a_of_type_ComTencentAvUiMutiMemberThumbList.setMoreInfoDrawableColor("#F246505F");
        this.jdField_a_of_type_ComTencentAvUiMutiMemberThumbList.setDisPlayList(null);
        this.jdField_c_of_type_Long = this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_b_of_type_Int, this.jdField_e_of_type_Int, this.jdField_a_of_type_Long);
        this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_a_of_type_Long, this.jdField_c_of_type_Long, true);
        c(this.jdField_e_of_type_Int);
      }
      localObject2 = (Button)localView.findViewById(2131373522);
      ((Button)localObject2).setOnClickListener(new mff(this, paramLong));
      this.jdField_a_of_type_Mro.setOnCancelListener(new mfg(this, paramLong));
      this.jdField_a_of_type_Mro.setOnDismissListener(new mfh(this));
      lff locallff = lcb.a().a();
      localObject1 = (Button)localView.findViewById(2131373516);
      ((Button)localObject1).setOnClickListener(new mfi(this, paramLong, paramIntent, locallff));
      if (!b()) {
        break label977;
      }
      ((Button)localObject1).setText(2131695057);
      ((Button)localObject2).setText(2131695063);
      if ((!this.jdField_b_of_type_Boolean) && (!this.jdField_a_of_type_Boolean)) {
        ((Button)localObject1).setCompoundDrawablesWithIntrinsicBounds(super.getResources().getDrawable(2130842164), null, null, null);
      }
      boolean bool2 = b();
      if (bool1)
      {
        j = Color.parseColor("#A8A8A8");
        if (!bool2) {
          break label996;
        }
      }
    }
    label900:
    label940:
    label969:
    label977:
    label996:
    for (int i = 2131373515;; i = 2131373364)
    {
      localView.findViewById(i).setBackgroundDrawable(getResources().getDrawable(2130850664));
      paramIntent = localView.findViewById(2131373520);
      paramIntent.setBackgroundDrawable(mvd.a(67.199997F, this));
      paramIntent.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(j);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(j);
      this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(j);
      localView.findViewById(2131365500).setBackgroundColor(Color.parseColor("#262626"));
      paramIntent = getResources().getDrawable(2130842091);
      paramIntent.setBounds(0, 0, paramIntent.getIntrinsicWidth(), paramIntent.getIntrinsicHeight());
      ((Button)localObject2).setCompoundDrawables(paramIntent, null, null, null);
      ((Button)localObject2).setCompoundDrawablePadding(0);
      ((Button)localObject2).setTextColor(j);
      localView.findViewById(2131373526).setBackgroundColor(Color.parseColor("#262626"));
      paramIntent = getResources().getDrawable(2130842089);
      paramIntent.setBounds(0, 0, paramIntent.getIntrinsicWidth(), paramIntent.getIntrinsicHeight());
      ((Button)localObject1).setCompoundDrawables(paramIntent, null, null, null);
      ((Button)localObject1).setCompoundDrawablePadding(0);
      ((Button)localObject1).setTextColor(j);
      this.jdField_a_of_type_Mro.show();
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_b_of_type_JavaLangString, 2, String.format("begin show dialog, mPeerUin[%s], mExtraUin[%s], mIsDoubleVideoMeeting[%s], mUinType[%s], mRelationType[%s], mMemberType[%s], mHasGVideoJoined[%s], mIsAudioMode[%s], mBindType[%s]", new Object[] { this.jdField_c_of_type_JavaLangString, this.jdField_d_of_type_JavaLangString, Boolean.valueOf(this.jdField_a_of_type_Boolean), Integer.valueOf(this.jdField_a_of_type_Int), Integer.valueOf(this.jdField_b_of_type_Int), Integer.valueOf(this.jdField_d_of_type_Int), Boolean.valueOf(this.jdField_c_of_type_Boolean), Boolean.valueOf(this.jdField_b_of_type_Boolean), Integer.valueOf(this.jdField_c_of_type_Int) }));
      }
      mur.a().a(paramLong, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 2131230736, null, 0, null);
      return;
      localObject1 = (ViewStub)localView.findViewById(2131373363);
      break;
      if (!this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.i()) {
        break label171;
      }
      this.jdField_c_of_type_AndroidWidgetTextView.setText(2131690351);
      this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131166006));
      break label171;
      if (this.jdField_a_of_type_AndroidGraphicsBitmap != null) {
        this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap);
      }
      a(this.jdField_b_of_type_AndroidWidgetTextView);
      break label211;
      localObject1 = "#878B99";
      break label285;
      ((Button)localObject1).setText(2131695057);
      ((Button)localObject2).setText(2131695064);
      break label485;
    }
  }
  
  public void a(long paramLong, Intent paramIntent, lff paramlff)
  {
    bhoo.a(true);
    sendBroadcast(new Intent("com.tencent.werewoves.plugin"));
    sendBroadcast(new Intent("com.gvideo.com.tencent.av.EXIT_GROUP_VIDEO"));
    sendBroadcast(new Intent("tencent.video.v2g.exitAVGame"));
    b(1);
    if (ldf.a())
    {
      sendBroadcast(new Intent("tencent.av.EXIT_QZONE_LIVE_REQ_ACTION"));
      return;
    }
    a(paramLong, "onClickAccept", paramIntent, paramlff);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(67), Long.valueOf(this.jdField_a_of_type_Long), Integer.valueOf(3) });
    b("onClickAccept");
  }
  
  public void a(long paramLong, String paramString, Intent paramIntent, lff paramlff)
  {
    lff locallff = lcb.a().a();
    String str = this.jdField_b_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder().append("acceptRequest, from[").append(paramString).append("], HandleSessionInfo[").append(paramlff).append("], CurMainSession[").append(locallff).append("], mSessionInfo[").append(this.jdField_a_of_type_Lff).append("], SameSession[");
    boolean bool;
    if (paramlff == locallff)
    {
      bool = true;
      QLog.w(str, 1, bool + "], mAnyChatCloseByFriend[" + this.jdField_a_of_type_ComTencentAvVideoController.jdField_f_of_type_Boolean + "], getAliveSessionCount[" + lcb.a().a() + "], seq[" + paramLong + "]");
      this.jdField_d_of_type_Boolean = true;
      if (!this.jdField_a_of_type_ComTencentAvVideoController.jdField_f_of_type_Boolean) {
        break label250;
      }
      this.jdField_a_of_type_ComTencentAvVideoController.g(true);
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_Lff != null) && (!this.jdField_a_of_type_Lff.j()))
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_b_of_type_JavaLangString, 2, "Session already destroyed, id:" + this.jdField_a_of_type_Lff.jdField_c_of_type_JavaLangString + ", status = " + this.jdField_a_of_type_Lff.jdField_g_of_type_Int);
        }
        return;
        bool = false;
        break;
        label250:
        if ((paramlff != null) && (locallff == paramlff) && (lcb.a().a() >= 2))
        {
          this.jdField_a_of_type_ComTencentAvVideoController.k(true);
          if (paramlff.j()) {
            a(paramLong, paramString, false, paramlff, -1);
          }
          for (;;)
          {
            a(paramlff);
            break;
            this.jdField_a_of_type_ComTencentAvVideoController.a(true, 205, new int[] { locallff.D });
            this.jdField_a_of_type_ComTencentAvVideoController.b(205);
          }
        }
      }
    }
    if (b())
    {
      d();
      return;
    }
    b(paramIntent);
  }
  
  public void a(long paramLong, String paramString, boolean paramBoolean, lff paramlff, int paramInt)
  {
    boolean bool3 = true;
    QLog.w(this.jdField_b_of_type_JavaLangString, 1, "ignoreRequest[" + paramString + "], refuse3rd[" + paramBoolean + "], mainSessionInfo[" + paramlff + "], iFlag[" + paramInt + "], seq[" + paramLong + "]");
    if (paramBoolean) {
      this.jdField_d_of_type_Boolean = false;
    }
    mur.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    paramString = this.jdField_c_of_type_JavaLangString;
    boolean bool1 = this.jdField_a_of_type_Boolean;
    int i = this.jdField_b_of_type_Int;
    long l = this.jdField_a_of_type_Long;
    if (!paramBoolean) {
      if (paramlff != null)
      {
        String str = paramlff.jdField_d_of_type_JavaLangString;
        paramString = str;
        if (TextUtils.isEmpty(str)) {
          paramString = paramlff.s;
        }
        bool1 = paramlff.J;
        i = paramlff.F;
        l = paramlff.jdField_g_of_type_Long;
      }
    }
    for (;;)
    {
      int j = mvd.c(i);
      if (!paramBoolean)
      {
        bool2 = bool3;
        if (!bool1) {
          if (!a(j)) {
            break label234;
          }
        }
      }
      label234:
      for (boolean bool2 = bool3; a(j); bool2 = false)
      {
        a(paramLong, i, l, bool2, paramInt, paramBoolean);
        return;
      }
      a(paramLong, bool1, paramString, bool2, paramBoolean);
      return;
    }
  }
  
  void a(long paramLong, boolean paramBoolean1, String paramString, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController == null)
    {
      QLog.d(this.jdField_b_of_type_JavaLangString, 1, "refuseDoubleCall mVideoController is null");
      return;
    }
    QLog.w(this.jdField_b_of_type_JavaLangString, 1, "refuseDoubleCall, isDoubleVideoMeeting[" + paramBoolean1 + "], peerUin[" + paramString + "], notifyDestroyUI[" + paramBoolean2 + "], refuse3rd[" + paramBoolean3 + "], seq[" + paramLong + "]");
    long l2;
    if (paramBoolean1)
    {
      this.jdField_a_of_type_ComTencentAvVideoController.a(paramLong, paramString, 1, true);
      l2 = -1L;
    }
    for (;;)
    {
      try
      {
        l1 = mrs.a(paramString);
        if (!paramBoolean3)
        {
          this.jdField_a_of_type_ComTencentAvVideoController.a(paramLong, 3, l1, 10, false);
          this.jdField_a_of_type_ComTencentAvVideoController.a(paramLong, l1, 23);
          if ((!paramBoolean2) || (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null)) {
            break;
          }
          this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(28), paramString, Boolean.valueOf(true) });
          return;
        }
      }
      catch (NumberFormatException localNumberFormatException)
      {
        long l1 = l2;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d(this.jdField_b_of_type_JavaLangString, 2, "", localNumberFormatException);
        l1 = l2;
        continue;
        this.jdField_a_of_type_ComTencentAvVideoController.a(paramLong, 3, l1);
        this.jdField_a_of_type_ComTencentAvVideoController.a(paramLong, l1, 1);
        continue;
      }
      VideoController localVideoController = this.jdField_a_of_type_ComTencentAvVideoController;
      localVideoController.a(paramLong, paramString, 1, false, new MultiIncomingCallsActivity.11(this, localVideoController, paramString, paramBoolean3));
    }
  }
  
  public void a(Intent paramIntent)
  {
    long l = AudioHelper.b();
    this.jdField_b_of_type_Int = 3;
    super.a(paramIntent);
    if (paramIntent == null) {}
    label358:
    do
    {
      return;
      this.jdField_c_of_type_JavaLangString = paramIntent.getStringExtra("peerUin");
      this.jdField_d_of_type_JavaLangString = paramIntent.getStringExtra("extraUin");
      this.jdField_a_of_type_Boolean = paramIntent.getBooleanExtra("isDoubleVideoMeeting", false);
      this.jdField_d_of_type_Int = paramIntent.getIntExtra("memberType", -1);
      this.jdField_c_of_type_Boolean = paramIntent.getBooleanExtra("hasGVideoJoined", false);
      this.jdField_b_of_type_Boolean = paramIntent.getBooleanExtra("isAudioMode", false);
      this.jdField_c_of_type_Int = paramIntent.getIntExtra("bindType", 0);
      String str = lcb.a(3, this.jdField_c_of_type_JavaLangString, new int[0]);
      if (this.jdField_a_of_type_Boolean)
      {
        str = lcb.a(100, this.jdField_c_of_type_JavaLangString, new int[0]);
        this.jdField_b_of_type_Boolean = false;
      }
      int i;
      if (b())
      {
        this.jdField_e_of_type_Int = paramIntent.getIntExtra("MultiAVType", -1);
        if (this.jdField_e_of_type_Int == 2)
        {
          this.jdField_b_of_type_Boolean = false;
          this.jdField_e_of_type_JavaLangString = paramIntent.getStringExtra("inviteId");
          str = lcb.a(this.jdField_b_of_type_Int, String.valueOf(this.jdField_a_of_type_Long), new int[0]);
          this.jdField_b_of_type_ArrayOfLong = paramIntent.getLongArrayExtra("memberList");
          i = mrl.c(this.jdField_b_of_type_Int);
          this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getDisplayName(i, String.valueOf(this.jdField_b_of_type_Long), String.valueOf(this.jdField_a_of_type_Long));
        }
      }
      for (this.jdField_a_of_type_AndroidGraphicsBitmap = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(i, String.valueOf(this.jdField_b_of_type_Long), this.jdField_d_of_type_JavaLangString, true, true);; this.jdField_a_of_type_AndroidGraphicsBitmap = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_a_of_type_Int, this.jdField_c_of_type_JavaLangString, this.jdField_d_of_type_JavaLangString, true, true))
      {
        this.jdField_a_of_type_Lff = lcb.a().c(str);
        if (this.jdField_a_of_type_Lff != null) {
          break label358;
        }
        b("processIntent_fail");
        return;
        this.jdField_b_of_type_Boolean = true;
        break;
        this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getDisplayName(this.jdField_a_of_type_Int, this.jdField_c_of_type_JavaLangString, this.jdField_d_of_type_JavaLangString);
      }
    } while (a(paramIntent));
    a(l, paramIntent);
  }
  
  void a(TextView paramTextView)
  {
    if (paramTextView == null) {
      return;
    }
    float f1 = super.getResources().getDimensionPixelSize(2131297759);
    String str2;
    int i;
    if (b())
    {
      str2 = String.valueOf(this.jdField_a_of_type_Long);
      str1 = super.getApplicationContext().getString(2131694905);
      int j = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_b_of_type_Int, str2);
      i = j;
      if (j == 0)
      {
        if (this.jdField_b_of_type_ArrayOfLong != null) {
          i = this.jdField_b_of_type_ArrayOfLong.length + 1;
        }
      }
      else
      {
        if (i <= 999) {
          break label183;
        }
        f1 = super.getResources().getDimensionPixelSize(2131297761);
        label102:
        str2 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getDisplayName(this.jdField_a_of_type_Int, str2, null);
        str2 = mvd.a(super.getApplicationContext(), str2, paramTextView, f1);
        str1 = String.format(str1, new Object[] { Integer.valueOf(i) });
      }
    }
    for (String str1 = str2 + str1;; str1 = this.jdField_a_of_type_JavaLangString)
    {
      paramTextView.setText(str1);
      return;
      i = 1;
      break;
      label183:
      if (i <= 99) {
        break label102;
      }
      f1 = super.getResources().getDimensionPixelSize(2131297760);
      break label102;
    }
  }
  
  void a(lff paramlff)
  {
    if ((this.jdField_a_of_type_ComTencentAvVideoController != null) && (paramlff != null))
    {
      Intent localIntent = new Intent();
      localIntent.setPackage(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getPackageName());
      localIntent.setAction("tencent.av.v2q.StopVideoChat");
      localIntent.putExtra("stopReason3rd", 1);
      localIntent.putExtra("groupId", paramlff.jdField_g_of_type_Long);
      localIntent.putExtra("peerUin", paramlff.jdField_d_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().sendBroadcast(localIntent);
    }
  }
  
  public boolean a(Intent paramIntent)
  {
    if (paramIntent == null) {
      return false;
    }
    long l = AudioHelper.b();
    String str1 = paramIntent.getAction();
    String str2;
    Object localObject;
    if ("com.tencent.qav.notify.accept".equals(str1))
    {
      str2 = paramIntent.getStringExtra("session_id");
      if (this.jdField_a_of_type_Lff == null)
      {
        localObject = null;
        if (!TextUtils.equals(str2, (CharSequence)localObject)) {
          break label137;
        }
        a(l, paramIntent, lcb.a().a());
      }
    }
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.i(this.jdField_b_of_type_JavaLangString, 2, "checkParamAndDoAction action[" + str1 + "], seq[" + l + "]");
      }
      return bool;
      localObject = this.jdField_a_of_type_Lff.jdField_c_of_type_JavaLangString;
      break;
      label137:
      if (QLog.isColorLevel()) {
        QLog.i(this.jdField_b_of_type_JavaLangString, 2, "checkParamAndDoAction coming[" + str2 + "], cur[" + (String)localObject + "]");
      }
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Mtn != null) {
      this.jdField_a_of_type_Mtn.a(this.jdField_a_of_type_Lff.jdField_c_of_type_JavaLangString);
    }
    b(2);
    a(AudioHelper.b(), "onInviteTimeOut", true, lcb.a().a(), 8);
    b("onInviteTimeOut");
  }
  
  public void b(int paramInt)
  {
    label258:
    label1410:
    for (;;)
    {
      lff locallff;
      int i;
      int j;
      Object localObject5;
      Object localObject6;
      Object localObject7;
      Object localObject8;
      Object localObject9;
      Object localObject10;
      Object localObject11;
      Object localObject12;
      Object localObject4;
      try
      {
        locallff = lcb.a().a();
        if ((locallff == null) || (lcb.a().a() < 2)) {
          return;
        }
        i = locallff.jdField_g_of_type_Int;
        j = locallff.jdField_c_of_type_Int;
        Object localObject1 = null;
        localObject5 = null;
        localObject6 = null;
        localObject7 = null;
        localObject8 = null;
        localObject9 = null;
        localObject10 = null;
        localObject11 = null;
        localObject12 = null;
        localObject4 = null;
        if ((locallff.j != 21) && ((locallff.j != 1011) || (locallff.jdField_a_of_type_Lfg == null) || (locallff.jdField_a_of_type_Lfg.jdField_b_of_type_Int <= 0) || (locallff.jdField_a_of_type_Lfg.jdField_a_of_type_Int != 1))) {
          break label258;
        }
        if (paramInt == 0)
        {
          localObject4 = "0X8005BB9";
          localObject1 = localObject4;
          if (!QLog.isColorLevel()) {
            break label1410;
          }
          QLog.d(this.jdField_b_of_type_JavaLangString, 2, "double random chat, action:" + paramInt + ", reportType:" + (String)localObject4);
          localObject1 = localObject4;
          if (localObject1 == null) {
            break;
          }
          bdll.b(null, "CliOper", "", "", localObject1, localObject1, 0, 0, "", "", "", "");
          return;
        }
      }
      finally {}
      if (paramInt == 1)
      {
        localObject4 = "0X8005BBA";
      }
      else if (paramInt == 2)
      {
        localObject4 = "0X8005BBB";
        continue;
        if ((locallff.jdField_a_of_type_Lfh != null) && (locallff.jdField_a_of_type_Lfh.jdField_a_of_type_Int != 0) && (locallff.jdField_a_of_type_Lfh.jdField_a_of_type_Long > 0L))
        {
          if (paramInt == 0) {
            localObject4 = "0X8005BBF";
          }
          for (;;)
          {
            localObject3 = localObject4;
            if (!QLog.isColorLevel()) {
              break label1410;
            }
            QLog.d(this.jdField_b_of_type_JavaLangString, 2, "multi gonghui, action:" + paramInt + ", reportType:" + (String)localObject4);
            localObject3 = localObject4;
            break;
            if (paramInt == 1)
            {
              localObject4 = "0X8005BC0";
            }
            else
            {
              localObject4 = localObject3;
              if (paramInt == 2) {
                localObject4 = "0X8005BC1";
              }
            }
          }
        }
        if ((locallff.jdField_a_of_type_Lfg != null) && (locallff.jdField_a_of_type_Lfg.jdField_b_of_type_Int > 0) && (locallff.jdField_a_of_type_Lfg.jdField_a_of_type_Int == 3))
        {
          if (paramInt == 0) {
            localObject4 = "0X8005BBC";
          }
          for (;;)
          {
            localObject3 = localObject4;
            if (!QLog.isColorLevel()) {
              break label1410;
            }
            QLog.d(this.jdField_b_of_type_JavaLangString, 2, "multi random chat, action:" + paramInt + ", reportType:" + (String)localObject4);
            localObject3 = localObject4;
            break;
            if (paramInt == 1)
            {
              localObject4 = "0X8005BBD";
            }
            else
            {
              localObject4 = localObject5;
              if (paramInt == 2) {
                localObject4 = "0X8005BBE";
              }
            }
          }
        }
        if (locallff.J)
        {
          if (paramInt == 0) {
            localObject4 = "0X8005BAA";
          }
          for (;;)
          {
            localObject3 = localObject4;
            if (!QLog.isColorLevel()) {
              break label1410;
            }
            QLog.d(this.jdField_b_of_type_JavaLangString, 2, "double share, action:" + paramInt + ", reportType:" + (String)localObject4);
            localObject3 = localObject4;
            break;
            if (paramInt == 1)
            {
              localObject4 = "0X8005BAB";
            }
            else
            {
              localObject4 = localObject6;
              if (paramInt == 2) {
                localObject4 = "0X8005BAC";
              }
            }
          }
        }
        if ((locallff.F == 1) && (locallff.jdField_d_of_type_Int == 3))
        {
          if (paramInt == 0) {
            localObject4 = "0X8005BB3";
          }
          for (;;)
          {
            localObject3 = localObject4;
            if (!QLog.isColorLevel()) {
              break label1410;
            }
            QLog.d(this.jdField_b_of_type_JavaLangString, 2, "group audio, action:" + paramInt + ", reportType:" + (String)localObject4);
            localObject3 = localObject4;
            break;
            if (paramInt == 1)
            {
              localObject4 = "0X8005BB4";
            }
            else
            {
              localObject4 = localObject7;
              if (paramInt == 2) {
                localObject4 = "0X8005BB5";
              }
            }
          }
        }
        if ((locallff.F == 1) && (locallff.jdField_d_of_type_Int == 4))
        {
          if (paramInt == 0) {
            localObject4 = "0X8005BB6";
          }
          for (;;)
          {
            localObject3 = localObject4;
            if (!QLog.isColorLevel()) {
              break label1410;
            }
            QLog.d(this.jdField_b_of_type_JavaLangString, 2, "group video, action:" + paramInt + ", reportType:" + (String)localObject4);
            localObject3 = localObject4;
            break;
            if (paramInt == 1)
            {
              localObject4 = "0X8005BB7";
            }
            else
            {
              localObject4 = localObject8;
              if (paramInt == 2) {
                localObject4 = "0X8005BB8";
              }
            }
          }
        }
        if ((locallff.F == 2) && (locallff.jdField_d_of_type_Int == 3))
        {
          if (paramInt == 0) {
            localObject4 = "0X8005BAD";
          }
          for (;;)
          {
            localObject3 = localObject4;
            if (!QLog.isColorLevel()) {
              break label1410;
            }
            QLog.d(this.jdField_b_of_type_JavaLangString, 2, "discuss audio, action:" + paramInt + ", reportType:" + (String)localObject4);
            localObject3 = localObject4;
            break;
            if (paramInt == 1)
            {
              localObject4 = "0X8005BAE";
            }
            else
            {
              localObject4 = localObject9;
              if (paramInt == 2) {
                localObject4 = "0X8005BAF";
              }
            }
          }
        }
        if ((locallff.F == 2) && (locallff.jdField_d_of_type_Int == 4))
        {
          if (paramInt == 0) {
            localObject4 = "0X8005BB0";
          }
          for (;;)
          {
            localObject3 = localObject4;
            if (!QLog.isColorLevel()) {
              break label1410;
            }
            QLog.d(this.jdField_b_of_type_JavaLangString, 2, "discuss video, action:" + paramInt + ", reportType:" + (String)localObject4);
            localObject3 = localObject4;
            break;
            if (paramInt == 1)
            {
              localObject4 = "0X8005BB1";
            }
            else
            {
              localObject4 = localObject10;
              if (paramInt == 2) {
                localObject4 = "0X8005BB2";
              }
            }
          }
        }
        if ((locallff.jdField_d_of_type_Int == 2) || ((locallff.f == 2) && ((i == 1) || (i == 2))))
        {
          if (paramInt == 0) {
            localObject4 = "0X8005BA7";
          }
          for (;;)
          {
            localObject3 = localObject4;
            if (!QLog.isColorLevel()) {
              break label1410;
            }
            QLog.d(this.jdField_b_of_type_JavaLangString, 2, "double video, action:" + paramInt + ", reportType:" + (String)localObject4);
            localObject3 = localObject4;
            break;
            if (paramInt == 1)
            {
              localObject4 = "0X8005BA8";
            }
            else
            {
              localObject4 = localObject11;
              if (paramInt == 2) {
                localObject4 = "0X8005BA9";
              }
            }
          }
        }
        if ((locallff.jdField_d_of_type_Int == 1) || ((locallff.f == 1) && ((i == 1) || (i == 2))))
        {
          if (paramInt == 0) {
            localObject4 = "0X8005BA4";
          }
          for (;;)
          {
            localObject3 = localObject4;
            if (!QLog.isColorLevel()) {
              break label1410;
            }
            QLog.d(this.jdField_b_of_type_JavaLangString, 2, "double audio, action:" + paramInt + ", reportType:" + (String)localObject4);
            localObject3 = localObject4;
            break;
            if (paramInt == 1)
            {
              localObject4 = "0X8005BA5";
            }
            else
            {
              localObject4 = localObject12;
              if (paramInt == 2) {
                localObject4 = "0X8005BA6";
              }
            }
          }
        }
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_b_of_type_JavaLangString, 2, "nothing, action:" + paramInt + ", reportType:" + null + "SessionType:" + locallff.jdField_d_of_type_Int + ", BeginSessionType:" + locallff.f + ", sessionStatus:" + j + ", state:" + i);
        }
        Object localObject3 = null;
      }
    }
  }
  
  void b(Intent paramIntent)
  {
    Object localObject2 = null;
    QLog.d(this.jdField_b_of_type_JavaLangString, 1, "startVideoChatActivity");
    mur.a().a();
    if ((this.jdField_a_of_type_ComTencentAvVideoController != null) && (this.jdField_a_of_type_ComTencentAvVideoController.m)) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(113) });
    }
    Intent localIntent = new Intent(super.getApplicationContext(), AVActivity.class);
    localIntent.addFlags(262144);
    Object localObject1;
    int i;
    if (this.jdField_a_of_type_Lff != null)
    {
      localObject1 = this.jdField_a_of_type_Lff.p;
      i = this.jdField_a_of_type_Lff.A;
      localObject2 = this.jdField_a_of_type_Lff.jdField_a_of_type_ArrayOfByte;
    }
    for (;;)
    {
      int j = paramIntent.getIntExtra("uinType", -1);
      boolean bool = paramIntent.getBooleanExtra("isAudioMode", false);
      if (this.jdField_a_of_type_Boolean)
      {
        paramIntent = super.getIntent().getStringExtra("peerUin");
        localIntent.putExtra("sessionType", 3);
        localIntent.putExtra("Type", 1);
        localIntent.putExtra("uin", paramIntent);
        localIntent.putExtra("uinType", 0);
        localIntent.putExtra("isDoubleVideoMeeting", true);
        localIntent.putExtra("inviteUin", paramIntent);
        localIntent.putExtra("sessionType", 1);
        localIntent.putExtra("isSender", false);
        localIntent.putExtra("isEnter", true);
        localIntent.putExtra("name", this.jdField_a_of_type_JavaLangString);
        super.startActivity(localIntent);
        super.overridePendingTransition(2130772170, 2130772169);
        return;
      }
      localIntent.putExtra("uinType", j);
      localIntent.putExtra("bindType", i);
      localIntent.putExtra("bindId", (String)localObject1);
      localIntent.putExtra("uin", this.jdField_c_of_type_JavaLangString);
      localIntent.putExtra("name", this.jdField_a_of_type_JavaLangString);
      localIntent.putExtra("extraUin", this.jdField_d_of_type_JavaLangString);
      localIntent.putExtra("receive", true);
      localIntent.putExtra("isAudioMode", bool);
      localIntent.putExtra("sig", (byte[])localObject2);
      if (QLog.isColorLevel())
      {
        localObject2 = this.jdField_b_of_type_JavaLangString;
        localObject1 = new StringBuilder().append("startVideoChatActivity: bindType = ").append(i).append(",bindId = ").append((String)localObject1).append(",BindType = ");
        if (this.jdField_a_of_type_Lff == null)
        {
          paramIntent = "session info null";
          label433:
          QLog.d((String)localObject2, 2, paramIntent);
        }
      }
      else
      {
        if (j == 0) {
          localIntent.putExtra("isFriend", this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_c_of_type_JavaLangString));
        }
        if (!bool) {
          break label514;
        }
        localIntent.putExtra("sessionType", 1);
      }
      for (;;)
      {
        localIntent.putExtra("isSender", false);
        break;
        paramIntent = Integer.valueOf(this.jdField_a_of_type_Lff.A);
        break label433;
        label514:
        localIntent.putExtra("sessionType", 2);
      }
      i = -1;
      localObject1 = null;
    }
  }
  
  public void b(String paramString)
  {
    QLog.w(this.jdField_b_of_type_JavaLangString, 1, "destroyUI[" + paramString + "]");
    e();
    super.finish();
  }
  
  void c()
  {
    if (this.jdField_a_of_type_AndroidWidgetTextView == null) {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setSingleLine();
    if (b())
    {
      localObject = a(this.jdField_b_of_type_Int, this.jdField_a_of_type_Long, null, this.jdField_b_of_type_Boolean, true);
      this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      return;
    }
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131695042);
      return;
    }
    Object localObject = this.jdField_a_of_type_AndroidWidgetTextView;
    if (this.jdField_b_of_type_Boolean) {}
    for (int i = 2131695055;; i = 2131695056)
    {
      ((TextView)localObject).setText(i);
      return;
    }
  }
  
  void d()
  {
    QLog.d(this.jdField_b_of_type_JavaLangString, 1, "startGActivity");
    Intent localIntent = new Intent(this, AVActivity.class);
    localIntent.addFlags(262144);
    localIntent.addFlags(268435456);
    localIntent.putExtra("sessionType", 3);
    localIntent.putExtra("GroupId", String.valueOf(this.jdField_a_of_type_Long));
    localIntent.putExtra("Type", 1);
    localIntent.putExtra("DiscussUinList", this.jdField_b_of_type_ArrayOfLong);
    localIntent.putExtra("needStartTRAE", true);
    localIntent.putExtra("MultiAVType", this.jdField_a_of_type_Lff.D);
    localIntent.putExtra("uin", String.valueOf(this.jdField_a_of_type_Long));
    localIntent.putExtra("uinType", this.jdField_a_of_type_Int);
    localIntent.putExtra("isFromInviteDialog", true);
    super.startActivity(localIntent);
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool);
    return bool;
  }
  
  void e()
  {
    if (this.jdField_a_of_type_Mro != null) {}
    try
    {
      this.jdField_a_of_type_Mro.dismiss();
      this.jdField_a_of_type_Mro = null;
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        localThrowable.printStackTrace();
      }
    }
  }
  
  void f()
  {
    if (this.jdField_a_of_type_Mtn == null) {
      this.jdField_a_of_type_Mtn = mtn.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    }
    if (b())
    {
      if (this.jdField_a_of_type_Lff != null)
      {
        localObject = String.valueOf(this.jdField_a_of_type_Long);
        Bitmap localBitmap = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_a_of_type_Int, (String)localObject, null, true, true);
        String str = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getDisplayName(mrl.c(this.jdField_b_of_type_Int), Long.toString(this.jdField_b_of_type_Long), (String)localObject);
        this.jdField_a_of_type_Mtn.a(this.jdField_a_of_type_Lff.jdField_c_of_type_JavaLangString, str, localBitmap, (String)localObject, 57, this.jdField_a_of_type_Int, 3);
      }
      return;
    }
    Object localObject = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_a_of_type_Int, this.jdField_c_of_type_JavaLangString, this.jdField_d_of_type_JavaLangString, true, true);
    if ((!this.jdField_b_of_type_Boolean) && (!this.jdField_a_of_type_Boolean))
    {
      this.jdField_a_of_type_Mtn.a(this.jdField_a_of_type_Lff.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, (Bitmap)localObject, null, 56, this.jdField_a_of_type_Int, 2);
      return;
    }
    this.jdField_a_of_type_Mtn.a(this.jdField_a_of_type_Lff.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, (Bitmap)localObject, null, 55, this.jdField_a_of_type_Int, 1);
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    long l = AudioHelper.b();
    QLog.w(this.jdField_b_of_type_JavaLangString, 1, "onCreate, seq[" + l + "]");
    super.onCreate(paramBundle);
    super.getWindow().setBackgroundDrawableResource(2130850683);
    super.getWindow().addFlags(128);
    paramBundle = this.jdField_a_of_type_ComTencentAvVideoController.a();
    if ((paramBundle != null) && (paramBundle.a(this)))
    {
      this.jdField_f_of_type_Boolean = true;
      return;
    }
    mur.a().b(l);
    a(super.getIntent());
    paramBundle = this.jdField_a_of_type_ComTencentAvVideoController.a();
    if (paramBundle != null) {
      paramBundle.a(getClass().getName(), getIntent());
    }
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)
    {
      if (!b()) {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_a_of_type_Lfl);
      }
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_a_of_type_Lef);
      if (b())
      {
        this.jdField_a_of_type_MqqOsMqqHandler = ThreadManager.getUIHandler();
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_a_of_type_Leu);
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_b_of_type_Lef);
        this.jdField_a_of_type_AndroidContentBroadcastReceiver = new mfe(this);
        registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, new IntentFilter("tencent.video.q2v.GvideoMemInviteUpdate"));
      }
    }
    paramBundle = new IntentFilter();
    paramBundle.addAction("tencent.av.EXIT_QZONE_LIVE_RSP_ACTION");
    try
    {
      registerReceiver(this.jdField_b_of_type_AndroidContentBroadcastReceiver, paramBundle);
      this.g = true;
      if (b())
      {
        i = 30000;
        a(i);
        return;
      }
    }
    catch (Throwable paramBundle)
    {
      for (;;)
      {
        paramBundle.printStackTrace();
        continue;
        int i = 60000;
      }
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    jdField_e_of_type_Boolean = false;
    QLog.d(this.jdField_b_of_type_JavaLangString, 1, "onDestroy");
    e();
    this.jdField_a_of_type_AndroidGraphicsBitmap = null;
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(this.jdField_a_of_type_Lfl);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(this.jdField_a_of_type_Lef);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(this.jdField_a_of_type_Leu);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(this.jdField_b_of_type_Lef);
    }
    if (this.jdField_a_of_type_AndroidContentBroadcastReceiver != null) {}
    try
    {
      unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = null;
      if (this.jdField_a_of_type_ComTencentAvUiMutiMemberThumbList != null) {
        this.jdField_a_of_type_ComTencentAvUiMutiMemberThumbList.a();
      }
      if (this.jdField_a_of_type_MqqOsMqqHandler != null)
      {
        this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
        this.jdField_a_of_type_MqqOsMqqHandler = null;
      }
      if (this.jdField_a_of_type_Mtn != null)
      {
        lff locallff = lcb.a().a();
        if (this.jdField_a_of_type_Lff != locallff) {
          this.jdField_a_of_type_Mtn.a(this.jdField_a_of_type_Lff.jdField_c_of_type_JavaLangString);
        }
        if (locallff != null) {
          this.jdField_a_of_type_Mtn.b(locallff.jdField_c_of_type_JavaLangString);
        }
        if ((locallff != null) && (locallff.jdField_c_of_type_JavaLangString != null) && (!locallff.jdField_c_of_type_JavaLangString.equals(this.jdField_f_of_type_JavaLangString))) {
          this.jdField_a_of_type_Mtn.a(this.jdField_f_of_type_JavaLangString);
        }
        this.jdField_a_of_type_Mtn = null;
        if (QLog.isColorLevel()) {
          QLog.i(this.jdField_b_of_type_JavaLangString, 2, "onDestroy main[" + locallff + "], cur[" + this.jdField_a_of_type_Lff + "], id[" + this.jdField_f_of_type_JavaLangString + "]");
        }
      }
      if ((this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) && (!this.jdField_f_of_type_Boolean)) {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(707) });
      }
    }
    catch (Throwable localThrowable1)
    {
      try
      {
        if (this.g)
        {
          unregisterReceiver(this.jdField_b_of_type_AndroidContentBroadcastReceiver);
          this.g = false;
        }
        if (this.jdField_d_of_type_JavaLangRunnable != null)
        {
          ThreadManager.getUIHandler().removeCallbacks(this.jdField_d_of_type_JavaLangRunnable);
          this.jdField_d_of_type_JavaLangRunnable = null;
        }
        if (this.jdField_c_of_type_JavaLangRunnable != null)
        {
          ThreadManager.getSubThreadHandler().removeCallbacks(this.jdField_c_of_type_JavaLangRunnable);
          this.jdField_c_of_type_JavaLangRunnable = null;
        }
        if (this.jdField_a_of_type_JavaLangRunnable != null)
        {
          ThreadManager.getUIHandler().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
          this.jdField_a_of_type_JavaLangRunnable = null;
        }
        return;
        localThrowable1 = localThrowable1;
        localThrowable1.printStackTrace();
      }
      catch (Throwable localThrowable2)
      {
        for (;;)
        {
          localThrowable2.printStackTrace();
        }
      }
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((!this.jdField_d_of_type_Boolean) && (paramInt == 4))
    {
      b(2);
      a(AudioHelper.b(), "onKeyDown", true, null, -1);
      b("onKeyDown");
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "onNewIntent");
    }
    a(paramIntent);
  }
  
  public void onPause()
  {
    super.onPause();
    QLog.d(this.jdField_b_of_type_JavaLangString, 1, "onPause");
    aquy.a(this, 2, true);
    a(false);
  }
  
  public void onResume()
  {
    super.onResume();
    jdField_e_of_type_Boolean = true;
    QLog.d(this.jdField_b_of_type_JavaLangString, 1, "onResume");
    aquy.a(this, 2, false);
    a(true);
    b(0);
    if (this.jdField_a_of_type_ComTencentAvVideoController != null)
    {
      this.jdField_a_of_type_ComTencentAvVideoController.c(this.jdField_c_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentAvVideoController.a(MultiIncomingCallsActivity.class);
    }
  }
  
  public void onStart()
  {
    super.onStart();
    QLog.d(this.jdField_b_of_type_JavaLangString, 1, "onStart");
    if (this.jdField_a_of_type_Lff == null) {}
    lff locallff;
    do
    {
      return;
      if (this.jdField_a_of_type_Mtn == null) {
        this.jdField_a_of_type_Mtn = mtn.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
      }
      this.jdField_a_of_type_Mtn.a(this.jdField_a_of_type_Lff.jdField_c_of_type_JavaLangString);
      locallff = lcb.a().a();
    } while ((locallff == null) || (this.jdField_a_of_type_Lff.jdField_c_of_type_JavaLangString.equals(locallff.jdField_c_of_type_JavaLangString)));
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(false, null);
    this.jdField_a_of_type_Mtn.a(locallff.jdField_c_of_type_JavaLangString);
    this.jdField_f_of_type_JavaLangString = locallff.jdField_c_of_type_JavaLangString;
  }
  
  public void onStop()
  {
    super.onStop();
    QLog.d(this.jdField_b_of_type_JavaLangString, 1, "onStop");
    if (!super.isFinishing())
    {
      f();
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(true, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.ui.MultiIncomingCallsActivity
 * JD-Core Version:    0.7.0.1
 */