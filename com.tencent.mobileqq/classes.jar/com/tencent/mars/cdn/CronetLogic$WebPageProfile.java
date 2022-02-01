package com.tencent.mars.cdn;

public class CronetLogic$WebPageProfile
{
  public long SSLconnectionEnd;
  public long SSLconnectionStart;
  public long connectEnd;
  public long connectStart;
  public long domainLookUpEnd;
  public long domainLookUpStart;
  public int downstreamThroughputKbpsEstimate;
  public long fetchStart;
  public int httpRttEstimate;
  public int networkTypeEstimate;
  public String peerIP = "";
  public int port;
  public String protocol = "";
  public long receivedBytedCount;
  public long redirectEnd;
  public long redirectStart;
  public long requestEnd;
  public long requestStart;
  public long responseEnd;
  public long responseStart;
  public int rtt;
  public long sendBytesCount;
  public boolean socketReused;
  public int statusCode;
  public int throughputKbps;
  public int transportRttEstimate;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("WebPageProfile{redirectStart=");
    localStringBuilder.append(this.redirectStart);
    localStringBuilder.append(", redirectEnd=");
    localStringBuilder.append(this.redirectEnd);
    localStringBuilder.append(", fetchStart=");
    localStringBuilder.append(this.fetchStart);
    localStringBuilder.append(", domainLookUpStart=");
    localStringBuilder.append(this.domainLookUpStart);
    localStringBuilder.append(", domainLookUpEnd=");
    localStringBuilder.append(this.domainLookUpEnd);
    localStringBuilder.append(", connectStart=");
    localStringBuilder.append(this.connectStart);
    localStringBuilder.append(", connectEnd=");
    localStringBuilder.append(this.connectEnd);
    localStringBuilder.append(", SSLconnectionStart=");
    localStringBuilder.append(this.SSLconnectionStart);
    localStringBuilder.append(", SSLconnectionEnd=");
    localStringBuilder.append(this.SSLconnectionEnd);
    localStringBuilder.append(", requestStart=");
    localStringBuilder.append(this.requestStart);
    localStringBuilder.append(", requestEnd=");
    localStringBuilder.append(this.requestEnd);
    localStringBuilder.append(", responseStart=");
    localStringBuilder.append(this.responseStart);
    localStringBuilder.append(", responseEnd=");
    localStringBuilder.append(this.responseEnd);
    localStringBuilder.append(", protocol='");
    localStringBuilder.append(this.protocol);
    localStringBuilder.append('\'');
    localStringBuilder.append(", rtt=");
    localStringBuilder.append(this.rtt);
    localStringBuilder.append(", statusCode=");
    localStringBuilder.append(this.statusCode);
    localStringBuilder.append(", networkTypeEstimate=");
    localStringBuilder.append(this.networkTypeEstimate);
    localStringBuilder.append(", httpRttEstimate=");
    localStringBuilder.append(this.httpRttEstimate);
    localStringBuilder.append(", transportRttEstimate=");
    localStringBuilder.append(this.transportRttEstimate);
    localStringBuilder.append(", downstreamThroughputKbpsEstimate=");
    localStringBuilder.append(this.downstreamThroughputKbpsEstimate);
    localStringBuilder.append(", throughputKbps=");
    localStringBuilder.append(this.throughputKbps);
    localStringBuilder.append(", peerIP='");
    localStringBuilder.append(this.peerIP);
    localStringBuilder.append('\'');
    localStringBuilder.append(", port=");
    localStringBuilder.append(this.port);
    localStringBuilder.append(", socketReused=");
    localStringBuilder.append(this.socketReused);
    localStringBuilder.append(", sendBytesCount=");
    localStringBuilder.append(this.sendBytesCount);
    localStringBuilder.append(", receivedBytedCount=");
    localStringBuilder.append(this.receivedBytedCount);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mars.cdn.CronetLogic.WebPageProfile
 * JD-Core Version:    0.7.0.1
 */