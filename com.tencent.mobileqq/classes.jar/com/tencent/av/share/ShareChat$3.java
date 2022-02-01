package com.tencent.av.share;

import android.content.Context;
import android.graphics.Bitmap;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.troop.data.TroopInfoData;
import java.lang.ref.WeakReference;

final class ShareChat$3
  implements ShareChat.SharePanel.IHandle
{
  ShareChat$3(String paramString1, QQAppInterface paramQQAppInterface, String paramString2, int paramInt, long paramLong, WeakReference paramWeakReference) {}
  
  public int a()
  {
    return this.d;
  }
  
  public Bitmap a(long paramLong)
  {
    return this.b.getTroopFaceBitmap(this.c, (byte)3, false, false);
  }
  
  public String a(int paramInt)
  {
    return "0X800A3E4";
  }
  
  public String a(long paramLong, int paramInt)
  {
    return this.a;
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt3 == 2) {
      ShareChatReport.a(paramInt1, paramInt2, this.d, this.c);
    }
    ShareChat.a(this.e, (Context)this.f.get());
  }
  
  public long b()
  {
    return 0L;
  }
  
  public void b(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt3 == 2) {
      ShareChatReport.a(paramInt1, paramInt2, this.d, this.c);
    }
  }
  
  public int c()
  {
    return 0;
  }
  
  public String d()
  {
    return ShareChat.b(this.b, this.c);
  }
  
  public String e()
  {
    return ShareChat.a(this.c);
  }
  
  public TroopInfoData f()
  {
    TroopInfoData localTroopInfoData = new TroopInfoData();
    localTroopInfoData.troopUin = this.c;
    localTroopInfoData.updateForTroopInfo(((TroopManager)this.b.getManager(QQManagerFactory.TROOP_MANAGER)).g(this.c), this.b.getCurrentAccountUin());
    return localTroopInfoData;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.av.share.ShareChat.3
 * JD-Core Version:    0.7.0.1
 */