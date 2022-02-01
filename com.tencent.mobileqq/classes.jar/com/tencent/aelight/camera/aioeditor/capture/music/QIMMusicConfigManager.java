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
  public static final File a;
  private int jdField_a_of_type_Int = 3;
  protected BroadcastReceiver a;
  public DoodleMusicCategoryItem a;
  public EntityManager a;
  public MusicItemInfo a;
  public IHttpEngineService a;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  public String a;
  private ArrayList<DoodleMusicCategoryItem> jdField_a_of_type_JavaUtilArrayList;
  private List<FlowMusic> jdField_a_of_type_JavaUtilList = new ArrayList();
  public AtomicBoolean a;
  private boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int = 0;
  private DoodleMusicCategoryItem jdField_b_of_type_ComTencentAelightCameraAioeditorCaptureDataDoodleMusicCategoryItem;
  public String b;
  private ArrayList<DoodleMusicCategoryItem> jdField_b_of_type_JavaUtilArrayList;
  private List<QIMMusicConfigManager.LoadMusicStepListener> jdField_b_of_type_JavaUtilList = new ArrayList();
  private int jdField_c_of_type_Int = 0;
  private String jdField_c_of_type_JavaLangString;
  private int jdField_d_of_type_Int = 0;
  private String jdField_d_of_type_JavaLangString = "我的";
  private int e = 2;
  
  static
  {
    jdField_a_of_type_JavaIoFile = new File(QIMFileUtils.a(), "dov_doodle_music");
  }
  
  public QIMMusicConfigManager()
  {
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new QIMMusicConfigManager.3(this);
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = a().getEntityManagerFactory().createEntityManager();
    this.jdField_a_of_type_ComTencentMobileqqTransfileApiIHttpEngineService = ((IHttpEngineService)a().getRuntimeService(IHttpEngineService.class, "all"));
  }
  
  private int a(MusicItemInfo paramMusicItemInfo)
  {
    Object localObject = this.jdField_b_of_type_ComTencentAelightCameraAioeditorCaptureDataDoodleMusicCategoryItem;
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QIMMusicConfigManager", 2, "findMusicInfoFromMyTab myTabCategory is null");
      }
      return -1;
    }
    if (((DoodleMusicCategoryItem)localObject).jdField_a_of_type_JavaUtilList == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QIMMusicConfigManager", 2, "findMusicInfoFromMyTab myTabCategory.templateGroups is null");
      }
      return -1;
    }
    int i = 0;
    while (i < this.jdField_b_of_type_ComTencentAelightCameraAioeditorCaptureDataDoodleMusicCategoryItem.jdField_a_of_type_JavaUtilList.size())
    {
      localObject = (MusicItemInfo)this.jdField_b_of_type_ComTencentAelightCameraAioeditorCaptureDataDoodleMusicCategoryItem.jdField_a_of_type_JavaUtilList.get(i);
      if (((MusicItemInfo)localObject).mItemId == paramMusicItemInfo.mItemId) {
        return i;
      }
      if ((paramMusicItemInfo.mRecognitionOffset != -1.0F) && (!TextUtils.isEmpty(paramMusicItemInfo.mMusicName)) && (!TextUtils.isEmpty(((MusicItemInfo)localObject).mMusicName)) && (paramMusicItemInfo.mMusicName.equals(((MusicItemInfo)localObject).mMusicName))) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  private DoodleMusicCategoryItem a(MusicItemInfo paramMusicItemInfo1, MusicItemInfo paramMusicItemInfo2, MusicItemInfo paramMusicItemInfo3)
  {
    this.jdField_b_of_type_ComTencentAelightCameraAioeditorCaptureDataDoodleMusicCategoryItem = new DoodleMusicCategoryItem();
    Object localObject = this.jdField_b_of_type_ComTencentAelightCameraAioeditorCaptureDataDoodleMusicCategoryItem;
    ((DoodleMusicCategoryItem)localObject).jdField_a_of_type_Int = 999;
    ((DoodleMusicCategoryItem)localObject).jdField_a_of_type_JavaLangString = this.jdField_d_of_type_JavaLangString;
    localObject = new MusicItemInfo();
    ((MusicItemInfo)localObject).mType = 4;
    ((MusicItemInfo)localObject).mItemId = -3;
    this.jdField_b_of_type_ComTencentAelightCameraAioeditorCaptureDataDoodleMusicCategoryItem.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_b_of_type_ComTencentAelightCameraAioeditorCaptureDataDoodleMusicCategoryItem.jdField_a_of_type_JavaUtilList.add(paramMusicItemInfo1);
    this.jdField_b_of_type_ComTencentAelightCameraAioeditorCaptureDataDoodleMusicCategoryItem.jdField_a_of_type_JavaUtilList.add(paramMusicItemInfo2);
    this.jdField_b_of_type_ComTencentAelightCameraAioeditorCaptureDataDoodleMusicCategoryItem.jdField_a_of_type_JavaUtilList.add(localObject);
    if (this.jdField_d_of_type_Int == 1)
    {
      this.jdField_b_of_type_ComTencentAelightCameraAioeditorCaptureDataDoodleMusicCategoryItem.jdField_a_of_type_JavaUtilList.add(paramMusicItemInfo3);
      paramMusicItemInfo3.jumpWs = this.jdField_c_of_type_JavaLangString;
    }
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      paramMusicItemInfo1 = (FlowMusic)this.jdField_a_of_type_JavaUtilList.get(i);
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
      this.jdField_b_of_type_ComTencentAelightCameraAioeditorCaptureDataDoodleMusicCategoryItem.jdField_a_of_type_JavaUtilList.add(paramMusicItemInfo2);
      i += 1;
    }
    return this.jdField_b_of_type_ComTencentAelightCameraAioeditorCaptureDataDoodleMusicCategoryItem;
  }
  
  private FlowMusic a(int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilList == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QIMMusicConfigManager", 2, "findFlowMusicFromUserList mUserMusicList is null");
      }
      return null;
    }
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      FlowMusic localFlowMusic = (FlowMusic)this.jdField_a_of_type_JavaUtilList.get(i);
      if (localFlowMusic.songId == paramInt) {
        return localFlowMusic;
      }
      i += 1;
    }
    return null;
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
    if (paramDoodleMusicCategoryItem.jdField_a_of_type_Int != 999)
    {
      if (paramMusicItemInfo.mType != 5) {
        return;
      }
      Iterator localIterator = paramDoodleMusicCategoryItem.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        MusicItemInfo localMusicItemInfo = (MusicItemInfo)localIterator.next();
        int i;
        if (localMusicItemInfo.mType == 5)
        {
          i = paramDoodleMusicCategoryItem.jdField_a_of_type_JavaUtilList.indexOf(localMusicItemInfo);
          paramDoodleMusicCategoryItem.jdField_a_of_type_JavaUtilList.remove(i);
          paramDoodleMusicCategoryItem.jdField_a_of_type_JavaUtilList.add(i, paramMusicItemInfo);
          return;
        }
        if (localMusicItemInfo.mType == 1)
        {
          i = paramDoodleMusicCategoryItem.jdField_a_of_type_JavaUtilList.indexOf(localMusicItemInfo);
          paramDoodleMusicCategoryItem.jdField_a_of_type_JavaUtilList.add(i, paramMusicItemInfo);
        }
      }
    }
  }
  
  private void a(FlowMusic paramFlowMusic, long paramLong)
  {
    localEntityTransaction = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.getTransaction();
    try
    {
      localEntityTransaction.begin();
      paramFlowMusic.storeTimeStamp = paramLong;
      Object localObject2 = null;
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
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
        int i;
        Collections.sort(this.jdField_a_of_type_JavaUtilList);
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
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.update((Entity)localObject1);
    }
    else
    {
      if (this.jdField_a_of_type_JavaUtilList.size() < 40)
      {
        this.jdField_a_of_type_JavaUtilList.add(0, paramFlowMusic);
      }
      else
      {
        i = this.jdField_a_of_type_JavaUtilList.size();
        localObject1 = (FlowMusic)this.jdField_a_of_type_JavaUtilList.remove(i - 1);
        this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.delete(FlowMusic.class.getSimpleName(), "songName=? and tryBegin=? and tryEnd=?", new String[] { ((FlowMusic)localObject1).songName, String.valueOf(((FlowMusic)localObject1).tryBegin), String.valueOf(((FlowMusic)localObject1).tryEnd) });
        this.jdField_a_of_type_JavaUtilList.add(0, paramFlowMusic);
      }
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.persistOrReplace(paramFlowMusic);
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("insert music=");
        ((StringBuilder)localObject1).append(paramFlowMusic);
        QLog.d("QIMMusicConfigManager", 2, ((StringBuilder)localObject1).toString());
      }
    }
    Collections.sort(this.jdField_a_of_type_JavaUtilList);
    localEntityTransaction.commit();
    localEntityTransaction.end();
  }
  
  private void a(boolean paramBoolean)
  {
    if (paramBoolean) {
      b(a().getCurrentAccountUin());
    }
  }
  
  public static boolean a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(jdField_a_of_type_JavaIoFile);
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
  
  public static void b(String paramString)
  {
    SharedPreferences.Editor localEditor = BaseApplicationImpl.getContext().getSharedPreferences("fecth_qq_music", 4).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("fecth_from_qq_music_time_");
    localStringBuilder.append(paramString);
    localEditor.putLong(localStringBuilder.toString(), System.currentTimeMillis());
    localEditor.commit();
  }
  
  public MusicItemInfo a(int paramInt)
  {
    Object localObject = this.jdField_b_of_type_ComTencentAelightCameraAioeditorCaptureDataDoodleMusicCategoryItem;
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QIMMusicConfigManager", 2, "findMusicInfoFromMyTab myTabCategory is null");
      }
      return null;
    }
    if (((DoodleMusicCategoryItem)localObject).jdField_a_of_type_JavaUtilList == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QIMMusicConfigManager", 2, "findMusicInfoFromMyTab myTabCategory.templateGroups is null");
      }
      return null;
    }
    int i = 0;
    while (i < this.jdField_b_of_type_ComTencentAelightCameraAioeditorCaptureDataDoodleMusicCategoryItem.jdField_a_of_type_JavaUtilList.size())
    {
      localObject = (MusicItemInfo)this.jdField_b_of_type_ComTencentAelightCameraAioeditorCaptureDataDoodleMusicCategoryItem.jdField_a_of_type_JavaUtilList.get(i);
      if (((MusicItemInfo)localObject).mItemId == paramInt) {
        return localObject;
      }
      i += 1;
    }
    return null;
  }
  
  public MusicItemInfo a(int paramInt1, int paramInt2)
  {
    try
    {
      Object localObject1 = a();
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
          if (localDoodleMusicCategoryItem.jdField_a_of_type_Int == paramInt1)
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
  
  public ArrayList<DoodleMusicCategoryItem> a()
  {
    try
    {
      boolean bool = this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(true, true);
      if (bool) {
        return null;
      }
      ArrayList localArrayList = a(false);
      return localArrayList;
    }
    finally {}
  }
  
  public ArrayList<DoodleMusicCategoryItem> a(String paramString)
  {
    ArrayList localArrayList = new ArrayList(4);
    try
    {
      paramString = new JSONObject(paramString);
      if (paramString.has("showMine")) {
        this.jdField_b_of_type_Int = paramString.getInt("showMine");
      }
      if (paramString.has("showWsTab")) {
        this.jdField_c_of_type_Int = paramString.getInt("showWsTab");
      }
      if (paramString.has("showMusicWs")) {
        this.jdField_d_of_type_Int = paramString.getInt("showMusicWs");
      }
      if (paramString.has("jumpWsTab")) {
        this.jdField_b_of_type_JavaLangString = paramString.getString("jumpWsTab");
      }
      if (paramString.has("jumpWsMusic")) {
        this.jdField_c_of_type_JavaLangString = paramString.getString("jumpWsMusic");
      }
      if (paramString.has("mineIndex")) {
        this.e = paramString.getInt("mineIndex");
      }
      if (paramString.has("mineCategoryName")) {
        this.jdField_d_of_type_JavaLangString = paramString.getString("mineCategoryName");
      }
      paramString = paramString.getJSONArray("category");
      localArrayList.ensureCapacity(paramString.length());
      int i = 0;
      while (i < paramString.length())
      {
        localArrayList.add(new DoodleMusicCategoryItem(paramString.getJSONObject(i)));
        i += 1;
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
  
  /* Error */
  public ArrayList<DoodleMusicCategoryItem> a(boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 73	com/tencent/aelight/camera/aioeditor/capture/music/QIMMusicConfigManager:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   6: astore 4
    //   8: aload 4
    //   10: monitorenter
    //   11: aload_0
    //   12: getfield 80	com/tencent/aelight/camera/aioeditor/capture/music/QIMMusicConfigManager:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   15: iconst_1
    //   16: invokevirtual 513	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   19: aload_0
    //   20: getfield 515	com/tencent/aelight/camera/aioeditor/capture/music/QIMMusicConfigManager:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   23: ifnonnull +168 -> 191
    //   26: getstatic 42	com/tencent/aelight/camera/aioeditor/capture/music/QIMMusicConfigManager:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   29: ldc_w 384
    //   32: invokestatic 518	com/tencent/aelight/camera/aioeditor/capture/util/QIMFileUtils:a	(Ljava/io/File;Ljava/lang/String;)Ljava/lang/String;
    //   35: astore 5
    //   37: aload 5
    //   39: ifnull +67 -> 106
    //   42: aload_0
    //   43: aload_0
    //   44: aload 5
    //   46: invokevirtual 520	com/tencent/aelight/camera/aioeditor/capture/music/QIMMusicConfigManager:a	(Ljava/lang/String;)Ljava/util/ArrayList;
    //   49: putfield 515	com/tencent/aelight/camera/aioeditor/capture/music/QIMMusicConfigManager:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   52: invokestatic 125	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   55: ifeq +51 -> 106
    //   58: new 349	java/lang/StringBuilder
    //   61: dup
    //   62: invokespecial 350	java/lang/StringBuilder:<init>	()V
    //   65: astore 5
    //   67: aload 5
    //   69: ldc_w 522
    //   72: invokevirtual 356	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: pop
    //   76: aload_0
    //   77: getfield 515	com/tencent/aelight/camera/aioeditor/capture/music/QIMMusicConfigManager:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   80: ifnull +567 -> 647
    //   83: iconst_1
    //   84: istore_3
    //   85: goto +3 -> 88
    //   88: aload 5
    //   90: iload_3
    //   91: invokevirtual 394	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   94: pop
    //   95: ldc 127
    //   97: iconst_2
    //   98: aload 5
    //   100: invokevirtual 362	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   103: invokestatic 397	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   106: aload_0
    //   107: getfield 515	com/tencent/aelight/camera/aioeditor/capture/music/QIMMusicConfigManager:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   110: ifnull +13 -> 123
    //   113: aload_0
    //   114: getfield 515	com/tencent/aelight/camera/aioeditor/capture/music/QIMMusicConfigManager:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   117: invokevirtual 524	java/util/ArrayList:isEmpty	()Z
    //   120: ifeq +71 -> 191
    //   123: aload_0
    //   124: aload_0
    //   125: ldc_w 526
    //   128: invokestatic 528	com/tencent/aelight/camera/aioeditor/capture/util/QIMFileUtils:a	(Ljava/lang/String;)Ljava/lang/String;
    //   131: invokevirtual 520	com/tencent/aelight/camera/aioeditor/capture/music/QIMMusicConfigManager:a	(Ljava/lang/String;)Ljava/util/ArrayList;
    //   134: putfield 515	com/tencent/aelight/camera/aioeditor/capture/music/QIMMusicConfigManager:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   137: invokestatic 125	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   140: ifeq +51 -> 191
    //   143: new 349	java/lang/StringBuilder
    //   146: dup
    //   147: invokespecial 350	java/lang/StringBuilder:<init>	()V
    //   150: astore 5
    //   152: aload 5
    //   154: ldc_w 530
    //   157: invokevirtual 356	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: pop
    //   161: aload_0
    //   162: getfield 515	com/tencent/aelight/camera/aioeditor/capture/music/QIMMusicConfigManager:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   165: ifnull +487 -> 652
    //   168: iconst_1
    //   169: istore_3
    //   170: goto +3 -> 173
    //   173: aload 5
    //   175: iload_3
    //   176: invokevirtual 394	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   179: pop
    //   180: ldc 127
    //   182: iconst_2
    //   183: aload 5
    //   185: invokevirtual 362	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   188: invokestatic 397	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   191: aload_0
    //   192: getfield 119	com/tencent/aelight/camera/aioeditor/capture/music/QIMMusicConfigManager:jdField_b_of_type_ComTencentAelightCameraAioeditorCaptureDataDoodleMusicCategoryItem	Lcom/tencent/aelight/camera/aioeditor/capture/data/DoodleMusicCategoryItem;
    //   195: ifnull +462 -> 657
    //   198: aload_0
    //   199: getfield 119	com/tencent/aelight/camera/aioeditor/capture/music/QIMMusicConfigManager:jdField_b_of_type_ComTencentAelightCameraAioeditorCaptureDataDoodleMusicCategoryItem	Lcom/tencent/aelight/camera/aioeditor/capture/data/DoodleMusicCategoryItem;
    //   202: getfield 135	com/tencent/aelight/camera/aioeditor/capture/data/DoodleMusicCategoryItem:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   205: invokeinterface 143 1 0
    //   210: aload_0
    //   211: getfield 68	com/tencent/aelight/camera/aioeditor/capture/music/QIMMusicConfigManager:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   214: invokeinterface 143 1 0
    //   219: aload_0
    //   220: getfield 49	com/tencent/aelight/camera/aioeditor/capture/music/QIMMusicConfigManager:jdField_a_of_type_Int	I
    //   223: iadd
    //   224: if_icmpeq +433 -> 657
    //   227: iconst_1
    //   228: istore_2
    //   229: goto +3 -> 232
    //   232: aload_0
    //   233: getfield 532	com/tencent/aelight/camera/aioeditor/capture/music/QIMMusicConfigManager:jdField_b_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   236: ifnull +11 -> 247
    //   239: iload_1
    //   240: ifne +7 -> 247
    //   243: iload_2
    //   244: ifeq +360 -> 604
    //   247: aload_0
    //   248: getfield 515	com/tencent/aelight/camera/aioeditor/capture/music/QIMMusicConfigManager:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   251: ifnonnull +8 -> 259
    //   254: iconst_0
    //   255: istore_2
    //   256: goto +11 -> 267
    //   259: aload_0
    //   260: getfield 515	com/tencent/aelight/camera/aioeditor/capture/music/QIMMusicConfigManager:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   263: invokevirtual 533	java/util/ArrayList:size	()I
    //   266: istore_2
    //   267: aload_0
    //   268: new 65	java/util/ArrayList
    //   271: dup
    //   272: iload_2
    //   273: invokespecial 456	java/util/ArrayList:<init>	(I)V
    //   276: putfield 532	com/tencent/aelight/camera/aioeditor/capture/music/QIMMusicConfigManager:jdField_b_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   279: new 149	com/tencent/mobileqq/richmedia/capture/data/MusicItemInfo
    //   282: dup
    //   283: invokespecial 177	com/tencent/mobileqq/richmedia/capture/data/MusicItemInfo:<init>	()V
    //   286: astore 5
    //   288: aload 5
    //   290: iconst_2
    //   291: putfield 180	com/tencent/mobileqq/richmedia/capture/data/MusicItemInfo:mType	I
    //   294: aload 5
    //   296: iconst_m1
    //   297: putfield 152	com/tencent/mobileqq/richmedia/capture/data/MusicItemInfo:mItemId	I
    //   300: new 149	com/tencent/mobileqq/richmedia/capture/data/MusicItemInfo
    //   303: dup
    //   304: invokespecial 177	com/tencent/mobileqq/richmedia/capture/data/MusicItemInfo:<init>	()V
    //   307: astore 6
    //   309: aload 6
    //   311: iconst_3
    //   312: putfield 180	com/tencent/mobileqq/richmedia/capture/data/MusicItemInfo:mType	I
    //   315: aload 6
    //   317: bipush 254
    //   319: putfield 152	com/tencent/mobileqq/richmedia/capture/data/MusicItemInfo:mItemId	I
    //   322: new 149	com/tencent/mobileqq/richmedia/capture/data/MusicItemInfo
    //   325: dup
    //   326: invokespecial 177	com/tencent/mobileqq/richmedia/capture/data/MusicItemInfo:<init>	()V
    //   329: astore 7
    //   331: aload 7
    //   333: bipush 10
    //   335: putfield 180	com/tencent/mobileqq/richmedia/capture/data/MusicItemInfo:mType	I
    //   338: aload 7
    //   340: bipush 249
    //   342: putfield 152	com/tencent/mobileqq/richmedia/capture/data/MusicItemInfo:mItemId	I
    //   345: aload_0
    //   346: getfield 515	com/tencent/aelight/camera/aioeditor/capture/music/QIMMusicConfigManager:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   349: ifnull +198 -> 547
    //   352: aload_0
    //   353: getfield 515	com/tencent/aelight/camera/aioeditor/capture/music/QIMMusicConfigManager:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   356: invokevirtual 439	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   359: astore 8
    //   361: aload 8
    //   363: invokeinterface 286 1 0
    //   368: ifeq +179 -> 547
    //   371: aload 8
    //   373: invokeinterface 290 1 0
    //   378: checkcast 134	com/tencent/aelight/camera/aioeditor/capture/data/DoodleMusicCategoryItem
    //   381: astore 9
    //   383: aload 9
    //   385: getfield 135	com/tencent/aelight/camera/aioeditor/capture/data/DoodleMusicCategoryItem:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   388: ifnull -27 -> 361
    //   391: aload 9
    //   393: getfield 135	com/tencent/aelight/camera/aioeditor/capture/data/DoodleMusicCategoryItem:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   396: invokeinterface 143 1 0
    //   401: ifle -40 -> 361
    //   404: aload 9
    //   406: invokevirtual 536	com/tencent/aelight/camera/aioeditor/capture/data/DoodleMusicCategoryItem:a	()Lcom/tencent/aelight/camera/aioeditor/capture/data/DoodleMusicCategoryItem;
    //   409: astore 10
    //   411: new 65	java/util/ArrayList
    //   414: dup
    //   415: invokespecial 66	java/util/ArrayList:<init>	()V
    //   418: astore 11
    //   420: aload 11
    //   422: aload 5
    //   424: invokeinterface 183 2 0
    //   429: pop
    //   430: aload 11
    //   432: aload 6
    //   434: invokeinterface 183 2 0
    //   439: pop
    //   440: aload_0
    //   441: iconst_3
    //   442: putfield 49	com/tencent/aelight/camera/aioeditor/capture/music/QIMMusicConfigManager:jdField_a_of_type_Int	I
    //   445: aload_0
    //   446: getfield 538	com/tencent/aelight/camera/aioeditor/capture/music/QIMMusicConfigManager:jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureDataDoodleMusicCategoryItem	Lcom/tencent/aelight/camera/aioeditor/capture/data/DoodleMusicCategoryItem;
    //   449: ifnull +45 -> 494
    //   452: aload_0
    //   453: getfield 538	com/tencent/aelight/camera/aioeditor/capture/music/QIMMusicConfigManager:jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureDataDoodleMusicCategoryItem	Lcom/tencent/aelight/camera/aioeditor/capture/data/DoodleMusicCategoryItem;
    //   456: getfield 135	com/tencent/aelight/camera/aioeditor/capture/data/DoodleMusicCategoryItem:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   459: ifnull +35 -> 494
    //   462: aload_0
    //   463: getfield 538	com/tencent/aelight/camera/aioeditor/capture/music/QIMMusicConfigManager:jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureDataDoodleMusicCategoryItem	Lcom/tencent/aelight/camera/aioeditor/capture/data/DoodleMusicCategoryItem;
    //   466: getfield 175	com/tencent/aelight/camera/aioeditor/capture/data/DoodleMusicCategoryItem:jdField_a_of_type_Int	I
    //   469: aload 9
    //   471: getfield 175	com/tencent/aelight/camera/aioeditor/capture/data/DoodleMusicCategoryItem:jdField_a_of_type_Int	I
    //   474: if_icmpne +20 -> 494
    //   477: aload_0
    //   478: getfield 540	com/tencent/aelight/camera/aioeditor/capture/music/QIMMusicConfigManager:jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo	Lcom/tencent/mobileqq/richmedia/capture/data/MusicItemInfo;
    //   481: ifnull +13 -> 494
    //   484: aload_0
    //   485: aload 9
    //   487: aload_0
    //   488: getfield 540	com/tencent/aelight/camera/aioeditor/capture/music/QIMMusicConfigManager:jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo	Lcom/tencent/mobileqq/richmedia/capture/data/MusicItemInfo;
    //   491: invokespecial 542	com/tencent/aelight/camera/aioeditor/capture/music/QIMMusicConfigManager:a	(Lcom/tencent/aelight/camera/aioeditor/capture/data/DoodleMusicCategoryItem;Lcom/tencent/mobileqq/richmedia/capture/data/MusicItemInfo;)V
    //   494: iload_1
    //   495: ifeq +19 -> 514
    //   498: aload 9
    //   500: getfield 543	com/tencent/aelight/camera/aioeditor/capture/data/DoodleMusicCategoryItem:jdField_a_of_type_Boolean	Z
    //   503: ifeq +11 -> 514
    //   506: aload 9
    //   508: getfield 135	com/tencent/aelight/camera/aioeditor/capture/data/DoodleMusicCategoryItem:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   511: invokestatic 546	java/util/Collections:shuffle	(Ljava/util/List;)V
    //   514: aload 11
    //   516: aload 9
    //   518: getfield 135	com/tencent/aelight/camera/aioeditor/capture/data/DoodleMusicCategoryItem:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   521: invokeinterface 550 2 0
    //   526: pop
    //   527: aload 10
    //   529: aload 11
    //   531: putfield 135	com/tencent/aelight/camera/aioeditor/capture/data/DoodleMusicCategoryItem:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   534: aload_0
    //   535: getfield 532	com/tencent/aelight/camera/aioeditor/capture/music/QIMMusicConfigManager:jdField_b_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   538: aload 10
    //   540: invokevirtual 503	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   543: pop
    //   544: goto -183 -> 361
    //   547: aload_0
    //   548: getfield 53	com/tencent/aelight/camera/aioeditor/capture/music/QIMMusicConfigManager:jdField_b_of_type_Int	I
    //   551: iconst_1
    //   552: if_icmpne +52 -> 604
    //   555: aload_0
    //   556: getfield 59	com/tencent/aelight/camera/aioeditor/capture/music/QIMMusicConfigManager:e	I
    //   559: iconst_1
    //   560: if_icmplt +44 -> 604
    //   563: aload_0
    //   564: getfield 59	com/tencent/aelight/camera/aioeditor/capture/music/QIMMusicConfigManager:e	I
    //   567: aload_0
    //   568: getfield 532	com/tencent/aelight/camera/aioeditor/capture/music/QIMMusicConfigManager:jdField_b_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   571: invokevirtual 533	java/util/ArrayList:size	()I
    //   574: if_icmpgt +30 -> 604
    //   577: aload_0
    //   578: aload 5
    //   580: aload 6
    //   582: aload 7
    //   584: invokespecial 552	com/tencent/aelight/camera/aioeditor/capture/music/QIMMusicConfigManager:a	(Lcom/tencent/mobileqq/richmedia/capture/data/MusicItemInfo;Lcom/tencent/mobileqq/richmedia/capture/data/MusicItemInfo;Lcom/tencent/mobileqq/richmedia/capture/data/MusicItemInfo;)Lcom/tencent/aelight/camera/aioeditor/capture/data/DoodleMusicCategoryItem;
    //   587: astore 5
    //   589: aload_0
    //   590: getfield 532	com/tencent/aelight/camera/aioeditor/capture/music/QIMMusicConfigManager:jdField_b_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   593: aload_0
    //   594: getfield 59	com/tencent/aelight/camera/aioeditor/capture/music/QIMMusicConfigManager:e	I
    //   597: iconst_1
    //   598: isub
    //   599: aload 5
    //   601: invokevirtual 553	java/util/ArrayList:add	(ILjava/lang/Object;)V
    //   604: aload_0
    //   605: getfield 80	com/tencent/aelight/camera/aioeditor/capture/music/QIMMusicConfigManager:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   608: iconst_0
    //   609: invokevirtual 513	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   612: aload_0
    //   613: getfield 532	com/tencent/aelight/camera/aioeditor/capture/music/QIMMusicConfigManager:jdField_b_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
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
    //   228	431	2	i	int
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
        this.jdField_a_of_type_JavaUtilList.addAll((Collection)paramObject);
        Collections.sort(this.jdField_a_of_type_JavaUtilList);
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
      List localList = this.jdField_b_of_type_JavaUtilList;
      if (localList != null)
      {
        if (localList.contains(paramLoadMusicStepListener))
        {
          if (QLog.isColorLevel()) {
            QLog.d("QIMMusicConfigManager", 2, "addLoadMusicListener mListeners has listener");
          }
          return;
        }
        this.jdField_b_of_type_JavaUtilList.add(paramLoadMusicStepListener);
        return;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("QIMMusicConfigManager", 2, "addLoadMusicListener listener = null");
    }
  }
  
  public void a(MusicItemInfo paramMusicItemInfo, boolean paramBoolean)
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      Object localObject1;
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("addOrUpdateMytabMusic, lock updateTimeStamp=");
        ((StringBuilder)localObject1).append(paramBoolean);
        QLog.d("QIMMusicConfigManager", 2, ((StringBuilder)localObject1).toString());
      }
      if ((this.jdField_b_of_type_ComTencentAelightCameraAioeditorCaptureDataDoodleMusicCategoryItem != null) && (this.jdField_b_of_type_ComTencentAelightCameraAioeditorCaptureDataDoodleMusicCategoryItem.jdField_a_of_type_JavaUtilList != null))
      {
        localObject1 = this.jdField_b_of_type_ComTencentAelightCameraAioeditorCaptureDataDoodleMusicCategoryItem.jdField_a_of_type_JavaUtilList;
        int i = a(paramMusicItemInfo);
        long l2 = System.currentTimeMillis();
        Object localObject2;
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("addOrUpdateMytabMusic, index=");
          ((StringBuilder)localObject2).append(i);
          QLog.d("QIMMusicConfigManager", 2, ((StringBuilder)localObject2).toString());
        }
        long l1;
        if (i == -1)
        {
          if (((List)localObject1).size() < this.jdField_a_of_type_Int + 40)
          {
            ((List)localObject1).add(this.jdField_a_of_type_Int, paramMusicItemInfo);
          }
          else
          {
            localObject2 = (MusicItemInfo)((List)localObject1).remove(((List)localObject1).size() - 1);
            if (!TextUtils.isEmpty(((MusicItemInfo)localObject2).getLocalPath()))
            {
              FileUtils.a(new File(((MusicItemInfo)localObject2).getLocalPath()));
              if (QLog.isColorLevel())
              {
                StringBuilder localStringBuilder = new StringBuilder();
                localStringBuilder.append("delete file=");
                localStringBuilder.append(((MusicItemInfo)localObject2).mMusicName);
                QLog.d("QIMMusicConfigManager", 2, localStringBuilder.toString());
              }
            }
            ((List)localObject1).add(this.jdField_a_of_type_Int, paramMusicItemInfo);
          }
          localObject1 = new FlowMusic(paramMusicItemInfo);
          l1 = l2;
        }
        else if ((i != this.jdField_a_of_type_Int) && (paramBoolean))
        {
          ((List)localObject1).remove(i);
          ((List)localObject1).add(this.jdField_a_of_type_Int, paramMusicItemInfo);
          localObject2 = a(paramMusicItemInfo.mItemId);
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
          ((List)localObject1).remove(i);
          ((List)localObject1).add(i, paramMusicItemInfo);
          localObject2 = a(paramMusicItemInfo.mItemId);
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
        if (this.jdField_b_of_type_JavaUtilList != null)
        {
          localObject1 = this.jdField_b_of_type_JavaUtilList.iterator();
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
    this.jdField_a_of_type_JavaUtilArrayList = a(paramString);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("handleDoodleMusicConfig");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" result:");
      boolean bool;
      if (this.jdField_a_of_type_JavaUtilArrayList != null) {
        bool = true;
      } else {
        bool = false;
      }
      localStringBuilder.append(bool);
      QLog.i("QIMMusicConfigManager", 2, localStringBuilder.toString());
    }
    QIMFileUtils.a(jdField_a_of_type_JavaIoFile, "doodle_music_config.cfg", paramString);
    PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.sApplication).edit().putInt("show_wstab", this.jdField_c_of_type_Int).commit();
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
      Object localObject3 = a();
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
  
  public void b()
  {
    AppInterface localAppInterface = a();
    if (localAppInterface != null) {
      localAppInterface.getApp().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
    }
  }
  
  public void b(QIMMusicConfigManager.LoadMusicStepListener paramLoadMusicStepListener)
  {
    if (this.jdField_b_of_type_JavaUtilList.contains(paramLoadMusicStepListener)) {
      this.jdField_b_of_type_JavaUtilList.remove(paramLoadMusicStepListener);
    }
  }
  
  public void d()
  {
    AppInterface localAppInterface = a();
    if (localAppInterface != null)
    {
      IntentFilter localIntentFilter = new IntentFilter("com.tencent.mobileqq.action.ACTION_WEBVIEW_DISPATCH_EVENT");
      localAppInterface.getApp().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
      a();
      a().notifyObservers(CaptureConfigUpdateObserver.class, 1, true, null);
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("QIMMusicConfigManager", 4, "initMusicConfig");
    }
  }
  
  public void e()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    ((IAsyncControl)QRoute.api(IAsyncControl.class)).startAsyncStep(1009);
    Object localObject = a().getCurrentAccountUin();
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getContext().getSharedPreferences("fecth_qq_music", 4);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("fecth_from_qq_music_time_");
    localStringBuilder.append((String)localObject);
    long l = localSharedPreferences.getLong(localStringBuilder.toString(), 0L);
    int i;
    if ((System.currentTimeMillis() - l > 86400000L) && (NetworkUtil.isWifiEnabled(BaseApplicationImpl.sApplication))) {
      i = 1;
    } else {
      i = 0;
    }
    if ((l == 0L) || (i != 0))
    {
      localObject = a().getCurrentAccountUin();
      if (localObject != null)
      {
        this.jdField_a_of_type_JavaLangString = ((String)localObject);
        new QIMMusicConfigManager.GetQQMusicSongListTask(this, this).a();
      }
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("checkMyFavoriteUpgradeInQQMusic, lastFetchTime = ");
      ((StringBuilder)localObject).append(l);
      QLog.d("QIMMusicConfigManager", 2, ((StringBuilder)localObject).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.music.QIMMusicConfigManager
 * JD-Core Version:    0.7.0.1
 */