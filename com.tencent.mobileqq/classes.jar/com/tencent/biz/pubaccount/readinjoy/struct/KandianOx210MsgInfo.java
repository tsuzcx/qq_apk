package com.tencent.biz.pubaccount.readinjoy.struct;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.util.QLog;
import cooperation.readinjoy.ReadInJoyHelper;
import mbc;
import mbd;
import mbe;
import mbf;
import mbg;
import mbh;
import mbi;
import mbj;
import mqq.os.MqqHandler;
import tencent.im.s2c.msgtype0x210.submsgtype0xc5.submsgtype0xc5.BBInfo;
import tencent.im.s2c.msgtype0x210.submsgtype0xc5.submsgtype0xc5.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0xc5.submsgtype0xc5.NotifyBody;
import tencent.im.s2c.msgtype0x210.submsgtype0xc5.submsgtype0xc5.StyleSheet;
import tencent.im.s2c.msgtype0x210.submsgtype0xc5.submsgtype0xc5.TipsBody;

public class KandianOx210MsgInfo
{
  public static int j = -1;
  public static int k = j + 1;
  public static int l = k + 1;
  public static int m = -1;
  public static int n = m + 1;
  public static int o = n + 1;
  public int a;
  public long a;
  public String a;
  private byte[] a;
  public int b;
  public long b;
  public String b;
  public int c;
  public long c;
  public String c;
  public int d;
  public long d;
  public String d;
  public int e;
  public long e;
  public String e;
  public int f;
  public String f;
  public int g;
  public String g;
  public int h;
  public int i;
  
  public KandianOx210MsgInfo()
  {
    this.jdField_a_of_type_Int = 1;
  }
  
  public static int a(byte[] paramArrayOfByte)
  {
    int i1 = j;
    for (;;)
    {
      try
      {
        submsgtype0xc5.MsgBody localMsgBody = new submsgtype0xc5.MsgBody();
        localMsgBody.mergeFrom(paramArrayOfByte);
        if ((localMsgBody.msg_notify_infos.has()) && (localMsgBody.msg_notify_infos.get() != null) && (((submsgtype0xc5.NotifyBody)localMsgBody.msg_notify_infos.get()).msg_style_sheet.has()) && (((submsgtype0xc5.NotifyBody)localMsgBody.msg_notify_infos.get()).msg_style_sheet.get() != null) && (((submsgtype0xc5.StyleSheet)((submsgtype0xc5.NotifyBody)localMsgBody.msg_notify_infos.get()).msg_style_sheet.get()).msg_type.has()))
        {
          i2 = ((submsgtype0xc5.StyleSheet)((submsgtype0xc5.NotifyBody)localMsgBody.msg_notify_infos.get()).msg_style_sheet.get()).msg_type.get();
          switch (i2)
          {
          }
        }
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        int i2;
        paramArrayOfByte.printStackTrace();
        continue;
      }
      if (QLog.isColorLevel()) {
        QLog.d("KandianOx210MsgInfo", 2, "get0x210MsgType = " + i1);
      }
      return i1;
      i2 = k;
      i1 = i2;
      continue;
      i2 = l;
      i1 = i2;
      continue;
      i2 = k;
      i1 = i2;
      continue;
      i2 = k;
      i1 = i2;
    }
  }
  
  public static KandianOx210MsgInfo a()
  {
    SharedPreferences localSharedPreferences = ReadInJoyHelper.a(ReadInJoyUtils.a(), true, false);
    return a(a(localSharedPreferences.getString("kandian_push_ox210_msg", ""), localSharedPreferences.getInt("kandian_push_ox210_c5_msg_count", 1)));
  }
  
  private static KandianOx210MsgInfo a(KandianOx210MsgInfo paramKandianOx210MsgInfo)
  {
    SharedPreferences localSharedPreferences = ReadInJoyHelper.a(ReadInJoyUtils.a(), true, false);
    if ((localSharedPreferences == null) || (paramKandianOx210MsgInfo == null)) {
      return paramKandianOx210MsgInfo;
    }
    paramKandianOx210MsgInfo.jdField_d_of_type_Long = localSharedPreferences.getLong("kandian_push_0x210_c5_msg_time", 0L);
    return paramKandianOx210MsgInfo;
  }
  
  private static KandianOx210MsgInfo a(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    return a(PkgTools.a(paramString), paramInt);
  }
  
