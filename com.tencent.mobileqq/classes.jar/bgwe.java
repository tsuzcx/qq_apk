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

public class bgwe
{
  private static volatile bgwe jdField_a_of_type_Bgwe;
  private SparseArray<bgwa> jdField_a_of_type_AndroidUtilSparseArray;
  private SparseArray<EngineChannel> b;
  private SparseArray<EngineChannel> c;
  
  private bgwe()
  {
    QMLog.i("EngineManager", "[MiniEng]init start");
    long l = System.currentTimeMillis();
    this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
    this.c = new SparseArray();
    EngineChannel localEngineChannel = new EngineChannel();
    localEngineChannel.a("MainGame");
    localEngineChannel.a(new bgwh(this));
    this.c.put(2, localEngineChannel);
    localEngineChannel = new EngineChannel();
    localEngineChannel.a("MainApp");
    localEngineChannel.a(new bgwh(this));
    this.c.put(3, localEngineChannel);
    this.b = new SparseArray();
    bgwa.a();
    bgwa.b(2);
    bgwa.a(2);
    bgwa.a(3);
    QMLog.i("EngineManager", "[MiniEng]init end cost=" + (System.currentTimeMillis() - l));
  }
  
  public static bgwe a()
  {
    if (jdField_a_of_type_Bgwe == null) {}
    try
    {
      if (jdField_a_of_type_Bgwe == null) {
        jdField_a_of_type_Bgwe = new bgwe();
      }
      return jdField_a_of_type_Bgwe;
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
    a(paramBaseLibInfo, new bgwg(this, paramEngineChannel, paramBaseLibInfo));
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
    return bgwa.a(paramInt);
  }
  
  public void a(BaseLibInfo paramBaseLibInfo, bgwd parambgwd)
  {
    if (paramBaseLibInfo != null)
    {
      bgwa localbgwa2 = (bgwa)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramBaseLibInfo.baseLibType);
      bgwa localbgwa1 = localbgwa2;
      if (localbgwa2 == null)
      {
        localbgwa1 = new bgwa();
        this.jdField_a_of_type_AndroidUtilSparseArray.put(paramBaseLibInfo.baseLibType, localbgwa1);
      }
      localbgwa1.a(paramBaseLibInfo, parambgwd);
      return;
    }
    QMLog.i("EngineManager", "[MiniEng] libInfo is null ");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bgwe
 * JD-Core Version:    0.7.0.1
 */