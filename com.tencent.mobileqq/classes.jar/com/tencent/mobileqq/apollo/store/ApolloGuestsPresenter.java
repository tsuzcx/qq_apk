package com.tencent.mobileqq.apollo.store;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.RectF;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.mobileqq.apollo.handler.ApolloExtensionHandler;
import com.tencent.mobileqq.apollo.handler.ApolloExtensionObserver;
import com.tencent.mobileqq.apollo.model.ApolloBaseInfo;
import com.tencent.mobileqq.apollo.model.ApolloDress;
import com.tencent.mobileqq.apollo.model.ApolloDress.Dress;
import com.tencent.mobileqq.apollo.persistence.api.IApolloDaoManagerService;
import com.tencent.mobileqq.apollo.persistence.api.impl.ApolloDaoManagerServiceImpl;
import com.tencent.mobileqq.apollo.res.api.IApolloResHelper;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloTextureView;
import com.tencent.mobileqq.cmshow.brickengine.apollo.OnDressDoneListener;
import com.tencent.mobileqq.cmshow.engine.resource.ApolloResManagerFacade;
import com.tencent.mobileqq.cmshow.engine.resource.IApolloResDownloader.OnApolloDownLoadListener;
import com.tencent.mobileqq.cmshow.engine.resource.IApolloResManager;
import com.tencent.mobileqq.cmshow.engine.scene.Scene;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONObject;

