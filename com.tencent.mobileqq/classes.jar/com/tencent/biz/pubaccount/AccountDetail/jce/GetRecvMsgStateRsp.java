package com.tencent.biz.pubaccount.AccountDetail.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class GetRecvMsgStateRsp
  extends JceStruct
  implements Cloneable
{
  public String reason = "";
  public int result = 0;
  public int state = 0;
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.result = paramJceInputStream.read(this.result, 0, true);
    this.reason = paramJceInputStream.readString(1, false);
    this.state = paramJceInputStream.read(this.state, 2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.result, 0);
    if (this.reason != null) {
      paramJceOutputStream.write(this.reason, 1);
    }
    paramJceOutputStream.write(this.state, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.AccountDetail.jce.GetRecvMsgStateRsp
 * JD-Core Version:    0.7.0.1
 */