  public static KandianOx210MsgInfo a(byte[] paramArrayOfByte)
  {
    return a(paramArrayOfByte, 1);
  }
  
  public static KandianOx210MsgInfo a(byte[] paramArrayOfByte, int paramInt)
  {
    int i1 = 0;
    KandianOx210MsgInfo localKandianOx210MsgInfo = new KandianOx210MsgInfo();
    for (;;)
    {
      try
      {
        submsgtype0xc5.MsgBody localMsgBody = new submsgtype0xc5.MsgBody();
        localMsgBody.mergeFrom(paramArrayOfByte);
        localKandianOx210MsgInfo.jdField_a_of_type_Int = paramInt;
        localKandianOx210MsgInfo.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
        localKandianOx210MsgInfo.jdField_b_of_type_Int = localMsgBody.uint32_source.get();
        if (QLog.isColorLevel()) {
          QLog.d("KandianOx210MsgInfo", 2, "receive push 0xc5, bid = " + localKandianOx210MsgInfo.jdField_b_of_type_Int);
        }
        localKandianOx210MsgInfo.jdField_c_of_type_Int = localMsgBody.uint32_bid.get();
        if (QLog.isColorLevel()) {
          QLog.d("KandianOx210MsgInfo", 2, "receive push 0xc5, realbid = " + localKandianOx210MsgInfo.jdField_c_of_type_Int);
        }
        localKandianOx210MsgInfo.jdField_a_of_type_Long = localMsgBody.uint64_article_id.get();
        localKandianOx210MsgInfo.jdField_b_of_type_Long = localMsgBody.uint64_seq.get();
        if (localMsgBody.bytes_diandian_cookie.has()) {
          localKandianOx210MsgInfo.jdField_c_of_type_JavaLangString = localMsgBody.bytes_diandian_cookie.get().toStringUtf8();
        }
        if ((localMsgBody.msg_notify_infos.has()) && (localMsgBody.msg_notify_infos.get() != null) && (((submsgtype0xc5.NotifyBody)localMsgBody.msg_notify_infos.get()).msg_style_sheet.has()) && (((submsgtype0xc5.NotifyBody)localMsgBody.msg_notify_infos.get()).msg_style_sheet.get() != null))
        {
          submsgtype0xc5.StyleSheet localStyleSheet = (submsgtype0xc5.StyleSheet)((submsgtype0xc5.NotifyBody)localMsgBody.msg_notify_infos.get()).msg_style_sheet.get();
          if (!localStyleSheet.uint32_show_folder.has()) {
            break label920;
          }
          paramInt = localStyleSheet.uint32_show_folder.get();
          localKandianOx210MsgInfo.jdField_e_of_type_Int = paramInt;
          if (!localStyleSheet.folder_red_type.has()) {
            break label925;
          }
          paramInt = localStyleSheet.folder_red_type.get();
          localKandianOx210MsgInfo.jdField_g_of_type_Int = paramInt;
          if (!localStyleSheet.bytes_orange_word.has()) {
            break label930;
          }
          paramArrayOfByte = localStyleSheet.bytes_orange_word.get().toStringUtf8();
          localKandianOx210MsgInfo.jdField_a_of_type_JavaLangString = paramArrayOfByte;
          if (!localStyleSheet.bytes_summary.has()) {
            break label935;
          }
          paramArrayOfByte = localStyleSheet.bytes_summary.get().toStringUtf8();
          localKandianOx210MsgInfo.jdField_b_of_type_JavaLangString = paramArrayOfByte;
          if ((((submsgtype0xc5.StyleSheet)localStyleSheet.get()).msg_tip_body.has()) && (((submsgtype0xc5.StyleSheet)localStyleSheet.get()).msg_tip_body.get() != null))
          {
            submsgtype0xc5.TipsBody localTipsBody = (submsgtype0xc5.TipsBody)((submsgtype0xc5.StyleSheet)localStyleSheet.get()).msg_tip_body.get();
            if (localStyleSheet.uint32_show_lock_screen.has())
            {
              paramInt = localStyleSheet.uint32_show_lock_screen.get();
              localKandianOx210MsgInfo.jdField_f_of_type_Int = paramInt;
              paramInt = i1;
              if (localTipsBody.tips_ui_type.has()) {
                paramInt = localStyleSheet.msg_tip_body.tips_ui_type.get();
              }
              localKandianOx210MsgInfo.h = paramInt;
              if (localTipsBody.uint64_uin.has())
              {
                l1 = localStyleSheet.msg_tip_body.uint64_uin.get();
                localKandianOx210MsgInfo.jdField_e_of_type_Long = l1;
                if (!localTipsBody.bytes_icon_url.has()) {
                  continue;
                }
                paramArrayOfByte = localStyleSheet.msg_tip_body.bytes_icon_url.get().toStringUtf8();
                localKandianOx210MsgInfo.jdField_e_of_type_JavaLangString = paramArrayOfByte;
                if (!localTipsBody.bytes_content.has()) {
                  continue;
                }
                paramArrayOfByte = localStyleSheet.msg_tip_body.bytes_content.get().toStringUtf8();
                localKandianOx210MsgInfo.jdField_d_of_type_JavaLangString = paramArrayOfByte;
                if (!localTipsBody.bytes_schema.has()) {
                  continue;
                }
                paramArrayOfByte = localStyleSheet.msg_tip_body.bytes_schema.get().toStringUtf8();
                localKandianOx210MsgInfo.jdField_f_of_type_JavaLangString = paramArrayOfByte;
                if (!localTipsBody.bytes_business_info.has()) {
                  continue;
                }
                paramArrayOfByte = localStyleSheet.msg_tip_body.bytes_business_info.get().toStringUtf8();
                localKandianOx210MsgInfo.jdField_g_of_type_JavaLangString = paramArrayOfByte;
                if ((localMsgBody.msg_notify_infos.has()) && (localMsgBody.msg_notify_infos.get() != null) && (((submsgtype0xc5.NotifyBody)localMsgBody.msg_notify_infos.get()).msg_style_sheet.has()) && (((submsgtype0xc5.NotifyBody)localMsgBody.msg_notify_infos.get()).msg_style_sheet.get() != null) && (((submsgtype0xc5.StyleSheet)((submsgtype0xc5.NotifyBody)localMsgBody.msg_notify_infos.get()).msg_style_sheet.get()).msg_type.has())) {
                  localKandianOx210MsgInfo.i = ((submsgtype0xc5.StyleSheet)((submsgtype0xc5.NotifyBody)localMsgBody.msg_notify_infos.get()).msg_style_sheet.get()).msg_type.get();
                }
                if ((((submsgtype0xc5.NotifyBody)localMsgBody.msg_notify_infos.get()).msg_bb_info.has()) && (((submsgtype0xc5.NotifyBody)localMsgBody.msg_notify_infos.get()).msg_bb_info.get() != null))
                {
                  paramArrayOfByte = (submsgtype0xc5.BBInfo)((submsgtype0xc5.NotifyBody)localMsgBody.msg_notify_infos.get()).msg_bb_info.get();
                  localKandianOx210MsgInfo.jdField_c_of_type_Long = paramArrayOfByte.uint64_bb_uin.get();
                  localKandianOx210MsgInfo.jdField_d_of_type_Int = paramArrayOfByte.uint32_src.get();
                }
                return localKandianOx210MsgInfo;
              }
            }
            else
            {
              paramInt = 0;
              continue;
            }
            long l1 = -1L;
            continue;
            paramArrayOfByte = null;
            continue;
            paramArrayOfByte = null;
            continue;
            paramArrayOfByte = null;
            continue;
            paramArrayOfByte = null;
            continue;
          }
        }
        else
        {
          return null;
        }
      }
      catch (Exception paramArrayOfByte)
      {
        if (QLog.isColorLevel()) {
          QLog.w("KandianOx210MsgInfo", 2, "receive push 0xc5, parse msgBody err,", paramArrayOfByte);
        }
        return null;
      }
      return null;
      label920:
      paramInt = 0;
      continue;
      label925:
      paramInt = 0;
      continue;
      label930:
      paramArrayOfByte = null;
      continue;
      label935:
      paramArrayOfByte = null;
    }
  }
  
