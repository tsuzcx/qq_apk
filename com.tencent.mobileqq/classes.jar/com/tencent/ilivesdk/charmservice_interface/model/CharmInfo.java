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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("charm:");
    localStringBuilder.append(this.charm);
    localStringBuilder.append(" giftTotal:");
    localStringBuilder.append(this.giftTotal);
    localStringBuilder.append(" todayIncome:");
    localStringBuilder.append(this.todayIncome);
    localStringBuilder.append(" uin:");
    localStringBuilder.append(this.uin);
    localStringBuilder.append(" label:");
    localStringBuilder.append(this.label);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilivesdk.charmservice_interface.model.CharmInfo
 * JD-Core Version:    0.7.0.1
 */