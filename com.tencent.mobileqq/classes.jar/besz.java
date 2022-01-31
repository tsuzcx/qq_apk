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

public class besz
{
  private static volatile besz jdField_a_of_type_Besz;
  private SparseArray<besv> jdField_a_of_type_AndroidUtilSparseArray;
  private SparseArray<EngineChannel> b;
  private SparseArray<EngineChannel> c;
  
  private besz()
  {
    besl.b("EngineManager", "[MiniEng]init start");
    long l = System.currentTimeMillis();
    this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
    this.c = new SparseArray();
    EngineChannel localEngineChannel = new EngineChannel();
    localEngineChannel.a("MainGame");
    localEngineChannel.a(new betc(this));
    this.c.put(2, localEngineChannel);
    localEngineChannel = new EngineChannel();
    localEngineChannel.a("MainApp");
    localEngineChannel.a(new betc(this));
    this.c.put(3, localEngineChannel);
    this.b = new SparseArray();
    besv.a();
    besv.b(2);
    besv.a(2);
    besv.a(3);
    besl.b("EngineManager", "[MiniEng]init end cost=" + (System.currentTimeMillis() - l));
  }
  
  public static besz a()
  {
    if (jdField_a_of_type_Besz == null) {}
    try
    {
      if (jdField_a_of_type_Besz == null) {
        jdField_a_of_type_Besz = new besz();
      }
      return jdField_a_of_type_Besz;
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
      beiw.b().post(new EngineManager.1(this, paramBaseLibInfo, paramEngineChannel));
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
              besl.d("EngineManager", "[MiniEng] removeDeadChannelExcept error pid=" + j);
            }
            else
            {
              this.b.remove(j);
              besl.b("EngineManager", "[MiniEng] removeDeadChannelExcept pid=" + j);
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
      beiw.b().post(new EngineManager.2(this, paramBaseLibInfo, paramEngineChannel));
      return;
    }
    paramEngineChannel.a(54, null);
  }
  
  private void c(BaseLibInfo paramBaseLibInfo, EngineChannel paramEngineChannel)
  {
    besl.b("EngineManager", "[MiniEng] installBaseLibForChannel " + paramBaseLibInfo + "," + paramEngineChannel);
    a(paramBaseLibInfo, new betb(this, paramEngineChannel, paramBaseLibInfo));
  }
  
  public EngineChannel a(int paramInt)
  {
    EngineChannel localEngineChannel = (EngineChannel)this.c.get(paramInt);
    if (localEngineChannel == null) {
      besl.d("EngineManager", "[MiniEng]getChannelForType error type" + paramInt);
    }
    return localEngineChannel;
  }
  
  public ArrayList<InstalledEngine> a(int paramInt)
  {
    return besv.a(paramInt);
  }
  
  public void a(BaseLibInfo paramBaseLibInfo, besy parambesy)
  {
    if (paramBaseLibInfo != null)
    {
      besv localbesv2 = (besv)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramBaseLibInfo.baseLibType);
      besv localbesv1 = localbesv2;
      if (localbesv2 == null)
      {
        localbesv1 = new besv();
        this.jdField_a_of_type_AndroidUtilSparseArray.put(paramBaseLibInfo.baseLibType, localbesv1);
      }
      localbesv1.a(paramBaseLibInfo, parambesy);
      return;
    }
    besl.b("EngineManager", "[MiniEng] libInfo is null ");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     besz
 * JD-Core Version:    0.7.0.1
 */