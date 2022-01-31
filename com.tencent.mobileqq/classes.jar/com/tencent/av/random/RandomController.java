package com.tencent.av.random;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.av.SessionMgr;
import com.tencent.av.VideoController;
import com.tencent.av.VideoController.GAudioFriends;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.SessionInfo.Anychat_Info;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.smallscreen.SmallScreenUtils;
import com.tencent.av.utils.BitmapTools;
import com.tencent.av.utils.NearbyPeopleProfileHelper;
import com.tencent.av.utils.NearbyPeopleProfileHelper.INearbyPeopleProfileCallBack;
import com.tencent.av.utils.PopupDialog;
import com.tencent.av.utils.QAVNotification;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import jme;
import jmf;
import jmg;
import jmi;
import jmj;
import jmk;
import jmm;
import jmn;
import jmo;
import jmp;
import jmq;
import jmy;
import jmz;
import jnb;

public class RandomController
{
  private static final RandomController jdField_a_of_type_ComTencentAvRandomRandomController = new RandomController();
  public int a;
  public long a;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private VideoController jdField_a_of_type_ComTencentAvVideoController;
  public SessionInfo a;
  private VideoAppInterface jdField_a_of_type_ComTencentAvAppVideoAppInterface;
  private RandomWebProtocol.OnRequestListener jdField_a_of_type_ComTencentAvRandomRandomWebProtocol$OnRequestListener = new jme(this);
  private RandomWebProtocol jdField_a_of_type_ComTencentAvRandomRandomWebProtocol;
  private NearbyPeopleProfileHelper.INearbyPeopleProfileCallBack jdField_a_of_type_ComTencentAvUtilsNearbyPeopleProfileHelper$INearbyPeopleProfileCallBack = new jmg(this);
  private NearbyPeopleProfileHelper jdField_a_of_type_ComTencentAvUtilsNearbyPeopleProfileHelper;
  private Runnable jdField_a_of_type_JavaLangRunnable = new jmi(this);
  public String a;
  private List jdField_a_of_type_JavaUtilList = new ArrayList();
  private AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  private jmq jdField_a_of_type_Jmq = new jmq(this, null);
  public boolean a;
  private byte[] jdField_a_of_type_ArrayOfByte;
  private long[] jdField_a_of_type_ArrayOfLong;
  public int b;
  private Runnable b;
  public String b;
  public boolean b;
  public int c;
  private Runnable c;
  public String c;
  public boolean c;
  private int jdField_d_of_type_Int;
  private Runnable jdField_d_of_type_JavaLangRunnable = new jmm(this);
  public String d;
  private boolean jdField_d_of_type_Boolean;
  private int jdField_e_of_type_Int = -1;
  private Runnable jdField_e_of_type_JavaLangRunnable = new jmn(this);
  public String e;
  private boolean jdField_e_of_type_Boolean;
  private int jdField_f_of_type_Int;
  public String f;
  private boolean jdField_f_of_type_Boolean;
  private int jdField_g_of_type_Int;
  public String g;
  private boolean jdField_g_of_type_Boolean;
  private int jdField_h_of_type_Int = 0;
  private String jdField_h_of_type_JavaLangString;
  private boolean jdField_h_of_type_Boolean;
  private int jdField_i_of_type_Int;
  private boolean jdField_i_of_type_Boolean;
  private int j = 0;
  private int k;
  
