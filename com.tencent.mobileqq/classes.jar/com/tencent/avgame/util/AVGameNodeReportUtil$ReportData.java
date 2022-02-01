package com.tencent.avgame.util;

import com.tencent.common.app.BaseApplicationImpl;
import java.io.Serializable;
import java.util.HashMap;
import mqq.app.AppRuntime;

public class AVGameNodeReportUtil$ReportData
  implements Serializable
{
  protected long createTime;
  protected int curNode;
  public int endCode;
  public int endNode;
  public boolean isAgain;
  protected long n1BeginTime;
  public long n1Cost;
  protected long n1EndTime;
  public int n1EnterGameRoomRetCode;
  public long n2AvEnterCost;
  protected long n2BeginTime;
  public long n2Cost;
  protected long n2EndTime;
  protected long n2EnterAvBeginTime;
  protected long n2EnterAvEndTime;
  protected long n3BeginTime;
  public long n3Cost;
  protected long n3EndTime;
  public int n3GameType;
  public int n3MemberCount;
  protected long n4BeginTime;
  public long n4Cost;
  protected long n4EndTime;
  protected long n5BeginTime;
  public long n5Cost;
  protected long n5EndTime;
  public String roomId = "";
  
  private void a()
  {
    if (this.n1BeginTime > 0L)
    {
      this.n1Cost = (System.currentTimeMillis() - this.n1BeginTime);
      return;
    }
    this.n1Cost = 0L;
  }
  
  private void b()
  {
    if (this.n2BeginTime > 0L)
    {
      this.n2Cost = (System.currentTimeMillis() - this.n2BeginTime);
      return;
    }
    this.n2Cost = 0L;
  }
  
  private void c()
  {
    if (this.n3BeginTime > 0L)
    {
      this.n5Cost = (System.currentTimeMillis() - this.n3BeginTime);
      return;
    }
    this.n3Cost = 0L;
  }
  
  private void d()
  {
    if (this.n4BeginTime > 0L)
    {
      this.n4Cost = (System.currentTimeMillis() - this.n4BeginTime);
      return;
    }
    this.n4Cost = 0L;
  }
  
  private void e()
  {
    if (this.n5BeginTime > 0L)
    {
      this.n5Cost = (System.currentTimeMillis() - this.n5BeginTime);
      return;
    }
    this.n5Cost = 0L;
  }
  
  protected void again()
  {
    String str = this.roomId;
    reset();
    this.curNode = 2;
    this.isAgain = true;
    this.createTime = System.currentTimeMillis();
    this.roomId = str;
    this.n2BeginTime = System.currentTimeMillis();
  }
  
  public HashMap<String, String> buildRealReportData()
  {
    long l = 0L;
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_CreateTime", String.valueOf(this.createTime));
    localHashMap.put("param_RoomId", String.valueOf(this.roomId));
    localHashMap.put("param_IsAgain", String.valueOf(this.isAgain));
    localHashMap.put("param_EndNode", String.valueOf(this.endNode));
    localHashMap.put("param_EndCode", String.valueOf(this.endCode));
    localHashMap.put("param_N1_Cost", String.valueOf(this.n1Cost));
    localHashMap.put("param_N1_EnterRoomRetCode", String.valueOf(this.n1EnterGameRoomRetCode));
    localHashMap.put("param_N2_Cost", String.valueOf(this.n2Cost));
    localHashMap.put("param_N2_AvEnterCost", String.valueOf(this.n2AvEnterCost));
    localHashMap.put("param_N3_Cost", String.valueOf(this.n3Cost));
    localHashMap.put("param_N3_GameType", String.valueOf(this.n3GameType));
    localHashMap.put("param_N3_MemberCount", String.valueOf(this.n3MemberCount));
    localHashMap.put("param_N4_Cost", String.valueOf(this.n4Cost));
    localHashMap.put("param_N5_Cost", String.valueOf(this.n5Cost));
    if (this.createTime > 0L) {
      l = System.currentTimeMillis() - this.createTime;
    }
    localHashMap.put("duration", String.valueOf(l));
    if (this.endCode > 0) {}
    for (boolean bool = true;; bool = false)
    {
      localHashMap.put("success", String.valueOf(bool));
      localHashMap.put("uin", BaseApplicationImpl.getApplication().getRuntime().getAccount());
      return localHashMap;
    }
  }
  
  public void copyFromMain(ReportData paramReportData)
  {
    this.createTime = paramReportData.createTime;
    this.roomId = paramReportData.roomId;
    this.n1BeginTime = paramReportData.n1BeginTime;
    this.n1EndTime = paramReportData.n1EndTime;
    this.n1EnterGameRoomRetCode = paramReportData.n1EnterGameRoomRetCode;
  }
  
  protected void exit()
  {
    switch (this.endNode)
    {
    default: 
      return;
    case 1: 
      a();
      return;
    case 2: 
      b();
      return;
    case 3: 
      c();
      return;
    case 4: 
      d();
      return;
    }
    e();
  }
  
  protected void reset()
  {
    this.curNode = 0;
    this.roomId = "";
    this.isAgain = false;
    this.endNode = 0;
    this.endCode = 0;
    this.n1Cost = 0L;
    this.n2Cost = 0L;
    this.n2AvEnterCost = 0L;
    this.n3Cost = 0L;
    this.n3GameType = 0;
    this.n3MemberCount = 0;
    this.n4Cost = 0L;
    this.n5Cost = 0L;
    this.createTime = 0L;
    this.n1BeginTime = 0L;
    this.n1EndTime = 0L;
    this.n1EnterGameRoomRetCode = 0;
    this.n2BeginTime = 0L;
    this.n2EndTime = 0L;
    this.n2EnterAvBeginTime = 0L;
    this.n2EnterAvEndTime = 0L;
    this.n3BeginTime = 0L;
    this.n3EndTime = 0L;
    this.n4BeginTime = 0L;
    this.n4EndTime = 0L;
    this.n5BeginTime = 0L;
    this.n5EndTime = 0L;
  }
  
  public String toString()
  {
    return "ReportData{roomId='" + this.roomId + '\'' + ", isAgain=" + this.isAgain + ", endNode=" + this.endNode + ", endCode=" + this.endCode + ", n1Cost=" + this.n1Cost + ", n1EnterGameRoomRetCode=" + this.n1EnterGameRoomRetCode + ", n2Cost=" + this.n2Cost + ", n2AvEnterCost=" + this.n2AvEnterCost + ", n3Cost=" + this.n3Cost + ", n3GameType=" + this.n3GameType + ", n3MemberCount=" + this.n3MemberCount + ", n4Cost=" + this.n4Cost + ", n5Cost=" + this.n5Cost + ", createTime=" + this.createTime + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.avgame.util.AVGameNodeReportUtil.ReportData
 * JD-Core Version:    0.7.0.1
 */