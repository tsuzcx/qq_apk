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
  public static AtomicBoolean a;
  private Context jdField_a_of_type_AndroidContentContext;
  protected Handler a;
  private PasterDataManager.DoodleEmojiDownloadEventReceiver jdField_a_of_type_ComTencentAelightCameraAioeditorCapturePasterPasterDataManager$DoodleEmojiDownloadEventReceiver;
  protected InformationFacePackage a;
  protected LocationFacePackage a;
  protected EditVideoDoodle.DoodleFacePanelAdapter a;
  DoodleEmojiManager.POIPostersRequestCallback jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleModelDoodleEmojiManager$POIPostersRequestCallback = new PasterDataManager.2(this);
  private WeatherDataProvider jdField_a_of_type_ComTencentBizQqstoryModelWeatherDataProvider;
  public LbsManager.POIListRequestSession a;
  protected Runnable a;
  public CopyOnWriteArrayList<FacePackage> a;
  protected boolean a;
  private boolean b;
  
  static
  {
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  }
  
  public PasterDataManager()
  {
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_a_of_type_ComTencentBizQqstoryModelLbsLbsManager$POIListRequestSession = null;
    this.jdField_a_of_type_JavaLangRunnable = new PasterDataManager.1(this);
  }
  
  private void a(WeatherDataProvider.WeatherInfo paramWeatherInfo)
  {
    if (paramWeatherInfo != null)
    {
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorDoodleUiFaceInformationFacePackage.c = paramWeatherInfo.jdField_a_of_type_Int;
      if (paramWeatherInfo.jdField_a_of_type_JavaLangString != null)
      {
        paramWeatherInfo = paramWeatherInfo.jdField_a_of_type_JavaLangString.split("\\|");
        Object localObject;
        if ((paramWeatherInfo != null) && (paramWeatherInfo.length == 2))
        {
          localObject = this.jdField_a_of_type_ComTencentAelightCameraAioeditorDoodleUiFaceInformationFacePackage;
          ((InformationFacePackage)localObject).h = paramWeatherInfo[0];
          ((InformationFacePackage)localObject).i = paramWeatherInfo[1];
        }
        paramWeatherInfo = this.jdField_a_of_type_ComTencentAelightCameraAioeditorDoodleUiFaceInformationFacePackage.jdField_a_of_type_JavaUtilList.iterator();
        while (paramWeatherInfo.hasNext())
        {
          localObject = (InformationFacePackage.Item)paramWeatherInfo.next();
          if (((InformationFacePackage.Item)localObject).jdField_a_of_type_Int == 6)
          {
            ((InformationFacePackage.Item)localObject).j = this.jdField_a_of_type_ComTencentAelightCameraAioeditorDoodleUiFaceInformationFacePackage.h;
            ((InformationFacePackage.Item)localObject).k = this.jdField_a_of_type_ComTencentAelightCameraAioeditorDoodleUiFaceInformationFacePackage.i;
            ((InformationFacePackage.Item)localObject).c = this.jdField_a_of_type_ComTencentAelightCameraAioeditorDoodleUiFaceInformationFacePackage.c;
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
      localBasicLocation = LbsManager.a();
    }
    if (paramBoolean)
    {
      localLbsManager.a(localBasicLocation, null, this);
      return;
    }
    localLbsManager.a(localBasicLocation, this.jdField_a_of_type_ComTencentBizQqstoryModelLbsLbsManager$POIListRequestSession, this);
  }
  
  private void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    Object localObject;
    if (paramString1 != null)
    {
      localObject = this.jdField_a_of_type_ComTencentAelightCameraAioeditorDoodleUiFaceInformationFacePackage;
      if ((localObject != null) && (!paramString1.equals(((InformationFacePackage)localObject).g))) {
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorDoodleUiFaceInformationFacePackage.g = paramString1;
      }
    }
    int j = 0;
    int i = j;
    if (paramString2 != null)
    {
      paramString1 = this.jdField_a_of_type_ComTencentAelightCameraAioeditorDoodleUiFaceLocationFacePackage;
      i = j;
      if (paramString1 != null)
      {
        i = j;
        if (!paramString2.equals(paramString1.f)) {
          i = 1;
        }
      }
    }
    paramString1 = this.jdField_a_of_type_ComTencentAelightCameraAioeditorDoodleUiFaceLocationFacePackage;
    if ((paramString1 != null) && (i != 0))
    {
      paramString1.f = paramString2;
      paramString1 = paramString1.jdField_a_of_type_JavaUtilList.iterator();
      while (paramString1.hasNext()) {
        ((LocationFacePackage.Item)paramString1.next()).jdField_b_of_type_JavaLangString = paramString2;
      }
      if (paramBoolean) {
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoDoodle$DoodleFacePanelAdapter.a(this.jdField_a_of_type_ComTencentAelightCameraAioeditorDoodleUiFaceLocationFacePackage);
      }
    }
    paramString1 = this.jdField_a_of_type_ComTencentAelightCameraAioeditorDoodleUiFaceInformationFacePackage;
    if (paramString1 != null)
    {
      if (i != 0)
      {
        paramString1.f = paramString2;
        paramString1 = paramString1.jdField_a_of_type_JavaUtilList.iterator();
        while (paramString1.hasNext())
        {
          localObject = (InformationFacePackage.Item)paramString1.next();
          if (((InformationFacePackage.Item)localObject).jdField_a_of_type_Boolean) {
            ((InformationFacePackage.Item)localObject).l = paramString2;
          }
        }
      }
      paramString1 = this.jdField_a_of_type_ComTencentAelightCameraAioeditorDoodleUiFaceInformationFacePackage.jdField_a_of_type_JavaUtilList.iterator();
      while (paramString1.hasNext())
      {
        paramString2 = (InformationFacePackage.Item)paramString1.next();
        if ((paramString2.jdField_a_of_type_Int == 7) && (!this.jdField_a_of_type_ComTencentAelightCameraAioeditorDoodleUiFaceInformationFacePackage.g.equals(paramString2.i)) && (this.jdField_a_of_type_ComTencentAelightCameraAioeditorDoodleUiFaceInformationFacePackage.jdField_a_of_type_JavaUtilMap != null)) {
          a(this.jdField_a_of_type_ComTencentAelightCameraAioeditorDoodleUiFaceInformationFacePackage.jdField_a_of_type_JavaUtilMap, this.jdField_a_of_type_ComTencentAelightCameraAioeditorDoodleUiFaceInformationFacePackage.g, paramString2);
        }
      }
      if (paramBoolean) {
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoDoodle$DoodleFacePanelAdapter.a(this.jdField_a_of_type_ComTencentAelightCameraAioeditorDoodleUiFaceInformationFacePackage);
      }
    }
  }
  
  private void a(Map<String, Map<String, InformationFacePackage.CityRes>> paramMap, String paramString, InformationFacePackage.Item paramItem)
  {
    if (paramItem.a() != null) {
      paramItem.a().c();
    }
    Map localMap = (Map)paramMap.get(paramItem.h);
    if (localMap != null)
    {
      paramString = (InformationFacePackage.CityRes)localMap.get(paramString);
      paramMap = paramString;
      if (paramString == null) {
        paramMap = (InformationFacePackage.CityRes)localMap.get("default");
      }
      if (paramMap != null)
      {
        paramItem.g = paramMap.jdField_a_of_type_JavaLangString;
        paramItem.e = paramMap.jdField_b_of_type_JavaLangString;
        paramItem.f = paramMap.c;
      }
    }
  }
  
  private void a(boolean paramBoolean)
  {
    a(null, paramBoolean);
  }
  
  private static void b(NormalFacePackage paramNormalFacePackage, DoodleEmojiItem paramDoodleEmojiItem)
  {
    paramNormalFacePackage.jdField_b_of_type_JavaLangString = paramDoodleEmojiItem.name;
    paramNormalFacePackage.c = paramDoodleEmojiItem.icon;
    paramNormalFacePackage.d = paramDoodleEmojiItem.download_icon;
    paramNormalFacePackage.g = paramDoodleEmojiItem.getLocalEmojiFolderPath();
    paramNormalFacePackage.e = paramDoodleEmojiItem.download_wording;
    paramNormalFacePackage.jdField_a_of_type_Boolean = "1".equals(paramDoodleEmojiItem.random_position);
    paramNormalFacePackage.a(paramDoodleEmojiItem.config);
    paramNormalFacePackage.jdField_a_of_type_Int = paramDoodleEmojiItem.hide;
    paramNormalFacePackage.jdField_b_of_type_Int = paramDoodleEmojiItem.mask;
  }
  
  private void f()
  {
    Object localObject = (DoodleEmojiManager)QIMManager.a(14);
    ((DoodleEmojiManager)localObject).c();
    if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorDoodleUiFaceLocationFacePackage == null)
    {
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorDoodleUiFaceLocationFacePackage = new LocationFacePackage("0");
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorDoodleUiFaceLocationFacePackage.jdField_b_of_type_Boolean = true;
      String str = DoodleEmojiManager.c((DoodleEmojiManager)localObject, "0");
      localObject = DoodleEmojiManager.a((DoodleEmojiManager)localObject, "0");
      if ((!TextUtils.isEmpty((CharSequence)localObject)) && (NetworkUtil.isNetworkAvailable(this.jdField_a_of_type_AndroidContentContext))) {
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorDoodleUiFaceLocationFacePackage.c = ((String)localObject);
      } else {
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorDoodleUiFaceLocationFacePackage.jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130846835);
      }
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorDoodleUiFaceLocationFacePackage.a(str);
    }
    if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorDoodleUiFaceInformationFacePackage == null) {
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorDoodleUiFaceInformationFacePackage = new InformationFacePackage("2001");
    }
  }
  
  public FacePackage a(String paramString)
  {
    return this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoDoodle$DoodleFacePanelAdapter.a(paramString);
  }
  
  public EditVideoDoodle.DoodleFacePanelAdapter a()
  {
    return this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoDoodle$DoodleFacePanelAdapter;
  }
  
  public String a()
  {
    LocationFacePackage localLocationFacePackage = this.jdField_a_of_type_ComTencentAelightCameraAioeditorDoodleUiFaceLocationFacePackage;
    if (localLocationFacePackage != null) {
      return localLocationFacePackage.f;
    }
    return null;
  }
  
  public List<FacePackage> a()
  {
    return a(false);
  }
  
  @NonNull
  public List<FacePackage> a(boolean paramBoolean)
  {
    try
    {
      if ((this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList == null) || (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size() == 0))
      {
        localObject1 = ((DoodleEmojiManager)QIMManager.a(14)).a();
        this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
        localObject1 = ((Collection)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          DoodleEmojiItem localDoodleEmojiItem = (DoodleEmojiItem)((Iterator)localObject1).next();
          Object localObject3;
          if (localDoodleEmojiItem.type == 1)
          {
            localObject3 = new NormalFacePackage(localDoodleEmojiItem.pack_id);
            b((NormalFacePackage)localObject3, localDoodleEmojiItem);
            if (("1".equals(((NormalFacePackage)localObject3).jdField_a_of_type_JavaLangString)) && (!NetworkUtil.isNetworkAvailable(this.jdField_a_of_type_AndroidContentContext))) {
              ((NormalFacePackage)localObject3).jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130846694);
            }
            this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(localObject3);
          }
          else
          {
            Object localObject4;
            if (localDoodleEmojiItem.type == 2)
            {
              this.jdField_a_of_type_ComTencentAelightCameraAioeditorDoodleUiFaceLocationFacePackage.jdField_b_of_type_JavaLangString = localDoodleEmojiItem.name;
              if ((!TextUtils.isEmpty(localDoodleEmojiItem.icon)) && (NetworkUtil.isNetworkAvailable(this.jdField_a_of_type_AndroidContentContext))) {
                this.jdField_a_of_type_ComTencentAelightCameraAioeditorDoodleUiFaceLocationFacePackage.c = localDoodleEmojiItem.icon;
              } else {
                this.jdField_a_of_type_ComTencentAelightCameraAioeditorDoodleUiFaceLocationFacePackage.jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130846835);
              }
              if (localDoodleEmojiItem.mItemList != null)
              {
                this.jdField_a_of_type_ComTencentAelightCameraAioeditorDoodleUiFaceLocationFacePackage.jdField_a_of_type_JavaUtilList = localDoodleEmojiItem.mItemList;
                if (localDoodleEmojiItem.mItemList != null)
                {
                  localObject3 = new StringBuilder();
                  ((StringBuilder)localObject3).append("add doodle emoji location item name = ");
                  ((StringBuilder)localObject3).append(this.jdField_a_of_type_ComTencentAelightCameraAioeditorDoodleUiFaceLocationFacePackage.f);
                  SLog.b("PasterDataManager", ((StringBuilder)localObject3).toString());
                  localObject3 = localDoodleEmojiItem.mItemList.iterator();
                  while (((Iterator)localObject3).hasNext())
                  {
                    localObject4 = (LocationFacePackage.Item)((Iterator)localObject3).next();
                    ((LocationFacePackage.Item)localObject4).g = this.jdField_a_of_type_ComTencentAelightCameraAioeditorDoodleUiFaceLocationFacePackage.jdField_b_of_type_JavaLangString;
                    ((LocationFacePackage.Item)localObject4).jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAelightCameraAioeditorDoodleUiFaceLocationFacePackage.f;
                  }
                }
              }
              this.jdField_a_of_type_ComTencentAelightCameraAioeditorDoodleUiFaceLocationFacePackage.jdField_a_of_type_Boolean = "1".equals(localDoodleEmojiItem.random_position);
              this.jdField_a_of_type_ComTencentAelightCameraAioeditorDoodleUiFaceLocationFacePackage.jdField_a_of_type_Int = localDoodleEmojiItem.hide;
              this.jdField_a_of_type_ComTencentAelightCameraAioeditorDoodleUiFaceLocationFacePackage.jdField_b_of_type_Int = localDoodleEmojiItem.mask;
              this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(this.jdField_a_of_type_ComTencentAelightCameraAioeditorDoodleUiFaceLocationFacePackage);
            }
            else if (localDoodleEmojiItem.type == 3)
            {
              if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorDoodleUiFaceInformationFacePackage == null) {
                this.jdField_a_of_type_ComTencentAelightCameraAioeditorDoodleUiFaceInformationFacePackage = new InformationFacePackage(localDoodleEmojiItem.pack_id);
              } else {
                this.jdField_a_of_type_ComTencentAelightCameraAioeditorDoodleUiFaceInformationFacePackage.jdField_a_of_type_JavaLangString = localDoodleEmojiItem.pack_id;
              }
              this.jdField_a_of_type_ComTencentAelightCameraAioeditorDoodleUiFaceInformationFacePackage.jdField_b_of_type_JavaLangString = localDoodleEmojiItem.name;
              this.jdField_a_of_type_ComTencentAelightCameraAioeditorDoodleUiFaceInformationFacePackage.jdField_a_of_type_JavaUtilList = localDoodleEmojiItem.mInfoItemList;
              this.jdField_a_of_type_ComTencentAelightCameraAioeditorDoodleUiFaceInformationFacePackage.a(localDoodleEmojiItem.config);
              this.jdField_a_of_type_ComTencentAelightCameraAioeditorDoodleUiFaceInformationFacePackage.jdField_a_of_type_Int = localDoodleEmojiItem.hide;
              this.jdField_a_of_type_ComTencentAelightCameraAioeditorDoodleUiFaceInformationFacePackage.g = "default";
              this.jdField_a_of_type_ComTencentAelightCameraAioeditorDoodleUiFaceInformationFacePackage.c = -999;
              this.jdField_a_of_type_ComTencentAelightCameraAioeditorDoodleUiFaceInformationFacePackage.h = "--";
              this.jdField_a_of_type_ComTencentAelightCameraAioeditorDoodleUiFaceInformationFacePackage.i = "default";
              if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorDoodleUiFaceInformationFacePackage.jdField_a_of_type_JavaUtilList != null)
              {
                localObject3 = this.jdField_a_of_type_ComTencentAelightCameraAioeditorDoodleUiFaceInformationFacePackage.jdField_a_of_type_JavaUtilList.iterator();
                while (((Iterator)localObject3).hasNext())
                {
                  localObject4 = (InformationFacePackage.Item)((Iterator)localObject3).next();
                  ((InformationFacePackage.Item)localObject4).m = this.jdField_a_of_type_ComTencentAelightCameraAioeditorDoodleUiFaceInformationFacePackage.jdField_b_of_type_JavaLangString;
                  if (InformationFaceConstant.a(((InformationFacePackage.Item)localObject4).jdField_a_of_type_Int)) {
                    ((InformationFacePackage.Item)localObject4).l = this.jdField_a_of_type_ComTencentAelightCameraAioeditorDoodleUiFaceInformationFacePackage.f;
                  }
                  if ((localDoodleEmojiItem.mCityRes != null) && (((InformationFacePackage.Item)localObject4).jdField_a_of_type_Int == 7)) {
                    a(localDoodleEmojiItem.mCityRes, this.jdField_a_of_type_ComTencentAelightCameraAioeditorDoodleUiFaceInformationFacePackage.g, (InformationFacePackage.Item)localObject4);
                  }
                  if (((InformationFacePackage.Item)localObject4).jdField_a_of_type_Int == 6)
                  {
                    ((InformationFacePackage.Item)localObject4).c = this.jdField_a_of_type_ComTencentAelightCameraAioeditorDoodleUiFaceInformationFacePackage.c;
                    ((InformationFacePackage.Item)localObject4).j = this.jdField_a_of_type_ComTencentAelightCameraAioeditorDoodleUiFaceInformationFacePackage.h;
                    ((InformationFacePackage.Item)localObject4).k = this.jdField_a_of_type_ComTencentAelightCameraAioeditorDoodleUiFaceInformationFacePackage.i;
                  }
                }
              }
              this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(this.jdField_a_of_type_ComTencentAelightCameraAioeditorDoodleUiFaceInformationFacePackage);
              this.jdField_a_of_type_ComTencentAelightCameraAioeditorDoodleUiFaceInformationFacePackage.jdField_a_of_type_JavaUtilMap = localDoodleEmojiItem.mCityRes;
            }
          }
        }
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("getDoodleFacePackages, size = ");
        ((StringBuilder)localObject1).append(this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size());
        SLog.b("PasterDataManager", ((StringBuilder)localObject1).toString());
        jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
      }
      if (paramBoolean)
      {
        StaticStickerProviderView.a(this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList);
        jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
      }
      Object localObject1 = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList;
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
      this.jdField_a_of_type_ComTencentBizQqstoryModelLbsLbsManager$POIListRequestSession = paramPOIListRequestSession;
      if ((paramList != null) && (paramList.size() > 0))
      {
        localObject = ((TroopBarPOI)paramList.get(0)).a();
        if (QLog.isColorLevel())
        {
          paramPOIListRequestSession = new StringBuilder();
          paramPOIListRequestSession.append("onPOIListRequestResult ");
          paramPOIListRequestSession.append((String)localObject);
          QLog.d("PasterDataManager", 2, paramPOIListRequestSession.toString());
        }
        String str = ShortVideoUtils.getRecentPOI(QQStoryContext.a().getCurrentAccountUin());
        Iterator localIterator = paramList.iterator();
        do
        {
          paramPOIListRequestSession = (LbsManager.POIListRequestSession)localObject;
          if (!localIterator.hasNext()) {
            break;
          }
        } while (!((TroopBarPOI)localIterator.next()).a().equals(str));
        paramPOIListRequestSession = str;
        a(((TroopBarPOI)paramList.get(0)).jdField_b_of_type_JavaLangString, paramPOIListRequestSession, true);
      }
    }
  }
  
  public void a(BasicLocation paramBasicLocation)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryModelWeatherDataProvider = ((WeatherDataProvider)((DataProviderManager)SuperManager.a(20)).a(0));
    Object localObject = this.jdField_a_of_type_ComTencentBizQqstoryModelWeatherDataProvider.a();
    if (localObject != null)
    {
      SLog.b("PasterDataManager", "get weather from cache.");
      a((WeatherDataProvider.WeatherInfo)localObject);
      return;
    }
    SLog.b("PasterDataManager", "get weather from net.");
    localObject = paramBasicLocation;
    if (paramBasicLocation == null) {
      localObject = LbsManager.a();
    }
    this.jdField_a_of_type_ComTencentBizQqstoryModelWeatherDataProvider.a(this);
    this.jdField_a_of_type_ComTencentBizQqstoryModelWeatherDataProvider.b((BasicLocation)localObject);
  }
  
  public void a(String paramString)
  {
    a(null, paramString, false);
  }
  
  public void a(boolean paramBoolean, Activity paramActivity)
  {
    if (this.jdField_b_of_type_Boolean)
    {
      InformationFacePackage localInformationFacePackage = this.jdField_a_of_type_ComTencentAelightCameraAioeditorDoodleUiFaceInformationFacePackage;
      if ((localInformationFacePackage != null) && (!"default".equals(localInformationFacePackage.g)) && (!"--".equals(this.jdField_a_of_type_ComTencentAelightCameraAioeditorDoodleUiFaceInformationFacePackage.h))) {
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
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorCapturePasterPasterDataManager$DoodleEmojiDownloadEventReceiver != null)
    {
      StoryDispatcher.a().unRegisterSubscriber(this.jdField_a_of_type_ComTencentAelightCameraAioeditorCapturePasterPasterDataManager$DoodleEmojiDownloadEventReceiver);
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorCapturePasterPasterDataManager$DoodleEmojiDownloadEventReceiver = null;
    }
    WeatherDataProvider localWeatherDataProvider = this.jdField_a_of_type_ComTencentBizQqstoryModelWeatherDataProvider;
    if (localWeatherDataProvider != null) {
      localWeatherDataProvider.b(this);
    }
  }
  
  public void d()
  {
    this.jdField_a_of_type_AndroidContentContext = BaseApplicationImpl.getContext();
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoDoodle$DoodleFacePanelAdapter = new EditVideoDoodle.DoodleFacePanelAdapter();
    f();
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorCapturePasterPasterDataManager$DoodleEmojiDownloadEventReceiver = new PasterDataManager.DoodleEmojiDownloadEventReceiver(this);
    StoryDispatcher.a().registerSubscriber(this.jdField_a_of_type_ComTencentAelightCameraAioeditorCapturePasterPasterDataManager$DoodleEmojiDownloadEventReceiver);
    if (QLog.isDevelopLevel()) {
      QLog.d("PasterDataManager", 4, "initPasterConfig");
    }
  }
  
  public void e()
  {
    this.jdField_b_of_type_Boolean = false;
  }
  
  public boolean isValidate()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.paster.PasterDataManager
 * JD-Core Version:    0.7.0.1
 */