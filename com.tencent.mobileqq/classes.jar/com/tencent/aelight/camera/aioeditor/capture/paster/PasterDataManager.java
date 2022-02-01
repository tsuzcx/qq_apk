package com.tencent.aelight.camera.aioeditor.capture.paster;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.aelight.camera.aioeditor.capture.QIMManager;
import com.tencent.aelight.camera.aioeditor.capture.control.QIMAsyncManager;
import com.tencent.aelight.camera.aioeditor.capture.view.StaticStickerProviderView;
import com.tencent.aelight.camera.aioeditor.doodle.ui.face.FacePackage;
import com.tencent.aelight.camera.aioeditor.doodle.ui.face.InformationFaceConstant;
import com.tencent.aelight.camera.aioeditor.doodle.ui.face.InformationFacePackage;
import com.tencent.aelight.camera.aioeditor.doodle.ui.face.InformationFacePackage.CityRes;
import com.tencent.aelight.camera.aioeditor.doodle.ui.face.InformationFacePackage.InformationPasterChangeListener;
import com.tencent.aelight.camera.aioeditor.doodle.ui.face.InformationFacePackage.Item;
import com.tencent.aelight.camera.aioeditor.doodle.ui.face.LocationFacePackage;
import com.tencent.aelight.camera.aioeditor.doodle.ui.face.LocationFacePackage.Item;
import com.tencent.aelight.camera.aioeditor.doodle.ui.face.NormalFacePackage;
import com.tencent.aelight.camera.aioeditor.takevideo.EditVideoDoodle.DoodleFacePanelAdapter;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.model.DoodleEmojiItem;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.model.DoodleEmojiManager;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.model.DoodleEmojiManager.POIPostersRequestCallback;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.StoryDispatcher;
import com.tencent.biz.qqstory.model.DataProvider.DataUpdateListener;
import com.tencent.biz.qqstory.model.DataProviderManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.WeatherDataProvider;
import com.tencent.biz.qqstory.model.WeatherDataProvider.WeatherInfo;
import com.tencent.biz.qqstory.model.lbs.BasicLocation;
import com.tencent.biz.qqstory.model.lbs.LbsManager;
import com.tencent.biz.qqstory.model.lbs.LbsManager.POIListRequestCallback;
import com.tencent.biz.qqstory.model.lbs.LbsManager.POIListRequestSession;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.richmedia.capture.util.LocationPermissionHelper;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.tribe.data.TroopBarPOI;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.IEventReceiver;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

