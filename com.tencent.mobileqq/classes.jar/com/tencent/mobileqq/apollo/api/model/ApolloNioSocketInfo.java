package com.tencent.mobileqq.apollo.api.model;

import java.nio.channels.SocketChannel;

public class ApolloNioSocketInfo
{
  public String mAddr;
  public SocketChannel mChannel;
  public int mPort;
  public long mSocketStr;
  public int mSslEnable;
  public String mSslInStance;
  public String mSslProtocol;
  public int mState;
  
  public ApolloNioSocketInfo(long paramLong, String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3, SocketChannel paramSocketChannel)
  {
    this.mSocketStr = paramLong;
    this.mAddr = paramString1;
    this.mPort = paramInt1;
    this.mSslEnable = paramInt2;
    this.mSslInStance = paramString2;
    this.mSslProtocol = paramString3;
    this.mChannel = paramSocketChannel;
    this.mState = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.model.ApolloNioSocketInfo
 * JD-Core Version:    0.7.0.1
 */