  public static int b(byte[] paramArrayOfByte)
  {
    int i1 = m;
    for (;;)
    {
      try
      {
        submsgtype0xc5.MsgBody localMsgBody = new submsgtype0xc5.MsgBody();
        localMsgBody.mergeFrom(paramArrayOfByte);
        if ((localMsgBody.msg_notify_infos.has()) && (localMsgBody.msg_notify_infos.get() != null) && (((submsgtype0xc5.NotifyBody)localMsgBody.msg_notify_infos.get()).msg_style_sheet.has()) && (((submsgtype0xc5.NotifyBody)localMsgBody.msg_notify_infos.get()).msg_style_sheet.get() != null) && (((submsgtype0xc5.StyleSheet)((submsgtype0xc5.NotifyBody)localMsgBody.msg_notify_infos.get()).msg_style_sheet.get()).msg_type.has()))
        {
          i2 = ((submsgtype0xc5.StyleSheet)((submsgtype0xc5.NotifyBody)localMsgBody.msg_notify_infos.get()).msg_style_sheet.get()).msg_type.get();
          switch (i2)
          {
          }
        }
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        int i2;
        paramArrayOfByte.printStackTrace();
        continue;
      }
      if (QLog.isColorLevel()) {
        QLog.d("KandianOx210MsgInfo", 2, "get0x210MsgType = " + i1);
      }
      return i1;
      i2 = n;
      i1 = i2;
      continue;
      i2 = n;
      i1 = i2;
      continue;
      i2 = o;
      i1 = i2;
    }
  }
  
