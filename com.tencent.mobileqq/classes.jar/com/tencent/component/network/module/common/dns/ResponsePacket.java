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
    Object localObject = Integer.toBinaryString(paramInt);
    if (((String)localObject).length() >= 4)
    {
      localObject = ((String)localObject).substring(((String)localObject).length() - 4);
      if (!((String)localObject).equals("0011"))
      {
        if (((String)localObject).equals("0000")) {
          return;
        }
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("exception cause [RCODE - ");
        localStringBuilder.append((String)localObject);
        localStringBuilder.append("][HOST - ");
        localStringBuilder.append(this.host);
        localStringBuilder.append("]");
        throw new Exception(localStringBuilder.toString());
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Unable to resolve host \"");
      ((StringBuilder)localObject).append(this.host);
      ((StringBuilder)localObject).append("\": No address associated with hostname");
      throw new UnknownHostException(((StringBuilder)localObject).toString());
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("exception cause [FBS - ");
    localStringBuilder.append((String)localObject);
    localStringBuilder.append("]");
    throw new Exception(localStringBuilder.toString());
  }
  
  private void initHeader()
  {
    this.reqId = this.in.readU16();
    this.flags = this.in.readU16();
    int i = 0;
    for (;;)
    {
      int[] arrayOfInt = this.counts;
      if (i >= arrayOfInt.length) {
        break;
      }
      arrayOfInt[i] = this.in.readU16();
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
          break label227;
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
        j += 1;
      }
      else
      {
        i += 1;
        break;
        return;
        label227:
        j = 0;
      }
    }
  }
  
  private String retrieveName()
  {
    StringBuilder localStringBuilder;
    if (this.nameBuilder.length() > 0)
    {
      localStringBuilder = this.nameBuilder;
      localStringBuilder.delete(0, localStringBuilder.length());
    }
    int j = 0;
    int i = 0;
    while (j == 0)
    {
      int k = this.in.readU8();
      int m = k & 0xC0;
      if (m != 0)
      {
        if (m == 192)
        {
          m = this.in.readU8() + ((k & 0xFFFFFF3F) << 8);
          if (m < this.in.current() - 2)
          {
            k = i;
            if (i == 0)
            {
              this.in.save();
              k = 1;
            }
            this.in.jump(m);
            i = k;
          }
          else
          {
            throw new WireParseException("bad compression");
          }
        }
        else
        {
          throw new WireParseException("bad label type");
        }
      }
      else if (k == 0)
      {
        j = 1;
      }
      else
      {
        this.in.readByteArray(this.label, 0, k);
        this.nameBuilder.append(ByteBase.byteString(this.label, k));
        this.nameBuilder.append(".");
      }
    }
    if (i != 0) {
      this.in.restore();
    }
    if (this.nameBuilder.length() > 0)
    {
      localStringBuilder = this.nameBuilder;
      localStringBuilder.deleteCharAt(localStringBuilder.length() - 1);
    }
    return this.nameBuilder.toString();
  }
  
  private void setExpireTime(long paramLong)
  {
    if ((this.expireTime == 0L) && (paramLong > 0L)) {
      this.expireTime = (System.currentTimeMillis() + paramLong * 1000L);
    }
  }
  
  public ArrayList<AnswerRecord> getAnswers()
  {
    return this.sections[1];
  }
  
  public InetAddress[] getByAddress()
  {
    Object localObject1 = this.sections;
    if ((localObject1[1] != null) && (localObject1[1].size() > 0))
    {
      localObject1 = new ArrayList();
      int i = 0;
      while (i < this.sections[1].size())
      {
        Object localObject2 = (AnswerRecord)this.sections[1].get(i);
        try
        {
          localObject2 = InetAddress.getByAddress(((AnswerRecord)localObject2).domain, ((AnswerRecord)localObject2).ip);
          if ((localObject2 != null) && (((InetAddress)localObject2).getHostName() != null) && (!((InetAddress)localObject2).getHostName().equals(((InetAddress)localObject2).getHostAddress()))) {
            ((ArrayList)localObject1).add(localObject2);
          }
        }
        catch (UnknownHostException localUnknownHostException)
        {
          QDLog.e("ResponsePacket", "getByAddress>>>", localUnknownHostException);
        }
        i += 1;
      }
      return (InetAddress[])((ArrayList)localObject1).toArray(new InetAddress[((ArrayList)localObject1).size()]);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.network.module.common.dns.ResponsePacket
 * JD-Core Version:    0.7.0.1
 */