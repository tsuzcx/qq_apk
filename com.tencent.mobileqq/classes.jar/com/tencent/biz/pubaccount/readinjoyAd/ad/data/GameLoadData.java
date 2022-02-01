package com.tencent.biz.pubaccount.readinjoyAd.ad.data;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;

public class GameLoadData
{
  public AdvertisementInfo a;
  public String b;
  public long c;
  public long d;
  public long e;
  public long f;
  public boolean g;
  
  public void a(Bundle paramBundle)
  {
    if (paramBundle != null)
    {
      String str = paramBundle.getString("adid", "");
      long l1 = paramBundle.getLong("navigationStart", 0L);
      long l2 = paramBundle.getLong("htmlLoaded", 0L);
      long l3 = paramBundle.getLong("domComplete", 0L);
      if ((!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty(this.b)))
      {
        if (!str.equals(this.b)) {
          return;
        }
        if (l1 > 0L) {
          this.d = l1;
        }
        if (l2 > 0L) {
          this.e = l2;
        }
        if (l3 > 0L) {
          this.f = l3;
        }
      }
    }
  }
  
  public boolean a()
  {
    return (this.a != null) && (!TextUtils.isEmpty(this.b)) && (this.c > 0L) && ((this.d > 0L) || (this.e > 0L) || (this.f > 0L));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.data.GameLoadData
 * JD-Core Version:    0.7.0.1
 */