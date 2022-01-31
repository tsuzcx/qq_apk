import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.component.network.module.common.NetworkState.NetworkStateListener;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.tmassistant.common.jce.StatItem;
import com.tencent.tmassistant.common.jce.StatReportRequest;
import com.tencent.tmassistant.common.jce.StatReportResponse;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class bfio
  implements bfim, NetworkState.NetworkStateListener
{
  private static bfio jdField_a_of_type_Bfio;
  private long jdField_a_of_type_Long = 1800000L;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private SparseArray<ArrayList<StatItem>> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  private bfil jdField_a_of_type_Bfil = new bfil();
  private Map<Integer, ArrayList<String>> jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
  private SparseArray<ArrayList<StatItem>> b = new SparseArray();
  
  private bfio()
  {
    this.jdField_a_of_type_Bfil.a(this);
    a();
  }
  
  public static bfio a()
  {
    try
    {
      if (jdField_a_of_type_Bfio == null) {
        jdField_a_of_type_Bfio = new bfio();
      }
      bfio localbfio = jdField_a_of_type_Bfio;
      return localbfio;
    }
    finally {}
  }
  
  private void a()
  {
    HandlerThread localHandlerThread = new HandlerThread("thread_report");
    localHandlerThread.start();
    this.jdField_a_of_type_AndroidOsHandler = new bfip(this, localHandlerThread.getLooper());
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(2);
  }
  
  public void a(int paramInt, DownloadInfo paramDownloadInfo)
  {
    if (BaseApplicationImpl.sProcessId == 7) {}
    for (int i = 1; (paramDownloadInfo == null) || (i == 0); i = 0) {
      return;
    }
    long l = System.currentTimeMillis() / 1000L;
    a(9, l + "|" + paramDownloadInfo.jdField_c_of_type_JavaLangString + "|" + paramDownloadInfo.b + "|" + paramDownloadInfo.e + "|" + paramDownloadInfo.jdField_c_of_type_Int + "|" + paramInt + "|" + paramDownloadInfo.jdField_c_of_type_Long + "|" + paramDownloadInfo.h);
  }
  
  public void a(int paramInt1, StatReportRequest paramStatReportRequest, StatReportResponse paramStatReportResponse, int paramInt2)
  {
    Log.i("selfupdeReport", "circleTest reportLog onReportFinish errorCode = " + paramInt2);
    paramStatReportRequest = (ArrayList)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt1);
    if (paramStatReportRequest == null) {
      paramStatReportRequest = (ArrayList)this.b.get(paramInt1);
    }
    for (int i = 1;; i = 0)
    {
      if (paramInt2 != 0)
      {
        if ((paramStatReportRequest != null) && (paramStatReportRequest.size() > 0) && (i == 0))
        {
          SparseArray localSparseArray = new SparseArray();
          Iterator localIterator = paramStatReportRequest.iterator();
          while (localIterator.hasNext())
          {
            StatItem localStatItem = (StatItem)localIterator.next();
            paramStatReportResponse = (List)localSparseArray.get(localStatItem.type);
            paramStatReportRequest = paramStatReportResponse;
            if (paramStatReportResponse == null)
            {
              paramStatReportRequest = new ArrayList();
              localSparseArray.put(localStatItem.type, paramStatReportRequest);
            }
            paramStatReportRequest.addAll(localStatItem.records);
          }
          i = localSparseArray.size();
          paramInt2 = 0;
          while (paramInt2 < i)
          {
            int j = localSparseArray.keyAt(paramInt2);
            paramStatReportResponse = (List)localSparseArray.get(j);
            paramStatReportRequest = new ArrayList();
            paramStatReportResponse = paramStatReportResponse.iterator();
            while (paramStatReportResponse.hasNext()) {
              paramStatReportRequest.add((String)paramStatReportResponse.next());
            }
            paramStatReportResponse = bfib.a().a(String.valueOf(j));
            if (paramStatReportResponse != null) {
              paramStatReportRequest.addAll(paramStatReportResponse);
            }
            bfib.a().a(String.valueOf(j), paramStatReportRequest);
            paramInt2 += 1;
          }
        }
      }
      else if ((i != 0) && (paramStatReportRequest != null) && (paramStatReportRequest.size() > 0))
      {
        paramStatReportRequest = paramStatReportRequest.iterator();
        while (paramStatReportRequest.hasNext())
        {
          paramStatReportResponse = (StatItem)paramStatReportRequest.next();
          bfib.a().a(String.valueOf(paramStatReportResponse.type));
        }
      }
      this.jdField_a_of_type_AndroidUtilSparseArray.delete(paramInt1);
      this.b.delete(paramInt1);
      return;
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    if ((paramInt >= 0) && (!TextUtils.isEmpty(paramString)))
    {
      ArrayList localArrayList2 = (ArrayList)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramInt));
      ArrayList localArrayList1 = localArrayList2;
      if (localArrayList2 == null)
      {
        localArrayList1 = new ArrayList();
        this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(paramInt), localArrayList1);
      }
      localArrayList1.add(paramString);
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, 500L);
    }
  }
  
  public void onNetworkConnect(boolean paramBoolean)
  {
    if (paramBoolean) {
      if (!this.jdField_a_of_type_AndroidOsHandler.hasMessages(2)) {
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(2);
      }
    }
    while (!this.jdField_a_of_type_AndroidOsHandler.hasMessages(2)) {
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bfio
 * JD-Core Version:    0.7.0.1
 */