package com.tencent.av.random;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.text.TextUtils;
import bcst;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.utils.PopupDialog;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import lbu;
import lco;
import ley;
import lez;
import lsc;
import lsd;
import lse;
import lsg;
import lsh;
import lsi;
import lsj;
import lsp;
import lsq;
import lss;
import lyu;
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
  private List<lsi> jdField_a_of_type_JavaUtilList = new ArrayList();
  private AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  public ley a;
  private lsj jdField_a_of_type_Lsj = new lsc(this);
  private mrv jdField_a_of_type_Mrv;
  private mrx jdField_a_of_type_Mrx = new lse(this);
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
  private int j;
  private int k;
  
  private RandomController()
  {
    this.jdField_j_of_type_Int = 0;
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
    if ((!this.jdField_a_of_type_Ley.f()) && (!this.jdField_a_of_type_Ley.g()))
    {
      m = n;
      if (!this.jdField_a_of_type_Ley.j()) {}
    }
    else
    {
      if (this.jdField_g_of_type_Boolean) {
        break label147;
      }
      this.jdField_a_of_type_Ley.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_Ley.jdField_a_of_type_Lez.jdField_c_of_type_JavaLangString;
      m = this.jdField_a_of_type_ComTencentAvVideoController.a(0L, this.jdField_a_of_type_Ley.jdField_d_of_type_JavaLangString, 0, 4, this.jdField_a_of_type_Ley.i, this.jdField_a_of_type_Ley.jdField_j_of_type_JavaLangString, this.jdField_a_of_type_Ley.a(), this.jdField_c_of_type_Int, this.jdField_a_of_type_Ley.jdField_f_of_type_JavaLangString, this.jdField_a_of_type_Ley.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_Ley.jdField_a_of_type_ArrayOfByte, this.jdField_c_of_type_JavaLangString, null, 0, 0, null, null);
    }
    label147:
    do
    {
      do
      {
        return m;
        m = n;
      } while (!this.jdField_a_of_type_Ley.jdField_a_of_type_Lez.jdField_b_of_type_Boolean);
      m = n;
    } while (!TextUtils.equals(this.jdField_a_of_type_Ley.jdField_d_of_type_JavaLangString, this.jdField_a_of_type_Ley.jdField_a_of_type_Lez.jdField_c_of_type_JavaLangString));
    return this.jdField_a_of_type_ComTencentAvVideoController.a(0L, this.jdField_a_of_type_Ley.jdField_d_of_type_JavaLangString, 0, 4);
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
      String str = this.jdField_a_of_type_Ley.jdField_c_of_type_JavaLangString;
      this.jdField_b_of_type_JavaLangString = lbu.a(this.jdField_d_of_type_Int, String.valueOf(this.jdField_a_of_type_Long), new int[0]);
      lbu.a().a(str, this.jdField_b_of_type_JavaLangString);
      msp localmsp = msp.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
      if ((localmsp != null) && (localmsp.a())) {
        localmsp.a(str, this.jdField_b_of_type_JavaLangString);
      }
      this.jdField_a_of_type_Mrv.a(this.jdField_b_of_type_JavaLangString);
      n = this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_d_of_type_Int, this.jdField_a_of_type_Long, this.jdField_e_of_type_Int, this.jdField_a_of_type_Ley.jdField_a_of_type_ArrayOfLong, false);
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
    String str2 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getString(2131695075);
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
  
  private void a(lsp paramlsp)
  {
    Object localObject1 = null;
    this.jdField_c_of_type_Int = 1011;
    if ((paramlsp instanceof lsq)) {
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
      Object localObject2 = (lsq)paramlsp;
      a(((lsq)localObject2).jdField_b_of_type_JavaLangString, ((lsq)localObject2).jdField_c_of_type_JavaLangString, ((lsq)localObject2).jdField_a_of_type_ArrayOfByte, ((lsq)localObject2).jdField_e_of_type_JavaLangString, ((lsq)localObject2).jdField_a_of_type_AndroidGraphicsBitmap, ((lsq)localObject2).jdField_d_of_type_JavaLangString, ((lsq)localObject2).jdField_f_of_type_Int);
      this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_d_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_f_of_type_JavaLangString);
      do
      {
        localObject2 = this.jdField_a_of_type_Ley.jdField_c_of_type_JavaLangString;
        this.jdField_b_of_type_JavaLangString = lbu.a(3, this.jdField_d_of_type_JavaLangString, new int[0]);
        lbu.a().a((String)localObject2, this.jdField_b_of_type_JavaLangString);
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
        if ((this.jdField_a_of_type_Ley.jdField_j_of_type_Int != 1011) && (!TextUtils.equals(this.jdField_a_of_type_Ley.jdField_d_of_type_JavaLangString, this.jdField_d_of_type_JavaLangString)) && (this.jdField_a_of_type_Ley.jdField_a_of_type_Lez.jdField_b_of_type_Boolean))
        {
          this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_a_of_type_Ley.jdField_d_of_type_JavaLangString, 221);
          this.jdField_a_of_type_ComTencentAvVideoController.b(221);
        }
        if ((this.jdField_h_of_type_JavaLangString != null) && (!TextUtils.isEmpty(this.jdField_h_of_type_JavaLangString))) {
          this.jdField_a_of_type_Ley.jdField_a_of_type_Lez.jdField_e_of_type_JavaLangString = (this.jdField_a_of_type_ComTencentAvVideoController.a().getString(2131695091) + this.jdField_h_of_type_JavaLangString);
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
      } while (!(paramlsp instanceof lss));
      localObject2 = (lss)paramlsp;
      if (QLog.isColorLevel()) {
        QLog.d("RandomController", 2, "processWebProtocol RspMulti [random room owner]");
      }
      if (((lss)localObject2).jdField_f_of_type_Int > 0) {
        this.jdField_b_of_type_Boolean = true;
      }
      for (;;)
      {
        this.jdField_e_of_type_Int = ((lss)localObject2).jdField_g_of_type_Int;
        this.jdField_g_of_type_JavaLangString = ((lss)localObject2).jdField_c_of_type_JavaLangString;
        this.jdField_h_of_type_Boolean = ((lss)localObject2).jdField_a_of_type_Boolean;
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
        if (((lss)localObject2).jdField_f_of_type_Int == 0) {
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
        paramlsp = mqt.a(this.jdField_a_of_type_AndroidGraphicsBitmap, this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth() / 2);
        if (paramlsp != null) {
          this.jdField_a_of_type_Ley.jdField_a_of_type_Lez.jdField_a_of_type_AndroidGraphicsBitmap = paramlsp;
        }
        this.jdField_a_of_type_Ley.jdField_e_of_type_JavaLangString = this.jdField_e_of_type_JavaLangString;
        this.jdField_a_of_type_Ley.jdField_a_of_type_Lez.jdField_b_of_type_JavaLangString = this.jdField_e_of_type_JavaLangString;
        for (;;)
        {
          this.jdField_a_of_type_Ley.a(-1032L, "processWebProtocol", this.jdField_h_of_type_Int);
          this.jdField_a_of_type_Ley.jdField_j_of_type_Int = this.jdField_c_of_type_Int;
          this.jdField_a_of_type_Ley.S = true;
          this.jdField_a_of_type_Ley.jdField_a_of_type_ArrayOfByte = this.jdField_a_of_type_ArrayOfByte;
          this.jdField_a_of_type_Ley.N = false;
          this.jdField_a_of_type_Ley.jdField_f_of_type_Int = this.jdField_h_of_type_Int;
          this.jdField_a_of_type_Ley.jdField_a_of_type_Lez.jdField_c_of_type_JavaLangString = this.jdField_d_of_type_JavaLangString;
          if (QLog.isColorLevel()) {
            QLog.d("RandomController", 2, "processWebProtocol  uinType = " + this.jdField_c_of_type_Int + " # peerUin = " + this.jdField_d_of_type_JavaLangString + " # signature = " + this.jdField_a_of_type_ArrayOfByte + " # BeginSessionType = " + this.jdField_h_of_type_Int + " # nickName = " + this.jdField_e_of_type_JavaLangString + " # roomTopic = " + this.jdField_c_of_type_JavaLangString + " # topTips = " + this.jdField_h_of_type_JavaLangString + ", isMask: " + this.jdField_b_of_type_Boolean);
          }
          if ((this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) && (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a() != null)) {
            this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
          }
          PopupDialog.a();
          paramlsp = this.jdField_a_of_type_JavaUtilList.iterator();
          while (paramlsp.hasNext()) {
            ((lsi)paramlsp.next()).a();
          }
          bool = false;
          break label591;
          label948:
          a(this.jdField_d_of_type_JavaLangString);
          paramlsp = a(this.jdField_d_of_type_JavaLangString, false);
          if (paramlsp != null)
          {
            this.jdField_a_of_type_Ley.jdField_a_of_type_Lez.jdField_a_of_type_AndroidGraphicsBitmap = paramlsp;
            continue;
            label984:
            if (this.jdField_f_of_type_Int == 2)
            {
              this.jdField_h_of_type_Int = 3;
              this.jdField_d_of_type_Int = 7;
              this.k = 0;
              if (!(paramlsp instanceof lss)) {
                break label1316;
              }
              paramlsp = ((lss)paramlsp).jdField_b_of_type_JavaLangString;
              if ((paramlsp == null) || (paramlsp.equals(""))) {
                break;
              }
              paramlsp = paramlsp.split(",");
              this.jdField_a_of_type_ArrayOfLong = new long[paramlsp.length];
              int m = 0;
              for (;;)
              {
                if (m < paramlsp.length) {
                  try
                  {
                    this.jdField_a_of_type_ArrayOfLong[m] = Long.parseLong(paramlsp[m].trim());
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
                this.jdField_a_of_type_Ley.jdField_g_of_type_Long = this.jdField_a_of_type_Long;
              }
              if (QLog.isColorLevel()) {
                QLog.d("RandomController", 2, "[random room owner] mRelationType = " + this.jdField_d_of_type_Int);
              }
              this.jdField_a_of_type_Ley.F = this.jdField_d_of_type_Int;
              this.jdField_a_of_type_Ley.jdField_e_of_type_Boolean = false;
              this.jdField_a_of_type_Ley.jdField_a_of_type_Lez.jdField_a_of_type_JavaLangString = null;
              this.jdField_a_of_type_Ley.jdField_a_of_type_Lez.jdField_b_of_type_JavaLangString = null;
              this.jdField_a_of_type_Ley.jdField_a_of_type_Lez.jdField_a_of_type_Boolean = false;
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
      catch (OutOfMemoryError paramlsp)
      {
        for (;;)
        {
          paramlsp = localNumberFormatException;
        }
      }
      catch (Exception paramlsp)
      {
        for (;;)
        {
          paramlsp = localNumberFormatException;
          continue;
          label1316:
          paramlsp = null;
        }
      }
    }
  }
  
  private void b(lsp paramlsp)
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    if (this.jdField_a_of_type_Int == -3) {
      return;
    }
    PopupDialog.a();
    if (this.jdField_f_of_type_Int == 2) {
      bcst.b(null, "CliOper", "", "", "0X8005728", "0X8005728", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      this.jdField_a_of_type_Int = -3;
      localObject = this.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((lsi)((Iterator)localObject).next()).a();
      }
      if (this.jdField_f_of_type_Int == 1) {
        bcst.b(null, "CliOper", "", "", "0X8005726", "0X8005726", 0, 0, "", "", "", "");
      }
    }
    Object localObject = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getApplicationContext();
    this.jdField_i_of_type_Int = paramlsp.jdField_e_of_type_Int;
    PopupDialog.b((Context)localObject, 230, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getString(2131695076), a(this.jdField_i_of_type_Int), 2131719054, 0, null, new lsg(this));
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
        bcst.b(null, "CliOper", "", "", "0X80053B3", "0X80053B3", 0, 0, "", "", "", "");
      }
      while (!this.jdField_a_of_type_Ley.l())
      {
        Context localContext = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getApplicationContext();
        PopupDialog.b(localContext, 230, null, localContext.getString(2131695078), 2131719004, 2131695184, new lsh(this), new lsd(this));
        this.jdField_i_of_type_Boolean = true;
        return;
        if (this.jdField_f_of_type_Int == 2) {
          bcst.b(null, "CliOper", "", "", "0X80053BF", "0X80053BF", 0, 0, "", "", "", "");
        }
      }
    }
  }
  
  public int a(String paramString)
  {
    int m = -1;
    if ((this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin().equals(paramString)) && (this.jdField_a_of_type_Ley.jdField_a_of_type_Lez.jdField_d_of_type_Int != -1)) {
      m = this.jdField_a_of_type_Ley.jdField_a_of_type_Lez.jdField_d_of_type_Int;
    }
    do
    {
      return m;
      paramString = this.jdField_a_of_type_ComTencentAvVideoController.a(paramString);
    } while (paramString == null);
    return paramString.jdField_c_of_type_Int;
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
    if (this.jdField_a_of_type_Ley == null)
    {
      this.jdField_b_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
      if (!lbu.a().a(this.jdField_b_of_type_JavaLangString)) {
        this.jdField_a_of_type_Ley = lbu.a().a(this.jdField_b_of_type_JavaLangString, false);
      }
    }
    if (this.jdField_a_of_type_Ley == null)
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
    if (this.jdField_a_of_type_Ley.jdField_a_of_type_Lez.jdField_b_of_type_Int != 2) {
      this.jdField_a_of_type_Ley.jdField_a_of_type_Lez.jdField_b_of_type_Int = 1;
    }
    if (this.jdField_f_of_type_Int == 1) {
      if (!this.jdField_a_of_type_ComTencentAvRandomRandomWebProtocol.a())
      {
        this.jdField_d_of_type_Boolean = true;
        if ((this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) && (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a() != null)) {
          this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_e_of_type_JavaLangRunnable, 2000L);
        }
        this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_a_of_type_Ley.jdField_a_of_type_Lez.jdField_b_of_type_Int, 1, this.jdField_a_of_type_Ley.jdField_a_of_type_Lez.jdField_d_of_type_JavaLangString);
      }
    }
    for (;;)
    {
      label271:
      if (this.jdField_a_of_type_Ley != null)
      {
        this.jdField_a_of_type_Ley.jdField_a_of_type_Lez.jdField_d_of_type_Boolean = this.jdField_b_of_type_Boolean;
        this.jdField_a_of_type_Ley.jdField_a_of_type_Lez.jdField_d_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
        return;
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(0);
        this.jdField_a_of_type_ComTencentAvRandomRandomWebProtocol.a(this.jdField_g_of_type_Int, this.jdField_j_of_type_Int, 1, new String[0]);
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
      this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_a_of_type_Ley.jdField_a_of_type_Lez.jdField_b_of_type_Int, 3, this.jdField_a_of_type_Ley.jdField_a_of_type_Lez.jdField_d_of_type_JavaLangString);
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
        if (this.jdField_a_of_type_Ley != null) {
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
        localObject = this.jdField_a_of_type_Ley.jdField_d_of_type_JavaLangString;
        if ((this.jdField_d_of_type_JavaLangString != null) && (this.jdField_d_of_type_JavaLangString.equals(localObject)))
        {
          this.jdField_a_of_type_ComTencentAvVideoController.a((String)localObject, 223);
          this.jdField_a_of_type_ComTencentAvVideoController.b(223);
          if (this.jdField_a_of_type_Ley.z == -1) {
            this.jdField_a_of_type_Ley.z = 0;
          }
          this.jdField_a_of_type_Ley.t = true;
          this.jdField_a_of_type_Ley.jdField_g_of_type_Boolean = false;
          this.jdField_a_of_type_ComTencentAvVideoController.b((String)localObject, this.jdField_a_of_type_Ley.z);
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
        lbu.a().a().jdField_a_of_type_Lez.jdField_b_of_type_Int = 0;
        this.jdField_a_of_type_ComTencentAvVideoController.a(0, 0, null);
        localObject = this.jdField_a_of_type_JavaUtilList.iterator();
        while (((Iterator)localObject).hasNext()) {
          ((lsi)((Iterator)localObject).next()).a();
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
          this.jdField_a_of_type_Ley.jdField_a_of_type_Lez.jdField_f_of_type_Boolean = false;
          this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_d_of_type_Int, this.jdField_a_of_type_Long, 90);
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("RandomController", 2, "stop random matching mSessionId = " + this.jdField_b_of_type_JavaLangString);
      }
      if ((this.jdField_d_of_type_JavaLangString != null) && (this.jdField_d_of_type_JavaLangString.equals(lbu.a().a().jdField_d_of_type_JavaLangString))) {
        lbu.a().a().b(0L);
      }
      lbu.a().a().a();
      lbu.a().a(-1042L, this.jdField_b_of_type_JavaLangString);
      this.jdField_a_of_type_Ley = null;
      this.jdField_b_of_type_JavaLangString = null;
      lyu.a(0L, 4, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp());
    } while (!QLog.isColorLevel());
    QLog.d("RandomController", 2, "stop random matching end");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.random.RandomController
 * JD-Core Version:    0.7.0.1
 */