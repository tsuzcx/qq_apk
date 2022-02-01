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
    ArrayList localArrayList = new ArrayList(20);
    Object localObject2 = new ArrayList(20);
    int i = nextSeqKey();
    Iterator localIterator = this.mReportings.keySet().iterator();
    Object localObject1 = null;
    int j = 0;
    Object localObject3;
    if (localIterator.hasNext())
    {
      localObject3 = (String)localIterator.next();
      localObject3 = (AVReporting)this.mReportings.get(localObject3);
      if ((((AVReporting)localObject3).mDetailHashCode != 0) && (((AVReporting)localObject3).mDetail.hashCode() != ((AVReporting)localObject3).mDetailHashCode))
      {
        k -= 1;
        localIterator.remove();
        label125:
        if ((j % 20 != 0) && (j < k)) {
          break label239;
        }
        localObject1 = reportPackage(localArrayList, (ArrayList)localObject2, i);
        localArrayList = new ArrayList(20);
        localObject2 = new ArrayList(20);
        if (j >= k) {
          break label254;
        }
        i = nextSeqKey();
        localObject3 = localObject2;
        localObject2 = localObject1;
        localObject1 = localObject3;
      }
    }
    for (;;)
    {
      localObject3 = localObject2;
      localObject2 = localObject1;
      localObject1 = localObject3;
      break;
      localArrayList.add(((AVReporting)localObject3).mTag);
      ((ArrayList)localObject2).add(((AVReporting)localObject3).mDetail);
      j += 1;
      break label125;
      return localObject1;
      label239:
      localObject3 = localObject1;
      localObject1 = localObject2;
      localObject2 = localObject3;
      continue;
      label254:
      localObject3 = localObject1;
      localObject1 = localObject2;
      localObject2 = localObject3;
    }
  }
  
  private byte[] handleAddReporting(String paramString1, String paramString2, int paramInt)
  {
    String str = paramString1 + ":" + paramString2;
    AVReporting localAVReporting = (AVReporting)this.mReportings.get(str);
    if (localAVReporting == null)
    {
      localAVReporting = new AVReporting();
      localAVReporting.mTag = paramString1;
      localAVReporting.mDetail = paramString2;
      localAVReporting.mCount = paramInt;
      localAVReporting.mDetailHashCode = localAVReporting.mDetail.hashCode();
      this.mReportings.put(str, localAVReporting);
    }
    for (;;)
    {
      return doReportClickEvent();
      localAVReporting.mCount += paramInt;
    }
  }
  
  private int nextSeqKey()
  {
    for (;;)
    {
      try
      {
        if (this.mSeqKey <= 0)
        {
          this.mSeqKey = (new Random().nextInt(1000000) + 100);
          int i = this.mSeqKey;
          return i;
        }
        if (this.mSeqKey >= 1000100) {
          this.mSeqKey = 100;
        } else {
          this.mSeqKey += 1;
        }
      }
      finally {}
    }
  }
  
  public byte[] report(String paramString)
  {
    QLog.d("AVReportEngine", 0, "reportData = " + paramString);
    return handleAddReporting("dc02105", paramString, 1);
  }
  
  byte[] reportPackage(ArrayList<String> paramArrayList1, ArrayList<String> paramArrayList2, int paramInt)
  {
    strupbuff localstrupbuff = new strupbuff();
    localstrupbuff.prefix = "";
    HashMap localHashMap = new HashMap();
    int i = 0;
    for (;;)
    {
      if (i >= paramArrayList1.size()) {
        break label162;
      }
      String str = (String)paramArrayList1.get(i);
      Object localObject = (String)paramArrayList2.get(i);
      try
      {
        byte[] arrayOfByte = ((String)localObject).getBytes("GBK");
        ArrayList localArrayList = (ArrayList)localHashMap.get(str);
        localObject = localArrayList;
        if (localArrayList == null)
        {
          localObject = new ArrayList();
          localHashMap.put(str, localObject);
        }
        ((ArrayList)localObject).add(arrayOfByte);
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        for (;;)
        {
          QLog.d("AVReportEngine", 0, "try catch reportPackage, exception = " + localUnsupportedEncodingException);
        }
      }
      i += 1;
    }
    label162:
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
      paramArrayList2 = new byte[paramInt - 4];
      System.arraycopy(paramArrayList1, 4, paramArrayList2, 0, paramInt - 4);
      return paramArrayList2;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.TMG.sdk.AVReportEngine
 * JD-Core Version:    0.7.0.1
 */