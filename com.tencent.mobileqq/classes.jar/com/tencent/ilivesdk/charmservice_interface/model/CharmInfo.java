package com.tencent.ilivesdk.charmservice_interface.model;

public class CharmInfo
{
  public long charm;
  public int giftTotal;
  public String label;
  public int todayIncome;
  public long uin;
  
  public String toString()
  {
    return "charm:" + this.charm + " giftTotal:" + this.giftTotal + " todayIncome:" + this.todayIncome + " uin:" + this.uin + " label:" + this.label;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilivesdk.charmservice_interface.model.CharmInfo
 * JD-Core Version:    0.7.0.1
 */