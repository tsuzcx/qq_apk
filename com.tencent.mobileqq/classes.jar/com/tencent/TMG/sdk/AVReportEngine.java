package com.tencent.TMG.sdk;

import com.tencent.TMG.report.AVPacket;
import com.tencent.TMG.report.AVReporting;
import com.tencent.TMG.report.strupbuff;
import com.tencent.TMG.utils.QLog;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class AVReportEngine
{
  public static final String CMD_REPORTSTAT = "CliLogSvc.UploadReq";
  private static final int MAX_ONCE_REPORT_COUNT = 20;
  public static final String TAG = "AVReportEngine";
  public static final String TAG_DC_02088 = "dc02088";
  public static final String TAG_DC_02105 = "dc02105";
  private AVReporting app;
  private final HashMap<String, AVReporting> mReportings = new HashMap();
  private int mSeqKey;
  public int nativeObj = 0;
  
  private byte[] doReportClickEvent()
  {
    int k = this.mReportings.size();
    ArrayList localArrayList1 = new ArrayList(20);
    ArrayList localArrayList2 = new ArrayList(20);
    int i = nextSeqKey();
    Iterator localIterator = this.mReportings.keySet().iterator();
    byte[] arrayOfByte = null;
    int j = 0;
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      localObject = (AVReporting)this.mReportings.get(localObject);
      int m;
      int n;
      if ((((AVReporting)localObject).mDetailHashCode != 0) && (((AVReporting)localObject).mDetail.hashCode() != ((AVReporting)localObject).mDetailHashCode))
      {
        m = k - 1;
        localIterator.remove();
        n = j;
      }
      else
      {
        localArrayList1.add(((AVReporting)localObject).mTag);
        localArrayList2.add(((AVReporting)localObject).mDetail);
        n = j + 1;
        m = k;
      }
      if (n % 20 != 0)
      {
        k = m;
        j = n;
        if (n < m) {}
      }
      else
      {
        arrayOfByte = reportPackage(localArrayList1, localArrayList2, i);
        localArrayList1 = new ArrayList(20);
        localArrayList2 = new ArrayList(20);
        if (n < m) {
          i = nextSeqKey();
        }
        k = m;
        j = n;
      }
    }
    return arrayOfByte;
  }
  
  private byte[] handleAddReporting(String paramString1, String paramString2, int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append(":");
    ((StringBuilder)localObject).append(paramString2);
    localObject = ((StringBuilder)localObject).toString();
    AVReporting localAVReporting = (AVReporting)this.mReportings.get(localObject);
    if (localAVReporting == null)
    {
      localAVReporting = new AVReporting();
      localAVReporting.mTag = paramString1;
      localAVReporting.mDetail = paramString2;
      localAVReporting.mCount = paramInt;
      localAVReporting.mDetailHashCode = localAVReporting.mDetail.hashCode();
      this.mReportings.put(localObject, localAVReporting);
    }
    else
    {
      localAVReporting.mCount += paramInt;
    }
    return doReportClickEvent();
  }
  
  private int nextSeqKey()
  {
    try
    {
      if (this.mSeqKey <= 0) {
        this.mSeqKey = (new Random().nextInt(1000000) + 100);
      } else if (this.mSeqKey >= 1000100) {
        this.mSeqKey = 100;
      } else {
        this.mSeqKey += 1;
      }
      int i = this.mSeqKey;
      return i;
    }
    finally {}
  }
  
  public byte[] report(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("reportData = ");
    localStringBuilder.append(paramString);
    QLog.d("AVReportEngine", 0, localStringBuilder.toString());
    return handleAddReporting("dc02105", paramString, 1);
  }
  
  byte[] reportPackage(ArrayList<String> paramArrayList1, ArrayList<String> paramArrayList2, int paramInt)
  {
    strupbuff localstrupbuff = new strupbuff();
    localstrupbuff.prefix = "";
    HashMap localHashMap = new HashMap();
    int i = 0;
    while (i < paramArrayList1.size())
    {
      String str = (String)paramArrayList1.get(i);
      Object localObject1 = (String)paramArrayList2.get(i);
      try
      {
        byte[] arrayOfByte = ((String)localObject1).getBytes("GBK");
        localObject2 = (ArrayList)localHashMap.get(str);
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = new ArrayList();
          localHashMap.put(str, localObject1);
        }
        ((ArrayList)localObject1).add(arrayOfByte);
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("try catch reportPackage, exception = ");
        ((StringBuilder)localObject2).append(localUnsupportedEncodingException);
        QLog.d("AVReportEngine", 0, ((StringBuilder)localObject2).toString());
      }
      i += 1;
    }
    localstrupbuff.logstring = new HashMap(localHashMap);
    localstrupbuff.encoding = 0;
    localstrupbuff.seqno = paramInt;
    paramArrayList1 = new AVPacket("QAVSDKUnity");
    paramArrayList1.setSSOCommand("CliLogSvc.UploadReq");
    paramArrayList1.setServantName("QQService.CliLogSvc.MainServantObj");
    paramArrayList1.setFuncName("UploadReq");
    paramArrayList1.addRequestPacket("Data", localstrupbuff);
    paramArrayList1.setTimeout(30000L);
    paramArrayList1 = paramArrayList1.toWupData();
    paramInt = paramArrayList1.length;
    if (paramInt >= 4)
    {
      paramInt -= 4;
      paramArrayList2 = new byte[paramInt];
      System.arraycopy(paramArrayList1, 4, paramArrayList2, 0, paramInt);
      return paramArrayList2;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.TMG.sdk.AVReportEngine
 * JD-Core Version:    0.7.0.1
 */