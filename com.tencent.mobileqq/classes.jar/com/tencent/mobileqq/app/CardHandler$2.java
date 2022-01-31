package com.tencent.mobileqq.app;

import ajfi;
import ajfw;
import ajjj;
import android.os.Bundle;
import azyf;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class CardHandler$2
  implements Runnable
{
  public CardHandler$2(ajfi paramajfi, Bundle paramBundle) {}
  
  public void run()
  {
    oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
    localOIDBSSOPkg.uint32_command.set(1279);
    localOIDBSSOPkg.uint32_result.set(0);
    localOIDBSSOPkg.uint32_service_type.set(9);
    Object localObject2 = ((ajjj)this.this$0.app.getManager(51)).c(this.this$0.app.getCurrentAccountUin());
    int j = 0;
    int i = 0;
    long l2 = 0L;
    Object localObject1 = ByteBuffer.allocate(1000);
    if (this.a.containsKey("nick"))
    {
      l1 = 0L | 1L;
      k = 1;
      n = this.a.getString("nick").getBytes().length;
      m = 0 + (n + 4);
      ((ByteBuffer)localObject1).putShort((short)20002);
      ((ByteBuffer)localObject1).putShort((short)this.a.getString("nick").getBytes().length);
      ((ByteBuffer)localObject1).put(this.a.getString("nick").getBytes());
      l2 = l1;
      i = m;
      j = k;
      if (QLog.isColorLevel())
      {
        QLog.d("CardHandler", 2, "set nick | length = " + n + " | nick = " + this.a.getString("nick"));
        j = k;
        i = m;
        l2 = l1;
      }
    }
    long l1 = l2;
    int k = i;
    int m = j;
    if (this.a.containsKey("sex"))
    {
      l2 |= 0x2;
      j += 1;
      i += 5;
      ((ByteBuffer)localObject1).putShort((short)20009);
      ((ByteBuffer)localObject1).putShort((short)1);
      ((ByteBuffer)localObject1).put((byte)(this.a.getByte("sex") + 1));
      l1 = l2;
      k = i;
      m = j;
      if (QLog.isColorLevel())
      {
        QLog.d("CardHandler", 2, "set sex | sex = " + this.a.getByte("sex"));
        m = j;
        k = i;
        l1 = l2;
      }
    }
    l2 = l1;
    i = k;
    j = m;
    if (this.a.containsKey("birthday"))
    {
      l1 |= 0x4;
      m += 1;
      k += 8;
      ((ByteBuffer)localObject1).putShort((short)26003);
      ((ByteBuffer)localObject1).putShort((short)4);
      ((ByteBuffer)localObject1).putInt(this.a.getInt("birthday"));
      l2 = l1;
      i = k;
      j = m;
      if (QLog.isColorLevel())
      {
        QLog.d("CardHandler", 2, "set birthday | birthday = " + this.a.getInt("birthday") + " | age = " + this.a.getInt("age"));
        j = m;
        i = k;
        l2 = l1;
      }
    }
    l1 = l2;
    k = i;
    int n = j;
    if (this.a.containsKey("profession"))
    {
      l2 |= 0x20;
      k = this.a.getInt("profession");
      int i1 = i;
      m = j;
      if (azyf.a(k))
      {
        m = j + 1;
        i1 = i + 8;
        ((ByteBuffer)localObject1).putShort((short)27037);
        ((ByteBuffer)localObject1).putShort((short)4);
        ((ByteBuffer)localObject1).putInt(k);
      }
      l1 = l2;
      k = i1;
      n = m;
      if (QLog.isColorLevel())
      {
        QLog.d("CardHandler", 2, "set profession | profession = " + this.a.getInt("profession"));
        n = m;
        k = i1;
        l1 = l2;
      }
    }
    l2 = l1;
    i = k;
    m = n;
    if (this.a.containsKey("company"))
    {
      l1 |= 0x40;
      j = n + 1;
      n = this.a.getString("company").getBytes().length;
      k += n + 4;
      ((ByteBuffer)localObject1).putShort((short)24008);
      ((ByteBuffer)localObject1).putShort((short)n);
      ((ByteBuffer)localObject1).put(this.a.getString("company").getBytes());
      l2 = l1;
      i = k;
      m = j;
      if (QLog.isColorLevel())
      {
        QLog.d("CardHandler", 2, "set company | length = " + n + " | company = " + this.a.getString("company"));
        m = j;
        i = k;
        l2 = l1;
      }
    }
    l1 = l2;
    j = i;
    k = m;
    if (this.a.containsKey("college"))
    {
      l2 |= 0x80;
      m += 1;
      n = this.a.getString("college").getBytes().length;
      i += n + 4;
      ((ByteBuffer)localObject1).putShort((short)20021);
      ((ByteBuffer)localObject1).putShort((short)n);
      ((ByteBuffer)localObject1).put(this.a.getString("college").getBytes());
      l1 = l2;
      j = i;
      k = m;
      if (QLog.isColorLevel())
      {
        QLog.d("CardHandler", 2, "set college | length = " + n + " | college = " + this.a.getString("college"));
        k = m;
        j = i;
        l1 = l2;
      }
    }
    l2 = l1;
    i = j;
    m = k;
    String[] arrayOfString;
    if (this.a.containsKey("location"))
    {
      l1 |= 0x100;
      k += 2;
      j += 24;
      arrayOfString = this.a.getStringArray("location");
      ((ByteBuffer)localObject1).putShort((short)20032).putShort((short)12).putInt(ajfw.a(arrayOfString[0])).putInt(ajfw.a(arrayOfString[1])).putInt(ajfw.a(arrayOfString[2]));
      ((ByteBuffer)localObject1).putShort((short)20041).putShort((short)4).putInt(ajfw.a(arrayOfString[3]));
      l2 = l1;
      i = j;
      m = k;
      if (QLog.isColorLevel())
      {
        QLog.d("CardHandler", 2, "set location | location = " + arrayOfString.toString() + ", code one = " + arrayOfString[0]);
        m = k;
        i = j;
        l2 = l1;
      }
    }
    l1 = l2;
    j = i;
    n = m;
    if (this.a.containsKey("hometown"))
    {
      l2 |= 0x800;
      k = m + 2;
      i += 24;
      arrayOfString = this.a.getStringArray("hometown");
      ((ByteBuffer)localObject1).putShort((short)24002).putShort((short)12).putInt(ajfw.a(arrayOfString[0])).putInt(ajfw.a(arrayOfString[1])).putInt(ajfw.a(arrayOfString[2]));
      ((ByteBuffer)localObject1).putShort((short)20043).putShort((short)4).putInt(ajfw.a(arrayOfString[3]));
      l1 = l2;
      j = i;
      n = k;
      if (QLog.isColorLevel())
      {
        QLog.d("CardHandler", 2, "set hometown | hometown = " + arrayOfString.toString());
        n = k;
        j = i;
        l1 = l2;
      }
    }
    l2 = l1;
    i = j;
    k = n;
    if (this.a.containsKey("email"))
    {
      l1 |= 0x2000;
      m = n + 1;
      n = this.a.getString("email").getBytes().length;
      j += n + 4;
      ((ByteBuffer)localObject1).putShort((short)20011).putShort((short)n).put(this.a.getString("email").getBytes());
      l2 = l1;
      i = j;
      k = m;
      if (QLog.isColorLevel())
      {
        QLog.d("CardHandler", 2, "set email | length = " + n + " | email = " + this.a.getString("email"));
        k = m;
        i = j;
        l2 = l1;
      }
    }
    l1 = l2;
    j = i;
    m = k;
    if (this.a.containsKey("personalNote"))
    {
      l2 |= 0x4000;
      k += 1;
      n = this.a.getString("personalNote").getBytes().length;
      i += n + 4;
      ((ByteBuffer)localObject1).putShort((short)20019).putShort((short)n).put(this.a.getString("personalNote").getBytes());
      l1 = l2;
      j = i;
      m = k;
      if (QLog.isColorLevel())
      {
        QLog.d("CardHandler", 2, "set note | length = " + n + " | note = " + this.a.getString("personalNote"));
        m = k;
        j = i;
        l1 = l2;
      }
    }
    l2 = l1;
    i = j;
    k = m;
    if (this.a.containsKey("key_interest_switch"))
    {
      l1 |= 0x800000;
      m += 1;
      j += 6;
      ((ByteBuffer)localObject1).putShort((short)-25223);
      ((ByteBuffer)localObject1).putShort((short)2);
      ((ByteBuffer)localObject1).putShort(this.a.getShort("key_interest_switch"));
      l2 = l1;
      i = j;
      k = m;
      if (QLog.isColorLevel())
      {
        QLog.d("CardHandler", 2, "set interest_switch | length = 2 | interest_switch = " + this.a.getShort("key_interest_switch"));
        k = m;
        i = j;
        l2 = l1;
      }
    }
    l1 = l2;
    j = i;
    m = k;
    if (this.a.containsKey("key_music_switch"))
    {
      l2 |= 0x1000000;
      k += 1;
      i += 6;
      ((ByteBuffer)localObject1).putShort((short)-25222);
      ((ByteBuffer)localObject1).putShort((short)2);
      ((ByteBuffer)localObject1).putShort(this.a.getShort("key_music_switch"));
      l1 = l2;
      j = i;
      m = k;
      if (QLog.isColorLevel())
      {
        QLog.d("CardHandler", 2, "set music_switch | length = 2 | music_switch = " + this.a.getShort("key_music_switch"));
        m = k;
        j = i;
        l1 = l2;
      }
    }
    l2 = l1;
    i = j;
    k = m;
    if (this.a.containsKey("key_present_switch"))
    {
      l1 |= 0x10000000;
      m += 1;
      j += 6;
      ((ByteBuffer)localObject1).putShort((short)-23247);
      ((ByteBuffer)localObject1).putShort((short)2);
      ((ByteBuffer)localObject1).putShort(this.a.getShort("key_present_switch"));
      l2 = l1;
      i = j;
      k = m;
      if (QLog.isColorLevel())
      {
        QLog.d("CardHandler", 2, "set present_switch | length = 2 | present_switch = " + this.a.getShort("key_present_switch"));
        k = m;
        i = j;
        l2 = l1;
      }
    }
    l1 = l2;
    j = i;
    m = k;
    if (this.a.containsKey("key_personality_label_switch"))
    {
      l2 |= 0x4000000;
      k += 1;
      i += 6;
      ((ByteBuffer)localObject1).putShort((short)-23408);
      ((ByteBuffer)localObject1).putShort((short)2);
      ((ByteBuffer)localObject1).putShort(this.a.getShort("key_personality_label_switch"));
      l1 = l2;
      j = i;
      m = k;
      if (QLog.isColorLevel())
      {
        QLog.d("CardHandler", 2, "set now_switch | length = 2 | personality_label_switch = " + this.a.getShort("key_personality_label_switch"));
        m = k;
        j = i;
        l1 = l2;
      }
    }
    l2 = l1;
    i = j;
    k = m;
    if (this.a.containsKey("key_extend_friend_switch"))
    {
      l1 |= 0x8000000;
      m += 1;
      j += 6;
      ((ByteBuffer)localObject1).putShort((short)-23364);
      ((ByteBuffer)localObject1).putShort((short)2);
      ((ByteBuffer)localObject1).putShort(this.a.getShort("key_extend_friend_switch"));
      l2 = l1;
      i = j;
      k = m;
      if (QLog.isColorLevel())
      {
        QLog.d("CardHandler", 2, "set now_switch | length = 2 | extend_friend_switch = " + this.a.getShort("key_extend_friend_switch"));
        k = m;
        i = j;
        l2 = l1;
      }
    }
    l1 = l2;
    j = i;
    m = k;
    if (this.a.containsKey("key_miniapp_playing_switch"))
    {
      l2 |= 0x20000000;
      k += 1;
      i += 6;
      ((ByteBuffer)localObject1).putShort((short)-23213);
      ((ByteBuffer)localObject1).putShort((short)2);
      ((ByteBuffer)localObject1).putShort(this.a.getShort("key_miniapp_playing_switch"));
      l1 = l2;
      j = i;
      m = k;
      if (QLog.isColorLevel())
      {
        QLog.d("CardHandler", 2, "set now_switch | length = 2 | mini_app_playing = " + this.a.getShort("key_miniapp_playing_switch"));
        m = k;
        j = i;
        l1 = l2;
      }
    }
    l2 = l1;
    i = j;
    k = m;
    if (this.a.containsKey("key_musicbox_switch"))
    {
      l1 |= 0x40000000;
      m += 1;
      j += 6;
      ((ByteBuffer)localObject1).putShort((short)-23196);
      ((ByteBuffer)localObject1).putShort((short)2);
      ((ByteBuffer)localObject1).putShort(this.a.getShort("key_musicbox_switch"));
      l2 = l1;
      i = j;
      k = m;
      if (QLog.isColorLevel())
      {
        QLog.d("CardHandler", 2, "set now_switch | length = 2 | mini_app_playing = " + this.a.getShort("key_musicbox_switch"));
        k = m;
        i = j;
        l2 = l1;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("CardHandler", 2, "set detail card, field count = " + k);
    }
    if (k == 0)
    {
      this.this$0.notifyUI(31, true, new Object[] { Integer.valueOf(0), localObject2 });
      return;
    }
    localObject2 = ByteBuffer.allocate(i + 7);
    ((ByteBuffer)localObject2).putInt((int)Long.parseLong(this.this$0.app.getCurrentAccountUin()));
    ((ByteBuffer)localObject2).put((byte)0);
    ((ByteBuffer)localObject2).putShort((short)k);
    ((ByteBuffer)localObject2).put(((ByteBuffer)localObject1).array(), 0, i);
    localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((ByteBuffer)localObject2).array()));
    localObject1 = this.this$0.createToServiceMsg("OidbSvc.0x4ff_9");
    ((ToServiceMsg)localObject1).extraData.putAll(this.a);
    ((ToServiceMsg)localObject1).putWupBuffer(localOIDBSSOPkg.toByteArray());
    ((ToServiceMsg)localObject1).extraData.putBoolean("isSetLoginDays", false);
    ((ToServiceMsg)localObject1).extraData.putBoolean("reqFromCardHandler", true);
    ((ToServiceMsg)localObject1).extraData.putLong("fieldFlag", l2);
    ((ToServiceMsg)localObject1).setTimeout(20000L);
    this.this$0.sendPbReq((ToServiceMsg)localObject1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.CardHandler.2
 * JD-Core Version:    0.7.0.1
 */