public class PasterDataManager
  extends QIMAsyncManager
  implements DataProvider.DataUpdateListener<WeatherDataProvider.WeatherInfo>, LbsManager.POIListRequestCallback, IEventReceiver
{
  public static AtomicBoolean j = new AtomicBoolean(false);
  protected boolean a;
  protected EditVideoDoodle.DoodleFacePanelAdapter b;
  protected LocationFacePackage c;
  protected InformationFacePackage d;
  protected Handler e = new Handler(Looper.getMainLooper());
  public LbsManager.POIListRequestSession f = null;
  public CopyOnWriteArrayList<FacePackage> g;
  protected Runnable h = new PasterDataManager.1(this);
  DoodleEmojiManager.POIPostersRequestCallback i = new PasterDataManager.2(this);
  private Context k;
  private PasterDataManager.DoodleEmojiDownloadEventReceiver l;
  private WeatherDataProvider m;
  private boolean n;
  
  private void a(WeatherDataProvider.WeatherInfo paramWeatherInfo)
  {
    if (paramWeatherInfo != null)
    {
      this.d.q = paramWeatherInfo.a;
      if (paramWeatherInfo.b != null)
      {
        paramWeatherInfo = paramWeatherInfo.b.split("\\|");
        Object localObject;
        if ((paramWeatherInfo != null) && (paramWeatherInfo.length == 2))
        {
          localObject = this.d;
          ((InformationFacePackage)localObject).o = paramWeatherInfo[0];
          ((InformationFacePackage)localObject).p = paramWeatherInfo[1];
        }
        paramWeatherInfo = this.d.l.iterator();
        while (paramWeatherInfo.hasNext())
        {
          localObject = (InformationFacePackage.Item)paramWeatherInfo.next();
          if (((InformationFacePackage.Item)localObject).c == 6)
          {
            ((InformationFacePackage.Item)localObject).l = this.d.o;
            ((InformationFacePackage.Item)localObject).m = this.d.p;
            ((InformationFacePackage.Item)localObject).n = this.d.q;
          }
        }
      }
    }
  }
  
  private void a(BasicLocation paramBasicLocation, boolean paramBoolean)
  {
    SLog.b("PasterDataManager", "requestPoiList");
    LbsManager localLbsManager = (LbsManager)SuperManager.a(9);
    BasicLocation localBasicLocation = paramBasicLocation;
    if (paramBasicLocation == null) {
      localBasicLocation = LbsManager.c();
    }
    if (paramBoolean)
    {
      localLbsManager.a(localBasicLocation, null, this);
      return;
    }
    localLbsManager.a(localBasicLocation, this.f, this);
  }
  
  private void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    Object localObject;
    if (paramString1 != null)
    {
      localObject = this.d;
      if ((localObject != null) && (!paramString1.equals(((InformationFacePackage)localObject).n))) {
        this.d.n = paramString1;
      }
    }
    int i2 = 0;
    int i1 = i2;
    if (paramString2 != null)
    {
      paramString1 = this.c;
      i1 = i2;
      if (paramString1 != null)
      {
        i1 = i2;
        if (!paramString2.equals(paramString1.m)) {
          i1 = 1;
        }
      }
    }
    paramString1 = this.c;
    if ((paramString1 != null) && (i1 != 0))
    {
      paramString1.m = paramString2;
      paramString1 = paramString1.k.iterator();
      while (paramString1.hasNext()) {
        ((LocationFacePackage.Item)paramString1.next()).b = paramString2;
      }
      if (paramBoolean) {
        this.b.a(this.c);
      }
    }
    paramString1 = this.d;
    if (paramString1 != null)
    {
      if (i1 != 0)
      {
        paramString1.m = paramString2;
        paramString1 = paramString1.l.iterator();
        while (paramString1.hasNext())
        {
          localObject = (InformationFacePackage.Item)paramString1.next();
          if (((InformationFacePackage.Item)localObject).p) {
            ((InformationFacePackage.Item)localObject).q = paramString2;
          }
        }
      }
      paramString1 = this.d.l.iterator();
      while (paramString1.hasNext())
      {
        paramString2 = (InformationFacePackage.Item)paramString1.next();
        if ((paramString2.c == 7) && (!this.d.n.equals(paramString2.k)) && (this.d.r != null)) {
          a(this.d.r, this.d.n, paramString2);
        }
      }
      if (paramBoolean) {
        this.b.a(this.d);
      }
    }
  }
  
  private void a(Map<String, Map<String, InformationFacePackage.CityRes>> paramMap, String paramString, InformationFacePackage.Item paramItem)
  {
    if (paramItem.a() != null) {
      paramItem.a().g();
    }
    Map localMap = (Map)paramMap.get(paramItem.j);
    if (localMap != null)
    {
      paramString = (InformationFacePackage.CityRes)localMap.get(paramString);
      paramMap = paramString;
      if (paramString == null) {
        paramMap = (InformationFacePackage.CityRes)localMap.get("default");
      }
      if (paramMap != null)
      {
        paramItem.i = paramMap.a;
        paramItem.g = paramMap.b;
        paramItem.h = paramMap.c;
      }
    }
  }
  
  private static void b(NormalFacePackage paramNormalFacePackage, DoodleEmojiItem paramDoodleEmojiItem)
  {
    paramNormalFacePackage.b = paramDoodleEmojiItem.name;
    paramNormalFacePackage.c = paramDoodleEmojiItem.icon;
    paramNormalFacePackage.d = paramDoodleEmojiItem.download_icon;
    paramNormalFacePackage.l = paramDoodleEmojiItem.getLocalEmojiFolderPath();
    paramNormalFacePackage.f = paramDoodleEmojiItem.download_wording;
    paramNormalFacePackage.g = "1".equals(paramDoodleEmojiItem.random_position);
    paramNormalFacePackage.a(paramDoodleEmojiItem.config);
    paramNormalFacePackage.i = paramDoodleEmojiItem.hide;
    paramNormalFacePackage.j = paramDoodleEmojiItem.mask;
  }
  
  private void b(boolean paramBoolean)
  {
    a(null, paramBoolean);
  }
  
  private void j()
  {
    Object localObject = (DoodleEmojiManager)QIMManager.a(14);
    ((DoodleEmojiManager)localObject).a();
    if (this.c == null)
    {
      this.c = new LocationFacePackage("0");
      this.c.l = true;
      String str = DoodleEmojiManager.c((DoodleEmojiManager)localObject, "0");
      localObject = DoodleEmojiManager.a((DoodleEmojiManager)localObject, "0");
      if ((!TextUtils.isEmpty((CharSequence)localObject)) && (NetworkUtil.isNetworkAvailable(this.k))) {
        this.c.c = ((String)localObject);
      } else {
        this.c.e = this.k.getResources().getDrawable(2130848387);
      }
      this.c.a(str);
    }
    if (this.d == null) {
      this.d = new InformationFacePackage("2001");
    }
  }
  
  @NonNull
  public List<FacePackage> a(boolean paramBoolean)
  {
    try
    {
      if ((this.g == null) || (this.g.size() == 0))
      {
        localObject1 = ((DoodleEmojiManager)QIMManager.a(14)).e();
        this.g = new CopyOnWriteArrayList();
        localObject1 = ((Collection)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          DoodleEmojiItem localDoodleEmojiItem = (DoodleEmojiItem)((Iterator)localObject1).next();
          Object localObject3;
          if (localDoodleEmojiItem.type == 1)
          {
            localObject3 = new NormalFacePackage(localDoodleEmojiItem.pack_id);
            b((NormalFacePackage)localObject3, localDoodleEmojiItem);
            if (("1".equals(((NormalFacePackage)localObject3).a)) && (!NetworkUtil.isNetworkAvailable(this.k))) {
              ((NormalFacePackage)localObject3).e = this.k.getResources().getDrawable(2130848246);
            }
            this.g.add(localObject3);
          }
          else
          {
            Object localObject4;
            if (localDoodleEmojiItem.type == 2)
            {
              this.c.b = localDoodleEmojiItem.name;
              if ((!TextUtils.isEmpty(localDoodleEmojiItem.icon)) && (NetworkUtil.isNetworkAvailable(this.k))) {
                this.c.c = localDoodleEmojiItem.icon;
              } else {
                this.c.e = this.k.getResources().getDrawable(2130848387);
              }
              if (localDoodleEmojiItem.mItemList != null)
              {
                this.c.k = localDoodleEmojiItem.mItemList;
                if (localDoodleEmojiItem.mItemList != null)
                {
                  localObject3 = new StringBuilder();
                  ((StringBuilder)localObject3).append("add doodle emoji location item name = ");
                  ((StringBuilder)localObject3).append(this.c.m);
                  SLog.b("PasterDataManager", ((StringBuilder)localObject3).toString());
                  localObject3 = localDoodleEmojiItem.mItemList.iterator();
                  while (((Iterator)localObject3).hasNext())
                  {
                    localObject4 = (LocationFacePackage.Item)((Iterator)localObject3).next();
                    ((LocationFacePackage.Item)localObject4).i = this.c.b;
                    ((LocationFacePackage.Item)localObject4).b = this.c.m;
                  }
                }
              }
              this.c.g = "1".equals(localDoodleEmojiItem.random_position);
              this.c.i = localDoodleEmojiItem.hide;
              this.c.j = localDoodleEmojiItem.mask;
              this.g.add(this.c);
            }
            else if (localDoodleEmojiItem.type == 3)
            {
              if (this.d == null) {
                this.d = new InformationFacePackage(localDoodleEmojiItem.pack_id);
              } else {
                this.d.a = localDoodleEmojiItem.pack_id;
              }
              this.d.b = localDoodleEmojiItem.name;
              this.d.l = localDoodleEmojiItem.mInfoItemList;
              this.d.a(localDoodleEmojiItem.config);
              this.d.i = localDoodleEmojiItem.hide;
              this.d.n = "default";
              this.d.q = -999;
              this.d.o = "--";
              this.d.p = "default";
              if (this.d.l != null)
              {
                localObject3 = this.d.l.iterator();
                while (((Iterator)localObject3).hasNext())
                {
                  localObject4 = (InformationFacePackage.Item)((Iterator)localObject3).next();
                  ((InformationFacePackage.Item)localObject4).t = this.d.b;
                  if (InformationFaceConstant.a(((InformationFacePackage.Item)localObject4).c)) {
                    ((InformationFacePackage.Item)localObject4).q = this.d.m;
                  }
                  if ((localDoodleEmojiItem.mCityRes != null) && (((InformationFacePackage.Item)localObject4).c == 7)) {
                    a(localDoodleEmojiItem.mCityRes, this.d.n, (InformationFacePackage.Item)localObject4);
                  }
                  if (((InformationFacePackage.Item)localObject4).c == 6)
                  {
                    ((InformationFacePackage.Item)localObject4).n = this.d.q;
                    ((InformationFacePackage.Item)localObject4).l = this.d.o;
                    ((InformationFacePackage.Item)localObject4).m = this.d.p;
                  }
                }
              }
              this.g.add(this.d);
              this.d.r = localDoodleEmojiItem.mCityRes;
            }
          }
        }
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("getDoodleFacePackages, size = ");
        ((StringBuilder)localObject1).append(this.g.size());
        SLog.b("PasterDataManager", ((StringBuilder)localObject1).toString());
        j.set(true);
      }
      if (paramBoolean)
      {
        StaticStickerProviderView.a(this.g);
        j.set(true);
      }
      Object localObject1 = this.g;
      return localObject1;
    }
    finally {}
    for (;;)
    {
      throw localObject2;
    }
  }
  
  public void a(int paramInt, LbsManager.POIListRequestSession paramPOIListRequestSession, List<TroopBarPOI> paramList)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onPOIListRequestResult.");
    ((StringBuilder)localObject).append(paramInt);
    SLog.b("PasterDataManager", ((StringBuilder)localObject).toString());
    if ((paramInt == 0) && (paramPOIListRequestSession != null))
    {
      this.f = paramPOIListRequestSession;
      if ((paramList != null) && (paramList.size() > 0))
      {
        localObject = ((TroopBarPOI)paramList.get(0)).b();
        if (QLog.isColorLevel())
        {
          paramPOIListRequestSession = new StringBuilder();
          paramPOIListRequestSession.append("onPOIListRequestResult ");
          paramPOIListRequestSession.append((String)localObject);
          QLog.d("PasterDataManager", 2, paramPOIListRequestSession.toString());
        }
        String str = ShortVideoUtils.getRecentPOI(QQStoryContext.k().getCurrentAccountUin());
        Iterator localIterator = paramList.iterator();
        do
        {
          paramPOIListRequestSession = (LbsManager.POIListRequestSession)localObject;
          if (!localIterator.hasNext()) {
            break;
          }
        } while (!((TroopBarPOI)localIterator.next()).b().equals(str));
        paramPOIListRequestSession = str;
        a(((TroopBarPOI)paramList.get(0)).b, paramPOIListRequestSession, true);
      }
    }
  }
  
  public void a(BasicLocation paramBasicLocation)
  {
    this.m = ((WeatherDataProvider)((DataProviderManager)SuperManager.a(20)).a(0));
    Object localObject = this.m.c();
    if (localObject != null)
    {
      SLog.b("PasterDataManager", "get weather from cache.");
      a((WeatherDataProvider.WeatherInfo)localObject);
      return;
    }
    SLog.b("PasterDataManager", "get weather from net.");
    localObject = paramBasicLocation;
    if (paramBasicLocation == null) {
      localObject = LbsManager.c();
    }
    this.m.a(this);
    this.m.b((BasicLocation)localObject);
  }
  
  public void a(String paramString)
  {
    a(null, paramString, false);
  }
  
  public void a(boolean paramBoolean, Activity paramActivity)
  {
    if (this.n)
    {
      InformationFacePackage localInformationFacePackage = this.d;
      if ((localInformationFacePackage != null) && (!"default".equals(localInformationFacePackage.n)) && (!"--".equals(this.d.o))) {
        return;
      }
    }
    new LocationPermissionHelper(paramActivity, new PasterDataManager.3(this, paramBoolean)).a();
  }
  
  public void a(boolean paramBoolean, WeatherDataProvider.WeatherInfo paramWeatherInfo)
  {
    if (paramBoolean) {
      a(paramWeatherInfo);
    }
  }
  
  public FacePackage b(String paramString)
  {
    return this.b.a(paramString);
  }
  
  public void b()
  {
    this.k = BaseApplicationImpl.getContext();
    this.b = new EditVideoDoodle.DoodleFacePanelAdapter();
    j();
    this.l = new PasterDataManager.DoodleEmojiDownloadEventReceiver(this);
    StoryDispatcher.a().registerSubscriber(this.l);
    if (QLog.isDevelopLevel()) {
      QLog.d("PasterDataManager", 4, "initPasterConfig");
    }
  }
  
  public void d()
  {
    if (this.l != null)
    {
      StoryDispatcher.a().unRegisterSubscriber(this.l);
      this.l = null;
    }
    WeatherDataProvider localWeatherDataProvider = this.m;
    if (localWeatherDataProvider != null) {
      localWeatherDataProvider.b(this);
    }
  }
  
  public EditVideoDoodle.DoodleFacePanelAdapter e()
  {
    return this.b;
  }
  
  public List<FacePackage> f()
  {
    return a(false);
  }
  
  public String h()
  {
    LocationFacePackage localLocationFacePackage = this.c;
    if (localLocationFacePackage != null) {
      return localLocationFacePackage.m;
    }
    return null;
  }
  
  public void i()
  {
    this.n = false;
  }
  
  public boolean isValidate()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.paster.PasterDataManager
 * JD-Core Version:    0.7.0.1
 */