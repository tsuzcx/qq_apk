package com.tencent.aelight.camera.aioeditor.shortvideo;

import android.content.SharedPreferences;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.aelight.camera.aioeditor.capture.control.QIMAsyncManager;
import com.tencent.aelight.camera.aioeditor.capture.data.TemplateGroupItem;
import com.tencent.aelight.camera.aioeditor.capture.music.CaptureConfigUpdateObserver;
import com.tencent.aelight.camera.struct.editor.PtvTemplateInfo;
import com.tencent.biz.common.util.ZipUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.richmedia.PathUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.shortvideo.common.Observable;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngineListener;
import com.tencent.mobileqq.transfile.NetworkCenter;
import com.tencent.mobileqq.transfile.api.IHttpEngineService;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class QIMPtvTemplateManager
  extends QIMAsyncManager
{
  public static final Long a = Long.valueOf(2000L);
  public static String b = "ptv_template_usable";
  public static String c = "ptv_debug";
  public static String d = "ptv_template_usable_doodle";
  public static File e;
  public static int k;
  public static AtomicBoolean o = new AtomicBoolean(false);
  private static final String p;
  private static File q;
  protected List<TemplateGroupItem> f = new CopyOnWriteArrayList();
  protected final Object g = new Object();
  String h;
  String i;
  protected Object j = new Object();
  public String l = "recent_template_setting";
  public String m = "recent_template_list";
  HashMap<Integer, QIMPtvTemplateManager.BusinessParam> n = new HashMap();
  private Observable r;
  private TemplateGroupItem s;
  private TemplateGroupItem t;
  private String u;
  
  static
  {
    Object localObject = new File(PathUtils.d);
    p = ((File)localObject).getPath();
    q = new File((File)localObject, "dov_ptv_template_dov");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(q.getPath());
    localStringBuilder.append(File.separator);
    localStringBuilder.append(b);
    localStringBuilder.append(File.separator);
    b = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(q.getPath());
    localStringBuilder.append(File.separator);
    localStringBuilder.append(c);
    c = localStringBuilder.toString();
    e = new File((File)localObject, "doodle_template");
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(e.getPath());
    ((StringBuilder)localObject).append(File.separator);
    ((StringBuilder)localObject).append(d);
    ((StringBuilder)localObject).append(File.separator);
    d = ((StringBuilder)localObject).toString();
  }
  
  private int a(List<PtvTemplateInfo> paramList, String paramString)
  {
    if (paramList != null)
    {
      if (paramList.size() <= 0) {
        return -1;
      }
      int i1 = 0;
      while (i1 < paramList.size())
      {
        if (((PtvTemplateInfo)paramList.get(i1)).a.equals(paramString)) {
          return i1;
        }
        i1 += 1;
      }
    }
    return -1;
  }
  
  public static String a(File paramFile)
  {
    paramFile = FileUtils.fileToBytes(paramFile);
    if (paramFile != null)
    {
      if (paramFile.length <= 0) {
        return null;
      }
      if (Build.VERSION.SDK_INT <= 8) {
        return new String(paramFile);
      }
      try
      {
        paramFile = new String(paramFile, "UTF-8");
        return paramFile;
      }
      catch (UnsupportedEncodingException paramFile)
      {
        QLog.e("QIMPtvTemplateManager_PTV", 1, "loadFileContent error, ", paramFile);
      }
    }
    return null;
  }
  
  static List<TemplateGroupItem> a(QIMPtvTemplateManager paramQIMPtvTemplateManager, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    for (;;)
    {
      try
      {
        Object localObject = new JSONObject(paramString);
        if (paramQIMPtvTemplateManager != null)
        {
          if (((JSONObject)localObject).has("guide_video_url")) {
            paramQIMPtvTemplateManager.h = ((JSONObject)localObject).getString("guide_video_url");
          }
          if (((JSONObject)localObject).has("guide_video_md5")) {
            paramQIMPtvTemplateManager.i = ((JSONObject)localObject).getString("guide_video_md5");
          }
        }
        boolean bool = ((JSONObject)localObject).has("bigheadCommonRes");
        String str = "";
        if (!bool) {
          break label168;
        }
        paramString = ((JSONObject)localObject).getJSONObject("bigheadCommonRes");
        if (paramString == null) {
          break label168;
        }
        str = paramString.optString("bighead_model_name", "");
        paramQIMPtvTemplateManager = paramString.optString("bighead_model_resurl", "");
        paramString = paramString.optString("bighead_model_resmd5", "");
        if (((JSONObject)localObject).has("category"))
        {
          localObject = a(((JSONObject)localObject).getJSONArray("category"));
          a((List)localObject, str, paramQIMPtvTemplateManager, paramString);
          return localObject;
        }
      }
      catch (JSONException paramQIMPtvTemplateManager)
      {
        if (QLog.isColorLevel()) {
          paramQIMPtvTemplateManager.printStackTrace();
        }
      }
      return null;
      label168:
      paramString = "";
      paramQIMPtvTemplateManager = paramString;
    }
  }
  
  static List<TemplateGroupItem> a(JSONArray paramJSONArray)
  {
    if (paramJSONArray == null) {
      return null;
    }
    int i2 = paramJSONArray.length();
    if (i2 <= 0) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    int i1 = 0;
    for (;;)
    {
      if (i1 < i2) {
        try
        {
          TemplateGroupItem localTemplateGroupItem = new TemplateGroupItem();
          Object localObject = paramJSONArray.getJSONObject(i1);
          if (((JSONObject)localObject).has("content")) {
            localTemplateGroupItem.a = PtvTemplateManager.PtvTemplateInfoUtil.a(((JSONObject)localObject).getJSONArray("content"));
          }
          if (((JSONObject)localObject).has("categoryName")) {
            localTemplateGroupItem.c = ((JSONObject)localObject).getString("categoryName");
          }
          if ((((JSONObject)localObject).has("TipsVer")) && (((JSONObject)localObject).has("Tips")))
          {
            localTemplateGroupItem.f = ((JSONObject)localObject).getInt("TipsVer");
            localTemplateGroupItem.e = ((JSONObject)localObject).getString("Tips");
          }
          localTemplateGroupItem.g = "1".equals(((JSONObject)localObject).optString("random_position"));
          if (((JSONObject)localObject).has("categoryId"))
          {
            localTemplateGroupItem.b = ((JSONObject)localObject).getInt("categoryId");
            if ((localTemplateGroupItem.a != null) && (!localTemplateGroupItem.a.isEmpty()))
            {
              localObject = localTemplateGroupItem.a.iterator();
              while (((Iterator)localObject).hasNext()) {
                ((PtvTemplateInfo)((Iterator)localObject).next()).l = localTemplateGroupItem.b;
              }
            }
          }
          localArrayList.add(localTemplateGroupItem);
          i1 += 1;
        }
        catch (JSONException paramJSONArray)
        {
          if (QLog.isColorLevel()) {
            paramJSONArray.printStackTrace();
          }
        }
      }
    }
    return localArrayList;
  }
  
  private void a(QIMPtvTemplateManager.DLSession paramDLSession, QIMPtvTemplateManager.DLItem paramDLItem, long paramLong1, long paramLong2)
  {
    if (paramDLSession != null)
    {
      if (paramDLItem == null) {
        return;
      }
      Object localObject = (QIMPtvTemplateManager.BusinessParam)this.n.get(Integer.valueOf(paramDLSession.d));
      if (localObject == null)
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("multiSessionDownloadProcessUpdate: BusinessParam=null  kind=");
          ((StringBuilder)localObject).append(paramDLSession.d);
          ((StringBuilder)localObject).append(" mItem.mName=");
          ((StringBuilder)localObject).append(paramDLItem.a);
          QLog.e("QIMPtvTemplateManager", 2, ((StringBuilder)localObject).toString());
        }
        return;
      }
      paramDLItem.g = paramLong1;
      paramDLItem.h = paramLong2;
      paramDLItem.f = true;
      paramLong2 = 0L;
      paramLong1 = 1L;
      paramDLItem = paramDLSession.a.iterator();
      while (paramDLItem.hasNext())
      {
        QIMPtvTemplateManager.DLItem localDLItem = (QIMPtvTemplateManager.DLItem)paramDLItem.next();
        if (!localDLItem.d)
        {
          localDLItem = (QIMPtvTemplateManager.DLItem)((QIMPtvTemplateManager.BusinessParam)localObject).a.get(localDLItem.a);
          if (localDLItem != null)
          {
            long l1;
            if (localDLItem.f)
            {
              paramLong2 += localDLItem.g;
              l1 = localDLItem.h;
            }
            else
            {
              l1 = 1000L;
            }
            paramLong1 += l1;
          }
        }
      }
      if (paramDLSession.c != null) {
        paramDLSession.c.a(paramDLSession.b, (int)(paramLong2 * 100L / paramLong1));
      }
    }
  }
  
  static void a(String paramString1, String paramString2)
  {
    ThreadManager.getFileThreadHandler().post(new QIMPtvTemplateManager.2(paramString2, paramString1));
  }
  
  private static void a(List<TemplateGroupItem> paramList, String paramString1, String paramString2, String paramString3)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      if (TextUtils.isEmpty(paramString3)) {
        return;
      }
      if (paramList != null)
      {
        if (paramList.size() <= 0) {
          return;
        }
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          Object localObject = (TemplateGroupItem)paramList.next();
          if ((((TemplateGroupItem)localObject).a != null) && (((TemplateGroupItem)localObject).a.size() > 0))
          {
            localObject = ((TemplateGroupItem)localObject).a.iterator();
            while (((Iterator)localObject).hasNext())
            {
              PtvTemplateInfo localPtvTemplateInfo = (PtvTemplateInfo)((Iterator)localObject).next();
              if ((localPtvTemplateInfo != null) && (localPtvTemplateInfo.o == 20))
              {
                localPtvTemplateInfo.S = paramString1;
                localPtvTemplateInfo.T = paramString2;
                localPtvTemplateInfo.U = paramString3;
              }
            }
          }
        }
      }
    }
  }
  
  private boolean a(QIMPtvTemplateManager.DLSession paramDLSession)
  {
    QIMPtvTemplateManager.BusinessParam localBusinessParam = (QIMPtvTemplateManager.BusinessParam)this.n.get(Integer.valueOf(paramDLSession.d));
    if (localBusinessParam != null)
    {
      if (localBusinessParam.b.size() == 0) {
        return true;
      }
      paramDLSession = paramDLSession.a.iterator();
      while (paramDLSession.hasNext())
      {
        QIMPtvTemplateManager.DLItem localDLItem = (QIMPtvTemplateManager.DLItem)paramDLSession.next();
        if (!(localBusinessParam.b.contains(localDLItem.a) ^ true)) {
          return false;
        }
      }
    }
    return true;
  }
  
  private boolean a(QIMPtvTemplateManager.DLSession paramDLSession, QIMPtvTemplateManager.DLItem paramDLItem)
  {
    if (paramDLSession != null)
    {
      if (paramDLItem == null) {
        return false;
      }
      QIMPtvTemplateManager.BusinessParam localBusinessParam = (QIMPtvTemplateManager.BusinessParam)this.n.get(Integer.valueOf(paramDLSession.d));
      if (localBusinessParam != null)
      {
        localBusinessParam.b.remove(paramDLItem.a);
        if (a(paramDLSession))
        {
          paramDLSession.b.g = a(paramDLSession.b);
          paramDLItem = this.f.iterator();
          while (paramDLItem.hasNext())
          {
            Object localObject = (TemplateGroupItem)paramDLItem.next();
            if (((TemplateGroupItem)localObject).a != null)
            {
              localObject = ((TemplateGroupItem)localObject).a.iterator();
              while (((Iterator)localObject).hasNext())
              {
                PtvTemplateInfo localPtvTemplateInfo = (PtvTemplateInfo)((Iterator)localObject).next();
                if (localPtvTemplateInfo.a.equals(paramDLSession.b.a)) {
                  localPtvTemplateInfo.g = a(localPtvTemplateInfo);
                } else if (paramDLSession.d == localPtvTemplateInfo.o) {
                  localPtvTemplateInfo.g = a(localPtvTemplateInfo);
                }
              }
            }
          }
          if (paramDLSession.c != null) {
            paramDLSession.c.a(paramDLSession.b, paramDLSession.b.g);
          }
          if (localBusinessParam.b.size() == 0) {
            localBusinessParam.a.clear();
          }
          return true;
        }
      }
    }
    return false;
  }
  
  private boolean a(String paramString1, String paramString2, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return false;
    }
    Object localObject = new File(q, paramString1);
    if (!((File)localObject).exists()) {
      return false;
    }
    try
    {
      localObject = FileUtils.calcMd5(((File)localObject).getPath());
      if ((!TextUtils.isEmpty((CharSequence)localObject)) && (((String)localObject).equalsIgnoreCase(paramString2)))
      {
        paramString2 = new StringBuilder();
        paramString2.append(b);
        paramString2.append(paramString1);
        paramString2.append(File.separator);
        localObject = paramString2.toString();
        paramString2 = new File((String)localObject, "params.json");
        localObject = new File((String)localObject, "params.dat");
        if ((!paramString2.exists()) && ((!paramBoolean) || (!((File)localObject).exists()))) {
          try
          {
            ZipUtils.unZipFile(new File(q, paramString1), b);
            return true;
          }
          catch (Exception paramString1)
          {
            if (QLog.isColorLevel()) {
              QLog.e("QIMPtvTemplateManager", 2, "judgeTemplateUsable unZipFile exp:", paramString1);
            }
            return (paramString2.exists()) && ((paramBoolean) || (((File)localObject).exists()));
          }
        }
        return true;
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("judgeTemplateUsable md5 exp, fileMd5:");
        localStringBuilder.append((String)localObject);
        localStringBuilder.append(", tempMd5:");
        localStringBuilder.append(paramString2);
        localStringBuilder.append(", name:");
        localStringBuilder.append(paramString1);
        QLog.e("QIMPtvTemplateManager", 2, localStringBuilder.toString());
      }
      return false;
    }
    catch (UnsatisfiedLinkError paramString1)
    {
      if (QLog.isColorLevel()) {
        QLog.e("QIMPtvTemplateManager", 2, "judgeTemplateUsable calcMd5 error:", paramString1);
      }
    }
    return false;
  }
  
  public static boolean e()
  {
    boolean bool = new File(q, "ptv_template_new.cfg").exists();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("QIMPtvTemplateManager isStickerConfigFileExist");
      localStringBuilder.append(bool);
      QLog.i("QIMPtvTemplateManager", 2, localStringBuilder.toString());
    }
    return bool;
  }
  
  private boolean m()
  {
    TemplateGroupItem localTemplateGroupItem = this.s;
    return (localTemplateGroupItem != null) && (localTemplateGroupItem.a.size() >= 100);
  }
  
  public TemplateGroupItem a(TemplateGroupItem paramTemplateGroupItem)
  {
    ??? = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    Object localObject2 = BaseApplicationImpl.getApplication().getSharedPreferences(this.l, 0);
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append(this.m);
    ((StringBuilder)localObject3).append((String)???);
    ??? = ((SharedPreferences)localObject2).getString(((StringBuilder)localObject3).toString(), null);
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("getRecentTemplate list=");
      ((StringBuilder)localObject2).append((String)???);
      QLog.d("QIMPtvTemplateManager", 2, ((StringBuilder)localObject2).toString());
    }
    if (TextUtils.isEmpty((CharSequence)???)) {
      return paramTemplateGroupItem;
    }
    localObject2 = ((String)???).split("\\$");
    int i1;
    synchronized (this.j)
    {
      paramTemplateGroupItem.a.clear();
      i1 = 0;
      if (i1 < localObject2.length)
      {
        localObject3 = localObject2[i1].split("\\|");
        if ((localObject3 != null) && (localObject3.length == 2))
        {
          Integer.valueOf(localObject3[1]).intValue();
          localObject3 = a(localObject3[0]);
          if (localObject3 != null)
          {
            if (paramTemplateGroupItem.a.size() >= 100) {
              return paramTemplateGroupItem;
            }
            paramTemplateGroupItem.a.add(localObject3);
          }
        }
      }
      else
      {
        return paramTemplateGroupItem;
      }
    }
  }
  
  public PtvTemplateInfo a(String paramString)
  {
    Object localObject;
    PtvTemplateInfo localPtvTemplateInfo;
    do
    {
      localObject = i().iterator();
      Iterator localIterator;
      while (!localIterator.hasNext())
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        localIterator = ((TemplateGroupItem)((Iterator)localObject).next()).a.iterator();
      }
      localPtvTemplateInfo = (PtvTemplateInfo)localIterator.next();
    } while (!localPtvTemplateInfo.a.equals(paramString));
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("QIMPtvTemplateManager existTemplateInfo id=");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("QIMPtvTemplateManager", 2, ((StringBuilder)localObject).toString());
    }
    return localPtvTemplateInfo;
    return null;
  }
  
  public Runnable a(boolean paramBoolean)
  {
    return new QIMPtvTemplateManager.1(this, paramBoolean);
  }
  
  public void a(int paramInt, Object paramObject)
  {
    Observable localObservable = this.r;
    if (localObservable != null)
    {
      localObservable.a(paramInt, new Object[] { paramObject });
      if (QLog.isColorLevel())
      {
        paramObject = new StringBuilder();
        paramObject.append("notifyEventId eventId");
        paramObject.append(paramInt);
        QLog.d("QIMPtvTemplateManager", 2, paramObject.toString());
      }
    }
  }
  
  public void a(PtvTemplateInfo paramPtvTemplateInfo, int paramInt)
  {
    synchronized (this.j)
    {
      if (this.s == null)
      {
        this.s = new TemplateGroupItem(HardCodeUtil.a(2131907504));
        this.s.a = new ArrayList(100);
        a(this.s);
      }
      if (this.t == null) {
        this.t = this.s.a();
      }
      int i1 = a(this.s.a, paramPtvTemplateInfo.a);
      if (i1 == -1)
      {
        if (!m())
        {
          this.s.a.add(0, paramPtvTemplateInfo);
          this.t.a.add(0, paramPtvTemplateInfo);
          if (this.r != null) {
            this.r.a(paramInt, new Object[] { this.t });
          }
          if (QLog.isColorLevel()) {
            QLog.d("QIMPtvTemplateManager", 2, "setCurrentTemplateInfoToRecent not isRecentTemplateFull ");
          }
        }
        else
        {
          PtvTemplateInfo localPtvTemplateInfo = (PtvTemplateInfo)this.s.a.remove(99);
          this.s.a.add(0, paramPtvTemplateInfo);
          this.t.a.remove(localPtvTemplateInfo);
          this.t.a.add(0, paramPtvTemplateInfo);
          if (this.r != null) {
            this.r.a(paramInt, new Object[] { this.t });
          }
        }
      }
      else if (i1 != 0)
      {
        this.s.a.remove(i1);
        this.s.a.add(0, paramPtvTemplateInfo);
      }
      if (QLog.isColorLevel())
      {
        paramPtvTemplateInfo = new StringBuilder();
        paramPtvTemplateInfo.append("setCurrentTemplateInfoToRecent index=");
        paramPtvTemplateInfo.append(i1);
        QLog.d("QIMPtvTemplateManager", 2, paramPtvTemplateInfo.toString());
      }
      return;
    }
  }
  
  public void a(AppInterface paramAppInterface, PtvTemplateInfo paramPtvTemplateInfo, PtvTemplateManager.IPtvTemplateDownloadListener paramIPtvTemplateDownloadListener)
  {
    if (paramPtvTemplateInfo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QIMPtvTemplateManager", 2, "startDownloadTemplate is null");
      }
      return;
    }
    b(paramAppInterface, paramPtvTemplateInfo, paramIPtvTemplateDownloadListener);
  }
  
  public void a(String paramString, int paramInt)
  {
    List localList = a(null, paramString);
    if ((localList != null) && (!localList.isEmpty()))
    {
      a(paramString, "ptv_template_new.cfg");
      g().notifyObservers(CaptureConfigUpdateObserver.class, 3, true, null);
      return;
    }
    QLog.d("QIMPtvTemplateManager", 1, "handleGetServerConfig no infos");
  }
  
  public void a(String paramString1, int paramInt, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder("QIMPtvTemplateManager setSelectedPtvTemplate id=");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(" categoryId =");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" currentPath=");
    localStringBuilder.append(paramString2);
    if (QLog.isColorLevel()) {
      QLog.d("QIMPtvTemplateManager", 2, localStringBuilder.toString());
    }
    a(113, null);
  }
  
  void a(List<TemplateGroupItem> paramList)
  {
    if (paramList != null)
    {
      if (paramList.isEmpty()) {
        return;
      }
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        Object localObject = (TemplateGroupItem)paramList.next();
        ArrayList localArrayList = new ArrayList();
        localArrayList.addAll(((TemplateGroupItem)localObject).a);
        int i1 = 0;
        while (i1 < localArrayList.size())
        {
          localObject = (PtvTemplateInfo)localArrayList.get(i1);
          if ((localObject != null) && (((PtvTemplateInfo)localObject).f) && (!TextUtils.isEmpty(((PtvTemplateInfo)localObject).c))) {
            ThreadManager.getFileThreadHandler().post(new QIMPtvTemplateManager.4(this, (PtvTemplateInfo)localObject));
          }
          i1 += 1;
        }
      }
    }
  }
  
  public boolean a(PtvTemplateInfo paramPtvTemplateInfo)
  {
    if (paramPtvTemplateInfo == null) {
      return false;
    }
    try
    {
      if (paramPtvTemplateInfo.o == 5)
      {
        paramPtvTemplateInfo.O = a(paramPtvTemplateInfo.M, paramPtvTemplateInfo.N, false);
        paramPtvTemplateInfo.R = a(paramPtvTemplateInfo.P, paramPtvTemplateInfo.Q, false);
        bool1 = a(paramPtvTemplateInfo.e, paramPtvTemplateInfo.d, false);
        if (QLog.isColorLevel()) {
          QLog.d("QIMPtvTemplateManager", 2, String.format("isDGTemplateUsage stage[%s], model[%s], total[%s], id[%s]", new Object[] { Boolean.valueOf(paramPtvTemplateInfo.O), Boolean.valueOf(paramPtvTemplateInfo.R), Boolean.valueOf(bool1), paramPtvTemplateInfo.a }));
        }
        if (paramPtvTemplateInfo.O)
        {
          boolean bool2 = paramPtvTemplateInfo.R;
          if (bool2) {
            return bool1;
          }
        }
        return false;
      }
      if (paramPtvTemplateInfo.o == 6)
      {
        paramPtvTemplateInfo.O = a(paramPtvTemplateInfo.M, paramPtvTemplateInfo.N, false);
        if (paramPtvTemplateInfo.O)
        {
          bool1 = a(paramPtvTemplateInfo.e, paramPtvTemplateInfo.d, false);
          return bool1;
        }
        return false;
      }
      boolean bool1 = a(paramPtvTemplateInfo.e, paramPtvTemplateInfo.d, true);
      return bool1;
    }
    finally {}
  }
  
  protected List<TemplateGroupItem> b(File paramFile)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QIMPtvTemplateManager", 2, String.format("rebuildTemplateInfos, cur_runnable[%s]", new Object[] { Integer.valueOf(hashCode()) }));
    }
    paramFile = a(paramFile);
    if (TextUtils.isEmpty(paramFile)) {
      return null;
    }
    paramFile = a(this, paramFile);
    if (paramFile != null)
    {
      if (paramFile.isEmpty()) {
        return null;
      }
      Iterator localIterator = paramFile.iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (TemplateGroupItem)localIterator.next();
        if ((((TemplateGroupItem)localObject).a != null) && (((TemplateGroupItem)localObject).a.size() != 0))
        {
          localObject = ((TemplateGroupItem)localObject).a.iterator();
          while (((Iterator)localObject).hasNext())
          {
            PtvTemplateInfo localPtvTemplateInfo = (PtvTemplateInfo)((Iterator)localObject).next();
            if (localPtvTemplateInfo != null) {
              localPtvTemplateInfo.g = a(localPtvTemplateInfo);
            }
          }
        }
      }
      f();
      return paramFile;
    }
    return null;
  }
  
  public void b()
  {
    h();
  }
  
  public void b(AppInterface paramAppInterface, PtvTemplateInfo paramPtvTemplateInfo, PtvTemplateManager.IPtvTemplateDownloadListener paramIPtvTemplateDownloadListener)
  {
    if (paramPtvTemplateInfo != null)
    {
      if (paramAppInterface == null) {
        return;
      }
      paramPtvTemplateInfo.W = System.currentTimeMillis();
      HttpNetReq localHttpNetReq = new HttpNetReq();
      localHttpNetReq.mCallback = new QIMPtvTemplateManager.6(this, paramPtvTemplateInfo, paramIPtvTemplateDownloadListener);
      localHttpNetReq.mReqUrl = paramPtvTemplateInfo.c;
      localHttpNetReq.mHttpMethod = 0;
      if (paramPtvTemplateInfo.e == null)
      {
        paramAppInterface = new StringBuilder();
        paramAppInterface.append("startDownloadTemplate fail, info.name is null, url:");
        paramAppInterface.append(paramPtvTemplateInfo.c);
        QLog.i("QIMPtvTemplateManager", 1, paramAppInterface.toString());
        return;
      }
      localHttpNetReq.mOutPath = new File(q, paramPtvTemplateInfo.e).getPath();
      localHttpNetReq.mContinuErrorLimit = NetworkUtil.getConnRetryTimes(NetworkCenter.getInstance().getNetType());
      localHttpNetReq.mExcuteTimeLimit = 60000L;
      try
      {
        ((IHttpEngineService)paramAppInterface.getRuntimeService(IHttpEngineService.class, "all")).sendReq(localHttpNetReq);
      }
      catch (Exception paramAppInterface)
      {
        if (QLog.isColorLevel()) {
          paramAppInterface.printStackTrace();
        }
      }
      localHttpNetReq.mCallback.onUpdateProgeress(localHttpNetReq, 1L, 100L);
      if (QLog.isColorLevel())
      {
        paramAppInterface = new StringBuilder();
        paramAppInterface.append("startDownloadTemplate url: ");
        paramAppInterface.append(paramPtvTemplateInfo.c);
        QLog.i("QIMPtvTemplateManager", 2, paramAppInterface.toString());
      }
    }
  }
  
  public Runnable c(File paramFile)
  {
    return new QIMPtvTemplateManager.5(this, paramFile);
  }
  
  public void d()
  {
    this.s = null;
    if (QLog.isColorLevel()) {
      QLog.d("QIMPtvTemplateManager", 2, "QIMPtvTemplateManager onDestroy");
    }
  }
  
  protected void f()
  {
    ThreadManager.getSubThreadHandler().postDelayed(new QIMPtvTemplateManager.3(this), a.longValue());
  }
  
  public void h()
  {
    File localFile = new File(q, "ptv_template_new.cfg");
    Runnable localRunnable;
    if (!localFile.exists()) {
      localRunnable = a(false);
    } else {
      localRunnable = c(localFile);
    }
    localRunnable.run();
    if (QLog.isDevelopLevel()) {
      QLog.d("QIMPtvTemplateManager", 4, new Object[] { "initTemplateConfig, cacheFile exists:", Boolean.valueOf(localFile.exists()), ", runnable:", Integer.valueOf(localRunnable.hashCode()) });
    }
  }
  
  public ArrayList<TemplateGroupItem> i()
  {
    ArrayList localArrayList = new ArrayList(this.f);
    List localList = j();
    if ((localList != null) && (!localList.isEmpty())) {
      localArrayList.removeAll(localList);
    }
    return localArrayList;
  }
  
  public List<TemplateGroupItem> j()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.f.iterator();
    while (localIterator.hasNext())
    {
      TemplateGroupItem localTemplateGroupItem = (TemplateGroupItem)localIterator.next();
      if (localTemplateGroupItem.d) {
        localArrayList.add(localTemplateGroupItem);
      }
    }
    return localArrayList;
  }
  
  public String k()
  {
    return this.u;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.shortvideo.QIMPtvTemplateManager
 * JD-Core Version:    0.7.0.1
 */