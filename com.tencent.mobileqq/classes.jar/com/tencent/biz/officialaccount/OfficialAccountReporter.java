package com.tencent.biz.officialaccount;

import android.os.SystemClock;
import com.tencent.beacon.event.UserAction;
import com.tencent.beacon.upload.TunnelInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.HashSet;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/officialaccount/OfficialAccountReporter;", "", "()V", "Reporter", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class OfficialAccountReporter
{
  public static final OfficialAccountReporter.Reporter a = new OfficialAccountReporter.Reporter(null);
  private static long b;
  private static long c;
  private static int d;
  private static int e;
  private static long f = SystemClock.elapsedRealtime();
  private static String g;
  private static final HashMap<Integer, Long> h = new HashMap();
  private static long i;
  private static final HashSet<Integer> j = new HashSet();
  private static long k;
  
  static
  {
    QLog.e("OfficialAccountReporter", 2, "OfficialAccountReporter.init: false");
    UserAction.registerTunnel(new TunnelInfo("00000KCQ7Y3ITP3Z"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.officialaccount.OfficialAccountReporter
 * JD-Core Version:    0.7.0.1
 */