package com.tencent.biz.pubaccount.AccountDetail.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class GetRecvMsgStateReq
  extends JceStruct
  implements Cloneable
{
  public long puin;
  public long uin;
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.puin = paramJceInputStream.read(this.puin, 0, true);
    this.uin = paramJceInputStream.read(this.uin, 1, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.puin, 0);
    paramJceOutputStream.write(this.uin, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.AccountDetail.jce.GetRecvMsgStateReq
 * JD-Core Version:    0.7.0.1
 */