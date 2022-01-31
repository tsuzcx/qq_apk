import android.text.TextUtils;
import com.tencent.av.opengl.filter.qqavimage.QQAVImageFilterConstants;
import com.tencent.mobileqq.richmedia.capture.data.FilterDesc;
import com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo;
import com.tencent.mobileqq.shortvideo.filter.FilterBusinessOperation;
import com.tencent.mobileqq.shortvideo.filter.QQFilterRenderManager;
import com.tencent.mobileqq.shortvideo.filter.QQSpecialAVFilter.MusicWaveformSupporter;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.music.QIMMusicConfigManager;
import dov.com.qq.im.capture.music.QQMusicDownloader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class bjdm
  extends bizw
  implements QQSpecialAVFilter.MusicWaveformSupporter
{
  private int jdField_a_of_type_Int = biho.jdField_a_of_type_Int;
  private bjdf jdField_a_of_type_Bjdf;
  private bjdg jdField_a_of_type_Bjdg;
  private blba jdField_a_of_type_Blba = new blba();
  private MusicItemInfo jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo;
  private HashMap<Integer, bjdg> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private List<bjdh> jdField_a_of_type_JavaUtilList = new ArrayList();
  public ConcurrentHashMap<String, MusicItemInfo> a;
  private boolean jdField_a_of_type_Boolean;
  private volatile int jdField_b_of_type_Int = 0;
  private MusicItemInfo jdField_b_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo;
  private ConcurrentHashMap<String, bbwg> jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private boolean jdField_b_of_type_Boolean;
  
  public bjdm()
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  }
  
  /* Error */
  private bjdg a(MusicItemInfo paramMusicItemInfo)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aconst_null
    //   3: astore_2
    //   4: aload_1
    //   5: getfield 61	com/tencent/mobileqq/richmedia/capture/data/MusicItemInfo:mType	I
    //   8: iconst_1
    //   9: if_icmpne +62 -> 71
    //   12: aload_0
    //   13: getfield 44	bjdm:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   16: iconst_1
    //   17: invokestatic 67	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   20: invokevirtual 71	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   23: checkcast 73	bjdg
    //   26: astore_3
    //   27: aload_3
    //   28: astore_2
    //   29: aload_3
    //   30: ifnonnull +32 -> 62
    //   33: new 73	bjdg
    //   36: dup
    //   37: invokespecial 74	bjdg:<init>	()V
    //   40: astore_2
    //   41: aload_2
    //   42: aload_0
    //   43: getfield 49	bjdm:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   46: invokevirtual 77	bjdg:a	(Ljava/util/List;)V
    //   49: aload_0
    //   50: getfield 44	bjdm:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   53: iconst_1
    //   54: invokestatic 67	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   57: aload_2
    //   58: invokevirtual 81	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   61: pop
    //   62: aload_2
    //   63: aload_1
    //   64: invokevirtual 84	bjdg:a	(Lcom/tencent/mobileqq/richmedia/capture/data/MusicItemInfo;)V
    //   67: aload_0
    //   68: monitorexit
    //   69: aload_2
    //   70: areturn
    //   71: aload_1
    //   72: getfield 61	com/tencent/mobileqq/richmedia/capture/data/MusicItemInfo:mType	I
    //   75: iconst_5
    //   76: if_icmpne -9 -> 67
    //   79: aload_0
    //   80: getfield 44	bjdm:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   83: iconst_2
    //   84: invokestatic 67	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   87: invokevirtual 71	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   90: checkcast 73	bjdg
    //   93: astore_3
    //   94: aload_3
    //   95: astore_2
    //   96: aload_3
    //   97: ifnonnull +32 -> 129
    //   100: new 86	dov/com/qq/im/capture/music/QQMusicPlayerScene
    //   103: dup
    //   104: invokespecial 87	dov/com/qq/im/capture/music/QQMusicPlayerScene:<init>	()V
    //   107: astore_2
    //   108: aload_2
    //   109: aload_0
    //   110: getfield 49	bjdm:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   113: invokevirtual 77	bjdg:a	(Ljava/util/List;)V
    //   116: aload_0
    //   117: getfield 44	bjdm:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   120: iconst_2
    //   121: invokestatic 67	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   124: aload_2
    //   125: invokevirtual 81	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   128: pop
    //   129: aload_2
    //   130: aload_1
    //   131: invokevirtual 84	bjdg:a	(Lcom/tencent/mobileqq/richmedia/capture/data/MusicItemInfo;)V
    //   134: goto -67 -> 67
    //   137: astore_1
    //   138: aload_0
    //   139: monitorexit
    //   140: aload_1
    //   141: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	142	0	this	bjdm
    //   0	142	1	paramMusicItemInfo	MusicItemInfo
    //   3	127	2	localObject	Object
    //   26	71	3	localbjdg	bjdg
    // Exception table:
    //   from	to	target	type
    //   4	27	137	finally
    //   33	62	137	finally
    //   62	67	137	finally
    //   71	94	137	finally
    //   100	129	137	finally
    //   129	134	137	finally
  }
  
  private void b(MusicItemInfo paramMusicItemInfo)
  {
    if ((this.jdField_a_of_type_Bjdf != null) && (!this.jdField_a_of_type_Boolean) && ((this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo == null) || (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.isMute() != paramMusicItemInfo.isMute()))) {
      this.jdField_a_of_type_Bjdf.a(paramMusicItemInfo.isMute());
    }
  }
  
  private void g()
  {
    if (this.jdField_a_of_type_Bjdg != null)
    {
      f();
      this.jdField_a_of_type_Bjdg.a();
    }
  }
  
  public int a()
  {
    int i = -1;
    if (a()) {
      i = this.jdField_a_of_type_Bjdg.a();
    }
    return i;
  }
  
  public MusicItemInfo a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo == null) {}
    while ((this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.mType != 5) && (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.mType != 1)) {
      return null;
    }
    return this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo;
  }
  
  public void a() {}
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_Bjdf != null) {
      this.jdField_a_of_type_Bjdf.a(true);
    }
    a(-1, -1, paramInt);
  }
  
  public void a(long paramLong)
  {
    if (this.jdField_a_of_type_Bjdg != null) {
      this.jdField_a_of_type_Bjdg.a(paramLong);
    }
  }
  
  public void a(bjdf parambjdf)
  {
    this.jdField_a_of_type_Bjdf = parambjdf;
    if ((!this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo != null) && (this.jdField_a_of_type_Bjdf != null)) {
      this.jdField_a_of_type_Bjdf.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.isMute());
    }
  }
  
  public void a(bjdh parambjdh)
  {
    if ((parambjdh == null) || (this.jdField_a_of_type_JavaUtilList == null)) {
      if (QLog.isColorLevel()) {
        QLog.d("QimMusicPlayer", 2, "addMusicPlayerSceneListener listener = null");
      }
    }
    do
    {
      return;
      if (!this.jdField_a_of_type_JavaUtilList.contains(parambjdh)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("QimMusicPlayer", 2, "addMusicPlayerSceneListener mListeners has listener");
    return;
    this.jdField_a_of_type_JavaUtilList.add(parambjdh);
  }
  
  public void a(MusicItemInfo paramMusicItemInfo)
  {
    if (this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap != null)
    {
      localObject = (bbwg)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramMusicItemInfo.getLocalPath());
      if (localObject != null) {
        QQMusicDownloader.a((bbwg)localObject);
      }
    }
    Object localObject = paramMusicItemInfo.getLocalPath();
    if ((this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null) && (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.contains(localObject))) {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(localObject);
    }
    paramMusicItemInfo.mProgress = -1;
    bjkm.a(paramMusicItemInfo).c();
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_Bjdg != null) && (this.jdField_a_of_type_Bjdg.a());
  }
  
  public boolean a(int paramInt1, int paramInt2, int paramInt3)
  {
    MusicItemInfo localMusicItemInfo = ((QIMMusicConfigManager)bjae.a(2)).a(paramInt1, paramInt2);
    if (localMusicItemInfo != null) {
      return a(localMusicItemInfo, false, paramInt3);
    }
    return false;
  }
  
  public boolean a(MusicItemInfo paramMusicItemInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QimMusicPlayer", 2, "replaceCurMusicInfoForFuturePlay");
    }
    if (!b(paramMusicItemInfo)) {
      return false;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo == paramMusicItemInfo) && (a()))
    {
      QLog.i("QimMusicPlayer", 1, "have playing" + paramMusicItemInfo);
      return false;
    }
    b(paramMusicItemInfo);
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        ((bjdh)localIterator.next()).a(paramMusicItemInfo);
      }
    }
    e();
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo = paramMusicItemInfo;
    this.jdField_b_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo = paramMusicItemInfo;
    this.jdField_a_of_type_Bjdg = a(paramMusicItemInfo);
    return true;
  }
  
  public boolean a(MusicItemInfo paramMusicItemInfo, int paramInt)
  {
    return a(paramMusicItemInfo, false, paramInt);
  }
  
  public boolean a(MusicItemInfo paramMusicItemInfo, bjde parambjde)
  {
    String str;
    if ((!b(paramMusicItemInfo)) && (paramMusicItemInfo != null))
    {
      str = paramMusicItemInfo.getLocalPath();
      if (!TextUtils.isEmpty(str)) {}
    }
    else
    {
      return false;
    }
    if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(str))
    {
      paramMusicItemInfo.mProgress = 0;
      parambjde = new bjdl(this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap, this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap, parambjde);
      bbwg localbbwg = QQMusicDownloader.a(paramMusicItemInfo.mUrl, str, parambjde);
      if (localbbwg != null)
      {
        this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(str, localbbwg);
        QQMusicDownloader.a(localbbwg, parambjde);
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(str, paramMusicItemInfo);
      }
    }
    return true;
  }
  
  public boolean a(MusicItemInfo paramMusicItemInfo, boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QimMusicPlayer", 2, "requestPlay " + paramInt + " " + this.jdField_b_of_type_Int);
    }
    this.jdField_b_of_type_Int = paramInt;
    if (!b(paramMusicItemInfo)) {}
    while ((axgm.a().b()) || (c(paramMusicItemInfo))) {
      return false;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo == paramMusicItemInfo) && (a()) && (!paramBoolean))
    {
      QLog.i("QimMusicPlayer", 1, "have playing" + paramMusicItemInfo);
      return false;
    }
    b(paramMusicItemInfo);
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        ((bjdh)localIterator.next()).a(paramMusicItemInfo);
      }
    }
    e();
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo = paramMusicItemInfo;
    this.jdField_b_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo = paramMusicItemInfo;
    this.jdField_a_of_type_Bjdg = a(paramMusicItemInfo);
    g();
    return true;
  }
  
  public MusicItemInfo b()
  {
    return this.jdField_b_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo;
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo = null;
    this.jdField_b_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo = null;
    this.jdField_a_of_type_Bjdf = null;
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList = null;
    this.jdField_a_of_type_Bjdg = null;
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.values().iterator();
    while (localIterator.hasNext()) {
      ((bjdg)localIterator.next()).f();
    }
    this.jdField_a_of_type_JavaUtilHashMap.clear();
    this.jdField_a_of_type_JavaUtilHashMap = null;
    this.jdField_a_of_type_Blba.a();
    this.jdField_a_of_type_Blba = null;
  }
  
  public void b(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QimMusicPlayer", 2, "pauseMusicCheckScene " + paramInt + " " + this.jdField_b_of_type_Int);
    }
    if (paramInt != this.jdField_b_of_type_Int) {}
    while (this.jdField_a_of_type_Bjdg == null) {
      return;
    }
    this.jdField_a_of_type_Bjdg.c();
  }
  
  public void b(bjdh parambjdh)
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.contains(parambjdh))) {
      this.jdField_a_of_type_JavaUtilList.remove(parambjdh);
    }
  }
  
  public boolean b()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.isMute());
  }
  
  public boolean b(MusicItemInfo paramMusicItemInfo)
  {
    if (paramMusicItemInfo == null) {}
    while (((paramMusicItemInfo.mType == 5) || (paramMusicItemInfo.mType == 1)) && (!bbdj.b(paramMusicItemInfo.getLocalPath()))) {
      return false;
    }
    return true;
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Bjdg != null)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo != null) && (this.jdField_a_of_type_JavaUtilList != null))
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
        while (localIterator.hasNext()) {
          ((bjdh)localIterator.next()).a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo);
        }
      }
      this.jdField_a_of_type_Bjdg.b();
      f();
    }
  }
  
  public void c(int paramInt)
  {
    if (this.jdField_a_of_type_Bjdg != null) {
      this.jdField_a_of_type_Bjdg.jdField_a_of_type_Int = paramInt;
    }
  }
  
  public boolean c()
  {
    int j = this.jdField_a_of_type_Int;
    int i = j;
    if (j == biho.jdField_a_of_type_Int) {
      i = biho.a();
    }
    QQFilterRenderManager localQQFilterRenderManager = biho.a(i);
    FilterDesc localFilterDesc = null;
    if (localQQFilterRenderManager != null) {
      localFilterDesc = localQQFilterRenderManager.getBusinessOperation().getCurrentAVFilterIdByType(2);
    }
    return (localFilterDesc != null) && (QQAVImageFilterConstants.isMusicSpecialFilter(localFilterDesc.id));
  }
  
  public boolean c(MusicItemInfo paramMusicItemInfo)
  {
    if (!this.jdField_b_of_type_Boolean) {}
    while ((a() == -1) || (!paramMusicItemInfo.mSongMid.equals(a().mSongMid)) || (a() >= paramMusicItemInfo.musicDuration)) {
      return false;
    }
    return true;
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_Bjdg != null) {
      this.jdField_a_of_type_Bjdg.c();
    }
  }
  
  public void d(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QimMusicPlayer", 2, "clearMusic ");
    }
    this.jdField_b_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo = null;
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo = null;
    if (this.jdField_a_of_type_Bjdg != null) {
      this.jdField_a_of_type_Bjdg.e();
    }
  }
  
  public void f()
  {
    MusicItemInfo localMusicItemInfo = a();
    if (localMusicItemInfo == null) {}
    label9:
    QQFilterRenderManager localQQFilterRenderManager;
    do
    {
      do
      {
        break label9;
        do
        {
          return;
        } while (this.jdField_a_of_type_Blba == null);
        int j = this.jdField_a_of_type_Int;
        int i = j;
        if (j == biho.jdField_a_of_type_Int) {
          i = biho.a();
        }
        localQQFilterRenderManager = biho.a(i);
        if ((localMusicItemInfo.needPlay()) && (c()))
        {
          if (a()) {}
          for (i = a() - localMusicItemInfo.musicStart;; i = 0)
          {
            this.jdField_a_of_type_Blba.a(localMusicItemInfo, i);
            if (localQQFilterRenderManager == null) {
              break;
            }
            localQQFilterRenderManager.getBusinessOperation().setMusicWaveformSupporter(this);
            return;
          }
        }
      } while ((!localMusicItemInfo.needPlay()) && (!c()));
      this.jdField_a_of_type_Blba.a();
    } while (localQQFilterRenderManager == null);
    localQQFilterRenderManager.getBusinessOperation().setMusicWaveformSupporter(null);
  }
  
  public float getCurrentMusicGain()
  {
    MusicItemInfo localMusicItemInfo = a();
    if (localMusicItemInfo == null) {}
    do
    {
      for (;;)
      {
        return -1.0F;
        try
        {
          if ((this.jdField_a_of_type_Blba != null) && (localMusicItemInfo.needPlay()) && (a()))
          {
            float f = this.jdField_a_of_type_Blba.a(a() - localMusicItemInfo.musicStart);
            return f;
          }
        }
        catch (Exception localException) {}
      }
    } while (!QLog.isColorLevel());
    QLog.e("QimMusicPlayer", 2, "getCurrentMusicGain() error: " + localException.toString());
    return -1.0F;
  }
  
  public MusicItemInfo getMusicItemInfo()
  {
    MusicItemInfo localMusicItemInfo = a();
    if ((localMusicItemInfo != null) && (localMusicItemInfo.needPlay())) {
      return localMusicItemInfo.copy();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjdm
 * JD-Core Version:    0.7.0.1
 */