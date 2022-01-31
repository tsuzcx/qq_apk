package com.tencent.biz.pubaccount.readinjoy.struct;

import android.content.SharedPreferences;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import cooperation.readinjoy.ReadInJoyHelper;
import lxo;
import lxp;

public class KandianOx210MsgInfo$Biu0x210Msg
{
  public int a;
  public long a;
  public long b = -1L;
  
  public KandianOx210MsgInfo$Biu0x210Msg()
  {
    this.jdField_a_of_type_Long = -1L;
    this.jdField_a_of_type_Int = -1;
  }
  
  public static Biu0x210Msg a()
  {
    Biu0x210Msg localBiu0x210Msg = new Biu0x210Msg();
    SharedPreferences localSharedPreferences = ReadInJoyHelper.a(ReadInJoyUtils.a(), true, false);
    localBiu0x210Msg.jdField_a_of_type_Long = localSharedPreferences.getLong("kandian_biu_0x210_seq", -1L);
    localBiu0x210Msg.b = localSharedPreferences.getLong("kandian_biu_0x210_uin", -1L);
    localBiu0x210Msg.jdField_a_of_type_Int = localSharedPreferences.getInt("kandian_biu_0x210_status", -1);
    return localBiu0x210Msg;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Int = 1;
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    ThreadManager.post(new lxo(this, paramQQAppInterface), 8, null, false);
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_Long != -1L) && (this.b != -1L) && (this.jdField_a_of_type_Int != -1);
  }
  
  public void b(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_Long = -1L;
    this.b = -1L;
    this.jdField_a_of_type_Int = -1;
    ThreadManager.post(new lxp(this, paramQQAppInterface), 8, null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.struct.KandianOx210MsgInfo.Biu0x210Msg
 * JD-Core Version:    0.7.0.1
 */