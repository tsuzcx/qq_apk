package com.tencent.component.network.module.common.dns;

import com.tencent.component.network.module.base.QDLog;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;

public class ResponsePacket
{
  private static final int LABEL_COMPRESSION = 192;
  private static final int LABEL_MASK = 192;
  private static final int LABEL_NORMAL = 0;
  private static final int MAXLABEL = 64;
  private static final int SECTION_ADDRESS = 1;
  private static final int SECTION_QUESTION = 0;
  private int[] counts = new int[4];
  private long expireTime = 0L;
  private int flags;
  private String host = "";
  private DNSInput in;
  private byte[] label = new byte[64];
  private StringBuilder nameBuilder = new StringBuilder();
  private int reqId;
  private ArrayList[] sections;
  
  public ResponsePacket(DNSInput paramDNSInput, String paramString)
  {
    this.in = paramDNSInput;
    this.host = paramString;
    this.sections = new ArrayList[4];
    initHeader();
    check(this.flags);
    parseAnswer();
  }
  
  private void check(int paramInt)
  {
    String str = Integer.toBinaryString(paramInt);
    if (str.length() < 4) {
      throw new Exception("exception cause [FBS - " + str + "]");
    }
    str = str.substring(str.length() - 4);
    if (str.equals("0011")) {
      throw new UnknownHostException("Unable to resolve host \"" + this.host + "\": No address associated with hostname");
    }
    if (!str.equals("0000")) {
      throw new Exception("exception cause [RCODE - " + str + "][HOST - " + this.host + "]");
    }
  }
  
  private void initHeader()
  {
    this.reqId = this.in.readU16();
    this.flags = this.in.readU16();
    int i = 0;
    while (i < this.counts.length)
    {
      this.counts[i] = this.in.readU16();
      i += 1;
    }
  }
  
  private void parseAnswer()
  {
    int i = 0;
    if (i < 2) {}
    for (;;)
    {
      int j;
      try
      {
        k = this.counts[i];
        if (k <= 0) {
          break label223;
        }
        this.sections[i] = new ArrayList(k);
      }
      catch (WireParseException localWireParseException)
      {
        int k;
        AnswerRecord localAnswerRecord;
        throw localWireParseException;
      }
      if (j < k)
      {
        localAnswerRecord = new AnswerRecord();
        if (i == 0)
        {
          localAnswerRecord.domain = retrieveName();
          localAnswerRecord.type = this.in.readU16();
          localAnswerRecord.qclass = this.in.readU16();
          this.sections[i].add(localAnswerRecord);
        }
        else
        {
          retrieveName();
          localAnswerRecord.domain = this.host;
          localAnswerRecord.type = this.in.readU16();
          localAnswerRecord.qclass = this.in.readU16();
          localAnswerRecord.ttl = this.in.readU32();
          this.in.setActive(this.in.readU16());
          localAnswerRecord.ip = this.in.readByteArray();
          if (localAnswerRecord.type == 1)
          {
            setExpireTime(localAnswerRecord.ttl);
            this.sections[i].add(localAnswerRecord);
          }
        }
      }
      else
      {
        i += 1;
        break;
        return;
        label223:
        j = 0;
        continue;
      }
      j += 1;
    }
  }
  
  private String retrieveName()
  {
    if (this.nameBuilder.length() > 0) {
      this.nameBuilder.delete(0, this.nameBuilder.length());
    }
    int j = 0;
    int i = 0;
    while (i == 0)
    {
      int k = this.in.readU8();
      switch (k & 0xC0)
      {
      default: 
        throw new WireParseException("bad label type");
      case 0: 
        if (k == 0)
        {
          i = 1;
        }
        else
        {
          this.in.readByteArray(this.label, 0, k);
          this.nameBuilder.append(ByteBase.byteString(this.label, k));
          this.nameBuilder.append(".");
        }
        break;
      case 192: 
        int m = ((k & 0xFFFFFF3F) << 8) + this.in.readU8();
        if (m >= this.in.current() - 2) {
          throw new WireParseException("bad compression");
        }
        k = j;
        if (j == 0)
        {
          this.in.save();
          k = 1;
        }
        this.in.jump(m);
        j = k;
      }
    }
    if (j != 0) {
      this.in.restore();
    }
    if (this.nameBuilder.length() > 0) {
      this.nameBuilder.deleteCharAt(this.nameBuilder.length() - 1);
    }
    return this.nameBuilder.toString();
  }
  
  private void setExpireTime(long paramLong)
  {
    if ((this.expireTime == 0L) && (paramLong > 0L)) {
      this.expireTime = (System.currentTimeMillis() + 1000L * paramLong);
    }
  }
  
  public ArrayList<AnswerRecord> getAnswers()
  {
    return this.sections[1];
  }
  
  public InetAddress[] getByAddress()
  {
    if ((this.sections[1] != null) && (this.sections[1].size() > 0))
    {
      ArrayList localArrayList = new ArrayList();
      int i = 0;
      for (;;)
      {
        if (i >= this.sections[1].size()) {
          break label120;
        }
        Object localObject = (AnswerRecord)this.sections[1].get(i);
        try
        {
          localObject = InetAddress.getByAddress(((AnswerRecord)localObject).domain, ((AnswerRecord)localObject).ip);
          if ((localObject != null) && (((InetAddress)localObject).getHostName() != null) && (!((InetAddress)localObject).getHostName().equals(((InetAddress)localObject).getHostAddress()))) {
            localArrayList.add(localObject);
          }
        }
        catch (UnknownHostException localUnknownHostException)
        {
          for (;;)
          {
            QDLog.e("ResponsePacket", "getByAddress>>>", localUnknownHostException);
          }
        }
        i += 1;
      }
      label120:
      return (InetAddress[])localArrayList.toArray(new InetAddress[localArrayList.size()]);
    }
    return null;
  }
  
  public long getExpireTime()
  {
    return this.expireTime;
  }
  
  public int getReqId()
  {
    return this.reqId;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.component.network.module.common.dns.ResponsePacket
 * JD-Core Version:    0.7.0.1
 */