  public static KandianOx210MsgInfo b()
  {
    return a(a(ReadInJoyHelper.a(ReadInJoyUtils.a(), true, false).getString("kandian_push_0x210_msg_for_follow", ""), 1));
  }
  
  public static int c(byte[] paramArrayOfByte)
  {
    try
    {
      submsgtype0xc5.MsgBody localMsgBody = new submsgtype0xc5.MsgBody();
      localMsgBody.mergeFrom(paramArrayOfByte);
      if (!localMsgBody.uint32_bid.has()) {
        break label85;
      }
      int i2 = localMsgBody.uint32_bid.get();
      if (i2 <= 2)
      {
        i1 = i2;
        if (i2 >= 1) {}
      }
      else
      {
        i1 = 0;
      }
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      for (;;)
      {
        paramArrayOfByte.printStackTrace();
        label85:
        int i1 = 0;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("KandianOx210MsgInfo", 2, "get0x210MsgBID = " + i1);
    }
    return i1;
  }
  
  public static KandianOx210MsgInfo c()
  {
    return a(a(ReadInJoyHelper.a(ReadInJoyUtils.a(), true, false).getString("kandian_push_0x210_msg_for_follow_show_in_folder", ""), 1));
  }
  
  public static KandianOx210MsgInfo d()
  {
    SharedPreferences localSharedPreferences = ReadInJoyHelper.a(ReadInJoyUtils.a(), true, false);
    return a(a(localSharedPreferences.getString("kandian_push_0x210_msg_sys", ""), localSharedPreferences.getInt("kandian_push_0x210_msg_sys_count", 1)));
  }
  
  public String a()
  {
    return PkgTools.a(this.jdField_a_of_type_ArrayOfByte);
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    ThreadManager.getSubThreadHandler().post(new mbc(this, paramQQAppInterface));
  }
  
  public void b(QQAppInterface paramQQAppInterface)
  {
    ThreadManager.getSubThreadHandler().post(new mbd(this, paramQQAppInterface));
  }
  
  public void c(QQAppInterface paramQQAppInterface)
  {
    ThreadManager.getSubThreadHandler().post(new mbe(this, paramQQAppInterface));
  }
  
  public void d(QQAppInterface paramQQAppInterface)
  {
    ThreadManager.getSubThreadHandler().post(new mbf(this, paramQQAppInterface));
  }
  
  public void e(QQAppInterface paramQQAppInterface)
  {
    ThreadManager.getSubThreadHandler().post(new mbg(this, paramQQAppInterface));
  }
  
  public void f(QQAppInterface paramQQAppInterface)
  {
    ThreadManager.getSubThreadHandler().post(new mbh(this, paramQQAppInterface));
  }
  
  public void g(QQAppInterface paramQQAppInterface)
  {
    ThreadManager.getSubThreadHandler().post(new mbi(this, paramQQAppInterface));
  }
  
  public void h(QQAppInterface paramQQAppInterface)
  {
    ThreadManager.getSubThreadHandler().post(new mbj(this, paramQQAppInterface));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.struct.KandianOx210MsgInfo
 * JD-Core Version:    0.7.0.1
 */