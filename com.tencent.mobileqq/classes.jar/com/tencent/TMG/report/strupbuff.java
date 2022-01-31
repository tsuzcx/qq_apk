package com.tencent.TMG.report;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class strupbuff
  extends JceStruct
{
  static Map<String, ArrayList<byte[]>> cache_logstring;
  public byte encoding = 0;
  public Map<String, ArrayList<byte[]>> logstring = null;
  public String prefix = "";
  public int seqno = 0;
  
  public strupbuff() {}
  
  public strupbuff(Map<String, ArrayList<byte[]>> paramMap, String paramString, byte paramByte, int paramInt)
  {
    this.logstring = paramMap;
    this.prefix = paramString;
    this.encoding = paramByte;
    this.seqno = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_logstring == null)
    {
      cache_logstring = new HashMap();
      ArrayList localArrayList = new ArrayList();
      byte[] arrayOfByte = (byte[])new byte[1];
      ((byte[])arrayOfByte)[0] = 0;
      localArrayList.add(arrayOfByte);
      cache_logstring.put("", localArrayList);
    }
    this.logstring = ((Map)paramJceInputStream.read(cache_logstring, 0, true));
    this.prefix = paramJceInputStream.readString(1, false);
    this.encoding = paramJceInputStream.read(this.encoding, 2, false);
    this.seqno = paramJceInputStream.read(this.seqno, 3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.logstring, 0);
    if (this.prefix != null) {
      paramJceOutputStream.write(this.prefix, 1);
    }
    paramJceOutputStream.write(this.encoding, 2);
    paramJceOutputStream.write(this.seqno, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.TMG.report.strupbuff
 * JD-Core Version:    0.7.0.1
 */