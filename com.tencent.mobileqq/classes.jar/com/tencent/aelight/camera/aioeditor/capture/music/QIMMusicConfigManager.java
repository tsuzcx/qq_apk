package com.tencent.aelight.camera.aioeditor.capture.music;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.tencent.aelight.camera.aioeditor.capture.control.GetSingleFullMusicInfoTask;
import com.tencent.aelight.camera.aioeditor.capture.control.QIMAsyncManager;
import com.tencent.aelight.camera.aioeditor.capture.data.DoodleMusicCategoryItem;
import com.tencent.aelight.camera.aioeditor.capture.util.QIMFileUtils;
import com.tencent.aelight.camera.qqstory.api.GetMusicInfoCallback;
import com.tencent.aelight.camera.qqstory.api.IAsyncControl;
import com.tencent.aelight.camera.struct.editor.FlowMusic;
import com.tencent.biz.qqstory.utils.FileUtils;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.request.BatchGetMusicInfoRequest;
import com.tencent.biz.videostory.widget.view.smartmusicview.VsMusicItemInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityTransaction;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo;
import com.tencent.mobileqq.transfile.api.IHttpEngineService;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class QIMMusicConfigManager
  extends QIMAsyncManager
{
  public static final File a = new File(QIMFileUtils.a(), "dov_doodle_music");
  public String b = null;
  public String c;
  public EntityManager d = g().getEntityManagerFactory().createEntityManager();
  public DoodleMusicCategoryItem e;
  public MusicItemInfo f;
  public AtomicBoolean g = new AtomicBoolean(false);
  public IHttpEngineService h = (IHttpEngineService)g().getRuntimeService(IHttpEngineService.class, "all");
  protected BroadcastReceiver i = new QIMMusicConfigManager.3(this);
  private boolean j = false;
  private int k = 3;
  private ArrayList<DoodleMusicCategoryItem> l;
  private int m = 0;
  private int n = 0;
  private int o = 0;
  private String p;
  private int q = 2;
  private String r = "我的";
  private ArrayList<DoodleMusicCategoryItem> s;
  private List<FlowMusic> t = new ArrayList();
  private DoodleMusicCategoryItem u;
  private Object v = new Object();
  private List<QIMMusicConfigManager.LoadMusicStepListener> w = new ArrayList();
  
  private int a(MusicItemInfo paramMusicItemInfo)
  {
    Object localObject = this.u;
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QIMMusicConfigManager", 2, "findMusicInfoFromMyTab myTabCategory is null");
      }
      return -1;
    }
    if (((DoodleMusicCategoryItem)localObject).d == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QIMMusicConfigManager", 2, "findMusicInfoFromMyTab myTabCategory.templateGroups is null");
      }
      return -1;
    }
    int i1 = 0;
    while (i1 < this.u.d.size())
    {
      localObject = (MusicItemInfo)this.u.d.get(i1);
      if (((MusicItemInfo)localObject).mItemId == paramMusicItemInfo.mItemId) {
        return i1;
      }
      if ((paramMusicItemInfo.mRecognitionOffset != -1.0F) && (!TextUtils.isEmpty(paramMusicItemInfo.mMusicName)) && (!TextUtils.isEmpty(((MusicItemInfo)localObject).mMusicName)) && (paramMusicItemInfo.mMusicName.equals(((MusicItemInfo)localObject).mMusicName))) {
        return i1;
      }
      i1 += 1;
    }
    return -1;
  }
  
  private DoodleMusicCategoryItem a(MusicItemInfo paramMusicItemInfo1, MusicItemInfo paramMusicItemInfo2, MusicItemInfo paramMusicItemInfo3)
  {
    this.u = new DoodleMusicCategoryItem();
    Object localObject = this.u;
    ((DoodleMusicCategoryItem)localObject).a = 999;
    ((DoodleMusicCategoryItem)localObject).c = this.r;
    localObject = new MusicItemInfo();
    ((MusicItemInfo)localObject).mType = 4;
    ((MusicItemInfo)localObject).mItemId = -3;
    this.u.d = new ArrayList();
    this.u.d.add(paramMusicItemInfo1);
    this.u.d.add(paramMusicItemInfo2);
    this.u.d.add(localObject);
    if (this.o == 1)
    {
      this.u.d.add(paramMusicItemInfo3);
      paramMusicItemInfo3.jumpWs = this.p;
    }
    int i1 = 0;
    while (i1 < this.t.size())
    {
      paramMusicItemInfo1 = (FlowMusic)this.t.get(i1);
      paramMusicItemInfo2 = new MusicItemInfo();
      paramMusicItemInfo2.mType = 5;
      paramMusicItemInfo2.mMusicName = paramMusicItemInfo1.songName;
      paramMusicItemInfo2.setPath(paramMusicItemInfo1.path);
      paramMusicItemInfo2.mUrl = paramMusicItemInfo1.url;
      paramMusicItemInfo2.mSingername = paramMusicItemInfo1.singerName;
      paramMusicItemInfo2.mItemId = paramMusicItemInfo1.songId;
      paramMusicItemInfo2.mSongMid = paramMusicItemInfo1.songMid;
      paramMusicItemInfo2.musicStart = paramMusicItemInfo1.tryBegin;
      paramMusicItemInfo2.musicEnd = paramMusicItemInfo1.tryEnd;
      paramMusicItemInfo2.musicDuration = paramMusicItemInfo1.duration;
      paramMusicItemInfo2.mAlbumUrl = paramMusicItemInfo1.albumUrl;
      this.u.d.add(paramMusicItemInfo2);
      i1 += 1;
    }
    return this.u;
  }
  
  private MusicItemInfo a(JSONObject paramJSONObject, boolean paramBoolean)
  {
    if (paramBoolean) {
      return new VsMusicItemInfo(paramJSONObject);
    }
    MusicItemInfo localMusicItemInfo = new MusicItemInfo();
    localMusicItemInfo.mType = 5;
    localMusicItemInfo.mMusicName = paramJSONObject.optString("title");
    localMusicItemInfo.mSingername = paramJSONObject.optString("desc");
    localMusicItemInfo.mItemId = paramJSONObject.optInt("id");
    localMusicItemInfo.mSongMid = paramJSONObject.optString("mid");
    return localMusicItemInfo;
  }
  
  private void a(DoodleMusicCategoryItem paramDoodleMusicCategoryItem, MusicItemInfo paramMusicItemInfo)
  {
    if (paramDoodleMusicCategoryItem.a != 999)
    {
      if (paramMusicItemInfo.mType != 5) {
        return;
      }
      Iterator localIterator = paramDoodleMusicCategoryItem.d.iterator();
      while (localIterator.hasNext())
      {
        MusicItemInfo localMusicItemInfo = (MusicItemInfo)localIterator.next();
        int i1;
        if (localMusicItemInfo.mType == 5)
        {
          i1 = paramDoodleMusicCategoryItem.d.indexOf(localMusicItemInfo);
          paramDoodleMusicCategoryItem.d.remove(i1);
          paramDoodleMusicCategoryItem.d.add(i1, paramMusicItemInfo);
          return;
        }
        if (localMusicItemInfo.mType == 1)
        {
          i1 = paramDoodleMusicCategoryItem.d.indexOf(localMusicItemInfo);
          paramDoodleMusicCategoryItem.d.add(i1, paramMusicItemInfo);
        }
      }
    }
  }
  
  private void a(FlowMusic paramFlowMusic, long paramLong)
  {
    localEntityTransaction = this.d.getTransaction();
    try
    {
      localEntityTransaction.begin();
      paramFlowMusic.storeTimeStamp = paramLong;
      Object localObject2 = null;
      Iterator localIterator = this.t.iterator();
      do
      {
        localObject1 = localObject2;
        if (!localIterator.hasNext()) {
          break;
        }
        localObject1 = (FlowMusic)localIterator.next();
      } while (((FlowMusic)localObject1).songId != paramFlowMusic.songId);
      if (localObject1 == paramFlowMusic) {
        break label316;
      }
      ((FlowMusic)localObject1).copyFrom(paramFlowMusic);
    }
    finally
    {
      for (;;)
      {
        Object localObject1;
        int i1;
        Collections.sort(this.t);
        localEntityTransaction.commit();
        localEntityTransaction.end();
        for (;;)
        {
          throw paramFlowMusic;
        }
      }
    }
    if (localObject1 != null)
    {
      this.d.update((Entity)localObject1);
    }
    else
    {
      if (this.t.size() < 40)
      {
        this.t.add(0, paramFlowMusic);
      }
      else
      {
        i1 = this.t.size();
        localObject1 = (FlowMusic)this.t.remove(i1 - 1);
        this.d.delete(FlowMusic.class.getSimpleName(), "songName=? and tryBegin=? and tryEnd=?", new String[] { ((FlowMusic)localObject1).songName, String.valueOf(((FlowMusic)localObject1).tryBegin), String.valueOf(((FlowMusic)localObject1).tryEnd) });
        this.t.add(0, paramFlowMusic);
      }
      this.d.persistOrReplace(paramFlowMusic);
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("insert music=");
        ((StringBuilder)localObject1).append(paramFlowMusic);
        QLog.d("QIMMusicConfigManager", 2, ((StringBuilder)localObject1).toString());
      }
    }
    Collections.sort(this.t);
    localEntityTransaction.commit();
    localEntityTransaction.end();
  }
  
  private void b(boolean paramBoolean)
  {
    if (paramBoolean) {
      c(g().getCurrentAccountUin());
    }
  }
  
  private FlowMusic c(int paramInt)
  {
    if (this.t == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QIMMusicConfigManager", 2, "findFlowMusicFromUserList mUserMusicList is null");
      }
      return null;
    }
    int i1 = 0;
    while (i1 < this.t.size())
    {
      FlowMusic localFlowMusic = (FlowMusic)this.t.get(i1);
      if (localFlowMusic.songId == paramInt) {
        return localFlowMusic;
      }
      i1 += 1;
    }
    return null;
  }
  
  public static void c(String paramString)
  {
    SharedPreferences.Editor localEditor = BaseApplicationImpl.getContext().getSharedPreferences("fecth_qq_music", 4).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("fecth_from_qq_music_time_");
    localStringBuilder.append(paramString);
    localEditor.putLong(localStringBuilder.toString(), System.currentTimeMillis());
    localEditor.commit();
  }
  
  public static boolean f()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(a);
    localStringBuilder.append(File.separator);
    localStringBuilder.append("doodle_music_config.cfg");
    boolean bool = new File(localStringBuilder.toString()).exists();
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("QIMMusicConfigManager isStickerConfigFileExist=");
      localStringBuilder.append(bool);
      QLog.i("QIMMusicConfigManager", 2, localStringBuilder.toString());
    }
    return bool;
  }
  
  public MusicItemInfo a(int paramInt)
  {
    Object localObject = this.u;
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QIMMusicConfigManager", 2, "findMusicInfoFromMyTab myTabCategory is null");
      }
      return null;
    }
    if (((DoodleMusicCategoryItem)localObject).d == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QIMMusicConfigManager", 2, "findMusicInfoFromMyTab myTabCategory.templateGroups is null");
      }
      return null;
    }
    int i1 = 0;
    while (i1 < this.u.d.size())
    {
      localObject = (MusicItemInfo)this.u.d.get(i1);
      if (((MusicItemInfo)localObject).mItemId == paramInt) {
        return localObject;
      }
      i1 += 1;
    }
    return null;
  }
  
  public MusicItemInfo a(int paramInt1, int paramInt2)
  {
    try
    {
      Object localObject1 = e();
      if (localObject1 != null)
      {
        localObject1 = ((ArrayList)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          DoodleMusicCategoryItem localDoodleMusicCategoryItem = (DoodleMusicCategoryItem)((Iterator)localObject1).next();
          if (paramInt1 == -1)
          {
            localObject1 = localDoodleMusicCategoryItem.a(paramInt2);
            return localObject1;
          }
          if (localDoodleMusicCategoryItem.a == paramInt1)
          {
            localObject1 = localDoodleMusicCategoryItem.a(paramInt2);
            return localObject1;
          }
        }
      }
      return null;
    }
    finally {}
    for (;;)
    {
      throw localObject2;
    }
  }
  
  /* Error */
  public ArrayList<DoodleMusicCategoryItem> a(boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 91	com/tencent/aelight/camera/aioeditor/capture/music/QIMMusicConfigManager:v	Ljava/lang/Object;
    //   6: astore 4
    //   8: aload 4
    //   10: monitorenter
    //   11: aload_0
    //   12: getfield 98	com/tencent/aelight/camera/aioeditor/capture/music/QIMMusicConfigManager:g	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   15: iconst_1
    //   16: invokevirtual 465	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   19: aload_0
    //   20: getfield 467	com/tencent/aelight/camera/aioeditor/capture/music/QIMMusicConfigManager:l	Ljava/util/ArrayList;
    //   23: ifnonnull +168 -> 191
    //   26: getstatic 60	com/tencent/aelight/camera/aioeditor/capture/music/QIMMusicConfigManager:a	Ljava/io/File;
    //   29: ldc_w 441
    //   32: invokestatic 470	com/tencent/aelight/camera/aioeditor/capture/util/QIMFileUtils:a	(Ljava/io/File;Ljava/lang/String;)Ljava/lang/String;
    //   35: astore 5
    //   37: aload 5
    //   39: ifnull +67 -> 106
    //   42: aload_0
    //   43: aload_0
    //   44: aload 5
    //   46: invokevirtual 473	com/tencent/aelight/camera/aioeditor/capture/music/QIMMusicConfigManager:b	(Ljava/lang/String;)Ljava/util/ArrayList;
    //   49: putfield 467	com/tencent/aelight/camera/aioeditor/capture/music/QIMMusicConfigManager:l	Ljava/util/ArrayList;
    //   52: invokestatic 143	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   55: ifeq +51 -> 106
    //   58: new 367	java/lang/StringBuilder
    //   61: dup
    //   62: invokespecial 368	java/lang/StringBuilder:<init>	()V
    //   65: astore 5
    //   67: aload 5
    //   69: ldc_w 475
    //   72: invokevirtual 374	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: pop
    //   76: aload_0
    //   77: getfield 467	com/tencent/aelight/camera/aioeditor/capture/music/QIMMusicConfigManager:l	Ljava/util/ArrayList;
    //   80: ifnull +567 -> 647
    //   83: iconst_1
    //   84: istore_3
    //   85: goto +3 -> 88
    //   88: aload 5
    //   90: iload_3
    //   91: invokevirtual 451	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   94: pop
    //   95: ldc 145
    //   97: iconst_2
    //   98: aload 5
    //   100: invokevirtual 380	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   103: invokestatic 453	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   106: aload_0
    //   107: getfield 467	com/tencent/aelight/camera/aioeditor/capture/music/QIMMusicConfigManager:l	Ljava/util/ArrayList;
    //   110: ifnull +13 -> 123
    //   113: aload_0
    //   114: getfield 467	com/tencent/aelight/camera/aioeditor/capture/music/QIMMusicConfigManager:l	Ljava/util/ArrayList;
    //   117: invokevirtual 477	java/util/ArrayList:isEmpty	()Z
    //   120: ifeq +71 -> 191
    //   123: aload_0
    //   124: aload_0
    //   125: ldc_w 479
    //   128: invokestatic 481	com/tencent/aelight/camera/aioeditor/capture/util/QIMFileUtils:a	(Ljava/lang/String;)Ljava/lang/String;
    //   131: invokevirtual 473	com/tencent/aelight/camera/aioeditor/capture/music/QIMMusicConfigManager:b	(Ljava/lang/String;)Ljava/util/ArrayList;
    //   134: putfield 467	com/tencent/aelight/camera/aioeditor/capture/music/QIMMusicConfigManager:l	Ljava/util/ArrayList;
    //   137: invokestatic 143	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   140: ifeq +51 -> 191
    //   143: new 367	java/lang/StringBuilder
    //   146: dup
    //   147: invokespecial 368	java/lang/StringBuilder:<init>	()V
    //   150: astore 5
    //   152: aload 5
    //   154: ldc_w 483
    //   157: invokevirtual 374	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: pop
    //   161: aload_0
    //   162: getfield 467	com/tencent/aelight/camera/aioeditor/capture/music/QIMMusicConfigManager:l	Ljava/util/ArrayList;
    //   165: ifnull +487 -> 652
    //   168: iconst_1
    //   169: istore_3
    //   170: goto +3 -> 173
    //   173: aload 5
    //   175: iload_3
    //   176: invokevirtual 451	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   179: pop
    //   180: ldc 145
    //   182: iconst_2
    //   183: aload 5
    //   185: invokevirtual 380	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   188: invokestatic 453	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   191: aload_0
    //   192: getfield 137	com/tencent/aelight/camera/aioeditor/capture/music/QIMMusicConfigManager:u	Lcom/tencent/aelight/camera/aioeditor/capture/data/DoodleMusicCategoryItem;
    //   195: ifnull +462 -> 657
    //   198: aload_0
    //   199: getfield 137	com/tencent/aelight/camera/aioeditor/capture/music/QIMMusicConfigManager:u	Lcom/tencent/aelight/camera/aioeditor/capture/data/DoodleMusicCategoryItem;
    //   202: getfield 154	com/tencent/aelight/camera/aioeditor/capture/data/DoodleMusicCategoryItem:d	Ljava/util/List;
    //   205: invokeinterface 162 1 0
    //   210: aload_0
    //   211: getfield 86	com/tencent/aelight/camera/aioeditor/capture/music/QIMMusicConfigManager:t	Ljava/util/List;
    //   214: invokeinterface 162 1 0
    //   219: aload_0
    //   220: getfield 67	com/tencent/aelight/camera/aioeditor/capture/music/QIMMusicConfigManager:k	I
    //   223: iadd
    //   224: if_icmpeq +433 -> 657
    //   227: iconst_1
    //   228: istore_2
    //   229: goto +3 -> 232
    //   232: aload_0
    //   233: getfield 485	com/tencent/aelight/camera/aioeditor/capture/music/QIMMusicConfigManager:s	Ljava/util/ArrayList;
    //   236: ifnull +11 -> 247
    //   239: iload_1
    //   240: ifne +7 -> 247
    //   243: iload_2
    //   244: ifeq +360 -> 604
    //   247: aload_0
    //   248: getfield 467	com/tencent/aelight/camera/aioeditor/capture/music/QIMMusicConfigManager:l	Ljava/util/ArrayList;
    //   251: ifnonnull +8 -> 259
    //   254: iconst_0
    //   255: istore_2
    //   256: goto +11 -> 267
    //   259: aload_0
    //   260: getfield 467	com/tencent/aelight/camera/aioeditor/capture/music/QIMMusicConfigManager:l	Ljava/util/ArrayList;
    //   263: invokevirtual 486	java/util/ArrayList:size	()I
    //   266: istore_2
    //   267: aload_0
    //   268: new 83	java/util/ArrayList
    //   271: dup
    //   272: iload_2
    //   273: invokespecial 489	java/util/ArrayList:<init>	(I)V
    //   276: putfield 485	com/tencent/aelight/camera/aioeditor/capture/music/QIMMusicConfigManager:s	Ljava/util/ArrayList;
    //   279: new 168	com/tencent/mobileqq/richmedia/capture/data/MusicItemInfo
    //   282: dup
    //   283: invokespecial 198	com/tencent/mobileqq/richmedia/capture/data/MusicItemInfo:<init>	()V
    //   286: astore 5
    //   288: aload 5
    //   290: iconst_2
    //   291: putfield 201	com/tencent/mobileqq/richmedia/capture/data/MusicItemInfo:mType	I
    //   294: aload 5
    //   296: iconst_m1
    //   297: putfield 171	com/tencent/mobileqq/richmedia/capture/data/MusicItemInfo:mItemId	I
    //   300: new 168	com/tencent/mobileqq/richmedia/capture/data/MusicItemInfo
    //   303: dup
    //   304: invokespecial 198	com/tencent/mobileqq/richmedia/capture/data/MusicItemInfo:<init>	()V
    //   307: astore 6
    //   309: aload 6
    //   311: iconst_3
    //   312: putfield 201	com/tencent/mobileqq/richmedia/capture/data/MusicItemInfo:mType	I
    //   315: aload 6
    //   317: bipush 254
    //   319: putfield 171	com/tencent/mobileqq/richmedia/capture/data/MusicItemInfo:mItemId	I
    //   322: new 168	com/tencent/mobileqq/richmedia/capture/data/MusicItemInfo
    //   325: dup
    //   326: invokespecial 198	com/tencent/mobileqq/richmedia/capture/data/MusicItemInfo:<init>	()V
    //   329: astore 7
    //   331: aload 7
    //   333: bipush 10
    //   335: putfield 201	com/tencent/mobileqq/richmedia/capture/data/MusicItemInfo:mType	I
    //   338: aload 7
    //   340: bipush 249
    //   342: putfield 171	com/tencent/mobileqq/richmedia/capture/data/MusicItemInfo:mItemId	I
    //   345: aload_0
    //   346: getfield 467	com/tencent/aelight/camera/aioeditor/capture/music/QIMMusicConfigManager:l	Ljava/util/ArrayList;
    //   349: ifnull +198 -> 547
    //   352: aload_0
    //   353: getfield 467	com/tencent/aelight/camera/aioeditor/capture/music/QIMMusicConfigManager:l	Ljava/util/ArrayList;
    //   356: invokevirtual 459	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   359: astore 8
    //   361: aload 8
    //   363: invokeinterface 304 1 0
    //   368: ifeq +179 -> 547
    //   371: aload 8
    //   373: invokeinterface 308 1 0
    //   378: checkcast 152	com/tencent/aelight/camera/aioeditor/capture/data/DoodleMusicCategoryItem
    //   381: astore 9
    //   383: aload 9
    //   385: getfield 154	com/tencent/aelight/camera/aioeditor/capture/data/DoodleMusicCategoryItem:d	Ljava/util/List;
    //   388: ifnull -27 -> 361
    //   391: aload 9
    //   393: getfield 154	com/tencent/aelight/camera/aioeditor/capture/data/DoodleMusicCategoryItem:d	Ljava/util/List;
    //   396: invokeinterface 162 1 0
    //   401: ifle -40 -> 361
    //   404: aload 9
    //   406: invokevirtual 492	com/tencent/aelight/camera/aioeditor/capture/data/DoodleMusicCategoryItem:a	()Lcom/tencent/aelight/camera/aioeditor/capture/data/DoodleMusicCategoryItem;
    //   409: astore 10
    //   411: new 83	java/util/ArrayList
    //   414: dup
    //   415: invokespecial 84	java/util/ArrayList:<init>	()V
    //   418: astore 11
    //   420: aload 11
    //   422: aload 5
    //   424: invokeinterface 204 2 0
    //   429: pop
    //   430: aload 11
    //   432: aload 6
    //   434: invokeinterface 204 2 0
    //   439: pop
    //   440: aload_0
    //   441: iconst_3
    //   442: putfield 67	com/tencent/aelight/camera/aioeditor/capture/music/QIMMusicConfigManager:k	I
    //   445: aload_0
    //   446: getfield 494	com/tencent/aelight/camera/aioeditor/capture/music/QIMMusicConfigManager:e	Lcom/tencent/aelight/camera/aioeditor/capture/data/DoodleMusicCategoryItem;
    //   449: ifnull +45 -> 494
    //   452: aload_0
    //   453: getfield 494	com/tencent/aelight/camera/aioeditor/capture/music/QIMMusicConfigManager:e	Lcom/tencent/aelight/camera/aioeditor/capture/data/DoodleMusicCategoryItem;
    //   456: getfield 154	com/tencent/aelight/camera/aioeditor/capture/data/DoodleMusicCategoryItem:d	Ljava/util/List;
    //   459: ifnull +35 -> 494
    //   462: aload_0
    //   463: getfield 494	com/tencent/aelight/camera/aioeditor/capture/music/QIMMusicConfigManager:e	Lcom/tencent/aelight/camera/aioeditor/capture/data/DoodleMusicCategoryItem;
    //   466: getfield 195	com/tencent/aelight/camera/aioeditor/capture/data/DoodleMusicCategoryItem:a	I
    //   469: aload 9
    //   471: getfield 195	com/tencent/aelight/camera/aioeditor/capture/data/DoodleMusicCategoryItem:a	I
    //   474: if_icmpne +20 -> 494
    //   477: aload_0
    //   478: getfield 496	com/tencent/aelight/camera/aioeditor/capture/music/QIMMusicConfigManager:f	Lcom/tencent/mobileqq/richmedia/capture/data/MusicItemInfo;
    //   481: ifnull +13 -> 494
    //   484: aload_0
    //   485: aload 9
    //   487: aload_0
    //   488: getfield 496	com/tencent/aelight/camera/aioeditor/capture/music/QIMMusicConfigManager:f	Lcom/tencent/mobileqq/richmedia/capture/data/MusicItemInfo;
    //   491: invokespecial 498	com/tencent/aelight/camera/aioeditor/capture/music/QIMMusicConfigManager:a	(Lcom/tencent/aelight/camera/aioeditor/capture/data/DoodleMusicCategoryItem;Lcom/tencent/mobileqq/richmedia/capture/data/MusicItemInfo;)V
    //   494: iload_1
    //   495: ifeq +19 -> 514
    //   498: aload 9
    //   500: getfield 500	com/tencent/aelight/camera/aioeditor/capture/data/DoodleMusicCategoryItem:b	Z
    //   503: ifeq +11 -> 514
    //   506: aload 9
    //   508: getfield 154	com/tencent/aelight/camera/aioeditor/capture/data/DoodleMusicCategoryItem:d	Ljava/util/List;
    //   511: invokestatic 503	java/util/Collections:shuffle	(Ljava/util/List;)V
    //   514: aload 11
    //   516: aload 9
    //   518: getfield 154	com/tencent/aelight/camera/aioeditor/capture/data/DoodleMusicCategoryItem:d	Ljava/util/List;
    //   521: invokeinterface 507 2 0
    //   526: pop
    //   527: aload 10
    //   529: aload 11
    //   531: putfield 154	com/tencent/aelight/camera/aioeditor/capture/data/DoodleMusicCategoryItem:d	Ljava/util/List;
    //   534: aload_0
    //   535: getfield 485	com/tencent/aelight/camera/aioeditor/capture/music/QIMMusicConfigManager:s	Ljava/util/ArrayList;
    //   538: aload 10
    //   540: invokevirtual 508	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   543: pop
    //   544: goto -183 -> 361
    //   547: aload_0
    //   548: getfield 71	com/tencent/aelight/camera/aioeditor/capture/music/QIMMusicConfigManager:m	I
    //   551: iconst_1
    //   552: if_icmpne +52 -> 604
    //   555: aload_0
    //   556: getfield 77	com/tencent/aelight/camera/aioeditor/capture/music/QIMMusicConfigManager:q	I
    //   559: iconst_1
    //   560: if_icmplt +44 -> 604
    //   563: aload_0
    //   564: getfield 77	com/tencent/aelight/camera/aioeditor/capture/music/QIMMusicConfigManager:q	I
    //   567: aload_0
    //   568: getfield 485	com/tencent/aelight/camera/aioeditor/capture/music/QIMMusicConfigManager:s	Ljava/util/ArrayList;
    //   571: invokevirtual 486	java/util/ArrayList:size	()I
    //   574: if_icmpgt +30 -> 604
    //   577: aload_0
    //   578: aload 5
    //   580: aload 6
    //   582: aload 7
    //   584: invokespecial 510	com/tencent/aelight/camera/aioeditor/capture/music/QIMMusicConfigManager:a	(Lcom/tencent/mobileqq/richmedia/capture/data/MusicItemInfo;Lcom/tencent/mobileqq/richmedia/capture/data/MusicItemInfo;Lcom/tencent/mobileqq/richmedia/capture/data/MusicItemInfo;)Lcom/tencent/aelight/camera/aioeditor/capture/data/DoodleMusicCategoryItem;
    //   587: astore 5
    //   589: aload_0
    //   590: getfield 485	com/tencent/aelight/camera/aioeditor/capture/music/QIMMusicConfigManager:s	Ljava/util/ArrayList;
    //   593: aload_0
    //   594: getfield 77	com/tencent/aelight/camera/aioeditor/capture/music/QIMMusicConfigManager:q	I
    //   597: iconst_1
    //   598: isub
    //   599: aload 5
    //   601: invokevirtual 511	java/util/ArrayList:add	(ILjava/lang/Object;)V
    //   604: aload_0
    //   605: getfield 98	com/tencent/aelight/camera/aioeditor/capture/music/QIMMusicConfigManager:g	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   608: iconst_0
    //   609: invokevirtual 465	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   612: aload_0
    //   613: getfield 485	com/tencent/aelight/camera/aioeditor/capture/music/QIMMusicConfigManager:s	Ljava/util/ArrayList;
    //   616: astore 5
    //   618: aload 4
    //   620: monitorexit
    //   621: aload_0
    //   622: monitorexit
    //   623: aload 5
    //   625: areturn
    //   626: astore 5
    //   628: aload 4
    //   630: monitorexit
    //   631: aload 5
    //   633: athrow
    //   634: astore 4
    //   636: aload_0
    //   637: monitorexit
    //   638: goto +6 -> 644
    //   641: aload 4
    //   643: athrow
    //   644: goto -3 -> 641
    //   647: iconst_0
    //   648: istore_3
    //   649: goto -561 -> 88
    //   652: iconst_0
    //   653: istore_3
    //   654: goto -481 -> 173
    //   657: iconst_0
    //   658: istore_2
    //   659: goto -427 -> 232
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	662	0	this	QIMMusicConfigManager
    //   0	662	1	paramBoolean	boolean
    //   228	431	2	i1	int
    //   84	570	3	bool	boolean
    //   634	8	4	localObject2	Object
    //   35	589	5	localObject3	Object
    //   626	6	5	localObject4	Object
    //   307	274	6	localMusicItemInfo1	MusicItemInfo
    //   329	254	7	localMusicItemInfo2	MusicItemInfo
    //   359	13	8	localIterator	Iterator
    //   381	136	9	localDoodleMusicCategoryItem1	DoodleMusicCategoryItem
    //   409	130	10	localDoodleMusicCategoryItem2	DoodleMusicCategoryItem
    //   418	112	11	localArrayList	ArrayList
    // Exception table:
    //   from	to	target	type
    //   11	37	626	finally
    //   42	83	626	finally
    //   88	106	626	finally
    //   106	123	626	finally
    //   123	168	626	finally
    //   173	191	626	finally
    //   191	227	626	finally
    //   232	239	626	finally
    //   247	254	626	finally
    //   259	267	626	finally
    //   267	361	626	finally
    //   361	494	626	finally
    //   498	514	626	finally
    //   514	544	626	finally
    //   547	604	626	finally
    //   604	621	626	finally
    //   628	631	626	finally
    //   2	11	634	finally
    //   631	634	634	finally
  }
  
  public void a(int paramInt, boolean paramBoolean, Object paramObject)
  {
    StringBuilder localStringBuilder;
    if (paramBoolean)
    {
      if (paramInt == 4)
      {
        this.t.addAll((Collection)paramObject);
        Collections.sort(this.t);
      }
      if (((paramObject instanceof String)) && (QLog.isColorLevel()))
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("onStepCall successed, step=");
        localStringBuilder.append(paramInt);
        localStringBuilder.append(", msg=");
        localStringBuilder.append(paramObject);
        QLog.d("QIMMusicConfigManager", 2, localStringBuilder.toString());
      }
    }
    else if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onStepCall failed, step=");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(", msg=");
      localStringBuilder.append(paramObject);
      QLog.d("QIMMusicConfigManager", 2, localStringBuilder.toString());
    }
    ThreadManager.getUIHandler().post(new QIMMusicConfigManager.1(this, paramInt, paramBoolean, paramObject));
  }
  
  public void a(QIMMusicConfigManager.LoadMusicStepListener paramLoadMusicStepListener)
  {
    if (paramLoadMusicStepListener != null)
    {
      List localList = this.w;
      if (localList != null)
      {
        if (localList.contains(paramLoadMusicStepListener))
        {
          if (QLog.isColorLevel()) {
            QLog.d("QIMMusicConfigManager", 2, "addLoadMusicListener mListeners has listener");
          }
          return;
        }
        this.w.add(paramLoadMusicStepListener);
        return;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("QIMMusicConfigManager", 2, "addLoadMusicListener listener = null");
    }
  }
  
  public void a(MusicItemInfo paramMusicItemInfo, boolean paramBoolean)
  {
    synchronized (this.v)
    {
      Object localObject1;
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("addOrUpdateMytabMusic, lock updateTimeStamp=");
        ((StringBuilder)localObject1).append(paramBoolean);
        QLog.d("QIMMusicConfigManager", 2, ((StringBuilder)localObject1).toString());
      }
      if ((this.u != null) && (this.u.d != null))
      {
        localObject1 = this.u.d;
        int i1 = a(paramMusicItemInfo);
        long l2 = System.currentTimeMillis();
        Object localObject2;
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("addOrUpdateMytabMusic, index=");
          ((StringBuilder)localObject2).append(i1);
          QLog.d("QIMMusicConfigManager", 2, ((StringBuilder)localObject2).toString());
        }
        long l1;
        if (i1 == -1)
        {
          if (((List)localObject1).size() < this.k + 40)
          {
            ((List)localObject1).add(this.k, paramMusicItemInfo);
          }
          else
          {
            localObject2 = (MusicItemInfo)((List)localObject1).remove(((List)localObject1).size() - 1);
            if (!TextUtils.isEmpty(((MusicItemInfo)localObject2).getLocalPath()))
            {
              FileUtils.c(new File(((MusicItemInfo)localObject2).getLocalPath()));
              if (QLog.isColorLevel())
              {
                StringBuilder localStringBuilder = new StringBuilder();
                localStringBuilder.append("delete file=");
                localStringBuilder.append(((MusicItemInfo)localObject2).mMusicName);
                QLog.d("QIMMusicConfigManager", 2, localStringBuilder.toString());
              }
            }
            ((List)localObject1).add(this.k, paramMusicItemInfo);
          }
          localObject1 = new FlowMusic(paramMusicItemInfo);
          l1 = l2;
        }
        else if ((i1 != this.k) && (paramBoolean))
        {
          ((List)localObject1).remove(i1);
          ((List)localObject1).add(this.k, paramMusicItemInfo);
          localObject2 = c(paramMusicItemInfo.mItemId);
          l1 = l2;
          localObject1 = localObject2;
          if (localObject2 != null)
          {
            ((FlowMusic)localObject2).sourceType = 0;
            l1 = l2;
            localObject1 = localObject2;
          }
        }
        else
        {
          ((List)localObject1).remove(i1);
          ((List)localObject1).add(i1, paramMusicItemInfo);
          localObject2 = c(paramMusicItemInfo.mItemId);
          l1 = l2;
          localObject1 = localObject2;
          if (localObject2 != null)
          {
            ((FlowMusic)localObject2).sourceType = 0;
            l1 = ((FlowMusic)localObject2).storeTimeStamp;
            localObject1 = localObject2;
          }
        }
        if (localObject1 != null)
        {
          ((FlowMusic)localObject1).tryBegin = paramMusicItemInfo.musicStart;
          ((FlowMusic)localObject1).tryEnd = paramMusicItemInfo.musicEnd;
          ((FlowMusic)localObject1).url = paramMusicItemInfo.mUrl;
          ((FlowMusic)localObject1).path = paramMusicItemInfo.getLocalPath();
          ((FlowMusic)localObject1).duration = paramMusicItemInfo.musicDuration;
          a((FlowMusic)localObject1, l1);
        }
        if (this.w != null)
        {
          localObject1 = this.w.iterator();
          while (((Iterator)localObject1).hasNext()) {
            ((QIMMusicConfigManager.LoadMusicStepListener)((Iterator)localObject1).next()).a(5, true, paramMusicItemInfo);
          }
        }
        if (QLog.isColorLevel()) {
          QLog.d("QIMMusicConfigManager", 2, "addOrUpdateMytabMusic, unlock");
        }
        return;
      }
      return;
    }
    for (;;)
    {
      throw paramMusicItemInfo;
    }
  }
  
  public void a(String paramString)
  {
    this.l = b(paramString);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("handleDoodleMusicConfig");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" result:");
      boolean bool;
      if (this.l != null) {
        bool = true;
      } else {
        bool = false;
      }
      localStringBuilder.append(bool);
      QLog.i("QIMMusicConfigManager", 2, localStringBuilder.toString());
    }
    QIMFileUtils.a(a, "doodle_music_config.cfg", paramString);
    PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.sApplication).edit().putInt("show_wstab", this.n).commit();
  }
  
  public void a(String paramString, boolean paramBoolean, GetMusicInfoCallback paramGetMusicInfoCallback)
  {
    if (paramBoolean)
    {
      QLog.i("QIMMusicConfigManager", 1, "getSingleFullMusicInfo instance is VsMusicItemInfo though videoStory cmd");
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(paramString);
      VSNetworkHelper.getInstance().sendRequest(new BatchGetMusicInfoRequest(localArrayList), new QIMMusicConfigManager.2(this, paramGetMusicInfoCallback));
      return;
    }
    ThreadManager.executeOnSubThread(new GetSingleFullMusicInfoTask(paramString, paramGetMusicInfoCallback));
  }
  
  public MusicItemInfo b(int paramInt)
  {
    Object localObject1 = null;
    MusicItemInfo localMusicItemInfo = null;
    try
    {
      Object localObject3 = e();
      if (localObject3 != null)
      {
        localObject3 = ((ArrayList)localObject3).iterator();
        localObject1 = localMusicItemInfo;
        while (((Iterator)localObject3).hasNext())
        {
          localMusicItemInfo = ((DoodleMusicCategoryItem)((Iterator)localObject3).next()).a(paramInt);
          localObject1 = localMusicItemInfo;
          if (localMusicItemInfo != null) {
            localObject1 = localMusicItemInfo;
          }
        }
      }
      return localObject1;
    }
    finally {}
    for (;;)
    {
      throw localObject2;
    }
  }
  
  public ArrayList<DoodleMusicCategoryItem> b(String paramString)
  {
    ArrayList localArrayList = new ArrayList(4);
    try
    {
      paramString = new JSONObject(paramString);
      if (paramString.has("showMine")) {
        this.m = paramString.getInt("showMine");
      }
      if (paramString.has("showWsTab")) {
        this.n = paramString.getInt("showWsTab");
      }
      if (paramString.has("showMusicWs")) {
        this.o = paramString.getInt("showMusicWs");
      }
      if (paramString.has("jumpWsTab")) {
        this.c = paramString.getString("jumpWsTab");
      }
      if (paramString.has("jumpWsMusic")) {
        this.p = paramString.getString("jumpWsMusic");
      }
      if (paramString.has("mineIndex")) {
        this.q = paramString.getInt("mineIndex");
      }
      if (paramString.has("mineCategoryName")) {
        this.r = paramString.getString("mineCategoryName");
      }
      paramString = paramString.getJSONArray("category");
      localArrayList.ensureCapacity(paramString.length());
      int i1 = 0;
      while (i1 < paramString.length())
      {
        localArrayList.add(new DoodleMusicCategoryItem(paramString.getJSONObject(i1)));
        i1 += 1;
      }
      return localArrayList;
    }
    catch (JSONException paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.e("QIMMusicConfigManager", 2, QLog.getStackTraceString(paramString));
      }
    }
    return null;
  }
  
  public void b()
  {
    AppInterface localAppInterface = g();
    if (localAppInterface != null)
    {
      IntentFilter localIntentFilter = new IntentFilter("com.tencent.mobileqq.action.ACTION_WEBVIEW_DISPATCH_EVENT");
      localAppInterface.getApp().registerReceiver(this.i, localIntentFilter);
      e();
      g().notifyObservers(CaptureConfigUpdateObserver.class, 1, true, null);
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("QIMMusicConfigManager", 4, "initMusicConfig");
    }
  }
  
  public void b(QIMMusicConfigManager.LoadMusicStepListener paramLoadMusicStepListener)
  {
    if (this.w.contains(paramLoadMusicStepListener)) {
      this.w.remove(paramLoadMusicStepListener);
    }
  }
  
  public void d()
  {
    AppInterface localAppInterface = g();
    if (localAppInterface != null) {
      localAppInterface.getApp().unregisterReceiver(this.i);
    }
  }
  
  public ArrayList<DoodleMusicCategoryItem> e()
  {
    try
    {
      boolean bool = this.g.compareAndSet(true, true);
      if (bool) {
        return null;
      }
      ArrayList localArrayList = a(false);
      return localArrayList;
    }
    finally {}
  }
  
  public void h()
  {
    this.t.clear();
    ((IAsyncControl)QRoute.api(IAsyncControl.class)).startAsyncStep(1009);
    Object localObject = g().getCurrentAccountUin();
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getContext().getSharedPreferences("fecth_qq_music", 4);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("fecth_from_qq_music_time_");
    localStringBuilder.append((String)localObject);
    long l1 = localSharedPreferences.getLong(localStringBuilder.toString(), 0L);
    int i1;
    if ((System.currentTimeMillis() - l1 > 86400000L) && (NetworkUtil.isWifiEnabled(BaseApplicationImpl.sApplication))) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    if ((l1 == 0L) || (i1 != 0))
    {
      localObject = g().getCurrentAccountUin();
      if (localObject != null)
      {
        this.b = ((String)localObject);
        new QIMMusicConfigManager.GetQQMusicSongListTask(this, this).b();
      }
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("checkMyFavoriteUpgradeInQQMusic, lastFetchTime = ");
      ((StringBuilder)localObject).append(l1);
      QLog.d("QIMMusicConfigManager", 2, ((StringBuilder)localObject).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.music.QIMMusicConfigManager
 * JD-Core Version:    0.7.0.1
 */