public class ApolloGuestsPresenter
  implements OnDressDoneListener
{
  ApolloExtensionObserver a = new ApolloGuestsPresenter.1(this);
  private IApolloGuestsView b;
  private QQAppInterface c;
  private String d;
  private ApolloTextureView e;
  private boolean f = false;
  private int g;
  private Context h;
  private float i = 0.0F;
  private IApolloResDownloader.OnApolloDownLoadListener j = new ApolloGuestsPresenter.2(this);
  
  public ApolloGuestsPresenter(IApolloGuestsView paramIApolloGuestsView, QQAppInterface paramQQAppInterface, Context paramContext, String paramString, ApolloTextureView paramApolloTextureView)
  {
    this.b = paramIApolloGuestsView;
    this.d = paramString;
    this.c = paramQQAppInterface;
    this.e = paramApolloTextureView;
    this.h = paramContext;
    this.i = paramContext.getResources().getDisplayMetrics().density;
    this.c.addObserver(this.a);
  }
  
  private int a(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 1) {
      return 1;
    }
    if (paramInt2 == 9) {
      return 2;
    }
    return 0;
  }
  
  public List<DressDescriptionItem> a(ApolloDress paramApolloDress)
  {
    if (paramApolloDress == null) {
      return null;
    }
    try
    {
      Object localObject1 = paramApolloDress.dressMap;
      if (localObject1 == null) {
        return null;
      }
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = ((HashMap)localObject1).entrySet().iterator();
      int k;
      while (localIterator.hasNext())
      {
        DressDescriptionItem localDressDescriptionItem = new DressDescriptionItem();
        localObject1 = (Map.Entry)localIterator.next();
        if (localObject1 != null)
        {
          k = ((Integer)((Map.Entry)localObject1).getKey()).intValue();
          localDressDescriptionItem.a = k;
          ApolloDress.Dress localDress = (ApolloDress.Dress)((Map.Entry)localObject1).getValue();
          if ((localDress != null) && (localDress.attachPart != null) && (localDress.attachPart.size() != 0))
          {
            localDressDescriptionItem.h = a(localDress.tag, localDress.feeType);
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/dress/");
            ((StringBuilder)localObject1).append(k);
            ((StringBuilder)localObject1).append("/config.json");
            localObject1 = new File(((StringBuilder)localObject1).toString());
            if (((File)localObject1).exists()) {
              localObject1 = FileUtils.fileToBytes((File)localObject1);
            } else {
              localObject1 = null;
            }
            try
            {
              JSONObject localJSONObject = new JSONObject(new String((byte[])localObject1, "UTF-8"));
              if ((localJSONObject.has("isShowInCard")) && (localJSONObject.getInt("isShowInCard") == 0)) {
                continue;
              }
              localObject3 = localJSONObject.optString("name");
              localObject1 = localObject3;
              if (localJSONObject.has("showName")) {
                if (TextUtils.isEmpty(localJSONObject.getString("showName"))) {
                  localObject1 = localObject3;
                } else {
                  localObject1 = localJSONObject.getString("showName");
                }
              }
              localDressDescriptionItem.i = ((Integer)ApolloDress.DRESS_UNIT_MAP.get(localDress.attachPart.get(0))).intValue();
              localObject3 = localObject1;
              if (localObject1 != null)
              {
                localObject3 = localObject1;
                if (((String)localObject1).length() > 5) {
                  localObject3 = ((String)localObject1).substring(0, 4);
                }
              }
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append(ApolloDress.DRESS_UNIT_DESCRIPTION_ARRAY[localDressDescriptionItem.i]);
              ((StringBuilder)localObject1).append((String)localObject3);
              localDressDescriptionItem.b = ((StringBuilder)localObject1).toString();
            }
            catch (Exception localException)
            {
              Object localObject3 = new StringBuilder();
              ((StringBuilder)localObject3).append("initTag e=");
              ((StringBuilder)localObject3).append(localException.toString());
              QLog.e("[cmshow]ApolloGuestsPresenter", 1, ((StringBuilder)localObject3).toString());
            }
            Object localObject2 = this.e.onGetDressRect((String)localDress.attachPart.get(0));
            if ((localObject2 != null) && ((((RectF)localObject2).bottom != ((RectF)localObject2).top) || (((RectF)localObject2).left != ((RectF)localObject2).right)))
            {
              localDressDescriptionItem.e = (((int)((RectF)localObject2).top + (int)((RectF)localObject2).bottom) / 2);
              localDressDescriptionItem.g = ((int)((RectF)localObject2).left);
              localDressDescriptionItem.f = ((int)((RectF)localObject2).right);
              localDressDescriptionItem.j = paramApolloDress.belongCombId;
              localDressDescriptionItem.k = paramApolloDress.combIsCollected;
              localArrayList.add(localDressDescriptionItem);
              if (QLog.isColorLevel())
              {
                localObject2 = new StringBuilder();
                ((StringBuilder)localObject2).append("item.name =");
                ((StringBuilder)localObject2).append(localDressDescriptionItem.b);
                ((StringBuilder)localObject2).append(" item.y = ");
                ((StringBuilder)localObject2).append(localDressDescriptionItem.e);
                ((StringBuilder)localObject2).append(" item.left = ");
                ((StringBuilder)localObject2).append(localDressDescriptionItem.g);
                ((StringBuilder)localObject2).append(" item.right = ");
                ((StringBuilder)localObject2).append(localDressDescriptionItem.f);
                QLog.d("[cmshow]ApolloGuestsPresenter", 2, ((StringBuilder)localObject2).toString());
              }
            }
          }
        }
      }
      if (localArrayList.size() > 4)
      {
        Collections.sort(localArrayList, new ApolloGuestsPresenter.3(this));
        k = localArrayList.size() - 1;
        while (k >= 4)
        {
          localArrayList.remove(k);
          k -= 1;
        }
      }
      Collections.sort(localArrayList);
      int m = 0;
      for (int n = 0; m < localArrayList.size(); n = k)
      {
        ((DressDescriptionItem)localArrayList.get(m)).c = n;
        ((DressDescriptionItem)localArrayList.get(m)).d = ((int)(this.i * 123.0F));
        if (n == 0)
        {
          k = 1;
        }
        else
        {
          k = n;
          if (n == 1) {
            k = 0;
          }
        }
        m += 1;
      }
      return localArrayList;
    }
    finally {}
    for (;;)
    {
      throw paramApolloDress;
    }
  }
  
  public void a()
  {
    if (this.c == null) {
      return;
    }
    Object localObject = this.h.getSharedPreferences("cmshow_zan", 0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("apollo_zan_count");
    localStringBuilder.append(this.d);
    int m = ((SharedPreferences)localObject).getInt(localStringBuilder.toString(), 0);
    localObject = String.valueOf(m);
    int k = m;
    if (m >= 99999)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(99999);
      ((StringBuilder)localObject).append("+");
      localObject = ((StringBuilder)localObject).toString();
      k = 99999;
    }
    this.b.onApprovalGet((String)localObject, k, k);
    ((ApolloExtensionHandler)this.c.getBusinessHandler(BusinessHandlerFactory.APOLLO_EXTENSION_HANDLER)).a(this.d, 256L, "myApollo");
  }
  
  public void b()
  {
    QQAppInterface localQQAppInterface = this.c;
    if (localQQAppInterface != null) {
      ((ApolloExtensionHandler)localQQAppInterface.getBusinessHandler(BusinessHandlerFactory.APOLLO_EXTENSION_HANDLER)).a(this.d, "myApollo");
    }
  }
  
  public void c()
  {
    Object localObject1 = this.c;
    if (localObject1 == null) {
      return;
    }
    localObject1 = ((ApolloDaoManagerServiceImpl)((QQAppInterface)localObject1).getRuntimeService(IApolloDaoManagerService.class, "all")).getApolloBaseInfo(this.d);
    Object localObject2 = null;
    if (localObject1 != null)
    {
      localObject1 = ((ApolloBaseInfo)localObject1).getApolloDress();
      if (localObject1 != null)
      {
        k = ((ApolloDress)localObject1).roleId;
        localObject2 = ((ApolloDress)localObject1).getDressIds();
        break label106;
      }
      ((ApolloExtensionHandler)this.c.getBusinessHandler(BusinessHandlerFactory.APOLLO_EXTENSION_HANDLER)).b(this.d);
    }
    else
    {
      ((ApolloExtensionHandler)this.c.getBusinessHandler(BusinessHandlerFactory.APOLLO_EXTENSION_HANDLER)).b(this.d);
    }
    int k = 0;
    label106:
    localObject1 = localObject2;
    if (k > 0)
    {
      localObject1 = localObject2;
      if (localObject2 != null)
      {
        localObject1 = localObject2;
        if (localObject2.length > 0)
        {
          localObject1 = localObject2;
          if (!ApolloResManagerFacade.a.a(Scene.WEB_STORE_OR_GAME).a(this.d, k, (int[])localObject2, this.c, this.j)) {
            localObject1 = ((IApolloResHelper)QRoute.api(IApolloResHelper.class)).readRoleDefaultDressIds(k);
          }
        }
      }
    }
    int m = k;
    if (k < 0) {
      m = 0;
    }
    if (localObject1 != null)
    {
      localObject2 = localObject1;
      if (localObject1.length > 0) {}
    }
    else
    {
      localObject2 = ((IApolloResHelper)QRoute.api(IApolloResHelper.class)).readRoleDefaultDressIds(m);
    }
    localObject1 = this.b;
    if (localObject1 != null) {
      ((IApolloGuestsView)localObject1).onLoadApolloInfo((int[])localObject2, m);
    }
    this.g = m;
  }
  
  public void d()
  {
    if (this.f) {
      return;
    }
    Object localObject = ((ApolloDaoManagerServiceImpl)this.c.getRuntimeService(IApolloDaoManagerService.class, "all")).getApolloBaseInfo(this.d);
    if ((localObject != null) && (this.b != null) && (this.e != null))
    {
      localObject = a(((ApolloBaseInfo)localObject).getApolloDress());
      this.b.onTagLoad((List)localObject);
    }
  }
  
  public void e()
  {
    QQAppInterface localQQAppInterface = this.c;
    if (localQQAppInterface != null) {
      localQQAppInterface.removeObserver(this.a);
    }
    this.f = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.store.ApolloGuestsPresenter
 * JD-Core Version:    0.7.0.1
 */