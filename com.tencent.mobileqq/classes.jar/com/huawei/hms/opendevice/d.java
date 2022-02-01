package com.huawei.hms.opendevice;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.secure.android.common.encrypt.utils.EncryptUtil;
import com.huawei.secure.android.common.encrypt.utils.RootKeyUtil;
import com.huawei.secure.android.common.encrypt.utils.WorkKeyCryptUtil;

public abstract class d
{
  private static RootKeyUtil a = null;
  
  private static RootKeyUtil a(Context paramContext, q paramq)
  {
    if (a == null)
    {
      if (TextUtils.isEmpty(paramq.b("Jarvis"))) {
        break label52;
      }
      a = RootKeyUtil.newInstance(paramq.b("CaptainA"), paramq.b("IronMan"), paramq.b("CaptainM"), paramq.b("SpokesMan"));
    }
    for (;;)
    {
      return a;
      label52:
      b(paramContext);
    }
  }
  
  private static String a()
  {
    return "2A57086C86EF54970C1E6EB37BFC72B1";
  }
  
  public static String a(Context paramContext)
  {
    q localq = new q(paramContext, "LocalAvengers");
    return WorkKeyCryptUtil.decryptWorkKey(localq.b("Jarvis"), a(paramContext, localq));
  }
  
  private static byte[] a(byte[] paramArrayOfByte)
  {
    int i = 0;
    byte[] arrayOfByte;
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
    {
      arrayOfByte = new byte[0];
      return arrayOfByte;
    }
    for (;;)
    {
      arrayOfByte = paramArrayOfByte;
      if (i >= paramArrayOfByte.length) {
        break;
      }
      paramArrayOfByte[i] = ((byte)(paramArrayOfByte[i] >> 2));
      i += 1;
    }
  }
  
  private static byte[] a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    int i = 0;
    Object localObject;
    if ((paramArrayOfByte1 == null) || (paramArrayOfByte2 == null) || (paramArrayOfByte1.length == 0) || (paramArrayOfByte2.length == 0))
    {
      localObject = new byte[0];
      return localObject;
    }
    int j = paramArrayOfByte1.length;
    if (j != paramArrayOfByte2.length) {
      return new byte[0];
    }
    byte[] arrayOfByte = new byte[j];
    for (;;)
    {
      localObject = arrayOfByte;
      if (i >= j) {
        break;
      }
      arrayOfByte[i] = ((byte)(paramArrayOfByte1[i] ^ paramArrayOfByte2[i]));
      i += 1;
    }
  }
  
  public static void b(Context paramContext)
  {
    paramContext = new q(paramContext, "LocalAvengers");
    if (!TextUtils.isEmpty(paramContext.b("Jarvis"))) {
      return;
    }
    Object localObject2 = EncryptUtil.generateSecureRandom(32);
    Object localObject3 = EncryptUtil.generateSecureRandom(32);
    Object localObject1 = EncryptUtil.generateSecureRandom(32);
    byte[] arrayOfByte = EncryptUtil.generateSecureRandom(32);
    localObject2 = b.a((byte[])localObject2);
    localObject3 = b.a((byte[])localObject3);
    localObject1 = b.a((byte[])localObject1);
    a = RootKeyUtil.newInstance((String)localObject2, (String)localObject3, (String)localObject1, arrayOfByte);
    paramContext.a("CaptainA", (String)localObject2);
    paramContext.a("IronMan", (String)localObject3);
    paramContext.a("CaptainM", (String)localObject1);
    paramContext.a("SpokesMan", b.a(arrayOfByte));
    paramContext.a("Jarvis", WorkKeyCryptUtil.encryptWorkKey(b.a(EncryptUtil.generateSecureRandom(32)), a));
  }
  
  public static byte[] c(Context paramContext)
  {
    byte[] arrayOfByte1 = b.a(paramContext.getString(2131695046));
    paramContext = b.a(paramContext.getString(2131695045));
    byte[] arrayOfByte2 = b.a(a());
    return a(a(a(arrayOfByte1, paramContext), arrayOfByte2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.huawei.hms.opendevice.d
 * JD-Core Version:    0.7.0.1
 */