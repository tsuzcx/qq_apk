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
import com.tencent.mobileqq.apollo.res.api.IApolloResDownloader;
import com.tencent.mobileqq.apollo.res.api.IApolloResDownloader.OnApolloDownLoadListener;
import com.tencent.mobileqq.apollo.task.OnDressDoneListener;
import com.tencent.mobileqq.apollo.utils.api.impl.ApolloActionHelperImpl;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloTextureView;
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
  private float jdField_a_of_type_Float = 0.0F;
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  ApolloExtensionObserver jdField_a_of_type_ComTencentMobileqqApolloHandlerApolloExtensionObserver = new ApolloGuestsPresenter.1(this);
  private IApolloResDownloader.OnApolloDownLoadListener jdField_a_of_type_ComTencentMobileqqApolloResApiIApolloResDownloader$OnApolloDownLoadListener = new ApolloGuestsPresenter.2(this);
  private IApolloGuestsView jdField_a_of_type_ComTencentMobileqqApolloStoreIApolloGuestsView;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private ApolloTextureView jdField_a_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloTextureView;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean = false;
  
  public ApolloGuestsPresenter(IApolloGuestsView paramIApolloGuestsView, QQAppInterface paramQQAppInterface, Context paramContext, String paramString, ApolloTextureView paramApolloTextureView)
  {
    this.jdField_a_of_type_ComTencentMobileqqApolloStoreIApolloGuestsView = paramIApolloGuestsView;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloTextureView = paramApolloTextureView;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Float = paramContext.getResources().getDisplayMetrics().density;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqApolloHandlerApolloExtensionObserver);
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
      int i;
      while (localIterator.hasNext())
      {
        DressDescriptionItem localDressDescriptionItem = new DressDescriptionItem();
        localObject1 = (Map.Entry)localIterator.next();
        if (localObject1 != null)
        {
          i = ((Integer)((Map.Entry)localObject1).getKey()).intValue();
          localDressDescriptionItem.jdField_a_of_type_Int = i;
          ApolloDress.Dress localDress = (ApolloDress.Dress)((Map.Entry)localObject1).getValue();
          if ((localDress != null) && (localDress.attachPart != null) && (localDress.attachPart.size() != 0))
          {
            localDressDescriptionItem.g = a(localDress.tag, localDress.feeType);
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/dress/");
            ((StringBuilder)localObject1).append(i);
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
              localDressDescriptionItem.h = ((Integer)ApolloDress.DRESS_UNIT_MAP.get(localDress.attachPart.get(0))).intValue();
              localObject3 = localObject1;
              if (localObject1 != null)
              {
                localObject3 = localObject1;
                if (((String)localObject1).length() > 5) {
                  localObject3 = ((String)localObject1).substring(0, 4);
                }
              }
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append(ApolloDress.DRESS_UNIT_DESCRIPTION_ARRAY[localDressDescriptionItem.h]);
              ((StringBuilder)localObject1).append((String)localObject3);
              localDressDescriptionItem.jdField_a_of_type_JavaLangString = ((StringBuilder)localObject1).toString();
            }
            catch (Exception localException)
            {
              Object localObject3 = new StringBuilder();
              ((StringBuilder)localObject3).append("initTag e=");
              ((StringBuilder)localObject3).append(localException.toString());
              QLog.e("[cmshow]ApolloGuestsPresenter", 1, ((StringBuilder)localObject3).toString());
            }
            Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloTextureView.onGetDressRect((String)localDress.attachPart.get(0));
            if ((localObject2 != null) && ((((RectF)localObject2).bottom != ((RectF)localObject2).top) || (((RectF)localObject2).left != ((RectF)localObject2).right)))
            {
              localDressDescriptionItem.d = (((int)((RectF)localObject2).top + (int)((RectF)localObject2).bottom) / 2);
              localDressDescriptionItem.f = ((int)((RectF)localObject2).left);
              localDressDescriptionItem.e = ((int)((RectF)localObject2).right);
              localDressDescriptionItem.i = paramApolloDress.belongCombId;
              localDressDescriptionItem.j = paramApolloDress.combIsCollected;
              localArrayList.add(localDressDescriptionItem);
              if (QLog.isColorLevel())
              {
                localObject2 = new StringBuilder();
                ((StringBuilder)localObject2).append("item.name =");
                ((StringBuilder)localObject2).append(localDressDescriptionItem.jdField_a_of_type_JavaLangString);
                ((StringBuilder)localObject2).append(" item.y = ");
                ((StringBuilder)localObject2).append(localDressDescriptionItem.d);
                ((StringBuilder)localObject2).append(" item.left = ");
                ((StringBuilder)localObject2).append(localDressDescriptionItem.f);
                ((StringBuilder)localObject2).append(" item.right = ");
                ((StringBuilder)localObject2).append(localDressDescriptionItem.e);
                QLog.d("[cmshow]ApolloGuestsPresenter", 2, ((StringBuilder)localObject2).toString());
              }
            }
          }
        }
      }
      if (localArrayList.size() > 4)
      {
        Collections.sort(localArrayList, new ApolloGuestsPresenter.3(this));
        i = localArrayList.size() - 1;
        while (i >= 4)
        {
          localArrayList.remove(i);
          i -= 1;
        }
      }
      Collections.sort(localArrayList);
      int j = 0;
      for (int k = 0; j < localArrayList.size(); k = i)
      {
        ((DressDescriptionItem)localArrayList.get(j)).b = k;
        ((DressDescriptionItem)localArrayList.get(j)).c = ((int)(this.jdField_a_of_type_Float * 123.0F));
        if (k == 0)
        {
          i = 1;
        }
        else
        {
          i = k;
          if (k == 1) {
            i = 0;
          }
        }
        j += 1;
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
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return;
    }
    Object localObject = this.jdField_a_of_type_AndroidContentContext.getSharedPreferences("cmshow_zan", 0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("apollo_zan_count");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    int j = ((SharedPreferences)localObject).getInt(localStringBuilder.toString(), 0);
    localObject = String.valueOf(j);
    int i = j;
    if (j >= 99999)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(99999);
      ((StringBuilder)localObject).append("+");
      localObject = ((StringBuilder)localObject).toString();
      i = 99999;
    }
    this.jdField_a_of_type_ComTencentMobileqqApolloStoreIApolloGuestsView.onApprovalGet((String)localObject, i, i);
    ((ApolloExtensionHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.APOLLO_EXTENSION_HANDLER)).a(this.jdField_a_of_type_JavaLangString, 256L, "myApollo");
  }
  
  public void b()
  {
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (localQQAppInterface != null) {
      ((ApolloExtensionHandler)localQQAppInterface.getBusinessHandler(BusinessHandlerFactory.APOLLO_EXTENSION_HANDLER)).a(this.jdField_a_of_type_JavaLangString, "myApollo");
    }
  }
  
  public void c()
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (localObject1 == null) {
      return;
    }
    localObject1 = ((ApolloDaoManagerServiceImpl)((QQAppInterface)localObject1).getRuntimeService(IApolloDaoManagerService.class, "all")).getApolloBaseInfo(this.jdField_a_of_type_JavaLangString);
    Object localObject2 = null;
    if (localObject1 != null)
    {
      localObject1 = ((ApolloBaseInfo)localObject1).getApolloDress();
      if (localObject1 != null)
      {
        i = ((ApolloDress)localObject1).roleId;
        localObject2 = ((ApolloDress)localObject1).getDressIds();
        break label106;
      }
      ((ApolloExtensionHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.APOLLO_EXTENSION_HANDLER)).b(this.jdField_a_of_type_JavaLangString);
    }
    else
    {
      ((ApolloExtensionHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.APOLLO_EXTENSION_HANDLER)).b(this.jdField_a_of_type_JavaLangString);
    }
    int i = 0;
    label106:
    localObject1 = localObject2;
    if (i > 0)
    {
      localObject1 = localObject2;
      if (localObject2 != null)
      {
        localObject1 = localObject2;
        if (localObject2.length > 0)
        {
          localObject1 = localObject2;
          if (!ApolloActionHelperImpl.isRscValid(this.jdField_a_of_type_JavaLangString, i, (int[])localObject2, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqApolloResApiIApolloResDownloader$OnApolloDownLoadListener)) {
            localObject1 = ((IApolloResDownloader)QRoute.api(IApolloResDownloader.class)).readRoleDefaultDressIds(i);
          }
        }
      }
    }
    int j = i;
    if (i < 0) {
      j = 0;
    }
    if (localObject1 != null)
    {
      localObject2 = localObject1;
      if (localObject1.length > 0) {}
    }
    else
    {
      localObject2 = ((IApolloResDownloader)QRoute.api(IApolloResDownloader.class)).readRoleDefaultDressIds(j);
    }
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqApolloStoreIApolloGuestsView;
    if (localObject1 != null) {
      ((IApolloGuestsView)localObject1).onLoadApolloInfo((int[])localObject2, j);
    }
    this.jdField_a_of_type_Int = j;
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    Object localObject = ((ApolloDaoManagerServiceImpl)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IApolloDaoManagerService.class, "all")).getApolloBaseInfo(this.jdField_a_of_type_JavaLangString);
    if ((localObject != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloStoreIApolloGuestsView != null) && (this.jdField_a_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloTextureView != null))
    {
      localObject = a(((ApolloBaseInfo)localObject).getApolloDress());
      this.jdField_a_of_type_ComTencentMobileqqApolloStoreIApolloGuestsView.onTagLoad((List)localObject);
    }
  }
  
  public void e()
  {
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (localQQAppInterface != null) {
      localQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqApolloHandlerApolloExtensionObserver);
    }
    this.jdField_a_of_type_Boolean = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.store.ApolloGuestsPresenter
 * JD-Core Version:    0.7.0.1
 */