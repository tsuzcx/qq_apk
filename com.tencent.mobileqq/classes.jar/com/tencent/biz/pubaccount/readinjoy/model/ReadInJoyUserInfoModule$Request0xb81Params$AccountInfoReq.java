package com.tencent.biz.pubaccount.readinjoy.model;

import java.io.Serializable;
import pgs;

public class ReadInJoyUserInfoModule$Request0xb81Params$AccountInfoReq
  implements Serializable
{
  private int accountType;
  private long friendStatus;
  private long uin;
  
  private ReadInJoyUserInfoModule$Request0xb81Params$AccountInfoReq(pgs parampgs)
  {
    this.accountType = pgs.a(parampgs);
    this.uin = pgs.a(parampgs);
    this.friendStatus = pgs.b(parampgs);
  }
  
  public String toString()
  {
    return "AccountInfoReq, accountType = " + this.accountType + ", uin = " + this.uin + '\n' + "friendStatus = " + this.friendStatus + '\n';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyUserInfoModule.Request0xb81Params.AccountInfoReq
 * JD-Core Version:    0.7.0.1
 */