  private RandomController()
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = -1;
    this.jdField_c_of_type_Int = -1;
    this.jdField_b_of_type_JavaLangRunnable = new jmj(this);
    this.jdField_c_of_type_JavaLangRunnable = new jmk(this);
  }
  
  private int a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("RandomController", 2, "requestDoubleChat");
    }
    int n = -1;
    int m;
    if ((!this.jdField_a_of_type_ComTencentAvAppSessionInfo.a()) && (!this.jdField_a_of_type_ComTencentAvAppSessionInfo.b()))
    {
      m = n;
      if (!this.jdField_a_of_type_ComTencentAvAppSessionInfo.d()) {}
    }
    else
    {
      if (this.jdField_g_of_type_Boolean) {
        break label146;
      }
      this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_c_of_type_JavaLangString;
      m = this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_c_of_type_JavaLangString, 0, 4, this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_h_of_type_JavaLangString, this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_i_of_type_JavaLangString, this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_g_of_type_JavaLangString, this.jdField_c_of_type_Int, this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_f_of_type_JavaLangString, this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_a_of_type_ArrayOfByte, this.jdField_c_of_type_JavaLangString, null, 0, 0, null, null);
    }
    label146:
    do
    {
      do
      {
        return m;
        m = n;
      } while (!this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_b_of_type_Boolean);
      m = n;
    } while (!TextUtils.equals(this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_c_of_type_JavaLangString));
    return this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_c_of_type_JavaLangString, 0, 4);
  }
  
  private int a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController.jdField_e_of_type_Boolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("RandomController", 2, "startOrEnterGAudio already in room");
      }
      return 0;
    }
    if (QLog.isColorLevel()) {
      QLog.d("RandomController", 2, "startOrEnterGAudio ,retry :" + paramBoolean + ", mCurRetryTimes:" + this.k + ", mGroupIds: " + this.jdField_a_of_type_ArrayOfLong.length);
    }
    if (this.jdField_e_of_type_Int < 0) {
      this.jdField_e_of_type_Int = 150;
    }
    int m = -1;
    int n;
    do
    {
      do
      {
        n = m;
        if (this.k >= this.jdField_a_of_type_ArrayOfLong.length) {
          break;
        }
        this.jdField_a_of_type_Long = this.jdField_a_of_type_ArrayOfLong[this.k];
        this.k += 1;
      } while (this.jdField_a_of_type_Long == 0L);
      String str = this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_b_of_type_JavaLangString;
      this.jdField_b_of_type_JavaLangString = SessionMgr.a(this.jdField_d_of_type_Int, String.valueOf(this.jdField_a_of_type_Long), new int[0]);
      SessionMgr.a().a(str, this.jdField_b_of_type_JavaLangString);
      QAVNotification localQAVNotification = QAVNotification.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
      if ((localQAVNotification != null) && (localQAVNotification.a())) {
        localQAVNotification.a(str, this.jdField_b_of_type_JavaLangString);
      }
      this.jdField_a_of_type_ComTencentAvUtilsNearbyPeopleProfileHelper.a(this.jdField_b_of_type_JavaLangString);
      n = this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_d_of_type_Int, this.jdField_a_of_type_Long, this.jdField_e_of_type_Int, this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_a_of_type_ArrayOfLong, false);
      if (QLog.isColorLevel()) {
        QLog.d("RandomController", 2, "startOrEnterGAudio: ret(" + n + ")==0 mCurrGroupId(" + this.jdField_a_of_type_Long + ") mRelationType(" + this.jdField_d_of_type_Int + ") mBusinessId(" + this.jdField_e_of_type_Int + ")");
      }
      m = n;
    } while (n != 0);
    if (QLog.isColorLevel()) {
      QLog.e("RandomController", 2, "startOrEnterGAudio -->mCurrGroupId == " + this.jdField_a_of_type_Long);
    }
    return n;
  }
  
  public static RandomController a(VideoAppInterface paramVideoAppInterface)
  {
    jdField_a_of_type_ComTencentAvRandomRandomController.a(paramVideoAppInterface);
    return jdField_a_of_type_ComTencentAvRandomRandomController;
  }
  
  private String a(int paramInt)
  {
    String str2 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getResources().getString(2131429372);
    int n = paramInt / 86400;
    int i1 = paramInt % 86400 / 3600;
    int m = paramInt % 3600 / 60;
    if ((n == 0) && (i1 == 0) && (m == 0)) {
      m = 1;
    }
    for (;;)
    {
      StringBuilder localStringBuilder;
      if (n > 0)
      {
        str1 = String.format("%d天", new Object[] { Integer.valueOf(n) });
        localStringBuilder = new StringBuilder().append(str1);
        if (i1 <= 0) {
          break label244;
        }
        str1 = String.format("%d小时", new Object[] { Integer.valueOf(i1) });
        label121:
        str1 = str1;
        localStringBuilder = new StringBuilder().append(str1);
        if (m <= 0) {
          break label252;
        }
      }
      label244:
      label252:
      for (String str1 = String.format("%d分钟", new Object[] { Integer.valueOf(m) });; str1 = "")
      {
        str1 = str2.replace("%t", str1);
        if (QLog.isColorLevel()) {
          QLog.d("RandomController", 2, "getBlockedPromoteText：" + paramInt + ",promtString:" + str1);
        }
        return str1;
        str1 = "";
        break;
        str1 = "";
        break label121;
      }
    }
  }
  
  private void a(VideoAppInterface paramVideoAppInterface)
  {
    if (paramVideoAppInterface != null)
    {
      if (jdField_a_of_type_ComTencentAvRandomRandomController.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null) {
        jdField_a_of_type_ComTencentAvRandomRandomController.jdField_a_of_type_ComTencentAvAppVideoAppInterface = paramVideoAppInterface;
      }
      if (jdField_a_of_type_ComTencentAvRandomRandomController.jdField_a_of_type_ComTencentAvRandomRandomWebProtocol == null) {
        jdField_a_of_type_ComTencentAvRandomRandomController.jdField_a_of_type_ComTencentAvRandomRandomWebProtocol = new RandomWebProtocol(paramVideoAppInterface);
      }
      this.jdField_a_of_type_ComTencentAvVideoController = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
    }
  }
  
  private void a(String paramString1, String paramString2, byte[] paramArrayOfByte, String paramString3, Bitmap paramBitmap, String paramString4, int paramInt)
  {
    this.jdField_d_of_type_JavaLangString = paramString1;
    this.jdField_e_of_type_JavaLangString = paramString2;
    if (paramArrayOfByte != null)
    {
      this.jdField_a_of_type_ArrayOfByte = new byte[paramArrayOfByte.length + 3];
      this.jdField_a_of_type_ArrayOfByte[0] = 1;
      this.jdField_a_of_type_ArrayOfByte[1] = 1;
      this.jdField_a_of_type_ArrayOfByte[2] = -118;
      System.arraycopy(paramArrayOfByte, 0, this.jdField_a_of_type_ArrayOfByte, 3, paramArrayOfByte.length);
      this.jdField_f_of_type_JavaLangString = paramString3;
      this.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
      this.jdField_h_of_type_JavaLangString = paramString4;
      if (paramInt <= 0) {
        break label115;
      }
      this.jdField_b_of_type_Boolean = true;
    }
    label115:
    while (paramInt != 0)
    {
      return;
      this.jdField_a_of_type_ArrayOfByte = new byte[] { 1, 1, -118 };
      break;
    }
    this.jdField_b_of_type_Boolean = false;
  }
  
  private void a(jmy paramjmy)
  {
    Object localObject1 = null;
    this.jdField_c_of_type_Int = 1011;
    if ((paramjmy instanceof jmz)) {
      if (this.jdField_a_of_type_Boolean) {
        if (QLog.isColorLevel()) {
          QLog.w("RandomController", 2, "[1v1] processWebProtocol RspDouble discard this push");
        }
      }
    }
    for (;;)
    {
      return;
      this.jdField_a_of_type_Boolean = true;
      Object localObject2 = (jmz)paramjmy;
      a(((jmz)localObject2).jdField_b_of_type_JavaLangString, ((jmz)localObject2).jdField_c_of_type_JavaLangString, ((jmz)localObject2).jdField_a_of_type_ArrayOfByte, ((jmz)localObject2).jdField_e_of_type_JavaLangString, ((jmz)localObject2).jdField_a_of_type_AndroidGraphicsBitmap, ((jmz)localObject2).jdField_d_of_type_JavaLangString, ((jmz)localObject2).jdField_f_of_type_Int);
      this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_d_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_f_of_type_JavaLangString);
      do
      {
        localObject2 = this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_b_of_type_JavaLangString;
        this.jdField_b_of_type_JavaLangString = SessionMgr.a(3, this.jdField_d_of_type_JavaLangString, new int[0]);
        SessionMgr.a().a((String)localObject2, this.jdField_b_of_type_JavaLangString);
        if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)
        {
          QAVNotification localQAVNotification = QAVNotification.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
          if ((localQAVNotification != null) && (localQAVNotification.a())) {
            localQAVNotification.a((String)localObject2, this.jdField_b_of_type_JavaLangString);
          }
        }
        if (this.jdField_a_of_type_ComTencentAvUtilsNearbyPeopleProfileHelper != null) {
          this.jdField_a_of_type_ComTencentAvUtilsNearbyPeopleProfileHelper.a(this.jdField_b_of_type_JavaLangString);
        }
        if ((this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_i_of_type_Int != 1011) && (!TextUtils.equals(this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_c_of_type_JavaLangString, this.jdField_d_of_type_JavaLangString)) && (this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_b_of_type_Boolean))
        {
          this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_c_of_type_JavaLangString, 0);
          this.jdField_a_of_type_ComTencentAvVideoController.b(221);
        }
        if ((this.jdField_h_of_type_JavaLangString != null) && (!TextUtils.isEmpty(this.jdField_h_of_type_JavaLangString))) {
          this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_e_of_type_JavaLangString = (this.jdField_a_of_type_ComTencentAvVideoController.a().getResources().getString(2131429350) + this.jdField_h_of_type_JavaLangString);
        }
        if (this.jdField_f_of_type_Int != 1) {
          break label979;
        }
        if (!TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString)) {
          break label551;
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("RandomController", 2, "uin is empty");
        return;
      } while (!(paramjmy instanceof jnb));
      localObject2 = (jnb)paramjmy;
      if (QLog.isColorLevel()) {
        QLog.d("RandomController", 2, "processWebProtocol RspMulti [random room owner]");
      }
      if (((jnb)localObject2).jdField_f_of_type_Int > 0) {
        this.jdField_b_of_type_Boolean = true;
      }
      for (;;)
      {
        this.jdField_e_of_type_Int = ((jnb)localObject2).jdField_g_of_type_Int;
        this.jdField_g_of_type_JavaLangString = ((jnb)localObject2).jdField_c_of_type_JavaLangString;
        this.jdField_h_of_type_Boolean = ((jnb)localObject2).jdField_a_of_type_Boolean;
        if ((TextUtils.isEmpty(this.jdField_g_of_type_JavaLangString)) && (this.jdField_h_of_type_Boolean)) {
          this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_b_of_type_JavaLangRunnable, 7000L);
        }
        if (!this.jdField_h_of_type_Boolean) {
          this.jdField_g_of_type_JavaLangString = null;
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("RandomController", 2, "[random room owner] processWebProtocol RspMulti mRoomOwnerUin = " + this.jdField_g_of_type_JavaLangString + ",mRoomOwnerEnable = " + this.jdField_h_of_type_Boolean);
        break;
        if (((jnb)localObject2).jdField_f_of_type_Int == 0) {
          this.jdField_b_of_type_Boolean = false;
        }
      }
      label551:
      this.jdField_h_of_type_Int = 1;
      boolean bool;
      if ((this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null) || (Long.valueOf(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin()).longValue() <= Long.valueOf(this.jdField_d_of_type_JavaLangString).longValue()))
      {
        bool = true;
        label592:
        this.jdField_g_of_type_Boolean = bool;
        this.jdField_a_of_type_ComTencentAvVideoController.A();
        if (!this.jdField_b_of_type_Boolean) {
          break label943;
        }
      }
      try
      {
        paramjmy = BitmapTools.a(this.jdField_a_of_type_AndroidGraphicsBitmap, this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth() / 2);
        if (paramjmy != null) {
          this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_a_of_type_AndroidGraphicsBitmap = paramjmy;
        }
        this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_d_of_type_JavaLangString = this.jdField_e_of_type_JavaLangString;
        this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_b_of_type_JavaLangString = this.jdField_e_of_type_JavaLangString;
        for (;;)
        {
          this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_d_of_type_Int = this.jdField_h_of_type_Int;
          this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_i_of_type_Int = this.jdField_c_of_type_Int;
          this.jdField_a_of_type_ComTencentAvAppSessionInfo.Q = true;
          this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_a_of_type_ArrayOfByte = this.jdField_a_of_type_ArrayOfByte;
          this.jdField_a_of_type_ComTencentAvAppSessionInfo.J = false;
          this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_f_of_type_Int = this.jdField_h_of_type_Int;
          this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_c_of_type_JavaLangString = this.jdField_d_of_type_JavaLangString;
          if (QLog.isColorLevel()) {
            QLog.d("RandomController", 2, "processWebProtocol  uinType = " + this.jdField_c_of_type_Int + " # peerUin = " + this.jdField_d_of_type_JavaLangString + " # signature = " + this.jdField_a_of_type_ArrayOfByte + " # BeginSessionType = " + this.jdField_h_of_type_Int + " # nickName = " + this.jdField_e_of_type_JavaLangString + " # roomTopic = " + this.jdField_c_of_type_JavaLangString + " # topTips = " + this.jdField_h_of_type_JavaLangString + ", isMask: " + this.jdField_b_of_type_Boolean);
          }
          if ((this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) && (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a() != null)) {
            this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
          }
          PopupDialog.a();
          paramjmy = this.jdField_a_of_type_JavaUtilList.iterator();
          while (paramjmy.hasNext()) {
            ((RandomController.RandomListener)paramjmy.next()).a();
          }
          bool = false;
          break label592;
          label943:
          a(this.jdField_d_of_type_JavaLangString);
          paramjmy = a(this.jdField_d_of_type_JavaLangString, false);
          if (paramjmy != null)
          {
            this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_a_of_type_AndroidGraphicsBitmap = paramjmy;
            continue;
            label979:
            if (this.jdField_f_of_type_Int == 2)
            {
              this.jdField_h_of_type_Int = 3;
              this.jdField_d_of_type_Int = 7;
              this.k = 0;
              if (!(paramjmy instanceof jnb)) {
                break label1325;
              }
              paramjmy = ((jnb)paramjmy).jdField_b_of_type_JavaLangString;
              if ((paramjmy == null) || (paramjmy.equals(""))) {
                break;
              }
              paramjmy = paramjmy.split(",");
              this.jdField_a_of_type_ArrayOfLong = new long[paramjmy.length];
              int m = 0;
              for (;;)
              {
                if (m < paramjmy.length) {
                  try
                  {
                    this.jdField_a_of_type_ArrayOfLong[m] = Long.parseLong(paramjmy[m].trim());
                    m += 1;
                  }
                  catch (NumberFormatException localNumberFormatException)
                  {
                    for (;;)
                    {
                      this.jdField_a_of_type_ArrayOfLong[m] = 0L;
                      localNumberFormatException.printStackTrace();
                    }
                  }
                }
              }
              if ((this.jdField_h_of_type_Int == 3) || (this.jdField_h_of_type_Int == 4))
              {
                this.jdField_a_of_type_ComTencentAvAppSessionInfo.q = String.valueOf(this.jdField_a_of_type_Long);
                this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_f_of_type_Long = this.jdField_a_of_type_Long;
              }
              if (QLog.isColorLevel()) {
                QLog.d("RandomController", 2, "[random room owner] mRelationType = " + this.jdField_d_of_type_Int);
              }
              this.jdField_a_of_type_ComTencentAvAppSessionInfo.F = this.jdField_d_of_type_Int;
              this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_a_of_type_Boolean = false;
              this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_a_of_type_JavaLangString = null;
              this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_b_of_type_JavaLangString = null;
              this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_a_of_type_Boolean = false;
            }
          }
        }
        if ((this.jdField_a_of_type_Int == 2) || (this.jdField_a_of_type_Int == 3)) {
          continue;
        }
        if (QLog.isColorLevel()) {
          QLog.d("RandomController", 2, "[warning] already in connecting. mStatus = " + this.jdField_a_of_type_Int);
        }
        this.jdField_a_of_type_Int = 2;
        if (this.jdField_f_of_type_Int == 1)
        {
          a();
          return;
        }
        if (this.jdField_f_of_type_Int != 2) {
          continue;
        }
        a(false);
        return;
      }
      catch (OutOfMemoryError paramjmy)
      {
        for (;;)
        {
          paramjmy = localNumberFormatException;
        }
      }
      catch (Exception paramjmy)
      {
        for (;;)
        {
          paramjmy = localNumberFormatException;
          continue;
          label1325:
          paramjmy = null;
        }
      }
    }
  }
  
  private void b(jmy paramjmy)
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    if (this.jdField_a_of_type_Int == -3) {
      return;
    }
    PopupDialog.a();
    if (this.jdField_f_of_type_Int == 2) {
      ReportController.b(null, "CliOper", "", "", "0X8005728", "0X8005728", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      this.jdField_a_of_type_Int = -3;
      localObject = this.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((RandomController.RandomListener)((Iterator)localObject).next()).a();
      }
      if (this.jdField_f_of_type_Int == 1) {
        ReportController.b(null, "CliOper", "", "", "0X8005726", "0X8005726", 0, 0, "", "", "", "");
      }
    }
    Object localObject = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getApplicationContext();
    this.jdField_i_of_type_Int = paramjmy.jdField_e_of_type_Int;
    PopupDialog.b((Context)localObject, 230, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getResources().getString(2131429371), a(this.jdField_i_of_type_Int), 2131428674, 0, null, new jmo(this));
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_d_of_type_JavaLangRunnable, 60000L);
    this.jdField_i_of_type_Int -= 60;
  }
  
  private void d()
  {
    if ((this.jdField_a_of_type_Int == 1) && (QLog.isColorLevel())) {
      QLog.d("RandomController", 2, "gotoMatchTimeout trigger, show timeOutDialog!");
    }
    if ((this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) && (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a() != null) && (this.jdField_f_of_type_Int == 1)) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().post(this.jdField_a_of_type_JavaLangRunnable);
    }
  }
  
  private void e()
  {
    if ((this.jdField_a_of_type_Int == 1) && (QLog.isColorLevel())) {
      QLog.d("RandomController", 2, "gotoMatchError trigger, show timeOutDialog!");
    }
    this.jdField_a_of_type_Int = -2;
  }
  
  private void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("RandomController", 2, "showTimeoutDialog");
    }
    if ((this.jdField_a_of_type_ComTencentAvVideoController.jdField_b_of_type_Int == 0) || (this.jdField_i_of_type_Boolean)) {}
    for (;;)
    {
      return;
      if (this.jdField_f_of_type_Int == 1) {
        ReportController.b(null, "CliOper", "", "", "0X80053B3", "0X80053B3", 0, 0, "", "", "", "");
      }
      while (!this.jdField_a_of_type_ComTencentAvAppSessionInfo.f())
      {
        Context localContext = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getApplicationContext();
        PopupDialog.b(localContext, 230, null, localContext.getString(2131429367), 2131428675, 2131429319, new jmp(this), new jmf(this));
        this.jdField_i_of_type_Boolean = true;
        return;
        if (this.jdField_f_of_type_Int == 2) {
          ReportController.b(null, "CliOper", "", "", "0X80053BF", "0X80053BF", 0, 0, "", "", "", "");
        }
      }
    }
  }
  
  public int a(String paramString)
  {
    int m = -1;
    if ((this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin().equals(paramString)) && (this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_d_of_type_Int != -1)) {
      m = this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_d_of_type_Int;
    }
    do
    {
      return m;
      paramString = this.jdField_a_of_type_ComTencentAvVideoController.a(paramString);
    } while (paramString == null);
    return paramString.jdField_b_of_type_Int;
  }
  
  public Bitmap a(String paramString, boolean paramBoolean)
  {
    int m = 1;
    if ((TextUtils.isEmpty(paramString)) || (this.jdField_a_of_type_ComTencentAvVideoController == null)) {
      paramString = null;
    }
    Bitmap localBitmap;
    do
    {
      return paramString;
      if (QLog.isColorLevel()) {
        QLog.d("RandomController", 2, "[pullhead] ~~~~~~ getRandomFaceBitmap ~~~~~~ uin(" + paramString + "), isMask(" + this.jdField_b_of_type_Boolean + ")");
      }
      if (!this.jdField_b_of_type_Boolean) {
        return this.jdField_a_of_type_ComTencentAvVideoController.a(paramString);
      }
      if (this.jdField_f_of_type_Int != 1) {
        break;
      }
      localBitmap = this.jdField_a_of_type_ComTencentAvVideoController.a(paramString, true);
      paramString = localBitmap;
    } while (localBitmap != null);
    this.jdField_a_of_type_ComTencentAvRandomRandomWebProtocol.a(this.jdField_d_of_type_JavaLangString, this.jdField_f_of_type_JavaLangString);
    return null;
    if (this.jdField_f_of_type_Int == 2)
    {
      localBitmap = this.jdField_a_of_type_ComTencentAvVideoController.a(paramString, true);
      int n;
      RandomWebProtocol localRandomWebProtocol;
      int i1;
      if ((localBitmap == null) || (paramBoolean))
      {
        n = a(paramString);
        if (n == -1)
        {
          if (QLog.isColorLevel()) {
            QLog.e("RandomController", 2, "getRandomFaceBitmap-->uin=" + paramString + ", gender" + n);
          }
          a(paramString);
          return null;
        }
        if (QLog.isColorLevel()) {
          QLog.d("RandomController", 2, "[pullhead] call pull Head uin(" + paramString + "), isMask(" + this.jdField_b_of_type_Boolean + ")");
        }
        localRandomWebProtocol = this.jdField_a_of_type_ComTencentAvRandomRandomWebProtocol;
        i1 = this.jdField_g_of_type_Int;
        if (!paramString.equals(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getAccount())) {
          break label317;
        }
      }
      for (;;)
      {
        localRandomWebProtocol.a(i1, m, paramString, n, this.jdField_a_of_type_Long);
        return localBitmap;
        label317:
        m = 2;
      }
    }
    return null;
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) && (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a() != null)) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
    }
  }
  
  public void a(String paramString)
  {
    if ((this.jdField_a_of_type_ComTencentAvUtilsNearbyPeopleProfileHelper != null) && (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)) {
      this.jdField_a_of_type_ComTencentAvUtilsNearbyPeopleProfileHelper.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, paramString);
    }
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("RandomController", 2, "start random matching");
    }
    this.jdField_a_of_type_Boolean = false;
    this.jdField_h_of_type_JavaLangString = null;
    if (this.jdField_a_of_type_ComTencentAvUtilsNearbyPeopleProfileHelper == null)
    {
      this.jdField_a_of_type_ComTencentAvUtilsNearbyPeopleProfileHelper = NearbyPeopleProfileHelper.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
      this.jdField_a_of_type_ComTencentAvUtilsNearbyPeopleProfileHelper.a(this.jdField_a_of_type_ComTencentAvUtilsNearbyPeopleProfileHelper$INearbyPeopleProfileCallBack);
    }
    if (this.jdField_a_of_type_ComTencentAvAppSessionInfo == null)
    {
      this.jdField_b_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
      if (!SessionMgr.a().a(this.jdField_b_of_type_JavaLangString)) {
        this.jdField_a_of_type_ComTencentAvAppSessionInfo = SessionMgr.a().a(this.jdField_b_of_type_JavaLangString, false);
      }
    }
    if (this.jdField_a_of_type_ComTencentAvAppSessionInfo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("RandomController", 2, "start random matching mSessionInfo is null!");
      }
      return;
    }
    this.jdField_a_of_type_Int = 1;
    if ((this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) && (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a() != null)) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_a_of_type_JavaLangRunnable, 7000L);
    }
    if (this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_b_of_type_Int != 2) {
      this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_b_of_type_Int = 1;
    }
    if (this.jdField_f_of_type_Int == 1) {
      if (!this.jdField_a_of_type_ComTencentAvRandomRandomWebProtocol.a())
      {
        this.jdField_d_of_type_Boolean = true;
        if ((this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) && (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a() != null)) {
          this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_e_of_type_JavaLangRunnable, 2000L);
        }
        this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_b_of_type_Int, 1, this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_d_of_type_JavaLangString);
      }
    }
    for (;;)
    {
      label271:
      if (this.jdField_a_of_type_ComTencentAvAppSessionInfo != null)
      {
        this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_d_of_type_Boolean = this.jdField_b_of_type_Boolean;
        this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_d_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
        return;
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(0);
        this.jdField_a_of_type_ComTencentAvRandomRandomWebProtocol.a(this.jdField_g_of_type_Int, this.j, 1, new String[0]);
        break;
        if (this.jdField_f_of_type_Int == 2)
        {
          if (this.jdField_a_of_type_ComTencentAvRandomRandomWebProtocol.a()) {
            break label427;
          }
          this.jdField_e_of_type_Boolean = true;
          if ((this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) && (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a() != null)) {
            this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_e_of_type_JavaLangRunnable, 2000L);
          }
        }
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_b_of_type_Int, 3, this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_d_of_type_JavaLangString);
      break label271;
      break;
      label427:
      this.jdField_a_of_type_ComTencentAvRandomRandomWebProtocol.a(this.jdField_b_of_type_Boolean, this.jdField_g_of_type_Int);
    }
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("RandomController", 2, "stop random matching");
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    PopupDialog.a();
    if (this.jdField_a_of_type_Int == 4) {
      if (QLog.isColorLevel()) {
        QLog.d("RandomController", 2, "stop random matching is already closed!");
      }
    }
    do
    {
      do
      {
        do
        {
          return;
          if ((this.jdField_f_of_type_Int == 1) || (this.jdField_f_of_type_Int == 2)) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d("RandomController", 2, "stop random matching mType is invalid!");
        return;
        if (this.jdField_a_of_type_ComTencentAvAppSessionInfo != null) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("RandomController", 2, "stop random matching mSessionInfo = null!");
      return;
      Object localObject = QAVNotification.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
      if (localObject != null) {
        ((QAVNotification)localObject).a(this.jdField_b_of_type_JavaLangString);
      }
      this.jdField_a_of_type_ComTencentAvVideoController.x();
      if (this.jdField_a_of_type_Int == 1) {
        this.jdField_a_of_type_ComTencentAvRandomRandomWebProtocol.a();
      }
      if (this.jdField_a_of_type_Int == -3)
      {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_d_of_type_JavaLangRunnable);
        PopupDialog.a();
      }
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_e_of_type_JavaLangRunnable);
      if (this.jdField_f_of_type_Int == 1)
      {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_Jmq);
        localObject = this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_c_of_type_JavaLangString;
        if ((this.jdField_d_of_type_JavaLangString != null) && (this.jdField_d_of_type_JavaLangString.equals(localObject)))
        {
          this.jdField_a_of_type_ComTencentAvVideoController.a((String)localObject, 0);
          this.jdField_a_of_type_ComTencentAvVideoController.b(223);
          if (this.jdField_a_of_type_ComTencentAvAppSessionInfo.z == -1) {
            this.jdField_a_of_type_ComTencentAvAppSessionInfo.z = 0;
          }
          this.jdField_a_of_type_ComTencentAvAppSessionInfo.o = true;
          this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_c_of_type_Boolean = false;
          this.jdField_a_of_type_ComTencentAvVideoController.c((String)localObject, this.jdField_a_of_type_ComTencentAvAppSessionInfo.z);
        }
      }
      for (;;)
      {
        if (this.jdField_a_of_type_ComTencentAvUtilsNearbyPeopleProfileHelper != null)
        {
          this.jdField_a_of_type_ComTencentAvUtilsNearbyPeopleProfileHelper.a();
          this.jdField_a_of_type_ComTencentAvUtilsNearbyPeopleProfileHelper = null;
        }
        this.jdField_a_of_type_Int = 4;
        SessionMgr.a().a().jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_b_of_type_Int = 0;
        this.jdField_a_of_type_ComTencentAvVideoController.a(0, 0, null);
        localObject = this.jdField_a_of_type_JavaUtilList.iterator();
        while (((Iterator)localObject).hasNext()) {
          ((RandomController.RandomListener)((Iterator)localObject).next()).a();
        }
        if (this.jdField_f_of_type_Int == 2)
        {
          this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_c_of_type_JavaLangRunnable);
          a();
          this.jdField_f_of_type_Boolean = false;
          if ((this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_Long != 0L))
          {
            localObject = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin();
            this.jdField_a_of_type_ComTencentAvRandomRandomWebProtocol.a(this.jdField_g_of_type_Int, 4, (String)localObject, a((String)localObject), this.jdField_a_of_type_Long);
          }
          this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_f_of_type_Boolean = false;
          this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_d_of_type_Int, this.jdField_a_of_type_Long, 90);
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("RandomController", 2, "stop random matching mSessionId = " + this.jdField_b_of_type_JavaLangString);
      }
      if ((this.jdField_d_of_type_JavaLangString != null) && (this.jdField_d_of_type_JavaLangString.equals(SessionMgr.a().a().jdField_c_of_type_JavaLangString))) {
        SessionMgr.a().a().b();
      }
      SessionMgr.a().a().d();
      SessionMgr.a().c(this.jdField_b_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentAvAppSessionInfo = null;
      this.jdField_b_of_type_JavaLangString = null;
      SmallScreenUtils.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp());
    } while (!QLog.isColorLevel());
    QLog.d("RandomController", 2, "stop random matching end");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.av.random.RandomController
 * JD-Core Version:    0.7.0.1
 */