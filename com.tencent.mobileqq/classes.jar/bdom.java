import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.os.Handler;
import android.util.SparseArray;
import com.tencent.qqmini.sdk.core.MiniAppEnv;
import com.tencent.qqmini.sdk.launcher.model.BaseLibInfo;
import com.tencent.qqmini.sdk.manager.EngineChannel;
import com.tencent.qqmini.sdk.manager.EngineManager.1;
import com.tencent.qqmini.sdk.manager.EngineManager.2;
import com.tencent.qqmini.sdk.manager.InstalledEngine;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class bdom
{
  private static volatile bdom jdField_a_of_type_Bdom;
  private SparseArray<bdoi> jdField_a_of_type_AndroidUtilSparseArray;
  private SparseArray<EngineChannel> b;
  private SparseArray<EngineChannel> c;
  
  private bdom()
  {
    bdnw.b("EngineManager", "[MiniEng]init start");
    long l = System.currentTimeMillis();
    this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
    this.c = new SparseArray();
    EngineChannel localEngineChannel = new EngineChannel();
    localEngineChannel.a("MainGame");
    localEngineChannel.a(new bdop(this));
    this.c.put(2, localEngineChannel);
    localEngineChannel = new EngineChannel();
    localEngineChannel.a("MainApp");
    localEngineChannel.a(new bdop(this));
    this.c.put(3, localEngineChannel);
    this.b = new SparseArray();
    bdoi.a();
    bdoi.b(2);
    bdoi.a(2);
    bdoi.a(3);
    bdnw.b("EngineManager", "[MiniEng]init end cost=" + (System.currentTimeMillis() - l));
  }
  
  public static bdom a()
  {
    if (jdField_a_of_type_Bdom == null) {}
    try
    {
      if (jdField_a_of_type_Bdom == null) {
        jdField_a_of_type_Bdom = new bdom();
      }
      return jdField_a_of_type_Bdom;
    }
    finally {}
  }
  
  private ArrayList<Integer> a()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = MiniAppEnv.g().getContext();
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
      bdew.b().post(new EngineManager.1(this, paramBaseLibInfo, paramEngineChannel));
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
              bdnw.d("EngineManager", "[MiniEng] removeDeadChannelExcept error pid=" + j);
            }
            else
            {
              this.b.remove(j);
              bdnw.b("EngineManager", "[MiniEng] removeDeadChannelExcept pid=" + j);
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
      bdew.b().post(new EngineManager.2(this, paramBaseLibInfo, paramEngineChannel));
      return;
    }
    paramEngineChannel.a(54, null);
  }
  
  private void c(BaseLibInfo paramBaseLibInfo, EngineChannel paramEngineChannel)
  {
    bdnw.b("EngineManager", "[MiniEng] installBaseLibForChannel " + paramBaseLibInfo + "," + paramEngineChannel);
    a(paramBaseLibInfo, new bdoo(this, paramEngineChannel, paramBaseLibInfo));
  }
  
  public EngineChannel a(int paramInt)
  {
    EngineChannel localEngineChannel = (EngineChannel)this.c.get(paramInt);
    if (localEngineChannel == null) {
      bdnw.d("EngineManager", "[MiniEng]getChannelForType error type" + paramInt);
    }
    return localEngineChannel;
  }
  
  public ArrayList<InstalledEngine> a(int paramInt)
  {
    return bdoi.a(paramInt);
  }
  
  public void a(BaseLibInfo paramBaseLibInfo, bdol parambdol)
  {
    if (paramBaseLibInfo != null)
    {
      bdoi localbdoi2 = (bdoi)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramBaseLibInfo.baseLibType);
      bdoi localbdoi1 = localbdoi2;
      if (localbdoi2 == null)
      {
        localbdoi1 = new bdoi();
        this.jdField_a_of_type_AndroidUtilSparseArray.put(paramBaseLibInfo.baseLibType, localbdoi1);
      }
      localbdoi1.a(paramBaseLibInfo, parambdol);
      return;
    }
    bdnw.b("EngineManager", "[MiniEng] libInfo is null ");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bdom
 * JD-Core Version:    0.7.0.1
 */