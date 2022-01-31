package com.tencent.av.random;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.text.TextUtils;
import axqy;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.utils.PopupDialog;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import lcx;
import ldr;
import lga;
import lgb;
import lst;
import lsu;
import lsv;
import lsx;
import lsy;
import lsz;
import lta;
import ltg;
import lth;
import ltj;
import lze;
import mqt;
import mrv;
import mrx;
import msp;

public class RandomController
{
  private static final RandomController jdField_a_of_type_ComTencentAvRandomRandomController = new RandomController();
  public int a;
  public long a;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private VideoController jdField_a_of_type_ComTencentAvVideoController;
  private VideoAppInterface jdField_a_of_type_ComTencentAvAppVideoAppInterface;
  private RandomController.RequestFetchRunnable jdField_a_of_type_ComTencentAvRandomRandomController$RequestFetchRunnable = new RandomController.RequestFetchRunnable(this, null);
  private RandomWebProtocol jdField_a_of_type_ComTencentAvRandomRandomWebProtocol;
  private Runnable jdField_a_of_type_JavaLangRunnable = new RandomController.3(this);
  public String a;
  private List<lsz> jdField_a_of_type_JavaUtilList = new ArrayList();
  private AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  public lga a;
  private lta jdField_a_of_type_Lta = new lst(this);
  private mrv jdField_a_of_type_Mrv;
  private mrx jdField_a_of_type_Mrx = new lsv(this);
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
  private Runnable jdField_d_of_type_JavaLangRunnable = new RandomController.6(this);
  public String d;
  private boolean jdField_d_of_type_Boolean;
  private int jdField_e_of_type_Int = -1;
  private Runnable jdField_e_of_type_JavaLangRunnable = new RandomController.7(this);
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
    this.jdField_b_of_type_JavaLangRunnable = new RandomController.4(this);
    this.jdField_c_of_type_JavaLangRunnable = new RandomController.5(this);
  }
  
  private int a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("RandomController", 2, "requestDoubleChat");
    }
    int n = -1;
    int m;
    if ((!this.jdField_a_of_type_Lga.d()) && (!this.jdField_a_of_type_Lga.e()))
    {
      m = n;
      if (!this.jdField_a_of_type_Lga.h()) {}
    }
    else
    {
      if (this.jdField_g_of_type_Boolean) {
        break label147;
      }
      this.jdField_a_of_type_Lga.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_Lga.jdField_a_of_type_Lgb.jdField_c_of_type_JavaLangString;
      m = this.jdField_a_of_type_ComTencentAvVideoController.a(0L, this.jdField_a_of_type_Lga.jdField_d_of_type_JavaLangString, 0, 4, this.jdField_a_of_type_Lga.jdField_i_of_type_JavaLangString, this.jdField_a_of_type_Lga.j, this.jdField_a_of_type_Lga.a(), this.jdField_c_of_type_Int, this.jdField_a_of_type_Lga.jdField_f_of_type_JavaLangString, this.jdField_a_of_type_Lga.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_Lga.jdField_a_of_type_ArrayOfByte, this.jdField_c_of_type_JavaLangString, null, 0, 0, null, null);
    }
    label147:
    do
    {
      do
      {
        return m;
        m = n;
      } while (!this.jdField_a_of_type_Lga.jdField_a_of_type_Lgb.jdField_b_of_type_Boolean);
      m = n;
    } while (!TextUtils.equals(this.jdField_a_of_type_Lga.jdField_d_of_type_JavaLangString, this.jdField_a_of_type_Lga.jdField_a_of_type_Lgb.jdField_c_of_type_JavaLangString));
    return this.jdField_a_of_type_ComTencentAvVideoController.a(0L, this.jdField_a_of_type_Lga.jdField_d_of_type_JavaLangString, 0, 4);
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
      String str = this.jdField_a_of_type_Lga.jdField_c_of_type_JavaLangString;
      this.jdField_b_of_type_JavaLangString = lcx.a(this.jdField_d_of_type_Int, String.valueOf(this.jdField_a_of_type_Long), new int[0]);
      lcx.a().a(str, this.jdField_b_of_type_JavaLangString);
      msp localmsp = msp.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
      if ((localmsp != null) && (localmsp.a())) {
        localmsp.a(str, this.jdField_b_of_type_JavaLangString);
      }
      this.jdField_a_of_type_Mrv.a(this.jdField_b_of_type_JavaLangString);
      n = this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_d_of_type_Int, this.jdField_a_of_type_Long, this.jdField_e_of_type_Int, this.jdField_a_of_type_Lga.jdField_a_of_type_ArrayOfLong, false);
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
    String str2 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getString(2131696031);
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
          break label241;
        }
        str1 = String.format("%d小时", new Object[] { Integer.valueOf(i1) });
        label118:
        str1 = str1;
        localStringBuilder = new StringBuilder().append(str1);
        if (m <= 0) {
          break label249;
        }
      }
      label241:
      label249:
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
        break label118;
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
  
  private void a(ltg paramltg)
  {
    Object localObject1 = null;
    this.jdField_c_of_type_Int = 1011;
    if ((paramltg instanceof lth)) {
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
      Object localObject2 = (lth)paramltg;
      a(((lth)localObject2).jdField_b_of_type_JavaLangString, ((lth)localObject2).jdField_c_of_type_JavaLangString, ((lth)localObject2).jdField_a_of_type_ArrayOfByte, ((lth)localObject2).jdField_e_of_type_JavaLangString, ((lth)localObject2).jdField_a_of_type_AndroidGraphicsBitmap, ((lth)localObject2).jdField_d_of_type_JavaLangString, ((lth)localObject2).jdField_f_of_type_Int);
      this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_d_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_f_of_type_JavaLangString);
      do
      {
        localObject2 = this.jdField_a_of_type_Lga.jdField_c_of_type_JavaLangString;
        this.jdField_b_of_type_JavaLangString = lcx.a(3, this.jdField_d_of_type_JavaLangString, new int[0]);
        lcx.a().a((String)localObject2, this.jdField_b_of_type_JavaLangString);
        if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)
        {
          msp localmsp = msp.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
          if ((localmsp != null) && (localmsp.a())) {
            localmsp.a((String)localObject2, this.jdField_b_of_type_JavaLangString);
          }
        }
        if (this.jdField_a_of_type_Mrv != null) {
          this.jdField_a_of_type_Mrv.a(this.jdField_b_of_type_JavaLangString);
        }
        if ((this.jdField_a_of_type_Lga.jdField_i_of_type_Int != 1011) && (!TextUtils.equals(this.jdField_a_of_type_Lga.jdField_d_of_type_JavaLangString, this.jdField_d_of_type_JavaLangString)) && (this.jdField_a_of_type_Lga.jdField_a_of_type_Lgb.jdField_b_of_type_Boolean))
        {
          this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_a_of_type_Lga.jdField_d_of_type_JavaLangString, 221);
          this.jdField_a_of_type_ComTencentAvVideoController.b(221);
        }
        if ((this.jdField_h_of_type_JavaLangString != null) && (!TextUtils.isEmpty(this.jdField_h_of_type_JavaLangString))) {
          this.jdField_a_of_type_Lga.jdField_a_of_type_Lgb.jdField_e_of_type_JavaLangString = (this.jdField_a_of_type_ComTencentAvVideoController.a().getString(2131696047) + this.jdField_h_of_type_JavaLangString);
        }
        if (this.jdField_f_of_type_Int != 1) {
          break label984;
        }
        if (!TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString)) {
          break label550;
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("RandomController", 2, "uin is empty");
        return;
      } while (!(paramltg instanceof ltj));
      localObject2 = (ltj)paramltg;
      if (QLog.isColorLevel()) {
        QLog.d("RandomController", 2, "processWebProtocol RspMulti [random room owner]");
      }
      if (((ltj)localObject2).jdField_f_of_type_Int > 0) {
        this.jdField_b_of_type_Boolean = true;
      }
      for (;;)
      {
        this.jdField_e_of_type_Int = ((ltj)localObject2).jdField_g_of_type_Int;
        this.jdField_g_of_type_JavaLangString = ((ltj)localObject2).jdField_c_of_type_JavaLangString;
        this.jdField_h_of_type_Boolean = ((ltj)localObject2).jdField_a_of_type_Boolean;
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
        if (((ltj)localObject2).jdField_f_of_type_Int == 0) {
          this.jdField_b_of_type_Boolean = false;
        }
      }
      label550:
      this.jdField_h_of_type_Int = 1;
      boolean bool;
      if ((this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null) || (Long.valueOf(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin()).longValue() <= Long.valueOf(this.jdField_d_of_type_JavaLangString).longValue()))
      {
        bool = true;
        label591:
        this.jdField_g_of_type_Boolean = bool;
        this.jdField_a_of_type_ComTencentAvVideoController.w();
        if (!this.jdField_b_of_type_Boolean) {
          break label948;
        }
      }
      try
      {
        paramltg = mqt.a(this.jdField_a_of_type_AndroidGraphicsBitmap, this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth() / 2);
        if (paramltg != null) {
          this.jdField_a_of_type_Lga.jdField_a_of_type_Lgb.jdField_a_of_type_AndroidGraphicsBitmap = paramltg;
        }
        this.jdField_a_of_type_Lga.jdField_e_of_type_JavaLangString = this.jdField_e_of_type_JavaLangString;
        this.jdField_a_of_type_Lga.jdField_a_of_type_Lgb.jdField_b_of_type_JavaLangString = this.jdField_e_of_type_JavaLangString;
        for (;;)
        {
          this.jdField_a_of_type_Lga.a(-1032L, "processWebProtocol", this.jdField_h_of_type_Int);
          this.jdField_a_of_type_Lga.jdField_i_of_type_Int = this.jdField_c_of_type_Int;
          this.jdField_a_of_type_Lga.Q = true;
          this.jdField_a_of_type_Lga.jdField_a_of_type_ArrayOfByte = this.jdField_a_of_type_ArrayOfByte;
          this.jdField_a_of_type_Lga.L = false;
          this.jdField_a_of_type_Lga.jdField_f_of_type_Int = this.jdField_h_of_type_Int;
          this.jdField_a_of_type_Lga.jdField_a_of_type_Lgb.jdField_c_of_type_JavaLangString = this.jdField_d_of_type_JavaLangString;
          if (QLog.isColorLevel()) {
            QLog.d("RandomController", 2, "processWebProtocol  uinType = " + this.jdField_c_of_type_Int + " # peerUin = " + this.jdField_d_of_type_JavaLangString + " # signature = " + this.jdField_a_of_type_ArrayOfByte + " # BeginSessionType = " + this.jdField_h_of_type_Int + " # nickName = " + this.jdField_e_of_type_JavaLangString + " # roomTopic = " + this.jdField_c_of_type_JavaLangString + " # topTips = " + this.jdField_h_of_type_JavaLangString + ", isMask: " + this.jdField_b_of_type_Boolean);
          }
          if ((this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) && (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a() != null)) {
            this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
          }
          PopupDialog.a();
          paramltg = this.jdField_a_of_type_JavaUtilList.iterator();
          while (paramltg.hasNext()) {
            ((lsz)paramltg.next()).a();
          }
          bool = false;
          break label591;
          label948:
          a(this.jdField_d_of_type_JavaLangString);
          paramltg = a(this.jdField_d_of_type_JavaLangString, false);
          if (paramltg != null)
          {
            this.jdField_a_of_type_Lga.jdField_a_of_type_Lgb.jdField_a_of_type_AndroidGraphicsBitmap = paramltg;
            continue;
            label984:
            if (this.jdField_f_of_type_Int == 2)
            {
              this.jdField_h_of_type_Int = 3;
              this.jdField_d_of_type_Int = 7;
              this.k = 0;
              if (!(paramltg instanceof ltj)) {
                break label1316;
              }
              paramltg = ((ltj)paramltg).jdField_b_of_type_JavaLangString;
              if ((paramltg == null) || (paramltg.equals(""))) {
                break;
              }
              paramltg = paramltg.split(",");
              this.jdField_a_of_type_ArrayOfLong = new long[paramltg.length];
              int m = 0;
              for (;;)
              {
                if (m < paramltg.length) {
                  try
                  {
                    this.jdField_a_of_type_ArrayOfLong[m] = Long.parseLong(paramltg[m].trim());
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
              if ((this.jdField_h_of_type_Int == 3) || (this.jdField_h_of_type_Int == 4)) {
                this.jdField_a_of_type_Lga.jdField_g_of_type_Long = this.jdField_a_of_type_Long;
              }
              if (QLog.isColorLevel()) {
                QLog.d("RandomController", 2, "[random room owner] mRelationType = " + this.jdField_d_of_type_Int);
              }
              this.jdField_a_of_type_Lga.E = this.jdField_d_of_type_Int;
              this.jdField_a_of_type_Lga.jdField_e_of_type_Boolean = false;
              this.jdField_a_of_type_Lga.jdField_a_of_type_Lgb.jdField_a_of_type_JavaLangString = null;
              this.jdField_a_of_type_Lga.jdField_a_of_type_Lgb.jdField_b_of_type_JavaLangString = null;
              this.jdField_a_of_type_Lga.jdField_a_of_type_Lgb.jdField_a_of_type_Boolean = false;
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
      catch (OutOfMemoryError paramltg)
      {
        for (;;)
        {
          paramltg = localNumberFormatException;
        }
      }
      catch (Exception paramltg)
      {
        for (;;)
        {
          paramltg = localNumberFormatException;
          continue;
          label1316:
          paramltg = null;
        }
      }
    }
  }
  
  private void b(ltg paramltg)
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    if (this.jdField_a_of_type_Int == -3) {
      return;
    }
    PopupDialog.a();
    if (this.jdField_f_of_type_Int == 2) {
      axqy.b(null, "CliOper", "", "", "0X8005728", "0X8005728", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      this.jdField_a_of_type_Int = -3;
      localObject = this.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((lsz)((Iterator)localObject).next()).a();
      }
      if (this.jdField_f_of_type_Int == 1) {
        axqy.b(null, "CliOper", "", "", "0X8005726", "0X8005726", 0, 0, "", "", "", "");
      }
    }
    Object localObject = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getApplicationContext();
    this.jdField_i_of_type_Int = paramltg.jdField_e_of_type_Int;
    PopupDialog.b((Context)localObject, 230, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getString(2131696032), a(this.jdField_i_of_type_Int), 2131720783, 0, null, new lsx(this));
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
        axqy.b(null, "CliOper", "", "", "0X80053B3", "0X80053B3", 0, 0, "", "", "", "");
      }
      while (!this.jdField_a_of_type_Lga.j())
      {
        Context localContext = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getApplicationContext();
        PopupDialog.b(localContext, 230, null, localContext.getString(2131696034), 2131720736, 2131696140, new lsy(this), new lsu(this));
        this.jdField_i_of_type_Boolean = true;
        return;
        if (this.jdField_f_of_type_Int == 2) {
          axqy.b(null, "CliOper", "", "", "0X80053BF", "0X80053BF", 0, 0, "", "", "", "");
        }
      }
    }
  }
  
  public int a(String paramString)
  {
    int m = -1;
    if ((this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin().equals(paramString)) && (this.jdField_a_of_type_Lga.jdField_a_of_type_Lgb.jdField_d_of_type_Int != -1)) {
      m = this.jdField_a_of_type_Lga.jdField_a_of_type_Lgb.jdField_d_of_type_Int;
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
    if ((this.jdField_a_of_type_Mrv != null) && (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)) {
      this.jdField_a_of_type_Mrv.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, paramString);
    }
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("RandomController", 2, "start random matching");
    }
    this.jdField_a_of_type_Boolean = false;
    this.jdField_h_of_type_JavaLangString = null;
    if (this.jdField_a_of_type_Mrv == null)
    {
      this.jdField_a_of_type_Mrv = mrv.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
      this.jdField_a_of_type_Mrv.a(this.jdField_a_of_type_Mrx);
    }
    if (this.jdField_a_of_type_Lga == null)
    {
      this.jdField_b_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
      if (!lcx.a().a(this.jdField_b_of_type_JavaLangString)) {
        this.jdField_a_of_type_Lga = lcx.a().a(this.jdField_b_of_type_JavaLangString, false);
      }
    }
    if (this.jdField_a_of_type_Lga == null)
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
    if (this.jdField_a_of_type_Lga.jdField_a_of_type_Lgb.jdField_b_of_type_Int != 2) {
      this.jdField_a_of_type_Lga.jdField_a_of_type_Lgb.jdField_b_of_type_Int = 1;
    }
    if (this.jdField_f_of_type_Int == 1) {
      if (!this.jdField_a_of_type_ComTencentAvRandomRandomWebProtocol.a())
      {
        this.jdField_d_of_type_Boolean = true;
        if ((this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) && (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a() != null)) {
          this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_e_of_type_JavaLangRunnable, 2000L);
        }
        this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_a_of_type_Lga.jdField_a_of_type_Lgb.jdField_b_of_type_Int, 1, this.jdField_a_of_type_Lga.jdField_a_of_type_Lgb.jdField_d_of_type_JavaLangString);
      }
    }
    for (;;)
    {
      label271:
      if (this.jdField_a_of_type_Lga != null)
      {
        this.jdField_a_of_type_Lga.jdField_a_of_type_Lgb.jdField_d_of_type_Boolean = this.jdField_b_of_type_Boolean;
        this.jdField_a_of_type_Lga.jdField_a_of_type_Lgb.jdField_d_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
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
      this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_a_of_type_Lga.jdField_a_of_type_Lgb.jdField_b_of_type_Int, 3, this.jdField_a_of_type_Lga.jdField_a_of_type_Lgb.jdField_d_of_type_JavaLangString);
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
        if (this.jdField_a_of_type_Lga != null) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("RandomController", 2, "stop random matching mSessionInfo = null!");
      return;
      Object localObject = msp.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
      if (localObject != null) {
        ((msp)localObject).a(this.jdField_b_of_type_JavaLangString);
      }
      this.jdField_a_of_type_ComTencentAvVideoController.t();
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
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_ComTencentAvRandomRandomController$RequestFetchRunnable);
        localObject = this.jdField_a_of_type_Lga.jdField_d_of_type_JavaLangString;
        if ((this.jdField_d_of_type_JavaLangString != null) && (this.jdField_d_of_type_JavaLangString.equals(localObject)))
        {
          this.jdField_a_of_type_ComTencentAvVideoController.a((String)localObject, 223);
          this.jdField_a_of_type_ComTencentAvVideoController.b(223);
          if (this.jdField_a_of_type_Lga.y == -1) {
            this.jdField_a_of_type_Lga.y = 0;
          }
          this.jdField_a_of_type_Lga.s = true;
          this.jdField_a_of_type_Lga.jdField_g_of_type_Boolean = false;
          this.jdField_a_of_type_ComTencentAvVideoController.b((String)localObject, this.jdField_a_of_type_Lga.y);
        }
      }
      for (;;)
      {
        if (this.jdField_a_of_type_Mrv != null)
        {
          this.jdField_a_of_type_Mrv.a();
          this.jdField_a_of_type_Mrv = null;
        }
        this.jdField_a_of_type_Int = 4;
        lcx.a().a().jdField_a_of_type_Lgb.jdField_b_of_type_Int = 0;
        this.jdField_a_of_type_ComTencentAvVideoController.a(0, 0, null);
        localObject = this.jdField_a_of_type_JavaUtilList.iterator();
        while (((Iterator)localObject).hasNext()) {
          ((lsz)((Iterator)localObject).next()).a();
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
          this.jdField_a_of_type_Lga.jdField_a_of_type_Lgb.jdField_f_of_type_Boolean = false;
          this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_d_of_type_Int, this.jdField_a_of_type_Long, 90);
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("RandomController", 2, "stop random matching mSessionId = " + this.jdField_b_of_type_JavaLangString);
      }
      if ((this.jdField_d_of_type_JavaLangString != null) && (this.jdField_d_of_type_JavaLangString.equals(lcx.a().a().jdField_d_of_type_JavaLangString))) {
        lcx.a().a().b(0L);
      }
      lcx.a().a().a();
      lcx.a().a(-1042L, this.jdField_b_of_type_JavaLangString);
      this.jdField_a_of_type_Lga = null;
      this.jdField_b_of_type_JavaLangString = null;
      lze.a(0L, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp());
    } while (!QLog.isColorLevel());
    QLog.d("RandomController", 2, "stop random matching end");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.av.random.RandomController
 * JD-Core Version:    0.7.0.1
 */