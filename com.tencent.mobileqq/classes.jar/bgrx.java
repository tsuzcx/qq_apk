import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.os.Handler;
import android.util.SparseArray;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.model.BaseLibInfo;
import com.tencent.qqmini.sdk.launcher.shell.IMiniAppEnv;
import com.tencent.qqmini.sdk.log.QMLog;
import com.tencent.qqmini.sdk.manager.EngineChannel;
import com.tencent.qqmini.sdk.manager.EngineManager.1;
import com.tencent.qqmini.sdk.manager.EngineManager.2;
import com.tencent.qqmini.sdk.manager.InstalledEngine;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class bgrx
{
  private static volatile bgrx jdField_a_of_type_Bgrx;
  private SparseArray<bgrt> jdField_a_of_type_AndroidUtilSparseArray;
  private SparseArray<EngineChannel> b;
  private SparseArray<EngineChannel> c;
  
  private bgrx()
  {
    QMLog.i("EngineManager", "[MiniEng]init start");
    long l = System.currentTimeMillis();
    this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
    this.c = new SparseArray();
    EngineChannel localEngineChannel = new EngineChannel();
    localEngineChannel.a("MainGame");
    localEngineChannel.a(new bgsa(this));
    this.c.put(2, localEngineChannel);
    localEngineChannel = new EngineChannel();
    localEngineChannel.a("MainApp");
    localEngineChannel.a(new bgsa(this));
    this.c.put(3, localEngineChannel);
    this.b = new SparseArray();
    bgrt.a();
    bgrt.b(2);
    bgrt.a(2);
    bgrt.a(3);
    QMLog.i("EngineManager", "[MiniEng]init end cost=" + (System.currentTimeMillis() - l));
  }
  
  public static bgrx a()
  {
    if (jdField_a_of_type_Bgrx == null) {}
    try
    {
      if (jdField_a_of_type_Bgrx == null) {
        jdField_a_of_type_Bgrx = new bgrx();
      }
      return jdField_a_of_type_Bgrx;
    }
    finally {}
  }
  
  private ArrayList<Integer> a()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = AppLoaderFactory.g().getMiniAppEnv().getContext();
    if (localObject == null) {
      return localArrayList;
    }
    localObject = (ActivityManager)((Context)localObject).getSystemService("activity");
    if (localObject == null) {
      return localArrayList;
    }
    localObject = ((ActivityManager)localObject).getRunningAppProcesses().iterator();
    while (((Iterator)localObject).hasNext()) {
      localArrayList.add(Integer.valueOf(((ActivityManager.RunningAppProcessInfo)((Iterator)localObject).next()).pid));
    }
    return localArrayList;
  }
  
  private void a(BaseLibInfo paramBaseLibInfo, EngineChannel paramEngineChannel)
  {
    if (paramBaseLibInfo != null)
    {
      ThreadManager.b().post(new EngineManager.1(this, paramBaseLibInfo, paramEngineChannel));
      return;
    }
    paramEngineChannel.a(54, null);
  }
  
  private void a(EngineChannel paramEngineChannel)
  {
    for (;;)
    {
      int i;
      try
      {
        ArrayList localArrayList = a();
        if (this.b != null)
        {
          i = 0;
          if (i < this.b.size())
          {
            int j = this.b.keyAt(i);
            if (localArrayList.contains(Integer.valueOf(j))) {
              break label137;
            }
            if (((EngineChannel)this.b.valueAt(i)).equals(paramEngineChannel))
            {
              QMLog.e("EngineManager", "[MiniEng] removeDeadChannelExcept error pid=" + j);
            }
            else
            {
              this.b.remove(j);
              QMLog.i("EngineManager", "[MiniEng] removeDeadChannelExcept pid=" + j);
            }
          }
        }
      }
      finally {}
      return;
      label137:
      i += 1;
    }
  }
  
  private void b(BaseLibInfo paramBaseLibInfo, EngineChannel paramEngineChannel)
  {
    if (paramBaseLibInfo != null)
    {
      ThreadManager.b().post(new EngineManager.2(this, paramBaseLibInfo, paramEngineChannel));
      return;
    }
    paramEngineChannel.a(54, null);
  }
  
  private void c(BaseLibInfo paramBaseLibInfo, EngineChannel paramEngineChannel)
  {
    QMLog.i("EngineManager", "[MiniEng] installBaseLibForChannel " + paramBaseLibInfo + "," + paramEngineChannel);
    a(paramBaseLibInfo, new bgrz(this, paramEngineChannel, paramBaseLibInfo));
  }
  
  public EngineChannel a(int paramInt)
  {
    EngineChannel localEngineChannel = (EngineChannel)this.c.get(paramInt);
    if (localEngineChannel == null) {
      QMLog.e("EngineManager", "[MiniEng]getChannelForType error type" + paramInt);
    }
    return localEngineChannel;
  }
  
  public ArrayList<InstalledEngine> a(int paramInt)
  {
    return bgrt.a(paramInt);
  }
  
  public void a(BaseLibInfo paramBaseLibInfo, bgrw parambgrw)
  {
    if (paramBaseLibInfo != null)
    {
      bgrt localbgrt2 = (bgrt)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramBaseLibInfo.baseLibType);
      bgrt localbgrt1 = localbgrt2;
      if (localbgrt2 == null)
      {
        localbgrt1 = new bgrt();
        this.jdField_a_of_type_AndroidUtilSparseArray.put(paramBaseLibInfo.baseLibType, localbgrt1);
      }
      localbgrt1.a(paramBaseLibInfo, parambgrw);
      return;
    }
    QMLog.i("EngineManager", "[MiniEng] libInfo is null ");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bgrx
 * JD-Core Version:    0.7.0.1
 */